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
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibPackage;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.runtime.evaluation.AbstractObjectManager;
import org.eclipse.qvtd.runtime.evaluation.SlotState;
import org.eclipse.qvtd.runtime.evaluation.SlotState.Speculating;

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
	//	protected final boolean isLoaded;
	/**	 * FIXME The Map of feature to SlotState should be replaced by compile-time computed indexes into an array
	 * of SlotState (for singly inherited objects). A Map may be necessary for multiple inheritance.
	 */
	protected @Nullable Map<@NonNull EStructuralFeature, @NonNull SS> feature2slotState = null;

	public AbstractObjectState(@NonNull AbstractObjectManager<SS> objectManager, @NonNull Object eObject) {
		this.objectManager = objectManager;
		this.eObject = eObject;
		//		this.isLoaded = ((eObject instanceof EObject) && ((EObject)eObject).eResource() != null);
	}

	public void assigned(@NonNull EStructuralFeature eFeature, @Nullable Object ecoreValue, boolean isPartial) {
		@Nullable SS slotState = basicGetSlotState(eFeature);
		if (slotState != null) {
			slotState.assigned(eObject, eFeature, ecoreValue, isPartial);
		}
		else {
			slotState = updateSlotState(eFeature, ecoreValue, isPartial);
			assert basicGetSlotState(eFeature) == slotState;
		}
	}

	public @Nullable SS basicGetSlotState(@NonNull EStructuralFeature eFeature) {
		return feature2slotState != null ? feature2slotState.get(eFeature) : null;
	}

	protected abstract @NonNull SS createManyToManySlotState(@NonNull EReference eReference);

	protected abstract @NonNull SS createOclContainerSlotState(@NonNull EReference eReference, @NonNull Object ecoreValue);

	protected abstract @NonNull SS createOneToManyAggregatorSlotState(@NonNull EReference eReference, @NonNull Object ecoreValue);

	protected abstract @NonNull SS createOneToManyElementSlotState(@NonNull EReference eReference, @NonNull EReference eOppositeReference, @NonNull Object eAggregator);

	protected abstract @NonNull SS createOneToOneSlotState(@NonNull EReference eReference, @Nullable Object ecoreValue);

	protected abstract @NonNull SS createSimpleSlotState(@NonNull EAttribute eFeature, @Nullable Object ecoreValue);

	protected abstract @NonNull Speculating createSpeculatingSlotState(@NonNull EAttribute eFeature);

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

	public @NonNull Speculating getSpeculatingSlotState(@NonNull EAttribute successAttribute) { //, @Nullable Speculating outputSpeculatingSlotState) {
		assert successAttribute.getEType() == EcorePackage.Literals.EBOOLEAN_OBJECT;
		@Nullable SS slotState = basicGetSlotState(successAttribute);
		@Nullable Speculating speculatingSlotState;
		if (slotState == null) {
			speculatingSlotState = createSpeculatingSlotState(successAttribute);
			@SuppressWarnings("unchecked")
			SS castSlotState = (SS)speculatingSlotState;
			putSlotState(successAttribute, castSlotState);
		}
		else {
			speculatingSlotState = (Speculating)slotState;
		}
		return speculatingSlotState;
	}

	/**
	 * Update the eFeature SlotState of this ObjectState with an ecoreValue as a consequence of ecoreValue being
	 * obtained by an eGet().
	 */
	public @NonNull SS gotSlotState(@NonNull EStructuralFeature eFeature, @Nullable Object ecoreValue) {
		assert ecoreValue != AbstractObjectManager.NOT_A_VALUE;
		@Nullable SS slotState = basicGetSlotState(eFeature);
		if (slotState == null) {
			slotState = updateSlotState(eFeature, ecoreValue, false);
		}
		else if (!slotState.isAssigned() && !eFeature.isMany()) {
			slotState.assigned(eObject, eFeature, ecoreValue, false);
		}
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

	/**
	 * Assign or create the eFeature SlotState of this ObjectState with an ecoreValue as a consequence of ecoreValue being
	 * assigned by an eSet() / eGet().add().
	 */
	public @NonNull SS updateSlotState(@NonNull EStructuralFeature eFeature, @Nullable Object ecoreValue, boolean isPartial) {
		@Nullable SS slotState = basicGetSlotState(eFeature);
		//
		//	Already known
		//
		if (slotState != null) {
			if (ecoreValue != AbstractObjectManager.NOT_A_VALUE) {
				slotState.assigned(eObject, eFeature, ecoreValue, isPartial);
			}
			return slotState;
		}
		//
		//	1:1 unidirectional
		//
		if (eFeature instanceof EAttribute) {
			EAttribute eAttribute = (EAttribute)eFeature;
			if ((eFeature.getEType() == EcorePackage.Literals.EBOOLEAN_OBJECT) && objectManager.maybeSpeculated(eAttribute)) {
				//	assert ecoreValue == AbstractObjectManager.NOT_A_VALUE;
				assert ecoreValue != null;
				Speculating speculatingSlotState = createSpeculatingSlotState(eAttribute);
				if (ecoreValue != AbstractObjectManager.NOT_A_VALUE) {
					speculatingSlotState.setStatus((Boolean)ecoreValue);
				}
				@SuppressWarnings("unchecked")
				SS castSpeculatingSlotState = (@NonNull SS) speculatingSlotState;
				slotState = castSpeculatingSlotState;
			}
			else {
				slotState = createSimpleSlotState(eAttribute, ecoreValue);
			}
			putSlotState(eFeature, slotState);
			return slotState;
		}
		EReference eReference = (EReference)eFeature;
		EReference eOppositeReference = objectManager.getEOppositeReference(eReference);
		Object eOpposite = ecoreValue != null ? ecoreValue : AbstractObjectManager.NOT_A_VALUE;
		//
		//	1:N contained
		//
		if (eReference == OCLstdlibPackage.Literals.OCL_ELEMENT__OCL_CONTAINER) {
			slotState = createOclContainerSlotState(eReference, eOpposite);
			putSlotState(eReference, slotState);
			return slotState;
		}
		if (eOppositeReference.isMany()) {
			//
			//	N:M
			//
			if (eReference.isMany()) {
				slotState = createManyToManySlotState(eReference);
				putSlotState(eReference, slotState);
				return slotState;
			}
			//
			//	1:N not-contained
			//
			else {
				slotState = createOneToManyElementSlotState(eReference, eOppositeReference, eOpposite);
				putSlotState(eReference, slotState);
				return slotState;
			}
		}
		//
		//	N:1
		//
		if (eReference.isMany()) {
			slotState = createOneToManyAggregatorSlotState(eReference, AbstractObjectManager.NOT_A_VALUE);
			putSlotState(eReference, slotState);
			if (isPartial) {
				AbstractObjectState<@NonNull SS> elementObjectState = objectManager.getObjectState(eOpposite);
				elementObjectState.updateSlotState(eOppositeReference, eObject, false);					// assignedSlot is a side effect
			}
			else if ((ecoreValue != null) && (ecoreValue != AbstractObjectManager.NOT_A_VALUE)) {
				@SuppressWarnings("unchecked")
				Iterable<? extends EObject> ecoreValues = (Iterable<? extends EObject>)ecoreValue;
				for (EObject element : ecoreValues) {
					if (element != null) {
						AbstractObjectState<@NonNull SS> elementObjectState = objectManager.getObjectState(element);
						elementObjectState.updateSlotState(eOppositeReference, eObject, false);			// assignedSlot is a side effect
					}
				}
			}
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
			slotState = createOneToOneSlotState(eReference, ecoreValue);
			if (oppositeObjectState != null) {
				oppositeObjectState.putSlotState(eOppositeReference, slotState);
			}
			putSlotState(eReference, slotState);
		}
		//
		//	1:1 bidirectional inverse
		//
		else {
			assert ecoreValue != null;
			assert oppositeObjectState != null;
			slotState = oppositeObjectState.createOneToOneSlotState(eOppositeReference, eObject);
			oppositeObjectState.putSlotState(eOppositeReference, slotState);
			putSlotState(eReference, slotState);
		}
		return slotState;
	}
}