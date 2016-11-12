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
package org.eclipse.qvtd.runtime.evaluation;

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
	/**
	 * This is solely used by the Model::allObjects Operation which is not needed by synthesized QVTr.
	 * @deprecated
	 */
	@Deprecated
	@NonNull Iterable<@NonNull ? extends Object> getAllObjects();

	@Nullable String getName();

	/**
	 * This is solely used by the Model::objectsOfKind Operation which is not needed by synthesized QVTr.
	 * @deprecated
	 */
	@Deprecated
	@NonNull Iterable<@NonNull ? extends Object> getObjectsOfKind(org.eclipse.ocl.pivot.@NonNull Class type);

	/**
	 * This is solely used by the Model::objectsOfType Operation which is not needed by synthesized QVTr.
	 * @deprecated
	 */
	@Deprecated
	@NonNull Collection<@NonNull ? extends Object> getObjectsOfType(org.eclipse.ocl.pivot.@NonNull Class type);

	/**
	 * This is solely used by the Model::rootObjects Operation which is not needed by synthesized QVTr.
	 * @deprecated
	 */
	@Deprecated
	@NonNull Collection<@NonNull ? extends Object> getRootObjects();
}
