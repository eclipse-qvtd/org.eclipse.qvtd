/*******************************************************************************
 * Copyright (c) 2007,2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.editor.ui.paged;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.commands.operations.ObjectUndoContext;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceStatus;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.ui.editor.ProblemEditorPart;
import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.celleditor.AdapterFactoryTreeEditor;
import org.eclipse.emf.edit.ui.util.EditUIUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.impl.TransactionalEditingDomainImpl;
import org.eclipse.emf.transaction.ui.provider.TransactionalAdapterFactoryContentProvider;
import org.eclipse.emf.transaction.ui.provider.TransactionalAdapterFactoryLabelProvider;
import org.eclipse.emf.workspace.IWorkspaceCommandStack;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.ocl.examples.modelregistry.eclipse.EclipseProjectHandle;
import org.eclipse.qvt.declarative.ecore.adapters.ResourceSetMappingMetaDataRegistryAdapter;
import org.eclipse.qvt.declarative.ecore.mappings.IMappingMetaData;
import org.eclipse.qvt.declarative.ecore.mappings.IMappingMetaDataRegistry;
import org.eclipse.qvt.declarative.ecore.mappings.MappingConfigurationException;
import org.eclipse.qvt.declarative.ecore.utils.TracingOption;
import org.eclipse.qvt.declarative.editor.ui.ICreationFactory;
import org.eclipse.qvt.declarative.editor.ui.IMasterPageManager;
import org.eclipse.qvt.declarative.editor.ui.IPageManager;
import org.eclipse.qvt.declarative.editor.ui.QVTEditorPlugin;
import org.eclipse.qvt.declarative.editor.ui.actions.HideResourceAdaptersAction;
import org.eclipse.qvt.declarative.editor.ui.actions.PagedActionBarContributor;
import org.eclipse.qvt.declarative.editor.ui.commands.MasterPageSaveCommand;
import org.eclipse.qvt.declarative.editor.ui.commands.PageChangeCommand;
import org.eclipse.qvt.declarative.editor.ui.commands.PageSaveCommand;
import org.eclipse.qvt.declarative.editor.ui.commands.ResourceSetSaveCommand;
import org.eclipse.qvt.declarative.editor.ui.cst.CSTOutline;
import org.eclipse.qvt.declarative.editor.ui.operations.OperationHistoryListener;
import org.eclipse.qvt.declarative.editor.ui.pages.IPageFactoryRegistry;
import org.eclipse.qvt.declarative.editor.ui.pages.PageDefinitions;
import org.eclipse.qvt.declarative.editor.ui.pages.PageDefinitionsReader;
import org.eclipse.qvt.declarative.editor.ui.text.TextResource;
import org.eclipse.qvt.declarative.editor.ui.tree.TreePageManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IStorageEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.ui.ide.IGotoMarker;
import org.eclipse.ui.part.IShowInTargetList;
import org.eclipse.ui.views.contentoutline.ContentOutline;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.PropertySheet;
import org.eclipse.ui.views.properties.PropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;
import org.xml.sax.SAXException;

/**
 * A PagedEditor support editing aspects of a ResourceSet in a variety of pages, typically
 * with a text page for some concrete syntax, an XML text page for serialised abstract syntax,
 * a Tree page to show the ResourceSet and perhaps with diagram pages for graphical concrete syntax.
 * <p>
 * Direct editing of pages updates the ResourceSet directly. This occurs for the ResourceSet
 * tree editor and the diagram editors.
 * <p>
 * Indirect editing of pages occurs in a text file, which is projected from the ResourceSet
 * when the page is viewed and reconciled back into the ResourceSet when another page is viewed.
 * This occurs for the concrete syntax and XML serialisation text editors.  
 * <p>
 * The editor may be in one of four states:
 * <p>
 * MASTER:
 * <br>The editing is indirect using the original (master) file.
 * <br>isText = true
 * <br>activePageManager.isDirect() == false
 * <br>activePageManager.isMaster() == true
 * <br>activePageManager.isTemporary() == false
 * <br>ResourceSet is incomplete - master resource may be empty
 * <p>
 * DIRECT:
 * <br>The editing is directly impacting the ResourceSet.
 * <br>activePageManager.isDirect() == true
 * <br>activePageManager.isMaster() == false
 * <br>activePageManager.isTemporary() == false
 * <br>ResourceSet is fully valid
 * <p>
 * TEMPORARY:
 * <br>The editing is indirect using a temporary file created to view the contents.
 * <br>activePageManager.isDirect() == false
 * <br>activePageManager.isMaster() == false
 * <br>activePageManager.isTemporary() == true
 * <br>ResourceSet is only partially valid - secondary resource was present is now on loan
 * <p>
 * MASTER_AS_TEMPORARY:
 * <br>The editing is indirect using a temporary file created to view the contents. This
 * file should be copied back to the original file on completion.
 * <br>activePageManager.isDirect() == false
 * <br>activePageManager.isMaster() == true
 * <br>activePageManager.isTemporary() == true
 * <br>ResourceSet is only partially valid - master resource was present is now on loan
 * <p>
 * Initial State:
 * <br>MASTER: opening editor on a text file (CST or XML), or text file problem marker.
 * <br>DIRECT: opening editor on a diagram file, or unresolved problem marker
 * <br> ==> isText == false
 * <p>
 * State transitions:
 * <br>MASTER to DIRECT (or TEMPORARY): selecting another page
 * <br>(TEMPORARY or) DIRECT to MASTER: selecting master page when the only ResourceSet
 * modifications involve the master resource.
 * <br>(TEMPORARY or) DIRECT to MASTER_AS_TEMPORARY: selecting master page when the ResourceSet
 * modifications involve more than the master resource.
 * <br>DIRECT (or TEMPORARY): selecting a text page other than the master page
 * <p>
 * Note that when the initial state is DIRECT there is no master file and so MASTER and
 * MASTER_AS_TEMPORARY states cannot be reached.
 * <p>
 * A page is activated when selected. For non-direct pages, this requires creating or refreshing
 * the master/secondary text file.
 * <p>
 * A page is deactivated when another page is selected. For non-direct pages, this requires analysing
 * the master/secondary text file and reconciling it with the ResourceSet. Deactivation can be
 * skipped if the editor is not dirty unless in the MASTER state when the ResourceSet must
 * be completed.
 */
public class PagedEditor extends BaseEditor implements IEditingDomainProvider, IResourceChangeListener, IGotoMarker, ISelectionProvider, ISelectionChangedListener, ITabbedPropertySheetPageContributor
{
	/**
	 * Forwards selections from the active PageManager to setSelection.
	 */
/*	private final class ActivePageManagerSelectionChangedListener implements ISelectionChangedListener
	{
		// This just notifies those things that are affected by the selection.
		//
		public void selectionChanged(SelectionChangedEvent selectionChangedEvent) {
			setSelection(selectionChangedEvent.getSelection());
		}
	} */
	
	/**
	 * Forwards selections in the Content Outline to handleContentOutlineSelection.
	 */
/*	public final class ContentOutlineSelectionListener implements ISelectionChangedListener
	{
		// This ensures that we handle selections correctly.
		//
		public void selectionChanged(SelectionChangedEvent selectionChangedEvent) {
			handleContentOutlineSelection(selectionChangedEvent.getSelection());
		}
	} */
	
	/**
	 * Refreshes the ResourceSet/ContentOutline tree view when the hide adapted resources selection changes.
	 */
	protected static class HideResourceAdaptersPropertyChangeListener implements IPropertyChangeListener
	{
		protected final TreeViewer viewer;

		protected HideResourceAdaptersPropertyChangeListener(TreeViewer viewer) {
			this.viewer = viewer;
		}

		public void propertyChange(PropertyChangeEvent event) {
			if (event.getProperty() == IAction.CHECKED)
				viewer.refresh();					
		}
	}

	/**
	 * Prunes the ResourceSet/CopntentOutline tree view to hide adpated resources.
	 */
	protected static class HideResourceAdaptersViewerFilter extends ViewerFilter
	{
		protected final HideResourceAdaptersAction hideResourceAdaptersAction;

		protected HideResourceAdaptersViewerFilter(HideResourceAdaptersAction hideResourceAdaptersAction) {
			this.hideResourceAdaptersAction = hideResourceAdaptersAction;
		}

		@Override
		public boolean select(Viewer viewer, Object parentElement, Object element) {
			return hideResourceAdaptersAction.select(element);
		}
	}

	private final class ModelRegistryChangedRunnable implements Runnable
	{
		public void run() {
			activePageManager.refresh();
		}
	}

	private final class PartListener implements IPartListener
	{
		public void partActivated(IWorkbenchPart p) {
			if (p instanceof ContentOutline) {
				if (((ContentOutline) p).getCurrentPage() == contentOutlinePage) {
					getActionBarContributor().setActiveEditor(PagedEditor.this);
					setCurrentSelectionProvider(contentOutlinePage.getTreeViewer());
				}
			} else if (p instanceof PropertySheet) {
				if (((PropertySheet) p).getCurrentPage() == propertySheetPage) {
					getActionBarContributor().setActiveEditor(PagedEditor.this);
					handleActivate();
				}
			} else if (p == PagedEditor.this) {
				setCurrentSelectionProvider(activePageManager);
				handleActivate();
			}
		}

		public void partBroughtToTop(IWorkbenchPart p) {}
		public void partClosed(IWorkbenchPart p) {}
		public void partDeactivated(IWorkbenchPart p) {}
		public void partOpened(IWorkbenchPart p) {}
	}

/*	private final class QVTCommandStackListener implements CommandStackListener
	{
		public void commandStackChanged(final EventObject event) {
			getContainer().getDisplay().asyncExec(new Runnable()
			{
				public void run() {
					firePropertyChange(IEditorPart.PROP_DIRTY);
					// Try to select the affected objects.
					//
					Command mostRecentCommand = ((CommandStack) event.getSource()).getMostRecentCommand();
					if (mostRecentCommand != null)
						setSelectionToViewer(mostRecentCommand.getAffectedObjects());
					if (propertySheetPage != null)
						propertySheetPage.refresh();
				}
			});
		}
	} */

	protected final ICreationFactory creationFactory;
	
	/**
	 * Non-null if the paged editor opened on a text file, null on an XML file.
	 */
	protected TextResource textResource;
	
	/**
	 * The resource underlying the initially opened file. This is never null but may be
	 * empty until the MASTER state is first exited. 
	 */ 
	protected XMLResource masterResource;
	
	/**
	 * The map of all editors to their corresponding page managers.
	 */
	protected final Map<IEditorPart, IPageManager> pageManagers = new HashMap<IEditorPart, IPageManager>();

	/**
	 * The page manager for the starting page (where doSave is permitted).
	 */
	protected IMasterPageManager masterPageManager = null;
	
	/**
	 * The page manager with most recently saved content
	 */
	protected IPageManager validPageManager = null;
	
	/**
	 * The page manager for the activatePage. (Workaround for Bug 177568)
	 */
	protected IPageManager activePageManager = null;

	/**
	 * This keeps track of the editing domain that is used to track all changes to the model.
	 */
	protected TransactionalEditingDomainImpl editingDomain;

	/**
	 * This is the content outline page.
	 */
	protected PagedContentOutlinePage contentOutlinePage = null;
	
	/**
	 * This is the property sheet page.
	 */
	protected IPropertySheetPage propertySheetPage = null;
	
	/**
	 * This listens for when the outline becomes active
	 */
	protected IPartListener partListener = new PartListener();

	/**
	 * This keeps track of the selection of the editor as a whole.
	 */
	protected ISelection editorSelection = StructuredSelection.EMPTY;

	/**
	 * This keeps track of the active content viewer, which may be either one of the viewers in the pages or the content outline viewer.
	 */
//	@Deprecated
//	protected Viewer currentViewer;
	protected ISelectionProvider currentSelectionProvider;

	/**
	 * This selection provider coordinates the selections of the various editor parts.
	 */
//	protected MultiPageSelectionProvider selectionProvider;

	/**
	 * This listens to which ever viewer is active.
	 */
//	protected final ISelectionChangedListener activePageManagerSelectionChangedListener = new ActivePageManagerSelectionChangedListener();

	/**
	 * This keeps track of all the {@link org.eclipse.jface.viewers.ISelectionChangedListener}s that are listening to this editor.
	 */
	protected Collection<ISelectionChangedListener> selectionChangedListeners = new ArrayList<ISelectionChangedListener>();
	
	/**
	 * This listens to the OperationHistory to ensure that all operations have out undoContext,
	 * and to maintain the isDirty flag.
	 */
	protected OperationHistoryListener operationHistoryListener;

	/**
	 * Counter of page changes so that we only undo one page change to any given page.
	 * Same count can be kept if changing page while !isDirtyPage().
	 */
	private long resourceSetTimeStamp = 0;

	/**
	 * The registry of page factories.
	 */
	private PageDefinitions pageFactoryRegistries = null;

	/**
	 * This is the list of extra views for the Show In menu.
	 */
	protected IShowInTargetList showInTargetList = null;

	protected PagedEditor(ICreationFactory creationFactory) {
		this.creationFactory = creationFactory;
//		selectionProvider = new PagedSelectionProvider(this);
	/*	selectionProvider.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				setSelectionToStatusLineManager(event.getSelection());
			}
		}); */		
		ResourcesPlugin.getWorkspace().addResourceChangeListener(this);
	    initializeEditingDomain();
//	    initializeOperationHistoryListener();
	}

	/**
	 * Create, install and return the page manager for the initial EMOF XMI edit, or null to suppress the page.
	 *
	public IMasterPageManager addEMOFXMLPageManager(XMLResource ecoreResource) {
		try {
			if (ecoreResource.getContents().size() > 0) {
				EObject rootObject = ecoreResource.getContents().get(0);
				MappingMetaData mappingMetaData = creationFactory.getMappingMetaData();	// throws if no EMOF support
				mappingMetaData.initialise();
				mappingMetaData.getAdapter(rootObject);	// throws if no EMOF support
			}
			return addPageManager(new EMOFXMLPageManager(this, ecoreResource, "EMOF XMI"));
		} catch (Exception e) {
//			isEMOF = false;
		}
		return null;
	} */

	/**
	 * Create, install and return the page manager for the initial Ecore XMI edit, or null to suppress the page.
	 *
	public IMasterPageManager addEcoreXMLPageManager(XMLResource ecoreResource) {
		return addPageManager(new EcoreXMLPageManager(this, ecoreResource, "Ecore XMI"));
	} */

	@Override
	public void addPage(int index, IEditorPart editor, IEditorInput input) throws PartInitException {
		super.addPage(index, editor, input);
		// Following is a tacky workaround for 103865
		CTabFolder tabFolder = (CTabFolder) getContainer();
		CTabItem[] items = tabFolder.getItems();
		CTabItem oldItem = items[index];
		Control savedControl = oldItem.getControl();
		Object savedData = oldItem.getData();
		oldItem.dispose();
		CTabItem item = new CTabItem(tabFolder, SWT.CLOSE, index);
		item.setControl(savedControl);
		item.setData(savedData);
	}
	
	public void addPageManager(IPageManager pageManager) {
		IEditorPart editor = pageManager.getEditor();
		IStorageEditorInput editorInput = pageManager.getEditorInput();
		String pageTitle = pageManager.getTitle();
		Image pageImage = pageManager.getImage();
		try {
			editor.getClass();
			editorInput.getClass();
			int pageIndex = addPage(editor, editorInput);
			setPageText(pageIndex, pageTitle);
			setPageImage(pageIndex, pageImage);
			pageManagers.put(pageManager.getEditor(), pageManager);
			IUndoContext undoContext = pageManager.getUndoContext();
			if (undoContext != null)
				getUndoContext().addMatch(undoContext);
		} catch (PartInitException e) {
			showError("Error creating nested " + pageTitle + " editor", e);
		}
	}

	/**
	 * This implements {@link org.eclipse.jface.viewers.ISelectionProvider}.
	 */
	public void addSelectionChangedListener(ISelectionChangedListener listener) {
		selectionChangedListeners.add(listener);
	}

	protected PagedContentOutlinePage createContentOutlinePage() {
		PagedContentOutlinePage page = new PagedContentOutlinePage(this);
		// Listen to selection so that we can handle it in a special way.
		//
//		page.addSelectionChangedListener(new ContentOutlineSelectionListener());
		return page;
	}

	/**
	 * Model loader attempts an XML load (of a model or a diagram of
	 * a model). If the the XML load fails the input is categorised as text.
	 * 
	 * On completion an XML load leaves isText false and masterResource assigned
	 * to the model. A text load leaves isText true and masterResource assigned
	 * to an empty resource awaiting content from textual analysis.
	 */
	protected void createModel() {
	    URI sourceURI = EditUIUtil.getURI(getEditorInput());
	    ResourceSet resourceSet = getResourceSet();
	    Resource loadedResource = null;
	    Exception loadingException = null;
		try {
	    	masterResource = (XMLResource) resourceSet.getResource(sourceURI, true);
	    	loadedResource = masterResource;
	    	textResource = null;
	    } catch (WrappedException e) {												// Load failure provokes treatment as a text file
	    	Throwable cause = e.getCause();
    		Resource reloadedResource = resourceSet.getResource(sourceURI, false);
	    	if (cause instanceof SAXException) {
	    		if (reloadedResource != null)											// Lose the resource masquerading
	    			resourceSet.getResources().remove(reloadedResource);				//  as the text file
		    	URI resourceURI = sourceURI.appendFileExtension(creationFactory.getEcoreExtension());
		    	try {
		    		masterResource = (XMLResource) resourceSet.getResource(resourceURI, true);	// Ecore resource for AST of text file CST
		    	} catch (WrappedException e1) {										// Load failure if does not exist
		    		Throwable e2 = e1.getCause();
		    		if (e2 instanceof CoreException) {
		    			IStatus status = ((CoreException) e2).getStatus();
	    				int code = status.getCode();
		    			if (status instanceof IResourceStatus) {
		    				if (code == IResourceStatus.RESOURCE_NOT_FOUND)
		    					masterResource = (XMLResource) resourceSet.createResource(resourceURI);	// Create the future resource
		    				else
			    				masterResource = (XMLResource) resourceSet.getResource(resourceURI, false);	// Dummy resource for inherited TreeViewer
		    			}
		    		}
					if (masterResource == null) {
						masterResource = (XMLResource) resourceSet.createResource(resourceURI);	// Dummy resource for inherited TreeViewer
						showError("Failed to create '" + resourceURI + "'", e1);
					}
		    	} finally {
					if (masterResource == null) {
						masterResource = (XMLResource) resourceSet.createResource(resourceURI);	// Dummy resource for inherited TreeViewer
						showError("Failed to create '" + resourceURI + "'", null);
					}
					textResource = new TextResource(sourceURI);
					resourceSet.getResources().add(0, textResource);
				}
	    	}
	    	else {
		    	loadingException = e;
		    	loadedResource = reloadedResource;
	    	}
	    } catch (Exception e) {
	    	loadingException = e;
	    }

	    if (hasGenerics(resourceSet))
	    			getActionBarContributor().showGenerics(true);

	    if (loadedResource != null) {
	    	Diagnostic diagnostic = analyzeResourceProblems(loadedResource, loadingException);
		    if (diagnostic.getSeverity() != Diagnostic.OK)
		    {
		      resourceToDiagnosticMap.put(loadedResource,  analyzeResourceProblems(loadedResource, loadingException));
		    }
		    resourceSet.eAdapters().add(problemIndicationAdapter);
		    updateProblemIndication();
	    }
	}

	protected PagedOperationHistoryListener createOperationHistoryListener() {
		return new PagedOperationHistoryListener(this);
	}

	protected PageDefinitions createPageFactoryRegistries() {
		return new PageDefinitions();
	}
	
	/**
	 * Creates the pages of the paged editor.
	 * @throws PartInitException 
	 */
	@Override protected void createPages() {
	    createModel();
	    PageDefinitions pageFactoryRegistries = getPageFactoryRegistries();
	    if (masterResource != null)
	    	masterPageManager = pageFactoryRegistries.createMasterPageFor(this, masterResource, textResource);
	    if (masterPageManager == null) {
	    	try {
				throw new PartInitException("Failed to identify a Master Page Manager");
			} catch (PartInitException e) {
				QVTEditorPlugin.logError("Failed to identify a Master Page Manager", e);
				return;	// FIXME get error out via updateProblemIndication
			}
	    }
	    pageFactoryRegistries.createOtherPagesFor(this);
//		validPageManager = isText ? null : resourceSetPageManager;
		if (textResource == null) {
			for (IPageManager pageManager : pageManagers.values())
				if (pageManager instanceof TreePageManager) {
					validPageManager = pageManager;
					break;
				}
		}
//		setActivePageManager(masterPageManager);
		IEditorPart initialPage = masterPageManager.getInitialPage();
		setActiveEditor(initialPage);						// Invokes pageChange
	    updateProblemIndication();
	}

	protected IPropertySheetPage createPropertySheetPage() {
		PropertySheetPage page = new PagedPropertySheetPage(this);
		page.setPropertySourceProvider(new TransactionalAdapterFactoryContentProvider(getTransactionalEditingDomain(), getAdapterFactory()));
		return page;
	}

	/**
	 * This method may be over-ridden to create a resource-specific ResourceItemProviderAdapter
	 */
	public Adapter createResourceAdapter(ResourceItemProviderAdapterFactory resourceItemProviderAdapterFactory, Resource resource) {
		return resourceItemProviderAdapterFactory.createResourceAdapter();
	}
	
	protected IShowInTargetList createShowInTargetList() {
		return new IShowInTargetList()
		{
			public String[] getShowInTargetIds() {
				return new String[] {
					"org.eclipse.ui.views.PropertySheet",
					"org.eclipse.ui.views.ContentOutline",
					CSTOutline.VIEW_ID
				};
			}
			
		};
	}
	
	protected IUndoContext createUndoContext() {
		return new ObjectUndoContext(this, getString("UndoContext_label"));
	}

	public void deactivate(IPageManager oldPageManager, long pageChangeTimeStamp) {
		if (oldPageManager != null) {
//			validPageManager = oldPageManager;
			oldPageManager.deactivated(getProgressMonitor(), pageChangeTimeStamp);
//			if ((masterPageManager != null) && (masterPageManager != validPageManager))
//				masterPageManager.setTemporary();
		}
	}
	
	/**
	 * The <code>MultiPageTextEditor</code> implementation of this 
	 * <code>IWorkbenchPart</code> method disposes all nested editors.
	 * Subclasses may extend.
	 */
	@Override public void dispose() {
		if (operationHistoryListener != null) {
			if (traceOperationHistory.isActive())
				traceOperationHistory.println("Remove " + operationHistoryListener.toString() );		
			getOperationHistory().removeOperationHistoryListener(operationHistoryListener);
		}
		ResourcesPlugin.getWorkspace().removeResourceChangeListener(this);
	    if (propertySheetPage != null)
	    	propertySheetPage.dispose();
	    if (contentOutlinePage != null)
	    	contentOutlinePage.dispose();
	    ResourcesPlugin.getWorkspace().removeResourceChangeListener(resourceChangeListener);
	    getSite().getPage().removePartListener(partListener);
	    if (getActionBarContributor().getActiveEditor() == this)
	    	getActionBarContributor().setActiveEditor(null);
	    //
	    // FIXME If the editing domain is to have longer life the following must
	    //	be pre-empted to avoid unloading Resource content.
		super.dispose();
	}
	
	@Override public void doSave(IProgressMonitor monitor) {
		if (activePageManager != masterPageManager) {
			IMasterPageManager activeIndirectPageManager = activePageManager.getAdapter(IMasterPageManager.class);
			if (activeIndirectPageManager == null) {
				PageSaveCommand pageSaveCommand = new ResourceSetSaveCommand(this, monitor);
				getCommandStack().execute(pageSaveCommand);
			}
			else
				doSaveAs(monitor);
		}
		else {
			PageSaveCommand pageSaveCommand = new MasterPageSaveCommand(this, monitor);
			getCommandStack().execute(pageSaveCommand);
		}
	}
	
	/**
	 * Saves the paged editor's document as another file.
	 */
	@Override public void doSaveAs() {
		doSaveAs(getProgressMonitor());
	}

	public void doSaveAs(final IProgressMonitor monitor) {
		IMasterPageManager activeIndirectPageManager = activePageManager.getAdapter(IMasterPageManager.class);
		if (activeIndirectPageManager == null) {
			QVTEditorPlugin.logError(getClass().getName() + ".doSaveAs for a " + activePageManager.getClass().getName(), null);
			return;
		}
        IFile inputFile = getEditorInputFile();
        IPath inputPath = inputFile.getFullPath();
        IPath suggestedPath = inputPath.removeFileExtension().addFileExtension(activeIndirectPageManager.getFileExtension());
        if (inputPath.equals(suggestedPath))
        	suggestedPath = suggestedPath.removeLastSegments(1).append("Copy of " + inputFile.getName());
        IFile suggestedFile = ResourcesPlugin.getWorkspace().getRoot().getFile(suggestedPath);
		SaveAsDialog saveAsDialog = new SaveAsDialog(getShell());
		saveAsDialog.setOriginalFile(suggestedFile);
	    saveAsDialog.open();
	    IPath saveAsPath = saveAsDialog.getResult();
	    if (saveAsPath != null) {
	        IFile saveAsFile = ResourcesPlugin.getWorkspace().getRoot().getFile(saveAsPath);
	        activeIndirectPageManager.saveTo(saveAsFile, monitor);
	    }
	}

	public void doSaveCommand(IProgressMonitor monitor) throws OperationCanceledException {
		masterPageManager.doSave(monitor);
        validPageManager = masterPageManager;
        getCommandStack().saveIsDone();		// FIXME use operation history
//        firePropertyChange(IEditorPart.PROP_DIRTY);
	}
	
	public PagedActionBarContributor getActionBarContributor() {
	    return (PagedActionBarContributor)getEditorSite().getActionBarContributor();
	}

	@Override
	public IActionBars getActionBars() {
	    return getActionBarContributor().getActionBars();
	}

	@Override
	public IEditorPart getActiveEditor() {			// Expose for testing
		return super.getActiveEditor();
	}

	public IPageManager getActivePageManager() {
		return activePageManager;
	}

	/**
	 * This is how the framework determines which interfaces we implement.
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Object getAdapter(Class key) {
		if (key.equals(IContentOutlinePage.class)) {
			if (contentOutlinePage == null)
				contentOutlinePage = createContentOutlinePage();
			return contentOutlinePage;
		}
		if (key.equals(IPropertySheetPage.class)) {
			if (propertySheetPage == null)
				propertySheetPage = createPropertySheetPage();
			return propertySheetPage;
		}
        if (key.equals(IShowInTargetList.class)) {
			if (showInTargetList  == null)
				showInTargetList = createShowInTargetList();
			return showInTargetList;
        }
		if (key.equals(IGotoMarker.class))
			return this;
		if (key.equals(IUndoContext.class))
			return getUndoContext();
		return super.getAdapter(key);
	}

	public AdapterFactory getAdapterFactory() {
		return editingDomain.getAdapterFactory();
	}

	@Override
	public AdapterFactoryEditingDomain getAdapterFactoryEditingDomain() {
		return editingDomain;
	}

	public String getContributorId() {
		return QVTEditorPlugin.ID;
	}

	public ICreationFactory getCreationFactory() {
		return creationFactory;
	}

	/**
	 * Override to return xxxDiagramEditorPlugin.getInstance().getItemProvidersAdapterFactories()
	 * @return
	 */
	protected Collection<AdapterFactory> getDomainAdapterFactories() { // FIXME abstract to force derived implementation
	    List<AdapterFactory> domainAdapterFactories = new ArrayList<AdapterFactory>();
	    domainAdapterFactories.add(new EcoreItemProviderAdapterFactory());
	    domainAdapterFactories.add(new ReflectiveItemProviderAdapterFactory());
		return domainAdapterFactories;
	}

	@Override
	public EditingDomain getEditingDomain() {
		return editingDomain;
	}

	public String getEditingDomainID() {
		return "org.eclipse.qvt.declarative.editingDomainID";		// FIXME share this with diagram editor plugin.xml's
	}

	/**
	 * Return the editor whose getPageText() matches the given pageTitle
	 */
	public IEditorPart getEditor(String pageTitle) {
		int count = getPageCount();
		for (int i = 0; i < count; i++) {
			String pageText = getPageText(i);
			if (pageTitle.equals(pageText))
				return getEditor(i);
		}
		return null;
	}

	@Override 
	public IFileEditorInput getEditorInput() {
		return (IFileEditorInput) super.getEditorInput();
	}

	public IFile getEditorInputFile() {
		return getEditorInput().getFile();
	}

	/**
	 * Return the page that appears as the first selection.
	 *
	protected IEditorPart getInitialPage() {
		return masterPageManager.getEditor();
	} */

	public IMappingMetaDataRegistry getMappingMetaDataRegistry() throws MappingConfigurationException {
		IMappingMetaData mappingMetaData = getCreationFactory().getMappingMetaData();
		ResourceSet resourceSet = getResourceSet();
		return ResourceSetMappingMetaDataRegistryAdapter.getMappingMetaDataRegistry(resourceSet, mappingMetaData);
	}

	public IMasterPageManager getMasterPageManager() {
		return masterPageManager;
	}

	public long getNextResourceSetTimeStamp() {
		if (isDirtyPage())
			resourceSetTimeStamp++;
		return resourceSetTimeStamp;
	}

	public IOperationHistory getOperationHistory() {
		return getWorkspaceCommandStack().getOperationHistory();
	}

//	public <T extends IPageFactory<T>> Collection<T> getPageFactories(Class<T> pageFactoryClass) {
//		return getPageFactoryRegistry().getPageFactories(pageFactoryClass);
//	}

	public <T extends IPageFactoryRegistry<?>> T getPageFactoryRegistry(Class<T> class1) {
		return pageFactoryRegistries.get(class1);
	}
	
	public PageDefinitions getPageFactoryRegistries() {
		if (pageFactoryRegistries == null) {
			pageFactoryRegistries = createPageFactoryRegistries();
			initializePageFactoryRegistries();
		}
		return pageFactoryRegistries;
	}

	public int getPageIndex(IEditorPart editorPart) {
		int count = getPageCount();
		for (int i = 0; i < count; i++) {
			IEditorPart editor = getEditor(i);
			if (editor == editorPart)
				return i;
		}
		return -1;
	}

	public Collection<IPageManager> getPageManagers() {
		return pageManagers.values();
	}

	/**
	 * Return the actual page title (possibly including a * prefix if dirty).
	 */
	public String getPageTitle(IEditorPart editor) {
		int pageIndex = getPageIndex(editor);
		if (pageIndex < 0) 
			return null;
		return getPageText(pageIndex);
	}

	/**
	 * Returns the progress monitor related to this editor. It should not be
	 * necessary to extend this method.
	 *
	 * @return the progress monitor related to this editor
	 * @since 2.1
	 */
	public IProgressMonitor getProgressMonitor(){
		IProgressMonitor pm = null;
		IStatusLineManager manager = getStatusLineManager();
		if (manager != null)
			pm= manager.getProgressMonitor();

		return pm != null ? pm : new NullProgressMonitor();
	}

	public IProject getProject() {
		return getEditorInputFile().getProject();
	}

	public IPropertySheetPage getPropertySheetPage() {
		return propertySheetPage;
	}
	
	@Override
	public ResourceSet getResourceSet() {
		return editingDomain.getResourceSet();
	}

	public long getResourceSetTimeStamp() {
		return resourceSetTimeStamp;
	}

	@Override
	public ISelection getSelection() {
		return editorSelection;
//		return selectionProvider.getSelection();
//		return currentSelectionProvider.getSelection();
	}

	/**
	 * Returns the status line manager of this editor.
	 * 
	 * @return the status line manager of this editor
	 * @since 2.0, protected since 3.3
	 */
	protected IStatusLineManager getStatusLineManager() {
		return getEditorSite().getActionBars().getStatusLineManager();
	}

	public IFolder getTmpDir() throws CoreException {
		IFolder tmpdir = getProject().getFolder(".tmpdir");
		if (!tmpdir.exists())
			tmpdir.create(true, false, null);		// FIXME ?? make local
		return tmpdir;
	}

	public TransactionalEditingDomain getTransactionalEditingDomain() {
		return editingDomain;
	}

	public ObjectUndoContext getUndoContext() {
		return operationHistoryListener.getUndoContext();
	}

	/**
	 * This returns the viewer as required by the {@link IViewerProvider} interface.
	 */
	public Viewer getViewer() {
		return (Viewer) (currentSelectionProvider instanceof Viewer ? currentSelectionProvider : null);
	}

	public IWorkspaceCommandStack getWorkspaceCommandStack() {
		return (IWorkspaceCommandStack) super.getCommandStack();
	}
	
	/* (non-Javadoc)
	 * Method declared on IEditorPart
	 */
	public void gotoMarker(IMarker marker) {
		if (activePageManager != null) {
			if (activePageManager.gotoMarker(marker))
				return;
		}
		// FIXME change to if activePage.hasMarker goto active page else for all pages if has marker ...
/*		try {
			Object builderId = marker.getAttribute(MarkerProblemHandler.BUILDER_ID);
			if (creationFactory.getBuilderId().equals(builderId)) {
				setActiveEditor(textPageManager.getEditor());
				IDE.gotoMarker(textPageManager.getEditor(), marker);
				return;
			}
		} catch (CoreException e) {
		}
		setActiveEditor(resourceSetPageManager.getEditor()); */
		if (false) {	// FIXME
			try {
				if (marker.getType().equals(EValidator.MARKER)) {
					String uriAttribute = marker.getAttribute(EValidator.URI_ATTRIBUTE, null);
					if (uriAttribute != null) {
						URI uri = URI.createURI(uriAttribute);
						EObject eObject = editingDomain.getResourceSet().getEObject(uri, true);
						if (eObject != null)
							setSelectionToViewer(Collections.singleton(editingDomain.getWrapper(eObject)));
					}
				}
			} catch (CoreException exception) {
				QVTEditorPlugin.INSTANCE.log(exception);
			}
		}
		setSelectionToViewer(markerHelper.getTargetObjects(editingDomain, marker));
	}
	
	@Override
	protected void handleActivate() {
		super.handleActivate();
	}

	public void handleContentOutlineSelection(ISelection selection) {
//		Viewer selectionViewer = activePageManager != null ? activePageManager.getViewer() : null;
//		ISelectionProvider selectionViewer = activePageManager != null ? activePageManager.getSelectionProvider() : null;
//	    if ((selectionViewer != null) && !selection.isEmpty() && (selection instanceof IStructuredSelection)) {
//	    	List<?> selectionList = ((IStructuredSelection) selection).toList();
//			selectionViewer.setSelection(new StructuredSelection(selectionList));
//		} 
//	    if ((currentSelectionProvider != null) && !selection.isEmpty() && (selection instanceof IStructuredSelection)) {
//	    	List<?> selectionList = ((IStructuredSelection) selection).toList();
//	    	currentSelectionProvider(new StructuredSelection(selectionList));
//	    	currentSelectionProvider.setSelection(selection);	// FIXME why no editorSelection correlation
//		} 
		if ((contentOutlinePage != null) && (currentSelectionProvider == contentOutlinePage.getTreeViewer()))
			setSelection(selection);
/*		if (!selection.isEmpty() && selection instanceof IStructuredSelection) {
			List selectedElements = ((IStructuredSelection)selection).toList();
			if (getActiveEditor() == selectionEditorPart) {
				// If the selection viewer is active, we want it to select the same selection as this selection.
				//
				selectionProvider.setSelection(new StructuredSelection(selectedElements));
			} else if (getActiveEditor() == diagramEditor) {
				// If the diagram viewer is active, we need to map the selection to the corresponding EditParts.
				//
				ArrayList<Object> selectionList = new ArrayList<Object>();
				for(Object selectedElement: selectedElements) {
					if (selectedElement instanceof EObject) {
						String elementID = EMFCoreUtil.getProxyID((EObject) selectedElement);
						selectionList.addAll(diagramEditor.getDiagramGraphicalViewer().findEditPartsForElement(elementID, 
								IGraphicalEditPart.class));
					}
					selectionProvider.setSelection(new StructuredSelection(selectionList));
				}
			} else {
				// For any other viewer, set the input directly.
				//
				((TopicmapEditorPart)getActiveEditor()).setInput(selectedElements.get(0));
			}
		} */
	}
	
	public boolean hasGenerics(ResourceSet resourceSet) {
	    for (Resource resource : resourceSet.getResources()) {
	    	for (Iterator<EObject> i = resource.getAllContents(); i.hasNext(); ) {
	    		EObject eObject = i.next();
	    		if ((eObject instanceof ETypeParameter)
	    		 || (eObject instanceof EGenericType) && !((EGenericType)eObject).getETypeArguments().isEmpty())
	    			return true;
	    	}
	    }
		return false;
	}
	
	/**
	 * This is called during startup.
	 */
	@Override
	public void init(IEditorSite site, IEditorInput editorInput) {
		setSite(site);
		setInputWithNotify(editorInput);
		setPartName(editorInput.getName());
	    initializeOperationHistoryListener();				// After names available
//		site.setSelectionProvider(selectionProvider);
		site.setSelectionProvider(this);
		site.getPage().addPartListener(partListener);
		//FIXME Transactional workspace synchronizer
		ResourcesPlugin.getWorkspace().addResourceChangeListener(resourceChangeListener, IResourceChangeEvent.POST_CHANGE);
	}

	/**
	 * This sets up the editing domain for the model editor.
	 */
	protected void initializeEditingDomain() {
	    // Use next line to re-use ResourceSet
//	    editingDomain = (TransactionalEditingDomainImpl) TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain(
//		"org.eclipse.qvt.declarative.editor.QVTEditingDomain");
	    editingDomain = (TransactionalEditingDomainImpl) new PagedEditingDomainFactory().createEditingDomain();
	    editingDomain.setID(getEditingDomainID());
	    ComposedAdapterFactory adapterFactory = (ComposedAdapterFactory) editingDomain.getAdapterFactory();
	    // Install the item providers.
	    //
//	    adapterFactory.addAdapterFactory(new PagedResourceItemProviderAdapterFactory(this));
	    adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
	    for (AdapterFactory domainAdapterFactory : getDomainAdapterFactories())
	    	adapterFactory.addAdapterFactory(domainAdapterFactory);
	}
	
	/**
	 * This sets up the operation history listener for the model editor.
	 */
	protected void initializeOperationHistoryListener() {
	    // Add a listener to set the most recent command's affected objects to be the selection of the viewer with focus.
	    //
//	    getCommandStack().addCommandStackListener(new QVTCommandStackListener());
		operationHistoryListener = createOperationHistoryListener();
		if (traceOperationHistory.isActive())
			traceOperationHistory.println("Install " + operationHistoryListener.toString() );		
		getOperationHistory().addOperationHistoryListener(operationHistoryListener);
		getUndoContext().addMatch(getWorkspaceCommandStack().getDefaultUndoContext());	// Save commands happen here
	}

	protected void initializePageFactoryRegistries() {
	    new PageDefinitionsReader(this).readRegistry();
	}

	public void initializeTreeViewer(TreeViewer viewer) {
		HideResourceAdaptersAction hideResourceAdaptersAction = getActionBarContributor().getHideResourceAdaptersAction();
		viewer.addFilter(
				new HideResourceAdaptersViewerFilter(hideResourceAdaptersAction));
		viewer.setContentProvider(
				new TransactionalAdapterFactoryContentProvider(editingDomain, getAdapterFactory()));
		viewer.setLabelProvider(
				new TransactionalAdapterFactoryLabelProvider(editingDomain, getAdapterFactory()));
		viewer.setInput(getResourceSet());
//		EList<Resource> resources = resourceSet.getResources();
//		if (!resources.isEmpty()) {
		// Select the root object in the view.
		//
//			StructuredSelection selection = new StructuredSelection(resources.get(0));
//			treeViewer.setSelection(selection, true);
//		}
		new AdapterFactoryTreeEditor(viewer.getTree(), getAdapterFactory());
		hideResourceAdaptersAction.addPropertyChangeListener(
				new HideResourceAdaptersPropertyChangeListener(viewer)
		);
	}	

	/**
	 * The editor is dirty if the operation history stack contains anything other than
	 * NonDirtying commands.
	 */
	@Override
	public boolean isDirty() {
/*		for (IUndoableOperation operation : getOperationHistory().getUndoHistory(undoContext)) {
			if (!operation.canUndo())
				return true;
			if (isDirty(operation))
				return true;
		}
		return false; */
		return operationHistoryListener.isDirty();
	}

	public boolean isDirtyPage() {
		return operationHistoryListener.isDirtyPage();
	}

	/**
	 * This implements {@link org.eclipse.jface.action.IMenuListener} to help fill the context menus with contributions from the Edit menu.
	 */
	public void menuAboutToShow(IMenuManager menuManager) {
		getActionBarContributor().menuAboutToShow(menuManager);
	}

	/**
	 * Calculates the contents of a page when it is activated.
	 */
	@Override
	protected void pageChange(int newPageIndex) {		
	    if (contentOutlinePage != null)
	    	handleContentOutlineSelection(contentOutlinePage.getSelection());
		IEditorPart newEditor = getEditor(newPageIndex);
		IPageManager newPageManager = pageManagers.get(newEditor);  // To be activated
		if (newPageManager == null) {
//			newPageManager = resourceSetPageManager;			// FIXME Change to error
			if (!(newEditor instanceof ProblemEditorPart))		// FIXME Make the Problems page a managed page
				QVTEditorPlugin.logError("No page manager for page " + newPageIndex, null);
			return;	
		}
		if (activePageManager == newPageManager)				// Self to Self (probably a workaround callback)
			return;
		if (activePageManager != null) {
			setActiveEditor(activePageManager.getEditor()); 	// Inhibit change for now.
			PageChangeCommand pageChangeCommand = new PageChangeCommand(this, newPageManager);
			getCommandStack().execute(pageChangeCommand);		// Does undoable super.pageChange()
		}
		else
			setActivePageManager(newPageManager, resourceSetTimeStamp);
	}

	public void registryChanged() {
		getDisplay().asyncExec(new ModelRegistryChangedRunnable());
	}
	
	public void removePageManager(IPageManager pageManager) {
		pageManagers.remove(pageManager.getEditor());
		getUndoContext().removeMatch(pageManager.getUndoContext());
	}

	/**
	 * This implements {@link org.eclipse.jface.viewers.ISelectionProvider}.
	 */
	public void removeSelectionChangedListener(ISelectionChangedListener listener) {
		selectionChangedListeners.remove(listener);
	}

	/**
	 * Closes all project files on project close.
	 */
	public void resourceChanged(final IResourceChangeEvent event){
		if (event.getType() == IResourceChangeEvent.POST_CHANGE) {
			EclipseProjectHandle projectHandle = new EclipseProjectHandle(getProject());
			final IFile registryResource = projectHandle.getRegistryResource();
			IResourceDelta resourceDelta = event.getDelta();
			try {
				resourceDelta.accept(new IResourceDeltaVisitor()
				{
					public boolean visit(IResourceDelta delta) {
						IResource changedResource = delta.getResource();
//						if (!(changedResource instanceof IFile))
//							return true;
/*						System.out.println("Resource " + changedResource + " deltaed " + delta.getKind());
						if (delta instanceof ResourceDelta) {
							StringBuffer s = new StringBuffer();
							if (delta.getMarkerDeltas().length > 0)
								((ResourceDelta)delta).writeMarkerDebugString(s);
							else
								s.append("[]");
							System.out.println(s.toString());
						} */
						if (changedResource.equals(registryResource))
							registryChanged();
						return true;
					}					
				});
			} catch (CoreException e) {
			}
		}
		if (event.getType() == IResourceChangeEvent.PRE_CLOSE){
			Display.getDefault().asyncExec(new Runnable(){
				public void run(){
					IFileEditorInput fileEditorInput = getEditorInput();
					IProject project = fileEditorInput.getFile().getProject();
					IWorkbenchPage[] pages = getSite().getWorkbenchWindow().getPages();
					for (IWorkbenchPage page : pages) {
						if (project.equals(event.getResource())){
							IEditorPart editorPart = page.findEditor(fileEditorInput);	// FIXME which page?
							page.closeEditor(editorPart, true);
						}
					}
				}            
			});
		}
	}

	@Override
	protected void resumeResourceListening() {
		for (IPageManager pageManager : pageManagers.values())
			pageManager.resumeResourceListening();
	}
	
	public void selectionChanged(SelectionChangedEvent selectionChangedEvent) {
		setSelection(selectionChangedEvent.getSelection());
	}
	
	@Override
	public void setActivePage(int pageIndex) {
/*		List<IPageManager> disposals = null;	// Trap any pages that have been closed
		for (IPageManager pageManager : pageManagers.values()) {
			int i = getPageIndex(pageManager.getEditor());
			if (i < 0) {
				if (disposals == null)
					disposals = new ArrayList<IPageManager>();
				disposals.add(pageManager);
			}
		}
		if (disposals != null)
			for (IPageManager pageManager : disposals) {
				removePageManager(pageManager);
				pageManager.dispose();
			} */
		super.setActivePage(pageIndex);
	}

	public void setActivePageManager(IPageManager newPageManager, long pageChangeTimeStamp) {
		try {
//			if (validPageManager != null)
				newPageManager.activate(getProgressMonitor(), pageChangeTimeStamp);
			IUndoContext undoContext = newPageManager.getUndoContext();
			if (undoContext != null) {
				ObjectUndoContext editorUndoContext = getUndoContext();
				if (!editorUndoContext.matches(undoContext))
					editorUndoContext.addMatch(undoContext);
			}
			if (activePageManager != newPageManager) {
				if (activePageManager != null) {
					int oldPageIndex = getPageIndex(activePageManager.getEditor());
					if (oldPageIndex >= 0)
						showDirtyPage(false);			
				}
				if (currentSelectionProvider == activePageManager)
					setCurrentSelectionProvider(newPageManager);
//				if ((activePageManager != null) && (currentSelectionProvider != activePageManager))
//					activePageManager.removeSelectionChangedListener(selectionChangedListener);
				activePageManager = newPageManager;
//				if ((activePageManager != null) && (currentSelectionProvider != activePageManager))
//					activePageManager.addSelectionChangedListener(selectionChangedListener);
//				System.out.println("PagedEditor.activePageManager changed to " + activePageManager);
				activePageManager.refresh();
				IEditorPart editorPart = activePageManager.getEditor();
				setActiveEditor(editorPart); 	 // Do change now.
				int pageIndex = getPageIndex(editorPart);
				if (pageIndex >= 0) {
//					setActivePage(pageIndex);
					super.pageChange(pageIndex);
				}
			}
		} catch (Exception e) {
			String message = "Error activating " + newPageManager.getTitle() + " editor";
			showError(message, e);
		}
	}
	
	/**
	 * This makes sure that one content viewer, either for the current page or the outline view, if it has focus,
	 * is the current one.
	 */
	public void setCurrentSelectionProvider(ISelectionProvider newSelectionProvider)
	{
		// If it is changing...
		//
		if (currentSelectionProvider != newSelectionProvider)
		{
			// Stop listening to the old one.
			//
			if (currentSelectionProvider != null)
				currentSelectionProvider.removeSelectionChangedListener(this);
			// Remember it.
			//
			currentSelectionProvider = newSelectionProvider;
			// Start listening to the new one.
			//
			if (currentSelectionProvider != null)
				currentSelectionProvider.addSelectionChangedListener(this);
//			System.out.println("PagedEditor.currentSelectionProvider changed to " + newSelectionProvider);
			// Set the editors selection based on the current viewer's selection.
			//
//			setSelection(currentSelectionProvider == null ? StructuredSelection.EMPTY : currentViewer.getSelection());
			setSelection(currentSelectionProvider == null ? StructuredSelection.EMPTY : currentSelectionProvider.getSelection());
		}
	}

	@Override
	public void setFocus() {
		getControl(getActivePage()).setFocus();
	}

	@Override
	protected void setPageText(int pageIndex, String text) {
		if ((pageIndex == getActivePage()) && isDirtyPage())
			text = "*" + text;
		if (traceEditorShowDirty.isActive())
			traceEditorShowDirty.println("setPageText " + pageIndex + ":" + text);		
		super.setPageText(pageIndex, text);
	}

	public void setPageTitle(IEditorPart editor, String title) {
		int pageIndex = getPageIndex(editor);
		if (pageIndex >= 0) {
			setPageText(pageIndex, title);
		}
	}
	
	/**
	 * This implements {@link org.eclipse.jface.viewers.ISelectionProvider}
	 * to set this editor's overall selection. Calling this result will
	 * notify the listeners.
	 */
	@Override
	public void setSelection(ISelection selection) {
//		selectionProvider.setSelection(selection);
		if ((selection != null) && selection.equals(editorSelection))
			return;
		editorSelection = selection;
//		System.out.println("PagedEditor.editorSelection changed to " + editorSelection);
		for (ISelectionChangedListener listener : selectionChangedListeners)
			listener.selectionChanged(new SelectionChangedEvent(this, selection));
		if (activePageManager != null)
			activePageManager.setSelection(selection);
		if (contentOutlinePage != null)
			contentOutlinePage.setSelection(selection);
		setSelectionToStatusLineManager(selection);
	}
	
	/**
	 * This implements {@link org.eclipse.jface.viewers.ISelectionProvider}
	 * to set this editor's overall selection. Calling this result will
	 * notify the listeners.
	 */
	public void setSelectionToAll(ISelection selection) {
		if ((selection != null) && selection.equals(editorSelection))
			return;
		editorSelection = selection;
//		System.out.println("PagedEditor.editorSelection changed to " + editorSelection);
//		for (ISelectionChangedListener listener : selectionChangedListeners)
//			listener.selectionChanged(new SelectionChangedEvent(this, selection));
		if (activePageManager != null)
			activePageManager.setSelection(selection);
		if (contentOutlinePage != null)
			contentOutlinePage.setSelection(selection);
		setSelectionToStatusLineManager(selection);
	}

	/**
	 */
	public void setSelectionToStatusLineManager(ISelection selection) {
		boolean isOutline = (contentOutlinePage != null) && (currentSelectionProvider == contentOutlinePage.getTreeViewer());
		IStatusLineManager statusLineManager = isOutline ? contentOutlinePage.getStatusLineManager()
														 : getActionBars().getStatusLineManager();
		if (statusLineManager != null) {
			if (selection instanceof IStructuredSelection) {
				Collection<?> collection = ((IStructuredSelection) selection).toList();
				switch (collection.size()) {
					case 0: {
						statusLineManager.setMessage(getString("_UI_NoObjectSelected"));
						break;
					}
					case 1: {
						String text = new AdapterFactoryItemDelegator(getAdapterFactory()).getText(collection.iterator().next());
						statusLineManager.setMessage(getString("_UI_SingleObjectSelected", text));
						break;
					}
					default: {
						statusLineManager.setMessage(getString("_UI_MultiObjectSelected", Integer.toString(collection.size())));
						break;
					}
				}
			} else {
				statusLineManager.setMessage("");
			}
		}
	}

	/**
	 * This sets the selection into whichever viewer is active.
	 */
	public void setSelectionToViewer(Collection<?> collection) {
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
					if (currentSelectionProvider != null)
						currentSelectionProvider.setSelection(new StructuredSelection(theSelection.toArray())/*, true*/);
				}
			};
			runnable.run();
		}
	}

	public static TracingOption traceEditorShowDirty = new TracingOption("editor/show/dirty");
	public static TracingOption traceOperationHistory = new TracingOption("operation/history");
	
	public void showDirtyPage(boolean isDirtyPage) {
		String title = activePageManager.getTitle();
		if (traceEditorShowDirty.isActive())
			traceEditorShowDirty.println(Boolean.toString(isDirtyPage));		
		int pageIndex = getPageIndex(activePageManager.getEditor());
		if (pageIndex >= 0)
			setPageText(pageIndex, title);
	}

	public void showError(String message, Exception e) {
		IStatus status;
		if (e instanceof CoreException)
			status = ((CoreException) e).getStatus();
		else
			status = QVTEditorPlugin.createErrorStatus(message, e);
		String title = getCreationFactory().getEditorName() + " Editor Problem";
		ErrorDialog.openError(getShell(), title, message, status);
		if (e != null)
			QVTEditorPlugin.logError(message, e);
	}

	@Override
	protected void suspendResourceListening() {
		for (IPageManager pageManager : pageManagers.values())
			pageManager.suspendResourceListening();
	}

	@Override
	public String toString() {
		IFile editorInputFile = getEditorInputFile();
		if (editorInputFile == null)
			return getClass().getSimpleName() + " null-editor-input-file";
		else
			return getClass().getSimpleName() + " '" + editorInputFile.getName().toString() + "'";
	}

	public ISelection unwrapEditPartSelection(ISelection selection) {
		return selection;
	}
}
