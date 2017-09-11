package org.eclipse.qvtd.atl.atl2qvtr;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.m2m.atl.common.ATL.Binding;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.AbstractBinaryOperation;

public class Helper4getProperty extends AbstractBinaryOperation
{
	public static final @NonNull Helper4getProperty INSTANCE = new Helper4getProperty();

	@Override
	public @NonNull Object evaluate(@NonNull Executor executor, @NonNull TypeId returnTypeId, @Nullable Object sourceValue, @Nullable Object argumentValue) {
		Binding atlType = (Binding)sourceValue;
		assert atlType != null;
		StandardLibrary standardLibrary = executor.getStandardLibrary();
		/*		if (atlType instanceof BooleanType) {
			return standardLibrary.getBooleanType();
		}
		else if (atlType instanceof IntegerType) {
			return standardLibrary.getIntegerType();
		}
		else if (atlType instanceof RealType) {
			return standardLibrary.getRealType();
		}
		else if (atlType instanceof StringType) {
			return standardLibrary.getStringType();
		}
		else if (atlType instanceof OclModelElement) {
			OclModelElement oclModelElement = (OclModelElement)atlType;
			OclModel metamodel = oclModelElement.getModel();
			//			OclModel metamodel = model.getMetamodel();
			Module atlModule = (Module) EcoreUtil.getRootContainer(oclModelElement);
			assert atlModule != null;
			String packageName = metamodel.getName();
			assert packageName != null;
			String className = oclModelElement.getName();
			assert className != null;
			org.eclipse.ocl.pivot.Class asClass = HelperUtils.getClass(executor, atlModule, packageName, className);
			if (asClass != null) {
				return asClass;
			}
			return standardLibrary.getOclInvalidType();
		}
		else {
			return standardLibrary.getOclInvalidType();
		} */
		return standardLibrary.getOclInvalidProperty();
	}
}
