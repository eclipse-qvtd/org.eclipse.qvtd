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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_SIMPLE_ID", "RULE_ESCAPED_ID", "RULE_INT", "RULE_SINGLE_QUOTED_STRING", "RULE_ESCAPED_CHARACTER", "RULE_LETTER_CHARACTER", "RULE_DOUBLE_QUOTED_STRING", "RULE_ML_SINGLE_QUOTED_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'{'", "','", "'|'", "'}'", "'default'", "':='", "';'", "'imports'", "'uses'", "'('", "')'", "':'", "'::'", "'realize'", "'check'", "'enforce'", "'import'", "'library'", "'map'", "'query'", "'refines'", "'transformation'", "'*'", "'-'", "'not'", "'/'", "'+'", "'>'", "'<'", "'>='", "'<='", "'='", "'<>'", "'and'", "'or'", "'xor'", "'implies'", "'.'", "'->'", "'Tuple'", "'Boolean'", "'Integer'", "'Real'", "'String'", "'UnlimitedNatural'", "'OclAny'", "'OclInvalid'", "'OclVoid'", "'Set'", "'Bag'", "'Sequence'", "'Collection'", "'OrderedSet'", "'..'", "'['", "']'", "'?'", "'true'", "'false'", "'invalid'", "'null'", "'@'", "'pre'", "'if'", "'then'", "'else'", "'endif'", "'let'", "'in'", "'self'"
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:82:1: ruleBottomPatternCS returns [EObject current=null] : ( (otherlv_0= '{' ( ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_2_0= ruleRealizedVariableCS ) ) ) (otherlv_3= ',' ( ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) ) ) )* otherlv_6= '|' ( (lv_constraints_7_0= ruleAssignmentCS ) )* otherlv_8= '}' ) | ( () otherlv_10= '{' ( (lv_constraints_11_0= ruleAssignmentCS ) )* otherlv_12= '}' ) ) ;
    public final EObject ruleBottomPatternCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        EObject lv_unrealizedVariables_1_0 = null;

        EObject lv_realizedVariables_2_0 = null;

        EObject lv_unrealizedVariables_4_0 = null;

        EObject lv_realizedVariables_5_0 = null;

        EObject lv_constraints_7_0 = null;

        EObject lv_constraints_11_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:85:28: ( ( (otherlv_0= '{' ( ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_2_0= ruleRealizedVariableCS ) ) ) (otherlv_3= ',' ( ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) ) ) )* otherlv_6= '|' ( (lv_constraints_7_0= ruleAssignmentCS ) )* otherlv_8= '}' ) | ( () otherlv_10= '{' ( (lv_constraints_11_0= ruleAssignmentCS ) )* otherlv_12= '}' ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:86:1: ( (otherlv_0= '{' ( ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_2_0= ruleRealizedVariableCS ) ) ) (otherlv_3= ',' ( ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) ) ) )* otherlv_6= '|' ( (lv_constraints_7_0= ruleAssignmentCS ) )* otherlv_8= '}' ) | ( () otherlv_10= '{' ( (lv_constraints_11_0= ruleAssignmentCS ) )* otherlv_12= '}' ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:86:1: ( (otherlv_0= '{' ( ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_2_0= ruleRealizedVariableCS ) ) ) (otherlv_3= ',' ( ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) ) ) )* otherlv_6= '|' ( (lv_constraints_7_0= ruleAssignmentCS ) )* otherlv_8= '}' ) | ( () otherlv_10= '{' ( (lv_constraints_11_0= ruleAssignmentCS ) )* otherlv_12= '}' ) )
            int alt6=2;
            alt6 = dfa6.predict(input);
            switch (alt6) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:86:2: (otherlv_0= '{' ( ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_2_0= ruleRealizedVariableCS ) ) ) (otherlv_3= ',' ( ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) ) ) )* otherlv_6= '|' ( (lv_constraints_7_0= ruleAssignmentCS ) )* otherlv_8= '}' )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:86:2: (otherlv_0= '{' ( ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_2_0= ruleRealizedVariableCS ) ) ) (otherlv_3= ',' ( ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) ) ) )* otherlv_6= '|' ( (lv_constraints_7_0= ruleAssignmentCS ) )* otherlv_8= '}' )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:86:4: otherlv_0= '{' ( ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_2_0= ruleRealizedVariableCS ) ) ) (otherlv_3= ',' ( ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) ) ) )* otherlv_6= '|' ( (lv_constraints_7_0= ruleAssignmentCS ) )* otherlv_8= '}'
                    {
                    otherlv_0=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleBottomPatternCS129); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getBottomPatternCSAccess().getLeftCurlyBracketKeyword_0_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:90:1: ( ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_2_0= ruleRealizedVariableCS ) ) )
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( ((LA1_0>=RULE_SIMPLE_ID && LA1_0<=RULE_ESCAPED_ID)||(LA1_0>=23 && LA1_0<=24)||(LA1_0>=30 && LA1_0<=37)) ) {
                        alt1=1;
                    }
                    else if ( (LA1_0==29) ) {
                        int LA1_2 = input.LA(2);

                        if ( (LA1_2==27) ) {
                            alt1=1;
                        }
                        else if ( ((LA1_2>=RULE_SIMPLE_ID && LA1_2<=RULE_ESCAPED_ID)||(LA1_2>=23 && LA1_2<=24)||(LA1_2>=29 && LA1_2<=37)) ) {
                            alt1=2;
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
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:90:2: ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:90:2: ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:91:1: (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:91:1: (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:92:3: lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getBottomPatternCSAccess().getUnrealizedVariablesUnrealizedVariableCSParserRuleCall_0_1_0_0()); 
                              	    
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
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:109:6: ( (lv_realizedVariables_2_0= ruleRealizedVariableCS ) )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:109:6: ( (lv_realizedVariables_2_0= ruleRealizedVariableCS ) )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:110:1: (lv_realizedVariables_2_0= ruleRealizedVariableCS )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:110:1: (lv_realizedVariables_2_0= ruleRealizedVariableCS )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:111:3: lv_realizedVariables_2_0= ruleRealizedVariableCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getBottomPatternCSAccess().getRealizedVariablesRealizedVariableCSParserRuleCall_0_1_1_0()); 
                              	    
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

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:127:3: (otherlv_3= ',' ( ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) ) ) )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==17) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:127:5: otherlv_3= ',' ( ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) ) )
                    	    {
                    	    otherlv_3=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleBottomPatternCS192); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getBottomPatternCSAccess().getCommaKeyword_0_2_0());
                    	          
                    	    }
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:131:1: ( ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) ) )
                    	    int alt2=2;
                    	    int LA2_0 = input.LA(1);

                    	    if ( ((LA2_0>=RULE_SIMPLE_ID && LA2_0<=RULE_ESCAPED_ID)||(LA2_0>=23 && LA2_0<=24)||(LA2_0>=30 && LA2_0<=37)) ) {
                    	        alt2=1;
                    	    }
                    	    else if ( (LA2_0==29) ) {
                    	        int LA2_2 = input.LA(2);

                    	        if ( ((LA2_2>=RULE_SIMPLE_ID && LA2_2<=RULE_ESCAPED_ID)||(LA2_2>=23 && LA2_2<=24)||(LA2_2>=29 && LA2_2<=37)) ) {
                    	            alt2=2;
                    	        }
                    	        else if ( (LA2_2==27) ) {
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
                    	            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:131:2: ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) )
                    	            {
                    	            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:131:2: ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) )
                    	            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:132:1: (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS )
                    	            {
                    	            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:132:1: (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS )
                    	            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:133:3: lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS
                    	            {
                    	            if ( state.backtracking==0 ) {
                    	               
                    	              	        newCompositeNode(grammarAccess.getBottomPatternCSAccess().getUnrealizedVariablesUnrealizedVariableCSParserRuleCall_0_2_1_0_0()); 
                    	              	    
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
                    	            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:150:6: ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) )
                    	            {
                    	            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:150:6: ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) )
                    	            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:151:1: (lv_realizedVariables_5_0= ruleRealizedVariableCS )
                    	            {
                    	            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:151:1: (lv_realizedVariables_5_0= ruleRealizedVariableCS )
                    	            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:152:3: lv_realizedVariables_5_0= ruleRealizedVariableCS
                    	            {
                    	            if ( state.backtracking==0 ) {
                    	               
                    	              	        newCompositeNode(grammarAccess.getBottomPatternCSAccess().getRealizedVariablesRealizedVariableCSParserRuleCall_0_2_1_1_0()); 
                    	              	    
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

                    otherlv_6=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleBottomPatternCS256); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getBottomPatternCSAccess().getVerticalLineKeyword_0_3());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:172:1: ( (lv_constraints_7_0= ruleAssignmentCS ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( ((LA4_0>=RULE_SIMPLE_ID && LA4_0<=RULE_SINGLE_QUOTED_STRING)||LA4_0==20||(LA4_0>=23 && LA4_0<=25)||(LA4_0>=29 && LA4_0<=40)||(LA4_0>=55 && LA4_0<=68)||(LA4_0>=73 && LA4_0<=76)||LA4_0==79||LA4_0==83||LA4_0==85) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:173:1: (lv_constraints_7_0= ruleAssignmentCS )
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:173:1: (lv_constraints_7_0= ruleAssignmentCS )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:174:3: lv_constraints_7_0= ruleAssignmentCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getBottomPatternCSAccess().getConstraintsAssignmentCSParserRuleCall_0_4_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleAssignmentCS_in_ruleBottomPatternCS277);
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
                    	    break loop4;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleBottomPatternCS290); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getBottomPatternCSAccess().getRightCurlyBracketKeyword_0_5());
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:195:6: ( () otherlv_10= '{' ( (lv_constraints_11_0= ruleAssignmentCS ) )* otherlv_12= '}' )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:195:6: ( () otherlv_10= '{' ( (lv_constraints_11_0= ruleAssignmentCS ) )* otherlv_12= '}' )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:195:7: () otherlv_10= '{' ( (lv_constraints_11_0= ruleAssignmentCS ) )* otherlv_12= '}'
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:195:7: ()
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:196:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getBottomPatternCSAccess().getBottomPatternCSAction_1_0(),
                                  current);
                          
                    }

                    }

                    otherlv_10=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleBottomPatternCS322); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getBottomPatternCSAccess().getLeftCurlyBracketKeyword_1_1());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:208:1: ( (lv_constraints_11_0= ruleAssignmentCS ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( ((LA5_0>=RULE_SIMPLE_ID && LA5_0<=RULE_SINGLE_QUOTED_STRING)||LA5_0==20||(LA5_0>=23 && LA5_0<=25)||(LA5_0>=29 && LA5_0<=40)||(LA5_0>=55 && LA5_0<=68)||(LA5_0>=73 && LA5_0<=76)||LA5_0==79||LA5_0==83||LA5_0==85) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:209:1: (lv_constraints_11_0= ruleAssignmentCS )
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:209:1: (lv_constraints_11_0= ruleAssignmentCS )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:210:3: lv_constraints_11_0= ruleAssignmentCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getBottomPatternCSAccess().getConstraintsAssignmentCSParserRuleCall_1_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleAssignmentCS_in_ruleBottomPatternCS343);
                    	    lv_constraints_11_0=ruleAssignmentCS();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getBottomPatternCSRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"constraints",
                    	              		lv_constraints_11_0, 
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

                    otherlv_12=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleBottomPatternCS356); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_12, grammarAccess.getBottomPatternCSAccess().getRightCurlyBracketKeyword_1_3());
                          
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


    // $ANTLR start "entryRuleAssignmentCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:238:1: entryRuleAssignmentCS returns [EObject current=null] : iv_ruleAssignmentCS= ruleAssignmentCS EOF ;
    public final EObject entryRuleAssignmentCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignmentCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:239:2: (iv_ruleAssignmentCS= ruleAssignmentCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:240:2: iv_ruleAssignmentCS= ruleAssignmentCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAssignmentCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAssignmentCS_in_entryRuleAssignmentCS393);
            iv_ruleAssignmentCS=ruleAssignmentCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAssignmentCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAssignmentCS403); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:247:1: ruleAssignmentCS returns [EObject current=null] : ( ( (lv_default_0_0= 'default' ) )? ( (lv_target_1_0= ruleExpCS ) ) (otherlv_2= ':=' ( (lv_initialiser_3_0= ruleExpCS ) ) )? otherlv_4= ';' ) ;
    public final EObject ruleAssignmentCS() throws RecognitionException {
        EObject current = null;

        Token lv_default_0_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_target_1_0 = null;

        EObject lv_initialiser_3_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:250:28: ( ( ( (lv_default_0_0= 'default' ) )? ( (lv_target_1_0= ruleExpCS ) ) (otherlv_2= ':=' ( (lv_initialiser_3_0= ruleExpCS ) ) )? otherlv_4= ';' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:251:1: ( ( (lv_default_0_0= 'default' ) )? ( (lv_target_1_0= ruleExpCS ) ) (otherlv_2= ':=' ( (lv_initialiser_3_0= ruleExpCS ) ) )? otherlv_4= ';' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:251:1: ( ( (lv_default_0_0= 'default' ) )? ( (lv_target_1_0= ruleExpCS ) ) (otherlv_2= ':=' ( (lv_initialiser_3_0= ruleExpCS ) ) )? otherlv_4= ';' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:251:2: ( (lv_default_0_0= 'default' ) )? ( (lv_target_1_0= ruleExpCS ) ) (otherlv_2= ':=' ( (lv_initialiser_3_0= ruleExpCS ) ) )? otherlv_4= ';'
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:251:2: ( (lv_default_0_0= 'default' ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==20) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:252:1: (lv_default_0_0= 'default' )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:252:1: (lv_default_0_0= 'default' )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:253:3: lv_default_0_0= 'default'
                    {
                    lv_default_0_0=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleAssignmentCS446); if (state.failed) return current;
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:266:3: ( (lv_target_1_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:267:1: (lv_target_1_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:267:1: (lv_target_1_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:268:3: lv_target_1_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAssignmentCSAccess().getTargetExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleAssignmentCS481);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:284:2: (otherlv_2= ':=' ( (lv_initialiser_3_0= ruleExpCS ) ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==21) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:284:4: otherlv_2= ':=' ( (lv_initialiser_3_0= ruleExpCS ) )
                    {
                    otherlv_2=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleAssignmentCS494); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getAssignmentCSAccess().getColonEqualsSignKeyword_2_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:288:1: ( (lv_initialiser_3_0= ruleExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:289:1: (lv_initialiser_3_0= ruleExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:289:1: (lv_initialiser_3_0= ruleExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:290:3: lv_initialiser_3_0= ruleExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAssignmentCSAccess().getInitialiserExpCSParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleAssignmentCS515);
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

            otherlv_4=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleAssignmentCS529); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:318:1: entryRuleDirectionCS returns [EObject current=null] : iv_ruleDirectionCS= ruleDirectionCS EOF ;
    public final EObject entryRuleDirectionCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDirectionCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:319:2: (iv_ruleDirectionCS= ruleDirectionCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:320:2: iv_ruleDirectionCS= ruleDirectionCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDirectionCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleDirectionCS_in_entryRuleDirectionCS565);
            iv_ruleDirectionCS=ruleDirectionCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDirectionCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDirectionCS575); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:327:1: ruleDirectionCS returns [EObject current=null] : ( () ( (lv_name_1_0= ruleUnrestrictedName ) )? (otherlv_2= 'imports' ( ( ruleUnrestrictedName ) ) (otherlv_4= ',' ( ( ruleUnrestrictedName ) ) )* )? (otherlv_6= 'uses' ( ( ruleUnrestrictedName ) ) (otherlv_8= ',' ( ( ruleUnrestrictedName ) ) )* )? ) ;
    public final EObject ruleDirectionCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:330:28: ( ( () ( (lv_name_1_0= ruleUnrestrictedName ) )? (otherlv_2= 'imports' ( ( ruleUnrestrictedName ) ) (otherlv_4= ',' ( ( ruleUnrestrictedName ) ) )* )? (otherlv_6= 'uses' ( ( ruleUnrestrictedName ) ) (otherlv_8= ',' ( ( ruleUnrestrictedName ) ) )* )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:331:1: ( () ( (lv_name_1_0= ruleUnrestrictedName ) )? (otherlv_2= 'imports' ( ( ruleUnrestrictedName ) ) (otherlv_4= ',' ( ( ruleUnrestrictedName ) ) )* )? (otherlv_6= 'uses' ( ( ruleUnrestrictedName ) ) (otherlv_8= ',' ( ( ruleUnrestrictedName ) ) )* )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:331:1: ( () ( (lv_name_1_0= ruleUnrestrictedName ) )? (otherlv_2= 'imports' ( ( ruleUnrestrictedName ) ) (otherlv_4= ',' ( ( ruleUnrestrictedName ) ) )* )? (otherlv_6= 'uses' ( ( ruleUnrestrictedName ) ) (otherlv_8= ',' ( ( ruleUnrestrictedName ) ) )* )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:331:2: () ( (lv_name_1_0= ruleUnrestrictedName ) )? (otherlv_2= 'imports' ( ( ruleUnrestrictedName ) ) (otherlv_4= ',' ( ( ruleUnrestrictedName ) ) )* )? (otherlv_6= 'uses' ( ( ruleUnrestrictedName ) ) (otherlv_8= ',' ( ( ruleUnrestrictedName ) ) )* )?
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:331:2: ()
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:332:2: 
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:340:2: ( (lv_name_1_0= ruleUnrestrictedName ) )?
            int alt9=2;
            alt9 = dfa9.predict(input);
            switch (alt9) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:341:1: (lv_name_1_0= ruleUnrestrictedName )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:341:1: (lv_name_1_0= ruleUnrestrictedName )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:342:3: lv_name_1_0= ruleUnrestrictedName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDirectionCSAccess().getNameUnrestrictedNameParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleDirectionCS633);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:358:3: (otherlv_2= 'imports' ( ( ruleUnrestrictedName ) ) (otherlv_4= ',' ( ( ruleUnrestrictedName ) ) )* )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==23) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:358:5: otherlv_2= 'imports' ( ( ruleUnrestrictedName ) ) (otherlv_4= ',' ( ( ruleUnrestrictedName ) ) )*
                    {
                    otherlv_2=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleDirectionCS647); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getDirectionCSAccess().getImportsKeyword_2_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:362:1: ( ( ruleUnrestrictedName ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:363:1: ( ruleUnrestrictedName )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:363:1: ( ruleUnrestrictedName )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:364:3: ruleUnrestrictedName
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
                    pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleDirectionCS674);
                    ruleUnrestrictedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:380:2: (otherlv_4= ',' ( ( ruleUnrestrictedName ) ) )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==17) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:380:4: otherlv_4= ',' ( ( ruleUnrestrictedName ) )
                    	    {
                    	    otherlv_4=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleDirectionCS687); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_4, grammarAccess.getDirectionCSAccess().getCommaKeyword_2_2_0());
                    	          
                    	    }
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:384:1: ( ( ruleUnrestrictedName ) )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:385:1: ( ruleUnrestrictedName )
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:385:1: ( ruleUnrestrictedName )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:386:3: ruleUnrestrictedName
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
                    	    pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleDirectionCS714);
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
                    	    break loop10;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:402:6: (otherlv_6= 'uses' ( ( ruleUnrestrictedName ) ) (otherlv_8= ',' ( ( ruleUnrestrictedName ) ) )* )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==24) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:402:8: otherlv_6= 'uses' ( ( ruleUnrestrictedName ) ) (otherlv_8= ',' ( ( ruleUnrestrictedName ) ) )*
                    {
                    otherlv_6=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleDirectionCS731); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getDirectionCSAccess().getUsesKeyword_3_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:406:1: ( ( ruleUnrestrictedName ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:407:1: ( ruleUnrestrictedName )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:407:1: ( ruleUnrestrictedName )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:408:3: ruleUnrestrictedName
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
                    pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleDirectionCS758);
                    ruleUnrestrictedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:424:2: (otherlv_8= ',' ( ( ruleUnrestrictedName ) ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==17) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:424:4: otherlv_8= ',' ( ( ruleUnrestrictedName ) )
                    	    {
                    	    otherlv_8=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleDirectionCS771); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_8, grammarAccess.getDirectionCSAccess().getCommaKeyword_3_2_0());
                    	          
                    	    }
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:428:1: ( ( ruleUnrestrictedName ) )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:429:1: ( ruleUnrestrictedName )
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:429:1: ( ruleUnrestrictedName )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:430:3: ruleUnrestrictedName
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
                    	    pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleDirectionCS798);
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
                    	    break loop12;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:454:1: entryRuleGuardPatternCS returns [EObject current=null] : iv_ruleGuardPatternCS= ruleGuardPatternCS EOF ;
    public final EObject entryRuleGuardPatternCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGuardPatternCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:455:2: (iv_ruleGuardPatternCS= ruleGuardPatternCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:456:2: iv_ruleGuardPatternCS= ruleGuardPatternCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGuardPatternCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleGuardPatternCS_in_entryRuleGuardPatternCS838);
            iv_ruleGuardPatternCS=ruleGuardPatternCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleGuardPatternCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleGuardPatternCS848); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:463:1: ruleGuardPatternCS returns [EObject current=null] : ( (otherlv_0= '(' ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) (otherlv_2= ',' ( (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS ) ) )* otherlv_4= '|' ( (lv_constraints_5_0= ruleAssignmentCS ) )* otherlv_6= ')' ) | ( () otherlv_8= '(' ( (lv_constraints_9_0= ruleAssignmentCS ) )* otherlv_10= ')' ) ) ;
    public final EObject ruleGuardPatternCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject lv_unrealizedVariables_1_0 = null;

        EObject lv_unrealizedVariables_3_0 = null;

        EObject lv_constraints_5_0 = null;

        EObject lv_constraints_9_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:466:28: ( ( (otherlv_0= '(' ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) (otherlv_2= ',' ( (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS ) ) )* otherlv_4= '|' ( (lv_constraints_5_0= ruleAssignmentCS ) )* otherlv_6= ')' ) | ( () otherlv_8= '(' ( (lv_constraints_9_0= ruleAssignmentCS ) )* otherlv_10= ')' ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:467:1: ( (otherlv_0= '(' ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) (otherlv_2= ',' ( (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS ) ) )* otherlv_4= '|' ( (lv_constraints_5_0= ruleAssignmentCS ) )* otherlv_6= ')' ) | ( () otherlv_8= '(' ( (lv_constraints_9_0= ruleAssignmentCS ) )* otherlv_10= ')' ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:467:1: ( (otherlv_0= '(' ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) (otherlv_2= ',' ( (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS ) ) )* otherlv_4= '|' ( (lv_constraints_5_0= ruleAssignmentCS ) )* otherlv_6= ')' ) | ( () otherlv_8= '(' ( (lv_constraints_9_0= ruleAssignmentCS ) )* otherlv_10= ')' ) )
            int alt17=2;
            alt17 = dfa17.predict(input);
            switch (alt17) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:467:2: (otherlv_0= '(' ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) (otherlv_2= ',' ( (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS ) ) )* otherlv_4= '|' ( (lv_constraints_5_0= ruleAssignmentCS ) )* otherlv_6= ')' )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:467:2: (otherlv_0= '(' ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) (otherlv_2= ',' ( (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS ) ) )* otherlv_4= '|' ( (lv_constraints_5_0= ruleAssignmentCS ) )* otherlv_6= ')' )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:467:4: otherlv_0= '(' ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) (otherlv_2= ',' ( (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS ) ) )* otherlv_4= '|' ( (lv_constraints_5_0= ruleAssignmentCS ) )* otherlv_6= ')'
                    {
                    otherlv_0=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleGuardPatternCS886); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getGuardPatternCSAccess().getLeftParenthesisKeyword_0_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:471:1: ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:472:1: (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:472:1: (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:473:3: lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getGuardPatternCSAccess().getUnrealizedVariablesUnrealizedVariableCSParserRuleCall_0_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUnrealizedVariableCS_in_ruleGuardPatternCS907);
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

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:489:2: (otherlv_2= ',' ( (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS ) ) )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==17) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:489:4: otherlv_2= ',' ( (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS ) )
                    	    {
                    	    otherlv_2=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleGuardPatternCS920); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_2, grammarAccess.getGuardPatternCSAccess().getCommaKeyword_0_2_0());
                    	          
                    	    }
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:493:1: ( (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS ) )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:494:1: (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS )
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:494:1: (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:495:3: lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getGuardPatternCSAccess().getUnrealizedVariablesUnrealizedVariableCSParserRuleCall_0_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleUnrealizedVariableCS_in_ruleGuardPatternCS941);
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
                    	    break loop14;
                        }
                    } while (true);

                    otherlv_4=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleGuardPatternCS955); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getGuardPatternCSAccess().getVerticalLineKeyword_0_3());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:515:1: ( (lv_constraints_5_0= ruleAssignmentCS ) )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( ((LA15_0>=RULE_SIMPLE_ID && LA15_0<=RULE_SINGLE_QUOTED_STRING)||LA15_0==20||(LA15_0>=23 && LA15_0<=25)||(LA15_0>=29 && LA15_0<=40)||(LA15_0>=55 && LA15_0<=68)||(LA15_0>=73 && LA15_0<=76)||LA15_0==79||LA15_0==83||LA15_0==85) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:516:1: (lv_constraints_5_0= ruleAssignmentCS )
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:516:1: (lv_constraints_5_0= ruleAssignmentCS )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:517:3: lv_constraints_5_0= ruleAssignmentCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getGuardPatternCSAccess().getConstraintsAssignmentCSParserRuleCall_0_4_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleAssignmentCS_in_ruleGuardPatternCS976);
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

                    otherlv_6=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleGuardPatternCS989); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getGuardPatternCSAccess().getRightParenthesisKeyword_0_5());
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:538:6: ( () otherlv_8= '(' ( (lv_constraints_9_0= ruleAssignmentCS ) )* otherlv_10= ')' )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:538:6: ( () otherlv_8= '(' ( (lv_constraints_9_0= ruleAssignmentCS ) )* otherlv_10= ')' )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:538:7: () otherlv_8= '(' ( (lv_constraints_9_0= ruleAssignmentCS ) )* otherlv_10= ')'
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:538:7: ()
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:539:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getGuardPatternCSAccess().getGuardPatternCSAction_1_0(),
                                  current);
                          
                    }

                    }

                    otherlv_8=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleGuardPatternCS1021); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getGuardPatternCSAccess().getLeftParenthesisKeyword_1_1());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:551:1: ( (lv_constraints_9_0= ruleAssignmentCS ) )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( ((LA16_0>=RULE_SIMPLE_ID && LA16_0<=RULE_SINGLE_QUOTED_STRING)||LA16_0==20||(LA16_0>=23 && LA16_0<=25)||(LA16_0>=29 && LA16_0<=40)||(LA16_0>=55 && LA16_0<=68)||(LA16_0>=73 && LA16_0<=76)||LA16_0==79||LA16_0==83||LA16_0==85) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:552:1: (lv_constraints_9_0= ruleAssignmentCS )
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:552:1: (lv_constraints_9_0= ruleAssignmentCS )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:553:3: lv_constraints_9_0= ruleAssignmentCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getGuardPatternCSAccess().getConstraintsAssignmentCSParserRuleCall_1_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleAssignmentCS_in_ruleGuardPatternCS1042);
                    	    lv_constraints_9_0=ruleAssignmentCS();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getGuardPatternCSRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"constraints",
                    	              		lv_constraints_9_0, 
                    	              		"AssignmentCS");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);

                    otherlv_10=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleGuardPatternCS1055); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getGuardPatternCSAccess().getRightParenthesisKeyword_1_3());
                          
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


    // $ANTLR start "entryRuleParamDeclarationCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:587:1: entryRuleParamDeclarationCS returns [EObject current=null] : iv_ruleParamDeclarationCS= ruleParamDeclarationCS EOF ;
    public final EObject entryRuleParamDeclarationCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParamDeclarationCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:588:2: (iv_ruleParamDeclarationCS= ruleParamDeclarationCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:589:2: iv_ruleParamDeclarationCS= ruleParamDeclarationCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParamDeclarationCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleParamDeclarationCS_in_entryRuleParamDeclarationCS1098);
            iv_ruleParamDeclarationCS=ruleParamDeclarationCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParamDeclarationCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParamDeclarationCS1108); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:596:1: ruleParamDeclarationCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) ) ;
    public final EObject ruleParamDeclarationCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:599:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:600:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:600:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:600:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:600:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:601:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:601:1: (lv_name_0_0= ruleUnrestrictedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:602:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParamDeclarationCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleParamDeclarationCS1154);
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

            otherlv_1=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleParamDeclarationCS1166); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getParamDeclarationCSAccess().getColonKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:622:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:623:1: (lv_ownedType_2_0= ruleTypeExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:623:1: (lv_ownedType_2_0= ruleTypeExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:624:3: lv_ownedType_2_0= ruleTypeExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParamDeclarationCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleParamDeclarationCS1187);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:650:1: entryRuleScopeNameCS returns [EObject current=null] : iv_ruleScopeNameCS= ruleScopeNameCS EOF ;
    public final EObject entryRuleScopeNameCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScopeNameCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:651:2: (iv_ruleScopeNameCS= ruleScopeNameCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:652:2: iv_ruleScopeNameCS= ruleScopeNameCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScopeNameCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleScopeNameCS_in_entryRuleScopeNameCS1225);
            iv_ruleScopeNameCS=ruleScopeNameCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScopeNameCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleScopeNameCS1235); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:659:1: ruleScopeNameCS returns [EObject current=null] : ( ( (lv_path_0_0= ruleFirstPathElementCS ) ) otherlv_1= '::' ( ( (lv_path_2_0= ruleNextPathElementCS ) ) otherlv_3= '::' )* ) ;
    public final EObject ruleScopeNameCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_path_0_0 = null;

        EObject lv_path_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:662:28: ( ( ( (lv_path_0_0= ruleFirstPathElementCS ) ) otherlv_1= '::' ( ( (lv_path_2_0= ruleNextPathElementCS ) ) otherlv_3= '::' )* ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:663:1: ( ( (lv_path_0_0= ruleFirstPathElementCS ) ) otherlv_1= '::' ( ( (lv_path_2_0= ruleNextPathElementCS ) ) otherlv_3= '::' )* )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:663:1: ( ( (lv_path_0_0= ruleFirstPathElementCS ) ) otherlv_1= '::' ( ( (lv_path_2_0= ruleNextPathElementCS ) ) otherlv_3= '::' )* )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:663:2: ( (lv_path_0_0= ruleFirstPathElementCS ) ) otherlv_1= '::' ( ( (lv_path_2_0= ruleNextPathElementCS ) ) otherlv_3= '::' )*
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:663:2: ( (lv_path_0_0= ruleFirstPathElementCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:664:1: (lv_path_0_0= ruleFirstPathElementCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:664:1: (lv_path_0_0= ruleFirstPathElementCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:665:3: lv_path_0_0= ruleFirstPathElementCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getScopeNameCSAccess().getPathFirstPathElementCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleFirstPathElementCS_in_ruleScopeNameCS1281);
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

            otherlv_1=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleScopeNameCS1293); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getScopeNameCSAccess().getColonColonKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:685:1: ( ( (lv_path_2_0= ruleNextPathElementCS ) ) otherlv_3= '::' )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0>=RULE_SIMPLE_ID && LA18_0<=RULE_ESCAPED_ID)||(LA18_0>=23 && LA18_0<=24)||(LA18_0>=29 && LA18_0<=37)||(LA18_0>=55 && LA18_0<=68)) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:685:2: ( (lv_path_2_0= ruleNextPathElementCS ) ) otherlv_3= '::'
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:685:2: ( (lv_path_2_0= ruleNextPathElementCS ) )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:686:1: (lv_path_2_0= ruleNextPathElementCS )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:686:1: (lv_path_2_0= ruleNextPathElementCS )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:687:3: lv_path_2_0= ruleNextPathElementCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getScopeNameCSAccess().getPathNextPathElementCSParserRuleCall_2_0_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleNextPathElementCS_in_ruleScopeNameCS1315);
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

            	    otherlv_3=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleScopeNameCS1327); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getScopeNameCSAccess().getColonColonKeyword_2_1());
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop18;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:717:1: entryRuleUnrealizedVariableCS returns [EObject current=null] : iv_ruleUnrealizedVariableCS= ruleUnrealizedVariableCS EOF ;
    public final EObject entryRuleUnrealizedVariableCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnrealizedVariableCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:718:2: (iv_ruleUnrealizedVariableCS= ruleUnrealizedVariableCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:719:2: iv_ruleUnrealizedVariableCS= ruleUnrealizedVariableCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnrealizedVariableCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrealizedVariableCS_in_entryRuleUnrealizedVariableCS1367);
            iv_ruleUnrealizedVariableCS=ruleUnrealizedVariableCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnrealizedVariableCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnrealizedVariableCS1377); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:726:1: ruleUnrealizedVariableCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) ) ;
    public final EObject ruleUnrealizedVariableCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:729:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:730:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:730:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:730:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:730:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:731:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:731:1: (lv_name_0_0= ruleUnrestrictedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:732:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getUnrealizedVariableCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleUnrealizedVariableCS1423);
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

            otherlv_1=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleUnrealizedVariableCS1435); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getUnrealizedVariableCSAccess().getColonKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:752:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:753:1: (lv_ownedType_2_0= ruleTypeExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:753:1: (lv_ownedType_2_0= ruleTypeExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:754:3: lv_ownedType_2_0= ruleTypeExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getUnrealizedVariableCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleUnrealizedVariableCS1456);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:778:1: entryRuleRealizedVariableCS returns [EObject current=null] : iv_ruleRealizedVariableCS= ruleRealizedVariableCS EOF ;
    public final EObject entryRuleRealizedVariableCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealizedVariableCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:779:2: (iv_ruleRealizedVariableCS= ruleRealizedVariableCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:780:2: iv_ruleRealizedVariableCS= ruleRealizedVariableCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRealizedVariableCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleRealizedVariableCS_in_entryRuleRealizedVariableCS1492);
            iv_ruleRealizedVariableCS=ruleRealizedVariableCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRealizedVariableCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRealizedVariableCS1502); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:787:1: ruleRealizedVariableCS returns [EObject current=null] : (otherlv_0= 'realize' ( (lv_name_1_0= ruleUnrestrictedName ) ) otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) ) ;
    public final EObject ruleRealizedVariableCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_ownedType_3_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:790:28: ( (otherlv_0= 'realize' ( (lv_name_1_0= ruleUnrestrictedName ) ) otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:791:1: (otherlv_0= 'realize' ( (lv_name_1_0= ruleUnrestrictedName ) ) otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:791:1: (otherlv_0= 'realize' ( (lv_name_1_0= ruleUnrestrictedName ) ) otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:791:3: otherlv_0= 'realize' ( (lv_name_1_0= ruleUnrestrictedName ) ) otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) )
            {
            otherlv_0=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleRealizedVariableCS1539); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getRealizedVariableCSAccess().getRealizeKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:795:1: ( (lv_name_1_0= ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:796:1: (lv_name_1_0= ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:796:1: (lv_name_1_0= ruleUnrestrictedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:797:3: lv_name_1_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRealizedVariableCSAccess().getNameUnrestrictedNameParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleRealizedVariableCS1560);
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

            otherlv_2=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleRealizedVariableCS1572); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getRealizedVariableCSAccess().getColonKeyword_2());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:817:1: ( (lv_ownedType_3_0= ruleTypeExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:818:1: (lv_ownedType_3_0= ruleTypeExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:818:1: (lv_ownedType_3_0= ruleTypeExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:819:3: lv_ownedType_3_0= ruleTypeExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRealizedVariableCSAccess().getOwnedTypeTypeExpCSParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleRealizedVariableCS1593);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:845:1: entryRuleUnrestrictedName returns [String current=null] : iv_ruleUnrestrictedName= ruleUnrestrictedName EOF ;
    public final String entryRuleUnrestrictedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnrestrictedName = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:846:2: (iv_ruleUnrestrictedName= ruleUnrestrictedName EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:847:2: iv_ruleUnrestrictedName= ruleUnrestrictedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnrestrictedNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_entryRuleUnrestrictedName1632);
            iv_ruleUnrestrictedName=ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnrestrictedName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnrestrictedName1643); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:854:1: ruleUnrestrictedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_EssentialOCLUnrestrictedName_0= ruleEssentialOCLUnrestrictedName | kw= 'check' | kw= 'enforce' | kw= 'import' | kw= 'imports' | kw= 'library' | kw= 'map' | kw= 'query' | kw= 'realize' | kw= 'refines' | kw= 'transformation' | kw= 'uses' ) ;
    public final AntlrDatatypeRuleToken ruleUnrestrictedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_EssentialOCLUnrestrictedName_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:857:28: ( (this_EssentialOCLUnrestrictedName_0= ruleEssentialOCLUnrestrictedName | kw= 'check' | kw= 'enforce' | kw= 'import' | kw= 'imports' | kw= 'library' | kw= 'map' | kw= 'query' | kw= 'realize' | kw= 'refines' | kw= 'transformation' | kw= 'uses' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:858:1: (this_EssentialOCLUnrestrictedName_0= ruleEssentialOCLUnrestrictedName | kw= 'check' | kw= 'enforce' | kw= 'import' | kw= 'imports' | kw= 'library' | kw= 'map' | kw= 'query' | kw= 'realize' | kw= 'refines' | kw= 'transformation' | kw= 'uses' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:858:1: (this_EssentialOCLUnrestrictedName_0= ruleEssentialOCLUnrestrictedName | kw= 'check' | kw= 'enforce' | kw= 'import' | kw= 'imports' | kw= 'library' | kw= 'map' | kw= 'query' | kw= 'realize' | kw= 'refines' | kw= 'transformation' | kw= 'uses' )
            int alt19=12;
            switch ( input.LA(1) ) {
            case RULE_SIMPLE_ID:
            case RULE_ESCAPED_ID:
                {
                alt19=1;
                }
                break;
            case 30:
                {
                alt19=2;
                }
                break;
            case 31:
                {
                alt19=3;
                }
                break;
            case 32:
                {
                alt19=4;
                }
                break;
            case 23:
                {
                alt19=5;
                }
                break;
            case 33:
                {
                alt19=6;
                }
                break;
            case 34:
                {
                alt19=7;
                }
                break;
            case 35:
                {
                alt19=8;
                }
                break;
            case 29:
                {
                alt19=9;
                }
                break;
            case 36:
                {
                alt19=10;
                }
                break;
            case 37:
                {
                alt19=11;
                }
                break;
            case 24:
                {
                alt19=12;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:859:5: this_EssentialOCLUnrestrictedName_0= ruleEssentialOCLUnrestrictedName
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getUnrestrictedNameAccess().getEssentialOCLUnrestrictedNameParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLUnrestrictedName_in_ruleUnrestrictedName1690);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:871:2: kw= 'check'
                    {
                    kw=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleUnrestrictedName1714); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getCheckKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:878:2: kw= 'enforce'
                    {
                    kw=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleUnrestrictedName1733); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getEnforceKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:885:2: kw= 'import'
                    {
                    kw=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleUnrestrictedName1752); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getImportKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:892:2: kw= 'imports'
                    {
                    kw=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleUnrestrictedName1771); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getImportsKeyword_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:899:2: kw= 'library'
                    {
                    kw=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleUnrestrictedName1790); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getLibraryKeyword_5()); 
                          
                    }

                    }
                    break;
                case 7 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:906:2: kw= 'map'
                    {
                    kw=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleUnrestrictedName1809); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getMapKeyword_6()); 
                          
                    }

                    }
                    break;
                case 8 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:913:2: kw= 'query'
                    {
                    kw=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleUnrestrictedName1828); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getQueryKeyword_7()); 
                          
                    }

                    }
                    break;
                case 9 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:920:2: kw= 'realize'
                    {
                    kw=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleUnrestrictedName1847); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getRealizeKeyword_8()); 
                          
                    }

                    }
                    break;
                case 10 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:927:2: kw= 'refines'
                    {
                    kw=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleUnrestrictedName1866); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getRefinesKeyword_9()); 
                          
                    }

                    }
                    break;
                case 11 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:934:2: kw= 'transformation'
                    {
                    kw=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleUnrestrictedName1885); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getTransformationKeyword_10()); 
                          
                    }

                    }
                    break;
                case 12 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:941:2: kw= 'uses'
                    {
                    kw=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleUnrestrictedName1904); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:956:1: entryRuleID returns [String current=null] : iv_ruleID= ruleID EOF ;
    public final String entryRuleID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleID = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:957:2: (iv_ruleID= ruleID EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:958:2: iv_ruleID= ruleID EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIDRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleID_in_entryRuleID1947);
            iv_ruleID=ruleID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleID.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleID1958); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:965:1: ruleID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_SIMPLE_ID_0= RULE_SIMPLE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID ) ;
    public final AntlrDatatypeRuleToken ruleID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_SIMPLE_ID_0=null;
        Token this_ESCAPED_ID_1=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:968:28: ( (this_SIMPLE_ID_0= RULE_SIMPLE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:969:1: (this_SIMPLE_ID_0= RULE_SIMPLE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:969:1: (this_SIMPLE_ID_0= RULE_SIMPLE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==RULE_SIMPLE_ID) ) {
                alt20=1;
            }
            else if ( (LA20_0==RULE_ESCAPED_ID) ) {
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:969:6: this_SIMPLE_ID_0= RULE_SIMPLE_ID
                    {
                    this_SIMPLE_ID_0=(Token)match(input,RULE_SIMPLE_ID,FollowSets000.FOLLOW_RULE_SIMPLE_ID_in_ruleID1998); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SIMPLE_ID_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SIMPLE_ID_0, grammarAccess.getIDAccess().getSIMPLE_IDTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:977:10: this_ESCAPED_ID_1= RULE_ESCAPED_ID
                    {
                    this_ESCAPED_ID_1=(Token)match(input,RULE_ESCAPED_ID,FollowSets000.FOLLOW_RULE_ESCAPED_ID_in_ruleID2024); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:992:1: entryRuleLOWER returns [String current=null] : iv_ruleLOWER= ruleLOWER EOF ;
    public final String entryRuleLOWER() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLOWER = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:993:2: (iv_ruleLOWER= ruleLOWER EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:994:2: iv_ruleLOWER= ruleLOWER EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLOWERRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLOWER_in_entryRuleLOWER2070);
            iv_ruleLOWER=ruleLOWER();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLOWER.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLOWER2081); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1001:1: ruleLOWER returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INT_0= RULE_INT ;
    public final AntlrDatatypeRuleToken ruleLOWER() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1004:28: (this_INT_0= RULE_INT )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1005:5: this_INT_0= RULE_INT
            {
            this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleLOWER2120); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1020:1: entryRuleUPPER returns [String current=null] : iv_ruleUPPER= ruleUPPER EOF ;
    public final String entryRuleUPPER() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUPPER = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1021:2: (iv_ruleUPPER= ruleUPPER EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1022:2: iv_ruleUPPER= ruleUPPER EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUPPERRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUPPER_in_entryRuleUPPER2165);
            iv_ruleUPPER=ruleUPPER();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUPPER.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUPPER2176); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1029:1: ruleUPPER returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT | kw= '*' ) ;
    public final AntlrDatatypeRuleToken ruleUPPER() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1032:28: ( (this_INT_0= RULE_INT | kw= '*' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1033:1: (this_INT_0= RULE_INT | kw= '*' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1033:1: (this_INT_0= RULE_INT | kw= '*' )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==RULE_INT) ) {
                alt21=1;
            }
            else if ( (LA21_0==38) ) {
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1033:6: this_INT_0= RULE_INT
                    {
                    this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleUPPER2216); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_INT_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_INT_0, grammarAccess.getUPPERAccess().getINTTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1042:2: kw= '*'
                    {
                    kw=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleUPPER2240); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1055:1: entryRuleNUMBER_LITERAL returns [String current=null] : iv_ruleNUMBER_LITERAL= ruleNUMBER_LITERAL EOF ;
    public final String entryRuleNUMBER_LITERAL() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNUMBER_LITERAL = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1056:2: (iv_ruleNUMBER_LITERAL= ruleNUMBER_LITERAL EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1057:2: iv_ruleNUMBER_LITERAL= ruleNUMBER_LITERAL EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNUMBER_LITERALRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNUMBER_LITERAL_in_entryRuleNUMBER_LITERAL2281);
            iv_ruleNUMBER_LITERAL=ruleNUMBER_LITERAL();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNUMBER_LITERAL.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNUMBER_LITERAL2292); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1064:1: ruleNUMBER_LITERAL returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INT_0= RULE_INT ;
    public final AntlrDatatypeRuleToken ruleNUMBER_LITERAL() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1067:28: (this_INT_0= RULE_INT )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1068:5: this_INT_0= RULE_INT
            {
            this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleNUMBER_LITERAL2331); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1083:1: entryRuleURI returns [String current=null] : iv_ruleURI= ruleURI EOF ;
    public final String entryRuleURI() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleURI = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1084:2: (iv_ruleURI= ruleURI EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1085:2: iv_ruleURI= ruleURI EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getURIRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleURI_in_entryRuleURI2376);
            iv_ruleURI=ruleURI();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleURI.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleURI2387); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1092:1: ruleURI returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING ;
    public final AntlrDatatypeRuleToken ruleURI() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_SINGLE_QUOTED_STRING_0=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1095:28: (this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1096:5: this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING
            {
            this_SINGLE_QUOTED_STRING_0=(Token)match(input,RULE_SINGLE_QUOTED_STRING,FollowSets000.FOLLOW_RULE_SINGLE_QUOTED_STRING_in_ruleURI2426); if (state.failed) return current;
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


    // $ANTLR start "entryRuleEssentialOCLUnaryOperatorCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1113:1: entryRuleEssentialOCLUnaryOperatorCS returns [EObject current=null] : iv_ruleEssentialOCLUnaryOperatorCS= ruleEssentialOCLUnaryOperatorCS EOF ;
    public final EObject entryRuleEssentialOCLUnaryOperatorCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEssentialOCLUnaryOperatorCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1114:2: (iv_ruleEssentialOCLUnaryOperatorCS= ruleEssentialOCLUnaryOperatorCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1115:2: iv_ruleEssentialOCLUnaryOperatorCS= ruleEssentialOCLUnaryOperatorCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEssentialOCLUnaryOperatorCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLUnaryOperatorCS_in_entryRuleEssentialOCLUnaryOperatorCS2472);
            iv_ruleEssentialOCLUnaryOperatorCS=ruleEssentialOCLUnaryOperatorCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEssentialOCLUnaryOperatorCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEssentialOCLUnaryOperatorCS2482); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEssentialOCLUnaryOperatorCS"


    // $ANTLR start "ruleEssentialOCLUnaryOperatorCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1122:1: ruleEssentialOCLUnaryOperatorCS returns [EObject current=null] : ( ( (lv_name_0_1= '-' | lv_name_0_2= 'not' ) ) ) ;
    public final EObject ruleEssentialOCLUnaryOperatorCS() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1125:28: ( ( ( (lv_name_0_1= '-' | lv_name_0_2= 'not' ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1126:1: ( ( (lv_name_0_1= '-' | lv_name_0_2= 'not' ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1126:1: ( ( (lv_name_0_1= '-' | lv_name_0_2= 'not' ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1127:1: ( (lv_name_0_1= '-' | lv_name_0_2= 'not' ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1127:1: ( (lv_name_0_1= '-' | lv_name_0_2= 'not' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1128:1: (lv_name_0_1= '-' | lv_name_0_2= 'not' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1128:1: (lv_name_0_1= '-' | lv_name_0_2= 'not' )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==39) ) {
                alt22=1;
            }
            else if ( (LA22_0==40) ) {
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1129:3: lv_name_0_1= '-'
                    {
                    lv_name_0_1=(Token)match(input,39,FollowSets000.FOLLOW_39_in_ruleEssentialOCLUnaryOperatorCS2526); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_name_0_1, grammarAccess.getEssentialOCLUnaryOperatorCSAccess().getNameHyphenMinusKeyword_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getEssentialOCLUnaryOperatorCSRule());
                      	        }
                             		setWithLastConsumed(current, "name", lv_name_0_1, null);
                      	    
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1141:8: lv_name_0_2= 'not'
                    {
                    lv_name_0_2=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleEssentialOCLUnaryOperatorCS2555); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_name_0_2, grammarAccess.getEssentialOCLUnaryOperatorCSAccess().getNameNotKeyword_0_1());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getEssentialOCLUnaryOperatorCSRule());
                      	        }
                             		setWithLastConsumed(current, "name", lv_name_0_2, null);
                      	    
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
    // $ANTLR end "ruleEssentialOCLUnaryOperatorCS"


    // $ANTLR start "entryRuleEssentialOCLInfixOperatorCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1164:1: entryRuleEssentialOCLInfixOperatorCS returns [EObject current=null] : iv_ruleEssentialOCLInfixOperatorCS= ruleEssentialOCLInfixOperatorCS EOF ;
    public final EObject entryRuleEssentialOCLInfixOperatorCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEssentialOCLInfixOperatorCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1165:2: (iv_ruleEssentialOCLInfixOperatorCS= ruleEssentialOCLInfixOperatorCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1166:2: iv_ruleEssentialOCLInfixOperatorCS= ruleEssentialOCLInfixOperatorCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEssentialOCLInfixOperatorCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLInfixOperatorCS_in_entryRuleEssentialOCLInfixOperatorCS2606);
            iv_ruleEssentialOCLInfixOperatorCS=ruleEssentialOCLInfixOperatorCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEssentialOCLInfixOperatorCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEssentialOCLInfixOperatorCS2616); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEssentialOCLInfixOperatorCS"


    // $ANTLR start "ruleEssentialOCLInfixOperatorCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1173:1: ruleEssentialOCLInfixOperatorCS returns [EObject current=null] : ( ( (lv_name_0_1= '*' | lv_name_0_2= '/' | lv_name_0_3= '+' | lv_name_0_4= '-' | lv_name_0_5= '>' | lv_name_0_6= '<' | lv_name_0_7= '>=' | lv_name_0_8= '<=' | lv_name_0_9= '=' | lv_name_0_10= '<>' | lv_name_0_11= 'and' | lv_name_0_12= 'or' | lv_name_0_13= 'xor' | lv_name_0_14= 'implies' ) ) ) ;
    public final EObject ruleEssentialOCLInfixOperatorCS() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;
        Token lv_name_0_3=null;
        Token lv_name_0_4=null;
        Token lv_name_0_5=null;
        Token lv_name_0_6=null;
        Token lv_name_0_7=null;
        Token lv_name_0_8=null;
        Token lv_name_0_9=null;
        Token lv_name_0_10=null;
        Token lv_name_0_11=null;
        Token lv_name_0_12=null;
        Token lv_name_0_13=null;
        Token lv_name_0_14=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1176:28: ( ( ( (lv_name_0_1= '*' | lv_name_0_2= '/' | lv_name_0_3= '+' | lv_name_0_4= '-' | lv_name_0_5= '>' | lv_name_0_6= '<' | lv_name_0_7= '>=' | lv_name_0_8= '<=' | lv_name_0_9= '=' | lv_name_0_10= '<>' | lv_name_0_11= 'and' | lv_name_0_12= 'or' | lv_name_0_13= 'xor' | lv_name_0_14= 'implies' ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1177:1: ( ( (lv_name_0_1= '*' | lv_name_0_2= '/' | lv_name_0_3= '+' | lv_name_0_4= '-' | lv_name_0_5= '>' | lv_name_0_6= '<' | lv_name_0_7= '>=' | lv_name_0_8= '<=' | lv_name_0_9= '=' | lv_name_0_10= '<>' | lv_name_0_11= 'and' | lv_name_0_12= 'or' | lv_name_0_13= 'xor' | lv_name_0_14= 'implies' ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1177:1: ( ( (lv_name_0_1= '*' | lv_name_0_2= '/' | lv_name_0_3= '+' | lv_name_0_4= '-' | lv_name_0_5= '>' | lv_name_0_6= '<' | lv_name_0_7= '>=' | lv_name_0_8= '<=' | lv_name_0_9= '=' | lv_name_0_10= '<>' | lv_name_0_11= 'and' | lv_name_0_12= 'or' | lv_name_0_13= 'xor' | lv_name_0_14= 'implies' ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1178:1: ( (lv_name_0_1= '*' | lv_name_0_2= '/' | lv_name_0_3= '+' | lv_name_0_4= '-' | lv_name_0_5= '>' | lv_name_0_6= '<' | lv_name_0_7= '>=' | lv_name_0_8= '<=' | lv_name_0_9= '=' | lv_name_0_10= '<>' | lv_name_0_11= 'and' | lv_name_0_12= 'or' | lv_name_0_13= 'xor' | lv_name_0_14= 'implies' ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1178:1: ( (lv_name_0_1= '*' | lv_name_0_2= '/' | lv_name_0_3= '+' | lv_name_0_4= '-' | lv_name_0_5= '>' | lv_name_0_6= '<' | lv_name_0_7= '>=' | lv_name_0_8= '<=' | lv_name_0_9= '=' | lv_name_0_10= '<>' | lv_name_0_11= 'and' | lv_name_0_12= 'or' | lv_name_0_13= 'xor' | lv_name_0_14= 'implies' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1179:1: (lv_name_0_1= '*' | lv_name_0_2= '/' | lv_name_0_3= '+' | lv_name_0_4= '-' | lv_name_0_5= '>' | lv_name_0_6= '<' | lv_name_0_7= '>=' | lv_name_0_8= '<=' | lv_name_0_9= '=' | lv_name_0_10= '<>' | lv_name_0_11= 'and' | lv_name_0_12= 'or' | lv_name_0_13= 'xor' | lv_name_0_14= 'implies' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1179:1: (lv_name_0_1= '*' | lv_name_0_2= '/' | lv_name_0_3= '+' | lv_name_0_4= '-' | lv_name_0_5= '>' | lv_name_0_6= '<' | lv_name_0_7= '>=' | lv_name_0_8= '<=' | lv_name_0_9= '=' | lv_name_0_10= '<>' | lv_name_0_11= 'and' | lv_name_0_12= 'or' | lv_name_0_13= 'xor' | lv_name_0_14= 'implies' )
            int alt23=14;
            switch ( input.LA(1) ) {
            case 38:
                {
                alt23=1;
                }
                break;
            case 41:
                {
                alt23=2;
                }
                break;
            case 42:
                {
                alt23=3;
                }
                break;
            case 39:
                {
                alt23=4;
                }
                break;
            case 43:
                {
                alt23=5;
                }
                break;
            case 44:
                {
                alt23=6;
                }
                break;
            case 45:
                {
                alt23=7;
                }
                break;
            case 46:
                {
                alt23=8;
                }
                break;
            case 47:
                {
                alt23=9;
                }
                break;
            case 48:
                {
                alt23=10;
                }
                break;
            case 49:
                {
                alt23=11;
                }
                break;
            case 50:
                {
                alt23=12;
                }
                break;
            case 51:
                {
                alt23=13;
                }
                break;
            case 52:
                {
                alt23=14;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1180:3: lv_name_0_1= '*'
                    {
                    lv_name_0_1=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleEssentialOCLInfixOperatorCS2660); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_name_0_1, grammarAccess.getEssentialOCLInfixOperatorCSAccess().getNameAsteriskKeyword_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getEssentialOCLInfixOperatorCSRule());
                      	        }
                             		setWithLastConsumed(current, "name", lv_name_0_1, null);
                      	    
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1192:8: lv_name_0_2= '/'
                    {
                    lv_name_0_2=(Token)match(input,41,FollowSets000.FOLLOW_41_in_ruleEssentialOCLInfixOperatorCS2689); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_name_0_2, grammarAccess.getEssentialOCLInfixOperatorCSAccess().getNameSolidusKeyword_0_1());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getEssentialOCLInfixOperatorCSRule());
                      	        }
                             		setWithLastConsumed(current, "name", lv_name_0_2, null);
                      	    
                    }

                    }
                    break;
                case 3 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1204:8: lv_name_0_3= '+'
                    {
                    lv_name_0_3=(Token)match(input,42,FollowSets000.FOLLOW_42_in_ruleEssentialOCLInfixOperatorCS2718); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_name_0_3, grammarAccess.getEssentialOCLInfixOperatorCSAccess().getNamePlusSignKeyword_0_2());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getEssentialOCLInfixOperatorCSRule());
                      	        }
                             		setWithLastConsumed(current, "name", lv_name_0_3, null);
                      	    
                    }

                    }
                    break;
                case 4 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1216:8: lv_name_0_4= '-'
                    {
                    lv_name_0_4=(Token)match(input,39,FollowSets000.FOLLOW_39_in_ruleEssentialOCLInfixOperatorCS2747); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_name_0_4, grammarAccess.getEssentialOCLInfixOperatorCSAccess().getNameHyphenMinusKeyword_0_3());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getEssentialOCLInfixOperatorCSRule());
                      	        }
                             		setWithLastConsumed(current, "name", lv_name_0_4, null);
                      	    
                    }

                    }
                    break;
                case 5 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1228:8: lv_name_0_5= '>'
                    {
                    lv_name_0_5=(Token)match(input,43,FollowSets000.FOLLOW_43_in_ruleEssentialOCLInfixOperatorCS2776); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_name_0_5, grammarAccess.getEssentialOCLInfixOperatorCSAccess().getNameGreaterThanSignKeyword_0_4());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getEssentialOCLInfixOperatorCSRule());
                      	        }
                             		setWithLastConsumed(current, "name", lv_name_0_5, null);
                      	    
                    }

                    }
                    break;
                case 6 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1240:8: lv_name_0_6= '<'
                    {
                    lv_name_0_6=(Token)match(input,44,FollowSets000.FOLLOW_44_in_ruleEssentialOCLInfixOperatorCS2805); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_name_0_6, grammarAccess.getEssentialOCLInfixOperatorCSAccess().getNameLessThanSignKeyword_0_5());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getEssentialOCLInfixOperatorCSRule());
                      	        }
                             		setWithLastConsumed(current, "name", lv_name_0_6, null);
                      	    
                    }

                    }
                    break;
                case 7 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1252:8: lv_name_0_7= '>='
                    {
                    lv_name_0_7=(Token)match(input,45,FollowSets000.FOLLOW_45_in_ruleEssentialOCLInfixOperatorCS2834); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_name_0_7, grammarAccess.getEssentialOCLInfixOperatorCSAccess().getNameGreaterThanSignEqualsSignKeyword_0_6());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getEssentialOCLInfixOperatorCSRule());
                      	        }
                             		setWithLastConsumed(current, "name", lv_name_0_7, null);
                      	    
                    }

                    }
                    break;
                case 8 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1264:8: lv_name_0_8= '<='
                    {
                    lv_name_0_8=(Token)match(input,46,FollowSets000.FOLLOW_46_in_ruleEssentialOCLInfixOperatorCS2863); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_name_0_8, grammarAccess.getEssentialOCLInfixOperatorCSAccess().getNameLessThanSignEqualsSignKeyword_0_7());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getEssentialOCLInfixOperatorCSRule());
                      	        }
                             		setWithLastConsumed(current, "name", lv_name_0_8, null);
                      	    
                    }

                    }
                    break;
                case 9 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1276:8: lv_name_0_9= '='
                    {
                    lv_name_0_9=(Token)match(input,47,FollowSets000.FOLLOW_47_in_ruleEssentialOCLInfixOperatorCS2892); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_name_0_9, grammarAccess.getEssentialOCLInfixOperatorCSAccess().getNameEqualsSignKeyword_0_8());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getEssentialOCLInfixOperatorCSRule());
                      	        }
                             		setWithLastConsumed(current, "name", lv_name_0_9, null);
                      	    
                    }

                    }
                    break;
                case 10 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1288:8: lv_name_0_10= '<>'
                    {
                    lv_name_0_10=(Token)match(input,48,FollowSets000.FOLLOW_48_in_ruleEssentialOCLInfixOperatorCS2921); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_name_0_10, grammarAccess.getEssentialOCLInfixOperatorCSAccess().getNameLessThanSignGreaterThanSignKeyword_0_9());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getEssentialOCLInfixOperatorCSRule());
                      	        }
                             		setWithLastConsumed(current, "name", lv_name_0_10, null);
                      	    
                    }

                    }
                    break;
                case 11 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1300:8: lv_name_0_11= 'and'
                    {
                    lv_name_0_11=(Token)match(input,49,FollowSets000.FOLLOW_49_in_ruleEssentialOCLInfixOperatorCS2950); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_name_0_11, grammarAccess.getEssentialOCLInfixOperatorCSAccess().getNameAndKeyword_0_10());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getEssentialOCLInfixOperatorCSRule());
                      	        }
                             		setWithLastConsumed(current, "name", lv_name_0_11, null);
                      	    
                    }

                    }
                    break;
                case 12 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1312:8: lv_name_0_12= 'or'
                    {
                    lv_name_0_12=(Token)match(input,50,FollowSets000.FOLLOW_50_in_ruleEssentialOCLInfixOperatorCS2979); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_name_0_12, grammarAccess.getEssentialOCLInfixOperatorCSAccess().getNameOrKeyword_0_11());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getEssentialOCLInfixOperatorCSRule());
                      	        }
                             		setWithLastConsumed(current, "name", lv_name_0_12, null);
                      	    
                    }

                    }
                    break;
                case 13 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1324:8: lv_name_0_13= 'xor'
                    {
                    lv_name_0_13=(Token)match(input,51,FollowSets000.FOLLOW_51_in_ruleEssentialOCLInfixOperatorCS3008); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_name_0_13, grammarAccess.getEssentialOCLInfixOperatorCSAccess().getNameXorKeyword_0_12());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getEssentialOCLInfixOperatorCSRule());
                      	        }
                             		setWithLastConsumed(current, "name", lv_name_0_13, null);
                      	    
                    }

                    }
                    break;
                case 14 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1336:8: lv_name_0_14= 'implies'
                    {
                    lv_name_0_14=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleEssentialOCLInfixOperatorCS3037); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_name_0_14, grammarAccess.getEssentialOCLInfixOperatorCSAccess().getNameImpliesKeyword_0_13());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getEssentialOCLInfixOperatorCSRule());
                      	        }
                             		setWithLastConsumed(current, "name", lv_name_0_14, null);
                      	    
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
    // $ANTLR end "ruleEssentialOCLInfixOperatorCS"


    // $ANTLR start "entryRuleEssentialOCLNavigationOperatorCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1359:1: entryRuleEssentialOCLNavigationOperatorCS returns [EObject current=null] : iv_ruleEssentialOCLNavigationOperatorCS= ruleEssentialOCLNavigationOperatorCS EOF ;
    public final EObject entryRuleEssentialOCLNavigationOperatorCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEssentialOCLNavigationOperatorCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1360:2: (iv_ruleEssentialOCLNavigationOperatorCS= ruleEssentialOCLNavigationOperatorCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1361:2: iv_ruleEssentialOCLNavigationOperatorCS= ruleEssentialOCLNavigationOperatorCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEssentialOCLNavigationOperatorCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLNavigationOperatorCS_in_entryRuleEssentialOCLNavigationOperatorCS3088);
            iv_ruleEssentialOCLNavigationOperatorCS=ruleEssentialOCLNavigationOperatorCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEssentialOCLNavigationOperatorCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEssentialOCLNavigationOperatorCS3098); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEssentialOCLNavigationOperatorCS"


    // $ANTLR start "ruleEssentialOCLNavigationOperatorCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1368:1: ruleEssentialOCLNavigationOperatorCS returns [EObject current=null] : ( ( (lv_name_0_1= '.' | lv_name_0_2= '->' ) ) ) ;
    public final EObject ruleEssentialOCLNavigationOperatorCS() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1371:28: ( ( ( (lv_name_0_1= '.' | lv_name_0_2= '->' ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1372:1: ( ( (lv_name_0_1= '.' | lv_name_0_2= '->' ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1372:1: ( ( (lv_name_0_1= '.' | lv_name_0_2= '->' ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1373:1: ( (lv_name_0_1= '.' | lv_name_0_2= '->' ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1373:1: ( (lv_name_0_1= '.' | lv_name_0_2= '->' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1374:1: (lv_name_0_1= '.' | lv_name_0_2= '->' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1374:1: (lv_name_0_1= '.' | lv_name_0_2= '->' )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==53) ) {
                alt24=1;
            }
            else if ( (LA24_0==54) ) {
                alt24=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1375:3: lv_name_0_1= '.'
                    {
                    lv_name_0_1=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleEssentialOCLNavigationOperatorCS3142); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_name_0_1, grammarAccess.getEssentialOCLNavigationOperatorCSAccess().getNameFullStopKeyword_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getEssentialOCLNavigationOperatorCSRule());
                      	        }
                             		setWithLastConsumed(current, "name", lv_name_0_1, null);
                      	    
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1387:8: lv_name_0_2= '->'
                    {
                    lv_name_0_2=(Token)match(input,54,FollowSets000.FOLLOW_54_in_ruleEssentialOCLNavigationOperatorCS3171); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_name_0_2, grammarAccess.getEssentialOCLNavigationOperatorCSAccess().getNameHyphenMinusGreaterThanSignKeyword_0_1());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getEssentialOCLNavigationOperatorCSRule());
                      	        }
                             		setWithLastConsumed(current, "name", lv_name_0_2, null);
                      	    
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
    // $ANTLR end "ruleEssentialOCLNavigationOperatorCS"


    // $ANTLR start "entryRuleIdentifier"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1410:1: entryRuleIdentifier returns [String current=null] : iv_ruleIdentifier= ruleIdentifier EOF ;
    public final String entryRuleIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdentifier = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1411:2: (iv_ruleIdentifier= ruleIdentifier EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1412:2: iv_ruleIdentifier= ruleIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIdentifierRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_entryRuleIdentifier3223);
            iv_ruleIdentifier=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIdentifier.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIdentifier3234); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1419:1: ruleIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= ruleID ;
    public final AntlrDatatypeRuleToken ruleIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_ID_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1422:28: (this_ID_0= ruleID )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1424:5: this_ID_0= ruleID
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getIdentifierAccess().getIDParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleID_in_ruleIdentifier3280);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1442:1: entryRuleStringLiteral returns [String current=null] : iv_ruleStringLiteral= ruleStringLiteral EOF ;
    public final String entryRuleStringLiteral() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleStringLiteral = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1443:2: (iv_ruleStringLiteral= ruleStringLiteral EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1444:2: iv_ruleStringLiteral= ruleStringLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStringLiteralRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral3325);
            iv_ruleStringLiteral=ruleStringLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStringLiteral.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleStringLiteral3336); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1451:1: ruleStringLiteral returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING ;
    public final AntlrDatatypeRuleToken ruleStringLiteral() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_SINGLE_QUOTED_STRING_0=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1454:28: (this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1455:5: this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING
            {
            this_SINGLE_QUOTED_STRING_0=(Token)match(input,RULE_SINGLE_QUOTED_STRING,FollowSets000.FOLLOW_RULE_SINGLE_QUOTED_STRING_in_ruleStringLiteral3375); if (state.failed) return current;
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


    // $ANTLR start "entryRuleBinaryOperatorCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1470:1: entryRuleBinaryOperatorCS returns [EObject current=null] : iv_ruleBinaryOperatorCS= ruleBinaryOperatorCS EOF ;
    public final EObject entryRuleBinaryOperatorCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinaryOperatorCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1471:2: (iv_ruleBinaryOperatorCS= ruleBinaryOperatorCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1472:2: iv_ruleBinaryOperatorCS= ruleBinaryOperatorCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBinaryOperatorCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleBinaryOperatorCS_in_entryRuleBinaryOperatorCS3419);
            iv_ruleBinaryOperatorCS=ruleBinaryOperatorCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBinaryOperatorCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBinaryOperatorCS3429); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1479:1: ruleBinaryOperatorCS returns [EObject current=null] : (this_InfixOperatorCS_0= ruleInfixOperatorCS | this_NavigationOperatorCS_1= ruleNavigationOperatorCS ) ;
    public final EObject ruleBinaryOperatorCS() throws RecognitionException {
        EObject current = null;

        EObject this_InfixOperatorCS_0 = null;

        EObject this_NavigationOperatorCS_1 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1482:28: ( (this_InfixOperatorCS_0= ruleInfixOperatorCS | this_NavigationOperatorCS_1= ruleNavigationOperatorCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1483:1: (this_InfixOperatorCS_0= ruleInfixOperatorCS | this_NavigationOperatorCS_1= ruleNavigationOperatorCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1483:1: (this_InfixOperatorCS_0= ruleInfixOperatorCS | this_NavigationOperatorCS_1= ruleNavigationOperatorCS )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( ((LA25_0>=38 && LA25_0<=39)||(LA25_0>=41 && LA25_0<=52)) ) {
                alt25=1;
            }
            else if ( ((LA25_0>=53 && LA25_0<=54)) ) {
                alt25=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1484:2: this_InfixOperatorCS_0= ruleInfixOperatorCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBinaryOperatorCSAccess().getInfixOperatorCSParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleInfixOperatorCS_in_ruleBinaryOperatorCS3479);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1497:2: this_NavigationOperatorCS_1= ruleNavigationOperatorCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBinaryOperatorCSAccess().getNavigationOperatorCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNavigationOperatorCS_in_ruleBinaryOperatorCS3509);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1516:1: entryRuleInfixOperatorCS returns [EObject current=null] : iv_ruleInfixOperatorCS= ruleInfixOperatorCS EOF ;
    public final EObject entryRuleInfixOperatorCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInfixOperatorCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1517:2: (iv_ruleInfixOperatorCS= ruleInfixOperatorCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1518:2: iv_ruleInfixOperatorCS= ruleInfixOperatorCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInfixOperatorCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleInfixOperatorCS_in_entryRuleInfixOperatorCS3544);
            iv_ruleInfixOperatorCS=ruleInfixOperatorCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInfixOperatorCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleInfixOperatorCS3554); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1525:1: ruleInfixOperatorCS returns [EObject current=null] : this_EssentialOCLInfixOperatorCS_0= ruleEssentialOCLInfixOperatorCS ;
    public final EObject ruleInfixOperatorCS() throws RecognitionException {
        EObject current = null;

        EObject this_EssentialOCLInfixOperatorCS_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1528:28: (this_EssentialOCLInfixOperatorCS_0= ruleEssentialOCLInfixOperatorCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1530:2: this_EssentialOCLInfixOperatorCS_0= ruleEssentialOCLInfixOperatorCS
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getInfixOperatorCSAccess().getEssentialOCLInfixOperatorCSParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLInfixOperatorCS_in_ruleInfixOperatorCS3603);
            this_EssentialOCLInfixOperatorCS_0=ruleEssentialOCLInfixOperatorCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_EssentialOCLInfixOperatorCS_0; 
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
    // $ANTLR end "ruleInfixOperatorCS"


    // $ANTLR start "entryRuleNavigationOperatorCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1549:1: entryRuleNavigationOperatorCS returns [EObject current=null] : iv_ruleNavigationOperatorCS= ruleNavigationOperatorCS EOF ;
    public final EObject entryRuleNavigationOperatorCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigationOperatorCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1550:2: (iv_ruleNavigationOperatorCS= ruleNavigationOperatorCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1551:2: iv_ruleNavigationOperatorCS= ruleNavigationOperatorCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigationOperatorCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigationOperatorCS_in_entryRuleNavigationOperatorCS3637);
            iv_ruleNavigationOperatorCS=ruleNavigationOperatorCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigationOperatorCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigationOperatorCS3647); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1558:1: ruleNavigationOperatorCS returns [EObject current=null] : this_EssentialOCLNavigationOperatorCS_0= ruleEssentialOCLNavigationOperatorCS ;
    public final EObject ruleNavigationOperatorCS() throws RecognitionException {
        EObject current = null;

        EObject this_EssentialOCLNavigationOperatorCS_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1561:28: (this_EssentialOCLNavigationOperatorCS_0= ruleEssentialOCLNavigationOperatorCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1563:2: this_EssentialOCLNavigationOperatorCS_0= ruleEssentialOCLNavigationOperatorCS
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getNavigationOperatorCSAccess().getEssentialOCLNavigationOperatorCSParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLNavigationOperatorCS_in_ruleNavigationOperatorCS3696);
            this_EssentialOCLNavigationOperatorCS_0=ruleEssentialOCLNavigationOperatorCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_EssentialOCLNavigationOperatorCS_0; 
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
    // $ANTLR end "ruleNavigationOperatorCS"


    // $ANTLR start "entryRuleUnaryOperatorCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1582:1: entryRuleUnaryOperatorCS returns [EObject current=null] : iv_ruleUnaryOperatorCS= ruleUnaryOperatorCS EOF ;
    public final EObject entryRuleUnaryOperatorCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryOperatorCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1583:2: (iv_ruleUnaryOperatorCS= ruleUnaryOperatorCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1584:2: iv_ruleUnaryOperatorCS= ruleUnaryOperatorCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryOperatorCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnaryOperatorCS_in_entryRuleUnaryOperatorCS3730);
            iv_ruleUnaryOperatorCS=ruleUnaryOperatorCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnaryOperatorCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnaryOperatorCS3740); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1591:1: ruleUnaryOperatorCS returns [EObject current=null] : this_EssentialOCLUnaryOperatorCS_0= ruleEssentialOCLUnaryOperatorCS ;
    public final EObject ruleUnaryOperatorCS() throws RecognitionException {
        EObject current = null;

        EObject this_EssentialOCLUnaryOperatorCS_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1594:28: (this_EssentialOCLUnaryOperatorCS_0= ruleEssentialOCLUnaryOperatorCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1596:2: this_EssentialOCLUnaryOperatorCS_0= ruleEssentialOCLUnaryOperatorCS
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getUnaryOperatorCSAccess().getEssentialOCLUnaryOperatorCSParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLUnaryOperatorCS_in_ruleUnaryOperatorCS3789);
            this_EssentialOCLUnaryOperatorCS_0=ruleEssentialOCLUnaryOperatorCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_EssentialOCLUnaryOperatorCS_0; 
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
    // $ANTLR end "ruleUnaryOperatorCS"


    // $ANTLR start "entryRuleEssentialOCLUnrestrictedName"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1615:1: entryRuleEssentialOCLUnrestrictedName returns [String current=null] : iv_ruleEssentialOCLUnrestrictedName= ruleEssentialOCLUnrestrictedName EOF ;
    public final String entryRuleEssentialOCLUnrestrictedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEssentialOCLUnrestrictedName = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1616:2: (iv_ruleEssentialOCLUnrestrictedName= ruleEssentialOCLUnrestrictedName EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1617:2: iv_ruleEssentialOCLUnrestrictedName= ruleEssentialOCLUnrestrictedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEssentialOCLUnrestrictedNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLUnrestrictedName_in_entryRuleEssentialOCLUnrestrictedName3824);
            iv_ruleEssentialOCLUnrestrictedName=ruleEssentialOCLUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEssentialOCLUnrestrictedName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEssentialOCLUnrestrictedName3835); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1624:1: ruleEssentialOCLUnrestrictedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_Identifier_0= ruleIdentifier ;
    public final AntlrDatatypeRuleToken ruleEssentialOCLUnrestrictedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_Identifier_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1627:28: (this_Identifier_0= ruleIdentifier )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1629:5: this_Identifier_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getEssentialOCLUnrestrictedNameAccess().getIdentifierParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_ruleEssentialOCLUnrestrictedName3881);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1647:1: entryRuleEssentialOCLUnreservedName returns [String current=null] : iv_ruleEssentialOCLUnreservedName= ruleEssentialOCLUnreservedName EOF ;
    public final String entryRuleEssentialOCLUnreservedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEssentialOCLUnreservedName = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1648:2: (iv_ruleEssentialOCLUnreservedName= ruleEssentialOCLUnreservedName EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1649:2: iv_ruleEssentialOCLUnreservedName= ruleEssentialOCLUnreservedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEssentialOCLUnreservedNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLUnreservedName_in_entryRuleEssentialOCLUnreservedName3926);
            iv_ruleEssentialOCLUnreservedName=ruleEssentialOCLUnreservedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEssentialOCLUnreservedName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEssentialOCLUnreservedName3937); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1656:1: ruleEssentialOCLUnreservedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_UnrestrictedName_0= ruleUnrestrictedName | this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier | this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier | kw= 'Tuple' ) ;
    public final AntlrDatatypeRuleToken ruleEssentialOCLUnreservedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_UnrestrictedName_0 = null;

        AntlrDatatypeRuleToken this_CollectionTypeIdentifier_1 = null;

        AntlrDatatypeRuleToken this_PrimitiveTypeIdentifier_2 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1659:28: ( (this_UnrestrictedName_0= ruleUnrestrictedName | this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier | this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier | kw= 'Tuple' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1660:1: (this_UnrestrictedName_0= ruleUnrestrictedName | this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier | this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier | kw= 'Tuple' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1660:1: (this_UnrestrictedName_0= ruleUnrestrictedName | this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier | this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier | kw= 'Tuple' )
            int alt26=4;
            switch ( input.LA(1) ) {
            case RULE_SIMPLE_ID:
            case RULE_ESCAPED_ID:
            case 23:
            case 24:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
                {
                alt26=1;
                }
                break;
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
                {
                alt26=2;
                }
                break;
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
                {
                alt26=3;
                }
                break;
            case 55:
                {
                alt26=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }

            switch (alt26) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1661:5: this_UnrestrictedName_0= ruleUnrestrictedName
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getEssentialOCLUnreservedNameAccess().getUnrestrictedNameParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleEssentialOCLUnreservedName3984);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1673:5: this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getEssentialOCLUnreservedNameAccess().getCollectionTypeIdentifierParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCollectionTypeIdentifier_in_ruleEssentialOCLUnreservedName4017);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1685:5: this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getEssentialOCLUnreservedNameAccess().getPrimitiveTypeIdentifierParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrimitiveTypeIdentifier_in_ruleEssentialOCLUnreservedName4050);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1697:2: kw= 'Tuple'
                    {
                    kw=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleEssentialOCLUnreservedName4074); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1710:1: entryRuleUnreservedName returns [String current=null] : iv_ruleUnreservedName= ruleUnreservedName EOF ;
    public final String entryRuleUnreservedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnreservedName = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1711:2: (iv_ruleUnreservedName= ruleUnreservedName EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1712:2: iv_ruleUnreservedName= ruleUnreservedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnreservedNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnreservedName_in_entryRuleUnreservedName4115);
            iv_ruleUnreservedName=ruleUnreservedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnreservedName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnreservedName4126); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1719:1: ruleUnreservedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_EssentialOCLUnreservedName_0= ruleEssentialOCLUnreservedName ;
    public final AntlrDatatypeRuleToken ruleUnreservedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_EssentialOCLUnreservedName_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1722:28: (this_EssentialOCLUnreservedName_0= ruleEssentialOCLUnreservedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1724:5: this_EssentialOCLUnreservedName_0= ruleEssentialOCLUnreservedName
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getUnreservedNameAccess().getEssentialOCLUnreservedNameParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLUnreservedName_in_ruleUnreservedName4172);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1742:1: entryRulePathNameCS returns [EObject current=null] : iv_rulePathNameCS= rulePathNameCS EOF ;
    public final EObject entryRulePathNameCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePathNameCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1743:2: (iv_rulePathNameCS= rulePathNameCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1744:2: iv_rulePathNameCS= rulePathNameCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPathNameCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePathNameCS_in_entryRulePathNameCS4216);
            iv_rulePathNameCS=rulePathNameCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePathNameCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePathNameCS4226); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1751:1: rulePathNameCS returns [EObject current=null] : ( ( (lv_path_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )* ) ;
    public final EObject rulePathNameCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_path_0_0 = null;

        EObject lv_path_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1754:28: ( ( ( (lv_path_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )* ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1755:1: ( ( (lv_path_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )* )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1755:1: ( ( (lv_path_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )* )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1755:2: ( (lv_path_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )*
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1755:2: ( (lv_path_0_0= ruleFirstPathElementCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1756:1: (lv_path_0_0= ruleFirstPathElementCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1756:1: (lv_path_0_0= ruleFirstPathElementCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1757:3: lv_path_0_0= ruleFirstPathElementCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPathNameCSAccess().getPathFirstPathElementCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleFirstPathElementCS_in_rulePathNameCS4272);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1773:2: (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==28) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1773:4: otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) )
            	    {
            	    otherlv_1=(Token)match(input,28,FollowSets000.FOLLOW_28_in_rulePathNameCS4285); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getPathNameCSAccess().getColonColonKeyword_1_0());
            	          
            	    }
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1777:1: ( (lv_path_2_0= ruleNextPathElementCS ) )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1778:1: (lv_path_2_0= ruleNextPathElementCS )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1778:1: (lv_path_2_0= ruleNextPathElementCS )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1779:3: lv_path_2_0= ruleNextPathElementCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getPathNameCSAccess().getPathNextPathElementCSParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleNextPathElementCS_in_rulePathNameCS4306);
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
            	    break loop27;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1803:1: entryRuleFirstPathElementCS returns [EObject current=null] : iv_ruleFirstPathElementCS= ruleFirstPathElementCS EOF ;
    public final EObject entryRuleFirstPathElementCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFirstPathElementCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1804:2: (iv_ruleFirstPathElementCS= ruleFirstPathElementCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1805:2: iv_ruleFirstPathElementCS= ruleFirstPathElementCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFirstPathElementCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleFirstPathElementCS_in_entryRuleFirstPathElementCS4344);
            iv_ruleFirstPathElementCS=ruleFirstPathElementCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFirstPathElementCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFirstPathElementCS4354); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1812:1: ruleFirstPathElementCS returns [EObject current=null] : ( ( ruleUnrestrictedName ) ) ;
    public final EObject ruleFirstPathElementCS() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1815:28: ( ( ( ruleUnrestrictedName ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1816:1: ( ( ruleUnrestrictedName ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1816:1: ( ( ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1817:1: ( ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1817:1: ( ruleUnrestrictedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1818:3: ruleUnrestrictedName
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
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleFirstPathElementCS4405);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1842:1: entryRuleNextPathElementCS returns [EObject current=null] : iv_ruleNextPathElementCS= ruleNextPathElementCS EOF ;
    public final EObject entryRuleNextPathElementCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNextPathElementCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1843:2: (iv_ruleNextPathElementCS= ruleNextPathElementCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1844:2: iv_ruleNextPathElementCS= ruleNextPathElementCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNextPathElementCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNextPathElementCS_in_entryRuleNextPathElementCS4440);
            iv_ruleNextPathElementCS=ruleNextPathElementCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNextPathElementCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNextPathElementCS4450); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1851:1: ruleNextPathElementCS returns [EObject current=null] : ( ( ruleUnreservedName ) ) ;
    public final EObject ruleNextPathElementCS() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1854:28: ( ( ( ruleUnreservedName ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1855:1: ( ( ruleUnreservedName ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1855:1: ( ( ruleUnreservedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1856:1: ( ruleUnreservedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1856:1: ( ruleUnreservedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1857:3: ruleUnreservedName
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
            pushFollow(FollowSets000.FOLLOW_ruleUnreservedName_in_ruleNextPathElementCS4501);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1881:1: entryRuleURIPathNameCS returns [EObject current=null] : iv_ruleURIPathNameCS= ruleURIPathNameCS EOF ;
    public final EObject entryRuleURIPathNameCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleURIPathNameCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1882:2: (iv_ruleURIPathNameCS= ruleURIPathNameCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1883:2: iv_ruleURIPathNameCS= ruleURIPathNameCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getURIPathNameCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleURIPathNameCS_in_entryRuleURIPathNameCS4536);
            iv_ruleURIPathNameCS=ruleURIPathNameCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleURIPathNameCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleURIPathNameCS4546); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1890:1: ruleURIPathNameCS returns [EObject current=null] : ( ( (lv_path_0_0= ruleURIFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )* ) ;
    public final EObject ruleURIPathNameCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_path_0_0 = null;

        EObject lv_path_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1893:28: ( ( ( (lv_path_0_0= ruleURIFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )* ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1894:1: ( ( (lv_path_0_0= ruleURIFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )* )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1894:1: ( ( (lv_path_0_0= ruleURIFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )* )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1894:2: ( (lv_path_0_0= ruleURIFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )*
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1894:2: ( (lv_path_0_0= ruleURIFirstPathElementCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1895:1: (lv_path_0_0= ruleURIFirstPathElementCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1895:1: (lv_path_0_0= ruleURIFirstPathElementCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1896:3: lv_path_0_0= ruleURIFirstPathElementCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getURIPathNameCSAccess().getPathURIFirstPathElementCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleURIFirstPathElementCS_in_ruleURIPathNameCS4592);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1912:2: (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==28) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1912:4: otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) )
            	    {
            	    otherlv_1=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleURIPathNameCS4605); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getURIPathNameCSAccess().getColonColonKeyword_1_0());
            	          
            	    }
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1916:1: ( (lv_path_2_0= ruleNextPathElementCS ) )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1917:1: (lv_path_2_0= ruleNextPathElementCS )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1917:1: (lv_path_2_0= ruleNextPathElementCS )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1918:3: lv_path_2_0= ruleNextPathElementCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getURIPathNameCSAccess().getPathNextPathElementCSParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleNextPathElementCS_in_ruleURIPathNameCS4626);
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
            	    break loop28;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1942:1: entryRuleURIFirstPathElementCS returns [EObject current=null] : iv_ruleURIFirstPathElementCS= ruleURIFirstPathElementCS EOF ;
    public final EObject entryRuleURIFirstPathElementCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleURIFirstPathElementCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1943:2: (iv_ruleURIFirstPathElementCS= ruleURIFirstPathElementCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1944:2: iv_ruleURIFirstPathElementCS= ruleURIFirstPathElementCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getURIFirstPathElementCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleURIFirstPathElementCS_in_entryRuleURIFirstPathElementCS4664);
            iv_ruleURIFirstPathElementCS=ruleURIFirstPathElementCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleURIFirstPathElementCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleURIFirstPathElementCS4674); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1951:1: ruleURIFirstPathElementCS returns [EObject current=null] : ( ( ( ruleUnrestrictedName ) ) | ( () ( ( ruleURI ) ) ) ) ;
    public final EObject ruleURIFirstPathElementCS() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1954:28: ( ( ( ( ruleUnrestrictedName ) ) | ( () ( ( ruleURI ) ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1955:1: ( ( ( ruleUnrestrictedName ) ) | ( () ( ( ruleURI ) ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1955:1: ( ( ( ruleUnrestrictedName ) ) | ( () ( ( ruleURI ) ) ) )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( ((LA29_0>=RULE_SIMPLE_ID && LA29_0<=RULE_ESCAPED_ID)||(LA29_0>=23 && LA29_0<=24)||(LA29_0>=29 && LA29_0<=37)) ) {
                alt29=1;
            }
            else if ( (LA29_0==RULE_SINGLE_QUOTED_STRING) ) {
                alt29=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1955:2: ( ( ruleUnrestrictedName ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1955:2: ( ( ruleUnrestrictedName ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1956:1: ( ruleUnrestrictedName )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1956:1: ( ruleUnrestrictedName )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1957:3: ruleUnrestrictedName
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
                    pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleURIFirstPathElementCS4726);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1974:6: ( () ( ( ruleURI ) ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1974:6: ( () ( ( ruleURI ) ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1974:7: () ( ( ruleURI ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1974:7: ()
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1975:2: 
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

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1983:2: ( ( ruleURI ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1984:1: ( ruleURI )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1984:1: ( ruleURI )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:1985:3: ruleURI
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
                    pushFollow(FollowSets000.FOLLOW_ruleURI_in_ruleURIFirstPathElementCS4772);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2009:1: entryRulePrimitiveTypeIdentifier returns [String current=null] : iv_rulePrimitiveTypeIdentifier= rulePrimitiveTypeIdentifier EOF ;
    public final String entryRulePrimitiveTypeIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePrimitiveTypeIdentifier = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2010:2: (iv_rulePrimitiveTypeIdentifier= rulePrimitiveTypeIdentifier EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2011:2: iv_rulePrimitiveTypeIdentifier= rulePrimitiveTypeIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimitiveTypeIdentifierRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePrimitiveTypeIdentifier_in_entryRulePrimitiveTypeIdentifier4810);
            iv_rulePrimitiveTypeIdentifier=rulePrimitiveTypeIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimitiveTypeIdentifier.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrimitiveTypeIdentifier4821); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2018:1: rulePrimitiveTypeIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Boolean' | kw= 'Integer' | kw= 'Real' | kw= 'String' | kw= 'UnlimitedNatural' | kw= 'OclAny' | kw= 'OclInvalid' | kw= 'OclVoid' ) ;
    public final AntlrDatatypeRuleToken rulePrimitiveTypeIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2021:28: ( (kw= 'Boolean' | kw= 'Integer' | kw= 'Real' | kw= 'String' | kw= 'UnlimitedNatural' | kw= 'OclAny' | kw= 'OclInvalid' | kw= 'OclVoid' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2022:1: (kw= 'Boolean' | kw= 'Integer' | kw= 'Real' | kw= 'String' | kw= 'UnlimitedNatural' | kw= 'OclAny' | kw= 'OclInvalid' | kw= 'OclVoid' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2022:1: (kw= 'Boolean' | kw= 'Integer' | kw= 'Real' | kw= 'String' | kw= 'UnlimitedNatural' | kw= 'OclAny' | kw= 'OclInvalid' | kw= 'OclVoid' )
            int alt30=8;
            switch ( input.LA(1) ) {
            case 56:
                {
                alt30=1;
                }
                break;
            case 57:
                {
                alt30=2;
                }
                break;
            case 58:
                {
                alt30=3;
                }
                break;
            case 59:
                {
                alt30=4;
                }
                break;
            case 60:
                {
                alt30=5;
                }
                break;
            case 61:
                {
                alt30=6;
                }
                break;
            case 62:
                {
                alt30=7;
                }
                break;
            case 63:
                {
                alt30=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2023:2: kw= 'Boolean'
                    {
                    kw=(Token)match(input,56,FollowSets000.FOLLOW_56_in_rulePrimitiveTypeIdentifier4859); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getBooleanKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2030:2: kw= 'Integer'
                    {
                    kw=(Token)match(input,57,FollowSets000.FOLLOW_57_in_rulePrimitiveTypeIdentifier4878); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getIntegerKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2037:2: kw= 'Real'
                    {
                    kw=(Token)match(input,58,FollowSets000.FOLLOW_58_in_rulePrimitiveTypeIdentifier4897); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getRealKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2044:2: kw= 'String'
                    {
                    kw=(Token)match(input,59,FollowSets000.FOLLOW_59_in_rulePrimitiveTypeIdentifier4916); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getStringKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2051:2: kw= 'UnlimitedNatural'
                    {
                    kw=(Token)match(input,60,FollowSets000.FOLLOW_60_in_rulePrimitiveTypeIdentifier4935); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getUnlimitedNaturalKeyword_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2058:2: kw= 'OclAny'
                    {
                    kw=(Token)match(input,61,FollowSets000.FOLLOW_61_in_rulePrimitiveTypeIdentifier4954); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getOclAnyKeyword_5()); 
                          
                    }

                    }
                    break;
                case 7 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2065:2: kw= 'OclInvalid'
                    {
                    kw=(Token)match(input,62,FollowSets000.FOLLOW_62_in_rulePrimitiveTypeIdentifier4973); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getOclInvalidKeyword_6()); 
                          
                    }

                    }
                    break;
                case 8 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2072:2: kw= 'OclVoid'
                    {
                    kw=(Token)match(input,63,FollowSets000.FOLLOW_63_in_rulePrimitiveTypeIdentifier4992); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2085:1: entryRulePrimitiveTypeCS returns [EObject current=null] : iv_rulePrimitiveTypeCS= rulePrimitiveTypeCS EOF ;
    public final EObject entryRulePrimitiveTypeCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveTypeCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2086:2: (iv_rulePrimitiveTypeCS= rulePrimitiveTypeCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2087:2: iv_rulePrimitiveTypeCS= rulePrimitiveTypeCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimitiveTypeCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePrimitiveTypeCS_in_entryRulePrimitiveTypeCS5032);
            iv_rulePrimitiveTypeCS=rulePrimitiveTypeCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimitiveTypeCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrimitiveTypeCS5042); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2094:1: rulePrimitiveTypeCS returns [EObject current=null] : ( (lv_name_0_0= rulePrimitiveTypeIdentifier ) ) ;
    public final EObject rulePrimitiveTypeCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2097:28: ( ( (lv_name_0_0= rulePrimitiveTypeIdentifier ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2098:1: ( (lv_name_0_0= rulePrimitiveTypeIdentifier ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2098:1: ( (lv_name_0_0= rulePrimitiveTypeIdentifier ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2099:1: (lv_name_0_0= rulePrimitiveTypeIdentifier )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2099:1: (lv_name_0_0= rulePrimitiveTypeIdentifier )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2100:3: lv_name_0_0= rulePrimitiveTypeIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPrimitiveTypeCSAccess().getNamePrimitiveTypeIdentifierParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_rulePrimitiveTypeIdentifier_in_rulePrimitiveTypeCS5087);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2124:1: entryRuleCollectionTypeIdentifier returns [String current=null] : iv_ruleCollectionTypeIdentifier= ruleCollectionTypeIdentifier EOF ;
    public final String entryRuleCollectionTypeIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleCollectionTypeIdentifier = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2125:2: (iv_ruleCollectionTypeIdentifier= ruleCollectionTypeIdentifier EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2126:2: iv_ruleCollectionTypeIdentifier= ruleCollectionTypeIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCollectionTypeIdentifierRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleCollectionTypeIdentifier_in_entryRuleCollectionTypeIdentifier5123);
            iv_ruleCollectionTypeIdentifier=ruleCollectionTypeIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCollectionTypeIdentifier.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCollectionTypeIdentifier5134); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2133:1: ruleCollectionTypeIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Set' | kw= 'Bag' | kw= 'Sequence' | kw= 'Collection' | kw= 'OrderedSet' ) ;
    public final AntlrDatatypeRuleToken ruleCollectionTypeIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2136:28: ( (kw= 'Set' | kw= 'Bag' | kw= 'Sequence' | kw= 'Collection' | kw= 'OrderedSet' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2137:1: (kw= 'Set' | kw= 'Bag' | kw= 'Sequence' | kw= 'Collection' | kw= 'OrderedSet' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2137:1: (kw= 'Set' | kw= 'Bag' | kw= 'Sequence' | kw= 'Collection' | kw= 'OrderedSet' )
            int alt31=5;
            switch ( input.LA(1) ) {
            case 64:
                {
                alt31=1;
                }
                break;
            case 65:
                {
                alt31=2;
                }
                break;
            case 66:
                {
                alt31=3;
                }
                break;
            case 67:
                {
                alt31=4;
                }
                break;
            case 68:
                {
                alt31=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }

            switch (alt31) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2138:2: kw= 'Set'
                    {
                    kw=(Token)match(input,64,FollowSets000.FOLLOW_64_in_ruleCollectionTypeIdentifier5172); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getSetKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2145:2: kw= 'Bag'
                    {
                    kw=(Token)match(input,65,FollowSets000.FOLLOW_65_in_ruleCollectionTypeIdentifier5191); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getBagKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2152:2: kw= 'Sequence'
                    {
                    kw=(Token)match(input,66,FollowSets000.FOLLOW_66_in_ruleCollectionTypeIdentifier5210); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getSequenceKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2159:2: kw= 'Collection'
                    {
                    kw=(Token)match(input,67,FollowSets000.FOLLOW_67_in_ruleCollectionTypeIdentifier5229); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getCollectionKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2166:2: kw= 'OrderedSet'
                    {
                    kw=(Token)match(input,68,FollowSets000.FOLLOW_68_in_ruleCollectionTypeIdentifier5248); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2179:1: entryRuleCollectionTypeCS returns [EObject current=null] : iv_ruleCollectionTypeCS= ruleCollectionTypeCS EOF ;
    public final EObject entryRuleCollectionTypeCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionTypeCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2180:2: (iv_ruleCollectionTypeCS= ruleCollectionTypeCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2181:2: iv_ruleCollectionTypeCS= ruleCollectionTypeCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCollectionTypeCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleCollectionTypeCS_in_entryRuleCollectionTypeCS5288);
            iv_ruleCollectionTypeCS=ruleCollectionTypeCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCollectionTypeCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCollectionTypeCS5298); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2188:1: ruleCollectionTypeCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )? ) ;
    public final EObject ruleCollectionTypeCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2191:28: ( ( ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2192:1: ( ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2192:1: ( ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2192:2: ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )?
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2192:2: ( (lv_name_0_0= ruleCollectionTypeIdentifier ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2193:1: (lv_name_0_0= ruleCollectionTypeIdentifier )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2193:1: (lv_name_0_0= ruleCollectionTypeIdentifier )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2194:3: lv_name_0_0= ruleCollectionTypeIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCollectionTypeCSAccess().getNameCollectionTypeIdentifierParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleCollectionTypeIdentifier_in_ruleCollectionTypeCS5344);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2210:2: (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==25) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2210:4: otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleCollectionTypeCS5357); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getCollectionTypeCSAccess().getLeftParenthesisKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2214:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2215:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2215:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2216:3: lv_ownedType_2_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionTypeCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleCollectionTypeCS5378);
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

                    otherlv_3=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleCollectionTypeCS5390); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2244:1: entryRuleMultiplicityBoundsCS returns [EObject current=null] : iv_ruleMultiplicityBoundsCS= ruleMultiplicityBoundsCS EOF ;
    public final EObject entryRuleMultiplicityBoundsCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicityBoundsCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2245:2: (iv_ruleMultiplicityBoundsCS= ruleMultiplicityBoundsCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2246:2: iv_ruleMultiplicityBoundsCS= ruleMultiplicityBoundsCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicityBoundsCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMultiplicityBoundsCS_in_entryRuleMultiplicityBoundsCS5428);
            iv_ruleMultiplicityBoundsCS=ruleMultiplicityBoundsCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicityBoundsCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMultiplicityBoundsCS5438); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2253:1: ruleMultiplicityBoundsCS returns [EObject current=null] : ( ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )? ) ;
    public final EObject ruleMultiplicityBoundsCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_lowerBound_0_0 = null;

        AntlrDatatypeRuleToken lv_upperBound_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2256:28: ( ( ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2257:1: ( ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2257:1: ( ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2257:2: ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )?
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2257:2: ( (lv_lowerBound_0_0= ruleLOWER ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2258:1: (lv_lowerBound_0_0= ruleLOWER )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2258:1: (lv_lowerBound_0_0= ruleLOWER )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2259:3: lv_lowerBound_0_0= ruleLOWER
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiplicityBoundsCSAccess().getLowerBoundLOWERParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleLOWER_in_ruleMultiplicityBoundsCS5484);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2275:2: (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==69) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2275:4: otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) )
                    {
                    otherlv_1=(Token)match(input,69,FollowSets000.FOLLOW_69_in_ruleMultiplicityBoundsCS5497); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getMultiplicityBoundsCSAccess().getFullStopFullStopKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2279:1: ( (lv_upperBound_2_0= ruleUPPER ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2280:1: (lv_upperBound_2_0= ruleUPPER )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2280:1: (lv_upperBound_2_0= ruleUPPER )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2281:3: lv_upperBound_2_0= ruleUPPER
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMultiplicityBoundsCSAccess().getUpperBoundUPPERParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUPPER_in_ruleMultiplicityBoundsCS5518);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2305:1: entryRuleMultiplicityCS returns [EObject current=null] : iv_ruleMultiplicityCS= ruleMultiplicityCS EOF ;
    public final EObject entryRuleMultiplicityCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicityCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2306:2: (iv_ruleMultiplicityCS= ruleMultiplicityCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2307:2: iv_ruleMultiplicityCS= ruleMultiplicityCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicityCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMultiplicityCS_in_entryRuleMultiplicityCS5556);
            iv_ruleMultiplicityCS=ruleMultiplicityCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicityCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMultiplicityCS5566); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2314:1: ruleMultiplicityCS returns [EObject current=null] : (otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) otherlv_3= ']' ) ;
    public final EObject ruleMultiplicityCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        EObject this_MultiplicityBoundsCS_1 = null;

        EObject this_MultiplicityStringCS_2 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2317:28: ( (otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) otherlv_3= ']' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2318:1: (otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) otherlv_3= ']' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2318:1: (otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) otherlv_3= ']' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2318:3: otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) otherlv_3= ']'
            {
            otherlv_0=(Token)match(input,70,FollowSets000.FOLLOW_70_in_ruleMultiplicityCS5603); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMultiplicityCSAccess().getLeftSquareBracketKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2322:1: (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==RULE_INT) ) {
                alt34=1;
            }
            else if ( (LA34_0==38||LA34_0==42||LA34_0==72) ) {
                alt34=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2323:2: this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getMultiplicityCSAccess().getMultiplicityBoundsCSParserRuleCall_1_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMultiplicityBoundsCS_in_ruleMultiplicityCS5629);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2336:2: this_MultiplicityStringCS_2= ruleMultiplicityStringCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getMultiplicityCSAccess().getMultiplicityStringCSParserRuleCall_1_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMultiplicityStringCS_in_ruleMultiplicityCS5659);
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

            otherlv_3=(Token)match(input,71,FollowSets000.FOLLOW_71_in_ruleMultiplicityCS5671); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2359:1: entryRuleMultiplicityStringCS returns [EObject current=null] : iv_ruleMultiplicityStringCS= ruleMultiplicityStringCS EOF ;
    public final EObject entryRuleMultiplicityStringCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicityStringCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2360:2: (iv_ruleMultiplicityStringCS= ruleMultiplicityStringCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2361:2: iv_ruleMultiplicityStringCS= ruleMultiplicityStringCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicityStringCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMultiplicityStringCS_in_entryRuleMultiplicityStringCS5707);
            iv_ruleMultiplicityStringCS=ruleMultiplicityStringCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicityStringCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMultiplicityStringCS5717); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2368:1: ruleMultiplicityStringCS returns [EObject current=null] : ( ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) ) ) ;
    public final EObject ruleMultiplicityStringCS() throws RecognitionException {
        EObject current = null;

        Token lv_stringBounds_0_1=null;
        Token lv_stringBounds_0_2=null;
        Token lv_stringBounds_0_3=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2371:28: ( ( ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2372:1: ( ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2372:1: ( ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2373:1: ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2373:1: ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2374:1: (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2374:1: (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' )
            int alt35=3;
            switch ( input.LA(1) ) {
            case 38:
                {
                alt35=1;
                }
                break;
            case 42:
                {
                alt35=2;
                }
                break;
            case 72:
                {
                alt35=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }

            switch (alt35) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2375:3: lv_stringBounds_0_1= '*'
                    {
                    lv_stringBounds_0_1=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleMultiplicityStringCS5761); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2387:8: lv_stringBounds_0_2= '+'
                    {
                    lv_stringBounds_0_2=(Token)match(input,42,FollowSets000.FOLLOW_42_in_ruleMultiplicityStringCS5790); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2399:8: lv_stringBounds_0_3= '?'
                    {
                    lv_stringBounds_0_3=(Token)match(input,72,FollowSets000.FOLLOW_72_in_ruleMultiplicityStringCS5819); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2422:1: entryRuleTupleTypeCS returns [EObject current=null] : iv_ruleTupleTypeCS= ruleTupleTypeCS EOF ;
    public final EObject entryRuleTupleTypeCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTupleTypeCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2423:2: (iv_ruleTupleTypeCS= ruleTupleTypeCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2424:2: iv_ruleTupleTypeCS= ruleTupleTypeCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTupleTypeCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTupleTypeCS_in_entryRuleTupleTypeCS5870);
            iv_ruleTupleTypeCS=ruleTupleTypeCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTupleTypeCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTupleTypeCS5880); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2431:1: ruleTupleTypeCS returns [EObject current=null] : ( ( (lv_name_0_0= 'Tuple' ) ) (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )? ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2434:28: ( ( ( (lv_name_0_0= 'Tuple' ) ) (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2435:1: ( ( (lv_name_0_0= 'Tuple' ) ) (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2435:1: ( ( (lv_name_0_0= 'Tuple' ) ) (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2435:2: ( (lv_name_0_0= 'Tuple' ) ) (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )?
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2435:2: ( (lv_name_0_0= 'Tuple' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2436:1: (lv_name_0_0= 'Tuple' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2436:1: (lv_name_0_0= 'Tuple' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2437:3: lv_name_0_0= 'Tuple'
            {
            lv_name_0_0=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleTupleTypeCS5923); if (state.failed) return current;
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2450:2: (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==25) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2450:4: otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')'
                    {
                    otherlv_1=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleTupleTypeCS5949); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getTupleTypeCSAccess().getLeftParenthesisKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2454:1: ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )?
                    int alt37=2;
                    int LA37_0 = input.LA(1);

                    if ( ((LA37_0>=RULE_SIMPLE_ID && LA37_0<=RULE_ESCAPED_ID)||(LA37_0>=23 && LA37_0<=24)||(LA37_0>=29 && LA37_0<=37)) ) {
                        alt37=1;
                    }
                    switch (alt37) {
                        case 1 :
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2454:2: ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )*
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2454:2: ( (lv_ownedParts_2_0= ruleTuplePartCS ) )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2455:1: (lv_ownedParts_2_0= ruleTuplePartCS )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2455:1: (lv_ownedParts_2_0= ruleTuplePartCS )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2456:3: lv_ownedParts_2_0= ruleTuplePartCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getTupleTypeCSAccess().getOwnedPartsTuplePartCSParserRuleCall_1_1_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleTuplePartCS_in_ruleTupleTypeCS5971);
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

                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2472:2: (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )*
                            loop36:
                            do {
                                int alt36=2;
                                int LA36_0 = input.LA(1);

                                if ( (LA36_0==17) ) {
                                    alt36=1;
                                }


                                switch (alt36) {
                            	case 1 :
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2472:4: otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) )
                            	    {
                            	    otherlv_3=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleTupleTypeCS5984); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_3, grammarAccess.getTupleTypeCSAccess().getCommaKeyword_1_1_1_0());
                            	          
                            	    }
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2476:1: ( (lv_ownedParts_4_0= ruleTuplePartCS ) )
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2477:1: (lv_ownedParts_4_0= ruleTuplePartCS )
                            	    {
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2477:1: (lv_ownedParts_4_0= ruleTuplePartCS )
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2478:3: lv_ownedParts_4_0= ruleTuplePartCS
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getTupleTypeCSAccess().getOwnedPartsTuplePartCSParserRuleCall_1_1_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FollowSets000.FOLLOW_ruleTuplePartCS_in_ruleTupleTypeCS6005);
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
                            	    break loop36;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_5=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleTupleTypeCS6021); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2506:1: entryRuleTuplePartCS returns [EObject current=null] : iv_ruleTuplePartCS= ruleTuplePartCS EOF ;
    public final EObject entryRuleTuplePartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTuplePartCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2507:2: (iv_ruleTuplePartCS= ruleTuplePartCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2508:2: iv_ruleTuplePartCS= ruleTuplePartCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTuplePartCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTuplePartCS_in_entryRuleTuplePartCS6059);
            iv_ruleTuplePartCS=ruleTuplePartCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTuplePartCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTuplePartCS6069); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2515:1: ruleTuplePartCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) ) ;
    public final EObject ruleTuplePartCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2518:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2519:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2519:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2519:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2519:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2520:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2520:1: (lv_name_0_0= ruleUnrestrictedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2521:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTuplePartCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleTuplePartCS6115);
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

            otherlv_1=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleTuplePartCS6127); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getTuplePartCSAccess().getColonKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2541:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2542:1: (lv_ownedType_2_0= ruleTypeExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2542:1: (lv_ownedType_2_0= ruleTypeExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2543:3: lv_ownedType_2_0= ruleTypeExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTuplePartCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleTuplePartCS6148);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2567:1: entryRuleCollectionLiteralExpCS returns [EObject current=null] : iv_ruleCollectionLiteralExpCS= ruleCollectionLiteralExpCS EOF ;
    public final EObject entryRuleCollectionLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2568:2: (iv_ruleCollectionLiteralExpCS= ruleCollectionLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2569:2: iv_ruleCollectionLiteralExpCS= ruleCollectionLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCollectionLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteralExpCS_in_entryRuleCollectionLiteralExpCS6184);
            iv_ruleCollectionLiteralExpCS=ruleCollectionLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCollectionLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCollectionLiteralExpCS6194); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2576:1: ruleCollectionLiteralExpCS returns [EObject current=null] : ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}' ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2579:28: ( ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2580:1: ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2580:1: ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2580:2: ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}'
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2580:2: ( (lv_ownedType_0_0= ruleCollectionTypeCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2581:1: (lv_ownedType_0_0= ruleCollectionTypeCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2581:1: (lv_ownedType_0_0= ruleCollectionTypeCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2582:3: lv_ownedType_0_0= ruleCollectionTypeCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedTypeCollectionTypeCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleCollectionTypeCS_in_ruleCollectionLiteralExpCS6240);
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

            otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleCollectionLiteralExpCS6252); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getCollectionLiteralExpCSAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2602:1: ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( ((LA40_0>=RULE_SIMPLE_ID && LA40_0<=RULE_SINGLE_QUOTED_STRING)||(LA40_0>=23 && LA40_0<=25)||(LA40_0>=29 && LA40_0<=40)||(LA40_0>=55 && LA40_0<=68)||(LA40_0>=73 && LA40_0<=76)||LA40_0==79||LA40_0==83||LA40_0==85) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2602:2: ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )*
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2602:2: ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2603:1: (lv_ownedParts_2_0= ruleCollectionLiteralPartCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2603:1: (lv_ownedParts_2_0= ruleCollectionLiteralPartCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2604:3: lv_ownedParts_2_0= ruleCollectionLiteralPartCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedPartsCollectionLiteralPartCSParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteralPartCS_in_ruleCollectionLiteralExpCS6274);
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

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2620:2: (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )*
                    loop39:
                    do {
                        int alt39=2;
                        int LA39_0 = input.LA(1);

                        if ( (LA39_0==17) ) {
                            alt39=1;
                        }


                        switch (alt39) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2620:4: otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) )
                    	    {
                    	    otherlv_3=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleCollectionLiteralExpCS6287); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getCollectionLiteralExpCSAccess().getCommaKeyword_2_1_0());
                    	          
                    	    }
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2624:1: ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2625:1: (lv_ownedParts_4_0= ruleCollectionLiteralPartCS )
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2625:1: (lv_ownedParts_4_0= ruleCollectionLiteralPartCS )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2626:3: lv_ownedParts_4_0= ruleCollectionLiteralPartCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedPartsCollectionLiteralPartCSParserRuleCall_2_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteralPartCS_in_ruleCollectionLiteralExpCS6308);
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
                    	    break loop39;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleCollectionLiteralExpCS6324); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2654:1: entryRuleCollectionLiteralPartCS returns [EObject current=null] : iv_ruleCollectionLiteralPartCS= ruleCollectionLiteralPartCS EOF ;
    public final EObject entryRuleCollectionLiteralPartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionLiteralPartCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2655:2: (iv_ruleCollectionLiteralPartCS= ruleCollectionLiteralPartCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2656:2: iv_ruleCollectionLiteralPartCS= ruleCollectionLiteralPartCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCollectionLiteralPartCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteralPartCS_in_entryRuleCollectionLiteralPartCS6360);
            iv_ruleCollectionLiteralPartCS=ruleCollectionLiteralPartCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCollectionLiteralPartCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCollectionLiteralPartCS6370); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2663:1: ruleCollectionLiteralPartCS returns [EObject current=null] : ( ( (lv_expressionCS_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_lastExpressionCS_2_0= ruleExpCS ) ) )? ) ;
    public final EObject ruleCollectionLiteralPartCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expressionCS_0_0 = null;

        EObject lv_lastExpressionCS_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2666:28: ( ( ( (lv_expressionCS_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_lastExpressionCS_2_0= ruleExpCS ) ) )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2667:1: ( ( (lv_expressionCS_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_lastExpressionCS_2_0= ruleExpCS ) ) )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2667:1: ( ( (lv_expressionCS_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_lastExpressionCS_2_0= ruleExpCS ) ) )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2667:2: ( (lv_expressionCS_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_lastExpressionCS_2_0= ruleExpCS ) ) )?
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2667:2: ( (lv_expressionCS_0_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2668:1: (lv_expressionCS_0_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2668:1: (lv_expressionCS_0_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2669:3: lv_expressionCS_0_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCollectionLiteralPartCSAccess().getExpressionCSExpCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleCollectionLiteralPartCS6416);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2685:2: (otherlv_1= '..' ( (lv_lastExpressionCS_2_0= ruleExpCS ) ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==69) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2685:4: otherlv_1= '..' ( (lv_lastExpressionCS_2_0= ruleExpCS ) )
                    {
                    otherlv_1=(Token)match(input,69,FollowSets000.FOLLOW_69_in_ruleCollectionLiteralPartCS6429); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getCollectionLiteralPartCSAccess().getFullStopFullStopKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2689:1: ( (lv_lastExpressionCS_2_0= ruleExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2690:1: (lv_lastExpressionCS_2_0= ruleExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2690:1: (lv_lastExpressionCS_2_0= ruleExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2691:3: lv_lastExpressionCS_2_0= ruleExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionLiteralPartCSAccess().getLastExpressionCSExpCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleCollectionLiteralPartCS6450);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2715:1: entryRuleConstructorPartCS returns [EObject current=null] : iv_ruleConstructorPartCS= ruleConstructorPartCS EOF ;
    public final EObject entryRuleConstructorPartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstructorPartCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2716:2: (iv_ruleConstructorPartCS= ruleConstructorPartCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2717:2: iv_ruleConstructorPartCS= ruleConstructorPartCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstructorPartCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleConstructorPartCS_in_entryRuleConstructorPartCS6488);
            iv_ruleConstructorPartCS=ruleConstructorPartCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConstructorPartCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleConstructorPartCS6498); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2724:1: ruleConstructorPartCS returns [EObject current=null] : ( ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( (lv_initExpression_2_0= ruleExpCS ) ) ) ;
    public final EObject ruleConstructorPartCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_initExpression_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2727:28: ( ( ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( (lv_initExpression_2_0= ruleExpCS ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2728:1: ( ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( (lv_initExpression_2_0= ruleExpCS ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2728:1: ( ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( (lv_initExpression_2_0= ruleExpCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2728:2: ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( (lv_initExpression_2_0= ruleExpCS ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2728:2: ( ( ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2729:1: ( ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2729:1: ( ruleUnrestrictedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2730:3: ruleUnrestrictedName
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
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleConstructorPartCS6550);
            ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,47,FollowSets000.FOLLOW_47_in_ruleConstructorPartCS6562); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getConstructorPartCSAccess().getEqualsSignKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2750:1: ( (lv_initExpression_2_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2751:1: (lv_initExpression_2_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2751:1: (lv_initExpression_2_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2752:3: lv_initExpression_2_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getConstructorPartCSAccess().getInitExpressionExpCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleConstructorPartCS6583);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2776:1: entryRulePrimitiveLiteralExpCS returns [EObject current=null] : iv_rulePrimitiveLiteralExpCS= rulePrimitiveLiteralExpCS EOF ;
    public final EObject entryRulePrimitiveLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2777:2: (iv_rulePrimitiveLiteralExpCS= rulePrimitiveLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2778:2: iv_rulePrimitiveLiteralExpCS= rulePrimitiveLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePrimitiveLiteralExpCS_in_entryRulePrimitiveLiteralExpCS6619);
            iv_rulePrimitiveLiteralExpCS=rulePrimitiveLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimitiveLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrimitiveLiteralExpCS6629); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2785:1: rulePrimitiveLiteralExpCS returns [EObject current=null] : (this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS | this_StringLiteralExpCS_1= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_5= ruleNullLiteralExpCS ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2788:28: ( (this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS | this_StringLiteralExpCS_1= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_5= ruleNullLiteralExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2789:1: (this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS | this_StringLiteralExpCS_1= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_5= ruleNullLiteralExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2789:1: (this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS | this_StringLiteralExpCS_1= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_5= ruleNullLiteralExpCS )
            int alt42=6;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt42=1;
                }
                break;
            case RULE_SINGLE_QUOTED_STRING:
                {
                alt42=2;
                }
                break;
            case 73:
            case 74:
                {
                alt42=3;
                }
                break;
            case 38:
                {
                alt42=4;
                }
                break;
            case 75:
                {
                alt42=5;
                }
                break;
            case 76:
                {
                alt42=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }

            switch (alt42) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2790:2: this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getNumberLiteralExpCSParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNumberLiteralExpCS_in_rulePrimitiveLiteralExpCS6679);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2803:2: this_StringLiteralExpCS_1= ruleStringLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getStringLiteralExpCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleStringLiteralExpCS_in_rulePrimitiveLiteralExpCS6709);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2816:2: this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getBooleanLiteralExpCSParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleBooleanLiteralExpCS_in_rulePrimitiveLiteralExpCS6739);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2829:2: this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getUnlimitedNaturalLiteralExpCSParserRuleCall_3()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUnlimitedNaturalLiteralExpCS_in_rulePrimitiveLiteralExpCS6769);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2842:2: this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getInvalidLiteralExpCSParserRuleCall_4()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleInvalidLiteralExpCS_in_rulePrimitiveLiteralExpCS6799);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2855:2: this_NullLiteralExpCS_5= ruleNullLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getNullLiteralExpCSParserRuleCall_5()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNullLiteralExpCS_in_rulePrimitiveLiteralExpCS6829);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2874:1: entryRuleTupleLiteralExpCS returns [EObject current=null] : iv_ruleTupleLiteralExpCS= ruleTupleLiteralExpCS EOF ;
    public final EObject entryRuleTupleLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTupleLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2875:2: (iv_ruleTupleLiteralExpCS= ruleTupleLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2876:2: iv_ruleTupleLiteralExpCS= ruleTupleLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTupleLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralExpCS_in_entryRuleTupleLiteralExpCS6864);
            iv_ruleTupleLiteralExpCS=ruleTupleLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTupleLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTupleLiteralExpCS6874); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2883:1: ruleTupleLiteralExpCS returns [EObject current=null] : (otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}' ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2886:28: ( (otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2887:1: (otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2887:1: (otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2887:3: otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleTupleLiteralExpCS6911); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getTupleLiteralExpCSAccess().getTupleKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleTupleLiteralExpCS6923); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getTupleLiteralExpCSAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2895:1: ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2896:1: (lv_ownedParts_2_0= ruleTupleLiteralPartCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2896:1: (lv_ownedParts_2_0= ruleTupleLiteralPartCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2897:3: lv_ownedParts_2_0= ruleTupleLiteralPartCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTupleLiteralExpCSAccess().getOwnedPartsTupleLiteralPartCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralPartCS_in_ruleTupleLiteralExpCS6944);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2913:2: (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==17) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2913:4: otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) )
            	    {
            	    otherlv_3=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleTupleLiteralExpCS6957); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getTupleLiteralExpCSAccess().getCommaKeyword_3_0());
            	          
            	    }
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2917:1: ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2918:1: (lv_ownedParts_4_0= ruleTupleLiteralPartCS )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2918:1: (lv_ownedParts_4_0= ruleTupleLiteralPartCS )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2919:3: lv_ownedParts_4_0= ruleTupleLiteralPartCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTupleLiteralExpCSAccess().getOwnedPartsTupleLiteralPartCSParserRuleCall_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralPartCS_in_ruleTupleLiteralExpCS6978);
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
            	    break loop43;
                }
            } while (true);

            otherlv_5=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleTupleLiteralExpCS6992); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2947:1: entryRuleTupleLiteralPartCS returns [EObject current=null] : iv_ruleTupleLiteralPartCS= ruleTupleLiteralPartCS EOF ;
    public final EObject entryRuleTupleLiteralPartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTupleLiteralPartCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2948:2: (iv_ruleTupleLiteralPartCS= ruleTupleLiteralPartCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2949:2: iv_ruleTupleLiteralPartCS= ruleTupleLiteralPartCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTupleLiteralPartCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralPartCS_in_entryRuleTupleLiteralPartCS7028);
            iv_ruleTupleLiteralPartCS=ruleTupleLiteralPartCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTupleLiteralPartCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTupleLiteralPartCS7038); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2956:1: ruleTupleLiteralPartCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) ) ) ;
    public final EObject ruleTupleLiteralPartCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;

        EObject lv_initExpression_4_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2959:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2960:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2960:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2960:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2960:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2961:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2961:1: (lv_name_0_0= ruleUnrestrictedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2962:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTupleLiteralPartCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleTupleLiteralPartCS7084);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2978:2: (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==27) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2978:4: otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                    {
                    otherlv_1=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleTupleLiteralPartCS7097); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getTupleLiteralPartCSAccess().getColonKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2982:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2983:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2983:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:2984:3: lv_ownedType_2_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTupleLiteralPartCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleTupleLiteralPartCS7118);
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

            otherlv_3=(Token)match(input,47,FollowSets000.FOLLOW_47_in_ruleTupleLiteralPartCS7132); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getTupleLiteralPartCSAccess().getEqualsSignKeyword_2());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3004:1: ( (lv_initExpression_4_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3005:1: (lv_initExpression_4_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3005:1: (lv_initExpression_4_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3006:3: lv_initExpression_4_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTupleLiteralPartCSAccess().getInitExpressionExpCSParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleTupleLiteralPartCS7153);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3030:1: entryRuleNumberLiteralExpCS returns [EObject current=null] : iv_ruleNumberLiteralExpCS= ruleNumberLiteralExpCS EOF ;
    public final EObject entryRuleNumberLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3031:2: (iv_ruleNumberLiteralExpCS= ruleNumberLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3032:2: iv_ruleNumberLiteralExpCS= ruleNumberLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumberLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNumberLiteralExpCS_in_entryRuleNumberLiteralExpCS7189);
            iv_ruleNumberLiteralExpCS=ruleNumberLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumberLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNumberLiteralExpCS7199); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3039:1: ruleNumberLiteralExpCS returns [EObject current=null] : ( (lv_name_0_0= ruleNUMBER_LITERAL ) ) ;
    public final EObject ruleNumberLiteralExpCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3042:28: ( ( (lv_name_0_0= ruleNUMBER_LITERAL ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3043:1: ( (lv_name_0_0= ruleNUMBER_LITERAL ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3043:1: ( (lv_name_0_0= ruleNUMBER_LITERAL ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3044:1: (lv_name_0_0= ruleNUMBER_LITERAL )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3044:1: (lv_name_0_0= ruleNUMBER_LITERAL )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3045:3: lv_name_0_0= ruleNUMBER_LITERAL
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNumberLiteralExpCSAccess().getNameNUMBER_LITERALParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleNUMBER_LITERAL_in_ruleNumberLiteralExpCS7244);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3069:1: entryRuleStringLiteralExpCS returns [EObject current=null] : iv_ruleStringLiteralExpCS= ruleStringLiteralExpCS EOF ;
    public final EObject entryRuleStringLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3070:2: (iv_ruleStringLiteralExpCS= ruleStringLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3071:2: iv_ruleStringLiteralExpCS= ruleStringLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStringLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleStringLiteralExpCS_in_entryRuleStringLiteralExpCS7279);
            iv_ruleStringLiteralExpCS=ruleStringLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStringLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleStringLiteralExpCS7289); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3078:1: ruleStringLiteralExpCS returns [EObject current=null] : ( (lv_name_0_0= ruleStringLiteral ) )+ ;
    public final EObject ruleStringLiteralExpCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3081:28: ( ( (lv_name_0_0= ruleStringLiteral ) )+ )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3082:1: ( (lv_name_0_0= ruleStringLiteral ) )+
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3082:1: ( (lv_name_0_0= ruleStringLiteral ) )+
            int cnt45=0;
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==RULE_SINGLE_QUOTED_STRING) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3083:1: (lv_name_0_0= ruleStringLiteral )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3083:1: (lv_name_0_0= ruleStringLiteral )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3084:3: lv_name_0_0= ruleStringLiteral
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getStringLiteralExpCSAccess().getNameStringLiteralParserRuleCall_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleStringLiteral_in_ruleStringLiteralExpCS7334);
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
            	    if ( cnt45 >= 1 ) break loop45;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(45, input);
                        throw eee;
                }
                cnt45++;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3108:1: entryRuleBooleanLiteralExpCS returns [EObject current=null] : iv_ruleBooleanLiteralExpCS= ruleBooleanLiteralExpCS EOF ;
    public final EObject entryRuleBooleanLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3109:2: (iv_ruleBooleanLiteralExpCS= ruleBooleanLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3110:2: iv_ruleBooleanLiteralExpCS= ruleBooleanLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBooleanLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleBooleanLiteralExpCS_in_entryRuleBooleanLiteralExpCS7370);
            iv_ruleBooleanLiteralExpCS=ruleBooleanLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBooleanLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBooleanLiteralExpCS7380); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3117:1: ruleBooleanLiteralExpCS returns [EObject current=null] : ( ( (lv_name_0_0= 'true' ) ) | ( (lv_name_1_0= 'false' ) ) ) ;
    public final EObject ruleBooleanLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3120:28: ( ( ( (lv_name_0_0= 'true' ) ) | ( (lv_name_1_0= 'false' ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3121:1: ( ( (lv_name_0_0= 'true' ) ) | ( (lv_name_1_0= 'false' ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3121:1: ( ( (lv_name_0_0= 'true' ) ) | ( (lv_name_1_0= 'false' ) ) )
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==73) ) {
                alt46=1;
            }
            else if ( (LA46_0==74) ) {
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3121:2: ( (lv_name_0_0= 'true' ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3121:2: ( (lv_name_0_0= 'true' ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3122:1: (lv_name_0_0= 'true' )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3122:1: (lv_name_0_0= 'true' )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3123:3: lv_name_0_0= 'true'
                    {
                    lv_name_0_0=(Token)match(input,73,FollowSets000.FOLLOW_73_in_ruleBooleanLiteralExpCS7423); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3137:6: ( (lv_name_1_0= 'false' ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3137:6: ( (lv_name_1_0= 'false' ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3138:1: (lv_name_1_0= 'false' )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3138:1: (lv_name_1_0= 'false' )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3139:3: lv_name_1_0= 'false'
                    {
                    lv_name_1_0=(Token)match(input,74,FollowSets000.FOLLOW_74_in_ruleBooleanLiteralExpCS7460); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3160:1: entryRuleUnlimitedNaturalLiteralExpCS returns [EObject current=null] : iv_ruleUnlimitedNaturalLiteralExpCS= ruleUnlimitedNaturalLiteralExpCS EOF ;
    public final EObject entryRuleUnlimitedNaturalLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnlimitedNaturalLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3161:2: (iv_ruleUnlimitedNaturalLiteralExpCS= ruleUnlimitedNaturalLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3162:2: iv_ruleUnlimitedNaturalLiteralExpCS= ruleUnlimitedNaturalLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnlimitedNaturalLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnlimitedNaturalLiteralExpCS_in_entryRuleUnlimitedNaturalLiteralExpCS7509);
            iv_ruleUnlimitedNaturalLiteralExpCS=ruleUnlimitedNaturalLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnlimitedNaturalLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnlimitedNaturalLiteralExpCS7519); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3169:1: ruleUnlimitedNaturalLiteralExpCS returns [EObject current=null] : ( () otherlv_1= '*' ) ;
    public final EObject ruleUnlimitedNaturalLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3172:28: ( ( () otherlv_1= '*' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3173:1: ( () otherlv_1= '*' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3173:1: ( () otherlv_1= '*' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3173:2: () otherlv_1= '*'
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3173:2: ()
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3174:2: 
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

            otherlv_1=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleUnlimitedNaturalLiteralExpCS7568); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3194:1: entryRuleInvalidLiteralExpCS returns [EObject current=null] : iv_ruleInvalidLiteralExpCS= ruleInvalidLiteralExpCS EOF ;
    public final EObject entryRuleInvalidLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInvalidLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3195:2: (iv_ruleInvalidLiteralExpCS= ruleInvalidLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3196:2: iv_ruleInvalidLiteralExpCS= ruleInvalidLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInvalidLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleInvalidLiteralExpCS_in_entryRuleInvalidLiteralExpCS7604);
            iv_ruleInvalidLiteralExpCS=ruleInvalidLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInvalidLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleInvalidLiteralExpCS7614); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3203:1: ruleInvalidLiteralExpCS returns [EObject current=null] : ( () otherlv_1= 'invalid' ) ;
    public final EObject ruleInvalidLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3206:28: ( ( () otherlv_1= 'invalid' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3207:1: ( () otherlv_1= 'invalid' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3207:1: ( () otherlv_1= 'invalid' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3207:2: () otherlv_1= 'invalid'
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3207:2: ()
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3208:2: 
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

            otherlv_1=(Token)match(input,75,FollowSets000.FOLLOW_75_in_ruleInvalidLiteralExpCS7663); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3228:1: entryRuleNullLiteralExpCS returns [EObject current=null] : iv_ruleNullLiteralExpCS= ruleNullLiteralExpCS EOF ;
    public final EObject entryRuleNullLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3229:2: (iv_ruleNullLiteralExpCS= ruleNullLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3230:2: iv_ruleNullLiteralExpCS= ruleNullLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNullLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNullLiteralExpCS_in_entryRuleNullLiteralExpCS7699);
            iv_ruleNullLiteralExpCS=ruleNullLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNullLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNullLiteralExpCS7709); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3237:1: ruleNullLiteralExpCS returns [EObject current=null] : ( () otherlv_1= 'null' ) ;
    public final EObject ruleNullLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3240:28: ( ( () otherlv_1= 'null' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3241:1: ( () otherlv_1= 'null' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3241:1: ( () otherlv_1= 'null' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3241:2: () otherlv_1= 'null'
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3241:2: ()
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3242:2: 
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

            otherlv_1=(Token)match(input,76,FollowSets000.FOLLOW_76_in_ruleNullLiteralExpCS7758); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3262:1: entryRuleTypeLiteralCS returns [EObject current=null] : iv_ruleTypeLiteralCS= ruleTypeLiteralCS EOF ;
    public final EObject entryRuleTypeLiteralCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeLiteralCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3263:2: (iv_ruleTypeLiteralCS= ruleTypeLiteralCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3264:2: iv_ruleTypeLiteralCS= ruleTypeLiteralCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeLiteralCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralCS_in_entryRuleTypeLiteralCS7794);
            iv_ruleTypeLiteralCS=ruleTypeLiteralCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeLiteralCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeLiteralCS7804); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3271:1: ruleTypeLiteralCS returns [EObject current=null] : (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS | this_CollectionTypeCS_1= ruleCollectionTypeCS | this_TupleTypeCS_2= ruleTupleTypeCS ) ;
    public final EObject ruleTypeLiteralCS() throws RecognitionException {
        EObject current = null;

        EObject this_PrimitiveTypeCS_0 = null;

        EObject this_CollectionTypeCS_1 = null;

        EObject this_TupleTypeCS_2 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3274:28: ( (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS | this_CollectionTypeCS_1= ruleCollectionTypeCS | this_TupleTypeCS_2= ruleTupleTypeCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3275:1: (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS | this_CollectionTypeCS_1= ruleCollectionTypeCS | this_TupleTypeCS_2= ruleTupleTypeCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3275:1: (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS | this_CollectionTypeCS_1= ruleCollectionTypeCS | this_TupleTypeCS_2= ruleTupleTypeCS )
            int alt47=3;
            switch ( input.LA(1) ) {
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
                {
                alt47=1;
                }
                break;
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
                {
                alt47=2;
                }
                break;
            case 55:
                {
                alt47=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }

            switch (alt47) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3276:2: this_PrimitiveTypeCS_0= rulePrimitiveTypeCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeLiteralCSAccess().getPrimitiveTypeCSParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrimitiveTypeCS_in_ruleTypeLiteralCS7854);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3289:2: this_CollectionTypeCS_1= ruleCollectionTypeCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeLiteralCSAccess().getCollectionTypeCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCollectionTypeCS_in_ruleTypeLiteralCS7884);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3302:2: this_TupleTypeCS_2= ruleTupleTypeCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeLiteralCSAccess().getTupleTypeCSParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTupleTypeCS_in_ruleTypeLiteralCS7914);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3321:1: entryRuleTypeLiteralWithMultiplicityCS returns [EObject current=null] : iv_ruleTypeLiteralWithMultiplicityCS= ruleTypeLiteralWithMultiplicityCS EOF ;
    public final EObject entryRuleTypeLiteralWithMultiplicityCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeLiteralWithMultiplicityCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3322:2: (iv_ruleTypeLiteralWithMultiplicityCS= ruleTypeLiteralWithMultiplicityCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3323:2: iv_ruleTypeLiteralWithMultiplicityCS= ruleTypeLiteralWithMultiplicityCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeLiteralWithMultiplicityCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralWithMultiplicityCS_in_entryRuleTypeLiteralWithMultiplicityCS7949);
            iv_ruleTypeLiteralWithMultiplicityCS=ruleTypeLiteralWithMultiplicityCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeLiteralWithMultiplicityCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeLiteralWithMultiplicityCS7959); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3330:1: ruleTypeLiteralWithMultiplicityCS returns [EObject current=null] : (this_TypeLiteralCS_0= ruleTypeLiteralCS ( (lv_multiplicity_1_0= ruleMultiplicityCS ) )? ) ;
    public final EObject ruleTypeLiteralWithMultiplicityCS() throws RecognitionException {
        EObject current = null;

        EObject this_TypeLiteralCS_0 = null;

        EObject lv_multiplicity_1_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3333:28: ( (this_TypeLiteralCS_0= ruleTypeLiteralCS ( (lv_multiplicity_1_0= ruleMultiplicityCS ) )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3334:1: (this_TypeLiteralCS_0= ruleTypeLiteralCS ( (lv_multiplicity_1_0= ruleMultiplicityCS ) )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3334:1: (this_TypeLiteralCS_0= ruleTypeLiteralCS ( (lv_multiplicity_1_0= ruleMultiplicityCS ) )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3335:2: this_TypeLiteralCS_0= ruleTypeLiteralCS ( (lv_multiplicity_1_0= ruleMultiplicityCS ) )?
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getTypeLiteralWithMultiplicityCSAccess().getTypeLiteralCSParserRuleCall_0()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralCS_in_ruleTypeLiteralWithMultiplicityCS8009);
            this_TypeLiteralCS_0=ruleTypeLiteralCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_TypeLiteralCS_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3346:1: ( (lv_multiplicity_1_0= ruleMultiplicityCS ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==70) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3347:1: (lv_multiplicity_1_0= ruleMultiplicityCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3347:1: (lv_multiplicity_1_0= ruleMultiplicityCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3348:3: lv_multiplicity_1_0= ruleMultiplicityCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeLiteralWithMultiplicityCSAccess().getMultiplicityMultiplicityCSParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMultiplicityCS_in_ruleTypeLiteralWithMultiplicityCS8029);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3372:1: entryRuleTypeLiteralExpCS returns [EObject current=null] : iv_ruleTypeLiteralExpCS= ruleTypeLiteralExpCS EOF ;
    public final EObject entryRuleTypeLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3373:2: (iv_ruleTypeLiteralExpCS= ruleTypeLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3374:2: iv_ruleTypeLiteralExpCS= ruleTypeLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralExpCS_in_entryRuleTypeLiteralExpCS8066);
            iv_ruleTypeLiteralExpCS=ruleTypeLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeLiteralExpCS8076); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3381:1: ruleTypeLiteralExpCS returns [EObject current=null] : ( (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS ) ) ;
    public final EObject ruleTypeLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject lv_ownedType_0_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3384:28: ( ( (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3385:1: ( (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3385:1: ( (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3386:1: (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3386:1: (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3387:3: lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypeLiteralExpCSAccess().getOwnedTypeTypeLiteralWithMultiplicityCSParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralWithMultiplicityCS_in_ruleTypeLiteralExpCS8121);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3411:1: entryRuleTypeNameExpCS returns [EObject current=null] : iv_ruleTypeNameExpCS= ruleTypeNameExpCS EOF ;
    public final EObject entryRuleTypeNameExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeNameExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3412:2: (iv_ruleTypeNameExpCS= ruleTypeNameExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3413:2: iv_ruleTypeNameExpCS= ruleTypeNameExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeNameExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeNameExpCS_in_entryRuleTypeNameExpCS8156);
            iv_ruleTypeNameExpCS=ruleTypeNameExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeNameExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeNameExpCS8166); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3420:1: ruleTypeNameExpCS returns [EObject current=null] : ( (lv_pathName_0_0= rulePathNameCS ) ) ;
    public final EObject ruleTypeNameExpCS() throws RecognitionException {
        EObject current = null;

        EObject lv_pathName_0_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3423:28: ( ( (lv_pathName_0_0= rulePathNameCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3424:1: ( (lv_pathName_0_0= rulePathNameCS ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3424:1: ( (lv_pathName_0_0= rulePathNameCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3425:1: (lv_pathName_0_0= rulePathNameCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3425:1: (lv_pathName_0_0= rulePathNameCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3426:3: lv_pathName_0_0= rulePathNameCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypeNameExpCSAccess().getPathNamePathNameCSParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_rulePathNameCS_in_ruleTypeNameExpCS8211);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3450:1: entryRuleTypeExpCS returns [EObject current=null] : iv_ruleTypeExpCS= ruleTypeExpCS EOF ;
    public final EObject entryRuleTypeExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3451:2: (iv_ruleTypeExpCS= ruleTypeExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3452:2: iv_ruleTypeExpCS= ruleTypeExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_entryRuleTypeExpCS8246);
            iv_ruleTypeExpCS=ruleTypeExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeExpCS8256); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3459:1: ruleTypeExpCS returns [EObject current=null] : ( (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS ) ( (lv_multiplicity_2_0= ruleMultiplicityCS ) )? ) ;
    public final EObject ruleTypeExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_TypeNameExpCS_0 = null;

        EObject this_TypeLiteralCS_1 = null;

        EObject lv_multiplicity_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3462:28: ( ( (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS ) ( (lv_multiplicity_2_0= ruleMultiplicityCS ) )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3463:1: ( (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS ) ( (lv_multiplicity_2_0= ruleMultiplicityCS ) )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3463:1: ( (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS ) ( (lv_multiplicity_2_0= ruleMultiplicityCS ) )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3463:2: (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS ) ( (lv_multiplicity_2_0= ruleMultiplicityCS ) )?
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3463:2: (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( ((LA49_0>=RULE_SIMPLE_ID && LA49_0<=RULE_ESCAPED_ID)||(LA49_0>=23 && LA49_0<=24)||(LA49_0>=29 && LA49_0<=37)) ) {
                alt49=1;
            }
            else if ( ((LA49_0>=55 && LA49_0<=68)) ) {
                alt49=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }
            switch (alt49) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3464:2: this_TypeNameExpCS_0= ruleTypeNameExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeExpCSAccess().getTypeNameExpCSParserRuleCall_0_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeNameExpCS_in_ruleTypeExpCS8307);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3477:2: this_TypeLiteralCS_1= ruleTypeLiteralCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeExpCSAccess().getTypeLiteralCSParserRuleCall_0_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralCS_in_ruleTypeExpCS8337);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3488:2: ( (lv_multiplicity_2_0= ruleMultiplicityCS ) )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==70) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3489:1: (lv_multiplicity_2_0= ruleMultiplicityCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3489:1: (lv_multiplicity_2_0= ruleMultiplicityCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3490:3: lv_multiplicity_2_0= ruleMultiplicityCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeExpCSAccess().getMultiplicityMultiplicityCSParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMultiplicityCS_in_ruleTypeExpCS8358);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3514:1: entryRuleExpCS returns [EObject current=null] : iv_ruleExpCS= ruleExpCS EOF ;
    public final EObject entryRuleExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3515:2: (iv_ruleExpCS= ruleExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3516:2: iv_ruleExpCS= ruleExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_entryRuleExpCS8395);
            iv_ruleExpCS=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleExpCS8405); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3523:1: ruleExpCS returns [EObject current=null] : ( (this_PrefixedExpCS_0= rulePrefixedExpCS ( () ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? ) | ( (lv_ownedExpression_8_0= ruleLetExpCS ) ) ) )? ) | ( () ( (lv_ownedOperator_10_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_11_0= ruleLetExpCS ) ) ) | this_LetExpCS_12= ruleLetExpCS ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3526:28: ( ( (this_PrefixedExpCS_0= rulePrefixedExpCS ( () ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? ) | ( (lv_ownedExpression_8_0= ruleLetExpCS ) ) ) )? ) | ( () ( (lv_ownedOperator_10_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_11_0= ruleLetExpCS ) ) ) | this_LetExpCS_12= ruleLetExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3527:1: ( (this_PrefixedExpCS_0= rulePrefixedExpCS ( () ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? ) | ( (lv_ownedExpression_8_0= ruleLetExpCS ) ) ) )? ) | ( () ( (lv_ownedOperator_10_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_11_0= ruleLetExpCS ) ) ) | this_LetExpCS_12= ruleLetExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3527:1: ( (this_PrefixedExpCS_0= rulePrefixedExpCS ( () ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? ) | ( (lv_ownedExpression_8_0= ruleLetExpCS ) ) ) )? ) | ( () ( (lv_ownedOperator_10_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_11_0= ruleLetExpCS ) ) ) | this_LetExpCS_12= ruleLetExpCS )
            int alt56=3;
            alt56 = dfa56.predict(input);
            switch (alt56) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3527:2: (this_PrefixedExpCS_0= rulePrefixedExpCS ( () ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? ) | ( (lv_ownedExpression_8_0= ruleLetExpCS ) ) ) )? )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3527:2: (this_PrefixedExpCS_0= rulePrefixedExpCS ( () ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? ) | ( (lv_ownedExpression_8_0= ruleLetExpCS ) ) ) )? )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3528:2: this_PrefixedExpCS_0= rulePrefixedExpCS ( () ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? ) | ( (lv_ownedExpression_8_0= ruleLetExpCS ) ) ) )?
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getExpCSAccess().getPrefixedExpCSParserRuleCall_0_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrefixedExpCS_in_ruleExpCS8456);
                    this_PrefixedExpCS_0=rulePrefixedExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_PrefixedExpCS_0; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3539:1: ( () ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? ) | ( (lv_ownedExpression_8_0= ruleLetExpCS ) ) ) )?
                    int alt54=2;
                    int LA54_0 = input.LA(1);

                    if ( ((LA54_0>=38 && LA54_0<=39)||(LA54_0>=41 && LA54_0<=54)) ) {
                        alt54=1;
                    }
                    switch (alt54) {
                        case 1 :
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3539:2: () ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? ) | ( (lv_ownedExpression_8_0= ruleLetExpCS ) ) )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3539:2: ()
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3540:2: 
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

                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3548:2: ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3549:1: (lv_ownedOperator_2_0= ruleBinaryOperatorCS )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3549:1: (lv_ownedOperator_2_0= ruleBinaryOperatorCS )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3550:3: lv_ownedOperator_2_0= ruleBinaryOperatorCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getExpCSAccess().getOwnedOperatorBinaryOperatorCSParserRuleCall_0_1_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleBinaryOperatorCS_in_ruleExpCS8489);
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

                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3566:2: ( ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? ) | ( (lv_ownedExpression_8_0= ruleLetExpCS ) ) )
                            int alt53=2;
                            int LA53_0 = input.LA(1);

                            if ( ((LA53_0>=RULE_SIMPLE_ID && LA53_0<=RULE_SINGLE_QUOTED_STRING)||(LA53_0>=23 && LA53_0<=25)||(LA53_0>=29 && LA53_0<=40)||(LA53_0>=55 && LA53_0<=68)||(LA53_0>=73 && LA53_0<=76)||LA53_0==79||LA53_0==85) ) {
                                alt53=1;
                            }
                            else if ( (LA53_0==83) ) {
                                alt53=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 53, 0, input);

                                throw nvae;
                            }
                            switch (alt53) {
                                case 1 :
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3566:3: ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? )
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3566:3: ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3566:4: ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )?
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3566:4: ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3567:1: (lv_ownedExpression_3_0= rulePrefixedExpCS )
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3567:1: (lv_ownedExpression_3_0= rulePrefixedExpCS )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3568:3: lv_ownedExpression_3_0= rulePrefixedExpCS
                                    {
                                    if ( state.backtracking==0 ) {
                                       
                                      	        newCompositeNode(grammarAccess.getExpCSAccess().getOwnedExpressionPrefixedExpCSParserRuleCall_0_1_2_0_0_0()); 
                                      	    
                                    }
                                    pushFollow(FollowSets000.FOLLOW_rulePrefixedExpCS_in_ruleExpCS8512);
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

                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3584:2: ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )*
                                    loop51:
                                    do {
                                        int alt51=2;
                                        alt51 = dfa51.predict(input);
                                        switch (alt51) {
                                    	case 1 :
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3584:3: ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) )
                                    	    {
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3584:3: ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) )
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3585:1: (lv_ownedOperator_4_0= ruleBinaryOperatorCS )
                                    	    {
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3585:1: (lv_ownedOperator_4_0= ruleBinaryOperatorCS )
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3586:3: lv_ownedOperator_4_0= ruleBinaryOperatorCS
                                    	    {
                                    	    if ( state.backtracking==0 ) {
                                    	       
                                    	      	        newCompositeNode(grammarAccess.getExpCSAccess().getOwnedOperatorBinaryOperatorCSParserRuleCall_0_1_2_0_1_0_0()); 
                                    	      	    
                                    	    }
                                    	    pushFollow(FollowSets000.FOLLOW_ruleBinaryOperatorCS_in_ruleExpCS8534);
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

                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3602:2: ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) )
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3603:1: (lv_ownedExpression_5_0= rulePrefixedExpCS )
                                    	    {
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3603:1: (lv_ownedExpression_5_0= rulePrefixedExpCS )
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3604:3: lv_ownedExpression_5_0= rulePrefixedExpCS
                                    	    {
                                    	    if ( state.backtracking==0 ) {
                                    	       
                                    	      	        newCompositeNode(grammarAccess.getExpCSAccess().getOwnedExpressionPrefixedExpCSParserRuleCall_0_1_2_0_1_1_0()); 
                                    	      	    
                                    	    }
                                    	    pushFollow(FollowSets000.FOLLOW_rulePrefixedExpCS_in_ruleExpCS8555);
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
                                    	    break loop51;
                                        }
                                    } while (true);

                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3620:4: ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )?
                                    int alt52=2;
                                    int LA52_0 = input.LA(1);

                                    if ( ((LA52_0>=38 && LA52_0<=39)||(LA52_0>=41 && LA52_0<=54)) ) {
                                        alt52=1;
                                    }
                                    switch (alt52) {
                                        case 1 :
                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3620:5: ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) )
                                            {
                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3620:5: ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) )
                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3621:1: (lv_ownedOperator_6_0= ruleBinaryOperatorCS )
                                            {
                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3621:1: (lv_ownedOperator_6_0= ruleBinaryOperatorCS )
                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3622:3: lv_ownedOperator_6_0= ruleBinaryOperatorCS
                                            {
                                            if ( state.backtracking==0 ) {
                                               
                                              	        newCompositeNode(grammarAccess.getExpCSAccess().getOwnedOperatorBinaryOperatorCSParserRuleCall_0_1_2_0_2_0_0()); 
                                              	    
                                            }
                                            pushFollow(FollowSets000.FOLLOW_ruleBinaryOperatorCS_in_ruleExpCS8579);
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

                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3638:2: ( (lv_ownedExpression_7_0= ruleLetExpCS ) )
                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3639:1: (lv_ownedExpression_7_0= ruleLetExpCS )
                                            {
                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3639:1: (lv_ownedExpression_7_0= ruleLetExpCS )
                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3640:3: lv_ownedExpression_7_0= ruleLetExpCS
                                            {
                                            if ( state.backtracking==0 ) {
                                               
                                              	        newCompositeNode(grammarAccess.getExpCSAccess().getOwnedExpressionLetExpCSParserRuleCall_0_1_2_0_2_1_0()); 
                                              	    
                                            }
                                            pushFollow(FollowSets000.FOLLOW_ruleLetExpCS_in_ruleExpCS8600);
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
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3657:6: ( (lv_ownedExpression_8_0= ruleLetExpCS ) )
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3657:6: ( (lv_ownedExpression_8_0= ruleLetExpCS ) )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3658:1: (lv_ownedExpression_8_0= ruleLetExpCS )
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3658:1: (lv_ownedExpression_8_0= ruleLetExpCS )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3659:3: lv_ownedExpression_8_0= ruleLetExpCS
                                    {
                                    if ( state.backtracking==0 ) {
                                       
                                      	        newCompositeNode(grammarAccess.getExpCSAccess().getOwnedExpressionLetExpCSParserRuleCall_0_1_2_1_0()); 
                                      	    
                                    }
                                    pushFollow(FollowSets000.FOLLOW_ruleLetExpCS_in_ruleExpCS8630);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3676:6: ( () ( (lv_ownedOperator_10_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_11_0= ruleLetExpCS ) ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3676:6: ( () ( (lv_ownedOperator_10_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_11_0= ruleLetExpCS ) ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3676:7: () ( (lv_ownedOperator_10_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_11_0= ruleLetExpCS ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3676:7: ()
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3677:2: 
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

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3685:2: ( (lv_ownedOperator_10_0= ruleUnaryOperatorCS ) )+
                    int cnt55=0;
                    loop55:
                    do {
                        int alt55=2;
                        int LA55_0 = input.LA(1);

                        if ( ((LA55_0>=39 && LA55_0<=40)) ) {
                            alt55=1;
                        }


                        switch (alt55) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3686:1: (lv_ownedOperator_10_0= ruleUnaryOperatorCS )
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3686:1: (lv_ownedOperator_10_0= ruleUnaryOperatorCS )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3687:3: lv_ownedOperator_10_0= ruleUnaryOperatorCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getExpCSAccess().getOwnedOperatorUnaryOperatorCSParserRuleCall_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleUnaryOperatorCS_in_ruleExpCS8674);
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
                    	    if ( cnt55 >= 1 ) break loop55;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(55, input);
                                throw eee;
                        }
                        cnt55++;
                    } while (true);

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3703:3: ( (lv_ownedExpression_11_0= ruleLetExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3704:1: (lv_ownedExpression_11_0= ruleLetExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3704:1: (lv_ownedExpression_11_0= ruleLetExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3705:3: lv_ownedExpression_11_0= ruleLetExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpCSAccess().getOwnedExpressionLetExpCSParserRuleCall_1_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLetExpCS_in_ruleExpCS8696);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3723:2: this_LetExpCS_12= ruleLetExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getExpCSAccess().getLetExpCSParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLetExpCS_in_ruleExpCS8728);
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


    // $ANTLR start "entryRulePrefixedExpCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3742:1: entryRulePrefixedExpCS returns [EObject current=null] : iv_rulePrefixedExpCS= rulePrefixedExpCS EOF ;
    public final EObject entryRulePrefixedExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrefixedExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3743:2: (iv_rulePrefixedExpCS= rulePrefixedExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3744:2: iv_rulePrefixedExpCS= rulePrefixedExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrefixedExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePrefixedExpCS_in_entryRulePrefixedExpCS8763);
            iv_rulePrefixedExpCS=rulePrefixedExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrefixedExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrefixedExpCS8773); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3751:1: rulePrefixedExpCS returns [EObject current=null] : ( ( () ( (lv_ownedOperator_1_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_2_0= rulePrimaryExpCS ) ) ) | this_PrimaryExpCS_3= rulePrimaryExpCS ) ;
    public final EObject rulePrefixedExpCS() throws RecognitionException {
        EObject current = null;

        EObject lv_ownedOperator_1_0 = null;

        EObject lv_ownedExpression_2_0 = null;

        EObject this_PrimaryExpCS_3 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3754:28: ( ( ( () ( (lv_ownedOperator_1_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_2_0= rulePrimaryExpCS ) ) ) | this_PrimaryExpCS_3= rulePrimaryExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3755:1: ( ( () ( (lv_ownedOperator_1_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_2_0= rulePrimaryExpCS ) ) ) | this_PrimaryExpCS_3= rulePrimaryExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3755:1: ( ( () ( (lv_ownedOperator_1_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_2_0= rulePrimaryExpCS ) ) ) | this_PrimaryExpCS_3= rulePrimaryExpCS )
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( ((LA58_0>=39 && LA58_0<=40)) ) {
                alt58=1;
            }
            else if ( ((LA58_0>=RULE_SIMPLE_ID && LA58_0<=RULE_SINGLE_QUOTED_STRING)||(LA58_0>=23 && LA58_0<=25)||(LA58_0>=29 && LA58_0<=38)||(LA58_0>=55 && LA58_0<=68)||(LA58_0>=73 && LA58_0<=76)||LA58_0==79||LA58_0==85) ) {
                alt58=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;
            }
            switch (alt58) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3755:2: ( () ( (lv_ownedOperator_1_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_2_0= rulePrimaryExpCS ) ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3755:2: ( () ( (lv_ownedOperator_1_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_2_0= rulePrimaryExpCS ) ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3755:3: () ( (lv_ownedOperator_1_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_2_0= rulePrimaryExpCS ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3755:3: ()
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3756:2: 
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

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3764:2: ( (lv_ownedOperator_1_0= ruleUnaryOperatorCS ) )+
                    int cnt57=0;
                    loop57:
                    do {
                        int alt57=2;
                        int LA57_0 = input.LA(1);

                        if ( ((LA57_0>=39 && LA57_0<=40)) ) {
                            alt57=1;
                        }


                        switch (alt57) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3765:1: (lv_ownedOperator_1_0= ruleUnaryOperatorCS )
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3765:1: (lv_ownedOperator_1_0= ruleUnaryOperatorCS )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3766:3: lv_ownedOperator_1_0= ruleUnaryOperatorCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getPrefixedExpCSAccess().getOwnedOperatorUnaryOperatorCSParserRuleCall_0_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleUnaryOperatorCS_in_rulePrefixedExpCS8832);
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
                    	    if ( cnt57 >= 1 ) break loop57;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(57, input);
                                throw eee;
                        }
                        cnt57++;
                    } while (true);

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3782:3: ( (lv_ownedExpression_2_0= rulePrimaryExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3783:1: (lv_ownedExpression_2_0= rulePrimaryExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3783:1: (lv_ownedExpression_2_0= rulePrimaryExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3784:3: lv_ownedExpression_2_0= rulePrimaryExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrefixedExpCSAccess().getOwnedExpressionPrimaryExpCSParserRuleCall_0_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrimaryExpCS_in_rulePrefixedExpCS8854);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3802:2: this_PrimaryExpCS_3= rulePrimaryExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrefixedExpCSAccess().getPrimaryExpCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrimaryExpCS_in_rulePrefixedExpCS8886);
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


    // $ANTLR start "entryRulePrimaryExpCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3821:1: entryRulePrimaryExpCS returns [EObject current=null] : iv_rulePrimaryExpCS= rulePrimaryExpCS EOF ;
    public final EObject entryRulePrimaryExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3822:2: (iv_rulePrimaryExpCS= rulePrimaryExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3823:2: iv_rulePrimaryExpCS= rulePrimaryExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimaryExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePrimaryExpCS_in_entryRulePrimaryExpCS8921);
            iv_rulePrimaryExpCS=rulePrimaryExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimaryExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrimaryExpCS8931); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3830:1: rulePrimaryExpCS returns [EObject current=null] : (this_NestedExpCS_0= ruleNestedExpCS | this_IfExpCS_1= ruleIfExpCS | this_SelfExpCS_2= ruleSelfExpCS | this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS | this_CollectionLiteralExpCS_5= ruleCollectionLiteralExpCS | this_TypeLiteralExpCS_6= ruleTypeLiteralExpCS | ( () ( (lv_pathName_8_0= rulePathNameCS ) ) ( ( () otherlv_10= '[' ( (lv_firstIndexes_11_0= ruleExpCS ) ) (otherlv_12= ',' ( (lv_firstIndexes_13_0= ruleExpCS ) ) )* otherlv_14= ']' (otherlv_15= '[' ( (lv_secondIndexes_16_0= ruleExpCS ) ) (otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) ) )* otherlv_19= ']' )? ( ( (lv_atPre_20_0= '@' ) ) otherlv_21= 'pre' )? ) | ( () otherlv_23= '{' ( ( ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )* ) | ( (lv_value_27_0= ruleStringLiteral ) ) ) otherlv_28= '}' ) | ( ( ( (lv_atPre_29_0= '@' ) ) otherlv_30= 'pre' )? ( () otherlv_32= '(' ( ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_39= ')' )? ) ) ) ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3833:28: ( (this_NestedExpCS_0= ruleNestedExpCS | this_IfExpCS_1= ruleIfExpCS | this_SelfExpCS_2= ruleSelfExpCS | this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS | this_CollectionLiteralExpCS_5= ruleCollectionLiteralExpCS | this_TypeLiteralExpCS_6= ruleTypeLiteralExpCS | ( () ( (lv_pathName_8_0= rulePathNameCS ) ) ( ( () otherlv_10= '[' ( (lv_firstIndexes_11_0= ruleExpCS ) ) (otherlv_12= ',' ( (lv_firstIndexes_13_0= ruleExpCS ) ) )* otherlv_14= ']' (otherlv_15= '[' ( (lv_secondIndexes_16_0= ruleExpCS ) ) (otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) ) )* otherlv_19= ']' )? ( ( (lv_atPre_20_0= '@' ) ) otherlv_21= 'pre' )? ) | ( () otherlv_23= '{' ( ( ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )* ) | ( (lv_value_27_0= ruleStringLiteral ) ) ) otherlv_28= '}' ) | ( ( ( (lv_atPre_29_0= '@' ) ) otherlv_30= 'pre' )? ( () otherlv_32= '(' ( ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_39= ')' )? ) ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3834:1: (this_NestedExpCS_0= ruleNestedExpCS | this_IfExpCS_1= ruleIfExpCS | this_SelfExpCS_2= ruleSelfExpCS | this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS | this_CollectionLiteralExpCS_5= ruleCollectionLiteralExpCS | this_TypeLiteralExpCS_6= ruleTypeLiteralExpCS | ( () ( (lv_pathName_8_0= rulePathNameCS ) ) ( ( () otherlv_10= '[' ( (lv_firstIndexes_11_0= ruleExpCS ) ) (otherlv_12= ',' ( (lv_firstIndexes_13_0= ruleExpCS ) ) )* otherlv_14= ']' (otherlv_15= '[' ( (lv_secondIndexes_16_0= ruleExpCS ) ) (otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) ) )* otherlv_19= ']' )? ( ( (lv_atPre_20_0= '@' ) ) otherlv_21= 'pre' )? ) | ( () otherlv_23= '{' ( ( ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )* ) | ( (lv_value_27_0= ruleStringLiteral ) ) ) otherlv_28= '}' ) | ( ( ( (lv_atPre_29_0= '@' ) ) otherlv_30= 'pre' )? ( () otherlv_32= '(' ( ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_39= ')' )? ) ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3834:1: (this_NestedExpCS_0= ruleNestedExpCS | this_IfExpCS_1= ruleIfExpCS | this_SelfExpCS_2= ruleSelfExpCS | this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS | this_CollectionLiteralExpCS_5= ruleCollectionLiteralExpCS | this_TypeLiteralExpCS_6= ruleTypeLiteralExpCS | ( () ( (lv_pathName_8_0= rulePathNameCS ) ) ( ( () otherlv_10= '[' ( (lv_firstIndexes_11_0= ruleExpCS ) ) (otherlv_12= ',' ( (lv_firstIndexes_13_0= ruleExpCS ) ) )* otherlv_14= ']' (otherlv_15= '[' ( (lv_secondIndexes_16_0= ruleExpCS ) ) (otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) ) )* otherlv_19= ']' )? ( ( (lv_atPre_20_0= '@' ) ) otherlv_21= 'pre' )? ) | ( () otherlv_23= '{' ( ( ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )* ) | ( (lv_value_27_0= ruleStringLiteral ) ) ) otherlv_28= '}' ) | ( ( ( (lv_atPre_29_0= '@' ) ) otherlv_30= 'pre' )? ( () otherlv_32= '(' ( ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_39= ')' )? ) ) ) )
            int alt74=8;
            alt74 = dfa74.predict(input);
            switch (alt74) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3835:2: this_NestedExpCS_0= ruleNestedExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getNestedExpCSParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNestedExpCS_in_rulePrimaryExpCS8981);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3848:2: this_IfExpCS_1= ruleIfExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getIfExpCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleIfExpCS_in_rulePrimaryExpCS9011);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3861:2: this_SelfExpCS_2= ruleSelfExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getSelfExpCSParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSelfExpCS_in_rulePrimaryExpCS9041);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3874:2: this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getPrimitiveLiteralExpCSParserRuleCall_3()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrimitiveLiteralExpCS_in_rulePrimaryExpCS9071);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3887:2: this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getTupleLiteralExpCSParserRuleCall_4()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralExpCS_in_rulePrimaryExpCS9101);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3900:2: this_CollectionLiteralExpCS_5= ruleCollectionLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getCollectionLiteralExpCSParserRuleCall_5()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteralExpCS_in_rulePrimaryExpCS9131);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3913:2: this_TypeLiteralExpCS_6= ruleTypeLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getTypeLiteralExpCSParserRuleCall_6()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralExpCS_in_rulePrimaryExpCS9161);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3925:6: ( () ( (lv_pathName_8_0= rulePathNameCS ) ) ( ( () otherlv_10= '[' ( (lv_firstIndexes_11_0= ruleExpCS ) ) (otherlv_12= ',' ( (lv_firstIndexes_13_0= ruleExpCS ) ) )* otherlv_14= ']' (otherlv_15= '[' ( (lv_secondIndexes_16_0= ruleExpCS ) ) (otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) ) )* otherlv_19= ']' )? ( ( (lv_atPre_20_0= '@' ) ) otherlv_21= 'pre' )? ) | ( () otherlv_23= '{' ( ( ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )* ) | ( (lv_value_27_0= ruleStringLiteral ) ) ) otherlv_28= '}' ) | ( ( ( (lv_atPre_29_0= '@' ) ) otherlv_30= 'pre' )? ( () otherlv_32= '(' ( ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_39= ')' )? ) ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3925:6: ( () ( (lv_pathName_8_0= rulePathNameCS ) ) ( ( () otherlv_10= '[' ( (lv_firstIndexes_11_0= ruleExpCS ) ) (otherlv_12= ',' ( (lv_firstIndexes_13_0= ruleExpCS ) ) )* otherlv_14= ']' (otherlv_15= '[' ( (lv_secondIndexes_16_0= ruleExpCS ) ) (otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) ) )* otherlv_19= ']' )? ( ( (lv_atPre_20_0= '@' ) ) otherlv_21= 'pre' )? ) | ( () otherlv_23= '{' ( ( ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )* ) | ( (lv_value_27_0= ruleStringLiteral ) ) ) otherlv_28= '}' ) | ( ( ( (lv_atPre_29_0= '@' ) ) otherlv_30= 'pre' )? ( () otherlv_32= '(' ( ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_39= ')' )? ) ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3925:7: () ( (lv_pathName_8_0= rulePathNameCS ) ) ( ( () otherlv_10= '[' ( (lv_firstIndexes_11_0= ruleExpCS ) ) (otherlv_12= ',' ( (lv_firstIndexes_13_0= ruleExpCS ) ) )* otherlv_14= ']' (otherlv_15= '[' ( (lv_secondIndexes_16_0= ruleExpCS ) ) (otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) ) )* otherlv_19= ']' )? ( ( (lv_atPre_20_0= '@' ) ) otherlv_21= 'pre' )? ) | ( () otherlv_23= '{' ( ( ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )* ) | ( (lv_value_27_0= ruleStringLiteral ) ) ) otherlv_28= '}' ) | ( ( ( (lv_atPre_29_0= '@' ) ) otherlv_30= 'pre' )? ( () otherlv_32= '(' ( ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_39= ')' )? ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3925:7: ()
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3926:2: 
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

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3934:2: ( (lv_pathName_8_0= rulePathNameCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3935:1: (lv_pathName_8_0= rulePathNameCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3935:1: (lv_pathName_8_0= rulePathNameCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3936:3: lv_pathName_8_0= rulePathNameCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getPathNamePathNameCSParserRuleCall_7_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePathNameCS_in_rulePrimaryExpCS9200);
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

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3952:2: ( ( () otherlv_10= '[' ( (lv_firstIndexes_11_0= ruleExpCS ) ) (otherlv_12= ',' ( (lv_firstIndexes_13_0= ruleExpCS ) ) )* otherlv_14= ']' (otherlv_15= '[' ( (lv_secondIndexes_16_0= ruleExpCS ) ) (otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) ) )* otherlv_19= ']' )? ( ( (lv_atPre_20_0= '@' ) ) otherlv_21= 'pre' )? ) | ( () otherlv_23= '{' ( ( ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )* ) | ( (lv_value_27_0= ruleStringLiteral ) ) ) otherlv_28= '}' ) | ( ( ( (lv_atPre_29_0= '@' ) ) otherlv_30= 'pre' )? ( () otherlv_32= '(' ( ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_39= ')' )? ) )
                    int alt73=3;
                    switch ( input.LA(1) ) {
                    case 70:
                        {
                        alt73=1;
                        }
                        break;
                    case 16:
                        {
                        alt73=2;
                        }
                        break;
                    case EOF:
                    case 17:
                    case 18:
                    case 19:
                    case 21:
                    case 22:
                    case 25:
                    case 26:
                    case 27:
                    case 38:
                    case 39:
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
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 69:
                    case 71:
                    case 77:
                    case 80:
                    case 81:
                    case 82:
                    case 84:
                        {
                        alt73=3;
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
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3952:3: ( () otherlv_10= '[' ( (lv_firstIndexes_11_0= ruleExpCS ) ) (otherlv_12= ',' ( (lv_firstIndexes_13_0= ruleExpCS ) ) )* otherlv_14= ']' (otherlv_15= '[' ( (lv_secondIndexes_16_0= ruleExpCS ) ) (otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) ) )* otherlv_19= ']' )? ( ( (lv_atPre_20_0= '@' ) ) otherlv_21= 'pre' )? )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3952:3: ( () otherlv_10= '[' ( (lv_firstIndexes_11_0= ruleExpCS ) ) (otherlv_12= ',' ( (lv_firstIndexes_13_0= ruleExpCS ) ) )* otherlv_14= ']' (otherlv_15= '[' ( (lv_secondIndexes_16_0= ruleExpCS ) ) (otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) ) )* otherlv_19= ']' )? ( ( (lv_atPre_20_0= '@' ) ) otherlv_21= 'pre' )? )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3952:4: () otherlv_10= '[' ( (lv_firstIndexes_11_0= ruleExpCS ) ) (otherlv_12= ',' ( (lv_firstIndexes_13_0= ruleExpCS ) ) )* otherlv_14= ']' (otherlv_15= '[' ( (lv_secondIndexes_16_0= ruleExpCS ) ) (otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) ) )* otherlv_19= ']' )? ( ( (lv_atPre_20_0= '@' ) ) otherlv_21= 'pre' )?
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3952:4: ()
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3953:2: 
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

                            otherlv_10=(Token)match(input,70,FollowSets000.FOLLOW_70_in_rulePrimaryExpCS9226); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_10, grammarAccess.getPrimaryExpCSAccess().getLeftSquareBracketKeyword_7_2_0_1());
                                  
                            }
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3965:1: ( (lv_firstIndexes_11_0= ruleExpCS ) )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3966:1: (lv_firstIndexes_11_0= ruleExpCS )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3966:1: (lv_firstIndexes_11_0= ruleExpCS )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3967:3: lv_firstIndexes_11_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getFirstIndexesExpCSParserRuleCall_7_2_0_2_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_rulePrimaryExpCS9247);
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

                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3983:2: (otherlv_12= ',' ( (lv_firstIndexes_13_0= ruleExpCS ) ) )*
                            loop59:
                            do {
                                int alt59=2;
                                int LA59_0 = input.LA(1);

                                if ( (LA59_0==17) ) {
                                    alt59=1;
                                }


                                switch (alt59) {
                            	case 1 :
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3983:4: otherlv_12= ',' ( (lv_firstIndexes_13_0= ruleExpCS ) )
                            	    {
                            	    otherlv_12=(Token)match(input,17,FollowSets000.FOLLOW_17_in_rulePrimaryExpCS9260); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_12, grammarAccess.getPrimaryExpCSAccess().getCommaKeyword_7_2_0_3_0());
                            	          
                            	    }
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3987:1: ( (lv_firstIndexes_13_0= ruleExpCS ) )
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3988:1: (lv_firstIndexes_13_0= ruleExpCS )
                            	    {
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3988:1: (lv_firstIndexes_13_0= ruleExpCS )
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3989:3: lv_firstIndexes_13_0= ruleExpCS
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getFirstIndexesExpCSParserRuleCall_7_2_0_3_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_rulePrimaryExpCS9281);
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
                            	    break loop59;
                                }
                            } while (true);

                            otherlv_14=(Token)match(input,71,FollowSets000.FOLLOW_71_in_rulePrimaryExpCS9295); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_14, grammarAccess.getPrimaryExpCSAccess().getRightSquareBracketKeyword_7_2_0_4());
                                  
                            }
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4009:1: (otherlv_15= '[' ( (lv_secondIndexes_16_0= ruleExpCS ) ) (otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) ) )* otherlv_19= ']' )?
                            int alt61=2;
                            int LA61_0 = input.LA(1);

                            if ( (LA61_0==70) ) {
                                alt61=1;
                            }
                            switch (alt61) {
                                case 1 :
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4009:3: otherlv_15= '[' ( (lv_secondIndexes_16_0= ruleExpCS ) ) (otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) ) )* otherlv_19= ']'
                                    {
                                    otherlv_15=(Token)match(input,70,FollowSets000.FOLLOW_70_in_rulePrimaryExpCS9308); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                          	newLeafNode(otherlv_15, grammarAccess.getPrimaryExpCSAccess().getLeftSquareBracketKeyword_7_2_0_5_0());
                                          
                                    }
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4013:1: ( (lv_secondIndexes_16_0= ruleExpCS ) )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4014:1: (lv_secondIndexes_16_0= ruleExpCS )
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4014:1: (lv_secondIndexes_16_0= ruleExpCS )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4015:3: lv_secondIndexes_16_0= ruleExpCS
                                    {
                                    if ( state.backtracking==0 ) {
                                       
                                      	        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getSecondIndexesExpCSParserRuleCall_7_2_0_5_1_0()); 
                                      	    
                                    }
                                    pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_rulePrimaryExpCS9329);
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

                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4031:2: (otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) ) )*
                                    loop60:
                                    do {
                                        int alt60=2;
                                        int LA60_0 = input.LA(1);

                                        if ( (LA60_0==17) ) {
                                            alt60=1;
                                        }


                                        switch (alt60) {
                                    	case 1 :
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4031:4: otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) )
                                    	    {
                                    	    otherlv_17=(Token)match(input,17,FollowSets000.FOLLOW_17_in_rulePrimaryExpCS9342); if (state.failed) return current;
                                    	    if ( state.backtracking==0 ) {

                                    	          	newLeafNode(otherlv_17, grammarAccess.getPrimaryExpCSAccess().getCommaKeyword_7_2_0_5_2_0());
                                    	          
                                    	    }
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4035:1: ( (lv_secondIndexes_18_0= ruleExpCS ) )
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4036:1: (lv_secondIndexes_18_0= ruleExpCS )
                                    	    {
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4036:1: (lv_secondIndexes_18_0= ruleExpCS )
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4037:3: lv_secondIndexes_18_0= ruleExpCS
                                    	    {
                                    	    if ( state.backtracking==0 ) {
                                    	       
                                    	      	        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getSecondIndexesExpCSParserRuleCall_7_2_0_5_2_1_0()); 
                                    	      	    
                                    	    }
                                    	    pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_rulePrimaryExpCS9363);
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
                                    	    break loop60;
                                        }
                                    } while (true);

                                    otherlv_19=(Token)match(input,71,FollowSets000.FOLLOW_71_in_rulePrimaryExpCS9377); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                          	newLeafNode(otherlv_19, grammarAccess.getPrimaryExpCSAccess().getRightSquareBracketKeyword_7_2_0_5_3());
                                          
                                    }

                                    }
                                    break;

                            }

                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4057:3: ( ( (lv_atPre_20_0= '@' ) ) otherlv_21= 'pre' )?
                            int alt62=2;
                            int LA62_0 = input.LA(1);

                            if ( (LA62_0==77) ) {
                                alt62=1;
                            }
                            switch (alt62) {
                                case 1 :
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4057:4: ( (lv_atPre_20_0= '@' ) ) otherlv_21= 'pre'
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4057:4: ( (lv_atPre_20_0= '@' ) )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4058:1: (lv_atPre_20_0= '@' )
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4058:1: (lv_atPre_20_0= '@' )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4059:3: lv_atPre_20_0= '@'
                                    {
                                    lv_atPre_20_0=(Token)match(input,77,FollowSets000.FOLLOW_77_in_rulePrimaryExpCS9398); if (state.failed) return current;
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

                                    otherlv_21=(Token)match(input,78,FollowSets000.FOLLOW_78_in_rulePrimaryExpCS9423); if (state.failed) return current;
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
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4077:6: ( () otherlv_23= '{' ( ( ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )* ) | ( (lv_value_27_0= ruleStringLiteral ) ) ) otherlv_28= '}' )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4077:6: ( () otherlv_23= '{' ( ( ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )* ) | ( (lv_value_27_0= ruleStringLiteral ) ) ) otherlv_28= '}' )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4077:7: () otherlv_23= '{' ( ( ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )* ) | ( (lv_value_27_0= ruleStringLiteral ) ) ) otherlv_28= '}'
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4077:7: ()
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4078:2: 
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

                            otherlv_23=(Token)match(input,16,FollowSets000.FOLLOW_16_in_rulePrimaryExpCS9457); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_23, grammarAccess.getPrimaryExpCSAccess().getLeftCurlyBracketKeyword_7_2_1_1());
                                  
                            }
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4090:1: ( ( ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )* ) | ( (lv_value_27_0= ruleStringLiteral ) ) )
                            int alt64=2;
                            int LA64_0 = input.LA(1);

                            if ( ((LA64_0>=RULE_SIMPLE_ID && LA64_0<=RULE_ESCAPED_ID)||(LA64_0>=23 && LA64_0<=24)||(LA64_0>=29 && LA64_0<=37)) ) {
                                alt64=1;
                            }
                            else if ( (LA64_0==RULE_SINGLE_QUOTED_STRING) ) {
                                alt64=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 64, 0, input);

                                throw nvae;
                            }
                            switch (alt64) {
                                case 1 :
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4090:2: ( ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )* )
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4090:2: ( ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )* )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4090:3: ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )*
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4090:3: ( (lv_ownedParts_24_0= ruleConstructorPartCS ) )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4091:1: (lv_ownedParts_24_0= ruleConstructorPartCS )
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4091:1: (lv_ownedParts_24_0= ruleConstructorPartCS )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4092:3: lv_ownedParts_24_0= ruleConstructorPartCS
                                    {
                                    if ( state.backtracking==0 ) {
                                       
                                      	        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getOwnedPartsConstructorPartCSParserRuleCall_7_2_1_2_0_0_0()); 
                                      	    
                                    }
                                    pushFollow(FollowSets000.FOLLOW_ruleConstructorPartCS_in_rulePrimaryExpCS9480);
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

                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4108:2: (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )*
                                    loop63:
                                    do {
                                        int alt63=2;
                                        int LA63_0 = input.LA(1);

                                        if ( (LA63_0==17) ) {
                                            alt63=1;
                                        }


                                        switch (alt63) {
                                    	case 1 :
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4108:4: otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) )
                                    	    {
                                    	    otherlv_25=(Token)match(input,17,FollowSets000.FOLLOW_17_in_rulePrimaryExpCS9493); if (state.failed) return current;
                                    	    if ( state.backtracking==0 ) {

                                    	          	newLeafNode(otherlv_25, grammarAccess.getPrimaryExpCSAccess().getCommaKeyword_7_2_1_2_0_1_0());
                                    	          
                                    	    }
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4112:1: ( (lv_ownedParts_26_0= ruleConstructorPartCS ) )
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4113:1: (lv_ownedParts_26_0= ruleConstructorPartCS )
                                    	    {
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4113:1: (lv_ownedParts_26_0= ruleConstructorPartCS )
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4114:3: lv_ownedParts_26_0= ruleConstructorPartCS
                                    	    {
                                    	    if ( state.backtracking==0 ) {
                                    	       
                                    	      	        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getOwnedPartsConstructorPartCSParserRuleCall_7_2_1_2_0_1_1_0()); 
                                    	      	    
                                    	    }
                                    	    pushFollow(FollowSets000.FOLLOW_ruleConstructorPartCS_in_rulePrimaryExpCS9514);
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
                                    	    break loop63;
                                        }
                                    } while (true);


                                    }


                                    }
                                    break;
                                case 2 :
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4131:6: ( (lv_value_27_0= ruleStringLiteral ) )
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4131:6: ( (lv_value_27_0= ruleStringLiteral ) )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4132:1: (lv_value_27_0= ruleStringLiteral )
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4132:1: (lv_value_27_0= ruleStringLiteral )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4133:3: lv_value_27_0= ruleStringLiteral
                                    {
                                    if ( state.backtracking==0 ) {
                                       
                                      	        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getValueStringLiteralParserRuleCall_7_2_1_2_1_0()); 
                                      	    
                                    }
                                    pushFollow(FollowSets000.FOLLOW_ruleStringLiteral_in_rulePrimaryExpCS9544);
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

                            otherlv_28=(Token)match(input,19,FollowSets000.FOLLOW_19_in_rulePrimaryExpCS9557); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_28, grammarAccess.getPrimaryExpCSAccess().getRightCurlyBracketKeyword_7_2_1_3());
                                  
                            }

                            }


                            }
                            break;
                        case 3 :
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4154:6: ( ( ( (lv_atPre_29_0= '@' ) ) otherlv_30= 'pre' )? ( () otherlv_32= '(' ( ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_39= ')' )? )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4154:6: ( ( ( (lv_atPre_29_0= '@' ) ) otherlv_30= 'pre' )? ( () otherlv_32= '(' ( ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_39= ')' )? )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4154:7: ( ( (lv_atPre_29_0= '@' ) ) otherlv_30= 'pre' )? ( () otherlv_32= '(' ( ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_39= ')' )?
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4154:7: ( ( (lv_atPre_29_0= '@' ) ) otherlv_30= 'pre' )?
                            int alt65=2;
                            int LA65_0 = input.LA(1);

                            if ( (LA65_0==77) ) {
                                alt65=1;
                            }
                            switch (alt65) {
                                case 1 :
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4154:8: ( (lv_atPre_29_0= '@' ) ) otherlv_30= 'pre'
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4154:8: ( (lv_atPre_29_0= '@' ) )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4155:1: (lv_atPre_29_0= '@' )
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4155:1: (lv_atPre_29_0= '@' )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4156:3: lv_atPre_29_0= '@'
                                    {
                                    lv_atPre_29_0=(Token)match(input,77,FollowSets000.FOLLOW_77_in_rulePrimaryExpCS9584); if (state.failed) return current;
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

                                    otherlv_30=(Token)match(input,78,FollowSets000.FOLLOW_78_in_rulePrimaryExpCS9609); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                          	newLeafNode(otherlv_30, grammarAccess.getPrimaryExpCSAccess().getPreKeyword_7_2_2_0_1());
                                          
                                    }

                                    }
                                    break;

                            }

                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4173:3: ( () otherlv_32= '(' ( ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_39= ')' )?
                            int alt72=2;
                            int LA72_0 = input.LA(1);

                            if ( (LA72_0==25) ) {
                                alt72=1;
                            }
                            switch (alt72) {
                                case 1 :
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4173:4: () otherlv_32= '(' ( ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_39= ')'
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4173:4: ()
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4174:2: 
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

                                    otherlv_32=(Token)match(input,25,FollowSets000.FOLLOW_25_in_rulePrimaryExpCS9636); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                          	newLeafNode(otherlv_32, grammarAccess.getPrimaryExpCSAccess().getLeftParenthesisKeyword_7_2_2_1_1());
                                          
                                    }
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4186:1: ( ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )? )?
                                    int alt71=2;
                                    int LA71_0 = input.LA(1);

                                    if ( ((LA71_0>=RULE_SIMPLE_ID && LA71_0<=RULE_SINGLE_QUOTED_STRING)||(LA71_0>=23 && LA71_0<=25)||(LA71_0>=29 && LA71_0<=40)||(LA71_0>=55 && LA71_0<=68)||(LA71_0>=73 && LA71_0<=76)||LA71_0==79||LA71_0==83||LA71_0==85) ) {
                                        alt71=1;
                                    }
                                    switch (alt71) {
                                        case 1 :
                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4186:2: ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )?
                                            {
                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4186:2: ( (lv_argument_33_0= ruleNavigatingArgCS ) )
                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4187:1: (lv_argument_33_0= ruleNavigatingArgCS )
                                            {
                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4187:1: (lv_argument_33_0= ruleNavigatingArgCS )
                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4188:3: lv_argument_33_0= ruleNavigatingArgCS
                                            {
                                            if ( state.backtracking==0 ) {
                                               
                                              	        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getArgumentNavigatingArgCSParserRuleCall_7_2_2_1_2_0_0()); 
                                              	    
                                            }
                                            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgCS_in_rulePrimaryExpCS9658);
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

                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4204:2: ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )*
                                            loop66:
                                            do {
                                                int alt66=2;
                                                int LA66_0 = input.LA(1);

                                                if ( (LA66_0==17) ) {
                                                    alt66=1;
                                                }


                                                switch (alt66) {
                                            	case 1 :
                                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4205:1: (lv_argument_34_0= ruleNavigatingCommaArgCS )
                                            	    {
                                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4205:1: (lv_argument_34_0= ruleNavigatingCommaArgCS )
                                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4206:3: lv_argument_34_0= ruleNavigatingCommaArgCS
                                            	    {
                                            	    if ( state.backtracking==0 ) {
                                            	       
                                            	      	        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getArgumentNavigatingCommaArgCSParserRuleCall_7_2_2_1_2_1_0()); 
                                            	      	    
                                            	    }
                                            	    pushFollow(FollowSets000.FOLLOW_ruleNavigatingCommaArgCS_in_rulePrimaryExpCS9679);
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
                                            	    break loop66;
                                                }
                                            } while (true);

                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4222:3: ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )?
                                            int alt68=2;
                                            int LA68_0 = input.LA(1);

                                            if ( (LA68_0==22) ) {
                                                alt68=1;
                                            }
                                            switch (alt68) {
                                                case 1 :
                                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4222:4: ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )*
                                                    {
                                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4222:4: ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) )
                                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4223:1: (lv_argument_35_0= ruleNavigatingSemiArgCS )
                                                    {
                                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4223:1: (lv_argument_35_0= ruleNavigatingSemiArgCS )
                                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4224:3: lv_argument_35_0= ruleNavigatingSemiArgCS
                                                    {
                                                    if ( state.backtracking==0 ) {
                                                       
                                                      	        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getArgumentNavigatingSemiArgCSParserRuleCall_7_2_2_1_2_2_0_0()); 
                                                      	    
                                                    }
                                                    pushFollow(FollowSets000.FOLLOW_ruleNavigatingSemiArgCS_in_rulePrimaryExpCS9702);
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

                                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4240:2: ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )*
                                                    loop67:
                                                    do {
                                                        int alt67=2;
                                                        int LA67_0 = input.LA(1);

                                                        if ( (LA67_0==17) ) {
                                                            alt67=1;
                                                        }


                                                        switch (alt67) {
                                                    	case 1 :
                                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4241:1: (lv_argument_36_0= ruleNavigatingCommaArgCS )
                                                    	    {
                                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4241:1: (lv_argument_36_0= ruleNavigatingCommaArgCS )
                                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4242:3: lv_argument_36_0= ruleNavigatingCommaArgCS
                                                    	    {
                                                    	    if ( state.backtracking==0 ) {
                                                    	       
                                                    	      	        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getArgumentNavigatingCommaArgCSParserRuleCall_7_2_2_1_2_2_1_0()); 
                                                    	      	    
                                                    	    }
                                                    	    pushFollow(FollowSets000.FOLLOW_ruleNavigatingCommaArgCS_in_rulePrimaryExpCS9723);
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
                                                    	    break loop67;
                                                        }
                                                    } while (true);


                                                    }
                                                    break;

                                            }

                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4258:5: ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )?
                                            int alt70=2;
                                            int LA70_0 = input.LA(1);

                                            if ( (LA70_0==18) ) {
                                                alt70=1;
                                            }
                                            switch (alt70) {
                                                case 1 :
                                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4258:6: ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )*
                                                    {
                                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4258:6: ( (lv_argument_37_0= ruleNavigatingBarArgCS ) )
                                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4259:1: (lv_argument_37_0= ruleNavigatingBarArgCS )
                                                    {
                                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4259:1: (lv_argument_37_0= ruleNavigatingBarArgCS )
                                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4260:3: lv_argument_37_0= ruleNavigatingBarArgCS
                                                    {
                                                    if ( state.backtracking==0 ) {
                                                       
                                                      	        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getArgumentNavigatingBarArgCSParserRuleCall_7_2_2_1_2_3_0_0()); 
                                                      	    
                                                    }
                                                    pushFollow(FollowSets000.FOLLOW_ruleNavigatingBarArgCS_in_rulePrimaryExpCS9748);
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

                                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4276:2: ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )*
                                                    loop69:
                                                    do {
                                                        int alt69=2;
                                                        int LA69_0 = input.LA(1);

                                                        if ( (LA69_0==17) ) {
                                                            alt69=1;
                                                        }


                                                        switch (alt69) {
                                                    	case 1 :
                                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4277:1: (lv_argument_38_0= ruleNavigatingCommaArgCS )
                                                    	    {
                                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4277:1: (lv_argument_38_0= ruleNavigatingCommaArgCS )
                                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4278:3: lv_argument_38_0= ruleNavigatingCommaArgCS
                                                    	    {
                                                    	    if ( state.backtracking==0 ) {
                                                    	       
                                                    	      	        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getArgumentNavigatingCommaArgCSParserRuleCall_7_2_2_1_2_3_1_0()); 
                                                    	      	    
                                                    	    }
                                                    	    pushFollow(FollowSets000.FOLLOW_ruleNavigatingCommaArgCS_in_rulePrimaryExpCS9769);
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
                                                    	    break loop69;
                                                        }
                                                    } while (true);


                                                    }
                                                    break;

                                            }


                                            }
                                            break;

                                    }

                                    otherlv_39=(Token)match(input,26,FollowSets000.FOLLOW_26_in_rulePrimaryExpCS9786); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4306:1: entryRuleNavigatingArgCS returns [EObject current=null] : iv_ruleNavigatingArgCS= ruleNavigatingArgCS EOF ;
    public final EObject entryRuleNavigatingArgCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingArgCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4307:2: (iv_ruleNavigatingArgCS= ruleNavigatingArgCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4308:2: iv_ruleNavigatingArgCS= ruleNavigatingArgCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingArgCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgCS_in_entryRuleNavigatingArgCS9827);
            iv_ruleNavigatingArgCS=ruleNavigatingArgCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingArgCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigatingArgCS9837); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4315:1: ruleNavigatingArgCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleNavigatingArgExpCS ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_init_4_0= ruleExpCS ) ) )? )? ) ;
    public final EObject ruleNavigatingArgCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;

        EObject lv_init_4_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4318:28: ( ( ( (lv_name_0_0= ruleNavigatingArgExpCS ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_init_4_0= ruleExpCS ) ) )? )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4319:1: ( ( (lv_name_0_0= ruleNavigatingArgExpCS ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_init_4_0= ruleExpCS ) ) )? )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4319:1: ( ( (lv_name_0_0= ruleNavigatingArgExpCS ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_init_4_0= ruleExpCS ) ) )? )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4319:2: ( (lv_name_0_0= ruleNavigatingArgExpCS ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_init_4_0= ruleExpCS ) ) )? )?
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4319:2: ( (lv_name_0_0= ruleNavigatingArgExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4320:1: (lv_name_0_0= ruleNavigatingArgExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4320:1: (lv_name_0_0= ruleNavigatingArgExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4321:3: lv_name_0_0= ruleNavigatingArgExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getNameNavigatingArgExpCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingArgCS9883);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4337:2: (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_init_4_0= ruleExpCS ) ) )? )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==27) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4337:4: otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_init_4_0= ruleExpCS ) ) )?
                    {
                    otherlv_1=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleNavigatingArgCS9896); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getNavigatingArgCSAccess().getColonKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4341:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4342:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4342:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4343:3: lv_ownedType_2_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleNavigatingArgCS9917);
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

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4359:2: (otherlv_3= '=' ( (lv_init_4_0= ruleExpCS ) ) )?
                    int alt75=2;
                    int LA75_0 = input.LA(1);

                    if ( (LA75_0==47) ) {
                        alt75=1;
                    }
                    switch (alt75) {
                        case 1 :
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4359:4: otherlv_3= '=' ( (lv_init_4_0= ruleExpCS ) )
                            {
                            otherlv_3=(Token)match(input,47,FollowSets000.FOLLOW_47_in_ruleNavigatingArgCS9930); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_3, grammarAccess.getNavigatingArgCSAccess().getEqualsSignKeyword_1_2_0());
                                  
                            }
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4363:1: ( (lv_init_4_0= ruleExpCS ) )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4364:1: (lv_init_4_0= ruleExpCS )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4364:1: (lv_init_4_0= ruleExpCS )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4365:3: lv_init_4_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getInitExpCSParserRuleCall_1_2_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNavigatingArgCS9951);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4389:1: entryRuleNavigatingBarArgCS returns [EObject current=null] : iv_ruleNavigatingBarArgCS= ruleNavigatingBarArgCS EOF ;
    public final EObject entryRuleNavigatingBarArgCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingBarArgCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4390:2: (iv_ruleNavigatingBarArgCS= ruleNavigatingBarArgCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4391:2: iv_ruleNavigatingBarArgCS= ruleNavigatingBarArgCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingBarArgCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingBarArgCS_in_entryRuleNavigatingBarArgCS9991);
            iv_ruleNavigatingBarArgCS=ruleNavigatingBarArgCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingBarArgCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigatingBarArgCS10001); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4398:1: ruleNavigatingBarArgCS returns [EObject current=null] : ( ( (lv_prefix_0_0= '|' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )? ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4401:28: ( ( ( (lv_prefix_0_0= '|' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4402:1: ( ( (lv_prefix_0_0= '|' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4402:1: ( ( (lv_prefix_0_0= '|' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4402:2: ( (lv_prefix_0_0= '|' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )?
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4402:2: ( (lv_prefix_0_0= '|' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4403:1: (lv_prefix_0_0= '|' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4403:1: (lv_prefix_0_0= '|' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4404:3: lv_prefix_0_0= '|'
            {
            lv_prefix_0_0=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleNavigatingBarArgCS10044); if (state.failed) return current;
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4417:2: ( (lv_name_1_0= ruleNavigatingArgExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4418:1: (lv_name_1_0= ruleNavigatingArgExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4418:1: (lv_name_1_0= ruleNavigatingArgExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4419:3: lv_name_1_0= ruleNavigatingArgExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNavigatingBarArgCSAccess().getNameNavigatingArgExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingBarArgCS10078);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4435:2: (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==27) ) {
                alt78=1;
            }
            switch (alt78) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4435:4: otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )?
                    {
                    otherlv_2=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleNavigatingBarArgCS10091); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getNavigatingBarArgCSAccess().getColonKeyword_2_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4439:1: ( (lv_ownedType_3_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4440:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4440:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4441:3: lv_ownedType_3_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingBarArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleNavigatingBarArgCS10112);
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

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4457:2: (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )?
                    int alt77=2;
                    int LA77_0 = input.LA(1);

                    if ( (LA77_0==47) ) {
                        alt77=1;
                    }
                    switch (alt77) {
                        case 1 :
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4457:4: otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) )
                            {
                            otherlv_4=(Token)match(input,47,FollowSets000.FOLLOW_47_in_ruleNavigatingBarArgCS10125); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getNavigatingBarArgCSAccess().getEqualsSignKeyword_2_2_0());
                                  
                            }
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4461:1: ( (lv_init_5_0= ruleExpCS ) )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4462:1: (lv_init_5_0= ruleExpCS )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4462:1: (lv_init_5_0= ruleExpCS )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4463:3: lv_init_5_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getNavigatingBarArgCSAccess().getInitExpCSParserRuleCall_2_2_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNavigatingBarArgCS10146);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4487:1: entryRuleNavigatingCommaArgCS returns [EObject current=null] : iv_ruleNavigatingCommaArgCS= ruleNavigatingCommaArgCS EOF ;
    public final EObject entryRuleNavigatingCommaArgCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingCommaArgCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4488:2: (iv_ruleNavigatingCommaArgCS= ruleNavigatingCommaArgCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4489:2: iv_ruleNavigatingCommaArgCS= ruleNavigatingCommaArgCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingCommaArgCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingCommaArgCS_in_entryRuleNavigatingCommaArgCS10186);
            iv_ruleNavigatingCommaArgCS=ruleNavigatingCommaArgCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingCommaArgCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigatingCommaArgCS10196); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4496:1: ruleNavigatingCommaArgCS returns [EObject current=null] : ( ( (lv_prefix_0_0= ',' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )? ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4499:28: ( ( ( (lv_prefix_0_0= ',' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4500:1: ( ( (lv_prefix_0_0= ',' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4500:1: ( ( (lv_prefix_0_0= ',' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4500:2: ( (lv_prefix_0_0= ',' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )?
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4500:2: ( (lv_prefix_0_0= ',' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4501:1: (lv_prefix_0_0= ',' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4501:1: (lv_prefix_0_0= ',' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4502:3: lv_prefix_0_0= ','
            {
            lv_prefix_0_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleNavigatingCommaArgCS10239); if (state.failed) return current;
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4515:2: ( (lv_name_1_0= ruleNavigatingArgExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4516:1: (lv_name_1_0= ruleNavigatingArgExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4516:1: (lv_name_1_0= ruleNavigatingArgExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4517:3: lv_name_1_0= ruleNavigatingArgExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getNameNavigatingArgExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingCommaArgCS10273);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4533:2: (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==27) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4533:4: otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )?
                    {
                    otherlv_2=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleNavigatingCommaArgCS10286); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getNavigatingCommaArgCSAccess().getColonKeyword_2_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4537:1: ( (lv_ownedType_3_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4538:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4538:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4539:3: lv_ownedType_3_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleNavigatingCommaArgCS10307);
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

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4555:2: (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )?
                    int alt79=2;
                    int LA79_0 = input.LA(1);

                    if ( (LA79_0==47) ) {
                        alt79=1;
                    }
                    switch (alt79) {
                        case 1 :
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4555:4: otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) )
                            {
                            otherlv_4=(Token)match(input,47,FollowSets000.FOLLOW_47_in_ruleNavigatingCommaArgCS10320); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getNavigatingCommaArgCSAccess().getEqualsSignKeyword_2_2_0());
                                  
                            }
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4559:1: ( (lv_init_5_0= ruleExpCS ) )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4560:1: (lv_init_5_0= ruleExpCS )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4560:1: (lv_init_5_0= ruleExpCS )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4561:3: lv_init_5_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getInitExpCSParserRuleCall_2_2_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNavigatingCommaArgCS10341);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4585:1: entryRuleNavigatingSemiArgCS returns [EObject current=null] : iv_ruleNavigatingSemiArgCS= ruleNavigatingSemiArgCS EOF ;
    public final EObject entryRuleNavigatingSemiArgCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingSemiArgCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4586:2: (iv_ruleNavigatingSemiArgCS= ruleNavigatingSemiArgCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4587:2: iv_ruleNavigatingSemiArgCS= ruleNavigatingSemiArgCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingSemiArgCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingSemiArgCS_in_entryRuleNavigatingSemiArgCS10381);
            iv_ruleNavigatingSemiArgCS=ruleNavigatingSemiArgCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingSemiArgCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigatingSemiArgCS10391); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4594:1: ruleNavigatingSemiArgCS returns [EObject current=null] : ( ( (lv_prefix_0_0= ';' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )? ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4597:28: ( ( ( (lv_prefix_0_0= ';' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4598:1: ( ( (lv_prefix_0_0= ';' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4598:1: ( ( (lv_prefix_0_0= ';' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4598:2: ( (lv_prefix_0_0= ';' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )?
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4598:2: ( (lv_prefix_0_0= ';' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4599:1: (lv_prefix_0_0= ';' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4599:1: (lv_prefix_0_0= ';' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4600:3: lv_prefix_0_0= ';'
            {
            lv_prefix_0_0=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleNavigatingSemiArgCS10434); if (state.failed) return current;
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4613:2: ( (lv_name_1_0= ruleNavigatingArgExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4614:1: (lv_name_1_0= ruleNavigatingArgExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4614:1: (lv_name_1_0= ruleNavigatingArgExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4615:3: lv_name_1_0= ruleNavigatingArgExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNavigatingSemiArgCSAccess().getNameNavigatingArgExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingSemiArgCS10468);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4631:2: (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==27) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4631:4: otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )?
                    {
                    otherlv_2=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleNavigatingSemiArgCS10481); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getNavigatingSemiArgCSAccess().getColonKeyword_2_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4635:1: ( (lv_ownedType_3_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4636:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4636:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4637:3: lv_ownedType_3_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingSemiArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleNavigatingSemiArgCS10502);
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

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4653:2: (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )?
                    int alt81=2;
                    int LA81_0 = input.LA(1);

                    if ( (LA81_0==47) ) {
                        alt81=1;
                    }
                    switch (alt81) {
                        case 1 :
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4653:4: otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) )
                            {
                            otherlv_4=(Token)match(input,47,FollowSets000.FOLLOW_47_in_ruleNavigatingSemiArgCS10515); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getNavigatingSemiArgCSAccess().getEqualsSignKeyword_2_2_0());
                                  
                            }
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4657:1: ( (lv_init_5_0= ruleExpCS ) )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4658:1: (lv_init_5_0= ruleExpCS )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4658:1: (lv_init_5_0= ruleExpCS )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4659:3: lv_init_5_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getNavigatingSemiArgCSAccess().getInitExpCSParserRuleCall_2_2_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNavigatingSemiArgCS10536);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4683:1: entryRuleNavigatingArgExpCS returns [EObject current=null] : iv_ruleNavigatingArgExpCS= ruleNavigatingArgExpCS EOF ;
    public final EObject entryRuleNavigatingArgExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingArgExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4684:2: (iv_ruleNavigatingArgExpCS= ruleNavigatingArgExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4685:2: iv_ruleNavigatingArgExpCS= ruleNavigatingArgExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingArgExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgExpCS_in_entryRuleNavigatingArgExpCS10576);
            iv_ruleNavigatingArgExpCS=ruleNavigatingArgExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingArgExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigatingArgExpCS10586); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4692:1: ruleNavigatingArgExpCS returns [EObject current=null] : this_ExpCS_0= ruleExpCS ;
    public final EObject ruleNavigatingArgExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_ExpCS_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4695:28: (this_ExpCS_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4697:2: this_ExpCS_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getNavigatingArgExpCSAccess().getExpCSParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNavigatingArgExpCS10635);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4716:1: entryRuleIfExpCS returns [EObject current=null] : iv_ruleIfExpCS= ruleIfExpCS EOF ;
    public final EObject entryRuleIfExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4717:2: (iv_ruleIfExpCS= ruleIfExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4718:2: iv_ruleIfExpCS= ruleIfExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIfExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIfExpCS_in_entryRuleIfExpCS10669);
            iv_ruleIfExpCS=ruleIfExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIfExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIfExpCS10679); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4725:1: ruleIfExpCS returns [EObject current=null] : (otherlv_0= 'if' ( (lv_condition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_thenExpression_3_0= ruleExpCS ) ) otherlv_4= 'else' ( (lv_elseExpression_5_0= ruleExpCS ) ) otherlv_6= 'endif' ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4728:28: ( (otherlv_0= 'if' ( (lv_condition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_thenExpression_3_0= ruleExpCS ) ) otherlv_4= 'else' ( (lv_elseExpression_5_0= ruleExpCS ) ) otherlv_6= 'endif' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4729:1: (otherlv_0= 'if' ( (lv_condition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_thenExpression_3_0= ruleExpCS ) ) otherlv_4= 'else' ( (lv_elseExpression_5_0= ruleExpCS ) ) otherlv_6= 'endif' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4729:1: (otherlv_0= 'if' ( (lv_condition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_thenExpression_3_0= ruleExpCS ) ) otherlv_4= 'else' ( (lv_elseExpression_5_0= ruleExpCS ) ) otherlv_6= 'endif' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4729:3: otherlv_0= 'if' ( (lv_condition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_thenExpression_3_0= ruleExpCS ) ) otherlv_4= 'else' ( (lv_elseExpression_5_0= ruleExpCS ) ) otherlv_6= 'endif'
            {
            otherlv_0=(Token)match(input,79,FollowSets000.FOLLOW_79_in_ruleIfExpCS10716); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getIfExpCSAccess().getIfKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4733:1: ( (lv_condition_1_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4734:1: (lv_condition_1_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4734:1: (lv_condition_1_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4735:3: lv_condition_1_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIfExpCSAccess().getConditionExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleIfExpCS10737);
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

            otherlv_2=(Token)match(input,80,FollowSets000.FOLLOW_80_in_ruleIfExpCS10749); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getIfExpCSAccess().getThenKeyword_2());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4755:1: ( (lv_thenExpression_3_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4756:1: (lv_thenExpression_3_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4756:1: (lv_thenExpression_3_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4757:3: lv_thenExpression_3_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIfExpCSAccess().getThenExpressionExpCSParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleIfExpCS10770);
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

            otherlv_4=(Token)match(input,81,FollowSets000.FOLLOW_81_in_ruleIfExpCS10782); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getIfExpCSAccess().getElseKeyword_4());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4777:1: ( (lv_elseExpression_5_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4778:1: (lv_elseExpression_5_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4778:1: (lv_elseExpression_5_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4779:3: lv_elseExpression_5_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIfExpCSAccess().getElseExpressionExpCSParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleIfExpCS10803);
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

            otherlv_6=(Token)match(input,82,FollowSets000.FOLLOW_82_in_ruleIfExpCS10815); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4807:1: entryRuleLetExpCS returns [EObject current=null] : iv_ruleLetExpCS= ruleLetExpCS EOF ;
    public final EObject entryRuleLetExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLetExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4808:2: (iv_ruleLetExpCS= ruleLetExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4809:2: iv_ruleLetExpCS= ruleLetExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLetExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLetExpCS_in_entryRuleLetExpCS10851);
            iv_ruleLetExpCS=ruleLetExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLetExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLetExpCS10861); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4816:1: ruleLetExpCS returns [EObject current=null] : (otherlv_0= 'let' ( (lv_variable_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_variable_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_in_5_0= ruleExpCS ) ) ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4819:28: ( (otherlv_0= 'let' ( (lv_variable_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_variable_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_in_5_0= ruleExpCS ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4820:1: (otherlv_0= 'let' ( (lv_variable_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_variable_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_in_5_0= ruleExpCS ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4820:1: (otherlv_0= 'let' ( (lv_variable_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_variable_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_in_5_0= ruleExpCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4820:3: otherlv_0= 'let' ( (lv_variable_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_variable_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_in_5_0= ruleExpCS ) )
            {
            otherlv_0=(Token)match(input,83,FollowSets000.FOLLOW_83_in_ruleLetExpCS10898); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLetExpCSAccess().getLetKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4824:1: ( (lv_variable_1_0= ruleLetVariableCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4825:1: (lv_variable_1_0= ruleLetVariableCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4825:1: (lv_variable_1_0= ruleLetVariableCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4826:3: lv_variable_1_0= ruleLetVariableCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetExpCSAccess().getVariableLetVariableCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleLetVariableCS_in_ruleLetExpCS10919);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4842:2: (otherlv_2= ',' ( (lv_variable_3_0= ruleLetVariableCS ) ) )*
            loop83:
            do {
                int alt83=2;
                int LA83_0 = input.LA(1);

                if ( (LA83_0==17) ) {
                    alt83=1;
                }


                switch (alt83) {
            	case 1 :
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4842:4: otherlv_2= ',' ( (lv_variable_3_0= ruleLetVariableCS ) )
            	    {
            	    otherlv_2=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleLetExpCS10932); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getLetExpCSAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4846:1: ( (lv_variable_3_0= ruleLetVariableCS ) )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4847:1: (lv_variable_3_0= ruleLetVariableCS )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4847:1: (lv_variable_3_0= ruleLetVariableCS )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4848:3: lv_variable_3_0= ruleLetVariableCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLetExpCSAccess().getVariableLetVariableCSParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleLetVariableCS_in_ruleLetExpCS10953);
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
            	    break loop83;
                }
            } while (true);

            otherlv_4=(Token)match(input,84,FollowSets000.FOLLOW_84_in_ruleLetExpCS10967); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getLetExpCSAccess().getInKeyword_3());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4868:1: ( (lv_in_5_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4869:1: (lv_in_5_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4869:1: (lv_in_5_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4870:3: lv_in_5_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetExpCSAccess().getInExpCSParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleLetExpCS10988);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4894:1: entryRuleLetVariableCS returns [EObject current=null] : iv_ruleLetVariableCS= ruleLetVariableCS EOF ;
    public final EObject entryRuleLetVariableCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLetVariableCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4895:2: (iv_ruleLetVariableCS= ruleLetVariableCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4896:2: iv_ruleLetVariableCS= ruleLetVariableCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLetVariableCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLetVariableCS_in_entryRuleLetVariableCS11024);
            iv_ruleLetVariableCS=ruleLetVariableCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLetVariableCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLetVariableCS11034); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4903:1: ruleLetVariableCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) ) ) ;
    public final EObject ruleLetVariableCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;

        EObject lv_initExpression_4_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4906:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4907:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4907:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4907:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4907:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4908:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4908:1: (lv_name_0_0= ruleUnrestrictedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4909:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetVariableCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleLetVariableCS11080);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4925:2: (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==27) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4925:4: otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                    {
                    otherlv_1=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleLetVariableCS11093); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getLetVariableCSAccess().getColonKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4929:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4930:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4930:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4931:3: lv_ownedType_2_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLetVariableCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleLetVariableCS11114);
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

            otherlv_3=(Token)match(input,47,FollowSets000.FOLLOW_47_in_ruleLetVariableCS11128); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getLetVariableCSAccess().getEqualsSignKeyword_2());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4951:1: ( (lv_initExpression_4_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4952:1: (lv_initExpression_4_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4952:1: (lv_initExpression_4_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4953:3: lv_initExpression_4_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetVariableCSAccess().getInitExpressionExpCSParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleLetVariableCS11149);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4977:1: entryRuleNestedExpCS returns [EObject current=null] : iv_ruleNestedExpCS= ruleNestedExpCS EOF ;
    public final EObject entryRuleNestedExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNestedExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4978:2: (iv_ruleNestedExpCS= ruleNestedExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4979:2: iv_ruleNestedExpCS= ruleNestedExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNestedExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNestedExpCS_in_entryRuleNestedExpCS11185);
            iv_ruleNestedExpCS=ruleNestedExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNestedExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNestedExpCS11195); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4986:1: ruleNestedExpCS returns [EObject current=null] : (otherlv_0= '(' ( (lv_source_1_0= ruleExpCS ) ) otherlv_2= ')' ) ;
    public final EObject ruleNestedExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_source_1_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4989:28: ( (otherlv_0= '(' ( (lv_source_1_0= ruleExpCS ) ) otherlv_2= ')' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4990:1: (otherlv_0= '(' ( (lv_source_1_0= ruleExpCS ) ) otherlv_2= ')' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4990:1: (otherlv_0= '(' ( (lv_source_1_0= ruleExpCS ) ) otherlv_2= ')' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4990:3: otherlv_0= '(' ( (lv_source_1_0= ruleExpCS ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleNestedExpCS11232); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getNestedExpCSAccess().getLeftParenthesisKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4994:1: ( (lv_source_1_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4995:1: (lv_source_1_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4995:1: (lv_source_1_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:4996:3: lv_source_1_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNestedExpCSAccess().getSourceExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNestedExpCS11253);
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

            otherlv_2=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleNestedExpCS11265); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:5024:1: entryRuleSelfExpCS returns [EObject current=null] : iv_ruleSelfExpCS= ruleSelfExpCS EOF ;
    public final EObject entryRuleSelfExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelfExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:5025:2: (iv_ruleSelfExpCS= ruleSelfExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:5026:2: iv_ruleSelfExpCS= ruleSelfExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSelfExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSelfExpCS_in_entryRuleSelfExpCS11301);
            iv_ruleSelfExpCS=ruleSelfExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSelfExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSelfExpCS11311); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:5033:1: ruleSelfExpCS returns [EObject current=null] : ( () otherlv_1= 'self' ) ;
    public final EObject ruleSelfExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:5036:28: ( ( () otherlv_1= 'self' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:5037:1: ( () otherlv_1= 'self' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:5037:1: ( () otherlv_1= 'self' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:5037:2: () otherlv_1= 'self'
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:5037:2: ()
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:5038:2: 
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

            otherlv_1=(Token)match(input,85,FollowSets000.FOLLOW_85_in_ruleSelfExpCS11360); if (state.failed) return current;
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

    // $ANTLR start synpred103_InternalQVTcoreBase
    public final void synpred103_InternalQVTcoreBase_fragment() throws RecognitionException {   
        EObject this_TupleLiteralExpCS_4 = null;


        // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3887:2: (this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS )
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3887:2: this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralExpCS_in_synpred103_InternalQVTcoreBase9101);
        this_TupleLiteralExpCS_4=ruleTupleLiteralExpCS();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred103_InternalQVTcoreBase

    // $ANTLR start synpred104_InternalQVTcoreBase
    public final void synpred104_InternalQVTcoreBase_fragment() throws RecognitionException {   
        EObject this_CollectionLiteralExpCS_5 = null;


        // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3900:2: (this_CollectionLiteralExpCS_5= ruleCollectionLiteralExpCS )
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3900:2: this_CollectionLiteralExpCS_5= ruleCollectionLiteralExpCS
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteralExpCS_in_synpred104_InternalQVTcoreBase9131);
        this_CollectionLiteralExpCS_5=ruleCollectionLiteralExpCS();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred104_InternalQVTcoreBase

    // $ANTLR start synpred105_InternalQVTcoreBase
    public final void synpred105_InternalQVTcoreBase_fragment() throws RecognitionException {   
        EObject this_TypeLiteralExpCS_6 = null;


        // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3913:2: (this_TypeLiteralExpCS_6= ruleTypeLiteralExpCS )
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcorebase/src-gen/org/eclipse/qvtd/xtext/qvtcorebase/parser/antlr/internal/InternalQVTcoreBase.g:3913:2: this_TypeLiteralExpCS_6= ruleTypeLiteralExpCS
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralExpCS_in_synpred105_InternalQVTcoreBase9161);
        this_TypeLiteralExpCS_6=ruleTypeLiteralExpCS();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred105_InternalQVTcoreBase

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
    public final boolean synpred105_InternalQVTcoreBase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred105_InternalQVTcoreBase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred104_InternalQVTcoreBase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred104_InternalQVTcoreBase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA6 dfa6 = new DFA6(this);
    protected DFA9 dfa9 = new DFA9(this);
    protected DFA17 dfa17 = new DFA17(this);
    protected DFA56 dfa56 = new DFA56(this);
    protected DFA51 dfa51 = new DFA51(this);
    protected DFA74 dfa74 = new DFA74(this);
    static final String DFA6_eotS =
        "\21\uffff";
    static final String DFA6_eofS =
        "\21\uffff";
    static final String DFA6_minS =
        "\1\20\1\4\1\uffff\11\20\1\4\3\20\1\uffff";
    static final String DFA6_maxS =
        "\1\20\1\125\1\uffff\15\115\1\uffff";
    static final String DFA6_acceptS =
        "\2\uffff\1\2\15\uffff\1\1";
    static final String DFA6_specialS =
        "\21\uffff}>";
    static final String[] DFA6_transitionS = {
            "\1\1",
            "\1\3\1\4\2\2\13\uffff\2\2\2\uffff\1\10\1\17\1\2\3\uffff\1"+
            "\14\1\5\1\6\1\7\1\11\1\12\1\13\1\15\1\16\3\2\16\uffff\16\2\4"+
            "\uffff\4\2\2\uffff\1\2\3\uffff\1\2\1\uffff\1\2",
            "",
            "\1\2\4\uffff\2\2\2\uffff\1\2\1\uffff\1\20\1\2\11\uffff\2\2"+
            "\1\uffff\16\2\17\uffff\1\2\6\uffff\1\2",
            "\1\2\4\uffff\2\2\2\uffff\1\2\1\uffff\1\20\1\2\11\uffff\2\2"+
            "\1\uffff\16\2\17\uffff\1\2\6\uffff\1\2",
            "\1\2\4\uffff\2\2\2\uffff\1\2\1\uffff\1\20\1\2\11\uffff\2\2"+
            "\1\uffff\16\2\17\uffff\1\2\6\uffff\1\2",
            "\1\2\4\uffff\2\2\2\uffff\1\2\1\uffff\1\20\1\2\11\uffff\2\2"+
            "\1\uffff\16\2\17\uffff\1\2\6\uffff\1\2",
            "\1\2\4\uffff\2\2\2\uffff\1\2\1\uffff\1\20\1\2\11\uffff\2\2"+
            "\1\uffff\16\2\17\uffff\1\2\6\uffff\1\2",
            "\1\2\4\uffff\2\2\2\uffff\1\2\1\uffff\1\20\1\2\11\uffff\2\2"+
            "\1\uffff\16\2\17\uffff\1\2\6\uffff\1\2",
            "\1\2\4\uffff\2\2\2\uffff\1\2\1\uffff\1\20\1\2\11\uffff\2\2"+
            "\1\uffff\16\2\17\uffff\1\2\6\uffff\1\2",
            "\1\2\4\uffff\2\2\2\uffff\1\2\1\uffff\1\20\1\2\11\uffff\2\2"+
            "\1\uffff\16\2\17\uffff\1\2\6\uffff\1\2",
            "\1\2\4\uffff\2\2\2\uffff\1\2\1\uffff\1\20\1\2\11\uffff\2\2"+
            "\1\uffff\16\2\17\uffff\1\2\6\uffff\1\2",
            "\2\20\12\uffff\1\2\4\uffff\2\2\2\20\1\2\1\uffff\1\20\1\2\11"+
            "\20\2\2\1\uffff\16\2\17\uffff\1\2\6\uffff\1\2",
            "\1\2\4\uffff\2\2\2\uffff\1\2\1\uffff\1\20\1\2\11\uffff\2\2"+
            "\1\uffff\16\2\17\uffff\1\2\6\uffff\1\2",
            "\1\2\4\uffff\2\2\2\uffff\1\2\1\uffff\1\20\1\2\11\uffff\2\2"+
            "\1\uffff\16\2\17\uffff\1\2\6\uffff\1\2",
            "\1\2\4\uffff\2\2\2\uffff\1\2\1\uffff\1\20\1\2\11\uffff\2\2"+
            "\1\uffff\16\2\17\uffff\1\2\6\uffff\1\2",
            ""
    };

    static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
    static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
    static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
    static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
    static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
    static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
    static final short[][] DFA6_transition;

    static {
        int numStates = DFA6_transitionS.length;
        DFA6_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
        }
    }

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = DFA6_eot;
            this.eof = DFA6_eof;
            this.min = DFA6_min;
            this.max = DFA6_max;
            this.accept = DFA6_accept;
            this.special = DFA6_special;
            this.transition = DFA6_transition;
        }
        public String getDescription() {
            return "86:1: ( (otherlv_0= '{' ( ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_2_0= ruleRealizedVariableCS ) ) ) (otherlv_3= ',' ( ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) ) ) )* otherlv_6= '|' ( (lv_constraints_7_0= ruleAssignmentCS ) )* otherlv_8= '}' ) | ( () otherlv_10= '{' ( (lv_constraints_11_0= ruleAssignmentCS ) )* otherlv_12= '}' ) )";
        }
    }
    static final String DFA9_eotS =
        "\13\uffff";
    static final String DFA9_eofS =
        "\1\4\1\uffff\2\1\1\uffff\4\4\2\1";
    static final String DFA9_minS =
        "\1\4\1\uffff\2\4\1\uffff\6\4";
    static final String DFA9_maxS =
        "\1\45\1\uffff\2\45\1\uffff\6\45";
    static final String DFA9_acceptS =
        "\1\uffff\1\1\2\uffff\1\2\6\uffff";
    static final String DFA9_specialS =
        "\13\uffff}>";
    static final String[] DFA9_transitionS = {
            "\2\1\21\uffff\1\2\1\3\4\uffff\11\1",
            "",
            "\2\4\21\uffff\1\5\1\6\4\uffff\11\4",
            "\2\4\21\uffff\1\7\1\10\4\uffff\11\4",
            "",
            "\2\1\13\uffff\1\4\5\uffff\1\1\1\11\4\uffff\11\1",
            "\2\1\13\uffff\1\4\5\uffff\1\1\1\12\4\uffff\11\1",
            "\2\1\13\uffff\1\4\5\uffff\2\1\4\uffff\11\1",
            "\2\1\13\uffff\1\4\5\uffff\2\1\4\uffff\11\1",
            "\2\4\13\uffff\1\1\5\uffff\1\4\1\10\4\uffff\11\4",
            "\2\4\13\uffff\1\1\5\uffff\2\4\4\uffff\11\4"
    };

    static final short[] DFA9_eot = DFA.unpackEncodedString(DFA9_eotS);
    static final short[] DFA9_eof = DFA.unpackEncodedString(DFA9_eofS);
    static final char[] DFA9_min = DFA.unpackEncodedStringToUnsignedChars(DFA9_minS);
    static final char[] DFA9_max = DFA.unpackEncodedStringToUnsignedChars(DFA9_maxS);
    static final short[] DFA9_accept = DFA.unpackEncodedString(DFA9_acceptS);
    static final short[] DFA9_special = DFA.unpackEncodedString(DFA9_specialS);
    static final short[][] DFA9_transition;

    static {
        int numStates = DFA9_transitionS.length;
        DFA9_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA9_transition[i] = DFA.unpackEncodedString(DFA9_transitionS[i]);
        }
    }

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = DFA9_eot;
            this.eof = DFA9_eof;
            this.min = DFA9_min;
            this.max = DFA9_max;
            this.accept = DFA9_accept;
            this.special = DFA9_special;
            this.transition = DFA9_transition;
        }
        public String getDescription() {
            return "340:2: ( (lv_name_1_0= ruleUnrestrictedName ) )?";
        }
    }
    static final String DFA17_eotS =
        "\21\uffff";
    static final String DFA17_eofS =
        "\21\uffff";
    static final String DFA17_minS =
        "\1\31\1\4\15\20\2\uffff";
    static final String DFA17_maxS =
        "\1\31\1\125\15\115\2\uffff";
    static final String DFA17_acceptS =
        "\17\uffff\1\2\1\1";
    static final String DFA17_specialS =
        "\21\uffff}>";
    static final String[] DFA17_transitionS = {
            "\1\1",
            "\1\2\1\3\2\17\14\uffff\1\17\2\uffff\1\7\1\16\2\17\2\uffff"+
            "\1\13\1\4\1\5\1\6\1\10\1\11\1\12\1\14\1\15\3\17\16\uffff\16"+
            "\17\4\uffff\4\17\2\uffff\1\17\3\uffff\1\17\1\uffff\1\17",
            "\1\17\4\uffff\2\17\2\uffff\1\17\1\uffff\1\20\1\17\11\uffff"+
            "\2\17\1\uffff\16\17\17\uffff\1\17\6\uffff\1\17",
            "\1\17\4\uffff\2\17\2\uffff\1\17\1\uffff\1\20\1\17\11\uffff"+
            "\2\17\1\uffff\16\17\17\uffff\1\17\6\uffff\1\17",
            "\1\17\4\uffff\2\17\2\uffff\1\17\1\uffff\1\20\1\17\11\uffff"+
            "\2\17\1\uffff\16\17\17\uffff\1\17\6\uffff\1\17",
            "\1\17\4\uffff\2\17\2\uffff\1\17\1\uffff\1\20\1\17\11\uffff"+
            "\2\17\1\uffff\16\17\17\uffff\1\17\6\uffff\1\17",
            "\1\17\4\uffff\2\17\2\uffff\1\17\1\uffff\1\20\1\17\11\uffff"+
            "\2\17\1\uffff\16\17\17\uffff\1\17\6\uffff\1\17",
            "\1\17\4\uffff\2\17\2\uffff\1\17\1\uffff\1\20\1\17\11\uffff"+
            "\2\17\1\uffff\16\17\17\uffff\1\17\6\uffff\1\17",
            "\1\17\4\uffff\2\17\2\uffff\1\17\1\uffff\1\20\1\17\11\uffff"+
            "\2\17\1\uffff\16\17\17\uffff\1\17\6\uffff\1\17",
            "\1\17\4\uffff\2\17\2\uffff\1\17\1\uffff\1\20\1\17\11\uffff"+
            "\2\17\1\uffff\16\17\17\uffff\1\17\6\uffff\1\17",
            "\1\17\4\uffff\2\17\2\uffff\1\17\1\uffff\1\20\1\17\11\uffff"+
            "\2\17\1\uffff\16\17\17\uffff\1\17\6\uffff\1\17",
            "\1\17\4\uffff\2\17\2\uffff\1\17\1\uffff\1\20\1\17\11\uffff"+
            "\2\17\1\uffff\16\17\17\uffff\1\17\6\uffff\1\17",
            "\1\17\4\uffff\2\17\2\uffff\1\17\1\uffff\1\20\1\17\11\uffff"+
            "\2\17\1\uffff\16\17\17\uffff\1\17\6\uffff\1\17",
            "\1\17\4\uffff\2\17\2\uffff\1\17\1\uffff\1\20\1\17\11\uffff"+
            "\2\17\1\uffff\16\17\17\uffff\1\17\6\uffff\1\17",
            "\1\17\4\uffff\2\17\2\uffff\1\17\1\uffff\1\20\1\17\11\uffff"+
            "\2\17\1\uffff\16\17\17\uffff\1\17\6\uffff\1\17",
            "",
            ""
    };

    static final short[] DFA17_eot = DFA.unpackEncodedString(DFA17_eotS);
    static final short[] DFA17_eof = DFA.unpackEncodedString(DFA17_eofS);
    static final char[] DFA17_min = DFA.unpackEncodedStringToUnsignedChars(DFA17_minS);
    static final char[] DFA17_max = DFA.unpackEncodedStringToUnsignedChars(DFA17_maxS);
    static final short[] DFA17_accept = DFA.unpackEncodedString(DFA17_acceptS);
    static final short[] DFA17_special = DFA.unpackEncodedString(DFA17_specialS);
    static final short[][] DFA17_transition;

    static {
        int numStates = DFA17_transitionS.length;
        DFA17_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA17_transition[i] = DFA.unpackEncodedString(DFA17_transitionS[i]);
        }
    }

    class DFA17 extends DFA {

        public DFA17(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 17;
            this.eot = DFA17_eot;
            this.eof = DFA17_eof;
            this.min = DFA17_min;
            this.max = DFA17_max;
            this.accept = DFA17_accept;
            this.special = DFA17_special;
            this.transition = DFA17_transition;
        }
        public String getDescription() {
            return "467:1: ( (otherlv_0= '(' ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) (otherlv_2= ',' ( (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS ) ) )* otherlv_4= '|' ( (lv_constraints_5_0= ruleAssignmentCS ) )* otherlv_6= ')' ) | ( () otherlv_8= '(' ( (lv_constraints_9_0= ruleAssignmentCS ) )* otherlv_10= ')' ) )";
        }
    }
    static final String DFA56_eotS =
        "\6\uffff";
    static final String DFA56_eofS =
        "\6\uffff";
    static final String DFA56_minS =
        "\3\4\3\uffff";
    static final String DFA56_maxS =
        "\3\125\3\uffff";
    static final String DFA56_acceptS =
        "\3\uffff\1\1\1\3\1\2";
    static final String DFA56_specialS =
        "\6\uffff}>";
    static final String[] DFA56_transitionS = {
            "\4\3\17\uffff\3\3\3\uffff\12\3\1\1\1\2\16\uffff\16\3\4\uffff"+
            "\4\3\2\uffff\1\3\3\uffff\1\4\1\uffff\1\3",
            "\4\3\17\uffff\3\3\3\uffff\12\3\1\1\1\2\16\uffff\16\3\4\uffff"+
            "\4\3\2\uffff\1\3\3\uffff\1\5\1\uffff\1\3",
            "\4\3\17\uffff\3\3\3\uffff\12\3\1\1\1\2\16\uffff\16\3\4\uffff"+
            "\4\3\2\uffff\1\3\3\uffff\1\5\1\uffff\1\3",
            "",
            "",
            ""
    };

    static final short[] DFA56_eot = DFA.unpackEncodedString(DFA56_eotS);
    static final short[] DFA56_eof = DFA.unpackEncodedString(DFA56_eofS);
    static final char[] DFA56_min = DFA.unpackEncodedStringToUnsignedChars(DFA56_minS);
    static final char[] DFA56_max = DFA.unpackEncodedStringToUnsignedChars(DFA56_maxS);
    static final short[] DFA56_accept = DFA.unpackEncodedString(DFA56_acceptS);
    static final short[] DFA56_special = DFA.unpackEncodedString(DFA56_specialS);
    static final short[][] DFA56_transition;

    static {
        int numStates = DFA56_transitionS.length;
        DFA56_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA56_transition[i] = DFA.unpackEncodedString(DFA56_transitionS[i]);
        }
    }

    class DFA56 extends DFA {

        public DFA56(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 56;
            this.eot = DFA56_eot;
            this.eof = DFA56_eof;
            this.min = DFA56_min;
            this.max = DFA56_max;
            this.accept = DFA56_accept;
            this.special = DFA56_special;
            this.transition = DFA56_transition;
        }
        public String getDescription() {
            return "3527:1: ( (this_PrefixedExpCS_0= rulePrefixedExpCS ( () ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? ) | ( (lv_ownedExpression_8_0= ruleLetExpCS ) ) ) )? ) | ( () ( (lv_ownedOperator_10_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_11_0= ruleLetExpCS ) ) ) | this_LetExpCS_12= ruleLetExpCS )";
        }
    }
    static final String DFA51_eotS =
        "\23\uffff";
    static final String DFA51_eofS =
        "\1\21\22\uffff";
    static final String DFA51_minS =
        "\1\21\20\4\2\uffff";
    static final String DFA51_maxS =
        "\1\124\20\125\2\uffff";
    static final String DFA51_acceptS =
        "\21\uffff\1\2\1\1";
    static final String DFA51_specialS =
        "\23\uffff}>";
    static final String[] DFA51_transitionS = {
            "\3\21\1\uffff\2\21\3\uffff\2\21\12\uffff\1\1\1\4\1\uffff\1"+
            "\2\1\3\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1"+
            "\20\16\uffff\1\21\1\uffff\1\21\10\uffff\3\21\1\uffff\1\21",
            "\4\22\17\uffff\3\22\3\uffff\14\22\16\uffff\16\22\4\uffff\4"+
            "\22\2\uffff\1\22\3\uffff\1\21\1\uffff\1\22",
            "\4\22\17\uffff\3\22\3\uffff\14\22\16\uffff\16\22\4\uffff\4"+
            "\22\2\uffff\1\22\3\uffff\1\21\1\uffff\1\22",
            "\4\22\17\uffff\3\22\3\uffff\14\22\16\uffff\16\22\4\uffff\4"+
            "\22\2\uffff\1\22\3\uffff\1\21\1\uffff\1\22",
            "\4\22\17\uffff\3\22\3\uffff\14\22\16\uffff\16\22\4\uffff\4"+
            "\22\2\uffff\1\22\3\uffff\1\21\1\uffff\1\22",
            "\4\22\17\uffff\3\22\3\uffff\14\22\16\uffff\16\22\4\uffff\4"+
            "\22\2\uffff\1\22\3\uffff\1\21\1\uffff\1\22",
            "\4\22\17\uffff\3\22\3\uffff\14\22\16\uffff\16\22\4\uffff\4"+
            "\22\2\uffff\1\22\3\uffff\1\21\1\uffff\1\22",
            "\4\22\17\uffff\3\22\3\uffff\14\22\16\uffff\16\22\4\uffff\4"+
            "\22\2\uffff\1\22\3\uffff\1\21\1\uffff\1\22",
            "\4\22\17\uffff\3\22\3\uffff\14\22\16\uffff\16\22\4\uffff\4"+
            "\22\2\uffff\1\22\3\uffff\1\21\1\uffff\1\22",
            "\4\22\17\uffff\3\22\3\uffff\14\22\16\uffff\16\22\4\uffff\4"+
            "\22\2\uffff\1\22\3\uffff\1\21\1\uffff\1\22",
            "\4\22\17\uffff\3\22\3\uffff\14\22\16\uffff\16\22\4\uffff\4"+
            "\22\2\uffff\1\22\3\uffff\1\21\1\uffff\1\22",
            "\4\22\17\uffff\3\22\3\uffff\14\22\16\uffff\16\22\4\uffff\4"+
            "\22\2\uffff\1\22\3\uffff\1\21\1\uffff\1\22",
            "\4\22\17\uffff\3\22\3\uffff\14\22\16\uffff\16\22\4\uffff\4"+
            "\22\2\uffff\1\22\3\uffff\1\21\1\uffff\1\22",
            "\4\22\17\uffff\3\22\3\uffff\14\22\16\uffff\16\22\4\uffff\4"+
            "\22\2\uffff\1\22\3\uffff\1\21\1\uffff\1\22",
            "\4\22\17\uffff\3\22\3\uffff\14\22\16\uffff\16\22\4\uffff\4"+
            "\22\2\uffff\1\22\3\uffff\1\21\1\uffff\1\22",
            "\4\22\17\uffff\3\22\3\uffff\14\22\16\uffff\16\22\4\uffff\4"+
            "\22\2\uffff\1\22\3\uffff\1\21\1\uffff\1\22",
            "\4\22\17\uffff\3\22\3\uffff\14\22\16\uffff\16\22\4\uffff\4"+
            "\22\2\uffff\1\22\3\uffff\1\21\1\uffff\1\22",
            "",
            ""
    };

    static final short[] DFA51_eot = DFA.unpackEncodedString(DFA51_eotS);
    static final short[] DFA51_eof = DFA.unpackEncodedString(DFA51_eofS);
    static final char[] DFA51_min = DFA.unpackEncodedStringToUnsignedChars(DFA51_minS);
    static final char[] DFA51_max = DFA.unpackEncodedStringToUnsignedChars(DFA51_maxS);
    static final short[] DFA51_accept = DFA.unpackEncodedString(DFA51_acceptS);
    static final short[] DFA51_special = DFA.unpackEncodedString(DFA51_specialS);
    static final short[][] DFA51_transition;

    static {
        int numStates = DFA51_transitionS.length;
        DFA51_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA51_transition[i] = DFA.unpackEncodedString(DFA51_transitionS[i]);
        }
    }

    class DFA51 extends DFA {

        public DFA51(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 51;
            this.eot = DFA51_eot;
            this.eof = DFA51_eof;
            this.min = DFA51_min;
            this.max = DFA51_max;
            this.accept = DFA51_accept;
            this.special = DFA51_special;
            this.transition = DFA51_transition;
        }
        public String getDescription() {
            return "()* loopback of 3584:2: ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )*";
        }
    }
    static final String DFA74_eotS =
        "\50\uffff";
    static final String DFA74_eofS =
        "\50\uffff";
    static final String DFA74_minS =
        "\1\4\12\uffff\6\0\27\uffff";
    static final String DFA74_maxS =
        "\1\125\12\uffff\6\0\27\uffff";
    static final String DFA74_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\14\uffff\1\7\7\uffff\1\10\14\uffff\1\5"+
        "\1\6";
    static final String DFA74_specialS =
        "\13\uffff\1\0\1\1\1\2\1\3\1\4\1\5\27\uffff}>";
    static final String[] DFA74_transitionS = {
            "\2\31\2\4\17\uffff\2\31\1\1\3\uffff\11\31\1\4\20\uffff\1\13"+
            "\10\21\1\14\1\15\1\16\1\17\1\20\4\uffff\4\4\2\uffff\1\2\5\uffff"+
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

    static final short[] DFA74_eot = DFA.unpackEncodedString(DFA74_eotS);
    static final short[] DFA74_eof = DFA.unpackEncodedString(DFA74_eofS);
    static final char[] DFA74_min = DFA.unpackEncodedStringToUnsignedChars(DFA74_minS);
    static final char[] DFA74_max = DFA.unpackEncodedStringToUnsignedChars(DFA74_maxS);
    static final short[] DFA74_accept = DFA.unpackEncodedString(DFA74_acceptS);
    static final short[] DFA74_special = DFA.unpackEncodedString(DFA74_specialS);
    static final short[][] DFA74_transition;

    static {
        int numStates = DFA74_transitionS.length;
        DFA74_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA74_transition[i] = DFA.unpackEncodedString(DFA74_transitionS[i]);
        }
    }

    class DFA74 extends DFA {

        public DFA74(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 74;
            this.eot = DFA74_eot;
            this.eof = DFA74_eof;
            this.min = DFA74_min;
            this.max = DFA74_max;
            this.accept = DFA74_accept;
            this.special = DFA74_special;
            this.transition = DFA74_transition;
        }
        public String getDescription() {
            return "3834:1: (this_NestedExpCS_0= ruleNestedExpCS | this_IfExpCS_1= ruleIfExpCS | this_SelfExpCS_2= ruleSelfExpCS | this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS | this_CollectionLiteralExpCS_5= ruleCollectionLiteralExpCS | this_TypeLiteralExpCS_6= ruleTypeLiteralExpCS | ( () ( (lv_pathName_8_0= rulePathNameCS ) ) ( ( () otherlv_10= '[' ( (lv_firstIndexes_11_0= ruleExpCS ) ) (otherlv_12= ',' ( (lv_firstIndexes_13_0= ruleExpCS ) ) )* otherlv_14= ']' (otherlv_15= '[' ( (lv_secondIndexes_16_0= ruleExpCS ) ) (otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) ) )* otherlv_19= ']' )? ( ( (lv_atPre_20_0= '@' ) ) otherlv_21= 'pre' )? ) | ( () otherlv_23= '{' ( ( ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )* ) | ( (lv_value_27_0= ruleStringLiteral ) ) ) otherlv_28= '}' ) | ( ( ( (lv_atPre_29_0= '@' ) ) otherlv_30= 'pre' )? ( () otherlv_32= '(' ( ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_39= ')' )? ) ) ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA74_11 = input.LA(1);

                         
                        int index74_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred103_InternalQVTcoreBase()) ) {s = 38;}

                        else if ( (synpred105_InternalQVTcoreBase()) ) {s = 17;}

                         
                        input.seek(index74_11);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA74_12 = input.LA(1);

                         
                        int index74_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred104_InternalQVTcoreBase()) ) {s = 39;}

                        else if ( (synpred105_InternalQVTcoreBase()) ) {s = 17;}

                         
                        input.seek(index74_12);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA74_13 = input.LA(1);

                         
                        int index74_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred104_InternalQVTcoreBase()) ) {s = 39;}

                        else if ( (synpred105_InternalQVTcoreBase()) ) {s = 17;}

                         
                        input.seek(index74_13);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA74_14 = input.LA(1);

                         
                        int index74_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred104_InternalQVTcoreBase()) ) {s = 39;}

                        else if ( (synpred105_InternalQVTcoreBase()) ) {s = 17;}

                         
                        input.seek(index74_14);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA74_15 = input.LA(1);

                         
                        int index74_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred104_InternalQVTcoreBase()) ) {s = 39;}

                        else if ( (synpred105_InternalQVTcoreBase()) ) {s = 17;}

                         
                        input.seek(index74_15);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA74_16 = input.LA(1);

                         
                        int index74_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred104_InternalQVTcoreBase()) ) {s = 39;}

                        else if ( (synpred105_InternalQVTcoreBase()) ) {s = 17;}

                         
                        input.seek(index74_16);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 74, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleBottomPatternCS_in_entryRuleBottomPatternCS81 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBottomPatternCS91 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleBottomPatternCS129 = new BitSet(new long[]{0x0000003FE1800030L});
        public static final BitSet FOLLOW_ruleUnrealizedVariableCS_in_ruleBottomPatternCS151 = new BitSet(new long[]{0x0000000000060000L});
        public static final BitSet FOLLOW_ruleRealizedVariableCS_in_ruleBottomPatternCS178 = new BitSet(new long[]{0x0000000000060000L});
        public static final BitSet FOLLOW_17_in_ruleBottomPatternCS192 = new BitSet(new long[]{0x0000003FE1800030L});
        public static final BitSet FOLLOW_ruleUnrealizedVariableCS_in_ruleBottomPatternCS214 = new BitSet(new long[]{0x0000000000060000L});
        public static final BitSet FOLLOW_ruleRealizedVariableCS_in_ruleBottomPatternCS241 = new BitSet(new long[]{0x0000000000060000L});
        public static final BitSet FOLLOW_18_in_ruleBottomPatternCS256 = new BitSet(new long[]{0xFF8001FFE39800F0L,0x0000000000289E1FL});
        public static final BitSet FOLLOW_ruleAssignmentCS_in_ruleBottomPatternCS277 = new BitSet(new long[]{0xFF8001FFE39800F0L,0x0000000000289E1FL});
        public static final BitSet FOLLOW_19_in_ruleBottomPatternCS290 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleBottomPatternCS322 = new BitSet(new long[]{0xFF8001FFE39800F0L,0x0000000000289E1FL});
        public static final BitSet FOLLOW_ruleAssignmentCS_in_ruleBottomPatternCS343 = new BitSet(new long[]{0xFF8001FFE39800F0L,0x0000000000289E1FL});
        public static final BitSet FOLLOW_19_in_ruleBottomPatternCS356 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignmentCS_in_entryRuleAssignmentCS393 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAssignmentCS403 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleAssignmentCS446 = new BitSet(new long[]{0xFF8001FFE39000F0L,0x0000000000289E1FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleAssignmentCS481 = new BitSet(new long[]{0x0000000000600000L});
        public static final BitSet FOLLOW_21_in_ruleAssignmentCS494 = new BitSet(new long[]{0xFF8001FFE39000F0L,0x0000000000289E1FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleAssignmentCS515 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_22_in_ruleAssignmentCS529 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDirectionCS_in_entryRuleDirectionCS565 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDirectionCS575 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleDirectionCS633 = new BitSet(new long[]{0x0000000001800002L});
        public static final BitSet FOLLOW_23_in_ruleDirectionCS647 = new BitSet(new long[]{0x0000003FE1800030L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleDirectionCS674 = new BitSet(new long[]{0x0000000001020002L});
        public static final BitSet FOLLOW_17_in_ruleDirectionCS687 = new BitSet(new long[]{0x0000003FE1800030L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleDirectionCS714 = new BitSet(new long[]{0x0000000001020002L});
        public static final BitSet FOLLOW_24_in_ruleDirectionCS731 = new BitSet(new long[]{0x0000003FE1800030L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleDirectionCS758 = new BitSet(new long[]{0x0000000000020002L});
        public static final BitSet FOLLOW_17_in_ruleDirectionCS771 = new BitSet(new long[]{0x0000003FE1800030L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleDirectionCS798 = new BitSet(new long[]{0x0000000000020002L});
        public static final BitSet FOLLOW_ruleGuardPatternCS_in_entryRuleGuardPatternCS838 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleGuardPatternCS848 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_ruleGuardPatternCS886 = new BitSet(new long[]{0x0000003FE1800030L});
        public static final BitSet FOLLOW_ruleUnrealizedVariableCS_in_ruleGuardPatternCS907 = new BitSet(new long[]{0x0000000000060000L});
        public static final BitSet FOLLOW_17_in_ruleGuardPatternCS920 = new BitSet(new long[]{0x0000003FE1800030L});
        public static final BitSet FOLLOW_ruleUnrealizedVariableCS_in_ruleGuardPatternCS941 = new BitSet(new long[]{0x0000000000060000L});
        public static final BitSet FOLLOW_18_in_ruleGuardPatternCS955 = new BitSet(new long[]{0xFF8001FFE79000F0L,0x0000000000289E1FL});
        public static final BitSet FOLLOW_ruleAssignmentCS_in_ruleGuardPatternCS976 = new BitSet(new long[]{0xFF8001FFE79000F0L,0x0000000000289E1FL});
        public static final BitSet FOLLOW_26_in_ruleGuardPatternCS989 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_ruleGuardPatternCS1021 = new BitSet(new long[]{0xFF8001FFE79000F0L,0x0000000000289E1FL});
        public static final BitSet FOLLOW_ruleAssignmentCS_in_ruleGuardPatternCS1042 = new BitSet(new long[]{0xFF8001FFE79000F0L,0x0000000000289E1FL});
        public static final BitSet FOLLOW_26_in_ruleGuardPatternCS1055 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParamDeclarationCS_in_entryRuleParamDeclarationCS1098 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParamDeclarationCS1108 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleParamDeclarationCS1154 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_27_in_ruleParamDeclarationCS1166 = new BitSet(new long[]{0xFF8001FFE38000F0L,0x0000000000209E1FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleParamDeclarationCS1187 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScopeNameCS_in_entryRuleScopeNameCS1225 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleScopeNameCS1235 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFirstPathElementCS_in_ruleScopeNameCS1281 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_28_in_ruleScopeNameCS1293 = new BitSet(new long[]{0xFF80003FE1800032L,0x000000000000001FL});
        public static final BitSet FOLLOW_ruleNextPathElementCS_in_ruleScopeNameCS1315 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_28_in_ruleScopeNameCS1327 = new BitSet(new long[]{0xFF80003FE1800032L,0x000000000000001FL});
        public static final BitSet FOLLOW_ruleUnrealizedVariableCS_in_entryRuleUnrealizedVariableCS1367 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnrealizedVariableCS1377 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleUnrealizedVariableCS1423 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_27_in_ruleUnrealizedVariableCS1435 = new BitSet(new long[]{0xFF8001FFE38000F0L,0x0000000000209E1FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleUnrealizedVariableCS1456 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRealizedVariableCS_in_entryRuleRealizedVariableCS1492 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRealizedVariableCS1502 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_ruleRealizedVariableCS1539 = new BitSet(new long[]{0x0000003FE1800030L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleRealizedVariableCS1560 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_27_in_ruleRealizedVariableCS1572 = new BitSet(new long[]{0xFF8001FFE38000F0L,0x0000000000209E1FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleRealizedVariableCS1593 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_entryRuleUnrestrictedName1632 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnrestrictedName1643 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLUnrestrictedName_in_ruleUnrestrictedName1690 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_ruleUnrestrictedName1714 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_ruleUnrestrictedName1733 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_ruleUnrestrictedName1752 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_ruleUnrestrictedName1771 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_ruleUnrestrictedName1790 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_ruleUnrestrictedName1809 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_ruleUnrestrictedName1828 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_ruleUnrestrictedName1847 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_ruleUnrestrictedName1866 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_ruleUnrestrictedName1885 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_ruleUnrestrictedName1904 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleID_in_entryRuleID1947 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleID1958 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_SIMPLE_ID_in_ruleID1998 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ESCAPED_ID_in_ruleID2024 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLOWER_in_entryRuleLOWER2070 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLOWER2081 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleLOWER2120 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUPPER_in_entryRuleUPPER2165 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUPPER2176 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleUPPER2216 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_ruleUPPER2240 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNUMBER_LITERAL_in_entryRuleNUMBER_LITERAL2281 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNUMBER_LITERAL2292 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleNUMBER_LITERAL2331 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleURI_in_entryRuleURI2376 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleURI2387 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_SINGLE_QUOTED_STRING_in_ruleURI2426 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLUnaryOperatorCS_in_entryRuleEssentialOCLUnaryOperatorCS2472 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEssentialOCLUnaryOperatorCS2482 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_39_in_ruleEssentialOCLUnaryOperatorCS2526 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_40_in_ruleEssentialOCLUnaryOperatorCS2555 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLInfixOperatorCS_in_entryRuleEssentialOCLInfixOperatorCS2606 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEssentialOCLInfixOperatorCS2616 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_ruleEssentialOCLInfixOperatorCS2660 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_41_in_ruleEssentialOCLInfixOperatorCS2689 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_42_in_ruleEssentialOCLInfixOperatorCS2718 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_39_in_ruleEssentialOCLInfixOperatorCS2747 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_43_in_ruleEssentialOCLInfixOperatorCS2776 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_44_in_ruleEssentialOCLInfixOperatorCS2805 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_45_in_ruleEssentialOCLInfixOperatorCS2834 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_46_in_ruleEssentialOCLInfixOperatorCS2863 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_47_in_ruleEssentialOCLInfixOperatorCS2892 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_48_in_ruleEssentialOCLInfixOperatorCS2921 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_49_in_ruleEssentialOCLInfixOperatorCS2950 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_50_in_ruleEssentialOCLInfixOperatorCS2979 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_51_in_ruleEssentialOCLInfixOperatorCS3008 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_52_in_ruleEssentialOCLInfixOperatorCS3037 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLNavigationOperatorCS_in_entryRuleEssentialOCLNavigationOperatorCS3088 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEssentialOCLNavigationOperatorCS3098 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_53_in_ruleEssentialOCLNavigationOperatorCS3142 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_54_in_ruleEssentialOCLNavigationOperatorCS3171 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_entryRuleIdentifier3223 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIdentifier3234 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleID_in_ruleIdentifier3280 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral3325 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteral3336 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_SINGLE_QUOTED_STRING_in_ruleStringLiteral3375 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBinaryOperatorCS_in_entryRuleBinaryOperatorCS3419 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBinaryOperatorCS3429 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInfixOperatorCS_in_ruleBinaryOperatorCS3479 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigationOperatorCS_in_ruleBinaryOperatorCS3509 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInfixOperatorCS_in_entryRuleInfixOperatorCS3544 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleInfixOperatorCS3554 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLInfixOperatorCS_in_ruleInfixOperatorCS3603 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigationOperatorCS_in_entryRuleNavigationOperatorCS3637 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigationOperatorCS3647 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLNavigationOperatorCS_in_ruleNavigationOperatorCS3696 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnaryOperatorCS_in_entryRuleUnaryOperatorCS3730 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnaryOperatorCS3740 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLUnaryOperatorCS_in_ruleUnaryOperatorCS3789 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLUnrestrictedName_in_entryRuleEssentialOCLUnrestrictedName3824 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEssentialOCLUnrestrictedName3835 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_ruleEssentialOCLUnrestrictedName3881 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLUnreservedName_in_entryRuleEssentialOCLUnreservedName3926 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEssentialOCLUnreservedName3937 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleEssentialOCLUnreservedName3984 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionTypeIdentifier_in_ruleEssentialOCLUnreservedName4017 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveTypeIdentifier_in_ruleEssentialOCLUnreservedName4050 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_55_in_ruleEssentialOCLUnreservedName4074 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnreservedName_in_entryRuleUnreservedName4115 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnreservedName4126 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLUnreservedName_in_ruleUnreservedName4172 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePathNameCS_in_entryRulePathNameCS4216 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePathNameCS4226 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFirstPathElementCS_in_rulePathNameCS4272 = new BitSet(new long[]{0x0000000010000002L});
        public static final BitSet FOLLOW_28_in_rulePathNameCS4285 = new BitSet(new long[]{0xFF80003FE1800030L,0x000000000000001FL});
        public static final BitSet FOLLOW_ruleNextPathElementCS_in_rulePathNameCS4306 = new BitSet(new long[]{0x0000000010000002L});
        public static final BitSet FOLLOW_ruleFirstPathElementCS_in_entryRuleFirstPathElementCS4344 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFirstPathElementCS4354 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleFirstPathElementCS4405 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNextPathElementCS_in_entryRuleNextPathElementCS4440 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNextPathElementCS4450 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnreservedName_in_ruleNextPathElementCS4501 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleURIPathNameCS_in_entryRuleURIPathNameCS4536 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleURIPathNameCS4546 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleURIFirstPathElementCS_in_ruleURIPathNameCS4592 = new BitSet(new long[]{0x0000000010000002L});
        public static final BitSet FOLLOW_28_in_ruleURIPathNameCS4605 = new BitSet(new long[]{0xFF80003FE1800030L,0x000000000000001FL});
        public static final BitSet FOLLOW_ruleNextPathElementCS_in_ruleURIPathNameCS4626 = new BitSet(new long[]{0x0000000010000002L});
        public static final BitSet FOLLOW_ruleURIFirstPathElementCS_in_entryRuleURIFirstPathElementCS4664 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleURIFirstPathElementCS4674 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleURIFirstPathElementCS4726 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleURI_in_ruleURIFirstPathElementCS4772 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveTypeIdentifier_in_entryRulePrimitiveTypeIdentifier4810 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrimitiveTypeIdentifier4821 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_56_in_rulePrimitiveTypeIdentifier4859 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_57_in_rulePrimitiveTypeIdentifier4878 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_58_in_rulePrimitiveTypeIdentifier4897 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_59_in_rulePrimitiveTypeIdentifier4916 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_60_in_rulePrimitiveTypeIdentifier4935 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_61_in_rulePrimitiveTypeIdentifier4954 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_62_in_rulePrimitiveTypeIdentifier4973 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_63_in_rulePrimitiveTypeIdentifier4992 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveTypeCS_in_entryRulePrimitiveTypeCS5032 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrimitiveTypeCS5042 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveTypeIdentifier_in_rulePrimitiveTypeCS5087 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionTypeIdentifier_in_entryRuleCollectionTypeIdentifier5123 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCollectionTypeIdentifier5134 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_64_in_ruleCollectionTypeIdentifier5172 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_65_in_ruleCollectionTypeIdentifier5191 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_66_in_ruleCollectionTypeIdentifier5210 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_67_in_ruleCollectionTypeIdentifier5229 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_68_in_ruleCollectionTypeIdentifier5248 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionTypeCS_in_entryRuleCollectionTypeCS5288 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCollectionTypeCS5298 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionTypeIdentifier_in_ruleCollectionTypeCS5344 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_25_in_ruleCollectionTypeCS5357 = new BitSet(new long[]{0xFF8001FFE38000F0L,0x0000000000209E1FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleCollectionTypeCS5378 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_ruleCollectionTypeCS5390 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiplicityBoundsCS_in_entryRuleMultiplicityBoundsCS5428 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicityBoundsCS5438 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLOWER_in_ruleMultiplicityBoundsCS5484 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000020L});
        public static final BitSet FOLLOW_69_in_ruleMultiplicityBoundsCS5497 = new BitSet(new long[]{0x0000004000000040L});
        public static final BitSet FOLLOW_ruleUPPER_in_ruleMultiplicityBoundsCS5518 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiplicityCS_in_entryRuleMultiplicityCS5556 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicityCS5566 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_70_in_ruleMultiplicityCS5603 = new BitSet(new long[]{0x0000044000000040L,0x0000000000000100L});
        public static final BitSet FOLLOW_ruleMultiplicityBoundsCS_in_ruleMultiplicityCS5629 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
        public static final BitSet FOLLOW_ruleMultiplicityStringCS_in_ruleMultiplicityCS5659 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
        public static final BitSet FOLLOW_71_in_ruleMultiplicityCS5671 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiplicityStringCS_in_entryRuleMultiplicityStringCS5707 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicityStringCS5717 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_ruleMultiplicityStringCS5761 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_42_in_ruleMultiplicityStringCS5790 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_72_in_ruleMultiplicityStringCS5819 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTupleTypeCS_in_entryRuleTupleTypeCS5870 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTupleTypeCS5880 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_55_in_ruleTupleTypeCS5923 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_25_in_ruleTupleTypeCS5949 = new BitSet(new long[]{0x0000003FE5800030L});
        public static final BitSet FOLLOW_ruleTuplePartCS_in_ruleTupleTypeCS5971 = new BitSet(new long[]{0x0000000004020000L});
        public static final BitSet FOLLOW_17_in_ruleTupleTypeCS5984 = new BitSet(new long[]{0x0000003FE1800030L});
        public static final BitSet FOLLOW_ruleTuplePartCS_in_ruleTupleTypeCS6005 = new BitSet(new long[]{0x0000000004020000L});
        public static final BitSet FOLLOW_26_in_ruleTupleTypeCS6021 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTuplePartCS_in_entryRuleTuplePartCS6059 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTuplePartCS6069 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleTuplePartCS6115 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_27_in_ruleTuplePartCS6127 = new BitSet(new long[]{0xFF8001FFE38000F0L,0x0000000000209E1FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleTuplePartCS6148 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionLiteralExpCS_in_entryRuleCollectionLiteralExpCS6184 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCollectionLiteralExpCS6194 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionTypeCS_in_ruleCollectionLiteralExpCS6240 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleCollectionLiteralExpCS6252 = new BitSet(new long[]{0xFF8001FFE39800F0L,0x0000000000289E1FL});
        public static final BitSet FOLLOW_ruleCollectionLiteralPartCS_in_ruleCollectionLiteralExpCS6274 = new BitSet(new long[]{0x00000000000A0000L});
        public static final BitSet FOLLOW_17_in_ruleCollectionLiteralExpCS6287 = new BitSet(new long[]{0xFF8001FFE39000F0L,0x0000000000289E1FL});
        public static final BitSet FOLLOW_ruleCollectionLiteralPartCS_in_ruleCollectionLiteralExpCS6308 = new BitSet(new long[]{0x00000000000A0000L});
        public static final BitSet FOLLOW_19_in_ruleCollectionLiteralExpCS6324 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionLiteralPartCS_in_entryRuleCollectionLiteralPartCS6360 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCollectionLiteralPartCS6370 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleCollectionLiteralPartCS6416 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000020L});
        public static final BitSet FOLLOW_69_in_ruleCollectionLiteralPartCS6429 = new BitSet(new long[]{0xFF8001FFE39000F0L,0x0000000000289E1FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleCollectionLiteralPartCS6450 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConstructorPartCS_in_entryRuleConstructorPartCS6488 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleConstructorPartCS6498 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleConstructorPartCS6550 = new BitSet(new long[]{0x0000800000000000L});
        public static final BitSet FOLLOW_47_in_ruleConstructorPartCS6562 = new BitSet(new long[]{0xFF8001FFE39000F0L,0x0000000000289E1FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleConstructorPartCS6583 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveLiteralExpCS_in_entryRulePrimitiveLiteralExpCS6619 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrimitiveLiteralExpCS6629 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNumberLiteralExpCS_in_rulePrimitiveLiteralExpCS6679 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringLiteralExpCS_in_rulePrimitiveLiteralExpCS6709 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBooleanLiteralExpCS_in_rulePrimitiveLiteralExpCS6739 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnlimitedNaturalLiteralExpCS_in_rulePrimitiveLiteralExpCS6769 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInvalidLiteralExpCS_in_rulePrimitiveLiteralExpCS6799 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNullLiteralExpCS_in_rulePrimitiveLiteralExpCS6829 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTupleLiteralExpCS_in_entryRuleTupleLiteralExpCS6864 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTupleLiteralExpCS6874 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_55_in_ruleTupleLiteralExpCS6911 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleTupleLiteralExpCS6923 = new BitSet(new long[]{0x0000003FE1800030L});
        public static final BitSet FOLLOW_ruleTupleLiteralPartCS_in_ruleTupleLiteralExpCS6944 = new BitSet(new long[]{0x00000000000A0000L});
        public static final BitSet FOLLOW_17_in_ruleTupleLiteralExpCS6957 = new BitSet(new long[]{0x0000003FE1800030L});
        public static final BitSet FOLLOW_ruleTupleLiteralPartCS_in_ruleTupleLiteralExpCS6978 = new BitSet(new long[]{0x00000000000A0000L});
        public static final BitSet FOLLOW_19_in_ruleTupleLiteralExpCS6992 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTupleLiteralPartCS_in_entryRuleTupleLiteralPartCS7028 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTupleLiteralPartCS7038 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleTupleLiteralPartCS7084 = new BitSet(new long[]{0x0000800008000000L});
        public static final BitSet FOLLOW_27_in_ruleTupleLiteralPartCS7097 = new BitSet(new long[]{0xFF8001FFE38000F0L,0x0000000000209E1FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleTupleLiteralPartCS7118 = new BitSet(new long[]{0x0000800000000000L});
        public static final BitSet FOLLOW_47_in_ruleTupleLiteralPartCS7132 = new BitSet(new long[]{0xFF8001FFE39000F0L,0x0000000000289E1FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleTupleLiteralPartCS7153 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNumberLiteralExpCS_in_entryRuleNumberLiteralExpCS7189 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNumberLiteralExpCS7199 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNUMBER_LITERAL_in_ruleNumberLiteralExpCS7244 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringLiteralExpCS_in_entryRuleStringLiteralExpCS7279 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteralExpCS7289 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringLiteral_in_ruleStringLiteralExpCS7334 = new BitSet(new long[]{0x0000000000000082L});
        public static final BitSet FOLLOW_ruleBooleanLiteralExpCS_in_entryRuleBooleanLiteralExpCS7370 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBooleanLiteralExpCS7380 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_73_in_ruleBooleanLiteralExpCS7423 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_74_in_ruleBooleanLiteralExpCS7460 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnlimitedNaturalLiteralExpCS_in_entryRuleUnlimitedNaturalLiteralExpCS7509 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnlimitedNaturalLiteralExpCS7519 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_ruleUnlimitedNaturalLiteralExpCS7568 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInvalidLiteralExpCS_in_entryRuleInvalidLiteralExpCS7604 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleInvalidLiteralExpCS7614 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_75_in_ruleInvalidLiteralExpCS7663 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNullLiteralExpCS_in_entryRuleNullLiteralExpCS7699 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNullLiteralExpCS7709 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_76_in_ruleNullLiteralExpCS7758 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralCS_in_entryRuleTypeLiteralCS7794 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeLiteralCS7804 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveTypeCS_in_ruleTypeLiteralCS7854 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionTypeCS_in_ruleTypeLiteralCS7884 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTupleTypeCS_in_ruleTypeLiteralCS7914 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralWithMultiplicityCS_in_entryRuleTypeLiteralWithMultiplicityCS7949 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeLiteralWithMultiplicityCS7959 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralCS_in_ruleTypeLiteralWithMultiplicityCS8009 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
        public static final BitSet FOLLOW_ruleMultiplicityCS_in_ruleTypeLiteralWithMultiplicityCS8029 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralExpCS_in_entryRuleTypeLiteralExpCS8066 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeLiteralExpCS8076 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralWithMultiplicityCS_in_ruleTypeLiteralExpCS8121 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeNameExpCS_in_entryRuleTypeNameExpCS8156 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeNameExpCS8166 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePathNameCS_in_ruleTypeNameExpCS8211 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_entryRuleTypeExpCS8246 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeExpCS8256 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeNameExpCS_in_ruleTypeExpCS8307 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
        public static final BitSet FOLLOW_ruleTypeLiteralCS_in_ruleTypeExpCS8337 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
        public static final BitSet FOLLOW_ruleMultiplicityCS_in_ruleTypeExpCS8358 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpCS_in_entryRuleExpCS8395 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleExpCS8405 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrefixedExpCS_in_ruleExpCS8456 = new BitSet(new long[]{0x007FFEC000000002L});
        public static final BitSet FOLLOW_ruleBinaryOperatorCS_in_ruleExpCS8489 = new BitSet(new long[]{0xFF8001FFE39000F0L,0x0000000000289E1FL});
        public static final BitSet FOLLOW_rulePrefixedExpCS_in_ruleExpCS8512 = new BitSet(new long[]{0x007FFEC000000002L});
        public static final BitSet FOLLOW_ruleBinaryOperatorCS_in_ruleExpCS8534 = new BitSet(new long[]{0xFF8001FFE38000F0L,0x0000000000209E1FL});
        public static final BitSet FOLLOW_rulePrefixedExpCS_in_ruleExpCS8555 = new BitSet(new long[]{0x007FFEC000000002L});
        public static final BitSet FOLLOW_ruleBinaryOperatorCS_in_ruleExpCS8579 = new BitSet(new long[]{0xFF8001FFE39000F0L,0x0000000000289E1FL});
        public static final BitSet FOLLOW_ruleLetExpCS_in_ruleExpCS8600 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLetExpCS_in_ruleExpCS8630 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnaryOperatorCS_in_ruleExpCS8674 = new BitSet(new long[]{0xFF8001FFE39000F0L,0x0000000000289E1FL});
        public static final BitSet FOLLOW_ruleLetExpCS_in_ruleExpCS8696 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLetExpCS_in_ruleExpCS8728 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrefixedExpCS_in_entryRulePrefixedExpCS8763 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrefixedExpCS8773 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnaryOperatorCS_in_rulePrefixedExpCS8832 = new BitSet(new long[]{0xFF8001FFE38000F0L,0x0000000000209E1FL});
        public static final BitSet FOLLOW_rulePrimaryExpCS_in_rulePrefixedExpCS8854 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimaryExpCS_in_rulePrefixedExpCS8886 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimaryExpCS_in_entryRulePrimaryExpCS8921 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpCS8931 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedExpCS_in_rulePrimaryExpCS8981 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIfExpCS_in_rulePrimaryExpCS9011 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSelfExpCS_in_rulePrimaryExpCS9041 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveLiteralExpCS_in_rulePrimaryExpCS9071 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTupleLiteralExpCS_in_rulePrimaryExpCS9101 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionLiteralExpCS_in_rulePrimaryExpCS9131 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralExpCS_in_rulePrimaryExpCS9161 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePathNameCS_in_rulePrimaryExpCS9200 = new BitSet(new long[]{0x0000000002010002L,0x0000000000002040L});
        public static final BitSet FOLLOW_70_in_rulePrimaryExpCS9226 = new BitSet(new long[]{0xFF8001FFE39000F0L,0x0000000000289E1FL});
        public static final BitSet FOLLOW_ruleExpCS_in_rulePrimaryExpCS9247 = new BitSet(new long[]{0x0000000000020000L,0x0000000000000080L});
        public static final BitSet FOLLOW_17_in_rulePrimaryExpCS9260 = new BitSet(new long[]{0xFF8001FFE39000F0L,0x0000000000289E1FL});
        public static final BitSet FOLLOW_ruleExpCS_in_rulePrimaryExpCS9281 = new BitSet(new long[]{0x0000000000020000L,0x0000000000000080L});
        public static final BitSet FOLLOW_71_in_rulePrimaryExpCS9295 = new BitSet(new long[]{0x0000000000000002L,0x0000000000002040L});
        public static final BitSet FOLLOW_70_in_rulePrimaryExpCS9308 = new BitSet(new long[]{0xFF8001FFE39000F0L,0x0000000000289E1FL});
        public static final BitSet FOLLOW_ruleExpCS_in_rulePrimaryExpCS9329 = new BitSet(new long[]{0x0000000000020000L,0x0000000000000080L});
        public static final BitSet FOLLOW_17_in_rulePrimaryExpCS9342 = new BitSet(new long[]{0xFF8001FFE39000F0L,0x0000000000289E1FL});
        public static final BitSet FOLLOW_ruleExpCS_in_rulePrimaryExpCS9363 = new BitSet(new long[]{0x0000000000020000L,0x0000000000000080L});
        public static final BitSet FOLLOW_71_in_rulePrimaryExpCS9377 = new BitSet(new long[]{0x0000000000000002L,0x0000000000002000L});
        public static final BitSet FOLLOW_77_in_rulePrimaryExpCS9398 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
        public static final BitSet FOLLOW_78_in_rulePrimaryExpCS9423 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rulePrimaryExpCS9457 = new BitSet(new long[]{0x0000003FE18000B0L});
        public static final BitSet FOLLOW_ruleConstructorPartCS_in_rulePrimaryExpCS9480 = new BitSet(new long[]{0x00000000000A0000L});
        public static final BitSet FOLLOW_17_in_rulePrimaryExpCS9493 = new BitSet(new long[]{0x0000003FE1800030L});
        public static final BitSet FOLLOW_ruleConstructorPartCS_in_rulePrimaryExpCS9514 = new BitSet(new long[]{0x00000000000A0000L});
        public static final BitSet FOLLOW_ruleStringLiteral_in_rulePrimaryExpCS9544 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_19_in_rulePrimaryExpCS9557 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_77_in_rulePrimaryExpCS9584 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
        public static final BitSet FOLLOW_78_in_rulePrimaryExpCS9609 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_25_in_rulePrimaryExpCS9636 = new BitSet(new long[]{0xFF8001FFE79000F0L,0x0000000000289E1FL});
        public static final BitSet FOLLOW_ruleNavigatingArgCS_in_rulePrimaryExpCS9658 = new BitSet(new long[]{0x0000000004460000L});
        public static final BitSet FOLLOW_ruleNavigatingCommaArgCS_in_rulePrimaryExpCS9679 = new BitSet(new long[]{0x0000000004460000L});
        public static final BitSet FOLLOW_ruleNavigatingSemiArgCS_in_rulePrimaryExpCS9702 = new BitSet(new long[]{0x0000000004060000L});
        public static final BitSet FOLLOW_ruleNavigatingCommaArgCS_in_rulePrimaryExpCS9723 = new BitSet(new long[]{0x0000000004060000L});
        public static final BitSet FOLLOW_ruleNavigatingBarArgCS_in_rulePrimaryExpCS9748 = new BitSet(new long[]{0x0000000004020000L});
        public static final BitSet FOLLOW_ruleNavigatingCommaArgCS_in_rulePrimaryExpCS9769 = new BitSet(new long[]{0x0000000004020000L});
        public static final BitSet FOLLOW_26_in_rulePrimaryExpCS9786 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingArgCS_in_entryRuleNavigatingArgCS9827 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigatingArgCS9837 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingArgCS9883 = new BitSet(new long[]{0x0000000008000002L});
        public static final BitSet FOLLOW_27_in_ruleNavigatingArgCS9896 = new BitSet(new long[]{0xFF8001FFE38000F0L,0x0000000000209E1FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleNavigatingArgCS9917 = new BitSet(new long[]{0x0000800000000002L});
        public static final BitSet FOLLOW_47_in_ruleNavigatingArgCS9930 = new BitSet(new long[]{0xFF8001FFE39000F0L,0x0000000000289E1FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNavigatingArgCS9951 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingBarArgCS_in_entryRuleNavigatingBarArgCS9991 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigatingBarArgCS10001 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleNavigatingBarArgCS10044 = new BitSet(new long[]{0xFF8001FFE39000F0L,0x0000000000289E1FL});
        public static final BitSet FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingBarArgCS10078 = new BitSet(new long[]{0x0000000008000002L});
        public static final BitSet FOLLOW_27_in_ruleNavigatingBarArgCS10091 = new BitSet(new long[]{0xFF8001FFE38000F0L,0x0000000000209E1FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleNavigatingBarArgCS10112 = new BitSet(new long[]{0x0000800000000002L});
        public static final BitSet FOLLOW_47_in_ruleNavigatingBarArgCS10125 = new BitSet(new long[]{0xFF8001FFE39000F0L,0x0000000000289E1FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNavigatingBarArgCS10146 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingCommaArgCS_in_entryRuleNavigatingCommaArgCS10186 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigatingCommaArgCS10196 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleNavigatingCommaArgCS10239 = new BitSet(new long[]{0xFF8001FFE39000F0L,0x0000000000289E1FL});
        public static final BitSet FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingCommaArgCS10273 = new BitSet(new long[]{0x0000000008000002L});
        public static final BitSet FOLLOW_27_in_ruleNavigatingCommaArgCS10286 = new BitSet(new long[]{0xFF8001FFE38000F0L,0x0000000000209E1FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleNavigatingCommaArgCS10307 = new BitSet(new long[]{0x0000800000000002L});
        public static final BitSet FOLLOW_47_in_ruleNavigatingCommaArgCS10320 = new BitSet(new long[]{0xFF8001FFE39000F0L,0x0000000000289E1FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNavigatingCommaArgCS10341 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingSemiArgCS_in_entryRuleNavigatingSemiArgCS10381 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigatingSemiArgCS10391 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleNavigatingSemiArgCS10434 = new BitSet(new long[]{0xFF8001FFE39000F0L,0x0000000000289E1FL});
        public static final BitSet FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingSemiArgCS10468 = new BitSet(new long[]{0x0000000008000002L});
        public static final BitSet FOLLOW_27_in_ruleNavigatingSemiArgCS10481 = new BitSet(new long[]{0xFF8001FFE38000F0L,0x0000000000209E1FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleNavigatingSemiArgCS10502 = new BitSet(new long[]{0x0000800000000002L});
        public static final BitSet FOLLOW_47_in_ruleNavigatingSemiArgCS10515 = new BitSet(new long[]{0xFF8001FFE39000F0L,0x0000000000289E1FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNavigatingSemiArgCS10536 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingArgExpCS_in_entryRuleNavigatingArgExpCS10576 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigatingArgExpCS10586 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNavigatingArgExpCS10635 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIfExpCS_in_entryRuleIfExpCS10669 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIfExpCS10679 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_79_in_ruleIfExpCS10716 = new BitSet(new long[]{0xFF8001FFE39000F0L,0x0000000000289E1FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleIfExpCS10737 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
        public static final BitSet FOLLOW_80_in_ruleIfExpCS10749 = new BitSet(new long[]{0xFF8001FFE39000F0L,0x0000000000289E1FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleIfExpCS10770 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
        public static final BitSet FOLLOW_81_in_ruleIfExpCS10782 = new BitSet(new long[]{0xFF8001FFE39000F0L,0x0000000000289E1FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleIfExpCS10803 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
        public static final BitSet FOLLOW_82_in_ruleIfExpCS10815 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLetExpCS_in_entryRuleLetExpCS10851 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLetExpCS10861 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_83_in_ruleLetExpCS10898 = new BitSet(new long[]{0x0000003FE1800030L});
        public static final BitSet FOLLOW_ruleLetVariableCS_in_ruleLetExpCS10919 = new BitSet(new long[]{0x0000000000020000L,0x0000000000100000L});
        public static final BitSet FOLLOW_17_in_ruleLetExpCS10932 = new BitSet(new long[]{0x0000003FE1800030L});
        public static final BitSet FOLLOW_ruleLetVariableCS_in_ruleLetExpCS10953 = new BitSet(new long[]{0x0000000000020000L,0x0000000000100000L});
        public static final BitSet FOLLOW_84_in_ruleLetExpCS10967 = new BitSet(new long[]{0xFF8001FFE39000F0L,0x0000000000289E1FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleLetExpCS10988 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLetVariableCS_in_entryRuleLetVariableCS11024 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLetVariableCS11034 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleLetVariableCS11080 = new BitSet(new long[]{0x0000800008000000L});
        public static final BitSet FOLLOW_27_in_ruleLetVariableCS11093 = new BitSet(new long[]{0xFF8001FFE38000F0L,0x0000000000209E1FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleLetVariableCS11114 = new BitSet(new long[]{0x0000800000000000L});
        public static final BitSet FOLLOW_47_in_ruleLetVariableCS11128 = new BitSet(new long[]{0xFF8001FFE39000F0L,0x0000000000289E1FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleLetVariableCS11149 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedExpCS_in_entryRuleNestedExpCS11185 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNestedExpCS11195 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_ruleNestedExpCS11232 = new BitSet(new long[]{0xFF8001FFE39000F0L,0x0000000000289E1FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNestedExpCS11253 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_ruleNestedExpCS11265 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSelfExpCS_in_entryRuleSelfExpCS11301 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSelfExpCS11311 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_85_in_ruleSelfExpCS11360 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTupleLiteralExpCS_in_synpred103_InternalQVTcoreBase9101 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionLiteralExpCS_in_synpred104_InternalQVTcoreBase9131 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralExpCS_in_synpred105_InternalQVTcoreBase9161 = new BitSet(new long[]{0x0000000000000002L});
    }


}