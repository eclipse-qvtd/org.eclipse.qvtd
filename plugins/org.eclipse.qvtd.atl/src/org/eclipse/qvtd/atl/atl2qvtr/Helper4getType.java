package org.eclipse.qvtd.atl.atl2qvtr;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.m2m.atl.common.OCL.OclType;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.AbstractUnaryOperation;

public class Helper4getType extends AbstractUnaryOperation
{
	public static final @NonNull Helper4getType INSTANCE = new Helper4getType();

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class evaluate(@NonNull Executor executor, @NonNull TypeId returnTypeId, @Nullable Object sourceValue) {
		OclType atlType = (OclType)sourceValue;
		if (atlType != null) {
			return HelperUtils.getType(executor, atlType);
		}
		else {
			return executor.getStandardLibrary().getOclInvalidType();
		}
	}
}
