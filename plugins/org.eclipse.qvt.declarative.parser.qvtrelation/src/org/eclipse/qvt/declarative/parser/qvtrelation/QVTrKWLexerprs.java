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
* $Id: QVTrKWLexerprs.java,v 1.12 2009/10/21 07:49:02 ewillink Exp $
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
            3,2,4,5,3,3,8,10,10,7,
            6,6,8,3,3,7,6,6,13,8,
            7,6,7,16,4,7,5,6,7,10,
            4,7,9,14,6,7,7,13,6,3,
            9,9,5,8,7,3,14,4,5
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
            1,1,1,1,1,1,1,1,1,1,
            1,62,57,103,52,113,114,55,112,119,
            123,125,130,39,54,126,62,72,77,133,
            74,135,43,136,16,44,27,78,137,142,
            139,144,145,148,147,149,150,151,51,155,
            153,162,165,166,168,171,169,173,87,174,
            180,181,183,186,188,190,194,88,89,91,
            66,176,93,196,172,198,201,203,202,204,
            94,205,208,209,212,211,214,215,224,226,
            221,230,227,106,232,46,235,237,240,241,
            233,243,244,247,246,252,250,255,256,257,
            264,269,267,272,273,274,13,259,108,279,
            275,277,281,283,285,287,290,291,293,292,
            294,297,300,306,298,307,312,313,318,316,
            321,323,326,324,328,330,331,334,335,337,
            338,339,343,110,349,340,352,353,354,358,
            359,361,362,363,364,368,367,371,374,375,
            376,379,383,380,382,385,392,384,394,395,
            396,397,400,401,402,407,410,412,413,418,
            420,424,414,428,426,430,435,437,431,433,
            438,441,445,443,446,448,450,453,452,456,
            460,461,463,465,466,305,467,470,475,471,
            476,472,479,480,484,482,490,488,493,494,
            496,500,498,501,503,504,508,506,511,515,
            517,519,520,522,521,523,528,532,535,534,
            538,540,539,544,546,550,547,529,552,555,
            557,559,560,561,563,569,562,575,320,320
        };
    };
    public final static char baseAction[] = BaseAction.baseAction;
    public final int baseAction(int index) { return baseAction[index]; }
    public final static char lhs[] = baseAction;
    public final int lhs(int index) { return lhs[index]; };

    public interface TermCheck {
        public final static byte termCheck[] = {0,
            0,1,2,3,4,5,6,7,8,9,
            10,11,0,13,2,0,16,2,6,4,
            20,21,22,0,24,25,0,27,28,3,
            4,31,32,33,34,35,10,22,0,13,
            2,15,0,0,6,0,4,5,5,6,
            0,0,2,0,0,1,0,19,5,17,
            6,0,19,12,11,0,16,6,23,8,
            25,0,1,0,3,10,0,0,1,6,
            30,36,6,6,8,12,0,0,0,3,
            0,3,0,0,38,7,9,4,5,9,
            8,14,0,13,12,0,20,0,1,0,
            1,0,0,0,1,10,7,5,0,1,
            13,19,0,12,0,0,4,0,4,0,
            1,6,0,1,0,0,0,1,0,4,
            6,0,1,0,0,7,0,0,0,0,
            0,2,0,3,0,1,8,14,6,15,
            13,0,16,2,0,0,2,0,0,2,
            0,0,0,0,9,0,6,5,5,0,
            0,2,0,3,2,0,18,0,3,0,
            1,16,5,0,1,0,1,0,1,28,
            0,0,0,0,0,2,5,0,0,5,
            0,0,2,0,0,2,8,17,16,8,
            0,7,15,0,1,0,0,2,8,0,
            1,0,0,2,0,1,0,11,2,0,
            0,2,0,0,12,0,0,7,2,0,
            5,0,1,10,0,0,0,1,0,10,
            6,3,7,0,0,23,0,4,0,1,
            4,0,0,0,0,4,0,5,0,1,
            0,8,0,7,0,1,0,7,14,0,
            0,0,0,0,12,3,0,0,8,0,
            1,15,11,6,0,0,0,18,12,4,
            4,0,0,1,21,0,5,0,1,4,
            0,1,0,0,2,0,1,0,5,0,
            0,4,3,0,0,5,0,0,0,0,
            2,37,0,7,10,8,13,5,0,1,
            11,0,0,0,3,2,4,0,0,1,
            0,0,0,0,7,3,0,0,7,6,
            0,11,5,0,0,0,1,11,0,0,
            7,0,0,0,0,4,2,17,14,11,
            8,0,9,0,0,0,0,18,7,0,
            0,0,3,10,3,11,0,7,13,0,
            1,0,0,0,0,3,20,0,5,0,
            9,15,3,0,7,0,3,0,1,0,
            0,6,0,4,0,1,0,0,8,3,
            0,9,0,3,0,0,9,0,4,0,
            1,0,0,11,9,0,1,10,6,0,
            0,1,0,12,0,0,0,1,9,0,
            0,0,10,4,0,0,2,2,0,0,
            1,0,17,0,1,7,5,0,24,0,
            1,4,0,0,1,0,26,0,27,0,
            0,1,0,0,1,0,14,0,9,7,
            0,14,17,6,0,10,0,3,0,0,
            0,0,0,3,8,15,4,0,0,10,
            9,0,1,0,0,8,2,0,0,0,
            3,8,3,0,26,0,0,9,3,0,
            1,0,1,7,0,12,0,29,0,0,
            0,0,0,0,6,9,12,5,0,8,
            10,0,4,14,0,0,2,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0
        };
    };
    public final static byte termCheck[] = TermCheck.termCheck;
    public final int termCheck(int index) { return termCheck[index]; }

    public interface TermAction {
        public final static char termAction[] = {0,
            320,84,79,85,80,72,82,86,83,67,
            87,73,320,78,203,320,65,120,202,119,
            64,66,81,320,76,71,320,77,70,125,
            126,63,75,74,69,68,124,118,320,322,
            100,127,320,320,101,320,116,327,122,121,
            320,320,140,320,320,93,320,99,103,115,
            92,320,123,89,102,320,139,105,185,106,
            183,320,108,320,107,159,320,320,129,113,
            141,184,109,128,110,112,320,320,320,335,
            320,155,320,320,319,156,326,378,169,158,
            160,344,320,157,161,320,150,320,205,320,
            235,320,320,320,91,181,236,90,320,95,
            321,88,320,94,320,320,96,320,97,320,
            98,104,320,111,320,320,320,130,320,117,
            114,320,131,320,320,132,320,320,320,320,
            320,137,320,138,320,142,136,370,143,133,
            134,320,135,144,320,320,145,320,320,147,
            320,320,320,320,146,320,148,149,151,320,
            320,152,320,331,153,320,336,320,329,320,
            154,376,328,320,345,320,162,320,164,163,
            12,320,320,320,320,168,167,320,320,170,
            320,320,174,320,320,355,172,165,166,173,
            320,175,171,320,176,320,320,177,178,320,
            179,320,320,182,320,186,320,180,187,320,
            320,188,320,320,190,320,320,189,361,320,
            193,320,194,192,320,320,320,324,320,195,
            196,204,197,320,320,191,320,198,320,333,
            323,320,320,320,320,199,320,200,320,379,
            320,201,320,206,320,357,320,207,373,320,
            320,320,320,320,208,212,320,320,211,320,
            216,209,213,218,320,320,320,210,215,217,
            219,320,320,221,214,320,220,320,222,223,
            320,224,320,320,225,320,334,320,226,320,
            320,227,228,320,320,229,320,320,320,320,
            233,280,320,231,230,232,325,234,320,237,
            238,320,320,320,239,240,365,320,320,242,
            320,320,320,320,241,348,320,320,244,245,
            320,243,246,320,320,320,250,247,320,320,
            249,320,320,320,320,253,341,248,358,251,
            252,320,255,320,320,320,320,352,254,320,
            320,320,259,342,369,256,320,260,257,320,
            262,320,320,320,320,347,258,320,353,320,
            263,261,265,320,264,320,266,320,375,320,
            320,267,320,268,320,351,320,320,270,269,
            320,359,320,272,320,320,271,320,356,320,
            366,320,320,273,274,320,340,367,275,320,
            320,277,320,276,320,320,320,281,362,320,
            26,320,330,374,320,320,282,284,320,320,
            337,320,279,320,287,286,288,320,278,320,
            343,289,320,320,372,320,283,320,285,320,
            320,292,320,320,294,320,350,320,291,293,
            320,363,290,295,320,371,320,297,320,320,
            320,320,320,339,298,296,338,320,320,300,
            360,320,302,320,320,301,303,320,320,320,
            305,304,306,320,299,320,320,307,309,320,
            310,320,313,311,320,308,320,312,320,320,
            320,320,320,320,315,349,314,316,320,317,
            364,320,377,368,320,320,354
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
           NUM_STATES        = 257,
           NT_OFFSET         = 55,
           LA_STATE_OFFSET   = 379,
           MAX_LA            = 1,
           NUM_RULES         = 59,
           NUM_NONTERMINALS  = 2,
           NUM_SYMBOLS       = 57,
           SEGMENT_SIZE      = 8192,
           START_STATE       = 60,
           IDENTIFIER_SYMBOL = 0,
           EOFT_SYMBOL       = 38,
           EOLT_SYMBOL       = 56,
           ACCEPT_ACTION     = 319,
           ERROR_ACTION      = 320;

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
