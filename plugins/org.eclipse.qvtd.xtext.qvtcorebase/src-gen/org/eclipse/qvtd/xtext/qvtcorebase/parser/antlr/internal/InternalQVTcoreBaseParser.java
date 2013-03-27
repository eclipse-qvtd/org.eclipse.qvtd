package org.eclipse.qvtd.xtext.qvtcorebase.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.qvtd.xtext.qvtcorebase.services.QVTcoreBaseGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalQVTcoreBaseParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_SIMPLE_ID", "RULE_ESCAPED_ID", "RULE_INT", "RULE_SINGLE_QUOTED_STRING", "RULE_ESCAPED_CHARACTER", "RULE_LETTER_CHARACTER", "RULE_DOUBLE_QUOTED_STRING", "RULE_ML_SINGLE_QUOTED_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "','", "'|'", "'default'", "':='", "';'", "'imports'", "'uses'", "':'", "'::'", "'realize'", "'check'", "'enforce'", "'import'", "'library'", "'map'", "'query'", "'refines'", "'transformation'", "'*'", "'-'", "'not'", "'/'", "'+'", "'>'", "'<'", "'>='", "'<='", "'='", "'<>'", "'and'", "'or'", "'xor'", "'implies'", "'.'", "'->'", "'Tuple'", "'Boolean'", "'Integer'", "'Real'", "'String'", "'UnlimitedNatural'", "'OclAny'", "'OclInvalid'", "'OclVoid'", "'Set'", "'Bag'", "'Sequence'", "'Collection'", "'OrderedSet'", "'('", "')'", "'..'", "'['", "']'", "'?'", "'{'", "'}'", "'true'", "'false'", "'invalid'", "'null'", "'@'", "'pre'", "'if'", "'then'", "'else'", "'endif'", "'let'", "'in'", "'self'"
    };
    public static final int T__42=42;
    public static final int T__28=28;
    public static final int T__57=57;
    public static final int T__23=23;
    public static final int T__80=80;
    public static final int T__51=51;
    public static final int RULE_LETTER_CHARACTER=9;
    public static final int T__69=69;
    public static final int T__47=47;
    public static final int T__73=73;
    public static final int T__50=50;
    public static final int T__21=21;
    public static final int RULE_ML_SINGLE_QUOTED_STRING=11;
    public static final int T__65=65;
    public static final int T__19=19;
    public static final int T__72=72;
    public static final int T__70=70;
    public static final int T__67=67;
    public static final int T__74=74;
    public static final int T__39=39;
    public static final int T__30=30;
    public static final int T__46=46;
    public static final int T__52=52;
    public static final int T__68=68;
    public static final int T__17=17;
    public static final int T__62=62;
    public static final int RULE_INT=6;
    public static final int T__27=27;
    public static final int T__24=24;
    public static final int T__49=49;
    public static final int RULE_SINGLE_QUOTED_STRING=7;
    public static final int T__61=61;
    public static final int RULE_DOUBLE_QUOTED_STRING=10;
    public static final int T__59=59;
    public static final int T__48=48;
    public static final int T__54=54;
    public static final int T__34=34;
    public static final int T__56=56;
    public static final int RULE_ESCAPED_CHARACTER=8;
    public static final int RULE_ML_COMMENT=12;
    public static final int T__35=35;
    public static final int T__78=78;
    public static final int T__36=36;
    public static final int T__20=20;
    public static final int T__58=58;
    public static final int T__79=79;
    public static final int T__64=64;
    public static final int RULE_SIMPLE_ID=4;
    public static final int T__44=44;
    public static final int T__66=66;
    public static final int T__33=33;
    public static final int T__22=22;
    public static final int T__77=77;
    public static final int T__29=29;
    public static final int T__45=45;
    public static final int T__55=55;
    public static final int RULE_ESCAPED_ID=5;
    public static final int T__84=84;
    public static final int RULE_WS=14;
    public static final int T__63=63;
    public static final int T__75=75;
    public static final int T__43=43;
    public static final int T__31=31;
    public static final int T__40=40;
    public static final int EOF=-1;
    public static final int T__53=53;
    public static final int T__85=85;
    public static final int T__16=16;
    public static final int T__32=32;
    public static final int T__38=38;
    public static final int T__76=76;
    public static final int T__37=37;
    public static final int RULE_ANY_OTHER=15;
    public static final int T__82=82;
    public static final int T__26=26;
    public static final int T__81=81;
    public static final int T__25=25;
    public static final int RULE_SL_COMMENT=13;
    public static final int T__83=83;
    public static final int T__60=60;
    public static final int T__41=41;
    public static final int T__71=71;
    public static final int T__18=18;

    // delegates
    // delegators


        public InternalQVTcoreBaseParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalQVTcoreBaseParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalQVTcoreBaseParser.tokenNames; }
    public String getGrammarFileName() { return "../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */
     
     	private QVTcoreBaseGrammarAccess grammarAccess;
     	
        public InternalQVTcoreBaseParser(TokenStream input, QVTcoreBaseGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "BottomPatternCS";	
       	}
       	
       	@Override
       	protected QVTcoreBaseGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleBottomPatternCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:73:1: entryRuleBottomPatternCS returns [EObject current=null] : iv_ruleBottomPatternCS= ruleBottomPatternCS EOF ;
    public final EObject entryRuleBottomPatternCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBottomPatternCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:74:2: (iv_ruleBottomPatternCS= ruleBottomPatternCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:75:2: iv_ruleBottomPatternCS= ruleBottomPatternCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBottomPatternCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleBottomPatternCS_in_entryRuleBottomPatternCS81);
            iv_ruleBottomPatternCS=ruleBottomPatternCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBottomPatternCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBottomPatternCS91); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:82:1: ruleBottomPatternCS returns [EObject current=null] : ( () ( ( ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_2_0= ruleRealizedVariableCS ) ) ) (otherlv_3= ',' ( ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) ) ) )* otherlv_6= '|' )? ( (lv_constraints_7_0= ruleAssignmentCS ) )* ) ;
    public final EObject ruleBottomPatternCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_3=null;
        Token otherlv_6=null;
        EObject lv_unrealizedVariables_1_0 = null;

        EObject lv_realizedVariables_2_0 = null;

        EObject lv_unrealizedVariables_4_0 = null;

        EObject lv_realizedVariables_5_0 = null;

        EObject lv_constraints_7_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:85:28: ( ( () ( ( ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_2_0= ruleRealizedVariableCS ) ) ) (otherlv_3= ',' ( ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) ) ) )* otherlv_6= '|' )? ( (lv_constraints_7_0= ruleAssignmentCS ) )* ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:86:1: ( () ( ( ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_2_0= ruleRealizedVariableCS ) ) ) (otherlv_3= ',' ( ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) ) ) )* otherlv_6= '|' )? ( (lv_constraints_7_0= ruleAssignmentCS ) )* )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:86:1: ( () ( ( ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_2_0= ruleRealizedVariableCS ) ) ) (otherlv_3= ',' ( ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) ) ) )* otherlv_6= '|' )? ( (lv_constraints_7_0= ruleAssignmentCS ) )* )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:86:2: () ( ( ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_2_0= ruleRealizedVariableCS ) ) ) (otherlv_3= ',' ( ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) ) ) )* otherlv_6= '|' )? ( (lv_constraints_7_0= ruleAssignmentCS ) )*
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:86:2: ()
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:87:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getBottomPatternCSAccess().getBottomPatternCSAction_0(),
                          current);
                  
            }

            }

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:95:2: ( ( ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_2_0= ruleRealizedVariableCS ) ) ) (otherlv_3= ',' ( ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) ) ) )* otherlv_6= '|' )?
            int alt4=2;
            alt4 = dfa4.predict(input);
            switch (alt4) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:95:3: ( ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_2_0= ruleRealizedVariableCS ) ) ) (otherlv_3= ',' ( ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) ) ) )* otherlv_6= '|'
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:95:3: ( ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_2_0= ruleRealizedVariableCS ) ) )
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( ((LA1_0>=RULE_SIMPLE_ID && LA1_0<=RULE_ESCAPED_ID)||(LA1_0>=21 && LA1_0<=22)||(LA1_0>=26 && LA1_0<=33)) ) {
                        alt1=1;
                    }
                    else if ( (LA1_0==25) ) {
                        int LA1_2 = input.LA(2);

                        if ( ((LA1_2>=RULE_SIMPLE_ID && LA1_2<=RULE_ESCAPED_ID)||(LA1_2>=21 && LA1_2<=22)||(LA1_2>=25 && LA1_2<=33)) ) {
                            alt1=2;
                        }
                        else if ( (LA1_2==23) ) {
                            alt1=1;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 1, 2, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 1, 0, input);

                        throw nvae;
                    }
                    switch (alt1) {
                        case 1 :
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:95:4: ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:95:4: ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:96:1: (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:96:1: (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:97:3: lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getBottomPatternCSAccess().getUnrealizedVariablesUnrealizedVariableCSParserRuleCall_1_0_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleUnrealizedVariableCS_in_ruleBottomPatternCS151);
                            lv_unrealizedVariables_1_0=ruleUnrealizedVariableCS();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getBottomPatternCSRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"unrealizedVariables",
                                      		lv_unrealizedVariables_1_0, 
                                      		"UnrealizedVariableCS");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:114:6: ( (lv_realizedVariables_2_0= ruleRealizedVariableCS ) )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:114:6: ( (lv_realizedVariables_2_0= ruleRealizedVariableCS ) )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:115:1: (lv_realizedVariables_2_0= ruleRealizedVariableCS )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:115:1: (lv_realizedVariables_2_0= ruleRealizedVariableCS )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:116:3: lv_realizedVariables_2_0= ruleRealizedVariableCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getBottomPatternCSAccess().getRealizedVariablesRealizedVariableCSParserRuleCall_1_0_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleRealizedVariableCS_in_ruleBottomPatternCS178);
                            lv_realizedVariables_2_0=ruleRealizedVariableCS();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getBottomPatternCSRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"realizedVariables",
                                      		lv_realizedVariables_2_0, 
                                      		"RealizedVariableCS");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;

                    }

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:132:3: (otherlv_3= ',' ( ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) ) ) )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==16) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:132:5: otherlv_3= ',' ( ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) ) )
                    	    {
                    	    otherlv_3=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleBottomPatternCS192); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getBottomPatternCSAccess().getCommaKeyword_1_1_0());
                    	          
                    	    }
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:136:1: ( ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) ) )
                    	    int alt2=2;
                    	    int LA2_0 = input.LA(1);

                    	    if ( ((LA2_0>=RULE_SIMPLE_ID && LA2_0<=RULE_ESCAPED_ID)||(LA2_0>=21 && LA2_0<=22)||(LA2_0>=26 && LA2_0<=33)) ) {
                    	        alt2=1;
                    	    }
                    	    else if ( (LA2_0==25) ) {
                    	        int LA2_2 = input.LA(2);

                    	        if ( ((LA2_2>=RULE_SIMPLE_ID && LA2_2<=RULE_ESCAPED_ID)||(LA2_2>=21 && LA2_2<=22)||(LA2_2>=25 && LA2_2<=33)) ) {
                    	            alt2=2;
                    	        }
                    	        else if ( (LA2_2==23) ) {
                    	            alt2=1;
                    	        }
                    	        else {
                    	            if (state.backtracking>0) {state.failed=true; return current;}
                    	            NoViableAltException nvae =
                    	                new NoViableAltException("", 2, 2, input);

                    	            throw nvae;
                    	        }
                    	    }
                    	    else {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 2, 0, input);

                    	        throw nvae;
                    	    }
                    	    switch (alt2) {
                    	        case 1 :
                    	            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:136:2: ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) )
                    	            {
                    	            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:136:2: ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) )
                    	            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:137:1: (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS )
                    	            {
                    	            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:137:1: (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS )
                    	            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:138:3: lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS
                    	            {
                    	            if ( state.backtracking==0 ) {
                    	               
                    	              	        newCompositeNode(grammarAccess.getBottomPatternCSAccess().getUnrealizedVariablesUnrealizedVariableCSParserRuleCall_1_1_1_0_0()); 
                    	              	    
                    	            }
                    	            pushFollow(FollowSets000.FOLLOW_ruleUnrealizedVariableCS_in_ruleBottomPatternCS214);
                    	            lv_unrealizedVariables_4_0=ruleUnrealizedVariableCS();

                    	            state._fsp--;
                    	            if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElementForParent(grammarAccess.getBottomPatternCSRule());
                    	              	        }
                    	                     		add(
                    	                     			current, 
                    	                     			"unrealizedVariables",
                    	                      		lv_unrealizedVariables_4_0, 
                    	                      		"UnrealizedVariableCS");
                    	              	        afterParserOrEnumRuleCall();
                    	              	    
                    	            }

                    	            }


                    	            }


                    	            }
                    	            break;
                    	        case 2 :
                    	            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:155:6: ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) )
                    	            {
                    	            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:155:6: ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) )
                    	            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:156:1: (lv_realizedVariables_5_0= ruleRealizedVariableCS )
                    	            {
                    	            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:156:1: (lv_realizedVariables_5_0= ruleRealizedVariableCS )
                    	            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:157:3: lv_realizedVariables_5_0= ruleRealizedVariableCS
                    	            {
                    	            if ( state.backtracking==0 ) {
                    	               
                    	              	        newCompositeNode(grammarAccess.getBottomPatternCSAccess().getRealizedVariablesRealizedVariableCSParserRuleCall_1_1_1_1_0()); 
                    	              	    
                    	            }
                    	            pushFollow(FollowSets000.FOLLOW_ruleRealizedVariableCS_in_ruleBottomPatternCS241);
                    	            lv_realizedVariables_5_0=ruleRealizedVariableCS();

                    	            state._fsp--;
                    	            if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElementForParent(grammarAccess.getBottomPatternCSRule());
                    	              	        }
                    	                     		add(
                    	                     			current, 
                    	                     			"realizedVariables",
                    	                      		lv_realizedVariables_5_0, 
                    	                      		"RealizedVariableCS");
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
                    	    break loop3;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleBottomPatternCS256); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getBottomPatternCSAccess().getVerticalLineKeyword_1_2());
                          
                    }

                    }
                    break;

            }

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:177:3: ( (lv_constraints_7_0= ruleAssignmentCS ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>=RULE_SIMPLE_ID && LA5_0<=RULE_SINGLE_QUOTED_STRING)||LA5_0==18||(LA5_0>=21 && LA5_0<=22)||(LA5_0>=25 && LA5_0<=36)||(LA5_0>=51 && LA5_0<=65)||(LA5_0>=73 && LA5_0<=76)||LA5_0==79||LA5_0==83||LA5_0==85) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:178:1: (lv_constraints_7_0= ruleAssignmentCS )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:178:1: (lv_constraints_7_0= ruleAssignmentCS )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:179:3: lv_constraints_7_0= ruleAssignmentCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getBottomPatternCSAccess().getConstraintsAssignmentCSParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleAssignmentCS_in_ruleBottomPatternCS279);
            	    lv_constraints_7_0=ruleAssignmentCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getBottomPatternCSRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"constraints",
            	              		lv_constraints_7_0, 
            	              		"AssignmentCS");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
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
    // $ANTLR end "ruleBottomPatternCS"


    // $ANTLR start "entryRuleAssignmentCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:203:1: entryRuleAssignmentCS returns [EObject current=null] : iv_ruleAssignmentCS= ruleAssignmentCS EOF ;
    public final EObject entryRuleAssignmentCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignmentCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:204:2: (iv_ruleAssignmentCS= ruleAssignmentCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:205:2: iv_ruleAssignmentCS= ruleAssignmentCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAssignmentCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAssignmentCS_in_entryRuleAssignmentCS316);
            iv_ruleAssignmentCS=ruleAssignmentCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAssignmentCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAssignmentCS326); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAssignmentCS"


    // $ANTLR start "ruleAssignmentCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:212:1: ruleAssignmentCS returns [EObject current=null] : ( ( (lv_default_0_0= 'default' ) )? ( (lv_target_1_0= ruleExpCS ) ) (otherlv_2= ':=' ( (lv_initialiser_3_0= ruleExpCS ) ) )? otherlv_4= ';' ) ;
    public final EObject ruleAssignmentCS() throws RecognitionException {
        EObject current = null;

        Token lv_default_0_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_target_1_0 = null;

        EObject lv_initialiser_3_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:215:28: ( ( ( (lv_default_0_0= 'default' ) )? ( (lv_target_1_0= ruleExpCS ) ) (otherlv_2= ':=' ( (lv_initialiser_3_0= ruleExpCS ) ) )? otherlv_4= ';' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:216:1: ( ( (lv_default_0_0= 'default' ) )? ( (lv_target_1_0= ruleExpCS ) ) (otherlv_2= ':=' ( (lv_initialiser_3_0= ruleExpCS ) ) )? otherlv_4= ';' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:216:1: ( ( (lv_default_0_0= 'default' ) )? ( (lv_target_1_0= ruleExpCS ) ) (otherlv_2= ':=' ( (lv_initialiser_3_0= ruleExpCS ) ) )? otherlv_4= ';' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:216:2: ( (lv_default_0_0= 'default' ) )? ( (lv_target_1_0= ruleExpCS ) ) (otherlv_2= ':=' ( (lv_initialiser_3_0= ruleExpCS ) ) )? otherlv_4= ';'
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:216:2: ( (lv_default_0_0= 'default' ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==18) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:217:1: (lv_default_0_0= 'default' )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:217:1: (lv_default_0_0= 'default' )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:218:3: lv_default_0_0= 'default'
                    {
                    lv_default_0_0=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleAssignmentCS369); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_default_0_0, grammarAccess.getAssignmentCSAccess().getDefaultDefaultKeyword_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getAssignmentCSRule());
                      	        }
                             		setWithLastConsumed(current, "default", true, "default");
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:231:3: ( (lv_target_1_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:232:1: (lv_target_1_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:232:1: (lv_target_1_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:233:3: lv_target_1_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAssignmentCSAccess().getTargetExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleAssignmentCS404);
            lv_target_1_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getAssignmentCSRule());
              	        }
                     		set(
                     			current, 
                     			"target",
                      		lv_target_1_0, 
                      		"ExpCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:249:2: (otherlv_2= ':=' ( (lv_initialiser_3_0= ruleExpCS ) ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==19) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:249:4: otherlv_2= ':=' ( (lv_initialiser_3_0= ruleExpCS ) )
                    {
                    otherlv_2=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleAssignmentCS417); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getAssignmentCSAccess().getColonEqualsSignKeyword_2_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:253:1: ( (lv_initialiser_3_0= ruleExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:254:1: (lv_initialiser_3_0= ruleExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:254:1: (lv_initialiser_3_0= ruleExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:255:3: lv_initialiser_3_0= ruleExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAssignmentCSAccess().getInitialiserExpCSParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleAssignmentCS438);
                    lv_initialiser_3_0=ruleExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAssignmentCSRule());
                      	        }
                             		set(
                             			current, 
                             			"initialiser",
                              		lv_initialiser_3_0, 
                              		"ExpCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleAssignmentCS452); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getAssignmentCSAccess().getSemicolonKeyword_3());
                  
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
    // $ANTLR end "ruleAssignmentCS"


    // $ANTLR start "entryRuleDirectionCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:283:1: entryRuleDirectionCS returns [EObject current=null] : iv_ruleDirectionCS= ruleDirectionCS EOF ;
    public final EObject entryRuleDirectionCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDirectionCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:284:2: (iv_ruleDirectionCS= ruleDirectionCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:285:2: iv_ruleDirectionCS= ruleDirectionCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDirectionCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleDirectionCS_in_entryRuleDirectionCS488);
            iv_ruleDirectionCS=ruleDirectionCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDirectionCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDirectionCS498); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:292:1: ruleDirectionCS returns [EObject current=null] : ( () ( (lv_name_1_0= ruleUnrestrictedName ) )? (otherlv_2= 'imports' ( ( ruleUnrestrictedName ) ) (otherlv_4= ',' ( ( ruleUnrestrictedName ) ) )* )? (otherlv_6= 'uses' ( ( ruleUnrestrictedName ) ) (otherlv_8= ',' ( ( ruleUnrestrictedName ) ) )* )? ) ;
    public final EObject ruleDirectionCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:295:28: ( ( () ( (lv_name_1_0= ruleUnrestrictedName ) )? (otherlv_2= 'imports' ( ( ruleUnrestrictedName ) ) (otherlv_4= ',' ( ( ruleUnrestrictedName ) ) )* )? (otherlv_6= 'uses' ( ( ruleUnrestrictedName ) ) (otherlv_8= ',' ( ( ruleUnrestrictedName ) ) )* )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:296:1: ( () ( (lv_name_1_0= ruleUnrestrictedName ) )? (otherlv_2= 'imports' ( ( ruleUnrestrictedName ) ) (otherlv_4= ',' ( ( ruleUnrestrictedName ) ) )* )? (otherlv_6= 'uses' ( ( ruleUnrestrictedName ) ) (otherlv_8= ',' ( ( ruleUnrestrictedName ) ) )* )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:296:1: ( () ( (lv_name_1_0= ruleUnrestrictedName ) )? (otherlv_2= 'imports' ( ( ruleUnrestrictedName ) ) (otherlv_4= ',' ( ( ruleUnrestrictedName ) ) )* )? (otherlv_6= 'uses' ( ( ruleUnrestrictedName ) ) (otherlv_8= ',' ( ( ruleUnrestrictedName ) ) )* )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:296:2: () ( (lv_name_1_0= ruleUnrestrictedName ) )? (otherlv_2= 'imports' ( ( ruleUnrestrictedName ) ) (otherlv_4= ',' ( ( ruleUnrestrictedName ) ) )* )? (otherlv_6= 'uses' ( ( ruleUnrestrictedName ) ) (otherlv_8= ',' ( ( ruleUnrestrictedName ) ) )* )?
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:296:2: ()
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:297:2: 
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:305:2: ( (lv_name_1_0= ruleUnrestrictedName ) )?
            int alt8=2;
            alt8 = dfa8.predict(input);
            switch (alt8) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:306:1: (lv_name_1_0= ruleUnrestrictedName )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:306:1: (lv_name_1_0= ruleUnrestrictedName )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:307:3: lv_name_1_0= ruleUnrestrictedName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDirectionCSAccess().getNameUnrestrictedNameParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleDirectionCS556);
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
                              		"UnrestrictedName");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:323:3: (otherlv_2= 'imports' ( ( ruleUnrestrictedName ) ) (otherlv_4= ',' ( ( ruleUnrestrictedName ) ) )* )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==21) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:323:5: otherlv_2= 'imports' ( ( ruleUnrestrictedName ) ) (otherlv_4= ',' ( ( ruleUnrestrictedName ) ) )*
                    {
                    otherlv_2=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleDirectionCS570); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getDirectionCSAccess().getImportsKeyword_2_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:327:1: ( ( ruleUnrestrictedName ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:328:1: ( ruleUnrestrictedName )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:328:1: ( ruleUnrestrictedName )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:329:3: ruleUnrestrictedName
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
                       
                      	        newCompositeNode(grammarAccess.getDirectionCSAccess().getImportsPackageCrossReference_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleDirectionCS597);
                    ruleUnrestrictedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:345:2: (otherlv_4= ',' ( ( ruleUnrestrictedName ) ) )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==16) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:345:4: otherlv_4= ',' ( ( ruleUnrestrictedName ) )
                    	    {
                    	    otherlv_4=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleDirectionCS610); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_4, grammarAccess.getDirectionCSAccess().getCommaKeyword_2_2_0());
                    	          
                    	    }
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:349:1: ( ( ruleUnrestrictedName ) )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:350:1: ( ruleUnrestrictedName )
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:350:1: ( ruleUnrestrictedName )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:351:3: ruleUnrestrictedName
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
                    	       
                    	      	        newCompositeNode(grammarAccess.getDirectionCSAccess().getImportsPackageCrossReference_2_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleDirectionCS637);
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
                    	    break loop9;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:367:6: (otherlv_6= 'uses' ( ( ruleUnrestrictedName ) ) (otherlv_8= ',' ( ( ruleUnrestrictedName ) ) )* )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==22) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:367:8: otherlv_6= 'uses' ( ( ruleUnrestrictedName ) ) (otherlv_8= ',' ( ( ruleUnrestrictedName ) ) )*
                    {
                    otherlv_6=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleDirectionCS654); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getDirectionCSAccess().getUsesKeyword_3_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:371:1: ( ( ruleUnrestrictedName ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:372:1: ( ruleUnrestrictedName )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:372:1: ( ruleUnrestrictedName )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:373:3: ruleUnrestrictedName
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
                       
                      	        newCompositeNode(grammarAccess.getDirectionCSAccess().getUsesCoreDomainCrossReference_3_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleDirectionCS681);
                    ruleUnrestrictedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:389:2: (otherlv_8= ',' ( ( ruleUnrestrictedName ) ) )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==16) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:389:4: otherlv_8= ',' ( ( ruleUnrestrictedName ) )
                    	    {
                    	    otherlv_8=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleDirectionCS694); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_8, grammarAccess.getDirectionCSAccess().getCommaKeyword_3_2_0());
                    	          
                    	    }
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:393:1: ( ( ruleUnrestrictedName ) )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:394:1: ( ruleUnrestrictedName )
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:394:1: ( ruleUnrestrictedName )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:395:3: ruleUnrestrictedName
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
                    	       
                    	      	        newCompositeNode(grammarAccess.getDirectionCSAccess().getUsesCoreDomainCrossReference_3_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleDirectionCS721);
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
                    	    break loop11;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:419:1: entryRuleGuardPatternCS returns [EObject current=null] : iv_ruleGuardPatternCS= ruleGuardPatternCS EOF ;
    public final EObject entryRuleGuardPatternCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGuardPatternCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:420:2: (iv_ruleGuardPatternCS= ruleGuardPatternCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:421:2: iv_ruleGuardPatternCS= ruleGuardPatternCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGuardPatternCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleGuardPatternCS_in_entryRuleGuardPatternCS761);
            iv_ruleGuardPatternCS=ruleGuardPatternCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleGuardPatternCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleGuardPatternCS771); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:428:1: ruleGuardPatternCS returns [EObject current=null] : ( () ( ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) (otherlv_2= ',' ( (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS ) ) )* otherlv_4= '|' )? ( (lv_constraints_5_0= ruleAssignmentCS ) )* ) ;
    public final EObject ruleGuardPatternCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_unrealizedVariables_1_0 = null;

        EObject lv_unrealizedVariables_3_0 = null;

        EObject lv_constraints_5_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:431:28: ( ( () ( ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) (otherlv_2= ',' ( (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS ) ) )* otherlv_4= '|' )? ( (lv_constraints_5_0= ruleAssignmentCS ) )* ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:432:1: ( () ( ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) (otherlv_2= ',' ( (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS ) ) )* otherlv_4= '|' )? ( (lv_constraints_5_0= ruleAssignmentCS ) )* )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:432:1: ( () ( ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) (otherlv_2= ',' ( (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS ) ) )* otherlv_4= '|' )? ( (lv_constraints_5_0= ruleAssignmentCS ) )* )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:432:2: () ( ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) (otherlv_2= ',' ( (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS ) ) )* otherlv_4= '|' )? ( (lv_constraints_5_0= ruleAssignmentCS ) )*
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:432:2: ()
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:433:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getGuardPatternCSAccess().getGuardPatternCSAction_0(),
                          current);
                  
            }

            }

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:441:2: ( ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) (otherlv_2= ',' ( (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS ) ) )* otherlv_4= '|' )?
            int alt14=2;
            alt14 = dfa14.predict(input);
            switch (alt14) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:441:3: ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) (otherlv_2= ',' ( (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS ) ) )* otherlv_4= '|'
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:441:3: ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:442:1: (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:442:1: (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:443:3: lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getGuardPatternCSAccess().getUnrealizedVariablesUnrealizedVariableCSParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUnrealizedVariableCS_in_ruleGuardPatternCS830);
                    lv_unrealizedVariables_1_0=ruleUnrealizedVariableCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getGuardPatternCSRule());
                      	        }
                             		add(
                             			current, 
                             			"unrealizedVariables",
                              		lv_unrealizedVariables_1_0, 
                              		"UnrealizedVariableCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:459:2: (otherlv_2= ',' ( (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS ) ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==16) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:459:4: otherlv_2= ',' ( (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS ) )
                    	    {
                    	    otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleGuardPatternCS843); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_2, grammarAccess.getGuardPatternCSAccess().getCommaKeyword_1_1_0());
                    	          
                    	    }
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:463:1: ( (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS ) )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:464:1: (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS )
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:464:1: (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:465:3: lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getGuardPatternCSAccess().getUnrealizedVariablesUnrealizedVariableCSParserRuleCall_1_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleUnrealizedVariableCS_in_ruleGuardPatternCS864);
                    	    lv_unrealizedVariables_3_0=ruleUnrealizedVariableCS();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getGuardPatternCSRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"unrealizedVariables",
                    	              		lv_unrealizedVariables_3_0, 
                    	              		"UnrealizedVariableCS");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);

                    otherlv_4=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleGuardPatternCS878); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getGuardPatternCSAccess().getVerticalLineKeyword_1_2());
                          
                    }

                    }
                    break;

            }

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:485:3: ( (lv_constraints_5_0= ruleAssignmentCS ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>=RULE_SIMPLE_ID && LA15_0<=RULE_SINGLE_QUOTED_STRING)||LA15_0==18||(LA15_0>=21 && LA15_0<=22)||(LA15_0>=25 && LA15_0<=36)||(LA15_0>=51 && LA15_0<=65)||(LA15_0>=73 && LA15_0<=76)||LA15_0==79||LA15_0==83||LA15_0==85) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:486:1: (lv_constraints_5_0= ruleAssignmentCS )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:486:1: (lv_constraints_5_0= ruleAssignmentCS )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:487:3: lv_constraints_5_0= ruleAssignmentCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getGuardPatternCSAccess().getConstraintsAssignmentCSParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleAssignmentCS_in_ruleGuardPatternCS901);
            	    lv_constraints_5_0=ruleAssignmentCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getGuardPatternCSRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"constraints",
            	              		lv_constraints_5_0, 
            	              		"AssignmentCS");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop15;
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
    // $ANTLR end "ruleGuardPatternCS"


    // $ANTLR start "entryRuleParamDeclarationCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:517:1: entryRuleParamDeclarationCS returns [EObject current=null] : iv_ruleParamDeclarationCS= ruleParamDeclarationCS EOF ;
    public final EObject entryRuleParamDeclarationCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParamDeclarationCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:518:2: (iv_ruleParamDeclarationCS= ruleParamDeclarationCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:519:2: iv_ruleParamDeclarationCS= ruleParamDeclarationCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParamDeclarationCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleParamDeclarationCS_in_entryRuleParamDeclarationCS944);
            iv_ruleParamDeclarationCS=ruleParamDeclarationCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParamDeclarationCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParamDeclarationCS954); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:526:1: ruleParamDeclarationCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) ) ;
    public final EObject ruleParamDeclarationCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:529:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:530:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:530:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:530:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:530:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:531:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:531:1: (lv_name_0_0= ruleUnrestrictedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:532:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParamDeclarationCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleParamDeclarationCS1000);
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
                      		"UnrestrictedName");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleParamDeclarationCS1012); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getParamDeclarationCSAccess().getColonKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:552:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:553:1: (lv_ownedType_2_0= ruleTypeExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:553:1: (lv_ownedType_2_0= ruleTypeExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:554:3: lv_ownedType_2_0= ruleTypeExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParamDeclarationCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleParamDeclarationCS1033);
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
                      		"TypeExpCS");
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


    // $ANTLR start "entryRuleScopeNameCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:580:1: entryRuleScopeNameCS returns [EObject current=null] : iv_ruleScopeNameCS= ruleScopeNameCS EOF ;
    public final EObject entryRuleScopeNameCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScopeNameCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:581:2: (iv_ruleScopeNameCS= ruleScopeNameCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:582:2: iv_ruleScopeNameCS= ruleScopeNameCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScopeNameCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleScopeNameCS_in_entryRuleScopeNameCS1071);
            iv_ruleScopeNameCS=ruleScopeNameCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScopeNameCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleScopeNameCS1081); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:589:1: ruleScopeNameCS returns [EObject current=null] : ( ( (lv_path_0_0= ruleFirstPathElementCS ) ) otherlv_1= '::' ( ( (lv_path_2_0= ruleNextPathElementCS ) ) otherlv_3= '::' )* ) ;
    public final EObject ruleScopeNameCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_path_0_0 = null;

        EObject lv_path_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:592:28: ( ( ( (lv_path_0_0= ruleFirstPathElementCS ) ) otherlv_1= '::' ( ( (lv_path_2_0= ruleNextPathElementCS ) ) otherlv_3= '::' )* ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:593:1: ( ( (lv_path_0_0= ruleFirstPathElementCS ) ) otherlv_1= '::' ( ( (lv_path_2_0= ruleNextPathElementCS ) ) otherlv_3= '::' )* )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:593:1: ( ( (lv_path_0_0= ruleFirstPathElementCS ) ) otherlv_1= '::' ( ( (lv_path_2_0= ruleNextPathElementCS ) ) otherlv_3= '::' )* )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:593:2: ( (lv_path_0_0= ruleFirstPathElementCS ) ) otherlv_1= '::' ( ( (lv_path_2_0= ruleNextPathElementCS ) ) otherlv_3= '::' )*
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:593:2: ( (lv_path_0_0= ruleFirstPathElementCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:594:1: (lv_path_0_0= ruleFirstPathElementCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:594:1: (lv_path_0_0= ruleFirstPathElementCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:595:3: lv_path_0_0= ruleFirstPathElementCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getScopeNameCSAccess().getPathFirstPathElementCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleFirstPathElementCS_in_ruleScopeNameCS1127);
            lv_path_0_0=ruleFirstPathElementCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getScopeNameCSRule());
              	        }
                     		add(
                     			current, 
                     			"path",
                      		lv_path_0_0, 
                      		"FirstPathElementCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleScopeNameCS1139); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getScopeNameCSAccess().getColonColonKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:615:1: ( ( (lv_path_2_0= ruleNextPathElementCS ) ) otherlv_3= '::' )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0>=RULE_SIMPLE_ID && LA16_0<=RULE_ESCAPED_ID)||(LA16_0>=21 && LA16_0<=22)||(LA16_0>=25 && LA16_0<=33)||(LA16_0>=51 && LA16_0<=64)) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:615:2: ( (lv_path_2_0= ruleNextPathElementCS ) ) otherlv_3= '::'
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:615:2: ( (lv_path_2_0= ruleNextPathElementCS ) )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:616:1: (lv_path_2_0= ruleNextPathElementCS )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:616:1: (lv_path_2_0= ruleNextPathElementCS )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:617:3: lv_path_2_0= ruleNextPathElementCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getScopeNameCSAccess().getPathNextPathElementCSParserRuleCall_2_0_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleNextPathElementCS_in_ruleScopeNameCS1161);
            	    lv_path_2_0=ruleNextPathElementCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getScopeNameCSRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"path",
            	              		lv_path_2_0, 
            	              		"NextPathElementCS");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    otherlv_3=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleScopeNameCS1173); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getScopeNameCSAccess().getColonColonKeyword_2_1());
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop16;
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


    // $ANTLR start "entryRuleUnrealizedVariableCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:647:1: entryRuleUnrealizedVariableCS returns [EObject current=null] : iv_ruleUnrealizedVariableCS= ruleUnrealizedVariableCS EOF ;
    public final EObject entryRuleUnrealizedVariableCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnrealizedVariableCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:648:2: (iv_ruleUnrealizedVariableCS= ruleUnrealizedVariableCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:649:2: iv_ruleUnrealizedVariableCS= ruleUnrealizedVariableCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnrealizedVariableCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrealizedVariableCS_in_entryRuleUnrealizedVariableCS1213);
            iv_ruleUnrealizedVariableCS=ruleUnrealizedVariableCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnrealizedVariableCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnrealizedVariableCS1223); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:656:1: ruleUnrealizedVariableCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) ) ;
    public final EObject ruleUnrealizedVariableCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:659:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:660:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:660:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:660:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:660:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:661:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:661:1: (lv_name_0_0= ruleUnrestrictedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:662:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getUnrealizedVariableCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleUnrealizedVariableCS1269);
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
                      		"UnrestrictedName");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleUnrealizedVariableCS1281); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getUnrealizedVariableCSAccess().getColonKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:682:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:683:1: (lv_ownedType_2_0= ruleTypeExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:683:1: (lv_ownedType_2_0= ruleTypeExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:684:3: lv_ownedType_2_0= ruleTypeExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getUnrealizedVariableCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleUnrealizedVariableCS1302);
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
                      		"TypeExpCS");
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
    // $ANTLR end "ruleUnrealizedVariableCS"


    // $ANTLR start "entryRuleRealizedVariableCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:708:1: entryRuleRealizedVariableCS returns [EObject current=null] : iv_ruleRealizedVariableCS= ruleRealizedVariableCS EOF ;
    public final EObject entryRuleRealizedVariableCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealizedVariableCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:709:2: (iv_ruleRealizedVariableCS= ruleRealizedVariableCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:710:2: iv_ruleRealizedVariableCS= ruleRealizedVariableCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRealizedVariableCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleRealizedVariableCS_in_entryRuleRealizedVariableCS1338);
            iv_ruleRealizedVariableCS=ruleRealizedVariableCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRealizedVariableCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRealizedVariableCS1348); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:717:1: ruleRealizedVariableCS returns [EObject current=null] : (otherlv_0= 'realize' ( (lv_name_1_0= ruleUnrestrictedName ) ) otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) ) ;
    public final EObject ruleRealizedVariableCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_ownedType_3_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:720:28: ( (otherlv_0= 'realize' ( (lv_name_1_0= ruleUnrestrictedName ) ) otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:721:1: (otherlv_0= 'realize' ( (lv_name_1_0= ruleUnrestrictedName ) ) otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:721:1: (otherlv_0= 'realize' ( (lv_name_1_0= ruleUnrestrictedName ) ) otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:721:3: otherlv_0= 'realize' ( (lv_name_1_0= ruleUnrestrictedName ) ) otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) )
            {
            otherlv_0=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleRealizedVariableCS1385); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getRealizedVariableCSAccess().getRealizeKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:725:1: ( (lv_name_1_0= ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:726:1: (lv_name_1_0= ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:726:1: (lv_name_1_0= ruleUnrestrictedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:727:3: lv_name_1_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRealizedVariableCSAccess().getNameUnrestrictedNameParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleRealizedVariableCS1406);
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
                      		"UnrestrictedName");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleRealizedVariableCS1418); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getRealizedVariableCSAccess().getColonKeyword_2());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:747:1: ( (lv_ownedType_3_0= ruleTypeExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:748:1: (lv_ownedType_3_0= ruleTypeExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:748:1: (lv_ownedType_3_0= ruleTypeExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:749:3: lv_ownedType_3_0= ruleTypeExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRealizedVariableCSAccess().getOwnedTypeTypeExpCSParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleRealizedVariableCS1439);
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
                      		"TypeExpCS");
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


    // $ANTLR start "entryRuleUnrestrictedName"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:775:1: entryRuleUnrestrictedName returns [String current=null] : iv_ruleUnrestrictedName= ruleUnrestrictedName EOF ;
    public final String entryRuleUnrestrictedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnrestrictedName = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:776:2: (iv_ruleUnrestrictedName= ruleUnrestrictedName EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:777:2: iv_ruleUnrestrictedName= ruleUnrestrictedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnrestrictedNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_entryRuleUnrestrictedName1478);
            iv_ruleUnrestrictedName=ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnrestrictedName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnrestrictedName1489); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:784:1: ruleUnrestrictedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_EssentialOCLUnrestrictedName_0= ruleEssentialOCLUnrestrictedName | kw= 'check' | kw= 'enforce' | kw= 'import' | kw= 'imports' | kw= 'library' | kw= 'map' | kw= 'query' | kw= 'realize' | kw= 'refines' | kw= 'transformation' | kw= 'uses' ) ;
    public final AntlrDatatypeRuleToken ruleUnrestrictedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_EssentialOCLUnrestrictedName_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:787:28: ( (this_EssentialOCLUnrestrictedName_0= ruleEssentialOCLUnrestrictedName | kw= 'check' | kw= 'enforce' | kw= 'import' | kw= 'imports' | kw= 'library' | kw= 'map' | kw= 'query' | kw= 'realize' | kw= 'refines' | kw= 'transformation' | kw= 'uses' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:788:1: (this_EssentialOCLUnrestrictedName_0= ruleEssentialOCLUnrestrictedName | kw= 'check' | kw= 'enforce' | kw= 'import' | kw= 'imports' | kw= 'library' | kw= 'map' | kw= 'query' | kw= 'realize' | kw= 'refines' | kw= 'transformation' | kw= 'uses' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:788:1: (this_EssentialOCLUnrestrictedName_0= ruleEssentialOCLUnrestrictedName | kw= 'check' | kw= 'enforce' | kw= 'import' | kw= 'imports' | kw= 'library' | kw= 'map' | kw= 'query' | kw= 'realize' | kw= 'refines' | kw= 'transformation' | kw= 'uses' )
            int alt17=12;
            switch ( input.LA(1) ) {
            case RULE_SIMPLE_ID:
            case RULE_ESCAPED_ID:
                {
                alt17=1;
                }
                break;
            case 26:
                {
                alt17=2;
                }
                break;
            case 27:
                {
                alt17=3;
                }
                break;
            case 28:
                {
                alt17=4;
                }
                break;
            case 21:
                {
                alt17=5;
                }
                break;
            case 29:
                {
                alt17=6;
                }
                break;
            case 30:
                {
                alt17=7;
                }
                break;
            case 31:
                {
                alt17=8;
                }
                break;
            case 25:
                {
                alt17=9;
                }
                break;
            case 32:
                {
                alt17=10;
                }
                break;
            case 33:
                {
                alt17=11;
                }
                break;
            case 22:
                {
                alt17=12;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:789:5: this_EssentialOCLUnrestrictedName_0= ruleEssentialOCLUnrestrictedName
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getUnrestrictedNameAccess().getEssentialOCLUnrestrictedNameParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLUnrestrictedName_in_ruleUnrestrictedName1536);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:801:2: kw= 'check'
                    {
                    kw=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleUnrestrictedName1560); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getCheckKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:808:2: kw= 'enforce'
                    {
                    kw=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleUnrestrictedName1579); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getEnforceKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:815:2: kw= 'import'
                    {
                    kw=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleUnrestrictedName1598); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getImportKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:822:2: kw= 'imports'
                    {
                    kw=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleUnrestrictedName1617); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getImportsKeyword_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:829:2: kw= 'library'
                    {
                    kw=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleUnrestrictedName1636); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getLibraryKeyword_5()); 
                          
                    }

                    }
                    break;
                case 7 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:836:2: kw= 'map'
                    {
                    kw=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleUnrestrictedName1655); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getMapKeyword_6()); 
                          
                    }

                    }
                    break;
                case 8 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:843:2: kw= 'query'
                    {
                    kw=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleUnrestrictedName1674); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getQueryKeyword_7()); 
                          
                    }

                    }
                    break;
                case 9 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:850:2: kw= 'realize'
                    {
                    kw=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleUnrestrictedName1693); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getRealizeKeyword_8()); 
                          
                    }

                    }
                    break;
                case 10 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:857:2: kw= 'refines'
                    {
                    kw=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleUnrestrictedName1712); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getRefinesKeyword_9()); 
                          
                    }

                    }
                    break;
                case 11 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:864:2: kw= 'transformation'
                    {
                    kw=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleUnrestrictedName1731); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getTransformationKeyword_10()); 
                          
                    }

                    }
                    break;
                case 12 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:871:2: kw= 'uses'
                    {
                    kw=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleUnrestrictedName1750); if (state.failed) return current;
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


    // $ANTLR start "entryRuleID"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:886:1: entryRuleID returns [String current=null] : iv_ruleID= ruleID EOF ;
    public final String entryRuleID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleID = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:887:2: (iv_ruleID= ruleID EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:888:2: iv_ruleID= ruleID EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIDRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleID_in_entryRuleID1793);
            iv_ruleID=ruleID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleID.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleID1804); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:895:1: ruleID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_SIMPLE_ID_0= RULE_SIMPLE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID ) ;
    public final AntlrDatatypeRuleToken ruleID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_SIMPLE_ID_0=null;
        Token this_ESCAPED_ID_1=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:898:28: ( (this_SIMPLE_ID_0= RULE_SIMPLE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:899:1: (this_SIMPLE_ID_0= RULE_SIMPLE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:899:1: (this_SIMPLE_ID_0= RULE_SIMPLE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_SIMPLE_ID) ) {
                alt18=1;
            }
            else if ( (LA18_0==RULE_ESCAPED_ID) ) {
                alt18=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:899:6: this_SIMPLE_ID_0= RULE_SIMPLE_ID
                    {
                    this_SIMPLE_ID_0=(Token)match(input,RULE_SIMPLE_ID,FollowSets000.FOLLOW_RULE_SIMPLE_ID_in_ruleID1844); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SIMPLE_ID_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SIMPLE_ID_0, grammarAccess.getIDAccess().getSIMPLE_IDTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:907:10: this_ESCAPED_ID_1= RULE_ESCAPED_ID
                    {
                    this_ESCAPED_ID_1=(Token)match(input,RULE_ESCAPED_ID,FollowSets000.FOLLOW_RULE_ESCAPED_ID_in_ruleID1870); if (state.failed) return current;
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


    // $ANTLR start "entryRuleLOWER"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:922:1: entryRuleLOWER returns [String current=null] : iv_ruleLOWER= ruleLOWER EOF ;
    public final String entryRuleLOWER() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLOWER = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:923:2: (iv_ruleLOWER= ruleLOWER EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:924:2: iv_ruleLOWER= ruleLOWER EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLOWERRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLOWER_in_entryRuleLOWER1916);
            iv_ruleLOWER=ruleLOWER();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLOWER.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLOWER1927); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:931:1: ruleLOWER returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INT_0= RULE_INT ;
    public final AntlrDatatypeRuleToken ruleLOWER() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:934:28: (this_INT_0= RULE_INT )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:935:5: this_INT_0= RULE_INT
            {
            this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleLOWER1966); if (state.failed) return current;
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


    // $ANTLR start "entryRuleUPPER"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:950:1: entryRuleUPPER returns [String current=null] : iv_ruleUPPER= ruleUPPER EOF ;
    public final String entryRuleUPPER() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUPPER = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:951:2: (iv_ruleUPPER= ruleUPPER EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:952:2: iv_ruleUPPER= ruleUPPER EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUPPERRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUPPER_in_entryRuleUPPER2011);
            iv_ruleUPPER=ruleUPPER();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUPPER.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUPPER2022); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:959:1: ruleUPPER returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT | kw= '*' ) ;
    public final AntlrDatatypeRuleToken ruleUPPER() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:962:28: ( (this_INT_0= RULE_INT | kw= '*' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:963:1: (this_INT_0= RULE_INT | kw= '*' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:963:1: (this_INT_0= RULE_INT | kw= '*' )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_INT) ) {
                alt19=1;
            }
            else if ( (LA19_0==34) ) {
                alt19=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:963:6: this_INT_0= RULE_INT
                    {
                    this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleUPPER2062); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_INT_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_INT_0, grammarAccess.getUPPERAccess().getINTTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:972:2: kw= '*'
                    {
                    kw=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleUPPER2086); if (state.failed) return current;
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


    // $ANTLR start "entryRuleNUMBER_LITERAL"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:985:1: entryRuleNUMBER_LITERAL returns [String current=null] : iv_ruleNUMBER_LITERAL= ruleNUMBER_LITERAL EOF ;
    public final String entryRuleNUMBER_LITERAL() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNUMBER_LITERAL = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:986:2: (iv_ruleNUMBER_LITERAL= ruleNUMBER_LITERAL EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:987:2: iv_ruleNUMBER_LITERAL= ruleNUMBER_LITERAL EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNUMBER_LITERALRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNUMBER_LITERAL_in_entryRuleNUMBER_LITERAL2127);
            iv_ruleNUMBER_LITERAL=ruleNUMBER_LITERAL();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNUMBER_LITERAL.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNUMBER_LITERAL2138); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:994:1: ruleNUMBER_LITERAL returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INT_0= RULE_INT ;
    public final AntlrDatatypeRuleToken ruleNUMBER_LITERAL() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:997:28: (this_INT_0= RULE_INT )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:998:5: this_INT_0= RULE_INT
            {
            this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleNUMBER_LITERAL2177); if (state.failed) return current;
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


    // $ANTLR start "entryRuleURI"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1013:1: entryRuleURI returns [String current=null] : iv_ruleURI= ruleURI EOF ;
    public final String entryRuleURI() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleURI = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1014:2: (iv_ruleURI= ruleURI EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1015:2: iv_ruleURI= ruleURI EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getURIRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleURI_in_entryRuleURI2222);
            iv_ruleURI=ruleURI();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleURI.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleURI2233); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1022:1: ruleURI returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING ;
    public final AntlrDatatypeRuleToken ruleURI() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_SINGLE_QUOTED_STRING_0=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1025:28: (this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1026:5: this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING
            {
            this_SINGLE_QUOTED_STRING_0=(Token)match(input,RULE_SINGLE_QUOTED_STRING,FollowSets000.FOLLOW_RULE_SINGLE_QUOTED_STRING_in_ruleURI2272); if (state.failed) return current;
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


    // $ANTLR start "entryRuleEssentialOCLPrefixOperator"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1043:1: entryRuleEssentialOCLPrefixOperator returns [String current=null] : iv_ruleEssentialOCLPrefixOperator= ruleEssentialOCLPrefixOperator EOF ;
    public final String entryRuleEssentialOCLPrefixOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEssentialOCLPrefixOperator = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1044:2: (iv_ruleEssentialOCLPrefixOperator= ruleEssentialOCLPrefixOperator EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1045:2: iv_ruleEssentialOCLPrefixOperator= ruleEssentialOCLPrefixOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEssentialOCLPrefixOperatorRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLPrefixOperator_in_entryRuleEssentialOCLPrefixOperator2319);
            iv_ruleEssentialOCLPrefixOperator=ruleEssentialOCLPrefixOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEssentialOCLPrefixOperator.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEssentialOCLPrefixOperator2330); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEssentialOCLPrefixOperator"


    // $ANTLR start "ruleEssentialOCLPrefixOperator"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1052:1: ruleEssentialOCLPrefixOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '-' | kw= 'not' ) ;
    public final AntlrDatatypeRuleToken ruleEssentialOCLPrefixOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1055:28: ( (kw= '-' | kw= 'not' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1056:1: (kw= '-' | kw= 'not' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1056:1: (kw= '-' | kw= 'not' )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==35) ) {
                alt20=1;
            }
            else if ( (LA20_0==36) ) {
                alt20=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1057:2: kw= '-'
                    {
                    kw=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleEssentialOCLPrefixOperator2368); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLPrefixOperatorAccess().getHyphenMinusKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1064:2: kw= 'not'
                    {
                    kw=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleEssentialOCLPrefixOperator2387); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLPrefixOperatorAccess().getNotKeyword_1()); 
                          
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
    // $ANTLR end "ruleEssentialOCLPrefixOperator"


    // $ANTLR start "entryRuleEssentialOCLInfixOperator"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1077:1: entryRuleEssentialOCLInfixOperator returns [String current=null] : iv_ruleEssentialOCLInfixOperator= ruleEssentialOCLInfixOperator EOF ;
    public final String entryRuleEssentialOCLInfixOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEssentialOCLInfixOperator = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1078:2: (iv_ruleEssentialOCLInfixOperator= ruleEssentialOCLInfixOperator EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1079:2: iv_ruleEssentialOCLInfixOperator= ruleEssentialOCLInfixOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEssentialOCLInfixOperatorRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLInfixOperator_in_entryRuleEssentialOCLInfixOperator2428);
            iv_ruleEssentialOCLInfixOperator=ruleEssentialOCLInfixOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEssentialOCLInfixOperator.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEssentialOCLInfixOperator2439); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEssentialOCLInfixOperator"


    // $ANTLR start "ruleEssentialOCLInfixOperator"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1086:1: ruleEssentialOCLInfixOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '*' | kw= '/' | kw= '+' | kw= '-' | kw= '>' | kw= '<' | kw= '>=' | kw= '<=' | kw= '=' | kw= '<>' | kw= 'and' | kw= 'or' | kw= 'xor' | kw= 'implies' ) ;
    public final AntlrDatatypeRuleToken ruleEssentialOCLInfixOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1089:28: ( (kw= '*' | kw= '/' | kw= '+' | kw= '-' | kw= '>' | kw= '<' | kw= '>=' | kw= '<=' | kw= '=' | kw= '<>' | kw= 'and' | kw= 'or' | kw= 'xor' | kw= 'implies' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1090:1: (kw= '*' | kw= '/' | kw= '+' | kw= '-' | kw= '>' | kw= '<' | kw= '>=' | kw= '<=' | kw= '=' | kw= '<>' | kw= 'and' | kw= 'or' | kw= 'xor' | kw= 'implies' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1090:1: (kw= '*' | kw= '/' | kw= '+' | kw= '-' | kw= '>' | kw= '<' | kw= '>=' | kw= '<=' | kw= '=' | kw= '<>' | kw= 'and' | kw= 'or' | kw= 'xor' | kw= 'implies' )
            int alt21=14;
            switch ( input.LA(1) ) {
            case 34:
                {
                alt21=1;
                }
                break;
            case 37:
                {
                alt21=2;
                }
                break;
            case 38:
                {
                alt21=3;
                }
                break;
            case 35:
                {
                alt21=4;
                }
                break;
            case 39:
                {
                alt21=5;
                }
                break;
            case 40:
                {
                alt21=6;
                }
                break;
            case 41:
                {
                alt21=7;
                }
                break;
            case 42:
                {
                alt21=8;
                }
                break;
            case 43:
                {
                alt21=9;
                }
                break;
            case 44:
                {
                alt21=10;
                }
                break;
            case 45:
                {
                alt21=11;
                }
                break;
            case 46:
                {
                alt21=12;
                }
                break;
            case 47:
                {
                alt21=13;
                }
                break;
            case 48:
                {
                alt21=14;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1091:2: kw= '*'
                    {
                    kw=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleEssentialOCLInfixOperator2477); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorAccess().getAsteriskKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1098:2: kw= '/'
                    {
                    kw=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleEssentialOCLInfixOperator2496); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorAccess().getSolidusKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1105:2: kw= '+'
                    {
                    kw=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleEssentialOCLInfixOperator2515); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorAccess().getPlusSignKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1112:2: kw= '-'
                    {
                    kw=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleEssentialOCLInfixOperator2534); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorAccess().getHyphenMinusKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1119:2: kw= '>'
                    {
                    kw=(Token)match(input,39,FollowSets000.FOLLOW_39_in_ruleEssentialOCLInfixOperator2553); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorAccess().getGreaterThanSignKeyword_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1126:2: kw= '<'
                    {
                    kw=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleEssentialOCLInfixOperator2572); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorAccess().getLessThanSignKeyword_5()); 
                          
                    }

                    }
                    break;
                case 7 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1133:2: kw= '>='
                    {
                    kw=(Token)match(input,41,FollowSets000.FOLLOW_41_in_ruleEssentialOCLInfixOperator2591); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorAccess().getGreaterThanSignEqualsSignKeyword_6()); 
                          
                    }

                    }
                    break;
                case 8 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1140:2: kw= '<='
                    {
                    kw=(Token)match(input,42,FollowSets000.FOLLOW_42_in_ruleEssentialOCLInfixOperator2610); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorAccess().getLessThanSignEqualsSignKeyword_7()); 
                          
                    }

                    }
                    break;
                case 9 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1147:2: kw= '='
                    {
                    kw=(Token)match(input,43,FollowSets000.FOLLOW_43_in_ruleEssentialOCLInfixOperator2629); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorAccess().getEqualsSignKeyword_8()); 
                          
                    }

                    }
                    break;
                case 10 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1154:2: kw= '<>'
                    {
                    kw=(Token)match(input,44,FollowSets000.FOLLOW_44_in_ruleEssentialOCLInfixOperator2648); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorAccess().getLessThanSignGreaterThanSignKeyword_9()); 
                          
                    }

                    }
                    break;
                case 11 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1161:2: kw= 'and'
                    {
                    kw=(Token)match(input,45,FollowSets000.FOLLOW_45_in_ruleEssentialOCLInfixOperator2667); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorAccess().getAndKeyword_10()); 
                          
                    }

                    }
                    break;
                case 12 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1168:2: kw= 'or'
                    {
                    kw=(Token)match(input,46,FollowSets000.FOLLOW_46_in_ruleEssentialOCLInfixOperator2686); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorAccess().getOrKeyword_11()); 
                          
                    }

                    }
                    break;
                case 13 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1175:2: kw= 'xor'
                    {
                    kw=(Token)match(input,47,FollowSets000.FOLLOW_47_in_ruleEssentialOCLInfixOperator2705); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorAccess().getXorKeyword_12()); 
                          
                    }

                    }
                    break;
                case 14 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1182:2: kw= 'implies'
                    {
                    kw=(Token)match(input,48,FollowSets000.FOLLOW_48_in_ruleEssentialOCLInfixOperator2724); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorAccess().getImpliesKeyword_13()); 
                          
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
    // $ANTLR end "ruleEssentialOCLInfixOperator"


    // $ANTLR start "entryRuleEssentialOCLNavigationOperator"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1195:1: entryRuleEssentialOCLNavigationOperator returns [String current=null] : iv_ruleEssentialOCLNavigationOperator= ruleEssentialOCLNavigationOperator EOF ;
    public final String entryRuleEssentialOCLNavigationOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEssentialOCLNavigationOperator = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1196:2: (iv_ruleEssentialOCLNavigationOperator= ruleEssentialOCLNavigationOperator EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1197:2: iv_ruleEssentialOCLNavigationOperator= ruleEssentialOCLNavigationOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEssentialOCLNavigationOperatorRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLNavigationOperator_in_entryRuleEssentialOCLNavigationOperator2765);
            iv_ruleEssentialOCLNavigationOperator=ruleEssentialOCLNavigationOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEssentialOCLNavigationOperator.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEssentialOCLNavigationOperator2776); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEssentialOCLNavigationOperator"


    // $ANTLR start "ruleEssentialOCLNavigationOperator"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1204:1: ruleEssentialOCLNavigationOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '.' | kw= '->' ) ;
    public final AntlrDatatypeRuleToken ruleEssentialOCLNavigationOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1207:28: ( (kw= '.' | kw= '->' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1208:1: (kw= '.' | kw= '->' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1208:1: (kw= '.' | kw= '->' )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==49) ) {
                alt22=1;
            }
            else if ( (LA22_0==50) ) {
                alt22=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1209:2: kw= '.'
                    {
                    kw=(Token)match(input,49,FollowSets000.FOLLOW_49_in_ruleEssentialOCLNavigationOperator2814); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLNavigationOperatorAccess().getFullStopKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1216:2: kw= '->'
                    {
                    kw=(Token)match(input,50,FollowSets000.FOLLOW_50_in_ruleEssentialOCLNavigationOperator2833); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLNavigationOperatorAccess().getHyphenMinusGreaterThanSignKeyword_1()); 
                          
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
    // $ANTLR end "ruleEssentialOCLNavigationOperator"


    // $ANTLR start "entryRuleIdentifier"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1229:1: entryRuleIdentifier returns [String current=null] : iv_ruleIdentifier= ruleIdentifier EOF ;
    public final String entryRuleIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdentifier = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1230:2: (iv_ruleIdentifier= ruleIdentifier EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1231:2: iv_ruleIdentifier= ruleIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIdentifierRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_entryRuleIdentifier2874);
            iv_ruleIdentifier=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIdentifier.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIdentifier2885); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1238:1: ruleIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= ruleID ;
    public final AntlrDatatypeRuleToken ruleIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_ID_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1241:28: (this_ID_0= ruleID )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1243:5: this_ID_0= ruleID
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getIdentifierAccess().getIDParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleID_in_ruleIdentifier2931);
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


    // $ANTLR start "entryRuleStringLiteral"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1261:1: entryRuleStringLiteral returns [String current=null] : iv_ruleStringLiteral= ruleStringLiteral EOF ;
    public final String entryRuleStringLiteral() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleStringLiteral = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1262:2: (iv_ruleStringLiteral= ruleStringLiteral EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1263:2: iv_ruleStringLiteral= ruleStringLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStringLiteralRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral2976);
            iv_ruleStringLiteral=ruleStringLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStringLiteral.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleStringLiteral2987); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1270:1: ruleStringLiteral returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING ;
    public final AntlrDatatypeRuleToken ruleStringLiteral() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_SINGLE_QUOTED_STRING_0=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1273:28: (this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1274:5: this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING
            {
            this_SINGLE_QUOTED_STRING_0=(Token)match(input,RULE_SINGLE_QUOTED_STRING,FollowSets000.FOLLOW_RULE_SINGLE_QUOTED_STRING_in_ruleStringLiteral3026); if (state.failed) return current;
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


    // $ANTLR start "entryRulePrefixOperator"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1289:1: entryRulePrefixOperator returns [String current=null] : iv_rulePrefixOperator= rulePrefixOperator EOF ;
    public final String entryRulePrefixOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePrefixOperator = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1290:2: (iv_rulePrefixOperator= rulePrefixOperator EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1291:2: iv_rulePrefixOperator= rulePrefixOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrefixOperatorRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePrefixOperator_in_entryRulePrefixOperator3071);
            iv_rulePrefixOperator=rulePrefixOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrefixOperator.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrefixOperator3082); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrefixOperator"


    // $ANTLR start "rulePrefixOperator"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1298:1: rulePrefixOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_EssentialOCLPrefixOperator_0= ruleEssentialOCLPrefixOperator ;
    public final AntlrDatatypeRuleToken rulePrefixOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_EssentialOCLPrefixOperator_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1301:28: (this_EssentialOCLPrefixOperator_0= ruleEssentialOCLPrefixOperator )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1303:5: this_EssentialOCLPrefixOperator_0= ruleEssentialOCLPrefixOperator
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getPrefixOperatorAccess().getEssentialOCLPrefixOperatorParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLPrefixOperator_in_rulePrefixOperator3128);
            this_EssentialOCLPrefixOperator_0=ruleEssentialOCLPrefixOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_EssentialOCLPrefixOperator_0);
                  
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
    // $ANTLR end "rulePrefixOperator"


    // $ANTLR start "entryRuleInfixOperator"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1321:1: entryRuleInfixOperator returns [String current=null] : iv_ruleInfixOperator= ruleInfixOperator EOF ;
    public final String entryRuleInfixOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInfixOperator = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1322:2: (iv_ruleInfixOperator= ruleInfixOperator EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1323:2: iv_ruleInfixOperator= ruleInfixOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInfixOperatorRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleInfixOperator_in_entryRuleInfixOperator3173);
            iv_ruleInfixOperator=ruleInfixOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInfixOperator.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleInfixOperator3184); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInfixOperator"


    // $ANTLR start "ruleInfixOperator"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1330:1: ruleInfixOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_EssentialOCLInfixOperator_0= ruleEssentialOCLInfixOperator ;
    public final AntlrDatatypeRuleToken ruleInfixOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_EssentialOCLInfixOperator_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1333:28: (this_EssentialOCLInfixOperator_0= ruleEssentialOCLInfixOperator )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1335:5: this_EssentialOCLInfixOperator_0= ruleEssentialOCLInfixOperator
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getInfixOperatorAccess().getEssentialOCLInfixOperatorParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLInfixOperator_in_ruleInfixOperator3230);
            this_EssentialOCLInfixOperator_0=ruleEssentialOCLInfixOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_EssentialOCLInfixOperator_0);
                  
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
    // $ANTLR end "ruleInfixOperator"


    // $ANTLR start "entryRuleNavigationOperator"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1353:1: entryRuleNavigationOperator returns [String current=null] : iv_ruleNavigationOperator= ruleNavigationOperator EOF ;
    public final String entryRuleNavigationOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNavigationOperator = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1354:2: (iv_ruleNavigationOperator= ruleNavigationOperator EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1355:2: iv_ruleNavigationOperator= ruleNavigationOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigationOperatorRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigationOperator_in_entryRuleNavigationOperator3275);
            iv_ruleNavigationOperator=ruleNavigationOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigationOperator.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigationOperator3286); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNavigationOperator"


    // $ANTLR start "ruleNavigationOperator"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1362:1: ruleNavigationOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_EssentialOCLNavigationOperator_0= ruleEssentialOCLNavigationOperator ;
    public final AntlrDatatypeRuleToken ruleNavigationOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_EssentialOCLNavigationOperator_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1365:28: (this_EssentialOCLNavigationOperator_0= ruleEssentialOCLNavigationOperator )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1367:5: this_EssentialOCLNavigationOperator_0= ruleEssentialOCLNavigationOperator
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getNavigationOperatorAccess().getEssentialOCLNavigationOperatorParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLNavigationOperator_in_ruleNavigationOperator3332);
            this_EssentialOCLNavigationOperator_0=ruleEssentialOCLNavigationOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_EssentialOCLNavigationOperator_0);
                  
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
    // $ANTLR end "ruleNavigationOperator"


    // $ANTLR start "entryRuleEssentialOCLUnrestrictedName"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1385:1: entryRuleEssentialOCLUnrestrictedName returns [String current=null] : iv_ruleEssentialOCLUnrestrictedName= ruleEssentialOCLUnrestrictedName EOF ;
    public final String entryRuleEssentialOCLUnrestrictedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEssentialOCLUnrestrictedName = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1386:2: (iv_ruleEssentialOCLUnrestrictedName= ruleEssentialOCLUnrestrictedName EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1387:2: iv_ruleEssentialOCLUnrestrictedName= ruleEssentialOCLUnrestrictedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEssentialOCLUnrestrictedNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLUnrestrictedName_in_entryRuleEssentialOCLUnrestrictedName3377);
            iv_ruleEssentialOCLUnrestrictedName=ruleEssentialOCLUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEssentialOCLUnrestrictedName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEssentialOCLUnrestrictedName3388); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1394:1: ruleEssentialOCLUnrestrictedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_Identifier_0= ruleIdentifier ;
    public final AntlrDatatypeRuleToken ruleEssentialOCLUnrestrictedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_Identifier_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1397:28: (this_Identifier_0= ruleIdentifier )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1399:5: this_Identifier_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getEssentialOCLUnrestrictedNameAccess().getIdentifierParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_ruleEssentialOCLUnrestrictedName3434);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1417:1: entryRuleEssentialOCLUnreservedName returns [String current=null] : iv_ruleEssentialOCLUnreservedName= ruleEssentialOCLUnreservedName EOF ;
    public final String entryRuleEssentialOCLUnreservedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEssentialOCLUnreservedName = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1418:2: (iv_ruleEssentialOCLUnreservedName= ruleEssentialOCLUnreservedName EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1419:2: iv_ruleEssentialOCLUnreservedName= ruleEssentialOCLUnreservedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEssentialOCLUnreservedNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLUnreservedName_in_entryRuleEssentialOCLUnreservedName3479);
            iv_ruleEssentialOCLUnreservedName=ruleEssentialOCLUnreservedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEssentialOCLUnreservedName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEssentialOCLUnreservedName3490); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1426:1: ruleEssentialOCLUnreservedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_UnrestrictedName_0= ruleUnrestrictedName | this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier | this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier | kw= 'Tuple' ) ;
    public final AntlrDatatypeRuleToken ruleEssentialOCLUnreservedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_UnrestrictedName_0 = null;

        AntlrDatatypeRuleToken this_CollectionTypeIdentifier_1 = null;

        AntlrDatatypeRuleToken this_PrimitiveTypeIdentifier_2 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1429:28: ( (this_UnrestrictedName_0= ruleUnrestrictedName | this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier | this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier | kw= 'Tuple' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1430:1: (this_UnrestrictedName_0= ruleUnrestrictedName | this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier | this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier | kw= 'Tuple' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1430:1: (this_UnrestrictedName_0= ruleUnrestrictedName | this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier | this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier | kw= 'Tuple' )
            int alt23=4;
            switch ( input.LA(1) ) {
            case RULE_SIMPLE_ID:
            case RULE_ESCAPED_ID:
            case 21:
            case 22:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
                {
                alt23=1;
                }
                break;
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
                {
                alt23=2;
                }
                break;
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
                {
                alt23=3;
                }
                break;
            case 51:
                {
                alt23=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1431:5: this_UnrestrictedName_0= ruleUnrestrictedName
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getEssentialOCLUnreservedNameAccess().getUnrestrictedNameParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleEssentialOCLUnreservedName3537);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1443:5: this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getEssentialOCLUnreservedNameAccess().getCollectionTypeIdentifierParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCollectionTypeIdentifier_in_ruleEssentialOCLUnreservedName3570);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1455:5: this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getEssentialOCLUnreservedNameAccess().getPrimitiveTypeIdentifierParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrimitiveTypeIdentifier_in_ruleEssentialOCLUnreservedName3603);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1467:2: kw= 'Tuple'
                    {
                    kw=(Token)match(input,51,FollowSets000.FOLLOW_51_in_ruleEssentialOCLUnreservedName3627); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLUnreservedNameAccess().getTupleKeyword_3()); 
                          
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1480:1: entryRuleUnreservedName returns [String current=null] : iv_ruleUnreservedName= ruleUnreservedName EOF ;
    public final String entryRuleUnreservedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnreservedName = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1481:2: (iv_ruleUnreservedName= ruleUnreservedName EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1482:2: iv_ruleUnreservedName= ruleUnreservedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnreservedNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnreservedName_in_entryRuleUnreservedName3668);
            iv_ruleUnreservedName=ruleUnreservedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnreservedName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnreservedName3679); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1489:1: ruleUnreservedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_EssentialOCLUnreservedName_0= ruleEssentialOCLUnreservedName ;
    public final AntlrDatatypeRuleToken ruleUnreservedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_EssentialOCLUnreservedName_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1492:28: (this_EssentialOCLUnreservedName_0= ruleEssentialOCLUnreservedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1494:5: this_EssentialOCLUnreservedName_0= ruleEssentialOCLUnreservedName
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getUnreservedNameAccess().getEssentialOCLUnreservedNameParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLUnreservedName_in_ruleUnreservedName3725);
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


    // $ANTLR start "entryRulePathNameCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1512:1: entryRulePathNameCS returns [EObject current=null] : iv_rulePathNameCS= rulePathNameCS EOF ;
    public final EObject entryRulePathNameCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePathNameCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1513:2: (iv_rulePathNameCS= rulePathNameCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1514:2: iv_rulePathNameCS= rulePathNameCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPathNameCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePathNameCS_in_entryRulePathNameCS3769);
            iv_rulePathNameCS=rulePathNameCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePathNameCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePathNameCS3779); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1521:1: rulePathNameCS returns [EObject current=null] : ( ( (lv_path_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )* ) ;
    public final EObject rulePathNameCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_path_0_0 = null;

        EObject lv_path_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1524:28: ( ( ( (lv_path_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )* ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1525:1: ( ( (lv_path_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )* )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1525:1: ( ( (lv_path_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )* )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1525:2: ( (lv_path_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )*
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1525:2: ( (lv_path_0_0= ruleFirstPathElementCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1526:1: (lv_path_0_0= ruleFirstPathElementCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1526:1: (lv_path_0_0= ruleFirstPathElementCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1527:3: lv_path_0_0= ruleFirstPathElementCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPathNameCSAccess().getPathFirstPathElementCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleFirstPathElementCS_in_rulePathNameCS3825);
            lv_path_0_0=ruleFirstPathElementCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getPathNameCSRule());
              	        }
                     		add(
                     			current, 
                     			"path",
                      		lv_path_0_0, 
                      		"FirstPathElementCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1543:2: (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==24) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1543:4: otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) )
            	    {
            	    otherlv_1=(Token)match(input,24,FollowSets000.FOLLOW_24_in_rulePathNameCS3838); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getPathNameCSAccess().getColonColonKeyword_1_0());
            	          
            	    }
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1547:1: ( (lv_path_2_0= ruleNextPathElementCS ) )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1548:1: (lv_path_2_0= ruleNextPathElementCS )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1548:1: (lv_path_2_0= ruleNextPathElementCS )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1549:3: lv_path_2_0= ruleNextPathElementCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getPathNameCSAccess().getPathNextPathElementCSParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleNextPathElementCS_in_rulePathNameCS3859);
            	    lv_path_2_0=ruleNextPathElementCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getPathNameCSRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"path",
            	              		lv_path_2_0, 
            	              		"NextPathElementCS");
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1573:1: entryRuleFirstPathElementCS returns [EObject current=null] : iv_ruleFirstPathElementCS= ruleFirstPathElementCS EOF ;
    public final EObject entryRuleFirstPathElementCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFirstPathElementCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1574:2: (iv_ruleFirstPathElementCS= ruleFirstPathElementCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1575:2: iv_ruleFirstPathElementCS= ruleFirstPathElementCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFirstPathElementCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleFirstPathElementCS_in_entryRuleFirstPathElementCS3897);
            iv_ruleFirstPathElementCS=ruleFirstPathElementCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFirstPathElementCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFirstPathElementCS3907); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1582:1: ruleFirstPathElementCS returns [EObject current=null] : ( ( ruleUnrestrictedName ) ) ;
    public final EObject ruleFirstPathElementCS() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1585:28: ( ( ( ruleUnrestrictedName ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1586:1: ( ( ruleUnrestrictedName ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1586:1: ( ( ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1587:1: ( ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1587:1: ( ruleUnrestrictedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1588:3: ruleUnrestrictedName
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
               
              	        newCompositeNode(grammarAccess.getFirstPathElementCSAccess().getElementNamedElementCrossReference_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleFirstPathElementCS3958);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1612:1: entryRuleNextPathElementCS returns [EObject current=null] : iv_ruleNextPathElementCS= ruleNextPathElementCS EOF ;
    public final EObject entryRuleNextPathElementCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNextPathElementCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1613:2: (iv_ruleNextPathElementCS= ruleNextPathElementCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1614:2: iv_ruleNextPathElementCS= ruleNextPathElementCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNextPathElementCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNextPathElementCS_in_entryRuleNextPathElementCS3993);
            iv_ruleNextPathElementCS=ruleNextPathElementCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNextPathElementCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNextPathElementCS4003); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1621:1: ruleNextPathElementCS returns [EObject current=null] : ( ( ruleUnreservedName ) ) ;
    public final EObject ruleNextPathElementCS() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1624:28: ( ( ( ruleUnreservedName ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1625:1: ( ( ruleUnreservedName ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1625:1: ( ( ruleUnreservedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1626:1: ( ruleUnreservedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1626:1: ( ruleUnreservedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1627:3: ruleUnreservedName
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
               
              	        newCompositeNode(grammarAccess.getNextPathElementCSAccess().getElementNamedElementCrossReference_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnreservedName_in_ruleNextPathElementCS4054);
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


    // $ANTLR start "entryRuleURIPathNameCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1651:1: entryRuleURIPathNameCS returns [EObject current=null] : iv_ruleURIPathNameCS= ruleURIPathNameCS EOF ;
    public final EObject entryRuleURIPathNameCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleURIPathNameCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1652:2: (iv_ruleURIPathNameCS= ruleURIPathNameCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1653:2: iv_ruleURIPathNameCS= ruleURIPathNameCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getURIPathNameCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleURIPathNameCS_in_entryRuleURIPathNameCS4089);
            iv_ruleURIPathNameCS=ruleURIPathNameCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleURIPathNameCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleURIPathNameCS4099); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1660:1: ruleURIPathNameCS returns [EObject current=null] : ( ( (lv_path_0_0= ruleURIFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )* ) ;
    public final EObject ruleURIPathNameCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_path_0_0 = null;

        EObject lv_path_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1663:28: ( ( ( (lv_path_0_0= ruleURIFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )* ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1664:1: ( ( (lv_path_0_0= ruleURIFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )* )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1664:1: ( ( (lv_path_0_0= ruleURIFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )* )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1664:2: ( (lv_path_0_0= ruleURIFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )*
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1664:2: ( (lv_path_0_0= ruleURIFirstPathElementCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1665:1: (lv_path_0_0= ruleURIFirstPathElementCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1665:1: (lv_path_0_0= ruleURIFirstPathElementCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1666:3: lv_path_0_0= ruleURIFirstPathElementCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getURIPathNameCSAccess().getPathURIFirstPathElementCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleURIFirstPathElementCS_in_ruleURIPathNameCS4145);
            lv_path_0_0=ruleURIFirstPathElementCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getURIPathNameCSRule());
              	        }
                     		add(
                     			current, 
                     			"path",
                      		lv_path_0_0, 
                      		"URIFirstPathElementCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1682:2: (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==24) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1682:4: otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) )
            	    {
            	    otherlv_1=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleURIPathNameCS4158); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getURIPathNameCSAccess().getColonColonKeyword_1_0());
            	          
            	    }
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1686:1: ( (lv_path_2_0= ruleNextPathElementCS ) )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1687:1: (lv_path_2_0= ruleNextPathElementCS )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1687:1: (lv_path_2_0= ruleNextPathElementCS )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1688:3: lv_path_2_0= ruleNextPathElementCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getURIPathNameCSAccess().getPathNextPathElementCSParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleNextPathElementCS_in_ruleURIPathNameCS4179);
            	    lv_path_2_0=ruleNextPathElementCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getURIPathNameCSRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"path",
            	              		lv_path_2_0, 
            	              		"NextPathElementCS");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop25;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1712:1: entryRuleURIFirstPathElementCS returns [EObject current=null] : iv_ruleURIFirstPathElementCS= ruleURIFirstPathElementCS EOF ;
    public final EObject entryRuleURIFirstPathElementCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleURIFirstPathElementCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1713:2: (iv_ruleURIFirstPathElementCS= ruleURIFirstPathElementCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1714:2: iv_ruleURIFirstPathElementCS= ruleURIFirstPathElementCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getURIFirstPathElementCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleURIFirstPathElementCS_in_entryRuleURIFirstPathElementCS4217);
            iv_ruleURIFirstPathElementCS=ruleURIFirstPathElementCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleURIFirstPathElementCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleURIFirstPathElementCS4227); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1721:1: ruleURIFirstPathElementCS returns [EObject current=null] : ( ( ( ruleUnrestrictedName ) ) | ( () ( ( ruleURI ) ) ) ) ;
    public final EObject ruleURIFirstPathElementCS() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1724:28: ( ( ( ( ruleUnrestrictedName ) ) | ( () ( ( ruleURI ) ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1725:1: ( ( ( ruleUnrestrictedName ) ) | ( () ( ( ruleURI ) ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1725:1: ( ( ( ruleUnrestrictedName ) ) | ( () ( ( ruleURI ) ) ) )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( ((LA26_0>=RULE_SIMPLE_ID && LA26_0<=RULE_ESCAPED_ID)||(LA26_0>=21 && LA26_0<=22)||(LA26_0>=25 && LA26_0<=33)) ) {
                alt26=1;
            }
            else if ( (LA26_0==RULE_SINGLE_QUOTED_STRING) ) {
                alt26=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1725:2: ( ( ruleUnrestrictedName ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1725:2: ( ( ruleUnrestrictedName ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1726:1: ( ruleUnrestrictedName )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1726:1: ( ruleUnrestrictedName )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1727:3: ruleUnrestrictedName
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
                       
                      	        newCompositeNode(grammarAccess.getURIFirstPathElementCSAccess().getElementNamedElementCrossReference_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleURIFirstPathElementCS4279);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1744:6: ( () ( ( ruleURI ) ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1744:6: ( () ( ( ruleURI ) ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1744:7: () ( ( ruleURI ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1744:7: ()
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1745:2: 
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

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1753:2: ( ( ruleURI ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1754:1: ( ruleURI )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1754:1: ( ruleURI )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1755:3: ruleURI
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
                       
                      	        newCompositeNode(grammarAccess.getURIFirstPathElementCSAccess().getElementNamespaceCrossReference_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleURI_in_ruleURIFirstPathElementCS4325);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1779:1: entryRulePrimitiveTypeIdentifier returns [String current=null] : iv_rulePrimitiveTypeIdentifier= rulePrimitiveTypeIdentifier EOF ;
    public final String entryRulePrimitiveTypeIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePrimitiveTypeIdentifier = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1780:2: (iv_rulePrimitiveTypeIdentifier= rulePrimitiveTypeIdentifier EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1781:2: iv_rulePrimitiveTypeIdentifier= rulePrimitiveTypeIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimitiveTypeIdentifierRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePrimitiveTypeIdentifier_in_entryRulePrimitiveTypeIdentifier4363);
            iv_rulePrimitiveTypeIdentifier=rulePrimitiveTypeIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimitiveTypeIdentifier.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrimitiveTypeIdentifier4374); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1788:1: rulePrimitiveTypeIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Boolean' | kw= 'Integer' | kw= 'Real' | kw= 'String' | kw= 'UnlimitedNatural' | kw= 'OclAny' | kw= 'OclInvalid' | kw= 'OclVoid' ) ;
    public final AntlrDatatypeRuleToken rulePrimitiveTypeIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1791:28: ( (kw= 'Boolean' | kw= 'Integer' | kw= 'Real' | kw= 'String' | kw= 'UnlimitedNatural' | kw= 'OclAny' | kw= 'OclInvalid' | kw= 'OclVoid' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1792:1: (kw= 'Boolean' | kw= 'Integer' | kw= 'Real' | kw= 'String' | kw= 'UnlimitedNatural' | kw= 'OclAny' | kw= 'OclInvalid' | kw= 'OclVoid' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1792:1: (kw= 'Boolean' | kw= 'Integer' | kw= 'Real' | kw= 'String' | kw= 'UnlimitedNatural' | kw= 'OclAny' | kw= 'OclInvalid' | kw= 'OclVoid' )
            int alt27=8;
            switch ( input.LA(1) ) {
            case 52:
                {
                alt27=1;
                }
                break;
            case 53:
                {
                alt27=2;
                }
                break;
            case 54:
                {
                alt27=3;
                }
                break;
            case 55:
                {
                alt27=4;
                }
                break;
            case 56:
                {
                alt27=5;
                }
                break;
            case 57:
                {
                alt27=6;
                }
                break;
            case 58:
                {
                alt27=7;
                }
                break;
            case 59:
                {
                alt27=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }

            switch (alt27) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1793:2: kw= 'Boolean'
                    {
                    kw=(Token)match(input,52,FollowSets000.FOLLOW_52_in_rulePrimitiveTypeIdentifier4412); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getBooleanKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1800:2: kw= 'Integer'
                    {
                    kw=(Token)match(input,53,FollowSets000.FOLLOW_53_in_rulePrimitiveTypeIdentifier4431); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getIntegerKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1807:2: kw= 'Real'
                    {
                    kw=(Token)match(input,54,FollowSets000.FOLLOW_54_in_rulePrimitiveTypeIdentifier4450); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getRealKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1814:2: kw= 'String'
                    {
                    kw=(Token)match(input,55,FollowSets000.FOLLOW_55_in_rulePrimitiveTypeIdentifier4469); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getStringKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1821:2: kw= 'UnlimitedNatural'
                    {
                    kw=(Token)match(input,56,FollowSets000.FOLLOW_56_in_rulePrimitiveTypeIdentifier4488); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getUnlimitedNaturalKeyword_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1828:2: kw= 'OclAny'
                    {
                    kw=(Token)match(input,57,FollowSets000.FOLLOW_57_in_rulePrimitiveTypeIdentifier4507); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getOclAnyKeyword_5()); 
                          
                    }

                    }
                    break;
                case 7 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1835:2: kw= 'OclInvalid'
                    {
                    kw=(Token)match(input,58,FollowSets000.FOLLOW_58_in_rulePrimitiveTypeIdentifier4526); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getOclInvalidKeyword_6()); 
                          
                    }

                    }
                    break;
                case 8 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1842:2: kw= 'OclVoid'
                    {
                    kw=(Token)match(input,59,FollowSets000.FOLLOW_59_in_rulePrimitiveTypeIdentifier4545); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1855:1: entryRulePrimitiveTypeCS returns [EObject current=null] : iv_rulePrimitiveTypeCS= rulePrimitiveTypeCS EOF ;
    public final EObject entryRulePrimitiveTypeCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveTypeCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1856:2: (iv_rulePrimitiveTypeCS= rulePrimitiveTypeCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1857:2: iv_rulePrimitiveTypeCS= rulePrimitiveTypeCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimitiveTypeCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePrimitiveTypeCS_in_entryRulePrimitiveTypeCS4585);
            iv_rulePrimitiveTypeCS=rulePrimitiveTypeCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimitiveTypeCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrimitiveTypeCS4595); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1864:1: rulePrimitiveTypeCS returns [EObject current=null] : ( (lv_name_0_0= rulePrimitiveTypeIdentifier ) ) ;
    public final EObject rulePrimitiveTypeCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1867:28: ( ( (lv_name_0_0= rulePrimitiveTypeIdentifier ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1868:1: ( (lv_name_0_0= rulePrimitiveTypeIdentifier ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1868:1: ( (lv_name_0_0= rulePrimitiveTypeIdentifier ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1869:1: (lv_name_0_0= rulePrimitiveTypeIdentifier )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1869:1: (lv_name_0_0= rulePrimitiveTypeIdentifier )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1870:3: lv_name_0_0= rulePrimitiveTypeIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPrimitiveTypeCSAccess().getNamePrimitiveTypeIdentifierParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_rulePrimitiveTypeIdentifier_in_rulePrimitiveTypeCS4640);
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
                      		"PrimitiveTypeIdentifier");
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1894:1: entryRuleCollectionTypeIdentifier returns [String current=null] : iv_ruleCollectionTypeIdentifier= ruleCollectionTypeIdentifier EOF ;
    public final String entryRuleCollectionTypeIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleCollectionTypeIdentifier = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1895:2: (iv_ruleCollectionTypeIdentifier= ruleCollectionTypeIdentifier EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1896:2: iv_ruleCollectionTypeIdentifier= ruleCollectionTypeIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCollectionTypeIdentifierRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleCollectionTypeIdentifier_in_entryRuleCollectionTypeIdentifier4676);
            iv_ruleCollectionTypeIdentifier=ruleCollectionTypeIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCollectionTypeIdentifier.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCollectionTypeIdentifier4687); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1903:1: ruleCollectionTypeIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Set' | kw= 'Bag' | kw= 'Sequence' | kw= 'Collection' | kw= 'OrderedSet' ) ;
    public final AntlrDatatypeRuleToken ruleCollectionTypeIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1906:28: ( (kw= 'Set' | kw= 'Bag' | kw= 'Sequence' | kw= 'Collection' | kw= 'OrderedSet' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1907:1: (kw= 'Set' | kw= 'Bag' | kw= 'Sequence' | kw= 'Collection' | kw= 'OrderedSet' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1907:1: (kw= 'Set' | kw= 'Bag' | kw= 'Sequence' | kw= 'Collection' | kw= 'OrderedSet' )
            int alt28=5;
            switch ( input.LA(1) ) {
            case 60:
                {
                alt28=1;
                }
                break;
            case 61:
                {
                alt28=2;
                }
                break;
            case 62:
                {
                alt28=3;
                }
                break;
            case 63:
                {
                alt28=4;
                }
                break;
            case 64:
                {
                alt28=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }

            switch (alt28) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1908:2: kw= 'Set'
                    {
                    kw=(Token)match(input,60,FollowSets000.FOLLOW_60_in_ruleCollectionTypeIdentifier4725); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getSetKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1915:2: kw= 'Bag'
                    {
                    kw=(Token)match(input,61,FollowSets000.FOLLOW_61_in_ruleCollectionTypeIdentifier4744); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getBagKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1922:2: kw= 'Sequence'
                    {
                    kw=(Token)match(input,62,FollowSets000.FOLLOW_62_in_ruleCollectionTypeIdentifier4763); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getSequenceKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1929:2: kw= 'Collection'
                    {
                    kw=(Token)match(input,63,FollowSets000.FOLLOW_63_in_ruleCollectionTypeIdentifier4782); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getCollectionKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1936:2: kw= 'OrderedSet'
                    {
                    kw=(Token)match(input,64,FollowSets000.FOLLOW_64_in_ruleCollectionTypeIdentifier4801); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1949:1: entryRuleCollectionTypeCS returns [EObject current=null] : iv_ruleCollectionTypeCS= ruleCollectionTypeCS EOF ;
    public final EObject entryRuleCollectionTypeCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionTypeCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1950:2: (iv_ruleCollectionTypeCS= ruleCollectionTypeCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1951:2: iv_ruleCollectionTypeCS= ruleCollectionTypeCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCollectionTypeCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleCollectionTypeCS_in_entryRuleCollectionTypeCS4841);
            iv_ruleCollectionTypeCS=ruleCollectionTypeCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCollectionTypeCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCollectionTypeCS4851); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1958:1: ruleCollectionTypeCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )? ) ;
    public final EObject ruleCollectionTypeCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1961:28: ( ( ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1962:1: ( ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1962:1: ( ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1962:2: ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )?
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1962:2: ( (lv_name_0_0= ruleCollectionTypeIdentifier ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1963:1: (lv_name_0_0= ruleCollectionTypeIdentifier )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1963:1: (lv_name_0_0= ruleCollectionTypeIdentifier )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1964:3: lv_name_0_0= ruleCollectionTypeIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCollectionTypeCSAccess().getNameCollectionTypeIdentifierParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleCollectionTypeIdentifier_in_ruleCollectionTypeCS4897);
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
                      		"CollectionTypeIdentifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1980:2: (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==65) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1980:4: otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,65,FollowSets000.FOLLOW_65_in_ruleCollectionTypeCS4910); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getCollectionTypeCSAccess().getLeftParenthesisKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1984:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1985:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1985:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1986:3: lv_ownedType_2_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionTypeCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleCollectionTypeCS4931);
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
                              		"TypeExpCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_3=(Token)match(input,66,FollowSets000.FOLLOW_66_in_ruleCollectionTypeCS4943); if (state.failed) return current;
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


    // $ANTLR start "entryRuleMultiplicityBoundsCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2014:1: entryRuleMultiplicityBoundsCS returns [EObject current=null] : iv_ruleMultiplicityBoundsCS= ruleMultiplicityBoundsCS EOF ;
    public final EObject entryRuleMultiplicityBoundsCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicityBoundsCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2015:2: (iv_ruleMultiplicityBoundsCS= ruleMultiplicityBoundsCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2016:2: iv_ruleMultiplicityBoundsCS= ruleMultiplicityBoundsCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicityBoundsCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMultiplicityBoundsCS_in_entryRuleMultiplicityBoundsCS4981);
            iv_ruleMultiplicityBoundsCS=ruleMultiplicityBoundsCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicityBoundsCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMultiplicityBoundsCS4991); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2023:1: ruleMultiplicityBoundsCS returns [EObject current=null] : ( ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )? ) ;
    public final EObject ruleMultiplicityBoundsCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_lowerBound_0_0 = null;

        AntlrDatatypeRuleToken lv_upperBound_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2026:28: ( ( ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2027:1: ( ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2027:1: ( ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2027:2: ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )?
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2027:2: ( (lv_lowerBound_0_0= ruleLOWER ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2028:1: (lv_lowerBound_0_0= ruleLOWER )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2028:1: (lv_lowerBound_0_0= ruleLOWER )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2029:3: lv_lowerBound_0_0= ruleLOWER
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiplicityBoundsCSAccess().getLowerBoundLOWERParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleLOWER_in_ruleMultiplicityBoundsCS5037);
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
                      		"LOWER");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2045:2: (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==67) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2045:4: otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) )
                    {
                    otherlv_1=(Token)match(input,67,FollowSets000.FOLLOW_67_in_ruleMultiplicityBoundsCS5050); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getMultiplicityBoundsCSAccess().getFullStopFullStopKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2049:1: ( (lv_upperBound_2_0= ruleUPPER ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2050:1: (lv_upperBound_2_0= ruleUPPER )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2050:1: (lv_upperBound_2_0= ruleUPPER )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2051:3: lv_upperBound_2_0= ruleUPPER
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMultiplicityBoundsCSAccess().getUpperBoundUPPERParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUPPER_in_ruleMultiplicityBoundsCS5071);
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
                              		"UPPER");
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2075:1: entryRuleMultiplicityCS returns [EObject current=null] : iv_ruleMultiplicityCS= ruleMultiplicityCS EOF ;
    public final EObject entryRuleMultiplicityCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicityCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2076:2: (iv_ruleMultiplicityCS= ruleMultiplicityCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2077:2: iv_ruleMultiplicityCS= ruleMultiplicityCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicityCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMultiplicityCS_in_entryRuleMultiplicityCS5109);
            iv_ruleMultiplicityCS=ruleMultiplicityCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicityCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMultiplicityCS5119); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2084:1: ruleMultiplicityCS returns [EObject current=null] : (otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) otherlv_3= ']' ) ;
    public final EObject ruleMultiplicityCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        EObject this_MultiplicityBoundsCS_1 = null;

        EObject this_MultiplicityStringCS_2 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2087:28: ( (otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) otherlv_3= ']' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2088:1: (otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) otherlv_3= ']' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2088:1: (otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) otherlv_3= ']' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2088:3: otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) otherlv_3= ']'
            {
            otherlv_0=(Token)match(input,68,FollowSets000.FOLLOW_68_in_ruleMultiplicityCS5156); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMultiplicityCSAccess().getLeftSquareBracketKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2092:1: (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==RULE_INT) ) {
                alt31=1;
            }
            else if ( (LA31_0==34||LA31_0==38||LA31_0==70) ) {
                alt31=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }
            switch (alt31) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2093:2: this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getMultiplicityCSAccess().getMultiplicityBoundsCSParserRuleCall_1_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMultiplicityBoundsCS_in_ruleMultiplicityCS5182);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2106:2: this_MultiplicityStringCS_2= ruleMultiplicityStringCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getMultiplicityCSAccess().getMultiplicityStringCSParserRuleCall_1_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMultiplicityStringCS_in_ruleMultiplicityCS5212);
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

            otherlv_3=(Token)match(input,69,FollowSets000.FOLLOW_69_in_ruleMultiplicityCS5224); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getMultiplicityCSAccess().getRightSquareBracketKeyword_2());
                  
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2129:1: entryRuleMultiplicityStringCS returns [EObject current=null] : iv_ruleMultiplicityStringCS= ruleMultiplicityStringCS EOF ;
    public final EObject entryRuleMultiplicityStringCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicityStringCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2130:2: (iv_ruleMultiplicityStringCS= ruleMultiplicityStringCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2131:2: iv_ruleMultiplicityStringCS= ruleMultiplicityStringCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicityStringCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMultiplicityStringCS_in_entryRuleMultiplicityStringCS5260);
            iv_ruleMultiplicityStringCS=ruleMultiplicityStringCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicityStringCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMultiplicityStringCS5270); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2138:1: ruleMultiplicityStringCS returns [EObject current=null] : ( ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) ) ) ;
    public final EObject ruleMultiplicityStringCS() throws RecognitionException {
        EObject current = null;

        Token lv_stringBounds_0_1=null;
        Token lv_stringBounds_0_2=null;
        Token lv_stringBounds_0_3=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2141:28: ( ( ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2142:1: ( ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2142:1: ( ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2143:1: ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2143:1: ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2144:1: (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2144:1: (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' )
            int alt32=3;
            switch ( input.LA(1) ) {
            case 34:
                {
                alt32=1;
                }
                break;
            case 38:
                {
                alt32=2;
                }
                break;
            case 70:
                {
                alt32=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }

            switch (alt32) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2145:3: lv_stringBounds_0_1= '*'
                    {
                    lv_stringBounds_0_1=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleMultiplicityStringCS5314); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2157:8: lv_stringBounds_0_2= '+'
                    {
                    lv_stringBounds_0_2=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleMultiplicityStringCS5343); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2169:8: lv_stringBounds_0_3= '?'
                    {
                    lv_stringBounds_0_3=(Token)match(input,70,FollowSets000.FOLLOW_70_in_ruleMultiplicityStringCS5372); if (state.failed) return current;
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


    // $ANTLR start "entryRuleTupleTypeCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2192:1: entryRuleTupleTypeCS returns [EObject current=null] : iv_ruleTupleTypeCS= ruleTupleTypeCS EOF ;
    public final EObject entryRuleTupleTypeCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTupleTypeCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2193:2: (iv_ruleTupleTypeCS= ruleTupleTypeCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2194:2: iv_ruleTupleTypeCS= ruleTupleTypeCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTupleTypeCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTupleTypeCS_in_entryRuleTupleTypeCS5423);
            iv_ruleTupleTypeCS=ruleTupleTypeCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTupleTypeCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTupleTypeCS5433); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2201:1: ruleTupleTypeCS returns [EObject current=null] : ( ( (lv_name_0_0= 'Tuple' ) ) (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )? ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2204:28: ( ( ( (lv_name_0_0= 'Tuple' ) ) (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2205:1: ( ( (lv_name_0_0= 'Tuple' ) ) (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2205:1: ( ( (lv_name_0_0= 'Tuple' ) ) (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2205:2: ( (lv_name_0_0= 'Tuple' ) ) (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )?
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2205:2: ( (lv_name_0_0= 'Tuple' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2206:1: (lv_name_0_0= 'Tuple' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2206:1: (lv_name_0_0= 'Tuple' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2207:3: lv_name_0_0= 'Tuple'
            {
            lv_name_0_0=(Token)match(input,51,FollowSets000.FOLLOW_51_in_ruleTupleTypeCS5476); if (state.failed) return current;
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2220:2: (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==65) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2220:4: otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')'
                    {
                    otherlv_1=(Token)match(input,65,FollowSets000.FOLLOW_65_in_ruleTupleTypeCS5502); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getTupleTypeCSAccess().getLeftParenthesisKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2224:1: ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )?
                    int alt34=2;
                    int LA34_0 = input.LA(1);

                    if ( ((LA34_0>=RULE_SIMPLE_ID && LA34_0<=RULE_ESCAPED_ID)||(LA34_0>=21 && LA34_0<=22)||(LA34_0>=25 && LA34_0<=33)) ) {
                        alt34=1;
                    }
                    switch (alt34) {
                        case 1 :
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2224:2: ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )*
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2224:2: ( (lv_ownedParts_2_0= ruleTuplePartCS ) )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2225:1: (lv_ownedParts_2_0= ruleTuplePartCS )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2225:1: (lv_ownedParts_2_0= ruleTuplePartCS )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2226:3: lv_ownedParts_2_0= ruleTuplePartCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getTupleTypeCSAccess().getOwnedPartsTuplePartCSParserRuleCall_1_1_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleTuplePartCS_in_ruleTupleTypeCS5524);
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
                                      		"TuplePartCS");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2242:2: (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )*
                            loop33:
                            do {
                                int alt33=2;
                                int LA33_0 = input.LA(1);

                                if ( (LA33_0==16) ) {
                                    alt33=1;
                                }


                                switch (alt33) {
                            	case 1 :
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2242:4: otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) )
                            	    {
                            	    otherlv_3=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleTupleTypeCS5537); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_3, grammarAccess.getTupleTypeCSAccess().getCommaKeyword_1_1_1_0());
                            	          
                            	    }
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2246:1: ( (lv_ownedParts_4_0= ruleTuplePartCS ) )
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2247:1: (lv_ownedParts_4_0= ruleTuplePartCS )
                            	    {
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2247:1: (lv_ownedParts_4_0= ruleTuplePartCS )
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2248:3: lv_ownedParts_4_0= ruleTuplePartCS
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getTupleTypeCSAccess().getOwnedPartsTuplePartCSParserRuleCall_1_1_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FollowSets000.FOLLOW_ruleTuplePartCS_in_ruleTupleTypeCS5558);
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
                            	              		"TuplePartCS");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop33;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_5=(Token)match(input,66,FollowSets000.FOLLOW_66_in_ruleTupleTypeCS5574); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2276:1: entryRuleTuplePartCS returns [EObject current=null] : iv_ruleTuplePartCS= ruleTuplePartCS EOF ;
    public final EObject entryRuleTuplePartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTuplePartCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2277:2: (iv_ruleTuplePartCS= ruleTuplePartCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2278:2: iv_ruleTuplePartCS= ruleTuplePartCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTuplePartCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTuplePartCS_in_entryRuleTuplePartCS5612);
            iv_ruleTuplePartCS=ruleTuplePartCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTuplePartCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTuplePartCS5622); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2285:1: ruleTuplePartCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) ) ;
    public final EObject ruleTuplePartCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2288:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2289:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2289:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2289:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2289:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2290:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2290:1: (lv_name_0_0= ruleUnrestrictedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2291:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTuplePartCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleTuplePartCS5668);
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
                      		"UnrestrictedName");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleTuplePartCS5680); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getTuplePartCSAccess().getColonKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2311:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2312:1: (lv_ownedType_2_0= ruleTypeExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2312:1: (lv_ownedType_2_0= ruleTypeExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2313:3: lv_ownedType_2_0= ruleTypeExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTuplePartCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleTuplePartCS5701);
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
                      		"TypeExpCS");
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2337:1: entryRuleCollectionLiteralExpCS returns [EObject current=null] : iv_ruleCollectionLiteralExpCS= ruleCollectionLiteralExpCS EOF ;
    public final EObject entryRuleCollectionLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2338:2: (iv_ruleCollectionLiteralExpCS= ruleCollectionLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2339:2: iv_ruleCollectionLiteralExpCS= ruleCollectionLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCollectionLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteralExpCS_in_entryRuleCollectionLiteralExpCS5737);
            iv_ruleCollectionLiteralExpCS=ruleCollectionLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCollectionLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCollectionLiteralExpCS5747); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2346:1: ruleCollectionLiteralExpCS returns [EObject current=null] : ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}' ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2349:28: ( ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2350:1: ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2350:1: ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2350:2: ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}'
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2350:2: ( (lv_ownedType_0_0= ruleCollectionTypeCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2351:1: (lv_ownedType_0_0= ruleCollectionTypeCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2351:1: (lv_ownedType_0_0= ruleCollectionTypeCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2352:3: lv_ownedType_0_0= ruleCollectionTypeCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedTypeCollectionTypeCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleCollectionTypeCS_in_ruleCollectionLiteralExpCS5793);
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
                      		"CollectionTypeCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,71,FollowSets000.FOLLOW_71_in_ruleCollectionLiteralExpCS5805); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getCollectionLiteralExpCSAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2372:1: ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( ((LA37_0>=RULE_SIMPLE_ID && LA37_0<=RULE_SINGLE_QUOTED_STRING)||(LA37_0>=21 && LA37_0<=22)||(LA37_0>=25 && LA37_0<=36)||(LA37_0>=51 && LA37_0<=65)||(LA37_0>=73 && LA37_0<=76)||LA37_0==79||LA37_0==83||LA37_0==85) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2372:2: ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )*
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2372:2: ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2373:1: (lv_ownedParts_2_0= ruleCollectionLiteralPartCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2373:1: (lv_ownedParts_2_0= ruleCollectionLiteralPartCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2374:3: lv_ownedParts_2_0= ruleCollectionLiteralPartCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedPartsCollectionLiteralPartCSParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteralPartCS_in_ruleCollectionLiteralExpCS5827);
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
                              		"CollectionLiteralPartCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2390:2: (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )*
                    loop36:
                    do {
                        int alt36=2;
                        int LA36_0 = input.LA(1);

                        if ( (LA36_0==16) ) {
                            alt36=1;
                        }


                        switch (alt36) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2390:4: otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) )
                    	    {
                    	    otherlv_3=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleCollectionLiteralExpCS5840); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getCollectionLiteralExpCSAccess().getCommaKeyword_2_1_0());
                    	          
                    	    }
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2394:1: ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2395:1: (lv_ownedParts_4_0= ruleCollectionLiteralPartCS )
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2395:1: (lv_ownedParts_4_0= ruleCollectionLiteralPartCS )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2396:3: lv_ownedParts_4_0= ruleCollectionLiteralPartCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedPartsCollectionLiteralPartCSParserRuleCall_2_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteralPartCS_in_ruleCollectionLiteralExpCS5861);
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
                    	              		"CollectionLiteralPartCS");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop36;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,72,FollowSets000.FOLLOW_72_in_ruleCollectionLiteralExpCS5877); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2424:1: entryRuleCollectionLiteralPartCS returns [EObject current=null] : iv_ruleCollectionLiteralPartCS= ruleCollectionLiteralPartCS EOF ;
    public final EObject entryRuleCollectionLiteralPartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionLiteralPartCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2425:2: (iv_ruleCollectionLiteralPartCS= ruleCollectionLiteralPartCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2426:2: iv_ruleCollectionLiteralPartCS= ruleCollectionLiteralPartCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCollectionLiteralPartCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteralPartCS_in_entryRuleCollectionLiteralPartCS5913);
            iv_ruleCollectionLiteralPartCS=ruleCollectionLiteralPartCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCollectionLiteralPartCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCollectionLiteralPartCS5923); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2433:1: ruleCollectionLiteralPartCS returns [EObject current=null] : ( ( (lv_expressionCS_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_lastExpressionCS_2_0= ruleExpCS ) ) )? ) ;
    public final EObject ruleCollectionLiteralPartCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expressionCS_0_0 = null;

        EObject lv_lastExpressionCS_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2436:28: ( ( ( (lv_expressionCS_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_lastExpressionCS_2_0= ruleExpCS ) ) )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2437:1: ( ( (lv_expressionCS_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_lastExpressionCS_2_0= ruleExpCS ) ) )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2437:1: ( ( (lv_expressionCS_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_lastExpressionCS_2_0= ruleExpCS ) ) )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2437:2: ( (lv_expressionCS_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_lastExpressionCS_2_0= ruleExpCS ) ) )?
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2437:2: ( (lv_expressionCS_0_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2438:1: (lv_expressionCS_0_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2438:1: (lv_expressionCS_0_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2439:3: lv_expressionCS_0_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCollectionLiteralPartCSAccess().getExpressionCSExpCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleCollectionLiteralPartCS5969);
            lv_expressionCS_0_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getCollectionLiteralPartCSRule());
              	        }
                     		set(
                     			current, 
                     			"expressionCS",
                      		lv_expressionCS_0_0, 
                      		"ExpCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2455:2: (otherlv_1= '..' ( (lv_lastExpressionCS_2_0= ruleExpCS ) ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==67) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2455:4: otherlv_1= '..' ( (lv_lastExpressionCS_2_0= ruleExpCS ) )
                    {
                    otherlv_1=(Token)match(input,67,FollowSets000.FOLLOW_67_in_ruleCollectionLiteralPartCS5982); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getCollectionLiteralPartCSAccess().getFullStopFullStopKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2459:1: ( (lv_lastExpressionCS_2_0= ruleExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2460:1: (lv_lastExpressionCS_2_0= ruleExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2460:1: (lv_lastExpressionCS_2_0= ruleExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2461:3: lv_lastExpressionCS_2_0= ruleExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionLiteralPartCSAccess().getLastExpressionCSExpCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleCollectionLiteralPartCS6003);
                    lv_lastExpressionCS_2_0=ruleExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getCollectionLiteralPartCSRule());
                      	        }
                             		set(
                             			current, 
                             			"lastExpressionCS",
                              		lv_lastExpressionCS_2_0, 
                              		"ExpCS");
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
    // $ANTLR end "ruleCollectionLiteralPartCS"


    // $ANTLR start "entryRuleConstructorPartCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2485:1: entryRuleConstructorPartCS returns [EObject current=null] : iv_ruleConstructorPartCS= ruleConstructorPartCS EOF ;
    public final EObject entryRuleConstructorPartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstructorPartCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2486:2: (iv_ruleConstructorPartCS= ruleConstructorPartCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2487:2: iv_ruleConstructorPartCS= ruleConstructorPartCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstructorPartCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleConstructorPartCS_in_entryRuleConstructorPartCS6041);
            iv_ruleConstructorPartCS=ruleConstructorPartCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConstructorPartCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleConstructorPartCS6051); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConstructorPartCS"


    // $ANTLR start "ruleConstructorPartCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2494:1: ruleConstructorPartCS returns [EObject current=null] : ( ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( (lv_initExpression_2_0= ruleExpCS ) ) ) ;
    public final EObject ruleConstructorPartCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_initExpression_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2497:28: ( ( ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( (lv_initExpression_2_0= ruleExpCS ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2498:1: ( ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( (lv_initExpression_2_0= ruleExpCS ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2498:1: ( ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( (lv_initExpression_2_0= ruleExpCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2498:2: ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( (lv_initExpression_2_0= ruleExpCS ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2498:2: ( ( ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2499:1: ( ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2499:1: ( ruleUnrestrictedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2500:3: ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getConstructorPartCSRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getConstructorPartCSAccess().getPropertyPropertyCrossReference_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleConstructorPartCS6103);
            ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,43,FollowSets000.FOLLOW_43_in_ruleConstructorPartCS6115); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getConstructorPartCSAccess().getEqualsSignKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2520:1: ( (lv_initExpression_2_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2521:1: (lv_initExpression_2_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2521:1: (lv_initExpression_2_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2522:3: lv_initExpression_2_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getConstructorPartCSAccess().getInitExpressionExpCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleConstructorPartCS6136);
            lv_initExpression_2_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getConstructorPartCSRule());
              	        }
                     		set(
                     			current, 
                     			"initExpression",
                      		lv_initExpression_2_0, 
                      		"ExpCS");
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
    // $ANTLR end "ruleConstructorPartCS"


    // $ANTLR start "entryRulePrimitiveLiteralExpCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2546:1: entryRulePrimitiveLiteralExpCS returns [EObject current=null] : iv_rulePrimitiveLiteralExpCS= rulePrimitiveLiteralExpCS EOF ;
    public final EObject entryRulePrimitiveLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2547:2: (iv_rulePrimitiveLiteralExpCS= rulePrimitiveLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2548:2: iv_rulePrimitiveLiteralExpCS= rulePrimitiveLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePrimitiveLiteralExpCS_in_entryRulePrimitiveLiteralExpCS6172);
            iv_rulePrimitiveLiteralExpCS=rulePrimitiveLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimitiveLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrimitiveLiteralExpCS6182); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2555:1: rulePrimitiveLiteralExpCS returns [EObject current=null] : (this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS | this_StringLiteralExpCS_1= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_5= ruleNullLiteralExpCS ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2558:28: ( (this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS | this_StringLiteralExpCS_1= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_5= ruleNullLiteralExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2559:1: (this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS | this_StringLiteralExpCS_1= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_5= ruleNullLiteralExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2559:1: (this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS | this_StringLiteralExpCS_1= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_5= ruleNullLiteralExpCS )
            int alt39=6;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt39=1;
                }
                break;
            case RULE_SINGLE_QUOTED_STRING:
                {
                alt39=2;
                }
                break;
            case 73:
            case 74:
                {
                alt39=3;
                }
                break;
            case 34:
                {
                alt39=4;
                }
                break;
            case 75:
                {
                alt39=5;
                }
                break;
            case 76:
                {
                alt39=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }

            switch (alt39) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2560:2: this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getNumberLiteralExpCSParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNumberLiteralExpCS_in_rulePrimitiveLiteralExpCS6232);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2573:2: this_StringLiteralExpCS_1= ruleStringLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getStringLiteralExpCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleStringLiteralExpCS_in_rulePrimitiveLiteralExpCS6262);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2586:2: this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getBooleanLiteralExpCSParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleBooleanLiteralExpCS_in_rulePrimitiveLiteralExpCS6292);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2599:2: this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getUnlimitedNaturalLiteralExpCSParserRuleCall_3()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUnlimitedNaturalLiteralExpCS_in_rulePrimitiveLiteralExpCS6322);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2612:2: this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getInvalidLiteralExpCSParserRuleCall_4()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleInvalidLiteralExpCS_in_rulePrimitiveLiteralExpCS6352);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2625:2: this_NullLiteralExpCS_5= ruleNullLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getNullLiteralExpCSParserRuleCall_5()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNullLiteralExpCS_in_rulePrimitiveLiteralExpCS6382);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2644:1: entryRuleTupleLiteralExpCS returns [EObject current=null] : iv_ruleTupleLiteralExpCS= ruleTupleLiteralExpCS EOF ;
    public final EObject entryRuleTupleLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTupleLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2645:2: (iv_ruleTupleLiteralExpCS= ruleTupleLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2646:2: iv_ruleTupleLiteralExpCS= ruleTupleLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTupleLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralExpCS_in_entryRuleTupleLiteralExpCS6417);
            iv_ruleTupleLiteralExpCS=ruleTupleLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTupleLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTupleLiteralExpCS6427); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2653:1: ruleTupleLiteralExpCS returns [EObject current=null] : (otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}' ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2656:28: ( (otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2657:1: (otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2657:1: (otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2657:3: otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,51,FollowSets000.FOLLOW_51_in_ruleTupleLiteralExpCS6464); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getTupleLiteralExpCSAccess().getTupleKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,71,FollowSets000.FOLLOW_71_in_ruleTupleLiteralExpCS6476); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getTupleLiteralExpCSAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2665:1: ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2666:1: (lv_ownedParts_2_0= ruleTupleLiteralPartCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2666:1: (lv_ownedParts_2_0= ruleTupleLiteralPartCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2667:3: lv_ownedParts_2_0= ruleTupleLiteralPartCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTupleLiteralExpCSAccess().getOwnedPartsTupleLiteralPartCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralPartCS_in_ruleTupleLiteralExpCS6497);
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
                      		"TupleLiteralPartCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2683:2: (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==16) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2683:4: otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) )
            	    {
            	    otherlv_3=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleTupleLiteralExpCS6510); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getTupleLiteralExpCSAccess().getCommaKeyword_3_0());
            	          
            	    }
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2687:1: ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2688:1: (lv_ownedParts_4_0= ruleTupleLiteralPartCS )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2688:1: (lv_ownedParts_4_0= ruleTupleLiteralPartCS )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2689:3: lv_ownedParts_4_0= ruleTupleLiteralPartCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTupleLiteralExpCSAccess().getOwnedPartsTupleLiteralPartCSParserRuleCall_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralPartCS_in_ruleTupleLiteralExpCS6531);
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
            	              		"TupleLiteralPartCS");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop40;
                }
            } while (true);

            otherlv_5=(Token)match(input,72,FollowSets000.FOLLOW_72_in_ruleTupleLiteralExpCS6545); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2717:1: entryRuleTupleLiteralPartCS returns [EObject current=null] : iv_ruleTupleLiteralPartCS= ruleTupleLiteralPartCS EOF ;
    public final EObject entryRuleTupleLiteralPartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTupleLiteralPartCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2718:2: (iv_ruleTupleLiteralPartCS= ruleTupleLiteralPartCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2719:2: iv_ruleTupleLiteralPartCS= ruleTupleLiteralPartCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTupleLiteralPartCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralPartCS_in_entryRuleTupleLiteralPartCS6581);
            iv_ruleTupleLiteralPartCS=ruleTupleLiteralPartCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTupleLiteralPartCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTupleLiteralPartCS6591); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2726:1: ruleTupleLiteralPartCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) ) ) ;
    public final EObject ruleTupleLiteralPartCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;

        EObject lv_initExpression_4_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2729:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2730:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2730:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2730:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2730:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2731:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2731:1: (lv_name_0_0= ruleUnrestrictedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2732:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTupleLiteralPartCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleTupleLiteralPartCS6637);
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
                      		"UnrestrictedName");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2748:2: (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==23) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2748:4: otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                    {
                    otherlv_1=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleTupleLiteralPartCS6650); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getTupleLiteralPartCSAccess().getColonKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2752:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2753:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2753:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2754:3: lv_ownedType_2_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTupleLiteralPartCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleTupleLiteralPartCS6671);
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
                              		"TypeExpCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,43,FollowSets000.FOLLOW_43_in_ruleTupleLiteralPartCS6685); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getTupleLiteralPartCSAccess().getEqualsSignKeyword_2());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2774:1: ( (lv_initExpression_4_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2775:1: (lv_initExpression_4_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2775:1: (lv_initExpression_4_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2776:3: lv_initExpression_4_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTupleLiteralPartCSAccess().getInitExpressionExpCSParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleTupleLiteralPartCS6706);
            lv_initExpression_4_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTupleLiteralPartCSRule());
              	        }
                     		set(
                     			current, 
                     			"initExpression",
                      		lv_initExpression_4_0, 
                      		"ExpCS");
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2800:1: entryRuleNumberLiteralExpCS returns [EObject current=null] : iv_ruleNumberLiteralExpCS= ruleNumberLiteralExpCS EOF ;
    public final EObject entryRuleNumberLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2801:2: (iv_ruleNumberLiteralExpCS= ruleNumberLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2802:2: iv_ruleNumberLiteralExpCS= ruleNumberLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumberLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNumberLiteralExpCS_in_entryRuleNumberLiteralExpCS6742);
            iv_ruleNumberLiteralExpCS=ruleNumberLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumberLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNumberLiteralExpCS6752); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2809:1: ruleNumberLiteralExpCS returns [EObject current=null] : ( (lv_name_0_0= ruleNUMBER_LITERAL ) ) ;
    public final EObject ruleNumberLiteralExpCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2812:28: ( ( (lv_name_0_0= ruleNUMBER_LITERAL ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2813:1: ( (lv_name_0_0= ruleNUMBER_LITERAL ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2813:1: ( (lv_name_0_0= ruleNUMBER_LITERAL ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2814:1: (lv_name_0_0= ruleNUMBER_LITERAL )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2814:1: (lv_name_0_0= ruleNUMBER_LITERAL )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2815:3: lv_name_0_0= ruleNUMBER_LITERAL
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNumberLiteralExpCSAccess().getNameNUMBER_LITERALParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleNUMBER_LITERAL_in_ruleNumberLiteralExpCS6797);
            lv_name_0_0=ruleNUMBER_LITERAL();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getNumberLiteralExpCSRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"NUMBER_LITERAL");
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2839:1: entryRuleStringLiteralExpCS returns [EObject current=null] : iv_ruleStringLiteralExpCS= ruleStringLiteralExpCS EOF ;
    public final EObject entryRuleStringLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2840:2: (iv_ruleStringLiteralExpCS= ruleStringLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2841:2: iv_ruleStringLiteralExpCS= ruleStringLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStringLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleStringLiteralExpCS_in_entryRuleStringLiteralExpCS6832);
            iv_ruleStringLiteralExpCS=ruleStringLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStringLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleStringLiteralExpCS6842); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2848:1: ruleStringLiteralExpCS returns [EObject current=null] : ( (lv_name_0_0= ruleStringLiteral ) )+ ;
    public final EObject ruleStringLiteralExpCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2851:28: ( ( (lv_name_0_0= ruleStringLiteral ) )+ )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2852:1: ( (lv_name_0_0= ruleStringLiteral ) )+
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2852:1: ( (lv_name_0_0= ruleStringLiteral ) )+
            int cnt42=0;
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==RULE_SINGLE_QUOTED_STRING) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2853:1: (lv_name_0_0= ruleStringLiteral )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2853:1: (lv_name_0_0= ruleStringLiteral )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2854:3: lv_name_0_0= ruleStringLiteral
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getStringLiteralExpCSAccess().getNameStringLiteralParserRuleCall_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleStringLiteral_in_ruleStringLiteralExpCS6887);
            	    lv_name_0_0=ruleStringLiteral();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getStringLiteralExpCSRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"name",
            	              		lv_name_0_0, 
            	              		"StringLiteral");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2878:1: entryRuleBooleanLiteralExpCS returns [EObject current=null] : iv_ruleBooleanLiteralExpCS= ruleBooleanLiteralExpCS EOF ;
    public final EObject entryRuleBooleanLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2879:2: (iv_ruleBooleanLiteralExpCS= ruleBooleanLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2880:2: iv_ruleBooleanLiteralExpCS= ruleBooleanLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBooleanLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleBooleanLiteralExpCS_in_entryRuleBooleanLiteralExpCS6923);
            iv_ruleBooleanLiteralExpCS=ruleBooleanLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBooleanLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBooleanLiteralExpCS6933); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2887:1: ruleBooleanLiteralExpCS returns [EObject current=null] : ( ( (lv_name_0_0= 'true' ) ) | ( (lv_name_1_0= 'false' ) ) ) ;
    public final EObject ruleBooleanLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2890:28: ( ( ( (lv_name_0_0= 'true' ) ) | ( (lv_name_1_0= 'false' ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2891:1: ( ( (lv_name_0_0= 'true' ) ) | ( (lv_name_1_0= 'false' ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2891:1: ( ( (lv_name_0_0= 'true' ) ) | ( (lv_name_1_0= 'false' ) ) )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==73) ) {
                alt43=1;
            }
            else if ( (LA43_0==74) ) {
                alt43=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }
            switch (alt43) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2891:2: ( (lv_name_0_0= 'true' ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2891:2: ( (lv_name_0_0= 'true' ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2892:1: (lv_name_0_0= 'true' )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2892:1: (lv_name_0_0= 'true' )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2893:3: lv_name_0_0= 'true'
                    {
                    lv_name_0_0=(Token)match(input,73,FollowSets000.FOLLOW_73_in_ruleBooleanLiteralExpCS6976); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_name_0_0, grammarAccess.getBooleanLiteralExpCSAccess().getNameTrueKeyword_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBooleanLiteralExpCSRule());
                      	        }
                             		setWithLastConsumed(current, "name", lv_name_0_0, "true");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2907:6: ( (lv_name_1_0= 'false' ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2907:6: ( (lv_name_1_0= 'false' ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2908:1: (lv_name_1_0= 'false' )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2908:1: (lv_name_1_0= 'false' )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2909:3: lv_name_1_0= 'false'
                    {
                    lv_name_1_0=(Token)match(input,74,FollowSets000.FOLLOW_74_in_ruleBooleanLiteralExpCS7013); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_name_1_0, grammarAccess.getBooleanLiteralExpCSAccess().getNameFalseKeyword_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBooleanLiteralExpCSRule());
                      	        }
                             		setWithLastConsumed(current, "name", lv_name_1_0, "false");
                      	    
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2930:1: entryRuleUnlimitedNaturalLiteralExpCS returns [EObject current=null] : iv_ruleUnlimitedNaturalLiteralExpCS= ruleUnlimitedNaturalLiteralExpCS EOF ;
    public final EObject entryRuleUnlimitedNaturalLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnlimitedNaturalLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2931:2: (iv_ruleUnlimitedNaturalLiteralExpCS= ruleUnlimitedNaturalLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2932:2: iv_ruleUnlimitedNaturalLiteralExpCS= ruleUnlimitedNaturalLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnlimitedNaturalLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnlimitedNaturalLiteralExpCS_in_entryRuleUnlimitedNaturalLiteralExpCS7062);
            iv_ruleUnlimitedNaturalLiteralExpCS=ruleUnlimitedNaturalLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnlimitedNaturalLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnlimitedNaturalLiteralExpCS7072); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2939:1: ruleUnlimitedNaturalLiteralExpCS returns [EObject current=null] : ( () otherlv_1= '*' ) ;
    public final EObject ruleUnlimitedNaturalLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2942:28: ( ( () otherlv_1= '*' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2943:1: ( () otherlv_1= '*' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2943:1: ( () otherlv_1= '*' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2943:2: () otherlv_1= '*'
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2943:2: ()
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2944:2: 
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

            otherlv_1=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleUnlimitedNaturalLiteralExpCS7121); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2964:1: entryRuleInvalidLiteralExpCS returns [EObject current=null] : iv_ruleInvalidLiteralExpCS= ruleInvalidLiteralExpCS EOF ;
    public final EObject entryRuleInvalidLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInvalidLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2965:2: (iv_ruleInvalidLiteralExpCS= ruleInvalidLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2966:2: iv_ruleInvalidLiteralExpCS= ruleInvalidLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInvalidLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleInvalidLiteralExpCS_in_entryRuleInvalidLiteralExpCS7157);
            iv_ruleInvalidLiteralExpCS=ruleInvalidLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInvalidLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleInvalidLiteralExpCS7167); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2973:1: ruleInvalidLiteralExpCS returns [EObject current=null] : ( () otherlv_1= 'invalid' ) ;
    public final EObject ruleInvalidLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2976:28: ( ( () otherlv_1= 'invalid' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2977:1: ( () otherlv_1= 'invalid' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2977:1: ( () otherlv_1= 'invalid' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2977:2: () otherlv_1= 'invalid'
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2977:2: ()
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2978:2: 
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

            otherlv_1=(Token)match(input,75,FollowSets000.FOLLOW_75_in_ruleInvalidLiteralExpCS7216); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2998:1: entryRuleNullLiteralExpCS returns [EObject current=null] : iv_ruleNullLiteralExpCS= ruleNullLiteralExpCS EOF ;
    public final EObject entryRuleNullLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2999:2: (iv_ruleNullLiteralExpCS= ruleNullLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3000:2: iv_ruleNullLiteralExpCS= ruleNullLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNullLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNullLiteralExpCS_in_entryRuleNullLiteralExpCS7252);
            iv_ruleNullLiteralExpCS=ruleNullLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNullLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNullLiteralExpCS7262); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3007:1: ruleNullLiteralExpCS returns [EObject current=null] : ( () otherlv_1= 'null' ) ;
    public final EObject ruleNullLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3010:28: ( ( () otherlv_1= 'null' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3011:1: ( () otherlv_1= 'null' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3011:1: ( () otherlv_1= 'null' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3011:2: () otherlv_1= 'null'
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3011:2: ()
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3012:2: 
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

            otherlv_1=(Token)match(input,76,FollowSets000.FOLLOW_76_in_ruleNullLiteralExpCS7311); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3032:1: entryRuleTypeLiteralCS returns [EObject current=null] : iv_ruleTypeLiteralCS= ruleTypeLiteralCS EOF ;
    public final EObject entryRuleTypeLiteralCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeLiteralCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3033:2: (iv_ruleTypeLiteralCS= ruleTypeLiteralCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3034:2: iv_ruleTypeLiteralCS= ruleTypeLiteralCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeLiteralCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralCS_in_entryRuleTypeLiteralCS7347);
            iv_ruleTypeLiteralCS=ruleTypeLiteralCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeLiteralCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeLiteralCS7357); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3041:1: ruleTypeLiteralCS returns [EObject current=null] : (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS | this_CollectionTypeCS_1= ruleCollectionTypeCS | this_TupleTypeCS_2= ruleTupleTypeCS ) ;
    public final EObject ruleTypeLiteralCS() throws RecognitionException {
        EObject current = null;

        EObject this_PrimitiveTypeCS_0 = null;

        EObject this_CollectionTypeCS_1 = null;

        EObject this_TupleTypeCS_2 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3044:28: ( (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS | this_CollectionTypeCS_1= ruleCollectionTypeCS | this_TupleTypeCS_2= ruleTupleTypeCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3045:1: (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS | this_CollectionTypeCS_1= ruleCollectionTypeCS | this_TupleTypeCS_2= ruleTupleTypeCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3045:1: (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS | this_CollectionTypeCS_1= ruleCollectionTypeCS | this_TupleTypeCS_2= ruleTupleTypeCS )
            int alt44=3;
            switch ( input.LA(1) ) {
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
                {
                alt44=1;
                }
                break;
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
                {
                alt44=2;
                }
                break;
            case 51:
                {
                alt44=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }

            switch (alt44) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3046:2: this_PrimitiveTypeCS_0= rulePrimitiveTypeCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeLiteralCSAccess().getPrimitiveTypeCSParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrimitiveTypeCS_in_ruleTypeLiteralCS7407);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3059:2: this_CollectionTypeCS_1= ruleCollectionTypeCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeLiteralCSAccess().getCollectionTypeCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCollectionTypeCS_in_ruleTypeLiteralCS7437);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3072:2: this_TupleTypeCS_2= ruleTupleTypeCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeLiteralCSAccess().getTupleTypeCSParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTupleTypeCS_in_ruleTypeLiteralCS7467);
                    this_TupleTypeCS_2=ruleTupleTypeCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_TupleTypeCS_2; 
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3091:1: entryRuleTypeLiteralWithMultiplicityCS returns [EObject current=null] : iv_ruleTypeLiteralWithMultiplicityCS= ruleTypeLiteralWithMultiplicityCS EOF ;
    public final EObject entryRuleTypeLiteralWithMultiplicityCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeLiteralWithMultiplicityCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3092:2: (iv_ruleTypeLiteralWithMultiplicityCS= ruleTypeLiteralWithMultiplicityCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3093:2: iv_ruleTypeLiteralWithMultiplicityCS= ruleTypeLiteralWithMultiplicityCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeLiteralWithMultiplicityCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralWithMultiplicityCS_in_entryRuleTypeLiteralWithMultiplicityCS7502);
            iv_ruleTypeLiteralWithMultiplicityCS=ruleTypeLiteralWithMultiplicityCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeLiteralWithMultiplicityCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeLiteralWithMultiplicityCS7512); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3100:1: ruleTypeLiteralWithMultiplicityCS returns [EObject current=null] : (this_TypeLiteralCS_0= ruleTypeLiteralCS ( (lv_multiplicity_1_0= ruleMultiplicityCS ) )? ) ;
    public final EObject ruleTypeLiteralWithMultiplicityCS() throws RecognitionException {
        EObject current = null;

        EObject this_TypeLiteralCS_0 = null;

        EObject lv_multiplicity_1_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3103:28: ( (this_TypeLiteralCS_0= ruleTypeLiteralCS ( (lv_multiplicity_1_0= ruleMultiplicityCS ) )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3104:1: (this_TypeLiteralCS_0= ruleTypeLiteralCS ( (lv_multiplicity_1_0= ruleMultiplicityCS ) )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3104:1: (this_TypeLiteralCS_0= ruleTypeLiteralCS ( (lv_multiplicity_1_0= ruleMultiplicityCS ) )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3105:2: this_TypeLiteralCS_0= ruleTypeLiteralCS ( (lv_multiplicity_1_0= ruleMultiplicityCS ) )?
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getTypeLiteralWithMultiplicityCSAccess().getTypeLiteralCSParserRuleCall_0()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralCS_in_ruleTypeLiteralWithMultiplicityCS7562);
            this_TypeLiteralCS_0=ruleTypeLiteralCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_TypeLiteralCS_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3116:1: ( (lv_multiplicity_1_0= ruleMultiplicityCS ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==68) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3117:1: (lv_multiplicity_1_0= ruleMultiplicityCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3117:1: (lv_multiplicity_1_0= ruleMultiplicityCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3118:3: lv_multiplicity_1_0= ruleMultiplicityCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeLiteralWithMultiplicityCSAccess().getMultiplicityMultiplicityCSParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMultiplicityCS_in_ruleTypeLiteralWithMultiplicityCS7582);
                    lv_multiplicity_1_0=ruleMultiplicityCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTypeLiteralWithMultiplicityCSRule());
                      	        }
                             		set(
                             			current, 
                             			"multiplicity",
                              		lv_multiplicity_1_0, 
                              		"MultiplicityCS");
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3142:1: entryRuleTypeLiteralExpCS returns [EObject current=null] : iv_ruleTypeLiteralExpCS= ruleTypeLiteralExpCS EOF ;
    public final EObject entryRuleTypeLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3143:2: (iv_ruleTypeLiteralExpCS= ruleTypeLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3144:2: iv_ruleTypeLiteralExpCS= ruleTypeLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralExpCS_in_entryRuleTypeLiteralExpCS7619);
            iv_ruleTypeLiteralExpCS=ruleTypeLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeLiteralExpCS7629); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3151:1: ruleTypeLiteralExpCS returns [EObject current=null] : ( (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS ) ) ;
    public final EObject ruleTypeLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject lv_ownedType_0_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3154:28: ( ( (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3155:1: ( (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3155:1: ( (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3156:1: (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3156:1: (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3157:3: lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypeLiteralExpCSAccess().getOwnedTypeTypeLiteralWithMultiplicityCSParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralWithMultiplicityCS_in_ruleTypeLiteralExpCS7674);
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
                      		"TypeLiteralWithMultiplicityCS");
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3181:1: entryRuleTypeNameExpCS returns [EObject current=null] : iv_ruleTypeNameExpCS= ruleTypeNameExpCS EOF ;
    public final EObject entryRuleTypeNameExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeNameExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3182:2: (iv_ruleTypeNameExpCS= ruleTypeNameExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3183:2: iv_ruleTypeNameExpCS= ruleTypeNameExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeNameExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeNameExpCS_in_entryRuleTypeNameExpCS7709);
            iv_ruleTypeNameExpCS=ruleTypeNameExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeNameExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeNameExpCS7719); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3190:1: ruleTypeNameExpCS returns [EObject current=null] : ( (lv_pathName_0_0= rulePathNameCS ) ) ;
    public final EObject ruleTypeNameExpCS() throws RecognitionException {
        EObject current = null;

        EObject lv_pathName_0_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3193:28: ( ( (lv_pathName_0_0= rulePathNameCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3194:1: ( (lv_pathName_0_0= rulePathNameCS ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3194:1: ( (lv_pathName_0_0= rulePathNameCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3195:1: (lv_pathName_0_0= rulePathNameCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3195:1: (lv_pathName_0_0= rulePathNameCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3196:3: lv_pathName_0_0= rulePathNameCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypeNameExpCSAccess().getPathNamePathNameCSParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_rulePathNameCS_in_ruleTypeNameExpCS7764);
            lv_pathName_0_0=rulePathNameCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTypeNameExpCSRule());
              	        }
                     		set(
                     			current, 
                     			"pathName",
                      		lv_pathName_0_0, 
                      		"PathNameCS");
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
    // $ANTLR end "ruleTypeNameExpCS"


    // $ANTLR start "entryRuleTypeExpCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3220:1: entryRuleTypeExpCS returns [EObject current=null] : iv_ruleTypeExpCS= ruleTypeExpCS EOF ;
    public final EObject entryRuleTypeExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3221:2: (iv_ruleTypeExpCS= ruleTypeExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3222:2: iv_ruleTypeExpCS= ruleTypeExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_entryRuleTypeExpCS7799);
            iv_ruleTypeExpCS=ruleTypeExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeExpCS7809); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3229:1: ruleTypeExpCS returns [EObject current=null] : ( (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS ) ( (lv_multiplicity_2_0= ruleMultiplicityCS ) )? ) ;
    public final EObject ruleTypeExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_TypeNameExpCS_0 = null;

        EObject this_TypeLiteralCS_1 = null;

        EObject lv_multiplicity_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3232:28: ( ( (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS ) ( (lv_multiplicity_2_0= ruleMultiplicityCS ) )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3233:1: ( (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS ) ( (lv_multiplicity_2_0= ruleMultiplicityCS ) )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3233:1: ( (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS ) ( (lv_multiplicity_2_0= ruleMultiplicityCS ) )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3233:2: (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS ) ( (lv_multiplicity_2_0= ruleMultiplicityCS ) )?
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3233:2: (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS )
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( ((LA46_0>=RULE_SIMPLE_ID && LA46_0<=RULE_ESCAPED_ID)||(LA46_0>=21 && LA46_0<=22)||(LA46_0>=25 && LA46_0<=33)) ) {
                alt46=1;
            }
            else if ( ((LA46_0>=51 && LA46_0<=64)) ) {
                alt46=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }
            switch (alt46) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3234:2: this_TypeNameExpCS_0= ruleTypeNameExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeExpCSAccess().getTypeNameExpCSParserRuleCall_0_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeNameExpCS_in_ruleTypeExpCS7860);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3247:2: this_TypeLiteralCS_1= ruleTypeLiteralCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeExpCSAccess().getTypeLiteralCSParserRuleCall_0_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralCS_in_ruleTypeExpCS7890);
                    this_TypeLiteralCS_1=ruleTypeLiteralCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_TypeLiteralCS_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3258:2: ( (lv_multiplicity_2_0= ruleMultiplicityCS ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==68) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3259:1: (lv_multiplicity_2_0= ruleMultiplicityCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3259:1: (lv_multiplicity_2_0= ruleMultiplicityCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3260:3: lv_multiplicity_2_0= ruleMultiplicityCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeExpCSAccess().getMultiplicityMultiplicityCSParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMultiplicityCS_in_ruleTypeExpCS7911);
                    lv_multiplicity_2_0=ruleMultiplicityCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTypeExpCSRule());
                      	        }
                             		set(
                             			current, 
                             			"multiplicity",
                              		lv_multiplicity_2_0, 
                              		"MultiplicityCS");
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3284:1: entryRuleExpCS returns [EObject current=null] : iv_ruleExpCS= ruleExpCS EOF ;
    public final EObject entryRuleExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3285:2: (iv_ruleExpCS= ruleExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3286:2: iv_ruleExpCS= ruleExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_entryRuleExpCS7948);
            iv_ruleExpCS=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleExpCS7958); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3293:1: ruleExpCS returns [EObject current=null] : ( (this_PrefixedExpCS_0= rulePrefixedExpCS ( () ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? ) | ( (lv_ownedExpression_8_0= ruleLetExpCS ) ) ) )? ) | ( () ( (lv_ownedOperator_10_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_11_0= ruleLetExpCS ) ) ) | this_LetExpCS_12= ruleLetExpCS ) ;
    public final EObject ruleExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_PrefixedExpCS_0 = null;

        EObject lv_ownedOperator_2_0 = null;

        EObject lv_ownedExpression_3_0 = null;

        EObject lv_ownedOperator_4_0 = null;

        EObject lv_ownedExpression_5_0 = null;

        EObject lv_ownedOperator_6_0 = null;

        EObject lv_ownedExpression_7_0 = null;

        EObject lv_ownedExpression_8_0 = null;

        EObject lv_ownedOperator_10_0 = null;

        EObject lv_ownedExpression_11_0 = null;

        EObject this_LetExpCS_12 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3296:28: ( ( (this_PrefixedExpCS_0= rulePrefixedExpCS ( () ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? ) | ( (lv_ownedExpression_8_0= ruleLetExpCS ) ) ) )? ) | ( () ( (lv_ownedOperator_10_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_11_0= ruleLetExpCS ) ) ) | this_LetExpCS_12= ruleLetExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3297:1: ( (this_PrefixedExpCS_0= rulePrefixedExpCS ( () ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? ) | ( (lv_ownedExpression_8_0= ruleLetExpCS ) ) ) )? ) | ( () ( (lv_ownedOperator_10_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_11_0= ruleLetExpCS ) ) ) | this_LetExpCS_12= ruleLetExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3297:1: ( (this_PrefixedExpCS_0= rulePrefixedExpCS ( () ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? ) | ( (lv_ownedExpression_8_0= ruleLetExpCS ) ) ) )? ) | ( () ( (lv_ownedOperator_10_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_11_0= ruleLetExpCS ) ) ) | this_LetExpCS_12= ruleLetExpCS )
            int alt53=3;
            alt53 = dfa53.predict(input);
            switch (alt53) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3297:2: (this_PrefixedExpCS_0= rulePrefixedExpCS ( () ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? ) | ( (lv_ownedExpression_8_0= ruleLetExpCS ) ) ) )? )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3297:2: (this_PrefixedExpCS_0= rulePrefixedExpCS ( () ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? ) | ( (lv_ownedExpression_8_0= ruleLetExpCS ) ) ) )? )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3298:2: this_PrefixedExpCS_0= rulePrefixedExpCS ( () ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? ) | ( (lv_ownedExpression_8_0= ruleLetExpCS ) ) ) )?
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getExpCSAccess().getPrefixedExpCSParserRuleCall_0_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrefixedExpCS_in_ruleExpCS8009);
                    this_PrefixedExpCS_0=rulePrefixedExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_PrefixedExpCS_0; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3309:1: ( () ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? ) | ( (lv_ownedExpression_8_0= ruleLetExpCS ) ) ) )?
                    int alt51=2;
                    int LA51_0 = input.LA(1);

                    if ( ((LA51_0>=34 && LA51_0<=35)||(LA51_0>=37 && LA51_0<=50)) ) {
                        alt51=1;
                    }
                    switch (alt51) {
                        case 1 :
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3309:2: () ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? ) | ( (lv_ownedExpression_8_0= ruleLetExpCS ) ) )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3309:2: ()
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3310:2: 
                            {
                            if ( state.backtracking==0 ) {
                               
                              	  /* */ 
                              	
                            }
                            if ( state.backtracking==0 ) {

                                      current = forceCreateModelElementAndAdd(
                                          grammarAccess.getExpCSAccess().getInfixExpCSOwnedExpressionAction_0_1_0(),
                                          current);
                                  
                            }

                            }

                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3318:2: ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3319:1: (lv_ownedOperator_2_0= ruleBinaryOperatorCS )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3319:1: (lv_ownedOperator_2_0= ruleBinaryOperatorCS )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3320:3: lv_ownedOperator_2_0= ruleBinaryOperatorCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getExpCSAccess().getOwnedOperatorBinaryOperatorCSParserRuleCall_0_1_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleBinaryOperatorCS_in_ruleExpCS8042);
                            lv_ownedOperator_2_0=ruleBinaryOperatorCS();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getExpCSRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"ownedOperator",
                                      		lv_ownedOperator_2_0, 
                                      		"BinaryOperatorCS");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3336:2: ( ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? ) | ( (lv_ownedExpression_8_0= ruleLetExpCS ) ) )
                            int alt50=2;
                            int LA50_0 = input.LA(1);

                            if ( ((LA50_0>=RULE_SIMPLE_ID && LA50_0<=RULE_SINGLE_QUOTED_STRING)||(LA50_0>=21 && LA50_0<=22)||(LA50_0>=25 && LA50_0<=36)||(LA50_0>=51 && LA50_0<=65)||(LA50_0>=73 && LA50_0<=76)||LA50_0==79||LA50_0==85) ) {
                                alt50=1;
                            }
                            else if ( (LA50_0==83) ) {
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
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3336:3: ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? )
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3336:3: ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3336:4: ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )?
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3336:4: ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3337:1: (lv_ownedExpression_3_0= rulePrefixedExpCS )
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3337:1: (lv_ownedExpression_3_0= rulePrefixedExpCS )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3338:3: lv_ownedExpression_3_0= rulePrefixedExpCS
                                    {
                                    if ( state.backtracking==0 ) {
                                       
                                      	        newCompositeNode(grammarAccess.getExpCSAccess().getOwnedExpressionPrefixedExpCSParserRuleCall_0_1_2_0_0_0()); 
                                      	    
                                    }
                                    pushFollow(FollowSets000.FOLLOW_rulePrefixedExpCS_in_ruleExpCS8065);
                                    lv_ownedExpression_3_0=rulePrefixedExpCS();

                                    state._fsp--;
                                    if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      	        if (current==null) {
                                      	            current = createModelElementForParent(grammarAccess.getExpCSRule());
                                      	        }
                                             		add(
                                             			current, 
                                             			"ownedExpression",
                                              		lv_ownedExpression_3_0, 
                                              		"PrefixedExpCS");
                                      	        afterParserOrEnumRuleCall();
                                      	    
                                    }

                                    }


                                    }

                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3354:2: ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )*
                                    loop48:
                                    do {
                                        int alt48=2;
                                        alt48 = dfa48.predict(input);
                                        switch (alt48) {
                                    	case 1 :
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3354:3: ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) )
                                    	    {
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3354:3: ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) )
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3355:1: (lv_ownedOperator_4_0= ruleBinaryOperatorCS )
                                    	    {
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3355:1: (lv_ownedOperator_4_0= ruleBinaryOperatorCS )
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3356:3: lv_ownedOperator_4_0= ruleBinaryOperatorCS
                                    	    {
                                    	    if ( state.backtracking==0 ) {
                                    	       
                                    	      	        newCompositeNode(grammarAccess.getExpCSAccess().getOwnedOperatorBinaryOperatorCSParserRuleCall_0_1_2_0_1_0_0()); 
                                    	      	    
                                    	    }
                                    	    pushFollow(FollowSets000.FOLLOW_ruleBinaryOperatorCS_in_ruleExpCS8087);
                                    	    lv_ownedOperator_4_0=ruleBinaryOperatorCS();

                                    	    state._fsp--;
                                    	    if (state.failed) return current;
                                    	    if ( state.backtracking==0 ) {

                                    	      	        if (current==null) {
                                    	      	            current = createModelElementForParent(grammarAccess.getExpCSRule());
                                    	      	        }
                                    	             		add(
                                    	             			current, 
                                    	             			"ownedOperator",
                                    	              		lv_ownedOperator_4_0, 
                                    	              		"BinaryOperatorCS");
                                    	      	        afterParserOrEnumRuleCall();
                                    	      	    
                                    	    }

                                    	    }


                                    	    }

                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3372:2: ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) )
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3373:1: (lv_ownedExpression_5_0= rulePrefixedExpCS )
                                    	    {
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3373:1: (lv_ownedExpression_5_0= rulePrefixedExpCS )
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3374:3: lv_ownedExpression_5_0= rulePrefixedExpCS
                                    	    {
                                    	    if ( state.backtracking==0 ) {
                                    	       
                                    	      	        newCompositeNode(grammarAccess.getExpCSAccess().getOwnedExpressionPrefixedExpCSParserRuleCall_0_1_2_0_1_1_0()); 
                                    	      	    
                                    	    }
                                    	    pushFollow(FollowSets000.FOLLOW_rulePrefixedExpCS_in_ruleExpCS8108);
                                    	    lv_ownedExpression_5_0=rulePrefixedExpCS();

                                    	    state._fsp--;
                                    	    if (state.failed) return current;
                                    	    if ( state.backtracking==0 ) {

                                    	      	        if (current==null) {
                                    	      	            current = createModelElementForParent(grammarAccess.getExpCSRule());
                                    	      	        }
                                    	             		add(
                                    	             			current, 
                                    	             			"ownedExpression",
                                    	              		lv_ownedExpression_5_0, 
                                    	              		"PrefixedExpCS");
                                    	      	        afterParserOrEnumRuleCall();
                                    	      	    
                                    	    }

                                    	    }


                                    	    }


                                    	    }
                                    	    break;

                                    	default :
                                    	    break loop48;
                                        }
                                    } while (true);

                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3390:4: ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )?
                                    int alt49=2;
                                    int LA49_0 = input.LA(1);

                                    if ( ((LA49_0>=34 && LA49_0<=35)||(LA49_0>=37 && LA49_0<=50)) ) {
                                        alt49=1;
                                    }
                                    switch (alt49) {
                                        case 1 :
                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3390:5: ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) )
                                            {
                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3390:5: ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) )
                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3391:1: (lv_ownedOperator_6_0= ruleBinaryOperatorCS )
                                            {
                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3391:1: (lv_ownedOperator_6_0= ruleBinaryOperatorCS )
                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3392:3: lv_ownedOperator_6_0= ruleBinaryOperatorCS
                                            {
                                            if ( state.backtracking==0 ) {
                                               
                                              	        newCompositeNode(grammarAccess.getExpCSAccess().getOwnedOperatorBinaryOperatorCSParserRuleCall_0_1_2_0_2_0_0()); 
                                              	    
                                            }
                                            pushFollow(FollowSets000.FOLLOW_ruleBinaryOperatorCS_in_ruleExpCS8132);
                                            lv_ownedOperator_6_0=ruleBinaryOperatorCS();

                                            state._fsp--;
                                            if (state.failed) return current;
                                            if ( state.backtracking==0 ) {

                                              	        if (current==null) {
                                              	            current = createModelElementForParent(grammarAccess.getExpCSRule());
                                              	        }
                                                     		add(
                                                     			current, 
                                                     			"ownedOperator",
                                                      		lv_ownedOperator_6_0, 
                                                      		"BinaryOperatorCS");
                                              	        afterParserOrEnumRuleCall();
                                              	    
                                            }

                                            }


                                            }

                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3408:2: ( (lv_ownedExpression_7_0= ruleLetExpCS ) )
                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3409:1: (lv_ownedExpression_7_0= ruleLetExpCS )
                                            {
                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3409:1: (lv_ownedExpression_7_0= ruleLetExpCS )
                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3410:3: lv_ownedExpression_7_0= ruleLetExpCS
                                            {
                                            if ( state.backtracking==0 ) {
                                               
                                              	        newCompositeNode(grammarAccess.getExpCSAccess().getOwnedExpressionLetExpCSParserRuleCall_0_1_2_0_2_1_0()); 
                                              	    
                                            }
                                            pushFollow(FollowSets000.FOLLOW_ruleLetExpCS_in_ruleExpCS8153);
                                            lv_ownedExpression_7_0=ruleLetExpCS();

                                            state._fsp--;
                                            if (state.failed) return current;
                                            if ( state.backtracking==0 ) {

                                              	        if (current==null) {
                                              	            current = createModelElementForParent(grammarAccess.getExpCSRule());
                                              	        }
                                                     		add(
                                                     			current, 
                                                     			"ownedExpression",
                                                      		lv_ownedExpression_7_0, 
                                                      		"LetExpCS");
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
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3427:6: ( (lv_ownedExpression_8_0= ruleLetExpCS ) )
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3427:6: ( (lv_ownedExpression_8_0= ruleLetExpCS ) )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3428:1: (lv_ownedExpression_8_0= ruleLetExpCS )
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3428:1: (lv_ownedExpression_8_0= ruleLetExpCS )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3429:3: lv_ownedExpression_8_0= ruleLetExpCS
                                    {
                                    if ( state.backtracking==0 ) {
                                       
                                      	        newCompositeNode(grammarAccess.getExpCSAccess().getOwnedExpressionLetExpCSParserRuleCall_0_1_2_1_0()); 
                                      	    
                                    }
                                    pushFollow(FollowSets000.FOLLOW_ruleLetExpCS_in_ruleExpCS8183);
                                    lv_ownedExpression_8_0=ruleLetExpCS();

                                    state._fsp--;
                                    if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      	        if (current==null) {
                                      	            current = createModelElementForParent(grammarAccess.getExpCSRule());
                                      	        }
                                             		add(
                                             			current, 
                                             			"ownedExpression",
                                              		lv_ownedExpression_8_0, 
                                              		"LetExpCS");
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
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3446:6: ( () ( (lv_ownedOperator_10_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_11_0= ruleLetExpCS ) ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3446:6: ( () ( (lv_ownedOperator_10_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_11_0= ruleLetExpCS ) ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3446:7: () ( (lv_ownedOperator_10_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_11_0= ruleLetExpCS ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3446:7: ()
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3447:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getExpCSAccess().getPrefixExpCSAction_1_0(),
                                  current);
                          
                    }

                    }

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3455:2: ( (lv_ownedOperator_10_0= ruleUnaryOperatorCS ) )+
                    int cnt52=0;
                    loop52:
                    do {
                        int alt52=2;
                        int LA52_0 = input.LA(1);

                        if ( ((LA52_0>=35 && LA52_0<=36)) ) {
                            alt52=1;
                        }


                        switch (alt52) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3456:1: (lv_ownedOperator_10_0= ruleUnaryOperatorCS )
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3456:1: (lv_ownedOperator_10_0= ruleUnaryOperatorCS )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3457:3: lv_ownedOperator_10_0= ruleUnaryOperatorCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getExpCSAccess().getOwnedOperatorUnaryOperatorCSParserRuleCall_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleUnaryOperatorCS_in_ruleExpCS8227);
                    	    lv_ownedOperator_10_0=ruleUnaryOperatorCS();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getExpCSRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"ownedOperator",
                    	              		lv_ownedOperator_10_0, 
                    	              		"UnaryOperatorCS");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt52 >= 1 ) break loop52;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(52, input);
                                throw eee;
                        }
                        cnt52++;
                    } while (true);

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3473:3: ( (lv_ownedExpression_11_0= ruleLetExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3474:1: (lv_ownedExpression_11_0= ruleLetExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3474:1: (lv_ownedExpression_11_0= ruleLetExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3475:3: lv_ownedExpression_11_0= ruleLetExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpCSAccess().getOwnedExpressionLetExpCSParserRuleCall_1_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLetExpCS_in_ruleExpCS8249);
                    lv_ownedExpression_11_0=ruleLetExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExpCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedExpression",
                              		lv_ownedExpression_11_0, 
                              		"LetExpCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3493:2: this_LetExpCS_12= ruleLetExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getExpCSAccess().getLetExpCSParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLetExpCS_in_ruleExpCS8281);
                    this_LetExpCS_12=ruleLetExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_LetExpCS_12; 
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


    // $ANTLR start "entryRuleBinaryOperatorCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3512:1: entryRuleBinaryOperatorCS returns [EObject current=null] : iv_ruleBinaryOperatorCS= ruleBinaryOperatorCS EOF ;
    public final EObject entryRuleBinaryOperatorCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinaryOperatorCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3513:2: (iv_ruleBinaryOperatorCS= ruleBinaryOperatorCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3514:2: iv_ruleBinaryOperatorCS= ruleBinaryOperatorCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBinaryOperatorCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleBinaryOperatorCS_in_entryRuleBinaryOperatorCS8316);
            iv_ruleBinaryOperatorCS=ruleBinaryOperatorCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBinaryOperatorCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBinaryOperatorCS8326); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBinaryOperatorCS"


    // $ANTLR start "ruleBinaryOperatorCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3521:1: ruleBinaryOperatorCS returns [EObject current=null] : (this_InfixOperatorCS_0= ruleInfixOperatorCS | this_NavigationOperatorCS_1= ruleNavigationOperatorCS ) ;
    public final EObject ruleBinaryOperatorCS() throws RecognitionException {
        EObject current = null;

        EObject this_InfixOperatorCS_0 = null;

        EObject this_NavigationOperatorCS_1 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3524:28: ( (this_InfixOperatorCS_0= ruleInfixOperatorCS | this_NavigationOperatorCS_1= ruleNavigationOperatorCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3525:1: (this_InfixOperatorCS_0= ruleInfixOperatorCS | this_NavigationOperatorCS_1= ruleNavigationOperatorCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3525:1: (this_InfixOperatorCS_0= ruleInfixOperatorCS | this_NavigationOperatorCS_1= ruleNavigationOperatorCS )
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( ((LA54_0>=34 && LA54_0<=35)||(LA54_0>=37 && LA54_0<=48)) ) {
                alt54=1;
            }
            else if ( ((LA54_0>=49 && LA54_0<=50)) ) {
                alt54=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 54, 0, input);

                throw nvae;
            }
            switch (alt54) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3526:2: this_InfixOperatorCS_0= ruleInfixOperatorCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBinaryOperatorCSAccess().getInfixOperatorCSParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleInfixOperatorCS_in_ruleBinaryOperatorCS8376);
                    this_InfixOperatorCS_0=ruleInfixOperatorCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_InfixOperatorCS_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3539:2: this_NavigationOperatorCS_1= ruleNavigationOperatorCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBinaryOperatorCSAccess().getNavigationOperatorCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNavigationOperatorCS_in_ruleBinaryOperatorCS8406);
                    this_NavigationOperatorCS_1=ruleNavigationOperatorCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_NavigationOperatorCS_1; 
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
    // $ANTLR end "ruleBinaryOperatorCS"


    // $ANTLR start "entryRuleInfixOperatorCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3558:1: entryRuleInfixOperatorCS returns [EObject current=null] : iv_ruleInfixOperatorCS= ruleInfixOperatorCS EOF ;
    public final EObject entryRuleInfixOperatorCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInfixOperatorCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3559:2: (iv_ruleInfixOperatorCS= ruleInfixOperatorCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3560:2: iv_ruleInfixOperatorCS= ruleInfixOperatorCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInfixOperatorCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleInfixOperatorCS_in_entryRuleInfixOperatorCS8441);
            iv_ruleInfixOperatorCS=ruleInfixOperatorCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInfixOperatorCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleInfixOperatorCS8451); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInfixOperatorCS"


    // $ANTLR start "ruleInfixOperatorCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3567:1: ruleInfixOperatorCS returns [EObject current=null] : ( (lv_name_0_0= ruleInfixOperator ) ) ;
    public final EObject ruleInfixOperatorCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3570:28: ( ( (lv_name_0_0= ruleInfixOperator ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3571:1: ( (lv_name_0_0= ruleInfixOperator ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3571:1: ( (lv_name_0_0= ruleInfixOperator ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3572:1: (lv_name_0_0= ruleInfixOperator )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3572:1: (lv_name_0_0= ruleInfixOperator )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3573:3: lv_name_0_0= ruleInfixOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getInfixOperatorCSAccess().getNameInfixOperatorParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleInfixOperator_in_ruleInfixOperatorCS8496);
            lv_name_0_0=ruleInfixOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getInfixOperatorCSRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"InfixOperator");
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
    // $ANTLR end "ruleInfixOperatorCS"


    // $ANTLR start "entryRuleNavigationOperatorCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3597:1: entryRuleNavigationOperatorCS returns [EObject current=null] : iv_ruleNavigationOperatorCS= ruleNavigationOperatorCS EOF ;
    public final EObject entryRuleNavigationOperatorCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigationOperatorCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3598:2: (iv_ruleNavigationOperatorCS= ruleNavigationOperatorCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3599:2: iv_ruleNavigationOperatorCS= ruleNavigationOperatorCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigationOperatorCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigationOperatorCS_in_entryRuleNavigationOperatorCS8531);
            iv_ruleNavigationOperatorCS=ruleNavigationOperatorCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigationOperatorCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigationOperatorCS8541); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNavigationOperatorCS"


    // $ANTLR start "ruleNavigationOperatorCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3606:1: ruleNavigationOperatorCS returns [EObject current=null] : ( (lv_name_0_0= ruleNavigationOperator ) ) ;
    public final EObject ruleNavigationOperatorCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3609:28: ( ( (lv_name_0_0= ruleNavigationOperator ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3610:1: ( (lv_name_0_0= ruleNavigationOperator ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3610:1: ( (lv_name_0_0= ruleNavigationOperator ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3611:1: (lv_name_0_0= ruleNavigationOperator )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3611:1: (lv_name_0_0= ruleNavigationOperator )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3612:3: lv_name_0_0= ruleNavigationOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNavigationOperatorCSAccess().getNameNavigationOperatorParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigationOperator_in_ruleNavigationOperatorCS8586);
            lv_name_0_0=ruleNavigationOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getNavigationOperatorCSRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"NavigationOperator");
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
    // $ANTLR end "ruleNavigationOperatorCS"


    // $ANTLR start "entryRulePrefixedExpCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3636:1: entryRulePrefixedExpCS returns [EObject current=null] : iv_rulePrefixedExpCS= rulePrefixedExpCS EOF ;
    public final EObject entryRulePrefixedExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrefixedExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3637:2: (iv_rulePrefixedExpCS= rulePrefixedExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3638:2: iv_rulePrefixedExpCS= rulePrefixedExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrefixedExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePrefixedExpCS_in_entryRulePrefixedExpCS8621);
            iv_rulePrefixedExpCS=rulePrefixedExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrefixedExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrefixedExpCS8631); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrefixedExpCS"


    // $ANTLR start "rulePrefixedExpCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3645:1: rulePrefixedExpCS returns [EObject current=null] : ( ( () ( (lv_ownedOperator_1_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_2_0= rulePrimaryExpCS ) ) ) | this_PrimaryExpCS_3= rulePrimaryExpCS ) ;
    public final EObject rulePrefixedExpCS() throws RecognitionException {
        EObject current = null;

        EObject lv_ownedOperator_1_0 = null;

        EObject lv_ownedExpression_2_0 = null;

        EObject this_PrimaryExpCS_3 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3648:28: ( ( ( () ( (lv_ownedOperator_1_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_2_0= rulePrimaryExpCS ) ) ) | this_PrimaryExpCS_3= rulePrimaryExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3649:1: ( ( () ( (lv_ownedOperator_1_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_2_0= rulePrimaryExpCS ) ) ) | this_PrimaryExpCS_3= rulePrimaryExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3649:1: ( ( () ( (lv_ownedOperator_1_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_2_0= rulePrimaryExpCS ) ) ) | this_PrimaryExpCS_3= rulePrimaryExpCS )
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( ((LA56_0>=35 && LA56_0<=36)) ) {
                alt56=1;
            }
            else if ( ((LA56_0>=RULE_SIMPLE_ID && LA56_0<=RULE_SINGLE_QUOTED_STRING)||(LA56_0>=21 && LA56_0<=22)||(LA56_0>=25 && LA56_0<=34)||(LA56_0>=51 && LA56_0<=65)||(LA56_0>=73 && LA56_0<=76)||LA56_0==79||LA56_0==85) ) {
                alt56=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;
            }
            switch (alt56) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3649:2: ( () ( (lv_ownedOperator_1_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_2_0= rulePrimaryExpCS ) ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3649:2: ( () ( (lv_ownedOperator_1_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_2_0= rulePrimaryExpCS ) ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3649:3: () ( (lv_ownedOperator_1_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_2_0= rulePrimaryExpCS ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3649:3: ()
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3650:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getPrefixedExpCSAccess().getPrefixExpCSAction_0_0(),
                                  current);
                          
                    }

                    }

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3658:2: ( (lv_ownedOperator_1_0= ruleUnaryOperatorCS ) )+
                    int cnt55=0;
                    loop55:
                    do {
                        int alt55=2;
                        int LA55_0 = input.LA(1);

                        if ( ((LA55_0>=35 && LA55_0<=36)) ) {
                            alt55=1;
                        }


                        switch (alt55) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3659:1: (lv_ownedOperator_1_0= ruleUnaryOperatorCS )
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3659:1: (lv_ownedOperator_1_0= ruleUnaryOperatorCS )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3660:3: lv_ownedOperator_1_0= ruleUnaryOperatorCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getPrefixedExpCSAccess().getOwnedOperatorUnaryOperatorCSParserRuleCall_0_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleUnaryOperatorCS_in_rulePrefixedExpCS8690);
                    	    lv_ownedOperator_1_0=ruleUnaryOperatorCS();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getPrefixedExpCSRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"ownedOperator",
                    	              		lv_ownedOperator_1_0, 
                    	              		"UnaryOperatorCS");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt55 >= 1 ) break loop55;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(55, input);
                                throw eee;
                        }
                        cnt55++;
                    } while (true);

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3676:3: ( (lv_ownedExpression_2_0= rulePrimaryExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3677:1: (lv_ownedExpression_2_0= rulePrimaryExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3677:1: (lv_ownedExpression_2_0= rulePrimaryExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3678:3: lv_ownedExpression_2_0= rulePrimaryExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrefixedExpCSAccess().getOwnedExpressionPrimaryExpCSParserRuleCall_0_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrimaryExpCS_in_rulePrefixedExpCS8712);
                    lv_ownedExpression_2_0=rulePrimaryExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPrefixedExpCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedExpression",
                              		lv_ownedExpression_2_0, 
                              		"PrimaryExpCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3696:2: this_PrimaryExpCS_3= rulePrimaryExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrefixedExpCSAccess().getPrimaryExpCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrimaryExpCS_in_rulePrefixedExpCS8744);
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
    // $ANTLR end "rulePrefixedExpCS"


    // $ANTLR start "entryRuleUnaryOperatorCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3715:1: entryRuleUnaryOperatorCS returns [EObject current=null] : iv_ruleUnaryOperatorCS= ruleUnaryOperatorCS EOF ;
    public final EObject entryRuleUnaryOperatorCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryOperatorCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3716:2: (iv_ruleUnaryOperatorCS= ruleUnaryOperatorCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3717:2: iv_ruleUnaryOperatorCS= ruleUnaryOperatorCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryOperatorCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnaryOperatorCS_in_entryRuleUnaryOperatorCS8779);
            iv_ruleUnaryOperatorCS=ruleUnaryOperatorCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnaryOperatorCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnaryOperatorCS8789); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnaryOperatorCS"


    // $ANTLR start "ruleUnaryOperatorCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3724:1: ruleUnaryOperatorCS returns [EObject current=null] : ( (lv_name_0_0= rulePrefixOperator ) ) ;
    public final EObject ruleUnaryOperatorCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3727:28: ( ( (lv_name_0_0= rulePrefixOperator ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3728:1: ( (lv_name_0_0= rulePrefixOperator ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3728:1: ( (lv_name_0_0= rulePrefixOperator ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3729:1: (lv_name_0_0= rulePrefixOperator )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3729:1: (lv_name_0_0= rulePrefixOperator )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3730:3: lv_name_0_0= rulePrefixOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getUnaryOperatorCSAccess().getNamePrefixOperatorParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_rulePrefixOperator_in_ruleUnaryOperatorCS8834);
            lv_name_0_0=rulePrefixOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getUnaryOperatorCSRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"PrefixOperator");
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
    // $ANTLR end "ruleUnaryOperatorCS"


    // $ANTLR start "entryRulePrimaryExpCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3754:1: entryRulePrimaryExpCS returns [EObject current=null] : iv_rulePrimaryExpCS= rulePrimaryExpCS EOF ;
    public final EObject entryRulePrimaryExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3755:2: (iv_rulePrimaryExpCS= rulePrimaryExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3756:2: iv_rulePrimaryExpCS= rulePrimaryExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimaryExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePrimaryExpCS_in_entryRulePrimaryExpCS8869);
            iv_rulePrimaryExpCS=rulePrimaryExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimaryExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrimaryExpCS8879); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3763:1: rulePrimaryExpCS returns [EObject current=null] : (this_NestedExpCS_0= ruleNestedExpCS | this_IfExpCS_1= ruleIfExpCS | this_SelfExpCS_2= ruleSelfExpCS | this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS | this_CollectionLiteralExpCS_5= ruleCollectionLiteralExpCS | this_TypeLiteralExpCS_6= ruleTypeLiteralExpCS | ( () ( (lv_pathName_8_0= rulePathNameCS ) ) ( ( () otherlv_10= '[' ( (lv_firstIndexes_11_0= ruleExpCS ) ) (otherlv_12= ',' ( (lv_firstIndexes_13_0= ruleExpCS ) ) )* otherlv_14= ']' (otherlv_15= '[' ( (lv_secondIndexes_16_0= ruleExpCS ) ) (otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) ) )* otherlv_19= ']' )? ( ( (lv_atPre_20_0= '@' ) ) otherlv_21= 'pre' )? ) | ( () otherlv_23= '{' ( ( ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )* ) | ( (lv_value_27_0= ruleStringLiteral ) ) ) otherlv_28= '}' ) | ( ( ( (lv_atPre_29_0= '@' ) ) otherlv_30= 'pre' )? ( () otherlv_32= '(' ( ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_39= ')' )? ) ) ) ) ;
    public final EObject rulePrimaryExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        Token lv_atPre_20_0=null;
        Token otherlv_21=null;
        Token otherlv_23=null;
        Token otherlv_25=null;
        Token otherlv_28=null;
        Token lv_atPre_29_0=null;
        Token otherlv_30=null;
        Token otherlv_32=null;
        Token otherlv_39=null;
        EObject this_NestedExpCS_0 = null;

        EObject this_IfExpCS_1 = null;

        EObject this_SelfExpCS_2 = null;

        EObject this_PrimitiveLiteralExpCS_3 = null;

        EObject this_TupleLiteralExpCS_4 = null;

        EObject this_CollectionLiteralExpCS_5 = null;

        EObject this_TypeLiteralExpCS_6 = null;

        EObject lv_pathName_8_0 = null;

        EObject lv_firstIndexes_11_0 = null;

        EObject lv_firstIndexes_13_0 = null;

        EObject lv_secondIndexes_16_0 = null;

        EObject lv_secondIndexes_18_0 = null;

        EObject lv_ownedParts_24_0 = null;

        EObject lv_ownedParts_26_0 = null;

        AntlrDatatypeRuleToken lv_value_27_0 = null;

        EObject lv_argument_33_0 = null;

        EObject lv_argument_34_0 = null;

        EObject lv_argument_35_0 = null;

        EObject lv_argument_36_0 = null;

        EObject lv_argument_37_0 = null;

        EObject lv_argument_38_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3766:28: ( (this_NestedExpCS_0= ruleNestedExpCS | this_IfExpCS_1= ruleIfExpCS | this_SelfExpCS_2= ruleSelfExpCS | this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS | this_CollectionLiteralExpCS_5= ruleCollectionLiteralExpCS | this_TypeLiteralExpCS_6= ruleTypeLiteralExpCS | ( () ( (lv_pathName_8_0= rulePathNameCS ) ) ( ( () otherlv_10= '[' ( (lv_firstIndexes_11_0= ruleExpCS ) ) (otherlv_12= ',' ( (lv_firstIndexes_13_0= ruleExpCS ) ) )* otherlv_14= ']' (otherlv_15= '[' ( (lv_secondIndexes_16_0= ruleExpCS ) ) (otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) ) )* otherlv_19= ']' )? ( ( (lv_atPre_20_0= '@' ) ) otherlv_21= 'pre' )? ) | ( () otherlv_23= '{' ( ( ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )* ) | ( (lv_value_27_0= ruleStringLiteral ) ) ) otherlv_28= '}' ) | ( ( ( (lv_atPre_29_0= '@' ) ) otherlv_30= 'pre' )? ( () otherlv_32= '(' ( ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_39= ')' )? ) ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3767:1: (this_NestedExpCS_0= ruleNestedExpCS | this_IfExpCS_1= ruleIfExpCS | this_SelfExpCS_2= ruleSelfExpCS | this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS | this_CollectionLiteralExpCS_5= ruleCollectionLiteralExpCS | this_TypeLiteralExpCS_6= ruleTypeLiteralExpCS | ( () ( (lv_pathName_8_0= rulePathNameCS ) ) ( ( () otherlv_10= '[' ( (lv_firstIndexes_11_0= ruleExpCS ) ) (otherlv_12= ',' ( (lv_firstIndexes_13_0= ruleExpCS ) ) )* otherlv_14= ']' (otherlv_15= '[' ( (lv_secondIndexes_16_0= ruleExpCS ) ) (otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) ) )* otherlv_19= ']' )? ( ( (lv_atPre_20_0= '@' ) ) otherlv_21= 'pre' )? ) | ( () otherlv_23= '{' ( ( ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )* ) | ( (lv_value_27_0= ruleStringLiteral ) ) ) otherlv_28= '}' ) | ( ( ( (lv_atPre_29_0= '@' ) ) otherlv_30= 'pre' )? ( () otherlv_32= '(' ( ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_39= ')' )? ) ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3767:1: (this_NestedExpCS_0= ruleNestedExpCS | this_IfExpCS_1= ruleIfExpCS | this_SelfExpCS_2= ruleSelfExpCS | this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS | this_CollectionLiteralExpCS_5= ruleCollectionLiteralExpCS | this_TypeLiteralExpCS_6= ruleTypeLiteralExpCS | ( () ( (lv_pathName_8_0= rulePathNameCS ) ) ( ( () otherlv_10= '[' ( (lv_firstIndexes_11_0= ruleExpCS ) ) (otherlv_12= ',' ( (lv_firstIndexes_13_0= ruleExpCS ) ) )* otherlv_14= ']' (otherlv_15= '[' ( (lv_secondIndexes_16_0= ruleExpCS ) ) (otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) ) )* otherlv_19= ']' )? ( ( (lv_atPre_20_0= '@' ) ) otherlv_21= 'pre' )? ) | ( () otherlv_23= '{' ( ( ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )* ) | ( (lv_value_27_0= ruleStringLiteral ) ) ) otherlv_28= '}' ) | ( ( ( (lv_atPre_29_0= '@' ) ) otherlv_30= 'pre' )? ( () otherlv_32= '(' ( ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_39= ')' )? ) ) ) )
            int alt72=8;
            alt72 = dfa72.predict(input);
            switch (alt72) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3768:2: this_NestedExpCS_0= ruleNestedExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getNestedExpCSParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNestedExpCS_in_rulePrimaryExpCS8929);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3781:2: this_IfExpCS_1= ruleIfExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getIfExpCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleIfExpCS_in_rulePrimaryExpCS8959);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3794:2: this_SelfExpCS_2= ruleSelfExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getSelfExpCSParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSelfExpCS_in_rulePrimaryExpCS8989);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3807:2: this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getPrimitiveLiteralExpCSParserRuleCall_3()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrimitiveLiteralExpCS_in_rulePrimaryExpCS9019);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3820:2: this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getTupleLiteralExpCSParserRuleCall_4()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralExpCS_in_rulePrimaryExpCS9049);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3833:2: this_CollectionLiteralExpCS_5= ruleCollectionLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getCollectionLiteralExpCSParserRuleCall_5()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteralExpCS_in_rulePrimaryExpCS9079);
                    this_CollectionLiteralExpCS_5=ruleCollectionLiteralExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_CollectionLiteralExpCS_5; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 7 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3846:2: this_TypeLiteralExpCS_6= ruleTypeLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getTypeLiteralExpCSParserRuleCall_6()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralExpCS_in_rulePrimaryExpCS9109);
                    this_TypeLiteralExpCS_6=ruleTypeLiteralExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_TypeLiteralExpCS_6; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 8 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3858:6: ( () ( (lv_pathName_8_0= rulePathNameCS ) ) ( ( () otherlv_10= '[' ( (lv_firstIndexes_11_0= ruleExpCS ) ) (otherlv_12= ',' ( (lv_firstIndexes_13_0= ruleExpCS ) ) )* otherlv_14= ']' (otherlv_15= '[' ( (lv_secondIndexes_16_0= ruleExpCS ) ) (otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) ) )* otherlv_19= ']' )? ( ( (lv_atPre_20_0= '@' ) ) otherlv_21= 'pre' )? ) | ( () otherlv_23= '{' ( ( ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )* ) | ( (lv_value_27_0= ruleStringLiteral ) ) ) otherlv_28= '}' ) | ( ( ( (lv_atPre_29_0= '@' ) ) otherlv_30= 'pre' )? ( () otherlv_32= '(' ( ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_39= ')' )? ) ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3858:6: ( () ( (lv_pathName_8_0= rulePathNameCS ) ) ( ( () otherlv_10= '[' ( (lv_firstIndexes_11_0= ruleExpCS ) ) (otherlv_12= ',' ( (lv_firstIndexes_13_0= ruleExpCS ) ) )* otherlv_14= ']' (otherlv_15= '[' ( (lv_secondIndexes_16_0= ruleExpCS ) ) (otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) ) )* otherlv_19= ']' )? ( ( (lv_atPre_20_0= '@' ) ) otherlv_21= 'pre' )? ) | ( () otherlv_23= '{' ( ( ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )* ) | ( (lv_value_27_0= ruleStringLiteral ) ) ) otherlv_28= '}' ) | ( ( ( (lv_atPre_29_0= '@' ) ) otherlv_30= 'pre' )? ( () otherlv_32= '(' ( ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_39= ')' )? ) ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3858:7: () ( (lv_pathName_8_0= rulePathNameCS ) ) ( ( () otherlv_10= '[' ( (lv_firstIndexes_11_0= ruleExpCS ) ) (otherlv_12= ',' ( (lv_firstIndexes_13_0= ruleExpCS ) ) )* otherlv_14= ']' (otherlv_15= '[' ( (lv_secondIndexes_16_0= ruleExpCS ) ) (otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) ) )* otherlv_19= ']' )? ( ( (lv_atPre_20_0= '@' ) ) otherlv_21= 'pre' )? ) | ( () otherlv_23= '{' ( ( ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )* ) | ( (lv_value_27_0= ruleStringLiteral ) ) ) otherlv_28= '}' ) | ( ( ( (lv_atPre_29_0= '@' ) ) otherlv_30= 'pre' )? ( () otherlv_32= '(' ( ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_39= ')' )? ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3858:7: ()
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3859:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getPrimaryExpCSAccess().getNameExpCSAction_7_0(),
                                  current);
                          
                    }

                    }

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3867:2: ( (lv_pathName_8_0= rulePathNameCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3868:1: (lv_pathName_8_0= rulePathNameCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3868:1: (lv_pathName_8_0= rulePathNameCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3869:3: lv_pathName_8_0= rulePathNameCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getPathNamePathNameCSParserRuleCall_7_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePathNameCS_in_rulePrimaryExpCS9148);
                    lv_pathName_8_0=rulePathNameCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPrimaryExpCSRule());
                      	        }
                             		set(
                             			current, 
                             			"pathName",
                              		lv_pathName_8_0, 
                              		"PathNameCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3885:2: ( ( () otherlv_10= '[' ( (lv_firstIndexes_11_0= ruleExpCS ) ) (otherlv_12= ',' ( (lv_firstIndexes_13_0= ruleExpCS ) ) )* otherlv_14= ']' (otherlv_15= '[' ( (lv_secondIndexes_16_0= ruleExpCS ) ) (otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) ) )* otherlv_19= ']' )? ( ( (lv_atPre_20_0= '@' ) ) otherlv_21= 'pre' )? ) | ( () otherlv_23= '{' ( ( ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )* ) | ( (lv_value_27_0= ruleStringLiteral ) ) ) otherlv_28= '}' ) | ( ( ( (lv_atPre_29_0= '@' ) ) otherlv_30= 'pre' )? ( () otherlv_32= '(' ( ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_39= ')' )? ) )
                    int alt71=3;
                    switch ( input.LA(1) ) {
                    case 68:
                        {
                        alt71=1;
                        }
                        break;
                    case 71:
                        {
                        alt71=2;
                        }
                        break;
                    case EOF:
                    case 16:
                    case 17:
                    case 19:
                    case 20:
                    case 23:
                    case 34:
                    case 35:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                    case 50:
                    case 65:
                    case 66:
                    case 67:
                    case 69:
                    case 72:
                    case 77:
                    case 80:
                    case 81:
                    case 82:
                    case 84:
                        {
                        alt71=3;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 71, 0, input);

                        throw nvae;
                    }

                    switch (alt71) {
                        case 1 :
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3885:3: ( () otherlv_10= '[' ( (lv_firstIndexes_11_0= ruleExpCS ) ) (otherlv_12= ',' ( (lv_firstIndexes_13_0= ruleExpCS ) ) )* otherlv_14= ']' (otherlv_15= '[' ( (lv_secondIndexes_16_0= ruleExpCS ) ) (otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) ) )* otherlv_19= ']' )? ( ( (lv_atPre_20_0= '@' ) ) otherlv_21= 'pre' )? )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3885:3: ( () otherlv_10= '[' ( (lv_firstIndexes_11_0= ruleExpCS ) ) (otherlv_12= ',' ( (lv_firstIndexes_13_0= ruleExpCS ) ) )* otherlv_14= ']' (otherlv_15= '[' ( (lv_secondIndexes_16_0= ruleExpCS ) ) (otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) ) )* otherlv_19= ']' )? ( ( (lv_atPre_20_0= '@' ) ) otherlv_21= 'pre' )? )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3885:4: () otherlv_10= '[' ( (lv_firstIndexes_11_0= ruleExpCS ) ) (otherlv_12= ',' ( (lv_firstIndexes_13_0= ruleExpCS ) ) )* otherlv_14= ']' (otherlv_15= '[' ( (lv_secondIndexes_16_0= ruleExpCS ) ) (otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) ) )* otherlv_19= ']' )? ( ( (lv_atPre_20_0= '@' ) ) otherlv_21= 'pre' )?
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3885:4: ()
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3886:2: 
                            {
                            if ( state.backtracking==0 ) {
                               
                              	  /* */ 
                              	
                            }
                            if ( state.backtracking==0 ) {

                                      current = forceCreateModelElementAndSet(
                                          grammarAccess.getPrimaryExpCSAccess().getIndexExpCSNameExpAction_7_2_0_0(),
                                          current);
                                  
                            }

                            }

                            otherlv_10=(Token)match(input,68,FollowSets000.FOLLOW_68_in_rulePrimaryExpCS9174); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_10, grammarAccess.getPrimaryExpCSAccess().getLeftSquareBracketKeyword_7_2_0_1());
                                  
                            }
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3898:1: ( (lv_firstIndexes_11_0= ruleExpCS ) )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3899:1: (lv_firstIndexes_11_0= ruleExpCS )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3899:1: (lv_firstIndexes_11_0= ruleExpCS )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3900:3: lv_firstIndexes_11_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getFirstIndexesExpCSParserRuleCall_7_2_0_2_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_rulePrimaryExpCS9195);
                            lv_firstIndexes_11_0=ruleExpCS();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getPrimaryExpCSRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"firstIndexes",
                                      		lv_firstIndexes_11_0, 
                                      		"ExpCS");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3916:2: (otherlv_12= ',' ( (lv_firstIndexes_13_0= ruleExpCS ) ) )*
                            loop57:
                            do {
                                int alt57=2;
                                int LA57_0 = input.LA(1);

                                if ( (LA57_0==16) ) {
                                    alt57=1;
                                }


                                switch (alt57) {
                            	case 1 :
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3916:4: otherlv_12= ',' ( (lv_firstIndexes_13_0= ruleExpCS ) )
                            	    {
                            	    otherlv_12=(Token)match(input,16,FollowSets000.FOLLOW_16_in_rulePrimaryExpCS9208); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_12, grammarAccess.getPrimaryExpCSAccess().getCommaKeyword_7_2_0_3_0());
                            	          
                            	    }
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3920:1: ( (lv_firstIndexes_13_0= ruleExpCS ) )
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3921:1: (lv_firstIndexes_13_0= ruleExpCS )
                            	    {
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3921:1: (lv_firstIndexes_13_0= ruleExpCS )
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3922:3: lv_firstIndexes_13_0= ruleExpCS
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getFirstIndexesExpCSParserRuleCall_7_2_0_3_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_rulePrimaryExpCS9229);
                            	    lv_firstIndexes_13_0=ruleExpCS();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getPrimaryExpCSRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"firstIndexes",
                            	              		lv_firstIndexes_13_0, 
                            	              		"ExpCS");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop57;
                                }
                            } while (true);

                            otherlv_14=(Token)match(input,69,FollowSets000.FOLLOW_69_in_rulePrimaryExpCS9243); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_14, grammarAccess.getPrimaryExpCSAccess().getRightSquareBracketKeyword_7_2_0_4());
                                  
                            }
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3942:1: (otherlv_15= '[' ( (lv_secondIndexes_16_0= ruleExpCS ) ) (otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) ) )* otherlv_19= ']' )?
                            int alt59=2;
                            int LA59_0 = input.LA(1);

                            if ( (LA59_0==68) ) {
                                alt59=1;
                            }
                            switch (alt59) {
                                case 1 :
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3942:3: otherlv_15= '[' ( (lv_secondIndexes_16_0= ruleExpCS ) ) (otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) ) )* otherlv_19= ']'
                                    {
                                    otherlv_15=(Token)match(input,68,FollowSets000.FOLLOW_68_in_rulePrimaryExpCS9256); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                          	newLeafNode(otherlv_15, grammarAccess.getPrimaryExpCSAccess().getLeftSquareBracketKeyword_7_2_0_5_0());
                                          
                                    }
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3946:1: ( (lv_secondIndexes_16_0= ruleExpCS ) )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3947:1: (lv_secondIndexes_16_0= ruleExpCS )
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3947:1: (lv_secondIndexes_16_0= ruleExpCS )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3948:3: lv_secondIndexes_16_0= ruleExpCS
                                    {
                                    if ( state.backtracking==0 ) {
                                       
                                      	        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getSecondIndexesExpCSParserRuleCall_7_2_0_5_1_0()); 
                                      	    
                                    }
                                    pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_rulePrimaryExpCS9277);
                                    lv_secondIndexes_16_0=ruleExpCS();

                                    state._fsp--;
                                    if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      	        if (current==null) {
                                      	            current = createModelElementForParent(grammarAccess.getPrimaryExpCSRule());
                                      	        }
                                             		add(
                                             			current, 
                                             			"secondIndexes",
                                              		lv_secondIndexes_16_0, 
                                              		"ExpCS");
                                      	        afterParserOrEnumRuleCall();
                                      	    
                                    }

                                    }


                                    }

                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3964:2: (otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) ) )*
                                    loop58:
                                    do {
                                        int alt58=2;
                                        int LA58_0 = input.LA(1);

                                        if ( (LA58_0==16) ) {
                                            alt58=1;
                                        }


                                        switch (alt58) {
                                    	case 1 :
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3964:4: otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) )
                                    	    {
                                    	    otherlv_17=(Token)match(input,16,FollowSets000.FOLLOW_16_in_rulePrimaryExpCS9290); if (state.failed) return current;
                                    	    if ( state.backtracking==0 ) {

                                    	          	newLeafNode(otherlv_17, grammarAccess.getPrimaryExpCSAccess().getCommaKeyword_7_2_0_5_2_0());
                                    	          
                                    	    }
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3968:1: ( (lv_secondIndexes_18_0= ruleExpCS ) )
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3969:1: (lv_secondIndexes_18_0= ruleExpCS )
                                    	    {
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3969:1: (lv_secondIndexes_18_0= ruleExpCS )
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3970:3: lv_secondIndexes_18_0= ruleExpCS
                                    	    {
                                    	    if ( state.backtracking==0 ) {
                                    	       
                                    	      	        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getSecondIndexesExpCSParserRuleCall_7_2_0_5_2_1_0()); 
                                    	      	    
                                    	    }
                                    	    pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_rulePrimaryExpCS9311);
                                    	    lv_secondIndexes_18_0=ruleExpCS();

                                    	    state._fsp--;
                                    	    if (state.failed) return current;
                                    	    if ( state.backtracking==0 ) {

                                    	      	        if (current==null) {
                                    	      	            current = createModelElementForParent(grammarAccess.getPrimaryExpCSRule());
                                    	      	        }
                                    	             		add(
                                    	             			current, 
                                    	             			"secondIndexes",
                                    	              		lv_secondIndexes_18_0, 
                                    	              		"ExpCS");
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

                                    otherlv_19=(Token)match(input,69,FollowSets000.FOLLOW_69_in_rulePrimaryExpCS9325); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                          	newLeafNode(otherlv_19, grammarAccess.getPrimaryExpCSAccess().getRightSquareBracketKeyword_7_2_0_5_3());
                                          
                                    }

                                    }
                                    break;

                            }

                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3990:3: ( ( (lv_atPre_20_0= '@' ) ) otherlv_21= 'pre' )?
                            int alt60=2;
                            int LA60_0 = input.LA(1);

                            if ( (LA60_0==77) ) {
                                alt60=1;
                            }
                            switch (alt60) {
                                case 1 :
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3990:4: ( (lv_atPre_20_0= '@' ) ) otherlv_21= 'pre'
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3990:4: ( (lv_atPre_20_0= '@' ) )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3991:1: (lv_atPre_20_0= '@' )
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3991:1: (lv_atPre_20_0= '@' )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3992:3: lv_atPre_20_0= '@'
                                    {
                                    lv_atPre_20_0=(Token)match(input,77,FollowSets000.FOLLOW_77_in_rulePrimaryExpCS9346); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                              newLeafNode(lv_atPre_20_0, grammarAccess.getPrimaryExpCSAccess().getAtPreCommercialAtKeyword_7_2_0_6_0_0());
                                          
                                    }
                                    if ( state.backtracking==0 ) {

                                      	        if (current==null) {
                                      	            current = createModelElement(grammarAccess.getPrimaryExpCSRule());
                                      	        }
                                             		setWithLastConsumed(current, "atPre", true, "@");
                                      	    
                                    }

                                    }


                                    }

                                    otherlv_21=(Token)match(input,78,FollowSets000.FOLLOW_78_in_rulePrimaryExpCS9371); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                          	newLeafNode(otherlv_21, grammarAccess.getPrimaryExpCSAccess().getPreKeyword_7_2_0_6_1());
                                          
                                    }

                                    }
                                    break;

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4010:6: ( () otherlv_23= '{' ( ( ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )* ) | ( (lv_value_27_0= ruleStringLiteral ) ) ) otherlv_28= '}' )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4010:6: ( () otherlv_23= '{' ( ( ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )* ) | ( (lv_value_27_0= ruleStringLiteral ) ) ) otherlv_28= '}' )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4010:7: () otherlv_23= '{' ( ( ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )* ) | ( (lv_value_27_0= ruleStringLiteral ) ) ) otherlv_28= '}'
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4010:7: ()
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4011:2: 
                            {
                            if ( state.backtracking==0 ) {
                               
                              	  /* */ 
                              	
                            }
                            if ( state.backtracking==0 ) {

                                      current = forceCreateModelElementAndSet(
                                          grammarAccess.getPrimaryExpCSAccess().getConstructorExpCSNameExpAction_7_2_1_0(),
                                          current);
                                  
                            }

                            }

                            otherlv_23=(Token)match(input,71,FollowSets000.FOLLOW_71_in_rulePrimaryExpCS9405); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_23, grammarAccess.getPrimaryExpCSAccess().getLeftCurlyBracketKeyword_7_2_1_1());
                                  
                            }
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4023:1: ( ( ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )* ) | ( (lv_value_27_0= ruleStringLiteral ) ) )
                            int alt62=2;
                            int LA62_0 = input.LA(1);

                            if ( ((LA62_0>=RULE_SIMPLE_ID && LA62_0<=RULE_ESCAPED_ID)||(LA62_0>=21 && LA62_0<=22)||(LA62_0>=25 && LA62_0<=33)) ) {
                                alt62=1;
                            }
                            else if ( (LA62_0==RULE_SINGLE_QUOTED_STRING) ) {
                                alt62=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 62, 0, input);

                                throw nvae;
                            }
                            switch (alt62) {
                                case 1 :
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4023:2: ( ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )* )
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4023:2: ( ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )* )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4023:3: ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )*
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4023:3: ( (lv_ownedParts_24_0= ruleConstructorPartCS ) )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4024:1: (lv_ownedParts_24_0= ruleConstructorPartCS )
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4024:1: (lv_ownedParts_24_0= ruleConstructorPartCS )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4025:3: lv_ownedParts_24_0= ruleConstructorPartCS
                                    {
                                    if ( state.backtracking==0 ) {
                                       
                                      	        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getOwnedPartsConstructorPartCSParserRuleCall_7_2_1_2_0_0_0()); 
                                      	    
                                    }
                                    pushFollow(FollowSets000.FOLLOW_ruleConstructorPartCS_in_rulePrimaryExpCS9428);
                                    lv_ownedParts_24_0=ruleConstructorPartCS();

                                    state._fsp--;
                                    if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      	        if (current==null) {
                                      	            current = createModelElementForParent(grammarAccess.getPrimaryExpCSRule());
                                      	        }
                                             		add(
                                             			current, 
                                             			"ownedParts",
                                              		lv_ownedParts_24_0, 
                                              		"ConstructorPartCS");
                                      	        afterParserOrEnumRuleCall();
                                      	    
                                    }

                                    }


                                    }

                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4041:2: (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )*
                                    loop61:
                                    do {
                                        int alt61=2;
                                        int LA61_0 = input.LA(1);

                                        if ( (LA61_0==16) ) {
                                            alt61=1;
                                        }


                                        switch (alt61) {
                                    	case 1 :
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4041:4: otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) )
                                    	    {
                                    	    otherlv_25=(Token)match(input,16,FollowSets000.FOLLOW_16_in_rulePrimaryExpCS9441); if (state.failed) return current;
                                    	    if ( state.backtracking==0 ) {

                                    	          	newLeafNode(otherlv_25, grammarAccess.getPrimaryExpCSAccess().getCommaKeyword_7_2_1_2_0_1_0());
                                    	          
                                    	    }
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4045:1: ( (lv_ownedParts_26_0= ruleConstructorPartCS ) )
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4046:1: (lv_ownedParts_26_0= ruleConstructorPartCS )
                                    	    {
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4046:1: (lv_ownedParts_26_0= ruleConstructorPartCS )
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4047:3: lv_ownedParts_26_0= ruleConstructorPartCS
                                    	    {
                                    	    if ( state.backtracking==0 ) {
                                    	       
                                    	      	        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getOwnedPartsConstructorPartCSParserRuleCall_7_2_1_2_0_1_1_0()); 
                                    	      	    
                                    	    }
                                    	    pushFollow(FollowSets000.FOLLOW_ruleConstructorPartCS_in_rulePrimaryExpCS9462);
                                    	    lv_ownedParts_26_0=ruleConstructorPartCS();

                                    	    state._fsp--;
                                    	    if (state.failed) return current;
                                    	    if ( state.backtracking==0 ) {

                                    	      	        if (current==null) {
                                    	      	            current = createModelElementForParent(grammarAccess.getPrimaryExpCSRule());
                                    	      	        }
                                    	             		add(
                                    	             			current, 
                                    	             			"ownedParts",
                                    	              		lv_ownedParts_26_0, 
                                    	              		"ConstructorPartCS");
                                    	      	        afterParserOrEnumRuleCall();
                                    	      	    
                                    	    }

                                    	    }


                                    	    }


                                    	    }
                                    	    break;

                                    	default :
                                    	    break loop61;
                                        }
                                    } while (true);


                                    }


                                    }
                                    break;
                                case 2 :
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4064:6: ( (lv_value_27_0= ruleStringLiteral ) )
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4064:6: ( (lv_value_27_0= ruleStringLiteral ) )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4065:1: (lv_value_27_0= ruleStringLiteral )
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4065:1: (lv_value_27_0= ruleStringLiteral )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4066:3: lv_value_27_0= ruleStringLiteral
                                    {
                                    if ( state.backtracking==0 ) {
                                       
                                      	        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getValueStringLiteralParserRuleCall_7_2_1_2_1_0()); 
                                      	    
                                    }
                                    pushFollow(FollowSets000.FOLLOW_ruleStringLiteral_in_rulePrimaryExpCS9492);
                                    lv_value_27_0=ruleStringLiteral();

                                    state._fsp--;
                                    if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      	        if (current==null) {
                                      	            current = createModelElementForParent(grammarAccess.getPrimaryExpCSRule());
                                      	        }
                                             		set(
                                             			current, 
                                             			"value",
                                              		lv_value_27_0, 
                                              		"StringLiteral");
                                      	        afterParserOrEnumRuleCall();
                                      	    
                                    }

                                    }


                                    }


                                    }
                                    break;

                            }

                            otherlv_28=(Token)match(input,72,FollowSets000.FOLLOW_72_in_rulePrimaryExpCS9505); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_28, grammarAccess.getPrimaryExpCSAccess().getRightCurlyBracketKeyword_7_2_1_3());
                                  
                            }

                            }


                            }
                            break;
                        case 3 :
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4087:6: ( ( ( (lv_atPre_29_0= '@' ) ) otherlv_30= 'pre' )? ( () otherlv_32= '(' ( ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_39= ')' )? )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4087:6: ( ( ( (lv_atPre_29_0= '@' ) ) otherlv_30= 'pre' )? ( () otherlv_32= '(' ( ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_39= ')' )? )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4087:7: ( ( (lv_atPre_29_0= '@' ) ) otherlv_30= 'pre' )? ( () otherlv_32= '(' ( ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_39= ')' )?
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4087:7: ( ( (lv_atPre_29_0= '@' ) ) otherlv_30= 'pre' )?
                            int alt63=2;
                            int LA63_0 = input.LA(1);

                            if ( (LA63_0==77) ) {
                                alt63=1;
                            }
                            switch (alt63) {
                                case 1 :
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4087:8: ( (lv_atPre_29_0= '@' ) ) otherlv_30= 'pre'
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4087:8: ( (lv_atPre_29_0= '@' ) )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4088:1: (lv_atPre_29_0= '@' )
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4088:1: (lv_atPre_29_0= '@' )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4089:3: lv_atPre_29_0= '@'
                                    {
                                    lv_atPre_29_0=(Token)match(input,77,FollowSets000.FOLLOW_77_in_rulePrimaryExpCS9532); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                              newLeafNode(lv_atPre_29_0, grammarAccess.getPrimaryExpCSAccess().getAtPreCommercialAtKeyword_7_2_2_0_0_0());
                                          
                                    }
                                    if ( state.backtracking==0 ) {

                                      	        if (current==null) {
                                      	            current = createModelElement(grammarAccess.getPrimaryExpCSRule());
                                      	        }
                                             		setWithLastConsumed(current, "atPre", true, "@");
                                      	    
                                    }

                                    }


                                    }

                                    otherlv_30=(Token)match(input,78,FollowSets000.FOLLOW_78_in_rulePrimaryExpCS9557); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                          	newLeafNode(otherlv_30, grammarAccess.getPrimaryExpCSAccess().getPreKeyword_7_2_2_0_1());
                                          
                                    }

                                    }
                                    break;

                            }

                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4106:3: ( () otherlv_32= '(' ( ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_39= ')' )?
                            int alt70=2;
                            int LA70_0 = input.LA(1);

                            if ( (LA70_0==65) ) {
                                alt70=1;
                            }
                            switch (alt70) {
                                case 1 :
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4106:4: () otherlv_32= '(' ( ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_39= ')'
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4106:4: ()
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4107:2: 
                                    {
                                    if ( state.backtracking==0 ) {
                                       
                                      	  /* */ 
                                      	
                                    }
                                    if ( state.backtracking==0 ) {

                                              current = forceCreateModelElementAndSet(
                                                  grammarAccess.getPrimaryExpCSAccess().getInvocationExpCSNameExpAction_7_2_2_1_0(),
                                                  current);
                                          
                                    }

                                    }

                                    otherlv_32=(Token)match(input,65,FollowSets000.FOLLOW_65_in_rulePrimaryExpCS9584); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                          	newLeafNode(otherlv_32, grammarAccess.getPrimaryExpCSAccess().getLeftParenthesisKeyword_7_2_2_1_1());
                                          
                                    }
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4119:1: ( ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )? )?
                                    int alt69=2;
                                    int LA69_0 = input.LA(1);

                                    if ( ((LA69_0>=RULE_SIMPLE_ID && LA69_0<=RULE_SINGLE_QUOTED_STRING)||(LA69_0>=21 && LA69_0<=22)||(LA69_0>=25 && LA69_0<=36)||(LA69_0>=51 && LA69_0<=65)||(LA69_0>=73 && LA69_0<=76)||LA69_0==79||LA69_0==83||LA69_0==85) ) {
                                        alt69=1;
                                    }
                                    switch (alt69) {
                                        case 1 :
                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4119:2: ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )?
                                            {
                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4119:2: ( (lv_argument_33_0= ruleNavigatingArgCS ) )
                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4120:1: (lv_argument_33_0= ruleNavigatingArgCS )
                                            {
                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4120:1: (lv_argument_33_0= ruleNavigatingArgCS )
                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4121:3: lv_argument_33_0= ruleNavigatingArgCS
                                            {
                                            if ( state.backtracking==0 ) {
                                               
                                              	        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getArgumentNavigatingArgCSParserRuleCall_7_2_2_1_2_0_0()); 
                                              	    
                                            }
                                            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgCS_in_rulePrimaryExpCS9606);
                                            lv_argument_33_0=ruleNavigatingArgCS();

                                            state._fsp--;
                                            if (state.failed) return current;
                                            if ( state.backtracking==0 ) {

                                              	        if (current==null) {
                                              	            current = createModelElementForParent(grammarAccess.getPrimaryExpCSRule());
                                              	        }
                                                     		add(
                                                     			current, 
                                                     			"argument",
                                                      		lv_argument_33_0, 
                                                      		"NavigatingArgCS");
                                              	        afterParserOrEnumRuleCall();
                                              	    
                                            }

                                            }


                                            }

                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4137:2: ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )*
                                            loop64:
                                            do {
                                                int alt64=2;
                                                int LA64_0 = input.LA(1);

                                                if ( (LA64_0==16) ) {
                                                    alt64=1;
                                                }


                                                switch (alt64) {
                                            	case 1 :
                                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4138:1: (lv_argument_34_0= ruleNavigatingCommaArgCS )
                                            	    {
                                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4138:1: (lv_argument_34_0= ruleNavigatingCommaArgCS )
                                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4139:3: lv_argument_34_0= ruleNavigatingCommaArgCS
                                            	    {
                                            	    if ( state.backtracking==0 ) {
                                            	       
                                            	      	        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getArgumentNavigatingCommaArgCSParserRuleCall_7_2_2_1_2_1_0()); 
                                            	      	    
                                            	    }
                                            	    pushFollow(FollowSets000.FOLLOW_ruleNavigatingCommaArgCS_in_rulePrimaryExpCS9627);
                                            	    lv_argument_34_0=ruleNavigatingCommaArgCS();

                                            	    state._fsp--;
                                            	    if (state.failed) return current;
                                            	    if ( state.backtracking==0 ) {

                                            	      	        if (current==null) {
                                            	      	            current = createModelElementForParent(grammarAccess.getPrimaryExpCSRule());
                                            	      	        }
                                            	             		add(
                                            	             			current, 
                                            	             			"argument",
                                            	              		lv_argument_34_0, 
                                            	              		"NavigatingCommaArgCS");
                                            	      	        afterParserOrEnumRuleCall();
                                            	      	    
                                            	    }

                                            	    }


                                            	    }
                                            	    break;

                                            	default :
                                            	    break loop64;
                                                }
                                            } while (true);

                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4155:3: ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )?
                                            int alt66=2;
                                            int LA66_0 = input.LA(1);

                                            if ( (LA66_0==20) ) {
                                                alt66=1;
                                            }
                                            switch (alt66) {
                                                case 1 :
                                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4155:4: ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )*
                                                    {
                                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4155:4: ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) )
                                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4156:1: (lv_argument_35_0= ruleNavigatingSemiArgCS )
                                                    {
                                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4156:1: (lv_argument_35_0= ruleNavigatingSemiArgCS )
                                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4157:3: lv_argument_35_0= ruleNavigatingSemiArgCS
                                                    {
                                                    if ( state.backtracking==0 ) {
                                                       
                                                      	        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getArgumentNavigatingSemiArgCSParserRuleCall_7_2_2_1_2_2_0_0()); 
                                                      	    
                                                    }
                                                    pushFollow(FollowSets000.FOLLOW_ruleNavigatingSemiArgCS_in_rulePrimaryExpCS9650);
                                                    lv_argument_35_0=ruleNavigatingSemiArgCS();

                                                    state._fsp--;
                                                    if (state.failed) return current;
                                                    if ( state.backtracking==0 ) {

                                                      	        if (current==null) {
                                                      	            current = createModelElementForParent(grammarAccess.getPrimaryExpCSRule());
                                                      	        }
                                                             		add(
                                                             			current, 
                                                             			"argument",
                                                              		lv_argument_35_0, 
                                                              		"NavigatingSemiArgCS");
                                                      	        afterParserOrEnumRuleCall();
                                                      	    
                                                    }

                                                    }


                                                    }

                                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4173:2: ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )*
                                                    loop65:
                                                    do {
                                                        int alt65=2;
                                                        int LA65_0 = input.LA(1);

                                                        if ( (LA65_0==16) ) {
                                                            alt65=1;
                                                        }


                                                        switch (alt65) {
                                                    	case 1 :
                                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4174:1: (lv_argument_36_0= ruleNavigatingCommaArgCS )
                                                    	    {
                                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4174:1: (lv_argument_36_0= ruleNavigatingCommaArgCS )
                                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4175:3: lv_argument_36_0= ruleNavigatingCommaArgCS
                                                    	    {
                                                    	    if ( state.backtracking==0 ) {
                                                    	       
                                                    	      	        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getArgumentNavigatingCommaArgCSParserRuleCall_7_2_2_1_2_2_1_0()); 
                                                    	      	    
                                                    	    }
                                                    	    pushFollow(FollowSets000.FOLLOW_ruleNavigatingCommaArgCS_in_rulePrimaryExpCS9671);
                                                    	    lv_argument_36_0=ruleNavigatingCommaArgCS();

                                                    	    state._fsp--;
                                                    	    if (state.failed) return current;
                                                    	    if ( state.backtracking==0 ) {

                                                    	      	        if (current==null) {
                                                    	      	            current = createModelElementForParent(grammarAccess.getPrimaryExpCSRule());
                                                    	      	        }
                                                    	             		add(
                                                    	             			current, 
                                                    	             			"argument",
                                                    	              		lv_argument_36_0, 
                                                    	              		"NavigatingCommaArgCS");
                                                    	      	        afterParserOrEnumRuleCall();
                                                    	      	    
                                                    	    }

                                                    	    }


                                                    	    }
                                                    	    break;

                                                    	default :
                                                    	    break loop65;
                                                        }
                                                    } while (true);


                                                    }
                                                    break;

                                            }

                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4191:5: ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )?
                                            int alt68=2;
                                            int LA68_0 = input.LA(1);

                                            if ( (LA68_0==17) ) {
                                                alt68=1;
                                            }
                                            switch (alt68) {
                                                case 1 :
                                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4191:6: ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )*
                                                    {
                                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4191:6: ( (lv_argument_37_0= ruleNavigatingBarArgCS ) )
                                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4192:1: (lv_argument_37_0= ruleNavigatingBarArgCS )
                                                    {
                                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4192:1: (lv_argument_37_0= ruleNavigatingBarArgCS )
                                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4193:3: lv_argument_37_0= ruleNavigatingBarArgCS
                                                    {
                                                    if ( state.backtracking==0 ) {
                                                       
                                                      	        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getArgumentNavigatingBarArgCSParserRuleCall_7_2_2_1_2_3_0_0()); 
                                                      	    
                                                    }
                                                    pushFollow(FollowSets000.FOLLOW_ruleNavigatingBarArgCS_in_rulePrimaryExpCS9696);
                                                    lv_argument_37_0=ruleNavigatingBarArgCS();

                                                    state._fsp--;
                                                    if (state.failed) return current;
                                                    if ( state.backtracking==0 ) {

                                                      	        if (current==null) {
                                                      	            current = createModelElementForParent(grammarAccess.getPrimaryExpCSRule());
                                                      	        }
                                                             		add(
                                                             			current, 
                                                             			"argument",
                                                              		lv_argument_37_0, 
                                                              		"NavigatingBarArgCS");
                                                      	        afterParserOrEnumRuleCall();
                                                      	    
                                                    }

                                                    }


                                                    }

                                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4209:2: ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )*
                                                    loop67:
                                                    do {
                                                        int alt67=2;
                                                        int LA67_0 = input.LA(1);

                                                        if ( (LA67_0==16) ) {
                                                            alt67=1;
                                                        }


                                                        switch (alt67) {
                                                    	case 1 :
                                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4210:1: (lv_argument_38_0= ruleNavigatingCommaArgCS )
                                                    	    {
                                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4210:1: (lv_argument_38_0= ruleNavigatingCommaArgCS )
                                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4211:3: lv_argument_38_0= ruleNavigatingCommaArgCS
                                                    	    {
                                                    	    if ( state.backtracking==0 ) {
                                                    	       
                                                    	      	        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getArgumentNavigatingCommaArgCSParserRuleCall_7_2_2_1_2_3_1_0()); 
                                                    	      	    
                                                    	    }
                                                    	    pushFollow(FollowSets000.FOLLOW_ruleNavigatingCommaArgCS_in_rulePrimaryExpCS9717);
                                                    	    lv_argument_38_0=ruleNavigatingCommaArgCS();

                                                    	    state._fsp--;
                                                    	    if (state.failed) return current;
                                                    	    if ( state.backtracking==0 ) {

                                                    	      	        if (current==null) {
                                                    	      	            current = createModelElementForParent(grammarAccess.getPrimaryExpCSRule());
                                                    	      	        }
                                                    	             		add(
                                                    	             			current, 
                                                    	             			"argument",
                                                    	              		lv_argument_38_0, 
                                                    	              		"NavigatingCommaArgCS");
                                                    	      	        afterParserOrEnumRuleCall();
                                                    	      	    
                                                    	    }

                                                    	    }


                                                    	    }
                                                    	    break;

                                                    	default :
                                                    	    break loop67;
                                                        }
                                                    } while (true);


                                                    }
                                                    break;

                                            }


                                            }
                                            break;

                                    }

                                    otherlv_39=(Token)match(input,66,FollowSets000.FOLLOW_66_in_rulePrimaryExpCS9734); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                          	newLeafNode(otherlv_39, grammarAccess.getPrimaryExpCSAccess().getRightParenthesisKeyword_7_2_2_1_3());
                                          
                                    }

                                    }
                                    break;

                            }


                            }


                            }
                            break;

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
    // $ANTLR end "rulePrimaryExpCS"


    // $ANTLR start "entryRuleNavigatingArgCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4239:1: entryRuleNavigatingArgCS returns [EObject current=null] : iv_ruleNavigatingArgCS= ruleNavigatingArgCS EOF ;
    public final EObject entryRuleNavigatingArgCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingArgCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4240:2: (iv_ruleNavigatingArgCS= ruleNavigatingArgCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4241:2: iv_ruleNavigatingArgCS= ruleNavigatingArgCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingArgCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgCS_in_entryRuleNavigatingArgCS9775);
            iv_ruleNavigatingArgCS=ruleNavigatingArgCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingArgCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigatingArgCS9785); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4248:1: ruleNavigatingArgCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleNavigatingArgExpCS ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_init_4_0= ruleExpCS ) ) )? )? ) ;
    public final EObject ruleNavigatingArgCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;

        EObject lv_init_4_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4251:28: ( ( ( (lv_name_0_0= ruleNavigatingArgExpCS ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_init_4_0= ruleExpCS ) ) )? )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4252:1: ( ( (lv_name_0_0= ruleNavigatingArgExpCS ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_init_4_0= ruleExpCS ) ) )? )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4252:1: ( ( (lv_name_0_0= ruleNavigatingArgExpCS ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_init_4_0= ruleExpCS ) ) )? )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4252:2: ( (lv_name_0_0= ruleNavigatingArgExpCS ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_init_4_0= ruleExpCS ) ) )? )?
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4252:2: ( (lv_name_0_0= ruleNavigatingArgExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4253:1: (lv_name_0_0= ruleNavigatingArgExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4253:1: (lv_name_0_0= ruleNavigatingArgExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4254:3: lv_name_0_0= ruleNavigatingArgExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getNameNavigatingArgExpCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingArgCS9831);
            lv_name_0_0=ruleNavigatingArgExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getNavigatingArgCSRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"NavigatingArgExpCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4270:2: (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_init_4_0= ruleExpCS ) ) )? )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==23) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4270:4: otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_init_4_0= ruleExpCS ) ) )?
                    {
                    otherlv_1=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleNavigatingArgCS9844); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getNavigatingArgCSAccess().getColonKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4274:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4275:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4275:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4276:3: lv_ownedType_2_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleNavigatingArgCS9865);
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
                              		"TypeExpCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4292:2: (otherlv_3= '=' ( (lv_init_4_0= ruleExpCS ) ) )?
                    int alt73=2;
                    int LA73_0 = input.LA(1);

                    if ( (LA73_0==43) ) {
                        alt73=1;
                    }
                    switch (alt73) {
                        case 1 :
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4292:4: otherlv_3= '=' ( (lv_init_4_0= ruleExpCS ) )
                            {
                            otherlv_3=(Token)match(input,43,FollowSets000.FOLLOW_43_in_ruleNavigatingArgCS9878); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_3, grammarAccess.getNavigatingArgCSAccess().getEqualsSignKeyword_1_2_0());
                                  
                            }
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4296:1: ( (lv_init_4_0= ruleExpCS ) )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4297:1: (lv_init_4_0= ruleExpCS )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4297:1: (lv_init_4_0= ruleExpCS )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4298:3: lv_init_4_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getInitExpCSParserRuleCall_1_2_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNavigatingArgCS9899);
                            lv_init_4_0=ruleExpCS();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getNavigatingArgCSRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"init",
                                      		lv_init_4_0, 
                                      		"ExpCS");
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
    // $ANTLR end "ruleNavigatingArgCS"


    // $ANTLR start "entryRuleNavigatingBarArgCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4322:1: entryRuleNavigatingBarArgCS returns [EObject current=null] : iv_ruleNavigatingBarArgCS= ruleNavigatingBarArgCS EOF ;
    public final EObject entryRuleNavigatingBarArgCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingBarArgCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4323:2: (iv_ruleNavigatingBarArgCS= ruleNavigatingBarArgCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4324:2: iv_ruleNavigatingBarArgCS= ruleNavigatingBarArgCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingBarArgCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingBarArgCS_in_entryRuleNavigatingBarArgCS9939);
            iv_ruleNavigatingBarArgCS=ruleNavigatingBarArgCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingBarArgCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigatingBarArgCS9949); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4331:1: ruleNavigatingBarArgCS returns [EObject current=null] : ( ( (lv_prefix_0_0= '|' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )? ) ;
    public final EObject ruleNavigatingBarArgCS() throws RecognitionException {
        EObject current = null;

        Token lv_prefix_0_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_name_1_0 = null;

        EObject lv_ownedType_3_0 = null;

        EObject lv_init_5_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4334:28: ( ( ( (lv_prefix_0_0= '|' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4335:1: ( ( (lv_prefix_0_0= '|' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4335:1: ( ( (lv_prefix_0_0= '|' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4335:2: ( (lv_prefix_0_0= '|' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )?
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4335:2: ( (lv_prefix_0_0= '|' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4336:1: (lv_prefix_0_0= '|' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4336:1: (lv_prefix_0_0= '|' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4337:3: lv_prefix_0_0= '|'
            {
            lv_prefix_0_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleNavigatingBarArgCS9992); if (state.failed) return current;
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4350:2: ( (lv_name_1_0= ruleNavigatingArgExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4351:1: (lv_name_1_0= ruleNavigatingArgExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4351:1: (lv_name_1_0= ruleNavigatingArgExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4352:3: lv_name_1_0= ruleNavigatingArgExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNavigatingBarArgCSAccess().getNameNavigatingArgExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingBarArgCS10026);
            lv_name_1_0=ruleNavigatingArgExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getNavigatingBarArgCSRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"NavigatingArgExpCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4368:2: (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==23) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4368:4: otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )?
                    {
                    otherlv_2=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleNavigatingBarArgCS10039); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getNavigatingBarArgCSAccess().getColonKeyword_2_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4372:1: ( (lv_ownedType_3_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4373:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4373:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4374:3: lv_ownedType_3_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingBarArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleNavigatingBarArgCS10060);
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
                              		"TypeExpCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4390:2: (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )?
                    int alt75=2;
                    int LA75_0 = input.LA(1);

                    if ( (LA75_0==43) ) {
                        alt75=1;
                    }
                    switch (alt75) {
                        case 1 :
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4390:4: otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) )
                            {
                            otherlv_4=(Token)match(input,43,FollowSets000.FOLLOW_43_in_ruleNavigatingBarArgCS10073); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getNavigatingBarArgCSAccess().getEqualsSignKeyword_2_2_0());
                                  
                            }
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4394:1: ( (lv_init_5_0= ruleExpCS ) )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4395:1: (lv_init_5_0= ruleExpCS )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4395:1: (lv_init_5_0= ruleExpCS )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4396:3: lv_init_5_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getNavigatingBarArgCSAccess().getInitExpCSParserRuleCall_2_2_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNavigatingBarArgCS10094);
                            lv_init_5_0=ruleExpCS();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getNavigatingBarArgCSRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"init",
                                      		lv_init_5_0, 
                                      		"ExpCS");
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4420:1: entryRuleNavigatingCommaArgCS returns [EObject current=null] : iv_ruleNavigatingCommaArgCS= ruleNavigatingCommaArgCS EOF ;
    public final EObject entryRuleNavigatingCommaArgCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingCommaArgCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4421:2: (iv_ruleNavigatingCommaArgCS= ruleNavigatingCommaArgCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4422:2: iv_ruleNavigatingCommaArgCS= ruleNavigatingCommaArgCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingCommaArgCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingCommaArgCS_in_entryRuleNavigatingCommaArgCS10134);
            iv_ruleNavigatingCommaArgCS=ruleNavigatingCommaArgCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingCommaArgCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigatingCommaArgCS10144); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4429:1: ruleNavigatingCommaArgCS returns [EObject current=null] : ( ( (lv_prefix_0_0= ',' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )? ) ;
    public final EObject ruleNavigatingCommaArgCS() throws RecognitionException {
        EObject current = null;

        Token lv_prefix_0_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_name_1_0 = null;

        EObject lv_ownedType_3_0 = null;

        EObject lv_init_5_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4432:28: ( ( ( (lv_prefix_0_0= ',' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4433:1: ( ( (lv_prefix_0_0= ',' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4433:1: ( ( (lv_prefix_0_0= ',' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4433:2: ( (lv_prefix_0_0= ',' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )?
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4433:2: ( (lv_prefix_0_0= ',' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4434:1: (lv_prefix_0_0= ',' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4434:1: (lv_prefix_0_0= ',' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4435:3: lv_prefix_0_0= ','
            {
            lv_prefix_0_0=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleNavigatingCommaArgCS10187); if (state.failed) return current;
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4448:2: ( (lv_name_1_0= ruleNavigatingArgExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4449:1: (lv_name_1_0= ruleNavigatingArgExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4449:1: (lv_name_1_0= ruleNavigatingArgExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4450:3: lv_name_1_0= ruleNavigatingArgExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getNameNavigatingArgExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingCommaArgCS10221);
            lv_name_1_0=ruleNavigatingArgExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getNavigatingCommaArgCSRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"NavigatingArgExpCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4466:2: (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==23) ) {
                alt78=1;
            }
            switch (alt78) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4466:4: otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )?
                    {
                    otherlv_2=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleNavigatingCommaArgCS10234); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getNavigatingCommaArgCSAccess().getColonKeyword_2_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4470:1: ( (lv_ownedType_3_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4471:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4471:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4472:3: lv_ownedType_3_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleNavigatingCommaArgCS10255);
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
                              		"TypeExpCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4488:2: (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )?
                    int alt77=2;
                    int LA77_0 = input.LA(1);

                    if ( (LA77_0==43) ) {
                        alt77=1;
                    }
                    switch (alt77) {
                        case 1 :
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4488:4: otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) )
                            {
                            otherlv_4=(Token)match(input,43,FollowSets000.FOLLOW_43_in_ruleNavigatingCommaArgCS10268); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getNavigatingCommaArgCSAccess().getEqualsSignKeyword_2_2_0());
                                  
                            }
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4492:1: ( (lv_init_5_0= ruleExpCS ) )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4493:1: (lv_init_5_0= ruleExpCS )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4493:1: (lv_init_5_0= ruleExpCS )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4494:3: lv_init_5_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getInitExpCSParserRuleCall_2_2_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNavigatingCommaArgCS10289);
                            lv_init_5_0=ruleExpCS();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getNavigatingCommaArgCSRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"init",
                                      		lv_init_5_0, 
                                      		"ExpCS");
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
    // $ANTLR end "ruleNavigatingCommaArgCS"


    // $ANTLR start "entryRuleNavigatingSemiArgCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4518:1: entryRuleNavigatingSemiArgCS returns [EObject current=null] : iv_ruleNavigatingSemiArgCS= ruleNavigatingSemiArgCS EOF ;
    public final EObject entryRuleNavigatingSemiArgCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingSemiArgCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4519:2: (iv_ruleNavigatingSemiArgCS= ruleNavigatingSemiArgCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4520:2: iv_ruleNavigatingSemiArgCS= ruleNavigatingSemiArgCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingSemiArgCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingSemiArgCS_in_entryRuleNavigatingSemiArgCS10329);
            iv_ruleNavigatingSemiArgCS=ruleNavigatingSemiArgCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingSemiArgCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigatingSemiArgCS10339); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4527:1: ruleNavigatingSemiArgCS returns [EObject current=null] : ( ( (lv_prefix_0_0= ';' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )? ) ;
    public final EObject ruleNavigatingSemiArgCS() throws RecognitionException {
        EObject current = null;

        Token lv_prefix_0_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_name_1_0 = null;

        EObject lv_ownedType_3_0 = null;

        EObject lv_init_5_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4530:28: ( ( ( (lv_prefix_0_0= ';' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4531:1: ( ( (lv_prefix_0_0= ';' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4531:1: ( ( (lv_prefix_0_0= ';' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4531:2: ( (lv_prefix_0_0= ';' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )?
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4531:2: ( (lv_prefix_0_0= ';' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4532:1: (lv_prefix_0_0= ';' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4532:1: (lv_prefix_0_0= ';' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4533:3: lv_prefix_0_0= ';'
            {
            lv_prefix_0_0=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleNavigatingSemiArgCS10382); if (state.failed) return current;
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4546:2: ( (lv_name_1_0= ruleNavigatingArgExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4547:1: (lv_name_1_0= ruleNavigatingArgExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4547:1: (lv_name_1_0= ruleNavigatingArgExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4548:3: lv_name_1_0= ruleNavigatingArgExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNavigatingSemiArgCSAccess().getNameNavigatingArgExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingSemiArgCS10416);
            lv_name_1_0=ruleNavigatingArgExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getNavigatingSemiArgCSRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"NavigatingArgExpCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4564:2: (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==23) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4564:4: otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )?
                    {
                    otherlv_2=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleNavigatingSemiArgCS10429); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getNavigatingSemiArgCSAccess().getColonKeyword_2_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4568:1: ( (lv_ownedType_3_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4569:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4569:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4570:3: lv_ownedType_3_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingSemiArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleNavigatingSemiArgCS10450);
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
                              		"TypeExpCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4586:2: (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )?
                    int alt79=2;
                    int LA79_0 = input.LA(1);

                    if ( (LA79_0==43) ) {
                        alt79=1;
                    }
                    switch (alt79) {
                        case 1 :
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4586:4: otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) )
                            {
                            otherlv_4=(Token)match(input,43,FollowSets000.FOLLOW_43_in_ruleNavigatingSemiArgCS10463); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getNavigatingSemiArgCSAccess().getEqualsSignKeyword_2_2_0());
                                  
                            }
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4590:1: ( (lv_init_5_0= ruleExpCS ) )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4591:1: (lv_init_5_0= ruleExpCS )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4591:1: (lv_init_5_0= ruleExpCS )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4592:3: lv_init_5_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getNavigatingSemiArgCSAccess().getInitExpCSParserRuleCall_2_2_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNavigatingSemiArgCS10484);
                            lv_init_5_0=ruleExpCS();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getNavigatingSemiArgCSRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"init",
                                      		lv_init_5_0, 
                                      		"ExpCS");
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4616:1: entryRuleNavigatingArgExpCS returns [EObject current=null] : iv_ruleNavigatingArgExpCS= ruleNavigatingArgExpCS EOF ;
    public final EObject entryRuleNavigatingArgExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingArgExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4617:2: (iv_ruleNavigatingArgExpCS= ruleNavigatingArgExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4618:2: iv_ruleNavigatingArgExpCS= ruleNavigatingArgExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingArgExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgExpCS_in_entryRuleNavigatingArgExpCS10524);
            iv_ruleNavigatingArgExpCS=ruleNavigatingArgExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingArgExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigatingArgExpCS10534); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4625:1: ruleNavigatingArgExpCS returns [EObject current=null] : this_ExpCS_0= ruleExpCS ;
    public final EObject ruleNavigatingArgExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_ExpCS_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4628:28: (this_ExpCS_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4630:2: this_ExpCS_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getNavigatingArgExpCSAccess().getExpCSParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNavigatingArgExpCS10583);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4649:1: entryRuleIfExpCS returns [EObject current=null] : iv_ruleIfExpCS= ruleIfExpCS EOF ;
    public final EObject entryRuleIfExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4650:2: (iv_ruleIfExpCS= ruleIfExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4651:2: iv_ruleIfExpCS= ruleIfExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIfExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIfExpCS_in_entryRuleIfExpCS10617);
            iv_ruleIfExpCS=ruleIfExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIfExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIfExpCS10627); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4658:1: ruleIfExpCS returns [EObject current=null] : (otherlv_0= 'if' ( (lv_condition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_thenExpression_3_0= ruleExpCS ) ) otherlv_4= 'else' ( (lv_elseExpression_5_0= ruleExpCS ) ) otherlv_6= 'endif' ) ;
    public final EObject ruleIfExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_condition_1_0 = null;

        EObject lv_thenExpression_3_0 = null;

        EObject lv_elseExpression_5_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4661:28: ( (otherlv_0= 'if' ( (lv_condition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_thenExpression_3_0= ruleExpCS ) ) otherlv_4= 'else' ( (lv_elseExpression_5_0= ruleExpCS ) ) otherlv_6= 'endif' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4662:1: (otherlv_0= 'if' ( (lv_condition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_thenExpression_3_0= ruleExpCS ) ) otherlv_4= 'else' ( (lv_elseExpression_5_0= ruleExpCS ) ) otherlv_6= 'endif' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4662:1: (otherlv_0= 'if' ( (lv_condition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_thenExpression_3_0= ruleExpCS ) ) otherlv_4= 'else' ( (lv_elseExpression_5_0= ruleExpCS ) ) otherlv_6= 'endif' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4662:3: otherlv_0= 'if' ( (lv_condition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_thenExpression_3_0= ruleExpCS ) ) otherlv_4= 'else' ( (lv_elseExpression_5_0= ruleExpCS ) ) otherlv_6= 'endif'
            {
            otherlv_0=(Token)match(input,79,FollowSets000.FOLLOW_79_in_ruleIfExpCS10664); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getIfExpCSAccess().getIfKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4666:1: ( (lv_condition_1_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4667:1: (lv_condition_1_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4667:1: (lv_condition_1_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4668:3: lv_condition_1_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIfExpCSAccess().getConditionExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleIfExpCS10685);
            lv_condition_1_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getIfExpCSRule());
              	        }
                     		set(
                     			current, 
                     			"condition",
                      		lv_condition_1_0, 
                      		"ExpCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,80,FollowSets000.FOLLOW_80_in_ruleIfExpCS10697); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getIfExpCSAccess().getThenKeyword_2());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4688:1: ( (lv_thenExpression_3_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4689:1: (lv_thenExpression_3_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4689:1: (lv_thenExpression_3_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4690:3: lv_thenExpression_3_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIfExpCSAccess().getThenExpressionExpCSParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleIfExpCS10718);
            lv_thenExpression_3_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getIfExpCSRule());
              	        }
                     		set(
                     			current, 
                     			"thenExpression",
                      		lv_thenExpression_3_0, 
                      		"ExpCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,81,FollowSets000.FOLLOW_81_in_ruleIfExpCS10730); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getIfExpCSAccess().getElseKeyword_4());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4710:1: ( (lv_elseExpression_5_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4711:1: (lv_elseExpression_5_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4711:1: (lv_elseExpression_5_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4712:3: lv_elseExpression_5_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIfExpCSAccess().getElseExpressionExpCSParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleIfExpCS10751);
            lv_elseExpression_5_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getIfExpCSRule());
              	        }
                     		set(
                     			current, 
                     			"elseExpression",
                      		lv_elseExpression_5_0, 
                      		"ExpCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_6=(Token)match(input,82,FollowSets000.FOLLOW_82_in_ruleIfExpCS10763); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getIfExpCSAccess().getEndifKeyword_6());
                  
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


    // $ANTLR start "entryRuleLetExpCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4740:1: entryRuleLetExpCS returns [EObject current=null] : iv_ruleLetExpCS= ruleLetExpCS EOF ;
    public final EObject entryRuleLetExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLetExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4741:2: (iv_ruleLetExpCS= ruleLetExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4742:2: iv_ruleLetExpCS= ruleLetExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLetExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLetExpCS_in_entryRuleLetExpCS10799);
            iv_ruleLetExpCS=ruleLetExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLetExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLetExpCS10809); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4749:1: ruleLetExpCS returns [EObject current=null] : (otherlv_0= 'let' ( (lv_variable_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_variable_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_in_5_0= ruleExpCS ) ) ) ;
    public final EObject ruleLetExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_variable_1_0 = null;

        EObject lv_variable_3_0 = null;

        EObject lv_in_5_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4752:28: ( (otherlv_0= 'let' ( (lv_variable_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_variable_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_in_5_0= ruleExpCS ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4753:1: (otherlv_0= 'let' ( (lv_variable_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_variable_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_in_5_0= ruleExpCS ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4753:1: (otherlv_0= 'let' ( (lv_variable_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_variable_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_in_5_0= ruleExpCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4753:3: otherlv_0= 'let' ( (lv_variable_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_variable_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_in_5_0= ruleExpCS ) )
            {
            otherlv_0=(Token)match(input,83,FollowSets000.FOLLOW_83_in_ruleLetExpCS10846); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLetExpCSAccess().getLetKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4757:1: ( (lv_variable_1_0= ruleLetVariableCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4758:1: (lv_variable_1_0= ruleLetVariableCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4758:1: (lv_variable_1_0= ruleLetVariableCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4759:3: lv_variable_1_0= ruleLetVariableCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetExpCSAccess().getVariableLetVariableCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleLetVariableCS_in_ruleLetExpCS10867);
            lv_variable_1_0=ruleLetVariableCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLetExpCSRule());
              	        }
                     		add(
                     			current, 
                     			"variable",
                      		lv_variable_1_0, 
                      		"LetVariableCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4775:2: (otherlv_2= ',' ( (lv_variable_3_0= ruleLetVariableCS ) ) )*
            loop81:
            do {
                int alt81=2;
                int LA81_0 = input.LA(1);

                if ( (LA81_0==16) ) {
                    alt81=1;
                }


                switch (alt81) {
            	case 1 :
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4775:4: otherlv_2= ',' ( (lv_variable_3_0= ruleLetVariableCS ) )
            	    {
            	    otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleLetExpCS10880); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getLetExpCSAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4779:1: ( (lv_variable_3_0= ruleLetVariableCS ) )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4780:1: (lv_variable_3_0= ruleLetVariableCS )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4780:1: (lv_variable_3_0= ruleLetVariableCS )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4781:3: lv_variable_3_0= ruleLetVariableCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLetExpCSAccess().getVariableLetVariableCSParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleLetVariableCS_in_ruleLetExpCS10901);
            	    lv_variable_3_0=ruleLetVariableCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getLetExpCSRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"variable",
            	              		lv_variable_3_0, 
            	              		"LetVariableCS");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop81;
                }
            } while (true);

            otherlv_4=(Token)match(input,84,FollowSets000.FOLLOW_84_in_ruleLetExpCS10915); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getLetExpCSAccess().getInKeyword_3());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4801:1: ( (lv_in_5_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4802:1: (lv_in_5_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4802:1: (lv_in_5_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4803:3: lv_in_5_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetExpCSAccess().getInExpCSParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleLetExpCS10936);
            lv_in_5_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLetExpCSRule());
              	        }
                     		set(
                     			current, 
                     			"in",
                      		lv_in_5_0, 
                      		"ExpCS");
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4827:1: entryRuleLetVariableCS returns [EObject current=null] : iv_ruleLetVariableCS= ruleLetVariableCS EOF ;
    public final EObject entryRuleLetVariableCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLetVariableCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4828:2: (iv_ruleLetVariableCS= ruleLetVariableCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4829:2: iv_ruleLetVariableCS= ruleLetVariableCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLetVariableCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLetVariableCS_in_entryRuleLetVariableCS10972);
            iv_ruleLetVariableCS=ruleLetVariableCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLetVariableCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLetVariableCS10982); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4836:1: ruleLetVariableCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) ) ) ;
    public final EObject ruleLetVariableCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;

        EObject lv_initExpression_4_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4839:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4840:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4840:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4840:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4840:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4841:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4841:1: (lv_name_0_0= ruleUnrestrictedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4842:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetVariableCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleLetVariableCS11028);
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
                      		"UnrestrictedName");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4858:2: (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==23) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4858:4: otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                    {
                    otherlv_1=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleLetVariableCS11041); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getLetVariableCSAccess().getColonKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4862:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4863:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4863:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4864:3: lv_ownedType_2_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLetVariableCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleLetVariableCS11062);
                    lv_ownedType_2_0=ruleTypeExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getLetVariableCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedType",
                              		lv_ownedType_2_0, 
                              		"TypeExpCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,43,FollowSets000.FOLLOW_43_in_ruleLetVariableCS11076); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getLetVariableCSAccess().getEqualsSignKeyword_2());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4884:1: ( (lv_initExpression_4_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4885:1: (lv_initExpression_4_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4885:1: (lv_initExpression_4_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4886:3: lv_initExpression_4_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetVariableCSAccess().getInitExpressionExpCSParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleLetVariableCS11097);
            lv_initExpression_4_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLetVariableCSRule());
              	        }
                     		set(
                     			current, 
                     			"initExpression",
                      		lv_initExpression_4_0, 
                      		"ExpCS");
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4910:1: entryRuleNestedExpCS returns [EObject current=null] : iv_ruleNestedExpCS= ruleNestedExpCS EOF ;
    public final EObject entryRuleNestedExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNestedExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4911:2: (iv_ruleNestedExpCS= ruleNestedExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4912:2: iv_ruleNestedExpCS= ruleNestedExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNestedExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNestedExpCS_in_entryRuleNestedExpCS11133);
            iv_ruleNestedExpCS=ruleNestedExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNestedExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNestedExpCS11143); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4919:1: ruleNestedExpCS returns [EObject current=null] : (otherlv_0= '(' ( (lv_source_1_0= ruleExpCS ) ) otherlv_2= ')' ) ;
    public final EObject ruleNestedExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_source_1_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4922:28: ( (otherlv_0= '(' ( (lv_source_1_0= ruleExpCS ) ) otherlv_2= ')' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4923:1: (otherlv_0= '(' ( (lv_source_1_0= ruleExpCS ) ) otherlv_2= ')' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4923:1: (otherlv_0= '(' ( (lv_source_1_0= ruleExpCS ) ) otherlv_2= ')' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4923:3: otherlv_0= '(' ( (lv_source_1_0= ruleExpCS ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,65,FollowSets000.FOLLOW_65_in_ruleNestedExpCS11180); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getNestedExpCSAccess().getLeftParenthesisKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4927:1: ( (lv_source_1_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4928:1: (lv_source_1_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4928:1: (lv_source_1_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4929:3: lv_source_1_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNestedExpCSAccess().getSourceExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNestedExpCS11201);
            lv_source_1_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getNestedExpCSRule());
              	        }
                     		set(
                     			current, 
                     			"source",
                      		lv_source_1_0, 
                      		"ExpCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,66,FollowSets000.FOLLOW_66_in_ruleNestedExpCS11213); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4957:1: entryRuleSelfExpCS returns [EObject current=null] : iv_ruleSelfExpCS= ruleSelfExpCS EOF ;
    public final EObject entryRuleSelfExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelfExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4958:2: (iv_ruleSelfExpCS= ruleSelfExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4959:2: iv_ruleSelfExpCS= ruleSelfExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSelfExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSelfExpCS_in_entryRuleSelfExpCS11249);
            iv_ruleSelfExpCS=ruleSelfExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSelfExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSelfExpCS11259); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4966:1: ruleSelfExpCS returns [EObject current=null] : ( () otherlv_1= 'self' ) ;
    public final EObject ruleSelfExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4969:28: ( ( () otherlv_1= 'self' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4970:1: ( () otherlv_1= 'self' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4970:1: ( () otherlv_1= 'self' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4970:2: () otherlv_1= 'self'
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4970:2: ()
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4971:2: 
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

            otherlv_1=(Token)match(input,85,FollowSets000.FOLLOW_85_in_ruleSelfExpCS11308); if (state.failed) return current;
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

    // $ANTLR start synpred101_InternalQVTcoreBase
    public final void synpred101_InternalQVTcoreBase_fragment() throws RecognitionException {   
        EObject this_TupleLiteralExpCS_4 = null;


        // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3820:2: (this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS )
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3820:2: this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralExpCS_in_synpred101_InternalQVTcoreBase9049);
        this_TupleLiteralExpCS_4=ruleTupleLiteralExpCS();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred101_InternalQVTcoreBase

    // $ANTLR start synpred102_InternalQVTcoreBase
    public final void synpred102_InternalQVTcoreBase_fragment() throws RecognitionException {   
        EObject this_CollectionLiteralExpCS_5 = null;


        // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3833:2: (this_CollectionLiteralExpCS_5= ruleCollectionLiteralExpCS )
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3833:2: this_CollectionLiteralExpCS_5= ruleCollectionLiteralExpCS
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteralExpCS_in_synpred102_InternalQVTcoreBase9079);
        this_CollectionLiteralExpCS_5=ruleCollectionLiteralExpCS();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred102_InternalQVTcoreBase

    // $ANTLR start synpred103_InternalQVTcoreBase
    public final void synpred103_InternalQVTcoreBase_fragment() throws RecognitionException {   
        EObject this_TypeLiteralExpCS_6 = null;


        // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3846:2: (this_TypeLiteralExpCS_6= ruleTypeLiteralExpCS )
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3846:2: this_TypeLiteralExpCS_6= ruleTypeLiteralExpCS
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralExpCS_in_synpred103_InternalQVTcoreBase9109);
        this_TypeLiteralExpCS_6=ruleTypeLiteralExpCS();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred103_InternalQVTcoreBase

    // Delegated rules

    public final boolean synpred103_InternalQVTcoreBase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred103_InternalQVTcoreBase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred102_InternalQVTcoreBase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred102_InternalQVTcoreBase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred101_InternalQVTcoreBase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred101_InternalQVTcoreBase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA4 dfa4 = new DFA4(this);
    protected DFA8 dfa8 = new DFA8(this);
    protected DFA14 dfa14 = new DFA14(this);
    protected DFA53 dfa53 = new DFA53(this);
    protected DFA48 dfa48 = new DFA48(this);
    protected DFA72 dfa72 = new DFA72(this);
    static final String DFA4_eotS =
        "\20\uffff";
    static final String DFA4_eofS =
        "\1\16\17\uffff";
    static final String DFA4_minS =
        "\1\4\11\23\1\4\3\23\2\uffff";
    static final String DFA4_maxS =
        "\1\125\15\115\2\uffff";
    static final String DFA4_acceptS =
        "\16\uffff\1\2\1\1";
    static final String DFA4_specialS =
        "\20\uffff}>";
    static final String[] DFA4_transitionS = {
            "\1\1\1\2\2\16\12\uffff\1\16\2\uffff\1\6\1\15\2\uffff\1\12\1"+
            "\3\1\4\1\5\1\7\1\10\1\11\1\13\1\14\3\16\16\uffff\17\16\7\uffff"+
            "\4\16\2\uffff\1\16\3\uffff\1\16\1\uffff\1\16",
            "\2\16\2\uffff\1\17\1\16\11\uffff\2\16\1\uffff\16\16\16\uffff"+
            "\1\16\2\uffff\1\16\2\uffff\1\16\5\uffff\1\16",
            "\2\16\2\uffff\1\17\1\16\11\uffff\2\16\1\uffff\16\16\16\uffff"+
            "\1\16\2\uffff\1\16\2\uffff\1\16\5\uffff\1\16",
            "\2\16\2\uffff\1\17\1\16\11\uffff\2\16\1\uffff\16\16\16\uffff"+
            "\1\16\2\uffff\1\16\2\uffff\1\16\5\uffff\1\16",
            "\2\16\2\uffff\1\17\1\16\11\uffff\2\16\1\uffff\16\16\16\uffff"+
            "\1\16\2\uffff\1\16\2\uffff\1\16\5\uffff\1\16",
            "\2\16\2\uffff\1\17\1\16\11\uffff\2\16\1\uffff\16\16\16\uffff"+
            "\1\16\2\uffff\1\16\2\uffff\1\16\5\uffff\1\16",
            "\2\16\2\uffff\1\17\1\16\11\uffff\2\16\1\uffff\16\16\16\uffff"+
            "\1\16\2\uffff\1\16\2\uffff\1\16\5\uffff\1\16",
            "\2\16\2\uffff\1\17\1\16\11\uffff\2\16\1\uffff\16\16\16\uffff"+
            "\1\16\2\uffff\1\16\2\uffff\1\16\5\uffff\1\16",
            "\2\16\2\uffff\1\17\1\16\11\uffff\2\16\1\uffff\16\16\16\uffff"+
            "\1\16\2\uffff\1\16\2\uffff\1\16\5\uffff\1\16",
            "\2\16\2\uffff\1\17\1\16\11\uffff\2\16\1\uffff\16\16\16\uffff"+
            "\1\16\2\uffff\1\16\2\uffff\1\16\5\uffff\1\16",
            "\2\17\15\uffff\2\16\3\17\1\16\11\17\2\16\1\uffff\16\16\16"+
            "\uffff\1\16\2\uffff\1\16\2\uffff\1\16\5\uffff\1\16",
            "\2\16\2\uffff\1\17\1\16\11\uffff\2\16\1\uffff\16\16\16\uffff"+
            "\1\16\2\uffff\1\16\2\uffff\1\16\5\uffff\1\16",
            "\2\16\2\uffff\1\17\1\16\11\uffff\2\16\1\uffff\16\16\16\uffff"+
            "\1\16\2\uffff\1\16\2\uffff\1\16\5\uffff\1\16",
            "\2\16\2\uffff\1\17\1\16\11\uffff\2\16\1\uffff\16\16\16\uffff"+
            "\1\16\2\uffff\1\16\2\uffff\1\16\5\uffff\1\16",
            "",
            ""
    };

    static final short[] DFA4_eot = DFA.unpackEncodedString(DFA4_eotS);
    static final short[] DFA4_eof = DFA.unpackEncodedString(DFA4_eofS);
    static final char[] DFA4_min = DFA.unpackEncodedStringToUnsignedChars(DFA4_minS);
    static final char[] DFA4_max = DFA.unpackEncodedStringToUnsignedChars(DFA4_maxS);
    static final short[] DFA4_accept = DFA.unpackEncodedString(DFA4_acceptS);
    static final short[] DFA4_special = DFA.unpackEncodedString(DFA4_specialS);
    static final short[][] DFA4_transition;

    static {
        int numStates = DFA4_transitionS.length;
        DFA4_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA4_transition[i] = DFA.unpackEncodedString(DFA4_transitionS[i]);
        }
    }

    class DFA4 extends DFA {

        public DFA4(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 4;
            this.eot = DFA4_eot;
            this.eof = DFA4_eof;
            this.min = DFA4_min;
            this.max = DFA4_max;
            this.accept = DFA4_accept;
            this.special = DFA4_special;
            this.transition = DFA4_transition;
        }
        public String getDescription() {
            return "95:2: ( ( ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_2_0= ruleRealizedVariableCS ) ) ) (otherlv_3= ',' ( ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) ) ) )* otherlv_6= '|' )?";
        }
    }
    static final String DFA8_eotS =
        "\13\uffff";
    static final String DFA8_eofS =
        "\1\4\1\uffff\2\1\1\uffff\4\4\2\1";
    static final String DFA8_minS =
        "\1\4\1\uffff\2\4\1\uffff\6\4";
    static final String DFA8_maxS =
        "\1\41\1\uffff\2\41\1\uffff\6\41";
    static final String DFA8_acceptS =
        "\1\uffff\1\1\2\uffff\1\2\6\uffff";
    static final String DFA8_specialS =
        "\13\uffff}>";
    static final String[] DFA8_transitionS = {
            "\2\1\17\uffff\1\2\1\3\2\uffff\11\1",
            "",
            "\2\4\17\uffff\1\5\1\6\2\uffff\11\4",
            "\2\4\17\uffff\1\7\1\10\2\uffff\11\4",
            "",
            "\2\1\12\uffff\1\4\4\uffff\1\1\1\11\2\uffff\11\1",
            "\2\1\12\uffff\1\4\4\uffff\1\1\1\12\2\uffff\11\1",
            "\2\1\12\uffff\1\4\4\uffff\2\1\2\uffff\11\1",
            "\2\1\12\uffff\1\4\4\uffff\2\1\2\uffff\11\1",
            "\2\4\12\uffff\1\1\4\uffff\1\4\1\10\2\uffff\11\4",
            "\2\4\12\uffff\1\1\4\uffff\2\4\2\uffff\11\4"
    };

    static final short[] DFA8_eot = DFA.unpackEncodedString(DFA8_eotS);
    static final short[] DFA8_eof = DFA.unpackEncodedString(DFA8_eofS);
    static final char[] DFA8_min = DFA.unpackEncodedStringToUnsignedChars(DFA8_minS);
    static final char[] DFA8_max = DFA.unpackEncodedStringToUnsignedChars(DFA8_maxS);
    static final short[] DFA8_accept = DFA.unpackEncodedString(DFA8_acceptS);
    static final short[] DFA8_special = DFA.unpackEncodedString(DFA8_specialS);
    static final short[][] DFA8_transition;

    static {
        int numStates = DFA8_transitionS.length;
        DFA8_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA8_transition[i] = DFA.unpackEncodedString(DFA8_transitionS[i]);
        }
    }

    class DFA8 extends DFA {

        public DFA8(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 8;
            this.eot = DFA8_eot;
            this.eof = DFA8_eof;
            this.min = DFA8_min;
            this.max = DFA8_max;
            this.accept = DFA8_accept;
            this.special = DFA8_special;
            this.transition = DFA8_transition;
        }
        public String getDescription() {
            return "305:2: ( (lv_name_1_0= ruleUnrestrictedName ) )?";
        }
    }
    static final String DFA14_eotS =
        "\20\uffff";
    static final String DFA14_eofS =
        "\1\16\17\uffff";
    static final String DFA14_minS =
        "\1\4\15\23\2\uffff";
    static final String DFA14_maxS =
        "\1\125\15\115\2\uffff";
    static final String DFA14_acceptS =
        "\16\uffff\1\2\1\1";
    static final String DFA14_specialS =
        "\20\uffff}>";
    static final String[] DFA14_transitionS = {
            "\1\1\1\2\2\16\12\uffff\1\16\2\uffff\1\6\1\15\2\uffff\1\12\1"+
            "\3\1\4\1\5\1\7\1\10\1\11\1\13\1\14\3\16\16\uffff\17\16\7\uffff"+
            "\4\16\2\uffff\1\16\3\uffff\1\16\1\uffff\1\16",
            "\2\16\2\uffff\1\17\1\16\11\uffff\2\16\1\uffff\16\16\16\uffff"+
            "\1\16\2\uffff\1\16\2\uffff\1\16\5\uffff\1\16",
            "\2\16\2\uffff\1\17\1\16\11\uffff\2\16\1\uffff\16\16\16\uffff"+
            "\1\16\2\uffff\1\16\2\uffff\1\16\5\uffff\1\16",
            "\2\16\2\uffff\1\17\1\16\11\uffff\2\16\1\uffff\16\16\16\uffff"+
            "\1\16\2\uffff\1\16\2\uffff\1\16\5\uffff\1\16",
            "\2\16\2\uffff\1\17\1\16\11\uffff\2\16\1\uffff\16\16\16\uffff"+
            "\1\16\2\uffff\1\16\2\uffff\1\16\5\uffff\1\16",
            "\2\16\2\uffff\1\17\1\16\11\uffff\2\16\1\uffff\16\16\16\uffff"+
            "\1\16\2\uffff\1\16\2\uffff\1\16\5\uffff\1\16",
            "\2\16\2\uffff\1\17\1\16\11\uffff\2\16\1\uffff\16\16\16\uffff"+
            "\1\16\2\uffff\1\16\2\uffff\1\16\5\uffff\1\16",
            "\2\16\2\uffff\1\17\1\16\11\uffff\2\16\1\uffff\16\16\16\uffff"+
            "\1\16\2\uffff\1\16\2\uffff\1\16\5\uffff\1\16",
            "\2\16\2\uffff\1\17\1\16\11\uffff\2\16\1\uffff\16\16\16\uffff"+
            "\1\16\2\uffff\1\16\2\uffff\1\16\5\uffff\1\16",
            "\2\16\2\uffff\1\17\1\16\11\uffff\2\16\1\uffff\16\16\16\uffff"+
            "\1\16\2\uffff\1\16\2\uffff\1\16\5\uffff\1\16",
            "\2\16\2\uffff\1\17\1\16\11\uffff\2\16\1\uffff\16\16\16\uffff"+
            "\1\16\2\uffff\1\16\2\uffff\1\16\5\uffff\1\16",
            "\2\16\2\uffff\1\17\1\16\11\uffff\2\16\1\uffff\16\16\16\uffff"+
            "\1\16\2\uffff\1\16\2\uffff\1\16\5\uffff\1\16",
            "\2\16\2\uffff\1\17\1\16\11\uffff\2\16\1\uffff\16\16\16\uffff"+
            "\1\16\2\uffff\1\16\2\uffff\1\16\5\uffff\1\16",
            "\2\16\2\uffff\1\17\1\16\11\uffff\2\16\1\uffff\16\16\16\uffff"+
            "\1\16\2\uffff\1\16\2\uffff\1\16\5\uffff\1\16",
            "",
            ""
    };

    static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);
    static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);
    static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);
    static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);
    static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);
    static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);
    static final short[][] DFA14_transition;

    static {
        int numStates = DFA14_transitionS.length;
        DFA14_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
        }
    }

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = DFA14_eot;
            this.eof = DFA14_eof;
            this.min = DFA14_min;
            this.max = DFA14_max;
            this.accept = DFA14_accept;
            this.special = DFA14_special;
            this.transition = DFA14_transition;
        }
        public String getDescription() {
            return "441:2: ( ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) (otherlv_2= ',' ( (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS ) ) )* otherlv_4= '|' )?";
        }
    }
    static final String DFA53_eotS =
        "\6\uffff";
    static final String DFA53_eofS =
        "\6\uffff";
    static final String DFA53_minS =
        "\3\4\3\uffff";
    static final String DFA53_maxS =
        "\3\125\3\uffff";
    static final String DFA53_acceptS =
        "\3\uffff\1\1\1\3\1\2";
    static final String DFA53_specialS =
        "\6\uffff}>";
    static final String[] DFA53_transitionS = {
            "\4\3\15\uffff\2\3\2\uffff\12\3\1\1\1\2\16\uffff\17\3\7\uffff"+
            "\4\3\2\uffff\1\3\3\uffff\1\4\1\uffff\1\3",
            "\4\3\15\uffff\2\3\2\uffff\12\3\1\1\1\2\16\uffff\17\3\7\uffff"+
            "\4\3\2\uffff\1\3\3\uffff\1\5\1\uffff\1\3",
            "\4\3\15\uffff\2\3\2\uffff\12\3\1\1\1\2\16\uffff\17\3\7\uffff"+
            "\4\3\2\uffff\1\3\3\uffff\1\5\1\uffff\1\3",
            "",
            "",
            ""
    };

    static final short[] DFA53_eot = DFA.unpackEncodedString(DFA53_eotS);
    static final short[] DFA53_eof = DFA.unpackEncodedString(DFA53_eofS);
    static final char[] DFA53_min = DFA.unpackEncodedStringToUnsignedChars(DFA53_minS);
    static final char[] DFA53_max = DFA.unpackEncodedStringToUnsignedChars(DFA53_maxS);
    static final short[] DFA53_accept = DFA.unpackEncodedString(DFA53_acceptS);
    static final short[] DFA53_special = DFA.unpackEncodedString(DFA53_specialS);
    static final short[][] DFA53_transition;

    static {
        int numStates = DFA53_transitionS.length;
        DFA53_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA53_transition[i] = DFA.unpackEncodedString(DFA53_transitionS[i]);
        }
    }

    class DFA53 extends DFA {

        public DFA53(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 53;
            this.eot = DFA53_eot;
            this.eof = DFA53_eof;
            this.min = DFA53_min;
            this.max = DFA53_max;
            this.accept = DFA53_accept;
            this.special = DFA53_special;
            this.transition = DFA53_transition;
        }
        public String getDescription() {
            return "3297:1: ( (this_PrefixedExpCS_0= rulePrefixedExpCS ( () ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? ) | ( (lv_ownedExpression_8_0= ruleLetExpCS ) ) ) )? ) | ( () ( (lv_ownedOperator_10_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_11_0= ruleLetExpCS ) ) ) | this_LetExpCS_12= ruleLetExpCS )";
        }
    }
    static final String DFA48_eotS =
        "\23\uffff";
    static final String DFA48_eofS =
        "\1\21\22\uffff";
    static final String DFA48_minS =
        "\1\20\20\4\2\uffff";
    static final String DFA48_maxS =
        "\1\124\20\125\2\uffff";
    static final String DFA48_acceptS =
        "\21\uffff\1\2\1\1";
    static final String DFA48_specialS =
        "\23\uffff}>";
    static final String[] DFA48_transitionS = {
            "\2\21\1\uffff\2\21\2\uffff\1\21\12\uffff\1\1\1\4\1\uffff\1"+
            "\2\1\3\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1"+
            "\20\17\uffff\2\21\1\uffff\1\21\2\uffff\1\21\7\uffff\3\21\1\uffff"+
            "\1\21",
            "\4\22\15\uffff\2\22\2\uffff\14\22\16\uffff\17\22\7\uffff\4"+
            "\22\2\uffff\1\22\3\uffff\1\21\1\uffff\1\22",
            "\4\22\15\uffff\2\22\2\uffff\14\22\16\uffff\17\22\7\uffff\4"+
            "\22\2\uffff\1\22\3\uffff\1\21\1\uffff\1\22",
            "\4\22\15\uffff\2\22\2\uffff\14\22\16\uffff\17\22\7\uffff\4"+
            "\22\2\uffff\1\22\3\uffff\1\21\1\uffff\1\22",
            "\4\22\15\uffff\2\22\2\uffff\14\22\16\uffff\17\22\7\uffff\4"+
            "\22\2\uffff\1\22\3\uffff\1\21\1\uffff\1\22",
            "\4\22\15\uffff\2\22\2\uffff\14\22\16\uffff\17\22\7\uffff\4"+
            "\22\2\uffff\1\22\3\uffff\1\21\1\uffff\1\22",
            "\4\22\15\uffff\2\22\2\uffff\14\22\16\uffff\17\22\7\uffff\4"+
            "\22\2\uffff\1\22\3\uffff\1\21\1\uffff\1\22",
            "\4\22\15\uffff\2\22\2\uffff\14\22\16\uffff\17\22\7\uffff\4"+
            "\22\2\uffff\1\22\3\uffff\1\21\1\uffff\1\22",
            "\4\22\15\uffff\2\22\2\uffff\14\22\16\uffff\17\22\7\uffff\4"+
            "\22\2\uffff\1\22\3\uffff\1\21\1\uffff\1\22",
            "\4\22\15\uffff\2\22\2\uffff\14\22\16\uffff\17\22\7\uffff\4"+
            "\22\2\uffff\1\22\3\uffff\1\21\1\uffff\1\22",
            "\4\22\15\uffff\2\22\2\uffff\14\22\16\uffff\17\22\7\uffff\4"+
            "\22\2\uffff\1\22\3\uffff\1\21\1\uffff\1\22",
            "\4\22\15\uffff\2\22\2\uffff\14\22\16\uffff\17\22\7\uffff\4"+
            "\22\2\uffff\1\22\3\uffff\1\21\1\uffff\1\22",
            "\4\22\15\uffff\2\22\2\uffff\14\22\16\uffff\17\22\7\uffff\4"+
            "\22\2\uffff\1\22\3\uffff\1\21\1\uffff\1\22",
            "\4\22\15\uffff\2\22\2\uffff\14\22\16\uffff\17\22\7\uffff\4"+
            "\22\2\uffff\1\22\3\uffff\1\21\1\uffff\1\22",
            "\4\22\15\uffff\2\22\2\uffff\14\22\16\uffff\17\22\7\uffff\4"+
            "\22\2\uffff\1\22\3\uffff\1\21\1\uffff\1\22",
            "\4\22\15\uffff\2\22\2\uffff\14\22\16\uffff\17\22\7\uffff\4"+
            "\22\2\uffff\1\22\3\uffff\1\21\1\uffff\1\22",
            "\4\22\15\uffff\2\22\2\uffff\14\22\16\uffff\17\22\7\uffff\4"+
            "\22\2\uffff\1\22\3\uffff\1\21\1\uffff\1\22",
            "",
            ""
    };

    static final short[] DFA48_eot = DFA.unpackEncodedString(DFA48_eotS);
    static final short[] DFA48_eof = DFA.unpackEncodedString(DFA48_eofS);
    static final char[] DFA48_min = DFA.unpackEncodedStringToUnsignedChars(DFA48_minS);
    static final char[] DFA48_max = DFA.unpackEncodedStringToUnsignedChars(DFA48_maxS);
    static final short[] DFA48_accept = DFA.unpackEncodedString(DFA48_acceptS);
    static final short[] DFA48_special = DFA.unpackEncodedString(DFA48_specialS);
    static final short[][] DFA48_transition;

    static {
        int numStates = DFA48_transitionS.length;
        DFA48_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA48_transition[i] = DFA.unpackEncodedString(DFA48_transitionS[i]);
        }
    }

    class DFA48 extends DFA {

        public DFA48(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 48;
            this.eot = DFA48_eot;
            this.eof = DFA48_eof;
            this.min = DFA48_min;
            this.max = DFA48_max;
            this.accept = DFA48_accept;
            this.special = DFA48_special;
            this.transition = DFA48_transition;
        }
        public String getDescription() {
            return "()* loopback of 3354:2: ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )*";
        }
    }
    static final String DFA72_eotS =
        "\50\uffff";
    static final String DFA72_eofS =
        "\50\uffff";
    static final String DFA72_minS =
        "\1\4\12\uffff\6\0\27\uffff";
    static final String DFA72_maxS =
        "\1\125\12\uffff\6\0\27\uffff";
    static final String DFA72_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\14\uffff\1\7\7\uffff\1\10\14\uffff\1\5"+
        "\1\6";
    static final String DFA72_specialS =
        "\13\uffff\1\0\1\1\1\2\1\3\1\4\1\5\27\uffff}>";
    static final String[] DFA72_transitionS = {
            "\2\31\2\4\15\uffff\2\31\2\uffff\11\31\1\4\20\uffff\1\13\10"+
            "\21\1\14\1\15\1\16\1\17\1\20\1\1\7\uffff\4\4\2\uffff\1\2\5\uffff"+
            "\1\3",
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

    static final short[] DFA72_eot = DFA.unpackEncodedString(DFA72_eotS);
    static final short[] DFA72_eof = DFA.unpackEncodedString(DFA72_eofS);
    static final char[] DFA72_min = DFA.unpackEncodedStringToUnsignedChars(DFA72_minS);
    static final char[] DFA72_max = DFA.unpackEncodedStringToUnsignedChars(DFA72_maxS);
    static final short[] DFA72_accept = DFA.unpackEncodedString(DFA72_acceptS);
    static final short[] DFA72_special = DFA.unpackEncodedString(DFA72_specialS);
    static final short[][] DFA72_transition;

    static {
        int numStates = DFA72_transitionS.length;
        DFA72_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA72_transition[i] = DFA.unpackEncodedString(DFA72_transitionS[i]);
        }
    }

    class DFA72 extends DFA {

        public DFA72(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 72;
            this.eot = DFA72_eot;
            this.eof = DFA72_eof;
            this.min = DFA72_min;
            this.max = DFA72_max;
            this.accept = DFA72_accept;
            this.special = DFA72_special;
            this.transition = DFA72_transition;
        }
        public String getDescription() {
            return "3767:1: (this_NestedExpCS_0= ruleNestedExpCS | this_IfExpCS_1= ruleIfExpCS | this_SelfExpCS_2= ruleSelfExpCS | this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS | this_CollectionLiteralExpCS_5= ruleCollectionLiteralExpCS | this_TypeLiteralExpCS_6= ruleTypeLiteralExpCS | ( () ( (lv_pathName_8_0= rulePathNameCS ) ) ( ( () otherlv_10= '[' ( (lv_firstIndexes_11_0= ruleExpCS ) ) (otherlv_12= ',' ( (lv_firstIndexes_13_0= ruleExpCS ) ) )* otherlv_14= ']' (otherlv_15= '[' ( (lv_secondIndexes_16_0= ruleExpCS ) ) (otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) ) )* otherlv_19= ']' )? ( ( (lv_atPre_20_0= '@' ) ) otherlv_21= 'pre' )? ) | ( () otherlv_23= '{' ( ( ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )* ) | ( (lv_value_27_0= ruleStringLiteral ) ) ) otherlv_28= '}' ) | ( ( ( (lv_atPre_29_0= '@' ) ) otherlv_30= 'pre' )? ( () otherlv_32= '(' ( ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_39= ')' )? ) ) ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA72_11 = input.LA(1);

                         
                        int index72_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred101_InternalQVTcoreBase()) ) {s = 38;}

                        else if ( (synpred103_InternalQVTcoreBase()) ) {s = 17;}

                         
                        input.seek(index72_11);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA72_12 = input.LA(1);

                         
                        int index72_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred102_InternalQVTcoreBase()) ) {s = 39;}

                        else if ( (synpred103_InternalQVTcoreBase()) ) {s = 17;}

                         
                        input.seek(index72_12);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA72_13 = input.LA(1);

                         
                        int index72_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred102_InternalQVTcoreBase()) ) {s = 39;}

                        else if ( (synpred103_InternalQVTcoreBase()) ) {s = 17;}

                         
                        input.seek(index72_13);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA72_14 = input.LA(1);

                         
                        int index72_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred102_InternalQVTcoreBase()) ) {s = 39;}

                        else if ( (synpred103_InternalQVTcoreBase()) ) {s = 17;}

                         
                        input.seek(index72_14);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA72_15 = input.LA(1);

                         
                        int index72_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred102_InternalQVTcoreBase()) ) {s = 39;}

                        else if ( (synpred103_InternalQVTcoreBase()) ) {s = 17;}

                         
                        input.seek(index72_15);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA72_16 = input.LA(1);

                         
                        int index72_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred102_InternalQVTcoreBase()) ) {s = 39;}

                        else if ( (synpred103_InternalQVTcoreBase()) ) {s = 17;}

                         
                        input.seek(index72_16);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 72, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleBottomPatternCS_in_entryRuleBottomPatternCS81 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBottomPatternCS91 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrealizedVariableCS_in_ruleBottomPatternCS151 = new BitSet(new long[]{0x0000000000030000L});
        public static final BitSet FOLLOW_ruleRealizedVariableCS_in_ruleBottomPatternCS178 = new BitSet(new long[]{0x0000000000030000L});
        public static final BitSet FOLLOW_16_in_ruleBottomPatternCS192 = new BitSet(new long[]{0x00000003FE600030L});
        public static final BitSet FOLLOW_ruleUnrealizedVariableCS_in_ruleBottomPatternCS214 = new BitSet(new long[]{0x0000000000030000L});
        public static final BitSet FOLLOW_ruleRealizedVariableCS_in_ruleBottomPatternCS241 = new BitSet(new long[]{0x0000000000030000L});
        public static final BitSet FOLLOW_17_in_ruleBottomPatternCS256 = new BitSet(new long[]{0xFFF8001FFE6400F2L,0x0000000000289E03L});
        public static final BitSet FOLLOW_ruleAssignmentCS_in_ruleBottomPatternCS279 = new BitSet(new long[]{0xFFF8001FFE6400F2L,0x0000000000289E03L});
        public static final BitSet FOLLOW_ruleAssignmentCS_in_entryRuleAssignmentCS316 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAssignmentCS326 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleAssignmentCS369 = new BitSet(new long[]{0xFFF8001FFE6400F0L,0x0000000000289E03L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleAssignmentCS404 = new BitSet(new long[]{0x0000000000180000L});
        public static final BitSet FOLLOW_19_in_ruleAssignmentCS417 = new BitSet(new long[]{0xFFF8001FFE6400F0L,0x0000000000289E03L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleAssignmentCS438 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleAssignmentCS452 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDirectionCS_in_entryRuleDirectionCS488 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDirectionCS498 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleDirectionCS556 = new BitSet(new long[]{0x0000000000600002L});
        public static final BitSet FOLLOW_21_in_ruleDirectionCS570 = new BitSet(new long[]{0x00000003FE600030L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleDirectionCS597 = new BitSet(new long[]{0x0000000000410002L});
        public static final BitSet FOLLOW_16_in_ruleDirectionCS610 = new BitSet(new long[]{0x00000003FE600030L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleDirectionCS637 = new BitSet(new long[]{0x0000000000410002L});
        public static final BitSet FOLLOW_22_in_ruleDirectionCS654 = new BitSet(new long[]{0x00000003FE600030L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleDirectionCS681 = new BitSet(new long[]{0x0000000000010002L});
        public static final BitSet FOLLOW_16_in_ruleDirectionCS694 = new BitSet(new long[]{0x00000003FE600030L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleDirectionCS721 = new BitSet(new long[]{0x0000000000010002L});
        public static final BitSet FOLLOW_ruleGuardPatternCS_in_entryRuleGuardPatternCS761 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleGuardPatternCS771 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrealizedVariableCS_in_ruleGuardPatternCS830 = new BitSet(new long[]{0x0000000000030000L});
        public static final BitSet FOLLOW_16_in_ruleGuardPatternCS843 = new BitSet(new long[]{0x00000003FE600030L});
        public static final BitSet FOLLOW_ruleUnrealizedVariableCS_in_ruleGuardPatternCS864 = new BitSet(new long[]{0x0000000000030000L});
        public static final BitSet FOLLOW_17_in_ruleGuardPatternCS878 = new BitSet(new long[]{0xFFF8001FFE6400F2L,0x0000000000289E03L});
        public static final BitSet FOLLOW_ruleAssignmentCS_in_ruleGuardPatternCS901 = new BitSet(new long[]{0xFFF8001FFE6400F2L,0x0000000000289E03L});
        public static final BitSet FOLLOW_ruleParamDeclarationCS_in_entryRuleParamDeclarationCS944 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParamDeclarationCS954 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleParamDeclarationCS1000 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleParamDeclarationCS1012 = new BitSet(new long[]{0xFFF8001FFE6000F0L,0x0000000000209E03L});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleParamDeclarationCS1033 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScopeNameCS_in_entryRuleScopeNameCS1071 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleScopeNameCS1081 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFirstPathElementCS_in_ruleScopeNameCS1127 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleScopeNameCS1139 = new BitSet(new long[]{0xFFF80003FE600032L,0x0000000000000001L});
        public static final BitSet FOLLOW_ruleNextPathElementCS_in_ruleScopeNameCS1161 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleScopeNameCS1173 = new BitSet(new long[]{0xFFF80003FE600032L,0x0000000000000001L});
        public static final BitSet FOLLOW_ruleUnrealizedVariableCS_in_entryRuleUnrealizedVariableCS1213 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnrealizedVariableCS1223 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleUnrealizedVariableCS1269 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleUnrealizedVariableCS1281 = new BitSet(new long[]{0xFFF8001FFE6000F0L,0x0000000000209E03L});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleUnrealizedVariableCS1302 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRealizedVariableCS_in_entryRuleRealizedVariableCS1338 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRealizedVariableCS1348 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_ruleRealizedVariableCS1385 = new BitSet(new long[]{0x00000003FE600030L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleRealizedVariableCS1406 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleRealizedVariableCS1418 = new BitSet(new long[]{0xFFF8001FFE6000F0L,0x0000000000209E03L});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleRealizedVariableCS1439 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_entryRuleUnrestrictedName1478 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnrestrictedName1489 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLUnrestrictedName_in_ruleUnrestrictedName1536 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_ruleUnrestrictedName1560 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_ruleUnrestrictedName1579 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_ruleUnrestrictedName1598 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_ruleUnrestrictedName1617 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_ruleUnrestrictedName1636 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_ruleUnrestrictedName1655 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_ruleUnrestrictedName1674 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_ruleUnrestrictedName1693 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_ruleUnrestrictedName1712 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_ruleUnrestrictedName1731 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleUnrestrictedName1750 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleID_in_entryRuleID1793 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleID1804 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_SIMPLE_ID_in_ruleID1844 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ESCAPED_ID_in_ruleID1870 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLOWER_in_entryRuleLOWER1916 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLOWER1927 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleLOWER1966 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUPPER_in_entryRuleUPPER2011 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUPPER2022 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleUPPER2062 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_ruleUPPER2086 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNUMBER_LITERAL_in_entryRuleNUMBER_LITERAL2127 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNUMBER_LITERAL2138 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleNUMBER_LITERAL2177 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleURI_in_entryRuleURI2222 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleURI2233 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_SINGLE_QUOTED_STRING_in_ruleURI2272 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLPrefixOperator_in_entryRuleEssentialOCLPrefixOperator2319 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEssentialOCLPrefixOperator2330 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_ruleEssentialOCLPrefixOperator2368 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_ruleEssentialOCLPrefixOperator2387 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLInfixOperator_in_entryRuleEssentialOCLInfixOperator2428 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEssentialOCLInfixOperator2439 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_ruleEssentialOCLInfixOperator2477 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_ruleEssentialOCLInfixOperator2496 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_ruleEssentialOCLInfixOperator2515 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_ruleEssentialOCLInfixOperator2534 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_39_in_ruleEssentialOCLInfixOperator2553 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_40_in_ruleEssentialOCLInfixOperator2572 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_41_in_ruleEssentialOCLInfixOperator2591 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_42_in_ruleEssentialOCLInfixOperator2610 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_43_in_ruleEssentialOCLInfixOperator2629 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_44_in_ruleEssentialOCLInfixOperator2648 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_45_in_ruleEssentialOCLInfixOperator2667 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_46_in_ruleEssentialOCLInfixOperator2686 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_47_in_ruleEssentialOCLInfixOperator2705 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_48_in_ruleEssentialOCLInfixOperator2724 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLNavigationOperator_in_entryRuleEssentialOCLNavigationOperator2765 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEssentialOCLNavigationOperator2776 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_49_in_ruleEssentialOCLNavigationOperator2814 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_50_in_ruleEssentialOCLNavigationOperator2833 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_entryRuleIdentifier2874 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIdentifier2885 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleID_in_ruleIdentifier2931 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral2976 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteral2987 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_SINGLE_QUOTED_STRING_in_ruleStringLiteral3026 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrefixOperator_in_entryRulePrefixOperator3071 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrefixOperator3082 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLPrefixOperator_in_rulePrefixOperator3128 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInfixOperator_in_entryRuleInfixOperator3173 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleInfixOperator3184 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLInfixOperator_in_ruleInfixOperator3230 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigationOperator_in_entryRuleNavigationOperator3275 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigationOperator3286 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLNavigationOperator_in_ruleNavigationOperator3332 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLUnrestrictedName_in_entryRuleEssentialOCLUnrestrictedName3377 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEssentialOCLUnrestrictedName3388 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_ruleEssentialOCLUnrestrictedName3434 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLUnreservedName_in_entryRuleEssentialOCLUnreservedName3479 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEssentialOCLUnreservedName3490 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleEssentialOCLUnreservedName3537 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionTypeIdentifier_in_ruleEssentialOCLUnreservedName3570 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveTypeIdentifier_in_ruleEssentialOCLUnreservedName3603 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_51_in_ruleEssentialOCLUnreservedName3627 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnreservedName_in_entryRuleUnreservedName3668 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnreservedName3679 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLUnreservedName_in_ruleUnreservedName3725 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePathNameCS_in_entryRulePathNameCS3769 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePathNameCS3779 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFirstPathElementCS_in_rulePathNameCS3825 = new BitSet(new long[]{0x0000000001000002L});
        public static final BitSet FOLLOW_24_in_rulePathNameCS3838 = new BitSet(new long[]{0xFFF80003FE600030L,0x0000000000000001L});
        public static final BitSet FOLLOW_ruleNextPathElementCS_in_rulePathNameCS3859 = new BitSet(new long[]{0x0000000001000002L});
        public static final BitSet FOLLOW_ruleFirstPathElementCS_in_entryRuleFirstPathElementCS3897 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFirstPathElementCS3907 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleFirstPathElementCS3958 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNextPathElementCS_in_entryRuleNextPathElementCS3993 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNextPathElementCS4003 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnreservedName_in_ruleNextPathElementCS4054 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleURIPathNameCS_in_entryRuleURIPathNameCS4089 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleURIPathNameCS4099 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleURIFirstPathElementCS_in_ruleURIPathNameCS4145 = new BitSet(new long[]{0x0000000001000002L});
        public static final BitSet FOLLOW_24_in_ruleURIPathNameCS4158 = new BitSet(new long[]{0xFFF80003FE600030L,0x0000000000000001L});
        public static final BitSet FOLLOW_ruleNextPathElementCS_in_ruleURIPathNameCS4179 = new BitSet(new long[]{0x0000000001000002L});
        public static final BitSet FOLLOW_ruleURIFirstPathElementCS_in_entryRuleURIFirstPathElementCS4217 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleURIFirstPathElementCS4227 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleURIFirstPathElementCS4279 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleURI_in_ruleURIFirstPathElementCS4325 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveTypeIdentifier_in_entryRulePrimitiveTypeIdentifier4363 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrimitiveTypeIdentifier4374 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_52_in_rulePrimitiveTypeIdentifier4412 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_53_in_rulePrimitiveTypeIdentifier4431 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_54_in_rulePrimitiveTypeIdentifier4450 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_55_in_rulePrimitiveTypeIdentifier4469 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_56_in_rulePrimitiveTypeIdentifier4488 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_57_in_rulePrimitiveTypeIdentifier4507 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_58_in_rulePrimitiveTypeIdentifier4526 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_59_in_rulePrimitiveTypeIdentifier4545 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveTypeCS_in_entryRulePrimitiveTypeCS4585 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrimitiveTypeCS4595 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveTypeIdentifier_in_rulePrimitiveTypeCS4640 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionTypeIdentifier_in_entryRuleCollectionTypeIdentifier4676 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCollectionTypeIdentifier4687 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_60_in_ruleCollectionTypeIdentifier4725 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_61_in_ruleCollectionTypeIdentifier4744 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_62_in_ruleCollectionTypeIdentifier4763 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_63_in_ruleCollectionTypeIdentifier4782 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_64_in_ruleCollectionTypeIdentifier4801 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionTypeCS_in_entryRuleCollectionTypeCS4841 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCollectionTypeCS4851 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionTypeIdentifier_in_ruleCollectionTypeCS4897 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000002L});
        public static final BitSet FOLLOW_65_in_ruleCollectionTypeCS4910 = new BitSet(new long[]{0xFFF8001FFE6000F0L,0x0000000000209E03L});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleCollectionTypeCS4931 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
        public static final BitSet FOLLOW_66_in_ruleCollectionTypeCS4943 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiplicityBoundsCS_in_entryRuleMultiplicityBoundsCS4981 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicityBoundsCS4991 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLOWER_in_ruleMultiplicityBoundsCS5037 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000008L});
        public static final BitSet FOLLOW_67_in_ruleMultiplicityBoundsCS5050 = new BitSet(new long[]{0x0000000400000040L});
        public static final BitSet FOLLOW_ruleUPPER_in_ruleMultiplicityBoundsCS5071 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiplicityCS_in_entryRuleMultiplicityCS5109 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicityCS5119 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_68_in_ruleMultiplicityCS5156 = new BitSet(new long[]{0x0000004400000040L,0x0000000000000040L});
        public static final BitSet FOLLOW_ruleMultiplicityBoundsCS_in_ruleMultiplicityCS5182 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
        public static final BitSet FOLLOW_ruleMultiplicityStringCS_in_ruleMultiplicityCS5212 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
        public static final BitSet FOLLOW_69_in_ruleMultiplicityCS5224 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiplicityStringCS_in_entryRuleMultiplicityStringCS5260 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicityStringCS5270 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_ruleMultiplicityStringCS5314 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_ruleMultiplicityStringCS5343 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_70_in_ruleMultiplicityStringCS5372 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTupleTypeCS_in_entryRuleTupleTypeCS5423 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTupleTypeCS5433 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_51_in_ruleTupleTypeCS5476 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000002L});
        public static final BitSet FOLLOW_65_in_ruleTupleTypeCS5502 = new BitSet(new long[]{0x00000003FE600030L,0x0000000000000004L});
        public static final BitSet FOLLOW_ruleTuplePartCS_in_ruleTupleTypeCS5524 = new BitSet(new long[]{0x0000000000010000L,0x0000000000000004L});
        public static final BitSet FOLLOW_16_in_ruleTupleTypeCS5537 = new BitSet(new long[]{0x00000003FE600030L});
        public static final BitSet FOLLOW_ruleTuplePartCS_in_ruleTupleTypeCS5558 = new BitSet(new long[]{0x0000000000010000L,0x0000000000000004L});
        public static final BitSet FOLLOW_66_in_ruleTupleTypeCS5574 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTuplePartCS_in_entryRuleTuplePartCS5612 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTuplePartCS5622 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleTuplePartCS5668 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleTuplePartCS5680 = new BitSet(new long[]{0xFFF8001FFE6000F0L,0x0000000000209E03L});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleTuplePartCS5701 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionLiteralExpCS_in_entryRuleCollectionLiteralExpCS5737 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCollectionLiteralExpCS5747 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionTypeCS_in_ruleCollectionLiteralExpCS5793 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
        public static final BitSet FOLLOW_71_in_ruleCollectionLiteralExpCS5805 = new BitSet(new long[]{0xFFF8001FFE6400F0L,0x0000000000289F03L});
        public static final BitSet FOLLOW_ruleCollectionLiteralPartCS_in_ruleCollectionLiteralExpCS5827 = new BitSet(new long[]{0x0000000000010000L,0x0000000000000100L});
        public static final BitSet FOLLOW_16_in_ruleCollectionLiteralExpCS5840 = new BitSet(new long[]{0xFFF8001FFE6400F0L,0x0000000000289E03L});
        public static final BitSet FOLLOW_ruleCollectionLiteralPartCS_in_ruleCollectionLiteralExpCS5861 = new BitSet(new long[]{0x0000000000010000L,0x0000000000000100L});
        public static final BitSet FOLLOW_72_in_ruleCollectionLiteralExpCS5877 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionLiteralPartCS_in_entryRuleCollectionLiteralPartCS5913 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCollectionLiteralPartCS5923 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleCollectionLiteralPartCS5969 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000008L});
        public static final BitSet FOLLOW_67_in_ruleCollectionLiteralPartCS5982 = new BitSet(new long[]{0xFFF8001FFE6400F0L,0x0000000000289E03L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleCollectionLiteralPartCS6003 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConstructorPartCS_in_entryRuleConstructorPartCS6041 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleConstructorPartCS6051 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleConstructorPartCS6103 = new BitSet(new long[]{0x0000080000000000L});
        public static final BitSet FOLLOW_43_in_ruleConstructorPartCS6115 = new BitSet(new long[]{0xFFF8001FFE6400F0L,0x0000000000289E03L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleConstructorPartCS6136 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveLiteralExpCS_in_entryRulePrimitiveLiteralExpCS6172 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrimitiveLiteralExpCS6182 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNumberLiteralExpCS_in_rulePrimitiveLiteralExpCS6232 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringLiteralExpCS_in_rulePrimitiveLiteralExpCS6262 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBooleanLiteralExpCS_in_rulePrimitiveLiteralExpCS6292 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnlimitedNaturalLiteralExpCS_in_rulePrimitiveLiteralExpCS6322 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInvalidLiteralExpCS_in_rulePrimitiveLiteralExpCS6352 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNullLiteralExpCS_in_rulePrimitiveLiteralExpCS6382 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTupleLiteralExpCS_in_entryRuleTupleLiteralExpCS6417 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTupleLiteralExpCS6427 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_51_in_ruleTupleLiteralExpCS6464 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
        public static final BitSet FOLLOW_71_in_ruleTupleLiteralExpCS6476 = new BitSet(new long[]{0x00000003FE600030L});
        public static final BitSet FOLLOW_ruleTupleLiteralPartCS_in_ruleTupleLiteralExpCS6497 = new BitSet(new long[]{0x0000000000010000L,0x0000000000000100L});
        public static final BitSet FOLLOW_16_in_ruleTupleLiteralExpCS6510 = new BitSet(new long[]{0x00000003FE600030L});
        public static final BitSet FOLLOW_ruleTupleLiteralPartCS_in_ruleTupleLiteralExpCS6531 = new BitSet(new long[]{0x0000000000010000L,0x0000000000000100L});
        public static final BitSet FOLLOW_72_in_ruleTupleLiteralExpCS6545 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTupleLiteralPartCS_in_entryRuleTupleLiteralPartCS6581 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTupleLiteralPartCS6591 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleTupleLiteralPartCS6637 = new BitSet(new long[]{0x0000080000800000L});
        public static final BitSet FOLLOW_23_in_ruleTupleLiteralPartCS6650 = new BitSet(new long[]{0xFFF8001FFE6000F0L,0x0000000000209E03L});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleTupleLiteralPartCS6671 = new BitSet(new long[]{0x0000080000000000L});
        public static final BitSet FOLLOW_43_in_ruleTupleLiteralPartCS6685 = new BitSet(new long[]{0xFFF8001FFE6400F0L,0x0000000000289E03L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleTupleLiteralPartCS6706 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNumberLiteralExpCS_in_entryRuleNumberLiteralExpCS6742 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNumberLiteralExpCS6752 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNUMBER_LITERAL_in_ruleNumberLiteralExpCS6797 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringLiteralExpCS_in_entryRuleStringLiteralExpCS6832 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteralExpCS6842 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringLiteral_in_ruleStringLiteralExpCS6887 = new BitSet(new long[]{0x0000000000000082L});
        public static final BitSet FOLLOW_ruleBooleanLiteralExpCS_in_entryRuleBooleanLiteralExpCS6923 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBooleanLiteralExpCS6933 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_73_in_ruleBooleanLiteralExpCS6976 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_74_in_ruleBooleanLiteralExpCS7013 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnlimitedNaturalLiteralExpCS_in_entryRuleUnlimitedNaturalLiteralExpCS7062 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnlimitedNaturalLiteralExpCS7072 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_ruleUnlimitedNaturalLiteralExpCS7121 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInvalidLiteralExpCS_in_entryRuleInvalidLiteralExpCS7157 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleInvalidLiteralExpCS7167 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_75_in_ruleInvalidLiteralExpCS7216 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNullLiteralExpCS_in_entryRuleNullLiteralExpCS7252 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNullLiteralExpCS7262 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_76_in_ruleNullLiteralExpCS7311 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralCS_in_entryRuleTypeLiteralCS7347 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeLiteralCS7357 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveTypeCS_in_ruleTypeLiteralCS7407 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionTypeCS_in_ruleTypeLiteralCS7437 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTupleTypeCS_in_ruleTypeLiteralCS7467 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralWithMultiplicityCS_in_entryRuleTypeLiteralWithMultiplicityCS7502 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeLiteralWithMultiplicityCS7512 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralCS_in_ruleTypeLiteralWithMultiplicityCS7562 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000010L});
        public static final BitSet FOLLOW_ruleMultiplicityCS_in_ruleTypeLiteralWithMultiplicityCS7582 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralExpCS_in_entryRuleTypeLiteralExpCS7619 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeLiteralExpCS7629 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralWithMultiplicityCS_in_ruleTypeLiteralExpCS7674 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeNameExpCS_in_entryRuleTypeNameExpCS7709 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeNameExpCS7719 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePathNameCS_in_ruleTypeNameExpCS7764 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_entryRuleTypeExpCS7799 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeExpCS7809 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeNameExpCS_in_ruleTypeExpCS7860 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000010L});
        public static final BitSet FOLLOW_ruleTypeLiteralCS_in_ruleTypeExpCS7890 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000010L});
        public static final BitSet FOLLOW_ruleMultiplicityCS_in_ruleTypeExpCS7911 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpCS_in_entryRuleExpCS7948 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleExpCS7958 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrefixedExpCS_in_ruleExpCS8009 = new BitSet(new long[]{0x0007FFEC00000002L});
        public static final BitSet FOLLOW_ruleBinaryOperatorCS_in_ruleExpCS8042 = new BitSet(new long[]{0xFFF8001FFE6400F0L,0x0000000000289E03L});
        public static final BitSet FOLLOW_rulePrefixedExpCS_in_ruleExpCS8065 = new BitSet(new long[]{0x0007FFEC00000002L});
        public static final BitSet FOLLOW_ruleBinaryOperatorCS_in_ruleExpCS8087 = new BitSet(new long[]{0xFFF8001FFE6000F0L,0x0000000000209E03L});
        public static final BitSet FOLLOW_rulePrefixedExpCS_in_ruleExpCS8108 = new BitSet(new long[]{0x0007FFEC00000002L});
        public static final BitSet FOLLOW_ruleBinaryOperatorCS_in_ruleExpCS8132 = new BitSet(new long[]{0xFFF8001FFE6400F0L,0x0000000000289E03L});
        public static final BitSet FOLLOW_ruleLetExpCS_in_ruleExpCS8153 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLetExpCS_in_ruleExpCS8183 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnaryOperatorCS_in_ruleExpCS8227 = new BitSet(new long[]{0xFFF8001FFE6400F0L,0x0000000000289E03L});
        public static final BitSet FOLLOW_ruleLetExpCS_in_ruleExpCS8249 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLetExpCS_in_ruleExpCS8281 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBinaryOperatorCS_in_entryRuleBinaryOperatorCS8316 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBinaryOperatorCS8326 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInfixOperatorCS_in_ruleBinaryOperatorCS8376 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigationOperatorCS_in_ruleBinaryOperatorCS8406 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInfixOperatorCS_in_entryRuleInfixOperatorCS8441 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleInfixOperatorCS8451 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInfixOperator_in_ruleInfixOperatorCS8496 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigationOperatorCS_in_entryRuleNavigationOperatorCS8531 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigationOperatorCS8541 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigationOperator_in_ruleNavigationOperatorCS8586 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrefixedExpCS_in_entryRulePrefixedExpCS8621 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrefixedExpCS8631 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnaryOperatorCS_in_rulePrefixedExpCS8690 = new BitSet(new long[]{0xFFF8001FFE6000F0L,0x0000000000209E03L});
        public static final BitSet FOLLOW_rulePrimaryExpCS_in_rulePrefixedExpCS8712 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimaryExpCS_in_rulePrefixedExpCS8744 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnaryOperatorCS_in_entryRuleUnaryOperatorCS8779 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnaryOperatorCS8789 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrefixOperator_in_ruleUnaryOperatorCS8834 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimaryExpCS_in_entryRulePrimaryExpCS8869 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpCS8879 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedExpCS_in_rulePrimaryExpCS8929 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIfExpCS_in_rulePrimaryExpCS8959 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSelfExpCS_in_rulePrimaryExpCS8989 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveLiteralExpCS_in_rulePrimaryExpCS9019 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTupleLiteralExpCS_in_rulePrimaryExpCS9049 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionLiteralExpCS_in_rulePrimaryExpCS9079 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralExpCS_in_rulePrimaryExpCS9109 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePathNameCS_in_rulePrimaryExpCS9148 = new BitSet(new long[]{0x0000000000000002L,0x0000000000002092L});
        public static final BitSet FOLLOW_68_in_rulePrimaryExpCS9174 = new BitSet(new long[]{0xFFF8001FFE6400F0L,0x0000000000289E03L});
        public static final BitSet FOLLOW_ruleExpCS_in_rulePrimaryExpCS9195 = new BitSet(new long[]{0x0000000000010000L,0x0000000000000020L});
        public static final BitSet FOLLOW_16_in_rulePrimaryExpCS9208 = new BitSet(new long[]{0xFFF8001FFE6400F0L,0x0000000000289E03L});
        public static final BitSet FOLLOW_ruleExpCS_in_rulePrimaryExpCS9229 = new BitSet(new long[]{0x0000000000010000L,0x0000000000000020L});
        public static final BitSet FOLLOW_69_in_rulePrimaryExpCS9243 = new BitSet(new long[]{0x0000000000000002L,0x0000000000002010L});
        public static final BitSet FOLLOW_68_in_rulePrimaryExpCS9256 = new BitSet(new long[]{0xFFF8001FFE6400F0L,0x0000000000289E03L});
        public static final BitSet FOLLOW_ruleExpCS_in_rulePrimaryExpCS9277 = new BitSet(new long[]{0x0000000000010000L,0x0000000000000020L});
        public static final BitSet FOLLOW_16_in_rulePrimaryExpCS9290 = new BitSet(new long[]{0xFFF8001FFE6400F0L,0x0000000000289E03L});
        public static final BitSet FOLLOW_ruleExpCS_in_rulePrimaryExpCS9311 = new BitSet(new long[]{0x0000000000010000L,0x0000000000000020L});
        public static final BitSet FOLLOW_69_in_rulePrimaryExpCS9325 = new BitSet(new long[]{0x0000000000000002L,0x0000000000002000L});
        public static final BitSet FOLLOW_77_in_rulePrimaryExpCS9346 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
        public static final BitSet FOLLOW_78_in_rulePrimaryExpCS9371 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_71_in_rulePrimaryExpCS9405 = new BitSet(new long[]{0x00000003FE6000B0L});
        public static final BitSet FOLLOW_ruleConstructorPartCS_in_rulePrimaryExpCS9428 = new BitSet(new long[]{0x0000000000010000L,0x0000000000000100L});
        public static final BitSet FOLLOW_16_in_rulePrimaryExpCS9441 = new BitSet(new long[]{0x00000003FE600030L});
        public static final BitSet FOLLOW_ruleConstructorPartCS_in_rulePrimaryExpCS9462 = new BitSet(new long[]{0x0000000000010000L,0x0000000000000100L});
        public static final BitSet FOLLOW_ruleStringLiteral_in_rulePrimaryExpCS9492 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
        public static final BitSet FOLLOW_72_in_rulePrimaryExpCS9505 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_77_in_rulePrimaryExpCS9532 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
        public static final BitSet FOLLOW_78_in_rulePrimaryExpCS9557 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000002L});
        public static final BitSet FOLLOW_65_in_rulePrimaryExpCS9584 = new BitSet(new long[]{0xFFF8001FFE6400F0L,0x0000000000289E07L});
        public static final BitSet FOLLOW_ruleNavigatingArgCS_in_rulePrimaryExpCS9606 = new BitSet(new long[]{0x0000000000130000L,0x0000000000000004L});
        public static final BitSet FOLLOW_ruleNavigatingCommaArgCS_in_rulePrimaryExpCS9627 = new BitSet(new long[]{0x0000000000130000L,0x0000000000000004L});
        public static final BitSet FOLLOW_ruleNavigatingSemiArgCS_in_rulePrimaryExpCS9650 = new BitSet(new long[]{0x0000000000030000L,0x0000000000000004L});
        public static final BitSet FOLLOW_ruleNavigatingCommaArgCS_in_rulePrimaryExpCS9671 = new BitSet(new long[]{0x0000000000030000L,0x0000000000000004L});
        public static final BitSet FOLLOW_ruleNavigatingBarArgCS_in_rulePrimaryExpCS9696 = new BitSet(new long[]{0x0000000000010000L,0x0000000000000004L});
        public static final BitSet FOLLOW_ruleNavigatingCommaArgCS_in_rulePrimaryExpCS9717 = new BitSet(new long[]{0x0000000000010000L,0x0000000000000004L});
        public static final BitSet FOLLOW_66_in_rulePrimaryExpCS9734 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingArgCS_in_entryRuleNavigatingArgCS9775 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigatingArgCS9785 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingArgCS9831 = new BitSet(new long[]{0x0000000000800002L});
        public static final BitSet FOLLOW_23_in_ruleNavigatingArgCS9844 = new BitSet(new long[]{0xFFF8001FFE6000F0L,0x0000000000209E03L});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleNavigatingArgCS9865 = new BitSet(new long[]{0x0000080000000002L});
        public static final BitSet FOLLOW_43_in_ruleNavigatingArgCS9878 = new BitSet(new long[]{0xFFF8001FFE6400F0L,0x0000000000289E03L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNavigatingArgCS9899 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingBarArgCS_in_entryRuleNavigatingBarArgCS9939 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigatingBarArgCS9949 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleNavigatingBarArgCS9992 = new BitSet(new long[]{0xFFF8001FFE6400F0L,0x0000000000289E03L});
        public static final BitSet FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingBarArgCS10026 = new BitSet(new long[]{0x0000000000800002L});
        public static final BitSet FOLLOW_23_in_ruleNavigatingBarArgCS10039 = new BitSet(new long[]{0xFFF8001FFE6000F0L,0x0000000000209E03L});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleNavigatingBarArgCS10060 = new BitSet(new long[]{0x0000080000000002L});
        public static final BitSet FOLLOW_43_in_ruleNavigatingBarArgCS10073 = new BitSet(new long[]{0xFFF8001FFE6400F0L,0x0000000000289E03L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNavigatingBarArgCS10094 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingCommaArgCS_in_entryRuleNavigatingCommaArgCS10134 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigatingCommaArgCS10144 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleNavigatingCommaArgCS10187 = new BitSet(new long[]{0xFFF8001FFE6400F0L,0x0000000000289E03L});
        public static final BitSet FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingCommaArgCS10221 = new BitSet(new long[]{0x0000000000800002L});
        public static final BitSet FOLLOW_23_in_ruleNavigatingCommaArgCS10234 = new BitSet(new long[]{0xFFF8001FFE6000F0L,0x0000000000209E03L});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleNavigatingCommaArgCS10255 = new BitSet(new long[]{0x0000080000000002L});
        public static final BitSet FOLLOW_43_in_ruleNavigatingCommaArgCS10268 = new BitSet(new long[]{0xFFF8001FFE6400F0L,0x0000000000289E03L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNavigatingCommaArgCS10289 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingSemiArgCS_in_entryRuleNavigatingSemiArgCS10329 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigatingSemiArgCS10339 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleNavigatingSemiArgCS10382 = new BitSet(new long[]{0xFFF8001FFE6400F0L,0x0000000000289E03L});
        public static final BitSet FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingSemiArgCS10416 = new BitSet(new long[]{0x0000000000800002L});
        public static final BitSet FOLLOW_23_in_ruleNavigatingSemiArgCS10429 = new BitSet(new long[]{0xFFF8001FFE6000F0L,0x0000000000209E03L});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleNavigatingSemiArgCS10450 = new BitSet(new long[]{0x0000080000000002L});
        public static final BitSet FOLLOW_43_in_ruleNavigatingSemiArgCS10463 = new BitSet(new long[]{0xFFF8001FFE6400F0L,0x0000000000289E03L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNavigatingSemiArgCS10484 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingArgExpCS_in_entryRuleNavigatingArgExpCS10524 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigatingArgExpCS10534 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNavigatingArgExpCS10583 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIfExpCS_in_entryRuleIfExpCS10617 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIfExpCS10627 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_79_in_ruleIfExpCS10664 = new BitSet(new long[]{0xFFF8001FFE6400F0L,0x0000000000289E03L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleIfExpCS10685 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
        public static final BitSet FOLLOW_80_in_ruleIfExpCS10697 = new BitSet(new long[]{0xFFF8001FFE6400F0L,0x0000000000289E03L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleIfExpCS10718 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
        public static final BitSet FOLLOW_81_in_ruleIfExpCS10730 = new BitSet(new long[]{0xFFF8001FFE6400F0L,0x0000000000289E03L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleIfExpCS10751 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
        public static final BitSet FOLLOW_82_in_ruleIfExpCS10763 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLetExpCS_in_entryRuleLetExpCS10799 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLetExpCS10809 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_83_in_ruleLetExpCS10846 = new BitSet(new long[]{0x00000003FE600030L});
        public static final BitSet FOLLOW_ruleLetVariableCS_in_ruleLetExpCS10867 = new BitSet(new long[]{0x0000000000010000L,0x0000000000100000L});
        public static final BitSet FOLLOW_16_in_ruleLetExpCS10880 = new BitSet(new long[]{0x00000003FE600030L});
        public static final BitSet FOLLOW_ruleLetVariableCS_in_ruleLetExpCS10901 = new BitSet(new long[]{0x0000000000010000L,0x0000000000100000L});
        public static final BitSet FOLLOW_84_in_ruleLetExpCS10915 = new BitSet(new long[]{0xFFF8001FFE6400F0L,0x0000000000289E03L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleLetExpCS10936 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLetVariableCS_in_entryRuleLetVariableCS10972 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLetVariableCS10982 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleLetVariableCS11028 = new BitSet(new long[]{0x0000080000800000L});
        public static final BitSet FOLLOW_23_in_ruleLetVariableCS11041 = new BitSet(new long[]{0xFFF8001FFE6000F0L,0x0000000000209E03L});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleLetVariableCS11062 = new BitSet(new long[]{0x0000080000000000L});
        public static final BitSet FOLLOW_43_in_ruleLetVariableCS11076 = new BitSet(new long[]{0xFFF8001FFE6400F0L,0x0000000000289E03L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleLetVariableCS11097 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedExpCS_in_entryRuleNestedExpCS11133 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNestedExpCS11143 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_65_in_ruleNestedExpCS11180 = new BitSet(new long[]{0xFFF8001FFE6400F0L,0x0000000000289E03L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNestedExpCS11201 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
        public static final BitSet FOLLOW_66_in_ruleNestedExpCS11213 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSelfExpCS_in_entryRuleSelfExpCS11249 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSelfExpCS11259 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_85_in_ruleSelfExpCS11308 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTupleLiteralExpCS_in_synpred101_InternalQVTcoreBase9049 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionLiteralExpCS_in_synpred102_InternalQVTcoreBase9079 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralExpCS_in_synpred103_InternalQVTcoreBase9109 = new BitSet(new long[]{0x0000000000000002L});
    }


}