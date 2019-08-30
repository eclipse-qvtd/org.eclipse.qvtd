/*******************************************************************************
 * Copyright (c) 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.runtime.evaluation;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.PropertyId;
import org.eclipse.ocl.pivot.utilities.ClassUtil;

public abstract class AbstractModelsManager implements ModelsManager
{
	/**
	 * Unchanging configured map from the PropertyId for which unnavigable opposite navigation may occur to the PropertyIndex for that PropertyId.
	 */
	private @Nullable Map<@NonNull PropertyId, @NonNull Integer> propertyId2propertyIndex;

	/**
	 * Unchanging configured map from the PropertyIndex to the EReference for the opposite property navigation.
	 */
	private @NonNull EReference @Nullable[] propertyIndex2eReference;

	/**
	 * Unchanging maps from an EObject to its opposite using the Property whose PropertyIndex indexes the map.
	 */
	private @NonNull Map<@NonNull Object, @NonNull Object> @Nullable [] object2oppositeObject;

	private @Nullable Map<@NonNull EReference, @NonNull Integer> eReference2propertyIndex = null;

	public void analyzeInputResources() {
		for (@NonNull TypedModelInstance typedModelInstance : getTypedModelInstances()) {
			typedModelInstance.analyzeInputResources();
		}
	}

	public void analyzeOutputResources() {
		for (@NonNull TypedModelInstance typedModelInstance : getTypedModelInstances()) {
			typedModelInstance.analyzeOutputResources();
		}
	}

	@Override
	public @NonNull Map<@NonNull Object, @NonNull Object>[] getObject2oppositeObject() {
		return object2oppositeObject;
	}

	/**
	 * Return the PropertyIndex corresponding to eReference for which an EClass instance could be the unnavigable opposite.
	 * eReference2propertyIndex contains known equivalences and may be updated if more are discovered.
	 * Returns -1 as the propertyIndex for which no unnavigable opposite is appropriate.
	 */
	@Override
	public int getOppositePropertyIndex(@NonNull EReference eReference) {
		Map<PropertyId, Integer> propertyId2propertyIndex2 = propertyId2propertyIndex;
		if (propertyId2propertyIndex2 == null) {
			return -1;
		}
		Map<@NonNull EReference, @NonNull Integer> eReference2propertyIndex2 = eReference2propertyIndex;
		if (eReference2propertyIndex2 == null) {
			eReference2propertyIndex = eReference2propertyIndex2 =new HashMap<>();
		}
		Integer propertyIndex = eReference2propertyIndex2.get(eReference);
		if (propertyIndex == null) {
			if ((eReference.getEOpposite() == null) && !eReference.isDerived() && !eReference.isTransient() && !eReference.isVolatile()) {
				PropertyId propertyId = IdManager.getPropertyId(eReference);
				propertyIndex = propertyId2propertyIndex2.get(propertyId);
			}
			if (propertyIndex == null) {
				propertyIndex = -1;
			}
			eReference2propertyIndex2.put(eReference, propertyIndex);
		}
		return propertyIndex;
	}

	@Override
	public @NonNull EReference @NonNull [] getPropertyIndex2eReference() {
		return ClassUtil.nonNullState(propertyIndex2eReference);
	}

	public void initOpposites(@NonNull PropertyId @NonNull [] propertyIndex2propertyId) {
		//
		//	Prepare the unnavigable opposite property fields
		//
		int propertyIds = propertyIndex2propertyId.length;
		//	this.propertyIndex2propertyId = propertyIndex2propertyId;
		Map<@NonNull PropertyId, @NonNull Integer> propertyId2propertyIndex2 = new HashMap<>(propertyIds);
		this.propertyId2propertyIndex = propertyId2propertyIndex2;
		this.propertyIndex2eReference = new @NonNull EReference @NonNull [propertyIds];
		//	this.eReference2oppositePropertyId = new HashMap<>();
		for (int propertyIndex = 0; propertyIndex < propertyIds; propertyIndex++) {
			PropertyId propertyId = propertyIndex2propertyId[propertyIndex];
			propertyId2propertyIndex2.put(propertyId, propertyIndex);
		}
		@SuppressWarnings("unchecked")@NonNull Map<@NonNull Object, @NonNull Object> @Nullable [] object2oppositeObject = (@NonNull Map<@NonNull Object, @NonNull Object> @NonNull []) new HashMap<?,?> @NonNull [propertyIds];
		this.object2oppositeObject = object2oppositeObject;
		for (int i = 0; i < propertyIds; i++) {
			object2oppositeObject[i] = new HashMap<>();
		}
	}

	@Deprecated /* @deprecated removing resources is a dubious experimental capability */
	@Override
	public void removeResources() {
		for (@NonNull TypedModelInstance typedModelInstance : getTypedModelInstances()) {
			typedModelInstance.removeInputResources();
			typedModelInstance.removeOutputResources();
		}
	}

	@Override
	public void saveModels(@Nullable Map<?, ?> saveOptions) throws IOException {
		analyzeOutputResources();
		for (@NonNull TypedModelInstance typedModelInstance : getTypedModelInstances()) {
			typedModelInstance.saveResources(saveOptions);
		}
	}
}
