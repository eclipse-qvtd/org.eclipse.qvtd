package org.eclipse.qvt.declarative.test.editor.qvtrelation;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.text.AbstractDocument;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.qvt.declarative.editor.qvtrelation.ui.QVTrEditor;
import org.eclipse.qvt.declarative.editor.ui.ICreationFactory;
import org.eclipse.qvt.declarative.editor.ui.builder.CommonBuilder;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.texteditor.IDocumentProvider;

public class QVTrEditorTests extends QVTrEditorTestCase
{
//	private static final String EXPECTED_ERROR = "'import' or 'transformation' expected instead of \"trans formation tx0(ecore:Ecore) {}\"";
//	private static final String EXPECTED_ERROR2 = "'import' or 'transformation' expected instead of \"trans  formation tx0(ecore:Ecore) {}\"";

	private static String expectedError(String prefix, String contents) {
		return prefix + " 'import' or 'transformation' expected instead of \"" + contents.replaceAll("\\n", "") + "\"";
	}
	
	private static class BuilderWatcher implements CommonBuilder.BuilderListener
	{
//		private boolean begun = false;
		private boolean ended = false;
		
		public void beginBuild(IFile file) {
//			begun = true;		
		}

		public void endBuild(IFile file) {
			ended = true;		
		}

//		public boolean hasBegun() {
//			return begun;
//		}

		public boolean hasEnded() {
			return ended;
		}
	}

//	private static final String QVT_RELATION_TEXT = "QVT relation Text";

	public void addNatureAndWaitForBuild(ICreationFactory creationFactory, IFile file) {
		BuilderWatcher watcher = new BuilderWatcher();
		CommonBuilder.addBuilderListener(creationFactory.getBuilderId(), file, watcher);
		creationFactory.createNature().addToProject(project);
		for (int i = 0; i < 50; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
			if (watcher.hasEnded())
				break;
		}
		assertTrue("Builder hasEnded post-build", watcher.hasEnded());
	}

	public void testDoAndUndo() throws CoreException, ExecutionException, BadLocationException {
		final String contents1 = "trans";
		final String contents2 = " ";
		final String contents3 = "formation tx0(ecore:Ecore) {}\n";
		final String contents = contents1 + contents3;
		final String testFileName = getName() + ".qvtr";
//		final String pageTitle = QVT_RELATION_TEXT;
		createModelRegistryFile();
		IFile file = createFile(testFileName, contents);
		IFileEditorInput editorInput = new FileEditorInput(file);
		QVTrEditor editor = (QVTrEditor) workbenchPage.openEditor(editorInput, getEditorId());
		try {
			ICreationFactory creationFactory = editor.getCreationFactory();		
			String markerId = creationFactory.getProblemMarkerId();	
			IDocumentProvider documentProvider = editor.getDocumentProvider();
			AbstractDocument document = (AbstractDocument) documentProvider.getDocument(editorInput);
					
			assertEquals("Original contents", contents, document.get());
			assertEquals("Original isDirty", false, editor.isDirty());
			assertEquals("Original title", testFileName, editor.getTitle());
			IMarker[] markers = file.findMarkers(markerId, true, IResource.DEPTH_INFINITE);
			assertEquals("Original markers", 0, markers.length);
			Annotation[] annotations = editor.getAnnotations();
			assertEquals("Original annotations", 0, annotations.length);
	
			document.replace(contents1.length(), 0, contents2);
			runAsyncMessages(editor.getDisplay(), "Typing");
			
			String editedContents = contents1 + contents2 + contents3;
			assertEquals("Edited contents", editedContents, document.get());
			assertEquals("Edited isDirty", true, editor.isDirty());
//			assertEquals("Edited title", "*" + testFileName, editor.getTitle());
			editor.refresh();
			markers = file.findMarkers(markerId, true, IResource.DEPTH_INFINITE);
			assertEquals("Edited markers", 0, markers.length);
			annotations = editor.getAnnotations();
			assertEquals("Edited annotations", 1, annotations.length);
			assertEquals("Edited annotation", expectedError("ERROR:", editedContents), annotations[0].getText());
			
			editor.getOperationHistory().undo(editor.getUndoContext(), monitor, null);
			runAsyncMessages(editor.getDisplay(), "Undo");
	
			assertEquals("Restored contents", contents, document.get());
			assertEquals("Restored isDirty", false, editor.isDirty());
			assertEquals("Restored title", testFileName, editor.getTitle());
			editor.refresh();
			markers = file.findMarkers(markerId, true, IResource.DEPTH_INFINITE);
			assertEquals("Restored markers", 0, markers.length);
			annotations = editor.getAnnotations();
			assertEquals("Restored annotations", 0, annotations.length);
		} finally {
			assertTrue("Close Editor", workbenchPage.closeEditor(editor, true));
		}
	}

	//	Second edit continues first, requiring TextEditor's to DocumentUndoManager.commit
	// Bugzilla 224324 part 1.
	public void testEditSaveBuildAndEdit() throws CoreException, ExecutionException, BadLocationException {
		final String contents1 = "trans";
		final String contents2 = " ";
		final String contents3 = "formation tx0(ecore:Ecore) {}\n";
		final String contents = contents1 + contents3;
		final String testFileName = getName() + ".qvtr";
		createModelRegistryFile();
		IFile file = createFile(testFileName, contents);
		IFileEditorInput editorInput = new FileEditorInput(file);
		QVTrEditor editor = (QVTrEditor) workbenchPage.openEditor(editorInput, getEditorId());
		try {
			ICreationFactory creationFactory = editor.getCreationFactory();		
			String markerId = creationFactory.getProblemMarkerId();	
			IDocumentProvider documentProvider = editor.getDocumentProvider();
			AbstractDocument document = (AbstractDocument) documentProvider.getDocument(editorInput);
					
			assertEquals("Original contents", contents, document.get());
			assertEquals("Original isDirty", false, editor.isDirty());
			IMarker[] markers = file.findMarkers(markerId, true, IResource.DEPTH_INFINITE);
			assertEquals("Original markers", 0, markers.length);
			Annotation[] annotations = editor.getAnnotations();
			assertEquals("Original annotations", 0, annotations.length);
		
			document.replace(contents1.length(), 0, contents2);
			runAsyncMessages(editor.getDisplay(), "Typing");
			markers = file.findMarkers(markerId, true, IResource.DEPTH_INFINITE);
			
			String editedContents = contents1 + contents2 + contents3;
			assertEquals("Edited contents", editedContents, document.get());
			assertEquals("Edited isDirty", true, editor.isDirty());
			editor.refresh();
			markers = file.findMarkers(markerId, true, IResource.DEPTH_INFINITE);
			assertEquals("Edited markers", 0, markers.length);
			annotations = editor.getAnnotations();
			assertEquals("Edited annotations", 1, annotations.length);
			assertEquals("Edited annotation", expectedError("ERROR:", editedContents), annotations[0].getText());
				
			editor.doSave(null);
	//		editor.getOperationHistory().undo(editor.getUndoContext(), monitor, null);
			runAsyncMessages(editor.getDisplay(), "Save");
	
			assertEquals("Saved contents", editedContents, document.get());
			assertEquals("Saved isDirty", false, editor.isDirty());
			editor.refresh();
			markers = file.findMarkers(markerId, true, IResource.DEPTH_INFINITE);
			assertEquals("Saved markers", 0, markers.length);
			annotations = editor.getAnnotations();
			assertEquals("Saved annotations", 1, annotations.length);
			assertEquals("Saved annotation", expectedError("ERROR:", editedContents), annotations[0].getText());

			String newName = getName() + ".eqvtrelation";
			IFile newFile = file.getParent().getFile(new Path(newName));
			assertFalse("Generated file exists pre-build", newFile.exists());
			addNatureAndWaitForBuild(creationFactory, file);
			
			markers = file.findMarkers(markerId, true, IResource.DEPTH_INFINITE);
			assertEquals("Built markers", 1, markers.length);
			assertEquals("Built marker", expectedError("Parser:", editedContents), markers[0].getAttribute(IMarker.MESSAGE, ""));
			
			document.replace(contents1.length() + contents2.length(), 0, contents2);
			runAsyncMessages(editor.getDisplay(), "Typing");
			markers = file.findMarkers(markerId, true, IResource.DEPTH_INFINITE);
			
			String editedContents2 = contents1 + contents2 + contents2 + contents3;
			assertEquals("Edited2 contents", editedContents2, document.get());
			assertEquals("Edited2 isDirty", true, editor.isDirty());
			editor.refresh();
			markers = file.findMarkers(markerId, true, IResource.DEPTH_INFINITE);
			assertEquals("Edited2 markers", 1, markers.length);
			assertEquals("Edited2 marker", expectedError("Parser:", editedContents), markers[0].getAttribute(IMarker.MESSAGE, ""));
			annotations = editor.getAnnotations();
			assertEquals("Edited2 annotations", 1, annotations.length);
			assertEquals("Edited2 annotation", expectedError("ERROR:", editedContents2), annotations[0].getText());
			
			editor.getOperationHistory().undo(editor.getUndoContext(), monitor, null);
			runAsyncMessages(editor.getDisplay(), "Undo");
	
			assertEquals("Restored contents", editedContents, document.get());
			assertEquals("Restored isDirty", false, editor.isDirty());
			editor.refresh();
			markers = file.findMarkers(markerId, true, IResource.DEPTH_INFINITE);
			assertEquals("Restored markers", 1, markers.length);
			assertEquals("Restored marker", expectedError("Parser:", editedContents), markers[0].getAttribute(IMarker.MESSAGE, ""));
			annotations = editor.getAnnotations();
			assertEquals("Restored annotations", 1, annotations.length);
			assertEquals("Restored annotation", expectedError("ERROR:", editedContents), annotations[0].getText());
		} finally {
			assertTrue("Close Editor", workbenchPage.closeEditor(editor, true));
		}
	}
	
	// FIXME Awaiting Bugzilla 237213 guidance
	// Subsequent test is for Bugzilla 231288
	public void nontestEditSaveAndUndo() throws CoreException, ExecutionException, BadLocationException {
		final String contents1 = "trans";
		final String contents2 = " ";
		final String contents3 = "formation tx0(ecore:Ecore) {}\n";
		final String contents = contents1 + contents3;
		final String testFileName = getName() + ".qvtr";
//		final String pageTitle = QVT_RELATION_TEXT;
		createModelRegistryFile();
		IFile file = createFile(testFileName, contents);
		IFileEditorInput editorInput = new FileEditorInput(file);
		QVTrEditor editor = (QVTrEditor) workbenchPage.openEditor(editorInput, getEditorId());
		try {
			ICreationFactory creationFactory = editor.getCreationFactory();		
			String markerId = creationFactory.getProblemMarkerId();	
			
			IDocumentProvider documentProvider = editor.getDocumentProvider();
			AbstractDocument document = (AbstractDocument) documentProvider.getDocument(editorInput);
					
			assertEquals("Original contents", contents, document.get());
			assertEquals("Original isDirty", false, editor.isDirty());
			IMarker[] markers = file.findMarkers(markerId, true, IResource.DEPTH_INFINITE);
			assertEquals("Original markers", 0, markers.length);
			Annotation[] annotations = editor.getAnnotations();
			assertEquals("Original annotations", 0, annotations.length);
			assertEquals("Original annotation", expectedError("ERROR:", contents), annotations[0].getText());
		
			document.replace(contents1.length(), 0, contents2);
			runAsyncMessages(editor.getDisplay(), "Typing");
			
			String editedContents = contents1 + contents2 + contents3;
			assertEquals("Edited contents", editedContents, document.get());
			assertEquals("Edited isDirty", true, editor.isDirty());
			editor.refresh();
			annotations = editor.getAnnotations();
			assertEquals("Edited annotations", 1, annotations.length);
			assertEquals("Edited annotation", expectedError("ERROR:", editedContents), annotations[0].getText());
				
			editor.doSave(null);
	//		editor.getOperationHistory().undo(editor.getUndoContext(), monitor, null);
			runAsyncMessages(editor.getDisplay(), "Save");
	
			assertEquals("Saved contents", editedContents, document.get());
			assertEquals("Saved isDirty", false, editor.isDirty());
			editor.refresh();
			markers = file.findMarkers(markerId, true, IResource.DEPTH_INFINITE);
			assertEquals("Saved markers", 1, markers.length);
			assertEquals("Saved marker", expectedError("Parser:", editedContents), markers[0].getAttribute(IMarker.MESSAGE, ""));
			annotations = editor.getAnnotations();
			assertEquals("Saved annotations", 1, annotations.length);
			assertEquals("Saved annotation", expectedError("ERROR:", editedContents), annotations[0].getText());
			
			editor.getOperationHistory().undo(editor.getUndoContext(), monitor, null);
			runAsyncMessages(editor.getDisplay(), "Undo");
	
			assertEquals("Restored contents", contents, document.get());
			assertEquals("Restored isDirty", false, editor.isDirty());
			editor.refresh();
			markers = file.findMarkers(markerId, true, IResource.DEPTH_INFINITE);
			assertEquals("Restored markers", 1, markers.length);
			assertEquals("Restored marker", expectedError("ERROR:", contents), markers[0].getAttribute(IMarker.MESSAGE, ""));
			annotations = editor.getAnnotations();
			assertEquals("Restored annotations", 1, annotations.length);
			assertEquals("Restored annotation", expectedError("ERROR:", contents), annotations[0].getText());
		} finally {
			assertTrue("Close Editor", workbenchPage.closeEditor(editor, true));
		}
	}

	public void testErrorAndNoError() throws CoreException, ExecutionException, BadLocationException {
		final String contents1 = "trans";
		final String contents2 = " ";
		final String contents3 = "formation tx0(ecore:Ecore) {}\n";
		final String contents = contents1 + contents2 + contents3;
		final String testFileName = getName() + ".qvtr";
		createModelRegistryFile();
		IFile file = createFile(testFileName, contents);
		IFileEditorInput editorInput = new FileEditorInput(file);
		QVTrEditor editor = (QVTrEditor) workbenchPage.openEditor(editorInput, getEditorId());
		try {
			IDocumentProvider documentProvider = editor.getDocumentProvider();
			AbstractDocument document = (AbstractDocument) documentProvider.getDocument(editorInput);
					
			assertEquals("Original contents", contents, document.get());
			assertEquals("Original isDirty", false, editor.isDirty());
			Annotation[] annotations = editor.getAnnotations();
			assertEquals("Original annotations", 1, annotations.length);
			assertEquals("Original annotation", expectedError("ERROR:", contents), annotations[0].getText());
		
			document.replace(contents1.length(), contents2.length(), "");
			runAsyncMessages(editor.getDisplay(), "Typing");
			
			assertEquals("Edited contents", contents1 + contents3, document.get());
			assertEquals("Edited isDirty", true, editor.isDirty());
			editor.refresh();
			annotations = editor.getAnnotations();
			assertEquals("Edited annotations", 0, annotations.length);
			
			editor.getOperationHistory().undo(editor.getUndoContext(), monitor, null);
			runAsyncMessages(editor.getDisplay(), "Undo");
	
			assertEquals("Restored contents", contents, document.get());
			assertEquals("Restored isDirty", false, editor.isDirty());
			editor.refresh();
			annotations = editor.getAnnotations();
			assertEquals("Restored annotations", 1, annotations.length);
			assertEquals("Restored annotation", expectedError("ERROR:", contents), annotations[0].getText());
		} finally {
			assertTrue("Close Editor", workbenchPage.closeEditor(editor, true));
		}
	}

	public void testTwoEditorsDoAndUndo() throws CoreException, ExecutionException, BadLocationException {
		final String contents1A = "trans";
		final String contents2A = " ";
		final String contents3A = "formation txA(ecore:Ecore) {}\n";
		final String contents1B = "tr";
		final String contents2B = " ";
		final String contents3B = "ansformation txB(ecore:Ecore) {}\n";
		final String contentsA = contents1A + contents3A;
		final String contentsB = contents1B + contents3B;
		final String testFileNameA = getName() + ".A.qvtr";
		final String testFileNameB = getName() + ".B.qvtr";
		createModelRegistryFile();
		IFile fileA = createFile(testFileNameA, contentsA);
		IFile fileB = createFile(testFileNameB, contentsB);
		IFileEditorInput editorInputA = new FileEditorInput(fileA);
		IFileEditorInput editorInputB = new FileEditorInput(fileB);
		QVTrEditor editorA = (QVTrEditor) workbenchPage.openEditor(editorInputA, getEditorId());
		QVTrEditor editorB = (QVTrEditor) workbenchPage.openEditor(editorInputB, getEditorId());
		try {
			ICreationFactory creationFactory = editorA.getCreationFactory();		
			String markerId = creationFactory.getProblemMarkerId();	
			
			IDocumentProvider documentProviderA = editorA.getDocumentProvider();
			IDocumentProvider documentProviderB = editorB.getDocumentProvider();
			AbstractDocument documentA = (AbstractDocument) documentProviderA.getDocument(editorInputA);
			AbstractDocument documentB = (AbstractDocument) documentProviderB.getDocument(editorInputB);
			IMarker[] markersA = fileA.findMarkers(markerId, true, IResource.DEPTH_INFINITE);
			IMarker[] markersB = fileB.findMarkers(markerId, true, IResource.DEPTH_INFINITE);
					
			assertEquals("Original contents A", contentsA, documentA.get());
			assertEquals("Original isDirty A", false, editorA.isDirty());
			assertEquals("Original markers A", 0, markersA.length);
			assertEquals("Original contents B", contentsB, documentB.get());
			assertEquals("Original isDirty B", false, editorB.isDirty());
			assertEquals("Original markers B", 0, markersB.length);
			Annotation[] annotationsA = editorA.getAnnotations();
			assertEquals("Original annotations A", 0, annotationsA.length);
			Annotation[] annotationsB = editorB.getAnnotations();
			assertEquals("Original annotations B", 0, annotationsB.length);
	
			documentA.replace(contents1A.length(), 0, contents2A);
			runAsyncMessages(editorA.getDisplay(), "Typing A");
			
			String editedContentsA = contents1A + contents2A + contents3A;
			assertEquals("Edited contents A", editedContentsA, documentA.get());
			assertEquals("Edited isDirty A", true, editorA.isDirty());
			assertEquals("Unedited contents B", contentsB, documentB.get());
			assertEquals("Unedited isDirty B", false, editorB.isDirty());
			editorA.refresh();
			editorB.refresh();
			annotationsA = editorA.getAnnotations();
			assertEquals("Edited annotations A", 1, annotationsA.length);
			assertEquals("Edited annotation A", expectedError("ERROR:", editedContentsA), annotationsA[0].getText());
			annotationsB = editorB.getAnnotations();
			assertEquals("Unedited annotations B", 0, annotationsB.length);
	
			documentB.replace(contents1B.length(), 0, contents2B);
			runAsyncMessages(editorB.getDisplay(), "Typing B");
			
			assertEquals("Edited contents A", editedContentsA, documentA.get());
			assertEquals("Edited isDirty A", true, editorA.isDirty());
			String editedContentsB = contents1B + contents2B + contents3B;
			assertEquals("Edited contents B", editedContentsB, documentB.get());
			assertEquals("Edited isDirty B", true, editorB.isDirty());
			editorA.refresh();
			editorB.refresh();
			annotationsA = editorA.getAnnotations();
			assertEquals("Edited annotations A", 1, annotationsA.length);
			assertEquals("Edited annotation A", expectedError("ERROR:", editedContentsA), annotationsA[0].getText());
			annotationsB = editorB.getAnnotations();
			assertEquals("Edited annotations B", 1, annotationsB.length);
			assertEquals("Edited annotation B", expectedError("ERROR:", editedContentsB), annotationsB[0].getText());
			
			editorA.getOperationHistory().undo(editorA.getUndoContext(), monitor, null);
			runAsyncMessages(editorA.getDisplay(), "Undo A");
			
			assertEquals("Restored contents A", contentsA, documentA.get());
			assertEquals("Restored isDirty A", false, editorA.isDirty());
			assertEquals("Edited contents B", editedContentsB, documentB.get());
			assertEquals("Edited isDirty B", true, editorB.isDirty());
			editorA.refresh();
			editorB.refresh();
			annotationsA = editorA.getAnnotations();
			assertEquals("Restored annotations A", 0, annotationsA.length);
			annotationsB = editorB.getAnnotations();
			assertEquals("Edited annotations B", 1, annotationsB.length);
			assertEquals("Edited annotation B", expectedError("ERROR:", editedContentsB), annotationsB[0].getText());
			
			editorB.getOperationHistory().undo(editorB.getUndoContext(), monitor, null);
			runAsyncMessages(editorB.getDisplay(), "Undo B");
	
			assertEquals("Restored contents A", contentsA, documentA.get());
			assertEquals("Restored isDirty A", false, editorA.isDirty());
			assertEquals("Restored contents B", contentsB, documentB.get());
			assertEquals("Restored isDirty B", false, editorB.isDirty());
			editorA.refresh();
			editorB.refresh();
			annotationsA = editorA.getAnnotations();
			assertEquals("Restored annotations A", 0, annotationsA.length);
			annotationsB = editorB.getAnnotations();
			assertEquals("Restored annotations B", 0, annotationsB.length);
		} finally {
			assertTrue("Close Editor A", workbenchPage.closeEditor(editorA, true));
			assertTrue("Close Editor B", workbenchPage.closeEditor(editorB, true));
		}
	}
}
