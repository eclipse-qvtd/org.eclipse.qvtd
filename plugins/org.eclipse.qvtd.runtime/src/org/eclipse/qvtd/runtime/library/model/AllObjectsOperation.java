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
package org.eclipse.qvtd.runtime.library.model;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.AbstractUnaryOperation;
import org.eclipse.ocl.pivot.messages.PivotMessages;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.SetValue;
import org.eclipse.qvtd.runtime.evaluation.TypedModelInstance;

/**
 * AllObjectsOperation realises the Model::allObjects() library operation.
 * @deprecated This is not needed by synthesized QVTr
 */
@Deprecated
public class AllObjectsOperation extends AbstractUnaryOperation
{
	public static final @NonNull AllObjectsOperation INSTANCE = new AllObjectsOperation();

	@Override
	public @NonNull SetValue evaluate(@NonNull Executor executor, @NonNull TypeId returnTypeId, @Nullable Object sourceVal) {
		if (!(sourceVal instanceof TypedModelInstance)) {
			throw new InvalidValueException(PivotMessages.TypedValueRequired, "TypedModelInstance", getTypeName(sourceVal));
		}
		TypedModelInstance typedModelInstance = (TypedModelInstance)sourceVal;
		Iterable<@NonNull ? extends Object> results = typedModelInstance.getAllObjects();
		return new IterableAsSetValue<Object>((CollectionTypeId)returnTypeId, results);
	}
}
