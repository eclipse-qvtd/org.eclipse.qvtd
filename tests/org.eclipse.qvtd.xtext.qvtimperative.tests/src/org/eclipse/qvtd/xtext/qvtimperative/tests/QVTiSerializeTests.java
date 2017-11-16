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
import org.eclipse.ocl.pivot.resource.ProjectManager;
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
	protected void doSerializeRoundTrip(@NonNull URI inputURI) throws Exception {
		doSerializeRoundTrip(inputURI, getURIWithExtension(inputURI, "ref.qvtias"));
	}
	protected void doSerializeRoundTrip(@NonNull URI inputURI, @NonNull URI referenceURI) throws Exception {
		URI pivotURI = getTestURIWithExtension(inputURI, "qvtias");
		URI serializedInputURI = getTestURIWithExtension(inputURI, "serialized.qvti");
		URI serializedPivotURI = getTestURIWithExtension(inputURI, "serialized.qvtias");
		ProjectManager projectManager = getTestProjectManager();
		OCL ocl1 = QVTimperative.newInstance(projectManager, null);
		OCL ocl2 = QVTimperative.newInstance(projectManager, null);
		Resource asResource1 = doLoad_Concrete(ocl1, inputURI, pivotURI, NO_MESSAGES);
		doSerialize(pivotURI, serializedInputURI, referenceURI, null, true, true);
		Resource asResource3 = doLoad_Concrete(ocl2, serializedInputURI, serializedPivotURI, NO_MESSAGES);
		((Model)asResource3.getContents().get(0)).setExternalURI(((Model)asResource1.getContents().get(0)).getExternalURI());
		TestsXMLUtil.resetTransients(asResource1);
		TestsXMLUtil.resetTransients(asResource3);
		assertSameModel(asResource1, asResource3);
		ocl1.dispose();
		ocl2.dispose();
	}

	protected void doSerializeRoundTripFromAS(@NonNull URI inputURI) throws Exception {
		doSerializeRoundTripFromAS(inputURI, getURIWithExtension(inputURI, "ref.qvtias"));
	}
	protected void doSerializeRoundTripFromAS(@NonNull URI pivotURI, @NonNull URI referenceURI) throws Exception {
		URI serializedInputURI = getTestURIWithExtension(pivotURI, "serialized.qvti");
		URI serializedPivotURI = getTestURIWithExtension(pivotURI, "serialized.qvtias");
		ProjectManager projectManager = getTestProjectManager();
		OCL ocl1 = OCL.newInstance(projectManager);
		OCL ocl2 = OCL.newInstance(projectManager);
		Resource asResource1 = ocl1.getMetamodelManager().getASResourceSet().getResource(pivotURI, true);
		doSerialize(pivotURI, serializedInputURI, referenceURI, null, true, true);
		Resource asResource3 = doLoad_Concrete(ocl2, serializedInputURI, serializedPivotURI, NO_MESSAGES);
		((Model)asResource3.getContents().get(0)).setExternalURI(((Model)asResource1.getContents().get(0)).getExternalURI());
		assertSameModel(asResource1, asResource3);
		ocl1.dispose();
		ocl2.dispose();
	}

	public XtextResource doSerialize(@NonNull URI inputURI, @NonNull URI serializedInputURI, @NonNull URI referenceURI, @Nullable Map<String, Object> options, boolean doCompare, boolean validateSaved) throws Exception {
		ResourceSet resourceSet = new ResourceSetImpl();
		//		getProjectMap().initializeResourceSet(resourceSet);
		//
		//	Load QVTiAS
		//
		OCL ocl = QVTbase.newInstance(getTestProjectManager());
		try {
			ASResource asResource = AbstractTestQVT.loadQVTiAS(ocl, inputURI);
			assertNoResourceErrors("Normalisation failed", asResource);
			assertNoValidationErrors("Normalisation invalid", asResource);
			//
			//	Pivot to CS
			//
			XtextResource xtextResource = AbstractTestQVT.as2cs(ocl, resourceSet, asResource, serializedInputURI, QVTimperativeCSPackage.eCONTENT_TYPE);
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

	public void testQVTiSerialize_Constructors() throws Exception {
		URI inputURI = getModelsURI("Constructors/Constructors.qvti");
		doSerializeRoundTrip(inputURI);
	}

	public void testQVTiSerialize_Dependencies() throws Exception {
		URI inputURI = getModelsURI("Dependencies/Dependencies.qvti");
		doSerializeRoundTrip(inputURI);
	}

	public void testQVTiSerialize_Expressions() throws Exception {
		URI inputURI = getModelsURI("Expressions/Expressions.qvti");
		doSerializeRoundTrip(inputURI);
	}

	public void testQVTiSerialize_Graph2GraphHierarchical() throws Exception {
		URI inputURI = getModelsURI("Graph2GraphHierarchical/Graph2GraphHierarchical.qvti");
		doSerializeRoundTrip(inputURI);
	}

	public void testQVTiSerialize_Graph2GraphMinimal() throws Exception {
		URI inputURI = getModelsURI("Graph2GraphMinimal/Graph2GraphMinimal.qvti");
		doSerializeRoundTrip(inputURI);
	}

	public void testQVTiSerialize_HSV2HSL_qvti() throws Exception {
		URI inputURI = getModelsURI("HSV2HSL/HSV2HSL.qvti");
		doSerializeRoundTrip(inputURI);
	}

	public void testQVTiSerialize_HSV2HSLas_qvtias() throws Exception {
		URI inputURI = getModelsURI("HSV2HSL/HSV2HSLas.qvtias");
		URI referenceURI = getURIWithExtension(inputURI, "ref.qvtias");
		URI serializedInputURI = getTestURIWithExtension(inputURI, "serialized.qvti");
		doSerialize(inputURI, serializedInputURI, referenceURI, null, true, true);
	}

	public void testQVTiSerialize_KiamaRewrite_qvti() throws Exception {
		URI inputURI = getModelsURI("KiamaRewrite/KiamaRewrite.qvti");
		doSerializeRoundTrip(inputURI);
	}

	public void testQVTiSerialize_ManualUML2RDBMS_qvti() throws Exception {
		URI inputURI = getModelsURI("ManualUML2RDBMS/ManualUML2RDBMS.qvti");
		doSerializeRoundTrip(inputURI);
	}

	public void testQVTiSerialize_SimpleUML2RDBMS_qvti() throws Exception {
		URI inputURI = getModelsURI("SimpleUML2RDBMS/SimpleUML2RDBMS.qvti");
		doSerializeRoundTrip(inputURI);
	}

	public void testQVTiSerialize_Tree2TallTree_qvti() throws Exception {
		URI inputURI = getModelsURI("Tree2TallTree/Tree2TallTree.qvti");
		doSerializeRoundTrip(inputURI);
	}

	public void zztestSerialize_platformResource_BaseCS2AS() throws Exception {
		URI inputURI = getModelsURI("platformResource/org.eclipse.ocl.xtext.base/model/BaseCS2AS.qvtias");
		doSerializeRoundTripFromAS(inputURI);
	}

	public void zztestSerialize_platformResource_EssentialOCLCS2AS() throws Exception {
		URI inputURI = getModelsURI("platformResource/org.eclipse.ocl.xtext.essentialocl/model/EssentialOCLCS2AS.qvtias");
		doSerializeRoundTripFromAS(inputURI);
	}
}
