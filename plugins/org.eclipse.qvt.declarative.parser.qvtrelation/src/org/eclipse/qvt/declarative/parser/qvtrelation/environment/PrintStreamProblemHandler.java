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
package org.eclipse.qvt.declarative.parser.qvtrelation.environment;

import java.io.File;
import java.io.PrintStream;

import org.eclipse.ocl.lpg.AbstractParser;
import org.eclipse.ocl.lpg.AbstractProblemHandler;

public class PrintStreamProblemHandler extends AbstractProblemHandler
{
	private final File file;
	private final PrintStream stream;

	public PrintStreamProblemHandler(AbstractParser parser, File file, PrintStream stream) {
		super(parser);
		this.file = file;
		this.stream = stream;
	}

	@Override public void handleProblem(Severity problemSeverity, Phase processingPhase,
			String problemMessage, String processingContext, int startOffset, int endOffset) {
		int lineNumber = getParser().getIPrsStream().getTokenAtCharacter(startOffset).getLine();
		stream.println(file.getName() + ":" + lineNumber + ": " + String.valueOf(processingPhase) + "-" + String.valueOf(problemSeverity) + ": " + problemMessage + ": " + getParser().computeInputString(startOffset, endOffset));
	}
}
