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
package org.eclipse.qvtd.debug.ui.actions;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ocl.examples.debug.vm.ui.actions.VMToggleBreakpointAdapter;
import org.eclipse.qvtd.xtext.qvtimperative.ui.QVTimperativeEditor;
import org.eclipse.ui.IWorkbenchPart;

public class QVTiToggleBreakpointAdapter extends VMToggleBreakpointAdapter
{
	public boolean canToggleLineBreakpoints(IWorkbenchPart part, ISelection selection) {
		return part instanceof QVTimperativeEditor;
	}

	public void toggleLineBreakpoints(final IWorkbenchPart part, ISelection selection) throws CoreException {
		if (part instanceof QVTimperativeEditor) {
			super.toggleLineBreakpoints(part, selection);;
		}
	}
}
