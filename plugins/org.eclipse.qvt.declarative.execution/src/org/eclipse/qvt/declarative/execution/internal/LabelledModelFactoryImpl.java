package org.eclipse.qvt.declarative.execution.internal;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.qvt.declarative.execution.LabelledModel;
import org.eclipse.qvt.declarative.execution.LabelledModelFactory;

public class LabelledModelFactoryImpl implements LabelledModelFactory {

	private final static LabelledModelFactory INSTANCE = new LabelledModelFactoryImpl();

	public static LabelledModelFactory getInstance() {
		return INSTANCE;
	}

	protected final static LabelledModel LABELLED_REPOSITORY = new LabelledModelImpl(
			EcorePackage.eNAME, EcorePackage.eNS_URI);

	protected LabelledModelFactoryImpl() {

	}

	public LabelledModel createLabelledMetamodel(String label,
			String modelAccessor) {
		LabelledModel result = new LabelledModelImpl(label, modelAccessor,
				LABELLED_REPOSITORY);
		return result;
	}

	public LabelledModel createLabelledModel(String label,
			String modelAccessor, LabelledModel metamodel) {
		LabelledModel result = new LabelledModelImpl(label, modelAccessor,
				metamodel);
		return result;
	}

}
