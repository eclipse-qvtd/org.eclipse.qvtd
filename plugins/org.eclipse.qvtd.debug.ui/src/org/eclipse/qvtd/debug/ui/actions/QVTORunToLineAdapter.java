/*******************************************************************************
 * Copyright (c) 2009 R.Dvorak and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Radek Dvorak - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.debug.ui.actions;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.ISuspendResume;
import org.eclipse.debug.ui.actions.IRunToLineTarget;
import org.eclipse.debug.ui.actions.RunToLineHandler;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ocl.examples.debug.core.VMDebugCore;
import org.eclipse.ocl.examples.debug.core.VMDebugElement;
import org.eclipse.ocl.examples.debug.core.VMLineBreakpoint;
import org.eclipse.qvtd.debug.core.QVTiLineBreakpoint;
import org.eclipse.qvtd.debug.ui.QVTdDebugUIPlugin;
import org.eclipse.qvtd.debug.ui.messages.DebugUIMessages;
import org.eclipse.qvtd.xtext.qvtimperative.ui.QVTimperativeEditor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.ITextEditor;


public class QVTORunToLineAdapter implements IRunToLineTarget {
	
	public QVTORunToLineAdapter() {
		super();
	}
	
	public void runToLine(IWorkbenchPart part, ISelection selection, ISuspendResume target) throws CoreException {
		IEditorPart editorPart = (IEditorPart)part;
		IEditorInput input = editorPart.getEditorInput();
		if(input == null) {
			throw new CoreException(QVTdDebugUIPlugin.createErrorStatus(DebugUIMessages.QVTORunToLineAdapter_NoInput));
		}
		
		ITextEditor textEditor = (ITextEditor)editorPart;
		IDocumentProvider provider = textEditor.getDocumentProvider();
		IDocument document = provider.getDocument(input);
		if(document == null) {
			throw new CoreException(QVTdDebugUIPlugin.createErrorStatus(DebugUIMessages.QVTORunToLineAdapter_NoDocument));
		}
		
		IFile file = (IFile)input.getAdapter(IFile.class);
		if (file == null) {
			throw new CoreException(QVTdDebugUIPlugin.createErrorStatus(DebugUIMessages.QVTORunToLineAdapter_NoFile)); 
		}
		
		ITextSelection textSelection = (ITextSelection) selection;
		int lineNumber = textSelection.getStartLine() + 1;
				
		URI resourceURI = VMDebugCore.getResourceURI(file);
		VMLineBreakpoint qvtBreakpoint = QVTiLineBreakpoint.createRunToLineBreakpoint(resourceURI, lineNumber);

		String invalidLocationMessage = DebugUIMessages.QVTORunToLineAdapter_invalidLocation;
		IStatus verifyStatus = new BreakpointLocationVerifier((QVTimperativeEditor) textEditor, qvtBreakpoint,
				invalidLocationMessage).run();
		if(!verifyStatus.isOK()) {
			new ErrorDialog(part.getSite().getShell(), null,
					DebugUIMessages.QVTORunToLineAdapter_runFailed, verifyStatus, IStatus.CANCEL).open();
			return;
		}

		
		IAdaptable adaptableTarget = (IAdaptable)target;
		IDebugTarget debugTarget = (IDebugTarget) adaptableTarget.getAdapter(IDebugTarget.class);
		if (debugTarget != null) {
            RunToLineHandler handler = new RunToLineHandler(debugTarget, target, qvtBreakpoint);
            handler.run(new NullProgressMonitor());
			return;
		}
	}

	public boolean canRunToLine(IWorkbenchPart part, ISelection selection, ISuspendResume target) {
		return (target instanceof VMDebugElement) && (part instanceof QVTimperativeEditor);
	}
}
