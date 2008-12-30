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
* $Id: QVTrLexerprs.java,v 1.9 2008/12/30 12:54:05 ewillink Exp $
*/

package org.eclipse.qvt.declarative.parser.qvtrelation;

public class QVTrLexerprs implements lpg.lpgjavaruntime.ParseTable, QVTrLexersym {

    public interface IsKeyword {
        public final static byte isKeyword[] = {0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0
        };
    };
    public final static byte isKeyword[] = IsKeyword.isKeyword;
    public final boolean isKeyword(int index) { return isKeyword[index] != 0; }

    public interface BaseCheck {
        public final static byte baseCheck[] = {0,
            1,1,3,3,3,1,1,1,1,1,
            5,1,1,1,1,1,1,1,1,1,
            1,2,2,2,1,1,1,1,2,1,
            1,1,2,1,1,2,4,1,2,1,
            1,1,2,2,3,2,2,0,1,2,
            2,2,1,2,1,2,3,2,3,3,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,2,3,1,1,1,1,
            1,2,1,2,2,2,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,2,2,1,
            2,1,2,0,1,3,3,3,3,3,
            3,3,4,4,3,3,2,2
        };
    };
    public final static byte baseCheck[] = BaseCheck.baseCheck;
    public final int baseCheck(int index) { return baseCheck[index]; }
    public final static byte rhs[] = baseCheck;
    public final int rhs(int index) { return rhs[index]; };

    public interface BaseAction {
        public final static char baseAction[] = {
            21,21,21,21,21,21,21,21,21,21,
            21,21,21,21,21,21,21,21,21,21,
            21,21,21,21,21,21,21,21,21,21,
            21,21,21,21,21,21,21,21,21,21,
            21,22,23,23,23,27,27,27,27,28,
            28,26,26,6,6,35,35,30,13,13,
            13,9,9,9,9,9,2,2,2,2,
            3,3,3,3,3,3,3,3,3,3,
            3,3,3,3,3,3,3,3,3,3,
            3,3,3,3,3,3,4,4,4,4,
            4,4,4,4,4,4,4,4,4,4,
            4,4,4,4,4,4,4,4,4,4,
            4,4,1,1,1,1,1,1,1,1,
            1,1,37,37,37,37,37,37,37,37,
            38,38,38,38,38,38,38,38,38,38,
            38,38,36,36,39,39,39,15,15,40,
            40,29,29,11,11,11,11,11,32,32,
            32,32,32,32,32,32,32,32,32,32,
            32,32,32,32,32,32,32,32,32,32,
            32,32,32,32,32,32,32,32,17,17,
            17,17,17,17,17,17,17,17,17,17,
            17,17,17,17,17,17,17,17,17,17,
            17,17,17,17,17,17,17,18,18,18,
            18,18,18,18,18,18,18,18,18,18,
            18,18,18,18,18,18,18,18,18,18,
            18,18,18,18,18,18,7,7,7,7,
            7,7,7,7,7,7,7,7,7,7,
            7,7,7,7,7,7,7,7,7,7,
            7,7,7,7,7,7,14,14,14,14,
            31,31,31,31,31,31,31,31,19,19,
            19,19,19,8,8,8,8,8,5,20,
            33,33,10,10,12,12,16,24,24,24,
            24,24,24,24,24,24,25,21,26,891,
            481,480,480,480,2,356,1238,346,482,1282,
            493,1285,346,1249,410,483,1271,54,162,410,
            341,6,7,8,9,423,1225,54,339,490,
            309,485,485,485,485,485,984,485,485,44,
            433,336,431,309,485,485,485,485,485,1332,
            485,485,304,433,1216,447,406,459,459,459,
            459,459,990,459,459,1289,459,794,468,468,
            468,468,1293,54,1,47,47,47,47,404,
            1309,54,1290,47,1070,468,468,468,47,1320,
            54,47,1069,205,52,52,52,52,1147,1333,
            468,100,475,503,313,313,313,313,313,1218,
            313,313,994,402,498,498,498,986,402,1220,
            1260,419,1071,498,52,52,419,1335,498,600,
            313,313,313,313,313,1291,313,313,697,311,
            311,311,311,1334,1221,103,45,45,45,45,
            1288,1336,1337,1338,45,1339,311,311,311,45,
            1331,508,45,1073,165,164,164,164,1149,165,
            164,164,164,43,508,336,508,508
        };
    };
    public final static char baseAction[] = BaseAction.baseAction;
    public final int baseAction(int index) { return baseAction[index]; }
    public final static char lhs[] = baseAction;
    public final int lhs(int index) { return lhs[index]; };

    public interface TermCheck {
        public final static byte termCheck[] = {0,
            0,1,2,3,4,5,6,7,8,9,
            10,11,12,13,14,15,16,17,18,19,
            20,21,22,23,24,25,26,27,28,29,
            30,31,32,33,34,35,36,37,38,39,
            40,41,42,43,44,45,46,47,48,49,
            50,51,52,53,54,55,56,57,58,59,
            60,61,62,63,64,65,66,67,68,69,
            70,71,72,73,74,75,76,77,78,79,
            80,81,82,83,84,85,86,87,88,89,
            90,91,92,93,94,95,96,97,98,0,
            100,101,0,1,2,3,4,5,6,7,
            8,9,10,11,12,13,14,15,16,17,
            18,19,20,21,22,23,24,25,26,27,
            28,29,30,31,32,33,34,35,36,37,
            38,39,40,41,42,43,44,45,46,47,
            48,49,50,51,52,53,54,55,56,57,
            58,59,60,61,62,63,64,65,66,67,
            68,69,70,71,72,73,74,75,76,77,
            78,79,80,81,82,83,84,85,86,87,
            88,89,90,91,92,93,94,95,96,97,
            98,102,100,101,0,1,2,3,4,5,
            6,7,8,9,10,11,12,13,14,15,
            16,17,18,19,20,21,22,23,24,25,
            26,27,28,29,30,31,32,33,34,35,
            36,37,38,39,40,41,42,43,44,45,
            46,47,48,49,50,51,52,53,54,55,
            56,57,58,59,60,61,62,63,64,65,
            66,67,68,69,70,71,72,73,74,75,
            76,77,78,79,80,81,82,83,84,85,
            86,87,88,89,90,91,92,93,94,95,
            96,97,98,0,0,0,0,103,0,1,
            2,3,4,5,6,7,8,9,10,11,
            12,13,14,15,16,17,18,19,20,21,
            22,23,24,25,26,27,28,29,30,31,
            32,33,34,35,36,37,38,39,40,41,
            42,43,44,45,46,47,48,49,50,51,
            52,53,54,55,56,57,58,59,60,61,
            62,63,64,65,66,67,68,69,70,71,
            72,73,74,75,76,77,78,79,80,81,
            82,83,84,85,86,87,88,89,90,91,
            92,93,94,95,96,0,1,2,3,4,
            5,6,7,8,9,10,11,12,13,14,
            15,16,17,18,19,20,21,22,23,24,
            25,26,27,28,29,30,31,32,33,34,
            35,36,37,38,39,40,41,42,43,44,
            45,46,47,48,49,50,51,52,53,54,
            55,56,57,58,59,60,61,62,63,64,
            65,66,67,68,69,70,71,72,73,74,
            75,76,77,78,79,80,81,82,83,84,
            85,86,87,88,89,90,91,92,93,94,
            95,96,0,1,2,3,4,5,6,7,
            8,9,10,11,12,13,14,15,16,17,
            18,19,20,21,22,23,24,25,26,27,
            28,29,30,31,32,33,34,35,36,37,
            38,39,40,41,42,43,44,45,46,47,
            48,49,50,51,52,53,54,55,56,57,
            58,59,60,61,62,63,64,65,66,67,
            68,69,70,71,72,73,74,75,76,77,
            78,79,80,81,82,83,84,85,86,87,
            88,89,90,91,92,93,94,95,96,0,
            1,2,3,4,5,6,7,8,9,10,
            11,12,13,14,15,16,17,18,19,20,
            21,22,23,24,25,26,27,28,29,30,
            31,32,33,34,35,36,37,38,39,40,
            41,42,43,44,45,46,47,48,49,50,
            51,52,53,54,55,56,57,58,59,60,
            61,62,63,64,65,66,67,68,69,70,
            71,72,73,74,75,76,77,78,79,80,
            81,82,83,84,85,86,87,88,89,90,
            91,92,93,94,95,96,0,1,2,3,
            4,5,6,7,8,9,10,11,12,13,
            14,15,16,17,18,19,20,21,22,23,
            24,25,26,27,28,29,30,31,32,33,
            34,35,36,37,38,39,40,41,42,43,
            44,45,46,47,48,49,50,51,52,53,
            54,55,56,57,58,59,60,61,62,63,
            64,65,66,67,68,69,70,71,72,73,
            74,75,76,77,78,79,80,81,82,83,
            84,85,86,87,88,89,90,91,92,93,
            94,95,96,0,1,2,3,4,5,6,
            7,8,9,10,11,12,13,14,15,16,
            17,18,19,20,21,22,23,24,25,26,
            27,28,29,30,31,32,33,34,35,36,
            37,38,39,40,41,42,43,44,45,46,
            47,48,49,50,51,52,53,54,55,56,
            57,58,59,60,61,62,63,64,65,66,
            67,68,69,70,71,72,73,0,75,76,
            77,78,79,80,81,82,83,84,85,86,
            87,88,89,90,91,92,93,94,95,96,
            0,1,2,3,4,5,6,7,8,9,
            10,11,12,13,14,15,16,17,18,19,
            20,21,22,23,24,25,26,27,28,29,
            30,31,32,33,34,35,36,37,38,39,
            40,41,42,43,44,45,46,47,48,49,
            50,51,52,53,54,55,56,57,58,59,
            60,61,62,63,64,65,66,67,68,69,
            70,71,72,73,74,0,76,77,78,79,
            80,81,82,83,84,85,86,87,88,89,
            90,0,0,0,0,0,0,97,98,0,
            100,101,102,0,1,2,3,4,5,6,
            7,8,9,10,11,12,13,14,0,16,
            17,18,19,20,21,22,23,24,25,26,
            27,28,29,30,31,32,33,34,35,36,
            37,38,39,40,41,42,43,44,45,46,
            47,48,49,50,51,52,53,54,55,56,
            57,58,59,60,61,62,63,64,65,76,
            67,68,69,70,71,72,77,74,0,0,
            0,78,0,1,2,3,4,5,6,7,
            8,9,10,11,12,13,14,102,16,17,
            18,19,20,21,22,23,24,25,26,27,
            28,29,30,31,32,33,34,35,36,37,
            38,39,40,41,42,43,44,45,46,47,
            48,49,50,51,52,53,54,55,56,57,
            58,59,60,61,62,63,64,65,69,71,
            72,0,0,0,74,0,0,75,0,1,
            2,3,4,5,6,7,8,9,10,11,
            12,13,14,0,16,17,18,19,20,21,
            22,23,24,25,26,27,28,29,30,31,
            32,33,34,35,36,37,38,39,40,41,
            42,43,44,45,46,47,48,49,50,51,
            52,53,54,55,56,57,58,59,60,61,
            62,63,64,65,68,0,70,0,0,0,
            0,0,0,75,0,1,2,3,4,5,
            6,7,8,9,10,11,12,0,1,2,
            3,4,5,6,7,8,9,10,0,1,
            2,3,4,5,6,7,8,9,10,0,
            1,2,3,4,5,6,7,8,9,10,
            0,1,2,3,4,5,6,7,8,9,
            10,0,67,66,0,66,66,0,0,0,
            0,67,0,1,2,3,4,5,6,7,
            8,9,10,15,15,15,69,70,0,1,
            2,3,4,5,6,7,8,9,10,0,
            1,2,3,4,5,6,7,8,9,10,
            0,0,0,0,0,0,0,0,0,0,
            0,11,12,0,13,11,14,0,15,0,
            0,0,0,0,73,0,68,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,97,98,
            0,100,101,99,0,0,99,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,99,99,99,0,0,0,
            102,0
        };
    };
    public final static byte termCheck[] = TermCheck.termCheck;
    public final int termCheck(int index) { return termCheck[index]; }

    public interface TermAction {
        public final static char termAction[] = {0,
            508,555,555,555,555,555,555,555,555,555,
            555,555,555,555,555,555,555,555,555,555,
            555,555,555,555,555,555,555,555,555,555,
            555,555,555,555,555,555,555,555,555,555,
            555,555,555,555,555,555,555,555,555,555,
            555,555,555,555,555,555,555,555,555,555,
            555,555,555,555,555,555,555,555,555,555,
            555,554,475,555,555,555,555,555,555,555,
            555,555,555,555,555,555,555,555,555,555,
            555,555,555,555,555,555,555,555,555,508,
            555,555,508,553,553,553,553,553,553,553,
            553,553,553,553,553,553,553,553,553,553,
            553,553,553,553,553,553,553,553,553,553,
            553,553,553,553,553,553,553,553,553,553,
            553,553,553,553,553,553,553,553,553,553,
            553,553,553,553,553,553,553,553,553,553,
            553,553,553,553,553,553,553,553,553,553,
            553,553,553,519,558,553,553,553,553,553,
            553,553,553,553,553,553,553,553,553,553,
            553,553,553,553,553,553,553,553,553,553,
            553,513,553,553,10,560,560,560,560,560,
            560,560,560,560,560,560,560,560,560,560,
            560,560,560,560,560,560,560,560,560,560,
            560,560,560,560,560,560,560,560,560,560,
            560,560,560,560,560,560,560,560,560,560,
            560,560,560,560,560,560,560,560,560,560,
            560,560,560,560,560,560,560,560,560,560,
            560,560,560,560,560,560,560,560,560,560,
            560,560,560,560,560,560,560,560,560,560,
            560,560,560,560,560,560,560,560,560,560,
            560,560,560,48,508,508,508,560,314,485,
            485,485,485,485,485,485,485,485,485,485,
            485,485,485,485,485,485,485,485,485,485,
            485,485,485,485,485,485,485,485,485,485,
            485,485,485,485,485,485,485,485,485,485,
            485,485,485,485,485,485,485,485,485,485,
            485,485,485,485,485,485,485,485,485,485,
            485,485,485,485,439,485,485,485,485,485,
            485,485,485,485,485,485,485,485,485,485,
            485,485,485,485,485,485,485,485,485,485,
            485,485,485,485,485,508,459,459,459,459,
            459,459,459,459,459,459,459,459,459,459,
            459,459,459,459,459,459,459,459,459,459,
            459,459,459,459,459,459,459,459,459,459,
            459,459,459,459,459,459,459,459,459,459,
            459,459,459,459,459,459,459,459,459,459,
            459,459,459,459,459,459,459,459,459,459,
            459,449,459,459,459,459,459,459,459,459,
            459,459,459,459,459,459,459,459,459,459,
            459,459,459,459,459,459,459,459,459,459,
            459,459,315,821,821,821,821,821,821,821,
            821,821,821,821,821,821,821,821,821,821,
            821,821,821,821,821,821,821,821,821,821,
            821,821,821,821,821,821,821,821,821,821,
            821,821,821,821,821,821,821,821,821,821,
            821,821,821,821,821,821,821,821,821,821,
            821,821,821,821,821,821,821,821,439,821,
            821,821,821,821,821,821,821,821,821,821,
            821,821,821,821,821,821,821,821,821,821,
            821,821,821,821,821,821,821,821,821,508,
            821,821,821,821,821,821,821,821,821,821,
            821,821,821,821,821,821,821,821,821,821,
            821,821,821,821,821,821,821,821,821,821,
            821,821,821,821,821,821,821,821,821,821,
            821,821,821,821,821,821,821,821,821,821,
            821,821,821,821,821,821,821,821,821,821,
            821,821,821,821,821,474,821,821,821,821,
            821,821,821,821,821,821,821,821,821,821,
            821,821,821,821,821,821,821,821,821,821,
            821,821,821,821,821,821,508,819,819,819,
            819,819,819,819,819,819,819,819,819,819,
            819,819,819,819,819,819,819,819,819,819,
            819,819,819,819,819,819,819,819,819,819,
            819,819,819,819,819,819,819,819,819,819,
            819,819,819,819,819,819,819,819,819,819,
            819,819,819,819,819,819,819,819,819,819,
            819,819,819,819,819,819,819,819,819,819,
            824,819,819,819,819,819,819,819,819,819,
            819,819,819,819,819,819,819,819,819,819,
            819,819,452,508,468,468,468,468,468,468,
            468,468,468,468,468,468,468,468,468,468,
            468,468,468,468,468,468,468,468,468,468,
            468,468,468,468,468,468,468,468,468,468,
            468,468,468,468,468,468,468,468,468,468,
            468,468,468,468,468,468,468,468,468,468,
            468,468,468,468,468,468,468,468,468,468,
            468,468,468,468,468,468,468,508,468,468,
            468,468,468,468,468,468,468,468,468,468,
            468,468,468,468,468,468,468,468,468,452,
            508,481,481,481,481,481,481,481,481,481,
            481,480,480,480,480,529,480,480,480,480,
            480,480,480,480,480,480,480,480,480,480,
            480,480,480,480,480,480,480,480,480,480,
            480,480,480,480,480,480,480,480,480,480,
            480,480,480,480,480,480,480,480,480,480,
            480,480,480,480,480,480,386,384,412,414,
            428,422,523,482,397,508,366,392,395,538,
            379,360,542,535,536,533,534,548,539,525,
            526,508,508,38,508,508,508,482,482,32,
            482,482,373,508,402,402,402,402,402,402,
            402,402,402,402,498,498,498,498,508,498,
            498,498,498,498,498,498,498,498,498,498,
            498,498,498,498,498,498,498,498,498,498,
            498,498,498,498,498,498,498,498,498,498,
            498,498,498,498,498,498,498,498,498,498,
            498,498,498,498,498,498,498,498,498,547,
            834,465,826,827,829,828,541,397,16,13,
            508,473,1,673,673,673,673,673,673,673,
            673,673,673,672,672,672,672,512,672,672,
            672,672,672,672,672,672,672,672,672,672,
            672,672,672,672,672,672,672,672,672,672,
            672,672,672,672,672,672,672,672,672,672,
            672,672,672,672,672,672,672,672,672,672,
            672,672,672,672,672,672,672,672,835,836,
            382,508,508,508,817,508,14,674,317,673,
            673,673,673,673,673,673,673,673,673,672,
            672,672,672,508,672,672,672,672,672,672,
            672,672,672,672,672,672,672,672,672,672,
            672,672,672,672,672,672,672,672,672,672,
            672,672,672,672,672,672,672,672,672,672,
            672,672,672,672,672,672,672,672,672,672,
            672,672,672,672,537,35,559,508,508,308,
            3,508,508,674,6,562,562,562,562,562,
            562,562,562,562,562,336,336,508,346,346,
            346,346,346,346,346,346,346,346,508,410,
            410,410,410,410,410,410,410,410,410,508,
            419,419,419,419,419,419,419,419,419,419,
            58,562,562,562,562,562,562,562,562,562,
            562,12,544,816,508,816,816,163,20,19,
            325,442,57,562,562,562,562,562,562,562,
            562,562,562,531,530,832,343,450,60,562,
            562,562,562,562,562,562,562,562,562,59,
            562,562,562,562,562,562,562,562,562,562,
            7,508,508,322,508,53,161,167,312,508,
            508,336,336,508,429,545,457,508,831,508,
            508,508,508,508,670,508,532,508,508,508,
            508,508,508,508,508,508,508,508,508,508,
            508,508,508,508,508,508,508,508,670,670,
            508,670,670,507,508,508,1,508,508,508,
            508,508,508,508,508,508,508,508,508,508,
            508,508,508,508,508,508,508,508,508,508,
            508,508,508,508,508,508,508,508,508,508,
            508,508,508,508,508,508,508,508,508,508,
            508,508,508,508,6,12,1,508,508,508,
            315
        };
    };
    public final static char termAction[] = TermAction.termAction;
    public final int termAction(int index) { return termAction[index]; }
    public final int asb(int index) { return 0; }
    public final int asr(int index) { return 0; }
    public final int nasb(int index) { return 0; }
    public final int nasr(int index) { return 0; }
    public final int terminalIndex(int index) { return 0; }
    public final int nonterminalIndex(int index) { return 0; }
    public final int scopePrefix(int index) { return 0;}
    public final int scopeSuffix(int index) { return 0;}
    public final int scopeLhs(int index) { return 0;}
    public final int scopeLa(int index) { return 0;}
    public final int scopeStateSet(int index) { return 0;}
    public final int scopeRhs(int index) { return 0;}
    public final int scopeState(int index) { return 0;}
    public final int inSymb(int index) { return 0;}
    public final String name(int index) { return null; }
    public final int getErrorSymbol() { return 0; }
    public final int getScopeUbound() { return 0; }
    public final int getScopeSize() { return 0; }
    public final int getMaxNameLength() { return 0; }

    public final static int
           NUM_STATES        = 50,
           NT_OFFSET         = 103,
           LA_STATE_OFFSET   = 836,
           MAX_LA            = 1,
           NUM_RULES         = 328,
           NUM_NONTERMINALS  = 40,
           NUM_SYMBOLS       = 143,
           SEGMENT_SIZE      = 8192,
           START_STATE       = 329,
           IDENTIFIER_SYMBOL = 0,
           EOFT_SYMBOL       = 99,
           EOLT_SYMBOL       = 104,
           ACCEPT_ACTION     = 507,
           ERROR_ACTION      = 508;

    public final static boolean BACKTRACK = false;

    public final int getNumStates() { return NUM_STATES; }
    public final int getNtOffset() { return NT_OFFSET; }
    public final int getLaStateOffset() { return LA_STATE_OFFSET; }
    public final int getMaxLa() { return MAX_LA; }
    public final int getNumRules() { return NUM_RULES; }
    public final int getNumNonterminals() { return NUM_NONTERMINALS; }
    public final int getNumSymbols() { return NUM_SYMBOLS; }
    public final int getSegmentSize() { return SEGMENT_SIZE; }
    public final int getStartState() { return START_STATE; }
    public final int getStartSymbol() { return lhs[0]; }
    public final int getIdentifierSymbol() { return IDENTIFIER_SYMBOL; }
    public final int getEoftSymbol() { return EOFT_SYMBOL; }
    public final int getEoltSymbol() { return EOLT_SYMBOL; }
    public final int getAcceptAction() { return ACCEPT_ACTION; }
    public final int getErrorAction() { return ERROR_ACTION; }
    public final boolean isValidForParser() { return isValidForParser; }
    public final boolean getBacktrack() { return BACKTRACK; }

    public final int originalState(int state) { return 0; }
    public final int asi(int state) { return 0; }
    public final int nasi(int state) { return 0; }
    public final int inSymbol(int state) { return 0; }

    public final int ntAction(int state, int sym) {
        return baseAction[state + sym];
    }

    public final int tAction(int state, int sym) {
        int i = baseAction[state],
            k = i + sym;
        return termAction[termCheck[k] == sym ? k : i];
    }
    public final int lookAhead(int la_state, int sym) {
        int k = la_state + sym;
        return termAction[termCheck[k] == sym ? k : la_state];
    }
}
