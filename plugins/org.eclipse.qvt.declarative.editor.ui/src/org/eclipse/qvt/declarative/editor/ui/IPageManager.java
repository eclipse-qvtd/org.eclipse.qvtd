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

import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.qvt.declarative.ecore.mappings.MappingConfigurationException;
import org.eclipse.qvt.declarative.editor.ui.paged.PagedEditor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.services.IDisposable;

public interface IPageManager extends ISelectionProvider, IDisposable
{
	/**
	 * Activate the page by loading from the core representation.
	 */
	public void activate(IProgressMonitor monitor, long resourceSetTimeStamp) throws CoreException, IOException, MappingConfigurationException;

	/**
	 * Notify the page that it has been deactivated.
	 */
	public void deactivated(IProgressMonitor monitor, long resourceSetTimeStamp);

	/**
	 * Return a potentially editor-specific action for actionId.
	 */
	public IAction getAction(String actionId);

	/**
	 * Return an adapter that enables this to behave as key, or null if no adapter available. 
	 */
	public <T> T getAdapter(Class<T> key);

	/**
	 * Return the editor managed by this page manager.
	 */
	public IEditorPart getEditor();
	
	/**
	 * Return the edit or input that is (or will become) the editor input once the
	 * editor is activated.
	 */
	public IFileEditorInput getEditorInput();
	
	/**
	 * Return the icon for the page tab.
	 */
	public Image getImage();

	/**
	 * Return the overall paged editor.
	 */
	public PagedEditor getPagedEditor();
		
	/**
	 * Return a SelectionProvider, if any, for the page
	 */
	public ISelectionProvider getSelectionProvider();

	/**
	 * Return the text for the page tab.
	 */
	public String getTitle();

	/**
	 * Return the Undo Context for the managed editor.
	 */
	public IUndoContext getUndoContext();

	/**
	 * Return true after selecting the object referenced by marker,
	 * or false if the object is not visible in this page.
	 *  
	 * @param marker
	 * @return true if gone to
	 */
	public boolean gotoMarker(IMarker marker);

	/**
	 * Return true if the manager has a saved context for resourceSetTimeStamp.
	 */
	public boolean hasResourceSetTimeStamp(long resourceSetTimeStamp);

	/**
	 * Return true if this page editor directly edits the ResourceSet.
	 */
	public boolean isDirect();

	/**
	 * Respond to an external change such as a model registry update.
	 */
	public void refresh();

	/**
	 * Resume listening to resource changes. This follows the
	 * suspendResourceListening that avoids an unwanted
	 * notification of a change following a save.
	 */
	public void resumeResourceListening();

	/**
	 * Suspend listening to resource changes. This avoids an unwanted
	 * notification of a change following a save.
	 */
	public void suspendResourceListening();
}