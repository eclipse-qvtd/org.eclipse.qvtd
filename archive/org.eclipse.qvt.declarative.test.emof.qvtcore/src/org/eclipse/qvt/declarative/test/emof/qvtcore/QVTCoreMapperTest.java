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
package org.eclipse.qvt.declarative.test.emof.qvtcore;

import java.io.IOException;

import org.eclipse.qvt.declarative.ecore.mappings.IMappingMetaDataRegistry;
import org.eclipse.qvt.declarative.ecore.mappings.MappingConfigurationException;
import org.eclipse.qvt.declarative.emof.QVTCore.util.QVTCoreMappingMetaData;
import org.eclipse.qvt.declarative.test.emof.AbstractMapperTest;

public class QVTCoreMapperTest extends AbstractMapperTest
{
	public void eqvtcoreToQVTcore(String prefixName) throws IOException, MappingConfigurationException {
		ecoreToAdaptedEMOF(prefixName, ".eqvtcore", ".qvtcore");
	}

	@Override
	protected String getEcoreContentTypeIdentifier() {
		return org.eclipse.qvt.declarative.ecore.QVTCore.QVTCorePackage.eCONTENT_TYPE;
	}

	@Override
	protected IMappingMetaDataRegistry getMappingMetaDataRegistry() {
		IMappingMetaDataRegistry mappingMetaDataRegistry = super.getMappingMetaDataRegistry();
		QVTCoreMappingMetaData.INSTANCE.getFactory(mappingMetaDataRegistry);
//		QVTCorePlusMappingMetaData.INSTANCE.getInstance(mappingMetaDataRegistry);
		return mappingMetaDataRegistry;
	}
	
	public void qvtcoreLoad(String prefixName) throws IOException, MappingConfigurationException {
		adaptedEMOFLoad(prefixName, ".eqvtcore", ".qvtcore");
	}

	public void testEcoreToEMOF_EmptyTx() throws IOException, MappingConfigurationException { eqvtcoreToQVTcore("EmptyTx"); }
	public void testEmofLoad_EmptyTx() throws IOException, MappingConfigurationException { qvtcoreLoad("EmptyTx"); }
	public void testEcoreToEMOF_Rule4a() throws IOException, MappingConfigurationException { eqvtcoreToQVTcore("Rule4a"); }
	public void testEmofLoad_Rule4a() throws IOException, MappingConfigurationException { qvtcoreLoad("Rule4a"); }
}
