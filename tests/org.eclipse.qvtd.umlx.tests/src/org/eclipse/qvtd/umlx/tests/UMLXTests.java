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

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.umlx.qvtr2umlx.QVTr2UMLX;
import org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase;
import org.eclipse.qvtd.xtext.qvtrelation.tests.QVTrTestUtil;

/**
 * Tests that load a model and verify that there are no unresolved proxies as a result.
 */
public class UMLXTests extends LoadTestCase
{
	protected void doLoad_Concrete(URI inputURI, URI pivotURI) throws IOException {
		OCL ocl = OCL.newInstance(getProjectMap());
		doLoad_Concrete(ocl, inputURI, pivotURI, null);
		ocl.dispose();
	}

	@Override
	protected void setUp() throws Exception {
		QVTrTestUtil.doQVTrelationSetup();
		super.setUp();
	}

	public void testUMLXLoad_Forward2Reverse_qvtr() throws IOException, InterruptedException, CompilerChainException {
		URI inputURI = URI.createPlatformResourceURI("/org.eclipse.qvtd.xtext.qvtrelation.tests/src/org/eclipse/qvtd/xtext/qvtrelation/tests/forward2reverse/Forward2Reverse.qvtr", true);
		URI pivotURI = getProjectFileURI("Forward2Reverse.qvtras");
		URI umlxURI = getProjectFileURI("Forward2Reverse.umlx");
		OCL ocl = OCL.newInstance(getProjectMap());
		Resource qvtrResource = doLoad_Concrete(ocl, inputURI, pivotURI, null);
		Resource umlxResource = qvtrResource.getResourceSet().createResource(umlxURI);
		QVTr2UMLX qvtr2umlx = new QVTr2UMLX(ocl.getEnvironmentFactory(), qvtrResource, umlxResource);
		qvtr2umlx.transform();
		umlxResource.save(null);
		ocl.dispose();
	}

	public void testUMLXLoad_Keys_qvtr() throws IOException, InterruptedException, CompilerChainException {
		URI inputURI = URI.createPlatformResourceURI("/org.eclipse.qvtd.xtext.qvtrelation.tests/src/org/eclipse/qvtd/xtext/qvtrelation/tests/models/Keys.qvtr", true);
		URI pivotURI = getProjectFileURI("Keys.qvtras");
		URI umlxURI = getProjectFileURI("Keys.umlx");
		OCL ocl = OCL.newInstance(getProjectMap());
		Resource qvtrResource = doLoad_Concrete(ocl, inputURI, pivotURI, null);
		Resource umlxResource = qvtrResource.getResourceSet().createResource(umlxURI);
		QVTr2UMLX qvtr2umlx = new QVTr2UMLX(ocl.getEnvironmentFactory(), qvtrResource, umlxResource);
		qvtr2umlx.transform();
		umlxResource.save(null);
		ocl.dispose();
	}

	public void testUMLXLoad_RelToCore_qvtr() throws IOException, InterruptedException {
		URI inputURI = URI.createPlatformResourceURI("/org.eclipse.qvtd.examples.qvtrelation.reltocore/qvtrsrc/RelToCore.qvtr", true);
		URI pivotURI = getProjectFileURI("RelToCore.qvtras");
		URI umlxURI = getProjectFileURI("RelToCore.umlx");
		OCL ocl = OCL.newInstance(getProjectMap());
		Resource qvtrResource = doLoad_Concrete(ocl, inputURI, pivotURI, null);
		Resource umlxResource = qvtrResource.getResourceSet().createResource(umlxURI);
		QVTr2UMLX qvtr2umlx = new QVTr2UMLX(ocl.getEnvironmentFactory(), qvtrResource, umlxResource);
		qvtr2umlx.transform();
		umlxResource.save(null);
		ocl.dispose();
	}

	public void testUMLXLoad_SimplerRelToCore_qvtr() throws IOException, InterruptedException {
		URI inputURI = URI.createPlatformResourceURI("/org.eclipse.qvtd.examples.qvtrelation.reltocore/qvtrsrc/SimplerRelToCore.qvtr", true);
		URI pivotURI = getProjectFileURI("SimplerRelToCore.qvtras");
		URI umlxURI = getProjectFileURI("SimplerRelToCore.umlx");
		OCL ocl = OCL.newInstance(getProjectMap());
		Resource qvtrResource = doLoad_Concrete(ocl, inputURI, pivotURI, null);
		Resource umlxResource = qvtrResource.getResourceSet().createResource(umlxURI);
		QVTr2UMLX qvtr2umlx = new QVTr2UMLX(ocl.getEnvironmentFactory(), qvtrResource, umlxResource);
		qvtr2umlx.transform();
		umlxResource.save(null);
		ocl.dispose();
	}
}
