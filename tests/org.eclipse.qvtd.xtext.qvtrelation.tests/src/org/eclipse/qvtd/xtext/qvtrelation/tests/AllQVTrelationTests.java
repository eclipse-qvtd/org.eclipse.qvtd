/**
 * <copyright>
 * 
 * Copyright (c) 2002,2011 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   E.D.Willink - Bug 298634
 *
 * </copyright>
 *
 * $Id: AllXtextTests.java,v 1.10 2011/05/20 15:27:16 ewillink Exp $
 */

package org.eclipse.qvtd.xtext.qvtrelation.tests;

import java.util.Arrays;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

/**
 * Tests for the Xtext QVTr editor support.
 */
@SuppressWarnings("nls")
public class AllQVTrelationTests extends TestCase
{
	public AllQVTrelationTests() {
		super("");
	}

	public static Test suite() {
		TestSuite result = new TestSuite("QVTr Editor Support");			
		result.addTestSuite(LoadTests.class);
//		if (EMFPlugin.IS_ECLIPSE_RUNNING) {
//			result.addTestSuite(EditorTests.class);
//		}
//		else {	// Bug 370824 Bug 371394 causes this to fail on Hudson
//			result.addTestSuite(UsageTests.class);
//		}
		return result;
	}

	public Object run(Object args)
		throws Exception {

		TestRunner.run(suite());
		return Arrays
			.asList(new String[] {"Please see raw test suite output for details."});
	}
}
