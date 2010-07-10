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
package org.eclipse.qvt.declarative.editor.ui.xml;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.ocl.examples.modelregistry.environment.FileHandle;
import org.eclipse.ocl.lpg.ProblemHandler.Phase;
import org.eclipse.ocl.lpg.ProblemHandler.Severity;
import org.eclipse.qvt.declarative.ecore.mappings.MappingConfigurationException;
import org.eclipse.qvt.declarative.editor.ui.paged.PagedEditor;
import org.eclipse.qvt.declarative.editor.ui.pages.EditorPageManager;
import org.eclipse.qvt.declarative.editor.ui.text.LazyTextPageEditor;
import org.eclipse.qvt.declarative.parser.environment.ICSTFileEnvironment;
import org.eclipse.qvt.declarative.parser.utils.ProblemCounter;

/**
 * An XMLPageManager manages editing of the primary edit Resource as an XMI text file.
 */
public abstract class XMLPageManager extends EditorPageManager
{
	public XMLPageManager(PagedEditor pagedEditor, XMLResource resource, String pageTitle) {
		super(pagedEditor, resource, false, pageTitle);
		// FIXME BadBug editing XML view of CST source reconstructs CST from wrong resource
	}

	public ProblemCounter cannotDeactivate(Map<XMLResource,XMLResource> updates, IProgressMonitor monitor) {
		final ResourceSet resourceSet = getResourceSet();
		FileHandle fileHandle = getFileHandle();
		ICSTFileEnvironment environment = getCreationFactory().createFileEnvironment(fileHandle, resourceSet, resource.getURI());
		ProblemCounter reporter = new ProblemCounter();
		environment.setProblemHandler(reporter);
		InputStream inputStream = new ByteArrayInputStream(getCurrentContents().getBytes());
		String fatalMessage = null;
		try {		// FIXME WIP Simplify, error handling
//			String rootURI = resourceSet.getRootURI(inputStream);
//			inputStream.reset();
//			Resource.Factory resourceFactory = resourceSet.getResourceFactory(rootURI);
//			XMLResource newResource = (XMLResource) resourceFactory.createResource(resource.getURI());
//			newResource.load(inputStream, null);
			XMLResource newResource = (XMLResource) resourceSet.getResource(resource.getURI(), true);
			updates.put(resource, getEcoreResource(newResource));
//		} catch (SAXParseException e) {
//			fatalMessage = "XMI analysis gives " + e.getMessage() + " at line " + e.getLineNumber() + ":" + e.getColumnNumber();
//		} catch (IOWrappedException e) {
//			Throwable t = e.getCause();
//			if (t instanceof XMIException)
//				fatalMessage = "XMI analysis gives " + t.getMessage() + " at line " + ((XMIException)t).getLine() + ":" + ((XMIException)t).getColumn();
//			else
//				fatalMessage = "XMI analysis gives " + e.getMessage();
		} catch (Exception e) {
			fatalMessage = "XMI analysis gives " + e.getMessage();
		}
		if (fatalMessage != null)
			reporter.handleProblem(Severity.FATAL, Phase.UTILITY, fatalMessage, "", -1, -1);
		return reporter;
	}

	public void createContents(OutputStream outputStream) throws MappingConfigurationException, IOException {
		getCreationFactory().assignXmiIds(resource);
		resource.save(outputStream, null);
	}

	@Override
	protected LazyTextPageEditor createEditor() {
		return new XMLPageEditor(this);
	}
	
	protected XMLResource getEcoreResource(XMLResource resource) {
		return resource;
	}

	public void refresh() {}
}