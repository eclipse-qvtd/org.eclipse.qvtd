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
* $Id: QVTrKWLexerprs.java,v 1.13 2009/11/10 06:04:56 ewillink Exp $
*/

package org.eclipse.qvt.declarative.parser.qvtrelation;

public class QVTrKWLexerprs implements lpg.lpgjavaruntime.ParseTable, QVTrKWLexersym {

    public interface IsKeyword {
        public final static byte isKeyword[] = {0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0
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
            62,75,78,82,85,95,47,92,98,100,
            102,103,44,12,53,57,107,112,59,108,
            64,115,15,31,38,119,121,66,123,125,
            110,117,126,132,128,130,26,134,136,135,
            145,141,142,146,65,148,152,153,156,154,
            163,157,161,74,165,168,77,169,171,173,
            172,40,176,177,180,179,182,190,186,192,
            199,191,202,19,204,206,207,196,210,212,
            211,214,215,217,220,226,228,229,232,233,
            89,223,237,234,239,242,243,244,246,249,
            250,252,253,255,254,260,256,264,267,270,
            274,276,278,279,280,281,286,287,288,72,
            272,291,292,297,299,302,303,304,290,308,
            309,313,311,315,316,317,321,318,319,324,
            328,329,330,338,340,342,343,345,333,346,
            348,349,354,355,359,357,358,362,366,367,
            361,372,373,375,377,378,379,382,386,388,
            383,389,391,395,397,398,399,403,404,405,
            406,408,412,413,411,416,417,418,426,427,
            428,429,437,430,434,439,440,442,444,443,
            446,451,454,455,456,457,459,458,462,466,
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
            20,21,22,23,24,0,26,2,28,29,
            0,31,32,33,34,5,22,0,8,0,
            3,23,3,0,5,27,0,1,5,19,
            13,14,0,35,8,12,0,1,0,7,
            8,0,6,0,0,0,8,2,5,11,
            6,0,1,0,0,4,0,0,1,16,
            15,0,9,7,0,21,13,11,0,5,
            2,0,11,19,0,1,8,0,37,0,
            1,0,0,0,3,3,0,0,11,0,
            19,0,1,7,0,8,0,3,0,1,
            0,1,0,1,0,0,17,0,4,0,
            14,0,1,0,0,0,7,2,13,6,
            0,0,15,9,0,0,2,0,8,2,
            5,0,0,0,2,0,0,6,5,18,
            0,6,0,1,0,9,6,0,0,1,
            0,0,0,2,10,0,0,2,0,0,
            0,0,15,7,5,0,16,15,7,0,
            0,0,14,2,4,0,7,12,0,4,
            2,0,1,0,1,0,0,2,2,0,
            0,0,2,0,0,1,0,0,5,0,
            11,10,0,4,8,0,1,0,0,1,
            3,0,0,0,3,13,0,1,0,7,
            7,0,0,0,6,0,4,4,0,0,
            1,0,0,0,0,0,11,3,17,0,
            5,8,3,0,1,14,0,1,20,0,
            18,0,3,0,1,0,1,0,0,0,
            0,3,5,12,5,0,0,0,2,0,
            0,0,5,13,4,10,0,6,0,3,
            2,0,0,0,1,16,4,0,0,8,
            0,4,0,1,0,0,0,0,0,3,
            0,7,12,0,4,17,9,0,0,0,
            12,4,0,18,6,3,13,0,1,0,
            1,0,0,14,0,0,4,0,0,8,
            6,6,5,0,0,7,0,0,0,3,
            0,0,9,9,6,0,0,1,8,12,
            9,0,0,1,0,10,0,0,0,3,
            9,0,0,2,10,0,1,0,0,2,
            0,1,4,16,0,1,0,0,0,1,
            3,5,0,0,0,0,24,0,1,4,
            0,0,0,9,36,0,0,0,16,8,
            17,6,10,7,14,0,0,0,0,0,
            3,2,6,0,9,7,0,1,0,0,
            7,0,0,0,6,0,4,30,9,6,
            0,1,11,0,0,0,0,0,0,0,
            3,0,8,5,11,0,10,2,7,0,
            25,0,17,0,0,0,0,0,0,0,
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
            55,53,69,61,65,262,51,121,64,63,
            262,62,59,58,60,106,102,262,105,262,
            108,153,308,262,142,155,262,82,89,107,
            264,109,262,154,81,88,262,94,262,92,
            91,262,93,262,262,262,98,113,269,97,
            277,262,192,262,262,193,262,262,77,100,
            112,262,134,136,262,128,133,137,262,79,
            169,262,78,76,262,80,168,262,261,262,
            85,262,262,262,86,87,262,262,84,262,
            83,262,96,95,262,99,262,101,262,110,
            262,111,262,114,262,262,300,262,115,262,
            116,262,118,262,262,262,120,123,117,122,
            262,262,119,124,262,262,125,262,126,129,
            127,262,262,262,130,262,262,273,270,278,
            262,271,262,131,262,268,132,262,262,138,
            12,262,262,141,135,262,262,143,262,262,
            262,262,306,144,145,262,139,140,147,262,
            262,262,146,150,151,262,148,149,262,159,
            285,262,152,262,156,262,262,157,158,262,
            262,262,291,262,262,163,262,262,162,262,
            160,161,262,165,164,262,266,262,262,275,
            166,262,262,262,265,263,262,309,262,167,
            170,262,262,262,171,262,172,173,262,262,
            287,262,262,262,262,262,174,178,303,262,
            181,179,180,262,182,176,262,183,175,262,
            177,262,184,262,185,262,276,262,262,262,
            262,187,186,194,188,262,262,262,190,262,
            262,262,191,267,195,189,262,196,262,295,
            197,262,262,262,200,201,199,262,262,198,
            262,202,262,203,262,262,262,262,262,206,
            262,205,204,262,207,288,208,262,262,262,
            209,211,262,282,299,217,210,262,213,262,
            305,262,262,212,262,262,215,262,262,214,
            216,218,283,262,262,219,262,262,262,286,
            262,262,289,220,221,262,262,296,224,222,
            223,262,262,225,262,297,262,262,262,304,
            292,262,262,228,272,262,229,262,262,230,
            262,279,232,226,262,233,262,262,262,302,
            235,234,262,262,262,262,231,262,239,238,
            262,262,262,237,227,262,262,262,236,240,
            293,242,301,243,241,262,262,262,262,262,
            280,247,281,262,290,245,262,246,262,262,
            248,262,262,262,249,262,253,244,250,252,
            262,255,251,262,262,262,262,262,262,262,
            307,262,257,258,256,262,294,284,259,262,
            254,262,298
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
           NUM_STATES        = 211,
           NT_OFFSET         = 55,
           LA_STATE_OFFSET   = 309,
           MAX_LA            = 1,
           NUM_RULES         = 47,
           NUM_NONTERMINALS  = 2,
           NUM_SYMBOLS       = 57,
           SEGMENT_SIZE      = 8192,
           START_STATE       = 48,
           IDENTIFIER_SYMBOL = 0,
           EOFT_SYMBOL       = 37,
           EOLT_SYMBOL       = 56,
           ACCEPT_ACTION     = 261,
           ERROR_ACTION      = 262;

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
