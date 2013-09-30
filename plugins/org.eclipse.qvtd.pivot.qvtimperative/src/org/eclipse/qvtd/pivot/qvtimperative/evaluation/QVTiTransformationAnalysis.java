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
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.ids.OperationId;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
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
	protected final @NonNull MetaModelManager metaModelManager;

	/**
	 *  Set of all types for which allInstances() is invoked.
	 */
	private @NonNull Set<Type> allInstancesTypes = new HashSet<Type>();

	/**
	 *  Map from navigable property to sequential index.
	 */
	private @NonNull Map<Property, Integer> property2cacheIndex = new HashMap<Property, Integer>();

	public QVTiTransformationAnalysis(@NonNull MetaModelManager metaModelManager) {
	    this.metaModelManager = metaModelManager;
	}

	public void analyzeTransformation(@NonNull Transformation transformation) {
		//
		//	First pass
		//  - identify all allInstances() source types
		//  - identify all MiddlePropertyAssignments
		//  - identify all MiddlePropertyCallExp and allocate a cacheIndex
		//
		Type oclElementType = metaModelManager.getOclElementType();
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
					OCLExpression source = operationCallExp.getSource();
					if (source != null) {
						Type sourceType = source.getType();
						if (sourceType != null) {
							allInstancesTypes.add(sourceType);
						}
					}
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
	
	public @NonNull Set<Type> getAllInstancesTypes() {
		return allInstancesTypes;
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

	public @NonNull MetaModelManager getMetaModelManager() {
		return metaModelManager;
	}
}
