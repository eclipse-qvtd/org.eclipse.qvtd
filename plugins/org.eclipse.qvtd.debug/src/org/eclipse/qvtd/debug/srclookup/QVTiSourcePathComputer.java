/*******************************************************************************
 * Copyright (c) 2014 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     R.Dvorak and others - QVTo debugger framework
 *     E.D.Willink - revised API for OCL/QVTi debugger framework
 *******************************************************************************/
package org.eclipse.qvtd.debug.srclookup;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.debug.vm.srclookup.VMSourcePathComputer;
import org.eclipse.qvtd.debug.launching.QVTiLaunchConstants;

public class QVTiSourcePathComputer extends VMSourcePathComputer {
		
	public static final @NonNull String ID = "org.eclipse.qvtd.debug.srclookup.QVTiSourcePathComputer";  //$NON-NLS-1$
	
	public @NonNull String getId() {
		return ID;
	}

	protected URI getModuleFile(@NonNull ILaunchConfiguration configuration) throws CoreException {
//        String moduleFileName = configuration.getAttribute(LaunchConstants.MODULE, ""); //$NON-NLS-1$
        String moduleFileName = configuration.getAttribute(QVTiLaunchConstants.TX_KEY, ""); //$NON-NLS-1$
        URI moduleUri = URI.createURI(moduleFileName);
        return moduleUri;
//        IFile moduleFile = getWorkspaceFile(moduleUri);
//        if(moduleFile == null) {
        	//IStatus errorStatus = MiscUtil.makeErrorStatus( 
        		//	NLS.bind(Messages.QvtLaunchConfigurationDelegate_transformationFileNotFound, moduleFileName));
        	//throw new CoreException(errorStatus);
//        }
        
//        return moduleFile;
    }
}
