/*******************************************************************************
 * Copyright (c) 2012, 2014 Willink Transformations and others.
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

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.ocl.xtext.base.services.BaseLinkingService;
import org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase;
import org.eclipse.qvtd.xtext.qvtcore.QVTcoreStandaloneSetup;

import com.google.inject.Guice;

/**
 * Tests that load a model and verify that there are no unresolved proxies as a result.
 */
public class LoadTests extends LoadTestCase
{	
	/**
	 * Perform the appropriate initialization to support QVTcore parsing and editing using Xtext.
	 * NB. This must be called before setUp() creates a GlobalStateMemento if the aggressive DEBUG_GC
	 * garbage collection is enabled.
	 */
	public static void doQVTcoreSetup() {
    	if (!EMFPlugin.IS_ECLIPSE_RUNNING) {
    		QVTcoreStandaloneSetup.doSetup();
    	}
    	else {
    		Guice.createInjector(new org.eclipse.qvtd.xtext.qvtcore.QVTcoreRuntimeModule());
    	}
	}
	
	@Override
	protected void setUp() throws Exception {
		BaseLinkingService.DEBUG_RETRY.setState(true);
		doQVTcoreSetup();
		super.setUp();
	}

	public void testLoad_expressions_qvtc() throws IOException, InterruptedException {
		doLoad_Concrete("models/expressions.qvtc");
	}	

	public void testLoad_mini_qvtc() throws IOException, InterruptedException {
		doLoad_Concrete("models/mini.qvtc");
	}	

	public void testLoad_uml2rdbms_qvtc() throws IOException, InterruptedException {
		doLoad_Concrete("models/uml2rdbms.qvtc");
	}	

	public void testLoad_uml2rdbms_qvti_qvtc() throws IOException, InterruptedException {
		doLoad_Concrete("models/uml2rdbms.qvti.qvtc");
	}	

	public void testLoad_uml2rdbms_qvtu_qvtc() throws IOException, InterruptedException {
		doLoad_Concrete("models/uml2rdbms.qvtu.qvtc");
	}	

	public void testLoad_HSV2HLS_qvtc() throws IOException, InterruptedException {
		doLoad_Concrete("models/HSV2HLS.qvtc");
	}	

	public void testLoad_Class2RDBMS_qvtc() throws IOException, InterruptedException {
		doLoad_Concrete("Class2RDBMS/Class2RDBMS.qvtc");
	}	
}
