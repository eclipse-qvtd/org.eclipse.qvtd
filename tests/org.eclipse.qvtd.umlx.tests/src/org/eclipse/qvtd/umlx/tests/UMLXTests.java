/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.umlx.tests;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.xtext.base.services.BaseLinkingService;
import org.eclipse.qvtd.umlx.qvtr2umlx.QVTr2UMLX;
import org.eclipse.qvtd.umlx.umlx2qvtr.UMLX2QVTr;
import org.eclipse.qvtd.umlx.utilities.UMLXStandaloneSetup;
import org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase;
import org.eclipse.qvtd.xtext.qvtbase.tests.utilities.TestsXMLUtil;
import org.eclipse.qvtd.xtext.qvtrelation.tests.QVTrTestUtil;

/**
 * Tests that load a model and verify that there are no unresolved proxies as a result.
 */
public class UMLXTests extends LoadTestCase
{
	/*	protected void doLoad_QVTr(URI inputURI, URI pivotURI) throws IOException {
		OCL ocl = OCL.newInstance(getProjectMap());
		doLoad_Concrete(ocl, inputURI, pivotURI, null);
		ocl.dispose();
	} */

	protected void doLoadTest(URI inputURI, URI pivotURI, URI umlxURI) throws Exception {
		OCL ocl = OCL.newInstance(getProjectMap());
		Resource qvtrResource = doLoad_Concrete(ocl, inputURI, pivotURI, null);
		Resource umlxResource = qvtrResource.getResourceSet().createResource(umlxURI);
		QVTr2UMLX qvtr2umlx = new QVTr2UMLX(ocl.getEnvironmentFactory(), qvtrResource, umlxResource);
		qvtr2umlx.transform();
		umlxResource.save(null);
		//
		assertNoValidationErrors(umlxURI.toString(), umlxResource);
		//
		ocl.dispose();
	}

	protected void doRoundTripTest(@NonNull URI inputURI1, @NonNull URI pivotURI1, @NonNull URI umlxURI, @NonNull URI pivotURI2) throws Exception {
		OCL ocl1 = OCL.newInstance(getProjectMap());
		Resource qvtrResource1 = doLoad_Concrete(ocl1, inputURI1, pivotURI1, null);
		Resource umlxResource1 = qvtrResource1.getResourceSet().createResource(umlxURI);
		QVTr2UMLX qvtr2umlx = new QVTr2UMLX(ocl1.getEnvironmentFactory(), qvtrResource1, umlxResource1);
		qvtr2umlx.transform();
		umlxResource1.save(null);
		//
		assertNoValidationErrors(umlxURI.toString(), umlxResource1);
		//
		OCL ocl2 = OCL.newInstance(getProjectMap());
		Resource umlxResource2 = ocl2.getResourceSet().getResource(umlxURI, true);
		Resource qvtrResource2 = ocl2.getMetamodelManager().getASResourceSet().createResource(pivotURI2);
		UMLX2QVTr umlx2qvtr = new UMLX2QVTr(ocl2.getEnvironmentFactory(), umlxResource2, qvtrResource2);
		umlx2qvtr.transform();
		qvtrResource2.save(TestsXMLUtil.defaultSavingOptions);
		//
		Model asModel1 = PivotUtil.getModel(qvtrResource1);
		Model asModel2 = PivotUtil.getModel(qvtrResource2);
		asModel2.setName(asModel1.getName());
		asModel2.setExternalURI(asModel1.getExternalURI());
		assertSameModel(qvtrResource1, qvtrResource2);
		ocl1.dispose();
		ocl2.dispose();
	}

	@Override
	protected void setUp() throws Exception {
		QVTrTestUtil.doQVTrelationSetup();
		if (!EMFPlugin.IS_ECLIPSE_RUNNING) {
			UMLXStandaloneSetup.doSetup();
		}
		super.setUp();
	}

	public void testUMLXLoad_Forward2Reverse_qvtr() throws Exception {
		URI inputURI = URI.createPlatformResourceURI("/org.eclipse.qvtd.xtext.qvtrelation.tests/src/org/eclipse/qvtd/xtext/qvtrelation/tests/forward2reverse/Forward2Reverse.qvtr", true);
		URI pivotURI = getProjectFileURI("Forward2Reverse.qvtras");
		URI umlxURI = getProjectFileURI("Forward2Reverse.umlx");
		doLoadTest(inputURI, pivotURI, umlxURI);
	}

	public void testUMLXLoad_Keys_qvtr() throws Exception {
		URI inputURI = URI.createPlatformResourceURI("/org.eclipse.qvtd.xtext.qvtrelation.tests/src/org/eclipse/qvtd/xtext/qvtrelation/tests/models/Keys.qvtr", true);
		URI pivotURI = getProjectFileURI("Keys.qvtras");
		URI umlxURI = getProjectFileURI("Keys.umlx");
		doLoadTest(inputURI, pivotURI, umlxURI);
	}

	public void testUMLXLoad_RelToCore_qvtr() throws Exception {
		URI inputURI = URI.createPlatformResourceURI("/org.eclipse.qvtd.examples.qvtrelation.reltocore/qvtrsrc/RelToCore.qvtr", true);
		URI pivotURI = getProjectFileURI("RelToCore.qvtras");
		URI umlxURI = getProjectFileURI("RelToCore.umlx");
		doLoadTest(inputURI, pivotURI, umlxURI);
	}

	public void testUMLXLoad_SeqToStm_qvtr() throws Exception {
		URI inputURI = URI.createPlatformResourceURI("/org.eclipse.qvtd.xtext.qvtrelation.tests/src/org/eclipse/qvtd/xtext/qvtrelation/tests/seq2stm/SeqToStm.qvtr", true);
		URI pivotURI = getProjectFileURI("SeqToStm.qvtras");
		URI umlxURI = getProjectFileURI("SeqToStm.umlx");
		doLoadTest(inputURI, pivotURI, umlxURI);
	}

	public void testUMLXLoad_SimplerRelToCore_qvtr() throws Exception {
		URI inputURI = URI.createPlatformResourceURI("/org.eclipse.qvtd.examples.qvtrelation.reltocore/qvtrsrc/SimplerRelToCore.qvtr", true);
		URI pivotURI = getProjectFileURI("SimplerRelToCore.qvtras");
		URI umlxURI = getProjectFileURI("SimplerRelToCore.umlx");
		doLoadTest(inputURI, pivotURI, umlxURI);
	}

	public void testUMLXRoundtrip_Forward2Reverse_qvtr() throws Exception {
		URI inputURI1 = URI.createPlatformResourceURI("/org.eclipse.qvtd.xtext.qvtrelation.tests/src/org/eclipse/qvtd/xtext/qvtrelation/tests/forward2reverse/Forward2Reverse.qvtr", true);
		URI pivotURI1 = getProjectFileURI("Forward2Reverse.qvtras");
		URI umlxURI = getProjectFileURI("Forward2Reverse.umlx");
		URI pivotURI2 = getProjectFileURI("Forward2Reverse.regenerated.qvtras");
		doRoundTripTest(inputURI1, pivotURI1, umlxURI, pivotURI2);
	}

	public void testUMLXRoundtrip_Keys_qvtr() throws Exception {
		URI inputURI1 = URI.createPlatformResourceURI("/org.eclipse.qvtd.xtext.qvtrelation.tests/src/org/eclipse/qvtd/xtext/qvtrelation/tests/models/Keys.qvtr", true);
		URI pivotURI1 = getProjectFileURI("Keys.qvtras");
		URI umlxURI = getProjectFileURI("Keys.umlx");
		URI pivotURI2 = getProjectFileURI("Keys.regenerated.qvtras");
		doRoundTripTest(inputURI1, pivotURI1, umlxURI, pivotURI2);
	}

	public void testUMLXRoundtrip_SeqToStm_qvtr() throws Exception {
		BaseLinkingService.DEBUG_RETRY.setState(true);
		URI inputURI1 = URI.createPlatformResourceURI("/org.eclipse.qvtd.xtext.qvtrelation.tests/src/org/eclipse/qvtd/xtext/qvtrelation/tests/seq2stm/SeqToStm.qvtr", true);
		URI pivotURI1 = getProjectFileURI("SeqToStm.qvtras");
		URI umlxURI = getProjectFileURI("SeqToStm.umlx");
		URI pivotURI2 = getProjectFileURI("SeqToStm.regenerated.qvtras");
		doRoundTripTest(inputURI1, pivotURI1, umlxURI, pivotURI2);
	}

	/*	public void testUMLXRoundtrip_SimplerRelToCore_qvtr() throws Exception {
		URI inputURI1 = URI.createPlatformResourceURI("/org.eclipse.qvtd.examples.qvtrelation.reltocore/qvtrsrc/SimplerRelToCore.qvtr", true);
		URI pivotURI1 = getProjectFileURI("SimplerRelToCore.qvtras");
		URI umlxURI = getProjectFileURI("SimplerRelToCore.umlx");
		URI pivotURI2 = getProjectFileURI("SimplerRelToCore.regenerated.qvtras");
		doRoundTripTest(inputURI1, pivotURI1, umlxURI, pivotURI2);
	} */
}
