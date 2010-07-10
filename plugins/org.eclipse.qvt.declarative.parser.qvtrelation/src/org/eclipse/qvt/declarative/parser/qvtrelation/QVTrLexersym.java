/**
* Essential OCL Lexer
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
*   E.D.Willink - Lexer and Parser refactoring to support extensibility and flexible error handling
*   Borland - Bug 242880
*   E.D.Willink - Bug 292112, 295166
*   Adolfo Sanchez-Barbudo Herrera (Open Canarias) - LPG v 2.0.17 adoption (242153)
*   Adolfo Sanchez-Barbudo Herrera (Open Canarias) - Introducing new LPG templates (299396)
*   E.D.Willink - Extended API and implementation for QVTr
*
* </copyright>
*
* $Id: QVTrLexersym.java,v 1.16 2010/07/10 06:14:54 ewillink Exp $
*/

package org.eclipse.qvt.declarative.parser.qvtrelation;

public interface QVTrLexersym {
    public final static int
      Char_CtlCharNotWS = 103,
      Char_LF = 100,
      Char_CR = 101,
      Char_HT = 97,
      Char_FF = 98,
      Char_a = 18,
      Char_b = 19,
      Char_c = 20,
      Char_d = 21,
      Char_e = 11,
      Char_f = 22,
      Char_g = 23,
      Char_h = 24,
      Char_i = 25,
      Char_j = 26,
      Char_k = 27,
      Char_l = 28,
      Char_m = 29,
      Char_n = 30,
      Char_o = 31,
      Char_p = 32,
      Char_q = 33,
      Char_r = 34,
      Char_s = 35,
      Char_t = 36,
      Char_u = 37,
      Char_v = 38,
      Char_w = 39,
      Char_x = 40,
      Char_y = 41,
      Char_z = 42,
      Char__ = 43,
      Char_A = 44,
      Char_B = 45,
      Char_C = 46,
      Char_D = 47,
      Char_E = 12,
      Char_F = 48,
      Char_G = 49,
      Char_H = 50,
      Char_I = 51,
      Char_J = 52,
      Char_K = 53,
      Char_L = 54,
      Char_M = 55,
      Char_N = 56,
      Char_O = 57,
      Char_P = 58,
      Char_Q = 59,
      Char_R = 60,
      Char_S = 61,
      Char_T = 62,
      Char_U = 63,
      Char_V = 64,
      Char_W = 65,
      Char_X = 66,
      Char_Y = 67,
      Char_Z = 68,
      Char_0 = 1,
      Char_1 = 2,
      Char_2 = 3,
      Char_3 = 4,
      Char_4 = 5,
      Char_5 = 6,
      Char_6 = 7,
      Char_7 = 8,
      Char_8 = 9,
      Char_9 = 10,
      Char_AfterASCIINotAcute = 69,
      Char_Space = 70,
      Char_DoubleQuote = 87,
      Char_SingleQuote = 71,
      Char_Percent = 88,
      Char_VerticalBar = 75,
      Char_Exclamation = 89,
      Char_AtSign = 90,
      Char_BackQuote = 76,
      Char_Acute = 102,
      Char_Tilde = 91,
      Char_Sharp = 92,
      Char_DollarSign = 77,
      Char_Ampersand = 93,
      Char_Caret = 94,
      Char_Colon = 72,
      Char_SemiColon = 78,
      Char_BackSlash = 95,
      Char_LeftBrace = 79,
      Char_RightBrace = 80,
      Char_LeftBracket = 81,
      Char_RightBracket = 82,
      Char_QuestionMark = 96,
      Char_Comma = 83,
      Char_Dot = 13,
      Char_LessThan = 84,
      Char_GreaterThan = 14,
      Char_Plus = 15,
      Char_Minus = 16,
      Char_Slash = 73,
      Char_Star = 74,
      Char_LeftParen = 85,
      Char_RightParen = 86,
      Char_Equal = 17,
      Char_EOF = 99;

    public final static String orderedTerminalSymbols[] = {
                 "",
                 "0",
                 "1",
                 "2",
                 "3",
                 "4",
                 "5",
                 "6",
                 "7",
                 "8",
                 "9",
                 "e",
                 "E",
                 "Dot",
                 "GreaterThan",
                 "Plus",
                 "Minus",
                 "Equal",
                 "a",
                 "b",
                 "c",
                 "d",
                 "f",
                 "g",
                 "h",
                 "i",
                 "j",
                 "k",
                 "l",
                 "m",
                 "n",
                 "o",
                 "p",
                 "q",
                 "r",
                 "s",
                 "t",
                 "u",
                 "v",
                 "w",
                 "x",
                 "y",
                 "z",
                 "_",
                 "A",
                 "B",
                 "C",
                 "D",
                 "F",
                 "G",
                 "H",
                 "I",
                 "J",
                 "K",
                 "L",
                 "M",
                 "N",
                 "O",
                 "P",
                 "Q",
                 "R",
                 "S",
                 "T",
                 "U",
                 "V",
                 "W",
                 "X",
                 "Y",
                 "Z",
                 "AfterASCIINotAcute",
                 "Space",
                 "SingleQuote",
                 "Colon",
                 "Slash",
                 "Star",
                 "VerticalBar",
                 "BackQuote",
                 "DollarSign",
                 "SemiColon",
                 "LeftBrace",
                 "RightBrace",
                 "LeftBracket",
                 "RightBracket",
                 "Comma",
                 "LessThan",
                 "LeftParen",
                 "RightParen",
                 "DoubleQuote",
                 "Percent",
                 "Exclamation",
                 "AtSign",
                 "Tilde",
                 "Sharp",
                 "Ampersand",
                 "Caret",
                 "BackSlash",
                 "QuestionMark",
                 "HT",
                 "FF",
                 "EOF",
                 "LF",
                 "CR",
                 "Acute",
                 "CtlCharNotWS"
             };

    public final static int numTokenKinds = orderedTerminalSymbols.length;
    public final static boolean isValidForParser = true;
}
