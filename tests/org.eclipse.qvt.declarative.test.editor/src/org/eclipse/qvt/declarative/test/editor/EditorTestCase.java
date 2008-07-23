package org.eclipse.qvt.declarative.test.editor;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.qvt.declarative.editor.ui.paged.PagedEditor;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Synchronizer;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

public abstract class EditorTestCase extends TestCase
{
	protected Synchronizer dummySynchronizer;
	protected IProgressMonitor monitor = new NullProgressMonitor();
	protected IProject project;
	protected IWorkbenchPage workbenchPage;
	protected List<IFile> files = new ArrayList<IFile>();

	protected IFile createFile(String fileName, String contents) throws CoreException {
		IFile file = project.getFile(fileName);
		InputStream source = new ByteArrayInputStream(contents.getBytes());
		file.create(source, true, monitor);
		files.add(file);
		return file;
	}

	protected IFile createFile(IFolder folder, String fileName, String contents) throws CoreException {
		IFile file = folder.getFile(fileName);
		InputStream source = new ByteArrayInputStream(contents.getBytes());
		file.create(source, true, monitor);
		files.add(file);
		return file;
	}

	protected IFolder createFolder(String fileName) throws CoreException {
		IFolder folder = project.getFolder(fileName);
		folder.create(true, true, monitor);
		return folder;
	}

	protected abstract String getEditorId();
	
	protected String getProjectId() {
		return getClass().getPackage().getName();
	}

	protected void runAsyncMessages(Display display, final String message) {
		if (PagedEditor.traceEditorShowDirty.isActive())
			PagedEditor.traceEditorShowDirty.println("Waiting for " + message);		
		Synchronizer savedSynchronizer = display.getSynchronizer();
		display.setSynchronizer(dummySynchronizer);
		display.setSynchronizer(savedSynchronizer);
		if (PagedEditor.traceEditorShowDirty.isActive())
			PagedEditor.traceEditorShowDirty.println("Waited for " + message);		
	}
			
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		project = workspace.getRoot().getProject(getProjectId());
		if (!project.exists())
			project.create(monitor);
		if (!project.isOpen())
			project.open(monitor);
		IWorkbench workbench = PlatformUI.getWorkbench();
		IWorkbenchWindow workbenchWindow = workbench.getActiveWorkbenchWindow();
		workbenchPage = workbenchWindow.getActivePage();
		dummySynchronizer = new Synchronizer(Display.getDefault());
	}

	@Override
	protected void tearDown() throws Exception {
		Exception ex = null;
		for (IFile file : files) {
			try {
				file.delete(true, false, monitor);
			} catch (CoreException e) {
				if (ex == null)
					ex = e;
			}
		}
		if (ex != null)
			throw ex;
		super.tearDown();
	}
}
