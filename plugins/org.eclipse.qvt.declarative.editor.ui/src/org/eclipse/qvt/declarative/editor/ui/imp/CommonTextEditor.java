/**
 * <copyright>
 * 
 * Copyright (c) 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: CommonTextEditor.java,v 1.3 2008/09/28 12:14:59 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.ui.imp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.impl.TransactionalEditingDomainImpl;
import org.eclipse.emf.transaction.ui.provider.TransactionalAdapterFactoryContentProvider;
import org.eclipse.emf.workspace.IWorkspaceCommandStack;
import org.eclipse.imp.editor.LanguageServiceManager;
import org.eclipse.imp.editor.UniversalEditor;
import org.eclipse.imp.parser.ISourcePositionLocator;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextViewerExtension6;
import org.eclipse.jface.text.IUndoManager;
import org.eclipse.jface.text.IUndoManagerExtension;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.qvt.declarative.editor.ui.ICreationFactory;
import org.eclipse.qvt.declarative.editor.ui.cst.ASTOutlinePage;
import org.eclipse.qvt.declarative.editor.ui.cst.CSTOutline;
import org.eclipse.qvt.declarative.editor.ui.cst.CSTOutlinePage;
import org.eclipse.qvt.declarative.editor.ui.cst.ICSTOutlinePage;
import org.eclipse.qvt.declarative.editor.ui.paged.PagedEditingDomainFactory;
import org.eclipse.qvt.declarative.editor.ui.text.ITextEditorWithUndoContext;
import org.eclipse.qvt.declarative.parser.utils.ASTandCST;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.text.undo.DocumentUndoManagerRegistry;
import org.eclipse.text.undo.IDocumentUndoManager;
import org.eclipse.ui.IEditorActionBarContributor;
import org.eclipse.ui.part.IShowInTargetList;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.PropertySheetPage;

public class CommonTextEditor extends UniversalEditor implements ITextEditorWithUndoContext
{	
	/**
	 * This keeps track of the editing domain that is used to track all changes to the model.
	 */
	protected TransactionalEditingDomainImpl editingDomain;
	/**
	 * This is the property sheet page.
	 */
	protected IPropertySheetPage propertySheetPage = null;
	/**
	 * This is the AST outline page.
	 */
	protected IContentOutlinePage astOutlinePage = null;
	/**
	 * This is the CST outline page.
	 */
	protected ICSTOutlinePage cstOutlinePage = null;
	/**
	 * This is the list of extra views for the Show In menu.
	 */
	protected IShowInTargetList showInTargetList = null;

	public CommonTextEditor() {
	    initializeEditingDomain();
	}

	protected IContentOutlinePage createASTOutlinePage() {
		return new ASTOutlinePage(this);
	}

	protected ICSTOutlinePage createCSTOutlinePage() {
		return new CSTOutlinePage(this);
	}

	protected IPropertySheetPage createPropertySheetPage() {
		PropertySheetPage page = new CommonPropertySheetPage(this);
		page.setPropertySourceProvider(new TransactionalAdapterFactoryContentProvider(getTransactionalEditingDomain(), getAdapterFactory()));
		return page;
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

	@Override
	public void doSave(IProgressMonitor progressMonitor) {
		//
		//	Bugzilla 224324 part 1. Ensure that partial text operation does not continue across save.
		//
		IDocument document = getDocumentProvider().getDocument(getEditorInput());
		if (document != null) {
			IDocumentUndoManager documentUndoManager = DocumentUndoManagerRegistry.getDocumentUndoManager(document);
			if (documentUndoManager != null)
				documentUndoManager.commit();
		}
		super.doSave(progressMonitor);
	}
	
	protected Object getASTNode(ISelection selection) {
		Object node = getCSTNode((TextSelection) selection);
		if (node instanceof CSTNode) {
			for (Object cstNode = node; cstNode instanceof CSTNode; cstNode = ((EObject) cstNode).eContainer()) {
				node = ((CSTNode)cstNode).getAstNode();
				if (node != null)
					break;
			}
		}
		return node;
	}

	protected List<Object> getASTNodes(ISelection selection) {
		CommonParseController parseController = getParseController();
		List<Object> unwrappedSelections = new ArrayList<Object>(((IStructuredSelection)selection).size());
		for (Iterator<?> i = ((IStructuredSelection)selection).iterator(); i.hasNext(); ) {
			Object node = parseController.getASTNode(i.next());
			if (node != null)
				unwrappedSelections.add(node);
		}
		return unwrappedSelections;
	}

	public ISelection getASTSelection(ISelection selection) {
		if (selection instanceof TextSelection) {
			Object node = getASTNode(selection);
			selection = node != null ? new StructuredSelection(node) : StructuredSelection.EMPTY;
		}
		else if ((selection instanceof IStructuredSelection) && !selection.isEmpty()) {
			List<Object> unwrappedSelections = getASTNodes(selection);
			selection = new StructuredSelection(unwrappedSelections);		
		}
		return selection;
	}

	protected List<Object> getASTorCSTNodes(ISelection selection) {
		CommonParseController parseController = getParseController();
		List<Object> unwrappedSelections = new ArrayList<Object>(((IStructuredSelection)selection).size());
		for (Iterator<?> i = ((IStructuredSelection)selection).iterator(); i.hasNext(); ) {
			Object node = parseController.getASTorCSTNode(i.next());
			if (node != null)
				unwrappedSelections.add(node);
		}
		return unwrappedSelections;
	}

	public ISelection getASTorCSTSelection(ISelection selection) {
		if (selection instanceof TextSelection) {
			Object node = getASTNode(selection);
			selection = node != null ? new StructuredSelection(node) : StructuredSelection.EMPTY;
		}
		else if ((selection instanceof IStructuredSelection) && !selection.isEmpty()) {
			List<Object> unwrappedSelections = getASTorCSTNodes(selection);
			selection = new StructuredSelection(unwrappedSelections);			
		}
		return selection;
	}

	public IAnnotationModel getAnnotationModel() {	
		return getDocumentProvider().getAnnotationModel(getEditorInput());
	}

	public Annotation[] getAnnotations() {
		IAnnotationModel annotationModel = getAnnotationModel();
		List<Annotation> annotationList = new ArrayList<Annotation>();
		for (Iterator<?> i = annotationModel.getAnnotationIterator(); i.hasNext(); ) {
			Annotation annotation = (Annotation) i.next();
			if (PARSE_ANNOTATION_TYPE.equals(annotation.getType()))
				annotationList.add(annotation);
		}
		return annotationList.toArray(new Annotation[annotationList.size()]);
	}

	protected Object getCSTNode(TextSelection selection) {
		CommonParseController parseController = getParseController();
		int length = selection.getLength();
		int offset = selection.getOffset();
		ISourcePositionLocator nodeLocator = parseController.getNodeLocator();
		ASTandCST currentAst = parseController.getCurrentAst();
		return nodeLocator.findNode(currentAst.getCST(), offset, offset+length);
	}

	protected List<CSTNode> getCSTNodes(ISelection selection) {
		CommonParseController parseController = getParseController();
		List<CSTNode> unwrappedSelections = new ArrayList<CSTNode>(((IStructuredSelection)selection).size());
		for (Iterator<?> i = ((IStructuredSelection)selection).iterator(); i.hasNext(); ) {
			CSTNode node = parseController.getCSTNode(i.next());
			if (node != null)
				unwrappedSelections.add(node);
		}
		return unwrappedSelections;
	}

	public ISelection getCSTSelection(ISelection selection) {
		if (selection instanceof TextSelection) {
			Object node = getCSTNode((TextSelection) selection);
			selection = node != null ? new StructuredSelection(node) : StructuredSelection.EMPTY;
		}
		else if ((selection instanceof IStructuredSelection) && !selection.isEmpty()) {
			List<CSTNode> unwrappedSelections = getCSTNodes(selection);
			selection = new StructuredSelection(unwrappedSelections);			
		}
		return selection;
	}

	public IEditorActionBarContributor getActionBarContributor() {
	    return getEditorSite().getActionBarContributor();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object getAdapter(Class key) {
		if (key.equals(IPropertySheetPage.class)) {
			if (propertySheetPage == null)
				propertySheetPage = createPropertySheetPage();
			return propertySheetPage;
		}
        if (key.equals(IContentOutlinePage.class)) {
			if (astOutlinePage  == null)
				astOutlinePage = createASTOutlinePage();
			return astOutlinePage;
        }
        if (key.equals(ICSTOutlinePage.class)) {
			if (cstOutlinePage  == null)
				cstOutlinePage = createCSTOutlinePage();
			return cstOutlinePage;
        }
        if (key.equals(IShowInTargetList.class)) {
			if (showInTargetList  == null)
				showInTargetList = createShowInTargetList();
			return showInTargetList;
        }
		return super.getAdapter(key);
	}

	public AdapterFactory getAdapterFactory() {
		return editingDomain.getAdapterFactory();
	}

//	@Override
	public AdapterFactoryEditingDomain getAdapterFactoryEditingDomain() {
		return editingDomain;
	}

	public ICreationFactory getCreationFactory() {
		return getParseController().getCreationFactory();
	}

	public Display getDisplay() {
		return getShell().getDisplay();
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

//	@Override
	public EditingDomain getEditingDomain() {
		return editingDomain;
	}

	public String getEditingDomainID() {
		return "org.eclipse.qvt.declarative.editingDomainID";		// FIXME share this with diagram editor plugin.xml's
	}

	public LanguageServiceManager getLanguageServiceManager() {
		return fLanguageServiceManager;
	}

	public IOperationHistory getOperationHistory() {
		return getWorkspaceCommandStack().getOperationHistory();
	}

	@Override
	public CommonParseController getParseController() {
		return (CommonParseController) super.getParseController();
	}

	public ISelectionChangedListener getSelectionListener() {
		return getSelectionChangedListener();
	}

	public Shell getShell() {
		return getSite().getShell();
	}

	public TransactionalEditingDomain getTransactionalEditingDomain() {
		return editingDomain;
	}
	
	public IUndoContext getUndoContext() {
		ISourceViewer sourceViewer = getSourceViewer();
		if (sourceViewer instanceof ITextViewerExtension6) {
			IUndoManager undoManager= ((ITextViewerExtension6)sourceViewer).getUndoManager();
			if (undoManager instanceof IUndoManagerExtension)
				return ((IUndoManagerExtension)undoManager).getUndoContext();
		}
		return null;
	}

	public IWorkspaceCommandStack getWorkspaceCommandStack() {
//		return (IWorkspaceCommandStack) super.getCommandStack();
		return (IWorkspaceCommandStack) editingDomain.getCommandStack();
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

	public boolean refresh() {
		CommonParseController parseController = getParseController();
		ASTandCST initialAst = parseController.getCurrentAst();
		for (int i = 0; i < 50; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
			if (parseController.getCurrentAst() != initialAst)
				return true;
		}
		return false;
	}
}
