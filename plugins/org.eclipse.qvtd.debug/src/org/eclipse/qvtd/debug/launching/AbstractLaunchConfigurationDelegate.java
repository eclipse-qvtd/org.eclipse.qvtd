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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.model.LaunchConfigurationDelegate;
import org.eclipse.qvtd.debug.QVTdDebugPlugin;
import org.eclipse.qvtd.debug.utils.BaseProcess;
import org.eclipse.qvtd.debug.utils.SafeRunner;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.EvaluationMonitor;

public abstract class AbstractLaunchConfigurationDelegate extends LaunchConfigurationDelegate implements LaunchConstants
{ 
    public static BaseProcess.IRunnable getSafeRunnable(Object /*QvtTransformation*/ transformation, BaseProcess.IRunnable r) throws CoreException {
        return SafeRunner.getSafeRunnable(r);
    }
    
    protected static final int LAUNCH_ERROR_CODE = 210;
    protected static final IStatus fgLaunchErrorStatus = new Status(IStatus.ERROR, QVTdDebugPlugin.PLUGIN_ID, LAUNCH_ERROR_CODE, "Launch configuration error", null); //$NON-NLS-1$	

	protected EvaluationMonitor createMonitor() {
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
}

