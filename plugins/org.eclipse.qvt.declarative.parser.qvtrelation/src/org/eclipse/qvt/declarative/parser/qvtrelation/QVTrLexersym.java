/**
* Essential OCL Lexer
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
*   E.D.Willink - Lexer and Parser refactoring to support extensibility and flexible error handling
*   Borland - Bug 242880
*   E.D.Willink - Bug 292112
* </copyright>
*
* $Id: QVTrLexersym.java,v 1.12 2009/10/21 07:49:02 ewillink Exp $
*/

package org.eclipse.qvt.declarative.parser.qvtrelation;

public interface QVTrLexersym {
    public final static int
      Char_CtlCharNotWS = 103,
      Char_LF = 100,
      Char_CR = 101,
      Char_HT = 97,
      Char_FF = 98,
      Char_a = 19,
      Char_b = 20,
      Char_c = 21,
      Char_d = 22,
      Char_e = 11,
      Char_f = 23,
      Char_g = 24,
      Char_h = 25,
      Char_i = 26,
      Char_j = 27,
      Char_k = 28,
      Char_l = 29,
      Char_m = 30,
      Char_n = 31,
      Char_o = 32,
      Char_p = 33,
      Char_q = 34,
      Char_r = 35,
      Char_s = 36,
      Char_t = 37,
      Char_u = 38,
      Char_v = 39,
      Char_w = 40,
      Char_x = 41,
      Char_y = 42,
      Char_z = 43,
      Char__ = 44,
      Char_A = 45,
      Char_B = 46,
      Char_C = 47,
      Char_D = 48,
      Char_E = 12,
      Char_F = 49,
      Char_G = 50,
      Char_H = 51,
      Char_I = 52,
      Char_J = 53,
      Char_K = 54,
      Char_L = 55,
      Char_M = 56,
      Char_N = 57,
      Char_O = 58,
      Char_P = 59,
      Char_Q = 60,
      Char_R = 61,
      Char_S = 62,
      Char_T = 63,
      Char_U = 64,
      Char_V = 65,
      Char_W = 66,
      Char_X = 67,
      Char_Y = 68,
      Char_Z = 69,
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
      Char_AfterASCIINotAcute = 70,
      Char_Space = 71,
      Char_DoubleQuote = 75,
      Char_SingleQuote = 13,
      Char_Percent = 88,
      Char_VerticalBar = 76,
      Char_Exclamation = 89,
      Char_AtSign = 90,
      Char_BackQuote = 77,
      Char_Acute = 102,
      Char_Tilde = 91,
      Char_Sharp = 92,
      Char_DollarSign = 78,
      Char_Ampersand = 93,
      Char_Caret = 94,
      Char_Colon = 72,
      Char_SemiColon = 79,
      Char_BackSlash = 95,
      Char_LeftBrace = 80,
      Char_RightBrace = 81,
      Char_LeftBracket = 82,
      Char_RightBracket = 83,
      Char_QuestionMark = 96,
      Char_Comma = 84,
      Char_Dot = 14,
      Char_LessThan = 85,
      Char_GreaterThan = 15,
      Char_Plus = 16,
      Char_Minus = 17,
      Char_Slash = 73,
      Char_Star = 74,
      Char_LeftParen = 86,
      Char_RightParen = 87,
      Char_Equal = 18,
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
                 "SingleQuote",
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
                 "Colon",
                 "Slash",
                 "Star",
                 "DoubleQuote",
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

    public final static boolean isValidForParser = true;
}
