/*******************************************************************************
 * Copyright (c) 2009 R.Dvorak and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Radek Dvorak - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.debug.srclookup;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.model.IPersistableSourceLocator;
import org.eclipse.debug.core.sourcelookup.AbstractSourceLookupDirector;
import org.eclipse.debug.core.sourcelookup.ISourceLookupDirector;
import org.eclipse.debug.core.sourcelookup.ISourceLookupParticipant;
import org.eclipse.qvtd.debug.QVTdDebugPlugin;

/**
 * @since 1.3
 */
public class QVTiSourceLookupDirector extends AbstractSourceLookupDirector {	
	
	private static final String PDE_SOURCE_LOOKUP_DIRECTOR_ID = "org.eclipse.pde.ui.launcher.PDESourceLookupDirector";
	
	private ISourceLookupDirector fPDEdelegate;
	
	public QVTiSourceLookupDirector() {
		try {
			IPersistableSourceLocator newSourceLocator = DebugPlugin.getDefault().getLaunchManager()
				.newSourceLocator(PDE_SOURCE_LOOKUP_DIRECTOR_ID);
			
			if(newSourceLocator instanceof ISourceLookupDirector) {
				fPDEdelegate = (ISourceLookupDirector) newSourceLocator;
			}
		} catch (CoreException e) {
			QVTdDebugPlugin.log(e.getStatus());
		}
	}
	
	public void initializeParticipants() {
		addParticipants(new ISourceLookupParticipant[] { new QVTiSourceLookupParticipant() });
		if(fPDEdelegate != null) {
			fPDEdelegate.initializeParticipants();
			addParticipants(fPDEdelegate.getParticipants());
		}
	}
}
