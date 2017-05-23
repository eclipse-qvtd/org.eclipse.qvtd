/*******************************************************************************
 * Copyright (c) 2014, 2016 Willink Transformations and others.
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
import org.eclipse.ocl.examples.debug.vm.UnitLocation;
import org.eclipse.ocl.examples.debug.vm.evaluator.VMEvaluationEnvironment;
import org.eclipse.ocl.examples.debug.vm.utils.VMRuntimeException;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEvaluationEnvironment;

public interface QVTiVMEvaluationEnvironment extends QVTiEvaluationEnvironment, VMEvaluationEnvironment
{
	@NonNull QVTiVMEvaluationEnvironment createClonedEvaluationEnvironment();
	@Override
	@NonNull Element getCurrentIP();
	@Override
	@NonNull UnitLocation getCurrentLocation();
	@Override
	@Nullable QVTiVMEvaluationEnvironment getVMParentEvaluationEnvironment();
	@Override
	@NonNull QVTiVMRootEvaluationEnvironment getVMRootEvaluationEnvironment();
	@Override
	void processDeferredTasks();
	@Override
	@NonNull Element setCurrentIP(@NonNull Element element);
	@Override
	void throwVMException(@NonNull VMRuntimeException qvtInterruptedExecutionException);
}
