/*******************************************************************************
 * Copyright (c) 2011, 2023 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/

package org.eclipse.qvtd.xtext.qvtbase.tests;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.tests.AbstractPivotTestCase;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.internal.ecore.as2es.AS2Ecore;
import org.eclipse.ocl.pivot.internal.resource.AS2ID;
import org.eclipse.ocl.pivot.internal.resource.ASResourceImpl;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.pivot.utilities.ThreadLocalExecutor;
import org.eclipse.ocl.pivot.validation.ValidationContext;
import org.eclipse.ocl.pivot.validation.ValidationRegistryAdapter;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.xtext.base.utilities.ElementUtil;
import org.eclipse.ocl.xtext.basecs.ModelElementCS;
import org.eclipse.ocl.xtext.essentialocl.utilities.EssentialOCLCSResource;
import org.eclipse.qvtd.compiler.DefaultCompilerOptions;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePivotStandaloneSetup;
import org.eclipse.qvtd.pivot.qvtcore.QVTcorePivotStandaloneSetup;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePivotStandaloneSetup;
import org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPivotStandaloneSetup;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePivotStandaloneSetup;
import org.eclipse.qvtd.pivot.qvttemplate.QVTtemplatePivotStandaloneSetup;
import org.eclipse.qvtd.runtime.utilities.QVTruntimeUtil;
import org.eclipse.qvtd.umlx.utilities.UMLXStandaloneSetup;
import org.eclipse.qvtd.xtext.qvtbase.QVTbaseStandaloneSetup;
import org.eclipse.qvtd.xtext.qvtcore.QVTcoreStandaloneSetup;
import org.eclipse.qvtd.xtext.qvtimperative.QVTimperativeStandaloneSetup;
import org.eclipse.qvtd.xtext.qvtrelation.QVTrelationStandaloneSetup;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

/**
 * Tests for OclAny operations.
 */
public class PivotTestCase extends AbstractPivotTestCase
{
	{
		//	TEST_START.setState(true);
		//	AbstractEnvironmentFactory.ENVIRONMENT_FACTORY_ATTACH.setState(true);
		//	ThreadLocalExecutor.THREAD_LOCAL_ENVIRONMENT_FACTORY.setState(true);
		DefaultCompilerOptions.defaultSavingOptions.put(AS2ID.DEBUG_LUSSID_COLLISIONS, Boolean.TRUE);
		DefaultCompilerOptions.defaultSavingOptions.put(AS2ID.DEBUG_XMIID_COLLISIONS, Boolean.TRUE);
	}

	public static class QVTTestHelper extends TestHelper
	{
		public static final @NonNull QVTTestHelper INSTANCE = new QVTTestHelper();

		@Override
		public void doTearDown() {
			super.doTearDown();
			QVTbasePivotStandaloneSetup.doTearDown();
			QVTcorePivotStandaloneSetup.doTearDown();
			QVTimperativePivotStandaloneSetup.doTearDown();
			QVTrelationPivotStandaloneSetup.doTearDown();
			QVTschedulePivotStandaloneSetup.doTearDown();
			QVTtemplatePivotStandaloneSetup.doTearDown();
			QVTbaseStandaloneSetup.doTearDown();
			QVTcoreStandaloneSetup.doTearDown();
			QVTimperativeStandaloneSetup.doTearDown();
			QVTrelationStandaloneSetup.doTearDown();
			UMLXStandaloneSetup.doTearDown();
		}
	}

	public static void assertNoValidationErrors(@NonNull String string, @NonNull Resource resource) {
		Executor savedExecutor = ThreadLocalExecutor.basicGetExecutor();
		Executor savedInterpretedExecutor = savedExecutor != null ? savedExecutor.basicGetInterpretedExecutor() : null;
		try {
			for (EObject eObject : resource.getContents()) {
				assertNoValidationErrorsInternal(string, ClassUtil.nonNullEMF(eObject));
			}
		}
		finally {
			if (savedExecutor != ThreadLocalExecutor.basicGetExecutor()) {
				ThreadLocalExecutor.setExecutor(null);
			}
			else if (savedExecutor != null) {
				if (savedInterpretedExecutor != savedExecutor.basicGetInterpretedExecutor()) {
					savedExecutor.setInterpretedExecutor(null);
				}
			}
		}
	}

	public static void assertNoValidationErrors(@NonNull String string, @NonNull EObject eObject) {
		Executor savedExecutor = ThreadLocalExecutor.basicGetExecutor();
		Executor savedInterpretedExecutor = savedExecutor != null ? savedExecutor.basicGetInterpretedExecutor() : null;
		try {
			assertNoValidationErrorsInternal(string, eObject);
		}
		finally {
			if (savedExecutor != ThreadLocalExecutor.basicGetExecutor()) {
				ThreadLocalExecutor.setExecutor(null);
			}
			else if (savedExecutor != null) {
				if (savedInterpretedExecutor != savedExecutor.basicGetInterpretedExecutor()) {
					savedExecutor.setInterpretedExecutor(null);
				}
			}
		}
	}

	protected static void assertNoValidationErrorsInternal(@NonNull String string, @NonNull EObject eObject) {
		ValidationRegistryAdapter validationRegistry = ValidationRegistryAdapter.getAdapter(eObject);
		ValidationContext validationContext = new ValidationContext(validationRegistry);
		Diagnostician diagnostician = validationContext.getDiagnostician();
		Diagnostic diagnostic = diagnostician.validate(eObject, validationContext);
		List<Diagnostic> children = diagnostic.getChildren();
		if (children.size() <= 0) {
			return;
		}
		StringBuilder s = new StringBuilder();
		s.append(children.size() + " validation errors: " + string);
		for (Diagnostic child : children){
			s.append("\n\t");
			if (child.getData().size() > 0) {
				Object data = child.getData().get(0);
				if (data instanceof Element) {
					for (EObject eScope = (Element)data; eScope instanceof Element; eScope = eScope.eContainer()) {
						ModelElementCS csElement = ElementUtil.getCsElement((Element)eScope);
						if (csElement != null) {
							ICompositeNode node = NodeModelUtils.getNode(csElement);
							if (node != null) {
								Resource eResource = csElement.eResource();
								if (eResource != null) {
									s.append(eResource.getURI().lastSegment() + ":");
								}
								int startLine = node.getStartLine();
								s.append(startLine + ":");
							}
							s.append(((Element)data).eClass().getName() + ": ");
							break;
						}
					}
				}
			}
			s.append(child.getMessage());
		}
		fail(s.toString());
	}

	public static void assertResourceErrors(String prefix, Resource resource, String... messages) {
		Map<String, Integer> expected = new HashMap<String, Integer>();
		for (String message : messages) {
			Integer count = expected.get(message);
			count = count == null ? 1 : count + 1;
			expected.put(message, count);
		}
		StringBuilder s1 = null;
		for (Resource.Diagnostic error : resource.getErrors()) {
			String actual = error.getMessage();
			Integer expectedCount = expected.get(actual);
			if ((expectedCount == null) || (expectedCount <= 0)) {
				if (s1 == null) {
					s1 = new StringBuilder();
					s1.append("\nUnexpected errors");
				}
				s1.append("\n");
				s1.append(actual);
			}
			else {
				expected.put(actual, expectedCount-1);
			}
		}
		StringBuilder s2 = null;
		for (String key : expected.keySet()) {
			Integer count = ClassUtil.nonNullState(expected.get(key));
			while (count-- > 0) {
				if (s2 == null) {
					s2 = new StringBuilder();
					s2.append("\nMissing errors");
				}
				s2.append("\n");
				s2.append(key);
			}
		}
		if (s1 == null) {
			if (s2 == null) {
				return;
			}
			else {
				fail(s2.toString());
			}
		}
		else {
			if (s2 == null) {
				fail(s1.toString());
			}
			else {
				fail(s1.toString() + s2.toString());
			}
		}
	}

	/**
	 * Remove the global EPackage.Registry for the nsURIs.
	 * This should be invoked at the end of a test that installs compiled models to avoid pollution
	 * affecting subsequent tests that may re-use the nsURI.
	 */
	protected static void cleanup(@NonNull String @NonNull ... nsURIs) {
		for (@NonNull String nsURI : nsURIs) {
			Object ePackage = EPackage.Registry.INSTANCE.remove(nsURI);
			if (!(ePackage instanceof EPackage)) {
				QVTruntimeUtil.errPrintln("No EPackage to cleanup for '" + nsURI + "'");
			}
		}
	}

	public static Resource getEcoreFromCS(@NonNull OCL ocl, String testDocument, URI ecoreURI) throws IOException {
		InputStream inputStream = new ByteArrayInputStream(testDocument.getBytes());
		URI xtextURI = URI.createURI("test.oclinecore");
		ResourceSet resourceSet = new ResourceSetImpl();
		EssentialOCLCSResource xtextResource = (EssentialOCLCSResource) resourceSet.createResource(xtextURI, null);
		assert xtextResource != null;
		ocl.getEnvironmentFactory().adapt(xtextResource);
		xtextResource.load(inputStream, null);
		assertNoResourceErrors("Loading Xtext", xtextResource);
		Resource pivotResource = savePivotFromCS(ocl, xtextResource, null);
		Resource ecoreResource = savePivotAsEcore(ocl, pivotResource, ecoreURI, true);
		return ecoreResource;
	}

	public static Resource savePivotAsEcore(@NonNull OCL ocl, @NonNull Resource pivotResource, URI ecoreURI, boolean validateSaved) throws IOException {
		return savePivotAsEcore(ocl, pivotResource, ecoreURI, null, validateSaved);
	}
	public static @NonNull Resource savePivotAsEcore(@NonNull OCL ocl, @NonNull Resource pivotResource, URI ecoreURI, Map<String,Object> options, boolean validateSaved) throws IOException {
		URI uri = ecoreURI != null ? ecoreURI : URI.createURI("test.ecore");
		Resource ecoreResource = AS2Ecore.createResource((EnvironmentFactoryInternal) ocl.getEnvironmentFactory(), pivotResource, uri, null);
		assertNoResourceErrors("Ecore2Pivot failed", ecoreResource);
		if (ecoreURI != null) {
			ecoreResource.save(DefaultCompilerOptions.defaultSavingOptions);
		}
		if (validateSaved) {
			assertNoValidationErrors("Ecore2Pivot invalid", ecoreResource);
		}
		return ecoreResource;
	}

	public static @NonNull Resource savePivotFromCS(@NonNull OCL ocl, @NonNull BaseCSResource xtextResource, URI pivotURI) throws IOException {
		Resource pivotResource = xtextResource.getASResource();
		assertNoUnresolvedProxies("Unresolved proxies", pivotResource);
		if (pivotURI != null) {
			pivotResource.setURI(pivotURI);
			pivotResource.save(DefaultCompilerOptions.defaultSavingOptions);
		}
		return pivotResource;
	}

	//	protected static boolean noDebug = false;

	//	public static void debugPrintln(String string) {
	//		if (!noDebug) {
	//			System.out.println(string);
	//		}
	//	}

	protected PivotTestCase() {
		super(QVTTestHelper.INSTANCE);
	}

	private static List<String> savedEPackageRegistry = null;

	@Override
	protected void setUp() throws Exception {
		savedEPackageRegistry = new ArrayList<>(EPackage.Registry.INSTANCE.keySet());
		Collections.sort(savedEPackageRegistry);
		if (!TEST_START.isActive()) {
			QVTruntimeUtil.contextLine = "-----Starting " + getClass().getSimpleName() + "." + getName() + "-----";
		}
		super.setUp();
		if (DEBUG_ID) {
			PivotUtilInternal.debugPrintln("-----Starting " + getClass().getSimpleName() + "." + getName() + "-----");
		}
		//	TracingOption.resetAll();
		ThreadLocalExecutor.reset();
		ASResourceImpl.CHECK_IMMUTABILITY.setState(true);
		TEST_START.println("-----Starting " + getClass().getSimpleName() + "." + getName() + "-----");
		startTime = System.nanoTime();
		//	resetEValidators();
	}

	/*	private void resetEValidators() {		// FIXME Bug 571755 this should not be needed
		for (Map.Entry<EPackage, Object> entry : EValidator.Registry.INSTANCE.entrySet()) {
			Object eValidator = entry.getValue();
			if (eValidator instanceof ComposedEValidator) {
				ComposedEValidator composedEValidator = (ComposedEValidator)eValidator;
				composedEValidator.removeChild(PivotEObjectValidator.INSTANCE);
				List<EValidator> children = composedEValidator.getChildren();
				if (children.size() == 1) {
					EValidator.Registry.INSTANCE.put(entry.getKey(), children.get(0));
				}
			}
		}
	} */

	static long startTime;

	@Override
	protected void tearDown() throws Exception {
		//	long time = System.nanoTime() - startTime;
		ThreadLocalExecutor.reset();
		super.tearDown();
		QVTruntimeUtil.contextLine = null;
		//
		//	Diagnose the unexpected residual EPackage.Registry that are being left lying around to pollute another test.
		//
		Set<String> newSet = new HashSet<>(EPackage.Registry.INSTANCE.keySet());
		newSet.removeAll(savedEPackageRegistry);
		if (newSet.size() > 0) {
			List<String> newList = new ArrayList<>(newSet);
			Collections.sort(newList);
			//	QVTruntimeUtil.errPrintln("EPackage.Registry.INSTANCE pre-extras");
			for (String nsURI : newList) {
				if (nsURI.contains("example") || nsURI.contains("test")		// FIXME Avoid using http://www.eclipse.org for test models
						|| (!nsURI.startsWith("http://www.eclipse.org") && !nsURI.startsWith("http://www.w3.org"))) {
					PivotUtilInternal.debugPrintln("Extra " + nsURI);
				}
			}
		}
		ThreadLocalExecutor.reset();
		if (DEBUG_GC) {
			//	uninstall();
			//	makeCopyOfGlobalState.restoreGlobalState();
			//	makeCopyOfGlobalState = null;
			System.gc();
			System.runFinalization();
			//			MetamodelManagerResourceAdapter.INSTANCES.show();
		}
		if (DEBUG_ID) {
			PivotUtilInternal.debugPrintln("==> Finish " + getClass().getSimpleName() + "." + getName());
		}
	}
}
