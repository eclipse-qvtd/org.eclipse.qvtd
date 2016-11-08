/**
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.xtext.tests.XtextTestCase.Normalizer;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.xtext.qvtbase.tests.ModelNormalizer;
import org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSLTree.HSLTreePackage;

/**
 * FIXME Bug 490497 - this is a workaround for Bug 490172
 *
 * HSV2HSLNormalizer normalises the results of the HSV2HLS transformation pending support for order preservation.
 */
public class HSV2HSLNormalizer implements ModelNormalizer
{
	public static final @NonNull HSV2HSLNormalizer INSTANCE = new HSV2HSLNormalizer();

	protected static class HLSNodeComparator implements Comparator<@NonNull EObject>
	{
		private final @NonNull EAttribute hslNodeName;

		public HLSNodeComparator(@NonNull EAttribute hslNodeName) {
			this.hslNodeName = hslNodeName;
		}

		@Override
		public int compare(@NonNull EObject o1, @NonNull EObject o2) {
			String n1 = (String) o1.eGet(hslNodeName);
			String n2 = (String) o2.eGet(hslNodeName);
			return ClassUtil.safeCompareTo(n1, n2);
		}
	}

	@Override
	public @NonNull List<@NonNull Normalizer> normalize(@NonNull Resource resource) {
		EObject eRoot = resource.getContents().get(0);
		EPackage ePackage = eRoot.eClass().getEPackage();
		EClass hslNodeClass = (EClass) ePackage.getEClassifier(HSLTreePackage.Literals.HSL_NODE.getName());
		assert hslNodeClass != null;
		@NonNull EReference hslNodeChildren = (EReference) hslNodeClass.getEStructuralFeature(HSLTreePackage.Literals.HSL_NODE__CHILDREN.getName());
		assert hslNodeChildren != null;
		@NonNull EAttribute hslNodeName = (EAttribute) hslNodeClass.getEStructuralFeature(HSLTreePackage.Literals.HSL_NODE__NAME.getName());
		assert hslNodeName != null;
		HLSNodeComparator personComparator = new HLSNodeComparator(hslNodeName);
		List<@NonNull EObject> allNodes = new ArrayList<@NonNull EObject>();
		for (TreeIterator<EObject> tit = resource.getAllContents(); tit.hasNext(); ) {
			EObject eObject = tit.next();
			if (hslNodeClass.isInstance(eObject)) {
				allNodes.add(eObject);
			}
		}
		for (@NonNull EObject hslNode : allNodes) {
			@SuppressWarnings("unchecked")
			EList<@NonNull EObject> children = (EList<@NonNull EObject>) hslNode.eGet(hslNodeChildren);
			ECollections.sort(children, personComparator);
		}
		List<@NonNull Normalizer> normalizers = new ArrayList<>();
		return normalizers;
	}
}