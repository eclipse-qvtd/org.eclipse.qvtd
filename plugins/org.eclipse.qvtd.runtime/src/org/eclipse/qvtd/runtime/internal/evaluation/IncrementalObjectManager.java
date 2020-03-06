/*******************************************************************************
 * Copyright (c) 2013, 2020 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.runtime.internal.evaluation;

import java.util.List;
import java.util.Set;

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
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibPackage;
import org.eclipse.ocl.pivot.utilities.UniqueList;
import org.eclipse.qvtd.runtime.evaluation.AbstractObjectManager;
import org.eclipse.qvtd.runtime.evaluation.AbstractSlotState;
import org.eclipse.qvtd.runtime.evaluation.AbstractTransformer;
import org.eclipse.qvtd.runtime.evaluation.Execution;
import org.eclipse.qvtd.runtime.evaluation.Invocation;
import org.eclipse.qvtd.runtime.evaluation.InvocationFailedException;
import org.eclipse.qvtd.runtime.evaluation.SlotState;
import org.eclipse.qvtd.runtime.utilities.QVTruntimeUtil;

/**
 * An IncrementalObjectManager supervises objects during a transformation maintaining sufficient context to allow
 * a subsequent incremental re-execution.
 */
public class IncrementalObjectManager extends AbstractObjectManager<IncrementalObjectManager.@NonNull IncrementalSlotState>
{
	public static class IncrementalObjectState extends AbstractObjectState<@NonNull IncrementalSlotState>
	{
		public IncrementalObjectState(@NonNull IncrementalObjectManager objectManager, @NonNull Object eObject) {
			super(objectManager, eObject);
		}

		@Override
		protected @NonNull ManyToManySlotState createManyToManySlotState(@NonNull EReference eReference) {
			return new ManyToManySlotState(this, eReference);
		}

		@Override
		protected @NonNull IncrementalSlotState createOclContainerSlotState(@NonNull EReference eReference, @NonNull Object eContainer) {
			return new OclContainerSlotState(this, eReference, eContainer);
		}

		@Override
		protected @NonNull IncrementalSlotState createOneToManyAggregatorSlotState(@NonNull EReference eReference, @NonNull Object eContents) {
			return new OneToManyAggregatorSlotState(this, eReference, eContents);
		}

		@Override
		protected @NonNull OneToManyElementSlotState createOneToManyElementSlotState(@NonNull EReference eReference, @NonNull EReference eOppositeReference, @NonNull Object eAggregator) {
			return new OneToManyElementSlotState(this, eReference, eOppositeReference, eAggregator);
		}

		@Override
		protected @NonNull IncrementalSlotState createOneToOneSlotState(@NonNull EReference eReference, @Nullable Object ecoreValue) {
			return new OneToOneSlotState(this, eReference, ecoreValue);
		}

		@Override
		protected @NonNull SimpleSlotState createSimpleSlotState(@NonNull EAttribute eFeature, @Nullable Object ecoreValue) {
			return new SimpleSlotState(this, eFeature, ecoreValue);
		}

		@Override
		protected @NonNull SpeculatingSlotState createSpeculatableSlotState(@NonNull EAttribute eFeature, @Nullable Boolean speculationStatus) {
			return new SpeculatingSlotState(this, eFeature, speculationStatus);
		}
	}

	public static abstract class IncrementalSlotState extends AbstractSlotState.Incremental
	{
		protected final @NonNull EStructuralFeature eFeature;
		private @Nullable Object value;

		protected IncrementalSlotState(@NonNull AbstractObjectState<@NonNull IncrementalSlotState> objectState, @NonNull EStructuralFeature eFeature, @Nullable Object ecoreValue) {
			super(objectState, ecoreValue != NOT_A_VALUE ? SlotMode.ASSIGNED : SlotMode.ASSIGNABLE);
			this.eFeature = eFeature;
			this.value = ecoreValue;
		}

		@Override
		public synchronized void assigned(@NonNull Object eObject, @NonNull EStructuralFeature eFeature, @Nullable Object ecoreValue, boolean isPartial) {
			switch (mode) {
				case ASSIGNABLE:
					this.value = ecoreValue;
					break;
				case ASSIGNED:
					if (!(eFeature instanceof EOppositeReferenceImpl)) {
						QVTruntimeUtil.errPrintln("Re-assignment of \"" + toDebugString(eObject) + "\"." + eFeature.getEContainingClass().getName() + "::" + eFeature.getName() + " with \"" + ecoreValue + "\"");
					}
					break;
				case REASSIGNABLE:
					if (this.value != ecoreValue) {		// FIXME equals() ??
						this.value = ecoreValue;
						revokeTargets();
					}
					break;
			}
			assignedSlot();
		}

		@Override
		public final void assignedSlot() {
			switch (mode) {
				case ASSIGNABLE:
				case REASSIGNABLE:
					mode = SlotMode.ASSIGNED;
					unblock();
					break;
				case ASSIGNED:
					break;
			}
		}

		@Override
		public void debugUnblock() {
			Object eObject2 = objectState.getObject();
			if (eObject2 instanceof EObject) {
				Object eProxy = null;
				EObject eObject = ((EObject)eObject2);
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
		protected @NonNull IncrementalObjectManager getObjectManager() {
			return (IncrementalObjectManager) objectState.getObjectManager();
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
					throw new InvocationFailedException(this, false);
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
			s.append(toDebugString(objectState.getObject()));
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
	 *
	 * Any assignment changes the aggregate at reach end of the changed relationship, but leaves all other aggregates unchanged.
	 * Many assignments may occur until a get occurs
	 */
	static class ManyToManySlotState extends IncrementalSlotState
	{
		public ManyToManySlotState(@NonNull AbstractObjectState<@NonNull IncrementalSlotState> objectState, @NonNull EReference eReference) {
			super(objectState, eReference, NOT_A_VALUE);
			assert eReference.isMany();
			assert getObjectManager().getEOppositeReference(eReference).isMany();
		}

		@Override
		public synchronized void assigned(@NonNull Object eObject, @NonNull EStructuralFeature eFeature, @Nullable Object ecoreValue, boolean isPartial) {
			IncrementalObjectManager objectManager = getObjectManager();
			assert ecoreValue != null;
			@SuppressWarnings("unchecked")
			List<? extends EObject> ecoreValues = (List<? extends EObject>)ecoreValue;
			EReference eOppositeReference = objectManager.getEOppositeReference(((EReference)eFeature));
			for (EObject element : ecoreValues) {
				if (element != null) {
					AbstractObjectState<@NonNull IncrementalSlotState> elementObjectState = objectManager.getObjectState(element);
					elementObjectState.putSlotState(eOppositeReference, this);
				}
			}
			assignedSlot();
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
	static class OneToManyAggregatorSlotState extends IncrementalSlotState
	{
		private OneToManyAggregatorSlotState(@NonNull AbstractObjectState<@NonNull IncrementalSlotState> objectState, @NonNull EReference eReference, @Nullable Object eContents) {
			super(objectState, eReference, eContents);
			assert eReference.isMany();
			//			assert eFeature.getEOpposite() != null;
			//			assert eFeature.getEOpposite().isMany();
			assert (eContents == NOT_A_VALUE) || ((EObject)objectState.getObject()).eGet(eReference).equals(eContents);
		}

		@Override
		public synchronized void assigned(@NonNull Object eObject, @NonNull EStructuralFeature eFeature, @Nullable Object ecoreValue, boolean isPartial) {
			assert ecoreValue != null;
			IncrementalObjectManager objectManager = getObjectManager();
			EReference eOppositeReference = objectManager.getEOppositeReference(((EReference)eFeature));
			if (isPartial) {
				AbstractObjectState<@NonNull IncrementalSlotState> elementObjectState = objectManager.getObjectState(ecoreValue);
				//	elementObjectState.updateSlotState(eOppositeReference, eObject, false);
				elementObjectState.gotSlotState(eOppositeReference, eObject);
			}
			else {
				@SuppressWarnings("unchecked")
				Iterable<? extends EObject> ecoreValues = (Iterable<? extends EObject>)ecoreValue;
				for (EObject element : ecoreValues) {
					if (element != null) {
						AbstractObjectState<@NonNull IncrementalSlotState> elementObjectState = objectManager.getObjectState(element);
						//	elementObjectState.updateSlotState(eOppositeReference, eObject, false);
						elementObjectState.gotSlotState(eOppositeReference, eObject);
					}
				}
			}
			assignedSlot();
		}

		@Override
		public synchronized void getting(@NonNull Object eObject, @NonNull EStructuralFeature eFeature) {
			assignedSlot();
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
	static class OneToManyElementSlotState extends IncrementalSlotState
	{
		public OneToManyElementSlotState(@NonNull AbstractObjectState<@NonNull IncrementalSlotState> objectState, @NonNull EReference eReference, @NonNull EReference eOppositeReference, @NonNull Object eAggregator) {
			super(objectState, eReference, eAggregator);
			assert !eReference.isMany();
			assert eOppositeReference.isMany();
			assert eReference != OCLstdlibPackage.Literals.OCL_ELEMENT__OCL_CONTAINER;
			assert (eAggregator == NOT_A_VALUE) || (eReference instanceof EOppositeReferenceImpl) || (((EObject)objectState.getObject()).eGet(eReference) == eAggregator);
		}

		@Override
		public synchronized void assigned(@NonNull Object eObject, @NonNull EStructuralFeature eFeature, @Nullable Object ecoreValue, boolean isPartial) {
			if (!isAssigned() && (ecoreValue != null)) {		// FIXME null
				IncrementalObjectManager objectManager = getObjectManager();
				EObject eOpposite = (EObject) ecoreValue;
				EReference eOppositeReference = objectManager.getEOppositeReference(((EReference)eFeature));
				assert eOppositeReference != null;
				OneToManyAggregatorSlotState aggregatorSlotState = (OneToManyAggregatorSlotState) objectManager.updateSlotState(eOpposite, eOppositeReference, NOT_A_VALUE, isPartial);
				aggregatorSlotState.assignedSlot();
			}
			super.assigned(eObject, eFeature, ecoreValue, isPartial);
		}

		@Override
		public @NonNull IncrementalSlotState getPrimarySlotState() {
			EObject eOpposite = (EObject) getValue();
			assert eOpposite != null;
			EReference eOppositeReference = ((EReference)eFeature).getEOpposite();
			assert eOppositeReference != null;
			return getObjectManager().updateSlotState(eOpposite, eOppositeReference, NOT_A_VALUE, false);
		}
	}

	static class OclContainerSlotState extends IncrementalSlotState
	{
		public OclContainerSlotState(@NonNull AbstractObjectState<@NonNull IncrementalSlotState> objectState, @NonNull EReference eReference, @NonNull Object eContainer) {
			super(objectState, eReference, eContainer);
			assert !eReference.isMany();
			assert getObjectManager().getEOppositeReference(eReference).isMany();
			assert eReference == OCLstdlibPackage.Literals.OCL_ELEMENT__OCL_CONTAINER;
			assert eReference.getEOpposite() == null;
			assert (eContainer == NOT_A_VALUE) || (((EObject)objectState.getObject()).eContainer() == eContainer);
		}

		@Override
		public synchronized void assigned(@NonNull Object eObject, @NonNull EStructuralFeature eFeature, @Nullable Object eContainer, boolean isPartial) {
			if (!isAssigned() && (eContainer != null)) {
				IncrementalObjectManager objectManager = getObjectManager();
				EObject eOpposite = (EObject) eContainer;
				EReference eOppositeReference = objectManager.getEOppositeReference(((EReference)eFeature));
				eOppositeReference = ((EObject)eObject).eContainmentFeature();
				assert eOppositeReference != null;
				SlotState aggregatorSlotState = objectManager.updateSlotState(eOpposite, eOppositeReference, eContainer, isPartial);
				aggregatorSlotState.assigned(eOpposite, eOppositeReference, eObject, isPartial);
			}
			super.assigned(eObject, eFeature, eContainer, isPartial);
		}

		@Override
		public @NonNull IncrementalSlotState getPrimarySlotState() {
			EObject eOpposite = (EObject) getValue();
			assert eOpposite != null;
			EReference eOppositeReference = ((EReference)eFeature).getEOpposite();
			eOppositeReference = ((EObject)objectState.getObject()).eContainmentFeature();
			assert eOppositeReference != null;
			return getObjectManager().updateSlotState(eOpposite, eOppositeReference, NOT_A_VALUE, false);
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
	static class OneToOneSlotState extends IncrementalSlotState
	{
		private OneToOneSlotState(@NonNull AbstractObjectState<@NonNull IncrementalSlotState> objectState, @NonNull EReference eFeature, @Nullable Object eOpposite) {
			super(objectState, eFeature, eOpposite);
			Object eObject = objectState.getObject();
			assert !eFeature.isMany();
			IncrementalObjectManager objectManager = getObjectManager();
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
					assert !objectManager.getEOppositeReference(eFeature).isMany();
				}
			}
			if (eFeature.isContainer()) {
				assert ((EObject)eObject).eContainer() == eOpposite;
			}
			else if (eFeature.isContainment()) {
				//				assert eOpposite != null;
				//				assert eObject == ((EObject)eOpposite).eContainer();
				assert (eOpposite == null) || (eObject == ((EObject)eOpposite).eContainer());
			}
			else {
				assert !objectManager.getEOppositeReference(eFeature).isMany();
				assert (eOpposite == NOT_A_VALUE) || (eFeature == this.eFeature ? (((EObject)eObject).eGet(eFeature) == eOpposite) : (eOpposite == null || ((EObject)eOpposite).eGet(objectManager.getEOppositeReference(eFeature)) == eObject));
			}
		}
	}

	/**
	 * Simple SlotState describing a DataType element.
	 */
	static class SimpleSlotState extends IncrementalSlotState
	{
		public SimpleSlotState(@NonNull AbstractObjectState<@NonNull IncrementalSlotState> objectState, @NonNull EAttribute eFeature, @Nullable Object ecoreValue) {
			super(objectState, eFeature, ecoreValue);
		}
	}

	/**
	 * SlotState describing a Speculatable Boolean result.
	 */
	static class SpeculatingSlotState extends IncrementalSlotState implements SlotState.Speculating
	{
		/**
		 * The immediate speculatables that must be satisfied for this speculatable to be satisfied.
		 */
		private final @NonNull Set<@NonNull Speculating> inputSpeculatables = new UniqueList<>();

		/**
		 * The outcome of the speculation of this speculatable.
		 *
		 * null => pending. false => failure. true => success.
		 *
		 * NB. success indicates that speculation has succeeded and that the speculatables are no longer
		 * speculating. It does not indicate that the mapping that provoked speculation has re-executed.
		 * The speculatable remains ASSIGNABLE until the re-execution makes it ASSIGNED.
		 */
		private @Nullable Boolean speculationStatus;

		public SpeculatingSlotState(@NonNull AbstractObjectState<@NonNull IncrementalSlotState> objectState, @NonNull EAttribute eFeature, @Nullable Boolean speculationStatus) {
			super(objectState, eFeature, speculationStatus != null ? speculationStatus : AbstractObjectManager.NOT_A_VALUE);
			assert speculationStatus != AbstractObjectManager.NOT_A_VALUE;
			this.speculationStatus = speculationStatus;
		}

		@Override
		public void addInput(@NonNull Speculating inputSpeculatable) {
			assert speculationStatus == null;
			inputSpeculatables.add(inputSpeculatable);
		}

		@Override
		public @NonNull Iterable<@NonNull Speculating> getInputs() {
			assert speculationStatus == null;
			return inputSpeculatables;
		}

		@Override
		public @Nullable Boolean getSpeculationStatus() {
			return speculationStatus;
		}

		@Override
		public void setSpeculated(boolean success) {
			assert speculationStatus == null;
			speculationStatus  = success;
			if (!success) {
				//				this.status = false;
				// Boolean.TRUE/FALSE slot value is assigned as part of the re-execution of the speculating partition.
				assignedSlot();			//	mode = SlotMode.ASSIGNED;
			}
			else {
				unblock();
			}
		}
	}

	public IncrementalObjectManager(@NonNull IncrementalInvocationManager invocationManager) {
		super(invocationManager);
	}

	@Override
	public void assigned(Invocation.@NonNull Incremental invocation, @NonNull Object eObject, EStructuralFeature eFeature, @Nullable Object ecoreValue, boolean isPartial) {
		//	assigned(eObject, eFeature, ecoreValue, isPartial);
		assert eFeature != null;
		IncrementalSlotState slotState = updateSlotState(eObject, eFeature, ecoreValue, isPartial);
		invocation.addWriteSlot(slotState);
	}

	@Override
	public @NonNull IncrementalObjectState createObjectState(@NonNull Object eObject) {
		return new IncrementalObjectState(this, eObject);
	}

	@Override
	public void created(Invocation.@NonNull Incremental invocation, @NonNull Object eObject) {
		invocation.addCreatedObject(eObject);
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
		SlotState slotState = updateSlotState(eObject, eFeature, NOT_A_VALUE, false);
		slotState.getting(eObject, eFeature);
	}

	@Override
	public void got(Execution.@NonNull Incremental execution, @NonNull Object eObject, /*@NonNull*/ EStructuralFeature eFeature, @Nullable Object ecoreValue) {
		assert eFeature != null;
		SlotState slotState = gotSlotState(eObject, eFeature, ecoreValue);
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