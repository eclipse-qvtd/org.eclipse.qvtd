package org.eclipse.qvt.declarative.execution;

public interface LabelledModelFactory {

	public static LabelledModelFactory INSTANCE = LabelledModelFactoryImpl
			.getInstance();

	public LabelledModel createLabelledModel(String label,
			String modelAccessor, LabelledModel metamodel);

	public LabelledModel createLabelledMetamodel(String label,
			String modelAccessor);
}
