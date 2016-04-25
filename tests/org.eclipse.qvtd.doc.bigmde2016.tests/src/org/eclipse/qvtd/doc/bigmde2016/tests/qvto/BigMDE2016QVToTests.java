/*******************************************************************************
 * Copyright (c) 2012, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.doc.bigmde2016.tests.qvto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.URIHandlerImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.m2m.qvt.oml.BasicModelExtent;
import org.eclipse.m2m.qvt.oml.ExecutionContextImpl;
import org.eclipse.m2m.qvt.oml.ExecutionDiagnostic;
import org.eclipse.m2m.qvt.oml.ModelExtent;
import org.eclipse.m2m.qvt.oml.TransformationExecutor;
import org.eclipse.m2m.qvt.oml.util.StringBufferLog;
import org.eclipse.ocl.pivot.internal.resource.ProjectMap;
import org.eclipse.ocl.pivot.utilities.XMIUtil;
import org.eclipse.qvtd.doc.bigmde2016.tests.FamiliesGenerator;
import org.eclipse.qvtd.doc.bigmde2016.tests.PrintAndLog;
import org.eclipse.qvtd.doc.bigmde2016.tests.qvtc.BigMDE2016CGTests;
import org.eclipse.qvtd.pivot.qvtbase.utilities.TreeIterable;
import org.eclipse.qvtd.xtext.qvtcore.tests.families2persons.Families.FamiliesPackage;
import org.eclipse.qvtd.xtext.qvtcore.tests.families2persons.Persons.PersonsPackage;
import org.junit.Test;

import junit.framework.TestCase;
import rdb.RdbPackage;
import simpleuml.SimpleumlPackage;

public class BigMDE2016QVToTests extends TestCase
{
	@Test
	public void testQVToCompiler_UML2RDBMS() throws Exception {
    	PrintAndLog logger = new PrintAndLog("results/" + getName());
    	logger.printf("%s\n", getName());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("simpleuml", new XMIResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("rdb", new XMIResourceFactoryImpl());
		SimpleumlPackage.eINSTANCE.getClass();
		RdbPackage.eINSTANCE.getClass();
		ProjectMap projectMap = new ProjectMap(false);
		projectMap.initializeResourceSet(null);
		String uri = "platform:/resource/org.eclipse.qvtd.doc.bigmde2016.tests/src/org/eclipse/qvtd/doc/bigmde2016/tests/qvto/Simpleuml_To_Rdb.qvto";
		URI txURI = URI.createURI(uri, true);
//		logger.info("Loading '" + txURI + "'");
		TransformationExecutor transformationExecutor = new TransformationExecutor(txURI);
		Diagnostic diagnostic = transformationExecutor.loadTransformation();
		if (diagnostic.getSeverity() != Diagnostic.OK) {
			StringBuilder s = new StringBuilder();
			s.append("Failed to load ");
			s.append(txURI);
			for (Diagnostic child : diagnostic.getChildren()) {
				s.append("\n  " + child.getMessage());
			}
			throw new Exception(s.toString() + txURI);
		}
		
		ResourceSet resourceSet = new ResourceSetImpl();
//		URI inURI = URI.createURI("src/org/eclipse/qvtd/doc/bigmde2016/tests/qvto/pim.simpleuml", true);
//		logger.info("Loading '" + inURI + "'");
//		Resource inResource = resourceSet.getResource(inURI, true);
//		if (inResource.getErrors().size() > 0) {
//			throw new Exception("Failed to load" + inURI);
//		}
		
       	QVToSimpleUMLGenerator generator = new QVToSimpleUMLGenerator();
        int[] tests = PrintAndLog.getTestSizes();
        for (int testSize : tests) {
        	int nPackages = testSize;
           	int nClasses = testSize * 8;
           	int nTypes = 0;//testSize;
           	int nProperties = 0;//testSize * 45;
           	int nAssociations = 0;//testSize * 45;
        	int nElements = nPackages + nClasses + nTypes + nProperties + nAssociations;
    		List<@NonNull ModelExtent> modelExtents = new ArrayList<@NonNull ModelExtent>();
			modelExtents.add(new BasicModelExtent(generator.createSimpleUMLModel(nPackages, nClasses, nTypes, nProperties, nAssociations)));
			modelExtents.add(new BasicModelExtent());
		
		
	
			StringBufferLog qvtoLog = new StringBufferLog();
	//		logger.info("Executing transformation '" + uri + "'");
			ExecutionContextImpl executionContext = new ExecutionContextImpl();
			executionContext.setLog(qvtoLog);
			BigMDE2016CGTests.garbageCollect();
			logger.printf("%9d, ", nElements);
			long startTime = System.nanoTime();
			ExecutionDiagnostic executionDiagnostic = transformationExecutor.execute(executionContext, modelExtents.toArray(new ModelExtent[modelExtents.size()]));
			long endTime = System.nanoTime();
			logger.printf("%9.6f\n", (endTime - startTime) / 1.0e9);
			if (executionDiagnostic.getSeverity() != Diagnostic.OK) {
				StringBuilder s = new StringBuilder();
				s.append("Failed to execute ");
				s.append(txURI);
				s.append(": ");
				s.append(executionDiagnostic.getMessage());
				for (Diagnostic child : diagnostic.getChildren()) {
					s.append("\n  " + child.getMessage());
				}
				throw new Exception(s.toString() + txURI);
			}
			String qvtoLogContents = qvtoLog.getContents().trim();
//			if (qvtoLogContents.length() > 0) {
//				logger.info("Creating output:  '" + outURI + "'\n" + qvtoLogContents);
//			}
//			else {
//				logger.info("Creating output:  '" + outURI);
//			}
			URI outURI = URI.createURI("src/org/eclipse/qvtd/doc/bigmde2016/tests/qvto/pim" + nElements + ".rdb", true);
			XMLResource outResource = (XMLResource) resourceSet.createResource(outURI, null);
			outResource.getContents().addAll(modelExtents.get(modelExtents.size()-1).getContents());
			int count = 0;
			for (Object eObject1 : outResource.getContents()) {
				for (EObject eObject2 : new TreeIterable((EObject)eObject1, true)) {
					count++;
				}
			}
			System.out.println(outResource.getContents().size() + " => " + count);
			Map<Object, Object> options = XMIUtil.createSaveOptions();
			options.put(XMLResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.TRUE);
			options.put(XMLResource.OPTION_URI_HANDLER, new URIHandlerImpl.PlatformSchemeAware());
			options.put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
			outResource.save(options);
        }
	
		logger.dispose();
	}
	
	@Test
	public void testQVToCompiler_Families2Persons() throws Exception {
    	PrintAndLog logger = new PrintAndLog("results/" + getName());
    	logger.printf("%s\n", getName());
//		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("simpleuml", new XMIResourceFactoryImpl());
//		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("rdb", new XMIResourceFactoryImpl());
		FamiliesPackage.eINSTANCE.getClass();
		PersonsPackage.eINSTANCE.getClass();
		ProjectMap projectMap = new ProjectMap(false);
		projectMap.initializeResourceSet(null);
		String uri = "platform:/resource/org.eclipse.qvtd.doc.bigmde2016.tests/src/org/eclipse/qvtd/doc/bigmde2016/tests/qvto/Families2Persons.qvto";
		URI txURI = URI.createURI(uri, true);
//		logger.info("Loading '" + txURI + "'");
		TransformationExecutor transformationExecutor = new TransformationExecutor(txURI);
		Diagnostic diagnostic = transformationExecutor.loadTransformation();
		if (diagnostic.getSeverity() != Diagnostic.OK) {
			StringBuilder s = new StringBuilder();
			s.append("Failed to load ");
			s.append(txURI);
			for (Diagnostic child : diagnostic.getChildren()) {
				s.append("\n  " + child.getMessage());
			}
			throw new Exception(s.toString() + txURI);
		}
		
		ResourceSet resourceSet = new ResourceSetImpl();
//		URI inURI = URI.createURI("src/org/eclipse/qvtd/doc/bigmde2016/tests/qvto/pim.simpleuml", true);
//		logger.info("Loading '" + inURI + "'");
//		Resource inResource = resourceSet.getResource(inURI, true);
//		if (inResource.getErrors().size() > 0) {
//			throw new Exception("Failed to load" + inURI);
//		}
		
		
		
        int[] tests = PrintAndLog.getTestSizes();
        for (int testSize : tests) {
			List<@NonNull ? extends EObject> rootObjects = FamiliesGenerator.createFamiliesModel(testSize, 9);
    		List<@NonNull ModelExtent> modelExtents = new ArrayList<@NonNull ModelExtent>();
			modelExtents.add(new BasicModelExtent(rootObjects));
			modelExtents.add(new BasicModelExtent());
	
			StringBufferLog qvtoLog = new StringBufferLog();
	//		logger.info("Executing transformation '" + uri + "'");
			ExecutionContextImpl executionContext = new ExecutionContextImpl();
			executionContext.setLog(qvtoLog);
			BigMDE2016CGTests.garbageCollect();
			logger.printf("%9d, ", 10*testSize);
			long startTime = System.nanoTime();
			ExecutionDiagnostic executionDiagnostic = transformationExecutor.execute(executionContext, modelExtents.toArray(new ModelExtent[modelExtents.size()]));
			long endTime = System.nanoTime();
			logger.printf("%9.6f\n", (endTime - startTime) / 1.0e9);
			if (executionDiagnostic.getSeverity() != Diagnostic.OK) {
				StringBuilder s = new StringBuilder();
				s.append("Failed to execute ");
				s.append(txURI);
				s.append(": ");
				s.append(executionDiagnostic.getMessage());
				for (Diagnostic child : diagnostic.getChildren()) {
					s.append("\n  " + child.getMessage());
				}
				throw new Exception(s.toString() + txURI);
			}
			transformationExecutor.cleanup();
			String qvtoLogContents = qvtoLog.getContents().trim();
//			if (qvtoLogContents.length() > 0) {
//				logger.info("Creating output:  '" + outURI + "'\n" + qvtoLogContents);
//			}
//			else {
//				logger.info("Creating output:  '" + outURI);
//			}
			URI outURI = URI.createURI("src/org/eclipse/qvtd/doc/bigmde2016/tests/qvto/persons" + 10*testSize + ".xmi", true);
//			XMLResource outResource = (XMLResource) resourceSet.createResource(outURI, null);
			List<EObject> contents = modelExtents.get(modelExtents.size()-1).getContents();
//			outResource.getContents().addAll(contents);
			int count = 0;
			for (Object eObject1 : contents) {
				for (EObject eObject2 : new TreeIterable((EObject)eObject1, true)) {
					count++;
				}
			}
//			System.out.println(contents.size() + " => " + count);
//			Map<Object, Object> options = XMIUtil.createSaveOptions();
//			options.put(XMLResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.TRUE);
//			options.put(XMLResource.OPTION_URI_HANDLER, new URIHandlerImpl.PlatformSchemeAware());
//			options.put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
//			outResource.save(options);
        }
	
		logger.dispose();
	}
}
