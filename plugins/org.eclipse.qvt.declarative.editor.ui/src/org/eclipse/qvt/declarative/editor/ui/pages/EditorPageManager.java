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
package org.eclipse.qvt.declarative.editor.ui.pages;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.ocl.examples.modelregistry.eclipse.EclipseProjectHandle;
import org.eclipse.ocl.examples.modelregistry.environment.FileHandle;
import org.eclipse.qvt.declarative.ecore.mappings.MappingConfigurationException;
import org.eclipse.qvt.declarative.editor.ui.IMasterPageManager;
import org.eclipse.qvt.declarative.editor.ui.QVTEditorPlugin;
import org.eclipse.qvt.declarative.editor.ui.paged.PagedEditor;
import org.eclipse.qvt.declarative.editor.ui.text.ITextEditorWithUndoContext;
import org.eclipse.qvt.declarative.editor.ui.text.LazyFileEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.texteditor.IDocumentProvider;

public abstract class EditorPageManager extends AbstractPageManager<ITextEditorWithUndoContext> implements IMasterPageManager
{
	public static final class ByteArrayOutputStream2InputStream extends ByteArrayOutputStream
	{
		public ByteArrayInputStream createInputStreamReusingBuffer() {
			return new ByteArrayInputStream(buf, 0, count);
		}
	}

	/**
	 * The resource for which this page manager supervises editing.
	 */
	protected final XMLResource resource;

	/**
	 * The editor input referring to a master file. Null if not a master page.
	 */
	protected final IFileEditorInput masterEditorInput;
	
	/**
	 * The editor input referring to a temporary file. This is lazily created to avoid
	 * undue start up cost.
	 */
	private LazyFileEditorInput lazyEditorInput = null;
	
	/**
	 * The editor input referring to a temporary file. This is lazily created to avoid
	 * undue start up cost.
	 */
	private IFileEditorInput currentEditorInput;

	/**
	 * True so long as the managed page edits a resource that has no valid ResourceSet representation.
	 */
	private boolean needsDeactivation;

	/**
	 * Timestamp of deactivated page change.
	 */
	private long deactivatedResourceSetTimeStamp = -1;
	
	public EditorPageManager(PagedEditor pagedEditor, XMLResource resource, boolean isMaster, String pageTitle) {
		super(pagedEditor, pageTitle);
		setEditor(createEditor());
		this.resource = resource;
		this.needsDeactivation = isMaster;
		IFileEditorInput pagedEditorInput = pagedEditor.getEditorInput();
		if (isMaster) {
	        masterEditorInput = pagedEditorInput;
	        currentEditorInput = pagedEditorInput;
		}
		else {
	        masterEditorInput = null;
			try {
				lazyEditorInput = createLazyEditorInput();
			} catch (CoreException e) {
				String message = "Error creating nested '" + pageTitle + "' editor";
				pagedEditor.showError(message, e);
			}
	        currentEditorInput = lazyEditorInput;
		}
 	}

	public void activate(IProgressMonitor monitor, long resourceSetTimeStamp) throws CoreException, IOException, MappingConfigurationException {
		// FIXME masterFile changed externally
//		if (isMaster() && !editorInput.hasContents()) {						// Initial load of master file
//			InputStream inputStream = masterEditorInput.getFile().getContents();
//			editorInput.setContents(inputStream, monitor);
//			editor.setInput(editorInput);
//		}
		if (isMaster()) {						// Initial load of master file
//			InputStream inputStream = masterEditorInput.getFile().getContents();
//			editorInput.setContents(inputStream, monitor);
//			editor.setInput(editorInput);
		}
		else if (resourceSetTimeStamp == deactivatedResourceSetTimeStamp) {	// Re-activation via undo page change			
//			InputStream inputStream = masterEditorInput.getFile().getContents();
//			editorInput.setContents(inputStream, monitor);
//			editor.setInput(editorInput);
		}
		else {																// Regeneration via do page change
			if (lazyEditorInput == null) {
				lazyEditorInput = createLazyEditorInput();
//				activatedResourceSetTimeStamp = resourceSetTimeStamp;
			}
			ByteArrayOutputStream2InputStream outputStream = new ByteArrayOutputStream2InputStream();
			createContents(outputStream);
			ByteArrayInputStream inputStream = outputStream.createInputStreamReusingBuffer();
			lazyEditorInput.setContents(inputStream, monitor);
			outputStream.close();
	        currentEditorInput = lazyEditorInput;
			editor.setInput(currentEditorInput);
		}
	}

	public void addSelectionChangedListener(ISelectionChangedListener listener) {}

	protected abstract ITextEditorWithUndoContext createEditor();

	@Deprecated // Use UniversalTextEditor
	protected LazyFileEditorInput createLazyEditorInput() throws CoreException {
		IFile masterFile = pagedEditor.getEditorInputFile();
		return new LazyFileEditorInput(pagedEditor.getTmpDir(), masterFile.getName(), getFileExtension());
	}

	public void deactivated(IProgressMonitor monitor, long resourceSetTimeStamp) {
		// FIXME master to lazy transition
		deactivatedResourceSetTimeStamp = resourceSetTimeStamp;
		needsDeactivation = false;
		editor.doSave(monitor);
	}

	public void doSave(IProgressMonitor monitor) throws OperationCanceledException {
		editor.doSave(monitor);
		if (monitor.isCanceled())
			throw new OperationCanceledException();
		assert isMaster() : "Should be master";
		if (lazyEditorInput != null) {
			try {
				InputStream inputStream = lazyEditorInput.getFile().getContents();
				masterEditorInput.getFile().setContents(inputStream, IResource.FORCE, monitor);
			} catch (CoreException e) {
				QVTEditorPlugin.logError("Failed to copy temporary file to master", e);
			}
	        currentEditorInput = masterEditorInput;
			editor.setInput(currentEditorInput);
			lazyEditorInput = null;
		}
	}

	@Override
	public IAction getAction(String actionID) {
		return editor.getAction(actionID);
	}

	public String getCurrentContents() {
		IDocumentProvider documentProvider = editor.getDocumentProvider();
		IDocument document = documentProvider.getDocument(currentEditorInput);
		return document != null ? document.get() : "";
	}

	public XMLResource getEcoreResource() {
		return resource;
	}
	
	public IFileEditorInput getEditorInput() {
		return isMaster() ? masterEditorInput : lazyEditorInput;
	}

	/**
	 * Return the FileHandle that defines the Model name resolution context.
	 * 
	 * @return primary input file handle
	 */
	protected FileHandle getFileHandle() {
		IProject project = pagedEditor.getProject();
		EclipseProjectHandle projectHandle = new EclipseProjectHandle(project);
		return projectHandle.getFileHandle(pagedEditor.getEditorInputFile());
	}

	public IEditorPart getInitialPage() {
		return getEditor();
	}

	public XMLResource getResource() {
		return resource;
	}

	public ISelection getSelection() {
		// FIXME convert CST to AST 
		return pagedEditor.getSelection();
	}

	@Override
	public IUndoContext getUndoContext() {
		return editor.getUndoContext();
	}

	public boolean gotoMarker(IMarker marker) {
		return false;
	}

	public boolean hasResourceSetTimeStamp(long resourceSetTimeStamp) {
		return deactivatedResourceSetTimeStamp == resourceSetTimeStamp;
	}
	
	public boolean isDirect() {
		return false;
	}

	public boolean isMaster() {
		return masterEditorInput != null;
	}

	public boolean needsDeactivation() {
		return needsDeactivation;
	}

	public void removeSelectionChangedListener(ISelectionChangedListener listener) {}

	public void saveTo(IFile file, IProgressMonitor monitor) {
		try {
			String contents = getCurrentContents();
			InputStream inputStream = new ByteArrayInputStream(contents.getBytes());
			if (file.exists())
				file.setContents(inputStream, true, true, monitor);
			else
				file.create(inputStream, true, monitor);
		} catch (Exception e) {
			String message = "Failed to save '" + getTitle() + "' editor to '" + file.getName() + "'";
			pagedEditor.showError(message, e);
		}
	}

	public void setSelection(ISelection selection) {
		// FIXME convert AST object to CST position		
	}
}