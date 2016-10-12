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
package org.eclipse.qvtd.doc.exe2016.tests.qvtr;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.doc.exe2016.tests.AbstractDoublyLinkedListGenerator;
import org.eclipse.qvtd.doc.exe2016.tests.AbstractEXE2016CGTests;
import org.eclipse.qvtd.doc.exe2016.tests.PrintAndLog;
import org.eclipse.qvtd.doc.exe2016.tests.qvtr.doublylinkedlist.DoublyLinkedList;
import org.eclipse.qvtd.doc.exe2016.tests.qvtr.doublylinkedlist.Element;
import org.eclipse.qvtd.doc.exe2016.tests.qvtr.doublylinkedlist.doublylinkedlistFactory;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePivotStandaloneSetup;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiTransformationExecutor;
import org.eclipse.qvtd.runtime.evaluation.Transformer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Source code for CG results in EXE 2016, Micro-Mappings paper (subset used as part of overall QVTd test suite)
 */
public class EXE2016_QVTr_AutomatedTests extends AbstractEXE2016CGTests
{
	public static class DoublyLinkedListGenerator extends AbstractDoublyLinkedListGenerator<@NonNull DoublyLinkedList, @NonNull Element>
	{
		@Override
		@SuppressWarnings("null")
		protected @NonNull DoublyLinkedList createDoublyLinkedList() {
			return doublylinkedlistFactory.eINSTANCE.createDoublyLinkedList();
		}

		@Override
		@SuppressWarnings("null")
		protected @NonNull Element createElement() {
			return doublylinkedlistFactory.eINSTANCE.createElement();
		}

		@Override
		protected @Nullable Element getHeadElement(@NonNull DoublyLinkedList list) {
			return list.getHeadElement();
		}

		@Override
		protected String getElementName(@NonNull Element element) {
			return element.getName();
		}

		@Override
		protected String getListName(@NonNull DoublyLinkedList list) {
			return list.getName();
		}

		@Override
		protected @NonNull List<@NonNull Element> getOwnedElements(@NonNull DoublyLinkedList list) {
			return ClassUtil.nullFree(list.getOwnedElements());
		}

		@SuppressWarnings("null")
		@Override
		protected @NonNull Element getSource(@NonNull Element element) {
			return element.getSource();
		}

		@SuppressWarnings("null")
		@Override
		protected @NonNull Element getTarget(@NonNull Element element) {
			return element.getTarget();
		}

		@Override
		protected void setElementName(@NonNull Element element, String name) {
			element.setName(name);
		}

		@Override
		protected void setHeadElement(@NonNull DoublyLinkedList list, @NonNull Element element) {
			list.setHeadElement(element);
		}

		@Override
		protected void setListName(@NonNull DoublyLinkedList list, String name) {
			list.setName(name);
		}

		@Override
		protected void setSource(@NonNull Element element, @NonNull Element source) {
			element.setSource(source);
		}

		@Override
		protected void setTarget(@NonNull Element element, @NonNull Element target) {
			element.setTarget(target);
		}
	}

	protected void doTest(@NonNull PrintAndLog logger, @NonNull QVTiEnvironmentFactory environmentFactory,
			@NonNull DoublyLinkedListGenerator doublyLinkedListGenerator, int testSize) throws Exception {
		Iterable<@NonNull ? extends Object> rootObjects = doublyLinkedListGenerator.createDoublyLinkedListModel(testSize);
		Class<@NonNull Forward2Reverse> txClass = Forward2Reverse.class;
		QVTiTransformationExecutor generatedExecutor = new QVTiTransformationExecutor(environmentFactory, txClass);
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
		doublyLinkedListGenerator.checkModel((DoublyLinkedList) rootObject, testSize);
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
	public void testQVTrCompiler_Forward2Reverse_CG_10K() throws Exception {
		DoublyLinkedListGenerator doublyLinkedListGenerator = new DoublyLinkedListGenerator();
		PrintAndLog logger = new PrintAndLog(getName());
		logger.printf("%s\n", getName());
		QVTiEnvironmentFactory environmentFactory = new QVTiEnvironmentFactory(ProjectManager.NO_PROJECTS, null);
		try {
			doTest(logger, environmentFactory, doublyLinkedListGenerator, 10000);
		}
		finally {
			environmentFactory.dispose();
			logger.dispose();
		}
	}
}
