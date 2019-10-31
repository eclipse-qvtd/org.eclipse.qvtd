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
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.EReferenceImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.EMOFExtendedMetaData;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.utilities.PivotConstantsInternal;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibPackage;
import org.eclipse.ocl.pivot.utilities.LabelUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.NumberValue;
import org.eclipse.ocl.pivot.values.UnlimitedNaturalValue;

/**
 * AbstractObjectManager provides the mandatory shared functionality for an object state manager.
 */
public abstract class AbstractObjectManager<SS extends SlotState> implements ObjectManager
{
	protected static final @NonNull List<@NonNull SlotState> EMPTY_SLOT_STATE_LIST = Collections.emptyList();

	/**
	 * An AutoAssigningHashMap supports the slots in an input model by automatically marking
	 * each slot ASSIGNED as soon as its SlotState is registered.
	 */
	private static final class AutoAssigningHashMap<@NonNull SS extends SlotState> extends HashMap<@NonNull EStructuralFeature, SS>
	{
		// FIXME missing /*@NonNull*/ SlotState works around JDT limitation

		private final @NonNull Object eObject;

		private static final long serialVersionUID = 1L;

		private AutoAssigningHashMap(@NonNull Object eObject) {
			this.eObject = eObject;
		}

		@Override
		public SS put(@NonNull EStructuralFeature eFeature, /*@NonNull*/ SS slotState) {
			SS oldSlotState = super.put(eFeature, slotState);
			if ((oldSlotState == null) && !(eFeature instanceof EOppositeReferenceImpl)) {
				slotState.assigned(eObject, eFeature, ((EObject)eObject).eGet(eFeature));
			}
			return oldSlotState;
		}
	}

	/**
	 * EOppositeReferenceImpl is used internally to reify the missing EReference.eOpposite. The instances should not be used
	 * externally since they violate many WFRs. Only getEOpposite() is useful.
	 */
	protected static class EOppositeReferenceImpl extends EReferenceImpl
	{
		public EOppositeReferenceImpl(@NonNull EReference eReference) {
			assert eOpposite == null;
			setEOpposite(eReference);
			assert eOpposite == eReference;
		}

		@Override
		public EClass basicGetEReferenceType() {
			throw new UnsupportedOperationException();
		}

		@Override
		public EClassifier basicGetEType() {
			throw new UnsupportedOperationException();
		}

		@Override
		public EClass getEContainingClass() {
			return eOpposite.getEReferenceType();
		}

		@Override
		public EGenericType getEGenericType() {
			throw new UnsupportedOperationException();
		}

		@Override
		public EClass getEReferenceType() {
			return eOpposite.getEContainingClass();
		}

		@Override
		public EClassifier getEType() {
			return eOpposite.getEContainingClass();
		}

		@Override
		public String getName() {
			return "«opposite»" + eOpposite.getName();
		}

		@Override
		public String getNameGen() {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean isChangeable() {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean isContainer() {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean isContainment() {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean isDerived() {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean isTransient() {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean isVolatile() {
			throw new UnsupportedOperationException();
		}
	}

	protected final @NonNull InvocationManager invocationManager;
	protected final boolean debugAssignments = AbstractTransformer.ASSIGNMENTS.isActive();
	protected final boolean debugGettings = AbstractTransformer.GETTINGS.isActive();
	//	protected final boolean debugInvocations = AbstractTransformer.INVOCATIONS.isActive();

	/**
	 * This unpleasant Map of Maps is a pathfinder before embarking on slotted objects that merge user and overhead
	 * in a single object. The first map is then a null lookup and the nested map is an index within the object.
	 */
	protected @NonNull Map<@NonNull Object, @NonNull Map<@NonNull EStructuralFeature, @NonNull SS>> object2feature2slotState = new HashMap<>();

	/**
	 * Map of helper objects to reify missing EReference::eOpposites. Only used as a semantically inverse handle on the available EReference.
	 */
	private @NonNull Map<@NonNull EReference, @NonNull EOppositeReferenceImpl> eReference2eOppositeReference = new HashMap<>();

	protected AbstractObjectManager(@NonNull InvocationManager invocationManager) {
		this.invocationManager = invocationManager;
	}

	@Override
	public <R> R accept(@NonNull ExecutionVisitor<R> visitor) {
		return visitor.visitObjectManager(this);
	}

	@Deprecated /* @deprecated childKey not used */
	@Override
	public synchronized void assigned(@NonNull Object eObject, /*@NonNull*/ EStructuralFeature eFeature, @Nullable Object ecoreValue, @Nullable Object childKey) {
		assigned(eObject, eFeature, ecoreValue);
	}

	@Deprecated /* @deprecated childKey not used */
	@Override
	public void assigned(Invocation.@NonNull Incremental invocation, @NonNull Object eObject, EStructuralFeature eFeature, @Nullable Object ecoreValue, @Nullable Object childKey) {
		assigned(invocation, eObject, eFeature, ecoreValue);
	}

	@Override
	public synchronized void assigned(@NonNull Object eObject, /*@NonNull*/ EStructuralFeature eFeature, @Nullable Object ecoreValue) {
		assert eFeature != null;
		if (debugAssignments) {
			boolean isOpposite = false;
			StringBuilder s = new StringBuilder();
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
		Map<@NonNull EStructuralFeature, @NonNull SS> objectState = getObjectState(eObject);
		SS slotState = objectState.get(eFeature);
		if (slotState != null) {
			slotState.assigned(eObject, eFeature, ecoreValue);
		}
		else {
			if (eFeature instanceof EAttribute) {
				slotState = createSimpleSlotState(eObject, (EAttribute)eFeature, ecoreValue);
			}
			else {
				Object ecoreValue2 = ecoreValue;
				EReference eReference = (EReference)eFeature;
				EReference eOppositeReference = getEOppositeReference(eReference);
				if (!(eOppositeReference instanceof EOppositeReferenceImpl)) {
					//					if (ecoreValue2 != null) {
					//						Map<EStructuralFeature, SlotState> oppositeObjectState = getObjectState((EObject) ecoreValue2);
					//						SlotState oppositeSlotState = oppositeObjectState.get(eOppositeReference);
					//					}
					if (eReference.isMany()) {
						assert ecoreValue2 != null;
						if (eOppositeReference.isMany()) {
							slotState = createManyToManySlotState(eObject, eReference, eOppositeReference);
						}
						else {
							slotState = createOneToManyAggregatorSlotState(eObject, eReference, eOppositeReference, ecoreValue2);
						}
					}
					else if (ecoreValue2 != null) {
						if (eOppositeReference.isMany()) {
							slotState = createOneToManyElementSlotState(eObject, eReference, eOppositeReference, ecoreValue2);
						}
						//						else if (isIncremental) {
						//							slotState = OneToOneSlotState.create(this, eObject, eReference, eOppositeReference, ecoreValue2);
						//						}
						else {
							slotState = createOneToOneSlotState(eObject, eReference, eOppositeReference, ecoreValue2);
						}
					}
					else {
						slotState = createOneToOneSlotState(eObject, eReference, eOppositeReference, ecoreValue2);
					}
				}
				else if (eReference.isContainment()) {
					assert ecoreValue2 != null;
					eOppositeReference = OCLstdlibPackage.Literals.OCL_ELEMENT__OCL_CONTAINER;
					assert eOppositeReference != null;
					if (eReference.isMany()) {
						assert eOppositeReference != null;
						slotState = createOneToManyAggregatorSlotState(eObject, eReference, eOppositeReference, ecoreValue2);
					}
					else {
						Map<@NonNull EStructuralFeature, @NonNull SS> oppositeObjectState = getObjectState(ecoreValue2);
						slotState = oppositeObjectState.get(eOppositeReference);
						if (slotState != null) {
							assert eOppositeReference != null;
							slotState.assigned(ecoreValue2, eOppositeReference, eObject);
						}
						else {
							assert eOppositeReference != null;
							slotState = createOneToOneSlotState(eObject, eReference, eOppositeReference, ecoreValue2);
						}
					}
				}
				//				else if (eReference == OCLstdlibPackage.Literals.OCL_ELEMENT__OCL_CONTAINER) {
				//					slotState = OneToOneSlotState.create(this, eObject, eReference, eOppositeReference, (EObject)ecoreValue2);
				//				}
				else {						// Unidirectional non-containment EReference
					if (ecoreValue2 != null) {
						//						eOppositeReference = getEOppositeReference(eReference);
						Map<@NonNull EStructuralFeature, @NonNull SS> oppositeObjectState = getObjectState(ecoreValue2);
						slotState = oppositeObjectState.get(eOppositeReference);
						if (slotState == null) {
							if (eOppositeReference.isMany()) {
								slotState = createOneToManyElementSlotState(eObject, eReference, eOppositeReference, ecoreValue2);
							}
							else if (eReference.isMany()) {
								slotState = createOneToManyAggregatorSlotState(eObject, eReference, /*eOppositeReference,*/ ecoreValue2);
								oppositeObjectState.put(eOppositeReference, slotState);
							}
							else {
								slotState = createOneToOneSlotState(eObject, eReference, /*eOppositeReference,*/ ecoreValue2);
								oppositeObjectState.put(eOppositeReference, slotState);
							}
						}
						else {
							slotState.assigned(ecoreValue2, eOppositeReference, eObject);
						}
					}
					else {
						slotState = createOneToOneSlotState(eObject, eReference, eOppositeReference, ecoreValue2);

					}
				}
			}
			objectState.put(eFeature, slotState);
		}
	}

	public @Nullable Map<@NonNull EStructuralFeature, @NonNull SS> basicGetObjectState(@NonNull Object eObject) {
		return object2feature2slotState.get(eObject);
	}

	public @Nullable SS basicGetSlotState(@NonNull Object eObject, @NonNull EStructuralFeature eFeature) {
		assert eFeature != null;
		Map<@NonNull EStructuralFeature, @NonNull SS> objectState = basicGetObjectState(eObject);
		if (objectState == null) {
			return null;
		}
		return objectState.get(eFeature);
	}

	protected abstract @NonNull SS createContainmentSlotState(@NonNull Object eObject, @NonNull EReference eReference);

	protected @NonNull Map<@NonNull EStructuralFeature, @NonNull SS> createFeature2State(@NonNull Object eObject) {
		Map<@NonNull EStructuralFeature, @NonNull SS> feature2state;
		Resource eResource = null;
		if (eObject instanceof EObject) {
			eResource = ((EObject)eObject).eResource();
		}
		if (eResource != null) {
			Map<@NonNull EStructuralFeature, @NonNull SS> autoAssigningHashMap = new AutoAssigningHashMap<>(eObject);
			feature2state = autoAssigningHashMap;
		}
		else {
			feature2state = new HashMap<>();
		}
		return feature2state;
	}

	protected @NonNull SS createManyToManySlotState(@NonNull Object eObject, @NonNull EReference eFeature, @NonNull EReference eOppositeFeature) {
		throw new UnsupportedOperationException();
	}

	protected abstract @NonNull SS createOclContainerSlotState(@NonNull Object eObject, @NonNull EReference eReference);

	protected abstract @NonNull SS createOneToManyAggregatorSlotState(@NonNull Object eObject, @NonNull EReference eFeature,
			@NonNull EReference eOppositeFeature, @Nullable Object eContents);

	protected abstract @NonNull SS createOneToManyAggregatorSlotState(@NonNull Object eObject, @NonNull EReference eReference,
			@NonNull Object ecoreValue);

	protected abstract @NonNull SS createOneToManyElementSlotState(@NonNull Object eObject, @NonNull EReference eFeature,
			@NonNull EReference eOppositeFeature, @NonNull Object eAggregator);

	protected abstract @NonNull SS createOneToOneSlotState(@NonNull Object eObject, @NonNull EReference eFeature,
			@NonNull EReference eOppositeFeature, @Nullable Object eOpposite);

	protected abstract @NonNull SS createOneToOneSlotState(@NonNull Object eObject, @NonNull EReference eReference,
			@NonNull Object ecoreValue);

	protected abstract @NonNull SS createReferenceSlotState(@NonNull Object eObject, @NonNull EReference eReference,
			@NonNull EReference eOppositeReference);

	protected abstract @NonNull SS createSimpleSlotState(@NonNull Object eObject, @NonNull EAttribute eFeature);

	protected abstract @NonNull SS createSimpleSlotState(@NonNull Object eObject, @NonNull EAttribute eFeature, @Nullable Object ecoreValue);

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

	public @NonNull Map<@NonNull EStructuralFeature, @NonNull SS> getObjectState(@NonNull Object eObject) {
		Map<@NonNull EStructuralFeature, @NonNull SS> feature2state = object2feature2slotState.get(eObject);
		if (feature2state == null) {
			feature2state = createFeature2State(eObject);
			object2feature2slotState.put(eObject, feature2state);
		}
		return feature2state;
	}

	@Override
	public @NonNull Iterable<@NonNull ? extends Object> getObjects() {
		return object2feature2slotState.keySet();
	}

	public synchronized @NonNull SS getSlotState(@NonNull Object eObject, @NonNull EStructuralFeature eFeature) {
		Map<@NonNull EStructuralFeature, @NonNull SS> objectState = getObjectState(eObject);
		SS slotState = objectState.get(eFeature);
		if (slotState == null) {
			if (eFeature instanceof EAttribute) {
				slotState = createSimpleSlotState(eObject, (EAttribute) eFeature);
			}
			else {
				EReference eReference = (EReference)eFeature;
				EReference eOppositeReference = getEOppositeReference(eReference);
				if (eReference instanceof EOppositeReferenceImpl) {
					slotState = createReferenceSlotState(eObject, eReference, eOppositeReference);
				}
				else if (!(eOppositeReference instanceof EOppositeReferenceImpl)) {
					slotState = createReferenceSlotState(eObject, eReference, eOppositeReference);
				}
				else if (eReference.isContainment()) {
					slotState = createContainmentSlotState(eObject, eReference);
				}
				else if (eReference == OCLstdlibPackage.Literals.OCL_ELEMENT__OCL_CONTAINER) {
					slotState = createOclContainerSlotState(eObject, eReference);
				}
				else {						// Unidirectional non-containment EReference
					slotState = createReferenceSlotState(eObject, eReference, eOppositeReference);
				}
			}
			objectState.put(eFeature, slotState);
		}
		return slotState;
	}

	@Override
	public @NonNull Iterable<@NonNull SS> getSlotStates(@NonNull Object object) {
		Map<@NonNull EStructuralFeature, @NonNull SS> feature2slotState = object2feature2slotState.get(object);
		if (feature2slotState != null) {
			return feature2slotState.values();
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
		SS slotState = getSlotState(eObject, eFeature);
		slotState.getting(eObject, eFeature);
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
}