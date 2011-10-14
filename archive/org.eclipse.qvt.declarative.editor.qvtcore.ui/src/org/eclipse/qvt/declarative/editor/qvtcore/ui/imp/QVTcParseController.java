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
 * $Id: QVTcParseController.java,v 1.7 2010/01/26 22:03:08 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.qvtcore.ui.imp;

import org.eclipse.qvt.declarative.editor.ocl.ui.imp.OCLParseController;
import org.eclipse.qvt.declarative.editor.qvtcore.ui.QVTcCreationFactory;
import org.eclipse.qvt.declarative.editor.ui.imp.CommonParseController;
import org.eclipse.qvt.declarative.editor.ui.imp.ICommonKeyword;
import org.eclipse.qvt.declarative.parser.qvtcore.QVTcParsersym;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.QVTcCSTPackage;

public class QVTcParseController extends CommonParseController
{
	public QVTcParseController() {
		super(QVTcCreationFactory.INSTANCE);
		QVTcCSTPackage.eINSTANCE.getClass();
	}

	@Override
	protected ICommonKeyword createKeyword(String text) {
		ICommonKeyword keyword = OCLParseController.createOCLKeyword(text);
		return keyword != null ? keyword : super.createKeyword(text);
	}

	public TokenKind getTokenKind(int kind) {
		switch (kind) {
		case QVTcParsersym.TK_EOF_TOKEN:
			return TokenKind.EOF;
		case QVTcParsersym.TK_IDENTIFIER:
			return TokenKind.IDENTIFIER;
		case QVTcParsersym.TK_INTEGER_LITERAL:
			return TokenKind.INTEGER;
		case QVTcParsersym.TK_REAL_LITERAL:
			return TokenKind.REAL;
        case QVTcParsersym.TK_STRING_LITERAL:
             return TokenKind.STRING;
        case QVTcParsersym.TK_SINGLE_LINE_COMMENT:
            return TokenKind.LINE_COMMENT;
        case QVTcParsersym.TK_MULTI_LINE_COMMENT:
            return TokenKind.PARAGRAPH_COMMENT;
		default:
			if (isKeyword(kind))
				return TokenKind.KEYWORD;
			return TokenKind.OTHER;
		}
	}
}
