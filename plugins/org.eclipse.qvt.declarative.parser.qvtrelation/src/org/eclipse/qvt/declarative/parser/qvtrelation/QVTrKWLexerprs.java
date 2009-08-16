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
* $Id: QVTrKWLexerprs.java,v 1.11 2009/08/16 10:08:48 ewillink Exp $
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
            4,3,3,4,4,7,7,10,3,6,
            4,2,4,4,5,3,2,3,3,7,
            3,2,4,5,3,3,8,10,10,7,
            6,6,8,3,3,7,6,6,13,8,
            7,11,11,9,8,14,12,12,12,6,
            7,16,4,7,5,6,7,7,10,4,
            10,4,4,9,14,6,7,7,13,6,
            3,9,9,5,8,7,3,14,4,5
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
            1,1,1,1,1,1,1,1,1,1,
            1,1,83,22,158,72,161,156,163,167,
            168,173,86,26,90,57,91,175,94,170,
            36,15,56,103,65,71,180,76,37,105,
            181,183,87,185,115,45,73,67,186,187,
            190,191,192,194,108,195,203,196,204,208,
            205,213,215,217,218,221,222,109,211,112,
            227,224,114,116,229,124,230,232,128,233,
            234,235,137,236,246,237,129,241,250,140,
            249,251,255,159,257,259,261,263,266,42,
            269,271,272,273,276,277,278,280,281,284,
            127,285,286,290,295,293,298,300,299,307,
            302,309,312,133,313,314,315,317,316,321,
            325,322,328,326,149,329,334,141,337,335,
            342,339,344,345,346,348,352,354,355,353,
            360,359,367,369,371,372,374,378,376,380,
            381,382,384,385,387,388,392,395,398,394,
            399,400,402,407,409,411,412,413,417,414,
            154,423,425,426,427,428,430,431,438,434,
            435,439,442,446,443,448,449,451,457,452,
            459,25,461,462,463,464,468,469,472,473,
            475,477,476,478,480,482,488,491,492,493,
            496,497,500,502,505,501,508,516,512,518,
            519,521,522,524,525,527,530,533,535,537,
            542,534,544,549,545,552,546,556,558,559,
            560,562,565,568,566,570,573,575,571,577,
            581,584,506,585,579,586,593,595,587,150,
            589,591,597,600,598,601,605,610,611,607,
            613,616,619,620,618,621,624,625,630,631,
            635,637,642,645,648,633,650,651,652,653,
            657,655,658,660,661,663,664,672,675,676,
            677,666,667,682,683,684,685,687,691,695,
            692,699,698,703,702,705,706,710,713,718,
            711,722,725,719,723,728,730,731,732,715,
            734,738,735,740,742,746,748,749,750,753,
            751,758,424,424
        };
    };
    public final static char baseAction[] = BaseAction.baseAction;
    public final int baseAction(int index) { return baseAction[index]; }
    public final static char lhs[] = baseAction;
    public final int lhs(int index) { return lhs[index]; };

    public interface TermCheck {
        public final static byte termCheck[] = {0,
            0,1,2,3,4,5,6,7,8,9,
            10,11,12,0,0,15,2,3,4,19,
            20,0,22,23,0,0,26,27,28,29,
            30,31,32,8,34,0,0,37,2,4,
            4,0,7,19,0,9,11,3,12,25,
            15,16,28,29,18,0,0,1,2,35,
            19,40,7,8,0,24,0,3,4,3,
            0,0,0,3,2,0,21,36,8,38,
            5,15,7,8,13,0,0,23,16,0,
            0,21,7,0,5,5,11,8,8,33,
            14,8,0,1,0,1,13,0,0,2,
            8,0,8,0,0,0,5,2,10,5,
            7,6,14,0,13,12,0,0,0,22,
            3,4,0,10,6,12,0,1,6,0,
            0,1,6,4,16,19,7,15,0,0,
            24,3,12,0,1,0,8,0,0,6,
            0,1,0,1,6,16,0,0,13,0,
            4,4,0,1,0,1,27,8,21,0,
            0,1,0,1,0,0,0,8,3,0,
            0,0,3,0,0,0,10,2,8,15,
            7,7,0,0,0,3,3,0,17,2,
            0,7,0,1,0,1,0,0,1,3,
            0,0,2,0,3,15,0,1,0,0,
            1,0,0,0,0,0,0,9,0,8,
            0,18,10,9,11,0,1,7,0,0,
            0,15,3,3,0,7,0,3,0,1,
            0,5,0,3,29,0,1,5,0,1,
            0,0,0,3,3,0,0,0,6,0,
            0,0,3,0,0,0,9,7,13,0,
            7,7,0,4,0,1,4,0,0,0,
            24,0,5,5,19,6,0,1,0,1,
            9,0,0,0,0,0,0,3,2,8,
            0,0,9,11,0,0,2,0,0,14,
            2,4,7,0,0,2,0,1,0,18,
            20,0,1,0,0,0,3,0,14,2,
            5,0,0,0,0,1,18,4,0,0,
            8,17,11,4,0,7,0,1,0,1,
            0,0,1,0,4,0,3,0,1,0,
            0,0,7,0,0,4,0,0,9,9,
            6,0,9,0,0,4,2,0,0,0,
            13,0,16,5,7,12,0,1,0,1,
            0,0,0,0,13,5,0,6,6,20,
            7,5,0,1,0,0,0,0,1,0,
            0,6,6,0,0,11,6,0,0,2,
            11,0,0,9,6,0,1,0,0,16,
            0,0,5,11,4,14,0,6,0,3,
            0,0,0,0,1,17,4,0,0,9,
            3,0,0,12,0,0,0,0,10,0,
            9,0,7,11,8,11,28,0,11,2,
            0,0,0,2,2,0,0,1,17,0,
            0,0,23,2,0,0,2,0,3,10,
            10,0,22,18,7,0,1,0,0,8,
            0,0,5,0,0,2,0,9,4,0,
            10,10,0,0,0,0,0,11,4,10,
            4,0,1,0,0,0,14,14,0,6,
            2,0,8,2,9,0,1,0,0,0,
            1,0,4,2,0,0,2,0,1,0,
            0,6,0,1,0,1,0,20,0,9,
            0,1,13,0,0,0,0,4,0,5,
            0,6,0,1,0,1,0,0,10,0,
            0,15,5,4,0,27,0,7,32,0,
            0,15,0,3,5,0,1,0,0,0,
            0,31,4,0,0,1,6,10,16,0,
            0,25,0,14,0,1,0,8,2,9,
            17,0,10,39,0,1,5,0,1,0,
            0,0,0,4,0,1,0,0,1,0,
            0,2,0,0,1,0,0,16,18,17,
            14,0,10,2,0,0,0,12,4,3,
            5,0,0,0,0,25,0,1,5,5,
            0,0,26,11,0,1,5,0,0,9,
            2,0,0,6,0,0,1,26,6,0,
            0,2,0,12,0,3,12,0,0,2,
            10,0,0,2,0,1,4,0,10,0,
            0,0,1,0,0,6,9,0,1,0,
            1,0,8,13,30,0,13,0,0,0,
            0,10,0,4,7,5,0,0,10,14,
            3,9,0,0,0,0,0,0,0,0,
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
            424,104,102,97,98,101,108,91,100,109,
            103,105,96,424,424,107,135,136,137,90,
            86,424,85,99,424,424,92,95,87,89,
            106,84,94,120,93,424,424,88,154,134,
            156,424,441,308,424,153,133,163,436,310,
            132,131,311,309,155,424,424,124,123,312,
            217,423,139,138,424,220,424,144,145,167,
            424,424,424,147,165,424,140,218,148,219,
            150,166,152,151,111,424,424,143,164,424,
            424,146,119,424,122,126,118,121,125,168,
            495,129,424,142,424,158,128,424,424,449,
            141,424,157,424,424,424,183,189,440,162,
            187,190,458,424,184,188,424,424,22,174,
            196,197,424,193,205,192,424,427,239,424,
            424,252,201,503,426,230,208,240,424,424,
            229,250,425,424,290,424,249,424,424,291,
            424,112,424,114,211,362,424,424,113,424,
            115,116,424,117,424,127,361,130,110,424,
            424,159,424,160,424,424,424,149,169,424,
            424,424,171,424,424,424,170,445,172,161,
            173,175,424,424,424,176,177,424,450,443,
            424,442,424,178,424,179,424,424,459,180,
            424,424,181,424,182,501,424,185,424,424,
            194,424,424,424,424,424,424,191,424,195,
            424,186,198,200,199,424,203,206,424,424,
            424,204,207,210,424,209,424,477,424,213,
            424,212,424,214,202,424,216,215,424,221,
            424,424,424,222,223,424,424,424,224,424,
            424,424,484,424,424,424,227,228,225,424,
            487,486,424,232,424,447,437,424,9,424,
            226,424,233,235,231,234,424,236,424,438,
            237,424,424,424,424,424,424,243,244,238,
            424,424,242,241,424,424,428,424,424,429,
            435,247,248,424,424,251,424,504,424,246,
            245,424,479,424,424,424,254,424,498,257,
            256,424,424,424,424,260,253,259,424,424,
            261,255,258,262,424,263,424,264,424,265,
            424,424,267,424,266,424,268,424,448,424,
            424,424,269,424,424,272,424,424,270,271,
            274,424,273,424,424,277,278,424,424,424,
            276,424,275,280,279,439,424,283,424,284,
            424,424,424,424,282,285,424,286,287,281,
            289,288,424,292,424,424,424,424,296,424,
            424,294,295,424,424,293,298,424,424,462,
            297,424,424,300,301,424,302,424,424,299,
            424,424,304,303,305,480,424,306,424,455,
            424,424,424,424,434,474,490,424,424,313,
            315,424,424,314,424,424,424,424,316,424,
            456,424,320,317,319,318,307,424,321,324,
            424,424,424,326,494,424,424,328,323,424,
            424,424,322,461,424,424,330,424,355,329,
            482,424,325,327,475,424,500,424,424,331,
            424,424,332,424,424,335,424,333,478,424,
            481,334,424,424,424,424,424,336,339,337,
            340,424,341,424,424,424,338,342,424,343,
            344,424,345,346,492,424,491,424,424,424,
            465,424,348,349,424,424,430,424,431,424,
            424,350,424,454,424,352,424,347,424,444,
            424,354,351,424,424,424,424,499,424,356,
            424,358,424,451,424,359,424,424,363,424,
            424,360,366,365,424,357,36,367,353,424,
            424,364,424,370,369,424,457,424,424,424,
            424,469,373,424,424,377,375,374,372,424,
            424,371,424,464,424,468,424,378,379,496,
            376,424,383,368,424,381,380,424,382,424,
            424,424,424,384,424,388,424,424,497,424,
            424,389,424,424,483,424,424,386,385,387,
            488,424,485,453,424,424,424,393,452,392,
            391,424,424,424,424,390,424,432,397,398,
            424,424,394,396,424,400,401,424,424,399,
            402,424,424,403,424,424,405,395,404,424,
            424,406,424,467,424,407,466,424,424,408,
            409,424,424,410,424,472,411,424,471,424,
            424,424,414,424,424,412,473,424,417,424,
            419,424,418,413,415,424,416,424,424,424,
            424,463,424,502,420,421,424,424,470,493,
            476,489
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
           NUM_STATES        = 340,
           NT_OFFSET         = 55,
           LA_STATE_OFFSET   = 504,
           MAX_LA            = 1,
           NUM_RULES         = 80,
           NUM_NONTERMINALS  = 2,
           NUM_SYMBOLS       = 57,
           SEGMENT_SIZE      = 8192,
           START_STATE       = 81,
           IDENTIFIER_SYMBOL = 0,
           EOFT_SYMBOL       = 40,
           EOLT_SYMBOL       = 56,
           ACCEPT_ACTION     = 423,
           ERROR_ACTION      = 424;

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
