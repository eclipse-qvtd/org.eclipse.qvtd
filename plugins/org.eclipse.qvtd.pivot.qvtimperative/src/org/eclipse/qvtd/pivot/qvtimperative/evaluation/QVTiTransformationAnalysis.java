/*******************************************************************************
 * Copyright (c) 2013 E.D.Willink and others.
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
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.OppositePropertyCallExp;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.OperationId;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtimperative.MiddlePropertyAssignment;
import org.eclipse.qvtd.pivot.qvtimperative.MiddlePropertyCallExp;

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
	protected final @NonNull PivotMetamodelManager metamodelManager;

	/**
	 *  Set of all types for which allInstances() is invoked.
	 */
	private @NonNull Set<org.eclipse.ocl.pivot.Class> allInstancesClasses = new HashSet<org.eclipse.ocl.pivot.Class>();

	/**
	 *  Map from navigable property to sequential index.
	 */
	private @NonNull Map<Property, Integer> property2cacheIndex = new HashMap<Property, Integer>();

	/**
	 *  Map from opposite property to sequential index.
	 */
	private @NonNull Map<Property, Integer> opposite2cacheIndex = new HashMap<Property, Integer>();

	public QVTiTransformationAnalysis(@NonNull PivotMetamodelManager metamodelManager) {
	    this.metamodelManager = metamodelManager;
	}

	public void analyzeTransformation(@NonNull Transformation transformation) {
		//
		//	First pass
		//  - identify all allInstances() source types
		//  - identify all MiddlePropertyAssignments
		//  - identify all MiddlePropertyCallExp and allocate a cacheIndex
		//
		Type oclElementType = metamodelManager.getStandardLibrary().getOclElementType();
		OperationId allInstancesOperationId = oclElementType.getTypeId().getOperationId(0, "allInstances", IdManager.getParametersId());
		List<MiddlePropertyAssignment> middlePropertyAssignments = new ArrayList<MiddlePropertyAssignment>();
		for (TreeIterator<EObject> tit = transformation.eAllContents(); tit.hasNext(); ) {
			EObject eObject = tit.next();
			if (eObject instanceof MiddlePropertyCallExp) {
				MiddlePropertyCallExp middlePropertyCallExp = (MiddlePropertyCallExp)eObject;
				Property navigableProperty = middlePropertyCallExp.getReferredProperty();
				if (navigableProperty != null) {
					int cacheIndex = getCacheIndex(navigableProperty);
					middlePropertyCallExp.setCacheIndex(cacheIndex);
				}
			}
			else if (eObject instanceof MiddlePropertyAssignment) {
				middlePropertyAssignments.add((MiddlePropertyAssignment)eObject);
			}
			else if (eObject instanceof OperationCallExp) {
				OperationCallExp operationCallExp = (OperationCallExp)eObject;
				Operation referredOperation = operationCallExp.getReferredOperation();
				if ((referredOperation != null) && (referredOperation.getOperationId() == allInstancesOperationId)) {
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
			}
			else if (eObject instanceof OppositePropertyCallExp) {
				OppositePropertyCallExp oppositePropertyCallExp = (OppositePropertyCallExp)eObject;
				Property referredProperty = oppositePropertyCallExp.getReferredProperty();
				if (referredProperty != null) {
					getOppositeCacheIndex(referredProperty);
				}
			}
		}
		//
		//	Second pass
		//  - install cacheIndex allocated to MiddlePropertyCallExp in each MiddlePropertyAssignment
		//
		for (MiddlePropertyAssignment middlePropertyAssignment : middlePropertyAssignments) {
			Property navigableProperty = middlePropertyAssignment.getTargetProperty();
			if (navigableProperty != null) {
				Integer cacheIndex = property2cacheIndex.get(navigableProperty);
				if (cacheIndex != null) { 		// No need to set cacheIndex if it is never accessed by a MiddlePropertyCallExp
					middlePropertyAssignment.setCacheIndex(cacheIndex);
				}
			}
		}
	}
	
	public @NonNull Set<org.eclipse.ocl.pivot.Class> getAllInstancesClasses() {
		return allInstancesClasses;
	}
	
	protected int getCacheIndex(@NonNull Property navigableProperty) {
		Integer cacheIndex = property2cacheIndex.get(navigableProperty);
		if (cacheIndex == null) { 
			cacheIndex = property2cacheIndex.size();
			property2cacheIndex.put(navigableProperty, cacheIndex);
		}
		return cacheIndex;
	}

	public int getCacheIndexes() {
		return property2cacheIndex.size();
	}

	/**
	 * Return a Map from each instanceClasses to the subset of instanceClasses that are transitive superClasses of the particular instanceClass.
	 */
	public @NonNull Map<org.eclipse.ocl.pivot.Class, List<org.eclipse.ocl.pivot.Class>> getInstancesClassAnalysis(@NonNull Iterable<org.eclipse.ocl.pivot.Class> instanceClasses) {
		Map<org.eclipse.ocl.pivot.Class, List<org.eclipse.ocl.pivot.Class>> instancesClassAnalysis = new HashMap<org.eclipse.ocl.pivot.Class, List<org.eclipse.ocl.pivot.Class>>();
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

	public @NonNull PivotMetamodelManager getMetamodelManager() {
		return metamodelManager;
	}
	
	protected int getOppositeCacheIndex(@NonNull Property oppositeProperty) {
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
	}
}
