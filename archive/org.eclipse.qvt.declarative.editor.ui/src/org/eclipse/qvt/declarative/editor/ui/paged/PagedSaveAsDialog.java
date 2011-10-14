/*******************************************************************************
 * Copyright (c) 2007 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.editor.ui.paged;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.SaveAsDialog;

public abstract class PagedSaveAsDialog extends SaveAsDialog
{
	private Combo saveTypeCombo = null;
	private int saveTypeIndex = -1;

	public PagedSaveAsDialog(Shell parentShell) {
		super(parentShell);
	}

	@Override protected Control createDialogArea(Composite parent) {
		Composite contents = (Composite) super.createDialogArea(parent);
		GridLayout layout = new GridLayout(2, false);
        layout.marginHeight = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_MARGIN);
        layout.marginWidth = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_MARGIN);
        layout.verticalSpacing = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_SPACING);
        layout.horizontalSpacing = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_SPACING);
		Composite inner = new Composite(contents, SWT.NULL);
		inner.setLayout(layout);
//		inner.setFont(parent.getFont());
		inner.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		createSaveTypeCombo(inner);
		return contents;
	}

	private Combo createSaveTypeCombo(Composite inner) {
		Label saveTypeKindLabel = new Label(inner, SWT.NONE);
		saveTypeKindLabel.setText("Save As Type:"); 
		saveTypeCombo = new Combo(inner, SWT.NONE);
		saveTypeCombo.setItems(getSaveTypes());
		saveTypeCombo.select(0);
		saveTypeCombo.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		return saveTypeCombo;
	}
	
	protected abstract String[] getSaveTypes();
	
	public int getSaveTypeIndex() {
		return saveTypeIndex;
	}

	@Override protected void okPressed() {
		saveTypeIndex = saveTypeCombo.getSelectionIndex();
		super.okPressed();
	}
}
