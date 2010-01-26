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
 * $Id: QVTrParseController.java,v 1.7 2010/01/26 22:03:42 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.qvtrelation.ui.imp;

import org.eclipse.qvt.declarative.editor.ocl.ui.imp.OCLParseController;
import org.eclipse.qvt.declarative.editor.qvtrelation.ui.QVTrCreationFactory;
import org.eclipse.qvt.declarative.editor.ui.imp.CommonParseController;
import org.eclipse.qvt.declarative.editor.ui.imp.ICommonKeyword;
import org.eclipse.qvt.declarative.parser.qvtrelation.QVTrParsersym;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.QVTrCSTPackage;

public class QVTrParseController extends CommonParseController
{
	public QVTrParseController() {
		super(QVTrCreationFactory.INSTANCE);
		QVTrCSTPackage.eINSTANCE.getClass();
	}

	@Override
	protected ICommonKeyword createKeyword(String text) {
		ICommonKeyword keyword = OCLParseController.createOCLKeyword(text);
		return keyword != null ? keyword : super.createKeyword(text);
	}

	public TokenKind getTokenKind(int kind) {
		switch (kind) {
		case QVTrParsersym.TK_EOF_TOKEN:
			return TokenKind.EOF;
		case QVTrParsersym.TK_IDENTIFIER:
			return TokenKind.IDENTIFIER;
		case QVTrParsersym.TK_INTEGER_LITERAL:
			return TokenKind.INTEGER;
		case QVTrParsersym.TK_REAL_LITERAL:
			return TokenKind.REAL;
        case QVTrParsersym.TK_STRING_LITERAL:
             return TokenKind.STRING;
        case QVTrParsersym.TK_SINGLE_LINE_COMMENT:
            return TokenKind.LINE_COMMENT;
        case QVTrParsersym.TK_MULTI_LINE_COMMENT:
            return TokenKind.PARAGRAPH_COMMENT;
		default:
			if (isKeyword(kind))
				return TokenKind.KEYWORD;
			return TokenKind.OTHER;
		}
	}
}
