/*******************************************************************************
 * Copyright (c) 2016, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Horacio Hoyos - initial migration from Epsilon prototype
 *     E.D.Willink - simplification
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtb2qvts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CallExp;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.CompleteModel;
import org.eclipse.ocl.pivot.CompletePackage;
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
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.TreeIterable;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtcore.analysis.DomainUsageAnalysis;
import org.eclipse.qvtd.pivot.qvtcore.analysis.RootDomainUsageAnalysis;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.CollectionClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum;
import org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleFactory;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.DomainUsage;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

import com.google.common.collect.Iterables;

/**
 * DatumCaches maintains the caches of ClassDatum and PropertyDatum that establish the inter-Mapping connectivity.
 */
public class DatumCaches
{
	protected final @NonNull ScheduleManager scheduleManager;
	protected final @NonNull Property oclContainerProperty;
	protected final @NonNull RootDomainUsageAnalysis domainUsageAnalysis;
	protected final @NonNull ContainmentAnalysis containmentAnalysis;
	protected final @NonNull CompleteModel completeModel;

	// Caches
	/**
	 * The per-TypedModel mappings from a CompleteClass to its corresponding ClassDatum in that TypedModel.
	 */
	private @NonNull Map<@NonNull TypedModel, @NonNull Map<@NonNull CompleteClass, @NonNull ClassDatum>> typedModel2completeClass2classDatum = new HashMap<>();
	private @NonNull Map<@NonNull TypedModel, @NonNull Map<@NonNull Set<@NonNull CompleteClass>, @NonNull ClassDatum>> typedModel2completeClasses2classDatum = new HashMap<>();

	/**
	 * The per-ClassDatum mapping from a Property to its corresponding PropertyDatum.
	 * FIXME to what extent are inherited properties entered?
	 */
	private @NonNull Map<@NonNull ClassDatum, @NonNull Map<@NonNull Property, @NonNull PropertyDatum>> classDatum2property2propertyDatum = new HashMap<>();

	/**
	 * The per-ClassDatum mapping from the oclContainer Property to all possible containing PropertyDatums.
	 */
	private @NonNull Map<@NonNull ClassDatum, @NonNull List<@NonNull PropertyDatum>> classDatum2oclContainerPropertyDatums = new HashMap<>();

	protected DatumCaches(@NonNull ScheduleManager scheduleManager) {
		this.scheduleManager = scheduleManager;
		this.oclContainerProperty = scheduleManager.getStandardLibraryHelper().getOclContainerProperty();
		this.domainUsageAnalysis = scheduleManager.getDomainUsageAnalysis();
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

	public void analyzeCompletePackage(@NonNull TypedModel typedModel, @NonNull CompletePackage completePackage) {
		for (@NonNull CompleteClass completeClass : PivotUtil.getOwnedCompleteClasses(completePackage)) {
			org.eclipse.ocl.pivot.Class asClass = completeClass.getPrimaryClass();
			TypedModel containingTypedModel = asClass instanceof DataType ? domainUsageAnalysis.getPrimitiveTypeModel() : typedModel;
			ClassDatum classDatum = getClassDatum(containingTypedModel, asClass);
			for (@NonNull Property property : PivotUtil.getOwnedProperties(asClass)) {
				if (property != oclContainerProperty) {
					@SuppressWarnings("unused")
					PropertyDatum propertyDatumDatum = getPropertyDatum(classDatum, property);
				}
			}
		}
	}

	private boolean assertValidTypedModel(@NonNull TypedModel typedModel, @NonNull CompleteClass completeClass) {
		org.eclipse.ocl.pivot.@NonNull Class aType = completeClass.getPrimaryClass();
		Type elementType = QVTbaseUtil.getElementalType(aType);
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
				result.add(completeModel.getCompleteClass(QVTbaseUtil.getType(varExp)));
			}
		} else if (oclExp instanceof CallExp) {
			CallExp callExp = (CallExp) oclExp;
			if (callExp instanceof OperationCallExp &&
					isOclContainerOp(QVTbaseUtil.getReferredOperation(callExp))) {
				OCLExpression ownedSource = QVTbaseUtil.getOwnedSource(callExp);
				for (@NonNull CompleteClass oclContainerOpContext : computeContexts(ownedSource, variable2BoundContext)) {
					Iterables.addAll(result, containmentAnalysis.getContainerClasses(oclContainerOpContext));
				}
			} else {
				result.add(completeModel.getCompleteClass(QVTbaseUtil.getType(callExp)));
			}
		} else if (oclExp instanceof ShadowExp) {
			result.add(completeModel.getCompleteClass(QVTbaseUtil.getType(oclExp)));

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
		for (@NonNull ClassDatum superClassDatum : scheduleManager.getSuperClassDatums(cDatum)) {
			if (superClassDatum != cDatum) {
				getAllPropertyDatumsInternal(classDatums, propertyDatums, superClassDatum);
			}
		}
		return propertyDatums;
	}

	// Property datum analysis

	public @NonNull ClassDatum getClassDatum(@NonNull TypedModel typedModel, org.eclipse.ocl.pivot.@NonNull Class asClass) {
		CompleteClass completeClass = completeModel.getCompleteClass(asClass);
		return getClassDatum(typedModel, completeClass);
	}

	public @NonNull ClassDatum getClassDatum(@NonNull TypedModel typedModel, @NonNull CompleteClass completeClass) {
		assert assertValidTypedModel(typedModel, completeClass);
		Map<@NonNull CompleteClass, @NonNull ClassDatum> completeClass2classDatums = typedModel2completeClass2classDatum.get(typedModel);
		if (completeClass2classDatums == null) {
			completeClass2classDatums = new HashMap<>();
			typedModel2completeClass2classDatum.put(typedModel, completeClass2classDatums);
		}
		ClassDatum classDatum = completeClass2classDatums.get(completeClass);
		if (classDatum == null) {
			org.eclipse.ocl.pivot.@NonNull Class primaryClass = completeClass.getPrimaryClass();
			if (primaryClass instanceof CollectionType) {
				Type elementType = PivotUtil.getElementType((CollectionType)primaryClass);
				org.eclipse.ocl.pivot.@NonNull Class primaryElementClass = PivotUtil.getClass(elementType, scheduleManager.getStandardLibrary());
				CompleteClass completeElementClass = scheduleManager.getEnvironmentFactory().getCompleteModel().getCompleteClass(primaryElementClass);
				ClassDatum elementClassDatum = getClassDatum(typedModel, completeElementClass);
				CollectionClassDatum collectionClassDatum = QVTscheduleFactory.eINSTANCE.createCollectionClassDatum();
				collectionClassDatum.setElementalClassDatum(elementClassDatum);
				classDatum = collectionClassDatum;
			}
			else {
				classDatum = QVTscheduleFactory.eINSTANCE.createClassDatum();
			}
			classDatum.setOwningScheduleModel(scheduleManager.getScheduleModel());
			classDatum.getCompleteClasses().add(completeClass);
			classDatum.setReferredClass(primaryClass);
			classDatum.setName(primaryClass.getName());
			classDatum.setReferredTypedModel(typedModel);
			if (!(primaryClass instanceof DataType)) {
				//				scheduleManager.getSuperClassDatums(classDatum);  -- lazily computed
				/*				List<ClassDatum> superClassDatums = classDatum.getSuperClassDatums();
				for (@NonNull CompleteClass superCompleteClass : completeClass.getProperSuperCompleteClasses()) {
					DomainUsage superUsage = getUsage(superCompleteClass.getPrimaryClass());
					if (superUsage != null) {		// Ignore superClassDatum with differet typedModels (OclAny)
						Iterable<@NonNull TypedModel> superTypedModels = superUsage.getTypedModels();
						if ((Iterables.size(superTypedModels) == 1) && Iterables.contains(superTypedModels, typedModel)) {
							ClassDatum superClassDatum = getClassDatum(typedModel, superCompleteClass);
							superClassDatums.add(superClassDatum);
						}
					}
				} */
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

	public @NonNull ClassDatum getClassDatum(@NonNull TypedModel typedModel, @NonNull Set<@NonNull CompleteClass> completeClasses) {
		assert completeClasses.size() >= 2;
		for (@NonNull CompleteClass completeClass : completeClasses) {
			assert assertValidTypedModel(typedModel, completeClass);
		}
		Map<@NonNull Set<@NonNull CompleteClass>, @NonNull ClassDatum> completeClasses2classDatums = typedModel2completeClasses2classDatum.get(typedModel);
		if (completeClasses2classDatums == null) {
			completeClasses2classDatums = new HashMap<>();
			typedModel2completeClasses2classDatum.put(typedModel, completeClasses2classDatums);
		}
		ClassDatum classDatum = completeClasses2classDatums.get(completeClasses);
		if (classDatum == null) {
			org.eclipse.ocl.pivot.@NonNull Class primaryClass = completeClasses.iterator().next().getPrimaryClass();
			if (primaryClass instanceof CollectionType) {
				Type elementType = PivotUtil.getElementType((CollectionType)primaryClass);
				org.eclipse.ocl.pivot.@NonNull Class primaryElementClass = PivotUtil.getClass(elementType, scheduleManager.getStandardLibrary());
				CompleteClass completeElementClass = scheduleManager.getEnvironmentFactory().getCompleteModel().getCompleteClass(primaryElementClass);
				ClassDatum elementClassDatum = getClassDatum(typedModel, completeElementClass);
				CollectionClassDatum collectionClassDatum = QVTscheduleFactory.eINSTANCE.createCollectionClassDatum();
				collectionClassDatum.setElementalClassDatum(elementClassDatum);
				classDatum = collectionClassDatum;
			}
			else {
				classDatum = QVTscheduleFactory.eINSTANCE.createClassDatum();
			}
			classDatum.setOwningScheduleModel(scheduleManager.getScheduleModel());
			classDatum.getCompleteClasses().addAll(completeClasses);
			classDatum.setReferredClass(primaryClass);
			classDatum.setName(primaryClass.getName());
			classDatum.setReferredTypedModel(typedModel);
			if (!(primaryClass instanceof DataType)) {
				//				scheduleManager.getSuperClassDatums(classDatum);  -- lazily computed
				/*				List<ClassDatum> superClassDatums = classDatum.getSuperClassDatums();
				for (@NonNull CompleteClass superCompleteClass : completeClass.getProperSuperCompleteClasses()) {
					DomainUsage superUsage = getUsage(superCompleteClass.getPrimaryClass());
					if (superUsage != null) {		// Ignore superClassDatum with differet typedModels (OclAny)
						Iterable<@NonNull TypedModel> superTypedModels = superUsage.getTypedModels();
						if ((Iterables.size(superTypedModels) == 1) && Iterables.contains(superTypedModels, typedModel)) {
							ClassDatum superClassDatum = getClassDatum(typedModel, superCompleteClass);
							superClassDatums.add(superClassDatum);
						}
					}
				} */
			}
			completeClasses2classDatums.put(completeClasses, classDatum);
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
		OCLExpression source = QVTbaseUtil.getOwnedSource(callExp);
		return computeContexts(source, variable2BoundContext);
	}

	public @NonNull ContainmentAnalysis getContainmentAnalysis() {
		return containmentAnalysis;
	}

	protected @NonNull CompleteClass getElementClass(@NonNull TypedElement typedElement) {
		Type type = QVTbaseUtil.getElementalType(QVTbaseUtil.getType(typedElement));
		return completeModel.getCompleteClass(type);
	}

	public @NonNull Iterable<@NonNull PropertyDatum> getOclContainerPropertyDatums(@NonNull ClassDatum containedClassDatum) {
		List<@NonNull PropertyDatum> oclContainerPropertyDatums = classDatum2oclContainerPropertyDatums.get(containedClassDatum);
		if (oclContainerPropertyDatums == null) {
			oclContainerPropertyDatums = new ArrayList<>();
			classDatum2oclContainerPropertyDatums.put(containedClassDatum, oclContainerPropertyDatums);
			for (@NonNull CompleteClass containedCompleteClass : QVTscheduleUtil.getCompleteClasses(containedClassDatum)) {
				Iterable<@NonNull Property> containmentProperties = containmentAnalysis.getContainmentProperties(containedCompleteClass);
				for (@NonNull Property containmentProperty : containmentProperties) {
					//	CompleteClass containingCompleteClass = scheduleManager.getEnvironmentFactory().getCompleteModel().getCompleteClass(PivotUtil.getOwningClass(containmentProperty));
					ClassDatum containingClassDatum = getClassDatum(QVTscheduleUtil.getReferredTypedModel(containedClassDatum), PivotUtil.getOwningClass(containmentProperty));
					oclContainerPropertyDatums.add(getPropertyDatum(containingClassDatum, containmentProperty));
				}
			}
		}
		return oclContainerPropertyDatums;
	}

	protected @NonNull Set<@NonNull PropertyDatum> getOperationPropertyDatums(@NonNull OperationCallExp opCall, @NonNull CompleteClass context,
			@NonNull Map<@NonNull CompleteClass, @NonNull Set<@NonNull Operation>> type2VisitedOps,
			@NonNull Map<@NonNull Variable, @NonNull Set<@NonNull CompleteClass>> variable2BoundContext) {

		Set<@NonNull Operation> visitedOps = type2VisitedOps.get(context);
		if (visitedOps == null) {
			visitedOps = new HashSet<>();
			type2VisitedOps.put(context, visitedOps);
		}

		Set<@NonNull PropertyDatum> result = new HashSet<>();
		Operation op = QVTbaseUtil.getReferredOperation(opCall);

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
						Property property = QVTbaseUtil.getReferredProperty(navCallExp);
						OCLExpression ownedSource = QVTbaseUtil.getOwnedSource(navCallExp);
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

	protected @NonNull PropertyDatum getPropertyDatum(@NonNull TypedModel typedModel, org.eclipse.ocl.pivot.@NonNull Class context, @NonNull Property property) {
		CompleteClass completeClass = completeModel.getCompleteClass(context);
		return getPropertyDatum(typedModel, completeClass, property);
	}

	protected @NonNull PropertyDatum getPropertyDatum(@NonNull TypedModel typedModel, @NonNull CompleteClass completeClass, @NonNull Property property) {
		ClassDatum classDatum = getClassDatum(typedModel, completeClass);
		return getPropertyDatum(classDatum, property);
	}

	public @NonNull PropertyDatum getPropertyDatum(@NonNull ClassDatum classDatum, @NonNull Property property) {
		assert property != oclContainerProperty;			// Use getOclContainerPropertyDatums() to return multiple candidates
		Map<@NonNull Property, @NonNull PropertyDatum> property2propertyDatum = getProperty2propertyDatum(classDatum);
		PropertyDatum cachedPropertyDatum = property2propertyDatum.get(property);
		if (cachedPropertyDatum != null) {
			return cachedPropertyDatum;
		}
		// If not found we create it
		TypedModel typedModel = QVTscheduleUtil.getReferredTypedModel(classDatum);
		//	Iterable<@NonNull CompleteClass> targetCompleteClasses = QVTscheduleUtil.getCompleteClasses(classDatum);
		//	org.eclipse.ocl.pivot.Class owningClass = QVTbaseUtil.getOwningClass(property);
		//	Iterable<@NonNull CompleteClass> hostCompleteClasses = QVTscheduleUtil.getCompleteClasses(classDatum);// completeModel.getCompleteClass(owningClass);
		PropertyDatum propertyDatum = QVTscheduleFactory.eINSTANCE.createPropertyDatum();
		propertyDatum.setReferredTypedModel(typedModel);
		propertyDatum.setReferredProperty(property);
		propertyDatum.setName(property.getName());
		propertyDatum.setOwningClassDatum(classDatum);
		//	assert targetClassDatum.conformsTo(hostClassDatum);
		PropertyDatum oldPropertyDatum = property2propertyDatum.put(property, propertyDatum);
		assert oldPropertyDatum == null;
		/*	for (@NonNull CompleteClass superCompleteClass : targetCompleteClass.getSuperCompleteClasses()) {
			if (superCompleteClass.conformsTo(hostCompleteClass)) {
				PropertyDatum superPropDatum = getPropertyDatum(typedModel, superCompleteClass, property);
				propertyDatum.getSuperPropertyDatums().add(superPropDatum);
			}
		} */
		// Lazily assign the opposite
		Property oppositeProperty = property.getOpposite();
		if (oppositeProperty != null) {
			//	assert oppositeProperty != oclContainerProperty;
			ClassDatum oppositeClassDatum = getClassDatum(QVTscheduleUtil.getReferredTypedModel(classDatum), PivotUtil.getOwningClass(oppositeProperty));
			Map<@NonNull Property, @NonNull PropertyDatum> oppositeProperty2propertyDatum = getProperty2propertyDatum(oppositeClassDatum);
			PropertyDatum oppositePropertyDatum = oppositeProperty2propertyDatum.get(oppositeProperty);
			if (oppositePropertyDatum != null) {
				propertyDatum.setOpposite(oppositePropertyDatum);
				oppositePropertyDatum.setOpposite(propertyDatum);
			}
		}
		return propertyDatum;
	}

	private @NonNull Map<@NonNull Property, @NonNull PropertyDatum> getProperty2propertyDatum(@NonNull ClassDatum classDatum) {
		Map<@NonNull Property, @NonNull PropertyDatum> property2propertyDatum = classDatum2property2propertyDatum.get(classDatum);
		if (property2propertyDatum == null) {
			property2propertyDatum = new HashMap<>();
			classDatum2property2propertyDatum.put(classDatum, property2propertyDatum);
		}
		return property2propertyDatum;
	}

	public @NonNull PropertyDatum getSuccessPropertyDatum(@NonNull Property successProperty) {  // FIXME Could this be more regular ?? <<success>> in the QVTm ??
		org.eclipse.ocl.pivot.Class owningClass = QVTbaseUtil.getOwningClass(successProperty);
		TypedModel typedModel = getTypedModel(owningClass);
		return getPropertyDatum(typedModel, owningClass, successProperty);
	}

	protected @NonNull TypedModel getTypedModel(@NonNull Element element) {
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

	protected @Nullable DomainUsage getUsage(@NonNull Element element) {
		Operation operation = QVTbaseUtil.getContainingOperation(element);
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
		Variable variable = QVTbaseUtil.getOwnedVariable(letExp);
		variable2BoundContext.put(variable, computeContexts(QVTbaseUtil.getOwnedInit(variable), variable2BoundContext));
	}
}
