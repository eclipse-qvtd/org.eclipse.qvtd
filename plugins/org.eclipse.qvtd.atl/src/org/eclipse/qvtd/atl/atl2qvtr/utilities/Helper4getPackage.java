package org.eclipse.qvtd.atl.atl2qvtr.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.m2m.atl.common.ATL.Module;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.AbstractBinaryOperation;

public class Helper4getPackage extends AbstractBinaryOperation
{
	public static final @NonNull Helper4getPackage INSTANCE = new Helper4getPackage();

	@Override
	public org.eclipse.ocl.pivot.@Nullable Package evaluate(@NonNull Executor executor, @NonNull TypeId returnTypeId, @Nullable Object sourceValue, @Nullable Object argumentValue) {
		Module atlModule = (Module)sourceValue;
		assert atlModule != null;
		assert argumentValue != null;
		return HelperUtils.getPackage(executor, atlModule, (String) argumentValue);
	}
}
