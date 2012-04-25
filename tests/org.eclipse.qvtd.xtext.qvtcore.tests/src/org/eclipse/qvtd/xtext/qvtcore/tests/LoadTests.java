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
package org.eclipse.qvtd.xtext.qvtcore.tests;

import java.io.IOException;

import org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase;
import org.eclipse.qvtd.xtext.qvtcore.QVTcoreStandaloneSetup;

/**
 * Tests that load a model and verify that there are no unresolved proxies as a result.
 */
public class LoadTests extends LoadTestCase
{	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		QVTcoreStandaloneSetup.doSetup();
	}

	public void testLoad_expressions_qvtc() throws IOException, InterruptedException {
		doLoad_Concrete("expressions", "qvtc");
	}	

	public void testLoad_mini_qvtc() throws IOException, InterruptedException {
		doLoad_Concrete("mini", "qvtc");
	}	
}
