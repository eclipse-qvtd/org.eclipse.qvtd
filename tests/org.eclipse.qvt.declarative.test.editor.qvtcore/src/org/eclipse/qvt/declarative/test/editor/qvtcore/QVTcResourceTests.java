package org.eclipse.qvt.declarative.test.editor.qvtcore;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.text.AbstractDocument;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.qvt.declarative.editor.qvtcore.ui.QVTcCreationFactory;
import org.eclipse.qvt.declarative.editor.qvtcore.ui.QVTcEditor;
import org.eclipse.qvt.declarative.editor.ui.text.ITextEditorWithUndoContext;
import org.eclipse.qvt.declarative.editor.ui.text.TextPageManager;
import org.eclipse.qvt.declarative.test.editor.EditorTestCase;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.texteditor.IDocumentProvider;

public class QVTcResourceTests extends EditorTestCase
{
	/**
	 * A ButtonPress may be queued by Display.asyncExec just before
	 * triggering the activation of a Dialog, so that a button
	 * with designated label is pressed on the next opportunity.
	 * The required button must be a sibling of the default dialog button.
	 */
	public static final class ButtonPress implements Runnable
	{
		private final Display display;
		private final String buttonLabel;

		private ButtonPress(Display display, String buttonLabel) {
			this.display = display;
			this.buttonLabel = buttonLabel;
		}

		public void run() {
			Shell[] shells = display.getShells();
			for (int i = shells.length; --i >= 0; ) {
				Shell shell = shells[i];
				Button defaultButton = shell.getDefaultButton();
				Composite buttonParent = defaultButton.getParent();
				for (Control buttonSibling : buttonParent.getChildren()) {
					if (buttonSibling instanceof Button) {
						Button button = (Button) buttonSibling;
						if (buttonLabel.equals(button.getText())) {
							Event e = new Event();
							e.type = SWT.Selection;
							e.widget = button;
							for (Listener listener : button.getListeners(SWT.Selection))
								listener.handleEvent(e);
							return;
						}
					}
				}
			}
		}
	}

	private IFile createTestFile() throws CoreException {
		final String contents = "transformation tx0 {}\n";
		final String testFileName = getName() + " .qvtc";
		IFile file = createFile(testFileName, contents);
		return file;
	}

	@Override
	protected String getEditorId() {
		return QVTcCreationFactory.EDITOR_ID;
	}

	public void testOpenAndDelete() throws CoreException, ExecutionException, BadLocationException {
		IFile file = createTestFile();
		IFileEditorInput editorInput = new FileEditorInput(file);
		QVTcEditor editor = (QVTcEditor) workbenchPage.openEditor(editorInput, getEditorId());
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
		IFile file = createTestFile();
		IFileEditorInput editorInput = new FileEditorInput(file);
		QVTcEditor editor = (QVTcEditor) workbenchPage.openEditor(editorInput, getEditorId());
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
		IFile file = createTestFile();
		IFileEditorInput editorInput = new FileEditorInput(file);
		QVTcEditor editor = (QVTcEditor) workbenchPage.openEditor(editorInput, getEditorId());
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
		IFile file = createTestFile();
		IFileEditorInput editorInput = new FileEditorInput(file);
		QVTcEditor editor = (QVTcEditor) workbenchPage.openEditor(editorInput, getEditorId());
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
		IFile file = createTestFile();
		IFileEditorInput editorInput = new FileEditorInput(file);
		QVTcEditor editor = (QVTcEditor) workbenchPage.openEditor(editorInput, getEditorId());
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
