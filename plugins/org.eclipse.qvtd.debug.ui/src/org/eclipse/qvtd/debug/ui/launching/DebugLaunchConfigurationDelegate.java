package org.eclipse.qvtd.debug.ui.launching;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.IDebugEventSetListener;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.ITerminate;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.debug.core.EvaluationContext;
import org.eclipse.qvtd.debug.core.QVTODebugTarget;
import org.eclipse.qvtd.debug.core.QVTOVirtualProcess;
import org.eclipse.qvtd.debug.launching.AbstractLaunchConfigurationDelegate;
import org.eclipse.qvtd.debug.stubs.QVTODebugUtil;
import org.eclipse.qvtd.debug.utils.QVTODebugCore;
import org.eclipse.qvtd.debug.utils.StreamsProxy;
import org.eclipse.qvtd.debug.utils.WriterLog;
import org.eclipse.qvtd.debug.vm.DebuggableExecutorAdapter;
import org.eclipse.qvtd.debug.vm.IQVTOVirtualMachineShell;
import org.eclipse.qvtd.debug.vm.QVTOVirtualMachine;

public class DebugLaunchConfigurationDelegate extends AbstractLaunchConfigurationDelegate
{
	public static final IStatus MODIFIED_SOURCE_STATUS = QVTODebugCore.createError("", 300, null); //$NON-NLS-1$
	
	@Override
	public void launch(ILaunchConfiguration configuration, String mode,
			ILaunch launch, IProgressMonitor monitor) throws CoreException {
		
		EvaluationContext evaluationContext = createEvaluationContext(configuration);
		StreamsProxy streamsProxy = new StreamsProxy();
		evaluationContext.setLog(new WriterLog(streamsProxy.getOutputWriter(), true));
			
		DebugTransformationRunner runner = createRunner(evaluationContext);
		runner.setErrorLog(new PrintWriter(streamsProxy.getErrWriter(), true));
		
		Diagnostic initDiagnostic = runner.initialize();
		if (initDiagnostic.getSeverity() == Diagnostic.ERROR) {
			throw new CoreException(BasicDiagnostic.toIStatus(initDiagnostic));			
		}
		
		DebuggableExecutorAdapter executable = runner.createDebugableAdapter(evaluationContext);
		IQVTOVirtualMachineShell vm = new QVTOVirtualMachine(runner.getMetaModelManager(), executable);
		
		QVTOVirtualProcess process = new QVTOVirtualProcess(launch, vm);
		process.setStreamsProxy(streamsProxy);
		
		List<IFile> transformationWsFile = QVTODebugUtil.toFiles(runner.getTransformationURI());
		if (!transformationWsFile.isEmpty()) {			
			addSourceModificationListener(transformationWsFile.get(0), process);
		}
		
		QVTODebugTarget debugTarget = new QVTODebugTarget(process, vm);		
		launch.addDebugTarget(debugTarget);
	}
	
	private EvaluationContext createEvaluationContext(ILaunchConfiguration configuration) throws CoreException {
		EvaluationContext evaluationContext = new EvaluationContext();
		String txName = configuration.getAttribute(TX_KEY, "");
		@SuppressWarnings("null")@NonNull URI txURI = URI.createURI(txName, true);
		evaluationContext.setTransformationURI(txURI);
		final Map<String, String> inMap = configuration.getAttribute(IN_KEY, EMPTY_MAP);
		for (Map.Entry<String, String> inEntry : inMap.entrySet()) {
			@SuppressWarnings("null")@NonNull String inKey = inEntry.getKey();
			@SuppressWarnings("null")@NonNull URI inURI = URI.createURI(inEntry.getValue(), true);
			evaluationContext.addInputURI(inKey, inURI);
		}
		final Map<String, String> outMap = configuration.getAttribute(OUT_KEY, EMPTY_MAP);
		for (Map.Entry<String, String> outEntry : outMap.entrySet()) {
			@SuppressWarnings("null")@NonNull String outKey = outEntry.getKey();
			@SuppressWarnings("null")@NonNull URI outURI = URI.createURI(outEntry.getValue(), true);
			evaluationContext.addOutputURI(outKey, outURI);
		}
		return evaluationContext;
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
	
	
	private DebugTransformationRunner createRunner(@NonNull EvaluationContext evaluationContext) throws CoreException {
		DebugRunnerFactory runnerFactory = new DebugRunnerFactory();

		URI transformationURI = evaluationContext.getTransformationURI();
		String uri = transformationURI != null ? transformationURI.toString() : null;
		runnerFactory.transformationURI = uri;
		runnerFactory.packageRegistry = createPackageRegistry(uri);
		
//		List<String> modelURIs = new ArrayList<String>();
//		for (TargetUriData uriData : QvtLaunchUtil.getTargetUris(configuration)) {
//			modelURIs.add(uriData.getUriString());
//		}
		
//		runnerFactory.modelParamURI = modelURIs;

		URI traceFileURI = evaluationContext.getTraceFileURI();
		String traceFile = traceFileURI != null ? traceFileURI.toString() : null;
		boolean shouldGenerateTraceFile = false; //QvtLaunchUtil.shouldGenerateTraceFile(configuration);
		if (traceFile != null && traceFile.trim().length() != 0 && shouldGenerateTraceFile) {
			runnerFactory.traceFileURI = traceFile;
		}
		
		try {
			return runnerFactory.createRunner(evaluationContext);
		} catch(DiagnosticException e) {
			throw new CoreException(BasicDiagnostic.toIStatus(e.getDiagnostic()));
		}
	}
	
	/*
	 * TODO - handle multiple files involved in the transformation
	 */
	private void addSourceModificationListener(final IFile unitFile, final ITerminate terminate) {
		final SourceModificationListener listener = new SourceModificationListener(unitFile, terminate);

		unitFile.getProject().getWorkspace().addResourceChangeListener(listener, IResourceChangeEvent.POST_CHANGE);

		DebugPlugin.getDefault().addDebugEventListener(
				new IDebugEventSetListener() {
					public void handleDebugEvents(DebugEvent[] events) {
						for (int i = 0; i < events.length; i++) {
							DebugEvent event = events[i];

							if (event.getKind() == DebugEvent.TERMINATE && event.getSource().equals(terminate)) {
								// unregister myself
								DebugPlugin.getDefault().removeDebugEventListener(this);
								// unregister workspace listener
								unitFile.getProject().getWorkspace().removeResourceChangeListener(listener);								
							}
						}
					}
				});
	
	}

	private EPackage.Registry createPackageRegistry(String transformationURIStr) {
		URI transformationURI = URI.createURI(transformationURIStr);
		try {		
			if(transformationURI.isPlatformResource()) {
				IFile file = QVTODebugUtil.toFile(transformationURI);
//				if(file != null && file.exists()) {	
//					return MetamodelURIMappingHelper.mappingsToEPackageRegistry(file.getProject(), new ResourceSetImpl());
//				}
			}
		} catch(Exception e) {
			// FIXME
			QVTODebugCore.log(e);
		}		

		return new EPackageRegistryImpl(EPackage.Registry.INSTANCE);
	}
}