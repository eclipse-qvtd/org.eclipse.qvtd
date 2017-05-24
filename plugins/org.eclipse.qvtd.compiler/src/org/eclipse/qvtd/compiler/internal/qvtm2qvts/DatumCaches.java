/*******************************************************************************
 * Copyright (c) 2016, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Horacio Hoyos - initial migration from Epsilon prototype
 *     E.D.Willink - simplification
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtm2qvts;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CallExp;
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
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.FeatureFilter;
import org.eclipse.ocl.pivot.utilities.TreeIterable;
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
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

import com.google.common.collect.Iterables;

/**
 * DatumCaches maintains the caches of ClassDatum and PropertyDatum that establish the inter-Mapping connectivity.
 */
public class DatumCaches
{
	protected final @NonNull ScheduleManager scheduleManager;
	protected final @NonNull RootDomainUsageAnalysis domainUsageAnalysis;
	protected final @NonNull ContainmentAnalysis containmentAnalysis;
	protected final @NonNull CompleteModel completeModel;

	// Caches
	private @NonNull Map<@NonNull TypedModel, @NonNull Map<org.eclipse.ocl.pivot.@NonNull CompleteClass, @NonNull ClassDatum>> typedModel2completeClass2classDatum = new HashMap<>();
	private @NonNull Map<@NonNull ClassDatum, @NonNull Map<@NonNull Property, @NonNull PropertyDatum>> classDatum2property2propertyDatum = new HashMap<>();

	public DatumCaches(@NonNull ScheduleManager scheduleManager) {
		this.scheduleManager = scheduleManager;
		this.domainUsageAnalysis = scheduleManager.getDomainAnalysis();
		EnvironmentFactory environmentFactory = scheduleManager.getEnvironmentFactory();
		this.containmentAnalysis = new ContainmentAnalysis(environmentFactory);
		this.completeModel = environmentFactory.getCompleteModel();
	}

	private @NonNull Set<@NonNull PropertyDatum> analyseOclContainerCall(@NonNull TypedModel typedModel, @NonNull CompleteClass context) {
		InheritanceAnalysis inheritanceAnalysis = containmentAnalysis.getInheritanceAnalysis();
		Set<@NonNull PropertyDatum> result = new HashSet<>();
		for (@NonNull CompleteClass parentClass : containmentAnalysis.getContainerClasses(context)) {
			for (@NonNull Property prop : parentClass.getProperties(FeatureFilter.SELECT_NON_STATIC)) {
				if (prop.isIsComposite()) {
					Set<@NonNull CompleteClass> allSuperAndSubClasses = inheritanceAnalysis.getAllSuperAndSelfAndSubClasses(context);
					CompleteClass elementClass = getElementClass(prop);
					if (allSuperAndSubClasses.contains(elementClass)) {
						result.add(getPropertyDatum(typedModel, parentClass, prop));
					}
				}
			}

		}
		return result;

	}

	public void analyzeTransformation(@NonNull Transformation transformation) {
		for (@NonNull Rule rule : QVTcoreUtil.getRule(transformation)) {
			analyzeMapping((Mapping) rule);
		}
	}

	private void analyzeMapping(@NonNull Mapping mapping) {
		MappingAction mappingAction = QVTscheduleFactory.eINSTANCE.createMappingAction();
		mappingAction.setReferredMapping(mapping);
		mappingAction.setOwningScheduleModel(scheduleManager.getScheduleModel());
		List<@NonNull AbstractDatum> productions = QVTscheduleUtil.Internal.getProducedDatumsList(mappingAction);
		List<@NonNull AbstractDatum> requisites = QVTscheduleUtil.Internal.getRequiredDatumsList(mappingAction);
		for (@NonNull EObject eObject : new TreeIterable(mapping, true)) {
			if (eObject instanceof GuardPattern) {
				for (@NonNull Variable inputVar : QVTcoreUtil.getOwnedVariables((GuardPattern)eObject)) {
					TypedModel typedModel = getTypedModel(inputVar);
					requisites.add(getClassDatum(typedModel, QVTcoreUtil.getClass(inputVar)));
				}
			}
			else if (eObject instanceof RealizedVariable) {
				RealizedVariable outputVar = (RealizedVariable) eObject;
				TypedModel typedModel = getTypedModel(outputVar);
				productions.add(getClassDatum(typedModel, QVTcoreUtil.getClass(outputVar)));
			}
			else if (eObject instanceof OperationCallExp) {
				OperationCallExp opCall = (OperationCallExp)eObject;
				OCLExpression ownedSource = QVTcoreUtil.getOwnedSource(opCall);
				Type type = QVTcoreUtil.getType(ownedSource);
				CompleteClass context = completeModel.getCompleteClass(type);
				requisites.addAll(getOperationPropertyDatums(opCall, context, new HashMap<>(), new HashMap<>()));
			}
			else if (eObject instanceof NavigationAssignment) {
				productions.addAll(getAssignedPropertyDatums((NavigationAssignment)eObject));
			}
			else if (eObject instanceof NavigationCallExp) {
				NavigationCallExp navigationCallExp = (NavigationCallExp)eObject;
				OCLExpression source = QVTcoreUtil.getOwnedSource(navigationCallExp);
				TypedModel typedModel = getTypedModel(source);
				Property property = QVTcoreUtil.getReferredProperty(navigationCallExp);
				org.eclipse.ocl.pivot.Class context = QVTcoreUtil.getClass(source);
				PropertyDatum propertyDatum = getPropertyDatum(typedModel, context, property);
				requisites.add(propertyDatum);
			}
		}
	}

	private boolean assertValidTypedModel(@NonNull TypedModel typedModel, @NonNull CompleteClass completeClass) {
		org.eclipse.ocl.pivot.@NonNull Class aType = completeClass.getPrimaryClass();
		Type elementType = QVTcoreUtil.getElementalType(aType);
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
				result.add(completeModel.getCompleteClass(QVTcoreUtil.getType(varExp)));
			}
		} else if (oclExp instanceof CallExp) {
			CallExp callExp = (CallExp) oclExp;
			if (callExp instanceof OperationCallExp &&
					isOclContainerOp(QVTcoreUtil.getReferredOperation(callExp))) {
				OCLExpression ownedSource = QVTcoreUtil.getOwnedSource(callExp);
				for (@NonNull CompleteClass oclContainerOpContext : computeContexts(ownedSource, variable2BoundContext)) {
					Iterables.addAll(result, containmentAnalysis.getContainerClasses(oclContainerOpContext));
				}
			} else {
				result.add(completeModel.getCompleteClass(QVTcoreUtil.getType(callExp)));
			}
		} else if (oclExp instanceof ShadowExp) {
			result.add(completeModel.getCompleteClass(QVTcoreUtil.getType(oclExp)));

		} else {
			throw new IllegalStateException("OCLExpression has not been considered yet");
		}
		return result;
	}

	public @NonNull Iterable<@NonNull PropertyDatum> getAllPropertyDatums(@NonNull ClassDatum classDatum) {
		return getAllPropertyDatumsInternal(new HashSet<>(), new HashSet<>(), classDatum);
	}

	private @NonNull Iterable<@NonNull PropertyDatum> getAllPropertyDatumsInternal(@NonNull Set<@NonNull ClassDatum> classDatums, @NonNull Set<@NonNull PropertyDatum> propertyDatums, @NonNull ClassDatum cDatum) {
		if (classDatums.add(cDatum)) {
			Iterables.addAll(propertyDatums, QVTscheduleUtil.getOwnedPropertyDatums(cDatum));
		}
		for (@NonNull ClassDatum superClassDatum : QVTscheduleUtil.getSuperClassDatums(cDatum)) {
			getAllPropertyDatumsInternal(classDatums, propertyDatums, superClassDatum);
		}
		return propertyDatums;
	}

	// Property datum analysis

	private @NonNull Set<@NonNull PropertyDatum> getAssignedPropertyDatums(@NonNull NavigationAssignment propAssign) {
		Set<@NonNull PropertyDatum> result = new HashSet<>();
		Property targetProp = QVTcoreUtil.getTargetProperty(propAssign);
		OCLExpression slotExpression = QVTcoreUtil.getSlotExpression(propAssign);
		TypedModel typedModel = getTypedModel(slotExpression);
		PropertyDatum targetDatum = getPropertyDatum(typedModel, QVTcoreUtil.getClass(slotExpression), targetProp);
		result.add(targetDatum);
		Property oppositeProp = targetProp.getOpposite();
		if (oppositeProp != null) {
			OCLExpression value = QVTcoreUtil.getValue(propAssign);
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
			PropertyDatum oppositeDatum = getPropertyDatum(oppositeTypedModel, getElementClass(targetProp), oppositeProp);
			targetDatum.setOpposite(oppositeDatum);
			result.add(oppositeDatum);
		}
		return result;
	}

	public @NonNull ClassDatum getClassDatum(@NonNull TypedModel typedModel, org.eclipse.ocl.pivot.@NonNull Class asClass) {
		CompleteClass completeClass = completeModel.getCompleteClass(asClass);
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
			classDatum.setOwningScheduleModel(scheduleManager.getScheduleModel());
			classDatum.setCompleteClass(completeClass);
			classDatum.setReferredClass(completeClass.getPrimaryClass());
			classDatum.setReferredTypedModel(typedModel);
			org.eclipse.ocl.pivot.@NonNull Class aClass = completeClass.getPrimaryClass();
			if (!(aClass instanceof DataType)) {
				List<ClassDatum> superClassDatums = classDatum.getSuperClassDatums();
				for (@NonNull CompleteClass superCompleteClass : completeClass.getProperSuperCompleteClasses()) {
					DomainUsage superUsage = getUsage(superCompleteClass.getPrimaryClass());
					if (superUsage != null) {		// Ignore superClassDatum with differet typedModels (OclAny)
						Iterable<@NonNull TypedModel> superTypedModels = superUsage.getTypedModels();
						if ((Iterables.size(superTypedModels) == 1) && Iterables.contains(superTypedModels, typedModel)) {
							ClassDatum superClassDatum = getClassDatum(typedModel, superCompleteClass);
							superClassDatums.add(superClassDatum);
						}
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
		OCLExpression source = QVTcoreUtil.getOwnedSource(callExp);
		return computeContexts(source, variable2BoundContext);
	}

	public @NonNull ContainmentAnalysis getContainmentAnalysis() {
		return containmentAnalysis;
	}

	private @NonNull CompleteClass getElementClass(@NonNull TypedElement typedElement) {
		Type type = QVTcoreUtil.getElementalType(QVTcoreUtil.getType(typedElement));
		return completeModel.getCompleteClass(type);
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
		Operation op = QVTcoreUtil.getReferredOperation(opCall);

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

	private @NonNull Set<@NonNull PropertyDatum> getOperationPropertyDatums(@NonNull Operation operation, @NonNull CompleteClass context, @NonNull Map<@NonNull CompleteClass, @NonNull Set<@NonNull Operation>> type2VisitedOps) {
		Set<@NonNull PropertyDatum> result = new HashSet<>();
		LanguageExpression langExp = operation.getBodyExpression();
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
				for (@NonNull EObject eObject : new TreeIterable(expInOCL, true)) {
					if (eObject instanceof LetExp) {
						updateVariableBindings((LetExp) eObject, variable2BoundContext);
					} else if (eObject instanceof NavigationCallExp) {
						NavigationCallExp navCallExp = (NavigationCallExp)eObject;
						Property property = QVTcoreUtil.getReferredProperty(navCallExp);
						OCLExpression ownedSource = QVTcoreUtil.getOwnedSource(navCallExp);
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
			if (propertyDatum.getReferredProperty().equals(property)) {
				return propertyDatum;
			}
		}
		// If not found we create it
		TypedModel typedModel = QVTscheduleUtil.getReferredTypedModel(classDatum);
		CompleteClass targetCompleteClass = classDatum.getCompleteClass();
		org.eclipse.ocl.pivot.Class owningClass = QVTcoreUtil.getOwningClass(property);
		CompleteClass hostCompleteClass = completeModel.getCompleteClass(owningClass);
		PropertyDatum propertyDatum = QVTscheduleFactory.eINSTANCE.createPropertyDatum();
		propertyDatum.setReferredTypedModel(typedModel);
		propertyDatum.setReferredProperty(property);
		propertyDatum.setOwningClassDatum(classDatum);
		assert targetCompleteClass.conformsTo(hostCompleteClass);
		for (@NonNull CompleteClass superCompleteClass : targetCompleteClass.getSuperCompleteClasses()) {
			if (superCompleteClass.conformsTo(hostCompleteClass)) {
				PropertyDatum superPropDatum = getPropertyDatum(typedModel, superCompleteClass, property);
				propertyDatum.getSuperPropertyDatums().add(superPropDatum);
			}
		}
		PropertyDatum oldPropertyDatum = property2propertyDatum.put(property, propertyDatum);
		assert oldPropertyDatum == null;
		return propertyDatum;
	}

	public @NonNull PropertyDatum getSuccessPropertyDatum(@NonNull Property successProperty) {  // FIXME Could this be more regular ?? <<success>> in the QVTm ??
		org.eclipse.ocl.pivot.Class owningClass = QVTcoreUtil.getOwningClass(successProperty);
		TypedModel typedModel = getTypedModel(owningClass);
		return getPropertyDatum(typedModel, owningClass, successProperty);
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
		Operation operation = QVTcoreUtil.getContainingOperation(element);
		if (operation != null) {
			DomainUsageAnalysis analysis = domainUsageAnalysis.getAnalysis(operation);
			return analysis.getUsage(element);
		}
		else {
			return domainUsageAnalysis.getUsage(element);
		}
	}

	private boolean isOclContainerOp(@NonNull Operation operation) {
		return operation.getOperationId() == domainUsageAnalysis.getOclContainerId();
		//		return "oclContainer".equals(op.getName()) && op.getOwnedParameters().isEmpty();
	}

	private void updateVariableBindings(@NonNull LetExp letExp, @NonNull Map<@NonNull Variable, @NonNull Set<@NonNull CompleteClass>> variable2BoundContext ) {
		Variable variable = QVTcoreUtil.getOwnedVariable(letExp);
		variable2BoundContext.put(variable, computeContexts(QVTcoreUtil.getOwnedInit(variable), variable2BoundContext));
	}
}
