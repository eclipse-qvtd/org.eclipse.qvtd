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

import java.io.IOException;
import java.io.OutputStream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.qvt.declarative.ecore.adapters.AdaptingXMIResource;
import org.eclipse.qvt.declarative.ecore.mappings.IMappingMetaDataRegistry;
import org.eclipse.qvt.declarative.ecore.mappings.MappingConfigurationException;
import org.eclipse.qvt.declarative.editor.ui.paged.PagedEditor;

/**
 * An EMOFPageManager manages editing of the primary edit Resource as an EMOF-based XMI text file.
 */
public class EMOFXMLPageManager extends XMLPageManager
{
	public EMOFXMLPageManager(PagedEditor pagedEditor, XMLResource resource, String pageTitle) {
		super(pagedEditor, resource, pageTitle);
	}

	@Override
	public void createContents(OutputStream outputStream) throws MappingConfigurationException, IOException {
		getCreationFactory().assignXmiIds(resource);
		URI ecoreURI = resource.getURI();
		URI emofURI = ecoreURI.trimFileExtension().appendFileExtension(getFileExtension());
		IMappingMetaDataRegistry mappingMetaDataRegistry = pagedEditor.getMappingMetaDataRegistry();
		Resource emofResource = mappingMetaDataRegistry.getAdapter(resource, emofURI);
		emofResource.save(outputStream, null);
	}
	
	@Override protected XMLResource getEcoreResource(XMLResource resource) {
		return (XMLResource) ((AdaptingXMIResource) resource).getTarget();
	}

	public String getFileExtension() {
		return getCreationFactory().getEMOFExtension();
	}
}