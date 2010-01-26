/**
* Essential OCL Grammar
* <copyright>
*
* Copyright (c) 2005, 2009 IBM Corporation and others.
* All rights reserved.   This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*   IBM - Initial API and implementation
*   E.D.Willink - Elimination of some shift-reduce conflicts
*   E.D.Willink - Remove unnecessary warning suppression
*   E.D.Willink - Bugs 184048, 225493, 243976, 259818, 282882, 287993, 288040, 292112
*   Borland - Bug 242880
*   Adolfo Sanchez-Barbudo Herrera (Open Canarias):
*        - 242153: LPG v 2.0.17 adoption.
*        - 299396: Introducing new LPG templates
*        - 300534: Removing the use of deprecated macros.
* </copyright>
*
* $Id: QVTcParsersym.java,v 1.13 2010/01/26 22:03:33 ewillink Exp $
*/

package org.eclipse.qvt.declarative.parser.qvtcore;

public interface QVTcParsersym {
    public final static int
      TK_COLON_EQUALS = 56,
      TK_INTEGER_LITERAL = 23,
      TK_REAL_LITERAL = 24,
      TK_STRING_LITERAL = 7,
      TK_PLUS = 33,
      TK_MINUS = 4,
      TK_MULTIPLY = 5,
      TK_DIVIDE = 35,
      TK_GREATER = 41,
      TK_LESS = 42,
      TK_EQUAL = 40,
      TK_GREATER_EQUAL = 43,
      TK_LESS_EQUAL = 44,
      TK_NOT_EQUAL = 47,
      TK_LPAREN = 2,
      TK_RPAREN = 6,
      TK_LBRACE = 48,
      TK_RBRACE = 36,
      TK_LBRACKET = 52,
      TK_RBRACKET = 57,
      TK_ARROW = 37,
      TK_BAR = 46,
      TK_COMMA = 8,
      TK_COLON = 34,
      TK_COLONCOLON = 38,
      TK_SEMICOLON = 45,
      TK_DOT = 39,
      TK_DOTDOT = 65,
      TK_self = 25,
      TK_if = 26,
      TK_then = 66,
      TK_else = 67,
      TK_endif = 58,
      TK_and = 49,
      TK_or = 50,
      TK_xor = 51,
      TK_not = 27,
      TK_implies = 53,
      TK_let = 32,
      TK_in = 55,
      TK_true = 28,
      TK_false = 29,
      TK_null = 30,
      TK_invalid = 31,
      TK_Set = 9,
      TK_Bag = 10,
      TK_Sequence = 11,
      TK_Collection = 12,
      TK_OrderedSet = 13,
      TK_String = 14,
      TK_Integer = 15,
      TK_UnlimitedNatural = 16,
      TK_Real = 17,
      TK_Boolean = 18,
      TK_Tuple = 19,
      TK_OclAny = 20,
      TK_OclVoid = 21,
      TK_OclInvalid = 22,
      TK_check = 68,
      TK_creation = 59,
      TK_default = 54,
      TK_deletion = 60,
      TK_enforce = 61,
      TK_imports = 69,
      TK_map = 62,
      TK_query = 70,
      TK_realize = 63,
      TK_refines = 64,
      TK_transformation = 71,
      TK_uses = 72,
      TK_where = 73,
      TK_EOF_TOKEN = 74,
      TK_IDENTIFIER = 3,
      TK_SINGLE_LINE_COMMENT = 75,
      TK_MULTI_LINE_COMMENT = 76,
      TK_ERROR_TOKEN = 1;

    public final static String orderedTerminalSymbols[] = {
                 "",
                 "ERROR_TOKEN",
                 "LPAREN",
                 "IDENTIFIER",
                 "MINUS",
                 "MULTIPLY",
                 "RPAREN",
                 "STRING_LITERAL",
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
                 "let",
                 "PLUS",
                 "COLON",
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
