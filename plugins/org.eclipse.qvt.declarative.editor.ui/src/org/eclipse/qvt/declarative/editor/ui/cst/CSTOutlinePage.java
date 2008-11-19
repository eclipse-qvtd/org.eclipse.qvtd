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
 * $Id: CSTOutlinePage.java,v 1.2 2008/11/19 21:55:36 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.ui.cst;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.qvt.declarative.editor.ui.QVTEditorPlugin;
import org.eclipse.qvt.declarative.editor.ui.format.DefaultFormatManager;
import org.eclipse.qvt.declarative.editor.ui.imp.CommonTextEditor;

public class CSTOutlinePage extends CommonOutlinePage implements ICSTOutlinePage
{
	public CSTOutlinePage(CommonTextEditor editor) {
		super(editor, editor.getCreationFactory().createTreeModelBuilder(false));
	}

	@Override
	public void setSelection(ISelection selection) {
		if (!isChangingSelection())
			super.setSelection(editor.getCSTSelection(selection));
        else if (QVTEditorPlugin.SELECTION_INNER.isActive())
			QVTEditorPlugin.SELECTION_INNER.println(getClass(), "setSelection " + DefaultFormatManager.formatDebug(selection));
	}
}
