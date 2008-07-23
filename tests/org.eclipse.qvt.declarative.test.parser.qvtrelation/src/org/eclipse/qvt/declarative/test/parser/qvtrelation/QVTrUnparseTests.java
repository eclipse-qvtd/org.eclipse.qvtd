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
package org.eclipse.qvt.declarative.test.parser.qvtrelation;

import java.io.IOException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.qvt.declarative.ecore.mappings.MappingConfigurationException;

public class QVTrUnparseTests extends AbstractQVTrTestCase
{
	public void testUnparseEqvtRelation_test() throws IOException, CoreException, MappingConfigurationException {
		unparserTest("SeqToStm");
	}

	public void testUnparseQvtrelation_test() throws IOException, CoreException, MappingConfigurationException {
		asEMOF = true;
		unparserTest("SeqToStm");
	}
}
