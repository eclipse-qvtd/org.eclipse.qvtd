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
package org.eclipse.qvtd.runtime.evaluation;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.xmi.impl.EMOFExtendedMetaData;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.utilities.PivotConstantsInternal;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.LabelUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.NumberValue;
import org.eclipse.ocl.pivot.values.UnlimitedNaturalValue;
import org.eclipse.qvtd.runtime.internal.evaluation.AbstractObjectState;
import org.eclipse.qvtd.runtime.internal.evaluation.EOppositeReferenceImpl;

/**
 * AbstractObjectManager provides the mandatory shared functionality for an object state manager.
 */
public abstract class AbstractObjectManager<SS extends SlotState> implements ObjectManager
{
	protected static final @NonNull List<@NonNull SlotState> EMPTY_SLOT_STATE_LIST = Collections.emptyList();

	/**
	 * Distinctive value indicating that no value is available to be placed in a slot.
	 */
	public static @NonNull Object NOT_A_VALUE = AbstractObjectManager.class;

	protected final @NonNull InvocationManager invocationManager;
	protected final boolean debugAssignments = AbstractTransformer.ASSIGNMENTS.isActive();
	protected final boolean debugGettings = AbstractTransformer.GETTINGS.isActive();
	//	protected final boolean debugInvocations = AbstractTransformer.INVOCATIONS.isActive();

	/**
	 * This unpleasant Map of Maps is a pathfinder before embarking on slotted objects that merge user and overhead
	 * in a single object. The first map is then a null lookup and the nested map is an index within the object.
	 */
	private @NonNull Map<@NonNull Object, org.eclipse.qvtd.runtime.internal.evaluation.AbstractObjectState<@NonNull SS>> object2objectState = new HashMap<>();

	/**
	 * Map of helper objects to reify missing EReference::eOpposites. Only used as a semantically inverse handle on the available EReference.
	 */
	private @NonNull Map<@NonNull EReference, org.eclipse.qvtd.runtime.internal.evaluation.EOppositeReferenceImpl> eReference2eOppositeReference = new HashMap<>();

	protected AbstractObjectManager(@NonNull InvocationManager invocationManager) {
		this.invocationManager = invocationManager;
	}

	@Override
	public <R> R accept(@NonNull ExecutionVisitor<R> visitor) {
		return visitor.visitObjectManager(this);
	}

	@Override
	public synchronized void assigned(@NonNull Object eObject, /*@NonNull*/ EStructuralFeature eFeature, @Nullable Object ecoreValue, boolean isPartial) {
		assert eFeature != null;
		if (debugAssignments) {
			boolean isOpposite = false;
			StringBuilder s = new StringBuilder();
			if (isPartial) {
				s.append("partial-");
			}
			s.append("assigned ");
			s.append(toDebugString(eObject));
			s.append(".");
			/*s.append(eFeature.getEContainingClass().getName() + "."); */
			s.append(isOpposite ? "~" : "");
			s.append(eFeature.getName());
			s.append(" := ");
			if (ecoreValue instanceof EObject) {
				s.append(toDebugString(ecoreValue));
			}
			else {
				//	s.append("\"");
				s.append(LabelUtil.getLabel(ecoreValue));
				//	s.append("\"");
			}
			AbstractTransformer.ASSIGNMENTS.println(s.toString());
		}
		AbstractObjectState<@NonNull SS> objectState = getObjectState(eObject);
		objectState.assigned(eFeature, ecoreValue, isPartial);
	}

	public @Nullable AbstractObjectState<@NonNull SS> basicGetObjectState(@NonNull Object eObject) {
		return object2objectState.get(eObject);
	}

	public @Nullable SS basicGetSlotState(@NonNull Object eObject, @NonNull EStructuralFeature eFeature) {
		AbstractObjectState<@NonNull SS> objectState = basicGetObjectState(eObject);
		return objectState != null ? objectState.basicGetSlotState(eFeature) : null;
	}

	public abstract @NonNull AbstractObjectState<@NonNull SS> createObjectState(@NonNull Object eObject);

	@Override
	public void destroyed(@NonNull Object eObject) {
		PivotUtilInternal.resetContainer((EObject) eObject);
		object2objectState.remove(eObject);
	}

	@Override
	public @NonNull EReference getEOppositeReference(@NonNull EReference eReference) {
		EReference eOppositeReference = eReference.getEOpposite();
		if (eOppositeReference == null) {
			EOppositeReferenceImpl eOppositeReference2 = eReference2eOppositeReference.get(eReference);
			if (eOppositeReference2 == null) {
				eOppositeReference2 = new EOppositeReferenceImpl(eReference);
				EAnnotation oppositeRole = eReference.getEAnnotation(EMOFExtendedMetaData.EMOF_PROPERTY_OPPOSITE_ROLE_NAME_ANNOTATION_SOURCE);
				if (oppositeRole != null) {
					EMap<String, String> details = oppositeRole.getDetails();
					String oppositeName = details.get(EMOFExtendedMetaData.EMOF_COMMENT_BODY);
					if (oppositeName != null) {
						eOppositeReference2.setName(oppositeName);
						String lowerValue = details.get("lower");
						IntegerValue lower = lowerValue != null ? ValueUtil.integerValueOf(lowerValue) :  PivotConstantsInternal.ANNOTATED_IMPLICIT_OPPOSITE_LOWER_VALUE;
						if (lower.isInvalid()) {
							//							logger.error("Invalid " + PROPERTY_OPPOSITE_ROLE_LOWER_KEY + " " + lower);
							lower = PivotConstantsInternal.ANNOTATED_IMPLICIT_OPPOSITE_LOWER_VALUE;
						}
						eOppositeReference2.setLowerBound(lower.intValue());
						String upperValue = details.get("upper");
						UnlimitedNaturalValue upper = upperValue != null ? ValueUtil.unlimitedNaturalValueOf(upperValue) : PivotConstantsInternal.ANNOTATED_IMPLICIT_OPPOSITE_UPPER_VALUE;
						if (upper.isInvalid()) {
							//							logger.error("Invalid " + PROPERTY_OPPOSITE_ROLE_UPPER_KEY + " " + upper);
							upper = PivotConstantsInternal.ANNOTATED_IMPLICIT_OPPOSITE_UPPER_VALUE;
						}
						eOppositeReference2.setUpperBound(upper.isUnlimited() ? -1 : upper.intValue());
						if (!((NumberValue)upper).equals(ValueUtil.ONE_VALUE)) {
							String uniqueValue = details.get("unique");
							boolean isUnique = uniqueValue != null ? Boolean.valueOf(uniqueValue) : PivotConstantsInternal.ANNOTATED_IMPLICIT_OPPOSITE_UNIQUE;
							eOppositeReference2.setUnique(isUnique);
							String orderedValue = details.get("ordered");
							boolean isOrdered = orderedValue != null ? Boolean.valueOf(orderedValue) : PivotConstantsInternal.ANNOTATED_IMPLICIT_OPPOSITE_ORDERED;
							eOppositeReference2.setOrdered(isOrdered);
						}
					}
				}
				eReference2eOppositeReference.put(eReference, eOppositeReference2);
			}
			eOppositeReference = eOppositeReference2;
		}
		return eOppositeReference;
	}

	public @NonNull AbstractObjectState<@NonNull SS> getObjectState(@NonNull Object eObject) {
		@Nullable AbstractObjectState<@NonNull SS> objectState = object2objectState.get(eObject);
		if (objectState == null) {
			objectState = createObjectState(eObject);
			object2objectState.put(eObject, objectState);
		}
		return objectState;
	}

	@Override
	public @NonNull Iterable<@NonNull Object> getObjects() {
		return  ClassUtil.nullFree(object2objectState.keySet());
	}

	@Override
	public @NonNull Iterable<@NonNull SS> getSlotStates(@NonNull Object object) {
		AbstractObjectState<@NonNull SS> objectState = object2objectState.get(object);
		if (objectState != null) {
			return objectState.getFeatures();
		}
		else {
			return (Iterable<@NonNull SS>)EMPTY_SLOT_STATE_LIST;
		}
	}

	@Override
	public synchronized void getting(@NonNull Object eObject, /*@NonNull*/ EStructuralFeature eFeature, boolean isOpposite) {
		assert eFeature != null;
		if (debugGettings) {
			AbstractTransformer.GETTINGS.println("getting " + toDebugString(eObject) + "." + /*eFeature.getEContainingClass().getName() + "::" +*/ (isOpposite ? "~" : "") + eFeature.getName());
		}
		if (isOpposite) {
			eFeature = getEOppositeReference((EReference) eFeature);
		}
		SS slotState = updateSlotState(eObject, eFeature, NOT_A_VALUE, false);
		slotState.getting(eObject, eFeature);
	}

	/**
	 * Update the eFeature SlotState of eObject with an ecoreValue as a consequence of ecoreValue being
	 * obtained by an eGet().
	 */
	public synchronized @NonNull SS gotSlotState(@NonNull Object eObject, @NonNull EStructuralFeature eFeature, @Nullable Object ecoreValue) {
		AbstractObjectState<@NonNull SS> objectState = getObjectState(eObject);
		return objectState.gotSlotState(eFeature, ecoreValue);
	}

	/**
	 * Return the string rendering of object for use in debug messages. The default just invokes String.valueOf().
	 * Derived implementations may provide metamodel-specific content.
	 */
	public static @NonNull String toDebugString(@Nullable Object object) {		// FIXME make non-static and usefully overrideable
		if (object == null) {
			return "null";
		}
		StringBuilder s = new StringBuilder();
		if (object instanceof EObject) {
			EClass eClass = ((EObject)object).eClass();
			EPackage ePackage = eClass.getEPackage();
			//			EResource eResource = eClass.eResource();
			s.append(ePackage.getName());
			s.append("::");
			s.append(eClass.getName());
		}
		else {
			String className = object.getClass().getName();
			int index = className.lastIndexOf('.');
			if (index >= 0) {
				className = className.substring(index+1);
			}
			s.append(className);
		}
		s.append("@");
		s.append(Integer.toHexString(System.identityHashCode(object)));
		return s.toString();
	}

	public synchronized @NonNull SS updateSlotState(@NonNull Object eObject, @NonNull EStructuralFeature eFeature, @Nullable Object ecoreValue, boolean isPartial) {
		AbstractObjectState<@NonNull SS> objectState = getObjectState(eObject);
		return objectState.updateSlotState(eFeature, ecoreValue, isPartial);
	}
}