/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.runtime.library.model;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;

import com.google.common.collect.Iterables;

/**
 * This wrapper makes an Iterable appear to be a Set. It only has enough functionality to
 * support the unhelpfule ModelManager.get return type..
 */
public class IterableAsSet<T> implements Set<T>
{
	protected final @NonNull Iterable<@NonNull ? extends T> iterable;

	public IterableAsSet(@NonNull Iterable<@NonNull ? extends T> iterable) {
		this.iterable = iterable;
	}

	@Override
	public boolean add(T e) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void clear() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean contains(Object o) {
		return Iterables.contains(iterable, o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		for (Object e : c) {
			if (!contains(e)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean equals(Object obj) {
		return iterable.equals(obj);
	}

	@Override
	public int hashCode() {
		return iterable.hashCode();
	}

	@Override
	public boolean isEmpty() {
		return Iterables.isEmpty(iterable);
	}

	@Override
	public @NonNull Iterator<T> iterator() {
		return (Iterator<T>) iterable.iterator();
	}

	@Override
	public boolean remove(Object o) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public int size() {
		return Iterables.size(iterable);
	}

	@Override
	public Object[] toArray() {
		throw new UnsupportedOperationException();
	}

	@Override
	public <T1> T1[] toArray(T1[] a) {
		throw new UnsupportedOperationException();
	}
}