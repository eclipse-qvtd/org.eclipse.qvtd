package org.eclipse.qvtd.debug.launching;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.qvtd.debug.QVTdDebugPlugin;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.EvaluationMonitor;

public class ZZQvtLaunchConfigurationDelegate extends QvtLaunchConfigurationDelegateBase {

    public static final String LAUNCH_CONFIGURATION_TYPE_ID = "org.eclipse.m2m.qvt.oml.QvtTransformation"; //$NON-NLS-1$

    private static final int LAUNCH_ERROR_CODE = 210;
    private static final IStatus fgLaunchErrorStatus = new Status(IStatus.ERROR, QVTdDebugPlugin.PLUGIN_ID, LAUNCH_ERROR_CODE, "Launch configuration error", null); //$NON-NLS-1$	
	
	public ZZQvtLaunchConfigurationDelegate() {
	}
	
	// FIXME - do refactoring of this area 
	public void launch(final ILaunchConfiguration configuration, String mode, final ILaunch launch, IProgressMonitor monitor) throws CoreException {
        
/*		try {
            final QvtTransformation qvtTransformation = new QvtInterpretedTransformation(getQvtModule(configuration));
            final EvaluationMonitor execMonitor = createMonitor();
                                    
            final StreamsProxy streamsProxy = new StreamsProxy();
   
            ShallowProcess.IRunnable r = new ShallowProcess.IRunnable() {
                
                public void run() throws Exception { 
                    IStatus status = QvtLaunchConfigurationDelegateBase.validate(qvtTransformation, configuration);                    
                    if(status.getSeverity() > IStatus.WARNING) {
                    	throw new CoreException(status);
                    }      	
                	
                	Context context = QvtLaunchUtil.createContext(configuration);
                    context.setLog(new WriterLog(streamsProxy.getOutputWriter()));
                    context.setMonitor(execMonitor);
                    
                	QvtLaunchConfigurationDelegateBase.doLaunch(qvtTransformation, configuration, context);
                	
                	qvtTransformation.cleanup();
                }
            };
            
            
            r = getSafeRunnable(qvtTransformation, r);       
            final ShallowProcess process = new ShallowProcess(launch, r) {
            	boolean isTerminated = false;
            	@Override
            	public void terminate() throws DebugException {            		
            		execMonitor.cancel();
            		isTerminated = true;	            		
            		super.terminate();            		
            	}

            	@Override
            	public boolean isTerminated() {            	
            		return isTerminated || super.isTerminated();
            	}
            	
            	@Override
            	public boolean canTerminate() {
            		return !isTerminated();
            	}
            };
            
            process.setStreamsProxy(streamsProxy);
            
            Thread processThread = new Thread(new Runnable() {
            	public void run() {
                    try {
						process.run();
					} catch (Exception e) {
						if(e instanceof QvtRuntimeException == false) {
							// QVT runtime exception are legal QVT transformation level errors
							
							IStatusHandler statusHandler = DebugPlugin.getDefault().getStatusHandler(fgLaunchErrorStatus);
							if(statusHandler != null) {
								IStatus actualStatus = new Status(IStatus.ERROR, QVTdDebugPlugin.PLUGIN_ID, LAUNCH_ERROR_CODE, 
														e.getMessage(), e.getMessage() == null ? e : null);
								try {
									statusHandler.handleStatus(actualStatus, configuration);
								} catch (CoreException coreExc) {
									QVTdDebugPlugin.getDefault().log(coreExc.getStatus());
								}
							}						
							
							QVTdDebugPlugin.error(e);							
						}
					}
					
					try {
						launch.terminate();
					} catch (DebugException e) {
						QVTdDebugPlugin.getDefault().log(e.getStatus());
					}
            	}
            }, "QVT Run"); //$NON-NLS-1$
            
            processThread.start();
		}
		catch(Exception e) {
			throw new CoreException(MiscUtil.makeErrorStatus(e));
		} */
	}

	private EvaluationMonitor createMonitor() {
		return new EvaluationMonitor() {
			boolean fIsCanceled = false;
			
			public void cancel() {
				fIsCanceled = true;
			}
			
			public boolean isCanceled() {
				return fIsCanceled;
			}
		};
	}
    
  
// FIXME - do we need such an annoying generic check ?
// Useless anyway without overriding 
//	org.eclipse.debug.core.model.LaunchConfigurationDelegate.getProjectsForProblemSearch(ILaunchConfiguration, String)	
//    @Override
//	protected boolean existsProblems(IProject proj) throws CoreException {
//        IMarker[] markers = proj.findMarkers(QVTOProjectPlugin.PROBLEM_MARKER, true, IResource.DEPTH_INFINITE);
//        for (int i = 0; i < markers.length; i++) {
//            if (isLaunchProblem(markers[i])) {
//                return true;
//            }
//        }
//
//        return false;
//    }

}
