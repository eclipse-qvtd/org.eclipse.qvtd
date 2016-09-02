/**
 * This file was copied and re-packaged automatically by
 *     org.eclipse.qvtd.doc.miniocl.build.MiniOCLBuildEverything
 * from 
 *     ..\..\plugins\org.eclipse.qvtd.runtime\src\org\eclipse\qvtd\runtime\evaluation\TransformationInstance.java
 *
 * Do not edit this file. 
 */
/*******************************************************************************
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.doc.minioclcs.xtext.tx;

import org.eclipse.jdt.annotation.Nullable;

/**
 * A TransformationInstance reifies an executing transformation as a useable
 * transformation model instance during the execution of a transformation.
 * 
 * at-since 1.1
 * @noimplement clients should derive from AbstractTransformationInstance
 */
public interface TransformationInstance
{
	@Nullable String getName();
}