/*******************************************************************************
 * Copyright (c) 2013, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.runtime.internal.evaluation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibPackage;
import org.eclipse.qvtd.runtime.evaluation.AbstractObjectManager;
import org.eclipse.qvtd.runtime.evaluation.AbstractSlotState;
import org.eclipse.qvtd.runtime.evaluation.AbstractTransformer;
import org.eclipse.qvtd.runtime.evaluation.Execution;
import org.eclipse.qvtd.runtime.evaluation.Invocation;
import org.eclipse.qvtd.runtime.evaluation.InvocationFailedException;
import org.eclipse.qvtd.runtime.evaluation.SlotState;
import org.eclipse.qvtd.runtime.utilities.QVTruntimeUtil;

public class IncrementalObjectManager extends AbstractObjectManager<IncrementalObjectManager.BasicSlotState>
{
	/**
	 * Simple SlotState describing a DataType element or 1:1 Object navigation.
	 */
	public static abstract class BasicSlotState extends AbstractSlotState.Incremental
	{
		protected final @NonNull Object eObject;
		protected final @NonNull EStructuralFeature eFeature;
		private @Nullable Object value = null;

		protected BasicSlotState(@NonNull Object eObject, @NonNull EStructuralFeature eFeature) {
			super(SlotMode.ASSIGNABLE);
			this.eObject = eObject;
			this.eFeature = eFeature;
		}

		protected BasicSlotState(@NonNull Object eObject, @NonNull EStructuralFeature eFeature, @Nullable Object ecoreValue) {
			super(SlotMode.ASSIGNED);
			this.eObject = eObject;
			this.eFeature = eFeature;
			this.value = ecoreValue;
		}

		public synchronized void assigned(@NonNull IncrementalObjectManager objectManager, @NonNull Object eObject, @NonNull EStructuralFeature eFeature, @Nullable Object ecoreValue) {
			switch (mode) {
				case ASSIGNABLE:
					mode = SlotMode.ASSIGNED;
					unblock(objectManager);
					this.value = ecoreValue;
					break;
				case ASSIGNED:
					if (!(eFeature instanceof EOppositeReferenceImpl)) {
						QVTruntimeUtil.errPrintln("Re-assignment of \"" + toDebugString(eObject) + "\"." + eFeature.getEContainingClass().getName() + "::" + eFeature.getName() + " with \"" + ecoreValue + "\"");
					}
					break;
				case REASSIGNABLE:
					mode = SlotMode.ASSIGNED;
					if (this.value != ecoreValue) {		// FIXME equals() ??
						this.value = ecoreValue;
						revokeTargets();
					}
					unblock(objectManager);
					break;
			}
		}

		@Override
		public void debugUnblock() {
			if (eObject instanceof EObject) {
				Object eProxy = null;
				EObject eObject = ((EObject)this.eObject);
				EClassifier eType = eFeature.getEType();
				if (eType instanceof EClass) {
					EClass eClass = (EClass) eType;
					for (EClassifier eClassifier : eClass.getEPackage().getEClassifiers()) {
						if (eClassifier instanceof EClass) {
							EClass eClass2 = (EClass)eClassifier;
							if (!eClass2.isAbstract() && eClass2.getEAllSuperTypes().contains(eClass)) {
								eClass = eClass2;
							}
						}
					}
					eProxy = eType.getEPackage().getEFactoryInstance().create(eClass);
					if (eProxy instanceof InternalEObject) {
						((InternalEObject)eProxy).eSetProxyURI(URI.createURI("blocked"));
					}
				}
				else {
					try {
						eProxy = eType.getEPackage().getEFactoryInstance().createFromString((EDataType)eType, "");
					}
					catch (Throwable e) {}
				}
				if (eFeature.isMany()) {
					@SuppressWarnings("unchecked")
					List<Object> list = (List<Object>)eObject.eGet(eFeature);
					list.add(eProxy);
				}
				else if (!(eFeature instanceof EOppositeReferenceImpl)) {
					eObject.eSet(eFeature, eProxy);
				}
			}
		}

		@Override
		public @NonNull EStructuralFeature getEFeature() {
			return eFeature;
		}

		@Override
		public SlotState.@NonNull Incremental getPrimarySlotState() {
			return this;
		}

		@Override
		public @Nullable Object getValue() {
			return value;
		}

		@Override
		public synchronized void getting( @NonNull Object eObject, @NonNull EStructuralFeature eFeature) {
			switch (mode) {
				case ASSIGNABLE:
				case REASSIGNABLE:
					throw new InvocationFailedException(this);
				case ASSIGNED:
					break;
			}
		}

		@Override
		public void revokeAssigned() {
			SlotMode mode2 = mode;
			mode = SlotMode.REASSIGNABLE;
			if (mode2 == SlotMode.ASSIGNED) {
				revokeTargets();
			}
		}

		@Override
		public String toString() {
			StringBuilder s = new StringBuilder();
			s.append(toDebugString(eObject));
			s.append(".");
			s.append(eFeature.getEContainingClass().getName());
			s.append("::");
			s.append(eFeature.getName());
			s.append(" ");
			s.append(getClass().getSimpleName());
			s.append("@");
			s.append(Integer.toHexString(System.identityHashCode(this)));
			s.append(" ");
			s.append(mode);
			return s.toString();
		}
	}

	/**
	 * SlotState describing an M:N Object navigation.
	 */
	class ManyToManySlotState extends BasicSlotState
	{
		public ManyToManySlotState(@NonNull Object eObject, @NonNull EStructuralFeature eFeature) {
			super(eObject, eFeature);
			//			throw new UnsupportedOperationException();
		}

		@Override
		public synchronized void assigned(@NonNull Object eObject, @NonNull EStructuralFeature eFeature, @Nullable Object ecoreValue) {
			throw new UnsupportedOperationException();
			// ?? identify the mesh of M:N objects and set all of them assigned
		}
	}

	/**
	 * SlotState describing the aggregator side of a 1:N Object navigation.
	 * <br>
	 * Lifecycle:
	 * Create due to
	 * - get of all elements => ASSIGNABLE, blocked
	 * NO: - get of an aggregator => ASSIGNABLE, blocked
	 * Create due to
	 * - assign of all elements => ASSIGNABLE => ASSIGNED, not blocked
	 * - assign of a first element to the aggregator => ASSIGNABLE, not blocked
	 * Update due to
	 * - assign of a further element to the aggregator => ASSIGNABLE => ASSIGNABLE
	 * Unblock due to
	 * - get of an aggregator ASSIGNABLE => ASSIGNED
	 * - get of all elements ASSIGNABLE => ASSIGNED
	 * Thereafter
	 * - get of an aggregator ASSIGNED => ASSIGNED
	 * - get of all elements ASSIGNED => ASSIGNED
	 * <br>
	 * Lifecycle 2: read first
	 * Create due to
	 * - get of elements => ASSIGNABLE, blocked
	 * Unblock due to
	 * - assign of an element to the aggregator => ASSIGNABLE => ASSIGNED, not blocked
	 * Thereafter
	 * - get of either end ASSIGNED => ASSIGNED
	 * - (assign of either end is an ignored error)
	 */
	class OneToManyAggregatorSlotState extends BasicSlotState
	{
		public OneToManyAggregatorSlotState(@NonNull Object eContainer, @NonNull EStructuralFeature eFeature) {
			super(eContainer, eFeature);
			assert eFeature.isMany();
			//			assert eFeature.getEOpposite() != null;
			//			assert eFeature.getEOpposite().isMany();
		}

		private OneToManyAggregatorSlotState(@NonNull Object eContainer, @NonNull EStructuralFeature eFeature, @Nullable Object eContents) {
			super(eContainer, eFeature, eContents);
			assert eFeature.isMany();
			//			assert eFeature.getEOpposite() != null;
			//			assert eFeature.getEOpposite().isMany();
			assert ((EObject)eContainer).eGet(eFeature).equals(eContents);
		}

		@Override
		public synchronized void assigned(@NonNull Object eObject, @NonNull EStructuralFeature eFeature, @Nullable Object ecoreValue) {
			assert ecoreValue != null;
			@SuppressWarnings("unchecked")
			List<? extends EObject> ecoreValues = (List<? extends EObject>)ecoreValue;
			EReference eOppositeReference = getEOppositeReference(((EReference)eFeature));
			for (EObject element : ecoreValues) {
				if (element != null) {
					Map<@NonNull EStructuralFeature, @NonNull BasicSlotState> elementObjectState = getObjectState(element);
					elementObjectState.put(eOppositeReference, this);
				}
			}
			//			super.assigned(objectManager, eObject, eFeature, ecoreValue);
			assignedElement(eObject, (EReference)eFeature, /*(EObject)*/ecoreValue);
		}

		public void assignedElement(@NonNull Object eContainer, @NonNull EReference eReference, Object eObject) {
			//			super.assigned(objectManager, eContainer, eReference, eObject);
			switch (mode) {
				case ASSIGNABLE:
				case REASSIGNABLE:
					mode = SlotMode.ASSIGNED;
					unblock(IncrementalObjectManager.this);
					break;
				case ASSIGNED:
					break;
			}
		}

		@Override
		public synchronized void getting(@NonNull Object eObject, @NonNull EStructuralFeature eFeature) {
			switch (mode) {
				case ASSIGNABLE:
				case REASSIGNABLE:
					mode = SlotMode.ASSIGNED;
					unblock(IncrementalObjectManager.this);
					break;
				case ASSIGNED:
					break;
			}
		}
	}

	/**
	 * SlotState describing the element side of a 1:N Object navigation.
	 * <br>
	 * Lifecycle (read first, write later):
	 * Create due to
	 * - get of an aggregator => ASSIGNABLE, blocked
	 * Unblock
	 * - assign of possibly null aggregator for the element, ASSIGNABLE, blocked => ASSIGNED, not blocked
	 * - non-null aggregator is notified to unblock
	 * Thereafter
	 * - get of aggregator ASSIGNED => ASSIGNED
	 * <br>
	 * Lifecycle (write first):
	 * Create due to
	 * - assign of a possibly null aggregator => ASSIGNED, unblocked
	 * - non-null aggregator is notified to unblock
	 * Thereafter
	 * - get of aggregator ASSIGNED => ASSIGNED
	 */
	class OneToManyElementSlotState extends BasicSlotState
	{
		public OneToManyElementSlotState(@NonNull Object eObject, @NonNull EReference eFeature) {
			super(eObject, eFeature);
			assert !eFeature.isMany();
			if (eFeature == OCLstdlibPackage.Literals.OCL_ELEMENT__OCL_CONTAINER) {
				assert eFeature.getEOpposite() == null;
			}
			else {
				//				assert eFeature.getEOpposite() != null;
				assert getEOppositeReference(eFeature).isMany();
			}
		}

		public OneToManyElementSlotState(@NonNull Object eObject, @NonNull EReference eFeature, @NonNull Object eAggregator) {
			super(eObject, eFeature, eAggregator);
			assert !eFeature.isMany();
			//			assert eFeature.getEOpposite() != null;
			assert getEOppositeReference(eFeature).isMany();
			if (eFeature == OCLstdlibPackage.Literals.OCL_ELEMENT__OCL_CONTAINER) {
				assert ((EObject)eObject).eContainer() == eAggregator;
			}
			else {
				assert ((EObject)eObject).eGet(eFeature) == eAggregator;
			}
		}

		@Override
		public synchronized void assigned(@NonNull Object eObject, @NonNull EStructuralFeature eFeature, @Nullable Object ecoreValue) {
			if (!isAssigned() && (ecoreValue != null)) {
				EObject eOpposite = (EObject) ecoreValue;
				EReference eOppositeReference = getEOppositeReference(((EReference)eFeature));
				if (eFeature == OCLstdlibPackage.Literals.OCL_ELEMENT__OCL_CONTAINER) {
					eOppositeReference = ((EObject)eObject).eContainmentFeature();
					assert eOppositeReference != null;
					SlotState aggregatorSlotState = getSlotState(eOpposite, eOppositeReference);
					aggregatorSlotState.assigned(eOpposite, eOppositeReference, eObject);
				}
				else {
					assert eOppositeReference != null;
					OneToManyAggregatorSlotState aggregatorSlotState = (OneToManyAggregatorSlotState) getSlotState(eOpposite, eOppositeReference);
					aggregatorSlotState.assignedElement(eOpposite, eOppositeReference, eObject);
				}
			}
		}

		@Override
		public @NonNull BasicSlotState getPrimarySlotState() {
			EObject eOpposite = (EObject) getValue();
			assert eOpposite != null;
			EReference eOppositeReference = ((EReference)eFeature).getEOpposite();
			if (eFeature == OCLstdlibPackage.Literals.OCL_ELEMENT__OCL_CONTAINER) {
				eOppositeReference = ((EObject)eObject).eContainmentFeature();
				assert eOppositeReference != null;
				return getSlotState(eOpposite, eOppositeReference);
			}
			else {
				assert eOppositeReference != null;
				return getSlotState(eOpposite, eOppositeReference);
			}
		}
	}

	/**
	 * SlotState describing a 1:1 Object navigation. Both ends are assigned exactly once. The remote assignment
	 * may be null.
	 * <br>
	 * Lifecycle 1: write first
	 * Create due to
	 * - assign of possibly null eOpposite => ASSIGNED
	 * Thereafter
	 * - get of either end ASSIGNED => ASSIGNED
	 * - (assign of either end is an ignored error)
	 * <br>
	 * Lifecycle 2: read first
	 * Create due to
	 * - get of other end => ASSIGNABLE_BLOCKED
	 * Unblock due to
	 * - assign of a further element to the aggregator => ASSIGNABLE_BLOCKED => ASSIGNED
	 * Thereafter
	 * - get of either end ASSIGNED => ASSIGNED
	 * - (assign of either end is an ignored error)
	 */
	class OneToOneSlotState extends BasicSlotState
	{
		public OneToOneSlotState(@NonNull Object eObject, @NonNull EReference eFeature) {
			super(eObject, eFeature);
			if (eFeature instanceof EOppositeReferenceImpl) {
				assert !(((EOppositeReferenceImpl)eFeature).getEOpposite().isMany());
			}
			else {
				assert !eFeature.isMany();
				if (eFeature.isContainer()) {
					//				assert eObject.eContainer() == eOpposite;
				}
				else if (eFeature.isContainment()) {
					//				assert eOpposite != null;
					//				assert eObject == eOpposite.eContainer();
				}
				else if (eFeature == OCLstdlibPackage.Literals.OCL_ELEMENT__OCL_CONTAINER) {
					//				slotState = new OneToOneSlotState(eObject, eReference);
				}
				else {
					//					assert eFeature.getEOpposite() != null;
					assert !getEOppositeReference(eFeature).isMany();
				}
			}
		}

		private OneToOneSlotState(@NonNull Object eObject, @NonNull EReference eFeature, @Nullable Object eOpposite) {
			super(eObject, eFeature, eOpposite);
			assert !eFeature.isMany();
			if (eFeature.isContainer()) {
				assert ((EObject)eObject).eContainer() == eOpposite;
			}
			else if (eFeature.isContainment()) {
				//				assert eOpposite != null;
				//				assert eObject == ((EObject)eOpposite).eContainer();
				assert (eOpposite == null) || (eObject == ((EObject)eOpposite).eContainer());
			}
			else {
				//	assert eFeature.getEOpposite() != null;
				assert !getEOppositeReference(eFeature).isMany();
				assert ((EObject)eObject).eGet(eFeature) == eOpposite;
			}
		}

		@Override
		public void assigned(@NonNull Object eObject, @NonNull EStructuralFeature eFeature, @Nullable Object ecoreValue) {
			assigned(IncrementalObjectManager.this, eObject, eFeature, ecoreValue);
		}
	}

	/**
	 * Simple SlotState describing a DataType element.
	 */
	class SimpleSlotState extends BasicSlotState
	{
		public SimpleSlotState(@NonNull Object eObject, @NonNull EAttribute eFeature) {
			super(eObject, eFeature);
		}

		public SimpleSlotState(@NonNull Object eObject, @NonNull EAttribute eFeature, @Nullable Object ecoreValue) {
			super(eObject, eFeature, ecoreValue);
		}

		@Override
		public void assigned(@NonNull Object eObject, @NonNull EStructuralFeature eFeature, @Nullable Object ecoreValue) {
			assigned(IncrementalObjectManager.this, eObject, eFeature, ecoreValue);
		}
	}

	public IncrementalObjectManager(@NonNull IncrementalInvocationManager invocationManager) {
		super(invocationManager);
	}

	@Override
	public void assigned(Invocation.@NonNull Incremental invocation, @NonNull Object eObject, EStructuralFeature eFeature, @Nullable Object ecoreValue) {
		assigned(eObject, eFeature, ecoreValue);
		assert eFeature != null;
		BasicSlotState slotState = getSlotState(eObject, eFeature);
		invocation.addWriteSlot(slotState);
	}

	@Override
	protected @NonNull BasicSlotState createContainmentSlotState(@NonNull Object eObject, @NonNull EReference eReference) {
		if (eReference.isMany()) {
			return new OneToManyAggregatorSlotState(eObject, eReference);
		}
		else {
			return new OneToOneSlotState(eObject, eReference);
		}
	}

	@Override
	protected @NonNull BasicSlotState createOclContainerSlotState(@NonNull Object eObject, @NonNull EReference eReference) {
		return new OneToManyElementSlotState(eObject, eReference); //FIXME may be many
	}

	@Override
	protected @NonNull BasicSlotState createOneToManyAggregatorSlotState(@NonNull Object eObject, @NonNull EReference eFeature,
			@NonNull EReference eOppositeFeature, @Nullable Object eContents) {
		if (eContents != null) {
			//			SlotState containedSlotState = objectManager.getSlotState(eContent, eOppositeFeature);
			//			containedSlotState.assigned(objectManager, eContent, eOppositeFeature, eObject);
		}
		return new OneToManyAggregatorSlotState(eObject, eFeature, eContents);
	}

	@Override
	protected @NonNull BasicSlotState createOneToManyAggregatorSlotState(@NonNull Object eObject, @NonNull EReference eReference, @NonNull Object ecoreValue) {
		return new OneToManyAggregatorSlotState(eObject, eReference, /*eOppositeReference,*/ ecoreValue);
	}

	@Override
	protected @NonNull BasicSlotState createOneToManyElementSlotState(@NonNull Object eObject, @NonNull EReference eFeature,
			@NonNull EReference eOppositeFeature, @NonNull Object eAggregator) {
		OneToManyAggregatorSlotState aggregatorSlotState = (OneToManyAggregatorSlotState) getSlotState(eAggregator, eOppositeFeature);
		aggregatorSlotState.assignedElement(eAggregator, eOppositeFeature, eObject);
		return new OneToManyElementSlotState(eObject, eFeature, eAggregator);
	}

	@Override
	protected @NonNull BasicSlotState createOneToOneSlotState(@NonNull Object eObject, @NonNull EReference eReference, @NonNull Object ecoreValue) {
		return new OneToOneSlotState(eObject, eReference, /*eOppositeReference,*/ ecoreValue);
	}

	@Override
	protected @NonNull BasicSlotState createOneToOneSlotState(@NonNull Object eObject, @NonNull EReference eFeature,
			@NonNull EReference eOppositeFeature, @Nullable Object eOpposite) {
		Map<@NonNull EStructuralFeature, @NonNull BasicSlotState> oppositeObjectState = null;
		if (eOpposite != null) {
			oppositeObjectState = getObjectState(eOpposite);
			BasicSlotState slotState = oppositeObjectState.get(eOppositeFeature);
			if (slotState != null) {
				return slotState;
			}
		}
		BasicSlotState slotState = new OneToOneSlotState(eObject, eFeature, eOpposite);
		if (oppositeObjectState != null) {
			oppositeObjectState.put(eOppositeFeature, slotState);
		}
		return slotState;
	}

	@Override
	protected @NonNull BasicSlotState createReferenceSlotState(@NonNull Object eObject, @NonNull EReference eReference, @NonNull EReference eOppositeReference) {
		if (eReference.isMany()) {
			if (eOppositeReference.isMany()) {
				return new ManyToManySlotState(eObject, eReference);
			}
			else {
				return new OneToManyAggregatorSlotState(eObject, eReference);
			}
		}
		else {
			if (eOppositeReference.isMany()) {
				return createOclContainerSlotState(eObject, eReference);
			}
			else {
				return new OneToOneSlotState(eObject, eReference);
			}
		}
	}

	@Override
	protected @NonNull BasicSlotState createSimpleSlotState(@NonNull Object eObject, @NonNull EAttribute eFeature) {
		return new SimpleSlotState(eObject, eFeature);
	}

	@Override
	protected @NonNull SimpleSlotState createSimpleSlotState(@NonNull Object eObject, @NonNull EAttribute eFeature, @Nullable Object ecoreValue) {
		return new SimpleSlotState(eObject, eFeature, ecoreValue);
	}

	@Override
	public void created(Invocation.@NonNull Incremental invocation, @NonNull Object eObject) {
		invocation.addCreatedObject(eObject);
	}

	@Override
	public void destroyed(@NonNull Object eObject) {
		PivotUtilInternal.resetContainer((EObject) eObject);
		object2feature2slotState.remove(eObject);
	}

	@Override
	public @NonNull Map<@NonNull EStructuralFeature, @NonNull BasicSlotState> getObjectState(@NonNull Object eObject) {
		Map<@NonNull EStructuralFeature, @NonNull BasicSlotState> feature2state = object2feature2slotState.get(eObject);
		if (feature2state == null) {
			//			feature2state = createFeature2State(eObject);	// FIXME this LazyObjectManager functionality gives a StackOverflowError
			feature2state = new HashMap<>();
			object2feature2slotState.put(eObject, feature2state);
		}
		return feature2state;
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
		SlotState slotState = getSlotState(eObject, eFeature);
		slotState.getting(eObject, eFeature);
	}

	@Override
	public void got(Execution.@NonNull Incremental execution, @NonNull Object eObject, /*@NonNull*/ EStructuralFeature eFeature, @Nullable Object ecoreValue) {
		assert eFeature != null;
		SlotState slotState = getSlotState(eObject, eFeature);
		execution.addReadSlot((SlotState.Incremental)slotState);
	}

	public void modified(@NonNull Object eObject, @NonNull EStructuralFeature eFeature) {
		SlotState.Incremental slotState = basicGetSlotState(eObject, eFeature);
		if (slotState != null) {
			for (Execution.@NonNull Incremental execution : slotState.getTargets()) {
				execution.revoke();
			}
		}
	}
}