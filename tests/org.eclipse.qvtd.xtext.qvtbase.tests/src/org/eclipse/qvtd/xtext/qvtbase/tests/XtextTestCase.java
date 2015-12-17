/*******************************************************************************
 * Copyright (c) 2008, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtbase.tests;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.spi.ThrowableInformation;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.jdt.annotation.NonNull;
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
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.model.OCLstdlib;
import org.eclipse.ocl.pivot.utilities.PivotConstants;
import org.eclipse.ocl.pivot.utilities.PivotStandaloneSetup;
import org.eclipse.ocl.pivot.values.Bag;
import org.eclipse.ocl.xtext.basecs.ModelElementCS;

import junit.framework.TestCase;

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
	public static String formatMessageDifferences(Bag<String> expectedMessages, Bag<String> actualMessages) {
		Set<String> allMessages = new HashSet<String>(expectedMessages);
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

	protected static boolean hasCorrespondingCS(Element pivotElement) {
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

	protected static boolean hasCorrespondingPivot(ModelElementCS csElement) {
		if (!org.eclipse.ocl.examples.xtext.tests.XtextTestCase.hasCorrespondingPivot(csElement)) {
			return false;
		}
		return true;
	}

	protected static boolean hasUniqueMoniker(ModelElementCS csElement) {
		if (!org.eclipse.ocl.examples.xtext.tests.XtextTestCase.hasUniqueMoniker(csElement)) {
			return false;
		}
		return true;
	}
	
	protected static boolean isValidPivot(Element pivotElement) {
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
			return PivotUtilInternal.isLibraryType((TupleType)pivotElement);
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

	protected File getProjectFile() {
		String projectName = getProjectName();
		URL projectURL = getTestResource(projectName);	
		assertNotNull(projectURL);
		return new File(projectURL.getFile());
	}
	
	protected @NonNull URI getProjectFileURI(String referenceName) {
		File projectFile = getProjectFile();
		return URI.createFileURI(projectFile.toString() + "/" + referenceName);
	}
	
	protected String getProjectName() {
		return getClass().getPackage().getName().replace('.', '/');
	}

	protected URL getTestResource(String resourceName) {
		URL projectURL = getClass().getClassLoader().getResource(resourceName);
		if ((projectURL != null) && Platform.isRunning()) {
			try {
				projectURL = FileLocator.resolve(projectURL);
			} catch (IOException e) {
				TestCase.fail(e.getMessage());
				return null;
			}
		}
		return projectURL;
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
