/*******************************************************************************
 * Copyright (c) 2013, 2015 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtbase.evaluation;


import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.PackageId;
import org.eclipse.ocl.pivot.ids.PropertyId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;

public abstract class AbstractTransformer implements Transformer
{	
	private static final @SuppressWarnings("null")@NonNull List<Integer> EMPTY_INDEX_LIST = Collections.emptyList();
	private static final @SuppressWarnings("null")@NonNull List<EObject> EMPTY_EOBJECT_LIST = Collections.emptyList();

	@SuppressWarnings("serial")
	public static class InvocationFailedException extends RuntimeException
	{
		public final @NonNull PropertyState propertyState;
		
		public InvocationFailedException(@NonNull PropertyState propertyState) {
			this.propertyState = propertyState;
		}
	}
	
	
	/**
	 * Simple PropertyState describing a DataType element or 1:1 Object navigation.
	 */
	public static class PropertyState
	{
		public enum PropertyMode {
			ASSIGNABLE,		// No assignment has been performed, object reads are blocked (collections reads may be unblocked)
			ASSIGNED		// Last assignment has been performed, reads are unblocked
		}

		protected final @NonNull EObject debug_eObject; 
		protected final @NonNull EStructuralFeature debug_eFeature; 
		protected @NonNull PropertyMode mode;	
		private @Nullable Object blockedInvocations = null;
		
		public PropertyState(@NonNull EObject eObject, @NonNull EStructuralFeature eFeature) {
			super();
			mode = PropertyMode.ASSIGNABLE;	
			this.debug_eObject = eObject;
			this.debug_eFeature = eFeature;
		}

		public PropertyState(@NonNull EObject eObject, @NonNull EStructuralFeature eFeature, @Nullable Object ecoreValue) {
			super();
			mode = PropertyMode.ASSIGNED;	
			this.debug_eObject = eObject;
			this.debug_eFeature = eFeature;
		}

		public synchronized void assigned(@NonNull ObjectManager objectManager, @NonNull EObject eObject, @NonNull EStructuralFeature eFeature, @Nullable Object ecoreValue) {
			switch (mode) {
				case ASSIGNABLE:
					mode = PropertyMode.ASSIGNED;
					unblock(objectManager);
					break;
				case ASSIGNED:
					System.out.println("Re-assignment");
					break;
			}
		}
		
		public synchronized void block(@NonNull Invocation invocation) {
			final Object blockedInvocations2 = blockedInvocations;
			if (blockedInvocations2 == null) {
				blockedInvocations = invocation;
			}
			else if (blockedInvocations2 instanceof Invocation) {
				List<Invocation> blockedInvocationList = new ArrayList<Invocation>();
				blockedInvocationList.add((Invocation) blockedInvocations2);
				blockedInvocationList.add(invocation);
				blockedInvocations = blockedInvocationList;
			}
			else {
				@SuppressWarnings("unchecked")
				List<Invocation> blockedInvocationList = (List<Invocation>)blockedInvocations2;
				blockedInvocationList.add(invocation);
			}
		}
		
		@SuppressWarnings("unchecked")
		public synchronized @Nullable <G> G get(@NonNull ObjectManager objectManager, @NonNull EObject eObject, @NonNull EStructuralFeature eFeature) {
			switch (mode) {
				case ASSIGNABLE:
					throw new InvocationFailedException(this);
				case ASSIGNED:
					break;
			}
			return (G) eObject.eGet(eFeature);
		}

		protected boolean isAssigned() {
			return mode == PropertyMode.ASSIGNED;
		}
		
		protected synchronized void unblock(@NonNull ObjectManager objectManager) {
			final Object blockedInvocations2 = blockedInvocations;
			if (blockedInvocations2 instanceof Invocation) {
				objectManager.unblock((Invocation) blockedInvocations2);
			}
			else if (blockedInvocations2 != null) {
				@SuppressWarnings("unchecked")
				List<Invocation> blockedInvocationList = (List<Invocation>)blockedInvocations2;
				for (@SuppressWarnings("null")@NonNull Invocation invocation : blockedInvocationList) {
					objectManager.unblock(invocation);
				}
			}
			blockedInvocations = null;
		}
	}
	
	/**
	 * PropertyState describing an M:N Object navigation.
	 */
	private static class ManyToManyPropertyState extends PropertyState
	{	
		public static @NonNull PropertyState create(@NonNull ObjectManager objectManager,
				@NonNull EObject eObject, @NonNull EReference eFeature, @NonNull EReference eOppositeFeature) {
			throw new UnsupportedOperationException();
		}
		
		public ManyToManyPropertyState(@NonNull EObject eObject, @NonNull EStructuralFeature eFeature) {
			super(eObject, eFeature);
			throw new UnsupportedOperationException();
		}

		@Override
		public synchronized void assigned(@NonNull ObjectManager objectManager, @NonNull EObject eObject, @NonNull EStructuralFeature eFeature, @Nullable Object ecoreValue) {
			throw new UnsupportedOperationException();
		}
	}
	
	/**
	 * PropertyState describing the container side of a 1:N Object navigation.
	 * <br>
	 * Lifecycle:
	 * Create due to
	 * - get of all elements => ASSIGNABLE, blocked
	 * NO: - get of a container => ASSIGNABLE, blocked
	 * Create due to
	 * - assign of all elements => ASSIGNABLE => ASSIGNED, not blocked
	 * - assign of a first element to the container => ASSIGNABLE, not blocked
	 * Update due to
	 * - assign of a further element to the container => ASSIGNABLE => ASSIGNABLE
	 * Unblock due to
	 * - get of a container ASSIGNABLE => ASSIGNED
	 * - get of all elements ASSIGNABLE => ASSIGNED
	 * Thereafter
	 * - get of a container ASSIGNED => ASSIGNED
	 * - get of all elements ASSIGNED => ASSIGNED
	 * <br>
	 * Lifecycle 2: read first
	 * Create due to
	 * - get of elements => ASSIGNABLE, blocked
	 * Unblock due to
	 * - assign of an element to the container => ASSIGNABLE => ASSIGNED, not blocked
	 * Thereafter
	 * - get of either end ASSIGNED => ASSIGNED
	 * - (assign of either end is an ignored error)
	 */
	private static class OneToManyContainerPropertyState extends PropertyState
	{
		public OneToManyContainerPropertyState(@NonNull EObject eContainer, @NonNull EStructuralFeature eFeature) {
			super(eContainer, eFeature);
			assert eFeature.isMany();
//			assert eFeature.getEOpposite() != null;
//			assert eFeature.getEOpposite().isMany();
		}

		public OneToManyContainerPropertyState(@NonNull EObject eContainer, @NonNull EStructuralFeature eFeature, @Nullable Object elements) {
			super(eContainer, eFeature, elements);
			assert eFeature.isMany();
//			assert eFeature.getEOpposite() != null;
//			assert eFeature.getEOpposite().isMany();
			assert eContainer.eGet(eFeature) == eContainer;
		}

		@Override
		public synchronized void assigned(@NonNull ObjectManager objectManager, @NonNull EObject eObject, @NonNull EStructuralFeature eFeature, @Nullable Object ecoreValue) {
			assert ecoreValue != null;
			@SuppressWarnings("unchecked")
			List<? extends EObject> ecoreValues = (List<? extends EObject>)ecoreValue;
			EReference eOppositeReference = ((EReference)eFeature).getEOpposite();
			for (EObject element : ecoreValues) {
				if (element != null) {
					Map<EStructuralFeature, PropertyState> elementObjectState = objectManager.getObjectState(element);
					elementObjectState.put(eOppositeReference, this);
				}
			}
			super.assigned(objectManager, eObject, eFeature, ecoreValue);

		}
		
		public void assignedElement(@NonNull ObjectManager objectManager,
				@NonNull EObject eContainer, @NonNull EReference eReference, EObject eObject) {
			super.assigned(objectManager, eContainer, eReference, eObject);
		}
		
		@Override
		@SuppressWarnings("unchecked")
		public synchronized @Nullable <G> G get(@NonNull ObjectManager objectManager, @NonNull EObject eObject, @NonNull EStructuralFeature eFeature) {
			switch (mode) {
				case ASSIGNABLE:
					mode = PropertyMode.ASSIGNED;
					unblock(objectManager);
					break;
				case ASSIGNED:
					break;
			}
			return (G) eObject.eGet(eFeature);
		}
	}
	
	/**
	 * PropertyState describing the element side of a 1:N Object navigation.
	 * <br>
	 * Lifecycle (read first, write later):
	 * Create due to
	 * - get of a container => ASSIGNABLE, blocked
	 * Unblock
	 * - assign of possibly null container for the element, ASSIGNABLE, blocked => ASSIGNED, not blocked
	 * - non-null container is notified to unblock 
	 * Thereafter
	 * - get of container ASSIGNED => ASSIGNED
	 * <br>
	 * Lifecycle (write first):
	 * Create due to
	 * - assign of a possibly null container => ASSIGNED, unblocked
	 * - non-null container is notified to unblock 
	 * Thereafter
	 * - get of container ASSIGNED => ASSIGNED
	 */
	private static class OneToManyElementPropertyState extends PropertyState
	{
		public static @NonNull PropertyState create(@NonNull ObjectManager objectManager,
				@NonNull EObject eObject, @NonNull EReference eFeature, @NonNull EReference eOppositeFeature, @NonNull EObject eContainer) {
			OneToManyContainerPropertyState containerPropertyState = (OneToManyContainerPropertyState) objectManager.getPropertyState(eContainer, eOppositeFeature);
			containerPropertyState.assignedElement(objectManager, eContainer, eOppositeFeature, eObject);
			return new OneToManyElementPropertyState(eObject, eFeature, eContainer);
		}
		
		public OneToManyElementPropertyState(@NonNull EObject eObject, @NonNull EReference eFeature) {
			super(eObject, eFeature);
			assert !eFeature.isMany();
			assert eFeature.getEOpposite() != null;
			assert eFeature.getEOpposite().isMany();
		}
		
		public OneToManyElementPropertyState(@NonNull EObject eObject, @NonNull EReference eFeature, @NonNull EObject eContainer) {
			super(eObject, eFeature, eContainer);
			assert !eFeature.isMany();
			assert eFeature.getEOpposite() != null;
			assert eFeature.getEOpposite().isMany();
			assert eObject.eGet(eFeature) == eContainer;
		}

		@Override
		public synchronized void assigned(@NonNull ObjectManager objectManager, @NonNull EObject eObject, @NonNull EStructuralFeature eFeature, @Nullable Object ecoreValue) {
			if (!isAssigned() && (ecoreValue != null)) {
				EObject eOpposite = (EObject) ecoreValue;
				EReference eOppositeReference = ((EReference)eFeature).getEOpposite();
				assert eOppositeReference != null;
				OneToManyContainerPropertyState containerPropertyState = (OneToManyContainerPropertyState) objectManager.getPropertyState(eOpposite, eOppositeReference);
				containerPropertyState.assignedElement(objectManager, eOpposite, eOppositeReference, eObject);
			}
			super.assigned(objectManager, eObject, eFeature, ecoreValue);
		}
	}
	
	/**
	 * PropertyState describing a 1:1 Object navigation. Both ends are assigned exactly once. The remote assignment
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
	 * - assign of a further element to the container => ASSIGNABLE_BLOCKED => ASSIGNED
	 * Thereafter
	 * - get of either end ASSIGNED => ASSIGNED
	 * - (assign of either end is an ignored error)
	 */
	private static class OneToOnePropertyState extends PropertyState
	{
		public static @NonNull <G,S> PropertyState create(@NonNull ObjectManager objectManager,
				@NonNull EObject eObject, @NonNull EReference eFeature,
				@NonNull EReference eOppositeFeature, @Nullable EObject eOpposite) {
			Map<EStructuralFeature, PropertyState> oppositeObjectState = null;
			if (eOpposite != null) {
				oppositeObjectState = objectManager.getObjectState(eObject);
				PropertyState propertyState = oppositeObjectState.get(eOppositeFeature);
				if (propertyState != null) {
					return propertyState;
				}		
			}
			PropertyState propertyState = new OneToOnePropertyState(eObject, eFeature, eOpposite);
			if (oppositeObjectState != null) {
				oppositeObjectState.put(eOppositeFeature, propertyState);
			}
			return propertyState;
		}
		
		public OneToOnePropertyState(@NonNull EObject eObject, @NonNull EReference eFeature) {
			super(eObject, eFeature);
			assert !eFeature.isMany();
			assert eFeature.getEOpposite() != null;
			assert !eFeature.getEOpposite().isMany();
		}

		private OneToOnePropertyState(@NonNull EObject eObject, @NonNull EReference eFeature, @Nullable EObject eOpposite) {
			super(eObject, eFeature, eOpposite);
			assert !eFeature.isMany();
			assert eFeature.getEOpposite() != null;
			assert !eFeature.getEOpposite().isMany();
			assert eObject.eGet(eFeature) == eOpposite;
		}
	}
	
	/** @noimplement */
	protected static interface Invocation
	{
		/**
		 * Execute the mapping invocation.
		 */
 		boolean execute() throws InvocationFailedException, ReflectiveOperationException;

 		/**
		 * Execute the mapping invocation.
		 */
 		void insertAfter(@NonNull Invocation predecessor);
 		
 		/**
 		 * Return true if a mapping invocation for thatClass with thoseValues would be a re-invocation of this invocation,
  		 */
		boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object[] thoseValues);

		/**
		 * Remove this Invocation from a list, which may be the blocked or unblocked invocations list.
		 */
		void remove();
	}

	protected static abstract class AbstractInvocation implements Invocation
	{
		private @NonNull AbstractInvocation prev = this;
		private @NonNull AbstractInvocation next = this;
		
		@Override
		public void insertAfter(@NonNull Invocation predecessor) {
			@NonNull AbstractInvocation castPredecessor = (AbstractInvocation)predecessor;
			@Nullable AbstractInvocation successor = castPredecessor.next;
			successor.prev = this;
			next = successor;
			castPredecessor.next = this;
			prev = castPredecessor;
		}
		
		@Override
		public void remove() {
			prev.next = next;
			next.prev = prev;
		}
	}
	
	/**
	 * InvocationManager supervises and provides thread safety for the listof blocked and unblock invocations.
	 */
	protected class InvocationManager
	{
		/**
		 * Head of doubly linked list of blocked invocations.
		 */
		private @Nullable AbstractInvocation blockedInvocations = null;

		/**
		 * Head of doubly linked list of unblocked invocations.
		 */
		private @Nullable AbstractInvocation unblockedInvocations = null;	
	    
		private synchronized void block(@NonNull Invocation invocation, @NonNull PropertyState propertyState) {
			AbstractInvocation castInvocation = (AbstractInvocation) invocation;
			AbstractInvocation blockedInvocations2 = blockedInvocations;
			if (blockedInvocations2 == null) {
				blockedInvocations = castInvocation;
			}
			else {
				castInvocation.insertAfter(blockedInvocations2.prev);
			}
   			propertyState.block(invocation);
		}
			
	    public void flush() throws ReflectiveOperationException {
			while (unblockedInvocations != null) {
	    		AbstractInvocation invocation = null;
	    		synchronized (this) {
	    	    	AbstractInvocation unblockedInvocations2 = unblockedInvocations;
	    			if (unblockedInvocations2 != null) {
	    				invocation = unblockedInvocations2;
	    				unblockedInvocations = unblockedInvocations2.next;
	    				if (unblockedInvocations == invocation) {
	    					unblockedInvocations = null;
	    				}
	    				invocation.remove();
	    			}
	    		}
	    		if (invocation != null) {
	        		invoke(invocation);
	    		}
	    	}
	    }
		
	    public <T extends Invocation> void invoke(@NonNull Invocation invocation) throws ReflectiveOperationException {
    		try {
    			invocation.execute();
    			flush();
    		}
    		catch (InvocationFailedException e) {
     			block(invocation, e.propertyState);
    		}
	    }
	    
		public synchronized void unblock(@NonNull Invocation invocation) {
			AbstractInvocation castInvocation = (AbstractInvocation) invocation;
			if (blockedInvocations == castInvocation) {
				blockedInvocations = castInvocation.next;
				if (blockedInvocations == castInvocation) {
					blockedInvocations = null;
				}
			}
			castInvocation.remove();
			AbstractInvocation unblockedInvocations2 = unblockedInvocations;
			if (unblockedInvocations2 == null) {
				unblockedInvocations = castInvocation;
			}
			else {
				castInvocation.insertAfter(unblockedInvocations2.prev);
			}
		}
	}

	protected class ObjectManager
	{
		/**
		 * This unpleasant Map of Maps is a pathfinder before embarking on slotted objects that merge user and overhead
		 * in a single object. The first map is then a null lookup and the nested map is an index within the object. 
		 */
		private Map<EObject, Map<EStructuralFeature, PropertyState>> map = new HashMap<EObject, Map<EStructuralFeature, PropertyState>>();
		
		public synchronized void assigned(@NonNull EObject eObject, /*@NonNull*/ EStructuralFeature eFeature, @Nullable Object ecoreValue) {
			assert eFeature != null;
			Map<EStructuralFeature, PropertyState> objectState = getObjectState(eObject);
			PropertyState propertyState = objectState.get(eFeature);
			if (propertyState != null) {
				propertyState.assigned(this, eObject, eFeature, ecoreValue);		
			}
			else {
				if (eFeature instanceof EReference) {
					EReference eReference = (EReference)eFeature;
					EReference eOppositeReference = eReference.getEOpposite();
					if (eOppositeReference != null) {
						if (eReference.isMany()) {
							assert ecoreValue != null;
							if (eOppositeReference.isMany()) {
								propertyState = ManyToManyPropertyState.create(this, eObject, eReference, eOppositeReference);
							}
							else {
								propertyState = new OneToManyContainerPropertyState(eObject, eOppositeReference, ecoreValue);
							}
						}
						else {
							if (eOppositeReference.isMany()) {
								assert ecoreValue != null;
								propertyState = OneToManyElementPropertyState.create(this, eObject, eReference, eOppositeReference, (EObject)ecoreValue);
							}
							else if ((ecoreValue != null) || isIncremental()) {
								propertyState = OneToOnePropertyState.create(this, eObject, eReference, eOppositeReference, (EObject)ecoreValue);
							}
							else {
								propertyState = new PropertyState(eObject, eFeature, ecoreValue);
							}
						}
					}
				}
				else {
					propertyState = new PropertyState(eObject, eFeature, ecoreValue);
				}
				objectState.put(eFeature, propertyState);
			}
		}

		public synchronized <G,S> G get(@NonNull EObject eObject, /*@NonNull*/ EStructuralFeature eFeature) {
			assert eFeature != null;
			PropertyState propertyState = getPropertyState(eObject, eFeature);
			return propertyState.get(this, eObject, eFeature);
		}

		public synchronized @NonNull PropertyState getPropertyState(@NonNull EObject eObject, @NonNull EStructuralFeature eFeature) {
			assert eFeature != null;
			Map<EStructuralFeature, PropertyState> objectState = getObjectState(eObject);
			PropertyState propertyState = objectState.get(eFeature);
			if (propertyState == null) {
				if (eFeature instanceof EReference) {
					EReference eReference = (EReference)eFeature;
					EReference eOppositeReference = eReference.getEOpposite();			// FIXME there is always a Pivot opposite
					if (eOppositeReference != null) {
						if (eReference.isMany()) {
							if (eOppositeReference.isMany()) {
								propertyState = new ManyToManyPropertyState(eObject, eReference);
							}
							else {
								propertyState = new OneToManyContainerPropertyState(eObject, eReference);
							}
						}
						else {
							if (eOppositeReference.isMany()) {
								propertyState = new OneToManyElementPropertyState(eObject, eReference);
							}
							else {
								propertyState = new OneToOnePropertyState(eObject, eReference);
							}
						}
					}
				}
				if (propertyState == null) {
					propertyState = new PropertyState(eObject, eFeature);
				}
				objectState.put(eFeature, propertyState);
			}
			return propertyState;
		}

		private @NonNull Map<EStructuralFeature, PropertyState> getObjectState(@NonNull EObject eObject) {
			Map<EStructuralFeature, PropertyState> feature2state = map.get(eObject);
			if (feature2state == null) {
				feature2state = new HashMap<EStructuralFeature, PropertyState>();
				map.put(eObject, feature2state);
			}
			return feature2state;
		}

		public void unblock(@NonNull Invocation anInvocation) {
			invocationManager.unblock(anInvocation);
		}
	}
	
	protected class Model implements TypedModelInstance
	{
		protected final @NonNull String name;
		private @Nullable Set<EObject> allEObjects = null;
		private @Nullable List<EObject> rootEObjects = null;
		private @Nullable Map<EClass, Set<Integer>> eClass2allClassIndexes = null;

		/**
		 * All possible allInstances() returns indexed by the ClassIndex of the ClassId for which allInstances() may be invoked.
		 */
		private final @Nullable Set<EObject>[] classIndex2objects;
		
		public Model(@NonNull String name, @Nullable PropertyId[] propertyIndex2propertyId, @Nullable ClassId[] classIndex2classId, @Nullable int[][] classIndex2allClassIndexes) {
			this.name = name;
			//
			//	Prepare the allInstances() fields
			//
			if (classIndex2classId != null) {
		    	assert classIndex2allClassIndexes != null;
		    	int classIds = classIndex2classId.length;
				@SuppressWarnings("unchecked")Set<EObject>[] classIndex2objects = (Set<EObject>[]) new HashSet<?>[classIds];
				this.classIndex2objects = classIndex2objects;
		        for (int i = 0; i < classIds; i++) {
		        	classIndex2objects[i] = new HashSet<EObject>();
		        }
			}
			else {
		    	this.classIndex2objects = null;
			}
		}

		/**
		 * Add eObject to the caches.
		 * <p>
		 * If eClass2allClassIndexes is non-null, eObject is added to the allInstances() caches potentially updating eClass2allClassIndexes with
		 * the state of a new EClass.
		 * <p>
		 * If eClass2allPropertyIndexes is non-null, eObject is added to the unnavigable opposites caches potentially updating eClass2allPropertyIndexes with
		 * the state of a new EClass.
		 */
	    private void accumulateEObject(@Nullable Map<EClass, Set<Integer>> eClass2allClassIndexes,
	    		@Nullable Map<EClass, List<Integer>> eClass2allPropertyIndexes, @Nullable Map<EReference, Integer> eReference2propertyIndex,
	    		@NonNull EObject eObject) {
			EClass eClass = ClassUtil.nonNullEMF(eObject.eClass());
			if (eClass2allClassIndexes != null) {
				Set<Integer> allClassIndexes = eClass2allClassIndexes.get(eClass);
				if (allClassIndexes == null) {
					allClassIndexes = getClassIndexes(eClass);
					eClass2allClassIndexes.put(eClass, allClassIndexes);
				}
				for (Integer classIndex : allClassIndexes) {
					assert classIndex2objects != null;
					classIndex2objects[classIndex].add(eObject);
				}
			}
			if (eClass2allPropertyIndexes != null) {
				assert eReference2propertyIndex != null;
				List<Integer> allPropertyIndexes = eClass2allPropertyIndexes.get(eClass);
				if (allPropertyIndexes == null) {
					allPropertyIndexes = getOppositePropertyIndexes(eReference2propertyIndex, eClass);
					eClass2allPropertyIndexes.put(eClass, allPropertyIndexes);
				}
				for (Integer propertyIndex : allPropertyIndexes) {
					assert propertyIndex2eReference != null;
					EReference eReference = propertyIndex2eReference[propertyIndex];
					if (eReference == null) {
						assert propertyIndex2propertyId != null;
						PropertyId propertyId = propertyIndex2propertyId[propertyIndex];
						eReference = (EReference) NameUtil.getENamedElement(eClass.getEAllStructuralFeatures(), propertyId.getName());
					}
					assert object2oppositeObject != null;
					object2oppositeObject[propertyIndex].put((EObject)eObject.eGet(eReference), eObject);
				}
			}
		}

		public void add(@NonNull EObject eObject) {
			Set<EObject> allEObjects2 = allEObjects;
			if (allEObjects2 == null) {
				allEObjects = allEObjects2 = new HashSet<EObject>();
			}
			rootEObjects = null;
			allEObjects2.add(eObject);
			if ((eClass2allClassIndexes == null) && (classId2classIndexes != null) && (classIndex2objects != null)) {
				eClass2allClassIndexes = new HashMap<EClass, Set<Integer>>();
			}
			accumulateEObject(eClass2allClassIndexes, null, null, eObject);
		}
		
		/**
	     * Add eRootObjects to the modelIndex model.
	     */
		public void addRootObjects(@NonNull Iterable<? extends EObject> eRootObjects) {
			List<EObject> rootEObjects2 = rootEObjects;
			if (rootEObjects2 == null) {
				rootEObjects = rootEObjects2 = new ArrayList<EObject>();
			}
			allEObjects = null;
	    	Map<EClass, Set<Integer>> eClass2allClassIndexes = null;
			Map<EClass, List<Integer>> eClass2allPropertyIndexes = null;
			Map<EReference, Integer> eReference2propertyIndex = null;
			if ((classId2classIndexes != null) && (classIndex2objects != null)) {
				eClass2allClassIndexes = new HashMap<EClass, Set<Integer>>();
			}
			if (propertyIndex2propertyId != null) {
				eClass2allPropertyIndexes = new HashMap<EClass, List<Integer>>();
				eReference2propertyIndex = new HashMap<EReference, Integer>();
			}
			for (EObject eRootObject : eRootObjects) {
				if (eRootObject != null) {
					//
					//	Accumulate the root object in the model extent
					//
					rootEObjects2.add(eRootObject);
					//
					//	Accumulate the root object and all its child objects in the allInstances() returns
					//
					if ((eClass2allClassIndexes != null) || (eClass2allPropertyIndexes != null)) {
						accumulateEObject(eClass2allClassIndexes, eClass2allPropertyIndexes, eReference2propertyIndex, eRootObject);
						for (TreeIterator<EObject> tit = eRootObject.eAllContents(); tit.hasNext(); ) {
							EObject eObject = tit.next();
							if (eObject != null) {
								accumulateEObject(eClass2allClassIndexes, eClass2allPropertyIndexes, eReference2propertyIndex, eObject);
							}
						}
					}
				}
			}
		}
		
		@Override
		public @NonNull Collection<EObject> getAllObjects() {
			Set<EObject> allEObjects2 = allEObjects;
			if (allEObjects2 == null) {
				allEObjects = allEObjects2 = new HashSet<EObject>();
				if (rootEObjects != null) {
			    	for (EObject eRootObject : rootEObjects) {
			    		allEObjects2.add(eRootObject);
			        	for (TreeIterator<EObject> tit = eRootObject.eAllContents(); tit.hasNext(); ) {
			        		@SuppressWarnings("null")@NonNull EObject eObject = tit.next();
			        		allEObjects2.add(eObject);
			        	}
			    	}
				}
			}
			return allEObjects2;
		}

		@Override
		public @NonNull Collection<EObject> getObjectsOfKind(@NonNull org.eclipse.ocl.pivot.Class type) {
			Map<ClassId, Integer> classId2classIndex2 = classId2classIndex;
			if (classId2classIndex2 != null) {
				TypeId classId = type.getTypeId();
				Integer classIndex = classId2classIndex2.get(classId);
				if (classIndex != null) {
					Set<EObject>[] classIndex2objects2 = classIndex2objects;
					if (classIndex2objects2 != null) {
						Set<EObject> objects = classIndex2objects2[classIndex];
						if (objects !=  null) {
							return objects;
						}
					}
				}
			}
			return EMPTY_EOBJECT_LIST;
		}

		@Override
		public @NonNull Collection<EObject> getObjectsOfType(@NonNull org.eclipse.ocl.pivot.Class type) {
			throw new UnsupportedOperationException();
		}

		/**
	     * Return all objects in the modelIndex model that conform to eClass.
	     *
	    protected @NonNull <T extends EObject> List<T> getObjectsByType(@NonNull EClass eClass) {
	    	List<T> selectedEObjects = new ArrayList<T>();
			if (rootEObjects != null) {
		    	for (EObject eRootObject : rootEObjects) {
		    		if (eClass.isInstance(eRootObject)) {
		    			@SuppressWarnings("unchecked") T eObject2 = (T)eRootObject;
		    			selectedEObjects.add(eObject2);
		    		}
		        	for (TreeIterator<EObject> tit = eRootObject.eAllContents(); tit.hasNext(); ) {
		        		@SuppressWarnings("null")@NonNull EObject eObject = tit.next();
			    		if (eClass.isInstance(eObject)) {
			    			@SuppressWarnings("unchecked") T eObject2 = (T)eObject;
			    			selectedEObjects.add(eObject2);
			    		}
		        	}
		    	}
			}
			return selectedEObjects;
		} */

		@Override
		public @NonNull Collection<EObject> getRootObjects() {
			List<EObject> rootEObjects2 = rootEObjects;
			if (rootEObjects2 == null) {
				rootEObjects = rootEObjects2 = new ArrayList<EObject>();
				if (allEObjects != null) {
			    	for (EObject eObject : allEObjects) {
			    		if (eObject.eContainer() == null) {
			    			rootEObjects2.add(eObject);
			    		}
			    	}
				}
			}
			return rootEObjects2;
		}

		@Override
		public String toString() {
			return name + " " + (rootEObjects != null ? rootEObjects.size() : "null") +  "/" + (allEObjects != null ? allEObjects.size() : "null");
		}

		@Override
		public @NonNull String getName() {
			return name;
		}
	}
	
	protected final @NonNull Executor executor;
	/** deprecated use executor */
	@Deprecated
	protected final @NonNull Evaluator evaluator;
	protected final @NonNull IdResolver.IdResolverExtension idResolver;
	protected final @NonNull Model[] models;
	protected final @NonNull Map<String, Integer> modelIndexes = new HashMap<String, Integer>();

	/**
	 * Unchanging configured list PropertyId for which unnavigable opposite navigation may occur indexed by the PropertyIndex for that PropertyId.
	 */
	private final @Nullable PropertyId[] propertyIndex2propertyId;

	/**
	 * Unchanging configured map from the PropertyId for which unnavigable opposite navigation may occur to the PropertyIndex for that PropertyId.
	 */
	private final @Nullable Map<PropertyId, Integer> propertyId2propertyIndex;

	/**
	 * Unchanging configured map from the PropertyIndex to the EReference for the opposite property navigation.
	 */
	private final @Nullable EReference[] propertyIndex2eReference;

	/**
	 * Unchanging maps from an EObject to its opposite using the Property whose PropertyIndex indexes the map.
	 */
	private final @Nullable Map<EObject, EObject>[] object2oppositeObject;

	/**
	 * Unchanging configured map from the ClassId for which allInstances() may be invoked to the ClassIndex for that ClassId.
	 */
	private final @Nullable Map<ClassId, Integer> classId2classIndex;

	/**
	 * Evolving map from the ClassId of some model object's class to all the ClassIndexes for which the model object
	 * might contribute to an allInstances() return. This is initially populated for the ClassIndexes of the ClassIds
	 * for which allInstances() may be invoked. It evolves lazily to include the ClassIds for all objects in the user
	 * models.
	 */
	private final @Nullable Map<ClassId, Set<Integer>> classId2classIndexes;
	
	/**
	 * Map from invocation identity to one or more invocations with that identity. Single map entries use the
	 * Invocation directly as the entry. Colliding entries use a List<Invocation> for the collisions.
	 * <br>
	 * This map is used to inhibit repeated invocations of the invocationId.
	 */
	private final @NonNull Map<Integer, Object> invocationId2invocation = new HashMap<Integer, Object>();

	/**
	 * Manager for the blocked and unblocked invocations.
	 */
	protected final @NonNull InvocationManager invocationManager = new InvocationManager();

	/**
	 * Manager for the auxiliary object and property state.
	 */
	protected final @NonNull ObjectManager objectManager = new ObjectManager();
	
	/** @deprecated use Executor in constructor */
	@Deprecated
	protected AbstractTransformer(@NonNull Evaluator evaluator, @NonNull String[] modelNames,
			@Nullable PropertyId[] propertyIndex2propertyId, @Nullable ClassId[] classIndex2classId, @Nullable int[][] classIndex2allClassIndexes) {
		this(ValueUtil.getExecutor(evaluator), modelNames, propertyIndex2propertyId, classIndex2classId, classIndex2allClassIndexes);
	}
	protected AbstractTransformer(@NonNull Executor executor, @NonNull String[] modelNames,
				@Nullable PropertyId[] propertyIndex2propertyId, @Nullable ClassId[] classIndex2classId, @Nullable int[][] classIndex2allClassIndexes) {
		this.executor = executor;
		this.evaluator = executor;
		this.idResolver = (IdResolver.IdResolverExtension)executor.getIdResolver();
		this.models = new Model[modelNames.length];
		for (int i = 0; i < modelNames.length; i++) {
			@SuppressWarnings("null")@NonNull String modelName = modelNames[i];
			models[i] = new Model(modelName, propertyIndex2propertyId, classIndex2classId, classIndex2allClassIndexes);
			modelIndexes.put(modelName,  i);
		}
		//
		//	Prepare the unnavigable opposite property fields
		//
		if (propertyIndex2propertyId != null) {
	    	int propertyIds = propertyIndex2propertyId.length;
	    	this.propertyIndex2propertyId = propertyIndex2propertyId;
			this.propertyId2propertyIndex = new HashMap<PropertyId, Integer>(propertyIds);
			this.propertyIndex2eReference = new EReference[propertyIds];
			for (int propertyIndex = 0; propertyIndex < propertyIds; propertyIndex++) {
				PropertyId propertyId = propertyIndex2propertyId[propertyIndex];
				propertyId2propertyIndex.put(propertyId, propertyIndex);
			}
			@SuppressWarnings("unchecked")Map<EObject,EObject>[] object2oppositeObject = (Map<EObject,EObject>[]) new HashMap<?,?>[propertyIds];
			this.object2oppositeObject = object2oppositeObject;
	        for (int i = 0; i < propertyIds; i++) {
	        	object2oppositeObject[i] = new HashMap<EObject, EObject>();
	        }
		}
		else {
	    	this.propertyIndex2propertyId = null;
	    	this.propertyId2propertyIndex = null;
	    	this.propertyIndex2eReference = null;
	    	this.object2oppositeObject = null;
		}
		//
		//	Prepare the allInstances() fields
		//
		if (classIndex2classId != null) {
	    	assert classIndex2allClassIndexes != null;
	    	int classIds = classIndex2classId.length;
			this.classId2classIndex = new HashMap<ClassId, Integer>(classIds);
	    	this.classId2classIndexes = new HashMap<ClassId, Set<Integer>>(classIds);
			for (int classIndex = 0; classIndex < classIds; classIndex++) {
				ClassId classId = classIndex2classId[classIndex];
				classId2classIndex.put(classId, classIndex);
				Set<Integer> superClassIndexes = new HashSet<Integer>();
				for (int allClassIndex : classIndex2allClassIndexes[classIndex]) {
					superClassIndexes.add(allClassIndex);
				}
				classId2classIndexes.put(classId, superClassIndexes);
			}
		}
		else {
	    	this.classId2classIndex = null;
	    	this.classId2classIndexes = null;
		}
	}

	/**
     * Add eRootObjects to the modelIndex model.
     */
    @Override
	public void addRootObjects(@NonNull String modelName, @NonNull Iterable<? extends EObject> eRootObjects) {
    	Integer modelIndex = modelIndexes.get(modelName);
    	if (modelIndex == null) {
    		throw new IllegalStateException("Unknown model name '" + modelName + "'");
    	}
    	models[modelIndex].addRootObjects(eRootObjects);
	}
	
    /**
     * Create and return the invocation for an invocationClass and boundValues.
     * Returns null if already created.
     * @throws ReflectiveOperationException 
     */
    private @Nullable Invocation createFirst(@NonNull Constructor<? extends Invocation> constructor, @NonNull Object... boundValues) throws ReflectiveOperationException {
    	Class<? extends Invocation> invocationClass = constructor.getDeclaringClass();
    	assert invocationClass != null;
		int hashCode = System.identityHashCode(invocationClass);
    	for (Object boundValue : boundValues) {
    		hashCode = 3 * hashCode + idResolver.oclHashCode(boundValue);
    	}
    	Object zeroOrMoreInvocations = invocationId2invocation.get(hashCode);
    	Invocation oneInvocation = null;
		List<Invocation> twoOrMoreInvocations2 = null;
    	if (zeroOrMoreInvocations instanceof Invocation) {
    		oneInvocation = (Invocation)zeroOrMoreInvocations;
    		if ((invocationClass == oneInvocation.getClass()) && oneInvocation.isEqual(idResolver, boundValues)) {
	    		return oneInvocation;
	    	}
    	}
    	else if (zeroOrMoreInvocations instanceof List<?>) {
    		@SuppressWarnings("unchecked")List<Invocation> zeroOrMoreInvocations2 = (List<Invocation>)zeroOrMoreInvocations;
			twoOrMoreInvocations2 = zeroOrMoreInvocations2;
			for (Invocation anInvocation : twoOrMoreInvocations2) {
		   		if ((invocationClass == anInvocation.getClass()) && anInvocation.isEqual(idResolver, boundValues)) {
     	    		return anInvocation;
    	    	}
    		}
    	}
		Invocation theInvocation = constructor.newInstance(this, boundValues);
		if (zeroOrMoreInvocations == null) {
			invocationId2invocation.put(hashCode, theInvocation);
		}
		else {
			if (twoOrMoreInvocations2 == null) {
	    		twoOrMoreInvocations2 = new ArrayList<Invocation>(4);
    			twoOrMoreInvocations2.add(oneInvocation);
			}
			twoOrMoreInvocations2.add(theInvocation);
			invocationId2invocation.put(hashCode, twoOrMoreInvocations2);
		}
		return theInvocation;
    }
    
	@Override
	public @NonNull Set<EObject> get(@NonNull org.eclipse.ocl.pivot.Class type) {
		return new HashSet<EObject>(models[0].getObjectsOfKind(type));
	} 

	/**
	 * Return the Set of all ClassIndexes to which an EClass instance contributes to allInstances() returns.
	 */
	private @NonNull Set<Integer> getClassIndexes(@NonNull EClass eClass) {
	//	ClassId classId = IdManager.getClassId(eClass);
		EPackage ePackage = ClassUtil.nonNullEMF(eClass.getEPackage());
		PackageId packageId = IdManager.getPackageId(ePackage);
		String className = ClassUtil.nonNullEMF(eClass.getName());		// FIXME Original name
		ClassId classId = packageId.getClassId(className, eClass.getETypeParameters().size());
		assert classId2classIndexes != null;
		Set<Integer> classIndexes = classId2classIndexes.get(classId);
		if (classIndexes == null) {
			classIndexes = new HashSet<Integer>();
			for (@SuppressWarnings("null")@NonNull EClass eSuperClass : eClass.getESuperTypes()) {
				Set<Integer> partialResult = getClassIndexes(eSuperClass);
				classIndexes.addAll(partialResult);
			}
			assert classId2classIndexes != null;
			classId2classIndexes.put(classId, classIndexes);
		}
		return classIndexes;
	}

	/**
     * Return all objects in the modelIndex model that conform to eClass.
     *
    protected @NonNull <T extends EObject> List<T> getObjectsByType(int modelIndex, @NonNull EClass eClass) {
		return models[modelIndex].getObjectsByType(eClass);
	} */

	/**
	 * Return the List of all PropertyIndexes for which an EClass instance could be the unnavigable opposite.
	 * eReference2propertyIndex contains known equivalences and may be updated if more are discovered
	 * using -1 as a propertyIndex for which no unnavigable opposite is appropriate.
	 */
    private @NonNull List<Integer> getOppositePropertyIndexes(@NonNull Map<EReference, Integer> eReference2propertyIndex, @NonNull EClass eClass) {
    	List<Integer> propertyIndexes = null;
    	for (EStructuralFeature eStructuralFeature : eClass.getEAllStructuralFeatures()) {
    		if (eStructuralFeature instanceof EReference) {
    			EReference eReference = (EReference)eStructuralFeature;
				Integer propertyIndex = eReference2propertyIndex.get(eReference);
				if (propertyIndex == null) {
	    			if ((eReference.getEOpposite() == null) && !eReference.isDerived() && !eReference.isTransient() && !eReference.isVolatile()) {
	    				//	PropertyId propertyId = IdManager.getPropertyId(eReference);
	    				EClass eContainingClass = eReference.getEContainingClass();
	    				EPackage ePackage = ClassUtil.nonNullEMF(eContainingClass.getEPackage());
	    				PackageId packageId = IdManager.getPackageId(ePackage);
	    				String className = ClassUtil.nonNullEMF(eContainingClass.getName());				// FIXME Original name
	    				ClassId classId = packageId.getClassId(className, eContainingClass.getETypeParameters().size());
	    				String propertyName = ClassUtil.nonNullEMF(eReference.getName());		// FIXME Original name
	    				PropertyId propertyId = classId.getPropertyId(propertyName);
	    				assert propertyId2propertyIndex != null;
	    				propertyIndex = propertyId2propertyIndex.get(propertyId);
	    			}
	    			if (propertyIndex == null) {
	    				propertyIndex = -1;
	    			}
					eReference2propertyIndex.put(eReference, propertyIndex);
				}
				if (propertyIndex >= 0) {
					if (propertyIndexes == null) {
						propertyIndexes = new ArrayList<Integer>();
					}
					propertyIndexes.add(propertyIndex);
				}
    		}
    	}
		return propertyIndexes != null ? propertyIndexes : EMPTY_INDEX_LIST;
	}

	/**
     * Return all the containerless objects in the modelName model.
     */
    @Override
	public @NonNull Collection<EObject> getRootObjects(@NonNull String modelName) {
    	Integer modelIndex = modelIndexes.get(modelName);
    	if (modelIndex == null) {
    		throw new IllegalStateException("Unknown model name '" + modelName + "'");
    	}
    	return models[modelIndex].getRootObjects();
	}
	
    /**
     * Invoke a mapping with the given constructor with a given set of boundValues once. This shortform of invokeOnce
     * should only be used when it is known that recursive invocation is impossible.
     * 
     * @throws ReflectiveOperationException 
     */
    public <T extends Invocation> void invoke(@NonNull Constructor<T> constructor, @NonNull Object... boundValues) throws ReflectiveOperationException {
    	@SuppressWarnings("null")@NonNull Invocation invocation = constructor.newInstance(this, boundValues);
    	invocationManager.invoke(invocation);
    }
	
    /**
     * Invoke a mapping with the given constructor with a given set of boundValues once. Repeated invocation attempts are ignored.
	 *
     * @throws ReflectiveOperationException 
     */
    public <T extends Invocation> void invokeOnce(@NonNull Constructor<T> constructor, @NonNull Object... boundValues) throws ReflectiveOperationException {
    	Invocation invocation = createFirst(constructor, boundValues);
    	if (invocation != null) {
    		invocationManager.invoke(invocation);
    	}
    }
	
	private boolean isIncremental() {
		return false;
	}
}
