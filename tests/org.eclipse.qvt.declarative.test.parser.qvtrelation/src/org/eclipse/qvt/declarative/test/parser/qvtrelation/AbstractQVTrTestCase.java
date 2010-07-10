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
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.ocl.examples.modelregistry.environment.FileHandle;
import org.eclipse.qvt.declarative.ecore.QVTRelation.QVTRelationPackage;
import org.eclipse.qvt.declarative.editor.qvtrelation.ui.QVTrCreationFactory;
import org.eclipse.qvt.declarative.editor.ui.ICreationFactory;
import org.eclipse.qvt.declarative.parser.environment.ICSTFileEnvironment;
import org.eclipse.qvt.declarative.parser.qvtrelation.environment.QVTrFileEnvironment;
import org.eclipse.qvt.declarative.parser.qvtrelation.environment.QVTrTopLevelEnvironment;
import org.eclipse.qvt.declarative.test.parser.AbstractParseTestCase;

public abstract class AbstractQVTrTestCase extends AbstractParseTestCase
{
	@Override protected ICSTFileEnvironment createEnvironment(String fileName, URI astURI) throws IOException, CoreException {
		FileHandle fileHandle = getFileHandle(fileName);
		XMIResource astResource = (XMIResource) resourceSet.createResource(astURI, QVTRelationPackage.eCONTENT_TYPE);
		QVTrFileEnvironment environment = new QVTrFileEnvironment(fileHandle, resourceSet, astResource)
		{
			@Override
			public void initializePackageNs(EPackage ePackage) {
				super.initializePackageNs(ePackage);
				ePackage.setNsURI(ePackage.getNsURI().replace(".unparsed", ""));
			}			

			@Override
			protected void postParse(QVTrTopLevelEnvironment rootEnvironment) {
				super.postParse(rootEnvironment);
				rootEnvironment.checkMappings();
			}
		};
		return environment;
	}

	@Override
	protected ICreationFactory getCreationFactory() {
		return QVTrCreationFactory.INSTANCE;
	}
}
