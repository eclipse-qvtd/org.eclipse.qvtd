/*******************************************************************************
 * Copyright (c) 2013, 2016 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.runtime.evaluation;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ids.IdResolver;

/** 
 * A Computation identifies a unique computation of its input values. This is used to support
 * - a function cache which associates a result with its arguments.
 * - an OCL shadow which identifies objects from all its properties.
 * - a QVTr key which identifies objects from a subset of their properties.
 * 
 * @noimplement clients should derive from AbstractIdentification
 * @since 1.1
 */
public interface Computation extends ExecutionVisitable
{	
	@Nullable Object getResult();
	
	/**
	 * Return true if this is a computation from thoseValues.
	 */
	boolean isEqual(@NonNull IdResolver idResolver, @Nullable Object @NonNull [] thoseValues);
	
	public interface Constructor
	{	
		/**
		 * Return the cached computation from argValues, using newInstance(argValues) to
		 * create a new computation instance if necessary.
		 */
		public @NonNull Computation getUniqueComputation(@Nullable Object @NonNull ... argValues);
	}
	
	public interface Incremental extends Computation
	{
	}
}