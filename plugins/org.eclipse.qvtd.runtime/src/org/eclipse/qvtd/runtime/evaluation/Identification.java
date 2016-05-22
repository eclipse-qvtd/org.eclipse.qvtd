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

/** 
 * An Identification identifies a unique object with its bound values. This is used to support
 * - a function cache which associates a result with its arguments.
 * - an OCL shadow which identifies objects from all its properties.
 * - a QVTr key which identifies objects from a subset of their properties.
 * 
 * @noimplement clients should derive from AbstractIdentification
 * @since 1.1
 */
public interface Identification extends Occurrence
{
	@NonNull Object getInstance();
	
	public interface Incremental extends Identification, Occurrence.Incremental
	{
	}
}