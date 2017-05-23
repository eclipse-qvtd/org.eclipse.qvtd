/*******************************************************************************
 * Copyright (c) 2014, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtimperative.tests;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.xtext.tests.TestUtil;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.xtext.base.services.BaseLinkingService;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbase;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperative;
import org.eclipse.qvtd.xtext.qvtbase.tests.AbstractTestQVT;
import org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase;
import org.eclipse.qvtd.xtext.qvtbase.tests.utilities.TestsXMLUtil;
import org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage;
import org.eclipse.xtext.resource.XtextResource;

/**
 * Tests that check that an Ecore model can be serialized to OCLinEcore.
 */
public class QVTiSerializeTests extends LoadTestCase
{
	protected void doSerializeRoundTrip(@NonNull String stem) throws Exception {
		OCL ocl1 = QVTimperative.newInstance(OCL.CLASS_PATH, null);
		OCL ocl2 = QVTimperative.newInstance(OCL.CLASS_PATH, null);
		Resource asResource1 = doLoad_Concrete(ocl1, stem + ".qvti", stem + ".qvtias", NO_MESSAGES);
		URI inputURI = getProjectFileURI(stem + ".qvtias");
		URI referenceURI = getProjectFileURI(stem + "ref.qvtias");
		doSerialize(inputURI, stem, referenceURI, null, true, true);
		Resource asResource3 = doLoad_Concrete(ocl2, stem + ".serialized.qvti", stem + ".serialized.qvtias", NO_MESSAGES);
		((Model)asResource3.getContents().get(0)).setExternalURI(((Model)asResource1.getContents().get(0)).getExternalURI());
		TestsXMLUtil.resetTransients(asResource1);
		TestsXMLUtil.resetTransients(asResource3);
		assertSameModel(asResource1, asResource3);
		ocl1.dispose();
		ocl2.dispose();
	}
	protected void doSerializeRoundTripFromAS(@NonNull String stem) throws Exception {
		OCL ocl1 = OCL.newInstance(OCL.NO_PROJECTS);
		OCL ocl2 = OCL.newInstance(OCL.NO_PROJECTS);
		URI inputURI = getProjectFileURI(stem + ".qvtias");
		Resource asResource1 = ocl1.getMetamodelManager().getASResourceSet().getResource(inputURI, true);
		URI referenceURI = getProjectFileURI(stem + "ref.qvtcas");
		doSerialize(inputURI, stem, referenceURI, null, true, true);
		Resource asResource3 = doLoad_Concrete(ocl2, stem + ".serialized.qvti", stem + ".serialized.qvtias", NO_MESSAGES);
		((Model)asResource3.getContents().get(0)).setExternalURI(((Model)asResource1.getContents().get(0)).getExternalURI());
		assertSameModel(asResource1, asResource3);
		ocl1.dispose();
		ocl2.dispose();
	}

	public XtextResource doSerialize(@NonNull URI inputURI, @NonNull String stem, @NonNull URI referenceURI, @Nullable Map<String, Object> options, boolean doCompare, boolean validateSaved) throws Exception {
		ResourceSet resourceSet = new ResourceSetImpl();
		//		getProjectMap().initializeResourceSet(resourceSet);
		String outputName = stem + ".serialized.qvti";
		URI outputURI = getProjectFileURI(outputName);
		//
		//	Load QVTiAS
		//
		OCL ocl = QVTbase.newInstance(OCL.NO_PROJECTS);
		try {
			ASResource asResource = AbstractTestQVT.loadQVTiAS(ocl, inputURI);
			assertNoResourceErrors("Normalisation failed", asResource);
			assertNoValidationErrors("Normalisation invalid", asResource);
			//
			//	Pivot to CS
			//
			XtextResource xtextResource = AbstractTestQVT.as2cs(ocl, resourceSet, asResource, outputURI, QVTimperativeCSPackage.eCONTENT_TYPE);
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
		TestUtil.doCompleteOCLSetup();
		QVTiTestUtil.doQVTimperativeSetup();
		super.setUp();
	}

	public void testSerialize_Constructors() throws Exception {
		doSerializeRoundTrip("Constructors/Constructors");
	}

	public void testSerialize_Dependencies() throws Exception {
		doSerializeRoundTrip("Dependencies/Dependencies");
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

	public void testSerialize_HSV2HSL_qvti() throws Exception {
		doSerializeRoundTrip("HSV2HSL/HSV2HSL");
	}

	public void testSerialize_HSV2HSLas_qvtias() throws Exception {
		doSerialize("HSV2HSL/HSV2HSLas");
	}

	public void testSerialize_KiamaRewrite_qvti() throws Exception {
		doSerializeRoundTrip("KiamaRewrite/KiamaRewrite");
	}

	public void testSerialize_ManualUML2RDBMS_qvti() throws Exception {
		doSerializeRoundTrip("ManualUML2RDBMS/ManualUML2RDBMS");
	}

	public void testSerialize_SimpleUML2RDBMS_qvti() throws Exception {
		doSerializeRoundTrip("SimpleUML2RDBMS/SimpleUML2RDBMS");
	}

	public void testSerialize_Tree2TallTree_qvti() throws Exception {
		doSerializeRoundTrip("Tree2TallTree/Tree2TallTree");
	}

	public void zztestSerialize_platformResource_BaseCS2AS() throws Exception {
		doSerializeRoundTripFromAS("platformResource/org.eclipse.ocl.xtext.base/model/BaseCS2AS");
	}

	public void zztestSerialize_platformResource_EssentialOCLCS2AS() throws Exception {
		doSerializeRoundTripFromAS("platformResource/org.eclipse.ocl.xtext.essentialocl/model/EssentialOCLCS2AS");
	}

	protected void doSerialize(@NonNull String stem) throws Exception {
		URI inputURI = getProjectFileURI(stem + ".qvtias");
		URI referenceURI = getProjectFileURI(stem + "ref..qvtias");
		doSerialize(inputURI, stem, referenceURI, null, true, true);
	}

}
