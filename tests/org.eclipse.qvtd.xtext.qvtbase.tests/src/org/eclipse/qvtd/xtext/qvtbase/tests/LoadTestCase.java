/*******************************************************************************
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtbase.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.EMOFResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.library.StandardLibraryContribution;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManagerResourceSetAdapter;
import org.eclipse.ocl.examples.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.examples.xtext.base.utilities.CS2PivotResourceAdapter;

/**
 * Tests that load a model and verify that there are no unresolved proxies as a result.
 */
public class LoadTestCase extends XtextTestCase
{	
	protected MetaModelManager metaModelManager = null;

	public Resource doLoad_Concrete(String stem, String extension) throws IOException {
		String inputName = stem + "." + extension;
		URI inputURI = getProjectFileURI(inputName);
		return doLoad_Concrete(inputURI);
	}

	protected Resource doLoad_Concrete(@NonNull URI inputURI) throws IOException {
		String inputName = inputURI.lastSegment();
		String cstName = inputName + ".xmi";
		String pivotName = inputName + ".pivot";
		URI cstURI = getProjectFileURI(cstName);
		URI pivotURI = getProjectFileURI(pivotName);
		//		URI savedURI = getProjectFileURI(savedName);
		//		MetaModelManager metaModelManager = new MetaModelManager();
		//		MetaModelManagerResourceSetAdapter.getAdapter(resourceSet, metaModelManager);
				CS2PivotResourceAdapter adapter = null;
				try {
					BaseCSResource xtextResource = (BaseCSResource) resourceSet.getResource(inputURI, true);
					assertNoResourceErrors("Load failed", xtextResource);
					adapter = xtextResource.getCS2ASAdapter(null);
					Resource pivotResource = adapter.getASResource(xtextResource);
		//			assertNoUnresolvedProxies("Unresolved proxies", xtextResource);
			//		System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " validate()");
					assertNoValidationErrors("Validation errors", xtextResource.getContents().get(0));
			//		System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " validated()");
		//			xtextResource.setURI(savedURI);
		//			xtextResource.save(null);
		//			xtextResource.setURI(inputURI);
		//			assertNoResourceErrors("Save failed", xtextResource);
					saveAsXMI(xtextResource, cstURI);
					pivotResource.setURI(pivotURI);
					assertNoValidationErrors("Pivot validation errors", pivotResource.getContents().get(0));
					Map<String, Object> options = new HashMap<String, Object>();
					options.put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
				    pivotResource.save(options);
					return pivotResource;
				}
				finally {
//					if (adapter != null) {
//						adapter.dispose();
//						adapter.getMetaModelManager().dispose();
//					}
				}
	}

	protected void saveAsXMI(Resource resource, URI xmiURI) throws IOException {
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl()); //$NON-NLS-1$
		Resource xmiResource = resourceSet.createResource(xmiURI);
		xmiResource.getContents().addAll(resource.getContents());
		Map<String, Object> options = new HashMap<String, Object>();
//		options.put(XMLResource.OPTION_SCHEMA_LOCATION_IMPLEMENTATION, Boolean.TRUE);
		xmiResource.save(options);
		assertNoResourceErrors("Save failed", xmiResource);
		resource.getContents().addAll(xmiResource.getContents());
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		configurePlatformResources();
		EcorePackage.eINSTANCE.getClass();						// Workaround Bug 425841
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("emof", new EMOFResourceFactoryImpl()); //$NON-NLS-1$
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("pivot", new XMIResourceFactoryImpl()); //$NON-NLS-1$
	}

	@Override
	protected void tearDown() throws Exception {
		MetaModelManagerResourceSetAdapter adapter = MetaModelManagerResourceSetAdapter.findAdapter(resourceSet);
		if (adapter != null) {
			MetaModelManager metaModelManager = adapter.getMetaModelManager();
			if (metaModelManager != null) {
				metaModelManager.dispose();
			}
		}
		if (metaModelManager != null) {
			metaModelManager.dispose();
			metaModelManager = null;
		}
		StandardLibraryContribution.REGISTRY.remove(MetaModelManager.DEFAULT_OCL_STDLIB_URI);
		super.tearDown();
	}
}
