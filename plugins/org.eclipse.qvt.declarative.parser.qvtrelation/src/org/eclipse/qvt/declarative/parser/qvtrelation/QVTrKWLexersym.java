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
*   E.D.Willink - Extended API and implementation for QVTr
*
* </copyright>
*
* $Id: QVTrKWLexersym.java,v 1.2 2008/08/10 13:44:35 ewillink Exp $
*/

package org.eclipse.qvt.declarative.parser.qvtrelation;

public interface QVTrKWLexersym {
    public final static int
      Char_DollarSign = 41,
      Char_a = 5,
      Char_b = 30,
      Char_c = 11,
      Char_d = 10,
      Char_e = 1,
      Char_f = 12,
      Char_g = 17,
      Char_h = 21,
      Char_i = 6,
      Char_j = 33,
      Char_k = 20,
      Char_l = 3,
      Char_m = 18,
      Char_n = 4,
      Char_o = 8,
      Char_p = 15,
      Char_q = 22,
      Char_r = 7,
      Char_s = 9,
      Char_t = 2,
      Char_u = 13,
      Char_v = 16,
      Char_w = 31,
      Char_x = 23,
      Char_y = 14,
      Char_z = 42,
      Char_A = 24,
      Char_B = 32,
      Char_C = 34,
      Char_D = 43,
      Char_E = 44,
      Char_F = 45,
      Char_G = 46,
      Char_H = 47,
      Char_I = 19,
      Char_J = 48,
      Char_K = 35,
      Char_L = 49,
      Char_M = 36,
      Char_N = 25,
      Char_O = 26,
      Char_P = 50,
      Char_Q = 51,
      Char_R = 37,
      Char_S = 27,
      Char_T = 28,
      Char_U = 29,
      Char_V = 38,
      Char_W = 52,
      Char_X = 53,
      Char_Y = 54,
      Char_Z = 55,
      Char__ = 39,
      Char_EOF = 40;

      public final static String orderedTerminalSymbols[] = {
                 "",
                 "e",
                 "t",
                 "l",
                 "n",
                 "a",
                 "i",
                 "r",
                 "o",
                 "s",
                 "d",
                 "c",
                 "f",
                 "u",
                 "y",
                 "p",
                 "v",
                 "g",
                 "m",
                 "I",
                 "k",
                 "h",
                 "q",
                 "x",
                 "A",
                 "N",
                 "O",
                 "S",
                 "T",
                 "U",
                 "b",
                 "w",
                 "B",
                 "j",
                 "C",
                 "K",
                 "M",
                 "R",
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
