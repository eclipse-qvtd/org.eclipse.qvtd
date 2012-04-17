/**
 * <copyright>
 * 
 * Copyright (c) 2011 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id$
 */

package org.eclipse.qvtd.xtext.qvtbase.tests;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.impl.BasicEObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil.UnresolvedProxyCrossReferencer;
import org.eclipse.ocl.examples.domain.evaluation.DomainException;
import org.eclipse.ocl.examples.domain.utilities.ProjectMap;
import org.eclipse.ocl.examples.domain.validation.DomainSubstitutionLabelProvider;
import org.eclipse.ocl.examples.domain.values.Value;
import org.eclipse.ocl.examples.pivot.ecore.Pivot2Ecore;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManagerResourceAdapter;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.examples.xtext.base.utilities.CS2PivotResourceAdapter;
import org.eclipse.ocl.examples.xtext.essentialocl.utilities.EssentialOCLCSResource;
import org.eclipse.uml2.uml.profile.l2.L2Package;
import org.eclipse.uml2.uml.resource.UML302UMLResource;
import org.eclipse.xtext.resource.XtextResource;

/**
 * Tests for OclAny operations.
 */
@SuppressWarnings("nls")
public class PivotTestCase extends TestCase
{
	public static final String PLUGIN_ID = "org.eclipse.ocl.examples.xtext.tests";
	private static ProjectMap projectMap = null;

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

	public static void assertNoResourceErrors(String prefix, Resource resource) {
		String message = PivotUtil.formatResourceDiagnostics(resource.getErrors(), prefix, "\n\t");
		if (message != null)
			fail(message);
	}

	public static void assertNoUnresolvedProxies(String message, Resource resource) {
		Map<EObject, Collection<Setting>> unresolvedProxies = UnresolvedProxyCrossReferencer.find(resource);
		if (unresolvedProxies.size() > 0) {
			StringBuilder s = new StringBuilder();
			s.append(unresolvedProxies.size());
			s.append(" ");	
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

	public static void assertNoValidationErrors(String string, Resource resource) {
		for (EObject eObject : resource.getContents()) {
			assertNoValidationErrors(string, eObject);
		}
	}

	public static void assertNoValidationErrors(String string, EObject eObject) {
		Map<Object, Object> validationContext = DomainSubstitutionLabelProvider.createDefaultContext(Diagnostician.INSTANCE);
		Diagnostic diagnostic = Diagnostician.INSTANCE.validate(eObject, validationContext);
		List<Diagnostic> children = diagnostic.getChildren();
		if (children.size() <= 0) {
			return;
		}
		StringBuilder s = new StringBuilder();
		s.append(children.size() + " validation errors");
		for (Diagnostic child : children){
			s.append("\n\t");
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
			Integer count = expected.get(key);
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

	protected static Value failOn(String expression, Throwable e) {
		if (e instanceof DomainException) {
			Throwable eCause = e.getCause();
			if (eCause != null) {
				return failOn(expression, eCause);
			}
			throw new Error("Failed to evaluate \"" + expression + "\"", e);
		}
		else if (e instanceof DomainException) {
			throw new Error("Failed to parse or evaluate \"" + expression + "\"", e);
		}
		else {
	        throw new Error("Failure for \"" + expression + "\"", e);
		}
	}
	
	public static Resource getEcoreFromCS(MetaModelManager metaModelManager, String testDocument, URI ecoreURI) throws IOException {
		InputStream inputStream = new ByteArrayInputStream(testDocument.getBytes());
		URI xtextURI = URI.createURI("test.oclinecore");
		ResourceSet resourceSet = new ResourceSetImpl();
		EssentialOCLCSResource xtextResource = (EssentialOCLCSResource) resourceSet.createResource(xtextURI, null);
		MetaModelManagerResourceAdapter.getAdapter(xtextResource, metaModelManager);
		xtextResource.load(inputStream, null);
		assertNoResourceErrors("Loading Xtext", xtextResource);
		Resource pivotResource = savePivotFromCS(metaModelManager, xtextResource, null);
		Resource ecoreResource = savePivotAsEcore(metaModelManager, pivotResource, ecoreURI, true);
		return ecoreResource;
	}
	
	public URI getTestModelURI(String localFileName) {
		if (projectMap == null) {
			projectMap = new ProjectMap();
		}
		String urlString = projectMap.getLocation(PLUGIN_ID).toString();
		TestCase.assertNotNull(urlString);
		return URI.createURI(urlString + "/" + localFileName);
	}

	public static Resource savePivotAsEcore(MetaModelManager metaModelManager, Resource pivotResource, URI ecoreURI, boolean validateSaved) throws IOException {
		return savePivotAsEcore(metaModelManager, pivotResource, ecoreURI, null, validateSaved);
	}
	public static Resource savePivotAsEcore(MetaModelManager metaModelManager, Resource pivotResource, URI ecoreURI, Map<String,Object> options, boolean validateSaved) throws IOException {
		URI uri = ecoreURI != null ? ecoreURI : URI.createURI("test.ecore");
		Resource ecoreResource = Pivot2Ecore.createResource(metaModelManager, pivotResource, uri, null);
		assertNoResourceErrors("Ecore2Pivot failed", ecoreResource);
		if (ecoreURI != null) {
			ecoreResource.save(null);
		}
		if (validateSaved) {
			assertNoValidationErrors("Ecore2Pivot invalid", ecoreResource);
		}
		return ecoreResource;
	}

	public static Resource savePivotFromCS(MetaModelManager metaModelManager, BaseCSResource xtextResource, URI pivotURI) throws IOException {
		CS2PivotResourceAdapter adapter = CS2PivotResourceAdapter.getAdapter(xtextResource, metaModelManager);
		Resource pivotResource = adapter.getPivotResource(xtextResource);
		assertNoUnresolvedProxies("Unresolved proxies", pivotResource);
		if (pivotURI != null) {
			pivotResource.setURI(pivotURI);
			pivotResource.save(null);
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
	protected void setUp() throws Exception {
		super.setUp();
//		debugPrintln("-----Starting " + getClass().getSimpleName() + "." + getName() + "-----");
		EPackage.Registry.INSTANCE.put(UML302UMLResource.STANDARD_PROFILE_NS_URI, L2Package.eINSTANCE);
	}

	@Override
	protected void tearDown() throws Exception {
//		OCLstdlib.uninstall();	
//		CompleteOCLStandaloneSetup.doTearDown();
//		EssentialOCLStandaloneSetup.doTearDown();
//		MarkupStandaloneSetup.doTearDown();
//		OCLinEcoreStandaloneSetup.doTearDown();
//		OCLstdlibStandaloneSetup.doTearDown();
//		System.gc();
//		System.runFinalization();
//		MetaModelManagerResourceAdapter.INSTANCES.show();
//		debugPrintln("==> Finish " + getName());
		super.tearDown();
	}
}
