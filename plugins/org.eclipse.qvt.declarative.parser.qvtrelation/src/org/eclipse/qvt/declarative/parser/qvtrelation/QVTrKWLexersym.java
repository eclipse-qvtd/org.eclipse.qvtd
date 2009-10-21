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
* $Id: QVTrKWLexersym.java,v 1.12 2009/10/21 07:49:03 ewillink Exp $
*/

package org.eclipse.qvt.declarative.parser.qvtrelation;

public interface QVTrKWLexersym {
    public final static int
      Char_DollarSign = 39,
      Char_a = 8,
      Char_b = 29,
      Char_c = 11,
      Char_d = 9,
      Char_e = 1,
      Char_f = 13,
      Char_g = 18,
      Char_h = 19,
      Char_i = 7,
      Char_j = 30,
      Char_k = 21,
      Char_l = 2,
      Char_m = 15,
      Char_n = 4,
      Char_o = 6,
      Char_p = 16,
      Char_q = 20,
      Char_r = 5,
      Char_s = 10,
      Char_t = 3,
      Char_u = 12,
      Char_v = 17,
      Char_w = 31,
      Char_x = 22,
      Char_y = 14,
      Char_z = 40,
      Char_A = 23,
      Char_B = 24,
      Char_C = 32,
      Char_D = 41,
      Char_E = 42,
      Char_F = 43,
      Char_G = 44,
      Char_H = 45,
      Char_I = 25,
      Char_J = 46,
      Char_K = 47,
      Char_L = 48,
      Char_M = 49,
      Char_N = 26,
      Char_O = 33,
      Char_P = 50,
      Char_Q = 51,
      Char_R = 34,
      Char_S = 27,
      Char_T = 35,
      Char_U = 28,
      Char_V = 36,
      Char_W = 52,
      Char_X = 53,
      Char_Y = 54,
      Char_Z = 55,
      Char__ = 37,
      Char_EOF = 38;

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
                 "d",
                 "s",
                 "c",
                 "u",
                 "f",
                 "y",
                 "m",
                 "p",
                 "v",
                 "g",
                 "h",
                 "q",
                 "k",
                 "x",
                 "A",
                 "B",
                 "I",
                 "N",
                 "S",
                 "U",
                 "b",
                 "j",
                 "w",
                 "C",
                 "O",
                 "R",
                 "T",
                 "V",
                 "_",
                 "EOF",
                 "DollarSign",
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
