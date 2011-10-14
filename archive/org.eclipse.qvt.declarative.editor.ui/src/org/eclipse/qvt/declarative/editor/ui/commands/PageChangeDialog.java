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
package org.eclipse.qvt.declarative.editor.ui.commands;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

public class PageChangeDialog extends MessageDialog
{
	protected static final String[] buttonLabels = new String[] { "Update", "Revert", "Resume" };	
	protected static final int UPDATE_BUTTON = 0;
	protected static final int REVERT_BUTTON = 1;
	protected static final int RESUME_BUTTON = 2;

	protected boolean canRevert;
	protected boolean canUpdate;
	protected String reasonNotToDeactivate;
	
	public PageChangeDialog(Shell shell, String newTitle, String oldTitle, String fileName, String reasonNotToDeactivate, boolean canUpdate, boolean canRevert) {
		super(shell, "Update " + fileName + " Resource", null, null,
				reasonNotToDeactivate != null ? MessageDialog.ERROR : MessageDialog.QUESTION,
				buttonLabels,
				reasonNotToDeactivate != null ? RESUME_BUTTON : UPDATE_BUTTON);
		this.canRevert = canRevert;
		this.canUpdate = canUpdate;
		StringBuffer s = new StringBuffer();
		if (reasonNotToDeactivate != null)
			s.append(reasonNotToDeactivate + "\n");
		else
			s.append("'" + oldTitle + "' page has been modified.\n");
		s.append("\n  Update - accept changes to '" + oldTitle + "' page");
//		if (!canAbort)
//			s.append("\n                - start editing '" + newTitle + "' page");
//		else {
			s.append("\n               - reconcile and edit '" + newTitle + "' page");
			s.append("\n\n  Revert - discard changes to '" + oldTitle + "' page");
			s.append("\n            - revert to editing '" + newTitle + "' page");
//		}
		s.append("\n\n  Resume - continue editing '" + oldTitle + "' page");
		message = s.toString();
	}
	
	@Override public void create() {
		super.create();
		if (!canUpdate)
			getButton(UPDATE_BUTTON).setEnabled(false);
		if (!canRevert)
			getButton(REVERT_BUTTON).setEnabled(false);
	}
	
	public boolean isResume() {
		return getReturnCode() == RESUME_BUTTON;
	}

	public boolean isRevert() {
		return getReturnCode() == REVERT_BUTTON;
	}
	
	public boolean isUpdate() {
		return getReturnCode() == UPDATE_BUTTON;
	}
}