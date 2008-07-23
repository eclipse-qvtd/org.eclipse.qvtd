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

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.qvt.declarative.ecore.mappings.MappingConfigurationException;
import org.eclipse.qvt.declarative.parser.utils.ProblemCounter;
import org.eclipse.ui.IEditorPart;


public interface IMasterPageManager extends IPageManager
{
	/**
	 * Return a non-null reason if the current page should not deactivate; typically because
	 * it has fatal errors that prohibit installation to the ResourceSet.
	 * <p>
	 * If deactivation may proceed, updates should be populated with a map from resource-to-be-updated
	 * to updated-content that will be applied during PageChnageCommand. 
	 * 
	 * @param updates returned map of resource-to-update to updating-content
	 * @param monitor for progress
	 * @return warning and error counts of current page
	 */
	public ProblemCounter cannotDeactivate(Map<XMLResource,XMLResource> updates, IProgressMonitor monitor);

	/**
	 * Create the editor-specific content in outputStream from getEcoreResource().
	 */
	public void createContents(OutputStream outputStream) throws MappingConfigurationException, IOException;

	/**
	 * Save the page contents to editor input file.
	 */
	public void doSave(IProgressMonitor monitor) throws OperationCanceledException;

	/**
	 * Create the current editor-specific content.
	 */
	public String getCurrentContents() throws IOException;

	/**
	 * Return the underlying Ecore resource, if any.
	 */
	public XMLResource getEcoreResource();

	/**
	 * Return the file extension appropriate for temporary files created to support this page.
	 */
	public String getFileExtension();

	/**
	 * Return the editor to open when first opening starting to edit this page.
	 * Normally returns self, which is often an XML editor. May instead redirect
	 * to something prettier.)
	 */
	public IEditorPart getInitialPage();

	/**
	 * Return the resource edited my this page.
	 */
	public XMLResource getResource();

	/**
	 * Return true if this page editor is the one for which the paged editor opened.
	 */
	public boolean isMaster();

	/**
	 * Return true if this page edit needs to be deactivated (to validate the ResourceSet)
	 * before any other page can proceed.
	 */
	public boolean needsDeactivation();

	/**
	 * Save the page contents to the specified file.
	 */
	public void saveTo(IFile file, IProgressMonitor monitor);
}