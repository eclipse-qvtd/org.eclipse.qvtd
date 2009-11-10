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
* </copyright>
*
* $Id: QVTrKWLexersym.java,v 1.13 2009/11/10 06:04:56 ewillink Exp $
*/

package org.eclipse.qvt.declarative.parser.qvtrelation;

public interface QVTrKWLexersym {
    public final static int
      Char_DollarSign = 38,
      Char_a = 7,
      Char_b = 25,
      Char_c = 12,
      Char_d = 9,
      Char_e = 1,
      Char_f = 13,
      Char_g = 18,
      Char_h = 19,
      Char_i = 4,
      Char_j = 39,
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
      Char_w = 26,
      Char_x = 22,
      Char_y = 17,
      Char_z = 40,
      Char_A = 27,
      Char_B = 28,
      Char_C = 29,
      Char_D = 41,
      Char_E = 42,
      Char_F = 43,
      Char_G = 44,
      Char_H = 45,
      Char_I = 23,
      Char_J = 46,
      Char_K = 47,
      Char_L = 48,
      Char_M = 49,
      Char_N = 30,
      Char_O = 31,
      Char_P = 50,
      Char_Q = 51,
      Char_R = 32,
      Char_S = 24,
      Char_T = 33,
      Char_U = 34,
      Char_V = 35,
      Char_W = 52,
      Char_X = 53,
      Char_Y = 54,
      Char_Z = 55,
      Char__ = 36,
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
                 "_",
                 "EOF",
                 "DollarSign",
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

    public final static boolean isValidForParser = true;
}
