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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.presentation.EcoreActionBarContributor;
import org.eclipse.emf.workspace.ui.actions.RedoActionWrapper;
import org.eclipse.emf.workspace.ui.actions.UndoActionWrapper;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.qvt.declarative.editor.ui.CoreUtils;
import org.eclipse.qvt.declarative.editor.ui.IPageManager;
import org.eclipse.qvt.declarative.editor.ui.IPagedActionBarContributor;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.ide.IDEActionFactory;
import org.eclipse.ui.texteditor.ITextEditorActionConstants;
import org.eclipse.ui.texteditor.ITextEditorActionDefinitionIds;
import org.eclipse.ui.texteditor.ITextEditorExtension;
import org.eclipse.ui.texteditor.StatusLineContributionItem;

/**
 * Manages the installation/deinstallation of global actions for paged editors.
 * Responsible for the redirection of global actions to the active editor.
 * Paged contributor replaces the contributors for the individual editors in the paged editor.
 */
// FIXME review all extensions wrt EditingDomainActionBarContributor
public class PagedActionBarContributor extends EcoreActionBarContributor implements IPagedActionBarContributor
//public class PagedActionBarContributor extends EditingDomainActionBarContributor
{
	// Following from BasicTextEditor
	/**
	 * Status field definition.
	 * @since 3.0
	 */
	private static class StatusFieldDef {

		private String category;
		private String actionId;
		private boolean visible;
		private int widthInChars;

		private StatusFieldDef(String category, String actionId, boolean visible, int widthInChars) {
			Assert.isNotNull(category);
			this.category= category;
			this.actionId= actionId;
			this.visible= visible;
			this.widthInChars= widthInChars;
		}
	}

	private final static StatusFieldDef[] STATUS_FIELD_DEFS= {
//		new StatusFieldDef(ITextEditorActionConstants.STATUS_CATEGORY_FIND_FIELD, null, false, EditorMessages.Editor_FindIncremental_reverse_name.length() + 15),
		new StatusFieldDef(ITextEditorActionConstants.STATUS_CATEGORY_ELEMENT_STATE, null, true, 14/*StatusLineContributionItem.DEFAULT_WIDTH_IN_CHARS*/ + 1),
		new StatusFieldDef(ITextEditorActionConstants.STATUS_CATEGORY_INPUT_MODE, ITextEditorActionDefinitionIds.TOGGLE_OVERWRITE, true, 14/*StatusLineContributionItem.DEFAULT_WIDTH_IN_CHARS*/),
		new StatusFieldDef(ITextEditorActionConstants.STATUS_CATEGORY_INPUT_POSITION, ITextEditorActionConstants.GOTO_LINE, true, 14/*StatusLineContributionItem.DEFAULT_WIDTH_IN_CHARS*/)
	};
	private IEditorPart activeEditorPart;
	private HideResourceAdaptersAction hideResourceAdaptersAction;
//	private Action testActionBarAction;
//	private Action testGlobalAction;
//	private Action testMenuAction;
//	private Action testToolBarAction;
	private Map<StatusFieldDef, StatusLineContributionItem> fStatusFields;
	private Map<String, IAction> sharedActions = new HashMap<String, IAction>();
	
	/**
	 * Creates a multi-page contributor.
	 */
	public PagedActionBarContributor() {
		super();
		hideResourceAdaptersAction = new HideResourceAdaptersAction(this);

		fStatusFields = new HashMap<StatusFieldDef, StatusLineContributionItem>(3);
		for (int i= 0; i < STATUS_FIELD_DEFS.length; i++) {
			StatusFieldDef fieldDef = STATUS_FIELD_DEFS[i];
			fStatusFields.put(fieldDef, new StatusLineContributionItem(fieldDef.category, fieldDef.visible, fieldDef.widthInChars));
		}
	}
	
	@Override
	protected void addGlobalActions(IMenuManager menuManager) {
		// TODO Auto-generated method stub
		super.addGlobalActions(menuManager);
//	    String key = (style & ADDITIONS_LAST_STYLE) == 0 ? "additions-end" : "additions";
	    String key = "ui-actions";
	    if (hideResourceAdaptersAction != null)
	    	menuManager.insertAfter(key, new ActionContributionItem(hideResourceAdaptersAction));
//	    if (testGlobalAction != null)
//	    	menuManager.insertBefore(key, new ActionContributionItem(testGlobalAction));
	}
	
	@Override public void contributeToMenu(IMenuManager manager) {
		super.contributeToMenu(manager);
		IMenuManager menu = new MenuManager("Editor &Menu");
		manager.prependToGroup(IWorkbenchActionConstants.MB_ADDITIONS, menu);
//		System.out.println(getClass().getSimpleName() + ".contributeToMenu: add test actions to " + manager.toString());
//		menu.add(testMenuAction);
	}

	
	@Override public void contributeToStatusLine(IStatusLineManager statusLineManager) {
		super.contributeToStatusLine(statusLineManager);
		for (int i= 0; i < STATUS_FIELD_DEFS.length; i++)
			statusLineManager.add(fStatusFields.get(STATUS_FIELD_DEFS[i]));
	}
	
	@Override public void contributeToToolBar(IToolBarManager manager) {
		super.contributeToToolBar(manager);
		manager.add(new Separator());
//		System.out.println(getClass().getSimpleName() + ".contributeToToolBar: add test actions to " + manager.toString());
//		manager.add(testToolBarAction);
	}
	
	/**
	 * Returns the action registed with the given text editor.
	 * @return IAction or null if editor is null.
	 */
//	protected IAction getAction(ITextEditor editor, String actionID) {
//		return (editor == null ? null : editor.getAction(actionID));
//	}

	public HideResourceAdaptersAction getHideResourceAdaptersAction() {
		return hideResourceAdaptersAction;
	}

	public IAction getSharedAction(String actionId) {
		return sharedActions.get(actionId);
	}
	
	@Override public void init(IActionBars actionBars) {
		super.init(actionBars);

	    ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();
	    
		// override the superclass implementation of these actions
	    undoAction = new UndoActionWrapper();
	    undoAction.setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_UNDO));
	    actionBars.setGlobalActionHandler(ActionFactory.UNDO.getId(), undoAction);

	    redoAction = new RedoActionWrapper();
	    redoAction.setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_REDO));
	    actionBars.setGlobalActionHandler(ActionFactory.REDO.getId(), redoAction);
	    
	    sharedActions.put(ActionFactory.DELETE.getId(), deleteAction);
	    sharedActions.put(ActionFactory.CUT.getId(), cutAction);
	    sharedActions.put(ActionFactory.COPY.getId(), copyAction);
	    sharedActions.put(ActionFactory.PASTE.getId(), pasteAction);
	    sharedActions.put(ActionFactory.UNDO.getId(), undoAction);
	    sharedActions.put(ActionFactory.REDO.getId(), redoAction);
	}
	
	@Override public void setActiveEditor(IEditorPart part) {
//		System.out.println(getClass().getSimpleName() + ".setActiveEditor " + String.valueOf(part));
		super.setActiveEditor(part);
	}

	@Override public void setActivePage(IEditorPart part) {
//		System.out.println(getClass().getSimpleName() + ".setActivePage " + String.valueOf(part));
		if (activeEditorPart == part)
			return;
		activeEditorPart = part;
		IActionBars actionBars = getActionBars();
		IPageManager pageManager = CoreUtils.getAdapter(part, IPageManager.class);
		if ((actionBars != null) && (pageManager != null)) {
			if (activeEditorPart instanceof ITextEditorExtension) {
				ITextEditorExtension extension = (ITextEditorExtension) activeEditorPart;
				for (int i= 0; i < STATUS_FIELD_DEFS.length; i++)
					extension.setStatusField(null, STATUS_FIELD_DEFS[i].category);
			}
			setGlobalAction(actionBars, pageManager, ActionFactory.DELETE.getId());
			setGlobalAction(actionBars, pageManager, ActionFactory.UNDO.getId());
			setGlobalAction(actionBars, pageManager, ActionFactory.REDO.getId());
			setGlobalAction(actionBars, pageManager, ActionFactory.CUT.getId());
			setGlobalAction(actionBars, pageManager, ActionFactory.COPY.getId());
			setGlobalAction(actionBars, pageManager, ActionFactory.PASTE.getId());
			setGlobalAction(actionBars, pageManager, ActionFactory.SELECT_ALL.getId());
			setGlobalAction(actionBars, pageManager, ActionFactory.FIND.getId());
			setGlobalAction(actionBars, pageManager, ActionFactory.PROPERTIES.getId());
			setGlobalAction(actionBars, pageManager, ActionFactory.PRINT.getId());
			setGlobalAction(actionBars, pageManager, IDEActionFactory.BOOKMARK.getId());
//			System.out.println("setActivePage: set global test actions to " + actionBars.toString());
//			actionBars.setGlobalActionHandler("TestActionBarAction", testActionBarAction);
			actionBars.updateActionBars();			
			for (int i= 0; i < STATUS_FIELD_DEFS.length; i++) {
				if (activeEditorPart instanceof ITextEditorExtension) {
					StatusLineContributionItem statusField= fStatusFields.get(STATUS_FIELD_DEFS[i]);
					if (STATUS_FIELD_DEFS[i].actionId != null)
						statusField.setActionHandler(pageManager.getAction(STATUS_FIELD_DEFS[i].actionId));
					ITextEditorExtension extension= (ITextEditorExtension) activeEditorPart;
					extension.setStatusField(statusField, STATUS_FIELD_DEFS[i].category);
				}
			}
		}
	}
	
	protected void setGlobalAction(IActionBars actionBars, IPageManager pageManager, String actionId) {
		IAction action = null;
		if (pageManager != null)
			action = pageManager.getAction(actionId);
		else
			action = getSharedAction(actionId);
		actionBars.setGlobalActionHandler(actionId, action);
	}
}
