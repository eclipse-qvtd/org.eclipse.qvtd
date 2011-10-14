/*******************************************************************************
 * Copyright (c) 2007 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.test.parser.qvtcore;

import java.io.IOException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.ocl.lpg.ProblemHandler;
import org.eclipse.qvt.declarative.parser.utils.ProblemLog;

public class AnalyzerErrorTests extends AbstractQVTcTestCase
{
	public void testSemanticErrorUnknownPackage() throws IOException, CoreException {
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.handleProblem(ProblemHandler.Severity.ERROR, ProblemHandler.Phase.ANALYZER,
				"Unknown package 'xyzzy'", "ImportCS", -1, -1);
		problemTest("SemanticErrorUnknownPackage", expectedProblems);
	}
}
