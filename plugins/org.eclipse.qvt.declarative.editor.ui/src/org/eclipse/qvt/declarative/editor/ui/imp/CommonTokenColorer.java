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
 * $Id: CommonTokenColorer.java,v 1.3 2009/01/27 21:21:15 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.ui.imp;

import lpg.lpgjavaruntime.IToken;
import lpg.lpgjavaruntime.PrsStream;

import org.eclipse.imp.parser.IParseController;
import org.eclipse.imp.services.ITokenColorer;
import org.eclipse.imp.services.base.TokenColorerBase;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;

public class CommonTokenColorer extends TokenColorerBase implements ITokenColorer, IWorkaroundTokenColorer
{
	protected TextAttribute lineCommentAttribute;
	protected TextAttribute paragraphCommentAttribute;
	protected TextAttribute keywordAttribute;
	protected TextAttribute stringAttribute;
	protected TextAttribute integerAttribute;
	protected TextAttribute realAttribute;
	protected TextAttribute identifierAttribute;

	public CommonTokenColorer() {
		// TODO:  Define text attributes for the various
		// token types that will have their text colored
		Display display = Display.getDefault();
		lineCommentAttribute = new TextAttribute(display.getSystemColor(SWT.COLOR_DARK_GREEN), null, SWT.ITALIC);
		paragraphCommentAttribute = new TextAttribute(display.getSystemColor(SWT.COLOR_BLUE), null, SWT.ITALIC);
		stringAttribute = new TextAttribute(display.getSystemColor(SWT.COLOR_DARK_BLUE), null, SWT.BOLD);
		identifierAttribute = new TextAttribute(display.getSystemColor(SWT.COLOR_BLACK), null, SWT.NORMAL);
		realAttribute = new TextAttribute(display.getSystemColor(SWT.COLOR_DARK_GREEN), null, SWT.BOLD);
		integerAttribute = new TextAttribute(display.getSystemColor(SWT.COLOR_DARK_YELLOW), null, SWT.BOLD);
		keywordAttribute = new TextAttribute(display.getSystemColor(SWT.COLOR_DARK_MAGENTA), null, SWT.BOLD);
	}

	public IRegion calculateDamageExtent(IRegion seed) {
		return seed;
	}
	
	@Override
	public TextAttribute getColoring(IParseController controller, Object token) {
		CommonParseController.TokenKind tokenKind = ((CommonParseController)controller).getTokenKind(((IToken)token).getKind());
		switch (tokenKind) {
		case IDENTIFIER:
			return identifierAttribute;
		case INTEGER:
			return integerAttribute;
		case REAL:
			return realAttribute;
        case STRING:
            return stringAttribute;
        case KEYWORD:
            return keywordAttribute;
        case LINE_COMMENT:
            return lineCommentAttribute;
        case PARAGRAPH_COMMENT:
            return paragraphCommentAttribute;
		default:
			return super.getColoring(controller, token);
		}
	}

	@Override
	public TextAttribute getInterColoring(IParseController controller, Object prevToken, Object nextToken) {
		IToken preToken = (IToken)prevToken;
		IToken postToken = (IToken)nextToken;
		PrsStream prsStream = preToken != null ? preToken.getPrsStream() : postToken != null ? postToken.getPrsStream() : null;
		if (prsStream == null)
			return null;
		int startOffset = preToken != null ? preToken.getEndOffset()+1 : 0;
		char[] inputChars = prsStream.getInputChars();
		int size = inputChars.length;
		if (startOffset >= size)
			return null;
		int endOffset = postToken != null ? postToken.getStartOffset()-1 : size-1;
		String interChars = new String(inputChars, startOffset, endOffset - startOffset + 1);
		return getInterColoring(interChars);
	}

	protected TextAttribute getInterColoring(String interChars) {
		if (interChars.trim().contains("\n"))
			return paragraphCommentAttribute;
		else
			return lineCommentAttribute;
	}
}
