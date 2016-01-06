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

import java.util.List;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.DiagnosticException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.vm.ValidBreakpointLocator;
import org.eclipse.ocl.examples.debug.vm.core.EvaluationContext;
import org.eclipse.ocl.examples.debug.vm.evaluator.IVMContext;
import org.eclipse.ocl.examples.debug.vm.launching.DebuggableRunner;
import org.eclipse.ocl.examples.debug.vm.launching.DebuggableRunnerFactory;
import org.eclipse.qvtd.debug.QVTiDebugPlugin;
import org.eclipse.qvtd.debug.core.QVTiEvaluationContext;
import org.eclipse.qvtd.debug.vm.QVTiIsBreakpointableVisitor;

public class QVTiDebuggableRunnerFactory extends DebuggableRunnerFactory
{
	public static final @NonNull ValidBreakpointLocator validBreakpointLocator = new ValidBreakpointLocator(QVTiIsBreakpointableVisitor.INSTANCE);
	
	public QVTiDebuggableRunnerFactory(EPackage.@NonNull Registry packageRegistry,
			@NonNull List<String> modelURIs, @Nullable String traceFileURI) {
		super(packageRegistry, modelURIs, traceFileURI);
	}

	public @NonNull DebuggableRunner createRunner(@NonNull EvaluationContext evaluationContext) throws DiagnosticException {
		QVTiEvaluationContext qvtiEvaluationContext = (QVTiEvaluationContext)evaluationContext;
		@SuppressWarnings("unused") BasicDiagnostic diagnostic = createDiagnostic("Transformation runner problems");
		@SuppressWarnings("unused") URI uri = null;
//		try {
			uri = qvtiEvaluationContext.getTransformationURI(); //toURI(this.transformationURI, "transformation");
//		} catch(DiagnosticException e) {
//			QVTdDebugUIPlugin.createDiagnostic("Transformation runner problems").add(e.getDiagnostic());
//		}

//		List<URI> paramURIs = new ArrayList<URI>();
/*		if(this.modelParamURI != null) {
			for (String paramURIStr : this.modelParamURI) {
				try {
					paramURIs.add(toURI(paramURIStr, "model parameter"));
				} catch(DiagnosticException e) {
					diagnostic.add(e.getDiagnostic());
				}
			}
		} else {
			diagnostic.add(QVTdDebugUIPlugin.createErrorDiagnostic("No model parameters passed to transformation", null));
		}

		if(diagnostic.getSeverity() == Diagnostic.ERROR) {
			throw new DiagnosticException(diagnostic);
		} */
		IVMContext environmentFactory = qvtiEvaluationContext.getVMContext();
		QVTiInternalDebuggableExecutor executor = new QVTiInternalDebuggableExecutor(qvtiEvaluationContext, environmentFactory);
		DebuggableRunner runner = new DebuggableRunner(this, qvtiEvaluationContext.getTransformationURI(), executor);
		
/*		if(traceFileURI != null) {
			try {
				runner.setTraceFile(toURI(this.traceFileURI, "trace file"));
			} catch(DiagnosticException e) {
				diagnostic.add(e.getDiagnostic());
			}
		} */

		return runner;
	}

	protected @NonNull String getPluginId() {
		return QVTiDebugPlugin.PLUGIN_ID;
	}

	@Override
	public @NonNull ValidBreakpointLocator getValidBreakpointLocator() {
		return validBreakpointLocator;
	}
}
