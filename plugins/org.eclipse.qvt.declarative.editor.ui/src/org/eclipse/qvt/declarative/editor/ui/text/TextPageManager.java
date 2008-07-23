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
package org.eclipse.qvt.declarative.editor.ui.text;

import java.io.IOException;
import java.io.OutputStream;
import java.io.StringReader;
import java.util.Collection;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.eclipse.ocl.lpg.ProblemHandler;
import org.eclipse.ocl.lpg.ProblemHandler.Phase;
import org.eclipse.ocl.lpg.ProblemHandler.Severity;
import org.eclipse.qvt.declarative.ecore.mappings.MappingConfigurationException;
import org.eclipse.qvt.declarative.editor.ui.QVTEditorPlugin;
import org.eclipse.qvt.declarative.editor.ui.builder.MarkerProblemHandler;
import org.eclipse.qvt.declarative.editor.ui.paged.PagedEditor;
import org.eclipse.qvt.declarative.editor.ui.pages.EditorPageManager;
import org.eclipse.qvt.declarative.modelregistry.eclipse.EclipseFileHandle;
import org.eclipse.qvt.declarative.modelregistry.eclipse.EclipseProjectHandle;
import org.eclipse.qvt.declarative.modelregistry.environment.AbstractFileHandle;
import org.eclipse.qvt.declarative.parser.environment.IFileEnvironment;
import org.eclipse.qvt.declarative.parser.unparser.AbstractUnparser;
import org.eclipse.qvt.declarative.parser.utils.ProblemCounter;
import org.eclipse.ui.ide.IDE;

/**
 * A TextPageManager manages editing of the primary edit Resource as a concrete syntax text file.
 */
public class TextPageManager extends EditorPageManager
{
	protected final TextResource textResource;
	
	public TextPageManager(PagedEditor pagedEditor, XMLResource resource, TextResource textResource) {
		super(pagedEditor, resource, textResource != null, pagedEditor.getCreationFactory().getEditorName() + " Text");
		this.textResource = textResource;
	}

	public ProblemCounter cannotDeactivate(Map<XMLResource,XMLResource> updates, IProgressMonitor monitor) {
		AbstractFileHandle fileHandle = getFileHandle();
		IFileEnvironment environment = getCreationFactory().createFileEnvironment(fileHandle, getResourceSet());
		ProblemCounter reporter = new ProblemCounter();
		environment.setProblemHandler(reporter);
		StringReader reader = new StringReader(getCurrentContents());
		try {
			Collection<? extends EObject> newRootObjects = environment.parseToAST(reader, null);
//			environment.validate(newRootObjects);
			XMLResource newResource = new XMLResourceImpl(resource.getURI());
			newResource.getContents().addAll(newRootObjects);
			environment.validate(newResource);
			// FIXME re-use xmi:id's by CST matching
			updates.put(resource, newResource);
			reporter.flush(null);
		} catch (Exception e) {
			QVTEditorPlugin.logError("Internal error while validating", e);
			reporter.handleProblem(Severity.FATAL, Phase.UTILITY, e.getMessage(), "", -1, -1);
		}
		return reporter;
	}

	public void createContents(OutputStream outputStream) throws MappingConfigurationException, IOException {
		AbstractUnparser unparser = getCreationFactory().createUnparser(resource);
	    unparser.unparse();
	    outputStream.write(unparser.getBytes());
	}
			
	@Override protected LazyTextPageEditor createEditor() {
		return getCreationFactory().createTextEditor(this);
	}

	@Override
	public void doSave(IProgressMonitor monitor) throws OperationCanceledException {
		if (textResource != null)
			textResource.setSaveInProgress(true);
		try {
		super.doSave(monitor);
		refresh();
		} finally {
			if (textResource != null)
				textResource.setSaveInProgress(false);
		}
	}

	public String getFileExtension() {
		return getCreationFactory().getTextExtension();
	}

	@Override
	public boolean gotoMarker(IMarker marker) {
		try {
			Object builderId = marker.getAttribute(MarkerProblemHandler.BUILDER_ID);
			if (getCreationFactory().getBuilderId().equals(builderId)) {
				pagedEditor.setActiveEditor(getEditor());
				IDE.gotoMarker(getEditor(), marker);
				return true;
			}
		} catch (CoreException e) {
		}
		return false;
	}

	public void refresh() {
		refreshMarkers(getEditorInput().getFile());	// FIXME
	}

	protected void refreshMarkers(IFile file) {
		// Resolve references wrt to initial editor file name
		EclipseProjectHandle projectHandle = new EclipseProjectHandle(pagedEditor.getProject());
		EclipseFileHandle fileHandle = projectHandle.getFileHandle(pagedEditor.getEditorInputFile()); // FIXME
		IFileEnvironment environment = getCreationFactory().createFileEnvironment(fileHandle, getResourceSet());
		// Report errors wrt to current editor file name
		ProblemHandler reporter = getCreationFactory().createProblemHandler(file);
		environment.setProblemHandler(reporter);
		try {
			StringReader reader = new StringReader(getCurrentContents());
			Collection<? extends EObject> astNodes = environment.parseToAST(reader, null);
			URI uri = URI.createFileURI(file.toString());
			if (astNodes != null) {
				Resource resource = new ResourceImpl(uri);
				resource.getContents().addAll(astNodes);
				environment.validate(resource);
			}
		} catch (Exception e) {
			reporter.utilityProblem(ProblemHandler.Severity.ERROR, "Failed to refreshMarkers: " + e, null, -1, -1);
			QVTEditorPlugin.logError("Failed to refreshMarkers on " + file.getFullPath().toString(), e);
		} finally {
			reporter.flush(null);
		}
	}

	@Override public void saveTo(IFile file, IProgressMonitor monitor) {
		refreshMarkers(file);
		super.saveTo(file, monitor);
	}
}