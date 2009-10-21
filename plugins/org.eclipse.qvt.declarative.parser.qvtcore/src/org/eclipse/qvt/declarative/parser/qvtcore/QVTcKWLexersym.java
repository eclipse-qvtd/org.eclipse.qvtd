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
* $Id: QVTcKWLexersym.java,v 1.10 2009/10/21 07:48:38 ewillink Exp $
*/

package org.eclipse.qvt.declarative.parser.qvtcore;

public interface QVTcKWLexersym {
    public final static int
      Char_DollarSign = 38,
      Char_a = 8,
      Char_b = 39,
      Char_c = 12,
      Char_d = 10,
      Char_e = 1,
      Char_f = 13,
      Char_g = 16,
      Char_h = 17,
      Char_i = 7,
      Char_j = 28,
      Char_k = 29,
      Char_l = 2,
      Char_m = 14,
      Char_n = 4,
      Char_o = 6,
      Char_p = 18,
      Char_q = 19,
      Char_r = 5,
      Char_s = 9,
      Char_t = 3,
      Char_u = 11,
      Char_v = 20,
      Char_w = 30,
      Char_x = 21,
      Char_y = 15,
      Char_z = 31,
      Char_A = 22,
      Char_B = 23,
      Char_C = 32,
      Char_D = 40,
      Char_E = 41,
      Char_F = 42,
      Char_G = 43,
      Char_H = 44,
      Char_I = 24,
      Char_J = 45,
      Char_K = 46,
      Char_L = 47,
      Char_M = 48,
      Char_N = 25,
      Char_O = 33,
      Char_P = 49,
      Char_Q = 50,
      Char_R = 34,
      Char_S = 26,
      Char_T = 35,
      Char_U = 27,
      Char_V = 36,
      Char_W = 51,
      Char_X = 52,
      Char_Y = 53,
      Char_Z = 54,
      Char_EOF = 37;

      public final static String orderedTerminalSymbols[] = {
                 "",
                 "e",
                 "l",
                 "t",
                 "n",
                 "r",
                 "o",
                 "i",
                 "a",
                 "s",
                 "d",
                 "u",
                 "c",
                 "f",
                 "m",
                 "y",
                 "g",
                 "h",
                 "p",
                 "q",
                 "v",
                 "x",
                 "A",
                 "B",
                 "I",
                 "N",
                 "S",
                 "U",
                 "j",
                 "k",
                 "w",
                 "z",
                 "C",
                 "O",
                 "R",
                 "T",
                 "V",
                 "EOF",
                 "DollarSign",
                 "b",
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
