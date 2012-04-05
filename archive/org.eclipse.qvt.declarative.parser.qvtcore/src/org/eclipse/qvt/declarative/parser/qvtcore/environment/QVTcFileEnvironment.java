/*******************************************************************************
 * Copyright (c) 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.parser.qvtcore.environment;

import lpg.runtime.Monitor;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.ocl.examples.modelregistry.environment.FileHandle;
import org.eclipse.qvt.declarative.ecore.QVTCore.QVTCorePackage;
import org.eclipse.qvt.declarative.parser.qvt.environment.QVTFileEnvironment;
import org.eclipse.qvt.declarative.parser.qvtcore.QVTcAnalyzer;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.TopLevelCS;

public class QVTcFileEnvironment extends QVTFileEnvironment<QVTcTopLevelEnvironment, IQVTcNodeEnvironment, TopLevelCS>
{
	public QVTcFileEnvironment(FileHandle file, ResourceSet resourceSet, XMIResource astResource) {
		super(file, resourceSet, astResource);
	}

	@Override
	public QVTcAnalyzer createAnalyzer(Monitor monitor) {
		return new QVTcAnalyzer(this, monitor);
	}

	@Override
	protected QVTcTopLevelEnvironment createRootEnvironment(XMIResource ast, TopLevelCS cst) {
		return new QVTcTopLevelEnvironment(this, ast, cst);
	}

	@Override
	protected String getContentTypeIdentifier() {
		return QVTCorePackage.eCONTENT_TYPE;
	}
}
