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
package org.eclipse.qvtd.runtime.evaluation;

import org.eclipse.jdt.annotation.Nullable;

/**
 * A TransformationInstance reifies an executing transformation as a useable
 * transformation model instance during the execution of a transformation.
 * 
 * @since 1.1
 * @noimplement clients should derive from AbstractTransformationInstance
 */
public interface TransformationInstance
{
	@Nullable String getName();
}