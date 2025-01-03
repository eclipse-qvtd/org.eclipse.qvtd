/*******************************************************************************
 * Copyright (c) 2015, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.debug.evaluator;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.vm.evaluator.IVMContext;
import org.eclipse.ocl.examples.debug.vm.evaluator.VMEvaluationStepper;
import org.eclipse.ocl.examples.debug.vm.evaluator.VMExecutor;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.qvtd.debug.QVTiDebugPlugin;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.BasicQVTiExecutor;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEvaluationVisitor;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;
import org.eclipse.qvtd.runtime.evaluation.ModeFactory;

public class QVTiVMExecutor extends BasicQVTiExecutor implements VMExecutor
{
	protected final @NonNull IVMContext vmContext;
	private boolean suspendOnStartup = false;
	private long envId = 0;

	public QVTiVMExecutor(@NonNull IVMContext vmContext, @NonNull URI transformationURI) throws IOException {
		super((QVTiEnvironmentFactory)vmContext.getEnvironmentFactory(), QVTimperativeUtil.loadTransformation((QVTiEnvironmentFactory)vmContext.getEnvironmentFactory(), transformationURI, vmContext.keepDebug()), ModeFactory.LAZY);
		this.vmContext = vmContext;
	}

	@Override
	protected @NonNull QVTiVMEvaluationVisitor createEvaluationVisitor() {
		QVTiEvaluationVisitor evaluationVisitor = new QVTiEvaluationVisitor(this);
		QVTiVMEvaluationStepper vmEvaluationStepper =  new QVTiVMEvaluationStepper(evaluationVisitor, vmContext);
		return new QVTiVMEvaluationVisitor(vmEvaluationStepper, evaluationVisitor);
	}

	@Override
	protected @NonNull QVTiVMEvaluationEnvironment createNestedEvaluationEnvironment(EvaluationEnvironment.@NonNull EvaluationEnvironmentExtension evaluationEnvironment, @NonNull NamedElement executableObject, @Nullable Object caller) {
		return new QVTiVMNestedEvaluationEnvironment((QVTiVMEvaluationEnvironment) evaluationEnvironment, executableObject, caller, ++envId);
	}

	@Override
	protected @NonNull QVTiVMEvaluationEnvironment createRootEvaluationEnvironment(@NonNull NamedElement executableObject) {
		return new QVTiVMRootEvaluationEnvironment(this, (Transformation)executableObject, ++envId);
	}

	//	@Override
	//	public Boolean execute() {
	//		return execute(null);
	//	}

	@Override
	protected Boolean executeInternal() {
		QVTiVMEvaluationVisitor visitor = (QVTiVMEvaluationVisitor) getEvaluationVisitor();
		VMEvaluationStepper vmStepper = visitor.getVMEvaluationStepper();
		vmStepper.start(suspendOnStartup);
		return super.executeInternal();
	}

	@Override
	public @NonNull Transformation getDebuggable() {
		return transformation;
	}

	@Override
	public @NonNull String getPluginId() {
		return QVTiDebugPlugin.PLUGIN_ID;
	}

	@Override
	public void saveModels() {
		try {
			modelsManager.saveModels(null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void setSuspendOnStartUp(boolean suspendOnStartup) {
		this.suspendOnStartup = suspendOnStartup;
	}
}
