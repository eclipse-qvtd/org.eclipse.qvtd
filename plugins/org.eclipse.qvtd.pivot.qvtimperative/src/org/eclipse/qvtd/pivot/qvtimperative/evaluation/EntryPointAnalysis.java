/*******************************************************************************
 * Copyright (c) 2019 Willink Transformations and others.
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
import org.eclipse.ocl.pivot.library.LibraryFeature;
import org.eclipse.ocl.pivot.library.oclany.OclElementOclContainerProperty;
import org.eclipse.ocl.pivot.utilities.TreeIterable;
import org.eclipse.ocl.pivot.utilities.UniqueList;
import org.eclipse.qvtd.pivot.qvtimperative.AppendParameter;
import org.eclipse.qvtd.pivot.qvtimperative.EntryPoint;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.SetStatement;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;

/**
 * EntryPointAnalysis provides the pre-execution analysis of a particular transformation entry-point.
 */
public class EntryPointAnalysis
{
	protected final @NonNull EntryPointsAnalysis entryPointsAnalysis;
	protected final @NonNull EntryPoint entryPoint;
	protected final @NonNull UniqueList<@NonNull Mapping> mappings = new UniqueList<>();

	/**
	 *  Set of all types for which allInstances() is invoked.
	 */
	private final @NonNull Set<@NonNull CompleteClass> allInstancesCompleteClasses = new HashSet<>();
	/**
	 * Map from oppositePropertyCallExp to the cache index identifying the relevant un-navigable lookup cache.
	 */
	private final @NonNull Map<@NonNull OppositePropertyCallExp, @NonNull Integer> oppositePropertyCallExp2cacheIndex = new HashMap<>();

	/**
	 * Mappings that have an isPolled input.
	 */
	private final @NonNull Set<@NonNull Mapping> hazardousMappings = new HashSet<>();

	/**
	 * Map from mapping to the properties that it may access.
	 */
	private final @NonNull Map<@NonNull Mapping, @NonNull Set<@NonNull NavigationCallExp>> mapping2property = new HashMap<>();

	/**
	 * Map from mapping to the properties that it may assign.
	 */
	private final @NonNull Map<@NonNull Mapping, @NonNull Set<@NonNull SetStatement>> mapping2propertyAssignments = new HashMap<>();

	/**
	 * Map from operation to the properties that it may access.
	 */
	private final @NonNull Map<@NonNull Operation, @NonNull Set<@NonNull NavigationCallExp>> operation2property = new HashMap<>();

	/**
	 * The SetStatements to each Property.
	 */
	private final @NonNull Map<@NonNull Property, @NonNull Set<@NonNull SetStatement>> property2propertyAssignments = new HashMap<>();

	/**
	 * Map of all oclContainer() accesses.
	 */
	private final @NonNull Map<@NonNull Type, @NonNull List<@NonNull Type>> parentClass2childClasses = new HashMap<>();

	public EntryPointAnalysis(@NonNull EntryPointsAnalysis entryPointsAnalysis, @NonNull EntryPoint entryPoint) {
		this.entryPointsAnalysis = entryPointsAnalysis;
		this.entryPoint = entryPoint;
		mappings.add(entryPoint);
	}

	private void addAllInstancesClass(@NonNull TypedElement asExpression) {
		Type asType = asExpression instanceof OCLExpression ? ((OCLExpression)asExpression).getTypeValue() : null;
		if (asType == null) {
			asType = asExpression.getType();
		}
		if (asType instanceof org.eclipse.ocl.pivot.Class) {
			assert !(asType instanceof PrimitiveType);
			assert !(asType instanceof CollectionType);
			CompleteClass completeClass = entryPointsAnalysis.environmentFactory.getCompleteModel().getCompleteClass(asType);
			allInstancesCompleteClasses.add(completeClass);
		}
	}

	public boolean addMapping(@NonNull Mapping iMapping) {
		return mappings.add(iMapping);
	}

	public void analyze() {
		//
		//	First pass
		//  - identify all allInstances() source types
		//  - identify all SetStatements
		//  - identify all assigned PropertyCallExp and allocate a cacheIndex
		//
		List<@NonNull SetStatement> setStatements = new ArrayList<>();
		Type oclElementType = entryPointsAnalysis.environmentFactory.getStandardLibrary().getOclElementType();
		Type modelType = entryPointsAnalysis.environmentFactory.getStandardLibrary().getLibraryType("Model");
		OperationId allInstancesOperationId = oclElementType.getTypeId().getOperationId(0, "allInstances", IdManager.getParametersId());
		OperationId objectsOfKindOperationId = modelType.getTypeId().getOperationId(1, "objectsOfKind", IdManager.getParametersId(TypeId.T_1));
		OperationId objectsOfTypeOperationId = modelType.getTypeId().getOperationId(1, "objectsOfType", IdManager.getParametersId(TypeId.T_1));
		for (@NonNull Mapping iMapping : getMappings()) {
			for (EObject eObject : new TreeIterable(iMapping, true)) {
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
						int cacheIndex = entryPointsAnalysis.allocateCacheIndex(oppositePropertyCallExp.getOwnedSource(), navigableProperty);
						oppositePropertyCallExp2cacheIndex.put(oppositePropertyCallExp, cacheIndex);
					}
				}
				else if (eObject instanceof SetStatement) {
					setStatements.add((SetStatement)eObject);
				}
				else if (eObject instanceof AppendParameter) {
					Mapping mapping = QVTimperativeUtil.getContainingMapping(eObject);
					if (entryPoint == mapping) {
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
			entryPointsAnalysis.analyzeStatements(setStatements);
			//
			analyzeProperties();
		}
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

	public @NonNull Set<@NonNull CompleteClass> getAllInstancesCompleteClasses() {
		return allInstancesCompleteClasses;
	}

	public @Nullable Integer getCacheIndex(@NonNull OppositePropertyCallExp oppositePropertyCallExp) {
		return oppositePropertyCallExp2cacheIndex.get(oppositePropertyCallExp);
	}

	public @NonNull EntryPoint getEntryPoint() {
		return entryPoint;
	}

	public @NonNull EntryPointsAnalysis getEntryPointsAnalysis() {
		return entryPointsAnalysis;
	}

	//		public @NonNull Set<@NonNull Mapping> getHazardousMappings() {
	//			return hazardousMappings;
	//		}

	//		public @NonNull Map<@NonNull Mapping, @NonNull Set<@NonNull NavigationCallExp>> getMapping2Property() {
	//			return mapping2property;
	//		}

	//		public @NonNull Map<Mapping, @NonNull Set<@NonNull SetStatement>> getMapping2SetStatements() {
	//			return mapping2propertyAssignments;
	//		}

	public @NonNull List<@NonNull Mapping> getMappings() {
		return mappings;
	}

	public boolean isHazardous(@NonNull Mapping mapping) {
		return hazardousMappings.contains(mapping);
	}
}