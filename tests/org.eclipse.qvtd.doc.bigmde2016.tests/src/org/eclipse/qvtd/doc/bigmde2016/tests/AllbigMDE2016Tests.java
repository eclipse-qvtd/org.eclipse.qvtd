/*******************************************************************************
 * Copyright (c) 2017, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/

package org.eclipse.qvtd.doc.bigmde2016.tests;

import java.util.Arrays;

import org.eclipse.qvtd.doc.bigmde2016.tests.qvtc.BigMDE2016_QVTc_AutomatedTests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

/**
 * Tests for the BigMDE 2016 example.
 */
public class AllbigMDE2016Tests extends TestCase
{
	public AllbigMDE2016Tests() {
		super("");
	}

	public static Test suite() {
		TestSuite result = new TestSuite("All BigMDE 2016 Tests");
		result.addTestSuite(BigMDE2016_QVTc_AutomatedTests.class);	// NB this is very slow since we are -ea
		return result;
	}

	public Object run(Object args)
			throws Exception {

		TestRunner.run(suite());
		return Arrays
				.asList(new String[] {"Please see raw test suite output for details."});
	}
}
