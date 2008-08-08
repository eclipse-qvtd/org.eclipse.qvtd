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
 * $Id: AdaptingList.java,v 1.2 2008/08/08 17:00:10 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.adapters;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.qvt.declarative.ecore.mappings.MappingMetaDataRegistry;

/**
 * An AdaptingList maintains a List of adapting adapting model objects, delegating all interaction
 * to a corresponding list of adapted ecore objects, performing appropriate adapting to ecore and
 * ecore to adapting conversions.
 *
 * @param <E> Ecore model EObject type
 * @param <A> Adapting model EObject type
 * @param <L> Ecore model List type
 */
public class AdaptingList<E extends EObject, A extends EObject, L extends List<E>> implements List<A>
{
	protected class AdaptingIterator implements java.util.Iterator<A>
	{
		private Iterator<E> ecoreIterator = ecoreList.iterator();
		
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
	
	protected final MappingMetaDataRegistry mappingMetaDataRegistry;
	protected L ecoreList;
	
	public AdaptingList(MappingMetaDataRegistry mappingMetaDataRegistry, L ecoreList) {
		this.mappingMetaDataRegistry = mappingMetaDataRegistry;
		this.ecoreList = ecoreList;
	}

	public boolean add(A o) {
		return ecoreList.add(getTarget(o));
	}

	public void add(int index, A o) {
		ecoreList.add(index, getTarget(o));
	}

	public boolean addAll(Collection<? extends A> c) {
		for (A o : c)
			add(o);
		return !c.isEmpty();
	}

	public boolean addAll(int index, Collection<? extends A> c) {
		for (A o : c)
			add(index++, o);
		return !c.isEmpty();
	}

	public void clear() {
		ecoreList.clear();		
	}

	public boolean contains(Object object) {
		if (!(object instanceof Adapter))
			return false;
		return ecoreList.contains(((Adapter)object).getTarget());
	}

	public boolean containsAll(Collection<?> c) {
		for (Object o : c)
			if (!contains(o))
				return false;
		return true;
	}

	public A get(int index) {
		return getAdapter(ecoreList.get(index));
	}

	@SuppressWarnings("unchecked")
	protected A getAdapter(E ecoreObject) {
//		if (ecoreObject == null)
//			return null;
//		EClass ecoreEClass = ecoreObject.eClass();
//		MappingMetaData mappingMetaData = mappingMetaDataRegistry.getFromEcoreMappingMetaDataOrThrow(ecoreEClass);
		return (A) mappingMetaDataRegistry.getAdapter(ecoreObject);
	}

	@SuppressWarnings("unchecked")
	protected E getTarget(A adaptingObject) {
		if (!(adaptingObject instanceof Adapter))
			throw new NotAdapterException(adaptingObject);
		return (E) ((Adapter)adaptingObject).getTarget();
	}

	@SuppressWarnings("unchecked")
	public List<E> getTargets(Collection<?> collection) {
		if (collection.isEmpty())
			return Collections.emptyList();
		List<E> list = new ArrayList<E>(collection.size());
		for (Object adaptingObject : collection)
			list.add(getTarget((A)adaptingObject));
		return list;
	}

	public int indexOf(Object object) {
		if (!(object instanceof Adapter))
			return -1;
		return ecoreList.indexOf(((Adapter)object).getTarget());
	}

	public boolean isEmpty() {
		return ecoreList.isEmpty();
	}

	public Iterator<A> iterator() {
		return new AdaptingIterator();
	}

	public int lastIndexOf(Object o) {
		if (!(o instanceof Adapter))
			return -1;
		return ecoreList.lastIndexOf(((Adapter)o).getTarget());
	}

	public ListIterator<A> listIterator() {
		throw new UnsupportedOperationException(getClass().getName() + ".listIterator");
	}

	public ListIterator<A> listIterator(int index) {
		throw new UnsupportedOperationException(getClass().getName() + ".listIterator");
	}

	public boolean remove(Object o) {
		if (!(o instanceof Adapter))
			return false;
		return ecoreList.remove(((Adapter)o).getTarget());
	}

	public A remove(int index) {
		return getAdapter(ecoreList.remove(index));
	}

	public boolean removeAll(Collection<?> c) {
		boolean status = false;
		for (Object o : c)
			if (remove(o))
				status = true;
		return status;
	}

	@SuppressWarnings("unchecked")
	public boolean retainAll(Collection<?> c) {
		boolean status = false;
		for (EObject e : ecoreList.toArray(new EObject[ecoreList.size()]))
			if (!c.contains(getAdapter((E) e))) {
				ecoreList.remove(e);
				status = true;
			}
		return status;
	}

	public A set(int index, A element) {
		return getAdapter(ecoreList.set(index, getTarget(element)));
	}

	public int size() {
		return ecoreList.size();
	}

	public List<A> subList(int fromIndex, int toIndex) {
		throw new UnsupportedOperationException(getClass().getName() + ".subList");
	}

	@SuppressWarnings("unchecked")
	public Object[] toArray() {
		Object[] ecoreObjects = ecoreList.toArray();
		Object[] adaptingObjects = new Object[ecoreObjects.length];
		for (int i = 0; i < ecoreObjects.length; i++)
			adaptingObjects[i] = getAdapter((E) ecoreObjects[i]);
		return adaptingObjects;
	}

	@SuppressWarnings("unchecked")
	public <T> T[] toArray(T[] a) {
		Object[] ecoreObjects = ecoreList.toArray();
		for (int i = 0; i < ecoreObjects.length; i++)
			a[i] = (T) getAdapter((E) ecoreObjects[i]);
		return a;
	}
}