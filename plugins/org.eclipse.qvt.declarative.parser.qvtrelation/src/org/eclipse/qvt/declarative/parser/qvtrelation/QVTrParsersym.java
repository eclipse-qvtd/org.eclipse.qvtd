/**
* <copyright>
*
* Copyright (c) 2005, 2008 IBM Corporation and others.
* All rights reserved.   This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*   IBM - Initial API and implementation
*   E.D.Willink - Elimination of some shift-reduce conflicts
*   E.D.Willink - Remove unnecessary warning suppression
*   E.D.Willink - 225493 Need ability to set CSTNode offsets
*   E.D.Willink - Extended API and implementation for QVTr
*
* </copyright>
*
* $Id: QVTrParsersym.java,v 1.4 2008/08/18 07:55:54 ewillink Exp $
*/

package org.eclipse.qvt.declarative.parser.qvtrelation;

public interface QVTrParsersym {
    public final static int
      TK_PLUS_PLUS = 111,
      TK_NUMERIC_OPERATION = 85,
      TK_STRING_LITERAL = 86,
      TK_INTEGER_LITERAL = 87,
      TK_REAL_LITERAL = 88,
      TK_PLUS = 50,
      TK_MINUS = 56,
      TK_MULTIPLY = 32,
      TK_DIVIDE = 33,
      TK_GREATER = 34,
      TK_LESS = 35,
      TK_EQUAL = 27,
      TK_GREATER_EQUAL = 36,
      TK_LESS_EQUAL = 37,
      TK_NOT_EQUAL = 31,
      TK_LPAREN = 1,
      TK_RPAREN = 2,
      TK_LBRACE = 30,
      TK_RBRACE = 57,
      TK_LBRACKET = 98,
      TK_RBRACKET = 97,
      TK_ARROW = 101,
      TK_BAR = 95,
      TK_COMMA = 28,
      TK_COLON = 3,
      TK_COLONCOLON = 58,
      TK_SEMICOLON = 92,
      TK_DOT = 99,
      TK_DOTDOT = 102,
      TK_ATPRE = 96,
      TK_CARET = 103,
      TK_CARETCARET = 104,
      TK_QUESTIONMARK = 105,
      TK_self = 29,
      TK_inv = 22,
      TK_pre = 23,
      TK_post = 24,
      TK_context = 113,
      TK_package = 114,
      TK_endpackage = 25,
      TK_def = 26,
      TK_if = 94,
      TK_then = 106,
      TK_else = 107,
      TK_endif = 108,
      TK_and = 38,
      TK_or = 39,
      TK_xor = 40,
      TK_not = 83,
      TK_implies = 109,
      TK_let = 93,
      TK_in = 110,
      TK_true = 89,
      TK_false = 90,
      TK_body = 59,
      TK_derive = 60,
      TK_init = 61,
      TK_null = 62,
      TK_attr = 115,
      TK_oper = 116,
      TK_Set = 51,
      TK_Bag = 52,
      TK_Sequence = 53,
      TK_Collection = 54,
      TK_OrderedSet = 55,
      TK_iterate = 63,
      TK_forAll = 64,
      TK_exists = 65,
      TK_isUnique = 66,
      TK_any = 67,
      TK_one = 68,
      TK_collect = 69,
      TK_select = 70,
      TK_reject = 71,
      TK_collectNested = 72,
      TK_sortedBy = 73,
      TK_closure = 74,
      TK_oclIsKindOf = 75,
      TK_oclIsTypeOf = 76,
      TK_oclAsType = 77,
      TK_oclIsNew = 78,
      TK_oclIsUndefined = 79,
      TK_oclIsInvalid = 80,
      TK_oclIsInState = 81,
      TK_allInstances = 82,
      TK_String = 41,
      TK_Integer = 42,
      TK_UnlimitedNatural = 43,
      TK_Real = 44,
      TK_Boolean = 45,
      TK_Tuple = 84,
      TK_OclAny = 46,
      TK_OclVoid = 47,
      TK_Invalid = 48,
      TK_OclMessage = 49,
      TK_OclInvalid = 91,
      TK_checkonly = 8,
      TK_default_values = 9,
      TK_domain = 4,
      TK_enforce = 10,
      TK_extends = 11,
      TK_implementedby = 12,
      TK_import = 13,
      TK_key = 14,
      TK_overrides = 15,
      TK_primitive = 16,
      TK_query = 17,
      TK_relation = 6,
      TK_replace = 18,
      TK_top = 19,
      TK_transformation = 20,
      TK_when = 21,
      TK_where = 7,
      TK_EOF_TOKEN = 112,
      TK_IDENTIFIER = 5,
      TK_INTEGER_RANGE_START = 100,
      TK_ERROR_TOKEN = 117;

      public final static String orderedTerminalSymbols[] = {
                 "",
                 "LPAREN",
                 "RPAREN",
                 "COLON",
                 "domain",
                 "IDENTIFIER",
                 "relation",
                 "where",
                 "checkonly",
                 "default_values",
                 "enforce",
                 "extends",
                 "implementedby",
                 "import",
                 "key",
                 "overrides",
                 "primitive",
                 "query",
                 "replace",
                 "top",
                 "transformation",
                 "when",
                 "inv",
                 "pre",
                 "post",
                 "endpackage",
                 "def",
                 "EQUAL",
                 "COMMA",
                 "self",
                 "LBRACE",
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
                 "String",
                 "Integer",
                 "UnlimitedNatural",
                 "Real",
                 "Boolean",
                 "OclAny",
                 "OclVoid",
                 "Invalid",
                 "OclMessage",
                 "PLUS",
                 "Set",
                 "Bag",
                 "Sequence",
                 "Collection",
                 "OrderedSet",
                 "MINUS",
                 "RBRACE",
                 "COLONCOLON",
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
                 "oclIsKindOf",
                 "oclIsTypeOf",
                 "oclAsType",
                 "oclIsNew",
                 "oclIsUndefined",
                 "oclIsInvalid",
                 "oclIsInState",
                 "allInstances",
                 "not",
                 "Tuple",
                 "NUMERIC_OPERATION",
                 "STRING_LITERAL",
                 "INTEGER_LITERAL",
                 "REAL_LITERAL",
                 "true",
                 "false",
                 "OclInvalid",
                 "SEMICOLON",
                 "let",
                 "if",
                 "BAR",
                 "ATPRE",
                 "RBRACKET",
                 "LBRACKET",
                 "DOT",
                 "INTEGER_RANGE_START",
                 "ARROW",
                 "DOTDOT",
                 "CARET",
                 "CARETCARET",
                 "QUESTIONMARK",
                 "then",
                 "else",
                 "endif",
                 "implies",
                 "in",
                 "PLUS_PLUS",
                 "EOF_TOKEN",
                 "context",
                 "package",
                 "attr",
                 "oper",
                 "ERROR_TOKEN"
             };

    public final static boolean isValidForParser = true;
}
