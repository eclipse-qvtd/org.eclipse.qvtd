/*******************************************************************************
 * Copyright (c) 2014, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtcore.tests;

import java.io.IOException;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.resource.CSResource;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.pivot.utilities.PivotConstants;
import org.eclipse.ocl.xtext.base.services.BaseLinkingService;
import org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase;
import org.eclipse.qvtd.xtext.qvtbase.tests.utilities.TestsXMLUtil;
import org.eclipse.qvtd.xtext.qvtcorecs.QVTcoreCSPackage;
import org.eclipse.xtext.resource.XtextResource;

/**
 * Tests that check that an Ecore model can be serialized to OCLinEcore.
 */
public class QVTcSerializeTests extends LoadTestCase
{
	protected void doSerializeRoundTripFromAS(@NonNull String stem) throws Exception {
		OCL ocl1 = OCL.newInstance(OCL.NO_PROJECTS);
		OCL ocl2 = OCL.newInstance(OCL.NO_PROJECTS);
		URI inputURI = getProjectFileURI(stem + ".qvtcas");
		Resource asResource1 = ocl1.getMetamodelManager().getASResourceSet().getResource(inputURI, true);
		URI referenceURI = getProjectFileURI(stem + "ref.qvtcas");
		doSerialize(inputURI, stem, referenceURI, null, true, true);
		Resource asResource3 = doLoad_Concrete(ocl2, stem + ".serialized.qvtc", stem + ".serialized.qvtcas");
		((Model)asResource3.getContents().get(0)).setExternalURI(((Model)asResource1.getContents().get(0)).getExternalURI());
		assertSameModel(asResource1, asResource3);
		ocl1.dispose();
		ocl2.dispose();
	}	

	protected void doSerializeRoundTripFromCS(@NonNull String stem) throws Exception {
		OCL ocl1 = OCL.newInstance(OCL.NO_PROJECTS);
		OCL ocl2 = OCL.newInstance(OCL.NO_PROJECTS);
		Resource asResource1 = doLoad_Concrete(ocl1, stem + ".qvtc", stem + ".qvtcas");
		URI inputURI = getProjectFileURI(stem + ".qvtcas");
		URI referenceURI = getProjectFileURI(stem + "ref.qvtcas");
		doSerialize(inputURI, stem, referenceURI, null, true, true);
		Resource asResource3 = doLoad_Concrete(ocl2, stem + ".serialized.qvtc", stem + ".serialized.qvtcas");
		((Model)asResource3.getContents().get(0)).setExternalURI(((Model)asResource1.getContents().get(0)).getExternalURI());
		assertSameModel(asResource1, asResource3);
		ocl1.dispose();
		ocl2.dispose();
	}	

	protected ASResource loadQVTiAS(@NonNull OCL ocl, @NonNull URI inputURI) {
		Resource asResource = ocl.getMetamodelManager().getASResourceSet().getResource(inputURI, true);
//		List<String> conversionErrors = new ArrayList<String>();
//		RootPackageCS documentCS = Ecore2OCLinEcore.importFromEcore(resourceSet, null, ecoreResource);
//		Resource eResource = documentCS.eResource();
		assertNoResourceErrors("Load failed", asResource);
//		Resource xtextResource = resourceSet.createResource(outputURI, OCLinEcoreCSTPackage.eCONTENT_TYPE);
//		XtextResource xtextResource = (XtextResource) resourceSet.createResource(outputURI);
//		xtextResource.getContents().add(documentCS);
		return (ASResource) asResource;
	}

	public static @NonNull XtextResource pivot2cs(@NonNull OCL ocl, @NonNull ResourceSet resourceSet, @NonNull ASResource asResource, @NonNull URI outputURI) throws IOException {
		XtextResource xtextResource = ClassUtil.nonNullState((XtextResource) resourceSet.createResource(outputURI, QVTcoreCSPackage.eCONTENT_TYPE));
		ocl.as2cs(asResource, (CSResource) xtextResource);
		assertNoResourceErrors("Conversion failed", xtextResource);
		//
		//	CS save
		//		
		URI savedURI = ClassUtil.nonNullState(asResource.getURI());
		asResource.setURI(outputURI.trimFileExtension().trimFileExtension().appendFileExtension(PivotConstants.OCL_AS_FILE_EXTENSION));
		asResource.save(TestsXMLUtil.defaultSavingOptions);
		asResource.setURI(savedURI);
		
		assertNoDiagnosticErrors("Concrete Syntax validation failed", xtextResource);
		try {
			xtextResource.save(TestsXMLUtil.defaultSavingOptions);
		}
		catch (Exception e) {
			e.printStackTrace();
			URI xmiURI = outputURI.appendFileExtension(".xmi");
			Resource xmiResource = resourceSet.createResource(xmiURI);
			xmiResource.getContents().addAll(xtextResource.getContents());
			xmiResource.save(TestsXMLUtil.defaultSavingOptions);
			fail(e.toString());
		}
		return xtextResource;
	}

	public XtextResource doSerialize(@NonNull URI inputURI, @NonNull String stem, @NonNull URI referenceURI, @Nullable Map<String, Object> options, boolean doCompare, boolean validateSaved) throws Exception {
		ResourceSet resourceSet = new ResourceSetImpl();
//		getProjectMap().initializeResourceSet(resourceSet);
		String outputName = stem + ".serialized.qvtc";
		URI outputURI = getProjectFileURI(outputName);
		//
		//	Load QVTiAS
		//		
		OCL ocl = OCL.newInstance(OCL.NO_PROJECTS);
		try {
			ASResource asResource = loadQVTiAS(ocl, inputURI);
			assertNoResourceErrors("Normalisation failed", asResource);
			assertNoValidationErrors("Normalisation invalid", asResource);
			//
			//	Pivot to CS
			//		
			XtextResource xtextResource = pivot2cs(ocl, resourceSet, asResource, outputURI);
			resourceSet.getResources().clear();
			return xtextResource;
		}
		finally {
			ocl.dispose();
			ocl = null;
		}
	}
	
	@Override
	public void setUp() throws Exception {
		BaseLinkingService.DEBUG_RETRY.setState(true);
		QVTcTestUtil.doQVTcoreSetup();
		super.setUp();
	}
	
	public void testSerialize_Class2RDBMS() throws Exception {
		doSerializeRoundTripFromCS("Class2RDBMS/Class2RDBMS");
	}
	
	/* FIXME get better source
	public void testSerialize_Seq2Stm() throws Exception {
		doSerializeRoundTripFromAS("Seq2Stm/SeqToStm");
	} */
}
