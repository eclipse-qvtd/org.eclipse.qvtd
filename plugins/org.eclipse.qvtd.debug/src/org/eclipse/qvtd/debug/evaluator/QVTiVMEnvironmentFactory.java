/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     R.Dvorak and others - QVTo debugger framework
 *     E.D.Willink - revised API for OCL/QVTi debugger framework
 *******************************************************************************/
package org.eclipse.qvtd.debug.evaluator;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.vm.IVMDebuggerShell;
import org.eclipse.ocl.examples.debug.vm.evaluator.IVMEnvironmentFactory;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.IQVTiEvaluationEnvironment;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;

public class QVTiVMEnvironmentFactory extends QVTiEnvironmentFactory implements IVMEnvironmentFactory
{
//	private @Nullable IVMDebuggerShell shell;
	private long envId = 0;
	
	public QVTiVMEnvironmentFactory(EPackage.Registry reg, @NonNull MetaModelManager metaModelManager) {
		super(reg, metaModelManager);
	}

	@Override
	public @NonNull IQVTiVMEvaluationEnvironment createEvaluationEnvironment(@NonNull IQVTiEvaluationEnvironment parent, @NonNull NamedElement operation) {
		return new QVTiVMNestedEvaluationEnvironment((IQVTiVMEvaluationEnvironment) parent, ++envId, operation);
	}

	@Override
	public boolean keepDebug() {
		return true;
	}

	public void setShell(@Nullable IVMDebuggerShell shell) {
//		this.shell = shell;
	}
}
