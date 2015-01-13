/*******************************************************************************
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtbase.evaluation;

import java.util.ArrayList;
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
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.PackageId;
import org.eclipse.ocl.pivot.ids.PropertyId;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;

public abstract class AbstractTransformationExecutor implements TransformationExecutor
{	
	private static final @SuppressWarnings("null")@NonNull List<Integer> EMPTY_INDEX_LIST = Collections.emptyList();
	
	protected final @NonNull Evaluator evaluator;
	protected final @NonNull IdResolver idResolver;
	protected final @NonNull List<EObject>[] modelObjects;
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
	 * All possible allInstances() returns indexed by the ClassIndex of the ClassId for which allInstances() may be invoked.
	 */
	private final @Nullable Set<EObject>[] classIndex2objects;
	
	protected AbstractTransformationExecutor(@NonNull Evaluator evaluator, @NonNull String[] modelNames,
			@Nullable PropertyId[] propertyIndex2propertyId, @Nullable ClassId[] classIndex2classId, @Nullable int[][] classIndex2allClassIndexes) {
		this.evaluator = evaluator;
		this.idResolver = evaluator.getIdResolver();
		@SuppressWarnings("unchecked")List<EObject>[] modelObjects = (List<EObject>[]) new List<?>[modelNames.length];
		this.modelObjects = modelObjects;
		for (int i = 0; i < modelNames.length; i++) {
			modelObjects[i] = new ArrayList<EObject>();
			modelIndexes.put(modelNames[i],  i);
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
			@SuppressWarnings("unchecked")Set<EObject>[] classIndex2objects = (Set<EObject>[]) new HashSet<?>[classIds];
			this.classIndex2objects = classIndex2objects;
	        for (int i = 0; i < classIds; i++) {
	        	classIndex2objects[i] = new HashSet<EObject>();
	        }
		}
		else {
	    	this.classId2classIndex = null;
	    	this.classId2classIndexes = null;
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

	/**
     * Add eRootObjects to the modelIndex model.
     */
    @Override
	public void addRootObjects(@NonNull String modelName, @NonNull Iterable<? extends EObject> eRootObjects) {
    	Integer modelIndex = modelIndexes.get(modelName);
    	if (modelIndex == null) {
    		throw new IllegalStateException("Unknown model name '" + modelName + "'");
    	}
    	List<EObject> eObjects = modelObjects[modelIndex];
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
				eObjects.add(eRootObject);
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
	public @NonNull Set<EObject> get(@NonNull org.eclipse.ocl.pivot.Class type) {
		Map<ClassId, Integer> classId2classIndex2 = classId2classIndex;
		Set<EObject>[] classIndex2objects2 = classIndex2objects;
		if ((classId2classIndex2 == null) || (classIndex2objects2 == null)) {
			throw new IllegalArgumentException("No allInstances() support");
		}
		ClassId classId = IdManager.getClassId(type);
		Integer index = classId2classIndex2.get(classId);
		if (index == null) {
			throw new IllegalArgumentException("No allInstances() support for '" + type + "'");
		}
		@SuppressWarnings("null")@NonNull Set<EObject> objects = classIndex2objects2[index];
		return objects;
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
     */
    protected @NonNull <T extends EObject> List<T> getObjectsByType(@NonNull Class<T> javaClass, int modelIndex, @NonNull EClass eClass) {

		List<EObject> eRootObjects = modelObjects[modelIndex];
    	List<T> eObjects = new ArrayList<T>();
    	for (EObject eRootObject : eRootObjects) {
    		if (eClass.isInstance(eRootObject)) {
    			@SuppressWarnings("unchecked") T eObject2 = (T)eRootObject;
				eObjects.add(eObject2);
    		}
        	for (TreeIterator<EObject> tit = eRootObject.eAllContents(); tit.hasNext(); ) {
        		@SuppressWarnings("null")@NonNull EObject eObject = tit.next();
	    		if (eClass.isInstance(eObject)) {
	    			@SuppressWarnings("unchecked") T eObject2 = (T)eObject;
					eObjects.add(eObject2);
	    		}
        	}
    	}
		return eObjects;
	}

	/**
	 * Return the List of all PropertyIndexes for which an EClass instance could be the unnavigable opposite.
	 * eReference2propertyIndex contains known equivalences and may be updated if more are discovered
	 * using -1 as a propertyIndex for#which no unnavigable opposite is appropriate.
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
	public @NonNull List<EObject> getRootObjects(@NonNull String modelName) {
    	Integer modelIndex = modelIndexes.get(modelName);
    	if (modelIndex == null) {
    		throw new IllegalStateException("Unknown model name '" + modelName + "'");
    	}
    	List<EObject> eObjects = modelObjects[modelIndex];
    	List<EObject> eRootObjects = new ArrayList<EObject>(eObjects.size());
    	for (EObject eObject : eObjects) {
    		if (eObject.eContainer() == null) {
    			eRootObjects.add(eObject);
    		}
    	}
		return eRootObjects;
	}
}
