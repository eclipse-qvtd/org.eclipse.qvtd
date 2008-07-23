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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.qvt.declarative.editor.ui.IPagedActionBarContributor;

public final class HideResourceAdaptersAction extends PagedAction
{
	public HideResourceAdaptersAction(IPagedActionBarContributor actionBarContributor) {
		super(actionBarContributor, "Hide Resource Adapters");
		setToolTipText("Suppress Resource Adapters such as EMOF adapters from the ResourceSet tree");
		setChecked(false);
	}

	public boolean select(Object element) {
		if (isChecked() && (element instanceof Resource) && (element instanceof Adapter))
			return false;
		return true;
	}
}