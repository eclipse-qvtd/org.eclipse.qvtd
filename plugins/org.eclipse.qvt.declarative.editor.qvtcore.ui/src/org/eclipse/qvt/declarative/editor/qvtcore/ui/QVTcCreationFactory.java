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
 * $Id: QVTcCreationFactory.java,v 1.11 2010/07/10 09:35:44 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.qvtcore.ui;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.ocl.examples.modelregistry.environment.FileHandle;
import org.eclipse.ocl.lpg.ProblemHandler;
import org.eclipse.qvt.declarative.ecore.mappings.IMappingMetaData;
import org.eclipse.qvt.declarative.editor.qvtcore.ui.imp.QVTcParseController;
import org.eclipse.qvt.declarative.editor.qvtcore.ui.imp.QVTcSourcePositionLocator;
import org.eclipse.qvt.declarative.editor.qvtcore.ui.imp.QVTcTreeModelBuilder;
import org.eclipse.qvt.declarative.editor.ui.IPageManager;
import org.eclipse.qvt.declarative.editor.ui.builder.CommonNature;
import org.eclipse.qvt.declarative.editor.ui.common.AbstractCreationFactory;
import org.eclipse.qvt.declarative.editor.ui.imp.CommonTreeModelBuilder;
import org.eclipse.qvt.declarative.emof.QVTCore.facade.QVTCoreFacade;
import org.eclipse.qvt.declarative.parser.environment.ICSTRootEnvironment;
import org.eclipse.qvt.declarative.parser.qvtcore.environment.QVTcFileEnvironment;
import org.eclipse.qvt.declarative.parser.qvtcore.unparser.QVTcUnparser;
import org.eclipse.qvt.declarative.parser.ui.preferences.QVTPreferences;

public class QVTcCreationFactory extends AbstractCreationFactory
{
	public static QVTcCreationFactory INSTANCE = new QVTcCreationFactory();
	public static final String BUILDER_ID = QVTcBuilder.class.getName();
	public static final String EDITOR_ID = QVTcEditor.class.getName();
	public static final String MULTI_EDITOR_ID = QVTcMultiEditor.class.getName();
	public static final String NATURE_ID = QVTcNature.class.getName();
	public static final String PROBLEM_MARKER_ID = QVTcMarkerProblemHandler.class.getPackage().getName() + ".qvtcProblem";

	protected QVTcCreationFactory() {}
	
	public ProblemHandler createProblemHandler(IFile file) {
		return new QVTcMarkerProblemHandler(file);
	}
	
	public QVTcFileEnvironment createFileEnvironment(FileHandle fileHandle, ResourceSet resourceSet, URI astURI) {
		XMIResource astResource = (XMIResource) resourceSet.createResource(astURI, getMappingMetaData().getEcoreContentTypeIdentifier());
		return new QVTcFileEnvironment(fileHandle, resourceSet, astResource);
	}
	
	public CommonNature createNature() {
		return new QVTcNature();
	}
	
	public QVTcParseController createParseController() {
		return new QVTcParseController();
	}

	public QVTcSourcePositionLocator createSourcePositionLocator(ICSTRootEnvironment environment) {
		return new QVTcSourcePositionLocator(environment);
	}

	public QVTcTextEditor createTextEditor(IPageManager editorPageManager) {
		return new QVTcTextEditor(editorPageManager);
	}

	@Override
	public CommonTreeModelBuilder createTreeModelBuilder(boolean showAST) {
		return new QVTcTreeModelBuilder(showAST);
	}

	public QVTcUnparser createUnparser(Resource resource) {
		return new QVTcUnparser(resource);
	}

	public String getBuilderId() { return BUILDER_ID; }
	public String[] getEMOFExtensions() { return QVTPreferences.getCoreEMOFExtensions(); }
	public String[] getEcoreExtensions() { return QVTPreferences.getCoreEcoreExtensions(); }
	public String getEditorName() { return "QVT core"; }
	public IMappingMetaData getMappingMetaData() { return QVTCoreFacade.MAPPING_META_DATA; }	
	public String getNatureId() { return NATURE_ID; }
	public QVTcPlugin getPlugin() { return QVTcPlugin.getInstance(); }
	public String getProblemMarkerId() { return PROBLEM_MARKER_ID; }
	public String getTextExtension() { return QVTPreferences.getCoreTextExtension(); }
	public String[] getTextExtensions() { return QVTPreferences.getCoreTextExtensions(); }
}
