package org.eclipse.qvt.declarative.execution.internal;

import org.eclipse.qvt.declarative.execution.LabelledModel;

public class LabelledModelImpl implements LabelledModel {

	protected String name;
	protected String accessor;
	protected LabelledModel metamodel;

	protected LabelledModelImpl(String name, String model) {
		super();
		this.metamodel = this;
		this.accessor = model;
		this.name = name;
	}

	protected LabelledModelImpl(String name, String model,
			LabelledModel metamodel) {
		super();
		this.metamodel = metamodel;
		this.accessor = model;
		this.name = name;
	}

	public LabelledModel getMetamodel() {
		return metamodel;
	}

	public String getAccessor() {
		return accessor;
	}

	public String getName() {
		return name;
	}
}
