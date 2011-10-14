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
package org.eclipse.qvt.declarative.editor.ui;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.qvt.declarative.editor.ui.actions.HideResourceAdaptersAction;
import org.eclipse.ui.IEditorActionBarContributor;
import org.eclipse.ui.IEditorPart;

public interface IPagedActionBarContributor extends IEditorActionBarContributor
{
	public IEditorPart getActiveEditor();
	public HideResourceAdaptersAction getHideResourceAdaptersAction();
	public void menuAboutToShow(IMenuManager menuManager);
}
