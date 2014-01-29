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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.sourcelookup.ISourceContainer;
import org.eclipse.debug.core.sourcelookup.ISourcePathComputer;
import org.eclipse.debug.core.sourcelookup.containers.ProjectSourceContainer;
import org.eclipse.debug.core.sourcelookup.containers.WorkspaceSourceContainer;
import org.eclipse.qvtd.debug.utils.WorkspaceUtils;

/**
 * @since 1.3
 */
public class QVTiSourcePathComputer implements ISourcePathComputer {
		
	public static final String ID = "org.eclipse.qvtd.debug.srclookup.QVTiSourcePathComputer";  //$NON-NLS-1$
	
	private static final String JAVA_SRC_COMPUTER_ID = "org.eclipse.jdt.launching.sourceLookup.javaSourcePathComputer"; //$NON-NLS-1$
	
	private final ISourcePathComputer fJavaSourcePathComputer;
	
	
	public QVTiSourcePathComputer() {
		fJavaSourcePathComputer = DebugPlugin.getDefault().getLaunchManager().getSourcePathComputer(JAVA_SRC_COMPUTER_ID);
	}
	
	public String getId() {
		return ID;
	}
	
	public ISourceContainer[] computeSourceContainers(ILaunchConfiguration configuration, IProgressMonitor monitor) throws CoreException {
		IFile moduleFile = WorkspaceUtils.getModuleFile(configuration);
		
		ISourceContainer sourceContainer;
		if (moduleFile != null && moduleFile.exists()) {
			sourceContainer = new ProjectSourceContainer(moduleFile.getProject(), false);
		}
		else {
			sourceContainer = new WorkspaceSourceContainer();
		}
		
	    List<ISourceContainer> result = new ArrayList<ISourceContainer>();
		result.add(sourceContainer);		
		result.addAll(Arrays.asList(fJavaSourcePathComputer
				.computeSourceContainers(configuration, monitor)));
		
		return result.toArray(new ISourceContainer[result.size()]);
	}
}
