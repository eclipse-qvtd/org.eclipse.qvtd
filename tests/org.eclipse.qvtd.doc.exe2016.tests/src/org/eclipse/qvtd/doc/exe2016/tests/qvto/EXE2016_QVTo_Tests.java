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
package org.eclipse.qvtd.doc.exe2016.tests.qvto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.m2m.qvt.oml.BasicModelExtent;
import org.eclipse.m2m.qvt.oml.ExecutionContextImpl;
import org.eclipse.m2m.qvt.oml.ExecutionDiagnostic;
import org.eclipse.m2m.qvt.oml.ModelExtent;
import org.eclipse.m2m.qvt.oml.TransformationExecutor;
import org.eclipse.m2m.qvt.oml.util.StringBufferLog;
import org.eclipse.ocl.pivot.internal.resource.ProjectMap;
import org.eclipse.qvtd.doc.exe2016.tests.AbstractEXE2016CGTests;
import org.eclipse.qvtd.doc.exe2016.tests.DoublyLinkedListGenerator;
import org.eclipse.qvtd.doc.exe2016.tests.PrintAndLog;
import org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.DoublyLinkedList;
import org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.DoublylinkedlistPackage;
import org.junit.Test;

public class EXE2016_QVTo_Tests extends AbstractEXE2016CGTests
{
	@Test
	public void testQVToCompiler_Forward2Reverse() throws Exception {
		DoublyLinkedListGenerator doublyLinkedListGenerator = new DoublyLinkedListGenerator();
		PrintAndLog logger = new PrintAndLog("results/" + getName());
		logger.printf("%s\n", getName());
		//		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("simpleuml", new XMIResourceFactoryImpl());
		//		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("rdb", new XMIResourceFactoryImpl());
		DoublylinkedlistPackage.eINSTANCE.getClass();
		ProjectMap projectMap = new ProjectMap(false);
		projectMap.initializeResourceSet(null);
		String uri = "platform:/resource/org.eclipse.qvtd.doc.exe2016.tests/src/org/eclipse/qvtd/doc/exe2016/tests/qvto/Forward2Reverse.qvto";
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
			List<@NonNull ? extends EObject> rootObjects = doublyLinkedListGenerator.createDoublyLinkedListModel(testSize);
			List<@NonNull ModelExtent> modelExtents = new ArrayList<@NonNull ModelExtent>();
			modelExtents.add(new BasicModelExtent(rootObjects));
			modelExtents.add(new BasicModelExtent());

			StringBufferLog qvtoLog = new StringBufferLog();
			//		logger.info("Executing transformation '" + uri + "'");
			ExecutionContextImpl executionContext = new ExecutionContextImpl();
			executionContext.setLog(qvtoLog);
			logger.printf("%9d, ", testSize);
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
			List<EObject> rootObjects2 = modelExtents.get(modelExtents.size()-1).getContents();
			Iterator<@NonNull EObject> it = rootObjects2.iterator();
			Object rootObject = it.next();
			assert !it.hasNext();
			assert ((DoublyLinkedList)rootObject).getOwnedElements().size() == testSize-1;
			doublyLinkedListGenerator.checkModel((DoublyLinkedList) rootObject, testSize);
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
