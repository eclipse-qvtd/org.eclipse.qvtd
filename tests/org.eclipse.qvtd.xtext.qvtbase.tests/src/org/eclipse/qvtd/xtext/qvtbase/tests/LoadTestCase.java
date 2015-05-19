/*******************************************************************************
 * Copyright (c) 2012, 2015 Willink Transformations and others.
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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.internal.StandardLibraryImpl;
import org.eclipse.ocl.pivot.internal.library.StandardLibraryContribution;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbase;
import org.eclipse.qvtd.xtext.qvtbase.tests.utilities.TestsXMLUtil;

/**
 * Tests that load a model and verify that there are no unresolved proxies as a result.
 */
public class LoadTestCase extends XtextTestCase
{	
	public void doLoad_Concrete(@NonNull String inputName) throws IOException {
		OCL ocl = QVTbase.newInstance(getProjectMap(), null);
//		OCL ocl = OCL.newInstance(getProjectMap());
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
		BaseCSResource xtextResource = (BaseCSResource) ocl.getResourceSet().getResource(inputURI, true);
		assertNoResourceErrors("Load failed", xtextResource);
		Resource pivotResource = xtextResource.getASResource();
		assertNoUnresolvedProxies("Unresolved proxies", xtextResource);
//		System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " validate()");
		assertNoValidationErrors("Validation errors", xtextResource.getContents().get(0));
//		System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " validated()");
		saveAsXMI(xtextResource, cstURI);
		pivotResource.setURI(pivotURI);
		assertNoValidationErrors("Pivot validation errors", pivotResource.getContents().get(0));
	    pivotResource.save(TestsXMLUtil.defaultSavingOptions);
		return pivotResource;
	}

	protected void saveAsXMI(Resource resource, URI xmiURI) throws IOException {
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl()); //$NON-NLS-1$
		Resource xmiResource = resourceSet.createResource(xmiURI);
		xmiResource.getContents().addAll(resource.getContents());
		xmiResource.save(TestsXMLUtil.defaultSavingOptions);
		assertNoResourceErrors("Save failed", xmiResource);
		resource.getContents().addAll(xmiResource.getContents());
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		configurePlatformResources();
		EcorePackage.eINSTANCE.getClass();						// Workaround Bug 425841
//		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("emof", new EMOFResourceFactoryImpl()); //$NON-NLS-1$
//		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("pivot", new XMIResourceFactoryImpl()); //$NON-NLS-1$
	}

	@Override
	protected void tearDown() throws Exception {
		StandardLibraryContribution.REGISTRY.remove(StandardLibraryImpl.DEFAULT_OCL_STDLIB_URI);
		super.tearDown();
	}
}
