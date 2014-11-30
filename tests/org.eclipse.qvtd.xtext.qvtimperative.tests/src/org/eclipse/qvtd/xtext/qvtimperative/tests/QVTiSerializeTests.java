/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtimperative.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.Model;
import org.eclipse.ocl.examples.pivot.OCL;
import org.eclipse.ocl.examples.pivot.PivotConstants;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.resource.ASResource;
import org.eclipse.ocl.examples.pivot.utilities.BaseResource;
import org.eclipse.ocl.examples.xtext.base.services.BaseLinkingService;
import org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase;
import org.eclipse.qvtd.xtext.qvtimperative.QVTimperativeStandaloneSetup;
import org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.QVTimperativeCSPackage;
import org.eclipse.xtext.resource.XtextResource;

/**
 * Tests that check that an Ecore model can be serialized to OCLinEcore.
 */
public class QVTiSerializeTests extends LoadTestCase
{
	protected void doSerializeRoundTrip(@NonNull String stem) throws Exception {
		OCL ocl1 = OCL.newInstance();
		OCL ocl2 = OCL.newInstance();
		Resource asResource1 = doLoad_Concrete(ocl1, stem + ".qvti", stem + ".qvtias");
		URI inputURI = getProjectFileURI(stem + ".qvtias");
		URI referenceURI = getProjectFileURI(stem + "ref.qvtias");
		doSerialize(inputURI, stem, referenceURI, null, true, true);
		Resource asResource3 = doLoad_Concrete(ocl2, stem + ".serialized.qvti", stem + ".serialized.qvtias");
		((Model)asResource3.getContents().get(0)).setExternalURI(((Model)asResource1.getContents().get(0)).getExternalURI());
		assertSameModel(asResource1, asResource3);
		ocl1.dispose();
		ocl2.dispose();
	}	

	protected ASResource loadQVTiAS(@NonNull MetaModelManager MetaModelManager, @NonNull URI inputURI) {
		Resource asResource = MetaModelManager.getExternalResourceSet().getResource(inputURI, true);
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
		XtextResource xtextResource = DomainUtil.nonNullState((XtextResource) resourceSet.createResource(outputURI, QVTimperativeCSPackage.eCONTENT_TYPE));
		ocl.as2cs(asResource, (BaseResource) xtextResource);
		assertNoResourceErrors("Conversion failed", xtextResource);
		//
		//	CS save
		//		
		URI savedURI = DomainUtil.nonNullState(asResource.getURI());
		asResource.setURI(outputURI.trimFileExtension().trimFileExtension().appendFileExtension(PivotConstants.OCL_AS_FILE_EXTENSION));
		asResource.save(null);
		asResource.setURI(savedURI);
		
		assertNoDiagnosticErrors("Concrete Syntax validation failed", xtextResource);
		try {
			HashMap<String, Object> saveOptions = new HashMap<String,Object>();
			saveOptions.put(XMLResource.OPTION_LINE_DELIMITER, "\n");		// BUG 439440 Xtext ignores this
			xtextResource.save(saveOptions);
		}
		catch (Exception e) {
			e.printStackTrace();
			URI xmiURI = outputURI.appendFileExtension(".xmi");
			Resource xmiResource = resourceSet.createResource(xmiURI);
			xmiResource.getContents().addAll(xtextResource.getContents());
			xmiResource.save(null);
			fail(e.toString());
		}
		return xtextResource;
	}

	@SuppressWarnings("null")
	public XtextResource doSerialize(@NonNull URI inputURI, @NonNull String stem, @NonNull URI referenceURI, @Nullable Map<String, Object> options, boolean doCompare, boolean validateSaved) throws Exception {
		ResourceSet resourceSet = new ResourceSetImpl();
//		getProjectMap().initializeResourceSet(resourceSet);
		String outputName = stem + ".serialized.qvti";
		URI outputURI = getProjectFileURI(outputName);
		//
		//	Load QVTiAS
		//		
		OCL ocl = OCL.newInstance();
		try {
			ASResource asResource = loadQVTiAS(ocl.getMetaModelManager(), inputURI);
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
		BaseLinkingService.DEBUG_RETRY = true;
		super.setUp();
		QVTimperativeStandaloneSetup.doSetup();
	}
	
	public void testSerialize_ClassToRDBMS() throws Exception {
		doSerializeRoundTrip("ClassToRDBMS/ClassToRDBMSSchedule");
	}
	
	public void testSerialize_Expressions() throws Exception {
		doSerializeRoundTrip("Expressions/Expressions");
	}
	
	public void testSerialize_Graph2GraphHierarchical() throws Exception {
		doSerializeRoundTrip("Graph2GraphHierarchical/Graph2GraphHierarchical");
	}
	
	public void testSerialize_Graph2GraphMinimal() throws Exception {
		doSerializeRoundTrip("Graph2GraphMinimal/Graph2GraphMinimal");
	}
	
	public void testSerialize_HSV2HLS_qvti() throws Exception {
		doSerializeRoundTrip("HSV2HLS/HSV2HLS");
	}
	
//	public void testSerialize_Uml2Rdbms_qvti() throws Exception {
//		doSerializeRoundTrip("UML2RDBMS/UmlToRdbms");
//	}
}
