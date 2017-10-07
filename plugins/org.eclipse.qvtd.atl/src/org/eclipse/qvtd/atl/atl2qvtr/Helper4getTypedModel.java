package org.eclipse.qvtd.atl.atl2qvtr;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.AbstractBinaryOperation;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;

public class Helper4getTypedModel extends AbstractBinaryOperation
{
	public static final @NonNull Helper4getTypedModel INSTANCE = new Helper4getTypedModel();

	@Override
	public @NonNull TypedModel evaluate(@NonNull Executor executor, @NonNull TypeId returnTypeId, @Nullable Object sourceValue, @Nullable Object argumentValue) {
		Relation relation = (Relation)argumentValue;
		assert relation != null;
		/*		String propertyName = (String) argumentValue;
		if (sourceValue instanceof OclType) {
			OclType atlType = (OclType)sourceValue;
			assert propertyName != null;
			org.eclipse.ocl.pivot.Class asType = HelperUtils.getType(executor, atlType);
			CompleteClass completeClass = executor.getEnvironmentFactory().getCompleteModel().getCompleteClass(asType);
			asProperty = completeClass.getProperty(propertyName);
		}
		if (asProperty == null) {
			asProperty = executor.getStandardLibrary().getOclInvalidProperty();
		} */
		return ClassUtil.nonNullState(relation.getTransformation().getModelParameter().get(0));
	}
}
