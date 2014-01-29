package org.eclipse.qvtd.debug.ui.launching;

import java.util.List;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.DiagnosticException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.qvtd.debug.core.EvaluationContext;
import org.eclipse.qvtd.debug.ui.QVTdDebugUIPlugin;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;

public class TransformationRunnerFactory {

	public String transformationURI;
	
	public List<String> modelParamURI;

	public String traceFileURI;
	
	public EPackage.Registry packageRegistry;
	
	public @NonNull QVTiEnvironmentFactory createEnvironmentFactory() {
		EPackage.Registry registry = this.packageRegistry != null ? this.packageRegistry : EPackage.Registry.INSTANCE;
		return new QVTiEnvironmentFactory(registry, new MetaModelManager());
	}

	public @NonNull TransformationRunner createRunner(@NonNull EvaluationContext evaluationContext) throws DiagnosticException {
		BasicDiagnostic diagnostic = QVTdDebugUIPlugin.createDiagnostic("Transformation runner problems");
		
		URI uri = null;
//		try {
			uri = evaluationContext.getTransformationURI(); //toURI(this.transformationURI, "transformation");
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
		
		TransformationRunner runner = createRunner(evaluationContext, createEnvironmentFactory());
		
/*		if(traceFileURI != null) {
			try {
				runner.setTraceFile(toURI(this.traceFileURI, "trace file"));
			} catch(DiagnosticException e) {
				diagnostic.add(e.getDiagnostic());
			}
		} */

		return runner;
	}
	
	protected @NonNull TransformationRunner createRunner(@NonNull EvaluationContext evaluationContext, @NonNull QVTiEnvironmentFactory envFactory) {
		return new TransformationRunner(evaluationContext, envFactory);
	}
	
/*	private URI toURI(String uriStr, String uriType) throws DiagnosticException {
		IllegalArgumentException exc = null;
		if(uriStr != null) {
			try {
				return URI.createURI(uriStr);
			} catch(IllegalArgumentException e) {
				exc = e; 
			}
		}

		String message = NLS.bind("Invalid {0} URI : ''{1}''", uriType, uriStr);
		throw new DiagnosticException(QVTdDebugUIPlugin.createErrorDiagnostic(message, exc));
	} */
}
