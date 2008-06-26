package org.eclipse.qvt.declarative.execution;

public class LabelledModelImpl implements LabelledModel {

	protected String name;
	protected String model;
	protected LabelledModel metamodel;

	protected LabelledModelImpl(String name, String model) {
		super();
		this.metamodel = this;
		this.model = model;
		this.name = name;
	}

	protected LabelledModelImpl(String name, String model,
			LabelledModel metamodel) {
		super();
		this.metamodel = metamodel;
		this.model = model;
		this.name = name;
	}

	@Override
	public LabelledModel getMetamodel() {
		return metamodel;
	}

	@Override
	public String getAccessor() {
		return model;
	}

	@Override
	public String getName() {
		return name;
	}
}
