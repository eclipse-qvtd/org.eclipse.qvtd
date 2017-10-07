package org.eclipse.qvtd.atl.atl2qvtr;

import java.util.Iterator;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.AbstractBinaryOperation;

public class Helper4getOperation extends AbstractBinaryOperation
{
	public static final @NonNull Helper4getOperation INSTANCE = new Helper4getOperation();

	@Override
	public @NonNull Operation evaluate(@NonNull Executor executor, @NonNull TypeId returnTypeId, @Nullable Object sourceValue, @Nullable Object argumentValue) {
		org.eclipse.ocl.pivot.Class asType = (org.eclipse.ocl.pivot.Class)sourceValue;
		Operation asOperation = null;
		assert (asType != null);// {
		String operationName = (String) argumentValue;
		assert operationName != null;
		CompleteClass completeClass = executor.getEnvironmentFactory().getCompleteModel().getCompleteClass(asType);
		Iterator<@NonNull Operation> asOperations = completeClass.getOperations(null, operationName).iterator();
		asOperation = asOperations.hasNext() ? asOperations.next() : null;
		//		}
		if (asOperation == null) {
			asOperation = executor.getStandardLibrary().getOclInvalidOperation();
		}
		return asOperation;
	}
}
