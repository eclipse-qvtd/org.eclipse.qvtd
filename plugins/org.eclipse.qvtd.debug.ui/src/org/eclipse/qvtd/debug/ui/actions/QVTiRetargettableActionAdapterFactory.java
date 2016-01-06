/*******************************************************************************
 * Copyright (c) 2014, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     R.Dvorak and others - QVTo debugger framework
 *     E.D.Willink - revised API for OCL/QVTi debugger framework
 *******************************************************************************/
package org.eclipse.qvtd.debug.ui.actions;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.debug.ui.actions.IRunToLineTarget;
import org.eclipse.debug.ui.actions.IToggleBreakpointsTarget;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.xtext.qvtimperative.ui.QVTimperativeEditor;

/**
 * Creates adapters for retargettable actions in debug platform.
 * Contributed via <code>org.eclipse.core.runtime.adapters</code> 
 * extension point. 
 */
public class QVTiRetargettableActionAdapterFactory implements IAdapterFactory
{	
	public QVTiRetargettableActionAdapterFactory() {
		super();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> @Nullable T getAdapter(Object adaptableObject, Class<T> adapterType) {
		if (!(adaptableObject instanceof QVTimperativeEditor)) {
			return null;
        }
        if (IRunToLineTarget.class == adapterType) {
			return (T) new QVTiRunToLineAdapter();
        } else if (IToggleBreakpointsTarget.class == adapterType) {
			return (T) new QVTiToggleBreakpointAdapter();
        } 
		return null;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Class[] getAdapterList() {
		return new Class[] { QVTiToggleBreakpointAdapter.class, QVTiRunToLineAdapter.class };
	}
}
