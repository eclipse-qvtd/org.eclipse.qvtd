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

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.qvt.declarative.ecore.adapters.AdaptingEObject;
import org.eclipse.qvt.declarative.ecore.adapters.AdaptingXMIResource;
import org.eclipse.qvt.declarative.ecore.adapters.ResourceSetMappingMetaDataRegistryAdapter;
import org.eclipse.qvt.declarative.ecore.mappings.IMappingMetaData;
import org.eclipse.qvt.declarative.ecore.mappings.IMappingMetaDataRegistry;
import org.eclipse.qvt.declarative.editor.ui.IMasterPageManager;
import org.eclipse.qvt.declarative.editor.ui.paged.PagedEditor;

/**
 * An EMOFXMLPageFactory manages creation of EMOF XML pages.
 */
public class EMOFXMLPageFactory extends XMLPageFactory
{
	public static final String PAGE_TITLE = "EMOF XMI";

	public EMOFXMLPageFactory(PagedEditor pagedEditor) {
		super(pagedEditor);
	}
	
	public static boolean isPackageBased(XMLResource e) {
		if (e == null)
			return false;
		List<EObject> contents = e.getContents();
		if (contents.isEmpty())
			return false;
		EClass ePackageMetaClass = EcorePackage.eINSTANCE.eClass();
		for (EObject content : contents) {		// content is an EPackage or derivation
			if (!(content instanceof AdaptingEObject))
				return false;
			content = ((AdaptingEObject)content).getTarget();
			EClass metaClass = content.eClass();					
			if (!ePackageMetaClass.isSuperTypeOf(metaClass))
				return false;
		}
		return true;
	}
	
	@Override
	public IMasterPageManager createMasterPageFor(PagedEditor pagedEditor, XMLResource resource) {
		if (!EcoreXMLPageFactory.isEPackageBased(resource) && !resource.getContents().isEmpty())
			return null;
		AdaptingXMIResource adapter = AdaptingXMIResource.findAdapter(resource);
		if (adapter == null)
			return null;
		return createPageFor(pagedEditor, resource);
	}

	@Override
	public void createOtherPagesFor(PagedEditor pagedEditor) {
		IMasterPageManager masterPageManager = pagedEditor.getMasterPageManager();
		if (masterPageManager instanceof EMOFXMLPageManager)
			return;
		XMLResource resource = masterPageManager.getEcoreResource();
		if (resource != null)
			createPageFor(pagedEditor, resource);
	}

	@Override
	public EMOFXMLPageManager createPageFor(PagedEditor pagedEditor, XMLResource resource) {
//		boolean isEMOF = !isText && AdaptingXMIResource.findAdapter(ecoreResource) != null;
		try {
			if (resource.getContents().size() > 0) {
				EObject rootObject = resource.getContents().get(0);
				ResourceSet resourceSet = resource.getResourceSet();
				IMappingMetaData mappingMetaData = creationFactory.getMappingMetaData();
				IMappingMetaDataRegistry mappingMetaDataRegistry = ResourceSetMappingMetaDataRegistryAdapter.getMappingMetaDataRegistry(resourceSet, mappingMetaData);
				mappingMetaDataRegistry.getAdapter(rootObject);	// throws if no EMOF support
			}
			EMOFXMLPageManager pageManager = new EMOFXMLPageManager(pagedEditor, resource, PAGE_TITLE);
			pagedEditor.addPageManager(pageManager);
			return pageManager;
		} catch (Exception e) {
//				isEMOF = false;
			return null;
		}
	}
}