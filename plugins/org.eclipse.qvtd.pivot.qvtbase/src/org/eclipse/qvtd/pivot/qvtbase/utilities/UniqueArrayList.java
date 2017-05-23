/*******************************************************************************
 * Copyright (c) 2016, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtbase.utilities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * A UniqueArrayList provides Set-like functionality for a List whose size is expected to be small.
 * Addition of duplicate entries is suppressed. Use of indexed mutation is prohibited.
 */
public class UniqueArrayList<T> extends ArrayList<T>
{
	private static final long serialVersionUID = -525995856050494628L;

	public UniqueArrayList() {
		super();
	}

	public UniqueArrayList(Iterable<? extends T> c) {
		if (c != null) {
			for (T e : c) {
				add(e);
			}
		}
	}

	public UniqueArrayList(int initialCapacity) {
		super(initialCapacity);
	}

	@Override
	public boolean add(T e) {
		if (!contains(e)) {
			return super.add(e);
		}
		else {
			return false;
		}
	}

	@Override
	public void add(int index, T element) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		boolean changed = false;
		if (c != null) {
			for (T e : c) {
				if (add(e)) {
					changed = true;
				}
			}
		}
		return changed;
	}

	@Override
	public boolean addAll(int index, Collection<? extends T> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public T set(int index, T element) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<T> subList(int fromIndex, int toIndex) {
		throw new UnsupportedOperationException();
	}
}