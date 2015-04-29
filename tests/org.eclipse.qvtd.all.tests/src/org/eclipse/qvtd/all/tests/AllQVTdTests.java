/*******************************************************************************
 * Copyright (c) 2002,2011 IBM Corporation and others.
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

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

import org.eclipse.qvtd.build.cs2as.tests.OCL2QVTiTestCases;
import org.eclipse.qvtd.build.etl.tests.QVTdMtcTests;
import org.eclipse.qvtd.build.qvtrtoqvtc.tests.QvtrToQvtcTests;
import org.eclipse.qvtd.xtext.qvtbase.tests.QVTbaseLibraryTests;
import org.eclipse.qvtd.xtext.qvtcore.tests.AllQVTcoreTests;
import org.eclipse.qvtd.xtext.qvtimperative.tests.AllQVTimperativeTests;
import org.eclipse.qvtd.xtext.qvtrelation.tests.AllQVTrelationTests;

/**
 * Tests the QWVTr and QVTc parser / compiler / editor / evaluator / debugger support.
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
		result.addTest(AllQVTrelationTests.suite());
		result.addTestSuite(QVTbaseLibraryTests.class);
		result.addTestSuite(GrammarTests.class);
		result.addTestSuite(QVTdMtcTests.class);
		result.addTestSuite(QvtrToQvtcTests.class);
		result.addTestSuite(OCL2QVTiTestCases.class);
		return result;
	}

	public Object run(Object args)
		throws Exception {

		TestRunner.run(suite());
		return Arrays
			.asList(new String[] {"Please see raw test suite output for details."});
	}
}
