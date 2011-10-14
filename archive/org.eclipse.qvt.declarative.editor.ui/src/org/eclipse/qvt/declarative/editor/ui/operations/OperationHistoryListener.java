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
package org.eclipse.qvt.declarative.editor.ui.operations;

import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IOperationHistoryListener;
import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.commands.operations.ObjectUndoContext;
import org.eclipse.core.commands.operations.OperationHistoryEvent;
import org.eclipse.qvt.declarative.ecore.utils.TracingOption;
import org.eclipse.qvt.declarative.editor.ui.IUndoableOperationHelper;
import org.eclipse.qvt.declarative.editor.ui.QVTEditorPlugin;
import org.eclipse.qvt.declarative.editor.ui.paged.PagedEditor;

/**
 * Maintains the isDirty cached state.
 * Ensures all operations have the paged undo context.
 * Ensures all operations have command specific undo context(s)
 */
public abstract class OperationHistoryListener implements IOperationHistoryListener
{		
	public static TracingOption showApplicableOperation = new TracingOption(QVTEditorPlugin.PLUGIN_ID, "operation/show/applicable");
	public static TracingOption showInapplicableOperation = new TracingOption(QVTEditorPlugin.PLUGIN_ID, "operation/show/inapplicable");
	public static TracingOption showDirty = new TracingOption(QVTEditorPlugin.PLUGIN_ID, "operation/show/dirty");

	public static String getEventTypeString(OperationHistoryEvent event) {
		switch (event.getEventType()) {
			case OperationHistoryEvent.ABOUT_TO_EXECUTE: return "ABOUT_TO_EXECUTE";
			case OperationHistoryEvent.ABOUT_TO_UNDO: return "ABOUT_TO_UNDO";
			case OperationHistoryEvent.OPERATION_CHANGED: return "OPERATION_CHANGED";
			case OperationHistoryEvent.OPERATION_NOT_OK: return "OPERATION_NOT_OK";
			case OperationHistoryEvent.OPERATION_ADDED:	return "OPERATION_ADDED";
			case OperationHistoryEvent.ABOUT_TO_REDO: return "ABOUT_TO_REDO";
			case OperationHistoryEvent.OPERATION_REMOVED: return "OPERATION_REMOVED";
			case OperationHistoryEvent.UNDONE: return "UNDONE";
			case OperationHistoryEvent.DONE: return "DONE";
			case OperationHistoryEvent.REDONE: return "REDONE";
			default: return "UNKNOWN";
		}
	}

	public static String getOperationString(OperationHistoryEvent event) {
		final IUndoableOperation operation = event.getOperation();
		StringBuilder s = new StringBuilder();
		s.append(getEventTypeString(event));
		s.append(" '");
		s.append(operation.getLabel());
		String separator = "' ";
		for (IUndoContext undoContext : operation.getContexts()) {
			s.append(separator);
			s.append("[");
			s.append(undoContext.toString());
			s.append("]");
			separator = "+";
		}
		String operationText = s.toString();
		return operationText;
	}

	/**
	 * Helper to facilitate use of IUndoableOperations.
	 */
	protected IUndoableOperationHelper undoableOperationHelper = new AbstractUndoableOperationHelper();
	
	protected final PagedEditor pagedEditor;
	protected final ObjectUndoContext undoContext;
	
	/**
	 * True if any operation on the OperationHistory is not non-dirtying.
	 */
	private boolean isDirty = false;
	
	/**
	 * True if any operation on the OperationHistory since the most recent PageChangeCommand is not non-dirtying.
	 */
	private boolean isDirtyPage = false;

	public OperationHistoryListener(PagedEditor pagedEditor) {
		this.pagedEditor = pagedEditor;
		this.undoableOperationHelper = createUndoableOperationHelper();
		this.undoContext = createUndoContext();
	}
	
	protected ObjectUndoContext createUndoContext() {
		return new ObjectUndoContext(pagedEditor, pagedEditor.toString());
	}

	protected IUndoableOperationHelper createUndoableOperationHelper() {
		return new AbstractUndoableOperationHelper();
	}
	
	public ObjectUndoContext getUndoContext() {
		return undoContext;
	}

	public void historyNotification(OperationHistoryEvent event) {
		IUndoableOperation operation = event.getOperation();
		if (!operation.hasContext(undoContext)) {
			if (showInapplicableOperation.isActive())
				showInapplicableOperation.println(pagedEditor.toString() + " " + getOperationString(event));
			return;
		}
		else if (showApplicableOperation.isActive())
			showApplicableOperation.println(getOperationString(event));
		switch (event.getEventType()) {
			case OperationHistoryEvent.ABOUT_TO_EXECUTE:
			case OperationHistoryEvent.ABOUT_TO_UNDO:
			case OperationHistoryEvent.OPERATION_CHANGED:
			case OperationHistoryEvent.OPERATION_NOT_OK:
				break;
			case OperationHistoryEvent.OPERATION_ADDED:			// 'Typing' gets added then updated
			case OperationHistoryEvent.ABOUT_TO_REDO:			// 'Typing' gets reactivated then updated
				if (!isDirtyPage && undoableOperationHelper.isDirty(operation))
					setDirtyPage();
				break;
			case OperationHistoryEvent.OPERATION_REMOVED:
			case OperationHistoryEvent.UNDONE:
				if (isDirty && undoableOperationHelper.isDirty(operation))
					refreshDirty(event);
				else if (isDirtyPage && undoableOperationHelper.isPageChange(operation))
					refreshDirty(event);
				break;
			case OperationHistoryEvent.DONE:
			case OperationHistoryEvent.REDONE:
//				Set<?> affectedResources = ResourceUndoContext.getAffectedResources(operation);				
//				if (affectedResources.contains(getResource())) {
//				if (!affectedResources.isEmpty())
					setDone(operation);
				if (isDirty && undoableOperationHelper.isPageSave(operation))
					resetDirty();
				else if (isDirtyPage && undoableOperationHelper.isPageChange(operation))
					resetDirtyPage();
				break;				
		}
	}

	public boolean isDirty() {
		return isDirty;
	}

	public boolean isDirtyPage() {
		return isDirtyPage;
	}

	protected void refreshDirty(OperationHistoryEvent event) {
		boolean stillDirty = false;
		boolean gotPageCommand = false;
		IOperationHistory operationHistory = event.getHistory();
		IUndoableOperation[] operations = operationHistory.getUndoHistory(getUndoContext());
		for (int i = operations.length; --i >= 0; ) {
			IUndoableOperation op = operations[i];
			if (undoableOperationHelper.isPageSave(op))
				break;
			if (undoableOperationHelper.isPageChange(op))
				gotPageCommand = true;
			if (!op.canUndo() || undoableOperationHelper.isDirty(op)) {
				stillDirty = true;
				break;
			}
		}
		if (!stillDirty)
			resetDirty();
		else if (gotPageCommand)
			resetDirtyPage();
	}
	
	protected void resetDirty() {
		if (isDirty && showDirty.isActive())
			showDirty.println(pagedEditor.toString() + " resetDirty");
		isDirty = false;
		isDirtyPage = false;			// Necessary corrolary
	}
	
	protected void resetDirtyPage() {
		isDirtyPage = false;
	}
	
//	protected void setDirty() {
//		isDirty = true;
//	}
	
	protected void setDirtyPage() {
		if (!isDirty && showDirty.isActive())
			showDirty.println(pagedEditor.toString() + " setDirty");
		isDirty = true;					// Necessary corrolary
		isDirtyPage = true;
	}
	
	protected void setDone(IUndoableOperation operation) {}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "(" + String.valueOf(pagedEditor) + ")";
	}
}