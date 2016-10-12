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
package org.eclipse.qvtd.xtext.qvtrelation.tests.forward2reverse;

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
import org.eclipse.qvtd.xtext.qvtimperative.tests.ModelNormalizer;
import org.eclipse.qvtd.xtext.qvtrelation.tests.forward2reverse.doublylinkedlist.doublylinkedlistPackage;

/**
 * Forward2ReverseNormalizer normalises the results of the Forward2Reverse transformation.
 *
 * The list contents are not ordered, so we impose alphabetical ordering by name for test purposes.
 */
public class Forward2ReverseNormalizer implements ModelNormalizer
{
	public static final @NonNull Forward2ReverseNormalizer INSTANCE = new Forward2ReverseNormalizer();

	protected static class ElementComparator implements Comparator<EObject>
	{
		private final @NonNull EAttribute elementName;

		public ElementComparator(@NonNull EAttribute elementName) {
			this.elementName = elementName;
		}

		@Override
		public int compare(EObject o1, EObject o2) {
			String n1 = (String) o1.eGet(elementName);
			String n2 = (String) o2.eGet(elementName);
			return ClassUtil.safeCompareTo(n1, n2);
		}
	}

	protected class DoublyLinkedListNormalizer implements Normalizer
	{
		protected final @NonNull EObject list;
		protected final @NonNull EReference listElements;
		protected final @NonNull ElementComparator elementComparator;

		public DoublyLinkedListNormalizer(@NonNull EObject list, @NonNull EReference listElements, @NonNull ElementComparator elementComparator) {
			this.list = list;
			this.listElements = listElements;
			this.elementComparator = elementComparator;
		}

		@Override
		public void denormalize() {
			throw new UnsupportedOperationException();
		}

		@Override
		public void normalize() {
			@SuppressWarnings("unchecked")
			EList<EObject> elements = (EList<EObject>) list.eGet(listElements);
			ECollections.sort(elements, elementComparator);
		}
	}

	@Override
	public @NonNull List<Normalizer> normalize(@NonNull Resource resource) {
		List<Normalizer> normalizers = new ArrayList<Normalizer>();
		List<@NonNull EObject> contents = resource.getContents();
		if (contents.isEmpty()) {
			return normalizers;
		}
		EObject eRoot = contents.get(0);
		EPackage ePackage = eRoot.eClass().getEPackage();
		EClass elementClass = (EClass) ePackage.getEClassifier(doublylinkedlistPackage.Literals.ELEMENT.getName());
		assert elementClass != null;
		EClass listClass = (EClass) ePackage.getEClassifier(doublylinkedlistPackage.Literals.DOUBLY_LINKED_LIST.getName());
		assert listClass != null;
		EReference listElements = (EReference) listClass.getEStructuralFeature(doublylinkedlistPackage.Literals.DOUBLY_LINKED_LIST__OWNED_ELEMENTS.getName());
		assert listElements != null;
		EAttribute elementName = (EAttribute) elementClass.getEStructuralFeature(doublylinkedlistPackage.Literals.ELEMENT__NAME.getName());
		assert elementName != null;
		ElementComparator elementComparator = new ElementComparator(elementName);
		for (TreeIterator<EObject> tit = resource.getAllContents(); tit.hasNext(); ) {
			EObject eObject = tit.next();
			EClass eClass = eObject.eClass();
			if (listClass.isSuperTypeOf(eClass)) {
				normalizers.add(new DoublyLinkedListNormalizer(eObject, listElements, elementComparator));
			}
		}
		for (Normalizer normalizer : normalizers) {
			normalizer.normalize();
		}
		return normalizers;
	}
}