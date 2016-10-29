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
import org.eclipse.qvtd.pivot.schedule.AbstractDatum;
import org.eclipse.qvtd.pivot.schedule.ClassDatum;
import org.eclipse.qvtd.pivot.schedule.MappingAction;
import org.eclipse.qvtd.pivot.schedule.PropertyDatum;
import org.eclipse.qvtd.pivot.schedule.Schedule;
import org.eclipse.qvtd.pivot.schedule.ScheduleFactory;

public class QVTp2QVTg
{
	private final @NonNull RootDomainUsageAnalysis domainUsageAnalysis;
	private final @NonNull ClassRelationships classRelationships;

	private final @NonNull Schedule schedule = ScheduleFactory.eINSTANCE.createSchedule();

	// Caches
	private @NonNull Map<@NonNull TypedModel, @NonNull Map<org.eclipse.ocl.pivot.@NonNull CompleteClass, @NonNull ClassDatum>> typedModel2completeClass2classDatum = new HashMap<>();
	private @NonNull Map<@NonNull ClassDatum, @NonNull Map<@NonNull Property, @NonNull PropertyDatum>> classDatum2property2propertyDatum = new HashMap<>();

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

	public void analyzeTransformation(@NonNull Transformation pTransformation) {
		List<MappingAction> actions = schedule.getActions();
		for (@NonNull Rule pRule : ClassUtil.nullFree(pTransformation.getRule())) {
			actions.add(analyzeMapping((Mapping) pRule));
		}
	}

	private MappingAction analyzeMapping(@NonNull Mapping mapping) {
		MappingAction ma = ScheduleFactory.eINSTANCE.createMappingAction();
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
				org.eclipse.ocl.pivot.Class context = (org.eclipse.ocl.pivot.Class)type;
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

	public @NonNull ClassDatum getClassDatum(@NonNull TypedModel typedModel, org.eclipse.ocl.pivot.@NonNull Class aClass) {
		CompleteClass completeClass = classRelationships.getEnvironmentFactory().getCompleteModel().getCompleteClass(aClass);
		assert assertValidTypedModel(typedModel, aClass);
		Map<org.eclipse.ocl.pivot.@NonNull CompleteClass, @NonNull ClassDatum> completeClass2classDatums = typedModel2completeClass2classDatum.get(typedModel);
		if (completeClass2classDatums == null) {
			completeClass2classDatums = new HashMap<>();
			typedModel2completeClass2classDatum.put(typedModel, completeClass2classDatums);
		}
		ClassDatum classDatum = completeClass2classDatums.get(completeClass);
		if (classDatum == null) {
			assert assertValidTypedModel(typedModel, aClass);
			classDatum = ScheduleFactory.eINSTANCE.createClassDatum();
			classDatum.setSchedule(schedule);
			classDatum.setCompleteClass(completeClass);
			classDatum.setTypedModel(typedModel);
			if (!(aClass instanceof DataType)) {
				for (@SuppressWarnings("null") org.eclipse.ocl.pivot.@NonNull Class superClass : aClass.getSuperClasses()) {
					ClassDatum superCDatum = getClassDatum(typedModel, superClass);
					classDatum.getSuper().add(superCDatum);
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

	/*	public @NonNull Iterable<@NonNull PropertyDatum> getAllPropertyDatums(@NonNull ClassDatum classDatum) {
		Map<@NonNull Property, @NonNull PropertyDatum> property2propertyDatums = classDatum2property2propertyDatums.get(classDatum);
		if (property2propertyDatums == null) {
			property2propertyDatums = new HashMap<>();
			classDatum2property2propertyDatums.put(classDatum, property2propertyDatums);
			for (@NonNull PropertyDatum propertyDatum : getAllPropertyDatumsInternal(new HashSet<>(), new HashSet<>(), classDatum)) {
				Property property = propertyDatum.getProperty();
				assert property != null;
				PropertyDatum oldPropertyDatum = property2propertyDatums.put(property, propertyDatum);
				assert oldPropertyDatum == null;
			}
		}
		return property2propertyDatums.values();
	} */
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

	private @NonNull PropertyDatum getPropertyDatum(@NonNull TypedModel typedModel, org.eclipse.ocl.pivot.@NonNull Class context, @NonNull Property property) {
		ClassDatum classDatum = getClassDatum(typedModel, context);
		return getPropertyDatum(classDatum, property);
	}

	public @NonNull PropertyDatum getPropertyDatum(@NonNull ClassDatum classDatum, @NonNull Property property) {
		TypedModel typedModel = classDatum.getTypedModel();
		assert typedModel != null;
		org.eclipse.ocl.pivot.Class context = classDatum.getCompleteClass().getPrimaryClass();
		assert context != null;
		Iterable<@NonNull PropertyDatum> allPropertyDatums = getAllPropertyDatums(classDatum);

		Map<@NonNull Property, @NonNull PropertyDatum> property2propertyDatum = classDatum2property2propertyDatum.get(classDatum);
		if (property2propertyDatum == null) {
			property2propertyDatum = new HashMap<>();
			classDatum2property2propertyDatum.put(classDatum, property2propertyDatum);
		}
		PropertyDatum cachedPropertyDatum = property2propertyDatum.get(property);
		for (PropertyDatum propertyDatum : allPropertyDatums) {
			if (propertyDatum.getProperty().equals(property)) {
				if (cachedPropertyDatum == propertyDatum) {
					System.out.println("Consistent " + classDatum + " : " + propertyDatum);
				}
				else if (cachedPropertyDatum != null) {
					System.out.println("Inconsistent " + classDatum + " : " + cachedPropertyDatum + " / " + propertyDatum);
				}
				return propertyDatum;
			}
		}
		// If not found we create it
		PropertyDatum propertyDatum = ScheduleFactory.eINSTANCE.createPropertyDatum();
		propertyDatum.setTypedModel(typedModel);
		propertyDatum.setProperty(property);
		propertyDatum.setClassDatum(classDatum);
		if (context != property.getOwningClass()) {
			for (@SuppressWarnings("null") org.eclipse.ocl.pivot.@NonNull Class superClass : context.getSuperClasses()) {
				PropertyDatum superPropDatum = getPropertyDatum(typedModel, superClass, property);
				propertyDatum.getSuper().add(superPropDatum);
			}

		}
		PropertyDatum oldPropertyDatum = property2propertyDatum.put(property, propertyDatum);
		assert oldPropertyDatum == null;
		System.out.println("Create " + classDatum + " : " + propertyDatum);
		return propertyDatum;
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

	private @NonNull Set<@NonNull PropertyDatum> getOperationPropertyDatums(@NonNull OperationCallExp opCall, org.eclipse.ocl.pivot.@NonNull Class context,
			@NonNull Map<org.eclipse.ocl.pivot.@NonNull Class, @NonNull Set<@NonNull Operation>> type2VisitedOps,
			@NonNull Map<@NonNull Variable, @NonNull Set<org.eclipse.ocl.pivot.@NonNull Class>> variable2BoundContext) {

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
				result.addAll(getOperationPropertyDatums(op, context, type2VisitedOps));
			}
		}
		return result;
	}

	private @NonNull Set<@NonNull PropertyDatum> getOperationPropertyDatums(@NonNull Operation op, org.eclipse.ocl.pivot.@NonNull Class context, @NonNull Map<org.eclipse.ocl.pivot.@NonNull Class, @NonNull Set<@NonNull Operation>> type2VisitedOps) {

		Set<@NonNull PropertyDatum> result = new HashSet<>();
		LanguageExpression langExp = op.getBodyExpression();
		if (langExp instanceof ExpressionInOCL) {
			ExpressionInOCL expInOCL = (ExpressionInOCL) langExp;
			if (expInOCL.getOwnedBody() != null) {
				Map<@NonNull Variable, @NonNull Set<org.eclipse.ocl.pivot.@NonNull Class>> variable2BoundContext = new HashMap<>();
				Set<org.eclipse.ocl.pivot.@NonNull Class> boundContexts = new HashSet<>();
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
						for (org.eclipse.ocl.pivot.@NonNull Class newContext : getComputedContexts(navCallExp, variable2BoundContext)) {
							PropertyDatum propertyDatum = getPropertyDatum(typedModel, newContext, property);
							result.add(propertyDatum);
						}
					} else if (eObject instanceof OperationCallExp) {
						OperationCallExp opCallExp = (OperationCallExp) eObject;
						for (org.eclipse.ocl.pivot.Class newContext : getComputedContexts(opCallExp, variable2BoundContext)) {
							result.addAll(getOperationPropertyDatums(opCallExp, newContext, type2VisitedOps, variable2BoundContext));
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

		Set<@NonNull PropertyDatum> result = new HashSet<>();

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

		Set<org.eclipse.ocl.pivot.@NonNull Class> result = new HashSet<>();
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

	private @NonNull Set<org.eclipse.ocl.pivot.@NonNull Class> getAllSuperClasses(org.eclipse.ocl.pivot.@NonNull Class context) {
		return classRelationships.getAllSuperClasses(context);
	}

	private @NonNull Set<org.eclipse.ocl.pivot.@NonNull Class> getAllSubClasses(org.eclipse.ocl.pivot.@NonNull Class context) {
		return classRelationships.getAllSubClasses(context);
	}

	private @NonNull Set<org.eclipse.ocl.pivot.@NonNull Class> getAllSuperAndSubClasses(org.eclipse.ocl.pivot.@NonNull Class context) {
		Set<org.eclipse.ocl.pivot.@NonNull Class> result = new HashSet<>();
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
