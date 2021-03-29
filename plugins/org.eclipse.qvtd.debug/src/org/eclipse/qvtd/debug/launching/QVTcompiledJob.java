/*******************************************************************************
 * Copyright (c) 2019, 2021 Willink Transformations and others.
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
import java.io.PrintWriter;
import java.io.StringWriter;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.resource.BasicProjectManager;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.ThreadLocalExecutor;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiTransformationExecutor;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeEnvironmentStrategy;
import org.eclipse.qvtd.runtime.evaluation.ModelsManager;
import org.eclipse.qvtd.runtime.evaluation.Transformer;
import org.eclipse.qvtd.runtime.evaluation.TypedModelInstance;
import org.eclipse.ui.statushandlers.StatusManager;

/**
 * The QVTimperativeJob provides a Job that interprets a QVTd transformation.
 */
public class QVTcompiledJob extends QVTimperativeJob
{
	protected final @NonNull Class<? extends Transformer> txClass;

	protected QVTcompiledJob(@NonNull QVTiLaunchConfigurationDelegate launchConfigurationDelegate,
			@NonNull ILaunch launch, @NonNull ILaunchConfiguration configuration, @NonNull Class<? extends Transformer> txClass) throws CoreException {
		super("QVTi Compiled Job", launchConfigurationDelegate, launch, configuration);
		this.txClass = txClass;
	}

	@Override
	public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {
		int LOAD_TX_TICKS = 5;
		int USED_PACKAGES_TICKS = inMap.size();
		int CHECKING_TICKS = outMap.size();
		int EXECUTING_TICKS = 50;
		int SAVING_TICKS = outMap.size();
		int allTicks = LOAD_TX_TICKS + USED_PACKAGES_TICKS + CHECKING_TICKS + EXECUTING_TICKS + SAVING_TICKS + inMap.size() + 2 * outMap.size();
		SubMonitor subMonitor = SubMonitor.convert(monitor, allTicks);
		ThreadLocalExecutor.reset();
		try {
			QVTimperativeEnvironmentFactory environmentFactory = new QVTimperativeEnvironmentFactory(BasicProjectManager.CLASS_PATH, null, QVTimperativeEnvironmentStrategy.INSTANCE);
			if (traceEvaluation) {
				environmentFactory.setEvaluationTracingEnabled(true);
			}
			subMonitor.split(LOAD_TX_TICKS, SubMonitor.SUPPRESS_NONE).beginTask("Loading '" + txURI + "'", LOAD_TX_TICKS);
			//	ImperativeTransformation transformation = QVTimperativeUtil.loadTransformation(environmentFactory, txURI, environmentFactory.keepDebug());
			//	if (monitor.isCanceled()) {
			//		throw new OperationCanceledException();
			//	}
			subMonitor.split(USED_PACKAGES_TICKS, SubMonitor.SUPPRESS_NONE).beginTask("Loading used packages for '" + txURI + "'", USED_PACKAGES_TICKS);

			//		QVTiExecutor executor2 = new QVTiTransformationExecutor(getEnvironmentFactory(), txClass);

			QVTiTransformationExecutor generatedExecutor = new QVTiTransformationExecutor(environmentFactory, txClass);
			/*	QVTiExecutor executor = launchConfigurationDelegate.createExecutor(environmentFactory, transformation);
			for (@NonNull TypedModel typedModel : ClassUtil.nullFree(transformation.getModelParameter())) {
				if (monitor.isCanceled()) {
					throw new OperationCanceledException();
				}
				for (org.eclipse.ocl.pivot.@NonNull Package asPackage : ClassUtil.nullFree(typedModel.getUsedPackage())) {
					EObject esObject = asPackage.getESObject();
					if (esObject instanceof EPackage) {
						String nsURI = ((EPackage)esObject).getNsURI();
						if (nsURI != null) {
							environmentFactory.getResourceSet().getPackageRegistry().put(nsURI, esObject);
						}
					}
				}
			} */
			ResourceSet resourceSet = environmentFactory.getResourceSet();		// FIXME get package registrations in external RespurcSet
			PivotUtil.initializeLoadOptionsToSupportSelfReferences(resourceSet);
			Transformer transformer = generatedExecutor.getTransformer();
			ModelsManager modelsManager = transformer.getModelsManager();
			for (String inName : inMap.keySet()) {
				if (monitor.isCanceled()) {
					throw new OperationCanceledException();
				}
				if (inName != null) {
					URI inURI = URI.createURI(inMap.get(inName), true);
					subMonitor.split(1, SubMonitor.SUPPRESS_NONE).beginTask("Loading '" + inURI + "'", 1);
					Resource inputResource = ClassUtil.nonNullState(resourceSet.getResource(inURI, true));
					TypedModelInstance typedModelInstance = modelsManager.getTypedModelInstance(inName);
					typedModelInstance.addInputResource(inputResource);
				}
			}
			if (monitor.isCanceled()) {
				throw new OperationCanceledException();
			}
			//	subMonitor.split(CHECKING_TICKS, SubMonitor.SUPPRESS_NONE).beginTask("Checking loaded models for '" + txURI + "'", CHECKING_TICKS);
			//	executor.checkModels();
			//	if (monitor.isCanceled()) {
			//		throw new OperationCanceledException();
			//	}
			subMonitor.split(EXECUTING_TICKS, SubMonitor.SUPPRESS_NONE).beginTask("Executing '" + txURI + "'", EXECUTING_TICKS);
			//	if (!generatedExecutor.preExecute()) {
			//
			//	}
			if (!generatedExecutor.execute(null)) {		// FIXME TypedModel index
				//	if (!suppressFailureDiagnosis) {						// FIXME BUG 511028
				StringBuilder s = new StringBuilder();
				transformer.getInvocationManager().diagnoseWorkLists(s);
				throw new Exception("Failed to execute" + s.toString());
				//	}
			}
			if (monitor.isCanceled()) {
				throw new OperationCanceledException();
			}
			subMonitor.split(SAVING_TICKS, SubMonitor.SUPPRESS_NONE).beginTask("Saving output models for '" + txURI + "'", SAVING_TICKS);
			for (String outName : outMap.keySet()) {
				if (monitor.isCanceled()) {
					throw new OperationCanceledException();
				}
				if (outName != null) { //&& !QVTbaseUtil.TRACE_TYPED_MODEL_NAME.equals(outName)) {
					URI outURI = URI.createURI(outMap.get(outName), true);
					subMonitor.split(1, SubMonitor.SUPPRESS_NONE).beginTask("Creating '" + outURI + "'", 1);
					Resource outputResource = ClassUtil.nonNullState(resourceSet.createResource(outURI));
					TypedModelInstance typedModelInstance = modelsManager.getTypedModelInstance(outName);
					typedModelInstance.addOutputResource(outputResource);
				}
			}
			//	for (Resource outputResource : outputResources) {
			if (monitor.isCanceled()) {
				throw new OperationCanceledException();
			}
			subMonitor.split(1, SubMonitor.SUPPRESS_NONE).beginTask("Saving", 1);
			modelsManager.saveModels(null);
			//		outputResource.save(DefaultCompilerOptions.defaultSavingOptions);
			//	}
			return new Status(IStatus.OK, getPluginId(), null);
		}
		catch (OperationCanceledException oce) {
			try {
				streamsProxy.getErrWriter().write("Cancelled");
			} catch (IOException e) {
				noThrow(e);
			}
			throw oce;
		}
		catch (Throwable t) {
			if (t instanceof WrappedException) {
				t = t.getCause();
			}
			StringWriter sw = new StringWriter();
			sw.append("Failed to execute '" + txURI + "'\n");
			t.printStackTrace(new PrintWriter(sw));
			String consoleMessage = sw.toString().replaceAll("\\r\\n", "\n");
			try {
				streamsProxy.getErrWriter().write(consoleMessage);
			} catch (IOException e) {
				noThrow(e);
			}
			String popUpMessage = "Failed to execute '" + txURI + "' - see console for more details.";
			Status status = new Status(IStatus.ERROR, getPluginId(), popUpMessage, t);
			StatusManager.getManager().handle(status, StatusManager.SHOW);	// Provide the standard problem occurred pop-up
			String logMessage = popUpMessage;
			return new Status(IStatus.INFO, getPluginId(), logMessage, t);		//  but do not clutter the error log or report via AERI
		}
		finally {
			monitor.done();
			ThreadLocalExecutor.reset();
		}
	}
}