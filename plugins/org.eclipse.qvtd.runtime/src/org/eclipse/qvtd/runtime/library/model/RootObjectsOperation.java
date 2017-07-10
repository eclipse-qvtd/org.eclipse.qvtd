/*******************************************************************************
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.runtime.library.model;

import java.util.Collection;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.AbstractUnaryOperation;
import org.eclipse.ocl.pivot.messages.PivotMessages;
import org.eclipse.ocl.pivot.values.CollectionValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.qvtd.runtime.evaluation.TypedModelInstance;

/**
 * RootObjectsOperation realises the Model::rootObjects() library operation.
 * @deprecated This is not needed by synthesized QVTr
 */
@Deprecated
public class RootObjectsOperation extends AbstractUnaryOperation
{
	public static final @NonNull RootObjectsOperation INSTANCE = new RootObjectsOperation();

	@Override
	public @NonNull CollectionValue evaluate(@NonNull Executor executor, @NonNull TypeId returnTypeId, @Nullable Object sourceVal) {
		if (!(sourceVal instanceof TypedModelInstance)) {
			throw new InvalidValueException(PivotMessages.TypedValueRequired, "TypedModelInstance", getTypeName(sourceVal));
		}
		TypedModelInstance typedModelInstance = (TypedModelInstance)sourceVal;
		@SuppressWarnings("null")
		Collection<@Nullable ? extends Object> results = (Collection<@Nullable ? extends Object>)typedModelInstance.getRootObjects();
		return createSetValue((CollectionTypeId)returnTypeId, results);
	}
}
