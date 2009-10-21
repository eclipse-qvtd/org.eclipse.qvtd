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
* $Id: QVTrKWLexer.java,v 1.12 2009/10/21 07:49:03 ewillink Exp $
*/

package org.eclipse.qvt.declarative.parser.qvtrelation;



public class QVTrKWLexer extends QVTrKWLexerprs implements QVTrParsersym
{
    private char[] inputChars;
    private final int keywordKind[] = new int[59 + 1];

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
        tokenKind['$'] = Char_DollarSign;

        tokenKind['a'] = Char_a;
        tokenKind['b'] = Char_b;
        tokenKind['c'] = Char_c;
        tokenKind['d'] = Char_d;
        tokenKind['e'] = Char_e;
        tokenKind['f'] = Char_f;
        tokenKind['g'] = Char_g;
        tokenKind['h'] = Char_h;
        tokenKind['i'] = Char_i;
        tokenKind['j'] = Char_j;
        tokenKind['k'] = Char_k;
        tokenKind['l'] = Char_l;
        tokenKind['m'] = Char_m;
        tokenKind['n'] = Char_n;
        tokenKind['o'] = Char_o;
        tokenKind['p'] = Char_p;
        tokenKind['q'] = Char_q;
        tokenKind['r'] = Char_r;
        tokenKind['s'] = Char_s;
        tokenKind['t'] = Char_t;
        tokenKind['u'] = Char_u;
        tokenKind['v'] = Char_v;
        tokenKind['w'] = Char_w;
        tokenKind['x'] = Char_x;
        tokenKind['y'] = Char_y;
        tokenKind['z'] = Char_z;

        tokenKind['A'] = Char_A;
        tokenKind['B'] = Char_B;
        tokenKind['C'] = Char_C;
        tokenKind['D'] = Char_D;
        tokenKind['E'] = Char_E;
        tokenKind['F'] = Char_F;
        tokenKind['G'] = Char_G;
        tokenKind['H'] = Char_H;
        tokenKind['I'] = Char_I;
        tokenKind['J'] = Char_J;
        tokenKind['K'] = Char_K;
        tokenKind['L'] = Char_L;
        tokenKind['M'] = Char_M;
        tokenKind['N'] = Char_N;
        tokenKind['O'] = Char_O;
        tokenKind['P'] = Char_P;
        tokenKind['Q'] = Char_Q;
        tokenKind['R'] = Char_R;
        tokenKind['S'] = Char_S;
        tokenKind['T'] = Char_T;
        tokenKind['U'] = Char_U;
        tokenKind['V'] = Char_V;
        tokenKind['W'] = Char_W;
        tokenKind['X'] = Char_X;
        tokenKind['Y'] = Char_Y;
        tokenKind['Z'] = Char_Z;
    };

    final int getKind(char c)
    {
        return (c < 128 ? tokenKind[c] : 0);
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
		keywordKind[1] = (TK_self);
	  
	
        //
        // Rule 2:  KeyWord ::= i f
        //
		keywordKind[2] = (TK_if);
	  
	
        //
        // Rule 3:  KeyWord ::= t h e n
        //
		keywordKind[3] = (TK_then);
	  
	
        //
        // Rule 4:  KeyWord ::= e l s e
        //
		keywordKind[4] = (TK_else);
	  
	
        //
        // Rule 5:  KeyWord ::= e n d i f
        //
		keywordKind[5] = (TK_endif);
	  
	
        //
        // Rule 6:  KeyWord ::= a n d
        //
		keywordKind[6] = (TK_and);
	  
	
        //
        // Rule 7:  KeyWord ::= o r
        //
		keywordKind[7] = (TK_or);
	  
	
        //
        // Rule 8:  KeyWord ::= x o r
        //
		keywordKind[8] = (TK_xor);
	  
	
        //
        // Rule 9:  KeyWord ::= n o t
        //
		keywordKind[9] = (TK_not);
	  
	
        //
        // Rule 10:  KeyWord ::= i m p l i e s
        //
		keywordKind[10] = (TK_implies);
	  
	
        //
        // Rule 11:  KeyWord ::= l e t
        //
		keywordKind[11] = (TK_let);
	  
	
        //
        // Rule 12:  KeyWord ::= i n
        //
		keywordKind[12] = (TK_in);
	  
	
        //
        // Rule 13:  KeyWord ::= t r u e
        //
		keywordKind[13] = (TK_true);
	  
	
        //
        // Rule 14:  KeyWord ::= f a l s e
        //
		keywordKind[14] = (TK_false);
	  
	
        //
        // Rule 15:  KeyWord ::= S e t
        //
		keywordKind[15] = (TK_Set);
	  
	
        //
        // Rule 16:  KeyWord ::= B a g
        //
		keywordKind[16] = (TK_Bag);
	  
	
        //
        // Rule 17:  KeyWord ::= S e q u e n c e
        //
		keywordKind[17] = (TK_Sequence);
	  
	
        //
        // Rule 18:  KeyWord ::= C o l l e c t i o n
        //
		keywordKind[18] = (TK_Collection);
	  
	
        //
        // Rule 19:  KeyWord ::= O r d e r e d S e t
        //
		keywordKind[19] = (TK_OrderedSet);
	  
	
        //
        // Rule 20:  KeyWord ::= i t e r a t e
        //
		keywordKind[20] = (TK_iterate);
	  
	
        //
        // Rule 21:  KeyWord ::= f o r A l l
        //
		keywordKind[21] = (TK_forAll);
	  
	
        //
        // Rule 22:  KeyWord ::= e x i s t s
        //
		keywordKind[22] = (TK_exists);
	  
	
        //
        // Rule 23:  KeyWord ::= i s U n i q u e
        //
		keywordKind[23] = (TK_isUnique);
	  
	
        //
        // Rule 24:  KeyWord ::= a n y
        //
		keywordKind[24] = (TK_any);
	  
	
        //
        // Rule 25:  KeyWord ::= o n e
        //
		keywordKind[25] = (TK_one);
	  
	
        //
        // Rule 26:  KeyWord ::= c o l l e c t
        //
		keywordKind[26] = (TK_collect);
	  
	
        //
        // Rule 27:  KeyWord ::= s e l e c t
        //
		keywordKind[27] = (TK_select);
	  
	
        //
        // Rule 28:  KeyWord ::= r e j e c t
        //
		keywordKind[28] = (TK_reject);
	  
	
        //
        // Rule 29:  KeyWord ::= c o l l e c t N e s t e d
        //
		keywordKind[29] = (TK_collectNested);
	  
	
        //
        // Rule 30:  KeyWord ::= s o r t e d B y
        //
		keywordKind[30] = (TK_sortedBy);
	  
	
        //
        // Rule 31:  KeyWord ::= c l o s u r e
        //
		keywordKind[31] = (TK_closure);
	  
	
        //
        // Rule 32:  KeyWord ::= S t r i n g
        //
		keywordKind[32] = (TK_String);
	  
	
        //
        // Rule 33:  KeyWord ::= I n t e g e r
        //
		keywordKind[33] = (TK_Integer);
	  
	
        //
        // Rule 34:  KeyWord ::= U n l i m i t e d N a t u r a l
        //
		keywordKind[34] = (TK_UnlimitedNatural);
	  
	
        //
        // Rule 35:  KeyWord ::= R e a l
        //
		keywordKind[35] = (TK_Real);
	  
	
        //
        // Rule 36:  KeyWord ::= B o o l e a n
        //
		keywordKind[36] = (TK_Boolean);
	  
	
        //
        // Rule 37:  KeyWord ::= T u p l e
        //
		keywordKind[37] = (TK_Tuple);
	  
	
        //
        // Rule 38:  KeyWord ::= O c l A n y
        //
		keywordKind[38] = (TK_OclAny);
	  
	
        //
        // Rule 39:  KeyWord ::= O c l V o i d
        //
		keywordKind[39] = (TK_OclVoid);
	  
	
        //
        // Rule 40:  KeyWord ::= O c l I n v a l i d
        //
		keywordKind[40] = (TK_OclInvalid);
	  
	
        //
        // Rule 41:  KeyWord ::= n u l l
        //
		keywordKind[41] = (TK_null);
	  
	
        //
        // Rule 42:  KeyWord ::= i n v a l i d
        //
		keywordKind[42] = (TK_invalid);
	  
	
        //
        // Rule 43:  KeyWord ::= c h e c k o n l y
        //
		keywordKind[43] = (TK_checkonly);
	  
	
        //
        // Rule 44:  KeyWord ::= d e f a u l t _ v a l u e s
        //
		keywordKind[44] = (TK_default_values);
	  
	
        //
        // Rule 45:  KeyWord ::= d o m a i n
        //
		keywordKind[45] = (TK_domain);
	  
	
        //
        // Rule 46:  KeyWord ::= e n f o r c e
        //
		keywordKind[46] = (TK_enforce);
	  
	
        //
        // Rule 47:  KeyWord ::= e x t e n d s
        //
		keywordKind[47] = (TK_extends);
	  
	
        //
        // Rule 48:  KeyWord ::= i m p l e m e n t e d b y
        //
		keywordKind[48] = (TK_implementedby);
	  
	
        //
        // Rule 49:  KeyWord ::= i m p o r t
        //
		keywordKind[49] = (TK_import);
	  
	
        //
        // Rule 50:  KeyWord ::= k e y
        //
		keywordKind[50] = (TK_key);
	  
	
        //
        // Rule 51:  KeyWord ::= o v e r r i d e s
        //
		keywordKind[51] = (TK_overrides);
	  
	
        //
        // Rule 52:  KeyWord ::= p r i m i t i v e
        //
		keywordKind[52] = (TK_primitive);
	  
	
        //
        // Rule 53:  KeyWord ::= q u e r y
        //
		keywordKind[53] = (TK_query);
	  
	
        //
        // Rule 54:  KeyWord ::= r e l a t i o n
        //
		keywordKind[54] = (TK_relation);
	  
	
        //
        // Rule 55:  KeyWord ::= r e p l a c e
        //
		keywordKind[55] = (TK_replace);
	  
	
        //
        // Rule 56:  KeyWord ::= t o p
        //
		keywordKind[56] = (TK_top);
	  
	
        //
        // Rule 57:  KeyWord ::= t r a n s f o r m a t i o n
        //
		keywordKind[57] = (TK_transformation);
	  
	
        //
        // Rule 58:  KeyWord ::= w h e n
        //
		keywordKind[58] = (TK_when);
	  
	
        //
        // Rule 59:  KeyWord ::= w h e r e
        //
		keywordKind[59] = (TK_where);
	  
	

        for (int i = 0; i < keywordKind.length; i++)
        {
            if (keywordKind[i] == 0)
                keywordKind[i] = identifierKind;
        }
    }
}

