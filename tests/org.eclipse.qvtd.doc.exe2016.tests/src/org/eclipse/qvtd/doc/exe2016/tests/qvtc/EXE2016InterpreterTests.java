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
package org.eclipse.qvtd.doc.exe2016.tests.qvtc;

import java.util.Collection;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.doc.exe2016.tests.AbstractEXE2016CGTests;
import org.eclipse.qvtd.doc.exe2016.tests.DoublyLinkedListGenerator;
import org.eclipse.qvtd.doc.exe2016.tests.PrintAndLog;
import org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.DoublyLinkedList;
import org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.DoublylinkedlistPackage;
import org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.List2listPackage;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.BasicQVTiExecutor;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;
import org.eclipse.qvtd.runtime.evaluation.AbstractTransformer;
import org.eclipse.qvtd.xtext.qvtcore.tests.QVTcCompilerTests;
import org.junit.Test;

/**
 * Tests that QVTc files can be compiled and executed.
 */
public class EXE2016InterpreterTests extends QVTcCompilerTests
{
	@Override
	@Test
	public void testQVTcCompiler_Forward2Reverse() throws Exception {
		AbstractTransformer.EXCEPTIONS.setState(true);
		String testFolderName = "forward2reverse";
		URI testFolderURI = TESTS_BASE_URI.appendSegment(testFolderName);
		DoublyLinkedListGenerator doublyLinkedListGenerator = new DoublyLinkedListGenerator();
		PrintAndLog logger = new PrintAndLog("results/" + getName());
		logger.printf("%s\n", getName());
		//		AbstractTransformer.INVOCATIONS.setState(true);
		MyQVT myQVT = new MyQVT("forward2reverse");
		myQVT.loadEcoreFile(testFolderURI.appendSegment("DoublyLinkedList.ecore"), DoublylinkedlistPackage.eINSTANCE);
		myQVT.loadEcoreFile(testFolderURI.appendSegment("List2List.ecore"), List2listPackage.eINSTANCE);
		//    	myQVT.getEnvironmentFactory().setEvaluationTracingEnabled(true);
		try {
			ImperativeTransformation asTransformation = myQVT.compileTransformation("Forward2Reverse.qvtc", "reverse");
			int[] tests = /**new int[]{100000}; //*/PrintAndLog.getTestSizes();
			for (int testSize : tests) {
				@SuppressWarnings("unused")BasicQVTiExecutor interpretedExecutor = myQVT.createInterpretedExecutor(asTransformation);
				Resource inResource = myQVT.loadInput("forward", "EmptyList.xmi");
				assert inResource != null;
				inResource.getContents().clear();
				inResource.getContents().addAll(doublyLinkedListGenerator.createDoublyLinkedListModel(testSize));
				//				myQVT.createModel(QVTimperativeUtil.MIDDLE_DOMAIN_NAME, "Forward2Reverse_trace.xmi");
				Resource outResource = myQVT.createModel("reverse", "List_Interpreted.xmi");
				assert outResource != null;
				AbstractEXE2016CGTests.garbageCollect();
				logger.printf("%9d, ", testSize);
				long startTime = System.nanoTime();
				myQVT.executeTransformation();
				Collection<@NonNull ?> rootObjects = myQVT.getRootObjects("reverse");
				long endTime = System.nanoTime();
				logger.printf("%9.6f\n", (endTime - startTime) / 1.0e9);
				doublyLinkedListGenerator.checkModel((@NonNull DoublyLinkedList) rootObjects.iterator().next(), testSize);
				//				myQVT.saveOutput("person", "Persons_Interpreted.xmi", "Persons_expected.xmi", Families2PersonsNormalizer.INSTANCE);
				myQVT.getResourceSet().getResources().remove(inResource);
				myQVT.getResourceSet().getResources().remove(outResource);
				inResource = null;
				outResource = null;
				rootObjects = null;
				interpretedExecutor = null;
			}
		}
		finally {
			myQVT.dispose();
			logger.dispose();
		}
	}

	@Test
	public void testQVTcCompiler_Forward2Reverse_100K() throws Exception {
		DoublyLinkedListGenerator doublyLinkedListGenerator = new DoublyLinkedListGenerator();
		PrintAndLog logger = new PrintAndLog("results/" + getName());
		logger.printf("%s\n", getName());
		//		AbstractTransformer.INVOCATIONS.setState(true);
		String testFolderName = "forward2reverse";
		URI testFolderURI = TESTS_BASE_URI.appendSegment(testFolderName);
		MyQVT myQVT = new MyQVT(testFolderName);
		myQVT.loadEcoreFile(testFolderURI.appendSegment("DoublyLinkedList.ecore"), DoublylinkedlistPackage.eINSTANCE);
		myQVT.loadEcoreFile(testFolderURI.appendSegment("List2List.ecore"), List2listPackage.eINSTANCE);
		//		myQVT.getEnvironmentFactory().setEvaluationTracingEnabled(true);
		try {
			ImperativeTransformation asTransformation = myQVT.compileTransformation("Forward2Reverse.qvtc", "reverse");
			int testSize = 100000;
			BasicQVTiExecutor interpretedExecutor = myQVT.createInterpretedExecutor(asTransformation);
			myQVT.loadInput("forward", "EmptyList.xmi");
			Resource inResource = interpretedExecutor.getModel("forward");
			assert inResource != null;
			inResource.getContents().clear();
			inResource.getContents().addAll(doublyLinkedListGenerator.createDoublyLinkedListModel(testSize));
			myQVT.createModel(QVTimperativeUtil.MIDDLE_DOMAIN_NAME, "Forward2Reverse_trace.xmi");
			myQVT.createModel("reverse", "List_Interpreted.xmi");
			AbstractEXE2016CGTests.garbageCollect();
			logger.printf("%9d, ", testSize);
			long startTime = System.nanoTime();
			myQVT.executeTransformation();
			Collection<@NonNull ?> rootObjects = myQVT.getRootObjects("reverse");
			long endTime = System.nanoTime();
			logger.printf("%9.6f\n", (endTime - startTime) / 1.0e9);
			doublyLinkedListGenerator.checkModel((@NonNull DoublyLinkedList) rootObjects.iterator().next(), testSize);
			//				myQVT.saveOutput("person", "Persons_Interpreted.xmi", "Persons_expected.xmi", Families2PersonsNormalizer.INSTANCE);
		}
		finally {
			myQVT.dispose();
			logger.dispose();
		}
	}
}
