/*******************************************************************************
 * Copyright (c) 2015, 2022 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtbase.tests;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.xtext.tests.TestUtil;
import org.eclipse.ocl.pivot.Annotation;
import org.eclipse.ocl.pivot.Comment;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.Feature;
import org.eclipse.ocl.pivot.TemplateParameter;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.internal.utilities.AS2Moniker;
import org.eclipse.ocl.pivot.internal.utilities.OCLInternal;
import org.eclipse.ocl.pivot.library.LibraryFeature;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.xtext.base.cs2as.CS2AS;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.xtext.oclstdlib.scoping.JavaClassScope;
import org.eclipse.qvtd.pivot.qvtbase.model.QVTbaseMetamodel;
import org.eclipse.qvtd.runtime.model.QVTruntimeLibrary;

/**
 * Tests.
 */
public class QVTruntimeLibraryTests extends XtextTestCase
{
	public static class MonikeredComparator implements Comparator<@NonNull Element>
	{
		public static final Comparator<@NonNull Element> INSTANCE = new MonikeredComparator();

		@Override
		public int compare(@NonNull Element o1, @NonNull Element o2) {
			String m1 = AS2Moniker.toString(o1);
			String m2 = AS2Moniker.toString(o2);
			return m1.compareTo(m2);
		}
	}

	public Map<@NonNull String, @NonNull Element> computeMoniker2ASMap(Collection<@NonNull ? extends Resource> pivotResources) {
		Map<@NonNull String, @NonNull Element> map = new HashMap<>();
		for (@NonNull Resource asResource : pivotResources) {
			for (Iterator<EObject> it = asResource.getAllContents(); it.hasNext();) {
				EObject eObject = it.next();
				assert eObject.eResource() == asResource;
				if ((eObject instanceof Element) && !(eObject instanceof TemplateParameter) && !(eObject instanceof Comment) /*&& (eObject != orphanagePackage)*/) {
					Element newElement = (Element) eObject;
					String moniker = AS2Moniker.toString(newElement);
					assert moniker != null;
					Element oldElement = map.get(moniker);
					if (oldElement == null) {
						map.put(moniker, newElement);
					}
					else {
						assert newElement.getClass() == oldElement.getClass();
					}
				}
			}
		}
		return map;
	}

	protected Resource doLoadAS(@NonNull ResourceSet resourceSet, @NonNull URI libraryURI, @NonNull Resource javaResource, boolean validateMonikers) {
		Resource asResource = resourceSet.getResource(libraryURI, true);
		assert asResource != null;
		assertNoResourceErrors("Load failed", asResource);
		assertNoUnresolvedProxies("File Model", asResource);
		assertNoValidationErrors("File Model", asResource);
		//		PivotAliasCreator.refreshPackageAliases(javaResource);
		assertNoResourceErrors("Java Model", javaResource);
		assertNoUnresolvedProxies("Java Model", javaResource);
		assertNoValidationErrors("Java Model", javaResource);
		if (!validateMonikers) {
			return asResource;
		}
		//
		//	Check similar content
		//
		List<@NonNull Resource> asResourceList = Collections.singletonList(asResource);
		Map<@NonNull String, @NonNull Element> fileMoniker2asMap = computeMoniker2ASMap(asResourceList);
		//		for (String moniker : fileMoniker2asMap.keySet()) {
		//			System.out.println("File : " + moniker);
		//		}
		Map<@NonNull String, @NonNull Element> javaMoniker2asMap = computeMoniker2ASMap(Collections.singletonList(javaResource));
		//		for (String moniker : javaMoniker2asMap.keySet()) {
		//			System.out.println("Java : " + moniker);
		//		}
		//		assertEquals(fileMoniker2asMap.size(), javaMoniker2asMap.size());
		for (@NonNull String moniker : fileMoniker2asMap.keySet()) {
			Element fileElement = fileMoniker2asMap.get(moniker);
			Element javaElement = javaMoniker2asMap.get(moniker);
			if (javaElement == null) {
				boolean isExpression = false;
				for (EObject eObject = fileElement; eObject != null; eObject = eObject.eContainer()) {
					if ((eObject instanceof ExpressionInOCL) || (eObject instanceof Constraint) || (eObject instanceof Annotation)) {
						isExpression = true;		// Embedded OCL not present in Java
						break;
					}
				}
				if (isExpression) {
					continue;
				}
			}
			assertNotNull("Missing java element for '" + moniker + "'", javaElement);
			assert fileElement != null;
			assert javaElement != null;
			//			@SuppressWarnings("null")	// Can be null and we'll have an NPE as the test failure.
			Class<? extends Element> javaElementClass = javaElement.getClass();
			assertEquals(fileElement.getClass(), javaElementClass);
			if (fileElement instanceof TypedElement) {
				Type fileType = ((TypedElement)fileElement).getType();
				Type javaType = ((TypedElement)javaElement).getType();
				assertEquals(fileType.getClass(), javaType.getClass());
				String fileMoniker = AS2Moniker.toString(fileType);
				String javaMoniker = AS2Moniker.toString(javaType);
				assertEquals(fileMoniker, javaMoniker);
			}
			if (fileElement instanceof Feature) {
				String fileClass = ((Feature)fileElement).getImplementationClass();
				String javaClass = ((Feature)javaElement).getImplementationClass();
				if (fileClass == null) {
					LibraryFeature implementation = ((Feature)fileElement).getImplementation();
					if (implementation != null) {
						fileClass = implementation.getClass().getCanonicalName();
					}
				}
				if (javaClass == null) {
					LibraryFeature implementation = ((Feature)javaElement).getImplementation();
					if (implementation != null) {
						javaClass = implementation.getClass().getCanonicalName();
					}
				}
				assertEquals(fileClass, javaClass);
			}
			if (fileElement instanceof org.eclipse.ocl.pivot.Class) {
				List<Element> fileTypes = new ArrayList<>(((org.eclipse.ocl.pivot.Class)fileElement).getSuperClasses());
				List<Element> javaTypes = new ArrayList<>(((org.eclipse.ocl.pivot.Class)javaElement).getSuperClasses());
				Collections.sort(fileTypes, MonikeredComparator.INSTANCE);
				Collections.sort(javaTypes, MonikeredComparator.INSTANCE);
				assertEquals(fileTypes.size(), javaTypes.size());
				for (int i = 0; i < fileTypes.size(); i++) {
					Element fileType = fileTypes.get(i);
					Element javaType = javaTypes.get(i);
					assert (fileType != null) && (javaType != null);
					String fileMoniker = AS2Moniker.toString(fileType);
					String javaMoniker = AS2Moniker.toString(javaType);
					assertEquals(fileMoniker, javaMoniker);
				}
			}
		}
		return asResource;
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		TestUtil.doOCLstdlibSetup();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Checks that the local QVTbase-1.3.oclstdlib is the same as the pre-compiled
	 * Java implementation.
	 *
	 * FIXME check the library/model version instead.
	 */
	public void testQVTruntimeLibrary() throws Exception {
		OCL ocl = OCL.newInstance(OCL.CLASS_PATH);
		//
		//	Load OCL QVTruntimeLibrary as a file.
		//
		ResourceSet resourceSet = ocl.getResourceSet();
		getTestProjectManager().initializeResourceSet(resourceSet);
		URI libraryURI = URI.createPlatformResourceURI("org.eclipse.qvtd.runtime/model/QVTruntimeLibrary.oclstdlib", true);
		BaseCSResource xtextResource = (BaseCSResource) resourceSet.createResource(libraryURI);
		assert xtextResource != null;
		ClassLoader classLoader = getClass().getClassLoader();
		assert classLoader != null;
		JavaClassScope.getAdapter(xtextResource, classLoader);
		ocl.getEnvironmentFactory().adapt(xtextResource);
		xtextResource.load(null);
		assertNoResourceErrors("Load failed", xtextResource);
		CS2AS cs2as = xtextResource.findCS2AS();
		assert cs2as != null;
		Resource fileResource = cs2as.getASResource();
		assertNoResourceErrors("File Model", fileResource);
		assertNoUnresolvedProxies("File Model", fileResource);
		assertNoValidationErrors("File Model", fileResource);
		//
		//	Load 'QVTruntimeLibrary.oclstdlib' as pre-code-generated Java.
		//
		Resource javaResource = QVTruntimeLibrary.getDefault();
		//		PivotAliasCreator.refreshPackageAliases(javaResource);
		assertNoResourceErrors("Java Model", javaResource);
		assertNoUnresolvedProxies("Java Model", javaResource);
		assertNoValidationErrors("Java Model", javaResource);
		//
		//	Check similar content
		//
		List<@NonNull Resource> fileResourceList = Collections.singletonList(fileResource);
		Map<@NonNull String, @NonNull Element> fileMoniker2asMap = computeMoniker2ASMap(fileResourceList);
		//		for (String moniker : fileMoniker2asMap.keySet()) {
		//			System.out.println("File : " + moniker);
		//		}
		List<@NonNull Resource> javaResourceList = Collections.singletonList(javaResource);
		Map<@NonNull String, @NonNull Element> javaMoniker2asMap = computeMoniker2ASMap(javaResourceList);
		//		for (String moniker : javaMoniker2asMap.keySet()) {
		//			System.out.println("Java : " + moniker);
		//		}
		//		assertEquals(fileMoniker2asMap.size(), javaMoniker2asMap.size());
		for (String moniker : fileMoniker2asMap.keySet()) {
			Element fileElement = fileMoniker2asMap.get(moniker);
			Element javaElement = javaMoniker2asMap.get(moniker);
			if (javaElement == null) {
				boolean isExpression = false;
				for (EObject eObject = fileElement; eObject != null; eObject = eObject.eContainer()) {
					if ((eObject instanceof ExpressionInOCL) || (eObject instanceof Constraint) || (eObject instanceof Annotation)) {
						isExpression = true;		// Embedded OCL not present in Java
						break;
					}
				}
				if (isExpression) {
					continue;
				}
			}
			assertNotNull("Missing java element for '" + moniker + "'", javaElement);
			assert fileElement != null;
			assert javaElement != null;
			//			@SuppressWarnings("null")	// Can be null and we'll have an NPE as the test failure.
			Class<? extends Element> javaElementClass = javaElement.getClass();
			assertEquals(fileElement.getClass(), javaElementClass);
			if (fileElement instanceof TypedElement) {
				Type fileType = ((TypedElement)fileElement).getType();
				Type javaType = ((TypedElement)javaElement).getType();
				assertEquals(fileType.getClass(), javaType.getClass());
				String fileMoniker = AS2Moniker.toString(fileType);
				String javaMoniker = AS2Moniker.toString(javaType);
				assertEquals(fileMoniker, javaMoniker);
			}
			if (fileElement instanceof Feature) {
				String fileClass = ((Feature)fileElement).getImplementationClass();
				String javaClass = ((Feature)javaElement).getImplementationClass();
				if (fileClass == null) {
					LibraryFeature implementation = ((Feature)fileElement).getImplementation();
					if (implementation != null) {
						fileClass = implementation.getClass().getCanonicalName();
					}
				}
				if (javaClass == null) {
					LibraryFeature implementation = ((Feature)javaElement).getImplementation();
					if (implementation != null) {
						javaClass = implementation.getClass().getCanonicalName();
					}
				}
				assertEquals(fileClass, javaClass);
			}
			if (fileElement instanceof org.eclipse.ocl.pivot.Class) {
				List<Element> fileTypes = new ArrayList<>(((org.eclipse.ocl.pivot.Class)fileElement).getSuperClasses());
				List<Element> javaTypes = new ArrayList<>(((org.eclipse.ocl.pivot.Class)javaElement).getSuperClasses());
				Collections.sort(fileTypes, MonikeredComparator.INSTANCE);
				Collections.sort(javaTypes, MonikeredComparator.INSTANCE);
				assertEquals(fileTypes.size(), javaTypes.size());
				for (int i = 0; i < fileTypes.size(); i++) {
					Element fileType = fileTypes.get(i);
					Element javaType = javaTypes.get(i);
					assert (fileType != null) && (javaType != null);
					String fileMoniker = AS2Moniker.toString(fileType);
					String javaMoniker = AS2Moniker.toString(javaType);
					assertEquals(fileMoniker, javaMoniker);
				}
			}
		}
		ocl.dispose();
	}

	/**
	 * Checks that the QVTbase-1.3 AS model is the same as the pre-compiled
	 * Java implementation.
	 */
	public void testQVTruntimeLibrary_AS() throws Exception {
		OCL ocl = OCL.newInstance(getTestProjectManager());
		//
		//	Load QVTbase-1.3 as an AS file.
		//
		URI libraryURI = URI.createPlatformResourceURI("org.eclipse.qvtd.runtime/model-gen/QVTruntimeLibrary.oclas", true);
		//
		//	Load 'QVTbase-1.3.oclstdlib' as pre-code-generated Java.
		//
		Resource javaResource = QVTruntimeLibrary.getDefault();
		@SuppressWarnings("unused")Resource asResource = doLoadAS(ocl.getMetamodelManager().getASResourceSet(), libraryURI, javaResource, false);		// FIXME Contents are far from identical
		ocl.dispose();
	}

	/**
	 * Checks that the QVTbase AS model is the same as the pre-compiled Java implementation.
	 */
	public void testQVTbase_AS() throws Exception {
		OCLInternal ocl = OCLInternal.newInstance(getTestProjectManager(), null);
		//
		//	Load QVTbase as an AS file.
		//
		URI pivotURI = URI.createPlatformResourceURI("org.eclipse.qvtd.pivot.qvtbase/model-gen/QVTbase.oclas", true);
		//
		//	Load QVTbaseMetamodel as pre-code-generated Java.
		//
		Resource javaResource = QVTbaseMetamodel.getDefault();
		@SuppressWarnings("unused")
		Resource asResource = doLoadAS(ocl.getMetamodelManager().getASResourceSet(), pivotURI, javaResource, false);		// FIXME Contents are far from identical
		ocl.dispose();
	}
}
