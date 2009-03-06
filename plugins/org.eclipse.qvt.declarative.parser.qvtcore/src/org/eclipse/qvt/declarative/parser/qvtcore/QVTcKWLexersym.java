/**
* <copyright>
*
* Copyright (c) 2005, 2007 IBM Corporation and others.
* All rights reserved.   This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*   IBM - Initial API and implementation
*   E.D.Willink - Lexer and Parser refactoring to support extensibility and flexible error handling
*   E.D.Willink - Extended API and implementation for QVTc
*
* </copyright>
*
* $Id: QVTcKWLexersym.java,v 1.8 2009/03/06 22:39:26 ewillink Exp $
*/

package org.eclipse.qvt.declarative.parser.qvtcore;

public interface QVTcKWLexersym {
    public final static int
      Char_DollarSign = 41,
      Char_a = 5,
      Char_b = 32,
      Char_c = 11,
      Char_d = 10,
      Char_e = 1,
      Char_f = 12,
      Char_g = 16,
      Char_h = 20,
      Char_i = 7,
      Char_j = 33,
      Char_k = 21,
      Char_l = 3,
      Char_m = 19,
      Char_n = 4,
      Char_o = 9,
      Char_p = 14,
      Char_q = 22,
      Char_r = 6,
      Char_s = 8,
      Char_t = 2,
      Char_u = 13,
      Char_v = 17,
      Char_w = 30,
      Char_x = 23,
      Char_y = 15,
      Char_z = 34,
      Char_A = 24,
      Char_B = 31,
      Char_C = 35,
      Char_D = 42,
      Char_E = 43,
      Char_F = 44,
      Char_G = 45,
      Char_H = 46,
      Char_I = 18,
      Char_J = 47,
      Char_K = 36,
      Char_L = 48,
      Char_M = 37,
      Char_N = 25,
      Char_O = 26,
      Char_P = 49,
      Char_Q = 50,
      Char_R = 38,
      Char_S = 27,
      Char_T = 28,
      Char_U = 29,
      Char_V = 39,
      Char_W = 51,
      Char_X = 52,
      Char_Y = 53,
      Char_Z = 54,
      Char_EOF = 40;

      public final static String orderedTerminalSymbols[] = {
                 "",
                 "e",
                 "t",
                 "l",
                 "n",
                 "a",
                 "r",
                 "i",
                 "s",
                 "o",
                 "d",
                 "c",
                 "f",
                 "u",
                 "p",
                 "y",
                 "g",
                 "v",
                 "I",
                 "m",
                 "h",
                 "k",
                 "q",
                 "x",
                 "A",
                 "N",
                 "O",
                 "S",
                 "T",
                 "U",
                 "w",
                 "B",
                 "b",
                 "j",
                 "z",
                 "C",
                 "K",
                 "M",
                 "R",
                 "V",
                 "EOF",
                 "DollarSign",
                 "D",
                 "E",
                 "F",
                 "G",
                 "H",
                 "J",
                 "L",
                 "P",
                 "Q",
                 "W",
                 "X",
                 "Y",
                 "Z"
             };

    public final static boolean isValidForParser = true;
}
