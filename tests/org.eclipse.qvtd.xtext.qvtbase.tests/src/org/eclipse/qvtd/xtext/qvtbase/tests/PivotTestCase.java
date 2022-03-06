/*******************************************************************************
 * Copyright (c) 2011, 2022 Willink Transformations and others.
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
import java.util.Collection;
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
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.impl.BasicEObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil.UnresolvedProxyCrossReferencer;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.xtext.tests.TestUtil;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.evaluation.EvaluationException;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.internal.ecore.as2es.AS2Ecore;
import org.eclipse.ocl.pivot.internal.resource.ASResourceImpl;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.internal.validation.PivotEObjectValidator;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.LabelUtil;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.ThreadLocalExecutor;
import org.eclipse.ocl.pivot.utilities.TracingOption;
import org.eclipse.ocl.pivot.validation.ComposedEValidator;
import org.eclipse.ocl.pivot.values.Value;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.xtext.base.utilities.ElementUtil;
import org.eclipse.ocl.xtext.basecs.ModelElementCS;
import org.eclipse.ocl.xtext.essentialocl.utilities.EssentialOCLCSResource;
import org.eclipse.qvtd.compiler.DefaultCompilerOptions;
import org.eclipse.qvtd.runtime.utilities.QVTruntimeUtil;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;

import junit.framework.TestCase;

/**
 * Tests for OclAny operations.
 */
public class PivotTestCase extends TestCase
{
	public static final @NonNull String PLUGIN_ID = "org.eclipse.qvtd.xtext.qvtbase.tests";
	public static final @NonNull TracingOption TEST_START = new TracingOption(PLUGIN_ID, "test/start");

	/*
	 * The following may be tweaked to assist debugging.
	 */
	//public static boolean DEBUG_GC = false;			// True performs an enthusuastic resource release and GC at the end of each test
	public static boolean DEBUG_ID = false;			// True prints the start and end of each test.
	{
		//	PivotUtilInternal.noDebug = false;
		//	DEBUG_GC = true;
		//	DEBUG_ID = true;
		//	AbstractEnvironmentFactory.liveEnvironmentFactories = new WeakHashMap<>();	// Prints the create/finalize of each EnvironmentFactory
		//	PivotMetamodelManager.liveMetamodelManagers = new WeakHashMap<>();			// Prints the create/finalize of each MetamodelManager
		//	StandaloneProjectMap.liveStandaloneProjectMaps = new WeakHashMap<>();		// Prints the create/finalize of each StandaloneProjectMap
		//	ResourceSetImpl.liveResourceSets = new WeakHashMap<>();						// Requires edw-debug private EMF branch
		//	TEST_START.setState(true);
		//	AbstractEnvironmentFactory.ENVIRONMENT_FACTORY_ATTACH.setState(true);
		//	ThreadLocalExecutor.THREAD_LOCAL_ENVIRONMENT_FACTORY.setState(true);
	}

	public static @NonNull List<Diagnostic> assertDiagnostics(@NonNull String prefix, @NonNull List<Diagnostic> diagnostics, String... messages) {
		Map<String, Integer> expected = new HashMap<String, Integer>();
		for (String message : messages) {
			Integer count = expected.get(message);
			count = count == null ? 1 : count + 1;
			expected.put(message, count);
		}
		StringBuilder s1 = null;
		for (Diagnostic diagnostic : diagnostics) {
			String actual = diagnostic.getMessage();
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
			Integer count = expected.get(key);
			assert count != null;
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
			if (s2 != null) {
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
		return diagnostics;
	}

	public static void assertNoDiagnosticErrors(String message, XtextResource xtextResource) {
		List<Diagnostic> diagnostics = xtextResource.validateConcreteSyntax();
		if (diagnostics.size() > 0) {
			StringBuilder s = new StringBuilder();
			s.append(message);
			for (Diagnostic diagnostic : diagnostics) {
				s.append("\n");
				s.append(diagnostic.toString());
			}
			fail(s.toString());
		}
	}

	public static void assertNoResourceErrors(@NonNull String prefix, @NonNull Resource resource) {
		String message = PivotUtil.formatResourceDiagnostics(resource.getErrors(), prefix, "\n\t");
		if (message != null)
			fail(message);
	}

	public static void assertNoUnresolvedProxies(String message, Resource resource) {
		Map<EObject, Collection<Setting>> unresolvedProxies = UnresolvedProxyCrossReferencer.find(resource);
		if (unresolvedProxies.size() > 0) {
			StringBuilder s = new StringBuilder();
			s.append(unresolvedProxies.size());
			s.append(" unresolved proxies in '" + resource.getURI() + "' ");
			s.append(message);
			for (Map.Entry<EObject, Collection<Setting>> unresolvedProxy : unresolvedProxies.entrySet()) {
				s.append("\n");
				BasicEObjectImpl key = (BasicEObjectImpl) unresolvedProxy.getKey();
				s.append(key.eProxyURI());
				for (Setting setting : unresolvedProxy.getValue()) {
					s.append("\n\t");
					EObject eObject = setting.getEObject();
					s.append(eObject.toString());
				}
			}
			fail(s.toString());
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
		Map<Object, Object> validationContext = LabelUtil.createDefaultContext(Diagnostician.INSTANCE);
		Diagnostic diagnostic = Diagnostician.INSTANCE.validate(eObject, validationContext);
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

	public static @NonNull List<Diagnostic> assertValidationDiagnostics(@NonNull String prefix, @NonNull Resource resource, String... messages) {
		Map<Object, Object> validationContext = LabelUtil.createDefaultContext(Diagnostician.INSTANCE);
		return assertValidationDiagnostics(prefix, resource, validationContext, messages);
	}

	public static @NonNull List<Diagnostic> assertValidationDiagnostics(@NonNull String prefix, @NonNull Resource resource, Map<Object, Object> validationContext, String... messages) {
		Executor savedExecutor = ThreadLocalExecutor.basicGetExecutor();
		Executor savedInterpretedExecutor = savedExecutor != null ? savedExecutor.basicGetInterpretedExecutor() : null;
		try {
			List<Diagnostic> diagnostics = new ArrayList<Diagnostic>();
			for (EObject eObject : resource.getContents()) {
				Diagnostic diagnostic = Diagnostician.INSTANCE.validate(eObject, validationContext);		// FIXME inline 1 call level
				diagnostics.addAll(diagnostic.getChildren());
			}
			return messages != null ? assertDiagnostics(prefix, diagnostics, messages) : Collections.emptyList();
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

	/**
	 * Remove the global EPackage.Registry and EValidator.Registry for the nsURIs.
	 * This should be invoked at the end of a test that installs compiled models to avoid pollution
	 * affecting subsequent tests that may re-use the nsURI.
	 */
	protected static void cleanup(@NonNull String @NonNull ... nsURIs) {
		for (@NonNull String nsURI : nsURIs) {
			Object ePackage = EPackage.Registry.INSTANCE.remove(nsURI);
			if (ePackage instanceof EPackage) {
				EValidator.Registry.INSTANCE.remove(ePackage);
			}
			else {
				QVTruntimeUtil.errPrintln("No EPackage to cleanup for '" + nsURI + "'");
			}
		}
	}

	protected static Value failOn(String expression, Throwable e) {
		if (e instanceof EvaluationException) {
			Throwable eCause = e.getCause();
			if (eCause != null) {
				return failOn(expression, eCause);
			}
			throw new Error("Failed to evaluate \"" + expression + "\"", e);
		}
		else if (e instanceof EvaluationException) {
			throw new Error("Failed to parse or evaluate \"" + expression + "\"", e);
		}
		else {
			throw new Error("Failure for \"" + expression + "\"", e);
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

	public static void unloadResourceSet(ResourceSet resourceSet) {
		for (Resource resource : resourceSet.getResources()) {
			resource.unload();
		}
		resourceSet.eAdapters().clear();
	}

	protected static boolean noDebug = false;

	public static void debugPrintln(String string) {
		if (!noDebug) {
			System.out.println(string);
		}
	}

	@Override
	public @NonNull String getName() {
		return TestUtil.getName(getTestName());
	}

	public @NonNull String getTestName() {
		return ClassUtil.nonNullState(super.getName());
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
		resetEValidators();
	}

	private void resetEValidators() {		// FIXME Bug 571755 this should not be needed
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
	}

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
		if (DEBUG_ID) {
			PivotUtilInternal.debugPrintln("==> Finish " + getClass().getSimpleName() + "." + getName());
		}
	}
}
