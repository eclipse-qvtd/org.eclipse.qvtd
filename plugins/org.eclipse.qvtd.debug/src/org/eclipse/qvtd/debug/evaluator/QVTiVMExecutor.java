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

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.vm.evaluator.IVMContext;
import org.eclipse.ocl.examples.debug.vm.evaluator.VMEvaluationStepper;
import org.eclipse.ocl.examples.debug.vm.evaluator.VMExecutor;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.qvtd.debug.QVTiDebugPlugin;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.BasicQVTiExecutor;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEvaluationVisitor;

public class QVTiVMExecutor extends BasicQVTiExecutor implements VMExecutor
{
	protected final @NonNull IVMContext vmContext;
	private boolean suspendOnStartup = false;
	private long envId = 0;

    public QVTiVMExecutor(@NonNull IVMContext vmContext, @NonNull URI transformationURI) throws IOException {
    	super((QVTiEnvironmentFactory) vmContext.getEnvironmentFactory(), QVTbaseUtil.loadTransformation(ImperativeModel.class, vmContext.getEnvironmentFactory(), transformationURI, vmContext.keepDebug()));
		this.vmContext = vmContext;
    }

	@Override
	protected @NonNull QVTiVMEvaluationVisitor createEvaluationVisitor() {
		QVTiEvaluationVisitor evaluationVisitor = new QVTiEvaluationVisitor(this);
		QVTiVMEvaluationStepper vmEvaluationStepper =  new QVTiVMEvaluationStepper(evaluationVisitor, vmContext);
		return new QVTiVMEvaluationVisitor(vmEvaluationStepper, evaluationVisitor);
	}

	@Override
	protected @NonNull QVTiVMEvaluationEnvironment createNestedEvaluationEnvironment(EvaluationEnvironment.@NonNull EvaluationEnvironmentExtension evaluationEnvironment, @NonNull NamedElement executableObject, @Nullable OCLExpression callingObject) {
		return new QVTiVMNestedEvaluationEnvironment((QVTiVMEvaluationEnvironment) evaluationEnvironment, executableObject, callingObject, ++envId);
	}

	@Override
	protected @NonNull QVTiVMEvaluationEnvironment createRootEvaluationEnvironment(@NonNull NamedElement executableObject) {
		return new QVTiVMRootEvaluationEnvironment(this, (Transformation)executableObject, ++envId);
	}

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
	public void setSuspendOnStartUp(boolean suspendOnStartup) {
		this.suspendOnStartup = suspendOnStartup;
	}
}
