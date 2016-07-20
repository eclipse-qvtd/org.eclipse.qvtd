/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.doc.exe2016.tests.qvtc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.qvtd.doc.exe2016.tests.DoublyLinkedListGenerator;
import org.eclipse.qvtd.doc.exe2016.tests.PrintAndLog;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePivotStandaloneSetup;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiTransformationExecutor;
import org.eclipse.qvtd.runtime.evaluation.Transformer;
import org.eclipse.qvtd.xtext.qvtcore.tests.list2list.doublylinkedlist.DoublyLinkedList;
import org.eclipse.qvtd.xtext.qvtcore.tests.list2list.doublylinkedlist.DoublylinkedlistFactory;
import org.eclipse.qvtd.xtext.qvtcore.tests.list2list.doublylinkedlist.Element;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cg.org.eclipse.qvtd.xtext.qvtcore.tests.forward2reverse.Forward2Reverse;
import junit.framework.TestCase;

/**
 * Source code for CG results in EXE 2016, Micro-Mappings paper.
 */
public class EXE2016CGTests extends TestCase
{
	public static void garbageCollect() throws InterruptedException {
		for (int y = 0; y < 5; y++) {
			System.gc();
			Thread.sleep(100);
		}
	}

	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
		QVTimperativePivotStandaloneSetup.doSetup();
	}

	@Override
	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testQVTcCompiler_Forward2Reverse_CG() throws Exception {
		PrintAndLog logger = new PrintAndLog(getName());
		logger.printf("%s\n", getName());
		QVTiEnvironmentFactory environmentFactory = new QVTiEnvironmentFactory(ProjectManager.NO_PROJECTS, null);
		try {
			int[] tests = PrintAndLog.getTestSizes();
			for (int testSize : tests) {
				Iterable<@NonNull ? extends Object> rootObjects = DoublyLinkedListGenerator.createDoublyLinkedListModel(testSize);
				QVTiTransformationExecutor generatedExecutor = new QVTiTransformationExecutor(environmentFactory, Forward2Reverse.class);
				Transformer transformer = generatedExecutor.getTransformer();
				transformer.addRootObjects("forward", rootObjects);
				garbageCollect();
				logger.printf("%9d, ", testSize);
				long startTime = System.nanoTime();
				transformer.run();
				long endTime = System.nanoTime();
				logger.printf("%9.6f\n", (endTime - startTime) / 1.0e9);
				Collection<@NonNull Object> rootObjects2 = transformer.getRootObjects("reverse");
				Iterator<Object> it = rootObjects2.iterator();
				Object rootObject = it.next();
				assert !it.hasNext();
				assert ((DoublyLinkedList)rootObject).getOwnedElements().size() == testSize-1;
				DoublyLinkedListGenerator.checkModel((DoublyLinkedList) rootObject, testSize);
			}
		}
		finally {
			environmentFactory.dispose();
			logger.dispose();
		}
	}

	@Test
	public void testQVTcCompiler_Families2Persons_EcoreUtil() throws Exception {
		PrintAndLog logger = new PrintAndLog(getName());
		logger.printf("%s\n", getName());
		QVTiEnvironmentFactory environmentFactory = new QVTiEnvironmentFactory(ProjectManager.NO_PROJECTS, null);
		try {
			int[] tests = PrintAndLog.getTestSizes();
			for (int testSize : tests) {
				Iterable<@NonNull ? extends Object> rootObjects = DoublyLinkedListGenerator.createDoublyLinkedListModel(testSize);
				garbageCollect();
				logger.printf("%9d, ", testSize);
				long startTime = System.nanoTime();
				DoublyLinkedList oldList = (DoublyLinkedList) rootObjects.iterator().next();
				Copier copier = new EcoreUtil.Copier();
				DoublyLinkedList newList = (DoublyLinkedList) copier.copy(oldList);
				for (Element oldElement : oldList.getOwnedElements()) {
					Element newElement = (Element) copier.get(oldElement);
					assert newElement != null;
					Element oldTarget = oldElement.getTarget();
					Element newSource = (Element) copier.get(oldTarget);
					assert newSource != null;
					newElement.setSource(newSource);
				}
				newList.setHeadElement((Element) copier.get(oldList.getHeadElement()));
				long endTime = System.nanoTime();
				logger.printf("%9.6f\n", (endTime - startTime) / 1.0e9);
				DoublyLinkedListGenerator.checkModel(newList, testSize);
			}
		}
		finally {
			environmentFactory.dispose();
			logger.dispose();
		}
	}

	@Test
	public void testQVTcCompiler_Families2Persons_Manual() throws Exception {
		PrintAndLog logger = new PrintAndLog(getName());
		logger.printf("%s\n", getName());
		QVTiEnvironmentFactory environmentFactory = new QVTiEnvironmentFactory(ProjectManager.NO_PROJECTS, null);
		try {
			int[] tests = PrintAndLog.getTestSizes();
			for (int testSize : tests) {
				Iterable<@NonNull ? extends Object> rootObjects = DoublyLinkedListGenerator.createDoublyLinkedListModel(testSize);
				garbageCollect();
				logger.printf("%9d, ", testSize);
				long startTime = System.nanoTime();
				DoublyLinkedList oldList = (DoublyLinkedList) rootObjects.iterator().next();
				List<Element> oldElements = oldList.getOwnedElements();
				//
				DoublyLinkedList newList = DoublylinkedlistFactory.eINSTANCE.createDoublyLinkedList();
				int iSize = oldElements.size();
				List<Element> newElements = new ArrayList<>(iSize);
				newList.setName(oldList.getName());

				Element prevElement = null;
				for (Element oldElement : oldElements) {
					Element newElement = DoublylinkedlistFactory.eINSTANCE.createElement();
					newElement.setName(oldElement.getName());
					newElement.setTarget(prevElement);
					newElements.add(newElement);
					prevElement = newElement;
				}
				if (prevElement != null) {
					Element firstElement = newElements.get(0);
					firstElement.setTarget(prevElement);
					newList.setHeadElement(firstElement);
				}
				newList.getOwnedElements().addAll(newElements);
				long endTime = System.nanoTime();
				logger.printf("%9.6f\n", (endTime - startTime) / 1.0e9);
				DoublyLinkedListGenerator.checkModel(newList, testSize);
			}
		}
		finally {
			environmentFactory.dispose();
			logger.dispose();
		}
	}

	/*    private Member manualCopy(@NonNull Member oldMember) {
		Member newMember = FamiliesFactory.eINSTANCE.createMember();
		newMember.setFirstName(oldMember.getFirstName());
		return newMember;
	} */
}
