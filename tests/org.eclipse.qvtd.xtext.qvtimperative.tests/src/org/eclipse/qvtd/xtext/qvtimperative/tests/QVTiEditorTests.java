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
package org.eclipse.qvtd.xtext.qvtimperative.tests;

import java.io.IOException;

import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLLinkingService;
import org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase;
import org.eclipse.qvtd.xtext.qvtimperative.QVTimperativeStandaloneSetup;

/**
 * Tests that load a model and verify that there are no unresolved proxies as a result.
 */
public class QVTiEditorTests extends LoadTestCase
{	
	@Override
	protected void setUp() throws Exception {
		EssentialOCLLinkingService.DEBUG_RETRY = true;
		super.setUp();
		QVTimperativeStandaloneSetup.doSetup();
	}
	public void testLoad_HSV2HLS_qvti() throws IOException, InterruptedException {
		doLoad_Concrete("HSV2HLS/HSV2HLS", "qvti");
	}	

//	public void testLoad_ClassToRDBMSSchedule_qvti() throws IOException, InterruptedException {
//		doLoad_Concrete("ClassToRDBMSSchedule", "qvti");
//	}	
}
