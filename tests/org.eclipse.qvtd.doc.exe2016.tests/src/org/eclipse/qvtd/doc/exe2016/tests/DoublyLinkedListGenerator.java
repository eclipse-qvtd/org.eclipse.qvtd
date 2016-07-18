/*******************************************************************************
 * Copyright (c) 2012, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.doc.exe2016.tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.xtext.qvtcore.tests.list2list.doublylinkedlist.DoublyLinkedList;
import org.eclipse.qvtd.xtext.qvtcore.tests.list2list.doublylinkedlist.DoublylinkedlistFactory;
import org.eclipse.qvtd.xtext.qvtcore.tests.list2list.doublylinkedlist.Element;

public class DoublyLinkedListGenerator
{

	public static void checkModel(@NonNull DoublyLinkedList list, int testSize) {
		List<Element> elements = list.getOwnedElements();
		assert elements.size() == testSize-1;
		int i = 0;
		for (Element element = list.getHeadElement(); element != null; element = element.getTarget()) {
			assert element.getName().equals("e-" + (i > 0 ? testSize-i : 1));
			if ((i > 0) && (element == list.getHeadElement())) {
				break;
			}
			i++;
		}
		assert i == testSize-1;
		i = 0;
		for (Element element = list.getHeadElement(); element != null; element = element.getSource()) {
			if ((i > 0) && (element == list.getHeadElement())) {
				break;
			}
			assert element.getName().equals("e-" + (i+1));
			i++;
		}
		assert i == testSize-1;
	}

	public static @NonNull List<@NonNull ? extends EObject> createDoublyLinkedListModel(int nElements) {
		DoublyLinkedList list = DoublylinkedlistFactory.eINSTANCE.createDoublyLinkedList();
		Element prevElement = null;
		List<Element> elements = new ArrayList<>(nElements-1);
		for (int n = 1; n < nElements; n++) {
			Element element = DoublylinkedlistFactory.eINSTANCE.createElement();
			element.setName("e-" + n);
			elements.add(element);
			if (n == 1) {
				list.setHeadElement(element);
			}
			if (n == nElements-1) {
				list.getHeadElement().setSource(element);
			}
			if (prevElement != null) {
				element.setSource(prevElement);
			}
			prevElement = element;
		}
		list.getOwnedElements().addAll(elements);
		int i = 1;
		for (Element element = list.getHeadElement(); element != null; element = element.getTarget()) {
			if ((i > 1) && (element == list.getHeadElement())) {
				break;
			}
			i++;
		}
		assert i == nElements;
		return Collections.singletonList(list);
	}

	public static void garbageCollect() throws InterruptedException {
		for (int y = 0; y < 5; y++) {
			System.gc();
			Thread.sleep(100);
		}
	}
}
