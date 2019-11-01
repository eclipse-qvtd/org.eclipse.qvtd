/*******************************************************************************
 * Copyright (c) 2013, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.runtime.internal.evaluation;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibPackage;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.runtime.evaluation.AbstractObjectManager;
import org.eclipse.qvtd.runtime.evaluation.SlotState;

/**
 * An AbstractObjectState supports the slot states of an EObject.
 *
 * FIXME A BasicObjectState has some duplication of EObject. In due course BasicObjectState should
 * fully replace intermediate EObjects and eventually all EObjects.
 */
public abstract class AbstractObjectState<@NonNull SS extends SlotState> implements ObjectState
{
	protected final @NonNull AbstractObjectManager<@NonNull SS> objectManager;
	protected final @NonNull Object eObject;
	protected final boolean isLoaded;
	/**	 * FIXME The Map of feature to SlotState should be replaced by compile-time computed indexes into an array
	 * of SlotState (for singly inherited objects). A Map may be necessary for multiple inheritance.
	 */
	protected @Nullable Map<@NonNull EStructuralFeature, @NonNull SS> feature2slotState = null;

	public AbstractObjectState(@NonNull AbstractObjectManager<SS> objectManager, @NonNull Object eObject) {
		this.objectManager = objectManager;
		this.eObject = eObject;
		this.isLoaded = ((eObject instanceof EObject) && ((EObject)eObject).eResource() != null);
	}

	public void assigned(@NonNull EStructuralFeature eFeature, @Nullable Object ecoreValue) {
		@Nullable SS slotState = basicGetSlotState(eFeature);
		if (slotState != null) {
			slotState.assigned(eObject, eFeature, ecoreValue);
		}
		else {
			slotState = getSlotState(eFeature, ecoreValue);
			assert basicGetSlotState(eFeature) == slotState;
		}
	}

	public @Nullable SS basicGetSlotState(@NonNull EStructuralFeature eFeature) {
		return feature2slotState != null ? feature2slotState.get(eFeature) : null;
	}

	public @NonNull Iterable<@NonNull SS> getFeatures() {
		return feature2slotState != null ? ClassUtil.nullFree(feature2slotState.values()) : Collections.emptyList();
	}


	@Override
	public @NonNull Object getObject() {
		return eObject;
	}

	public @NonNull AbstractObjectManager<@NonNull SS> getObjectManager() {
		return objectManager;
	}

	public @NonNull SS getSlotState(@NonNull EStructuralFeature eFeature, @Nullable Object ecoreValue) {
		@Nullable SS slotState = basicGetSlotState(eFeature);
		//
		//	Already known
		//
		if (slotState != null) {
			return slotState;
		}
		//
		//	1:1 unidirectional
		//
		if (eFeature instanceof EAttribute) {
			slotState = objectManager.createSimpleSlotState(this, (EAttribute)eFeature, ecoreValue);
			putSlotState(eFeature, slotState);
			return slotState;
		}
		EReference eReference = (EReference)eFeature;
		EReference eOppositeReference = objectManager.getEOppositeReference(eReference);
		Object eOpposite = ecoreValue != null ? ecoreValue : AbstractObjectManager.NOT_A_VALUE;
		//
		//	1:N contained, N:M, 1:N not-contained, N:1
		//
		if (eReference == OCLstdlibPackage.Literals.OCL_ELEMENT__OCL_CONTAINER) {
			slotState = objectManager.createOclContainerSlotState(this, eReference, eOpposite);
		}
		else if (eOppositeReference.isMany()) {
			if (eReference.isMany()) {
				slotState = objectManager.createManyToManySlotState(this, eReference);
			}
			else {
				slotState = objectManager.createOneToManyElementSlotState(this, eReference, eOpposite);
			}
		}
		else if (eReference.isMany()) {
			slotState = objectManager.createOneToManyAggregatorSlotState(this, eReference, eOpposite);
		}
		if (slotState != null) {
			putSlotState(eReference, slotState);
			return slotState;
		}
		//
		//	1:1 bidirectional opposite exists
		//
		AbstractObjectState<@NonNull SS> oppositeObjectState = null;
		if ((ecoreValue != null) && (ecoreValue != AbstractObjectManager.NOT_A_VALUE)) {
			oppositeObjectState = objectManager.getObjectState(ecoreValue);
			slotState = oppositeObjectState.basicGetSlotState(eOppositeReference);
			if (slotState != null) {
				putSlotState(eReference, slotState);
				return slotState;
			}
		}
		//
		//	1:1 bidirectional new
		//
		if (!(eReference instanceof EOppositeReferenceImpl) || (ecoreValue == AbstractObjectManager.NOT_A_VALUE)) {
			slotState = objectManager.createOneToOneSlotState(this, eReference, ecoreValue);
			if (oppositeObjectState != null) {
				oppositeObjectState.putSlotState(eOppositeReference, slotState);
			}
		}
		else {
			assert ecoreValue != null;
			assert oppositeObjectState != null;
			slotState = objectManager.createOneToOneSlotState(oppositeObjectState, eOppositeReference, eObject);
			oppositeObjectState.putSlotState(eOppositeReference, slotState);
		}
		putSlotState(eReference, slotState);
		return slotState;
	}

	protected void putSlotState(@NonNull EStructuralFeature eFeature, @NonNull SS slotState) {
		Map<@NonNull EStructuralFeature, @NonNull SS> feature2slotState2 = feature2slotState;
		if (feature2slotState2 == null) {
			feature2slotState = feature2slotState2 = new HashMap<>();
		}
		/*@Nullable SS oldSlotState =*/ feature2slotState2.put(eFeature, slotState);
		// assert oldSlotState == null; FIXME testQVTcCompiler_SimpleUML2RDBMS_CG changes for one-to-many
	}

	@Override
	public String toString() {
		return eObject.toString();
	}
}