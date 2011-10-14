/**
 * <copyright>
 * 
 * Copyright (c) 2008,2009 E.D.Willink and others.
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
 * $Id: CSTOutlinePage.java,v 1.3 2009/08/20 20:18:55 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.ui.cst;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.qvt.declarative.editor.ui.QVTEditorPlugin;
import org.eclipse.qvt.declarative.editor.ui.format.DefaultFormatManager;
import org.eclipse.qvt.declarative.editor.ui.imp.CommonTextEditor;
import org.eclipse.qvt.declarative.editor.ui.imp.ICommonParseResult;

public class CSTOutlinePage extends CommonOutlinePage implements ICSTOutlinePage
{
	public CSTOutlinePage(CommonTextEditor editor) {
		super(editor, editor.getCreationFactory().createTreeModelBuilder(false));
	}

	@Override
	public void setSelection(ISelection selection) {
		if (!isChangingSelection()) {
			ICommonParseResult currentResult = editor.getParseController().getCurrentResult();
			if (currentResult != null)
				selection = editor.getCSTSelection(selection, currentResult);
			super.setSelection(selection);
		} else if (QVTEditorPlugin.SELECTION_INNER.isActive())
			QVTEditorPlugin.SELECTION_INNER.println(getClass(), "setSelection " + DefaultFormatManager.formatDebug(selection));
	}
}
