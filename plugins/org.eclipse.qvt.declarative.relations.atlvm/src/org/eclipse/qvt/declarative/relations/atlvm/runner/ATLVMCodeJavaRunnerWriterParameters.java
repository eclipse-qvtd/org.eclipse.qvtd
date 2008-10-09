/**
 * <copyright>
 * 
 * Copyright (c) 2007, 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * </copyright>
 * 
 * Contributors:
 *     Quentin Glineur - initial API and implementation
 *
 * $Id: ATLVMCodeJavaRunnerWriterParameters.java,v 1.4 2008/10/09 17:21:05 qglineur Exp $
 */
package org.eclipse.qvt.declarative.relations.atlvm.runner;

import java.io.File;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationalTransformation;

public class ATLVMCodeJavaRunnerWriterParameters {
	protected RelationalTransformation transformation;
	protected URI transformationURI;
	protected URI sourceFolderURI;
	
	public ATLVMCodeJavaRunnerWriterParameters(Resource transformationResource, URI sourceFolderURI){
		EObject eObject = transformationResource.getContents().get(0);
		if (eObject instanceof RelationalTransformation) {
			transformation = (RelationalTransformation) eObject;
		}
		transformationURI = transformationResource.getURI();
		this.sourceFolderURI = sourceFolderURI;
	}

	public RelationalTransformation getTransformation() {
		return transformation;
	}

	public URI getTransformationURI() {
		return transformationURI;
	}

	public URI getSourceFolderURI() {
		return sourceFolderURI;
	}
	
	public String getBasePackage() {
		URI base = transformationURI.trimSegments(1).appendSegment("");
		URI relativeBase = base.deresolve(sourceFolderURI);
		if (relativeBase.hasTrailingPathSeparator()) {
			relativeBase = relativeBase.trimSegments(1);
		}
		String packageName = relativeBase.toFileString().replace(
				File.separator, ".");
		return packageName;
	}
	
	public String getClassName() {
		String unformatedName = transformation.getName();
		return unformatedName.substring(0, 1).toUpperCase()
				+ unformatedName.substring(1);
	}
	
	public String getASMFileName() {
		URI fileURI = transformationURI.trimFileExtension();
		return fileURI.lastSegment();
	}

}
