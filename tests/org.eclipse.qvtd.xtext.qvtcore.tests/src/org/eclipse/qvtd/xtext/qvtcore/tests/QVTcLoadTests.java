/*******************************************************************************
 * Copyright (c) 2012, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtcore.tests;

import org.eclipse.ocl.xtext.base.services.BaseLinkingService;
import org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase;

/**
 * Tests that load a model and verify that there are no unresolved proxies as a result.
 */
public class QVTcLoadTests extends LoadTestCase
{
	@Override
	protected void setUp() throws Exception {
		BaseLinkingService.DEBUG_RETRY.setState(true);
		QVTcTestUtil.doQVTcoreSetup();
		super.setUp();
	}

	public void testQVTcLoad_expressions_qvtc() throws Exception {
		doLoad_Concrete(getModelsURI("misc/expressions.qvtc"), NO_MESSAGES);
	}

	public void testQVTcLoad_mini_qvtc() throws Exception {
		doLoad_Concrete(getModelsURI("misc/mini.qvtc"), NO_MESSAGES);
	}

	public void testQVTcLoad_uml2rdbms_qvtc() throws Exception {
		doLoad_Concrete(getModelsURI("misc/uml2rdbms.qvtc"), NO_MESSAGES);
	}

	public void testQVTcLoad_uml2rdbms_qvti_qvtc() throws Exception {
		doLoad_Concrete(getModelsURI("misc/uml2rdbms.qvti.qvtc"), NO_MESSAGES);
	}

	public void testQVTcLoad_uml2rdbms_qvtu_qvtc() throws Exception {
		doLoad_Concrete(getModelsURI("misc/uml2rdbms.qvtu.qvtc"), NO_MESSAGES);
	}

	public void testQVTcLoad_HSV2HLS_qvtc() throws Exception {
		doLoad_Concrete(getModelsURI("misc/HSV2HLS.qvtc"), NO_MESSAGES);
	}

	public void testQVTcLoad_Class2RDBMS_qvtc() throws Exception {
		doLoad_Concrete(getModelsURI("Class2RDBMS/Class2RDBMS.qvtc"), NO_MESSAGES);
	}
}