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
* $Id: QVTcKWLexerprs.java,v 1.4 2008/08/18 07:48:56 ewillink Exp $
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
            4,3,3,4,4,7,7,10,3,6,
            4,2,4,4,5,3,2,3,3,7,
            3,2,4,5,3,3,8,10,10,7,
            6,6,8,3,3,7,6,6,13,8,
            7,11,11,9,8,14,12,12,12,6,
            7,16,4,7,5,6,7,7,10,4,
            10,4,4,5,8,7,8,7,7,3,
            5,7,7,14,4,5
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
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,79,134,
            55,136,135,140,138,146,150,152,157,43,
            155,17,80,88,159,90,161,47,67,94,
            162,60,56,166,68,38,95,167,171,176,
            165,169,173,18,105,79,139,180,181,182,
            185,186,106,187,194,196,199,203,189,206,
            208,209,212,213,101,110,217,86,215,219,
            25,220,223,225,117,226,228,229,230,204,
            240,232,102,238,242,243,247,248,250,256,
            251,252,260,262,263,264,48,267,270,271,
            272,275,276,277,278,280,113,283,284,287,
            292,290,295,297,298,299,305,301,118,308,
            309,311,312,314,317,318,321,322,324,124,
            325,329,129,333,328,335,337,338,342,340,
            345,346,347,348,350,360,355,353,362,365,
            366,368,372,370,374,375,376,381,377,380,
            385,386,188,390,389,388,397,398,400,402,
            396,406,408,405,415,413,418,419,420,422,
            404,427,417,428,430,431,432,439,435,441,
            443,442,444,16,448,449,451,452,459,455,
            454,460,466,464,467,468,469,474,475,479,
            482,476,487,488,484,492,493,499,497,495,
            504,505,506,507,509,510,512,513,518,521,
            522,524,523,528,531,534,527,530,540,542,
            543,546,538,549,552,553,554,555,559,558,
            557,564,565,567,126,568,569,572,570,575,
            573,583,577,588,576,589,591,593,595,594,
            596,598,604,609,608,614,616,612,619,618,
            620,624,621,628,626,629,630,635,639,632,
            633,641,643,645,647,649,651,653,658,661,
            652,660,662,669,673,674,677,670,679,681,
            684,685,682,687,690,692,694,693,697,704,
            705,393,393
        };
    };
    public final static char baseAction[] = BaseAction.baseAction;
    public final int baseAction(int index) { return baseAction[index]; }
    public final static char lhs[] = baseAction;
    public final int lhs(int index) { return lhs[index]; };

    public interface TermCheck {
        public final static byte termCheck[] = {0,
            0,1,2,3,4,5,6,7,8,9,
            10,11,12,13,14,0,0,0,18,19,
            3,5,22,23,0,9,26,27,28,29,
            30,31,32,18,10,35,12,0,38,2,
            25,4,0,28,29,8,0,0,6,12,
            4,36,6,11,0,0,19,11,3,0,
            14,6,3,4,9,18,0,0,2,3,
            4,24,5,6,20,20,9,0,0,0,
            1,2,23,5,37,0,39,0,3,0,
            12,6,5,0,0,1,9,12,9,6,
            0,0,13,9,0,0,2,2,7,0,
            10,33,0,20,5,15,0,0,17,3,
            4,17,13,0,7,0,3,22,0,1,
            18,14,9,0,0,0,24,0,0,0,
            12,3,17,8,5,0,1,13,0,0,
            13,0,27,4,0,4,0,1,0,1,
            0,0,1,9,0,0,0,1,0,9,
            0,1,0,40,9,0,1,5,14,0,
            0,0,14,3,0,0,0,0,0,10,
            9,6,6,0,6,0,3,2,0,12,
            16,3,0,0,2,0,1,0,0,1,
            3,0,0,2,0,3,0,1,0,0,
            1,7,0,1,0,0,8,0,0,0,
            1,0,29,9,0,10,8,0,11,0,
            1,0,0,6,3,14,0,0,6,0,
            0,0,3,6,8,0,5,7,3,0,
            1,0,0,0,1,3,0,1,7,0,
            0,0,3,3,0,0,0,0,7,0,
            3,0,0,0,8,6,0,13,6,0,
            4,0,1,4,0,1,0,0,0,24,
            0,18,5,7,0,1,8,0,0,9,
            0,0,5,0,3,2,0,0,8,11,
            0,0,2,0,0,4,2,0,0,6,
            2,15,0,1,0,1,0,0,21,0,
            3,0,15,4,0,0,0,0,1,0,
            4,7,0,1,0,19,11,16,9,0,
            6,0,1,4,0,0,1,0,4,0,
            3,0,1,0,0,0,0,8,4,0,
            0,8,2,8,0,0,2,0,0,0,
            2,6,13,17,5,0,0,0,1,0,
            1,0,7,0,0,0,5,0,21,13,
            5,7,0,6,0,1,0,0,0,0,
            1,0,1,11,7,7,0,0,2,0,
            0,0,1,17,0,8,7,34,0,5,
            0,0,0,0,3,15,4,0,0,11,
            0,0,1,0,0,8,16,7,0,0,
            12,3,8,0,11,0,0,0,0,6,
            11,28,7,0,0,0,2,11,0,0,
            2,0,1,0,16,10,0,0,2,2,
            23,0,0,10,0,22,0,6,0,1,
            8,5,8,0,0,0,0,2,0,0,
            4,0,0,10,10,4,4,0,1,11,
            0,0,0,0,15,2,0,0,7,0,
            0,9,2,0,1,15,9,0,9,0,
            1,0,0,2,2,0,1,21,0,1,
            13,0,0,0,0,1,0,0,0,8,
            8,3,5,0,0,1,0,0,0,0,
            7,0,0,4,0,0,0,10,6,5,
            14,5,0,27,31,14,4,0,0,1,
            0,4,0,0,0,0,1,0,30,0,
            25,7,10,0,1,15,9,0,0,16,
            2,0,5,0,1,0,1,0,0,0,
            0,10,4,0,1,0,1,0,0,0,
            2,0,0,4,0,16,19,10,0,5,
            0,3,0,12,0,25,0,1,0,5,
            0,0,0,11,2,5,8,0,26,0,
            0,0,1,12,7,0,26,7,0,0,
            2,12,0,0,2,2,0,1,0,10,
            0,0,4,0,0,1,0,1,8,0,
            7,0,0,0,13,0,0,0,9,6,
            4,10,10,0,0,0,0,3,5,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0
        };
    };
    public final static byte termCheck[] = TermCheck.termCheck;
    public final int termCheck(int index) { return termCheck[index]; }

    public interface TermAction {
        public final static char termAction[] = {0,
            393,101,99,94,95,98,88,105,106,97,
            100,102,93,81,104,393,393,393,87,83,
            160,120,82,96,393,119,89,92,84,86,
            80,91,103,296,188,90,187,393,85,150,
            298,152,393,299,297,149,393,393,117,405,
            131,300,410,116,393,393,151,130,143,393,
            129,141,139,140,144,212,393,393,132,133,
            134,215,146,148,107,142,147,393,393,393,
            122,121,138,164,213,393,214,393,182,393,
            163,183,124,393,393,154,123,184,127,135,
            393,22,126,153,393,393,162,418,200,393,
            409,165,393,136,179,427,393,393,395,192,
            193,161,180,393,232,393,243,171,393,245,
            224,233,242,393,393,393,223,393,393,393,
            394,166,344,108,110,393,112,109,393,393,
            111,393,343,113,393,114,393,115,393,125,
            393,393,137,118,393,393,393,155,393,128,
            393,156,393,392,145,393,157,159,463,393,
            393,393,158,168,393,393,393,393,393,167,
            169,170,172,393,411,393,173,414,393,408,
            419,174,393,393,412,393,175,393,393,428,
            176,393,393,177,393,178,393,181,393,393,
            189,185,393,190,393,393,186,393,393,393,
            396,393,197,191,393,194,196,393,195,393,
            198,393,393,201,202,199,393,393,203,393,
            393,393,205,204,468,393,207,206,446,393,
            208,393,393,393,211,210,393,216,209,393,
            393,393,217,218,393,393,393,393,219,393,
            453,393,393,393,222,456,393,220,455,393,
            226,393,416,406,393,227,393,9,393,221,
            393,225,229,228,393,407,230,393,393,231,
            393,393,234,393,237,238,393,393,236,235,
            393,393,397,393,393,240,404,393,393,241,
            244,398,393,469,393,448,393,393,239,393,
            247,393,464,249,393,393,393,393,253,393,
            252,250,393,257,393,246,251,248,254,393,
            256,393,258,255,393,393,260,393,259,393,
            261,393,417,393,393,393,393,262,264,393,
            393,263,266,265,393,393,269,393,393,393,
            272,270,268,267,271,393,393,393,274,393,
            275,393,277,393,393,393,276,393,457,273,
            278,280,393,279,393,281,393,393,393,393,
            285,393,286,282,283,284,393,393,431,393,
            393,393,291,288,393,289,290,287,393,293,
            393,393,393,393,424,449,294,393,393,292,
            393,393,403,393,393,301,443,303,393,393,
            302,304,425,393,305,393,393,393,393,308,
            306,295,307,393,393,393,313,309,393,393,
            314,393,315,393,311,316,393,393,430,317,
            310,393,393,451,393,312,393,444,393,465,
            466,318,319,393,393,393,393,321,393,393,
            447,393,393,450,320,324,325,393,326,322,
            393,393,393,393,323,329,393,393,328,393,
            393,330,459,393,461,327,331,393,333,393,
            434,393,393,334,399,393,400,332,393,423,
            335,393,393,393,393,337,393,393,393,462,
            413,338,339,393,393,420,393,393,393,393,
            341,393,393,347,393,36,393,345,349,348,
            342,350,393,340,336,346,460,393,393,426,
            393,458,393,393,393,393,355,393,438,393,
            351,353,352,393,437,433,356,393,393,354,
            357,393,358,393,359,393,360,393,393,393,
            393,361,362,393,365,393,452,393,393,393,
            422,393,393,421,393,364,363,454,393,367,
            393,368,393,369,393,366,393,401,393,373,
            393,393,393,372,376,375,374,393,370,393,
            393,393,379,436,377,393,371,378,393,393,
            380,435,393,393,381,382,393,441,393,440,
            393,393,383,393,393,385,393,387,442,393,
            384,393,393,393,386,393,393,393,388,389,
            467,432,439,393,393,393,393,445,390
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
           NUM_STATES        = 313,
           NT_OFFSET         = 54,
           LA_STATE_OFFSET   = 469,
           MAX_LA            = 1,
           NUM_RULES         = 76,
           NUM_NONTERMINALS  = 2,
           NUM_SYMBOLS       = 56,
           SEGMENT_SIZE      = 8192,
           START_STATE       = 77,
           IDENTIFIER_SYMBOL = 0,
           EOFT_SYMBOL       = 40,
           EOLT_SYMBOL       = 55,
           ACCEPT_ACTION     = 392,
           ERROR_ACTION      = 393;

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
