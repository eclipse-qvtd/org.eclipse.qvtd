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
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EcoreValidator;
import org.eclipse.ocl.lpg.ProblemHandler;
import org.eclipse.qvt.declarative.parser.utils.ProblemLog;

public class ParserErrorTests extends AbstractQVTcTestCase
{	
	public void testParserErrorNoTxName() throws IOException, CoreException {
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.handleProblem(ProblemHandler.Severity.ERROR, ProblemHandler.Phase.PARSER,
				"\"<simpleName>\" expected after \"transformation\"", null, -1, -1);
		String wellFormedProblem = EcorePlugin.INSTANCE.getString("_UI_ENamedElementNameNotWellFormed_diagnostic", new Object[] { "" });
		expectedProblems.handleProblem(ProblemHandler.Severity.ERROR, ProblemHandler.Phase.VALIDATOR,
				wellFormedProblem, EcoreValidator.DIAGNOSTIC_SOURCE, -1, -1);
		problemTest("ParserErrorNoTxName", expectedProblems);
	}
	
	public void testParserErrorSplitTx() throws IOException, CoreException {
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.handleProblem(ProblemHandler.Severity.ERROR, ProblemHandler.Phase.PARSER,
				"merge tokens \"transfor mation\" to form \"transformation\"", null, -1, -1);
		problemTest("ParserErrorSplitTx", expectedProblems);
	}
}
