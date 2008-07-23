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
package org.eclipse.qvt.declarative.editor.ui.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.qvt.declarative.editor.ui.IPagedActionBarContributor;

public abstract class PagedAction extends Action
{
	protected final IPagedActionBarContributor actionBarContributor;
		
	protected PagedAction(IPagedActionBarContributor actionBarContributor, String text) {
		this.actionBarContributor = actionBarContributor;
		setText(text);
	}
	
	@Override public String toString() {
		return getClass().getSimpleName() + ":" + getText();
	}
}