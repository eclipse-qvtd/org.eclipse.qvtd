/**
 * <copyright>
 * 
 * Copyright (c) 2007,2008,2009 E.D.Willink and others.
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
 * $Id: QVTrCreationFactory.java,v 1.11 2010/07/10 09:35:36 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.qvtrelation.ui;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.ocl.examples.modelregistry.environment.FileHandle;
import org.eclipse.ocl.lpg.ProblemHandler;
import org.eclipse.qvt.declarative.ecore.mappings.IMappingMetaData;
import org.eclipse.qvt.declarative.editor.qvtrelation.ui.imp.QVTrParseController;
import org.eclipse.qvt.declarative.editor.qvtrelation.ui.imp.QVTrSourcePositionLocator;
import org.eclipse.qvt.declarative.editor.qvtrelation.ui.imp.QVTrTreeModelBuilder;
import org.eclipse.qvt.declarative.editor.ui.IPageManager;
import org.eclipse.qvt.declarative.editor.ui.builder.CommonNature;
import org.eclipse.qvt.declarative.editor.ui.common.AbstractCreationFactory;
import org.eclipse.qvt.declarative.editor.ui.imp.CommonTreeModelBuilder;
import org.eclipse.qvt.declarative.emof.QVTRelation.facade.QVTRelationFacade;
import org.eclipse.qvt.declarative.parser.environment.ICSTRootEnvironment;
import org.eclipse.qvt.declarative.parser.qvtrelation.environment.QVTrFileEnvironment;
import org.eclipse.qvt.declarative.parser.qvtrelation.unparser.QVTrUnparser;
import org.eclipse.qvt.declarative.parser.ui.preferences.QVTPreferences;

public class QVTrCreationFactory extends AbstractCreationFactory
{
	public static QVTrCreationFactory INSTANCE = new QVTrCreationFactory();
	public static final String BUILDER_ID = QVTrBuilder.class.getName();
	public static final String EDITOR_ID = QVTrEditor.class.getName();
	public static final String MULTI_EDITOR_ID = QVTrMultiEditor.class.getName();
	public static final String NATURE_ID = QVTrNature.class.getName();
	public static final String PROBLEM_MARKER_ID = QVTrMarkerProblemHandler.class.getPackage().getName() + ".qvtrProblem";
	
	protected QVTrCreationFactory() {}
	
	public QVTrFileEnvironment createFileEnvironment(FileHandle fileHandle, ResourceSet resourceSet, URI astURI) {
		XMIResource astResource = (XMIResource) resourceSet.createResource(astURI, getMappingMetaData().getEcoreContentTypeIdentifier());
		return new QVTrFileEnvironment(fileHandle, resourceSet, astResource);
	}
	
	public CommonNature createNature() {
		return new QVTrNature();
	}
	
	public QVTrParseController createParseController() {
		return new QVTrParseController();
	}

	public ProblemHandler createProblemHandler(IFile file) {
		return new QVTrMarkerProblemHandler(file);
	}

	public QVTrSourcePositionLocator createSourcePositionLocator(ICSTRootEnvironment environment) {
		return new QVTrSourcePositionLocator(environment);
	}

	public QVTrTextEditor createTextEditor(IPageManager editorPageManager) {
		return new QVTrTextEditor(editorPageManager);
	}

	@Override
	public CommonTreeModelBuilder createTreeModelBuilder(boolean showAST) {
		return new QVTrTreeModelBuilder(showAST);
	}

	public QVTrUnparser createUnparser(Resource resource) {
		return new QVTrUnparser(resource);
	}

	public String getBuilderId() { return BUILDER_ID; }
	public String[] getEMOFExtensions() { return QVTPreferences.getRelationEMOFExtensions(); }
	public String[] getEcoreExtensions() { return QVTPreferences.getRelationEcoreExtensions(); }
	public String getEditorName() { return "QVT relation"; }
	public QVTrPlugin getPlugin() { return QVTrPlugin.getInstance(); }
	public IMappingMetaData getMappingMetaData() { return QVTRelationFacade.MAPPING_META_DATA; }
	public String getNatureId() { return NATURE_ID; }
	public String getProblemMarkerId() { return PROBLEM_MARKER_ID; }
	public String getTextExtension() { return QVTPreferences.getRelationTextExtension(); }
	public String[] getTextExtensions() { return QVTPreferences.getRelationTextExtensions(); }
}
