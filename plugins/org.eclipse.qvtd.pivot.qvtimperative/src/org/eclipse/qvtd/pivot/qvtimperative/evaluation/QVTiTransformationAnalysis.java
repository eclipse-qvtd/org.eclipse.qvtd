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
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.OppositePropertyCallExp;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.OperationId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManagerInternal;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.analysis.DomainUsage;
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
	private final @NonNull Set<org.eclipse.ocl.pivot.Class> allInstancesClasses = new HashSet<org.eclipse.ocl.pivot.Class>();

	/**
	 *  Map from navigable property to sequential index in any TypedModel.
	 */
	private final @NonNull Map<Property, Integer> property2cacheIndex = new HashMap<Property, Integer>();

	/**
	 *  Map from navigable property to sequential index in a checkable TypedModel.
	 */
	private final @NonNull Map<Property, Integer> sourceProperty2cacheIndex = new HashMap<Property, Integer>();

	/**
	 * Map from propertyAssignment to the cache index of an un-navigable lookup cache to be updated by the assignment.
	 */
	private final @NonNull Map<PropertyAssignment, Integer> propertyAssignment2cacheIndex = new HashMap<PropertyAssignment, Integer>();

	/**
	 * Map from oppositePropertyCallExp to the cache index identifying the relevant un-navigable lookup cache.
	 */
	private final @NonNull Map<OppositePropertyCallExp, Integer> oppositePropertyCallExp2cacheIndex = new HashMap<OppositePropertyCallExp, Integer>();;

	/**
	 * @deprecated Use EnvironmentFactoryInternal constructor
	 */
	@Deprecated
	public QVTiTransformationAnalysis(@NonNull MetamodelManagerInternal metamodelManager) {
	    this(metamodelManager.getEnvironmentFactory());
	}

	public QVTiTransformationAnalysis(@NonNull EnvironmentFactoryInternal environmentFactory) {
	    this.environmentFactory = environmentFactory;
		this.domainAnalysis = new QVTimperativeDomainUsageAnalysis(environmentFactory);
	}
	
	protected @NonNull Integer allocateCacheIndex(@Nullable OCLExpression sourceExpression, @NonNull Property navigableProperty) {
		Integer cacheIndex = property2cacheIndex.get(navigableProperty);
		if (cacheIndex == null) { 
			Integer size = property2cacheIndex.size();
			property2cacheIndex.put(navigableProperty, size);
			if (sourceExpression != null) {
				DomainUsage sourceUsage = domainAnalysis.getUsage(sourceExpression);
				if ((sourceUsage != null) && sourceUsage.isCheckable()) {
					sourceProperty2cacheIndex.put(navigableProperty, size);
				}
			}
			cacheIndex = size;
		}
		return cacheIndex;
	}

	public void analyzeTransformation(@NonNull Transformation transformation) {
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
			if (eObject instanceof OppositePropertyCallExp) {
				OppositePropertyCallExp oppositePropertyCallExp = (OppositePropertyCallExp)eObject;
				Property navigableProperty = oppositePropertyCallExp.getReferredProperty();
				if (navigableProperty != null) {
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
							Type sourceType = source.getTypeValue();
							if (sourceType == null) {
								sourceType = source.getType();
							}
							if (sourceType instanceof org.eclipse.ocl.pivot.Class) {
								allInstancesClasses.add((org.eclipse.ocl.pivot.Class)sourceType);
							}
						}
					}
					else if ((operationId == objectsOfKindOperationId) || (operationId == objectsOfTypeOperationId)) {
						OCLExpression argument = operationCallExp.getOwnedArguments().get(0);
						if (argument != null) {
							Type argumentType = argument.getTypeValue();
							if (argumentType == null) {
								argumentType = argument.getType();
							}
							if (argumentType instanceof org.eclipse.ocl.pivot.Class) {
								allInstancesClasses.add((org.eclipse.ocl.pivot.Class)argumentType);
							}
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
					propertyAssignment2cacheIndex.put(propertyAssignment, cacheIndex);
				}
			}
		}
	}
	
	public @NonNull Set<org.eclipse.ocl.pivot.Class> getAllInstancesClasses() {
		return allInstancesClasses;
	}

	public @Nullable Integer getCacheIndex(@NonNull OppositePropertyCallExp oppositePropertyCallExp) {
		return oppositePropertyCallExp2cacheIndex.get(oppositePropertyCallExp);
	}

	public @Nullable Integer getCacheIndex(@NonNull PropertyAssignment propertyAssignment) {
		return propertyAssignment2cacheIndex.get(propertyAssignment);
	}

	public int getCacheIndexes() {
		return property2cacheIndex.size();
	}

	public @NonNull Map<Property, Integer> getCaches() {
		return property2cacheIndex;
	}

	/**
	 * Return a Map from each instanceClasses to the subset of instanceClasses that are transitive superClasses of the particular instanceClass.
	 */
	public @NonNull Map<org.eclipse.ocl.pivot.Class, List<org.eclipse.ocl.pivot.Class>> getInstancesClassAnalysis(@NonNull Iterable<org.eclipse.ocl.pivot.Class> instanceClasses) {
		Map<org.eclipse.ocl.pivot.Class, List<org.eclipse.ocl.pivot.Class>> instancesClassAnalysis = new HashMap<org.eclipse.ocl.pivot.Class, List<org.eclipse.ocl.pivot.Class>>();
		MetamodelManagerInternal metamodelManager = environmentFactory.getMetamodelManager();
		for (@SuppressWarnings("null")@NonNull org.eclipse.ocl.pivot.Class instanceClass : instanceClasses) {
			CompleteClass completeInstanceClass = metamodelManager.getCompleteClass(instanceClass);
			instancesClassAnalysis.put(completeInstanceClass.getPrimaryClass(),  null);
		}
		for (@SuppressWarnings("null")@NonNull org.eclipse.ocl.pivot.Class instanceClass : instancesClassAnalysis.keySet()) {
			List<org.eclipse.ocl.pivot.Class> superInstanceClasses = new ArrayList<org.eclipse.ocl.pivot.Class>();
			superInstanceClasses.add(instanceClass);
			CompleteClass completeClass = metamodelManager.getCompleteClass(instanceClass);
			for (CompleteClass superCompleteClass : completeClass.getProperSuperCompleteClasses()) {
				org.eclipse.ocl.pivot.Class superClass = superCompleteClass.getPrimaryClass();
				if (instancesClassAnalysis.containsKey(superClass)) {
					superInstanceClasses.add(superClass);
				}
				instancesClassAnalysis.put(instanceClass, superInstanceClasses);
			}
		}
		return instancesClassAnalysis;
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
}
