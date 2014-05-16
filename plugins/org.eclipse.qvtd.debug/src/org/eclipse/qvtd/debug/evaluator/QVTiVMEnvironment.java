/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     R.Dvorak and others - QVTo debugger framework
 *     E.D.Willink - revised API for OCL debugger framework
 *******************************************************************************/
package org.eclipse.qvtd.debug.evaluator;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironment;

public class QVTiVMEnvironment extends QVTiEnvironment
{
	public QVTiVMEnvironment(@NonNull QVTiVMEnvironmentFactory factory, @Nullable Resource resource) {
		super(factory, resource);
	}

	public QVTiVMEnvironment(@NonNull QVTiVMEnvironment parent) {
		super(parent);
	}

	@Override
	public @NonNull QVTiVMEnvironmentFactory getFactory() {
		return (QVTiVMEnvironmentFactory) super.getFactory();
	}
}
