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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;

public abstract class AbstractDoublyLinkedListGenerator<@NonNull L extends EObject, @NonNull E extends EObject>
{
	public void checkModel(L list, int testSize) {
		List<E> elements = getOwnedElements(list);
		assert elements.size() == testSize-1;
		int i = 0;
		for (@Nullable E element = getHeadElement(list); element != null; element = getTarget(element)) {
			assert getElementName(element).equals("e-" + (i > 0 ? testSize-i : 1));
			if ((i > 0) && (element == getHeadElement(list))) {
				break;
			}
			i++;
		}
		assert i == testSize-1;
		i = 0;
		for (@Nullable E element = getHeadElement(list); element != null; element = getSource(element)) {
			if ((i > 0) && (element == getHeadElement(list))) {
				break;
			}
			assert getElementName(element).equals("e-" + (i+1));
			i++;
		}
		assert i == testSize-1;
	}

	public @NonNull List<@NonNull ? extends EObject> createDoublyLinkedListModel(int nElements) {
		L list = createDoublyLinkedList();
		setListName(list, "listName");
		@Nullable E prevElement = null;
		List<E> elements = new ArrayList<>(nElements-1);
		for (int n = 1; n < nElements; n++) {
			E element = createElement();
			setElementName(element, "e-" + n);
			elements.add(element);
			if (n == 1) {
				setHeadElement(list, element);
			}
			if (n == nElements-1) {
				setSource(ClassUtil.nonNullState(getHeadElement(list)), element);
			}
			if (prevElement != null) {
				setSource(element, prevElement);
			}
			prevElement = element;
		}
		getOwnedElements(list).addAll(elements);
		int i = 1;
		for (@Nullable E element = getHeadElement(list); element != null; element = getTarget(element)) {
			if ((i > 1) && (element == getHeadElement(list))) {
				break;
			}
			i++;
		}
		assert i == nElements;
		return Collections.singletonList(list);
	}

	protected abstract L createDoublyLinkedList();

	protected abstract E createElement();

	protected abstract String getElementName(E element);

	protected abstract @Nullable E getHeadElement(L list);

	protected abstract String getListName(L list);

	protected abstract @NonNull List<E> getOwnedElements(L list);

	protected abstract E getSource(E element);

	protected abstract E getTarget(E element);

	protected abstract void setElementName(E element, String name);

	protected abstract void setHeadElement(L list, E element);

	protected abstract void setListName(L list, String name);

	protected abstract void setSource(E element, E source);

	protected abstract void setTarget(E element, E target);
}
