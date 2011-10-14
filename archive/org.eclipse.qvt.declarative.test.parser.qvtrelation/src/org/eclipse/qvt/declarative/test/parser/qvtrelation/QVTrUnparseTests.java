/**
 * <copyright>
 * 
 * Copyright (c) 2007,2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: QVTrUnparseTests.java,v 1.2 2008/12/31 18:22:40 ewillink Exp $
 */
package org.eclipse.qvt.declarative.test.parser.qvtrelation;

import java.io.IOException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.qvt.declarative.ecore.mappings.MappingConfigurationException;

public class QVTrUnparseTests extends AbstractQVTrTestCase
{
	public void testUnparseEqvtRelation_SeqToStm() throws IOException, CoreException, MappingConfigurationException {
		unparserTest("SeqToStm");
	}

	public void testUnparseQvtrelation_SeqToStm() throws IOException, CoreException, MappingConfigurationException {
		asEMOF = true;
		unparserTest("SeqToStm");
	}
	
//	public void testParseEqvtRelation_RelToCoreWithoutErrors() throws IOException, CoreException, MappingConfigurationException {
//		parserTest("RelToCoreWithoutErrors", null);
//	}
	
	public void testUnparseEqvtRelation_RelToCoreWithoutErrors() throws IOException, CoreException, MappingConfigurationException {
		unparserTest("RelToCoreWithoutErrors");
	}
}
