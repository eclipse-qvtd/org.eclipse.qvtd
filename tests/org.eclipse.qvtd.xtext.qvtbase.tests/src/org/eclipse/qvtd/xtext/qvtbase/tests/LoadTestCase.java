/*******************************************************************************
 * Copyright (c) 2012, 2022 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
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
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.StandardLibraryImpl;
import org.eclipse.ocl.pivot.internal.library.StandardLibraryContribution;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.OCLInternal;
import org.eclipse.ocl.pivot.messages.StatusCodes;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.pivot.utilities.XMIUtil;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;

/**
 * Tests that load a model and verify that there are no unresolved proxies as a result.
 */
public abstract class LoadTestCase extends XtextTestCase
{
	public static final @NonNull String @NonNull [] NO_MESSAGES = new @NonNull String[] {};

	public void doLoad_Concrete(@NonNull URI inputURI, @NonNull String @Nullable [] messages) throws Exception {
		doLoad_Concrete(inputURI, messages, StatusCodes.Severity.IGNORE);
	}

	public void doLoad_Concrete(@NonNull URI inputURI, @NonNull String @Nullable [] messages, StatusCodes.@NonNull Severity severity) throws Exception {
		OCL ocl = createOCL();
		((EnvironmentFactoryInternal)ocl.getEnvironmentFactory()).setSafeNavigationValidationSeverity(severity);
		URI pivotURI = getTestURIWithExtension(inputURI, QVTimperativeUtil.QVTIAS_FILE_EXTENSION);
		doLoad_Concrete(ocl, inputURI, pivotURI, messages);
		ocl.dispose();
	}

	protected abstract @NonNull OCLInternal createOCL();

	//	public Resource doLoad_Concrete(@NonNull OCL ocl, @NonNull String inputName, @NonNull String outputName, @NonNull String @Nullable [] messages) throws IOException {
	//		URI inputURI = getProjectFileURI(inputName);
	//		URI pivotURI = getProjectFileURI(outputName);
	//		return doLoad_Concrete(ocl, inputURI, pivotURI, messages);
	//	}

	protected Resource doLoad_Concrete(@NonNull OCL ocl, @NonNull URI inputURI, @NonNull URI pivotURI, @NonNull String @Nullable [] messages) throws Exception {
		URI cstURI = getTestURIWithExtension(pivotURI, "xmi");
		BaseCSResource xtextResource = (BaseCSResource) ocl.getResourceSet().getResource(inputURI, true);
		assert xtextResource != null;
		assertNoResourceErrors("Load failed", xtextResource);
		ASResource pivotResource = xtextResource.getASResource();
		assertNoUnresolvedProxies("Unresolved proxies", xtextResource);
		//		System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " validate()");
		assertNoValidationErrors("Validation errors", xtextResource.getContents().get(0));
		//		System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " validated()");
		saveAsXMI(xtextResource, cstURI);
		assertValidationDiagnostics("Pivot validation errors", pivotResource, messages);
		pivotResource.setSaveable(true);
		pivotResource.setURI(pivotURI);
		pivotResource.save(XMIUtil.createSaveOptions(pivotResource));
		assertNoResourceErrors("Save", pivotResource);
		return pivotResource;
	}

	protected void saveAsXMI(@NonNull Resource resource, @NonNull URI xmiURI) throws IOException {
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl()); //$NON-NLS-1$
		XMLResource xmiResource = (XMLResource) resourceSet.createResource(xmiURI);
		xmiResource.getContents().addAll(resource.getContents());
		xmiResource.save(XMIUtil.createSaveOptions(xmiResource));
		assertNoResourceErrors("Save failed", xmiResource);
		resource.getContents().addAll(xmiResource.getContents());
	}

	@Override
	protected void setUp() throws Exception {
		//		PivotTestCase.TEST_START.setState(true);
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
