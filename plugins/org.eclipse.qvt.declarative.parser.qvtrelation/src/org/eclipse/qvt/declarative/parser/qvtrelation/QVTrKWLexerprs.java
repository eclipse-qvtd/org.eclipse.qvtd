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

public class QVTrKWLexerprs implements lpg.runtime.ParseTable, QVTrKWLexersym {
    public final static int ERROR_SYMBOL = 0;
    public final int getErrorSymbol() { return ERROR_SYMBOL; }

    public final static int SCOPE_UBOUND = 0;
    public final int getScopeUbound() { return SCOPE_UBOUND; }

    public final static int SCOPE_SIZE = 0;
    public final int getScopeSize() { return SCOPE_SIZE; }

    public final static int MAX_NAME_LENGTH = 0;
    public final int getMaxNameLength() { return MAX_NAME_LENGTH; }

    public final static int NUM_STATES = 211;
    public final int getNumStates() { return NUM_STATES; }

    public final static int NT_OFFSET = 56;
    public final int getNtOffset() { return NT_OFFSET; }

    public final static int LA_STATE_OFFSET = 309;
    public final int getLaStateOffset() { return LA_STATE_OFFSET; }

    public final static int MAX_LA = 1;
    public final int getMaxLa() { return MAX_LA; }

    public final static int NUM_RULES = 47;
    public final int getNumRules() { return NUM_RULES; }

    public final static int NUM_NONTERMINALS = 2;
    public final int getNumNonterminals() { return NUM_NONTERMINALS; }

    public final static int NUM_SYMBOLS = 58;
    public final int getNumSymbols() { return NUM_SYMBOLS; }

    public final static int SEGMENT_SIZE = 8192;
    public final int getSegmentSize() { return SEGMENT_SIZE; }

    public final static int START_STATE = 48;
    public final int getStartState() { return START_STATE; }

    public final static int IDENTIFIER_SYMBOL = 0;
    public final int getIdentifier_SYMBOL() { return IDENTIFIER_SYMBOL; }

    public final static int EOFT_SYMBOL = 37;
    public final int getEoftSymbol() { return EOFT_SYMBOL; }

    public final static int EOLT_SYMBOL = 57;
    public final int getEoltSymbol() { return EOLT_SYMBOL; }

    public final static int ACCEPT_ACTION = 261;
    public final int getAcceptAction() { return ACCEPT_ACTION; }

    public final static int ERROR_ACTION = 262;
    public final int getErrorAction() { return ERROR_ACTION; }

    public final static boolean BACKTRACK = false;
    public final boolean getBacktrack() { return BACKTRACK; }

    public final int getStartSymbol() { return lhs(0); }
    public final boolean isValidForParser() { return QVTrKWLexersym.isValidForParser; }


    public interface IsNullable {
        public final static byte isNullable[] = {0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0
        };
    };
    public final static byte isNullable[] = IsNullable.isNullable;
    public final boolean isNullable(int index) { return isNullable[index] != 0; }

    public interface ProsthesesIndex {
        public final static byte prosthesesIndex[] = {0,
            2,1
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
            0,0,0,0,0,0
        };
    };
    public final static byte isKeyword[] = IsKeyword.isKeyword;
    public final boolean isKeyword(int index) { return isKeyword[index] != 0; }

    public interface BaseCheck {
        public final static byte baseCheck[] = {0,
            4,2,4,4,5,3,2,3,3,7,
            3,2,4,5,3,3,8,10,10,6,
            7,16,4,7,5,6,7,10,4,7,
            9,14,6,7,7,13,6,3,9,9,
            5,8,7,3,14,4,5
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
            1,1,1,1,1,1,1,1,1,50,
            56,76,96,83,27,98,44,86,91,100,
            103,104,48,12,51,61,108,109,63,111,
            49,113,15,38,26,117,120,64,122,124,
            112,125,114,130,126,133,132,136,135,41,
            143,138,144,147,69,148,149,151,154,156,
            157,159,163,68,164,165,73,166,170,172,
            171,82,175,176,179,178,181,182,185,191,
            194,195,200,19,202,204,205,208,198,210,
            211,214,215,217,218,223,226,227,230,231,
            70,221,235,232,237,240,241,242,244,247,
            248,250,251,253,252,258,254,262,265,268,
            272,274,276,277,278,279,284,285,286,88,
            270,289,290,295,297,300,301,302,288,306,
            307,311,309,313,314,315,319,316,317,322,
            326,327,328,336,338,340,341,343,331,344,
            346,347,352,353,357,355,356,360,364,365,
            359,370,371,373,375,376,377,380,384,386,
            381,387,389,393,395,396,397,401,403,404,
            406,407,411,412,409,415,418,414,424,426,
            427,428,436,429,434,438,439,440,443,442,
            447,452,450,454,455,456,458,457,464,465,
            262,262
        };
    };
    public final static char baseAction[] = BaseAction.baseAction;
    public final int baseAction(int index) { return baseAction[index]; }
    public final static char lhs[] = baseAction;
    public final int lhs(int index) { return lhs[index]; };

    public interface TermCheck {
        public final static byte termCheck[] = {0,
            0,1,2,3,4,5,6,7,8,9,
            10,0,12,13,0,15,2,3,0,8,
            20,21,22,23,24,0,0,27,3,29,
            30,5,32,33,34,35,22,0,13,14,
            0,23,5,0,1,8,28,0,0,9,
            0,8,5,5,36,0,19,7,8,12,
            0,1,0,0,16,2,6,0,0,0,
            8,2,0,11,6,0,9,8,15,7,
            13,0,0,11,3,0,5,0,1,21,
            0,4,37,11,19,0,1,0,1,0,
            1,11,0,0,19,3,3,0,0,1,
            0,0,0,0,7,3,0,1,8,0,
            1,0,1,0,0,0,13,4,17,0,
            1,0,0,2,0,0,2,0,14,7,
            15,6,0,0,2,8,0,0,0,2,
            0,5,2,0,6,0,0,1,0,6,
            5,18,0,0,0,0,1,9,6,0,
            0,0,2,10,0,0,2,0,0,15,
            0,0,7,5,0,16,15,7,7,0,
            0,14,2,0,0,2,12,0,4,0,
            1,0,1,0,0,2,2,0,11,0,
            0,4,2,0,0,1,0,0,5,10,
            0,4,0,1,8,0,0,1,3,0,
            0,0,3,13,0,1,0,7,7,0,
            0,0,6,0,4,4,0,0,1,0,
            0,0,0,0,11,3,17,0,5,8,
            3,0,1,14,0,1,20,0,18,0,
            3,0,1,0,1,0,0,0,0,3,
            5,12,5,0,0,0,2,0,0,0,
            5,13,4,10,0,6,0,3,2,0,
            0,0,1,16,4,0,0,8,0,4,
            0,1,0,0,0,0,0,3,0,7,
            12,0,4,17,9,0,0,0,12,4,
            0,18,6,3,13,0,1,0,1,0,
            0,14,0,0,4,0,0,8,6,6,
            5,0,0,7,0,0,0,3,0,0,
            9,9,6,0,0,1,8,12,9,0,
            0,1,0,10,0,0,0,3,9,0,
            0,2,10,0,1,0,0,2,0,1,
            4,16,0,1,0,0,0,1,3,5,
            0,25,0,0,24,0,0,1,0,4,
            0,0,9,0,0,0,16,0,8,17,
            6,10,14,0,7,0,0,0,0,3,
            2,6,9,0,7,0,1,0,0,0,
            7,0,0,6,31,4,0,9,6,0,
            11,0,1,0,0,0,0,0,0,3,
            11,8,5,0,0,10,2,0,0,0,
            7,17,26,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0
        };
    };
    public final static byte termCheck[] = TermCheck.termCheck;
    public final int termCheck(int index) { return termCheck[index]; }

    public interface TermAction {
        public final static char termAction[] = {0,
            262,72,67,68,74,52,73,71,70,56,
            75,262,57,66,262,54,104,103,262,90,
            55,53,69,61,65,262,262,51,108,64,
            63,79,62,59,58,60,102,262,264,109,
            262,153,106,262,82,105,155,262,262,124,
            262,81,89,269,154,262,107,92,91,88,
            262,94,262,262,100,113,93,262,262,262,
            98,169,262,97,277,262,134,168,112,136,
            133,262,262,137,308,262,142,262,192,128,
            262,193,261,78,76,262,77,262,80,262,
            85,84,262,262,83,86,87,262,262,96,
            262,262,262,262,95,101,262,110,99,262,
            111,262,114,262,262,262,117,115,300,262,
            118,262,262,121,262,262,123,262,116,120,
            119,122,262,262,125,126,262,262,262,129,
            262,127,130,262,273,262,262,131,262,271,
            270,278,262,262,262,262,138,268,132,12,
            262,262,141,135,262,262,143,262,262,306,
            262,262,144,145,262,139,140,147,148,262,
            262,146,150,262,262,285,149,262,151,262,
            152,262,156,262,262,157,158,262,160,262,
            262,159,291,262,262,163,262,262,162,161,
            262,165,262,266,164,262,262,275,166,262,
            262,262,265,263,262,309,262,167,170,262,
            262,262,171,262,172,173,262,262,287,262,
            262,262,262,262,174,178,303,262,181,179,
            180,262,182,176,262,183,175,262,177,262,
            184,262,185,262,276,262,262,262,262,187,
            186,194,188,262,262,262,190,262,262,262,
            191,267,195,189,262,196,262,295,197,262,
            262,262,200,201,199,262,262,198,262,202,
            262,203,262,262,262,262,262,206,262,205,
            204,262,207,288,208,262,262,262,209,211,
            262,282,299,217,210,262,213,262,305,262,
            262,212,262,262,215,262,262,214,216,218,
            283,262,262,219,262,262,262,286,262,262,
            289,220,221,262,262,296,224,222,223,262,
            262,225,262,297,262,262,262,304,292,262,
            262,228,272,262,229,262,262,230,262,279,
            232,226,262,233,262,262,262,302,235,234,
            262,227,262,262,231,262,262,239,262,238,
            262,262,237,262,262,262,236,262,240,293,
            242,301,241,262,243,262,262,262,262,280,
            247,281,290,262,245,262,246,262,262,262,
            248,262,262,249,244,253,262,250,252,262,
            251,262,255,262,262,262,262,262,262,307,
            256,257,258,262,262,294,284,262,262,262,
            259,298,254
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
