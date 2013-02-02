/**
 * <copyright>
 *
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.xtext.qvtrelation.tests;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.ocl.examples.domain.utilities.ProjectMap;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLLinkingService;
import org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase;
import org.eclipse.qvtd.xtext.qvtrelation.QVTrelationStandaloneSetup;

/**
 * Tests that load a model and verify that there are no unresolved proxies as a result.
 */
public class LoadTests extends LoadTestCase
{	
	@Override
	protected void setUp() throws Exception {
		EssentialOCLLinkingService.DEBUG_RETRY = true;
		super.setUp();
		QVTrelationStandaloneSetup.doSetup();
	}

	public void testLoad_AbstractToConcrete_qvtr() throws IOException, InterruptedException {
		ProjectMap.getAdapter(resourceSet);
		doLoad_Concrete(URI.createPlatformResourceURI("/org.eclipse.qvtd.examples.qvtrelation.modelmorf/qvtrsrc/AbstractToConcrete/AbstractToConcrete.qvtr", true));
	}	

	// FIXME
	public void zztestLoad_ClassModelToClassModel_qvtr() throws IOException, InterruptedException {
		ProjectMap.getAdapter(resourceSet);
		doLoad_Concrete(URI.createPlatformResourceURI("/org.eclipse.qvtd.examples.qvtrelation.modelmorf/qvtrsrc/ClassModelToClassModel/ClassModelToClassModel.qvtr", true));
	}	

	// FIXME
	public void zztestLoad_DNF_bbox_qvtr() throws IOException, InterruptedException {
		ProjectMap.getAdapter(resourceSet);
		doLoad_Concrete(URI.createPlatformResourceURI("/org.eclipse.qvtd.examples.qvtrelation.modelmorf/qvtrsrc/DNF_bbox/DNF_bbox.qvtr", true));
	}	

	// FIXME
	public void zztestLoad_DNF_qvtr() throws IOException, InterruptedException {
		ProjectMap.getAdapter(resourceSet);
		doLoad_Concrete(URI.createPlatformResourceURI("/org.eclipse.qvtd.examples.qvtrelation.modelmorf/qvtrsrc/DNF/DNF.qvtr", true));
	}	

	public void testLoad_HstmToStm_qvtr() throws IOException, InterruptedException {
		ProjectMap.getAdapter(resourceSet);
		doLoad_Concrete(URI.createPlatformResourceURI("/org.eclipse.qvtd.examples.qvtrelation.modelmorf/qvtrsrc/HstmToStm/hstmtostm.qvtr", true));
	}	

	// FIXME
	public void zztestLoad_Import_qvtr() throws IOException, InterruptedException {
		ProjectMap.getAdapter(resourceSet);
		doLoad_Concrete(URI.createPlatformResourceURI("/org.eclipse.qvtd.examples.qvtrelation.modelmorf/qvtrsrc/Import/UmlToRdbms_1.qvtr", true));
	}	

	public void testLoad_Keys_qvtr() throws IOException, InterruptedException {
		doLoad_Concrete("Keys", "qvtr");
	}	

	public void testLoad_MiToSi_qvtr() throws IOException, InterruptedException {
		ProjectMap.getAdapter(resourceSet);
		doLoad_Concrete(URI.createPlatformResourceURI("/org.eclipse.qvtd.examples.qvtrelation.modelmorf/qvtrsrc/MiToSi/mitosi.qvtr", true));
	}	

	public void testLoad_RelToCore_qvtr() throws IOException, InterruptedException {
		ProjectMap.getAdapter(resourceSet);
		doLoad_Concrete(URI.createPlatformResourceURI("/org.eclipse.qvtd.examples.qvtrelation.reltocore/qvtrsrc/RelToCore.qvtr", true));
	}	

	public void testLoad_SeqToStm_qvtr() throws IOException, InterruptedException {
		ProjectMap.getAdapter(resourceSet);
		doLoad_Concrete(URI.createPlatformResourceURI("/org.eclipse.qvtd.examples.qvtrelation.modelmorf/qvtrsrc/SeqToStm/SeqToStm.qvtr", true));
	}	

	public void testLoad_SeqToStmc_CT_qvtr() throws IOException, InterruptedException {
		ProjectMap.getAdapter(resourceSet);
		doLoad_Concrete(URI.createPlatformResourceURI("/org.eclipse.qvtd.examples.qvtrelation.modelmorf/qvtrsrc/SeqToStmc_CT/SeqToStmc.qvtr", true));
	}	

	public void testLoad_UmlToRdbms_qvtr() throws IOException, InterruptedException {
		ProjectMap.getAdapter(resourceSet);
		doLoad_Concrete(URI.createPlatformResourceURI("/org.eclipse.qvtd.examples.qvtrelation.modelmorf/qvtrsrc/UmlToRdbms/UmlToRdbms.qvtr", true));
	}	

	public void testLoad_UmlToRel_qvtr() throws IOException, InterruptedException {
		ProjectMap.getAdapter(resourceSet);
		doLoad_Concrete(URI.createPlatformResourceURI("/org.eclipse.qvtd.examples.qvtrelation.modelmorf/qvtrsrc/UmlToRel/UmlToRel.qvtr", true));
	}	
}
