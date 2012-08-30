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

	public void testLoad_Keys_qvtr() throws IOException, InterruptedException {
		doLoad_Concrete("Keys", "qvtr");
	}	

	public void testLoad_hstmtostm_qvtr() throws IOException, InterruptedException {
		doLoad_Concrete("hstmtostm", "qvtr");
	}	

//	public void testLoad_RelToCoreWithoutErrors_qvtr() throws IOException, InterruptedException {
//		doLoad_Concrete("RelToCoreWithoutErrors", "qvtr");
//	}	
}
