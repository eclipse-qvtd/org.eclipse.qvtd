/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/

package org.eclipse.qvtd.compiler.tests;

import java.util.Arrays;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

public class AllCompilerTests extends TestCase
{
	public AllCompilerTests() {
		super("");
	}

	public static Test suite() {
		TestSuite result = new TestSuite("All Compiler Tests");
		result.addTestSuite(AnalysisTests.class);
		result.addTestSuite(RuntimeConnectionTests.class);
		return result;
	}

	public Object run(Object args)
			throws Exception {

		TestRunner.run(suite());
		return Arrays.asList(new String[] {"Please see raw test suite output for details."});
	}
}
