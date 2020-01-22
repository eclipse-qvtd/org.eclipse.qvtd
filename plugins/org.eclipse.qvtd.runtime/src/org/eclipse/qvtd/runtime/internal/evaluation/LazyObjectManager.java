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

import java.util.List;
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
import org.eclipse.qvtd.runtime.evaluation.Execution;
import org.eclipse.qvtd.runtime.evaluation.Invocation;
import org.eclipse.qvtd.runtime.evaluation.InvocationFailedException;
import org.eclipse.qvtd.runtime.evaluation.SlotState;
import org.eclipse.qvtd.runtime.utilities.QVTruntimeUtil;

/**
 * A LazyObjectManager supervises objects during a transformation avoiding the heavyweight costs that
 * are necessary for an incremenatal re-execution.
 */
public class LazyObjectManager extends AbstractObjectManager<LazyObjectManager.@NonNull LazySlotState>
{
	public static class LazyObjectState extends AbstractObjectState<@NonNull LazySlotState>
	{
		public LazyObjectState(@NonNull LazyObjectManager objectManager, @NonNull Object eObject) {
			super(objectManager, eObject);
		}

		@Override
		protected @NonNull ManyToManySlotState createManyToManySlotState(@NonNull EReference eReference) {
			return new ManyToManySlotState(this, eReference);
		}

		@Override
		protected @NonNull LazySlotState createOclContainerSlotState(@NonNull EReference eReference, @NonNull Object eContainer) {
			return new OclContainerSlotState(this, eReference, eContainer);
		}

		@Override
		protected @NonNull LazySlotState createOneToManyAggregatorSlotState(@NonNull EReference eReference, @NonNull Object eContents) {
			return new OneToManyAggregatorSlotState(this, eReference, eContents);
		}

		@Override
		protected @NonNull OneToManyElementSlotState createOneToManyElementSlotState(@NonNull EReference eReference, @NonNull EReference eOppositeReference, @NonNull Object eAggregator) {
			return new OneToManyElementSlotState(this, eReference, eOppositeReference, eAggregator);
		}

		@Override
		protected @NonNull LazySlotState createOneToOneSlotState(@NonNull EReference eReference, @Nullable Object ecoreValue) {
			return new OneToOneSlotState(this, eReference, ecoreValue);
		}

		@Override
		protected @NonNull SimpleSlotState createSimpleSlotState(@NonNull EAttribute eFeature, @Nullable Object ecoreValue) {
			return new SimpleSlotState(this, eFeature, ecoreValue);
		}

		@Override
		protected @NonNull SpeculatingSlotState createSpeculatingSlotState(@NonNull EAttribute eFeature) {
			return new SpeculatingSlotState(this, eFeature);
		}
	}

	public static abstract class LazySlotState extends AbstractSlotState
	{
		protected final @NonNull EStructuralFeature debug_eFeature;

		protected LazySlotState(@NonNull AbstractObjectState<@NonNull LazySlotState> objectState, @NonNull EStructuralFeature eFeature, @Nullable Object ecoreValue) {
			super(objectState, ecoreValue != NOT_A_VALUE ? SlotMode.ASSIGNED : SlotMode.ASSIGNABLE);
			this.debug_eFeature = eFeature;
		}

		@Override
		public synchronized void assigned(@NonNull Object eObject, @NonNull EStructuralFeature eFeature, @Nullable Object ecoreValue, boolean isPartial) {
			if (isAssigned() && !(eFeature instanceof EOppositeReferenceImpl)) {
				QVTruntimeUtil.errPrintln("Re-assignment of \"" + toDebugString(eObject) + "\"." + eFeature.getEContainingClass().getName() + "::" + eFeature.getName() + " with \"" + ecoreValue + "\"");
			}
			assignedSlot();
		}

		@Override
		public final void assignedSlot() {
			switch (mode) {
				case ASSIGNABLE:
					mode = SlotMode.ASSIGNED;
					unblock();
					break;
				case ASSIGNED:
					break;
				case REASSIGNABLE:
					throw new IllegalStateException("Only the IncrementalObjectManager supports REASSIGNABLE slots.");
			}
		}

		@Override
		public void debugUnblock() {
			Object object2 = objectState.getObject();
			if (object2 instanceof EObject) {
				Object eProxy = null;
				EObject eObject = ((EObject)objectState.getObject());
				EClassifier eType = debug_eFeature.getEType();
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
				if (debug_eFeature.isMany()) {
					@SuppressWarnings("unchecked")
					List<Object> list = (List<Object>)eObject.eGet(debug_eFeature);
					list.add(eProxy);
				}
				else if (!(debug_eFeature instanceof EOppositeReferenceImpl)) {
					eObject.eSet(debug_eFeature, eProxy);
				}
			}
		}

		@Override
		protected @NonNull LazyObjectManager getObjectManager() {
			return (LazyObjectManager)objectState.getObjectManager();
		}

		@Override
		public synchronized void getting(@NonNull Object eObject, @NonNull EStructuralFeature eFeature) {
			switch (mode) {
				case ASSIGNABLE:
					throw new InvocationFailedException(this, false);
				case ASSIGNED:
					break;
				case REASSIGNABLE:
					throw new IllegalStateException("Only the IncrementalObjectManager supports REASSIGNABLE slots.");
			}
		}

		@Override
		public String toString() {
			StringBuilder s = new StringBuilder();
			s.append(toDebugString(objectState.getObject()));
			s.append(".");
			s.append(debug_eFeature.getEContainingClass().getName());
			s.append("::");
			s.append(debug_eFeature.getName());
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
	static class ManyToManySlotState extends LazySlotState
	{
		public ManyToManySlotState(@NonNull AbstractObjectState<@NonNull LazySlotState> objectState, @NonNull EReference eReference) {
			super(objectState, eReference, NOT_A_VALUE);
			assert eReference.isMany();
			assert getObjectManager().getEOppositeReference(eReference).isMany();
		}

		@Override
		public synchronized void assigned(@NonNull Object eObject, @NonNull EStructuralFeature eFeature, @Nullable Object ecoreValue, boolean isPartial) {
			LazyObjectManager objectManager = getObjectManager();
			assert ecoreValue != null;
			@SuppressWarnings("unchecked")
			List<? extends EObject> ecoreValues = (List<? extends EObject>)ecoreValue;
			EReference eOppositeReference = objectManager.getEOppositeReference(((EReference)eFeature));
			for (EObject element : ecoreValues) {
				if (element != null) {
					AbstractObjectState<@NonNull LazySlotState> elementObjectState = objectManager.getObjectState(element);
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
	static class OneToManyAggregatorSlotState extends LazySlotState
	{
		private OneToManyAggregatorSlotState(@NonNull AbstractObjectState<@NonNull LazySlotState> objectState, @NonNull EReference eReference, @Nullable Object eContents) {
			super(objectState, eReference, eContents);
			assert eReference.isMany();
			//			assert eFeature.getEOpposite() != null;
			//			assert eFeature.getEOpposite().isMany();
			assert (eContents == NOT_A_VALUE) || ((EObject)objectState.getObject()).eGet(eReference).equals(eContents);
		}

		@Override
		public synchronized void assigned(@NonNull Object eObject, @NonNull EStructuralFeature eFeature, @Nullable Object ecoreValue, boolean isPartial) {
			assert ecoreValue != null;
			LazyObjectManager objectManager = getObjectManager();
			EReference eOppositeReference = objectManager.getEOppositeReference(((EReference)eFeature));
			if (isPartial) {
				AbstractObjectState<@NonNull LazySlotState> elementObjectState = objectManager.getObjectState(ecoreValue);
				//	elementObjectState.updateSlotState(eOppositeReference, eObject, false);
				elementObjectState.gotSlotState(eOppositeReference, eObject);
			}
			else {
				@SuppressWarnings("unchecked")
				Iterable<? extends EObject> ecoreValues = (Iterable<? extends EObject>)ecoreValue;
				for (EObject element : ecoreValues) {
					if (element != null) {
						AbstractObjectState<@NonNull LazySlotState> elementObjectState = objectManager.getObjectState(element);
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
	static class OneToManyElementSlotState extends LazySlotState
	{
		public OneToManyElementSlotState(@NonNull AbstractObjectState<@NonNull LazySlotState> objectState, @NonNull EReference eReference, @NonNull EReference eOppositeReference, @NonNull Object eAggregator) {
			super(objectState, eReference, eAggregator);
			assert !eReference.isMany();
			assert eOppositeReference.isMany();
			assert eReference != OCLstdlibPackage.Literals.OCL_ELEMENT__OCL_CONTAINER;
			assert (eAggregator == NOT_A_VALUE) || (eReference instanceof EOppositeReferenceImpl) || (((EObject)objectState.getObject()).eGet(eReference) == eAggregator);
		}

		@Override
		public synchronized void assigned(@NonNull Object eObject, @NonNull EStructuralFeature eFeature, @Nullable Object ecoreValue, boolean isPartial) {
			if (!isAssigned() && (ecoreValue != null)) {
				LazyObjectManager objectManager = getObjectManager();
				EObject eOpposite = (EObject) ecoreValue;
				EReference eOppositeReference = objectManager.getEOppositeReference(((EReference)eFeature));
				assert eOppositeReference != null;
				OneToManyAggregatorSlotState aggregatorSlotState = (OneToManyAggregatorSlotState) objectManager.updateSlotState(eOpposite, eOppositeReference, ecoreValue, isPartial);
				aggregatorSlotState.assignedSlot();
			}
			super.assigned(eObject, eFeature, ecoreValue, isPartial);
		}
	}

	static class OclContainerSlotState extends LazySlotState
	{
		public OclContainerSlotState(@NonNull AbstractObjectState<@NonNull LazySlotState> objectState, @NonNull EReference eReference, @NonNull Object eContainer) {
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
				LazyObjectManager objectManager = getObjectManager();
				EObject eOpposite = (EObject) eContainer;
				EReference eOppositeReference = objectManager.getEOppositeReference(((EReference)eFeature));
				eOppositeReference = ((EObject)eObject).eContainmentFeature();
				assert eOppositeReference != null;
				SlotState aggregatorSlotState = objectManager.updateSlotState(eOpposite, eOppositeReference, eContainer, isPartial);
				aggregatorSlotState.assigned(eOpposite, eOppositeReference, eObject, isPartial);
			}
			super.assigned(eObject, eFeature, eContainer, isPartial);
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
	static class OneToOneSlotState extends LazySlotState
	{
		private OneToOneSlotState(@NonNull AbstractObjectState<@NonNull LazySlotState> objectState, @NonNull EReference eFeature, @Nullable Object eOpposite) {
			super(objectState, eFeature, eOpposite);
			assert eOpposite != null;		// FIXME if really null exploit, but isn't null valid until we have a OneToZeroOrOneSlotState ??
			assert !eFeature.isMany();
			Object eObject = objectState.getObject();
			LazyObjectManager objectManager = getObjectManager();
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
				assert /*(eOpposite == null) ||*/ (eOpposite == NOT_A_VALUE) || (eObject == ((EObject)eOpposite).eContainer());
			}
			else {
				assert !objectManager.getEOppositeReference(eFeature).isMany();
				assert (eOpposite == NOT_A_VALUE) || (eFeature == this.debug_eFeature ? (((EObject)eObject).eGet(eFeature) == eOpposite) : (eOpposite == null || ((EObject)eOpposite).eGet(objectManager.getEOppositeReference(eFeature)) == eObject));
			}
		}
	}

	/**
	 * Simple SlotState describing a DataType element.
	 */
	static class SimpleSlotState extends LazySlotState
	{
		public SimpleSlotState(@NonNull AbstractObjectState<@NonNull LazySlotState> objectState, @NonNull EAttribute eFeature, @Nullable Object ecoreValue) {
			super(objectState, eFeature, ecoreValue);
		}
	}

	/**
	 * SlotState describing a Speculatable Boolean result.
	 */
	static class SpeculatingSlotState extends LazySlotState implements SlotState.Speculating
	{
		private final @NonNull UniqueList<@NonNull Speculating> inputSpeculatables = new UniqueList<>();
		private @Nullable Boolean status;

		public SpeculatingSlotState(@NonNull AbstractObjectState<@NonNull LazySlotState> objectState, @NonNull EAttribute eFeature) {
			super(objectState, eFeature, NOT_A_VALUE);
		}

		@Override
		public void addInput(@NonNull Speculating inputSpeculatable) {
			inputSpeculatables.add(inputSpeculatable);
		}

		@Override
		public synchronized void assigned(@NonNull Object eObject, @NonNull EStructuralFeature eFeature, @Nullable Object ecoreValue, boolean isPartial) {
			//			status = (Boolean)ecoreValue;
			super.assigned(eObject, eFeature, ecoreValue, isPartial);
		}

		@Override
		public @NonNull Iterable<@NonNull Speculating> getInputs() {
			return inputSpeculatables;
		}

		@Override
		public @Nullable Boolean getStatus() {
			return status;
		}

		@Override
		public void setStatus(@NonNull Boolean successStatus) {
			this.status = successStatus;
			// Boolean.TRUE/FALSE slot value is assigned as part of the re-execution of the speculating partition.
			assignedSlot();			//	mode = SlotMode.ASSIGNED;
		}
	}

	public LazyObjectManager(@NonNull LazyInvocationManager invocationManager) {
		super(invocationManager);
	}

	@Override
	public void assigned(Invocation.@NonNull Incremental invocation, @NonNull Object eObject, EStructuralFeature eFeature, @Nullable Object ecoreValue, boolean isPartial) {
		assigned(eObject, eFeature, ecoreValue, isPartial);		// Delegate incremental API to non-incremental API
	}

	@Override
	public @NonNull LazyObjectState createObjectState(@NonNull Object eObject) {
		return new LazyObjectState(this, eObject);
	}

	@Override
	public void created(Invocation.@NonNull Incremental invocation, @NonNull Object eObject) {
		// Ignore incremental API
	}

	@Override
	public void destroyed(@NonNull Object eObject) {
		// Ignore incremental API
	}

	@Override
	public void got(Execution.@NonNull Incremental computation, @NonNull Object eObject, EStructuralFeature eFeature, @Nullable Object ecoreValue) {
		// Ignore incremental API
	}
}