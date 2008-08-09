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
 * $Id: QVTcTokenColorer.java,v 1.1 2008/08/09 17:55:46 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.qvtcore.ui.imp.tokenColorer;

import lpg.lpgjavaruntime.IToken;

import org.eclipse.imp.parser.IParseController;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.qvt.declarative.editor.qvtcore.ui.imp.parser.QVTcParseController;
import org.eclipse.qvt.declarative.editor.ui.imp.CommonTokenColorer;
import org.eclipse.qvt.declarative.parser.qvtcore.QVTcParsersym;

public class QVTcTokenColorer extends CommonTokenColorer implements QVTcParsersym
{
	public TextAttribute getColoring(IParseController controller, Object o) {
		IToken token = (IToken) o;
		if (token.getKind() == TK_EOF_TOKEN)
			return null;
		switch (token.getKind()) {
		case TK_IDENTIFIER:
			return identifierAttribute;
		case TK_INTEGER_LITERAL:
			return numberAttribute;
		case TK_REAL_LITERAL:
			return doubleAttribute;
        case TK_STRING_LITERAL:
             return stringAttribute;
		default:
			if (((QVTcParseController) controller).isKeyword(token.getKind()))
				return keywordAttribute;
			return super.getColoring(controller, token);
		}
	}
}
