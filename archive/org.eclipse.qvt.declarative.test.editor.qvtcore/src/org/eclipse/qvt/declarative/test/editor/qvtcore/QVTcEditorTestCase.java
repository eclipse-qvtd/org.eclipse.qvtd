package org.eclipse.qvt.declarative.test.editor.qvtcore;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.ocl.examples.modelregistry.environment.ProjectHandle;
import org.eclipse.qvt.declarative.editor.qvtcore.ui.QVTcCreationFactory;
import org.eclipse.qvt.declarative.editor.ui.ICreationFactory;
import org.eclipse.qvt.declarative.test.editor.EditorTestCase;

public class QVTcEditorTestCase extends EditorTestCase
{
	protected IFile createModelRegistryFile() throws CoreException {
		final String contents = 
			"<?xml version='1.0' encoding='ASCII'?>\n" +
			"<mreg:ModelRegistrySettings xmi:version='2.0' xmlns:xmi='http://www.omg.org/XMI' xmlns:mreg='http://www.eclipse.org/gmt/umlx/2007/ModelRegistry'>\n" +
			"  <resource name='.'>\n" +
			"    <entry accessor='Ecore' kind='Model Name' uri='platform:/plugin/org.eclipse.emf.ecore/model/Ecore.ecore'/>\n" +
			"  </resource>\n" +
			"</mreg:ModelRegistrySettings>\n";
		final String testFileName = ProjectHandle.DEFAULT_MODEL_REGISTRY_PATH;
		IFile file = createFile(testFileName, contents);
		return file;
	}

	protected IFile createMinimalTestFile() throws CoreException {
		final String contents = "transformation tx0 {}\n";
		final String testFileName = getName() + " .qvtc";
		IFile file = createFile(testFileName, contents);
		return file;
	}

	@Override
	protected ICreationFactory getCreationFactory() {
		return QVTcCreationFactory.INSTANCE;
	}

	@Override
	protected String getEditorId() {
		return QVTcCreationFactory.EDITOR_ID;
	}

	@Override
	protected String getMultiEditorId() {
		return QVTcCreationFactory.MULTI_EDITOR_ID;
	}
}
