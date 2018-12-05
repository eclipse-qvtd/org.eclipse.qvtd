/*******************************************************************************
 * Copyright (c) 2015, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.all.tests;

import org.eclipse.ocl.examples.test.xtext.AbstractGrammarTests;
import org.eclipse.ocl.xtext.completeocl.CompleteOCLStandaloneSetup;
import org.eclipse.ocl.xtext.oclinecore.OCLinEcoreStandaloneSetup;
import org.eclipse.ocl.xtext.oclstdlib.OCLstdlibStandaloneSetup;
import org.eclipse.qvtd.xtext.qvtbase.QVTbaseGrammarResource;
import org.eclipse.qvtd.xtext.qvtcore.QVTcoreGrammarResource;
import org.eclipse.qvtd.xtext.qvtimperative.QVTimperativeGrammarResource;
import org.eclipse.qvtd.xtext.qvtrelation.QVTrelationGrammarResource;

/**
 * Tests.
 */
public class GrammarTests extends AbstractGrammarTests
{
	@Override
	protected void setUp() throws Exception {
		CompleteOCLStandaloneSetup.class.getName();			// Ensure hidden reference is resolveable on classpath.
		OCLinEcoreStandaloneSetup.class.getName();			// Ensure hidden reference is resolveable on classpath.
		OCLstdlibStandaloneSetup.class.getName();			// Ensure hidden reference is resolveable on classpath.
		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Checks that the local *.xtextbin is the same as the pre-compiled Java implementation.
	 *
	 * FIXME check the library/model version instead.
	 */
	public void testGrammar_QVTbase() throws Exception {
		doTestGrammar(QVTbaseGrammarResource.class, "QVTbase.xtextbin", QVTbaseGrammarResource.INSTANCE);
	}

	public void testGrammar_QVTcore() throws Exception {
		doTestGrammar(QVTcoreGrammarResource.class, "QVTcore.xtextbin", QVTcoreGrammarResource.INSTANCE);
	}

	public void testGrammar_QVTimperative() throws Exception {
		doTestGrammar(QVTimperativeGrammarResource.class, "QVTimperative.xtextbin", QVTimperativeGrammarResource.INSTANCE);
	}

	public void testGrammar_QVTrelation() throws Exception {
		doTestGrammar(QVTrelationGrammarResource.class, "QVTrelation.xtextbin", QVTrelationGrammarResource.INSTANCE);
	}
}
