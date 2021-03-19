/*******************************************************************************
 * Copyright (c) 2017, 2021 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtrelation.tests;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.internal.utilities.OCLInternal;
import org.eclipse.ocl.pivot.messages.StatusCodes;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.utilities.OCLThread.EnvironmentThreadFactory;
import org.eclipse.ocl.pivot.utilities.OCLThread.Resumable;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelation;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationEnvironmentThreadFactory;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;
import org.eclipse.qvtd.xtext.qvtbase.tests.AbstractTestQVT;
import org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase;
import org.eclipse.qvtd.xtext.qvtbase.tests.utilities.TestsXMLUtil;
import org.eclipse.qvtd.xtext.qvtbase.tests.utilities.XtextCompilerUtil;
import org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage;
import org.eclipse.xtext.resource.XtextResource;

/**
 * Tests that check that an Ecore model can be serialized to OCLinEcore.
 */
public class QVTrSerializeTests extends LoadTestCase
{
	@Override
	protected @NonNull OCLInternal createOCL() {
		return QVTrelation.newInstance(getTestProjectManager(), null);
	}

	public @NonNull Resumable<@NonNull Resource>  doLoad_Concrete(@NonNull URI inputURI, @NonNull URI pivotURI, @NonNull String @Nullable [] messages, StatusCodes.@Nullable Severity severity) throws Exception {
		EnvironmentThreadFactory environmentThreadFactory = new QVTrelationEnvironmentThreadFactory(getTestProjectManager(), severity);
		return doLoad_Concrete(environmentThreadFactory, inputURI, pivotURI, messages, severity);
	}

	protected void doSerializeRoundTripFromAS(@NonNull URI inputURI) throws Exception {
		URI referenceURI = getTestURIWithExtension(inputURI, "ref.qvtras");
		URI serializedInputURI = getTestURIWithExtension(inputURI, "serialized.qvtr");
		URI serializedPivotURI = getTestURIWithExtension(inputURI, "serialized.qvtras");
		QVTrelation ocl1 = QVTrelation.newInstance(QVTrelation.NO_PROJECTS);
		//	QVTrelation ocl2 = QVTrelation.newInstance(QVTrelation.NO_PROJECTS);
		Resource asResource1 = ocl1.getMetamodelManager().getASResourceSet().getResource(inputURI, true);
		doSerialize(inputURI, serializedInputURI, referenceURI, null, true, true, null);
		Resumable<@NonNull Resource> testThread3 = doLoad_Concrete(serializedInputURI, serializedPivotURI, NO_MESSAGES, null);
		Resource asResource3 = testThread3.getResult();
		((Model)asResource3.getContents().get(0)).setExternalURI(((Model)asResource1.getContents().get(0)).getExternalURI());
		assertSameModel(asResource1, asResource3);
		testThread3.syncResume();
		//	ocl1.dispose();
		//	ocl2.dispose();
	}

	protected void doSerializeRoundTripFromCS(@NonNull URI inputURI, @NonNull String @Nullable [] messages) throws Exception {
		URI pivotURI = getTestURIWithExtension(inputURI, QVTrelationUtil.QVTRAS_FILE_EXTENSION);
		URI referenceURI = getTestURIWithExtension(inputURI, "ref.qvtras");
		URI serializedInputURI = getTestURIWithExtension(inputURI, "serialized.qvtr");
		URI serializedPivotURI = getTestURIWithExtension(inputURI, "serialized.qvtras");
		//	ProjectManager projectManager = getTestProjectManager();
		//	QVTrelation ocl1 = QVTrelation.newInstance(projectManager, null);
		Resumable<@NonNull Resource> testThread1 = doLoad_Concrete(inputURI, pivotURI, null, null);
		Resource asResource1 = testThread1.getResult();
		//	ocl1.deactivate();
		doSerialize(pivotURI, serializedInputURI, referenceURI, null, true, true, messages);
		//	QVTrelation ocl2 = QVTrelation.newInstance(projectManager, null);
		Resumable<@NonNull Resource> testThread3 = doLoad_Concrete(serializedInputURI, serializedPivotURI, null, null);
		Resource asResource3 = testThread3.getResult();
		((Model)asResource3.getContents().get(0)).setExternalURI(((Model)asResource1.getContents().get(0)).getExternalURI());
		TestsXMLUtil.resetTransients(asResource1);
		TestsXMLUtil.resetTransients(asResource3);
		assertSameModel(asResource1, asResource3);
		testThread1.syncResume();
		testThread3.syncResume();
	}

	// FIXME workaround for Bug 510503
	protected void doSerializeRoundTripFromCS_usingOCL1(@NonNull URI inputURI, @NonNull String @Nullable [] messages) throws Exception {
		URI pivotURI = getTestURIWithExtension(inputURI, QVTrelationUtil.QVTRAS_FILE_EXTENSION);
		URI referenceURI = getTestURIWithExtension(inputURI, "ref.qvtras");
		URI serializedInputURI = getTestURIWithExtension(inputURI, "serialized.qvtr");
		URI serializedPivotURI = getTestURIWithExtension(inputURI, "serialized.qvtras");
		//	ProjectManager projectManager = getTestProjectManager();
		//	OCL ocl1 = OCL.newInstance(projectManager);//, null);
		Resumable<@NonNull Resource> testThread1 = doLoad_Concrete(inputURI, pivotURI, null, null);
		Resource asResource1 = testThread1.getResult();
		//	ocl1.deactivate();
		doSerialize(pivotURI, serializedInputURI, referenceURI, null, true, true, messages);
		//	QVTrelation ocl2 = QVTrelation.newInstance(projectManager);
		Resumable<@NonNull Resource> testThread3 = doLoad_Concrete(serializedInputURI, serializedPivotURI, null, null);
		Resource asResource3 = testThread3.getResult();
		((Model)asResource3.getContents().get(0)).setExternalURI(((Model)asResource1.getContents().get(0)).getExternalURI());
		TestsXMLUtil.resetTransients(asResource1);
		TestsXMLUtil.resetTransients(asResource3);
		assertSameModel(asResource1, asResource3);
		//	ocl1.dispose();
		//	ocl2.dispose();
	}

	// FIXME workaround for Bug 510503
	protected void doSerializeRoundTripFromCS_usingOCL2(@NonNull URI inputURI, @NonNull String @Nullable [] messages) throws Exception {
		URI pivotURI = getTestURIWithExtension(inputURI, QVTrelationUtil.QVTRAS_FILE_EXTENSION);
		URI referenceURI = getTestURIWithExtension(inputURI, "ref.qvtras");
		URI serializedInputURI = getTestURIWithExtension(inputURI, "serialized.qvtr");
		URI serializedPivotURI = getTestURIWithExtension(inputURI, "serialized.qvtras");
		//	ProjectManager projectManager = getTestProjectManager();
		//	OCL ocl1 = OCL.newInstance(projectManager);//, null);
		Resumable<@NonNull Resource> testThread1 = doLoad_Concrete(inputURI, pivotURI, NO_MESSAGES, null);
		Resource asResource1 = testThread1.getResult();
		//	ocl1.deactivate();
		doSerialize(pivotURI, serializedInputURI, referenceURI, null, true, true, messages);
		//	OCL ocl2 = OCL.newInstance(projectManager);
		Resumable<@NonNull Resource> testThread3 = doLoad_Concrete(serializedInputURI, serializedPivotURI, NO_MESSAGES, null);
		Resource asResource3 = testThread3.getResult();
		((Model)asResource3.getContents().get(0)).setExternalURI(((Model)asResource1.getContents().get(0)).getExternalURI());
		TestsXMLUtil.resetTransients(asResource1);
		TestsXMLUtil.resetTransients(asResource3);
		assertSameModel(asResource1, asResource3);
		//	ocl1.dispose();
		//	ocl2.dispose();
	}

	public XtextResource doSerialize(@NonNull URI inputURI, @NonNull URI serializedInputURI, @NonNull URI referenceURI, @Nullable Map<String, Object> options, boolean doCompare, boolean validateSaved, @NonNull String @Nullable [] messages) throws Exception {
		//		getProjectMap().initializeResourceSet(resourceSet);
		//
		//	Load QVTiAS
		//
		QVTrelation ocl = QVTrelation.newInstance(getTestProjectManager());
		QVTrEnvironmentFactory environmentFactory = ocl.getEnvironmentFactory();
		try {
			ASResource asResource = AbstractTestQVT.loadQVTiAS(environmentFactory, inputURI);
			assertNoResourceErrors("Normalisation failed", asResource);
			//			assertNoValidationErrors("Normalisation invalid", asResource);
			assertValidationDiagnostics("Pivot validation errors", asResource, messages);
			//
			//	Pivot to CS
			//
			ResourceSet resourceSet = ocl.getResourceSet();
			XtextResource xtextResource = AbstractTestQVT.as2cs(environmentFactory, resourceSet, asResource, serializedInputURI, QVTrelationCSPackage.eCONTENT_TYPE);
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
		//		BaseLinkingService.DEBUG_RETRY.setState(true);
		XtextCompilerUtil.doQVTrelationSetup();
		super.setUp();
	}

	/**
	 * FIXME Bug 510503, Bug 548543 the reserialized *.qvtr uses the 'wrong' Boolean.
	 *
	public void testQVTrSerialize_ATL2QVTr() throws Exception {
		doSerializeRoundTripFromCS(getModelsURI("newATL2QVTr/NewATL2QVTr.qvtr"), null);
	} */

	public void testQVTrSerialize_ClassModelToClassModel() throws Exception {
		doSerializeRoundTripFromCS(getModelsURI("classmodel2classmodel/ClassModelToClassModel.qvtr"), null);
	}

	public void testQVTrSerialize_HierarchicalStateMachine2FlatStateMachine() throws Exception {
		doSerializeRoundTripFromCS(getModelsURI("hstm2fstm/HierarchicalStateMachine2FlatStateMachine.qvtr"), null);
	}

	public void testQVTrSerialize_Iterated2Iterated() throws Exception {
		doSerializeRoundTripFromCS(getModelsURI("iterated2iterated/Iterated2Iterated.qvtr"), null);
	}

	public void testQVTrSerialize_Keys() throws Exception {
		doSerializeRoundTripFromCS(getModelsURI("misc/Keys.qvtr"), new @NonNull String[] {
			"The 'Key::IdentifiesIsUnique' constraint is violated for 'key QVTRelation::Key {QVTRelation::Key::identifies}'",
			"The 'Key::IdentifiesIsUnique' constraint is violated for 'key QVTRelation::Key {QVTRelation::Key::identifies, QVTRelation::Key::part}'",
			"The 'Key::NoSuperKeys' constraint is violated for 'key EMOF::Class {EMOF::NamedElement::name}'",
			"The 'Key::IdentifiesIsNotAbstract' constraint is violated for 'key EMOF::NamedElement {EMOF::NamedElement::name}'"
		});
	}

	public void testQVTrSerialize_MiToSiSimple() throws Exception {
		doSerializeRoundTripFromCS(getModelsURI("mitosi/MiToSiSimple.qvtr"), null);
	}

	public void testQVTrSerialize_Packages() throws Exception {
		doSerializeRoundTripFromCS(getModelsURI("misc/Packages.qvtr"), null);
	}

	public void testQVTrSerialize_Persons2Names2Families_qvtr() throws Exception {
		doSerializeRoundTripFromCS(getModelsURI("persons2families/Persons2Names2Families.qvtr"), null);
	}

	public void testQVTrSerialize_PetriNet2StateChart() throws Exception {
		doSerializeRoundTripFromCS(getModelsURI("pn2sc/PetriNet2StateChart.qvtr"), null);
	}

	public void testQVTrSerialize_RelToCore() throws Exception {
		doSerializeRoundTripFromCS_usingOCL2(getModelsURI("rel2core/RelToCore.qvtr"), null);
	}

	public void testQVTrSerialize_SimplerRelToCore() throws Exception {
		doSerializeRoundTripFromCS_usingOCL1(getModelsURI("rel2core/SimplerRelToCore.qvtr"), null);
	}

	public void testQVTrSerialize_SeqToStm() throws Exception {
		doSerializeRoundTripFromCS(getModelsURI("seq2stm/SeqToStm.qvtr"), null);
	}
}
