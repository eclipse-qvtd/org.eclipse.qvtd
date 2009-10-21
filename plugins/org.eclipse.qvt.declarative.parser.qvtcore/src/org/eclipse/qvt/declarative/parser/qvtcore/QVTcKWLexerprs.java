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
* $Id: QVTcKWLexerprs.java,v 1.10 2009/10/21 07:48:38 ewillink Exp $
*/

package org.eclipse.qvt.declarative.parser.qvtcore;

public class QVTcKWLexerprs implements lpg.lpgjavaruntime.ParseTable, QVTcKWLexersym {

    public interface IsKeyword {
        public final static byte isKeyword[] = {0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0
        };
    };
    public final static byte isKeyword[] = IsKeyword.isKeyword;
    public final boolean isKeyword(int index) { return isKeyword[index] != 0; }

    public interface BaseCheck {
        public final static byte baseCheck[] = {0,
            4,2,4,4,5,3,2,3,3,7,
            3,2,4,5,3,3,8,10,10,7,
            6,6,8,3,3,7,6,6,13,8,
            7,6,7,16,4,7,5,6,7,10,
            4,7,5,8,7,8,7,7,3,5,
            7,7,14,4,5
        };
    };
    public final static byte baseCheck[] = BaseCheck.baseCheck;
    public final int baseCheck(int index) { return baseCheck[index]; }
    public final static byte rhs[] = baseCheck;
    public final int rhs(int index) { return rhs[index]; };

    public interface BaseAction {
        public final static char baseAction[] = {
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,58,43,32,
            91,97,102,111,109,113,115,117,122,42,
            55,124,56,68,57,125,70,127,74,128,
            17,72,37,82,134,136,138,129,16,131,
            140,141,23,45,144,150,146,153,154,157,
            158,159,161,163,84,164,170,171,173,176,
            178,180,75,182,86,107,93,184,166,186,
            142,188,190,192,191,198,197,199,201,203,
            208,204,212,214,215,218,216,220,222,223,
            30,226,228,233,229,234,39,237,238,239,
            241,242,243,250,251,253,255,256,258,92,
            260,105,264,262,267,268,271,269,273,274,
            275,276,281,280,285,286,290,291,295,293,
            300,302,304,305,310,313,315,311,307,317,
            321,319,322,325,329,331,323,333,337,334,
            342,344,338,346,347,348,350,351,352,355,
            356,360,358,361,363,373,365,364,368,378,
            379,380,383,384,388,389,390,391,399,395,
            401,403,405,406,409,408,413,414,415,417,
            419,425,422,427,429,432,434,435,433,436,
            445,437,439,447,448,450,451,453,454,460,
            459,461,463,465,467,468,471,472,476,477,
            479,484,485,487,488,494,498,495,478,500,
            501,503,505,504,511,287,287
        };
    };
    public final static char baseAction[] = BaseAction.baseAction;
    public final int baseAction(int index) { return baseAction[index]; }
    public final static char lhs[] = baseAction;
    public final int lhs(int index) { return lhs[index]; };

    public interface TermCheck {
        public final static byte termCheck[] = {0,
            0,1,2,3,4,5,6,7,8,9,
            10,11,12,13,14,0,0,2,2,19,
            4,21,0,23,24,3,26,27,13,0,
            30,0,32,33,34,35,0,21,0,3,
            4,0,0,2,0,9,5,6,17,13,
            14,22,8,24,0,0,0,13,17,5,
            22,6,6,8,8,36,12,0,1,0,
            3,0,28,0,0,6,5,4,5,37,
            11,0,1,0,10,0,3,6,17,15,
            0,0,0,2,0,10,0,6,13,9,
            8,0,19,11,0,1,0,11,0,8,
            0,1,0,1,0,9,0,13,4,11,
            4,0,1,0,0,1,0,0,0,6,
            0,4,6,0,1,0,1,0,1,0,
            0,0,2,0,1,0,18,8,18,0,
            1,6,0,0,2,2,0,0,0,2,
            0,20,0,0,6,0,10,5,5,0,
            0,2,0,3,2,0,16,0,3,0,
            1,0,5,0,1,0,1,0,7,0,
            0,0,27,2,5,5,0,0,0,1,
            0,5,0,0,2,18,9,0,8,2,
            7,0,1,0,0,0,2,0,1,0,
            7,0,0,8,2,0,1,0,0,2,
            9,12,0,0,2,7,0,0,0,2,
            0,0,0,1,11,9,6,9,7,0,
            0,1,0,4,0,0,4,0,4,0,
            5,0,3,0,1,8,0,0,0,3,
            0,1,0,0,0,0,15,4,11,0,
            0,7,14,3,0,0,1,12,16,0,
            0,0,0,4,0,11,6,5,4,0,
            1,0,1,0,0,1,0,4,29,0,
            0,2,0,1,0,5,0,3,0,13,
            0,0,0,2,0,9,8,7,0,5,
            0,1,0,0,12,7,0,0,2,7,
            7,0,1,0,1,0,0,0,3,0,
            0,0,5,7,0,0,1,0,7,0,
            0,12,0,0,0,8,4,0,31,15,
            20,12,0,9,2,12,16,0,0,0,
            13,3,0,0,1,3,7,0,0,0,
            0,3,0,3,0,6,19,10,0,5,
            0,3,0,1,0,0,1,0,0,9,
            6,3,0,0,0,8,0,3,0,0,
            4,0,10,10,0,1,0,6,0,1,
            12,0,0,0,0,0,0,11,0,4,
            4,10,9,9,0,1,0,0,2,0,
            0,1,0,0,1,23,7,5,0,0,
            0,1,0,25,0,1,0,0,10,7,
            0,0,6,26,15,0,0,0,0,3,
            9,14,4,0,0,10,0,0,11,3,
            3,8,8,0,0,25,3,0,1,0,
            0,7,0,0,0,0,6,5,4,10,
            0,8,2,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
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
            287,80,75,81,76,68,78,82,79,83,
            63,60,69,74,62,287,287,127,115,61,
            114,77,287,72,67,132,73,66,128,287,
            59,287,71,70,65,64,287,113,287,119,
            120,287,287,96,287,118,94,97,84,289,
            121,178,134,176,287,287,287,133,95,99,
            184,101,105,102,106,177,98,287,104,287,
            103,287,135,287,287,109,116,111,294,286,
            108,287,123,287,293,287,302,122,117,311,
            287,287,287,194,287,151,287,193,150,85,
            153,287,145,154,287,196,287,86,287,87,
            287,88,287,90,287,152,287,288,91,89,
            92,287,93,287,287,107,287,287,287,100,
            287,112,110,287,124,287,125,287,126,287,
            287,12,131,287,136,287,336,130,129,287,
            137,138,287,287,139,140,287,287,287,142,
            287,158,287,287,143,287,141,144,146,287,
            287,147,287,298,148,287,303,287,296,287,
            312,287,295,287,155,287,157,287,149,287,
            287,287,156,161,160,162,287,287,287,164,
            287,163,287,287,166,159,341,287,165,322,
            167,287,168,287,287,287,170,287,171,287,
            169,287,287,172,175,287,179,287,287,180,
            174,173,287,287,181,182,287,287,287,328,
            287,287,287,291,183,185,187,186,188,287,
            287,300,287,189,287,287,290,287,190,287,
            191,287,195,287,342,192,287,287,287,197,
            287,324,287,287,287,287,337,201,198,287,
            287,202,199,204,287,287,206,203,200,287,
            287,287,287,207,287,205,208,210,209,287,
            211,287,212,287,287,214,287,213,330,287,
            287,215,287,301,287,217,287,216,287,292,
            287,287,287,221,287,218,220,219,287,222,
            287,224,287,287,225,223,287,287,227,226,
            228,287,229,287,230,287,287,287,315,287,
            287,287,233,232,287,287,237,287,236,287,
            287,234,287,287,287,239,240,287,231,325,
            235,238,287,309,308,241,319,287,287,287,
            242,244,287,287,247,246,245,287,287,287,
            287,314,287,332,287,249,243,248,287,320,
            287,250,287,338,287,287,318,287,287,339,
            251,252,287,287,287,253,287,255,287,287,
            323,287,326,254,287,334,287,257,287,307,
            256,287,287,287,287,287,287,258,26,333,
            331,329,335,297,287,260,287,287,262,287,
            287,304,287,287,310,259,264,265,287,287,
            287,267,287,261,287,269,287,287,266,268,
            287,287,270,263,317,287,287,287,287,306,
            273,271,305,287,287,327,287,287,281,276,
            277,274,275,287,287,272,278,287,279,287,
            287,280,287,287,287,287,282,283,340,316,
            287,284,321
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
           NUM_STATES        = 228,
           NT_OFFSET         = 54,
           LA_STATE_OFFSET   = 342,
           MAX_LA            = 1,
           NUM_RULES         = 55,
           NUM_NONTERMINALS  = 2,
           NUM_SYMBOLS       = 56,
           SEGMENT_SIZE      = 8192,
           START_STATE       = 56,
           IDENTIFIER_SYMBOL = 0,
           EOFT_SYMBOL       = 37,
           EOLT_SYMBOL       = 55,
           ACCEPT_ACTION     = 286,
           ERROR_ACTION      = 287;

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
