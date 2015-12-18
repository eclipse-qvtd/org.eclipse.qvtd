/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.scheduler;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.eclipse.jdt.annotation.NonNull;

public final class SingletonIterator<T> implements Iterator<T>
{
	private final @NonNull T element;
	private boolean hasNext = true;

	public SingletonIterator(@NonNull T element) {
		this.element = element;
	}

	@Override
	public boolean hasNext() {
	    return hasNext;
	}

	@Override
	public @NonNull T next() {
	    if (!hasNext) {
		    throw new NoSuchElementException();
	    }
        hasNext = false;
        return element;
	}

	@Override
	public void remove() {
	    throw new UnsupportedOperationException();
	}
}