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
package org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hls;

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
import org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hls.HLSTree.HLSTreePackage;
import org.eclipse.qvtd.xtext.qvtimperative.tests.ModelNormalizer;

/**
 * FIXME Bug 490497 - this is a workaround for Bug 490172
 * 
 * HSV2HLSNormalizer normalises the results of the HSV2HLS transformation pending support for order preservation.
 */
public class HSV2HLSNormalizer implements ModelNormalizer
{
	public static final @NonNull HSV2HLSNormalizer INSTANCE = new HSV2HLSNormalizer();
	
	protected static class HLSNodeComparator implements Comparator<@NonNull EObject>
	{
		private final @NonNull EAttribute hlsNodeName;

		public HLSNodeComparator(@NonNull EAttribute hlsNodeName) {
			this.hlsNodeName = hlsNodeName;
		}
		
		@Override
		public int compare(@NonNull EObject o1, @NonNull EObject o2) {
			String n1 = (String) o1.eGet(hlsNodeName);
			String n2 = (String) o2.eGet(hlsNodeName);
			return ClassUtil.safeCompareTo(n1, n2);
		}
	}

	@Override
	public @NonNull List<Normalizer> normalize(@NonNull Resource resource) {
		EObject eRoot = resource.getContents().get(0);
		EPackage ePackage = eRoot.eClass().getEPackage();
		EClass hlsNodeClass = (EClass) ePackage.getEClassifier(HLSTreePackage.Literals.HLS_NODE.getName());
		assert hlsNodeClass != null;
		@NonNull EReference hlsNodeChildren = (EReference) hlsNodeClass.getEStructuralFeature(HLSTreePackage.Literals.HLS_NODE__CHILDREN.getName());
		assert hlsNodeChildren != null;
		@NonNull EAttribute hlsNodeName = (EAttribute) hlsNodeClass.getEStructuralFeature(HLSTreePackage.Literals.HLS_NODE__NAME.getName());
		assert hlsNodeName != null;
		HLSNodeComparator personComparator = new HLSNodeComparator(hlsNodeName);
		List<@NonNull EObject> allNodes = new ArrayList<@NonNull EObject>();
		for (TreeIterator<EObject> tit = resource.getAllContents(); tit.hasNext(); ) {
			EObject eObject = tit.next();
			if (hlsNodeClass.isInstance(eObject)) {
				allNodes.add(eObject);
			}
		}
		for (@NonNull EObject hlsNode : allNodes) {
			@SuppressWarnings("unchecked")
			EList<@NonNull EObject> children = (EList<@NonNull EObject>) hlsNode.eGet(hlsNodeChildren);
			ECollections.sort(children, personComparator);
		}
		List<Normalizer> normalizers = new ArrayList<Normalizer>();
		return normalizers;
	}
}