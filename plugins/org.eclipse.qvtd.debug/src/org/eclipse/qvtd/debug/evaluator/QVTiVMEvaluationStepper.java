/*******************************************************************************
 * Copyright (c) 2014, 2015 Willink Transformations and others.
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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.debug.vm.data.VMStackFrameData;
import org.eclipse.ocl.examples.debug.vm.evaluator.AbstractVMEvaluationStepper;
import org.eclipse.ocl.examples.debug.vm.evaluator.IVMContext;
import org.eclipse.qvtd.debug.core.QVTiDebugCore;
import org.eclipse.qvtd.debug.stepper.QVTiStepperVisitor;
import org.eclipse.qvtd.debug.vm.QVTiVMVirtualMachine;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEvaluationVisitor;

public class QVTiVMEvaluationStepper extends AbstractVMEvaluationStepper
{
	public QVTiVMEvaluationStepper(@NonNull QVTiEvaluationVisitor evaluationVisitor, @NonNull IVMContext vmContext) {
		super(evaluationVisitor, vmContext, QVTiStepperVisitor.INSTANCE);
	}

	protected @NonNull VMStackFrameData @NonNull [] createStackFrame() {
		return QVTiVMVirtualMachine.createStackFrame(getLocationStack());
	}
	
    protected void log(IStatus status) {
		QVTiDebugCore.INSTANCE.log(status);
    }

	protected void trace(String option, String message) {
		QVTiDebugCore.TRACE.trace(option, message);
	}
}
