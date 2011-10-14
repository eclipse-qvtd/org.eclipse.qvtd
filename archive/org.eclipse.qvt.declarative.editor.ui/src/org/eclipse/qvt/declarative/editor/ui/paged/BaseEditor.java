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
package org.eclipse.qvt.declarative.editor.ui.paged;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.ui.MarkerHelper;
import org.eclipse.emf.common.ui.editor.ProblemEditorPart;
import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.dnd.EditingDomainViewerDropAdapter;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.emf.edit.ui.dnd.ViewerDragAdapter;
import org.eclipse.emf.edit.ui.provider.UnwrappingSelectionProvider;
import org.eclipse.emf.edit.ui.util.EditUIMarkerHelper;
import org.eclipse.emf.transaction.impl.AbstractTransactionalCommandStack;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.qvt.declarative.editor.ui.QVTEditorPlugin;
import org.eclipse.qvt.declarative.editor.ui.text.TextResource;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.MultiPageEditorPart;

/**
 * BaseEditor is based on EcoreEditor but trimmed to retain only the multi-page support.
 */
public abstract class BaseEditor
extends MultiPageEditorPart
implements /*ISelectionProvider,*/ IMenuListener, IViewerProvider
{

	private final class DoubleClickListener extends MouseAdapter
	{
		@Override
		public void mouseDoubleClick(MouseEvent event) {
			if (event.button == 1) {
				try {
					getEditorSite().getPage().showView("org.eclipse.ui.views.PropertySheet");
				} catch (PartInitException exception) {
					QVTEditorPlugin.INSTANCE.log(exception);
				}
			}
		}
	}

	private final class ProblemIndicationAdapter extends EContentAdapter
	{

		@Override
		public void notifyChanged(Notification notification)
		{
			if (notification.getNotifier() instanceof Resource)
			{
				switch (notification.getFeatureID(Resource.class))
				{
				case Resource.RESOURCE__IS_LOADED:
				case Resource.RESOURCE__ERRORS:
				case Resource.RESOURCE__WARNINGS:
				{
					Resource resource = (Resource)notification.getNotifier();
					Diagnostic diagnostic = analyzeResourceProblems(resource, null);
					if (diagnostic.getSeverity() != Diagnostic.OK)
						resourceToDiagnosticMap.put(resource, diagnostic);
					else
						resourceToDiagnosticMap.remove(resource);
					if (updateProblemIndication) {
						getDisplay().asyncExec(new UpdateProblemIndicationRunnable());
					}
					break;
				}
				}
			}
			else
			{
				super.notifyChanged(notification);
			}
		}

		@Override
		protected void setTarget(Resource target)
		{
			basicSetTarget(target);
		}

		@Override
		protected void unsetTarget(Resource target)
		{
			basicUnsetTarget(target);
		}
	}

	private class ResourceDeltaVisitor implements IResourceDeltaVisitor
	{
		protected ResourceSet resourceSet = getResourceSet();
		protected Collection<Resource> changedResources = new ArrayList<Resource>();
		protected Map<Resource, IPath> refactoredResources = new HashMap<Resource, IPath>();

		public boolean visit(IResourceDelta delta) {
				if (delta.getResource().getType() == IResource.FILE) {
				int flags = delta.getFlags();
				int kind = delta.getKind();
				if ((kind & IResourceDelta.REMOVED) != 0) {  // Deleted or renamed
					URI uri = URI.createURI(delta.getFullPath().toString(), true);		// See Bugzilla 236362
						Resource resource = resourceSet.getResource(uri, false);
						if (resource != null) {
								if (QVTEditorPlugin.EDITOR_SAVE.isActive())
									QVTEditorPlugin.EDITOR_SAVE.println(getClass(), "Removed " + resource.getURI().toString());
						refactoredResources.put(resource, delta.getMovedToPath());
					}
				}
				else if (((kind & IResourceDelta.CHANGED) != 0) && ((flags & ~IResourceDelta.MARKERS) != 0)) {
					URI uri = URI.createURI(delta.getFullPath().toString(), true);		// See Bugzilla 236362
					Resource resource = resourceSet.getResource(uri, false);
					if (resource != null) {
						if ((resource instanceof TextResource) && (((TextResource)resource).isSaveInProgress()))
							;
						else if (!savedResources.remove(resource)) {
								if (QVTEditorPlugin.EDITOR_SAVE.isActive())
									QVTEditorPlugin.EDITOR_SAVE.println(getClass(), "Changed " + resource.getURI().toString());
								changedResources.add(resource);
							} else {
								if (QVTEditorPlugin.EDITOR_SAVE.isActive())
									QVTEditorPlugin.EDITOR_SAVE.println(getClass(), "Saved " + resource.getURI().toString());
							}
						}
					}
				}
			return true;
		}

		private Collection<Resource> getChangedResources() {
			return changedResources;
		}

		private Map<Resource, IPath> getRefactoredResources() {
			return refactoredResources;
		}
	}

	private final class ResourceChangeListener implements IResourceChangeListener
	{
		public void resourceChanged(IResourceChangeEvent event) {
			// Only listening to these.
			// if (event.getType() == IResourceDelta.POST_CHANGE)
			{
				IResourceDelta delta = event.getDelta();
				try {
					ResourceDeltaVisitor visitor = new ResourceDeltaVisitor();
					delta.accept(visitor);
					Map<Resource, IPath> refactoredResources = visitor.getRefactoredResources();
					if (!refactoredResources.isEmpty()) {
						if (QVTEditorPlugin.EDITOR_SAVE.isActive())
							for (Resource removedResource : refactoredResources.keySet())
								QVTEditorPlugin.EDITOR_SAVE.println(getClass(), "Removed " + removedResource.getURI().toString());
						removedResources.addAll(refactoredResources.keySet());
						if (!isDirty())
							getDisplay().asyncExec(new ResourceRemovedRunnable());
						else {
							for (Resource removedResource : refactoredResources.keySet()) {
								if (removedResource instanceof TextResource) {
									IPath path = refactoredResources.get(removedResource);
									if (path != null)
										getDisplay().asyncExec(new ResourceRenamedRunnable(path));
								}
							}
						}
					}
					if (!visitor.getChangedResources().isEmpty()) {
						if (QVTEditorPlugin.EDITOR_SAVE.isActive())
							for (Resource changedResource : visitor.getChangedResources())
								QVTEditorPlugin.EDITOR_SAVE.println(getClass(), "Changed " + changedResource.getURI().toString());
						changedResources.addAll(visitor.getChangedResources());
						if (getSite().getPage().getActiveEditor() == BaseEditor.this) {
							getDisplay().asyncExec(new ResourceChangedRunnable());
						}
					}
				} catch (CoreException exception) {
					QVTEditorPlugin.INSTANCE.log(exception);
				}
			}
		}
	}

	private final class ResourceChangedRunnable implements Runnable
	{
		public void run() {
			if (QVTEditorPlugin.EDITOR_SAVE.isActive())
				QVTEditorPlugin.EDITOR_SAVE.println(getClass(), "run");
			handleActivate();
		}
	}

	private final class ResourceRemovedRunnable implements Runnable
	{
		public void run() {
			if (QVTEditorPlugin.EDITOR_SAVE.isActive())
				QVTEditorPlugin.EDITOR_SAVE.println(getClass(), "run");
			getSite().getPage().closeEditor(BaseEditor.this, false);
		}
	}

	private final class ResourceRenamedRunnable implements Runnable
	{
		private IPath path;
		
		public ResourceRenamedRunnable(IPath path) {
			this.path = path;
		}

		public void run() {
			setPartName(path.lastSegment());
		}
	}

	private final class SaveOperation1 extends WorkspaceModifyOperation
	{
		private final Map<Object, Object> saveOptions;

		private SaveOperation1(Map<Object, Object> saveOptions) {
			this.saveOptions = saveOptions;
		}

		// This is the method that gets invoked when the operation runs.
		//
		@Override
		public void execute(IProgressMonitor monitor)
		{
			suspendResourceListening();
			// Save the resources to the file system.
			//
			boolean first = true;
			for (Resource resource : getResourceSet().getResources())
			{
				if ((first || !resource.getContents().isEmpty() || isPersisted(resource)) && !getEditingDomain().isReadOnly(resource))
				{
					try
					{
						savingResources.add(resource);
						savedResources.add(resource);
						if (QVTEditorPlugin.EDITOR_SAVE.isActive())
							QVTEditorPlugin.EDITOR_SAVE.println(getClass(), "Save " + resource.getURI().toString());
						resource.save(saveOptions);
					}
					catch (Exception exception)
					{
						resourceToDiagnosticMap.put(resource, analyzeResourceProblems(resource, exception));
					} finally {
						if (QVTEditorPlugin.EDITOR_SAVE.isActive())
							QVTEditorPlugin.EDITOR_SAVE.println(getClass(), "Saved all");
					}
					first = false;
				}
			}
		}
	}

	private final class SaveOperation2 extends WorkspaceModifyOperation
	{
		private SaveOperation2() {}

		// This is the method that gets invoked when the operation runs.
		//
		@Override
		public void execute(IProgressMonitor monitor)
		{
			resumeResourceListening();
			if (QVTEditorPlugin.EDITOR_SAVE.isActive())
				QVTEditorPlugin.EDITOR_SAVE.println(getClass(), "Saved all2");
		}
	}

	private final class UpdateProblemIndicationRunnable implements Runnable
	{
		public void run()
		{
			updateProblemIndication();
		}
	}

	public static final String ECORE_FILE_EXTENSION = "ecore";
	public static final String EMOF_FILE_EXTENSION = "emof";

	/**
	 * The MarkerHelper is responsible for creating workspace resource markers presented
	 * in Eclipse's Problems View.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MarkerHelper markerHelper = new EditUIMarkerHelper();

	/**
	 * Resources that have been removed since last activation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private Collection<Resource> removedResources = new ArrayList<Resource>();

	/**
	 * Resources that have been changed since last activation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private Collection<Resource> changedResources = new ArrayList<Resource>();

	/**
	 * Resources that have been saved.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private Collection<Resource> savedResources = new ArrayList<Resource>();

	/**
	 * Resources that have been saved.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private Collection<Resource> savingResources = new ArrayList<Resource>();

	/**
	 * Map to store the diagnostic associated with a resource.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Map<Resource, Diagnostic> resourceToDiagnosticMap = new LinkedHashMap<Resource, Diagnostic>();

	/**
	 * Controls whether the problem indication should be updated.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected boolean updateProblemIndication = true;

	/**
	 * Adapter used to update the problem indication when resources are demanded loaded.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EContentAdapter problemIndicationAdapter = new ProblemIndicationAdapter();

	/**
	 * This listens for workspace changes.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IResourceChangeListener resourceChangeListener = new ResourceChangeListener();

	/**
	 * Returns a diagnostic describing the errors and warnings listed in the resource
	 * and the specified exception (if any).
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Diagnostic analyzeResourceProblems(Resource resource, Exception exception) 
	{
		if (!resource.getErrors().isEmpty() || !resource.getWarnings().isEmpty())
		{
			BasicDiagnostic basicDiagnostic = new BasicDiagnostic
			(Diagnostic.ERROR, "org.eclipse.emf.ecore.editor", 0,
					getString("_UI_CreateModelError_message", resource.getURI()),
					new Object [] { exception == null ? (Object)resource : exception });
			basicDiagnostic.merge(EcoreUtil.computeDiagnostic(resource, true));
			return basicDiagnostic;
		}
		else if (exception != null)
		{
			return new BasicDiagnostic
			(Diagnostic.ERROR, "org.eclipse.emf.ecore.editor", 0,
					getString("_UI_CreateModelError_message", resource.getURI()),
					new Object[] { exception });
		}
		else
			return Diagnostic.OK_INSTANCE;
	}
	public void createContextMenuFor(StructuredViewer viewer)
	{
		Control control = viewer.getControl();
		MenuManager contextMenu = new MenuManager("#PopUp");
		contextMenu.add(new Separator("additions"));
		contextMenu.setRemoveAllWhenShown(true);
		contextMenu.addMenuListener(this);
		Menu menu = contextMenu.createContextMenu(control);
		control.setMenu(menu);
		getSite().registerContextMenu(contextMenu, new UnwrappingSelectionProvider(viewer));

		int dndOperations = DND.DROP_COPY | DND.DROP_MOVE | DND.DROP_LINK;
		Transfer[] transfers = new Transfer[] { LocalTransfer.getInstance() };
		viewer.addDragSupport(dndOperations, transfers, new ViewerDragAdapter(viewer));
		viewer.addDropSupport(dndOperations, transfers, new EditingDomainViewerDropAdapter(getEditingDomain(), viewer));
		control.addMouseListener(new DoubleClickListener());
	}

	/**
	 * This is for implementing {@link IEditorPart} and simply saves the model file.
	 */
	public void doResourceSetSave(IProgressMonitor progressMonitor)
	{
		// Save only resources that have actually changed.
		//
		Map<Object, Object> saveOptions = new HashMap<Object, Object>();
		saveOptions.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED, Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);

		// Do the work within an operation because this is a long running activity that modifies the workbench.
		//
		WorkspaceModifyOperation operation1 = new SaveOperation1(saveOptions);
		WorkspaceModifyOperation operation2 = new SaveOperation2();
		updateProblemIndication = false;
		try
		{
			// This runs the options, and shows progress.
			//
			ProgressMonitorDialog progressMonitorDialog = new ProgressMonitorDialog(getShell());
			progressMonitorDialog.run(true, false, operation1);

			// Refresh the necessary state.
			//
			if (QVTEditorPlugin.EDITOR_SAVE.isActive())
				QVTEditorPlugin.EDITOR_SAVE.println(getClass(), "Saved all");
			try
			{
				// This runs the options, and shows progress.
				//
				progressMonitorDialog.run(true, false, operation2);

				// Refresh the necessary state.
				//
				if (QVTEditorPlugin.EDITOR_SAVE.isActive())
					QVTEditorPlugin.EDITOR_SAVE.println(getClass(), "Saved all2");
				savingResources.clear();
			}
			catch (Exception exception)
			{
				// Something went wrong that shouldn't.
				//
				QVTEditorPlugin.INSTANCE.log(exception);
			}
			getCommandStack().saveIsDone();		// FIXME operation history
			firePropertyChange(IEditorPart.PROP_DIRTY);
		}
		catch (Exception exception)
		{
			// Something went wrong that shouldn't.
			//
			QVTEditorPlugin.INSTANCE.log(exception);
		}
		updateProblemIndication = true;
		updateProblemIndication();
	}

	/**
	 */
	@Override
	public void dispose()
	{
		updateProblemIndication = false;
		super.dispose();
	}

	/**
	 * This also changes the editor's input.
	 */
	@Override
	public void doSaveAs()
	{
		SaveAsDialog saveAsDialog= new SaveAsDialog(getShell());
		saveAsDialog.open();
		IPath path= saveAsDialog.getResult();
		if (path != null)
		{
			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
			if (file != null)
			{
				ResourceSet resourceSet = getResourceSet();
				Resource currentResource = resourceSet.getResources().get(0);
				String currentExtension = currentResource.getURI().fileExtension();

				URI newURI = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
				String newExtension = newURI.fileExtension();

				if (currentExtension.equals(ECORE_FILE_EXTENSION) && newExtension.equals(EMOF_FILE_EXTENSION) ||
						currentExtension.equals(EMOF_FILE_EXTENSION) && newExtension.equals(ECORE_FILE_EXTENSION))
				{
					Resource newResource = resourceSet.createResource(newURI);
					newResource.getContents().addAll(currentResource.getContents());
					resourceSet.getResources().remove(0);
					resourceSet.getResources().move(0, newResource);
				}
				else
				{
					currentResource.setURI(newURI);
				}

				IFileEditorInput modelFile = new FileEditorInput(file);
				setInputWithNotify(modelFile);
				setPartName(file.getName());
				doSave(getActionBars().getStatusLineManager().getProgressMonitor());
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void doSaveAs(URI uri, IEditorInput editorInput)
	{
		(getResourceSet().getResources().get(0)).setURI(uri);
		setInputWithNotify(editorInput);
		setPartName(editorInput.getName());
		IProgressMonitor progressMonitor =
			getActionBars().getStatusLineManager() != null ?
					getActionBars().getStatusLineManager().getProgressMonitor() :
						new NullProgressMonitor();
					doSave(progressMonitor);
	}

	/**
	 * This is here for the listener to be able to call it.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void firePropertyChange(int action)
	{
		super.firePropertyChange(action);
	}

	public abstract AdapterFactoryEditingDomain getAdapterFactoryEditingDomain();

	public AbstractTransactionalCommandStack getCommandStack() {
		return ((AbstractTransactionalCommandStack)getEditingDomain().getCommandStack());
	}

	public Display getDisplay() {
		return getShell().getDisplay();
	}

	public abstract EditingDomain getEditingDomain();

	public abstract ResourceSet getResourceSet();
	public abstract ISelection getSelection();

	public Shell getShell() {
		return getSite().getShell();
	}

	/**
	 * This looks up a string in the plugin's plugin.properties file.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static String getString(String key)
	{
		return QVTEditorPlugin.INSTANCE.getString(key);
	}

	/**
	 * This looks up a string in plugin.properties, making a substitution.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static String getString(String key, Object s1)
	{
		return QVTEditorPlugin.INSTANCE.getString(key, new Object [] { s1 });
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	/*  public EditingDomainActionBarContributor getActionBarContributor()
  {
    return (EditingDomainActionBarContributor)getEditorSite().getActionBarContributor();
  } */

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public abstract IActionBars getActionBars();

	/**
	 * Handles activation of the editor or it's associated views.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void handleActivate()
	{
		AdapterFactoryEditingDomain editingDomain = getAdapterFactoryEditingDomain();
		// Recompute the read only state.
		//
		if (editingDomain.getResourceToReadOnlyMap() != null) {
			editingDomain.getResourceToReadOnlyMap().clear();

			// Refresh any actions that may become enabled or disabled.
			//
			setSelection(getSelection());
		}

		if (!removedResources.isEmpty())
		{
			if (handleDirtyConflict())
			{
				getSite().getPage().closeEditor(BaseEditor.this, false);
			}
			else
			{
				removedResources.clear();
				changedResources.clear();
				savedResources.clear();
				if (QVTEditorPlugin.EDITOR_SAVE.isActive())
					QVTEditorPlugin.EDITOR_SAVE.println(getClass(), "Clear saved after removed");
			}
		}
		else if (!changedResources.isEmpty())
		{
			changedResources.removeAll(savedResources);
			handleChangedResources();
			changedResources.clear();
			savedResources.clear();
			if (QVTEditorPlugin.EDITOR_SAVE.isActive())
				QVTEditorPlugin.EDITOR_SAVE.println(getClass(), "Clear saved after changed");
		}
	}

	/**
	 * Handles what to do with changed resources on activation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void handleChangedResources()
	{
		if (!changedResources.isEmpty() && (!isDirty() || handleDirtyConflict()))
		{
			getCommandStack().flush();				// FIXME operation history
			updateProblemIndication = false;
			for (Resource resource : changedResources)
			{
				if (resource.isLoaded())
				{
					resource.unload();
					try
					{
						resource.load(Collections.EMPTY_MAP);
					}
					catch (IOException exception)
					{
						if (!resourceToDiagnosticMap.containsKey(resource))
						{
							resourceToDiagnosticMap.put(resource, analyzeResourceProblems(resource, exception));
						}
					}
				}
			}
			updateProblemIndication = true;
			updateProblemIndication();
		}
	}

	/**
	 * Shows a dialog that asks if conflicting changes should be discarded.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected boolean handleDirtyConflict()
	{
		return MessageDialog.openQuestion (getShell(),
				getString("_UI_FileConflict_label"),
				getString("_WARN_FileConflict"));
	}

	/**
	 * This returns whether something has been persisted to the URI of the specified resource.
	 * The implementation uses the URI converter from the editor's resource set to try to open an input stream. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected boolean isPersisted(Resource resource)
	{
		boolean result = false;
		try
		{
			InputStream stream = getResourceSet().getURIConverter().createInputStream(resource.getURI());
			if (stream != null)
			{
				result = true;
				stream.close();
			}
		}
		catch (IOException e)
		{
			// Ignore
		}
		return result;
	}

	/**
	 * This always returns true because it is not currently supported.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSaveAsAllowed()
	{
		return true;
	}

//	public boolean isSaving(Resource resource) {
//		return savingResources.contains(resource);
//	}

	protected abstract void resumeResourceListening();

	public abstract void setSelection(ISelection selection);

	protected abstract void suspendResourceListening();
	
	/**
	 * Updates the problems indication with the information described in the specified diagnostic.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void updateProblemIndication()
	{
		if (updateProblemIndication)
		{
			BasicDiagnostic diagnostic =
				new BasicDiagnostic
				(Diagnostic.OK,
						"org.eclipse.emf.ecore.editor",
						0,
						null,
						new Object [] { getResourceSet() });
			for (Diagnostic childDiagnostic : resourceToDiagnosticMap.values())
			{
				if (childDiagnostic.getSeverity() != Diagnostic.OK)
				{
					diagnostic.add(childDiagnostic);
				}
			}

			int lastEditorPage = getPageCount() - 1;
			if (lastEditorPage >= 0 && getEditor(lastEditorPage) instanceof ProblemEditorPart)
			{
				((ProblemEditorPart)getEditor(lastEditorPage)).setDiagnostic(diagnostic);
				if (diagnostic.getSeverity() != Diagnostic.OK)
				{
					setActivePage(lastEditorPage);
				}
			}
			else if (diagnostic.getSeverity() != Diagnostic.OK)
			{
				ProblemEditorPart problemEditorPart = new ProblemEditorPart();
				problemEditorPart.setDiagnostic(diagnostic);
				problemEditorPart.setMarkerHelper(markerHelper);
				try
				{
					addPage(++lastEditorPage, problemEditorPart, getEditorInput());
					setPageText(lastEditorPage, problemEditorPart.getPartName());
					setActivePage(lastEditorPage);
					//					 showTabs();
				}
				catch (PartInitException exception)
				{
					QVTEditorPlugin.INSTANCE.log(exception);
				}
			}

			if (markerHelper.hasMarkers(getResourceSet()))
			{
				markerHelper.deleteMarkers(getResourceSet());
				if (diagnostic.getSeverity() != Diagnostic.OK)
				{
					try
					{
						markerHelper.createMarkers(diagnostic);
					}
					catch (CoreException exception)
					{
						QVTEditorPlugin.INSTANCE.log(exception);
					}
				}
			}
		}
	}
}
