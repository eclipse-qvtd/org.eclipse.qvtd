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
package org.eclipse.qvt.declarative.test.emof.qvtrelation;

import java.io.IOException;

import org.eclipse.qvt.declarative.ecore.QVTRelation.QVTRelationPackage;
import org.eclipse.qvt.declarative.ecore.mappings.IMappingMetaDataRegistry;
import org.eclipse.qvt.declarative.ecore.mappings.MappingConfigurationException;
import org.eclipse.qvt.declarative.emof.QVTRelation.util.QVTRelationMappingMetaData;
import org.eclipse.qvt.declarative.test.emof.AbstractMapperTest;

public class QVTRelationMapperTest extends AbstractMapperTest
{
	public void eqvtrelationToQVTrelation(String prefixName) throws IOException, MappingConfigurationException {
		ecoreToAdaptedEMOF(prefixName, ".eqvtrelation", ".qvtrelation");
	}

	@Override
	protected String getEcoreContentTypeIdentifier() {
		return QVTRelationPackage.eCONTENT_TYPE;
	}

	@Override
	protected IMappingMetaDataRegistry getMappingMetaDataRegistry() {
		IMappingMetaDataRegistry mappingMetaDataRegistry = super.getMappingMetaDataRegistry();
		QVTRelationMappingMetaData.INSTANCE.getFactory(mappingMetaDataRegistry);
		return mappingMetaDataRegistry;
	}
	
	public void qvtrelationLoad(String prefixName) throws IOException, MappingConfigurationException {
		adaptedEMOFLoad(prefixName, ".eqvtrelation", ".qvtrelation");
	}
	
	public void testEcoreToEMOF_EmptyTx() throws IOException, MappingConfigurationException { eqvtrelationToQVTrelation("EmptyTx"); }
	public void testEmofLoad_EmptyTx() throws IOException, MappingConfigurationException { qvtrelationLoad("EmptyTx"); }
//	public void testEcoreToEMOF_Rule4a() throws IOException, MappingConfigurationException { eqvtrelationToQVTrelation("Rule4a"); }
//	public void testEmofLoad_Rule4a() throws IOException, MappingConfigurationException { qvtrelationLoad("Rule4a"); }
}
