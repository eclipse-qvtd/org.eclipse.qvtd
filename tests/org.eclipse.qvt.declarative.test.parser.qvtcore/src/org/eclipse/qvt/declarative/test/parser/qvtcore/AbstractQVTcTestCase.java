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
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.qvt.declarative.ecore.QVTCore.QVTCorePackage;
import org.eclipse.qvt.declarative.editor.qvtcore.ui.QVTcCreationFactory;
import org.eclipse.qvt.declarative.editor.ui.ICreationFactory;
import org.eclipse.qvt.declarative.modelregistry.standalone.FileHandle;
import org.eclipse.qvt.declarative.parser.environment.IFileEnvironment;
import org.eclipse.qvt.declarative.parser.qvtcore.environment.QVTcFileEnvironment;
import org.eclipse.qvt.declarative.test.parser.AbstractParseTestCase;

public abstract class AbstractQVTcTestCase extends AbstractParseTestCase
{
	@Override protected IFileEnvironment createEnvironment(String fileName, URI astURI) throws IOException, CoreException {
		FileHandle fileHandle = getFileHandle(fileName);
		XMIResource astResource = (XMIResource) resourceSet.createResource(astURI, QVTCorePackage.eCONTENT_TYPE);
		QVTcFileEnvironment environment = new QVTcFileEnvironment(fileHandle, resourceSet, astResource)
		{
			@Override
			public void initializePackageNs(EPackage ePackage) {
				super.initializePackageNs(ePackage);
				ePackage.setNsURI(ePackage.getNsURI().replace(".unparsed", ""));
			}			
		};
		return environment;
	}

	@Override
	protected ICreationFactory getCreationFactory() {
		return QVTcCreationFactory.INSTANCE;
	}
}
