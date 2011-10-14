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
 * $Id: OCLParseController.java,v 1.7 2010/01/26 22:03:12 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.ocl.ui.imp;

import org.eclipse.ocl.cst.CSTPackage;
import org.eclipse.ocl.parser.backtracking.OCLBacktrackingParsersym;
import org.eclipse.qvt.declarative.editor.ocl.ui.OCLCreationFactory;
import org.eclipse.qvt.declarative.editor.ui.imp.CommonKeyword;
import org.eclipse.qvt.declarative.editor.ui.imp.CommonParseController;
import org.eclipse.qvt.declarative.editor.ui.imp.ICommonKeyword;

public class OCLParseController extends CommonParseController
{
	public static final String[] oclIteratorKeywords = new String[] {
		"iterate",
		"forAll",
		"exists",
		"isUnique",
		"any",
		"one",
		"collect",
		"select",
		"reject",
		"collectNested",
		"sortedBy",
		"closure"
	};
	
	public static final String[] oclIdentifierKeywords = new String[] {
		"attr",
		"oper",

		"allInstances",
		"oclIsKindOf",
		"oclIsTypeOf",
		"oclAsType",
		"oclIsNew",
		"oclIsUndefined",
		"oclIsInvalid",
		"oclIsInState",
		
		"body",
		"derive",
		"init",
		
		"Set",
		"Bag",
		"Sequence",
		"Collection",
		"OrderedSet",
		
		"String",
		"Integer",
		"UnlimitedNatural",
		"Real",
		"Boolean",
		"Tuple",
		"OclAny",
		"OclVoid",
		"Invalid",
		"OclMessage",

		"OclInvalid"		
	};

	public static ICommonKeyword createOCLKeyword(String text) {
		for (String s : oclIteratorKeywords)
			if (s.equals(text))
				return new CommonKeyword.Identifier(text);
		for (String s : oclIdentifierKeywords)
			if (s.equals(text))
				return new CommonKeyword.Identifier(text);
		return null;
	}
	
	public OCLParseController() {
		super(OCLCreationFactory.INSTANCE);
		CSTPackage.eINSTANCE.getClass();
	}

	@Override
	protected ICommonKeyword createKeyword(String text) {
		ICommonKeyword keyword = createOCLKeyword(text);
		return keyword != null ? keyword : super.createKeyword(text);
	}

	public TokenKind getTokenKind(int kind) {
		switch (kind) {
		case OCLBacktrackingParsersym.TK_EOF_TOKEN:
			return TokenKind.EOF;
		case OCLBacktrackingParsersym.TK_IDENTIFIER:
			return TokenKind.IDENTIFIER;
		case OCLBacktrackingParsersym.TK_INTEGER_LITERAL:
			return TokenKind.INTEGER;
		case OCLBacktrackingParsersym.TK_REAL_LITERAL:
			return TokenKind.REAL;
        case OCLBacktrackingParsersym.TK_STRING_LITERAL:
            return TokenKind.STRING;
        case OCLBacktrackingParsersym.TK_SINGLE_LINE_COMMENT:
            return TokenKind.LINE_COMMENT;
        case OCLBacktrackingParsersym.TK_MULTI_LINE_COMMENT:
            return TokenKind.PARAGRAPH_COMMENT;
		default:
			if (isKeyword(kind))
				return TokenKind.KEYWORD;
			return TokenKind.OTHER;
		}
	}
}
