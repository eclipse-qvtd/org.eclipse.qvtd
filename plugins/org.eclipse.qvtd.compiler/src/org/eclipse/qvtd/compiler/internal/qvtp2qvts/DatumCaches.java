/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Horacio Hoyos - initial migration from Epsilon prototype
 *     E.D.Willink - simplification
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtp2qvts;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
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
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.CompleteModel;
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
import org.eclipse.ocl.pivot.utilities.FeatureFilter;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcore.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcore.NavigationAssignment;
import org.eclipse.qvtd.pivot.qvtcore.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtcore.analysis.DomainUsage;
import org.eclipse.qvtd.pivot.qvtcore.analysis.DomainUsageAnalysis;
import org.eclipse.qvtd.pivot.qvtcore.analysis.RootDomainUsageAnalysis;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcoreUtil;
import org.eclipse.qvtd.pivot.qvtschedule.AbstractDatum;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.MappingAction;
import org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum;
import org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleFactory;
import com.google.common.collect.Iterables;

/**
 * DatumCaches maintains the caches of ClassDatum and PropertyDatum that establish the inter-Mapping connectivity.
 */
public class DatumCaches
{
	protected final @NonNull RootDomainUsageAnalysis domainUsageAnalysis;
	protected final @NonNull ContainmentAnalysis containmentAnalysis;
	protected final @NonNull CompleteModel completeModel;

	// Caches
	private @NonNull Map<@NonNull TypedModel, @NonNull Map<org.eclipse.ocl.pivot.@NonNull CompleteClass, @NonNull ClassDatum>> typedModel2completeClass2classDatum = new HashMap<>();
	private @NonNull Map<@NonNull ClassDatum, @NonNull Map<@NonNull Property, @NonNull PropertyDatum>> classDatum2property2propertyDatum = new HashMap<>();

	public DatumCaches(@NonNull RootDomainUsageAnalysis domainAnalysis) {
		this.domainUsageAnalysis = domainAnalysis;
		this.containmentAnalysis = new ContainmentAnalysis(domainAnalysis.getEnvironmentFactory());
		this.completeModel = domainAnalysis.getEnvironmentFactory().getCompleteModel();
	}

	private @NonNull Set<@NonNull PropertyDatum> analyseOclContainerCall(@NonNull TypedModel typedModel, @NonNull CompleteClass context) {
		InheritanceAnalysis inheritanceAnalysis = containmentAnalysis.getInheritanceAnalysis();
		Set<@NonNull PropertyDatum> result = new HashSet<>();
		for (@NonNull CompleteClass parentClass : containmentAnalysis.getContainerClasses(context)) {
			for (Property prop : parentClass.getProperties(FeatureFilter.SELECT_NON_STATIC)) {
				if (prop.isIsComposite()) {
					Set<@NonNull CompleteClass> allSuperAndSubClasses = inheritanceAnalysis.getAllSuperAndSelfAndSubClasses(context);
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

	public void analyzeTransformation(@NonNull Transformation pTransformation) {
		//		List<MappingAction> actions = schedule.getActions();
		for (@NonNull Rule pRule : ClassUtil.nullFree(pTransformation.getRule())) {
			@SuppressWarnings("unused")
			MappingAction mappingAction = analyzeMapping((Mapping) pRule);
			//			actions.add(mappingAction);
		}
	}

	private MappingAction analyzeMapping(@NonNull Mapping mapping) {
		MappingAction ma = QVTscheduleFactory.eINSTANCE.createMappingAction();
		ma.setMapping(mapping);

		List<AbstractDatum> productions = ma.getProductions();
		List<AbstractDatum> requisites = ma.getRequisites();
		TreeIterator<EObject> it = mapping.eAllContents();
		while (it.hasNext()) {
			EObject eObj = it.next();
			if (eObj instanceof GuardPattern) {
				for (@NonNull Variable inputVar : ClassUtil.nullFree(((GuardPattern)eObj).getVariable())) {
					TypedModel typedModel = getTypedModel(inputVar);
					requisites.add(getClassDatum(typedModel, ClassUtil.nonNullState((org.eclipse.ocl.pivot.Class)inputVar.getType())));
				}
			}
			if (eObj instanceof RealizedVariable) {
				RealizedVariable outputVar = (RealizedVariable) eObj;
				TypedModel typedModel = getTypedModel(outputVar);
				productions.add(getClassDatum(typedModel, ClassUtil.nonNullState((org.eclipse.ocl.pivot.Class)outputVar.getType())));
			}
			else if (eObj instanceof OperationCallExp) {
				OperationCallExp opCall = (OperationCallExp)eObj;
				OCLExpression ownedSource = opCall.getOwnedSource();
				assert ownedSource != null;
				Type type = ownedSource.getType();
				assert type != null;
				CompleteClass context = completeModel.getCompleteClass(type);
				requisites.addAll(getOperationPropertyDatums(opCall, context, new HashMap<>(), new HashMap<>()));
			}
			else if (eObj instanceof NavigationAssignment) {
				productions.addAll(getAssignedPropertyDatums((NavigationAssignment)eObj));
			}
			else if (eObj instanceof NavigationCallExp) {
				NavigationCallExp navigationCallExp = (NavigationCallExp)eObj;
				OCLExpression source = navigationCallExp.getOwnedSource();
				assert source != null;
				TypedModel typedModel = getTypedModel(source);
				Property property = PivotUtil.getReferredProperty(navigationCallExp);
				org.eclipse.ocl.pivot.Class context = ClassUtil.nonNullState((org.eclipse.ocl.pivot.Class) source.getType());
				PropertyDatum propertyDatum = getPropertyDatum(typedModel, context, property);
				requisites.add(propertyDatum);
			}
		}
		return ma;
	}

	private boolean assertValidTypedModel(@NonNull TypedModel typedModel, @NonNull CompleteClass completeClass) {
		org.eclipse.ocl.pivot.@NonNull Class aType = completeClass.getPrimaryClass();
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

	// TODO cache
	private @NonNull Set<@NonNull CompleteClass> computeContexts(@NonNull OCLExpression oclExp, @NonNull Map<@NonNull Variable, @NonNull Set<@NonNull CompleteClass>> variable2BoundContext) {

		Set<@NonNull CompleteClass> result = new HashSet<>();
		if (oclExp instanceof VariableExp) {
			VariableExp varExp = (VariableExp) oclExp;
			Set<@NonNull CompleteClass> context = variable2BoundContext.get(varExp.getReferredVariable());
			if (context != null) { // FIXME is this check needed ?
				result.addAll(context);
			} else {
				result.add(completeModel.getCompleteClass(ClassUtil.nonNullState(varExp.getType())));
			}
		} else if (oclExp instanceof CallExp) {
			CallExp callExp = (CallExp) oclExp;
			if (callExp instanceof OperationCallExp &&
					isOclContainerOp(ClassUtil.nonNullState(((OperationCallExp)callExp).getReferredOperation()))) {
				OCLExpression ownedSource = callExp.getOwnedSource();
				assert ownedSource != null;
				for (@NonNull CompleteClass oclContainerOpContext : computeContexts(ownedSource, variable2BoundContext)) {
					Iterables.addAll(result, containmentAnalysis.getContainerClasses(oclContainerOpContext));
				}
			} else {
				result.add(completeModel.getCompleteClass(ClassUtil.nonNullState(callExp.getType())));
			}
		} else if (oclExp instanceof ShadowExp) {
			result.add(completeModel.getCompleteClass(ClassUtil.nonNullState(((ShadowExp)oclExp).getType())));

		} else {
			throw new IllegalStateException("OCLExpression has not been considered yet");
		}
		return result;
	}

	public @NonNull Iterable<@NonNull PropertyDatum> getAllPropertyDatums(@NonNull ClassDatum cDatum) {
		return getAllPropertyDatumsInternal(new HashSet<>(), new HashSet<>(), cDatum);
	}

	private @NonNull Iterable<@NonNull PropertyDatum> getAllPropertyDatumsInternal(@NonNull Set<@NonNull ClassDatum> classDatums, @NonNull Set<@NonNull PropertyDatum> propertyDatums, @NonNull ClassDatum cDatum) {
		if (classDatums.add(cDatum)) {
			propertyDatums.addAll(ClassUtil.nullFree(cDatum.getPropertyDatums()));
		}
		for (@NonNull ClassDatum superClassDatum : ClassUtil.nullFree(cDatum.getSuper())) {
			getAllPropertyDatumsInternal(classDatums, propertyDatums, superClassDatum);
		}
		return propertyDatums;
	}

	// Property datum analysis

	private @NonNull Set<@NonNull PropertyDatum> getAssignedPropertyDatums(@NonNull NavigationAssignment propAssign) {
		Set<@NonNull PropertyDatum> result = new HashSet<>();
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

	public @NonNull ClassDatum getClassDatum(@NonNull TypedModel typedModel, org.eclipse.ocl.pivot.@NonNull Class aClass) {
		CompleteClass completeClass = completeModel.getCompleteClass(aClass);
		return getClassDatum(typedModel, completeClass);
	}

	public @NonNull ClassDatum getClassDatum(@NonNull TypedModel typedModel, @NonNull CompleteClass completeClass) {
		assert assertValidTypedModel(typedModel, completeClass);
		Map<org.eclipse.ocl.pivot.@NonNull CompleteClass, @NonNull ClassDatum> completeClass2classDatums = typedModel2completeClass2classDatum.get(typedModel);
		if (completeClass2classDatums == null) {
			completeClass2classDatums = new HashMap<>();
			typedModel2completeClass2classDatum.put(typedModel, completeClass2classDatums);
		}
		ClassDatum classDatum = completeClass2classDatums.get(completeClass);
		if (classDatum == null) {
			classDatum = QVTscheduleFactory.eINSTANCE.createClassDatum();
			classDatum.setCompleteClass(completeClass);
			classDatum.setTypedModel(typedModel);
			org.eclipse.ocl.pivot.@NonNull Class aClass = completeClass.getPrimaryClass();
			if (!(aClass instanceof DataType)) {
				List<ClassDatum> superClassDatums = classDatum.getSuper();
				for (@NonNull CompleteClass superCompleteClass : completeClass.getSuperCompleteClasses()) {
					if (superCompleteClass != completeClass) {		// FIXME Why is OclAny its own superClass ?
						ClassDatum superClassDatum = getClassDatum(typedModel, superCompleteClass);
						superClassDatums.add(superClassDatum);
					}
				}
			}
			completeClass2classDatums.put(completeClass, classDatum);
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
		return classDatum;
	}

	// Property datum analysis

	// This is needed when analysing Property/Operation call exps so that they exploit the statically computed context
	// carried on through the analysis.
	// TODO cache
	private @NonNull Set<@NonNull CompleteClass> getComputedContexts(@NonNull CallExp callExp, @NonNull Map<@NonNull Variable, @NonNull Set<@NonNull CompleteClass>> variable2BoundContext) {
		OCLExpression source = ClassUtil.nonNullState(callExp.getOwnedSource());
		return computeContexts(source, variable2BoundContext);
	}

	public @NonNull ContainmentAnalysis getContainmentAnalysis() {
		return containmentAnalysis;
	}

	private org.eclipse.ocl.pivot.@Nullable Class getElementClass(@NonNull TypedElement tElement) {
		Type type = tElement.getType();
		if (type instanceof CollectionType) {
			return ((CollectionType) type).getElementType().isClass();
		} else {
			return type.isClass();
		}
	}

	private @NonNull Set<@NonNull PropertyDatum> getOperationPropertyDatums(@NonNull OperationCallExp opCall, @NonNull CompleteClass context,
			@NonNull Map<@NonNull CompleteClass, @NonNull Set<@NonNull Operation>> type2VisitedOps,
			@NonNull Map<@NonNull Variable, @NonNull Set<@NonNull CompleteClass>> variable2BoundContext) {

		Set<@NonNull Operation> visitedOps = type2VisitedOps.get(context);
		if (visitedOps == null) {
			visitedOps = new HashSet<>();
			type2VisitedOps.put(context, visitedOps);
		}

		Set<@NonNull PropertyDatum> result = new HashSet<>();
		Operation op = ClassUtil.nonNullState(opCall.getReferredOperation());

		if (!visitedOps.contains(op)) {
			visitedOps.add(op);
			if (isOclContainerOp(op)) {
				for (@NonNull TypedModel typedModel : getTypedModels(context.getPrimaryClass())) {
					for (@NonNull CompleteClass newContext : getComputedContexts(opCall, variable2BoundContext)) {
						result.addAll(analyseOclContainerCall(typedModel, newContext));
					}
				}
				//				for (@SuppressWarnings("null") @NonNull TypedModel typedModel : getTypedModels(opCall)) {
				//					for (@SuppressWarnings("null") org.eclipse.ocl.pivot.@NonNull Class newContext : getComputedContexts(opCall, variable2BoundContext)) {
				//						result.addAll(analyseOclContainerCall(typedModel, newContext));
				//					}
				//				}
			} else {
				result.addAll(getOperationPropertyDatums(op, context, type2VisitedOps));
			}
		}
		return result;
	}

	// Property datum analysis

	private @NonNull Set<@NonNull PropertyDatum> getOperationPropertyDatums(@NonNull Operation op, @NonNull CompleteClass context, @NonNull Map<@NonNull CompleteClass, @NonNull Set<@NonNull Operation>> type2VisitedOps) {

		Set<@NonNull PropertyDatum> result = new HashSet<>();
		LanguageExpression langExp = op.getBodyExpression();
		if (langExp instanceof ExpressionInOCL) {
			ExpressionInOCL expInOCL = (ExpressionInOCL) langExp;
			if (expInOCL.getOwnedBody() != null) {
				Map<@NonNull Variable, @NonNull Set<@NonNull CompleteClass>> variable2BoundContext = new HashMap<>();
				Set<@NonNull CompleteClass> boundContexts = new HashSet<>();
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
						Property property = PivotUtil.getReferredProperty(navCallExp);
						OCLExpression ownedSource = navCallExp.getOwnedSource();
						assert ownedSource != null;
						TypedModel typedModel = getTypedModel(ownedSource);
						for (@NonNull CompleteClass newContext : getComputedContexts(navCallExp, variable2BoundContext)) {
							PropertyDatum propertyDatum = getPropertyDatum(typedModel, newContext, property);
							result.add(propertyDatum);
						}
					} else if (eObject instanceof OperationCallExp) {
						OperationCallExp opCallExp = (OperationCallExp) eObject;
						for (@NonNull CompleteClass newContext : getComputedContexts(opCallExp, variable2BoundContext)) {
							result.addAll(getOperationPropertyDatums(opCallExp, newContext, type2VisitedOps, variable2BoundContext));
						}
					}
				}
			}
		}
		return result;
	}

	private @NonNull PropertyDatum getPropertyDatum(@NonNull TypedModel typedModel, org.eclipse.ocl.pivot.@NonNull Class context, @NonNull Property property) {
		CompleteClass completeClass = completeModel.getCompleteClass(context);
		return getPropertyDatum(typedModel, completeClass, property);
	}

	private @NonNull PropertyDatum getPropertyDatum(@NonNull TypedModel typedModel, @NonNull CompleteClass completeClass, @NonNull Property property) {
		ClassDatum classDatum = getClassDatum(typedModel, completeClass);
		return getPropertyDatum(classDatum, property);
	}

	public @NonNull PropertyDatum getPropertyDatum(@NonNull ClassDatum classDatum, @NonNull Property property) {
		Iterable<@NonNull PropertyDatum> allPropertyDatums = getAllPropertyDatums(classDatum);

		Map<@NonNull Property, @NonNull PropertyDatum> property2propertyDatum = classDatum2property2propertyDatum.get(classDatum);
		if (property2propertyDatum == null) {
			property2propertyDatum = new HashMap<>();
			classDatum2property2propertyDatum.put(classDatum, property2propertyDatum);
		}
		PropertyDatum cachedPropertyDatum = property2propertyDatum.get(property);
		if (cachedPropertyDatum != null) {
			return cachedPropertyDatum;
		}
		for (PropertyDatum propertyDatum : allPropertyDatums) {
			if (propertyDatum.getProperty().equals(property)) {
				return propertyDatum;
			}
		}
		// If not found we create it
		TypedModel typedModel = classDatum.getTypedModel();
		assert typedModel != null;
		CompleteClass targetCompleteClass = classDatum.getCompleteClass();
		org.eclipse.ocl.pivot.Class owningClass = PivotUtil.getOwningClass(property);
		CompleteClass hostCompleteClass = completeModel.getCompleteClass(owningClass);
		PropertyDatum propertyDatum = QVTscheduleFactory.eINSTANCE.createPropertyDatum();
		propertyDatum.setTypedModel(typedModel);
		propertyDatum.setProperty(property);
		propertyDatum.setClassDatum(classDatum);
		assert targetCompleteClass.conformsTo(hostCompleteClass);
		for (@NonNull CompleteClass superCompleteClass : targetCompleteClass.getSuperCompleteClasses()) {
			if (superCompleteClass.conformsTo(hostCompleteClass)) {
				PropertyDatum superPropDatum = getPropertyDatum(typedModel, superCompleteClass, property);
				propertyDatum.getSuper().add(superPropDatum);
			}
		}
		PropertyDatum oldPropertyDatum = property2propertyDatum.put(property, propertyDatum);
		assert oldPropertyDatum == null;
		return propertyDatum;
	}

	// Property datum analysis

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

	private void updateVariableBindings(@NonNull LetExp letExp, @NonNull Map<@NonNull Variable, @NonNull Set<@NonNull CompleteClass>> variable2BoundContext ) {

		Variable variable = letExp.getOwnedVariable();
		variable2BoundContext.put(variable, computeContexts(ClassUtil.nonNullState(variable.getOwnedInit()), variable2BoundContext));
	}
}
