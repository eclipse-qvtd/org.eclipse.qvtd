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
