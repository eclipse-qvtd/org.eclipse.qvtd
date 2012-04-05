/**
 * <copyright>
 * 
 * Copyright (c) 2007, 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * </copyright>
 * 
 * Contributors:
 *     Quentin Glineur - initial API and implementation
 *
 * $Id: LabelledModelImpl.java,v 1.3 2008/10/09 17:21:01 qglineur Exp $
 */
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
