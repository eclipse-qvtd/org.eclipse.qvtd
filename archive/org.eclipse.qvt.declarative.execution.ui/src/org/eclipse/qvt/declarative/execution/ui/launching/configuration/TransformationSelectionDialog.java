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
 * $Id: TransformationSelectionDialog.java,v 1.2 2008/10/09 17:20:59 qglineur Exp $
 */
package org.eclipse.qvt.declarative.execution.ui.launching.configuration;

import java.util.Comparator;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.qvt.declarative.execution.ui.Activator;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.FilteredItemsSelectionDialog;

public class TransformationSelectionDialog extends FilteredItemsSelectionDialog {

	private Set<IFile> files = null;
	private static final String SETTINGS_ID = Activator.PLUGIN_ID;
	
	private class FileItemsFilter extends ItemsFilter {

		@Override
		public boolean isConsistentItem(Object item) {
			if (item instanceof IFile) {
				IFile file = (IFile) item;
				String extension = file.getFileExtension();
				return extension.equals(DeclarativeQVTFileFetcher.QVT_CORE_FILE_EXTENSION) || extension.equals(DeclarativeQVTFileFetcher.QVT_RELATIONS_FILE_EXTENSION);
			}
			return false;
		}

		@Override
		public boolean matchItem(Object item) {
			if (item instanceof IFile) {
				IFile file = (IFile) item;
				return files.contains(file) && matches(((IFile)item).getName());
			}
			return false;
		}
		
	}
	
	public TransformationSelectionDialog(Shell shell, Set<IFile> files) {
		super(shell, false);
		setTitle("Select transformation");
		this.files = files;
		setMessage(getClass().getName());
		setInitialPattern("**");
	}

	@Override
	protected Control createExtendedContentArea(Composite parent) {
		System.out.println("createExtendedContentArea");
		return null;
	}

	@Override
	protected ItemsFilter createFilter() {
		return new FileItemsFilter();
	}

	@Override
	protected void fillContentProvider(AbstractContentProvider contentProvider,
			ItemsFilter itemsFilter, IProgressMonitor progressMonitor)
			throws CoreException {
		if(files != null) {
			for(IFile file : files) {
				if(itemsFilter.isConsistentItem(file)) {
					contentProvider.add(file, itemsFilter);
				}
			}
		}
	}

	@Override
	protected IDialogSettings getDialogSettings() {
		IDialogSettings dialogSettings = Activator.getDefault().getDialogSettings();
		IDialogSettings section = dialogSettings.getSection(SETTINGS_ID);
		if (section == null) {
			section = dialogSettings.addNewSection(SETTINGS_ID);
		}
		return section;
	}

	@Override
	public String getElementName(Object item) {
		if (item instanceof IFile) {
			IFile file = (IFile) item;
			return file.getName();
		}
		return null;
	}

	@Override
	protected Comparator<?> getItemsComparator() {
		Comparator<Object> comparator = new Comparator<Object>(){
			
			public int compare(Object o1,Object o2){
				if (o1 instanceof IFile && o2 instanceof IFile) {
					return ((IFile)o1).getName().compareTo(((IFile)o2).getName());
				}
				return -1;
			}
		};
		return comparator;
	}

	@Override
	protected IStatus validateItem(Object item) {
		return Status.OK_STATUS;
	}

}
