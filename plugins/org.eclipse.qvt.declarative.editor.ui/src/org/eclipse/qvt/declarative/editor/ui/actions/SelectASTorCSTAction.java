/**
 * <copyright>
 * 
 * Copyright (c) 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: SelectASTorCSTAction.java,v 1.1 2008/08/18 07:46:26 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.ui.actions;

import org.eclipse.imp.editor.UniversalEditor;
import org.eclipse.qvt.declarative.editor.ui.imp.CommonParseController;
import org.eclipse.ui.texteditor.TextEditorAction;

public class SelectASTorCSTAction extends TextEditorAction
{
	public static final String useASTkey = "org.eclipse.qvt.declarative.editor.ui.imp.actions.useAST";

	public SelectASTorCSTAction(UniversalEditor editor) {
        super(CommonActionContributor.ResBundle, "selectAST.", editor);
		setChecked(getUseAST());
    }

    @Override
	public void run() {
		boolean useAST = getUseAST();
    	setUseAST(!useAST);
    }

	protected boolean getUseAST() {
    	UniversalEditor universalEditor = (UniversalEditor)getTextEditor();
		String useAST = universalEditor.getPartProperty(useASTkey);
    	return useAST != null;
	}

	protected void setUseAST(boolean useAST) {
		UniversalEditor universalEditor = (UniversalEditor)getTextEditor();
    	CommonParseController parseController = (CommonParseController) universalEditor.getParseController();
    	parseController.setUseAST(useAST);
    	universalEditor.setPartProperty(useASTkey, useAST ? "true" : null);
	}
}
