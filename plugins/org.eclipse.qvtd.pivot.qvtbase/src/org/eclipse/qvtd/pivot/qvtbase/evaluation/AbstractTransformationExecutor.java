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
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.PackageId;
import org.eclipse.ocl.pivot.utilities.ClassUtil;

public abstract class AbstractTransformationExecutor implements TransformationExecutor
{	
	protected final @NonNull Evaluator evaluator;
	protected final @NonNull IdResolver idResolver;
	protected final @NonNull List<EObject>[] modelObjects;
	protected final @NonNull Map<String, Integer> modelIndexes = new HashMap<String, Integer>();

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
			@Nullable ClassId[] classIndex2classId, @Nullable int[][] classIndex2allClassIndexes) {
		this.evaluator = evaluator;
		this.idResolver = evaluator.getIdResolver();
		@SuppressWarnings("unchecked")List<EObject>[] modelObjects = (List<EObject>[]) new List<?>[modelNames.length];
		this.modelObjects = modelObjects;
		for (int i = 0; i < modelNames.length; i++) {
			modelObjects[i] = new ArrayList<EObject>();
			modelIndexes.put(modelNames[i],  i);
		}
		if (classIndex2classId != null) {
	    	assert classIndex2allClassIndexes != null;
	    	this.classId2classIndex = new HashMap<ClassId, Integer>();
	    	this.classId2classIndexes = new HashMap<ClassId, Set<Integer>>(classIndex2classId.length);
			for (int classIndex = 0; classIndex < classIndex2classId.length; classIndex++) {
				ClassId classId = classIndex2classId[classIndex];
				classId2classIndex.put(classId, classIndex);
				Set<Integer> superClassIndexes = new HashSet<Integer>();
				for (int allClassIndex : classIndex2allClassIndexes[classIndex]) {
					superClassIndexes.add(allClassIndex);
				}
				classId2classIndexes.put(classId, superClassIndexes);
			}
			@SuppressWarnings("unchecked")Set<EObject>[] classIndex2objects = (Set<EObject>[]) new HashSet<?>[classIndex2classId.length];
			this.classIndex2objects = classIndex2objects;
	        for (int i = 0; i < classIndex2classId.length; i++) {
	        	classIndex2objects[i] = new HashSet<EObject>();
	        }
		}
		else {
	    	this.classId2classIndex = null;
	    	this.classId2classIndexes = null;
	    	this.classIndex2objects = null;
		}
	}

    private void accumulateAllInstancesEObject(@NonNull Map<EClass, Set<Integer>> eClass2superClassIndexes, @NonNull EObject eObject) {
		EClass eClass = ClassUtil.nonNullEMF(eObject.eClass());
		Set<Integer> superClassIndexes = eClass2superClassIndexes.get(eClass);
		if (superClassIndexes == null) {
			superClassIndexes = getClassIndexes(eClass);
			eClass2superClassIndexes.put(eClass, superClassIndexes);
		}
		for (Integer classIndex : superClassIndexes) {
			assert classIndex2objects != null;
			classIndex2objects[classIndex].add(eObject);
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
    	Map<EClass, Set<Integer>> eClass2superClassIndexes = new HashMap<EClass, Set<Integer>>();
    	for (EObject eRootObject : eRootObjects) {
    		if (eRootObject != null) {
				//
				//	Accumulate the root object in the model extent
				//
				eObjects.add(eRootObject);
				//
				//	Accumulate the root object and all its child objects in the allInstances() returns
				//
				if ((classId2classIndexes != null) && (classIndex2objects != null)) {
					accumulateAllInstancesEObject(eClass2superClassIndexes, eRootObject);
					for (TreeIterator<EObject> tit = eRootObject.eAllContents(); tit.hasNext(); ) {
						EObject eObject = tit.next();
						if (eObject != null) {
							accumulateAllInstancesEObject(eClass2superClassIndexes, eObject);
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
		String className = ClassUtil.nonNullEMF(eClass.getName());
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
