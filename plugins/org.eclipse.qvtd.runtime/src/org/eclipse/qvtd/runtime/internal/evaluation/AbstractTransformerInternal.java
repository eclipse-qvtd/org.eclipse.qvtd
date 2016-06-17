/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.runtime.internal.evaluation;


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
import org.eclipse.ocl.pivot.evaluation.AbstractModelManager;
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
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.qvtd.runtime.evaluation.AbstractTransformer;
import org.eclipse.qvtd.runtime.evaluation.AbstractTypedModelInstance;
import org.eclipse.qvtd.runtime.evaluation.ExecutionVisitable;
import org.eclipse.qvtd.runtime.evaluation.Invocation;
import org.eclipse.qvtd.runtime.evaluation.InvocationFailedException;
import org.eclipse.qvtd.runtime.evaluation.InvocationManager;
import org.eclipse.qvtd.runtime.evaluation.ObjectManager;
import org.eclipse.qvtd.runtime.evaluation.Transformer;

/**
 * The abstract implementation of an auto-generated transformation provides the shared infrastructure for maintaining
 * models and deferring invocation of not-ready mapping invocations.
 * 
 * @since 1.1
 */
public abstract class AbstractTransformerInternal extends AbstractModelManager implements Transformer, ExecutionVisitable
{	
	private static final @NonNull List<@NonNull Integer> EMPTY_INDEX_LIST = Collections.emptyList();
	private static final @NonNull List<@NonNull Object> EMPTY_EOBJECT_LIST = Collections.emptyList();
    
	protected class Model extends AbstractTypedModelInstance
	{
		protected final @NonNull String name;
		private @Nullable Set<@NonNull Object> allEObjects = null;
		private @Nullable List<@NonNull Object> rootEObjects = null;
		private @Nullable Map<@NonNull EClass, @NonNull Set<@NonNull Integer>> eClass2allClassIndexes = null;

		/**
		 * All possible allInstances() returns indexed by the ClassIndex of the ClassId for which allInstances() may be invoked.
		 */
		private final @NonNull Set<@NonNull Object>[] classIndex2objects;
		
		public Model(@NonNull String name, @NonNull PropertyId @Nullable [] propertyIndex2propertyId, @NonNull ClassId @Nullable [] classIndex2classId, int @Nullable [] @NonNull [] classIndex2allClassIndexes) {
			this.name = name;
			//
			//	Prepare the allInstances() fields
			//
			if (classIndex2classId != null) {
		    	assert classIndex2allClassIndexes != null;
		    	int classIds = classIndex2classId.length;
				@SuppressWarnings("unchecked")@NonNull Set<Object> @NonNull [] classIndex2objects = (@NonNull Set<Object> @NonNull []) new @NonNull HashSet<?> @NonNull [classIds];
				this.classIndex2objects = classIndex2objects;
		        for (int i = 0; i < classIds; i++) {
		        	classIndex2objects[i] = new HashSet<Object>();
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
	    private void accumulateEObject(@Nullable Map<@NonNull EClass, @NonNull Set<@NonNull Integer>> eClass2allClassIndexes,
	    		@Nullable Map<@NonNull EClass, @NonNull List<@NonNull Integer>> eClass2allPropertyIndexes, @Nullable Map<@NonNull EReference, @NonNull Integer> eReference2propertyIndex,
	    		@NonNull Object eObject) {
			EClass eClass = eClass(eObject);
			if (eClass2allClassIndexes != null) {
				Set<@NonNull Integer> allClassIndexes = eClass2allClassIndexes.get(eClass);
				if (allClassIndexes == null) {
					allClassIndexes = getClassIndexes(eClass);
					eClass2allClassIndexes.put(eClass, allClassIndexes);
				}
				Set<@NonNull Object>[] classIndex2objects2 = classIndex2objects;
				assert classIndex2objects2 != null;
				for (@NonNull Integer classIndex : allClassIndexes) {
					classIndex2objects2[classIndex].add(eObject);
				}
			}
			if (eClass2allPropertyIndexes != null) {
				assert eReference2propertyIndex != null;
				List<@NonNull Integer> allPropertyIndexes = eClass2allPropertyIndexes.get(eClass);
				if (allPropertyIndexes == null) {
					allPropertyIndexes = getOppositePropertyIndexes(eReference2propertyIndex, eClass);
					eClass2allPropertyIndexes.put(eClass, allPropertyIndexes);
				}
				Map<@NonNull Object, @NonNull Object>[] object2oppositeObject2 = object2oppositeObject;
				assert object2oppositeObject2 != null;
				for (@NonNull Integer propertyIndex : allPropertyIndexes) {
					assert propertyIndex2eReference != null;
					EReference eReference = propertyIndex2eReference[propertyIndex];
					if (eReference == null) {
						assert propertyIndex2propertyId != null;
						PropertyId propertyId = propertyIndex2propertyId[propertyIndex];
						assert propertyId != null;
						eReference = (EReference) NameUtil.getENamedElement(eClass.getEAllStructuralFeatures(), propertyId.getName());
						assert eReference != null;
					}
					Object object = eGet(eObject, eReference);
					assert object != null;
					object2oppositeObject2[propertyIndex].put(object, eObject);
				}
			}
		}

		public void add(@NonNull EObject eObject) {
			Set<@NonNull Object> allEObjects2 = allEObjects;
			if (allEObjects2 == null) {
				allEObjects = allEObjects2 = new HashSet<@NonNull Object>();
			}
			rootEObjects = null;
			allEObjects2.add(eObject);
			if ((eClass2allClassIndexes == null) && (classId2classIndexes != null) && (classIndex2objects != null)) {
				eClass2allClassIndexes = new HashMap<@NonNull EClass, @NonNull Set<@NonNull Integer>>();
			}
			accumulateEObject(eClass2allClassIndexes, null, null, eObject);
		}
		
		/**
	     * Add eRootObjects to the modelIndex model.
	     */
		public void addRootObjects(@NonNull Iterable<@NonNull ? extends Object> eRootObjects) {
			List<@NonNull Object> rootEObjects2 = rootEObjects;
			if (rootEObjects2 == null) {
				rootEObjects = rootEObjects2 = new ArrayList<@NonNull Object>();
			}
			allEObjects = null;
	    	Map<@NonNull EClass, @NonNull Set<@NonNull Integer>> eClass2allClassIndexes = null;
			Map<@NonNull EClass, @NonNull List<@NonNull Integer>> eClass2allPropertyIndexes = null;
			Map<@NonNull EReference, @NonNull Integer> eReference2propertyIndex = null;
			if ((classId2classIndexes != null) && (classIndex2objects != null)) {
				eClass2allClassIndexes = new HashMap<@NonNull EClass, @NonNull Set<@NonNull Integer>>();
			}
			if (propertyIndex2propertyId != null) {
				eClass2allPropertyIndexes = new HashMap<@NonNull EClass, @NonNull List<@NonNull Integer>>();
				eReference2propertyIndex = new HashMap<@NonNull EReference, @NonNull Integer>();
			}
			for (Object eRootObject : eRootObjects) {
				//
				//	Accumulate the root object in the model extent
				//
				rootEObjects2.add(eRootObject);
				//
				//	Accumulate the root object and all its child objects in the allInstances() returns
				//
				if ((eClass2allClassIndexes != null) || (eClass2allPropertyIndexes != null)) {
					accumulateEObject(eClass2allClassIndexes, eClass2allPropertyIndexes, eReference2propertyIndex, eRootObject);
					for (TreeIterator<? extends Object> tit = eAllContents(eRootObject); tit.hasNext(); ) {
						Object eObject = tit.next();
						if (eObject != null) {
							accumulateEObject(eClass2allClassIndexes, eClass2allPropertyIndexes, eReference2propertyIndex, eObject);
						}
					}
				}
			}
		}
		
		@Override
		public @NonNull Collection<@NonNull Object> getAllObjects() {
			Set<@NonNull Object> allEObjects2 = allEObjects;
			if (allEObjects2 == null) {
				allEObjects = allEObjects2 = new HashSet<@NonNull Object>();
				if (rootEObjects != null) {
			    	for (@NonNull Object eRootObject : rootEObjects) {
			    		allEObjects2.add(eRootObject);
			        	for (TreeIterator<? extends Object> tit = eAllContents(eRootObject); tit.hasNext(); ) {
			        		Object eObject = tit.next();
			        		if (eObject != null) {
			        			allEObjects2.add(eObject);
			        		}
			        	}
			    	}
				}
			}
			return allEObjects2;
		}

		@Override
		public @NonNull Collection<@NonNull Object> getObjectsOfKind(org.eclipse.ocl.pivot.@NonNull Class type) {
			Map<@NonNull ClassId, @NonNull Integer> classId2classIndex2 = classId2classIndex;
			if (classId2classIndex2 != null) {
				TypeId classId = type.getTypeId();
				Integer classIndex = classId2classIndex2.get(classId);
				if (classIndex != null) {
					Set<@NonNull Object>[] classIndex2objects2 = classIndex2objects;
					if (classIndex2objects2 != null) {
						Set<@NonNull Object> objects = classIndex2objects2[classIndex];
						if (objects !=  null) {
							return objects;
						}
					}
				}
			}
			return EMPTY_EOBJECT_LIST;
		}

		@Override
		public @NonNull Collection<@NonNull Object> getObjectsOfType(org.eclipse.ocl.pivot.@NonNull Class type) {
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
		public @NonNull Collection<@NonNull Object> getRootObjects() {
			List<@NonNull Object> rootEObjects2 = rootEObjects;
			if (rootEObjects2 == null) {
				rootEObjects = rootEObjects2 = new ArrayList<@NonNull Object>();
				if (allEObjects != null) {
			    	for (@NonNull Object eObject : allEObjects) {
			    		if (eContainer(eObject) == null) {
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
	protected final IdResolver.@NonNull IdResolverExtension idResolver;
	protected final @NonNull Model @NonNull [] models;
	protected final @NonNull Map<String, Integer> modelIndexes = new HashMap<String, Integer>();

	/**
	 * Unchanging configured list PropertyId for which unnavigable opposite navigation may occur indexed by the PropertyIndex for that PropertyId.
	 */
	private final @NonNull PropertyId @Nullable [] propertyIndex2propertyId;

	/**
	 * Unchanging configured map from the PropertyId for which unnavigable opposite navigation may occur to the PropertyIndex for that PropertyId.
	 */
	private final @Nullable Map<PropertyId, Integer> propertyId2propertyIndex;

	/**
	 * Unchanging configured map from the PropertyIndex to the EReference for the opposite property navigation.
	 */
	private final @Nullable EReference @Nullable[] propertyIndex2eReference;

	/**
	 * Unchanging maps from an EObject to its opposite using the Property whose PropertyIndex indexes the map.
	 */
	private final @NonNull Map<@NonNull Object, @NonNull Object> @Nullable [] object2oppositeObject;

	/**
	 * Unchanging configured map from the ClassId for which allInstances() may be invoked to the ClassIndex for that ClassId.
	 */
	private final @Nullable Map<@NonNull ClassId, @NonNull Integer> classId2classIndex;

	/**
	 * Evolving map from the ClassId of some model object's class to all the ClassIndexes for which the model object
	 * might contribute to an allInstances() return. This is initially populated for the ClassIndexes of the ClassIds
	 * for which allInstances() may be invoked. It evolves lazily to include the ClassIds for all objects in the user
	 * models.
	 */
	private final @Nullable Map<@NonNull ClassId, @NonNull Set<@NonNull Integer>> classId2classIndexes;

	/**
	 * Manager for the blocked and unblocked invocations.
	 */
	protected final @NonNull InvocationManager invocationManager;

	/**
	 * Manager for the auxiliary object and property state.
	 */
	protected final @NonNull ObjectManager objectManager;
	
	protected AbstractTransformerInternal(@NonNull Executor executor, @NonNull String @NonNull [] modelNames,
			@NonNull PropertyId @Nullable [] propertyIndex2propertyId, @NonNull ClassId @Nullable [] classIndex2classId, int @Nullable [] @NonNull [] classIndex2allClassIndexes) {
		this.executor = executor;
		this.evaluator = executor;
		this.idResolver = (IdResolver.IdResolverExtension)executor.getIdResolver();
		this.invocationManager = createInvocationManager();
		this.objectManager = createObjectManager();
		this.models = new @NonNull Model @NonNull [modelNames.length];
		for (int i = 0; i < modelNames.length; i++) {
			String modelName = modelNames[i];
			models[i] = new Model(modelName, propertyIndex2propertyId, classIndex2classId, classIndex2allClassIndexes);
			modelIndexes.put(modelName,  i);
		}
		//
		//	Prepare the unnavigable opposite property fields
		//
		if (propertyIndex2propertyId != null) {
	    	int propertyIds = propertyIndex2propertyId.length;
	    	this.propertyIndex2propertyId = propertyIndex2propertyId;
			HashMap<PropertyId, Integer> propertyId2propertyIndex2 = new HashMap<PropertyId, Integer>(propertyIds);
			this.propertyId2propertyIndex = propertyId2propertyIndex2;
			this.propertyIndex2eReference = new @Nullable EReference @NonNull [propertyIds];
			for (int propertyIndex = 0; propertyIndex < propertyIds; propertyIndex++) {
				PropertyId propertyId = propertyIndex2propertyId[propertyIndex];
				propertyId2propertyIndex2.put(propertyId, propertyIndex);
			}
			@SuppressWarnings("unchecked")@NonNull Map<@NonNull Object, @NonNull Object> @Nullable [] object2oppositeObject = (@NonNull Map<@NonNull Object, @NonNull Object> @NonNull []) new HashMap<?,?> @NonNull [propertyIds];
			this.object2oppositeObject = object2oppositeObject;
	        for (int i = 0; i < propertyIds; i++) {
	        	object2oppositeObject[i] = new HashMap<@NonNull Object, @NonNull Object>();
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
			HashMap<@NonNull ClassId, @NonNull Integer> classId2classIndex2 = new HashMap<@NonNull ClassId, @NonNull Integer>(classIds);
	    	HashMap<@NonNull ClassId, @NonNull Set<@NonNull Integer>> classId2classIndexes2 = new HashMap<@NonNull ClassId, @NonNull Set<@NonNull Integer>>(classIds);
			this.classId2classIndex = classId2classIndex2;
			this.classId2classIndexes = classId2classIndexes2;
			for (int classIndex = 0; classIndex < classIds; classIndex++) {
				ClassId classId = classIndex2classId[classIndex];
				classId2classIndex2.put(classId, classIndex);
				Set<Integer> superClassIndexes = new HashSet<Integer>();
				for (int allClassIndex : classIndex2allClassIndexes[classIndex]) {
					superClassIndexes.add(allClassIndex);
				}
				classId2classIndexes2.put(classId, superClassIndexes);
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
	public void addRootObjects(@NonNull String modelName, @NonNull Iterable<@NonNull ? extends Object> eRootObjects) {
    	Integer modelIndex = modelIndexes.get(modelName);
    	if (modelIndex == null) {
    		throw new IllegalStateException("Unknown model name '" + modelName + "'");
    	}
    	models[modelIndex].addRootObjects(eRootObjects);
	}

    /**
     * Create the InvocationManager. Creates a LazyInvocationManager by default.
     */
	protected @NonNull InvocationManager createInvocationManager() {
		return new LazyInvocationManager();
	}

    /**
     * Create the ObjectManager. Creates a LazyObjectManager by default.
     */
	protected @NonNull ObjectManager createObjectManager() {
		return new LazyObjectManager((LazyInvocationManager)invocationManager);
	}

	@Override
	public @NonNull Set<@NonNull Object> get(org.eclipse.ocl.pivot.@NonNull Class type) {
		return new HashSet<@NonNull Object>(models[0].getObjectsOfKind(type));
	} 

	/**
	 * Return the Set of all ClassIndexes to which an EClass instance contributes to allInstances() returns.
	 */
	private @NonNull Set<@NonNull Integer> getClassIndexes(@NonNull EClass eClass) {
	//	ClassId classId = IdManager.getClassId(eClass);
		EPackage ePackage = ClassUtil.nonNullEMF(eClass.getEPackage());
		PackageId packageId = IdManager.getPackageId(ePackage);
		String className = ClassUtil.nonNullEMF(eClass.getName());		// FIXME Original name
		ClassId classId = packageId.getClassId(className, eClass.getETypeParameters().size());
		assert classId2classIndexes != null;
		Set<@NonNull Integer> classIndexes = classId2classIndexes.get(classId);
		if (classIndexes == null) {
			classIndexes = new HashSet<@NonNull Integer>();
			for (@NonNull EClass eSuperClass : ClassUtil.nullFree(eClass.getESuperTypes())) {
				Set<@NonNull Integer> partialResult = getClassIndexes(eSuperClass);
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
    private @NonNull List<@NonNull Integer> getOppositePropertyIndexes(@NonNull Map<@NonNull EReference, @NonNull Integer> eReference2propertyIndex, @NonNull EClass eClass) {
    	List<@NonNull Integer> propertyIndexes = null;
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
						propertyIndexes = new ArrayList<@NonNull Integer>();
					}
					propertyIndexes.add(propertyIndex);
				}
    		}
    	}
		return propertyIndexes != null ? propertyIndexes : EMPTY_INDEX_LIST;
	}

	/**
     * Return all the container-less objects in the modelName model.
     */
    @Override
	public @NonNull Collection<@NonNull EObject> getRootEObjects(@NonNull String modelName) {
    	Integer modelIndex = modelIndexes.get(modelName);
    	if (modelIndex == null) {
    		throw new IllegalStateException("Unknown model name '" + modelName + "'");
    	}
    	List<@NonNull EObject> rootEObjects = new ArrayList<@NonNull EObject>();
    	for (@NonNull Object rootObject : models[modelIndex].getRootObjects()) {
    		if (rootObject instanceof EObject) {
    			rootEObjects.add((EObject)rootObject);
    		}
    	}
		return rootEObjects;
	}

	/**
     * Return all the container-less objects in the modelName model.
     */
    @Override
	public @NonNull Collection<@NonNull Object> getRootObjects(@NonNull String modelName) {
    	Integer modelIndex = modelIndexes.get(modelName);
    	if (modelIndex == null) {
    		throw new IllegalStateException("Unknown model name '" + modelName + "'");
    	}
    	return models[modelIndex].getRootObjects();
	}

    /**
     * The default handler for an exception during mapping execution rethrows an InvocationFailedException so that the
     * caller may organize a re-exection when the reqired memory access can succeed. Errors are rethrown and should
     * propagate to the transformation invoker, except for AssertionError which is is absorbed if the user has configured
     * AbstractTransformer.EXCEPTIONS to observe them on the console. All other exceptions are just absorbed since they
     * may represent a predicate failure.
     */
    protected boolean handleExecutionFailure(@NonNull String mappingName, @NonNull Throwable e) throws InvocationFailedException {
    	if (e instanceof InvocationFailedException) {		// Normal case - premature access needs a retry later
    		throw (InvocationFailedException)e;
    	}
    	else if (e instanceof AssertionError) {				// Debug case - assertion errors are diagnostic not catastrophic
    		AbstractTransformer.EXCEPTIONS.println("Execution failure in '" + mappingName + "' : " + e);
        	if (!AbstractTransformer.EXCEPTIONS.isActive()) {
        		throw (AssertionError)e;					// But if the user isn't watching them they are fatal
    		}
    	}
    	else if (e instanceof Error) {						// Real errors are fatal
    		AbstractTransformer.EXCEPTIONS.println("Execution failure in '" + mappingName + "' : " + e);
    		throw (Error)e;
    	}
    	else { 												// Other failures are just mappings whose predicates were not satisfied.
    		if (e instanceof InvalidValueException) {		// Multiway branch to facilitate debugger breakpoints.
	    		AbstractTransformer.EXCEPTIONS.println("Execution failure in '" + mappingName + "' : " + e);
	    	}
	    	else if (e instanceof NullPointerException) {
	    		AbstractTransformer.EXCEPTIONS.println("Execution failure in '" + mappingName + "' : " + e);
	    	}
	    	else {
	    		AbstractTransformer.EXCEPTIONS.println("Execution failure in '" + mappingName + "' : " + e);
	    	}
    	}
    	return false;
	}
	
    /**
     * Invoke a mapping with the given constructor with a given set of boundValues once. This shortform of invokeOnce
     * should only be used when it is known that recursive invocation is impossible.
     */
    public <@Nullable T extends Invocation> void invoke(Invocation.@NonNull Constructor constructor, @NonNull Object @NonNull ... boundValues) {
    	@NonNull Invocation invocation = constructor.newInstance(boundValues);
    	AbstractTransformer.INVOCATIONS.println("invoke " + invocation);
    	invocationManager.invoke(invocation, true);
    }
	
    /**
     * Invoke a mapping with the given constructor with a given set of boundValues once. Repeated invocation attempts are ignored.
     */
    public void invokeOnce(Invocation.@NonNull Constructor constructor, @NonNull Object @NonNull ... boundValues) {
    	@Nullable Invocation invocation = constructor.getFirstInvocation(boundValues);
    	if (invocation != null) {
    		AbstractTransformer.INVOCATIONS.println("invokeOnce " + invocation);
        	invocationManager.invoke(invocation, true);
    	}
    }
}
