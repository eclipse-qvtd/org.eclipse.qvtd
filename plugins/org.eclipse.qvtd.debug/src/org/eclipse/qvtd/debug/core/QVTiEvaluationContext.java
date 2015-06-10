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
package org.eclipse.qvtd.debug.core;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.vm.core.EvaluationContext;
import org.eclipse.ocl.examples.debug.vm.evaluator.VMContext;
import org.eclipse.ocl.pivot.resource.BasicProjectManager;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;

public class QVTiEvaluationContext extends EvaluationContext
{
	private @NonNull URI transformationURI;
	private @NonNull Map<String, URI> inputURIs = new HashMap<String, URI>();
	private @NonNull Map<String, URI> outputURIs = new HashMap<String, URI>();

	public QVTiEvaluationContext(@NonNull URI transformationURI, @NonNull Map<String, URI> inputURIs, @NonNull Map<String, URI> outputURIs) {
		super(new VMContext(new QVTiEnvironmentFactory(BasicProjectManager.createDefaultProjectManager(), null)));
		this.transformationURI = transformationURI;
		this.inputURIs = inputURIs;
		this.outputURIs = outputURIs;
	}

	public @NonNull URI getDebuggableURI() {
		return transformationURI;
	}

	public @Nullable URI getInputURI(@NonNull String name) {
		return inputURIs.get(name);
	}

	public @NonNull Map<String, URI> getInputURIs() {
		return inputURIs;
	}

	public @Nullable URI getOutputURI(@NonNull String name) {
		return outputURIs.get(name);
	}

	public @NonNull Map<String, URI> getOutputURIs() {
		return outputURIs;
	}

	public @Nullable URI getTraceFileURI() {
		return null;
	}

	public @NonNull URI getTransformationURI() {
		return transformationURI;
	}
}
