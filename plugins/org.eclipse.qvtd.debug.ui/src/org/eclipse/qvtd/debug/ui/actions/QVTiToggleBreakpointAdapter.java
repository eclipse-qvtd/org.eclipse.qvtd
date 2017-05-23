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

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.model.ILineBreakpoint;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ocl.examples.debug.vm.core.VMLineBreakpoint;
import org.eclipse.ocl.examples.debug.vm.ui.actions.BreakpointLocationVerifier;
import org.eclipse.ocl.examples.debug.vm.ui.actions.VMToggleBreakpointAdapter;
import org.eclipse.ocl.examples.debug.vm.ui.messages.DebugVMUIMessages;
import org.eclipse.qvtd.debug.core.QVTiDebugCore;
import org.eclipse.qvtd.debug.core.QVTiLineBreakpoint;
import org.eclipse.qvtd.xtext.qvtimperative.ui.QVTimperativeEditor;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.texteditor.ITextEditor;

public class QVTiToggleBreakpointAdapter extends VMToggleBreakpointAdapter
{
	@Override
	public boolean canToggleLineBreakpoints(IWorkbenchPart part, ISelection selection) {
		return part instanceof QVTimperativeEditor;
	}

	@Override
	protected @NonNull BreakpointLocationVerifier createBreakpointLocationVerifier(@NonNull ITextEditor textEditor, @NonNull VMLineBreakpoint lineBreakpoint) {
		String invalidLocationMessage = DebugVMUIMessages.ToggleBreakpointAdapter_CannotSetBreakpoint;
		assert invalidLocationMessage != null;
		return new QVTiBreakpointLocationVerifier(textEditor, lineBreakpoint, invalidLocationMessage);
	}

	@Override
	protected @NonNull QVTiLineBreakpoint createLineBreakpoint(int lineNumber, @NonNull URI sourceURI) throws CoreException {
		return new QVTiLineBreakpoint(sourceURI, lineNumber);
	}

	@Override
	protected @NonNull Object getBreakpointJobFamily(){
		return QVTiLineBreakpoint.QVTI_BREAKPOINT_JOBFAMILY;
	}

	@Override
	protected @NonNull List<@NonNull ILineBreakpoint> getOCLBreakpoints() {
		return QVTiDebugCore.INSTANCE.getOCLBreakpoints(ILineBreakpoint.class);
	}

	@Override
	public void toggleLineBreakpoints(final IWorkbenchPart part, ISelection selection) throws CoreException {
		if (part instanceof QVTimperativeEditor) {
			super.toggleLineBreakpoints(part, selection);;
		}
	}
}
