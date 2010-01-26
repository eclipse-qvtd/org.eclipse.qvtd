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



public class QVTcKWLexer extends QVTcKWLexerprs
{
    private char[] inputChars;
    private final int keywordKind[] = new int[43 + 1];

    public int[] getKeywordKinds() { return keywordKind; }

    public int lexer(int curtok, int lasttok)
    {
        int current_kind = getKind(inputChars[curtok]),
            act;

        for (act = tAction(START_STATE, current_kind);
             act > NUM_RULES && act < ACCEPT_ACTION;
             act = tAction(act, current_kind))
        {
            curtok++;
            current_kind = (curtok > lasttok
                                   ? Char_EOF
                                   : getKind(inputChars[curtok]));
        }

        if (act > ERROR_ACTION)
        {
            curtok++;
            act -= ERROR_ACTION;
        }

        return keywordKind[act == ERROR_ACTION  || curtok <= lasttok ? 0 : act];
    }

    public void setInputChars(char[] inputChars) { this.inputChars = inputChars; }


    final static int tokenKind[] = new int[128];
    static
    {
        tokenKind['$'] = QVTcKWLexersym.Char_DollarSign;
        tokenKind['%'] = QVTcKWLexersym.Char_Percent;
        tokenKind['_'] = QVTcKWLexersym.Char__;

        tokenKind['a'] = QVTcKWLexersym.Char_a;
        tokenKind['b'] = QVTcKWLexersym.Char_b;
        tokenKind['c'] = QVTcKWLexersym.Char_c;
        tokenKind['d'] = QVTcKWLexersym.Char_d;
        tokenKind['e'] = QVTcKWLexersym.Char_e;
        tokenKind['f'] = QVTcKWLexersym.Char_f;
        tokenKind['g'] = QVTcKWLexersym.Char_g;
        tokenKind['h'] = QVTcKWLexersym.Char_h;
        tokenKind['i'] = QVTcKWLexersym.Char_i;
        tokenKind['j'] = QVTcKWLexersym.Char_j;
        tokenKind['k'] = QVTcKWLexersym.Char_k;
        tokenKind['l'] = QVTcKWLexersym.Char_l;
        tokenKind['m'] = QVTcKWLexersym.Char_m;
        tokenKind['n'] = QVTcKWLexersym.Char_n;
        tokenKind['o'] = QVTcKWLexersym.Char_o;
        tokenKind['p'] = QVTcKWLexersym.Char_p;
        tokenKind['q'] = QVTcKWLexersym.Char_q;
        tokenKind['r'] = QVTcKWLexersym.Char_r;
        tokenKind['s'] = QVTcKWLexersym.Char_s;
        tokenKind['t'] = QVTcKWLexersym.Char_t;
        tokenKind['u'] = QVTcKWLexersym.Char_u;
        tokenKind['v'] = QVTcKWLexersym.Char_v;
        tokenKind['w'] = QVTcKWLexersym.Char_w;
        tokenKind['x'] = QVTcKWLexersym.Char_x;
        tokenKind['y'] = QVTcKWLexersym.Char_y;
        tokenKind['z'] = QVTcKWLexersym.Char_z;

        tokenKind['A'] = QVTcKWLexersym.Char_A;
        tokenKind['B'] = QVTcKWLexersym.Char_B;
        tokenKind['C'] = QVTcKWLexersym.Char_C;
        tokenKind['D'] = QVTcKWLexersym.Char_D;
        tokenKind['E'] = QVTcKWLexersym.Char_E;
        tokenKind['F'] = QVTcKWLexersym.Char_F;
        tokenKind['G'] = QVTcKWLexersym.Char_G;
        tokenKind['H'] = QVTcKWLexersym.Char_H;
        tokenKind['I'] = QVTcKWLexersym.Char_I;
        tokenKind['J'] = QVTcKWLexersym.Char_J;
        tokenKind['K'] = QVTcKWLexersym.Char_K;
        tokenKind['L'] = QVTcKWLexersym.Char_L;
        tokenKind['M'] = QVTcKWLexersym.Char_M;
        tokenKind['N'] = QVTcKWLexersym.Char_N;
        tokenKind['O'] = QVTcKWLexersym.Char_O;
        tokenKind['P'] = QVTcKWLexersym.Char_P;
        tokenKind['Q'] = QVTcKWLexersym.Char_Q;
        tokenKind['R'] = QVTcKWLexersym.Char_R;
        tokenKind['S'] = QVTcKWLexersym.Char_S;
        tokenKind['T'] = QVTcKWLexersym.Char_T;
        tokenKind['U'] = QVTcKWLexersym.Char_U;
        tokenKind['V'] = QVTcKWLexersym.Char_V;
        tokenKind['W'] = QVTcKWLexersym.Char_W;
        tokenKind['X'] = QVTcKWLexersym.Char_X;
        tokenKind['Y'] = QVTcKWLexersym.Char_Y;
        tokenKind['Z'] = QVTcKWLexersym.Char_Z;
    };

    final int getKind(char c)
    {
        return (((c & 0xFFFFFF80) == 0) /* 0 <= c < 128? */ ? tokenKind[c] : 0);
    }


    public QVTcKWLexer(char[] inputChars, int identifierKind)
    {
        this.inputChars = inputChars;
        keywordKind[0] = identifierKind;

        //
        // Rule 1:  KeyWord ::= s e l f
        //
        
		keywordKind[1] = (QVTcParsersym.TK_self);
	  
	
        //
        // Rule 2:  KeyWord ::= i f
        //
        
		keywordKind[2] = (QVTcParsersym.TK_if);
	  
	
        //
        // Rule 3:  KeyWord ::= t h e n
        //
        
		keywordKind[3] = (QVTcParsersym.TK_then);
	  
	
        //
        // Rule 4:  KeyWord ::= e l s e
        //
        
		keywordKind[4] = (QVTcParsersym.TK_else);
	  
	
        //
        // Rule 5:  KeyWord ::= e n d i f
        //
        
		keywordKind[5] = (QVTcParsersym.TK_endif);
	  
	
        //
        // Rule 6:  KeyWord ::= a n d
        //
        
		keywordKind[6] = (QVTcParsersym.TK_and);
	  
	
        //
        // Rule 7:  KeyWord ::= o r
        //
        
		keywordKind[7] = (QVTcParsersym.TK_or);
	  
	
        //
        // Rule 8:  KeyWord ::= x o r
        //
        
		keywordKind[8] = (QVTcParsersym.TK_xor);
	  
	
        //
        // Rule 9:  KeyWord ::= n o t
        //
        
		keywordKind[9] = (QVTcParsersym.TK_not);
	  
	
        //
        // Rule 10:  KeyWord ::= i m p l i e s
        //
        
		keywordKind[10] = (QVTcParsersym.TK_implies);
	  
	
        //
        // Rule 11:  KeyWord ::= l e t
        //
        
		keywordKind[11] = (QVTcParsersym.TK_let);
	  
	
        //
        // Rule 12:  KeyWord ::= i n
        //
        
		keywordKind[12] = (QVTcParsersym.TK_in);
	  
	
        //
        // Rule 13:  KeyWord ::= t r u e
        //
        
		keywordKind[13] = (QVTcParsersym.TK_true);
	  
	
        //
        // Rule 14:  KeyWord ::= f a l s e
        //
        
		keywordKind[14] = (QVTcParsersym.TK_false);
	  
	
        //
        // Rule 15:  KeyWord ::= S e t
        //
        
		keywordKind[15] = (QVTcParsersym.TK_Set);
	  
	
        //
        // Rule 16:  KeyWord ::= B a g
        //
        
		keywordKind[16] = (QVTcParsersym.TK_Bag);
	  
	
        //
        // Rule 17:  KeyWord ::= S e q u e n c e
        //
        
		keywordKind[17] = (QVTcParsersym.TK_Sequence);
	  
	
        //
        // Rule 18:  KeyWord ::= C o l l e c t i o n
        //
        
		keywordKind[18] = (QVTcParsersym.TK_Collection);
	  
	
        //
        // Rule 19:  KeyWord ::= O r d e r e d S e t
        //
        
		keywordKind[19] = (QVTcParsersym.TK_OrderedSet);
	  
	
        //
        // Rule 20:  KeyWord ::= S t r i n g
        //
        
		keywordKind[20] = (QVTcParsersym.TK_String);
	  
	
        //
        // Rule 21:  KeyWord ::= I n t e g e r
        //
        
		keywordKind[21] = (QVTcParsersym.TK_Integer);
	  
	
        //
        // Rule 22:  KeyWord ::= U n l i m i t e d N a t u r a l
        //
        
		keywordKind[22] = (QVTcParsersym.TK_UnlimitedNatural);
	  
	
        //
        // Rule 23:  KeyWord ::= R e a l
        //
        
		keywordKind[23] = (QVTcParsersym.TK_Real);
	  
	
        //
        // Rule 24:  KeyWord ::= B o o l e a n
        //
        
		keywordKind[24] = (QVTcParsersym.TK_Boolean);
	  
	
        //
        // Rule 25:  KeyWord ::= T u p l e
        //
        
		keywordKind[25] = (QVTcParsersym.TK_Tuple);
	  
	
        //
        // Rule 26:  KeyWord ::= O c l A n y
        //
        
		keywordKind[26] = (QVTcParsersym.TK_OclAny);
	  
	
        //
        // Rule 27:  KeyWord ::= O c l V o i d
        //
        
		keywordKind[27] = (QVTcParsersym.TK_OclVoid);
	  
	
        //
        // Rule 28:  KeyWord ::= O c l I n v a l i d
        //
        
		keywordKind[28] = (QVTcParsersym.TK_OclInvalid);
	  
	
        //
        // Rule 29:  KeyWord ::= n u l l
        //
        
		keywordKind[29] = (QVTcParsersym.TK_null);
	  
	
        //
        // Rule 30:  KeyWord ::= i n v a l i d
        //
        
		keywordKind[30] = (QVTcParsersym.TK_invalid);
	  
	
        //
        // Rule 31:  KeyWord ::= c h e c k
        //
        
		keywordKind[31] = (QVTcParsersym.TK_check);
	  
	
        //
        // Rule 32:  KeyWord ::= c r e a t i o n
        //
        
		keywordKind[32] = (QVTcParsersym.TK_creation);
	  
	
        //
        // Rule 33:  KeyWord ::= d e f a u l t
        //
        
		keywordKind[33] = (QVTcParsersym.TK_default);
	  
	
        //
        // Rule 34:  KeyWord ::= d e l e t i o n
        //
        
		keywordKind[34] = (QVTcParsersym.TK_deletion);
	  
	
        //
        // Rule 35:  KeyWord ::= e n f o r c e
        //
        
		keywordKind[35] = (QVTcParsersym.TK_enforce);
	  
	
        //
        // Rule 36:  KeyWord ::= i m p o r t s
        //
        
		keywordKind[36] = (QVTcParsersym.TK_imports);
	  
	
        //
        // Rule 37:  KeyWord ::= m a p
        //
        
		keywordKind[37] = (QVTcParsersym.TK_map);
	  
	
        //
        // Rule 38:  KeyWord ::= q u e r y
        //
        
		keywordKind[38] = (QVTcParsersym.TK_query);
	  
	
        //
        // Rule 39:  KeyWord ::= r e a l i z e
        //
        
		keywordKind[39] = (QVTcParsersym.TK_realize);
	  
	
        //
        // Rule 40:  KeyWord ::= r e f i n e s
        //
        
		keywordKind[40] = (QVTcParsersym.TK_refines);
	  
	
        //
        // Rule 41:  KeyWord ::= t r a n s f o r m a t i o n
        //
        
		keywordKind[41] = (QVTcParsersym.TK_transformation);
	  
	
        //
        // Rule 42:  KeyWord ::= u s e s
        //
        
		keywordKind[42] = (QVTcParsersym.TK_uses);
	  
	
        //
        // Rule 43:  KeyWord ::= w h e r e
        //
        
		keywordKind[43] = (QVTcParsersym.TK_where);
	  
	
        for (int i = 0; i < keywordKind.length; i++)
        {
            if (keywordKind[i] == 0)
                keywordKind[i] = identifierKind;
        }
    }
}

