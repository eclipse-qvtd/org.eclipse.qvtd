/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.doc.exe2016.tests;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.DoublyLinkedList;
import org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.DoublylinkedlistFactory;
import org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.Element;

public class DoublyLinkedListGenerator extends AbstractDoublyLinkedListGenerator<@NonNull DoublyLinkedList, @NonNull Element>
{
	@Override
	@SuppressWarnings("null")
	protected @NonNull DoublyLinkedList createDoublyLinkedList() {
		return DoublylinkedlistFactory.eINSTANCE.createDoublyLinkedList();
	}

	@Override
	@SuppressWarnings("null")
	protected @NonNull Element createElement() {
		return DoublylinkedlistFactory.eINSTANCE.createElement();
	}

	@Override
	protected @Nullable Element getHeadElement(@NonNull DoublyLinkedList list) {
		return list.getHeadElement();
	}

	@Override
	protected String getElementName(@NonNull Element element) {
		return element.getName();
	}

	@Override
	protected String getListName(@NonNull DoublyLinkedList list) {
		return list.getName();
	}

	@Override
	protected @NonNull List<@NonNull Element> getOwnedElements(@NonNull DoublyLinkedList list) {
		return ClassUtil.nullFree(list.getOwnedElements());
	}

	@SuppressWarnings("null")
	@Override
	protected @NonNull Element getSource(@NonNull Element element) {
		return element.getSource();
	}

	@SuppressWarnings("null")
	@Override
	protected @NonNull Element getTarget(@NonNull Element element) {
		return element.getTarget();
	}

	@Override
	protected void setElementName(@NonNull Element element, String name) {
		element.setName(name);
	}

	@Override
	protected void setHeadElement(@NonNull DoublyLinkedList list, @NonNull Element element) {
		list.setHeadElement(element);
	}

	@Override
	protected void setListName(@NonNull DoublyLinkedList list, String name) {
		list.setName(name);
	}

	@Override
	protected void setSource(@NonNull Element element, @NonNull Element source) {
		element.setSource(source);
	}

	@Override
	protected void setTarget(@NonNull Element element, @NonNull Element target) {
		element.setTarget(target);
	}
}
