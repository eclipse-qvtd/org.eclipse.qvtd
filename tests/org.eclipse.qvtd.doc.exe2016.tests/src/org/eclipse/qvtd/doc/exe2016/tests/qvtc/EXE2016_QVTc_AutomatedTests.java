/*******************************************************************************
 * Copyright (c) 2016, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.doc.exe2016.tests.qvtc;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.qvtd.doc.exe2016.tests.AbstractEXE2016CGTests;
import org.eclipse.qvtd.doc.exe2016.tests.DoublyLinkedListGenerator;
import org.eclipse.qvtd.doc.exe2016.tests.PrintAndLog;
import org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.DoublyLinkedList;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePivotStandaloneSetup;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiTransformationExecutor;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeEnvironmentStrategy;
import org.eclipse.qvtd.runtime.evaluation.Transformer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Source code for CG results in EXE 2016, Micro-Mappings paper.
 */
public class EXE2016_QVTc_AutomatedTests extends AbstractEXE2016CGTests
{
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

	protected void doTest(@NonNull PrintAndLog logger, @NonNull QVTimperativeEnvironmentFactory environmentFactory,
			@NonNull DoublyLinkedListGenerator doublyLinkedListGenerator, int testSize) throws Exception {
		Iterable<@NonNull ? extends Object> rootObjects = doublyLinkedListGenerator.createDoublyLinkedListModel(testSize);
		Class<@NonNull Forward2Reverse> txClass = Forward2Reverse.class;
		QVTiTransformationExecutor generatedExecutor = new QVTiTransformationExecutor(environmentFactory, txClass);
		Transformer transformer = generatedExecutor.getTransformer();
		transformer.getTypedModelInstance("forward").addRootObjects(rootObjects);
		garbageCollect();
		logger.printf("%9d, ", testSize);
		long startTime = System.nanoTime();
		transformer.analyzeInputResources();
		transformer.run();
		long endTime = System.nanoTime();
		logger.printf("%9.6f\n", (endTime - startTime) / 1.0e9);
		Collection<@NonNull EObject> rootObjects2 = transformer.getTypedModelInstance("reverse").getRootEObjects();
		Iterator<EObject> it = rootObjects2.iterator();
		Object rootObject = it.next();
		assert !it.hasNext();
		assert ((DoublyLinkedList)rootObject).getOwnedElements().size() == testSize-1;
		doublyLinkedListGenerator.checkModel((DoublyLinkedList) rootObject, testSize);
	}

	@Test
	public void testQVTcCompiler_Forward2Reverse_CG_10K() throws Exception {
		DoublyLinkedListGenerator doublyLinkedListGenerator = new DoublyLinkedListGenerator();
		PrintAndLog logger = new PrintAndLog(getName());
		logger.printf("%s\n", getName());
		QVTimperativeEnvironmentFactory environmentFactory = new QVTimperativeEnvironmentFactory(ProjectManager.NO_PROJECTS, null, QVTimperativeEnvironmentStrategy.INSTANCE);
		try {
			doTest(logger, environmentFactory, doublyLinkedListGenerator, 10000);
		}
		finally {
			environmentFactory.dispose();
			logger.dispose();
		}
	}
}
