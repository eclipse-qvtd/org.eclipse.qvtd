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
import org.eclipse.ocl.pivot.internal.StandardLibraryImpl;
import org.eclipse.ocl.pivot.internal.library.StandardLibraryContribution;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManager;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManagerResourceSetAdapter;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.xtext.base.utilities.CS2ASResourceAdapter;

/**
 * Tests that load a model and verify that there are no unresolved proxies as a result.
 */
public class LoadTestCase extends XtextTestCase
{	
	protected MetamodelManager metamodelManager = null;

	public void doLoad_Concrete(@NonNull String inputName) throws IOException {
		OCL ocl = OCL.newInstance(getProjectMap());
		URI inputURI = getProjectFileURI(inputName);
		URI pivotURI = inputURI.trimFileExtension().appendFileExtension("qvtias");
		doLoad_Concrete(ocl, inputURI, pivotURI);
		ocl.dispose();
	}

	public Resource doLoad_Concrete(@NonNull OCL ocl, @NonNull String inputName, @NonNull String outputName) throws IOException {
		URI inputURI = getProjectFileURI(inputName);
		URI pivotURI = getProjectFileURI(outputName);
		return doLoad_Concrete(ocl, inputURI, pivotURI);
	}

	protected Resource doLoad_Concrete(@NonNull OCL ocl, @NonNull URI inputURI, @NonNull URI pivotURI) throws IOException {
		URI cstURI = pivotURI.trimFileExtension().appendFileExtension("xmi");
		BaseCSResource xtextResource = (BaseCSResource) ocl.getMetamodelManager().getExternalResourceSet().getResource(inputURI, true);
		assertNoResourceErrors("Load failed", xtextResource);
		CS2ASResourceAdapter adapter = xtextResource.getCS2ASAdapter(null);
		Resource pivotResource = adapter.getASResource(xtextResource);
//		assertNoUnresolvedProxies("Unresolved proxies", xtextResource);
//		System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " validate()");
		assertNoValidationErrors("Validation errors", xtextResource.getContents().get(0));
//		System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " validated()");
		saveAsXMI(xtextResource, cstURI);
		pivotResource.setURI(pivotURI);
		assertNoValidationErrors("Pivot validation errors", pivotResource.getContents().get(0));
		Map<String, Object> options = new HashMap<String, Object>();
		options.put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
	    pivotResource.save(options);
		return pivotResource;
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
		MetamodelManagerResourceSetAdapter adapter = MetamodelManagerResourceSetAdapter.findAdapter(resourceSet);
		if (adapter != null) {
			MetamodelManager metamodelManager = adapter.getMetamodelManager();
			if (metamodelManager != null) {
				metamodelManager.dispose();
			}
		}
		if (metamodelManager != null) {
			metamodelManager.dispose();
			metamodelManager = null;
		}
		StandardLibraryContribution.REGISTRY.remove(StandardLibraryImpl.DEFAULT_OCL_STDLIB_URI);
		super.tearDown();
	}
}
