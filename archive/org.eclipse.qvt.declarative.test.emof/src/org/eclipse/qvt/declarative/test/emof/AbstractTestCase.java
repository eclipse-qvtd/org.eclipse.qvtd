/*******************************************************************************
 * Copyright (c) 2007,2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.test.emof;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.ocl.examples.modelregistry.standalone.JavaFileHandle;
import org.eclipse.ocl.examples.modelregistry.standalone.JavaModelRegistryEnvironment;
import org.eclipse.ocl.examples.modelregistry.standalone.JavaProjectHandle;
import org.eclipse.qvt.declarative.ecore.adapters.ResourceSetMappingMetaDataRegistryAdapter;
import org.eclipse.qvt.declarative.ecore.mappings.IMappingMetaData;
import org.eclipse.qvt.declarative.ecore.mappings.IMappingMetaDataRegistry;
import org.eclipse.qvt.declarative.emof.EMOF.util.EMOFMappingMetaData;
import org.eclipse.qvt.declarative.test.emof.tools.EcoreDifference;
import org.eclipse.qvt.declarative.test.emof.tools.EquivalenceHelper;
import org.eclipse.qvt.declarative.test.emof.tools.EquivalenceMap;

public abstract class AbstractTestCase extends UtilityTestCase
{
	protected ResourceSetImpl resourceSet;
	protected List<String> expectedErrors = null;
	
	public class TestEnvironment extends JavaModelRegistryEnvironment
	{
		@Override public void logTheError(String string, Throwable e) {
			if ((expectedErrors != null) && expectedErrors.contains(string))
				expectedErrors.remove(string);
			else {
				StringWriter sw = new StringWriter();
				PrintWriter pw = new PrintWriter(sw);
				pw.println(string);
				if (e != null)
					e.printStackTrace(pw);
				fail(sw.toString());
			}
		}		
	}
	
	public static class LexerError {
		public int errorCode;
		public int leftToken;
		public int rightToken;
		
		public LexerError(int errorCode, int leftToken, int rightToken) {
			this.errorCode = errorCode;
			this.leftToken = leftToken;
			this.rightToken = rightToken;				
		}
	}
	
	public static class ParserError {
		public int errorCode;
		public int leftToken;
		public int rightToken;
		public String tokenText;
		
		public ParserError(int errorCode, int leftToken, int rightToken, String tokenText) {
			this.errorCode = errorCode;
			this.leftToken = leftToken;
			this.rightToken = rightToken;				
			this.tokenText = tokenText;				
		}
	}
	
	public static class SemanticError {
		public String rule;
		public String problemMessage;
		public int startOffset;
		public int endOffset;
		
		public SemanticError(String rule, String problemMessage, int startOffset, int endOffset) {
			this.rule = rule;
			this.problemMessage = problemMessage;
			this.startOffset = startOffset;				
			this.endOffset = endOffset;				
		}
	}

	protected void assertDifferencesEquals(EquivalenceMap ecoreComparator, URI leftURI, URI rightURI, Set<EcoreDifference> expectedDifferences) {
		List<EcoreDifference> actualDifferences = ecoreComparator.computeDifferences();
		List<EcoreDifference> extraDifferences = new ArrayList<EcoreDifference>();
		for (EcoreDifference expectedDifference : expectedDifferences) {
			EcoreDifference gotIt = null;
			for (EcoreDifference actualDifference : actualDifferences) {
				if (expectedDifference.isSameLeftElseRight(actualDifference))
					gotIt = actualDifference;
			}
			if (gotIt != null)
				actualDifferences.remove(gotIt);
			else
				extraDifferences.add(expectedDifference);
		}
		Collections.sort(actualDifferences);
		Collections.sort(extraDifferences);
		StringBuffer s = null;
		s = checkDifferences(s, " missing ", leftURI, rightURI, actualDifferences);
		s = checkDifferences(s, " extra ", leftURI, rightURI, extraDifferences);
		if (s != null)
			fail(s.toString());
	}

	protected void assertNoDifferences(EquivalenceMap ecoreComparator, URI leftURI, URI rightURI) {
		List<EcoreDifference> differences = ecoreComparator.computeDifferences();
		Collections.sort(differences);
		StringBuffer s = null;
		s = checkDifferences(s, " ", leftURI, rightURI, differences);
		if (s != null)
			fail(s.toString());
	}

	private StringBuffer checkDifferences(StringBuffer errors, String prefix, URI leftURI, URI rightURI, Collection<EcoreDifference> differences) {
		if (differences.size() > 0) {
			if (errors == null)
				errors = new StringBuffer();
			else
				errors.append("\n  ");
			errors.append(differences.size() + prefix + "model differences between\n  ");
			errors.append(leftURI);
			errors.append("\n  ");
			errors.append(rightURI);
			for (EcoreDifference difference : differences) {
				errors.append("\n");
				errors.append(difference.toString());
			}
		}
		return errors;
	}

	protected void assertSameModel(EquivalenceHelper helper, URI projectURI, Resource resource1, URI referenceURI, EquivalenceMap.ContentPredicate contentPredicate) throws IOException {
		assertTrue("Resource Set should contain resource", resourceSet.getResources().contains(resource1));
		assertNotNull("Null project URI", projectURI);
		assertNotNull("Null parsed resource", resource1);
		assertNotNull("Null reference URI", referenceURI);
		URI uri = resource1.getURI();
		assertNotNull(uri);
		Resource resource2 = resourceSet.getResource(referenceURI, true);
		EquivalenceMap ecoreComparator = new EquivalenceMap(helper, resource1, resource2, contentPredicate);
		ecoreComparator.setURI(projectURI);
		assertNoDifferences(ecoreComparator, uri, referenceURI);
	}

	protected void assertSameModel(EquivalenceHelper helper, URI projectURI, Resource resource1, Resource resource2, EquivalenceMap.ContentPredicate contentPredicate) throws IOException {
		assertTrue("Resource Set should contain first resource", resourceSet.getResources().contains(resource1));
		assertTrue("Resource Set should contain second resource", resourceSet.getResources().contains(resource2));
		assertNotNull("Null project URI", projectURI);
		assertNotNull("Null parsed resource", resource1);
		assertNotNull("Null reference resource", resource2);
		URI uri = resource1.getURI();
		assertNotNull(uri);
		EquivalenceMap ecoreComparator = new EquivalenceMap(helper, resource1, resource2, contentPredicate);
		ecoreComparator.setURI(projectURI);
		assertNoDifferences(ecoreComparator, uri, resource2.getURI());
	}

	/**
	 * Return the name of this test bundle. The default implementation
	 * assumes that the parent package of the package containing this
	 * class is the same as the bundle name.
	 *
	protected String getBundleName() {
		String projectName = getClass().getPackage().getName();
		int i = projectName.lastIndexOf (".");
		String bundleName = projectName.substring(0, i);
		return bundleName;
	} */
	
	protected JavaFileHandle getFileHandle(String fileName) throws IOException {
		File projectFile = getProjectFile();
		JavaProjectHandle projectHandle = new JavaProjectHandle(projectFile, "test.modelregistry");
		return projectHandle.getFileHandle(fileName);
	}
	
	protected IMappingMetaDataRegistry getMappingMetaDataRegistry() {
		return getMappingMetaDataRegistry(EMOFMappingMetaData.INSTANCE);
	}

	public IMappingMetaDataRegistry getMappingMetaDataRegistry(IMappingMetaData mappingMetaData) {
		IMappingMetaDataRegistry mappingMetaDataRegistry = ResourceSetMappingMetaDataRegistryAdapter.getMappingMetaDataRegistry(resourceSet, mappingMetaData);
		mappingMetaDataRegistry.getMappingMetaDataFactory(mappingMetaData);
		return mappingMetaDataRegistry;
	}
	
	protected URI getProjectURI() {
		File projectFile = getProjectFile();
		return URI.createFileURI(projectFile.toString() + "/");
	}
	
	protected InputStream getResourceAsStream(String fileName) {
		String referenceName = getProjectName() + "/" + fileName;
		return getClass().getClassLoader().getResourceAsStream(referenceName);
	}	
	
	@Override
	protected void setUp() throws Exception {		
/*		TracingOption.RESOURCE_CREATE.setState(true);
		TracingOption.RESOURCE_CREATED.setState(true);
//		TracingOption.RESOURCE_FACTORY.setState(true);
		TracingOption.RESOURCE_LOAD.setState(true);
		TracingOption.RESOURCE_OBJECT.setState(true);
		TracingOption.RESOURCE_SAVE.setState(true);
		TracingOption.CONTENT_DESCRIPTION.setState(true); */
		new TestEnvironment();
		super.setUp();
		resourceSet = new ResourceSetImpl();
		getMappingMetaDataRegistry().configure(resourceSet);
	}

	@Override
	protected void tearDown() throws Exception {
		resourceSet = null;
//		DebugCounters.print(System.out, getName());
		super.tearDown();
	}
}
