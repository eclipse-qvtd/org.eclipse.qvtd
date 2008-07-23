/*******************************************************************************
 * Copyright (c) 2007 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.test.parser.qvtcore;

import java.io.IOException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.qvt.declarative.ecore.mappings.MappingConfigurationException;

public class QVTcUnparseTests extends AbstractQVTcTestCase
{
	public void testUnparseEqvtCore_test() throws IOException, CoreException, MappingConfigurationException {
		unparserTest("test");
	}

	public void testUnparseQvtcore_test() throws IOException, CoreException, MappingConfigurationException {
		asEMOF = true;
		unparserTest("test");
	}

	public void testUnparseEqvtcore_Rule4b() throws IOException, CoreException, MappingConfigurationException {
		unparserTest("Rule4b");
	}

	public void testUnparseEqvtcore_Rule6() throws IOException, CoreException, MappingConfigurationException {
		unparserTest("Rule6");
	}
	
	public void testUnparseEqvtCore_multimaps() throws IOException, CoreException, MappingConfigurationException {
		unparserTest("multimaps");
	}

}
