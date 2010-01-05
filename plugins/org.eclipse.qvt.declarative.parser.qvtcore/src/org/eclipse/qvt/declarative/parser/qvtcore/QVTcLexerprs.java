/**
* Essential OCL Lexer
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
*   Borland - Bug 242880
*   E.D.Willink - Bug 292112
*   Adolfo Sanchez-Barbudo Herrera (Open Canarias) - LPG v 2.0.17 adoption (242153)
*   E.D.Willink - Extended API and implementation for QVTc
*
* </copyright>
*
* $Id: QVTcLexerprs.java,v 1.12 2010/01/05 11:41:47 ewillink Exp $
*/

package org.eclipse.qvt.declarative.parser.qvtcore;

public class QVTcLexerprs implements lpg.runtime.ParseTable, QVTcLexersym {
    public final static int ERROR_SYMBOL = 0;
    public final int getErrorSymbol() { return ERROR_SYMBOL; }

    public final static int SCOPE_UBOUND = 0;
    public final int getScopeUbound() { return SCOPE_UBOUND; }

    public final static int SCOPE_SIZE = 0;
    public final int getScopeSize() { return SCOPE_SIZE; }

    public final static int MAX_NAME_LENGTH = 0;
    public final int getMaxNameLength() { return MAX_NAME_LENGTH; }

    public final static int NUM_STATES = 39;
    public final int getNumStates() { return NUM_STATES; }

    public final static int NT_OFFSET = 103;
    public final int getNtOffset() { return NT_OFFSET; }

    public final static int LA_STATE_OFFSET = 705;
    public final int getLaStateOffset() { return LA_STATE_OFFSET; }

    public final static int MAX_LA = 2;
    public final int getMaxLa() { return MAX_LA; }

    public final static int NUM_RULES = 265;
    public final int getNumRules() { return NUM_RULES; }

    public final static int NUM_NONTERMINALS = 35;
    public final int getNumNonterminals() { return NUM_NONTERMINALS; }

    public final static int NUM_SYMBOLS = 138;
    public final int getNumSymbols() { return NUM_SYMBOLS; }

    public final static int SEGMENT_SIZE = 8192;
    public final int getSegmentSize() { return SEGMENT_SIZE; }

    public final static int START_STATE = 266;
    public final int getStartState() { return START_STATE; }

    public final static int IDENTIFIER_SYMBOL = 0;
    public final int getIdentifier_SYMBOL() { return IDENTIFIER_SYMBOL; }

    public final static int EOFT_SYMBOL = 102;
    public final int getEoftSymbol() { return EOFT_SYMBOL; }

    public final static int EOLT_SYMBOL = 104;
    public final int getEoltSymbol() { return EOLT_SYMBOL; }

    public final static int ACCEPT_ACTION = 439;
    public final int getAcceptAction() { return ACCEPT_ACTION; }

    public final static int ERROR_ACTION = 440;
    public final int getErrorAction() { return ERROR_ACTION; }

    public final static boolean BACKTRACK = false;
    public final boolean getBacktrack() { return BACKTRACK; }

    public final int getStartSymbol() { return lhs(0); }
    public final boolean isValidForParser() { return QVTcLexersym.isValidForParser; }


    public interface IsNullable {
        public final static byte isNullable[] = {0,
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
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,1,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,1,
            0,0,0,0,0,0,0,0
        };
    };
    public final static byte isNullable[] = IsNullable.isNullable;
    public final boolean isNullable(int index) { return isNullable[index] != 0; }

    public interface ProsthesesIndex {
        public final static byte prosthesesIndex[] = {0,
            19,22,23,24,27,32,14,21,29,34,
            5,35,7,8,16,17,20,26,28,33,
            2,3,4,6,9,10,11,12,13,15,
            18,25,30,31,1
        };
    };
    public final static byte prosthesesIndex[] = ProsthesesIndex.prosthesesIndex;
    public final int prosthesesIndex(int index) { return prosthesesIndex[index]; }

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
            1,3,3,3,3,1,2,2,1,1,
            5,1,1,1,1,1,1,1,1,1,
            1,2,2,2,1,1,1,1,2,1,
            1,1,2,1,1,1,1,2,1,1,
            2,2,3,2,2,0,1,2,2,2,
            1,2,3,2,3,3,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            2,1,2,2,2,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            2,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,2,1,
            2,0,1,2,2
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
            21,21,21,21,21,21,13,21,14,24,
            25,25,25,27,27,27,27,28,28,26,
            26,7,7,30,15,15,15,8,8,8,
            8,8,2,2,2,2,3,3,3,3,
            3,3,3,3,3,3,3,3,3,3,
            3,3,3,3,3,3,3,3,3,3,
            3,3,4,4,4,4,4,4,4,4,
            4,4,4,4,4,4,4,4,4,4,
            4,4,4,4,4,4,4,4,1,1,
            1,1,1,1,1,1,1,1,17,17,
            29,29,22,22,22,22,32,32,32,32,
            32,32,32,32,32,32,32,32,32,32,
            32,32,32,32,32,32,32,32,32,32,
            32,32,32,32,32,32,18,18,18,18,
            18,18,18,18,18,18,18,18,18,18,
            18,18,18,18,18,18,18,18,18,18,
            18,18,18,18,18,5,5,5,5,5,
            5,5,5,5,5,5,5,5,5,5,
            5,5,5,5,5,5,5,5,5,5,
            5,5,5,19,19,9,9,33,33,33,
            33,6,16,16,16,16,31,31,31,31,
            31,31,31,31,34,34,34,34,20,20,
            20,20,20,10,10,10,10,10,23,23,
            12,12,11,11,21,26,792,413,403,403,
            403,986,275,357,418,1036,52,1051,275,35,
            37,894,134,133,133,133,1047,277,281,1103,
            304,9,405,869,131,286,377,501,421,421,
            421,421,421,421,1106,1104,421,421,376,343,
            501,421,421,421,421,421,421,7,8,421,
            421,384,343,501,421,421,421,421,421,421,
            1058,52,421,421,393,343,598,360,360,360,
            360,360,360,695,261,261,261,261,261,261,
            1112,302,261,261,1048,360,360,972,52,360,
            404,259,259,259,259,259,259,1,45,45,
            45,45,42,1107,271,45,1049,1102,367,259,
            259,1069,52,45,1053,45,307,231,231,231,
            231,231,41,1052,271,396,102,43,43,43,
            43,1080,52,1054,43,203,50,50,50,50,
            1003,330,43,1055,43,1014,381,330,1056,231,
            231,1050,381,1025,401,440,440,440,440,440,
            401,440,440,440,440,440,50,50,440,440
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
            90,91,92,93,94,95,96,97,98,99,
            100,0,1,2,3,4,5,6,7,8,
            9,10,11,12,13,14,15,16,17,18,
            19,20,21,22,23,24,25,26,27,28,
            29,30,31,32,33,34,35,36,37,38,
            39,40,41,42,43,44,45,46,47,48,
            49,50,51,52,53,54,55,56,57,58,
            59,60,61,62,63,64,65,66,67,68,
            69,70,71,72,73,74,75,76,77,78,
            79,80,81,82,83,84,85,86,87,88,
            89,90,91,92,93,94,95,96,97,98,
            99,100,0,1,2,3,4,5,6,7,
            8,9,10,11,12,13,14,15,16,17,
            18,19,20,21,22,23,24,25,26,27,
            28,29,30,31,32,33,34,35,36,37,
            38,39,40,41,42,43,44,45,46,47,
            48,49,50,51,52,53,54,55,56,57,
            58,59,60,61,62,63,64,65,66,67,
            68,69,70,71,72,73,74,75,76,77,
            78,79,80,81,82,83,84,85,86,87,
            88,89,90,91,92,93,94,95,96,97,
            98,0,0,0,0,103,0,1,2,3,
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
            67,68,69,70,71,72,73,74,75,76,
            77,78,79,80,81,82,83,84,85,86,
            87,88,89,90,91,92,93,94,95,96,
            0,1,2,3,4,5,6,7,8,9,
            10,11,12,13,14,15,16,17,18,19,
            20,21,22,23,24,25,26,27,28,29,
            30,31,32,33,34,35,36,37,38,39,
            40,41,42,43,44,45,46,47,48,49,
            50,51,52,53,54,55,56,57,58,59,
            60,61,62,63,64,65,66,67,68,69,
            70,71,72,73,0,75,76,77,78,79,
            80,81,82,83,84,85,86,87,88,89,
            90,91,92,93,94,95,96,0,1,2,
            3,4,5,6,7,8,9,10,11,12,
            13,14,15,16,17,18,19,20,21,22,
            23,24,25,26,27,28,29,30,31,32,
            33,34,35,36,37,38,39,40,41,42,
            43,44,45,46,47,48,49,50,51,52,
            53,54,55,56,57,58,59,60,61,62,
            63,64,65,66,67,68,69,70,71,72,
            73,74,75,76,77,78,79,80,81,82,
            83,84,85,86,0,88,89,90,91,92,
            93,94,95,96,0,1,2,3,4,5,
            6,7,8,9,10,11,12,13,14,15,
            16,17,18,19,20,21,22,23,24,25,
            26,27,28,29,30,31,32,33,34,35,
            36,37,38,39,40,41,42,43,44,45,
            46,47,48,49,50,51,52,53,54,55,
            56,57,58,59,60,61,62,63,64,65,
            66,67,68,69,70,71,72,73,0,75,
            76,77,78,79,80,81,82,83,84,85,
            86,87,88,89,90,91,92,93,94,95,
            96,0,1,2,3,4,5,6,7,8,
            9,10,11,12,13,14,15,16,17,18,
            19,20,21,22,23,24,25,26,27,28,
            29,30,31,32,33,34,35,36,37,38,
            39,40,41,42,43,44,45,46,47,48,
            49,50,51,52,53,54,55,56,57,58,
            59,60,61,62,63,64,65,66,67,68,
            69,70,71,72,73,74,75,76,0,78,
            79,80,81,82,83,84,85,86,87,0,
            0,0,14,15,0,0,0,0,97,98,
            99,100,101,0,1,2,3,4,5,6,
            7,8,9,10,11,12,0,0,0,0,
            17,18,19,20,21,22,23,24,25,26,
            27,28,29,30,31,32,33,34,35,36,
            37,38,39,40,41,42,43,44,45,46,
            47,48,49,50,51,52,53,54,55,56,
            57,58,59,60,61,62,63,64,65,66,
            67,68,0,0,0,0,0,0,0,0,
            77,0,1,2,3,4,5,6,7,8,
            9,10,11,12,13,0,1,2,3,4,
            5,6,7,8,9,10,0,0,0,0,
            0,16,0,1,2,3,4,5,6,7,
            8,9,10,0,1,2,3,4,5,6,
            7,8,9,10,0,1,2,3,4,5,
            6,7,8,9,10,0,1,2,3,4,
            5,6,7,8,9,10,0,0,0,0,
            0,0,0,0,0,0,71,0,1,2,
            3,4,5,6,7,8,9,10,0,1,
            2,3,4,5,6,7,8,9,10,0,
            1,2,3,4,5,6,7,8,9,10,
            0,1,2,3,4,5,6,7,8,9,
            10,0,0,0,0,0,0,0,0,0,
            0,0,11,12,0,69,14,14,13,72,
            73,15,16,74,13,74,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,97,98,99,100,0,0,101,
            101,0,102,101,0,102,102,102,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,70,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0
        };
    };
    public final static byte termCheck[] = TermCheck.termCheck;
    public final int termCheck(int index) { return termCheck[index]; }

    public interface TermAction {
        public final static char termAction[] = {0,
            440,485,485,485,485,485,485,485,485,485,
            485,485,485,485,485,485,485,485,485,485,
            485,485,485,485,485,485,485,485,485,485,
            485,485,485,485,485,485,485,485,485,485,
            485,485,485,485,485,485,485,485,485,485,
            485,485,485,485,485,485,485,485,485,485,
            485,485,485,485,485,485,485,485,485,485,
            485,485,484,396,485,485,485,485,485,485,
            485,485,485,485,485,485,485,485,485,485,
            485,485,485,485,485,485,485,485,485,485,
            485,440,483,483,483,483,483,483,483,483,
            483,483,483,483,483,483,483,483,483,483,
            483,483,483,483,483,483,483,483,483,483,
            483,483,483,483,483,483,483,483,483,483,
            483,483,483,483,483,483,483,483,483,483,
            483,483,483,483,483,483,483,483,483,483,
            483,483,483,483,483,483,483,483,483,483,
            483,483,483,451,488,483,483,483,483,483,
            483,483,483,483,483,483,483,483,483,483,
            483,483,483,483,483,483,483,483,483,483,
            483,483,10,490,490,490,490,490,490,490,
            490,490,490,490,490,490,490,490,490,490,
            490,490,490,490,490,490,490,490,490,490,
            490,490,490,490,490,490,490,490,490,490,
            490,490,490,490,490,490,490,490,490,490,
            490,490,490,490,490,490,490,490,490,490,
            490,490,490,490,490,490,490,490,490,490,
            490,490,490,490,490,490,490,490,490,490,
            490,490,490,490,490,490,490,490,490,490,
            490,490,490,490,490,490,490,490,490,490,
            490,46,440,440,440,490,440,671,671,671,
            671,671,671,671,671,671,671,671,671,671,
            671,671,671,671,671,671,671,671,671,671,
            671,671,671,671,671,671,671,671,671,671,
            671,671,671,671,671,671,671,671,671,671,
            671,671,671,671,671,671,671,671,671,671,
            671,671,671,671,671,671,671,671,671,671,
            671,671,671,671,671,671,671,671,671,671,
            671,671,671,671,671,671,671,671,671,671,
            671,671,671,671,671,671,671,671,671,671,
            671,671,671,440,699,699,699,699,699,699,
            699,699,699,699,699,699,699,699,699,699,
            699,699,699,699,699,699,699,699,699,699,
            699,699,699,699,699,699,699,699,699,699,
            699,699,699,699,699,699,699,699,699,699,
            699,699,699,699,699,699,699,699,699,699,
            699,699,699,699,699,699,699,699,699,699,
            699,699,699,699,699,699,699,699,699,699,
            699,699,699,699,699,699,699,699,699,699,
            442,699,699,699,699,699,699,699,386,699,
            262,421,421,421,421,421,421,421,421,421,
            421,421,421,421,421,421,421,421,421,421,
            421,421,421,421,421,421,421,421,421,421,
            421,421,421,421,421,421,421,421,421,421,
            421,421,421,421,421,421,421,421,421,421,
            421,421,421,421,421,421,421,421,421,421,
            421,421,421,421,421,421,421,421,421,421,
            421,421,421,421,440,421,421,421,421,421,
            421,421,421,421,421,421,421,421,421,421,
            421,421,421,421,421,386,421,440,360,360,
            360,360,360,360,360,360,360,360,360,360,
            360,360,360,360,360,360,360,360,360,360,
            360,360,360,360,360,360,360,360,360,360,
            360,360,360,360,360,360,360,360,360,360,
            360,360,360,360,360,360,360,360,360,360,
            360,360,360,360,360,360,360,360,360,360,
            360,360,360,360,360,360,360,360,360,360,
            360,360,360,360,360,360,360,360,360,360,
            360,360,360,360,440,360,360,360,360,360,
            360,360,386,360,263,701,701,701,701,701,
            701,701,701,701,701,701,701,701,701,701,
            701,701,701,701,701,701,701,701,701,701,
            701,701,701,701,701,701,701,701,701,701,
            701,701,701,701,701,701,701,701,701,701,
            701,701,701,701,701,701,701,701,701,701,
            701,701,701,701,701,701,701,701,701,701,
            701,701,701,701,701,701,701,701,440,701,
            701,701,701,701,701,701,701,701,701,701,
            701,701,701,701,701,701,701,701,701,386,
            701,440,413,413,413,413,413,413,413,413,
            413,413,403,403,350,461,305,373,403,403,
            403,403,403,403,403,403,403,403,403,403,
            403,403,403,403,403,403,403,403,403,403,
            403,403,403,403,403,403,403,403,403,403,
            403,403,403,403,403,403,403,403,403,403,
            403,403,403,403,403,403,403,403,403,403,
            418,289,453,354,455,323,470,297,20,474,
            467,468,465,466,471,293,457,458,336,440,
            440,440,463,464,440,440,440,440,418,418,
            418,418,310,1,574,574,574,574,574,574,
            574,574,574,574,573,573,440,440,440,440,
            573,573,573,573,573,573,573,573,573,573,
            573,573,573,573,573,573,573,573,573,573,
            573,573,573,573,573,573,573,573,573,573,
            573,573,573,573,573,573,573,573,573,573,
            573,573,573,573,573,573,573,573,573,573,
            573,573,440,440,440,440,440,440,440,440,
            575,39,492,492,492,492,492,492,492,492,
            492,492,271,271,1796,440,275,275,275,275,
            275,275,275,275,275,275,440,440,440,440,
            440,423,440,330,330,330,330,330,330,330,
            330,330,330,440,381,381,381,381,381,381,
            381,381,381,381,440,401,401,401,401,401,
            401,401,401,401,401,54,492,492,492,492,
            492,492,492,492,492,492,12,16,440,260,
            440,440,440,132,51,130,415,53,492,492,
            492,492,492,492,492,492,492,492,56,492,
            492,492,492,492,492,492,492,492,492,55,
            492,492,492,492,492,492,492,492,492,492,
            39,410,410,410,410,410,410,410,410,410,
            410,9,32,19,440,6,14,440,440,440,
            440,36,271,271,440,571,704,462,350,705,
            351,469,489,263,478,443,440,440,440,440,
            440,440,440,440,440,440,440,440,440,440,
            440,440,440,571,571,571,571,440,440,445,
            263,440,439,444,440,1,39,12,440,440,
            440,440,440,440,440,440,440,440,440,440,
            440,440,473
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
    public final int originalState(int state) { return 0; }
    public final int asi(int state) { return 0; }
    public final int nasi(int state) { return 0; }
    public final int inSymbol(int state) { return 0; }

    /**
     * assert(! goto_default);
     */
    public final int ntAction(int state, int sym) {
        return baseAction[state + sym];
    }

    /**
     * assert(! shift_default);
     */
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
