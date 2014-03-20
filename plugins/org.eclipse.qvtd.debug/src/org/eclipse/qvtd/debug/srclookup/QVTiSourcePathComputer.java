/*******************************************************************************
 * Copyright (c) 2009, 2013 R.Dvorak and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Radek Dvorak - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.debug.srclookup;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.debug.srclookup.VMSourcePathComputer;
import org.eclipse.qvtd.debug.launching.QVTiLaunchConstants;

public class QVTiSourcePathComputer extends VMSourcePathComputer {
		
	public static final @NonNull String ID = "org.eclipse.qvtd.debug.srclookup.QVTiSourcePathComputer";  //$NON-NLS-1$
	
	public @NonNull String getId() {
		return ID;
	}

	protected IFile getModuleFile(@NonNull ILaunchConfiguration configuration) throws CoreException {
//        String moduleFileName = configuration.getAttribute(LaunchConstants.MODULE, ""); //$NON-NLS-1$
        String moduleFileName = configuration.getAttribute(QVTiLaunchConstants.TX_KEY, ""); //$NON-NLS-1$
        URI moduleUri = URI.createURI(moduleFileName);
        IFile moduleFile = getWorkspaceFile(moduleUri);
        if(moduleFile == null) {
        	//IStatus errorStatus = MiscUtil.makeErrorStatus( 
        		//	NLS.bind(Messages.QvtLaunchConfigurationDelegate_transformationFileNotFound, moduleFileName));
        	//throw new CoreException(errorStatus);
        }
        
        return moduleFile;
    }
}
