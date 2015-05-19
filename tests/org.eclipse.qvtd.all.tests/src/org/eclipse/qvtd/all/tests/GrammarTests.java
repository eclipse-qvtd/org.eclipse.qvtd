/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.all.tests;

import org.eclipse.ocl.examples.test.xtext.AbstractGrammarTests;
import org.eclipse.ocl.xtext.completeocl.CompleteOCLStandaloneSetup;
import org.eclipse.ocl.xtext.oclinecore.OCLinEcoreStandaloneSetup;
import org.eclipse.ocl.xtext.oclstdlib.OCLstdlibStandaloneSetup;
import org.eclipse.qvtd.xtext.qvtcore.QVTcoreGrammarResource;
import org.eclipse.qvtd.xtext.qvtcorebase.QVTcoreBaseGrammarResource;
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
	public void testGrammar_QVTcore() throws Exception {
		doTestGrammar(QVTcoreGrammarResource.class.getResource("QVTcore.xtextbin"), QVTcoreGrammarResource.INSTANCE);
	}
	
	public void testGrammar_QVTcoreBase() throws Exception {
		doTestGrammar(QVTcoreBaseGrammarResource.class.getResource("QVTcoreBase.xtextbin"), QVTcoreBaseGrammarResource.INSTANCE);
	}
	
	public void testGrammar_QVTimperative() throws Exception {
		doTestGrammar(QVTimperativeGrammarResource.class.getResource("QVTimperative.xtextbin"), QVTimperativeGrammarResource.INSTANCE);
	}
	
	public void testGrammar_QVTrelation() throws Exception {
		doTestGrammar(QVTrelationGrammarResource.class.getResource("QVTrelation.xtextbin"), QVTrelationGrammarResource.INSTANCE);
	}
}
