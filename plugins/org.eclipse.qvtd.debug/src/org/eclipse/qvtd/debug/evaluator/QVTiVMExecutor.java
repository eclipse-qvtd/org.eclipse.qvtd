/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.debug.evaluator;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.debug.vm.evaluator.IVMContext;
import org.eclipse.ocl.examples.debug.vm.evaluator.IVMModelManager;
import org.eclipse.ocl.examples.debug.vm.evaluator.VMExecutor;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.qvtd.debug.QVTiDebugPlugin;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.BasicQVTiExecutor;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEvaluationVisitor;

public class QVTiVMExecutor extends BasicQVTiExecutor implements VMExecutor
{
	protected final @NonNull IVMContext vmContext;
	private long envId = 0;
	
	public QVTiVMExecutor(@NonNull IVMContext vmContext, @NonNull IVMModelManager modelManager) {
		super((QVTiEnvironmentFactory)vmContext.getEnvironmentFactory(), modelManager);
		this.vmContext = vmContext;
	}

	@Override
	protected @NonNull QVTiVMEvaluationVisitor createEvaluationVisitor() {
		QVTiEvaluationVisitor evaluationVisitor = new QVTiEvaluationVisitor(this);
		return new QVTiVMEvaluationVisitor(evaluationVisitor, vmContext);
	}

	@Override
	protected @NonNull QVTiVMEvaluationEnvironment createNestedEvaluationEnvironment(@NonNull EvaluationEnvironment evaluationEnvironment, @NonNull NamedElement executableObject) {
		return new QVTiVMNestedEvaluationEnvironment((QVTiVMEvaluationEnvironment) evaluationEnvironment, executableObject, ++envId);
	}

	@Override
	protected @NonNull QVTiVMEvaluationEnvironment createRootEvaluationEnvironment(@NonNull NamedElement executableObject) {
		return new QVTiVMRootEvaluationEnvironment(this, (Transformation)executableObject, ++envId);
	}

	@Override
	public @NonNull QVTiVMEvaluationVisitor getEvaluationVisitor() {
		return (QVTiVMEvaluationVisitor) super.getEvaluationVisitor();
	}

	@Override
	public @NonNull String getPluginId() {
		return QVTiDebugPlugin.PLUGIN_ID;
	}

	@Override
	public @NonNull QVTiVMEvaluationEnvironment getRootEvaluationEnvironment() {
		return (QVTiVMEvaluationEnvironment) super.getRootEvaluationEnvironment();
	}

	@Override
	public @NonNull IVMContext getVMContext() {
		return vmContext;
	}
}
