/*******************************************************************************
 * Copyright (c) 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtrelation.tests;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.xtext.base.services.BaseLinkingService;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelation;
import org.eclipse.qvtd.xtext.qvtbase.tests.AbstractTestQVT;
import org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase;
import org.eclipse.qvtd.xtext.qvtbase.tests.utilities.TestsXMLUtil;
import org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage;
import org.eclipse.xtext.resource.XtextResource;

/**
 * Tests that check that an Ecore model can be serialized to OCLinEcore.
 */
public class QVTrSerializeTests extends LoadTestCase
{
	protected void doSerializeRoundTripFromAS(@NonNull String stem) throws Exception {
		QVTrelation ocl1 = QVTrelation.newInstance(QVTrelation.NO_PROJECTS);
		QVTrelation ocl2 = QVTrelation.newInstance(QVTrelation.NO_PROJECTS);
		URI inputURI = getProjectFileURI(stem + ".qvtras");
		Resource asResource1 = ocl1.getMetamodelManager().getASResourceSet().getResource(inputURI, true);
		URI referenceURI = getProjectFileURI(stem + "ref.qvtras");
		doSerialize(inputURI, stem, referenceURI, null, true, true, null);
		Resource asResource3 = doLoad_Concrete(ocl2, stem + ".serialized.qvtr", stem + ".serialized.qvtras", NO_MESSAGES);
		((Model)asResource3.getContents().get(0)).setExternalURI(((Model)asResource1.getContents().get(0)).getExternalURI());
		assertSameModel(asResource1, asResource3);
		ocl1.dispose();
		ocl2.dispose();
	}

	protected void doSerializeRoundTripFromCS(@NonNull String stem, @NonNull String @Nullable [] messages) throws Exception {
		QVTrelation ocl1 = QVTrelation.newInstance(getProjectMap(), null);
		QVTrelation ocl2 = QVTrelation.newInstance(getProjectMap(), null);
		Resource asResource1 = doLoad_Concrete(ocl1, stem + ".qvtr", stem + ".qvtras", null);
		URI inputURI = getProjectFileURI(stem + ".qvtras");
		URI referenceURI = getProjectFileURI(stem + "ref.qvtras");
		doSerialize(inputURI, stem, referenceURI, null, true, true, messages);
		Resource asResource3 = doLoad_Concrete(ocl2, stem + ".serialized.qvtr", stem + ".serialized.qvtras", null);
		((Model)asResource3.getContents().get(0)).setExternalURI(((Model)asResource1.getContents().get(0)).getExternalURI());
		TestsXMLUtil.resetTransients(asResource1);
		TestsXMLUtil.resetTransients(asResource3);
		assertSameModel(asResource1, asResource3);
		ocl1.dispose();
		ocl2.dispose();
	}

	// FIXME workaround for Bug 510503
	protected void doSerializeRoundTripFromCS_usingOCL1(@NonNull String stem, @NonNull String @Nullable [] messages) throws Exception {
		OCL ocl1 = OCL.newInstance(getProjectMap());//, null);
		QVTrelation ocl2 = QVTrelation.newInstance(getProjectMap());
		Resource asResource1 = doLoad_Concrete(ocl1, stem + ".qvtr", stem + ".qvtras", null);
		URI inputURI = getProjectFileURI(stem + ".qvtras");
		URI referenceURI = getProjectFileURI(stem + "ref.qvtras");
		doSerialize(inputURI, stem, referenceURI, null, true, true, messages);
		Resource asResource3 = doLoad_Concrete(ocl2, stem + ".serialized.qvtr", stem + ".serialized.qvtras", null);
		((Model)asResource3.getContents().get(0)).setExternalURI(((Model)asResource1.getContents().get(0)).getExternalURI());
		TestsXMLUtil.resetTransients(asResource1);
		TestsXMLUtil.resetTransients(asResource3);
		assertSameModel(asResource1, asResource3);
		ocl1.dispose();
		ocl2.dispose();
	}

	// FIXME workaround for Bug 510503
	protected void doSerializeRoundTripFromCS_usingOCL2(@NonNull String stem, @NonNull String @Nullable [] messages) throws Exception {
		OCL ocl1 = OCL.newInstance(getProjectMap());//, null);
		OCL ocl2 = OCL.newInstance(getProjectMap());
		Resource asResource1 = doLoad_Concrete(ocl1, stem + ".qvtr", stem + ".qvtras", NO_MESSAGES);
		URI inputURI = getProjectFileURI(stem + ".qvtras");
		URI referenceURI = getProjectFileURI(stem + "ref.qvtras");
		doSerialize(inputURI, stem, referenceURI, null, true, true, messages);
		Resource asResource3 = doLoad_Concrete(ocl2, stem + ".serialized.qvtr", stem + ".serialized.qvtras", NO_MESSAGES);
		((Model)asResource3.getContents().get(0)).setExternalURI(((Model)asResource1.getContents().get(0)).getExternalURI());
		TestsXMLUtil.resetTransients(asResource1);
		TestsXMLUtil.resetTransients(asResource3);
		assertSameModel(asResource1, asResource3);
		ocl1.dispose();
		ocl2.dispose();
	}

	public XtextResource doSerialize(@NonNull URI inputURI, @NonNull String stem, @NonNull URI referenceURI, @Nullable Map<String, Object> options, boolean doCompare, boolean validateSaved, @NonNull String @Nullable [] messages) throws Exception {
		ResourceSet resourceSet = new ResourceSetImpl();
		//		getProjectMap().initializeResourceSet(resourceSet);
		String outputName = stem + ".serialized.qvtr";
		URI outputURI = getProjectFileURI(outputName);
		//
		//	Load QVTiAS
		//
		QVTrelation ocl = QVTrelation.newInstance(QVTrelation.NO_PROJECTS);
		try {
			ASResource asResource = AbstractTestQVT.loadQVTiAS(ocl, inputURI);
			assertNoResourceErrors("Normalisation failed", asResource);
			//			assertNoValidationErrors("Normalisation invalid", asResource);
			assertValidationDiagnostics("Pivot validation errors", asResource, messages);
			//
			//	Pivot to CS
			//
			XtextResource xtextResource = AbstractTestQVT.as2cs(ocl, resourceSet, asResource, outputURI, QVTrelationCSPackage.eCONTENT_TYPE);
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
		QVTrTestUtil.doQVTrelationSetup();
		super.setUp();
	}

	public void testSerialize_ClassModelToClassModel() throws Exception {
		doSerializeRoundTripFromCS("classmodel2classmodel/ClassModelToClassModel", null);
	}

	public void testSerialize_HierarchicalStateMachine2FlatStateMachine() throws Exception {
		doSerializeRoundTripFromCS("hstm2fstm/HierarchicalStateMachine2FlatStateMachine", null);
	}

	public void testSerialize_Keys() throws Exception {
		doSerializeRoundTripFromCS("models/Keys", new @NonNull String[] {
			"The 'Key::IdentifiesIsUnique' constraint is violated for 'key QVTRelation::Key {QVTRelation::Key::identifies}'",
			"The 'Key::IdentifiesIsUnique' constraint is violated for 'key QVTRelation::Key {QVTRelation::Key::identifies, QVTRelation::Key::part}'",
			"The 'Key::NoSuperKeys' constraint is violated for 'key EMOF::Class {EMOF::NamedElement::name}'",
			"The 'Key::IdentifiesIsNotAbstract' constraint is violated for 'key EMOF::NamedElement {EMOF::NamedElement::name}'"
		});
	}

	public void testSerialize_MiToSiSimple() throws Exception {
		doSerializeRoundTripFromCS("mitosi/MiToSiSimple", null);
	}

	public void testSerialize_PetriNet2StateChart() throws Exception {
		doSerializeRoundTripFromCS("pn2sc/PetriNet2StateChart", null);
	}

	public void testSerialize_RelToCore() throws Exception {
		doSerializeRoundTripFromCS_usingOCL2("rel2core/RelToCore", null);
	}

	public void testSerialize_SimplerRelToCore() throws Exception {
		doSerializeRoundTripFromCS_usingOCL1("rel2core/SimplerRelToCore", null);
	}

	public void testSerialize_SeqToStm() throws Exception {
		doSerializeRoundTripFromCS("seq2stm/SeqToStm", null);
	}
}
