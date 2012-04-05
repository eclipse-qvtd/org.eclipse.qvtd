/**
 * <copyright>
 * 
 * Copyright (c) 2007, 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * </copyright>
 * 
 * Contributors:
 *     Quentin Glineur - initial API and implementation
 *
 * $Id: DeclarativeQVTElementLabelProvider.java,v 1.2 2008/10/09 17:20:59 qglineur Exp $
 */
package org.eclipse.qvt.declarative.execution.ui.launching.configuration;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;

public class DeclarativeQVTElementLabelProvider implements ILabelProvider {

	public Image getImage(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getText(Object element) {
		if (element instanceof IProject) {
			IProject project = (IProject) element;
			return project.getName();
		} else if (element instanceof IFile) {
			IFile file = (IFile) element;
			String result = file.getProjectRelativePath().toString().replaceAll("/", ".");
			if (result.startsWith("src")) {
				return result.substring(4);
			}
			return result;
		}
		return null;
	}

	public void addListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub

	}

	public void dispose() {
		// TODO Auto-generated method stub

	}

	public boolean isLabelProperty(Object element, String property) {
		// TODO Auto-generated method stub
		return false;
	}

	public void removeListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub

	}

}
