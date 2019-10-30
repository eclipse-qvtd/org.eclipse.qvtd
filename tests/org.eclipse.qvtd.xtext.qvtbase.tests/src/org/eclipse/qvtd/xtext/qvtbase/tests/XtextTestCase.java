/*******************************************************************************
 * Copyright (c) 2008, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtbase.tests;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.spi.ThrowableInformation;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.xtext.tests.TestFile;
import org.eclipse.ocl.examples.xtext.tests.TestFileSystem;
import org.eclipse.ocl.examples.xtext.tests.TestFileSystemHelper;
import org.eclipse.ocl.examples.xtext.tests.TestProject;
import org.eclipse.ocl.examples.xtext.tests.TestUtil;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.LambdaType;
import org.eclipse.ocl.pivot.LoopExp;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.TemplateableElement;
import org.eclipse.ocl.pivot.TupleType;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.internal.StandardLibraryImpl;
import org.eclipse.ocl.pivot.internal.library.StandardLibraryContribution;
import org.eclipse.ocl.pivot.model.OCLstdlib;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotConstants;
import org.eclipse.ocl.pivot.utilities.PivotStandaloneSetup;
import org.eclipse.ocl.pivot.values.Bag;
import org.eclipse.ocl.xtext.basecs.ModelElementCS;

public class XtextTestCase extends PivotTestCase
{
	public static final class TestCaseAppender extends ConsoleAppender
	{
		private static Logger rootLogger = Logger.getRootLogger();

		private boolean installed = false;

		public TestCaseAppender() {
			super(new SimpleLayout(), SYSTEM_OUT);
			setName("TestHarness");
		}

		@Override
		public void append(LoggingEvent event) {
			if (event.getLevel().isGreaterOrEqual(Level.INFO)) {
				String renderedMessage = event.getRenderedMessage();
				ThrowableInformation throwableInformation = event.getThrowableInformation();
				Throwable throwable = throwableInformation != null ? throwableInformation.getThrowable() : null;
				throw new Error(renderedMessage, throwable);
			}
			//			super.append(event);
		}

		public void install() {
			if (!installed) {
				rootLogger.addAppender(this);
				installed = true;
			}
		}

		public void uninstall() {
			rootLogger.removeAppender(this);
			installed = false;
		}
	}

	public static TestCaseAppender testCaseAppender = new TestCaseAppender();

	protected void assertPivotIsValid(URI pivotURI) {
		ResourceSet reloadResourceSet = new ResourceSetImpl();
		reloadResourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("pivot", new EcoreResourceFactoryImpl());
		Resource reloadedPivotResource = reloadResourceSet.getResource(pivotURI, true);
		assertNoValidationErrors("Pivot reload validation problems", reloadedPivotResource);
		unloadResourceSet(reloadResourceSet);
	}

	public static void assertSameModel(@NonNull Resource expectedResource, @NonNull Resource actualResource) throws IOException, InterruptedException {
		TestUtil.assertSameModel(expectedResource, actualResource);
	}

	/**
	 * Install a platform:/resource/project... mapping for all folders in
	 * $WORKSPACE_LOC/* if defined, or $user.dir/../* otherwise.
	 */
	public static void configurePlatformResources() {
		if (!EcorePlugin.IS_ECLIPSE_RUNNING) {
			String urlString = System.getProperty("WORKSPACE_LOC");
			File workspaceLoc;
			if (urlString != null) {
				workspaceLoc = new File(urlString);
			}
			else {
				workspaceLoc = new File(System.getProperty("user.dir")).getParentFile();
			}
			File[] files = workspaceLoc.listFiles();
			for (File file : files) {
				if (file.isDirectory()) {
					String name = file.getName();
					EcorePlugin.getPlatformResourceMap().put(name, URI.createFileURI(file.toString() + "/"));
				}
			}
		}
	}

	/**
	 * Return the difference between expectedMessages and actualMessages, or null if no differences.
	 *
	 * The return is formatted one message per line with a leading new-line followed by
	 * an expected/actual count in parentheses followed by the messages
	 */
	public static String formatMessageDifferences(@NonNull Bag<@NonNull String> expectedMessages, @NonNull Bag<@NonNull String> actualMessages) {
		Set<@NonNull String> allMessages = new HashSet<>(expectedMessages);
		allMessages.addAll(actualMessages);
		StringBuilder s = null;
		for (String message : allMessages) {
			int actualCount = actualMessages.count(message);
			int expectedCount = expectedMessages.count(message);
			if (actualCount != expectedCount) {
				if (s == null) {
					s = new StringBuilder();
				}
				s.append("\n  (" + expectedCount + "/" + actualCount + ") " + message);
			}
		}
		return s != null ? s.toString() : null;
	}

	protected static boolean hasCorrespondingCS(@NonNull Element pivotElement) {
		if (!isValidPivot(pivotElement)) {
			return false;
		}
		if (pivotElement instanceof ExpressionInOCL) {
			return false;
		}
		if ((pivotElement instanceof Variable) && (pivotElement.eContainer() instanceof ExpressionInOCL)) {
			return false;
		}
		if ((pivotElement instanceof Variable) && (pivotElement.eContainer() instanceof LoopExp)
				&& Character.isDigit((((Variable)pivotElement).getName().charAt(0)))) {
			return false;
		}
		//		if (pivotElement instanceof TemplateBinding) {
		//			return false;
		//		}
		//		if ((pivotElement instanceof TemplateableElement) && (((TemplateableElement)pivotElement).getTemplateBinding().size() > 0)) {
		//			return false;
		//		}
		return true;
	}

	//	protected static boolean hasOptionalCS(MonikeredElement pivotElement) {
	//		if ((pivotElement instanceof LetExp) && (pivotElement.eContainer() instanceof LetExp)) {
	//			return false;
	//		}
	//		return true;
	//	}

	protected static boolean hasCorrespondingPivot(@NonNull ModelElementCS csElement) {
		if (!org.eclipse.ocl.examples.xtext.tests.XtextTestCase.hasCorrespondingPivot(csElement)) {
			return false;
		}
		return true;
	}

	protected static boolean hasUniqueMoniker(@NonNull ModelElementCS csElement) {
		if (!org.eclipse.ocl.examples.xtext.tests.XtextTestCase.hasUniqueMoniker(csElement)) {
			return false;
		}
		return true;
	}

	protected static boolean isValidPivot(@NonNull Element pivotElement) {
		if (pivotElement instanceof org.eclipse.ocl.pivot.Package) {
			if ((pivotElement.eContainer() == null) && PivotConstants.ORPHANAGE_NAME.equals(((NamedElement) pivotElement).getName())) {
				return false;
			}
		}
		if ((pivotElement instanceof TemplateableElement) && (((TemplateableElement)pivotElement).getOwnedBindings().size() > 0)) {
			return false;
		}
		if (pivotElement instanceof LambdaType) {
			return false;
		}
		if (pivotElement instanceof TupleType) {
			return false;
		}
		if (pivotElement instanceof Type) {
			EObject eContainer = pivotElement.eContainer();
			if ((eContainer instanceof org.eclipse.ocl.pivot.Package) && (eContainer.eContainer() == null)
					&& PivotConstants.ORPHANAGE_NAME.equals(((NamedElement) pivotElement).getName())
					&& PivotConstants.ORPHANAGE_NAME.equals(((NamedElement) eContainer).getName())) {
				return false;
			}
		}
		if ((pivotElement instanceof Property) && (pivotElement.eContainer() instanceof TupleType)) {
			return false;
		}
		if ((pivotElement instanceof VariableExp) && (pivotElement.eContainer() instanceof OperationCallExp)) {
			return false;
		}
		return true;
	}

	/*	protected XtextResource savePivotAsCS(MetamodelManager metamodelManager, Resource pivotResource, URI outputURI) throws IOException {
//		ResourceSet csResourceSet = resourceSet; //new ResourceSetImpl();
//		csResourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("cs", new EcoreResourceFactoryImpl());
//		csResourceSet.getPackageRegistry().put(PivotPackage.eNS_URI, PivotPackage.eINSTANCE);
//		Resource csResource = csResourceSet.createResource(uri);
//		URI oclinecoreURI = ecoreResource.getURI().appendFileExtension("oclinecore");
		XtextResource xtextResource = (XtextResource) resourceSet.createResource(outputURI, OCLinEcoreCSTPackage.eCONTENT_TYPE);
		Map<Resource, Resource> cs2PivotResourceMap = new HashMap<Resource, Resource>();
		cs2PivotResourceMap.put(xtextResource, pivotResource);
		Pivot2CS pivot2cs = new OCLinEcorePivot2CS(cs2PivotResourceMap, metamodelManager);
		pivot2cs.update();
		assertNoResourceErrors("Conversion failed", xtextResource);
//		csResource.save(TestsXMLUtil.defaultSavingOptions);
		//
		//	CS save and reload
		//
		URI savedURI = pivotResource.getURI();
		pivotResource.setURI(PivotUtil.getNonPivotURI(savedURI).appendFileExtension("pivot"));
		pivotResource.save(TestsXMLUtil.defaultSavingOptions);
		pivotResource.setURI(savedURI);

		assertNoDiagnosticErrors("Concrete Syntax validation failed", xtextResource);
		try {
			xtextResource.save(TestsXMLUtil.defaultSavingOptions);
		}
		catch (Exception e) {
			e.printStackTrace();
			URI xmiURI = outputURI.appendFileExtension(".xmi");
			Resource xmiResource = resourceSet.createResource(xmiURI);
			xmiResource.getContents().addAll(xtextResource.getContents());
			xmiResource.save(TestsXMLUtil.defaultSavingOptions);
			fail(e.toString());
		}
		return xtextResource;
	} */

	/*	protected Resource getPivotFromEcore(@NonNull EnvironmentFactoryInternal environmentFactory, Resource ecoreResource) {
		Ecore2AS ecore2Pivot = Ecore2AS.getAdapter(ecoreResource, environmentFactory);
		Model pivotRoot = ecore2Pivot.getPivotModel();
		Resource pivotResource = pivotRoot.eResource();
		assertNoResourceErrors("Normalisation failed", pivotResource);
		assertNoValidationErrors("Normalisation invalid", pivotResource);
		return pivotResource;
	} */

	public @Nullable TestFileSystem testFileSystem = null;
	public @Nullable TestProject testProject = null;
	public @Nullable ProjectManager testProjectManager = null;

	/**
	 * Return the URI of a file in the test harness models folder.
	 */
	protected @NonNull URI getModelsURI(@NonNull String filePath) {
		return URI.createPlatformResourceURI(getTestBundleName() + "/models/" + filePath, true);
	}

	/**
	 * Return the URI of a file in the test project based on the file name of the inputURI and
	 * file extension replaced by fileExtension.
	 *
	protected @NonNull URI getModelsURIWithExtension(@NonNull URI inputURI, @NonNull String fileExtension) throws Exception {
		URI fileStem = inputURI.trimFileExtension().appendFileExtension(fileExtension);
		return getModelsURI(ClassUtil.nonNullState(fileStem.lastSegment()));
	} */

	protected @NonNull String getProjectName() {
		return getClass().getPackage().getName().replace('.', '/');
	}

	/**
	 * Return platform:/resource/'filePath'
	 */
	protected @NonNull URI getResourceURI(@NonNull String filePath) {
		return URI.createPlatformResourceURI(filePath, true);
	}

	/**
	 * Return the name of the test bundle. The default implementation assumes that the package name is
	 * the same as the bundle name. Override when this assumption is unjustified.
	 */
	protected @NonNull String getTestBundleName() {
		return ClassUtil.nonNullState(getClass().getPackage().getName());
	}
	protected @NonNull URI getTestBundleURI() {
		if (EMFPlugin.IS_ECLIPSE_RUNNING) {
			return URI.createPlatformPluginURI("/" + getTestBundleName(), true);
		}
		else {
			return URI.createPlatformResourceURI("/" + getTestBundleName(), true);
		}
	}

	protected final @NonNull TestFileSystem getTestFileSystem() {
		return getTestFileSystem("");
	}

	protected @NonNull TestFileSystem getTestFileSystem(@NonNull String pathFromCurrentWorkingDirectoryToFileSystem) {
		TestFileSystem testFileSystem2 = testFileSystem;
		if (testFileSystem2 == null) {
			if (!EMFPlugin.IS_ECLIPSE_RUNNING) {
				File testBundleFile = new File(".project");
				assert !testBundleFile.exists() : "Default working directory should be the workspace rather than a project: " + testBundleFile.getAbsolutePath();
			}
			testFileSystem = testFileSystem2 = TestFileSystem.create(getTestFileSystemHelper(), pathFromCurrentWorkingDirectoryToFileSystem);
		}
		return testFileSystem2;
	}

	protected @NonNull TestFileSystemHelper getTestFileSystemHelper() {
		return new TestFileSystemHelper();
	}

	/**
	 * Return the URI of the file within the testProject.
	 */
	protected @NonNull URI getTestFileURI(@NonNull String filePath) {
		TestProject testProject = getTestProject();
		TestFile outFile = testProject.getOutputFile(filePath);
		return URI.createFileURI(outFile.getFile().toString());
	}

	/**
	 * Return the URI of the test models folder.
	 */
	protected @NonNull URI getTestModelsFolderURI() {
		return getTestBundleURI().appendSegment("models");
	}

	protected @NonNull TestProject getTestProject() {
		return getTestProject("");
	}

	protected @NonNull TestProject getTestProject(@NonNull String pathFromCurrentWorkingDirectoryToFileSystem) {
		TestProject testProject2 = testProject;
		if (testProject2 == null) {
			String testProjectName = "_QVTd_" + getClass().getSimpleName() + "__" + getTestName();
			testProject = testProject2 = getTestFileSystem(pathFromCurrentWorkingDirectoryToFileSystem).getTestProject(testProjectName, true);
		}
		return testProject2;
	}

	protected @NonNull ProjectManager getTestProjectManager() {
		return getTestProjectManager("");
	}

	protected @NonNull ProjectManager getTestProjectManager(@NonNull String pathFromCurrentWorkingDirectoryToFileSystem) {
		ProjectManager testProjectManager2 = testProjectManager;
		if (testProjectManager2 == null) {
			testProjectManager = testProjectManager2 = getTestProject(pathFromCurrentWorkingDirectoryToFileSystem).createTestProjectManager();
		}
		return testProjectManager2;
	}

	/**
	 * Return the URI of the filePath within the testProject.
	 */
	protected @NonNull URI getTestURI(@NonNull String filePath) {
		TestProject testProject = getTestProject();
		TestFile outFile = testProject.getOutputFile(filePath);
		return outFile.getURI();
	}

	/**
	 * Return the URI of a file in the test project based on the file name of the inputURI and
	 * file extension replaced by fileExtension.
	 */
	protected @NonNull URI getTestURIWithExtension(@NonNull URI inputURI, @Nullable String fileExtension) {
		URI fileStem = inputURI.trimFileExtension();
		if (fileExtension != null) {
			fileStem = fileStem.appendFileExtension(fileExtension);
		}
		String fileName = ClassUtil.nonNullState(fileStem.lastSegment());
		return getTestURI(fileName);
	}

	/**
	 * Return the URI of a file based on the file name of the inputURI and
	 * file extension replaced by fileExtension.
	 */
	protected @NonNull URI getURIWithExtension(@NonNull URI inputURI, @NonNull String fileExtension) {
		return inputURI.trimFileExtension().appendFileExtension(fileExtension);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		testCaseAppender.install();
		//    	if (!EMFPlugin.IS_ECLIPSE_RUNNING) {
		//    		OCL.initialize(null);
		//    	}
		PivotStandaloneSetup.doSetup();
		//		CompleteOCLStandaloneSetup.doSetup();
		//		OCLinEcoreStandaloneSetup.doSetup();
		//		OCLstdlibStandaloneSetup.doSetup();
		//		resourceSet = new ResourceSetImpl();
		//		ProjectMap.initializeURIResourceMap(resourceSet);
		//		Map<URI, URI> uriMap = resourceSet.getURIConverter().getURIMap();
		//		uriMap.putAll(EcorePlugin.computePlatformURIMap(false));
		//		for (Map.Entry<URI,URI> entry : uriMap.entrySet()) {
		//			System.out.println(entry.getKey() + " => " + entry.getValue());
		//		}
		//		URI platformOCLstdlibURI = URI.createURI(StandardDocumentAttribution.OCLSTDLIB_URI);
		//		URI projectURI = getProjectFileURI("dummy");
		//		URI projectOCLstdlibURI = URI.createURI("oclstdlib.oclstdlib").resolve(projectURI);
		//		uriMap.put(platformOCLstdlibURI, projectOCLstdlibURI);
		StandardLibraryContribution.REGISTRY.put(StandardLibraryImpl.DEFAULT_OCL_STDLIB_URI, new OCLstdlib.Loader());
		//        OCLDelegateDomain.initialize(null);
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}
}
