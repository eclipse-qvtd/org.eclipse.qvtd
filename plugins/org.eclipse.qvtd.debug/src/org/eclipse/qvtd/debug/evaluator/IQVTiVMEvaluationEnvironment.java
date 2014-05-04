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
import org.eclipse.ocl.examples.debug.evaluator.IVMEvaluationEnvironment;
import org.eclipse.ocl.examples.debug.vm.UnitLocation;
import org.eclipse.ocl.examples.debug.vm.utils.VMRuntimeException;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.IQVTiEvaluationEnvironment;

public interface IQVTiVMEvaluationEnvironment extends IQVTiEvaluationEnvironment, IVMEvaluationEnvironment<Transformation>
{
	@NonNull IQVTiEvaluationEnvironment createClonedEvaluationEnvironment();
	@NonNull Element getCurrentIP();
	@NonNull UnitLocation getCurrentLocation();
	@NonNull QVTiVMModelManager getModelManager();
	@Nullable IQVTiVMEvaluationEnvironment getParentEvaluationEnvironment();
	@NonNull QVTiRootVMEvaluationEnvironment getRootEvaluationEnvironment();
	void processDeferredTasks();
	@NonNull Element setCurrentIP(@NonNull Element element);
	void throwVMException(@NonNull VMRuntimeException qvtInterruptedExecutionException);
}
