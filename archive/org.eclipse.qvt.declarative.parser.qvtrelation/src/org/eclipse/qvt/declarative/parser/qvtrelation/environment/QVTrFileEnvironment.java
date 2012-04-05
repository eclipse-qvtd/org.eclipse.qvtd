/*******************************************************************************
 * Copyright (c) 2007,2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.parser.qvtrelation.environment;

import lpg.runtime.Monitor;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.ocl.examples.modelregistry.environment.FileHandle;
import org.eclipse.qvt.declarative.ecore.QVTRelation.QVTRelationPackage;
import org.eclipse.qvt.declarative.parser.qvt.environment.QVTFileEnvironment;
import org.eclipse.qvt.declarative.parser.qvtrelation.QVTrAnalyzer;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.TopLevelCS;

public class QVTrFileEnvironment extends QVTFileEnvironment<QVTrTopLevelEnvironment, IQVTrNodeEnvironment, TopLevelCS> implements IQVTrEnvironment
{
	public QVTrFileEnvironment(FileHandle file, ResourceSet resourceSet, XMIResource astResource) {
		super(file, resourceSet, astResource);
	}

	@Override
	public QVTrAnalyzer createAnalyzer(Monitor monitor) {
		return new QVTrAnalyzer(this, monitor);
	}

	@Override
	protected QVTrTopLevelEnvironment createRootEnvironment(XMIResource ast, TopLevelCS cst) {
		return new QVTrTopLevelEnvironment(this, ast, cst);
	}

	@Override
	protected String getContentTypeIdentifier() {
		return QVTRelationPackage.eCONTENT_TYPE;
	}
}
