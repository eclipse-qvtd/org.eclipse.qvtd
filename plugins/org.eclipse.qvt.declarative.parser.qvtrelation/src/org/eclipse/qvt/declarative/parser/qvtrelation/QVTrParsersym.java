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
*   E.D.Willink - Extended API and implementation for QVTr
*
* </copyright>
*
* $Id: QVTrParsersym.java,v 1.7 2008/11/19 21:38:07 ewillink Exp $
*/

package org.eclipse.qvt.declarative.parser.qvtrelation;

public interface QVTrParsersym {
    public final static int
      TK_PLUS_PLUS = 114,
      TK_NUMERIC_OPERATION = 84,
      TK_STRING_LITERAL = 85,
      TK_INTEGER_LITERAL = 86,
      TK_REAL_LITERAL = 87,
      TK_PLUS = 40,
      TK_MINUS = 41,
      TK_MULTIPLY = 30,
      TK_DIVIDE = 31,
      TK_GREATER = 32,
      TK_LESS = 33,
      TK_EQUAL = 23,
      TK_GREATER_EQUAL = 34,
      TK_LESS_EQUAL = 35,
      TK_NOT_EQUAL = 29,
      TK_LPAREN = 2,
      TK_RPAREN = 4,
      TK_LBRACE = 88,
      TK_RBRACE = 57,
      TK_LBRACKET = 110,
      TK_RBRACKET = 98,
      TK_ARROW = 102,
      TK_BAR = 96,
      TK_COMMA = 42,
      TK_COLON = 7,
      TK_COLONCOLON = 95,
      TK_SEMICOLON = 94,
      TK_DOT = 100,
      TK_DOTDOT = 103,
      TK_ATPRE = 97,
      TK_CARET = 104,
      TK_CARETCARET = 105,
      TK_QUESTIONMARK = 111,
      TK_self = 36,
      TK_inv = 24,
      TK_pre = 25,
      TK_post = 26,
      TK_context = 116,
      TK_package = 117,
      TK_endpackage = 27,
      TK_def = 28,
      TK_if = 93,
      TK_then = 106,
      TK_else = 107,
      TK_endif = 99,
      TK_and = 37,
      TK_or = 38,
      TK_xor = 39,
      TK_not = 82,
      TK_implies = 108,
      TK_let = 92,
      TK_in = 101,
      TK_true = 89,
      TK_false = 90,
      TK_body = 58,
      TK_derive = 59,
      TK_init = 60,
      TK_null = 61,
      TK_attr = 118,
      TK_oper = 119,
      TK_Set = 52,
      TK_Bag = 53,
      TK_Sequence = 54,
      TK_Collection = 55,
      TK_OrderedSet = 56,
      TK_iterate = 62,
      TK_forAll = 63,
      TK_exists = 64,
      TK_isUnique = 65,
      TK_any = 66,
      TK_one = 67,
      TK_collect = 68,
      TK_select = 69,
      TK_reject = 70,
      TK_collectNested = 71,
      TK_sortedBy = 72,
      TK_closure = 73,
      TK_oclIsKindOf = 74,
      TK_oclIsTypeOf = 75,
      TK_oclAsType = 76,
      TK_oclIsNew = 77,
      TK_oclIsUndefined = 78,
      TK_oclIsInvalid = 79,
      TK_oclIsInState = 80,
      TK_allInstances = 81,
      TK_String = 43,
      TK_Integer = 44,
      TK_UnlimitedNatural = 45,
      TK_Real = 46,
      TK_Boolean = 47,
      TK_Tuple = 83,
      TK_OclAny = 48,
      TK_OclVoid = 49,
      TK_Invalid = 50,
      TK_OclMessage = 51,
      TK_OclInvalid = 91,
      TK_checkonly = 10,
      TK_default_values = 11,
      TK_domain = 5,
      TK_enforce = 12,
      TK_extends = 13,
      TK_implementedby = 14,
      TK_import = 15,
      TK_key = 16,
      TK_overrides = 17,
      TK_primitive = 18,
      TK_query = 19,
      TK_relation = 8,
      TK_replace = 20,
      TK_top = 21,
      TK_transformation = 6,
      TK_when = 22,
      TK_where = 9,
      TK_EOF_TOKEN = 112,
      TK_IDENTIFIER = 3,
      TK_INTEGER_RANGE_START = 113,
      TK_ERROR_TOKEN = 1,
      TK_ERROR_simpleNameCS = 115,
      TK_ERROR_Garbage = 109;

      public final static String orderedTerminalSymbols[] = {
                 "",
                 "ERROR_TOKEN",
                 "LPAREN",
                 "IDENTIFIER",
                 "RPAREN",
                 "domain",
                 "transformation",
                 "COLON",
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
                 "when",
                 "EQUAL",
                 "inv",
                 "pre",
                 "post",
                 "endpackage",
                 "def",
                 "NOT_EQUAL",
                 "MULTIPLY",
                 "DIVIDE",
                 "GREATER",
                 "LESS",
                 "GREATER_EQUAL",
                 "LESS_EQUAL",
                 "self",
                 "and",
                 "or",
                 "xor",
                 "PLUS",
                 "MINUS",
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
                 "Set",
                 "Bag",
                 "Sequence",
                 "Collection",
                 "OrderedSet",
                 "RBRACE",
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
                 "LBRACE",
                 "true",
                 "false",
                 "OclInvalid",
                 "let",
                 "if",
                 "SEMICOLON",
                 "COLONCOLON",
                 "BAR",
                 "ATPRE",
                 "RBRACKET",
                 "endif",
                 "DOT",
                 "in",
                 "ARROW",
                 "DOTDOT",
                 "CARET",
                 "CARETCARET",
                 "then",
                 "else",
                 "implies",
                 "ERROR_Garbage",
                 "LBRACKET",
                 "QUESTIONMARK",
                 "EOF_TOKEN",
                 "INTEGER_RANGE_START",
                 "PLUS_PLUS",
                 "ERROR_simpleNameCS",
                 "context",
                 "package",
                 "attr",
                 "oper"
             };

    public final static boolean isValidForParser = true;
}
