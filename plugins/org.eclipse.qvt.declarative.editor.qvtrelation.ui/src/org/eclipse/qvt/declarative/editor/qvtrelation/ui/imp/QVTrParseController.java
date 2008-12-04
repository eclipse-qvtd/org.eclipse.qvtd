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
 * $Id: QVTrParseController.java,v 1.4 2008/12/04 07:51:27 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.qvtrelation.ui.imp;

import org.eclipse.qvt.declarative.editor.ocl.ui.imp.OCLParseController;
import org.eclipse.qvt.declarative.editor.qvtrelation.ui.QVTrCreationFactory;
import org.eclipse.qvt.declarative.editor.ui.imp.CommonParseController;
import org.eclipse.qvt.declarative.editor.ui.imp.ICommonKeyword;
import org.eclipse.qvt.declarative.parser.qvtrelation.QVTrLexer;
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

	@Override
	public TokenKind getTokenKind(int kind) {
		switch (kind) {
		case QVTrLexer.TK_EOF_TOKEN:
			return TokenKind.EOF;
		case QVTrLexer.TK_IDENTIFIER:
			return TokenKind.IDENTIFIER;
		case QVTrLexer.TK_INTEGER_LITERAL:
			return TokenKind.INTEGER;
		case QVTrLexer.TK_REAL_LITERAL:
			return TokenKind.REAL;
        case QVTrLexer.TK_STRING_LITERAL:
             return TokenKind.STRING;
		default:
			if (isKeyword(kind))
				return TokenKind.KEYWORD;
			return TokenKind.OTHER;
		}
	}
}
