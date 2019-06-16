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

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * The per-Model EClassAnalysis caches some derived characterstics of an EClass facilitating more
 * efficient EClass-driven processing of loaded EObjects.
 *
 * Some of this functionality could perhaps be moved tocomoile time at the expense of a sensitivity to
 * EClass evolution varing between compile time and run time.
 */
public class EClassAnalysis
{
	/**
	 * The TypedModel instance for which this EClassAnalysis provides details.
	 */
	protected final @NonNull AbstractTypedModelInstance typedModelInstance;

	/**
	 * Next EClassAnalysis in a singly linked list of same-hashed EClassAnalysis instances.
	 * (For the exclusive use of AbstractTypedModelInstance.getEClassAnalysis.)
	 */
	/*package*/ @Nullable EClassAnalysis nextEClassAnalysis = null;

	/**
	 * The analyzed EClass.
	 */
	protected final @NonNull EClass eClass;

	/**
	 * The reference features whose slot values need analysis.
	 */
	private final @NonNull EReferenceAnalysis @Nullable [] eReferenceAnalyses;

	/**
	 * The connections to which instances need to be appended.
	 */
	private final @NonNull Connection @NonNull [] connections;

	public EClassAnalysis(@NonNull AbstractTypedModelInstance typedModelInstance, @NonNull EClass eClass, @Nullable EClassAnalysis nextEClassAnalysis) {
		this.typedModelInstance = typedModelInstance;
		this.eClass = eClass;
		this.nextEClassAnalysis = nextEClassAnalysis;
		ModelsManager modelsManager = typedModelInstance.getModelsManager();
		List<@NonNull EReferenceAnalysis> eReferenceAnalyses = null;
		for (EStructuralFeature eStructuralFeature : eClass.getEAllStructuralFeatures()) {
			if (eStructuralFeature instanceof EReference) {
				EReference eReference = (EReference)eStructuralFeature;
				boolean isContainment = eReference.isContainment();
				boolean isResolveProxies = eReference.isResolveProxies();
				int oppositePropertyIndex = modelsManager.getOppositePropertyIndex(eReference);
				if (isContainment || isResolveProxies || (oppositePropertyIndex >= 0)) {
					//	assert !eReference.isDerived();		// EClass::eAllAttributes is derived and resolveProxies
					//	assert !eReference.isTransient();	// EPackage::eSuperPackage is transient and resolveProxies
					//	assert !eReference.isVolatile();	// EClass::eAllAttributes is volatile and resolveProxies
					if (eReferenceAnalyses == null) {
						eReferenceAnalyses = new ArrayList<>();
					}
					eReferenceAnalyses.add(new EReferenceAnalysis(this, eReference, oppositePropertyIndex));
				}
			}
		}
		this.eReferenceAnalyses = eReferenceAnalyses != null ? eReferenceAnalyses.toArray(new @NonNull EReferenceAnalysis[eReferenceAnalyses.size()]) : null;
		Set<@NonNull Integer> allClassIndexes = typedModelInstance.getClassIndexes(eClass);
		this.connections = new @NonNull Connection[allClassIndexes.size()];
		int connectionIndex = 0;
		for (@NonNull Integer classIndex : allClassIndexes) {
			connections[connectionIndex++] = typedModelInstance.classIndex2connection[classIndex];
		}
	}

	public @NonNull EClass getEClass() {
		return eClass;
	}

	public ModelsManager getModelsManager() {
		return typedModelInstance.getModelsManager();
	}

	public @NonNull AbstractTypedModelInstance getTypedModelInstance() {
		return typedModelInstance;
	}

	/**
	 * Propagate eObject to the connections that use it.
	 */
	public void propagate(@NonNull EObject eObject) {
		for (@NonNull Connection connection : connections) {
			connection.appendElement(eObject);
		}
	}

	public void traverseChild(@NonNull EObject eObject) {
		//	assert eObject.eClass() == eClass;
		/**
		 * Propagate eObject to the consuming connections.
		 */
		//	propagate(eObject);
		for (@NonNull Connection connection : connections) {
			connection.appendElement(eObject);
		}
		/**
		 * Recurse to containment children and add the targets of resolved proxies to the model roots and of unnavigable opposites to the opposites cache.
		 */
		if (eReferenceAnalyses != null) {
			for (@NonNull EReferenceAnalysis eReferenceAnalysis : eReferenceAnalyses) {
				eReferenceAnalysis.traverseFrom(eObject);
			}
		}
	}

	@Override
	public String toString() {
		return eClass.getName();
	}

	/**
	 * Remove eObject from the caches.
	 * <p>
	 * If eClass2allClassIndexes is non-null, eObject is removed from the allInstances() caches potentially updating eClass2allClassIndexes with
	 * the state of a new EClass.
	 * <p>
	 * If eClass2allPropertyIndexes is non-null, eObject is removed fromun the unnavigable opposites caches potentially updating eClass2allPropertyIndexes with
	 * the state of a new EClass.
	 */
	public void unpropagate(@NonNull EObject eObject) {
		//	assert classIndex2connection != null;
		assert eClass == eObject.eClass();
		for (@NonNull Connection connection : connections) {
			((Connection.Incremental)connection).removeElement(eObject);
		}
		if (eReferenceAnalyses != null) {
			for (@NonNull EReferenceAnalysis eReferenceAnalysis : eReferenceAnalyses) {
				eReferenceAnalysis.untraverseFrom(eObject);
			}
		}
	}
}