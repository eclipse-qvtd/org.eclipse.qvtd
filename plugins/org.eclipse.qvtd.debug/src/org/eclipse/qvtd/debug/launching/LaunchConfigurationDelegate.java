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
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.emf.common.util.URI;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.qvtd.debug.QVTdDebugPlugin;
import org.eclipse.qvtd.xtext.qvtimperative.utilities.QVTiXtextEvaluator;

public class LaunchConfigurationDelegate extends org.eclipse.debug.core.model.LaunchConfigurationDelegate implements LaunchConstants
{
	@Override
	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor monitor) throws CoreException {
		String txName = configuration.getAttribute(TX_KEY, "");
		Map<String, String> inMap = configuration.getAttribute(IN_KEY, EMPTY_MAP);
		Map<String, String> outMap = configuration.getAttribute(OUT_KEY, EMPTY_MAP);
		MetaModelManager metaModelManager = new MetaModelManager();
		URI txURI = URI.createURI(txName, true);
		try {
			QVTiXtextEvaluator xtextEvaluator = new QVTiXtextEvaluator(metaModelManager, txURI);
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
		}
		catch (Exception e) {
			throw new CoreException(new Status(IStatus.ERROR, QVTdDebugPlugin.PLUGIN_ID, "Failed to launch '" + txURI + "'", e));
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

