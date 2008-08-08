/**
 * <copyright>
 * 
 * Copyright (c) 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: CommonProblemHandler.java,v 1.1 2008/08/08 16:42:46 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.ui.imp;

import org.eclipse.imp.parser.IMessageHandler;
import org.eclipse.ocl.lpg.AbstractParser;
import org.eclipse.ocl.lpg.AbstractProblemHandler;

/**
 * A CommonProblemHandler arranges for errors, reported via the MDT OCL
 * ProblemHandler API, to be redirected to an IMP IMessageHandler.  
 */
public class CommonProblemHandler extends AbstractProblemHandler
{
	protected final IMessageHandler handler;
	
	public CommonProblemHandler(AbstractParser parser, IMessageHandler handler) {
		super(parser);
		this.handler = handler;
		handler.clearMessages();
	}

	@Override
	public void handleProblem(Severity problemSeverity,
			Phase processingPhase, String problemMessage,
			String processingContext, int startOffset, int endOffset) {
		int startLine = getParser().getTokenAtCharacter(startOffset).getLine();
		int startCol = getParser().getTokenAtCharacter(startOffset).getColumn();
		int endLine = getParser().getTokenAtCharacter(endOffset).getLine();
		int endCol = getParser().getTokenAtCharacter(startOffset).getColumn();
		handler.handleSimpleMessage(problemMessage, startOffset, endOffset,
	            startCol, endCol, startLine, endLine);
	}		
}