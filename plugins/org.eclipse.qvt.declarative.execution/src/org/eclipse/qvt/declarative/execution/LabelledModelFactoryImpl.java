package org.eclipse.qvt.declarative.execution;

import org.eclipse.emf.ecore.EcorePackage;

public class LabelledModelFactoryImpl implements LabelledModelFactory {

	private final static LabelledModelFactory INSTANCE = new LabelledModelFactoryImpl();

	public static LabelledModelFactory getInstance() {
		return INSTANCE;
	}

	protected final static LabelledModel LABELLED_REPOSITORY = new LabelledModelImpl(
			EcorePackage.eNAME, EcorePackage.eNS_URI);

	protected LabelledModelFactoryImpl() {

	}

	@Override
	public LabelledModel createLabelledMetamodel(String label,
			String modelAccessor) {
		LabelledModel result = new LabelledModelImpl(label, modelAccessor,
				LABELLED_REPOSITORY);
		return result;
	}

	@Override
	public LabelledModel createLabelledModel(String label,
			String modelAccessor, LabelledModel metamodel) {
		LabelledModel result = new LabelledModelImpl(label, modelAccessor,
				metamodel);
		return result;
	}

}
