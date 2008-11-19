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
*   E.D.Willink - Lexer and Parser refactoring to support extensibility and flexible error handling
*   E.D.Willink - Extended API and implementation for QVTr
*
* </copyright>
*
* $Id: QVTrLexersym.java,v 1.7 2008/11/19 21:38:06 ewillink Exp $
*/

package org.eclipse.qvt.declarative.parser.qvtrelation;

public interface QVTrLexersym {
    public final static int
      Char_CtlCharNotWS = 103,
      Char_LF = 100,
      Char_CR = 101,
      Char_HT = 97,
      Char_FF = 98,
      Char_a = 16,
      Char_b = 17,
      Char_c = 18,
      Char_d = 19,
      Char_e = 11,
      Char_f = 20,
      Char_g = 21,
      Char_h = 22,
      Char_i = 23,
      Char_j = 24,
      Char_k = 25,
      Char_l = 26,
      Char_m = 27,
      Char_n = 28,
      Char_o = 29,
      Char_p = 13,
      Char_q = 30,
      Char_r = 14,
      Char_s = 31,
      Char_t = 32,
      Char_u = 33,
      Char_v = 34,
      Char_w = 35,
      Char_x = 36,
      Char_y = 37,
      Char_z = 38,
      Char__ = 39,
      Char_A = 40,
      Char_B = 41,
      Char_C = 42,
      Char_D = 43,
      Char_E = 12,
      Char_F = 44,
      Char_G = 45,
      Char_H = 46,
      Char_I = 47,
      Char_J = 48,
      Char_K = 49,
      Char_L = 50,
      Char_M = 51,
      Char_N = 52,
      Char_O = 53,
      Char_P = 54,
      Char_Q = 55,
      Char_R = 56,
      Char_S = 57,
      Char_T = 58,
      Char_U = 59,
      Char_V = 60,
      Char_W = 61,
      Char_X = 62,
      Char_Y = 63,
      Char_Z = 64,
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
      Char_AfterASCIINotAcute = 65,
      Char_Space = 73,
      Char_DoubleQuote = 74,
      Char_SingleQuote = 66,
      Char_Percent = 91,
      Char_VerticalBar = 79,
      Char_Exclamation = 92,
      Char_AtSign = 80,
      Char_BackQuote = 81,
      Char_Acute = 102,
      Char_Tilde = 93,
      Char_Sharp = 94,
      Char_DollarSign = 75,
      Char_Ampersand = 95,
      Char_Caret = 76,
      Char_Colon = 77,
      Char_SemiColon = 82,
      Char_BackSlash = 96,
      Char_LeftBrace = 83,
      Char_RightBrace = 84,
      Char_LeftBracket = 85,
      Char_RightBracket = 86,
      Char_QuestionMark = 87,
      Char_Comma = 88,
      Char_Dot = 67,
      Char_LessThan = 78,
      Char_GreaterThan = 68,
      Char_Plus = 69,
      Char_Minus = 70,
      Char_Slash = 71,
      Char_Star = 72,
      Char_LeftParen = 89,
      Char_RightParen = 90,
      Char_Equal = 15,
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
                 "p",
                 "r",
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
                 "q",
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
                 "SingleQuote",
                 "Dot",
                 "GreaterThan",
                 "Plus",
                 "Minus",
                 "Slash",
                 "Star",
                 "Space",
                 "DoubleQuote",
                 "DollarSign",
                 "Caret",
                 "Colon",
                 "LessThan",
                 "VerticalBar",
                 "AtSign",
                 "BackQuote",
                 "SemiColon",
                 "LeftBrace",
                 "RightBrace",
                 "LeftBracket",
                 "RightBracket",
                 "QuestionMark",
                 "Comma",
                 "LeftParen",
                 "RightParen",
                 "Percent",
                 "Exclamation",
                 "Tilde",
                 "Sharp",
                 "Ampersand",
                 "BackSlash",
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
