/*******************************************************************************
 * Copyright (c) 2022 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.all.tests;

import org.eclipse.ocl.examples.codegen.calling.AbstractCallingConvention;
import org.junit.Test;

import junit.framework.TestCase;

public class LastTest extends TestCase
{
	// Workaround for non-functional @AfterClass
	@Test
	public void testLast() {
		AbstractCallingConvention.printAllUsages();
	}
}
