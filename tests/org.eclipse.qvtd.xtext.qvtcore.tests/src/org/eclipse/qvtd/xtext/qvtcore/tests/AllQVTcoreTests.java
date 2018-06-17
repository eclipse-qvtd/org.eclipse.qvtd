/*******************************************************************************
 * Copyright (c) 2016, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/

package org.eclipse.qvtd.xtext.qvtcore.tests;

import java.util.Arrays;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

/**
 * Tests for the Xtext QVTc editor support.
 */
public class AllQVTcoreTests extends TestCase
{
	public AllQVTcoreTests() {
		super("");
	}

	public static Test suite() {
		TestSuite result = new TestSuite("All QVTcore Tests");
		result.addTestSuite(QVTcLoadTests.class);
		result.addTestSuite(QVTcDomainUsageTests.class);
		result.addTestSuite(QVTcSerializeTests.class);
		result.addTestSuite(QVTcCompilerTests.class);
		return result;
	}

	public Object run(Object args)
			throws Exception {

		TestRunner.run(suite());
		return Arrays
				.asList(new String[] {"Please see raw test suite output for details."});
	}
}
