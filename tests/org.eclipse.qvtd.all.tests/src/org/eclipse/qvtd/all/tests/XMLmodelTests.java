/*******************************************************************************
 * Copyright (c) 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.all.tests;

import java.io.IOException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.xtext.tests.NoHttpURIHandlerImpl;
import org.eclipse.ocl.examples.xtext.tests.TestFile;
import org.eclipse.ocl.examples.xtext.tests.TestProject;
import org.eclipse.ocl.examples.xtext.tests.TestUtil;
import org.eclipse.ocl.pivot.internal.resource.StandaloneProjectMap.LoadFirstStrategy;
import org.eclipse.ocl.pivot.internal.resource.StandaloneProjectMap.MapToFirstConflictHandler;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.ocl.pivot.utilities.XMIUtil;
import org.eclipse.qvtd.xml.utilities.XMLmodelResourceFactoryImpl;
import org.eclipse.qvtd.xtext.qvtbase.tests.XtextTestCase;

/**
 * Tests.
 */
public class XMLmodelTests extends XtextTestCase
{
	protected void doXMLtest(URI inURI, boolean doCompare) throws Exception {
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
		Resource xmlResource = resourceSet.getResource(inURI, true);
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
			resourceSet2.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMLResourceFactoryImpl());
			Resource resource1 = resourceSet2.getResource(inURI, true);
			Resource resource2 = resourceSet2.getResource(outURI, true);
			assert (resource1 != null) && (resource2 != null);
			TestUtil.assertSameModel(resource1, resource2);
		}
	}

	public static void assertSameModel(@NonNull Resource expectedResource, @NonNull Resource actualResource) throws IOException, InterruptedException {
		TestUtil.assertSameModel(expectedResource, actualResource);
	}

	public void testXML_junit_noframes_xsl() throws Exception {
		String inPath = getTestBundleName() + "/models/junit-noframes.xsl";
		URI inURI = URI.createPlatformResourceURI(inPath, true);
		doXMLtest(inURI, false);		// FIXME whitepsace adrft, Transform package no loadable
	}

	public void testXML_Ecore_ecore() throws Exception {
		String inPath ="org.eclipse.emf.ecore/model/Ecore.ecore";
		URI inURI = URI.createPlatformResourceURI(inPath, true);
		doXMLtest(inURI, true);
	}
}
