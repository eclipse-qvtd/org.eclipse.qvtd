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
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.qvt.declarative.ecore.mappings.IMappingMetaDataRegistry;
import org.eclipse.qvt.declarative.emof.QVTCore.util.QVTCoreMappingMetaData;
import org.eclipse.qvt.declarative.modelregistry.standalone.FileHandle;
import org.eclipse.qvt.declarative.parser.environment.IFileEnvironment;
import org.eclipse.qvt.declarative.parser.qvtcore.environment.QVTcTopLevelEnvironment;
import org.eclipse.qvt.declarative.parser.qvtcore.unparser.QVTcUnparser;
import org.eclipse.qvt.declarative.test.parser.AbstractParseTestCase;

public abstract class AbstractQVTcTestCase extends AbstractParseTestCase
{
	@Override protected IFileEnvironment createEnvironment(String fileName) throws IOException, CoreException {
		FileHandle fileHandle = getFileHandle(fileName);
		QVTcTopLevelEnvironment environment = new QVTcTopLevelEnvironment(fileHandle, resourceSet)
		{
			@Override
			protected void initializePackageNs(EPackage ePackage) {
				super.initializePackageNs(ePackage);
				ePackage.setNsURI(ePackage.getNsURI().replace(".unparsed", ""));
			}			
		};
		return environment;
	}
	
	@Override protected QVTcUnparser createUnparser(Resource referenceResource) {
		return new QVTcUnparser(referenceResource);
	}

	@Override
	protected IMappingMetaDataRegistry getMappingMetaDataRegistry() {
		IMappingMetaDataRegistry mappingMetaDataRegistry = super.getMappingMetaDataRegistry();
		QVTCoreMappingMetaData.INSTANCE.getFactory(mappingMetaDataRegistry);
//		QVTCorePlusMappingMetaData.INSTANCE.getInstance(mappingMetaDataRegistry);
		return mappingMetaDataRegistry;
	}
	
	@Override protected String getTextExtension() {
		return "qvtc";
	}

	@Override protected String getXMLExtension(boolean generateEMOF) {
		return (generateEMOF ? "qvtcore" :  "eqvtcore");
	}
}
