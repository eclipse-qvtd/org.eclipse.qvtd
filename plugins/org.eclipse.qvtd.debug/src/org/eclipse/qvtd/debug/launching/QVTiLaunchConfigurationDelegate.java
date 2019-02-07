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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.debug.vm.utils.MiscUtil;
import org.eclipse.ocl.examples.debug.vm.utils.SafeRunner;
import org.eclipse.ocl.examples.debug.vm.utils.ShallowProcess;
import org.eclipse.ocl.examples.debug.vm.utils.StreamsProxy;
import org.eclipse.ocl.examples.debug.vm.utils.VMRuntimeException;
import org.eclipse.ocl.pivot.resource.BasicProjectManager;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.compiler.CompilerChain;
import org.eclipse.qvtd.compiler.DefaultCompilerOptions;
import org.eclipse.qvtd.debug.QVTiDebugPlugin;
import org.eclipse.qvtd.debug.core.QVTiDebugCore;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiExecutor;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiIncrementalExecutor;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;

public class QVTiLaunchConfigurationDelegate extends LaunchConfigurationDelegate implements QVTiLaunchConstants
{
	public static final @NonNull String @NonNull [] compileStepKeys = new @NonNull String[] {
		CompilerChain.QVTI_STEP
	};

	public static final @NonNull String @NonNull [] generateStepKeys = new @NonNull String[] {
		CompilerChain.JAVA_STEP,
		CompilerChain.CLASS_STEP
	};

	protected static final int LAUNCH_ERROR_CODE = 210;
	protected static final IStatus fgLaunchErrorStatus = new Status(IStatus.ERROR, QVTiDebugPlugin.PLUGIN_ID, LAUNCH_ERROR_CODE, "Launch configuration error", null); //$NON-NLS-1$

	protected @NonNull DefaultCompilerOptions createCompilerOptions() {
		return new DefaultCompilerOptions();
	}

	protected @NonNull QVTiExecutor createExecutor(@NonNull QVTiEnvironmentFactory envFactory, @NonNull ImperativeTransformation transformation) {
		return new QVTiIncrementalExecutor(envFactory, transformation, QVTiIncrementalExecutor.Mode.LAZY);
	}

	protected @NonNull QVTiDebugCore getDebugCore() {
		return QVTiDebugCore.INSTANCE;
	}

	protected @NonNull URI getTransformationURI(final ILaunchConfiguration configuration) throws CoreException {
		String txName = configuration.getAttribute(TX_KEY, "");		// FIXME Change to intermediate - same as QVTc/QVTr
		return URI.createURI(txName, true);
	}

	// FIXME - do refactoring of this area
	@Override
	public void launch(final ILaunchConfiguration configuration, String mode, final ILaunch launch, IProgressMonitor monitor) throws CoreException {

		try {
			@SuppressWarnings("unused") boolean interpreted = configuration.getAttribute(INTERPRETED_KEY, false);
			final boolean traceEvaluation = configuration.getAttribute(TRACE_EVALUATION_KEY, false);
			final Map<String, String> inMap = configuration.getAttribute(NEW_IN_KEY, EMPTY_MAP);
			final Map<String, String> outMap = configuration.getAttribute(NEW_OUT_KEY, EMPTY_MAP);
			final URI txURI = getTransformationURI(configuration);
			final Monitor execMonitor = new BasicMonitor();

			final StreamsProxy streamsProxy = new StreamsProxy();

			ShallowProcess.IRunnable r = new ShallowProcess.IRunnable() {

				@Override
				public void run() throws Exception {
					QVTiEnvironmentFactory environmentFactory = new QVTiEnvironmentFactory(BasicProjectManager.CLASS_PATH, null);
					if (traceEvaluation) {
						environmentFactory.setEvaluationTracingEnabled(true);
					}
					ImperativeTransformation transformation = QVTimperativeUtil.loadTransformation(environmentFactory, txURI, environmentFactory.keepDebug());
					QVTiExecutor executor = createExecutor(environmentFactory, transformation);
					for (@NonNull TypedModel typedModel : ClassUtil.nullFree(transformation.getModelParameter())) {
						for (org.eclipse.ocl.pivot.@NonNull Package asPackage : ClassUtil.nullFree(typedModel.getUsedPackage())) {
							EObject esObject = asPackage.getESObject();
							if (esObject instanceof EPackage) {
								String nsURI = ((EPackage)esObject).getNsURI();
								if (nsURI != null) {
									environmentFactory.getResourceSet().getPackageRegistry().put(nsURI, esObject);
								}
							}
						}
					}
					for (String inName : inMap.keySet()) {
						if (inName != null) {
							URI inURI = URI.createURI(inMap.get(inName), true);
							executor.loadModel(inName, inURI, null);
						}
					}
					for (String outName : outMap.keySet()) {
						if (outName != null) { //&& !QVTbaseUtil.TRACE_TYPED_MODEL_NAME.equals(outName)) {
							URI outURI = URI.createURI(outMap.get(outName), true);
							executor.createModel(outName, outURI, null);
						}
					}
					executor.execute();
					executor.saveModels();
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
				@Override
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
									getDebugCore().log(coreExc.getStatus());
								}
							}

							getDebugCore().error("Execution of launch '" + configuration.getName() + "' failed", e);
						}
					}

					try {
						launch.terminate();
					} catch (DebugException e) {
						getDebugCore().log(e.getStatus());
					}
				}
			}, "QVTi Run"); //$NON-NLS-1$

			processThread.start();
		}
		catch(Exception e) {
			throw new CoreException(MiscUtil.makeErrorStatus(e));
		}
	}
}

