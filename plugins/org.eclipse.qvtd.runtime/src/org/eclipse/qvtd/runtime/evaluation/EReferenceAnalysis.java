/*******************************************************************************
 * Copyright (c) 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.runtime.evaluation;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;

public class EReferenceAnalysis
{
	//	protected final @NonNull EClassAnalysis eClassAnalysis;
	protected final @NonNull AbstractTypedModelInstance typedModelInstance;
	protected final @NonNull ModelsManager modelsManager;

	/**
	 * The analyzed EReference.
	 */
	protected final @NonNull EReference eReference;
	private final boolean isContainment;
	private final boolean isMany;
	private final boolean isResolveProxies;
	private final int oppositePropertyIndex;

	public EReferenceAnalysis(@NonNull EClassAnalysis eClassAnalysis, @NonNull EReference eReference, int oppositePropertyIndex) {
		//	this.eClassAnalysis = eClassAnalysis;
		this.typedModelInstance = eClassAnalysis.getTypedModelInstance();
		this.modelsManager = typedModelInstance.getModelsManager();
		this.eReference = eReference;
		this.isContainment = eReference.isContainment();
		this.isMany = eReference.isMany();
		this.isResolveProxies = eReference.isResolveProxies();
		this.oppositePropertyIndex = oppositePropertyIndex;
		assert !isContainment || (oppositePropertyIndex < 0);
	}

	public void traverseFrom(@NonNull EObject eObject) {
		if (!isMany) {
			Object object = eObject.eGet(eReference, true);
			if (object != null) {
				traverseFromTo(eObject, (EObject)object);
			}
		}
		else if (eObject.eIsSet(eReference)) {			// Avoid creating an empty list
			@SuppressWarnings("unchecked")
			List<@NonNull EObject> list = (List<@NonNull EObject>)eObject.eGet(eReference, true);
			for (@NonNull EObject object : list) {
				traverseFromTo(eObject, object);
			}
		}
	}

	private void traverseFromTo(@NonNull EObject fromEObject, @NonNull EObject toEObject) {
		if (isResolveProxies) {
			Resource eResource = toEObject.eResource();
			if (eResource != null) {			// FIXME faster rejection of known resources, particularly the current resource
				typedModelInstance.addInputResource(eResource);
			}
		}
		if (isContainment) {
			typedModelInstance.getEClassAnalysis(toEObject).traverseChild(toEObject);
		}
		else if (oppositePropertyIndex >= 0) {
			Map<@NonNull Object, @NonNull Object>[] object2oppositeObject2 = modelsManager.getObject2oppositeObject();
			assert object2oppositeObject2 != null;
			object2oppositeObject2[oppositePropertyIndex].put(toEObject, fromEObject);
		}
	}

	public void untraverseFrom(@NonNull EObject eObject) {
		if (oppositePropertyIndex >= 0) {
			@NonNull Map<@NonNull Object, @NonNull Object>[] object2oppositeObject2 = modelsManager.getObject2oppositeObject();
			EReference @NonNull [] propertyIndex2eReference2 = modelsManager.getPropertyIndex2eReference();
			EReference eReference = propertyIndex2eReference2[oppositePropertyIndex];
			if (eReference != null) {
				Object object = eObject.eGet(eReference);
				assert object != null;
				object2oppositeObject2[oppositePropertyIndex].remove(object);
			}
		}
	}
}