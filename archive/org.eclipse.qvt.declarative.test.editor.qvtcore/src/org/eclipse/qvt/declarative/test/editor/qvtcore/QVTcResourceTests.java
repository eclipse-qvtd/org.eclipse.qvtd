package org.eclipse.qvt.declarative.test.editor.qvtcore;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.text.AbstractDocument;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.qvt.declarative.editor.qvtcore.ui.QVTcMultiEditor;
import org.eclipse.qvt.declarative.editor.ui.text.ITextEditorWithUndoContext;
import org.eclipse.qvt.declarative.editor.ui.text.TextPageManager;
import org.eclipse.qvt.declarative.test.editor.ButtonPress;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.texteditor.IDocumentProvider;

public class QVTcResourceTests extends QVTcEditorTestCase
{
	public void testOpenAndDelete() throws CoreException, ExecutionException, BadLocationException {
		IFile file = createMinimalTestFile();
		IFileEditorInput editorInput = new FileEditorInput(file);
		QVTcMultiEditor editor = (QVTcMultiEditor) workbenchPage.openEditor(editorInput, getMultiEditorId());
		try {
			assertNotNull("Editor is open", workbenchPage.findEditor(editorInput));
			file.delete(true, monitor);
			runAsyncMessages(editor.getDisplay(), "Delete File");
			assertTrue("File does not exist", !file.exists());
			assertNull("Editor is closed", workbenchPage.findEditor(editorInput));
		} finally {
			workbenchPage.closeEditor(editor, false);
		}
	}

	public void testOpenAndRename() throws CoreException, ExecutionException, BadLocationException {
		IFile file = createMinimalTestFile();
		IFileEditorInput editorInput = new FileEditorInput(file);
		QVTcMultiEditor editor = (QVTcMultiEditor) workbenchPage.openEditor(editorInput, getMultiEditorId());
		try {
			assertNotNull("Editor is open", workbenchPage.findEditor(editorInput));
			file.move(file.getFullPath().addFileExtension(".rename"), true, monitor);
			runAsyncMessages(editor.getDisplay(), "Move File");
			assertTrue("File does not exist", !file.exists());
			assertNull("Editor is closed", workbenchPage.findEditor(editorInput));
		} finally {
			workbenchPage.closeEditor(editor, false);
		}
	}

	public void testOpenEditAndDeleteAndKeep() throws CoreException, ExecutionException, BadLocationException {
		IFile file = createMinimalTestFile();
		IFileEditorInput editorInput = new FileEditorInput(file);
		QVTcMultiEditor editor = (QVTcMultiEditor) workbenchPage.openEditor(editorInput, getMultiEditorId());
		try {
			final Display display = editor.getDisplay();
			TextPageManager textPageManager = (TextPageManager) editor.getActivePageManager();
			assertEquals("Page managers", 4, editor.getPageManagers().size());
			
			ITextEditorWithUndoContext textEditor = textPageManager.getEditor();
			IDocumentProvider documentProvider = textEditor.getDocumentProvider();
			AbstractDocument document = (AbstractDocument) documentProvider.getDocument(editorInput);
			document.replace(0, 0, " ");
			runAsyncMessages(display, "Typing");
			
			assertTrue("Edited isDirty", editor.isDirty());
			assertTrue("Edited isDirtyPage", editor.isDirtyPage());
			textPageManager.refresh();
	
			file.delete(true, monitor);
			runAsyncMessages(display, "Delete File");
			assertNotNull("Editor is still open", workbenchPage.findEditor(editorInput));
			assertTrue("File does not exist", !file.exists());
			display.asyncExec(new ButtonPress(display, IDialogConstants.OK_LABEL));
			editor.doSave(monitor);
			runAsyncMessages(editor.getDisplay(), "Save");
			assertFalse("Saved isNotDirty", editor.isDirty());
			assertFalse("Saved isNotDirtyPage", editor.isDirtyPage());
			assertTrue("File exists", file.exists());
			file.delete(true, monitor);
			runAsyncMessages(display, "Delete File");
			assertTrue("File does not exist", !file.exists());
			assertNull("Editor is closed", workbenchPage.findEditor(editorInput));
		} finally {
			workbenchPage.closeEditor(editor, false);
		}
	}

	public void testOpenEditAndDeleteAndLose() throws CoreException, ExecutionException, BadLocationException {
		IFile file = createMinimalTestFile();
		IFileEditorInput editorInput = new FileEditorInput(file);
		QVTcMultiEditor editor = (QVTcMultiEditor) workbenchPage.openEditor(editorInput, getMultiEditorId());
		try {
			final Display display = editor.getDisplay();
			TextPageManager textPageManager = (TextPageManager) editor.getActivePageManager();
			assertEquals("Page managers", 4, editor.getPageManagers().size());
			
			ITextEditorWithUndoContext textEditor = textPageManager.getEditor();
			IDocumentProvider documentProvider = textEditor.getDocumentProvider();
			AbstractDocument document = (AbstractDocument) documentProvider.getDocument(editorInput);
			document.replace(0, 0, " ");
			runAsyncMessages(display, "Typing");
			
			assertTrue("Edited isDirty", editor.isDirty());
			assertTrue("Edited isDirtyPage", editor.isDirtyPage());
			textPageManager.refresh();
	
			file.delete(true, monitor);
			runAsyncMessages(display, "Delete File");
			assertNotNull("Editor is still open", workbenchPage.findEditor(editorInput));
			assertTrue("Deleted isDirty", editor.isDirty());
			assertTrue("Deleted isDirtyPage", editor.isDirtyPage());
			assertTrue("File does not exist", !file.exists());
			display.asyncExec(new ButtonPress(display, IDialogConstants.CANCEL_LABEL));
			editor.doSave(monitor);
			runAsyncMessages(editor.getDisplay(), "NonSave");
			assertTrue("Unsaved isDirty", editor.isDirty());
			assertTrue("Unsaved isDirtyPage", editor.isDirtyPage());
			display.asyncExec(new ButtonPress(display, IDialogConstants.OK_LABEL));
			editor.doSave(monitor);
			runAsyncMessages(editor.getDisplay(), "Save");
			assertFalse("Saved isNotDirty", editor.isDirty());
			assertFalse("Saved isNotDirtyPage", editor.isDirtyPage());
			assertTrue("File exists", file.exists());
			file.delete(true, monitor);
			runAsyncMessages(display, "Delete File");
			assertTrue("File does not exist", !file.exists());
			assertNull("Editor is closed", workbenchPage.findEditor(editorInput));
		} finally {
			workbenchPage.closeEditor(editor, false);
		}
	}

	public void testOpenEditAndRename() throws CoreException, ExecutionException, BadLocationException {
		IFile file = createMinimalTestFile();
		IFileEditorInput editorInput = new FileEditorInput(file);
		QVTcMultiEditor editor = (QVTcMultiEditor) workbenchPage.openEditor(editorInput, getMultiEditorId());
		try {
			final Display display = editor.getDisplay();
			TextPageManager textPageManager = (TextPageManager) editor.getActivePageManager();
			assertEquals("Page managers", 4, editor.getPageManagers().size());
			
			ITextEditorWithUndoContext textEditor = textPageManager.getEditor();
			IDocumentProvider documentProvider = textEditor.getDocumentProvider();
			AbstractDocument document = (AbstractDocument) documentProvider.getDocument(editorInput);
			document.replace(0, 0, " ");
			runAsyncMessages(display, "Typing");
			
			assertTrue("Edited isDirty", editor.isDirty());
			assertTrue("Edited isDirtyPage", editor.isDirtyPage());
			assertEquals("Edited title", file.getName(), editor.getTitle());
			textPageManager.refresh();
	
			file.move(file.getFullPath().addFileExtension("rename"), true, monitor);
			runAsyncMessages(editor.getDisplay(), "Move File");
			String newName = file.getName() + ".rename";
			assertEquals("Moved title", newName, editor.getTitle());
			assertNotNull("Editor is still open", workbenchPage.findEditor(editorInput));
			assertTrue("File does not exist", !file.exists());
			editor.doSave(monitor);
			runAsyncMessages(editor.getDisplay(), "Save");
			assertFalse("Saved isNotDirty", editor.isDirty());
			assertFalse("Saved isNotDirtyPage", editor.isDirtyPage());
			assertFalse("Old file does not exist", file.exists());
			IFile newFile = (IFile) file.getParent().findMember(newName);		
			assertTrue("New file exists", newFile.exists());
			newFile.delete(true, monitor);
			runAsyncMessages(display, "Delete File");
			assertFalse("New file does not exist", newFile.exists());
			assertNotNull("Editor is open", workbenchPage.findEditor(editorInput));
		} finally {
			workbenchPage.closeEditor(editor, false);
		}
	}
}
