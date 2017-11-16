package org.eclipse.qvtd.atl.atl2qvtr.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.AbstractBinaryOperation;

public class Helper4getCommonType extends AbstractBinaryOperation
{
	public static final @NonNull Helper4getCommonType INSTANCE = new Helper4getCommonType();

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class evaluate(@NonNull Executor executor, @NonNull TypeId returnTypeId, @Nullable Object sourceValue, @Nullable Object argumentValue) {
		org.eclipse.ocl.pivot.Class asType1 = (org.eclipse.ocl.pivot.Class)sourceValue;
		org.eclipse.ocl.pivot.Class asType2 = (org.eclipse.ocl.pivot.Class)argumentValue;
		assert (asType1 != null);
		assert (asType2 != null);
		org.eclipse.ocl.pivot.Class asCommonType = (org.eclipse.ocl.pivot.Class)asType1.getCommonType(executor.getIdResolver(), asType2);
		return asCommonType;
	}
}
