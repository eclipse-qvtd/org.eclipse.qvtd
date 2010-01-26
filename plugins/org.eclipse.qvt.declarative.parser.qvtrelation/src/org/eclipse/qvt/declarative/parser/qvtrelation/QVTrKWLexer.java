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



public class QVTrKWLexer extends QVTrKWLexerprs
{
    private char[] inputChars;
    private final int keywordKind[] = new int[47 + 1];

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
        tokenKind['$'] = QVTrKWLexersym.Char_DollarSign;
        tokenKind['%'] = QVTrKWLexersym.Char_Percent;
        tokenKind['_'] = QVTrKWLexersym.Char__;

        tokenKind['a'] = QVTrKWLexersym.Char_a;
        tokenKind['b'] = QVTrKWLexersym.Char_b;
        tokenKind['c'] = QVTrKWLexersym.Char_c;
        tokenKind['d'] = QVTrKWLexersym.Char_d;
        tokenKind['e'] = QVTrKWLexersym.Char_e;
        tokenKind['f'] = QVTrKWLexersym.Char_f;
        tokenKind['g'] = QVTrKWLexersym.Char_g;
        tokenKind['h'] = QVTrKWLexersym.Char_h;
        tokenKind['i'] = QVTrKWLexersym.Char_i;
        tokenKind['j'] = QVTrKWLexersym.Char_j;
        tokenKind['k'] = QVTrKWLexersym.Char_k;
        tokenKind['l'] = QVTrKWLexersym.Char_l;
        tokenKind['m'] = QVTrKWLexersym.Char_m;
        tokenKind['n'] = QVTrKWLexersym.Char_n;
        tokenKind['o'] = QVTrKWLexersym.Char_o;
        tokenKind['p'] = QVTrKWLexersym.Char_p;
        tokenKind['q'] = QVTrKWLexersym.Char_q;
        tokenKind['r'] = QVTrKWLexersym.Char_r;
        tokenKind['s'] = QVTrKWLexersym.Char_s;
        tokenKind['t'] = QVTrKWLexersym.Char_t;
        tokenKind['u'] = QVTrKWLexersym.Char_u;
        tokenKind['v'] = QVTrKWLexersym.Char_v;
        tokenKind['w'] = QVTrKWLexersym.Char_w;
        tokenKind['x'] = QVTrKWLexersym.Char_x;
        tokenKind['y'] = QVTrKWLexersym.Char_y;
        tokenKind['z'] = QVTrKWLexersym.Char_z;

        tokenKind['A'] = QVTrKWLexersym.Char_A;
        tokenKind['B'] = QVTrKWLexersym.Char_B;
        tokenKind['C'] = QVTrKWLexersym.Char_C;
        tokenKind['D'] = QVTrKWLexersym.Char_D;
        tokenKind['E'] = QVTrKWLexersym.Char_E;
        tokenKind['F'] = QVTrKWLexersym.Char_F;
        tokenKind['G'] = QVTrKWLexersym.Char_G;
        tokenKind['H'] = QVTrKWLexersym.Char_H;
        tokenKind['I'] = QVTrKWLexersym.Char_I;
        tokenKind['J'] = QVTrKWLexersym.Char_J;
        tokenKind['K'] = QVTrKWLexersym.Char_K;
        tokenKind['L'] = QVTrKWLexersym.Char_L;
        tokenKind['M'] = QVTrKWLexersym.Char_M;
        tokenKind['N'] = QVTrKWLexersym.Char_N;
        tokenKind['O'] = QVTrKWLexersym.Char_O;
        tokenKind['P'] = QVTrKWLexersym.Char_P;
        tokenKind['Q'] = QVTrKWLexersym.Char_Q;
        tokenKind['R'] = QVTrKWLexersym.Char_R;
        tokenKind['S'] = QVTrKWLexersym.Char_S;
        tokenKind['T'] = QVTrKWLexersym.Char_T;
        tokenKind['U'] = QVTrKWLexersym.Char_U;
        tokenKind['V'] = QVTrKWLexersym.Char_V;
        tokenKind['W'] = QVTrKWLexersym.Char_W;
        tokenKind['X'] = QVTrKWLexersym.Char_X;
        tokenKind['Y'] = QVTrKWLexersym.Char_Y;
        tokenKind['Z'] = QVTrKWLexersym.Char_Z;
    };

    final int getKind(char c)
    {
        return (((c & 0xFFFFFF80) == 0) /* 0 <= c < 128? */ ? tokenKind[c] : 0);
    }

    static
    {
        tokenKind['_'] = Char__;
    };


    public QVTrKWLexer(char[] inputChars, int identifierKind)
    {
        this.inputChars = inputChars;
        keywordKind[0] = identifierKind;

        //
        // Rule 1:  KeyWord ::= s e l f
        //
        
		keywordKind[1] = (QVTrParsersym.TK_self);
	  
	
        //
        // Rule 2:  KeyWord ::= i f
        //
        
		keywordKind[2] = (QVTrParsersym.TK_if);
	  
	
        //
        // Rule 3:  KeyWord ::= t h e n
        //
        
		keywordKind[3] = (QVTrParsersym.TK_then);
	  
	
        //
        // Rule 4:  KeyWord ::= e l s e
        //
        
		keywordKind[4] = (QVTrParsersym.TK_else);
	  
	
        //
        // Rule 5:  KeyWord ::= e n d i f
        //
        
		keywordKind[5] = (QVTrParsersym.TK_endif);
	  
	
        //
        // Rule 6:  KeyWord ::= a n d
        //
        
		keywordKind[6] = (QVTrParsersym.TK_and);
	  
	
        //
        // Rule 7:  KeyWord ::= o r
        //
        
		keywordKind[7] = (QVTrParsersym.TK_or);
	  
	
        //
        // Rule 8:  KeyWord ::= x o r
        //
        
		keywordKind[8] = (QVTrParsersym.TK_xor);
	  
	
        //
        // Rule 9:  KeyWord ::= n o t
        //
        
		keywordKind[9] = (QVTrParsersym.TK_not);
	  
	
        //
        // Rule 10:  KeyWord ::= i m p l i e s
        //
        
		keywordKind[10] = (QVTrParsersym.TK_implies);
	  
	
        //
        // Rule 11:  KeyWord ::= l e t
        //
        
		keywordKind[11] = (QVTrParsersym.TK_let);
	  
	
        //
        // Rule 12:  KeyWord ::= i n
        //
        
		keywordKind[12] = (QVTrParsersym.TK_in);
	  
	
        //
        // Rule 13:  KeyWord ::= t r u e
        //
        
		keywordKind[13] = (QVTrParsersym.TK_true);
	  
	
        //
        // Rule 14:  KeyWord ::= f a l s e
        //
        
		keywordKind[14] = (QVTrParsersym.TK_false);
	  
	
        //
        // Rule 15:  KeyWord ::= S e t
        //
        
		keywordKind[15] = (QVTrParsersym.TK_Set);
	  
	
        //
        // Rule 16:  KeyWord ::= B a g
        //
        
		keywordKind[16] = (QVTrParsersym.TK_Bag);
	  
	
        //
        // Rule 17:  KeyWord ::= S e q u e n c e
        //
        
		keywordKind[17] = (QVTrParsersym.TK_Sequence);
	  
	
        //
        // Rule 18:  KeyWord ::= C o l l e c t i o n
        //
        
		keywordKind[18] = (QVTrParsersym.TK_Collection);
	  
	
        //
        // Rule 19:  KeyWord ::= O r d e r e d S e t
        //
        
		keywordKind[19] = (QVTrParsersym.TK_OrderedSet);
	  
	
        //
        // Rule 20:  KeyWord ::= S t r i n g
        //
        
		keywordKind[20] = (QVTrParsersym.TK_String);
	  
	
        //
        // Rule 21:  KeyWord ::= I n t e g e r
        //
        
		keywordKind[21] = (QVTrParsersym.TK_Integer);
	  
	
        //
        // Rule 22:  KeyWord ::= U n l i m i t e d N a t u r a l
        //
        
		keywordKind[22] = (QVTrParsersym.TK_UnlimitedNatural);
	  
	
        //
        // Rule 23:  KeyWord ::= R e a l
        //
        
		keywordKind[23] = (QVTrParsersym.TK_Real);
	  
	
        //
        // Rule 24:  KeyWord ::= B o o l e a n
        //
        
		keywordKind[24] = (QVTrParsersym.TK_Boolean);
	  
	
        //
        // Rule 25:  KeyWord ::= T u p l e
        //
        
		keywordKind[25] = (QVTrParsersym.TK_Tuple);
	  
	
        //
        // Rule 26:  KeyWord ::= O c l A n y
        //
        
		keywordKind[26] = (QVTrParsersym.TK_OclAny);
	  
	
        //
        // Rule 27:  KeyWord ::= O c l V o i d
        //
        
		keywordKind[27] = (QVTrParsersym.TK_OclVoid);
	  
	
        //
        // Rule 28:  KeyWord ::= O c l I n v a l i d
        //
        
		keywordKind[28] = (QVTrParsersym.TK_OclInvalid);
	  
	
        //
        // Rule 29:  KeyWord ::= n u l l
        //
        
		keywordKind[29] = (QVTrParsersym.TK_null);
	  
	
        //
        // Rule 30:  KeyWord ::= i n v a l i d
        //
        
		keywordKind[30] = (QVTrParsersym.TK_invalid);
	  
	
        //
        // Rule 31:  KeyWord ::= c h e c k o n l y
        //
        
		keywordKind[31] = (QVTrParsersym.TK_checkonly);
	  
	
        //
        // Rule 32:  KeyWord ::= d e f a u l t _ v a l u e s
        //
        
		keywordKind[32] = (QVTrParsersym.TK_default_values);
	  
	
        //
        // Rule 33:  KeyWord ::= d o m a i n
        //
        
		keywordKind[33] = (QVTrParsersym.TK_domain);
	  
	
        //
        // Rule 34:  KeyWord ::= e n f o r c e
        //
        
		keywordKind[34] = (QVTrParsersym.TK_enforce);
	  
	
        //
        // Rule 35:  KeyWord ::= e x t e n d s
        //
        
		keywordKind[35] = (QVTrParsersym.TK_extends);
	  
	
        //
        // Rule 36:  KeyWord ::= i m p l e m e n t e d b y
        //
        
		keywordKind[36] = (QVTrParsersym.TK_implementedby);
	  
	
        //
        // Rule 37:  KeyWord ::= i m p o r t
        //
        
		keywordKind[37] = (QVTrParsersym.TK_import);
	  
	
        //
        // Rule 38:  KeyWord ::= k e y
        //
        
		keywordKind[38] = (QVTrParsersym.TK_key);
	  
	
        //
        // Rule 39:  KeyWord ::= o v e r r i d e s
        //
        
		keywordKind[39] = (QVTrParsersym.TK_overrides);
	  
	
        //
        // Rule 40:  KeyWord ::= p r i m i t i v e
        //
        
		keywordKind[40] = (QVTrParsersym.TK_primitive);
	  
	
        //
        // Rule 41:  KeyWord ::= q u e r y
        //
        
		keywordKind[41] = (QVTrParsersym.TK_query);
	  
	
        //
        // Rule 42:  KeyWord ::= r e l a t i o n
        //
        
		keywordKind[42] = (QVTrParsersym.TK_relation);
	  
	
        //
        // Rule 43:  KeyWord ::= r e p l a c e
        //
        
		keywordKind[43] = (QVTrParsersym.TK_replace);
	  
	
        //
        // Rule 44:  KeyWord ::= t o p
        //
        
		keywordKind[44] = (QVTrParsersym.TK_top);
	  
	
        //
        // Rule 45:  KeyWord ::= t r a n s f o r m a t i o n
        //
        
		keywordKind[45] = (QVTrParsersym.TK_transformation);
	  
	
        //
        // Rule 46:  KeyWord ::= w h e n
        //
        
		keywordKind[46] = (QVTrParsersym.TK_when);
	  
	
        //
        // Rule 47:  KeyWord ::= w h e r e
        //
        
		keywordKind[47] = (QVTrParsersym.TK_where);
	  
	
        for (int i = 0; i < keywordKind.length; i++)
        {
            if (keywordKind[i] == 0)
                keywordKind[i] = identifierKind;
        }
    }
}

