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

public abstract class LexerErrorTests extends AbstractQVTcTestCase
{
	// FIXME The loose $ is no longer a lexer error - need a new test model
	public void testLexerErrorUnexpectedCharacter() throws IOException, CoreException {
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.handleProblem(ProblemHandler.Severity.ERROR, ProblemHandler.Phase.VALIDATOR,
				"Unknown package 'xyzzy'", null, -1, -1);
		problemTest("LexerErrorUnexpectedCharacter", expectedProblems);
//		assertEquals("Error count", 1, lexerErrors.size());
//		LexerError error = lexerErrors.get(0);
//		assertEquals("Error code", ParseErrorCodes.LEX_ERROR_CODE, error.errorCode);
//		assertEquals("Error position", error.rightToken, error.rightToken);
	}
}
