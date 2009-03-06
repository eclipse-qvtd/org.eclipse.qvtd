package org.eclipse.qvt.declarative.test.editor.qvtrelation;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.ui.editor.ProblemEditorPart;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.xmi.ClassNotFoundException;
import org.eclipse.emf.ecore.xmi.PackageNotFoundException;
import org.eclipse.jface.text.AbstractDocument;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.qvt.declarative.ecore.adapters.AdapterNotFoundException;
import org.eclipse.qvt.declarative.editor.qvtrelation.ui.QVTrMultiEditor;
import org.eclipse.qvt.declarative.editor.ui.ICreationFactory;
import org.eclipse.qvt.declarative.editor.ui.text.ITextEditorWithUndoContext;
import org.eclipse.qvt.declarative.editor.ui.text.TextPageManager;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.texteditor.IDocumentProvider;

public class QVTrMultiEditorTests extends QVTrEditorTestCase
{
	private static final String QVT_RELATION_TEXT = "QVT relation Text";

	public void testDoAndUndo() throws CoreException, ExecutionException, BadLocationException {
		final String contents1 = "trans";
		final String contents2 = " ";
		final String contents3 = "formation tx0(ecore:Ecore) {}\n";
		final String contents = contents1 + contents3;
		final String testFileName = getName() + ".qvtr";
		final String pageTitle = QVT_RELATION_TEXT;
		createModelRegistryFile();
		IFile file = createFile(testFileName, contents);
		IFileEditorInput editorInput = new FileEditorInput(file);
		QVTrMultiEditor editor = (QVTrMultiEditor) workbenchPage.openEditor(editorInput, getMultiEditorId());
		try {
			ICreationFactory creationFactory = editor.getCreationFactory();		
			String markerId = creationFactory.getProblemMarkerId();	
	
			TextPageManager textPageManager = (TextPageManager) editor.getActivePageManager();
			assertEquals("Page managers", 4, editor.getPageManagers().size());
			
			ITextEditorWithUndoContext textEditor = textPageManager.getEditor();
			IDocumentProvider documentProvider = textEditor.getDocumentProvider();
			AbstractDocument document = (AbstractDocument) documentProvider.getDocument(editorInput);
			IMarker[] markers = file.findMarkers(markerId, true, IResource.DEPTH_INFINITE);
					
			assertEquals("Original contents", contents, document.get());
			assertEquals("Original isDirty", false, editor.isDirty());
			assertEquals("Original isDirtyPage", false, editor.isDirtyPage());
			assertEquals("Original page title", pageTitle, editor.getPageTitle(textPageManager.getEditor()));
			assertEquals("Original markers", 0, markers.length);
	
			document.replace(contents1.length(), 0, contents2);
			runAsyncMessages(editor.getDisplay(), "Typing");
			
			assertEquals("Edited contents", contents1 + contents2 + contents3, document.get());
			assertEquals("Edited isDirty", true, editor.isDirty());
			assertEquals("Edited isDirtyPage", true, editor.isDirtyPage());
			assertEquals("Edited page title", "*" + pageTitle, editor.getPageTitle(textPageManager.getEditor()));
			textPageManager.refresh();
			markers = file.findMarkers(markerId, true, IResource.DEPTH_INFINITE);
			assertEquals("Edited markers", 1, markers.length);
			assertEquals("Edited marker", "Parser: merge tokens \"trans formation\" to form \"transformation\"", markers[0].getAttribute(IMarker.MESSAGE, ""));
			
			editor.getOperationHistory().undo(editor.getUndoContext(), monitor, null);
			runAsyncMessages(editor.getDisplay(), "Undo");
	
			assertEquals("Restored contents", contents, document.get());
			assertEquals("Restored isDirty", false, editor.isDirty());
			assertEquals("Restored isDirtyPage", false, editor.isDirtyPage());
			assertEquals("Restored page title", pageTitle, editor.getPageTitle(textPageManager.getEditor()));
			textPageManager.refresh();
			markers = file.findMarkers(markerId, true, IResource.DEPTH_INFINITE);
			assertEquals("Restored markers", 0, markers.length);
		} finally {
			assertTrue("Close Editor", workbenchPage.closeEditor(editor, true));
		}
	}

	//	Second edit continues first, requiring TextEditor's to DocumentUndoManager.commit
	// Bugzilla 224324 part 1.
	public void testEditSaveAndEdit() throws CoreException, ExecutionException, BadLocationException {
		final String contents1 = "trans";
		final String contents2 = " ";
		final String contents3 = "formation tx0(ecore:Ecore) {}\n";
		final String contents = contents1 + contents3;
		final String testFileName = getName() + ".qvtr";
		final String pageTitle = QVT_RELATION_TEXT;
		createModelRegistryFile();
		IFile file = createFile(testFileName, contents);
		IFileEditorInput editorInput = new FileEditorInput(file);
		QVTrMultiEditor editor = (QVTrMultiEditor) workbenchPage.openEditor(editorInput, getMultiEditorId());
		try {
			ICreationFactory creationFactory = editor.getCreationFactory();		
			String markerId = creationFactory.getProblemMarkerId();	
			
			TextPageManager textPageManager = (TextPageManager) editor.getActivePageManager();
			assertEquals("Page managers", 4, editor.getPageManagers().size());
			
			ITextEditorWithUndoContext textEditor = textPageManager.getEditor();
			IDocumentProvider documentProvider = textEditor.getDocumentProvider();
			AbstractDocument document = (AbstractDocument) documentProvider.getDocument(editorInput);
			IMarker[] markers = file.findMarkers(markerId, true, IResource.DEPTH_INFINITE);
					
			assertEquals("Original contents", contents, document.get());
			assertEquals("Original isDirty", false, editor.isDirty());
			assertEquals("Original isDirtyPage", false, editor.isDirtyPage());
			assertEquals("Original page title", pageTitle, editor.getPageTitle(textPageManager.getEditor()));
			assertEquals("Original markers", 0, markers.length);
	//		assertEquals("Original marker", "Parser: merge tokens \"trans formation\" to form \"transformation\"", markers[0].getAttribute(IMarker.MESSAGE, ""));
		
			document.replace(contents1.length(), 0, contents2);
			runAsyncMessages(editor.getDisplay(), "Typing");
			markers = file.findMarkers(markerId, true, IResource.DEPTH_INFINITE);
			
			assertEquals("Edited contents", contents1 + contents2 + contents3, document.get());
			assertEquals("Edited isDirty", true, editor.isDirty());
			assertEquals("Edited isDirtyPage", true, editor.isDirtyPage());
			assertEquals("Edited page title", "*" + pageTitle, editor.getPageTitle(textPageManager.getEditor()));
			textPageManager.refresh();
			markers = file.findMarkers(markerId, true, IResource.DEPTH_INFINITE);
			assertEquals("Edited markers", 1, markers.length);
			assertEquals("Edited marker", "Parser: merge tokens \"trans formation\" to form \"transformation\"", markers[0].getAttribute(IMarker.MESSAGE, ""));
				
			editor.doSave(null);
	//		editor.getOperationHistory().undo(editor.getUndoContext(), monitor, null);
			runAsyncMessages(editor.getDisplay(), "Save");
	
			assertEquals("Saved contents", contents1 + contents2 + contents3, document.get());
			assertEquals("Saved isDirty", false, editor.isDirty());
			assertEquals("Saved isDirtyPage", false, editor.isDirtyPage());
			assertEquals("Saved page title", pageTitle, editor.getPageTitle(textPageManager.getEditor()));
			textPageManager.refresh();
			markers = file.findMarkers(markerId, true, IResource.DEPTH_INFINITE);
			assertEquals("Saved markers", 1, markers.length);
			assertEquals("Saved marker", "Parser: merge tokens \"trans formation\" to form \"transformation\"", markers[0].getAttribute(IMarker.MESSAGE, ""));
			
			document.replace(contents1.length() + contents2.length(), 0, contents2);
			runAsyncMessages(editor.getDisplay(), "Typing");
			markers = file.findMarkers(markerId, true, IResource.DEPTH_INFINITE);
			
			assertEquals("Edited2 contents", contents1 + contents2 + contents2 + contents3, document.get());
			assertEquals("Edited2 isDirty", true, editor.isDirty());
			assertEquals("Edited2 isDirtyPage", true, editor.isDirtyPage());
			assertEquals("Edited2 page title", "*" + pageTitle, editor.getPageTitle(textPageManager.getEditor()));
			textPageManager.refresh();
			markers = file.findMarkers(markerId, true, IResource.DEPTH_INFINITE);
			assertEquals("Edited2 markers", 1, markers.length);
			assertEquals("Edited2 marker", "Parser: merge tokens \"trans  formation\" to form \"transformation\"", markers[0].getAttribute(IMarker.MESSAGE, ""));
			
			editor.getOperationHistory().undo(editor.getUndoContext(), monitor, null);
			runAsyncMessages(editor.getDisplay(), "Undo");
	
			assertEquals("Restored contents", contents1 + contents2 + contents3, document.get());
			assertEquals("Restored isDirty", false, editor.isDirty());
			assertEquals("Restored isDirtyPage", false, editor.isDirtyPage());
			assertEquals("Restored page title", pageTitle, editor.getPageTitle(textPageManager.getEditor()));
			textPageManager.refresh();
			markers = file.findMarkers(markerId, true, IResource.DEPTH_INFINITE);
			assertEquals("Restored markers", 1, markers.length);
			assertEquals("Restored marker", "Parser: merge tokens \"trans formation\" to form \"transformation\"", markers[0].getAttribute(IMarker.MESSAGE, ""));
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
		final String pageTitle = QVT_RELATION_TEXT;
		createModelRegistryFile();
		IFile file = createFile(testFileName, contents);
		IFileEditorInput editorInput = new FileEditorInput(file);
		QVTrMultiEditor editor = (QVTrMultiEditor) workbenchPage.openEditor(editorInput, getEditorId());
		try {
			ICreationFactory creationFactory = editor.getCreationFactory();		
			String markerId = creationFactory.getProblemMarkerId();	
			
			TextPageManager textPageManager = (TextPageManager) editor.getActivePageManager();
			assertEquals("Page managers", 4, editor.getPageManagers().size());
			
			ITextEditorWithUndoContext textEditor = textPageManager.getEditor();
			IDocumentProvider documentProvider = textEditor.getDocumentProvider();
			AbstractDocument document = (AbstractDocument) documentProvider.getDocument(editorInput);
			IMarker[] markers = file.findMarkers(markerId, true, IResource.DEPTH_INFINITE);
					
			assertEquals("Original contents", contents, document.get());
			assertEquals("Original isDirty", false, editor.isDirty());
			assertEquals("Original isDirtyPage", false, editor.isDirtyPage());
			assertEquals("Original page title", pageTitle, editor.getPageTitle(textPageManager.getEditor()));
			assertEquals("Original markers", 0, markers.length);
	//		assertEquals("Original marker", "Parser: merge tokens \"trans formation\" to form \"transformation\"", markers[0].getAttribute(IMarker.MESSAGE, ""));
		
			document.replace(contents1.length(), 0, contents2);
			runAsyncMessages(editor.getDisplay(), "Typing");
			markers = file.findMarkers(markerId, true, IResource.DEPTH_INFINITE);
			
			assertEquals("Edited contents", contents1 + contents2 + contents3, document.get());
			assertEquals("Edited isDirty", true, editor.isDirty());
			assertEquals("Edited isDirtyPage", true, editor.isDirtyPage());
			assertEquals("Edited page title", "*" + pageTitle, editor.getPageTitle(textPageManager.getEditor()));
			textPageManager.refresh();
			markers = file.findMarkers(markerId, true, IResource.DEPTH_INFINITE);
			assertEquals("Edited markers", 1, markers.length);
			assertEquals("Edited marker", "Parser: merge tokens \"trans formation\" to form \"transformation\"", markers[0].getAttribute(IMarker.MESSAGE, ""));
				
			editor.doSave(null);
	//		editor.getOperationHistory().undo(editor.getUndoContext(), monitor, null);
			runAsyncMessages(editor.getDisplay(), "Save");
	
			assertEquals("Saved contents", contents1 + contents2 + contents3, document.get());
			assertEquals("Saved isDirty", false, editor.isDirty());
			assertEquals("Saved isDirtyPage", false, editor.isDirtyPage());
			assertEquals("Saved page title", pageTitle, editor.getPageTitle(textPageManager.getEditor()));
			textPageManager.refresh();
			markers = file.findMarkers(markerId, true, IResource.DEPTH_INFINITE);
			assertEquals("Saved markers", 1, markers.length);
			assertEquals("Saved marker", "Parser: merge tokens \"trans formation\" to form \"transformation\"", markers[0].getAttribute(IMarker.MESSAGE, ""));
			
			editor.getOperationHistory().undo(editor.getUndoContext(), monitor, null);
			runAsyncMessages(editor.getDisplay(), "Undo");
	
			assertEquals("Restored contents", contents, document.get());
			assertEquals("Restored isDirty", false, editor.isDirty());
			assertEquals("Restored isDirtyPage", false, editor.isDirtyPage());
			assertEquals("Restored page title", pageTitle, editor.getPageTitle(textPageManager.getEditor()));
			textPageManager.refresh();
			markers = file.findMarkers(markerId, true, IResource.DEPTH_INFINITE);
			assertEquals("Restored markers", 1, markers.length);
			assertEquals("Restored marker", "Parser: merge tokens \"trans formation\" to form \"transformation\"", markers[0].getAttribute(IMarker.MESSAGE, ""));
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
		final String pageTitle = QVT_RELATION_TEXT;
		createModelRegistryFile();
		IFile file = createFile(testFileName, contents);
		IFileEditorInput editorInput = new FileEditorInput(file);
		QVTrMultiEditor editor = (QVTrMultiEditor) workbenchPage.openEditor(editorInput, getMultiEditorId());
		try {
			ICreationFactory creationFactory = editor.getCreationFactory();		
			String markerId = creationFactory.getProblemMarkerId();	
			
			TextPageManager textPageManager = (TextPageManager) editor.getActivePageManager();
			assertEquals("Page managers", 4, editor.getPageManagers().size());
			
			ITextEditorWithUndoContext textEditor = textPageManager.getEditor();
			IDocumentProvider documentProvider = textEditor.getDocumentProvider();
			AbstractDocument document = (AbstractDocument) documentProvider.getDocument(editorInput);
			IMarker[] markers = file.findMarkers(markerId, true, IResource.DEPTH_INFINITE);
					
			assertEquals("Original contents", contents, document.get());
			assertEquals("Original isDirty", false, editor.isDirty());
			assertEquals("Original isDirtyPage", false, editor.isDirtyPage());
			assertEquals("Original page title", pageTitle, editor.getPageTitle(textPageManager.getEditor()));
			assertEquals("Original markers", 1, markers.length);
			assertEquals("Original marker", "Parser: merge tokens \"trans formation\" to form \"transformation\"", markers[0].getAttribute(IMarker.MESSAGE, ""));
		
			document.replace(contents1.length(), contents2.length(), "");
			runAsyncMessages(editor.getDisplay(), "Typing");
			markers = file.findMarkers(markerId, true, IResource.DEPTH_INFINITE);
			
			assertEquals("Edited contents", contents1 + contents3, document.get());
			assertEquals("Edited isDirty", true, editor.isDirty());
			assertEquals("Edited isDirtyPage", true, editor.isDirtyPage());
			assertEquals("Edited page title", "*" + pageTitle, editor.getPageTitle(textPageManager.getEditor()));
			textPageManager.refresh();
			markers = file.findMarkers(markerId, true, IResource.DEPTH_INFINITE);
			assertEquals("Edited markers", 0, markers.length);
			
			editor.getOperationHistory().undo(editor.getUndoContext(), monitor, null);
			runAsyncMessages(editor.getDisplay(), "Undo");
	
			assertEquals("Restored contents", contents, document.get());
			assertEquals("Restored isDirty", false, editor.isDirty());
			assertEquals("Restored isDirtyPage", false, editor.isDirtyPage());
			assertEquals("Restored page title", pageTitle, editor.getPageTitle(textPageManager.getEditor()));
			textPageManager.refresh();
			markers = file.findMarkers(markerId, true, IResource.DEPTH_INFINITE);
			assertEquals("Restored markers", 1, markers.length);
			assertEquals("Restored marker", "Parser: merge tokens \"trans formation\" to form \"transformation\"", markers[0].getAttribute(IMarker.MESSAGE, ""));
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
		final String pageTitle = QVT_RELATION_TEXT;
		createModelRegistryFile();
		IFile fileA = createFile(testFileNameA, contentsA);
		IFile fileB = createFile(testFileNameB, contentsB);
		IFileEditorInput editorInputA = new FileEditorInput(fileA);
		IFileEditorInput editorInputB = new FileEditorInput(fileB);
		QVTrMultiEditor editorA = (QVTrMultiEditor) workbenchPage.openEditor(editorInputA, getMultiEditorId());
		QVTrMultiEditor editorB = (QVTrMultiEditor) workbenchPage.openEditor(editorInputB, getMultiEditorId());
		try {
			ICreationFactory creationFactory = editorA.getCreationFactory();		
			String markerId = creationFactory.getProblemMarkerId();	
	
			TextPageManager textPageManagerA = (TextPageManager) editorA.getActivePageManager();
			TextPageManager textPageManagerB = (TextPageManager) editorB.getActivePageManager();
			assertEquals("Page managers A", 4, editorA.getPageManagers().size());
			assertEquals("Page managers B", 4, editorB.getPageManagers().size());
			
			ITextEditorWithUndoContext textEditorA = textPageManagerA.getEditor();
			ITextEditorWithUndoContext textEditorB = textPageManagerB.getEditor();
			IDocumentProvider documentProviderA = textEditorA.getDocumentProvider();
			IDocumentProvider documentProviderB = textEditorB.getDocumentProvider();
			AbstractDocument documentA = (AbstractDocument) documentProviderA.getDocument(editorInputA);
			AbstractDocument documentB = (AbstractDocument) documentProviderB.getDocument(editorInputB);
			IMarker[] markersA = fileA.findMarkers(markerId, true, IResource.DEPTH_INFINITE);
			IMarker[] markersB = fileB.findMarkers(markerId, true, IResource.DEPTH_INFINITE);
					
			assertEquals("Original contents A", contentsA, documentA.get());
			assertEquals("Original isDirty A", false, editorA.isDirty());
			assertEquals("Original isDirtyPage A", false, editorA.isDirtyPage());
			assertEquals("Original page title A", pageTitle, editorA.getPageTitle(textPageManagerA.getEditor()));
			assertEquals("Original markers A", 0, markersA.length);
			assertEquals("Original contents B", contentsB, documentB.get());
			assertEquals("Original isDirty B", false, editorB.isDirty());
			assertEquals("Original isDirtyPage B", false, editorB.isDirtyPage());
			assertEquals("Original page title B", pageTitle, editorB.getPageTitle(textPageManagerB.getEditor()));
			assertEquals("Original markers B", 0, markersB.length);
	
			documentA.replace(contents1A.length(), 0, contents2A);
			runAsyncMessages(editorA.getDisplay(), "Typing A");
			
			assertEquals("Edited contents A", contents1A + contents2A + contents3A, documentA.get());
			assertEquals("Edited isDirty A", true, editorA.isDirty());
			assertEquals("Edited isDirtyPage A", true, editorA.isDirtyPage());
			assertEquals("Edited page title A", "*" + pageTitle, editorA.getPageTitle(textPageManagerA.getEditor()));
			assertEquals("Unedited contents B", contentsB, documentB.get());
			assertEquals("Unedited isDirty B", false, editorB.isDirty());
			assertEquals("Unedited isDirtyPage B", false, editorB.isDirtyPage());
			assertEquals("Unedited page title B", pageTitle, editorB.getPageTitle(textPageManagerB.getEditor()));
			textPageManagerA.refresh();
			textPageManagerB.refresh();
			markersA = fileA.findMarkers(markerId, true, IResource.DEPTH_INFINITE);
			markersB = fileB.findMarkers(markerId, true, IResource.DEPTH_INFINITE);
			assertEquals("Edited markers A", 1, markersA.length);
			assertEquals("Edited marker A", "Parser: merge tokens \"trans formation\" to form \"transformation\"", markersA[0].getAttribute(IMarker.MESSAGE, ""));
			assertEquals("Unedited markers B", 0, markersB.length);
	
			documentB.replace(contents1B.length(), 0, contents2B);
			runAsyncMessages(editorB.getDisplay(), "Typing B");
			
			assertEquals("Edited contents A", contents1A + contents2A + contents3A, documentA.get());
			assertEquals("Edited isDirty A", true, editorA.isDirty());
			assertEquals("Edited isDirtyPage A", true, editorA.isDirtyPage());
			assertEquals("Edited page title A", "*" + pageTitle, editorA.getPageTitle(textPageManagerA.getEditor()));
			assertEquals("Edited contents B", contents1B + contents2B + contents3B, documentB.get());
			assertEquals("Edited isDirty B", true, editorB.isDirty());
			assertEquals("Edited isDirtyPage B", true, editorB.isDirtyPage());
			assertEquals("Edited page title B", "*" + pageTitle, editorB.getPageTitle(textPageManagerB.getEditor()));
			textPageManagerA.refresh();
			textPageManagerB.refresh();
			markersA = fileA.findMarkers(markerId, true, IResource.DEPTH_INFINITE);
			markersB = fileB.findMarkers(markerId, true, IResource.DEPTH_INFINITE);
			assertEquals("Edited markers A", 1, markersA.length);
			assertEquals("Edited marker A", "Parser: merge tokens \"trans formation\" to form \"transformation\"", markersA[0].getAttribute(IMarker.MESSAGE, ""));
			assertEquals("Edited markers B", 1, markersB.length);
			assertEquals("Edited marker B", "Parser: merge tokens \"tr ansformation\" to form \"transformation\"", markersB[0].getAttribute(IMarker.MESSAGE, ""));
			
			editorA.getOperationHistory().undo(editorA.getUndoContext(), monitor, null);
			runAsyncMessages(editorA.getDisplay(), "Undo A");
			
			assertEquals("Restored contents A", contentsA, documentA.get());
			assertEquals("Restored isDirty A", false, editorA.isDirty());
			assertEquals("Restored isDirtyPage A", false, editorA.isDirtyPage());
			assertEquals("Restored page title A", pageTitle, editorA.getPageTitle(textPageManagerA.getEditor()));
			assertEquals("Edited contents B", contents1B + contents2B + contents3B, documentB.get());
			assertEquals("Edited isDirty B", true, editorB.isDirty());
			assertEquals("Edited isDirtyPage B", true, editorB.isDirtyPage());
			assertEquals("Edited page title B", "*" + pageTitle, editorB.getPageTitle(textPageManagerB.getEditor()));
			textPageManagerA.refresh();
			textPageManagerB.refresh();
			markersA = fileA.findMarkers(markerId, true, IResource.DEPTH_INFINITE);
			markersB = fileB.findMarkers(markerId, true, IResource.DEPTH_INFINITE);
			assertEquals("Restored markers A", 0, markersA.length);
			assertEquals("Edited markers B", 1, markersB.length);
			assertEquals("Edited marker B", "Parser: merge tokens \"tr ansformation\" to form \"transformation\"", markersB[0].getAttribute(IMarker.MESSAGE, ""));
			
			editorB.getOperationHistory().undo(editorB.getUndoContext(), monitor, null);
			runAsyncMessages(editorB.getDisplay(), "Undo B");
	
			assertEquals("Restored contents A", contentsA, documentA.get());
			assertEquals("Restored isDirty A", false, editorA.isDirty());
			assertEquals("Restored isDirtyPage A", false, editorA.isDirtyPage());
			assertEquals("Restored page title A", pageTitle, editorA.getPageTitle(textPageManagerA.getEditor()));
			assertEquals("Restored contents B", contentsB, documentB.get());
			assertEquals("Restored isDirty B", false, editorB.isDirty());
			assertEquals("Restored isDirtyPage B", false, editorB.isDirtyPage());
			assertEquals("Restored page title B", pageTitle, editorB.getPageTitle(textPageManagerB.getEditor()));
			textPageManagerA.refresh();
			textPageManagerB.refresh();
			markersA = fileA.findMarkers(markerId, true, IResource.DEPTH_INFINITE);
			markersB = fileB.findMarkers(markerId, true, IResource.DEPTH_INFINITE);
			assertEquals("Restored markers A", 0, markersA.length);
			assertEquals("Restored markers B", 0, markersB.length);
		} finally {
			assertTrue("Close Editor A", workbenchPage.closeEditor(editorA, true));
			assertTrue("Close Editor B", workbenchPage.closeEditor(editorB, true));
		}
	}

	public void testEditQvtRelationAsEqvtRelation() throws CoreException, ExecutionException, BadLocationException {
		final String contents =
			"<?xml version=\"1.0\" encoding=\"ASCII\"?>\n" +
			"<eqvtbase:Transformation xmi:version=\"2.0\"\n" +
			"	xmlns:xmi=\"http://www.omg.org/XMI\"\n" +
			"	xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
			"	xmlns:ecore=\"http://www.eclipse.org/emf/2002/Ecore\"\n" +
			"	xmlns:eqvtbase=\"http://www.eclipse.org/gmt/umlx/EQVTbase\"\n" +
			"	xmlns:eqvtrelation=\"http://www.eclipse.org/gmt/umlx/EQVTcore\"\n" +
			"	xmlns:ocl.ecore=\"http://www.eclipse.org/ocl/1.1.0/Ecore\"\n" +
			"	xmi:id=\"ast0\" name=\"umlRdbms\"/>\n";
		IFile file = createFile(getName() + ".qvtrelation", contents);
		checkOpenCloseDiagnostics(file, AdapterNotFoundException.class);
		checkOpenCloseDiagnostics(file, AdapterNotFoundException.class);	// Could differ if resource mis-caches	
	}

	public void testEditNotEqvtRelation() throws CoreException, ExecutionException, BadLocationException {
		final String contents =
			"<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
			"<emp:Company xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:emp=\"http://www.eclipse.org/OCL/examples/codegen/employee\">\n" +
			"  <employees empID=\"99\" name=\"e1\"/>\n" +
			"  <departments manager=\"99\" deptID=\"1\" name=\"d1\"/>\n" +
			"</emp:Company>\n";
		IFile file = createFile(getName() + ".eqvtrelation", contents);
		checkOpenCloseDiagnostics(file, PackageNotFoundException.class, ClassNotFoundException.class);
		checkOpenCloseDiagnostics(file, PackageNotFoundException.class, ClassNotFoundException.class);	// Could differ if resource mis-caches	
	}


	public void testEditNotQvtRelation() throws CoreException, ExecutionException, BadLocationException {
		final String contents =
			"<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
			"<emp:Company xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:emp=\"http://www.eclipse.org/OCL/examples/codegen/employee\">\n" +
			"  <employees empID=\"99\" name=\"e1\"/>\n" +
			"  <departments manager=\"99\" deptID=\"1\" name=\"d1\"/>\n" +
			"</emp:Company>\n";
		IFile file = createFile(getName() + ".qvtrelation", contents);
		checkOpenCloseDiagnostics(file, PackageNotFoundException.class);
		checkOpenCloseDiagnostics(file, PackageNotFoundException.class);	// Could differ if resource mis-caches	
	}

	private void checkOpenCloseDiagnostics(IFile file, Class<?>... expectedDiagnostics) throws PartInitException, CoreException {
		IFileEditorInput editorInput = new FileEditorInput(file);
		QVTrMultiEditor editor = (QVTrMultiEditor) workbenchPage.openEditor(editorInput, getMultiEditorId());
		try {
			ICreationFactory creationFactory = editor.getCreationFactory();		
			String markerId = creationFactory.getProblemMarkerId();			
			assertEquals("Page managers", 0, editor.getPageManagers().size());
			assertNull("Page manager", editor.getActivePageManager());
			ProblemEditorPart editorPart = (ProblemEditorPart) editor.getActiveEditor();
			Diagnostic diagnostic0 = editorPart.getDiagnostic();
			assertEquals("Diagnostics 0", 1, diagnostic0.getChildren().size());
			Diagnostic diagnostic1 = diagnostic0.getChildren().get(0);
			assertEquals("Diagnostics 0.0", expectedDiagnostics.length, diagnostic1.getChildren().size());
			for (int i = 0; i < expectedDiagnostics.length; i++) {
				Diagnostic diagnostic2 = diagnostic1.getChildren().get(i);
				assertEquals("Diagnostics 0."+i, 1, diagnostic2.getData().size());
				assertEquals("Diagnostic 0." + i, expectedDiagnostics[i], diagnostic2.getData().get(0).getClass());
			}
			IMarker[] markers = file.findMarkers(markerId, true, IResource.DEPTH_INFINITE);				
			assertEquals("Original isDirty", false, editor.isDirty());
			assertEquals("Original isDirtyPage", false, editor.isDirtyPage());
			assertEquals("Original markers", 0, markers.length);
		} finally {
			assertTrue("Close Editor", workbenchPage.closeEditor(editor, true));
		}
	}
}
