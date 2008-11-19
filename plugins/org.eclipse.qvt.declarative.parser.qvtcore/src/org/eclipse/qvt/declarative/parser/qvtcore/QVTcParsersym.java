/**
* <copyright>
*
* Copyright (c) 2005, 2008 IBM Corporation, Zeligsoft Inc., and others.
* All rights reserved.   This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*   IBM - Initial API and implementation
*   E.D.Willink - Elimination of some shift-reduce conflicts
*   E.D.Willink - Remove unnecessary warning suppression
*   E.D.Willink - Bugs 225493, 243976
*   Zeligsoft - Bug 243976
*   E.D.Willink - Extended API and implementation for QVTc
*
* </copyright>
*
* $Id: QVTcParsersym.java,v 1.7 2008/11/19 21:37:41 ewillink Exp $
*/

package org.eclipse.qvt.declarative.parser.qvtcore;

public interface QVTcParsersym {
    public final static int
      TK_COLON_EQUALS = 94,
      TK_NUMERIC_OPERATION = 76,
      TK_STRING_LITERAL = 16,
      TK_INTEGER_LITERAL = 77,
      TK_REAL_LITERAL = 78,
      TK_PLUS = 17,
      TK_MINUS = 22,
      TK_MULTIPLY = 7,
      TK_DIVIDE = 8,
      TK_GREATER = 9,
      TK_LESS = 10,
      TK_EQUAL = 5,
      TK_GREATER_EQUAL = 11,
      TK_LESS_EQUAL = 12,
      TK_NOT_EQUAL = 6,
      TK_LPAREN = 2,
      TK_RPAREN = 4,
      TK_LBRACE = 87,
      TK_RBRACE = 84,
      TK_LBRACKET = 104,
      TK_RBRACKET = 91,
      TK_ARROW = 95,
      TK_BAR = 85,
      TK_COMMA = 34,
      TK_COLON = 92,
      TK_COLONCOLON = 88,
      TK_SEMICOLON = 86,
      TK_DOT = 96,
      TK_DOTDOT = 99,
      TK_ATPRE = 89,
      TK_CARET = 97,
      TK_CARETCARET = 98,
      TK_QUESTIONMARK = 105,
      TK_self = 44,
      TK_inv = 29,
      TK_pre = 30,
      TK_post = 31,
      TK_context = 112,
      TK_package = 113,
      TK_endpackage = 32,
      TK_def = 33,
      TK_if = 83,
      TK_then = 100,
      TK_else = 101,
      TK_endif = 93,
      TK_and = 13,
      TK_or = 14,
      TK_xor = 15,
      TK_not = 74,
      TK_implies = 102,
      TK_let = 82,
      TK_in = 90,
      TK_true = 79,
      TK_false = 80,
      TK_body = 50,
      TK_derive = 51,
      TK_init = 52,
      TK_null = 53,
      TK_attr = 114,
      TK_oper = 115,
      TK_Set = 45,
      TK_Bag = 46,
      TK_Sequence = 47,
      TK_Collection = 48,
      TK_OrderedSet = 49,
      TK_iterate = 54,
      TK_forAll = 55,
      TK_exists = 56,
      TK_isUnique = 57,
      TK_any = 58,
      TK_one = 59,
      TK_collect = 60,
      TK_select = 61,
      TK_reject = 62,
      TK_collectNested = 63,
      TK_sortedBy = 64,
      TK_closure = 65,
      TK_oclIsKindOf = 67,
      TK_oclIsTypeOf = 68,
      TK_oclAsType = 69,
      TK_oclIsNew = 70,
      TK_oclIsUndefined = 71,
      TK_oclIsInvalid = 72,
      TK_oclIsInState = 73,
      TK_allInstances = 66,
      TK_String = 35,
      TK_Integer = 36,
      TK_UnlimitedNatural = 37,
      TK_Real = 38,
      TK_Boolean = 39,
      TK_Tuple = 75,
      TK_OclAny = 40,
      TK_OclVoid = 41,
      TK_Invalid = 42,
      TK_OclMessage = 43,
      TK_OclInvalid = 81,
      TK_check = 23,
      TK_creation = 108,
      TK_default = 107,
      TK_deletion = 109,
      TK_enforce = 18,
      TK_imports = 24,
      TK_map = 19,
      TK_query = 25,
      TK_realize = 20,
      TK_refines = 21,
      TK_transformation = 26,
      TK_uses = 27,
      TK_where = 28,
      TK_EOF_TOKEN = 110,
      TK_IDENTIFIER = 3,
      TK_INTEGER_RANGE_START = 106,
      TK_ERROR_TOKEN = 1,
      TK_ERROR_simpleNameCS = 111,
      TK_ERROR_Garbage = 103;

      public final static String orderedTerminalSymbols[] = {
                 "",
                 "ERROR_TOKEN",
                 "LPAREN",
                 "IDENTIFIER",
                 "RPAREN",
                 "EQUAL",
                 "NOT_EQUAL",
                 "MULTIPLY",
                 "DIVIDE",
                 "GREATER",
                 "LESS",
                 "GREATER_EQUAL",
                 "LESS_EQUAL",
                 "and",
                 "or",
                 "xor",
                 "STRING_LITERAL",
                 "PLUS",
                 "enforce",
                 "map",
                 "realize",
                 "refines",
                 "MINUS",
                 "check",
                 "imports",
                 "query",
                 "transformation",
                 "uses",
                 "where",
                 "inv",
                 "pre",
                 "post",
                 "endpackage",
                 "def",
                 "COMMA",
                 "String",
                 "Integer",
                 "UnlimitedNatural",
                 "Real",
                 "Boolean",
                 "OclAny",
                 "OclVoid",
                 "Invalid",
                 "OclMessage",
                 "self",
                 "Set",
                 "Bag",
                 "Sequence",
                 "Collection",
                 "OrderedSet",
                 "body",
                 "derive",
                 "init",
                 "null",
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
                 "closure",
                 "allInstances",
                 "oclIsKindOf",
                 "oclIsTypeOf",
                 "oclAsType",
                 "oclIsNew",
                 "oclIsUndefined",
                 "oclIsInvalid",
                 "oclIsInState",
                 "not",
                 "Tuple",
                 "NUMERIC_OPERATION",
                 "INTEGER_LITERAL",
                 "REAL_LITERAL",
                 "true",
                 "false",
                 "OclInvalid",
                 "let",
                 "if",
                 "RBRACE",
                 "BAR",
                 "SEMICOLON",
                 "LBRACE",
                 "COLONCOLON",
                 "ATPRE",
                 "in",
                 "RBRACKET",
                 "COLON",
                 "endif",
                 "COLON_EQUALS",
                 "ARROW",
                 "DOT",
                 "CARET",
                 "CARETCARET",
                 "DOTDOT",
                 "then",
                 "else",
                 "implies",
                 "ERROR_Garbage",
                 "LBRACKET",
                 "QUESTIONMARK",
                 "INTEGER_RANGE_START",
                 "default",
                 "creation",
                 "deletion",
                 "EOF_TOKEN",
                 "ERROR_simpleNameCS",
                 "context",
                 "package",
                 "attr",
                 "oper"
             };

    public final static boolean isValidForParser = true;
}
