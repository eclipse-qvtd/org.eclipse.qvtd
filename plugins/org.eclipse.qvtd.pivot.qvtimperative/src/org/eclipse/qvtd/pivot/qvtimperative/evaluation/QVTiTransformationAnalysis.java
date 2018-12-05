/*******************************************************************************
 * Copyright (c) 2013, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
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
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.OperationId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManagerInternal;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.library.LibraryFeature;
import org.eclipse.ocl.pivot.library.oclany.OclElementOclContainerProperty;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.AppendParameter;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.SetStatement;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;

/**
 * QVTiTransformationAnalysis accumulates salient characteristics of one or more
 * transformations prior to execution so that those characteristics can be exploited
 * during execution.
 * <p>
 * Salient characteristics are:
 * <br>
 * - the source types of allInstances() calls
 * - cache indexes of MiddleSetStatement/MiddlePropertyCallExp
 */
public class QVTiTransformationAnalysis
{
	protected final @NonNull EnvironmentFactoryInternal environmentFactory;

	protected final @NonNull ImperativeTransformation transformation;

	/**
	 *  Set of all types for which allInstances() is invoked.
	 */
	private final @NonNull Set<org.eclipse.ocl.pivot.@NonNull Class> allInstancesClasses = new HashSet<>();

	/**
	 *  Map from navigable property to sequential index in any TypedModel.
	 */
	private final @NonNull Map<@NonNull Property, @NonNull Integer> property2cacheIndex = new HashMap<>();

	/**
	 * Map from propertyAssignment to the cache index of an un-navigable lookup cache to be updated by the assignment.
	 */
	private final @NonNull Map<@NonNull SetStatement, @NonNull Integer> setStatement2cacheIndex = new HashMap<>();

	/**
	 * Map from oppositePropertyCallExp to the cache index identifying the relevant un-navigable lookup cache.
	 */
	private final @NonNull Map<@NonNull OppositePropertyCallExp, @NonNull Integer> oppositePropertyCallExp2cacheIndex = new HashMap<>();

	/**
	 * Map from operation to the properties that it may access.
	 */
	private final @NonNull Map<@NonNull Operation, @NonNull Set<@NonNull NavigationCallExp>> operation2property = new HashMap<>();

	/**
	 * Map from mapping to the properties that it may access.
	 */
	private final @NonNull Map<@NonNull Mapping, @NonNull Set<@NonNull NavigationCallExp>> mapping2property = new HashMap<>();

	/**
	 * Map from mapping to the properties that it may assign.
	 */
	private final @NonNull Map<@NonNull Mapping, @NonNull Set<@NonNull SetStatement>> mapping2propertyAssignments = new HashMap<>();

	/**
	 * Mappings that have an isPolled input.
	 */
	private final @NonNull Set<@NonNull Mapping> hazardousMappings = new HashSet<>();

	/**
	 * The SetStatements to each Property.
	 */
	private final @NonNull Map<@NonNull Property, @NonNull Set<@NonNull SetStatement>> property2propertyAssignments = new HashMap<>();

	/**
	 * Map of all oclContainer() accesses.
	 */
	private final @NonNull Map<@NonNull Type, @NonNull List<@NonNull Type>> parentClass2childClasses = new HashMap<>();

	public QVTiTransformationAnalysis(@NonNull EnvironmentFactoryInternal environmentFactory, @NonNull ImperativeTransformation transformation) {
		this.environmentFactory = environmentFactory;
		this.transformation = transformation;
	}

	private void addAllInstancesClass(@NonNull TypedElement asExpression) {
		Type asType = asExpression instanceof OCLExpression ? ((OCLExpression)asExpression).getTypeValue() : null;
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
			cacheIndex = size;
		}
		return cacheIndex;
	}

	private @NonNull Set<@NonNull NavigationCallExp> analyzeMappingPropertyAccesses(@NonNull Mapping mapping) {
		Set<@NonNull NavigationCallExp> accessedProperties = mapping2property.get(mapping);
		if (accessedProperties != null) {
			return accessedProperties;
		}
		accessedProperties = new HashSet<>();
		mapping2property.put(mapping, accessedProperties);
		analyzeTree(accessedProperties, mapping.eAllContents());
		return accessedProperties;
	}

	private @NonNull Set<@NonNull SetStatement> analyzeMappingSetStatements(@NonNull Mapping mapping) {
		Set<@NonNull SetStatement> assignedProperties = mapping2propertyAssignments.get(mapping);
		if (assignedProperties == null) {
			assignedProperties = new HashSet<>();
			mapping2propertyAssignments.put(mapping, assignedProperties);
		}
		for (TreeIterator<EObject> treeIterator = mapping.eAllContents(); treeIterator.hasNext(); ) {
			EObject eObject = treeIterator.next();
			if (eObject instanceof SetStatement) {
				assignedProperties.add((SetStatement) eObject);
			}
		}
		return assignedProperties;
	}

	private @NonNull Set<@NonNull NavigationCallExp> analyzeOperation(@NonNull Operation operation) {
		Set<@NonNull NavigationCallExp> operationProperties = operation2property.get(operation);
		if (operationProperties != null) {
			return operationProperties;
		}
		operationProperties = new HashSet<>();
		operation2property.put(operation, operationProperties);
		analyzeTree(operationProperties, operation.eAllContents());
		return operationProperties;
	}

	private void analyzeProperties() {
		for (@NonNull Set<@NonNull SetStatement> propertyAssignments : mapping2propertyAssignments.values()) {
			for (@NonNull SetStatement propertyAssignment : propertyAssignments) {
				Property property = propertyAssignment.getTargetProperty();
				assert property != null;
				Set<@NonNull SetStatement> assignments = property2propertyAssignments.get(property);
				if (assignments == null) {
					assignments = new HashSet<>();
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
						assert childType != null;
						Type parentType = asPropertyCallExp.getType();
						assert parentType != null;
						List<@NonNull Type> childClasses = parentClass2childClasses .get(parentType);
						if (childClasses == null) {
							childClasses = new ArrayList<>();
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

	public void analyzeTransformation() {
		//
		//	First pass
		//  - identify all allInstances() source types
		//  - identify all SetStatements
		//  - identify all assigned PropertyCallExp and allocate a cacheIndex
		//
		Type oclElementType = environmentFactory.getStandardLibrary().getOclElementType();
		Type modelType = environmentFactory.getStandardLibrary().getLibraryType("Model");
		OperationId allInstancesOperationId = oclElementType.getTypeId().getOperationId(0, "allInstances", IdManager.getParametersId());
		OperationId objectsOfKindOperationId = modelType.getTypeId().getOperationId(1, "objectsOfKind", IdManager.getParametersId(TypeId.T_1));
		OperationId objectsOfTypeOperationId = modelType.getTypeId().getOperationId(1, "objectsOfType", IdManager.getParametersId(TypeId.T_1));
		List<@NonNull SetStatement> setStatements = new ArrayList<>();
		for (TreeIterator<EObject> tit = transformation.eAllContents(); tit.hasNext(); ) {
			EObject eObject = tit.next();
			if (eObject instanceof Mapping) {
				Mapping mapping = (Mapping)eObject;
				analyzeMappingPropertyAccesses(mapping);
				analyzeMappingSetStatements(mapping);
				if (QVTimperativeUtil.isObserver(mapping)) {
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
			else if (eObject instanceof SetStatement) {
				setStatements.add((SetStatement)eObject);
			}
			else if (eObject instanceof AppendParameter) {
				Mapping mapping = QVTimperativeUtil.getContainingMapping(eObject);
				Mapping rootMapping = QVTimperativeUtil.getRootMapping(QVTimperativeUtil.getContainingTransformation(mapping));
				if (rootMapping == mapping) {
					addAllInstancesClass((AppendParameter)eObject);
				}
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
		//  - install cacheIndex allocated to MiddlePropertyCallExp in each MiddleSetStatement
		//
		for (@NonNull SetStatement propertyAssignment : setStatements) {
			Property navigableProperty = propertyAssignment.getTargetProperty();
			if (navigableProperty != null) {
				Integer cacheIndex = property2cacheIndex.get(navigableProperty);
				if (cacheIndex != null) { 		// No need to set cacheIndex if it is never accessed by an OppositePropertyCallExp
					setStatement2cacheIndex.put(propertyAssignment, cacheIndex);
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

	public @Nullable Integer getCacheIndex(@NonNull SetStatement setStatement) {
		return setStatement2cacheIndex.get(setStatement);
	}

	public int getCacheIndexes() {
		return property2cacheIndex.size();
	}

	public @NonNull Map<@NonNull Property, @NonNull Integer> getCaches() {
		return property2cacheIndex;
	}

	public @NonNull EnvironmentFactory getEnvironmentFactory() {
		return environmentFactory;
	}

	public @NonNull Set<@NonNull Mapping> getHazardousMappings() {
		return hazardousMappings;
	}

	/**
	 * Return a Map from each instanceClasses to the subset of instanceClasses that are transitive superClasses of the particular instanceClass.
	 */
	public @NonNull Map<org.eclipse.ocl.pivot.@NonNull Class, @Nullable List<org.eclipse.ocl.pivot.@NonNull Class>> getInstancesClassAnalysis(@NonNull Iterable<org.eclipse.ocl.pivot.@NonNull Class> instanceClasses) {
		Map<org.eclipse.ocl.pivot.@NonNull Class, @Nullable List<org.eclipse.ocl.pivot.@NonNull Class>> instancesClassAnalysis = new HashMap<>();
		MetamodelManagerInternal metamodelManager = environmentFactory.getMetamodelManager();
		for (org.eclipse.ocl.pivot.@NonNull Class instanceClass : instanceClasses) {
			CompleteClass completeInstanceClass = metamodelManager.getCompleteClass(instanceClass);
			instancesClassAnalysis.put(completeInstanceClass.getPrimaryClass(), null);
		}
		for (org.eclipse.ocl.pivot.@NonNull Class instanceClass : instancesClassAnalysis.keySet()) {
			List<org.eclipse.ocl.pivot.Class> superInstanceClasses = new ArrayList<>();
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

	public @NonNull Map<@NonNull Mapping, @NonNull Set<@NonNull NavigationCallExp>> getMapping2Property() {
		return mapping2property;
	}

	public @NonNull Map<Mapping, @NonNull Set<@NonNull SetStatement>> getMapping2SetStatements() {
		return mapping2propertyAssignments;
	}

	public @NonNull MetamodelManagerInternal getMetamodelManager() {
		return environmentFactory.getMetamodelManager();
	}

	public @NonNull ImperativeTransformation getTransformation() {
		return transformation;
	}

	public boolean isHazardous(@NonNull Mapping mapping) {
		return hazardousMappings.contains(mapping);
	}
}
