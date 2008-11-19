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
 * $Id: CommonProblemHandler.java,v 1.4 2008/11/19 21:51:42 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.ui.imp;

import lpg.lpgjavaruntime.IToken;

import org.eclipse.core.resources.IMarker;
import org.eclipse.imp.parser.IMessageHandler;
import org.eclipse.ocl.lpg.AbstractParser;
import org.eclipse.ocl.lpg.AbstractProblemHandler;
import org.eclipse.qvt.declarative.editor.ui.QVTEditorPlugin;
import org.eclipse.qvt.declarative.editor.ui.builder.MarkerProblemHandler;
import org.eclipse.qvt.declarative.editor.ui.builder.ProblemLimit;

/**
 * A CommonProblemHandler arranges for errors, reported via the MDT OCL
 * ProblemHandler API, to be redirected to an IMP IMessageHandler.  
 */
public class CommonProblemHandler extends AbstractProblemHandler
{
	protected final IMessageHandler handler;
	private ProblemLimit problemLimit = null;
	
	public CommonProblemHandler(AbstractParser parser, IMessageHandler handler) {
		super(parser);
		this.handler = handler;
		handler.clearMessages();
	}

	@Override
	public void handleProblem(Severity problemSeverity,
			Phase processingPhase, String problemMessage,
			String processingContext, int startOffset, int endOffset) {
		try {
			if (startOffset < 0)
				startOffset = 0;
			if (endOffset < 0)
				endOffset = 0;
			IToken startToken = getParser().getTokenAtCharacter(startOffset);
			IToken endToken = getParser().getTokenAtCharacter(endOffset);
			int startLine = startToken.getLine();
			int startCol = startToken.getColumn();
			int endLine = endToken.getLine();
			int endCol = endToken.getColumn();
			String adjustedMessage = problemMessage;
			if (problemLimit != null) {
				Integer severity = MarkerProblemHandler.severityMap.get(problemSeverity);
				adjustedMessage = problemLimit.check(severity != null ? severity.intValue() : IMarker.SEVERITY_ERROR, adjustedMessage);
				if (adjustedMessage == null)
					return;
			}
			// FIXME Get Annotation to display alternate severities
			String prefixedMessage = problemSeverity != null ? (problemSeverity.name() + ": " + problemMessage) : problemMessage;
			handler.handleSimpleMessage(prefixedMessage, startOffset, endOffset,
		            startCol, endCol, startLine, endLine);
			if (adjustedMessage != problemMessage)
				throw new ProblemLimit.LimitExceededException(adjustedMessage);
		} catch(Throwable e) {
			QVTEditorPlugin.logError("Failed to handleProblem", e);
		}
	}		
	
	public void setProblemLimit(ProblemLimit problemLimit) {
		this.problemLimit = problemLimit;
	}
}