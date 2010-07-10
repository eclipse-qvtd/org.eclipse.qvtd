/**
* Essential OCL Grammar
* <copyright>
*
* Copyright (c) 2005, 2010 IBM Corporation and others.
* All rights reserved.   This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*   IBM - Initial API and implementation
*   E.D.Willink - Elimination of some shift-reduce conflicts
*   E.D.Willink - Remove unnecessary warning suppression
*   E.D.Willink - Bugs 184048, 225493, 243976, 259818, 282882, 287993, 288040, 292112, 295166
*   Borland - Bug 242880
*   Adolfo Sanchez-Barbudo Herrera (Open Canarias):
*        - 242153: LPG v 2.0.17 adoption.
*        - 299396: Introducing new LPG templates
*        - 300534: Removing the use of deprecated macros.
* </copyright>
*
* $Id: QVTcParsersym.java,v 1.15 2010/07/10 09:34:36 ewillink Exp $
*/

package org.eclipse.qvt.declarative.parser.qvtcore;

public interface QVTcParsersym {
    public final static int
      TK_COLON_EQUALS = 57,
      TK_QUOTED_IDENTIFIER = 3,
      TK_INTEGER_LITERAL = 24,
      TK_REAL_LITERAL = 25,
      TK_STRING_LITERAL = 5,
      TK_PLUS = 35,
      TK_MINUS = 6,
      TK_MULTIPLY = 7,
      TK_DIVIDE = 36,
      TK_GREATER = 42,
      TK_LESS = 43,
      TK_EQUAL = 41,
      TK_GREATER_EQUAL = 44,
      TK_LESS_EQUAL = 45,
      TK_NOT_EQUAL = 48,
      TK_LPAREN = 2,
      TK_RPAREN = 8,
      TK_LBRACE = 49,
      TK_RBRACE = 37,
      TK_LBRACKET = 53,
      TK_RBRACKET = 58,
      TK_ARROW = 38,
      TK_BAR = 47,
      TK_COMMA = 9,
      TK_COLON = 33,
      TK_COLONCOLON = 39,
      TK_SEMICOLON = 46,
      TK_DOT = 40,
      TK_DOTDOT = 66,
      TK_self = 26,
      TK_if = 27,
      TK_then = 67,
      TK_else = 68,
      TK_endif = 59,
      TK_and = 50,
      TK_or = 51,
      TK_xor = 52,
      TK_not = 28,
      TK_implies = 54,
      TK_let = 34,
      TK_in = 56,
      TK_true = 29,
      TK_false = 30,
      TK_null = 31,
      TK_invalid = 32,
      TK_Set = 10,
      TK_Bag = 11,
      TK_Sequence = 12,
      TK_Collection = 13,
      TK_OrderedSet = 14,
      TK_String = 15,
      TK_Integer = 16,
      TK_UnlimitedNatural = 17,
      TK_Real = 18,
      TK_Boolean = 19,
      TK_Tuple = 20,
      TK_OclAny = 21,
      TK_OclVoid = 22,
      TK_OclInvalid = 23,
      TK_check = 69,
      TK_creation = 60,
      TK_default = 55,
      TK_deletion = 61,
      TK_enforce = 62,
      TK_imports = 70,
      TK_map = 63,
      TK_query = 71,
      TK_realize = 64,
      TK_refines = 65,
      TK_transformation = 72,
      TK_uses = 73,
      TK_where = 74,
      TK_EOF_TOKEN = 75,
      TK_IDENTIFIER = 4,
      TK_SINGLE_LINE_COMMENT = 76,
      TK_MULTI_LINE_COMMENT = 77,
      TK_ERROR_TOKEN = 1;

    public final static String orderedTerminalSymbols[] = {
                 "",
                 "ERROR_TOKEN",
                 "LPAREN",
                 "QUOTED_IDENTIFIER",
                 "IDENTIFIER",
                 "STRING_LITERAL",
                 "MINUS",
                 "MULTIPLY",
                 "RPAREN",
                 "COMMA",
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
                 "OclInvalid",
                 "INTEGER_LITERAL",
                 "REAL_LITERAL",
                 "self",
                 "if",
                 "not",
                 "true",
                 "false",
                 "null",
                 "invalid",
                 "COLON",
                 "let",
                 "PLUS",
                 "DIVIDE",
                 "RBRACE",
                 "ARROW",
                 "COLONCOLON",
                 "DOT",
                 "EQUAL",
                 "GREATER",
                 "LESS",
                 "GREATER_EQUAL",
                 "LESS_EQUAL",
                 "SEMICOLON",
                 "BAR",
                 "NOT_EQUAL",
                 "LBRACE",
                 "and",
                 "or",
                 "xor",
                 "LBRACKET",
                 "implies",
                 "default",
                 "in",
                 "COLON_EQUALS",
                 "RBRACKET",
                 "endif",
                 "creation",
                 "deletion",
                 "enforce",
                 "map",
                 "realize",
                 "refines",
                 "DOTDOT",
                 "then",
                 "else",
                 "check",
                 "imports",
                 "query",
                 "transformation",
                 "uses",
                 "where",
                 "EOF_TOKEN",
                 "SINGLE_LINE_COMMENT",
                 "MULTI_LINE_COMMENT"
             };

    public final static int numTokenKinds = orderedTerminalSymbols.length;
    public final static boolean isValidForParser = true;
}
