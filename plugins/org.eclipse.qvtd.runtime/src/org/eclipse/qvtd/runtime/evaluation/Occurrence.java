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
package org.eclipse.qvtd.runtime.evaluation;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ids.IdResolver;

/** 
 * An Occurrence identifies an object creation or execution that must only happen once.
 * 
 * @noimplement clients should derive from AbstractSingleton
 * @since 1.1
 */
public interface Occurrence extends ExecutionVisitable
{
	/**
	 * Return true if an occurrence with thoseValues would be a re-occurrence.
	 */
	boolean isEqual(@NonNull IdResolver idResolver, @Nullable Object @NonNull [] thoseValues);
	
	public interface Constructor<T extends Occurrence>
	{
		T getResultOf(@NonNull T theOccurrence);
		@NonNull T newInstance(@Nullable Object @NonNull [] values);
	}
	
	public interface Incremental extends Occurrence
	{
	}
}