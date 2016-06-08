package org.eclipse.qvtd.xtext.qvtcore.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.qvtd.xtext.qvtcore.services.QVTcoreGrammarAccess;



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
public class InternalQVTcoreParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_SIMPLE_ID", "RULE_ESCAPED_ID", "RULE_INT", "RULE_SINGLE_QUOTED_STRING", "RULE_ESCAPED_CHARACTER", "RULE_LETTER_CHARACTER", "RULE_DOUBLE_QUOTED_STRING", "RULE_ML_SINGLE_QUOTED_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'default'", "'map'", "'in'", "'refines'", "','", "'{'", "'where'", "'}'", "'|'", "'imports'", "'uses'", "'('", "')'", "':'", "'import'", "'::'", "'*'", "';'", "'check'", "'enforce'", "':='", "'query'", "'transformation'", "'realize'", "'library'", "'-'", "'not'", "'/'", "'+'", "'>'", "'<'", "'>='", "'<='", "'='", "'<>'", "'and'", "'or'", "'xor'", "'implies'", "'.'", "'->'", "'?.'", "'?->'", "'Map'", "'Tuple'", "'Boolean'", "'Integer'", "'Real'", "'String'", "'UnlimitedNatural'", "'OclAny'", "'OclInvalid'", "'OclVoid'", "'Set'", "'Bag'", "'Sequence'", "'Collection'", "'OrderedSet'", "'..'", "'++'", "'Lambda'", "'<-'", "'true'", "'false'", "'invalid'", "'null'", "'@'", "'pre'", "'['", "']'", "'if'", "'then'", "'else'", "'endif'", "'elseif'", "'let'", "'self'", "'|?'", "'|1'", "'?'", "'extends'", "'&&'"
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
    public static final int RULE_ML_COMMENT=12;
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
    public static final int RULE_SINGLE_QUOTED_STRING=7;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int RULE_DOUBLE_QUOTED_STRING=10;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int RULE_ESCAPED_ID=5;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__91=91;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__94=94;
    public static final int T__90=90;
    public static final int RULE_LETTER_CHARACTER=9;
    public static final int T__19=19;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int RULE_ESCAPED_CHARACTER=8;
    public static final int T__95=95;
    public static final int RULE_ML_SINGLE_QUOTED_STRING=11;
    public static final int T__96=96;
    public static final int T__97=97;
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
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_SL_COMMENT=13;
    public static final int T__77=77;
    public static final int T__78=78;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__75=75;
    public static final int T__76=76;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int RULE_SIMPLE_ID=4;
    public static final int T__83=83;
    public static final int RULE_WS=14;
    public static final int RULE_ANY_OTHER=15;
    public static final int T__88=88;
    public static final int T__89=89;
    public static final int T__84=84;
    public static final int T__85=85;
    public static final int T__86=86;
    public static final int T__87=87;

    // delegates
    // delegators


        public InternalQVTcoreParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalQVTcoreParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalQVTcoreParser.tokenNames; }
    public String getGrammarFileName() { return "InternalQVTcore.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */
     
     	private QVTcoreGrammarAccess grammarAccess;
     	
        public InternalQVTcoreParser(TokenStream input, QVTcoreGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "TopLevelCS";	
       	}
       	
       	@Override
       	protected QVTcoreGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleTopLevelCS"
    // InternalQVTcore.g:80:1: entryRuleTopLevelCS returns [EObject current=null] : iv_ruleTopLevelCS= ruleTopLevelCS EOF ;
    public final EObject entryRuleTopLevelCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTopLevelCS = null;


        try {
            // InternalQVTcore.g:81:2: (iv_ruleTopLevelCS= ruleTopLevelCS EOF )
            // InternalQVTcore.g:82:2: iv_ruleTopLevelCS= ruleTopLevelCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTopLevelCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTopLevelCS=ruleTopLevelCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTopLevelCS; 
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
    // $ANTLR end "entryRuleTopLevelCS"


    // $ANTLR start "ruleTopLevelCS"
    // InternalQVTcore.g:89:1: ruleTopLevelCS returns [EObject current=null] : ( ( (lv_ownedImports_0_0= ruleImportCS ) )* ( ( (lv_ownedTransformations_1_0= ruleTransformationCS ) ) | ( (lv_ownedMappings_2_0= ruleMappingCS ) ) | ( (lv_ownedQueries_3_0= ruleQueryCS ) ) )* ) ;
    public final EObject ruleTopLevelCS() throws RecognitionException {
        EObject current = null;

        EObject lv_ownedImports_0_0 = null;

        EObject lv_ownedTransformations_1_0 = null;

        EObject lv_ownedMappings_2_0 = null;

        EObject lv_ownedQueries_3_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTcore.g:92:28: ( ( ( (lv_ownedImports_0_0= ruleImportCS ) )* ( ( (lv_ownedTransformations_1_0= ruleTransformationCS ) ) | ( (lv_ownedMappings_2_0= ruleMappingCS ) ) | ( (lv_ownedQueries_3_0= ruleQueryCS ) ) )* ) )
            // InternalQVTcore.g:93:1: ( ( (lv_ownedImports_0_0= ruleImportCS ) )* ( ( (lv_ownedTransformations_1_0= ruleTransformationCS ) ) | ( (lv_ownedMappings_2_0= ruleMappingCS ) ) | ( (lv_ownedQueries_3_0= ruleQueryCS ) ) )* )
            {
            // InternalQVTcore.g:93:1: ( ( (lv_ownedImports_0_0= ruleImportCS ) )* ( ( (lv_ownedTransformations_1_0= ruleTransformationCS ) ) | ( (lv_ownedMappings_2_0= ruleMappingCS ) ) | ( (lv_ownedQueries_3_0= ruleQueryCS ) ) )* )
            // InternalQVTcore.g:93:2: ( (lv_ownedImports_0_0= ruleImportCS ) )* ( ( (lv_ownedTransformations_1_0= ruleTransformationCS ) ) | ( (lv_ownedMappings_2_0= ruleMappingCS ) ) | ( (lv_ownedQueries_3_0= ruleQueryCS ) ) )*
            {
            // InternalQVTcore.g:93:2: ( (lv_ownedImports_0_0= ruleImportCS ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==30) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalQVTcore.g:94:1: (lv_ownedImports_0_0= ruleImportCS )
            	    {
            	    // InternalQVTcore.g:94:1: (lv_ownedImports_0_0= ruleImportCS )
            	    // InternalQVTcore.g:95:3: lv_ownedImports_0_0= ruleImportCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTopLevelCSAccess().getOwnedImportsImportCSParserRuleCall_0_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    lv_ownedImports_0_0=ruleImportCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getTopLevelCSRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedImports",
            	              		lv_ownedImports_0_0, 
            	              		"org.eclipse.qvtd.xtext.qvtcorebase.QVTcoreBase.ImportCS");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // InternalQVTcore.g:111:3: ( ( (lv_ownedTransformations_1_0= ruleTransformationCS ) ) | ( (lv_ownedMappings_2_0= ruleMappingCS ) ) | ( (lv_ownedQueries_3_0= ruleQueryCS ) ) )*
            loop2:
            do {
                int alt2=4;
                switch ( input.LA(1) ) {
                case 38:
                    {
                    alt2=1;
                    }
                    break;
                case 16:
                case 17:
                    {
                    alt2=2;
                    }
                    break;
                case 37:
                    {
                    alt2=3;
                    }
                    break;

                }

                switch (alt2) {
            	case 1 :
            	    // InternalQVTcore.g:111:4: ( (lv_ownedTransformations_1_0= ruleTransformationCS ) )
            	    {
            	    // InternalQVTcore.g:111:4: ( (lv_ownedTransformations_1_0= ruleTransformationCS ) )
            	    // InternalQVTcore.g:112:1: (lv_ownedTransformations_1_0= ruleTransformationCS )
            	    {
            	    // InternalQVTcore.g:112:1: (lv_ownedTransformations_1_0= ruleTransformationCS )
            	    // InternalQVTcore.g:113:3: lv_ownedTransformations_1_0= ruleTransformationCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTopLevelCSAccess().getOwnedTransformationsTransformationCSParserRuleCall_1_0_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_4);
            	    lv_ownedTransformations_1_0=ruleTransformationCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getTopLevelCSRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedTransformations",
            	              		lv_ownedTransformations_1_0, 
            	              		"org.eclipse.qvtd.xtext.qvtcorebase.QVTcoreBase.TransformationCS");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalQVTcore.g:130:6: ( (lv_ownedMappings_2_0= ruleMappingCS ) )
            	    {
            	    // InternalQVTcore.g:130:6: ( (lv_ownedMappings_2_0= ruleMappingCS ) )
            	    // InternalQVTcore.g:131:1: (lv_ownedMappings_2_0= ruleMappingCS )
            	    {
            	    // InternalQVTcore.g:131:1: (lv_ownedMappings_2_0= ruleMappingCS )
            	    // InternalQVTcore.g:132:3: lv_ownedMappings_2_0= ruleMappingCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTopLevelCSAccess().getOwnedMappingsMappingCSParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_4);
            	    lv_ownedMappings_2_0=ruleMappingCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getTopLevelCSRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedMappings",
            	              		lv_ownedMappings_2_0, 
            	              		"org.eclipse.qvtd.xtext.qvtcore.QVTcore.MappingCS");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalQVTcore.g:149:6: ( (lv_ownedQueries_3_0= ruleQueryCS ) )
            	    {
            	    // InternalQVTcore.g:149:6: ( (lv_ownedQueries_3_0= ruleQueryCS ) )
            	    // InternalQVTcore.g:150:1: (lv_ownedQueries_3_0= ruleQueryCS )
            	    {
            	    // InternalQVTcore.g:150:1: (lv_ownedQueries_3_0= ruleQueryCS )
            	    // InternalQVTcore.g:151:3: lv_ownedQueries_3_0= ruleQueryCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTopLevelCSAccess().getOwnedQueriesQueryCSParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_4);
            	    lv_ownedQueries_3_0=ruleQueryCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getTopLevelCSRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedQueries",
            	              		lv_ownedQueries_3_0, 
            	              		"org.eclipse.qvtd.xtext.qvtcorebase.QVTcoreBase.QueryCS");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
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
    // $ANTLR end "ruleTopLevelCS"


    // $ANTLR start "entryRuleMappingCS"
    // InternalQVTcore.g:175:1: entryRuleMappingCS returns [EObject current=null] : iv_ruleMappingCS= ruleMappingCS EOF ;
    public final EObject entryRuleMappingCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMappingCS = null;


        try {
            // InternalQVTcore.g:176:2: (iv_ruleMappingCS= ruleMappingCS EOF )
            // InternalQVTcore.g:177:2: iv_ruleMappingCS= ruleMappingCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMappingCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMappingCS=ruleMappingCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMappingCS; 
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
    // $ANTLR end "entryRuleMappingCS"


    // $ANTLR start "ruleMappingCS"
    // InternalQVTcore.g:184:1: ruleMappingCS returns [EObject current=null] : ( () ( (lv_isDefault_1_0= 'default' ) )? otherlv_2= 'map' ( (lv_name_3_0= ruleUnrestrictedName ) )? (otherlv_4= 'in' ( (lv_ownedInPathName_5_0= rulePathNameCS ) ) )? (otherlv_6= 'refines' ( ( ruleUnrestrictedName ) ) (otherlv_8= ',' ( ( ruleUnrestrictedName ) ) )* )? otherlv_10= '{' ( (lv_ownedDomains_11_0= ruleNamedDomainCS ) )* (otherlv_12= 'where' ( (lv_ownedMiddle_13_0= ruleUnnamedDomainCS ) ) )? ( (lv_ownedComposedMappings_14_0= ruleMappingCS ) )* otherlv_15= '}' ) ;
    public final EObject ruleMappingCS() throws RecognitionException {
        EObject current = null;

        Token lv_isDefault_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_15=null;
        AntlrDatatypeRuleToken lv_name_3_0 = null;

        EObject lv_ownedInPathName_5_0 = null;

        EObject lv_ownedDomains_11_0 = null;

        EObject lv_ownedMiddle_13_0 = null;

        EObject lv_ownedComposedMappings_14_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTcore.g:187:28: ( ( () ( (lv_isDefault_1_0= 'default' ) )? otherlv_2= 'map' ( (lv_name_3_0= ruleUnrestrictedName ) )? (otherlv_4= 'in' ( (lv_ownedInPathName_5_0= rulePathNameCS ) ) )? (otherlv_6= 'refines' ( ( ruleUnrestrictedName ) ) (otherlv_8= ',' ( ( ruleUnrestrictedName ) ) )* )? otherlv_10= '{' ( (lv_ownedDomains_11_0= ruleNamedDomainCS ) )* (otherlv_12= 'where' ( (lv_ownedMiddle_13_0= ruleUnnamedDomainCS ) ) )? ( (lv_ownedComposedMappings_14_0= ruleMappingCS ) )* otherlv_15= '}' ) )
            // InternalQVTcore.g:188:1: ( () ( (lv_isDefault_1_0= 'default' ) )? otherlv_2= 'map' ( (lv_name_3_0= ruleUnrestrictedName ) )? (otherlv_4= 'in' ( (lv_ownedInPathName_5_0= rulePathNameCS ) ) )? (otherlv_6= 'refines' ( ( ruleUnrestrictedName ) ) (otherlv_8= ',' ( ( ruleUnrestrictedName ) ) )* )? otherlv_10= '{' ( (lv_ownedDomains_11_0= ruleNamedDomainCS ) )* (otherlv_12= 'where' ( (lv_ownedMiddle_13_0= ruleUnnamedDomainCS ) ) )? ( (lv_ownedComposedMappings_14_0= ruleMappingCS ) )* otherlv_15= '}' )
            {
            // InternalQVTcore.g:188:1: ( () ( (lv_isDefault_1_0= 'default' ) )? otherlv_2= 'map' ( (lv_name_3_0= ruleUnrestrictedName ) )? (otherlv_4= 'in' ( (lv_ownedInPathName_5_0= rulePathNameCS ) ) )? (otherlv_6= 'refines' ( ( ruleUnrestrictedName ) ) (otherlv_8= ',' ( ( ruleUnrestrictedName ) ) )* )? otherlv_10= '{' ( (lv_ownedDomains_11_0= ruleNamedDomainCS ) )* (otherlv_12= 'where' ( (lv_ownedMiddle_13_0= ruleUnnamedDomainCS ) ) )? ( (lv_ownedComposedMappings_14_0= ruleMappingCS ) )* otherlv_15= '}' )
            // InternalQVTcore.g:188:2: () ( (lv_isDefault_1_0= 'default' ) )? otherlv_2= 'map' ( (lv_name_3_0= ruleUnrestrictedName ) )? (otherlv_4= 'in' ( (lv_ownedInPathName_5_0= rulePathNameCS ) ) )? (otherlv_6= 'refines' ( ( ruleUnrestrictedName ) ) (otherlv_8= ',' ( ( ruleUnrestrictedName ) ) )* )? otherlv_10= '{' ( (lv_ownedDomains_11_0= ruleNamedDomainCS ) )* (otherlv_12= 'where' ( (lv_ownedMiddle_13_0= ruleUnnamedDomainCS ) ) )? ( (lv_ownedComposedMappings_14_0= ruleMappingCS ) )* otherlv_15= '}'
            {
            // InternalQVTcore.g:188:2: ()
            // InternalQVTcore.g:189:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getMappingCSAccess().getMappingCSAction_0(),
                          current);
                  
            }

            }

            // InternalQVTcore.g:197:2: ( (lv_isDefault_1_0= 'default' ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==16) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalQVTcore.g:198:1: (lv_isDefault_1_0= 'default' )
                    {
                    // InternalQVTcore.g:198:1: (lv_isDefault_1_0= 'default' )
                    // InternalQVTcore.g:199:3: lv_isDefault_1_0= 'default'
                    {
                    lv_isDefault_1_0=(Token)match(input,16,FollowSets000.FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_isDefault_1_0, grammarAccess.getMappingCSAccess().getIsDefaultDefaultKeyword_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getMappingCSRule());
                      	        }
                             		setWithLastConsumed(current, "isDefault", true, "default");
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,17,FollowSets000.FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getMappingCSAccess().getMapKeyword_2());
                  
            }
            // InternalQVTcore.g:216:1: ( (lv_name_3_0= ruleUnrestrictedName ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0>=RULE_SIMPLE_ID && LA4_0<=RULE_ESCAPED_ID)||LA4_0==17||(LA4_0>=25 && LA4_0<=26)||LA4_0==30||(LA4_0>=34 && LA4_0<=35)||(LA4_0>=37 && LA4_0<=40)) ) {
                alt4=1;
            }
            else if ( (LA4_0==19) ) {
                int LA4_2 = input.LA(2);

                if ( (LA4_2==18||LA4_2==21) ) {
                    alt4=1;
                }
                else if ( (LA4_2==19) ) {
                    int LA4_4 = input.LA(3);

                    if ( ((LA4_4>=RULE_SIMPLE_ID && LA4_4<=RULE_ESCAPED_ID)||LA4_4==17||LA4_4==19||(LA4_4>=25 && LA4_4<=26)||LA4_4==30||(LA4_4>=34 && LA4_4<=35)||(LA4_4>=37 && LA4_4<=40)) ) {
                        alt4=1;
                    }
                }
            }
            switch (alt4) {
                case 1 :
                    // InternalQVTcore.g:217:1: (lv_name_3_0= ruleUnrestrictedName )
                    {
                    // InternalQVTcore.g:217:1: (lv_name_3_0= ruleUnrestrictedName )
                    // InternalQVTcore.g:218:3: lv_name_3_0= ruleUnrestrictedName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMappingCSAccess().getNameUnrestrictedNameParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_7);
                    lv_name_3_0=ruleUnrestrictedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getMappingCSRule());
                      	        }
                             		set(
                             			current, 
                             			"name",
                              		lv_name_3_0, 
                              		"org.eclipse.qvtd.xtext.qvtcorebase.QVTcoreBase.UnrestrictedName");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // InternalQVTcore.g:234:3: (otherlv_4= 'in' ( (lv_ownedInPathName_5_0= rulePathNameCS ) ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==18) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalQVTcore.g:234:5: otherlv_4= 'in' ( (lv_ownedInPathName_5_0= rulePathNameCS ) )
                    {
                    otherlv_4=(Token)match(input,18,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getMappingCSAccess().getInKeyword_4_0());
                          
                    }
                    // InternalQVTcore.g:238:1: ( (lv_ownedInPathName_5_0= rulePathNameCS ) )
                    // InternalQVTcore.g:239:1: (lv_ownedInPathName_5_0= rulePathNameCS )
                    {
                    // InternalQVTcore.g:239:1: (lv_ownedInPathName_5_0= rulePathNameCS )
                    // InternalQVTcore.g:240:3: lv_ownedInPathName_5_0= rulePathNameCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMappingCSAccess().getOwnedInPathNamePathNameCSParserRuleCall_4_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_9);
                    lv_ownedInPathName_5_0=rulePathNameCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getMappingCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedInPathName",
                              		lv_ownedInPathName_5_0, 
                              		"org.eclipse.ocl.xtext.base.Base.PathNameCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalQVTcore.g:256:4: (otherlv_6= 'refines' ( ( ruleUnrestrictedName ) ) (otherlv_8= ',' ( ( ruleUnrestrictedName ) ) )* )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==19) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalQVTcore.g:256:6: otherlv_6= 'refines' ( ( ruleUnrestrictedName ) ) (otherlv_8= ',' ( ( ruleUnrestrictedName ) ) )*
                    {
                    otherlv_6=(Token)match(input,19,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getMappingCSAccess().getRefinesKeyword_5_0());
                          
                    }
                    // InternalQVTcore.g:260:1: ( ( ruleUnrestrictedName ) )
                    // InternalQVTcore.g:261:1: ( ruleUnrestrictedName )
                    {
                    // InternalQVTcore.g:261:1: ( ruleUnrestrictedName )
                    // InternalQVTcore.g:262:3: ruleUnrestrictedName
                    {
                    if ( state.backtracking==0 ) {
                       
                      		  /* */ 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getMappingCSRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMappingCSAccess().getRefinesMappingCrossReference_5_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_10);
                    ruleUnrestrictedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalQVTcore.g:278:2: (otherlv_8= ',' ( ( ruleUnrestrictedName ) ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==20) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // InternalQVTcore.g:278:4: otherlv_8= ',' ( ( ruleUnrestrictedName ) )
                    	    {
                    	    otherlv_8=(Token)match(input,20,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_8, grammarAccess.getMappingCSAccess().getCommaKeyword_5_2_0());
                    	          
                    	    }
                    	    // InternalQVTcore.g:282:1: ( ( ruleUnrestrictedName ) )
                    	    // InternalQVTcore.g:283:1: ( ruleUnrestrictedName )
                    	    {
                    	    // InternalQVTcore.g:283:1: ( ruleUnrestrictedName )
                    	    // InternalQVTcore.g:284:3: ruleUnrestrictedName
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      		  /* */ 
                    	      		
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      			if (current==null) {
                    	      	            current = createModelElement(grammarAccess.getMappingCSRule());
                    	      	        }
                    	              
                    	    }
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getMappingCSAccess().getRefinesMappingCrossReference_5_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_10);
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

                    	default :
                    	    break loop6;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_10=(Token)match(input,21,FollowSets000.FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_10, grammarAccess.getMappingCSAccess().getLeftCurlyBracketKeyword_6());
                  
            }
            // InternalQVTcore.g:304:1: ( (lv_ownedDomains_11_0= ruleNamedDomainCS ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==17) ) {
                    int LA8_2 = input.LA(2);

                    if ( (LA8_2==27) ) {
                        alt8=1;
                    }


                }
                else if ( ((LA8_0>=RULE_SIMPLE_ID && LA8_0<=RULE_ESCAPED_ID)||LA8_0==19||(LA8_0>=25 && LA8_0<=26)||LA8_0==30||(LA8_0>=34 && LA8_0<=35)||(LA8_0>=37 && LA8_0<=40)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalQVTcore.g:305:1: (lv_ownedDomains_11_0= ruleNamedDomainCS )
            	    {
            	    // InternalQVTcore.g:305:1: (lv_ownedDomains_11_0= ruleNamedDomainCS )
            	    // InternalQVTcore.g:306:3: lv_ownedDomains_11_0= ruleNamedDomainCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMappingCSAccess().getOwnedDomainsNamedDomainCSParserRuleCall_7_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_11);
            	    lv_ownedDomains_11_0=ruleNamedDomainCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getMappingCSRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedDomains",
            	              		lv_ownedDomains_11_0, 
            	              		"org.eclipse.qvtd.xtext.qvtcorebase.QVTcoreBase.NamedDomainCS");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            // InternalQVTcore.g:322:3: (otherlv_12= 'where' ( (lv_ownedMiddle_13_0= ruleUnnamedDomainCS ) ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==22) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalQVTcore.g:322:5: otherlv_12= 'where' ( (lv_ownedMiddle_13_0= ruleUnnamedDomainCS ) )
                    {
                    otherlv_12=(Token)match(input,22,FollowSets000.FOLLOW_12); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_12, grammarAccess.getMappingCSAccess().getWhereKeyword_8_0());
                          
                    }
                    // InternalQVTcore.g:326:1: ( (lv_ownedMiddle_13_0= ruleUnnamedDomainCS ) )
                    // InternalQVTcore.g:327:1: (lv_ownedMiddle_13_0= ruleUnnamedDomainCS )
                    {
                    // InternalQVTcore.g:327:1: (lv_ownedMiddle_13_0= ruleUnnamedDomainCS )
                    // InternalQVTcore.g:328:3: lv_ownedMiddle_13_0= ruleUnnamedDomainCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMappingCSAccess().getOwnedMiddleUnnamedDomainCSParserRuleCall_8_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_13);
                    lv_ownedMiddle_13_0=ruleUnnamedDomainCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getMappingCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedMiddle",
                              		lv_ownedMiddle_13_0, 
                              		"org.eclipse.qvtd.xtext.qvtcorebase.QVTcoreBase.UnnamedDomainCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalQVTcore.g:344:4: ( (lv_ownedComposedMappings_14_0= ruleMappingCS ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>=16 && LA10_0<=17)) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalQVTcore.g:345:1: (lv_ownedComposedMappings_14_0= ruleMappingCS )
            	    {
            	    // InternalQVTcore.g:345:1: (lv_ownedComposedMappings_14_0= ruleMappingCS )
            	    // InternalQVTcore.g:346:3: lv_ownedComposedMappings_14_0= ruleMappingCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMappingCSAccess().getOwnedComposedMappingsMappingCSParserRuleCall_9_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_13);
            	    lv_ownedComposedMappings_14_0=ruleMappingCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getMappingCSRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedComposedMappings",
            	              		lv_ownedComposedMappings_14_0, 
            	              		"org.eclipse.qvtd.xtext.qvtcore.QVTcore.MappingCS");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            otherlv_15=(Token)match(input,23,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_15, grammarAccess.getMappingCSAccess().getRightCurlyBracketKeyword_10());
                  
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
    // $ANTLR end "ruleMappingCS"


    // $ANTLR start "entryRuleBottomPatternCS"
    // InternalQVTcore.g:374:1: entryRuleBottomPatternCS returns [EObject current=null] : iv_ruleBottomPatternCS= ruleBottomPatternCS EOF ;
    public final EObject entryRuleBottomPatternCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBottomPatternCS = null;


        try {
            // InternalQVTcore.g:375:2: (iv_ruleBottomPatternCS= ruleBottomPatternCS EOF )
            // InternalQVTcore.g:376:2: iv_ruleBottomPatternCS= ruleBottomPatternCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBottomPatternCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleBottomPatternCS=ruleBottomPatternCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBottomPatternCS; 
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
    // $ANTLR end "entryRuleBottomPatternCS"


    // $ANTLR start "ruleBottomPatternCS"
    // InternalQVTcore.g:383:1: ruleBottomPatternCS returns [EObject current=null] : ( (otherlv_0= '{' ( ( (lv_ownedUnrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) | ( (lv_ownedRealizedVariables_2_0= ruleRealizedVariableCS ) ) ) (otherlv_3= ',' ( ( (lv_ownedUnrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_ownedRealizedVariables_5_0= ruleRealizedVariableCS ) ) ) )* otherlv_6= '|' ( (lv_ownedConstraints_7_0= rulePredicateOrAssignmentCS ) )* otherlv_8= '}' ) | (otherlv_9= '{' ( ( (lv_ownedUnrealizedVariables_10_0= ruleUnrealizedVariableCS ) ) | ( (lv_ownedRealizedVariables_11_0= ruleRealizedVariableCS ) ) ) (otherlv_12= ',' ( ( (lv_ownedUnrealizedVariables_13_0= ruleUnrealizedVariableCS ) ) | ( (lv_ownedRealizedVariables_14_0= ruleRealizedVariableCS ) ) ) )* otherlv_15= '}' ) | (otherlv_16= '{' ( (lv_ownedConstraints_17_0= rulePredicateOrAssignmentCS ) )+ otherlv_18= '}' ) | ( () otherlv_20= '{' otherlv_21= '}' ) ) ;
    public final EObject ruleBottomPatternCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_12=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        Token otherlv_21=null;
        EObject lv_ownedUnrealizedVariables_1_0 = null;

        EObject lv_ownedRealizedVariables_2_0 = null;

        EObject lv_ownedUnrealizedVariables_4_0 = null;

        EObject lv_ownedRealizedVariables_5_0 = null;

        EObject lv_ownedConstraints_7_0 = null;

        EObject lv_ownedUnrealizedVariables_10_0 = null;

        EObject lv_ownedRealizedVariables_11_0 = null;

        EObject lv_ownedUnrealizedVariables_13_0 = null;

        EObject lv_ownedRealizedVariables_14_0 = null;

        EObject lv_ownedConstraints_17_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTcore.g:386:28: ( ( (otherlv_0= '{' ( ( (lv_ownedUnrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) | ( (lv_ownedRealizedVariables_2_0= ruleRealizedVariableCS ) ) ) (otherlv_3= ',' ( ( (lv_ownedUnrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_ownedRealizedVariables_5_0= ruleRealizedVariableCS ) ) ) )* otherlv_6= '|' ( (lv_ownedConstraints_7_0= rulePredicateOrAssignmentCS ) )* otherlv_8= '}' ) | (otherlv_9= '{' ( ( (lv_ownedUnrealizedVariables_10_0= ruleUnrealizedVariableCS ) ) | ( (lv_ownedRealizedVariables_11_0= ruleRealizedVariableCS ) ) ) (otherlv_12= ',' ( ( (lv_ownedUnrealizedVariables_13_0= ruleUnrealizedVariableCS ) ) | ( (lv_ownedRealizedVariables_14_0= ruleRealizedVariableCS ) ) ) )* otherlv_15= '}' ) | (otherlv_16= '{' ( (lv_ownedConstraints_17_0= rulePredicateOrAssignmentCS ) )+ otherlv_18= '}' ) | ( () otherlv_20= '{' otherlv_21= '}' ) ) )
            // InternalQVTcore.g:387:1: ( (otherlv_0= '{' ( ( (lv_ownedUnrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) | ( (lv_ownedRealizedVariables_2_0= ruleRealizedVariableCS ) ) ) (otherlv_3= ',' ( ( (lv_ownedUnrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_ownedRealizedVariables_5_0= ruleRealizedVariableCS ) ) ) )* otherlv_6= '|' ( (lv_ownedConstraints_7_0= rulePredicateOrAssignmentCS ) )* otherlv_8= '}' ) | (otherlv_9= '{' ( ( (lv_ownedUnrealizedVariables_10_0= ruleUnrealizedVariableCS ) ) | ( (lv_ownedRealizedVariables_11_0= ruleRealizedVariableCS ) ) ) (otherlv_12= ',' ( ( (lv_ownedUnrealizedVariables_13_0= ruleUnrealizedVariableCS ) ) | ( (lv_ownedRealizedVariables_14_0= ruleRealizedVariableCS ) ) ) )* otherlv_15= '}' ) | (otherlv_16= '{' ( (lv_ownedConstraints_17_0= rulePredicateOrAssignmentCS ) )+ otherlv_18= '}' ) | ( () otherlv_20= '{' otherlv_21= '}' ) )
            {
            // InternalQVTcore.g:387:1: ( (otherlv_0= '{' ( ( (lv_ownedUnrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) | ( (lv_ownedRealizedVariables_2_0= ruleRealizedVariableCS ) ) ) (otherlv_3= ',' ( ( (lv_ownedUnrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_ownedRealizedVariables_5_0= ruleRealizedVariableCS ) ) ) )* otherlv_6= '|' ( (lv_ownedConstraints_7_0= rulePredicateOrAssignmentCS ) )* otherlv_8= '}' ) | (otherlv_9= '{' ( ( (lv_ownedUnrealizedVariables_10_0= ruleUnrealizedVariableCS ) ) | ( (lv_ownedRealizedVariables_11_0= ruleRealizedVariableCS ) ) ) (otherlv_12= ',' ( ( (lv_ownedUnrealizedVariables_13_0= ruleUnrealizedVariableCS ) ) | ( (lv_ownedRealizedVariables_14_0= ruleRealizedVariableCS ) ) ) )* otherlv_15= '}' ) | (otherlv_16= '{' ( (lv_ownedConstraints_17_0= rulePredicateOrAssignmentCS ) )+ otherlv_18= '}' ) | ( () otherlv_20= '{' otherlv_21= '}' ) )
            int alt19=4;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==21) ) {
                int LA19_1 = input.LA(2);

                if ( (synpred17_InternalQVTcore()) ) {
                    alt19=1;
                }
                else if ( (synpred21_InternalQVTcore()) ) {
                    alt19=2;
                }
                else if ( (synpred23_InternalQVTcore()) ) {
                    alt19=3;
                }
                else if ( (true) ) {
                    alt19=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 19, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // InternalQVTcore.g:387:2: (otherlv_0= '{' ( ( (lv_ownedUnrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) | ( (lv_ownedRealizedVariables_2_0= ruleRealizedVariableCS ) ) ) (otherlv_3= ',' ( ( (lv_ownedUnrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_ownedRealizedVariables_5_0= ruleRealizedVariableCS ) ) ) )* otherlv_6= '|' ( (lv_ownedConstraints_7_0= rulePredicateOrAssignmentCS ) )* otherlv_8= '}' )
                    {
                    // InternalQVTcore.g:387:2: (otherlv_0= '{' ( ( (lv_ownedUnrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) | ( (lv_ownedRealizedVariables_2_0= ruleRealizedVariableCS ) ) ) (otherlv_3= ',' ( ( (lv_ownedUnrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_ownedRealizedVariables_5_0= ruleRealizedVariableCS ) ) ) )* otherlv_6= '|' ( (lv_ownedConstraints_7_0= rulePredicateOrAssignmentCS ) )* otherlv_8= '}' )
                    // InternalQVTcore.g:387:4: otherlv_0= '{' ( ( (lv_ownedUnrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) | ( (lv_ownedRealizedVariables_2_0= ruleRealizedVariableCS ) ) ) (otherlv_3= ',' ( ( (lv_ownedUnrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_ownedRealizedVariables_5_0= ruleRealizedVariableCS ) ) ) )* otherlv_6= '|' ( (lv_ownedConstraints_7_0= rulePredicateOrAssignmentCS ) )* otherlv_8= '}'
                    {
                    otherlv_0=(Token)match(input,21,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getBottomPatternCSAccess().getLeftCurlyBracketKeyword_0_0());
                          
                    }
                    // InternalQVTcore.g:391:1: ( ( (lv_ownedUnrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) | ( (lv_ownedRealizedVariables_2_0= ruleRealizedVariableCS ) ) )
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( ((LA11_0>=RULE_SIMPLE_ID && LA11_0<=RULE_ESCAPED_ID)||LA11_0==17||LA11_0==19||(LA11_0>=25 && LA11_0<=26)||LA11_0==30||(LA11_0>=34 && LA11_0<=35)||(LA11_0>=37 && LA11_0<=38)||LA11_0==40) ) {
                        alt11=1;
                    }
                    else if ( (LA11_0==39) ) {
                        int LA11_2 = input.LA(2);

                        if ( (LA11_2==20||LA11_2==24||LA11_2==29||LA11_2==36) ) {
                            alt11=1;
                        }
                        else if ( ((LA11_2>=RULE_SIMPLE_ID && LA11_2<=RULE_ESCAPED_ID)||LA11_2==17||LA11_2==19||(LA11_2>=25 && LA11_2<=26)||LA11_2==30||(LA11_2>=34 && LA11_2<=35)||(LA11_2>=37 && LA11_2<=40)) ) {
                            alt11=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 11, 2, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 11, 0, input);

                        throw nvae;
                    }
                    switch (alt11) {
                        case 1 :
                            // InternalQVTcore.g:391:2: ( (lv_ownedUnrealizedVariables_1_0= ruleUnrealizedVariableCS ) )
                            {
                            // InternalQVTcore.g:391:2: ( (lv_ownedUnrealizedVariables_1_0= ruleUnrealizedVariableCS ) )
                            // InternalQVTcore.g:392:1: (lv_ownedUnrealizedVariables_1_0= ruleUnrealizedVariableCS )
                            {
                            // InternalQVTcore.g:392:1: (lv_ownedUnrealizedVariables_1_0= ruleUnrealizedVariableCS )
                            // InternalQVTcore.g:393:3: lv_ownedUnrealizedVariables_1_0= ruleUnrealizedVariableCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getBottomPatternCSAccess().getOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_0_1_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_14);
                            lv_ownedUnrealizedVariables_1_0=ruleUnrealizedVariableCS();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getBottomPatternCSRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"ownedUnrealizedVariables",
                                      		lv_ownedUnrealizedVariables_1_0, 
                                      		"org.eclipse.qvtd.xtext.qvtcorebase.QVTcoreBase.UnrealizedVariableCS");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalQVTcore.g:410:6: ( (lv_ownedRealizedVariables_2_0= ruleRealizedVariableCS ) )
                            {
                            // InternalQVTcore.g:410:6: ( (lv_ownedRealizedVariables_2_0= ruleRealizedVariableCS ) )
                            // InternalQVTcore.g:411:1: (lv_ownedRealizedVariables_2_0= ruleRealizedVariableCS )
                            {
                            // InternalQVTcore.g:411:1: (lv_ownedRealizedVariables_2_0= ruleRealizedVariableCS )
                            // InternalQVTcore.g:412:3: lv_ownedRealizedVariables_2_0= ruleRealizedVariableCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getBottomPatternCSAccess().getOwnedRealizedVariablesRealizedVariableCSParserRuleCall_0_1_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_14);
                            lv_ownedRealizedVariables_2_0=ruleRealizedVariableCS();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getBottomPatternCSRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"ownedRealizedVariables",
                                      		lv_ownedRealizedVariables_2_0, 
                                      		"org.eclipse.qvtd.xtext.qvtcorebase.QVTcoreBase.RealizedVariableCS");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;

                    }

                    // InternalQVTcore.g:428:3: (otherlv_3= ',' ( ( (lv_ownedUnrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_ownedRealizedVariables_5_0= ruleRealizedVariableCS ) ) ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==20) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // InternalQVTcore.g:428:5: otherlv_3= ',' ( ( (lv_ownedUnrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_ownedRealizedVariables_5_0= ruleRealizedVariableCS ) ) )
                    	    {
                    	    otherlv_3=(Token)match(input,20,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getBottomPatternCSAccess().getCommaKeyword_0_2_0());
                    	          
                    	    }
                    	    // InternalQVTcore.g:432:1: ( ( (lv_ownedUnrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_ownedRealizedVariables_5_0= ruleRealizedVariableCS ) ) )
                    	    int alt12=2;
                    	    int LA12_0 = input.LA(1);

                    	    if ( ((LA12_0>=RULE_SIMPLE_ID && LA12_0<=RULE_ESCAPED_ID)||LA12_0==17||LA12_0==19||(LA12_0>=25 && LA12_0<=26)||LA12_0==30||(LA12_0>=34 && LA12_0<=35)||(LA12_0>=37 && LA12_0<=38)||LA12_0==40) ) {
                    	        alt12=1;
                    	    }
                    	    else if ( (LA12_0==39) ) {
                    	        int LA12_2 = input.LA(2);

                    	        if ( ((LA12_2>=RULE_SIMPLE_ID && LA12_2<=RULE_ESCAPED_ID)||LA12_2==17||LA12_2==19||(LA12_2>=25 && LA12_2<=26)||LA12_2==30||(LA12_2>=34 && LA12_2<=35)||(LA12_2>=37 && LA12_2<=40)) ) {
                    	            alt12=2;
                    	        }
                    	        else if ( (LA12_2==20||LA12_2==24||LA12_2==29||LA12_2==36) ) {
                    	            alt12=1;
                    	        }
                    	        else {
                    	            if (state.backtracking>0) {state.failed=true; return current;}
                    	            NoViableAltException nvae =
                    	                new NoViableAltException("", 12, 2, input);

                    	            throw nvae;
                    	        }
                    	    }
                    	    else {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 12, 0, input);

                    	        throw nvae;
                    	    }
                    	    switch (alt12) {
                    	        case 1 :
                    	            // InternalQVTcore.g:432:2: ( (lv_ownedUnrealizedVariables_4_0= ruleUnrealizedVariableCS ) )
                    	            {
                    	            // InternalQVTcore.g:432:2: ( (lv_ownedUnrealizedVariables_4_0= ruleUnrealizedVariableCS ) )
                    	            // InternalQVTcore.g:433:1: (lv_ownedUnrealizedVariables_4_0= ruleUnrealizedVariableCS )
                    	            {
                    	            // InternalQVTcore.g:433:1: (lv_ownedUnrealizedVariables_4_0= ruleUnrealizedVariableCS )
                    	            // InternalQVTcore.g:434:3: lv_ownedUnrealizedVariables_4_0= ruleUnrealizedVariableCS
                    	            {
                    	            if ( state.backtracking==0 ) {
                    	               
                    	              	        newCompositeNode(grammarAccess.getBottomPatternCSAccess().getOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_0_2_1_0_0()); 
                    	              	    
                    	            }
                    	            pushFollow(FollowSets000.FOLLOW_14);
                    	            lv_ownedUnrealizedVariables_4_0=ruleUnrealizedVariableCS();

                    	            state._fsp--;
                    	            if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElementForParent(grammarAccess.getBottomPatternCSRule());
                    	              	        }
                    	                     		add(
                    	                     			current, 
                    	                     			"ownedUnrealizedVariables",
                    	                      		lv_ownedUnrealizedVariables_4_0, 
                    	                      		"org.eclipse.qvtd.xtext.qvtcorebase.QVTcoreBase.UnrealizedVariableCS");
                    	              	        afterParserOrEnumRuleCall();
                    	              	    
                    	            }

                    	            }


                    	            }


                    	            }
                    	            break;
                    	        case 2 :
                    	            // InternalQVTcore.g:451:6: ( (lv_ownedRealizedVariables_5_0= ruleRealizedVariableCS ) )
                    	            {
                    	            // InternalQVTcore.g:451:6: ( (lv_ownedRealizedVariables_5_0= ruleRealizedVariableCS ) )
                    	            // InternalQVTcore.g:452:1: (lv_ownedRealizedVariables_5_0= ruleRealizedVariableCS )
                    	            {
                    	            // InternalQVTcore.g:452:1: (lv_ownedRealizedVariables_5_0= ruleRealizedVariableCS )
                    	            // InternalQVTcore.g:453:3: lv_ownedRealizedVariables_5_0= ruleRealizedVariableCS
                    	            {
                    	            if ( state.backtracking==0 ) {
                    	               
                    	              	        newCompositeNode(grammarAccess.getBottomPatternCSAccess().getOwnedRealizedVariablesRealizedVariableCSParserRuleCall_0_2_1_1_0()); 
                    	              	    
                    	            }
                    	            pushFollow(FollowSets000.FOLLOW_14);
                    	            lv_ownedRealizedVariables_5_0=ruleRealizedVariableCS();

                    	            state._fsp--;
                    	            if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElementForParent(grammarAccess.getBottomPatternCSRule());
                    	              	        }
                    	                     		add(
                    	                     			current, 
                    	                     			"ownedRealizedVariables",
                    	                      		lv_ownedRealizedVariables_5_0, 
                    	                      		"org.eclipse.qvtd.xtext.qvtcorebase.QVTcoreBase.RealizedVariableCS");
                    	              	        afterParserOrEnumRuleCall();
                    	              	    
                    	            }

                    	            }


                    	            }


                    	            }
                    	            break;

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,24,FollowSets000.FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getBottomPatternCSAccess().getVerticalLineKeyword_0_3());
                          
                    }
                    // InternalQVTcore.g:473:1: ( (lv_ownedConstraints_7_0= rulePredicateOrAssignmentCS ) )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( ((LA14_0>=RULE_SIMPLE_ID && LA14_0<=RULE_SINGLE_QUOTED_STRING)||(LA14_0>=16 && LA14_0<=17)||LA14_0==19||(LA14_0>=25 && LA14_0<=27)||LA14_0==30||LA14_0==32||(LA14_0>=34 && LA14_0<=35)||(LA14_0>=37 && LA14_0<=42)||(LA14_0>=59 && LA14_0<=73)||LA14_0==76||(LA14_0>=78 && LA14_0<=81)||LA14_0==86||(LA14_0>=91 && LA14_0<=92)) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // InternalQVTcore.g:474:1: (lv_ownedConstraints_7_0= rulePredicateOrAssignmentCS )
                    	    {
                    	    // InternalQVTcore.g:474:1: (lv_ownedConstraints_7_0= rulePredicateOrAssignmentCS )
                    	    // InternalQVTcore.g:475:3: lv_ownedConstraints_7_0= rulePredicateOrAssignmentCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getBottomPatternCSAccess().getOwnedConstraintsPredicateOrAssignmentCSParserRuleCall_0_4_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_15);
                    	    lv_ownedConstraints_7_0=rulePredicateOrAssignmentCS();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getBottomPatternCSRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"ownedConstraints",
                    	              		lv_ownedConstraints_7_0, 
                    	              		"org.eclipse.qvtd.xtext.qvtcorebase.QVTcoreBase.PredicateOrAssignmentCS");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,23,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getBottomPatternCSAccess().getRightCurlyBracketKeyword_0_5());
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalQVTcore.g:496:6: (otherlv_9= '{' ( ( (lv_ownedUnrealizedVariables_10_0= ruleUnrealizedVariableCS ) ) | ( (lv_ownedRealizedVariables_11_0= ruleRealizedVariableCS ) ) ) (otherlv_12= ',' ( ( (lv_ownedUnrealizedVariables_13_0= ruleUnrealizedVariableCS ) ) | ( (lv_ownedRealizedVariables_14_0= ruleRealizedVariableCS ) ) ) )* otherlv_15= '}' )
                    {
                    // InternalQVTcore.g:496:6: (otherlv_9= '{' ( ( (lv_ownedUnrealizedVariables_10_0= ruleUnrealizedVariableCS ) ) | ( (lv_ownedRealizedVariables_11_0= ruleRealizedVariableCS ) ) ) (otherlv_12= ',' ( ( (lv_ownedUnrealizedVariables_13_0= ruleUnrealizedVariableCS ) ) | ( (lv_ownedRealizedVariables_14_0= ruleRealizedVariableCS ) ) ) )* otherlv_15= '}' )
                    // InternalQVTcore.g:496:8: otherlv_9= '{' ( ( (lv_ownedUnrealizedVariables_10_0= ruleUnrealizedVariableCS ) ) | ( (lv_ownedRealizedVariables_11_0= ruleRealizedVariableCS ) ) ) (otherlv_12= ',' ( ( (lv_ownedUnrealizedVariables_13_0= ruleUnrealizedVariableCS ) ) | ( (lv_ownedRealizedVariables_14_0= ruleRealizedVariableCS ) ) ) )* otherlv_15= '}'
                    {
                    otherlv_9=(Token)match(input,21,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getBottomPatternCSAccess().getLeftCurlyBracketKeyword_1_0());
                          
                    }
                    // InternalQVTcore.g:500:1: ( ( (lv_ownedUnrealizedVariables_10_0= ruleUnrealizedVariableCS ) ) | ( (lv_ownedRealizedVariables_11_0= ruleRealizedVariableCS ) ) )
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( ((LA15_0>=RULE_SIMPLE_ID && LA15_0<=RULE_ESCAPED_ID)||LA15_0==17||LA15_0==19||(LA15_0>=25 && LA15_0<=26)||LA15_0==30||(LA15_0>=34 && LA15_0<=35)||(LA15_0>=37 && LA15_0<=38)||LA15_0==40) ) {
                        alt15=1;
                    }
                    else if ( (LA15_0==39) ) {
                        int LA15_2 = input.LA(2);

                        if ( ((LA15_2>=RULE_SIMPLE_ID && LA15_2<=RULE_ESCAPED_ID)||LA15_2==17||LA15_2==19||(LA15_2>=25 && LA15_2<=26)||LA15_2==30||(LA15_2>=34 && LA15_2<=35)||(LA15_2>=37 && LA15_2<=40)) ) {
                            alt15=2;
                        }
                        else if ( (LA15_2==20||LA15_2==23||LA15_2==29||LA15_2==36) ) {
                            alt15=1;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 15, 2, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 15, 0, input);

                        throw nvae;
                    }
                    switch (alt15) {
                        case 1 :
                            // InternalQVTcore.g:500:2: ( (lv_ownedUnrealizedVariables_10_0= ruleUnrealizedVariableCS ) )
                            {
                            // InternalQVTcore.g:500:2: ( (lv_ownedUnrealizedVariables_10_0= ruleUnrealizedVariableCS ) )
                            // InternalQVTcore.g:501:1: (lv_ownedUnrealizedVariables_10_0= ruleUnrealizedVariableCS )
                            {
                            // InternalQVTcore.g:501:1: (lv_ownedUnrealizedVariables_10_0= ruleUnrealizedVariableCS )
                            // InternalQVTcore.g:502:3: lv_ownedUnrealizedVariables_10_0= ruleUnrealizedVariableCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getBottomPatternCSAccess().getOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_1_1_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_16);
                            lv_ownedUnrealizedVariables_10_0=ruleUnrealizedVariableCS();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getBottomPatternCSRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"ownedUnrealizedVariables",
                                      		lv_ownedUnrealizedVariables_10_0, 
                                      		"org.eclipse.qvtd.xtext.qvtcorebase.QVTcoreBase.UnrealizedVariableCS");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalQVTcore.g:519:6: ( (lv_ownedRealizedVariables_11_0= ruleRealizedVariableCS ) )
                            {
                            // InternalQVTcore.g:519:6: ( (lv_ownedRealizedVariables_11_0= ruleRealizedVariableCS ) )
                            // InternalQVTcore.g:520:1: (lv_ownedRealizedVariables_11_0= ruleRealizedVariableCS )
                            {
                            // InternalQVTcore.g:520:1: (lv_ownedRealizedVariables_11_0= ruleRealizedVariableCS )
                            // InternalQVTcore.g:521:3: lv_ownedRealizedVariables_11_0= ruleRealizedVariableCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getBottomPatternCSAccess().getOwnedRealizedVariablesRealizedVariableCSParserRuleCall_1_1_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_16);
                            lv_ownedRealizedVariables_11_0=ruleRealizedVariableCS();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getBottomPatternCSRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"ownedRealizedVariables",
                                      		lv_ownedRealizedVariables_11_0, 
                                      		"org.eclipse.qvtd.xtext.qvtcorebase.QVTcoreBase.RealizedVariableCS");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;

                    }

                    // InternalQVTcore.g:537:3: (otherlv_12= ',' ( ( (lv_ownedUnrealizedVariables_13_0= ruleUnrealizedVariableCS ) ) | ( (lv_ownedRealizedVariables_14_0= ruleRealizedVariableCS ) ) ) )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==20) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // InternalQVTcore.g:537:5: otherlv_12= ',' ( ( (lv_ownedUnrealizedVariables_13_0= ruleUnrealizedVariableCS ) ) | ( (lv_ownedRealizedVariables_14_0= ruleRealizedVariableCS ) ) )
                    	    {
                    	    otherlv_12=(Token)match(input,20,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_12, grammarAccess.getBottomPatternCSAccess().getCommaKeyword_1_2_0());
                    	          
                    	    }
                    	    // InternalQVTcore.g:541:1: ( ( (lv_ownedUnrealizedVariables_13_0= ruleUnrealizedVariableCS ) ) | ( (lv_ownedRealizedVariables_14_0= ruleRealizedVariableCS ) ) )
                    	    int alt16=2;
                    	    int LA16_0 = input.LA(1);

                    	    if ( ((LA16_0>=RULE_SIMPLE_ID && LA16_0<=RULE_ESCAPED_ID)||LA16_0==17||LA16_0==19||(LA16_0>=25 && LA16_0<=26)||LA16_0==30||(LA16_0>=34 && LA16_0<=35)||(LA16_0>=37 && LA16_0<=38)||LA16_0==40) ) {
                    	        alt16=1;
                    	    }
                    	    else if ( (LA16_0==39) ) {
                    	        int LA16_2 = input.LA(2);

                    	        if ( (LA16_2==20||LA16_2==23||LA16_2==29||LA16_2==36) ) {
                    	            alt16=1;
                    	        }
                    	        else if ( ((LA16_2>=RULE_SIMPLE_ID && LA16_2<=RULE_ESCAPED_ID)||LA16_2==17||LA16_2==19||(LA16_2>=25 && LA16_2<=26)||LA16_2==30||(LA16_2>=34 && LA16_2<=35)||(LA16_2>=37 && LA16_2<=40)) ) {
                    	            alt16=2;
                    	        }
                    	        else {
                    	            if (state.backtracking>0) {state.failed=true; return current;}
                    	            NoViableAltException nvae =
                    	                new NoViableAltException("", 16, 2, input);

                    	            throw nvae;
                    	        }
                    	    }
                    	    else {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 16, 0, input);

                    	        throw nvae;
                    	    }
                    	    switch (alt16) {
                    	        case 1 :
                    	            // InternalQVTcore.g:541:2: ( (lv_ownedUnrealizedVariables_13_0= ruleUnrealizedVariableCS ) )
                    	            {
                    	            // InternalQVTcore.g:541:2: ( (lv_ownedUnrealizedVariables_13_0= ruleUnrealizedVariableCS ) )
                    	            // InternalQVTcore.g:542:1: (lv_ownedUnrealizedVariables_13_0= ruleUnrealizedVariableCS )
                    	            {
                    	            // InternalQVTcore.g:542:1: (lv_ownedUnrealizedVariables_13_0= ruleUnrealizedVariableCS )
                    	            // InternalQVTcore.g:543:3: lv_ownedUnrealizedVariables_13_0= ruleUnrealizedVariableCS
                    	            {
                    	            if ( state.backtracking==0 ) {
                    	               
                    	              	        newCompositeNode(grammarAccess.getBottomPatternCSAccess().getOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_1_2_1_0_0()); 
                    	              	    
                    	            }
                    	            pushFollow(FollowSets000.FOLLOW_16);
                    	            lv_ownedUnrealizedVariables_13_0=ruleUnrealizedVariableCS();

                    	            state._fsp--;
                    	            if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElementForParent(grammarAccess.getBottomPatternCSRule());
                    	              	        }
                    	                     		add(
                    	                     			current, 
                    	                     			"ownedUnrealizedVariables",
                    	                      		lv_ownedUnrealizedVariables_13_0, 
                    	                      		"org.eclipse.qvtd.xtext.qvtcorebase.QVTcoreBase.UnrealizedVariableCS");
                    	              	        afterParserOrEnumRuleCall();
                    	              	    
                    	            }

                    	            }


                    	            }


                    	            }
                    	            break;
                    	        case 2 :
                    	            // InternalQVTcore.g:560:6: ( (lv_ownedRealizedVariables_14_0= ruleRealizedVariableCS ) )
                    	            {
                    	            // InternalQVTcore.g:560:6: ( (lv_ownedRealizedVariables_14_0= ruleRealizedVariableCS ) )
                    	            // InternalQVTcore.g:561:1: (lv_ownedRealizedVariables_14_0= ruleRealizedVariableCS )
                    	            {
                    	            // InternalQVTcore.g:561:1: (lv_ownedRealizedVariables_14_0= ruleRealizedVariableCS )
                    	            // InternalQVTcore.g:562:3: lv_ownedRealizedVariables_14_0= ruleRealizedVariableCS
                    	            {
                    	            if ( state.backtracking==0 ) {
                    	               
                    	              	        newCompositeNode(grammarAccess.getBottomPatternCSAccess().getOwnedRealizedVariablesRealizedVariableCSParserRuleCall_1_2_1_1_0()); 
                    	              	    
                    	            }
                    	            pushFollow(FollowSets000.FOLLOW_16);
                    	            lv_ownedRealizedVariables_14_0=ruleRealizedVariableCS();

                    	            state._fsp--;
                    	            if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElementForParent(grammarAccess.getBottomPatternCSRule());
                    	              	        }
                    	                     		add(
                    	                     			current, 
                    	                     			"ownedRealizedVariables",
                    	                      		lv_ownedRealizedVariables_14_0, 
                    	                      		"org.eclipse.qvtd.xtext.qvtcorebase.QVTcoreBase.RealizedVariableCS");
                    	              	        afterParserOrEnumRuleCall();
                    	              	    
                    	            }

                    	            }


                    	            }


                    	            }
                    	            break;

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop17;
                        }
                    } while (true);

                    otherlv_15=(Token)match(input,23,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_15, grammarAccess.getBottomPatternCSAccess().getRightCurlyBracketKeyword_1_3());
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalQVTcore.g:583:6: (otherlv_16= '{' ( (lv_ownedConstraints_17_0= rulePredicateOrAssignmentCS ) )+ otherlv_18= '}' )
                    {
                    // InternalQVTcore.g:583:6: (otherlv_16= '{' ( (lv_ownedConstraints_17_0= rulePredicateOrAssignmentCS ) )+ otherlv_18= '}' )
                    // InternalQVTcore.g:583:8: otherlv_16= '{' ( (lv_ownedConstraints_17_0= rulePredicateOrAssignmentCS ) )+ otherlv_18= '}'
                    {
                    otherlv_16=(Token)match(input,21,FollowSets000.FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_16, grammarAccess.getBottomPatternCSAccess().getLeftCurlyBracketKeyword_2_0());
                          
                    }
                    // InternalQVTcore.g:587:1: ( (lv_ownedConstraints_17_0= rulePredicateOrAssignmentCS ) )+
                    int cnt18=0;
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( ((LA18_0>=RULE_SIMPLE_ID && LA18_0<=RULE_SINGLE_QUOTED_STRING)||(LA18_0>=16 && LA18_0<=17)||LA18_0==19||(LA18_0>=25 && LA18_0<=27)||LA18_0==30||LA18_0==32||(LA18_0>=34 && LA18_0<=35)||(LA18_0>=37 && LA18_0<=42)||(LA18_0>=59 && LA18_0<=73)||LA18_0==76||(LA18_0>=78 && LA18_0<=81)||LA18_0==86||(LA18_0>=91 && LA18_0<=92)) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // InternalQVTcore.g:588:1: (lv_ownedConstraints_17_0= rulePredicateOrAssignmentCS )
                    	    {
                    	    // InternalQVTcore.g:588:1: (lv_ownedConstraints_17_0= rulePredicateOrAssignmentCS )
                    	    // InternalQVTcore.g:589:3: lv_ownedConstraints_17_0= rulePredicateOrAssignmentCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getBottomPatternCSAccess().getOwnedConstraintsPredicateOrAssignmentCSParserRuleCall_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_15);
                    	    lv_ownedConstraints_17_0=rulePredicateOrAssignmentCS();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getBottomPatternCSRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"ownedConstraints",
                    	              		lv_ownedConstraints_17_0, 
                    	              		"org.eclipse.qvtd.xtext.qvtcorebase.QVTcoreBase.PredicateOrAssignmentCS");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt18 >= 1 ) break loop18;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(18, input);
                                throw eee;
                        }
                        cnt18++;
                    } while (true);

                    otherlv_18=(Token)match(input,23,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_18, grammarAccess.getBottomPatternCSAccess().getRightCurlyBracketKeyword_2_2());
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalQVTcore.g:610:6: ( () otherlv_20= '{' otherlv_21= '}' )
                    {
                    // InternalQVTcore.g:610:6: ( () otherlv_20= '{' otherlv_21= '}' )
                    // InternalQVTcore.g:610:7: () otherlv_20= '{' otherlv_21= '}'
                    {
                    // InternalQVTcore.g:610:7: ()
                    // InternalQVTcore.g:611:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getBottomPatternCSAccess().getBottomPatternCSAction_3_0(),
                                  current);
                          
                    }

                    }

                    otherlv_20=(Token)match(input,21,FollowSets000.FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_20, grammarAccess.getBottomPatternCSAccess().getLeftCurlyBracketKeyword_3_1());
                          
                    }
                    otherlv_21=(Token)match(input,23,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_21, grammarAccess.getBottomPatternCSAccess().getRightCurlyBracketKeyword_3_2());
                          
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
    // $ANTLR end "ruleBottomPatternCS"


    // $ANTLR start "entryRuleDirectionCS"
    // InternalQVTcore.g:635:1: entryRuleDirectionCS returns [EObject current=null] : iv_ruleDirectionCS= ruleDirectionCS EOF ;
    public final EObject entryRuleDirectionCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDirectionCS = null;


        try {
            // InternalQVTcore.g:636:2: (iv_ruleDirectionCS= ruleDirectionCS EOF )
            // InternalQVTcore.g:637:2: iv_ruleDirectionCS= ruleDirectionCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDirectionCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDirectionCS=ruleDirectionCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDirectionCS; 
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
    // $ANTLR end "entryRuleDirectionCS"


    // $ANTLR start "ruleDirectionCS"
    // InternalQVTcore.g:644:1: ruleDirectionCS returns [EObject current=null] : ( () ( (lv_name_1_0= ruleUnrestrictedName ) )? otherlv_2= 'imports' ( ( ruleUnrestrictedName ) ) (otherlv_4= ',' ( ( ruleUnrestrictedName ) ) )* (otherlv_6= 'uses' ( ( ruleUnrestrictedName ) ) (otherlv_8= ',' ( ( ruleUnrestrictedName ) ) )* )? ) ;
    public final EObject ruleDirectionCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTcore.g:647:28: ( ( () ( (lv_name_1_0= ruleUnrestrictedName ) )? otherlv_2= 'imports' ( ( ruleUnrestrictedName ) ) (otherlv_4= ',' ( ( ruleUnrestrictedName ) ) )* (otherlv_6= 'uses' ( ( ruleUnrestrictedName ) ) (otherlv_8= ',' ( ( ruleUnrestrictedName ) ) )* )? ) )
            // InternalQVTcore.g:648:1: ( () ( (lv_name_1_0= ruleUnrestrictedName ) )? otherlv_2= 'imports' ( ( ruleUnrestrictedName ) ) (otherlv_4= ',' ( ( ruleUnrestrictedName ) ) )* (otherlv_6= 'uses' ( ( ruleUnrestrictedName ) ) (otherlv_8= ',' ( ( ruleUnrestrictedName ) ) )* )? )
            {
            // InternalQVTcore.g:648:1: ( () ( (lv_name_1_0= ruleUnrestrictedName ) )? otherlv_2= 'imports' ( ( ruleUnrestrictedName ) ) (otherlv_4= ',' ( ( ruleUnrestrictedName ) ) )* (otherlv_6= 'uses' ( ( ruleUnrestrictedName ) ) (otherlv_8= ',' ( ( ruleUnrestrictedName ) ) )* )? )
            // InternalQVTcore.g:648:2: () ( (lv_name_1_0= ruleUnrestrictedName ) )? otherlv_2= 'imports' ( ( ruleUnrestrictedName ) ) (otherlv_4= ',' ( ( ruleUnrestrictedName ) ) )* (otherlv_6= 'uses' ( ( ruleUnrestrictedName ) ) (otherlv_8= ',' ( ( ruleUnrestrictedName ) ) )* )?
            {
            // InternalQVTcore.g:648:2: ()
            // InternalQVTcore.g:649:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getDirectionCSAccess().getDirectionCSAction_0(),
                          current);
                  
            }

            }

            // InternalQVTcore.g:657:2: ( (lv_name_1_0= ruleUnrestrictedName ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( ((LA20_0>=RULE_SIMPLE_ID && LA20_0<=RULE_ESCAPED_ID)||LA20_0==17||LA20_0==19||LA20_0==26||LA20_0==30||(LA20_0>=34 && LA20_0<=35)||(LA20_0>=37 && LA20_0<=40)) ) {
                alt20=1;
            }
            else if ( (LA20_0==25) ) {
                int LA20_2 = input.LA(2);

                if ( (LA20_2==25) ) {
                    int LA20_4 = input.LA(3);

                    if ( (LA20_4==26) ) {
                        int LA20_5 = input.LA(4);

                        if ( (LA20_5==26) ) {
                            int LA20_6 = input.LA(5);

                            if ( ((LA20_6>=RULE_SIMPLE_ID && LA20_6<=RULE_ESCAPED_ID)||LA20_6==17||LA20_6==19||(LA20_6>=25 && LA20_6<=26)||LA20_6==30||(LA20_6>=34 && LA20_6<=35)||(LA20_6>=37 && LA20_6<=40)) ) {
                                alt20=1;
                            }
                        }
                        else if ( (LA20_5==EOF||LA20_5==20||LA20_5==33) ) {
                            alt20=1;
                        }
                    }
                    else if ( ((LA20_4>=RULE_SIMPLE_ID && LA20_4<=RULE_ESCAPED_ID)||LA20_4==17||LA20_4==19||LA20_4==25||LA20_4==30||(LA20_4>=34 && LA20_4<=35)||(LA20_4>=37 && LA20_4<=40)) ) {
                        alt20=1;
                    }
                }
            }
            switch (alt20) {
                case 1 :
                    // InternalQVTcore.g:658:1: (lv_name_1_0= ruleUnrestrictedName )
                    {
                    // InternalQVTcore.g:658:1: (lv_name_1_0= ruleUnrestrictedName )
                    // InternalQVTcore.g:659:3: lv_name_1_0= ruleUnrestrictedName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDirectionCSAccess().getNameUnrestrictedNameParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_19);
                    lv_name_1_0=ruleUnrestrictedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getDirectionCSRule());
                      	        }
                             		set(
                             			current, 
                             			"name",
                              		lv_name_1_0, 
                              		"org.eclipse.qvtd.xtext.qvtcorebase.QVTcoreBase.UnrestrictedName");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,25,FollowSets000.FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getDirectionCSAccess().getImportsKeyword_2());
                  
            }
            // InternalQVTcore.g:679:1: ( ( ruleUnrestrictedName ) )
            // InternalQVTcore.g:680:1: ( ruleUnrestrictedName )
            {
            // InternalQVTcore.g:680:1: ( ruleUnrestrictedName )
            // InternalQVTcore.g:681:3: ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getDirectionCSRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDirectionCSAccess().getImportsPackageCrossReference_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_20);
            ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalQVTcore.g:697:2: (otherlv_4= ',' ( ( ruleUnrestrictedName ) ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==20) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalQVTcore.g:697:4: otherlv_4= ',' ( ( ruleUnrestrictedName ) )
            	    {
            	    otherlv_4=(Token)match(input,20,FollowSets000.FOLLOW_8); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_4, grammarAccess.getDirectionCSAccess().getCommaKeyword_4_0());
            	          
            	    }
            	    // InternalQVTcore.g:701:1: ( ( ruleUnrestrictedName ) )
            	    // InternalQVTcore.g:702:1: ( ruleUnrestrictedName )
            	    {
            	    // InternalQVTcore.g:702:1: ( ruleUnrestrictedName )
            	    // InternalQVTcore.g:703:3: ruleUnrestrictedName
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      		  /* */ 
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getDirectionCSRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getDirectionCSAccess().getImportsPackageCrossReference_4_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_20);
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

            	default :
            	    break loop21;
                }
            } while (true);

            // InternalQVTcore.g:719:4: (otherlv_6= 'uses' ( ( ruleUnrestrictedName ) ) (otherlv_8= ',' ( ( ruleUnrestrictedName ) ) )* )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==26) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalQVTcore.g:719:6: otherlv_6= 'uses' ( ( ruleUnrestrictedName ) ) (otherlv_8= ',' ( ( ruleUnrestrictedName ) ) )*
                    {
                    otherlv_6=(Token)match(input,26,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getDirectionCSAccess().getUsesKeyword_5_0());
                          
                    }
                    // InternalQVTcore.g:723:1: ( ( ruleUnrestrictedName ) )
                    // InternalQVTcore.g:724:1: ( ruleUnrestrictedName )
                    {
                    // InternalQVTcore.g:724:1: ( ruleUnrestrictedName )
                    // InternalQVTcore.g:725:3: ruleUnrestrictedName
                    {
                    if ( state.backtracking==0 ) {
                       
                      		  /* */ 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getDirectionCSRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDirectionCSAccess().getUsesCoreDomainCrossReference_5_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_21);
                    ruleUnrestrictedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalQVTcore.g:741:2: (otherlv_8= ',' ( ( ruleUnrestrictedName ) ) )*
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==20) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // InternalQVTcore.g:741:4: otherlv_8= ',' ( ( ruleUnrestrictedName ) )
                    	    {
                    	    otherlv_8=(Token)match(input,20,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_8, grammarAccess.getDirectionCSAccess().getCommaKeyword_5_2_0());
                    	          
                    	    }
                    	    // InternalQVTcore.g:745:1: ( ( ruleUnrestrictedName ) )
                    	    // InternalQVTcore.g:746:1: ( ruleUnrestrictedName )
                    	    {
                    	    // InternalQVTcore.g:746:1: ( ruleUnrestrictedName )
                    	    // InternalQVTcore.g:747:3: ruleUnrestrictedName
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      		  /* */ 
                    	      		
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      			if (current==null) {
                    	      	            current = createModelElement(grammarAccess.getDirectionCSRule());
                    	      	        }
                    	              
                    	    }
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getDirectionCSAccess().getUsesCoreDomainCrossReference_5_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_21);
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

                    	default :
                    	    break loop22;
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
    // $ANTLR end "ruleDirectionCS"


    // $ANTLR start "entryRuleGuardPatternCS"
    // InternalQVTcore.g:771:1: entryRuleGuardPatternCS returns [EObject current=null] : iv_ruleGuardPatternCS= ruleGuardPatternCS EOF ;
    public final EObject entryRuleGuardPatternCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGuardPatternCS = null;


        try {
            // InternalQVTcore.g:772:2: (iv_ruleGuardPatternCS= ruleGuardPatternCS EOF )
            // InternalQVTcore.g:773:2: iv_ruleGuardPatternCS= ruleGuardPatternCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGuardPatternCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleGuardPatternCS=ruleGuardPatternCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleGuardPatternCS; 
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
    // $ANTLR end "entryRuleGuardPatternCS"


    // $ANTLR start "ruleGuardPatternCS"
    // InternalQVTcore.g:780:1: ruleGuardPatternCS returns [EObject current=null] : ( (otherlv_0= '(' ( (lv_ownedUnrealizedVariables_1_0= ruleGuardVariableCS ) ) (otherlv_2= ',' ( (lv_ownedUnrealizedVariables_3_0= ruleGuardVariableCS ) ) )* otherlv_4= '|' ( (lv_ownedPredicates_5_0= rulePredicateCS ) )* otherlv_6= ')' ) | (otherlv_7= '(' ( (lv_ownedUnrealizedVariables_8_0= ruleGuardVariableCS ) ) (otherlv_9= ',' ( (lv_ownedUnrealizedVariables_10_0= ruleGuardVariableCS ) ) )* otherlv_11= ')' ) | (otherlv_12= '(' ( (lv_ownedPredicates_13_0= rulePredicateCS ) )+ otherlv_14= ')' ) | ( () otherlv_16= '(' otherlv_17= ')' ) ) ;
    public final EObject ruleGuardPatternCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        EObject lv_ownedUnrealizedVariables_1_0 = null;

        EObject lv_ownedUnrealizedVariables_3_0 = null;

        EObject lv_ownedPredicates_5_0 = null;

        EObject lv_ownedUnrealizedVariables_8_0 = null;

        EObject lv_ownedUnrealizedVariables_10_0 = null;

        EObject lv_ownedPredicates_13_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTcore.g:783:28: ( ( (otherlv_0= '(' ( (lv_ownedUnrealizedVariables_1_0= ruleGuardVariableCS ) ) (otherlv_2= ',' ( (lv_ownedUnrealizedVariables_3_0= ruleGuardVariableCS ) ) )* otherlv_4= '|' ( (lv_ownedPredicates_5_0= rulePredicateCS ) )* otherlv_6= ')' ) | (otherlv_7= '(' ( (lv_ownedUnrealizedVariables_8_0= ruleGuardVariableCS ) ) (otherlv_9= ',' ( (lv_ownedUnrealizedVariables_10_0= ruleGuardVariableCS ) ) )* otherlv_11= ')' ) | (otherlv_12= '(' ( (lv_ownedPredicates_13_0= rulePredicateCS ) )+ otherlv_14= ')' ) | ( () otherlv_16= '(' otherlv_17= ')' ) ) )
            // InternalQVTcore.g:784:1: ( (otherlv_0= '(' ( (lv_ownedUnrealizedVariables_1_0= ruleGuardVariableCS ) ) (otherlv_2= ',' ( (lv_ownedUnrealizedVariables_3_0= ruleGuardVariableCS ) ) )* otherlv_4= '|' ( (lv_ownedPredicates_5_0= rulePredicateCS ) )* otherlv_6= ')' ) | (otherlv_7= '(' ( (lv_ownedUnrealizedVariables_8_0= ruleGuardVariableCS ) ) (otherlv_9= ',' ( (lv_ownedUnrealizedVariables_10_0= ruleGuardVariableCS ) ) )* otherlv_11= ')' ) | (otherlv_12= '(' ( (lv_ownedPredicates_13_0= rulePredicateCS ) )+ otherlv_14= ')' ) | ( () otherlv_16= '(' otherlv_17= ')' ) )
            {
            // InternalQVTcore.g:784:1: ( (otherlv_0= '(' ( (lv_ownedUnrealizedVariables_1_0= ruleGuardVariableCS ) ) (otherlv_2= ',' ( (lv_ownedUnrealizedVariables_3_0= ruleGuardVariableCS ) ) )* otherlv_4= '|' ( (lv_ownedPredicates_5_0= rulePredicateCS ) )* otherlv_6= ')' ) | (otherlv_7= '(' ( (lv_ownedUnrealizedVariables_8_0= ruleGuardVariableCS ) ) (otherlv_9= ',' ( (lv_ownedUnrealizedVariables_10_0= ruleGuardVariableCS ) ) )* otherlv_11= ')' ) | (otherlv_12= '(' ( (lv_ownedPredicates_13_0= rulePredicateCS ) )+ otherlv_14= ')' ) | ( () otherlv_16= '(' otherlv_17= ')' ) )
            int alt28=4;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==27) ) {
                int LA28_1 = input.LA(2);

                if ( (synpred30_InternalQVTcore()) ) {
                    alt28=1;
                }
                else if ( (synpred32_InternalQVTcore()) ) {
                    alt28=2;
                }
                else if ( (synpred34_InternalQVTcore()) ) {
                    alt28=3;
                }
                else if ( (true) ) {
                    alt28=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 28, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // InternalQVTcore.g:784:2: (otherlv_0= '(' ( (lv_ownedUnrealizedVariables_1_0= ruleGuardVariableCS ) ) (otherlv_2= ',' ( (lv_ownedUnrealizedVariables_3_0= ruleGuardVariableCS ) ) )* otherlv_4= '|' ( (lv_ownedPredicates_5_0= rulePredicateCS ) )* otherlv_6= ')' )
                    {
                    // InternalQVTcore.g:784:2: (otherlv_0= '(' ( (lv_ownedUnrealizedVariables_1_0= ruleGuardVariableCS ) ) (otherlv_2= ',' ( (lv_ownedUnrealizedVariables_3_0= ruleGuardVariableCS ) ) )* otherlv_4= '|' ( (lv_ownedPredicates_5_0= rulePredicateCS ) )* otherlv_6= ')' )
                    // InternalQVTcore.g:784:4: otherlv_0= '(' ( (lv_ownedUnrealizedVariables_1_0= ruleGuardVariableCS ) ) (otherlv_2= ',' ( (lv_ownedUnrealizedVariables_3_0= ruleGuardVariableCS ) ) )* otherlv_4= '|' ( (lv_ownedPredicates_5_0= rulePredicateCS ) )* otherlv_6= ')'
                    {
                    otherlv_0=(Token)match(input,27,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getGuardPatternCSAccess().getLeftParenthesisKeyword_0_0());
                          
                    }
                    // InternalQVTcore.g:788:1: ( (lv_ownedUnrealizedVariables_1_0= ruleGuardVariableCS ) )
                    // InternalQVTcore.g:789:1: (lv_ownedUnrealizedVariables_1_0= ruleGuardVariableCS )
                    {
                    // InternalQVTcore.g:789:1: (lv_ownedUnrealizedVariables_1_0= ruleGuardVariableCS )
                    // InternalQVTcore.g:790:3: lv_ownedUnrealizedVariables_1_0= ruleGuardVariableCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getGuardPatternCSAccess().getOwnedUnrealizedVariablesGuardVariableCSParserRuleCall_0_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_14);
                    lv_ownedUnrealizedVariables_1_0=ruleGuardVariableCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getGuardPatternCSRule());
                      	        }
                             		add(
                             			current, 
                             			"ownedUnrealizedVariables",
                              		lv_ownedUnrealizedVariables_1_0, 
                              		"org.eclipse.qvtd.xtext.qvtcorebase.QVTcoreBase.GuardVariableCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalQVTcore.g:806:2: (otherlv_2= ',' ( (lv_ownedUnrealizedVariables_3_0= ruleGuardVariableCS ) ) )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==20) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // InternalQVTcore.g:806:4: otherlv_2= ',' ( (lv_ownedUnrealizedVariables_3_0= ruleGuardVariableCS ) )
                    	    {
                    	    otherlv_2=(Token)match(input,20,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_2, grammarAccess.getGuardPatternCSAccess().getCommaKeyword_0_2_0());
                    	          
                    	    }
                    	    // InternalQVTcore.g:810:1: ( (lv_ownedUnrealizedVariables_3_0= ruleGuardVariableCS ) )
                    	    // InternalQVTcore.g:811:1: (lv_ownedUnrealizedVariables_3_0= ruleGuardVariableCS )
                    	    {
                    	    // InternalQVTcore.g:811:1: (lv_ownedUnrealizedVariables_3_0= ruleGuardVariableCS )
                    	    // InternalQVTcore.g:812:3: lv_ownedUnrealizedVariables_3_0= ruleGuardVariableCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getGuardPatternCSAccess().getOwnedUnrealizedVariablesGuardVariableCSParserRuleCall_0_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_14);
                    	    lv_ownedUnrealizedVariables_3_0=ruleGuardVariableCS();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getGuardPatternCSRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"ownedUnrealizedVariables",
                    	              		lv_ownedUnrealizedVariables_3_0, 
                    	              		"org.eclipse.qvtd.xtext.qvtcorebase.QVTcoreBase.GuardVariableCS");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop24;
                        }
                    } while (true);

                    otherlv_4=(Token)match(input,24,FollowSets000.FOLLOW_22); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getGuardPatternCSAccess().getVerticalLineKeyword_0_3());
                          
                    }
                    // InternalQVTcore.g:832:1: ( (lv_ownedPredicates_5_0= rulePredicateCS ) )*
                    loop25:
                    do {
                        int alt25=2;
                        int LA25_0 = input.LA(1);

                        if ( ((LA25_0>=RULE_SIMPLE_ID && LA25_0<=RULE_SINGLE_QUOTED_STRING)||LA25_0==17||LA25_0==19||(LA25_0>=25 && LA25_0<=27)||LA25_0==30||LA25_0==32||(LA25_0>=34 && LA25_0<=35)||(LA25_0>=37 && LA25_0<=42)||(LA25_0>=59 && LA25_0<=73)||LA25_0==76||(LA25_0>=78 && LA25_0<=81)||LA25_0==86||(LA25_0>=91 && LA25_0<=92)) ) {
                            alt25=1;
                        }


                        switch (alt25) {
                    	case 1 :
                    	    // InternalQVTcore.g:833:1: (lv_ownedPredicates_5_0= rulePredicateCS )
                    	    {
                    	    // InternalQVTcore.g:833:1: (lv_ownedPredicates_5_0= rulePredicateCS )
                    	    // InternalQVTcore.g:834:3: lv_ownedPredicates_5_0= rulePredicateCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getGuardPatternCSAccess().getOwnedPredicatesPredicateCSParserRuleCall_0_4_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_22);
                    	    lv_ownedPredicates_5_0=rulePredicateCS();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getGuardPatternCSRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"ownedPredicates",
                    	              		lv_ownedPredicates_5_0, 
                    	              		"org.eclipse.qvtd.xtext.qvtcorebase.QVTcoreBase.PredicateCS");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop25;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,28,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getGuardPatternCSAccess().getRightParenthesisKeyword_0_5());
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalQVTcore.g:855:6: (otherlv_7= '(' ( (lv_ownedUnrealizedVariables_8_0= ruleGuardVariableCS ) ) (otherlv_9= ',' ( (lv_ownedUnrealizedVariables_10_0= ruleGuardVariableCS ) ) )* otherlv_11= ')' )
                    {
                    // InternalQVTcore.g:855:6: (otherlv_7= '(' ( (lv_ownedUnrealizedVariables_8_0= ruleGuardVariableCS ) ) (otherlv_9= ',' ( (lv_ownedUnrealizedVariables_10_0= ruleGuardVariableCS ) ) )* otherlv_11= ')' )
                    // InternalQVTcore.g:855:8: otherlv_7= '(' ( (lv_ownedUnrealizedVariables_8_0= ruleGuardVariableCS ) ) (otherlv_9= ',' ( (lv_ownedUnrealizedVariables_10_0= ruleGuardVariableCS ) ) )* otherlv_11= ')'
                    {
                    otherlv_7=(Token)match(input,27,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getGuardPatternCSAccess().getLeftParenthesisKeyword_1_0());
                          
                    }
                    // InternalQVTcore.g:859:1: ( (lv_ownedUnrealizedVariables_8_0= ruleGuardVariableCS ) )
                    // InternalQVTcore.g:860:1: (lv_ownedUnrealizedVariables_8_0= ruleGuardVariableCS )
                    {
                    // InternalQVTcore.g:860:1: (lv_ownedUnrealizedVariables_8_0= ruleGuardVariableCS )
                    // InternalQVTcore.g:861:3: lv_ownedUnrealizedVariables_8_0= ruleGuardVariableCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getGuardPatternCSAccess().getOwnedUnrealizedVariablesGuardVariableCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_23);
                    lv_ownedUnrealizedVariables_8_0=ruleGuardVariableCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getGuardPatternCSRule());
                      	        }
                             		add(
                             			current, 
                             			"ownedUnrealizedVariables",
                              		lv_ownedUnrealizedVariables_8_0, 
                              		"org.eclipse.qvtd.xtext.qvtcorebase.QVTcoreBase.GuardVariableCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalQVTcore.g:877:2: (otherlv_9= ',' ( (lv_ownedUnrealizedVariables_10_0= ruleGuardVariableCS ) ) )*
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==20) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // InternalQVTcore.g:877:4: otherlv_9= ',' ( (lv_ownedUnrealizedVariables_10_0= ruleGuardVariableCS ) )
                    	    {
                    	    otherlv_9=(Token)match(input,20,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_9, grammarAccess.getGuardPatternCSAccess().getCommaKeyword_1_2_0());
                    	          
                    	    }
                    	    // InternalQVTcore.g:881:1: ( (lv_ownedUnrealizedVariables_10_0= ruleGuardVariableCS ) )
                    	    // InternalQVTcore.g:882:1: (lv_ownedUnrealizedVariables_10_0= ruleGuardVariableCS )
                    	    {
                    	    // InternalQVTcore.g:882:1: (lv_ownedUnrealizedVariables_10_0= ruleGuardVariableCS )
                    	    // InternalQVTcore.g:883:3: lv_ownedUnrealizedVariables_10_0= ruleGuardVariableCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getGuardPatternCSAccess().getOwnedUnrealizedVariablesGuardVariableCSParserRuleCall_1_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_23);
                    	    lv_ownedUnrealizedVariables_10_0=ruleGuardVariableCS();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getGuardPatternCSRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"ownedUnrealizedVariables",
                    	              		lv_ownedUnrealizedVariables_10_0, 
                    	              		"org.eclipse.qvtd.xtext.qvtcorebase.QVTcoreBase.GuardVariableCS");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop26;
                        }
                    } while (true);

                    otherlv_11=(Token)match(input,28,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_11, grammarAccess.getGuardPatternCSAccess().getRightParenthesisKeyword_1_3());
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalQVTcore.g:904:6: (otherlv_12= '(' ( (lv_ownedPredicates_13_0= rulePredicateCS ) )+ otherlv_14= ')' )
                    {
                    // InternalQVTcore.g:904:6: (otherlv_12= '(' ( (lv_ownedPredicates_13_0= rulePredicateCS ) )+ otherlv_14= ')' )
                    // InternalQVTcore.g:904:8: otherlv_12= '(' ( (lv_ownedPredicates_13_0= rulePredicateCS ) )+ otherlv_14= ')'
                    {
                    otherlv_12=(Token)match(input,27,FollowSets000.FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_12, grammarAccess.getGuardPatternCSAccess().getLeftParenthesisKeyword_2_0());
                          
                    }
                    // InternalQVTcore.g:908:1: ( (lv_ownedPredicates_13_0= rulePredicateCS ) )+
                    int cnt27=0;
                    loop27:
                    do {
                        int alt27=2;
                        int LA27_0 = input.LA(1);

                        if ( ((LA27_0>=RULE_SIMPLE_ID && LA27_0<=RULE_SINGLE_QUOTED_STRING)||LA27_0==17||LA27_0==19||(LA27_0>=25 && LA27_0<=27)||LA27_0==30||LA27_0==32||(LA27_0>=34 && LA27_0<=35)||(LA27_0>=37 && LA27_0<=42)||(LA27_0>=59 && LA27_0<=73)||LA27_0==76||(LA27_0>=78 && LA27_0<=81)||LA27_0==86||(LA27_0>=91 && LA27_0<=92)) ) {
                            alt27=1;
                        }


                        switch (alt27) {
                    	case 1 :
                    	    // InternalQVTcore.g:909:1: (lv_ownedPredicates_13_0= rulePredicateCS )
                    	    {
                    	    // InternalQVTcore.g:909:1: (lv_ownedPredicates_13_0= rulePredicateCS )
                    	    // InternalQVTcore.g:910:3: lv_ownedPredicates_13_0= rulePredicateCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getGuardPatternCSAccess().getOwnedPredicatesPredicateCSParserRuleCall_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_22);
                    	    lv_ownedPredicates_13_0=rulePredicateCS();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getGuardPatternCSRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"ownedPredicates",
                    	              		lv_ownedPredicates_13_0, 
                    	              		"org.eclipse.qvtd.xtext.qvtcorebase.QVTcoreBase.PredicateCS");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt27 >= 1 ) break loop27;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(27, input);
                                throw eee;
                        }
                        cnt27++;
                    } while (true);

                    otherlv_14=(Token)match(input,28,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_14, grammarAccess.getGuardPatternCSAccess().getRightParenthesisKeyword_2_2());
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalQVTcore.g:931:6: ( () otherlv_16= '(' otherlv_17= ')' )
                    {
                    // InternalQVTcore.g:931:6: ( () otherlv_16= '(' otherlv_17= ')' )
                    // InternalQVTcore.g:931:7: () otherlv_16= '(' otherlv_17= ')'
                    {
                    // InternalQVTcore.g:931:7: ()
                    // InternalQVTcore.g:932:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getGuardPatternCSAccess().getGuardPatternCSAction_3_0(),
                                  current);
                          
                    }

                    }

                    otherlv_16=(Token)match(input,27,FollowSets000.FOLLOW_24); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_16, grammarAccess.getGuardPatternCSAccess().getLeftParenthesisKeyword_3_1());
                          
                    }
                    otherlv_17=(Token)match(input,28,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_17, grammarAccess.getGuardPatternCSAccess().getRightParenthesisKeyword_3_2());
                          
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
    // $ANTLR end "ruleGuardPatternCS"


    // $ANTLR start "entryRuleGuardVariableCS"
    // InternalQVTcore.g:956:1: entryRuleGuardVariableCS returns [EObject current=null] : iv_ruleGuardVariableCS= ruleGuardVariableCS EOF ;
    public final EObject entryRuleGuardVariableCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGuardVariableCS = null;


        try {
            // InternalQVTcore.g:957:2: (iv_ruleGuardVariableCS= ruleGuardVariableCS EOF )
            // InternalQVTcore.g:958:2: iv_ruleGuardVariableCS= ruleGuardVariableCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGuardVariableCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleGuardVariableCS=ruleGuardVariableCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleGuardVariableCS; 
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
    // $ANTLR end "entryRuleGuardVariableCS"


    // $ANTLR start "ruleGuardVariableCS"
    // InternalQVTcore.g:965:1: ruleGuardVariableCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) ) ;
    public final EObject ruleGuardVariableCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTcore.g:968:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) ) )
            // InternalQVTcore.g:969:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )
            {
            // InternalQVTcore.g:969:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )
            // InternalQVTcore.g:969:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) )
            {
            // InternalQVTcore.g:969:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // InternalQVTcore.g:970:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // InternalQVTcore.g:970:1: (lv_name_0_0= ruleUnrestrictedName )
            // InternalQVTcore.g:971:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getGuardVariableCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_25);
            lv_name_0_0=ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getGuardVariableCSRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"org.eclipse.qvtd.xtext.qvtcorebase.QVTcoreBase.UnrestrictedName");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,29,FollowSets000.FOLLOW_26); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getGuardVariableCSAccess().getColonKeyword_1());
                  
            }
            // InternalQVTcore.g:991:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
            // InternalQVTcore.g:992:1: (lv_ownedType_2_0= ruleTypeExpCS )
            {
            // InternalQVTcore.g:992:1: (lv_ownedType_2_0= ruleTypeExpCS )
            // InternalQVTcore.g:993:3: lv_ownedType_2_0= ruleTypeExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getGuardVariableCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_ownedType_2_0=ruleTypeExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getGuardVariableCSRule());
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
    // $ANTLR end "ruleGuardVariableCS"


    // $ANTLR start "entryRuleImportCS"
    // InternalQVTcore.g:1017:1: entryRuleImportCS returns [EObject current=null] : iv_ruleImportCS= ruleImportCS EOF ;
    public final EObject entryRuleImportCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportCS = null;


        try {
            // InternalQVTcore.g:1018:2: (iv_ruleImportCS= ruleImportCS EOF )
            // InternalQVTcore.g:1019:2: iv_ruleImportCS= ruleImportCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImportCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleImportCS=ruleImportCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImportCS; 
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
    // $ANTLR end "entryRuleImportCS"


    // $ANTLR start "ruleImportCS"
    // InternalQVTcore.g:1026:1: ruleImportCS returns [EObject current=null] : (otherlv_0= 'import' ( ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= ':' )? ( (lv_ownedPathName_3_0= ruleURIPathNameCS ) ) ( ( (lv_isAll_4_0= '::' ) ) otherlv_5= '*' )? otherlv_6= ';' ) ;
    public final EObject ruleImportCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_isAll_4_0=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_ownedPathName_3_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTcore.g:1029:28: ( (otherlv_0= 'import' ( ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= ':' )? ( (lv_ownedPathName_3_0= ruleURIPathNameCS ) ) ( ( (lv_isAll_4_0= '::' ) ) otherlv_5= '*' )? otherlv_6= ';' ) )
            // InternalQVTcore.g:1030:1: (otherlv_0= 'import' ( ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= ':' )? ( (lv_ownedPathName_3_0= ruleURIPathNameCS ) ) ( ( (lv_isAll_4_0= '::' ) ) otherlv_5= '*' )? otherlv_6= ';' )
            {
            // InternalQVTcore.g:1030:1: (otherlv_0= 'import' ( ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= ':' )? ( (lv_ownedPathName_3_0= ruleURIPathNameCS ) ) ( ( (lv_isAll_4_0= '::' ) ) otherlv_5= '*' )? otherlv_6= ';' )
            // InternalQVTcore.g:1030:3: otherlv_0= 'import' ( ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= ':' )? ( (lv_ownedPathName_3_0= ruleURIPathNameCS ) ) ( ( (lv_isAll_4_0= '::' ) ) otherlv_5= '*' )? otherlv_6= ';'
            {
            otherlv_0=(Token)match(input,30,FollowSets000.FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getImportCSAccess().getImportKeyword_0());
                  
            }
            // InternalQVTcore.g:1034:1: ( ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= ':' )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==RULE_SIMPLE_ID) ) {
                int LA29_1 = input.LA(2);

                if ( (LA29_1==29) ) {
                    alt29=1;
                }
            }
            else if ( (LA29_0==RULE_ESCAPED_ID) ) {
                int LA29_2 = input.LA(2);

                if ( (LA29_2==29) ) {
                    alt29=1;
                }
            }
            switch (alt29) {
                case 1 :
                    // InternalQVTcore.g:1034:2: ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= ':'
                    {
                    // InternalQVTcore.g:1034:2: ( (lv_name_1_0= ruleIdentifier ) )
                    // InternalQVTcore.g:1035:1: (lv_name_1_0= ruleIdentifier )
                    {
                    // InternalQVTcore.g:1035:1: (lv_name_1_0= ruleIdentifier )
                    // InternalQVTcore.g:1036:3: lv_name_1_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getImportCSAccess().getNameIdentifierParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_25);
                    lv_name_1_0=ruleIdentifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getImportCSRule());
                      	        }
                             		set(
                             			current, 
                             			"name",
                              		lv_name_1_0, 
                              		"org.eclipse.ocl.xtext.base.Base.Identifier");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_2=(Token)match(input,29,FollowSets000.FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getImportCSAccess().getColonKeyword_1_1());
                          
                    }

                    }
                    break;

            }

            // InternalQVTcore.g:1056:3: ( (lv_ownedPathName_3_0= ruleURIPathNameCS ) )
            // InternalQVTcore.g:1057:1: (lv_ownedPathName_3_0= ruleURIPathNameCS )
            {
            // InternalQVTcore.g:1057:1: (lv_ownedPathName_3_0= ruleURIPathNameCS )
            // InternalQVTcore.g:1058:3: lv_ownedPathName_3_0= ruleURIPathNameCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getImportCSAccess().getOwnedPathNameURIPathNameCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_28);
            lv_ownedPathName_3_0=ruleURIPathNameCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getImportCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedPathName",
                      		lv_ownedPathName_3_0, 
                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.URIPathNameCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalQVTcore.g:1074:2: ( ( (lv_isAll_4_0= '::' ) ) otherlv_5= '*' )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==31) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalQVTcore.g:1074:3: ( (lv_isAll_4_0= '::' ) ) otherlv_5= '*'
                    {
                    // InternalQVTcore.g:1074:3: ( (lv_isAll_4_0= '::' ) )
                    // InternalQVTcore.g:1075:1: (lv_isAll_4_0= '::' )
                    {
                    // InternalQVTcore.g:1075:1: (lv_isAll_4_0= '::' )
                    // InternalQVTcore.g:1076:3: lv_isAll_4_0= '::'
                    {
                    lv_isAll_4_0=(Token)match(input,31,FollowSets000.FOLLOW_29); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_isAll_4_0, grammarAccess.getImportCSAccess().getIsAllColonColonKeyword_3_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getImportCSRule());
                      	        }
                             		setWithLastConsumed(current, "isAll", true, "::");
                      	    
                    }

                    }


                    }

                    otherlv_5=(Token)match(input,32,FollowSets000.FOLLOW_30); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getImportCSAccess().getAsteriskKeyword_3_1());
                          
                    }

                    }
                    break;

            }

            otherlv_6=(Token)match(input,33,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getImportCSAccess().getSemicolonKeyword_4());
                  
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
    // $ANTLR end "ruleImportCS"


    // $ANTLR start "entryRuleNamedDomainCS"
    // InternalQVTcore.g:1105:1: entryRuleNamedDomainCS returns [EObject current=null] : iv_ruleNamedDomainCS= ruleNamedDomainCS EOF ;
    public final EObject entryRuleNamedDomainCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedDomainCS = null;


        try {
            // InternalQVTcore.g:1106:2: (iv_ruleNamedDomainCS= ruleNamedDomainCS EOF )
            // InternalQVTcore.g:1107:2: iv_ruleNamedDomainCS= ruleNamedDomainCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNamedDomainCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNamedDomainCS=ruleNamedDomainCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNamedDomainCS; 
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
    // $ANTLR end "entryRuleNamedDomainCS"


    // $ANTLR start "ruleNamedDomainCS"
    // InternalQVTcore.g:1114:1: ruleNamedDomainCS returns [EObject current=null] : ( ( (lv_isCheck_0_0= 'check' ) )? ( (lv_isEnforce_1_0= 'enforce' ) )? ( ( ruleUnrestrictedName ) ) ( (lv_ownedGuardPattern_3_0= ruleGuardPatternCS ) ) ( (lv_ownedBottomPattern_4_0= ruleBottomPatternCS ) ) ) ;
    public final EObject ruleNamedDomainCS() throws RecognitionException {
        EObject current = null;

        Token lv_isCheck_0_0=null;
        Token lv_isEnforce_1_0=null;
        EObject lv_ownedGuardPattern_3_0 = null;

        EObject lv_ownedBottomPattern_4_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTcore.g:1117:28: ( ( ( (lv_isCheck_0_0= 'check' ) )? ( (lv_isEnforce_1_0= 'enforce' ) )? ( ( ruleUnrestrictedName ) ) ( (lv_ownedGuardPattern_3_0= ruleGuardPatternCS ) ) ( (lv_ownedBottomPattern_4_0= ruleBottomPatternCS ) ) ) )
            // InternalQVTcore.g:1118:1: ( ( (lv_isCheck_0_0= 'check' ) )? ( (lv_isEnforce_1_0= 'enforce' ) )? ( ( ruleUnrestrictedName ) ) ( (lv_ownedGuardPattern_3_0= ruleGuardPatternCS ) ) ( (lv_ownedBottomPattern_4_0= ruleBottomPatternCS ) ) )
            {
            // InternalQVTcore.g:1118:1: ( ( (lv_isCheck_0_0= 'check' ) )? ( (lv_isEnforce_1_0= 'enforce' ) )? ( ( ruleUnrestrictedName ) ) ( (lv_ownedGuardPattern_3_0= ruleGuardPatternCS ) ) ( (lv_ownedBottomPattern_4_0= ruleBottomPatternCS ) ) )
            // InternalQVTcore.g:1118:2: ( (lv_isCheck_0_0= 'check' ) )? ( (lv_isEnforce_1_0= 'enforce' ) )? ( ( ruleUnrestrictedName ) ) ( (lv_ownedGuardPattern_3_0= ruleGuardPatternCS ) ) ( (lv_ownedBottomPattern_4_0= ruleBottomPatternCS ) )
            {
            // InternalQVTcore.g:1118:2: ( (lv_isCheck_0_0= 'check' ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==34) ) {
                int LA31_1 = input.LA(2);

                if ( ((LA31_1>=RULE_SIMPLE_ID && LA31_1<=RULE_ESCAPED_ID)||LA31_1==17||LA31_1==19||(LA31_1>=25 && LA31_1<=26)||LA31_1==30||(LA31_1>=34 && LA31_1<=35)||(LA31_1>=37 && LA31_1<=40)) ) {
                    alt31=1;
                }
            }
            switch (alt31) {
                case 1 :
                    // InternalQVTcore.g:1119:1: (lv_isCheck_0_0= 'check' )
                    {
                    // InternalQVTcore.g:1119:1: (lv_isCheck_0_0= 'check' )
                    // InternalQVTcore.g:1120:3: lv_isCheck_0_0= 'check'
                    {
                    lv_isCheck_0_0=(Token)match(input,34,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_isCheck_0_0, grammarAccess.getNamedDomainCSAccess().getIsCheckCheckKeyword_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getNamedDomainCSRule());
                      	        }
                             		setWithLastConsumed(current, "isCheck", true, "check");
                      	    
                    }

                    }


                    }
                    break;

            }

            // InternalQVTcore.g:1133:3: ( (lv_isEnforce_1_0= 'enforce' ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==35) ) {
                int LA32_1 = input.LA(2);

                if ( ((LA32_1>=RULE_SIMPLE_ID && LA32_1<=RULE_ESCAPED_ID)||LA32_1==17||LA32_1==19||(LA32_1>=25 && LA32_1<=26)||LA32_1==30||(LA32_1>=34 && LA32_1<=35)||(LA32_1>=37 && LA32_1<=40)) ) {
                    alt32=1;
                }
            }
            switch (alt32) {
                case 1 :
                    // InternalQVTcore.g:1134:1: (lv_isEnforce_1_0= 'enforce' )
                    {
                    // InternalQVTcore.g:1134:1: (lv_isEnforce_1_0= 'enforce' )
                    // InternalQVTcore.g:1135:3: lv_isEnforce_1_0= 'enforce'
                    {
                    lv_isEnforce_1_0=(Token)match(input,35,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_isEnforce_1_0, grammarAccess.getNamedDomainCSAccess().getIsEnforceEnforceKeyword_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getNamedDomainCSRule());
                      	        }
                             		setWithLastConsumed(current, "isEnforce", true, "enforce");
                      	    
                    }

                    }


                    }
                    break;

            }

            // InternalQVTcore.g:1148:3: ( ( ruleUnrestrictedName ) )
            // InternalQVTcore.g:1149:1: ( ruleUnrestrictedName )
            {
            // InternalQVTcore.g:1149:1: ( ruleUnrestrictedName )
            // InternalQVTcore.g:1150:3: ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getNamedDomainCSRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNamedDomainCSAccess().getDirectionTypedModelCrossReference_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_12);
            ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalQVTcore.g:1166:2: ( (lv_ownedGuardPattern_3_0= ruleGuardPatternCS ) )
            // InternalQVTcore.g:1167:1: (lv_ownedGuardPattern_3_0= ruleGuardPatternCS )
            {
            // InternalQVTcore.g:1167:1: (lv_ownedGuardPattern_3_0= ruleGuardPatternCS )
            // InternalQVTcore.g:1168:3: lv_ownedGuardPattern_3_0= ruleGuardPatternCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNamedDomainCSAccess().getOwnedGuardPatternGuardPatternCSParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_31);
            lv_ownedGuardPattern_3_0=ruleGuardPatternCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getNamedDomainCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedGuardPattern",
                      		lv_ownedGuardPattern_3_0, 
                      		"org.eclipse.qvtd.xtext.qvtcorebase.QVTcoreBase.GuardPatternCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalQVTcore.g:1184:2: ( (lv_ownedBottomPattern_4_0= ruleBottomPatternCS ) )
            // InternalQVTcore.g:1185:1: (lv_ownedBottomPattern_4_0= ruleBottomPatternCS )
            {
            // InternalQVTcore.g:1185:1: (lv_ownedBottomPattern_4_0= ruleBottomPatternCS )
            // InternalQVTcore.g:1186:3: lv_ownedBottomPattern_4_0= ruleBottomPatternCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNamedDomainCSAccess().getOwnedBottomPatternBottomPatternCSParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_ownedBottomPattern_4_0=ruleBottomPatternCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getNamedDomainCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedBottomPattern",
                      		lv_ownedBottomPattern_4_0, 
                      		"org.eclipse.qvtd.xtext.qvtcorebase.QVTcoreBase.BottomPatternCS");
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
    // $ANTLR end "ruleNamedDomainCS"


    // $ANTLR start "entryRuleParamDeclarationCS"
    // InternalQVTcore.g:1210:1: entryRuleParamDeclarationCS returns [EObject current=null] : iv_ruleParamDeclarationCS= ruleParamDeclarationCS EOF ;
    public final EObject entryRuleParamDeclarationCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParamDeclarationCS = null;


        try {
            // InternalQVTcore.g:1211:2: (iv_ruleParamDeclarationCS= ruleParamDeclarationCS EOF )
            // InternalQVTcore.g:1212:2: iv_ruleParamDeclarationCS= ruleParamDeclarationCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParamDeclarationCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleParamDeclarationCS=ruleParamDeclarationCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParamDeclarationCS; 
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
    // $ANTLR end "entryRuleParamDeclarationCS"


    // $ANTLR start "ruleParamDeclarationCS"
    // InternalQVTcore.g:1219:1: ruleParamDeclarationCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) ) ;
    public final EObject ruleParamDeclarationCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTcore.g:1222:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) ) )
            // InternalQVTcore.g:1223:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )
            {
            // InternalQVTcore.g:1223:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )
            // InternalQVTcore.g:1223:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) )
            {
            // InternalQVTcore.g:1223:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // InternalQVTcore.g:1224:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // InternalQVTcore.g:1224:1: (lv_name_0_0= ruleUnrestrictedName )
            // InternalQVTcore.g:1225:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParamDeclarationCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_25);
            lv_name_0_0=ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getParamDeclarationCSRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"org.eclipse.qvtd.xtext.qvtcorebase.QVTcoreBase.UnrestrictedName");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,29,FollowSets000.FOLLOW_26); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getParamDeclarationCSAccess().getColonKeyword_1());
                  
            }
            // InternalQVTcore.g:1245:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
            // InternalQVTcore.g:1246:1: (lv_ownedType_2_0= ruleTypeExpCS )
            {
            // InternalQVTcore.g:1246:1: (lv_ownedType_2_0= ruleTypeExpCS )
            // InternalQVTcore.g:1247:3: lv_ownedType_2_0= ruleTypeExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParamDeclarationCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_ownedType_2_0=ruleTypeExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getParamDeclarationCSRule());
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
    // $ANTLR end "ruleParamDeclarationCS"


    // $ANTLR start "entryRulePredicateCS"
    // InternalQVTcore.g:1271:1: entryRulePredicateCS returns [EObject current=null] : iv_rulePredicateCS= rulePredicateCS EOF ;
    public final EObject entryRulePredicateCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePredicateCS = null;


        try {
            // InternalQVTcore.g:1272:2: (iv_rulePredicateCS= rulePredicateCS EOF )
            // InternalQVTcore.g:1273:2: iv_rulePredicateCS= rulePredicateCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPredicateCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePredicateCS=rulePredicateCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePredicateCS; 
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
    // $ANTLR end "entryRulePredicateCS"


    // $ANTLR start "rulePredicateCS"
    // InternalQVTcore.g:1280:1: rulePredicateCS returns [EObject current=null] : ( ( (lv_ownedCondition_0_0= ruleExpCS ) ) otherlv_1= ';' ) ;
    public final EObject rulePredicateCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_ownedCondition_0_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTcore.g:1283:28: ( ( ( (lv_ownedCondition_0_0= ruleExpCS ) ) otherlv_1= ';' ) )
            // InternalQVTcore.g:1284:1: ( ( (lv_ownedCondition_0_0= ruleExpCS ) ) otherlv_1= ';' )
            {
            // InternalQVTcore.g:1284:1: ( ( (lv_ownedCondition_0_0= ruleExpCS ) ) otherlv_1= ';' )
            // InternalQVTcore.g:1284:2: ( (lv_ownedCondition_0_0= ruleExpCS ) ) otherlv_1= ';'
            {
            // InternalQVTcore.g:1284:2: ( (lv_ownedCondition_0_0= ruleExpCS ) )
            // InternalQVTcore.g:1285:1: (lv_ownedCondition_0_0= ruleExpCS )
            {
            // InternalQVTcore.g:1285:1: (lv_ownedCondition_0_0= ruleExpCS )
            // InternalQVTcore.g:1286:3: lv_ownedCondition_0_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPredicateCSAccess().getOwnedConditionExpCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_30);
            lv_ownedCondition_0_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getPredicateCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedCondition",
                      		lv_ownedCondition_0_0, 
                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,33,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getPredicateCSAccess().getSemicolonKeyword_1());
                  
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
    // $ANTLR end "rulePredicateCS"


    // $ANTLR start "entryRulePredicateOrAssignmentCS"
    // InternalQVTcore.g:1314:1: entryRulePredicateOrAssignmentCS returns [EObject current=null] : iv_rulePredicateOrAssignmentCS= rulePredicateOrAssignmentCS EOF ;
    public final EObject entryRulePredicateOrAssignmentCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePredicateOrAssignmentCS = null;


        try {
            // InternalQVTcore.g:1315:2: (iv_rulePredicateOrAssignmentCS= rulePredicateOrAssignmentCS EOF )
            // InternalQVTcore.g:1316:2: iv_rulePredicateOrAssignmentCS= rulePredicateOrAssignmentCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPredicateOrAssignmentCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePredicateOrAssignmentCS=rulePredicateOrAssignmentCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePredicateOrAssignmentCS; 
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
    // $ANTLR end "entryRulePredicateOrAssignmentCS"


    // $ANTLR start "rulePredicateOrAssignmentCS"
    // InternalQVTcore.g:1323:1: rulePredicateOrAssignmentCS returns [EObject current=null] : ( ( (lv_isDefault_0_0= 'default' ) )? ( (lv_ownedTarget_1_0= ruleExpCS ) ) (otherlv_2= ':=' ( (lv_ownedInitExpression_3_0= ruleExpCS ) ) )? otherlv_4= ';' ) ;
    public final EObject rulePredicateOrAssignmentCS() throws RecognitionException {
        EObject current = null;

        Token lv_isDefault_0_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_ownedTarget_1_0 = null;

        EObject lv_ownedInitExpression_3_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTcore.g:1326:28: ( ( ( (lv_isDefault_0_0= 'default' ) )? ( (lv_ownedTarget_1_0= ruleExpCS ) ) (otherlv_2= ':=' ( (lv_ownedInitExpression_3_0= ruleExpCS ) ) )? otherlv_4= ';' ) )
            // InternalQVTcore.g:1327:1: ( ( (lv_isDefault_0_0= 'default' ) )? ( (lv_ownedTarget_1_0= ruleExpCS ) ) (otherlv_2= ':=' ( (lv_ownedInitExpression_3_0= ruleExpCS ) ) )? otherlv_4= ';' )
            {
            // InternalQVTcore.g:1327:1: ( ( (lv_isDefault_0_0= 'default' ) )? ( (lv_ownedTarget_1_0= ruleExpCS ) ) (otherlv_2= ':=' ( (lv_ownedInitExpression_3_0= ruleExpCS ) ) )? otherlv_4= ';' )
            // InternalQVTcore.g:1327:2: ( (lv_isDefault_0_0= 'default' ) )? ( (lv_ownedTarget_1_0= ruleExpCS ) ) (otherlv_2= ':=' ( (lv_ownedInitExpression_3_0= ruleExpCS ) ) )? otherlv_4= ';'
            {
            // InternalQVTcore.g:1327:2: ( (lv_isDefault_0_0= 'default' ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==16) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalQVTcore.g:1328:1: (lv_isDefault_0_0= 'default' )
                    {
                    // InternalQVTcore.g:1328:1: (lv_isDefault_0_0= 'default' )
                    // InternalQVTcore.g:1329:3: lv_isDefault_0_0= 'default'
                    {
                    lv_isDefault_0_0=(Token)match(input,16,FollowSets000.FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_isDefault_0_0, grammarAccess.getPredicateOrAssignmentCSAccess().getIsDefaultDefaultKeyword_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getPredicateOrAssignmentCSRule());
                      	        }
                             		setWithLastConsumed(current, "isDefault", true, "default");
                      	    
                    }

                    }


                    }
                    break;

            }

            // InternalQVTcore.g:1342:3: ( (lv_ownedTarget_1_0= ruleExpCS ) )
            // InternalQVTcore.g:1343:1: (lv_ownedTarget_1_0= ruleExpCS )
            {
            // InternalQVTcore.g:1343:1: (lv_ownedTarget_1_0= ruleExpCS )
            // InternalQVTcore.g:1344:3: lv_ownedTarget_1_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPredicateOrAssignmentCSAccess().getOwnedTargetExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_32);
            lv_ownedTarget_1_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getPredicateOrAssignmentCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedTarget",
                      		lv_ownedTarget_1_0, 
                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalQVTcore.g:1360:2: (otherlv_2= ':=' ( (lv_ownedInitExpression_3_0= ruleExpCS ) ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==36) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalQVTcore.g:1360:4: otherlv_2= ':=' ( (lv_ownedInitExpression_3_0= ruleExpCS ) )
                    {
                    otherlv_2=(Token)match(input,36,FollowSets000.FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getPredicateOrAssignmentCSAccess().getColonEqualsSignKeyword_2_0());
                          
                    }
                    // InternalQVTcore.g:1364:1: ( (lv_ownedInitExpression_3_0= ruleExpCS ) )
                    // InternalQVTcore.g:1365:1: (lv_ownedInitExpression_3_0= ruleExpCS )
                    {
                    // InternalQVTcore.g:1365:1: (lv_ownedInitExpression_3_0= ruleExpCS )
                    // InternalQVTcore.g:1366:3: lv_ownedInitExpression_3_0= ruleExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPredicateOrAssignmentCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_30);
                    lv_ownedInitExpression_3_0=ruleExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPredicateOrAssignmentCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedInitExpression",
                              		lv_ownedInitExpression_3_0, 
                              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,33,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getPredicateOrAssignmentCSAccess().getSemicolonKeyword_3());
                  
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
    // $ANTLR end "rulePredicateOrAssignmentCS"


    // $ANTLR start "entryRuleQueryCS"
    // InternalQVTcore.g:1394:1: entryRuleQueryCS returns [EObject current=null] : iv_ruleQueryCS= ruleQueryCS EOF ;
    public final EObject entryRuleQueryCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQueryCS = null;


        try {
            // InternalQVTcore.g:1395:2: (iv_ruleQueryCS= ruleQueryCS EOF )
            // InternalQVTcore.g:1396:2: iv_ruleQueryCS= ruleQueryCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQueryCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleQueryCS=ruleQueryCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQueryCS; 
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
    // $ANTLR end "entryRuleQueryCS"


    // $ANTLR start "ruleQueryCS"
    // InternalQVTcore.g:1403:1: ruleQueryCS returns [EObject current=null] : (otherlv_0= 'query' ( (lv_ownedPathName_1_0= ruleScopeNameCS ) ) ( (lv_name_2_0= ruleUnrestrictedName ) ) otherlv_3= '(' ( ( (lv_ownedParameters_4_0= ruleParamDeclarationCS ) ) (otherlv_5= ',' ( (lv_ownedParameters_6_0= ruleParamDeclarationCS ) ) )* )? otherlv_7= ')' otherlv_8= ':' ( (lv_ownedType_9_0= ruleTypeExpCS ) ) (otherlv_10= ';' | (otherlv_11= '{' ( (lv_ownedExpression_12_0= ruleExpCS ) ) otherlv_13= '}' ) ) ) ;
    public final EObject ruleQueryCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        EObject lv_ownedPathName_1_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_ownedParameters_4_0 = null;

        EObject lv_ownedParameters_6_0 = null;

        EObject lv_ownedType_9_0 = null;

        EObject lv_ownedExpression_12_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTcore.g:1406:28: ( (otherlv_0= 'query' ( (lv_ownedPathName_1_0= ruleScopeNameCS ) ) ( (lv_name_2_0= ruleUnrestrictedName ) ) otherlv_3= '(' ( ( (lv_ownedParameters_4_0= ruleParamDeclarationCS ) ) (otherlv_5= ',' ( (lv_ownedParameters_6_0= ruleParamDeclarationCS ) ) )* )? otherlv_7= ')' otherlv_8= ':' ( (lv_ownedType_9_0= ruleTypeExpCS ) ) (otherlv_10= ';' | (otherlv_11= '{' ( (lv_ownedExpression_12_0= ruleExpCS ) ) otherlv_13= '}' ) ) ) )
            // InternalQVTcore.g:1407:1: (otherlv_0= 'query' ( (lv_ownedPathName_1_0= ruleScopeNameCS ) ) ( (lv_name_2_0= ruleUnrestrictedName ) ) otherlv_3= '(' ( ( (lv_ownedParameters_4_0= ruleParamDeclarationCS ) ) (otherlv_5= ',' ( (lv_ownedParameters_6_0= ruleParamDeclarationCS ) ) )* )? otherlv_7= ')' otherlv_8= ':' ( (lv_ownedType_9_0= ruleTypeExpCS ) ) (otherlv_10= ';' | (otherlv_11= '{' ( (lv_ownedExpression_12_0= ruleExpCS ) ) otherlv_13= '}' ) ) )
            {
            // InternalQVTcore.g:1407:1: (otherlv_0= 'query' ( (lv_ownedPathName_1_0= ruleScopeNameCS ) ) ( (lv_name_2_0= ruleUnrestrictedName ) ) otherlv_3= '(' ( ( (lv_ownedParameters_4_0= ruleParamDeclarationCS ) ) (otherlv_5= ',' ( (lv_ownedParameters_6_0= ruleParamDeclarationCS ) ) )* )? otherlv_7= ')' otherlv_8= ':' ( (lv_ownedType_9_0= ruleTypeExpCS ) ) (otherlv_10= ';' | (otherlv_11= '{' ( (lv_ownedExpression_12_0= ruleExpCS ) ) otherlv_13= '}' ) ) )
            // InternalQVTcore.g:1407:3: otherlv_0= 'query' ( (lv_ownedPathName_1_0= ruleScopeNameCS ) ) ( (lv_name_2_0= ruleUnrestrictedName ) ) otherlv_3= '(' ( ( (lv_ownedParameters_4_0= ruleParamDeclarationCS ) ) (otherlv_5= ',' ( (lv_ownedParameters_6_0= ruleParamDeclarationCS ) ) )* )? otherlv_7= ')' otherlv_8= ':' ( (lv_ownedType_9_0= ruleTypeExpCS ) ) (otherlv_10= ';' | (otherlv_11= '{' ( (lv_ownedExpression_12_0= ruleExpCS ) ) otherlv_13= '}' ) )
            {
            otherlv_0=(Token)match(input,37,FollowSets000.FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getQueryCSAccess().getQueryKeyword_0());
                  
            }
            // InternalQVTcore.g:1411:1: ( (lv_ownedPathName_1_0= ruleScopeNameCS ) )
            // InternalQVTcore.g:1412:1: (lv_ownedPathName_1_0= ruleScopeNameCS )
            {
            // InternalQVTcore.g:1412:1: (lv_ownedPathName_1_0= ruleScopeNameCS )
            // InternalQVTcore.g:1413:3: lv_ownedPathName_1_0= ruleScopeNameCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getQueryCSAccess().getOwnedPathNameScopeNameCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_8);
            lv_ownedPathName_1_0=ruleScopeNameCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getQueryCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedPathName",
                      		lv_ownedPathName_1_0, 
                      		"org.eclipse.qvtd.xtext.qvtcorebase.QVTcoreBase.ScopeNameCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalQVTcore.g:1429:2: ( (lv_name_2_0= ruleUnrestrictedName ) )
            // InternalQVTcore.g:1430:1: (lv_name_2_0= ruleUnrestrictedName )
            {
            // InternalQVTcore.g:1430:1: (lv_name_2_0= ruleUnrestrictedName )
            // InternalQVTcore.g:1431:3: lv_name_2_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getQueryCSAccess().getNameUnrestrictedNameParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_12);
            lv_name_2_0=ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getQueryCSRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_2_0, 
                      		"org.eclipse.qvtd.xtext.qvtcorebase.QVTcoreBase.UnrestrictedName");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,27,FollowSets000.FOLLOW_33); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getQueryCSAccess().getLeftParenthesisKeyword_3());
                  
            }
            // InternalQVTcore.g:1451:1: ( ( (lv_ownedParameters_4_0= ruleParamDeclarationCS ) ) (otherlv_5= ',' ( (lv_ownedParameters_6_0= ruleParamDeclarationCS ) ) )* )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( ((LA36_0>=RULE_SIMPLE_ID && LA36_0<=RULE_ESCAPED_ID)||LA36_0==17||LA36_0==19||(LA36_0>=25 && LA36_0<=26)||LA36_0==30||(LA36_0>=34 && LA36_0<=35)||(LA36_0>=37 && LA36_0<=40)) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalQVTcore.g:1451:2: ( (lv_ownedParameters_4_0= ruleParamDeclarationCS ) ) (otherlv_5= ',' ( (lv_ownedParameters_6_0= ruleParamDeclarationCS ) ) )*
                    {
                    // InternalQVTcore.g:1451:2: ( (lv_ownedParameters_4_0= ruleParamDeclarationCS ) )
                    // InternalQVTcore.g:1452:1: (lv_ownedParameters_4_0= ruleParamDeclarationCS )
                    {
                    // InternalQVTcore.g:1452:1: (lv_ownedParameters_4_0= ruleParamDeclarationCS )
                    // InternalQVTcore.g:1453:3: lv_ownedParameters_4_0= ruleParamDeclarationCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getQueryCSAccess().getOwnedParametersParamDeclarationCSParserRuleCall_4_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_23);
                    lv_ownedParameters_4_0=ruleParamDeclarationCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getQueryCSRule());
                      	        }
                             		add(
                             			current, 
                             			"ownedParameters",
                              		lv_ownedParameters_4_0, 
                              		"org.eclipse.qvtd.xtext.qvtcorebase.QVTcoreBase.ParamDeclarationCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalQVTcore.g:1469:2: (otherlv_5= ',' ( (lv_ownedParameters_6_0= ruleParamDeclarationCS ) ) )*
                    loop35:
                    do {
                        int alt35=2;
                        int LA35_0 = input.LA(1);

                        if ( (LA35_0==20) ) {
                            alt35=1;
                        }


                        switch (alt35) {
                    	case 1 :
                    	    // InternalQVTcore.g:1469:4: otherlv_5= ',' ( (lv_ownedParameters_6_0= ruleParamDeclarationCS ) )
                    	    {
                    	    otherlv_5=(Token)match(input,20,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_5, grammarAccess.getQueryCSAccess().getCommaKeyword_4_1_0());
                    	          
                    	    }
                    	    // InternalQVTcore.g:1473:1: ( (lv_ownedParameters_6_0= ruleParamDeclarationCS ) )
                    	    // InternalQVTcore.g:1474:1: (lv_ownedParameters_6_0= ruleParamDeclarationCS )
                    	    {
                    	    // InternalQVTcore.g:1474:1: (lv_ownedParameters_6_0= ruleParamDeclarationCS )
                    	    // InternalQVTcore.g:1475:3: lv_ownedParameters_6_0= ruleParamDeclarationCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getQueryCSAccess().getOwnedParametersParamDeclarationCSParserRuleCall_4_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_23);
                    	    lv_ownedParameters_6_0=ruleParamDeclarationCS();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getQueryCSRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"ownedParameters",
                    	              		lv_ownedParameters_6_0, 
                    	              		"org.eclipse.qvtd.xtext.qvtcorebase.QVTcoreBase.ParamDeclarationCS");
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

            otherlv_7=(Token)match(input,28,FollowSets000.FOLLOW_25); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getQueryCSAccess().getRightParenthesisKeyword_5());
                  
            }
            otherlv_8=(Token)match(input,29,FollowSets000.FOLLOW_26); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getQueryCSAccess().getColonKeyword_6());
                  
            }
            // InternalQVTcore.g:1499:1: ( (lv_ownedType_9_0= ruleTypeExpCS ) )
            // InternalQVTcore.g:1500:1: (lv_ownedType_9_0= ruleTypeExpCS )
            {
            // InternalQVTcore.g:1500:1: (lv_ownedType_9_0= ruleTypeExpCS )
            // InternalQVTcore.g:1501:3: lv_ownedType_9_0= ruleTypeExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getQueryCSAccess().getOwnedTypeTypeExpCSParserRuleCall_7_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_34);
            lv_ownedType_9_0=ruleTypeExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getQueryCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedType",
                      		lv_ownedType_9_0, 
                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeExpCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalQVTcore.g:1517:2: (otherlv_10= ';' | (otherlv_11= '{' ( (lv_ownedExpression_12_0= ruleExpCS ) ) otherlv_13= '}' ) )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==33) ) {
                alt37=1;
            }
            else if ( (LA37_0==21) ) {
                alt37=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }
            switch (alt37) {
                case 1 :
                    // InternalQVTcore.g:1517:4: otherlv_10= ';'
                    {
                    otherlv_10=(Token)match(input,33,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getQueryCSAccess().getSemicolonKeyword_8_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalQVTcore.g:1522:6: (otherlv_11= '{' ( (lv_ownedExpression_12_0= ruleExpCS ) ) otherlv_13= '}' )
                    {
                    // InternalQVTcore.g:1522:6: (otherlv_11= '{' ( (lv_ownedExpression_12_0= ruleExpCS ) ) otherlv_13= '}' )
                    // InternalQVTcore.g:1522:8: otherlv_11= '{' ( (lv_ownedExpression_12_0= ruleExpCS ) ) otherlv_13= '}'
                    {
                    otherlv_11=(Token)match(input,21,FollowSets000.FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_11, grammarAccess.getQueryCSAccess().getLeftCurlyBracketKeyword_8_1_0());
                          
                    }
                    // InternalQVTcore.g:1526:1: ( (lv_ownedExpression_12_0= ruleExpCS ) )
                    // InternalQVTcore.g:1527:1: (lv_ownedExpression_12_0= ruleExpCS )
                    {
                    // InternalQVTcore.g:1527:1: (lv_ownedExpression_12_0= ruleExpCS )
                    // InternalQVTcore.g:1528:3: lv_ownedExpression_12_0= ruleExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getQueryCSAccess().getOwnedExpressionExpCSParserRuleCall_8_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_18);
                    lv_ownedExpression_12_0=ruleExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getQueryCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedExpression",
                              		lv_ownedExpression_12_0, 
                              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_13=(Token)match(input,23,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getQueryCSAccess().getRightCurlyBracketKeyword_8_1_2());
                          
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
    // $ANTLR end "ruleQueryCS"


    // $ANTLR start "entryRuleScopeNameCS"
    // InternalQVTcore.g:1556:1: entryRuleScopeNameCS returns [EObject current=null] : iv_ruleScopeNameCS= ruleScopeNameCS EOF ;
    public final EObject entryRuleScopeNameCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScopeNameCS = null;


        try {
            // InternalQVTcore.g:1557:2: (iv_ruleScopeNameCS= ruleScopeNameCS EOF )
            // InternalQVTcore.g:1558:2: iv_ruleScopeNameCS= ruleScopeNameCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScopeNameCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleScopeNameCS=ruleScopeNameCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScopeNameCS; 
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
    // $ANTLR end "entryRuleScopeNameCS"


    // $ANTLR start "ruleScopeNameCS"
    // InternalQVTcore.g:1565:1: ruleScopeNameCS returns [EObject current=null] : ( ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) ) otherlv_1= '::' ( ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) otherlv_3= '::' )* ) ;
    public final EObject ruleScopeNameCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_ownedPathElements_0_0 = null;

        EObject lv_ownedPathElements_2_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTcore.g:1568:28: ( ( ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) ) otherlv_1= '::' ( ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) otherlv_3= '::' )* ) )
            // InternalQVTcore.g:1569:1: ( ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) ) otherlv_1= '::' ( ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) otherlv_3= '::' )* )
            {
            // InternalQVTcore.g:1569:1: ( ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) ) otherlv_1= '::' ( ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) otherlv_3= '::' )* )
            // InternalQVTcore.g:1569:2: ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) ) otherlv_1= '::' ( ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) otherlv_3= '::' )*
            {
            // InternalQVTcore.g:1569:2: ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) )
            // InternalQVTcore.g:1570:1: (lv_ownedPathElements_0_0= ruleFirstPathElementCS )
            {
            // InternalQVTcore.g:1570:1: (lv_ownedPathElements_0_0= ruleFirstPathElementCS )
            // InternalQVTcore.g:1571:3: lv_ownedPathElements_0_0= ruleFirstPathElementCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getScopeNameCSAccess().getOwnedPathElementsFirstPathElementCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_35);
            lv_ownedPathElements_0_0=ruleFirstPathElementCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getScopeNameCSRule());
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

            otherlv_1=(Token)match(input,31,FollowSets000.FOLLOW_36); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getScopeNameCSAccess().getColonColonKeyword_1());
                  
            }
            // InternalQVTcore.g:1591:1: ( ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) otherlv_3= '::' )*
            loop38:
            do {
                int alt38=2;
                alt38 = dfa38.predict(input);
                switch (alt38) {
            	case 1 :
            	    // InternalQVTcore.g:1591:2: ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) otherlv_3= '::'
            	    {
            	    // InternalQVTcore.g:1591:2: ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) )
            	    // InternalQVTcore.g:1592:1: (lv_ownedPathElements_2_0= ruleNextPathElementCS )
            	    {
            	    // InternalQVTcore.g:1592:1: (lv_ownedPathElements_2_0= ruleNextPathElementCS )
            	    // InternalQVTcore.g:1593:3: lv_ownedPathElements_2_0= ruleNextPathElementCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getScopeNameCSAccess().getOwnedPathElementsNextPathElementCSParserRuleCall_2_0_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_35);
            	    lv_ownedPathElements_2_0=ruleNextPathElementCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getScopeNameCSRule());
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

            	    otherlv_3=(Token)match(input,31,FollowSets000.FOLLOW_36); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getScopeNameCSAccess().getColonColonKeyword_2_1());
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop38;
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
    // $ANTLR end "ruleScopeNameCS"


    // $ANTLR start "entryRuleTransformationCS"
    // InternalQVTcore.g:1621:1: entryRuleTransformationCS returns [EObject current=null] : iv_ruleTransformationCS= ruleTransformationCS EOF ;
    public final EObject entryRuleTransformationCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransformationCS = null;


        try {
            // InternalQVTcore.g:1622:2: (iv_ruleTransformationCS= ruleTransformationCS EOF )
            // InternalQVTcore.g:1623:2: iv_ruleTransformationCS= ruleTransformationCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTransformationCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTransformationCS=ruleTransformationCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTransformationCS; 
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
    // $ANTLR end "entryRuleTransformationCS"


    // $ANTLR start "ruleTransformationCS"
    // InternalQVTcore.g:1630:1: ruleTransformationCS returns [EObject current=null] : (otherlv_0= 'transformation' ( (lv_ownedPathName_1_0= ruleScopeNameCS ) )? ( (lv_name_2_0= ruleUnreservedName ) ) otherlv_3= '{' ( ( (lv_ownedDirections_4_0= ruleDirectionCS ) ) otherlv_5= ';' )* otherlv_6= '}' ) ;
    public final EObject ruleTransformationCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        EObject lv_ownedPathName_1_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_ownedDirections_4_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTcore.g:1633:28: ( (otherlv_0= 'transformation' ( (lv_ownedPathName_1_0= ruleScopeNameCS ) )? ( (lv_name_2_0= ruleUnreservedName ) ) otherlv_3= '{' ( ( (lv_ownedDirections_4_0= ruleDirectionCS ) ) otherlv_5= ';' )* otherlv_6= '}' ) )
            // InternalQVTcore.g:1634:1: (otherlv_0= 'transformation' ( (lv_ownedPathName_1_0= ruleScopeNameCS ) )? ( (lv_name_2_0= ruleUnreservedName ) ) otherlv_3= '{' ( ( (lv_ownedDirections_4_0= ruleDirectionCS ) ) otherlv_5= ';' )* otherlv_6= '}' )
            {
            // InternalQVTcore.g:1634:1: (otherlv_0= 'transformation' ( (lv_ownedPathName_1_0= ruleScopeNameCS ) )? ( (lv_name_2_0= ruleUnreservedName ) ) otherlv_3= '{' ( ( (lv_ownedDirections_4_0= ruleDirectionCS ) ) otherlv_5= ';' )* otherlv_6= '}' )
            // InternalQVTcore.g:1634:3: otherlv_0= 'transformation' ( (lv_ownedPathName_1_0= ruleScopeNameCS ) )? ( (lv_name_2_0= ruleUnreservedName ) ) otherlv_3= '{' ( ( (lv_ownedDirections_4_0= ruleDirectionCS ) ) otherlv_5= ';' )* otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,38,FollowSets000.FOLLOW_26); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getTransformationCSAccess().getTransformationKeyword_0());
                  
            }
            // InternalQVTcore.g:1638:1: ( (lv_ownedPathName_1_0= ruleScopeNameCS ) )?
            int alt39=2;
            alt39 = dfa39.predict(input);
            switch (alt39) {
                case 1 :
                    // InternalQVTcore.g:1639:1: (lv_ownedPathName_1_0= ruleScopeNameCS )
                    {
                    // InternalQVTcore.g:1639:1: (lv_ownedPathName_1_0= ruleScopeNameCS )
                    // InternalQVTcore.g:1640:3: lv_ownedPathName_1_0= ruleScopeNameCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTransformationCSAccess().getOwnedPathNameScopeNameCSParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_26);
                    lv_ownedPathName_1_0=ruleScopeNameCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTransformationCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedPathName",
                              		lv_ownedPathName_1_0, 
                              		"org.eclipse.qvtd.xtext.qvtcorebase.QVTcoreBase.ScopeNameCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // InternalQVTcore.g:1656:3: ( (lv_name_2_0= ruleUnreservedName ) )
            // InternalQVTcore.g:1657:1: (lv_name_2_0= ruleUnreservedName )
            {
            // InternalQVTcore.g:1657:1: (lv_name_2_0= ruleUnreservedName )
            // InternalQVTcore.g:1658:3: lv_name_2_0= ruleUnreservedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTransformationCSAccess().getNameUnreservedNameParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_31);
            lv_name_2_0=ruleUnreservedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTransformationCSRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_2_0, 
                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.UnreservedName");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,21,FollowSets000.FOLLOW_37); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getTransformationCSAccess().getLeftCurlyBracketKeyword_3());
                  
            }
            // InternalQVTcore.g:1678:1: ( ( (lv_ownedDirections_4_0= ruleDirectionCS ) ) otherlv_5= ';' )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( ((LA40_0>=RULE_SIMPLE_ID && LA40_0<=RULE_ESCAPED_ID)||LA40_0==17||LA40_0==19||(LA40_0>=25 && LA40_0<=26)||LA40_0==30||(LA40_0>=34 && LA40_0<=35)||(LA40_0>=37 && LA40_0<=40)) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // InternalQVTcore.g:1678:2: ( (lv_ownedDirections_4_0= ruleDirectionCS ) ) otherlv_5= ';'
            	    {
            	    // InternalQVTcore.g:1678:2: ( (lv_ownedDirections_4_0= ruleDirectionCS ) )
            	    // InternalQVTcore.g:1679:1: (lv_ownedDirections_4_0= ruleDirectionCS )
            	    {
            	    // InternalQVTcore.g:1679:1: (lv_ownedDirections_4_0= ruleDirectionCS )
            	    // InternalQVTcore.g:1680:3: lv_ownedDirections_4_0= ruleDirectionCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTransformationCSAccess().getOwnedDirectionsDirectionCSParserRuleCall_4_0_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_30);
            	    lv_ownedDirections_4_0=ruleDirectionCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getTransformationCSRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedDirections",
            	              		lv_ownedDirections_4_0, 
            	              		"org.eclipse.qvtd.xtext.qvtcorebase.QVTcoreBase.DirectionCS");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    otherlv_5=(Token)match(input,33,FollowSets000.FOLLOW_37); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_5, grammarAccess.getTransformationCSAccess().getSemicolonKeyword_4_1());
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop40;
                }
            } while (true);

            otherlv_6=(Token)match(input,23,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getTransformationCSAccess().getRightCurlyBracketKeyword_5());
                  
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
    // $ANTLR end "ruleTransformationCS"


    // $ANTLR start "entryRuleUnrealizedVariableCS"
    // InternalQVTcore.g:1712:1: entryRuleUnrealizedVariableCS returns [EObject current=null] : iv_ruleUnrealizedVariableCS= ruleUnrealizedVariableCS EOF ;
    public final EObject entryRuleUnrealizedVariableCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnrealizedVariableCS = null;


        try {
            // InternalQVTcore.g:1713:2: (iv_ruleUnrealizedVariableCS= ruleUnrealizedVariableCS EOF )
            // InternalQVTcore.g:1714:2: iv_ruleUnrealizedVariableCS= ruleUnrealizedVariableCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnrealizedVariableCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUnrealizedVariableCS=ruleUnrealizedVariableCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnrealizedVariableCS; 
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
    // $ANTLR end "entryRuleUnrealizedVariableCS"


    // $ANTLR start "ruleUnrealizedVariableCS"
    // InternalQVTcore.g:1721:1: ruleUnrealizedVariableCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? (otherlv_3= ':=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? ) ;
    public final EObject ruleUnrealizedVariableCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;

        EObject lv_ownedInitExpression_4_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTcore.g:1724:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? (otherlv_3= ':=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? ) )
            // InternalQVTcore.g:1725:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? (otherlv_3= ':=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? )
            {
            // InternalQVTcore.g:1725:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? (otherlv_3= ':=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? )
            // InternalQVTcore.g:1725:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? (otherlv_3= ':=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )?
            {
            // InternalQVTcore.g:1725:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // InternalQVTcore.g:1726:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // InternalQVTcore.g:1726:1: (lv_name_0_0= ruleUnrestrictedName )
            // InternalQVTcore.g:1727:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getUnrealizedVariableCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_38);
            lv_name_0_0=ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getUnrealizedVariableCSRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"org.eclipse.qvtd.xtext.qvtcorebase.QVTcoreBase.UnrestrictedName");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalQVTcore.g:1743:2: (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==29) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalQVTcore.g:1743:4: otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                    {
                    otherlv_1=(Token)match(input,29,FollowSets000.FOLLOW_26); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getUnrealizedVariableCSAccess().getColonKeyword_1_0());
                          
                    }
                    // InternalQVTcore.g:1747:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                    // InternalQVTcore.g:1748:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    {
                    // InternalQVTcore.g:1748:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    // InternalQVTcore.g:1749:3: lv_ownedType_2_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getUnrealizedVariableCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_39);
                    lv_ownedType_2_0=ruleTypeExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getUnrealizedVariableCSRule());
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

            // InternalQVTcore.g:1765:4: (otherlv_3= ':=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==36) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalQVTcore.g:1765:6: otherlv_3= ':=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) )
                    {
                    otherlv_3=(Token)match(input,36,FollowSets000.FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getUnrealizedVariableCSAccess().getColonEqualsSignKeyword_2_0());
                          
                    }
                    // InternalQVTcore.g:1769:1: ( (lv_ownedInitExpression_4_0= ruleExpCS ) )
                    // InternalQVTcore.g:1770:1: (lv_ownedInitExpression_4_0= ruleExpCS )
                    {
                    // InternalQVTcore.g:1770:1: (lv_ownedInitExpression_4_0= ruleExpCS )
                    // InternalQVTcore.g:1771:3: lv_ownedInitExpression_4_0= ruleExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getUnrealizedVariableCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_ownedInitExpression_4_0=ruleExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getUnrealizedVariableCSRule());
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
    // $ANTLR end "ruleUnrealizedVariableCS"


    // $ANTLR start "entryRuleRealizedVariableCS"
    // InternalQVTcore.g:1795:1: entryRuleRealizedVariableCS returns [EObject current=null] : iv_ruleRealizedVariableCS= ruleRealizedVariableCS EOF ;
    public final EObject entryRuleRealizedVariableCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealizedVariableCS = null;


        try {
            // InternalQVTcore.g:1796:2: (iv_ruleRealizedVariableCS= ruleRealizedVariableCS EOF )
            // InternalQVTcore.g:1797:2: iv_ruleRealizedVariableCS= ruleRealizedVariableCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRealizedVariableCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleRealizedVariableCS=ruleRealizedVariableCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRealizedVariableCS; 
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
    // $ANTLR end "entryRuleRealizedVariableCS"


    // $ANTLR start "ruleRealizedVariableCS"
    // InternalQVTcore.g:1804:1: ruleRealizedVariableCS returns [EObject current=null] : (otherlv_0= 'realize' ( (lv_name_1_0= ruleUnrestrictedName ) ) otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) ) ;
    public final EObject ruleRealizedVariableCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_ownedType_3_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTcore.g:1807:28: ( (otherlv_0= 'realize' ( (lv_name_1_0= ruleUnrestrictedName ) ) otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) ) )
            // InternalQVTcore.g:1808:1: (otherlv_0= 'realize' ( (lv_name_1_0= ruleUnrestrictedName ) ) otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )
            {
            // InternalQVTcore.g:1808:1: (otherlv_0= 'realize' ( (lv_name_1_0= ruleUnrestrictedName ) ) otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )
            // InternalQVTcore.g:1808:3: otherlv_0= 'realize' ( (lv_name_1_0= ruleUnrestrictedName ) ) otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) )
            {
            otherlv_0=(Token)match(input,39,FollowSets000.FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getRealizedVariableCSAccess().getRealizeKeyword_0());
                  
            }
            // InternalQVTcore.g:1812:1: ( (lv_name_1_0= ruleUnrestrictedName ) )
            // InternalQVTcore.g:1813:1: (lv_name_1_0= ruleUnrestrictedName )
            {
            // InternalQVTcore.g:1813:1: (lv_name_1_0= ruleUnrestrictedName )
            // InternalQVTcore.g:1814:3: lv_name_1_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRealizedVariableCSAccess().getNameUnrestrictedNameParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_25);
            lv_name_1_0=ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getRealizedVariableCSRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"org.eclipse.qvtd.xtext.qvtcorebase.QVTcoreBase.UnrestrictedName");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,29,FollowSets000.FOLLOW_26); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getRealizedVariableCSAccess().getColonKeyword_2());
                  
            }
            // InternalQVTcore.g:1834:1: ( (lv_ownedType_3_0= ruleTypeExpCS ) )
            // InternalQVTcore.g:1835:1: (lv_ownedType_3_0= ruleTypeExpCS )
            {
            // InternalQVTcore.g:1835:1: (lv_ownedType_3_0= ruleTypeExpCS )
            // InternalQVTcore.g:1836:3: lv_ownedType_3_0= ruleTypeExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRealizedVariableCSAccess().getOwnedTypeTypeExpCSParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_ownedType_3_0=ruleTypeExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getRealizedVariableCSRule());
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
    // $ANTLR end "ruleRealizedVariableCS"


    // $ANTLR start "entryRuleUnnamedDomainCS"
    // InternalQVTcore.g:1860:1: entryRuleUnnamedDomainCS returns [EObject current=null] : iv_ruleUnnamedDomainCS= ruleUnnamedDomainCS EOF ;
    public final EObject entryRuleUnnamedDomainCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnnamedDomainCS = null;


        try {
            // InternalQVTcore.g:1861:2: (iv_ruleUnnamedDomainCS= ruleUnnamedDomainCS EOF )
            // InternalQVTcore.g:1862:2: iv_ruleUnnamedDomainCS= ruleUnnamedDomainCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnnamedDomainCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUnnamedDomainCS=ruleUnnamedDomainCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnnamedDomainCS; 
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
    // $ANTLR end "entryRuleUnnamedDomainCS"


    // $ANTLR start "ruleUnnamedDomainCS"
    // InternalQVTcore.g:1869:1: ruleUnnamedDomainCS returns [EObject current=null] : ( () ( (lv_ownedGuardPattern_1_0= ruleGuardPatternCS ) ) ( (lv_ownedBottomPattern_2_0= ruleBottomPatternCS ) ) ) ;
    public final EObject ruleUnnamedDomainCS() throws RecognitionException {
        EObject current = null;

        EObject lv_ownedGuardPattern_1_0 = null;

        EObject lv_ownedBottomPattern_2_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTcore.g:1872:28: ( ( () ( (lv_ownedGuardPattern_1_0= ruleGuardPatternCS ) ) ( (lv_ownedBottomPattern_2_0= ruleBottomPatternCS ) ) ) )
            // InternalQVTcore.g:1873:1: ( () ( (lv_ownedGuardPattern_1_0= ruleGuardPatternCS ) ) ( (lv_ownedBottomPattern_2_0= ruleBottomPatternCS ) ) )
            {
            // InternalQVTcore.g:1873:1: ( () ( (lv_ownedGuardPattern_1_0= ruleGuardPatternCS ) ) ( (lv_ownedBottomPattern_2_0= ruleBottomPatternCS ) ) )
            // InternalQVTcore.g:1873:2: () ( (lv_ownedGuardPattern_1_0= ruleGuardPatternCS ) ) ( (lv_ownedBottomPattern_2_0= ruleBottomPatternCS ) )
            {
            // InternalQVTcore.g:1873:2: ()
            // InternalQVTcore.g:1874:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getUnnamedDomainCSAccess().getDomainCSAction_0(),
                          current);
                  
            }

            }

            // InternalQVTcore.g:1882:2: ( (lv_ownedGuardPattern_1_0= ruleGuardPatternCS ) )
            // InternalQVTcore.g:1883:1: (lv_ownedGuardPattern_1_0= ruleGuardPatternCS )
            {
            // InternalQVTcore.g:1883:1: (lv_ownedGuardPattern_1_0= ruleGuardPatternCS )
            // InternalQVTcore.g:1884:3: lv_ownedGuardPattern_1_0= ruleGuardPatternCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getUnnamedDomainCSAccess().getOwnedGuardPatternGuardPatternCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_31);
            lv_ownedGuardPattern_1_0=ruleGuardPatternCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getUnnamedDomainCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedGuardPattern",
                      		lv_ownedGuardPattern_1_0, 
                      		"org.eclipse.qvtd.xtext.qvtcorebase.QVTcoreBase.GuardPatternCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalQVTcore.g:1900:2: ( (lv_ownedBottomPattern_2_0= ruleBottomPatternCS ) )
            // InternalQVTcore.g:1901:1: (lv_ownedBottomPattern_2_0= ruleBottomPatternCS )
            {
            // InternalQVTcore.g:1901:1: (lv_ownedBottomPattern_2_0= ruleBottomPatternCS )
            // InternalQVTcore.g:1902:3: lv_ownedBottomPattern_2_0= ruleBottomPatternCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getUnnamedDomainCSAccess().getOwnedBottomPatternBottomPatternCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_ownedBottomPattern_2_0=ruleBottomPatternCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getUnnamedDomainCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedBottomPattern",
                      		lv_ownedBottomPattern_2_0, 
                      		"org.eclipse.qvtd.xtext.qvtcorebase.QVTcoreBase.BottomPatternCS");
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
    // $ANTLR end "ruleUnnamedDomainCS"


    // $ANTLR start "entryRuleUnrestrictedName"
    // InternalQVTcore.g:1926:1: entryRuleUnrestrictedName returns [String current=null] : iv_ruleUnrestrictedName= ruleUnrestrictedName EOF ;
    public final String entryRuleUnrestrictedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnrestrictedName = null;


        try {
            // InternalQVTcore.g:1927:2: (iv_ruleUnrestrictedName= ruleUnrestrictedName EOF )
            // InternalQVTcore.g:1928:2: iv_ruleUnrestrictedName= ruleUnrestrictedName EOF
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
    // InternalQVTcore.g:1935:1: ruleUnrestrictedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_EssentialOCLUnrestrictedName_0= ruleEssentialOCLUnrestrictedName | kw= 'check' | kw= 'enforce' | kw= 'import' | kw= 'imports' | kw= 'library' | kw= 'map' | kw= 'query' | kw= 'realize' | kw= 'refines' | kw= 'transformation' | kw= 'uses' ) ;
    public final AntlrDatatypeRuleToken ruleUnrestrictedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_EssentialOCLUnrestrictedName_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTcore.g:1938:28: ( (this_EssentialOCLUnrestrictedName_0= ruleEssentialOCLUnrestrictedName | kw= 'check' | kw= 'enforce' | kw= 'import' | kw= 'imports' | kw= 'library' | kw= 'map' | kw= 'query' | kw= 'realize' | kw= 'refines' | kw= 'transformation' | kw= 'uses' ) )
            // InternalQVTcore.g:1939:1: (this_EssentialOCLUnrestrictedName_0= ruleEssentialOCLUnrestrictedName | kw= 'check' | kw= 'enforce' | kw= 'import' | kw= 'imports' | kw= 'library' | kw= 'map' | kw= 'query' | kw= 'realize' | kw= 'refines' | kw= 'transformation' | kw= 'uses' )
            {
            // InternalQVTcore.g:1939:1: (this_EssentialOCLUnrestrictedName_0= ruleEssentialOCLUnrestrictedName | kw= 'check' | kw= 'enforce' | kw= 'import' | kw= 'imports' | kw= 'library' | kw= 'map' | kw= 'query' | kw= 'realize' | kw= 'refines' | kw= 'transformation' | kw= 'uses' )
            int alt43=12;
            switch ( input.LA(1) ) {
            case RULE_SIMPLE_ID:
            case RULE_ESCAPED_ID:
                {
                alt43=1;
                }
                break;
            case 34:
                {
                alt43=2;
                }
                break;
            case 35:
                {
                alt43=3;
                }
                break;
            case 30:
                {
                alt43=4;
                }
                break;
            case 25:
                {
                alt43=5;
                }
                break;
            case 40:
                {
                alt43=6;
                }
                break;
            case 17:
                {
                alt43=7;
                }
                break;
            case 37:
                {
                alt43=8;
                }
                break;
            case 39:
                {
                alt43=9;
                }
                break;
            case 19:
                {
                alt43=10;
                }
                break;
            case 38:
                {
                alt43=11;
                }
                break;
            case 26:
                {
                alt43=12;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }

            switch (alt43) {
                case 1 :
                    // InternalQVTcore.g:1940:5: this_EssentialOCLUnrestrictedName_0= ruleEssentialOCLUnrestrictedName
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getUnrestrictedNameAccess().getEssentialOCLUnrestrictedNameParserRuleCall_0()); 
                          
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
                    break;
                case 2 :
                    // InternalQVTcore.g:1952:2: kw= 'check'
                    {
                    kw=(Token)match(input,34,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getCheckKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalQVTcore.g:1959:2: kw= 'enforce'
                    {
                    kw=(Token)match(input,35,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getEnforceKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalQVTcore.g:1966:2: kw= 'import'
                    {
                    kw=(Token)match(input,30,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getImportKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // InternalQVTcore.g:1973:2: kw= 'imports'
                    {
                    kw=(Token)match(input,25,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getImportsKeyword_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // InternalQVTcore.g:1980:2: kw= 'library'
                    {
                    kw=(Token)match(input,40,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getLibraryKeyword_5()); 
                          
                    }

                    }
                    break;
                case 7 :
                    // InternalQVTcore.g:1987:2: kw= 'map'
                    {
                    kw=(Token)match(input,17,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getMapKeyword_6()); 
                          
                    }

                    }
                    break;
                case 8 :
                    // InternalQVTcore.g:1994:2: kw= 'query'
                    {
                    kw=(Token)match(input,37,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getQueryKeyword_7()); 
                          
                    }

                    }
                    break;
                case 9 :
                    // InternalQVTcore.g:2001:2: kw= 'realize'
                    {
                    kw=(Token)match(input,39,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getRealizeKeyword_8()); 
                          
                    }

                    }
                    break;
                case 10 :
                    // InternalQVTcore.g:2008:2: kw= 'refines'
                    {
                    kw=(Token)match(input,19,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getRefinesKeyword_9()); 
                          
                    }

                    }
                    break;
                case 11 :
                    // InternalQVTcore.g:2015:2: kw= 'transformation'
                    {
                    kw=(Token)match(input,38,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getTransformationKeyword_10()); 
                          
                    }

                    }
                    break;
                case 12 :
                    // InternalQVTcore.g:2022:2: kw= 'uses'
                    {
                    kw=(Token)match(input,26,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getUsesKeyword_11()); 
                          
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
    // $ANTLR end "ruleUnrestrictedName"


    // $ANTLR start "entryRuleEssentialOCLUnaryOperatorName"
    // InternalQVTcore.g:2039:1: entryRuleEssentialOCLUnaryOperatorName returns [String current=null] : iv_ruleEssentialOCLUnaryOperatorName= ruleEssentialOCLUnaryOperatorName EOF ;
    public final String entryRuleEssentialOCLUnaryOperatorName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEssentialOCLUnaryOperatorName = null;


        try {
            // InternalQVTcore.g:2040:2: (iv_ruleEssentialOCLUnaryOperatorName= ruleEssentialOCLUnaryOperatorName EOF )
            // InternalQVTcore.g:2041:2: iv_ruleEssentialOCLUnaryOperatorName= ruleEssentialOCLUnaryOperatorName EOF
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
    // InternalQVTcore.g:2048:1: ruleEssentialOCLUnaryOperatorName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '-' | kw= 'not' ) ;
    public final AntlrDatatypeRuleToken ruleEssentialOCLUnaryOperatorName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalQVTcore.g:2051:28: ( (kw= '-' | kw= 'not' ) )
            // InternalQVTcore.g:2052:1: (kw= '-' | kw= 'not' )
            {
            // InternalQVTcore.g:2052:1: (kw= '-' | kw= 'not' )
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==41) ) {
                alt44=1;
            }
            else if ( (LA44_0==42) ) {
                alt44=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }
            switch (alt44) {
                case 1 :
                    // InternalQVTcore.g:2053:2: kw= '-'
                    {
                    kw=(Token)match(input,41,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLUnaryOperatorNameAccess().getHyphenMinusKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalQVTcore.g:2060:2: kw= 'not'
                    {
                    kw=(Token)match(input,42,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
    // InternalQVTcore.g:2073:1: entryRuleEssentialOCLInfixOperatorName returns [String current=null] : iv_ruleEssentialOCLInfixOperatorName= ruleEssentialOCLInfixOperatorName EOF ;
    public final String entryRuleEssentialOCLInfixOperatorName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEssentialOCLInfixOperatorName = null;


        try {
            // InternalQVTcore.g:2074:2: (iv_ruleEssentialOCLInfixOperatorName= ruleEssentialOCLInfixOperatorName EOF )
            // InternalQVTcore.g:2075:2: iv_ruleEssentialOCLInfixOperatorName= ruleEssentialOCLInfixOperatorName EOF
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
    // InternalQVTcore.g:2082:1: ruleEssentialOCLInfixOperatorName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '*' | kw= '/' | kw= '+' | kw= '-' | kw= '>' | kw= '<' | kw= '>=' | kw= '<=' | kw= '=' | kw= '<>' | kw= 'and' | kw= 'or' | kw= 'xor' | kw= 'implies' ) ;
    public final AntlrDatatypeRuleToken ruleEssentialOCLInfixOperatorName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalQVTcore.g:2085:28: ( (kw= '*' | kw= '/' | kw= '+' | kw= '-' | kw= '>' | kw= '<' | kw= '>=' | kw= '<=' | kw= '=' | kw= '<>' | kw= 'and' | kw= 'or' | kw= 'xor' | kw= 'implies' ) )
            // InternalQVTcore.g:2086:1: (kw= '*' | kw= '/' | kw= '+' | kw= '-' | kw= '>' | kw= '<' | kw= '>=' | kw= '<=' | kw= '=' | kw= '<>' | kw= 'and' | kw= 'or' | kw= 'xor' | kw= 'implies' )
            {
            // InternalQVTcore.g:2086:1: (kw= '*' | kw= '/' | kw= '+' | kw= '-' | kw= '>' | kw= '<' | kw= '>=' | kw= '<=' | kw= '=' | kw= '<>' | kw= 'and' | kw= 'or' | kw= 'xor' | kw= 'implies' )
            int alt45=14;
            switch ( input.LA(1) ) {
            case 32:
                {
                alt45=1;
                }
                break;
            case 43:
                {
                alt45=2;
                }
                break;
            case 44:
                {
                alt45=3;
                }
                break;
            case 41:
                {
                alt45=4;
                }
                break;
            case 45:
                {
                alt45=5;
                }
                break;
            case 46:
                {
                alt45=6;
                }
                break;
            case 47:
                {
                alt45=7;
                }
                break;
            case 48:
                {
                alt45=8;
                }
                break;
            case 49:
                {
                alt45=9;
                }
                break;
            case 50:
                {
                alt45=10;
                }
                break;
            case 51:
                {
                alt45=11;
                }
                break;
            case 52:
                {
                alt45=12;
                }
                break;
            case 53:
                {
                alt45=13;
                }
                break;
            case 54:
                {
                alt45=14;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }

            switch (alt45) {
                case 1 :
                    // InternalQVTcore.g:2087:2: kw= '*'
                    {
                    kw=(Token)match(input,32,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getAsteriskKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalQVTcore.g:2094:2: kw= '/'
                    {
                    kw=(Token)match(input,43,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getSolidusKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalQVTcore.g:2101:2: kw= '+'
                    {
                    kw=(Token)match(input,44,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getPlusSignKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalQVTcore.g:2108:2: kw= '-'
                    {
                    kw=(Token)match(input,41,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getHyphenMinusKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // InternalQVTcore.g:2115:2: kw= '>'
                    {
                    kw=(Token)match(input,45,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getGreaterThanSignKeyword_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // InternalQVTcore.g:2122:2: kw= '<'
                    {
                    kw=(Token)match(input,46,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getLessThanSignKeyword_5()); 
                          
                    }

                    }
                    break;
                case 7 :
                    // InternalQVTcore.g:2129:2: kw= '>='
                    {
                    kw=(Token)match(input,47,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getGreaterThanSignEqualsSignKeyword_6()); 
                          
                    }

                    }
                    break;
                case 8 :
                    // InternalQVTcore.g:2136:2: kw= '<='
                    {
                    kw=(Token)match(input,48,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getLessThanSignEqualsSignKeyword_7()); 
                          
                    }

                    }
                    break;
                case 9 :
                    // InternalQVTcore.g:2143:2: kw= '='
                    {
                    kw=(Token)match(input,49,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getEqualsSignKeyword_8()); 
                          
                    }

                    }
                    break;
                case 10 :
                    // InternalQVTcore.g:2150:2: kw= '<>'
                    {
                    kw=(Token)match(input,50,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getLessThanSignGreaterThanSignKeyword_9()); 
                          
                    }

                    }
                    break;
                case 11 :
                    // InternalQVTcore.g:2157:2: kw= 'and'
                    {
                    kw=(Token)match(input,51,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getAndKeyword_10()); 
                          
                    }

                    }
                    break;
                case 12 :
                    // InternalQVTcore.g:2164:2: kw= 'or'
                    {
                    kw=(Token)match(input,52,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getOrKeyword_11()); 
                          
                    }

                    }
                    break;
                case 13 :
                    // InternalQVTcore.g:2171:2: kw= 'xor'
                    {
                    kw=(Token)match(input,53,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getXorKeyword_12()); 
                          
                    }

                    }
                    break;
                case 14 :
                    // InternalQVTcore.g:2178:2: kw= 'implies'
                    {
                    kw=(Token)match(input,54,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
    // InternalQVTcore.g:2191:1: entryRuleEssentialOCLNavigationOperatorName returns [String current=null] : iv_ruleEssentialOCLNavigationOperatorName= ruleEssentialOCLNavigationOperatorName EOF ;
    public final String entryRuleEssentialOCLNavigationOperatorName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEssentialOCLNavigationOperatorName = null;


        try {
            // InternalQVTcore.g:2192:2: (iv_ruleEssentialOCLNavigationOperatorName= ruleEssentialOCLNavigationOperatorName EOF )
            // InternalQVTcore.g:2193:2: iv_ruleEssentialOCLNavigationOperatorName= ruleEssentialOCLNavigationOperatorName EOF
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
    // InternalQVTcore.g:2200:1: ruleEssentialOCLNavigationOperatorName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '.' | kw= '->' | kw= '?.' | kw= '?->' ) ;
    public final AntlrDatatypeRuleToken ruleEssentialOCLNavigationOperatorName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalQVTcore.g:2203:28: ( (kw= '.' | kw= '->' | kw= '?.' | kw= '?->' ) )
            // InternalQVTcore.g:2204:1: (kw= '.' | kw= '->' | kw= '?.' | kw= '?->' )
            {
            // InternalQVTcore.g:2204:1: (kw= '.' | kw= '->' | kw= '?.' | kw= '?->' )
            int alt46=4;
            switch ( input.LA(1) ) {
            case 55:
                {
                alt46=1;
                }
                break;
            case 56:
                {
                alt46=2;
                }
                break;
            case 57:
                {
                alt46=3;
                }
                break;
            case 58:
                {
                alt46=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }

            switch (alt46) {
                case 1 :
                    // InternalQVTcore.g:2205:2: kw= '.'
                    {
                    kw=(Token)match(input,55,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLNavigationOperatorNameAccess().getFullStopKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalQVTcore.g:2212:2: kw= '->'
                    {
                    kw=(Token)match(input,56,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLNavigationOperatorNameAccess().getHyphenMinusGreaterThanSignKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalQVTcore.g:2219:2: kw= '?.'
                    {
                    kw=(Token)match(input,57,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLNavigationOperatorNameAccess().getQuestionMarkFullStopKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalQVTcore.g:2226:2: kw= '?->'
                    {
                    kw=(Token)match(input,58,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
    // InternalQVTcore.g:2239:1: entryRuleBinaryOperatorName returns [String current=null] : iv_ruleBinaryOperatorName= ruleBinaryOperatorName EOF ;
    public final String entryRuleBinaryOperatorName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBinaryOperatorName = null;


        try {
            // InternalQVTcore.g:2240:2: (iv_ruleBinaryOperatorName= ruleBinaryOperatorName EOF )
            // InternalQVTcore.g:2241:2: iv_ruleBinaryOperatorName= ruleBinaryOperatorName EOF
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
    // InternalQVTcore.g:2248:1: ruleBinaryOperatorName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_InfixOperatorName_0= ruleInfixOperatorName | this_NavigationOperatorName_1= ruleNavigationOperatorName ) ;
    public final AntlrDatatypeRuleToken ruleBinaryOperatorName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_InfixOperatorName_0 = null;

        AntlrDatatypeRuleToken this_NavigationOperatorName_1 = null;


         enterRule(); 
            
        try {
            // InternalQVTcore.g:2251:28: ( (this_InfixOperatorName_0= ruleInfixOperatorName | this_NavigationOperatorName_1= ruleNavigationOperatorName ) )
            // InternalQVTcore.g:2252:1: (this_InfixOperatorName_0= ruleInfixOperatorName | this_NavigationOperatorName_1= ruleNavigationOperatorName )
            {
            // InternalQVTcore.g:2252:1: (this_InfixOperatorName_0= ruleInfixOperatorName | this_NavigationOperatorName_1= ruleNavigationOperatorName )
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==32||LA47_0==41||(LA47_0>=43 && LA47_0<=54)) ) {
                alt47=1;
            }
            else if ( ((LA47_0>=55 && LA47_0<=58)) ) {
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
                    // InternalQVTcore.g:2253:5: this_InfixOperatorName_0= ruleInfixOperatorName
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
                    // InternalQVTcore.g:2265:5: this_NavigationOperatorName_1= ruleNavigationOperatorName
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
    // InternalQVTcore.g:2283:1: entryRuleInfixOperatorName returns [String current=null] : iv_ruleInfixOperatorName= ruleInfixOperatorName EOF ;
    public final String entryRuleInfixOperatorName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInfixOperatorName = null;


        try {
            // InternalQVTcore.g:2284:2: (iv_ruleInfixOperatorName= ruleInfixOperatorName EOF )
            // InternalQVTcore.g:2285:2: iv_ruleInfixOperatorName= ruleInfixOperatorName EOF
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
    // InternalQVTcore.g:2292:1: ruleInfixOperatorName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_EssentialOCLInfixOperatorName_0= ruleEssentialOCLInfixOperatorName ;
    public final AntlrDatatypeRuleToken ruleInfixOperatorName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_EssentialOCLInfixOperatorName_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTcore.g:2295:28: (this_EssentialOCLInfixOperatorName_0= ruleEssentialOCLInfixOperatorName )
            // InternalQVTcore.g:2297:5: this_EssentialOCLInfixOperatorName_0= ruleEssentialOCLInfixOperatorName
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
    // InternalQVTcore.g:2315:1: entryRuleNavigationOperatorName returns [String current=null] : iv_ruleNavigationOperatorName= ruleNavigationOperatorName EOF ;
    public final String entryRuleNavigationOperatorName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNavigationOperatorName = null;


        try {
            // InternalQVTcore.g:2316:2: (iv_ruleNavigationOperatorName= ruleNavigationOperatorName EOF )
            // InternalQVTcore.g:2317:2: iv_ruleNavigationOperatorName= ruleNavigationOperatorName EOF
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
    // InternalQVTcore.g:2324:1: ruleNavigationOperatorName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_EssentialOCLNavigationOperatorName_0= ruleEssentialOCLNavigationOperatorName ;
    public final AntlrDatatypeRuleToken ruleNavigationOperatorName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_EssentialOCLNavigationOperatorName_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTcore.g:2327:28: (this_EssentialOCLNavigationOperatorName_0= ruleEssentialOCLNavigationOperatorName )
            // InternalQVTcore.g:2329:5: this_EssentialOCLNavigationOperatorName_0= ruleEssentialOCLNavigationOperatorName
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
    // InternalQVTcore.g:2347:1: entryRuleUnaryOperatorName returns [String current=null] : iv_ruleUnaryOperatorName= ruleUnaryOperatorName EOF ;
    public final String entryRuleUnaryOperatorName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnaryOperatorName = null;


        try {
            // InternalQVTcore.g:2348:2: (iv_ruleUnaryOperatorName= ruleUnaryOperatorName EOF )
            // InternalQVTcore.g:2349:2: iv_ruleUnaryOperatorName= ruleUnaryOperatorName EOF
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
    // InternalQVTcore.g:2356:1: ruleUnaryOperatorName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_EssentialOCLUnaryOperatorName_0= ruleEssentialOCLUnaryOperatorName ;
    public final AntlrDatatypeRuleToken ruleUnaryOperatorName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_EssentialOCLUnaryOperatorName_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTcore.g:2359:28: (this_EssentialOCLUnaryOperatorName_0= ruleEssentialOCLUnaryOperatorName )
            // InternalQVTcore.g:2361:5: this_EssentialOCLUnaryOperatorName_0= ruleEssentialOCLUnaryOperatorName
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
    // InternalQVTcore.g:2379:1: entryRuleEssentialOCLUnrestrictedName returns [String current=null] : iv_ruleEssentialOCLUnrestrictedName= ruleEssentialOCLUnrestrictedName EOF ;
    public final String entryRuleEssentialOCLUnrestrictedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEssentialOCLUnrestrictedName = null;


        try {
            // InternalQVTcore.g:2380:2: (iv_ruleEssentialOCLUnrestrictedName= ruleEssentialOCLUnrestrictedName EOF )
            // InternalQVTcore.g:2381:2: iv_ruleEssentialOCLUnrestrictedName= ruleEssentialOCLUnrestrictedName EOF
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
    // InternalQVTcore.g:2388:1: ruleEssentialOCLUnrestrictedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_Identifier_0= ruleIdentifier ;
    public final AntlrDatatypeRuleToken ruleEssentialOCLUnrestrictedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_Identifier_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTcore.g:2391:28: (this_Identifier_0= ruleIdentifier )
            // InternalQVTcore.g:2393:5: this_Identifier_0= ruleIdentifier
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


    // $ANTLR start "entryRuleEssentialOCLUnreservedName"
    // InternalQVTcore.g:2411:1: entryRuleEssentialOCLUnreservedName returns [String current=null] : iv_ruleEssentialOCLUnreservedName= ruleEssentialOCLUnreservedName EOF ;
    public final String entryRuleEssentialOCLUnreservedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEssentialOCLUnreservedName = null;


        try {
            // InternalQVTcore.g:2412:2: (iv_ruleEssentialOCLUnreservedName= ruleEssentialOCLUnreservedName EOF )
            // InternalQVTcore.g:2413:2: iv_ruleEssentialOCLUnreservedName= ruleEssentialOCLUnreservedName EOF
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
    // InternalQVTcore.g:2420:1: ruleEssentialOCLUnreservedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_UnrestrictedName_0= ruleUnrestrictedName | this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier | this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier | kw= 'Map' | kw= 'Tuple' ) ;
    public final AntlrDatatypeRuleToken ruleEssentialOCLUnreservedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_UnrestrictedName_0 = null;

        AntlrDatatypeRuleToken this_CollectionTypeIdentifier_1 = null;

        AntlrDatatypeRuleToken this_PrimitiveTypeIdentifier_2 = null;


         enterRule(); 
            
        try {
            // InternalQVTcore.g:2423:28: ( (this_UnrestrictedName_0= ruleUnrestrictedName | this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier | this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier | kw= 'Map' | kw= 'Tuple' ) )
            // InternalQVTcore.g:2424:1: (this_UnrestrictedName_0= ruleUnrestrictedName | this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier | this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier | kw= 'Map' | kw= 'Tuple' )
            {
            // InternalQVTcore.g:2424:1: (this_UnrestrictedName_0= ruleUnrestrictedName | this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier | this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier | kw= 'Map' | kw= 'Tuple' )
            int alt48=5;
            switch ( input.LA(1) ) {
            case RULE_SIMPLE_ID:
            case RULE_ESCAPED_ID:
            case 17:
            case 19:
            case 25:
            case 26:
            case 30:
            case 34:
            case 35:
            case 37:
            case 38:
            case 39:
            case 40:
                {
                alt48=1;
                }
                break;
            case 69:
            case 70:
            case 71:
            case 72:
            case 73:
                {
                alt48=2;
                }
                break;
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
                {
                alt48=3;
                }
                break;
            case 59:
                {
                alt48=4;
                }
                break;
            case 60:
                {
                alt48=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }

            switch (alt48) {
                case 1 :
                    // InternalQVTcore.g:2425:5: this_UnrestrictedName_0= ruleUnrestrictedName
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
                    // InternalQVTcore.g:2437:5: this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier
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
                    // InternalQVTcore.g:2449:5: this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier
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
                    // InternalQVTcore.g:2461:2: kw= 'Map'
                    {
                    kw=(Token)match(input,59,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLUnreservedNameAccess().getMapKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // InternalQVTcore.g:2468:2: kw= 'Tuple'
                    {
                    kw=(Token)match(input,60,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
    // InternalQVTcore.g:2481:1: entryRuleUnreservedName returns [String current=null] : iv_ruleUnreservedName= ruleUnreservedName EOF ;
    public final String entryRuleUnreservedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnreservedName = null;


        try {
            // InternalQVTcore.g:2482:2: (iv_ruleUnreservedName= ruleUnreservedName EOF )
            // InternalQVTcore.g:2483:2: iv_ruleUnreservedName= ruleUnreservedName EOF
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
    // InternalQVTcore.g:2490:1: ruleUnreservedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_EssentialOCLUnreservedName_0= ruleEssentialOCLUnreservedName ;
    public final AntlrDatatypeRuleToken ruleUnreservedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_EssentialOCLUnreservedName_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTcore.g:2493:28: (this_EssentialOCLUnreservedName_0= ruleEssentialOCLUnreservedName )
            // InternalQVTcore.g:2495:5: this_EssentialOCLUnreservedName_0= ruleEssentialOCLUnreservedName
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


    // $ANTLR start "entryRuleURIPathNameCS"
    // InternalQVTcore.g:2513:1: entryRuleURIPathNameCS returns [EObject current=null] : iv_ruleURIPathNameCS= ruleURIPathNameCS EOF ;
    public final EObject entryRuleURIPathNameCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleURIPathNameCS = null;


        try {
            // InternalQVTcore.g:2514:2: (iv_ruleURIPathNameCS= ruleURIPathNameCS EOF )
            // InternalQVTcore.g:2515:2: iv_ruleURIPathNameCS= ruleURIPathNameCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getURIPathNameCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleURIPathNameCS=ruleURIPathNameCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleURIPathNameCS; 
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
    // $ANTLR end "entryRuleURIPathNameCS"


    // $ANTLR start "ruleURIPathNameCS"
    // InternalQVTcore.g:2522:1: ruleURIPathNameCS returns [EObject current=null] : ( ( (lv_ownedPathElements_0_0= ruleURIFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )* ) ;
    public final EObject ruleURIPathNameCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_ownedPathElements_0_0 = null;

        EObject lv_ownedPathElements_2_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTcore.g:2525:28: ( ( ( (lv_ownedPathElements_0_0= ruleURIFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )* ) )
            // InternalQVTcore.g:2526:1: ( ( (lv_ownedPathElements_0_0= ruleURIFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )* )
            {
            // InternalQVTcore.g:2526:1: ( ( (lv_ownedPathElements_0_0= ruleURIFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )* )
            // InternalQVTcore.g:2526:2: ( (lv_ownedPathElements_0_0= ruleURIFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )*
            {
            // InternalQVTcore.g:2526:2: ( (lv_ownedPathElements_0_0= ruleURIFirstPathElementCS ) )
            // InternalQVTcore.g:2527:1: (lv_ownedPathElements_0_0= ruleURIFirstPathElementCS )
            {
            // InternalQVTcore.g:2527:1: (lv_ownedPathElements_0_0= ruleURIFirstPathElementCS )
            // InternalQVTcore.g:2528:3: lv_ownedPathElements_0_0= ruleURIFirstPathElementCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getURIPathNameCSAccess().getOwnedPathElementsURIFirstPathElementCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_40);
            lv_ownedPathElements_0_0=ruleURIFirstPathElementCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getURIPathNameCSRule());
              	        }
                     		add(
                     			current, 
                     			"ownedPathElements",
                      		lv_ownedPathElements_0_0, 
                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.URIFirstPathElementCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalQVTcore.g:2544:2: (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==31) ) {
                    int LA49_1 = input.LA(2);

                    if ( ((LA49_1>=RULE_SIMPLE_ID && LA49_1<=RULE_ESCAPED_ID)||LA49_1==17||LA49_1==19||(LA49_1>=25 && LA49_1<=26)||LA49_1==30||(LA49_1>=34 && LA49_1<=35)||(LA49_1>=37 && LA49_1<=40)||(LA49_1>=59 && LA49_1<=73)) ) {
                        alt49=1;
                    }


                }


                switch (alt49) {
            	case 1 :
            	    // InternalQVTcore.g:2544:4: otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) )
            	    {
            	    otherlv_1=(Token)match(input,31,FollowSets000.FOLLOW_26); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getURIPathNameCSAccess().getColonColonKeyword_1_0());
            	          
            	    }
            	    // InternalQVTcore.g:2548:1: ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) )
            	    // InternalQVTcore.g:2549:1: (lv_ownedPathElements_2_0= ruleNextPathElementCS )
            	    {
            	    // InternalQVTcore.g:2549:1: (lv_ownedPathElements_2_0= ruleNextPathElementCS )
            	    // InternalQVTcore.g:2550:3: lv_ownedPathElements_2_0= ruleNextPathElementCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getURIPathNameCSAccess().getOwnedPathElementsNextPathElementCSParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_40);
            	    lv_ownedPathElements_2_0=ruleNextPathElementCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getURIPathNameCSRule());
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
            	    break loop49;
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
    // $ANTLR end "ruleURIPathNameCS"


    // $ANTLR start "entryRuleURIFirstPathElementCS"
    // InternalQVTcore.g:2574:1: entryRuleURIFirstPathElementCS returns [EObject current=null] : iv_ruleURIFirstPathElementCS= ruleURIFirstPathElementCS EOF ;
    public final EObject entryRuleURIFirstPathElementCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleURIFirstPathElementCS = null;


        try {
            // InternalQVTcore.g:2575:2: (iv_ruleURIFirstPathElementCS= ruleURIFirstPathElementCS EOF )
            // InternalQVTcore.g:2576:2: iv_ruleURIFirstPathElementCS= ruleURIFirstPathElementCS EOF
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
    // InternalQVTcore.g:2583:1: ruleURIFirstPathElementCS returns [EObject current=null] : ( ( ( ruleUnrestrictedName ) ) | ( () ( ( ruleURI ) ) ) ) ;
    public final EObject ruleURIFirstPathElementCS() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // InternalQVTcore.g:2586:28: ( ( ( ( ruleUnrestrictedName ) ) | ( () ( ( ruleURI ) ) ) ) )
            // InternalQVTcore.g:2587:1: ( ( ( ruleUnrestrictedName ) ) | ( () ( ( ruleURI ) ) ) )
            {
            // InternalQVTcore.g:2587:1: ( ( ( ruleUnrestrictedName ) ) | ( () ( ( ruleURI ) ) ) )
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( ((LA50_0>=RULE_SIMPLE_ID && LA50_0<=RULE_ESCAPED_ID)||LA50_0==17||LA50_0==19||(LA50_0>=25 && LA50_0<=26)||LA50_0==30||(LA50_0>=34 && LA50_0<=35)||(LA50_0>=37 && LA50_0<=40)) ) {
                alt50=1;
            }
            else if ( (LA50_0==RULE_SINGLE_QUOTED_STRING) ) {
                alt50=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }
            switch (alt50) {
                case 1 :
                    // InternalQVTcore.g:2587:2: ( ( ruleUnrestrictedName ) )
                    {
                    // InternalQVTcore.g:2587:2: ( ( ruleUnrestrictedName ) )
                    // InternalQVTcore.g:2588:1: ( ruleUnrestrictedName )
                    {
                    // InternalQVTcore.g:2588:1: ( ruleUnrestrictedName )
                    // InternalQVTcore.g:2589:3: ruleUnrestrictedName
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
                    // InternalQVTcore.g:2606:6: ( () ( ( ruleURI ) ) )
                    {
                    // InternalQVTcore.g:2606:6: ( () ( ( ruleURI ) ) )
                    // InternalQVTcore.g:2606:7: () ( ( ruleURI ) )
                    {
                    // InternalQVTcore.g:2606:7: ()
                    // InternalQVTcore.g:2607:2: 
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

                    // InternalQVTcore.g:2615:2: ( ( ruleURI ) )
                    // InternalQVTcore.g:2616:1: ( ruleURI )
                    {
                    // InternalQVTcore.g:2616:1: ( ruleURI )
                    // InternalQVTcore.g:2617:3: ruleURI
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
    // InternalQVTcore.g:2641:1: entryRulePrimitiveTypeIdentifier returns [String current=null] : iv_rulePrimitiveTypeIdentifier= rulePrimitiveTypeIdentifier EOF ;
    public final String entryRulePrimitiveTypeIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePrimitiveTypeIdentifier = null;


        try {
            // InternalQVTcore.g:2642:2: (iv_rulePrimitiveTypeIdentifier= rulePrimitiveTypeIdentifier EOF )
            // InternalQVTcore.g:2643:2: iv_rulePrimitiveTypeIdentifier= rulePrimitiveTypeIdentifier EOF
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
    // InternalQVTcore.g:2650:1: rulePrimitiveTypeIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Boolean' | kw= 'Integer' | kw= 'Real' | kw= 'String' | kw= 'UnlimitedNatural' | kw= 'OclAny' | kw= 'OclInvalid' | kw= 'OclVoid' ) ;
    public final AntlrDatatypeRuleToken rulePrimitiveTypeIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalQVTcore.g:2653:28: ( (kw= 'Boolean' | kw= 'Integer' | kw= 'Real' | kw= 'String' | kw= 'UnlimitedNatural' | kw= 'OclAny' | kw= 'OclInvalid' | kw= 'OclVoid' ) )
            // InternalQVTcore.g:2654:1: (kw= 'Boolean' | kw= 'Integer' | kw= 'Real' | kw= 'String' | kw= 'UnlimitedNatural' | kw= 'OclAny' | kw= 'OclInvalid' | kw= 'OclVoid' )
            {
            // InternalQVTcore.g:2654:1: (kw= 'Boolean' | kw= 'Integer' | kw= 'Real' | kw= 'String' | kw= 'UnlimitedNatural' | kw= 'OclAny' | kw= 'OclInvalid' | kw= 'OclVoid' )
            int alt51=8;
            switch ( input.LA(1) ) {
            case 61:
                {
                alt51=1;
                }
                break;
            case 62:
                {
                alt51=2;
                }
                break;
            case 63:
                {
                alt51=3;
                }
                break;
            case 64:
                {
                alt51=4;
                }
                break;
            case 65:
                {
                alt51=5;
                }
                break;
            case 66:
                {
                alt51=6;
                }
                break;
            case 67:
                {
                alt51=7;
                }
                break;
            case 68:
                {
                alt51=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }

            switch (alt51) {
                case 1 :
                    // InternalQVTcore.g:2655:2: kw= 'Boolean'
                    {
                    kw=(Token)match(input,61,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getBooleanKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalQVTcore.g:2662:2: kw= 'Integer'
                    {
                    kw=(Token)match(input,62,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getIntegerKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalQVTcore.g:2669:2: kw= 'Real'
                    {
                    kw=(Token)match(input,63,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getRealKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalQVTcore.g:2676:2: kw= 'String'
                    {
                    kw=(Token)match(input,64,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getStringKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // InternalQVTcore.g:2683:2: kw= 'UnlimitedNatural'
                    {
                    kw=(Token)match(input,65,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getUnlimitedNaturalKeyword_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // InternalQVTcore.g:2690:2: kw= 'OclAny'
                    {
                    kw=(Token)match(input,66,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getOclAnyKeyword_5()); 
                          
                    }

                    }
                    break;
                case 7 :
                    // InternalQVTcore.g:2697:2: kw= 'OclInvalid'
                    {
                    kw=(Token)match(input,67,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getOclInvalidKeyword_6()); 
                          
                    }

                    }
                    break;
                case 8 :
                    // InternalQVTcore.g:2704:2: kw= 'OclVoid'
                    {
                    kw=(Token)match(input,68,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
    // InternalQVTcore.g:2717:1: entryRulePrimitiveTypeCS returns [EObject current=null] : iv_rulePrimitiveTypeCS= rulePrimitiveTypeCS EOF ;
    public final EObject entryRulePrimitiveTypeCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveTypeCS = null;


        try {
            // InternalQVTcore.g:2718:2: (iv_rulePrimitiveTypeCS= rulePrimitiveTypeCS EOF )
            // InternalQVTcore.g:2719:2: iv_rulePrimitiveTypeCS= rulePrimitiveTypeCS EOF
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
    // InternalQVTcore.g:2726:1: rulePrimitiveTypeCS returns [EObject current=null] : ( (lv_name_0_0= rulePrimitiveTypeIdentifier ) ) ;
    public final EObject rulePrimitiveTypeCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTcore.g:2729:28: ( ( (lv_name_0_0= rulePrimitiveTypeIdentifier ) ) )
            // InternalQVTcore.g:2730:1: ( (lv_name_0_0= rulePrimitiveTypeIdentifier ) )
            {
            // InternalQVTcore.g:2730:1: ( (lv_name_0_0= rulePrimitiveTypeIdentifier ) )
            // InternalQVTcore.g:2731:1: (lv_name_0_0= rulePrimitiveTypeIdentifier )
            {
            // InternalQVTcore.g:2731:1: (lv_name_0_0= rulePrimitiveTypeIdentifier )
            // InternalQVTcore.g:2732:3: lv_name_0_0= rulePrimitiveTypeIdentifier
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
    // InternalQVTcore.g:2756:1: entryRuleCollectionTypeIdentifier returns [String current=null] : iv_ruleCollectionTypeIdentifier= ruleCollectionTypeIdentifier EOF ;
    public final String entryRuleCollectionTypeIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleCollectionTypeIdentifier = null;


        try {
            // InternalQVTcore.g:2757:2: (iv_ruleCollectionTypeIdentifier= ruleCollectionTypeIdentifier EOF )
            // InternalQVTcore.g:2758:2: iv_ruleCollectionTypeIdentifier= ruleCollectionTypeIdentifier EOF
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
    // InternalQVTcore.g:2765:1: ruleCollectionTypeIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Set' | kw= 'Bag' | kw= 'Sequence' | kw= 'Collection' | kw= 'OrderedSet' ) ;
    public final AntlrDatatypeRuleToken ruleCollectionTypeIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalQVTcore.g:2768:28: ( (kw= 'Set' | kw= 'Bag' | kw= 'Sequence' | kw= 'Collection' | kw= 'OrderedSet' ) )
            // InternalQVTcore.g:2769:1: (kw= 'Set' | kw= 'Bag' | kw= 'Sequence' | kw= 'Collection' | kw= 'OrderedSet' )
            {
            // InternalQVTcore.g:2769:1: (kw= 'Set' | kw= 'Bag' | kw= 'Sequence' | kw= 'Collection' | kw= 'OrderedSet' )
            int alt52=5;
            switch ( input.LA(1) ) {
            case 69:
                {
                alt52=1;
                }
                break;
            case 70:
                {
                alt52=2;
                }
                break;
            case 71:
                {
                alt52=3;
                }
                break;
            case 72:
                {
                alt52=4;
                }
                break;
            case 73:
                {
                alt52=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }

            switch (alt52) {
                case 1 :
                    // InternalQVTcore.g:2770:2: kw= 'Set'
                    {
                    kw=(Token)match(input,69,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getSetKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalQVTcore.g:2777:2: kw= 'Bag'
                    {
                    kw=(Token)match(input,70,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getBagKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalQVTcore.g:2784:2: kw= 'Sequence'
                    {
                    kw=(Token)match(input,71,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getSequenceKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalQVTcore.g:2791:2: kw= 'Collection'
                    {
                    kw=(Token)match(input,72,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getCollectionKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // InternalQVTcore.g:2798:2: kw= 'OrderedSet'
                    {
                    kw=(Token)match(input,73,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
    // InternalQVTcore.g:2811:1: entryRuleCollectionTypeCS returns [EObject current=null] : iv_ruleCollectionTypeCS= ruleCollectionTypeCS EOF ;
    public final EObject entryRuleCollectionTypeCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionTypeCS = null;


        try {
            // InternalQVTcore.g:2812:2: (iv_ruleCollectionTypeCS= ruleCollectionTypeCS EOF )
            // InternalQVTcore.g:2813:2: iv_ruleCollectionTypeCS= ruleCollectionTypeCS EOF
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
    // InternalQVTcore.g:2820:1: ruleCollectionTypeCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )? ) ;
    public final EObject ruleCollectionTypeCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTcore.g:2823:28: ( ( ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )? ) )
            // InternalQVTcore.g:2824:1: ( ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )? )
            {
            // InternalQVTcore.g:2824:1: ( ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )? )
            // InternalQVTcore.g:2824:2: ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )?
            {
            // InternalQVTcore.g:2824:2: ( (lv_name_0_0= ruleCollectionTypeIdentifier ) )
            // InternalQVTcore.g:2825:1: (lv_name_0_0= ruleCollectionTypeIdentifier )
            {
            // InternalQVTcore.g:2825:1: (lv_name_0_0= ruleCollectionTypeIdentifier )
            // InternalQVTcore.g:2826:3: lv_name_0_0= ruleCollectionTypeIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCollectionTypeCSAccess().getNameCollectionTypeIdentifierParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_41);
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

            // InternalQVTcore.g:2842:2: (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==27) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // InternalQVTcore.g:2842:4: otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,27,FollowSets000.FOLLOW_26); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getCollectionTypeCSAccess().getLeftParenthesisKeyword_1_0());
                          
                    }
                    // InternalQVTcore.g:2846:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                    // InternalQVTcore.g:2847:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    {
                    // InternalQVTcore.g:2847:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    // InternalQVTcore.g:2848:3: lv_ownedType_2_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionTypeCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_24);
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

                    otherlv_3=(Token)match(input,28,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
    // InternalQVTcore.g:2876:1: entryRuleMapTypeCS returns [EObject current=null] : iv_ruleMapTypeCS= ruleMapTypeCS EOF ;
    public final EObject entryRuleMapTypeCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMapTypeCS = null;


        try {
            // InternalQVTcore.g:2877:2: (iv_ruleMapTypeCS= ruleMapTypeCS EOF )
            // InternalQVTcore.g:2878:2: iv_ruleMapTypeCS= ruleMapTypeCS EOF
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
    // InternalQVTcore.g:2885:1: ruleMapTypeCS returns [EObject current=null] : ( ( (lv_name_0_0= 'Map' ) ) (otherlv_1= '(' ( (lv_ownedKeyType_2_0= ruleTypeExpCS ) ) otherlv_3= ',' ( (lv_ownedValueType_4_0= ruleTypeExpCS ) ) otherlv_5= ')' )? ) ;
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
            // InternalQVTcore.g:2888:28: ( ( ( (lv_name_0_0= 'Map' ) ) (otherlv_1= '(' ( (lv_ownedKeyType_2_0= ruleTypeExpCS ) ) otherlv_3= ',' ( (lv_ownedValueType_4_0= ruleTypeExpCS ) ) otherlv_5= ')' )? ) )
            // InternalQVTcore.g:2889:1: ( ( (lv_name_0_0= 'Map' ) ) (otherlv_1= '(' ( (lv_ownedKeyType_2_0= ruleTypeExpCS ) ) otherlv_3= ',' ( (lv_ownedValueType_4_0= ruleTypeExpCS ) ) otherlv_5= ')' )? )
            {
            // InternalQVTcore.g:2889:1: ( ( (lv_name_0_0= 'Map' ) ) (otherlv_1= '(' ( (lv_ownedKeyType_2_0= ruleTypeExpCS ) ) otherlv_3= ',' ( (lv_ownedValueType_4_0= ruleTypeExpCS ) ) otherlv_5= ')' )? )
            // InternalQVTcore.g:2889:2: ( (lv_name_0_0= 'Map' ) ) (otherlv_1= '(' ( (lv_ownedKeyType_2_0= ruleTypeExpCS ) ) otherlv_3= ',' ( (lv_ownedValueType_4_0= ruleTypeExpCS ) ) otherlv_5= ')' )?
            {
            // InternalQVTcore.g:2889:2: ( (lv_name_0_0= 'Map' ) )
            // InternalQVTcore.g:2890:1: (lv_name_0_0= 'Map' )
            {
            // InternalQVTcore.g:2890:1: (lv_name_0_0= 'Map' )
            // InternalQVTcore.g:2891:3: lv_name_0_0= 'Map'
            {
            lv_name_0_0=(Token)match(input,59,FollowSets000.FOLLOW_41); if (state.failed) return current;
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

            // InternalQVTcore.g:2904:2: (otherlv_1= '(' ( (lv_ownedKeyType_2_0= ruleTypeExpCS ) ) otherlv_3= ',' ( (lv_ownedValueType_4_0= ruleTypeExpCS ) ) otherlv_5= ')' )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==27) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // InternalQVTcore.g:2904:4: otherlv_1= '(' ( (lv_ownedKeyType_2_0= ruleTypeExpCS ) ) otherlv_3= ',' ( (lv_ownedValueType_4_0= ruleTypeExpCS ) ) otherlv_5= ')'
                    {
                    otherlv_1=(Token)match(input,27,FollowSets000.FOLLOW_26); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getMapTypeCSAccess().getLeftParenthesisKeyword_1_0());
                          
                    }
                    // InternalQVTcore.g:2908:1: ( (lv_ownedKeyType_2_0= ruleTypeExpCS ) )
                    // InternalQVTcore.g:2909:1: (lv_ownedKeyType_2_0= ruleTypeExpCS )
                    {
                    // InternalQVTcore.g:2909:1: (lv_ownedKeyType_2_0= ruleTypeExpCS )
                    // InternalQVTcore.g:2910:3: lv_ownedKeyType_2_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMapTypeCSAccess().getOwnedKeyTypeTypeExpCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_42);
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

                    otherlv_3=(Token)match(input,20,FollowSets000.FOLLOW_26); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getMapTypeCSAccess().getCommaKeyword_1_2());
                          
                    }
                    // InternalQVTcore.g:2930:1: ( (lv_ownedValueType_4_0= ruleTypeExpCS ) )
                    // InternalQVTcore.g:2931:1: (lv_ownedValueType_4_0= ruleTypeExpCS )
                    {
                    // InternalQVTcore.g:2931:1: (lv_ownedValueType_4_0= ruleTypeExpCS )
                    // InternalQVTcore.g:2932:3: lv_ownedValueType_4_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMapTypeCSAccess().getOwnedValueTypeTypeExpCSParserRuleCall_1_3_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_24);
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

                    otherlv_5=(Token)match(input,28,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
    // InternalQVTcore.g:2960:1: entryRuleTupleTypeCS returns [EObject current=null] : iv_ruleTupleTypeCS= ruleTupleTypeCS EOF ;
    public final EObject entryRuleTupleTypeCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTupleTypeCS = null;


        try {
            // InternalQVTcore.g:2961:2: (iv_ruleTupleTypeCS= ruleTupleTypeCS EOF )
            // InternalQVTcore.g:2962:2: iv_ruleTupleTypeCS= ruleTupleTypeCS EOF
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
    // InternalQVTcore.g:2969:1: ruleTupleTypeCS returns [EObject current=null] : ( ( (lv_name_0_0= 'Tuple' ) ) (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )? ) ;
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
            // InternalQVTcore.g:2972:28: ( ( ( (lv_name_0_0= 'Tuple' ) ) (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )? ) )
            // InternalQVTcore.g:2973:1: ( ( (lv_name_0_0= 'Tuple' ) ) (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )? )
            {
            // InternalQVTcore.g:2973:1: ( ( (lv_name_0_0= 'Tuple' ) ) (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )? )
            // InternalQVTcore.g:2973:2: ( (lv_name_0_0= 'Tuple' ) ) (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )?
            {
            // InternalQVTcore.g:2973:2: ( (lv_name_0_0= 'Tuple' ) )
            // InternalQVTcore.g:2974:1: (lv_name_0_0= 'Tuple' )
            {
            // InternalQVTcore.g:2974:1: (lv_name_0_0= 'Tuple' )
            // InternalQVTcore.g:2975:3: lv_name_0_0= 'Tuple'
            {
            lv_name_0_0=(Token)match(input,60,FollowSets000.FOLLOW_41); if (state.failed) return current;
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

            // InternalQVTcore.g:2988:2: (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==27) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // InternalQVTcore.g:2988:4: otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')'
                    {
                    otherlv_1=(Token)match(input,27,FollowSets000.FOLLOW_33); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getTupleTypeCSAccess().getLeftParenthesisKeyword_1_0());
                          
                    }
                    // InternalQVTcore.g:2992:1: ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )?
                    int alt56=2;
                    int LA56_0 = input.LA(1);

                    if ( ((LA56_0>=RULE_SIMPLE_ID && LA56_0<=RULE_ESCAPED_ID)||LA56_0==17||LA56_0==19||(LA56_0>=25 && LA56_0<=26)||LA56_0==30||(LA56_0>=34 && LA56_0<=35)||(LA56_0>=37 && LA56_0<=40)) ) {
                        alt56=1;
                    }
                    switch (alt56) {
                        case 1 :
                            // InternalQVTcore.g:2992:2: ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )*
                            {
                            // InternalQVTcore.g:2992:2: ( (lv_ownedParts_2_0= ruleTuplePartCS ) )
                            // InternalQVTcore.g:2993:1: (lv_ownedParts_2_0= ruleTuplePartCS )
                            {
                            // InternalQVTcore.g:2993:1: (lv_ownedParts_2_0= ruleTuplePartCS )
                            // InternalQVTcore.g:2994:3: lv_ownedParts_2_0= ruleTuplePartCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getTupleTypeCSAccess().getOwnedPartsTuplePartCSParserRuleCall_1_1_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_23);
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

                            // InternalQVTcore.g:3010:2: (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )*
                            loop55:
                            do {
                                int alt55=2;
                                int LA55_0 = input.LA(1);

                                if ( (LA55_0==20) ) {
                                    alt55=1;
                                }


                                switch (alt55) {
                            	case 1 :
                            	    // InternalQVTcore.g:3010:4: otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) )
                            	    {
                            	    otherlv_3=(Token)match(input,20,FollowSets000.FOLLOW_8); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_3, grammarAccess.getTupleTypeCSAccess().getCommaKeyword_1_1_1_0());
                            	          
                            	    }
                            	    // InternalQVTcore.g:3014:1: ( (lv_ownedParts_4_0= ruleTuplePartCS ) )
                            	    // InternalQVTcore.g:3015:1: (lv_ownedParts_4_0= ruleTuplePartCS )
                            	    {
                            	    // InternalQVTcore.g:3015:1: (lv_ownedParts_4_0= ruleTuplePartCS )
                            	    // InternalQVTcore.g:3016:3: lv_ownedParts_4_0= ruleTuplePartCS
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getTupleTypeCSAccess().getOwnedPartsTuplePartCSParserRuleCall_1_1_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FollowSets000.FOLLOW_23);
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
                            	    break loop55;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_5=(Token)match(input,28,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
    // InternalQVTcore.g:3044:1: entryRuleTuplePartCS returns [EObject current=null] : iv_ruleTuplePartCS= ruleTuplePartCS EOF ;
    public final EObject entryRuleTuplePartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTuplePartCS = null;


        try {
            // InternalQVTcore.g:3045:2: (iv_ruleTuplePartCS= ruleTuplePartCS EOF )
            // InternalQVTcore.g:3046:2: iv_ruleTuplePartCS= ruleTuplePartCS EOF
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
    // InternalQVTcore.g:3053:1: ruleTuplePartCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) ) ;
    public final EObject ruleTuplePartCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTcore.g:3056:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) ) )
            // InternalQVTcore.g:3057:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )
            {
            // InternalQVTcore.g:3057:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )
            // InternalQVTcore.g:3057:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) )
            {
            // InternalQVTcore.g:3057:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // InternalQVTcore.g:3058:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // InternalQVTcore.g:3058:1: (lv_name_0_0= ruleUnrestrictedName )
            // InternalQVTcore.g:3059:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTuplePartCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_25);
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
                      		"org.eclipse.qvtd.xtext.qvtcorebase.QVTcoreBase.UnrestrictedName");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,29,FollowSets000.FOLLOW_26); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getTuplePartCSAccess().getColonKeyword_1());
                  
            }
            // InternalQVTcore.g:3079:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
            // InternalQVTcore.g:3080:1: (lv_ownedType_2_0= ruleTypeExpCS )
            {
            // InternalQVTcore.g:3080:1: (lv_ownedType_2_0= ruleTypeExpCS )
            // InternalQVTcore.g:3081:3: lv_ownedType_2_0= ruleTypeExpCS
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
    // InternalQVTcore.g:3105:1: entryRuleCollectionLiteralExpCS returns [EObject current=null] : iv_ruleCollectionLiteralExpCS= ruleCollectionLiteralExpCS EOF ;
    public final EObject entryRuleCollectionLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionLiteralExpCS = null;


        try {
            // InternalQVTcore.g:3106:2: (iv_ruleCollectionLiteralExpCS= ruleCollectionLiteralExpCS EOF )
            // InternalQVTcore.g:3107:2: iv_ruleCollectionLiteralExpCS= ruleCollectionLiteralExpCS EOF
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
    // InternalQVTcore.g:3114:1: ruleCollectionLiteralExpCS returns [EObject current=null] : ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}' ) ;
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
            // InternalQVTcore.g:3117:28: ( ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}' ) )
            // InternalQVTcore.g:3118:1: ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}' )
            {
            // InternalQVTcore.g:3118:1: ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}' )
            // InternalQVTcore.g:3118:2: ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}'
            {
            // InternalQVTcore.g:3118:2: ( (lv_ownedType_0_0= ruleCollectionTypeCS ) )
            // InternalQVTcore.g:3119:1: (lv_ownedType_0_0= ruleCollectionTypeCS )
            {
            // InternalQVTcore.g:3119:1: (lv_ownedType_0_0= ruleCollectionTypeCS )
            // InternalQVTcore.g:3120:3: lv_ownedType_0_0= ruleCollectionTypeCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedTypeCollectionTypeCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_31);
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

            otherlv_1=(Token)match(input,21,FollowSets000.FOLLOW_43); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getCollectionLiteralExpCSAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // InternalQVTcore.g:3140:1: ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( ((LA59_0>=RULE_SIMPLE_ID && LA59_0<=RULE_SINGLE_QUOTED_STRING)||LA59_0==17||LA59_0==19||(LA59_0>=25 && LA59_0<=27)||(LA59_0>=29 && LA59_0<=30)||LA59_0==32||(LA59_0>=34 && LA59_0<=35)||(LA59_0>=37 && LA59_0<=42)||(LA59_0>=59 && LA59_0<=73)||LA59_0==76||(LA59_0>=78 && LA59_0<=81)||LA59_0==86||(LA59_0>=91 && LA59_0<=92)) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // InternalQVTcore.g:3140:2: ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )*
                    {
                    // InternalQVTcore.g:3140:2: ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) )
                    // InternalQVTcore.g:3141:1: (lv_ownedParts_2_0= ruleCollectionLiteralPartCS )
                    {
                    // InternalQVTcore.g:3141:1: (lv_ownedParts_2_0= ruleCollectionLiteralPartCS )
                    // InternalQVTcore.g:3142:3: lv_ownedParts_2_0= ruleCollectionLiteralPartCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedPartsCollectionLiteralPartCSParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_16);
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

                    // InternalQVTcore.g:3158:2: (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )*
                    loop58:
                    do {
                        int alt58=2;
                        int LA58_0 = input.LA(1);

                        if ( (LA58_0==20) ) {
                            alt58=1;
                        }


                        switch (alt58) {
                    	case 1 :
                    	    // InternalQVTcore.g:3158:4: otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) )
                    	    {
                    	    otherlv_3=(Token)match(input,20,FollowSets000.FOLLOW_44); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getCollectionLiteralExpCSAccess().getCommaKeyword_2_1_0());
                    	          
                    	    }
                    	    // InternalQVTcore.g:3162:1: ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) )
                    	    // InternalQVTcore.g:3163:1: (lv_ownedParts_4_0= ruleCollectionLiteralPartCS )
                    	    {
                    	    // InternalQVTcore.g:3163:1: (lv_ownedParts_4_0= ruleCollectionLiteralPartCS )
                    	    // InternalQVTcore.g:3164:3: lv_ownedParts_4_0= ruleCollectionLiteralPartCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedPartsCollectionLiteralPartCSParserRuleCall_2_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_16);
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
                    	    break loop58;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,23,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
    // InternalQVTcore.g:3192:1: entryRuleCollectionLiteralPartCS returns [EObject current=null] : iv_ruleCollectionLiteralPartCS= ruleCollectionLiteralPartCS EOF ;
    public final EObject entryRuleCollectionLiteralPartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionLiteralPartCS = null;


        try {
            // InternalQVTcore.g:3193:2: (iv_ruleCollectionLiteralPartCS= ruleCollectionLiteralPartCS EOF )
            // InternalQVTcore.g:3194:2: iv_ruleCollectionLiteralPartCS= ruleCollectionLiteralPartCS EOF
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
    // InternalQVTcore.g:3201:1: ruleCollectionLiteralPartCS returns [EObject current=null] : ( ( ( (lv_ownedExpression_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_ownedLastExpression_2_0= ruleExpCS ) ) )? ) | ( (lv_ownedExpression_3_0= rulePatternExpCS ) ) ) ;
    public final EObject ruleCollectionLiteralPartCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_ownedExpression_0_0 = null;

        EObject lv_ownedLastExpression_2_0 = null;

        EObject lv_ownedExpression_3_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTcore.g:3204:28: ( ( ( ( (lv_ownedExpression_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_ownedLastExpression_2_0= ruleExpCS ) ) )? ) | ( (lv_ownedExpression_3_0= rulePatternExpCS ) ) ) )
            // InternalQVTcore.g:3205:1: ( ( ( (lv_ownedExpression_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_ownedLastExpression_2_0= ruleExpCS ) ) )? ) | ( (lv_ownedExpression_3_0= rulePatternExpCS ) ) )
            {
            // InternalQVTcore.g:3205:1: ( ( ( (lv_ownedExpression_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_ownedLastExpression_2_0= ruleExpCS ) ) )? ) | ( (lv_ownedExpression_3_0= rulePatternExpCS ) ) )
            int alt61=2;
            alt61 = dfa61.predict(input);
            switch (alt61) {
                case 1 :
                    // InternalQVTcore.g:3205:2: ( ( (lv_ownedExpression_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_ownedLastExpression_2_0= ruleExpCS ) ) )? )
                    {
                    // InternalQVTcore.g:3205:2: ( ( (lv_ownedExpression_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_ownedLastExpression_2_0= ruleExpCS ) ) )? )
                    // InternalQVTcore.g:3205:3: ( (lv_ownedExpression_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_ownedLastExpression_2_0= ruleExpCS ) ) )?
                    {
                    // InternalQVTcore.g:3205:3: ( (lv_ownedExpression_0_0= ruleExpCS ) )
                    // InternalQVTcore.g:3206:1: (lv_ownedExpression_0_0= ruleExpCS )
                    {
                    // InternalQVTcore.g:3206:1: (lv_ownedExpression_0_0= ruleExpCS )
                    // InternalQVTcore.g:3207:3: lv_ownedExpression_0_0= ruleExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionLiteralPartCSAccess().getOwnedExpressionExpCSParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_45);
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

                    // InternalQVTcore.g:3223:2: (otherlv_1= '..' ( (lv_ownedLastExpression_2_0= ruleExpCS ) ) )?
                    int alt60=2;
                    int LA60_0 = input.LA(1);

                    if ( (LA60_0==74) ) {
                        alt60=1;
                    }
                    switch (alt60) {
                        case 1 :
                            // InternalQVTcore.g:3223:4: otherlv_1= '..' ( (lv_ownedLastExpression_2_0= ruleExpCS ) )
                            {
                            otherlv_1=(Token)match(input,74,FollowSets000.FOLLOW_17); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_1, grammarAccess.getCollectionLiteralPartCSAccess().getFullStopFullStopKeyword_0_1_0());
                                  
                            }
                            // InternalQVTcore.g:3227:1: ( (lv_ownedLastExpression_2_0= ruleExpCS ) )
                            // InternalQVTcore.g:3228:1: (lv_ownedLastExpression_2_0= ruleExpCS )
                            {
                            // InternalQVTcore.g:3228:1: (lv_ownedLastExpression_2_0= ruleExpCS )
                            // InternalQVTcore.g:3229:3: lv_ownedLastExpression_2_0= ruleExpCS
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
                    // InternalQVTcore.g:3246:6: ( (lv_ownedExpression_3_0= rulePatternExpCS ) )
                    {
                    // InternalQVTcore.g:3246:6: ( (lv_ownedExpression_3_0= rulePatternExpCS ) )
                    // InternalQVTcore.g:3247:1: (lv_ownedExpression_3_0= rulePatternExpCS )
                    {
                    // InternalQVTcore.g:3247:1: (lv_ownedExpression_3_0= rulePatternExpCS )
                    // InternalQVTcore.g:3248:3: lv_ownedExpression_3_0= rulePatternExpCS
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
    // InternalQVTcore.g:3272:1: entryRuleCollectionPatternCS returns [EObject current=null] : iv_ruleCollectionPatternCS= ruleCollectionPatternCS EOF ;
    public final EObject entryRuleCollectionPatternCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionPatternCS = null;


        try {
            // InternalQVTcore.g:3273:2: (iv_ruleCollectionPatternCS= ruleCollectionPatternCS EOF )
            // InternalQVTcore.g:3274:2: iv_ruleCollectionPatternCS= ruleCollectionPatternCS EOF
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
    // InternalQVTcore.g:3281:1: ruleCollectionPatternCS returns [EObject current=null] : ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= rulePatternExpCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= rulePatternExpCS ) ) )* (otherlv_5= '++' ( (lv_restVariableName_6_0= ruleIdentifier ) ) ) )? otherlv_7= '}' ) ;
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
            // InternalQVTcore.g:3284:28: ( ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= rulePatternExpCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= rulePatternExpCS ) ) )* (otherlv_5= '++' ( (lv_restVariableName_6_0= ruleIdentifier ) ) ) )? otherlv_7= '}' ) )
            // InternalQVTcore.g:3285:1: ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= rulePatternExpCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= rulePatternExpCS ) ) )* (otherlv_5= '++' ( (lv_restVariableName_6_0= ruleIdentifier ) ) ) )? otherlv_7= '}' )
            {
            // InternalQVTcore.g:3285:1: ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= rulePatternExpCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= rulePatternExpCS ) ) )* (otherlv_5= '++' ( (lv_restVariableName_6_0= ruleIdentifier ) ) ) )? otherlv_7= '}' )
            // InternalQVTcore.g:3285:2: ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= rulePatternExpCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= rulePatternExpCS ) ) )* (otherlv_5= '++' ( (lv_restVariableName_6_0= ruleIdentifier ) ) ) )? otherlv_7= '}'
            {
            // InternalQVTcore.g:3285:2: ( (lv_ownedType_0_0= ruleCollectionTypeCS ) )
            // InternalQVTcore.g:3286:1: (lv_ownedType_0_0= ruleCollectionTypeCS )
            {
            // InternalQVTcore.g:3286:1: (lv_ownedType_0_0= ruleCollectionTypeCS )
            // InternalQVTcore.g:3287:3: lv_ownedType_0_0= ruleCollectionTypeCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCollectionPatternCSAccess().getOwnedTypeCollectionTypeCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_31);
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

            otherlv_1=(Token)match(input,21,FollowSets000.FOLLOW_43); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getCollectionPatternCSAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // InternalQVTcore.g:3307:1: ( ( (lv_ownedParts_2_0= rulePatternExpCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= rulePatternExpCS ) ) )* (otherlv_5= '++' ( (lv_restVariableName_6_0= ruleIdentifier ) ) ) )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( ((LA63_0>=RULE_SIMPLE_ID && LA63_0<=RULE_ESCAPED_ID)||LA63_0==17||LA63_0==19||(LA63_0>=25 && LA63_0<=26)||(LA63_0>=29 && LA63_0<=30)||(LA63_0>=34 && LA63_0<=35)||(LA63_0>=37 && LA63_0<=40)) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // InternalQVTcore.g:3307:2: ( (lv_ownedParts_2_0= rulePatternExpCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= rulePatternExpCS ) ) )* (otherlv_5= '++' ( (lv_restVariableName_6_0= ruleIdentifier ) ) )
                    {
                    // InternalQVTcore.g:3307:2: ( (lv_ownedParts_2_0= rulePatternExpCS ) )
                    // InternalQVTcore.g:3308:1: (lv_ownedParts_2_0= rulePatternExpCS )
                    {
                    // InternalQVTcore.g:3308:1: (lv_ownedParts_2_0= rulePatternExpCS )
                    // InternalQVTcore.g:3309:3: lv_ownedParts_2_0= rulePatternExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionPatternCSAccess().getOwnedPartsPatternExpCSParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_46);
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

                    // InternalQVTcore.g:3325:2: (otherlv_3= ',' ( (lv_ownedParts_4_0= rulePatternExpCS ) ) )*
                    loop62:
                    do {
                        int alt62=2;
                        int LA62_0 = input.LA(1);

                        if ( (LA62_0==20) ) {
                            alt62=1;
                        }


                        switch (alt62) {
                    	case 1 :
                    	    // InternalQVTcore.g:3325:4: otherlv_3= ',' ( (lv_ownedParts_4_0= rulePatternExpCS ) )
                    	    {
                    	    otherlv_3=(Token)match(input,20,FollowSets000.FOLLOW_44); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getCollectionPatternCSAccess().getCommaKeyword_2_1_0());
                    	          
                    	    }
                    	    // InternalQVTcore.g:3329:1: ( (lv_ownedParts_4_0= rulePatternExpCS ) )
                    	    // InternalQVTcore.g:3330:1: (lv_ownedParts_4_0= rulePatternExpCS )
                    	    {
                    	    // InternalQVTcore.g:3330:1: (lv_ownedParts_4_0= rulePatternExpCS )
                    	    // InternalQVTcore.g:3331:3: lv_ownedParts_4_0= rulePatternExpCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getCollectionPatternCSAccess().getOwnedPartsPatternExpCSParserRuleCall_2_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_46);
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
                    	    break loop62;
                        }
                    } while (true);

                    // InternalQVTcore.g:3347:4: (otherlv_5= '++' ( (lv_restVariableName_6_0= ruleIdentifier ) ) )
                    // InternalQVTcore.g:3347:6: otherlv_5= '++' ( (lv_restVariableName_6_0= ruleIdentifier ) )
                    {
                    otherlv_5=(Token)match(input,75,FollowSets000.FOLLOW_47); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getCollectionPatternCSAccess().getPlusSignPlusSignKeyword_2_2_0());
                          
                    }
                    // InternalQVTcore.g:3351:1: ( (lv_restVariableName_6_0= ruleIdentifier ) )
                    // InternalQVTcore.g:3352:1: (lv_restVariableName_6_0= ruleIdentifier )
                    {
                    // InternalQVTcore.g:3352:1: (lv_restVariableName_6_0= ruleIdentifier )
                    // InternalQVTcore.g:3353:3: lv_restVariableName_6_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionPatternCSAccess().getRestVariableNameIdentifierParserRuleCall_2_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_18);
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

            otherlv_7=(Token)match(input,23,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
    // InternalQVTcore.g:3381:1: entryRuleShadowPartCS returns [EObject current=null] : iv_ruleShadowPartCS= ruleShadowPartCS EOF ;
    public final EObject entryRuleShadowPartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleShadowPartCS = null;


        try {
            // InternalQVTcore.g:3382:2: (iv_ruleShadowPartCS= ruleShadowPartCS EOF )
            // InternalQVTcore.g:3383:2: iv_ruleShadowPartCS= ruleShadowPartCS EOF
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
    // InternalQVTcore.g:3390:1: ruleShadowPartCS returns [EObject current=null] : ( ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( ( (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS ) ) ) ) ;
    public final EObject ruleShadowPartCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_ownedInitExpression_2_1 = null;

        EObject lv_ownedInitExpression_2_2 = null;


         enterRule(); 
            
        try {
            // InternalQVTcore.g:3393:28: ( ( ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( ( (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS ) ) ) ) )
            // InternalQVTcore.g:3394:1: ( ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( ( (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS ) ) ) )
            {
            // InternalQVTcore.g:3394:1: ( ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( ( (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS ) ) ) )
            // InternalQVTcore.g:3394:2: ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( ( (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS ) ) )
            {
            // InternalQVTcore.g:3394:2: ( ( ruleUnrestrictedName ) )
            // InternalQVTcore.g:3395:1: ( ruleUnrestrictedName )
            {
            // InternalQVTcore.g:3395:1: ( ruleUnrestrictedName )
            // InternalQVTcore.g:3396:3: ruleUnrestrictedName
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
               
              	        newCompositeNode(grammarAccess.getShadowPartCSAccess().getReferredPropertyPropertyCrossReference_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_48);
            ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,49,FollowSets000.FOLLOW_44); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getShadowPartCSAccess().getEqualsSignKeyword_1());
                  
            }
            // InternalQVTcore.g:3416:1: ( ( (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS ) ) )
            // InternalQVTcore.g:3417:1: ( (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS ) )
            {
            // InternalQVTcore.g:3417:1: ( (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS ) )
            // InternalQVTcore.g:3418:1: (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS )
            {
            // InternalQVTcore.g:3418:1: (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS )
            int alt64=2;
            alt64 = dfa64.predict(input);
            switch (alt64) {
                case 1 :
                    // InternalQVTcore.g:3419:3: lv_ownedInitExpression_2_1= ruleExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getShadowPartCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_0_0()); 
                      	    
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
                    // InternalQVTcore.g:3434:8: lv_ownedInitExpression_2_2= rulePatternExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getShadowPartCSAccess().getOwnedInitExpressionPatternExpCSParserRuleCall_2_0_1()); 
                      	    
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
    // InternalQVTcore.g:3460:1: entryRulePatternExpCS returns [EObject current=null] : iv_rulePatternExpCS= rulePatternExpCS EOF ;
    public final EObject entryRulePatternExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePatternExpCS = null;


        try {
            // InternalQVTcore.g:3461:2: (iv_rulePatternExpCS= rulePatternExpCS EOF )
            // InternalQVTcore.g:3462:2: iv_rulePatternExpCS= rulePatternExpCS EOF
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
    // InternalQVTcore.g:3469:1: rulePatternExpCS returns [EObject current=null] : ( ( (lv_patternVariableName_0_0= ruleUnrestrictedName ) )? otherlv_1= ':' ( (lv_ownedPatternType_2_0= ruleTypeExpCS ) ) ) ;
    public final EObject rulePatternExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_patternVariableName_0_0 = null;

        EObject lv_ownedPatternType_2_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTcore.g:3472:28: ( ( ( (lv_patternVariableName_0_0= ruleUnrestrictedName ) )? otherlv_1= ':' ( (lv_ownedPatternType_2_0= ruleTypeExpCS ) ) ) )
            // InternalQVTcore.g:3473:1: ( ( (lv_patternVariableName_0_0= ruleUnrestrictedName ) )? otherlv_1= ':' ( (lv_ownedPatternType_2_0= ruleTypeExpCS ) ) )
            {
            // InternalQVTcore.g:3473:1: ( ( (lv_patternVariableName_0_0= ruleUnrestrictedName ) )? otherlv_1= ':' ( (lv_ownedPatternType_2_0= ruleTypeExpCS ) ) )
            // InternalQVTcore.g:3473:2: ( (lv_patternVariableName_0_0= ruleUnrestrictedName ) )? otherlv_1= ':' ( (lv_ownedPatternType_2_0= ruleTypeExpCS ) )
            {
            // InternalQVTcore.g:3473:2: ( (lv_patternVariableName_0_0= ruleUnrestrictedName ) )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( ((LA65_0>=RULE_SIMPLE_ID && LA65_0<=RULE_ESCAPED_ID)||LA65_0==17||LA65_0==19||(LA65_0>=25 && LA65_0<=26)||LA65_0==30||(LA65_0>=34 && LA65_0<=35)||(LA65_0>=37 && LA65_0<=40)) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // InternalQVTcore.g:3474:1: (lv_patternVariableName_0_0= ruleUnrestrictedName )
                    {
                    // InternalQVTcore.g:3474:1: (lv_patternVariableName_0_0= ruleUnrestrictedName )
                    // InternalQVTcore.g:3475:3: lv_patternVariableName_0_0= ruleUnrestrictedName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPatternExpCSAccess().getPatternVariableNameUnrestrictedNameParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_25);
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
                              		"org.eclipse.qvtd.xtext.qvtcorebase.QVTcoreBase.UnrestrictedName");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,29,FollowSets000.FOLLOW_26); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getPatternExpCSAccess().getColonKeyword_1());
                  
            }
            // InternalQVTcore.g:3495:1: ( (lv_ownedPatternType_2_0= ruleTypeExpCS ) )
            // InternalQVTcore.g:3496:1: (lv_ownedPatternType_2_0= ruleTypeExpCS )
            {
            // InternalQVTcore.g:3496:1: (lv_ownedPatternType_2_0= ruleTypeExpCS )
            // InternalQVTcore.g:3497:3: lv_ownedPatternType_2_0= ruleTypeExpCS
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
    // InternalQVTcore.g:3521:1: entryRuleLambdaLiteralExpCS returns [EObject current=null] : iv_ruleLambdaLiteralExpCS= ruleLambdaLiteralExpCS EOF ;
    public final EObject entryRuleLambdaLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLambdaLiteralExpCS = null;


        try {
            // InternalQVTcore.g:3522:2: (iv_ruleLambdaLiteralExpCS= ruleLambdaLiteralExpCS EOF )
            // InternalQVTcore.g:3523:2: iv_ruleLambdaLiteralExpCS= ruleLambdaLiteralExpCS EOF
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
    // InternalQVTcore.g:3530:1: ruleLambdaLiteralExpCS returns [EObject current=null] : (otherlv_0= 'Lambda' otherlv_1= '{' ( (lv_ownedExpressionCS_2_0= ruleExpCS ) ) otherlv_3= '}' ) ;
    public final EObject ruleLambdaLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_ownedExpressionCS_2_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTcore.g:3533:28: ( (otherlv_0= 'Lambda' otherlv_1= '{' ( (lv_ownedExpressionCS_2_0= ruleExpCS ) ) otherlv_3= '}' ) )
            // InternalQVTcore.g:3534:1: (otherlv_0= 'Lambda' otherlv_1= '{' ( (lv_ownedExpressionCS_2_0= ruleExpCS ) ) otherlv_3= '}' )
            {
            // InternalQVTcore.g:3534:1: (otherlv_0= 'Lambda' otherlv_1= '{' ( (lv_ownedExpressionCS_2_0= ruleExpCS ) ) otherlv_3= '}' )
            // InternalQVTcore.g:3534:3: otherlv_0= 'Lambda' otherlv_1= '{' ( (lv_ownedExpressionCS_2_0= ruleExpCS ) ) otherlv_3= '}'
            {
            otherlv_0=(Token)match(input,76,FollowSets000.FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLambdaLiteralExpCSAccess().getLambdaKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,21,FollowSets000.FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getLambdaLiteralExpCSAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // InternalQVTcore.g:3542:1: ( (lv_ownedExpressionCS_2_0= ruleExpCS ) )
            // InternalQVTcore.g:3543:1: (lv_ownedExpressionCS_2_0= ruleExpCS )
            {
            // InternalQVTcore.g:3543:1: (lv_ownedExpressionCS_2_0= ruleExpCS )
            // InternalQVTcore.g:3544:3: lv_ownedExpressionCS_2_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLambdaLiteralExpCSAccess().getOwnedExpressionCSExpCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_18);
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

            otherlv_3=(Token)match(input,23,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
    // InternalQVTcore.g:3572:1: entryRuleMapLiteralExpCS returns [EObject current=null] : iv_ruleMapLiteralExpCS= ruleMapLiteralExpCS EOF ;
    public final EObject entryRuleMapLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMapLiteralExpCS = null;


        try {
            // InternalQVTcore.g:3573:2: (iv_ruleMapLiteralExpCS= ruleMapLiteralExpCS EOF )
            // InternalQVTcore.g:3574:2: iv_ruleMapLiteralExpCS= ruleMapLiteralExpCS EOF
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
    // InternalQVTcore.g:3581:1: ruleMapLiteralExpCS returns [EObject current=null] : ( ( (lv_ownedType_0_0= ruleMapTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleMapLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) ) )* )? otherlv_5= '}' ) ;
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
            // InternalQVTcore.g:3584:28: ( ( ( (lv_ownedType_0_0= ruleMapTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleMapLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) ) )* )? otherlv_5= '}' ) )
            // InternalQVTcore.g:3585:1: ( ( (lv_ownedType_0_0= ruleMapTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleMapLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) ) )* )? otherlv_5= '}' )
            {
            // InternalQVTcore.g:3585:1: ( ( (lv_ownedType_0_0= ruleMapTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleMapLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) ) )* )? otherlv_5= '}' )
            // InternalQVTcore.g:3585:2: ( (lv_ownedType_0_0= ruleMapTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleMapLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) ) )* )? otherlv_5= '}'
            {
            // InternalQVTcore.g:3585:2: ( (lv_ownedType_0_0= ruleMapTypeCS ) )
            // InternalQVTcore.g:3586:1: (lv_ownedType_0_0= ruleMapTypeCS )
            {
            // InternalQVTcore.g:3586:1: (lv_ownedType_0_0= ruleMapTypeCS )
            // InternalQVTcore.g:3587:3: lv_ownedType_0_0= ruleMapTypeCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMapLiteralExpCSAccess().getOwnedTypeMapTypeCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_31);
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

            otherlv_1=(Token)match(input,21,FollowSets000.FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getMapLiteralExpCSAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // InternalQVTcore.g:3607:1: ( ( (lv_ownedParts_2_0= ruleMapLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) ) )* )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( ((LA67_0>=RULE_SIMPLE_ID && LA67_0<=RULE_SINGLE_QUOTED_STRING)||LA67_0==17||LA67_0==19||(LA67_0>=25 && LA67_0<=27)||LA67_0==30||LA67_0==32||(LA67_0>=34 && LA67_0<=35)||(LA67_0>=37 && LA67_0<=42)||(LA67_0>=59 && LA67_0<=73)||LA67_0==76||(LA67_0>=78 && LA67_0<=81)||LA67_0==86||(LA67_0>=91 && LA67_0<=92)) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // InternalQVTcore.g:3607:2: ( (lv_ownedParts_2_0= ruleMapLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) ) )*
                    {
                    // InternalQVTcore.g:3607:2: ( (lv_ownedParts_2_0= ruleMapLiteralPartCS ) )
                    // InternalQVTcore.g:3608:1: (lv_ownedParts_2_0= ruleMapLiteralPartCS )
                    {
                    // InternalQVTcore.g:3608:1: (lv_ownedParts_2_0= ruleMapLiteralPartCS )
                    // InternalQVTcore.g:3609:3: lv_ownedParts_2_0= ruleMapLiteralPartCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMapLiteralExpCSAccess().getOwnedPartsMapLiteralPartCSParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_16);
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

                    // InternalQVTcore.g:3625:2: (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) ) )*
                    loop66:
                    do {
                        int alt66=2;
                        int LA66_0 = input.LA(1);

                        if ( (LA66_0==20) ) {
                            alt66=1;
                        }


                        switch (alt66) {
                    	case 1 :
                    	    // InternalQVTcore.g:3625:4: otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) )
                    	    {
                    	    otherlv_3=(Token)match(input,20,FollowSets000.FOLLOW_17); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getMapLiteralExpCSAccess().getCommaKeyword_2_1_0());
                    	          
                    	    }
                    	    // InternalQVTcore.g:3629:1: ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) )
                    	    // InternalQVTcore.g:3630:1: (lv_ownedParts_4_0= ruleMapLiteralPartCS )
                    	    {
                    	    // InternalQVTcore.g:3630:1: (lv_ownedParts_4_0= ruleMapLiteralPartCS )
                    	    // InternalQVTcore.g:3631:3: lv_ownedParts_4_0= ruleMapLiteralPartCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getMapLiteralExpCSAccess().getOwnedPartsMapLiteralPartCSParserRuleCall_2_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_16);
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
                    	    break loop66;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,23,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
    // InternalQVTcore.g:3659:1: entryRuleMapLiteralPartCS returns [EObject current=null] : iv_ruleMapLiteralPartCS= ruleMapLiteralPartCS EOF ;
    public final EObject entryRuleMapLiteralPartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMapLiteralPartCS = null;


        try {
            // InternalQVTcore.g:3660:2: (iv_ruleMapLiteralPartCS= ruleMapLiteralPartCS EOF )
            // InternalQVTcore.g:3661:2: iv_ruleMapLiteralPartCS= ruleMapLiteralPartCS EOF
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
    // InternalQVTcore.g:3668:1: ruleMapLiteralPartCS returns [EObject current=null] : ( ( (lv_ownedKey_0_0= ruleExpCS ) ) otherlv_1= '<-' ( (lv_ownedValue_2_0= ruleExpCS ) ) ) ;
    public final EObject ruleMapLiteralPartCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_ownedKey_0_0 = null;

        EObject lv_ownedValue_2_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTcore.g:3671:28: ( ( ( (lv_ownedKey_0_0= ruleExpCS ) ) otherlv_1= '<-' ( (lv_ownedValue_2_0= ruleExpCS ) ) ) )
            // InternalQVTcore.g:3672:1: ( ( (lv_ownedKey_0_0= ruleExpCS ) ) otherlv_1= '<-' ( (lv_ownedValue_2_0= ruleExpCS ) ) )
            {
            // InternalQVTcore.g:3672:1: ( ( (lv_ownedKey_0_0= ruleExpCS ) ) otherlv_1= '<-' ( (lv_ownedValue_2_0= ruleExpCS ) ) )
            // InternalQVTcore.g:3672:2: ( (lv_ownedKey_0_0= ruleExpCS ) ) otherlv_1= '<-' ( (lv_ownedValue_2_0= ruleExpCS ) )
            {
            // InternalQVTcore.g:3672:2: ( (lv_ownedKey_0_0= ruleExpCS ) )
            // InternalQVTcore.g:3673:1: (lv_ownedKey_0_0= ruleExpCS )
            {
            // InternalQVTcore.g:3673:1: (lv_ownedKey_0_0= ruleExpCS )
            // InternalQVTcore.g:3674:3: lv_ownedKey_0_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMapLiteralPartCSAccess().getOwnedKeyExpCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_49);
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

            otherlv_1=(Token)match(input,77,FollowSets000.FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getMapLiteralPartCSAccess().getLessThanSignHyphenMinusKeyword_1());
                  
            }
            // InternalQVTcore.g:3694:1: ( (lv_ownedValue_2_0= ruleExpCS ) )
            // InternalQVTcore.g:3695:1: (lv_ownedValue_2_0= ruleExpCS )
            {
            // InternalQVTcore.g:3695:1: (lv_ownedValue_2_0= ruleExpCS )
            // InternalQVTcore.g:3696:3: lv_ownedValue_2_0= ruleExpCS
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
    // InternalQVTcore.g:3720:1: entryRulePrimitiveLiteralExpCS returns [EObject current=null] : iv_rulePrimitiveLiteralExpCS= rulePrimitiveLiteralExpCS EOF ;
    public final EObject entryRulePrimitiveLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveLiteralExpCS = null;


        try {
            // InternalQVTcore.g:3721:2: (iv_rulePrimitiveLiteralExpCS= rulePrimitiveLiteralExpCS EOF )
            // InternalQVTcore.g:3722:2: iv_rulePrimitiveLiteralExpCS= rulePrimitiveLiteralExpCS EOF
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
    // InternalQVTcore.g:3729:1: rulePrimitiveLiteralExpCS returns [EObject current=null] : (this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS | this_StringLiteralExpCS_1= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_5= ruleNullLiteralExpCS ) ;
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
            // InternalQVTcore.g:3732:28: ( (this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS | this_StringLiteralExpCS_1= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_5= ruleNullLiteralExpCS ) )
            // InternalQVTcore.g:3733:1: (this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS | this_StringLiteralExpCS_1= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_5= ruleNullLiteralExpCS )
            {
            // InternalQVTcore.g:3733:1: (this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS | this_StringLiteralExpCS_1= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_5= ruleNullLiteralExpCS )
            int alt68=6;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt68=1;
                }
                break;
            case RULE_SINGLE_QUOTED_STRING:
                {
                alt68=2;
                }
                break;
            case 78:
            case 79:
                {
                alt68=3;
                }
                break;
            case 32:
                {
                alt68=4;
                }
                break;
            case 80:
                {
                alt68=5;
                }
                break;
            case 81:
                {
                alt68=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 68, 0, input);

                throw nvae;
            }

            switch (alt68) {
                case 1 :
                    // InternalQVTcore.g:3734:2: this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS
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
                    // InternalQVTcore.g:3747:2: this_StringLiteralExpCS_1= ruleStringLiteralExpCS
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
                    // InternalQVTcore.g:3760:2: this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS
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
                    // InternalQVTcore.g:3773:2: this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS
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
                    // InternalQVTcore.g:3786:2: this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS
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
                    // InternalQVTcore.g:3799:2: this_NullLiteralExpCS_5= ruleNullLiteralExpCS
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
    // InternalQVTcore.g:3818:1: entryRuleTupleLiteralExpCS returns [EObject current=null] : iv_ruleTupleLiteralExpCS= ruleTupleLiteralExpCS EOF ;
    public final EObject entryRuleTupleLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTupleLiteralExpCS = null;


        try {
            // InternalQVTcore.g:3819:2: (iv_ruleTupleLiteralExpCS= ruleTupleLiteralExpCS EOF )
            // InternalQVTcore.g:3820:2: iv_ruleTupleLiteralExpCS= ruleTupleLiteralExpCS EOF
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
    // InternalQVTcore.g:3827:1: ruleTupleLiteralExpCS returns [EObject current=null] : (otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}' ) ;
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
            // InternalQVTcore.g:3830:28: ( (otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}' ) )
            // InternalQVTcore.g:3831:1: (otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}' )
            {
            // InternalQVTcore.g:3831:1: (otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}' )
            // InternalQVTcore.g:3831:3: otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,60,FollowSets000.FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getTupleLiteralExpCSAccess().getTupleKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,21,FollowSets000.FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getTupleLiteralExpCSAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // InternalQVTcore.g:3839:1: ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) )
            // InternalQVTcore.g:3840:1: (lv_ownedParts_2_0= ruleTupleLiteralPartCS )
            {
            // InternalQVTcore.g:3840:1: (lv_ownedParts_2_0= ruleTupleLiteralPartCS )
            // InternalQVTcore.g:3841:3: lv_ownedParts_2_0= ruleTupleLiteralPartCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTupleLiteralExpCSAccess().getOwnedPartsTupleLiteralPartCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_16);
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

            // InternalQVTcore.g:3857:2: (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )*
            loop69:
            do {
                int alt69=2;
                int LA69_0 = input.LA(1);

                if ( (LA69_0==20) ) {
                    alt69=1;
                }


                switch (alt69) {
            	case 1 :
            	    // InternalQVTcore.g:3857:4: otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) )
            	    {
            	    otherlv_3=(Token)match(input,20,FollowSets000.FOLLOW_8); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getTupleLiteralExpCSAccess().getCommaKeyword_3_0());
            	          
            	    }
            	    // InternalQVTcore.g:3861:1: ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) )
            	    // InternalQVTcore.g:3862:1: (lv_ownedParts_4_0= ruleTupleLiteralPartCS )
            	    {
            	    // InternalQVTcore.g:3862:1: (lv_ownedParts_4_0= ruleTupleLiteralPartCS )
            	    // InternalQVTcore.g:3863:3: lv_ownedParts_4_0= ruleTupleLiteralPartCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTupleLiteralExpCSAccess().getOwnedPartsTupleLiteralPartCSParserRuleCall_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_16);
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
            	    break loop69;
                }
            } while (true);

            otherlv_5=(Token)match(input,23,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
    // InternalQVTcore.g:3891:1: entryRuleTupleLiteralPartCS returns [EObject current=null] : iv_ruleTupleLiteralPartCS= ruleTupleLiteralPartCS EOF ;
    public final EObject entryRuleTupleLiteralPartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTupleLiteralPartCS = null;


        try {
            // InternalQVTcore.g:3892:2: (iv_ruleTupleLiteralPartCS= ruleTupleLiteralPartCS EOF )
            // InternalQVTcore.g:3893:2: iv_ruleTupleLiteralPartCS= ruleTupleLiteralPartCS EOF
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
    // InternalQVTcore.g:3900:1: ruleTupleLiteralPartCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) ) ;
    public final EObject ruleTupleLiteralPartCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;

        EObject lv_ownedInitExpression_4_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTcore.g:3903:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) ) )
            // InternalQVTcore.g:3904:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )
            {
            // InternalQVTcore.g:3904:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )
            // InternalQVTcore.g:3904:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) )
            {
            // InternalQVTcore.g:3904:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // InternalQVTcore.g:3905:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // InternalQVTcore.g:3905:1: (lv_name_0_0= ruleUnrestrictedName )
            // InternalQVTcore.g:3906:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTupleLiteralPartCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_50);
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
                      		"org.eclipse.qvtd.xtext.qvtcorebase.QVTcoreBase.UnrestrictedName");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalQVTcore.g:3922:2: (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==29) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // InternalQVTcore.g:3922:4: otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                    {
                    otherlv_1=(Token)match(input,29,FollowSets000.FOLLOW_26); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getTupleLiteralPartCSAccess().getColonKeyword_1_0());
                          
                    }
                    // InternalQVTcore.g:3926:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                    // InternalQVTcore.g:3927:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    {
                    // InternalQVTcore.g:3927:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    // InternalQVTcore.g:3928:3: lv_ownedType_2_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTupleLiteralPartCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_48);
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

            otherlv_3=(Token)match(input,49,FollowSets000.FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getTupleLiteralPartCSAccess().getEqualsSignKeyword_2());
                  
            }
            // InternalQVTcore.g:3948:1: ( (lv_ownedInitExpression_4_0= ruleExpCS ) )
            // InternalQVTcore.g:3949:1: (lv_ownedInitExpression_4_0= ruleExpCS )
            {
            // InternalQVTcore.g:3949:1: (lv_ownedInitExpression_4_0= ruleExpCS )
            // InternalQVTcore.g:3950:3: lv_ownedInitExpression_4_0= ruleExpCS
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
    // InternalQVTcore.g:3974:1: entryRuleNumberLiteralExpCS returns [EObject current=null] : iv_ruleNumberLiteralExpCS= ruleNumberLiteralExpCS EOF ;
    public final EObject entryRuleNumberLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberLiteralExpCS = null;


        try {
            // InternalQVTcore.g:3975:2: (iv_ruleNumberLiteralExpCS= ruleNumberLiteralExpCS EOF )
            // InternalQVTcore.g:3976:2: iv_ruleNumberLiteralExpCS= ruleNumberLiteralExpCS EOF
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
    // InternalQVTcore.g:3983:1: ruleNumberLiteralExpCS returns [EObject current=null] : ( (lv_symbol_0_0= ruleNUMBER_LITERAL ) ) ;
    public final EObject ruleNumberLiteralExpCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_symbol_0_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTcore.g:3986:28: ( ( (lv_symbol_0_0= ruleNUMBER_LITERAL ) ) )
            // InternalQVTcore.g:3987:1: ( (lv_symbol_0_0= ruleNUMBER_LITERAL ) )
            {
            // InternalQVTcore.g:3987:1: ( (lv_symbol_0_0= ruleNUMBER_LITERAL ) )
            // InternalQVTcore.g:3988:1: (lv_symbol_0_0= ruleNUMBER_LITERAL )
            {
            // InternalQVTcore.g:3988:1: (lv_symbol_0_0= ruleNUMBER_LITERAL )
            // InternalQVTcore.g:3989:3: lv_symbol_0_0= ruleNUMBER_LITERAL
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
    // InternalQVTcore.g:4013:1: entryRuleStringLiteralExpCS returns [EObject current=null] : iv_ruleStringLiteralExpCS= ruleStringLiteralExpCS EOF ;
    public final EObject entryRuleStringLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteralExpCS = null;


        try {
            // InternalQVTcore.g:4014:2: (iv_ruleStringLiteralExpCS= ruleStringLiteralExpCS EOF )
            // InternalQVTcore.g:4015:2: iv_ruleStringLiteralExpCS= ruleStringLiteralExpCS EOF
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
    // InternalQVTcore.g:4022:1: ruleStringLiteralExpCS returns [EObject current=null] : ( (lv_segments_0_0= ruleStringLiteral ) )+ ;
    public final EObject ruleStringLiteralExpCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_segments_0_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTcore.g:4025:28: ( ( (lv_segments_0_0= ruleStringLiteral ) )+ )
            // InternalQVTcore.g:4026:1: ( (lv_segments_0_0= ruleStringLiteral ) )+
            {
            // InternalQVTcore.g:4026:1: ( (lv_segments_0_0= ruleStringLiteral ) )+
            int cnt71=0;
            loop71:
            do {
                int alt71=2;
                int LA71_0 = input.LA(1);

                if ( (LA71_0==RULE_SINGLE_QUOTED_STRING) ) {
                    alt71=1;
                }


                switch (alt71) {
            	case 1 :
            	    // InternalQVTcore.g:4027:1: (lv_segments_0_0= ruleStringLiteral )
            	    {
            	    // InternalQVTcore.g:4027:1: (lv_segments_0_0= ruleStringLiteral )
            	    // InternalQVTcore.g:4028:3: lv_segments_0_0= ruleStringLiteral
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getStringLiteralExpCSAccess().getSegmentsStringLiteralParserRuleCall_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_51);
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
            	    if ( cnt71 >= 1 ) break loop71;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(71, input);
                        throw eee;
                }
                cnt71++;
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
    // InternalQVTcore.g:4052:1: entryRuleBooleanLiteralExpCS returns [EObject current=null] : iv_ruleBooleanLiteralExpCS= ruleBooleanLiteralExpCS EOF ;
    public final EObject entryRuleBooleanLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteralExpCS = null;


        try {
            // InternalQVTcore.g:4053:2: (iv_ruleBooleanLiteralExpCS= ruleBooleanLiteralExpCS EOF )
            // InternalQVTcore.g:4054:2: iv_ruleBooleanLiteralExpCS= ruleBooleanLiteralExpCS EOF
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
    // InternalQVTcore.g:4061:1: ruleBooleanLiteralExpCS returns [EObject current=null] : ( ( (lv_symbol_0_0= 'true' ) ) | ( (lv_symbol_1_0= 'false' ) ) ) ;
    public final EObject ruleBooleanLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token lv_symbol_0_0=null;
        Token lv_symbol_1_0=null;

         enterRule(); 
            
        try {
            // InternalQVTcore.g:4064:28: ( ( ( (lv_symbol_0_0= 'true' ) ) | ( (lv_symbol_1_0= 'false' ) ) ) )
            // InternalQVTcore.g:4065:1: ( ( (lv_symbol_0_0= 'true' ) ) | ( (lv_symbol_1_0= 'false' ) ) )
            {
            // InternalQVTcore.g:4065:1: ( ( (lv_symbol_0_0= 'true' ) ) | ( (lv_symbol_1_0= 'false' ) ) )
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==78) ) {
                alt72=1;
            }
            else if ( (LA72_0==79) ) {
                alt72=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 72, 0, input);

                throw nvae;
            }
            switch (alt72) {
                case 1 :
                    // InternalQVTcore.g:4065:2: ( (lv_symbol_0_0= 'true' ) )
                    {
                    // InternalQVTcore.g:4065:2: ( (lv_symbol_0_0= 'true' ) )
                    // InternalQVTcore.g:4066:1: (lv_symbol_0_0= 'true' )
                    {
                    // InternalQVTcore.g:4066:1: (lv_symbol_0_0= 'true' )
                    // InternalQVTcore.g:4067:3: lv_symbol_0_0= 'true'
                    {
                    lv_symbol_0_0=(Token)match(input,78,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
                    // InternalQVTcore.g:4081:6: ( (lv_symbol_1_0= 'false' ) )
                    {
                    // InternalQVTcore.g:4081:6: ( (lv_symbol_1_0= 'false' ) )
                    // InternalQVTcore.g:4082:1: (lv_symbol_1_0= 'false' )
                    {
                    // InternalQVTcore.g:4082:1: (lv_symbol_1_0= 'false' )
                    // InternalQVTcore.g:4083:3: lv_symbol_1_0= 'false'
                    {
                    lv_symbol_1_0=(Token)match(input,79,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
    // InternalQVTcore.g:4104:1: entryRuleUnlimitedNaturalLiteralExpCS returns [EObject current=null] : iv_ruleUnlimitedNaturalLiteralExpCS= ruleUnlimitedNaturalLiteralExpCS EOF ;
    public final EObject entryRuleUnlimitedNaturalLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnlimitedNaturalLiteralExpCS = null;


        try {
            // InternalQVTcore.g:4105:2: (iv_ruleUnlimitedNaturalLiteralExpCS= ruleUnlimitedNaturalLiteralExpCS EOF )
            // InternalQVTcore.g:4106:2: iv_ruleUnlimitedNaturalLiteralExpCS= ruleUnlimitedNaturalLiteralExpCS EOF
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
    // InternalQVTcore.g:4113:1: ruleUnlimitedNaturalLiteralExpCS returns [EObject current=null] : ( () otherlv_1= '*' ) ;
    public final EObject ruleUnlimitedNaturalLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // InternalQVTcore.g:4116:28: ( ( () otherlv_1= '*' ) )
            // InternalQVTcore.g:4117:1: ( () otherlv_1= '*' )
            {
            // InternalQVTcore.g:4117:1: ( () otherlv_1= '*' )
            // InternalQVTcore.g:4117:2: () otherlv_1= '*'
            {
            // InternalQVTcore.g:4117:2: ()
            // InternalQVTcore.g:4118:2: 
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

            otherlv_1=(Token)match(input,32,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
    // InternalQVTcore.g:4138:1: entryRuleInvalidLiteralExpCS returns [EObject current=null] : iv_ruleInvalidLiteralExpCS= ruleInvalidLiteralExpCS EOF ;
    public final EObject entryRuleInvalidLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInvalidLiteralExpCS = null;


        try {
            // InternalQVTcore.g:4139:2: (iv_ruleInvalidLiteralExpCS= ruleInvalidLiteralExpCS EOF )
            // InternalQVTcore.g:4140:2: iv_ruleInvalidLiteralExpCS= ruleInvalidLiteralExpCS EOF
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
    // InternalQVTcore.g:4147:1: ruleInvalidLiteralExpCS returns [EObject current=null] : ( () otherlv_1= 'invalid' ) ;
    public final EObject ruleInvalidLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // InternalQVTcore.g:4150:28: ( ( () otherlv_1= 'invalid' ) )
            // InternalQVTcore.g:4151:1: ( () otherlv_1= 'invalid' )
            {
            // InternalQVTcore.g:4151:1: ( () otherlv_1= 'invalid' )
            // InternalQVTcore.g:4151:2: () otherlv_1= 'invalid'
            {
            // InternalQVTcore.g:4151:2: ()
            // InternalQVTcore.g:4152:2: 
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

            otherlv_1=(Token)match(input,80,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
    // InternalQVTcore.g:4172:1: entryRuleNullLiteralExpCS returns [EObject current=null] : iv_ruleNullLiteralExpCS= ruleNullLiteralExpCS EOF ;
    public final EObject entryRuleNullLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullLiteralExpCS = null;


        try {
            // InternalQVTcore.g:4173:2: (iv_ruleNullLiteralExpCS= ruleNullLiteralExpCS EOF )
            // InternalQVTcore.g:4174:2: iv_ruleNullLiteralExpCS= ruleNullLiteralExpCS EOF
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
    // InternalQVTcore.g:4181:1: ruleNullLiteralExpCS returns [EObject current=null] : ( () otherlv_1= 'null' ) ;
    public final EObject ruleNullLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // InternalQVTcore.g:4184:28: ( ( () otherlv_1= 'null' ) )
            // InternalQVTcore.g:4185:1: ( () otherlv_1= 'null' )
            {
            // InternalQVTcore.g:4185:1: ( () otherlv_1= 'null' )
            // InternalQVTcore.g:4185:2: () otherlv_1= 'null'
            {
            // InternalQVTcore.g:4185:2: ()
            // InternalQVTcore.g:4186:2: 
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

            otherlv_1=(Token)match(input,81,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
    // InternalQVTcore.g:4206:1: entryRuleTypeLiteralCS returns [EObject current=null] : iv_ruleTypeLiteralCS= ruleTypeLiteralCS EOF ;
    public final EObject entryRuleTypeLiteralCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeLiteralCS = null;


        try {
            // InternalQVTcore.g:4207:2: (iv_ruleTypeLiteralCS= ruleTypeLiteralCS EOF )
            // InternalQVTcore.g:4208:2: iv_ruleTypeLiteralCS= ruleTypeLiteralCS EOF
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
    // InternalQVTcore.g:4215:1: ruleTypeLiteralCS returns [EObject current=null] : (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS | this_CollectionTypeCS_1= ruleCollectionTypeCS | this_MapTypeCS_2= ruleMapTypeCS | this_TupleTypeCS_3= ruleTupleTypeCS ) ;
    public final EObject ruleTypeLiteralCS() throws RecognitionException {
        EObject current = null;

        EObject this_PrimitiveTypeCS_0 = null;

        EObject this_CollectionTypeCS_1 = null;

        EObject this_MapTypeCS_2 = null;

        EObject this_TupleTypeCS_3 = null;


         enterRule(); 
            
        try {
            // InternalQVTcore.g:4218:28: ( (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS | this_CollectionTypeCS_1= ruleCollectionTypeCS | this_MapTypeCS_2= ruleMapTypeCS | this_TupleTypeCS_3= ruleTupleTypeCS ) )
            // InternalQVTcore.g:4219:1: (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS | this_CollectionTypeCS_1= ruleCollectionTypeCS | this_MapTypeCS_2= ruleMapTypeCS | this_TupleTypeCS_3= ruleTupleTypeCS )
            {
            // InternalQVTcore.g:4219:1: (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS | this_CollectionTypeCS_1= ruleCollectionTypeCS | this_MapTypeCS_2= ruleMapTypeCS | this_TupleTypeCS_3= ruleTupleTypeCS )
            int alt73=4;
            switch ( input.LA(1) ) {
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
                {
                alt73=1;
                }
                break;
            case 69:
            case 70:
            case 71:
            case 72:
            case 73:
                {
                alt73=2;
                }
                break;
            case 59:
                {
                alt73=3;
                }
                break;
            case 60:
                {
                alt73=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 73, 0, input);

                throw nvae;
            }

            switch (alt73) {
                case 1 :
                    // InternalQVTcore.g:4220:2: this_PrimitiveTypeCS_0= rulePrimitiveTypeCS
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
                    // InternalQVTcore.g:4233:2: this_CollectionTypeCS_1= ruleCollectionTypeCS
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
                    // InternalQVTcore.g:4246:2: this_MapTypeCS_2= ruleMapTypeCS
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
                    // InternalQVTcore.g:4259:2: this_TupleTypeCS_3= ruleTupleTypeCS
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
    // InternalQVTcore.g:4278:1: entryRuleTypeLiteralWithMultiplicityCS returns [EObject current=null] : iv_ruleTypeLiteralWithMultiplicityCS= ruleTypeLiteralWithMultiplicityCS EOF ;
    public final EObject entryRuleTypeLiteralWithMultiplicityCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeLiteralWithMultiplicityCS = null;


        try {
            // InternalQVTcore.g:4279:2: (iv_ruleTypeLiteralWithMultiplicityCS= ruleTypeLiteralWithMultiplicityCS EOF )
            // InternalQVTcore.g:4280:2: iv_ruleTypeLiteralWithMultiplicityCS= ruleTypeLiteralWithMultiplicityCS EOF
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
    // InternalQVTcore.g:4287:1: ruleTypeLiteralWithMultiplicityCS returns [EObject current=null] : (this_TypeLiteralCS_0= ruleTypeLiteralCS ( (lv_ownedMultiplicity_1_0= ruleMultiplicityCS ) )? ) ;
    public final EObject ruleTypeLiteralWithMultiplicityCS() throws RecognitionException {
        EObject current = null;

        EObject this_TypeLiteralCS_0 = null;

        EObject lv_ownedMultiplicity_1_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTcore.g:4290:28: ( (this_TypeLiteralCS_0= ruleTypeLiteralCS ( (lv_ownedMultiplicity_1_0= ruleMultiplicityCS ) )? ) )
            // InternalQVTcore.g:4291:1: (this_TypeLiteralCS_0= ruleTypeLiteralCS ( (lv_ownedMultiplicity_1_0= ruleMultiplicityCS ) )? )
            {
            // InternalQVTcore.g:4291:1: (this_TypeLiteralCS_0= ruleTypeLiteralCS ( (lv_ownedMultiplicity_1_0= ruleMultiplicityCS ) )? )
            // InternalQVTcore.g:4292:2: this_TypeLiteralCS_0= ruleTypeLiteralCS ( (lv_ownedMultiplicity_1_0= ruleMultiplicityCS ) )?
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getTypeLiteralWithMultiplicityCSAccess().getTypeLiteralCSParserRuleCall_0()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_52);
            this_TypeLiteralCS_0=ruleTypeLiteralCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_TypeLiteralCS_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalQVTcore.g:4303:1: ( (lv_ownedMultiplicity_1_0= ruleMultiplicityCS ) )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==84) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // InternalQVTcore.g:4304:1: (lv_ownedMultiplicity_1_0= ruleMultiplicityCS )
                    {
                    // InternalQVTcore.g:4304:1: (lv_ownedMultiplicity_1_0= ruleMultiplicityCS )
                    // InternalQVTcore.g:4305:3: lv_ownedMultiplicity_1_0= ruleMultiplicityCS
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
    // InternalQVTcore.g:4329:1: entryRuleTypeLiteralExpCS returns [EObject current=null] : iv_ruleTypeLiteralExpCS= ruleTypeLiteralExpCS EOF ;
    public final EObject entryRuleTypeLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeLiteralExpCS = null;


        try {
            // InternalQVTcore.g:4330:2: (iv_ruleTypeLiteralExpCS= ruleTypeLiteralExpCS EOF )
            // InternalQVTcore.g:4331:2: iv_ruleTypeLiteralExpCS= ruleTypeLiteralExpCS EOF
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
    // InternalQVTcore.g:4338:1: ruleTypeLiteralExpCS returns [EObject current=null] : ( (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS ) ) ;
    public final EObject ruleTypeLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject lv_ownedType_0_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTcore.g:4341:28: ( ( (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS ) ) )
            // InternalQVTcore.g:4342:1: ( (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS ) )
            {
            // InternalQVTcore.g:4342:1: ( (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS ) )
            // InternalQVTcore.g:4343:1: (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS )
            {
            // InternalQVTcore.g:4343:1: (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS )
            // InternalQVTcore.g:4344:3: lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS
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
    // InternalQVTcore.g:4368:1: entryRuleTypeNameExpCS returns [EObject current=null] : iv_ruleTypeNameExpCS= ruleTypeNameExpCS EOF ;
    public final EObject entryRuleTypeNameExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeNameExpCS = null;


        try {
            // InternalQVTcore.g:4369:2: (iv_ruleTypeNameExpCS= ruleTypeNameExpCS EOF )
            // InternalQVTcore.g:4370:2: iv_ruleTypeNameExpCS= ruleTypeNameExpCS EOF
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
    // InternalQVTcore.g:4377:1: ruleTypeNameExpCS returns [EObject current=null] : ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( ( (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS ) ) (otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}' )? )? ) ;
    public final EObject ruleTypeNameExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_ownedPathName_0_0 = null;

        EObject lv_ownedCurlyBracketedClause_1_0 = null;

        EObject lv_ownedPatternGuard_3_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTcore.g:4380:28: ( ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( ( (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS ) ) (otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}' )? )? ) )
            // InternalQVTcore.g:4381:1: ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( ( (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS ) ) (otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}' )? )? )
            {
            // InternalQVTcore.g:4381:1: ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( ( (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS ) ) (otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}' )? )? )
            // InternalQVTcore.g:4381:2: ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( ( (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS ) ) (otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}' )? )?
            {
            // InternalQVTcore.g:4381:2: ( (lv_ownedPathName_0_0= rulePathNameCS ) )
            // InternalQVTcore.g:4382:1: (lv_ownedPathName_0_0= rulePathNameCS )
            {
            // InternalQVTcore.g:4382:1: (lv_ownedPathName_0_0= rulePathNameCS )
            // InternalQVTcore.g:4383:3: lv_ownedPathName_0_0= rulePathNameCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypeNameExpCSAccess().getOwnedPathNamePathNameCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_53);
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

            // InternalQVTcore.g:4399:2: ( ( (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS ) ) (otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}' )? )?
            int alt76=2;
            alt76 = dfa76.predict(input);
            switch (alt76) {
                case 1 :
                    // InternalQVTcore.g:4399:3: ( (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS ) ) (otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}' )?
                    {
                    // InternalQVTcore.g:4399:3: ( (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS ) )
                    // InternalQVTcore.g:4400:1: (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS )
                    {
                    // InternalQVTcore.g:4400:1: (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS )
                    // InternalQVTcore.g:4401:3: lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeNameExpCSAccess().getOwnedCurlyBracketedClauseCurlyBracketedClauseCSParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_53);
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

                    // InternalQVTcore.g:4417:2: (otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}' )?
                    int alt75=2;
                    alt75 = dfa75.predict(input);
                    switch (alt75) {
                        case 1 :
                            // InternalQVTcore.g:4417:4: otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}'
                            {
                            otherlv_2=(Token)match(input,21,FollowSets000.FOLLOW_17); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_2, grammarAccess.getTypeNameExpCSAccess().getLeftCurlyBracketKeyword_1_1_0());
                                  
                            }
                            // InternalQVTcore.g:4421:1: ( (lv_ownedPatternGuard_3_0= ruleExpCS ) )
                            // InternalQVTcore.g:4422:1: (lv_ownedPatternGuard_3_0= ruleExpCS )
                            {
                            // InternalQVTcore.g:4422:1: (lv_ownedPatternGuard_3_0= ruleExpCS )
                            // InternalQVTcore.g:4423:3: lv_ownedPatternGuard_3_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getTypeNameExpCSAccess().getOwnedPatternGuardExpCSParserRuleCall_1_1_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_18);
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

                            otherlv_4=(Token)match(input,23,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
    // InternalQVTcore.g:4451:1: entryRuleTypeExpCS returns [EObject current=null] : iv_ruleTypeExpCS= ruleTypeExpCS EOF ;
    public final EObject entryRuleTypeExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeExpCS = null;


        try {
            // InternalQVTcore.g:4452:2: (iv_ruleTypeExpCS= ruleTypeExpCS EOF )
            // InternalQVTcore.g:4453:2: iv_ruleTypeExpCS= ruleTypeExpCS EOF
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
    // InternalQVTcore.g:4460:1: ruleTypeExpCS returns [EObject current=null] : ( (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS | this_CollectionPatternCS_2= ruleCollectionPatternCS ) ( (lv_ownedMultiplicity_3_0= ruleMultiplicityCS ) )? ) ;
    public final EObject ruleTypeExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_TypeNameExpCS_0 = null;

        EObject this_TypeLiteralCS_1 = null;

        EObject this_CollectionPatternCS_2 = null;

        EObject lv_ownedMultiplicity_3_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTcore.g:4463:28: ( ( (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS | this_CollectionPatternCS_2= ruleCollectionPatternCS ) ( (lv_ownedMultiplicity_3_0= ruleMultiplicityCS ) )? ) )
            // InternalQVTcore.g:4464:1: ( (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS | this_CollectionPatternCS_2= ruleCollectionPatternCS ) ( (lv_ownedMultiplicity_3_0= ruleMultiplicityCS ) )? )
            {
            // InternalQVTcore.g:4464:1: ( (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS | this_CollectionPatternCS_2= ruleCollectionPatternCS ) ( (lv_ownedMultiplicity_3_0= ruleMultiplicityCS ) )? )
            // InternalQVTcore.g:4464:2: (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS | this_CollectionPatternCS_2= ruleCollectionPatternCS ) ( (lv_ownedMultiplicity_3_0= ruleMultiplicityCS ) )?
            {
            // InternalQVTcore.g:4464:2: (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS | this_CollectionPatternCS_2= ruleCollectionPatternCS )
            int alt77=3;
            alt77 = dfa77.predict(input);
            switch (alt77) {
                case 1 :
                    // InternalQVTcore.g:4465:2: this_TypeNameExpCS_0= ruleTypeNameExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeExpCSAccess().getTypeNameExpCSParserRuleCall_0_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_52);
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
                    // InternalQVTcore.g:4478:2: this_TypeLiteralCS_1= ruleTypeLiteralCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeExpCSAccess().getTypeLiteralCSParserRuleCall_0_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_52);
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
                    // InternalQVTcore.g:4491:2: this_CollectionPatternCS_2= ruleCollectionPatternCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeExpCSAccess().getCollectionPatternCSParserRuleCall_0_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_52);
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

            // InternalQVTcore.g:4502:2: ( (lv_ownedMultiplicity_3_0= ruleMultiplicityCS ) )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==84) ) {
                alt78=1;
            }
            switch (alt78) {
                case 1 :
                    // InternalQVTcore.g:4503:1: (lv_ownedMultiplicity_3_0= ruleMultiplicityCS )
                    {
                    // InternalQVTcore.g:4503:1: (lv_ownedMultiplicity_3_0= ruleMultiplicityCS )
                    // InternalQVTcore.g:4504:3: lv_ownedMultiplicity_3_0= ruleMultiplicityCS
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
    // InternalQVTcore.g:4528:1: entryRuleExpCS returns [EObject current=null] : iv_ruleExpCS= ruleExpCS EOF ;
    public final EObject entryRuleExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpCS = null;


        try {
            // InternalQVTcore.g:4529:2: (iv_ruleExpCS= ruleExpCS EOF )
            // InternalQVTcore.g:4530:2: iv_ruleExpCS= ruleExpCS EOF
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
    // InternalQVTcore.g:4537:1: ruleExpCS returns [EObject current=null] : ( (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? ) | this_PrefixedLetExpCS_4= rulePrefixedLetExpCS ) ;
    public final EObject ruleExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_PrefixedPrimaryExpCS_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_ownedRight_3_0 = null;

        EObject this_PrefixedLetExpCS_4 = null;


         enterRule(); 
            
        try {
            // InternalQVTcore.g:4540:28: ( ( (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? ) | this_PrefixedLetExpCS_4= rulePrefixedLetExpCS ) )
            // InternalQVTcore.g:4541:1: ( (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? ) | this_PrefixedLetExpCS_4= rulePrefixedLetExpCS )
            {
            // InternalQVTcore.g:4541:1: ( (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? ) | this_PrefixedLetExpCS_4= rulePrefixedLetExpCS )
            int alt80=2;
            alt80 = dfa80.predict(input);
            switch (alt80) {
                case 1 :
                    // InternalQVTcore.g:4541:2: (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? )
                    {
                    // InternalQVTcore.g:4541:2: (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? )
                    // InternalQVTcore.g:4542:2: this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )?
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getExpCSAccess().getPrefixedPrimaryExpCSParserRuleCall_0_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_54);
                    this_PrefixedPrimaryExpCS_0=rulePrefixedPrimaryExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_PrefixedPrimaryExpCS_0; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    // InternalQVTcore.g:4553:1: ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )?
                    int alt79=2;
                    int LA79_0 = input.LA(1);

                    if ( (LA79_0==32||LA79_0==41||(LA79_0>=43 && LA79_0<=58)) ) {
                        alt79=1;
                    }
                    switch (alt79) {
                        case 1 :
                            // InternalQVTcore.g:4553:2: () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) )
                            {
                            // InternalQVTcore.g:4553:2: ()
                            // InternalQVTcore.g:4554:2: 
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

                            // InternalQVTcore.g:4562:2: ( (lv_name_2_0= ruleBinaryOperatorName ) )
                            // InternalQVTcore.g:4563:1: (lv_name_2_0= ruleBinaryOperatorName )
                            {
                            // InternalQVTcore.g:4563:1: (lv_name_2_0= ruleBinaryOperatorName )
                            // InternalQVTcore.g:4564:3: lv_name_2_0= ruleBinaryOperatorName
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getExpCSAccess().getNameBinaryOperatorNameParserRuleCall_0_1_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_17);
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

                            // InternalQVTcore.g:4580:2: ( (lv_ownedRight_3_0= ruleExpCS ) )
                            // InternalQVTcore.g:4581:1: (lv_ownedRight_3_0= ruleExpCS )
                            {
                            // InternalQVTcore.g:4581:1: (lv_ownedRight_3_0= ruleExpCS )
                            // InternalQVTcore.g:4582:3: lv_ownedRight_3_0= ruleExpCS
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
                    // InternalQVTcore.g:4600:2: this_PrefixedLetExpCS_4= rulePrefixedLetExpCS
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
    // InternalQVTcore.g:4619:1: entryRulePrefixedLetExpCS returns [EObject current=null] : iv_rulePrefixedLetExpCS= rulePrefixedLetExpCS EOF ;
    public final EObject entryRulePrefixedLetExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrefixedLetExpCS = null;


        try {
            // InternalQVTcore.g:4620:2: (iv_rulePrefixedLetExpCS= rulePrefixedLetExpCS EOF )
            // InternalQVTcore.g:4621:2: iv_rulePrefixedLetExpCS= rulePrefixedLetExpCS EOF
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
    // InternalQVTcore.g:4628:1: rulePrefixedLetExpCS returns [EObject current=null] : ( ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedLetExpCS ) ) ) | this_LetExpCS_3= ruleLetExpCS ) ;
    public final EObject rulePrefixedLetExpCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_ownedRight_2_0 = null;

        EObject this_LetExpCS_3 = null;


         enterRule(); 
            
        try {
            // InternalQVTcore.g:4631:28: ( ( ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedLetExpCS ) ) ) | this_LetExpCS_3= ruleLetExpCS ) )
            // InternalQVTcore.g:4632:1: ( ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedLetExpCS ) ) ) | this_LetExpCS_3= ruleLetExpCS )
            {
            // InternalQVTcore.g:4632:1: ( ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedLetExpCS ) ) ) | this_LetExpCS_3= ruleLetExpCS )
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( ((LA81_0>=41 && LA81_0<=42)) ) {
                alt81=1;
            }
            else if ( (LA81_0==91) ) {
                alt81=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 81, 0, input);

                throw nvae;
            }
            switch (alt81) {
                case 1 :
                    // InternalQVTcore.g:4632:2: ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedLetExpCS ) ) )
                    {
                    // InternalQVTcore.g:4632:2: ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedLetExpCS ) ) )
                    // InternalQVTcore.g:4632:3: () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedLetExpCS ) )
                    {
                    // InternalQVTcore.g:4632:3: ()
                    // InternalQVTcore.g:4633:2: 
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

                    // InternalQVTcore.g:4641:2: ( (lv_name_1_0= ruleUnaryOperatorName ) )
                    // InternalQVTcore.g:4642:1: (lv_name_1_0= ruleUnaryOperatorName )
                    {
                    // InternalQVTcore.g:4642:1: (lv_name_1_0= ruleUnaryOperatorName )
                    // InternalQVTcore.g:4643:3: lv_name_1_0= ruleUnaryOperatorName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrefixedLetExpCSAccess().getNameUnaryOperatorNameParserRuleCall_0_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_17);
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

                    // InternalQVTcore.g:4659:2: ( (lv_ownedRight_2_0= rulePrefixedLetExpCS ) )
                    // InternalQVTcore.g:4660:1: (lv_ownedRight_2_0= rulePrefixedLetExpCS )
                    {
                    // InternalQVTcore.g:4660:1: (lv_ownedRight_2_0= rulePrefixedLetExpCS )
                    // InternalQVTcore.g:4661:3: lv_ownedRight_2_0= rulePrefixedLetExpCS
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
                    // InternalQVTcore.g:4679:2: this_LetExpCS_3= ruleLetExpCS
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
    // InternalQVTcore.g:4698:1: entryRulePrefixedPrimaryExpCS returns [EObject current=null] : iv_rulePrefixedPrimaryExpCS= rulePrefixedPrimaryExpCS EOF ;
    public final EObject entryRulePrefixedPrimaryExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrefixedPrimaryExpCS = null;


        try {
            // InternalQVTcore.g:4699:2: (iv_rulePrefixedPrimaryExpCS= rulePrefixedPrimaryExpCS EOF )
            // InternalQVTcore.g:4700:2: iv_rulePrefixedPrimaryExpCS= rulePrefixedPrimaryExpCS EOF
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
    // InternalQVTcore.g:4707:1: rulePrefixedPrimaryExpCS returns [EObject current=null] : ( ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS ) ) ) | this_PrimaryExpCS_3= rulePrimaryExpCS ) ;
    public final EObject rulePrefixedPrimaryExpCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_ownedRight_2_0 = null;

        EObject this_PrimaryExpCS_3 = null;


         enterRule(); 
            
        try {
            // InternalQVTcore.g:4710:28: ( ( ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS ) ) ) | this_PrimaryExpCS_3= rulePrimaryExpCS ) )
            // InternalQVTcore.g:4711:1: ( ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS ) ) ) | this_PrimaryExpCS_3= rulePrimaryExpCS )
            {
            // InternalQVTcore.g:4711:1: ( ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS ) ) ) | this_PrimaryExpCS_3= rulePrimaryExpCS )
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( ((LA82_0>=41 && LA82_0<=42)) ) {
                alt82=1;
            }
            else if ( ((LA82_0>=RULE_SIMPLE_ID && LA82_0<=RULE_SINGLE_QUOTED_STRING)||LA82_0==17||LA82_0==19||(LA82_0>=25 && LA82_0<=27)||LA82_0==30||LA82_0==32||(LA82_0>=34 && LA82_0<=35)||(LA82_0>=37 && LA82_0<=40)||(LA82_0>=59 && LA82_0<=73)||LA82_0==76||(LA82_0>=78 && LA82_0<=81)||LA82_0==86||LA82_0==92) ) {
                alt82=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 82, 0, input);

                throw nvae;
            }
            switch (alt82) {
                case 1 :
                    // InternalQVTcore.g:4711:2: ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS ) ) )
                    {
                    // InternalQVTcore.g:4711:2: ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS ) ) )
                    // InternalQVTcore.g:4711:3: () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS ) )
                    {
                    // InternalQVTcore.g:4711:3: ()
                    // InternalQVTcore.g:4712:2: 
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

                    // InternalQVTcore.g:4720:2: ( (lv_name_1_0= ruleUnaryOperatorName ) )
                    // InternalQVTcore.g:4721:1: (lv_name_1_0= ruleUnaryOperatorName )
                    {
                    // InternalQVTcore.g:4721:1: (lv_name_1_0= ruleUnaryOperatorName )
                    // InternalQVTcore.g:4722:3: lv_name_1_0= ruleUnaryOperatorName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrefixedPrimaryExpCSAccess().getNameUnaryOperatorNameParserRuleCall_0_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_55);
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

                    // InternalQVTcore.g:4738:2: ( (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS ) )
                    // InternalQVTcore.g:4739:1: (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS )
                    {
                    // InternalQVTcore.g:4739:1: (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS )
                    // InternalQVTcore.g:4740:3: lv_ownedRight_2_0= rulePrefixedPrimaryExpCS
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
                    // InternalQVTcore.g:4758:2: this_PrimaryExpCS_3= rulePrimaryExpCS
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
    // InternalQVTcore.g:4777:1: entryRulePrimaryExpCS returns [EObject current=null] : iv_rulePrimaryExpCS= rulePrimaryExpCS EOF ;
    public final EObject entryRulePrimaryExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpCS = null;


        try {
            // InternalQVTcore.g:4778:2: (iv_rulePrimaryExpCS= rulePrimaryExpCS EOF )
            // InternalQVTcore.g:4779:2: iv_rulePrimaryExpCS= rulePrimaryExpCS EOF
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
    // InternalQVTcore.g:4786:1: rulePrimaryExpCS returns [EObject current=null] : (this_NestedExpCS_0= ruleNestedExpCS | this_IfExpCS_1= ruleIfExpCS | this_SelfExpCS_2= ruleSelfExpCS | this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS | this_MapLiteralExpCS_5= ruleMapLiteralExpCS | this_CollectionLiteralExpCS_6= ruleCollectionLiteralExpCS | this_LambdaLiteralExpCS_7= ruleLambdaLiteralExpCS | this_TypeLiteralExpCS_8= ruleTypeLiteralExpCS | this_NameExpCS_9= ruleNameExpCS ) ;
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
            // InternalQVTcore.g:4789:28: ( (this_NestedExpCS_0= ruleNestedExpCS | this_IfExpCS_1= ruleIfExpCS | this_SelfExpCS_2= ruleSelfExpCS | this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS | this_MapLiteralExpCS_5= ruleMapLiteralExpCS | this_CollectionLiteralExpCS_6= ruleCollectionLiteralExpCS | this_LambdaLiteralExpCS_7= ruleLambdaLiteralExpCS | this_TypeLiteralExpCS_8= ruleTypeLiteralExpCS | this_NameExpCS_9= ruleNameExpCS ) )
            // InternalQVTcore.g:4790:1: (this_NestedExpCS_0= ruleNestedExpCS | this_IfExpCS_1= ruleIfExpCS | this_SelfExpCS_2= ruleSelfExpCS | this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS | this_MapLiteralExpCS_5= ruleMapLiteralExpCS | this_CollectionLiteralExpCS_6= ruleCollectionLiteralExpCS | this_LambdaLiteralExpCS_7= ruleLambdaLiteralExpCS | this_TypeLiteralExpCS_8= ruleTypeLiteralExpCS | this_NameExpCS_9= ruleNameExpCS )
            {
            // InternalQVTcore.g:4790:1: (this_NestedExpCS_0= ruleNestedExpCS | this_IfExpCS_1= ruleIfExpCS | this_SelfExpCS_2= ruleSelfExpCS | this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS | this_MapLiteralExpCS_5= ruleMapLiteralExpCS | this_CollectionLiteralExpCS_6= ruleCollectionLiteralExpCS | this_LambdaLiteralExpCS_7= ruleLambdaLiteralExpCS | this_TypeLiteralExpCS_8= ruleTypeLiteralExpCS | this_NameExpCS_9= ruleNameExpCS )
            int alt83=10;
            alt83 = dfa83.predict(input);
            switch (alt83) {
                case 1 :
                    // InternalQVTcore.g:4791:2: this_NestedExpCS_0= ruleNestedExpCS
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
                    // InternalQVTcore.g:4804:2: this_IfExpCS_1= ruleIfExpCS
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
                    // InternalQVTcore.g:4817:2: this_SelfExpCS_2= ruleSelfExpCS
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
                    // InternalQVTcore.g:4830:2: this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS
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
                    // InternalQVTcore.g:4843:2: this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS
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
                    // InternalQVTcore.g:4856:2: this_MapLiteralExpCS_5= ruleMapLiteralExpCS
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
                    // InternalQVTcore.g:4869:2: this_CollectionLiteralExpCS_6= ruleCollectionLiteralExpCS
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
                    // InternalQVTcore.g:4882:2: this_LambdaLiteralExpCS_7= ruleLambdaLiteralExpCS
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
                    // InternalQVTcore.g:4895:2: this_TypeLiteralExpCS_8= ruleTypeLiteralExpCS
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
                    // InternalQVTcore.g:4908:2: this_NameExpCS_9= ruleNameExpCS
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
    // InternalQVTcore.g:4927:1: entryRuleNameExpCS returns [EObject current=null] : iv_ruleNameExpCS= ruleNameExpCS EOF ;
    public final EObject entryRuleNameExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNameExpCS = null;


        try {
            // InternalQVTcore.g:4928:2: (iv_ruleNameExpCS= ruleNameExpCS EOF )
            // InternalQVTcore.g:4929:2: iv_ruleNameExpCS= ruleNameExpCS EOF
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
    // InternalQVTcore.g:4936:1: ruleNameExpCS returns [EObject current=null] : ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( (lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS ) )* ( (lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS ) )? ( (lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS ) )? ( ( (lv_isPre_4_0= '@' ) ) otherlv_5= 'pre' )? ) ;
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
            // InternalQVTcore.g:4939:28: ( ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( (lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS ) )* ( (lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS ) )? ( (lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS ) )? ( ( (lv_isPre_4_0= '@' ) ) otherlv_5= 'pre' )? ) )
            // InternalQVTcore.g:4940:1: ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( (lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS ) )* ( (lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS ) )? ( (lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS ) )? ( ( (lv_isPre_4_0= '@' ) ) otherlv_5= 'pre' )? )
            {
            // InternalQVTcore.g:4940:1: ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( (lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS ) )* ( (lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS ) )? ( (lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS ) )? ( ( (lv_isPre_4_0= '@' ) ) otherlv_5= 'pre' )? )
            // InternalQVTcore.g:4940:2: ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( (lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS ) )* ( (lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS ) )? ( (lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS ) )? ( ( (lv_isPre_4_0= '@' ) ) otherlv_5= 'pre' )?
            {
            // InternalQVTcore.g:4940:2: ( (lv_ownedPathName_0_0= rulePathNameCS ) )
            // InternalQVTcore.g:4941:1: (lv_ownedPathName_0_0= rulePathNameCS )
            {
            // InternalQVTcore.g:4941:1: (lv_ownedPathName_0_0= rulePathNameCS )
            // InternalQVTcore.g:4942:3: lv_ownedPathName_0_0= rulePathNameCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNameExpCSAccess().getOwnedPathNamePathNameCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_56);
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

            // InternalQVTcore.g:4958:2: ( (lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS ) )*
            loop84:
            do {
                int alt84=2;
                int LA84_0 = input.LA(1);

                if ( (LA84_0==84) ) {
                    alt84=1;
                }


                switch (alt84) {
            	case 1 :
            	    // InternalQVTcore.g:4959:1: (lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS )
            	    {
            	    // InternalQVTcore.g:4959:1: (lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS )
            	    // InternalQVTcore.g:4960:3: lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getNameExpCSAccess().getOwnedSquareBracketedClausesSquareBracketedClauseCSParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_56);
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
            	    break loop84;
                }
            } while (true);

            // InternalQVTcore.g:4976:3: ( (lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS ) )?
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==27) ) {
                alt85=1;
            }
            switch (alt85) {
                case 1 :
                    // InternalQVTcore.g:4977:1: (lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS )
                    {
                    // InternalQVTcore.g:4977:1: (lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS )
                    // InternalQVTcore.g:4978:3: lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNameExpCSAccess().getOwnedRoundBracketedClauseRoundBracketedClauseCSParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_57);
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

            // InternalQVTcore.g:4994:3: ( (lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS ) )?
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==21) ) {
                alt86=1;
            }
            switch (alt86) {
                case 1 :
                    // InternalQVTcore.g:4995:1: (lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS )
                    {
                    // InternalQVTcore.g:4995:1: (lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS )
                    // InternalQVTcore.g:4996:3: lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNameExpCSAccess().getOwnedCurlyBracketedClauseCurlyBracketedClauseCSParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_58);
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

            // InternalQVTcore.g:5012:3: ( ( (lv_isPre_4_0= '@' ) ) otherlv_5= 'pre' )?
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==82) ) {
                alt87=1;
            }
            switch (alt87) {
                case 1 :
                    // InternalQVTcore.g:5012:4: ( (lv_isPre_4_0= '@' ) ) otherlv_5= 'pre'
                    {
                    // InternalQVTcore.g:5012:4: ( (lv_isPre_4_0= '@' ) )
                    // InternalQVTcore.g:5013:1: (lv_isPre_4_0= '@' )
                    {
                    // InternalQVTcore.g:5013:1: (lv_isPre_4_0= '@' )
                    // InternalQVTcore.g:5014:3: lv_isPre_4_0= '@'
                    {
                    lv_isPre_4_0=(Token)match(input,82,FollowSets000.FOLLOW_59); if (state.failed) return current;
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

                    otherlv_5=(Token)match(input,83,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
    // InternalQVTcore.g:5039:1: entryRuleCurlyBracketedClauseCS returns [EObject current=null] : iv_ruleCurlyBracketedClauseCS= ruleCurlyBracketedClauseCS EOF ;
    public final EObject entryRuleCurlyBracketedClauseCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCurlyBracketedClauseCS = null;


        try {
            // InternalQVTcore.g:5040:2: (iv_ruleCurlyBracketedClauseCS= ruleCurlyBracketedClauseCS EOF )
            // InternalQVTcore.g:5041:2: iv_ruleCurlyBracketedClauseCS= ruleCurlyBracketedClauseCS EOF
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
    // InternalQVTcore.g:5048:1: ruleCurlyBracketedClauseCS returns [EObject current=null] : ( () otherlv_1= '{' ( ( ( (lv_ownedParts_2_0= ruleShadowPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleShadowPartCS ) ) )* )? | ( (lv_value_5_0= ruleStringLiteral ) ) ) otherlv_6= '}' ) ;
    public final EObject ruleCurlyBracketedClauseCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_6=null;
        EObject lv_ownedParts_2_0 = null;

        EObject lv_ownedParts_4_0 = null;

        AntlrDatatypeRuleToken lv_value_5_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTcore.g:5051:28: ( ( () otherlv_1= '{' ( ( ( (lv_ownedParts_2_0= ruleShadowPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleShadowPartCS ) ) )* )? | ( (lv_value_5_0= ruleStringLiteral ) ) ) otherlv_6= '}' ) )
            // InternalQVTcore.g:5052:1: ( () otherlv_1= '{' ( ( ( (lv_ownedParts_2_0= ruleShadowPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleShadowPartCS ) ) )* )? | ( (lv_value_5_0= ruleStringLiteral ) ) ) otherlv_6= '}' )
            {
            // InternalQVTcore.g:5052:1: ( () otherlv_1= '{' ( ( ( (lv_ownedParts_2_0= ruleShadowPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleShadowPartCS ) ) )* )? | ( (lv_value_5_0= ruleStringLiteral ) ) ) otherlv_6= '}' )
            // InternalQVTcore.g:5052:2: () otherlv_1= '{' ( ( ( (lv_ownedParts_2_0= ruleShadowPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleShadowPartCS ) ) )* )? | ( (lv_value_5_0= ruleStringLiteral ) ) ) otherlv_6= '}'
            {
            // InternalQVTcore.g:5052:2: ()
            // InternalQVTcore.g:5053:2: 
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

            otherlv_1=(Token)match(input,21,FollowSets000.FOLLOW_60); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getCurlyBracketedClauseCSAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // InternalQVTcore.g:5065:1: ( ( ( (lv_ownedParts_2_0= ruleShadowPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleShadowPartCS ) ) )* )? | ( (lv_value_5_0= ruleStringLiteral ) ) )
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( ((LA90_0>=RULE_SIMPLE_ID && LA90_0<=RULE_ESCAPED_ID)||LA90_0==17||LA90_0==19||LA90_0==23||(LA90_0>=25 && LA90_0<=26)||LA90_0==30||(LA90_0>=34 && LA90_0<=35)||(LA90_0>=37 && LA90_0<=40)) ) {
                alt90=1;
            }
            else if ( (LA90_0==RULE_SINGLE_QUOTED_STRING) ) {
                alt90=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 90, 0, input);

                throw nvae;
            }
            switch (alt90) {
                case 1 :
                    // InternalQVTcore.g:5065:2: ( ( (lv_ownedParts_2_0= ruleShadowPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleShadowPartCS ) ) )* )?
                    {
                    // InternalQVTcore.g:5065:2: ( ( (lv_ownedParts_2_0= ruleShadowPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleShadowPartCS ) ) )* )?
                    int alt89=2;
                    int LA89_0 = input.LA(1);

                    if ( ((LA89_0>=RULE_SIMPLE_ID && LA89_0<=RULE_ESCAPED_ID)||LA89_0==17||LA89_0==19||(LA89_0>=25 && LA89_0<=26)||LA89_0==30||(LA89_0>=34 && LA89_0<=35)||(LA89_0>=37 && LA89_0<=40)) ) {
                        alt89=1;
                    }
                    switch (alt89) {
                        case 1 :
                            // InternalQVTcore.g:5065:3: ( (lv_ownedParts_2_0= ruleShadowPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleShadowPartCS ) ) )*
                            {
                            // InternalQVTcore.g:5065:3: ( (lv_ownedParts_2_0= ruleShadowPartCS ) )
                            // InternalQVTcore.g:5066:1: (lv_ownedParts_2_0= ruleShadowPartCS )
                            {
                            // InternalQVTcore.g:5066:1: (lv_ownedParts_2_0= ruleShadowPartCS )
                            // InternalQVTcore.g:5067:3: lv_ownedParts_2_0= ruleShadowPartCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getCurlyBracketedClauseCSAccess().getOwnedPartsShadowPartCSParserRuleCall_2_0_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_16);
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

                            // InternalQVTcore.g:5083:2: (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleShadowPartCS ) ) )*
                            loop88:
                            do {
                                int alt88=2;
                                int LA88_0 = input.LA(1);

                                if ( (LA88_0==20) ) {
                                    alt88=1;
                                }


                                switch (alt88) {
                            	case 1 :
                            	    // InternalQVTcore.g:5083:4: otherlv_3= ',' ( (lv_ownedParts_4_0= ruleShadowPartCS ) )
                            	    {
                            	    otherlv_3=(Token)match(input,20,FollowSets000.FOLLOW_8); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_3, grammarAccess.getCurlyBracketedClauseCSAccess().getCommaKeyword_2_0_1_0());
                            	          
                            	    }
                            	    // InternalQVTcore.g:5087:1: ( (lv_ownedParts_4_0= ruleShadowPartCS ) )
                            	    // InternalQVTcore.g:5088:1: (lv_ownedParts_4_0= ruleShadowPartCS )
                            	    {
                            	    // InternalQVTcore.g:5088:1: (lv_ownedParts_4_0= ruleShadowPartCS )
                            	    // InternalQVTcore.g:5089:3: lv_ownedParts_4_0= ruleShadowPartCS
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getCurlyBracketedClauseCSAccess().getOwnedPartsShadowPartCSParserRuleCall_2_0_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FollowSets000.FOLLOW_16);
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
                            	    break loop88;
                                }
                            } while (true);


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // InternalQVTcore.g:5106:6: ( (lv_value_5_0= ruleStringLiteral ) )
                    {
                    // InternalQVTcore.g:5106:6: ( (lv_value_5_0= ruleStringLiteral ) )
                    // InternalQVTcore.g:5107:1: (lv_value_5_0= ruleStringLiteral )
                    {
                    // InternalQVTcore.g:5107:1: (lv_value_5_0= ruleStringLiteral )
                    // InternalQVTcore.g:5108:3: lv_value_5_0= ruleStringLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCurlyBracketedClauseCSAccess().getValueStringLiteralParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_18);
                    lv_value_5_0=ruleStringLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getCurlyBracketedClauseCSRule());
                      	        }
                             		set(
                             			current, 
                             			"value",
                              		lv_value_5_0, 
                              		"org.eclipse.ocl.xtext.base.Base.StringLiteral");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,23,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getCurlyBracketedClauseCSAccess().getRightCurlyBracketKeyword_3());
                  
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
    // InternalQVTcore.g:5136:1: entryRuleRoundBracketedClauseCS returns [EObject current=null] : iv_ruleRoundBracketedClauseCS= ruleRoundBracketedClauseCS EOF ;
    public final EObject entryRuleRoundBracketedClauseCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRoundBracketedClauseCS = null;


        try {
            // InternalQVTcore.g:5137:2: (iv_ruleRoundBracketedClauseCS= ruleRoundBracketedClauseCS EOF )
            // InternalQVTcore.g:5138:2: iv_ruleRoundBracketedClauseCS= ruleRoundBracketedClauseCS EOF
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
    // InternalQVTcore.g:5145:1: ruleRoundBracketedClauseCS returns [EObject current=null] : ( () otherlv_1= '(' ( ( (lv_ownedArguments_2_0= ruleNavigatingArgCS ) ) ( (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )* )* )? otherlv_8= ')' ) ;
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
            // InternalQVTcore.g:5148:28: ( ( () otherlv_1= '(' ( ( (lv_ownedArguments_2_0= ruleNavigatingArgCS ) ) ( (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )* )* )? otherlv_8= ')' ) )
            // InternalQVTcore.g:5149:1: ( () otherlv_1= '(' ( ( (lv_ownedArguments_2_0= ruleNavigatingArgCS ) ) ( (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )* )* )? otherlv_8= ')' )
            {
            // InternalQVTcore.g:5149:1: ( () otherlv_1= '(' ( ( (lv_ownedArguments_2_0= ruleNavigatingArgCS ) ) ( (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )* )* )? otherlv_8= ')' )
            // InternalQVTcore.g:5149:2: () otherlv_1= '(' ( ( (lv_ownedArguments_2_0= ruleNavigatingArgCS ) ) ( (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )* )* )? otherlv_8= ')'
            {
            // InternalQVTcore.g:5149:2: ()
            // InternalQVTcore.g:5150:2: 
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

            otherlv_1=(Token)match(input,27,FollowSets000.FOLLOW_61); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getRoundBracketedClauseCSAccess().getLeftParenthesisKeyword_1());
                  
            }
            // InternalQVTcore.g:5162:1: ( ( (lv_ownedArguments_2_0= ruleNavigatingArgCS ) ) ( (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )* )* )?
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( ((LA96_0>=RULE_SIMPLE_ID && LA96_0<=RULE_SINGLE_QUOTED_STRING)||LA96_0==17||LA96_0==19||(LA96_0>=25 && LA96_0<=27)||(LA96_0>=29 && LA96_0<=30)||LA96_0==32||(LA96_0>=34 && LA96_0<=35)||(LA96_0>=37 && LA96_0<=42)||(LA96_0>=59 && LA96_0<=73)||LA96_0==76||(LA96_0>=78 && LA96_0<=81)||LA96_0==86||(LA96_0>=91 && LA96_0<=92)) ) {
                alt96=1;
            }
            switch (alt96) {
                case 1 :
                    // InternalQVTcore.g:5162:2: ( (lv_ownedArguments_2_0= ruleNavigatingArgCS ) ) ( (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )* )*
                    {
                    // InternalQVTcore.g:5162:2: ( (lv_ownedArguments_2_0= ruleNavigatingArgCS ) )
                    // InternalQVTcore.g:5163:1: (lv_ownedArguments_2_0= ruleNavigatingArgCS )
                    {
                    // InternalQVTcore.g:5163:1: (lv_ownedArguments_2_0= ruleNavigatingArgCS )
                    // InternalQVTcore.g:5164:3: lv_ownedArguments_2_0= ruleNavigatingArgCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingArgCSParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_62);
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

                    // InternalQVTcore.g:5180:2: ( (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS ) )*
                    loop91:
                    do {
                        int alt91=2;
                        int LA91_0 = input.LA(1);

                        if ( (LA91_0==20) ) {
                            alt91=1;
                        }


                        switch (alt91) {
                    	case 1 :
                    	    // InternalQVTcore.g:5181:1: (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS )
                    	    {
                    	    // InternalQVTcore.g:5181:1: (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS )
                    	    // InternalQVTcore.g:5182:3: lv_ownedArguments_3_0= ruleNavigatingCommaArgCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingCommaArgCSParserRuleCall_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_62);
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
                    	    break loop91;
                        }
                    } while (true);

                    // InternalQVTcore.g:5198:3: ( ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )* )?
                    int alt93=2;
                    int LA93_0 = input.LA(1);

                    if ( (LA93_0==33) ) {
                        alt93=1;
                    }
                    switch (alt93) {
                        case 1 :
                            // InternalQVTcore.g:5198:4: ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )*
                            {
                            // InternalQVTcore.g:5198:4: ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) )
                            // InternalQVTcore.g:5199:1: (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS )
                            {
                            // InternalQVTcore.g:5199:1: (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS )
                            // InternalQVTcore.g:5200:3: lv_ownedArguments_4_0= ruleNavigatingSemiArgCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingSemiArgCSParserRuleCall_2_2_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_63);
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

                            // InternalQVTcore.g:5216:2: ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )*
                            loop92:
                            do {
                                int alt92=2;
                                int LA92_0 = input.LA(1);

                                if ( (LA92_0==20) ) {
                                    alt92=1;
                                }


                                switch (alt92) {
                            	case 1 :
                            	    // InternalQVTcore.g:5217:1: (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS )
                            	    {
                            	    // InternalQVTcore.g:5217:1: (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS )
                            	    // InternalQVTcore.g:5218:3: lv_ownedArguments_5_0= ruleNavigatingCommaArgCS
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingCommaArgCSParserRuleCall_2_2_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FollowSets000.FOLLOW_63);
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
                            	    break loop92;
                                }
                            } while (true);


                            }
                            break;

                    }

                    // InternalQVTcore.g:5234:5: ( ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )* )*
                    loop95:
                    do {
                        int alt95=2;
                        int LA95_0 = input.LA(1);

                        if ( (LA95_0==24) ) {
                            alt95=1;
                        }


                        switch (alt95) {
                    	case 1 :
                    	    // InternalQVTcore.g:5234:6: ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )*
                    	    {
                    	    // InternalQVTcore.g:5234:6: ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) )
                    	    // InternalQVTcore.g:5235:1: (lv_ownedArguments_6_0= ruleNavigatingBarArgCS )
                    	    {
                    	    // InternalQVTcore.g:5235:1: (lv_ownedArguments_6_0= ruleNavigatingBarArgCS )
                    	    // InternalQVTcore.g:5236:3: lv_ownedArguments_6_0= ruleNavigatingBarArgCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingBarArgCSParserRuleCall_2_3_0_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_63);
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

                    	    // InternalQVTcore.g:5252:2: ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )*
                    	    loop94:
                    	    do {
                    	        int alt94=2;
                    	        int LA94_0 = input.LA(1);

                    	        if ( (LA94_0==20) ) {
                    	            alt94=1;
                    	        }


                    	        switch (alt94) {
                    	    	case 1 :
                    	    	    // InternalQVTcore.g:5253:1: (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS )
                    	    	    {
                    	    	    // InternalQVTcore.g:5253:1: (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS )
                    	    	    // InternalQVTcore.g:5254:3: lv_ownedArguments_7_0= ruleNavigatingCommaArgCS
                    	    	    {
                    	    	    if ( state.backtracking==0 ) {
                    	    	       
                    	    	      	        newCompositeNode(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingCommaArgCSParserRuleCall_2_3_1_0()); 
                    	    	      	    
                    	    	    }
                    	    	    pushFollow(FollowSets000.FOLLOW_63);
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
                    	    	    break loop94;
                    	        }
                    	    } while (true);


                    	    }
                    	    break;

                    	default :
                    	    break loop95;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_8=(Token)match(input,28,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
    // InternalQVTcore.g:5282:1: entryRuleSquareBracketedClauseCS returns [EObject current=null] : iv_ruleSquareBracketedClauseCS= ruleSquareBracketedClauseCS EOF ;
    public final EObject entryRuleSquareBracketedClauseCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSquareBracketedClauseCS = null;


        try {
            // InternalQVTcore.g:5283:2: (iv_ruleSquareBracketedClauseCS= ruleSquareBracketedClauseCS EOF )
            // InternalQVTcore.g:5284:2: iv_ruleSquareBracketedClauseCS= ruleSquareBracketedClauseCS EOF
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
    // InternalQVTcore.g:5291:1: ruleSquareBracketedClauseCS returns [EObject current=null] : (otherlv_0= '[' ( (lv_ownedTerms_1_0= ruleExpCS ) ) (otherlv_2= ',' ( (lv_ownedTerms_3_0= ruleExpCS ) ) )* otherlv_4= ']' ) ;
    public final EObject ruleSquareBracketedClauseCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_ownedTerms_1_0 = null;

        EObject lv_ownedTerms_3_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTcore.g:5294:28: ( (otherlv_0= '[' ( (lv_ownedTerms_1_0= ruleExpCS ) ) (otherlv_2= ',' ( (lv_ownedTerms_3_0= ruleExpCS ) ) )* otherlv_4= ']' ) )
            // InternalQVTcore.g:5295:1: (otherlv_0= '[' ( (lv_ownedTerms_1_0= ruleExpCS ) ) (otherlv_2= ',' ( (lv_ownedTerms_3_0= ruleExpCS ) ) )* otherlv_4= ']' )
            {
            // InternalQVTcore.g:5295:1: (otherlv_0= '[' ( (lv_ownedTerms_1_0= ruleExpCS ) ) (otherlv_2= ',' ( (lv_ownedTerms_3_0= ruleExpCS ) ) )* otherlv_4= ']' )
            // InternalQVTcore.g:5295:3: otherlv_0= '[' ( (lv_ownedTerms_1_0= ruleExpCS ) ) (otherlv_2= ',' ( (lv_ownedTerms_3_0= ruleExpCS ) ) )* otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,84,FollowSets000.FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getSquareBracketedClauseCSAccess().getLeftSquareBracketKeyword_0());
                  
            }
            // InternalQVTcore.g:5299:1: ( (lv_ownedTerms_1_0= ruleExpCS ) )
            // InternalQVTcore.g:5300:1: (lv_ownedTerms_1_0= ruleExpCS )
            {
            // InternalQVTcore.g:5300:1: (lv_ownedTerms_1_0= ruleExpCS )
            // InternalQVTcore.g:5301:3: lv_ownedTerms_1_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSquareBracketedClauseCSAccess().getOwnedTermsExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_64);
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

            // InternalQVTcore.g:5317:2: (otherlv_2= ',' ( (lv_ownedTerms_3_0= ruleExpCS ) ) )*
            loop97:
            do {
                int alt97=2;
                int LA97_0 = input.LA(1);

                if ( (LA97_0==20) ) {
                    alt97=1;
                }


                switch (alt97) {
            	case 1 :
            	    // InternalQVTcore.g:5317:4: otherlv_2= ',' ( (lv_ownedTerms_3_0= ruleExpCS ) )
            	    {
            	    otherlv_2=(Token)match(input,20,FollowSets000.FOLLOW_17); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getSquareBracketedClauseCSAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // InternalQVTcore.g:5321:1: ( (lv_ownedTerms_3_0= ruleExpCS ) )
            	    // InternalQVTcore.g:5322:1: (lv_ownedTerms_3_0= ruleExpCS )
            	    {
            	    // InternalQVTcore.g:5322:1: (lv_ownedTerms_3_0= ruleExpCS )
            	    // InternalQVTcore.g:5323:3: lv_ownedTerms_3_0= ruleExpCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSquareBracketedClauseCSAccess().getOwnedTermsExpCSParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_64);
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
            	    break loop97;
                }
            } while (true);

            otherlv_4=(Token)match(input,85,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
    // InternalQVTcore.g:5351:1: entryRuleNavigatingArgCS returns [EObject current=null] : iv_ruleNavigatingArgCS= ruleNavigatingArgCS EOF ;
    public final EObject entryRuleNavigatingArgCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingArgCS = null;


        try {
            // InternalQVTcore.g:5352:2: (iv_ruleNavigatingArgCS= ruleNavigatingArgCS EOF )
            // InternalQVTcore.g:5353:2: iv_ruleNavigatingArgCS= ruleNavigatingArgCS EOF
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
    // InternalQVTcore.g:5360:1: ruleNavigatingArgCS returns [EObject current=null] : ( ( ( (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS ) ) ( (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? ) | (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) ) )? ) | (otherlv_7= ':' ( (lv_ownedType_8_0= ruleTypeExpCS ) ) ) ) ;
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
            // InternalQVTcore.g:5363:28: ( ( ( ( (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS ) ) ( (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? ) | (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) ) )? ) | (otherlv_7= ':' ( (lv_ownedType_8_0= ruleTypeExpCS ) ) ) ) )
            // InternalQVTcore.g:5364:1: ( ( ( (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS ) ) ( (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? ) | (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) ) )? ) | (otherlv_7= ':' ( (lv_ownedType_8_0= ruleTypeExpCS ) ) ) )
            {
            // InternalQVTcore.g:5364:1: ( ( ( (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS ) ) ( (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? ) | (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) ) )? ) | (otherlv_7= ':' ( (lv_ownedType_8_0= ruleTypeExpCS ) ) ) )
            int alt100=2;
            int LA100_0 = input.LA(1);

            if ( ((LA100_0>=RULE_SIMPLE_ID && LA100_0<=RULE_SINGLE_QUOTED_STRING)||LA100_0==17||LA100_0==19||(LA100_0>=25 && LA100_0<=27)||LA100_0==30||LA100_0==32||(LA100_0>=34 && LA100_0<=35)||(LA100_0>=37 && LA100_0<=42)||(LA100_0>=59 && LA100_0<=73)||LA100_0==76||(LA100_0>=78 && LA100_0<=81)||LA100_0==86||(LA100_0>=91 && LA100_0<=92)) ) {
                alt100=1;
            }
            else if ( (LA100_0==29) ) {
                alt100=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 100, 0, input);

                throw nvae;
            }
            switch (alt100) {
                case 1 :
                    // InternalQVTcore.g:5364:2: ( ( (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS ) ) ( (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? ) | (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) ) )? )
                    {
                    // InternalQVTcore.g:5364:2: ( ( (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS ) ) ( (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? ) | (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) ) )? )
                    // InternalQVTcore.g:5364:3: ( (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS ) ) ( (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? ) | (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) ) )?
                    {
                    // InternalQVTcore.g:5364:3: ( (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS ) )
                    // InternalQVTcore.g:5365:1: (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS )
                    {
                    // InternalQVTcore.g:5365:1: (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS )
                    // InternalQVTcore.g:5366:3: lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedNameExpressionNavigatingArgExpCSParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_65);
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

                    // InternalQVTcore.g:5382:2: ( (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? ) | (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) ) )?
                    int alt99=3;
                    int LA99_0 = input.LA(1);

                    if ( (LA99_0==29) ) {
                        alt99=1;
                    }
                    else if ( (LA99_0==18) ) {
                        alt99=2;
                    }
                    switch (alt99) {
                        case 1 :
                            // InternalQVTcore.g:5382:3: (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? )
                            {
                            // InternalQVTcore.g:5382:3: (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? )
                            // InternalQVTcore.g:5382:5: otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )?
                            {
                            otherlv_1=(Token)match(input,29,FollowSets000.FOLLOW_26); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_1, grammarAccess.getNavigatingArgCSAccess().getColonKeyword_0_1_0_0());
                                  
                            }
                            // InternalQVTcore.g:5386:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                            // InternalQVTcore.g:5387:1: (lv_ownedType_2_0= ruleTypeExpCS )
                            {
                            // InternalQVTcore.g:5387:1: (lv_ownedType_2_0= ruleTypeExpCS )
                            // InternalQVTcore.g:5388:3: lv_ownedType_2_0= ruleTypeExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_0_1_0_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_66);
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

                            // InternalQVTcore.g:5404:2: (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )?
                            int alt98=2;
                            int LA98_0 = input.LA(1);

                            if ( (LA98_0==49) ) {
                                alt98=1;
                            }
                            switch (alt98) {
                                case 1 :
                                    // InternalQVTcore.g:5404:4: otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) )
                                    {
                                    otherlv_3=(Token)match(input,49,FollowSets000.FOLLOW_17); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                          	newLeafNode(otherlv_3, grammarAccess.getNavigatingArgCSAccess().getEqualsSignKeyword_0_1_0_2_0());
                                          
                                    }
                                    // InternalQVTcore.g:5408:1: ( (lv_ownedInitExpression_4_0= ruleExpCS ) )
                                    // InternalQVTcore.g:5409:1: (lv_ownedInitExpression_4_0= ruleExpCS )
                                    {
                                    // InternalQVTcore.g:5409:1: (lv_ownedInitExpression_4_0= ruleExpCS )
                                    // InternalQVTcore.g:5410:3: lv_ownedInitExpression_4_0= ruleExpCS
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
                            // InternalQVTcore.g:5427:6: (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) )
                            {
                            // InternalQVTcore.g:5427:6: (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) )
                            // InternalQVTcore.g:5427:8: otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) )
                            {
                            otherlv_5=(Token)match(input,18,FollowSets000.FOLLOW_17); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_5, grammarAccess.getNavigatingArgCSAccess().getInKeyword_0_1_1_0());
                                  
                            }
                            // InternalQVTcore.g:5431:1: ( (lv_ownedInitExpression_6_0= ruleExpCS ) )
                            // InternalQVTcore.g:5432:1: (lv_ownedInitExpression_6_0= ruleExpCS )
                            {
                            // InternalQVTcore.g:5432:1: (lv_ownedInitExpression_6_0= ruleExpCS )
                            // InternalQVTcore.g:5433:3: lv_ownedInitExpression_6_0= ruleExpCS
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
                    // InternalQVTcore.g:5450:6: (otherlv_7= ':' ( (lv_ownedType_8_0= ruleTypeExpCS ) ) )
                    {
                    // InternalQVTcore.g:5450:6: (otherlv_7= ':' ( (lv_ownedType_8_0= ruleTypeExpCS ) ) )
                    // InternalQVTcore.g:5450:8: otherlv_7= ':' ( (lv_ownedType_8_0= ruleTypeExpCS ) )
                    {
                    otherlv_7=(Token)match(input,29,FollowSets000.FOLLOW_26); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getNavigatingArgCSAccess().getColonKeyword_1_0());
                          
                    }
                    // InternalQVTcore.g:5454:1: ( (lv_ownedType_8_0= ruleTypeExpCS ) )
                    // InternalQVTcore.g:5455:1: (lv_ownedType_8_0= ruleTypeExpCS )
                    {
                    // InternalQVTcore.g:5455:1: (lv_ownedType_8_0= ruleTypeExpCS )
                    // InternalQVTcore.g:5456:3: lv_ownedType_8_0= ruleTypeExpCS
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
    // InternalQVTcore.g:5480:1: entryRuleNavigatingBarArgCS returns [EObject current=null] : iv_ruleNavigatingBarArgCS= ruleNavigatingBarArgCS EOF ;
    public final EObject entryRuleNavigatingBarArgCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingBarArgCS = null;


        try {
            // InternalQVTcore.g:5481:2: (iv_ruleNavigatingBarArgCS= ruleNavigatingBarArgCS EOF )
            // InternalQVTcore.g:5482:2: iv_ruleNavigatingBarArgCS= ruleNavigatingBarArgCS EOF
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
    // InternalQVTcore.g:5489:1: ruleNavigatingBarArgCS returns [EObject current=null] : ( ( (lv_prefix_0_0= '|' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )? ) ;
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
            // InternalQVTcore.g:5492:28: ( ( ( (lv_prefix_0_0= '|' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )? ) )
            // InternalQVTcore.g:5493:1: ( ( (lv_prefix_0_0= '|' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )? )
            {
            // InternalQVTcore.g:5493:1: ( ( (lv_prefix_0_0= '|' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )? )
            // InternalQVTcore.g:5493:2: ( (lv_prefix_0_0= '|' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )?
            {
            // InternalQVTcore.g:5493:2: ( (lv_prefix_0_0= '|' ) )
            // InternalQVTcore.g:5494:1: (lv_prefix_0_0= '|' )
            {
            // InternalQVTcore.g:5494:1: (lv_prefix_0_0= '|' )
            // InternalQVTcore.g:5495:3: lv_prefix_0_0= '|'
            {
            lv_prefix_0_0=(Token)match(input,24,FollowSets000.FOLLOW_17); if (state.failed) return current;
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

            // InternalQVTcore.g:5508:2: ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) )
            // InternalQVTcore.g:5509:1: (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS )
            {
            // InternalQVTcore.g:5509:1: (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS )
            // InternalQVTcore.g:5510:3: lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNavigatingBarArgCSAccess().getOwnedNameExpressionNavigatingArgExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_67);
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

            // InternalQVTcore.g:5526:2: (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )?
            int alt102=2;
            int LA102_0 = input.LA(1);

            if ( (LA102_0==29) ) {
                alt102=1;
            }
            switch (alt102) {
                case 1 :
                    // InternalQVTcore.g:5526:4: otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )?
                    {
                    otherlv_2=(Token)match(input,29,FollowSets000.FOLLOW_26); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getNavigatingBarArgCSAccess().getColonKeyword_2_0());
                          
                    }
                    // InternalQVTcore.g:5530:1: ( (lv_ownedType_3_0= ruleTypeExpCS ) )
                    // InternalQVTcore.g:5531:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    {
                    // InternalQVTcore.g:5531:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    // InternalQVTcore.g:5532:3: lv_ownedType_3_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingBarArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_66);
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

                    // InternalQVTcore.g:5548:2: (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )?
                    int alt101=2;
                    int LA101_0 = input.LA(1);

                    if ( (LA101_0==49) ) {
                        alt101=1;
                    }
                    switch (alt101) {
                        case 1 :
                            // InternalQVTcore.g:5548:4: otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) )
                            {
                            otherlv_4=(Token)match(input,49,FollowSets000.FOLLOW_17); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getNavigatingBarArgCSAccess().getEqualsSignKeyword_2_2_0());
                                  
                            }
                            // InternalQVTcore.g:5552:1: ( (lv_ownedInitExpression_5_0= ruleExpCS ) )
                            // InternalQVTcore.g:5553:1: (lv_ownedInitExpression_5_0= ruleExpCS )
                            {
                            // InternalQVTcore.g:5553:1: (lv_ownedInitExpression_5_0= ruleExpCS )
                            // InternalQVTcore.g:5554:3: lv_ownedInitExpression_5_0= ruleExpCS
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
    // InternalQVTcore.g:5578:1: entryRuleNavigatingCommaArgCS returns [EObject current=null] : iv_ruleNavigatingCommaArgCS= ruleNavigatingCommaArgCS EOF ;
    public final EObject entryRuleNavigatingCommaArgCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingCommaArgCS = null;


        try {
            // InternalQVTcore.g:5579:2: (iv_ruleNavigatingCommaArgCS= ruleNavigatingCommaArgCS EOF )
            // InternalQVTcore.g:5580:2: iv_ruleNavigatingCommaArgCS= ruleNavigatingCommaArgCS EOF
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
    // InternalQVTcore.g:5587:1: ruleNavigatingCommaArgCS returns [EObject current=null] : ( ( (lv_prefix_0_0= ',' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) ( (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? ) | (otherlv_6= 'in' ( (lv_ownedInitExpression_7_0= ruleExpCS ) ) ) )? ) ;
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
            // InternalQVTcore.g:5590:28: ( ( ( (lv_prefix_0_0= ',' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) ( (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? ) | (otherlv_6= 'in' ( (lv_ownedInitExpression_7_0= ruleExpCS ) ) ) )? ) )
            // InternalQVTcore.g:5591:1: ( ( (lv_prefix_0_0= ',' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) ( (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? ) | (otherlv_6= 'in' ( (lv_ownedInitExpression_7_0= ruleExpCS ) ) ) )? )
            {
            // InternalQVTcore.g:5591:1: ( ( (lv_prefix_0_0= ',' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) ( (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? ) | (otherlv_6= 'in' ( (lv_ownedInitExpression_7_0= ruleExpCS ) ) ) )? )
            // InternalQVTcore.g:5591:2: ( (lv_prefix_0_0= ',' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) ( (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? ) | (otherlv_6= 'in' ( (lv_ownedInitExpression_7_0= ruleExpCS ) ) ) )?
            {
            // InternalQVTcore.g:5591:2: ( (lv_prefix_0_0= ',' ) )
            // InternalQVTcore.g:5592:1: (lv_prefix_0_0= ',' )
            {
            // InternalQVTcore.g:5592:1: (lv_prefix_0_0= ',' )
            // InternalQVTcore.g:5593:3: lv_prefix_0_0= ','
            {
            lv_prefix_0_0=(Token)match(input,20,FollowSets000.FOLLOW_17); if (state.failed) return current;
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

            // InternalQVTcore.g:5606:2: ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) )
            // InternalQVTcore.g:5607:1: (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS )
            {
            // InternalQVTcore.g:5607:1: (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS )
            // InternalQVTcore.g:5608:3: lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedNameExpressionNavigatingArgExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_65);
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

            // InternalQVTcore.g:5624:2: ( (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? ) | (otherlv_6= 'in' ( (lv_ownedInitExpression_7_0= ruleExpCS ) ) ) )?
            int alt104=3;
            int LA104_0 = input.LA(1);

            if ( (LA104_0==29) ) {
                alt104=1;
            }
            else if ( (LA104_0==18) ) {
                alt104=2;
            }
            switch (alt104) {
                case 1 :
                    // InternalQVTcore.g:5624:3: (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )
                    {
                    // InternalQVTcore.g:5624:3: (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )
                    // InternalQVTcore.g:5624:5: otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )?
                    {
                    otherlv_2=(Token)match(input,29,FollowSets000.FOLLOW_26); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getNavigatingCommaArgCSAccess().getColonKeyword_2_0_0());
                          
                    }
                    // InternalQVTcore.g:5628:1: ( (lv_ownedType_3_0= ruleTypeExpCS ) )
                    // InternalQVTcore.g:5629:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    {
                    // InternalQVTcore.g:5629:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    // InternalQVTcore.g:5630:3: lv_ownedType_3_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_0_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_66);
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

                    // InternalQVTcore.g:5646:2: (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )?
                    int alt103=2;
                    int LA103_0 = input.LA(1);

                    if ( (LA103_0==49) ) {
                        alt103=1;
                    }
                    switch (alt103) {
                        case 1 :
                            // InternalQVTcore.g:5646:4: otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) )
                            {
                            otherlv_4=(Token)match(input,49,FollowSets000.FOLLOW_17); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getNavigatingCommaArgCSAccess().getEqualsSignKeyword_2_0_2_0());
                                  
                            }
                            // InternalQVTcore.g:5650:1: ( (lv_ownedInitExpression_5_0= ruleExpCS ) )
                            // InternalQVTcore.g:5651:1: (lv_ownedInitExpression_5_0= ruleExpCS )
                            {
                            // InternalQVTcore.g:5651:1: (lv_ownedInitExpression_5_0= ruleExpCS )
                            // InternalQVTcore.g:5652:3: lv_ownedInitExpression_5_0= ruleExpCS
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
                    // InternalQVTcore.g:5669:6: (otherlv_6= 'in' ( (lv_ownedInitExpression_7_0= ruleExpCS ) ) )
                    {
                    // InternalQVTcore.g:5669:6: (otherlv_6= 'in' ( (lv_ownedInitExpression_7_0= ruleExpCS ) ) )
                    // InternalQVTcore.g:5669:8: otherlv_6= 'in' ( (lv_ownedInitExpression_7_0= ruleExpCS ) )
                    {
                    otherlv_6=(Token)match(input,18,FollowSets000.FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getNavigatingCommaArgCSAccess().getInKeyword_2_1_0());
                          
                    }
                    // InternalQVTcore.g:5673:1: ( (lv_ownedInitExpression_7_0= ruleExpCS ) )
                    // InternalQVTcore.g:5674:1: (lv_ownedInitExpression_7_0= ruleExpCS )
                    {
                    // InternalQVTcore.g:5674:1: (lv_ownedInitExpression_7_0= ruleExpCS )
                    // InternalQVTcore.g:5675:3: lv_ownedInitExpression_7_0= ruleExpCS
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
    // InternalQVTcore.g:5699:1: entryRuleNavigatingSemiArgCS returns [EObject current=null] : iv_ruleNavigatingSemiArgCS= ruleNavigatingSemiArgCS EOF ;
    public final EObject entryRuleNavigatingSemiArgCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingSemiArgCS = null;


        try {
            // InternalQVTcore.g:5700:2: (iv_ruleNavigatingSemiArgCS= ruleNavigatingSemiArgCS EOF )
            // InternalQVTcore.g:5701:2: iv_ruleNavigatingSemiArgCS= ruleNavigatingSemiArgCS EOF
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
    // InternalQVTcore.g:5708:1: ruleNavigatingSemiArgCS returns [EObject current=null] : ( ( (lv_prefix_0_0= ';' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )? ) ;
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
            // InternalQVTcore.g:5711:28: ( ( ( (lv_prefix_0_0= ';' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )? ) )
            // InternalQVTcore.g:5712:1: ( ( (lv_prefix_0_0= ';' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )? )
            {
            // InternalQVTcore.g:5712:1: ( ( (lv_prefix_0_0= ';' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )? )
            // InternalQVTcore.g:5712:2: ( (lv_prefix_0_0= ';' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )?
            {
            // InternalQVTcore.g:5712:2: ( (lv_prefix_0_0= ';' ) )
            // InternalQVTcore.g:5713:1: (lv_prefix_0_0= ';' )
            {
            // InternalQVTcore.g:5713:1: (lv_prefix_0_0= ';' )
            // InternalQVTcore.g:5714:3: lv_prefix_0_0= ';'
            {
            lv_prefix_0_0=(Token)match(input,33,FollowSets000.FOLLOW_17); if (state.failed) return current;
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

            // InternalQVTcore.g:5727:2: ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) )
            // InternalQVTcore.g:5728:1: (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS )
            {
            // InternalQVTcore.g:5728:1: (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS )
            // InternalQVTcore.g:5729:3: lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNavigatingSemiArgCSAccess().getOwnedNameExpressionNavigatingArgExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_67);
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

            // InternalQVTcore.g:5745:2: (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )?
            int alt106=2;
            int LA106_0 = input.LA(1);

            if ( (LA106_0==29) ) {
                alt106=1;
            }
            switch (alt106) {
                case 1 :
                    // InternalQVTcore.g:5745:4: otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )?
                    {
                    otherlv_2=(Token)match(input,29,FollowSets000.FOLLOW_26); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getNavigatingSemiArgCSAccess().getColonKeyword_2_0());
                          
                    }
                    // InternalQVTcore.g:5749:1: ( (lv_ownedType_3_0= ruleTypeExpCS ) )
                    // InternalQVTcore.g:5750:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    {
                    // InternalQVTcore.g:5750:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    // InternalQVTcore.g:5751:3: lv_ownedType_3_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingSemiArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_66);
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

                    // InternalQVTcore.g:5767:2: (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )?
                    int alt105=2;
                    int LA105_0 = input.LA(1);

                    if ( (LA105_0==49) ) {
                        alt105=1;
                    }
                    switch (alt105) {
                        case 1 :
                            // InternalQVTcore.g:5767:4: otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) )
                            {
                            otherlv_4=(Token)match(input,49,FollowSets000.FOLLOW_17); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getNavigatingSemiArgCSAccess().getEqualsSignKeyword_2_2_0());
                                  
                            }
                            // InternalQVTcore.g:5771:1: ( (lv_ownedInitExpression_5_0= ruleExpCS ) )
                            // InternalQVTcore.g:5772:1: (lv_ownedInitExpression_5_0= ruleExpCS )
                            {
                            // InternalQVTcore.g:5772:1: (lv_ownedInitExpression_5_0= ruleExpCS )
                            // InternalQVTcore.g:5773:3: lv_ownedInitExpression_5_0= ruleExpCS
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
    // InternalQVTcore.g:5797:1: entryRuleNavigatingArgExpCS returns [EObject current=null] : iv_ruleNavigatingArgExpCS= ruleNavigatingArgExpCS EOF ;
    public final EObject entryRuleNavigatingArgExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingArgExpCS = null;


        try {
            // InternalQVTcore.g:5798:2: (iv_ruleNavigatingArgExpCS= ruleNavigatingArgExpCS EOF )
            // InternalQVTcore.g:5799:2: iv_ruleNavigatingArgExpCS= ruleNavigatingArgExpCS EOF
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
    // InternalQVTcore.g:5806:1: ruleNavigatingArgExpCS returns [EObject current=null] : this_ExpCS_0= ruleExpCS ;
    public final EObject ruleNavigatingArgExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_ExpCS_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTcore.g:5809:28: (this_ExpCS_0= ruleExpCS )
            // InternalQVTcore.g:5811:2: this_ExpCS_0= ruleExpCS
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
    // InternalQVTcore.g:5830:1: entryRuleIfExpCS returns [EObject current=null] : iv_ruleIfExpCS= ruleIfExpCS EOF ;
    public final EObject entryRuleIfExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfExpCS = null;


        try {
            // InternalQVTcore.g:5831:2: (iv_ruleIfExpCS= ruleIfExpCS EOF )
            // InternalQVTcore.g:5832:2: iv_ruleIfExpCS= ruleIfExpCS EOF
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
    // InternalQVTcore.g:5839:1: ruleIfExpCS returns [EObject current=null] : (otherlv_0= 'if' ( ( (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS ) ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) ( (lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS ) )* otherlv_5= 'else' ( (lv_ownedElseExpression_6_0= ruleExpCS ) ) otherlv_7= 'endif' ) ;
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
            // InternalQVTcore.g:5842:28: ( (otherlv_0= 'if' ( ( (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS ) ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) ( (lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS ) )* otherlv_5= 'else' ( (lv_ownedElseExpression_6_0= ruleExpCS ) ) otherlv_7= 'endif' ) )
            // InternalQVTcore.g:5843:1: (otherlv_0= 'if' ( ( (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS ) ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) ( (lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS ) )* otherlv_5= 'else' ( (lv_ownedElseExpression_6_0= ruleExpCS ) ) otherlv_7= 'endif' )
            {
            // InternalQVTcore.g:5843:1: (otherlv_0= 'if' ( ( (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS ) ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) ( (lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS ) )* otherlv_5= 'else' ( (lv_ownedElseExpression_6_0= ruleExpCS ) ) otherlv_7= 'endif' )
            // InternalQVTcore.g:5843:3: otherlv_0= 'if' ( ( (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS ) ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) ( (lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS ) )* otherlv_5= 'else' ( (lv_ownedElseExpression_6_0= ruleExpCS ) ) otherlv_7= 'endif'
            {
            otherlv_0=(Token)match(input,86,FollowSets000.FOLLOW_44); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getIfExpCSAccess().getIfKeyword_0());
                  
            }
            // InternalQVTcore.g:5847:1: ( ( (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS ) ) )
            // InternalQVTcore.g:5848:1: ( (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS ) )
            {
            // InternalQVTcore.g:5848:1: ( (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS ) )
            // InternalQVTcore.g:5849:1: (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS )
            {
            // InternalQVTcore.g:5849:1: (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS )
            int alt107=2;
            alt107 = dfa107.predict(input);
            switch (alt107) {
                case 1 :
                    // InternalQVTcore.g:5850:3: lv_ownedCondition_1_1= ruleExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getIfExpCSAccess().getOwnedConditionExpCSParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_68);
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
                    // InternalQVTcore.g:5865:8: lv_ownedCondition_1_2= rulePatternExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getIfExpCSAccess().getOwnedConditionPatternExpCSParserRuleCall_1_0_1()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_68);
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

            otherlv_2=(Token)match(input,87,FollowSets000.FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getIfExpCSAccess().getThenKeyword_2());
                  
            }
            // InternalQVTcore.g:5887:1: ( (lv_ownedThenExpression_3_0= ruleExpCS ) )
            // InternalQVTcore.g:5888:1: (lv_ownedThenExpression_3_0= ruleExpCS )
            {
            // InternalQVTcore.g:5888:1: (lv_ownedThenExpression_3_0= ruleExpCS )
            // InternalQVTcore.g:5889:3: lv_ownedThenExpression_3_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIfExpCSAccess().getOwnedThenExpressionExpCSParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_69);
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

            // InternalQVTcore.g:5905:2: ( (lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS ) )*
            loop108:
            do {
                int alt108=2;
                int LA108_0 = input.LA(1);

                if ( (LA108_0==90) ) {
                    alt108=1;
                }


                switch (alt108) {
            	case 1 :
            	    // InternalQVTcore.g:5906:1: (lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS )
            	    {
            	    // InternalQVTcore.g:5906:1: (lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS )
            	    // InternalQVTcore.g:5907:3: lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getIfExpCSAccess().getOwnedIfThenExpressionsElseIfThenExpCSParserRuleCall_4_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_69);
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
            	    break loop108;
                }
            } while (true);

            otherlv_5=(Token)match(input,88,FollowSets000.FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getIfExpCSAccess().getElseKeyword_5());
                  
            }
            // InternalQVTcore.g:5927:1: ( (lv_ownedElseExpression_6_0= ruleExpCS ) )
            // InternalQVTcore.g:5928:1: (lv_ownedElseExpression_6_0= ruleExpCS )
            {
            // InternalQVTcore.g:5928:1: (lv_ownedElseExpression_6_0= ruleExpCS )
            // InternalQVTcore.g:5929:3: lv_ownedElseExpression_6_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIfExpCSAccess().getOwnedElseExpressionExpCSParserRuleCall_6_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_70);
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

            otherlv_7=(Token)match(input,89,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
    // InternalQVTcore.g:5957:1: entryRuleElseIfThenExpCS returns [EObject current=null] : iv_ruleElseIfThenExpCS= ruleElseIfThenExpCS EOF ;
    public final EObject entryRuleElseIfThenExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElseIfThenExpCS = null;


        try {
            // InternalQVTcore.g:5958:2: (iv_ruleElseIfThenExpCS= ruleElseIfThenExpCS EOF )
            // InternalQVTcore.g:5959:2: iv_ruleElseIfThenExpCS= ruleElseIfThenExpCS EOF
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
    // InternalQVTcore.g:5966:1: ruleElseIfThenExpCS returns [EObject current=null] : (otherlv_0= 'elseif' ( (lv_ownedCondition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) ) ;
    public final EObject ruleElseIfThenExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_ownedCondition_1_0 = null;

        EObject lv_ownedThenExpression_3_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTcore.g:5969:28: ( (otherlv_0= 'elseif' ( (lv_ownedCondition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) ) )
            // InternalQVTcore.g:5970:1: (otherlv_0= 'elseif' ( (lv_ownedCondition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) )
            {
            // InternalQVTcore.g:5970:1: (otherlv_0= 'elseif' ( (lv_ownedCondition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) )
            // InternalQVTcore.g:5970:3: otherlv_0= 'elseif' ( (lv_ownedCondition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) )
            {
            otherlv_0=(Token)match(input,90,FollowSets000.FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getElseIfThenExpCSAccess().getElseifKeyword_0());
                  
            }
            // InternalQVTcore.g:5974:1: ( (lv_ownedCondition_1_0= ruleExpCS ) )
            // InternalQVTcore.g:5975:1: (lv_ownedCondition_1_0= ruleExpCS )
            {
            // InternalQVTcore.g:5975:1: (lv_ownedCondition_1_0= ruleExpCS )
            // InternalQVTcore.g:5976:3: lv_ownedCondition_1_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getElseIfThenExpCSAccess().getOwnedConditionExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_68);
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

            otherlv_2=(Token)match(input,87,FollowSets000.FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getElseIfThenExpCSAccess().getThenKeyword_2());
                  
            }
            // InternalQVTcore.g:5996:1: ( (lv_ownedThenExpression_3_0= ruleExpCS ) )
            // InternalQVTcore.g:5997:1: (lv_ownedThenExpression_3_0= ruleExpCS )
            {
            // InternalQVTcore.g:5997:1: (lv_ownedThenExpression_3_0= ruleExpCS )
            // InternalQVTcore.g:5998:3: lv_ownedThenExpression_3_0= ruleExpCS
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
    // InternalQVTcore.g:6022:1: entryRuleLetExpCS returns [EObject current=null] : iv_ruleLetExpCS= ruleLetExpCS EOF ;
    public final EObject entryRuleLetExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLetExpCS = null;


        try {
            // InternalQVTcore.g:6023:2: (iv_ruleLetExpCS= ruleLetExpCS EOF )
            // InternalQVTcore.g:6024:2: iv_ruleLetExpCS= ruleLetExpCS EOF
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
    // InternalQVTcore.g:6031:1: ruleLetExpCS returns [EObject current=null] : (otherlv_0= 'let' ( (lv_ownedVariables_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_ownedVariables_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_ownedInExpression_5_0= ruleExpCS ) ) ) ;
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
            // InternalQVTcore.g:6034:28: ( (otherlv_0= 'let' ( (lv_ownedVariables_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_ownedVariables_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_ownedInExpression_5_0= ruleExpCS ) ) ) )
            // InternalQVTcore.g:6035:1: (otherlv_0= 'let' ( (lv_ownedVariables_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_ownedVariables_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_ownedInExpression_5_0= ruleExpCS ) ) )
            {
            // InternalQVTcore.g:6035:1: (otherlv_0= 'let' ( (lv_ownedVariables_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_ownedVariables_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_ownedInExpression_5_0= ruleExpCS ) ) )
            // InternalQVTcore.g:6035:3: otherlv_0= 'let' ( (lv_ownedVariables_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_ownedVariables_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_ownedInExpression_5_0= ruleExpCS ) )
            {
            otherlv_0=(Token)match(input,91,FollowSets000.FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLetExpCSAccess().getLetKeyword_0());
                  
            }
            // InternalQVTcore.g:6039:1: ( (lv_ownedVariables_1_0= ruleLetVariableCS ) )
            // InternalQVTcore.g:6040:1: (lv_ownedVariables_1_0= ruleLetVariableCS )
            {
            // InternalQVTcore.g:6040:1: (lv_ownedVariables_1_0= ruleLetVariableCS )
            // InternalQVTcore.g:6041:3: lv_ownedVariables_1_0= ruleLetVariableCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetExpCSAccess().getOwnedVariablesLetVariableCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_71);
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

            // InternalQVTcore.g:6057:2: (otherlv_2= ',' ( (lv_ownedVariables_3_0= ruleLetVariableCS ) ) )*
            loop109:
            do {
                int alt109=2;
                int LA109_0 = input.LA(1);

                if ( (LA109_0==20) ) {
                    alt109=1;
                }


                switch (alt109) {
            	case 1 :
            	    // InternalQVTcore.g:6057:4: otherlv_2= ',' ( (lv_ownedVariables_3_0= ruleLetVariableCS ) )
            	    {
            	    otherlv_2=(Token)match(input,20,FollowSets000.FOLLOW_8); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getLetExpCSAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // InternalQVTcore.g:6061:1: ( (lv_ownedVariables_3_0= ruleLetVariableCS ) )
            	    // InternalQVTcore.g:6062:1: (lv_ownedVariables_3_0= ruleLetVariableCS )
            	    {
            	    // InternalQVTcore.g:6062:1: (lv_ownedVariables_3_0= ruleLetVariableCS )
            	    // InternalQVTcore.g:6063:3: lv_ownedVariables_3_0= ruleLetVariableCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLetExpCSAccess().getOwnedVariablesLetVariableCSParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_71);
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
            	    break loop109;
                }
            } while (true);

            otherlv_4=(Token)match(input,18,FollowSets000.FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getLetExpCSAccess().getInKeyword_3());
                  
            }
            // InternalQVTcore.g:6083:1: ( (lv_ownedInExpression_5_0= ruleExpCS ) )
            // InternalQVTcore.g:6084:1: (lv_ownedInExpression_5_0= ruleExpCS )
            {
            // InternalQVTcore.g:6084:1: (lv_ownedInExpression_5_0= ruleExpCS )
            // InternalQVTcore.g:6085:3: lv_ownedInExpression_5_0= ruleExpCS
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
    // InternalQVTcore.g:6109:1: entryRuleLetVariableCS returns [EObject current=null] : iv_ruleLetVariableCS= ruleLetVariableCS EOF ;
    public final EObject entryRuleLetVariableCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLetVariableCS = null;


        try {
            // InternalQVTcore.g:6110:2: (iv_ruleLetVariableCS= ruleLetVariableCS EOF )
            // InternalQVTcore.g:6111:2: iv_ruleLetVariableCS= ruleLetVariableCS EOF
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
    // InternalQVTcore.g:6118:1: ruleLetVariableCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) ( (lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS ) )? (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )? otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) ) ;
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
            // InternalQVTcore.g:6121:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) ( (lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS ) )? (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )? otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) ) )
            // InternalQVTcore.g:6122:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) ( (lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS ) )? (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )? otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )
            {
            // InternalQVTcore.g:6122:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) ( (lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS ) )? (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )? otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )
            // InternalQVTcore.g:6122:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) ( (lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS ) )? (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )? otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) )
            {
            // InternalQVTcore.g:6122:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // InternalQVTcore.g:6123:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // InternalQVTcore.g:6123:1: (lv_name_0_0= ruleUnrestrictedName )
            // InternalQVTcore.g:6124:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetVariableCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_72);
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
                      		"org.eclipse.qvtd.xtext.qvtcorebase.QVTcoreBase.UnrestrictedName");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalQVTcore.g:6140:2: ( (lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS ) )?
            int alt110=2;
            int LA110_0 = input.LA(1);

            if ( (LA110_0==27) ) {
                alt110=1;
            }
            switch (alt110) {
                case 1 :
                    // InternalQVTcore.g:6141:1: (lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS )
                    {
                    // InternalQVTcore.g:6141:1: (lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS )
                    // InternalQVTcore.g:6142:3: lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLetVariableCSAccess().getOwnedRoundBracketedClauseRoundBracketedClauseCSParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_50);
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

            // InternalQVTcore.g:6158:3: (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )?
            int alt111=2;
            int LA111_0 = input.LA(1);

            if ( (LA111_0==29) ) {
                alt111=1;
            }
            switch (alt111) {
                case 1 :
                    // InternalQVTcore.g:6158:5: otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) )
                    {
                    otherlv_2=(Token)match(input,29,FollowSets000.FOLLOW_26); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getLetVariableCSAccess().getColonKeyword_2_0());
                          
                    }
                    // InternalQVTcore.g:6162:1: ( (lv_ownedType_3_0= ruleTypeExpCS ) )
                    // InternalQVTcore.g:6163:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    {
                    // InternalQVTcore.g:6163:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    // InternalQVTcore.g:6164:3: lv_ownedType_3_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLetVariableCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_48);
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

            otherlv_4=(Token)match(input,49,FollowSets000.FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getLetVariableCSAccess().getEqualsSignKeyword_3());
                  
            }
            // InternalQVTcore.g:6184:1: ( (lv_ownedInitExpression_5_0= ruleExpCS ) )
            // InternalQVTcore.g:6185:1: (lv_ownedInitExpression_5_0= ruleExpCS )
            {
            // InternalQVTcore.g:6185:1: (lv_ownedInitExpression_5_0= ruleExpCS )
            // InternalQVTcore.g:6186:3: lv_ownedInitExpression_5_0= ruleExpCS
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
    // InternalQVTcore.g:6210:1: entryRuleNestedExpCS returns [EObject current=null] : iv_ruleNestedExpCS= ruleNestedExpCS EOF ;
    public final EObject entryRuleNestedExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNestedExpCS = null;


        try {
            // InternalQVTcore.g:6211:2: (iv_ruleNestedExpCS= ruleNestedExpCS EOF )
            // InternalQVTcore.g:6212:2: iv_ruleNestedExpCS= ruleNestedExpCS EOF
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
    // InternalQVTcore.g:6219:1: ruleNestedExpCS returns [EObject current=null] : (otherlv_0= '(' ( (lv_ownedExpression_1_0= ruleExpCS ) ) otherlv_2= ')' ) ;
    public final EObject ruleNestedExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_ownedExpression_1_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTcore.g:6222:28: ( (otherlv_0= '(' ( (lv_ownedExpression_1_0= ruleExpCS ) ) otherlv_2= ')' ) )
            // InternalQVTcore.g:6223:1: (otherlv_0= '(' ( (lv_ownedExpression_1_0= ruleExpCS ) ) otherlv_2= ')' )
            {
            // InternalQVTcore.g:6223:1: (otherlv_0= '(' ( (lv_ownedExpression_1_0= ruleExpCS ) ) otherlv_2= ')' )
            // InternalQVTcore.g:6223:3: otherlv_0= '(' ( (lv_ownedExpression_1_0= ruleExpCS ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,27,FollowSets000.FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getNestedExpCSAccess().getLeftParenthesisKeyword_0());
                  
            }
            // InternalQVTcore.g:6227:1: ( (lv_ownedExpression_1_0= ruleExpCS ) )
            // InternalQVTcore.g:6228:1: (lv_ownedExpression_1_0= ruleExpCS )
            {
            // InternalQVTcore.g:6228:1: (lv_ownedExpression_1_0= ruleExpCS )
            // InternalQVTcore.g:6229:3: lv_ownedExpression_1_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNestedExpCSAccess().getOwnedExpressionExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_24);
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

            otherlv_2=(Token)match(input,28,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
    // InternalQVTcore.g:6257:1: entryRuleSelfExpCS returns [EObject current=null] : iv_ruleSelfExpCS= ruleSelfExpCS EOF ;
    public final EObject entryRuleSelfExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelfExpCS = null;


        try {
            // InternalQVTcore.g:6258:2: (iv_ruleSelfExpCS= ruleSelfExpCS EOF )
            // InternalQVTcore.g:6259:2: iv_ruleSelfExpCS= ruleSelfExpCS EOF
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
    // InternalQVTcore.g:6266:1: ruleSelfExpCS returns [EObject current=null] : ( () otherlv_1= 'self' ) ;
    public final EObject ruleSelfExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // InternalQVTcore.g:6269:28: ( ( () otherlv_1= 'self' ) )
            // InternalQVTcore.g:6270:1: ( () otherlv_1= 'self' )
            {
            // InternalQVTcore.g:6270:1: ( () otherlv_1= 'self' )
            // InternalQVTcore.g:6270:2: () otherlv_1= 'self'
            {
            // InternalQVTcore.g:6270:2: ()
            // InternalQVTcore.g:6271:2: 
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

            otherlv_1=(Token)match(input,92,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
    // InternalQVTcore.g:6291:1: entryRuleMultiplicityBoundsCS returns [EObject current=null] : iv_ruleMultiplicityBoundsCS= ruleMultiplicityBoundsCS EOF ;
    public final EObject entryRuleMultiplicityBoundsCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicityBoundsCS = null;


        try {
            // InternalQVTcore.g:6292:2: (iv_ruleMultiplicityBoundsCS= ruleMultiplicityBoundsCS EOF )
            // InternalQVTcore.g:6293:2: iv_ruleMultiplicityBoundsCS= ruleMultiplicityBoundsCS EOF
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
    // InternalQVTcore.g:6300:1: ruleMultiplicityBoundsCS returns [EObject current=null] : ( ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )? ) ;
    public final EObject ruleMultiplicityBoundsCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_lowerBound_0_0 = null;

        AntlrDatatypeRuleToken lv_upperBound_2_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTcore.g:6303:28: ( ( ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )? ) )
            // InternalQVTcore.g:6304:1: ( ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )? )
            {
            // InternalQVTcore.g:6304:1: ( ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )? )
            // InternalQVTcore.g:6304:2: ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )?
            {
            // InternalQVTcore.g:6304:2: ( (lv_lowerBound_0_0= ruleLOWER ) )
            // InternalQVTcore.g:6305:1: (lv_lowerBound_0_0= ruleLOWER )
            {
            // InternalQVTcore.g:6305:1: (lv_lowerBound_0_0= ruleLOWER )
            // InternalQVTcore.g:6306:3: lv_lowerBound_0_0= ruleLOWER
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiplicityBoundsCSAccess().getLowerBoundLOWERParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_45);
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

            // InternalQVTcore.g:6322:2: (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )?
            int alt112=2;
            int LA112_0 = input.LA(1);

            if ( (LA112_0==74) ) {
                alt112=1;
            }
            switch (alt112) {
                case 1 :
                    // InternalQVTcore.g:6322:4: otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) )
                    {
                    otherlv_1=(Token)match(input,74,FollowSets000.FOLLOW_73); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getMultiplicityBoundsCSAccess().getFullStopFullStopKeyword_1_0());
                          
                    }
                    // InternalQVTcore.g:6326:1: ( (lv_upperBound_2_0= ruleUPPER ) )
                    // InternalQVTcore.g:6327:1: (lv_upperBound_2_0= ruleUPPER )
                    {
                    // InternalQVTcore.g:6327:1: (lv_upperBound_2_0= ruleUPPER )
                    // InternalQVTcore.g:6328:3: lv_upperBound_2_0= ruleUPPER
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
    // InternalQVTcore.g:6352:1: entryRuleMultiplicityCS returns [EObject current=null] : iv_ruleMultiplicityCS= ruleMultiplicityCS EOF ;
    public final EObject entryRuleMultiplicityCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicityCS = null;


        try {
            // InternalQVTcore.g:6353:2: (iv_ruleMultiplicityCS= ruleMultiplicityCS EOF )
            // InternalQVTcore.g:6354:2: iv_ruleMultiplicityCS= ruleMultiplicityCS EOF
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
    // InternalQVTcore.g:6361:1: ruleMultiplicityCS returns [EObject current=null] : (otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) (otherlv_3= '|?' | ( (lv_isNullFree_4_0= '|1' ) ) )? otherlv_5= ']' ) ;
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
            // InternalQVTcore.g:6364:28: ( (otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) (otherlv_3= '|?' | ( (lv_isNullFree_4_0= '|1' ) ) )? otherlv_5= ']' ) )
            // InternalQVTcore.g:6365:1: (otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) (otherlv_3= '|?' | ( (lv_isNullFree_4_0= '|1' ) ) )? otherlv_5= ']' )
            {
            // InternalQVTcore.g:6365:1: (otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) (otherlv_3= '|?' | ( (lv_isNullFree_4_0= '|1' ) ) )? otherlv_5= ']' )
            // InternalQVTcore.g:6365:3: otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) (otherlv_3= '|?' | ( (lv_isNullFree_4_0= '|1' ) ) )? otherlv_5= ']'
            {
            otherlv_0=(Token)match(input,84,FollowSets000.FOLLOW_74); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMultiplicityCSAccess().getLeftSquareBracketKeyword_0());
                  
            }
            // InternalQVTcore.g:6369:1: (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS )
            int alt113=2;
            int LA113_0 = input.LA(1);

            if ( (LA113_0==RULE_INT) ) {
                alt113=1;
            }
            else if ( (LA113_0==32||LA113_0==44||LA113_0==95) ) {
                alt113=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 113, 0, input);

                throw nvae;
            }
            switch (alt113) {
                case 1 :
                    // InternalQVTcore.g:6370:2: this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getMultiplicityCSAccess().getMultiplicityBoundsCSParserRuleCall_1_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_75);
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
                    // InternalQVTcore.g:6383:2: this_MultiplicityStringCS_2= ruleMultiplicityStringCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getMultiplicityCSAccess().getMultiplicityStringCSParserRuleCall_1_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_75);
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

            // InternalQVTcore.g:6394:2: (otherlv_3= '|?' | ( (lv_isNullFree_4_0= '|1' ) ) )?
            int alt114=3;
            int LA114_0 = input.LA(1);

            if ( (LA114_0==93) ) {
                alt114=1;
            }
            else if ( (LA114_0==94) ) {
                alt114=2;
            }
            switch (alt114) {
                case 1 :
                    // InternalQVTcore.g:6394:4: otherlv_3= '|?'
                    {
                    otherlv_3=(Token)match(input,93,FollowSets000.FOLLOW_76); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getMultiplicityCSAccess().getVerticalLineQuestionMarkKeyword_2_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalQVTcore.g:6399:6: ( (lv_isNullFree_4_0= '|1' ) )
                    {
                    // InternalQVTcore.g:6399:6: ( (lv_isNullFree_4_0= '|1' ) )
                    // InternalQVTcore.g:6400:1: (lv_isNullFree_4_0= '|1' )
                    {
                    // InternalQVTcore.g:6400:1: (lv_isNullFree_4_0= '|1' )
                    // InternalQVTcore.g:6401:3: lv_isNullFree_4_0= '|1'
                    {
                    lv_isNullFree_4_0=(Token)match(input,94,FollowSets000.FOLLOW_76); if (state.failed) return current;
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

            otherlv_5=(Token)match(input,85,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
    // InternalQVTcore.g:6426:1: entryRuleMultiplicityStringCS returns [EObject current=null] : iv_ruleMultiplicityStringCS= ruleMultiplicityStringCS EOF ;
    public final EObject entryRuleMultiplicityStringCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicityStringCS = null;


        try {
            // InternalQVTcore.g:6427:2: (iv_ruleMultiplicityStringCS= ruleMultiplicityStringCS EOF )
            // InternalQVTcore.g:6428:2: iv_ruleMultiplicityStringCS= ruleMultiplicityStringCS EOF
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
    // InternalQVTcore.g:6435:1: ruleMultiplicityStringCS returns [EObject current=null] : ( ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) ) ) ;
    public final EObject ruleMultiplicityStringCS() throws RecognitionException {
        EObject current = null;

        Token lv_stringBounds_0_1=null;
        Token lv_stringBounds_0_2=null;
        Token lv_stringBounds_0_3=null;

         enterRule(); 
            
        try {
            // InternalQVTcore.g:6438:28: ( ( ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) ) ) )
            // InternalQVTcore.g:6439:1: ( ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) ) )
            {
            // InternalQVTcore.g:6439:1: ( ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) ) )
            // InternalQVTcore.g:6440:1: ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) )
            {
            // InternalQVTcore.g:6440:1: ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) )
            // InternalQVTcore.g:6441:1: (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' )
            {
            // InternalQVTcore.g:6441:1: (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' )
            int alt115=3;
            switch ( input.LA(1) ) {
            case 32:
                {
                alt115=1;
                }
                break;
            case 44:
                {
                alt115=2;
                }
                break;
            case 95:
                {
                alt115=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 115, 0, input);

                throw nvae;
            }

            switch (alt115) {
                case 1 :
                    // InternalQVTcore.g:6442:3: lv_stringBounds_0_1= '*'
                    {
                    lv_stringBounds_0_1=(Token)match(input,32,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
                    // InternalQVTcore.g:6454:8: lv_stringBounds_0_2= '+'
                    {
                    lv_stringBounds_0_2=(Token)match(input,44,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
                    // InternalQVTcore.g:6466:8: lv_stringBounds_0_3= '?'
                    {
                    lv_stringBounds_0_3=(Token)match(input,95,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
    // InternalQVTcore.g:6489:1: entryRulePathNameCS returns [EObject current=null] : iv_rulePathNameCS= rulePathNameCS EOF ;
    public final EObject entryRulePathNameCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePathNameCS = null;


        try {
            // InternalQVTcore.g:6490:2: (iv_rulePathNameCS= rulePathNameCS EOF )
            // InternalQVTcore.g:6491:2: iv_rulePathNameCS= rulePathNameCS EOF
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
    // InternalQVTcore.g:6498:1: rulePathNameCS returns [EObject current=null] : ( ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )* ) ;
    public final EObject rulePathNameCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_ownedPathElements_0_0 = null;

        EObject lv_ownedPathElements_2_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTcore.g:6501:28: ( ( ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )* ) )
            // InternalQVTcore.g:6502:1: ( ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )* )
            {
            // InternalQVTcore.g:6502:1: ( ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )* )
            // InternalQVTcore.g:6502:2: ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )*
            {
            // InternalQVTcore.g:6502:2: ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) )
            // InternalQVTcore.g:6503:1: (lv_ownedPathElements_0_0= ruleFirstPathElementCS )
            {
            // InternalQVTcore.g:6503:1: (lv_ownedPathElements_0_0= ruleFirstPathElementCS )
            // InternalQVTcore.g:6504:3: lv_ownedPathElements_0_0= ruleFirstPathElementCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPathNameCSAccess().getOwnedPathElementsFirstPathElementCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_40);
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

            // InternalQVTcore.g:6520:2: (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )*
            loop116:
            do {
                int alt116=2;
                int LA116_0 = input.LA(1);

                if ( (LA116_0==31) ) {
                    alt116=1;
                }


                switch (alt116) {
            	case 1 :
            	    // InternalQVTcore.g:6520:4: otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) )
            	    {
            	    otherlv_1=(Token)match(input,31,FollowSets000.FOLLOW_26); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getPathNameCSAccess().getColonColonKeyword_1_0());
            	          
            	    }
            	    // InternalQVTcore.g:6524:1: ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) )
            	    // InternalQVTcore.g:6525:1: (lv_ownedPathElements_2_0= ruleNextPathElementCS )
            	    {
            	    // InternalQVTcore.g:6525:1: (lv_ownedPathElements_2_0= ruleNextPathElementCS )
            	    // InternalQVTcore.g:6526:3: lv_ownedPathElements_2_0= ruleNextPathElementCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getPathNameCSAccess().getOwnedPathElementsNextPathElementCSParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_40);
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
            	    break loop116;
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
    // InternalQVTcore.g:6550:1: entryRuleFirstPathElementCS returns [EObject current=null] : iv_ruleFirstPathElementCS= ruleFirstPathElementCS EOF ;
    public final EObject entryRuleFirstPathElementCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFirstPathElementCS = null;


        try {
            // InternalQVTcore.g:6551:2: (iv_ruleFirstPathElementCS= ruleFirstPathElementCS EOF )
            // InternalQVTcore.g:6552:2: iv_ruleFirstPathElementCS= ruleFirstPathElementCS EOF
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
    // InternalQVTcore.g:6559:1: ruleFirstPathElementCS returns [EObject current=null] : ( ( ruleUnrestrictedName ) ) ;
    public final EObject ruleFirstPathElementCS() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // InternalQVTcore.g:6562:28: ( ( ( ruleUnrestrictedName ) ) )
            // InternalQVTcore.g:6563:1: ( ( ruleUnrestrictedName ) )
            {
            // InternalQVTcore.g:6563:1: ( ( ruleUnrestrictedName ) )
            // InternalQVTcore.g:6564:1: ( ruleUnrestrictedName )
            {
            // InternalQVTcore.g:6564:1: ( ruleUnrestrictedName )
            // InternalQVTcore.g:6565:3: ruleUnrestrictedName
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
    // InternalQVTcore.g:6589:1: entryRuleNextPathElementCS returns [EObject current=null] : iv_ruleNextPathElementCS= ruleNextPathElementCS EOF ;
    public final EObject entryRuleNextPathElementCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNextPathElementCS = null;


        try {
            // InternalQVTcore.g:6590:2: (iv_ruleNextPathElementCS= ruleNextPathElementCS EOF )
            // InternalQVTcore.g:6591:2: iv_ruleNextPathElementCS= ruleNextPathElementCS EOF
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
    // InternalQVTcore.g:6598:1: ruleNextPathElementCS returns [EObject current=null] : ( ( ruleUnreservedName ) ) ;
    public final EObject ruleNextPathElementCS() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // InternalQVTcore.g:6601:28: ( ( ( ruleUnreservedName ) ) )
            // InternalQVTcore.g:6602:1: ( ( ruleUnreservedName ) )
            {
            // InternalQVTcore.g:6602:1: ( ( ruleUnreservedName ) )
            // InternalQVTcore.g:6603:1: ( ruleUnreservedName )
            {
            // InternalQVTcore.g:6603:1: ( ruleUnreservedName )
            // InternalQVTcore.g:6604:3: ruleUnreservedName
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
    // InternalQVTcore.g:6628:1: entryRuleTemplateBindingCS returns [EObject current=null] : iv_ruleTemplateBindingCS= ruleTemplateBindingCS EOF ;
    public final EObject entryRuleTemplateBindingCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTemplateBindingCS = null;


        try {
            // InternalQVTcore.g:6629:2: (iv_ruleTemplateBindingCS= ruleTemplateBindingCS EOF )
            // InternalQVTcore.g:6630:2: iv_ruleTemplateBindingCS= ruleTemplateBindingCS EOF
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
    // InternalQVTcore.g:6637:1: ruleTemplateBindingCS returns [EObject current=null] : ( ( (lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS ) ) (otherlv_1= ',' ( (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS ) ) )* ( (lv_ownedMultiplicity_3_0= ruleMultiplicityCS ) )? ) ;
    public final EObject ruleTemplateBindingCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_ownedSubstitutions_0_0 = null;

        EObject lv_ownedSubstitutions_2_0 = null;

        EObject lv_ownedMultiplicity_3_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTcore.g:6640:28: ( ( ( (lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS ) ) (otherlv_1= ',' ( (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS ) ) )* ( (lv_ownedMultiplicity_3_0= ruleMultiplicityCS ) )? ) )
            // InternalQVTcore.g:6641:1: ( ( (lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS ) ) (otherlv_1= ',' ( (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS ) ) )* ( (lv_ownedMultiplicity_3_0= ruleMultiplicityCS ) )? )
            {
            // InternalQVTcore.g:6641:1: ( ( (lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS ) ) (otherlv_1= ',' ( (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS ) ) )* ( (lv_ownedMultiplicity_3_0= ruleMultiplicityCS ) )? )
            // InternalQVTcore.g:6641:2: ( (lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS ) ) (otherlv_1= ',' ( (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS ) ) )* ( (lv_ownedMultiplicity_3_0= ruleMultiplicityCS ) )?
            {
            // InternalQVTcore.g:6641:2: ( (lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS ) )
            // InternalQVTcore.g:6642:1: (lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS )
            {
            // InternalQVTcore.g:6642:1: (lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS )
            // InternalQVTcore.g:6643:3: lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsTemplateParameterSubstitutionCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_77);
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

            // InternalQVTcore.g:6659:2: (otherlv_1= ',' ( (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS ) ) )*
            loop117:
            do {
                int alt117=2;
                int LA117_0 = input.LA(1);

                if ( (LA117_0==20) ) {
                    alt117=1;
                }


                switch (alt117) {
            	case 1 :
            	    // InternalQVTcore.g:6659:4: otherlv_1= ',' ( (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS ) )
            	    {
            	    otherlv_1=(Token)match(input,20,FollowSets000.FOLLOW_78); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getTemplateBindingCSAccess().getCommaKeyword_1_0());
            	          
            	    }
            	    // InternalQVTcore.g:6663:1: ( (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS ) )
            	    // InternalQVTcore.g:6664:1: (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS )
            	    {
            	    // InternalQVTcore.g:6664:1: (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS )
            	    // InternalQVTcore.g:6665:3: lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsTemplateParameterSubstitutionCSParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_77);
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
            	    break loop117;
                }
            } while (true);

            // InternalQVTcore.g:6681:4: ( (lv_ownedMultiplicity_3_0= ruleMultiplicityCS ) )?
            int alt118=2;
            int LA118_0 = input.LA(1);

            if ( (LA118_0==84) ) {
                alt118=1;
            }
            switch (alt118) {
                case 1 :
                    // InternalQVTcore.g:6682:1: (lv_ownedMultiplicity_3_0= ruleMultiplicityCS )
                    {
                    // InternalQVTcore.g:6682:1: (lv_ownedMultiplicity_3_0= ruleMultiplicityCS )
                    // InternalQVTcore.g:6683:3: lv_ownedMultiplicity_3_0= ruleMultiplicityCS
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
    // InternalQVTcore.g:6707:1: entryRuleTemplateParameterSubstitutionCS returns [EObject current=null] : iv_ruleTemplateParameterSubstitutionCS= ruleTemplateParameterSubstitutionCS EOF ;
    public final EObject entryRuleTemplateParameterSubstitutionCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTemplateParameterSubstitutionCS = null;


        try {
            // InternalQVTcore.g:6708:2: (iv_ruleTemplateParameterSubstitutionCS= ruleTemplateParameterSubstitutionCS EOF )
            // InternalQVTcore.g:6709:2: iv_ruleTemplateParameterSubstitutionCS= ruleTemplateParameterSubstitutionCS EOF
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
    // InternalQVTcore.g:6716:1: ruleTemplateParameterSubstitutionCS returns [EObject current=null] : ( (lv_ownedActualParameter_0_0= ruleTypeRefCS ) ) ;
    public final EObject ruleTemplateParameterSubstitutionCS() throws RecognitionException {
        EObject current = null;

        EObject lv_ownedActualParameter_0_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTcore.g:6719:28: ( ( (lv_ownedActualParameter_0_0= ruleTypeRefCS ) ) )
            // InternalQVTcore.g:6720:1: ( (lv_ownedActualParameter_0_0= ruleTypeRefCS ) )
            {
            // InternalQVTcore.g:6720:1: ( (lv_ownedActualParameter_0_0= ruleTypeRefCS ) )
            // InternalQVTcore.g:6721:1: (lv_ownedActualParameter_0_0= ruleTypeRefCS )
            {
            // InternalQVTcore.g:6721:1: (lv_ownedActualParameter_0_0= ruleTypeRefCS )
            // InternalQVTcore.g:6722:3: lv_ownedActualParameter_0_0= ruleTypeRefCS
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


    // $ANTLR start "entryRuleTypeParameterCS"
    // InternalQVTcore.g:6748:1: entryRuleTypeParameterCS returns [EObject current=null] : iv_ruleTypeParameterCS= ruleTypeParameterCS EOF ;
    public final EObject entryRuleTypeParameterCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeParameterCS = null;


        try {
            // InternalQVTcore.g:6749:2: (iv_ruleTypeParameterCS= ruleTypeParameterCS EOF )
            // InternalQVTcore.g:6750:2: iv_ruleTypeParameterCS= ruleTypeParameterCS EOF
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
    // InternalQVTcore.g:6757:1: ruleTypeParameterCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleTypedRefCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) ) )* )? ) ;
    public final EObject ruleTypeParameterCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedExtends_2_0 = null;

        EObject lv_ownedExtends_4_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTcore.g:6760:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleTypedRefCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) ) )* )? ) )
            // InternalQVTcore.g:6761:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleTypedRefCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) ) )* )? )
            {
            // InternalQVTcore.g:6761:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleTypedRefCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) ) )* )? )
            // InternalQVTcore.g:6761:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleTypedRefCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) ) )* )?
            {
            // InternalQVTcore.g:6761:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // InternalQVTcore.g:6762:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // InternalQVTcore.g:6762:1: (lv_name_0_0= ruleUnrestrictedName )
            // InternalQVTcore.g:6763:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypeParameterCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_79);
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
                      		"org.eclipse.qvtd.xtext.qvtcorebase.QVTcoreBase.UnrestrictedName");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalQVTcore.g:6779:2: (otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleTypedRefCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) ) )* )?
            int alt120=2;
            int LA120_0 = input.LA(1);

            if ( (LA120_0==96) ) {
                alt120=1;
            }
            switch (alt120) {
                case 1 :
                    // InternalQVTcore.g:6779:4: otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleTypedRefCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) ) )*
                    {
                    otherlv_1=(Token)match(input,96,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getTypeParameterCSAccess().getExtendsKeyword_1_0());
                          
                    }
                    // InternalQVTcore.g:6783:1: ( (lv_ownedExtends_2_0= ruleTypedRefCS ) )
                    // InternalQVTcore.g:6784:1: (lv_ownedExtends_2_0= ruleTypedRefCS )
                    {
                    // InternalQVTcore.g:6784:1: (lv_ownedExtends_2_0= ruleTypedRefCS )
                    // InternalQVTcore.g:6785:3: lv_ownedExtends_2_0= ruleTypedRefCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsTypedRefCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_80);
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

                    // InternalQVTcore.g:6801:2: (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) ) )*
                    loop119:
                    do {
                        int alt119=2;
                        int LA119_0 = input.LA(1);

                        if ( (LA119_0==97) ) {
                            alt119=1;
                        }


                        switch (alt119) {
                    	case 1 :
                    	    // InternalQVTcore.g:6801:4: otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) )
                    	    {
                    	    otherlv_3=(Token)match(input,97,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getTypeParameterCSAccess().getAmpersandAmpersandKeyword_1_2_0());
                    	          
                    	    }
                    	    // InternalQVTcore.g:6805:1: ( (lv_ownedExtends_4_0= ruleTypedRefCS ) )
                    	    // InternalQVTcore.g:6806:1: (lv_ownedExtends_4_0= ruleTypedRefCS )
                    	    {
                    	    // InternalQVTcore.g:6806:1: (lv_ownedExtends_4_0= ruleTypedRefCS )
                    	    // InternalQVTcore.g:6807:3: lv_ownedExtends_4_0= ruleTypedRefCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsTypedRefCSParserRuleCall_1_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_80);
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
                    	    break loop119;
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
    // InternalQVTcore.g:6831:1: entryRuleTypeRefCS returns [EObject current=null] : iv_ruleTypeRefCS= ruleTypeRefCS EOF ;
    public final EObject entryRuleTypeRefCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeRefCS = null;


        try {
            // InternalQVTcore.g:6832:2: (iv_ruleTypeRefCS= ruleTypeRefCS EOF )
            // InternalQVTcore.g:6833:2: iv_ruleTypeRefCS= ruleTypeRefCS EOF
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
    // InternalQVTcore.g:6840:1: ruleTypeRefCS returns [EObject current=null] : (this_TypedRefCS_0= ruleTypedRefCS | this_WildcardTypeRefCS_1= ruleWildcardTypeRefCS ) ;
    public final EObject ruleTypeRefCS() throws RecognitionException {
        EObject current = null;

        EObject this_TypedRefCS_0 = null;

        EObject this_WildcardTypeRefCS_1 = null;


         enterRule(); 
            
        try {
            // InternalQVTcore.g:6843:28: ( (this_TypedRefCS_0= ruleTypedRefCS | this_WildcardTypeRefCS_1= ruleWildcardTypeRefCS ) )
            // InternalQVTcore.g:6844:1: (this_TypedRefCS_0= ruleTypedRefCS | this_WildcardTypeRefCS_1= ruleWildcardTypeRefCS )
            {
            // InternalQVTcore.g:6844:1: (this_TypedRefCS_0= ruleTypedRefCS | this_WildcardTypeRefCS_1= ruleWildcardTypeRefCS )
            int alt121=2;
            int LA121_0 = input.LA(1);

            if ( ((LA121_0>=RULE_SIMPLE_ID && LA121_0<=RULE_ESCAPED_ID)||LA121_0==17||LA121_0==19||(LA121_0>=25 && LA121_0<=26)||LA121_0==30||(LA121_0>=34 && LA121_0<=35)||(LA121_0>=37 && LA121_0<=40)) ) {
                alt121=1;
            }
            else if ( (LA121_0==95) ) {
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
                    // InternalQVTcore.g:6845:2: this_TypedRefCS_0= ruleTypedRefCS
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
                    // InternalQVTcore.g:6858:2: this_WildcardTypeRefCS_1= ruleWildcardTypeRefCS
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
    // InternalQVTcore.g:6877:1: entryRuleTypedRefCS returns [EObject current=null] : iv_ruleTypedRefCS= ruleTypedRefCS EOF ;
    public final EObject entryRuleTypedRefCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypedRefCS = null;


        try {
            // InternalQVTcore.g:6878:2: (iv_ruleTypedRefCS= ruleTypedRefCS EOF )
            // InternalQVTcore.g:6879:2: iv_ruleTypedRefCS= ruleTypedRefCS EOF
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
    // InternalQVTcore.g:6886:1: ruleTypedRefCS returns [EObject current=null] : this_TypedTypeRefCS_0= ruleTypedTypeRefCS ;
    public final EObject ruleTypedRefCS() throws RecognitionException {
        EObject current = null;

        EObject this_TypedTypeRefCS_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTcore.g:6889:28: (this_TypedTypeRefCS_0= ruleTypedTypeRefCS )
            // InternalQVTcore.g:6891:2: this_TypedTypeRefCS_0= ruleTypedTypeRefCS
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
    // InternalQVTcore.g:6910:1: entryRuleTypedTypeRefCS returns [EObject current=null] : iv_ruleTypedTypeRefCS= ruleTypedTypeRefCS EOF ;
    public final EObject entryRuleTypedTypeRefCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypedTypeRefCS = null;


        try {
            // InternalQVTcore.g:6911:2: (iv_ruleTypedTypeRefCS= ruleTypedTypeRefCS EOF )
            // InternalQVTcore.g:6912:2: iv_ruleTypedTypeRefCS= ruleTypedTypeRefCS EOF
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
    // InternalQVTcore.g:6919:1: ruleTypedTypeRefCS returns [EObject current=null] : ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) (otherlv_1= '(' ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) ) otherlv_3= ')' )? ) ;
    public final EObject ruleTypedTypeRefCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_ownedPathName_0_0 = null;

        EObject lv_ownedBinding_2_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTcore.g:6922:28: ( ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) (otherlv_1= '(' ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) ) otherlv_3= ')' )? ) )
            // InternalQVTcore.g:6923:1: ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) (otherlv_1= '(' ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) ) otherlv_3= ')' )? )
            {
            // InternalQVTcore.g:6923:1: ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) (otherlv_1= '(' ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) ) otherlv_3= ')' )? )
            // InternalQVTcore.g:6923:2: ( (lv_ownedPathName_0_0= rulePathNameCS ) ) (otherlv_1= '(' ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) ) otherlv_3= ')' )?
            {
            // InternalQVTcore.g:6923:2: ( (lv_ownedPathName_0_0= rulePathNameCS ) )
            // InternalQVTcore.g:6924:1: (lv_ownedPathName_0_0= rulePathNameCS )
            {
            // InternalQVTcore.g:6924:1: (lv_ownedPathName_0_0= rulePathNameCS )
            // InternalQVTcore.g:6925:3: lv_ownedPathName_0_0= rulePathNameCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypedTypeRefCSAccess().getOwnedPathNamePathNameCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_41);
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

            // InternalQVTcore.g:6941:2: (otherlv_1= '(' ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) ) otherlv_3= ')' )?
            int alt122=2;
            int LA122_0 = input.LA(1);

            if ( (LA122_0==27) ) {
                alt122=1;
            }
            switch (alt122) {
                case 1 :
                    // InternalQVTcore.g:6941:4: otherlv_1= '(' ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) ) otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,27,FollowSets000.FOLLOW_78); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getTypedTypeRefCSAccess().getLeftParenthesisKeyword_1_0());
                          
                    }
                    // InternalQVTcore.g:6945:1: ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) )
                    // InternalQVTcore.g:6946:1: (lv_ownedBinding_2_0= ruleTemplateBindingCS )
                    {
                    // InternalQVTcore.g:6946:1: (lv_ownedBinding_2_0= ruleTemplateBindingCS )
                    // InternalQVTcore.g:6947:3: lv_ownedBinding_2_0= ruleTemplateBindingCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypedTypeRefCSAccess().getOwnedBindingTemplateBindingCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_24);
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

                    otherlv_3=(Token)match(input,28,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
    // InternalQVTcore.g:6975:1: entryRuleWildcardTypeRefCS returns [EObject current=null] : iv_ruleWildcardTypeRefCS= ruleWildcardTypeRefCS EOF ;
    public final EObject entryRuleWildcardTypeRefCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWildcardTypeRefCS = null;


        try {
            // InternalQVTcore.g:6976:2: (iv_ruleWildcardTypeRefCS= ruleWildcardTypeRefCS EOF )
            // InternalQVTcore.g:6977:2: iv_ruleWildcardTypeRefCS= ruleWildcardTypeRefCS EOF
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
    // InternalQVTcore.g:6984:1: ruleWildcardTypeRefCS returns [EObject current=null] : ( () otherlv_1= '?' (otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleTypedRefCS ) ) )? ) ;
    public final EObject ruleWildcardTypeRefCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_ownedExtends_3_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTcore.g:6987:28: ( ( () otherlv_1= '?' (otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleTypedRefCS ) ) )? ) )
            // InternalQVTcore.g:6988:1: ( () otherlv_1= '?' (otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleTypedRefCS ) ) )? )
            {
            // InternalQVTcore.g:6988:1: ( () otherlv_1= '?' (otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleTypedRefCS ) ) )? )
            // InternalQVTcore.g:6988:2: () otherlv_1= '?' (otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleTypedRefCS ) ) )?
            {
            // InternalQVTcore.g:6988:2: ()
            // InternalQVTcore.g:6989:2: 
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

            otherlv_1=(Token)match(input,95,FollowSets000.FOLLOW_79); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getWildcardTypeRefCSAccess().getQuestionMarkKeyword_1());
                  
            }
            // InternalQVTcore.g:7001:1: (otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleTypedRefCS ) ) )?
            int alt123=2;
            int LA123_0 = input.LA(1);

            if ( (LA123_0==96) ) {
                alt123=1;
            }
            switch (alt123) {
                case 1 :
                    // InternalQVTcore.g:7001:3: otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleTypedRefCS ) )
                    {
                    otherlv_2=(Token)match(input,96,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getWildcardTypeRefCSAccess().getExtendsKeyword_2_0());
                          
                    }
                    // InternalQVTcore.g:7005:1: ( (lv_ownedExtends_3_0= ruleTypedRefCS ) )
                    // InternalQVTcore.g:7006:1: (lv_ownedExtends_3_0= ruleTypedRefCS )
                    {
                    // InternalQVTcore.g:7006:1: (lv_ownedExtends_3_0= ruleTypedRefCS )
                    // InternalQVTcore.g:7007:3: lv_ownedExtends_3_0= ruleTypedRefCS
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
    // InternalQVTcore.g:7031:1: entryRuleID returns [String current=null] : iv_ruleID= ruleID EOF ;
    public final String entryRuleID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleID = null;


        try {
            // InternalQVTcore.g:7032:2: (iv_ruleID= ruleID EOF )
            // InternalQVTcore.g:7033:2: iv_ruleID= ruleID EOF
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
    // InternalQVTcore.g:7040:1: ruleID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_SIMPLE_ID_0= RULE_SIMPLE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID ) ;
    public final AntlrDatatypeRuleToken ruleID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_SIMPLE_ID_0=null;
        Token this_ESCAPED_ID_1=null;

         enterRule(); 
            
        try {
            // InternalQVTcore.g:7043:28: ( (this_SIMPLE_ID_0= RULE_SIMPLE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID ) )
            // InternalQVTcore.g:7044:1: (this_SIMPLE_ID_0= RULE_SIMPLE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID )
            {
            // InternalQVTcore.g:7044:1: (this_SIMPLE_ID_0= RULE_SIMPLE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID )
            int alt124=2;
            int LA124_0 = input.LA(1);

            if ( (LA124_0==RULE_SIMPLE_ID) ) {
                alt124=1;
            }
            else if ( (LA124_0==RULE_ESCAPED_ID) ) {
                alt124=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 124, 0, input);

                throw nvae;
            }
            switch (alt124) {
                case 1 :
                    // InternalQVTcore.g:7044:6: this_SIMPLE_ID_0= RULE_SIMPLE_ID
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
                    // InternalQVTcore.g:7052:10: this_ESCAPED_ID_1= RULE_ESCAPED_ID
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
    // InternalQVTcore.g:7067:1: entryRuleIdentifier returns [String current=null] : iv_ruleIdentifier= ruleIdentifier EOF ;
    public final String entryRuleIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdentifier = null;


        try {
            // InternalQVTcore.g:7068:2: (iv_ruleIdentifier= ruleIdentifier EOF )
            // InternalQVTcore.g:7069:2: iv_ruleIdentifier= ruleIdentifier EOF
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
    // InternalQVTcore.g:7076:1: ruleIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= ruleID ;
    public final AntlrDatatypeRuleToken ruleIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_ID_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTcore.g:7079:28: (this_ID_0= ruleID )
            // InternalQVTcore.g:7081:5: this_ID_0= ruleID
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
    // InternalQVTcore.g:7099:1: entryRuleLOWER returns [String current=null] : iv_ruleLOWER= ruleLOWER EOF ;
    public final String entryRuleLOWER() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLOWER = null;


        try {
            // InternalQVTcore.g:7100:2: (iv_ruleLOWER= ruleLOWER EOF )
            // InternalQVTcore.g:7101:2: iv_ruleLOWER= ruleLOWER EOF
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
    // InternalQVTcore.g:7108:1: ruleLOWER returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INT_0= RULE_INT ;
    public final AntlrDatatypeRuleToken ruleLOWER() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;

         enterRule(); 
            
        try {
            // InternalQVTcore.g:7111:28: (this_INT_0= RULE_INT )
            // InternalQVTcore.g:7112:5: this_INT_0= RULE_INT
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
    // InternalQVTcore.g:7127:1: entryRuleNUMBER_LITERAL returns [String current=null] : iv_ruleNUMBER_LITERAL= ruleNUMBER_LITERAL EOF ;
    public final String entryRuleNUMBER_LITERAL() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNUMBER_LITERAL = null;


        try {
            // InternalQVTcore.g:7128:2: (iv_ruleNUMBER_LITERAL= ruleNUMBER_LITERAL EOF )
            // InternalQVTcore.g:7129:2: iv_ruleNUMBER_LITERAL= ruleNUMBER_LITERAL EOF
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
    // InternalQVTcore.g:7136:1: ruleNUMBER_LITERAL returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INT_0= RULE_INT ;
    public final AntlrDatatypeRuleToken ruleNUMBER_LITERAL() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;

         enterRule(); 
            
        try {
            // InternalQVTcore.g:7139:28: (this_INT_0= RULE_INT )
            // InternalQVTcore.g:7140:5: this_INT_0= RULE_INT
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
    // InternalQVTcore.g:7155:1: entryRuleStringLiteral returns [String current=null] : iv_ruleStringLiteral= ruleStringLiteral EOF ;
    public final String entryRuleStringLiteral() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleStringLiteral = null;


        try {
            // InternalQVTcore.g:7156:2: (iv_ruleStringLiteral= ruleStringLiteral EOF )
            // InternalQVTcore.g:7157:2: iv_ruleStringLiteral= ruleStringLiteral EOF
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
    // InternalQVTcore.g:7164:1: ruleStringLiteral returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING ;
    public final AntlrDatatypeRuleToken ruleStringLiteral() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_SINGLE_QUOTED_STRING_0=null;

         enterRule(); 
            
        try {
            // InternalQVTcore.g:7167:28: (this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING )
            // InternalQVTcore.g:7168:5: this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING
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
    // InternalQVTcore.g:7183:1: entryRuleUPPER returns [String current=null] : iv_ruleUPPER= ruleUPPER EOF ;
    public final String entryRuleUPPER() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUPPER = null;


        try {
            // InternalQVTcore.g:7184:2: (iv_ruleUPPER= ruleUPPER EOF )
            // InternalQVTcore.g:7185:2: iv_ruleUPPER= ruleUPPER EOF
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
    // InternalQVTcore.g:7192:1: ruleUPPER returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT | kw= '*' ) ;
    public final AntlrDatatypeRuleToken ruleUPPER() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;

         enterRule(); 
            
        try {
            // InternalQVTcore.g:7195:28: ( (this_INT_0= RULE_INT | kw= '*' ) )
            // InternalQVTcore.g:7196:1: (this_INT_0= RULE_INT | kw= '*' )
            {
            // InternalQVTcore.g:7196:1: (this_INT_0= RULE_INT | kw= '*' )
            int alt125=2;
            int LA125_0 = input.LA(1);

            if ( (LA125_0==RULE_INT) ) {
                alt125=1;
            }
            else if ( (LA125_0==32) ) {
                alt125=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 125, 0, input);

                throw nvae;
            }
            switch (alt125) {
                case 1 :
                    // InternalQVTcore.g:7196:6: this_INT_0= RULE_INT
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
                    // InternalQVTcore.g:7205:2: kw= '*'
                    {
                    kw=(Token)match(input,32,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
    // InternalQVTcore.g:7218:1: entryRuleURI returns [String current=null] : iv_ruleURI= ruleURI EOF ;
    public final String entryRuleURI() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleURI = null;


        try {
            // InternalQVTcore.g:7219:2: (iv_ruleURI= ruleURI EOF )
            // InternalQVTcore.g:7220:2: iv_ruleURI= ruleURI EOF
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
    // InternalQVTcore.g:7227:1: ruleURI returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING ;
    public final AntlrDatatypeRuleToken ruleURI() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_SINGLE_QUOTED_STRING_0=null;

         enterRule(); 
            
        try {
            // InternalQVTcore.g:7230:28: (this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING )
            // InternalQVTcore.g:7231:5: this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING
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

    // $ANTLR start synpred17_InternalQVTcore
    public final void synpred17_InternalQVTcore_fragment() throws RecognitionException {   
        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_ownedUnrealizedVariables_1_0 = null;

        EObject lv_ownedRealizedVariables_2_0 = null;

        EObject lv_ownedUnrealizedVariables_4_0 = null;

        EObject lv_ownedRealizedVariables_5_0 = null;

        EObject lv_ownedConstraints_7_0 = null;


        // InternalQVTcore.g:387:2: ( (otherlv_0= '{' ( ( (lv_ownedUnrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) | ( (lv_ownedRealizedVariables_2_0= ruleRealizedVariableCS ) ) ) (otherlv_3= ',' ( ( (lv_ownedUnrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_ownedRealizedVariables_5_0= ruleRealizedVariableCS ) ) ) )* otherlv_6= '|' ( (lv_ownedConstraints_7_0= rulePredicateOrAssignmentCS ) )* otherlv_8= '}' ) )
        // InternalQVTcore.g:387:2: (otherlv_0= '{' ( ( (lv_ownedUnrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) | ( (lv_ownedRealizedVariables_2_0= ruleRealizedVariableCS ) ) ) (otherlv_3= ',' ( ( (lv_ownedUnrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_ownedRealizedVariables_5_0= ruleRealizedVariableCS ) ) ) )* otherlv_6= '|' ( (lv_ownedConstraints_7_0= rulePredicateOrAssignmentCS ) )* otherlv_8= '}' )
        {
        // InternalQVTcore.g:387:2: (otherlv_0= '{' ( ( (lv_ownedUnrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) | ( (lv_ownedRealizedVariables_2_0= ruleRealizedVariableCS ) ) ) (otherlv_3= ',' ( ( (lv_ownedUnrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_ownedRealizedVariables_5_0= ruleRealizedVariableCS ) ) ) )* otherlv_6= '|' ( (lv_ownedConstraints_7_0= rulePredicateOrAssignmentCS ) )* otherlv_8= '}' )
        // InternalQVTcore.g:387:4: otherlv_0= '{' ( ( (lv_ownedUnrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) | ( (lv_ownedRealizedVariables_2_0= ruleRealizedVariableCS ) ) ) (otherlv_3= ',' ( ( (lv_ownedUnrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_ownedRealizedVariables_5_0= ruleRealizedVariableCS ) ) ) )* otherlv_6= '|' ( (lv_ownedConstraints_7_0= rulePredicateOrAssignmentCS ) )* otherlv_8= '}'
        {
        otherlv_0=(Token)match(input,21,FollowSets000.FOLLOW_8); if (state.failed) return ;
        // InternalQVTcore.g:391:1: ( ( (lv_ownedUnrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) | ( (lv_ownedRealizedVariables_2_0= ruleRealizedVariableCS ) ) )
        int alt128=2;
        int LA128_0 = input.LA(1);

        if ( ((LA128_0>=RULE_SIMPLE_ID && LA128_0<=RULE_ESCAPED_ID)||LA128_0==17||LA128_0==19||(LA128_0>=25 && LA128_0<=26)||LA128_0==30||(LA128_0>=34 && LA128_0<=35)||(LA128_0>=37 && LA128_0<=38)||LA128_0==40) ) {
            alt128=1;
        }
        else if ( (LA128_0==39) ) {
            int LA128_2 = input.LA(2);

            if ( ((LA128_2>=RULE_SIMPLE_ID && LA128_2<=RULE_ESCAPED_ID)||LA128_2==17||LA128_2==19||(LA128_2>=25 && LA128_2<=26)||LA128_2==30||(LA128_2>=34 && LA128_2<=35)||(LA128_2>=37 && LA128_2<=40)) ) {
                alt128=2;
            }
            else if ( (LA128_2==20||LA128_2==24||LA128_2==29||LA128_2==36) ) {
                alt128=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 128, 2, input);

                throw nvae;
            }
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 128, 0, input);

            throw nvae;
        }
        switch (alt128) {
            case 1 :
                // InternalQVTcore.g:391:2: ( (lv_ownedUnrealizedVariables_1_0= ruleUnrealizedVariableCS ) )
                {
                // InternalQVTcore.g:391:2: ( (lv_ownedUnrealizedVariables_1_0= ruleUnrealizedVariableCS ) )
                // InternalQVTcore.g:392:1: (lv_ownedUnrealizedVariables_1_0= ruleUnrealizedVariableCS )
                {
                // InternalQVTcore.g:392:1: (lv_ownedUnrealizedVariables_1_0= ruleUnrealizedVariableCS )
                // InternalQVTcore.g:393:3: lv_ownedUnrealizedVariables_1_0= ruleUnrealizedVariableCS
                {
                if ( state.backtracking==0 ) {
                   
                  	        newCompositeNode(grammarAccess.getBottomPatternCSAccess().getOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_0_1_0_0()); 
                  	    
                }
                pushFollow(FollowSets000.FOLLOW_14);
                lv_ownedUnrealizedVariables_1_0=ruleUnrealizedVariableCS();

                state._fsp--;
                if (state.failed) return ;

                }


                }


                }
                break;
            case 2 :
                // InternalQVTcore.g:410:6: ( (lv_ownedRealizedVariables_2_0= ruleRealizedVariableCS ) )
                {
                // InternalQVTcore.g:410:6: ( (lv_ownedRealizedVariables_2_0= ruleRealizedVariableCS ) )
                // InternalQVTcore.g:411:1: (lv_ownedRealizedVariables_2_0= ruleRealizedVariableCS )
                {
                // InternalQVTcore.g:411:1: (lv_ownedRealizedVariables_2_0= ruleRealizedVariableCS )
                // InternalQVTcore.g:412:3: lv_ownedRealizedVariables_2_0= ruleRealizedVariableCS
                {
                if ( state.backtracking==0 ) {
                   
                  	        newCompositeNode(grammarAccess.getBottomPatternCSAccess().getOwnedRealizedVariablesRealizedVariableCSParserRuleCall_0_1_1_0()); 
                  	    
                }
                pushFollow(FollowSets000.FOLLOW_14);
                lv_ownedRealizedVariables_2_0=ruleRealizedVariableCS();

                state._fsp--;
                if (state.failed) return ;

                }


                }


                }
                break;

        }

        // InternalQVTcore.g:428:3: (otherlv_3= ',' ( ( (lv_ownedUnrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_ownedRealizedVariables_5_0= ruleRealizedVariableCS ) ) ) )*
        loop130:
        do {
            int alt130=2;
            int LA130_0 = input.LA(1);

            if ( (LA130_0==20) ) {
                alt130=1;
            }


            switch (alt130) {
        	case 1 :
        	    // InternalQVTcore.g:428:5: otherlv_3= ',' ( ( (lv_ownedUnrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_ownedRealizedVariables_5_0= ruleRealizedVariableCS ) ) )
        	    {
        	    otherlv_3=(Token)match(input,20,FollowSets000.FOLLOW_8); if (state.failed) return ;
        	    // InternalQVTcore.g:432:1: ( ( (lv_ownedUnrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_ownedRealizedVariables_5_0= ruleRealizedVariableCS ) ) )
        	    int alt129=2;
        	    int LA129_0 = input.LA(1);

        	    if ( ((LA129_0>=RULE_SIMPLE_ID && LA129_0<=RULE_ESCAPED_ID)||LA129_0==17||LA129_0==19||(LA129_0>=25 && LA129_0<=26)||LA129_0==30||(LA129_0>=34 && LA129_0<=35)||(LA129_0>=37 && LA129_0<=38)||LA129_0==40) ) {
        	        alt129=1;
        	    }
        	    else if ( (LA129_0==39) ) {
        	        int LA129_2 = input.LA(2);

        	        if ( (LA129_2==20||LA129_2==24||LA129_2==29||LA129_2==36) ) {
        	            alt129=1;
        	        }
        	        else if ( ((LA129_2>=RULE_SIMPLE_ID && LA129_2<=RULE_ESCAPED_ID)||LA129_2==17||LA129_2==19||(LA129_2>=25 && LA129_2<=26)||LA129_2==30||(LA129_2>=34 && LA129_2<=35)||(LA129_2>=37 && LA129_2<=40)) ) {
        	            alt129=2;
        	        }
        	        else {
        	            if (state.backtracking>0) {state.failed=true; return ;}
        	            NoViableAltException nvae =
        	                new NoViableAltException("", 129, 2, input);

        	            throw nvae;
        	        }
        	    }
        	    else {
        	        if (state.backtracking>0) {state.failed=true; return ;}
        	        NoViableAltException nvae =
        	            new NoViableAltException("", 129, 0, input);

        	        throw nvae;
        	    }
        	    switch (alt129) {
        	        case 1 :
        	            // InternalQVTcore.g:432:2: ( (lv_ownedUnrealizedVariables_4_0= ruleUnrealizedVariableCS ) )
        	            {
        	            // InternalQVTcore.g:432:2: ( (lv_ownedUnrealizedVariables_4_0= ruleUnrealizedVariableCS ) )
        	            // InternalQVTcore.g:433:1: (lv_ownedUnrealizedVariables_4_0= ruleUnrealizedVariableCS )
        	            {
        	            // InternalQVTcore.g:433:1: (lv_ownedUnrealizedVariables_4_0= ruleUnrealizedVariableCS )
        	            // InternalQVTcore.g:434:3: lv_ownedUnrealizedVariables_4_0= ruleUnrealizedVariableCS
        	            {
        	            if ( state.backtracking==0 ) {
        	               
        	              	        newCompositeNode(grammarAccess.getBottomPatternCSAccess().getOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_0_2_1_0_0()); 
        	              	    
        	            }
        	            pushFollow(FollowSets000.FOLLOW_14);
        	            lv_ownedUnrealizedVariables_4_0=ruleUnrealizedVariableCS();

        	            state._fsp--;
        	            if (state.failed) return ;

        	            }


        	            }


        	            }
        	            break;
        	        case 2 :
        	            // InternalQVTcore.g:451:6: ( (lv_ownedRealizedVariables_5_0= ruleRealizedVariableCS ) )
        	            {
        	            // InternalQVTcore.g:451:6: ( (lv_ownedRealizedVariables_5_0= ruleRealizedVariableCS ) )
        	            // InternalQVTcore.g:452:1: (lv_ownedRealizedVariables_5_0= ruleRealizedVariableCS )
        	            {
        	            // InternalQVTcore.g:452:1: (lv_ownedRealizedVariables_5_0= ruleRealizedVariableCS )
        	            // InternalQVTcore.g:453:3: lv_ownedRealizedVariables_5_0= ruleRealizedVariableCS
        	            {
        	            if ( state.backtracking==0 ) {
        	               
        	              	        newCompositeNode(grammarAccess.getBottomPatternCSAccess().getOwnedRealizedVariablesRealizedVariableCSParserRuleCall_0_2_1_1_0()); 
        	              	    
        	            }
        	            pushFollow(FollowSets000.FOLLOW_14);
        	            lv_ownedRealizedVariables_5_0=ruleRealizedVariableCS();

        	            state._fsp--;
        	            if (state.failed) return ;

        	            }


        	            }


        	            }
        	            break;

        	    }


        	    }
        	    break;

        	default :
        	    break loop130;
            }
        } while (true);

        otherlv_6=(Token)match(input,24,FollowSets000.FOLLOW_15); if (state.failed) return ;
        // InternalQVTcore.g:473:1: ( (lv_ownedConstraints_7_0= rulePredicateOrAssignmentCS ) )*
        loop131:
        do {
            int alt131=2;
            int LA131_0 = input.LA(1);

            if ( ((LA131_0>=RULE_SIMPLE_ID && LA131_0<=RULE_SINGLE_QUOTED_STRING)||(LA131_0>=16 && LA131_0<=17)||LA131_0==19||(LA131_0>=25 && LA131_0<=27)||LA131_0==30||LA131_0==32||(LA131_0>=34 && LA131_0<=35)||(LA131_0>=37 && LA131_0<=42)||(LA131_0>=59 && LA131_0<=73)||LA131_0==76||(LA131_0>=78 && LA131_0<=81)||LA131_0==86||(LA131_0>=91 && LA131_0<=92)) ) {
                alt131=1;
            }


            switch (alt131) {
        	case 1 :
        	    // InternalQVTcore.g:474:1: (lv_ownedConstraints_7_0= rulePredicateOrAssignmentCS )
        	    {
        	    // InternalQVTcore.g:474:1: (lv_ownedConstraints_7_0= rulePredicateOrAssignmentCS )
        	    // InternalQVTcore.g:475:3: lv_ownedConstraints_7_0= rulePredicateOrAssignmentCS
        	    {
        	    if ( state.backtracking==0 ) {
        	       
        	      	        newCompositeNode(grammarAccess.getBottomPatternCSAccess().getOwnedConstraintsPredicateOrAssignmentCSParserRuleCall_0_4_0()); 
        	      	    
        	    }
        	    pushFollow(FollowSets000.FOLLOW_15);
        	    lv_ownedConstraints_7_0=rulePredicateOrAssignmentCS();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }
        	    break;

        	default :
        	    break loop131;
            }
        } while (true);

        otherlv_8=(Token)match(input,23,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred17_InternalQVTcore

    // $ANTLR start synpred21_InternalQVTcore
    public final void synpred21_InternalQVTcore_fragment() throws RecognitionException {   
        Token otherlv_9=null;
        Token otherlv_12=null;
        Token otherlv_15=null;
        EObject lv_ownedUnrealizedVariables_10_0 = null;

        EObject lv_ownedRealizedVariables_11_0 = null;

        EObject lv_ownedUnrealizedVariables_13_0 = null;

        EObject lv_ownedRealizedVariables_14_0 = null;


        // InternalQVTcore.g:496:6: ( (otherlv_9= '{' ( ( (lv_ownedUnrealizedVariables_10_0= ruleUnrealizedVariableCS ) ) | ( (lv_ownedRealizedVariables_11_0= ruleRealizedVariableCS ) ) ) (otherlv_12= ',' ( ( (lv_ownedUnrealizedVariables_13_0= ruleUnrealizedVariableCS ) ) | ( (lv_ownedRealizedVariables_14_0= ruleRealizedVariableCS ) ) ) )* otherlv_15= '}' ) )
        // InternalQVTcore.g:496:6: (otherlv_9= '{' ( ( (lv_ownedUnrealizedVariables_10_0= ruleUnrealizedVariableCS ) ) | ( (lv_ownedRealizedVariables_11_0= ruleRealizedVariableCS ) ) ) (otherlv_12= ',' ( ( (lv_ownedUnrealizedVariables_13_0= ruleUnrealizedVariableCS ) ) | ( (lv_ownedRealizedVariables_14_0= ruleRealizedVariableCS ) ) ) )* otherlv_15= '}' )
        {
        // InternalQVTcore.g:496:6: (otherlv_9= '{' ( ( (lv_ownedUnrealizedVariables_10_0= ruleUnrealizedVariableCS ) ) | ( (lv_ownedRealizedVariables_11_0= ruleRealizedVariableCS ) ) ) (otherlv_12= ',' ( ( (lv_ownedUnrealizedVariables_13_0= ruleUnrealizedVariableCS ) ) | ( (lv_ownedRealizedVariables_14_0= ruleRealizedVariableCS ) ) ) )* otherlv_15= '}' )
        // InternalQVTcore.g:496:8: otherlv_9= '{' ( ( (lv_ownedUnrealizedVariables_10_0= ruleUnrealizedVariableCS ) ) | ( (lv_ownedRealizedVariables_11_0= ruleRealizedVariableCS ) ) ) (otherlv_12= ',' ( ( (lv_ownedUnrealizedVariables_13_0= ruleUnrealizedVariableCS ) ) | ( (lv_ownedRealizedVariables_14_0= ruleRealizedVariableCS ) ) ) )* otherlv_15= '}'
        {
        otherlv_9=(Token)match(input,21,FollowSets000.FOLLOW_8); if (state.failed) return ;
        // InternalQVTcore.g:500:1: ( ( (lv_ownedUnrealizedVariables_10_0= ruleUnrealizedVariableCS ) ) | ( (lv_ownedRealizedVariables_11_0= ruleRealizedVariableCS ) ) )
        int alt133=2;
        int LA133_0 = input.LA(1);

        if ( ((LA133_0>=RULE_SIMPLE_ID && LA133_0<=RULE_ESCAPED_ID)||LA133_0==17||LA133_0==19||(LA133_0>=25 && LA133_0<=26)||LA133_0==30||(LA133_0>=34 && LA133_0<=35)||(LA133_0>=37 && LA133_0<=38)||LA133_0==40) ) {
            alt133=1;
        }
        else if ( (LA133_0==39) ) {
            int LA133_2 = input.LA(2);

            if ( (LA133_2==20||LA133_2==23||LA133_2==29||LA133_2==36) ) {
                alt133=1;
            }
            else if ( ((LA133_2>=RULE_SIMPLE_ID && LA133_2<=RULE_ESCAPED_ID)||LA133_2==17||LA133_2==19||(LA133_2>=25 && LA133_2<=26)||LA133_2==30||(LA133_2>=34 && LA133_2<=35)||(LA133_2>=37 && LA133_2<=40)) ) {
                alt133=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 133, 2, input);

                throw nvae;
            }
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 133, 0, input);

            throw nvae;
        }
        switch (alt133) {
            case 1 :
                // InternalQVTcore.g:500:2: ( (lv_ownedUnrealizedVariables_10_0= ruleUnrealizedVariableCS ) )
                {
                // InternalQVTcore.g:500:2: ( (lv_ownedUnrealizedVariables_10_0= ruleUnrealizedVariableCS ) )
                // InternalQVTcore.g:501:1: (lv_ownedUnrealizedVariables_10_0= ruleUnrealizedVariableCS )
                {
                // InternalQVTcore.g:501:1: (lv_ownedUnrealizedVariables_10_0= ruleUnrealizedVariableCS )
                // InternalQVTcore.g:502:3: lv_ownedUnrealizedVariables_10_0= ruleUnrealizedVariableCS
                {
                if ( state.backtracking==0 ) {
                   
                  	        newCompositeNode(grammarAccess.getBottomPatternCSAccess().getOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_1_1_0_0()); 
                  	    
                }
                pushFollow(FollowSets000.FOLLOW_16);
                lv_ownedUnrealizedVariables_10_0=ruleUnrealizedVariableCS();

                state._fsp--;
                if (state.failed) return ;

                }


                }


                }
                break;
            case 2 :
                // InternalQVTcore.g:519:6: ( (lv_ownedRealizedVariables_11_0= ruleRealizedVariableCS ) )
                {
                // InternalQVTcore.g:519:6: ( (lv_ownedRealizedVariables_11_0= ruleRealizedVariableCS ) )
                // InternalQVTcore.g:520:1: (lv_ownedRealizedVariables_11_0= ruleRealizedVariableCS )
                {
                // InternalQVTcore.g:520:1: (lv_ownedRealizedVariables_11_0= ruleRealizedVariableCS )
                // InternalQVTcore.g:521:3: lv_ownedRealizedVariables_11_0= ruleRealizedVariableCS
                {
                if ( state.backtracking==0 ) {
                   
                  	        newCompositeNode(grammarAccess.getBottomPatternCSAccess().getOwnedRealizedVariablesRealizedVariableCSParserRuleCall_1_1_1_0()); 
                  	    
                }
                pushFollow(FollowSets000.FOLLOW_16);
                lv_ownedRealizedVariables_11_0=ruleRealizedVariableCS();

                state._fsp--;
                if (state.failed) return ;

                }


                }


                }
                break;

        }

        // InternalQVTcore.g:537:3: (otherlv_12= ',' ( ( (lv_ownedUnrealizedVariables_13_0= ruleUnrealizedVariableCS ) ) | ( (lv_ownedRealizedVariables_14_0= ruleRealizedVariableCS ) ) ) )*
        loop135:
        do {
            int alt135=2;
            int LA135_0 = input.LA(1);

            if ( (LA135_0==20) ) {
                alt135=1;
            }


            switch (alt135) {
        	case 1 :
        	    // InternalQVTcore.g:537:5: otherlv_12= ',' ( ( (lv_ownedUnrealizedVariables_13_0= ruleUnrealizedVariableCS ) ) | ( (lv_ownedRealizedVariables_14_0= ruleRealizedVariableCS ) ) )
        	    {
        	    otherlv_12=(Token)match(input,20,FollowSets000.FOLLOW_8); if (state.failed) return ;
        	    // InternalQVTcore.g:541:1: ( ( (lv_ownedUnrealizedVariables_13_0= ruleUnrealizedVariableCS ) ) | ( (lv_ownedRealizedVariables_14_0= ruleRealizedVariableCS ) ) )
        	    int alt134=2;
        	    int LA134_0 = input.LA(1);

        	    if ( ((LA134_0>=RULE_SIMPLE_ID && LA134_0<=RULE_ESCAPED_ID)||LA134_0==17||LA134_0==19||(LA134_0>=25 && LA134_0<=26)||LA134_0==30||(LA134_0>=34 && LA134_0<=35)||(LA134_0>=37 && LA134_0<=38)||LA134_0==40) ) {
        	        alt134=1;
        	    }
        	    else if ( (LA134_0==39) ) {
        	        int LA134_2 = input.LA(2);

        	        if ( ((LA134_2>=RULE_SIMPLE_ID && LA134_2<=RULE_ESCAPED_ID)||LA134_2==17||LA134_2==19||(LA134_2>=25 && LA134_2<=26)||LA134_2==30||(LA134_2>=34 && LA134_2<=35)||(LA134_2>=37 && LA134_2<=40)) ) {
        	            alt134=2;
        	        }
        	        else if ( (LA134_2==20||LA134_2==23||LA134_2==29||LA134_2==36) ) {
        	            alt134=1;
        	        }
        	        else {
        	            if (state.backtracking>0) {state.failed=true; return ;}
        	            NoViableAltException nvae =
        	                new NoViableAltException("", 134, 2, input);

        	            throw nvae;
        	        }
        	    }
        	    else {
        	        if (state.backtracking>0) {state.failed=true; return ;}
        	        NoViableAltException nvae =
        	            new NoViableAltException("", 134, 0, input);

        	        throw nvae;
        	    }
        	    switch (alt134) {
        	        case 1 :
        	            // InternalQVTcore.g:541:2: ( (lv_ownedUnrealizedVariables_13_0= ruleUnrealizedVariableCS ) )
        	            {
        	            // InternalQVTcore.g:541:2: ( (lv_ownedUnrealizedVariables_13_0= ruleUnrealizedVariableCS ) )
        	            // InternalQVTcore.g:542:1: (lv_ownedUnrealizedVariables_13_0= ruleUnrealizedVariableCS )
        	            {
        	            // InternalQVTcore.g:542:1: (lv_ownedUnrealizedVariables_13_0= ruleUnrealizedVariableCS )
        	            // InternalQVTcore.g:543:3: lv_ownedUnrealizedVariables_13_0= ruleUnrealizedVariableCS
        	            {
        	            if ( state.backtracking==0 ) {
        	               
        	              	        newCompositeNode(grammarAccess.getBottomPatternCSAccess().getOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_1_2_1_0_0()); 
        	              	    
        	            }
        	            pushFollow(FollowSets000.FOLLOW_16);
        	            lv_ownedUnrealizedVariables_13_0=ruleUnrealizedVariableCS();

        	            state._fsp--;
        	            if (state.failed) return ;

        	            }


        	            }


        	            }
        	            break;
        	        case 2 :
        	            // InternalQVTcore.g:560:6: ( (lv_ownedRealizedVariables_14_0= ruleRealizedVariableCS ) )
        	            {
        	            // InternalQVTcore.g:560:6: ( (lv_ownedRealizedVariables_14_0= ruleRealizedVariableCS ) )
        	            // InternalQVTcore.g:561:1: (lv_ownedRealizedVariables_14_0= ruleRealizedVariableCS )
        	            {
        	            // InternalQVTcore.g:561:1: (lv_ownedRealizedVariables_14_0= ruleRealizedVariableCS )
        	            // InternalQVTcore.g:562:3: lv_ownedRealizedVariables_14_0= ruleRealizedVariableCS
        	            {
        	            if ( state.backtracking==0 ) {
        	               
        	              	        newCompositeNode(grammarAccess.getBottomPatternCSAccess().getOwnedRealizedVariablesRealizedVariableCSParserRuleCall_1_2_1_1_0()); 
        	              	    
        	            }
        	            pushFollow(FollowSets000.FOLLOW_16);
        	            lv_ownedRealizedVariables_14_0=ruleRealizedVariableCS();

        	            state._fsp--;
        	            if (state.failed) return ;

        	            }


        	            }


        	            }
        	            break;

        	    }


        	    }
        	    break;

        	default :
        	    break loop135;
            }
        } while (true);

        otherlv_15=(Token)match(input,23,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred21_InternalQVTcore

    // $ANTLR start synpred23_InternalQVTcore
    public final void synpred23_InternalQVTcore_fragment() throws RecognitionException {   
        Token otherlv_16=null;
        Token otherlv_18=null;
        EObject lv_ownedConstraints_17_0 = null;


        // InternalQVTcore.g:583:6: ( (otherlv_16= '{' ( (lv_ownedConstraints_17_0= rulePredicateOrAssignmentCS ) )+ otherlv_18= '}' ) )
        // InternalQVTcore.g:583:6: (otherlv_16= '{' ( (lv_ownedConstraints_17_0= rulePredicateOrAssignmentCS ) )+ otherlv_18= '}' )
        {
        // InternalQVTcore.g:583:6: (otherlv_16= '{' ( (lv_ownedConstraints_17_0= rulePredicateOrAssignmentCS ) )+ otherlv_18= '}' )
        // InternalQVTcore.g:583:8: otherlv_16= '{' ( (lv_ownedConstraints_17_0= rulePredicateOrAssignmentCS ) )+ otherlv_18= '}'
        {
        otherlv_16=(Token)match(input,21,FollowSets000.FOLLOW_17); if (state.failed) return ;
        // InternalQVTcore.g:587:1: ( (lv_ownedConstraints_17_0= rulePredicateOrAssignmentCS ) )+
        int cnt136=0;
        loop136:
        do {
            int alt136=2;
            int LA136_0 = input.LA(1);

            if ( ((LA136_0>=RULE_SIMPLE_ID && LA136_0<=RULE_SINGLE_QUOTED_STRING)||(LA136_0>=16 && LA136_0<=17)||LA136_0==19||(LA136_0>=25 && LA136_0<=27)||LA136_0==30||LA136_0==32||(LA136_0>=34 && LA136_0<=35)||(LA136_0>=37 && LA136_0<=42)||(LA136_0>=59 && LA136_0<=73)||LA136_0==76||(LA136_0>=78 && LA136_0<=81)||LA136_0==86||(LA136_0>=91 && LA136_0<=92)) ) {
                alt136=1;
            }


            switch (alt136) {
        	case 1 :
        	    // InternalQVTcore.g:588:1: (lv_ownedConstraints_17_0= rulePredicateOrAssignmentCS )
        	    {
        	    // InternalQVTcore.g:588:1: (lv_ownedConstraints_17_0= rulePredicateOrAssignmentCS )
        	    // InternalQVTcore.g:589:3: lv_ownedConstraints_17_0= rulePredicateOrAssignmentCS
        	    {
        	    if ( state.backtracking==0 ) {
        	       
        	      	        newCompositeNode(grammarAccess.getBottomPatternCSAccess().getOwnedConstraintsPredicateOrAssignmentCSParserRuleCall_2_1_0()); 
        	      	    
        	    }
        	    pushFollow(FollowSets000.FOLLOW_15);
        	    lv_ownedConstraints_17_0=rulePredicateOrAssignmentCS();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }
        	    break;

        	default :
        	    if ( cnt136 >= 1 ) break loop136;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(136, input);
                    throw eee;
            }
            cnt136++;
        } while (true);

        otherlv_18=(Token)match(input,23,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred23_InternalQVTcore

    // $ANTLR start synpred30_InternalQVTcore
    public final void synpred30_InternalQVTcore_fragment() throws RecognitionException {   
        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_ownedUnrealizedVariables_1_0 = null;

        EObject lv_ownedUnrealizedVariables_3_0 = null;

        EObject lv_ownedPredicates_5_0 = null;


        // InternalQVTcore.g:784:2: ( (otherlv_0= '(' ( (lv_ownedUnrealizedVariables_1_0= ruleGuardVariableCS ) ) (otherlv_2= ',' ( (lv_ownedUnrealizedVariables_3_0= ruleGuardVariableCS ) ) )* otherlv_4= '|' ( (lv_ownedPredicates_5_0= rulePredicateCS ) )* otherlv_6= ')' ) )
        // InternalQVTcore.g:784:2: (otherlv_0= '(' ( (lv_ownedUnrealizedVariables_1_0= ruleGuardVariableCS ) ) (otherlv_2= ',' ( (lv_ownedUnrealizedVariables_3_0= ruleGuardVariableCS ) ) )* otherlv_4= '|' ( (lv_ownedPredicates_5_0= rulePredicateCS ) )* otherlv_6= ')' )
        {
        // InternalQVTcore.g:784:2: (otherlv_0= '(' ( (lv_ownedUnrealizedVariables_1_0= ruleGuardVariableCS ) ) (otherlv_2= ',' ( (lv_ownedUnrealizedVariables_3_0= ruleGuardVariableCS ) ) )* otherlv_4= '|' ( (lv_ownedPredicates_5_0= rulePredicateCS ) )* otherlv_6= ')' )
        // InternalQVTcore.g:784:4: otherlv_0= '(' ( (lv_ownedUnrealizedVariables_1_0= ruleGuardVariableCS ) ) (otherlv_2= ',' ( (lv_ownedUnrealizedVariables_3_0= ruleGuardVariableCS ) ) )* otherlv_4= '|' ( (lv_ownedPredicates_5_0= rulePredicateCS ) )* otherlv_6= ')'
        {
        otherlv_0=(Token)match(input,27,FollowSets000.FOLLOW_8); if (state.failed) return ;
        // InternalQVTcore.g:788:1: ( (lv_ownedUnrealizedVariables_1_0= ruleGuardVariableCS ) )
        // InternalQVTcore.g:789:1: (lv_ownedUnrealizedVariables_1_0= ruleGuardVariableCS )
        {
        // InternalQVTcore.g:789:1: (lv_ownedUnrealizedVariables_1_0= ruleGuardVariableCS )
        // InternalQVTcore.g:790:3: lv_ownedUnrealizedVariables_1_0= ruleGuardVariableCS
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getGuardPatternCSAccess().getOwnedUnrealizedVariablesGuardVariableCSParserRuleCall_0_1_0()); 
          	    
        }
        pushFollow(FollowSets000.FOLLOW_14);
        lv_ownedUnrealizedVariables_1_0=ruleGuardVariableCS();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // InternalQVTcore.g:806:2: (otherlv_2= ',' ( (lv_ownedUnrealizedVariables_3_0= ruleGuardVariableCS ) ) )*
        loop138:
        do {
            int alt138=2;
            int LA138_0 = input.LA(1);

            if ( (LA138_0==20) ) {
                alt138=1;
            }


            switch (alt138) {
        	case 1 :
        	    // InternalQVTcore.g:806:4: otherlv_2= ',' ( (lv_ownedUnrealizedVariables_3_0= ruleGuardVariableCS ) )
        	    {
        	    otherlv_2=(Token)match(input,20,FollowSets000.FOLLOW_8); if (state.failed) return ;
        	    // InternalQVTcore.g:810:1: ( (lv_ownedUnrealizedVariables_3_0= ruleGuardVariableCS ) )
        	    // InternalQVTcore.g:811:1: (lv_ownedUnrealizedVariables_3_0= ruleGuardVariableCS )
        	    {
        	    // InternalQVTcore.g:811:1: (lv_ownedUnrealizedVariables_3_0= ruleGuardVariableCS )
        	    // InternalQVTcore.g:812:3: lv_ownedUnrealizedVariables_3_0= ruleGuardVariableCS
        	    {
        	    if ( state.backtracking==0 ) {
        	       
        	      	        newCompositeNode(grammarAccess.getGuardPatternCSAccess().getOwnedUnrealizedVariablesGuardVariableCSParserRuleCall_0_2_1_0()); 
        	      	    
        	    }
        	    pushFollow(FollowSets000.FOLLOW_14);
        	    lv_ownedUnrealizedVariables_3_0=ruleGuardVariableCS();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }


        	    }
        	    break;

        	default :
        	    break loop138;
            }
        } while (true);

        otherlv_4=(Token)match(input,24,FollowSets000.FOLLOW_22); if (state.failed) return ;
        // InternalQVTcore.g:832:1: ( (lv_ownedPredicates_5_0= rulePredicateCS ) )*
        loop139:
        do {
            int alt139=2;
            int LA139_0 = input.LA(1);

            if ( ((LA139_0>=RULE_SIMPLE_ID && LA139_0<=RULE_SINGLE_QUOTED_STRING)||LA139_0==17||LA139_0==19||(LA139_0>=25 && LA139_0<=27)||LA139_0==30||LA139_0==32||(LA139_0>=34 && LA139_0<=35)||(LA139_0>=37 && LA139_0<=42)||(LA139_0>=59 && LA139_0<=73)||LA139_0==76||(LA139_0>=78 && LA139_0<=81)||LA139_0==86||(LA139_0>=91 && LA139_0<=92)) ) {
                alt139=1;
            }


            switch (alt139) {
        	case 1 :
        	    // InternalQVTcore.g:833:1: (lv_ownedPredicates_5_0= rulePredicateCS )
        	    {
        	    // InternalQVTcore.g:833:1: (lv_ownedPredicates_5_0= rulePredicateCS )
        	    // InternalQVTcore.g:834:3: lv_ownedPredicates_5_0= rulePredicateCS
        	    {
        	    if ( state.backtracking==0 ) {
        	       
        	      	        newCompositeNode(grammarAccess.getGuardPatternCSAccess().getOwnedPredicatesPredicateCSParserRuleCall_0_4_0()); 
        	      	    
        	    }
        	    pushFollow(FollowSets000.FOLLOW_22);
        	    lv_ownedPredicates_5_0=rulePredicateCS();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }
        	    break;

        	default :
        	    break loop139;
            }
        } while (true);

        otherlv_6=(Token)match(input,28,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred30_InternalQVTcore

    // $ANTLR start synpred32_InternalQVTcore
    public final void synpred32_InternalQVTcore_fragment() throws RecognitionException {   
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        EObject lv_ownedUnrealizedVariables_8_0 = null;

        EObject lv_ownedUnrealizedVariables_10_0 = null;


        // InternalQVTcore.g:855:6: ( (otherlv_7= '(' ( (lv_ownedUnrealizedVariables_8_0= ruleGuardVariableCS ) ) (otherlv_9= ',' ( (lv_ownedUnrealizedVariables_10_0= ruleGuardVariableCS ) ) )* otherlv_11= ')' ) )
        // InternalQVTcore.g:855:6: (otherlv_7= '(' ( (lv_ownedUnrealizedVariables_8_0= ruleGuardVariableCS ) ) (otherlv_9= ',' ( (lv_ownedUnrealizedVariables_10_0= ruleGuardVariableCS ) ) )* otherlv_11= ')' )
        {
        // InternalQVTcore.g:855:6: (otherlv_7= '(' ( (lv_ownedUnrealizedVariables_8_0= ruleGuardVariableCS ) ) (otherlv_9= ',' ( (lv_ownedUnrealizedVariables_10_0= ruleGuardVariableCS ) ) )* otherlv_11= ')' )
        // InternalQVTcore.g:855:8: otherlv_7= '(' ( (lv_ownedUnrealizedVariables_8_0= ruleGuardVariableCS ) ) (otherlv_9= ',' ( (lv_ownedUnrealizedVariables_10_0= ruleGuardVariableCS ) ) )* otherlv_11= ')'
        {
        otherlv_7=(Token)match(input,27,FollowSets000.FOLLOW_8); if (state.failed) return ;
        // InternalQVTcore.g:859:1: ( (lv_ownedUnrealizedVariables_8_0= ruleGuardVariableCS ) )
        // InternalQVTcore.g:860:1: (lv_ownedUnrealizedVariables_8_0= ruleGuardVariableCS )
        {
        // InternalQVTcore.g:860:1: (lv_ownedUnrealizedVariables_8_0= ruleGuardVariableCS )
        // InternalQVTcore.g:861:3: lv_ownedUnrealizedVariables_8_0= ruleGuardVariableCS
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getGuardPatternCSAccess().getOwnedUnrealizedVariablesGuardVariableCSParserRuleCall_1_1_0()); 
          	    
        }
        pushFollow(FollowSets000.FOLLOW_23);
        lv_ownedUnrealizedVariables_8_0=ruleGuardVariableCS();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // InternalQVTcore.g:877:2: (otherlv_9= ',' ( (lv_ownedUnrealizedVariables_10_0= ruleGuardVariableCS ) ) )*
        loop140:
        do {
            int alt140=2;
            int LA140_0 = input.LA(1);

            if ( (LA140_0==20) ) {
                alt140=1;
            }


            switch (alt140) {
        	case 1 :
        	    // InternalQVTcore.g:877:4: otherlv_9= ',' ( (lv_ownedUnrealizedVariables_10_0= ruleGuardVariableCS ) )
        	    {
        	    otherlv_9=(Token)match(input,20,FollowSets000.FOLLOW_8); if (state.failed) return ;
        	    // InternalQVTcore.g:881:1: ( (lv_ownedUnrealizedVariables_10_0= ruleGuardVariableCS ) )
        	    // InternalQVTcore.g:882:1: (lv_ownedUnrealizedVariables_10_0= ruleGuardVariableCS )
        	    {
        	    // InternalQVTcore.g:882:1: (lv_ownedUnrealizedVariables_10_0= ruleGuardVariableCS )
        	    // InternalQVTcore.g:883:3: lv_ownedUnrealizedVariables_10_0= ruleGuardVariableCS
        	    {
        	    if ( state.backtracking==0 ) {
        	       
        	      	        newCompositeNode(grammarAccess.getGuardPatternCSAccess().getOwnedUnrealizedVariablesGuardVariableCSParserRuleCall_1_2_1_0()); 
        	      	    
        	    }
        	    pushFollow(FollowSets000.FOLLOW_23);
        	    lv_ownedUnrealizedVariables_10_0=ruleGuardVariableCS();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }


        	    }
        	    break;

        	default :
        	    break loop140;
            }
        } while (true);

        otherlv_11=(Token)match(input,28,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred32_InternalQVTcore

    // $ANTLR start synpred34_InternalQVTcore
    public final void synpred34_InternalQVTcore_fragment() throws RecognitionException {   
        Token otherlv_12=null;
        Token otherlv_14=null;
        EObject lv_ownedPredicates_13_0 = null;


        // InternalQVTcore.g:904:6: ( (otherlv_12= '(' ( (lv_ownedPredicates_13_0= rulePredicateCS ) )+ otherlv_14= ')' ) )
        // InternalQVTcore.g:904:6: (otherlv_12= '(' ( (lv_ownedPredicates_13_0= rulePredicateCS ) )+ otherlv_14= ')' )
        {
        // InternalQVTcore.g:904:6: (otherlv_12= '(' ( (lv_ownedPredicates_13_0= rulePredicateCS ) )+ otherlv_14= ')' )
        // InternalQVTcore.g:904:8: otherlv_12= '(' ( (lv_ownedPredicates_13_0= rulePredicateCS ) )+ otherlv_14= ')'
        {
        otherlv_12=(Token)match(input,27,FollowSets000.FOLLOW_17); if (state.failed) return ;
        // InternalQVTcore.g:908:1: ( (lv_ownedPredicates_13_0= rulePredicateCS ) )+
        int cnt141=0;
        loop141:
        do {
            int alt141=2;
            int LA141_0 = input.LA(1);

            if ( ((LA141_0>=RULE_SIMPLE_ID && LA141_0<=RULE_SINGLE_QUOTED_STRING)||LA141_0==17||LA141_0==19||(LA141_0>=25 && LA141_0<=27)||LA141_0==30||LA141_0==32||(LA141_0>=34 && LA141_0<=35)||(LA141_0>=37 && LA141_0<=42)||(LA141_0>=59 && LA141_0<=73)||LA141_0==76||(LA141_0>=78 && LA141_0<=81)||LA141_0==86||(LA141_0>=91 && LA141_0<=92)) ) {
                alt141=1;
            }


            switch (alt141) {
        	case 1 :
        	    // InternalQVTcore.g:909:1: (lv_ownedPredicates_13_0= rulePredicateCS )
        	    {
        	    // InternalQVTcore.g:909:1: (lv_ownedPredicates_13_0= rulePredicateCS )
        	    // InternalQVTcore.g:910:3: lv_ownedPredicates_13_0= rulePredicateCS
        	    {
        	    if ( state.backtracking==0 ) {
        	       
        	      	        newCompositeNode(grammarAccess.getGuardPatternCSAccess().getOwnedPredicatesPredicateCSParserRuleCall_2_1_0()); 
        	      	    
        	    }
        	    pushFollow(FollowSets000.FOLLOW_22);
        	    lv_ownedPredicates_13_0=rulePredicateCS();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }
        	    break;

        	default :
        	    if ( cnt141 >= 1 ) break loop141;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(141, input);
                    throw eee;
            }
            cnt141++;
        } while (true);

        otherlv_14=(Token)match(input,28,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred34_InternalQVTcore

    // $ANTLR start synpred123_InternalQVTcore
    public final void synpred123_InternalQVTcore_fragment() throws RecognitionException {   
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_ownedPatternGuard_3_0 = null;


        // InternalQVTcore.g:4417:4: (otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}' )
        // InternalQVTcore.g:4417:4: otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}'
        {
        otherlv_2=(Token)match(input,21,FollowSets000.FOLLOW_17); if (state.failed) return ;
        // InternalQVTcore.g:4421:1: ( (lv_ownedPatternGuard_3_0= ruleExpCS ) )
        // InternalQVTcore.g:4422:1: (lv_ownedPatternGuard_3_0= ruleExpCS )
        {
        // InternalQVTcore.g:4422:1: (lv_ownedPatternGuard_3_0= ruleExpCS )
        // InternalQVTcore.g:4423:3: lv_ownedPatternGuard_3_0= ruleExpCS
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getTypeNameExpCSAccess().getOwnedPatternGuardExpCSParserRuleCall_1_1_1_0()); 
          	    
        }
        pushFollow(FollowSets000.FOLLOW_18);
        lv_ownedPatternGuard_3_0=ruleExpCS();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        otherlv_4=(Token)match(input,23,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred123_InternalQVTcore

    // $ANTLR start synpred124_InternalQVTcore
    public final void synpred124_InternalQVTcore_fragment() throws RecognitionException {   
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_ownedCurlyBracketedClause_1_0 = null;

        EObject lv_ownedPatternGuard_3_0 = null;


        // InternalQVTcore.g:4399:3: ( ( (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS ) ) (otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}' )? )
        // InternalQVTcore.g:4399:3: ( (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS ) ) (otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}' )?
        {
        // InternalQVTcore.g:4399:3: ( (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS ) )
        // InternalQVTcore.g:4400:1: (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS )
        {
        // InternalQVTcore.g:4400:1: (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS )
        // InternalQVTcore.g:4401:3: lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getTypeNameExpCSAccess().getOwnedCurlyBracketedClauseCurlyBracketedClauseCSParserRuleCall_1_0_0()); 
          	    
        }
        pushFollow(FollowSets000.FOLLOW_53);
        lv_ownedCurlyBracketedClause_1_0=ruleCurlyBracketedClauseCS();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // InternalQVTcore.g:4417:2: (otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}' )?
        int alt150=2;
        int LA150_0 = input.LA(1);

        if ( (LA150_0==21) ) {
            alt150=1;
        }
        switch (alt150) {
            case 1 :
                // InternalQVTcore.g:4417:4: otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}'
                {
                otherlv_2=(Token)match(input,21,FollowSets000.FOLLOW_17); if (state.failed) return ;
                // InternalQVTcore.g:4421:1: ( (lv_ownedPatternGuard_3_0= ruleExpCS ) )
                // InternalQVTcore.g:4422:1: (lv_ownedPatternGuard_3_0= ruleExpCS )
                {
                // InternalQVTcore.g:4422:1: (lv_ownedPatternGuard_3_0= ruleExpCS )
                // InternalQVTcore.g:4423:3: lv_ownedPatternGuard_3_0= ruleExpCS
                {
                if ( state.backtracking==0 ) {
                   
                  	        newCompositeNode(grammarAccess.getTypeNameExpCSAccess().getOwnedPatternGuardExpCSParserRuleCall_1_1_1_0()); 
                  	    
                }
                pushFollow(FollowSets000.FOLLOW_18);
                lv_ownedPatternGuard_3_0=ruleExpCS();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                otherlv_4=(Token)match(input,23,FollowSets000.FOLLOW_2); if (state.failed) return ;

                }
                break;

        }


        }
    }
    // $ANTLR end synpred124_InternalQVTcore

    // $ANTLR start synpred126_InternalQVTcore
    public final void synpred126_InternalQVTcore_fragment() throws RecognitionException {   
        EObject this_TypeLiteralCS_1 = null;


        // InternalQVTcore.g:4478:2: (this_TypeLiteralCS_1= ruleTypeLiteralCS )
        // InternalQVTcore.g:4478:2: this_TypeLiteralCS_1= ruleTypeLiteralCS
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
    // $ANTLR end synpred126_InternalQVTcore

    // $ANTLR start synpred129_InternalQVTcore
    public final void synpred129_InternalQVTcore_fragment() throws RecognitionException {   
        EObject this_PrefixedPrimaryExpCS_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_ownedRight_3_0 = null;


        // InternalQVTcore.g:4541:2: ( (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? ) )
        // InternalQVTcore.g:4541:2: (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? )
        {
        // InternalQVTcore.g:4541:2: (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? )
        // InternalQVTcore.g:4542:2: this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )?
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_54);
        this_PrefixedPrimaryExpCS_0=rulePrefixedPrimaryExpCS();

        state._fsp--;
        if (state.failed) return ;
        // InternalQVTcore.g:4553:1: ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )?
        int alt151=2;
        int LA151_0 = input.LA(1);

        if ( (LA151_0==32||LA151_0==41||(LA151_0>=43 && LA151_0<=58)) ) {
            alt151=1;
        }
        switch (alt151) {
            case 1 :
                // InternalQVTcore.g:4553:2: () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) )
                {
                // InternalQVTcore.g:4553:2: ()
                // InternalQVTcore.g:4554:2: 
                {
                if ( state.backtracking==0 ) {
                   
                  	  /* */ 
                  	
                }

                }

                // InternalQVTcore.g:4562:2: ( (lv_name_2_0= ruleBinaryOperatorName ) )
                // InternalQVTcore.g:4563:1: (lv_name_2_0= ruleBinaryOperatorName )
                {
                // InternalQVTcore.g:4563:1: (lv_name_2_0= ruleBinaryOperatorName )
                // InternalQVTcore.g:4564:3: lv_name_2_0= ruleBinaryOperatorName
                {
                if ( state.backtracking==0 ) {
                   
                  	        newCompositeNode(grammarAccess.getExpCSAccess().getNameBinaryOperatorNameParserRuleCall_0_1_1_0()); 
                  	    
                }
                pushFollow(FollowSets000.FOLLOW_17);
                lv_name_2_0=ruleBinaryOperatorName();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // InternalQVTcore.g:4580:2: ( (lv_ownedRight_3_0= ruleExpCS ) )
                // InternalQVTcore.g:4581:1: (lv_ownedRight_3_0= ruleExpCS )
                {
                // InternalQVTcore.g:4581:1: (lv_ownedRight_3_0= ruleExpCS )
                // InternalQVTcore.g:4582:3: lv_ownedRight_3_0= ruleExpCS
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
    // $ANTLR end synpred129_InternalQVTcore

    // $ANTLR start synpred136_InternalQVTcore
    public final void synpred136_InternalQVTcore_fragment() throws RecognitionException {   
        EObject this_TupleLiteralExpCS_4 = null;


        // InternalQVTcore.g:4843:2: (this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS )
        // InternalQVTcore.g:4843:2: this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS
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
    // $ANTLR end synpred136_InternalQVTcore

    // $ANTLR start synpred137_InternalQVTcore
    public final void synpred137_InternalQVTcore_fragment() throws RecognitionException {   
        EObject this_MapLiteralExpCS_5 = null;


        // InternalQVTcore.g:4856:2: (this_MapLiteralExpCS_5= ruleMapLiteralExpCS )
        // InternalQVTcore.g:4856:2: this_MapLiteralExpCS_5= ruleMapLiteralExpCS
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
    // $ANTLR end synpred137_InternalQVTcore

    // $ANTLR start synpred138_InternalQVTcore
    public final void synpred138_InternalQVTcore_fragment() throws RecognitionException {   
        EObject this_CollectionLiteralExpCS_6 = null;


        // InternalQVTcore.g:4869:2: (this_CollectionLiteralExpCS_6= ruleCollectionLiteralExpCS )
        // InternalQVTcore.g:4869:2: this_CollectionLiteralExpCS_6= ruleCollectionLiteralExpCS
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
    // $ANTLR end synpred138_InternalQVTcore

    // $ANTLR start synpred140_InternalQVTcore
    public final void synpred140_InternalQVTcore_fragment() throws RecognitionException {   
        EObject this_TypeLiteralExpCS_8 = null;


        // InternalQVTcore.g:4895:2: (this_TypeLiteralExpCS_8= ruleTypeLiteralExpCS )
        // InternalQVTcore.g:4895:2: this_TypeLiteralExpCS_8= ruleTypeLiteralExpCS
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
    // $ANTLR end synpred140_InternalQVTcore

    // Delegated rules

    public final boolean synpred124_InternalQVTcore() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred124_InternalQVTcore_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred17_InternalQVTcore() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred17_InternalQVTcore_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred30_InternalQVTcore() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred30_InternalQVTcore_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred32_InternalQVTcore() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred32_InternalQVTcore_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred123_InternalQVTcore() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred123_InternalQVTcore_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred138_InternalQVTcore() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred138_InternalQVTcore_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred21_InternalQVTcore() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred21_InternalQVTcore_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred129_InternalQVTcore() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred129_InternalQVTcore_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred126_InternalQVTcore() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred126_InternalQVTcore_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred140_InternalQVTcore() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred140_InternalQVTcore_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred137_InternalQVTcore() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred137_InternalQVTcore_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred23_InternalQVTcore() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred23_InternalQVTcore_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred34_InternalQVTcore() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred34_InternalQVTcore_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred136_InternalQVTcore() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred136_InternalQVTcore_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA38 dfa38 = new DFA38(this);
    protected DFA39 dfa39 = new DFA39(this);
    protected DFA61 dfa61 = new DFA61(this);
    protected DFA64 dfa64 = new DFA64(this);
    protected DFA76 dfa76 = new DFA76(this);
    protected DFA75 dfa75 = new DFA75(this);
    protected DFA77 dfa77 = new DFA77(this);
    protected DFA80 dfa80 = new DFA80(this);
    protected DFA83 dfa83 = new DFA83(this);
    protected DFA107 dfa107 = new DFA107(this);
    static final String dfa_1s = "\37\uffff";
    static final String dfa_2s = "\1\16\36\uffff";
    static final String dfa_3s = "\1\4\15\25\1\uffff\17\25\1\uffff";
    static final String dfa_4s = "\1\111\15\37\1\uffff\17\37\1\uffff";
    static final String dfa_5s = "\16\uffff\1\2\17\uffff\1\1";
    static final String dfa_6s = "\37\uffff}>";
    static final String[] dfa_7s = {
            "\1\1\1\2\13\uffff\1\10\1\uffff\1\13\5\uffff\1\6\1\15\3\uffff\1\5\3\uffff\1\3\1\4\1\uffff\1\11\1\14\1\12\1\7\22\uffff\1\34\1\35\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\17\1\20\1\21\1\22\1\23",
            "\1\16\5\uffff\1\16\3\uffff\1\36",
            "\1\16\5\uffff\1\16\3\uffff\1\36",
            "\1\16\5\uffff\1\16\3\uffff\1\36",
            "\1\16\5\uffff\1\16\3\uffff\1\36",
            "\1\16\5\uffff\1\16\3\uffff\1\36",
            "\1\16\5\uffff\1\16\3\uffff\1\36",
            "\1\16\5\uffff\1\16\3\uffff\1\36",
            "\1\16\5\uffff\1\16\3\uffff\1\36",
            "\1\16\5\uffff\1\16\3\uffff\1\36",
            "\1\16\5\uffff\1\16\3\uffff\1\36",
            "\1\16\5\uffff\1\16\3\uffff\1\36",
            "\1\16\5\uffff\1\16\3\uffff\1\36",
            "\1\16\5\uffff\1\16\3\uffff\1\36",
            "",
            "\1\16\11\uffff\1\36",
            "\1\16\11\uffff\1\36",
            "\1\16\11\uffff\1\36",
            "\1\16\11\uffff\1\36",
            "\1\16\11\uffff\1\36",
            "\1\16\11\uffff\1\36",
            "\1\16\11\uffff\1\36",
            "\1\16\11\uffff\1\36",
            "\1\16\11\uffff\1\36",
            "\1\16\11\uffff\1\36",
            "\1\16\11\uffff\1\36",
            "\1\16\11\uffff\1\36",
            "\1\16\11\uffff\1\36",
            "\1\16\11\uffff\1\36",
            "\1\16\11\uffff\1\36",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA38 extends DFA {

        public DFA38(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 38;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "()* loopback of 1591:1: ( ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) otherlv_3= '::' )*";
        }
    }
    static final String dfa_8s = "\20\uffff";
    static final String dfa_9s = "\1\4\15\25\2\uffff";
    static final String dfa_10s = "\1\111\15\37\2\uffff";
    static final String dfa_11s = "\16\uffff\1\2\1\1";
    static final String dfa_12s = "\20\uffff}>";
    static final String[] dfa_13s = {
            "\1\1\1\2\13\uffff\1\10\1\uffff\1\13\5\uffff\1\6\1\15\3\uffff\1\5\3\uffff\1\3\1\4\1\uffff\1\11\1\14\1\12\1\7\22\uffff\17\16",
            "\1\16\11\uffff\1\17",
            "\1\16\11\uffff\1\17",
            "\1\16\11\uffff\1\17",
            "\1\16\11\uffff\1\17",
            "\1\16\11\uffff\1\17",
            "\1\16\11\uffff\1\17",
            "\1\16\11\uffff\1\17",
            "\1\16\11\uffff\1\17",
            "\1\16\11\uffff\1\17",
            "\1\16\11\uffff\1\17",
            "\1\16\11\uffff\1\17",
            "\1\16\11\uffff\1\17",
            "\1\16\11\uffff\1\17",
            "",
            ""
    };

    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[][] dfa_13 = unpackEncodedStringArray(dfa_13s);

    class DFA39 extends DFA {

        public DFA39(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 39;
            this.eot = dfa_8;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "1638:1: ( (lv_ownedPathName_1_0= ruleScopeNameCS ) )?";
        }
    }
    static final String dfa_14s = "\2\uffff\15\1\1\uffff";
    static final String dfa_15s = "\1\4\1\uffff\15\24\1\uffff";
    static final String dfa_16s = "\1\134\1\uffff\15\124\1\uffff";
    static final String dfa_17s = "\1\uffff\1\1\15\uffff\1\2";
    static final String[] dfa_18s = {
            "\1\2\1\3\2\1\11\uffff\1\11\1\uffff\1\14\5\uffff\1\7\1\16\1\1\1\uffff\1\17\1\6\1\uffff\1\1\1\uffff\1\4\1\5\1\uffff\1\12\1\15\1\13\1\10\2\1\20\uffff\17\1\2\uffff\1\1\1\uffff\4\1\4\uffff\1\1\4\uffff\2\1",
            "",
            "\2\1\1\uffff\1\1\3\uffff\1\1\1\uffff\1\17\1\uffff\2\1\10\uffff\1\1\1\uffff\20\1\17\uffff\1\1\7\uffff\1\1\1\uffff\1\1",
            "\2\1\1\uffff\1\1\3\uffff\1\1\1\uffff\1\17\1\uffff\2\1\10\uffff\1\1\1\uffff\20\1\17\uffff\1\1\7\uffff\1\1\1\uffff\1\1",
            "\2\1\1\uffff\1\1\3\uffff\1\1\1\uffff\1\17\1\uffff\2\1\10\uffff\1\1\1\uffff\20\1\17\uffff\1\1\7\uffff\1\1\1\uffff\1\1",
            "\2\1\1\uffff\1\1\3\uffff\1\1\1\uffff\1\17\1\uffff\2\1\10\uffff\1\1\1\uffff\20\1\17\uffff\1\1\7\uffff\1\1\1\uffff\1\1",
            "\2\1\1\uffff\1\1\3\uffff\1\1\1\uffff\1\17\1\uffff\2\1\10\uffff\1\1\1\uffff\20\1\17\uffff\1\1\7\uffff\1\1\1\uffff\1\1",
            "\2\1\1\uffff\1\1\3\uffff\1\1\1\uffff\1\17\1\uffff\2\1\10\uffff\1\1\1\uffff\20\1\17\uffff\1\1\7\uffff\1\1\1\uffff\1\1",
            "\2\1\1\uffff\1\1\3\uffff\1\1\1\uffff\1\17\1\uffff\2\1\10\uffff\1\1\1\uffff\20\1\17\uffff\1\1\7\uffff\1\1\1\uffff\1\1",
            "\2\1\1\uffff\1\1\3\uffff\1\1\1\uffff\1\17\1\uffff\2\1\10\uffff\1\1\1\uffff\20\1\17\uffff\1\1\7\uffff\1\1\1\uffff\1\1",
            "\2\1\1\uffff\1\1\3\uffff\1\1\1\uffff\1\17\1\uffff\2\1\10\uffff\1\1\1\uffff\20\1\17\uffff\1\1\7\uffff\1\1\1\uffff\1\1",
            "\2\1\1\uffff\1\1\3\uffff\1\1\1\uffff\1\17\1\uffff\2\1\10\uffff\1\1\1\uffff\20\1\17\uffff\1\1\7\uffff\1\1\1\uffff\1\1",
            "\2\1\1\uffff\1\1\3\uffff\1\1\1\uffff\1\17\1\uffff\2\1\10\uffff\1\1\1\uffff\20\1\17\uffff\1\1\7\uffff\1\1\1\uffff\1\1",
            "\2\1\1\uffff\1\1\3\uffff\1\1\1\uffff\1\17\1\uffff\2\1\10\uffff\1\1\1\uffff\20\1\17\uffff\1\1\7\uffff\1\1\1\uffff\1\1",
            "\2\1\1\uffff\1\1\3\uffff\1\1\1\uffff\1\17\1\uffff\2\1\10\uffff\1\1\1\uffff\20\1\17\uffff\1\1\7\uffff\1\1\1\uffff\1\1",
            ""
    };
    static final short[] dfa_14 = DFA.unpackEncodedString(dfa_14s);
    static final char[] dfa_15 = DFA.unpackEncodedStringToUnsignedChars(dfa_15s);
    static final char[] dfa_16 = DFA.unpackEncodedStringToUnsignedChars(dfa_16s);
    static final short[] dfa_17 = DFA.unpackEncodedString(dfa_17s);
    static final short[][] dfa_18 = unpackEncodedStringArray(dfa_18s);

    class DFA61 extends DFA {

        public DFA61(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 61;
            this.eot = dfa_8;
            this.eof = dfa_14;
            this.min = dfa_15;
            this.max = dfa_16;
            this.accept = dfa_17;
            this.special = dfa_12;
            this.transition = dfa_18;
        }
        public String getDescription() {
            return "3205:1: ( ( ( (lv_ownedExpression_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_ownedLastExpression_2_0= ruleExpCS ) ) )? ) | ( (lv_ownedExpression_3_0= rulePatternExpCS ) ) )";
        }
    }
    static final String[] dfa_19s = {
            "\1\2\1\3\2\1\11\uffff\1\11\1\uffff\1\14\5\uffff\1\7\1\16\1\1\1\uffff\1\17\1\6\1\uffff\1\1\1\uffff\1\4\1\5\1\uffff\1\12\1\15\1\13\1\10\2\1\20\uffff\17\1\2\uffff\1\1\1\uffff\4\1\4\uffff\1\1\4\uffff\2\1",
            "",
            "\2\1\1\uffff\1\1\3\uffff\1\1\1\uffff\1\17\1\uffff\2\1\10\uffff\1\1\1\uffff\20\1\27\uffff\1\1\1\uffff\1\1",
            "\2\1\1\uffff\1\1\3\uffff\1\1\1\uffff\1\17\1\uffff\2\1\10\uffff\1\1\1\uffff\20\1\27\uffff\1\1\1\uffff\1\1",
            "\2\1\1\uffff\1\1\3\uffff\1\1\1\uffff\1\17\1\uffff\2\1\10\uffff\1\1\1\uffff\20\1\27\uffff\1\1\1\uffff\1\1",
            "\2\1\1\uffff\1\1\3\uffff\1\1\1\uffff\1\17\1\uffff\2\1\10\uffff\1\1\1\uffff\20\1\27\uffff\1\1\1\uffff\1\1",
            "\2\1\1\uffff\1\1\3\uffff\1\1\1\uffff\1\17\1\uffff\2\1\10\uffff\1\1\1\uffff\20\1\27\uffff\1\1\1\uffff\1\1",
            "\2\1\1\uffff\1\1\3\uffff\1\1\1\uffff\1\17\1\uffff\2\1\10\uffff\1\1\1\uffff\20\1\27\uffff\1\1\1\uffff\1\1",
            "\2\1\1\uffff\1\1\3\uffff\1\1\1\uffff\1\17\1\uffff\2\1\10\uffff\1\1\1\uffff\20\1\27\uffff\1\1\1\uffff\1\1",
            "\2\1\1\uffff\1\1\3\uffff\1\1\1\uffff\1\17\1\uffff\2\1\10\uffff\1\1\1\uffff\20\1\27\uffff\1\1\1\uffff\1\1",
            "\2\1\1\uffff\1\1\3\uffff\1\1\1\uffff\1\17\1\uffff\2\1\10\uffff\1\1\1\uffff\20\1\27\uffff\1\1\1\uffff\1\1",
            "\2\1\1\uffff\1\1\3\uffff\1\1\1\uffff\1\17\1\uffff\2\1\10\uffff\1\1\1\uffff\20\1\27\uffff\1\1\1\uffff\1\1",
            "\2\1\1\uffff\1\1\3\uffff\1\1\1\uffff\1\17\1\uffff\2\1\10\uffff\1\1\1\uffff\20\1\27\uffff\1\1\1\uffff\1\1",
            "\2\1\1\uffff\1\1\3\uffff\1\1\1\uffff\1\17\1\uffff\2\1\10\uffff\1\1\1\uffff\20\1\27\uffff\1\1\1\uffff\1\1",
            "\2\1\1\uffff\1\1\3\uffff\1\1\1\uffff\1\17\1\uffff\2\1\10\uffff\1\1\1\uffff\20\1\27\uffff\1\1\1\uffff\1\1",
            ""
    };
    static final short[][] dfa_19 = unpackEncodedStringArray(dfa_19s);

    class DFA64 extends DFA {

        public DFA64(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 64;
            this.eot = dfa_8;
            this.eof = dfa_14;
            this.min = dfa_15;
            this.max = dfa_16;
            this.accept = dfa_17;
            this.special = dfa_12;
            this.transition = dfa_19;
        }
        public String getDescription() {
            return "3418:1: (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS )";
        }
    }
    static final String dfa_20s = "\16\uffff";
    static final String dfa_21s = "\1\2\15\uffff";
    static final String dfa_22s = "\1\24\1\0\14\uffff";
    static final String dfa_23s = "\1\127\1\0\14\uffff";
    static final String dfa_24s = "\2\uffff\1\2\12\uffff\1\1";
    static final String dfa_25s = "\1\uffff\1\0\14\uffff}>";
    static final String[] dfa_26s = {
            "\1\2\1\1\1\uffff\2\2\3\uffff\1\2\4\uffff\1\2\2\uffff\1\2\14\uffff\1\2\31\uffff\1\2\10\uffff\1\2\2\uffff\1\2",
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
            ""
    };

    static final short[] dfa_20 = DFA.unpackEncodedString(dfa_20s);
    static final short[] dfa_21 = DFA.unpackEncodedString(dfa_21s);
    static final char[] dfa_22 = DFA.unpackEncodedStringToUnsignedChars(dfa_22s);
    static final char[] dfa_23 = DFA.unpackEncodedStringToUnsignedChars(dfa_23s);
    static final short[] dfa_24 = DFA.unpackEncodedString(dfa_24s);
    static final short[] dfa_25 = DFA.unpackEncodedString(dfa_25s);
    static final short[][] dfa_26 = unpackEncodedStringArray(dfa_26s);

    class DFA76 extends DFA {

        public DFA76(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 76;
            this.eot = dfa_20;
            this.eof = dfa_21;
            this.min = dfa_22;
            this.max = dfa_23;
            this.accept = dfa_24;
            this.special = dfa_25;
            this.transition = dfa_26;
        }
        public String getDescription() {
            return "4399:2: ( ( (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS ) ) (otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}' )? )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA76_1 = input.LA(1);

                         
                        int index76_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred124_InternalQVTcore()) ) {s = 13;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index76_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 76, _s, input);
            error(nvae);
            throw nvae;
        }
    }

    class DFA75 extends DFA {

        public DFA75(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 75;
            this.eot = dfa_20;
            this.eof = dfa_21;
            this.min = dfa_22;
            this.max = dfa_23;
            this.accept = dfa_24;
            this.special = dfa_25;
            this.transition = dfa_26;
        }
        public String getDescription() {
            return "4417:2: (otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA75_1 = input.LA(1);

                         
                        int index75_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred123_InternalQVTcore()) ) {s = 13;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index75_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 75, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_27s = "\36\uffff";
    static final String dfa_28s = "\1\4\25\uffff\5\0\3\uffff";
    static final String dfa_29s = "\1\111\25\uffff\5\0\3\uffff";
    static final String dfa_30s = "\1\uffff\1\1\14\uffff\1\2\16\uffff\1\3";
    static final String dfa_31s = "\26\uffff\1\0\1\1\1\2\1\3\1\4\3\uffff}>";
    static final String[] dfa_32s = {
            "\2\1\13\uffff\1\1\1\uffff\1\1\5\uffff\2\1\3\uffff\1\1\3\uffff\2\1\1\uffff\4\1\22\uffff\12\16\1\26\1\27\1\30\1\31\1\32",
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
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            ""
    };

    static final short[] dfa_27 = DFA.unpackEncodedString(dfa_27s);
    static final char[] dfa_28 = DFA.unpackEncodedStringToUnsignedChars(dfa_28s);
    static final char[] dfa_29 = DFA.unpackEncodedStringToUnsignedChars(dfa_29s);
    static final short[] dfa_30 = DFA.unpackEncodedString(dfa_30s);
    static final short[] dfa_31 = DFA.unpackEncodedString(dfa_31s);
    static final short[][] dfa_32 = unpackEncodedStringArray(dfa_32s);

    class DFA77 extends DFA {

        public DFA77(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 77;
            this.eot = dfa_27;
            this.eof = dfa_27;
            this.min = dfa_28;
            this.max = dfa_29;
            this.accept = dfa_30;
            this.special = dfa_31;
            this.transition = dfa_32;
        }
        public String getDescription() {
            return "4464:2: (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS | this_CollectionPatternCS_2= ruleCollectionPatternCS )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA77_22 = input.LA(1);

                         
                        int index77_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred126_InternalQVTcore()) ) {s = 14;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index77_22);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA77_23 = input.LA(1);

                         
                        int index77_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred126_InternalQVTcore()) ) {s = 14;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index77_23);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA77_24 = input.LA(1);

                         
                        int index77_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred126_InternalQVTcore()) ) {s = 14;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index77_24);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA77_25 = input.LA(1);

                         
                        int index77_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred126_InternalQVTcore()) ) {s = 14;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index77_25);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA77_26 = input.LA(1);

                         
                        int index77_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred126_InternalQVTcore()) ) {s = 14;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index77_26);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 77, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_33s = "\53\uffff";
    static final String dfa_34s = "\1\4\2\0\50\uffff";
    static final String dfa_35s = "\1\134\2\0\50\uffff";
    static final String dfa_36s = "\3\uffff\1\1\46\uffff\1\2";
    static final String dfa_37s = "\1\uffff\1\0\1\1\50\uffff}>";
    static final String[] dfa_38s = {
            "\4\3\11\uffff\1\3\1\uffff\1\3\5\uffff\3\3\2\uffff\1\3\1\uffff\1\3\1\uffff\2\3\1\uffff\4\3\1\1\1\2\20\uffff\17\3\2\uffff\1\3\1\uffff\4\3\4\uffff\1\3\4\uffff\1\52\1\3",
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

    static final short[] dfa_33 = DFA.unpackEncodedString(dfa_33s);
    static final char[] dfa_34 = DFA.unpackEncodedStringToUnsignedChars(dfa_34s);
    static final char[] dfa_35 = DFA.unpackEncodedStringToUnsignedChars(dfa_35s);
    static final short[] dfa_36 = DFA.unpackEncodedString(dfa_36s);
    static final short[] dfa_37 = DFA.unpackEncodedString(dfa_37s);
    static final short[][] dfa_38 = unpackEncodedStringArray(dfa_38s);

    class DFA80 extends DFA {

        public DFA80(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 80;
            this.eot = dfa_33;
            this.eof = dfa_33;
            this.min = dfa_34;
            this.max = dfa_35;
            this.accept = dfa_36;
            this.special = dfa_37;
            this.transition = dfa_38;
        }
        public String getDescription() {
            return "4541:1: ( (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? ) | this_PrefixedLetExpCS_4= rulePrefixedLetExpCS )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA80_1 = input.LA(1);

                         
                        int index80_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred129_InternalQVTcore()) ) {s = 3;}

                        else if ( (true) ) {s = 42;}

                         
                        input.seek(index80_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA80_2 = input.LA(1);

                         
                        int index80_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred129_InternalQVTcore()) ) {s = 3;}

                        else if ( (true) ) {s = 42;}

                         
                        input.seek(index80_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 80, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_39s = "\1\4\12\uffff\7\0\31\uffff";
    static final String dfa_40s = "\1\134\12\uffff\7\0\31\uffff";
    static final String dfa_41s = "\1\uffff\1\1\1\2\1\3\1\4\15\uffff\1\10\1\11\7\uffff\1\12\14\uffff\1\5\1\6\1\7";
    static final String dfa_42s = "\13\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\31\uffff}>";
    static final String[] dfa_43s = {
            "\2\33\2\4\11\uffff\1\33\1\uffff\1\33\5\uffff\2\33\1\1\2\uffff\1\33\1\uffff\1\4\1\uffff\2\33\1\uffff\4\33\22\uffff\1\14\1\13\10\23\1\15\1\16\1\17\1\20\1\21\2\uffff\1\22\1\uffff\4\4\4\uffff\1\2\5\uffff\1\3",
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
    static final char[] dfa_39 = DFA.unpackEncodedStringToUnsignedChars(dfa_39s);
    static final char[] dfa_40 = DFA.unpackEncodedStringToUnsignedChars(dfa_40s);
    static final short[] dfa_41 = DFA.unpackEncodedString(dfa_41s);
    static final short[] dfa_42 = DFA.unpackEncodedString(dfa_42s);
    static final short[][] dfa_43 = unpackEncodedStringArray(dfa_43s);

    class DFA83 extends DFA {

        public DFA83(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 83;
            this.eot = dfa_33;
            this.eof = dfa_33;
            this.min = dfa_39;
            this.max = dfa_40;
            this.accept = dfa_41;
            this.special = dfa_42;
            this.transition = dfa_43;
        }
        public String getDescription() {
            return "4790:1: (this_NestedExpCS_0= ruleNestedExpCS | this_IfExpCS_1= ruleIfExpCS | this_SelfExpCS_2= ruleSelfExpCS | this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS | this_MapLiteralExpCS_5= ruleMapLiteralExpCS | this_CollectionLiteralExpCS_6= ruleCollectionLiteralExpCS | this_LambdaLiteralExpCS_7= ruleLambdaLiteralExpCS | this_TypeLiteralExpCS_8= ruleTypeLiteralExpCS | this_NameExpCS_9= ruleNameExpCS )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA83_11 = input.LA(1);

                         
                        int index83_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred136_InternalQVTcore()) ) {s = 40;}

                        else if ( (synpred140_InternalQVTcore()) ) {s = 19;}

                         
                        input.seek(index83_11);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA83_12 = input.LA(1);

                         
                        int index83_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_InternalQVTcore()) ) {s = 41;}

                        else if ( (synpred140_InternalQVTcore()) ) {s = 19;}

                         
                        input.seek(index83_12);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA83_13 = input.LA(1);

                         
                        int index83_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred138_InternalQVTcore()) ) {s = 42;}

                        else if ( (synpred140_InternalQVTcore()) ) {s = 19;}

                         
                        input.seek(index83_13);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA83_14 = input.LA(1);

                         
                        int index83_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred138_InternalQVTcore()) ) {s = 42;}

                        else if ( (synpred140_InternalQVTcore()) ) {s = 19;}

                         
                        input.seek(index83_14);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA83_15 = input.LA(1);

                         
                        int index83_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred138_InternalQVTcore()) ) {s = 42;}

                        else if ( (synpred140_InternalQVTcore()) ) {s = 19;}

                         
                        input.seek(index83_15);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA83_16 = input.LA(1);

                         
                        int index83_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred138_InternalQVTcore()) ) {s = 42;}

                        else if ( (synpred140_InternalQVTcore()) ) {s = 19;}

                         
                        input.seek(index83_16);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA83_17 = input.LA(1);

                         
                        int index83_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred138_InternalQVTcore()) ) {s = 42;}

                        else if ( (synpred140_InternalQVTcore()) ) {s = 19;}

                         
                        input.seek(index83_17);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 83, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_44s = "\1\4\1\uffff\15\25\1\uffff";
    static final String dfa_45s = "\1\134\1\uffff\15\127\1\uffff";
    static final String[] dfa_46s = {
            "\1\2\1\3\2\1\11\uffff\1\11\1\uffff\1\14\5\uffff\1\7\1\16\1\1\1\uffff\1\17\1\6\1\uffff\1\1\1\uffff\1\4\1\5\1\uffff\1\12\1\15\1\13\1\10\2\1\20\uffff\17\1\2\uffff\1\1\1\uffff\4\1\4\uffff\1\1\4\uffff\2\1",
            "",
            "\1\1\5\uffff\1\1\1\uffff\1\17\1\uffff\2\1\10\uffff\1\1\1\uffff\20\1\27\uffff\1\1\1\uffff\1\1\2\uffff\1\1",
            "\1\1\5\uffff\1\1\1\uffff\1\17\1\uffff\2\1\10\uffff\1\1\1\uffff\20\1\27\uffff\1\1\1\uffff\1\1\2\uffff\1\1",
            "\1\1\5\uffff\1\1\1\uffff\1\17\1\uffff\2\1\10\uffff\1\1\1\uffff\20\1\27\uffff\1\1\1\uffff\1\1\2\uffff\1\1",
            "\1\1\5\uffff\1\1\1\uffff\1\17\1\uffff\2\1\10\uffff\1\1\1\uffff\20\1\27\uffff\1\1\1\uffff\1\1\2\uffff\1\1",
            "\1\1\5\uffff\1\1\1\uffff\1\17\1\uffff\2\1\10\uffff\1\1\1\uffff\20\1\27\uffff\1\1\1\uffff\1\1\2\uffff\1\1",
            "\1\1\5\uffff\1\1\1\uffff\1\17\1\uffff\2\1\10\uffff\1\1\1\uffff\20\1\27\uffff\1\1\1\uffff\1\1\2\uffff\1\1",
            "\1\1\5\uffff\1\1\1\uffff\1\17\1\uffff\2\1\10\uffff\1\1\1\uffff\20\1\27\uffff\1\1\1\uffff\1\1\2\uffff\1\1",
            "\1\1\5\uffff\1\1\1\uffff\1\17\1\uffff\2\1\10\uffff\1\1\1\uffff\20\1\27\uffff\1\1\1\uffff\1\1\2\uffff\1\1",
            "\1\1\5\uffff\1\1\1\uffff\1\17\1\uffff\2\1\10\uffff\1\1\1\uffff\20\1\27\uffff\1\1\1\uffff\1\1\2\uffff\1\1",
            "\1\1\5\uffff\1\1\1\uffff\1\17\1\uffff\2\1\10\uffff\1\1\1\uffff\20\1\27\uffff\1\1\1\uffff\1\1\2\uffff\1\1",
            "\1\1\5\uffff\1\1\1\uffff\1\17\1\uffff\2\1\10\uffff\1\1\1\uffff\20\1\27\uffff\1\1\1\uffff\1\1\2\uffff\1\1",
            "\1\1\5\uffff\1\1\1\uffff\1\17\1\uffff\2\1\10\uffff\1\1\1\uffff\20\1\27\uffff\1\1\1\uffff\1\1\2\uffff\1\1",
            "\1\1\5\uffff\1\1\1\uffff\1\17\1\uffff\2\1\10\uffff\1\1\1\uffff\20\1\27\uffff\1\1\1\uffff\1\1\2\uffff\1\1",
            ""
    };
    static final char[] dfa_44 = DFA.unpackEncodedStringToUnsignedChars(dfa_44s);
    static final char[] dfa_45 = DFA.unpackEncodedStringToUnsignedChars(dfa_45s);
    static final short[][] dfa_46 = unpackEncodedStringArray(dfa_46s);

    class DFA107 extends DFA {

        public DFA107(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 107;
            this.eot = dfa_8;
            this.eof = dfa_8;
            this.min = dfa_44;
            this.max = dfa_45;
            this.accept = dfa_17;
            this.special = dfa_12;
            this.transition = dfa_46;
        }
        public String getDescription() {
            return "5849:1: (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS )";
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000006040030002L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000006000030002L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x000001EC462E0030L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x00000000002C0000L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x000001EC460A0030L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000280000L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000300000L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x000001EC46CB0030L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000830000L});
        public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000001100000L});
        public static final BitSet FOLLOW_15 = new BitSet(new long[]{0xF80007ED4E8B00F0L,0x000000001843D3FFL});
        public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000900000L});
        public static final BitSet FOLLOW_17 = new BitSet(new long[]{0xF80007ED4E0B00F0L,0x000000001843D3FFL});
        public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000004100002L});
        public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000100002L});
        public static final BitSet FOLLOW_22 = new BitSet(new long[]{0xF80007ED5E0B00F0L,0x000000001843D3FFL});
        public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000010100000L});
        public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_26 = new BitSet(new long[]{0xF80001EC460A0030L,0x00000000000003FFL});
        public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x000001EC460A00B0L});
        public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000280000000L});
        public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000200000000L});
        public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000001200000000L});
        public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x000001EC560A0030L});
        public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000200200000L});
        public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_36 = new BitSet(new long[]{0xF80001EC460A0032L,0x00000000000003FFL});
        public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x000001EC468A0030L});
        public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000001020000002L});
        public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000001000000002L});
        public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000080000002L});
        public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000008000002L});
        public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_43 = new BitSet(new long[]{0xF80007ED6E8B00F0L,0x000000001843D3FFL});
        public static final BitSet FOLLOW_44 = new BitSet(new long[]{0xF80007ED6E0B00F0L,0x000000001843D3FFL});
        public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000400L});
        public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000000100000L,0x0000000000000800L});
        public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0002000000000000L});
        public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
        public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0002000020000000L});
        public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000000082L});
        public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000000002L,0x0000000000100000L});
        public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000000200002L});
        public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x07FFFA0100000002L});
        public static final BitSet FOLLOW_55 = new BitSet(new long[]{0xF80007ED4E0A00F0L,0x000000001043D3FFL});
        public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000008200002L,0x0000000000140000L});
        public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000200002L,0x0000000000040000L});
        public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000000000002L,0x0000000000040000L});
        public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
        public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x000001EC468A00B0L});
        public static final BitSet FOLLOW_61 = new BitSet(new long[]{0xF80007ED7E0B00F0L,0x000000001843D3FFL});
        public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000211100000L});
        public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000011100000L});
        public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000000100000L,0x0000000000200000L});
        public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000020040002L});
        public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0002000000000002L});
        public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
        public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000000000000000L,0x0000000005000000L});
        public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
        public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0000000000140000L});
        public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0002000028000000L});
        public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0000000100000040L});
        public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000100100000040L,0x0000000080000000L});
        public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x0000000000000000L,0x0000000060200000L});
        public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
        public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x0000000000100002L,0x0000000000100000L});
        public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x000001EC460A0030L,0x0000000080000000L});
        public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x0000000000000002L,0x0000000100000000L});
        public static final BitSet FOLLOW_80 = new BitSet(new long[]{0x0000000000000002L,0x0000000200000000L});
    }


}