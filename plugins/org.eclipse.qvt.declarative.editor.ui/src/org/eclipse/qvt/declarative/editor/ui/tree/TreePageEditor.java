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
package org.eclipse.qvt.declarative.editor.ui.tree;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.ui.MarkerHelper;
import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.ui.dnd.EditingDomainViewerDropAdapter;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.emf.edit.ui.dnd.ViewerDragAdapter;
import org.eclipse.emf.edit.ui.provider.UnwrappingSelectionProvider;
import org.eclipse.emf.edit.ui.util.EditUIMarkerHelper;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.qvt.declarative.editor.ui.IPageManager;
import org.eclipse.qvt.declarative.editor.ui.QVTEditorPlugin;
import org.eclipse.qvt.declarative.editor.ui.paged.PagedEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.ui.part.FileEditorInput;

/**
 * The ResourceSetEditor is based on EcoreEditor, but edited to change it from a standalone MultiPageEditorPart
 * to an EditorPart component.
 * 
 * FIXME Strip out more obsolete multi-page functionality.
 */
public class TreePageEditor extends EditorPart implements
		IEditingDomainProvider, IMenuListener, IViewerProvider
{
	public static final String ECORE_FILE_EXTENSION = "ecore";
	public static final String EMOF_FILE_EXTENSION = "emof";

	/**
	 * This looks up a string in the plugin's plugin.properties file.
	 */
	private static String getString(String key) {
		return QVTEditorPlugin.INSTANCE.getString(key);
	}

	/**
	 * This looks up a string in plugin.properties, making a substitution.
	 */
	private static String getString(String key, Object s1) {
		return QVTEditorPlugin.INSTANCE.getString(key, new Object[] { s1 });
	}

	/**
	 * This is the viewer that shadows the selection in the content outline. The
	 * parent relation must be correctly defined for this to work.
	 */
	protected TreeViewer selectionViewer;

	/**
	 * The MarkerHelper is responsible for creating workspace resource markers
	 * presented in Eclipse's Problems View.
	 */
	protected MarkerHelper markerHelper = new EditUIMarkerHelper();

	
	
	
	protected final IPageManager pageManager;
	
	

	/**
	 * Resources that have been removed since last activation.
	 */
	protected Collection<Resource> removedResources = new ArrayList<Resource>();

	/**
	 * Resources that have been changed since last activation.
	 */
	protected Collection<Resource> changedResources = new ArrayList<Resource>();

	/**
	 * Resources that have been saved.
	 */
	protected Collection<Resource> savedResources = new ArrayList<Resource>();

	/**
	 * Map to store the diagnostic associated with a resource.
	 */
	protected Map<Resource, Diagnostic> resourceToDiagnosticMap = new LinkedHashMap<Resource, Diagnostic>();

	/**
	 * Controls whether the problem indication should be updated.
	 */
//	protected boolean updateProblemIndication = true;

	/**
	 * Adapter used to update the problem indication when resources are demanded
	 * loaded.
	 */
	protected EContentAdapter problemIndicationAdapter = new EContentAdapter() {
		@Override
		public void notifyChanged(Notification notification) {
			if (notification.getNotifier() instanceof Resource) {
				switch (notification.getFeatureID(Resource.class)) {
				case Resource.RESOURCE__IS_LOADED:
				case Resource.RESOURCE__ERRORS:
				case Resource.RESOURCE__WARNINGS: {
					Resource resource = (Resource) notification.getNotifier();
					Diagnostic diagnostic = analyzeResourceProblems(resource,
							null);
					if (diagnostic.getSeverity() != Diagnostic.OK) {
						resourceToDiagnosticMap.put(resource, diagnostic);
					} else {
						resourceToDiagnosticMap.remove(resource);
					}

/*					if (updateProblemIndication) {
						getSite().getShell().getDisplay().asyncExec(
								new Runnable() {
									public void run() {
										updateProblemIndication();
									}
								});
					} */
					break;
				}
				}
			} else {
				super.notifyChanged(notification);
			}
		}

		@Override
		protected void setTarget(Resource target) {
			basicSetTarget(target);
		}

		@Override
		protected void unsetTarget(Resource target) {
			basicUnsetTarget(target);
		}
	};

	/**
	 * This creates a model editor.
	 */
	public TreePageEditor(IPageManager pageManager) {
		this.pageManager = pageManager;
	}

	/**
	 * Returns a diagnostic describing the errors and warnings listed in the
	 * resource and the specified exception (if any).
	 */
	public Diagnostic analyzeResourceProblems(Resource resource,
			Exception exception) {
		if (!resource.getErrors().isEmpty()
				|| !resource.getWarnings().isEmpty()) {
			BasicDiagnostic basicDiagnostic = new BasicDiagnostic(
					Diagnostic.ERROR,
					"org.eclipse.emf.ecore.editor",
					0,
					getString("_UI_CreateModelError_message", resource.getURI()),
					new Object[] { exception == null ? (Object) resource
							: exception });
			basicDiagnostic.merge(EcoreUtil.computeDiagnostic(resource, true));
			return basicDiagnostic;
		} else if (exception != null) {
			return new BasicDiagnostic(Diagnostic.ERROR,
					"org.eclipse.emf.ecore.editor", 0, getString(
							"_UI_CreateModelError_message", resource.getURI()),
					new Object[] { exception });
		} else {
			return Diagnostic.OK_INSTANCE;
		}
	}

	protected void createContextMenuFor(StructuredViewer viewer) {
		createContextMenuForGen(viewer);

		viewer.getControl().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent event) {
				if (event.button == 1) {
					try {
						getEditorSite().getPage().showView(
								"org.eclipse.ui.views.PropertySheet");
					} catch (PartInitException exception) {
						QVTEditorPlugin.INSTANCE.log(exception);
					}
				}
			}
		});
	}

	/**
	 * This creates a context menu for the viewer and adds a listener as well
	 * registering the menu for extension.
	 */
	protected void createContextMenuForGen(StructuredViewer viewer) {
		MenuManager contextMenu = new MenuManager("#PopUp");
		contextMenu.add(new Separator("additions"));
		contextMenu.setRemoveAllWhenShown(true);
		contextMenu.addMenuListener(this);
		Menu menu = contextMenu.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(contextMenu,
				new UnwrappingSelectionProvider(viewer));

		int dndOperations = DND.DROP_COPY | DND.DROP_MOVE | DND.DROP_LINK;
		Transfer[] transfers = new Transfer[] { LocalTransfer.getInstance() };
		viewer.addDragSupport(dndOperations, transfers, new ViewerDragAdapter(
				viewer));
		viewer.addDropSupport(dndOperations, transfers,
				new EditingDomainViewerDropAdapter(getEditingDomain(), viewer));
	}

	@Override
	public void createPartControl(Composite parent) {
		// Create a page for the selection tree view.
		//
		Tree tree = new Tree(parent, SWT.MULTI);
		selectionViewer = new TreeViewer(tree);
		getPagedEditor().initializeTreeViewer(selectionViewer);
		createContextMenuFor(selectionViewer);

//		updateProblemIndication();
	}

	/**
	 */
	@Override
	public void dispose() {
//		updateProblemIndication = false;

//		if (getActionBarContributor().getActiveEditor() == this) {
//			getActionBarContributor().setActiveEditor(null);
//		}

		super.dispose();
	}
	
	/**
	 * This is for implementing {@link IEditorPart} and simply saves the model
	 * file.
	 */
	@Override
	public void doSave(IProgressMonitor progressMonitor) {
		// Save only resources that have actually changed.
		//
		final Map<Object, Object> saveOptions = new HashMap<Object, Object>();
		saveOptions.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED,
				Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);

		// Do the work within an operation because this is a long running
		// activity that modifies the workbench.
		//
		WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {	// FIXME Transactional
			// This is the method that gets invoked when the operation runs.
			//
			@Override
			public void execute(IProgressMonitor monitor) {
				// Save the resources to the file system.
				//
				boolean first = true;
				for (Resource resource : getResourceSet().getResources()) {
					if ((first || !resource.getContents().isEmpty() || isPersisted(resource))
							&& !getEditingDomain().isReadOnly(resource)) {
						try {
							savedResources.add(resource);
							resource.save(saveOptions);
						} catch (Exception exception) {
							resourceToDiagnosticMap
									.put(resource, analyzeResourceProblems(
											resource, exception));
						}
						first = false;
					}
				}
			}
		};

//		updateProblemIndication = false;
		try {
			// This runs the options, and shows progress.
			//
			new ProgressMonitorDialog(getSite().getShell()).run(true, false,
					operation);

			// Refresh the necessary state.
			//
			((BasicCommandStack) getEditingDomain().getCommandStack()).saveIsDone();
			firePropertyChange(IEditorPart.PROP_DIRTY);
		} catch (Exception exception) {
			// Something went wrong that shouldn't.
			//
			QVTEditorPlugin.INSTANCE.log(exception);
		}
//		updateProblemIndication = true;
//		updateProblemIndication();
	}

	/**
	 * This also changes the editor's input.
	 */
	@Override
	public void doSaveAs() {
		SaveAsDialog saveAsDialog = new SaveAsDialog(getSite().getShell());
		saveAsDialog.open();
		IPath path = saveAsDialog.getResult();
		if (path != null) {
			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
			if (file != null) {
				ResourceSet resourceSet = getResourceSet();
				Resource currentResource = resourceSet.getResources().get(0);
				String currentExtension = currentResource.getURI()
						.fileExtension();

				URI newURI = URI.createPlatformResourceURI(file.getFullPath()
						.toString(), true);
				String newExtension = newURI.fileExtension();

				if (currentExtension.equals(ECORE_FILE_EXTENSION)
						&& newExtension.equals(EMOF_FILE_EXTENSION)
						|| currentExtension.equals(EMOF_FILE_EXTENSION)
						&& newExtension.equals(ECORE_FILE_EXTENSION)) {
					Resource newResource = resourceSet.createResource(newURI);
					newResource.getContents().addAll(
							currentResource.getContents());
					resourceSet.getResources().remove(0);
					resourceSet.getResources().move(0, newResource);
				} else {
					currentResource.setURI(newURI);
				}

				IFileEditorInput modelFile = new FileEditorInput(file);
				setInputWithNotify(modelFile);
				setPartName(file.getName());
//				doSave(getActionBars().getStatusLineManager()
//						.getProgressMonitor());
			}
		}
	}

	/**
	 */
	protected void doSaveAs(URI uri, IEditorInput editorInput) {
		(getResourceSet().getResources().get(0)).setURI(uri);
		setInputWithNotify(editorInput);
		setPartName(editorInput.getName());
		IProgressMonitor progressMonitor = /*getActionBars()
				.getStatusLineManager() != null ? getActionBars()
				.getStatusLineManager().getProgressMonitor()
				:*/ new NullProgressMonitor();
		doSave(progressMonitor);
	}

	/**
	 * This is here for the listener to be able to call it.
	 */
	@Override
	protected void firePropertyChange(int action) {
		super.firePropertyChange(action);
	}


	@SuppressWarnings("rawtypes")
	@Override
	public Object getAdapter(Class key) {
		if (key.equals(IPageManager.class))
			return pageManager;
		if (key.equals(IUndoContext.class))
			return getPagedEditor().getUndoContext();
		return super.getAdapter(key);
	}

	/**
	 */
	public AdapterFactory getAdapterFactory() {
		return getPagedEditor().getAdapterFactory();
	}

	/**
	 * This returns the editing domain as required by the
	 * {@link IEditingDomainProvider} interface. This is important for
	 * implementing the static methods of {@link AdapterFactoryEditingDomain}
	 * and for supporting {@link org.eclipse.emf.edit.ui.action.CommandAction}.
	 */
	public AdapterFactoryEditingDomain getEditingDomain() {
		return getPagedEditor().getAdapterFactoryEditingDomain();
	}

	public PagedEditor getPagedEditor() {
		return pageManager.getPagedEditor();
	}

	public ResourceSet getResourceSet() {
		return getPagedEditor().getResourceSet();
	}

	/**
	 * This returns the viewer as required by the {@link IViewerProvider}
	 * interface.
	 */
	public Viewer getViewer() {
		return selectionViewer;
	}

	/**
	 * Handles activation of the editor or it's associated views.
	 */
/*	protected void handleActivate() {
		// Recompute the read only state.
		//
		if (getEditingDomain().getResourceToReadOnlyMap() != null) {
			getEditingDomain().getResourceToReadOnlyMap().clear();

			// Refresh any actions that may become enabled or disabled.
			//
//			setSelection(getSelection());
		}

		if (!removedResources.isEmpty()) {
			if (handleDirtyConflict()) {
				getSite().getPage().closeEditor(ResourceSetEditor.this, false);
			} else {
				removedResources.clear();
				changedResources.clear();
				savedResources.clear();
			}
		} else if (!changedResources.isEmpty()) {
			changedResources.removeAll(savedResources);
			handleChangedResources();
			changedResources.clear();
			savedResources.clear();
		}
	} */

	/**
	 * Handles what to do with changed resources on activation.
	 */
	protected void handleChangedResources() {
		if (!changedResources.isEmpty()
				&& (!isDirty() || handleDirtyConflict())) {
			getEditingDomain().getCommandStack().flush();

//			updateProblemIndication = false;
			for (Resource resource : changedResources) {
				if (resource.isLoaded()) {
					resource.unload();
					try {
						resource.load(Collections.EMPTY_MAP);
					} catch (IOException exception) {
						if (!resourceToDiagnosticMap.containsKey(resource)) {
							resourceToDiagnosticMap
									.put(resource, analyzeResourceProblems(
											resource, exception));
						}
					}
				}
			}
//			updateProblemIndication = true;
//			updateProblemIndication();
		}
	}

	/**
	 * Shows a dialog that asks if conflicting changes should be discarded.
	 */
	protected boolean handleDirtyConflict() {
		return MessageDialog.openQuestion(getSite().getShell(),
				getString("_UI_FileConflict_label"),
				getString("_WARN_FileConflict"));
	}

	/**
	 */
	@Override
	public void init(IEditorSite site, IEditorInput editorInput) {
		setSite(site);
		setInputWithNotify(editorInput);
		setPartName(editorInput.getName());
	}

	/**
	 * This is for implementing {@link IEditorPart} and simply tests the command
	 * stack.
	 */
	@Override
	public boolean isDirty() {
		return ((BasicCommandStack) getEditingDomain().getCommandStack()).isSaveNeeded();
	}


	/**
	 * This returns whether something has been persisted to the URI of the
	 * specified resource. The implementation uses the URI converter from the
	 * editor's resource set to try to open an input stream.
	 */
	protected boolean isPersisted(Resource resource) {
		boolean result = false;
		try {
			InputStream stream = getResourceSet()
					.getURIConverter().createInputStream(resource.getURI());
			if (stream != null) {
				result = true;
				stream.close();
			}
		} catch (IOException e) {
			// Ignore
		}
		return result;
	}

	/**
	 * This always returns true because it is not currently supported.
	 */
	@Override
	public boolean isSaveAsAllowed() {
		return true;
	}

	/**
	 * This implements {@link org.eclipse.jface.action.IMenuListener} to help
	 * fill the context menus with contributions from the Edit menu.
	 */
	public void menuAboutToShow(IMenuManager menuManager) {
		getPagedEditor().getActionBarContributor().menuAboutToShow(menuManager);
	}

	/**
	 */
	@Override
	public void setFocus() {
		selectionViewer.getControl().setFocus();
	}

	/**
	 * This sets the selection into whichever viewer is active.
	 */
/*	public void setSelectionToViewer(Collection<?> collection) {
		final Collection<?> theSelection = collection;
		// Make sure it's okay.
		//
		if (theSelection != null && !theSelection.isEmpty()) {
			// I don't know if this should be run this deferred
			// because we might have to give the editor a chance to process the
			// viewer update events
			// and hence to update the views first.
			//
			//
			Runnable runnable = new Runnable() {
				public void run() {
					// Try to select the items in the current content viewer of
					// the editor.
					//
					selectionViewer.setSelection(new StructuredSelection(
									theSelection.toArray()), true);
//					}
				}
			};
			runnable.run();
		}
	} */

	@Override public String toString() {
		return getClass().getSimpleName() + " " + String.valueOf(((IFileEditorInput)getEditorInput()).getFile());
	}
}
