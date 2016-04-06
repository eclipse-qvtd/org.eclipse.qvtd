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
package org.eclipse.qvtd.pivot.qvtbase.utilities;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * A TreeIterable supports use of the TreeIterator returned by EObject.eAllContents() as a conventional Iterable.
 * It's includeRoot option supports inclusion of the root object as is often more useful thatn the default
 * exclusion by a TreeIterator.
 */
public class TreeIterable implements Iterable<@NonNull EObject>
{
	private static class Iterator implements java.util.Iterator<@NonNull EObject>
	{
		protected @Nullable EObject firstEObject;
		protected final @NonNull TreeIterator<@NonNull EObject> tit;;
		
		public Iterator(@NonNull EObject rootEObject, boolean includeRoot) {
			this.firstEObject = includeRoot ? rootEObject : null;
			@SuppressWarnings("null")
			@NonNull TreeIterator<@NonNull EObject> eAllContents = (@NonNull TreeIterator<@NonNull EObject>)rootEObject.eAllContents();
			this.tit = eAllContents;
		}
		
		@Override
		public boolean hasNext() {
			return (firstEObject != null) || tit.hasNext();
		}

		@Override
		public @NonNull EObject next() {
			@NonNull EObject eObject;
			if (firstEObject != null) {
				eObject = firstEObject;
				firstEObject = null;
			}
			else {
				eObject = tit.next();
			}
			return eObject;
		}
	}

	protected final @NonNull EObject rootEObject;
	protected final boolean includeRoot;
	
	public TreeIterable(@NonNull EObject rootEObject, boolean includeRoot) {
		this.rootEObject = rootEObject;
		this.includeRoot = includeRoot;
	}
	
	@Override
	public @NonNull Iterator iterator() {
		return new Iterator(rootEObject, includeRoot);
	}
}