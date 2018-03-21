/*******************************************************************************
 * Copyright (c) 2002,2017 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   E.D.Willink - Bug 298634
 *******************************************************************************/

package org.eclipse.qvtd.xtext.qvtrelation.tests;

import java.util.Arrays;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

/**
 * Tests for the Xtext QVTr editor support.
 */
public class AllQVTrelationTests extends TestCase
{
	public AllQVTrelationTests() {
		super("");
	}

	public static Test suite() {
		TestSuite result = new TestSuite("All QVTrelation Tests");
		result.addTestSuite(QVTrLoadTests.class);
		result.addTestSuite(QVTrDomainUsageTests.class);
		result.addTestSuite(QVTr2QVTrTests.class);
		//		if (EMFPlugin.IS_ECLIPSE_RUNNING) {
		//			result.addTestSuite(EditorTests.class);		-- not yet written
		//		}
		result.addTestSuite(QVTrSerializeTests.class);
		result.addTestSuite(QVTrCompilerTests.class);
		return result;
	}

	public Object run(Object args)
			throws Exception {

		TestRunner.run(suite());
		return Arrays
				.asList(new String[] {"Please see raw test suite output for details."});
	}
}
