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

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.qvtd.doc.exe2016.tests.AbstractEXE2016CGTests;
import org.eclipse.qvtd.doc.exe2016.tests.DoublyLinkedListGenerator;
import org.eclipse.qvtd.doc.exe2016.tests.PrintAndLog;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePivotStandaloneSetup;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiTransformationExecutor;
import org.eclipse.qvtd.runtime.evaluation.Transformer;
import org.eclipse.qvtd.xtext.qvtcore.tests.list2list.doublylinkedlist.DoublyLinkedList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Source code for CG results in EXE 2016, Micro-Mappings paper.
 */
public class EXE2016_QVTc_Tests extends AbstractEXE2016CGTests
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

	@Test
	public void testQVTcCompiler_Forward2Reverse_CG() throws Exception {
		DoublyLinkedListGenerator doublyLinkedListGenerator = new DoublyLinkedListGenerator();
		PrintAndLog logger = new PrintAndLog(getName());
		logger.printf("%s\n", getName());
		QVTiEnvironmentFactory environmentFactory = new QVTiEnvironmentFactory(ProjectManager.NO_PROJECTS, null);
		try {
			int[] tests = PrintAndLog.getTestSizes();
			for (int testSize : tests) {
				Iterable<@NonNull ? extends Object> rootObjects = doublyLinkedListGenerator.createDoublyLinkedListModel(testSize);
				Class<cg.org.eclipse.qvtd.xtext.qvtcore.tests.forward2reverse.@NonNull Forward2Reverse> txClass = cg.org.eclipse.qvtd.xtext.qvtcore.tests.forward2reverse.Forward2Reverse.class;
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
		}
		finally {
			environmentFactory.dispose();
			logger.dispose();
		}
	}
}
