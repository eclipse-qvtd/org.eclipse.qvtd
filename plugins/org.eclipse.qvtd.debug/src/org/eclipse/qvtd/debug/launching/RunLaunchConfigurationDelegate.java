/**
 * <copyright>
 *
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.debug.launching;

import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.IStatusHandler;
import org.eclipse.debug.core.model.LaunchConfigurationDelegate;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.ocl.examples.debug.evaluator.VMRuntimeException;
import org.eclipse.ocl.examples.debug.utils.MiscUtil;
import org.eclipse.ocl.examples.debug.utils.SafeRunner;
import org.eclipse.ocl.examples.debug.utils.ShallowProcess;
import org.eclipse.ocl.examples.debug.utils.StreamsProxy;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.qvtd.debug.QVTiDebugPlugin;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.xtext.qvtimperative.utilities.QVTiXtextEvaluator;

public class RunLaunchConfigurationDelegate extends LaunchConfigurationDelegate implements QVTiLaunchConstants
{ 
    protected static final int LAUNCH_ERROR_CODE = 210;
    protected static final IStatus fgLaunchErrorStatus = new Status(IStatus.ERROR, QVTiDebugPlugin.PLUGIN_ID, LAUNCH_ERROR_CODE, "Launch configuration error", null); //$NON-NLS-1$	
	
	// FIXME - do refactoring of this area 
	public void launch(final ILaunchConfiguration configuration, String mode, final ILaunch launch, IProgressMonitor monitor) throws CoreException {
        
		try {
			String txName = configuration.getAttribute(TX_KEY, "");
			final Map<String, String> inMap = configuration.getAttribute(IN_KEY, EMPTY_MAP);
			final Map<String, String> outMap = configuration.getAttribute(OUT_KEY, EMPTY_MAP);
			final URI txURI = URI.createURI(txName, true);
//            final QvtTransformation qvtTransformation = new QvtInterpretedTransformation(getQvtModule(configuration));
            final Monitor execMonitor = new BasicMonitor();
                                    
            final StreamsProxy streamsProxy = new StreamsProxy();
   
            ShallowProcess.IRunnable r = new ShallowProcess.IRunnable() {
                
                public void run() throws Exception { 
        			MetaModelManager metaModelManager = new MetaModelManager();
        			QVTiEnvironmentFactory envFactory = new QVTiEnvironmentFactory(null, metaModelManager);
        			QVTiXtextEvaluator xtextEvaluator = new QVTiXtextEvaluator(envFactory, txURI);
        			for (String inName : inMap.keySet()) {
        				URI inURI = URI.createURI(inMap.get(inName), true);
        				xtextEvaluator.loadModel(inName, inURI, null);
        			}
        			for (String outName : outMap.keySet()) {
        				URI outURI = URI.createURI(outMap.get(outName), true);
        				xtextEvaluator.createModel(outName, outURI, null);
        			}
        			xtextEvaluator.execute();
        			xtextEvaluator.saveModels();
//                    IStatus status = QvtLaunchConfigurationDelegateBase.validate(qvtTransformation, configuration);                    
//                    if(status.getSeverity() > IStatus.WARNING) {
//                    	throw new CoreException(status);
//                    }      	
                	
//                	Context context = QvtLaunchUtil.createContext(configuration);
//                    context.setLog(new WriterLog(streamsProxy.getOutputWriter()));
//                    context.setMonitor(execMonitor);
                    
//                	QvtLaunchConfigurationDelegateBase.doLaunch(qvtTransformation, configuration, context);
                	
//                	qvtTransformation.cleanup();
                }
            };
            
            
            r = SafeRunner.getSafeRunnable(r);       
            final ShallowProcess process = new ShallowProcess(launch, r) {
            	boolean isTerminated = false;
            	@Override
            	public void terminate() throws DebugException {            		
            		execMonitor.setCanceled(true);
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
						if(e instanceof VMRuntimeException == false) {
							// QVT runtime exception are legal QVT transformation level errors
							
							IStatusHandler statusHandler = DebugPlugin.getDefault().getStatusHandler(fgLaunchErrorStatus);
							if(statusHandler != null) {
								IStatus actualStatus = new Status(IStatus.ERROR, QVTiDebugPlugin.PLUGIN_ID, LAUNCH_ERROR_CODE, 
														e.getMessage(), e.getMessage() == null ? e : null);
								try {
									statusHandler.handleStatus(actualStatus, configuration);
								} catch (CoreException coreExc) {
									QVTiDebugPlugin.getDefault().log(coreExc.getStatus());
								}
							}						
							
							QVTiDebugPlugin.error(e);							
						}
					}
					
					try {
						launch.terminate();
					} catch (DebugException e) {
						QVTiDebugPlugin.getDefault().log(e.getStatus());
					}
            	}
            }, "QVTi Run"); //$NON-NLS-1$
            
            processThread.start();
		}
		catch(Exception e) {
			throw new CoreException(MiscUtil.makeErrorStatus(e));
		}
	}
	
/*	@Override
	public IEolExecutableModule createModule() {
		return new EvlModule();
	}
	
	@Override
	protected EolDebugger createDebugger() {
		return new EvlDebugger();
	}
	
	@Override
	protected void preExecute(IEolExecutableModule module) throws CoreException, EolRuntimeException {
		super.preExecute(module);
//		((EvlModule)module).setUnsatisfiedConstraintFixer(new ValidationViewFixer());
	} */
}

