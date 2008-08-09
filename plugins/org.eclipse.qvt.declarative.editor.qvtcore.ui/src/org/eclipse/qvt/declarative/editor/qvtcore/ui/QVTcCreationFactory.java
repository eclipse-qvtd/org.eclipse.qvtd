/**
 * <copyright>
 * 
 * Copyright (c) 2007,2008 E.D.Willink and others.
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
 * $Id: QVTcCreationFactory.java,v 1.2 2008/08/09 17:56:11 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.qvtcore.ui;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ocl.lpg.ProblemHandler;
import org.eclipse.qvt.declarative.ecore.mappings.IMappingMetaData;
import org.eclipse.qvt.declarative.editor.ui.IPageManager;
import org.eclipse.qvt.declarative.editor.ui.common.AbstractCreationFactory;
import org.eclipse.qvt.declarative.emof.QVTCore.facade.QVTCoreFacade;
import org.eclipse.qvt.declarative.modelregistry.environment.AbstractFileHandle;
import org.eclipse.qvt.declarative.parser.qvtcore.environment.QVTcTopLevelEnvironment;
import org.eclipse.qvt.declarative.parser.qvtcore.unparser.QVTcUnparser;
import org.eclipse.qvt.declarative.parser.ui.preferences.QVTPreferences;

public class QVTcCreationFactory extends AbstractCreationFactory
{
	public static QVTcCreationFactory INSTANCE = new QVTcCreationFactory();
	public static final String BUILDER_ID = QVTcBuilder.class.getName();
	public static final String EDITOR_ID = QVTcEditor.class.getName();
	public static final String NATURE_ID = QVTcNature.class.getName();
	public static final String PROBLEM_MARKER_ID = QVTcMarkerProblemHandler.class.getPackage().getName() + ".qvtcProblem";

	protected QVTcCreationFactory() {}
	
	public ProblemHandler createProblemHandler(IFile file) {
		return new QVTcMarkerProblemHandler(file);
	}
	
	public QVTcTopLevelEnvironment createFileEnvironment(AbstractFileHandle fileHandle, ResourceSet resourceSet) {
		return new QVTcTopLevelEnvironment(fileHandle, resourceSet);
	}

	public QVTcTextEditor createTextEditor(IPageManager editorPageManager) {
		return new QVTcTextEditor(editorPageManager);
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
	public String getProblemMarkerId() { return PROBLEM_MARKER_ID; }
	public String getTextExtension() { return QVTPreferences.getCoreTextExtension(); }
	public String[] getTextExtensions() { return QVTPreferences.getCoreTextExtensions(); }
}
