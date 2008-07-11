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
