/*******************************************************************************
 * Copyright (c) 2012, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.doc.bigmde2016.tests.qvtc;

import java.util.Collection;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.qvtd.doc.bigmde2016.tests.FamiliesGenerator;
import org.eclipse.qvtd.doc.bigmde2016.tests.PrintAndLog;
import org.eclipse.qvtd.doc.bigmde2016.tests.qvtc.tx.Families2Persons;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePivotStandaloneSetup;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiTransformationExecutor;
import org.eclipse.qvtd.runtime.evaluation.Transformer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

/**
 * Source code for CG results in BigMDE 2016, Eclipse QVTC First Results paper.
 */
public class BigMDE2016_QVTc_AutomatedTests extends TestCase
{
	public static void garbageCollect() throws InterruptedException {
		for (int y = 0; y < 5; y++) {
			System.gc();
			Thread.sleep(100);
		}
	}

	protected void doTest(@NonNull PrintAndLog logger, @NonNull QVTiEnvironmentFactory environmentFactory, int testSize) throws Exception {
		Iterable<@NonNull ? extends Object> rootObjects = FamiliesGenerator.createFamiliesModel(testSize, 9);
		QVTiTransformationExecutor generatedExecutor = new QVTiTransformationExecutor(environmentFactory, Families2Persons.class);
		Transformer transformer = generatedExecutor.getTransformer();
		transformer.addRootObjects("family", rootObjects);
		garbageCollect();
		logger.printf("%9d, ", 10*testSize);
		long startTime = System.nanoTime();
		transformer.run();
		long endTime = System.nanoTime();
		logger.printf("%9.6f\n", (endTime - startTime) / 1.0e9);
		Collection<@NonNull Object> rootObjects2 = transformer.getRootObjects("person");
		assert rootObjects2.size() == 9*testSize;
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
	public void testQVTcCompiler_Families2Persons_CG_10K() throws Exception {
		PrintAndLog logger = new PrintAndLog(getName());
		logger.printf("%s\n", getName());
		QVTiEnvironmentFactory environmentFactory = new QVTiEnvironmentFactory(ProjectManager.NO_PROJECTS, null);
		try {
			doTest(logger, environmentFactory, 1000);
		}
		finally {
			environmentFactory.dispose();
			logger.dispose();
		}
	}
}
