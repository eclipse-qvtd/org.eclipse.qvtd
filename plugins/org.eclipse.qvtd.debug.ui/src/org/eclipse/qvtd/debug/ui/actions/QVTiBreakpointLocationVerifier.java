/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     R.Dvorak and others - QVTo debugger framework
 *     E.D.Willink - revised API for OCL debugger framework
 *******************************************************************************/
package org.eclipse.qvtd.debug.ui.actions;

import org.eclipse.debug.core.model.ILineBreakpoint;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.debug.vm.ValidBreakpointLocator;
import org.eclipse.ocl.examples.debug.vm.ui.actions.BreakpointLocationVerifier;
import org.eclipse.qvtd.debug.launching.QVTiDebuggableRunnerFactory;
import org.eclipse.ui.texteditor.ITextEditor;

public class QVTiBreakpointLocationVerifier extends BreakpointLocationVerifier
{
	protected QVTiBreakpointLocationVerifier(@NonNull ITextEditor editor, @NonNull ILineBreakpoint breakpoint, @NonNull String invalidLocationMessage) {
		super(editor, breakpoint, invalidLocationMessage);
	}

	@Override
	protected @NonNull ValidBreakpointLocator getValidBreakpointLocator() {
		return QVTiDebuggableRunnerFactory.validBreakpointLocator;
	}
}