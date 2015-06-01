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
package org.eclipse.qvtd.debug.launching;

import java.io.IOException;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.debug.vm.launching.InternalDebuggableExecutor;
import org.eclipse.qvtd.debug.core.QVTiEvaluationContext;
import org.eclipse.qvtd.debug.evaluator.QVTiVMEnvironmentFactory;
import org.eclipse.qvtd.debug.evaluator.QVTiVMEvaluator;

/**
 * Internal transformation executor
 * 
 * @since 3.0
 */
public class QVTiInternalDebuggableExecutor extends InternalDebuggableExecutor
{
	protected final @NonNull QVTiEvaluationContext evaluationContext;
	
	public QVTiInternalDebuggableExecutor(@NonNull QVTiEvaluationContext evaluationContext, @NonNull QVTiVMEnvironmentFactory vmEnvironmentFactory) {
		super(vmEnvironmentFactory, evaluationContext.getTransformationURI());
		this.evaluationContext = evaluationContext;
	}

	protected @NonNull QVTiVMEvaluator createVMEvaluator() throws IOException {
		QVTiVMEvaluator evaluator = new QVTiVMEvaluator((QVTiVMEnvironmentFactory) vmEnvironmentFactory, evaluationContext.getTransformationURI());
		for (Map.Entry<String, URI> inEntry : evaluationContext.getInputURIs().entrySet()) {
			@SuppressWarnings("null")@NonNull String inKey = inEntry.getKey();
			@SuppressWarnings("null")@NonNull URI inURI = inEntry.getValue();
			evaluator.loadModel(inKey, inURI, null);
		}
		for (Map.Entry<String, URI> outEntry : evaluationContext.getOutputURIs().entrySet()) {
			@SuppressWarnings("null")@NonNull String outKey = outEntry.getKey();
			@SuppressWarnings("null")@NonNull URI outURI = outEntry.getValue();
			evaluator.createModel(outKey, outURI, null);
		}
		return evaluator;
	}
}
