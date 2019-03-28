/**
 * This file was copied and re-packaged automatically by
 *     org.eclipse.qvtd.doc.miniocl.build.MiniOCLBuildEverything
 * from 
 *     ..\..\plugins\org.eclipse.qvtd.runtime\src\org\eclipse\qvtd\runtime\library\model\ModelObjectsOfTypeOperation.java
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
package org.eclipse.qvtd.doc.minioclcs.xtext.library.model;

import java.util.Collection;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.AbstractBinaryOperation;
import org.eclipse.ocl.pivot.messages.PivotMessages;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.SetValue;
import org.eclipse.qvtd.doc.minioclcs.xtext.tx.TypedModelInstance;

/**
 * ModelObjectsOfTypeOperation realises the Model::objectsOfType() library operation.
 * @deprecated This is not needed by synthesized QVTr
 */
@Deprecated
public class ModelObjectsOfTypeOperation extends AbstractBinaryOperation
{
	public static final @NonNull ModelObjectsOfTypeOperation INSTANCE = new ModelObjectsOfTypeOperation();

	@Override
	public @NonNull SetValue evaluate(@NonNull Executor executor, @NonNull TypeId returnTypeId, @Nullable Object sourceVal, @Nullable Object typeVal) {
		org.eclipse.ocl.pivot.Class type = asClass(typeVal);
		if (!(sourceVal instanceof TypedModelInstance)) {
			throw new InvalidValueException(PivotMessages.TypedValueRequired, "TypedModelInstance", getTypeName(sourceVal));
		}
		TypedModelInstance typedModelInstance = (TypedModelInstance)sourceVal;
		Collection<@NonNull ? extends Object> results = typedModelInstance.getObjectsOfType(type);
		return createSetValue((CollectionTypeId)returnTypeId, results);
	}
}
