package org.eclipse.qvtd.debug.ui.launching;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.osgi.util.NLS;
import org.eclipse.qvtd.debug.core.EvaluationContext;
import org.eclipse.qvtd.debug.stubs.ExecutionDiagnostic;
import org.eclipse.qvtd.debug.ui.QVTdDebugUIPlugin;
import org.eclipse.qvtd.debug.utils.Trace;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;

public class TransformationRunner  {

	protected static class Executor extends InternalTransformationExecutor {
		
		Trace fTraces;
		
		public Executor(@NonNull EvaluationContext evaluationContext, @NonNull QVTiEnvironmentFactory envFactory) {
			super(evaluationContext, envFactory);
		}

//		public Executor(@NonNull EvaluationContext evaluationContext) {
//			super(evaluationContext);
//		}

		@Override
		protected void handleExecutionTraces(Trace traces) {				
			super.handleExecutionTraces(traces);
			fTraces = traces;
		}

	}
		
	private final URI fTransformationURI;	
	private final Executor fExecutor;
//	private final List<URI> fModelParamURIs;
	private URI fTraceFileURI;
	
	private BasicDiagnostic fDiagnostic;
//	private List<ModelExtent> fModelParams;		
//	private ModelExtentHelper fExtentHelper;
	
	
	public TransformationRunner(@NonNull EvaluationContext evaluationContext, @NonNull QVTiEnvironmentFactory envFactory) {
		
//		if (transformationURI == null || modelParamURIs == null
//				|| modelParamURIs.contains(null)) {
//			throw new IllegalArgumentException();
//		}

		fExecutor = new Executor(evaluationContext, envFactory);
		fTransformationURI = evaluationContext.getTransformationURI();
//		fModelParamURIs = modelParamURIs;
	}
	
	protected InternalTransformationExecutor getExecutor() {
		return fExecutor;
	};
	
	public @NonNull MetaModelManager getMetaModelManager() {
		return fExecutor.getEvaluator().getMetaModelManager();
	}
	
	public URI getTransformationURI() {
		return fTransformationURI;
	}
	
	public void setTraceFile(URI traceFileURI) {
		fTraceFileURI = traceFileURI;
	}
	
	public URI getTraceFileURI() {
		return fTraceFileURI;
	}

	public Diagnostic initialize() {
		if(fDiagnostic != null) {
			return fDiagnostic;
		}
		
		fDiagnostic = QVTdDebugUIPlugin.createDiagnostic("Transformation runner initiliaze");
		
		Diagnostic loadDiagnostic = fExecutor.loadTransformation();
		if(!QVTdDebugUIPlugin.isSuccess(loadDiagnostic)) {
			fDiagnostic.add(loadDiagnostic);
		}

		handleLoadTransformation(loadDiagnostic);
		
		Transformation transformation = fExecutor.getTransformation();
		if (transformation == null) {
			return fDiagnostic;
		}
		
		// Note: initialized here already loaded transformation is required
//		fExtentHelper = new ModelExtentHelper(transformation, fModelParamURIs, fExecutor.getResourceSet());
		
//		Diagnostic extentsDiagnostic = Diagnostic.OK_INSTANCE; 
//		try {
//			fModelParams = fExtentHelper.loadExtents();
//		} catch (DiagnosticException e) {
//			extentsDiagnostic = e.getDiagnostic();
//		}
		
//		handleLoadExtents(extentsDiagnostic);
//		if(!QVTdDebugUIPlugin.isSuccess(extentsDiagnostic)) {
//			fDiagnostic.add(extentsDiagnostic);
//		}
		
		// FIXME - 
		// add validation for configuration properties and param count
		// into the internal executor

		// TODO - collect WARN, INFO diagnostics?
		return fDiagnostic;
	}
	
	protected @NonNull QVTiEnvironmentFactory getEnvFactory() {
		return fExecutor.getEnvFactory(); 
	}
	
	protected void handleLoadTransformation(Diagnostic diagnostic) {
		// do nothing
	}	
			
	protected void handleLoadExtents(Diagnostic diagnostic) {
		// do nothing
	}	

	protected void handleExecution(ExecutionDiagnostic execDiagnostic) {
		// do nothing
	}
	
	protected void handleSaveExtents(Diagnostic diagnostic) {
		// do nothing
	}		


	public Diagnostic execute(@NonNull EvaluationContext evaluationContext) {
		Diagnostic diagnostic = initialize();
		
		if(!isSuccess(diagnostic)) {
			return diagnostic;
		}

//		fExecutor.setEnvironmentFactory(getEnvFactory());
		try {			
//			ModelExtent[] params = fModelParams.toArray(new ModelExtent[fModelParams.size()]);
			ExecutionDiagnostic execDiagnostic = fExecutor.execute(evaluationContext); //, params);
			handleExecution(execDiagnostic);
			
			Trace traces = fExecutor.fTraces;
			fExecutor.fTraces = null;

			if(!isSuccess(execDiagnostic)) {
				// skip saving any output
				return execDiagnostic;
			}

			// can continue and save output
//			Diagnostic saveExtentsDiagnostic = fExtentHelper.saveExtents();
//			handleSaveExtents(saveExtentsDiagnostic);
			fExecutor.getEvaluator().saveModels();
			
//			if(!isSuccess(saveExtentsDiagnostic)) {
//				return saveExtentsDiagnostic;
//			}

//			Diagnostic saveTracesDiagnostic = saveTraces(traces);
//			if(!isSuccess(saveTracesDiagnostic)) {
//				return saveTracesDiagnostic;
//			}

			return execDiagnostic;
		} finally {
			fExecutor.cleanup();
		}			
	}
	
	private Diagnostic saveTraces(Trace trace) { 
		if(fTraceFileURI != null) {
			Resource resource = new ResourceSetImpl().createResource(fTraceFileURI);
			resource.getContents().add(trace);
			try {
		        Map<String, String> options = new HashMap<String, String>();
		        options.put(XMLResource.OPTION_PROCESS_DANGLING_HREF, XMLResource.OPTION_PROCESS_DANGLING_HREF_DISCARD);
				resource.save(options);
			} catch (IOException e) {
				String message = NLS.bind("Failed to save trace model uri={0}", fTraceFileURI);
				return new BasicDiagnostic(Diagnostic.ERROR, QVTdDebugUIPlugin.PLUGIN_ID, 0,
						message, new Object[] { e });
			}
		}
		
		return Diagnostic.OK_INSTANCE;
	}
	
	/**
	 * Successfully finished execution, no errors and user interruption 
	 */
	private static boolean isSuccess(Diagnostic diagnostic) {
		int severity = diagnostic.getSeverity();
		return severity != Diagnostic.ERROR && severity != Diagnostic.CANCEL;
	}
		
}