/*******************************************************************************
* Copyright (c) 2007 IBM Corporation.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*    Robert Fuhrer (rfuhrer@watson.ibm.com) - initial API and implementation

*******************************************************************************/

package org.eclipse.imp.ui.dialogs.providers;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.pde.internal.ui.elements.DefaultContentProvider;

public class ContentProviderForGivenProjects
	extends DefaultContentProvider implements IStructuredContentProvider
{

	private IProject[] fProjects;

	public Object[] getElements(Object parent) {	
		if (fProjects!= null)
			return fProjects;
		return new Object[0];
	}
	
	public void setProjects(IProject[] projects) {
		fProjects = projects;
	}
	
	public IProject[] getProjects() {
		return fProjects;
	}

	
}
