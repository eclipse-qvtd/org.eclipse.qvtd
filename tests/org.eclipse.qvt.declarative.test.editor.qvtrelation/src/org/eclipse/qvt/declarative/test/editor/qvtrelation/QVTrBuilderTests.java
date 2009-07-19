package org.eclipse.qvt.declarative.test.editor.qvtrelation;

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.qvt.declarative.editor.qvtrelation.ui.QVTrCreationFactory;
import org.eclipse.qvt.declarative.editor.ui.builder.CommonBuilder;
import org.eclipse.qvt.declarative.editor.ui.builder.CommonNature;

public class QVTrBuilderTests extends QVTrEditorTestCase
{
	public void testAddBuildRemoveNature() throws CoreException, ExecutionException, BadLocationException {
		LogListener logListener = new LogListener();
		Platform.addLogListener(logListener);
		QVTrCreationFactory creationFactory = getCreationFactory();
		String natureId = creationFactory.getNatureId();
		IProjectNature oldNature = project.getNature(natureId);
		assertNull("No initial nature", oldNature);
		CommonNature nature = creationFactory.createNature();
		nature.addToProject(project);				// NB this creates another new nature
		IProjectNature newNature = project.getNature(natureId);
		assertEquals("Installed nature", nature.getClass(), newNature.getClass());
		IFile file = createFile(getName() + "." + creationFactory.getTextExtension());
		setFileContents(file, MINIMAL_TEST_FILE_CONTENTS);
		BuilderListener builderListener = new BuilderListener();
		CommonBuilder.addBuilderListener(creationFactory.getBuilderId(), file, builderListener);
		BuilderSession session = builderListener.createSession(file);
		List<IStatus> statuses = waitForBuilder(session, logListener);
		if (statuses.size() > 0) {
			StringBuffer s = null;
			for (IStatus status : statuses) {
				if (status.getSeverity() == IStatus.INFO)
					continue;
				if (s == null)
					s = new StringBuffer();
				s.append("\n");
				s.append(status.toString());
			}
			if (s != null)
				fail("Failed to create '" + file.getFullPath() + "'" + s.toString());
		}
		assertTrue("Builder started for '" + file.getFullPath() + "'", session.hasStarted());
		assertTrue("Builder ended for '" + file.getFullPath() + "'", session.hasStarted());
		IMarker[] markers = file.findMarkers(null, true, IResource.DEPTH_INFINITE);
		assertEquals("Markers on '" + file.getFullPath() + "'", 0, markers.length);
		markers = project.findMarkers(null, true, IResource.DEPTH_INFINITE);
		assertEquals("Markers on '" + project.getFullPath() + "'", 0, markers.length);
		nature.removeFromProject(project);
		IProjectNature removedNature = project.getNature(natureId);
		assertNull("No removed nature", removedNature);
	}
}
