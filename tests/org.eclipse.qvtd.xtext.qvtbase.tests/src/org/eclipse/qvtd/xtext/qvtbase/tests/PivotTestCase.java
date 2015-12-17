/*******************************************************************************
 * Copyright (c) 2011, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/

package org.eclipse.qvtd.xtext.qvtbase.tests;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.impl.BasicEObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil.UnresolvedProxyCrossReferencer;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.evaluation.EvaluationException;
import org.eclipse.ocl.pivot.internal.ecore.as2es.AS2Ecore;
import org.eclipse.ocl.pivot.internal.resource.ProjectMap;
import org.eclipse.ocl.pivot.internal.resource.StandaloneProjectMap;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.utilities.LabelUtil;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.values.Value;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.xtext.base.utilities.ElementUtil;
import org.eclipse.ocl.xtext.basecs.ModelElementCS;
import org.eclipse.ocl.xtext.essentialocl.utilities.EssentialOCLCSResource;
import org.eclipse.qvtd.xtext.qvtbase.tests.utilities.TestsXMLUtil;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;

/**
 * Tests for OclAny operations.
 */
@SuppressWarnings("nls")
public class PivotTestCase extends TestCase
{
	public static final String PLUGIN_ID = "org.eclipse.ocl.examples.xtext.tests";
	private static StandaloneProjectMap projectMap = null;

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

	public static void assertNoValidationErrors(String string, Resource resource) {
		for (EObject eObject : resource.getContents()) {
			assertNoValidationErrors(string, eObject);
		}
	}

	public static void assertNoValidationErrors(String string, EObject eObject) {
		Map<Object, Object> validationContext = LabelUtil.createDefaultContext(Diagnostician.INSTANCE);
		Diagnostic diagnostic = Diagnostician.INSTANCE.validate(eObject, validationContext);
		List<Diagnostic> children = diagnostic.getChildren();
		if (children.size() <= 0) {
			return;
		}
		StringBuilder s = new StringBuilder();
		s.append(children.size() + " validation errors");
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
		ocl.getEnvironmentFactory().adapt(xtextResource);
		xtextResource.load(inputStream, null);
		assertNoResourceErrors("Loading Xtext", xtextResource);
		Resource pivotResource = savePivotFromCS(ocl, xtextResource, null);
		Resource ecoreResource = savePivotAsEcore(ocl, pivotResource, ecoreURI, true);
		return ecoreResource;
	}

	public static @NonNull StandaloneProjectMap getProjectMap() {
		StandaloneProjectMap projectMap2 = projectMap;
		if (projectMap2 == null) {
			projectMap = projectMap2 = EMFPlugin.IS_ECLIPSE_RUNNING ? new ProjectMap(false) : new StandaloneProjectMap(false);
		}
		return projectMap2;
	}
	
	public URI getTestModelURI(String localFileName) {
		String urlString = getProjectMap().getLocation(PLUGIN_ID).toString();
		TestCase.assertNotNull(urlString);
		return URI.createURI(urlString + "/" + localFileName);
	}

//	public static void resetProjectMap() {
//		projectMap = null;
//	}

	public static Resource savePivotAsEcore(@NonNull OCL ocl, Resource pivotResource, URI ecoreURI, boolean validateSaved) throws IOException {
		return savePivotAsEcore(ocl, pivotResource, ecoreURI, null, validateSaved);
	}
	public static Resource savePivotAsEcore(@NonNull OCL ocl, Resource pivotResource, URI ecoreURI, Map<String,Object> options, boolean validateSaved) throws IOException {
		URI uri = ecoreURI != null ? ecoreURI : URI.createURI("test.ecore");
		Resource ecoreResource = AS2Ecore.createResource((EnvironmentFactoryInternal) ocl.getEnvironmentFactory(), pivotResource, uri, null);
		assertNoResourceErrors("Ecore2Pivot failed", ecoreResource);
		if (ecoreURI != null) {
			ecoreResource.save(TestsXMLUtil.defaultSavingOptions);
		}
		if (validateSaved) {
			assertNoValidationErrors("Ecore2Pivot invalid", ecoreResource);
		}
		return ecoreResource;
	}

	public static Resource savePivotFromCS(@NonNull OCL ocl, BaseCSResource xtextResource, URI pivotURI) throws IOException {
		Resource pivotResource = xtextResource.getASResource();
		assertNoUnresolvedProxies("Unresolved proxies", pivotResource);
		if (pivotURI != null) {
			pivotResource.setURI(pivotURI);
			pivotResource.save(TestsXMLUtil.defaultSavingOptions);
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
}
