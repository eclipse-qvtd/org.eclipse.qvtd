/*******************************************************************************
 * Copyright (c) 2013, 2016 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.debug.ui.launching;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;

public class CompileStepRow extends ParameterRow
{
	private Label state;

	public CompileStepRow(@NonNull MainTab mainTab, @NonNull Group group, int style, @NonNull String parameterName, @NonNull String parameterPath) {
		super(mainTab, group, style, parameterName, parameterPath);
	}

	public void compiled(@Nullable Object object) {
		state.setText("Ready");
		state.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_GREEN));
//		state.setForeground(Display.getDefault().getSystemColor(SWT.COLOR_GREEN));
	}

	@Override
	protected void createDerivedButtons() {
		state = new Label(this, SWT.NONE);
		state.setText("  Stale  ");
	}

	public void reset() {
		state.setText("Stale");
		state.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
	}
}
