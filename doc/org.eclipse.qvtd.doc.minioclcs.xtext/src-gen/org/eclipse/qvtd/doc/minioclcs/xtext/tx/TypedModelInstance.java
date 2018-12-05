/**
 * This file was copied and re-packaged automatically by
 *     org.eclipse.qvtd.doc.miniocl.build.MiniOCLBuildEverything
 * from 
 *     ..\..\plugins\org.eclipse.qvtd.runtime\src\org\eclipse\qvtd\runtime\evaluation\TypedModelInstance.java
 *
 * Do not edit this file. 
 */
/*******************************************************************************
 * Copyright (c) 2015, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.doc.minioclcs.xtext.tx;

import java.util.Collection;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * A TypedModelInstance makes an input or output model of an executing transformation
 * accessible as a model instance.
 *
 * @noimplement clients should derive from AbstractTypedModelInstance
 */
public interface TypedModelInstance
{
	@NonNull Collection<@NonNull ? extends Object> getAllObjects();
	@Nullable String getName();
	@NonNull Collection<@NonNull ? extends Object> getObjectsOfKind(org.eclipse.ocl.pivot.@NonNull Class type);
	@NonNull Collection<@NonNull ? extends Object> getObjectsOfType(org.eclipse.ocl.pivot.@NonNull Class type);
	@NonNull Collection<@NonNull ? extends Object> getRootObjects();
}
