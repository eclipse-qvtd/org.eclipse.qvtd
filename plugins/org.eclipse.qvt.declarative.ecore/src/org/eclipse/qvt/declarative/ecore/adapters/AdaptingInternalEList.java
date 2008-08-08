/**
 * <copyright>
 * 
 * Copyright (c) 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: AdaptingInternalEList.java,v 1.2 2008/08/08 17:00:10 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.adapters;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.BasicEList.UnmodifiableEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.qvt.declarative.ecore.mappings.MappingMetaDataRegistry;

/**
 * An AdaptingInternalEList maintains an InternalEList of adapting adapting model objects, delegating all interaction
 * to a corresponding list of adapted ecore objects, performing appropriate adapting to ecore and
 * ecore to adapting conversions.
 *
 * @param <E> Ecore model EObject type
 * @param <A> Adapting model EObject type
 * @param <L> Ecore model EList type
 */
public class AdaptingInternalEList<E extends EObject, A extends EObject> extends AdaptingEList<E, A, InternalEList<E>> implements InternalEList<A>
{
	protected class AdaptingBasicIterator implements java.util.Iterator<A>
	{
		private Iterator<E> ecoreIterator = ecoreList.basicIterator();
		
		public boolean hasNext() {
			return ecoreIterator.hasNext();
		}

		public A next() {
			return getAdapter(ecoreIterator.next());
		}

		public void remove() {
			ecoreIterator.remove();
		}		
	}
	
	public AdaptingInternalEList(MappingMetaDataRegistry mappingMetaDataRegistry, InternalEList<E> ecoreList) {
		super(mappingMetaDataRegistry, ecoreList);
	}

	public boolean addAllUnique(Collection<? extends A> adaptingObjects) {
		List<E> targets = getTargets(adaptingObjects);
		return ecoreList.addAllUnique(targets);		
	}

	public boolean addAllUnique(int index, Collection<? extends A> adaptingObjects) {
		List<E> targets = getTargets(adaptingObjects);
		return ecoreList.addAllUnique(index, targets);
	}

	public void addUnique(A adaptingObject) {
		ecoreList.addUnique(getTarget(adaptingObject));		
	}

	public void addUnique(int index, A adaptingObject) {
		ecoreList.addUnique(index, getTarget(adaptingObject));		
	}

	public NotificationChain basicAdd(A adaptingObject, NotificationChain notifications) {
		return ecoreList.basicAdd(getTarget(adaptingObject), notifications);
	}

	@SuppressWarnings("unchecked")
	public boolean basicContains(Object adaptingObject) {
		E target = getTarget((A)adaptingObject);
		return ecoreList.basicContains(target);
	}

	public boolean basicContainsAll(Collection<?> adaptingObjects) {
		List<E> targets = getTargets(adaptingObjects);
		return ecoreList.basicContains(targets);
	}

	public A basicGet(int index) {
		return getAdapter(ecoreList.basicGet(index));
	}

	@SuppressWarnings("unchecked")
	public int basicIndexOf(Object adaptingObject) {
		E target = getTarget((A)adaptingObject);
		return ecoreList.basicIndexOf(target);
	}

	public Iterator<A> basicIterator() {
		return new AdaptingBasicIterator();		// non-resolving
	}

	@SuppressWarnings("unchecked")
	public int basicLastIndexOf(Object adaptingObject) {
		E target = getTarget((A)adaptingObject);
		return ecoreList.basicLastIndexOf(target);
	}

	public List<A> basicList() {
		int size = size();
		if (size <= 0)
			return ECollections.emptyEList();
		Object[] data = new Object[size];
		for (int i = 0; i < size; i++)
			data[i] = basicGet(i);
	    return new UnmodifiableEList<A>(size, data);
	}

	public ListIterator<A> basicListIterator() {
		throw new UnsupportedOperationException(getClass().getName() + ".basicListIterator");
	}

	public ListIterator<A> basicListIterator(int index) {
		throw new UnsupportedOperationException(getClass().getName() + ".basicListIterator");
	}

	public NotificationChain basicRemove(Object adaptingObject, NotificationChain notifications) {
		if (adaptingObject instanceof Adapter)
			return ecoreList.basicRemove(((Adapter) adaptingObject).getTarget(), notifications);
		else
			return notifications;
	}

	public Object[] basicToArray() {
		return toArray();
	}

	public <T> T[] basicToArray(T[] array) {
		return toArray(array);
	}

	public A setUnique(int index, A adaptingObject) {
		return getAdapter(ecoreList.setUnique(index, getTarget(adaptingObject)));
	}
}