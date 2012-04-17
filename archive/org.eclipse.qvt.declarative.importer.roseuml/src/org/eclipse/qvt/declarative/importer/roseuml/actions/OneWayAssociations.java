/*******************************************************************************
 * Copyright (c) 2007 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.importer.roseuml.actions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * OneWayAssociations manages a set of unidirectional associations providing facilities to
 * convert them from semi-opposite (two EReferences with one eOpposite) to
 * bi-directional (two EReferences with two mutual eOpposite) or  
 * uni-directional (one EREference an no eOpposite).
 */
public class OneWayAssociations
{   
	private final Map<EReference, EReference> assocs = new HashMap<EReference, EReference>();

	public OneWayAssociations(List<EPackage> ePackages) {
		findOneWayAssociations(ePackages);
	}
	
	/**
	 * Find all one way associations within ePackages and its sub-packages, populating this
	 * with mappings from one end (the key) to the other end (the value) such that the
	 * key.eOpposite is non-null i.e. navigable to the value, and value.eOpposite is non-null
	 * i.e. not navigable to the key.
	 * @param ePackages
	 */
	protected void findOneWayAssociations(List<EPackage> ePackages) {
		for (EPackage ePackage : ePackages) {
			for (EClassifier eClassifier : ePackage.getEClassifiers()) {
				if (eClassifier instanceof EClass) {
					for (EStructuralFeature eFeature : ((EClass) eClassifier).getEStructuralFeatures()) {
						if (eFeature instanceof EReference) {
							EReference from = (EReference) eFeature;
							EReference to = from.getEOpposite();
							if ((to != null) && (to.getEOpposite() == null))
								assocs.put(from, to);
						}
					}
				}
			}
			findOneWayAssociations(ePackage.getESubpackages());
		}	
	}

	/**
	 * Convert each one way association defined by a mapping from key to value into a single
	 * reference without any opposite. This orphans the value reference.
	 */
	public void minimise() {
		for (EReference from : assocs.keySet()) {
			EReference to = assocs.get(from);
			to.setEOpposite(null);
			to.getEReferenceType().getEStructuralFeatures().remove(from);
		}
	}

	/**
	 * Convert each one way association defined by a mapping from key to value into a fully navigable
	 * bidirectional pair of mutually opposite references.
	 */
	public void maximise() {
		for (EReference from : assocs.keySet()) {
			EReference to = assocs.get(from);
			to.setEOpposite(from);
			if (from.eContainer() == null)
				to.getEReferenceType().getEStructuralFeatures().add(from);
		}
	}
}
