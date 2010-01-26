/**
* Essential OCL Keyword Lexer
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
*   E.D.Willink - Bug 285633, 292112
*   Adolfo Sanchez-Barbudo Herrera (Open Canarias) - LPG v 2.0.17 adoption (242153)
*   Adolfo Sanchez-Barbudo Herrera (Open Canarias) - Introducing new LPG templates (299396) 
*   E.D.Willink - Extended API and implementation for QVTc
*
* </copyright>
*
*
*/

package org.eclipse.qvt.declarative.parser.qvtcore;

public interface QVTcKWLexersym {
    public final static int
      Char_DollarSign = 37,
      Char_Percent = 38,
      Char__ = 39,
      Char_a = 4,
      Char_b = 40,
      Char_c = 13,
      Char_d = 9,
      Char_e = 1,
      Char_f = 11,
      Char_g = 15,
      Char_h = 16,
      Char_i = 5,
      Char_j = 41,
      Char_k = 23,
      Char_l = 2,
      Char_m = 14,
      Char_n = 3,
      Char_o = 8,
      Char_p = 17,
      Char_q = 18,
      Char_r = 6,
      Char_s = 10,
      Char_t = 7,
      Char_u = 12,
      Char_v = 19,
      Char_w = 24,
      Char_x = 25,
      Char_y = 20,
      Char_z = 26,
      Char_A = 27,
      Char_B = 28,
      Char_C = 29,
      Char_D = 42,
      Char_E = 43,
      Char_F = 44,
      Char_G = 45,
      Char_H = 46,
      Char_I = 21,
      Char_J = 47,
      Char_K = 48,
      Char_L = 49,
      Char_M = 50,
      Char_N = 30,
      Char_O = 31,
      Char_P = 51,
      Char_Q = 52,
      Char_R = 32,
      Char_S = 22,
      Char_T = 33,
      Char_U = 34,
      Char_V = 35,
      Char_W = 53,
      Char_X = 54,
      Char_Y = 55,
      Char_Z = 56,
      Char_EOF = 36;

    public final static String orderedTerminalSymbols[] = {
                 "",
                 "e",
                 "l",
                 "n",
                 "a",
                 "i",
                 "r",
                 "t",
                 "o",
                 "d",
                 "s",
                 "f",
                 "u",
                 "c",
                 "m",
                 "g",
                 "h",
                 "p",
                 "q",
                 "v",
                 "y",
                 "I",
                 "S",
                 "k",
                 "w",
                 "x",
                 "z",
                 "A",
                 "B",
                 "C",
                 "N",
                 "O",
                 "R",
                 "T",
                 "U",
                 "V",
                 "EOF",
                 "DollarSign",
                 "Percent",
                 "_",
                 "b",
                 "j",
                 "D",
                 "E",
                 "F",
                 "G",
                 "H",
                 "J",
                 "K",
                 "L",
                 "M",
                 "P",
                 "Q",
                 "W",
                 "X",
                 "Y",
                 "Z"
             };

    public final static int numTokenKinds = orderedTerminalSymbols.length;
    public final static boolean isValidForParser = true;
}
