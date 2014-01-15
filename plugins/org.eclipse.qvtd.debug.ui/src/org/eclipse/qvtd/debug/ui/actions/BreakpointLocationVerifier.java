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

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.model.ILineBreakpoint;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.resource.ASResource;
import org.eclipse.ocl.examples.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.examples.xtext.base.utilities.CS2PivotResourceAdapter;
import org.eclipse.osgi.util.NLS;
import org.eclipse.qvtd.debug.ui.QVTdDebugUIPlugin;
import org.eclipse.qvtd.debug.utils.CompiledUnit;
import org.eclipse.qvtd.debug.utils.LineNumberProvider;
import org.eclipse.qvtd.debug.vm.ValidBreakpointLocator;
import org.eclipse.qvtd.xtext.qvtimperative.ui.QVTimperativeEditor;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.IEditorStatusLine;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

class BreakpointLocationVerifier {
	
	private static LineNumberProvider getLineNumberProvider(final IDocument doc) {
		
		return new LineNumberProvider() {
			
			public int getLineNumber(int offset) {
				try {
					return doc.getLineOfOffset(offset) + 1;
				} catch (BadLocationException e) {
					return -1;
				}
			}
			
			public int getLineEnd(int lineNumber) {
				try {
					IRegion lineInfo = doc.getLineInformation(lineNumber);
					return lineInfo.getOffset() + lineInfo.getLength();
				} catch (BadLocationException e) {
					return -1;
				}
			}

			public int getLineCount() {
				return doc.getNumberOfLines();
			}
		};
	}		
	
	private static final int GET_AST_TIMEOUT = 10 * 1000;
	
	private final ILineBreakpoint fBreakpoint;
	private final QVTimperativeEditor fEditor;
	private final String fInvalidLocationMessage;
	
	BreakpointLocationVerifier(QVTimperativeEditor editor, ILineBreakpoint breakpoint, String invalidLocationMessage) {
		if(editor == null || breakpoint == null || invalidLocationMessage == null) {
			throw new IllegalArgumentException();
		}
		
		fEditor = editor; 			
		fBreakpoint = breakpoint;
		fInvalidLocationMessage = invalidLocationMessage; 			
	}
	
	IStatus run()  {
		IStatus status = checkBreakpointableElements();
		if(!status.isOK()) {				
			if (fBreakpoint != null) {
				try {
					DebugPlugin.getDefault().getBreakpointManager().removeBreakpoint(fBreakpoint, true);
				} catch (CoreException e) {
					QVTdDebugUIPlugin.log(e.getStatus());
				}
			}
		}
		return status;
	}
	
	private IStatus checkBreakpointableElements()  {
		int lineNumber;
		try {
			lineNumber = fBreakpoint.getLineNumber();
		} catch (CoreException e) {
			return e.getStatus();
		}
		
		IDocumentProvider docProvider = fEditor.getDocumentProvider();
		if(docProvider == null) {
			return canceled();
		}
		
		IDocument doc = docProvider.getDocument(fEditor.getEditorInput());
		if(doc == null) {
			return canceled();
		}
		Root root = ((XtextDocument)doc).readOnly(new IUnitOfWork<Root, XtextResource>()
		{
			@Override
			public Root exec(XtextResource state) throws Exception {
				if (state instanceof BaseCSResource) {
					BaseCSResource csResource = (BaseCSResource)state;
					CS2PivotResourceAdapter cs2asAdapter = csResource.findCS2ASAdapter();
					if (cs2asAdapter != null) {
						ASResource asResource = cs2asAdapter.getASResource(csResource);
						if ((asResource != null) && (asResource.getContents().size() > 0)) {
							EObject eObject = asResource.getContents().get(0);
							if (eObject instanceof Root) {
								return (Root)eObject;
							}
						}
					}
				}
				return null;
			}
		});
        CompiledUnit compilationUnit = root != null ? new CompiledUnit(root) : null;
        if(compilationUnit == null) {
        	return QVTdDebugUIPlugin.createErrorStatus("Failed to obtain AST"); //$NON-NLS-1$
        }

		List<Element> elements = ValidBreakpointLocator
				.getBreakpointableElementsForLine(compilationUnit,
						getLineNumberProvider(doc), lineNumber);                    	 
		if(elements.isEmpty()) {
            report(NLS.bind(fInvalidLocationMessage, new Integer(lineNumber)));
            return canceled();
		}

		return Status.OK_STATUS;
	}
		
	/**
	 * Reports any status to the current active workbench shell
	 * @param message the message to display
	 */
	protected void report(final String message) {
		QVTdDebugUIPlugin.getStandardDisplay().asyncExec(new Runnable() {
			public void run() {
				IEditorStatusLine statusLine = (IEditorStatusLine) fEditor.getAdapter(IEditorStatusLine.class);
				if (statusLine != null) {
					statusLine.setMessage(true, message, null);
				}
				if (message != null && QVTdDebugUIPlugin.getActiveWorkbenchShell() != null) {
					Display.getCurrent().beep();
				}
			}
		});
	}
	
	private IStatus canceled() {
		return QVTdDebugUIPlugin.createStatus(IStatus.CANCEL, fInvalidLocationMessage);
	}
}