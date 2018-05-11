/*******************************************************************************
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.all.tests;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.xtext.tests.TestFile;
import org.eclipse.ocl.examples.xtext.tests.TestProject;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.qvtd.text.utilities.TextModelResourceFactoryImpl;
import org.eclipse.qvtd.xtext.qvtbase.tests.XtextTestCase;

/**
 * Tests.
 */
public class TextModelTests extends XtextTestCase
{
	protected void doTextTest(String testPath) throws IOException {
		ProjectManager projectManager = getTestProjectManager();
		ResourceSet resourceSet = new ResourceSetImpl();
		projectManager.initializeResourceSet(resourceSet);
		TestProject testProject = getTestProject();
		String inPath = getTestBundleName() + "/models/" + testPath + ".textmodel";
		URI inURI = URI.createPlatformResourceURI(inPath, true);
		TestFile outFile = testProject.getOutputFile(testPath + ".out.textmodel");
		TestFile xmlFile = testProject.getOutputFile(testPath + ".xml");
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("textmodel", new TextModelResourceFactoryImpl());
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xml", new XMLResourceFactoryImpl());
		Resource textResource = resourceSet.getResource(inURI, true);
		textResource.toString();
		URI xmlURI = xmlFile.getURI();
		URI textOutURI = outFile.getURI();
		textResource.setURI(textOutURI);
		textResource.save(null);
		Resource xmlResource = resourceSet.createResource(xmlURI);
		xmlResource.getContents().addAll(textResource.getContents());
		xmlResource.save(null);
		//
		String inFileString = readFile(new InputStreamReader(resourceSet.getURIConverter().createInputStream(inURI)));
		String outFileString = readFile(new FileReader(outFile.getFile()));
		assertEquals(inFileString, outFileString);
	}

	protected String readFile(@NonNull Reader reader) throws IOException {
		StringBuilder s = new StringBuilder();
		BufferedReader bufferedReader = new BufferedReader(reader);
		for (String line; (line = bufferedReader.readLine()) != null; ) {
			s.append(line);
			s.append("\n");
		}
		bufferedReader.close();
		return s.toString();
	}

	public void testText_BadIndents() throws Exception {
		String testPath = "badindents";
		doTextTest(testPath);
	}

	public void testText_BadTree() throws Exception {
		String testPath = "badtree";
		doTextTest(testPath);
	}

	public void testText_List() throws Exception {
		String testPath = "list";
		doTextTest(testPath);
	}

	public void testText_SimpleIndents() throws Exception {
		String testPath = "simpleindents";
		doTextTest(testPath);
	}

	public void testText_Tree() throws Exception {
		String testPath = "tree";
		doTextTest(testPath);
	}

}
