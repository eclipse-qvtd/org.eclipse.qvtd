/*******************************************************************************
 * Copyright (c) 2014, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     R.Dvorak and others - QVTo debugger framework
 *     E.D.Willink - revised API for OCL/QVTi debugger framework
 *******************************************************************************/
package org.eclipse.qvtd.debug.ui.actions;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.model.ISuspendResume;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ocl.examples.debug.vm.core.VMLineBreakpoint;
import org.eclipse.ocl.examples.debug.vm.ui.actions.BreakpointLocationVerifier;
import org.eclipse.ocl.examples.debug.vm.ui.actions.VMRunToLineAdapter;
import org.eclipse.qvtd.debug.core.QVTiLineBreakpoint;
import org.eclipse.qvtd.xtext.qvtimperative.ui.QVTimperativeEditor;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.texteditor.ITextEditor;

public class QVTiRunToLineAdapter extends VMRunToLineAdapter
{
	@Override
	public boolean canRunToLine(IWorkbenchPart part, ISelection selection, ISuspendResume target) {
		return (part instanceof QVTimperativeEditor) && super.canRunToLine(part, selection, target);
	}

	@Override
	protected @NonNull BreakpointLocationVerifier createBreakpointLocationVerifier(@NonNull ITextEditor textEditor,
			@NonNull VMLineBreakpoint vmBreakpoint, @NonNull String invalidLocationMessage) {
		return new QVTiBreakpointLocationVerifier(textEditor, vmBreakpoint, invalidLocationMessage);
	}

	@Override
	protected @NonNull VMLineBreakpoint createRunToLineBreakpoint(@NonNull URI resourceURI, int lineNumber) throws CoreException {
		return QVTiLineBreakpoint.createRunToLineBreakpoint(resourceURI, lineNumber);
	}
}
