/*******************************************************************************
 * Copyright (c) 2012, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.all.tests;

import java.util.Arrays;
import org.eclipse.qvtd.cs2as.compiler.tests.OCL2QVTiTestCases;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

/**
 * Tests the QVTr and QVTc parser / compiler / editor / evaluator / debugger support.
 */
public class AllQVTdTests extends TestCase
{
	public AllQVTdTests() {
		super("");
	}

	public static Test suite() {
		TestSuite result = new TestSuite("QVTd All Tests");
		//	result.addTest(AllCompilerTests.suite());
		//	result.addTest(AllQVTcoreTests.suite());
		//	result.addTest(AllQVTimperativeTests.suite());
		//	result.addTest(AllQVTrelationTests.suite());
		//	result.addTestSuite(QVTruntimeLibraryTests.class);
		result.addTestSuite(GrammarTests.class);
		//	result.addTestSuite(TextModelTests.class);
		//	result.addTestSuite(XMLmodelTests.class);
		result.addTestSuite(OCL2QVTiTestCases.class);
		//	result.addTest(AllUMLXTests.suite());
		// result.addTest(AllATLTests.suite()); -- FIXME waiting for BUG 514604
		//	result.addTest(AllbigMDE2016Tests.suite());	// NB this is very slow since we are -ea
		//	result.addTest(Allexe2016Tests.suite());		// NB this is very slow since we are -ea
		//	result.addTestSuite(MiniOCLCSParsingTest.class);
		return result;
	}

	public Object run(Object args)
			throws Exception {

		TestRunner.run(suite());
		return Arrays
				.asList(new String[] {"Please see raw test suite output for details."});
	}
}
