/*******************************************************************************
 * Copyright (c) 2016, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.doc.exe2016.tests.qvtc;

import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.qvtd.doc.exe2016.tests.DoublyLinkedListGenerator;
import org.eclipse.qvtd.doc.exe2016.tests.PrintAndLog;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeEnvironmentStrategy;
import org.junit.Test;

/**
 * Source code for CG results in EXE 2016, Micro-Mappings paper.
 */
public class EXE2016_QVTc_Tests extends EXE2016_QVTc_AutomatedTests
{
	@Test
	public void testQVTcCompiler_Forward2Reverse_CG() throws Exception {
		DoublyLinkedListGenerator doublyLinkedListGenerator = new DoublyLinkedListGenerator();
		PrintAndLog logger = new PrintAndLog(getName());
		logger.printf("%s\n", getName());
		QVTimperativeEnvironmentFactory environmentFactory = new QVTimperativeEnvironmentFactory(ProjectManager.NO_PROJECTS, null, QVTimperativeEnvironmentStrategy.INSTANCE);
		try {
			int[] tests = PrintAndLog.getTestSizes();
			for (int testSize : tests) {
				doTest(logger, environmentFactory, doublyLinkedListGenerator, testSize);
			}
		}
		finally {
			environmentFactory.dispose();
			logger.dispose();
		}
	}
}
