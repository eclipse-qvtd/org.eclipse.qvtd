/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtp2qvts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CallExp;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.LetExp;
import org.eclipse.ocl.pivot.NavigationCallExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.ShadowExp;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcore.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcore.NavigationAssignment;
import org.eclipse.qvtd.pivot.qvtcore.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtcore.analysis.DomainUsage;
import org.eclipse.qvtd.pivot.qvtcore.analysis.DomainUsageAnalysis;
import org.eclipse.qvtd.pivot.qvtcore.analysis.RootDomainUsageAnalysis;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcoreUtil;
import org.eclipse.qvtd.pivot.schedule.AbstractDatum;
import org.eclipse.qvtd.pivot.schedule.ClassDatum;
import org.eclipse.qvtd.pivot.schedule.DataParameter;
import org.eclipse.qvtd.pivot.schedule.MappingAction;
import org.eclipse.qvtd.pivot.schedule.PropertyDatum;
import org.eclipse.qvtd.pivot.schedule.Schedule;
import org.eclipse.qvtd.pivot.schedule.ScheduleFactory;

public class QVTp2QVTg {

	public static @NonNull Iterable<@NonNull PropertyDatum> getAllPropertyDatums(@NonNull ClassDatum cDatum) {
		return getAllPropertyDatumsInternal(new HashSet<>(), new HashSet<>(), cDatum);
	}
	private static @NonNull Iterable<@NonNull PropertyDatum> getAllPropertyDatumsInternal(@NonNull Set<@NonNull ClassDatum> classDatums, @NonNull Set<@NonNull PropertyDatum> propertyDatums, @NonNull ClassDatum cDatum) {
		if (classDatums.add(cDatum)) {
			propertyDatums.addAll(ClassUtil.nullFree(cDatum.getPropertyDatums()));
		}
		for (AbstractDatum superClassDatum : ClassUtil.nullFree(cDatum.getSuper())) {
			if (superClassDatum instanceof ClassDatum) {
				getAllPropertyDatumsInternal(classDatums, propertyDatums, (ClassDatum) superClassDatum);
			}
		}
		return propertyDatums;
	}


	private final @NonNull Schedule dg= ScheduleFactory.eINSTANCE.createSchedule();
	;

	// Caches
	private Map<@NonNull TypedModel, @NonNull Map<org.eclipse.ocl.pivot.@NonNull Class, @NonNull ClassDatum>> typedModel2class2datum = new HashMap<>();

	private Map<Mapping, List<@NonNull OperationCallExp>> mapping2opCallExps = new HashMap<>();
	private Map<Mapping, List<@NonNull NavigationAssignment>> mapping2propAssigns = new HashMap<>();
	private Map<Mapping, List<@NonNull NavigationCallExp>> mapping2navCallExps = new HashMap<>();

	private final @NonNull RootDomainUsageAnalysis domainUsageAnalysis;
	private final @NonNull ClassRelationships classRelationships;

	public QVTp2QVTg(@NonNull RootDomainUsageAnalysis domainAnalysis, @NonNull ClassRelationships classRelationships) {
		this.domainUsageAnalysis = domainAnalysis;
		this.classRelationships = classRelationships;
	}

	private boolean assertValidTypedModel(@NonNull TypedModel typedModel, @NonNull Type aType) {
		Type elementType = PivotUtil.getElementalType(aType);
		if (elementType instanceof DataType) {
			assert typedModel == domainUsageAnalysis.getPrimitiveTypeModel();
		}
		else {
			assert typedModel != null;
			/* FIXME waiting for BUG 485647
			if (typedModel != domainUsageAnalysis.getPrimitiveTypeModel()) {			// Un'used' packages are primitive
				Set<org.eclipse.ocl.pivot.Package> allUsedPackages = QVTbaseUtil.getAllUsedPackages(typedModel);
				org.eclipse.ocl.pivot.Package containingPackage = PivotUtil.getContainingPackage(elementType);
				assert containingPackage != null;
				if (!Iterables.contains(allUsedPackages, containingPackage)) {
					StandardLibrary standardLibrary = classRelationships.getEnvironmentFactory().getStandardLibrary();
					assert (elementType == standardLibrary.getOclAnyType())
				    || (elementType == standardLibrary.getOclElementType())
				    || (elementType == standardLibrary.getOclVoidType());
				}
			} */
		}
		return true;
	}

	private void clearCaches() {
		typedModel2class2datum.clear();
		mapping2opCallExps.clear();
		mapping2propAssigns.clear();
		mapping2navCallExps.clear();
	}

	private void computeInitialCaches(@NonNull Transformation tx) {
		for (Rule rule : tx.getRule()) {
			Mapping mapping = (Mapping) rule;
			TreeIterator<EObject> it = mapping.eAllContents();
			while (it.hasNext()) {
				EObject eObj = it.next();
				if (eObj instanceof OperationCallExp) {
					List<@NonNull OperationCallExp> opCallExps = mapping2opCallExps.get(mapping);
					if (opCallExps == null) {
						opCallExps = new ArrayList<>();
						mapping2opCallExps.put(mapping, opCallExps);
					}
					opCallExps.add((OperationCallExp)eObj);
				} else if (eObj instanceof NavigationAssignment) {
					List<@NonNull NavigationAssignment> propAssigns = mapping2propAssigns.get(mapping);
					if (propAssigns == null) {
						propAssigns = new ArrayList<>();
						mapping2propAssigns.put(mapping, propAssigns);
					}
					propAssigns.add((NavigationAssignment)eObj);
				} else if (eObj instanceof NavigationCallExp) {
					List<@NonNull NavigationCallExp> navCallExps = mapping2navCallExps.get(mapping);
					if (navCallExps == null) {
						navCallExps = new ArrayList<>();
						mapping2navCallExps.put(mapping, navCallExps);
					}
					navCallExps.add((NavigationCallExp)eObj);
				}
			}
		}

	}

	public @NonNull Schedule transformTransformation(@NonNull Transformation pTransformation) {
		clearCaches();
		computeInitialCaches(pTransformation);
		for (@NonNull Rule pRule : ClassUtil.nullFree(pTransformation.getRule())) {
			createMappingAction((Mapping) pRule);
		}
		return dg;
	}

	protected MappingAction createMappingAction(@NonNull Mapping mapping) {

		MappingAction ma = ScheduleFactory.eINSTANCE.createMappingAction();

		ma.setSchedule(dg);
		ma.setMapping(mapping);

		for (@NonNull Variable inputVar : getInputVariables(mapping)) {
			TypedModel typedModel = getTypedModel(inputVar);
			ma.getParameters().add(createDataParameter(inputVar));
			ma.getRequisites().add(getClassDatum(typedModel, ClassUtil.nonNullState((org.eclipse.ocl.pivot.Class)inputVar.getType())));

		}

		for (@NonNull RealizedVariable outputVar : getOutputVariables(mapping)) {
			TypedModel typedModel = getTypedModel(outputVar);
			ma.getResults().add(createDataParameter(outputVar));
			ma.getProductions().add(getClassDatum(typedModel, ClassUtil.nonNullState((org.eclipse.ocl.pivot.Class)outputVar.getType())));
		}

		for (@NonNull NavigationCallExp propRead : getPropertyNavigations(mapping)){
			ma.getRequisites().add(getPropertyDatum(propRead));
		}

		for (@NonNull NavigationAssignment propWrite : getNavigationAssignments(mapping)){
			ma.getProductions().addAll(getPropertyDatum(propWrite));

		}

		for (@NonNull OperationCallExp opCall : getOperationCallExps(mapping)) {
			org.eclipse.ocl.pivot.Class context = ClassUtil.nonNullState(getContextType(opCall));
			ma.getRequisites().addAll(getPropertyDatums(opCall, context, new HashMap<>(), new HashMap<>()));
		}

		return ma;
	}

	protected DataParameter createDataParameter(@NonNull Variable variable) {
		TypedModel typedModel = getTypedModel(variable);
		DataParameter dp = ScheduleFactory.eINSTANCE.createDataParameter();
		dp.setVariable(variable);
		dp.setDatum(getClassDatum(typedModel, ClassUtil.nonNullState((org.eclipse.ocl.pivot.Class)variable.getType())));
		return dp;
	}

	protected @NonNull ClassDatum createClassDatum(@NonNull TypedModel typedModel, org.eclipse.ocl.pivot.@NonNull Class aClass) {
		assert assertValidTypedModel(typedModel, aClass);
		ClassDatum cDatum = ScheduleFactory.eINSTANCE.createClassDatum();
		cDatum.setSchedule(dg);
		cDatum.setType(aClass);
		cDatum.setTypedModel(typedModel);
		if (!(aClass instanceof DataType)) {
			for (@SuppressWarnings("null") org.eclipse.ocl.pivot.@NonNull Class superClass : aClass.getSuperClasses()) {
				ClassDatum superCDatum = getClassDatum(typedModel, superClass);
				cDatum.getSuper().add(superCDatum);
			}
		}
		return cDatum;
	}

	public @NonNull ClassDatum getClassDatum(@NonNull TypedModel typedModel, org.eclipse.ocl.pivot.@NonNull Class aClass) {
		assert assertValidTypedModel(typedModel, aClass);
		Map<org.eclipse.ocl.pivot.@NonNull Class, @NonNull ClassDatum> class2datum = typedModel2class2datum.get(typedModel);
		if (class2datum == null) {
			class2datum = new HashMap<>();
			typedModel2class2datum.put(typedModel, class2datum);
		}
		ClassDatum cDatum = class2datum.get(aClass);
		if (cDatum == null) {
			cDatum = createClassDatum(typedModel, aClass);
			class2datum.put(aClass, cDatum);
		}
		/**
		 * Following check is useful for heterogeneous checking. assertValidTypedModel should be better once BUG 485647 is fixed.
		 *
		TypedModel tmKey = null;
		for (TypedModel tm : typedModel2class2datum.keySet()) {
			Map<Type, ClassDatum> c2d = typedModel2class2datum.get(tm);
			if (c2d.containsKey(aType)) {
				if (tmKey == null) {
					tmKey = tm;
				}
				else if (!aType.getName().startsWith("Ocl") && !aType.getName().equals("EObject")) {
					System.out.println(aType +  " is both " + tmKey + " and " + tm);
					throw new IllegalStateException(aType +  " is both " + tmKey + " and " + tm);
				}
			}
		} */
		return cDatum;
	}

	protected @NonNull PropertyDatum createPropertyDatum(@NonNull TypedModel typedModel, org.eclipse.ocl.pivot.@NonNull Class context, Property property) {

		PropertyDatum pDatum = ScheduleFactory.eINSTANCE.createPropertyDatum();
		ClassDatum classDatum = getClassDatum(typedModel, context);
		pDatum.setTypedModel(classDatum.getTypedModel());
		pDatum.setProperty(property);
		pDatum.setClassDatum(classDatum);
		if (context != property.getOwningClass()) {
			for (@SuppressWarnings("null") org.eclipse.ocl.pivot.@NonNull Class superClass : context.getSuperClasses()) {
				PropertyDatum superPropDatum = getPropertyDatum(typedModel, superClass, property);
				pDatum.getSuper().add(superPropDatum);
			}

		}
		return pDatum;
	}

	protected @NonNull PropertyDatum getPropertyDatum(@NonNull TypedModel typedModel, org.eclipse.ocl.pivot.@NonNull Class context, Property property) {
		ClassDatum cDatum = getClassDatum(typedModel, context);
		for (PropertyDatum pDatum : getAllPropertyDatums(cDatum)) {
			if (pDatum.getProperty().equals(property)) {
				return pDatum;
			}
		}
		// If not found we create it
		return createPropertyDatum(typedModel, context, property);
	}

	protected @NonNull List<@NonNull Variable> getInputVariables(@NonNull Mapping mapping) {

		List<@NonNull Variable> mInputVars = new ArrayList<>();
		mInputVars.addAll(ClassUtil.nullFree(mapping.getGuardPattern().getVariable()));

		for (Domain domain : mapping.getDomain()) {
			CoreDomain cDomain = (CoreDomain) domain;
			mInputVars.addAll(ClassUtil.nullFree(cDomain.getGuardPattern().getVariable()));
		}

		// TODO what about refinements ?
		return mInputVars;
	}

	protected @NonNull List<@NonNull RealizedVariable> getOutputVariables(@NonNull Mapping mapping) {
		List<@NonNull RealizedVariable> mOutputVars = new ArrayList<>();
		mOutputVars.addAll(ClassUtil.nullFree(mapping.getBottomPattern().getRealizedVariable()));

		for (Domain domain : mapping.getDomain()) {
			CoreDomain cDomain = (CoreDomain) domain;
			mOutputVars.addAll(ClassUtil.nullFree(cDomain.getBottomPattern().getRealizedVariable()));
		}

		// TODO what about refinements ?
		return mOutputVars;
	}


	// Property datum analysis

	protected @NonNull List<@NonNull NavigationCallExp> getPropertyNavigations(@NonNull Mapping mapping) {
		List<@NonNull NavigationCallExp> navCallExps = mapping2navCallExps.get(mapping);
		return navCallExps == null ? Collections.<@NonNull NavigationCallExp>emptyList() : navCallExps;
	}

	protected @NonNull List<@NonNull NavigationAssignment> getNavigationAssignments(@NonNull Mapping mapping) {
		List<@NonNull NavigationAssignment> propAssigns = mapping2propAssigns.get(mapping);
		return propAssigns == null ? Collections.<@NonNull NavigationAssignment>emptyList() : propAssigns;
	}

	protected @NonNull List<@NonNull OperationCallExp> getOperationCallExps(@NonNull Mapping mapping) {
		List<@NonNull OperationCallExp> opCallExps = mapping2opCallExps.get(mapping);
		return opCallExps == null ? Collections.<@NonNull OperationCallExp>emptyList() : opCallExps;
	}

	protected @NonNull PropertyDatum getPropertyDatum(@NonNull NavigationCallExp navCallExp) {

		org.eclipse.ocl.pivot.Class context = ClassUtil.nonNullState((org.eclipse.ocl.pivot.Class) navCallExp.getOwnedSource().getType());
		return getPropertyDatum(navCallExp, context );
	}

	protected @NonNull PropertyDatum getPropertyDatum(@NonNull NavigationCallExp navCallExp, org.eclipse.ocl.pivot.@NonNull Class context) {
		Property property = PivotUtil.getReferredProperty(navCallExp);
		OCLExpression ownedSource = navCallExp.getOwnedSource();
		assert ownedSource != null;
		TypedModel typedModel = getTypedModel(ownedSource);
		return getPropertyDatum(typedModel, context, property);
	}

	protected @NonNull Set<@NonNull PropertyDatum> getPropertyDatum(@NonNull NavigationAssignment propAssign) {
		Set<@NonNull PropertyDatum> result = new LinkedHashSet<>();
		Property targetProp = QVTcoreUtil.getTargetProperty(propAssign);
		OCLExpression slotExpression = ClassUtil.nonNullState(propAssign.getSlotExpression());
		TypedModel typedModel = getTypedModel(slotExpression);
		PropertyDatum targetDatum = getPropertyDatum(typedModel, ClassUtil.nonNullState(slotExpression.getType().isClass()), targetProp);
		result.add(targetDatum);
		Property oppositeProp = targetProp.getOpposite();
		if (oppositeProp != null) {
			OCLExpression value = propAssign.getValue();
			assert value != null;
			DomainUsage valueUsage = getUsage(value);
			if (valueUsage == null) {
				getUsage(value);
				throw new IllegalStateException("No DomainUsage for " + value);
			}
			Type propertyType = targetProp.getType();
			if ((propertyType != null) && (propertyType.getESObject() != EcorePackage.Literals.EOBJECT)) {		// FIXME Legacy fix tolerating undeclared import of EObject
				DomainUsage propertyUsage = getUsage(propertyType);
				if (propertyUsage == null) {
					getUsage(propertyType);
					throw new IllegalStateException("No DomainUsage for " + propertyType);
				}
				valueUsage = domainUsageAnalysis.intersection(propertyUsage, valueUsage);
			}
			TypedModel oppositeTypedModel = valueUsage.getTypedModel(propAssign);
			if (oppositeTypedModel == null) {
				throw new IllegalStateException("No left/right DomainUsage commonality for \"" + propAssign + "\"");
			}
			PropertyDatum oppositeDatum = getPropertyDatum(oppositeTypedModel, ClassUtil.nonNullState(getElementClass(targetProp)), oppositeProp);
			targetDatum.setOpposite(oppositeDatum);
			result.add(oppositeDatum);
		}
		return result;
	}

	private @NonNull Set<@NonNull PropertyDatum> getPropertyDatums(@NonNull OperationCallExp opCall, org.eclipse.ocl.pivot.@NonNull Class context,
			@NonNull Map<org.eclipse.ocl.pivot.@NonNull Class, @NonNull Set<@NonNull Operation>> type2VisitedOps,
			@NonNull Map<@NonNull Variable, @NonNull Set<org.eclipse.ocl.pivot.@NonNull Class>> variable2BoundContext) {

		Set<@NonNull Operation> visitedOps = type2VisitedOps.get(context);
		if (visitedOps == null) {
			visitedOps = new HashSet<>();
			type2VisitedOps.put(context, visitedOps);
		}

		Set<@NonNull PropertyDatum> result = new LinkedHashSet<>();
		Operation op = ClassUtil.nonNullState(opCall.getReferredOperation());

		if (!visitedOps.contains(op)) {
			visitedOps.add(op);
			if (isOclContainerOp(op)) {
				for (@NonNull TypedModel typedModel : getTypedModels(context)) {
					for (org.eclipse.ocl.pivot.@NonNull Class newContext : getComputedContexts(opCall, variable2BoundContext)) {
						result.addAll(analyseOclContainerCall(typedModel, newContext));
					}
				}
				//				for (@SuppressWarnings("null") @NonNull TypedModel typedModel : getTypedModels(opCall)) {
				//					for (@SuppressWarnings("null") org.eclipse.ocl.pivot.@NonNull Class newContext : getComputedContexts(opCall, variable2BoundContext)) {
				//						result.addAll(analyseOclContainerCall(typedModel, newContext));
				//					}
				//				}
			} else {
				result.addAll(getPropertyDatums(op, context, type2VisitedOps));
			}
		}
		return result;
	}

	private @NonNull Set<@NonNull PropertyDatum> getPropertyDatums(@NonNull Operation op, org.eclipse.ocl.pivot.@NonNull Class context, @NonNull Map<org.eclipse.ocl.pivot.@NonNull Class, @NonNull Set<@NonNull Operation>> type2VisitedOps) {

		Set<@NonNull PropertyDatum> result = new LinkedHashSet<>();
		LanguageExpression langExp = op.getBodyExpression();
		if (langExp instanceof ExpressionInOCL) {
			ExpressionInOCL expInOCL = (ExpressionInOCL) langExp;
			if (expInOCL.getOwnedBody() != null) {
				Map<@NonNull Variable, @NonNull Set<org.eclipse.ocl.pivot.@NonNull Class>> variable2BoundContext = new HashMap<>();
				Set<org.eclipse.ocl.pivot.@NonNull Class> boundContexts = new LinkedHashSet<>();
				boundContexts.add(context);
				Variable ownedContext = expInOCL.getOwnedContext();
				if (ownedContext != null) {
					variable2BoundContext.put(ownedContext, boundContexts);
				}
				TreeIterator<EObject> it = expInOCL.eAllContents();
				while (it.hasNext()) {
					EObject eObject = it.next();
					if (eObject instanceof LetExp) {
						updateVariableBindings((LetExp) eObject, variable2BoundContext);
					} else if (eObject instanceof NavigationCallExp) { // FIXME OppositeCallExp ?
						NavigationCallExp navCallExp = (NavigationCallExp)eObject;
						for (org.eclipse.ocl.pivot.@NonNull Class newContext : getComputedContexts(navCallExp, variable2BoundContext)) {
							result.add(getPropertyDatum(navCallExp, newContext));
						}
					} else if (eObject instanceof OperationCallExp) {
						OperationCallExp opCallExp = (OperationCallExp) eObject;
						for (org.eclipse.ocl.pivot.Class newContext : getComputedContexts(opCallExp, variable2BoundContext)) {
							result.addAll(getPropertyDatums(opCallExp, newContext, type2VisitedOps, variable2BoundContext));
						}
					}
				}
			}
		}
		return result;
	}

	private @NonNull TypedModel getTypedModel(@NonNull Element element) {
		DomainUsage domainUsage = getUsage(element);
		if (domainUsage == null) {
			getUsage(element);
			throw new IllegalStateException("No DomainUsage for " + element);
		}
		Iterator<TypedModel> typedModels = getTypedModels(element).iterator();
		if (!typedModels.hasNext()) {
			throw new IllegalStateException("No TypedModel for " + element);
		}
		@SuppressWarnings("null") @NonNull TypedModel typedModel = typedModels.next();
		if (typedModels.hasNext()) {
			getUsage(element);
			throw new IllegalStateException("Ambiguous TypedModel: " + domainUsage + " for " + element);
		}
		return typedModel;
	}

	private @NonNull Iterable<@NonNull TypedModel> getTypedModels(@NonNull Element element) {
		DomainUsage domainUsage = getUsage(element);
		if (domainUsage == null) {
			getUsage(element);
			throw new IllegalStateException("No DomainUsage for " + element);
		}
		return domainUsage.getTypedModels();
	}

	private @Nullable DomainUsage getUsage(@NonNull Element element) {
		Operation operation = PivotUtil.getContainingOperation(element);
		if (operation != null) {
			DomainUsageAnalysis analysis = domainUsageAnalysis.getAnalysis(operation);
			return analysis.getUsage(element);
		}
		else {
			return domainUsageAnalysis.getUsage(element);
		}
	}

	private boolean isOclContainerOp(@NonNull Operation op) {
		return op.getOperationId() == domainUsageAnalysis.getOclContainerId();
		//		return "oclContainer".equals(op.getName()) && op.getOwnedParameters().isEmpty();
	}

	private @NonNull Set<@NonNull PropertyDatum> analyseOclContainerCall(@NonNull TypedModel typedModel, org.eclipse.ocl.pivot.@NonNull Class context) {

		Set<@NonNull PropertyDatum> result = new LinkedHashSet<>();

		for (org.eclipse.ocl.pivot.@NonNull Class parentClass : getContainingTypes(context)) {
			for (Property prop : parentClass.getOwnedProperties()) {
				if (prop.isIsComposite()) {
					Set<org.eclipse.ocl.pivot.Class> allSuperAndSubClasses = getAllSuperAndSubClassesIncludingSelf(context);
					if (allSuperAndSubClasses.contains(getElementClass(prop))) {
						// self.print("\tOCL Container property  for ");
						// prop.println(" : ");
						// FIXME I'm getting non-deterministic QVTs 2 Graphml transformations
						// when there are references to non-navigable (inexistent) properties
						// in .oclas. Example3: Kiama
						// For the time being, let's create the dependency on the forward
						// containment property
						//var opposite = prop.opposite;
						//result.add(opposite.getOrCreatePropertyDatum(self));
						result.add(getPropertyDatum(typedModel, parentClass, prop));
					}
				}
			}

		}
		return result;

	}


	private void updateVariableBindings(@NonNull LetExp letExp , @NonNull Map<@NonNull Variable, @NonNull Set<org.eclipse.ocl.pivot.@NonNull Class>> variable2BoundContext ) {

		Variable variable = letExp.getOwnedVariable();
		variable2BoundContext.put(variable, computeContexts(ClassUtil.nonNullState(variable.getOwnedInit()), variable2BoundContext));
	}

	// TODO cache
	private @NonNull Set<org.eclipse.ocl.pivot.@NonNull Class> computeContexts(@NonNull OCLExpression oclExp, @NonNull Map<@NonNull Variable, @NonNull Set<org.eclipse.ocl.pivot.@NonNull Class>> variable2BoundContext) {

		Set<org.eclipse.ocl.pivot.@NonNull Class> result = new LinkedHashSet<>();
		if (oclExp instanceof VariableExp) {
			VariableExp varExp = (VariableExp) oclExp;
			Set<org.eclipse.ocl.pivot.@NonNull Class> context = variable2BoundContext.get(varExp.getReferredVariable());
			if (context != null) { // FIXME is this check needed ?
				result.addAll(context);
			} else {
				result.add(ClassUtil.nonNullState(varExp.getType().isClass()));
			}
		} else if (oclExp instanceof CallExp) {
			CallExp callExp = (CallExp) oclExp;
			if (callExp instanceof OperationCallExp &&
					isOclContainerOp(ClassUtil.nonNullState(((OperationCallExp)callExp).getReferredOperation()))) {
				for (@SuppressWarnings("null") org.eclipse.ocl.pivot.@NonNull Class oclContainerOpContext : computeContexts(callExp.getOwnedSource(), variable2BoundContext)) {
					result.addAll(getContainingTypes(oclContainerOpContext));
				}
			} else {
				result.add(ClassUtil.nonNullState(callExp.getType().isClass()));
			}
		} else if (oclExp instanceof ShadowExp) {
			result.add(ClassUtil.nonNullState(((ShadowExp)oclExp).getType()));

		} else {
			throw new IllegalStateException("OCLExpression has not been considered yet");
		}
		return result;
	}

	// This is needed when analysing Property/Operation call exps so that they exploit the statically computed context
	// carried on through the analysis.
	// TODO cache
	private @NonNull Set<org.eclipse.ocl.pivot.@NonNull Class> getComputedContexts(@NonNull CallExp callExp, @NonNull Map<@NonNull Variable, @NonNull Set<org.eclipse.ocl.pivot.@NonNull Class>> variable2BoundContext) {
		OCLExpression source = ClassUtil.nonNullState(callExp.getOwnedSource());
		return computeContexts(source, variable2BoundContext);
	}
	private @NonNull Set<org.eclipse.ocl.pivot.@NonNull Class> getContainingTypes(org.eclipse.ocl.pivot.@NonNull Class aClass) {
		return classRelationships.getContainerClasses(aClass);
	}

	private org.eclipse.ocl.pivot.@Nullable Class getContextType(CallExp callExp) {
		OCLExpression ownedSource = callExp.getOwnedSource();
		if (ownedSource == null) {
			return null;
		}
		Type type = ownedSource.getType();
		if (type == null) {
			return null;			// FIXME BUG 487123 type is null for ill-formed this declarations
		}
		return type.isClass();
	}

	private @NonNull Set<org.eclipse.ocl.pivot.@NonNull Class> getAllSuperClasses(org.eclipse.ocl.pivot.@NonNull Class context) {
		return classRelationships.getAllSuperClasses(context);
	}

	//	private Set<Class> getAllSuperClassesIncludingSelf(Class context) {
	//		Set<Class> result = new LinkedHashSet<Class>();
	//		result.addAll(getAllSuperClasses(context));
	//		result.add(context);
	//		return result;
	//	}

	private @NonNull Set<org.eclipse.ocl.pivot.@NonNull Class> getAllSubClasses(org.eclipse.ocl.pivot.@NonNull Class context) {
		return classRelationships.getAllSubClasses(context);
	}

	//	private Set<Class> getAllSubClassesIncludingSelf(Class context) {
	//		Set<Class> result = new LinkedHashSet<Class>();
	//		result.addAll(getAllSubClasses(context));
	//		result.add(context);
	//		return result;
	//	}

	private @NonNull Set<org.eclipse.ocl.pivot.@NonNull Class> getAllSuperAndSubClasses(org.eclipse.ocl.pivot.@NonNull Class context) {
		Set<org.eclipse.ocl.pivot.@NonNull Class> result = new LinkedHashSet<>();
		result.addAll(getAllSuperClasses(context));
		result.addAll(getAllSubClasses(context));
		return result;
	}

	private @NonNull Set<org.eclipse.ocl.pivot.@NonNull Class> getAllSuperAndSubClassesIncludingSelf(org.eclipse.ocl.pivot.@NonNull Class context) {
		Set<org.eclipse.ocl.pivot.@NonNull Class> result = getAllSuperAndSubClasses(context);
		result.add(context);
		return result;
	}

	private org.eclipse.ocl.pivot.@Nullable Class getElementClass(@NonNull TypedElement tElement) {
		Type type = tElement.getType();
		if (type instanceof CollectionType) {
			return ((CollectionType) type).getElementType().isClass();
		} else {
			return type.isClass();
		}
	}
}
