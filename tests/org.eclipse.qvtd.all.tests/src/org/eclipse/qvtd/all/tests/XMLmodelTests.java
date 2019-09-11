/*******************************************************************************
 * Copyright (c) 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.all.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.m2m.atl.common.ATL.ATLPackage;
import org.eclipse.ocl.examples.xtext.tests.NoHttpURIHandlerImpl;
import org.eclipse.ocl.examples.xtext.tests.TestFile;
import org.eclipse.ocl.examples.xtext.tests.TestProject;
import org.eclipse.ocl.examples.xtext.tests.TestUtil;
import org.eclipse.ocl.pivot.internal.resource.StandaloneProjectMap.LoadFirstStrategy;
import org.eclipse.ocl.pivot.internal.resource.StandaloneProjectMap.MapToFirstConflictHandler;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.pivot.utilities.XMIUtil;
import org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage;
import org.eclipse.qvtd.xml.utilities.XMLmodelResourceFactoryImpl;
import org.eclipse.qvtd.xml.utilities.XMLmodelResourceImpl;
import org.eclipse.qvtd.xtext.qvtbase.tests.XtextTestCase;

/**
 * Tests.
 */
public class XMLmodelTests extends XtextTestCase
{
	protected @NonNull Resource doXMLtest(URI inURI, boolean doCompare, boolean ignoreEcore) throws Exception {
		String testExtension = inURI.fileExtension();
		String testFileName = inURI.trimFileExtension().lastSegment();
		ProjectManager projectManager = getTestProjectManager();
		ResourceSet resourceSet = new ResourceSetImpl();
		projectManager.initializeResourceSet(resourceSet);
		TestProject testProject = getTestProject();
		TestFile outFile = testProject.getOutputFile(testFileName + ".out." + testExtension);
		TestFile xmlFile = testProject.getOutputFile(testFileName + ".xml");
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(testExtension, new XMLmodelResourceFactoryImpl());
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xml", new XMLResourceFactoryImpl());
		Resource xmlResource = resourceSet.createResource(inURI, "");
		Map<String, Object> loadOptions = new HashMap<>();
		if (ignoreEcore) {
			loadOptions.put(XMLmodelResourceImpl.IGNORE_ECORE, Boolean.TRUE);
		}
		xmlResource.load(loadOptions);
		xmlResource.toString();
		URI xmlURI = xmlFile.getURI();
		URI outURI = outFile.getURI();
		xmlResource.setURI(outURI);
		xmlResource.save(XMIUtil.createSaveOptions());
		Resource xmlResource2 = resourceSet.createResource(xmlURI);
		xmlResource2.getContents().addAll(xmlResource.getContents());
		xmlResource2.save(XMIUtil.createSaveOptions());
		//
		if (doCompare) {
			ResourceSet resourceSet2 = new ResourceSetImpl();
			NoHttpURIHandlerImpl.install(resourceSet2);
			projectManager.initializeResourceSet(resourceSet2);
			projectManager.configure(resourceSet2, LoadFirstStrategy.INSTANCE, MapToFirstConflictHandler.INSTANCE);
			resourceSet2.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
			resourceSet2.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
			resourceSet2.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMLResourceFactoryImpl());
			Resource resource1 = resourceSet2.getResource(inURI, true);
			Resource resource2 = resourceSet2.getResource(outURI, true);
			assert (resource1 != null) && (resource2 != null);
			URI uri = URI.createURI("assertSameModel");
			resource1.setURI(uri);
			resource2.setURI(uri);
			TestUtil.assertSameModel(resource1, resource2);
			resource1.setURI(inURI);
			resource2.setURI(outURI);
		}
		xmlResource.getContents().addAll(xmlResource2.getContents());
		return xmlResource;
	}

	public static void assertSameModel(@NonNull Resource expectedResource, @NonNull Resource actualResource) throws IOException, InterruptedException {
		TestUtil.assertSameModel(expectedResource, actualResource);
	}

	public void testXML_junit_noframes_xsl() throws Exception {
		String inPath = getTestBundleName() + "/models/junit-noframes.xsl";
		URI inURI = URI.createPlatformResourceURI(inPath, true);
		doXMLtest(inURI, false, true);		// FIXME whitepsace adrft, Transform package no loadable
	}

	public void testXML_Ecore_ecore() throws Exception {
		String inPath ="org.eclipse.emf.ecore/model/Ecore.ecore";
		URI inURI = URI.createPlatformResourceURI(inPath, true);
		XMLmodelResourceImpl resource = (XMLmodelResourceImpl) doXMLtest(inURI, true, false);
		assertNoValidationErrors("Loading '" + resource.getURI().toString() + "'", resource);
	}

	public void testXML_Families2Persons_qvtras_xmi() throws Exception {
		OCL ocl = OCL.newInstance(OCL.CLASS_PATH);
		URIConverter uriConverter = ocl.getResourceSet().getURIConverter();
		TestProject testProject = getTestProject();
		TestFile inFile = testProject.copyFile(uriConverter, null, getModelsURI("Families2Persons.qvtras.xmi"));
		QVTrelationPackage.eINSTANCE.getClass();
		URI inURI = inFile.getURI(); //URI.createPlatformResourceURI(inPath, true);
		@SuppressWarnings("unused")
		XMLmodelResourceImpl resource = (XMLmodelResourceImpl) doXMLtest(inURI, true, false);
		// There are unresolved proxies
		// assertNoValidationErrors("Loading '" + resource.getURI().toString() + "'", resource);
		ocl.dispose();
	}

	public void testXML_Families2Persons_atl_xmi() throws Exception {
		ATLPackage.eINSTANCE.getClass();
		String inPath = getTestBundleName() + "/models/Families2Persons.atl.xmi";
		URI inURI = URI.createPlatformResourceURI(inPath, true);
		XMLmodelResourceImpl resource = (XMLmodelResourceImpl) doXMLtest(inURI, true, false);
		assertNoValidationErrors("Loading '" + resource.getURI().toString() + "'", resource);
	}
}
