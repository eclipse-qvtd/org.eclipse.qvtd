package org.eclipse.qvt.declarative.editor.qvtrelation.ui;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ocl.lpg.ProblemHandler;
import org.eclipse.qvt.declarative.ecore.mappings.IMappingMetaData;
import org.eclipse.qvt.declarative.editor.ui.IPageManager;
import org.eclipse.qvt.declarative.editor.ui.common.AbstractCreationFactory;
import org.eclipse.qvt.declarative.emof.QVTRelation.facade.QVTRelationFacade;
import org.eclipse.qvt.declarative.modelregistry.environment.AbstractFileHandle;
import org.eclipse.qvt.declarative.parser.qvtrelation.environment.QVTrTopLevelEnvironment;
import org.eclipse.qvt.declarative.parser.qvtrelation.unparser.QVTrUnparser;
import org.eclipse.qvt.declarative.parser.ui.preferences.QVTPreferences;

public class QVTrCreationFactory extends AbstractCreationFactory
{
	public static QVTrCreationFactory INSTANCE = new QVTrCreationFactory();
	public static final String BUILDER_ID = QVTrBuilder.class.getName();
	public static final String EDITOR_ID = QVTrEditor.class.getName();
	public static final String NATURE_ID = QVTrNature.class.getName();
	public static final String PROBLEM_MARKER_ID = QVTrMarkerProblemHandler.class.getPackage().getName() + ".qvtrProblem";
	
	protected QVTrCreationFactory() {}
	
	public QVTrTopLevelEnvironment createFileEnvironment(AbstractFileHandle fileHandle, ResourceSet resourceSet) {
		return new QVTrTopLevelEnvironment(fileHandle, resourceSet);
	}

	public ProblemHandler createProblemHandler(IFile file) {
		return new QVTrMarkerProblemHandler(file);
	}

	public QVTrTextEditor createTextEditor(IPageManager editorPageManager) {
		return new QVTrTextEditor(editorPageManager);
	}

	public QVTrUnparser createUnparser(Resource resource) {
		return new QVTrUnparser(resource);
	}

	public String getBuilderId() { return BUILDER_ID; }
	public String[] getEMOFExtensions() { return QVTPreferences.getRelationEMOFExtensions(); }
	public String[] getEcoreExtensions() { return QVTPreferences.getRelationEcoreExtensions(); }
	public String getEditorName() { return "QVT relation"; }
	public IMappingMetaData getMappingMetaData() { return QVTRelationFacade.MAPPING_META_DATA; }
	public String getNatureId() { return NATURE_ID; }
	public String getProblemMarkerId() { return PROBLEM_MARKER_ID; }
	public String getTextExtension() { return QVTPreferences.getRelationTextExtension(); }
	public String[] getTextExtensions() { return QVTPreferences.getRelationTextExtensions(); }
}
