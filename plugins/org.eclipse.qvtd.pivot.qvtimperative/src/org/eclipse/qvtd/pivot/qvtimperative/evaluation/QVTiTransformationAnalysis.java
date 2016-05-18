/*******************************************************************************
 * Copyright (c) 2013, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     E.D.Willink - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.evaluation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.NavigationCallExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.OppositePropertyCallExp;
import org.eclipse.ocl.pivot.PrimitiveType;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.PropertyCallExp;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.OperationId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.complete.StandardLibraryInternal;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManagerInternal;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.library.LibraryFeature;
import org.eclipse.ocl.pivot.library.oclany.OclElementOclContainerProperty;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcorebase.Area;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.NavigationAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.analysis.DomainUsage;
import org.eclipse.qvtd.pivot.qvtcorebase.utilities.QVTcoreBaseUtil;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeArea;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeDomain;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeDomainUsageAnalysis;

/**
 * QVTiTransformationAnalysis accumulates salient characteristics of one or more
 * transformations prior to execution so that those characteristics can be exploited
 * during execution.
 * <p>
 * Salient characteristics are:
 * <br>
 * - the source types of allInstances() calls
 * - cache indexes of MiddlePropertyAssignment/MiddlePropertyCallExp
 */
public class QVTiTransformationAnalysis
{
	protected final @NonNull EnvironmentFactoryInternal environmentFactory;
	
	/**
	 * Analysis of domains applicable to each transformation element. 
	 */
	private final @NonNull QVTimperativeDomainUsageAnalysis domainAnalysis;

	/**
	 *  Set of all types for which allInstances() is invoked.
	 */
	private final @NonNull Set<org.eclipse.ocl.pivot.@NonNull Class> allInstancesClasses = new HashSet<org.eclipse.ocl.pivot.@NonNull Class>();

	/**
	 *  Map from navigable property to sequential index in any TypedModel.
	 */
	private final @NonNull Map<@NonNull Property, @NonNull Integer> property2cacheIndex = new HashMap<@NonNull Property, @NonNull Integer>();

	/**
	 *  Map from navigable property to sequential index in a checkable TypedModel.
	 */
	private final @NonNull Map<Property, Integer> sourceProperty2cacheIndex = new HashMap<Property, Integer>();

	/**
	 * Map from propertyAssignment to the cache index of an un-navigable lookup cache to be updated by the assignment.
	 */
	private final @NonNull Map<NavigationAssignment, Integer> navigationAssignment2cacheIndex = new HashMap<NavigationAssignment, Integer>();

	/**
	 * Map from oppositePropertyCallExp to the cache index identifying the relevant un-navigable lookup cache.
	 */
	private final @NonNull Map<OppositePropertyCallExp, Integer> oppositePropertyCallExp2cacheIndex = new HashMap<OppositePropertyCallExp, Integer>();

	/**
	 * Map from operation to the properties that it may access.
	 */
	private final @NonNull Map<Operation, Set<NavigationCallExp>> operation2property = new HashMap<Operation, Set<NavigationCallExp>>();

	/**
	 * Map from mapping to the properties that it may access.
	 */
	private final @NonNull Map<Mapping, Set<NavigationCallExp>> mapping2property = new HashMap<Mapping, Set<NavigationCallExp>>();

	/**
	 * Map from mapping to the properties that it may assign.
	 */
	private final @NonNull Map<Mapping, Set<PropertyAssignment>> mapping2propertyAssignments = new HashMap<Mapping, Set<PropertyAssignment>>();

	/**
	 * Mappings that have an isPolled input.
	 */
	private final @NonNull Set<Mapping> hazardousMappings = new HashSet<Mapping>();

	private final @NonNull Set<Property> hazardousProperties = new HashSet<Property>();

	/**
	 * The PropertyAssignments to each Property.
	 */
	private final @NonNull Map<Property, Set<PropertyAssignment>> property2propertyAssignments = new HashMap<Property, Set<PropertyAssignment>>();

	/**
	 * Map of all oclContainer() accesses.
	 */
	private final @NonNull Map<Type, List<Type>> parentClass2childClasses = new HashMap<Type, List<Type>>();

	public QVTiTransformationAnalysis(@NonNull EnvironmentFactoryInternal environmentFactory) {
	    this.environmentFactory = environmentFactory;
		this.domainAnalysis = new QVTimperativeDomainUsageAnalysis(environmentFactory);
	}

	private void addAllInstancesClass(@NonNull OCLExpression asExpression) {
		Type asType = asExpression.getTypeValue();
		if (asType == null) {
			asType = asExpression.getType();
		}
		if (asType instanceof org.eclipse.ocl.pivot.Class) {
			assert !(asType instanceof PrimitiveType);
			assert !(asType instanceof CollectionType);
			allInstancesClasses.add((org.eclipse.ocl.pivot.Class)asType);
		}
	}
	
	protected @NonNull Integer allocateCacheIndex(@Nullable OCLExpression sourceExpression, @NonNull Property navigableProperty) {
		Integer cacheIndex = property2cacheIndex.get(navigableProperty);
		if (cacheIndex == null) { 
			Integer size = property2cacheIndex.size();
			property2cacheIndex.put(navigableProperty, size);
			if (sourceExpression != null) {
				DomainUsage sourceUsage = domainAnalysis.basicGetUsage(sourceExpression);
				if ((sourceUsage != null) && sourceUsage.isInput()) {
					sourceProperty2cacheIndex.put(navigableProperty, size);
				}
			}
			cacheIndex = size;
		}
		return cacheIndex;
	}
	
	private @NonNull Set<NavigationCallExp> analyzeMappingPropertyAccesses(@NonNull Mapping mapping) {
		Set<NavigationCallExp> accessedProperties = mapping2property.get(mapping);
		if (accessedProperties != null) {
			return accessedProperties;
		}
		accessedProperties = new HashSet<NavigationCallExp>();
		mapping2property.put(mapping, accessedProperties);
		analyzeTree(accessedProperties, mapping.eAllContents());
		return accessedProperties;
	}
	
	private @NonNull Set<PropertyAssignment> analyzeMappingPropertyAssignments(@NonNull Mapping mapping) {
		Set<PropertyAssignment> assignedProperties = mapping2propertyAssignments.get(mapping);
		if (assignedProperties == null) {
			assignedProperties = new HashSet<PropertyAssignment>();
			mapping2propertyAssignments.put(mapping, assignedProperties);
		}
		for (TreeIterator<EObject> treeIterator = mapping.eAllContents(); treeIterator.hasNext(); ) {
			EObject eObject = treeIterator.next();
			if (eObject instanceof PropertyAssignment) {
				assignedProperties.add((PropertyAssignment) eObject);
			}
		}
		return assignedProperties;
	}

	private @NonNull Set<NavigationCallExp> analyzeOperation(@NonNull Operation operation) {
		Set<NavigationCallExp> operationProperties = operation2property.get(operation);
		if (operationProperties != null) {
			return operationProperties;
		}
		operationProperties = new HashSet<NavigationCallExp>();
		operation2property.put(operation, operationProperties);
		analyzeTree(operationProperties, operation.eAllContents());
		return operationProperties;
	}

	private void analyzeProperties() {
		Set<Mapping> hazardousMappings = getHazardousMappings();
		for (Map.Entry<Mapping, Set<NavigationCallExp>> entry : getMapping2Property().entrySet()) {
			Mapping mapping = entry.getKey();
			if (hazardousMappings.contains(mapping)) {
				for (@SuppressWarnings("null")@NonNull NavigationCallExp hazardousPropertyCallExp : entry.getValue()) {
					Property hazardousProperty = PivotUtil.getReferredProperty(hazardousPropertyCallExp);
					hazardousProperties.add(hazardousProperty);
					hazardousProperties.add(hazardousProperty.getOpposite());
				}
			}
		}
		for (Set<PropertyAssignment> propertyAssignments : mapping2propertyAssignments.values()) {
			for (PropertyAssignment propertyAssignment : propertyAssignments) {
				Property property = propertyAssignment.getTargetProperty();
				Set<PropertyAssignment> assignments = property2propertyAssignments.get(property);
				if (assignments == null) {
					assignments = new HashSet<PropertyAssignment>();
					property2propertyAssignments.put(property, assignments);
				}
				assignments.add(propertyAssignment);
			}
		}
	}

	protected void analyzeTree(@NonNull Set<NavigationCallExp> properties, /*@NonNull*/ TreeIterator<EObject> treeIterator) {
		while (treeIterator.hasNext()) {
			EObject eObject = treeIterator.next();
			if (eObject instanceof OperationCallExp) {
				Operation referredOperation = ((OperationCallExp)eObject).getReferredOperation();
				if (referredOperation != null) {
					properties.addAll(analyzeOperation(referredOperation));
				}
			}
			else if (eObject instanceof PropertyCallExp) {
				PropertyCallExp asPropertyCallExp = (PropertyCallExp)eObject;
				Property referredProperty = asPropertyCallExp.getReferredProperty();
				if (referredProperty != null) {
					LibraryFeature implementation = referredProperty.getImplementation();
					if (implementation instanceof OclElementOclContainerProperty) {
						Type childType = asPropertyCallExp.getOwnedSource().getType();
						Type parentType = asPropertyCallExp.getType();
						List<Type> childClasses = parentClass2childClasses .get(parentType);
						if (childClasses == null) {
							childClasses = new ArrayList<Type>();
							parentClass2childClasses.put(parentType, childClasses);
						}
						if (!childClasses.contains(childType)) {
							childClasses.add(childType);
						}
					}
					else {
						properties.add(asPropertyCallExp);
					}
				}
			}
			else if (eObject instanceof OppositePropertyCallExp) {
				OppositePropertyCallExp asOppositePropertyCallExp = (OppositePropertyCallExp)eObject;
				Property referredOppositeProperty = asOppositePropertyCallExp.getReferredProperty();
				if (referredOppositeProperty != null) {
					Property referredProperty = referredOppositeProperty.getOpposite();
					if (referredProperty != null) {
						properties.add(asOppositePropertyCallExp);
					}
				}
			}
		}
	}

	public void analyzeTransformation(@NonNull Transformation transformation) {
		domainAnalysis.analyzeTransformation(transformation);
		transformation.accept(QVTiTuneUpVisitor.INSTANCE);
		//
		//	First pass
		//  - identify all allInstances() source types
		//  - identify all PropertyAssignments
		//  - identify all assigned PropertyCallExp and allocate a cacheIndex
		//
		Type oclElementType = environmentFactory.getStandardLibrary().getOclElementType();
		Type modelType = environmentFactory.getStandardLibrary().getLibraryType("Model");
		OperationId allInstancesOperationId = oclElementType.getTypeId().getOperationId(0, "allInstances", IdManager.getParametersId());
		OperationId objectsOfKindOperationId = modelType.getTypeId().getOperationId(1, "objectsOfKind", IdManager.getParametersId(TypeId.T_1));
		OperationId objectsOfTypeOperationId = modelType.getTypeId().getOperationId(1, "objectsOfType", IdManager.getParametersId(TypeId.T_1));
		List<PropertyAssignment> propertyAssignments = new ArrayList<PropertyAssignment>();
		for (TreeIterator<EObject> tit = transformation.eAllContents(); tit.hasNext(); ) {
			EObject eObject = tit.next();
			if (eObject instanceof Mapping) {
				Mapping mapping = (Mapping)eObject;
				analyzeMappingPropertyAccesses(mapping);
				analyzeMappingPropertyAssignments(mapping);
				if (mapping.getCheckedProperties().size() > 0) {
					hazardousMappings.add(mapping);
				}
				else {
					for (Domain domain : mapping.getDomain()) {
						if (domain instanceof ImperativeDomain) {
							ImperativeDomain imperativeDomain = (ImperativeDomain)domain;
							if (imperativeDomain.getCheckedProperties().size() > 0) {
								hazardousMappings.add(mapping);
								break;
							}
						}
					}
				}
			}
			else if (eObject instanceof MappingCallBinding) {
				MappingCallBinding mappingCallBinding = (MappingCallBinding)eObject;
				if (mappingCallBinding.isIsPolled()) {
					Mapping mapping = mappingCallBinding.getMappingCall().getReferredMapping();
					hazardousMappings.add(mapping);
				}
			}
			else if (eObject instanceof OppositePropertyCallExp) {
				OppositePropertyCallExp oppositePropertyCallExp = (OppositePropertyCallExp)eObject;
				Property navigableProperty = oppositePropertyCallExp.getReferredProperty();
				if ((navigableProperty != null) && !navigableProperty.isIsComposite()) {
					int cacheIndex = allocateCacheIndex(oppositePropertyCallExp.getOwnedSource(), navigableProperty);
					oppositePropertyCallExp2cacheIndex.put(oppositePropertyCallExp, cacheIndex);
				}
			}
			else if (eObject instanceof PropertyAssignment) {
				propertyAssignments.add((PropertyAssignment)eObject);
			}
			else if (eObject instanceof OperationCallExp) {
				OperationCallExp operationCallExp = (OperationCallExp)eObject;
				Operation referredOperation = operationCallExp.getReferredOperation();
				if (referredOperation != null) {
					OperationId operationId = referredOperation.getOperationId();
					if (operationId == allInstancesOperationId) {
						OCLExpression source = operationCallExp.getOwnedSource();
						if (source != null) {
							addAllInstancesClass(source);
						}
					}
					else if ((operationId == objectsOfKindOperationId) || (operationId == objectsOfTypeOperationId)) {
						OCLExpression argument = operationCallExp.getOwnedArguments().get(0);
						if (argument != null) {
							addAllInstancesClass(argument);
						}
					}
				}
			}
/*			else if (eObject instanceof OppositePropertyCallExp) {
				OppositePropertyCallExp oppositePropertyCallExp = (OppositePropertyCallExp)eObject;
				Property referredProperty = oppositePropertyCallExp.getReferredProperty();
				if (referredProperty != null) {
					getOppositeCacheIndex(referredProperty);
				}
			} */
		}
		//
		//	Second pass
		//  - install cacheIndex allocated to MiddlePropertyCallExp in each MiddlePropertyAssignment
		//
		for (PropertyAssignment propertyAssignment : propertyAssignments) {
			Property navigableProperty = propertyAssignment.getTargetProperty();
			if (navigableProperty != null) {
				Integer cacheIndex = property2cacheIndex.get(navigableProperty);
				if (cacheIndex != null) { 		// No need to set cacheIndex if it is never accessed by an OppositePropertyCallExp
					navigationAssignment2cacheIndex.put(propertyAssignment, cacheIndex);
				}
			}
		}
		//
		analyzeProperties();
	}

	public @NonNull Set<org.eclipse.ocl.pivot.@NonNull Class> getAllInstancesClasses() {
		return allInstancesClasses;
	}

	public @Nullable Integer getCacheIndex(@NonNull OppositePropertyCallExp oppositePropertyCallExp) {
		return oppositePropertyCallExp2cacheIndex.get(oppositePropertyCallExp);
	}

	public @Nullable Integer getCacheIndex(@NonNull NavigationAssignment navigationAssignment) {
		return navigationAssignment2cacheIndex.get(navigationAssignment);
	}

	public int getCacheIndexes() {
		return property2cacheIndex.size();
	}

	public @NonNull Map<@NonNull Property, @NonNull Integer> getCaches() {
		return property2cacheIndex;
	}
	
	public @NonNull QVTimperativeDomainUsageAnalysis getDomainUsageAnalysis() {
		return domainAnalysis;
	}

	public @NonNull Set<Mapping> getHazardousMappings() {
		return hazardousMappings;
	}

	/**
	 * Return a Map from each instanceClasses to the subset of instanceClasses that are transitive superClasses of the particular instanceClass.
	 */
	public @NonNull Map<org.eclipse.ocl.pivot.@NonNull Class, @Nullable List<org.eclipse.ocl.pivot.@NonNull Class>> getInstancesClassAnalysis(@NonNull Iterable<org.eclipse.ocl.pivot.@NonNull Class> instanceClasses) {
		Map<org.eclipse.ocl.pivot.@NonNull Class, @Nullable List<org.eclipse.ocl.pivot.@NonNull Class>> instancesClassAnalysis = new HashMap<org.eclipse.ocl.pivot.@NonNull Class, @Nullable List<org.eclipse.ocl.pivot.@NonNull Class>>();
		MetamodelManagerInternal metamodelManager = environmentFactory.getMetamodelManager();
		for (org.eclipse.ocl.pivot.@NonNull Class instanceClass : instanceClasses) {
			CompleteClass completeInstanceClass = metamodelManager.getCompleteClass(instanceClass);
			instancesClassAnalysis.put(completeInstanceClass.getPrimaryClass(), null);
		}
		for (org.eclipse.ocl.pivot.@NonNull Class instanceClass : instancesClassAnalysis.keySet()) {
			List<org.eclipse.ocl.pivot.Class> superInstanceClasses = new ArrayList<org.eclipse.ocl.pivot.Class>();
			superInstanceClasses.add(instanceClass);
			CompleteClass completeClass = metamodelManager.getCompleteClass(instanceClass);
			for (@NonNull CompleteClass superCompleteClass : completeClass.getProperSuperCompleteClasses()) {
				org.eclipse.ocl.pivot.Class superClass = superCompleteClass.getPrimaryClass();
				if (instancesClassAnalysis.containsKey(superClass)) {
					superInstanceClasses.add(superClass);
				}
				instancesClassAnalysis.put(instanceClass, superInstanceClasses);
			}
		}
		return instancesClassAnalysis;
	}

	public @NonNull Map<Mapping, Set<NavigationCallExp>> getMapping2Property() {
		return mapping2property;
	}

	public @NonNull Map<Mapping, Set<PropertyAssignment>> getMapping2PropertyAssignments() {
		return mapping2propertyAssignments;
	}

	public @NonNull MetamodelManagerInternal getMetamodelManager() {
		return environmentFactory.getMetamodelManager();
	}
	
/*	protected int getOppositeCacheIndex(@NonNull Property oppositeProperty) {
		Integer cacheIndex = opposite2cacheIndex.get(oppositeProperty);
		if (cacheIndex == null) { 
			cacheIndex = opposite2cacheIndex.size();
			opposite2cacheIndex.put(oppositeProperty, cacheIndex);
		}
		return cacheIndex;
	}

	public int getOppositeCacheIndexes() {
		return opposite2cacheIndex.size();
	}

	public @NonNull Map<Property, Integer> getOpposites() {
		return opposite2cacheIndex;
	} */

	public @NonNull Map<Property, Integer> getSourceCaches() {
		return sourceProperty2cacheIndex;
	}

	public boolean hasHazardousRead(@NonNull MappingCall mappingCall) {
		for (MappingCallBinding callBinding : mappingCall.getBinding()) {
			if (callBinding.isIsPolled()) {
				return true;
			}
		}
		return false;
	}

	public boolean hasHazardousWrite(@NonNull MappingCall mappingCall) {
		Mapping mapping = mappingCall.getReferredMapping();
		Set<PropertyAssignment> propertyAssignments = mapping2propertyAssignments.get(mapping);
		if (propertyAssignments == null) {
			return false;
		}
		for (PropertyAssignment propertyAssignment : propertyAssignments) {
			Property assignedProperty = propertyAssignment.getTargetProperty();
			if (hazardousProperties.contains(assignedProperty)) {
				return true;
			}
			if (hazardousProperties.contains(assignedProperty.getOpposite())) {
				return true;
			}
		}
		return false;
	}

	public boolean isAssigned(@NonNull Property targetProperty, @NonNull DomainUsage domainUsage) {
		Set<PropertyAssignment> propertyAssignments = property2propertyAssignments.get(targetProperty);
		if (propertyAssignments == null) {
			return false;
		}
		for (PropertyAssignment propertyAssignment : propertyAssignments) {
			OCLExpression slotExpression = propertyAssignment.getSlotExpression();
			DomainUsage slotUsage = domainAnalysis.basicGetUsage(slotExpression);
			if (domainUsage == slotUsage) {
				return true;
			}
		}
		return false;
	}

	public boolean isHazardous(@NonNull Property targetProperty) {	// Migrate to isHazardous(@NonNull Mapping asMapping, @NonNull Property asProperty)
		if (hazardousProperties.contains(targetProperty)) {
			return true;
		}
		if (!targetProperty.isIsComposite()) {
			return false;
		}
		StandardLibraryInternal standardLibrary = environmentFactory.getStandardLibrary();
		Type parentType = targetProperty.getOwningClass();
		Type childType = targetProperty.getType();
		assert childType != null;
		for (Map.Entry<Type, List<Type>> entry : parentClass2childClasses.entrySet()) {
			Type entryType = entry.getKey();
			assert entryType != null;
			if (parentType.conformsTo(standardLibrary, entryType)) {
				for (Type type : entry.getValue()) {
					if (type.conformsTo(standardLibrary, childType)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public boolean isHazardous(@NonNull Mapping mapping) {
		return hazardousMappings.contains(mapping);
	}

	public boolean isHazardousRead(@NonNull Mapping asMapping, @NonNull NavigationCallExp asNavigationCallExp) {
		Property asProperty = PivotUtil.getReferredProperty(asNavigationCallExp);
		OCLExpression asSource = asNavigationCallExp.getOwnedSource();
		DomainUsage domainUsage = domainAnalysis.basicGetUsage(asSource);
		if (domainUsage != null) {
			TypedModel typedModel = domainUsage.getTypedModel(asSource);
			if (typedModel != null) {
				Area area = QVTcoreBaseUtil.getArea(asMapping, typedModel);
				if ((area instanceof ImperativeArea) && ((ImperativeArea)area).getCheckedProperties().contains(asProperty)) {
					return true;
				}
			}
		}
		Property asOppositeProperty = asProperty.getOpposite();
		domainUsage = domainAnalysis.basicGetUsage(asProperty.getType());
		DomainUsage domainUsage2 = domainAnalysis.basicGetUsage(asNavigationCallExp);
		if (domainUsage2 != null) {
			TypedModel typedModel = domainUsage2.getTypedModel(asProperty);
			if (typedModel != null) {
				Area area = QVTcoreBaseUtil.getArea(asMapping, typedModel);
				if ((area instanceof ImperativeArea) && ((ImperativeArea)area).getCheckedProperties().contains(asOppositeProperty)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean isHazardousWrite(@NonNull Mapping asMapping, @NonNull NavigationAssignment asNavigationAssignment) {
		Property asProperty = QVTcoreBaseUtil.getTargetProperty(asNavigationAssignment);
		OCLExpression asSource = asNavigationAssignment.getSlotExpression();
		DomainUsage domainUsage = getDomainUsageAnalysis().basicGetUsage(asSource);
		if (domainUsage != null) {
			TypedModel typedModel = domainUsage.getTypedModel(asSource);
			if (typedModel != null) {
				Area area = null;
				for (Domain domain : asMapping.getDomain()) {
					if (domain.getTypedModel() == typedModel) {
						area = (CoreDomain)domain;
						break;
					}
				}
				if (area == null) {
					area = asMapping;
				}
				if (area instanceof ImperativeArea) {
					List<Property> enforcedProperties = ((ImperativeArea)area).getEnforcedProperties();
					if (enforcedProperties.contains(asProperty)) {
						return true;
					}
					if (enforcedProperties.contains(asProperty.getOpposite())) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
