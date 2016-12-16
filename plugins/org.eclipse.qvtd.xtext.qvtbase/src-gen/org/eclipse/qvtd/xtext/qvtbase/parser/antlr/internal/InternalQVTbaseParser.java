package org.eclipse.qvtd.xtext.qvtbase.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.qvtd.xtext.qvtbase.services.QVTbaseGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
/*******************************************************************************
 * Copyright (c) 2011, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
@SuppressWarnings("all")
public class InternalQVTbaseParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_SINGLE_QUOTED_STRING", "RULE_UNQUOTED_STRING", "RULE_INT", "RULE_SIMPLE_ID", "RULE_ESCAPED_ID", "RULE_ESCAPED_CHARACTER", "RULE_LETTER_CHARACTER", "RULE_DOUBLE_QUOTED_STRING", "RULE_ML_SINGLE_QUOTED_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'static'", "'definition'", "'attribute'", "':'", "'='", "'{'", "'derived'", "'!derived'", "'id'", "'!id'", "'ordered'", "'!ordered'", "'readonly'", "'!readonly'", "'transient'", "'!transient'", "'unique'", "'!unique'", "'unsettable'", "'!unsettable'", "'volatile'", "'!volatile'", "','", "'}'", "'initial'", "';'", "'derivation'", "'primitive'", "'datatype'", "'serializable'", "'!serializable'", "'enum'", "'literal'", "'operation'", "'('", "')'", "'throws'", "'body'", "'property'", "'#'", "'composes'", "'!composes'", "'resolve'", "'!resolve'", "'abstract'", "'class'", "'extends'", "'interface'", "'-'", "'not'", "'*'", "'/'", "'+'", "'>'", "'<'", "'>='", "'<='", "'<>'", "'and'", "'or'", "'xor'", "'implies'", "'.'", "'->'", "'?.'", "'?->'", "'Map'", "'Tuple'", "'Boolean'", "'Integer'", "'Real'", "'String'", "'UnlimitedNatural'", "'OclAny'", "'OclInvalid'", "'OclVoid'", "'Set'", "'Bag'", "'Sequence'", "'Collection'", "'OrderedSet'", "'..'", "'++'", "'Lambda'", "'<-'", "'true'", "'false'", "'invalid'", "'null'", "'@'", "'pre'", "'['", "']'", "'in'", "'|'", "'if'", "'then'", "'else'", "'endif'", "'elseif'", "'let'", "'self'", "'|?'", "'|1'", "'?'", "'::'", "'&&'"
    };
    public static final int T__50=50;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_INT=6;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=13;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_SINGLE_QUOTED_STRING=4;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int RULE_DOUBLE_QUOTED_STRING=11;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int RULE_ESCAPED_ID=8;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__91=91;
    public static final int T__100=100;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__102=102;
    public static final int T__94=94;
    public static final int T__101=101;
    public static final int T__90=90;
    public static final int RULE_LETTER_CHARACTER=10;
    public static final int T__19=19;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__99=99;
    public static final int RULE_ESCAPED_CHARACTER=9;
    public static final int T__95=95;
    public static final int RULE_ML_SINGLE_QUOTED_STRING=12;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__122=122;
    public static final int T__70=70;
    public static final int T__121=121;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int T__123=123;
    public static final int T__120=120;
    public static final int RULE_UNQUOTED_STRING=5;
    public static final int RULE_SL_COMMENT=14;
    public static final int T__77=77;
    public static final int T__119=119;
    public static final int T__78=78;
    public static final int T__118=118;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int T__115=115;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__114=114;
    public static final int T__75=75;
    public static final int T__117=117;
    public static final int T__76=76;
    public static final int T__116=116;
    public static final int T__80=80;
    public static final int T__111=111;
    public static final int T__81=81;
    public static final int T__110=110;
    public static final int T__82=82;
    public static final int T__113=113;
    public static final int RULE_SIMPLE_ID=7;
    public static final int T__83=83;
    public static final int T__112=112;
    public static final int RULE_WS=15;
    public static final int RULE_ANY_OTHER=16;
    public static final int T__88=88;
    public static final int T__108=108;
    public static final int T__89=89;
    public static final int T__107=107;
    public static final int T__109=109;
    public static final int T__84=84;
    public static final int T__104=104;
    public static final int T__85=85;
    public static final int T__103=103;
    public static final int T__86=86;
    public static final int T__106=106;
    public static final int T__87=87;
    public static final int T__105=105;

    // delegates
    // delegators


        public InternalQVTbaseParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalQVTbaseParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);

        }


    public String[] getTokenNames() { return InternalQVTbaseParser.tokenNames; }
    public String getGrammarFileName() { return "InternalQVTbase.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */

     	private QVTbaseGrammarAccess grammarAccess;

        public InternalQVTbaseParser(TokenStream input, QVTbaseGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "AttributeCS";
       	}

       	@Override
       	protected QVTbaseGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleAttributeCS"
    // InternalQVTbase.g:80:1: entryRuleAttributeCS returns [EObject current=null] : iv_ruleAttributeCS= ruleAttributeCS EOF ;
    public final EObject entryRuleAttributeCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeCS = null;


        try {
            // InternalQVTbase.g:81:2: (iv_ruleAttributeCS= ruleAttributeCS EOF )
            // InternalQVTbase.g:82:2: iv_ruleAttributeCS= ruleAttributeCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAttributeCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAttributeCS=ruleAttributeCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAttributeCS;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAttributeCS"


    // $ANTLR start "ruleAttributeCS"
    // InternalQVTbase.g:89:1: ruleAttributeCS returns [EObject current=null] : ( ( ( ( (lv_qualifiers_0_0= 'static' ) ) ( (lv_qualifiers_1_0= 'definition' ) )? ) | ( ( (lv_qualifiers_2_0= 'definition' ) ) ( (lv_qualifiers_3_0= 'static' ) )? ) )? otherlv_4= 'attribute' ( (lv_name_5_0= ruleUnrestrictedName ) ) (otherlv_6= ':' ( (lv_ownedType_7_0= ruleTypedMultiplicityRefCS ) ) )? (otherlv_8= '=' ( (lv_default_9_0= RULE_SINGLE_QUOTED_STRING ) ) )? (otherlv_10= '{' ( ( ( (lv_qualifiers_11_0= 'derived' ) ) | ( (lv_qualifiers_12_0= '!derived' ) ) | ( (lv_qualifiers_13_0= 'id' ) ) | ( (lv_qualifiers_14_0= '!id' ) ) | ( (lv_qualifiers_15_0= 'ordered' ) ) | ( (lv_qualifiers_16_0= '!ordered' ) ) | ( (lv_qualifiers_17_0= 'readonly' ) ) | ( (lv_qualifiers_18_0= '!readonly' ) ) | ( (lv_qualifiers_19_0= 'transient' ) ) | ( (lv_qualifiers_20_0= '!transient' ) ) | ( (lv_qualifiers_21_0= 'unique' ) ) | ( (lv_qualifiers_22_0= '!unique' ) ) | ( (lv_qualifiers_23_0= 'unsettable' ) ) | ( (lv_qualifiers_24_0= '!unsettable' ) ) | ( (lv_qualifiers_25_0= 'volatile' ) ) | ( (lv_qualifiers_26_0= '!volatile' ) ) ) (otherlv_27= ',' )? )+ otherlv_28= '}' )? ( (otherlv_29= '{' ( (otherlv_30= 'initial' ( ruleUnrestrictedName )? otherlv_32= ':' ( (lv_ownedDefaultExpressions_33_0= ruleSpecificationCS ) )? otherlv_34= ';' ) | (otherlv_35= 'derivation' ( ruleUnrestrictedName )? otherlv_37= ':' ( (lv_ownedDefaultExpressions_38_0= ruleSpecificationCS ) )? otherlv_39= ';' ) )* otherlv_40= '}' ) | otherlv_41= ';' ) ) ;
    public final EObject ruleAttributeCS() throws RecognitionException {
        EObject current = null;

        Token lv_qualifiers_0_0=null;
        Token lv_qualifiers_1_0=null;
        Token lv_qualifiers_2_0=null;
        Token lv_qualifiers_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token lv_default_9_0=null;
        Token otherlv_10=null;
        Token lv_qualifiers_11_0=null;
        Token lv_qualifiers_12_0=null;
        Token lv_qualifiers_13_0=null;
        Token lv_qualifiers_14_0=null;
        Token lv_qualifiers_15_0=null;
        Token lv_qualifiers_16_0=null;
        Token lv_qualifiers_17_0=null;
        Token lv_qualifiers_18_0=null;
        Token lv_qualifiers_19_0=null;
        Token lv_qualifiers_20_0=null;
        Token lv_qualifiers_21_0=null;
        Token lv_qualifiers_22_0=null;
        Token lv_qualifiers_23_0=null;
        Token lv_qualifiers_24_0=null;
        Token lv_qualifiers_25_0=null;
        Token lv_qualifiers_26_0=null;
        Token otherlv_27=null;
        Token otherlv_28=null;
        Token otherlv_29=null;
        Token otherlv_30=null;
        Token otherlv_32=null;
        Token otherlv_34=null;
        Token otherlv_35=null;
        Token otherlv_37=null;
        Token otherlv_39=null;
        Token otherlv_40=null;
        Token otherlv_41=null;
        AntlrDatatypeRuleToken lv_name_5_0 = null;

        EObject lv_ownedType_7_0 = null;

        EObject lv_ownedDefaultExpressions_33_0 = null;

        EObject lv_ownedDefaultExpressions_38_0 = null;


         enterRule();

        try {
            // InternalQVTbase.g:92:28: ( ( ( ( ( (lv_qualifiers_0_0= 'static' ) ) ( (lv_qualifiers_1_0= 'definition' ) )? ) | ( ( (lv_qualifiers_2_0= 'definition' ) ) ( (lv_qualifiers_3_0= 'static' ) )? ) )? otherlv_4= 'attribute' ( (lv_name_5_0= ruleUnrestrictedName ) ) (otherlv_6= ':' ( (lv_ownedType_7_0= ruleTypedMultiplicityRefCS ) ) )? (otherlv_8= '=' ( (lv_default_9_0= RULE_SINGLE_QUOTED_STRING ) ) )? (otherlv_10= '{' ( ( ( (lv_qualifiers_11_0= 'derived' ) ) | ( (lv_qualifiers_12_0= '!derived' ) ) | ( (lv_qualifiers_13_0= 'id' ) ) | ( (lv_qualifiers_14_0= '!id' ) ) | ( (lv_qualifiers_15_0= 'ordered' ) ) | ( (lv_qualifiers_16_0= '!ordered' ) ) | ( (lv_qualifiers_17_0= 'readonly' ) ) | ( (lv_qualifiers_18_0= '!readonly' ) ) | ( (lv_qualifiers_19_0= 'transient' ) ) | ( (lv_qualifiers_20_0= '!transient' ) ) | ( (lv_qualifiers_21_0= 'unique' ) ) | ( (lv_qualifiers_22_0= '!unique' ) ) | ( (lv_qualifiers_23_0= 'unsettable' ) ) | ( (lv_qualifiers_24_0= '!unsettable' ) ) | ( (lv_qualifiers_25_0= 'volatile' ) ) | ( (lv_qualifiers_26_0= '!volatile' ) ) ) (otherlv_27= ',' )? )+ otherlv_28= '}' )? ( (otherlv_29= '{' ( (otherlv_30= 'initial' ( ruleUnrestrictedName )? otherlv_32= ':' ( (lv_ownedDefaultExpressions_33_0= ruleSpecificationCS ) )? otherlv_34= ';' ) | (otherlv_35= 'derivation' ( ruleUnrestrictedName )? otherlv_37= ':' ( (lv_ownedDefaultExpressions_38_0= ruleSpecificationCS ) )? otherlv_39= ';' ) )* otherlv_40= '}' ) | otherlv_41= ';' ) ) )
            // InternalQVTbase.g:93:1: ( ( ( ( (lv_qualifiers_0_0= 'static' ) ) ( (lv_qualifiers_1_0= 'definition' ) )? ) | ( ( (lv_qualifiers_2_0= 'definition' ) ) ( (lv_qualifiers_3_0= 'static' ) )? ) )? otherlv_4= 'attribute' ( (lv_name_5_0= ruleUnrestrictedName ) ) (otherlv_6= ':' ( (lv_ownedType_7_0= ruleTypedMultiplicityRefCS ) ) )? (otherlv_8= '=' ( (lv_default_9_0= RULE_SINGLE_QUOTED_STRING ) ) )? (otherlv_10= '{' ( ( ( (lv_qualifiers_11_0= 'derived' ) ) | ( (lv_qualifiers_12_0= '!derived' ) ) | ( (lv_qualifiers_13_0= 'id' ) ) | ( (lv_qualifiers_14_0= '!id' ) ) | ( (lv_qualifiers_15_0= 'ordered' ) ) | ( (lv_qualifiers_16_0= '!ordered' ) ) | ( (lv_qualifiers_17_0= 'readonly' ) ) | ( (lv_qualifiers_18_0= '!readonly' ) ) | ( (lv_qualifiers_19_0= 'transient' ) ) | ( (lv_qualifiers_20_0= '!transient' ) ) | ( (lv_qualifiers_21_0= 'unique' ) ) | ( (lv_qualifiers_22_0= '!unique' ) ) | ( (lv_qualifiers_23_0= 'unsettable' ) ) | ( (lv_qualifiers_24_0= '!unsettable' ) ) | ( (lv_qualifiers_25_0= 'volatile' ) ) | ( (lv_qualifiers_26_0= '!volatile' ) ) ) (otherlv_27= ',' )? )+ otherlv_28= '}' )? ( (otherlv_29= '{' ( (otherlv_30= 'initial' ( ruleUnrestrictedName )? otherlv_32= ':' ( (lv_ownedDefaultExpressions_33_0= ruleSpecificationCS ) )? otherlv_34= ';' ) | (otherlv_35= 'derivation' ( ruleUnrestrictedName )? otherlv_37= ':' ( (lv_ownedDefaultExpressions_38_0= ruleSpecificationCS ) )? otherlv_39= ';' ) )* otherlv_40= '}' ) | otherlv_41= ';' ) )
            {
            // InternalQVTbase.g:93:1: ( ( ( ( (lv_qualifiers_0_0= 'static' ) ) ( (lv_qualifiers_1_0= 'definition' ) )? ) | ( ( (lv_qualifiers_2_0= 'definition' ) ) ( (lv_qualifiers_3_0= 'static' ) )? ) )? otherlv_4= 'attribute' ( (lv_name_5_0= ruleUnrestrictedName ) ) (otherlv_6= ':' ( (lv_ownedType_7_0= ruleTypedMultiplicityRefCS ) ) )? (otherlv_8= '=' ( (lv_default_9_0= RULE_SINGLE_QUOTED_STRING ) ) )? (otherlv_10= '{' ( ( ( (lv_qualifiers_11_0= 'derived' ) ) | ( (lv_qualifiers_12_0= '!derived' ) ) | ( (lv_qualifiers_13_0= 'id' ) ) | ( (lv_qualifiers_14_0= '!id' ) ) | ( (lv_qualifiers_15_0= 'ordered' ) ) | ( (lv_qualifiers_16_0= '!ordered' ) ) | ( (lv_qualifiers_17_0= 'readonly' ) ) | ( (lv_qualifiers_18_0= '!readonly' ) ) | ( (lv_qualifiers_19_0= 'transient' ) ) | ( (lv_qualifiers_20_0= '!transient' ) ) | ( (lv_qualifiers_21_0= 'unique' ) ) | ( (lv_qualifiers_22_0= '!unique' ) ) | ( (lv_qualifiers_23_0= 'unsettable' ) ) | ( (lv_qualifiers_24_0= '!unsettable' ) ) | ( (lv_qualifiers_25_0= 'volatile' ) ) | ( (lv_qualifiers_26_0= '!volatile' ) ) ) (otherlv_27= ',' )? )+ otherlv_28= '}' )? ( (otherlv_29= '{' ( (otherlv_30= 'initial' ( ruleUnrestrictedName )? otherlv_32= ':' ( (lv_ownedDefaultExpressions_33_0= ruleSpecificationCS ) )? otherlv_34= ';' ) | (otherlv_35= 'derivation' ( ruleUnrestrictedName )? otherlv_37= ':' ( (lv_ownedDefaultExpressions_38_0= ruleSpecificationCS ) )? otherlv_39= ';' ) )* otherlv_40= '}' ) | otherlv_41= ';' ) )
            // InternalQVTbase.g:93:2: ( ( ( (lv_qualifiers_0_0= 'static' ) ) ( (lv_qualifiers_1_0= 'definition' ) )? ) | ( ( (lv_qualifiers_2_0= 'definition' ) ) ( (lv_qualifiers_3_0= 'static' ) )? ) )? otherlv_4= 'attribute' ( (lv_name_5_0= ruleUnrestrictedName ) ) (otherlv_6= ':' ( (lv_ownedType_7_0= ruleTypedMultiplicityRefCS ) ) )? (otherlv_8= '=' ( (lv_default_9_0= RULE_SINGLE_QUOTED_STRING ) ) )? (otherlv_10= '{' ( ( ( (lv_qualifiers_11_0= 'derived' ) ) | ( (lv_qualifiers_12_0= '!derived' ) ) | ( (lv_qualifiers_13_0= 'id' ) ) | ( (lv_qualifiers_14_0= '!id' ) ) | ( (lv_qualifiers_15_0= 'ordered' ) ) | ( (lv_qualifiers_16_0= '!ordered' ) ) | ( (lv_qualifiers_17_0= 'readonly' ) ) | ( (lv_qualifiers_18_0= '!readonly' ) ) | ( (lv_qualifiers_19_0= 'transient' ) ) | ( (lv_qualifiers_20_0= '!transient' ) ) | ( (lv_qualifiers_21_0= 'unique' ) ) | ( (lv_qualifiers_22_0= '!unique' ) ) | ( (lv_qualifiers_23_0= 'unsettable' ) ) | ( (lv_qualifiers_24_0= '!unsettable' ) ) | ( (lv_qualifiers_25_0= 'volatile' ) ) | ( (lv_qualifiers_26_0= '!volatile' ) ) ) (otherlv_27= ',' )? )+ otherlv_28= '}' )? ( (otherlv_29= '{' ( (otherlv_30= 'initial' ( ruleUnrestrictedName )? otherlv_32= ':' ( (lv_ownedDefaultExpressions_33_0= ruleSpecificationCS ) )? otherlv_34= ';' ) | (otherlv_35= 'derivation' ( ruleUnrestrictedName )? otherlv_37= ':' ( (lv_ownedDefaultExpressions_38_0= ruleSpecificationCS ) )? otherlv_39= ';' ) )* otherlv_40= '}' ) | otherlv_41= ';' )
            {
            // InternalQVTbase.g:93:2: ( ( ( (lv_qualifiers_0_0= 'static' ) ) ( (lv_qualifiers_1_0= 'definition' ) )? ) | ( ( (lv_qualifiers_2_0= 'definition' ) ) ( (lv_qualifiers_3_0= 'static' ) )? ) )?
            int alt3=3;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==17) ) {
                alt3=1;
            }
            else if ( (LA3_0==18) ) {
                alt3=2;
            }
            switch (alt3) {
                case 1 :
                    // InternalQVTbase.g:93:3: ( ( (lv_qualifiers_0_0= 'static' ) ) ( (lv_qualifiers_1_0= 'definition' ) )? )
                    {
                    // InternalQVTbase.g:93:3: ( ( (lv_qualifiers_0_0= 'static' ) ) ( (lv_qualifiers_1_0= 'definition' ) )? )
                    // InternalQVTbase.g:93:4: ( (lv_qualifiers_0_0= 'static' ) ) ( (lv_qualifiers_1_0= 'definition' ) )?
                    {
                    // InternalQVTbase.g:93:4: ( (lv_qualifiers_0_0= 'static' ) )
                    // InternalQVTbase.g:94:1: (lv_qualifiers_0_0= 'static' )
                    {
                    // InternalQVTbase.g:94:1: (lv_qualifiers_0_0= 'static' )
                    // InternalQVTbase.g:95:3: lv_qualifiers_0_0= 'static'
                    {
                    lv_qualifiers_0_0=(Token)match(input,17,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_qualifiers_0_0, grammarAccess.getAttributeCSAccess().getQualifiersStaticKeyword_0_0_0_0());

                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getAttributeCSRule());
                      	        }
                             		addWithLastConsumed(current, "qualifiers", lv_qualifiers_0_0, "static");

                    }

                    }


                    }

                    // InternalQVTbase.g:108:2: ( (lv_qualifiers_1_0= 'definition' ) )?
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==18) ) {
                        alt1=1;
                    }
                    switch (alt1) {
                        case 1 :
                            // InternalQVTbase.g:109:1: (lv_qualifiers_1_0= 'definition' )
                            {
                            // InternalQVTbase.g:109:1: (lv_qualifiers_1_0= 'definition' )
                            // InternalQVTbase.g:110:3: lv_qualifiers_1_0= 'definition'
                            {
                            lv_qualifiers_1_0=(Token)match(input,18,FollowSets000.FOLLOW_4); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_qualifiers_1_0, grammarAccess.getAttributeCSAccess().getQualifiersDefinitionKeyword_0_0_1_0());

                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getAttributeCSRule());
                              	        }
                                     		addWithLastConsumed(current, "qualifiers", lv_qualifiers_1_0, "definition");

                            }

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalQVTbase.g:124:6: ( ( (lv_qualifiers_2_0= 'definition' ) ) ( (lv_qualifiers_3_0= 'static' ) )? )
                    {
                    // InternalQVTbase.g:124:6: ( ( (lv_qualifiers_2_0= 'definition' ) ) ( (lv_qualifiers_3_0= 'static' ) )? )
                    // InternalQVTbase.g:124:7: ( (lv_qualifiers_2_0= 'definition' ) ) ( (lv_qualifiers_3_0= 'static' ) )?
                    {
                    // InternalQVTbase.g:124:7: ( (lv_qualifiers_2_0= 'definition' ) )
                    // InternalQVTbase.g:125:1: (lv_qualifiers_2_0= 'definition' )
                    {
                    // InternalQVTbase.g:125:1: (lv_qualifiers_2_0= 'definition' )
                    // InternalQVTbase.g:126:3: lv_qualifiers_2_0= 'definition'
                    {
                    lv_qualifiers_2_0=(Token)match(input,18,FollowSets000.FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_qualifiers_2_0, grammarAccess.getAttributeCSAccess().getQualifiersDefinitionKeyword_0_1_0_0());

                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getAttributeCSRule());
                      	        }
                             		addWithLastConsumed(current, "qualifiers", lv_qualifiers_2_0, "definition");

                    }

                    }


                    }

                    // InternalQVTbase.g:139:2: ( (lv_qualifiers_3_0= 'static' ) )?
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==17) ) {
                        alt2=1;
                    }
                    switch (alt2) {
                        case 1 :
                            // InternalQVTbase.g:140:1: (lv_qualifiers_3_0= 'static' )
                            {
                            // InternalQVTbase.g:140:1: (lv_qualifiers_3_0= 'static' )
                            // InternalQVTbase.g:141:3: lv_qualifiers_3_0= 'static'
                            {
                            lv_qualifiers_3_0=(Token)match(input,17,FollowSets000.FOLLOW_4); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_qualifiers_3_0, grammarAccess.getAttributeCSAccess().getQualifiersStaticKeyword_0_1_1_0());

                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getAttributeCSRule());
                              	        }
                                     		addWithLastConsumed(current, "qualifiers", lv_qualifiers_3_0, "static");

                            }

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,19,FollowSets000.FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getAttributeCSAccess().getAttributeKeyword_1());

            }
            // InternalQVTbase.g:158:1: ( (lv_name_5_0= ruleUnrestrictedName ) )
            // InternalQVTbase.g:159:1: (lv_name_5_0= ruleUnrestrictedName )
            {
            // InternalQVTbase.g:159:1: (lv_name_5_0= ruleUnrestrictedName )
            // InternalQVTbase.g:160:3: lv_name_5_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {

              	        newCompositeNode(grammarAccess.getAttributeCSAccess().getNameUnrestrictedNameParserRuleCall_2_0());

            }
            pushFollow(FollowSets000.FOLLOW_7);
            lv_name_5_0=ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getAttributeCSRule());
              	        }
                     		set(
                     			current,
                     			"name",
                      		lv_name_5_0,
                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.UnrestrictedName");
              	        afterParserOrEnumRuleCall();

            }

            }


            }

            // InternalQVTbase.g:176:2: (otherlv_6= ':' ( (lv_ownedType_7_0= ruleTypedMultiplicityRefCS ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==20) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalQVTbase.g:176:4: otherlv_6= ':' ( (lv_ownedType_7_0= ruleTypedMultiplicityRefCS ) )
                    {
                    otherlv_6=(Token)match(input,20,FollowSets000.FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getAttributeCSAccess().getColonKeyword_3_0());

                    }
                    // InternalQVTbase.g:180:1: ( (lv_ownedType_7_0= ruleTypedMultiplicityRefCS ) )
                    // InternalQVTbase.g:181:1: (lv_ownedType_7_0= ruleTypedMultiplicityRefCS )
                    {
                    // InternalQVTbase.g:181:1: (lv_ownedType_7_0= ruleTypedMultiplicityRefCS )
                    // InternalQVTbase.g:182:3: lv_ownedType_7_0= ruleTypedMultiplicityRefCS
                    {
                    if ( state.backtracking==0 ) {

                      	        newCompositeNode(grammarAccess.getAttributeCSAccess().getOwnedTypeTypedMultiplicityRefCSParserRuleCall_3_1_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_8);
                    lv_ownedType_7_0=ruleTypedMultiplicityRefCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAttributeCSRule());
                      	        }
                             		set(
                             			current,
                             			"ownedType",
                              		lv_ownedType_7_0,
                              		"org.eclipse.qvtd.xtext.qvtbase.QVTbase.TypedMultiplicityRefCS");
                      	        afterParserOrEnumRuleCall();

                    }

                    }


                    }


                    }
                    break;

            }

            // InternalQVTbase.g:198:4: (otherlv_8= '=' ( (lv_default_9_0= RULE_SINGLE_QUOTED_STRING ) ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==21) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalQVTbase.g:198:6: otherlv_8= '=' ( (lv_default_9_0= RULE_SINGLE_QUOTED_STRING ) )
                    {
                    otherlv_8=(Token)match(input,21,FollowSets000.FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getAttributeCSAccess().getEqualsSignKeyword_4_0());

                    }
                    // InternalQVTbase.g:202:1: ( (lv_default_9_0= RULE_SINGLE_QUOTED_STRING ) )
                    // InternalQVTbase.g:203:1: (lv_default_9_0= RULE_SINGLE_QUOTED_STRING )
                    {
                    // InternalQVTbase.g:203:1: (lv_default_9_0= RULE_SINGLE_QUOTED_STRING )
                    // InternalQVTbase.g:204:3: lv_default_9_0= RULE_SINGLE_QUOTED_STRING
                    {
                    lv_default_9_0=(Token)match(input,RULE_SINGLE_QUOTED_STRING,FollowSets000.FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_default_9_0, grammarAccess.getAttributeCSAccess().getDefaultSINGLE_QUOTED_STRINGTerminalRuleCall_4_1_0());

                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getAttributeCSRule());
                      	        }
                             		setWithLastConsumed(
                             			current,
                             			"default",
                              		lv_default_9_0,
                              		"org.eclipse.ocl.xtext.base.Base.SINGLE_QUOTED_STRING");

                    }

                    }


                    }


                    }
                    break;

            }

            // InternalQVTbase.g:220:4: (otherlv_10= '{' ( ( ( (lv_qualifiers_11_0= 'derived' ) ) | ( (lv_qualifiers_12_0= '!derived' ) ) | ( (lv_qualifiers_13_0= 'id' ) ) | ( (lv_qualifiers_14_0= '!id' ) ) | ( (lv_qualifiers_15_0= 'ordered' ) ) | ( (lv_qualifiers_16_0= '!ordered' ) ) | ( (lv_qualifiers_17_0= 'readonly' ) ) | ( (lv_qualifiers_18_0= '!readonly' ) ) | ( (lv_qualifiers_19_0= 'transient' ) ) | ( (lv_qualifiers_20_0= '!transient' ) ) | ( (lv_qualifiers_21_0= 'unique' ) ) | ( (lv_qualifiers_22_0= '!unique' ) ) | ( (lv_qualifiers_23_0= 'unsettable' ) ) | ( (lv_qualifiers_24_0= '!unsettable' ) ) | ( (lv_qualifiers_25_0= 'volatile' ) ) | ( (lv_qualifiers_26_0= '!volatile' ) ) ) (otherlv_27= ',' )? )+ otherlv_28= '}' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==22) ) {
                int LA9_1 = input.LA(2);

                if ( ((LA9_1>=23 && LA9_1<=38)) ) {
                    alt9=1;
                }
            }
            switch (alt9) {
                case 1 :
                    // InternalQVTbase.g:220:6: otherlv_10= '{' ( ( ( (lv_qualifiers_11_0= 'derived' ) ) | ( (lv_qualifiers_12_0= '!derived' ) ) | ( (lv_qualifiers_13_0= 'id' ) ) | ( (lv_qualifiers_14_0= '!id' ) ) | ( (lv_qualifiers_15_0= 'ordered' ) ) | ( (lv_qualifiers_16_0= '!ordered' ) ) | ( (lv_qualifiers_17_0= 'readonly' ) ) | ( (lv_qualifiers_18_0= '!readonly' ) ) | ( (lv_qualifiers_19_0= 'transient' ) ) | ( (lv_qualifiers_20_0= '!transient' ) ) | ( (lv_qualifiers_21_0= 'unique' ) ) | ( (lv_qualifiers_22_0= '!unique' ) ) | ( (lv_qualifiers_23_0= 'unsettable' ) ) | ( (lv_qualifiers_24_0= '!unsettable' ) ) | ( (lv_qualifiers_25_0= 'volatile' ) ) | ( (lv_qualifiers_26_0= '!volatile' ) ) ) (otherlv_27= ',' )? )+ otherlv_28= '}'
                    {
                    otherlv_10=(Token)match(input,22,FollowSets000.FOLLOW_11); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getAttributeCSAccess().getLeftCurlyBracketKeyword_5_0());

                    }
                    // InternalQVTbase.g:224:1: ( ( ( (lv_qualifiers_11_0= 'derived' ) ) | ( (lv_qualifiers_12_0= '!derived' ) ) | ( (lv_qualifiers_13_0= 'id' ) ) | ( (lv_qualifiers_14_0= '!id' ) ) | ( (lv_qualifiers_15_0= 'ordered' ) ) | ( (lv_qualifiers_16_0= '!ordered' ) ) | ( (lv_qualifiers_17_0= 'readonly' ) ) | ( (lv_qualifiers_18_0= '!readonly' ) ) | ( (lv_qualifiers_19_0= 'transient' ) ) | ( (lv_qualifiers_20_0= '!transient' ) ) | ( (lv_qualifiers_21_0= 'unique' ) ) | ( (lv_qualifiers_22_0= '!unique' ) ) | ( (lv_qualifiers_23_0= 'unsettable' ) ) | ( (lv_qualifiers_24_0= '!unsettable' ) ) | ( (lv_qualifiers_25_0= 'volatile' ) ) | ( (lv_qualifiers_26_0= '!volatile' ) ) ) (otherlv_27= ',' )? )+
                    int cnt8=0;
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( ((LA8_0>=23 && LA8_0<=38)) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // InternalQVTbase.g:224:2: ( ( (lv_qualifiers_11_0= 'derived' ) ) | ( (lv_qualifiers_12_0= '!derived' ) ) | ( (lv_qualifiers_13_0= 'id' ) ) | ( (lv_qualifiers_14_0= '!id' ) ) | ( (lv_qualifiers_15_0= 'ordered' ) ) | ( (lv_qualifiers_16_0= '!ordered' ) ) | ( (lv_qualifiers_17_0= 'readonly' ) ) | ( (lv_qualifiers_18_0= '!readonly' ) ) | ( (lv_qualifiers_19_0= 'transient' ) ) | ( (lv_qualifiers_20_0= '!transient' ) ) | ( (lv_qualifiers_21_0= 'unique' ) ) | ( (lv_qualifiers_22_0= '!unique' ) ) | ( (lv_qualifiers_23_0= 'unsettable' ) ) | ( (lv_qualifiers_24_0= '!unsettable' ) ) | ( (lv_qualifiers_25_0= 'volatile' ) ) | ( (lv_qualifiers_26_0= '!volatile' ) ) ) (otherlv_27= ',' )?
                    	    {
                    	    // InternalQVTbase.g:224:2: ( ( (lv_qualifiers_11_0= 'derived' ) ) | ( (lv_qualifiers_12_0= '!derived' ) ) | ( (lv_qualifiers_13_0= 'id' ) ) | ( (lv_qualifiers_14_0= '!id' ) ) | ( (lv_qualifiers_15_0= 'ordered' ) ) | ( (lv_qualifiers_16_0= '!ordered' ) ) | ( (lv_qualifiers_17_0= 'readonly' ) ) | ( (lv_qualifiers_18_0= '!readonly' ) ) | ( (lv_qualifiers_19_0= 'transient' ) ) | ( (lv_qualifiers_20_0= '!transient' ) ) | ( (lv_qualifiers_21_0= 'unique' ) ) | ( (lv_qualifiers_22_0= '!unique' ) ) | ( (lv_qualifiers_23_0= 'unsettable' ) ) | ( (lv_qualifiers_24_0= '!unsettable' ) ) | ( (lv_qualifiers_25_0= 'volatile' ) ) | ( (lv_qualifiers_26_0= '!volatile' ) ) )
                    	    int alt6=16;
                    	    switch ( input.LA(1) ) {
                    	    case 23:
                    	        {
                    	        alt6=1;
                    	        }
                    	        break;
                    	    case 24:
                    	        {
                    	        alt6=2;
                    	        }
                    	        break;
                    	    case 25:
                    	        {
                    	        alt6=3;
                    	        }
                    	        break;
                    	    case 26:
                    	        {
                    	        alt6=4;
                    	        }
                    	        break;
                    	    case 27:
                    	        {
                    	        alt6=5;
                    	        }
                    	        break;
                    	    case 28:
                    	        {
                    	        alt6=6;
                    	        }
                    	        break;
                    	    case 29:
                    	        {
                    	        alt6=7;
                    	        }
                    	        break;
                    	    case 30:
                    	        {
                    	        alt6=8;
                    	        }
                    	        break;
                    	    case 31:
                    	        {
                    	        alt6=9;
                    	        }
                    	        break;
                    	    case 32:
                    	        {
                    	        alt6=10;
                    	        }
                    	        break;
                    	    case 33:
                    	        {
                    	        alt6=11;
                    	        }
                    	        break;
                    	    case 34:
                    	        {
                    	        alt6=12;
                    	        }
                    	        break;
                    	    case 35:
                    	        {
                    	        alt6=13;
                    	        }
                    	        break;
                    	    case 36:
                    	        {
                    	        alt6=14;
                    	        }
                    	        break;
                    	    case 37:
                    	        {
                    	        alt6=15;
                    	        }
                    	        break;
                    	    case 38:
                    	        {
                    	        alt6=16;
                    	        }
                    	        break;
                    	    default:
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 6, 0, input);

                    	        throw nvae;
                    	    }

                    	    switch (alt6) {
                    	        case 1 :
                    	            // InternalQVTbase.g:224:3: ( (lv_qualifiers_11_0= 'derived' ) )
                    	            {
                    	            // InternalQVTbase.g:224:3: ( (lv_qualifiers_11_0= 'derived' ) )
                    	            // InternalQVTbase.g:225:1: (lv_qualifiers_11_0= 'derived' )
                    	            {
                    	            // InternalQVTbase.g:225:1: (lv_qualifiers_11_0= 'derived' )
                    	            // InternalQVTbase.g:226:3: lv_qualifiers_11_0= 'derived'
                    	            {
                    	            lv_qualifiers_11_0=(Token)match(input,23,FollowSets000.FOLLOW_12); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	                      newLeafNode(lv_qualifiers_11_0, grammarAccess.getAttributeCSAccess().getQualifiersDerivedKeyword_5_1_0_0_0());

                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElement(grammarAccess.getAttributeCSRule());
                    	              	        }
                    	                     		addWithLastConsumed(current, "qualifiers", lv_qualifiers_11_0, "derived");

                    	            }

                    	            }


                    	            }


                    	            }
                    	            break;
                    	        case 2 :
                    	            // InternalQVTbase.g:240:6: ( (lv_qualifiers_12_0= '!derived' ) )
                    	            {
                    	            // InternalQVTbase.g:240:6: ( (lv_qualifiers_12_0= '!derived' ) )
                    	            // InternalQVTbase.g:241:1: (lv_qualifiers_12_0= '!derived' )
                    	            {
                    	            // InternalQVTbase.g:241:1: (lv_qualifiers_12_0= '!derived' )
                    	            // InternalQVTbase.g:242:3: lv_qualifiers_12_0= '!derived'
                    	            {
                    	            lv_qualifiers_12_0=(Token)match(input,24,FollowSets000.FOLLOW_12); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	                      newLeafNode(lv_qualifiers_12_0, grammarAccess.getAttributeCSAccess().getQualifiersDerivedKeyword_5_1_0_1_0());

                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElement(grammarAccess.getAttributeCSRule());
                    	              	        }
                    	                     		addWithLastConsumed(current, "qualifiers", lv_qualifiers_12_0, "!derived");

                    	            }

                    	            }


                    	            }


                    	            }
                    	            break;
                    	        case 3 :
                    	            // InternalQVTbase.g:256:6: ( (lv_qualifiers_13_0= 'id' ) )
                    	            {
                    	            // InternalQVTbase.g:256:6: ( (lv_qualifiers_13_0= 'id' ) )
                    	            // InternalQVTbase.g:257:1: (lv_qualifiers_13_0= 'id' )
                    	            {
                    	            // InternalQVTbase.g:257:1: (lv_qualifiers_13_0= 'id' )
                    	            // InternalQVTbase.g:258:3: lv_qualifiers_13_0= 'id'
                    	            {
                    	            lv_qualifiers_13_0=(Token)match(input,25,FollowSets000.FOLLOW_12); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	                      newLeafNode(lv_qualifiers_13_0, grammarAccess.getAttributeCSAccess().getQualifiersIdKeyword_5_1_0_2_0());

                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElement(grammarAccess.getAttributeCSRule());
                    	              	        }
                    	                     		addWithLastConsumed(current, "qualifiers", lv_qualifiers_13_0, "id");

                    	            }

                    	            }


                    	            }


                    	            }
                    	            break;
                    	        case 4 :
                    	            // InternalQVTbase.g:272:6: ( (lv_qualifiers_14_0= '!id' ) )
                    	            {
                    	            // InternalQVTbase.g:272:6: ( (lv_qualifiers_14_0= '!id' ) )
                    	            // InternalQVTbase.g:273:1: (lv_qualifiers_14_0= '!id' )
                    	            {
                    	            // InternalQVTbase.g:273:1: (lv_qualifiers_14_0= '!id' )
                    	            // InternalQVTbase.g:274:3: lv_qualifiers_14_0= '!id'
                    	            {
                    	            lv_qualifiers_14_0=(Token)match(input,26,FollowSets000.FOLLOW_12); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	                      newLeafNode(lv_qualifiers_14_0, grammarAccess.getAttributeCSAccess().getQualifiersIdKeyword_5_1_0_3_0());

                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElement(grammarAccess.getAttributeCSRule());
                    	              	        }
                    	                     		addWithLastConsumed(current, "qualifiers", lv_qualifiers_14_0, "!id");

                    	            }

                    	            }


                    	            }


                    	            }
                    	            break;
                    	        case 5 :
                    	            // InternalQVTbase.g:288:6: ( (lv_qualifiers_15_0= 'ordered' ) )
                    	            {
                    	            // InternalQVTbase.g:288:6: ( (lv_qualifiers_15_0= 'ordered' ) )
                    	            // InternalQVTbase.g:289:1: (lv_qualifiers_15_0= 'ordered' )
                    	            {
                    	            // InternalQVTbase.g:289:1: (lv_qualifiers_15_0= 'ordered' )
                    	            // InternalQVTbase.g:290:3: lv_qualifiers_15_0= 'ordered'
                    	            {
                    	            lv_qualifiers_15_0=(Token)match(input,27,FollowSets000.FOLLOW_12); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	                      newLeafNode(lv_qualifiers_15_0, grammarAccess.getAttributeCSAccess().getQualifiersOrderedKeyword_5_1_0_4_0());

                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElement(grammarAccess.getAttributeCSRule());
                    	              	        }
                    	                     		addWithLastConsumed(current, "qualifiers", lv_qualifiers_15_0, "ordered");

                    	            }

                    	            }


                    	            }


                    	            }
                    	            break;
                    	        case 6 :
                    	            // InternalQVTbase.g:304:6: ( (lv_qualifiers_16_0= '!ordered' ) )
                    	            {
                    	            // InternalQVTbase.g:304:6: ( (lv_qualifiers_16_0= '!ordered' ) )
                    	            // InternalQVTbase.g:305:1: (lv_qualifiers_16_0= '!ordered' )
                    	            {
                    	            // InternalQVTbase.g:305:1: (lv_qualifiers_16_0= '!ordered' )
                    	            // InternalQVTbase.g:306:3: lv_qualifiers_16_0= '!ordered'
                    	            {
                    	            lv_qualifiers_16_0=(Token)match(input,28,FollowSets000.FOLLOW_12); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	                      newLeafNode(lv_qualifiers_16_0, grammarAccess.getAttributeCSAccess().getQualifiersOrderedKeyword_5_1_0_5_0());

                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElement(grammarAccess.getAttributeCSRule());
                    	              	        }
                    	                     		addWithLastConsumed(current, "qualifiers", lv_qualifiers_16_0, "!ordered");

                    	            }

                    	            }


                    	            }


                    	            }
                    	            break;
                    	        case 7 :
                    	            // InternalQVTbase.g:320:6: ( (lv_qualifiers_17_0= 'readonly' ) )
                    	            {
                    	            // InternalQVTbase.g:320:6: ( (lv_qualifiers_17_0= 'readonly' ) )
                    	            // InternalQVTbase.g:321:1: (lv_qualifiers_17_0= 'readonly' )
                    	            {
                    	            // InternalQVTbase.g:321:1: (lv_qualifiers_17_0= 'readonly' )
                    	            // InternalQVTbase.g:322:3: lv_qualifiers_17_0= 'readonly'
                    	            {
                    	            lv_qualifiers_17_0=(Token)match(input,29,FollowSets000.FOLLOW_12); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	                      newLeafNode(lv_qualifiers_17_0, grammarAccess.getAttributeCSAccess().getQualifiersReadonlyKeyword_5_1_0_6_0());

                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElement(grammarAccess.getAttributeCSRule());
                    	              	        }
                    	                     		addWithLastConsumed(current, "qualifiers", lv_qualifiers_17_0, "readonly");

                    	            }

                    	            }


                    	            }


                    	            }
                    	            break;
                    	        case 8 :
                    	            // InternalQVTbase.g:336:6: ( (lv_qualifiers_18_0= '!readonly' ) )
                    	            {
                    	            // InternalQVTbase.g:336:6: ( (lv_qualifiers_18_0= '!readonly' ) )
                    	            // InternalQVTbase.g:337:1: (lv_qualifiers_18_0= '!readonly' )
                    	            {
                    	            // InternalQVTbase.g:337:1: (lv_qualifiers_18_0= '!readonly' )
                    	            // InternalQVTbase.g:338:3: lv_qualifiers_18_0= '!readonly'
                    	            {
                    	            lv_qualifiers_18_0=(Token)match(input,30,FollowSets000.FOLLOW_12); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	                      newLeafNode(lv_qualifiers_18_0, grammarAccess.getAttributeCSAccess().getQualifiersReadonlyKeyword_5_1_0_7_0());

                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElement(grammarAccess.getAttributeCSRule());
                    	              	        }
                    	                     		addWithLastConsumed(current, "qualifiers", lv_qualifiers_18_0, "!readonly");

                    	            }

                    	            }


                    	            }


                    	            }
                    	            break;
                    	        case 9 :
                    	            // InternalQVTbase.g:352:6: ( (lv_qualifiers_19_0= 'transient' ) )
                    	            {
                    	            // InternalQVTbase.g:352:6: ( (lv_qualifiers_19_0= 'transient' ) )
                    	            // InternalQVTbase.g:353:1: (lv_qualifiers_19_0= 'transient' )
                    	            {
                    	            // InternalQVTbase.g:353:1: (lv_qualifiers_19_0= 'transient' )
                    	            // InternalQVTbase.g:354:3: lv_qualifiers_19_0= 'transient'
                    	            {
                    	            lv_qualifiers_19_0=(Token)match(input,31,FollowSets000.FOLLOW_12); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	                      newLeafNode(lv_qualifiers_19_0, grammarAccess.getAttributeCSAccess().getQualifiersTransientKeyword_5_1_0_8_0());

                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElement(grammarAccess.getAttributeCSRule());
                    	              	        }
                    	                     		addWithLastConsumed(current, "qualifiers", lv_qualifiers_19_0, "transient");

                    	            }

                    	            }


                    	            }


                    	            }
                    	            break;
                    	        case 10 :
                    	            // InternalQVTbase.g:368:6: ( (lv_qualifiers_20_0= '!transient' ) )
                    	            {
                    	            // InternalQVTbase.g:368:6: ( (lv_qualifiers_20_0= '!transient' ) )
                    	            // InternalQVTbase.g:369:1: (lv_qualifiers_20_0= '!transient' )
                    	            {
                    	            // InternalQVTbase.g:369:1: (lv_qualifiers_20_0= '!transient' )
                    	            // InternalQVTbase.g:370:3: lv_qualifiers_20_0= '!transient'
                    	            {
                    	            lv_qualifiers_20_0=(Token)match(input,32,FollowSets000.FOLLOW_12); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	                      newLeafNode(lv_qualifiers_20_0, grammarAccess.getAttributeCSAccess().getQualifiersTransientKeyword_5_1_0_9_0());

                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElement(grammarAccess.getAttributeCSRule());
                    	              	        }
                    	                     		addWithLastConsumed(current, "qualifiers", lv_qualifiers_20_0, "!transient");

                    	            }

                    	            }


                    	            }


                    	            }
                    	            break;
                    	        case 11 :
                    	            // InternalQVTbase.g:384:6: ( (lv_qualifiers_21_0= 'unique' ) )
                    	            {
                    	            // InternalQVTbase.g:384:6: ( (lv_qualifiers_21_0= 'unique' ) )
                    	            // InternalQVTbase.g:385:1: (lv_qualifiers_21_0= 'unique' )
                    	            {
                    	            // InternalQVTbase.g:385:1: (lv_qualifiers_21_0= 'unique' )
                    	            // InternalQVTbase.g:386:3: lv_qualifiers_21_0= 'unique'
                    	            {
                    	            lv_qualifiers_21_0=(Token)match(input,33,FollowSets000.FOLLOW_12); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	                      newLeafNode(lv_qualifiers_21_0, grammarAccess.getAttributeCSAccess().getQualifiersUniqueKeyword_5_1_0_10_0());

                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElement(grammarAccess.getAttributeCSRule());
                    	              	        }
                    	                     		addWithLastConsumed(current, "qualifiers", lv_qualifiers_21_0, "unique");

                    	            }

                    	            }


                    	            }


                    	            }
                    	            break;
                    	        case 12 :
                    	            // InternalQVTbase.g:400:6: ( (lv_qualifiers_22_0= '!unique' ) )
                    	            {
                    	            // InternalQVTbase.g:400:6: ( (lv_qualifiers_22_0= '!unique' ) )
                    	            // InternalQVTbase.g:401:1: (lv_qualifiers_22_0= '!unique' )
                    	            {
                    	            // InternalQVTbase.g:401:1: (lv_qualifiers_22_0= '!unique' )
                    	            // InternalQVTbase.g:402:3: lv_qualifiers_22_0= '!unique'
                    	            {
                    	            lv_qualifiers_22_0=(Token)match(input,34,FollowSets000.FOLLOW_12); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	                      newLeafNode(lv_qualifiers_22_0, grammarAccess.getAttributeCSAccess().getQualifiersUniqueKeyword_5_1_0_11_0());

                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElement(grammarAccess.getAttributeCSRule());
                    	              	        }
                    	                     		addWithLastConsumed(current, "qualifiers", lv_qualifiers_22_0, "!unique");

                    	            }

                    	            }


                    	            }


                    	            }
                    	            break;
                    	        case 13 :
                    	            // InternalQVTbase.g:416:6: ( (lv_qualifiers_23_0= 'unsettable' ) )
                    	            {
                    	            // InternalQVTbase.g:416:6: ( (lv_qualifiers_23_0= 'unsettable' ) )
                    	            // InternalQVTbase.g:417:1: (lv_qualifiers_23_0= 'unsettable' )
                    	            {
                    	            // InternalQVTbase.g:417:1: (lv_qualifiers_23_0= 'unsettable' )
                    	            // InternalQVTbase.g:418:3: lv_qualifiers_23_0= 'unsettable'
                    	            {
                    	            lv_qualifiers_23_0=(Token)match(input,35,FollowSets000.FOLLOW_12); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	                      newLeafNode(lv_qualifiers_23_0, grammarAccess.getAttributeCSAccess().getQualifiersUnsettableKeyword_5_1_0_12_0());

                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElement(grammarAccess.getAttributeCSRule());
                    	              	        }
                    	                     		addWithLastConsumed(current, "qualifiers", lv_qualifiers_23_0, "unsettable");

                    	            }

                    	            }


                    	            }


                    	            }
                    	            break;
                    	        case 14 :
                    	            // InternalQVTbase.g:432:6: ( (lv_qualifiers_24_0= '!unsettable' ) )
                    	            {
                    	            // InternalQVTbase.g:432:6: ( (lv_qualifiers_24_0= '!unsettable' ) )
                    	            // InternalQVTbase.g:433:1: (lv_qualifiers_24_0= '!unsettable' )
                    	            {
                    	            // InternalQVTbase.g:433:1: (lv_qualifiers_24_0= '!unsettable' )
                    	            // InternalQVTbase.g:434:3: lv_qualifiers_24_0= '!unsettable'
                    	            {
                    	            lv_qualifiers_24_0=(Token)match(input,36,FollowSets000.FOLLOW_12); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	                      newLeafNode(lv_qualifiers_24_0, grammarAccess.getAttributeCSAccess().getQualifiersUnsettableKeyword_5_1_0_13_0());

                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElement(grammarAccess.getAttributeCSRule());
                    	              	        }
                    	                     		addWithLastConsumed(current, "qualifiers", lv_qualifiers_24_0, "!unsettable");

                    	            }

                    	            }


                    	            }


                    	            }
                    	            break;
                    	        case 15 :
                    	            // InternalQVTbase.g:448:6: ( (lv_qualifiers_25_0= 'volatile' ) )
                    	            {
                    	            // InternalQVTbase.g:448:6: ( (lv_qualifiers_25_0= 'volatile' ) )
                    	            // InternalQVTbase.g:449:1: (lv_qualifiers_25_0= 'volatile' )
                    	            {
                    	            // InternalQVTbase.g:449:1: (lv_qualifiers_25_0= 'volatile' )
                    	            // InternalQVTbase.g:450:3: lv_qualifiers_25_0= 'volatile'
                    	            {
                    	            lv_qualifiers_25_0=(Token)match(input,37,FollowSets000.FOLLOW_12); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	                      newLeafNode(lv_qualifiers_25_0, grammarAccess.getAttributeCSAccess().getQualifiersVolatileKeyword_5_1_0_14_0());

                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElement(grammarAccess.getAttributeCSRule());
                    	              	        }
                    	                     		addWithLastConsumed(current, "qualifiers", lv_qualifiers_25_0, "volatile");

                    	            }

                    	            }


                    	            }


                    	            }
                    	            break;
                    	        case 16 :
                    	            // InternalQVTbase.g:464:6: ( (lv_qualifiers_26_0= '!volatile' ) )
                    	            {
                    	            // InternalQVTbase.g:464:6: ( (lv_qualifiers_26_0= '!volatile' ) )
                    	            // InternalQVTbase.g:465:1: (lv_qualifiers_26_0= '!volatile' )
                    	            {
                    	            // InternalQVTbase.g:465:1: (lv_qualifiers_26_0= '!volatile' )
                    	            // InternalQVTbase.g:466:3: lv_qualifiers_26_0= '!volatile'
                    	            {
                    	            lv_qualifiers_26_0=(Token)match(input,38,FollowSets000.FOLLOW_12); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	                      newLeafNode(lv_qualifiers_26_0, grammarAccess.getAttributeCSAccess().getQualifiersVolatileKeyword_5_1_0_15_0());

                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElement(grammarAccess.getAttributeCSRule());
                    	              	        }
                    	                     		addWithLastConsumed(current, "qualifiers", lv_qualifiers_26_0, "!volatile");

                    	            }

                    	            }


                    	            }


                    	            }
                    	            break;

                    	    }

                    	    // InternalQVTbase.g:479:3: (otherlv_27= ',' )?
                    	    int alt7=2;
                    	    int LA7_0 = input.LA(1);

                    	    if ( (LA7_0==39) ) {
                    	        alt7=1;
                    	    }
                    	    switch (alt7) {
                    	        case 1 :
                    	            // InternalQVTbase.g:479:5: otherlv_27= ','
                    	            {
                    	            otherlv_27=(Token)match(input,39,FollowSets000.FOLLOW_13); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	                  	newLeafNode(otherlv_27, grammarAccess.getAttributeCSAccess().getCommaKeyword_5_1_1());

                    	            }

                    	            }
                    	            break;

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt8 >= 1 ) break loop8;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(8, input);
                                throw eee;
                        }
                        cnt8++;
                    } while (true);

                    otherlv_28=(Token)match(input,40,FollowSets000.FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_28, grammarAccess.getAttributeCSAccess().getRightCurlyBracketKeyword_5_2());

                    }

                    }
                    break;

            }

            // InternalQVTbase.g:487:3: ( (otherlv_29= '{' ( (otherlv_30= 'initial' ( ruleUnrestrictedName )? otherlv_32= ':' ( (lv_ownedDefaultExpressions_33_0= ruleSpecificationCS ) )? otherlv_34= ';' ) | (otherlv_35= 'derivation' ( ruleUnrestrictedName )? otherlv_37= ':' ( (lv_ownedDefaultExpressions_38_0= ruleSpecificationCS ) )? otherlv_39= ';' ) )* otherlv_40= '}' ) | otherlv_41= ';' )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==22) ) {
                alt15=1;
            }
            else if ( (LA15_0==42) ) {
                alt15=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // InternalQVTbase.g:487:4: (otherlv_29= '{' ( (otherlv_30= 'initial' ( ruleUnrestrictedName )? otherlv_32= ':' ( (lv_ownedDefaultExpressions_33_0= ruleSpecificationCS ) )? otherlv_34= ';' ) | (otherlv_35= 'derivation' ( ruleUnrestrictedName )? otherlv_37= ':' ( (lv_ownedDefaultExpressions_38_0= ruleSpecificationCS ) )? otherlv_39= ';' ) )* otherlv_40= '}' )
                    {
                    // InternalQVTbase.g:487:4: (otherlv_29= '{' ( (otherlv_30= 'initial' ( ruleUnrestrictedName )? otherlv_32= ':' ( (lv_ownedDefaultExpressions_33_0= ruleSpecificationCS ) )? otherlv_34= ';' ) | (otherlv_35= 'derivation' ( ruleUnrestrictedName )? otherlv_37= ':' ( (lv_ownedDefaultExpressions_38_0= ruleSpecificationCS ) )? otherlv_39= ';' ) )* otherlv_40= '}' )
                    // InternalQVTbase.g:487:6: otherlv_29= '{' ( (otherlv_30= 'initial' ( ruleUnrestrictedName )? otherlv_32= ':' ( (lv_ownedDefaultExpressions_33_0= ruleSpecificationCS ) )? otherlv_34= ';' ) | (otherlv_35= 'derivation' ( ruleUnrestrictedName )? otherlv_37= ':' ( (lv_ownedDefaultExpressions_38_0= ruleSpecificationCS ) )? otherlv_39= ';' ) )* otherlv_40= '}'
                    {
                    otherlv_29=(Token)match(input,22,FollowSets000.FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_29, grammarAccess.getAttributeCSAccess().getLeftCurlyBracketKeyword_6_0_0());

                    }
                    // InternalQVTbase.g:491:1: ( (otherlv_30= 'initial' ( ruleUnrestrictedName )? otherlv_32= ':' ( (lv_ownedDefaultExpressions_33_0= ruleSpecificationCS ) )? otherlv_34= ';' ) | (otherlv_35= 'derivation' ( ruleUnrestrictedName )? otherlv_37= ':' ( (lv_ownedDefaultExpressions_38_0= ruleSpecificationCS ) )? otherlv_39= ';' ) )*
                    loop14:
                    do {
                        int alt14=3;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==41) ) {
                            alt14=1;
                        }
                        else if ( (LA14_0==43) ) {
                            alt14=2;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // InternalQVTbase.g:491:2: (otherlv_30= 'initial' ( ruleUnrestrictedName )? otherlv_32= ':' ( (lv_ownedDefaultExpressions_33_0= ruleSpecificationCS ) )? otherlv_34= ';' )
                    	    {
                    	    // InternalQVTbase.g:491:2: (otherlv_30= 'initial' ( ruleUnrestrictedName )? otherlv_32= ':' ( (lv_ownedDefaultExpressions_33_0= ruleSpecificationCS ) )? otherlv_34= ';' )
                    	    // InternalQVTbase.g:491:4: otherlv_30= 'initial' ( ruleUnrestrictedName )? otherlv_32= ':' ( (lv_ownedDefaultExpressions_33_0= ruleSpecificationCS ) )? otherlv_34= ';'
                    	    {
                    	    otherlv_30=(Token)match(input,41,FollowSets000.FOLLOW_15); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_30, grammarAccess.getAttributeCSAccess().getInitialKeyword_6_0_1_0_0());

                    	    }
                    	    // InternalQVTbase.g:495:1: ( ruleUnrestrictedName )?
                    	    int alt10=2;
                    	    int LA10_0 = input.LA(1);

                    	    if ( ((LA10_0>=RULE_SIMPLE_ID && LA10_0<=RULE_ESCAPED_ID)) ) {
                    	        alt10=1;
                    	    }
                    	    switch (alt10) {
                    	        case 1 :
                    	            // InternalQVTbase.g:496:2: ruleUnrestrictedName
                    	            {
                    	            if ( state.backtracking==0 ) {

                    	              	  /* */

                    	            }
                    	            if ( state.backtracking==0 ) {

                    	                      newCompositeNode(grammarAccess.getAttributeCSAccess().getUnrestrictedNameParserRuleCall_6_0_1_0_1());

                    	            }
                    	            pushFollow(FollowSets000.FOLLOW_16);
                    	            ruleUnrestrictedName();

                    	            state._fsp--;
                    	            if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	                      afterParserOrEnumRuleCall();

                    	            }

                    	            }
                    	            break;

                    	    }

                    	    otherlv_32=(Token)match(input,20,FollowSets000.FOLLOW_17); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_32, grammarAccess.getAttributeCSAccess().getColonKeyword_6_0_1_0_2());

                    	    }
                    	    // InternalQVTbase.g:510:1: ( (lv_ownedDefaultExpressions_33_0= ruleSpecificationCS ) )?
                    	    int alt11=2;
                    	    int LA11_0 = input.LA(1);

                    	    if ( ((LA11_0>=RULE_SINGLE_QUOTED_STRING && LA11_0<=RULE_ESCAPED_ID)||LA11_0==51||(LA11_0>=65 && LA11_0<=67)||(LA11_0>=83 && LA11_0<=97)||LA11_0==100||(LA11_0>=102 && LA11_0<=105)||LA11_0==112||(LA11_0>=117 && LA11_0<=118)) ) {
                    	        alt11=1;
                    	    }
                    	    switch (alt11) {
                    	        case 1 :
                    	            // InternalQVTbase.g:511:1: (lv_ownedDefaultExpressions_33_0= ruleSpecificationCS )
                    	            {
                    	            // InternalQVTbase.g:511:1: (lv_ownedDefaultExpressions_33_0= ruleSpecificationCS )
                    	            // InternalQVTbase.g:512:3: lv_ownedDefaultExpressions_33_0= ruleSpecificationCS
                    	            {
                    	            if ( state.backtracking==0 ) {

                    	              	        newCompositeNode(grammarAccess.getAttributeCSAccess().getOwnedDefaultExpressionsSpecificationCSParserRuleCall_6_0_1_0_3_0());

                    	            }
                    	            pushFollow(FollowSets000.FOLLOW_18);
                    	            lv_ownedDefaultExpressions_33_0=ruleSpecificationCS();

                    	            state._fsp--;
                    	            if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElementForParent(grammarAccess.getAttributeCSRule());
                    	              	        }
                    	                     		add(
                    	                     			current,
                    	                     			"ownedDefaultExpressions",
                    	                      		lv_ownedDefaultExpressions_33_0,
                    	                      		"org.eclipse.qvtd.xtext.qvtbase.QVTbase.SpecificationCS");
                    	              	        afterParserOrEnumRuleCall();

                    	            }

                    	            }


                    	            }
                    	            break;

                    	    }

                    	    otherlv_34=(Token)match(input,42,FollowSets000.FOLLOW_14); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_34, grammarAccess.getAttributeCSAccess().getSemicolonKeyword_6_0_1_0_4());

                    	    }

                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalQVTbase.g:533:6: (otherlv_35= 'derivation' ( ruleUnrestrictedName )? otherlv_37= ':' ( (lv_ownedDefaultExpressions_38_0= ruleSpecificationCS ) )? otherlv_39= ';' )
                    	    {
                    	    // InternalQVTbase.g:533:6: (otherlv_35= 'derivation' ( ruleUnrestrictedName )? otherlv_37= ':' ( (lv_ownedDefaultExpressions_38_0= ruleSpecificationCS ) )? otherlv_39= ';' )
                    	    // InternalQVTbase.g:533:8: otherlv_35= 'derivation' ( ruleUnrestrictedName )? otherlv_37= ':' ( (lv_ownedDefaultExpressions_38_0= ruleSpecificationCS ) )? otherlv_39= ';'
                    	    {
                    	    otherlv_35=(Token)match(input,43,FollowSets000.FOLLOW_15); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_35, grammarAccess.getAttributeCSAccess().getDerivationKeyword_6_0_1_1_0());

                    	    }
                    	    // InternalQVTbase.g:537:1: ( ruleUnrestrictedName )?
                    	    int alt12=2;
                    	    int LA12_0 = input.LA(1);

                    	    if ( ((LA12_0>=RULE_SIMPLE_ID && LA12_0<=RULE_ESCAPED_ID)) ) {
                    	        alt12=1;
                    	    }
                    	    switch (alt12) {
                    	        case 1 :
                    	            // InternalQVTbase.g:538:2: ruleUnrestrictedName
                    	            {
                    	            if ( state.backtracking==0 ) {

                    	              	  /* */

                    	            }
                    	            if ( state.backtracking==0 ) {

                    	                      newCompositeNode(grammarAccess.getAttributeCSAccess().getUnrestrictedNameParserRuleCall_6_0_1_1_1());

                    	            }
                    	            pushFollow(FollowSets000.FOLLOW_16);
                    	            ruleUnrestrictedName();

                    	            state._fsp--;
                    	            if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	                      afterParserOrEnumRuleCall();

                    	            }

                    	            }
                    	            break;

                    	    }

                    	    otherlv_37=(Token)match(input,20,FollowSets000.FOLLOW_17); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_37, grammarAccess.getAttributeCSAccess().getColonKeyword_6_0_1_1_2());

                    	    }
                    	    // InternalQVTbase.g:552:1: ( (lv_ownedDefaultExpressions_38_0= ruleSpecificationCS ) )?
                    	    int alt13=2;
                    	    int LA13_0 = input.LA(1);

                    	    if ( ((LA13_0>=RULE_SINGLE_QUOTED_STRING && LA13_0<=RULE_ESCAPED_ID)||LA13_0==51||(LA13_0>=65 && LA13_0<=67)||(LA13_0>=83 && LA13_0<=97)||LA13_0==100||(LA13_0>=102 && LA13_0<=105)||LA13_0==112||(LA13_0>=117 && LA13_0<=118)) ) {
                    	        alt13=1;
                    	    }
                    	    switch (alt13) {
                    	        case 1 :
                    	            // InternalQVTbase.g:553:1: (lv_ownedDefaultExpressions_38_0= ruleSpecificationCS )
                    	            {
                    	            // InternalQVTbase.g:553:1: (lv_ownedDefaultExpressions_38_0= ruleSpecificationCS )
                    	            // InternalQVTbase.g:554:3: lv_ownedDefaultExpressions_38_0= ruleSpecificationCS
                    	            {
                    	            if ( state.backtracking==0 ) {

                    	              	        newCompositeNode(grammarAccess.getAttributeCSAccess().getOwnedDefaultExpressionsSpecificationCSParserRuleCall_6_0_1_1_3_0());

                    	            }
                    	            pushFollow(FollowSets000.FOLLOW_18);
                    	            lv_ownedDefaultExpressions_38_0=ruleSpecificationCS();

                    	            state._fsp--;
                    	            if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElementForParent(grammarAccess.getAttributeCSRule());
                    	              	        }
                    	                     		add(
                    	                     			current,
                    	                     			"ownedDefaultExpressions",
                    	                      		lv_ownedDefaultExpressions_38_0,
                    	                      		"org.eclipse.qvtd.xtext.qvtbase.QVTbase.SpecificationCS");
                    	              	        afterParserOrEnumRuleCall();

                    	            }

                    	            }


                    	            }
                    	            break;

                    	    }

                    	    otherlv_39=(Token)match(input,42,FollowSets000.FOLLOW_14); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_39, grammarAccess.getAttributeCSAccess().getSemicolonKeyword_6_0_1_1_4());

                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);

                    otherlv_40=(Token)match(input,40,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_40, grammarAccess.getAttributeCSAccess().getRightCurlyBracketKeyword_6_0_2());

                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalQVTbase.g:579:7: otherlv_41= ';'
                    {
                    otherlv_41=(Token)match(input,42,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_41, grammarAccess.getAttributeCSAccess().getSemicolonKeyword_6_1());

                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAttributeCS"


    // $ANTLR start "entryRuleDataTypeCS"
    // InternalQVTbase.g:593:1: entryRuleDataTypeCS returns [EObject current=null] : iv_ruleDataTypeCS= ruleDataTypeCS EOF ;
    public final EObject entryRuleDataTypeCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataTypeCS = null;


        try {
            // InternalQVTbase.g:594:2: (iv_ruleDataTypeCS= ruleDataTypeCS EOF )
            // InternalQVTbase.g:595:2: iv_ruleDataTypeCS= ruleDataTypeCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDataTypeCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDataTypeCS=ruleDataTypeCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDataTypeCS;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDataTypeCS"


    // $ANTLR start "ruleDataTypeCS"
    // InternalQVTbase.g:602:1: ruleDataTypeCS returns [EObject current=null] : ( ( (lv_isPrimitive_0_0= 'primitive' ) )? otherlv_1= 'datatype' ( (lv_name_2_0= ruleUnrestrictedName ) ) ( (lv_ownedSignature_3_0= ruleTemplateSignatureCS ) )? (otherlv_4= ':' ( (lv_instanceClassName_5_0= RULE_SINGLE_QUOTED_STRING ) ) )? (otherlv_6= '{' ( ( (lv_isSerializable_7_0= 'serializable' ) ) | otherlv_8= '!serializable' )? otherlv_9= '}' )? ( (otherlv_10= '{' otherlv_11= '}' ) | otherlv_12= ';' ) ) ;
    public final EObject ruleDataTypeCS() throws RecognitionException {
        EObject current = null;

        Token lv_isPrimitive_0_0=null;
        Token otherlv_1=null;
        Token otherlv_4=null;
        Token lv_instanceClassName_5_0=null;
        Token otherlv_6=null;
        Token lv_isSerializable_7_0=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_ownedSignature_3_0 = null;


         enterRule();

        try {
            // InternalQVTbase.g:605:28: ( ( ( (lv_isPrimitive_0_0= 'primitive' ) )? otherlv_1= 'datatype' ( (lv_name_2_0= ruleUnrestrictedName ) ) ( (lv_ownedSignature_3_0= ruleTemplateSignatureCS ) )? (otherlv_4= ':' ( (lv_instanceClassName_5_0= RULE_SINGLE_QUOTED_STRING ) ) )? (otherlv_6= '{' ( ( (lv_isSerializable_7_0= 'serializable' ) ) | otherlv_8= '!serializable' )? otherlv_9= '}' )? ( (otherlv_10= '{' otherlv_11= '}' ) | otherlv_12= ';' ) ) )
            // InternalQVTbase.g:606:1: ( ( (lv_isPrimitive_0_0= 'primitive' ) )? otherlv_1= 'datatype' ( (lv_name_2_0= ruleUnrestrictedName ) ) ( (lv_ownedSignature_3_0= ruleTemplateSignatureCS ) )? (otherlv_4= ':' ( (lv_instanceClassName_5_0= RULE_SINGLE_QUOTED_STRING ) ) )? (otherlv_6= '{' ( ( (lv_isSerializable_7_0= 'serializable' ) ) | otherlv_8= '!serializable' )? otherlv_9= '}' )? ( (otherlv_10= '{' otherlv_11= '}' ) | otherlv_12= ';' ) )
            {
            // InternalQVTbase.g:606:1: ( ( (lv_isPrimitive_0_0= 'primitive' ) )? otherlv_1= 'datatype' ( (lv_name_2_0= ruleUnrestrictedName ) ) ( (lv_ownedSignature_3_0= ruleTemplateSignatureCS ) )? (otherlv_4= ':' ( (lv_instanceClassName_5_0= RULE_SINGLE_QUOTED_STRING ) ) )? (otherlv_6= '{' ( ( (lv_isSerializable_7_0= 'serializable' ) ) | otherlv_8= '!serializable' )? otherlv_9= '}' )? ( (otherlv_10= '{' otherlv_11= '}' ) | otherlv_12= ';' ) )
            // InternalQVTbase.g:606:2: ( (lv_isPrimitive_0_0= 'primitive' ) )? otherlv_1= 'datatype' ( (lv_name_2_0= ruleUnrestrictedName ) ) ( (lv_ownedSignature_3_0= ruleTemplateSignatureCS ) )? (otherlv_4= ':' ( (lv_instanceClassName_5_0= RULE_SINGLE_QUOTED_STRING ) ) )? (otherlv_6= '{' ( ( (lv_isSerializable_7_0= 'serializable' ) ) | otherlv_8= '!serializable' )? otherlv_9= '}' )? ( (otherlv_10= '{' otherlv_11= '}' ) | otherlv_12= ';' )
            {
            // InternalQVTbase.g:606:2: ( (lv_isPrimitive_0_0= 'primitive' ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==44) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalQVTbase.g:607:1: (lv_isPrimitive_0_0= 'primitive' )
                    {
                    // InternalQVTbase.g:607:1: (lv_isPrimitive_0_0= 'primitive' )
                    // InternalQVTbase.g:608:3: lv_isPrimitive_0_0= 'primitive'
                    {
                    lv_isPrimitive_0_0=(Token)match(input,44,FollowSets000.FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_isPrimitive_0_0, grammarAccess.getDataTypeCSAccess().getIsPrimitivePrimitiveKeyword_0_0());

                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getDataTypeCSRule());
                      	        }
                             		setWithLastConsumed(current, "isPrimitive", true, "primitive");

                    }

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,45,FollowSets000.FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getDataTypeCSAccess().getDatatypeKeyword_1());

            }
            // InternalQVTbase.g:625:1: ( (lv_name_2_0= ruleUnrestrictedName ) )
            // InternalQVTbase.g:626:1: (lv_name_2_0= ruleUnrestrictedName )
            {
            // InternalQVTbase.g:626:1: (lv_name_2_0= ruleUnrestrictedName )
            // InternalQVTbase.g:627:3: lv_name_2_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {

              	        newCompositeNode(grammarAccess.getDataTypeCSAccess().getNameUnrestrictedNameParserRuleCall_2_0());

            }
            pushFollow(FollowSets000.FOLLOW_20);
            lv_name_2_0=ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getDataTypeCSRule());
              	        }
                     		set(
                     			current,
                     			"name",
                      		lv_name_2_0,
                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.UnrestrictedName");
              	        afterParserOrEnumRuleCall();

            }

            }


            }

            // InternalQVTbase.g:643:2: ( (lv_ownedSignature_3_0= ruleTemplateSignatureCS ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==51) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalQVTbase.g:644:1: (lv_ownedSignature_3_0= ruleTemplateSignatureCS )
                    {
                    // InternalQVTbase.g:644:1: (lv_ownedSignature_3_0= ruleTemplateSignatureCS )
                    // InternalQVTbase.g:645:3: lv_ownedSignature_3_0= ruleTemplateSignatureCS
                    {
                    if ( state.backtracking==0 ) {

                      	        newCompositeNode(grammarAccess.getDataTypeCSAccess().getOwnedSignatureTemplateSignatureCSParserRuleCall_3_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_21);
                    lv_ownedSignature_3_0=ruleTemplateSignatureCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getDataTypeCSRule());
                      	        }
                             		set(
                             			current,
                             			"ownedSignature",
                              		lv_ownedSignature_3_0,
                              		"org.eclipse.ocl.xtext.base.Base.TemplateSignatureCS");
                      	        afterParserOrEnumRuleCall();

                    }

                    }


                    }
                    break;

            }

            // InternalQVTbase.g:661:3: (otherlv_4= ':' ( (lv_instanceClassName_5_0= RULE_SINGLE_QUOTED_STRING ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==20) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalQVTbase.g:661:5: otherlv_4= ':' ( (lv_instanceClassName_5_0= RULE_SINGLE_QUOTED_STRING ) )
                    {
                    otherlv_4=(Token)match(input,20,FollowSets000.FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getDataTypeCSAccess().getColonKeyword_4_0());

                    }
                    // InternalQVTbase.g:665:1: ( (lv_instanceClassName_5_0= RULE_SINGLE_QUOTED_STRING ) )
                    // InternalQVTbase.g:666:1: (lv_instanceClassName_5_0= RULE_SINGLE_QUOTED_STRING )
                    {
                    // InternalQVTbase.g:666:1: (lv_instanceClassName_5_0= RULE_SINGLE_QUOTED_STRING )
                    // InternalQVTbase.g:667:3: lv_instanceClassName_5_0= RULE_SINGLE_QUOTED_STRING
                    {
                    lv_instanceClassName_5_0=(Token)match(input,RULE_SINGLE_QUOTED_STRING,FollowSets000.FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_instanceClassName_5_0, grammarAccess.getDataTypeCSAccess().getInstanceClassNameSINGLE_QUOTED_STRINGTerminalRuleCall_4_1_0());

                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getDataTypeCSRule());
                      	        }
                             		setWithLastConsumed(
                             			current,
                             			"instanceClassName",
                              		lv_instanceClassName_5_0,
                              		"org.eclipse.ocl.xtext.base.Base.SINGLE_QUOTED_STRING");

                    }

                    }


                    }


                    }
                    break;

            }

            // InternalQVTbase.g:683:4: (otherlv_6= '{' ( ( (lv_isSerializable_7_0= 'serializable' ) ) | otherlv_8= '!serializable' )? otherlv_9= '}' )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==22) ) {
                int LA20_1 = input.LA(2);

                if ( ((LA20_1>=46 && LA20_1<=47)) ) {
                    alt20=1;
                }
                else if ( (LA20_1==40) ) {
                    int LA20_4 = input.LA(3);

                    if ( (LA20_4==22||LA20_4==42) ) {
                        alt20=1;
                    }
                }
            }
            switch (alt20) {
                case 1 :
                    // InternalQVTbase.g:683:6: otherlv_6= '{' ( ( (lv_isSerializable_7_0= 'serializable' ) ) | otherlv_8= '!serializable' )? otherlv_9= '}'
                    {
                    otherlv_6=(Token)match(input,22,FollowSets000.FOLLOW_22); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getDataTypeCSAccess().getLeftCurlyBracketKeyword_5_0());

                    }
                    // InternalQVTbase.g:687:1: ( ( (lv_isSerializable_7_0= 'serializable' ) ) | otherlv_8= '!serializable' )?
                    int alt19=3;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==46) ) {
                        alt19=1;
                    }
                    else if ( (LA19_0==47) ) {
                        alt19=2;
                    }
                    switch (alt19) {
                        case 1 :
                            // InternalQVTbase.g:687:2: ( (lv_isSerializable_7_0= 'serializable' ) )
                            {
                            // InternalQVTbase.g:687:2: ( (lv_isSerializable_7_0= 'serializable' ) )
                            // InternalQVTbase.g:688:1: (lv_isSerializable_7_0= 'serializable' )
                            {
                            // InternalQVTbase.g:688:1: (lv_isSerializable_7_0= 'serializable' )
                            // InternalQVTbase.g:689:3: lv_isSerializable_7_0= 'serializable'
                            {
                            lv_isSerializable_7_0=(Token)match(input,46,FollowSets000.FOLLOW_23); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_isSerializable_7_0, grammarAccess.getDataTypeCSAccess().getIsSerializableSerializableKeyword_5_1_0_0());

                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getDataTypeCSRule());
                              	        }
                                     		setWithLastConsumed(current, "isSerializable", true, "serializable");

                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalQVTbase.g:703:7: otherlv_8= '!serializable'
                            {
                            otherlv_8=(Token)match(input,47,FollowSets000.FOLLOW_23); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_8, grammarAccess.getDataTypeCSAccess().getSerializableKeyword_5_1_1());

                            }

                            }
                            break;

                    }

                    otherlv_9=(Token)match(input,40,FollowSets000.FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getDataTypeCSAccess().getRightCurlyBracketKeyword_5_2());

                    }

                    }
                    break;

            }

            // InternalQVTbase.g:711:3: ( (otherlv_10= '{' otherlv_11= '}' ) | otherlv_12= ';' )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==22) ) {
                alt21=1;
            }
            else if ( (LA21_0==42) ) {
                alt21=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // InternalQVTbase.g:711:4: (otherlv_10= '{' otherlv_11= '}' )
                    {
                    // InternalQVTbase.g:711:4: (otherlv_10= '{' otherlv_11= '}' )
                    // InternalQVTbase.g:711:6: otherlv_10= '{' otherlv_11= '}'
                    {
                    otherlv_10=(Token)match(input,22,FollowSets000.FOLLOW_23); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getDataTypeCSAccess().getLeftCurlyBracketKeyword_6_0_0());

                    }
                    otherlv_11=(Token)match(input,40,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_11, grammarAccess.getDataTypeCSAccess().getRightCurlyBracketKeyword_6_0_1());

                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalQVTbase.g:720:7: otherlv_12= ';'
                    {
                    otherlv_12=(Token)match(input,42,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_12, grammarAccess.getDataTypeCSAccess().getSemicolonKeyword_6_1());

                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDataTypeCS"


    // $ANTLR start "entryRuleEnumerationCS"
    // InternalQVTbase.g:732:1: entryRuleEnumerationCS returns [EObject current=null] : iv_ruleEnumerationCS= ruleEnumerationCS EOF ;
    public final EObject entryRuleEnumerationCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumerationCS = null;


        try {
            // InternalQVTbase.g:733:2: (iv_ruleEnumerationCS= ruleEnumerationCS EOF )
            // InternalQVTbase.g:734:2: iv_ruleEnumerationCS= ruleEnumerationCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEnumerationCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEnumerationCS=ruleEnumerationCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEnumerationCS;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEnumerationCS"


    // $ANTLR start "ruleEnumerationCS"
    // InternalQVTbase.g:741:1: ruleEnumerationCS returns [EObject current=null] : (otherlv_0= 'enum' ( (lv_name_1_0= ruleUnrestrictedName ) ) ( (lv_ownedSignature_2_0= ruleTemplateSignatureCS ) )? (otherlv_3= ':' ( (lv_instanceClassName_4_0= RULE_SINGLE_QUOTED_STRING ) ) )? (otherlv_5= '{' ( ( (lv_isSerializable_6_0= 'serializable' ) ) | otherlv_7= '!serializable' )? otherlv_8= '}' )? ( (otherlv_9= '{' ( (lv_ownedLiterals_10_0= ruleEnumerationLiteralCS ) )* otherlv_11= '}' ) | otherlv_12= ';' ) ) ;
    public final EObject ruleEnumerationCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token lv_instanceClassName_4_0=null;
        Token otherlv_5=null;
        Token lv_isSerializable_6_0=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_ownedSignature_2_0 = null;

        EObject lv_ownedLiterals_10_0 = null;


         enterRule();

        try {
            // InternalQVTbase.g:744:28: ( (otherlv_0= 'enum' ( (lv_name_1_0= ruleUnrestrictedName ) ) ( (lv_ownedSignature_2_0= ruleTemplateSignatureCS ) )? (otherlv_3= ':' ( (lv_instanceClassName_4_0= RULE_SINGLE_QUOTED_STRING ) ) )? (otherlv_5= '{' ( ( (lv_isSerializable_6_0= 'serializable' ) ) | otherlv_7= '!serializable' )? otherlv_8= '}' )? ( (otherlv_9= '{' ( (lv_ownedLiterals_10_0= ruleEnumerationLiteralCS ) )* otherlv_11= '}' ) | otherlv_12= ';' ) ) )
            // InternalQVTbase.g:745:1: (otherlv_0= 'enum' ( (lv_name_1_0= ruleUnrestrictedName ) ) ( (lv_ownedSignature_2_0= ruleTemplateSignatureCS ) )? (otherlv_3= ':' ( (lv_instanceClassName_4_0= RULE_SINGLE_QUOTED_STRING ) ) )? (otherlv_5= '{' ( ( (lv_isSerializable_6_0= 'serializable' ) ) | otherlv_7= '!serializable' )? otherlv_8= '}' )? ( (otherlv_9= '{' ( (lv_ownedLiterals_10_0= ruleEnumerationLiteralCS ) )* otherlv_11= '}' ) | otherlv_12= ';' ) )
            {
            // InternalQVTbase.g:745:1: (otherlv_0= 'enum' ( (lv_name_1_0= ruleUnrestrictedName ) ) ( (lv_ownedSignature_2_0= ruleTemplateSignatureCS ) )? (otherlv_3= ':' ( (lv_instanceClassName_4_0= RULE_SINGLE_QUOTED_STRING ) ) )? (otherlv_5= '{' ( ( (lv_isSerializable_6_0= 'serializable' ) ) | otherlv_7= '!serializable' )? otherlv_8= '}' )? ( (otherlv_9= '{' ( (lv_ownedLiterals_10_0= ruleEnumerationLiteralCS ) )* otherlv_11= '}' ) | otherlv_12= ';' ) )
            // InternalQVTbase.g:745:3: otherlv_0= 'enum' ( (lv_name_1_0= ruleUnrestrictedName ) ) ( (lv_ownedSignature_2_0= ruleTemplateSignatureCS ) )? (otherlv_3= ':' ( (lv_instanceClassName_4_0= RULE_SINGLE_QUOTED_STRING ) ) )? (otherlv_5= '{' ( ( (lv_isSerializable_6_0= 'serializable' ) ) | otherlv_7= '!serializable' )? otherlv_8= '}' )? ( (otherlv_9= '{' ( (lv_ownedLiterals_10_0= ruleEnumerationLiteralCS ) )* otherlv_11= '}' ) | otherlv_12= ';' )
            {
            otherlv_0=(Token)match(input,48,FollowSets000.FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getEnumerationCSAccess().getEnumKeyword_0());

            }
            // InternalQVTbase.g:749:1: ( (lv_name_1_0= ruleUnrestrictedName ) )
            // InternalQVTbase.g:750:1: (lv_name_1_0= ruleUnrestrictedName )
            {
            // InternalQVTbase.g:750:1: (lv_name_1_0= ruleUnrestrictedName )
            // InternalQVTbase.g:751:3: lv_name_1_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {

              	        newCompositeNode(grammarAccess.getEnumerationCSAccess().getNameUnrestrictedNameParserRuleCall_1_0());

            }
            pushFollow(FollowSets000.FOLLOW_20);
            lv_name_1_0=ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getEnumerationCSRule());
              	        }
                     		set(
                     			current,
                     			"name",
                      		lv_name_1_0,
                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.UnrestrictedName");
              	        afterParserOrEnumRuleCall();

            }

            }


            }

            // InternalQVTbase.g:767:2: ( (lv_ownedSignature_2_0= ruleTemplateSignatureCS ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==51) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalQVTbase.g:768:1: (lv_ownedSignature_2_0= ruleTemplateSignatureCS )
                    {
                    // InternalQVTbase.g:768:1: (lv_ownedSignature_2_0= ruleTemplateSignatureCS )
                    // InternalQVTbase.g:769:3: lv_ownedSignature_2_0= ruleTemplateSignatureCS
                    {
                    if ( state.backtracking==0 ) {

                      	        newCompositeNode(grammarAccess.getEnumerationCSAccess().getOwnedSignatureTemplateSignatureCSParserRuleCall_2_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_21);
                    lv_ownedSignature_2_0=ruleTemplateSignatureCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getEnumerationCSRule());
                      	        }
                             		set(
                             			current,
                             			"ownedSignature",
                              		lv_ownedSignature_2_0,
                              		"org.eclipse.ocl.xtext.base.Base.TemplateSignatureCS");
                      	        afterParserOrEnumRuleCall();

                    }

                    }


                    }
                    break;

            }

            // InternalQVTbase.g:785:3: (otherlv_3= ':' ( (lv_instanceClassName_4_0= RULE_SINGLE_QUOTED_STRING ) ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==20) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalQVTbase.g:785:5: otherlv_3= ':' ( (lv_instanceClassName_4_0= RULE_SINGLE_QUOTED_STRING ) )
                    {
                    otherlv_3=(Token)match(input,20,FollowSets000.FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getEnumerationCSAccess().getColonKeyword_3_0());

                    }
                    // InternalQVTbase.g:789:1: ( (lv_instanceClassName_4_0= RULE_SINGLE_QUOTED_STRING ) )
                    // InternalQVTbase.g:790:1: (lv_instanceClassName_4_0= RULE_SINGLE_QUOTED_STRING )
                    {
                    // InternalQVTbase.g:790:1: (lv_instanceClassName_4_0= RULE_SINGLE_QUOTED_STRING )
                    // InternalQVTbase.g:791:3: lv_instanceClassName_4_0= RULE_SINGLE_QUOTED_STRING
                    {
                    lv_instanceClassName_4_0=(Token)match(input,RULE_SINGLE_QUOTED_STRING,FollowSets000.FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_instanceClassName_4_0, grammarAccess.getEnumerationCSAccess().getInstanceClassNameSINGLE_QUOTED_STRINGTerminalRuleCall_3_1_0());

                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getEnumerationCSRule());
                      	        }
                             		setWithLastConsumed(
                             			current,
                             			"instanceClassName",
                              		lv_instanceClassName_4_0,
                              		"org.eclipse.ocl.xtext.base.Base.SINGLE_QUOTED_STRING");

                    }

                    }


                    }


                    }
                    break;

            }

            // InternalQVTbase.g:807:4: (otherlv_5= '{' ( ( (lv_isSerializable_6_0= 'serializable' ) ) | otherlv_7= '!serializable' )? otherlv_8= '}' )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==22) ) {
                int LA25_1 = input.LA(2);

                if ( (LA25_1==40) ) {
                    int LA25_3 = input.LA(3);

                    if ( (LA25_3==22||LA25_3==42) ) {
                        alt25=1;
                    }
                }
                else if ( ((LA25_1>=46 && LA25_1<=47)) ) {
                    alt25=1;
                }
            }
            switch (alt25) {
                case 1 :
                    // InternalQVTbase.g:807:6: otherlv_5= '{' ( ( (lv_isSerializable_6_0= 'serializable' ) ) | otherlv_7= '!serializable' )? otherlv_8= '}'
                    {
                    otherlv_5=(Token)match(input,22,FollowSets000.FOLLOW_22); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getEnumerationCSAccess().getLeftCurlyBracketKeyword_4_0());

                    }
                    // InternalQVTbase.g:811:1: ( ( (lv_isSerializable_6_0= 'serializable' ) ) | otherlv_7= '!serializable' )?
                    int alt24=3;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0==46) ) {
                        alt24=1;
                    }
                    else if ( (LA24_0==47) ) {
                        alt24=2;
                    }
                    switch (alt24) {
                        case 1 :
                            // InternalQVTbase.g:811:2: ( (lv_isSerializable_6_0= 'serializable' ) )
                            {
                            // InternalQVTbase.g:811:2: ( (lv_isSerializable_6_0= 'serializable' ) )
                            // InternalQVTbase.g:812:1: (lv_isSerializable_6_0= 'serializable' )
                            {
                            // InternalQVTbase.g:812:1: (lv_isSerializable_6_0= 'serializable' )
                            // InternalQVTbase.g:813:3: lv_isSerializable_6_0= 'serializable'
                            {
                            lv_isSerializable_6_0=(Token)match(input,46,FollowSets000.FOLLOW_23); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_isSerializable_6_0, grammarAccess.getEnumerationCSAccess().getIsSerializableSerializableKeyword_4_1_0_0());

                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getEnumerationCSRule());
                              	        }
                                     		setWithLastConsumed(current, "isSerializable", true, "serializable");

                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalQVTbase.g:827:7: otherlv_7= '!serializable'
                            {
                            otherlv_7=(Token)match(input,47,FollowSets000.FOLLOW_23); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_7, grammarAccess.getEnumerationCSAccess().getSerializableKeyword_4_1_1());

                            }

                            }
                            break;

                    }

                    otherlv_8=(Token)match(input,40,FollowSets000.FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getEnumerationCSAccess().getRightCurlyBracketKeyword_4_2());

                    }

                    }
                    break;

            }

            // InternalQVTbase.g:835:3: ( (otherlv_9= '{' ( (lv_ownedLiterals_10_0= ruleEnumerationLiteralCS ) )* otherlv_11= '}' ) | otherlv_12= ';' )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==22) ) {
                alt27=1;
            }
            else if ( (LA27_0==42) ) {
                alt27=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // InternalQVTbase.g:835:4: (otherlv_9= '{' ( (lv_ownedLiterals_10_0= ruleEnumerationLiteralCS ) )* otherlv_11= '}' )
                    {
                    // InternalQVTbase.g:835:4: (otherlv_9= '{' ( (lv_ownedLiterals_10_0= ruleEnumerationLiteralCS ) )* otherlv_11= '}' )
                    // InternalQVTbase.g:835:6: otherlv_9= '{' ( (lv_ownedLiterals_10_0= ruleEnumerationLiteralCS ) )* otherlv_11= '}'
                    {
                    otherlv_9=(Token)match(input,22,FollowSets000.FOLLOW_24); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getEnumerationCSAccess().getLeftCurlyBracketKeyword_5_0_0());

                    }
                    // InternalQVTbase.g:839:1: ( (lv_ownedLiterals_10_0= ruleEnumerationLiteralCS ) )*
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( ((LA26_0>=RULE_SIMPLE_ID && LA26_0<=RULE_ESCAPED_ID)||LA26_0==49) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // InternalQVTbase.g:840:1: (lv_ownedLiterals_10_0= ruleEnumerationLiteralCS )
                    	    {
                    	    // InternalQVTbase.g:840:1: (lv_ownedLiterals_10_0= ruleEnumerationLiteralCS )
                    	    // InternalQVTbase.g:841:3: lv_ownedLiterals_10_0= ruleEnumerationLiteralCS
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      	        newCompositeNode(grammarAccess.getEnumerationCSAccess().getOwnedLiteralsEnumerationLiteralCSParserRuleCall_5_0_1_0());

                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_24);
                    	    lv_ownedLiterals_10_0=ruleEnumerationLiteralCS();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getEnumerationCSRule());
                    	      	        }
                    	             		add(
                    	             			current,
                    	             			"ownedLiterals",
                    	              		lv_ownedLiterals_10_0,
                    	              		"org.eclipse.qvtd.xtext.qvtbase.QVTbase.EnumerationLiteralCS");
                    	      	        afterParserOrEnumRuleCall();

                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop26;
                        }
                    } while (true);

                    otherlv_11=(Token)match(input,40,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_11, grammarAccess.getEnumerationCSAccess().getRightCurlyBracketKeyword_5_0_2());

                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalQVTbase.g:862:7: otherlv_12= ';'
                    {
                    otherlv_12=(Token)match(input,42,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_12, grammarAccess.getEnumerationCSAccess().getSemicolonKeyword_5_1());

                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEnumerationCS"


    // $ANTLR start "entryRuleEnumerationLiteralCS"
    // InternalQVTbase.g:874:1: entryRuleEnumerationLiteralCS returns [EObject current=null] : iv_ruleEnumerationLiteralCS= ruleEnumerationLiteralCS EOF ;
    public final EObject entryRuleEnumerationLiteralCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumerationLiteralCS = null;


        try {
            // InternalQVTbase.g:875:2: (iv_ruleEnumerationLiteralCS= ruleEnumerationLiteralCS EOF )
            // InternalQVTbase.g:876:2: iv_ruleEnumerationLiteralCS= ruleEnumerationLiteralCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEnumerationLiteralCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEnumerationLiteralCS=ruleEnumerationLiteralCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEnumerationLiteralCS;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEnumerationLiteralCS"


    // $ANTLR start "ruleEnumerationLiteralCS"
    // InternalQVTbase.g:883:1: ruleEnumerationLiteralCS returns [EObject current=null] : ( ( (otherlv_0= 'literal' ( (lv_name_1_0= ruleUnrestrictedName ) ) ) | ( (lv_name_2_0= ruleEnumerationLiteralName ) ) ) (otherlv_3= '=' ( (lv_value_4_0= ruleSIGNED ) ) )? ( (otherlv_5= '{' otherlv_6= '}' ) | otherlv_7= ';' ) ) ;
    public final EObject ruleEnumerationLiteralCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        AntlrDatatypeRuleToken lv_value_4_0 = null;


         enterRule();

        try {
            // InternalQVTbase.g:886:28: ( ( ( (otherlv_0= 'literal' ( (lv_name_1_0= ruleUnrestrictedName ) ) ) | ( (lv_name_2_0= ruleEnumerationLiteralName ) ) ) (otherlv_3= '=' ( (lv_value_4_0= ruleSIGNED ) ) )? ( (otherlv_5= '{' otherlv_6= '}' ) | otherlv_7= ';' ) ) )
            // InternalQVTbase.g:887:1: ( ( (otherlv_0= 'literal' ( (lv_name_1_0= ruleUnrestrictedName ) ) ) | ( (lv_name_2_0= ruleEnumerationLiteralName ) ) ) (otherlv_3= '=' ( (lv_value_4_0= ruleSIGNED ) ) )? ( (otherlv_5= '{' otherlv_6= '}' ) | otherlv_7= ';' ) )
            {
            // InternalQVTbase.g:887:1: ( ( (otherlv_0= 'literal' ( (lv_name_1_0= ruleUnrestrictedName ) ) ) | ( (lv_name_2_0= ruleEnumerationLiteralName ) ) ) (otherlv_3= '=' ( (lv_value_4_0= ruleSIGNED ) ) )? ( (otherlv_5= '{' otherlv_6= '}' ) | otherlv_7= ';' ) )
            // InternalQVTbase.g:887:2: ( (otherlv_0= 'literal' ( (lv_name_1_0= ruleUnrestrictedName ) ) ) | ( (lv_name_2_0= ruleEnumerationLiteralName ) ) ) (otherlv_3= '=' ( (lv_value_4_0= ruleSIGNED ) ) )? ( (otherlv_5= '{' otherlv_6= '}' ) | otherlv_7= ';' )
            {
            // InternalQVTbase.g:887:2: ( (otherlv_0= 'literal' ( (lv_name_1_0= ruleUnrestrictedName ) ) ) | ( (lv_name_2_0= ruleEnumerationLiteralName ) ) )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==49) ) {
                alt28=1;
            }
            else if ( ((LA28_0>=RULE_SIMPLE_ID && LA28_0<=RULE_ESCAPED_ID)) ) {
                alt28=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // InternalQVTbase.g:887:3: (otherlv_0= 'literal' ( (lv_name_1_0= ruleUnrestrictedName ) ) )
                    {
                    // InternalQVTbase.g:887:3: (otherlv_0= 'literal' ( (lv_name_1_0= ruleUnrestrictedName ) ) )
                    // InternalQVTbase.g:887:5: otherlv_0= 'literal' ( (lv_name_1_0= ruleUnrestrictedName ) )
                    {
                    otherlv_0=(Token)match(input,49,FollowSets000.FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getEnumerationLiteralCSAccess().getLiteralKeyword_0_0_0());

                    }
                    // InternalQVTbase.g:891:1: ( (lv_name_1_0= ruleUnrestrictedName ) )
                    // InternalQVTbase.g:892:1: (lv_name_1_0= ruleUnrestrictedName )
                    {
                    // InternalQVTbase.g:892:1: (lv_name_1_0= ruleUnrestrictedName )
                    // InternalQVTbase.g:893:3: lv_name_1_0= ruleUnrestrictedName
                    {
                    if ( state.backtracking==0 ) {

                      	        newCompositeNode(grammarAccess.getEnumerationLiteralCSAccess().getNameUnrestrictedNameParserRuleCall_0_0_1_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_8);
                    lv_name_1_0=ruleUnrestrictedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getEnumerationLiteralCSRule());
                      	        }
                             		set(
                             			current,
                             			"name",
                              		lv_name_1_0,
                              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.UnrestrictedName");
                      	        afterParserOrEnumRuleCall();

                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalQVTbase.g:910:6: ( (lv_name_2_0= ruleEnumerationLiteralName ) )
                    {
                    // InternalQVTbase.g:910:6: ( (lv_name_2_0= ruleEnumerationLiteralName ) )
                    // InternalQVTbase.g:911:1: (lv_name_2_0= ruleEnumerationLiteralName )
                    {
                    // InternalQVTbase.g:911:1: (lv_name_2_0= ruleEnumerationLiteralName )
                    // InternalQVTbase.g:912:3: lv_name_2_0= ruleEnumerationLiteralName
                    {
                    if ( state.backtracking==0 ) {

                      	        newCompositeNode(grammarAccess.getEnumerationLiteralCSAccess().getNameEnumerationLiteralNameParserRuleCall_0_1_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_8);
                    lv_name_2_0=ruleEnumerationLiteralName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getEnumerationLiteralCSRule());
                      	        }
                             		set(
                             			current,
                             			"name",
                              		lv_name_2_0,
                              		"org.eclipse.qvtd.xtext.qvtbase.QVTbase.EnumerationLiteralName");
                      	        afterParserOrEnumRuleCall();

                    }

                    }


                    }


                    }
                    break;

            }

            // InternalQVTbase.g:928:3: (otherlv_3= '=' ( (lv_value_4_0= ruleSIGNED ) ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==21) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalQVTbase.g:928:5: otherlv_3= '=' ( (lv_value_4_0= ruleSIGNED ) )
                    {
                    otherlv_3=(Token)match(input,21,FollowSets000.FOLLOW_25); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getEnumerationLiteralCSAccess().getEqualsSignKeyword_1_0());

                    }
                    // InternalQVTbase.g:932:1: ( (lv_value_4_0= ruleSIGNED ) )
                    // InternalQVTbase.g:933:1: (lv_value_4_0= ruleSIGNED )
                    {
                    // InternalQVTbase.g:933:1: (lv_value_4_0= ruleSIGNED )
                    // InternalQVTbase.g:934:3: lv_value_4_0= ruleSIGNED
                    {
                    if ( state.backtracking==0 ) {

                      	        newCompositeNode(grammarAccess.getEnumerationLiteralCSAccess().getValueSIGNEDParserRuleCall_1_1_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_10);
                    lv_value_4_0=ruleSIGNED();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getEnumerationLiteralCSRule());
                      	        }
                             		set(
                             			current,
                             			"value",
                              		lv_value_4_0,
                              		"org.eclipse.qvtd.xtext.qvtbase.QVTbase.SIGNED");
                      	        afterParserOrEnumRuleCall();

                    }

                    }


                    }


                    }
                    break;

            }

            // InternalQVTbase.g:950:4: ( (otherlv_5= '{' otherlv_6= '}' ) | otherlv_7= ';' )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==22) ) {
                alt30=1;
            }
            else if ( (LA30_0==42) ) {
                alt30=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // InternalQVTbase.g:950:5: (otherlv_5= '{' otherlv_6= '}' )
                    {
                    // InternalQVTbase.g:950:5: (otherlv_5= '{' otherlv_6= '}' )
                    // InternalQVTbase.g:950:7: otherlv_5= '{' otherlv_6= '}'
                    {
                    otherlv_5=(Token)match(input,22,FollowSets000.FOLLOW_23); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getEnumerationLiteralCSAccess().getLeftCurlyBracketKeyword_2_0_0());

                    }
                    otherlv_6=(Token)match(input,40,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getEnumerationLiteralCSAccess().getRightCurlyBracketKeyword_2_0_1());

                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalQVTbase.g:959:7: otherlv_7= ';'
                    {
                    otherlv_7=(Token)match(input,42,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getEnumerationLiteralCSAccess().getSemicolonKeyword_2_1());

                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEnumerationLiteralCS"


    // $ANTLR start "entryRuleOperationCS"
    // InternalQVTbase.g:971:1: entryRuleOperationCS returns [EObject current=null] : iv_ruleOperationCS= ruleOperationCS EOF ;
    public final EObject entryRuleOperationCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationCS = null;


        try {
            // InternalQVTbase.g:972:2: (iv_ruleOperationCS= ruleOperationCS EOF )
            // InternalQVTbase.g:973:2: iv_ruleOperationCS= ruleOperationCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOperationCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleOperationCS=ruleOperationCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOperationCS;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOperationCS"


    // $ANTLR start "ruleOperationCS"
    // InternalQVTbase.g:980:1: ruleOperationCS returns [EObject current=null] : ( ( ( ( (lv_qualifiers_0_0= 'static' ) ) ( (lv_qualifiers_1_0= 'definition' ) )? ) | ( ( (lv_qualifiers_2_0= 'definition' ) ) ( (lv_qualifiers_3_0= 'static' ) )? ) )? otherlv_4= 'operation' ( (lv_ownedSignature_5_0= ruleTemplateSignatureCS ) )? ( (lv_name_6_0= ruleUnrestrictedName ) ) otherlv_7= '(' ( ( (lv_ownedParameters_8_0= ruleParameterCS ) ) (otherlv_9= ',' ( (lv_ownedParameters_10_0= ruleParameterCS ) ) )* )? otherlv_11= ')' (otherlv_12= ':' ( (lv_ownedType_13_0= ruleTypedMultiplicityRefCS ) ) )? (otherlv_14= 'throws' ( (lv_ownedExceptions_15_0= ruleTypedRefCS ) ) (otherlv_16= ',' ( (lv_ownedExceptions_17_0= ruleTypedRefCS ) ) )* )? (otherlv_18= '{' ( ( ( (lv_qualifiers_19_0= 'derived' ) ) | ( (lv_qualifiers_20_0= '!derived' ) ) | ( (lv_qualifiers_21_0= 'ordered' ) ) | ( (lv_qualifiers_22_0= '!ordered' ) ) | ( (lv_qualifiers_23_0= 'unique' ) ) | ( (lv_qualifiers_24_0= '!unique' ) ) ) (otherlv_25= ',' )? )+ otherlv_26= '}' )? ( (otherlv_27= '{' (otherlv_28= 'body' ( ruleUnrestrictedName )? otherlv_30= ':' ( (lv_ownedBodyExpressions_31_0= ruleSpecificationCS ) )? otherlv_32= ';' )* otherlv_33= '}' ) | otherlv_34= ';' ) ) ;
    public final EObject ruleOperationCS() throws RecognitionException {
        EObject current = null;

        Token lv_qualifiers_0_0=null;
        Token lv_qualifiers_1_0=null;
        Token lv_qualifiers_2_0=null;
        Token lv_qualifiers_3_0=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        Token lv_qualifiers_19_0=null;
        Token lv_qualifiers_20_0=null;
        Token lv_qualifiers_21_0=null;
        Token lv_qualifiers_22_0=null;
        Token lv_qualifiers_23_0=null;
        Token lv_qualifiers_24_0=null;
        Token otherlv_25=null;
        Token otherlv_26=null;
        Token otherlv_27=null;
        Token otherlv_28=null;
        Token otherlv_30=null;
        Token otherlv_32=null;
        Token otherlv_33=null;
        Token otherlv_34=null;
        EObject lv_ownedSignature_5_0 = null;

        AntlrDatatypeRuleToken lv_name_6_0 = null;

        EObject lv_ownedParameters_8_0 = null;

        EObject lv_ownedParameters_10_0 = null;

        EObject lv_ownedType_13_0 = null;

        EObject lv_ownedExceptions_15_0 = null;

        EObject lv_ownedExceptions_17_0 = null;

        EObject lv_ownedBodyExpressions_31_0 = null;


         enterRule();

        try {
            // InternalQVTbase.g:983:28: ( ( ( ( ( (lv_qualifiers_0_0= 'static' ) ) ( (lv_qualifiers_1_0= 'definition' ) )? ) | ( ( (lv_qualifiers_2_0= 'definition' ) ) ( (lv_qualifiers_3_0= 'static' ) )? ) )? otherlv_4= 'operation' ( (lv_ownedSignature_5_0= ruleTemplateSignatureCS ) )? ( (lv_name_6_0= ruleUnrestrictedName ) ) otherlv_7= '(' ( ( (lv_ownedParameters_8_0= ruleParameterCS ) ) (otherlv_9= ',' ( (lv_ownedParameters_10_0= ruleParameterCS ) ) )* )? otherlv_11= ')' (otherlv_12= ':' ( (lv_ownedType_13_0= ruleTypedMultiplicityRefCS ) ) )? (otherlv_14= 'throws' ( (lv_ownedExceptions_15_0= ruleTypedRefCS ) ) (otherlv_16= ',' ( (lv_ownedExceptions_17_0= ruleTypedRefCS ) ) )* )? (otherlv_18= '{' ( ( ( (lv_qualifiers_19_0= 'derived' ) ) | ( (lv_qualifiers_20_0= '!derived' ) ) | ( (lv_qualifiers_21_0= 'ordered' ) ) | ( (lv_qualifiers_22_0= '!ordered' ) ) | ( (lv_qualifiers_23_0= 'unique' ) ) | ( (lv_qualifiers_24_0= '!unique' ) ) ) (otherlv_25= ',' )? )+ otherlv_26= '}' )? ( (otherlv_27= '{' (otherlv_28= 'body' ( ruleUnrestrictedName )? otherlv_30= ':' ( (lv_ownedBodyExpressions_31_0= ruleSpecificationCS ) )? otherlv_32= ';' )* otherlv_33= '}' ) | otherlv_34= ';' ) ) )
            // InternalQVTbase.g:984:1: ( ( ( ( (lv_qualifiers_0_0= 'static' ) ) ( (lv_qualifiers_1_0= 'definition' ) )? ) | ( ( (lv_qualifiers_2_0= 'definition' ) ) ( (lv_qualifiers_3_0= 'static' ) )? ) )? otherlv_4= 'operation' ( (lv_ownedSignature_5_0= ruleTemplateSignatureCS ) )? ( (lv_name_6_0= ruleUnrestrictedName ) ) otherlv_7= '(' ( ( (lv_ownedParameters_8_0= ruleParameterCS ) ) (otherlv_9= ',' ( (lv_ownedParameters_10_0= ruleParameterCS ) ) )* )? otherlv_11= ')' (otherlv_12= ':' ( (lv_ownedType_13_0= ruleTypedMultiplicityRefCS ) ) )? (otherlv_14= 'throws' ( (lv_ownedExceptions_15_0= ruleTypedRefCS ) ) (otherlv_16= ',' ( (lv_ownedExceptions_17_0= ruleTypedRefCS ) ) )* )? (otherlv_18= '{' ( ( ( (lv_qualifiers_19_0= 'derived' ) ) | ( (lv_qualifiers_20_0= '!derived' ) ) | ( (lv_qualifiers_21_0= 'ordered' ) ) | ( (lv_qualifiers_22_0= '!ordered' ) ) | ( (lv_qualifiers_23_0= 'unique' ) ) | ( (lv_qualifiers_24_0= '!unique' ) ) ) (otherlv_25= ',' )? )+ otherlv_26= '}' )? ( (otherlv_27= '{' (otherlv_28= 'body' ( ruleUnrestrictedName )? otherlv_30= ':' ( (lv_ownedBodyExpressions_31_0= ruleSpecificationCS ) )? otherlv_32= ';' )* otherlv_33= '}' ) | otherlv_34= ';' ) )
            {
            // InternalQVTbase.g:984:1: ( ( ( ( (lv_qualifiers_0_0= 'static' ) ) ( (lv_qualifiers_1_0= 'definition' ) )? ) | ( ( (lv_qualifiers_2_0= 'definition' ) ) ( (lv_qualifiers_3_0= 'static' ) )? ) )? otherlv_4= 'operation' ( (lv_ownedSignature_5_0= ruleTemplateSignatureCS ) )? ( (lv_name_6_0= ruleUnrestrictedName ) ) otherlv_7= '(' ( ( (lv_ownedParameters_8_0= ruleParameterCS ) ) (otherlv_9= ',' ( (lv_ownedParameters_10_0= ruleParameterCS ) ) )* )? otherlv_11= ')' (otherlv_12= ':' ( (lv_ownedType_13_0= ruleTypedMultiplicityRefCS ) ) )? (otherlv_14= 'throws' ( (lv_ownedExceptions_15_0= ruleTypedRefCS ) ) (otherlv_16= ',' ( (lv_ownedExceptions_17_0= ruleTypedRefCS ) ) )* )? (otherlv_18= '{' ( ( ( (lv_qualifiers_19_0= 'derived' ) ) | ( (lv_qualifiers_20_0= '!derived' ) ) | ( (lv_qualifiers_21_0= 'ordered' ) ) | ( (lv_qualifiers_22_0= '!ordered' ) ) | ( (lv_qualifiers_23_0= 'unique' ) ) | ( (lv_qualifiers_24_0= '!unique' ) ) ) (otherlv_25= ',' )? )+ otherlv_26= '}' )? ( (otherlv_27= '{' (otherlv_28= 'body' ( ruleUnrestrictedName )? otherlv_30= ':' ( (lv_ownedBodyExpressions_31_0= ruleSpecificationCS ) )? otherlv_32= ';' )* otherlv_33= '}' ) | otherlv_34= ';' ) )
            // InternalQVTbase.g:984:2: ( ( ( (lv_qualifiers_0_0= 'static' ) ) ( (lv_qualifiers_1_0= 'definition' ) )? ) | ( ( (lv_qualifiers_2_0= 'definition' ) ) ( (lv_qualifiers_3_0= 'static' ) )? ) )? otherlv_4= 'operation' ( (lv_ownedSignature_5_0= ruleTemplateSignatureCS ) )? ( (lv_name_6_0= ruleUnrestrictedName ) ) otherlv_7= '(' ( ( (lv_ownedParameters_8_0= ruleParameterCS ) ) (otherlv_9= ',' ( (lv_ownedParameters_10_0= ruleParameterCS ) ) )* )? otherlv_11= ')' (otherlv_12= ':' ( (lv_ownedType_13_0= ruleTypedMultiplicityRefCS ) ) )? (otherlv_14= 'throws' ( (lv_ownedExceptions_15_0= ruleTypedRefCS ) ) (otherlv_16= ',' ( (lv_ownedExceptions_17_0= ruleTypedRefCS ) ) )* )? (otherlv_18= '{' ( ( ( (lv_qualifiers_19_0= 'derived' ) ) | ( (lv_qualifiers_20_0= '!derived' ) ) | ( (lv_qualifiers_21_0= 'ordered' ) ) | ( (lv_qualifiers_22_0= '!ordered' ) ) | ( (lv_qualifiers_23_0= 'unique' ) ) | ( (lv_qualifiers_24_0= '!unique' ) ) ) (otherlv_25= ',' )? )+ otherlv_26= '}' )? ( (otherlv_27= '{' (otherlv_28= 'body' ( ruleUnrestrictedName )? otherlv_30= ':' ( (lv_ownedBodyExpressions_31_0= ruleSpecificationCS ) )? otherlv_32= ';' )* otherlv_33= '}' ) | otherlv_34= ';' )
            {
            // InternalQVTbase.g:984:2: ( ( ( (lv_qualifiers_0_0= 'static' ) ) ( (lv_qualifiers_1_0= 'definition' ) )? ) | ( ( (lv_qualifiers_2_0= 'definition' ) ) ( (lv_qualifiers_3_0= 'static' ) )? ) )?
            int alt33=3;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==17) ) {
                alt33=1;
            }
            else if ( (LA33_0==18) ) {
                alt33=2;
            }
            switch (alt33) {
                case 1 :
                    // InternalQVTbase.g:984:3: ( ( (lv_qualifiers_0_0= 'static' ) ) ( (lv_qualifiers_1_0= 'definition' ) )? )
                    {
                    // InternalQVTbase.g:984:3: ( ( (lv_qualifiers_0_0= 'static' ) ) ( (lv_qualifiers_1_0= 'definition' ) )? )
                    // InternalQVTbase.g:984:4: ( (lv_qualifiers_0_0= 'static' ) ) ( (lv_qualifiers_1_0= 'definition' ) )?
                    {
                    // InternalQVTbase.g:984:4: ( (lv_qualifiers_0_0= 'static' ) )
                    // InternalQVTbase.g:985:1: (lv_qualifiers_0_0= 'static' )
                    {
                    // InternalQVTbase.g:985:1: (lv_qualifiers_0_0= 'static' )
                    // InternalQVTbase.g:986:3: lv_qualifiers_0_0= 'static'
                    {
                    lv_qualifiers_0_0=(Token)match(input,17,FollowSets000.FOLLOW_26); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_qualifiers_0_0, grammarAccess.getOperationCSAccess().getQualifiersStaticKeyword_0_0_0_0());

                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getOperationCSRule());
                      	        }
                             		addWithLastConsumed(current, "qualifiers", lv_qualifiers_0_0, "static");

                    }

                    }


                    }

                    // InternalQVTbase.g:999:2: ( (lv_qualifiers_1_0= 'definition' ) )?
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==18) ) {
                        alt31=1;
                    }
                    switch (alt31) {
                        case 1 :
                            // InternalQVTbase.g:1000:1: (lv_qualifiers_1_0= 'definition' )
                            {
                            // InternalQVTbase.g:1000:1: (lv_qualifiers_1_0= 'definition' )
                            // InternalQVTbase.g:1001:3: lv_qualifiers_1_0= 'definition'
                            {
                            lv_qualifiers_1_0=(Token)match(input,18,FollowSets000.FOLLOW_27); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_qualifiers_1_0, grammarAccess.getOperationCSAccess().getQualifiersDefinitionKeyword_0_0_1_0());

                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getOperationCSRule());
                              	        }
                                     		addWithLastConsumed(current, "qualifiers", lv_qualifiers_1_0, "definition");

                            }

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalQVTbase.g:1015:6: ( ( (lv_qualifiers_2_0= 'definition' ) ) ( (lv_qualifiers_3_0= 'static' ) )? )
                    {
                    // InternalQVTbase.g:1015:6: ( ( (lv_qualifiers_2_0= 'definition' ) ) ( (lv_qualifiers_3_0= 'static' ) )? )
                    // InternalQVTbase.g:1015:7: ( (lv_qualifiers_2_0= 'definition' ) ) ( (lv_qualifiers_3_0= 'static' ) )?
                    {
                    // InternalQVTbase.g:1015:7: ( (lv_qualifiers_2_0= 'definition' ) )
                    // InternalQVTbase.g:1016:1: (lv_qualifiers_2_0= 'definition' )
                    {
                    // InternalQVTbase.g:1016:1: (lv_qualifiers_2_0= 'definition' )
                    // InternalQVTbase.g:1017:3: lv_qualifiers_2_0= 'definition'
                    {
                    lv_qualifiers_2_0=(Token)match(input,18,FollowSets000.FOLLOW_28); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_qualifiers_2_0, grammarAccess.getOperationCSAccess().getQualifiersDefinitionKeyword_0_1_0_0());

                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getOperationCSRule());
                      	        }
                             		addWithLastConsumed(current, "qualifiers", lv_qualifiers_2_0, "definition");

                    }

                    }


                    }

                    // InternalQVTbase.g:1030:2: ( (lv_qualifiers_3_0= 'static' ) )?
                    int alt32=2;
                    int LA32_0 = input.LA(1);

                    if ( (LA32_0==17) ) {
                        alt32=1;
                    }
                    switch (alt32) {
                        case 1 :
                            // InternalQVTbase.g:1031:1: (lv_qualifiers_3_0= 'static' )
                            {
                            // InternalQVTbase.g:1031:1: (lv_qualifiers_3_0= 'static' )
                            // InternalQVTbase.g:1032:3: lv_qualifiers_3_0= 'static'
                            {
                            lv_qualifiers_3_0=(Token)match(input,17,FollowSets000.FOLLOW_27); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_qualifiers_3_0, grammarAccess.getOperationCSAccess().getQualifiersStaticKeyword_0_1_1_0());

                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getOperationCSRule());
                              	        }
                                     		addWithLastConsumed(current, "qualifiers", lv_qualifiers_3_0, "static");

                            }

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,50,FollowSets000.FOLLOW_29); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getOperationCSAccess().getOperationKeyword_1());

            }
            // InternalQVTbase.g:1049:1: ( (lv_ownedSignature_5_0= ruleTemplateSignatureCS ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==51) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalQVTbase.g:1050:1: (lv_ownedSignature_5_0= ruleTemplateSignatureCS )
                    {
                    // InternalQVTbase.g:1050:1: (lv_ownedSignature_5_0= ruleTemplateSignatureCS )
                    // InternalQVTbase.g:1051:3: lv_ownedSignature_5_0= ruleTemplateSignatureCS
                    {
                    if ( state.backtracking==0 ) {

                      	        newCompositeNode(grammarAccess.getOperationCSAccess().getOwnedSignatureTemplateSignatureCSParserRuleCall_2_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_6);
                    lv_ownedSignature_5_0=ruleTemplateSignatureCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getOperationCSRule());
                      	        }
                             		set(
                             			current,
                             			"ownedSignature",
                              		lv_ownedSignature_5_0,
                              		"org.eclipse.ocl.xtext.base.Base.TemplateSignatureCS");
                      	        afterParserOrEnumRuleCall();

                    }

                    }


                    }
                    break;

            }

            // InternalQVTbase.g:1067:3: ( (lv_name_6_0= ruleUnrestrictedName ) )
            // InternalQVTbase.g:1068:1: (lv_name_6_0= ruleUnrestrictedName )
            {
            // InternalQVTbase.g:1068:1: (lv_name_6_0= ruleUnrestrictedName )
            // InternalQVTbase.g:1069:3: lv_name_6_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {

              	        newCompositeNode(grammarAccess.getOperationCSAccess().getNameUnrestrictedNameParserRuleCall_3_0());

            }
            pushFollow(FollowSets000.FOLLOW_30);
            lv_name_6_0=ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getOperationCSRule());
              	        }
                     		set(
                     			current,
                     			"name",
                      		lv_name_6_0,
                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.UnrestrictedName");
              	        afterParserOrEnumRuleCall();

            }

            }


            }

            otherlv_7=(Token)match(input,51,FollowSets000.FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getOperationCSAccess().getLeftParenthesisKeyword_4());

            }
            // InternalQVTbase.g:1089:1: ( ( (lv_ownedParameters_8_0= ruleParameterCS ) ) (otherlv_9= ',' ( (lv_ownedParameters_10_0= ruleParameterCS ) ) )* )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( ((LA36_0>=RULE_SIMPLE_ID && LA36_0<=RULE_ESCAPED_ID)) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalQVTbase.g:1089:2: ( (lv_ownedParameters_8_0= ruleParameterCS ) ) (otherlv_9= ',' ( (lv_ownedParameters_10_0= ruleParameterCS ) ) )*
                    {
                    // InternalQVTbase.g:1089:2: ( (lv_ownedParameters_8_0= ruleParameterCS ) )
                    // InternalQVTbase.g:1090:1: (lv_ownedParameters_8_0= ruleParameterCS )
                    {
                    // InternalQVTbase.g:1090:1: (lv_ownedParameters_8_0= ruleParameterCS )
                    // InternalQVTbase.g:1091:3: lv_ownedParameters_8_0= ruleParameterCS
                    {
                    if ( state.backtracking==0 ) {

                      	        newCompositeNode(grammarAccess.getOperationCSAccess().getOwnedParametersParameterCSParserRuleCall_5_0_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_32);
                    lv_ownedParameters_8_0=ruleParameterCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getOperationCSRule());
                      	        }
                             		add(
                             			current,
                             			"ownedParameters",
                              		lv_ownedParameters_8_0,
                              		"org.eclipse.qvtd.xtext.qvtbase.QVTbase.ParameterCS");
                      	        afterParserOrEnumRuleCall();

                    }

                    }


                    }

                    // InternalQVTbase.g:1107:2: (otherlv_9= ',' ( (lv_ownedParameters_10_0= ruleParameterCS ) ) )*
                    loop35:
                    do {
                        int alt35=2;
                        int LA35_0 = input.LA(1);

                        if ( (LA35_0==39) ) {
                            alt35=1;
                        }


                        switch (alt35) {
                    	case 1 :
                    	    // InternalQVTbase.g:1107:4: otherlv_9= ',' ( (lv_ownedParameters_10_0= ruleParameterCS ) )
                    	    {
                    	    otherlv_9=(Token)match(input,39,FollowSets000.FOLLOW_6); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_9, grammarAccess.getOperationCSAccess().getCommaKeyword_5_1_0());

                    	    }
                    	    // InternalQVTbase.g:1111:1: ( (lv_ownedParameters_10_0= ruleParameterCS ) )
                    	    // InternalQVTbase.g:1112:1: (lv_ownedParameters_10_0= ruleParameterCS )
                    	    {
                    	    // InternalQVTbase.g:1112:1: (lv_ownedParameters_10_0= ruleParameterCS )
                    	    // InternalQVTbase.g:1113:3: lv_ownedParameters_10_0= ruleParameterCS
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      	        newCompositeNode(grammarAccess.getOperationCSAccess().getOwnedParametersParameterCSParserRuleCall_5_1_1_0());

                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_32);
                    	    lv_ownedParameters_10_0=ruleParameterCS();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getOperationCSRule());
                    	      	        }
                    	             		add(
                    	             			current,
                    	             			"ownedParameters",
                    	              		lv_ownedParameters_10_0,
                    	              		"org.eclipse.qvtd.xtext.qvtbase.QVTbase.ParameterCS");
                    	      	        afterParserOrEnumRuleCall();

                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop35;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_11=(Token)match(input,52,FollowSets000.FOLLOW_33); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_11, grammarAccess.getOperationCSAccess().getRightParenthesisKeyword_6());

            }
            // InternalQVTbase.g:1133:1: (otherlv_12= ':' ( (lv_ownedType_13_0= ruleTypedMultiplicityRefCS ) ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==20) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalQVTbase.g:1133:3: otherlv_12= ':' ( (lv_ownedType_13_0= ruleTypedMultiplicityRefCS ) )
                    {
                    otherlv_12=(Token)match(input,20,FollowSets000.FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_12, grammarAccess.getOperationCSAccess().getColonKeyword_7_0());

                    }
                    // InternalQVTbase.g:1137:1: ( (lv_ownedType_13_0= ruleTypedMultiplicityRefCS ) )
                    // InternalQVTbase.g:1138:1: (lv_ownedType_13_0= ruleTypedMultiplicityRefCS )
                    {
                    // InternalQVTbase.g:1138:1: (lv_ownedType_13_0= ruleTypedMultiplicityRefCS )
                    // InternalQVTbase.g:1139:3: lv_ownedType_13_0= ruleTypedMultiplicityRefCS
                    {
                    if ( state.backtracking==0 ) {

                      	        newCompositeNode(grammarAccess.getOperationCSAccess().getOwnedTypeTypedMultiplicityRefCSParserRuleCall_7_1_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_34);
                    lv_ownedType_13_0=ruleTypedMultiplicityRefCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getOperationCSRule());
                      	        }
                             		set(
                             			current,
                             			"ownedType",
                              		lv_ownedType_13_0,
                              		"org.eclipse.qvtd.xtext.qvtbase.QVTbase.TypedMultiplicityRefCS");
                      	        afterParserOrEnumRuleCall();

                    }

                    }


                    }


                    }
                    break;

            }

            // InternalQVTbase.g:1155:4: (otherlv_14= 'throws' ( (lv_ownedExceptions_15_0= ruleTypedRefCS ) ) (otherlv_16= ',' ( (lv_ownedExceptions_17_0= ruleTypedRefCS ) ) )* )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==53) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalQVTbase.g:1155:6: otherlv_14= 'throws' ( (lv_ownedExceptions_15_0= ruleTypedRefCS ) ) (otherlv_16= ',' ( (lv_ownedExceptions_17_0= ruleTypedRefCS ) ) )*
                    {
                    otherlv_14=(Token)match(input,53,FollowSets000.FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_14, grammarAccess.getOperationCSAccess().getThrowsKeyword_8_0());

                    }
                    // InternalQVTbase.g:1159:1: ( (lv_ownedExceptions_15_0= ruleTypedRefCS ) )
                    // InternalQVTbase.g:1160:1: (lv_ownedExceptions_15_0= ruleTypedRefCS )
                    {
                    // InternalQVTbase.g:1160:1: (lv_ownedExceptions_15_0= ruleTypedRefCS )
                    // InternalQVTbase.g:1161:3: lv_ownedExceptions_15_0= ruleTypedRefCS
                    {
                    if ( state.backtracking==0 ) {

                      	        newCompositeNode(grammarAccess.getOperationCSAccess().getOwnedExceptionsTypedRefCSParserRuleCall_8_1_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_35);
                    lv_ownedExceptions_15_0=ruleTypedRefCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getOperationCSRule());
                      	        }
                             		add(
                             			current,
                             			"ownedExceptions",
                              		lv_ownedExceptions_15_0,
                              		"org.eclipse.ocl.xtext.base.Base.TypedRefCS");
                      	        afterParserOrEnumRuleCall();

                    }

                    }


                    }

                    // InternalQVTbase.g:1177:2: (otherlv_16= ',' ( (lv_ownedExceptions_17_0= ruleTypedRefCS ) ) )*
                    loop38:
                    do {
                        int alt38=2;
                        int LA38_0 = input.LA(1);

                        if ( (LA38_0==39) ) {
                            alt38=1;
                        }


                        switch (alt38) {
                    	case 1 :
                    	    // InternalQVTbase.g:1177:4: otherlv_16= ',' ( (lv_ownedExceptions_17_0= ruleTypedRefCS ) )
                    	    {
                    	    otherlv_16=(Token)match(input,39,FollowSets000.FOLLOW_6); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_16, grammarAccess.getOperationCSAccess().getCommaKeyword_8_2_0());

                    	    }
                    	    // InternalQVTbase.g:1181:1: ( (lv_ownedExceptions_17_0= ruleTypedRefCS ) )
                    	    // InternalQVTbase.g:1182:1: (lv_ownedExceptions_17_0= ruleTypedRefCS )
                    	    {
                    	    // InternalQVTbase.g:1182:1: (lv_ownedExceptions_17_0= ruleTypedRefCS )
                    	    // InternalQVTbase.g:1183:3: lv_ownedExceptions_17_0= ruleTypedRefCS
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      	        newCompositeNode(grammarAccess.getOperationCSAccess().getOwnedExceptionsTypedRefCSParserRuleCall_8_2_1_0());

                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_35);
                    	    lv_ownedExceptions_17_0=ruleTypedRefCS();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getOperationCSRule());
                    	      	        }
                    	             		add(
                    	             			current,
                    	             			"ownedExceptions",
                    	              		lv_ownedExceptions_17_0,
                    	              		"org.eclipse.ocl.xtext.base.Base.TypedRefCS");
                    	      	        afterParserOrEnumRuleCall();

                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop38;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalQVTbase.g:1199:6: (otherlv_18= '{' ( ( ( (lv_qualifiers_19_0= 'derived' ) ) | ( (lv_qualifiers_20_0= '!derived' ) ) | ( (lv_qualifiers_21_0= 'ordered' ) ) | ( (lv_qualifiers_22_0= '!ordered' ) ) | ( (lv_qualifiers_23_0= 'unique' ) ) | ( (lv_qualifiers_24_0= '!unique' ) ) ) (otherlv_25= ',' )? )+ otherlv_26= '}' )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==22) ) {
                int LA43_1 = input.LA(2);

                if ( ((LA43_1>=23 && LA43_1<=24)||(LA43_1>=27 && LA43_1<=28)||(LA43_1>=33 && LA43_1<=34)) ) {
                    alt43=1;
                }
            }
            switch (alt43) {
                case 1 :
                    // InternalQVTbase.g:1199:8: otherlv_18= '{' ( ( ( (lv_qualifiers_19_0= 'derived' ) ) | ( (lv_qualifiers_20_0= '!derived' ) ) | ( (lv_qualifiers_21_0= 'ordered' ) ) | ( (lv_qualifiers_22_0= '!ordered' ) ) | ( (lv_qualifiers_23_0= 'unique' ) ) | ( (lv_qualifiers_24_0= '!unique' ) ) ) (otherlv_25= ',' )? )+ otherlv_26= '}'
                    {
                    otherlv_18=(Token)match(input,22,FollowSets000.FOLLOW_36); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_18, grammarAccess.getOperationCSAccess().getLeftCurlyBracketKeyword_9_0());

                    }
                    // InternalQVTbase.g:1203:1: ( ( ( (lv_qualifiers_19_0= 'derived' ) ) | ( (lv_qualifiers_20_0= '!derived' ) ) | ( (lv_qualifiers_21_0= 'ordered' ) ) | ( (lv_qualifiers_22_0= '!ordered' ) ) | ( (lv_qualifiers_23_0= 'unique' ) ) | ( (lv_qualifiers_24_0= '!unique' ) ) ) (otherlv_25= ',' )? )+
                    int cnt42=0;
                    loop42:
                    do {
                        int alt42=2;
                        int LA42_0 = input.LA(1);

                        if ( ((LA42_0>=23 && LA42_0<=24)||(LA42_0>=27 && LA42_0<=28)||(LA42_0>=33 && LA42_0<=34)) ) {
                            alt42=1;
                        }


                        switch (alt42) {
                    	case 1 :
                    	    // InternalQVTbase.g:1203:2: ( ( (lv_qualifiers_19_0= 'derived' ) ) | ( (lv_qualifiers_20_0= '!derived' ) ) | ( (lv_qualifiers_21_0= 'ordered' ) ) | ( (lv_qualifiers_22_0= '!ordered' ) ) | ( (lv_qualifiers_23_0= 'unique' ) ) | ( (lv_qualifiers_24_0= '!unique' ) ) ) (otherlv_25= ',' )?
                    	    {
                    	    // InternalQVTbase.g:1203:2: ( ( (lv_qualifiers_19_0= 'derived' ) ) | ( (lv_qualifiers_20_0= '!derived' ) ) | ( (lv_qualifiers_21_0= 'ordered' ) ) | ( (lv_qualifiers_22_0= '!ordered' ) ) | ( (lv_qualifiers_23_0= 'unique' ) ) | ( (lv_qualifiers_24_0= '!unique' ) ) )
                    	    int alt40=6;
                    	    switch ( input.LA(1) ) {
                    	    case 23:
                    	        {
                    	        alt40=1;
                    	        }
                    	        break;
                    	    case 24:
                    	        {
                    	        alt40=2;
                    	        }
                    	        break;
                    	    case 27:
                    	        {
                    	        alt40=3;
                    	        }
                    	        break;
                    	    case 28:
                    	        {
                    	        alt40=4;
                    	        }
                    	        break;
                    	    case 33:
                    	        {
                    	        alt40=5;
                    	        }
                    	        break;
                    	    case 34:
                    	        {
                    	        alt40=6;
                    	        }
                    	        break;
                    	    default:
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 40, 0, input);

                    	        throw nvae;
                    	    }

                    	    switch (alt40) {
                    	        case 1 :
                    	            // InternalQVTbase.g:1203:3: ( (lv_qualifiers_19_0= 'derived' ) )
                    	            {
                    	            // InternalQVTbase.g:1203:3: ( (lv_qualifiers_19_0= 'derived' ) )
                    	            // InternalQVTbase.g:1204:1: (lv_qualifiers_19_0= 'derived' )
                    	            {
                    	            // InternalQVTbase.g:1204:1: (lv_qualifiers_19_0= 'derived' )
                    	            // InternalQVTbase.g:1205:3: lv_qualifiers_19_0= 'derived'
                    	            {
                    	            lv_qualifiers_19_0=(Token)match(input,23,FollowSets000.FOLLOW_37); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	                      newLeafNode(lv_qualifiers_19_0, grammarAccess.getOperationCSAccess().getQualifiersDerivedKeyword_9_1_0_0_0());

                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElement(grammarAccess.getOperationCSRule());
                    	              	        }
                    	                     		addWithLastConsumed(current, "qualifiers", lv_qualifiers_19_0, "derived");

                    	            }

                    	            }


                    	            }


                    	            }
                    	            break;
                    	        case 2 :
                    	            // InternalQVTbase.g:1219:6: ( (lv_qualifiers_20_0= '!derived' ) )
                    	            {
                    	            // InternalQVTbase.g:1219:6: ( (lv_qualifiers_20_0= '!derived' ) )
                    	            // InternalQVTbase.g:1220:1: (lv_qualifiers_20_0= '!derived' )
                    	            {
                    	            // InternalQVTbase.g:1220:1: (lv_qualifiers_20_0= '!derived' )
                    	            // InternalQVTbase.g:1221:3: lv_qualifiers_20_0= '!derived'
                    	            {
                    	            lv_qualifiers_20_0=(Token)match(input,24,FollowSets000.FOLLOW_37); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	                      newLeafNode(lv_qualifiers_20_0, grammarAccess.getOperationCSAccess().getQualifiersDerivedKeyword_9_1_0_1_0());

                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElement(grammarAccess.getOperationCSRule());
                    	              	        }
                    	                     		addWithLastConsumed(current, "qualifiers", lv_qualifiers_20_0, "!derived");

                    	            }

                    	            }


                    	            }


                    	            }
                    	            break;
                    	        case 3 :
                    	            // InternalQVTbase.g:1235:6: ( (lv_qualifiers_21_0= 'ordered' ) )
                    	            {
                    	            // InternalQVTbase.g:1235:6: ( (lv_qualifiers_21_0= 'ordered' ) )
                    	            // InternalQVTbase.g:1236:1: (lv_qualifiers_21_0= 'ordered' )
                    	            {
                    	            // InternalQVTbase.g:1236:1: (lv_qualifiers_21_0= 'ordered' )
                    	            // InternalQVTbase.g:1237:3: lv_qualifiers_21_0= 'ordered'
                    	            {
                    	            lv_qualifiers_21_0=(Token)match(input,27,FollowSets000.FOLLOW_37); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	                      newLeafNode(lv_qualifiers_21_0, grammarAccess.getOperationCSAccess().getQualifiersOrderedKeyword_9_1_0_2_0());

                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElement(grammarAccess.getOperationCSRule());
                    	              	        }
                    	                     		addWithLastConsumed(current, "qualifiers", lv_qualifiers_21_0, "ordered");

                    	            }

                    	            }


                    	            }


                    	            }
                    	            break;
                    	        case 4 :
                    	            // InternalQVTbase.g:1251:6: ( (lv_qualifiers_22_0= '!ordered' ) )
                    	            {
                    	            // InternalQVTbase.g:1251:6: ( (lv_qualifiers_22_0= '!ordered' ) )
                    	            // InternalQVTbase.g:1252:1: (lv_qualifiers_22_0= '!ordered' )
                    	            {
                    	            // InternalQVTbase.g:1252:1: (lv_qualifiers_22_0= '!ordered' )
                    	            // InternalQVTbase.g:1253:3: lv_qualifiers_22_0= '!ordered'
                    	            {
                    	            lv_qualifiers_22_0=(Token)match(input,28,FollowSets000.FOLLOW_37); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	                      newLeafNode(lv_qualifiers_22_0, grammarAccess.getOperationCSAccess().getQualifiersOrderedKeyword_9_1_0_3_0());

                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElement(grammarAccess.getOperationCSRule());
                    	              	        }
                    	                     		addWithLastConsumed(current, "qualifiers", lv_qualifiers_22_0, "!ordered");

                    	            }

                    	            }


                    	            }


                    	            }
                    	            break;
                    	        case 5 :
                    	            // InternalQVTbase.g:1267:6: ( (lv_qualifiers_23_0= 'unique' ) )
                    	            {
                    	            // InternalQVTbase.g:1267:6: ( (lv_qualifiers_23_0= 'unique' ) )
                    	            // InternalQVTbase.g:1268:1: (lv_qualifiers_23_0= 'unique' )
                    	            {
                    	            // InternalQVTbase.g:1268:1: (lv_qualifiers_23_0= 'unique' )
                    	            // InternalQVTbase.g:1269:3: lv_qualifiers_23_0= 'unique'
                    	            {
                    	            lv_qualifiers_23_0=(Token)match(input,33,FollowSets000.FOLLOW_37); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	                      newLeafNode(lv_qualifiers_23_0, grammarAccess.getOperationCSAccess().getQualifiersUniqueKeyword_9_1_0_4_0());

                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElement(grammarAccess.getOperationCSRule());
                    	              	        }
                    	                     		addWithLastConsumed(current, "qualifiers", lv_qualifiers_23_0, "unique");

                    	            }

                    	            }


                    	            }


                    	            }
                    	            break;
                    	        case 6 :
                    	            // InternalQVTbase.g:1283:6: ( (lv_qualifiers_24_0= '!unique' ) )
                    	            {
                    	            // InternalQVTbase.g:1283:6: ( (lv_qualifiers_24_0= '!unique' ) )
                    	            // InternalQVTbase.g:1284:1: (lv_qualifiers_24_0= '!unique' )
                    	            {
                    	            // InternalQVTbase.g:1284:1: (lv_qualifiers_24_0= '!unique' )
                    	            // InternalQVTbase.g:1285:3: lv_qualifiers_24_0= '!unique'
                    	            {
                    	            lv_qualifiers_24_0=(Token)match(input,34,FollowSets000.FOLLOW_37); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	                      newLeafNode(lv_qualifiers_24_0, grammarAccess.getOperationCSAccess().getQualifiersUniqueKeyword_9_1_0_5_0());

                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElement(grammarAccess.getOperationCSRule());
                    	              	        }
                    	                     		addWithLastConsumed(current, "qualifiers", lv_qualifiers_24_0, "!unique");

                    	            }

                    	            }


                    	            }


                    	            }
                    	            break;

                    	    }

                    	    // InternalQVTbase.g:1298:3: (otherlv_25= ',' )?
                    	    int alt41=2;
                    	    int LA41_0 = input.LA(1);

                    	    if ( (LA41_0==39) ) {
                    	        alt41=1;
                    	    }
                    	    switch (alt41) {
                    	        case 1 :
                    	            // InternalQVTbase.g:1298:5: otherlv_25= ','
                    	            {
                    	            otherlv_25=(Token)match(input,39,FollowSets000.FOLLOW_38); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	                  	newLeafNode(otherlv_25, grammarAccess.getOperationCSAccess().getCommaKeyword_9_1_1());

                    	            }

                    	            }
                    	            break;

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt42 >= 1 ) break loop42;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(42, input);
                                throw eee;
                        }
                        cnt42++;
                    } while (true);

                    otherlv_26=(Token)match(input,40,FollowSets000.FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_26, grammarAccess.getOperationCSAccess().getRightCurlyBracketKeyword_9_2());

                    }

                    }
                    break;

            }

            // InternalQVTbase.g:1306:3: ( (otherlv_27= '{' (otherlv_28= 'body' ( ruleUnrestrictedName )? otherlv_30= ':' ( (lv_ownedBodyExpressions_31_0= ruleSpecificationCS ) )? otherlv_32= ';' )* otherlv_33= '}' ) | otherlv_34= ';' )
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==22) ) {
                alt47=1;
            }
            else if ( (LA47_0==42) ) {
                alt47=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }
            switch (alt47) {
                case 1 :
                    // InternalQVTbase.g:1306:4: (otherlv_27= '{' (otherlv_28= 'body' ( ruleUnrestrictedName )? otherlv_30= ':' ( (lv_ownedBodyExpressions_31_0= ruleSpecificationCS ) )? otherlv_32= ';' )* otherlv_33= '}' )
                    {
                    // InternalQVTbase.g:1306:4: (otherlv_27= '{' (otherlv_28= 'body' ( ruleUnrestrictedName )? otherlv_30= ':' ( (lv_ownedBodyExpressions_31_0= ruleSpecificationCS ) )? otherlv_32= ';' )* otherlv_33= '}' )
                    // InternalQVTbase.g:1306:6: otherlv_27= '{' (otherlv_28= 'body' ( ruleUnrestrictedName )? otherlv_30= ':' ( (lv_ownedBodyExpressions_31_0= ruleSpecificationCS ) )? otherlv_32= ';' )* otherlv_33= '}'
                    {
                    otherlv_27=(Token)match(input,22,FollowSets000.FOLLOW_39); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_27, grammarAccess.getOperationCSAccess().getLeftCurlyBracketKeyword_10_0_0());

                    }
                    // InternalQVTbase.g:1310:1: (otherlv_28= 'body' ( ruleUnrestrictedName )? otherlv_30= ':' ( (lv_ownedBodyExpressions_31_0= ruleSpecificationCS ) )? otherlv_32= ';' )*
                    loop46:
                    do {
                        int alt46=2;
                        int LA46_0 = input.LA(1);

                        if ( (LA46_0==54) ) {
                            alt46=1;
                        }


                        switch (alt46) {
                    	case 1 :
                    	    // InternalQVTbase.g:1310:3: otherlv_28= 'body' ( ruleUnrestrictedName )? otherlv_30= ':' ( (lv_ownedBodyExpressions_31_0= ruleSpecificationCS ) )? otherlv_32= ';'
                    	    {
                    	    otherlv_28=(Token)match(input,54,FollowSets000.FOLLOW_15); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_28, grammarAccess.getOperationCSAccess().getBodyKeyword_10_0_1_0());

                    	    }
                    	    // InternalQVTbase.g:1314:1: ( ruleUnrestrictedName )?
                    	    int alt44=2;
                    	    int LA44_0 = input.LA(1);

                    	    if ( ((LA44_0>=RULE_SIMPLE_ID && LA44_0<=RULE_ESCAPED_ID)) ) {
                    	        alt44=1;
                    	    }
                    	    switch (alt44) {
                    	        case 1 :
                    	            // InternalQVTbase.g:1315:2: ruleUnrestrictedName
                    	            {
                    	            if ( state.backtracking==0 ) {

                    	              	  /* */

                    	            }
                    	            if ( state.backtracking==0 ) {

                    	                      newCompositeNode(grammarAccess.getOperationCSAccess().getUnrestrictedNameParserRuleCall_10_0_1_1());

                    	            }
                    	            pushFollow(FollowSets000.FOLLOW_16);
                    	            ruleUnrestrictedName();

                    	            state._fsp--;
                    	            if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	                      afterParserOrEnumRuleCall();

                    	            }

                    	            }
                    	            break;

                    	    }

                    	    otherlv_30=(Token)match(input,20,FollowSets000.FOLLOW_17); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_30, grammarAccess.getOperationCSAccess().getColonKeyword_10_0_1_2());

                    	    }
                    	    // InternalQVTbase.g:1329:1: ( (lv_ownedBodyExpressions_31_0= ruleSpecificationCS ) )?
                    	    int alt45=2;
                    	    int LA45_0 = input.LA(1);

                    	    if ( ((LA45_0>=RULE_SINGLE_QUOTED_STRING && LA45_0<=RULE_ESCAPED_ID)||LA45_0==51||(LA45_0>=65 && LA45_0<=67)||(LA45_0>=83 && LA45_0<=97)||LA45_0==100||(LA45_0>=102 && LA45_0<=105)||LA45_0==112||(LA45_0>=117 && LA45_0<=118)) ) {
                    	        alt45=1;
                    	    }
                    	    switch (alt45) {
                    	        case 1 :
                    	            // InternalQVTbase.g:1330:1: (lv_ownedBodyExpressions_31_0= ruleSpecificationCS )
                    	            {
                    	            // InternalQVTbase.g:1330:1: (lv_ownedBodyExpressions_31_0= ruleSpecificationCS )
                    	            // InternalQVTbase.g:1331:3: lv_ownedBodyExpressions_31_0= ruleSpecificationCS
                    	            {
                    	            if ( state.backtracking==0 ) {

                    	              	        newCompositeNode(grammarAccess.getOperationCSAccess().getOwnedBodyExpressionsSpecificationCSParserRuleCall_10_0_1_3_0());

                    	            }
                    	            pushFollow(FollowSets000.FOLLOW_18);
                    	            lv_ownedBodyExpressions_31_0=ruleSpecificationCS();

                    	            state._fsp--;
                    	            if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElementForParent(grammarAccess.getOperationCSRule());
                    	              	        }
                    	                     		add(
                    	                     			current,
                    	                     			"ownedBodyExpressions",
                    	                      		lv_ownedBodyExpressions_31_0,
                    	                      		"org.eclipse.qvtd.xtext.qvtbase.QVTbase.SpecificationCS");
                    	              	        afterParserOrEnumRuleCall();

                    	            }

                    	            }


                    	            }
                    	            break;

                    	    }

                    	    otherlv_32=(Token)match(input,42,FollowSets000.FOLLOW_39); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_32, grammarAccess.getOperationCSAccess().getSemicolonKeyword_10_0_1_4());

                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop46;
                        }
                    } while (true);

                    otherlv_33=(Token)match(input,40,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_33, grammarAccess.getOperationCSAccess().getRightCurlyBracketKeyword_10_0_2());

                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalQVTbase.g:1356:7: otherlv_34= ';'
                    {
                    otherlv_34=(Token)match(input,42,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_34, grammarAccess.getOperationCSAccess().getSemicolonKeyword_10_1());

                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOperationCS"


    // $ANTLR start "entryRuleParameterCS"
    // InternalQVTbase.g:1368:1: entryRuleParameterCS returns [EObject current=null] : iv_ruleParameterCS= ruleParameterCS EOF ;
    public final EObject entryRuleParameterCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterCS = null;


        try {
            // InternalQVTbase.g:1369:2: (iv_ruleParameterCS= ruleParameterCS EOF )
            // InternalQVTbase.g:1370:2: iv_ruleParameterCS= ruleParameterCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameterCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleParameterCS=ruleParameterCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameterCS;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterCS"


    // $ANTLR start "ruleParameterCS"
    // InternalQVTbase.g:1377:1: ruleParameterCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypedMultiplicityRefCS ) ) )? (otherlv_3= '{' ( ( ( (lv_qualifiers_4_0= 'ordered' ) ) | ( (lv_qualifiers_5_0= '!ordered' ) ) | ( (lv_qualifiers_6_0= 'unique' ) ) | ( (lv_qualifiers_7_0= '!unique' ) ) ) (otherlv_8= ',' )? )+ otherlv_9= '}' )? (otherlv_10= '{' otherlv_11= '}' )? ) ;
    public final EObject ruleParameterCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token lv_qualifiers_4_0=null;
        Token lv_qualifiers_5_0=null;
        Token lv_qualifiers_6_0=null;
        Token lv_qualifiers_7_0=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;


         enterRule();

        try {
            // InternalQVTbase.g:1380:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypedMultiplicityRefCS ) ) )? (otherlv_3= '{' ( ( ( (lv_qualifiers_4_0= 'ordered' ) ) | ( (lv_qualifiers_5_0= '!ordered' ) ) | ( (lv_qualifiers_6_0= 'unique' ) ) | ( (lv_qualifiers_7_0= '!unique' ) ) ) (otherlv_8= ',' )? )+ otherlv_9= '}' )? (otherlv_10= '{' otherlv_11= '}' )? ) )
            // InternalQVTbase.g:1381:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypedMultiplicityRefCS ) ) )? (otherlv_3= '{' ( ( ( (lv_qualifiers_4_0= 'ordered' ) ) | ( (lv_qualifiers_5_0= '!ordered' ) ) | ( (lv_qualifiers_6_0= 'unique' ) ) | ( (lv_qualifiers_7_0= '!unique' ) ) ) (otherlv_8= ',' )? )+ otherlv_9= '}' )? (otherlv_10= '{' otherlv_11= '}' )? )
            {
            // InternalQVTbase.g:1381:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypedMultiplicityRefCS ) ) )? (otherlv_3= '{' ( ( ( (lv_qualifiers_4_0= 'ordered' ) ) | ( (lv_qualifiers_5_0= '!ordered' ) ) | ( (lv_qualifiers_6_0= 'unique' ) ) | ( (lv_qualifiers_7_0= '!unique' ) ) ) (otherlv_8= ',' )? )+ otherlv_9= '}' )? (otherlv_10= '{' otherlv_11= '}' )? )
            // InternalQVTbase.g:1381:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypedMultiplicityRefCS ) ) )? (otherlv_3= '{' ( ( ( (lv_qualifiers_4_0= 'ordered' ) ) | ( (lv_qualifiers_5_0= '!ordered' ) ) | ( (lv_qualifiers_6_0= 'unique' ) ) | ( (lv_qualifiers_7_0= '!unique' ) ) ) (otherlv_8= ',' )? )+ otherlv_9= '}' )? (otherlv_10= '{' otherlv_11= '}' )?
            {
            // InternalQVTbase.g:1381:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // InternalQVTbase.g:1382:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // InternalQVTbase.g:1382:1: (lv_name_0_0= ruleUnrestrictedName )
            // InternalQVTbase.g:1383:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {

              	        newCompositeNode(grammarAccess.getParameterCSAccess().getNameUnrestrictedNameParserRuleCall_0_0());

            }
            pushFollow(FollowSets000.FOLLOW_40);
            lv_name_0_0=ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getParameterCSRule());
              	        }
                     		set(
                     			current,
                     			"name",
                      		lv_name_0_0,
                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.UnrestrictedName");
              	        afterParserOrEnumRuleCall();

            }

            }


            }

            // InternalQVTbase.g:1399:2: (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypedMultiplicityRefCS ) ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==20) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalQVTbase.g:1399:4: otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypedMultiplicityRefCS ) )
                    {
                    otherlv_1=(Token)match(input,20,FollowSets000.FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getParameterCSAccess().getColonKeyword_1_0());

                    }
                    // InternalQVTbase.g:1403:1: ( (lv_ownedType_2_0= ruleTypedMultiplicityRefCS ) )
                    // InternalQVTbase.g:1404:1: (lv_ownedType_2_0= ruleTypedMultiplicityRefCS )
                    {
                    // InternalQVTbase.g:1404:1: (lv_ownedType_2_0= ruleTypedMultiplicityRefCS )
                    // InternalQVTbase.g:1405:3: lv_ownedType_2_0= ruleTypedMultiplicityRefCS
                    {
                    if ( state.backtracking==0 ) {

                      	        newCompositeNode(grammarAccess.getParameterCSAccess().getOwnedTypeTypedMultiplicityRefCSParserRuleCall_1_1_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_41);
                    lv_ownedType_2_0=ruleTypedMultiplicityRefCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getParameterCSRule());
                      	        }
                             		set(
                             			current,
                             			"ownedType",
                              		lv_ownedType_2_0,
                              		"org.eclipse.qvtd.xtext.qvtbase.QVTbase.TypedMultiplicityRefCS");
                      	        afterParserOrEnumRuleCall();

                    }

                    }


                    }


                    }
                    break;

            }

            // InternalQVTbase.g:1421:4: (otherlv_3= '{' ( ( ( (lv_qualifiers_4_0= 'ordered' ) ) | ( (lv_qualifiers_5_0= '!ordered' ) ) | ( (lv_qualifiers_6_0= 'unique' ) ) | ( (lv_qualifiers_7_0= '!unique' ) ) ) (otherlv_8= ',' )? )+ otherlv_9= '}' )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==22) ) {
                int LA52_1 = input.LA(2);

                if ( ((LA52_1>=27 && LA52_1<=28)||(LA52_1>=33 && LA52_1<=34)) ) {
                    alt52=1;
                }
            }
            switch (alt52) {
                case 1 :
                    // InternalQVTbase.g:1421:6: otherlv_3= '{' ( ( ( (lv_qualifiers_4_0= 'ordered' ) ) | ( (lv_qualifiers_5_0= '!ordered' ) ) | ( (lv_qualifiers_6_0= 'unique' ) ) | ( (lv_qualifiers_7_0= '!unique' ) ) ) (otherlv_8= ',' )? )+ otherlv_9= '}'
                    {
                    otherlv_3=(Token)match(input,22,FollowSets000.FOLLOW_42); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getParameterCSAccess().getLeftCurlyBracketKeyword_2_0());

                    }
                    // InternalQVTbase.g:1425:1: ( ( ( (lv_qualifiers_4_0= 'ordered' ) ) | ( (lv_qualifiers_5_0= '!ordered' ) ) | ( (lv_qualifiers_6_0= 'unique' ) ) | ( (lv_qualifiers_7_0= '!unique' ) ) ) (otherlv_8= ',' )? )+
                    int cnt51=0;
                    loop51:
                    do {
                        int alt51=2;
                        int LA51_0 = input.LA(1);

                        if ( ((LA51_0>=27 && LA51_0<=28)||(LA51_0>=33 && LA51_0<=34)) ) {
                            alt51=1;
                        }


                        switch (alt51) {
                    	case 1 :
                    	    // InternalQVTbase.g:1425:2: ( ( (lv_qualifiers_4_0= 'ordered' ) ) | ( (lv_qualifiers_5_0= '!ordered' ) ) | ( (lv_qualifiers_6_0= 'unique' ) ) | ( (lv_qualifiers_7_0= '!unique' ) ) ) (otherlv_8= ',' )?
                    	    {
                    	    // InternalQVTbase.g:1425:2: ( ( (lv_qualifiers_4_0= 'ordered' ) ) | ( (lv_qualifiers_5_0= '!ordered' ) ) | ( (lv_qualifiers_6_0= 'unique' ) ) | ( (lv_qualifiers_7_0= '!unique' ) ) )
                    	    int alt49=4;
                    	    switch ( input.LA(1) ) {
                    	    case 27:
                    	        {
                    	        alt49=1;
                    	        }
                    	        break;
                    	    case 28:
                    	        {
                    	        alt49=2;
                    	        }
                    	        break;
                    	    case 33:
                    	        {
                    	        alt49=3;
                    	        }
                    	        break;
                    	    case 34:
                    	        {
                    	        alt49=4;
                    	        }
                    	        break;
                    	    default:
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 49, 0, input);

                    	        throw nvae;
                    	    }

                    	    switch (alt49) {
                    	        case 1 :
                    	            // InternalQVTbase.g:1425:3: ( (lv_qualifiers_4_0= 'ordered' ) )
                    	            {
                    	            // InternalQVTbase.g:1425:3: ( (lv_qualifiers_4_0= 'ordered' ) )
                    	            // InternalQVTbase.g:1426:1: (lv_qualifiers_4_0= 'ordered' )
                    	            {
                    	            // InternalQVTbase.g:1426:1: (lv_qualifiers_4_0= 'ordered' )
                    	            // InternalQVTbase.g:1427:3: lv_qualifiers_4_0= 'ordered'
                    	            {
                    	            lv_qualifiers_4_0=(Token)match(input,27,FollowSets000.FOLLOW_43); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	                      newLeafNode(lv_qualifiers_4_0, grammarAccess.getParameterCSAccess().getQualifiersOrderedKeyword_2_1_0_0_0());

                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElement(grammarAccess.getParameterCSRule());
                    	              	        }
                    	                     		addWithLastConsumed(current, "qualifiers", lv_qualifiers_4_0, "ordered");

                    	            }

                    	            }


                    	            }


                    	            }
                    	            break;
                    	        case 2 :
                    	            // InternalQVTbase.g:1441:6: ( (lv_qualifiers_5_0= '!ordered' ) )
                    	            {
                    	            // InternalQVTbase.g:1441:6: ( (lv_qualifiers_5_0= '!ordered' ) )
                    	            // InternalQVTbase.g:1442:1: (lv_qualifiers_5_0= '!ordered' )
                    	            {
                    	            // InternalQVTbase.g:1442:1: (lv_qualifiers_5_0= '!ordered' )
                    	            // InternalQVTbase.g:1443:3: lv_qualifiers_5_0= '!ordered'
                    	            {
                    	            lv_qualifiers_5_0=(Token)match(input,28,FollowSets000.FOLLOW_43); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	                      newLeafNode(lv_qualifiers_5_0, grammarAccess.getParameterCSAccess().getQualifiersOrderedKeyword_2_1_0_1_0());

                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElement(grammarAccess.getParameterCSRule());
                    	              	        }
                    	                     		addWithLastConsumed(current, "qualifiers", lv_qualifiers_5_0, "!ordered");

                    	            }

                    	            }


                    	            }


                    	            }
                    	            break;
                    	        case 3 :
                    	            // InternalQVTbase.g:1457:6: ( (lv_qualifiers_6_0= 'unique' ) )
                    	            {
                    	            // InternalQVTbase.g:1457:6: ( (lv_qualifiers_6_0= 'unique' ) )
                    	            // InternalQVTbase.g:1458:1: (lv_qualifiers_6_0= 'unique' )
                    	            {
                    	            // InternalQVTbase.g:1458:1: (lv_qualifiers_6_0= 'unique' )
                    	            // InternalQVTbase.g:1459:3: lv_qualifiers_6_0= 'unique'
                    	            {
                    	            lv_qualifiers_6_0=(Token)match(input,33,FollowSets000.FOLLOW_43); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	                      newLeafNode(lv_qualifiers_6_0, grammarAccess.getParameterCSAccess().getQualifiersUniqueKeyword_2_1_0_2_0());

                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElement(grammarAccess.getParameterCSRule());
                    	              	        }
                    	                     		addWithLastConsumed(current, "qualifiers", lv_qualifiers_6_0, "unique");

                    	            }

                    	            }


                    	            }


                    	            }
                    	            break;
                    	        case 4 :
                    	            // InternalQVTbase.g:1473:6: ( (lv_qualifiers_7_0= '!unique' ) )
                    	            {
                    	            // InternalQVTbase.g:1473:6: ( (lv_qualifiers_7_0= '!unique' ) )
                    	            // InternalQVTbase.g:1474:1: (lv_qualifiers_7_0= '!unique' )
                    	            {
                    	            // InternalQVTbase.g:1474:1: (lv_qualifiers_7_0= '!unique' )
                    	            // InternalQVTbase.g:1475:3: lv_qualifiers_7_0= '!unique'
                    	            {
                    	            lv_qualifiers_7_0=(Token)match(input,34,FollowSets000.FOLLOW_43); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	                      newLeafNode(lv_qualifiers_7_0, grammarAccess.getParameterCSAccess().getQualifiersUniqueKeyword_2_1_0_3_0());

                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElement(grammarAccess.getParameterCSRule());
                    	              	        }
                    	                     		addWithLastConsumed(current, "qualifiers", lv_qualifiers_7_0, "!unique");

                    	            }

                    	            }


                    	            }


                    	            }
                    	            break;

                    	    }

                    	    // InternalQVTbase.g:1488:3: (otherlv_8= ',' )?
                    	    int alt50=2;
                    	    int LA50_0 = input.LA(1);

                    	    if ( (LA50_0==39) ) {
                    	        alt50=1;
                    	    }
                    	    switch (alt50) {
                    	        case 1 :
                    	            // InternalQVTbase.g:1488:5: otherlv_8= ','
                    	            {
                    	            otherlv_8=(Token)match(input,39,FollowSets000.FOLLOW_44); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	                  	newLeafNode(otherlv_8, grammarAccess.getParameterCSAccess().getCommaKeyword_2_1_1());

                    	            }

                    	            }
                    	            break;

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt51 >= 1 ) break loop51;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(51, input);
                                throw eee;
                        }
                        cnt51++;
                    } while (true);

                    otherlv_9=(Token)match(input,40,FollowSets000.FOLLOW_41); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getParameterCSAccess().getRightCurlyBracketKeyword_2_2());

                    }

                    }
                    break;

            }

            // InternalQVTbase.g:1496:3: (otherlv_10= '{' otherlv_11= '}' )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==22) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // InternalQVTbase.g:1496:5: otherlv_10= '{' otherlv_11= '}'
                    {
                    otherlv_10=(Token)match(input,22,FollowSets000.FOLLOW_23); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getParameterCSAccess().getLeftCurlyBracketKeyword_3_0());

                    }
                    otherlv_11=(Token)match(input,40,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_11, grammarAccess.getParameterCSAccess().getRightCurlyBracketKeyword_3_1());

                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterCS"


    // $ANTLR start "entryRuleReferenceCS"
    // InternalQVTbase.g:1512:1: entryRuleReferenceCS returns [EObject current=null] : iv_ruleReferenceCS= ruleReferenceCS EOF ;
    public final EObject entryRuleReferenceCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceCS = null;


        try {
            // InternalQVTbase.g:1513:2: (iv_ruleReferenceCS= ruleReferenceCS EOF )
            // InternalQVTbase.g:1514:2: iv_ruleReferenceCS= ruleReferenceCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getReferenceCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleReferenceCS=ruleReferenceCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleReferenceCS;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReferenceCS"


    // $ANTLR start "ruleReferenceCS"
    // InternalQVTbase.g:1521:1: ruleReferenceCS returns [EObject current=null] : ( ( ( ( (lv_qualifiers_0_0= 'static' ) ) ( (lv_qualifiers_1_0= 'definition' ) )? ) | ( ( (lv_qualifiers_2_0= 'definition' ) ) ( (lv_qualifiers_3_0= 'static' ) )? ) )? otherlv_4= 'property' ( (lv_name_5_0= ruleUnrestrictedName ) ) (otherlv_6= '#' ( ( ruleUnrestrictedName ) ) )? (otherlv_8= ':' ( (lv_ownedType_9_0= ruleTypedMultiplicityRefCS ) ) )? (otherlv_10= '=' ( (lv_default_11_0= RULE_SINGLE_QUOTED_STRING ) ) )? (otherlv_12= '{' ( ( ( (lv_qualifiers_13_0= 'composes' ) ) | ( (lv_qualifiers_14_0= '!composes' ) ) | ( (lv_qualifiers_15_0= 'derived' ) ) | ( (lv_qualifiers_16_0= '!derived' ) ) | ( (lv_qualifiers_17_0= 'ordered' ) ) | ( (lv_qualifiers_18_0= '!ordered' ) ) | ( (lv_qualifiers_19_0= 'readonly' ) ) | ( (lv_qualifiers_20_0= '!readonly' ) ) | ( (lv_qualifiers_21_0= 'resolve' ) ) | ( (lv_qualifiers_22_0= '!resolve' ) ) | ( (lv_qualifiers_23_0= 'transient' ) ) | ( (lv_qualifiers_24_0= '!transient' ) ) | ( (lv_qualifiers_25_0= 'unique' ) ) | ( (lv_qualifiers_26_0= '!unique' ) ) | ( (lv_qualifiers_27_0= 'unsettable' ) ) | ( (lv_qualifiers_28_0= '!unsettable' ) ) | ( (lv_qualifiers_29_0= 'volatile' ) ) | ( (lv_qualifiers_30_0= '!volatile' ) ) ) (otherlv_31= ',' )? )+ otherlv_32= '}' )? ( (otherlv_33= '{' ( (otherlv_34= 'initial' ( ruleUnrestrictedName )? otherlv_36= ':' ( (lv_ownedDefaultExpressions_37_0= ruleSpecificationCS ) )? otherlv_38= ';' ) | (otherlv_39= 'derivation' ( ruleUnrestrictedName )? otherlv_41= ':' ( (lv_ownedDefaultExpressions_42_0= ruleSpecificationCS ) )? otherlv_43= ';' ) )* otherlv_44= '}' ) | otherlv_45= ';' ) ) ;
    public final EObject ruleReferenceCS() throws RecognitionException {
        EObject current = null;

        Token lv_qualifiers_0_0=null;
        Token lv_qualifiers_1_0=null;
        Token lv_qualifiers_2_0=null;
        Token lv_qualifiers_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token lv_default_11_0=null;
        Token otherlv_12=null;
        Token lv_qualifiers_13_0=null;
        Token lv_qualifiers_14_0=null;
        Token lv_qualifiers_15_0=null;
        Token lv_qualifiers_16_0=null;
        Token lv_qualifiers_17_0=null;
        Token lv_qualifiers_18_0=null;
        Token lv_qualifiers_19_0=null;
        Token lv_qualifiers_20_0=null;
        Token lv_qualifiers_21_0=null;
        Token lv_qualifiers_22_0=null;
        Token lv_qualifiers_23_0=null;
        Token lv_qualifiers_24_0=null;
        Token lv_qualifiers_25_0=null;
        Token lv_qualifiers_26_0=null;
        Token lv_qualifiers_27_0=null;
        Token lv_qualifiers_28_0=null;
        Token lv_qualifiers_29_0=null;
        Token lv_qualifiers_30_0=null;
        Token otherlv_31=null;
        Token otherlv_32=null;
        Token otherlv_33=null;
        Token otherlv_34=null;
        Token otherlv_36=null;
        Token otherlv_38=null;
        Token otherlv_39=null;
        Token otherlv_41=null;
        Token otherlv_43=null;
        Token otherlv_44=null;
        Token otherlv_45=null;
        AntlrDatatypeRuleToken lv_name_5_0 = null;

        EObject lv_ownedType_9_0 = null;

        EObject lv_ownedDefaultExpressions_37_0 = null;

        EObject lv_ownedDefaultExpressions_42_0 = null;


         enterRule();

        try {
            // InternalQVTbase.g:1524:28: ( ( ( ( ( (lv_qualifiers_0_0= 'static' ) ) ( (lv_qualifiers_1_0= 'definition' ) )? ) | ( ( (lv_qualifiers_2_0= 'definition' ) ) ( (lv_qualifiers_3_0= 'static' ) )? ) )? otherlv_4= 'property' ( (lv_name_5_0= ruleUnrestrictedName ) ) (otherlv_6= '#' ( ( ruleUnrestrictedName ) ) )? (otherlv_8= ':' ( (lv_ownedType_9_0= ruleTypedMultiplicityRefCS ) ) )? (otherlv_10= '=' ( (lv_default_11_0= RULE_SINGLE_QUOTED_STRING ) ) )? (otherlv_12= '{' ( ( ( (lv_qualifiers_13_0= 'composes' ) ) | ( (lv_qualifiers_14_0= '!composes' ) ) | ( (lv_qualifiers_15_0= 'derived' ) ) | ( (lv_qualifiers_16_0= '!derived' ) ) | ( (lv_qualifiers_17_0= 'ordered' ) ) | ( (lv_qualifiers_18_0= '!ordered' ) ) | ( (lv_qualifiers_19_0= 'readonly' ) ) | ( (lv_qualifiers_20_0= '!readonly' ) ) | ( (lv_qualifiers_21_0= 'resolve' ) ) | ( (lv_qualifiers_22_0= '!resolve' ) ) | ( (lv_qualifiers_23_0= 'transient' ) ) | ( (lv_qualifiers_24_0= '!transient' ) ) | ( (lv_qualifiers_25_0= 'unique' ) ) | ( (lv_qualifiers_26_0= '!unique' ) ) | ( (lv_qualifiers_27_0= 'unsettable' ) ) | ( (lv_qualifiers_28_0= '!unsettable' ) ) | ( (lv_qualifiers_29_0= 'volatile' ) ) | ( (lv_qualifiers_30_0= '!volatile' ) ) ) (otherlv_31= ',' )? )+ otherlv_32= '}' )? ( (otherlv_33= '{' ( (otherlv_34= 'initial' ( ruleUnrestrictedName )? otherlv_36= ':' ( (lv_ownedDefaultExpressions_37_0= ruleSpecificationCS ) )? otherlv_38= ';' ) | (otherlv_39= 'derivation' ( ruleUnrestrictedName )? otherlv_41= ':' ( (lv_ownedDefaultExpressions_42_0= ruleSpecificationCS ) )? otherlv_43= ';' ) )* otherlv_44= '}' ) | otherlv_45= ';' ) ) )
            // InternalQVTbase.g:1525:1: ( ( ( ( (lv_qualifiers_0_0= 'static' ) ) ( (lv_qualifiers_1_0= 'definition' ) )? ) | ( ( (lv_qualifiers_2_0= 'definition' ) ) ( (lv_qualifiers_3_0= 'static' ) )? ) )? otherlv_4= 'property' ( (lv_name_5_0= ruleUnrestrictedName ) ) (otherlv_6= '#' ( ( ruleUnrestrictedName ) ) )? (otherlv_8= ':' ( (lv_ownedType_9_0= ruleTypedMultiplicityRefCS ) ) )? (otherlv_10= '=' ( (lv_default_11_0= RULE_SINGLE_QUOTED_STRING ) ) )? (otherlv_12= '{' ( ( ( (lv_qualifiers_13_0= 'composes' ) ) | ( (lv_qualifiers_14_0= '!composes' ) ) | ( (lv_qualifiers_15_0= 'derived' ) ) | ( (lv_qualifiers_16_0= '!derived' ) ) | ( (lv_qualifiers_17_0= 'ordered' ) ) | ( (lv_qualifiers_18_0= '!ordered' ) ) | ( (lv_qualifiers_19_0= 'readonly' ) ) | ( (lv_qualifiers_20_0= '!readonly' ) ) | ( (lv_qualifiers_21_0= 'resolve' ) ) | ( (lv_qualifiers_22_0= '!resolve' ) ) | ( (lv_qualifiers_23_0= 'transient' ) ) | ( (lv_qualifiers_24_0= '!transient' ) ) | ( (lv_qualifiers_25_0= 'unique' ) ) | ( (lv_qualifiers_26_0= '!unique' ) ) | ( (lv_qualifiers_27_0= 'unsettable' ) ) | ( (lv_qualifiers_28_0= '!unsettable' ) ) | ( (lv_qualifiers_29_0= 'volatile' ) ) | ( (lv_qualifiers_30_0= '!volatile' ) ) ) (otherlv_31= ',' )? )+ otherlv_32= '}' )? ( (otherlv_33= '{' ( (otherlv_34= 'initial' ( ruleUnrestrictedName )? otherlv_36= ':' ( (lv_ownedDefaultExpressions_37_0= ruleSpecificationCS ) )? otherlv_38= ';' ) | (otherlv_39= 'derivation' ( ruleUnrestrictedName )? otherlv_41= ':' ( (lv_ownedDefaultExpressions_42_0= ruleSpecificationCS ) )? otherlv_43= ';' ) )* otherlv_44= '}' ) | otherlv_45= ';' ) )
            {
            // InternalQVTbase.g:1525:1: ( ( ( ( (lv_qualifiers_0_0= 'static' ) ) ( (lv_qualifiers_1_0= 'definition' ) )? ) | ( ( (lv_qualifiers_2_0= 'definition' ) ) ( (lv_qualifiers_3_0= 'static' ) )? ) )? otherlv_4= 'property' ( (lv_name_5_0= ruleUnrestrictedName ) ) (otherlv_6= '#' ( ( ruleUnrestrictedName ) ) )? (otherlv_8= ':' ( (lv_ownedType_9_0= ruleTypedMultiplicityRefCS ) ) )? (otherlv_10= '=' ( (lv_default_11_0= RULE_SINGLE_QUOTED_STRING ) ) )? (otherlv_12= '{' ( ( ( (lv_qualifiers_13_0= 'composes' ) ) | ( (lv_qualifiers_14_0= '!composes' ) ) | ( (lv_qualifiers_15_0= 'derived' ) ) | ( (lv_qualifiers_16_0= '!derived' ) ) | ( (lv_qualifiers_17_0= 'ordered' ) ) | ( (lv_qualifiers_18_0= '!ordered' ) ) | ( (lv_qualifiers_19_0= 'readonly' ) ) | ( (lv_qualifiers_20_0= '!readonly' ) ) | ( (lv_qualifiers_21_0= 'resolve' ) ) | ( (lv_qualifiers_22_0= '!resolve' ) ) | ( (lv_qualifiers_23_0= 'transient' ) ) | ( (lv_qualifiers_24_0= '!transient' ) ) | ( (lv_qualifiers_25_0= 'unique' ) ) | ( (lv_qualifiers_26_0= '!unique' ) ) | ( (lv_qualifiers_27_0= 'unsettable' ) ) | ( (lv_qualifiers_28_0= '!unsettable' ) ) | ( (lv_qualifiers_29_0= 'volatile' ) ) | ( (lv_qualifiers_30_0= '!volatile' ) ) ) (otherlv_31= ',' )? )+ otherlv_32= '}' )? ( (otherlv_33= '{' ( (otherlv_34= 'initial' ( ruleUnrestrictedName )? otherlv_36= ':' ( (lv_ownedDefaultExpressions_37_0= ruleSpecificationCS ) )? otherlv_38= ';' ) | (otherlv_39= 'derivation' ( ruleUnrestrictedName )? otherlv_41= ':' ( (lv_ownedDefaultExpressions_42_0= ruleSpecificationCS ) )? otherlv_43= ';' ) )* otherlv_44= '}' ) | otherlv_45= ';' ) )
            // InternalQVTbase.g:1525:2: ( ( ( (lv_qualifiers_0_0= 'static' ) ) ( (lv_qualifiers_1_0= 'definition' ) )? ) | ( ( (lv_qualifiers_2_0= 'definition' ) ) ( (lv_qualifiers_3_0= 'static' ) )? ) )? otherlv_4= 'property' ( (lv_name_5_0= ruleUnrestrictedName ) ) (otherlv_6= '#' ( ( ruleUnrestrictedName ) ) )? (otherlv_8= ':' ( (lv_ownedType_9_0= ruleTypedMultiplicityRefCS ) ) )? (otherlv_10= '=' ( (lv_default_11_0= RULE_SINGLE_QUOTED_STRING ) ) )? (otherlv_12= '{' ( ( ( (lv_qualifiers_13_0= 'composes' ) ) | ( (lv_qualifiers_14_0= '!composes' ) ) | ( (lv_qualifiers_15_0= 'derived' ) ) | ( (lv_qualifiers_16_0= '!derived' ) ) | ( (lv_qualifiers_17_0= 'ordered' ) ) | ( (lv_qualifiers_18_0= '!ordered' ) ) | ( (lv_qualifiers_19_0= 'readonly' ) ) | ( (lv_qualifiers_20_0= '!readonly' ) ) | ( (lv_qualifiers_21_0= 'resolve' ) ) | ( (lv_qualifiers_22_0= '!resolve' ) ) | ( (lv_qualifiers_23_0= 'transient' ) ) | ( (lv_qualifiers_24_0= '!transient' ) ) | ( (lv_qualifiers_25_0= 'unique' ) ) | ( (lv_qualifiers_26_0= '!unique' ) ) | ( (lv_qualifiers_27_0= 'unsettable' ) ) | ( (lv_qualifiers_28_0= '!unsettable' ) ) | ( (lv_qualifiers_29_0= 'volatile' ) ) | ( (lv_qualifiers_30_0= '!volatile' ) ) ) (otherlv_31= ',' )? )+ otherlv_32= '}' )? ( (otherlv_33= '{' ( (otherlv_34= 'initial' ( ruleUnrestrictedName )? otherlv_36= ':' ( (lv_ownedDefaultExpressions_37_0= ruleSpecificationCS ) )? otherlv_38= ';' ) | (otherlv_39= 'derivation' ( ruleUnrestrictedName )? otherlv_41= ':' ( (lv_ownedDefaultExpressions_42_0= ruleSpecificationCS ) )? otherlv_43= ';' ) )* otherlv_44= '}' ) | otherlv_45= ';' )
            {
            // InternalQVTbase.g:1525:2: ( ( ( (lv_qualifiers_0_0= 'static' ) ) ( (lv_qualifiers_1_0= 'definition' ) )? ) | ( ( (lv_qualifiers_2_0= 'definition' ) ) ( (lv_qualifiers_3_0= 'static' ) )? ) )?
            int alt56=3;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==17) ) {
                alt56=1;
            }
            else if ( (LA56_0==18) ) {
                alt56=2;
            }
            switch (alt56) {
                case 1 :
                    // InternalQVTbase.g:1525:3: ( ( (lv_qualifiers_0_0= 'static' ) ) ( (lv_qualifiers_1_0= 'definition' ) )? )
                    {
                    // InternalQVTbase.g:1525:3: ( ( (lv_qualifiers_0_0= 'static' ) ) ( (lv_qualifiers_1_0= 'definition' ) )? )
                    // InternalQVTbase.g:1525:4: ( (lv_qualifiers_0_0= 'static' ) ) ( (lv_qualifiers_1_0= 'definition' ) )?
                    {
                    // InternalQVTbase.g:1525:4: ( (lv_qualifiers_0_0= 'static' ) )
                    // InternalQVTbase.g:1526:1: (lv_qualifiers_0_0= 'static' )
                    {
                    // InternalQVTbase.g:1526:1: (lv_qualifiers_0_0= 'static' )
                    // InternalQVTbase.g:1527:3: lv_qualifiers_0_0= 'static'
                    {
                    lv_qualifiers_0_0=(Token)match(input,17,FollowSets000.FOLLOW_45); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_qualifiers_0_0, grammarAccess.getReferenceCSAccess().getQualifiersStaticKeyword_0_0_0_0());

                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getReferenceCSRule());
                      	        }
                             		addWithLastConsumed(current, "qualifiers", lv_qualifiers_0_0, "static");

                    }

                    }


                    }

                    // InternalQVTbase.g:1540:2: ( (lv_qualifiers_1_0= 'definition' ) )?
                    int alt54=2;
                    int LA54_0 = input.LA(1);

                    if ( (LA54_0==18) ) {
                        alt54=1;
                    }
                    switch (alt54) {
                        case 1 :
                            // InternalQVTbase.g:1541:1: (lv_qualifiers_1_0= 'definition' )
                            {
                            // InternalQVTbase.g:1541:1: (lv_qualifiers_1_0= 'definition' )
                            // InternalQVTbase.g:1542:3: lv_qualifiers_1_0= 'definition'
                            {
                            lv_qualifiers_1_0=(Token)match(input,18,FollowSets000.FOLLOW_46); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_qualifiers_1_0, grammarAccess.getReferenceCSAccess().getQualifiersDefinitionKeyword_0_0_1_0());

                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getReferenceCSRule());
                              	        }
                                     		addWithLastConsumed(current, "qualifiers", lv_qualifiers_1_0, "definition");

                            }

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalQVTbase.g:1556:6: ( ( (lv_qualifiers_2_0= 'definition' ) ) ( (lv_qualifiers_3_0= 'static' ) )? )
                    {
                    // InternalQVTbase.g:1556:6: ( ( (lv_qualifiers_2_0= 'definition' ) ) ( (lv_qualifiers_3_0= 'static' ) )? )
                    // InternalQVTbase.g:1556:7: ( (lv_qualifiers_2_0= 'definition' ) ) ( (lv_qualifiers_3_0= 'static' ) )?
                    {
                    // InternalQVTbase.g:1556:7: ( (lv_qualifiers_2_0= 'definition' ) )
                    // InternalQVTbase.g:1557:1: (lv_qualifiers_2_0= 'definition' )
                    {
                    // InternalQVTbase.g:1557:1: (lv_qualifiers_2_0= 'definition' )
                    // InternalQVTbase.g:1558:3: lv_qualifiers_2_0= 'definition'
                    {
                    lv_qualifiers_2_0=(Token)match(input,18,FollowSets000.FOLLOW_47); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_qualifiers_2_0, grammarAccess.getReferenceCSAccess().getQualifiersDefinitionKeyword_0_1_0_0());

                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getReferenceCSRule());
                      	        }
                             		addWithLastConsumed(current, "qualifiers", lv_qualifiers_2_0, "definition");

                    }

                    }


                    }

                    // InternalQVTbase.g:1571:2: ( (lv_qualifiers_3_0= 'static' ) )?
                    int alt55=2;
                    int LA55_0 = input.LA(1);

                    if ( (LA55_0==17) ) {
                        alt55=1;
                    }
                    switch (alt55) {
                        case 1 :
                            // InternalQVTbase.g:1572:1: (lv_qualifiers_3_0= 'static' )
                            {
                            // InternalQVTbase.g:1572:1: (lv_qualifiers_3_0= 'static' )
                            // InternalQVTbase.g:1573:3: lv_qualifiers_3_0= 'static'
                            {
                            lv_qualifiers_3_0=(Token)match(input,17,FollowSets000.FOLLOW_46); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_qualifiers_3_0, grammarAccess.getReferenceCSAccess().getQualifiersStaticKeyword_0_1_1_0());

                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getReferenceCSRule());
                              	        }
                                     		addWithLastConsumed(current, "qualifiers", lv_qualifiers_3_0, "static");

                            }

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,55,FollowSets000.FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getReferenceCSAccess().getPropertyKeyword_1());

            }
            // InternalQVTbase.g:1590:1: ( (lv_name_5_0= ruleUnrestrictedName ) )
            // InternalQVTbase.g:1591:1: (lv_name_5_0= ruleUnrestrictedName )
            {
            // InternalQVTbase.g:1591:1: (lv_name_5_0= ruleUnrestrictedName )
            // InternalQVTbase.g:1592:3: lv_name_5_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {

              	        newCompositeNode(grammarAccess.getReferenceCSAccess().getNameUnrestrictedNameParserRuleCall_2_0());

            }
            pushFollow(FollowSets000.FOLLOW_48);
            lv_name_5_0=ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getReferenceCSRule());
              	        }
                     		set(
                     			current,
                     			"name",
                      		lv_name_5_0,
                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.UnrestrictedName");
              	        afterParserOrEnumRuleCall();

            }

            }


            }

            // InternalQVTbase.g:1608:2: (otherlv_6= '#' ( ( ruleUnrestrictedName ) ) )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==56) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // InternalQVTbase.g:1608:4: otherlv_6= '#' ( ( ruleUnrestrictedName ) )
                    {
                    otherlv_6=(Token)match(input,56,FollowSets000.FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getReferenceCSAccess().getNumberSignKeyword_3_0());

                    }
                    // InternalQVTbase.g:1612:1: ( ( ruleUnrestrictedName ) )
                    // InternalQVTbase.g:1613:1: ( ruleUnrestrictedName )
                    {
                    // InternalQVTbase.g:1613:1: ( ruleUnrestrictedName )
                    // InternalQVTbase.g:1614:3: ruleUnrestrictedName
                    {
                    if ( state.backtracking==0 ) {

                      		  /* */

                    }
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getReferenceCSRule());
                      	        }

                    }
                    if ( state.backtracking==0 ) {

                      	        newCompositeNode(grammarAccess.getReferenceCSAccess().getReferredOppositePropertyCrossReference_3_1_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_7);
                    ruleUnrestrictedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        afterParserOrEnumRuleCall();

                    }

                    }


                    }


                    }
                    break;

            }

            // InternalQVTbase.g:1630:4: (otherlv_8= ':' ( (lv_ownedType_9_0= ruleTypedMultiplicityRefCS ) ) )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==20) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // InternalQVTbase.g:1630:6: otherlv_8= ':' ( (lv_ownedType_9_0= ruleTypedMultiplicityRefCS ) )
                    {
                    otherlv_8=(Token)match(input,20,FollowSets000.FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getReferenceCSAccess().getColonKeyword_4_0());

                    }
                    // InternalQVTbase.g:1634:1: ( (lv_ownedType_9_0= ruleTypedMultiplicityRefCS ) )
                    // InternalQVTbase.g:1635:1: (lv_ownedType_9_0= ruleTypedMultiplicityRefCS )
                    {
                    // InternalQVTbase.g:1635:1: (lv_ownedType_9_0= ruleTypedMultiplicityRefCS )
                    // InternalQVTbase.g:1636:3: lv_ownedType_9_0= ruleTypedMultiplicityRefCS
                    {
                    if ( state.backtracking==0 ) {

                      	        newCompositeNode(grammarAccess.getReferenceCSAccess().getOwnedTypeTypedMultiplicityRefCSParserRuleCall_4_1_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_8);
                    lv_ownedType_9_0=ruleTypedMultiplicityRefCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getReferenceCSRule());
                      	        }
                             		set(
                             			current,
                             			"ownedType",
                              		lv_ownedType_9_0,
                              		"org.eclipse.qvtd.xtext.qvtbase.QVTbase.TypedMultiplicityRefCS");
                      	        afterParserOrEnumRuleCall();

                    }

                    }


                    }


                    }
                    break;

            }

            // InternalQVTbase.g:1652:4: (otherlv_10= '=' ( (lv_default_11_0= RULE_SINGLE_QUOTED_STRING ) ) )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==21) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // InternalQVTbase.g:1652:6: otherlv_10= '=' ( (lv_default_11_0= RULE_SINGLE_QUOTED_STRING ) )
                    {
                    otherlv_10=(Token)match(input,21,FollowSets000.FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getReferenceCSAccess().getEqualsSignKeyword_5_0());

                    }
                    // InternalQVTbase.g:1656:1: ( (lv_default_11_0= RULE_SINGLE_QUOTED_STRING ) )
                    // InternalQVTbase.g:1657:1: (lv_default_11_0= RULE_SINGLE_QUOTED_STRING )
                    {
                    // InternalQVTbase.g:1657:1: (lv_default_11_0= RULE_SINGLE_QUOTED_STRING )
                    // InternalQVTbase.g:1658:3: lv_default_11_0= RULE_SINGLE_QUOTED_STRING
                    {
                    lv_default_11_0=(Token)match(input,RULE_SINGLE_QUOTED_STRING,FollowSets000.FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_default_11_0, grammarAccess.getReferenceCSAccess().getDefaultSINGLE_QUOTED_STRINGTerminalRuleCall_5_1_0());

                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getReferenceCSRule());
                      	        }
                             		setWithLastConsumed(
                             			current,
                             			"default",
                              		lv_default_11_0,
                              		"org.eclipse.ocl.xtext.base.Base.SINGLE_QUOTED_STRING");

                    }

                    }


                    }


                    }
                    break;

            }

            // InternalQVTbase.g:1674:4: (otherlv_12= '{' ( ( ( (lv_qualifiers_13_0= 'composes' ) ) | ( (lv_qualifiers_14_0= '!composes' ) ) | ( (lv_qualifiers_15_0= 'derived' ) ) | ( (lv_qualifiers_16_0= '!derived' ) ) | ( (lv_qualifiers_17_0= 'ordered' ) ) | ( (lv_qualifiers_18_0= '!ordered' ) ) | ( (lv_qualifiers_19_0= 'readonly' ) ) | ( (lv_qualifiers_20_0= '!readonly' ) ) | ( (lv_qualifiers_21_0= 'resolve' ) ) | ( (lv_qualifiers_22_0= '!resolve' ) ) | ( (lv_qualifiers_23_0= 'transient' ) ) | ( (lv_qualifiers_24_0= '!transient' ) ) | ( (lv_qualifiers_25_0= 'unique' ) ) | ( (lv_qualifiers_26_0= '!unique' ) ) | ( (lv_qualifiers_27_0= 'unsettable' ) ) | ( (lv_qualifiers_28_0= '!unsettable' ) ) | ( (lv_qualifiers_29_0= 'volatile' ) ) | ( (lv_qualifiers_30_0= '!volatile' ) ) ) (otherlv_31= ',' )? )+ otherlv_32= '}' )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==22) ) {
                int LA63_1 = input.LA(2);

                if ( ((LA63_1>=23 && LA63_1<=24)||(LA63_1>=27 && LA63_1<=38)||(LA63_1>=57 && LA63_1<=60)) ) {
                    alt63=1;
                }
            }
            switch (alt63) {
                case 1 :
                    // InternalQVTbase.g:1674:6: otherlv_12= '{' ( ( ( (lv_qualifiers_13_0= 'composes' ) ) | ( (lv_qualifiers_14_0= '!composes' ) ) | ( (lv_qualifiers_15_0= 'derived' ) ) | ( (lv_qualifiers_16_0= '!derived' ) ) | ( (lv_qualifiers_17_0= 'ordered' ) ) | ( (lv_qualifiers_18_0= '!ordered' ) ) | ( (lv_qualifiers_19_0= 'readonly' ) ) | ( (lv_qualifiers_20_0= '!readonly' ) ) | ( (lv_qualifiers_21_0= 'resolve' ) ) | ( (lv_qualifiers_22_0= '!resolve' ) ) | ( (lv_qualifiers_23_0= 'transient' ) ) | ( (lv_qualifiers_24_0= '!transient' ) ) | ( (lv_qualifiers_25_0= 'unique' ) ) | ( (lv_qualifiers_26_0= '!unique' ) ) | ( (lv_qualifiers_27_0= 'unsettable' ) ) | ( (lv_qualifiers_28_0= '!unsettable' ) ) | ( (lv_qualifiers_29_0= 'volatile' ) ) | ( (lv_qualifiers_30_0= '!volatile' ) ) ) (otherlv_31= ',' )? )+ otherlv_32= '}'
                    {
                    otherlv_12=(Token)match(input,22,FollowSets000.FOLLOW_49); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_12, grammarAccess.getReferenceCSAccess().getLeftCurlyBracketKeyword_6_0());

                    }
                    // InternalQVTbase.g:1678:1: ( ( ( (lv_qualifiers_13_0= 'composes' ) ) | ( (lv_qualifiers_14_0= '!composes' ) ) | ( (lv_qualifiers_15_0= 'derived' ) ) | ( (lv_qualifiers_16_0= '!derived' ) ) | ( (lv_qualifiers_17_0= 'ordered' ) ) | ( (lv_qualifiers_18_0= '!ordered' ) ) | ( (lv_qualifiers_19_0= 'readonly' ) ) | ( (lv_qualifiers_20_0= '!readonly' ) ) | ( (lv_qualifiers_21_0= 'resolve' ) ) | ( (lv_qualifiers_22_0= '!resolve' ) ) | ( (lv_qualifiers_23_0= 'transient' ) ) | ( (lv_qualifiers_24_0= '!transient' ) ) | ( (lv_qualifiers_25_0= 'unique' ) ) | ( (lv_qualifiers_26_0= '!unique' ) ) | ( (lv_qualifiers_27_0= 'unsettable' ) ) | ( (lv_qualifiers_28_0= '!unsettable' ) ) | ( (lv_qualifiers_29_0= 'volatile' ) ) | ( (lv_qualifiers_30_0= '!volatile' ) ) ) (otherlv_31= ',' )? )+
                    int cnt62=0;
                    loop62:
                    do {
                        int alt62=2;
                        int LA62_0 = input.LA(1);

                        if ( ((LA62_0>=23 && LA62_0<=24)||(LA62_0>=27 && LA62_0<=38)||(LA62_0>=57 && LA62_0<=60)) ) {
                            alt62=1;
                        }


                        switch (alt62) {
                    	case 1 :
                    	    // InternalQVTbase.g:1678:2: ( ( (lv_qualifiers_13_0= 'composes' ) ) | ( (lv_qualifiers_14_0= '!composes' ) ) | ( (lv_qualifiers_15_0= 'derived' ) ) | ( (lv_qualifiers_16_0= '!derived' ) ) | ( (lv_qualifiers_17_0= 'ordered' ) ) | ( (lv_qualifiers_18_0= '!ordered' ) ) | ( (lv_qualifiers_19_0= 'readonly' ) ) | ( (lv_qualifiers_20_0= '!readonly' ) ) | ( (lv_qualifiers_21_0= 'resolve' ) ) | ( (lv_qualifiers_22_0= '!resolve' ) ) | ( (lv_qualifiers_23_0= 'transient' ) ) | ( (lv_qualifiers_24_0= '!transient' ) ) | ( (lv_qualifiers_25_0= 'unique' ) ) | ( (lv_qualifiers_26_0= '!unique' ) ) | ( (lv_qualifiers_27_0= 'unsettable' ) ) | ( (lv_qualifiers_28_0= '!unsettable' ) ) | ( (lv_qualifiers_29_0= 'volatile' ) ) | ( (lv_qualifiers_30_0= '!volatile' ) ) ) (otherlv_31= ',' )?
                    	    {
                    	    // InternalQVTbase.g:1678:2: ( ( (lv_qualifiers_13_0= 'composes' ) ) | ( (lv_qualifiers_14_0= '!composes' ) ) | ( (lv_qualifiers_15_0= 'derived' ) ) | ( (lv_qualifiers_16_0= '!derived' ) ) | ( (lv_qualifiers_17_0= 'ordered' ) ) | ( (lv_qualifiers_18_0= '!ordered' ) ) | ( (lv_qualifiers_19_0= 'readonly' ) ) | ( (lv_qualifiers_20_0= '!readonly' ) ) | ( (lv_qualifiers_21_0= 'resolve' ) ) | ( (lv_qualifiers_22_0= '!resolve' ) ) | ( (lv_qualifiers_23_0= 'transient' ) ) | ( (lv_qualifiers_24_0= '!transient' ) ) | ( (lv_qualifiers_25_0= 'unique' ) ) | ( (lv_qualifiers_26_0= '!unique' ) ) | ( (lv_qualifiers_27_0= 'unsettable' ) ) | ( (lv_qualifiers_28_0= '!unsettable' ) ) | ( (lv_qualifiers_29_0= 'volatile' ) ) | ( (lv_qualifiers_30_0= '!volatile' ) ) )
                    	    int alt60=18;
                    	    switch ( input.LA(1) ) {
                    	    case 57:
                    	        {
                    	        alt60=1;
                    	        }
                    	        break;
                    	    case 58:
                    	        {
                    	        alt60=2;
                    	        }
                    	        break;
                    	    case 23:
                    	        {
                    	        alt60=3;
                    	        }
                    	        break;
                    	    case 24:
                    	        {
                    	        alt60=4;
                    	        }
                    	        break;
                    	    case 27:
                    	        {
                    	        alt60=5;
                    	        }
                    	        break;
                    	    case 28:
                    	        {
                    	        alt60=6;
                    	        }
                    	        break;
                    	    case 29:
                    	        {
                    	        alt60=7;
                    	        }
                    	        break;
                    	    case 30:
                    	        {
                    	        alt60=8;
                    	        }
                    	        break;
                    	    case 59:
                    	        {
                    	        alt60=9;
                    	        }
                    	        break;
                    	    case 60:
                    	        {
                    	        alt60=10;
                    	        }
                    	        break;
                    	    case 31:
                    	        {
                    	        alt60=11;
                    	        }
                    	        break;
                    	    case 32:
                    	        {
                    	        alt60=12;
                    	        }
                    	        break;
                    	    case 33:
                    	        {
                    	        alt60=13;
                    	        }
                    	        break;
                    	    case 34:
                    	        {
                    	        alt60=14;
                    	        }
                    	        break;
                    	    case 35:
                    	        {
                    	        alt60=15;
                    	        }
                    	        break;
                    	    case 36:
                    	        {
                    	        alt60=16;
                    	        }
                    	        break;
                    	    case 37:
                    	        {
                    	        alt60=17;
                    	        }
                    	        break;
                    	    case 38:
                    	        {
                    	        alt60=18;
                    	        }
                    	        break;
                    	    default:
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 60, 0, input);

                    	        throw nvae;
                    	    }

                    	    switch (alt60) {
                    	        case 1 :
                    	            // InternalQVTbase.g:1678:3: ( (lv_qualifiers_13_0= 'composes' ) )
                    	            {
                    	            // InternalQVTbase.g:1678:3: ( (lv_qualifiers_13_0= 'composes' ) )
                    	            // InternalQVTbase.g:1679:1: (lv_qualifiers_13_0= 'composes' )
                    	            {
                    	            // InternalQVTbase.g:1679:1: (lv_qualifiers_13_0= 'composes' )
                    	            // InternalQVTbase.g:1680:3: lv_qualifiers_13_0= 'composes'
                    	            {
                    	            lv_qualifiers_13_0=(Token)match(input,57,FollowSets000.FOLLOW_50); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	                      newLeafNode(lv_qualifiers_13_0, grammarAccess.getReferenceCSAccess().getQualifiersComposesKeyword_6_1_0_0_0());

                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElement(grammarAccess.getReferenceCSRule());
                    	              	        }
                    	                     		addWithLastConsumed(current, "qualifiers", lv_qualifiers_13_0, "composes");

                    	            }

                    	            }


                    	            }


                    	            }
                    	            break;
                    	        case 2 :
                    	            // InternalQVTbase.g:1694:6: ( (lv_qualifiers_14_0= '!composes' ) )
                    	            {
                    	            // InternalQVTbase.g:1694:6: ( (lv_qualifiers_14_0= '!composes' ) )
                    	            // InternalQVTbase.g:1695:1: (lv_qualifiers_14_0= '!composes' )
                    	            {
                    	            // InternalQVTbase.g:1695:1: (lv_qualifiers_14_0= '!composes' )
                    	            // InternalQVTbase.g:1696:3: lv_qualifiers_14_0= '!composes'
                    	            {
                    	            lv_qualifiers_14_0=(Token)match(input,58,FollowSets000.FOLLOW_50); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	                      newLeafNode(lv_qualifiers_14_0, grammarAccess.getReferenceCSAccess().getQualifiersComposesKeyword_6_1_0_1_0());

                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElement(grammarAccess.getReferenceCSRule());
                    	              	        }
                    	                     		addWithLastConsumed(current, "qualifiers", lv_qualifiers_14_0, "!composes");

                    	            }

                    	            }


                    	            }


                    	            }
                    	            break;
                    	        case 3 :
                    	            // InternalQVTbase.g:1710:6: ( (lv_qualifiers_15_0= 'derived' ) )
                    	            {
                    	            // InternalQVTbase.g:1710:6: ( (lv_qualifiers_15_0= 'derived' ) )
                    	            // InternalQVTbase.g:1711:1: (lv_qualifiers_15_0= 'derived' )
                    	            {
                    	            // InternalQVTbase.g:1711:1: (lv_qualifiers_15_0= 'derived' )
                    	            // InternalQVTbase.g:1712:3: lv_qualifiers_15_0= 'derived'
                    	            {
                    	            lv_qualifiers_15_0=(Token)match(input,23,FollowSets000.FOLLOW_50); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	                      newLeafNode(lv_qualifiers_15_0, grammarAccess.getReferenceCSAccess().getQualifiersDerivedKeyword_6_1_0_2_0());

                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElement(grammarAccess.getReferenceCSRule());
                    	              	        }
                    	                     		addWithLastConsumed(current, "qualifiers", lv_qualifiers_15_0, "derived");

                    	            }

                    	            }


                    	            }


                    	            }
                    	            break;
                    	        case 4 :
                    	            // InternalQVTbase.g:1726:6: ( (lv_qualifiers_16_0= '!derived' ) )
                    	            {
                    	            // InternalQVTbase.g:1726:6: ( (lv_qualifiers_16_0= '!derived' ) )
                    	            // InternalQVTbase.g:1727:1: (lv_qualifiers_16_0= '!derived' )
                    	            {
                    	            // InternalQVTbase.g:1727:1: (lv_qualifiers_16_0= '!derived' )
                    	            // InternalQVTbase.g:1728:3: lv_qualifiers_16_0= '!derived'
                    	            {
                    	            lv_qualifiers_16_0=(Token)match(input,24,FollowSets000.FOLLOW_50); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	                      newLeafNode(lv_qualifiers_16_0, grammarAccess.getReferenceCSAccess().getQualifiersDerivedKeyword_6_1_0_3_0());

                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElement(grammarAccess.getReferenceCSRule());
                    	              	        }
                    	                     		addWithLastConsumed(current, "qualifiers", lv_qualifiers_16_0, "!derived");

                    	            }

                    	            }


                    	            }


                    	            }
                    	            break;
                    	        case 5 :
                    	            // InternalQVTbase.g:1742:6: ( (lv_qualifiers_17_0= 'ordered' ) )
                    	            {
                    	            // InternalQVTbase.g:1742:6: ( (lv_qualifiers_17_0= 'ordered' ) )
                    	            // InternalQVTbase.g:1743:1: (lv_qualifiers_17_0= 'ordered' )
                    	            {
                    	            // InternalQVTbase.g:1743:1: (lv_qualifiers_17_0= 'ordered' )
                    	            // InternalQVTbase.g:1744:3: lv_qualifiers_17_0= 'ordered'
                    	            {
                    	            lv_qualifiers_17_0=(Token)match(input,27,FollowSets000.FOLLOW_50); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	                      newLeafNode(lv_qualifiers_17_0, grammarAccess.getReferenceCSAccess().getQualifiersOrderedKeyword_6_1_0_4_0());

                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElement(grammarAccess.getReferenceCSRule());
                    	              	        }
                    	                     		addWithLastConsumed(current, "qualifiers", lv_qualifiers_17_0, "ordered");

                    	            }

                    	            }


                    	            }


                    	            }
                    	            break;
                    	        case 6 :
                    	            // InternalQVTbase.g:1758:6: ( (lv_qualifiers_18_0= '!ordered' ) )
                    	            {
                    	            // InternalQVTbase.g:1758:6: ( (lv_qualifiers_18_0= '!ordered' ) )
                    	            // InternalQVTbase.g:1759:1: (lv_qualifiers_18_0= '!ordered' )
                    	            {
                    	            // InternalQVTbase.g:1759:1: (lv_qualifiers_18_0= '!ordered' )
                    	            // InternalQVTbase.g:1760:3: lv_qualifiers_18_0= '!ordered'
                    	            {
                    	            lv_qualifiers_18_0=(Token)match(input,28,FollowSets000.FOLLOW_50); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	                      newLeafNode(lv_qualifiers_18_0, grammarAccess.getReferenceCSAccess().getQualifiersOrderedKeyword_6_1_0_5_0());

                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElement(grammarAccess.getReferenceCSRule());
                    	              	        }
                    	                     		addWithLastConsumed(current, "qualifiers", lv_qualifiers_18_0, "!ordered");

                    	            }

                    	            }


                    	            }


                    	            }
                    	            break;
                    	        case 7 :
                    	            // InternalQVTbase.g:1774:6: ( (lv_qualifiers_19_0= 'readonly' ) )
                    	            {
                    	            // InternalQVTbase.g:1774:6: ( (lv_qualifiers_19_0= 'readonly' ) )
                    	            // InternalQVTbase.g:1775:1: (lv_qualifiers_19_0= 'readonly' )
                    	            {
                    	            // InternalQVTbase.g:1775:1: (lv_qualifiers_19_0= 'readonly' )
                    	            // InternalQVTbase.g:1776:3: lv_qualifiers_19_0= 'readonly'
                    	            {
                    	            lv_qualifiers_19_0=(Token)match(input,29,FollowSets000.FOLLOW_50); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	                      newLeafNode(lv_qualifiers_19_0, grammarAccess.getReferenceCSAccess().getQualifiersReadonlyKeyword_6_1_0_6_0());

                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElement(grammarAccess.getReferenceCSRule());
                    	              	        }
                    	                     		addWithLastConsumed(current, "qualifiers", lv_qualifiers_19_0, "readonly");

                    	            }

                    	            }


                    	            }


                    	            }
                    	            break;
                    	        case 8 :
                    	            // InternalQVTbase.g:1790:6: ( (lv_qualifiers_20_0= '!readonly' ) )
                    	            {
                    	            // InternalQVTbase.g:1790:6: ( (lv_qualifiers_20_0= '!readonly' ) )
                    	            // InternalQVTbase.g:1791:1: (lv_qualifiers_20_0= '!readonly' )
                    	            {
                    	            // InternalQVTbase.g:1791:1: (lv_qualifiers_20_0= '!readonly' )
                    	            // InternalQVTbase.g:1792:3: lv_qualifiers_20_0= '!readonly'
                    	            {
                    	            lv_qualifiers_20_0=(Token)match(input,30,FollowSets000.FOLLOW_50); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	                      newLeafNode(lv_qualifiers_20_0, grammarAccess.getReferenceCSAccess().getQualifiersReadonlyKeyword_6_1_0_7_0());

                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElement(grammarAccess.getReferenceCSRule());
                    	              	        }
                    	                     		addWithLastConsumed(current, "qualifiers", lv_qualifiers_20_0, "!readonly");

                    	            }

                    	            }


                    	            }


                    	            }
                    	            break;
                    	        case 9 :
                    	            // InternalQVTbase.g:1806:6: ( (lv_qualifiers_21_0= 'resolve' ) )
                    	            {
                    	            // InternalQVTbase.g:1806:6: ( (lv_qualifiers_21_0= 'resolve' ) )
                    	            // InternalQVTbase.g:1807:1: (lv_qualifiers_21_0= 'resolve' )
                    	            {
                    	            // InternalQVTbase.g:1807:1: (lv_qualifiers_21_0= 'resolve' )
                    	            // InternalQVTbase.g:1808:3: lv_qualifiers_21_0= 'resolve'
                    	            {
                    	            lv_qualifiers_21_0=(Token)match(input,59,FollowSets000.FOLLOW_50); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	                      newLeafNode(lv_qualifiers_21_0, grammarAccess.getReferenceCSAccess().getQualifiersResolveKeyword_6_1_0_8_0());

                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElement(grammarAccess.getReferenceCSRule());
                    	              	        }
                    	                     		addWithLastConsumed(current, "qualifiers", lv_qualifiers_21_0, "resolve");

                    	            }

                    	            }


                    	            }


                    	            }
                    	            break;
                    	        case 10 :
                    	            // InternalQVTbase.g:1822:6: ( (lv_qualifiers_22_0= '!resolve' ) )
                    	            {
                    	            // InternalQVTbase.g:1822:6: ( (lv_qualifiers_22_0= '!resolve' ) )
                    	            // InternalQVTbase.g:1823:1: (lv_qualifiers_22_0= '!resolve' )
                    	            {
                    	            // InternalQVTbase.g:1823:1: (lv_qualifiers_22_0= '!resolve' )
                    	            // InternalQVTbase.g:1824:3: lv_qualifiers_22_0= '!resolve'
                    	            {
                    	            lv_qualifiers_22_0=(Token)match(input,60,FollowSets000.FOLLOW_50); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	                      newLeafNode(lv_qualifiers_22_0, grammarAccess.getReferenceCSAccess().getQualifiersResolveKeyword_6_1_0_9_0());

                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElement(grammarAccess.getReferenceCSRule());
                    	              	        }
                    	                     		addWithLastConsumed(current, "qualifiers", lv_qualifiers_22_0, "!resolve");

                    	            }

                    	            }


                    	            }


                    	            }
                    	            break;
                    	        case 11 :
                    	            // InternalQVTbase.g:1838:6: ( (lv_qualifiers_23_0= 'transient' ) )
                    	            {
                    	            // InternalQVTbase.g:1838:6: ( (lv_qualifiers_23_0= 'transient' ) )
                    	            // InternalQVTbase.g:1839:1: (lv_qualifiers_23_0= 'transient' )
                    	            {
                    	            // InternalQVTbase.g:1839:1: (lv_qualifiers_23_0= 'transient' )
                    	            // InternalQVTbase.g:1840:3: lv_qualifiers_23_0= 'transient'
                    	            {
                    	            lv_qualifiers_23_0=(Token)match(input,31,FollowSets000.FOLLOW_50); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	                      newLeafNode(lv_qualifiers_23_0, grammarAccess.getReferenceCSAccess().getQualifiersTransientKeyword_6_1_0_10_0());

                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElement(grammarAccess.getReferenceCSRule());
                    	              	        }
                    	                     		addWithLastConsumed(current, "qualifiers", lv_qualifiers_23_0, "transient");

                    	            }

                    	            }


                    	            }


                    	            }
                    	            break;
                    	        case 12 :
                    	            // InternalQVTbase.g:1854:6: ( (lv_qualifiers_24_0= '!transient' ) )
                    	            {
                    	            // InternalQVTbase.g:1854:6: ( (lv_qualifiers_24_0= '!transient' ) )
                    	            // InternalQVTbase.g:1855:1: (lv_qualifiers_24_0= '!transient' )
                    	            {
                    	            // InternalQVTbase.g:1855:1: (lv_qualifiers_24_0= '!transient' )
                    	            // InternalQVTbase.g:1856:3: lv_qualifiers_24_0= '!transient'
                    	            {
                    	            lv_qualifiers_24_0=(Token)match(input,32,FollowSets000.FOLLOW_50); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	                      newLeafNode(lv_qualifiers_24_0, grammarAccess.getReferenceCSAccess().getQualifiersTransientKeyword_6_1_0_11_0());

                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElement(grammarAccess.getReferenceCSRule());
                    	              	        }
                    	                     		addWithLastConsumed(current, "qualifiers", lv_qualifiers_24_0, "!transient");

                    	            }

                    	            }


                    	            }


                    	            }
                    	            break;
                    	        case 13 :
                    	            // InternalQVTbase.g:1870:6: ( (lv_qualifiers_25_0= 'unique' ) )
                    	            {
                    	            // InternalQVTbase.g:1870:6: ( (lv_qualifiers_25_0= 'unique' ) )
                    	            // InternalQVTbase.g:1871:1: (lv_qualifiers_25_0= 'unique' )
                    	            {
                    	            // InternalQVTbase.g:1871:1: (lv_qualifiers_25_0= 'unique' )
                    	            // InternalQVTbase.g:1872:3: lv_qualifiers_25_0= 'unique'
                    	            {
                    	            lv_qualifiers_25_0=(Token)match(input,33,FollowSets000.FOLLOW_50); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	                      newLeafNode(lv_qualifiers_25_0, grammarAccess.getReferenceCSAccess().getQualifiersUniqueKeyword_6_1_0_12_0());

                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElement(grammarAccess.getReferenceCSRule());
                    	              	        }
                    	                     		addWithLastConsumed(current, "qualifiers", lv_qualifiers_25_0, "unique");

                    	            }

                    	            }


                    	            }


                    	            }
                    	            break;
                    	        case 14 :
                    	            // InternalQVTbase.g:1886:6: ( (lv_qualifiers_26_0= '!unique' ) )
                    	            {
                    	            // InternalQVTbase.g:1886:6: ( (lv_qualifiers_26_0= '!unique' ) )
                    	            // InternalQVTbase.g:1887:1: (lv_qualifiers_26_0= '!unique' )
                    	            {
                    	            // InternalQVTbase.g:1887:1: (lv_qualifiers_26_0= '!unique' )
                    	            // InternalQVTbase.g:1888:3: lv_qualifiers_26_0= '!unique'
                    	            {
                    	            lv_qualifiers_26_0=(Token)match(input,34,FollowSets000.FOLLOW_50); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	                      newLeafNode(lv_qualifiers_26_0, grammarAccess.getReferenceCSAccess().getQualifiersUniqueKeyword_6_1_0_13_0());

                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElement(grammarAccess.getReferenceCSRule());
                    	              	        }
                    	                     		addWithLastConsumed(current, "qualifiers", lv_qualifiers_26_0, "!unique");

                    	            }

                    	            }


                    	            }


                    	            }
                    	            break;
                    	        case 15 :
                    	            // InternalQVTbase.g:1902:6: ( (lv_qualifiers_27_0= 'unsettable' ) )
                    	            {
                    	            // InternalQVTbase.g:1902:6: ( (lv_qualifiers_27_0= 'unsettable' ) )
                    	            // InternalQVTbase.g:1903:1: (lv_qualifiers_27_0= 'unsettable' )
                    	            {
                    	            // InternalQVTbase.g:1903:1: (lv_qualifiers_27_0= 'unsettable' )
                    	            // InternalQVTbase.g:1904:3: lv_qualifiers_27_0= 'unsettable'
                    	            {
                    	            lv_qualifiers_27_0=(Token)match(input,35,FollowSets000.FOLLOW_50); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	                      newLeafNode(lv_qualifiers_27_0, grammarAccess.getReferenceCSAccess().getQualifiersUnsettableKeyword_6_1_0_14_0());

                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElement(grammarAccess.getReferenceCSRule());
                    	              	        }
                    	                     		addWithLastConsumed(current, "qualifiers", lv_qualifiers_27_0, "unsettable");

                    	            }

                    	            }


                    	            }


                    	            }
                    	            break;
                    	        case 16 :
                    	            // InternalQVTbase.g:1918:6: ( (lv_qualifiers_28_0= '!unsettable' ) )
                    	            {
                    	            // InternalQVTbase.g:1918:6: ( (lv_qualifiers_28_0= '!unsettable' ) )
                    	            // InternalQVTbase.g:1919:1: (lv_qualifiers_28_0= '!unsettable' )
                    	            {
                    	            // InternalQVTbase.g:1919:1: (lv_qualifiers_28_0= '!unsettable' )
                    	            // InternalQVTbase.g:1920:3: lv_qualifiers_28_0= '!unsettable'
                    	            {
                    	            lv_qualifiers_28_0=(Token)match(input,36,FollowSets000.FOLLOW_50); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	                      newLeafNode(lv_qualifiers_28_0, grammarAccess.getReferenceCSAccess().getQualifiersUnsettableKeyword_6_1_0_15_0());

                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElement(grammarAccess.getReferenceCSRule());
                    	              	        }
                    	                     		addWithLastConsumed(current, "qualifiers", lv_qualifiers_28_0, "!unsettable");

                    	            }

                    	            }


                    	            }


                    	            }
                    	            break;
                    	        case 17 :
                    	            // InternalQVTbase.g:1934:6: ( (lv_qualifiers_29_0= 'volatile' ) )
                    	            {
                    	            // InternalQVTbase.g:1934:6: ( (lv_qualifiers_29_0= 'volatile' ) )
                    	            // InternalQVTbase.g:1935:1: (lv_qualifiers_29_0= 'volatile' )
                    	            {
                    	            // InternalQVTbase.g:1935:1: (lv_qualifiers_29_0= 'volatile' )
                    	            // InternalQVTbase.g:1936:3: lv_qualifiers_29_0= 'volatile'
                    	            {
                    	            lv_qualifiers_29_0=(Token)match(input,37,FollowSets000.FOLLOW_50); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	                      newLeafNode(lv_qualifiers_29_0, grammarAccess.getReferenceCSAccess().getQualifiersVolatileKeyword_6_1_0_16_0());

                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElement(grammarAccess.getReferenceCSRule());
                    	              	        }
                    	                     		addWithLastConsumed(current, "qualifiers", lv_qualifiers_29_0, "volatile");

                    	            }

                    	            }


                    	            }


                    	            }
                    	            break;
                    	        case 18 :
                    	            // InternalQVTbase.g:1950:6: ( (lv_qualifiers_30_0= '!volatile' ) )
                    	            {
                    	            // InternalQVTbase.g:1950:6: ( (lv_qualifiers_30_0= '!volatile' ) )
                    	            // InternalQVTbase.g:1951:1: (lv_qualifiers_30_0= '!volatile' )
                    	            {
                    	            // InternalQVTbase.g:1951:1: (lv_qualifiers_30_0= '!volatile' )
                    	            // InternalQVTbase.g:1952:3: lv_qualifiers_30_0= '!volatile'
                    	            {
                    	            lv_qualifiers_30_0=(Token)match(input,38,FollowSets000.FOLLOW_50); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	                      newLeafNode(lv_qualifiers_30_0, grammarAccess.getReferenceCSAccess().getQualifiersVolatileKeyword_6_1_0_17_0());

                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElement(grammarAccess.getReferenceCSRule());
                    	              	        }
                    	                     		addWithLastConsumed(current, "qualifiers", lv_qualifiers_30_0, "!volatile");

                    	            }

                    	            }


                    	            }


                    	            }
                    	            break;

                    	    }

                    	    // InternalQVTbase.g:1965:3: (otherlv_31= ',' )?
                    	    int alt61=2;
                    	    int LA61_0 = input.LA(1);

                    	    if ( (LA61_0==39) ) {
                    	        alt61=1;
                    	    }
                    	    switch (alt61) {
                    	        case 1 :
                    	            // InternalQVTbase.g:1965:5: otherlv_31= ','
                    	            {
                    	            otherlv_31=(Token)match(input,39,FollowSets000.FOLLOW_51); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	                  	newLeafNode(otherlv_31, grammarAccess.getReferenceCSAccess().getCommaKeyword_6_1_1());

                    	            }

                    	            }
                    	            break;

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt62 >= 1 ) break loop62;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(62, input);
                                throw eee;
                        }
                        cnt62++;
                    } while (true);

                    otherlv_32=(Token)match(input,40,FollowSets000.FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_32, grammarAccess.getReferenceCSAccess().getRightCurlyBracketKeyword_6_2());

                    }

                    }
                    break;

            }

            // InternalQVTbase.g:1973:3: ( (otherlv_33= '{' ( (otherlv_34= 'initial' ( ruleUnrestrictedName )? otherlv_36= ':' ( (lv_ownedDefaultExpressions_37_0= ruleSpecificationCS ) )? otherlv_38= ';' ) | (otherlv_39= 'derivation' ( ruleUnrestrictedName )? otherlv_41= ':' ( (lv_ownedDefaultExpressions_42_0= ruleSpecificationCS ) )? otherlv_43= ';' ) )* otherlv_44= '}' ) | otherlv_45= ';' )
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==22) ) {
                alt69=1;
            }
            else if ( (LA69_0==42) ) {
                alt69=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 69, 0, input);

                throw nvae;
            }
            switch (alt69) {
                case 1 :
                    // InternalQVTbase.g:1973:4: (otherlv_33= '{' ( (otherlv_34= 'initial' ( ruleUnrestrictedName )? otherlv_36= ':' ( (lv_ownedDefaultExpressions_37_0= ruleSpecificationCS ) )? otherlv_38= ';' ) | (otherlv_39= 'derivation' ( ruleUnrestrictedName )? otherlv_41= ':' ( (lv_ownedDefaultExpressions_42_0= ruleSpecificationCS ) )? otherlv_43= ';' ) )* otherlv_44= '}' )
                    {
                    // InternalQVTbase.g:1973:4: (otherlv_33= '{' ( (otherlv_34= 'initial' ( ruleUnrestrictedName )? otherlv_36= ':' ( (lv_ownedDefaultExpressions_37_0= ruleSpecificationCS ) )? otherlv_38= ';' ) | (otherlv_39= 'derivation' ( ruleUnrestrictedName )? otherlv_41= ':' ( (lv_ownedDefaultExpressions_42_0= ruleSpecificationCS ) )? otherlv_43= ';' ) )* otherlv_44= '}' )
                    // InternalQVTbase.g:1973:6: otherlv_33= '{' ( (otherlv_34= 'initial' ( ruleUnrestrictedName )? otherlv_36= ':' ( (lv_ownedDefaultExpressions_37_0= ruleSpecificationCS ) )? otherlv_38= ';' ) | (otherlv_39= 'derivation' ( ruleUnrestrictedName )? otherlv_41= ':' ( (lv_ownedDefaultExpressions_42_0= ruleSpecificationCS ) )? otherlv_43= ';' ) )* otherlv_44= '}'
                    {
                    otherlv_33=(Token)match(input,22,FollowSets000.FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_33, grammarAccess.getReferenceCSAccess().getLeftCurlyBracketKeyword_7_0_0());

                    }
                    // InternalQVTbase.g:1977:1: ( (otherlv_34= 'initial' ( ruleUnrestrictedName )? otherlv_36= ':' ( (lv_ownedDefaultExpressions_37_0= ruleSpecificationCS ) )? otherlv_38= ';' ) | (otherlv_39= 'derivation' ( ruleUnrestrictedName )? otherlv_41= ':' ( (lv_ownedDefaultExpressions_42_0= ruleSpecificationCS ) )? otherlv_43= ';' ) )*
                    loop68:
                    do {
                        int alt68=3;
                        int LA68_0 = input.LA(1);

                        if ( (LA68_0==41) ) {
                            alt68=1;
                        }
                        else if ( (LA68_0==43) ) {
                            alt68=2;
                        }


                        switch (alt68) {
                    	case 1 :
                    	    // InternalQVTbase.g:1977:2: (otherlv_34= 'initial' ( ruleUnrestrictedName )? otherlv_36= ':' ( (lv_ownedDefaultExpressions_37_0= ruleSpecificationCS ) )? otherlv_38= ';' )
                    	    {
                    	    // InternalQVTbase.g:1977:2: (otherlv_34= 'initial' ( ruleUnrestrictedName )? otherlv_36= ':' ( (lv_ownedDefaultExpressions_37_0= ruleSpecificationCS ) )? otherlv_38= ';' )
                    	    // InternalQVTbase.g:1977:4: otherlv_34= 'initial' ( ruleUnrestrictedName )? otherlv_36= ':' ( (lv_ownedDefaultExpressions_37_0= ruleSpecificationCS ) )? otherlv_38= ';'
                    	    {
                    	    otherlv_34=(Token)match(input,41,FollowSets000.FOLLOW_15); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_34, grammarAccess.getReferenceCSAccess().getInitialKeyword_7_0_1_0_0());

                    	    }
                    	    // InternalQVTbase.g:1981:1: ( ruleUnrestrictedName )?
                    	    int alt64=2;
                    	    int LA64_0 = input.LA(1);

                    	    if ( ((LA64_0>=RULE_SIMPLE_ID && LA64_0<=RULE_ESCAPED_ID)) ) {
                    	        alt64=1;
                    	    }
                    	    switch (alt64) {
                    	        case 1 :
                    	            // InternalQVTbase.g:1982:2: ruleUnrestrictedName
                    	            {
                    	            if ( state.backtracking==0 ) {

                    	              	  /* */

                    	            }
                    	            if ( state.backtracking==0 ) {

                    	                      newCompositeNode(grammarAccess.getReferenceCSAccess().getUnrestrictedNameParserRuleCall_7_0_1_0_1());

                    	            }
                    	            pushFollow(FollowSets000.FOLLOW_16);
                    	            ruleUnrestrictedName();

                    	            state._fsp--;
                    	            if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	                      afterParserOrEnumRuleCall();

                    	            }

                    	            }
                    	            break;

                    	    }

                    	    otherlv_36=(Token)match(input,20,FollowSets000.FOLLOW_17); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_36, grammarAccess.getReferenceCSAccess().getColonKeyword_7_0_1_0_2());

                    	    }
                    	    // InternalQVTbase.g:1996:1: ( (lv_ownedDefaultExpressions_37_0= ruleSpecificationCS ) )?
                    	    int alt65=2;
                    	    int LA65_0 = input.LA(1);

                    	    if ( ((LA65_0>=RULE_SINGLE_QUOTED_STRING && LA65_0<=RULE_ESCAPED_ID)||LA65_0==51||(LA65_0>=65 && LA65_0<=67)||(LA65_0>=83 && LA65_0<=97)||LA65_0==100||(LA65_0>=102 && LA65_0<=105)||LA65_0==112||(LA65_0>=117 && LA65_0<=118)) ) {
                    	        alt65=1;
                    	    }
                    	    switch (alt65) {
                    	        case 1 :
                    	            // InternalQVTbase.g:1997:1: (lv_ownedDefaultExpressions_37_0= ruleSpecificationCS )
                    	            {
                    	            // InternalQVTbase.g:1997:1: (lv_ownedDefaultExpressions_37_0= ruleSpecificationCS )
                    	            // InternalQVTbase.g:1998:3: lv_ownedDefaultExpressions_37_0= ruleSpecificationCS
                    	            {
                    	            if ( state.backtracking==0 ) {

                    	              	        newCompositeNode(grammarAccess.getReferenceCSAccess().getOwnedDefaultExpressionsSpecificationCSParserRuleCall_7_0_1_0_3_0());

                    	            }
                    	            pushFollow(FollowSets000.FOLLOW_18);
                    	            lv_ownedDefaultExpressions_37_0=ruleSpecificationCS();

                    	            state._fsp--;
                    	            if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElementForParent(grammarAccess.getReferenceCSRule());
                    	              	        }
                    	                     		add(
                    	                     			current,
                    	                     			"ownedDefaultExpressions",
                    	                      		lv_ownedDefaultExpressions_37_0,
                    	                      		"org.eclipse.qvtd.xtext.qvtbase.QVTbase.SpecificationCS");
                    	              	        afterParserOrEnumRuleCall();

                    	            }

                    	            }


                    	            }
                    	            break;

                    	    }

                    	    otherlv_38=(Token)match(input,42,FollowSets000.FOLLOW_14); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_38, grammarAccess.getReferenceCSAccess().getSemicolonKeyword_7_0_1_0_4());

                    	    }

                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalQVTbase.g:2019:6: (otherlv_39= 'derivation' ( ruleUnrestrictedName )? otherlv_41= ':' ( (lv_ownedDefaultExpressions_42_0= ruleSpecificationCS ) )? otherlv_43= ';' )
                    	    {
                    	    // InternalQVTbase.g:2019:6: (otherlv_39= 'derivation' ( ruleUnrestrictedName )? otherlv_41= ':' ( (lv_ownedDefaultExpressions_42_0= ruleSpecificationCS ) )? otherlv_43= ';' )
                    	    // InternalQVTbase.g:2019:8: otherlv_39= 'derivation' ( ruleUnrestrictedName )? otherlv_41= ':' ( (lv_ownedDefaultExpressions_42_0= ruleSpecificationCS ) )? otherlv_43= ';'
                    	    {
                    	    otherlv_39=(Token)match(input,43,FollowSets000.FOLLOW_15); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_39, grammarAccess.getReferenceCSAccess().getDerivationKeyword_7_0_1_1_0());

                    	    }
                    	    // InternalQVTbase.g:2023:1: ( ruleUnrestrictedName )?
                    	    int alt66=2;
                    	    int LA66_0 = input.LA(1);

                    	    if ( ((LA66_0>=RULE_SIMPLE_ID && LA66_0<=RULE_ESCAPED_ID)) ) {
                    	        alt66=1;
                    	    }
                    	    switch (alt66) {
                    	        case 1 :
                    	            // InternalQVTbase.g:2024:2: ruleUnrestrictedName
                    	            {
                    	            if ( state.backtracking==0 ) {

                    	              	  /* */

                    	            }
                    	            if ( state.backtracking==0 ) {

                    	                      newCompositeNode(grammarAccess.getReferenceCSAccess().getUnrestrictedNameParserRuleCall_7_0_1_1_1());

                    	            }
                    	            pushFollow(FollowSets000.FOLLOW_16);
                    	            ruleUnrestrictedName();

                    	            state._fsp--;
                    	            if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	                      afterParserOrEnumRuleCall();

                    	            }

                    	            }
                    	            break;

                    	    }

                    	    otherlv_41=(Token)match(input,20,FollowSets000.FOLLOW_17); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_41, grammarAccess.getReferenceCSAccess().getColonKeyword_7_0_1_1_2());

                    	    }
                    	    // InternalQVTbase.g:2038:1: ( (lv_ownedDefaultExpressions_42_0= ruleSpecificationCS ) )?
                    	    int alt67=2;
                    	    int LA67_0 = input.LA(1);

                    	    if ( ((LA67_0>=RULE_SINGLE_QUOTED_STRING && LA67_0<=RULE_ESCAPED_ID)||LA67_0==51||(LA67_0>=65 && LA67_0<=67)||(LA67_0>=83 && LA67_0<=97)||LA67_0==100||(LA67_0>=102 && LA67_0<=105)||LA67_0==112||(LA67_0>=117 && LA67_0<=118)) ) {
                    	        alt67=1;
                    	    }
                    	    switch (alt67) {
                    	        case 1 :
                    	            // InternalQVTbase.g:2039:1: (lv_ownedDefaultExpressions_42_0= ruleSpecificationCS )
                    	            {
                    	            // InternalQVTbase.g:2039:1: (lv_ownedDefaultExpressions_42_0= ruleSpecificationCS )
                    	            // InternalQVTbase.g:2040:3: lv_ownedDefaultExpressions_42_0= ruleSpecificationCS
                    	            {
                    	            if ( state.backtracking==0 ) {

                    	              	        newCompositeNode(grammarAccess.getReferenceCSAccess().getOwnedDefaultExpressionsSpecificationCSParserRuleCall_7_0_1_1_3_0());

                    	            }
                    	            pushFollow(FollowSets000.FOLLOW_18);
                    	            lv_ownedDefaultExpressions_42_0=ruleSpecificationCS();

                    	            state._fsp--;
                    	            if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElementForParent(grammarAccess.getReferenceCSRule());
                    	              	        }
                    	                     		add(
                    	                     			current,
                    	                     			"ownedDefaultExpressions",
                    	                      		lv_ownedDefaultExpressions_42_0,
                    	                      		"org.eclipse.qvtd.xtext.qvtbase.QVTbase.SpecificationCS");
                    	              	        afterParserOrEnumRuleCall();

                    	            }

                    	            }


                    	            }
                    	            break;

                    	    }

                    	    otherlv_43=(Token)match(input,42,FollowSets000.FOLLOW_14); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_43, grammarAccess.getReferenceCSAccess().getSemicolonKeyword_7_0_1_1_4());

                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop68;
                        }
                    } while (true);

                    otherlv_44=(Token)match(input,40,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_44, grammarAccess.getReferenceCSAccess().getRightCurlyBracketKeyword_7_0_2());

                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalQVTbase.g:2065:7: otherlv_45= ';'
                    {
                    otherlv_45=(Token)match(input,42,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_45, grammarAccess.getReferenceCSAccess().getSemicolonKeyword_7_1());

                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleReferenceCS"


    // $ANTLR start "entryRuleSpecificationCS"
    // InternalQVTbase.g:2077:1: entryRuleSpecificationCS returns [EObject current=null] : iv_ruleSpecificationCS= ruleSpecificationCS EOF ;
    public final EObject entryRuleSpecificationCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpecificationCS = null;


        try {
            // InternalQVTbase.g:2078:2: (iv_ruleSpecificationCS= ruleSpecificationCS EOF )
            // InternalQVTbase.g:2079:2: iv_ruleSpecificationCS= ruleSpecificationCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSpecificationCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSpecificationCS=ruleSpecificationCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSpecificationCS;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSpecificationCS"


    // $ANTLR start "ruleSpecificationCS"
    // InternalQVTbase.g:2086:1: ruleSpecificationCS returns [EObject current=null] : ( ( (lv_ownedExpression_0_0= ruleExpCS ) ) | ( (lv_exprString_1_0= RULE_UNQUOTED_STRING ) ) ) ;
    public final EObject ruleSpecificationCS() throws RecognitionException {
        EObject current = null;

        Token lv_exprString_1_0=null;
        EObject lv_ownedExpression_0_0 = null;


         enterRule();

        try {
            // InternalQVTbase.g:2089:28: ( ( ( (lv_ownedExpression_0_0= ruleExpCS ) ) | ( (lv_exprString_1_0= RULE_UNQUOTED_STRING ) ) ) )
            // InternalQVTbase.g:2090:1: ( ( (lv_ownedExpression_0_0= ruleExpCS ) ) | ( (lv_exprString_1_0= RULE_UNQUOTED_STRING ) ) )
            {
            // InternalQVTbase.g:2090:1: ( ( (lv_ownedExpression_0_0= ruleExpCS ) ) | ( (lv_exprString_1_0= RULE_UNQUOTED_STRING ) ) )
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==RULE_SINGLE_QUOTED_STRING||(LA70_0>=RULE_INT && LA70_0<=RULE_ESCAPED_ID)||LA70_0==51||(LA70_0>=65 && LA70_0<=67)||(LA70_0>=83 && LA70_0<=97)||LA70_0==100||(LA70_0>=102 && LA70_0<=105)||LA70_0==112||(LA70_0>=117 && LA70_0<=118)) ) {
                alt70=1;
            }
            else if ( (LA70_0==RULE_UNQUOTED_STRING) ) {
                alt70=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 70, 0, input);

                throw nvae;
            }
            switch (alt70) {
                case 1 :
                    // InternalQVTbase.g:2090:2: ( (lv_ownedExpression_0_0= ruleExpCS ) )
                    {
                    // InternalQVTbase.g:2090:2: ( (lv_ownedExpression_0_0= ruleExpCS ) )
                    // InternalQVTbase.g:2091:1: (lv_ownedExpression_0_0= ruleExpCS )
                    {
                    // InternalQVTbase.g:2091:1: (lv_ownedExpression_0_0= ruleExpCS )
                    // InternalQVTbase.g:2092:3: lv_ownedExpression_0_0= ruleExpCS
                    {
                    if ( state.backtracking==0 ) {

                      	        newCompositeNode(grammarAccess.getSpecificationCSAccess().getOwnedExpressionExpCSParserRuleCall_0_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_ownedExpression_0_0=ruleExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getSpecificationCSRule());
                      	        }
                             		set(
                             			current,
                             			"ownedExpression",
                              		lv_ownedExpression_0_0,
                              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
                      	        afterParserOrEnumRuleCall();

                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalQVTbase.g:2109:6: ( (lv_exprString_1_0= RULE_UNQUOTED_STRING ) )
                    {
                    // InternalQVTbase.g:2109:6: ( (lv_exprString_1_0= RULE_UNQUOTED_STRING ) )
                    // InternalQVTbase.g:2110:1: (lv_exprString_1_0= RULE_UNQUOTED_STRING )
                    {
                    // InternalQVTbase.g:2110:1: (lv_exprString_1_0= RULE_UNQUOTED_STRING )
                    // InternalQVTbase.g:2111:3: lv_exprString_1_0= RULE_UNQUOTED_STRING
                    {
                    lv_exprString_1_0=(Token)match(input,RULE_UNQUOTED_STRING,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_exprString_1_0, grammarAccess.getSpecificationCSAccess().getExprStringUNQUOTED_STRINGTerminalRuleCall_1_0());

                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getSpecificationCSRule());
                      	        }
                             		setWithLastConsumed(
                             			current,
                             			"exprString",
                              		lv_exprString_1_0,
                              		"org.eclipse.qvtd.xtext.qvtbase.QVTbase.UNQUOTED_STRING");

                    }

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSpecificationCS"


    // $ANTLR start "entryRuleStructuredClassCS"
    // InternalQVTbase.g:2135:1: entryRuleStructuredClassCS returns [EObject current=null] : iv_ruleStructuredClassCS= ruleStructuredClassCS EOF ;
    public final EObject entryRuleStructuredClassCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStructuredClassCS = null;


        try {
            // InternalQVTbase.g:2136:2: (iv_ruleStructuredClassCS= ruleStructuredClassCS EOF )
            // InternalQVTbase.g:2137:2: iv_ruleStructuredClassCS= ruleStructuredClassCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStructuredClassCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleStructuredClassCS=ruleStructuredClassCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStructuredClassCS;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStructuredClassCS"


    // $ANTLR start "ruleStructuredClassCS"
    // InternalQVTbase.g:2144:1: ruleStructuredClassCS returns [EObject current=null] : ( ( (lv_isAbstract_0_0= 'abstract' ) )? otherlv_1= 'class' ( (lv_name_2_0= ruleUnrestrictedName ) ) ( (lv_ownedSignature_3_0= ruleTemplateSignatureCS ) )? (otherlv_4= 'extends' ( (lv_ownedSuperTypes_5_0= ruleTypedRefCS ) ) (otherlv_6= ',' ( (lv_ownedSuperTypes_7_0= ruleTypedRefCS ) ) )* )? (otherlv_8= ':' ( (lv_instanceClassName_9_0= RULE_SINGLE_QUOTED_STRING ) ) )? (otherlv_10= '{' ( (lv_isInterface_11_0= 'interface' ) )? otherlv_12= '}' )? ( (otherlv_13= '{' ( ( (lv_ownedOperations_14_0= ruleOperationCS ) ) | ( (lv_ownedProperties_15_0= ruleStructuralFeatureCS ) ) )* otherlv_16= '}' ) | otherlv_17= ';' ) ) ;
    public final EObject ruleStructuredClassCS() throws RecognitionException {
        EObject current = null;

        Token lv_isAbstract_0_0=null;
        Token otherlv_1=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token lv_instanceClassName_9_0=null;
        Token otherlv_10=null;
        Token lv_isInterface_11_0=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_ownedSignature_3_0 = null;

        EObject lv_ownedSuperTypes_5_0 = null;

        EObject lv_ownedSuperTypes_7_0 = null;

        EObject lv_ownedOperations_14_0 = null;

        EObject lv_ownedProperties_15_0 = null;


         enterRule();

        try {
            // InternalQVTbase.g:2147:28: ( ( ( (lv_isAbstract_0_0= 'abstract' ) )? otherlv_1= 'class' ( (lv_name_2_0= ruleUnrestrictedName ) ) ( (lv_ownedSignature_3_0= ruleTemplateSignatureCS ) )? (otherlv_4= 'extends' ( (lv_ownedSuperTypes_5_0= ruleTypedRefCS ) ) (otherlv_6= ',' ( (lv_ownedSuperTypes_7_0= ruleTypedRefCS ) ) )* )? (otherlv_8= ':' ( (lv_instanceClassName_9_0= RULE_SINGLE_QUOTED_STRING ) ) )? (otherlv_10= '{' ( (lv_isInterface_11_0= 'interface' ) )? otherlv_12= '}' )? ( (otherlv_13= '{' ( ( (lv_ownedOperations_14_0= ruleOperationCS ) ) | ( (lv_ownedProperties_15_0= ruleStructuralFeatureCS ) ) )* otherlv_16= '}' ) | otherlv_17= ';' ) ) )
            // InternalQVTbase.g:2148:1: ( ( (lv_isAbstract_0_0= 'abstract' ) )? otherlv_1= 'class' ( (lv_name_2_0= ruleUnrestrictedName ) ) ( (lv_ownedSignature_3_0= ruleTemplateSignatureCS ) )? (otherlv_4= 'extends' ( (lv_ownedSuperTypes_5_0= ruleTypedRefCS ) ) (otherlv_6= ',' ( (lv_ownedSuperTypes_7_0= ruleTypedRefCS ) ) )* )? (otherlv_8= ':' ( (lv_instanceClassName_9_0= RULE_SINGLE_QUOTED_STRING ) ) )? (otherlv_10= '{' ( (lv_isInterface_11_0= 'interface' ) )? otherlv_12= '}' )? ( (otherlv_13= '{' ( ( (lv_ownedOperations_14_0= ruleOperationCS ) ) | ( (lv_ownedProperties_15_0= ruleStructuralFeatureCS ) ) )* otherlv_16= '}' ) | otherlv_17= ';' ) )
            {
            // InternalQVTbase.g:2148:1: ( ( (lv_isAbstract_0_0= 'abstract' ) )? otherlv_1= 'class' ( (lv_name_2_0= ruleUnrestrictedName ) ) ( (lv_ownedSignature_3_0= ruleTemplateSignatureCS ) )? (otherlv_4= 'extends' ( (lv_ownedSuperTypes_5_0= ruleTypedRefCS ) ) (otherlv_6= ',' ( (lv_ownedSuperTypes_7_0= ruleTypedRefCS ) ) )* )? (otherlv_8= ':' ( (lv_instanceClassName_9_0= RULE_SINGLE_QUOTED_STRING ) ) )? (otherlv_10= '{' ( (lv_isInterface_11_0= 'interface' ) )? otherlv_12= '}' )? ( (otherlv_13= '{' ( ( (lv_ownedOperations_14_0= ruleOperationCS ) ) | ( (lv_ownedProperties_15_0= ruleStructuralFeatureCS ) ) )* otherlv_16= '}' ) | otherlv_17= ';' ) )
            // InternalQVTbase.g:2148:2: ( (lv_isAbstract_0_0= 'abstract' ) )? otherlv_1= 'class' ( (lv_name_2_0= ruleUnrestrictedName ) ) ( (lv_ownedSignature_3_0= ruleTemplateSignatureCS ) )? (otherlv_4= 'extends' ( (lv_ownedSuperTypes_5_0= ruleTypedRefCS ) ) (otherlv_6= ',' ( (lv_ownedSuperTypes_7_0= ruleTypedRefCS ) ) )* )? (otherlv_8= ':' ( (lv_instanceClassName_9_0= RULE_SINGLE_QUOTED_STRING ) ) )? (otherlv_10= '{' ( (lv_isInterface_11_0= 'interface' ) )? otherlv_12= '}' )? ( (otherlv_13= '{' ( ( (lv_ownedOperations_14_0= ruleOperationCS ) ) | ( (lv_ownedProperties_15_0= ruleStructuralFeatureCS ) ) )* otherlv_16= '}' ) | otherlv_17= ';' )
            {
            // InternalQVTbase.g:2148:2: ( (lv_isAbstract_0_0= 'abstract' ) )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==61) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // InternalQVTbase.g:2149:1: (lv_isAbstract_0_0= 'abstract' )
                    {
                    // InternalQVTbase.g:2149:1: (lv_isAbstract_0_0= 'abstract' )
                    // InternalQVTbase.g:2150:3: lv_isAbstract_0_0= 'abstract'
                    {
                    lv_isAbstract_0_0=(Token)match(input,61,FollowSets000.FOLLOW_52); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_isAbstract_0_0, grammarAccess.getStructuredClassCSAccess().getIsAbstractAbstractKeyword_0_0());

                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getStructuredClassCSRule());
                      	        }
                             		setWithLastConsumed(current, "isAbstract", true, "abstract");

                    }

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,62,FollowSets000.FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getStructuredClassCSAccess().getClassKeyword_1());

            }
            // InternalQVTbase.g:2167:1: ( (lv_name_2_0= ruleUnrestrictedName ) )
            // InternalQVTbase.g:2168:1: (lv_name_2_0= ruleUnrestrictedName )
            {
            // InternalQVTbase.g:2168:1: (lv_name_2_0= ruleUnrestrictedName )
            // InternalQVTbase.g:2169:3: lv_name_2_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {

              	        newCompositeNode(grammarAccess.getStructuredClassCSAccess().getNameUnrestrictedNameParserRuleCall_2_0());

            }
            pushFollow(FollowSets000.FOLLOW_53);
            lv_name_2_0=ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getStructuredClassCSRule());
              	        }
                     		set(
                     			current,
                     			"name",
                      		lv_name_2_0,
                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.UnrestrictedName");
              	        afterParserOrEnumRuleCall();

            }

            }


            }

            // InternalQVTbase.g:2185:2: ( (lv_ownedSignature_3_0= ruleTemplateSignatureCS ) )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==51) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // InternalQVTbase.g:2186:1: (lv_ownedSignature_3_0= ruleTemplateSignatureCS )
                    {
                    // InternalQVTbase.g:2186:1: (lv_ownedSignature_3_0= ruleTemplateSignatureCS )
                    // InternalQVTbase.g:2187:3: lv_ownedSignature_3_0= ruleTemplateSignatureCS
                    {
                    if ( state.backtracking==0 ) {

                      	        newCompositeNode(grammarAccess.getStructuredClassCSAccess().getOwnedSignatureTemplateSignatureCSParserRuleCall_3_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_54);
                    lv_ownedSignature_3_0=ruleTemplateSignatureCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getStructuredClassCSRule());
                      	        }
                             		set(
                             			current,
                             			"ownedSignature",
                              		lv_ownedSignature_3_0,
                              		"org.eclipse.ocl.xtext.base.Base.TemplateSignatureCS");
                      	        afterParserOrEnumRuleCall();

                    }

                    }


                    }
                    break;

            }

            // InternalQVTbase.g:2203:3: (otherlv_4= 'extends' ( (lv_ownedSuperTypes_5_0= ruleTypedRefCS ) ) (otherlv_6= ',' ( (lv_ownedSuperTypes_7_0= ruleTypedRefCS ) ) )* )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==63) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // InternalQVTbase.g:2203:5: otherlv_4= 'extends' ( (lv_ownedSuperTypes_5_0= ruleTypedRefCS ) ) (otherlv_6= ',' ( (lv_ownedSuperTypes_7_0= ruleTypedRefCS ) ) )*
                    {
                    otherlv_4=(Token)match(input,63,FollowSets000.FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getStructuredClassCSAccess().getExtendsKeyword_4_0());

                    }
                    // InternalQVTbase.g:2207:1: ( (lv_ownedSuperTypes_5_0= ruleTypedRefCS ) )
                    // InternalQVTbase.g:2208:1: (lv_ownedSuperTypes_5_0= ruleTypedRefCS )
                    {
                    // InternalQVTbase.g:2208:1: (lv_ownedSuperTypes_5_0= ruleTypedRefCS )
                    // InternalQVTbase.g:2209:3: lv_ownedSuperTypes_5_0= ruleTypedRefCS
                    {
                    if ( state.backtracking==0 ) {

                      	        newCompositeNode(grammarAccess.getStructuredClassCSAccess().getOwnedSuperTypesTypedRefCSParserRuleCall_4_1_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_55);
                    lv_ownedSuperTypes_5_0=ruleTypedRefCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getStructuredClassCSRule());
                      	        }
                             		add(
                             			current,
                             			"ownedSuperTypes",
                              		lv_ownedSuperTypes_5_0,
                              		"org.eclipse.ocl.xtext.base.Base.TypedRefCS");
                      	        afterParserOrEnumRuleCall();

                    }

                    }


                    }

                    // InternalQVTbase.g:2225:2: (otherlv_6= ',' ( (lv_ownedSuperTypes_7_0= ruleTypedRefCS ) ) )*
                    loop73:
                    do {
                        int alt73=2;
                        int LA73_0 = input.LA(1);

                        if ( (LA73_0==39) ) {
                            alt73=1;
                        }


                        switch (alt73) {
                    	case 1 :
                    	    // InternalQVTbase.g:2225:4: otherlv_6= ',' ( (lv_ownedSuperTypes_7_0= ruleTypedRefCS ) )
                    	    {
                    	    otherlv_6=(Token)match(input,39,FollowSets000.FOLLOW_6); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_6, grammarAccess.getStructuredClassCSAccess().getCommaKeyword_4_2_0());

                    	    }
                    	    // InternalQVTbase.g:2229:1: ( (lv_ownedSuperTypes_7_0= ruleTypedRefCS ) )
                    	    // InternalQVTbase.g:2230:1: (lv_ownedSuperTypes_7_0= ruleTypedRefCS )
                    	    {
                    	    // InternalQVTbase.g:2230:1: (lv_ownedSuperTypes_7_0= ruleTypedRefCS )
                    	    // InternalQVTbase.g:2231:3: lv_ownedSuperTypes_7_0= ruleTypedRefCS
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      	        newCompositeNode(grammarAccess.getStructuredClassCSAccess().getOwnedSuperTypesTypedRefCSParserRuleCall_4_2_1_0());

                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_55);
                    	    lv_ownedSuperTypes_7_0=ruleTypedRefCS();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getStructuredClassCSRule());
                    	      	        }
                    	             		add(
                    	             			current,
                    	             			"ownedSuperTypes",
                    	              		lv_ownedSuperTypes_7_0,
                    	              		"org.eclipse.ocl.xtext.base.Base.TypedRefCS");
                    	      	        afterParserOrEnumRuleCall();

                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop73;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalQVTbase.g:2247:6: (otherlv_8= ':' ( (lv_instanceClassName_9_0= RULE_SINGLE_QUOTED_STRING ) ) )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==20) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // InternalQVTbase.g:2247:8: otherlv_8= ':' ( (lv_instanceClassName_9_0= RULE_SINGLE_QUOTED_STRING ) )
                    {
                    otherlv_8=(Token)match(input,20,FollowSets000.FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getStructuredClassCSAccess().getColonKeyword_5_0());

                    }
                    // InternalQVTbase.g:2251:1: ( (lv_instanceClassName_9_0= RULE_SINGLE_QUOTED_STRING ) )
                    // InternalQVTbase.g:2252:1: (lv_instanceClassName_9_0= RULE_SINGLE_QUOTED_STRING )
                    {
                    // InternalQVTbase.g:2252:1: (lv_instanceClassName_9_0= RULE_SINGLE_QUOTED_STRING )
                    // InternalQVTbase.g:2253:3: lv_instanceClassName_9_0= RULE_SINGLE_QUOTED_STRING
                    {
                    lv_instanceClassName_9_0=(Token)match(input,RULE_SINGLE_QUOTED_STRING,FollowSets000.FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_instanceClassName_9_0, grammarAccess.getStructuredClassCSAccess().getInstanceClassNameSINGLE_QUOTED_STRINGTerminalRuleCall_5_1_0());

                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getStructuredClassCSRule());
                      	        }
                             		setWithLastConsumed(
                             			current,
                             			"instanceClassName",
                              		lv_instanceClassName_9_0,
                              		"org.eclipse.ocl.xtext.base.Base.SINGLE_QUOTED_STRING");

                    }

                    }


                    }


                    }
                    break;

            }

            // InternalQVTbase.g:2269:4: (otherlv_10= '{' ( (lv_isInterface_11_0= 'interface' ) )? otherlv_12= '}' )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==22) ) {
                int LA77_1 = input.LA(2);

                if ( (LA77_1==40) ) {
                    int LA77_3 = input.LA(3);

                    if ( (LA77_3==22||LA77_3==42) ) {
                        alt77=1;
                    }
                }
                else if ( (LA77_1==64) ) {
                    alt77=1;
                }
            }
            switch (alt77) {
                case 1 :
                    // InternalQVTbase.g:2269:6: otherlv_10= '{' ( (lv_isInterface_11_0= 'interface' ) )? otherlv_12= '}'
                    {
                    otherlv_10=(Token)match(input,22,FollowSets000.FOLLOW_56); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getStructuredClassCSAccess().getLeftCurlyBracketKeyword_6_0());

                    }
                    // InternalQVTbase.g:2273:1: ( (lv_isInterface_11_0= 'interface' ) )?
                    int alt76=2;
                    int LA76_0 = input.LA(1);

                    if ( (LA76_0==64) ) {
                        alt76=1;
                    }
                    switch (alt76) {
                        case 1 :
                            // InternalQVTbase.g:2274:1: (lv_isInterface_11_0= 'interface' )
                            {
                            // InternalQVTbase.g:2274:1: (lv_isInterface_11_0= 'interface' )
                            // InternalQVTbase.g:2275:3: lv_isInterface_11_0= 'interface'
                            {
                            lv_isInterface_11_0=(Token)match(input,64,FollowSets000.FOLLOW_23); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_isInterface_11_0, grammarAccess.getStructuredClassCSAccess().getIsInterfaceInterfaceKeyword_6_1_0());

                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getStructuredClassCSRule());
                              	        }
                                     		setWithLastConsumed(current, "isInterface", true, "interface");

                            }

                            }


                            }
                            break;

                    }

                    otherlv_12=(Token)match(input,40,FollowSets000.FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_12, grammarAccess.getStructuredClassCSAccess().getRightCurlyBracketKeyword_6_2());

                    }

                    }
                    break;

            }

            // InternalQVTbase.g:2292:3: ( (otherlv_13= '{' ( ( (lv_ownedOperations_14_0= ruleOperationCS ) ) | ( (lv_ownedProperties_15_0= ruleStructuralFeatureCS ) ) )* otherlv_16= '}' ) | otherlv_17= ';' )
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==22) ) {
                alt79=1;
            }
            else if ( (LA79_0==42) ) {
                alt79=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 79, 0, input);

                throw nvae;
            }
            switch (alt79) {
                case 1 :
                    // InternalQVTbase.g:2292:4: (otherlv_13= '{' ( ( (lv_ownedOperations_14_0= ruleOperationCS ) ) | ( (lv_ownedProperties_15_0= ruleStructuralFeatureCS ) ) )* otherlv_16= '}' )
                    {
                    // InternalQVTbase.g:2292:4: (otherlv_13= '{' ( ( (lv_ownedOperations_14_0= ruleOperationCS ) ) | ( (lv_ownedProperties_15_0= ruleStructuralFeatureCS ) ) )* otherlv_16= '}' )
                    // InternalQVTbase.g:2292:6: otherlv_13= '{' ( ( (lv_ownedOperations_14_0= ruleOperationCS ) ) | ( (lv_ownedProperties_15_0= ruleStructuralFeatureCS ) ) )* otherlv_16= '}'
                    {
                    otherlv_13=(Token)match(input,22,FollowSets000.FOLLOW_57); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getStructuredClassCSAccess().getLeftCurlyBracketKeyword_7_0_0());

                    }
                    // InternalQVTbase.g:2296:1: ( ( (lv_ownedOperations_14_0= ruleOperationCS ) ) | ( (lv_ownedProperties_15_0= ruleStructuralFeatureCS ) ) )*
                    loop78:
                    do {
                        int alt78=3;
                        switch ( input.LA(1) ) {
                        case 17:
                            {
                            switch ( input.LA(2) ) {
                            case 18:
                                {
                                int LA78_6 = input.LA(3);

                                if ( (LA78_6==50) ) {
                                    alt78=1;
                                }
                                else if ( (LA78_6==19||LA78_6==55) ) {
                                    alt78=2;
                                }


                                }
                                break;
                            case 19:
                            case 55:
                                {
                                alt78=2;
                                }
                                break;
                            case 50:
                                {
                                alt78=1;
                                }
                                break;

                            }

                            }
                            break;
                        case 18:
                            {
                            switch ( input.LA(2) ) {
                            case 17:
                                {
                                int LA78_7 = input.LA(3);

                                if ( (LA78_7==19||LA78_7==55) ) {
                                    alt78=2;
                                }
                                else if ( (LA78_7==50) ) {
                                    alt78=1;
                                }


                                }
                                break;
                            case 50:
                                {
                                alt78=1;
                                }
                                break;
                            case 19:
                            case 55:
                                {
                                alt78=2;
                                }
                                break;

                            }

                            }
                            break;
                        case 50:
                            {
                            alt78=1;
                            }
                            break;
                        case 19:
                        case 55:
                            {
                            alt78=2;
                            }
                            break;

                        }

                        switch (alt78) {
                    	case 1 :
                    	    // InternalQVTbase.g:2296:2: ( (lv_ownedOperations_14_0= ruleOperationCS ) )
                    	    {
                    	    // InternalQVTbase.g:2296:2: ( (lv_ownedOperations_14_0= ruleOperationCS ) )
                    	    // InternalQVTbase.g:2297:1: (lv_ownedOperations_14_0= ruleOperationCS )
                    	    {
                    	    // InternalQVTbase.g:2297:1: (lv_ownedOperations_14_0= ruleOperationCS )
                    	    // InternalQVTbase.g:2298:3: lv_ownedOperations_14_0= ruleOperationCS
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      	        newCompositeNode(grammarAccess.getStructuredClassCSAccess().getOwnedOperationsOperationCSParserRuleCall_7_0_1_0_0());

                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_57);
                    	    lv_ownedOperations_14_0=ruleOperationCS();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getStructuredClassCSRule());
                    	      	        }
                    	             		add(
                    	             			current,
                    	             			"ownedOperations",
                    	              		lv_ownedOperations_14_0,
                    	              		"org.eclipse.qvtd.xtext.qvtbase.QVTbase.OperationCS");
                    	      	        afterParserOrEnumRuleCall();

                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalQVTbase.g:2315:6: ( (lv_ownedProperties_15_0= ruleStructuralFeatureCS ) )
                    	    {
                    	    // InternalQVTbase.g:2315:6: ( (lv_ownedProperties_15_0= ruleStructuralFeatureCS ) )
                    	    // InternalQVTbase.g:2316:1: (lv_ownedProperties_15_0= ruleStructuralFeatureCS )
                    	    {
                    	    // InternalQVTbase.g:2316:1: (lv_ownedProperties_15_0= ruleStructuralFeatureCS )
                    	    // InternalQVTbase.g:2317:3: lv_ownedProperties_15_0= ruleStructuralFeatureCS
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      	        newCompositeNode(grammarAccess.getStructuredClassCSAccess().getOwnedPropertiesStructuralFeatureCSParserRuleCall_7_0_1_1_0());

                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_57);
                    	    lv_ownedProperties_15_0=ruleStructuralFeatureCS();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getStructuredClassCSRule());
                    	      	        }
                    	             		add(
                    	             			current,
                    	             			"ownedProperties",
                    	              		lv_ownedProperties_15_0,
                    	              		"org.eclipse.qvtd.xtext.qvtbase.QVTbase.StructuralFeatureCS");
                    	      	        afterParserOrEnumRuleCall();

                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop78;
                        }
                    } while (true);

                    otherlv_16=(Token)match(input,40,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_16, grammarAccess.getStructuredClassCSAccess().getRightCurlyBracketKeyword_7_0_2());

                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalQVTbase.g:2338:7: otherlv_17= ';'
                    {
                    otherlv_17=(Token)match(input,42,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_17, grammarAccess.getStructuredClassCSAccess().getSemicolonKeyword_7_1());

                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStructuredClassCS"


    // $ANTLR start "entryRuleTypedMultiplicityRefCS"
    // InternalQVTbase.g:2350:1: entryRuleTypedMultiplicityRefCS returns [EObject current=null] : iv_ruleTypedMultiplicityRefCS= ruleTypedMultiplicityRefCS EOF ;
    public final EObject entryRuleTypedMultiplicityRefCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypedMultiplicityRefCS = null;


        try {
            // InternalQVTbase.g:2351:2: (iv_ruleTypedMultiplicityRefCS= ruleTypedMultiplicityRefCS EOF )
            // InternalQVTbase.g:2352:2: iv_ruleTypedMultiplicityRefCS= ruleTypedMultiplicityRefCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypedMultiplicityRefCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTypedMultiplicityRefCS=ruleTypedMultiplicityRefCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypedMultiplicityRefCS;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypedMultiplicityRefCS"


    // $ANTLR start "ruleTypedMultiplicityRefCS"
    // InternalQVTbase.g:2359:1: ruleTypedMultiplicityRefCS returns [EObject current=null] : (this_TypedRefCS_0= ruleTypedRefCS ( (lv_ownedMultiplicity_1_0= ruleMultiplicityCS ) )? ) ;
    public final EObject ruleTypedMultiplicityRefCS() throws RecognitionException {
        EObject current = null;

        EObject this_TypedRefCS_0 = null;

        EObject lv_ownedMultiplicity_1_0 = null;


         enterRule();

        try {
            // InternalQVTbase.g:2362:28: ( (this_TypedRefCS_0= ruleTypedRefCS ( (lv_ownedMultiplicity_1_0= ruleMultiplicityCS ) )? ) )
            // InternalQVTbase.g:2363:1: (this_TypedRefCS_0= ruleTypedRefCS ( (lv_ownedMultiplicity_1_0= ruleMultiplicityCS ) )? )
            {
            // InternalQVTbase.g:2363:1: (this_TypedRefCS_0= ruleTypedRefCS ( (lv_ownedMultiplicity_1_0= ruleMultiplicityCS ) )? )
            // InternalQVTbase.g:2364:2: this_TypedRefCS_0= ruleTypedRefCS ( (lv_ownedMultiplicity_1_0= ruleMultiplicityCS ) )?
            {
            if ( state.backtracking==0 ) {

              	  /* */

            }
            if ( state.backtracking==0 ) {

                      newCompositeNode(grammarAccess.getTypedMultiplicityRefCSAccess().getTypedRefCSParserRuleCall_0());

            }
            pushFollow(FollowSets000.FOLLOW_58);
            this_TypedRefCS_0=ruleTypedRefCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current = this_TypedRefCS_0;
                      afterParserOrEnumRuleCall();

            }
            // InternalQVTbase.g:2375:1: ( (lv_ownedMultiplicity_1_0= ruleMultiplicityCS ) )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==108) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // InternalQVTbase.g:2376:1: (lv_ownedMultiplicity_1_0= ruleMultiplicityCS )
                    {
                    // InternalQVTbase.g:2376:1: (lv_ownedMultiplicity_1_0= ruleMultiplicityCS )
                    // InternalQVTbase.g:2377:3: lv_ownedMultiplicity_1_0= ruleMultiplicityCS
                    {
                    if ( state.backtracking==0 ) {

                      	        newCompositeNode(grammarAccess.getTypedMultiplicityRefCSAccess().getOwnedMultiplicityMultiplicityCSParserRuleCall_1_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_ownedMultiplicity_1_0=ruleMultiplicityCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTypedMultiplicityRefCSRule());
                      	        }
                             		set(
                             			current,
                             			"ownedMultiplicity",
                              		lv_ownedMultiplicity_1_0,
                              		"org.eclipse.ocl.xtext.base.Base.MultiplicityCS");
                      	        afterParserOrEnumRuleCall();

                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypedMultiplicityRefCS"


    // $ANTLR start "entryRuleStructuralFeatureCS"
    // InternalQVTbase.g:2401:1: entryRuleStructuralFeatureCS returns [EObject current=null] : iv_ruleStructuralFeatureCS= ruleStructuralFeatureCS EOF ;
    public final EObject entryRuleStructuralFeatureCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStructuralFeatureCS = null;


        try {
            // InternalQVTbase.g:2402:2: (iv_ruleStructuralFeatureCS= ruleStructuralFeatureCS EOF )
            // InternalQVTbase.g:2403:2: iv_ruleStructuralFeatureCS= ruleStructuralFeatureCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStructuralFeatureCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleStructuralFeatureCS=ruleStructuralFeatureCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStructuralFeatureCS;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStructuralFeatureCS"


    // $ANTLR start "ruleStructuralFeatureCS"
    // InternalQVTbase.g:2410:1: ruleStructuralFeatureCS returns [EObject current=null] : (this_AttributeCS_0= ruleAttributeCS | this_ReferenceCS_1= ruleReferenceCS ) ;
    public final EObject ruleStructuralFeatureCS() throws RecognitionException {
        EObject current = null;

        EObject this_AttributeCS_0 = null;

        EObject this_ReferenceCS_1 = null;


         enterRule();

        try {
            // InternalQVTbase.g:2413:28: ( (this_AttributeCS_0= ruleAttributeCS | this_ReferenceCS_1= ruleReferenceCS ) )
            // InternalQVTbase.g:2414:1: (this_AttributeCS_0= ruleAttributeCS | this_ReferenceCS_1= ruleReferenceCS )
            {
            // InternalQVTbase.g:2414:1: (this_AttributeCS_0= ruleAttributeCS | this_ReferenceCS_1= ruleReferenceCS )
            int alt81=2;
            switch ( input.LA(1) ) {
            case 17:
                {
                switch ( input.LA(2) ) {
                case 18:
                    {
                    int LA81_5 = input.LA(3);

                    if ( (LA81_5==55) ) {
                        alt81=2;
                    }
                    else if ( (LA81_5==19) ) {
                        alt81=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 81, 5, input);

                        throw nvae;
                    }
                    }
                    break;
                case 55:
                    {
                    alt81=2;
                    }
                    break;
                case 19:
                    {
                    alt81=1;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 81, 1, input);

                    throw nvae;
                }

                }
                break;
            case 18:
                {
                switch ( input.LA(2) ) {
                case 17:
                    {
                    int LA81_6 = input.LA(3);

                    if ( (LA81_6==19) ) {
                        alt81=1;
                    }
                    else if ( (LA81_6==55) ) {
                        alt81=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 81, 6, input);

                        throw nvae;
                    }
                    }
                    break;
                case 55:
                    {
                    alt81=2;
                    }
                    break;
                case 19:
                    {
                    alt81=1;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 81, 2, input);

                    throw nvae;
                }

                }
                break;
            case 19:
                {
                alt81=1;
                }
                break;
            case 55:
                {
                alt81=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 81, 0, input);

                throw nvae;
            }

            switch (alt81) {
                case 1 :
                    // InternalQVTbase.g:2415:2: this_AttributeCS_0= ruleAttributeCS
                    {
                    if ( state.backtracking==0 ) {

                      	  /* */

                    }
                    if ( state.backtracking==0 ) {

                              newCompositeNode(grammarAccess.getStructuralFeatureCSAccess().getAttributeCSParserRuleCall_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_AttributeCS_0=ruleAttributeCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_AttributeCS_0;
                              afterParserOrEnumRuleCall();

                    }

                    }
                    break;
                case 2 :
                    // InternalQVTbase.g:2428:2: this_ReferenceCS_1= ruleReferenceCS
                    {
                    if ( state.backtracking==0 ) {

                      	  /* */

                    }
                    if ( state.backtracking==0 ) {

                              newCompositeNode(grammarAccess.getStructuralFeatureCSAccess().getReferenceCSParserRuleCall_1());

                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ReferenceCS_1=ruleReferenceCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_ReferenceCS_1;
                              afterParserOrEnumRuleCall();

                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStructuralFeatureCS"


    // $ANTLR start "entryRuleEnumerationLiteralName"
    // InternalQVTbase.g:2447:1: entryRuleEnumerationLiteralName returns [String current=null] : iv_ruleEnumerationLiteralName= ruleEnumerationLiteralName EOF ;
    public final String entryRuleEnumerationLiteralName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEnumerationLiteralName = null;


        try {
            // InternalQVTbase.g:2448:2: (iv_ruleEnumerationLiteralName= ruleEnumerationLiteralName EOF )
            // InternalQVTbase.g:2449:2: iv_ruleEnumerationLiteralName= ruleEnumerationLiteralName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEnumerationLiteralNameRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEnumerationLiteralName=ruleEnumerationLiteralName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEnumerationLiteralName.getText();
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEnumerationLiteralName"


    // $ANTLR start "ruleEnumerationLiteralName"
    // InternalQVTbase.g:2456:1: ruleEnumerationLiteralName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_EssentialOCLUnrestrictedName_0= ruleEssentialOCLUnrestrictedName ;
    public final AntlrDatatypeRuleToken ruleEnumerationLiteralName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_EssentialOCLUnrestrictedName_0 = null;


         enterRule();

        try {
            // InternalQVTbase.g:2459:28: (this_EssentialOCLUnrestrictedName_0= ruleEssentialOCLUnrestrictedName )
            // InternalQVTbase.g:2461:5: this_EssentialOCLUnrestrictedName_0= ruleEssentialOCLUnrestrictedName
            {
            if ( state.backtracking==0 ) {

                      newCompositeNode(grammarAccess.getEnumerationLiteralNameAccess().getEssentialOCLUnrestrictedNameParserRuleCall());

            }
            pushFollow(FollowSets000.FOLLOW_2);
            this_EssentialOCLUnrestrictedName_0=ruleEssentialOCLUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_EssentialOCLUnrestrictedName_0);

            }
            if ( state.backtracking==0 ) {

                      afterParserOrEnumRuleCall();

            }

            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEnumerationLiteralName"


    // $ANTLR start "entryRuleSIGNED"
    // InternalQVTbase.g:2479:1: entryRuleSIGNED returns [String current=null] : iv_ruleSIGNED= ruleSIGNED EOF ;
    public final String entryRuleSIGNED() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSIGNED = null;


        try {
            // InternalQVTbase.g:2480:2: (iv_ruleSIGNED= ruleSIGNED EOF )
            // InternalQVTbase.g:2481:2: iv_ruleSIGNED= ruleSIGNED EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSIGNEDRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSIGNED=ruleSIGNED();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSIGNED.getText();
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSIGNED"


    // $ANTLR start "ruleSIGNED"
    // InternalQVTbase.g:2488:1: ruleSIGNED returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? this_INT_1= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleSIGNED() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;

         enterRule();

        try {
            // InternalQVTbase.g:2491:28: ( ( (kw= '-' )? this_INT_1= RULE_INT ) )
            // InternalQVTbase.g:2492:1: ( (kw= '-' )? this_INT_1= RULE_INT )
            {
            // InternalQVTbase.g:2492:1: ( (kw= '-' )? this_INT_1= RULE_INT )
            // InternalQVTbase.g:2492:2: (kw= '-' )? this_INT_1= RULE_INT
            {
            // InternalQVTbase.g:2492:2: (kw= '-' )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==65) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // InternalQVTbase.g:2493:2: kw= '-'
                    {
                    kw=(Token)match(input,65,FollowSets000.FOLLOW_59); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSIGNEDAccess().getHyphenMinusKeyword_0());

                    }

                    }
                    break;

            }

            this_INT_1=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_INT_1);

            }
            if ( state.backtracking==0 ) {

                  newLeafNode(this_INT_1, grammarAccess.getSIGNEDAccess().getINTTerminalRuleCall_1());

            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSIGNED"


    // $ANTLR start "entryRuleEssentialOCLUnaryOperatorName"
    // InternalQVTbase.g:2517:1: entryRuleEssentialOCLUnaryOperatorName returns [String current=null] : iv_ruleEssentialOCLUnaryOperatorName= ruleEssentialOCLUnaryOperatorName EOF ;
    public final String entryRuleEssentialOCLUnaryOperatorName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEssentialOCLUnaryOperatorName = null;


        try {
            // InternalQVTbase.g:2518:2: (iv_ruleEssentialOCLUnaryOperatorName= ruleEssentialOCLUnaryOperatorName EOF )
            // InternalQVTbase.g:2519:2: iv_ruleEssentialOCLUnaryOperatorName= ruleEssentialOCLUnaryOperatorName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEssentialOCLUnaryOperatorNameRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEssentialOCLUnaryOperatorName=ruleEssentialOCLUnaryOperatorName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEssentialOCLUnaryOperatorName.getText();
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEssentialOCLUnaryOperatorName"


    // $ANTLR start "ruleEssentialOCLUnaryOperatorName"
    // InternalQVTbase.g:2526:1: ruleEssentialOCLUnaryOperatorName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '-' | kw= 'not' ) ;
    public final AntlrDatatypeRuleToken ruleEssentialOCLUnaryOperatorName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule();

        try {
            // InternalQVTbase.g:2529:28: ( (kw= '-' | kw= 'not' ) )
            // InternalQVTbase.g:2530:1: (kw= '-' | kw= 'not' )
            {
            // InternalQVTbase.g:2530:1: (kw= '-' | kw= 'not' )
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==65) ) {
                alt83=1;
            }
            else if ( (LA83_0==66) ) {
                alt83=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 83, 0, input);

                throw nvae;
            }
            switch (alt83) {
                case 1 :
                    // InternalQVTbase.g:2531:2: kw= '-'
                    {
                    kw=(Token)match(input,65,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLUnaryOperatorNameAccess().getHyphenMinusKeyword_0());

                    }

                    }
                    break;
                case 2 :
                    // InternalQVTbase.g:2538:2: kw= 'not'
                    {
                    kw=(Token)match(input,66,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLUnaryOperatorNameAccess().getNotKeyword_1());

                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEssentialOCLUnaryOperatorName"


    // $ANTLR start "entryRuleEssentialOCLInfixOperatorName"
    // InternalQVTbase.g:2551:1: entryRuleEssentialOCLInfixOperatorName returns [String current=null] : iv_ruleEssentialOCLInfixOperatorName= ruleEssentialOCLInfixOperatorName EOF ;
    public final String entryRuleEssentialOCLInfixOperatorName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEssentialOCLInfixOperatorName = null;


        try {
            // InternalQVTbase.g:2552:2: (iv_ruleEssentialOCLInfixOperatorName= ruleEssentialOCLInfixOperatorName EOF )
            // InternalQVTbase.g:2553:2: iv_ruleEssentialOCLInfixOperatorName= ruleEssentialOCLInfixOperatorName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEssentialOCLInfixOperatorNameRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEssentialOCLInfixOperatorName=ruleEssentialOCLInfixOperatorName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEssentialOCLInfixOperatorName.getText();
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEssentialOCLInfixOperatorName"


    // $ANTLR start "ruleEssentialOCLInfixOperatorName"
    // InternalQVTbase.g:2560:1: ruleEssentialOCLInfixOperatorName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '*' | kw= '/' | kw= '+' | kw= '-' | kw= '>' | kw= '<' | kw= '>=' | kw= '<=' | kw= '=' | kw= '<>' | kw= 'and' | kw= 'or' | kw= 'xor' | kw= 'implies' ) ;
    public final AntlrDatatypeRuleToken ruleEssentialOCLInfixOperatorName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule();

        try {
            // InternalQVTbase.g:2563:28: ( (kw= '*' | kw= '/' | kw= '+' | kw= '-' | kw= '>' | kw= '<' | kw= '>=' | kw= '<=' | kw= '=' | kw= '<>' | kw= 'and' | kw= 'or' | kw= 'xor' | kw= 'implies' ) )
            // InternalQVTbase.g:2564:1: (kw= '*' | kw= '/' | kw= '+' | kw= '-' | kw= '>' | kw= '<' | kw= '>=' | kw= '<=' | kw= '=' | kw= '<>' | kw= 'and' | kw= 'or' | kw= 'xor' | kw= 'implies' )
            {
            // InternalQVTbase.g:2564:1: (kw= '*' | kw= '/' | kw= '+' | kw= '-' | kw= '>' | kw= '<' | kw= '>=' | kw= '<=' | kw= '=' | kw= '<>' | kw= 'and' | kw= 'or' | kw= 'xor' | kw= 'implies' )
            int alt84=14;
            switch ( input.LA(1) ) {
            case 67:
                {
                alt84=1;
                }
                break;
            case 68:
                {
                alt84=2;
                }
                break;
            case 69:
                {
                alt84=3;
                }
                break;
            case 65:
                {
                alt84=4;
                }
                break;
            case 70:
                {
                alt84=5;
                }
                break;
            case 71:
                {
                alt84=6;
                }
                break;
            case 72:
                {
                alt84=7;
                }
                break;
            case 73:
                {
                alt84=8;
                }
                break;
            case 21:
                {
                alt84=9;
                }
                break;
            case 74:
                {
                alt84=10;
                }
                break;
            case 75:
                {
                alt84=11;
                }
                break;
            case 76:
                {
                alt84=12;
                }
                break;
            case 77:
                {
                alt84=13;
                }
                break;
            case 78:
                {
                alt84=14;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 84, 0, input);

                throw nvae;
            }

            switch (alt84) {
                case 1 :
                    // InternalQVTbase.g:2565:2: kw= '*'
                    {
                    kw=(Token)match(input,67,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getAsteriskKeyword_0());

                    }

                    }
                    break;
                case 2 :
                    // InternalQVTbase.g:2572:2: kw= '/'
                    {
                    kw=(Token)match(input,68,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getSolidusKeyword_1());

                    }

                    }
                    break;
                case 3 :
                    // InternalQVTbase.g:2579:2: kw= '+'
                    {
                    kw=(Token)match(input,69,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getPlusSignKeyword_2());

                    }

                    }
                    break;
                case 4 :
                    // InternalQVTbase.g:2586:2: kw= '-'
                    {
                    kw=(Token)match(input,65,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getHyphenMinusKeyword_3());

                    }

                    }
                    break;
                case 5 :
                    // InternalQVTbase.g:2593:2: kw= '>'
                    {
                    kw=(Token)match(input,70,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getGreaterThanSignKeyword_4());

                    }

                    }
                    break;
                case 6 :
                    // InternalQVTbase.g:2600:2: kw= '<'
                    {
                    kw=(Token)match(input,71,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getLessThanSignKeyword_5());

                    }

                    }
                    break;
                case 7 :
                    // InternalQVTbase.g:2607:2: kw= '>='
                    {
                    kw=(Token)match(input,72,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getGreaterThanSignEqualsSignKeyword_6());

                    }

                    }
                    break;
                case 8 :
                    // InternalQVTbase.g:2614:2: kw= '<='
                    {
                    kw=(Token)match(input,73,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getLessThanSignEqualsSignKeyword_7());

                    }

                    }
                    break;
                case 9 :
                    // InternalQVTbase.g:2621:2: kw= '='
                    {
                    kw=(Token)match(input,21,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getEqualsSignKeyword_8());

                    }

                    }
                    break;
                case 10 :
                    // InternalQVTbase.g:2628:2: kw= '<>'
                    {
                    kw=(Token)match(input,74,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getLessThanSignGreaterThanSignKeyword_9());

                    }

                    }
                    break;
                case 11 :
                    // InternalQVTbase.g:2635:2: kw= 'and'
                    {
                    kw=(Token)match(input,75,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getAndKeyword_10());

                    }

                    }
                    break;
                case 12 :
                    // InternalQVTbase.g:2642:2: kw= 'or'
                    {
                    kw=(Token)match(input,76,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getOrKeyword_11());

                    }

                    }
                    break;
                case 13 :
                    // InternalQVTbase.g:2649:2: kw= 'xor'
                    {
                    kw=(Token)match(input,77,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getXorKeyword_12());

                    }

                    }
                    break;
                case 14 :
                    // InternalQVTbase.g:2656:2: kw= 'implies'
                    {
                    kw=(Token)match(input,78,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getImpliesKeyword_13());

                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEssentialOCLInfixOperatorName"


    // $ANTLR start "entryRuleEssentialOCLNavigationOperatorName"
    // InternalQVTbase.g:2669:1: entryRuleEssentialOCLNavigationOperatorName returns [String current=null] : iv_ruleEssentialOCLNavigationOperatorName= ruleEssentialOCLNavigationOperatorName EOF ;
    public final String entryRuleEssentialOCLNavigationOperatorName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEssentialOCLNavigationOperatorName = null;


        try {
            // InternalQVTbase.g:2670:2: (iv_ruleEssentialOCLNavigationOperatorName= ruleEssentialOCLNavigationOperatorName EOF )
            // InternalQVTbase.g:2671:2: iv_ruleEssentialOCLNavigationOperatorName= ruleEssentialOCLNavigationOperatorName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEssentialOCLNavigationOperatorNameRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEssentialOCLNavigationOperatorName=ruleEssentialOCLNavigationOperatorName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEssentialOCLNavigationOperatorName.getText();
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEssentialOCLNavigationOperatorName"


    // $ANTLR start "ruleEssentialOCLNavigationOperatorName"
    // InternalQVTbase.g:2678:1: ruleEssentialOCLNavigationOperatorName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '.' | kw= '->' | kw= '?.' | kw= '?->' ) ;
    public final AntlrDatatypeRuleToken ruleEssentialOCLNavigationOperatorName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule();

        try {
            // InternalQVTbase.g:2681:28: ( (kw= '.' | kw= '->' | kw= '?.' | kw= '?->' ) )
            // InternalQVTbase.g:2682:1: (kw= '.' | kw= '->' | kw= '?.' | kw= '?->' )
            {
            // InternalQVTbase.g:2682:1: (kw= '.' | kw= '->' | kw= '?.' | kw= '?->' )
            int alt85=4;
            switch ( input.LA(1) ) {
            case 79:
                {
                alt85=1;
                }
                break;
            case 80:
                {
                alt85=2;
                }
                break;
            case 81:
                {
                alt85=3;
                }
                break;
            case 82:
                {
                alt85=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 85, 0, input);

                throw nvae;
            }

            switch (alt85) {
                case 1 :
                    // InternalQVTbase.g:2683:2: kw= '.'
                    {
                    kw=(Token)match(input,79,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLNavigationOperatorNameAccess().getFullStopKeyword_0());

                    }

                    }
                    break;
                case 2 :
                    // InternalQVTbase.g:2690:2: kw= '->'
                    {
                    kw=(Token)match(input,80,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLNavigationOperatorNameAccess().getHyphenMinusGreaterThanSignKeyword_1());

                    }

                    }
                    break;
                case 3 :
                    // InternalQVTbase.g:2697:2: kw= '?.'
                    {
                    kw=(Token)match(input,81,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLNavigationOperatorNameAccess().getQuestionMarkFullStopKeyword_2());

                    }

                    }
                    break;
                case 4 :
                    // InternalQVTbase.g:2704:2: kw= '?->'
                    {
                    kw=(Token)match(input,82,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLNavigationOperatorNameAccess().getQuestionMarkHyphenMinusGreaterThanSignKeyword_3());

                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEssentialOCLNavigationOperatorName"


    // $ANTLR start "entryRuleBinaryOperatorName"
    // InternalQVTbase.g:2717:1: entryRuleBinaryOperatorName returns [String current=null] : iv_ruleBinaryOperatorName= ruleBinaryOperatorName EOF ;
    public final String entryRuleBinaryOperatorName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBinaryOperatorName = null;


        try {
            // InternalQVTbase.g:2718:2: (iv_ruleBinaryOperatorName= ruleBinaryOperatorName EOF )
            // InternalQVTbase.g:2719:2: iv_ruleBinaryOperatorName= ruleBinaryOperatorName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBinaryOperatorNameRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleBinaryOperatorName=ruleBinaryOperatorName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBinaryOperatorName.getText();
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBinaryOperatorName"


    // $ANTLR start "ruleBinaryOperatorName"
    // InternalQVTbase.g:2726:1: ruleBinaryOperatorName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_InfixOperatorName_0= ruleInfixOperatorName | this_NavigationOperatorName_1= ruleNavigationOperatorName ) ;
    public final AntlrDatatypeRuleToken ruleBinaryOperatorName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_InfixOperatorName_0 = null;

        AntlrDatatypeRuleToken this_NavigationOperatorName_1 = null;


         enterRule();

        try {
            // InternalQVTbase.g:2729:28: ( (this_InfixOperatorName_0= ruleInfixOperatorName | this_NavigationOperatorName_1= ruleNavigationOperatorName ) )
            // InternalQVTbase.g:2730:1: (this_InfixOperatorName_0= ruleInfixOperatorName | this_NavigationOperatorName_1= ruleNavigationOperatorName )
            {
            // InternalQVTbase.g:2730:1: (this_InfixOperatorName_0= ruleInfixOperatorName | this_NavigationOperatorName_1= ruleNavigationOperatorName )
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==21||LA86_0==65||(LA86_0>=67 && LA86_0<=78)) ) {
                alt86=1;
            }
            else if ( ((LA86_0>=79 && LA86_0<=82)) ) {
                alt86=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 86, 0, input);

                throw nvae;
            }
            switch (alt86) {
                case 1 :
                    // InternalQVTbase.g:2731:5: this_InfixOperatorName_0= ruleInfixOperatorName
                    {
                    if ( state.backtracking==0 ) {

                              newCompositeNode(grammarAccess.getBinaryOperatorNameAccess().getInfixOperatorNameParserRuleCall_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_InfixOperatorName_0=ruleInfixOperatorName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_InfixOperatorName_0);

                    }
                    if ( state.backtracking==0 ) {

                              afterParserOrEnumRuleCall();

                    }

                    }
                    break;
                case 2 :
                    // InternalQVTbase.g:2743:5: this_NavigationOperatorName_1= ruleNavigationOperatorName
                    {
                    if ( state.backtracking==0 ) {

                              newCompositeNode(grammarAccess.getBinaryOperatorNameAccess().getNavigationOperatorNameParserRuleCall_1());

                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_NavigationOperatorName_1=ruleNavigationOperatorName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_NavigationOperatorName_1);

                    }
                    if ( state.backtracking==0 ) {

                              afterParserOrEnumRuleCall();

                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBinaryOperatorName"


    // $ANTLR start "entryRuleInfixOperatorName"
    // InternalQVTbase.g:2761:1: entryRuleInfixOperatorName returns [String current=null] : iv_ruleInfixOperatorName= ruleInfixOperatorName EOF ;
    public final String entryRuleInfixOperatorName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInfixOperatorName = null;


        try {
            // InternalQVTbase.g:2762:2: (iv_ruleInfixOperatorName= ruleInfixOperatorName EOF )
            // InternalQVTbase.g:2763:2: iv_ruleInfixOperatorName= ruleInfixOperatorName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInfixOperatorNameRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleInfixOperatorName=ruleInfixOperatorName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInfixOperatorName.getText();
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInfixOperatorName"


    // $ANTLR start "ruleInfixOperatorName"
    // InternalQVTbase.g:2770:1: ruleInfixOperatorName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_EssentialOCLInfixOperatorName_0= ruleEssentialOCLInfixOperatorName ;
    public final AntlrDatatypeRuleToken ruleInfixOperatorName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_EssentialOCLInfixOperatorName_0 = null;


         enterRule();

        try {
            // InternalQVTbase.g:2773:28: (this_EssentialOCLInfixOperatorName_0= ruleEssentialOCLInfixOperatorName )
            // InternalQVTbase.g:2775:5: this_EssentialOCLInfixOperatorName_0= ruleEssentialOCLInfixOperatorName
            {
            if ( state.backtracking==0 ) {

                      newCompositeNode(grammarAccess.getInfixOperatorNameAccess().getEssentialOCLInfixOperatorNameParserRuleCall());

            }
            pushFollow(FollowSets000.FOLLOW_2);
            this_EssentialOCLInfixOperatorName_0=ruleEssentialOCLInfixOperatorName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_EssentialOCLInfixOperatorName_0);

            }
            if ( state.backtracking==0 ) {

                      afterParserOrEnumRuleCall();

            }

            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInfixOperatorName"


    // $ANTLR start "entryRuleNavigationOperatorName"
    // InternalQVTbase.g:2793:1: entryRuleNavigationOperatorName returns [String current=null] : iv_ruleNavigationOperatorName= ruleNavigationOperatorName EOF ;
    public final String entryRuleNavigationOperatorName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNavigationOperatorName = null;


        try {
            // InternalQVTbase.g:2794:2: (iv_ruleNavigationOperatorName= ruleNavigationOperatorName EOF )
            // InternalQVTbase.g:2795:2: iv_ruleNavigationOperatorName= ruleNavigationOperatorName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigationOperatorNameRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNavigationOperatorName=ruleNavigationOperatorName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigationOperatorName.getText();
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNavigationOperatorName"


    // $ANTLR start "ruleNavigationOperatorName"
    // InternalQVTbase.g:2802:1: ruleNavigationOperatorName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_EssentialOCLNavigationOperatorName_0= ruleEssentialOCLNavigationOperatorName ;
    public final AntlrDatatypeRuleToken ruleNavigationOperatorName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_EssentialOCLNavigationOperatorName_0 = null;


         enterRule();

        try {
            // InternalQVTbase.g:2805:28: (this_EssentialOCLNavigationOperatorName_0= ruleEssentialOCLNavigationOperatorName )
            // InternalQVTbase.g:2807:5: this_EssentialOCLNavigationOperatorName_0= ruleEssentialOCLNavigationOperatorName
            {
            if ( state.backtracking==0 ) {

                      newCompositeNode(grammarAccess.getNavigationOperatorNameAccess().getEssentialOCLNavigationOperatorNameParserRuleCall());

            }
            pushFollow(FollowSets000.FOLLOW_2);
            this_EssentialOCLNavigationOperatorName_0=ruleEssentialOCLNavigationOperatorName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_EssentialOCLNavigationOperatorName_0);

            }
            if ( state.backtracking==0 ) {

                      afterParserOrEnumRuleCall();

            }

            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNavigationOperatorName"


    // $ANTLR start "entryRuleUnaryOperatorName"
    // InternalQVTbase.g:2825:1: entryRuleUnaryOperatorName returns [String current=null] : iv_ruleUnaryOperatorName= ruleUnaryOperatorName EOF ;
    public final String entryRuleUnaryOperatorName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnaryOperatorName = null;


        try {
            // InternalQVTbase.g:2826:2: (iv_ruleUnaryOperatorName= ruleUnaryOperatorName EOF )
            // InternalQVTbase.g:2827:2: iv_ruleUnaryOperatorName= ruleUnaryOperatorName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryOperatorNameRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUnaryOperatorName=ruleUnaryOperatorName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnaryOperatorName.getText();
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnaryOperatorName"


    // $ANTLR start "ruleUnaryOperatorName"
    // InternalQVTbase.g:2834:1: ruleUnaryOperatorName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_EssentialOCLUnaryOperatorName_0= ruleEssentialOCLUnaryOperatorName ;
    public final AntlrDatatypeRuleToken ruleUnaryOperatorName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_EssentialOCLUnaryOperatorName_0 = null;


         enterRule();

        try {
            // InternalQVTbase.g:2837:28: (this_EssentialOCLUnaryOperatorName_0= ruleEssentialOCLUnaryOperatorName )
            // InternalQVTbase.g:2839:5: this_EssentialOCLUnaryOperatorName_0= ruleEssentialOCLUnaryOperatorName
            {
            if ( state.backtracking==0 ) {

                      newCompositeNode(grammarAccess.getUnaryOperatorNameAccess().getEssentialOCLUnaryOperatorNameParserRuleCall());

            }
            pushFollow(FollowSets000.FOLLOW_2);
            this_EssentialOCLUnaryOperatorName_0=ruleEssentialOCLUnaryOperatorName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_EssentialOCLUnaryOperatorName_0);

            }
            if ( state.backtracking==0 ) {

                      afterParserOrEnumRuleCall();

            }

            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnaryOperatorName"


    // $ANTLR start "entryRuleEssentialOCLUnrestrictedName"
    // InternalQVTbase.g:2857:1: entryRuleEssentialOCLUnrestrictedName returns [String current=null] : iv_ruleEssentialOCLUnrestrictedName= ruleEssentialOCLUnrestrictedName EOF ;
    public final String entryRuleEssentialOCLUnrestrictedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEssentialOCLUnrestrictedName = null;


        try {
            // InternalQVTbase.g:2858:2: (iv_ruleEssentialOCLUnrestrictedName= ruleEssentialOCLUnrestrictedName EOF )
            // InternalQVTbase.g:2859:2: iv_ruleEssentialOCLUnrestrictedName= ruleEssentialOCLUnrestrictedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEssentialOCLUnrestrictedNameRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEssentialOCLUnrestrictedName=ruleEssentialOCLUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEssentialOCLUnrestrictedName.getText();
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEssentialOCLUnrestrictedName"


    // $ANTLR start "ruleEssentialOCLUnrestrictedName"
    // InternalQVTbase.g:2866:1: ruleEssentialOCLUnrestrictedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_Identifier_0= ruleIdentifier ;
    public final AntlrDatatypeRuleToken ruleEssentialOCLUnrestrictedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_Identifier_0 = null;


         enterRule();

        try {
            // InternalQVTbase.g:2869:28: (this_Identifier_0= ruleIdentifier )
            // InternalQVTbase.g:2871:5: this_Identifier_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {

                      newCompositeNode(grammarAccess.getEssentialOCLUnrestrictedNameAccess().getIdentifierParserRuleCall());

            }
            pushFollow(FollowSets000.FOLLOW_2);
            this_Identifier_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_Identifier_0);

            }
            if ( state.backtracking==0 ) {

                      afterParserOrEnumRuleCall();

            }

            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEssentialOCLUnrestrictedName"


    // $ANTLR start "entryRuleUnrestrictedName"
    // InternalQVTbase.g:2889:1: entryRuleUnrestrictedName returns [String current=null] : iv_ruleUnrestrictedName= ruleUnrestrictedName EOF ;
    public final String entryRuleUnrestrictedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnrestrictedName = null;


        try {
            // InternalQVTbase.g:2890:2: (iv_ruleUnrestrictedName= ruleUnrestrictedName EOF )
            // InternalQVTbase.g:2891:2: iv_ruleUnrestrictedName= ruleUnrestrictedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnrestrictedNameRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUnrestrictedName=ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnrestrictedName.getText();
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnrestrictedName"


    // $ANTLR start "ruleUnrestrictedName"
    // InternalQVTbase.g:2898:1: ruleUnrestrictedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_EssentialOCLUnrestrictedName_0= ruleEssentialOCLUnrestrictedName ;
    public final AntlrDatatypeRuleToken ruleUnrestrictedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_EssentialOCLUnrestrictedName_0 = null;


         enterRule();

        try {
            // InternalQVTbase.g:2901:28: (this_EssentialOCLUnrestrictedName_0= ruleEssentialOCLUnrestrictedName )
            // InternalQVTbase.g:2903:5: this_EssentialOCLUnrestrictedName_0= ruleEssentialOCLUnrestrictedName
            {
            if ( state.backtracking==0 ) {

                      newCompositeNode(grammarAccess.getUnrestrictedNameAccess().getEssentialOCLUnrestrictedNameParserRuleCall());

            }
            pushFollow(FollowSets000.FOLLOW_2);
            this_EssentialOCLUnrestrictedName_0=ruleEssentialOCLUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_EssentialOCLUnrestrictedName_0);

            }
            if ( state.backtracking==0 ) {

                      afterParserOrEnumRuleCall();

            }

            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnrestrictedName"


    // $ANTLR start "entryRuleEssentialOCLUnreservedName"
    // InternalQVTbase.g:2921:1: entryRuleEssentialOCLUnreservedName returns [String current=null] : iv_ruleEssentialOCLUnreservedName= ruleEssentialOCLUnreservedName EOF ;
    public final String entryRuleEssentialOCLUnreservedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEssentialOCLUnreservedName = null;


        try {
            // InternalQVTbase.g:2922:2: (iv_ruleEssentialOCLUnreservedName= ruleEssentialOCLUnreservedName EOF )
            // InternalQVTbase.g:2923:2: iv_ruleEssentialOCLUnreservedName= ruleEssentialOCLUnreservedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEssentialOCLUnreservedNameRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEssentialOCLUnreservedName=ruleEssentialOCLUnreservedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEssentialOCLUnreservedName.getText();
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEssentialOCLUnreservedName"


    // $ANTLR start "ruleEssentialOCLUnreservedName"
    // InternalQVTbase.g:2930:1: ruleEssentialOCLUnreservedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_UnrestrictedName_0= ruleUnrestrictedName | this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier | this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier | kw= 'Map' | kw= 'Tuple' ) ;
    public final AntlrDatatypeRuleToken ruleEssentialOCLUnreservedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_UnrestrictedName_0 = null;

        AntlrDatatypeRuleToken this_CollectionTypeIdentifier_1 = null;

        AntlrDatatypeRuleToken this_PrimitiveTypeIdentifier_2 = null;


         enterRule();

        try {
            // InternalQVTbase.g:2933:28: ( (this_UnrestrictedName_0= ruleUnrestrictedName | this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier | this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier | kw= 'Map' | kw= 'Tuple' ) )
            // InternalQVTbase.g:2934:1: (this_UnrestrictedName_0= ruleUnrestrictedName | this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier | this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier | kw= 'Map' | kw= 'Tuple' )
            {
            // InternalQVTbase.g:2934:1: (this_UnrestrictedName_0= ruleUnrestrictedName | this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier | this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier | kw= 'Map' | kw= 'Tuple' )
            int alt87=5;
            switch ( input.LA(1) ) {
            case RULE_SIMPLE_ID:
            case RULE_ESCAPED_ID:
                {
                alt87=1;
                }
                break;
            case 93:
            case 94:
            case 95:
            case 96:
            case 97:
                {
                alt87=2;
                }
                break;
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
            case 92:
                {
                alt87=3;
                }
                break;
            case 83:
                {
                alt87=4;
                }
                break;
            case 84:
                {
                alt87=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 87, 0, input);

                throw nvae;
            }

            switch (alt87) {
                case 1 :
                    // InternalQVTbase.g:2935:5: this_UnrestrictedName_0= ruleUnrestrictedName
                    {
                    if ( state.backtracking==0 ) {

                              newCompositeNode(grammarAccess.getEssentialOCLUnreservedNameAccess().getUnrestrictedNameParserRuleCall_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_UnrestrictedName_0=ruleUnrestrictedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_UnrestrictedName_0);

                    }
                    if ( state.backtracking==0 ) {

                              afterParserOrEnumRuleCall();

                    }

                    }
                    break;
                case 2 :
                    // InternalQVTbase.g:2947:5: this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier
                    {
                    if ( state.backtracking==0 ) {

                              newCompositeNode(grammarAccess.getEssentialOCLUnreservedNameAccess().getCollectionTypeIdentifierParserRuleCall_1());

                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_CollectionTypeIdentifier_1=ruleCollectionTypeIdentifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_CollectionTypeIdentifier_1);

                    }
                    if ( state.backtracking==0 ) {

                              afterParserOrEnumRuleCall();

                    }

                    }
                    break;
                case 3 :
                    // InternalQVTbase.g:2959:5: this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier
                    {
                    if ( state.backtracking==0 ) {

                              newCompositeNode(grammarAccess.getEssentialOCLUnreservedNameAccess().getPrimitiveTypeIdentifierParserRuleCall_2());

                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_PrimitiveTypeIdentifier_2=rulePrimitiveTypeIdentifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_PrimitiveTypeIdentifier_2);

                    }
                    if ( state.backtracking==0 ) {

                              afterParserOrEnumRuleCall();

                    }

                    }
                    break;
                case 4 :
                    // InternalQVTbase.g:2971:2: kw= 'Map'
                    {
                    kw=(Token)match(input,83,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLUnreservedNameAccess().getMapKeyword_3());

                    }

                    }
                    break;
                case 5 :
                    // InternalQVTbase.g:2978:2: kw= 'Tuple'
                    {
                    kw=(Token)match(input,84,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLUnreservedNameAccess().getTupleKeyword_4());

                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEssentialOCLUnreservedName"


    // $ANTLR start "entryRuleUnreservedName"
    // InternalQVTbase.g:2991:1: entryRuleUnreservedName returns [String current=null] : iv_ruleUnreservedName= ruleUnreservedName EOF ;
    public final String entryRuleUnreservedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnreservedName = null;


        try {
            // InternalQVTbase.g:2992:2: (iv_ruleUnreservedName= ruleUnreservedName EOF )
            // InternalQVTbase.g:2993:2: iv_ruleUnreservedName= ruleUnreservedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnreservedNameRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUnreservedName=ruleUnreservedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnreservedName.getText();
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnreservedName"


    // $ANTLR start "ruleUnreservedName"
    // InternalQVTbase.g:3000:1: ruleUnreservedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_EssentialOCLUnreservedName_0= ruleEssentialOCLUnreservedName ;
    public final AntlrDatatypeRuleToken ruleUnreservedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_EssentialOCLUnreservedName_0 = null;


         enterRule();

        try {
            // InternalQVTbase.g:3003:28: (this_EssentialOCLUnreservedName_0= ruleEssentialOCLUnreservedName )
            // InternalQVTbase.g:3005:5: this_EssentialOCLUnreservedName_0= ruleEssentialOCLUnreservedName
            {
            if ( state.backtracking==0 ) {

                      newCompositeNode(grammarAccess.getUnreservedNameAccess().getEssentialOCLUnreservedNameParserRuleCall());

            }
            pushFollow(FollowSets000.FOLLOW_2);
            this_EssentialOCLUnreservedName_0=ruleEssentialOCLUnreservedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_EssentialOCLUnreservedName_0);

            }
            if ( state.backtracking==0 ) {

                      afterParserOrEnumRuleCall();

            }

            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnreservedName"


    // $ANTLR start "entryRuleURIFirstPathElementCS"
    // InternalQVTbase.g:3025:1: entryRuleURIFirstPathElementCS returns [EObject current=null] : iv_ruleURIFirstPathElementCS= ruleURIFirstPathElementCS EOF ;
    public final EObject entryRuleURIFirstPathElementCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleURIFirstPathElementCS = null;


        try {
            // InternalQVTbase.g:3026:2: (iv_ruleURIFirstPathElementCS= ruleURIFirstPathElementCS EOF )
            // InternalQVTbase.g:3027:2: iv_ruleURIFirstPathElementCS= ruleURIFirstPathElementCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getURIFirstPathElementCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleURIFirstPathElementCS=ruleURIFirstPathElementCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleURIFirstPathElementCS;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleURIFirstPathElementCS"


    // $ANTLR start "ruleURIFirstPathElementCS"
    // InternalQVTbase.g:3034:1: ruleURIFirstPathElementCS returns [EObject current=null] : ( ( ( ruleUnrestrictedName ) ) | ( () ( ( ruleURI ) ) ) ) ;
    public final EObject ruleURIFirstPathElementCS() throws RecognitionException {
        EObject current = null;

         enterRule();

        try {
            // InternalQVTbase.g:3037:28: ( ( ( ( ruleUnrestrictedName ) ) | ( () ( ( ruleURI ) ) ) ) )
            // InternalQVTbase.g:3038:1: ( ( ( ruleUnrestrictedName ) ) | ( () ( ( ruleURI ) ) ) )
            {
            // InternalQVTbase.g:3038:1: ( ( ( ruleUnrestrictedName ) ) | ( () ( ( ruleURI ) ) ) )
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( ((LA88_0>=RULE_SIMPLE_ID && LA88_0<=RULE_ESCAPED_ID)) ) {
                alt88=1;
            }
            else if ( (LA88_0==RULE_SINGLE_QUOTED_STRING) ) {
                alt88=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 88, 0, input);

                throw nvae;
            }
            switch (alt88) {
                case 1 :
                    // InternalQVTbase.g:3038:2: ( ( ruleUnrestrictedName ) )
                    {
                    // InternalQVTbase.g:3038:2: ( ( ruleUnrestrictedName ) )
                    // InternalQVTbase.g:3039:1: ( ruleUnrestrictedName )
                    {
                    // InternalQVTbase.g:3039:1: ( ruleUnrestrictedName )
                    // InternalQVTbase.g:3040:3: ruleUnrestrictedName
                    {
                    if ( state.backtracking==0 ) {

                      		  /* */

                    }
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getURIFirstPathElementCSRule());
                      	        }

                    }
                    if ( state.backtracking==0 ) {

                      	        newCompositeNode(grammarAccess.getURIFirstPathElementCSAccess().getReferredElementNamedElementCrossReference_0_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleUnrestrictedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        afterParserOrEnumRuleCall();

                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalQVTbase.g:3057:6: ( () ( ( ruleURI ) ) )
                    {
                    // InternalQVTbase.g:3057:6: ( () ( ( ruleURI ) ) )
                    // InternalQVTbase.g:3057:7: () ( ( ruleURI ) )
                    {
                    // InternalQVTbase.g:3057:7: ()
                    // InternalQVTbase.g:3058:2:
                    {
                    if ( state.backtracking==0 ) {

                      	  /* */

                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getURIFirstPathElementCSAccess().getPathElementWithURICSAction_1_0(),
                                  current);

                    }

                    }

                    // InternalQVTbase.g:3066:2: ( ( ruleURI ) )
                    // InternalQVTbase.g:3067:1: ( ruleURI )
                    {
                    // InternalQVTbase.g:3067:1: ( ruleURI )
                    // InternalQVTbase.g:3068:3: ruleURI
                    {
                    if ( state.backtracking==0 ) {

                      		  /* */

                    }
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getURIFirstPathElementCSRule());
                      	        }

                    }
                    if ( state.backtracking==0 ) {

                      	        newCompositeNode(grammarAccess.getURIFirstPathElementCSAccess().getReferredElementNamespaceCrossReference_1_1_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleURI();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        afterParserOrEnumRuleCall();

                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleURIFirstPathElementCS"


    // $ANTLR start "entryRulePrimitiveTypeIdentifier"
    // InternalQVTbase.g:3092:1: entryRulePrimitiveTypeIdentifier returns [String current=null] : iv_rulePrimitiveTypeIdentifier= rulePrimitiveTypeIdentifier EOF ;
    public final String entryRulePrimitiveTypeIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePrimitiveTypeIdentifier = null;


        try {
            // InternalQVTbase.g:3093:2: (iv_rulePrimitiveTypeIdentifier= rulePrimitiveTypeIdentifier EOF )
            // InternalQVTbase.g:3094:2: iv_rulePrimitiveTypeIdentifier= rulePrimitiveTypeIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimitiveTypeIdentifierRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePrimitiveTypeIdentifier=rulePrimitiveTypeIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimitiveTypeIdentifier.getText();
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrimitiveTypeIdentifier"


    // $ANTLR start "rulePrimitiveTypeIdentifier"
    // InternalQVTbase.g:3101:1: rulePrimitiveTypeIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Boolean' | kw= 'Integer' | kw= 'Real' | kw= 'String' | kw= 'UnlimitedNatural' | kw= 'OclAny' | kw= 'OclInvalid' | kw= 'OclVoid' ) ;
    public final AntlrDatatypeRuleToken rulePrimitiveTypeIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule();

        try {
            // InternalQVTbase.g:3104:28: ( (kw= 'Boolean' | kw= 'Integer' | kw= 'Real' | kw= 'String' | kw= 'UnlimitedNatural' | kw= 'OclAny' | kw= 'OclInvalid' | kw= 'OclVoid' ) )
            // InternalQVTbase.g:3105:1: (kw= 'Boolean' | kw= 'Integer' | kw= 'Real' | kw= 'String' | kw= 'UnlimitedNatural' | kw= 'OclAny' | kw= 'OclInvalid' | kw= 'OclVoid' )
            {
            // InternalQVTbase.g:3105:1: (kw= 'Boolean' | kw= 'Integer' | kw= 'Real' | kw= 'String' | kw= 'UnlimitedNatural' | kw= 'OclAny' | kw= 'OclInvalid' | kw= 'OclVoid' )
            int alt89=8;
            switch ( input.LA(1) ) {
            case 85:
                {
                alt89=1;
                }
                break;
            case 86:
                {
                alt89=2;
                }
                break;
            case 87:
                {
                alt89=3;
                }
                break;
            case 88:
                {
                alt89=4;
                }
                break;
            case 89:
                {
                alt89=5;
                }
                break;
            case 90:
                {
                alt89=6;
                }
                break;
            case 91:
                {
                alt89=7;
                }
                break;
            case 92:
                {
                alt89=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 89, 0, input);

                throw nvae;
            }

            switch (alt89) {
                case 1 :
                    // InternalQVTbase.g:3106:2: kw= 'Boolean'
                    {
                    kw=(Token)match(input,85,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getBooleanKeyword_0());

                    }

                    }
                    break;
                case 2 :
                    // InternalQVTbase.g:3113:2: kw= 'Integer'
                    {
                    kw=(Token)match(input,86,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getIntegerKeyword_1());

                    }

                    }
                    break;
                case 3 :
                    // InternalQVTbase.g:3120:2: kw= 'Real'
                    {
                    kw=(Token)match(input,87,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getRealKeyword_2());

                    }

                    }
                    break;
                case 4 :
                    // InternalQVTbase.g:3127:2: kw= 'String'
                    {
                    kw=(Token)match(input,88,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getStringKeyword_3());

                    }

                    }
                    break;
                case 5 :
                    // InternalQVTbase.g:3134:2: kw= 'UnlimitedNatural'
                    {
                    kw=(Token)match(input,89,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getUnlimitedNaturalKeyword_4());

                    }

                    }
                    break;
                case 6 :
                    // InternalQVTbase.g:3141:2: kw= 'OclAny'
                    {
                    kw=(Token)match(input,90,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getOclAnyKeyword_5());

                    }

                    }
                    break;
                case 7 :
                    // InternalQVTbase.g:3148:2: kw= 'OclInvalid'
                    {
                    kw=(Token)match(input,91,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getOclInvalidKeyword_6());

                    }

                    }
                    break;
                case 8 :
                    // InternalQVTbase.g:3155:2: kw= 'OclVoid'
                    {
                    kw=(Token)match(input,92,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getOclVoidKeyword_7());

                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrimitiveTypeIdentifier"


    // $ANTLR start "entryRulePrimitiveTypeCS"
    // InternalQVTbase.g:3168:1: entryRulePrimitiveTypeCS returns [EObject current=null] : iv_rulePrimitiveTypeCS= rulePrimitiveTypeCS EOF ;
    public final EObject entryRulePrimitiveTypeCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveTypeCS = null;


        try {
            // InternalQVTbase.g:3169:2: (iv_rulePrimitiveTypeCS= rulePrimitiveTypeCS EOF )
            // InternalQVTbase.g:3170:2: iv_rulePrimitiveTypeCS= rulePrimitiveTypeCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimitiveTypeCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePrimitiveTypeCS=rulePrimitiveTypeCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimitiveTypeCS;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrimitiveTypeCS"


    // $ANTLR start "rulePrimitiveTypeCS"
    // InternalQVTbase.g:3177:1: rulePrimitiveTypeCS returns [EObject current=null] : ( (lv_name_0_0= rulePrimitiveTypeIdentifier ) ) ;
    public final EObject rulePrimitiveTypeCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule();

        try {
            // InternalQVTbase.g:3180:28: ( ( (lv_name_0_0= rulePrimitiveTypeIdentifier ) ) )
            // InternalQVTbase.g:3181:1: ( (lv_name_0_0= rulePrimitiveTypeIdentifier ) )
            {
            // InternalQVTbase.g:3181:1: ( (lv_name_0_0= rulePrimitiveTypeIdentifier ) )
            // InternalQVTbase.g:3182:1: (lv_name_0_0= rulePrimitiveTypeIdentifier )
            {
            // InternalQVTbase.g:3182:1: (lv_name_0_0= rulePrimitiveTypeIdentifier )
            // InternalQVTbase.g:3183:3: lv_name_0_0= rulePrimitiveTypeIdentifier
            {
            if ( state.backtracking==0 ) {

              	        newCompositeNode(grammarAccess.getPrimitiveTypeCSAccess().getNamePrimitiveTypeIdentifierParserRuleCall_0());

            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_name_0_0=rulePrimitiveTypeIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getPrimitiveTypeCSRule());
              	        }
                     		set(
                     			current,
                     			"name",
                      		lv_name_0_0,
                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.PrimitiveTypeIdentifier");
              	        afterParserOrEnumRuleCall();

            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrimitiveTypeCS"


    // $ANTLR start "entryRuleCollectionTypeIdentifier"
    // InternalQVTbase.g:3207:1: entryRuleCollectionTypeIdentifier returns [String current=null] : iv_ruleCollectionTypeIdentifier= ruleCollectionTypeIdentifier EOF ;
    public final String entryRuleCollectionTypeIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleCollectionTypeIdentifier = null;


        try {
            // InternalQVTbase.g:3208:2: (iv_ruleCollectionTypeIdentifier= ruleCollectionTypeIdentifier EOF )
            // InternalQVTbase.g:3209:2: iv_ruleCollectionTypeIdentifier= ruleCollectionTypeIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCollectionTypeIdentifierRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCollectionTypeIdentifier=ruleCollectionTypeIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCollectionTypeIdentifier.getText();
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCollectionTypeIdentifier"


    // $ANTLR start "ruleCollectionTypeIdentifier"
    // InternalQVTbase.g:3216:1: ruleCollectionTypeIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Set' | kw= 'Bag' | kw= 'Sequence' | kw= 'Collection' | kw= 'OrderedSet' ) ;
    public final AntlrDatatypeRuleToken ruleCollectionTypeIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule();

        try {
            // InternalQVTbase.g:3219:28: ( (kw= 'Set' | kw= 'Bag' | kw= 'Sequence' | kw= 'Collection' | kw= 'OrderedSet' ) )
            // InternalQVTbase.g:3220:1: (kw= 'Set' | kw= 'Bag' | kw= 'Sequence' | kw= 'Collection' | kw= 'OrderedSet' )
            {
            // InternalQVTbase.g:3220:1: (kw= 'Set' | kw= 'Bag' | kw= 'Sequence' | kw= 'Collection' | kw= 'OrderedSet' )
            int alt90=5;
            switch ( input.LA(1) ) {
            case 93:
                {
                alt90=1;
                }
                break;
            case 94:
                {
                alt90=2;
                }
                break;
            case 95:
                {
                alt90=3;
                }
                break;
            case 96:
                {
                alt90=4;
                }
                break;
            case 97:
                {
                alt90=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 90, 0, input);

                throw nvae;
            }

            switch (alt90) {
                case 1 :
                    // InternalQVTbase.g:3221:2: kw= 'Set'
                    {
                    kw=(Token)match(input,93,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getSetKeyword_0());

                    }

                    }
                    break;
                case 2 :
                    // InternalQVTbase.g:3228:2: kw= 'Bag'
                    {
                    kw=(Token)match(input,94,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getBagKeyword_1());

                    }

                    }
                    break;
                case 3 :
                    // InternalQVTbase.g:3235:2: kw= 'Sequence'
                    {
                    kw=(Token)match(input,95,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getSequenceKeyword_2());

                    }

                    }
                    break;
                case 4 :
                    // InternalQVTbase.g:3242:2: kw= 'Collection'
                    {
                    kw=(Token)match(input,96,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getCollectionKeyword_3());

                    }

                    }
                    break;
                case 5 :
                    // InternalQVTbase.g:3249:2: kw= 'OrderedSet'
                    {
                    kw=(Token)match(input,97,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getOrderedSetKeyword_4());

                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCollectionTypeIdentifier"


    // $ANTLR start "entryRuleCollectionTypeCS"
    // InternalQVTbase.g:3262:1: entryRuleCollectionTypeCS returns [EObject current=null] : iv_ruleCollectionTypeCS= ruleCollectionTypeCS EOF ;
    public final EObject entryRuleCollectionTypeCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionTypeCS = null;


        try {
            // InternalQVTbase.g:3263:2: (iv_ruleCollectionTypeCS= ruleCollectionTypeCS EOF )
            // InternalQVTbase.g:3264:2: iv_ruleCollectionTypeCS= ruleCollectionTypeCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCollectionTypeCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCollectionTypeCS=ruleCollectionTypeCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCollectionTypeCS;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCollectionTypeCS"


    // $ANTLR start "ruleCollectionTypeCS"
    // InternalQVTbase.g:3271:1: ruleCollectionTypeCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )? ) ;
    public final EObject ruleCollectionTypeCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;


         enterRule();

        try {
            // InternalQVTbase.g:3274:28: ( ( ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )? ) )
            // InternalQVTbase.g:3275:1: ( ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )? )
            {
            // InternalQVTbase.g:3275:1: ( ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )? )
            // InternalQVTbase.g:3275:2: ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )?
            {
            // InternalQVTbase.g:3275:2: ( (lv_name_0_0= ruleCollectionTypeIdentifier ) )
            // InternalQVTbase.g:3276:1: (lv_name_0_0= ruleCollectionTypeIdentifier )
            {
            // InternalQVTbase.g:3276:1: (lv_name_0_0= ruleCollectionTypeIdentifier )
            // InternalQVTbase.g:3277:3: lv_name_0_0= ruleCollectionTypeIdentifier
            {
            if ( state.backtracking==0 ) {

              	        newCompositeNode(grammarAccess.getCollectionTypeCSAccess().getNameCollectionTypeIdentifierParserRuleCall_0_0());

            }
            pushFollow(FollowSets000.FOLLOW_60);
            lv_name_0_0=ruleCollectionTypeIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getCollectionTypeCSRule());
              	        }
                     		set(
                     			current,
                     			"name",
                      		lv_name_0_0,
                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.CollectionTypeIdentifier");
              	        afterParserOrEnumRuleCall();

            }

            }


            }

            // InternalQVTbase.g:3293:2: (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )?
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( (LA91_0==51) ) {
                alt91=1;
            }
            switch (alt91) {
                case 1 :
                    // InternalQVTbase.g:3293:4: otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,51,FollowSets000.FOLLOW_61); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getCollectionTypeCSAccess().getLeftParenthesisKeyword_1_0());

                    }
                    // InternalQVTbase.g:3297:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                    // InternalQVTbase.g:3298:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    {
                    // InternalQVTbase.g:3298:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    // InternalQVTbase.g:3299:3: lv_ownedType_2_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {

                      	        newCompositeNode(grammarAccess.getCollectionTypeCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_62);
                    lv_ownedType_2_0=ruleTypeExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getCollectionTypeCSRule());
                      	        }
                             		set(
                             			current,
                             			"ownedType",
                              		lv_ownedType_2_0,
                              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeExpCS");
                      	        afterParserOrEnumRuleCall();

                    }

                    }


                    }

                    otherlv_3=(Token)match(input,52,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getCollectionTypeCSAccess().getRightParenthesisKeyword_1_2());

                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCollectionTypeCS"


    // $ANTLR start "entryRuleMapTypeCS"
    // InternalQVTbase.g:3327:1: entryRuleMapTypeCS returns [EObject current=null] : iv_ruleMapTypeCS= ruleMapTypeCS EOF ;
    public final EObject entryRuleMapTypeCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMapTypeCS = null;


        try {
            // InternalQVTbase.g:3328:2: (iv_ruleMapTypeCS= ruleMapTypeCS EOF )
            // InternalQVTbase.g:3329:2: iv_ruleMapTypeCS= ruleMapTypeCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMapTypeCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMapTypeCS=ruleMapTypeCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMapTypeCS;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMapTypeCS"


    // $ANTLR start "ruleMapTypeCS"
    // InternalQVTbase.g:3336:1: ruleMapTypeCS returns [EObject current=null] : ( ( (lv_name_0_0= 'Map' ) ) (otherlv_1= '(' ( (lv_ownedKeyType_2_0= ruleTypeExpCS ) ) otherlv_3= ',' ( (lv_ownedValueType_4_0= ruleTypeExpCS ) ) otherlv_5= ')' )? ) ;
    public final EObject ruleMapTypeCS() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_ownedKeyType_2_0 = null;

        EObject lv_ownedValueType_4_0 = null;


         enterRule();

        try {
            // InternalQVTbase.g:3339:28: ( ( ( (lv_name_0_0= 'Map' ) ) (otherlv_1= '(' ( (lv_ownedKeyType_2_0= ruleTypeExpCS ) ) otherlv_3= ',' ( (lv_ownedValueType_4_0= ruleTypeExpCS ) ) otherlv_5= ')' )? ) )
            // InternalQVTbase.g:3340:1: ( ( (lv_name_0_0= 'Map' ) ) (otherlv_1= '(' ( (lv_ownedKeyType_2_0= ruleTypeExpCS ) ) otherlv_3= ',' ( (lv_ownedValueType_4_0= ruleTypeExpCS ) ) otherlv_5= ')' )? )
            {
            // InternalQVTbase.g:3340:1: ( ( (lv_name_0_0= 'Map' ) ) (otherlv_1= '(' ( (lv_ownedKeyType_2_0= ruleTypeExpCS ) ) otherlv_3= ',' ( (lv_ownedValueType_4_0= ruleTypeExpCS ) ) otherlv_5= ')' )? )
            // InternalQVTbase.g:3340:2: ( (lv_name_0_0= 'Map' ) ) (otherlv_1= '(' ( (lv_ownedKeyType_2_0= ruleTypeExpCS ) ) otherlv_3= ',' ( (lv_ownedValueType_4_0= ruleTypeExpCS ) ) otherlv_5= ')' )?
            {
            // InternalQVTbase.g:3340:2: ( (lv_name_0_0= 'Map' ) )
            // InternalQVTbase.g:3341:1: (lv_name_0_0= 'Map' )
            {
            // InternalQVTbase.g:3341:1: (lv_name_0_0= 'Map' )
            // InternalQVTbase.g:3342:3: lv_name_0_0= 'Map'
            {
            lv_name_0_0=(Token)match(input,83,FollowSets000.FOLLOW_60); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      newLeafNode(lv_name_0_0, grammarAccess.getMapTypeCSAccess().getNameMapKeyword_0_0());

            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getMapTypeCSRule());
              	        }
                     		setWithLastConsumed(current, "name", lv_name_0_0, "Map");

            }

            }


            }

            // InternalQVTbase.g:3355:2: (otherlv_1= '(' ( (lv_ownedKeyType_2_0= ruleTypeExpCS ) ) otherlv_3= ',' ( (lv_ownedValueType_4_0= ruleTypeExpCS ) ) otherlv_5= ')' )?
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( (LA92_0==51) ) {
                alt92=1;
            }
            switch (alt92) {
                case 1 :
                    // InternalQVTbase.g:3355:4: otherlv_1= '(' ( (lv_ownedKeyType_2_0= ruleTypeExpCS ) ) otherlv_3= ',' ( (lv_ownedValueType_4_0= ruleTypeExpCS ) ) otherlv_5= ')'
                    {
                    otherlv_1=(Token)match(input,51,FollowSets000.FOLLOW_61); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getMapTypeCSAccess().getLeftParenthesisKeyword_1_0());

                    }
                    // InternalQVTbase.g:3359:1: ( (lv_ownedKeyType_2_0= ruleTypeExpCS ) )
                    // InternalQVTbase.g:3360:1: (lv_ownedKeyType_2_0= ruleTypeExpCS )
                    {
                    // InternalQVTbase.g:3360:1: (lv_ownedKeyType_2_0= ruleTypeExpCS )
                    // InternalQVTbase.g:3361:3: lv_ownedKeyType_2_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {

                      	        newCompositeNode(grammarAccess.getMapTypeCSAccess().getOwnedKeyTypeTypeExpCSParserRuleCall_1_1_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_63);
                    lv_ownedKeyType_2_0=ruleTypeExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getMapTypeCSRule());
                      	        }
                             		set(
                             			current,
                             			"ownedKeyType",
                              		lv_ownedKeyType_2_0,
                              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeExpCS");
                      	        afterParserOrEnumRuleCall();

                    }

                    }


                    }

                    otherlv_3=(Token)match(input,39,FollowSets000.FOLLOW_61); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getMapTypeCSAccess().getCommaKeyword_1_2());

                    }
                    // InternalQVTbase.g:3381:1: ( (lv_ownedValueType_4_0= ruleTypeExpCS ) )
                    // InternalQVTbase.g:3382:1: (lv_ownedValueType_4_0= ruleTypeExpCS )
                    {
                    // InternalQVTbase.g:3382:1: (lv_ownedValueType_4_0= ruleTypeExpCS )
                    // InternalQVTbase.g:3383:3: lv_ownedValueType_4_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {

                      	        newCompositeNode(grammarAccess.getMapTypeCSAccess().getOwnedValueTypeTypeExpCSParserRuleCall_1_3_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_62);
                    lv_ownedValueType_4_0=ruleTypeExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getMapTypeCSRule());
                      	        }
                             		set(
                             			current,
                             			"ownedValueType",
                              		lv_ownedValueType_4_0,
                              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeExpCS");
                      	        afterParserOrEnumRuleCall();

                    }

                    }


                    }

                    otherlv_5=(Token)match(input,52,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getMapTypeCSAccess().getRightParenthesisKeyword_1_4());

                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMapTypeCS"


    // $ANTLR start "entryRuleTupleTypeCS"
    // InternalQVTbase.g:3411:1: entryRuleTupleTypeCS returns [EObject current=null] : iv_ruleTupleTypeCS= ruleTupleTypeCS EOF ;
    public final EObject entryRuleTupleTypeCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTupleTypeCS = null;


        try {
            // InternalQVTbase.g:3412:2: (iv_ruleTupleTypeCS= ruleTupleTypeCS EOF )
            // InternalQVTbase.g:3413:2: iv_ruleTupleTypeCS= ruleTupleTypeCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTupleTypeCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTupleTypeCS=ruleTupleTypeCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTupleTypeCS;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTupleTypeCS"


    // $ANTLR start "ruleTupleTypeCS"
    // InternalQVTbase.g:3420:1: ruleTupleTypeCS returns [EObject current=null] : ( ( (lv_name_0_0= 'Tuple' ) ) (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )? ) ;
    public final EObject ruleTupleTypeCS() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_ownedParts_2_0 = null;

        EObject lv_ownedParts_4_0 = null;


         enterRule();

        try {
            // InternalQVTbase.g:3423:28: ( ( ( (lv_name_0_0= 'Tuple' ) ) (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )? ) )
            // InternalQVTbase.g:3424:1: ( ( (lv_name_0_0= 'Tuple' ) ) (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )? )
            {
            // InternalQVTbase.g:3424:1: ( ( (lv_name_0_0= 'Tuple' ) ) (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )? )
            // InternalQVTbase.g:3424:2: ( (lv_name_0_0= 'Tuple' ) ) (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )?
            {
            // InternalQVTbase.g:3424:2: ( (lv_name_0_0= 'Tuple' ) )
            // InternalQVTbase.g:3425:1: (lv_name_0_0= 'Tuple' )
            {
            // InternalQVTbase.g:3425:1: (lv_name_0_0= 'Tuple' )
            // InternalQVTbase.g:3426:3: lv_name_0_0= 'Tuple'
            {
            lv_name_0_0=(Token)match(input,84,FollowSets000.FOLLOW_60); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      newLeafNode(lv_name_0_0, grammarAccess.getTupleTypeCSAccess().getNameTupleKeyword_0_0());

            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getTupleTypeCSRule());
              	        }
                     		setWithLastConsumed(current, "name", lv_name_0_0, "Tuple");

            }

            }


            }

            // InternalQVTbase.g:3439:2: (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )?
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( (LA95_0==51) ) {
                alt95=1;
            }
            switch (alt95) {
                case 1 :
                    // InternalQVTbase.g:3439:4: otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')'
                    {
                    otherlv_1=(Token)match(input,51,FollowSets000.FOLLOW_31); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getTupleTypeCSAccess().getLeftParenthesisKeyword_1_0());

                    }
                    // InternalQVTbase.g:3443:1: ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )?
                    int alt94=2;
                    int LA94_0 = input.LA(1);

                    if ( ((LA94_0>=RULE_SIMPLE_ID && LA94_0<=RULE_ESCAPED_ID)) ) {
                        alt94=1;
                    }
                    switch (alt94) {
                        case 1 :
                            // InternalQVTbase.g:3443:2: ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )*
                            {
                            // InternalQVTbase.g:3443:2: ( (lv_ownedParts_2_0= ruleTuplePartCS ) )
                            // InternalQVTbase.g:3444:1: (lv_ownedParts_2_0= ruleTuplePartCS )
                            {
                            // InternalQVTbase.g:3444:1: (lv_ownedParts_2_0= ruleTuplePartCS )
                            // InternalQVTbase.g:3445:3: lv_ownedParts_2_0= ruleTuplePartCS
                            {
                            if ( state.backtracking==0 ) {

                              	        newCompositeNode(grammarAccess.getTupleTypeCSAccess().getOwnedPartsTuplePartCSParserRuleCall_1_1_0_0());

                            }
                            pushFollow(FollowSets000.FOLLOW_32);
                            lv_ownedParts_2_0=ruleTuplePartCS();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getTupleTypeCSRule());
                              	        }
                                     		add(
                                     			current,
                                     			"ownedParts",
                                      		lv_ownedParts_2_0,
                                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TuplePartCS");
                              	        afterParserOrEnumRuleCall();

                            }

                            }


                            }

                            // InternalQVTbase.g:3461:2: (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )*
                            loop93:
                            do {
                                int alt93=2;
                                int LA93_0 = input.LA(1);

                                if ( (LA93_0==39) ) {
                                    alt93=1;
                                }


                                switch (alt93) {
                            	case 1 :
                            	    // InternalQVTbase.g:3461:4: otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) )
                            	    {
                            	    otherlv_3=(Token)match(input,39,FollowSets000.FOLLOW_6); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_3, grammarAccess.getTupleTypeCSAccess().getCommaKeyword_1_1_1_0());

                            	    }
                            	    // InternalQVTbase.g:3465:1: ( (lv_ownedParts_4_0= ruleTuplePartCS ) )
                            	    // InternalQVTbase.g:3466:1: (lv_ownedParts_4_0= ruleTuplePartCS )
                            	    {
                            	    // InternalQVTbase.g:3466:1: (lv_ownedParts_4_0= ruleTuplePartCS )
                            	    // InternalQVTbase.g:3467:3: lv_ownedParts_4_0= ruleTuplePartCS
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      	        newCompositeNode(grammarAccess.getTupleTypeCSAccess().getOwnedPartsTuplePartCSParserRuleCall_1_1_1_1_0());

                            	    }
                            	    pushFollow(FollowSets000.FOLLOW_32);
                            	    lv_ownedParts_4_0=ruleTuplePartCS();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getTupleTypeCSRule());
                            	      	        }
                            	             		add(
                            	             			current,
                            	             			"ownedParts",
                            	              		lv_ownedParts_4_0,
                            	              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TuplePartCS");
                            	      	        afterParserOrEnumRuleCall();

                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop93;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_5=(Token)match(input,52,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getTupleTypeCSAccess().getRightParenthesisKeyword_1_2());

                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTupleTypeCS"


    // $ANTLR start "entryRuleTuplePartCS"
    // InternalQVTbase.g:3495:1: entryRuleTuplePartCS returns [EObject current=null] : iv_ruleTuplePartCS= ruleTuplePartCS EOF ;
    public final EObject entryRuleTuplePartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTuplePartCS = null;


        try {
            // InternalQVTbase.g:3496:2: (iv_ruleTuplePartCS= ruleTuplePartCS EOF )
            // InternalQVTbase.g:3497:2: iv_ruleTuplePartCS= ruleTuplePartCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTuplePartCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTuplePartCS=ruleTuplePartCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTuplePartCS;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTuplePartCS"


    // $ANTLR start "ruleTuplePartCS"
    // InternalQVTbase.g:3504:1: ruleTuplePartCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) ) ;
    public final EObject ruleTuplePartCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;


         enterRule();

        try {
            // InternalQVTbase.g:3507:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) ) )
            // InternalQVTbase.g:3508:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )
            {
            // InternalQVTbase.g:3508:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )
            // InternalQVTbase.g:3508:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) )
            {
            // InternalQVTbase.g:3508:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // InternalQVTbase.g:3509:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // InternalQVTbase.g:3509:1: (lv_name_0_0= ruleUnrestrictedName )
            // InternalQVTbase.g:3510:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {

              	        newCompositeNode(grammarAccess.getTuplePartCSAccess().getNameUnrestrictedNameParserRuleCall_0_0());

            }
            pushFollow(FollowSets000.FOLLOW_16);
            lv_name_0_0=ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTuplePartCSRule());
              	        }
                     		set(
                     			current,
                     			"name",
                      		lv_name_0_0,
                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.UnrestrictedName");
              	        afterParserOrEnumRuleCall();

            }

            }


            }

            otherlv_1=(Token)match(input,20,FollowSets000.FOLLOW_61); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getTuplePartCSAccess().getColonKeyword_1());

            }
            // InternalQVTbase.g:3530:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
            // InternalQVTbase.g:3531:1: (lv_ownedType_2_0= ruleTypeExpCS )
            {
            // InternalQVTbase.g:3531:1: (lv_ownedType_2_0= ruleTypeExpCS )
            // InternalQVTbase.g:3532:3: lv_ownedType_2_0= ruleTypeExpCS
            {
            if ( state.backtracking==0 ) {

              	        newCompositeNode(grammarAccess.getTuplePartCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_0());

            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_ownedType_2_0=ruleTypeExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTuplePartCSRule());
              	        }
                     		set(
                     			current,
                     			"ownedType",
                      		lv_ownedType_2_0,
                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeExpCS");
              	        afterParserOrEnumRuleCall();

            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTuplePartCS"


    // $ANTLR start "entryRuleCollectionLiteralExpCS"
    // InternalQVTbase.g:3556:1: entryRuleCollectionLiteralExpCS returns [EObject current=null] : iv_ruleCollectionLiteralExpCS= ruleCollectionLiteralExpCS EOF ;
    public final EObject entryRuleCollectionLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionLiteralExpCS = null;


        try {
            // InternalQVTbase.g:3557:2: (iv_ruleCollectionLiteralExpCS= ruleCollectionLiteralExpCS EOF )
            // InternalQVTbase.g:3558:2: iv_ruleCollectionLiteralExpCS= ruleCollectionLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCollectionLiteralExpCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCollectionLiteralExpCS=ruleCollectionLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCollectionLiteralExpCS;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCollectionLiteralExpCS"


    // $ANTLR start "ruleCollectionLiteralExpCS"
    // InternalQVTbase.g:3565:1: ruleCollectionLiteralExpCS returns [EObject current=null] : ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}' ) ;
    public final EObject ruleCollectionLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_ownedType_0_0 = null;

        EObject lv_ownedParts_2_0 = null;

        EObject lv_ownedParts_4_0 = null;


         enterRule();

        try {
            // InternalQVTbase.g:3568:28: ( ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}' ) )
            // InternalQVTbase.g:3569:1: ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}' )
            {
            // InternalQVTbase.g:3569:1: ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}' )
            // InternalQVTbase.g:3569:2: ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}'
            {
            // InternalQVTbase.g:3569:2: ( (lv_ownedType_0_0= ruleCollectionTypeCS ) )
            // InternalQVTbase.g:3570:1: (lv_ownedType_0_0= ruleCollectionTypeCS )
            {
            // InternalQVTbase.g:3570:1: (lv_ownedType_0_0= ruleCollectionTypeCS )
            // InternalQVTbase.g:3571:3: lv_ownedType_0_0= ruleCollectionTypeCS
            {
            if ( state.backtracking==0 ) {

              	        newCompositeNode(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedTypeCollectionTypeCSParserRuleCall_0_0());

            }
            pushFollow(FollowSets000.FOLLOW_64);
            lv_ownedType_0_0=ruleCollectionTypeCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getCollectionLiteralExpCSRule());
              	        }
                     		set(
                     			current,
                     			"ownedType",
                      		lv_ownedType_0_0,
                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.CollectionTypeCS");
              	        afterParserOrEnumRuleCall();

            }

            }


            }

            otherlv_1=(Token)match(input,22,FollowSets000.FOLLOW_65); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getCollectionLiteralExpCSAccess().getLeftCurlyBracketKeyword_1());

            }
            // InternalQVTbase.g:3591:1: ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )?
            int alt97=2;
            int LA97_0 = input.LA(1);

            if ( (LA97_0==RULE_SINGLE_QUOTED_STRING||(LA97_0>=RULE_INT && LA97_0<=RULE_ESCAPED_ID)||LA97_0==20||LA97_0==51||(LA97_0>=65 && LA97_0<=67)||(LA97_0>=83 && LA97_0<=97)||LA97_0==100||(LA97_0>=102 && LA97_0<=105)||LA97_0==112||(LA97_0>=117 && LA97_0<=118)) ) {
                alt97=1;
            }
            switch (alt97) {
                case 1 :
                    // InternalQVTbase.g:3591:2: ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )*
                    {
                    // InternalQVTbase.g:3591:2: ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) )
                    // InternalQVTbase.g:3592:1: (lv_ownedParts_2_0= ruleCollectionLiteralPartCS )
                    {
                    // InternalQVTbase.g:3592:1: (lv_ownedParts_2_0= ruleCollectionLiteralPartCS )
                    // InternalQVTbase.g:3593:3: lv_ownedParts_2_0= ruleCollectionLiteralPartCS
                    {
                    if ( state.backtracking==0 ) {

                      	        newCompositeNode(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedPartsCollectionLiteralPartCSParserRuleCall_2_0_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_66);
                    lv_ownedParts_2_0=ruleCollectionLiteralPartCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getCollectionLiteralExpCSRule());
                      	        }
                             		add(
                             			current,
                             			"ownedParts",
                              		lv_ownedParts_2_0,
                              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.CollectionLiteralPartCS");
                      	        afterParserOrEnumRuleCall();

                    }

                    }


                    }

                    // InternalQVTbase.g:3609:2: (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )*
                    loop96:
                    do {
                        int alt96=2;
                        int LA96_0 = input.LA(1);

                        if ( (LA96_0==39) ) {
                            alt96=1;
                        }


                        switch (alt96) {
                    	case 1 :
                    	    // InternalQVTbase.g:3609:4: otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) )
                    	    {
                    	    otherlv_3=(Token)match(input,39,FollowSets000.FOLLOW_67); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getCollectionLiteralExpCSAccess().getCommaKeyword_2_1_0());

                    	    }
                    	    // InternalQVTbase.g:3613:1: ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) )
                    	    // InternalQVTbase.g:3614:1: (lv_ownedParts_4_0= ruleCollectionLiteralPartCS )
                    	    {
                    	    // InternalQVTbase.g:3614:1: (lv_ownedParts_4_0= ruleCollectionLiteralPartCS )
                    	    // InternalQVTbase.g:3615:3: lv_ownedParts_4_0= ruleCollectionLiteralPartCS
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      	        newCompositeNode(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedPartsCollectionLiteralPartCSParserRuleCall_2_1_1_0());

                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_66);
                    	    lv_ownedParts_4_0=ruleCollectionLiteralPartCS();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getCollectionLiteralExpCSRule());
                    	      	        }
                    	             		add(
                    	             			current,
                    	             			"ownedParts",
                    	              		lv_ownedParts_4_0,
                    	              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.CollectionLiteralPartCS");
                    	      	        afterParserOrEnumRuleCall();

                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop96;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,40,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getCollectionLiteralExpCSAccess().getRightCurlyBracketKeyword_3());

            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCollectionLiteralExpCS"


    // $ANTLR start "entryRuleCollectionLiteralPartCS"
    // InternalQVTbase.g:3643:1: entryRuleCollectionLiteralPartCS returns [EObject current=null] : iv_ruleCollectionLiteralPartCS= ruleCollectionLiteralPartCS EOF ;
    public final EObject entryRuleCollectionLiteralPartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionLiteralPartCS = null;


        try {
            // InternalQVTbase.g:3644:2: (iv_ruleCollectionLiteralPartCS= ruleCollectionLiteralPartCS EOF )
            // InternalQVTbase.g:3645:2: iv_ruleCollectionLiteralPartCS= ruleCollectionLiteralPartCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCollectionLiteralPartCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCollectionLiteralPartCS=ruleCollectionLiteralPartCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCollectionLiteralPartCS;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCollectionLiteralPartCS"


    // $ANTLR start "ruleCollectionLiteralPartCS"
    // InternalQVTbase.g:3652:1: ruleCollectionLiteralPartCS returns [EObject current=null] : ( ( ( (lv_ownedExpression_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_ownedLastExpression_2_0= ruleExpCS ) ) )? ) | ( (lv_ownedExpression_3_0= rulePatternExpCS ) ) ) ;
    public final EObject ruleCollectionLiteralPartCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_ownedExpression_0_0 = null;

        EObject lv_ownedLastExpression_2_0 = null;

        EObject lv_ownedExpression_3_0 = null;


         enterRule();

        try {
            // InternalQVTbase.g:3655:28: ( ( ( ( (lv_ownedExpression_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_ownedLastExpression_2_0= ruleExpCS ) ) )? ) | ( (lv_ownedExpression_3_0= rulePatternExpCS ) ) ) )
            // InternalQVTbase.g:3656:1: ( ( ( (lv_ownedExpression_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_ownedLastExpression_2_0= ruleExpCS ) ) )? ) | ( (lv_ownedExpression_3_0= rulePatternExpCS ) ) )
            {
            // InternalQVTbase.g:3656:1: ( ( ( (lv_ownedExpression_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_ownedLastExpression_2_0= ruleExpCS ) ) )? ) | ( (lv_ownedExpression_3_0= rulePatternExpCS ) ) )
            int alt99=2;
            switch ( input.LA(1) ) {
            case RULE_SINGLE_QUOTED_STRING:
            case RULE_INT:
            case 51:
            case 65:
            case 66:
            case 67:
            case 83:
            case 84:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
            case 97:
            case 100:
            case 102:
            case 103:
            case 104:
            case 105:
            case 112:
            case 117:
            case 118:
                {
                alt99=1;
                }
                break;
            case RULE_SIMPLE_ID:
                {
                int LA99_2 = input.LA(2);

                if ( (LA99_2==EOF||(LA99_2>=21 && LA99_2<=22)||(LA99_2>=39 && LA99_2<=40)||LA99_2==51||LA99_2==65||(LA99_2>=67 && LA99_2<=82)||LA99_2==98||LA99_2==106||LA99_2==108||LA99_2==122) ) {
                    alt99=1;
                }
                else if ( (LA99_2==20) ) {
                    alt99=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 99, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_ESCAPED_ID:
                {
                int LA99_3 = input.LA(2);

                if ( (LA99_3==EOF||(LA99_3>=21 && LA99_3<=22)||(LA99_3>=39 && LA99_3<=40)||LA99_3==51||LA99_3==65||(LA99_3>=67 && LA99_3<=82)||LA99_3==98||LA99_3==106||LA99_3==108||LA99_3==122) ) {
                    alt99=1;
                }
                else if ( (LA99_3==20) ) {
                    alt99=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 99, 3, input);

                    throw nvae;
                }
                }
                break;
            case 20:
                {
                alt99=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 99, 0, input);

                throw nvae;
            }

            switch (alt99) {
                case 1 :
                    // InternalQVTbase.g:3656:2: ( ( (lv_ownedExpression_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_ownedLastExpression_2_0= ruleExpCS ) ) )? )
                    {
                    // InternalQVTbase.g:3656:2: ( ( (lv_ownedExpression_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_ownedLastExpression_2_0= ruleExpCS ) ) )? )
                    // InternalQVTbase.g:3656:3: ( (lv_ownedExpression_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_ownedLastExpression_2_0= ruleExpCS ) ) )?
                    {
                    // InternalQVTbase.g:3656:3: ( (lv_ownedExpression_0_0= ruleExpCS ) )
                    // InternalQVTbase.g:3657:1: (lv_ownedExpression_0_0= ruleExpCS )
                    {
                    // InternalQVTbase.g:3657:1: (lv_ownedExpression_0_0= ruleExpCS )
                    // InternalQVTbase.g:3658:3: lv_ownedExpression_0_0= ruleExpCS
                    {
                    if ( state.backtracking==0 ) {

                      	        newCompositeNode(grammarAccess.getCollectionLiteralPartCSAccess().getOwnedExpressionExpCSParserRuleCall_0_0_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_68);
                    lv_ownedExpression_0_0=ruleExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getCollectionLiteralPartCSRule());
                      	        }
                             		set(
                             			current,
                             			"ownedExpression",
                              		lv_ownedExpression_0_0,
                              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
                      	        afterParserOrEnumRuleCall();

                    }

                    }


                    }

                    // InternalQVTbase.g:3674:2: (otherlv_1= '..' ( (lv_ownedLastExpression_2_0= ruleExpCS ) ) )?
                    int alt98=2;
                    int LA98_0 = input.LA(1);

                    if ( (LA98_0==98) ) {
                        alt98=1;
                    }
                    switch (alt98) {
                        case 1 :
                            // InternalQVTbase.g:3674:4: otherlv_1= '..' ( (lv_ownedLastExpression_2_0= ruleExpCS ) )
                            {
                            otherlv_1=(Token)match(input,98,FollowSets000.FOLLOW_69); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_1, grammarAccess.getCollectionLiteralPartCSAccess().getFullStopFullStopKeyword_0_1_0());

                            }
                            // InternalQVTbase.g:3678:1: ( (lv_ownedLastExpression_2_0= ruleExpCS ) )
                            // InternalQVTbase.g:3679:1: (lv_ownedLastExpression_2_0= ruleExpCS )
                            {
                            // InternalQVTbase.g:3679:1: (lv_ownedLastExpression_2_0= ruleExpCS )
                            // InternalQVTbase.g:3680:3: lv_ownedLastExpression_2_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {

                              	        newCompositeNode(grammarAccess.getCollectionLiteralPartCSAccess().getOwnedLastExpressionExpCSParserRuleCall_0_1_1_0());

                            }
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_ownedLastExpression_2_0=ruleExpCS();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getCollectionLiteralPartCSRule());
                              	        }
                                     		set(
                                     			current,
                                     			"ownedLastExpression",
                                      		lv_ownedLastExpression_2_0,
                                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
                              	        afterParserOrEnumRuleCall();

                            }

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalQVTbase.g:3697:6: ( (lv_ownedExpression_3_0= rulePatternExpCS ) )
                    {
                    // InternalQVTbase.g:3697:6: ( (lv_ownedExpression_3_0= rulePatternExpCS ) )
                    // InternalQVTbase.g:3698:1: (lv_ownedExpression_3_0= rulePatternExpCS )
                    {
                    // InternalQVTbase.g:3698:1: (lv_ownedExpression_3_0= rulePatternExpCS )
                    // InternalQVTbase.g:3699:3: lv_ownedExpression_3_0= rulePatternExpCS
                    {
                    if ( state.backtracking==0 ) {

                      	        newCompositeNode(grammarAccess.getCollectionLiteralPartCSAccess().getOwnedExpressionPatternExpCSParserRuleCall_1_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_ownedExpression_3_0=rulePatternExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getCollectionLiteralPartCSRule());
                      	        }
                             		set(
                             			current,
                             			"ownedExpression",
                              		lv_ownedExpression_3_0,
                              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.PatternExpCS");
                      	        afterParserOrEnumRuleCall();

                    }

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCollectionLiteralPartCS"


    // $ANTLR start "entryRuleCollectionPatternCS"
    // InternalQVTbase.g:3723:1: entryRuleCollectionPatternCS returns [EObject current=null] : iv_ruleCollectionPatternCS= ruleCollectionPatternCS EOF ;
    public final EObject entryRuleCollectionPatternCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionPatternCS = null;


        try {
            // InternalQVTbase.g:3724:2: (iv_ruleCollectionPatternCS= ruleCollectionPatternCS EOF )
            // InternalQVTbase.g:3725:2: iv_ruleCollectionPatternCS= ruleCollectionPatternCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCollectionPatternCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCollectionPatternCS=ruleCollectionPatternCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCollectionPatternCS;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCollectionPatternCS"


    // $ANTLR start "ruleCollectionPatternCS"
    // InternalQVTbase.g:3732:1: ruleCollectionPatternCS returns [EObject current=null] : ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= rulePatternExpCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= rulePatternExpCS ) ) )* (otherlv_5= '++' ( (lv_restVariableName_6_0= ruleIdentifier ) ) ) )? otherlv_7= '}' ) ;
    public final EObject ruleCollectionPatternCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_ownedType_0_0 = null;

        EObject lv_ownedParts_2_0 = null;

        EObject lv_ownedParts_4_0 = null;

        AntlrDatatypeRuleToken lv_restVariableName_6_0 = null;


         enterRule();

        try {
            // InternalQVTbase.g:3735:28: ( ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= rulePatternExpCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= rulePatternExpCS ) ) )* (otherlv_5= '++' ( (lv_restVariableName_6_0= ruleIdentifier ) ) ) )? otherlv_7= '}' ) )
            // InternalQVTbase.g:3736:1: ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= rulePatternExpCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= rulePatternExpCS ) ) )* (otherlv_5= '++' ( (lv_restVariableName_6_0= ruleIdentifier ) ) ) )? otherlv_7= '}' )
            {
            // InternalQVTbase.g:3736:1: ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= rulePatternExpCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= rulePatternExpCS ) ) )* (otherlv_5= '++' ( (lv_restVariableName_6_0= ruleIdentifier ) ) ) )? otherlv_7= '}' )
            // InternalQVTbase.g:3736:2: ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= rulePatternExpCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= rulePatternExpCS ) ) )* (otherlv_5= '++' ( (lv_restVariableName_6_0= ruleIdentifier ) ) ) )? otherlv_7= '}'
            {
            // InternalQVTbase.g:3736:2: ( (lv_ownedType_0_0= ruleCollectionTypeCS ) )
            // InternalQVTbase.g:3737:1: (lv_ownedType_0_0= ruleCollectionTypeCS )
            {
            // InternalQVTbase.g:3737:1: (lv_ownedType_0_0= ruleCollectionTypeCS )
            // InternalQVTbase.g:3738:3: lv_ownedType_0_0= ruleCollectionTypeCS
            {
            if ( state.backtracking==0 ) {

              	        newCompositeNode(grammarAccess.getCollectionPatternCSAccess().getOwnedTypeCollectionTypeCSParserRuleCall_0_0());

            }
            pushFollow(FollowSets000.FOLLOW_64);
            lv_ownedType_0_0=ruleCollectionTypeCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getCollectionPatternCSRule());
              	        }
                     		set(
                     			current,
                     			"ownedType",
                      		lv_ownedType_0_0,
                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.CollectionTypeCS");
              	        afterParserOrEnumRuleCall();

            }

            }


            }

            otherlv_1=(Token)match(input,22,FollowSets000.FOLLOW_65); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getCollectionPatternCSAccess().getLeftCurlyBracketKeyword_1());

            }
            // InternalQVTbase.g:3758:1: ( ( (lv_ownedParts_2_0= rulePatternExpCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= rulePatternExpCS ) ) )* (otherlv_5= '++' ( (lv_restVariableName_6_0= ruleIdentifier ) ) ) )?
            int alt101=2;
            int LA101_0 = input.LA(1);

            if ( ((LA101_0>=RULE_SIMPLE_ID && LA101_0<=RULE_ESCAPED_ID)||LA101_0==20) ) {
                alt101=1;
            }
            switch (alt101) {
                case 1 :
                    // InternalQVTbase.g:3758:2: ( (lv_ownedParts_2_0= rulePatternExpCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= rulePatternExpCS ) ) )* (otherlv_5= '++' ( (lv_restVariableName_6_0= ruleIdentifier ) ) )
                    {
                    // InternalQVTbase.g:3758:2: ( (lv_ownedParts_2_0= rulePatternExpCS ) )
                    // InternalQVTbase.g:3759:1: (lv_ownedParts_2_0= rulePatternExpCS )
                    {
                    // InternalQVTbase.g:3759:1: (lv_ownedParts_2_0= rulePatternExpCS )
                    // InternalQVTbase.g:3760:3: lv_ownedParts_2_0= rulePatternExpCS
                    {
                    if ( state.backtracking==0 ) {

                      	        newCompositeNode(grammarAccess.getCollectionPatternCSAccess().getOwnedPartsPatternExpCSParserRuleCall_2_0_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_70);
                    lv_ownedParts_2_0=rulePatternExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getCollectionPatternCSRule());
                      	        }
                             		add(
                             			current,
                             			"ownedParts",
                              		lv_ownedParts_2_0,
                              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.PatternExpCS");
                      	        afterParserOrEnumRuleCall();

                    }

                    }


                    }

                    // InternalQVTbase.g:3776:2: (otherlv_3= ',' ( (lv_ownedParts_4_0= rulePatternExpCS ) ) )*
                    loop100:
                    do {
                        int alt100=2;
                        int LA100_0 = input.LA(1);

                        if ( (LA100_0==39) ) {
                            alt100=1;
                        }


                        switch (alt100) {
                    	case 1 :
                    	    // InternalQVTbase.g:3776:4: otherlv_3= ',' ( (lv_ownedParts_4_0= rulePatternExpCS ) )
                    	    {
                    	    otherlv_3=(Token)match(input,39,FollowSets000.FOLLOW_67); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getCollectionPatternCSAccess().getCommaKeyword_2_1_0());

                    	    }
                    	    // InternalQVTbase.g:3780:1: ( (lv_ownedParts_4_0= rulePatternExpCS ) )
                    	    // InternalQVTbase.g:3781:1: (lv_ownedParts_4_0= rulePatternExpCS )
                    	    {
                    	    // InternalQVTbase.g:3781:1: (lv_ownedParts_4_0= rulePatternExpCS )
                    	    // InternalQVTbase.g:3782:3: lv_ownedParts_4_0= rulePatternExpCS
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      	        newCompositeNode(grammarAccess.getCollectionPatternCSAccess().getOwnedPartsPatternExpCSParserRuleCall_2_1_1_0());

                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_70);
                    	    lv_ownedParts_4_0=rulePatternExpCS();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getCollectionPatternCSRule());
                    	      	        }
                    	             		add(
                    	             			current,
                    	             			"ownedParts",
                    	              		lv_ownedParts_4_0,
                    	              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.PatternExpCS");
                    	      	        afterParserOrEnumRuleCall();

                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop100;
                        }
                    } while (true);

                    // InternalQVTbase.g:3798:4: (otherlv_5= '++' ( (lv_restVariableName_6_0= ruleIdentifier ) ) )
                    // InternalQVTbase.g:3798:6: otherlv_5= '++' ( (lv_restVariableName_6_0= ruleIdentifier ) )
                    {
                    otherlv_5=(Token)match(input,99,FollowSets000.FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getCollectionPatternCSAccess().getPlusSignPlusSignKeyword_2_2_0());

                    }
                    // InternalQVTbase.g:3802:1: ( (lv_restVariableName_6_0= ruleIdentifier ) )
                    // InternalQVTbase.g:3803:1: (lv_restVariableName_6_0= ruleIdentifier )
                    {
                    // InternalQVTbase.g:3803:1: (lv_restVariableName_6_0= ruleIdentifier )
                    // InternalQVTbase.g:3804:3: lv_restVariableName_6_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {

                      	        newCompositeNode(grammarAccess.getCollectionPatternCSAccess().getRestVariableNameIdentifierParserRuleCall_2_2_1_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_23);
                    lv_restVariableName_6_0=ruleIdentifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getCollectionPatternCSRule());
                      	        }
                             		set(
                             			current,
                             			"restVariableName",
                              		lv_restVariableName_6_0,
                              		"org.eclipse.ocl.xtext.base.Base.Identifier");
                      	        afterParserOrEnumRuleCall();

                    }

                    }


                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,40,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getCollectionPatternCSAccess().getRightCurlyBracketKeyword_3());

            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCollectionPatternCS"


    // $ANTLR start "entryRuleShadowPartCS"
    // InternalQVTbase.g:3832:1: entryRuleShadowPartCS returns [EObject current=null] : iv_ruleShadowPartCS= ruleShadowPartCS EOF ;
    public final EObject entryRuleShadowPartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleShadowPartCS = null;


        try {
            // InternalQVTbase.g:3833:2: (iv_ruleShadowPartCS= ruleShadowPartCS EOF )
            // InternalQVTbase.g:3834:2: iv_ruleShadowPartCS= ruleShadowPartCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getShadowPartCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleShadowPartCS=ruleShadowPartCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleShadowPartCS;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleShadowPartCS"


    // $ANTLR start "ruleShadowPartCS"
    // InternalQVTbase.g:3841:1: ruleShadowPartCS returns [EObject current=null] : ( ( ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( ( (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS ) ) ) ) | ( (lv_ownedInitExpression_3_0= ruleStringLiteralExpCS ) ) ) ;
    public final EObject ruleShadowPartCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_ownedInitExpression_2_1 = null;

        EObject lv_ownedInitExpression_2_2 = null;

        EObject lv_ownedInitExpression_3_0 = null;


         enterRule();

        try {
            // InternalQVTbase.g:3844:28: ( ( ( ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( ( (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS ) ) ) ) | ( (lv_ownedInitExpression_3_0= ruleStringLiteralExpCS ) ) ) )
            // InternalQVTbase.g:3845:1: ( ( ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( ( (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS ) ) ) ) | ( (lv_ownedInitExpression_3_0= ruleStringLiteralExpCS ) ) )
            {
            // InternalQVTbase.g:3845:1: ( ( ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( ( (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS ) ) ) ) | ( (lv_ownedInitExpression_3_0= ruleStringLiteralExpCS ) ) )
            int alt103=2;
            int LA103_0 = input.LA(1);

            if ( ((LA103_0>=RULE_SIMPLE_ID && LA103_0<=RULE_ESCAPED_ID)) ) {
                alt103=1;
            }
            else if ( (LA103_0==RULE_SINGLE_QUOTED_STRING) ) {
                alt103=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 103, 0, input);

                throw nvae;
            }
            switch (alt103) {
                case 1 :
                    // InternalQVTbase.g:3845:2: ( ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( ( (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS ) ) ) )
                    {
                    // InternalQVTbase.g:3845:2: ( ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( ( (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS ) ) ) )
                    // InternalQVTbase.g:3845:3: ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( ( (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS ) ) )
                    {
                    // InternalQVTbase.g:3845:3: ( ( ruleUnrestrictedName ) )
                    // InternalQVTbase.g:3846:1: ( ruleUnrestrictedName )
                    {
                    // InternalQVTbase.g:3846:1: ( ruleUnrestrictedName )
                    // InternalQVTbase.g:3847:3: ruleUnrestrictedName
                    {
                    if ( state.backtracking==0 ) {

                      		  /* */

                    }
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getShadowPartCSRule());
                      	        }

                    }
                    if ( state.backtracking==0 ) {

                      	        newCompositeNode(grammarAccess.getShadowPartCSAccess().getReferredPropertyPropertyCrossReference_0_0_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_71);
                    ruleUnrestrictedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        afterParserOrEnumRuleCall();

                    }

                    }


                    }

                    otherlv_1=(Token)match(input,21,FollowSets000.FOLLOW_67); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getShadowPartCSAccess().getEqualsSignKeyword_0_1());

                    }
                    // InternalQVTbase.g:3867:1: ( ( (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS ) ) )
                    // InternalQVTbase.g:3868:1: ( (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS ) )
                    {
                    // InternalQVTbase.g:3868:1: ( (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS ) )
                    // InternalQVTbase.g:3869:1: (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS )
                    {
                    // InternalQVTbase.g:3869:1: (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS )
                    int alt102=2;
                    switch ( input.LA(1) ) {
                    case RULE_SINGLE_QUOTED_STRING:
                    case RULE_INT:
                    case 51:
                    case 65:
                    case 66:
                    case 67:
                    case 83:
                    case 84:
                    case 85:
                    case 86:
                    case 87:
                    case 88:
                    case 89:
                    case 90:
                    case 91:
                    case 92:
                    case 93:
                    case 94:
                    case 95:
                    case 96:
                    case 97:
                    case 100:
                    case 102:
                    case 103:
                    case 104:
                    case 105:
                    case 112:
                    case 117:
                    case 118:
                        {
                        alt102=1;
                        }
                        break;
                    case RULE_SIMPLE_ID:
                        {
                        int LA102_2 = input.LA(2);

                        if ( (LA102_2==EOF||(LA102_2>=21 && LA102_2<=22)||(LA102_2>=39 && LA102_2<=40)||LA102_2==51||LA102_2==65||(LA102_2>=67 && LA102_2<=82)||LA102_2==106||LA102_2==108||LA102_2==122) ) {
                            alt102=1;
                        }
                        else if ( (LA102_2==20) ) {
                            alt102=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 102, 2, input);

                            throw nvae;
                        }
                        }
                        break;
                    case RULE_ESCAPED_ID:
                        {
                        int LA102_3 = input.LA(2);

                        if ( (LA102_3==20) ) {
                            alt102=2;
                        }
                        else if ( (LA102_3==EOF||(LA102_3>=21 && LA102_3<=22)||(LA102_3>=39 && LA102_3<=40)||LA102_3==51||LA102_3==65||(LA102_3>=67 && LA102_3<=82)||LA102_3==106||LA102_3==108||LA102_3==122) ) {
                            alt102=1;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 102, 3, input);

                            throw nvae;
                        }
                        }
                        break;
                    case 20:
                        {
                        alt102=2;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 102, 0, input);

                        throw nvae;
                    }

                    switch (alt102) {
                        case 1 :
                            // InternalQVTbase.g:3870:3: lv_ownedInitExpression_2_1= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {

                              	        newCompositeNode(grammarAccess.getShadowPartCSAccess().getOwnedInitExpressionExpCSParserRuleCall_0_2_0_0());

                            }
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_ownedInitExpression_2_1=ruleExpCS();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getShadowPartCSRule());
                              	        }
                                     		set(
                                     			current,
                                     			"ownedInitExpression",
                                      		lv_ownedInitExpression_2_1,
                                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
                              	        afterParserOrEnumRuleCall();

                            }

                            }
                            break;
                        case 2 :
                            // InternalQVTbase.g:3885:8: lv_ownedInitExpression_2_2= rulePatternExpCS
                            {
                            if ( state.backtracking==0 ) {

                              	        newCompositeNode(grammarAccess.getShadowPartCSAccess().getOwnedInitExpressionPatternExpCSParserRuleCall_0_2_0_1());

                            }
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_ownedInitExpression_2_2=rulePatternExpCS();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getShadowPartCSRule());
                              	        }
                                     		set(
                                     			current,
                                     			"ownedInitExpression",
                                      		lv_ownedInitExpression_2_2,
                                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.PatternExpCS");
                              	        afterParserOrEnumRuleCall();

                            }

                            }
                            break;

                    }


                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalQVTbase.g:3904:6: ( (lv_ownedInitExpression_3_0= ruleStringLiteralExpCS ) )
                    {
                    // InternalQVTbase.g:3904:6: ( (lv_ownedInitExpression_3_0= ruleStringLiteralExpCS ) )
                    // InternalQVTbase.g:3905:1: (lv_ownedInitExpression_3_0= ruleStringLiteralExpCS )
                    {
                    // InternalQVTbase.g:3905:1: (lv_ownedInitExpression_3_0= ruleStringLiteralExpCS )
                    // InternalQVTbase.g:3906:3: lv_ownedInitExpression_3_0= ruleStringLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {

                      	        newCompositeNode(grammarAccess.getShadowPartCSAccess().getOwnedInitExpressionStringLiteralExpCSParserRuleCall_1_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_ownedInitExpression_3_0=ruleStringLiteralExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getShadowPartCSRule());
                      	        }
                             		set(
                             			current,
                             			"ownedInitExpression",
                              		lv_ownedInitExpression_3_0,
                              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.StringLiteralExpCS");
                      	        afterParserOrEnumRuleCall();

                    }

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleShadowPartCS"


    // $ANTLR start "entryRulePatternExpCS"
    // InternalQVTbase.g:3930:1: entryRulePatternExpCS returns [EObject current=null] : iv_rulePatternExpCS= rulePatternExpCS EOF ;
    public final EObject entryRulePatternExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePatternExpCS = null;


        try {
            // InternalQVTbase.g:3931:2: (iv_rulePatternExpCS= rulePatternExpCS EOF )
            // InternalQVTbase.g:3932:2: iv_rulePatternExpCS= rulePatternExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPatternExpCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePatternExpCS=rulePatternExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePatternExpCS;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePatternExpCS"


    // $ANTLR start "rulePatternExpCS"
    // InternalQVTbase.g:3939:1: rulePatternExpCS returns [EObject current=null] : ( ( (lv_patternVariableName_0_0= ruleUnrestrictedName ) )? otherlv_1= ':' ( (lv_ownedPatternType_2_0= ruleTypeExpCS ) ) ) ;
    public final EObject rulePatternExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_patternVariableName_0_0 = null;

        EObject lv_ownedPatternType_2_0 = null;


         enterRule();

        try {
            // InternalQVTbase.g:3942:28: ( ( ( (lv_patternVariableName_0_0= ruleUnrestrictedName ) )? otherlv_1= ':' ( (lv_ownedPatternType_2_0= ruleTypeExpCS ) ) ) )
            // InternalQVTbase.g:3943:1: ( ( (lv_patternVariableName_0_0= ruleUnrestrictedName ) )? otherlv_1= ':' ( (lv_ownedPatternType_2_0= ruleTypeExpCS ) ) )
            {
            // InternalQVTbase.g:3943:1: ( ( (lv_patternVariableName_0_0= ruleUnrestrictedName ) )? otherlv_1= ':' ( (lv_ownedPatternType_2_0= ruleTypeExpCS ) ) )
            // InternalQVTbase.g:3943:2: ( (lv_patternVariableName_0_0= ruleUnrestrictedName ) )? otherlv_1= ':' ( (lv_ownedPatternType_2_0= ruleTypeExpCS ) )
            {
            // InternalQVTbase.g:3943:2: ( (lv_patternVariableName_0_0= ruleUnrestrictedName ) )?
            int alt104=2;
            int LA104_0 = input.LA(1);

            if ( ((LA104_0>=RULE_SIMPLE_ID && LA104_0<=RULE_ESCAPED_ID)) ) {
                alt104=1;
            }
            switch (alt104) {
                case 1 :
                    // InternalQVTbase.g:3944:1: (lv_patternVariableName_0_0= ruleUnrestrictedName )
                    {
                    // InternalQVTbase.g:3944:1: (lv_patternVariableName_0_0= ruleUnrestrictedName )
                    // InternalQVTbase.g:3945:3: lv_patternVariableName_0_0= ruleUnrestrictedName
                    {
                    if ( state.backtracking==0 ) {

                      	        newCompositeNode(grammarAccess.getPatternExpCSAccess().getPatternVariableNameUnrestrictedNameParserRuleCall_0_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_16);
                    lv_patternVariableName_0_0=ruleUnrestrictedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPatternExpCSRule());
                      	        }
                             		set(
                             			current,
                             			"patternVariableName",
                              		lv_patternVariableName_0_0,
                              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.UnrestrictedName");
                      	        afterParserOrEnumRuleCall();

                    }

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,20,FollowSets000.FOLLOW_61); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getPatternExpCSAccess().getColonKeyword_1());

            }
            // InternalQVTbase.g:3965:1: ( (lv_ownedPatternType_2_0= ruleTypeExpCS ) )
            // InternalQVTbase.g:3966:1: (lv_ownedPatternType_2_0= ruleTypeExpCS )
            {
            // InternalQVTbase.g:3966:1: (lv_ownedPatternType_2_0= ruleTypeExpCS )
            // InternalQVTbase.g:3967:3: lv_ownedPatternType_2_0= ruleTypeExpCS
            {
            if ( state.backtracking==0 ) {

              	        newCompositeNode(grammarAccess.getPatternExpCSAccess().getOwnedPatternTypeTypeExpCSParserRuleCall_2_0());

            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_ownedPatternType_2_0=ruleTypeExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getPatternExpCSRule());
              	        }
                     		set(
                     			current,
                     			"ownedPatternType",
                      		lv_ownedPatternType_2_0,
                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeExpCS");
              	        afterParserOrEnumRuleCall();

            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePatternExpCS"


    // $ANTLR start "entryRuleLambdaLiteralExpCS"
    // InternalQVTbase.g:3991:1: entryRuleLambdaLiteralExpCS returns [EObject current=null] : iv_ruleLambdaLiteralExpCS= ruleLambdaLiteralExpCS EOF ;
    public final EObject entryRuleLambdaLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLambdaLiteralExpCS = null;


        try {
            // InternalQVTbase.g:3992:2: (iv_ruleLambdaLiteralExpCS= ruleLambdaLiteralExpCS EOF )
            // InternalQVTbase.g:3993:2: iv_ruleLambdaLiteralExpCS= ruleLambdaLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLambdaLiteralExpCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleLambdaLiteralExpCS=ruleLambdaLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLambdaLiteralExpCS;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLambdaLiteralExpCS"


    // $ANTLR start "ruleLambdaLiteralExpCS"
    // InternalQVTbase.g:4000:1: ruleLambdaLiteralExpCS returns [EObject current=null] : (otherlv_0= 'Lambda' otherlv_1= '{' ( (lv_ownedExpressionCS_2_0= ruleExpCS ) ) otherlv_3= '}' ) ;
    public final EObject ruleLambdaLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_ownedExpressionCS_2_0 = null;


         enterRule();

        try {
            // InternalQVTbase.g:4003:28: ( (otherlv_0= 'Lambda' otherlv_1= '{' ( (lv_ownedExpressionCS_2_0= ruleExpCS ) ) otherlv_3= '}' ) )
            // InternalQVTbase.g:4004:1: (otherlv_0= 'Lambda' otherlv_1= '{' ( (lv_ownedExpressionCS_2_0= ruleExpCS ) ) otherlv_3= '}' )
            {
            // InternalQVTbase.g:4004:1: (otherlv_0= 'Lambda' otherlv_1= '{' ( (lv_ownedExpressionCS_2_0= ruleExpCS ) ) otherlv_3= '}' )
            // InternalQVTbase.g:4004:3: otherlv_0= 'Lambda' otherlv_1= '{' ( (lv_ownedExpressionCS_2_0= ruleExpCS ) ) otherlv_3= '}'
            {
            otherlv_0=(Token)match(input,100,FollowSets000.FOLLOW_64); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLambdaLiteralExpCSAccess().getLambdaKeyword_0());

            }
            otherlv_1=(Token)match(input,22,FollowSets000.FOLLOW_69); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getLambdaLiteralExpCSAccess().getLeftCurlyBracketKeyword_1());

            }
            // InternalQVTbase.g:4012:1: ( (lv_ownedExpressionCS_2_0= ruleExpCS ) )
            // InternalQVTbase.g:4013:1: (lv_ownedExpressionCS_2_0= ruleExpCS )
            {
            // InternalQVTbase.g:4013:1: (lv_ownedExpressionCS_2_0= ruleExpCS )
            // InternalQVTbase.g:4014:3: lv_ownedExpressionCS_2_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {

              	        newCompositeNode(grammarAccess.getLambdaLiteralExpCSAccess().getOwnedExpressionCSExpCSParserRuleCall_2_0());

            }
            pushFollow(FollowSets000.FOLLOW_23);
            lv_ownedExpressionCS_2_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLambdaLiteralExpCSRule());
              	        }
                     		set(
                     			current,
                     			"ownedExpressionCS",
                      		lv_ownedExpressionCS_2_0,
                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
              	        afterParserOrEnumRuleCall();

            }

            }


            }

            otherlv_3=(Token)match(input,40,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getLambdaLiteralExpCSAccess().getRightCurlyBracketKeyword_3());

            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLambdaLiteralExpCS"


    // $ANTLR start "entryRuleMapLiteralExpCS"
    // InternalQVTbase.g:4042:1: entryRuleMapLiteralExpCS returns [EObject current=null] : iv_ruleMapLiteralExpCS= ruleMapLiteralExpCS EOF ;
    public final EObject entryRuleMapLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMapLiteralExpCS = null;


        try {
            // InternalQVTbase.g:4043:2: (iv_ruleMapLiteralExpCS= ruleMapLiteralExpCS EOF )
            // InternalQVTbase.g:4044:2: iv_ruleMapLiteralExpCS= ruleMapLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMapLiteralExpCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMapLiteralExpCS=ruleMapLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMapLiteralExpCS;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMapLiteralExpCS"


    // $ANTLR start "ruleMapLiteralExpCS"
    // InternalQVTbase.g:4051:1: ruleMapLiteralExpCS returns [EObject current=null] : ( ( (lv_ownedType_0_0= ruleMapTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleMapLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) ) )* )? otherlv_5= '}' ) ;
    public final EObject ruleMapLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_ownedType_0_0 = null;

        EObject lv_ownedParts_2_0 = null;

        EObject lv_ownedParts_4_0 = null;


         enterRule();

        try {
            // InternalQVTbase.g:4054:28: ( ( ( (lv_ownedType_0_0= ruleMapTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleMapLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) ) )* )? otherlv_5= '}' ) )
            // InternalQVTbase.g:4055:1: ( ( (lv_ownedType_0_0= ruleMapTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleMapLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) ) )* )? otherlv_5= '}' )
            {
            // InternalQVTbase.g:4055:1: ( ( (lv_ownedType_0_0= ruleMapTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleMapLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) ) )* )? otherlv_5= '}' )
            // InternalQVTbase.g:4055:2: ( (lv_ownedType_0_0= ruleMapTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleMapLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) ) )* )? otherlv_5= '}'
            {
            // InternalQVTbase.g:4055:2: ( (lv_ownedType_0_0= ruleMapTypeCS ) )
            // InternalQVTbase.g:4056:1: (lv_ownedType_0_0= ruleMapTypeCS )
            {
            // InternalQVTbase.g:4056:1: (lv_ownedType_0_0= ruleMapTypeCS )
            // InternalQVTbase.g:4057:3: lv_ownedType_0_0= ruleMapTypeCS
            {
            if ( state.backtracking==0 ) {

              	        newCompositeNode(grammarAccess.getMapLiteralExpCSAccess().getOwnedTypeMapTypeCSParserRuleCall_0_0());

            }
            pushFollow(FollowSets000.FOLLOW_64);
            lv_ownedType_0_0=ruleMapTypeCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getMapLiteralExpCSRule());
              	        }
                     		set(
                     			current,
                     			"ownedType",
                      		lv_ownedType_0_0,
                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.MapTypeCS");
              	        afterParserOrEnumRuleCall();

            }

            }


            }

            otherlv_1=(Token)match(input,22,FollowSets000.FOLLOW_72); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getMapLiteralExpCSAccess().getLeftCurlyBracketKeyword_1());

            }
            // InternalQVTbase.g:4077:1: ( ( (lv_ownedParts_2_0= ruleMapLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) ) )* )?
            int alt106=2;
            int LA106_0 = input.LA(1);

            if ( (LA106_0==RULE_SINGLE_QUOTED_STRING||(LA106_0>=RULE_INT && LA106_0<=RULE_ESCAPED_ID)||LA106_0==51||(LA106_0>=65 && LA106_0<=67)||(LA106_0>=83 && LA106_0<=97)||LA106_0==100||(LA106_0>=102 && LA106_0<=105)||LA106_0==112||(LA106_0>=117 && LA106_0<=118)) ) {
                alt106=1;
            }
            switch (alt106) {
                case 1 :
                    // InternalQVTbase.g:4077:2: ( (lv_ownedParts_2_0= ruleMapLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) ) )*
                    {
                    // InternalQVTbase.g:4077:2: ( (lv_ownedParts_2_0= ruleMapLiteralPartCS ) )
                    // InternalQVTbase.g:4078:1: (lv_ownedParts_2_0= ruleMapLiteralPartCS )
                    {
                    // InternalQVTbase.g:4078:1: (lv_ownedParts_2_0= ruleMapLiteralPartCS )
                    // InternalQVTbase.g:4079:3: lv_ownedParts_2_0= ruleMapLiteralPartCS
                    {
                    if ( state.backtracking==0 ) {

                      	        newCompositeNode(grammarAccess.getMapLiteralExpCSAccess().getOwnedPartsMapLiteralPartCSParserRuleCall_2_0_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_66);
                    lv_ownedParts_2_0=ruleMapLiteralPartCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getMapLiteralExpCSRule());
                      	        }
                             		add(
                             			current,
                             			"ownedParts",
                              		lv_ownedParts_2_0,
                              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.MapLiteralPartCS");
                      	        afterParserOrEnumRuleCall();

                    }

                    }


                    }

                    // InternalQVTbase.g:4095:2: (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) ) )*
                    loop105:
                    do {
                        int alt105=2;
                        int LA105_0 = input.LA(1);

                        if ( (LA105_0==39) ) {
                            alt105=1;
                        }


                        switch (alt105) {
                    	case 1 :
                    	    // InternalQVTbase.g:4095:4: otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) )
                    	    {
                    	    otherlv_3=(Token)match(input,39,FollowSets000.FOLLOW_69); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getMapLiteralExpCSAccess().getCommaKeyword_2_1_0());

                    	    }
                    	    // InternalQVTbase.g:4099:1: ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) )
                    	    // InternalQVTbase.g:4100:1: (lv_ownedParts_4_0= ruleMapLiteralPartCS )
                    	    {
                    	    // InternalQVTbase.g:4100:1: (lv_ownedParts_4_0= ruleMapLiteralPartCS )
                    	    // InternalQVTbase.g:4101:3: lv_ownedParts_4_0= ruleMapLiteralPartCS
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      	        newCompositeNode(grammarAccess.getMapLiteralExpCSAccess().getOwnedPartsMapLiteralPartCSParserRuleCall_2_1_1_0());

                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_66);
                    	    lv_ownedParts_4_0=ruleMapLiteralPartCS();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getMapLiteralExpCSRule());
                    	      	        }
                    	             		add(
                    	             			current,
                    	             			"ownedParts",
                    	              		lv_ownedParts_4_0,
                    	              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.MapLiteralPartCS");
                    	      	        afterParserOrEnumRuleCall();

                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop105;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,40,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getMapLiteralExpCSAccess().getRightCurlyBracketKeyword_3());

            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMapLiteralExpCS"


    // $ANTLR start "entryRuleMapLiteralPartCS"
    // InternalQVTbase.g:4129:1: entryRuleMapLiteralPartCS returns [EObject current=null] : iv_ruleMapLiteralPartCS= ruleMapLiteralPartCS EOF ;
    public final EObject entryRuleMapLiteralPartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMapLiteralPartCS = null;


        try {
            // InternalQVTbase.g:4130:2: (iv_ruleMapLiteralPartCS= ruleMapLiteralPartCS EOF )
            // InternalQVTbase.g:4131:2: iv_ruleMapLiteralPartCS= ruleMapLiteralPartCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMapLiteralPartCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMapLiteralPartCS=ruleMapLiteralPartCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMapLiteralPartCS;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMapLiteralPartCS"


    // $ANTLR start "ruleMapLiteralPartCS"
    // InternalQVTbase.g:4138:1: ruleMapLiteralPartCS returns [EObject current=null] : ( ( (lv_ownedKey_0_0= ruleExpCS ) ) otherlv_1= '<-' ( (lv_ownedValue_2_0= ruleExpCS ) ) ) ;
    public final EObject ruleMapLiteralPartCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_ownedKey_0_0 = null;

        EObject lv_ownedValue_2_0 = null;


         enterRule();

        try {
            // InternalQVTbase.g:4141:28: ( ( ( (lv_ownedKey_0_0= ruleExpCS ) ) otherlv_1= '<-' ( (lv_ownedValue_2_0= ruleExpCS ) ) ) )
            // InternalQVTbase.g:4142:1: ( ( (lv_ownedKey_0_0= ruleExpCS ) ) otherlv_1= '<-' ( (lv_ownedValue_2_0= ruleExpCS ) ) )
            {
            // InternalQVTbase.g:4142:1: ( ( (lv_ownedKey_0_0= ruleExpCS ) ) otherlv_1= '<-' ( (lv_ownedValue_2_0= ruleExpCS ) ) )
            // InternalQVTbase.g:4142:2: ( (lv_ownedKey_0_0= ruleExpCS ) ) otherlv_1= '<-' ( (lv_ownedValue_2_0= ruleExpCS ) )
            {
            // InternalQVTbase.g:4142:2: ( (lv_ownedKey_0_0= ruleExpCS ) )
            // InternalQVTbase.g:4143:1: (lv_ownedKey_0_0= ruleExpCS )
            {
            // InternalQVTbase.g:4143:1: (lv_ownedKey_0_0= ruleExpCS )
            // InternalQVTbase.g:4144:3: lv_ownedKey_0_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {

              	        newCompositeNode(grammarAccess.getMapLiteralPartCSAccess().getOwnedKeyExpCSParserRuleCall_0_0());

            }
            pushFollow(FollowSets000.FOLLOW_73);
            lv_ownedKey_0_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getMapLiteralPartCSRule());
              	        }
                     		set(
                     			current,
                     			"ownedKey",
                      		lv_ownedKey_0_0,
                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
              	        afterParserOrEnumRuleCall();

            }

            }


            }

            otherlv_1=(Token)match(input,101,FollowSets000.FOLLOW_69); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getMapLiteralPartCSAccess().getLessThanSignHyphenMinusKeyword_1());

            }
            // InternalQVTbase.g:4164:1: ( (lv_ownedValue_2_0= ruleExpCS ) )
            // InternalQVTbase.g:4165:1: (lv_ownedValue_2_0= ruleExpCS )
            {
            // InternalQVTbase.g:4165:1: (lv_ownedValue_2_0= ruleExpCS )
            // InternalQVTbase.g:4166:3: lv_ownedValue_2_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {

              	        newCompositeNode(grammarAccess.getMapLiteralPartCSAccess().getOwnedValueExpCSParserRuleCall_2_0());

            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_ownedValue_2_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getMapLiteralPartCSRule());
              	        }
                     		set(
                     			current,
                     			"ownedValue",
                      		lv_ownedValue_2_0,
                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
              	        afterParserOrEnumRuleCall();

            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMapLiteralPartCS"


    // $ANTLR start "entryRulePrimitiveLiteralExpCS"
    // InternalQVTbase.g:4190:1: entryRulePrimitiveLiteralExpCS returns [EObject current=null] : iv_rulePrimitiveLiteralExpCS= rulePrimitiveLiteralExpCS EOF ;
    public final EObject entryRulePrimitiveLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveLiteralExpCS = null;


        try {
            // InternalQVTbase.g:4191:2: (iv_rulePrimitiveLiteralExpCS= rulePrimitiveLiteralExpCS EOF )
            // InternalQVTbase.g:4192:2: iv_rulePrimitiveLiteralExpCS= rulePrimitiveLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePrimitiveLiteralExpCS=rulePrimitiveLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimitiveLiteralExpCS;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrimitiveLiteralExpCS"


    // $ANTLR start "rulePrimitiveLiteralExpCS"
    // InternalQVTbase.g:4199:1: rulePrimitiveLiteralExpCS returns [EObject current=null] : (this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS | this_StringLiteralExpCS_1= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_5= ruleNullLiteralExpCS ) ;
    public final EObject rulePrimitiveLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_NumberLiteralExpCS_0 = null;

        EObject this_StringLiteralExpCS_1 = null;

        EObject this_BooleanLiteralExpCS_2 = null;

        EObject this_UnlimitedNaturalLiteralExpCS_3 = null;

        EObject this_InvalidLiteralExpCS_4 = null;

        EObject this_NullLiteralExpCS_5 = null;


         enterRule();

        try {
            // InternalQVTbase.g:4202:28: ( (this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS | this_StringLiteralExpCS_1= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_5= ruleNullLiteralExpCS ) )
            // InternalQVTbase.g:4203:1: (this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS | this_StringLiteralExpCS_1= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_5= ruleNullLiteralExpCS )
            {
            // InternalQVTbase.g:4203:1: (this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS | this_StringLiteralExpCS_1= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_5= ruleNullLiteralExpCS )
            int alt107=6;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt107=1;
                }
                break;
            case RULE_SINGLE_QUOTED_STRING:
                {
                alt107=2;
                }
                break;
            case 102:
            case 103:
                {
                alt107=3;
                }
                break;
            case 67:
                {
                alt107=4;
                }
                break;
            case 104:
                {
                alt107=5;
                }
                break;
            case 105:
                {
                alt107=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 107, 0, input);

                throw nvae;
            }

            switch (alt107) {
                case 1 :
                    // InternalQVTbase.g:4204:2: this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {

                      	  /* */

                    }
                    if ( state.backtracking==0 ) {

                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getNumberLiteralExpCSParserRuleCall_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_NumberLiteralExpCS_0=ruleNumberLiteralExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_NumberLiteralExpCS_0;
                              afterParserOrEnumRuleCall();

                    }

                    }
                    break;
                case 2 :
                    // InternalQVTbase.g:4217:2: this_StringLiteralExpCS_1= ruleStringLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {

                      	  /* */

                    }
                    if ( state.backtracking==0 ) {

                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getStringLiteralExpCSParserRuleCall_1());

                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_StringLiteralExpCS_1=ruleStringLiteralExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_StringLiteralExpCS_1;
                              afterParserOrEnumRuleCall();

                    }

                    }
                    break;
                case 3 :
                    // InternalQVTbase.g:4230:2: this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {

                      	  /* */

                    }
                    if ( state.backtracking==0 ) {

                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getBooleanLiteralExpCSParserRuleCall_2());

                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_BooleanLiteralExpCS_2=ruleBooleanLiteralExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_BooleanLiteralExpCS_2;
                              afterParserOrEnumRuleCall();

                    }

                    }
                    break;
                case 4 :
                    // InternalQVTbase.g:4243:2: this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {

                      	  /* */

                    }
                    if ( state.backtracking==0 ) {

                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getUnlimitedNaturalLiteralExpCSParserRuleCall_3());

                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_UnlimitedNaturalLiteralExpCS_3=ruleUnlimitedNaturalLiteralExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_UnlimitedNaturalLiteralExpCS_3;
                              afterParserOrEnumRuleCall();

                    }

                    }
                    break;
                case 5 :
                    // InternalQVTbase.g:4256:2: this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {

                      	  /* */

                    }
                    if ( state.backtracking==0 ) {

                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getInvalidLiteralExpCSParserRuleCall_4());

                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_InvalidLiteralExpCS_4=ruleInvalidLiteralExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_InvalidLiteralExpCS_4;
                              afterParserOrEnumRuleCall();

                    }

                    }
                    break;
                case 6 :
                    // InternalQVTbase.g:4269:2: this_NullLiteralExpCS_5= ruleNullLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {

                      	  /* */

                    }
                    if ( state.backtracking==0 ) {

                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getNullLiteralExpCSParserRuleCall_5());

                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_NullLiteralExpCS_5=ruleNullLiteralExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_NullLiteralExpCS_5;
                              afterParserOrEnumRuleCall();

                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrimitiveLiteralExpCS"


    // $ANTLR start "entryRuleTupleLiteralExpCS"
    // InternalQVTbase.g:4288:1: entryRuleTupleLiteralExpCS returns [EObject current=null] : iv_ruleTupleLiteralExpCS= ruleTupleLiteralExpCS EOF ;
    public final EObject entryRuleTupleLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTupleLiteralExpCS = null;


        try {
            // InternalQVTbase.g:4289:2: (iv_ruleTupleLiteralExpCS= ruleTupleLiteralExpCS EOF )
            // InternalQVTbase.g:4290:2: iv_ruleTupleLiteralExpCS= ruleTupleLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTupleLiteralExpCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTupleLiteralExpCS=ruleTupleLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTupleLiteralExpCS;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTupleLiteralExpCS"


    // $ANTLR start "ruleTupleLiteralExpCS"
    // InternalQVTbase.g:4297:1: ruleTupleLiteralExpCS returns [EObject current=null] : (otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}' ) ;
    public final EObject ruleTupleLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_ownedParts_2_0 = null;

        EObject lv_ownedParts_4_0 = null;


         enterRule();

        try {
            // InternalQVTbase.g:4300:28: ( (otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}' ) )
            // InternalQVTbase.g:4301:1: (otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}' )
            {
            // InternalQVTbase.g:4301:1: (otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}' )
            // InternalQVTbase.g:4301:3: otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,84,FollowSets000.FOLLOW_64); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getTupleLiteralExpCSAccess().getTupleKeyword_0());

            }
            otherlv_1=(Token)match(input,22,FollowSets000.FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getTupleLiteralExpCSAccess().getLeftCurlyBracketKeyword_1());

            }
            // InternalQVTbase.g:4309:1: ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) )
            // InternalQVTbase.g:4310:1: (lv_ownedParts_2_0= ruleTupleLiteralPartCS )
            {
            // InternalQVTbase.g:4310:1: (lv_ownedParts_2_0= ruleTupleLiteralPartCS )
            // InternalQVTbase.g:4311:3: lv_ownedParts_2_0= ruleTupleLiteralPartCS
            {
            if ( state.backtracking==0 ) {

              	        newCompositeNode(grammarAccess.getTupleLiteralExpCSAccess().getOwnedPartsTupleLiteralPartCSParserRuleCall_2_0());

            }
            pushFollow(FollowSets000.FOLLOW_66);
            lv_ownedParts_2_0=ruleTupleLiteralPartCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTupleLiteralExpCSRule());
              	        }
                     		add(
                     			current,
                     			"ownedParts",
                      		lv_ownedParts_2_0,
                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TupleLiteralPartCS");
              	        afterParserOrEnumRuleCall();

            }

            }


            }

            // InternalQVTbase.g:4327:2: (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )*
            loop108:
            do {
                int alt108=2;
                int LA108_0 = input.LA(1);

                if ( (LA108_0==39) ) {
                    alt108=1;
                }


                switch (alt108) {
            	case 1 :
            	    // InternalQVTbase.g:4327:4: otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) )
            	    {
            	    otherlv_3=(Token)match(input,39,FollowSets000.FOLLOW_6); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getTupleLiteralExpCSAccess().getCommaKeyword_3_0());

            	    }
            	    // InternalQVTbase.g:4331:1: ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) )
            	    // InternalQVTbase.g:4332:1: (lv_ownedParts_4_0= ruleTupleLiteralPartCS )
            	    {
            	    // InternalQVTbase.g:4332:1: (lv_ownedParts_4_0= ruleTupleLiteralPartCS )
            	    // InternalQVTbase.g:4333:3: lv_ownedParts_4_0= ruleTupleLiteralPartCS
            	    {
            	    if ( state.backtracking==0 ) {

            	      	        newCompositeNode(grammarAccess.getTupleLiteralExpCSAccess().getOwnedPartsTupleLiteralPartCSParserRuleCall_3_1_0());

            	    }
            	    pushFollow(FollowSets000.FOLLOW_66);
            	    lv_ownedParts_4_0=ruleTupleLiteralPartCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getTupleLiteralExpCSRule());
            	      	        }
            	             		add(
            	             			current,
            	             			"ownedParts",
            	              		lv_ownedParts_4_0,
            	              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TupleLiteralPartCS");
            	      	        afterParserOrEnumRuleCall();

            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop108;
                }
            } while (true);

            otherlv_5=(Token)match(input,40,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getTupleLiteralExpCSAccess().getRightCurlyBracketKeyword_4());

            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTupleLiteralExpCS"


    // $ANTLR start "entryRuleTupleLiteralPartCS"
    // InternalQVTbase.g:4361:1: entryRuleTupleLiteralPartCS returns [EObject current=null] : iv_ruleTupleLiteralPartCS= ruleTupleLiteralPartCS EOF ;
    public final EObject entryRuleTupleLiteralPartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTupleLiteralPartCS = null;


        try {
            // InternalQVTbase.g:4362:2: (iv_ruleTupleLiteralPartCS= ruleTupleLiteralPartCS EOF )
            // InternalQVTbase.g:4363:2: iv_ruleTupleLiteralPartCS= ruleTupleLiteralPartCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTupleLiteralPartCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTupleLiteralPartCS=ruleTupleLiteralPartCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTupleLiteralPartCS;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTupleLiteralPartCS"


    // $ANTLR start "ruleTupleLiteralPartCS"
    // InternalQVTbase.g:4370:1: ruleTupleLiteralPartCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) ) ;
    public final EObject ruleTupleLiteralPartCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;

        EObject lv_ownedInitExpression_4_0 = null;


         enterRule();

        try {
            // InternalQVTbase.g:4373:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) ) )
            // InternalQVTbase.g:4374:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )
            {
            // InternalQVTbase.g:4374:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )
            // InternalQVTbase.g:4374:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) )
            {
            // InternalQVTbase.g:4374:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // InternalQVTbase.g:4375:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // InternalQVTbase.g:4375:1: (lv_name_0_0= ruleUnrestrictedName )
            // InternalQVTbase.g:4376:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {

              	        newCompositeNode(grammarAccess.getTupleLiteralPartCSAccess().getNameUnrestrictedNameParserRuleCall_0_0());

            }
            pushFollow(FollowSets000.FOLLOW_74);
            lv_name_0_0=ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTupleLiteralPartCSRule());
              	        }
                     		set(
                     			current,
                     			"name",
                      		lv_name_0_0,
                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.UnrestrictedName");
              	        afterParserOrEnumRuleCall();

            }

            }


            }

            // InternalQVTbase.g:4392:2: (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )?
            int alt109=2;
            int LA109_0 = input.LA(1);

            if ( (LA109_0==20) ) {
                alt109=1;
            }
            switch (alt109) {
                case 1 :
                    // InternalQVTbase.g:4392:4: otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                    {
                    otherlv_1=(Token)match(input,20,FollowSets000.FOLLOW_61); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getTupleLiteralPartCSAccess().getColonKeyword_1_0());

                    }
                    // InternalQVTbase.g:4396:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                    // InternalQVTbase.g:4397:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    {
                    // InternalQVTbase.g:4397:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    // InternalQVTbase.g:4398:3: lv_ownedType_2_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {

                      	        newCompositeNode(grammarAccess.getTupleLiteralPartCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_71);
                    lv_ownedType_2_0=ruleTypeExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTupleLiteralPartCSRule());
                      	        }
                             		set(
                             			current,
                             			"ownedType",
                              		lv_ownedType_2_0,
                              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeExpCS");
                      	        afterParserOrEnumRuleCall();

                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,21,FollowSets000.FOLLOW_69); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getTupleLiteralPartCSAccess().getEqualsSignKeyword_2());

            }
            // InternalQVTbase.g:4418:1: ( (lv_ownedInitExpression_4_0= ruleExpCS ) )
            // InternalQVTbase.g:4419:1: (lv_ownedInitExpression_4_0= ruleExpCS )
            {
            // InternalQVTbase.g:4419:1: (lv_ownedInitExpression_4_0= ruleExpCS )
            // InternalQVTbase.g:4420:3: lv_ownedInitExpression_4_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {

              	        newCompositeNode(grammarAccess.getTupleLiteralPartCSAccess().getOwnedInitExpressionExpCSParserRuleCall_3_0());

            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_ownedInitExpression_4_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTupleLiteralPartCSRule());
              	        }
                     		set(
                     			current,
                     			"ownedInitExpression",
                      		lv_ownedInitExpression_4_0,
                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
              	        afterParserOrEnumRuleCall();

            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTupleLiteralPartCS"


    // $ANTLR start "entryRuleNumberLiteralExpCS"
    // InternalQVTbase.g:4444:1: entryRuleNumberLiteralExpCS returns [EObject current=null] : iv_ruleNumberLiteralExpCS= ruleNumberLiteralExpCS EOF ;
    public final EObject entryRuleNumberLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberLiteralExpCS = null;


        try {
            // InternalQVTbase.g:4445:2: (iv_ruleNumberLiteralExpCS= ruleNumberLiteralExpCS EOF )
            // InternalQVTbase.g:4446:2: iv_ruleNumberLiteralExpCS= ruleNumberLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumberLiteralExpCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNumberLiteralExpCS=ruleNumberLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumberLiteralExpCS;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNumberLiteralExpCS"


    // $ANTLR start "ruleNumberLiteralExpCS"
    // InternalQVTbase.g:4453:1: ruleNumberLiteralExpCS returns [EObject current=null] : ( (lv_symbol_0_0= ruleNUMBER_LITERAL ) ) ;
    public final EObject ruleNumberLiteralExpCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_symbol_0_0 = null;


         enterRule();

        try {
            // InternalQVTbase.g:4456:28: ( ( (lv_symbol_0_0= ruleNUMBER_LITERAL ) ) )
            // InternalQVTbase.g:4457:1: ( (lv_symbol_0_0= ruleNUMBER_LITERAL ) )
            {
            // InternalQVTbase.g:4457:1: ( (lv_symbol_0_0= ruleNUMBER_LITERAL ) )
            // InternalQVTbase.g:4458:1: (lv_symbol_0_0= ruleNUMBER_LITERAL )
            {
            // InternalQVTbase.g:4458:1: (lv_symbol_0_0= ruleNUMBER_LITERAL )
            // InternalQVTbase.g:4459:3: lv_symbol_0_0= ruleNUMBER_LITERAL
            {
            if ( state.backtracking==0 ) {

              	        newCompositeNode(grammarAccess.getNumberLiteralExpCSAccess().getSymbolNUMBER_LITERALParserRuleCall_0());

            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_symbol_0_0=ruleNUMBER_LITERAL();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getNumberLiteralExpCSRule());
              	        }
                     		set(
                     			current,
                     			"symbol",
                      		lv_symbol_0_0,
                      		"org.eclipse.ocl.xtext.base.Base.NUMBER_LITERAL");
              	        afterParserOrEnumRuleCall();

            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNumberLiteralExpCS"


    // $ANTLR start "entryRuleStringLiteralExpCS"
    // InternalQVTbase.g:4483:1: entryRuleStringLiteralExpCS returns [EObject current=null] : iv_ruleStringLiteralExpCS= ruleStringLiteralExpCS EOF ;
    public final EObject entryRuleStringLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteralExpCS = null;


        try {
            // InternalQVTbase.g:4484:2: (iv_ruleStringLiteralExpCS= ruleStringLiteralExpCS EOF )
            // InternalQVTbase.g:4485:2: iv_ruleStringLiteralExpCS= ruleStringLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStringLiteralExpCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleStringLiteralExpCS=ruleStringLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStringLiteralExpCS;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStringLiteralExpCS"


    // $ANTLR start "ruleStringLiteralExpCS"
    // InternalQVTbase.g:4492:1: ruleStringLiteralExpCS returns [EObject current=null] : ( (lv_segments_0_0= ruleStringLiteral ) )+ ;
    public final EObject ruleStringLiteralExpCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_segments_0_0 = null;


         enterRule();

        try {
            // InternalQVTbase.g:4495:28: ( ( (lv_segments_0_0= ruleStringLiteral ) )+ )
            // InternalQVTbase.g:4496:1: ( (lv_segments_0_0= ruleStringLiteral ) )+
            {
            // InternalQVTbase.g:4496:1: ( (lv_segments_0_0= ruleStringLiteral ) )+
            int cnt110=0;
            loop110:
            do {
                int alt110=2;
                int LA110_0 = input.LA(1);

                if ( (LA110_0==RULE_SINGLE_QUOTED_STRING) ) {
                    alt110=1;
                }


                switch (alt110) {
            	case 1 :
            	    // InternalQVTbase.g:4497:1: (lv_segments_0_0= ruleStringLiteral )
            	    {
            	    // InternalQVTbase.g:4497:1: (lv_segments_0_0= ruleStringLiteral )
            	    // InternalQVTbase.g:4498:3: lv_segments_0_0= ruleStringLiteral
            	    {
            	    if ( state.backtracking==0 ) {

            	      	        newCompositeNode(grammarAccess.getStringLiteralExpCSAccess().getSegmentsStringLiteralParserRuleCall_0());

            	    }
            	    pushFollow(FollowSets000.FOLLOW_75);
            	    lv_segments_0_0=ruleStringLiteral();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getStringLiteralExpCSRule());
            	      	        }
            	             		add(
            	             			current,
            	             			"segments",
            	              		lv_segments_0_0,
            	              		"org.eclipse.ocl.xtext.base.Base.StringLiteral");
            	      	        afterParserOrEnumRuleCall();

            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt110 >= 1 ) break loop110;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(110, input);
                        throw eee;
                }
                cnt110++;
            } while (true);


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStringLiteralExpCS"


    // $ANTLR start "entryRuleBooleanLiteralExpCS"
    // InternalQVTbase.g:4522:1: entryRuleBooleanLiteralExpCS returns [EObject current=null] : iv_ruleBooleanLiteralExpCS= ruleBooleanLiteralExpCS EOF ;
    public final EObject entryRuleBooleanLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteralExpCS = null;


        try {
            // InternalQVTbase.g:4523:2: (iv_ruleBooleanLiteralExpCS= ruleBooleanLiteralExpCS EOF )
            // InternalQVTbase.g:4524:2: iv_ruleBooleanLiteralExpCS= ruleBooleanLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBooleanLiteralExpCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleBooleanLiteralExpCS=ruleBooleanLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBooleanLiteralExpCS;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBooleanLiteralExpCS"


    // $ANTLR start "ruleBooleanLiteralExpCS"
    // InternalQVTbase.g:4531:1: ruleBooleanLiteralExpCS returns [EObject current=null] : ( ( (lv_symbol_0_0= 'true' ) ) | ( (lv_symbol_1_0= 'false' ) ) ) ;
    public final EObject ruleBooleanLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token lv_symbol_0_0=null;
        Token lv_symbol_1_0=null;

         enterRule();

        try {
            // InternalQVTbase.g:4534:28: ( ( ( (lv_symbol_0_0= 'true' ) ) | ( (lv_symbol_1_0= 'false' ) ) ) )
            // InternalQVTbase.g:4535:1: ( ( (lv_symbol_0_0= 'true' ) ) | ( (lv_symbol_1_0= 'false' ) ) )
            {
            // InternalQVTbase.g:4535:1: ( ( (lv_symbol_0_0= 'true' ) ) | ( (lv_symbol_1_0= 'false' ) ) )
            int alt111=2;
            int LA111_0 = input.LA(1);

            if ( (LA111_0==102) ) {
                alt111=1;
            }
            else if ( (LA111_0==103) ) {
                alt111=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 111, 0, input);

                throw nvae;
            }
            switch (alt111) {
                case 1 :
                    // InternalQVTbase.g:4535:2: ( (lv_symbol_0_0= 'true' ) )
                    {
                    // InternalQVTbase.g:4535:2: ( (lv_symbol_0_0= 'true' ) )
                    // InternalQVTbase.g:4536:1: (lv_symbol_0_0= 'true' )
                    {
                    // InternalQVTbase.g:4536:1: (lv_symbol_0_0= 'true' )
                    // InternalQVTbase.g:4537:3: lv_symbol_0_0= 'true'
                    {
                    lv_symbol_0_0=(Token)match(input,102,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_symbol_0_0, grammarAccess.getBooleanLiteralExpCSAccess().getSymbolTrueKeyword_0_0());

                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBooleanLiteralExpCSRule());
                      	        }
                             		setWithLastConsumed(current, "symbol", lv_symbol_0_0, "true");

                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalQVTbase.g:4551:6: ( (lv_symbol_1_0= 'false' ) )
                    {
                    // InternalQVTbase.g:4551:6: ( (lv_symbol_1_0= 'false' ) )
                    // InternalQVTbase.g:4552:1: (lv_symbol_1_0= 'false' )
                    {
                    // InternalQVTbase.g:4552:1: (lv_symbol_1_0= 'false' )
                    // InternalQVTbase.g:4553:3: lv_symbol_1_0= 'false'
                    {
                    lv_symbol_1_0=(Token)match(input,103,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_symbol_1_0, grammarAccess.getBooleanLiteralExpCSAccess().getSymbolFalseKeyword_1_0());

                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBooleanLiteralExpCSRule());
                      	        }
                             		setWithLastConsumed(current, "symbol", lv_symbol_1_0, "false");

                    }

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBooleanLiteralExpCS"


    // $ANTLR start "entryRuleUnlimitedNaturalLiteralExpCS"
    // InternalQVTbase.g:4574:1: entryRuleUnlimitedNaturalLiteralExpCS returns [EObject current=null] : iv_ruleUnlimitedNaturalLiteralExpCS= ruleUnlimitedNaturalLiteralExpCS EOF ;
    public final EObject entryRuleUnlimitedNaturalLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnlimitedNaturalLiteralExpCS = null;


        try {
            // InternalQVTbase.g:4575:2: (iv_ruleUnlimitedNaturalLiteralExpCS= ruleUnlimitedNaturalLiteralExpCS EOF )
            // InternalQVTbase.g:4576:2: iv_ruleUnlimitedNaturalLiteralExpCS= ruleUnlimitedNaturalLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnlimitedNaturalLiteralExpCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUnlimitedNaturalLiteralExpCS=ruleUnlimitedNaturalLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnlimitedNaturalLiteralExpCS;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnlimitedNaturalLiteralExpCS"


    // $ANTLR start "ruleUnlimitedNaturalLiteralExpCS"
    // InternalQVTbase.g:4583:1: ruleUnlimitedNaturalLiteralExpCS returns [EObject current=null] : ( () otherlv_1= '*' ) ;
    public final EObject ruleUnlimitedNaturalLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule();

        try {
            // InternalQVTbase.g:4586:28: ( ( () otherlv_1= '*' ) )
            // InternalQVTbase.g:4587:1: ( () otherlv_1= '*' )
            {
            // InternalQVTbase.g:4587:1: ( () otherlv_1= '*' )
            // InternalQVTbase.g:4587:2: () otherlv_1= '*'
            {
            // InternalQVTbase.g:4587:2: ()
            // InternalQVTbase.g:4588:2:
            {
            if ( state.backtracking==0 ) {

              	  /* */

            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getUnlimitedNaturalLiteralExpCSAccess().getUnlimitedNaturalLiteralExpCSAction_0(),
                          current);

            }

            }

            otherlv_1=(Token)match(input,67,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getUnlimitedNaturalLiteralExpCSAccess().getAsteriskKeyword_1());

            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnlimitedNaturalLiteralExpCS"


    // $ANTLR start "entryRuleInvalidLiteralExpCS"
    // InternalQVTbase.g:4608:1: entryRuleInvalidLiteralExpCS returns [EObject current=null] : iv_ruleInvalidLiteralExpCS= ruleInvalidLiteralExpCS EOF ;
    public final EObject entryRuleInvalidLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInvalidLiteralExpCS = null;


        try {
            // InternalQVTbase.g:4609:2: (iv_ruleInvalidLiteralExpCS= ruleInvalidLiteralExpCS EOF )
            // InternalQVTbase.g:4610:2: iv_ruleInvalidLiteralExpCS= ruleInvalidLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInvalidLiteralExpCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleInvalidLiteralExpCS=ruleInvalidLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInvalidLiteralExpCS;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInvalidLiteralExpCS"


    // $ANTLR start "ruleInvalidLiteralExpCS"
    // InternalQVTbase.g:4617:1: ruleInvalidLiteralExpCS returns [EObject current=null] : ( () otherlv_1= 'invalid' ) ;
    public final EObject ruleInvalidLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule();

        try {
            // InternalQVTbase.g:4620:28: ( ( () otherlv_1= 'invalid' ) )
            // InternalQVTbase.g:4621:1: ( () otherlv_1= 'invalid' )
            {
            // InternalQVTbase.g:4621:1: ( () otherlv_1= 'invalid' )
            // InternalQVTbase.g:4621:2: () otherlv_1= 'invalid'
            {
            // InternalQVTbase.g:4621:2: ()
            // InternalQVTbase.g:4622:2:
            {
            if ( state.backtracking==0 ) {

              	  /* */

            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getInvalidLiteralExpCSAccess().getInvalidLiteralExpCSAction_0(),
                          current);

            }

            }

            otherlv_1=(Token)match(input,104,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getInvalidLiteralExpCSAccess().getInvalidKeyword_1());

            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInvalidLiteralExpCS"


    // $ANTLR start "entryRuleNullLiteralExpCS"
    // InternalQVTbase.g:4642:1: entryRuleNullLiteralExpCS returns [EObject current=null] : iv_ruleNullLiteralExpCS= ruleNullLiteralExpCS EOF ;
    public final EObject entryRuleNullLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullLiteralExpCS = null;


        try {
            // InternalQVTbase.g:4643:2: (iv_ruleNullLiteralExpCS= ruleNullLiteralExpCS EOF )
            // InternalQVTbase.g:4644:2: iv_ruleNullLiteralExpCS= ruleNullLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNullLiteralExpCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNullLiteralExpCS=ruleNullLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNullLiteralExpCS;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNullLiteralExpCS"


    // $ANTLR start "ruleNullLiteralExpCS"
    // InternalQVTbase.g:4651:1: ruleNullLiteralExpCS returns [EObject current=null] : ( () otherlv_1= 'null' ) ;
    public final EObject ruleNullLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule();

        try {
            // InternalQVTbase.g:4654:28: ( ( () otherlv_1= 'null' ) )
            // InternalQVTbase.g:4655:1: ( () otherlv_1= 'null' )
            {
            // InternalQVTbase.g:4655:1: ( () otherlv_1= 'null' )
            // InternalQVTbase.g:4655:2: () otherlv_1= 'null'
            {
            // InternalQVTbase.g:4655:2: ()
            // InternalQVTbase.g:4656:2:
            {
            if ( state.backtracking==0 ) {

              	  /* */

            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getNullLiteralExpCSAccess().getNullLiteralExpCSAction_0(),
                          current);

            }

            }

            otherlv_1=(Token)match(input,105,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getNullLiteralExpCSAccess().getNullKeyword_1());

            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNullLiteralExpCS"


    // $ANTLR start "entryRuleTypeLiteralCS"
    // InternalQVTbase.g:4676:1: entryRuleTypeLiteralCS returns [EObject current=null] : iv_ruleTypeLiteralCS= ruleTypeLiteralCS EOF ;
    public final EObject entryRuleTypeLiteralCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeLiteralCS = null;


        try {
            // InternalQVTbase.g:4677:2: (iv_ruleTypeLiteralCS= ruleTypeLiteralCS EOF )
            // InternalQVTbase.g:4678:2: iv_ruleTypeLiteralCS= ruleTypeLiteralCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeLiteralCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTypeLiteralCS=ruleTypeLiteralCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeLiteralCS;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypeLiteralCS"


    // $ANTLR start "ruleTypeLiteralCS"
    // InternalQVTbase.g:4685:1: ruleTypeLiteralCS returns [EObject current=null] : (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS | this_CollectionTypeCS_1= ruleCollectionTypeCS | this_MapTypeCS_2= ruleMapTypeCS | this_TupleTypeCS_3= ruleTupleTypeCS ) ;
    public final EObject ruleTypeLiteralCS() throws RecognitionException {
        EObject current = null;

        EObject this_PrimitiveTypeCS_0 = null;

        EObject this_CollectionTypeCS_1 = null;

        EObject this_MapTypeCS_2 = null;

        EObject this_TupleTypeCS_3 = null;


         enterRule();

        try {
            // InternalQVTbase.g:4688:28: ( (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS | this_CollectionTypeCS_1= ruleCollectionTypeCS | this_MapTypeCS_2= ruleMapTypeCS | this_TupleTypeCS_3= ruleTupleTypeCS ) )
            // InternalQVTbase.g:4689:1: (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS | this_CollectionTypeCS_1= ruleCollectionTypeCS | this_MapTypeCS_2= ruleMapTypeCS | this_TupleTypeCS_3= ruleTupleTypeCS )
            {
            // InternalQVTbase.g:4689:1: (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS | this_CollectionTypeCS_1= ruleCollectionTypeCS | this_MapTypeCS_2= ruleMapTypeCS | this_TupleTypeCS_3= ruleTupleTypeCS )
            int alt112=4;
            switch ( input.LA(1) ) {
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
            case 92:
                {
                alt112=1;
                }
                break;
            case 93:
            case 94:
            case 95:
            case 96:
            case 97:
                {
                alt112=2;
                }
                break;
            case 83:
                {
                alt112=3;
                }
                break;
            case 84:
                {
                alt112=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 112, 0, input);

                throw nvae;
            }

            switch (alt112) {
                case 1 :
                    // InternalQVTbase.g:4690:2: this_PrimitiveTypeCS_0= rulePrimitiveTypeCS
                    {
                    if ( state.backtracking==0 ) {

                      	  /* */

                    }
                    if ( state.backtracking==0 ) {

                              newCompositeNode(grammarAccess.getTypeLiteralCSAccess().getPrimitiveTypeCSParserRuleCall_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_PrimitiveTypeCS_0=rulePrimitiveTypeCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_PrimitiveTypeCS_0;
                              afterParserOrEnumRuleCall();

                    }

                    }
                    break;
                case 2 :
                    // InternalQVTbase.g:4703:2: this_CollectionTypeCS_1= ruleCollectionTypeCS
                    {
                    if ( state.backtracking==0 ) {

                      	  /* */

                    }
                    if ( state.backtracking==0 ) {

                              newCompositeNode(grammarAccess.getTypeLiteralCSAccess().getCollectionTypeCSParserRuleCall_1());

                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_CollectionTypeCS_1=ruleCollectionTypeCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_CollectionTypeCS_1;
                              afterParserOrEnumRuleCall();

                    }

                    }
                    break;
                case 3 :
                    // InternalQVTbase.g:4716:2: this_MapTypeCS_2= ruleMapTypeCS
                    {
                    if ( state.backtracking==0 ) {

                      	  /* */

                    }
                    if ( state.backtracking==0 ) {

                              newCompositeNode(grammarAccess.getTypeLiteralCSAccess().getMapTypeCSParserRuleCall_2());

                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_MapTypeCS_2=ruleMapTypeCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_MapTypeCS_2;
                              afterParserOrEnumRuleCall();

                    }

                    }
                    break;
                case 4 :
                    // InternalQVTbase.g:4729:2: this_TupleTypeCS_3= ruleTupleTypeCS
                    {
                    if ( state.backtracking==0 ) {

                      	  /* */

                    }
                    if ( state.backtracking==0 ) {

                              newCompositeNode(grammarAccess.getTypeLiteralCSAccess().getTupleTypeCSParserRuleCall_3());

                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_TupleTypeCS_3=ruleTupleTypeCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_TupleTypeCS_3;
                              afterParserOrEnumRuleCall();

                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypeLiteralCS"


    // $ANTLR start "entryRuleTypeLiteralWithMultiplicityCS"
    // InternalQVTbase.g:4748:1: entryRuleTypeLiteralWithMultiplicityCS returns [EObject current=null] : iv_ruleTypeLiteralWithMultiplicityCS= ruleTypeLiteralWithMultiplicityCS EOF ;
    public final EObject entryRuleTypeLiteralWithMultiplicityCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeLiteralWithMultiplicityCS = null;


        try {
            // InternalQVTbase.g:4749:2: (iv_ruleTypeLiteralWithMultiplicityCS= ruleTypeLiteralWithMultiplicityCS EOF )
            // InternalQVTbase.g:4750:2: iv_ruleTypeLiteralWithMultiplicityCS= ruleTypeLiteralWithMultiplicityCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeLiteralWithMultiplicityCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTypeLiteralWithMultiplicityCS=ruleTypeLiteralWithMultiplicityCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeLiteralWithMultiplicityCS;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypeLiteralWithMultiplicityCS"


    // $ANTLR start "ruleTypeLiteralWithMultiplicityCS"
    // InternalQVTbase.g:4757:1: ruleTypeLiteralWithMultiplicityCS returns [EObject current=null] : (this_TypeLiteralCS_0= ruleTypeLiteralCS ( (lv_ownedMultiplicity_1_0= ruleMultiplicityCS ) )? ) ;
    public final EObject ruleTypeLiteralWithMultiplicityCS() throws RecognitionException {
        EObject current = null;

        EObject this_TypeLiteralCS_0 = null;

        EObject lv_ownedMultiplicity_1_0 = null;


         enterRule();

        try {
            // InternalQVTbase.g:4760:28: ( (this_TypeLiteralCS_0= ruleTypeLiteralCS ( (lv_ownedMultiplicity_1_0= ruleMultiplicityCS ) )? ) )
            // InternalQVTbase.g:4761:1: (this_TypeLiteralCS_0= ruleTypeLiteralCS ( (lv_ownedMultiplicity_1_0= ruleMultiplicityCS ) )? )
            {
            // InternalQVTbase.g:4761:1: (this_TypeLiteralCS_0= ruleTypeLiteralCS ( (lv_ownedMultiplicity_1_0= ruleMultiplicityCS ) )? )
            // InternalQVTbase.g:4762:2: this_TypeLiteralCS_0= ruleTypeLiteralCS ( (lv_ownedMultiplicity_1_0= ruleMultiplicityCS ) )?
            {
            if ( state.backtracking==0 ) {

              	  /* */

            }
            if ( state.backtracking==0 ) {

                      newCompositeNode(grammarAccess.getTypeLiteralWithMultiplicityCSAccess().getTypeLiteralCSParserRuleCall_0());

            }
            pushFollow(FollowSets000.FOLLOW_58);
            this_TypeLiteralCS_0=ruleTypeLiteralCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current = this_TypeLiteralCS_0;
                      afterParserOrEnumRuleCall();

            }
            // InternalQVTbase.g:4773:1: ( (lv_ownedMultiplicity_1_0= ruleMultiplicityCS ) )?
            int alt113=2;
            int LA113_0 = input.LA(1);

            if ( (LA113_0==108) ) {
                alt113=1;
            }
            switch (alt113) {
                case 1 :
                    // InternalQVTbase.g:4774:1: (lv_ownedMultiplicity_1_0= ruleMultiplicityCS )
                    {
                    // InternalQVTbase.g:4774:1: (lv_ownedMultiplicity_1_0= ruleMultiplicityCS )
                    // InternalQVTbase.g:4775:3: lv_ownedMultiplicity_1_0= ruleMultiplicityCS
                    {
                    if ( state.backtracking==0 ) {

                      	        newCompositeNode(grammarAccess.getTypeLiteralWithMultiplicityCSAccess().getOwnedMultiplicityMultiplicityCSParserRuleCall_1_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_ownedMultiplicity_1_0=ruleMultiplicityCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTypeLiteralWithMultiplicityCSRule());
                      	        }
                             		set(
                             			current,
                             			"ownedMultiplicity",
                              		lv_ownedMultiplicity_1_0,
                              		"org.eclipse.ocl.xtext.base.Base.MultiplicityCS");
                      	        afterParserOrEnumRuleCall();

                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypeLiteralWithMultiplicityCS"


    // $ANTLR start "entryRuleTypeLiteralExpCS"
    // InternalQVTbase.g:4799:1: entryRuleTypeLiteralExpCS returns [EObject current=null] : iv_ruleTypeLiteralExpCS= ruleTypeLiteralExpCS EOF ;
    public final EObject entryRuleTypeLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeLiteralExpCS = null;


        try {
            // InternalQVTbase.g:4800:2: (iv_ruleTypeLiteralExpCS= ruleTypeLiteralExpCS EOF )
            // InternalQVTbase.g:4801:2: iv_ruleTypeLiteralExpCS= ruleTypeLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeLiteralExpCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTypeLiteralExpCS=ruleTypeLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeLiteralExpCS;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypeLiteralExpCS"


    // $ANTLR start "ruleTypeLiteralExpCS"
    // InternalQVTbase.g:4808:1: ruleTypeLiteralExpCS returns [EObject current=null] : ( (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS ) ) ;
    public final EObject ruleTypeLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject lv_ownedType_0_0 = null;


         enterRule();

        try {
            // InternalQVTbase.g:4811:28: ( ( (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS ) ) )
            // InternalQVTbase.g:4812:1: ( (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS ) )
            {
            // InternalQVTbase.g:4812:1: ( (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS ) )
            // InternalQVTbase.g:4813:1: (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS )
            {
            // InternalQVTbase.g:4813:1: (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS )
            // InternalQVTbase.g:4814:3: lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS
            {
            if ( state.backtracking==0 ) {

              	        newCompositeNode(grammarAccess.getTypeLiteralExpCSAccess().getOwnedTypeTypeLiteralWithMultiplicityCSParserRuleCall_0());

            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_ownedType_0_0=ruleTypeLiteralWithMultiplicityCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTypeLiteralExpCSRule());
              	        }
                     		set(
                     			current,
                     			"ownedType",
                      		lv_ownedType_0_0,
                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeLiteralWithMultiplicityCS");
              	        afterParserOrEnumRuleCall();

            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypeLiteralExpCS"


    // $ANTLR start "entryRuleTypeNameExpCS"
    // InternalQVTbase.g:4838:1: entryRuleTypeNameExpCS returns [EObject current=null] : iv_ruleTypeNameExpCS= ruleTypeNameExpCS EOF ;
    public final EObject entryRuleTypeNameExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeNameExpCS = null;


        try {
            // InternalQVTbase.g:4839:2: (iv_ruleTypeNameExpCS= ruleTypeNameExpCS EOF )
            // InternalQVTbase.g:4840:2: iv_ruleTypeNameExpCS= ruleTypeNameExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeNameExpCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTypeNameExpCS=ruleTypeNameExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeNameExpCS;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypeNameExpCS"


    // $ANTLR start "ruleTypeNameExpCS"
    // InternalQVTbase.g:4847:1: ruleTypeNameExpCS returns [EObject current=null] : ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( ( (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS ) ) (otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}' )? )? ) ;
    public final EObject ruleTypeNameExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_ownedPathName_0_0 = null;

        EObject lv_ownedCurlyBracketedClause_1_0 = null;

        EObject lv_ownedPatternGuard_3_0 = null;


         enterRule();

        try {
            // InternalQVTbase.g:4850:28: ( ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( ( (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS ) ) (otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}' )? )? ) )
            // InternalQVTbase.g:4851:1: ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( ( (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS ) ) (otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}' )? )? )
            {
            // InternalQVTbase.g:4851:1: ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( ( (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS ) ) (otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}' )? )? )
            // InternalQVTbase.g:4851:2: ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( ( (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS ) ) (otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}' )? )?
            {
            // InternalQVTbase.g:4851:2: ( (lv_ownedPathName_0_0= rulePathNameCS ) )
            // InternalQVTbase.g:4852:1: (lv_ownedPathName_0_0= rulePathNameCS )
            {
            // InternalQVTbase.g:4852:1: (lv_ownedPathName_0_0= rulePathNameCS )
            // InternalQVTbase.g:4853:3: lv_ownedPathName_0_0= rulePathNameCS
            {
            if ( state.backtracking==0 ) {

              	        newCompositeNode(grammarAccess.getTypeNameExpCSAccess().getOwnedPathNamePathNameCSParserRuleCall_0_0());

            }
            pushFollow(FollowSets000.FOLLOW_41);
            lv_ownedPathName_0_0=rulePathNameCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTypeNameExpCSRule());
              	        }
                     		set(
                     			current,
                     			"ownedPathName",
                      		lv_ownedPathName_0_0,
                      		"org.eclipse.ocl.xtext.base.Base.PathNameCS");
              	        afterParserOrEnumRuleCall();

            }

            }


            }

            // InternalQVTbase.g:4869:2: ( ( (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS ) ) (otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}' )? )?
            int alt115=2;
            int LA115_0 = input.LA(1);

            if ( (LA115_0==22) ) {
                alt115=1;
            }
            switch (alt115) {
                case 1 :
                    // InternalQVTbase.g:4869:3: ( (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS ) ) (otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}' )?
                    {
                    // InternalQVTbase.g:4869:3: ( (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS ) )
                    // InternalQVTbase.g:4870:1: (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS )
                    {
                    // InternalQVTbase.g:4870:1: (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS )
                    // InternalQVTbase.g:4871:3: lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS
                    {
                    if ( state.backtracking==0 ) {

                      	        newCompositeNode(grammarAccess.getTypeNameExpCSAccess().getOwnedCurlyBracketedClauseCurlyBracketedClauseCSParserRuleCall_1_0_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_41);
                    lv_ownedCurlyBracketedClause_1_0=ruleCurlyBracketedClauseCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTypeNameExpCSRule());
                      	        }
                             		set(
                             			current,
                             			"ownedCurlyBracketedClause",
                              		lv_ownedCurlyBracketedClause_1_0,
                              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.CurlyBracketedClauseCS");
                      	        afterParserOrEnumRuleCall();

                    }

                    }


                    }

                    // InternalQVTbase.g:4887:2: (otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}' )?
                    int alt114=2;
                    int LA114_0 = input.LA(1);

                    if ( (LA114_0==22) ) {
                        alt114=1;
                    }
                    switch (alt114) {
                        case 1 :
                            // InternalQVTbase.g:4887:4: otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}'
                            {
                            otherlv_2=(Token)match(input,22,FollowSets000.FOLLOW_69); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_2, grammarAccess.getTypeNameExpCSAccess().getLeftCurlyBracketKeyword_1_1_0());

                            }
                            // InternalQVTbase.g:4891:1: ( (lv_ownedPatternGuard_3_0= ruleExpCS ) )
                            // InternalQVTbase.g:4892:1: (lv_ownedPatternGuard_3_0= ruleExpCS )
                            {
                            // InternalQVTbase.g:4892:1: (lv_ownedPatternGuard_3_0= ruleExpCS )
                            // InternalQVTbase.g:4893:3: lv_ownedPatternGuard_3_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {

                              	        newCompositeNode(grammarAccess.getTypeNameExpCSAccess().getOwnedPatternGuardExpCSParserRuleCall_1_1_1_0());

                            }
                            pushFollow(FollowSets000.FOLLOW_23);
                            lv_ownedPatternGuard_3_0=ruleExpCS();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getTypeNameExpCSRule());
                              	        }
                                     		set(
                                     			current,
                                     			"ownedPatternGuard",
                                      		lv_ownedPatternGuard_3_0,
                                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
                              	        afterParserOrEnumRuleCall();

                            }

                            }


                            }

                            otherlv_4=(Token)match(input,40,FollowSets000.FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getTypeNameExpCSAccess().getRightCurlyBracketKeyword_1_1_2());

                            }

                            }
                            break;

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypeNameExpCS"


    // $ANTLR start "entryRuleTypeExpCS"
    // InternalQVTbase.g:4921:1: entryRuleTypeExpCS returns [EObject current=null] : iv_ruleTypeExpCS= ruleTypeExpCS EOF ;
    public final EObject entryRuleTypeExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeExpCS = null;


        try {
            // InternalQVTbase.g:4922:2: (iv_ruleTypeExpCS= ruleTypeExpCS EOF )
            // InternalQVTbase.g:4923:2: iv_ruleTypeExpCS= ruleTypeExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeExpCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTypeExpCS=ruleTypeExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeExpCS;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypeExpCS"


    // $ANTLR start "ruleTypeExpCS"
    // InternalQVTbase.g:4930:1: ruleTypeExpCS returns [EObject current=null] : ( (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS | this_CollectionPatternCS_2= ruleCollectionPatternCS ) ( (lv_ownedMultiplicity_3_0= ruleMultiplicityCS ) )? ) ;
    public final EObject ruleTypeExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_TypeNameExpCS_0 = null;

        EObject this_TypeLiteralCS_1 = null;

        EObject this_CollectionPatternCS_2 = null;

        EObject lv_ownedMultiplicity_3_0 = null;


         enterRule();

        try {
            // InternalQVTbase.g:4933:28: ( ( (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS | this_CollectionPatternCS_2= ruleCollectionPatternCS ) ( (lv_ownedMultiplicity_3_0= ruleMultiplicityCS ) )? ) )
            // InternalQVTbase.g:4934:1: ( (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS | this_CollectionPatternCS_2= ruleCollectionPatternCS ) ( (lv_ownedMultiplicity_3_0= ruleMultiplicityCS ) )? )
            {
            // InternalQVTbase.g:4934:1: ( (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS | this_CollectionPatternCS_2= ruleCollectionPatternCS ) ( (lv_ownedMultiplicity_3_0= ruleMultiplicityCS ) )? )
            // InternalQVTbase.g:4934:2: (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS | this_CollectionPatternCS_2= ruleCollectionPatternCS ) ( (lv_ownedMultiplicity_3_0= ruleMultiplicityCS ) )?
            {
            // InternalQVTbase.g:4934:2: (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS | this_CollectionPatternCS_2= ruleCollectionPatternCS )
            int alt116=3;
            alt116 = dfa116.predict(input);
            switch (alt116) {
                case 1 :
                    // InternalQVTbase.g:4935:2: this_TypeNameExpCS_0= ruleTypeNameExpCS
                    {
                    if ( state.backtracking==0 ) {

                      	  /* */

                    }
                    if ( state.backtracking==0 ) {

                              newCompositeNode(grammarAccess.getTypeExpCSAccess().getTypeNameExpCSParserRuleCall_0_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_58);
                    this_TypeNameExpCS_0=ruleTypeNameExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_TypeNameExpCS_0;
                              afterParserOrEnumRuleCall();

                    }

                    }
                    break;
                case 2 :
                    // InternalQVTbase.g:4948:2: this_TypeLiteralCS_1= ruleTypeLiteralCS
                    {
                    if ( state.backtracking==0 ) {

                      	  /* */

                    }
                    if ( state.backtracking==0 ) {

                              newCompositeNode(grammarAccess.getTypeExpCSAccess().getTypeLiteralCSParserRuleCall_0_1());

                    }
                    pushFollow(FollowSets000.FOLLOW_58);
                    this_TypeLiteralCS_1=ruleTypeLiteralCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_TypeLiteralCS_1;
                              afterParserOrEnumRuleCall();

                    }

                    }
                    break;
                case 3 :
                    // InternalQVTbase.g:4961:2: this_CollectionPatternCS_2= ruleCollectionPatternCS
                    {
                    if ( state.backtracking==0 ) {

                      	  /* */

                    }
                    if ( state.backtracking==0 ) {

                              newCompositeNode(grammarAccess.getTypeExpCSAccess().getCollectionPatternCSParserRuleCall_0_2());

                    }
                    pushFollow(FollowSets000.FOLLOW_58);
                    this_CollectionPatternCS_2=ruleCollectionPatternCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_CollectionPatternCS_2;
                              afterParserOrEnumRuleCall();

                    }

                    }
                    break;

            }

            // InternalQVTbase.g:4972:2: ( (lv_ownedMultiplicity_3_0= ruleMultiplicityCS ) )?
            int alt117=2;
            int LA117_0 = input.LA(1);

            if ( (LA117_0==108) ) {
                alt117=1;
            }
            switch (alt117) {
                case 1 :
                    // InternalQVTbase.g:4973:1: (lv_ownedMultiplicity_3_0= ruleMultiplicityCS )
                    {
                    // InternalQVTbase.g:4973:1: (lv_ownedMultiplicity_3_0= ruleMultiplicityCS )
                    // InternalQVTbase.g:4974:3: lv_ownedMultiplicity_3_0= ruleMultiplicityCS
                    {
                    if ( state.backtracking==0 ) {

                      	        newCompositeNode(grammarAccess.getTypeExpCSAccess().getOwnedMultiplicityMultiplicityCSParserRuleCall_1_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_ownedMultiplicity_3_0=ruleMultiplicityCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTypeExpCSRule());
                      	        }
                             		set(
                             			current,
                             			"ownedMultiplicity",
                              		lv_ownedMultiplicity_3_0,
                              		"org.eclipse.ocl.xtext.base.Base.MultiplicityCS");
                      	        afterParserOrEnumRuleCall();

                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypeExpCS"


    // $ANTLR start "entryRuleExpCS"
    // InternalQVTbase.g:4998:1: entryRuleExpCS returns [EObject current=null] : iv_ruleExpCS= ruleExpCS EOF ;
    public final EObject entryRuleExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpCS = null;


        try {
            // InternalQVTbase.g:4999:2: (iv_ruleExpCS= ruleExpCS EOF )
            // InternalQVTbase.g:5000:2: iv_ruleExpCS= ruleExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleExpCS=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpCS;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpCS"


    // $ANTLR start "ruleExpCS"
    // InternalQVTbase.g:5007:1: ruleExpCS returns [EObject current=null] : ( (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? ) | this_PrefixedLetExpCS_4= rulePrefixedLetExpCS ) ;
    public final EObject ruleExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_PrefixedPrimaryExpCS_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_ownedRight_3_0 = null;

        EObject this_PrefixedLetExpCS_4 = null;


         enterRule();

        try {
            // InternalQVTbase.g:5010:28: ( ( (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? ) | this_PrefixedLetExpCS_4= rulePrefixedLetExpCS ) )
            // InternalQVTbase.g:5011:1: ( (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? ) | this_PrefixedLetExpCS_4= rulePrefixedLetExpCS )
            {
            // InternalQVTbase.g:5011:1: ( (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? ) | this_PrefixedLetExpCS_4= rulePrefixedLetExpCS )
            int alt119=2;
            alt119 = dfa119.predict(input);
            switch (alt119) {
                case 1 :
                    // InternalQVTbase.g:5011:2: (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? )
                    {
                    // InternalQVTbase.g:5011:2: (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? )
                    // InternalQVTbase.g:5012:2: this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )?
                    {
                    if ( state.backtracking==0 ) {

                      	  /* */

                    }
                    if ( state.backtracking==0 ) {

                              newCompositeNode(grammarAccess.getExpCSAccess().getPrefixedPrimaryExpCSParserRuleCall_0_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_76);
                    this_PrefixedPrimaryExpCS_0=rulePrefixedPrimaryExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_PrefixedPrimaryExpCS_0;
                              afterParserOrEnumRuleCall();

                    }
                    // InternalQVTbase.g:5023:1: ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )?
                    int alt118=2;
                    int LA118_0 = input.LA(1);

                    if ( (LA118_0==21||LA118_0==65||(LA118_0>=67 && LA118_0<=82)) ) {
                        alt118=1;
                    }
                    switch (alt118) {
                        case 1 :
                            // InternalQVTbase.g:5023:2: () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) )
                            {
                            // InternalQVTbase.g:5023:2: ()
                            // InternalQVTbase.g:5024:2:
                            {
                            if ( state.backtracking==0 ) {

                              	  /* */

                            }
                            if ( state.backtracking==0 ) {

                                      current = forceCreateModelElementAndSet(
                                          grammarAccess.getExpCSAccess().getInfixExpCSOwnedLeftAction_0_1_0(),
                                          current);

                            }

                            }

                            // InternalQVTbase.g:5032:2: ( (lv_name_2_0= ruleBinaryOperatorName ) )
                            // InternalQVTbase.g:5033:1: (lv_name_2_0= ruleBinaryOperatorName )
                            {
                            // InternalQVTbase.g:5033:1: (lv_name_2_0= ruleBinaryOperatorName )
                            // InternalQVTbase.g:5034:3: lv_name_2_0= ruleBinaryOperatorName
                            {
                            if ( state.backtracking==0 ) {

                              	        newCompositeNode(grammarAccess.getExpCSAccess().getNameBinaryOperatorNameParserRuleCall_0_1_1_0());

                            }
                            pushFollow(FollowSets000.FOLLOW_69);
                            lv_name_2_0=ruleBinaryOperatorName();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getExpCSRule());
                              	        }
                                     		set(
                                     			current,
                                     			"name",
                                      		lv_name_2_0,
                                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.BinaryOperatorName");
                              	        afterParserOrEnumRuleCall();

                            }

                            }


                            }

                            // InternalQVTbase.g:5050:2: ( (lv_ownedRight_3_0= ruleExpCS ) )
                            // InternalQVTbase.g:5051:1: (lv_ownedRight_3_0= ruleExpCS )
                            {
                            // InternalQVTbase.g:5051:1: (lv_ownedRight_3_0= ruleExpCS )
                            // InternalQVTbase.g:5052:3: lv_ownedRight_3_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {

                              	        newCompositeNode(grammarAccess.getExpCSAccess().getOwnedRightExpCSParserRuleCall_0_1_2_0());

                            }
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_ownedRight_3_0=ruleExpCS();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getExpCSRule());
                              	        }
                                     		set(
                                     			current,
                                     			"ownedRight",
                                      		lv_ownedRight_3_0,
                                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
                              	        afterParserOrEnumRuleCall();

                            }

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalQVTbase.g:5070:2: this_PrefixedLetExpCS_4= rulePrefixedLetExpCS
                    {
                    if ( state.backtracking==0 ) {

                      	  /* */

                    }
                    if ( state.backtracking==0 ) {

                              newCompositeNode(grammarAccess.getExpCSAccess().getPrefixedLetExpCSParserRuleCall_1());

                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_PrefixedLetExpCS_4=rulePrefixedLetExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_PrefixedLetExpCS_4;
                              afterParserOrEnumRuleCall();

                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpCS"


    // $ANTLR start "entryRulePrefixedLetExpCS"
    // InternalQVTbase.g:5089:1: entryRulePrefixedLetExpCS returns [EObject current=null] : iv_rulePrefixedLetExpCS= rulePrefixedLetExpCS EOF ;
    public final EObject entryRulePrefixedLetExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrefixedLetExpCS = null;


        try {
            // InternalQVTbase.g:5090:2: (iv_rulePrefixedLetExpCS= rulePrefixedLetExpCS EOF )
            // InternalQVTbase.g:5091:2: iv_rulePrefixedLetExpCS= rulePrefixedLetExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrefixedLetExpCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePrefixedLetExpCS=rulePrefixedLetExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrefixedLetExpCS;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrefixedLetExpCS"


    // $ANTLR start "rulePrefixedLetExpCS"
    // InternalQVTbase.g:5098:1: rulePrefixedLetExpCS returns [EObject current=null] : ( ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedLetExpCS ) ) ) | this_LetExpCS_3= ruleLetExpCS ) ;
    public final EObject rulePrefixedLetExpCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_ownedRight_2_0 = null;

        EObject this_LetExpCS_3 = null;


         enterRule();

        try {
            // InternalQVTbase.g:5101:28: ( ( ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedLetExpCS ) ) ) | this_LetExpCS_3= ruleLetExpCS ) )
            // InternalQVTbase.g:5102:1: ( ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedLetExpCS ) ) ) | this_LetExpCS_3= ruleLetExpCS )
            {
            // InternalQVTbase.g:5102:1: ( ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedLetExpCS ) ) ) | this_LetExpCS_3= ruleLetExpCS )
            int alt120=2;
            int LA120_0 = input.LA(1);

            if ( ((LA120_0>=65 && LA120_0<=66)) ) {
                alt120=1;
            }
            else if ( (LA120_0==117) ) {
                alt120=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 120, 0, input);

                throw nvae;
            }
            switch (alt120) {
                case 1 :
                    // InternalQVTbase.g:5102:2: ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedLetExpCS ) ) )
                    {
                    // InternalQVTbase.g:5102:2: ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedLetExpCS ) ) )
                    // InternalQVTbase.g:5102:3: () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedLetExpCS ) )
                    {
                    // InternalQVTbase.g:5102:3: ()
                    // InternalQVTbase.g:5103:2:
                    {
                    if ( state.backtracking==0 ) {

                      	  /* */

                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getPrefixedLetExpCSAccess().getPrefixExpCSAction_0_0(),
                                  current);

                    }

                    }

                    // InternalQVTbase.g:5111:2: ( (lv_name_1_0= ruleUnaryOperatorName ) )
                    // InternalQVTbase.g:5112:1: (lv_name_1_0= ruleUnaryOperatorName )
                    {
                    // InternalQVTbase.g:5112:1: (lv_name_1_0= ruleUnaryOperatorName )
                    // InternalQVTbase.g:5113:3: lv_name_1_0= ruleUnaryOperatorName
                    {
                    if ( state.backtracking==0 ) {

                      	        newCompositeNode(grammarAccess.getPrefixedLetExpCSAccess().getNameUnaryOperatorNameParserRuleCall_0_1_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_69);
                    lv_name_1_0=ruleUnaryOperatorName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPrefixedLetExpCSRule());
                      	        }
                             		set(
                             			current,
                             			"name",
                              		lv_name_1_0,
                              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.UnaryOperatorName");
                      	        afterParserOrEnumRuleCall();

                    }

                    }


                    }

                    // InternalQVTbase.g:5129:2: ( (lv_ownedRight_2_0= rulePrefixedLetExpCS ) )
                    // InternalQVTbase.g:5130:1: (lv_ownedRight_2_0= rulePrefixedLetExpCS )
                    {
                    // InternalQVTbase.g:5130:1: (lv_ownedRight_2_0= rulePrefixedLetExpCS )
                    // InternalQVTbase.g:5131:3: lv_ownedRight_2_0= rulePrefixedLetExpCS
                    {
                    if ( state.backtracking==0 ) {

                      	        newCompositeNode(grammarAccess.getPrefixedLetExpCSAccess().getOwnedRightPrefixedLetExpCSParserRuleCall_0_2_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_ownedRight_2_0=rulePrefixedLetExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPrefixedLetExpCSRule());
                      	        }
                             		set(
                             			current,
                             			"ownedRight",
                              		lv_ownedRight_2_0,
                              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.PrefixedLetExpCS");
                      	        afterParserOrEnumRuleCall();

                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalQVTbase.g:5149:2: this_LetExpCS_3= ruleLetExpCS
                    {
                    if ( state.backtracking==0 ) {

                      	  /* */

                    }
                    if ( state.backtracking==0 ) {

                              newCompositeNode(grammarAccess.getPrefixedLetExpCSAccess().getLetExpCSParserRuleCall_1());

                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_LetExpCS_3=ruleLetExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_LetExpCS_3;
                              afterParserOrEnumRuleCall();

                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrefixedLetExpCS"


    // $ANTLR start "entryRulePrefixedPrimaryExpCS"
    // InternalQVTbase.g:5168:1: entryRulePrefixedPrimaryExpCS returns [EObject current=null] : iv_rulePrefixedPrimaryExpCS= rulePrefixedPrimaryExpCS EOF ;
    public final EObject entryRulePrefixedPrimaryExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrefixedPrimaryExpCS = null;


        try {
            // InternalQVTbase.g:5169:2: (iv_rulePrefixedPrimaryExpCS= rulePrefixedPrimaryExpCS EOF )
            // InternalQVTbase.g:5170:2: iv_rulePrefixedPrimaryExpCS= rulePrefixedPrimaryExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrefixedPrimaryExpCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePrefixedPrimaryExpCS=rulePrefixedPrimaryExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrefixedPrimaryExpCS;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrefixedPrimaryExpCS"


    // $ANTLR start "rulePrefixedPrimaryExpCS"
    // InternalQVTbase.g:5177:1: rulePrefixedPrimaryExpCS returns [EObject current=null] : ( ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS ) ) ) | this_PrimaryExpCS_3= rulePrimaryExpCS ) ;
    public final EObject rulePrefixedPrimaryExpCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_ownedRight_2_0 = null;

        EObject this_PrimaryExpCS_3 = null;


         enterRule();

        try {
            // InternalQVTbase.g:5180:28: ( ( ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS ) ) ) | this_PrimaryExpCS_3= rulePrimaryExpCS ) )
            // InternalQVTbase.g:5181:1: ( ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS ) ) ) | this_PrimaryExpCS_3= rulePrimaryExpCS )
            {
            // InternalQVTbase.g:5181:1: ( ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS ) ) ) | this_PrimaryExpCS_3= rulePrimaryExpCS )
            int alt121=2;
            int LA121_0 = input.LA(1);

            if ( ((LA121_0>=65 && LA121_0<=66)) ) {
                alt121=1;
            }
            else if ( (LA121_0==RULE_SINGLE_QUOTED_STRING||(LA121_0>=RULE_INT && LA121_0<=RULE_ESCAPED_ID)||LA121_0==51||LA121_0==67||(LA121_0>=83 && LA121_0<=97)||LA121_0==100||(LA121_0>=102 && LA121_0<=105)||LA121_0==112||LA121_0==118) ) {
                alt121=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 121, 0, input);

                throw nvae;
            }
            switch (alt121) {
                case 1 :
                    // InternalQVTbase.g:5181:2: ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS ) ) )
                    {
                    // InternalQVTbase.g:5181:2: ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS ) ) )
                    // InternalQVTbase.g:5181:3: () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS ) )
                    {
                    // InternalQVTbase.g:5181:3: ()
                    // InternalQVTbase.g:5182:2:
                    {
                    if ( state.backtracking==0 ) {

                      	  /* */

                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getPrefixedPrimaryExpCSAccess().getPrefixExpCSAction_0_0(),
                                  current);

                    }

                    }

                    // InternalQVTbase.g:5190:2: ( (lv_name_1_0= ruleUnaryOperatorName ) )
                    // InternalQVTbase.g:5191:1: (lv_name_1_0= ruleUnaryOperatorName )
                    {
                    // InternalQVTbase.g:5191:1: (lv_name_1_0= ruleUnaryOperatorName )
                    // InternalQVTbase.g:5192:3: lv_name_1_0= ruleUnaryOperatorName
                    {
                    if ( state.backtracking==0 ) {

                      	        newCompositeNode(grammarAccess.getPrefixedPrimaryExpCSAccess().getNameUnaryOperatorNameParserRuleCall_0_1_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_77);
                    lv_name_1_0=ruleUnaryOperatorName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPrefixedPrimaryExpCSRule());
                      	        }
                             		set(
                             			current,
                             			"name",
                              		lv_name_1_0,
                              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.UnaryOperatorName");
                      	        afterParserOrEnumRuleCall();

                    }

                    }


                    }

                    // InternalQVTbase.g:5208:2: ( (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS ) )
                    // InternalQVTbase.g:5209:1: (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS )
                    {
                    // InternalQVTbase.g:5209:1: (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS )
                    // InternalQVTbase.g:5210:3: lv_ownedRight_2_0= rulePrefixedPrimaryExpCS
                    {
                    if ( state.backtracking==0 ) {

                      	        newCompositeNode(grammarAccess.getPrefixedPrimaryExpCSAccess().getOwnedRightPrefixedPrimaryExpCSParserRuleCall_0_2_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_ownedRight_2_0=rulePrefixedPrimaryExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPrefixedPrimaryExpCSRule());
                      	        }
                             		set(
                             			current,
                             			"ownedRight",
                              		lv_ownedRight_2_0,
                              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.PrefixedPrimaryExpCS");
                      	        afterParserOrEnumRuleCall();

                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalQVTbase.g:5228:2: this_PrimaryExpCS_3= rulePrimaryExpCS
                    {
                    if ( state.backtracking==0 ) {

                      	  /* */

                    }
                    if ( state.backtracking==0 ) {

                              newCompositeNode(grammarAccess.getPrefixedPrimaryExpCSAccess().getPrimaryExpCSParserRuleCall_1());

                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_PrimaryExpCS_3=rulePrimaryExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_PrimaryExpCS_3;
                              afterParserOrEnumRuleCall();

                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrefixedPrimaryExpCS"


    // $ANTLR start "entryRulePrimaryExpCS"
    // InternalQVTbase.g:5247:1: entryRulePrimaryExpCS returns [EObject current=null] : iv_rulePrimaryExpCS= rulePrimaryExpCS EOF ;
    public final EObject entryRulePrimaryExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpCS = null;


        try {
            // InternalQVTbase.g:5248:2: (iv_rulePrimaryExpCS= rulePrimaryExpCS EOF )
            // InternalQVTbase.g:5249:2: iv_rulePrimaryExpCS= rulePrimaryExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimaryExpCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePrimaryExpCS=rulePrimaryExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimaryExpCS;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrimaryExpCS"


    // $ANTLR start "rulePrimaryExpCS"
    // InternalQVTbase.g:5256:1: rulePrimaryExpCS returns [EObject current=null] : (this_NestedExpCS_0= ruleNestedExpCS | this_IfExpCS_1= ruleIfExpCS | this_SelfExpCS_2= ruleSelfExpCS | this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS | this_MapLiteralExpCS_5= ruleMapLiteralExpCS | this_CollectionLiteralExpCS_6= ruleCollectionLiteralExpCS | this_LambdaLiteralExpCS_7= ruleLambdaLiteralExpCS | this_TypeLiteralExpCS_8= ruleTypeLiteralExpCS | this_NameExpCS_9= ruleNameExpCS ) ;
    public final EObject rulePrimaryExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_NestedExpCS_0 = null;

        EObject this_IfExpCS_1 = null;

        EObject this_SelfExpCS_2 = null;

        EObject this_PrimitiveLiteralExpCS_3 = null;

        EObject this_TupleLiteralExpCS_4 = null;

        EObject this_MapLiteralExpCS_5 = null;

        EObject this_CollectionLiteralExpCS_6 = null;

        EObject this_LambdaLiteralExpCS_7 = null;

        EObject this_TypeLiteralExpCS_8 = null;

        EObject this_NameExpCS_9 = null;


         enterRule();

        try {
            // InternalQVTbase.g:5259:28: ( (this_NestedExpCS_0= ruleNestedExpCS | this_IfExpCS_1= ruleIfExpCS | this_SelfExpCS_2= ruleSelfExpCS | this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS | this_MapLiteralExpCS_5= ruleMapLiteralExpCS | this_CollectionLiteralExpCS_6= ruleCollectionLiteralExpCS | this_LambdaLiteralExpCS_7= ruleLambdaLiteralExpCS | this_TypeLiteralExpCS_8= ruleTypeLiteralExpCS | this_NameExpCS_9= ruleNameExpCS ) )
            // InternalQVTbase.g:5260:1: (this_NestedExpCS_0= ruleNestedExpCS | this_IfExpCS_1= ruleIfExpCS | this_SelfExpCS_2= ruleSelfExpCS | this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS | this_MapLiteralExpCS_5= ruleMapLiteralExpCS | this_CollectionLiteralExpCS_6= ruleCollectionLiteralExpCS | this_LambdaLiteralExpCS_7= ruleLambdaLiteralExpCS | this_TypeLiteralExpCS_8= ruleTypeLiteralExpCS | this_NameExpCS_9= ruleNameExpCS )
            {
            // InternalQVTbase.g:5260:1: (this_NestedExpCS_0= ruleNestedExpCS | this_IfExpCS_1= ruleIfExpCS | this_SelfExpCS_2= ruleSelfExpCS | this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS | this_MapLiteralExpCS_5= ruleMapLiteralExpCS | this_CollectionLiteralExpCS_6= ruleCollectionLiteralExpCS | this_LambdaLiteralExpCS_7= ruleLambdaLiteralExpCS | this_TypeLiteralExpCS_8= ruleTypeLiteralExpCS | this_NameExpCS_9= ruleNameExpCS )
            int alt122=10;
            alt122 = dfa122.predict(input);
            switch (alt122) {
                case 1 :
                    // InternalQVTbase.g:5261:2: this_NestedExpCS_0= ruleNestedExpCS
                    {
                    if ( state.backtracking==0 ) {

                      	  /* */

                    }
                    if ( state.backtracking==0 ) {

                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getNestedExpCSParserRuleCall_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_NestedExpCS_0=ruleNestedExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_NestedExpCS_0;
                              afterParserOrEnumRuleCall();

                    }

                    }
                    break;
                case 2 :
                    // InternalQVTbase.g:5274:2: this_IfExpCS_1= ruleIfExpCS
                    {
                    if ( state.backtracking==0 ) {

                      	  /* */

                    }
                    if ( state.backtracking==0 ) {

                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getIfExpCSParserRuleCall_1());

                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_IfExpCS_1=ruleIfExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_IfExpCS_1;
                              afterParserOrEnumRuleCall();

                    }

                    }
                    break;
                case 3 :
                    // InternalQVTbase.g:5287:2: this_SelfExpCS_2= ruleSelfExpCS
                    {
                    if ( state.backtracking==0 ) {

                      	  /* */

                    }
                    if ( state.backtracking==0 ) {

                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getSelfExpCSParserRuleCall_2());

                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_SelfExpCS_2=ruleSelfExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_SelfExpCS_2;
                              afterParserOrEnumRuleCall();

                    }

                    }
                    break;
                case 4 :
                    // InternalQVTbase.g:5300:2: this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {

                      	  /* */

                    }
                    if ( state.backtracking==0 ) {

                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getPrimitiveLiteralExpCSParserRuleCall_3());

                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_PrimitiveLiteralExpCS_3=rulePrimitiveLiteralExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_PrimitiveLiteralExpCS_3;
                              afterParserOrEnumRuleCall();

                    }

                    }
                    break;
                case 5 :
                    // InternalQVTbase.g:5313:2: this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {

                      	  /* */

                    }
                    if ( state.backtracking==0 ) {

                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getTupleLiteralExpCSParserRuleCall_4());

                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_TupleLiteralExpCS_4=ruleTupleLiteralExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_TupleLiteralExpCS_4;
                              afterParserOrEnumRuleCall();

                    }

                    }
                    break;
                case 6 :
                    // InternalQVTbase.g:5326:2: this_MapLiteralExpCS_5= ruleMapLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {

                      	  /* */

                    }
                    if ( state.backtracking==0 ) {

                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getMapLiteralExpCSParserRuleCall_5());

                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_MapLiteralExpCS_5=ruleMapLiteralExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_MapLiteralExpCS_5;
                              afterParserOrEnumRuleCall();

                    }

                    }
                    break;
                case 7 :
                    // InternalQVTbase.g:5339:2: this_CollectionLiteralExpCS_6= ruleCollectionLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {

                      	  /* */

                    }
                    if ( state.backtracking==0 ) {

                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getCollectionLiteralExpCSParserRuleCall_6());

                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_CollectionLiteralExpCS_6=ruleCollectionLiteralExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_CollectionLiteralExpCS_6;
                              afterParserOrEnumRuleCall();

                    }

                    }
                    break;
                case 8 :
                    // InternalQVTbase.g:5352:2: this_LambdaLiteralExpCS_7= ruleLambdaLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {

                      	  /* */

                    }
                    if ( state.backtracking==0 ) {

                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getLambdaLiteralExpCSParserRuleCall_7());

                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_LambdaLiteralExpCS_7=ruleLambdaLiteralExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_LambdaLiteralExpCS_7;
                              afterParserOrEnumRuleCall();

                    }

                    }
                    break;
                case 9 :
                    // InternalQVTbase.g:5365:2: this_TypeLiteralExpCS_8= ruleTypeLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {

                      	  /* */

                    }
                    if ( state.backtracking==0 ) {

                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getTypeLiteralExpCSParserRuleCall_8());

                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_TypeLiteralExpCS_8=ruleTypeLiteralExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_TypeLiteralExpCS_8;
                              afterParserOrEnumRuleCall();

                    }

                    }
                    break;
                case 10 :
                    // InternalQVTbase.g:5378:2: this_NameExpCS_9= ruleNameExpCS
                    {
                    if ( state.backtracking==0 ) {

                      	  /* */

                    }
                    if ( state.backtracking==0 ) {

                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getNameExpCSParserRuleCall_9());

                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_NameExpCS_9=ruleNameExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_NameExpCS_9;
                              afterParserOrEnumRuleCall();

                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrimaryExpCS"


    // $ANTLR start "entryRuleNameExpCS"
    // InternalQVTbase.g:5397:1: entryRuleNameExpCS returns [EObject current=null] : iv_ruleNameExpCS= ruleNameExpCS EOF ;
    public final EObject entryRuleNameExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNameExpCS = null;


        try {
            // InternalQVTbase.g:5398:2: (iv_ruleNameExpCS= ruleNameExpCS EOF )
            // InternalQVTbase.g:5399:2: iv_ruleNameExpCS= ruleNameExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNameExpCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNameExpCS=ruleNameExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNameExpCS;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNameExpCS"


    // $ANTLR start "ruleNameExpCS"
    // InternalQVTbase.g:5406:1: ruleNameExpCS returns [EObject current=null] : ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( (lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS ) )* ( (lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS ) )? ( (lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS ) )? ( ( (lv_isPre_4_0= '@' ) ) otherlv_5= 'pre' )? ) ;
    public final EObject ruleNameExpCS() throws RecognitionException {
        EObject current = null;

        Token lv_isPre_4_0=null;
        Token otherlv_5=null;
        EObject lv_ownedPathName_0_0 = null;

        EObject lv_ownedSquareBracketedClauses_1_0 = null;

        EObject lv_ownedRoundBracketedClause_2_0 = null;

        EObject lv_ownedCurlyBracketedClause_3_0 = null;


         enterRule();

        try {
            // InternalQVTbase.g:5409:28: ( ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( (lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS ) )* ( (lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS ) )? ( (lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS ) )? ( ( (lv_isPre_4_0= '@' ) ) otherlv_5= 'pre' )? ) )
            // InternalQVTbase.g:5410:1: ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( (lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS ) )* ( (lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS ) )? ( (lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS ) )? ( ( (lv_isPre_4_0= '@' ) ) otherlv_5= 'pre' )? )
            {
            // InternalQVTbase.g:5410:1: ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( (lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS ) )* ( (lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS ) )? ( (lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS ) )? ( ( (lv_isPre_4_0= '@' ) ) otherlv_5= 'pre' )? )
            // InternalQVTbase.g:5410:2: ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( (lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS ) )* ( (lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS ) )? ( (lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS ) )? ( ( (lv_isPre_4_0= '@' ) ) otherlv_5= 'pre' )?
            {
            // InternalQVTbase.g:5410:2: ( (lv_ownedPathName_0_0= rulePathNameCS ) )
            // InternalQVTbase.g:5411:1: (lv_ownedPathName_0_0= rulePathNameCS )
            {
            // InternalQVTbase.g:5411:1: (lv_ownedPathName_0_0= rulePathNameCS )
            // InternalQVTbase.g:5412:3: lv_ownedPathName_0_0= rulePathNameCS
            {
            if ( state.backtracking==0 ) {

              	        newCompositeNode(grammarAccess.getNameExpCSAccess().getOwnedPathNamePathNameCSParserRuleCall_0_0());

            }
            pushFollow(FollowSets000.FOLLOW_78);
            lv_ownedPathName_0_0=rulePathNameCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getNameExpCSRule());
              	        }
                     		set(
                     			current,
                     			"ownedPathName",
                      		lv_ownedPathName_0_0,
                      		"org.eclipse.ocl.xtext.base.Base.PathNameCS");
              	        afterParserOrEnumRuleCall();

            }

            }


            }

            // InternalQVTbase.g:5428:2: ( (lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS ) )*
            loop123:
            do {
                int alt123=2;
                int LA123_0 = input.LA(1);

                if ( (LA123_0==108) ) {
                    alt123=1;
                }


                switch (alt123) {
            	case 1 :
            	    // InternalQVTbase.g:5429:1: (lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS )
            	    {
            	    // InternalQVTbase.g:5429:1: (lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS )
            	    // InternalQVTbase.g:5430:3: lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS
            	    {
            	    if ( state.backtracking==0 ) {

            	      	        newCompositeNode(grammarAccess.getNameExpCSAccess().getOwnedSquareBracketedClausesSquareBracketedClauseCSParserRuleCall_1_0());

            	    }
            	    pushFollow(FollowSets000.FOLLOW_78);
            	    lv_ownedSquareBracketedClauses_1_0=ruleSquareBracketedClauseCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getNameExpCSRule());
            	      	        }
            	             		add(
            	             			current,
            	             			"ownedSquareBracketedClauses",
            	              		lv_ownedSquareBracketedClauses_1_0,
            	              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.SquareBracketedClauseCS");
            	      	        afterParserOrEnumRuleCall();

            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop123;
                }
            } while (true);

            // InternalQVTbase.g:5446:3: ( (lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS ) )?
            int alt124=2;
            int LA124_0 = input.LA(1);

            if ( (LA124_0==51) ) {
                alt124=1;
            }
            switch (alt124) {
                case 1 :
                    // InternalQVTbase.g:5447:1: (lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS )
                    {
                    // InternalQVTbase.g:5447:1: (lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS )
                    // InternalQVTbase.g:5448:3: lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS
                    {
                    if ( state.backtracking==0 ) {

                      	        newCompositeNode(grammarAccess.getNameExpCSAccess().getOwnedRoundBracketedClauseRoundBracketedClauseCSParserRuleCall_2_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_79);
                    lv_ownedRoundBracketedClause_2_0=ruleRoundBracketedClauseCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getNameExpCSRule());
                      	        }
                             		set(
                             			current,
                             			"ownedRoundBracketedClause",
                              		lv_ownedRoundBracketedClause_2_0,
                              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.RoundBracketedClauseCS");
                      	        afterParserOrEnumRuleCall();

                    }

                    }


                    }
                    break;

            }

            // InternalQVTbase.g:5464:3: ( (lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS ) )?
            int alt125=2;
            int LA125_0 = input.LA(1);

            if ( (LA125_0==22) ) {
                alt125=1;
            }
            switch (alt125) {
                case 1 :
                    // InternalQVTbase.g:5465:1: (lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS )
                    {
                    // InternalQVTbase.g:5465:1: (lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS )
                    // InternalQVTbase.g:5466:3: lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS
                    {
                    if ( state.backtracking==0 ) {

                      	        newCompositeNode(grammarAccess.getNameExpCSAccess().getOwnedCurlyBracketedClauseCurlyBracketedClauseCSParserRuleCall_3_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_80);
                    lv_ownedCurlyBracketedClause_3_0=ruleCurlyBracketedClauseCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getNameExpCSRule());
                      	        }
                             		set(
                             			current,
                             			"ownedCurlyBracketedClause",
                              		lv_ownedCurlyBracketedClause_3_0,
                              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.CurlyBracketedClauseCS");
                      	        afterParserOrEnumRuleCall();

                    }

                    }


                    }
                    break;

            }

            // InternalQVTbase.g:5482:3: ( ( (lv_isPre_4_0= '@' ) ) otherlv_5= 'pre' )?
            int alt126=2;
            int LA126_0 = input.LA(1);

            if ( (LA126_0==106) ) {
                alt126=1;
            }
            switch (alt126) {
                case 1 :
                    // InternalQVTbase.g:5482:4: ( (lv_isPre_4_0= '@' ) ) otherlv_5= 'pre'
                    {
                    // InternalQVTbase.g:5482:4: ( (lv_isPre_4_0= '@' ) )
                    // InternalQVTbase.g:5483:1: (lv_isPre_4_0= '@' )
                    {
                    // InternalQVTbase.g:5483:1: (lv_isPre_4_0= '@' )
                    // InternalQVTbase.g:5484:3: lv_isPre_4_0= '@'
                    {
                    lv_isPre_4_0=(Token)match(input,106,FollowSets000.FOLLOW_81); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_isPre_4_0, grammarAccess.getNameExpCSAccess().getIsPreCommercialAtKeyword_4_0_0());

                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getNameExpCSRule());
                      	        }
                             		setWithLastConsumed(current, "isPre", true, "@");

                    }

                    }


                    }

                    otherlv_5=(Token)match(input,107,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getNameExpCSAccess().getPreKeyword_4_1());

                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNameExpCS"


    // $ANTLR start "entryRuleCurlyBracketedClauseCS"
    // InternalQVTbase.g:5509:1: entryRuleCurlyBracketedClauseCS returns [EObject current=null] : iv_ruleCurlyBracketedClauseCS= ruleCurlyBracketedClauseCS EOF ;
    public final EObject entryRuleCurlyBracketedClauseCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCurlyBracketedClauseCS = null;


        try {
            // InternalQVTbase.g:5510:2: (iv_ruleCurlyBracketedClauseCS= ruleCurlyBracketedClauseCS EOF )
            // InternalQVTbase.g:5511:2: iv_ruleCurlyBracketedClauseCS= ruleCurlyBracketedClauseCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCurlyBracketedClauseCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCurlyBracketedClauseCS=ruleCurlyBracketedClauseCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCurlyBracketedClauseCS;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCurlyBracketedClauseCS"


    // $ANTLR start "ruleCurlyBracketedClauseCS"
    // InternalQVTbase.g:5518:1: ruleCurlyBracketedClauseCS returns [EObject current=null] : ( () otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleShadowPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleShadowPartCS ) ) )* )? otherlv_5= '}' ) ;
    public final EObject ruleCurlyBracketedClauseCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_ownedParts_2_0 = null;

        EObject lv_ownedParts_4_0 = null;


         enterRule();

        try {
            // InternalQVTbase.g:5521:28: ( ( () otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleShadowPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleShadowPartCS ) ) )* )? otherlv_5= '}' ) )
            // InternalQVTbase.g:5522:1: ( () otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleShadowPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleShadowPartCS ) ) )* )? otherlv_5= '}' )
            {
            // InternalQVTbase.g:5522:1: ( () otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleShadowPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleShadowPartCS ) ) )* )? otherlv_5= '}' )
            // InternalQVTbase.g:5522:2: () otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleShadowPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleShadowPartCS ) ) )* )? otherlv_5= '}'
            {
            // InternalQVTbase.g:5522:2: ()
            // InternalQVTbase.g:5523:2:
            {
            if ( state.backtracking==0 ) {

              	  /* */

            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getCurlyBracketedClauseCSAccess().getCurlyBracketedClauseCSAction_0(),
                          current);

            }

            }

            otherlv_1=(Token)match(input,22,FollowSets000.FOLLOW_82); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getCurlyBracketedClauseCSAccess().getLeftCurlyBracketKeyword_1());

            }
            // InternalQVTbase.g:5535:1: ( ( (lv_ownedParts_2_0= ruleShadowPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleShadowPartCS ) ) )* )?
            int alt128=2;
            int LA128_0 = input.LA(1);

            if ( (LA128_0==RULE_SINGLE_QUOTED_STRING||(LA128_0>=RULE_SIMPLE_ID && LA128_0<=RULE_ESCAPED_ID)) ) {
                alt128=1;
            }
            switch (alt128) {
                case 1 :
                    // InternalQVTbase.g:5535:2: ( (lv_ownedParts_2_0= ruleShadowPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleShadowPartCS ) ) )*
                    {
                    // InternalQVTbase.g:5535:2: ( (lv_ownedParts_2_0= ruleShadowPartCS ) )
                    // InternalQVTbase.g:5536:1: (lv_ownedParts_2_0= ruleShadowPartCS )
                    {
                    // InternalQVTbase.g:5536:1: (lv_ownedParts_2_0= ruleShadowPartCS )
                    // InternalQVTbase.g:5537:3: lv_ownedParts_2_0= ruleShadowPartCS
                    {
                    if ( state.backtracking==0 ) {

                      	        newCompositeNode(grammarAccess.getCurlyBracketedClauseCSAccess().getOwnedPartsShadowPartCSParserRuleCall_2_0_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_66);
                    lv_ownedParts_2_0=ruleShadowPartCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getCurlyBracketedClauseCSRule());
                      	        }
                             		add(
                             			current,
                             			"ownedParts",
                              		lv_ownedParts_2_0,
                              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ShadowPartCS");
                      	        afterParserOrEnumRuleCall();

                    }

                    }


                    }

                    // InternalQVTbase.g:5553:2: (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleShadowPartCS ) ) )*
                    loop127:
                    do {
                        int alt127=2;
                        int LA127_0 = input.LA(1);

                        if ( (LA127_0==39) ) {
                            alt127=1;
                        }


                        switch (alt127) {
                    	case 1 :
                    	    // InternalQVTbase.g:5553:4: otherlv_3= ',' ( (lv_ownedParts_4_0= ruleShadowPartCS ) )
                    	    {
                    	    otherlv_3=(Token)match(input,39,FollowSets000.FOLLOW_83); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getCurlyBracketedClauseCSAccess().getCommaKeyword_2_1_0());

                    	    }
                    	    // InternalQVTbase.g:5557:1: ( (lv_ownedParts_4_0= ruleShadowPartCS ) )
                    	    // InternalQVTbase.g:5558:1: (lv_ownedParts_4_0= ruleShadowPartCS )
                    	    {
                    	    // InternalQVTbase.g:5558:1: (lv_ownedParts_4_0= ruleShadowPartCS )
                    	    // InternalQVTbase.g:5559:3: lv_ownedParts_4_0= ruleShadowPartCS
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      	        newCompositeNode(grammarAccess.getCurlyBracketedClauseCSAccess().getOwnedPartsShadowPartCSParserRuleCall_2_1_1_0());

                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_66);
                    	    lv_ownedParts_4_0=ruleShadowPartCS();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getCurlyBracketedClauseCSRule());
                    	      	        }
                    	             		add(
                    	             			current,
                    	             			"ownedParts",
                    	              		lv_ownedParts_4_0,
                    	              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ShadowPartCS");
                    	      	        afterParserOrEnumRuleCall();

                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop127;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,40,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getCurlyBracketedClauseCSAccess().getRightCurlyBracketKeyword_3());

            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCurlyBracketedClauseCS"


    // $ANTLR start "entryRuleRoundBracketedClauseCS"
    // InternalQVTbase.g:5587:1: entryRuleRoundBracketedClauseCS returns [EObject current=null] : iv_ruleRoundBracketedClauseCS= ruleRoundBracketedClauseCS EOF ;
    public final EObject entryRuleRoundBracketedClauseCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRoundBracketedClauseCS = null;


        try {
            // InternalQVTbase.g:5588:2: (iv_ruleRoundBracketedClauseCS= ruleRoundBracketedClauseCS EOF )
            // InternalQVTbase.g:5589:2: iv_ruleRoundBracketedClauseCS= ruleRoundBracketedClauseCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRoundBracketedClauseCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleRoundBracketedClauseCS=ruleRoundBracketedClauseCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRoundBracketedClauseCS;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRoundBracketedClauseCS"


    // $ANTLR start "ruleRoundBracketedClauseCS"
    // InternalQVTbase.g:5596:1: ruleRoundBracketedClauseCS returns [EObject current=null] : ( () otherlv_1= '(' ( ( (lv_ownedArguments_2_0= ruleNavigatingArgCS ) ) ( (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )* )* )? otherlv_8= ')' ) ;
    public final EObject ruleRoundBracketedClauseCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_8=null;
        EObject lv_ownedArguments_2_0 = null;

        EObject lv_ownedArguments_3_0 = null;

        EObject lv_ownedArguments_4_0 = null;

        EObject lv_ownedArguments_5_0 = null;

        EObject lv_ownedArguments_6_0 = null;

        EObject lv_ownedArguments_7_0 = null;


         enterRule();

        try {
            // InternalQVTbase.g:5599:28: ( ( () otherlv_1= '(' ( ( (lv_ownedArguments_2_0= ruleNavigatingArgCS ) ) ( (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )* )* )? otherlv_8= ')' ) )
            // InternalQVTbase.g:5600:1: ( () otherlv_1= '(' ( ( (lv_ownedArguments_2_0= ruleNavigatingArgCS ) ) ( (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )* )* )? otherlv_8= ')' )
            {
            // InternalQVTbase.g:5600:1: ( () otherlv_1= '(' ( ( (lv_ownedArguments_2_0= ruleNavigatingArgCS ) ) ( (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )* )* )? otherlv_8= ')' )
            // InternalQVTbase.g:5600:2: () otherlv_1= '(' ( ( (lv_ownedArguments_2_0= ruleNavigatingArgCS ) ) ( (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )* )* )? otherlv_8= ')'
            {
            // InternalQVTbase.g:5600:2: ()
            // InternalQVTbase.g:5601:2:
            {
            if ( state.backtracking==0 ) {

              	  /* */

            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getRoundBracketedClauseCSAccess().getRoundBracketedClauseCSAction_0(),
                          current);

            }

            }

            otherlv_1=(Token)match(input,51,FollowSets000.FOLLOW_84); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getRoundBracketedClauseCSAccess().getLeftParenthesisKeyword_1());

            }
            // InternalQVTbase.g:5613:1: ( ( (lv_ownedArguments_2_0= ruleNavigatingArgCS ) ) ( (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )* )* )?
            int alt134=2;
            int LA134_0 = input.LA(1);

            if ( (LA134_0==RULE_SINGLE_QUOTED_STRING||(LA134_0>=RULE_INT && LA134_0<=RULE_ESCAPED_ID)||LA134_0==20||LA134_0==51||(LA134_0>=65 && LA134_0<=67)||(LA134_0>=83 && LA134_0<=97)||LA134_0==100||(LA134_0>=102 && LA134_0<=105)||LA134_0==112||(LA134_0>=117 && LA134_0<=118)) ) {
                alt134=1;
            }
            switch (alt134) {
                case 1 :
                    // InternalQVTbase.g:5613:2: ( (lv_ownedArguments_2_0= ruleNavigatingArgCS ) ) ( (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )* )*
                    {
                    // InternalQVTbase.g:5613:2: ( (lv_ownedArguments_2_0= ruleNavigatingArgCS ) )
                    // InternalQVTbase.g:5614:1: (lv_ownedArguments_2_0= ruleNavigatingArgCS )
                    {
                    // InternalQVTbase.g:5614:1: (lv_ownedArguments_2_0= ruleNavigatingArgCS )
                    // InternalQVTbase.g:5615:3: lv_ownedArguments_2_0= ruleNavigatingArgCS
                    {
                    if ( state.backtracking==0 ) {

                      	        newCompositeNode(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingArgCSParserRuleCall_2_0_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_85);
                    lv_ownedArguments_2_0=ruleNavigatingArgCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getRoundBracketedClauseCSRule());
                      	        }
                             		add(
                             			current,
                             			"ownedArguments",
                              		lv_ownedArguments_2_0,
                              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.NavigatingArgCS");
                      	        afterParserOrEnumRuleCall();

                    }

                    }


                    }

                    // InternalQVTbase.g:5631:2: ( (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS ) )*
                    loop129:
                    do {
                        int alt129=2;
                        int LA129_0 = input.LA(1);

                        if ( (LA129_0==39) ) {
                            alt129=1;
                        }


                        switch (alt129) {
                    	case 1 :
                    	    // InternalQVTbase.g:5632:1: (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS )
                    	    {
                    	    // InternalQVTbase.g:5632:1: (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS )
                    	    // InternalQVTbase.g:5633:3: lv_ownedArguments_3_0= ruleNavigatingCommaArgCS
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      	        newCompositeNode(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingCommaArgCSParserRuleCall_2_1_0());

                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_85);
                    	    lv_ownedArguments_3_0=ruleNavigatingCommaArgCS();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getRoundBracketedClauseCSRule());
                    	      	        }
                    	             		add(
                    	             			current,
                    	             			"ownedArguments",
                    	              		lv_ownedArguments_3_0,
                    	              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.NavigatingCommaArgCS");
                    	      	        afterParserOrEnumRuleCall();

                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop129;
                        }
                    } while (true);

                    // InternalQVTbase.g:5649:3: ( ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )* )?
                    int alt131=2;
                    int LA131_0 = input.LA(1);

                    if ( (LA131_0==42) ) {
                        alt131=1;
                    }
                    switch (alt131) {
                        case 1 :
                            // InternalQVTbase.g:5649:4: ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )*
                            {
                            // InternalQVTbase.g:5649:4: ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) )
                            // InternalQVTbase.g:5650:1: (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS )
                            {
                            // InternalQVTbase.g:5650:1: (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS )
                            // InternalQVTbase.g:5651:3: lv_ownedArguments_4_0= ruleNavigatingSemiArgCS
                            {
                            if ( state.backtracking==0 ) {

                              	        newCompositeNode(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingSemiArgCSParserRuleCall_2_2_0_0());

                            }
                            pushFollow(FollowSets000.FOLLOW_86);
                            lv_ownedArguments_4_0=ruleNavigatingSemiArgCS();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getRoundBracketedClauseCSRule());
                              	        }
                                     		add(
                                     			current,
                                     			"ownedArguments",
                                      		lv_ownedArguments_4_0,
                                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.NavigatingSemiArgCS");
                              	        afterParserOrEnumRuleCall();

                            }

                            }


                            }

                            // InternalQVTbase.g:5667:2: ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )*
                            loop130:
                            do {
                                int alt130=2;
                                int LA130_0 = input.LA(1);

                                if ( (LA130_0==39) ) {
                                    alt130=1;
                                }


                                switch (alt130) {
                            	case 1 :
                            	    // InternalQVTbase.g:5668:1: (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS )
                            	    {
                            	    // InternalQVTbase.g:5668:1: (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS )
                            	    // InternalQVTbase.g:5669:3: lv_ownedArguments_5_0= ruleNavigatingCommaArgCS
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      	        newCompositeNode(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingCommaArgCSParserRuleCall_2_2_1_0());

                            	    }
                            	    pushFollow(FollowSets000.FOLLOW_86);
                            	    lv_ownedArguments_5_0=ruleNavigatingCommaArgCS();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getRoundBracketedClauseCSRule());
                            	      	        }
                            	             		add(
                            	             			current,
                            	             			"ownedArguments",
                            	              		lv_ownedArguments_5_0,
                            	              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.NavigatingCommaArgCS");
                            	      	        afterParserOrEnumRuleCall();

                            	    }

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop130;
                                }
                            } while (true);


                            }
                            break;

                    }

                    // InternalQVTbase.g:5685:5: ( ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )* )*
                    loop133:
                    do {
                        int alt133=2;
                        int LA133_0 = input.LA(1);

                        if ( (LA133_0==111) ) {
                            alt133=1;
                        }


                        switch (alt133) {
                    	case 1 :
                    	    // InternalQVTbase.g:5685:6: ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )*
                    	    {
                    	    // InternalQVTbase.g:5685:6: ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) )
                    	    // InternalQVTbase.g:5686:1: (lv_ownedArguments_6_0= ruleNavigatingBarArgCS )
                    	    {
                    	    // InternalQVTbase.g:5686:1: (lv_ownedArguments_6_0= ruleNavigatingBarArgCS )
                    	    // InternalQVTbase.g:5687:3: lv_ownedArguments_6_0= ruleNavigatingBarArgCS
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      	        newCompositeNode(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingBarArgCSParserRuleCall_2_3_0_0());

                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_86);
                    	    lv_ownedArguments_6_0=ruleNavigatingBarArgCS();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getRoundBracketedClauseCSRule());
                    	      	        }
                    	             		add(
                    	             			current,
                    	             			"ownedArguments",
                    	              		lv_ownedArguments_6_0,
                    	              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.NavigatingBarArgCS");
                    	      	        afterParserOrEnumRuleCall();

                    	    }

                    	    }


                    	    }

                    	    // InternalQVTbase.g:5703:2: ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )*
                    	    loop132:
                    	    do {
                    	        int alt132=2;
                    	        int LA132_0 = input.LA(1);

                    	        if ( (LA132_0==39) ) {
                    	            alt132=1;
                    	        }


                    	        switch (alt132) {
                    	    	case 1 :
                    	    	    // InternalQVTbase.g:5704:1: (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS )
                    	    	    {
                    	    	    // InternalQVTbase.g:5704:1: (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS )
                    	    	    // InternalQVTbase.g:5705:3: lv_ownedArguments_7_0= ruleNavigatingCommaArgCS
                    	    	    {
                    	    	    if ( state.backtracking==0 ) {

                    	    	      	        newCompositeNode(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingCommaArgCSParserRuleCall_2_3_1_0());

                    	    	    }
                    	    	    pushFollow(FollowSets000.FOLLOW_86);
                    	    	    lv_ownedArguments_7_0=ruleNavigatingCommaArgCS();

                    	    	    state._fsp--;
                    	    	    if (state.failed) return current;
                    	    	    if ( state.backtracking==0 ) {

                    	    	      	        if (current==null) {
                    	    	      	            current = createModelElementForParent(grammarAccess.getRoundBracketedClauseCSRule());
                    	    	      	        }
                    	    	             		add(
                    	    	             			current,
                    	    	             			"ownedArguments",
                    	    	              		lv_ownedArguments_7_0,
                    	    	              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.NavigatingCommaArgCS");
                    	    	      	        afterParserOrEnumRuleCall();

                    	    	    }

                    	    	    }


                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    break loop132;
                    	        }
                    	    } while (true);


                    	    }
                    	    break;

                    	default :
                    	    break loop133;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_8=(Token)match(input,52,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getRoundBracketedClauseCSAccess().getRightParenthesisKeyword_3());

            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRoundBracketedClauseCS"


    // $ANTLR start "entryRuleSquareBracketedClauseCS"
    // InternalQVTbase.g:5733:1: entryRuleSquareBracketedClauseCS returns [EObject current=null] : iv_ruleSquareBracketedClauseCS= ruleSquareBracketedClauseCS EOF ;
    public final EObject entryRuleSquareBracketedClauseCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSquareBracketedClauseCS = null;


        try {
            // InternalQVTbase.g:5734:2: (iv_ruleSquareBracketedClauseCS= ruleSquareBracketedClauseCS EOF )
            // InternalQVTbase.g:5735:2: iv_ruleSquareBracketedClauseCS= ruleSquareBracketedClauseCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSquareBracketedClauseCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSquareBracketedClauseCS=ruleSquareBracketedClauseCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSquareBracketedClauseCS;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSquareBracketedClauseCS"


    // $ANTLR start "ruleSquareBracketedClauseCS"
    // InternalQVTbase.g:5742:1: ruleSquareBracketedClauseCS returns [EObject current=null] : (otherlv_0= '[' ( (lv_ownedTerms_1_0= ruleExpCS ) ) (otherlv_2= ',' ( (lv_ownedTerms_3_0= ruleExpCS ) ) )* otherlv_4= ']' ) ;
    public final EObject ruleSquareBracketedClauseCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_ownedTerms_1_0 = null;

        EObject lv_ownedTerms_3_0 = null;


         enterRule();

        try {
            // InternalQVTbase.g:5745:28: ( (otherlv_0= '[' ( (lv_ownedTerms_1_0= ruleExpCS ) ) (otherlv_2= ',' ( (lv_ownedTerms_3_0= ruleExpCS ) ) )* otherlv_4= ']' ) )
            // InternalQVTbase.g:5746:1: (otherlv_0= '[' ( (lv_ownedTerms_1_0= ruleExpCS ) ) (otherlv_2= ',' ( (lv_ownedTerms_3_0= ruleExpCS ) ) )* otherlv_4= ']' )
            {
            // InternalQVTbase.g:5746:1: (otherlv_0= '[' ( (lv_ownedTerms_1_0= ruleExpCS ) ) (otherlv_2= ',' ( (lv_ownedTerms_3_0= ruleExpCS ) ) )* otherlv_4= ']' )
            // InternalQVTbase.g:5746:3: otherlv_0= '[' ( (lv_ownedTerms_1_0= ruleExpCS ) ) (otherlv_2= ',' ( (lv_ownedTerms_3_0= ruleExpCS ) ) )* otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,108,FollowSets000.FOLLOW_69); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getSquareBracketedClauseCSAccess().getLeftSquareBracketKeyword_0());

            }
            // InternalQVTbase.g:5750:1: ( (lv_ownedTerms_1_0= ruleExpCS ) )
            // InternalQVTbase.g:5751:1: (lv_ownedTerms_1_0= ruleExpCS )
            {
            // InternalQVTbase.g:5751:1: (lv_ownedTerms_1_0= ruleExpCS )
            // InternalQVTbase.g:5752:3: lv_ownedTerms_1_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {

              	        newCompositeNode(grammarAccess.getSquareBracketedClauseCSAccess().getOwnedTermsExpCSParserRuleCall_1_0());

            }
            pushFollow(FollowSets000.FOLLOW_87);
            lv_ownedTerms_1_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getSquareBracketedClauseCSRule());
              	        }
                     		add(
                     			current,
                     			"ownedTerms",
                      		lv_ownedTerms_1_0,
                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
              	        afterParserOrEnumRuleCall();

            }

            }


            }

            // InternalQVTbase.g:5768:2: (otherlv_2= ',' ( (lv_ownedTerms_3_0= ruleExpCS ) ) )*
            loop135:
            do {
                int alt135=2;
                int LA135_0 = input.LA(1);

                if ( (LA135_0==39) ) {
                    alt135=1;
                }


                switch (alt135) {
            	case 1 :
            	    // InternalQVTbase.g:5768:4: otherlv_2= ',' ( (lv_ownedTerms_3_0= ruleExpCS ) )
            	    {
            	    otherlv_2=(Token)match(input,39,FollowSets000.FOLLOW_69); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getSquareBracketedClauseCSAccess().getCommaKeyword_2_0());

            	    }
            	    // InternalQVTbase.g:5772:1: ( (lv_ownedTerms_3_0= ruleExpCS ) )
            	    // InternalQVTbase.g:5773:1: (lv_ownedTerms_3_0= ruleExpCS )
            	    {
            	    // InternalQVTbase.g:5773:1: (lv_ownedTerms_3_0= ruleExpCS )
            	    // InternalQVTbase.g:5774:3: lv_ownedTerms_3_0= ruleExpCS
            	    {
            	    if ( state.backtracking==0 ) {

            	      	        newCompositeNode(grammarAccess.getSquareBracketedClauseCSAccess().getOwnedTermsExpCSParserRuleCall_2_1_0());

            	    }
            	    pushFollow(FollowSets000.FOLLOW_87);
            	    lv_ownedTerms_3_0=ruleExpCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getSquareBracketedClauseCSRule());
            	      	        }
            	             		add(
            	             			current,
            	             			"ownedTerms",
            	              		lv_ownedTerms_3_0,
            	              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
            	      	        afterParserOrEnumRuleCall();

            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop135;
                }
            } while (true);

            otherlv_4=(Token)match(input,109,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getSquareBracketedClauseCSAccess().getRightSquareBracketKeyword_3());

            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSquareBracketedClauseCS"


    // $ANTLR start "entryRuleNavigatingArgCS"
    // InternalQVTbase.g:5802:1: entryRuleNavigatingArgCS returns [EObject current=null] : iv_ruleNavigatingArgCS= ruleNavigatingArgCS EOF ;
    public final EObject entryRuleNavigatingArgCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingArgCS = null;


        try {
            // InternalQVTbase.g:5803:2: (iv_ruleNavigatingArgCS= ruleNavigatingArgCS EOF )
            // InternalQVTbase.g:5804:2: iv_ruleNavigatingArgCS= ruleNavigatingArgCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingArgCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNavigatingArgCS=ruleNavigatingArgCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingArgCS;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNavigatingArgCS"


    // $ANTLR start "ruleNavigatingArgCS"
    // InternalQVTbase.g:5811:1: ruleNavigatingArgCS returns [EObject current=null] : ( ( ( (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS ) ) ( (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? ) | (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) ) )? ) | (otherlv_7= ':' ( (lv_ownedType_8_0= ruleTypeExpCS ) ) ) ) ;
    public final EObject ruleNavigatingArgCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_ownedNameExpression_0_0 = null;

        EObject lv_ownedType_2_0 = null;

        EObject lv_ownedInitExpression_4_0 = null;

        EObject lv_ownedInitExpression_6_0 = null;

        EObject lv_ownedType_8_0 = null;


         enterRule();

        try {
            // InternalQVTbase.g:5814:28: ( ( ( ( (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS ) ) ( (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? ) | (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) ) )? ) | (otherlv_7= ':' ( (lv_ownedType_8_0= ruleTypeExpCS ) ) ) ) )
            // InternalQVTbase.g:5815:1: ( ( ( (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS ) ) ( (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? ) | (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) ) )? ) | (otherlv_7= ':' ( (lv_ownedType_8_0= ruleTypeExpCS ) ) ) )
            {
            // InternalQVTbase.g:5815:1: ( ( ( (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS ) ) ( (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? ) | (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) ) )? ) | (otherlv_7= ':' ( (lv_ownedType_8_0= ruleTypeExpCS ) ) ) )
            int alt138=2;
            int LA138_0 = input.LA(1);

            if ( (LA138_0==RULE_SINGLE_QUOTED_STRING||(LA138_0>=RULE_INT && LA138_0<=RULE_ESCAPED_ID)||LA138_0==51||(LA138_0>=65 && LA138_0<=67)||(LA138_0>=83 && LA138_0<=97)||LA138_0==100||(LA138_0>=102 && LA138_0<=105)||LA138_0==112||(LA138_0>=117 && LA138_0<=118)) ) {
                alt138=1;
            }
            else if ( (LA138_0==20) ) {
                alt138=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 138, 0, input);

                throw nvae;
            }
            switch (alt138) {
                case 1 :
                    // InternalQVTbase.g:5815:2: ( ( (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS ) ) ( (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? ) | (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) ) )? )
                    {
                    // InternalQVTbase.g:5815:2: ( ( (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS ) ) ( (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? ) | (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) ) )? )
                    // InternalQVTbase.g:5815:3: ( (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS ) ) ( (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? ) | (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) ) )?
                    {
                    // InternalQVTbase.g:5815:3: ( (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS ) )
                    // InternalQVTbase.g:5816:1: (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS )
                    {
                    // InternalQVTbase.g:5816:1: (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS )
                    // InternalQVTbase.g:5817:3: lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS
                    {
                    if ( state.backtracking==0 ) {

                      	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedNameExpressionNavigatingArgExpCSParserRuleCall_0_0_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_88);
                    lv_ownedNameExpression_0_0=ruleNavigatingArgExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getNavigatingArgCSRule());
                      	        }
                             		set(
                             			current,
                             			"ownedNameExpression",
                              		lv_ownedNameExpression_0_0,
                              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.NavigatingArgExpCS");
                      	        afterParserOrEnumRuleCall();

                    }

                    }


                    }

                    // InternalQVTbase.g:5833:2: ( (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? ) | (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) ) )?
                    int alt137=3;
                    int LA137_0 = input.LA(1);

                    if ( (LA137_0==20) ) {
                        alt137=1;
                    }
                    else if ( (LA137_0==110) ) {
                        alt137=2;
                    }
                    switch (alt137) {
                        case 1 :
                            // InternalQVTbase.g:5833:3: (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? )
                            {
                            // InternalQVTbase.g:5833:3: (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? )
                            // InternalQVTbase.g:5833:5: otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )?
                            {
                            otherlv_1=(Token)match(input,20,FollowSets000.FOLLOW_61); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_1, grammarAccess.getNavigatingArgCSAccess().getColonKeyword_0_1_0_0());

                            }
                            // InternalQVTbase.g:5837:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                            // InternalQVTbase.g:5838:1: (lv_ownedType_2_0= ruleTypeExpCS )
                            {
                            // InternalQVTbase.g:5838:1: (lv_ownedType_2_0= ruleTypeExpCS )
                            // InternalQVTbase.g:5839:3: lv_ownedType_2_0= ruleTypeExpCS
                            {
                            if ( state.backtracking==0 ) {

                              	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_0_1_0_1_0());

                            }
                            pushFollow(FollowSets000.FOLLOW_89);
                            lv_ownedType_2_0=ruleTypeExpCS();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getNavigatingArgCSRule());
                              	        }
                                     		set(
                                     			current,
                                     			"ownedType",
                                      		lv_ownedType_2_0,
                                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeExpCS");
                              	        afterParserOrEnumRuleCall();

                            }

                            }


                            }

                            // InternalQVTbase.g:5855:2: (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )?
                            int alt136=2;
                            int LA136_0 = input.LA(1);

                            if ( (LA136_0==21) ) {
                                alt136=1;
                            }
                            switch (alt136) {
                                case 1 :
                                    // InternalQVTbase.g:5855:4: otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) )
                                    {
                                    otherlv_3=(Token)match(input,21,FollowSets000.FOLLOW_69); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                          	newLeafNode(otherlv_3, grammarAccess.getNavigatingArgCSAccess().getEqualsSignKeyword_0_1_0_2_0());

                                    }
                                    // InternalQVTbase.g:5859:1: ( (lv_ownedInitExpression_4_0= ruleExpCS ) )
                                    // InternalQVTbase.g:5860:1: (lv_ownedInitExpression_4_0= ruleExpCS )
                                    {
                                    // InternalQVTbase.g:5860:1: (lv_ownedInitExpression_4_0= ruleExpCS )
                                    // InternalQVTbase.g:5861:3: lv_ownedInitExpression_4_0= ruleExpCS
                                    {
                                    if ( state.backtracking==0 ) {

                                      	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_0_1_0_2_1_0());

                                    }
                                    pushFollow(FollowSets000.FOLLOW_2);
                                    lv_ownedInitExpression_4_0=ruleExpCS();

                                    state._fsp--;
                                    if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      	        if (current==null) {
                                      	            current = createModelElementForParent(grammarAccess.getNavigatingArgCSRule());
                                      	        }
                                             		set(
                                             			current,
                                             			"ownedInitExpression",
                                              		lv_ownedInitExpression_4_0,
                                              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
                                      	        afterParserOrEnumRuleCall();

                                    }

                                    }


                                    }


                                    }
                                    break;

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalQVTbase.g:5878:6: (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) )
                            {
                            // InternalQVTbase.g:5878:6: (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) )
                            // InternalQVTbase.g:5878:8: otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) )
                            {
                            otherlv_5=(Token)match(input,110,FollowSets000.FOLLOW_69); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_5, grammarAccess.getNavigatingArgCSAccess().getInKeyword_0_1_1_0());

                            }
                            // InternalQVTbase.g:5882:1: ( (lv_ownedInitExpression_6_0= ruleExpCS ) )
                            // InternalQVTbase.g:5883:1: (lv_ownedInitExpression_6_0= ruleExpCS )
                            {
                            // InternalQVTbase.g:5883:1: (lv_ownedInitExpression_6_0= ruleExpCS )
                            // InternalQVTbase.g:5884:3: lv_ownedInitExpression_6_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {

                              	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_0_1_1_1_0());

                            }
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_ownedInitExpression_6_0=ruleExpCS();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getNavigatingArgCSRule());
                              	        }
                                     		set(
                                     			current,
                                     			"ownedInitExpression",
                                      		lv_ownedInitExpression_6_0,
                                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
                              	        afterParserOrEnumRuleCall();

                            }

                            }


                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalQVTbase.g:5901:6: (otherlv_7= ':' ( (lv_ownedType_8_0= ruleTypeExpCS ) ) )
                    {
                    // InternalQVTbase.g:5901:6: (otherlv_7= ':' ( (lv_ownedType_8_0= ruleTypeExpCS ) ) )
                    // InternalQVTbase.g:5901:8: otherlv_7= ':' ( (lv_ownedType_8_0= ruleTypeExpCS ) )
                    {
                    otherlv_7=(Token)match(input,20,FollowSets000.FOLLOW_61); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getNavigatingArgCSAccess().getColonKeyword_1_0());

                    }
                    // InternalQVTbase.g:5905:1: ( (lv_ownedType_8_0= ruleTypeExpCS ) )
                    // InternalQVTbase.g:5906:1: (lv_ownedType_8_0= ruleTypeExpCS )
                    {
                    // InternalQVTbase.g:5906:1: (lv_ownedType_8_0= ruleTypeExpCS )
                    // InternalQVTbase.g:5907:3: lv_ownedType_8_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {

                      	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_ownedType_8_0=ruleTypeExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getNavigatingArgCSRule());
                      	        }
                             		set(
                             			current,
                             			"ownedType",
                              		lv_ownedType_8_0,
                              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeExpCS");
                      	        afterParserOrEnumRuleCall();

                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNavigatingArgCS"


    // $ANTLR start "entryRuleNavigatingBarArgCS"
    // InternalQVTbase.g:5931:1: entryRuleNavigatingBarArgCS returns [EObject current=null] : iv_ruleNavigatingBarArgCS= ruleNavigatingBarArgCS EOF ;
    public final EObject entryRuleNavigatingBarArgCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingBarArgCS = null;


        try {
            // InternalQVTbase.g:5932:2: (iv_ruleNavigatingBarArgCS= ruleNavigatingBarArgCS EOF )
            // InternalQVTbase.g:5933:2: iv_ruleNavigatingBarArgCS= ruleNavigatingBarArgCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingBarArgCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNavigatingBarArgCS=ruleNavigatingBarArgCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingBarArgCS;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNavigatingBarArgCS"


    // $ANTLR start "ruleNavigatingBarArgCS"
    // InternalQVTbase.g:5940:1: ruleNavigatingBarArgCS returns [EObject current=null] : ( ( (lv_prefix_0_0= '|' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )? ) ;
    public final EObject ruleNavigatingBarArgCS() throws RecognitionException {
        EObject current = null;

        Token lv_prefix_0_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_ownedNameExpression_1_0 = null;

        EObject lv_ownedType_3_0 = null;

        EObject lv_ownedInitExpression_5_0 = null;


         enterRule();

        try {
            // InternalQVTbase.g:5943:28: ( ( ( (lv_prefix_0_0= '|' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )? ) )
            // InternalQVTbase.g:5944:1: ( ( (lv_prefix_0_0= '|' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )? )
            {
            // InternalQVTbase.g:5944:1: ( ( (lv_prefix_0_0= '|' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )? )
            // InternalQVTbase.g:5944:2: ( (lv_prefix_0_0= '|' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )?
            {
            // InternalQVTbase.g:5944:2: ( (lv_prefix_0_0= '|' ) )
            // InternalQVTbase.g:5945:1: (lv_prefix_0_0= '|' )
            {
            // InternalQVTbase.g:5945:1: (lv_prefix_0_0= '|' )
            // InternalQVTbase.g:5946:3: lv_prefix_0_0= '|'
            {
            lv_prefix_0_0=(Token)match(input,111,FollowSets000.FOLLOW_69); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      newLeafNode(lv_prefix_0_0, grammarAccess.getNavigatingBarArgCSAccess().getPrefixVerticalLineKeyword_0_0());

            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getNavigatingBarArgCSRule());
              	        }
                     		setWithLastConsumed(current, "prefix", lv_prefix_0_0, "|");

            }

            }


            }

            // InternalQVTbase.g:5959:2: ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) )
            // InternalQVTbase.g:5960:1: (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS )
            {
            // InternalQVTbase.g:5960:1: (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS )
            // InternalQVTbase.g:5961:3: lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS
            {
            if ( state.backtracking==0 ) {

              	        newCompositeNode(grammarAccess.getNavigatingBarArgCSAccess().getOwnedNameExpressionNavigatingArgExpCSParserRuleCall_1_0());

            }
            pushFollow(FollowSets000.FOLLOW_90);
            lv_ownedNameExpression_1_0=ruleNavigatingArgExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getNavigatingBarArgCSRule());
              	        }
                     		set(
                     			current,
                     			"ownedNameExpression",
                      		lv_ownedNameExpression_1_0,
                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.NavigatingArgExpCS");
              	        afterParserOrEnumRuleCall();

            }

            }


            }

            // InternalQVTbase.g:5977:2: (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )?
            int alt140=2;
            int LA140_0 = input.LA(1);

            if ( (LA140_0==20) ) {
                alt140=1;
            }
            switch (alt140) {
                case 1 :
                    // InternalQVTbase.g:5977:4: otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )?
                    {
                    otherlv_2=(Token)match(input,20,FollowSets000.FOLLOW_61); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getNavigatingBarArgCSAccess().getColonKeyword_2_0());

                    }
                    // InternalQVTbase.g:5981:1: ( (lv_ownedType_3_0= ruleTypeExpCS ) )
                    // InternalQVTbase.g:5982:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    {
                    // InternalQVTbase.g:5982:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    // InternalQVTbase.g:5983:3: lv_ownedType_3_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {

                      	        newCompositeNode(grammarAccess.getNavigatingBarArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_89);
                    lv_ownedType_3_0=ruleTypeExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getNavigatingBarArgCSRule());
                      	        }
                             		set(
                             			current,
                             			"ownedType",
                              		lv_ownedType_3_0,
                              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeExpCS");
                      	        afterParserOrEnumRuleCall();

                    }

                    }


                    }

                    // InternalQVTbase.g:5999:2: (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )?
                    int alt139=2;
                    int LA139_0 = input.LA(1);

                    if ( (LA139_0==21) ) {
                        alt139=1;
                    }
                    switch (alt139) {
                        case 1 :
                            // InternalQVTbase.g:5999:4: otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) )
                            {
                            otherlv_4=(Token)match(input,21,FollowSets000.FOLLOW_69); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getNavigatingBarArgCSAccess().getEqualsSignKeyword_2_2_0());

                            }
                            // InternalQVTbase.g:6003:1: ( (lv_ownedInitExpression_5_0= ruleExpCS ) )
                            // InternalQVTbase.g:6004:1: (lv_ownedInitExpression_5_0= ruleExpCS )
                            {
                            // InternalQVTbase.g:6004:1: (lv_ownedInitExpression_5_0= ruleExpCS )
                            // InternalQVTbase.g:6005:3: lv_ownedInitExpression_5_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {

                              	        newCompositeNode(grammarAccess.getNavigatingBarArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_2_1_0());

                            }
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_ownedInitExpression_5_0=ruleExpCS();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getNavigatingBarArgCSRule());
                              	        }
                                     		set(
                                     			current,
                                     			"ownedInitExpression",
                                      		lv_ownedInitExpression_5_0,
                                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
                              	        afterParserOrEnumRuleCall();

                            }

                            }


                            }


                            }
                            break;

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNavigatingBarArgCS"


    // $ANTLR start "entryRuleNavigatingCommaArgCS"
    // InternalQVTbase.g:6029:1: entryRuleNavigatingCommaArgCS returns [EObject current=null] : iv_ruleNavigatingCommaArgCS= ruleNavigatingCommaArgCS EOF ;
    public final EObject entryRuleNavigatingCommaArgCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingCommaArgCS = null;


        try {
            // InternalQVTbase.g:6030:2: (iv_ruleNavigatingCommaArgCS= ruleNavigatingCommaArgCS EOF )
            // InternalQVTbase.g:6031:2: iv_ruleNavigatingCommaArgCS= ruleNavigatingCommaArgCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingCommaArgCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNavigatingCommaArgCS=ruleNavigatingCommaArgCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingCommaArgCS;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNavigatingCommaArgCS"


    // $ANTLR start "ruleNavigatingCommaArgCS"
    // InternalQVTbase.g:6038:1: ruleNavigatingCommaArgCS returns [EObject current=null] : ( ( (lv_prefix_0_0= ',' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) ( (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? ) | (otherlv_6= 'in' ( (lv_ownedInitExpression_7_0= ruleExpCS ) ) ) )? ) ;
    public final EObject ruleNavigatingCommaArgCS() throws RecognitionException {
        EObject current = null;

        Token lv_prefix_0_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_ownedNameExpression_1_0 = null;

        EObject lv_ownedType_3_0 = null;

        EObject lv_ownedInitExpression_5_0 = null;

        EObject lv_ownedInitExpression_7_0 = null;


         enterRule();

        try {
            // InternalQVTbase.g:6041:28: ( ( ( (lv_prefix_0_0= ',' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) ( (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? ) | (otherlv_6= 'in' ( (lv_ownedInitExpression_7_0= ruleExpCS ) ) ) )? ) )
            // InternalQVTbase.g:6042:1: ( ( (lv_prefix_0_0= ',' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) ( (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? ) | (otherlv_6= 'in' ( (lv_ownedInitExpression_7_0= ruleExpCS ) ) ) )? )
            {
            // InternalQVTbase.g:6042:1: ( ( (lv_prefix_0_0= ',' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) ( (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? ) | (otherlv_6= 'in' ( (lv_ownedInitExpression_7_0= ruleExpCS ) ) ) )? )
            // InternalQVTbase.g:6042:2: ( (lv_prefix_0_0= ',' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) ( (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? ) | (otherlv_6= 'in' ( (lv_ownedInitExpression_7_0= ruleExpCS ) ) ) )?
            {
            // InternalQVTbase.g:6042:2: ( (lv_prefix_0_0= ',' ) )
            // InternalQVTbase.g:6043:1: (lv_prefix_0_0= ',' )
            {
            // InternalQVTbase.g:6043:1: (lv_prefix_0_0= ',' )
            // InternalQVTbase.g:6044:3: lv_prefix_0_0= ','
            {
            lv_prefix_0_0=(Token)match(input,39,FollowSets000.FOLLOW_69); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      newLeafNode(lv_prefix_0_0, grammarAccess.getNavigatingCommaArgCSAccess().getPrefixCommaKeyword_0_0());

            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getNavigatingCommaArgCSRule());
              	        }
                     		setWithLastConsumed(current, "prefix", lv_prefix_0_0, ",");

            }

            }


            }

            // InternalQVTbase.g:6057:2: ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) )
            // InternalQVTbase.g:6058:1: (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS )
            {
            // InternalQVTbase.g:6058:1: (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS )
            // InternalQVTbase.g:6059:3: lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS
            {
            if ( state.backtracking==0 ) {

              	        newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedNameExpressionNavigatingArgExpCSParserRuleCall_1_0());

            }
            pushFollow(FollowSets000.FOLLOW_88);
            lv_ownedNameExpression_1_0=ruleNavigatingArgExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getNavigatingCommaArgCSRule());
              	        }
                     		set(
                     			current,
                     			"ownedNameExpression",
                      		lv_ownedNameExpression_1_0,
                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.NavigatingArgExpCS");
              	        afterParserOrEnumRuleCall();

            }

            }


            }

            // InternalQVTbase.g:6075:2: ( (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? ) | (otherlv_6= 'in' ( (lv_ownedInitExpression_7_0= ruleExpCS ) ) ) )?
            int alt142=3;
            int LA142_0 = input.LA(1);

            if ( (LA142_0==20) ) {
                alt142=1;
            }
            else if ( (LA142_0==110) ) {
                alt142=2;
            }
            switch (alt142) {
                case 1 :
                    // InternalQVTbase.g:6075:3: (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )
                    {
                    // InternalQVTbase.g:6075:3: (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )
                    // InternalQVTbase.g:6075:5: otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )?
                    {
                    otherlv_2=(Token)match(input,20,FollowSets000.FOLLOW_61); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getNavigatingCommaArgCSAccess().getColonKeyword_2_0_0());

                    }
                    // InternalQVTbase.g:6079:1: ( (lv_ownedType_3_0= ruleTypeExpCS ) )
                    // InternalQVTbase.g:6080:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    {
                    // InternalQVTbase.g:6080:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    // InternalQVTbase.g:6081:3: lv_ownedType_3_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {

                      	        newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_0_1_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_89);
                    lv_ownedType_3_0=ruleTypeExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getNavigatingCommaArgCSRule());
                      	        }
                             		set(
                             			current,
                             			"ownedType",
                              		lv_ownedType_3_0,
                              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeExpCS");
                      	        afterParserOrEnumRuleCall();

                    }

                    }


                    }

                    // InternalQVTbase.g:6097:2: (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )?
                    int alt141=2;
                    int LA141_0 = input.LA(1);

                    if ( (LA141_0==21) ) {
                        alt141=1;
                    }
                    switch (alt141) {
                        case 1 :
                            // InternalQVTbase.g:6097:4: otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) )
                            {
                            otherlv_4=(Token)match(input,21,FollowSets000.FOLLOW_69); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getNavigatingCommaArgCSAccess().getEqualsSignKeyword_2_0_2_0());

                            }
                            // InternalQVTbase.g:6101:1: ( (lv_ownedInitExpression_5_0= ruleExpCS ) )
                            // InternalQVTbase.g:6102:1: (lv_ownedInitExpression_5_0= ruleExpCS )
                            {
                            // InternalQVTbase.g:6102:1: (lv_ownedInitExpression_5_0= ruleExpCS )
                            // InternalQVTbase.g:6103:3: lv_ownedInitExpression_5_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {

                              	        newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_0_2_1_0());

                            }
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_ownedInitExpression_5_0=ruleExpCS();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getNavigatingCommaArgCSRule());
                              	        }
                                     		set(
                                     			current,
                                     			"ownedInitExpression",
                                      		lv_ownedInitExpression_5_0,
                                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
                              	        afterParserOrEnumRuleCall();

                            }

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalQVTbase.g:6120:6: (otherlv_6= 'in' ( (lv_ownedInitExpression_7_0= ruleExpCS ) ) )
                    {
                    // InternalQVTbase.g:6120:6: (otherlv_6= 'in' ( (lv_ownedInitExpression_7_0= ruleExpCS ) ) )
                    // InternalQVTbase.g:6120:8: otherlv_6= 'in' ( (lv_ownedInitExpression_7_0= ruleExpCS ) )
                    {
                    otherlv_6=(Token)match(input,110,FollowSets000.FOLLOW_69); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getNavigatingCommaArgCSAccess().getInKeyword_2_1_0());

                    }
                    // InternalQVTbase.g:6124:1: ( (lv_ownedInitExpression_7_0= ruleExpCS ) )
                    // InternalQVTbase.g:6125:1: (lv_ownedInitExpression_7_0= ruleExpCS )
                    {
                    // InternalQVTbase.g:6125:1: (lv_ownedInitExpression_7_0= ruleExpCS )
                    // InternalQVTbase.g:6126:3: lv_ownedInitExpression_7_0= ruleExpCS
                    {
                    if ( state.backtracking==0 ) {

                      	        newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_1_1_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_ownedInitExpression_7_0=ruleExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getNavigatingCommaArgCSRule());
                      	        }
                             		set(
                             			current,
                             			"ownedInitExpression",
                              		lv_ownedInitExpression_7_0,
                              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
                      	        afterParserOrEnumRuleCall();

                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNavigatingCommaArgCS"


    // $ANTLR start "entryRuleNavigatingSemiArgCS"
    // InternalQVTbase.g:6150:1: entryRuleNavigatingSemiArgCS returns [EObject current=null] : iv_ruleNavigatingSemiArgCS= ruleNavigatingSemiArgCS EOF ;
    public final EObject entryRuleNavigatingSemiArgCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingSemiArgCS = null;


        try {
            // InternalQVTbase.g:6151:2: (iv_ruleNavigatingSemiArgCS= ruleNavigatingSemiArgCS EOF )
            // InternalQVTbase.g:6152:2: iv_ruleNavigatingSemiArgCS= ruleNavigatingSemiArgCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingSemiArgCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNavigatingSemiArgCS=ruleNavigatingSemiArgCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingSemiArgCS;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNavigatingSemiArgCS"


    // $ANTLR start "ruleNavigatingSemiArgCS"
    // InternalQVTbase.g:6159:1: ruleNavigatingSemiArgCS returns [EObject current=null] : ( ( (lv_prefix_0_0= ';' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )? ) ;
    public final EObject ruleNavigatingSemiArgCS() throws RecognitionException {
        EObject current = null;

        Token lv_prefix_0_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_ownedNameExpression_1_0 = null;

        EObject lv_ownedType_3_0 = null;

        EObject lv_ownedInitExpression_5_0 = null;


         enterRule();

        try {
            // InternalQVTbase.g:6162:28: ( ( ( (lv_prefix_0_0= ';' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )? ) )
            // InternalQVTbase.g:6163:1: ( ( (lv_prefix_0_0= ';' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )? )
            {
            // InternalQVTbase.g:6163:1: ( ( (lv_prefix_0_0= ';' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )? )
            // InternalQVTbase.g:6163:2: ( (lv_prefix_0_0= ';' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )?
            {
            // InternalQVTbase.g:6163:2: ( (lv_prefix_0_0= ';' ) )
            // InternalQVTbase.g:6164:1: (lv_prefix_0_0= ';' )
            {
            // InternalQVTbase.g:6164:1: (lv_prefix_0_0= ';' )
            // InternalQVTbase.g:6165:3: lv_prefix_0_0= ';'
            {
            lv_prefix_0_0=(Token)match(input,42,FollowSets000.FOLLOW_69); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      newLeafNode(lv_prefix_0_0, grammarAccess.getNavigatingSemiArgCSAccess().getPrefixSemicolonKeyword_0_0());

            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getNavigatingSemiArgCSRule());
              	        }
                     		setWithLastConsumed(current, "prefix", lv_prefix_0_0, ";");

            }

            }


            }

            // InternalQVTbase.g:6178:2: ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) )
            // InternalQVTbase.g:6179:1: (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS )
            {
            // InternalQVTbase.g:6179:1: (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS )
            // InternalQVTbase.g:6180:3: lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS
            {
            if ( state.backtracking==0 ) {

              	        newCompositeNode(grammarAccess.getNavigatingSemiArgCSAccess().getOwnedNameExpressionNavigatingArgExpCSParserRuleCall_1_0());

            }
            pushFollow(FollowSets000.FOLLOW_90);
            lv_ownedNameExpression_1_0=ruleNavigatingArgExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getNavigatingSemiArgCSRule());
              	        }
                     		set(
                     			current,
                     			"ownedNameExpression",
                      		lv_ownedNameExpression_1_0,
                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.NavigatingArgExpCS");
              	        afterParserOrEnumRuleCall();

            }

            }


            }

            // InternalQVTbase.g:6196:2: (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )?
            int alt144=2;
            int LA144_0 = input.LA(1);

            if ( (LA144_0==20) ) {
                alt144=1;
            }
            switch (alt144) {
                case 1 :
                    // InternalQVTbase.g:6196:4: otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )?
                    {
                    otherlv_2=(Token)match(input,20,FollowSets000.FOLLOW_61); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getNavigatingSemiArgCSAccess().getColonKeyword_2_0());

                    }
                    // InternalQVTbase.g:6200:1: ( (lv_ownedType_3_0= ruleTypeExpCS ) )
                    // InternalQVTbase.g:6201:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    {
                    // InternalQVTbase.g:6201:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    // InternalQVTbase.g:6202:3: lv_ownedType_3_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {

                      	        newCompositeNode(grammarAccess.getNavigatingSemiArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_89);
                    lv_ownedType_3_0=ruleTypeExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getNavigatingSemiArgCSRule());
                      	        }
                             		set(
                             			current,
                             			"ownedType",
                              		lv_ownedType_3_0,
                              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeExpCS");
                      	        afterParserOrEnumRuleCall();

                    }

                    }


                    }

                    // InternalQVTbase.g:6218:2: (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )?
                    int alt143=2;
                    int LA143_0 = input.LA(1);

                    if ( (LA143_0==21) ) {
                        alt143=1;
                    }
                    switch (alt143) {
                        case 1 :
                            // InternalQVTbase.g:6218:4: otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) )
                            {
                            otherlv_4=(Token)match(input,21,FollowSets000.FOLLOW_69); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getNavigatingSemiArgCSAccess().getEqualsSignKeyword_2_2_0());

                            }
                            // InternalQVTbase.g:6222:1: ( (lv_ownedInitExpression_5_0= ruleExpCS ) )
                            // InternalQVTbase.g:6223:1: (lv_ownedInitExpression_5_0= ruleExpCS )
                            {
                            // InternalQVTbase.g:6223:1: (lv_ownedInitExpression_5_0= ruleExpCS )
                            // InternalQVTbase.g:6224:3: lv_ownedInitExpression_5_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {

                              	        newCompositeNode(grammarAccess.getNavigatingSemiArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_2_1_0());

                            }
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_ownedInitExpression_5_0=ruleExpCS();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getNavigatingSemiArgCSRule());
                              	        }
                                     		set(
                                     			current,
                                     			"ownedInitExpression",
                                      		lv_ownedInitExpression_5_0,
                                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
                              	        afterParserOrEnumRuleCall();

                            }

                            }


                            }


                            }
                            break;

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNavigatingSemiArgCS"


    // $ANTLR start "entryRuleNavigatingArgExpCS"
    // InternalQVTbase.g:6248:1: entryRuleNavigatingArgExpCS returns [EObject current=null] : iv_ruleNavigatingArgExpCS= ruleNavigatingArgExpCS EOF ;
    public final EObject entryRuleNavigatingArgExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingArgExpCS = null;


        try {
            // InternalQVTbase.g:6249:2: (iv_ruleNavigatingArgExpCS= ruleNavigatingArgExpCS EOF )
            // InternalQVTbase.g:6250:2: iv_ruleNavigatingArgExpCS= ruleNavigatingArgExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingArgExpCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNavigatingArgExpCS=ruleNavigatingArgExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingArgExpCS;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNavigatingArgExpCS"


    // $ANTLR start "ruleNavigatingArgExpCS"
    // InternalQVTbase.g:6257:1: ruleNavigatingArgExpCS returns [EObject current=null] : this_ExpCS_0= ruleExpCS ;
    public final EObject ruleNavigatingArgExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_ExpCS_0 = null;


         enterRule();

        try {
            // InternalQVTbase.g:6260:28: (this_ExpCS_0= ruleExpCS )
            // InternalQVTbase.g:6262:2: this_ExpCS_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {

              	  /* */

            }
            if ( state.backtracking==0 ) {

                      newCompositeNode(grammarAccess.getNavigatingArgExpCSAccess().getExpCSParserRuleCall());

            }
            pushFollow(FollowSets000.FOLLOW_2);
            this_ExpCS_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current = this_ExpCS_0;
                      afterParserOrEnumRuleCall();

            }

            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNavigatingArgExpCS"


    // $ANTLR start "entryRuleIfExpCS"
    // InternalQVTbase.g:6281:1: entryRuleIfExpCS returns [EObject current=null] : iv_ruleIfExpCS= ruleIfExpCS EOF ;
    public final EObject entryRuleIfExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfExpCS = null;


        try {
            // InternalQVTbase.g:6282:2: (iv_ruleIfExpCS= ruleIfExpCS EOF )
            // InternalQVTbase.g:6283:2: iv_ruleIfExpCS= ruleIfExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIfExpCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleIfExpCS=ruleIfExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIfExpCS;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIfExpCS"


    // $ANTLR start "ruleIfExpCS"
    // InternalQVTbase.g:6290:1: ruleIfExpCS returns [EObject current=null] : (otherlv_0= 'if' ( ( (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS ) ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) ( (lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS ) )* otherlv_5= 'else' ( (lv_ownedElseExpression_6_0= ruleExpCS ) ) otherlv_7= 'endif' ) ;
    public final EObject ruleIfExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_ownedCondition_1_1 = null;

        EObject lv_ownedCondition_1_2 = null;

        EObject lv_ownedThenExpression_3_0 = null;

        EObject lv_ownedIfThenExpressions_4_0 = null;

        EObject lv_ownedElseExpression_6_0 = null;


         enterRule();

        try {
            // InternalQVTbase.g:6293:28: ( (otherlv_0= 'if' ( ( (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS ) ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) ( (lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS ) )* otherlv_5= 'else' ( (lv_ownedElseExpression_6_0= ruleExpCS ) ) otherlv_7= 'endif' ) )
            // InternalQVTbase.g:6294:1: (otherlv_0= 'if' ( ( (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS ) ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) ( (lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS ) )* otherlv_5= 'else' ( (lv_ownedElseExpression_6_0= ruleExpCS ) ) otherlv_7= 'endif' )
            {
            // InternalQVTbase.g:6294:1: (otherlv_0= 'if' ( ( (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS ) ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) ( (lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS ) )* otherlv_5= 'else' ( (lv_ownedElseExpression_6_0= ruleExpCS ) ) otherlv_7= 'endif' )
            // InternalQVTbase.g:6294:3: otherlv_0= 'if' ( ( (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS ) ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) ( (lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS ) )* otherlv_5= 'else' ( (lv_ownedElseExpression_6_0= ruleExpCS ) ) otherlv_7= 'endif'
            {
            otherlv_0=(Token)match(input,112,FollowSets000.FOLLOW_67); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getIfExpCSAccess().getIfKeyword_0());

            }
            // InternalQVTbase.g:6298:1: ( ( (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS ) ) )
            // InternalQVTbase.g:6299:1: ( (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS ) )
            {
            // InternalQVTbase.g:6299:1: ( (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS ) )
            // InternalQVTbase.g:6300:1: (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS )
            {
            // InternalQVTbase.g:6300:1: (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS )
            int alt145=2;
            switch ( input.LA(1) ) {
            case RULE_SINGLE_QUOTED_STRING:
            case RULE_INT:
            case 51:
            case 65:
            case 66:
            case 67:
            case 83:
            case 84:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
            case 97:
            case 100:
            case 102:
            case 103:
            case 104:
            case 105:
            case 112:
            case 117:
            case 118:
                {
                alt145=1;
                }
                break;
            case RULE_SIMPLE_ID:
                {
                int LA145_2 = input.LA(2);

                if ( ((LA145_2>=21 && LA145_2<=22)||LA145_2==51||LA145_2==65||(LA145_2>=67 && LA145_2<=82)||LA145_2==106||LA145_2==108||LA145_2==113||LA145_2==122) ) {
                    alt145=1;
                }
                else if ( (LA145_2==20) ) {
                    alt145=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 145, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_ESCAPED_ID:
                {
                int LA145_3 = input.LA(2);

                if ( (LA145_3==20) ) {
                    alt145=2;
                }
                else if ( ((LA145_3>=21 && LA145_3<=22)||LA145_3==51||LA145_3==65||(LA145_3>=67 && LA145_3<=82)||LA145_3==106||LA145_3==108||LA145_3==113||LA145_3==122) ) {
                    alt145=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 145, 3, input);

                    throw nvae;
                }
                }
                break;
            case 20:
                {
                alt145=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 145, 0, input);

                throw nvae;
            }

            switch (alt145) {
                case 1 :
                    // InternalQVTbase.g:6301:3: lv_ownedCondition_1_1= ruleExpCS
                    {
                    if ( state.backtracking==0 ) {

                      	        newCompositeNode(grammarAccess.getIfExpCSAccess().getOwnedConditionExpCSParserRuleCall_1_0_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_91);
                    lv_ownedCondition_1_1=ruleExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getIfExpCSRule());
                      	        }
                             		set(
                             			current,
                             			"ownedCondition",
                              		lv_ownedCondition_1_1,
                              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
                      	        afterParserOrEnumRuleCall();

                    }

                    }
                    break;
                case 2 :
                    // InternalQVTbase.g:6316:8: lv_ownedCondition_1_2= rulePatternExpCS
                    {
                    if ( state.backtracking==0 ) {

                      	        newCompositeNode(grammarAccess.getIfExpCSAccess().getOwnedConditionPatternExpCSParserRuleCall_1_0_1());

                    }
                    pushFollow(FollowSets000.FOLLOW_91);
                    lv_ownedCondition_1_2=rulePatternExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getIfExpCSRule());
                      	        }
                             		set(
                             			current,
                             			"ownedCondition",
                              		lv_ownedCondition_1_2,
                              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.PatternExpCS");
                      	        afterParserOrEnumRuleCall();

                    }

                    }
                    break;

            }


            }


            }

            otherlv_2=(Token)match(input,113,FollowSets000.FOLLOW_69); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getIfExpCSAccess().getThenKeyword_2());

            }
            // InternalQVTbase.g:6338:1: ( (lv_ownedThenExpression_3_0= ruleExpCS ) )
            // InternalQVTbase.g:6339:1: (lv_ownedThenExpression_3_0= ruleExpCS )
            {
            // InternalQVTbase.g:6339:1: (lv_ownedThenExpression_3_0= ruleExpCS )
            // InternalQVTbase.g:6340:3: lv_ownedThenExpression_3_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {

              	        newCompositeNode(grammarAccess.getIfExpCSAccess().getOwnedThenExpressionExpCSParserRuleCall_3_0());

            }
            pushFollow(FollowSets000.FOLLOW_92);
            lv_ownedThenExpression_3_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getIfExpCSRule());
              	        }
                     		set(
                     			current,
                     			"ownedThenExpression",
                      		lv_ownedThenExpression_3_0,
                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
              	        afterParserOrEnumRuleCall();

            }

            }


            }

            // InternalQVTbase.g:6356:2: ( (lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS ) )*
            loop146:
            do {
                int alt146=2;
                int LA146_0 = input.LA(1);

                if ( (LA146_0==116) ) {
                    alt146=1;
                }


                switch (alt146) {
            	case 1 :
            	    // InternalQVTbase.g:6357:1: (lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS )
            	    {
            	    // InternalQVTbase.g:6357:1: (lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS )
            	    // InternalQVTbase.g:6358:3: lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS
            	    {
            	    if ( state.backtracking==0 ) {

            	      	        newCompositeNode(grammarAccess.getIfExpCSAccess().getOwnedIfThenExpressionsElseIfThenExpCSParserRuleCall_4_0());

            	    }
            	    pushFollow(FollowSets000.FOLLOW_92);
            	    lv_ownedIfThenExpressions_4_0=ruleElseIfThenExpCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getIfExpCSRule());
            	      	        }
            	             		add(
            	             			current,
            	             			"ownedIfThenExpressions",
            	              		lv_ownedIfThenExpressions_4_0,
            	              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ElseIfThenExpCS");
            	      	        afterParserOrEnumRuleCall();

            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop146;
                }
            } while (true);

            otherlv_5=(Token)match(input,114,FollowSets000.FOLLOW_69); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getIfExpCSAccess().getElseKeyword_5());

            }
            // InternalQVTbase.g:6378:1: ( (lv_ownedElseExpression_6_0= ruleExpCS ) )
            // InternalQVTbase.g:6379:1: (lv_ownedElseExpression_6_0= ruleExpCS )
            {
            // InternalQVTbase.g:6379:1: (lv_ownedElseExpression_6_0= ruleExpCS )
            // InternalQVTbase.g:6380:3: lv_ownedElseExpression_6_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {

              	        newCompositeNode(grammarAccess.getIfExpCSAccess().getOwnedElseExpressionExpCSParserRuleCall_6_0());

            }
            pushFollow(FollowSets000.FOLLOW_93);
            lv_ownedElseExpression_6_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getIfExpCSRule());
              	        }
                     		set(
                     			current,
                     			"ownedElseExpression",
                      		lv_ownedElseExpression_6_0,
                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
              	        afterParserOrEnumRuleCall();

            }

            }


            }

            otherlv_7=(Token)match(input,115,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getIfExpCSAccess().getEndifKeyword_7());

            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIfExpCS"


    // $ANTLR start "entryRuleElseIfThenExpCS"
    // InternalQVTbase.g:6408:1: entryRuleElseIfThenExpCS returns [EObject current=null] : iv_ruleElseIfThenExpCS= ruleElseIfThenExpCS EOF ;
    public final EObject entryRuleElseIfThenExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElseIfThenExpCS = null;


        try {
            // InternalQVTbase.g:6409:2: (iv_ruleElseIfThenExpCS= ruleElseIfThenExpCS EOF )
            // InternalQVTbase.g:6410:2: iv_ruleElseIfThenExpCS= ruleElseIfThenExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getElseIfThenExpCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleElseIfThenExpCS=ruleElseIfThenExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleElseIfThenExpCS;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleElseIfThenExpCS"


    // $ANTLR start "ruleElseIfThenExpCS"
    // InternalQVTbase.g:6417:1: ruleElseIfThenExpCS returns [EObject current=null] : (otherlv_0= 'elseif' ( (lv_ownedCondition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) ) ;
    public final EObject ruleElseIfThenExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_ownedCondition_1_0 = null;

        EObject lv_ownedThenExpression_3_0 = null;


         enterRule();

        try {
            // InternalQVTbase.g:6420:28: ( (otherlv_0= 'elseif' ( (lv_ownedCondition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) ) )
            // InternalQVTbase.g:6421:1: (otherlv_0= 'elseif' ( (lv_ownedCondition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) )
            {
            // InternalQVTbase.g:6421:1: (otherlv_0= 'elseif' ( (lv_ownedCondition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) )
            // InternalQVTbase.g:6421:3: otherlv_0= 'elseif' ( (lv_ownedCondition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) )
            {
            otherlv_0=(Token)match(input,116,FollowSets000.FOLLOW_69); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getElseIfThenExpCSAccess().getElseifKeyword_0());

            }
            // InternalQVTbase.g:6425:1: ( (lv_ownedCondition_1_0= ruleExpCS ) )
            // InternalQVTbase.g:6426:1: (lv_ownedCondition_1_0= ruleExpCS )
            {
            // InternalQVTbase.g:6426:1: (lv_ownedCondition_1_0= ruleExpCS )
            // InternalQVTbase.g:6427:3: lv_ownedCondition_1_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {

              	        newCompositeNode(grammarAccess.getElseIfThenExpCSAccess().getOwnedConditionExpCSParserRuleCall_1_0());

            }
            pushFollow(FollowSets000.FOLLOW_91);
            lv_ownedCondition_1_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getElseIfThenExpCSRule());
              	        }
                     		set(
                     			current,
                     			"ownedCondition",
                      		lv_ownedCondition_1_0,
                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
              	        afterParserOrEnumRuleCall();

            }

            }


            }

            otherlv_2=(Token)match(input,113,FollowSets000.FOLLOW_69); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getElseIfThenExpCSAccess().getThenKeyword_2());

            }
            // InternalQVTbase.g:6447:1: ( (lv_ownedThenExpression_3_0= ruleExpCS ) )
            // InternalQVTbase.g:6448:1: (lv_ownedThenExpression_3_0= ruleExpCS )
            {
            // InternalQVTbase.g:6448:1: (lv_ownedThenExpression_3_0= ruleExpCS )
            // InternalQVTbase.g:6449:3: lv_ownedThenExpression_3_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {

              	        newCompositeNode(grammarAccess.getElseIfThenExpCSAccess().getOwnedThenExpressionExpCSParserRuleCall_3_0());

            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_ownedThenExpression_3_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getElseIfThenExpCSRule());
              	        }
                     		set(
                     			current,
                     			"ownedThenExpression",
                      		lv_ownedThenExpression_3_0,
                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
              	        afterParserOrEnumRuleCall();

            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleElseIfThenExpCS"


    // $ANTLR start "entryRuleLetExpCS"
    // InternalQVTbase.g:6473:1: entryRuleLetExpCS returns [EObject current=null] : iv_ruleLetExpCS= ruleLetExpCS EOF ;
    public final EObject entryRuleLetExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLetExpCS = null;


        try {
            // InternalQVTbase.g:6474:2: (iv_ruleLetExpCS= ruleLetExpCS EOF )
            // InternalQVTbase.g:6475:2: iv_ruleLetExpCS= ruleLetExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLetExpCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleLetExpCS=ruleLetExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLetExpCS;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLetExpCS"


    // $ANTLR start "ruleLetExpCS"
    // InternalQVTbase.g:6482:1: ruleLetExpCS returns [EObject current=null] : (otherlv_0= 'let' ( (lv_ownedVariables_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_ownedVariables_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_ownedInExpression_5_0= ruleExpCS ) ) ) ;
    public final EObject ruleLetExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_ownedVariables_1_0 = null;

        EObject lv_ownedVariables_3_0 = null;

        EObject lv_ownedInExpression_5_0 = null;


         enterRule();

        try {
            // InternalQVTbase.g:6485:28: ( (otherlv_0= 'let' ( (lv_ownedVariables_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_ownedVariables_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_ownedInExpression_5_0= ruleExpCS ) ) ) )
            // InternalQVTbase.g:6486:1: (otherlv_0= 'let' ( (lv_ownedVariables_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_ownedVariables_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_ownedInExpression_5_0= ruleExpCS ) ) )
            {
            // InternalQVTbase.g:6486:1: (otherlv_0= 'let' ( (lv_ownedVariables_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_ownedVariables_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_ownedInExpression_5_0= ruleExpCS ) ) )
            // InternalQVTbase.g:6486:3: otherlv_0= 'let' ( (lv_ownedVariables_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_ownedVariables_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_ownedInExpression_5_0= ruleExpCS ) )
            {
            otherlv_0=(Token)match(input,117,FollowSets000.FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLetExpCSAccess().getLetKeyword_0());

            }
            // InternalQVTbase.g:6490:1: ( (lv_ownedVariables_1_0= ruleLetVariableCS ) )
            // InternalQVTbase.g:6491:1: (lv_ownedVariables_1_0= ruleLetVariableCS )
            {
            // InternalQVTbase.g:6491:1: (lv_ownedVariables_1_0= ruleLetVariableCS )
            // InternalQVTbase.g:6492:3: lv_ownedVariables_1_0= ruleLetVariableCS
            {
            if ( state.backtracking==0 ) {

              	        newCompositeNode(grammarAccess.getLetExpCSAccess().getOwnedVariablesLetVariableCSParserRuleCall_1_0());

            }
            pushFollow(FollowSets000.FOLLOW_94);
            lv_ownedVariables_1_0=ruleLetVariableCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLetExpCSRule());
              	        }
                     		add(
                     			current,
                     			"ownedVariables",
                      		lv_ownedVariables_1_0,
                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.LetVariableCS");
              	        afterParserOrEnumRuleCall();

            }

            }


            }

            // InternalQVTbase.g:6508:2: (otherlv_2= ',' ( (lv_ownedVariables_3_0= ruleLetVariableCS ) ) )*
            loop147:
            do {
                int alt147=2;
                int LA147_0 = input.LA(1);

                if ( (LA147_0==39) ) {
                    alt147=1;
                }


                switch (alt147) {
            	case 1 :
            	    // InternalQVTbase.g:6508:4: otherlv_2= ',' ( (lv_ownedVariables_3_0= ruleLetVariableCS ) )
            	    {
            	    otherlv_2=(Token)match(input,39,FollowSets000.FOLLOW_6); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getLetExpCSAccess().getCommaKeyword_2_0());

            	    }
            	    // InternalQVTbase.g:6512:1: ( (lv_ownedVariables_3_0= ruleLetVariableCS ) )
            	    // InternalQVTbase.g:6513:1: (lv_ownedVariables_3_0= ruleLetVariableCS )
            	    {
            	    // InternalQVTbase.g:6513:1: (lv_ownedVariables_3_0= ruleLetVariableCS )
            	    // InternalQVTbase.g:6514:3: lv_ownedVariables_3_0= ruleLetVariableCS
            	    {
            	    if ( state.backtracking==0 ) {

            	      	        newCompositeNode(grammarAccess.getLetExpCSAccess().getOwnedVariablesLetVariableCSParserRuleCall_2_1_0());

            	    }
            	    pushFollow(FollowSets000.FOLLOW_94);
            	    lv_ownedVariables_3_0=ruleLetVariableCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getLetExpCSRule());
            	      	        }
            	             		add(
            	             			current,
            	             			"ownedVariables",
            	              		lv_ownedVariables_3_0,
            	              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.LetVariableCS");
            	      	        afterParserOrEnumRuleCall();

            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop147;
                }
            } while (true);

            otherlv_4=(Token)match(input,110,FollowSets000.FOLLOW_69); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getLetExpCSAccess().getInKeyword_3());

            }
            // InternalQVTbase.g:6534:1: ( (lv_ownedInExpression_5_0= ruleExpCS ) )
            // InternalQVTbase.g:6535:1: (lv_ownedInExpression_5_0= ruleExpCS )
            {
            // InternalQVTbase.g:6535:1: (lv_ownedInExpression_5_0= ruleExpCS )
            // InternalQVTbase.g:6536:3: lv_ownedInExpression_5_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {

              	        newCompositeNode(grammarAccess.getLetExpCSAccess().getOwnedInExpressionExpCSParserRuleCall_4_0());

            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_ownedInExpression_5_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLetExpCSRule());
              	        }
                     		set(
                     			current,
                     			"ownedInExpression",
                      		lv_ownedInExpression_5_0,
                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
              	        afterParserOrEnumRuleCall();

            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLetExpCS"


    // $ANTLR start "entryRuleLetVariableCS"
    // InternalQVTbase.g:6560:1: entryRuleLetVariableCS returns [EObject current=null] : iv_ruleLetVariableCS= ruleLetVariableCS EOF ;
    public final EObject entryRuleLetVariableCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLetVariableCS = null;


        try {
            // InternalQVTbase.g:6561:2: (iv_ruleLetVariableCS= ruleLetVariableCS EOF )
            // InternalQVTbase.g:6562:2: iv_ruleLetVariableCS= ruleLetVariableCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLetVariableCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleLetVariableCS=ruleLetVariableCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLetVariableCS;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLetVariableCS"


    // $ANTLR start "ruleLetVariableCS"
    // InternalQVTbase.g:6569:1: ruleLetVariableCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) ( (lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS ) )? (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )? otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) ) ;
    public final EObject ruleLetVariableCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedRoundBracketedClause_1_0 = null;

        EObject lv_ownedType_3_0 = null;

        EObject lv_ownedInitExpression_5_0 = null;


         enterRule();

        try {
            // InternalQVTbase.g:6572:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) ( (lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS ) )? (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )? otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) ) )
            // InternalQVTbase.g:6573:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) ( (lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS ) )? (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )? otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )
            {
            // InternalQVTbase.g:6573:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) ( (lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS ) )? (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )? otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )
            // InternalQVTbase.g:6573:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) ( (lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS ) )? (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )? otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) )
            {
            // InternalQVTbase.g:6573:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // InternalQVTbase.g:6574:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // InternalQVTbase.g:6574:1: (lv_name_0_0= ruleUnrestrictedName )
            // InternalQVTbase.g:6575:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {

              	        newCompositeNode(grammarAccess.getLetVariableCSAccess().getNameUnrestrictedNameParserRuleCall_0_0());

            }
            pushFollow(FollowSets000.FOLLOW_95);
            lv_name_0_0=ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLetVariableCSRule());
              	        }
                     		set(
                     			current,
                     			"name",
                      		lv_name_0_0,
                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.UnrestrictedName");
              	        afterParserOrEnumRuleCall();

            }

            }


            }

            // InternalQVTbase.g:6591:2: ( (lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS ) )?
            int alt148=2;
            int LA148_0 = input.LA(1);

            if ( (LA148_0==51) ) {
                alt148=1;
            }
            switch (alt148) {
                case 1 :
                    // InternalQVTbase.g:6592:1: (lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS )
                    {
                    // InternalQVTbase.g:6592:1: (lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS )
                    // InternalQVTbase.g:6593:3: lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS
                    {
                    if ( state.backtracking==0 ) {

                      	        newCompositeNode(grammarAccess.getLetVariableCSAccess().getOwnedRoundBracketedClauseRoundBracketedClauseCSParserRuleCall_1_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_74);
                    lv_ownedRoundBracketedClause_1_0=ruleRoundBracketedClauseCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getLetVariableCSRule());
                      	        }
                             		set(
                             			current,
                             			"ownedRoundBracketedClause",
                              		lv_ownedRoundBracketedClause_1_0,
                              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.RoundBracketedClauseCS");
                      	        afterParserOrEnumRuleCall();

                    }

                    }


                    }
                    break;

            }

            // InternalQVTbase.g:6609:3: (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )?
            int alt149=2;
            int LA149_0 = input.LA(1);

            if ( (LA149_0==20) ) {
                alt149=1;
            }
            switch (alt149) {
                case 1 :
                    // InternalQVTbase.g:6609:5: otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) )
                    {
                    otherlv_2=(Token)match(input,20,FollowSets000.FOLLOW_61); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getLetVariableCSAccess().getColonKeyword_2_0());

                    }
                    // InternalQVTbase.g:6613:1: ( (lv_ownedType_3_0= ruleTypeExpCS ) )
                    // InternalQVTbase.g:6614:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    {
                    // InternalQVTbase.g:6614:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    // InternalQVTbase.g:6615:3: lv_ownedType_3_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {

                      	        newCompositeNode(grammarAccess.getLetVariableCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_71);
                    lv_ownedType_3_0=ruleTypeExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getLetVariableCSRule());
                      	        }
                             		set(
                             			current,
                             			"ownedType",
                              		lv_ownedType_3_0,
                              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeExpCS");
                      	        afterParserOrEnumRuleCall();

                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,21,FollowSets000.FOLLOW_69); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getLetVariableCSAccess().getEqualsSignKeyword_3());

            }
            // InternalQVTbase.g:6635:1: ( (lv_ownedInitExpression_5_0= ruleExpCS ) )
            // InternalQVTbase.g:6636:1: (lv_ownedInitExpression_5_0= ruleExpCS )
            {
            // InternalQVTbase.g:6636:1: (lv_ownedInitExpression_5_0= ruleExpCS )
            // InternalQVTbase.g:6637:3: lv_ownedInitExpression_5_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {

              	        newCompositeNode(grammarAccess.getLetVariableCSAccess().getOwnedInitExpressionExpCSParserRuleCall_4_0());

            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_ownedInitExpression_5_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLetVariableCSRule());
              	        }
                     		set(
                     			current,
                     			"ownedInitExpression",
                      		lv_ownedInitExpression_5_0,
                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
              	        afterParserOrEnumRuleCall();

            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLetVariableCS"


    // $ANTLR start "entryRuleNestedExpCS"
    // InternalQVTbase.g:6661:1: entryRuleNestedExpCS returns [EObject current=null] : iv_ruleNestedExpCS= ruleNestedExpCS EOF ;
    public final EObject entryRuleNestedExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNestedExpCS = null;


        try {
            // InternalQVTbase.g:6662:2: (iv_ruleNestedExpCS= ruleNestedExpCS EOF )
            // InternalQVTbase.g:6663:2: iv_ruleNestedExpCS= ruleNestedExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNestedExpCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNestedExpCS=ruleNestedExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNestedExpCS;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNestedExpCS"


    // $ANTLR start "ruleNestedExpCS"
    // InternalQVTbase.g:6670:1: ruleNestedExpCS returns [EObject current=null] : (otherlv_0= '(' ( (lv_ownedExpression_1_0= ruleExpCS ) ) otherlv_2= ')' ) ;
    public final EObject ruleNestedExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_ownedExpression_1_0 = null;


         enterRule();

        try {
            // InternalQVTbase.g:6673:28: ( (otherlv_0= '(' ( (lv_ownedExpression_1_0= ruleExpCS ) ) otherlv_2= ')' ) )
            // InternalQVTbase.g:6674:1: (otherlv_0= '(' ( (lv_ownedExpression_1_0= ruleExpCS ) ) otherlv_2= ')' )
            {
            // InternalQVTbase.g:6674:1: (otherlv_0= '(' ( (lv_ownedExpression_1_0= ruleExpCS ) ) otherlv_2= ')' )
            // InternalQVTbase.g:6674:3: otherlv_0= '(' ( (lv_ownedExpression_1_0= ruleExpCS ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,51,FollowSets000.FOLLOW_69); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getNestedExpCSAccess().getLeftParenthesisKeyword_0());

            }
            // InternalQVTbase.g:6678:1: ( (lv_ownedExpression_1_0= ruleExpCS ) )
            // InternalQVTbase.g:6679:1: (lv_ownedExpression_1_0= ruleExpCS )
            {
            // InternalQVTbase.g:6679:1: (lv_ownedExpression_1_0= ruleExpCS )
            // InternalQVTbase.g:6680:3: lv_ownedExpression_1_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {

              	        newCompositeNode(grammarAccess.getNestedExpCSAccess().getOwnedExpressionExpCSParserRuleCall_1_0());

            }
            pushFollow(FollowSets000.FOLLOW_62);
            lv_ownedExpression_1_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getNestedExpCSRule());
              	        }
                     		set(
                     			current,
                     			"ownedExpression",
                      		lv_ownedExpression_1_0,
                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
              	        afterParserOrEnumRuleCall();

            }

            }


            }

            otherlv_2=(Token)match(input,52,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getNestedExpCSAccess().getRightParenthesisKeyword_2());

            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNestedExpCS"


    // $ANTLR start "entryRuleSelfExpCS"
    // InternalQVTbase.g:6708:1: entryRuleSelfExpCS returns [EObject current=null] : iv_ruleSelfExpCS= ruleSelfExpCS EOF ;
    public final EObject entryRuleSelfExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelfExpCS = null;


        try {
            // InternalQVTbase.g:6709:2: (iv_ruleSelfExpCS= ruleSelfExpCS EOF )
            // InternalQVTbase.g:6710:2: iv_ruleSelfExpCS= ruleSelfExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSelfExpCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSelfExpCS=ruleSelfExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSelfExpCS;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSelfExpCS"


    // $ANTLR start "ruleSelfExpCS"
    // InternalQVTbase.g:6717:1: ruleSelfExpCS returns [EObject current=null] : ( () otherlv_1= 'self' ) ;
    public final EObject ruleSelfExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule();

        try {
            // InternalQVTbase.g:6720:28: ( ( () otherlv_1= 'self' ) )
            // InternalQVTbase.g:6721:1: ( () otherlv_1= 'self' )
            {
            // InternalQVTbase.g:6721:1: ( () otherlv_1= 'self' )
            // InternalQVTbase.g:6721:2: () otherlv_1= 'self'
            {
            // InternalQVTbase.g:6721:2: ()
            // InternalQVTbase.g:6722:2:
            {
            if ( state.backtracking==0 ) {

              	  /* */

            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getSelfExpCSAccess().getSelfExpCSAction_0(),
                          current);

            }

            }

            otherlv_1=(Token)match(input,118,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getSelfExpCSAccess().getSelfKeyword_1());

            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSelfExpCS"


    // $ANTLR start "entryRuleMultiplicityBoundsCS"
    // InternalQVTbase.g:6742:1: entryRuleMultiplicityBoundsCS returns [EObject current=null] : iv_ruleMultiplicityBoundsCS= ruleMultiplicityBoundsCS EOF ;
    public final EObject entryRuleMultiplicityBoundsCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicityBoundsCS = null;


        try {
            // InternalQVTbase.g:6743:2: (iv_ruleMultiplicityBoundsCS= ruleMultiplicityBoundsCS EOF )
            // InternalQVTbase.g:6744:2: iv_ruleMultiplicityBoundsCS= ruleMultiplicityBoundsCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicityBoundsCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMultiplicityBoundsCS=ruleMultiplicityBoundsCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicityBoundsCS;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMultiplicityBoundsCS"


    // $ANTLR start "ruleMultiplicityBoundsCS"
    // InternalQVTbase.g:6751:1: ruleMultiplicityBoundsCS returns [EObject current=null] : ( ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )? ) ;
    public final EObject ruleMultiplicityBoundsCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_lowerBound_0_0 = null;

        AntlrDatatypeRuleToken lv_upperBound_2_0 = null;


         enterRule();

        try {
            // InternalQVTbase.g:6754:28: ( ( ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )? ) )
            // InternalQVTbase.g:6755:1: ( ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )? )
            {
            // InternalQVTbase.g:6755:1: ( ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )? )
            // InternalQVTbase.g:6755:2: ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )?
            {
            // InternalQVTbase.g:6755:2: ( (lv_lowerBound_0_0= ruleLOWER ) )
            // InternalQVTbase.g:6756:1: (lv_lowerBound_0_0= ruleLOWER )
            {
            // InternalQVTbase.g:6756:1: (lv_lowerBound_0_0= ruleLOWER )
            // InternalQVTbase.g:6757:3: lv_lowerBound_0_0= ruleLOWER
            {
            if ( state.backtracking==0 ) {

              	        newCompositeNode(grammarAccess.getMultiplicityBoundsCSAccess().getLowerBoundLOWERParserRuleCall_0_0());

            }
            pushFollow(FollowSets000.FOLLOW_68);
            lv_lowerBound_0_0=ruleLOWER();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getMultiplicityBoundsCSRule());
              	        }
                     		set(
                     			current,
                     			"lowerBound",
                      		lv_lowerBound_0_0,
                      		"org.eclipse.ocl.xtext.base.Base.LOWER");
              	        afterParserOrEnumRuleCall();

            }

            }


            }

            // InternalQVTbase.g:6773:2: (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )?
            int alt150=2;
            int LA150_0 = input.LA(1);

            if ( (LA150_0==98) ) {
                alt150=1;
            }
            switch (alt150) {
                case 1 :
                    // InternalQVTbase.g:6773:4: otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) )
                    {
                    otherlv_1=(Token)match(input,98,FollowSets000.FOLLOW_96); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getMultiplicityBoundsCSAccess().getFullStopFullStopKeyword_1_0());

                    }
                    // InternalQVTbase.g:6777:1: ( (lv_upperBound_2_0= ruleUPPER ) )
                    // InternalQVTbase.g:6778:1: (lv_upperBound_2_0= ruleUPPER )
                    {
                    // InternalQVTbase.g:6778:1: (lv_upperBound_2_0= ruleUPPER )
                    // InternalQVTbase.g:6779:3: lv_upperBound_2_0= ruleUPPER
                    {
                    if ( state.backtracking==0 ) {

                      	        newCompositeNode(grammarAccess.getMultiplicityBoundsCSAccess().getUpperBoundUPPERParserRuleCall_1_1_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_upperBound_2_0=ruleUPPER();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getMultiplicityBoundsCSRule());
                      	        }
                             		set(
                             			current,
                             			"upperBound",
                              		lv_upperBound_2_0,
                              		"org.eclipse.ocl.xtext.base.Base.UPPER");
                      	        afterParserOrEnumRuleCall();

                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMultiplicityBoundsCS"


    // $ANTLR start "entryRuleMultiplicityCS"
    // InternalQVTbase.g:6803:1: entryRuleMultiplicityCS returns [EObject current=null] : iv_ruleMultiplicityCS= ruleMultiplicityCS EOF ;
    public final EObject entryRuleMultiplicityCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicityCS = null;


        try {
            // InternalQVTbase.g:6804:2: (iv_ruleMultiplicityCS= ruleMultiplicityCS EOF )
            // InternalQVTbase.g:6805:2: iv_ruleMultiplicityCS= ruleMultiplicityCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicityCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMultiplicityCS=ruleMultiplicityCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicityCS;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMultiplicityCS"


    // $ANTLR start "ruleMultiplicityCS"
    // InternalQVTbase.g:6812:1: ruleMultiplicityCS returns [EObject current=null] : (otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) (otherlv_3= '|?' | ( (lv_isNullFree_4_0= '|1' ) ) )? otherlv_5= ']' ) ;
    public final EObject ruleMultiplicityCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token lv_isNullFree_4_0=null;
        Token otherlv_5=null;
        EObject this_MultiplicityBoundsCS_1 = null;

        EObject this_MultiplicityStringCS_2 = null;


         enterRule();

        try {
            // InternalQVTbase.g:6815:28: ( (otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) (otherlv_3= '|?' | ( (lv_isNullFree_4_0= '|1' ) ) )? otherlv_5= ']' ) )
            // InternalQVTbase.g:6816:1: (otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) (otherlv_3= '|?' | ( (lv_isNullFree_4_0= '|1' ) ) )? otherlv_5= ']' )
            {
            // InternalQVTbase.g:6816:1: (otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) (otherlv_3= '|?' | ( (lv_isNullFree_4_0= '|1' ) ) )? otherlv_5= ']' )
            // InternalQVTbase.g:6816:3: otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) (otherlv_3= '|?' | ( (lv_isNullFree_4_0= '|1' ) ) )? otherlv_5= ']'
            {
            otherlv_0=(Token)match(input,108,FollowSets000.FOLLOW_97); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMultiplicityCSAccess().getLeftSquareBracketKeyword_0());

            }
            // InternalQVTbase.g:6820:1: (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS )
            int alt151=2;
            int LA151_0 = input.LA(1);

            if ( (LA151_0==RULE_INT) ) {
                alt151=1;
            }
            else if ( (LA151_0==67||LA151_0==69||LA151_0==121) ) {
                alt151=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 151, 0, input);

                throw nvae;
            }
            switch (alt151) {
                case 1 :
                    // InternalQVTbase.g:6821:2: this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS
                    {
                    if ( state.backtracking==0 ) {

                      	  /* */

                    }
                    if ( state.backtracking==0 ) {

                              newCompositeNode(grammarAccess.getMultiplicityCSAccess().getMultiplicityBoundsCSParserRuleCall_1_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_98);
                    this_MultiplicityBoundsCS_1=ruleMultiplicityBoundsCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_MultiplicityBoundsCS_1;
                              afterParserOrEnumRuleCall();

                    }

                    }
                    break;
                case 2 :
                    // InternalQVTbase.g:6834:2: this_MultiplicityStringCS_2= ruleMultiplicityStringCS
                    {
                    if ( state.backtracking==0 ) {

                      	  /* */

                    }
                    if ( state.backtracking==0 ) {

                              newCompositeNode(grammarAccess.getMultiplicityCSAccess().getMultiplicityStringCSParserRuleCall_1_1());

                    }
                    pushFollow(FollowSets000.FOLLOW_98);
                    this_MultiplicityStringCS_2=ruleMultiplicityStringCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_MultiplicityStringCS_2;
                              afterParserOrEnumRuleCall();

                    }

                    }
                    break;

            }

            // InternalQVTbase.g:6845:2: (otherlv_3= '|?' | ( (lv_isNullFree_4_0= '|1' ) ) )?
            int alt152=3;
            int LA152_0 = input.LA(1);

            if ( (LA152_0==119) ) {
                alt152=1;
            }
            else if ( (LA152_0==120) ) {
                alt152=2;
            }
            switch (alt152) {
                case 1 :
                    // InternalQVTbase.g:6845:4: otherlv_3= '|?'
                    {
                    otherlv_3=(Token)match(input,119,FollowSets000.FOLLOW_99); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getMultiplicityCSAccess().getVerticalLineQuestionMarkKeyword_2_0());

                    }

                    }
                    break;
                case 2 :
                    // InternalQVTbase.g:6850:6: ( (lv_isNullFree_4_0= '|1' ) )
                    {
                    // InternalQVTbase.g:6850:6: ( (lv_isNullFree_4_0= '|1' ) )
                    // InternalQVTbase.g:6851:1: (lv_isNullFree_4_0= '|1' )
                    {
                    // InternalQVTbase.g:6851:1: (lv_isNullFree_4_0= '|1' )
                    // InternalQVTbase.g:6852:3: lv_isNullFree_4_0= '|1'
                    {
                    lv_isNullFree_4_0=(Token)match(input,120,FollowSets000.FOLLOW_99); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_isNullFree_4_0, grammarAccess.getMultiplicityCSAccess().getIsNullFree1Keyword_2_1_0());

                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getMultiplicityCSRule());
                      	        }
                             		setWithLastConsumed(current, "isNullFree", true, "|1");

                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,109,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getMultiplicityCSAccess().getRightSquareBracketKeyword_3());

            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMultiplicityCS"


    // $ANTLR start "entryRuleMultiplicityStringCS"
    // InternalQVTbase.g:6877:1: entryRuleMultiplicityStringCS returns [EObject current=null] : iv_ruleMultiplicityStringCS= ruleMultiplicityStringCS EOF ;
    public final EObject entryRuleMultiplicityStringCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicityStringCS = null;


        try {
            // InternalQVTbase.g:6878:2: (iv_ruleMultiplicityStringCS= ruleMultiplicityStringCS EOF )
            // InternalQVTbase.g:6879:2: iv_ruleMultiplicityStringCS= ruleMultiplicityStringCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicityStringCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMultiplicityStringCS=ruleMultiplicityStringCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicityStringCS;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMultiplicityStringCS"


    // $ANTLR start "ruleMultiplicityStringCS"
    // InternalQVTbase.g:6886:1: ruleMultiplicityStringCS returns [EObject current=null] : ( ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) ) ) ;
    public final EObject ruleMultiplicityStringCS() throws RecognitionException {
        EObject current = null;

        Token lv_stringBounds_0_1=null;
        Token lv_stringBounds_0_2=null;
        Token lv_stringBounds_0_3=null;

         enterRule();

        try {
            // InternalQVTbase.g:6889:28: ( ( ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) ) ) )
            // InternalQVTbase.g:6890:1: ( ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) ) )
            {
            // InternalQVTbase.g:6890:1: ( ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) ) )
            // InternalQVTbase.g:6891:1: ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) )
            {
            // InternalQVTbase.g:6891:1: ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) )
            // InternalQVTbase.g:6892:1: (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' )
            {
            // InternalQVTbase.g:6892:1: (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' )
            int alt153=3;
            switch ( input.LA(1) ) {
            case 67:
                {
                alt153=1;
                }
                break;
            case 69:
                {
                alt153=2;
                }
                break;
            case 121:
                {
                alt153=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 153, 0, input);

                throw nvae;
            }

            switch (alt153) {
                case 1 :
                    // InternalQVTbase.g:6893:3: lv_stringBounds_0_1= '*'
                    {
                    lv_stringBounds_0_1=(Token)match(input,67,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_stringBounds_0_1, grammarAccess.getMultiplicityStringCSAccess().getStringBoundsAsteriskKeyword_0_0());

                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getMultiplicityStringCSRule());
                      	        }
                             		setWithLastConsumed(current, "stringBounds", lv_stringBounds_0_1, null);

                    }

                    }
                    break;
                case 2 :
                    // InternalQVTbase.g:6905:8: lv_stringBounds_0_2= '+'
                    {
                    lv_stringBounds_0_2=(Token)match(input,69,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_stringBounds_0_2, grammarAccess.getMultiplicityStringCSAccess().getStringBoundsPlusSignKeyword_0_1());

                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getMultiplicityStringCSRule());
                      	        }
                             		setWithLastConsumed(current, "stringBounds", lv_stringBounds_0_2, null);

                    }

                    }
                    break;
                case 3 :
                    // InternalQVTbase.g:6917:8: lv_stringBounds_0_3= '?'
                    {
                    lv_stringBounds_0_3=(Token)match(input,121,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_stringBounds_0_3, grammarAccess.getMultiplicityStringCSAccess().getStringBoundsQuestionMarkKeyword_0_2());

                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getMultiplicityStringCSRule());
                      	        }
                             		setWithLastConsumed(current, "stringBounds", lv_stringBounds_0_3, null);

                    }

                    }
                    break;

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMultiplicityStringCS"


    // $ANTLR start "entryRulePathNameCS"
    // InternalQVTbase.g:6940:1: entryRulePathNameCS returns [EObject current=null] : iv_rulePathNameCS= rulePathNameCS EOF ;
    public final EObject entryRulePathNameCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePathNameCS = null;


        try {
            // InternalQVTbase.g:6941:2: (iv_rulePathNameCS= rulePathNameCS EOF )
            // InternalQVTbase.g:6942:2: iv_rulePathNameCS= rulePathNameCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPathNameCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePathNameCS=rulePathNameCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePathNameCS;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePathNameCS"


    // $ANTLR start "rulePathNameCS"
    // InternalQVTbase.g:6949:1: rulePathNameCS returns [EObject current=null] : ( ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )* ) ;
    public final EObject rulePathNameCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_ownedPathElements_0_0 = null;

        EObject lv_ownedPathElements_2_0 = null;


         enterRule();

        try {
            // InternalQVTbase.g:6952:28: ( ( ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )* ) )
            // InternalQVTbase.g:6953:1: ( ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )* )
            {
            // InternalQVTbase.g:6953:1: ( ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )* )
            // InternalQVTbase.g:6953:2: ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )*
            {
            // InternalQVTbase.g:6953:2: ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) )
            // InternalQVTbase.g:6954:1: (lv_ownedPathElements_0_0= ruleFirstPathElementCS )
            {
            // InternalQVTbase.g:6954:1: (lv_ownedPathElements_0_0= ruleFirstPathElementCS )
            // InternalQVTbase.g:6955:3: lv_ownedPathElements_0_0= ruleFirstPathElementCS
            {
            if ( state.backtracking==0 ) {

              	        newCompositeNode(grammarAccess.getPathNameCSAccess().getOwnedPathElementsFirstPathElementCSParserRuleCall_0_0());

            }
            pushFollow(FollowSets000.FOLLOW_100);
            lv_ownedPathElements_0_0=ruleFirstPathElementCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getPathNameCSRule());
              	        }
                     		add(
                     			current,
                     			"ownedPathElements",
                      		lv_ownedPathElements_0_0,
                      		"org.eclipse.ocl.xtext.base.Base.FirstPathElementCS");
              	        afterParserOrEnumRuleCall();

            }

            }


            }

            // InternalQVTbase.g:6971:2: (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )*
            loop154:
            do {
                int alt154=2;
                int LA154_0 = input.LA(1);

                if ( (LA154_0==122) ) {
                    alt154=1;
                }


                switch (alt154) {
            	case 1 :
            	    // InternalQVTbase.g:6971:4: otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) )
            	    {
            	    otherlv_1=(Token)match(input,122,FollowSets000.FOLLOW_61); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getPathNameCSAccess().getColonColonKeyword_1_0());

            	    }
            	    // InternalQVTbase.g:6975:1: ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) )
            	    // InternalQVTbase.g:6976:1: (lv_ownedPathElements_2_0= ruleNextPathElementCS )
            	    {
            	    // InternalQVTbase.g:6976:1: (lv_ownedPathElements_2_0= ruleNextPathElementCS )
            	    // InternalQVTbase.g:6977:3: lv_ownedPathElements_2_0= ruleNextPathElementCS
            	    {
            	    if ( state.backtracking==0 ) {

            	      	        newCompositeNode(grammarAccess.getPathNameCSAccess().getOwnedPathElementsNextPathElementCSParserRuleCall_1_1_0());

            	    }
            	    pushFollow(FollowSets000.FOLLOW_100);
            	    lv_ownedPathElements_2_0=ruleNextPathElementCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getPathNameCSRule());
            	      	        }
            	             		add(
            	             			current,
            	             			"ownedPathElements",
            	              		lv_ownedPathElements_2_0,
            	              		"org.eclipse.ocl.xtext.base.Base.NextPathElementCS");
            	      	        afterParserOrEnumRuleCall();

            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop154;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePathNameCS"


    // $ANTLR start "entryRuleFirstPathElementCS"
    // InternalQVTbase.g:7001:1: entryRuleFirstPathElementCS returns [EObject current=null] : iv_ruleFirstPathElementCS= ruleFirstPathElementCS EOF ;
    public final EObject entryRuleFirstPathElementCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFirstPathElementCS = null;


        try {
            // InternalQVTbase.g:7002:2: (iv_ruleFirstPathElementCS= ruleFirstPathElementCS EOF )
            // InternalQVTbase.g:7003:2: iv_ruleFirstPathElementCS= ruleFirstPathElementCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFirstPathElementCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleFirstPathElementCS=ruleFirstPathElementCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFirstPathElementCS;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFirstPathElementCS"


    // $ANTLR start "ruleFirstPathElementCS"
    // InternalQVTbase.g:7010:1: ruleFirstPathElementCS returns [EObject current=null] : ( ( ruleUnrestrictedName ) ) ;
    public final EObject ruleFirstPathElementCS() throws RecognitionException {
        EObject current = null;

         enterRule();

        try {
            // InternalQVTbase.g:7013:28: ( ( ( ruleUnrestrictedName ) ) )
            // InternalQVTbase.g:7014:1: ( ( ruleUnrestrictedName ) )
            {
            // InternalQVTbase.g:7014:1: ( ( ruleUnrestrictedName ) )
            // InternalQVTbase.g:7015:1: ( ruleUnrestrictedName )
            {
            // InternalQVTbase.g:7015:1: ( ruleUnrestrictedName )
            // InternalQVTbase.g:7016:3: ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {

              		  /* */

            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getFirstPathElementCSRule());
              	        }

            }
            if ( state.backtracking==0 ) {

              	        newCompositeNode(grammarAccess.getFirstPathElementCSAccess().getReferredElementNamedElementCrossReference_0());

            }
            pushFollow(FollowSets000.FOLLOW_2);
            ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        afterParserOrEnumRuleCall();

            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFirstPathElementCS"


    // $ANTLR start "entryRuleNextPathElementCS"
    // InternalQVTbase.g:7040:1: entryRuleNextPathElementCS returns [EObject current=null] : iv_ruleNextPathElementCS= ruleNextPathElementCS EOF ;
    public final EObject entryRuleNextPathElementCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNextPathElementCS = null;


        try {
            // InternalQVTbase.g:7041:2: (iv_ruleNextPathElementCS= ruleNextPathElementCS EOF )
            // InternalQVTbase.g:7042:2: iv_ruleNextPathElementCS= ruleNextPathElementCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNextPathElementCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNextPathElementCS=ruleNextPathElementCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNextPathElementCS;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNextPathElementCS"


    // $ANTLR start "ruleNextPathElementCS"
    // InternalQVTbase.g:7049:1: ruleNextPathElementCS returns [EObject current=null] : ( ( ruleUnreservedName ) ) ;
    public final EObject ruleNextPathElementCS() throws RecognitionException {
        EObject current = null;

         enterRule();

        try {
            // InternalQVTbase.g:7052:28: ( ( ( ruleUnreservedName ) ) )
            // InternalQVTbase.g:7053:1: ( ( ruleUnreservedName ) )
            {
            // InternalQVTbase.g:7053:1: ( ( ruleUnreservedName ) )
            // InternalQVTbase.g:7054:1: ( ruleUnreservedName )
            {
            // InternalQVTbase.g:7054:1: ( ruleUnreservedName )
            // InternalQVTbase.g:7055:3: ruleUnreservedName
            {
            if ( state.backtracking==0 ) {

              		  /* */

            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getNextPathElementCSRule());
              	        }

            }
            if ( state.backtracking==0 ) {

              	        newCompositeNode(grammarAccess.getNextPathElementCSAccess().getReferredElementNamedElementCrossReference_0());

            }
            pushFollow(FollowSets000.FOLLOW_2);
            ruleUnreservedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        afterParserOrEnumRuleCall();

            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNextPathElementCS"


    // $ANTLR start "entryRuleTemplateBindingCS"
    // InternalQVTbase.g:7079:1: entryRuleTemplateBindingCS returns [EObject current=null] : iv_ruleTemplateBindingCS= ruleTemplateBindingCS EOF ;
    public final EObject entryRuleTemplateBindingCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTemplateBindingCS = null;


        try {
            // InternalQVTbase.g:7080:2: (iv_ruleTemplateBindingCS= ruleTemplateBindingCS EOF )
            // InternalQVTbase.g:7081:2: iv_ruleTemplateBindingCS= ruleTemplateBindingCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTemplateBindingCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTemplateBindingCS=ruleTemplateBindingCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTemplateBindingCS;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTemplateBindingCS"


    // $ANTLR start "ruleTemplateBindingCS"
    // InternalQVTbase.g:7088:1: ruleTemplateBindingCS returns [EObject current=null] : ( ( (lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS ) ) (otherlv_1= ',' ( (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS ) ) )* ( (lv_ownedMultiplicity_3_0= ruleMultiplicityCS ) )? ) ;
    public final EObject ruleTemplateBindingCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_ownedSubstitutions_0_0 = null;

        EObject lv_ownedSubstitutions_2_0 = null;

        EObject lv_ownedMultiplicity_3_0 = null;


         enterRule();

        try {
            // InternalQVTbase.g:7091:28: ( ( ( (lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS ) ) (otherlv_1= ',' ( (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS ) ) )* ( (lv_ownedMultiplicity_3_0= ruleMultiplicityCS ) )? ) )
            // InternalQVTbase.g:7092:1: ( ( (lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS ) ) (otherlv_1= ',' ( (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS ) ) )* ( (lv_ownedMultiplicity_3_0= ruleMultiplicityCS ) )? )
            {
            // InternalQVTbase.g:7092:1: ( ( (lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS ) ) (otherlv_1= ',' ( (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS ) ) )* ( (lv_ownedMultiplicity_3_0= ruleMultiplicityCS ) )? )
            // InternalQVTbase.g:7092:2: ( (lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS ) ) (otherlv_1= ',' ( (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS ) ) )* ( (lv_ownedMultiplicity_3_0= ruleMultiplicityCS ) )?
            {
            // InternalQVTbase.g:7092:2: ( (lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS ) )
            // InternalQVTbase.g:7093:1: (lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS )
            {
            // InternalQVTbase.g:7093:1: (lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS )
            // InternalQVTbase.g:7094:3: lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS
            {
            if ( state.backtracking==0 ) {

              	        newCompositeNode(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsTemplateParameterSubstitutionCSParserRuleCall_0_0());

            }
            pushFollow(FollowSets000.FOLLOW_101);
            lv_ownedSubstitutions_0_0=ruleTemplateParameterSubstitutionCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTemplateBindingCSRule());
              	        }
                     		add(
                     			current,
                     			"ownedSubstitutions",
                      		lv_ownedSubstitutions_0_0,
                      		"org.eclipse.ocl.xtext.base.Base.TemplateParameterSubstitutionCS");
              	        afterParserOrEnumRuleCall();

            }

            }


            }

            // InternalQVTbase.g:7110:2: (otherlv_1= ',' ( (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS ) ) )*
            loop155:
            do {
                int alt155=2;
                int LA155_0 = input.LA(1);

                if ( (LA155_0==39) ) {
                    alt155=1;
                }


                switch (alt155) {
            	case 1 :
            	    // InternalQVTbase.g:7110:4: otherlv_1= ',' ( (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS ) )
            	    {
            	    otherlv_1=(Token)match(input,39,FollowSets000.FOLLOW_102); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getTemplateBindingCSAccess().getCommaKeyword_1_0());

            	    }
            	    // InternalQVTbase.g:7114:1: ( (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS ) )
            	    // InternalQVTbase.g:7115:1: (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS )
            	    {
            	    // InternalQVTbase.g:7115:1: (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS )
            	    // InternalQVTbase.g:7116:3: lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS
            	    {
            	    if ( state.backtracking==0 ) {

            	      	        newCompositeNode(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsTemplateParameterSubstitutionCSParserRuleCall_1_1_0());

            	    }
            	    pushFollow(FollowSets000.FOLLOW_101);
            	    lv_ownedSubstitutions_2_0=ruleTemplateParameterSubstitutionCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getTemplateBindingCSRule());
            	      	        }
            	             		add(
            	             			current,
            	             			"ownedSubstitutions",
            	              		lv_ownedSubstitutions_2_0,
            	              		"org.eclipse.ocl.xtext.base.Base.TemplateParameterSubstitutionCS");
            	      	        afterParserOrEnumRuleCall();

            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop155;
                }
            } while (true);

            // InternalQVTbase.g:7132:4: ( (lv_ownedMultiplicity_3_0= ruleMultiplicityCS ) )?
            int alt156=2;
            int LA156_0 = input.LA(1);

            if ( (LA156_0==108) ) {
                alt156=1;
            }
            switch (alt156) {
                case 1 :
                    // InternalQVTbase.g:7133:1: (lv_ownedMultiplicity_3_0= ruleMultiplicityCS )
                    {
                    // InternalQVTbase.g:7133:1: (lv_ownedMultiplicity_3_0= ruleMultiplicityCS )
                    // InternalQVTbase.g:7134:3: lv_ownedMultiplicity_3_0= ruleMultiplicityCS
                    {
                    if ( state.backtracking==0 ) {

                      	        newCompositeNode(grammarAccess.getTemplateBindingCSAccess().getOwnedMultiplicityMultiplicityCSParserRuleCall_2_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_ownedMultiplicity_3_0=ruleMultiplicityCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTemplateBindingCSRule());
                      	        }
                             		set(
                             			current,
                             			"ownedMultiplicity",
                              		lv_ownedMultiplicity_3_0,
                              		"org.eclipse.ocl.xtext.base.Base.MultiplicityCS");
                      	        afterParserOrEnumRuleCall();

                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTemplateBindingCS"


    // $ANTLR start "entryRuleTemplateParameterSubstitutionCS"
    // InternalQVTbase.g:7158:1: entryRuleTemplateParameterSubstitutionCS returns [EObject current=null] : iv_ruleTemplateParameterSubstitutionCS= ruleTemplateParameterSubstitutionCS EOF ;
    public final EObject entryRuleTemplateParameterSubstitutionCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTemplateParameterSubstitutionCS = null;


        try {
            // InternalQVTbase.g:7159:2: (iv_ruleTemplateParameterSubstitutionCS= ruleTemplateParameterSubstitutionCS EOF )
            // InternalQVTbase.g:7160:2: iv_ruleTemplateParameterSubstitutionCS= ruleTemplateParameterSubstitutionCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTemplateParameterSubstitutionCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTemplateParameterSubstitutionCS=ruleTemplateParameterSubstitutionCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTemplateParameterSubstitutionCS;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTemplateParameterSubstitutionCS"


    // $ANTLR start "ruleTemplateParameterSubstitutionCS"
    // InternalQVTbase.g:7167:1: ruleTemplateParameterSubstitutionCS returns [EObject current=null] : ( (lv_ownedActualParameter_0_0= ruleTypeRefCS ) ) ;
    public final EObject ruleTemplateParameterSubstitutionCS() throws RecognitionException {
        EObject current = null;

        EObject lv_ownedActualParameter_0_0 = null;


         enterRule();

        try {
            // InternalQVTbase.g:7170:28: ( ( (lv_ownedActualParameter_0_0= ruleTypeRefCS ) ) )
            // InternalQVTbase.g:7171:1: ( (lv_ownedActualParameter_0_0= ruleTypeRefCS ) )
            {
            // InternalQVTbase.g:7171:1: ( (lv_ownedActualParameter_0_0= ruleTypeRefCS ) )
            // InternalQVTbase.g:7172:1: (lv_ownedActualParameter_0_0= ruleTypeRefCS )
            {
            // InternalQVTbase.g:7172:1: (lv_ownedActualParameter_0_0= ruleTypeRefCS )
            // InternalQVTbase.g:7173:3: lv_ownedActualParameter_0_0= ruleTypeRefCS
            {
            if ( state.backtracking==0 ) {

              	        newCompositeNode(grammarAccess.getTemplateParameterSubstitutionCSAccess().getOwnedActualParameterTypeRefCSParserRuleCall_0());

            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_ownedActualParameter_0_0=ruleTypeRefCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTemplateParameterSubstitutionCSRule());
              	        }
                     		set(
                     			current,
                     			"ownedActualParameter",
                      		lv_ownedActualParameter_0_0,
                      		"org.eclipse.ocl.xtext.base.Base.TypeRefCS");
              	        afterParserOrEnumRuleCall();

            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTemplateParameterSubstitutionCS"


    // $ANTLR start "entryRuleTemplateSignatureCS"
    // InternalQVTbase.g:7197:1: entryRuleTemplateSignatureCS returns [EObject current=null] : iv_ruleTemplateSignatureCS= ruleTemplateSignatureCS EOF ;
    public final EObject entryRuleTemplateSignatureCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTemplateSignatureCS = null;


        try {
            // InternalQVTbase.g:7198:2: (iv_ruleTemplateSignatureCS= ruleTemplateSignatureCS EOF )
            // InternalQVTbase.g:7199:2: iv_ruleTemplateSignatureCS= ruleTemplateSignatureCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTemplateSignatureCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTemplateSignatureCS=ruleTemplateSignatureCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTemplateSignatureCS;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTemplateSignatureCS"


    // $ANTLR start "ruleTemplateSignatureCS"
    // InternalQVTbase.g:7206:1: ruleTemplateSignatureCS returns [EObject current=null] : (otherlv_0= '(' ( (lv_ownedParameters_1_0= ruleTypeParameterCS ) ) (otherlv_2= ',' ( (lv_ownedParameters_3_0= ruleTypeParameterCS ) ) )* otherlv_4= ')' ) ;
    public final EObject ruleTemplateSignatureCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_ownedParameters_1_0 = null;

        EObject lv_ownedParameters_3_0 = null;


         enterRule();

        try {
            // InternalQVTbase.g:7209:28: ( (otherlv_0= '(' ( (lv_ownedParameters_1_0= ruleTypeParameterCS ) ) (otherlv_2= ',' ( (lv_ownedParameters_3_0= ruleTypeParameterCS ) ) )* otherlv_4= ')' ) )
            // InternalQVTbase.g:7210:1: (otherlv_0= '(' ( (lv_ownedParameters_1_0= ruleTypeParameterCS ) ) (otherlv_2= ',' ( (lv_ownedParameters_3_0= ruleTypeParameterCS ) ) )* otherlv_4= ')' )
            {
            // InternalQVTbase.g:7210:1: (otherlv_0= '(' ( (lv_ownedParameters_1_0= ruleTypeParameterCS ) ) (otherlv_2= ',' ( (lv_ownedParameters_3_0= ruleTypeParameterCS ) ) )* otherlv_4= ')' )
            // InternalQVTbase.g:7210:3: otherlv_0= '(' ( (lv_ownedParameters_1_0= ruleTypeParameterCS ) ) (otherlv_2= ',' ( (lv_ownedParameters_3_0= ruleTypeParameterCS ) ) )* otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,51,FollowSets000.FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getTemplateSignatureCSAccess().getLeftParenthesisKeyword_0());

            }
            // InternalQVTbase.g:7214:1: ( (lv_ownedParameters_1_0= ruleTypeParameterCS ) )
            // InternalQVTbase.g:7215:1: (lv_ownedParameters_1_0= ruleTypeParameterCS )
            {
            // InternalQVTbase.g:7215:1: (lv_ownedParameters_1_0= ruleTypeParameterCS )
            // InternalQVTbase.g:7216:3: lv_ownedParameters_1_0= ruleTypeParameterCS
            {
            if ( state.backtracking==0 ) {

              	        newCompositeNode(grammarAccess.getTemplateSignatureCSAccess().getOwnedParametersTypeParameterCSParserRuleCall_1_0());

            }
            pushFollow(FollowSets000.FOLLOW_32);
            lv_ownedParameters_1_0=ruleTypeParameterCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTemplateSignatureCSRule());
              	        }
                     		add(
                     			current,
                     			"ownedParameters",
                      		lv_ownedParameters_1_0,
                      		"org.eclipse.ocl.xtext.base.Base.TypeParameterCS");
              	        afterParserOrEnumRuleCall();

            }

            }


            }

            // InternalQVTbase.g:7232:2: (otherlv_2= ',' ( (lv_ownedParameters_3_0= ruleTypeParameterCS ) ) )*
            loop157:
            do {
                int alt157=2;
                int LA157_0 = input.LA(1);

                if ( (LA157_0==39) ) {
                    alt157=1;
                }


                switch (alt157) {
            	case 1 :
            	    // InternalQVTbase.g:7232:4: otherlv_2= ',' ( (lv_ownedParameters_3_0= ruleTypeParameterCS ) )
            	    {
            	    otherlv_2=(Token)match(input,39,FollowSets000.FOLLOW_6); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getTemplateSignatureCSAccess().getCommaKeyword_2_0());

            	    }
            	    // InternalQVTbase.g:7236:1: ( (lv_ownedParameters_3_0= ruleTypeParameterCS ) )
            	    // InternalQVTbase.g:7237:1: (lv_ownedParameters_3_0= ruleTypeParameterCS )
            	    {
            	    // InternalQVTbase.g:7237:1: (lv_ownedParameters_3_0= ruleTypeParameterCS )
            	    // InternalQVTbase.g:7238:3: lv_ownedParameters_3_0= ruleTypeParameterCS
            	    {
            	    if ( state.backtracking==0 ) {

            	      	        newCompositeNode(grammarAccess.getTemplateSignatureCSAccess().getOwnedParametersTypeParameterCSParserRuleCall_2_1_0());

            	    }
            	    pushFollow(FollowSets000.FOLLOW_32);
            	    lv_ownedParameters_3_0=ruleTypeParameterCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getTemplateSignatureCSRule());
            	      	        }
            	             		add(
            	             			current,
            	             			"ownedParameters",
            	              		lv_ownedParameters_3_0,
            	              		"org.eclipse.ocl.xtext.base.Base.TypeParameterCS");
            	      	        afterParserOrEnumRuleCall();

            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop157;
                }
            } while (true);

            otherlv_4=(Token)match(input,52,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getTemplateSignatureCSAccess().getRightParenthesisKeyword_3());

            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTemplateSignatureCS"


    // $ANTLR start "entryRuleTypeParameterCS"
    // InternalQVTbase.g:7266:1: entryRuleTypeParameterCS returns [EObject current=null] : iv_ruleTypeParameterCS= ruleTypeParameterCS EOF ;
    public final EObject entryRuleTypeParameterCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeParameterCS = null;


        try {
            // InternalQVTbase.g:7267:2: (iv_ruleTypeParameterCS= ruleTypeParameterCS EOF )
            // InternalQVTbase.g:7268:2: iv_ruleTypeParameterCS= ruleTypeParameterCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeParameterCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTypeParameterCS=ruleTypeParameterCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeParameterCS;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypeParameterCS"


    // $ANTLR start "ruleTypeParameterCS"
    // InternalQVTbase.g:7275:1: ruleTypeParameterCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleTypedRefCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) ) )* )? ) ;
    public final EObject ruleTypeParameterCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedExtends_2_0 = null;

        EObject lv_ownedExtends_4_0 = null;


         enterRule();

        try {
            // InternalQVTbase.g:7278:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleTypedRefCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) ) )* )? ) )
            // InternalQVTbase.g:7279:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleTypedRefCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) ) )* )? )
            {
            // InternalQVTbase.g:7279:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleTypedRefCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) ) )* )? )
            // InternalQVTbase.g:7279:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleTypedRefCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) ) )* )?
            {
            // InternalQVTbase.g:7279:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // InternalQVTbase.g:7280:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // InternalQVTbase.g:7280:1: (lv_name_0_0= ruleUnrestrictedName )
            // InternalQVTbase.g:7281:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {

              	        newCompositeNode(grammarAccess.getTypeParameterCSAccess().getNameUnrestrictedNameParserRuleCall_0_0());

            }
            pushFollow(FollowSets000.FOLLOW_103);
            lv_name_0_0=ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTypeParameterCSRule());
              	        }
                     		set(
                     			current,
                     			"name",
                      		lv_name_0_0,
                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.UnrestrictedName");
              	        afterParserOrEnumRuleCall();

            }

            }


            }

            // InternalQVTbase.g:7297:2: (otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleTypedRefCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) ) )* )?
            int alt159=2;
            int LA159_0 = input.LA(1);

            if ( (LA159_0==63) ) {
                alt159=1;
            }
            switch (alt159) {
                case 1 :
                    // InternalQVTbase.g:7297:4: otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleTypedRefCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) ) )*
                    {
                    otherlv_1=(Token)match(input,63,FollowSets000.FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getTypeParameterCSAccess().getExtendsKeyword_1_0());

                    }
                    // InternalQVTbase.g:7301:1: ( (lv_ownedExtends_2_0= ruleTypedRefCS ) )
                    // InternalQVTbase.g:7302:1: (lv_ownedExtends_2_0= ruleTypedRefCS )
                    {
                    // InternalQVTbase.g:7302:1: (lv_ownedExtends_2_0= ruleTypedRefCS )
                    // InternalQVTbase.g:7303:3: lv_ownedExtends_2_0= ruleTypedRefCS
                    {
                    if ( state.backtracking==0 ) {

                      	        newCompositeNode(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsTypedRefCSParserRuleCall_1_1_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_104);
                    lv_ownedExtends_2_0=ruleTypedRefCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTypeParameterCSRule());
                      	        }
                             		add(
                             			current,
                             			"ownedExtends",
                              		lv_ownedExtends_2_0,
                              		"org.eclipse.ocl.xtext.base.Base.TypedRefCS");
                      	        afterParserOrEnumRuleCall();

                    }

                    }


                    }

                    // InternalQVTbase.g:7319:2: (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) ) )*
                    loop158:
                    do {
                        int alt158=2;
                        int LA158_0 = input.LA(1);

                        if ( (LA158_0==123) ) {
                            alt158=1;
                        }


                        switch (alt158) {
                    	case 1 :
                    	    // InternalQVTbase.g:7319:4: otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) )
                    	    {
                    	    otherlv_3=(Token)match(input,123,FollowSets000.FOLLOW_6); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getTypeParameterCSAccess().getAmpersandAmpersandKeyword_1_2_0());

                    	    }
                    	    // InternalQVTbase.g:7323:1: ( (lv_ownedExtends_4_0= ruleTypedRefCS ) )
                    	    // InternalQVTbase.g:7324:1: (lv_ownedExtends_4_0= ruleTypedRefCS )
                    	    {
                    	    // InternalQVTbase.g:7324:1: (lv_ownedExtends_4_0= ruleTypedRefCS )
                    	    // InternalQVTbase.g:7325:3: lv_ownedExtends_4_0= ruleTypedRefCS
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      	        newCompositeNode(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsTypedRefCSParserRuleCall_1_2_1_0());

                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_104);
                    	    lv_ownedExtends_4_0=ruleTypedRefCS();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getTypeParameterCSRule());
                    	      	        }
                    	             		add(
                    	             			current,
                    	             			"ownedExtends",
                    	              		lv_ownedExtends_4_0,
                    	              		"org.eclipse.ocl.xtext.base.Base.TypedRefCS");
                    	      	        afterParserOrEnumRuleCall();

                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop158;
                        }
                    } while (true);


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypeParameterCS"


    // $ANTLR start "entryRuleTypeRefCS"
    // InternalQVTbase.g:7349:1: entryRuleTypeRefCS returns [EObject current=null] : iv_ruleTypeRefCS= ruleTypeRefCS EOF ;
    public final EObject entryRuleTypeRefCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeRefCS = null;


        try {
            // InternalQVTbase.g:7350:2: (iv_ruleTypeRefCS= ruleTypeRefCS EOF )
            // InternalQVTbase.g:7351:2: iv_ruleTypeRefCS= ruleTypeRefCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeRefCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTypeRefCS=ruleTypeRefCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeRefCS;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypeRefCS"


    // $ANTLR start "ruleTypeRefCS"
    // InternalQVTbase.g:7358:1: ruleTypeRefCS returns [EObject current=null] : (this_TypedRefCS_0= ruleTypedRefCS | this_WildcardTypeRefCS_1= ruleWildcardTypeRefCS ) ;
    public final EObject ruleTypeRefCS() throws RecognitionException {
        EObject current = null;

        EObject this_TypedRefCS_0 = null;

        EObject this_WildcardTypeRefCS_1 = null;


         enterRule();

        try {
            // InternalQVTbase.g:7361:28: ( (this_TypedRefCS_0= ruleTypedRefCS | this_WildcardTypeRefCS_1= ruleWildcardTypeRefCS ) )
            // InternalQVTbase.g:7362:1: (this_TypedRefCS_0= ruleTypedRefCS | this_WildcardTypeRefCS_1= ruleWildcardTypeRefCS )
            {
            // InternalQVTbase.g:7362:1: (this_TypedRefCS_0= ruleTypedRefCS | this_WildcardTypeRefCS_1= ruleWildcardTypeRefCS )
            int alt160=2;
            int LA160_0 = input.LA(1);

            if ( ((LA160_0>=RULE_SIMPLE_ID && LA160_0<=RULE_ESCAPED_ID)) ) {
                alt160=1;
            }
            else if ( (LA160_0==121) ) {
                alt160=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 160, 0, input);

                throw nvae;
            }
            switch (alt160) {
                case 1 :
                    // InternalQVTbase.g:7363:2: this_TypedRefCS_0= ruleTypedRefCS
                    {
                    if ( state.backtracking==0 ) {

                      	  /* */

                    }
                    if ( state.backtracking==0 ) {

                              newCompositeNode(grammarAccess.getTypeRefCSAccess().getTypedRefCSParserRuleCall_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_TypedRefCS_0=ruleTypedRefCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_TypedRefCS_0;
                              afterParserOrEnumRuleCall();

                    }

                    }
                    break;
                case 2 :
                    // InternalQVTbase.g:7376:2: this_WildcardTypeRefCS_1= ruleWildcardTypeRefCS
                    {
                    if ( state.backtracking==0 ) {

                      	  /* */

                    }
                    if ( state.backtracking==0 ) {

                              newCompositeNode(grammarAccess.getTypeRefCSAccess().getWildcardTypeRefCSParserRuleCall_1());

                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_WildcardTypeRefCS_1=ruleWildcardTypeRefCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_WildcardTypeRefCS_1;
                              afterParserOrEnumRuleCall();

                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypeRefCS"


    // $ANTLR start "entryRuleTypedRefCS"
    // InternalQVTbase.g:7395:1: entryRuleTypedRefCS returns [EObject current=null] : iv_ruleTypedRefCS= ruleTypedRefCS EOF ;
    public final EObject entryRuleTypedRefCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypedRefCS = null;


        try {
            // InternalQVTbase.g:7396:2: (iv_ruleTypedRefCS= ruleTypedRefCS EOF )
            // InternalQVTbase.g:7397:2: iv_ruleTypedRefCS= ruleTypedRefCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypedRefCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTypedRefCS=ruleTypedRefCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypedRefCS;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypedRefCS"


    // $ANTLR start "ruleTypedRefCS"
    // InternalQVTbase.g:7404:1: ruleTypedRefCS returns [EObject current=null] : this_TypedTypeRefCS_0= ruleTypedTypeRefCS ;
    public final EObject ruleTypedRefCS() throws RecognitionException {
        EObject current = null;

        EObject this_TypedTypeRefCS_0 = null;


         enterRule();

        try {
            // InternalQVTbase.g:7407:28: (this_TypedTypeRefCS_0= ruleTypedTypeRefCS )
            // InternalQVTbase.g:7409:2: this_TypedTypeRefCS_0= ruleTypedTypeRefCS
            {
            if ( state.backtracking==0 ) {

              	  /* */

            }
            if ( state.backtracking==0 ) {

                      newCompositeNode(grammarAccess.getTypedRefCSAccess().getTypedTypeRefCSParserRuleCall());

            }
            pushFollow(FollowSets000.FOLLOW_2);
            this_TypedTypeRefCS_0=ruleTypedTypeRefCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current = this_TypedTypeRefCS_0;
                      afterParserOrEnumRuleCall();

            }

            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypedRefCS"


    // $ANTLR start "entryRuleTypedTypeRefCS"
    // InternalQVTbase.g:7428:1: entryRuleTypedTypeRefCS returns [EObject current=null] : iv_ruleTypedTypeRefCS= ruleTypedTypeRefCS EOF ;
    public final EObject entryRuleTypedTypeRefCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypedTypeRefCS = null;


        try {
            // InternalQVTbase.g:7429:2: (iv_ruleTypedTypeRefCS= ruleTypedTypeRefCS EOF )
            // InternalQVTbase.g:7430:2: iv_ruleTypedTypeRefCS= ruleTypedTypeRefCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypedTypeRefCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTypedTypeRefCS=ruleTypedTypeRefCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypedTypeRefCS;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypedTypeRefCS"


    // $ANTLR start "ruleTypedTypeRefCS"
    // InternalQVTbase.g:7437:1: ruleTypedTypeRefCS returns [EObject current=null] : ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) (otherlv_1= '(' ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) ) otherlv_3= ')' )? ) ;
    public final EObject ruleTypedTypeRefCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_ownedPathName_0_0 = null;

        EObject lv_ownedBinding_2_0 = null;


         enterRule();

        try {
            // InternalQVTbase.g:7440:28: ( ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) (otherlv_1= '(' ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) ) otherlv_3= ')' )? ) )
            // InternalQVTbase.g:7441:1: ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) (otherlv_1= '(' ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) ) otherlv_3= ')' )? )
            {
            // InternalQVTbase.g:7441:1: ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) (otherlv_1= '(' ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) ) otherlv_3= ')' )? )
            // InternalQVTbase.g:7441:2: ( (lv_ownedPathName_0_0= rulePathNameCS ) ) (otherlv_1= '(' ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) ) otherlv_3= ')' )?
            {
            // InternalQVTbase.g:7441:2: ( (lv_ownedPathName_0_0= rulePathNameCS ) )
            // InternalQVTbase.g:7442:1: (lv_ownedPathName_0_0= rulePathNameCS )
            {
            // InternalQVTbase.g:7442:1: (lv_ownedPathName_0_0= rulePathNameCS )
            // InternalQVTbase.g:7443:3: lv_ownedPathName_0_0= rulePathNameCS
            {
            if ( state.backtracking==0 ) {

              	        newCompositeNode(grammarAccess.getTypedTypeRefCSAccess().getOwnedPathNamePathNameCSParserRuleCall_0_0());

            }
            pushFollow(FollowSets000.FOLLOW_60);
            lv_ownedPathName_0_0=rulePathNameCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTypedTypeRefCSRule());
              	        }
                     		set(
                     			current,
                     			"ownedPathName",
                      		lv_ownedPathName_0_0,
                      		"org.eclipse.ocl.xtext.base.Base.PathNameCS");
              	        afterParserOrEnumRuleCall();

            }

            }


            }

            // InternalQVTbase.g:7459:2: (otherlv_1= '(' ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) ) otherlv_3= ')' )?
            int alt161=2;
            int LA161_0 = input.LA(1);

            if ( (LA161_0==51) ) {
                alt161=1;
            }
            switch (alt161) {
                case 1 :
                    // InternalQVTbase.g:7459:4: otherlv_1= '(' ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) ) otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,51,FollowSets000.FOLLOW_102); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getTypedTypeRefCSAccess().getLeftParenthesisKeyword_1_0());

                    }
                    // InternalQVTbase.g:7463:1: ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) )
                    // InternalQVTbase.g:7464:1: (lv_ownedBinding_2_0= ruleTemplateBindingCS )
                    {
                    // InternalQVTbase.g:7464:1: (lv_ownedBinding_2_0= ruleTemplateBindingCS )
                    // InternalQVTbase.g:7465:3: lv_ownedBinding_2_0= ruleTemplateBindingCS
                    {
                    if ( state.backtracking==0 ) {

                      	        newCompositeNode(grammarAccess.getTypedTypeRefCSAccess().getOwnedBindingTemplateBindingCSParserRuleCall_1_1_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_62);
                    lv_ownedBinding_2_0=ruleTemplateBindingCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTypedTypeRefCSRule());
                      	        }
                             		set(
                             			current,
                             			"ownedBinding",
                              		lv_ownedBinding_2_0,
                              		"org.eclipse.ocl.xtext.base.Base.TemplateBindingCS");
                      	        afterParserOrEnumRuleCall();

                    }

                    }


                    }

                    otherlv_3=(Token)match(input,52,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getTypedTypeRefCSAccess().getRightParenthesisKeyword_1_2());

                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypedTypeRefCS"


    // $ANTLR start "entryRuleWildcardTypeRefCS"
    // InternalQVTbase.g:7493:1: entryRuleWildcardTypeRefCS returns [EObject current=null] : iv_ruleWildcardTypeRefCS= ruleWildcardTypeRefCS EOF ;
    public final EObject entryRuleWildcardTypeRefCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWildcardTypeRefCS = null;


        try {
            // InternalQVTbase.g:7494:2: (iv_ruleWildcardTypeRefCS= ruleWildcardTypeRefCS EOF )
            // InternalQVTbase.g:7495:2: iv_ruleWildcardTypeRefCS= ruleWildcardTypeRefCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getWildcardTypeRefCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleWildcardTypeRefCS=ruleWildcardTypeRefCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleWildcardTypeRefCS;
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleWildcardTypeRefCS"


    // $ANTLR start "ruleWildcardTypeRefCS"
    // InternalQVTbase.g:7502:1: ruleWildcardTypeRefCS returns [EObject current=null] : ( () otherlv_1= '?' (otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleTypedRefCS ) ) )? ) ;
    public final EObject ruleWildcardTypeRefCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_ownedExtends_3_0 = null;


         enterRule();

        try {
            // InternalQVTbase.g:7505:28: ( ( () otherlv_1= '?' (otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleTypedRefCS ) ) )? ) )
            // InternalQVTbase.g:7506:1: ( () otherlv_1= '?' (otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleTypedRefCS ) ) )? )
            {
            // InternalQVTbase.g:7506:1: ( () otherlv_1= '?' (otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleTypedRefCS ) ) )? )
            // InternalQVTbase.g:7506:2: () otherlv_1= '?' (otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleTypedRefCS ) ) )?
            {
            // InternalQVTbase.g:7506:2: ()
            // InternalQVTbase.g:7507:2:
            {
            if ( state.backtracking==0 ) {

              	  /* */

            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getWildcardTypeRefCSAccess().getWildcardTypeRefCSAction_0(),
                          current);

            }

            }

            otherlv_1=(Token)match(input,121,FollowSets000.FOLLOW_103); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getWildcardTypeRefCSAccess().getQuestionMarkKeyword_1());

            }
            // InternalQVTbase.g:7519:1: (otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleTypedRefCS ) ) )?
            int alt162=2;
            int LA162_0 = input.LA(1);

            if ( (LA162_0==63) ) {
                alt162=1;
            }
            switch (alt162) {
                case 1 :
                    // InternalQVTbase.g:7519:3: otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleTypedRefCS ) )
                    {
                    otherlv_2=(Token)match(input,63,FollowSets000.FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getWildcardTypeRefCSAccess().getExtendsKeyword_2_0());

                    }
                    // InternalQVTbase.g:7523:1: ( (lv_ownedExtends_3_0= ruleTypedRefCS ) )
                    // InternalQVTbase.g:7524:1: (lv_ownedExtends_3_0= ruleTypedRefCS )
                    {
                    // InternalQVTbase.g:7524:1: (lv_ownedExtends_3_0= ruleTypedRefCS )
                    // InternalQVTbase.g:7525:3: lv_ownedExtends_3_0= ruleTypedRefCS
                    {
                    if ( state.backtracking==0 ) {

                      	        newCompositeNode(grammarAccess.getWildcardTypeRefCSAccess().getOwnedExtendsTypedRefCSParserRuleCall_2_1_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_ownedExtends_3_0=ruleTypedRefCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getWildcardTypeRefCSRule());
                      	        }
                             		set(
                             			current,
                             			"ownedExtends",
                              		lv_ownedExtends_3_0,
                              		"org.eclipse.ocl.xtext.base.Base.TypedRefCS");
                      	        afterParserOrEnumRuleCall();

                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWildcardTypeRefCS"


    // $ANTLR start "entryRuleID"
    // InternalQVTbase.g:7549:1: entryRuleID returns [String current=null] : iv_ruleID= ruleID EOF ;
    public final String entryRuleID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleID = null;


        try {
            // InternalQVTbase.g:7550:2: (iv_ruleID= ruleID EOF )
            // InternalQVTbase.g:7551:2: iv_ruleID= ruleID EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIDRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleID=ruleID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleID.getText();
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleID"


    // $ANTLR start "ruleID"
    // InternalQVTbase.g:7558:1: ruleID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_SIMPLE_ID_0= RULE_SIMPLE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID ) ;
    public final AntlrDatatypeRuleToken ruleID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_SIMPLE_ID_0=null;
        Token this_ESCAPED_ID_1=null;

         enterRule();

        try {
            // InternalQVTbase.g:7561:28: ( (this_SIMPLE_ID_0= RULE_SIMPLE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID ) )
            // InternalQVTbase.g:7562:1: (this_SIMPLE_ID_0= RULE_SIMPLE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID )
            {
            // InternalQVTbase.g:7562:1: (this_SIMPLE_ID_0= RULE_SIMPLE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID )
            int alt163=2;
            int LA163_0 = input.LA(1);

            if ( (LA163_0==RULE_SIMPLE_ID) ) {
                alt163=1;
            }
            else if ( (LA163_0==RULE_ESCAPED_ID) ) {
                alt163=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 163, 0, input);

                throw nvae;
            }
            switch (alt163) {
                case 1 :
                    // InternalQVTbase.g:7562:6: this_SIMPLE_ID_0= RULE_SIMPLE_ID
                    {
                    this_SIMPLE_ID_0=(Token)match(input,RULE_SIMPLE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SIMPLE_ID_0);

                    }
                    if ( state.backtracking==0 ) {

                          newLeafNode(this_SIMPLE_ID_0, grammarAccess.getIDAccess().getSIMPLE_IDTerminalRuleCall_0());

                    }

                    }
                    break;
                case 2 :
                    // InternalQVTbase.g:7570:10: this_ESCAPED_ID_1= RULE_ESCAPED_ID
                    {
                    this_ESCAPED_ID_1=(Token)match(input,RULE_ESCAPED_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_ESCAPED_ID_1);

                    }
                    if ( state.backtracking==0 ) {

                          newLeafNode(this_ESCAPED_ID_1, grammarAccess.getIDAccess().getESCAPED_IDTerminalRuleCall_1());

                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleID"


    // $ANTLR start "entryRuleIdentifier"
    // InternalQVTbase.g:7585:1: entryRuleIdentifier returns [String current=null] : iv_ruleIdentifier= ruleIdentifier EOF ;
    public final String entryRuleIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdentifier = null;


        try {
            // InternalQVTbase.g:7586:2: (iv_ruleIdentifier= ruleIdentifier EOF )
            // InternalQVTbase.g:7587:2: iv_ruleIdentifier= ruleIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIdentifierRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleIdentifier=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIdentifier.getText();
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIdentifier"


    // $ANTLR start "ruleIdentifier"
    // InternalQVTbase.g:7594:1: ruleIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= ruleID ;
    public final AntlrDatatypeRuleToken ruleIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_ID_0 = null;


         enterRule();

        try {
            // InternalQVTbase.g:7597:28: (this_ID_0= ruleID )
            // InternalQVTbase.g:7599:5: this_ID_0= ruleID
            {
            if ( state.backtracking==0 ) {

                      newCompositeNode(grammarAccess.getIdentifierAccess().getIDParserRuleCall());

            }
            pushFollow(FollowSets000.FOLLOW_2);
            this_ID_0=ruleID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);

            }
            if ( state.backtracking==0 ) {

                      afterParserOrEnumRuleCall();

            }

            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIdentifier"


    // $ANTLR start "entryRuleLOWER"
    // InternalQVTbase.g:7617:1: entryRuleLOWER returns [String current=null] : iv_ruleLOWER= ruleLOWER EOF ;
    public final String entryRuleLOWER() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLOWER = null;


        try {
            // InternalQVTbase.g:7618:2: (iv_ruleLOWER= ruleLOWER EOF )
            // InternalQVTbase.g:7619:2: iv_ruleLOWER= ruleLOWER EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLOWERRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleLOWER=ruleLOWER();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLOWER.getText();
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLOWER"


    // $ANTLR start "ruleLOWER"
    // InternalQVTbase.g:7626:1: ruleLOWER returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INT_0= RULE_INT ;
    public final AntlrDatatypeRuleToken ruleLOWER() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;

         enterRule();

        try {
            // InternalQVTbase.g:7629:28: (this_INT_0= RULE_INT )
            // InternalQVTbase.g:7630:5: this_INT_0= RULE_INT
            {
            this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_INT_0);

            }
            if ( state.backtracking==0 ) {

                  newLeafNode(this_INT_0, grammarAccess.getLOWERAccess().getINTTerminalRuleCall());

            }

            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLOWER"


    // $ANTLR start "entryRuleNUMBER_LITERAL"
    // InternalQVTbase.g:7645:1: entryRuleNUMBER_LITERAL returns [String current=null] : iv_ruleNUMBER_LITERAL= ruleNUMBER_LITERAL EOF ;
    public final String entryRuleNUMBER_LITERAL() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNUMBER_LITERAL = null;


        try {
            // InternalQVTbase.g:7646:2: (iv_ruleNUMBER_LITERAL= ruleNUMBER_LITERAL EOF )
            // InternalQVTbase.g:7647:2: iv_ruleNUMBER_LITERAL= ruleNUMBER_LITERAL EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNUMBER_LITERALRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNUMBER_LITERAL=ruleNUMBER_LITERAL();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNUMBER_LITERAL.getText();
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNUMBER_LITERAL"


    // $ANTLR start "ruleNUMBER_LITERAL"
    // InternalQVTbase.g:7654:1: ruleNUMBER_LITERAL returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INT_0= RULE_INT ;
    public final AntlrDatatypeRuleToken ruleNUMBER_LITERAL() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;

         enterRule();

        try {
            // InternalQVTbase.g:7657:28: (this_INT_0= RULE_INT )
            // InternalQVTbase.g:7658:5: this_INT_0= RULE_INT
            {
            this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_INT_0);

            }
            if ( state.backtracking==0 ) {

                  newLeafNode(this_INT_0, grammarAccess.getNUMBER_LITERALAccess().getINTTerminalRuleCall());

            }

            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNUMBER_LITERAL"


    // $ANTLR start "entryRuleStringLiteral"
    // InternalQVTbase.g:7673:1: entryRuleStringLiteral returns [String current=null] : iv_ruleStringLiteral= ruleStringLiteral EOF ;
    public final String entryRuleStringLiteral() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleStringLiteral = null;


        try {
            // InternalQVTbase.g:7674:2: (iv_ruleStringLiteral= ruleStringLiteral EOF )
            // InternalQVTbase.g:7675:2: iv_ruleStringLiteral= ruleStringLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStringLiteralRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleStringLiteral=ruleStringLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStringLiteral.getText();
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStringLiteral"


    // $ANTLR start "ruleStringLiteral"
    // InternalQVTbase.g:7682:1: ruleStringLiteral returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING ;
    public final AntlrDatatypeRuleToken ruleStringLiteral() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_SINGLE_QUOTED_STRING_0=null;

         enterRule();

        try {
            // InternalQVTbase.g:7685:28: (this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING )
            // InternalQVTbase.g:7686:5: this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING
            {
            this_SINGLE_QUOTED_STRING_0=(Token)match(input,RULE_SINGLE_QUOTED_STRING,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_SINGLE_QUOTED_STRING_0);

            }
            if ( state.backtracking==0 ) {

                  newLeafNode(this_SINGLE_QUOTED_STRING_0, grammarAccess.getStringLiteralAccess().getSINGLE_QUOTED_STRINGTerminalRuleCall());

            }

            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStringLiteral"


    // $ANTLR start "entryRuleUPPER"
    // InternalQVTbase.g:7701:1: entryRuleUPPER returns [String current=null] : iv_ruleUPPER= ruleUPPER EOF ;
    public final String entryRuleUPPER() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUPPER = null;


        try {
            // InternalQVTbase.g:7702:2: (iv_ruleUPPER= ruleUPPER EOF )
            // InternalQVTbase.g:7703:2: iv_ruleUPPER= ruleUPPER EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUPPERRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUPPER=ruleUPPER();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUPPER.getText();
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUPPER"


    // $ANTLR start "ruleUPPER"
    // InternalQVTbase.g:7710:1: ruleUPPER returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT | kw= '*' ) ;
    public final AntlrDatatypeRuleToken ruleUPPER() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;

         enterRule();

        try {
            // InternalQVTbase.g:7713:28: ( (this_INT_0= RULE_INT | kw= '*' ) )
            // InternalQVTbase.g:7714:1: (this_INT_0= RULE_INT | kw= '*' )
            {
            // InternalQVTbase.g:7714:1: (this_INT_0= RULE_INT | kw= '*' )
            int alt164=2;
            int LA164_0 = input.LA(1);

            if ( (LA164_0==RULE_INT) ) {
                alt164=1;
            }
            else if ( (LA164_0==67) ) {
                alt164=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 164, 0, input);

                throw nvae;
            }
            switch (alt164) {
                case 1 :
                    // InternalQVTbase.g:7714:6: this_INT_0= RULE_INT
                    {
                    this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_INT_0);

                    }
                    if ( state.backtracking==0 ) {

                          newLeafNode(this_INT_0, grammarAccess.getUPPERAccess().getINTTerminalRuleCall_0());

                    }

                    }
                    break;
                case 2 :
                    // InternalQVTbase.g:7723:2: kw= '*'
                    {
                    kw=(Token)match(input,67,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUPPERAccess().getAsteriskKeyword_1());

                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUPPER"


    // $ANTLR start "entryRuleURI"
    // InternalQVTbase.g:7736:1: entryRuleURI returns [String current=null] : iv_ruleURI= ruleURI EOF ;
    public final String entryRuleURI() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleURI = null;


        try {
            // InternalQVTbase.g:7737:2: (iv_ruleURI= ruleURI EOF )
            // InternalQVTbase.g:7738:2: iv_ruleURI= ruleURI EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getURIRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleURI=ruleURI();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleURI.getText();
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleURI"


    // $ANTLR start "ruleURI"
    // InternalQVTbase.g:7745:1: ruleURI returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING ;
    public final AntlrDatatypeRuleToken ruleURI() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_SINGLE_QUOTED_STRING_0=null;

         enterRule();

        try {
            // InternalQVTbase.g:7748:28: (this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING )
            // InternalQVTbase.g:7749:5: this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING
            {
            this_SINGLE_QUOTED_STRING_0=(Token)match(input,RULE_SINGLE_QUOTED_STRING,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_SINGLE_QUOTED_STRING_0);

            }
            if ( state.backtracking==0 ) {

                  newLeafNode(this_SINGLE_QUOTED_STRING_0, grammarAccess.getURIAccess().getSINGLE_QUOTED_STRINGTerminalRuleCall());

            }

            }

            if ( state.backtracking==0 ) {
               leaveRule();
            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleURI"

    // $ANTLR start synpred193_InternalQVTbase
    public final void synpred193_InternalQVTbase_fragment() throws RecognitionException {
        EObject this_TypeLiteralCS_1 = null;


        // InternalQVTbase.g:4948:2: (this_TypeLiteralCS_1= ruleTypeLiteralCS )
        // InternalQVTbase.g:4948:2: this_TypeLiteralCS_1= ruleTypeLiteralCS
        {
        if ( state.backtracking==0 ) {

          	  /* */

        }
        pushFollow(FollowSets000.FOLLOW_2);
        this_TypeLiteralCS_1=ruleTypeLiteralCS();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred193_InternalQVTbase

    // $ANTLR start synpred196_InternalQVTbase
    public final void synpred196_InternalQVTbase_fragment() throws RecognitionException {
        EObject this_PrefixedPrimaryExpCS_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_ownedRight_3_0 = null;


        // InternalQVTbase.g:5011:2: ( (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? ) )
        // InternalQVTbase.g:5011:2: (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? )
        {
        // InternalQVTbase.g:5011:2: (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? )
        // InternalQVTbase.g:5012:2: this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )?
        {
        if ( state.backtracking==0 ) {

          	  /* */

        }
        pushFollow(FollowSets000.FOLLOW_76);
        this_PrefixedPrimaryExpCS_0=rulePrefixedPrimaryExpCS();

        state._fsp--;
        if (state.failed) return ;
        // InternalQVTbase.g:5023:1: ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )?
        int alt231=2;
        int LA231_0 = input.LA(1);

        if ( (LA231_0==21||LA231_0==65||(LA231_0>=67 && LA231_0<=82)) ) {
            alt231=1;
        }
        switch (alt231) {
            case 1 :
                // InternalQVTbase.g:5023:2: () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) )
                {
                // InternalQVTbase.g:5023:2: ()
                // InternalQVTbase.g:5024:2:
                {
                if ( state.backtracking==0 ) {

                  	  /* */

                }

                }

                // InternalQVTbase.g:5032:2: ( (lv_name_2_0= ruleBinaryOperatorName ) )
                // InternalQVTbase.g:5033:1: (lv_name_2_0= ruleBinaryOperatorName )
                {
                // InternalQVTbase.g:5033:1: (lv_name_2_0= ruleBinaryOperatorName )
                // InternalQVTbase.g:5034:3: lv_name_2_0= ruleBinaryOperatorName
                {
                if ( state.backtracking==0 ) {

                  	        newCompositeNode(grammarAccess.getExpCSAccess().getNameBinaryOperatorNameParserRuleCall_0_1_1_0());

                }
                pushFollow(FollowSets000.FOLLOW_69);
                lv_name_2_0=ruleBinaryOperatorName();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // InternalQVTbase.g:5050:2: ( (lv_ownedRight_3_0= ruleExpCS ) )
                // InternalQVTbase.g:5051:1: (lv_ownedRight_3_0= ruleExpCS )
                {
                // InternalQVTbase.g:5051:1: (lv_ownedRight_3_0= ruleExpCS )
                // InternalQVTbase.g:5052:3: lv_ownedRight_3_0= ruleExpCS
                {
                if ( state.backtracking==0 ) {

                  	        newCompositeNode(grammarAccess.getExpCSAccess().getOwnedRightExpCSParserRuleCall_0_1_2_0());

                }
                pushFollow(FollowSets000.FOLLOW_2);
                lv_ownedRight_3_0=ruleExpCS();

                state._fsp--;
                if (state.failed) return ;

                }


                }


                }
                break;

        }


        }


        }
    }
    // $ANTLR end synpred196_InternalQVTbase

    // $ANTLR start synpred203_InternalQVTbase
    public final void synpred203_InternalQVTbase_fragment() throws RecognitionException {
        EObject this_TupleLiteralExpCS_4 = null;


        // InternalQVTbase.g:5313:2: (this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS )
        // InternalQVTbase.g:5313:2: this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS
        {
        if ( state.backtracking==0 ) {

          	  /* */

        }
        pushFollow(FollowSets000.FOLLOW_2);
        this_TupleLiteralExpCS_4=ruleTupleLiteralExpCS();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred203_InternalQVTbase

    // $ANTLR start synpred204_InternalQVTbase
    public final void synpred204_InternalQVTbase_fragment() throws RecognitionException {
        EObject this_MapLiteralExpCS_5 = null;


        // InternalQVTbase.g:5326:2: (this_MapLiteralExpCS_5= ruleMapLiteralExpCS )
        // InternalQVTbase.g:5326:2: this_MapLiteralExpCS_5= ruleMapLiteralExpCS
        {
        if ( state.backtracking==0 ) {

          	  /* */

        }
        pushFollow(FollowSets000.FOLLOW_2);
        this_MapLiteralExpCS_5=ruleMapLiteralExpCS();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred204_InternalQVTbase

    // $ANTLR start synpred205_InternalQVTbase
    public final void synpred205_InternalQVTbase_fragment() throws RecognitionException {
        EObject this_CollectionLiteralExpCS_6 = null;


        // InternalQVTbase.g:5339:2: (this_CollectionLiteralExpCS_6= ruleCollectionLiteralExpCS )
        // InternalQVTbase.g:5339:2: this_CollectionLiteralExpCS_6= ruleCollectionLiteralExpCS
        {
        if ( state.backtracking==0 ) {

          	  /* */

        }
        pushFollow(FollowSets000.FOLLOW_2);
        this_CollectionLiteralExpCS_6=ruleCollectionLiteralExpCS();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred205_InternalQVTbase

    // $ANTLR start synpred207_InternalQVTbase
    public final void synpred207_InternalQVTbase_fragment() throws RecognitionException {
        EObject this_TypeLiteralExpCS_8 = null;


        // InternalQVTbase.g:5365:2: (this_TypeLiteralExpCS_8= ruleTypeLiteralExpCS )
        // InternalQVTbase.g:5365:2: this_TypeLiteralExpCS_8= ruleTypeLiteralExpCS
        {
        if ( state.backtracking==0 ) {

          	  /* */

        }
        pushFollow(FollowSets000.FOLLOW_2);
        this_TypeLiteralExpCS_8=ruleTypeLiteralExpCS();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred207_InternalQVTbase

    // Delegated rules

    public final boolean synpred204_InternalQVTbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred204_InternalQVTbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred196_InternalQVTbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred196_InternalQVTbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred203_InternalQVTbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred203_InternalQVTbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred193_InternalQVTbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred193_InternalQVTbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred207_InternalQVTbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred207_InternalQVTbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred205_InternalQVTbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred205_InternalQVTbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA116 dfa116 = new DFA116(this);
    protected DFA119 dfa119 = new DFA119(this);
    protected DFA122 dfa122 = new DFA122(this);
    static final String dfa_1s = "\23\uffff";
    static final String dfa_2s = "\1\7\12\uffff\5\0\3\uffff";
    static final String dfa_3s = "\1\141\12\uffff\5\0\3\uffff";
    static final String dfa_4s = "\1\uffff\1\1\1\uffff\1\2\16\uffff\1\3";
    static final String dfa_5s = "\13\uffff\1\0\1\1\1\2\1\3\1\4\3\uffff}>";
    static final String[] dfa_6s = {
            "\2\1\112\uffff\12\3\1\13\1\14\1\15\1\16\1\17",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA116 extends DFA {

        public DFA116(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 116;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "4934:2: (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS | this_CollectionPatternCS_2= ruleCollectionPatternCS )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 :
                        int LA116_11 = input.LA(1);


                        int index116_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred193_InternalQVTbase()) ) {s = 3;}

                        else if ( (true) ) {s = 18;}


                        input.seek(index116_11);
                        if ( s>=0 ) return s;
                        break;
                    case 1 :
                        int LA116_12 = input.LA(1);


                        int index116_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred193_InternalQVTbase()) ) {s = 3;}

                        else if ( (true) ) {s = 18;}


                        input.seek(index116_12);
                        if ( s>=0 ) return s;
                        break;
                    case 2 :
                        int LA116_13 = input.LA(1);


                        int index116_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred193_InternalQVTbase()) ) {s = 3;}

                        else if ( (true) ) {s = 18;}


                        input.seek(index116_13);
                        if ( s>=0 ) return s;
                        break;
                    case 3 :
                        int LA116_14 = input.LA(1);


                        int index116_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred193_InternalQVTbase()) ) {s = 3;}

                        else if ( (true) ) {s = 18;}


                        input.seek(index116_14);
                        if ( s>=0 ) return s;
                        break;
                    case 4 :
                        int LA116_15 = input.LA(1);


                        int index116_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred193_InternalQVTbase()) ) {s = 3;}

                        else if ( (true) ) {s = 18;}


                        input.seek(index116_15);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 116, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_7s = "\40\uffff";
    static final String dfa_8s = "\1\4\2\0\35\uffff";
    static final String dfa_9s = "\1\166\2\0\35\uffff";
    static final String dfa_10s = "\3\uffff\1\1\33\uffff\1\2";
    static final String dfa_11s = "\1\uffff\1\0\1\1\35\uffff}>";
    static final String[] dfa_12s = {
            "\1\3\1\uffff\3\3\52\uffff\1\3\15\uffff\1\1\1\2\1\3\17\uffff\17\3\2\uffff\1\3\1\uffff\4\3\6\uffff\1\3\4\uffff\1\37\1\3",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_7 = DFA.unpackEncodedString(dfa_7s);
    static final char[] dfa_8 = DFA.unpackEncodedStringToUnsignedChars(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final short[] dfa_10 = DFA.unpackEncodedString(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[][] dfa_12 = unpackEncodedStringArray(dfa_12s);

    class DFA119 extends DFA {

        public DFA119(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 119;
            this.eot = dfa_7;
            this.eof = dfa_7;
            this.min = dfa_8;
            this.max = dfa_9;
            this.accept = dfa_10;
            this.special = dfa_11;
            this.transition = dfa_12;
        }
        public String getDescription() {
            return "5011:1: ( (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? ) | this_PrefixedLetExpCS_4= rulePrefixedLetExpCS )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 :
                        int LA119_1 = input.LA(1);


                        int index119_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred196_InternalQVTbase()) ) {s = 3;}

                        else if ( (true) ) {s = 31;}


                        input.seek(index119_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 :
                        int LA119_2 = input.LA(1);


                        int index119_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred196_InternalQVTbase()) ) {s = 3;}

                        else if ( (true) ) {s = 31;}


                        input.seek(index119_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 119, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_13s = "\1\4\12\uffff\7\0\16\uffff";
    static final String dfa_14s = "\1\166\12\uffff\7\0\16\uffff";
    static final String dfa_15s = "\1\uffff\1\1\1\2\1\3\1\4\15\uffff\1\10\1\11\7\uffff\1\12\1\uffff\1\5\1\6\1\7";
    static final String dfa_16s = "\13\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\16\uffff}>";
    static final String[] dfa_17s = {
            "\1\4\1\uffff\1\4\2\33\52\uffff\1\1\17\uffff\1\4\17\uffff\1\14\1\13\10\23\1\15\1\16\1\17\1\20\1\21\2\uffff\1\22\1\uffff\4\4\6\uffff\1\2\5\uffff\1\3",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };
    static final char[] dfa_13 = DFA.unpackEncodedStringToUnsignedChars(dfa_13s);
    static final char[] dfa_14 = DFA.unpackEncodedStringToUnsignedChars(dfa_14s);
    static final short[] dfa_15 = DFA.unpackEncodedString(dfa_15s);
    static final short[] dfa_16 = DFA.unpackEncodedString(dfa_16s);
    static final short[][] dfa_17 = unpackEncodedStringArray(dfa_17s);

    class DFA122 extends DFA {

        public DFA122(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 122;
            this.eot = dfa_7;
            this.eof = dfa_7;
            this.min = dfa_13;
            this.max = dfa_14;
            this.accept = dfa_15;
            this.special = dfa_16;
            this.transition = dfa_17;
        }
        public String getDescription() {
            return "5260:1: (this_NestedExpCS_0= ruleNestedExpCS | this_IfExpCS_1= ruleIfExpCS | this_SelfExpCS_2= ruleSelfExpCS | this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS | this_MapLiteralExpCS_5= ruleMapLiteralExpCS | this_CollectionLiteralExpCS_6= ruleCollectionLiteralExpCS | this_LambdaLiteralExpCS_7= ruleLambdaLiteralExpCS | this_TypeLiteralExpCS_8= ruleTypeLiteralExpCS | this_NameExpCS_9= ruleNameExpCS )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 :
                        int LA122_11 = input.LA(1);


                        int index122_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred203_InternalQVTbase()) ) {s = 29;}

                        else if ( (synpred207_InternalQVTbase()) ) {s = 19;}


                        input.seek(index122_11);
                        if ( s>=0 ) return s;
                        break;
                    case 1 :
                        int LA122_12 = input.LA(1);


                        int index122_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred204_InternalQVTbase()) ) {s = 30;}

                        else if ( (synpred207_InternalQVTbase()) ) {s = 19;}


                        input.seek(index122_12);
                        if ( s>=0 ) return s;
                        break;
                    case 2 :
                        int LA122_13 = input.LA(1);


                        int index122_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred205_InternalQVTbase()) ) {s = 31;}

                        else if ( (synpred207_InternalQVTbase()) ) {s = 19;}


                        input.seek(index122_13);
                        if ( s>=0 ) return s;
                        break;
                    case 3 :
                        int LA122_14 = input.LA(1);


                        int index122_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred205_InternalQVTbase()) ) {s = 31;}

                        else if ( (synpred207_InternalQVTbase()) ) {s = 19;}


                        input.seek(index122_14);
                        if ( s>=0 ) return s;
                        break;
                    case 4 :
                        int LA122_15 = input.LA(1);


                        int index122_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred205_InternalQVTbase()) ) {s = 31;}

                        else if ( (synpred207_InternalQVTbase()) ) {s = 19;}


                        input.seek(index122_15);
                        if ( s>=0 ) return s;
                        break;
                    case 5 :
                        int LA122_16 = input.LA(1);


                        int index122_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred205_InternalQVTbase()) ) {s = 31;}

                        else if ( (synpred207_InternalQVTbase()) ) {s = 19;}


                        input.seek(index122_16);
                        if ( s>=0 ) return s;
                        break;
                    case 6 :
                        int LA122_17 = input.LA(1);


                        int index122_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred205_InternalQVTbase()) ) {s = 31;}

                        else if ( (synpred207_InternalQVTbase()) ) {s = 19;}


                        input.seek(index122_17);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 122, _s, input);
            error(nvae);
            throw nvae;
        }
    }



    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x00000000000C0000L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x00000000000A0000L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000180L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000040000700000L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000040000600000L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000040000400000L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000007FFF800000L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x000001FFFF800000L});
        public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000017FFF800000L});
        public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x00000B0000000000L});
        public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000100180L});
        public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x00080400000001F0L,0x006103D3FFF8000EL});
        public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000040000000000L});
        public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000200000000000L});
        public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0008040000500000L});
        public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000040000500000L});
        public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000C10000000000L});
        public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000010000000000L});
        public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0002010000000180L});
        public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000040L,0x0000000000000002L});
        public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0004000000040000L});
        public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0004000000000000L});
        public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0004000000020000L});
        public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0008000000000180L});
        public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0008000000000000L});
        public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0010000000000180L});
        public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0010008000000000L});
        public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0020040000500000L});
        public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0020040000400000L});
        public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000048000400000L});
        public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000619800000L});
        public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000018619800000L});
        public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000010619800000L});
        public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0040010000000000L});
        public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000500002L});
        public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000400002L});
        public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000618000000L});
        public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000018618000000L});
        public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000010618000000L});
        public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0080000000040000L});
        public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0080000000000000L});
        public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0080000000020000L});
        public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0100040000700000L});
        public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x1E00007FF9800000L});
        public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x1E0001FFF9800000L});
        public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x1E00017FF9800000L});
        public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x4000000000000000L});
        public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x8008040000500000L});
        public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x8000040000500000L});
        public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000048000500000L});
        public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000010000000000L,0x0000000000000001L});
        public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x00840100000E0000L});
        public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000000000002L,0x0000100000000000L});
        public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0008000000000002L});
        public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000000000180L,0x00000003FFF80000L});
        public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0010000000000000L});
        public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000008000000000L});
        public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x00080100001001D0L,0x006103D3FFF8000EL});
        public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000018000000000L});
        public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x00080000001001D0L,0x006103D3FFF8000EL});
        public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000000000000002L,0x0000000400000000L});
        public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x00080000000001D0L,0x006103D3FFF8000EL});
        public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000008000000000L,0x0000000800000000L});
        public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x00080100000001D0L,0x006103D3FFF8000EL});
        public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0000000000000000L,0x0000002000000000L});
        public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000000000300000L});
        public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x0000000000200002L,0x000000000007FFFAL});
        public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x00080000000001D0L,0x004103D3FFF8000EL});
        public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x0008000000400002L,0x0000140000000000L});
        public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x0000000000400002L,0x0000040000000000L});
        public static final BitSet FOLLOW_80 = new BitSet(new long[]{0x0000000000000002L,0x0000040000000000L});
        public static final BitSet FOLLOW_81 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
        public static final BitSet FOLLOW_82 = new BitSet(new long[]{0x0000010000000190L});
        public static final BitSet FOLLOW_83 = new BitSet(new long[]{0x0000000000000190L});
        public static final BitSet FOLLOW_84 = new BitSet(new long[]{0x00180000001001D0L,0x006103D3FFF8000EL});
        public static final BitSet FOLLOW_85 = new BitSet(new long[]{0x0010048000000000L,0x0000800000000000L});
        public static final BitSet FOLLOW_86 = new BitSet(new long[]{0x0010008000000000L,0x0000800000000000L});
        public static final BitSet FOLLOW_87 = new BitSet(new long[]{0x0000008000000000L,0x0000200000000000L});
        public static final BitSet FOLLOW_88 = new BitSet(new long[]{0x0000000000100002L,0x0000400000000000L});
        public static final BitSet FOLLOW_89 = new BitSet(new long[]{0x0000000000200002L});
        public static final BitSet FOLLOW_90 = new BitSet(new long[]{0x0000000000100002L});
        public static final BitSet FOLLOW_91 = new BitSet(new long[]{0x0000000000000000L,0x0002000000000000L});
        public static final BitSet FOLLOW_92 = new BitSet(new long[]{0x0000000000000000L,0x0014000000000000L});
        public static final BitSet FOLLOW_93 = new BitSet(new long[]{0x0000000000000000L,0x0008000000000000L});
        public static final BitSet FOLLOW_94 = new BitSet(new long[]{0x0000008000000000L,0x0000400000000000L});
        public static final BitSet FOLLOW_95 = new BitSet(new long[]{0x0008000000300000L});
        public static final BitSet FOLLOW_96 = new BitSet(new long[]{0x0000000000000040L,0x0000000000000008L});
        public static final BitSet FOLLOW_97 = new BitSet(new long[]{0x0000000000000040L,0x0200000000000028L});
        public static final BitSet FOLLOW_98 = new BitSet(new long[]{0x0000000000000000L,0x0180200000000000L});
        public static final BitSet FOLLOW_99 = new BitSet(new long[]{0x0000000000000000L,0x0000200000000000L});
        public static final BitSet FOLLOW_100 = new BitSet(new long[]{0x0000000000000002L,0x0400000000000000L});
        public static final BitSet FOLLOW_101 = new BitSet(new long[]{0x0000008000000002L,0x0000100000000000L});
        public static final BitSet FOLLOW_102 = new BitSet(new long[]{0x0000000000000180L,0x0200000000000000L});
        public static final BitSet FOLLOW_103 = new BitSet(new long[]{0x8000000000000002L});
        public static final BitSet FOLLOW_104 = new BitSet(new long[]{0x0000000000000002L,0x0800000000000000L});
    }


}