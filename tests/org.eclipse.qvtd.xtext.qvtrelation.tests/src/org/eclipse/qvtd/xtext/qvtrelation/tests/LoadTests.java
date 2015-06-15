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
package org.eclipse.qvtd.xtext.qvtrelation.tests;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.xtext.base.services.BaseLinkingService;
import org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase;

/**
 * Tests that load a model and verify that there are no unresolved proxies as a result.
 */
public class LoadTests extends LoadTestCase
{		
	public void doLoad_ModelMorf(@NonNull String stem) throws IOException {
		URI inputURI = URI.createPlatformResourceURI("/org.eclipse.qvtd.examples.qvtrelation.modelmorf/qvtrsrc/" + stem + ".qvtr", true);
		URI pivotURI = getProjectFileURI(stem + ".qvtras");
		doLoad_Concrete(inputURI, pivotURI);
	}

	protected void doLoad_Concrete(URI inputURI, URI pivotURI) throws IOException {
		OCL ocl = OCL.newInstance(getProjectMap());
		doLoad_Concrete(ocl, inputURI, pivotURI);
		ocl.dispose();
	}

	@Override
	protected void setUp() throws Exception {
		BaseLinkingService.DEBUG_RETRY.setState(true);
		QVTrTestUtil.doQVTrelationSetup();
		super.setUp();
//		getProjectMap().
//		ProjectMap.getAdapter(resourceSet);
	}

	public void testLoad_AbstractToConcrete_qvtr() throws IOException, InterruptedException {
		doLoad_ModelMorf("AbstractToConcrete/AbstractToConcrete");
	}	

	// FIXME
	public void zztestLoad_ClassModelToClassModel_qvtr() throws IOException, InterruptedException {
		doLoad_ModelMorf("ClassModelToClassModel/ClassModelToClassModel");
	}	

	public void testLoad_DNF_bbox_qvtr() throws IOException, InterruptedException {
		doLoad_ModelMorf("DNF_bbox/DNF_bbox");
	}	

	public void testLoad_DNF_qvtr() throws IOException, InterruptedException {
		doLoad_ModelMorf("DNF/DNF");
	}	

	public void testLoad_HstmToStm_qvtr() throws IOException, InterruptedException {
		doLoad_ModelMorf("HstmToStm/hstmtostm");
	}	

	public void testLoad_Import_qvtr() throws IOException, InterruptedException {
		doLoad_ModelMorf("Import/UmlToRdbms_1");
	}	

	public void testLoad_Keys_qvtr() throws IOException, InterruptedException {
		doLoad_Concrete("models/Keys.qvtr");
	}	

	public void testLoad_MiToSi_qvtr() throws IOException, InterruptedException {
		doLoad_ModelMorf("MiToSi/mitosi");
	}	

	public void testLoad_RelToCore_qvtr() throws IOException, InterruptedException {
//		ProjectMap.getAdapter(resourceSet);
		URI inputURI = URI.createPlatformResourceURI("/org.eclipse.qvtd.examples.qvtrelation.reltocore/qvtrsrc/RelToCore.qvtr", true);
		URI pivotURI = getProjectFileURI("RelToCore.qvtras");
		doLoad_Concrete(inputURI, pivotURI);
	}	

	public void testLoad_SimplerRelToCore_qvtr() throws IOException, InterruptedException {
//		ProjectMap.getAdapter(resourceSet);
		URI inputURI = URI.createPlatformResourceURI("/org.eclipse.qvtd.examples.qvtrelation.reltocore/qvtrsrc/SimplerRelToCore.qvtr", true);
		URI pivotURI = getProjectFileURI("SimplerRelToCore.qvtras");
		doLoad_Concrete(inputURI, pivotURI);
	}	

	public void testLoad_SeqToStm_qvtr() throws IOException, InterruptedException {
		doLoad_ModelMorf("SeqToStm/SeqToStm");
	}	

	public void testLoad_SeqToStmc_CT_qvtr() throws IOException, InterruptedException {
		doLoad_ModelMorf("SeqToStmc_CT/SeqToStmc");
	}	

	public void testLoad_UmlToRdbms_qvtr() throws IOException, InterruptedException {
		doLoad_ModelMorf("UmlToRdbms/UmlToRdbms");
	}	

	public void testLoad_UmlToRel_qvtr() throws IOException, InterruptedException {
		doLoad_ModelMorf("UmlToRel/UmlToRel");
	}	
}
