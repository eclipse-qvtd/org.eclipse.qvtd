/**
 * <copyright>
 * 
 * Copyright (c) 2007,2009 E.D.Willink and others.
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
 * $Id: OCLCreationFactory.java,v 1.9 2010/07/10 09:35:34 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.ocl.ui;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.ocl.examples.modelregistry.environment.FileHandle;
import org.eclipse.ocl.lpg.ProblemHandler;
import org.eclipse.qvt.declarative.ecore.mappings.IMappingMetaData;
import org.eclipse.qvt.declarative.editor.ocl.ui.imp.OCLParseController;
import org.eclipse.qvt.declarative.editor.ocl.ui.imp.OCLSourcePositionLocator;
import org.eclipse.qvt.declarative.editor.ocl.ui.imp.OCLTreeModelBuilder;
import org.eclipse.qvt.declarative.editor.ui.IPageManager;
import org.eclipse.qvt.declarative.editor.ui.builder.CommonNature;
import org.eclipse.qvt.declarative.editor.ui.common.AbstractCreationFactory;
import org.eclipse.qvt.declarative.editor.ui.imp.CommonTreeModelBuilder;
import org.eclipse.qvt.declarative.emof.EssentialOCL.util.EssentialOCLMappingMetaData;
import org.eclipse.qvt.declarative.emof.FullOCL.util.FullOCLMappingMetaData;
import org.eclipse.qvt.declarative.parser.environment.ICSTRootEnvironment;
import org.eclipse.qvt.declarative.parser.ocl.environment.OCLFileEnvironment;
import org.eclipse.qvt.declarative.parser.ui.preferences.QVTPreferences;
import org.eclipse.qvt.declarative.parser.unparser.OCLUnparser;

public class OCLCreationFactory extends AbstractCreationFactory
{
	public static OCLCreationFactory INSTANCE = new OCLCreationFactory();
	public static final String BUILDER_ID = OCLBuilder.class.getName();
	public static final String EDITOR_ID = OCLEditor.class.getName();
	public static final String MULTI_EDITOR_ID = OCLMultiEditor.class.getName();
	public static final String NATURE_ID = OCLNature.class.getName();
	public static final String PROBLEM_MARKER_ID = OCLMarkerProblemHandler.class.getPackage().getName() + ".oclProblem";

	protected OCLCreationFactory() {}
	
	public OCLFileEnvironment createFileEnvironment(FileHandle fileHandle, ResourceSet resourceSet, URI astURI) {
		XMIResource astResource = (XMIResource) resourceSet.createResource(astURI, EssentialOCLMappingMetaData.INSTANCE.getEcoreContentTypeIdentifier());
		return new OCLFileEnvironment(fileHandle, resourceSet, astResource);
	}
	
	public CommonNature createNature() {
		return new OCLNature();
	}
	
	public OCLParseController createParseController() {
		return new OCLParseController();
	}

	public ProblemHandler createProblemHandler(IFile file) {
		return new OCLMarkerProblemHandler(file);
	}

	public OCLSourcePositionLocator createSourcePositionLocator(ICSTRootEnvironment environment) {
		return new OCLSourcePositionLocator(environment);
	}

	public OCLTextEditor createTextEditor(IPageManager editorPageManager) {
		return new OCLTextEditor(editorPageManager);
	}

	@Override
	public CommonTreeModelBuilder createTreeModelBuilder(boolean showAST) {
		return new OCLTreeModelBuilder(showAST);
	}

	public OCLUnparser createUnparser(Resource resource) {
		return new OCLUnparser(resource);
	}

	public String getBuilderId() { return BUILDER_ID; }
	public String[] getEMOFExtensions() { return QVTPreferences.getOCLEMOFExtensions(); }
	public String[] getEcoreExtensions() { return QVTPreferences.getOCLEcoreExtensions(); }
	public String getEditorName() { return "OCL"; }
	public IMappingMetaData getMappingMetaData() { return FullOCLMappingMetaData.INSTANCE; }
	public String getNatureId() { return NATURE_ID; }
	public OCLPlugin getPlugin() { return OCLPlugin.getInstance(); }
	public String getProblemMarkerId() { return PROBLEM_MARKER_ID; }
	public String getTextExtension() { return QVTPreferences.getOCLTextExtension(); }
	public String[] getTextExtensions() { return QVTPreferences.getOCLTextExtensions(); }
}
