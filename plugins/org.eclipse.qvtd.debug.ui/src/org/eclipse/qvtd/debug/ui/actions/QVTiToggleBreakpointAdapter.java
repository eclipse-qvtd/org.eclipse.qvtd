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
package org.eclipse.qvtd.debug.ui.actions;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.model.ILineBreakpoint;
import org.eclipse.debug.ui.actions.IToggleBreakpointsTarget;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ocl.examples.debug.core.VMLineBreakpoint;
import org.eclipse.qvtd.debug.core.QVTiDebugCore;
import org.eclipse.qvtd.debug.core.QVTiLineBreakpoint;
import org.eclipse.qvtd.debug.ui.QVTdDebugUIPlugin;
import org.eclipse.qvtd.debug.ui.messages.DebugUIMessages;
import org.eclipse.qvtd.xtext.qvtimperative.ui.QVTimperativeEditor;
import org.eclipse.ui.IWorkbenchPart;

public class QVTiToggleBreakpointAdapter implements IToggleBreakpointsTarget {
	
	public QVTiToggleBreakpointAdapter() {
		super();
	}

	public void toggleLineBreakpoints(final IWorkbenchPart part, ISelection selection) throws CoreException {
		if (!(part instanceof QVTimperativeEditor)) {
			return;
		}
		final QVTimperativeEditor qvtEditor = (QVTimperativeEditor)part;
		IFile unitFile = (IFile) qvtEditor.getEditorInput().getAdapter(IResource.class);		
		ITextSelection textSelection = (ITextSelection) selection;
		int lineNumber = textSelection.getStartLine() + 1;
		
		List<ILineBreakpoint> breakpoints = QVTiDebugCore.INSTANCE.getOCLBreakpoints(ILineBreakpoint.class);
		for(ILineBreakpoint next : breakpoints) {			 
			if(!unitFile.equals(next.getMarker().getResource())) {
				continue;
			}

			if(next.getLineNumber() == lineNumber) {
				try {
					// a breakpoint already exists at this line =>toggle again means remove
					DebugPlugin.getDefault().getBreakpointManager().removeBreakpoint(next, true);
				} catch (CoreException e) {
					QVTdDebugUIPlugin.log(e.getStatus());
				}
				next.delete();
				return;
			}
		}

		@SuppressWarnings("null")@NonNull URI sourceURI = URI.createPlatformResourceURI(unitFile.getFullPath().toString(), true);
		final VMLineBreakpoint lineBreakpoint = new QVTiLineBreakpoint(sourceURI, lineNumber);
		lineBreakpoint.register(true);
        
        Job job = new Job(DebugUIMessages.QVTiToggleBreakpointAdapter_VerifyBreakpointJob) {
            @Override
			protected IStatus run(IProgressMonitor monitor) {
				return new BreakpointLocationVerifier(qvtEditor, lineBreakpoint,
						DebugUIMessages.QVTiToggleBreakpointAdapter_CannotSetBreakpoint).run();
            }
            
            @Override
            public boolean belongsTo(Object family) {
            	return VMLineBreakpoint.OCL_BREAKPOINT_JOBFAMILY == family;
            }
        };
        
        job.setPriority(Job.INTERACTIVE);
        job.setSystem(true);
        job.schedule();        
	} 

	public boolean canToggleLineBreakpoints(IWorkbenchPart part, ISelection selection) {
		return part instanceof QVTimperativeEditor;
	}
		
	public void toggleMethodBreakpoints(IWorkbenchPart part, ISelection selection) throws CoreException {
	}

	public boolean canToggleMethodBreakpoints(IWorkbenchPart part, ISelection selection) {
		return false;
	}

	public void toggleWatchpoints(IWorkbenchPart part, ISelection selection) throws CoreException {
	}

	public boolean canToggleWatchpoints(IWorkbenchPart part, ISelection selection) {
		return false;
	}
}
