/*******************************************************************************
 * Copyright (c) 2002, 2016 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   E.D.Willink - Bug 298634
 *******************************************************************************/

package org.eclipse.qvtd.all.tests;

import java.util.Arrays;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.qvtd.cs2as.compiler.tests.OCL2QVTiTestCases;
import org.eclipse.qvtd.doc.bigmde2016.tests.qvtc.BigMDE2016_QVTc_AutomatedTests;
import org.eclipse.qvtd.doc.exe2016.tests.qvtc.EXE2016_QVTc_AutomatedTests;
import org.eclipse.qvtd.doc.exe2016.tests.qvtr.EXE2016_QVTr_AutomatedTests;
import org.eclipse.qvtd.doc.minioclcs.xtext.tests.MiniOCLCSParsingTest;
import org.eclipse.qvtd.xtext.qvtbase.tests.QVTbaseLibraryTests;
import org.eclipse.qvtd.xtext.qvtcore.tests.AllQVTcoreTests;
import org.eclipse.qvtd.xtext.qvtimperative.tests.AllQVTimperativeTests;
import org.eclipse.qvtd.xtext.qvtimperative.tests.QVTiDebuggerTests;
import org.eclipse.qvtd.xtext.qvtrelation.tests.AllQVTrelationTests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

/**
 * Tests the QVTr and QVTc parser / compiler / editor / evaluator / debugger support.
 */
@SuppressWarnings("nls")
public class AllQVTdTests extends TestCase
{
	public AllQVTdTests() {
		super("");
	}

	public static Test suite() {
		TestSuite result = new TestSuite("QVTd All Tests");
		result.addTest(AllQVTcoreTests.suite());
		result.addTest(AllQVTimperativeTests.suite());
		if (!EMFPlugin.IS_ECLIPSE_RUNNING) {		// FIXME should work as plugin test too
			result.addTest(AllQVTrelationTests.suite());
		}
		result.addTestSuite(QVTbaseLibraryTests.class);
		if (EMFPlugin.IS_ECLIPSE_RUNNING) {
			result.addTestSuite(QVTiDebuggerTests.class);
		}
		else {
			result.addTestSuite(GrammarTests.class);		// *.xtextbin fail to load in Eclipse, but we don't need to test twice anyway.
		}
		if (!EMFPlugin.IS_ECLIPSE_RUNNING) {		// FIXME should work as plugin test too
			result.addTestSuite(OCL2QVTiTestCases.class);
		}
		result.addTestSuite(BigMDE2016_QVTc_AutomatedTests.class);	// NB this is very slow since we are -ea
		result.addTestSuite(EXE2016_QVTc_AutomatedTests.class);		// NB this is very slow since we are -ea
		result.addTestSuite(EXE2016_QVTr_AutomatedTests.class);		// NB this is very slow since we are -ea
		result.addTestSuite(MiniOCLCSParsingTest.class);
		return result;
	}

	public Object run(Object args)
			throws Exception {

		TestRunner.run(suite());
		return Arrays
				.asList(new String[] {"Please see raw test suite output for details."});
	}
}
