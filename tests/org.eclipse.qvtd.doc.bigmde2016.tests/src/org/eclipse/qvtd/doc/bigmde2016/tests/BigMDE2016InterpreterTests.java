/*******************************************************************************
 * Copyright (c) 2012, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.doc.bigmde2016.tests;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.qvtd.doc.bigmde2016.tests.qvtc.BigMDE2016CGTests;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.BasicQVTiExecutor;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleConstants;
import org.eclipse.qvtd.xtext.qvtcore.tests.QVTcCompilerTests;
import org.junit.Test;

/**
 * Tests that QVTc files can be compiled and executed.
 */
public class BigMDE2016InterpreterTests extends QVTcCompilerTests
{
	@Override
	@Test
	public void testQVTcCompiler_Families2Persons() throws Exception {
		PrintAndLog logger = new PrintAndLog("results/" + getName());
		logger.printf("%s\n", getName());
		//		AbstractTransformer.INVOCATIONS.setState(true);
		MyQVT myQVT = createQVT("Families2Persons", getModelsURI("families2persons/Families2Persons.qvtc"));
		//    	myQVT.getEnvironmentFactory().setEvaluationTracingEnabled(true);
		try {
			ImperativeTransformation asTransformation = myQVT.compileTransformation("person");
			int[] tests = PrintAndLog.getTestSizes();
			for (int testSize : tests) {
				BasicQVTiExecutor interpretedExecutor = myQVT.createInterpretedExecutor(asTransformation);
				myQVT.loadInput("family", getModelsURI("families2persons/samples/Families.xmi"));
				Resource inResource = interpretedExecutor.getModel("family");
				inResource.getContents().clear();
				inResource.getContents().addAll(FamiliesGenerator.createFamiliesModel(testSize, 9));
				myQVT.createModel(QVTscheduleConstants.MIDDLE_DOMAIN_NAME, getTestURI("Families2Persons_trace.xmi"));
				myQVT.createModel("person", getTestURI("Persons_Interpreted.xmi"));
				BigMDE2016CGTests.garbageCollect();
				logger.printf("%9d, ", 10*testSize);
				long startTime = System.nanoTime();
				myQVT.executeTransformation();
				long endTime = System.nanoTime();
				logger.printf("%9.6f\n", (endTime - startTime) / 1.0e9);
				//				myQVT.saveOutput("person", getTestURI("Persons_Interpreted.xmi"), getModelsURI("families2persons/samples/Persons_expected.xmi"), Families2PersonsNormalizer.INSTANCE);
			}
		}
		finally {
			myQVT.dispose();
			logger.dispose();
		}
	}
}
