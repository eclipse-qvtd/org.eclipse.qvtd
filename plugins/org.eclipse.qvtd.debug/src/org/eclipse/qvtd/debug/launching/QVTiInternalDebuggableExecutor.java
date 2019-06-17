/*******************************************************************************
 * Copyright (c) 2014, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     R.Dvorak and others - QVTo debugger framework
 *     E.D.Willink - revised API for OCL/QVTi debugger framework
 *******************************************************************************/
package org.eclipse.qvtd.debug.launching;

import java.io.IOException;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.debug.vm.evaluator.IVMContext;
import org.eclipse.ocl.examples.debug.vm.launching.InternalDebuggableExecutor;
import org.eclipse.qvtd.debug.core.QVTiEvaluationContext;
import org.eclipse.qvtd.debug.evaluator.QVTiVMExecutor;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiModelsManager;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiModelsManager.QVTiTypedModelInstance;

/**
 * Internal transformation executor
 *
 * @since 3.0
 */
public class QVTiInternalDebuggableExecutor extends InternalDebuggableExecutor
{
	protected final @NonNull QVTiEvaluationContext evaluationContext;

	public QVTiInternalDebuggableExecutor(@NonNull QVTiEvaluationContext evaluationContext, @NonNull IVMContext vmContext) {
		super(vmContext, evaluationContext.getTransformationURI());
		this.evaluationContext = evaluationContext;
	}

	@Override
	protected @NonNull QVTiVMExecutor createVMExecutor() throws IOException {
		QVTiVMExecutor vmExecutor = new QVTiVMExecutor(vmContext, evaluationContext.getTransformationURI());
		QVTiModelsManager modelsManager = vmExecutor.getModelsManager();
		for (Map.Entry<String, URI> inEntry : evaluationContext.getInputURIs().entrySet()) {
			@SuppressWarnings("null")@NonNull String inKey = inEntry.getKey();
			@SuppressWarnings("null")@NonNull URI inURI = inEntry.getValue();
			QVTiTypedModelInstance typedModelInstance = modelsManager.getTypedModelInstance(inKey);
			typedModelInstance.addInputResource(inURI, null);
		}
		for (Map.Entry<String, URI> outEntry : evaluationContext.getOutputURIs().entrySet()) {
			@SuppressWarnings("null")@NonNull String outKey = outEntry.getKey();
			@SuppressWarnings("null")@NonNull URI outURI = outEntry.getValue();
			QVTiTypedModelInstance typedModelInstance = modelsManager.getTypedModelInstance(outKey);
			typedModelInstance.addOutputResource(outURI, null);
		}
		return vmExecutor;
	}
}
