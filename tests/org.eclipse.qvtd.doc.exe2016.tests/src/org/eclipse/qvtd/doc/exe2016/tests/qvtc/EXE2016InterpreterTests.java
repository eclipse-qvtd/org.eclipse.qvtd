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

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.qvtd.doc.exe2016.tests.AbstractEXE2016CGTests;
import org.eclipse.qvtd.doc.exe2016.tests.DoublyLinkedListGenerator;
import org.eclipse.qvtd.doc.exe2016.tests.PrintAndLog;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.BasicQVTiExecutor;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;
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
		DoublyLinkedListGenerator doublyLinkedListGenerator = new DoublyLinkedListGenerator();
		PrintAndLog logger = new PrintAndLog("results/" + getName());
		logger.printf("%s\n", getName());
		//		AbstractTransformer.INVOCATIONS.setState(true);
		MyQVT myQVT = new MyQVT("forward2reverse");
		//    	myQVT.getEnvironmentFactory().setEvaluationTracingEnabled(true);
		try {
			Transformation asTransformation = myQVT.compileTransformation("Forward2Reverse.qvtc", "reverse");
			int[] tests = PrintAndLog.getTestSizes();
			for (int testSize : tests) {
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
				long endTime = System.nanoTime();
				logger.printf("%9.6f\n", (endTime - startTime) / 1.0e9);
				//				myQVT.saveOutput("person", "Persons_Interpreted.xmi", "Persons_expected.xmi", Families2PersonsNormalizer.INSTANCE);
			}
		}
		finally {
			myQVT.dispose();
			logger.dispose();
		}
	}
}
