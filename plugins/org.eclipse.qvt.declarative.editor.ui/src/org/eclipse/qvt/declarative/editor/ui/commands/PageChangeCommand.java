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
package org.eclipse.qvt.declarative.editor.ui.commands;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.ocl.lpg.ProblemHandler;
import org.eclipse.qvt.declarative.editor.ui.ICreationFactory;
import org.eclipse.qvt.declarative.editor.ui.IMasterPageManager;
import org.eclipse.qvt.declarative.editor.ui.IPageManager;
import org.eclipse.qvt.declarative.editor.ui.IUndoContextAffecter;
import org.eclipse.qvt.declarative.editor.ui.QVTEditorPlugin;
import org.eclipse.qvt.declarative.editor.ui.paged.PagedEditor;
import org.eclipse.qvt.declarative.editor.ui.utils.EcoreUpdater;
import org.eclipse.qvt.declarative.editor.ui.utils.MissingElementException;
import org.eclipse.qvt.declarative.parser.utils.ProblemCounter;

public class PageChangeCommand extends AbstractCommand implements AbstractCommand.NonDirtying, IUndoContextAffecter
{
	protected final PagedEditor pagedEditor;
	private final IPageManager oldPageManager;
	private final IPageManager newPageManager;
	protected final long resourceSetTimeStamp;
	protected Map<XMLResource,XMLResource> updates = null;
	protected Map<XMLResource,XMLResource> restores = null; 	// For undo
	private boolean suppressDeactivation = false;

	public PageChangeCommand(PagedEditor pagedEditor, IPageManager newPageManager) {
		this.pagedEditor = pagedEditor;
		this.oldPageManager = pagedEditor.getActivePageManager();
		this.newPageManager = newPageManager;
		resourceSetTimeStamp = pagedEditor.getNextResourceSetTimeStamp();
		assert newPageManager != oldPageManager;
		assert newPageManager != null;
		assert oldPageManager != null;
		setLabel("Page Change " + resourceSetTimeStamp);
	}

	@Override public boolean canUndo() {
		return oldPageManager.hasResourceSetTimeStamp(resourceSetTimeStamp);
	}

	@Override public void dispose() {
        super.dispose();
//	    oldPageManager = null;
//	    newPageManager = null;
        restores = null;
	}

	public void execute() {
		redo();
	}

	@Override
	protected boolean prepare() {
		IMasterPageManager oldIndirectPageManager = oldPageManager.getAdapter(IMasterPageManager.class);
		if (oldIndirectPageManager != null) {
			boolean needsDeactivation = oldIndirectPageManager.needsDeactivation();
			boolean dirtyPage = pagedEditor.isDirtyPage();
			if (needsDeactivation || dirtyPage) {
				boolean deactivate = false;						// False if abandoning oldPage
				updates = new HashMap<XMLResource,XMLResource>();
				ProblemCounter problems = oldIndirectPageManager.cannotDeactivate(updates, pagedEditor.getProgressMonitor());
				if ((problems.getRelevantProblemCount(ProblemHandler.Severity.WARNING) > 0) || dirtyPage) {
					// FIXME Test next line
					boolean canRevert = (resourceSetTimeStamp > 0) && newPageManager.hasResourceSetTimeStamp(resourceSetTimeStamp-1);
					boolean canUpdate = problems.getRelevantProblemCount(ProblemHandler.Severity.ERROR) <= 0; //oldIndirectPageManager.canRevert();
					String reasonNotToDeactivate = "Text has " + problems.getSummary();
					PageChangeDialog dialog = new PageChangeDialog(pagedEditor.getShell(), newPageManager.getTitle(), oldPageManager.getTitle(), pagedEditor.getTitle(), reasonNotToDeactivate, canUpdate, canRevert);
					dialog.open();
					if (dialog.isUpdate())						// UPDATE
						deactivate = true;						//  page change with deactivation
					else if (dialog.isRevert())					// REVERT
						suppressDeactivation = true;			//  page change without deactivation
					else										// RESUME or cancel
						return false;							//  nothing to do
				}
				else 
					deactivate = needsDeactivation;				// deactivate if ResourceSet needs definition
				if (!deactivate)
					updates = null;
			}
		}
		return true;
	}

	public void redo() {
		if (updates != null) {
			if (restores != null)
				restores.clear();
			else
				restores = new HashMap<XMLResource,XMLResource>();
			ICreationFactory creationFactory = pagedEditor.getCreationFactory();
			for (XMLResource target : updates.keySet()) {
				XMLResource source = updates.get(target);
				creationFactory.assignXmiIds(source);
				creationFactory.assignXmiIds(target);			// FIXME do just once when editor first activated
			}
			for (XMLResource target : updates.keySet()) {
				try {
					restores.put(target, EcoreUpdater.copy(target));
					XMLResource source = updates.get(target);
					EcoreUpdater.update(target, source);
				} catch (MissingElementException e) {
					QVTEditorPlugin.showError("Failed to update '" + target.getURI() + "'", e);
				}
			}
		}
		pagedEditor.deactivate(suppressDeactivation ? null : oldPageManager, resourceSetTimeStamp);
		pagedEditor.setActivePageManager(newPageManager, resourceSetTimeStamp);
		// FIXME Destroy a tab and remove page manager if page deleted.
	}

	public void setAffectedContext(IUndoableOperation operation) {
		IUndoContext context = oldPageManager.getUndoContext();
		if (context != null)
			operation.addContext(context);
		context = newPageManager.getUndoContext();
		if (context != null)
			operation.addContext(context);		
	}

	@Override public void undo() {
		if (restores != null) {
			for (XMLResource target : restores.keySet()) {
				try {
					XMLResource source = restores.get(target);
					EcoreUpdater.update(target, source);
				} catch (MissingElementException e) {
					QVTEditorPlugin.showError("Failed to update '" + target.getURI() + "'", e);
				}
			}
		}
		// FIXME Create a tab and re-add page manager if page deleted.
		pagedEditor.setActivePageManager(oldPageManager, resourceSetTimeStamp);
	}
}