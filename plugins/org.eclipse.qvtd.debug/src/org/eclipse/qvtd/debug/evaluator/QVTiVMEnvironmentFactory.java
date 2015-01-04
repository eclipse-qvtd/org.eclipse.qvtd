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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.vm.IVMDebuggerShell;
import org.eclipse.ocl.examples.debug.vm.evaluator.IVMEnvironmentFactory;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.pivot.resource.StandaloneProjectMap;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiModelManager;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiTransformationAnalysis;

public class QVTiVMEnvironmentFactory extends QVTiEnvironmentFactory implements IVMEnvironmentFactory
{
	private @Nullable IVMDebuggerShell shell;
	private long envId = 0;
	
	public QVTiVMEnvironmentFactory(@Nullable StandaloneProjectMap projectMap) {
		super(projectMap);
	}

	public @NonNull IQVTiVMEvaluationEnvironment createEvaluationEnvironment(@NonNull Transformation transformation, @NonNull QVTiModelManager modelManager) {
		return new QVTiVMRootEvaluationEnvironment(this, transformation, modelManager, ++envId);
	}

	@Override
	public @NonNull IQVTiVMEvaluationEnvironment createEvaluationEnvironment(@NonNull EvaluationEnvironment parent, @NonNull NamedElement operation) {
		return new QVTiVMNestedEvaluationEnvironment((IQVTiVMEvaluationEnvironment) parent, operation, ++envId);
	}

	@Override
	public @NonNull QVTiVMRootEvaluationVisitor createEvaluationVisitor(@NonNull EvaluationEnvironment evalEnv) {
		return new QVTiVMRootEvaluationVisitor((IQVTiVMEvaluationEnvironment) evalEnv, ClassUtil.nonNullState(shell));
	}

	@Override
	public @NonNull QVTiVMModelManager createModelManager(@NonNull QVTiTransformationAnalysis transformationAnalysis) {
		return new QVTiVMModelManager(transformationAnalysis);
	}

	@Override
	public boolean keepDebug() {
		return true;
	}

	public void setShell(@Nullable IVMDebuggerShell shell) {
		this.shell = shell;
	}
}
