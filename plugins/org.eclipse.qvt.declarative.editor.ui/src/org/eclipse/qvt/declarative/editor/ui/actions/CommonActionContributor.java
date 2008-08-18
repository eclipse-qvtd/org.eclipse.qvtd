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
 * $Id: CommonActionContributor.java,v 1.2 2008/08/18 20:36:56 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.ui.actions;

import java.util.ResourceBundle;

import org.eclipse.imp.editor.UniversalEditor;
import org.eclipse.imp.services.base.DefaultLanguageActionsContributor;
import org.eclipse.jface.action.IAction;

public class CommonActionContributor extends DefaultLanguageActionsContributor
{
	public CommonActionContributor() {
		super();
	}

	@Override
	public IAction[] getEditorActions(UniversalEditor editor) {
		return new IAction[] {
				new SelectASTorCSTAction(editor)
		};
	}

	public static ResourceBundle ResBundle = ResourceBundle.getBundle("org.eclipse.qvt.declarative.editor.ui.actions.ActionMessages");
}
