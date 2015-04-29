package org.eclipse.qvtd.pivot.qvtbase.library.model;

import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.AbstractUnaryOperation;
import org.eclipse.ocl.pivot.messages.PivotMessages;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.SetValue;
import org.eclipse.qvtd.pivot.qvtbase.evaluation.TypedModelInstance;

/**
 * RootObjectsOperation realises the Model::rootObjects() library operation.
 */
public class RootObjectsOperation extends AbstractUnaryOperation
{
	public static final @NonNull RootObjectsOperation INSTANCE = new RootObjectsOperation();

	@Override
	public @NonNull SetValue evaluate(@NonNull Evaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceVal) {
		if (!(sourceVal instanceof TypedModelInstance)) {
			throw new InvalidValueException(PivotMessages.TypedValueRequired, "TypedModelInstance", getTypeName(sourceVal));
		}
		TypedModelInstance typedModelInstance = (TypedModelInstance)sourceVal;
		Set<Object> results = typedModelInstance.getRootObjects();
		return createSetValue((CollectionTypeId)returnTypeId, results);
	}
}
