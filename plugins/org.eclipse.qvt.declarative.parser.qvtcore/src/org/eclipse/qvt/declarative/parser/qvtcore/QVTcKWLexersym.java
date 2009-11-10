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
* $Id: QVTcKWLexersym.java,v 1.11 2009/11/10 06:04:39 ewillink Exp $
*/

package org.eclipse.qvt.declarative.parser.qvtcore;

public interface QVTcKWLexersym {
    public final static int
      Char_DollarSign = 37,
      Char_a = 4,
      Char_b = 38,
      Char_c = 13,
      Char_d = 9,
      Char_e = 1,
      Char_f = 11,
      Char_g = 15,
      Char_h = 16,
      Char_i = 5,
      Char_j = 39,
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
      Char_D = 40,
      Char_E = 41,
      Char_F = 42,
      Char_G = 43,
      Char_H = 44,
      Char_I = 21,
      Char_J = 45,
      Char_K = 46,
      Char_L = 47,
      Char_M = 48,
      Char_N = 30,
      Char_O = 31,
      Char_P = 49,
      Char_Q = 50,
      Char_R = 32,
      Char_S = 22,
      Char_T = 33,
      Char_U = 34,
      Char_V = 35,
      Char_W = 51,
      Char_X = 52,
      Char_Y = 53,
      Char_Z = 54,
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

    public final static boolean isValidForParser = true;
}
