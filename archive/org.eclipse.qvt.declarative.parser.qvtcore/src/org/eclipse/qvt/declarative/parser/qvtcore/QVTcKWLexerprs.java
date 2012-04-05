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
*   E.D.Willink - Extended API and implementation for QVTc
*
* </copyright>
*
*
*/

package org.eclipse.qvt.declarative.parser.qvtcore;

public class QVTcKWLexerprs implements lpg.runtime.ParseTable, QVTcKWLexersym {
    public final static int ERROR_SYMBOL = 0;
    public final int getErrorSymbol() { return ERROR_SYMBOL; }

    public final static int SCOPE_UBOUND = 0;
    public final int getScopeUbound() { return SCOPE_UBOUND; }

    public final static int SCOPE_SIZE = 0;
    public final int getScopeSize() { return SCOPE_SIZE; }

    public final static int MAX_NAME_LENGTH = 0;
    public final int getMaxNameLength() { return MAX_NAME_LENGTH; }

    public final static int NUM_STATES = 181;
    public final int getNumStates() { return NUM_STATES; }

    public final static int NT_OFFSET = 56;
    public final int getNtOffset() { return NT_OFFSET; }

    public final static int LA_STATE_OFFSET = 271;
    public final int getLaStateOffset() { return LA_STATE_OFFSET; }

    public final static int MAX_LA = 1;
    public final int getMaxLa() { return MAX_LA; }

    public final static int NUM_RULES = 43;
    public final int getNumRules() { return NUM_RULES; }

    public final static int NUM_NONTERMINALS = 2;
    public final int getNumNonterminals() { return NUM_NONTERMINALS; }

    public final static int NUM_SYMBOLS = 58;
    public final int getNumSymbols() { return NUM_SYMBOLS; }

    public final static int SEGMENT_SIZE = 8192;
    public final int getSegmentSize() { return SEGMENT_SIZE; }

    public final static int START_STATE = 44;
    public final int getStartState() { return START_STATE; }

    public final static int IDENTIFIER_SYMBOL = 0;
    public final int getIdentifier_SYMBOL() { return IDENTIFIER_SYMBOL; }

    public final static int EOFT_SYMBOL = 36;
    public final int getEoftSymbol() { return EOFT_SYMBOL; }

    public final static int EOLT_SYMBOL = 57;
    public final int getEoltSymbol() { return EOLT_SYMBOL; }

    public final static int ACCEPT_ACTION = 227;
    public final int getAcceptAction() { return ACCEPT_ACTION; }

    public final static int ERROR_ACTION = 228;
    public final int getErrorAction() { return ERROR_ACTION; }

    public final static boolean BACKTRACK = false;
    public final boolean getBacktrack() { return BACKTRACK; }

    public final int getStartSymbol() { return lhs(0); }
    public final boolean isValidForParser() { return QVTcKWLexersym.isValidForParser; }


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
            5,8,7,8,7,7,3,5,7,7,
            14,4,5
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
            1,1,1,1,1,46,44,70,82,38,
            85,87,88,36,90,93,18,24,40,95,
            41,47,96,98,50,101,104,105,57,55,
            17,106,111,113,63,115,117,64,118,120,
            122,123,124,125,128,129,131,135,136,140,
            65,142,141,145,149,152,150,68,153,69,
            154,157,160,162,161,165,166,168,172,173,
            179,180,169,185,186,189,190,16,192,195,
            196,199,200,201,203,202,208,206,214,215,
            218,219,76,209,224,226,222,228,230,231,
            232,233,234,236,238,241,246,242,249,251,
            257,259,260,263,265,266,268,267,270,274,
            272,275,280,281,282,284,290,286,288,292,
            294,296,298,299,297,303,304,306,240,307,
            310,317,313,319,322,324,323,328,325,327,
            333,335,337,341,339,343,344,345,346,348,
            356,358,353,359,361,363,365,366,367,370,
            372,373,376,377,379,383,388,389,390,393,
            394,391,395,402,400,407,228,228
        };
    };
    public final static char baseAction[] = BaseAction.baseAction;
    public final int baseAction(int index) { return baseAction[index]; }
    public final static char lhs[] = baseAction;
    public final int lhs(int index) { return lhs[index]; };

    public interface TermCheck {
        public final static byte termCheck[] = {0,
            0,1,2,3,4,5,6,7,8,9,
            10,11,12,13,14,0,0,0,18,3,
            3,21,22,0,24,25,3,11,28,29,
            14,31,32,33,34,0,21,0,1,0,
            0,6,27,0,4,6,0,1,8,0,
            35,16,13,7,0,0,0,8,2,3,
            6,12,0,0,0,2,4,0,0,0,
            16,7,4,11,11,0,9,2,11,36,
            12,0,18,8,0,16,0,0,1,0,
            4,10,0,1,0,0,12,0,1,4,
            0,12,8,0,0,0,1,3,8,6,
            0,1,0,1,0,1,0,0,1,0,
            1,0,0,0,0,2,4,0,0,2,
            0,7,2,17,0,0,0,9,17,0,
            0,0,8,2,0,6,2,7,0,0,
            15,0,0,0,1,7,0,6,9,0,
            0,0,10,2,0,0,6,0,0,2,
            5,0,0,1,10,19,17,6,0,0,
            0,13,4,4,0,0,2,2,0,0,
            1,0,1,5,0,0,2,2,0,0,
            0,0,0,5,2,0,1,0,0,8,
            10,12,5,0,0,1,3,0,0,11,
            3,0,4,0,1,0,5,0,3,0,
            0,0,0,0,1,0,7,0,7,0,
            0,0,12,3,3,0,7,20,0,14,
            0,1,15,8,6,23,0,1,0,0,
            1,3,0,1,0,0,0,0,2,0,
            6,0,1,0,0,6,11,10,5,0,
            0,0,2,0,5,0,5,0,5,0,
            1,0,5,0,1,0,0,0,0,3,
            26,4,0,0,19,0,0,1,13,0,
            5,20,0,15,11,13,0,1,0,10,
            8,0,0,0,0,7,0,0,6,8,
            7,4,0,9,0,9,0,3,0,7,
            0,1,0,0,0,0,8,0,3,13,
            3,9,0,10,10,0,1,0,0,2,
            0,1,0,5,0,0,0,1,6,0,
            5,0,0,9,22,0,0,8,0,0,
            0,3,0,7,9,14,4,0,0,0,
            0,4,0,0,0,7,7,5,8,0,
            6,0,30,4,3,12,0,0,2,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0
        };
    };
    public final static byte termCheck[] = TermCheck.termCheck;
    public final int termCheck(int index) { return termCheck[index]; }

    public interface TermAction {
        public final static char termAction[] = {0,
            228,68,63,64,67,70,49,69,66,52,
            71,62,48,53,51,228,228,228,50,101,
            82,57,61,228,47,65,83,230,60,59,
            102,58,55,54,56,228,145,228,74,228,
            228,78,147,228,88,85,228,90,87,228,
            146,79,84,89,228,228,228,94,98,97,
            99,93,228,228,228,109,107,228,228,228,
            100,243,128,106,110,228,126,159,125,227,
            129,228,122,158,228,72,228,228,77,228,
            76,73,228,81,228,228,75,228,92,91,
            228,80,86,228,228,228,103,96,95,235,
            228,104,228,105,228,108,228,228,111,228,
            112,228,228,228,228,115,114,228,228,117,
            228,116,119,265,228,228,228,118,113,228,
            228,228,120,123,228,121,124,239,228,228,
            244,228,228,228,130,237,12,236,234,228,
            228,228,127,133,228,228,134,228,228,136,
            135,228,228,138,270,131,132,137,228,228,
            228,141,139,140,228,228,142,251,228,228,
            144,228,148,143,228,228,149,150,228,228,
            228,228,228,151,257,228,232,228,228,154,
            153,152,155,228,228,241,156,228,228,229,
            231,228,157,228,271,228,161,228,160,228,
            228,228,228,228,253,228,162,228,164,228,
            228,228,163,167,169,228,196,266,228,165,
            228,171,166,168,170,259,228,172,228,228,
            174,173,228,242,228,228,228,228,177,228,
            175,228,180,228,228,178,233,176,179,228,
            228,228,183,228,182,228,184,228,185,228,
            186,228,188,228,189,228,228,228,228,192,
            181,191,228,228,187,228,228,197,190,228,
            195,254,228,248,194,193,228,267,228,268,
            198,228,228,228,228,261,228,228,249,199,
            200,201,228,255,228,202,228,252,228,203,
            228,263,228,228,228,228,205,228,262,204,
            260,258,228,264,238,228,206,228,228,207,
            228,245,228,209,228,228,228,213,210,228,
            212,228,228,211,208,228,228,214,228,228,
            228,246,228,247,256,215,217,228,228,228,
            228,218,228,228,228,219,220,221,223,228,
            224,228,216,225,269,222,228,228,250
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
