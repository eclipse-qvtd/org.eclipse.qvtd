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
*   E.D.Willink - Extended API and implementation for QVTr
*
* </copyright>
*
*
*/

package org.eclipse.qvt.declarative.parser.qvtrelation;

public interface QVTrKWLexersym {
    public final static int
      Char_DollarSign = 38,
      Char_Percent = 39,
      Char__ = 25,
      Char_a = 7,
      Char_b = 26,
      Char_c = 12,
      Char_d = 9,
      Char_e = 1,
      Char_f = 13,
      Char_g = 18,
      Char_h = 19,
      Char_i = 4,
      Char_j = 40,
      Char_k = 20,
      Char_l = 2,
      Char_m = 14,
      Char_n = 3,
      Char_o = 8,
      Char_p = 15,
      Char_q = 21,
      Char_r = 5,
      Char_s = 10,
      Char_t = 6,
      Char_u = 11,
      Char_v = 16,
      Char_w = 27,
      Char_x = 22,
      Char_y = 17,
      Char_z = 41,
      Char_A = 28,
      Char_B = 29,
      Char_C = 30,
      Char_D = 42,
      Char_E = 43,
      Char_F = 44,
      Char_G = 45,
      Char_H = 46,
      Char_I = 23,
      Char_J = 47,
      Char_K = 48,
      Char_L = 49,
      Char_M = 50,
      Char_N = 31,
      Char_O = 32,
      Char_P = 51,
      Char_Q = 52,
      Char_R = 33,
      Char_S = 24,
      Char_T = 34,
      Char_U = 35,
      Char_V = 36,
      Char_W = 53,
      Char_X = 54,
      Char_Y = 55,
      Char_Z = 56,
      Char_EOF = 37;

    public final static String orderedTerminalSymbols[] = {
                 "",
                 "e",
                 "l",
                 "n",
                 "i",
                 "r",
                 "t",
                 "a",
                 "o",
                 "d",
                 "s",
                 "u",
                 "c",
                 "f",
                 "m",
                 "p",
                 "v",
                 "y",
                 "g",
                 "h",
                 "k",
                 "q",
                 "x",
                 "I",
                 "S",
                 "_",
                 "b",
                 "w",
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
                 "j",
                 "z",
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
