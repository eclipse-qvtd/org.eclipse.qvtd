package org.eclipse.qvtd.doc.parser.antlr.internal;

import org.antlr.runtime.BitSet;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.qvtd.doc.services.MiniOCLCSGrammarAccess;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
@SuppressWarnings("all")
public class InternalMiniOCLCSParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'package'", "'{'", "'}'", "'class'", "'extends'", "'datatype'", "':'", "';'", "'attribute'", "'containment'", "'cross_reference'", "'['", "'?'", "'*'", "'..'", "']'", "'op'", "'('", "','", "')'", "'='", "'context'", "'inv'", "'<>'", "'.'", "'->'", "'self'", "'collect'", "'|'", "'iterate'", "'true'", "'false'", "'null'", "'let'", "'in'", "'::'", "'Collection'"
    };
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int RULE_ID=4;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

    // delegates
    // delegators


        public InternalMiniOCLCSParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalMiniOCLCSParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalMiniOCLCSParser.tokenNames; }
    public String getGrammarFileName() { return "InternalMiniOCLCS.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */

     	private MiniOCLCSGrammarAccess grammarAccess;

        public InternalMiniOCLCSParser(TokenStream input, MiniOCLCSGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "RootCS";
       	}

       	@Override
       	protected MiniOCLCSGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleRootCS"
    // InternalMiniOCLCS.g:71:1: entryRuleRootCS returns [EObject current=null] : iv_ruleRootCS= ruleRootCS EOF ;
    public final EObject entryRuleRootCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRootCS = null;


        try {
            // InternalMiniOCLCS.g:71:47: (iv_ruleRootCS= ruleRootCS EOF )
            // InternalMiniOCLCS.g:72:2: iv_ruleRootCS= ruleRootCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRootCSRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRootCS=ruleRootCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRootCS; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRootCS"


    // $ANTLR start "ruleRootCS"
    // InternalMiniOCLCS.g:78:1: ruleRootCS returns [EObject current=null] : ( ( (lv_packages_0_0= rulePackageCS ) ) | ( (lv_contraints_1_0= ruleConstraintsDefCS ) ) )* ;
    public final EObject ruleRootCS() throws RecognitionException {
        EObject current = null;

        EObject lv_packages_0_0 = null;

        EObject lv_contraints_1_0 = null;



        	enterRule();

        try {
            // InternalMiniOCLCS.g:84:2: ( ( ( (lv_packages_0_0= rulePackageCS ) ) | ( (lv_contraints_1_0= ruleConstraintsDefCS ) ) )* )
            // InternalMiniOCLCS.g:85:2: ( ( (lv_packages_0_0= rulePackageCS ) ) | ( (lv_contraints_1_0= ruleConstraintsDefCS ) ) )*
            {
            // InternalMiniOCLCS.g:85:2: ( ( (lv_packages_0_0= rulePackageCS ) ) | ( (lv_contraints_1_0= ruleConstraintsDefCS ) ) )*
            loop1:
            do {
                int alt1=3;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }
                else if ( (LA1_0==32) ) {
                    alt1=2;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalMiniOCLCS.g:86:3: ( (lv_packages_0_0= rulePackageCS ) )
            	    {
            	    // InternalMiniOCLCS.g:86:3: ( (lv_packages_0_0= rulePackageCS ) )
            	    // InternalMiniOCLCS.g:87:4: (lv_packages_0_0= rulePackageCS )
            	    {
            	    // InternalMiniOCLCS.g:87:4: (lv_packages_0_0= rulePackageCS )
            	    // InternalMiniOCLCS.g:88:5: lv_packages_0_0= rulePackageCS
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getRootCSAccess().getPackagesPackageCSParserRuleCall_0_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_3);
            	    lv_packages_0_0=rulePackageCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getRootCSRule());
            	      					}
            	      					add(
            	      						current,
            	      						"packages",
            	      						lv_packages_0_0,
            	      						"org.eclipse.qvtd.doc.MiniOCLCS.PackageCS");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalMiniOCLCS.g:106:3: ( (lv_contraints_1_0= ruleConstraintsDefCS ) )
            	    {
            	    // InternalMiniOCLCS.g:106:3: ( (lv_contraints_1_0= ruleConstraintsDefCS ) )
            	    // InternalMiniOCLCS.g:107:4: (lv_contraints_1_0= ruleConstraintsDefCS )
            	    {
            	    // InternalMiniOCLCS.g:107:4: (lv_contraints_1_0= ruleConstraintsDefCS )
            	    // InternalMiniOCLCS.g:108:5: lv_contraints_1_0= ruleConstraintsDefCS
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getRootCSAccess().getContraintsConstraintsDefCSParserRuleCall_1_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_3);
            	    lv_contraints_1_0=ruleConstraintsDefCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getRootCSRule());
            	      					}
            	      					add(
            	      						current,
            	      						"contraints",
            	      						lv_contraints_1_0,
            	      						"org.eclipse.qvtd.doc.MiniOCLCS.ConstraintsDefCS");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
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
    // $ANTLR end "ruleRootCS"


    // $ANTLR start "entryRulePackageCS"
    // InternalMiniOCLCS.g:129:1: entryRulePackageCS returns [EObject current=null] : iv_rulePackageCS= rulePackageCS EOF ;
    public final EObject entryRulePackageCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePackageCS = null;


        try {
            // InternalMiniOCLCS.g:129:50: (iv_rulePackageCS= rulePackageCS EOF )
            // InternalMiniOCLCS.g:130:2: iv_rulePackageCS= rulePackageCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPackageCSRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePackageCS=rulePackageCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePackageCS; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePackageCS"


    // $ANTLR start "rulePackageCS"
    // InternalMiniOCLCS.g:136:1: rulePackageCS returns [EObject current=null] : (otherlv_0= 'package' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_packages_3_0= rulePackageCS ) ) | ( (lv_classifiers_4_0= ruleClassifierCS ) ) )* otherlv_5= '}' ) ;
    public final EObject rulePackageCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        EObject lv_packages_3_0 = null;

        EObject lv_classifiers_4_0 = null;



        	enterRule();

        try {
            // InternalMiniOCLCS.g:142:2: ( (otherlv_0= 'package' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_packages_3_0= rulePackageCS ) ) | ( (lv_classifiers_4_0= ruleClassifierCS ) ) )* otherlv_5= '}' ) )
            // InternalMiniOCLCS.g:143:2: (otherlv_0= 'package' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_packages_3_0= rulePackageCS ) ) | ( (lv_classifiers_4_0= ruleClassifierCS ) ) )* otherlv_5= '}' )
            {
            // InternalMiniOCLCS.g:143:2: (otherlv_0= 'package' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_packages_3_0= rulePackageCS ) ) | ( (lv_classifiers_4_0= ruleClassifierCS ) ) )* otherlv_5= '}' )
            // InternalMiniOCLCS.g:144:3: otherlv_0= 'package' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_packages_3_0= rulePackageCS ) ) | ( (lv_classifiers_4_0= ruleClassifierCS ) ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getPackageCSAccess().getPackageKeyword_0());
              		
            }
            // InternalMiniOCLCS.g:148:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMiniOCLCS.g:149:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMiniOCLCS.g:149:4: (lv_name_1_0= RULE_ID )
            // InternalMiniOCLCS.g:150:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getPackageCSAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getPackageCSRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getPackageCSAccess().getLeftCurlyBracketKeyword_2());
              		
            }
            // InternalMiniOCLCS.g:170:3: ( ( (lv_packages_3_0= rulePackageCS ) ) | ( (lv_classifiers_4_0= ruleClassifierCS ) ) )*
            loop2:
            do {
                int alt2=3;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==11) ) {
                    alt2=1;
                }
                else if ( (LA2_0==14||LA2_0==16) ) {
                    alt2=2;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalMiniOCLCS.g:171:4: ( (lv_packages_3_0= rulePackageCS ) )
            	    {
            	    // InternalMiniOCLCS.g:171:4: ( (lv_packages_3_0= rulePackageCS ) )
            	    // InternalMiniOCLCS.g:172:5: (lv_packages_3_0= rulePackageCS )
            	    {
            	    // InternalMiniOCLCS.g:172:5: (lv_packages_3_0= rulePackageCS )
            	    // InternalMiniOCLCS.g:173:6: lv_packages_3_0= rulePackageCS
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getPackageCSAccess().getPackagesPackageCSParserRuleCall_3_0_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_6);
            	    lv_packages_3_0=rulePackageCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getPackageCSRule());
            	      						}
            	      						add(
            	      							current,
            	      							"packages",
            	      							lv_packages_3_0,
            	      							"org.eclipse.qvtd.doc.MiniOCLCS.PackageCS");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalMiniOCLCS.g:191:4: ( (lv_classifiers_4_0= ruleClassifierCS ) )
            	    {
            	    // InternalMiniOCLCS.g:191:4: ( (lv_classifiers_4_0= ruleClassifierCS ) )
            	    // InternalMiniOCLCS.g:192:5: (lv_classifiers_4_0= ruleClassifierCS )
            	    {
            	    // InternalMiniOCLCS.g:192:5: (lv_classifiers_4_0= ruleClassifierCS )
            	    // InternalMiniOCLCS.g:193:6: lv_classifiers_4_0= ruleClassifierCS
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getPackageCSAccess().getClassifiersClassifierCSParserRuleCall_3_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_6);
            	    lv_classifiers_4_0=ruleClassifierCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getPackageCSRule());
            	      						}
            	      						add(
            	      							current,
            	      							"classifiers",
            	      							lv_classifiers_4_0,
            	      							"org.eclipse.qvtd.doc.MiniOCLCS.ClassifierCS");
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

            otherlv_5=(Token)match(input,13,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getPackageCSAccess().getRightCurlyBracketKeyword_4());
              		
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
    // $ANTLR end "rulePackageCS"


    // $ANTLR start "entryRuleClassifierCS"
    // InternalMiniOCLCS.g:219:1: entryRuleClassifierCS returns [EObject current=null] : iv_ruleClassifierCS= ruleClassifierCS EOF ;
    public final EObject entryRuleClassifierCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClassifierCS = null;


        try {
            // InternalMiniOCLCS.g:219:53: (iv_ruleClassifierCS= ruleClassifierCS EOF )
            // InternalMiniOCLCS.g:220:2: iv_ruleClassifierCS= ruleClassifierCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getClassifierCSRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleClassifierCS=ruleClassifierCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleClassifierCS; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleClassifierCS"


    // $ANTLR start "ruleClassifierCS"
    // InternalMiniOCLCS.g:226:1: ruleClassifierCS returns [EObject current=null] : (this_ClassCS_0= ruleClassCS | this_DatatypeCS_1= ruleDatatypeCS ) ;
    public final EObject ruleClassifierCS() throws RecognitionException {
        EObject current = null;

        EObject this_ClassCS_0 = null;

        EObject this_DatatypeCS_1 = null;



        	enterRule();

        try {
            // InternalMiniOCLCS.g:232:2: ( (this_ClassCS_0= ruleClassCS | this_DatatypeCS_1= ruleDatatypeCS ) )
            // InternalMiniOCLCS.g:233:2: (this_ClassCS_0= ruleClassCS | this_DatatypeCS_1= ruleDatatypeCS )
            {
            // InternalMiniOCLCS.g:233:2: (this_ClassCS_0= ruleClassCS | this_DatatypeCS_1= ruleDatatypeCS )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==14) ) {
                alt3=1;
            }
            else if ( (LA3_0==16) ) {
                alt3=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalMiniOCLCS.g:234:3: this_ClassCS_0= ruleClassCS
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getClassifierCSAccess().getClassCSParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ClassCS_0=ruleClassCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ClassCS_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalMiniOCLCS.g:246:3: this_DatatypeCS_1= ruleDatatypeCS
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getClassifierCSAccess().getDatatypeCSParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_DatatypeCS_1=ruleDatatypeCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_DatatypeCS_1;
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
    // $ANTLR end "ruleClassifierCS"


    // $ANTLR start "entryRuleClassCS"
    // InternalMiniOCLCS.g:261:1: entryRuleClassCS returns [EObject current=null] : iv_ruleClassCS= ruleClassCS EOF ;
    public final EObject entryRuleClassCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClassCS = null;


        try {
            // InternalMiniOCLCS.g:261:48: (iv_ruleClassCS= ruleClassCS EOF )
            // InternalMiniOCLCS.g:262:2: iv_ruleClassCS= ruleClassCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getClassCSRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleClassCS=ruleClassCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleClassCS; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleClassCS"


    // $ANTLR start "ruleClassCS"
    // InternalMiniOCLCS.g:268:1: ruleClassCS returns [EObject current=null] : (otherlv_0= 'class' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (lv_extends_3_0= rulePathNameCS ) ) )? otherlv_4= '{' ( ( (lv_properties_5_0= rulePropertyCS ) ) | ( (lv_operations_6_0= ruleOperationCS ) ) )* otherlv_7= '}' ) ;
    public final EObject ruleClassCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        EObject lv_extends_3_0 = null;

        EObject lv_properties_5_0 = null;

        EObject lv_operations_6_0 = null;



        	enterRule();

        try {
            // InternalMiniOCLCS.g:274:2: ( (otherlv_0= 'class' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (lv_extends_3_0= rulePathNameCS ) ) )? otherlv_4= '{' ( ( (lv_properties_5_0= rulePropertyCS ) ) | ( (lv_operations_6_0= ruleOperationCS ) ) )* otherlv_7= '}' ) )
            // InternalMiniOCLCS.g:275:2: (otherlv_0= 'class' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (lv_extends_3_0= rulePathNameCS ) ) )? otherlv_4= '{' ( ( (lv_properties_5_0= rulePropertyCS ) ) | ( (lv_operations_6_0= ruleOperationCS ) ) )* otherlv_7= '}' )
            {
            // InternalMiniOCLCS.g:275:2: (otherlv_0= 'class' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (lv_extends_3_0= rulePathNameCS ) ) )? otherlv_4= '{' ( ( (lv_properties_5_0= rulePropertyCS ) ) | ( (lv_operations_6_0= ruleOperationCS ) ) )* otherlv_7= '}' )
            // InternalMiniOCLCS.g:276:3: otherlv_0= 'class' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (lv_extends_3_0= rulePathNameCS ) ) )? otherlv_4= '{' ( ( (lv_properties_5_0= rulePropertyCS ) ) | ( (lv_operations_6_0= ruleOperationCS ) ) )* otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,14,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getClassCSAccess().getClassKeyword_0());
              		
            }
            // InternalMiniOCLCS.g:280:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMiniOCLCS.g:281:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMiniOCLCS.g:281:4: (lv_name_1_0= RULE_ID )
            // InternalMiniOCLCS.g:282:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getClassCSAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getClassCSRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            // InternalMiniOCLCS.g:298:3: (otherlv_2= 'extends' ( (lv_extends_3_0= rulePathNameCS ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==15) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalMiniOCLCS.g:299:4: otherlv_2= 'extends' ( (lv_extends_3_0= rulePathNameCS ) )
                    {
                    otherlv_2=(Token)match(input,15,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getClassCSAccess().getExtendsKeyword_2_0());
                      			
                    }
                    // InternalMiniOCLCS.g:303:4: ( (lv_extends_3_0= rulePathNameCS ) )
                    // InternalMiniOCLCS.g:304:5: (lv_extends_3_0= rulePathNameCS )
                    {
                    // InternalMiniOCLCS.g:304:5: (lv_extends_3_0= rulePathNameCS )
                    // InternalMiniOCLCS.g:305:6: lv_extends_3_0= rulePathNameCS
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getClassCSAccess().getExtendsPathNameCSParserRuleCall_2_1_0());
                      					
                    }
                    pushFollow(FOLLOW_5);
                    lv_extends_3_0=rulePathNameCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getClassCSRule());
                      						}
                      						set(
                      							current,
                      							"extends",
                      							lv_extends_3_0,
                      							"org.eclipse.qvtd.doc.MiniOCLCS.PathNameCS");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,12,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getClassCSAccess().getLeftCurlyBracketKeyword_3());
              		
            }
            // InternalMiniOCLCS.g:327:3: ( ( (lv_properties_5_0= rulePropertyCS ) ) | ( (lv_operations_6_0= ruleOperationCS ) ) )*
            loop5:
            do {
                int alt5=3;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>=19 && LA5_0<=21)) ) {
                    alt5=1;
                }
                else if ( (LA5_0==27) ) {
                    alt5=2;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalMiniOCLCS.g:328:4: ( (lv_properties_5_0= rulePropertyCS ) )
            	    {
            	    // InternalMiniOCLCS.g:328:4: ( (lv_properties_5_0= rulePropertyCS ) )
            	    // InternalMiniOCLCS.g:329:5: (lv_properties_5_0= rulePropertyCS )
            	    {
            	    // InternalMiniOCLCS.g:329:5: (lv_properties_5_0= rulePropertyCS )
            	    // InternalMiniOCLCS.g:330:6: lv_properties_5_0= rulePropertyCS
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getClassCSAccess().getPropertiesPropertyCSParserRuleCall_4_0_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_8);
            	    lv_properties_5_0=rulePropertyCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getClassCSRule());
            	      						}
            	      						add(
            	      							current,
            	      							"properties",
            	      							lv_properties_5_0,
            	      							"org.eclipse.qvtd.doc.MiniOCLCS.PropertyCS");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalMiniOCLCS.g:348:4: ( (lv_operations_6_0= ruleOperationCS ) )
            	    {
            	    // InternalMiniOCLCS.g:348:4: ( (lv_operations_6_0= ruleOperationCS ) )
            	    // InternalMiniOCLCS.g:349:5: (lv_operations_6_0= ruleOperationCS )
            	    {
            	    // InternalMiniOCLCS.g:349:5: (lv_operations_6_0= ruleOperationCS )
            	    // InternalMiniOCLCS.g:350:6: lv_operations_6_0= ruleOperationCS
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getClassCSAccess().getOperationsOperationCSParserRuleCall_4_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_8);
            	    lv_operations_6_0=ruleOperationCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getClassCSRule());
            	      						}
            	      						add(
            	      							current,
            	      							"operations",
            	      							lv_operations_6_0,
            	      							"org.eclipse.qvtd.doc.MiniOCLCS.OperationCS");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            otherlv_7=(Token)match(input,13,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_7, grammarAccess.getClassCSAccess().getRightCurlyBracketKeyword_5());
              		
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
    // $ANTLR end "ruleClassCS"


    // $ANTLR start "entryRuleDatatypeCS"
    // InternalMiniOCLCS.g:376:1: entryRuleDatatypeCS returns [EObject current=null] : iv_ruleDatatypeCS= ruleDatatypeCS EOF ;
    public final EObject entryRuleDatatypeCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDatatypeCS = null;


        try {
            // InternalMiniOCLCS.g:376:51: (iv_ruleDatatypeCS= ruleDatatypeCS EOF )
            // InternalMiniOCLCS.g:377:2: iv_ruleDatatypeCS= ruleDatatypeCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDatatypeCSRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDatatypeCS=ruleDatatypeCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDatatypeCS; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDatatypeCS"


    // $ANTLR start "ruleDatatypeCS"
    // InternalMiniOCLCS.g:383:1: ruleDatatypeCS returns [EObject current=null] : (otherlv_0= 'datatype' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_typeName_3_0= RULE_STRING ) ) otherlv_4= ';' ) ;
    public final EObject ruleDatatypeCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_typeName_3_0=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalMiniOCLCS.g:389:2: ( (otherlv_0= 'datatype' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_typeName_3_0= RULE_STRING ) ) otherlv_4= ';' ) )
            // InternalMiniOCLCS.g:390:2: (otherlv_0= 'datatype' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_typeName_3_0= RULE_STRING ) ) otherlv_4= ';' )
            {
            // InternalMiniOCLCS.g:390:2: (otherlv_0= 'datatype' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_typeName_3_0= RULE_STRING ) ) otherlv_4= ';' )
            // InternalMiniOCLCS.g:391:3: otherlv_0= 'datatype' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_typeName_3_0= RULE_STRING ) ) otherlv_4= ';'
            {
            otherlv_0=(Token)match(input,16,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getDatatypeCSAccess().getDatatypeKeyword_0());
              		
            }
            // InternalMiniOCLCS.g:395:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMiniOCLCS.g:396:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMiniOCLCS.g:396:4: (lv_name_1_0= RULE_ID )
            // InternalMiniOCLCS.g:397:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getDatatypeCSAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getDatatypeCSRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,17,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getDatatypeCSAccess().getColonKeyword_2());
              		
            }
            // InternalMiniOCLCS.g:417:3: ( (lv_typeName_3_0= RULE_STRING ) )
            // InternalMiniOCLCS.g:418:4: (lv_typeName_3_0= RULE_STRING )
            {
            // InternalMiniOCLCS.g:418:4: (lv_typeName_3_0= RULE_STRING )
            // InternalMiniOCLCS.g:419:5: lv_typeName_3_0= RULE_STRING
            {
            lv_typeName_3_0=(Token)match(input,RULE_STRING,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_typeName_3_0, grammarAccess.getDatatypeCSAccess().getTypeNameSTRINGTerminalRuleCall_3_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getDatatypeCSRule());
              					}
              					setWithLastConsumed(
              						current,
              						"typeName",
              						lv_typeName_3_0,
              						"org.eclipse.xtext.common.Terminals.STRING");
              				
            }

            }


            }

            otherlv_4=(Token)match(input,18,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getDatatypeCSAccess().getSemicolonKeyword_4());
              		
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
    // $ANTLR end "ruleDatatypeCS"


    // $ANTLR start "entryRulePropertyCS"
    // InternalMiniOCLCS.g:443:1: entryRulePropertyCS returns [EObject current=null] : iv_rulePropertyCS= rulePropertyCS EOF ;
    public final EObject entryRulePropertyCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyCS = null;


        try {
            // InternalMiniOCLCS.g:443:51: (iv_rulePropertyCS= rulePropertyCS EOF )
            // InternalMiniOCLCS.g:444:2: iv_rulePropertyCS= rulePropertyCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPropertyCSRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePropertyCS=rulePropertyCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePropertyCS; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePropertyCS"


    // $ANTLR start "rulePropertyCS"
    // InternalMiniOCLCS.g:450:1: rulePropertyCS returns [EObject current=null] : ( (otherlv_0= 'attribute' | otherlv_1= 'containment' | otherlv_2= 'cross_reference' ) ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_typeRef_5_0= rulePathNameCS ) ) ( (lv_multiplicity_6_0= ruleMultiplicityCS ) )? otherlv_7= ';' ) ;
    public final EObject rulePropertyCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        EObject lv_typeRef_5_0 = null;

        EObject lv_multiplicity_6_0 = null;



        	enterRule();

        try {
            // InternalMiniOCLCS.g:456:2: ( ( (otherlv_0= 'attribute' | otherlv_1= 'containment' | otherlv_2= 'cross_reference' ) ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_typeRef_5_0= rulePathNameCS ) ) ( (lv_multiplicity_6_0= ruleMultiplicityCS ) )? otherlv_7= ';' ) )
            // InternalMiniOCLCS.g:457:2: ( (otherlv_0= 'attribute' | otherlv_1= 'containment' | otherlv_2= 'cross_reference' ) ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_typeRef_5_0= rulePathNameCS ) ) ( (lv_multiplicity_6_0= ruleMultiplicityCS ) )? otherlv_7= ';' )
            {
            // InternalMiniOCLCS.g:457:2: ( (otherlv_0= 'attribute' | otherlv_1= 'containment' | otherlv_2= 'cross_reference' ) ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_typeRef_5_0= rulePathNameCS ) ) ( (lv_multiplicity_6_0= ruleMultiplicityCS ) )? otherlv_7= ';' )
            // InternalMiniOCLCS.g:458:3: (otherlv_0= 'attribute' | otherlv_1= 'containment' | otherlv_2= 'cross_reference' ) ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_typeRef_5_0= rulePathNameCS ) ) ( (lv_multiplicity_6_0= ruleMultiplicityCS ) )? otherlv_7= ';'
            {
            // InternalMiniOCLCS.g:458:3: (otherlv_0= 'attribute' | otherlv_1= 'containment' | otherlv_2= 'cross_reference' )
            int alt6=3;
            switch ( input.LA(1) ) {
            case 19:
                {
                alt6=1;
                }
                break;
            case 20:
                {
                alt6=2;
                }
                break;
            case 21:
                {
                alt6=3;
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
                    // InternalMiniOCLCS.g:459:4: otherlv_0= 'attribute'
                    {
                    otherlv_0=(Token)match(input,19,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_0, grammarAccess.getPropertyCSAccess().getAttributeKeyword_0_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalMiniOCLCS.g:464:4: otherlv_1= 'containment'
                    {
                    otherlv_1=(Token)match(input,20,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getPropertyCSAccess().getContainmentKeyword_0_1());
                      			
                    }

                    }
                    break;
                case 3 :
                    // InternalMiniOCLCS.g:469:4: otherlv_2= 'cross_reference'
                    {
                    otherlv_2=(Token)match(input,21,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getPropertyCSAccess().getCross_referenceKeyword_0_2());
                      			
                    }

                    }
                    break;

            }

            // InternalMiniOCLCS.g:474:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalMiniOCLCS.g:475:4: (lv_name_3_0= RULE_ID )
            {
            // InternalMiniOCLCS.g:475:4: (lv_name_3_0= RULE_ID )
            // InternalMiniOCLCS.g:476:5: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_3_0, grammarAccess.getPropertyCSAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getPropertyCSRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_3_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            otherlv_4=(Token)match(input,17,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getPropertyCSAccess().getColonKeyword_2());
              		
            }
            // InternalMiniOCLCS.g:496:3: ( (lv_typeRef_5_0= rulePathNameCS ) )
            // InternalMiniOCLCS.g:497:4: (lv_typeRef_5_0= rulePathNameCS )
            {
            // InternalMiniOCLCS.g:497:4: (lv_typeRef_5_0= rulePathNameCS )
            // InternalMiniOCLCS.g:498:5: lv_typeRef_5_0= rulePathNameCS
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPropertyCSAccess().getTypeRefPathNameCSParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_12);
            lv_typeRef_5_0=rulePathNameCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getPropertyCSRule());
              					}
              					set(
              						current,
              						"typeRef",
              						lv_typeRef_5_0,
              						"org.eclipse.qvtd.doc.MiniOCLCS.PathNameCS");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalMiniOCLCS.g:515:3: ( (lv_multiplicity_6_0= ruleMultiplicityCS ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==22) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalMiniOCLCS.g:516:4: (lv_multiplicity_6_0= ruleMultiplicityCS )
                    {
                    // InternalMiniOCLCS.g:516:4: (lv_multiplicity_6_0= ruleMultiplicityCS )
                    // InternalMiniOCLCS.g:517:5: lv_multiplicity_6_0= ruleMultiplicityCS
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getPropertyCSAccess().getMultiplicityMultiplicityCSParserRuleCall_4_0());
                      				
                    }
                    pushFollow(FOLLOW_11);
                    lv_multiplicity_6_0=ruleMultiplicityCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getPropertyCSRule());
                      					}
                      					set(
                      						current,
                      						"multiplicity",
                      						lv_multiplicity_6_0,
                      						"org.eclipse.qvtd.doc.MiniOCLCS.MultiplicityCS");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,18,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_7, grammarAccess.getPropertyCSAccess().getSemicolonKeyword_5());
              		
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
    // $ANTLR end "rulePropertyCS"


    // $ANTLR start "entryRuleMultiplicityCS"
    // InternalMiniOCLCS.g:542:1: entryRuleMultiplicityCS returns [EObject current=null] : iv_ruleMultiplicityCS= ruleMultiplicityCS EOF ;
    public final EObject entryRuleMultiplicityCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicityCS = null;


        try {
            // InternalMiniOCLCS.g:542:55: (iv_ruleMultiplicityCS= ruleMultiplicityCS EOF )
            // InternalMiniOCLCS.g:543:2: iv_ruleMultiplicityCS= ruleMultiplicityCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicityCSRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMultiplicityCS=ruleMultiplicityCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicityCS; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalMiniOCLCS.g:549:1: ruleMultiplicityCS returns [EObject current=null] : (otherlv_0= '[' ( ( (lv_opt_1_0= '?' ) ) | ( (lv_mult_2_0= '*' ) ) | ( ( (lv_lower_3_0= RULE_INT ) ) otherlv_4= '..' ( ( (lv_upperInt_5_0= RULE_INT ) ) | ( (lv_upperMult_6_0= '*' ) ) ) ) ) otherlv_7= ']' ) ;
    public final EObject ruleMultiplicityCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_opt_1_0=null;
        Token lv_mult_2_0=null;
        Token lv_lower_3_0=null;
        Token otherlv_4=null;
        Token lv_upperInt_5_0=null;
        Token lv_upperMult_6_0=null;
        Token otherlv_7=null;


        	enterRule();

        try {
            // InternalMiniOCLCS.g:555:2: ( (otherlv_0= '[' ( ( (lv_opt_1_0= '?' ) ) | ( (lv_mult_2_0= '*' ) ) | ( ( (lv_lower_3_0= RULE_INT ) ) otherlv_4= '..' ( ( (lv_upperInt_5_0= RULE_INT ) ) | ( (lv_upperMult_6_0= '*' ) ) ) ) ) otherlv_7= ']' ) )
            // InternalMiniOCLCS.g:556:2: (otherlv_0= '[' ( ( (lv_opt_1_0= '?' ) ) | ( (lv_mult_2_0= '*' ) ) | ( ( (lv_lower_3_0= RULE_INT ) ) otherlv_4= '..' ( ( (lv_upperInt_5_0= RULE_INT ) ) | ( (lv_upperMult_6_0= '*' ) ) ) ) ) otherlv_7= ']' )
            {
            // InternalMiniOCLCS.g:556:2: (otherlv_0= '[' ( ( (lv_opt_1_0= '?' ) ) | ( (lv_mult_2_0= '*' ) ) | ( ( (lv_lower_3_0= RULE_INT ) ) otherlv_4= '..' ( ( (lv_upperInt_5_0= RULE_INT ) ) | ( (lv_upperMult_6_0= '*' ) ) ) ) ) otherlv_7= ']' )
            // InternalMiniOCLCS.g:557:3: otherlv_0= '[' ( ( (lv_opt_1_0= '?' ) ) | ( (lv_mult_2_0= '*' ) ) | ( ( (lv_lower_3_0= RULE_INT ) ) otherlv_4= '..' ( ( (lv_upperInt_5_0= RULE_INT ) ) | ( (lv_upperMult_6_0= '*' ) ) ) ) ) otherlv_7= ']'
            {
            otherlv_0=(Token)match(input,22,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getMultiplicityCSAccess().getLeftSquareBracketKeyword_0());
              		
            }
            // InternalMiniOCLCS.g:561:3: ( ( (lv_opt_1_0= '?' ) ) | ( (lv_mult_2_0= '*' ) ) | ( ( (lv_lower_3_0= RULE_INT ) ) otherlv_4= '..' ( ( (lv_upperInt_5_0= RULE_INT ) ) | ( (lv_upperMult_6_0= '*' ) ) ) ) )
            int alt9=3;
            switch ( input.LA(1) ) {
            case 23:
                {
                alt9=1;
                }
                break;
            case 24:
                {
                alt9=2;
                }
                break;
            case RULE_INT:
                {
                alt9=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // InternalMiniOCLCS.g:562:4: ( (lv_opt_1_0= '?' ) )
                    {
                    // InternalMiniOCLCS.g:562:4: ( (lv_opt_1_0= '?' ) )
                    // InternalMiniOCLCS.g:563:5: (lv_opt_1_0= '?' )
                    {
                    // InternalMiniOCLCS.g:563:5: (lv_opt_1_0= '?' )
                    // InternalMiniOCLCS.g:564:6: lv_opt_1_0= '?'
                    {
                    lv_opt_1_0=(Token)match(input,23,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_opt_1_0, grammarAccess.getMultiplicityCSAccess().getOptQuestionMarkKeyword_1_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getMultiplicityCSRule());
                      						}
                      						setWithLastConsumed(current, "opt", true, "?");
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMiniOCLCS.g:577:4: ( (lv_mult_2_0= '*' ) )
                    {
                    // InternalMiniOCLCS.g:577:4: ( (lv_mult_2_0= '*' ) )
                    // InternalMiniOCLCS.g:578:5: (lv_mult_2_0= '*' )
                    {
                    // InternalMiniOCLCS.g:578:5: (lv_mult_2_0= '*' )
                    // InternalMiniOCLCS.g:579:6: lv_mult_2_0= '*'
                    {
                    lv_mult_2_0=(Token)match(input,24,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_mult_2_0, grammarAccess.getMultiplicityCSAccess().getMultAsteriskKeyword_1_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getMultiplicityCSRule());
                      						}
                      						setWithLastConsumed(current, "mult", true, "*");
                      					
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalMiniOCLCS.g:592:4: ( ( (lv_lower_3_0= RULE_INT ) ) otherlv_4= '..' ( ( (lv_upperInt_5_0= RULE_INT ) ) | ( (lv_upperMult_6_0= '*' ) ) ) )
                    {
                    // InternalMiniOCLCS.g:592:4: ( ( (lv_lower_3_0= RULE_INT ) ) otherlv_4= '..' ( ( (lv_upperInt_5_0= RULE_INT ) ) | ( (lv_upperMult_6_0= '*' ) ) ) )
                    // InternalMiniOCLCS.g:593:5: ( (lv_lower_3_0= RULE_INT ) ) otherlv_4= '..' ( ( (lv_upperInt_5_0= RULE_INT ) ) | ( (lv_upperMult_6_0= '*' ) ) )
                    {
                    // InternalMiniOCLCS.g:593:5: ( (lv_lower_3_0= RULE_INT ) )
                    // InternalMiniOCLCS.g:594:6: (lv_lower_3_0= RULE_INT )
                    {
                    // InternalMiniOCLCS.g:594:6: (lv_lower_3_0= RULE_INT )
                    // InternalMiniOCLCS.g:595:7: lv_lower_3_0= RULE_INT
                    {
                    lv_lower_3_0=(Token)match(input,RULE_INT,FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(lv_lower_3_0, grammarAccess.getMultiplicityCSAccess().getLowerINTTerminalRuleCall_1_2_0_0());
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getMultiplicityCSRule());
                      							}
                      							setWithLastConsumed(
                      								current,
                      								"lower",
                      								lv_lower_3_0,
                      								"org.eclipse.xtext.common.Terminals.INT");
                      						
                    }

                    }


                    }

                    otherlv_4=(Token)match(input,25,FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_4, grammarAccess.getMultiplicityCSAccess().getFullStopFullStopKeyword_1_2_1());
                      				
                    }
                    // InternalMiniOCLCS.g:615:5: ( ( (lv_upperInt_5_0= RULE_INT ) ) | ( (lv_upperMult_6_0= '*' ) ) )
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==RULE_INT) ) {
                        alt8=1;
                    }
                    else if ( (LA8_0==24) ) {
                        alt8=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 8, 0, input);

                        throw nvae;
                    }
                    switch (alt8) {
                        case 1 :
                            // InternalMiniOCLCS.g:616:6: ( (lv_upperInt_5_0= RULE_INT ) )
                            {
                            // InternalMiniOCLCS.g:616:6: ( (lv_upperInt_5_0= RULE_INT ) )
                            // InternalMiniOCLCS.g:617:7: (lv_upperInt_5_0= RULE_INT )
                            {
                            // InternalMiniOCLCS.g:617:7: (lv_upperInt_5_0= RULE_INT )
                            // InternalMiniOCLCS.g:618:8: lv_upperInt_5_0= RULE_INT
                            {
                            lv_upperInt_5_0=(Token)match(input,RULE_INT,FOLLOW_14); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								newLeafNode(lv_upperInt_5_0, grammarAccess.getMultiplicityCSAccess().getUpperIntINTTerminalRuleCall_1_2_2_0_0());
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElement(grammarAccess.getMultiplicityCSRule());
                              								}
                              								setWithLastConsumed(
                              									current,
                              									"upperInt",
                              									lv_upperInt_5_0,
                              									"org.eclipse.xtext.common.Terminals.INT");
                              							
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalMiniOCLCS.g:635:6: ( (lv_upperMult_6_0= '*' ) )
                            {
                            // InternalMiniOCLCS.g:635:6: ( (lv_upperMult_6_0= '*' ) )
                            // InternalMiniOCLCS.g:636:7: (lv_upperMult_6_0= '*' )
                            {
                            // InternalMiniOCLCS.g:636:7: (lv_upperMult_6_0= '*' )
                            // InternalMiniOCLCS.g:637:8: lv_upperMult_6_0= '*'
                            {
                            lv_upperMult_6_0=(Token)match(input,24,FOLLOW_14); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								newLeafNode(lv_upperMult_6_0, grammarAccess.getMultiplicityCSAccess().getUpperMultAsteriskKeyword_1_2_2_1_0());
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElement(grammarAccess.getMultiplicityCSRule());
                              								}
                              								setWithLastConsumed(current, "upperMult", true, "*");
                              							
                            }

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,26,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_7, grammarAccess.getMultiplicityCSAccess().getRightSquareBracketKeyword_2());
              		
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


    // $ANTLR start "entryRuleOperationCS"
    // InternalMiniOCLCS.g:660:1: entryRuleOperationCS returns [EObject current=null] : iv_ruleOperationCS= ruleOperationCS EOF ;
    public final EObject entryRuleOperationCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationCS = null;


        try {
            // InternalMiniOCLCS.g:660:52: (iv_ruleOperationCS= ruleOperationCS EOF )
            // InternalMiniOCLCS.g:661:2: iv_ruleOperationCS= ruleOperationCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOperationCSRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOperationCS=ruleOperationCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOperationCS; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalMiniOCLCS.g:667:1: ruleOperationCS returns [EObject current=null] : (otherlv_0= 'op' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_params_3_0= ruleParameterCS ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleParameterCS ) ) )* )? otherlv_6= ')' otherlv_7= ':' ( (lv_resultRef_8_0= rulePathNameCS ) ) otherlv_9= '=' ( (lv_body_10_0= ruleExpCS ) ) otherlv_11= ';' ) ;
    public final EObject ruleOperationCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        EObject lv_params_3_0 = null;

        EObject lv_params_5_0 = null;

        EObject lv_resultRef_8_0 = null;

        EObject lv_body_10_0 = null;



        	enterRule();

        try {
            // InternalMiniOCLCS.g:673:2: ( (otherlv_0= 'op' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_params_3_0= ruleParameterCS ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleParameterCS ) ) )* )? otherlv_6= ')' otherlv_7= ':' ( (lv_resultRef_8_0= rulePathNameCS ) ) otherlv_9= '=' ( (lv_body_10_0= ruleExpCS ) ) otherlv_11= ';' ) )
            // InternalMiniOCLCS.g:674:2: (otherlv_0= 'op' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_params_3_0= ruleParameterCS ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleParameterCS ) ) )* )? otherlv_6= ')' otherlv_7= ':' ( (lv_resultRef_8_0= rulePathNameCS ) ) otherlv_9= '=' ( (lv_body_10_0= ruleExpCS ) ) otherlv_11= ';' )
            {
            // InternalMiniOCLCS.g:674:2: (otherlv_0= 'op' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_params_3_0= ruleParameterCS ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleParameterCS ) ) )* )? otherlv_6= ')' otherlv_7= ':' ( (lv_resultRef_8_0= rulePathNameCS ) ) otherlv_9= '=' ( (lv_body_10_0= ruleExpCS ) ) otherlv_11= ';' )
            // InternalMiniOCLCS.g:675:3: otherlv_0= 'op' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_params_3_0= ruleParameterCS ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleParameterCS ) ) )* )? otherlv_6= ')' otherlv_7= ':' ( (lv_resultRef_8_0= rulePathNameCS ) ) otherlv_9= '=' ( (lv_body_10_0= ruleExpCS ) ) otherlv_11= ';'
            {
            otherlv_0=(Token)match(input,27,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getOperationCSAccess().getOpKeyword_0());
              		
            }
            // InternalMiniOCLCS.g:679:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMiniOCLCS.g:680:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMiniOCLCS.g:680:4: (lv_name_1_0= RULE_ID )
            // InternalMiniOCLCS.g:681:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getOperationCSAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getOperationCSRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,28,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getOperationCSAccess().getLeftParenthesisKeyword_2());
              		
            }
            // InternalMiniOCLCS.g:701:3: ( ( (lv_params_3_0= ruleParameterCS ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleParameterCS ) ) )* )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_ID) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalMiniOCLCS.g:702:4: ( (lv_params_3_0= ruleParameterCS ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleParameterCS ) ) )*
                    {
                    // InternalMiniOCLCS.g:702:4: ( (lv_params_3_0= ruleParameterCS ) )
                    // InternalMiniOCLCS.g:703:5: (lv_params_3_0= ruleParameterCS )
                    {
                    // InternalMiniOCLCS.g:703:5: (lv_params_3_0= ruleParameterCS )
                    // InternalMiniOCLCS.g:704:6: lv_params_3_0= ruleParameterCS
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getOperationCSAccess().getParamsParameterCSParserRuleCall_3_0_0());
                      					
                    }
                    pushFollow(FOLLOW_19);
                    lv_params_3_0=ruleParameterCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getOperationCSRule());
                      						}
                      						add(
                      							current,
                      							"params",
                      							lv_params_3_0,
                      							"org.eclipse.qvtd.doc.MiniOCLCS.ParameterCS");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalMiniOCLCS.g:721:4: (otherlv_4= ',' ( (lv_params_5_0= ruleParameterCS ) ) )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==29) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // InternalMiniOCLCS.g:722:5: otherlv_4= ',' ( (lv_params_5_0= ruleParameterCS ) )
                    	    {
                    	    otherlv_4=(Token)match(input,29,FOLLOW_4); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_4, grammarAccess.getOperationCSAccess().getCommaKeyword_3_1_0());
                    	      				
                    	    }
                    	    // InternalMiniOCLCS.g:726:5: ( (lv_params_5_0= ruleParameterCS ) )
                    	    // InternalMiniOCLCS.g:727:6: (lv_params_5_0= ruleParameterCS )
                    	    {
                    	    // InternalMiniOCLCS.g:727:6: (lv_params_5_0= ruleParameterCS )
                    	    // InternalMiniOCLCS.g:728:7: lv_params_5_0= ruleParameterCS
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getOperationCSAccess().getParamsParameterCSParserRuleCall_3_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_19);
                    	    lv_params_5_0=ruleParameterCS();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getOperationCSRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"params",
                    	      								lv_params_5_0,
                    	      								"org.eclipse.qvtd.doc.MiniOCLCS.ParameterCS");
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

            otherlv_6=(Token)match(input,30,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getOperationCSAccess().getRightParenthesisKeyword_4());
              		
            }
            otherlv_7=(Token)match(input,17,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_7, grammarAccess.getOperationCSAccess().getColonKeyword_5());
              		
            }
            // InternalMiniOCLCS.g:755:3: ( (lv_resultRef_8_0= rulePathNameCS ) )
            // InternalMiniOCLCS.g:756:4: (lv_resultRef_8_0= rulePathNameCS )
            {
            // InternalMiniOCLCS.g:756:4: (lv_resultRef_8_0= rulePathNameCS )
            // InternalMiniOCLCS.g:757:5: lv_resultRef_8_0= rulePathNameCS
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getOperationCSAccess().getResultRefPathNameCSParserRuleCall_6_0());
              				
            }
            pushFollow(FOLLOW_20);
            lv_resultRef_8_0=rulePathNameCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getOperationCSRule());
              					}
              					set(
              						current,
              						"resultRef",
              						lv_resultRef_8_0,
              						"org.eclipse.qvtd.doc.MiniOCLCS.PathNameCS");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_9=(Token)match(input,31,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_9, grammarAccess.getOperationCSAccess().getEqualsSignKeyword_7());
              		
            }
            // InternalMiniOCLCS.g:778:3: ( (lv_body_10_0= ruleExpCS ) )
            // InternalMiniOCLCS.g:779:4: (lv_body_10_0= ruleExpCS )
            {
            // InternalMiniOCLCS.g:779:4: (lv_body_10_0= ruleExpCS )
            // InternalMiniOCLCS.g:780:5: lv_body_10_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getOperationCSAccess().getBodyExpCSParserRuleCall_8_0());
              				
            }
            pushFollow(FOLLOW_11);
            lv_body_10_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getOperationCSRule());
              					}
              					set(
              						current,
              						"body",
              						lv_body_10_0,
              						"org.eclipse.qvtd.doc.MiniOCLCS.ExpCS");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_11=(Token)match(input,18,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_11, grammarAccess.getOperationCSAccess().getSemicolonKeyword_9());
              		
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
    // InternalMiniOCLCS.g:805:1: entryRuleParameterCS returns [EObject current=null] : iv_ruleParameterCS= ruleParameterCS EOF ;
    public final EObject entryRuleParameterCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterCS = null;


        try {
            // InternalMiniOCLCS.g:805:52: (iv_ruleParameterCS= ruleParameterCS EOF )
            // InternalMiniOCLCS.g:806:2: iv_ruleParameterCS= ruleParameterCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameterCSRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleParameterCS=ruleParameterCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameterCS; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalMiniOCLCS.g:812:1: ruleParameterCS returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_typeRef_2_0= rulePathNameCS ) ) ) ;
    public final EObject ruleParameterCS() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_typeRef_2_0 = null;



        	enterRule();

        try {
            // InternalMiniOCLCS.g:818:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_typeRef_2_0= rulePathNameCS ) ) ) )
            // InternalMiniOCLCS.g:819:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_typeRef_2_0= rulePathNameCS ) ) )
            {
            // InternalMiniOCLCS.g:819:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_typeRef_2_0= rulePathNameCS ) ) )
            // InternalMiniOCLCS.g:820:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_typeRef_2_0= rulePathNameCS ) )
            {
            // InternalMiniOCLCS.g:820:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalMiniOCLCS.g:821:4: (lv_name_0_0= RULE_ID )
            {
            // InternalMiniOCLCS.g:821:4: (lv_name_0_0= RULE_ID )
            // InternalMiniOCLCS.g:822:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_0_0, grammarAccess.getParameterCSAccess().getNameIDTerminalRuleCall_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getParameterCSRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_0_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            otherlv_1=(Token)match(input,17,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getParameterCSAccess().getColonKeyword_1());
              		
            }
            // InternalMiniOCLCS.g:842:3: ( (lv_typeRef_2_0= rulePathNameCS ) )
            // InternalMiniOCLCS.g:843:4: (lv_typeRef_2_0= rulePathNameCS )
            {
            // InternalMiniOCLCS.g:843:4: (lv_typeRef_2_0= rulePathNameCS )
            // InternalMiniOCLCS.g:844:5: lv_typeRef_2_0= rulePathNameCS
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getParameterCSAccess().getTypeRefPathNameCSParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_typeRef_2_0=rulePathNameCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getParameterCSRule());
              					}
              					set(
              						current,
              						"typeRef",
              						lv_typeRef_2_0,
              						"org.eclipse.qvtd.doc.MiniOCLCS.PathNameCS");
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
    // $ANTLR end "ruleParameterCS"


    // $ANTLR start "entryRuleConstraintsDefCS"
    // InternalMiniOCLCS.g:865:1: entryRuleConstraintsDefCS returns [EObject current=null] : iv_ruleConstraintsDefCS= ruleConstraintsDefCS EOF ;
    public final EObject entryRuleConstraintsDefCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstraintsDefCS = null;


        try {
            // InternalMiniOCLCS.g:865:57: (iv_ruleConstraintsDefCS= ruleConstraintsDefCS EOF )
            // InternalMiniOCLCS.g:866:2: iv_ruleConstraintsDefCS= ruleConstraintsDefCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstraintsDefCSRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleConstraintsDefCS=ruleConstraintsDefCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConstraintsDefCS; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConstraintsDefCS"


    // $ANTLR start "ruleConstraintsDefCS"
    // InternalMiniOCLCS.g:872:1: ruleConstraintsDefCS returns [EObject current=null] : (otherlv_0= 'context' ( (lv_typeRef_1_0= rulePathNameCS ) ) otherlv_2= '{' ( (lv_invariants_3_0= ruleInvariantCS ) )* otherlv_4= '}' ) ;
    public final EObject ruleConstraintsDefCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_typeRef_1_0 = null;

        EObject lv_invariants_3_0 = null;



        	enterRule();

        try {
            // InternalMiniOCLCS.g:878:2: ( (otherlv_0= 'context' ( (lv_typeRef_1_0= rulePathNameCS ) ) otherlv_2= '{' ( (lv_invariants_3_0= ruleInvariantCS ) )* otherlv_4= '}' ) )
            // InternalMiniOCLCS.g:879:2: (otherlv_0= 'context' ( (lv_typeRef_1_0= rulePathNameCS ) ) otherlv_2= '{' ( (lv_invariants_3_0= ruleInvariantCS ) )* otherlv_4= '}' )
            {
            // InternalMiniOCLCS.g:879:2: (otherlv_0= 'context' ( (lv_typeRef_1_0= rulePathNameCS ) ) otherlv_2= '{' ( (lv_invariants_3_0= ruleInvariantCS ) )* otherlv_4= '}' )
            // InternalMiniOCLCS.g:880:3: otherlv_0= 'context' ( (lv_typeRef_1_0= rulePathNameCS ) ) otherlv_2= '{' ( (lv_invariants_3_0= ruleInvariantCS ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,32,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getConstraintsDefCSAccess().getContextKeyword_0());
              		
            }
            // InternalMiniOCLCS.g:884:3: ( (lv_typeRef_1_0= rulePathNameCS ) )
            // InternalMiniOCLCS.g:885:4: (lv_typeRef_1_0= rulePathNameCS )
            {
            // InternalMiniOCLCS.g:885:4: (lv_typeRef_1_0= rulePathNameCS )
            // InternalMiniOCLCS.g:886:5: lv_typeRef_1_0= rulePathNameCS
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getConstraintsDefCSAccess().getTypeRefPathNameCSParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_5);
            lv_typeRef_1_0=rulePathNameCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getConstraintsDefCSRule());
              					}
              					set(
              						current,
              						"typeRef",
              						lv_typeRef_1_0,
              						"org.eclipse.qvtd.doc.MiniOCLCS.PathNameCS");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getConstraintsDefCSAccess().getLeftCurlyBracketKeyword_2());
              		
            }
            // InternalMiniOCLCS.g:907:3: ( (lv_invariants_3_0= ruleInvariantCS ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==33) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalMiniOCLCS.g:908:4: (lv_invariants_3_0= ruleInvariantCS )
            	    {
            	    // InternalMiniOCLCS.g:908:4: (lv_invariants_3_0= ruleInvariantCS )
            	    // InternalMiniOCLCS.g:909:5: lv_invariants_3_0= ruleInvariantCS
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getConstraintsDefCSAccess().getInvariantsInvariantCSParserRuleCall_3_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_22);
            	    lv_invariants_3_0=ruleInvariantCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getConstraintsDefCSRule());
            	      					}
            	      					add(
            	      						current,
            	      						"invariants",
            	      						lv_invariants_3_0,
            	      						"org.eclipse.qvtd.doc.MiniOCLCS.InvariantCS");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            otherlv_4=(Token)match(input,13,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getConstraintsDefCSAccess().getRightCurlyBracketKeyword_4());
              		
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
    // $ANTLR end "ruleConstraintsDefCS"


    // $ANTLR start "entryRuleInvariantCS"
    // InternalMiniOCLCS.g:934:1: entryRuleInvariantCS returns [EObject current=null] : iv_ruleInvariantCS= ruleInvariantCS EOF ;
    public final EObject entryRuleInvariantCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInvariantCS = null;


        try {
            // InternalMiniOCLCS.g:934:52: (iv_ruleInvariantCS= ruleInvariantCS EOF )
            // InternalMiniOCLCS.g:935:2: iv_ruleInvariantCS= ruleInvariantCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInvariantCSRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleInvariantCS=ruleInvariantCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInvariantCS; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInvariantCS"


    // $ANTLR start "ruleInvariantCS"
    // InternalMiniOCLCS.g:941:1: ruleInvariantCS returns [EObject current=null] : (otherlv_0= 'inv' otherlv_1= ':' ( (lv_exp_2_0= ruleExpCS ) ) otherlv_3= ';' ) ;
    public final EObject ruleInvariantCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_exp_2_0 = null;



        	enterRule();

        try {
            // InternalMiniOCLCS.g:947:2: ( (otherlv_0= 'inv' otherlv_1= ':' ( (lv_exp_2_0= ruleExpCS ) ) otherlv_3= ';' ) )
            // InternalMiniOCLCS.g:948:2: (otherlv_0= 'inv' otherlv_1= ':' ( (lv_exp_2_0= ruleExpCS ) ) otherlv_3= ';' )
            {
            // InternalMiniOCLCS.g:948:2: (otherlv_0= 'inv' otherlv_1= ':' ( (lv_exp_2_0= ruleExpCS ) ) otherlv_3= ';' )
            // InternalMiniOCLCS.g:949:3: otherlv_0= 'inv' otherlv_1= ':' ( (lv_exp_2_0= ruleExpCS ) ) otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,33,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getInvariantCSAccess().getInvKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,17,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getInvariantCSAccess().getColonKeyword_1());
              		
            }
            // InternalMiniOCLCS.g:957:3: ( (lv_exp_2_0= ruleExpCS ) )
            // InternalMiniOCLCS.g:958:4: (lv_exp_2_0= ruleExpCS )
            {
            // InternalMiniOCLCS.g:958:4: (lv_exp_2_0= ruleExpCS )
            // InternalMiniOCLCS.g:959:5: lv_exp_2_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getInvariantCSAccess().getExpExpCSParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_11);
            lv_exp_2_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getInvariantCSRule());
              					}
              					set(
              						current,
              						"exp",
              						lv_exp_2_0,
              						"org.eclipse.qvtd.doc.MiniOCLCS.ExpCS");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,18,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getInvariantCSAccess().getSemicolonKeyword_3());
              		
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
    // $ANTLR end "ruleInvariantCS"


    // $ANTLR start "entryRuleExpCS"
    // InternalMiniOCLCS.g:984:1: entryRuleExpCS returns [EObject current=null] : iv_ruleExpCS= ruleExpCS EOF ;
    public final EObject entryRuleExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpCS = null;


        try {
            // InternalMiniOCLCS.g:984:46: (iv_ruleExpCS= ruleExpCS EOF )
            // InternalMiniOCLCS.g:985:2: iv_ruleExpCS= ruleExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpCSRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExpCS=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpCS; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalMiniOCLCS.g:991:1: ruleExpCS returns [EObject current=null] : this_LogicExpCS_0= ruleLogicExpCS ;
    public final EObject ruleExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_LogicExpCS_0 = null;



        	enterRule();

        try {
            // InternalMiniOCLCS.g:997:2: (this_LogicExpCS_0= ruleLogicExpCS )
            // InternalMiniOCLCS.g:998:2: this_LogicExpCS_0= ruleLogicExpCS
            {
            if ( state.backtracking==0 ) {

              		/* */
              	
            }
            if ( state.backtracking==0 ) {

              		newCompositeNode(grammarAccess.getExpCSAccess().getLogicExpCSParserRuleCall());
              	
            }
            pushFollow(FOLLOW_2);
            this_LogicExpCS_0=ruleLogicExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current = this_LogicExpCS_0;
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
    // $ANTLR end "ruleExpCS"


    // $ANTLR start "entryRuleLogicExpCS"
    // InternalMiniOCLCS.g:1012:1: entryRuleLogicExpCS returns [EObject current=null] : iv_ruleLogicExpCS= ruleLogicExpCS EOF ;
    public final EObject entryRuleLogicExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicExpCS = null;


        try {
            // InternalMiniOCLCS.g:1012:51: (iv_ruleLogicExpCS= ruleLogicExpCS EOF )
            // InternalMiniOCLCS.g:1013:2: iv_ruleLogicExpCS= ruleLogicExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicExpCSRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLogicExpCS=ruleLogicExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicExpCS; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLogicExpCS"


    // $ANTLR start "ruleLogicExpCS"
    // InternalMiniOCLCS.g:1019:1: ruleLogicExpCS returns [EObject current=null] : (this_CallExpCS_0= ruleCallExpCS ( () ( ( (lv_op_2_1= '=' | lv_op_2_2= '<>' ) ) ) ( (lv_right_3_0= ruleCallExpCS ) ) )* ) ;
    public final EObject ruleLogicExpCS() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_CallExpCS_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalMiniOCLCS.g:1025:2: ( (this_CallExpCS_0= ruleCallExpCS ( () ( ( (lv_op_2_1= '=' | lv_op_2_2= '<>' ) ) ) ( (lv_right_3_0= ruleCallExpCS ) ) )* ) )
            // InternalMiniOCLCS.g:1026:2: (this_CallExpCS_0= ruleCallExpCS ( () ( ( (lv_op_2_1= '=' | lv_op_2_2= '<>' ) ) ) ( (lv_right_3_0= ruleCallExpCS ) ) )* )
            {
            // InternalMiniOCLCS.g:1026:2: (this_CallExpCS_0= ruleCallExpCS ( () ( ( (lv_op_2_1= '=' | lv_op_2_2= '<>' ) ) ) ( (lv_right_3_0= ruleCallExpCS ) ) )* )
            // InternalMiniOCLCS.g:1027:3: this_CallExpCS_0= ruleCallExpCS ( () ( ( (lv_op_2_1= '=' | lv_op_2_2= '<>' ) ) ) ( (lv_right_3_0= ruleCallExpCS ) ) )*
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getLogicExpCSAccess().getCallExpCSParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_23);
            this_CallExpCS_0=ruleCallExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_CallExpCS_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalMiniOCLCS.g:1038:3: ( () ( ( (lv_op_2_1= '=' | lv_op_2_2= '<>' ) ) ) ( (lv_right_3_0= ruleCallExpCS ) ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==31) ) {
                    int LA14_2 = input.LA(2);

                    if ( (synpred19_InternalMiniOCLCS()) ) {
                        alt14=1;
                    }


                }
                else if ( (LA14_0==34) ) {
                    int LA14_3 = input.LA(2);

                    if ( (synpred19_InternalMiniOCLCS()) ) {
                        alt14=1;
                    }


                }


                switch (alt14) {
            	case 1 :
            	    // InternalMiniOCLCS.g:1039:4: () ( ( (lv_op_2_1= '=' | lv_op_2_2= '<>' ) ) ) ( (lv_right_3_0= ruleCallExpCS ) )
            	    {
            	    // InternalMiniOCLCS.g:1039:4: ()
            	    // InternalMiniOCLCS.g:1040:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					/* */
            	      				
            	    }
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getLogicExpCSAccess().getLogicExpCSLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalMiniOCLCS.g:1049:4: ( ( (lv_op_2_1= '=' | lv_op_2_2= '<>' ) ) )
            	    // InternalMiniOCLCS.g:1050:5: ( (lv_op_2_1= '=' | lv_op_2_2= '<>' ) )
            	    {
            	    // InternalMiniOCLCS.g:1050:5: ( (lv_op_2_1= '=' | lv_op_2_2= '<>' ) )
            	    // InternalMiniOCLCS.g:1051:6: (lv_op_2_1= '=' | lv_op_2_2= '<>' )
            	    {
            	    // InternalMiniOCLCS.g:1051:6: (lv_op_2_1= '=' | lv_op_2_2= '<>' )
            	    int alt13=2;
            	    int LA13_0 = input.LA(1);

            	    if ( (LA13_0==31) ) {
            	        alt13=1;
            	    }
            	    else if ( (LA13_0==34) ) {
            	        alt13=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 13, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt13) {
            	        case 1 :
            	            // InternalMiniOCLCS.g:1052:7: lv_op_2_1= '='
            	            {
            	            lv_op_2_1=(Token)match(input,31,FOLLOW_21); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_op_2_1, grammarAccess.getLogicExpCSAccess().getOpEqualsSignKeyword_1_1_0_0());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getLogicExpCSRule());
            	              							}
            	              							setWithLastConsumed(current, "op", lv_op_2_1, null);
            	              						
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // InternalMiniOCLCS.g:1063:7: lv_op_2_2= '<>'
            	            {
            	            lv_op_2_2=(Token)match(input,34,FOLLOW_21); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_op_2_2, grammarAccess.getLogicExpCSAccess().getOpLessThanSignGreaterThanSignKeyword_1_1_0_1());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getLogicExpCSRule());
            	              							}
            	              							setWithLastConsumed(current, "op", lv_op_2_2, null);
            	              						
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalMiniOCLCS.g:1076:4: ( (lv_right_3_0= ruleCallExpCS ) )
            	    // InternalMiniOCLCS.g:1077:5: (lv_right_3_0= ruleCallExpCS )
            	    {
            	    // InternalMiniOCLCS.g:1077:5: (lv_right_3_0= ruleCallExpCS )
            	    // InternalMiniOCLCS.g:1078:6: lv_right_3_0= ruleCallExpCS
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getLogicExpCSAccess().getRightCallExpCSParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_23);
            	    lv_right_3_0=ruleCallExpCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getLogicExpCSRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"org.eclipse.qvtd.doc.MiniOCLCS.CallExpCS");
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


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLogicExpCS"


    // $ANTLR start "entryRuleCallExpCS"
    // InternalMiniOCLCS.g:1100:1: entryRuleCallExpCS returns [EObject current=null] : iv_ruleCallExpCS= ruleCallExpCS EOF ;
    public final EObject entryRuleCallExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCallExpCS = null;


        try {
            // InternalMiniOCLCS.g:1100:50: (iv_ruleCallExpCS= ruleCallExpCS EOF )
            // InternalMiniOCLCS.g:1101:2: iv_ruleCallExpCS= ruleCallExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCallExpCSRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCallExpCS=ruleCallExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCallExpCS; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCallExpCS"


    // $ANTLR start "ruleCallExpCS"
    // InternalMiniOCLCS.g:1107:1: ruleCallExpCS returns [EObject current=null] : (this_PrimaryExpCS_0= rulePrimaryExpCS ( () ( ( (lv_op_2_1= '.' | lv_op_2_2= '->' ) ) ) ( (lv_navExp_3_0= ruleNavigationExpCS ) ) )* ) ;
    public final EObject ruleCallExpCS() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_PrimaryExpCS_0 = null;

        EObject lv_navExp_3_0 = null;



        	enterRule();

        try {
            // InternalMiniOCLCS.g:1113:2: ( (this_PrimaryExpCS_0= rulePrimaryExpCS ( () ( ( (lv_op_2_1= '.' | lv_op_2_2= '->' ) ) ) ( (lv_navExp_3_0= ruleNavigationExpCS ) ) )* ) )
            // InternalMiniOCLCS.g:1114:2: (this_PrimaryExpCS_0= rulePrimaryExpCS ( () ( ( (lv_op_2_1= '.' | lv_op_2_2= '->' ) ) ) ( (lv_navExp_3_0= ruleNavigationExpCS ) ) )* )
            {
            // InternalMiniOCLCS.g:1114:2: (this_PrimaryExpCS_0= rulePrimaryExpCS ( () ( ( (lv_op_2_1= '.' | lv_op_2_2= '->' ) ) ) ( (lv_navExp_3_0= ruleNavigationExpCS ) ) )* )
            // InternalMiniOCLCS.g:1115:3: this_PrimaryExpCS_0= rulePrimaryExpCS ( () ( ( (lv_op_2_1= '.' | lv_op_2_2= '->' ) ) ) ( (lv_navExp_3_0= ruleNavigationExpCS ) ) )*
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getCallExpCSAccess().getPrimaryExpCSParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_24);
            this_PrimaryExpCS_0=rulePrimaryExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_PrimaryExpCS_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalMiniOCLCS.g:1126:3: ( () ( ( (lv_op_2_1= '.' | lv_op_2_2= '->' ) ) ) ( (lv_navExp_3_0= ruleNavigationExpCS ) ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==35) ) {
                    int LA16_2 = input.LA(2);

                    if ( (synpred21_InternalMiniOCLCS()) ) {
                        alt16=1;
                    }


                }
                else if ( (LA16_0==36) ) {
                    int LA16_3 = input.LA(2);

                    if ( (synpred21_InternalMiniOCLCS()) ) {
                        alt16=1;
                    }


                }


                switch (alt16) {
            	case 1 :
            	    // InternalMiniOCLCS.g:1127:4: () ( ( (lv_op_2_1= '.' | lv_op_2_2= '->' ) ) ) ( (lv_navExp_3_0= ruleNavigationExpCS ) )
            	    {
            	    // InternalMiniOCLCS.g:1127:4: ()
            	    // InternalMiniOCLCS.g:1128:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					/* */
            	      				
            	    }
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getCallExpCSAccess().getCallExpCSSourceAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalMiniOCLCS.g:1137:4: ( ( (lv_op_2_1= '.' | lv_op_2_2= '->' ) ) )
            	    // InternalMiniOCLCS.g:1138:5: ( (lv_op_2_1= '.' | lv_op_2_2= '->' ) )
            	    {
            	    // InternalMiniOCLCS.g:1138:5: ( (lv_op_2_1= '.' | lv_op_2_2= '->' ) )
            	    // InternalMiniOCLCS.g:1139:6: (lv_op_2_1= '.' | lv_op_2_2= '->' )
            	    {
            	    // InternalMiniOCLCS.g:1139:6: (lv_op_2_1= '.' | lv_op_2_2= '->' )
            	    int alt15=2;
            	    int LA15_0 = input.LA(1);

            	    if ( (LA15_0==35) ) {
            	        alt15=1;
            	    }
            	    else if ( (LA15_0==36) ) {
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
            	            // InternalMiniOCLCS.g:1140:7: lv_op_2_1= '.'
            	            {
            	            lv_op_2_1=(Token)match(input,35,FOLLOW_25); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_op_2_1, grammarAccess.getCallExpCSAccess().getOpFullStopKeyword_1_1_0_0());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getCallExpCSRule());
            	              							}
            	              							setWithLastConsumed(current, "op", lv_op_2_1, null);
            	              						
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // InternalMiniOCLCS.g:1151:7: lv_op_2_2= '->'
            	            {
            	            lv_op_2_2=(Token)match(input,36,FOLLOW_25); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_op_2_2, grammarAccess.getCallExpCSAccess().getOpHyphenMinusGreaterThanSignKeyword_1_1_0_1());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getCallExpCSRule());
            	              							}
            	              							setWithLastConsumed(current, "op", lv_op_2_2, null);
            	              						
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalMiniOCLCS.g:1164:4: ( (lv_navExp_3_0= ruleNavigationExpCS ) )
            	    // InternalMiniOCLCS.g:1165:5: (lv_navExp_3_0= ruleNavigationExpCS )
            	    {
            	    // InternalMiniOCLCS.g:1165:5: (lv_navExp_3_0= ruleNavigationExpCS )
            	    // InternalMiniOCLCS.g:1166:6: lv_navExp_3_0= ruleNavigationExpCS
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getCallExpCSAccess().getNavExpNavigationExpCSParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_24);
            	    lv_navExp_3_0=ruleNavigationExpCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getCallExpCSRule());
            	      						}
            	      						set(
            	      							current,
            	      							"navExp",
            	      							lv_navExp_3_0,
            	      							"org.eclipse.qvtd.doc.MiniOCLCS.NavigationExpCS");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


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
    // $ANTLR end "ruleCallExpCS"


    // $ANTLR start "entryRulePrimaryExpCS"
    // InternalMiniOCLCS.g:1188:1: entryRulePrimaryExpCS returns [EObject current=null] : iv_rulePrimaryExpCS= rulePrimaryExpCS EOF ;
    public final EObject entryRulePrimaryExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpCS = null;


        try {
            // InternalMiniOCLCS.g:1188:53: (iv_rulePrimaryExpCS= rulePrimaryExpCS EOF )
            // InternalMiniOCLCS.g:1189:2: iv_rulePrimaryExpCS= rulePrimaryExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimaryExpCSRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePrimaryExpCS=rulePrimaryExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimaryExpCS; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalMiniOCLCS.g:1195:1: rulePrimaryExpCS returns [EObject current=null] : (this_SelfExpCS_0= ruleSelfExpCS | this_NameExpCS_1= ruleNameExpCS | this_LiteralExpCS_2= ruleLiteralExpCS | this_LetExpCS_3= ruleLetExpCS ) ;
    public final EObject rulePrimaryExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_SelfExpCS_0 = null;

        EObject this_NameExpCS_1 = null;

        EObject this_LiteralExpCS_2 = null;

        EObject this_LetExpCS_3 = null;



        	enterRule();

        try {
            // InternalMiniOCLCS.g:1201:2: ( (this_SelfExpCS_0= ruleSelfExpCS | this_NameExpCS_1= ruleNameExpCS | this_LiteralExpCS_2= ruleLiteralExpCS | this_LetExpCS_3= ruleLetExpCS ) )
            // InternalMiniOCLCS.g:1202:2: (this_SelfExpCS_0= ruleSelfExpCS | this_NameExpCS_1= ruleNameExpCS | this_LiteralExpCS_2= ruleLiteralExpCS | this_LetExpCS_3= ruleLetExpCS )
            {
            // InternalMiniOCLCS.g:1202:2: (this_SelfExpCS_0= ruleSelfExpCS | this_NameExpCS_1= ruleNameExpCS | this_LiteralExpCS_2= ruleLiteralExpCS | this_LetExpCS_3= ruleLetExpCS )
            int alt17=4;
            switch ( input.LA(1) ) {
            case 37:
                {
                alt17=1;
                }
                break;
            case RULE_ID:
                {
                alt17=2;
                }
                break;
            case RULE_INT:
            case 41:
            case 42:
            case 43:
            case 47:
                {
                alt17=3;
                }
                break;
            case 44:
                {
                alt17=4;
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
                    // InternalMiniOCLCS.g:1203:3: this_SelfExpCS_0= ruleSelfExpCS
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getSelfExpCSParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_SelfExpCS_0=ruleSelfExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_SelfExpCS_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalMiniOCLCS.g:1215:3: this_NameExpCS_1= ruleNameExpCS
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getNameExpCSParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_NameExpCS_1=ruleNameExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_NameExpCS_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalMiniOCLCS.g:1227:3: this_LiteralExpCS_2= ruleLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getLiteralExpCSParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_LiteralExpCS_2=ruleLiteralExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_LiteralExpCS_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalMiniOCLCS.g:1239:3: this_LetExpCS_3= ruleLetExpCS
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getLetExpCSParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
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
    // $ANTLR end "rulePrimaryExpCS"


    // $ANTLR start "entryRuleSelfExpCS"
    // InternalMiniOCLCS.g:1254:1: entryRuleSelfExpCS returns [EObject current=null] : iv_ruleSelfExpCS= ruleSelfExpCS EOF ;
    public final EObject entryRuleSelfExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelfExpCS = null;


        try {
            // InternalMiniOCLCS.g:1254:50: (iv_ruleSelfExpCS= ruleSelfExpCS EOF )
            // InternalMiniOCLCS.g:1255:2: iv_ruleSelfExpCS= ruleSelfExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSelfExpCSRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSelfExpCS=ruleSelfExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSelfExpCS; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalMiniOCLCS.g:1261:1: ruleSelfExpCS returns [EObject current=null] : ( () otherlv_1= 'self' ) ;
    public final EObject ruleSelfExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalMiniOCLCS.g:1267:2: ( ( () otherlv_1= 'self' ) )
            // InternalMiniOCLCS.g:1268:2: ( () otherlv_1= 'self' )
            {
            // InternalMiniOCLCS.g:1268:2: ( () otherlv_1= 'self' )
            // InternalMiniOCLCS.g:1269:3: () otherlv_1= 'self'
            {
            // InternalMiniOCLCS.g:1269:3: ()
            // InternalMiniOCLCS.g:1270:4: 
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

            otherlv_1=(Token)match(input,37,FOLLOW_2); if (state.failed) return current;
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


    // $ANTLR start "entryRuleNavigationExpCS"
    // InternalMiniOCLCS.g:1287:1: entryRuleNavigationExpCS returns [EObject current=null] : iv_ruleNavigationExpCS= ruleNavigationExpCS EOF ;
    public final EObject entryRuleNavigationExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigationExpCS = null;


        try {
            // InternalMiniOCLCS.g:1287:56: (iv_ruleNavigationExpCS= ruleNavigationExpCS EOF )
            // InternalMiniOCLCS.g:1288:2: iv_ruleNavigationExpCS= ruleNavigationExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigationExpCSRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleNavigationExpCS=ruleNavigationExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigationExpCS; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNavigationExpCS"


    // $ANTLR start "ruleNavigationExpCS"
    // InternalMiniOCLCS.g:1294:1: ruleNavigationExpCS returns [EObject current=null] : (this_LoopExpCS_0= ruleLoopExpCS | this_NameExpCS_1= ruleNameExpCS ) ;
    public final EObject ruleNavigationExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_LoopExpCS_0 = null;

        EObject this_NameExpCS_1 = null;



        	enterRule();

        try {
            // InternalMiniOCLCS.g:1300:2: ( (this_LoopExpCS_0= ruleLoopExpCS | this_NameExpCS_1= ruleNameExpCS ) )
            // InternalMiniOCLCS.g:1301:2: (this_LoopExpCS_0= ruleLoopExpCS | this_NameExpCS_1= ruleNameExpCS )
            {
            // InternalMiniOCLCS.g:1301:2: (this_LoopExpCS_0= ruleLoopExpCS | this_NameExpCS_1= ruleNameExpCS )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==38||LA18_0==40) ) {
                alt18=1;
            }
            else if ( (LA18_0==RULE_ID) ) {
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
                    // InternalMiniOCLCS.g:1302:3: this_LoopExpCS_0= ruleLoopExpCS
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getNavigationExpCSAccess().getLoopExpCSParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_LoopExpCS_0=ruleLoopExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_LoopExpCS_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalMiniOCLCS.g:1314:3: this_NameExpCS_1= ruleNameExpCS
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getNavigationExpCSAccess().getNameExpCSParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_NameExpCS_1=ruleNameExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_NameExpCS_1;
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
    // $ANTLR end "ruleNavigationExpCS"


    // $ANTLR start "entryRuleLoopExpCS"
    // InternalMiniOCLCS.g:1329:1: entryRuleLoopExpCS returns [EObject current=null] : iv_ruleLoopExpCS= ruleLoopExpCS EOF ;
    public final EObject entryRuleLoopExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoopExpCS = null;


        try {
            // InternalMiniOCLCS.g:1329:50: (iv_ruleLoopExpCS= ruleLoopExpCS EOF )
            // InternalMiniOCLCS.g:1330:2: iv_ruleLoopExpCS= ruleLoopExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLoopExpCSRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLoopExpCS=ruleLoopExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLoopExpCS; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLoopExpCS"


    // $ANTLR start "ruleLoopExpCS"
    // InternalMiniOCLCS.g:1336:1: ruleLoopExpCS returns [EObject current=null] : (this_CollectExpCS_0= ruleCollectExpCS | this_IterateExpCS_1= ruleIterateExpCS ) ;
    public final EObject ruleLoopExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_CollectExpCS_0 = null;

        EObject this_IterateExpCS_1 = null;



        	enterRule();

        try {
            // InternalMiniOCLCS.g:1342:2: ( (this_CollectExpCS_0= ruleCollectExpCS | this_IterateExpCS_1= ruleIterateExpCS ) )
            // InternalMiniOCLCS.g:1343:2: (this_CollectExpCS_0= ruleCollectExpCS | this_IterateExpCS_1= ruleIterateExpCS )
            {
            // InternalMiniOCLCS.g:1343:2: (this_CollectExpCS_0= ruleCollectExpCS | this_IterateExpCS_1= ruleIterateExpCS )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==38) ) {
                alt19=1;
            }
            else if ( (LA19_0==40) ) {
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
                    // InternalMiniOCLCS.g:1344:3: this_CollectExpCS_0= ruleCollectExpCS
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLoopExpCSAccess().getCollectExpCSParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_CollectExpCS_0=ruleCollectExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_CollectExpCS_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalMiniOCLCS.g:1356:3: this_IterateExpCS_1= ruleIterateExpCS
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLoopExpCSAccess().getIterateExpCSParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_IterateExpCS_1=ruleIterateExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_IterateExpCS_1;
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
    // $ANTLR end "ruleLoopExpCS"


    // $ANTLR start "entryRuleCollectExpCS"
    // InternalMiniOCLCS.g:1371:1: entryRuleCollectExpCS returns [EObject current=null] : iv_ruleCollectExpCS= ruleCollectExpCS EOF ;
    public final EObject entryRuleCollectExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectExpCS = null;


        try {
            // InternalMiniOCLCS.g:1371:53: (iv_ruleCollectExpCS= ruleCollectExpCS EOF )
            // InternalMiniOCLCS.g:1372:2: iv_ruleCollectExpCS= ruleCollectExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCollectExpCSRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCollectExpCS=ruleCollectExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCollectExpCS; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCollectExpCS"


    // $ANTLR start "ruleCollectExpCS"
    // InternalMiniOCLCS.g:1378:1: ruleCollectExpCS returns [EObject current=null] : (otherlv_0= 'collect' otherlv_1= '(' ( ( (lv_itVar_2_0= ruleIteratorVarCS ) ) otherlv_3= '|' )? ( (lv_exp_4_0= ruleExpCS ) ) otherlv_5= ')' ) ;
    public final EObject ruleCollectExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_itVar_2_0 = null;

        EObject lv_exp_4_0 = null;



        	enterRule();

        try {
            // InternalMiniOCLCS.g:1384:2: ( (otherlv_0= 'collect' otherlv_1= '(' ( ( (lv_itVar_2_0= ruleIteratorVarCS ) ) otherlv_3= '|' )? ( (lv_exp_4_0= ruleExpCS ) ) otherlv_5= ')' ) )
            // InternalMiniOCLCS.g:1385:2: (otherlv_0= 'collect' otherlv_1= '(' ( ( (lv_itVar_2_0= ruleIteratorVarCS ) ) otherlv_3= '|' )? ( (lv_exp_4_0= ruleExpCS ) ) otherlv_5= ')' )
            {
            // InternalMiniOCLCS.g:1385:2: (otherlv_0= 'collect' otherlv_1= '(' ( ( (lv_itVar_2_0= ruleIteratorVarCS ) ) otherlv_3= '|' )? ( (lv_exp_4_0= ruleExpCS ) ) otherlv_5= ')' )
            // InternalMiniOCLCS.g:1386:3: otherlv_0= 'collect' otherlv_1= '(' ( ( (lv_itVar_2_0= ruleIteratorVarCS ) ) otherlv_3= '|' )? ( (lv_exp_4_0= ruleExpCS ) ) otherlv_5= ')'
            {
            otherlv_0=(Token)match(input,38,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getCollectExpCSAccess().getCollectKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,28,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getCollectExpCSAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalMiniOCLCS.g:1394:3: ( ( (lv_itVar_2_0= ruleIteratorVarCS ) ) otherlv_3= '|' )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==RULE_ID) ) {
                int LA20_1 = input.LA(2);

                if ( (LA20_1==17||LA20_1==39) ) {
                    alt20=1;
                }
            }
            switch (alt20) {
                case 1 :
                    // InternalMiniOCLCS.g:1395:4: ( (lv_itVar_2_0= ruleIteratorVarCS ) ) otherlv_3= '|'
                    {
                    // InternalMiniOCLCS.g:1395:4: ( (lv_itVar_2_0= ruleIteratorVarCS ) )
                    // InternalMiniOCLCS.g:1396:5: (lv_itVar_2_0= ruleIteratorVarCS )
                    {
                    // InternalMiniOCLCS.g:1396:5: (lv_itVar_2_0= ruleIteratorVarCS )
                    // InternalMiniOCLCS.g:1397:6: lv_itVar_2_0= ruleIteratorVarCS
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getCollectExpCSAccess().getItVarIteratorVarCSParserRuleCall_2_0_0());
                      					
                    }
                    pushFollow(FOLLOW_26);
                    lv_itVar_2_0=ruleIteratorVarCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getCollectExpCSRule());
                      						}
                      						set(
                      							current,
                      							"itVar",
                      							lv_itVar_2_0,
                      							"org.eclipse.qvtd.doc.MiniOCLCS.IteratorVarCS");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_3=(Token)match(input,39,FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getCollectExpCSAccess().getVerticalLineKeyword_2_1());
                      			
                    }

                    }
                    break;

            }

            // InternalMiniOCLCS.g:1419:3: ( (lv_exp_4_0= ruleExpCS ) )
            // InternalMiniOCLCS.g:1420:4: (lv_exp_4_0= ruleExpCS )
            {
            // InternalMiniOCLCS.g:1420:4: (lv_exp_4_0= ruleExpCS )
            // InternalMiniOCLCS.g:1421:5: lv_exp_4_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getCollectExpCSAccess().getExpExpCSParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_27);
            lv_exp_4_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getCollectExpCSRule());
              					}
              					set(
              						current,
              						"exp",
              						lv_exp_4_0,
              						"org.eclipse.qvtd.doc.MiniOCLCS.ExpCS");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_5=(Token)match(input,30,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getCollectExpCSAccess().getRightParenthesisKeyword_4());
              		
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
    // $ANTLR end "ruleCollectExpCS"


    // $ANTLR start "entryRuleIteratorVarCS"
    // InternalMiniOCLCS.g:1446:1: entryRuleIteratorVarCS returns [EObject current=null] : iv_ruleIteratorVarCS= ruleIteratorVarCS EOF ;
    public final EObject entryRuleIteratorVarCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIteratorVarCS = null;


        try {
            // InternalMiniOCLCS.g:1446:54: (iv_ruleIteratorVarCS= ruleIteratorVarCS EOF )
            // InternalMiniOCLCS.g:1447:2: iv_ruleIteratorVarCS= ruleIteratorVarCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIteratorVarCSRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleIteratorVarCS=ruleIteratorVarCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIteratorVarCS; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIteratorVarCS"


    // $ANTLR start "ruleIteratorVarCS"
    // InternalMiniOCLCS.g:1453:1: ruleIteratorVarCS returns [EObject current=null] : ( ( (lv_itName_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_itType_2_0= rulePathNameCS ) ) )? ) ;
    public final EObject ruleIteratorVarCS() throws RecognitionException {
        EObject current = null;

        Token lv_itName_0_0=null;
        Token otherlv_1=null;
        EObject lv_itType_2_0 = null;



        	enterRule();

        try {
            // InternalMiniOCLCS.g:1459:2: ( ( ( (lv_itName_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_itType_2_0= rulePathNameCS ) ) )? ) )
            // InternalMiniOCLCS.g:1460:2: ( ( (lv_itName_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_itType_2_0= rulePathNameCS ) ) )? )
            {
            // InternalMiniOCLCS.g:1460:2: ( ( (lv_itName_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_itType_2_0= rulePathNameCS ) ) )? )
            // InternalMiniOCLCS.g:1461:3: ( (lv_itName_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_itType_2_0= rulePathNameCS ) ) )?
            {
            // InternalMiniOCLCS.g:1461:3: ( (lv_itName_0_0= RULE_ID ) )
            // InternalMiniOCLCS.g:1462:4: (lv_itName_0_0= RULE_ID )
            {
            // InternalMiniOCLCS.g:1462:4: (lv_itName_0_0= RULE_ID )
            // InternalMiniOCLCS.g:1463:5: lv_itName_0_0= RULE_ID
            {
            lv_itName_0_0=(Token)match(input,RULE_ID,FOLLOW_28); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_itName_0_0, grammarAccess.getIteratorVarCSAccess().getItNameIDTerminalRuleCall_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getIteratorVarCSRule());
              					}
              					setWithLastConsumed(
              						current,
              						"itName",
              						lv_itName_0_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            // InternalMiniOCLCS.g:1479:3: (otherlv_1= ':' ( (lv_itType_2_0= rulePathNameCS ) ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==17) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalMiniOCLCS.g:1480:4: otherlv_1= ':' ( (lv_itType_2_0= rulePathNameCS ) )
                    {
                    otherlv_1=(Token)match(input,17,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getIteratorVarCSAccess().getColonKeyword_1_0());
                      			
                    }
                    // InternalMiniOCLCS.g:1484:4: ( (lv_itType_2_0= rulePathNameCS ) )
                    // InternalMiniOCLCS.g:1485:5: (lv_itType_2_0= rulePathNameCS )
                    {
                    // InternalMiniOCLCS.g:1485:5: (lv_itType_2_0= rulePathNameCS )
                    // InternalMiniOCLCS.g:1486:6: lv_itType_2_0= rulePathNameCS
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getIteratorVarCSAccess().getItTypePathNameCSParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_itType_2_0=rulePathNameCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getIteratorVarCSRule());
                      						}
                      						set(
                      							current,
                      							"itType",
                      							lv_itType_2_0,
                      							"org.eclipse.qvtd.doc.MiniOCLCS.PathNameCS");
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
    // $ANTLR end "ruleIteratorVarCS"


    // $ANTLR start "entryRuleIterateExpCS"
    // InternalMiniOCLCS.g:1508:1: entryRuleIterateExpCS returns [EObject current=null] : iv_ruleIterateExpCS= ruleIterateExpCS EOF ;
    public final EObject entryRuleIterateExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIterateExpCS = null;


        try {
            // InternalMiniOCLCS.g:1508:53: (iv_ruleIterateExpCS= ruleIterateExpCS EOF )
            // InternalMiniOCLCS.g:1509:2: iv_ruleIterateExpCS= ruleIterateExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIterateExpCSRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleIterateExpCS=ruleIterateExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIterateExpCS; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIterateExpCS"


    // $ANTLR start "ruleIterateExpCS"
    // InternalMiniOCLCS.g:1515:1: ruleIterateExpCS returns [EObject current=null] : (otherlv_0= 'iterate' otherlv_1= '(' ( (lv_itVar_2_0= ruleIteratorVarCS ) ) otherlv_3= ';' ( (lv_accVar_4_0= ruleAccVarCS ) ) otherlv_5= '|' ( (lv_exp_6_0= ruleExpCS ) ) otherlv_7= ')' ) ;
    public final EObject ruleIterateExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_itVar_2_0 = null;

        EObject lv_accVar_4_0 = null;

        EObject lv_exp_6_0 = null;



        	enterRule();

        try {
            // InternalMiniOCLCS.g:1521:2: ( (otherlv_0= 'iterate' otherlv_1= '(' ( (lv_itVar_2_0= ruleIteratorVarCS ) ) otherlv_3= ';' ( (lv_accVar_4_0= ruleAccVarCS ) ) otherlv_5= '|' ( (lv_exp_6_0= ruleExpCS ) ) otherlv_7= ')' ) )
            // InternalMiniOCLCS.g:1522:2: (otherlv_0= 'iterate' otherlv_1= '(' ( (lv_itVar_2_0= ruleIteratorVarCS ) ) otherlv_3= ';' ( (lv_accVar_4_0= ruleAccVarCS ) ) otherlv_5= '|' ( (lv_exp_6_0= ruleExpCS ) ) otherlv_7= ')' )
            {
            // InternalMiniOCLCS.g:1522:2: (otherlv_0= 'iterate' otherlv_1= '(' ( (lv_itVar_2_0= ruleIteratorVarCS ) ) otherlv_3= ';' ( (lv_accVar_4_0= ruleAccVarCS ) ) otherlv_5= '|' ( (lv_exp_6_0= ruleExpCS ) ) otherlv_7= ')' )
            // InternalMiniOCLCS.g:1523:3: otherlv_0= 'iterate' otherlv_1= '(' ( (lv_itVar_2_0= ruleIteratorVarCS ) ) otherlv_3= ';' ( (lv_accVar_4_0= ruleAccVarCS ) ) otherlv_5= '|' ( (lv_exp_6_0= ruleExpCS ) ) otherlv_7= ')'
            {
            otherlv_0=(Token)match(input,40,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getIterateExpCSAccess().getIterateKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,28,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getIterateExpCSAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalMiniOCLCS.g:1531:3: ( (lv_itVar_2_0= ruleIteratorVarCS ) )
            // InternalMiniOCLCS.g:1532:4: (lv_itVar_2_0= ruleIteratorVarCS )
            {
            // InternalMiniOCLCS.g:1532:4: (lv_itVar_2_0= ruleIteratorVarCS )
            // InternalMiniOCLCS.g:1533:5: lv_itVar_2_0= ruleIteratorVarCS
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getIterateExpCSAccess().getItVarIteratorVarCSParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_11);
            lv_itVar_2_0=ruleIteratorVarCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getIterateExpCSRule());
              					}
              					set(
              						current,
              						"itVar",
              						lv_itVar_2_0,
              						"org.eclipse.qvtd.doc.MiniOCLCS.IteratorVarCS");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,18,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getIterateExpCSAccess().getSemicolonKeyword_3());
              		
            }
            // InternalMiniOCLCS.g:1554:3: ( (lv_accVar_4_0= ruleAccVarCS ) )
            // InternalMiniOCLCS.g:1555:4: (lv_accVar_4_0= ruleAccVarCS )
            {
            // InternalMiniOCLCS.g:1555:4: (lv_accVar_4_0= ruleAccVarCS )
            // InternalMiniOCLCS.g:1556:5: lv_accVar_4_0= ruleAccVarCS
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getIterateExpCSAccess().getAccVarAccVarCSParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_26);
            lv_accVar_4_0=ruleAccVarCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getIterateExpCSRule());
              					}
              					set(
              						current,
              						"accVar",
              						lv_accVar_4_0,
              						"org.eclipse.qvtd.doc.MiniOCLCS.AccVarCS");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_5=(Token)match(input,39,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getIterateExpCSAccess().getVerticalLineKeyword_5());
              		
            }
            // InternalMiniOCLCS.g:1577:3: ( (lv_exp_6_0= ruleExpCS ) )
            // InternalMiniOCLCS.g:1578:4: (lv_exp_6_0= ruleExpCS )
            {
            // InternalMiniOCLCS.g:1578:4: (lv_exp_6_0= ruleExpCS )
            // InternalMiniOCLCS.g:1579:5: lv_exp_6_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getIterateExpCSAccess().getExpExpCSParserRuleCall_6_0());
              				
            }
            pushFollow(FOLLOW_27);
            lv_exp_6_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getIterateExpCSRule());
              					}
              					set(
              						current,
              						"exp",
              						lv_exp_6_0,
              						"org.eclipse.qvtd.doc.MiniOCLCS.ExpCS");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_7=(Token)match(input,30,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_7, grammarAccess.getIterateExpCSAccess().getRightParenthesisKeyword_7());
              		
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
    // $ANTLR end "ruleIterateExpCS"


    // $ANTLR start "entryRuleAccVarCS"
    // InternalMiniOCLCS.g:1604:1: entryRuleAccVarCS returns [EObject current=null] : iv_ruleAccVarCS= ruleAccVarCS EOF ;
    public final EObject entryRuleAccVarCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAccVarCS = null;


        try {
            // InternalMiniOCLCS.g:1604:49: (iv_ruleAccVarCS= ruleAccVarCS EOF )
            // InternalMiniOCLCS.g:1605:2: iv_ruleAccVarCS= ruleAccVarCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAccVarCSRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAccVarCS=ruleAccVarCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAccVarCS; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAccVarCS"


    // $ANTLR start "ruleAccVarCS"
    // InternalMiniOCLCS.g:1611:1: ruleAccVarCS returns [EObject current=null] : ( ( (lv_accName_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_accType_2_0= rulePathNameCS ) ) )? otherlv_3= '=' ( (lv_accInitExp_4_0= ruleExpCS ) ) ) ;
    public final EObject ruleAccVarCS() throws RecognitionException {
        EObject current = null;

        Token lv_accName_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_accType_2_0 = null;

        EObject lv_accInitExp_4_0 = null;



        	enterRule();

        try {
            // InternalMiniOCLCS.g:1617:2: ( ( ( (lv_accName_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_accType_2_0= rulePathNameCS ) ) )? otherlv_3= '=' ( (lv_accInitExp_4_0= ruleExpCS ) ) ) )
            // InternalMiniOCLCS.g:1618:2: ( ( (lv_accName_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_accType_2_0= rulePathNameCS ) ) )? otherlv_3= '=' ( (lv_accInitExp_4_0= ruleExpCS ) ) )
            {
            // InternalMiniOCLCS.g:1618:2: ( ( (lv_accName_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_accType_2_0= rulePathNameCS ) ) )? otherlv_3= '=' ( (lv_accInitExp_4_0= ruleExpCS ) ) )
            // InternalMiniOCLCS.g:1619:3: ( (lv_accName_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_accType_2_0= rulePathNameCS ) ) )? otherlv_3= '=' ( (lv_accInitExp_4_0= ruleExpCS ) )
            {
            // InternalMiniOCLCS.g:1619:3: ( (lv_accName_0_0= RULE_ID ) )
            // InternalMiniOCLCS.g:1620:4: (lv_accName_0_0= RULE_ID )
            {
            // InternalMiniOCLCS.g:1620:4: (lv_accName_0_0= RULE_ID )
            // InternalMiniOCLCS.g:1621:5: lv_accName_0_0= RULE_ID
            {
            lv_accName_0_0=(Token)match(input,RULE_ID,FOLLOW_29); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_accName_0_0, grammarAccess.getAccVarCSAccess().getAccNameIDTerminalRuleCall_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getAccVarCSRule());
              					}
              					setWithLastConsumed(
              						current,
              						"accName",
              						lv_accName_0_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            // InternalMiniOCLCS.g:1637:3: (otherlv_1= ':' ( (lv_accType_2_0= rulePathNameCS ) ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==17) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalMiniOCLCS.g:1638:4: otherlv_1= ':' ( (lv_accType_2_0= rulePathNameCS ) )
                    {
                    otherlv_1=(Token)match(input,17,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getAccVarCSAccess().getColonKeyword_1_0());
                      			
                    }
                    // InternalMiniOCLCS.g:1642:4: ( (lv_accType_2_0= rulePathNameCS ) )
                    // InternalMiniOCLCS.g:1643:5: (lv_accType_2_0= rulePathNameCS )
                    {
                    // InternalMiniOCLCS.g:1643:5: (lv_accType_2_0= rulePathNameCS )
                    // InternalMiniOCLCS.g:1644:6: lv_accType_2_0= rulePathNameCS
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAccVarCSAccess().getAccTypePathNameCSParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_20);
                    lv_accType_2_0=rulePathNameCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAccVarCSRule());
                      						}
                      						set(
                      							current,
                      							"accType",
                      							lv_accType_2_0,
                      							"org.eclipse.qvtd.doc.MiniOCLCS.PathNameCS");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,31,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getAccVarCSAccess().getEqualsSignKeyword_2());
              		
            }
            // InternalMiniOCLCS.g:1666:3: ( (lv_accInitExp_4_0= ruleExpCS ) )
            // InternalMiniOCLCS.g:1667:4: (lv_accInitExp_4_0= ruleExpCS )
            {
            // InternalMiniOCLCS.g:1667:4: (lv_accInitExp_4_0= ruleExpCS )
            // InternalMiniOCLCS.g:1668:5: lv_accInitExp_4_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAccVarCSAccess().getAccInitExpExpCSParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_accInitExp_4_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getAccVarCSRule());
              					}
              					set(
              						current,
              						"accInitExp",
              						lv_accInitExp_4_0,
              						"org.eclipse.qvtd.doc.MiniOCLCS.ExpCS");
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
    // $ANTLR end "ruleAccVarCS"


    // $ANTLR start "entryRuleNameExpCS"
    // InternalMiniOCLCS.g:1689:1: entryRuleNameExpCS returns [EObject current=null] : iv_ruleNameExpCS= ruleNameExpCS EOF ;
    public final EObject entryRuleNameExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNameExpCS = null;


        try {
            // InternalMiniOCLCS.g:1689:50: (iv_ruleNameExpCS= ruleNameExpCS EOF )
            // InternalMiniOCLCS.g:1690:2: iv_ruleNameExpCS= ruleNameExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNameExpCSRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleNameExpCS=ruleNameExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNameExpCS; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalMiniOCLCS.g:1696:1: ruleNameExpCS returns [EObject current=null] : ( ( (lv_expName_0_0= rulePathNameCS ) ) ( (lv_roundedBrackets_1_0= ruleRoundedBracketClauseCS ) )? ) ;
    public final EObject ruleNameExpCS() throws RecognitionException {
        EObject current = null;

        EObject lv_expName_0_0 = null;

        EObject lv_roundedBrackets_1_0 = null;



        	enterRule();

        try {
            // InternalMiniOCLCS.g:1702:2: ( ( ( (lv_expName_0_0= rulePathNameCS ) ) ( (lv_roundedBrackets_1_0= ruleRoundedBracketClauseCS ) )? ) )
            // InternalMiniOCLCS.g:1703:2: ( ( (lv_expName_0_0= rulePathNameCS ) ) ( (lv_roundedBrackets_1_0= ruleRoundedBracketClauseCS ) )? )
            {
            // InternalMiniOCLCS.g:1703:2: ( ( (lv_expName_0_0= rulePathNameCS ) ) ( (lv_roundedBrackets_1_0= ruleRoundedBracketClauseCS ) )? )
            // InternalMiniOCLCS.g:1704:3: ( (lv_expName_0_0= rulePathNameCS ) ) ( (lv_roundedBrackets_1_0= ruleRoundedBracketClauseCS ) )?
            {
            // InternalMiniOCLCS.g:1704:3: ( (lv_expName_0_0= rulePathNameCS ) )
            // InternalMiniOCLCS.g:1705:4: (lv_expName_0_0= rulePathNameCS )
            {
            // InternalMiniOCLCS.g:1705:4: (lv_expName_0_0= rulePathNameCS )
            // InternalMiniOCLCS.g:1706:5: lv_expName_0_0= rulePathNameCS
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getNameExpCSAccess().getExpNamePathNameCSParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_30);
            lv_expName_0_0=rulePathNameCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getNameExpCSRule());
              					}
              					set(
              						current,
              						"expName",
              						lv_expName_0_0,
              						"org.eclipse.qvtd.doc.MiniOCLCS.PathNameCS");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalMiniOCLCS.g:1723:3: ( (lv_roundedBrackets_1_0= ruleRoundedBracketClauseCS ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==28) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalMiniOCLCS.g:1724:4: (lv_roundedBrackets_1_0= ruleRoundedBracketClauseCS )
                    {
                    // InternalMiniOCLCS.g:1724:4: (lv_roundedBrackets_1_0= ruleRoundedBracketClauseCS )
                    // InternalMiniOCLCS.g:1725:5: lv_roundedBrackets_1_0= ruleRoundedBracketClauseCS
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getNameExpCSAccess().getRoundedBracketsRoundedBracketClauseCSParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_roundedBrackets_1_0=ruleRoundedBracketClauseCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getNameExpCSRule());
                      					}
                      					set(
                      						current,
                      						"roundedBrackets",
                      						lv_roundedBrackets_1_0,
                      						"org.eclipse.qvtd.doc.MiniOCLCS.RoundedBracketClauseCS");
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
    // $ANTLR end "ruleNameExpCS"


    // $ANTLR start "entryRuleRoundedBracketClauseCS"
    // InternalMiniOCLCS.g:1746:1: entryRuleRoundedBracketClauseCS returns [EObject current=null] : iv_ruleRoundedBracketClauseCS= ruleRoundedBracketClauseCS EOF ;
    public final EObject entryRuleRoundedBracketClauseCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRoundedBracketClauseCS = null;


        try {
            // InternalMiniOCLCS.g:1746:63: (iv_ruleRoundedBracketClauseCS= ruleRoundedBracketClauseCS EOF )
            // InternalMiniOCLCS.g:1747:2: iv_ruleRoundedBracketClauseCS= ruleRoundedBracketClauseCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRoundedBracketClauseCSRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRoundedBracketClauseCS=ruleRoundedBracketClauseCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRoundedBracketClauseCS; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRoundedBracketClauseCS"


    // $ANTLR start "ruleRoundedBracketClauseCS"
    // InternalMiniOCLCS.g:1753:1: ruleRoundedBracketClauseCS returns [EObject current=null] : ( () otherlv_1= '(' ( ( (lv_args_2_0= ruleExpCS ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpCS ) ) )* )? otherlv_5= ')' ) ;
    public final EObject ruleRoundedBracketClauseCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_args_2_0 = null;

        EObject lv_args_4_0 = null;



        	enterRule();

        try {
            // InternalMiniOCLCS.g:1759:2: ( ( () otherlv_1= '(' ( ( (lv_args_2_0= ruleExpCS ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpCS ) ) )* )? otherlv_5= ')' ) )
            // InternalMiniOCLCS.g:1760:2: ( () otherlv_1= '(' ( ( (lv_args_2_0= ruleExpCS ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpCS ) ) )* )? otherlv_5= ')' )
            {
            // InternalMiniOCLCS.g:1760:2: ( () otherlv_1= '(' ( ( (lv_args_2_0= ruleExpCS ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpCS ) ) )* )? otherlv_5= ')' )
            // InternalMiniOCLCS.g:1761:3: () otherlv_1= '(' ( ( (lv_args_2_0= ruleExpCS ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpCS ) ) )* )? otherlv_5= ')'
            {
            // InternalMiniOCLCS.g:1761:3: ()
            // InternalMiniOCLCS.g:1762:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getRoundedBracketClauseCSAccess().getRoundedBracketClauseCSAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,28,FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getRoundedBracketClauseCSAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalMiniOCLCS.g:1775:3: ( ( (lv_args_2_0= ruleExpCS ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpCS ) ) )* )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==RULE_ID||LA25_0==RULE_INT||LA25_0==37||(LA25_0>=41 && LA25_0<=44)||LA25_0==47) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalMiniOCLCS.g:1776:4: ( (lv_args_2_0= ruleExpCS ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpCS ) ) )*
                    {
                    // InternalMiniOCLCS.g:1776:4: ( (lv_args_2_0= ruleExpCS ) )
                    // InternalMiniOCLCS.g:1777:5: (lv_args_2_0= ruleExpCS )
                    {
                    // InternalMiniOCLCS.g:1777:5: (lv_args_2_0= ruleExpCS )
                    // InternalMiniOCLCS.g:1778:6: lv_args_2_0= ruleExpCS
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getRoundedBracketClauseCSAccess().getArgsExpCSParserRuleCall_2_0_0());
                      					
                    }
                    pushFollow(FOLLOW_19);
                    lv_args_2_0=ruleExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getRoundedBracketClauseCSRule());
                      						}
                      						add(
                      							current,
                      							"args",
                      							lv_args_2_0,
                      							"org.eclipse.qvtd.doc.MiniOCLCS.ExpCS");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalMiniOCLCS.g:1795:4: (otherlv_3= ',' ( (lv_args_4_0= ruleExpCS ) ) )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==29) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // InternalMiniOCLCS.g:1796:5: otherlv_3= ',' ( (lv_args_4_0= ruleExpCS ) )
                    	    {
                    	    otherlv_3=(Token)match(input,29,FOLLOW_21); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_3, grammarAccess.getRoundedBracketClauseCSAccess().getCommaKeyword_2_1_0());
                    	      				
                    	    }
                    	    // InternalMiniOCLCS.g:1800:5: ( (lv_args_4_0= ruleExpCS ) )
                    	    // InternalMiniOCLCS.g:1801:6: (lv_args_4_0= ruleExpCS )
                    	    {
                    	    // InternalMiniOCLCS.g:1801:6: (lv_args_4_0= ruleExpCS )
                    	    // InternalMiniOCLCS.g:1802:7: lv_args_4_0= ruleExpCS
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getRoundedBracketClauseCSAccess().getArgsExpCSParserRuleCall_2_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_19);
                    	    lv_args_4_0=ruleExpCS();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getRoundedBracketClauseCSRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"args",
                    	      								lv_args_4_0,
                    	      								"org.eclipse.qvtd.doc.MiniOCLCS.ExpCS");
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
                    break;

            }

            otherlv_5=(Token)match(input,30,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getRoundedBracketClauseCSAccess().getRightParenthesisKeyword_3());
              		
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
    // $ANTLR end "ruleRoundedBracketClauseCS"


    // $ANTLR start "entryRuleLiteralExpCS"
    // InternalMiniOCLCS.g:1829:1: entryRuleLiteralExpCS returns [EObject current=null] : iv_ruleLiteralExpCS= ruleLiteralExpCS EOF ;
    public final EObject entryRuleLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralExpCS = null;


        try {
            // InternalMiniOCLCS.g:1829:53: (iv_ruleLiteralExpCS= ruleLiteralExpCS EOF )
            // InternalMiniOCLCS.g:1830:2: iv_ruleLiteralExpCS= ruleLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLiteralExpCSRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLiteralExpCS=ruleLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLiteralExpCS; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLiteralExpCS"


    // $ANTLR start "ruleLiteralExpCS"
    // InternalMiniOCLCS.g:1836:1: ruleLiteralExpCS returns [EObject current=null] : (this_IntLiteralExpCS_0= ruleIntLiteralExpCS | this_BooleanLiteralExpCS_1= ruleBooleanLiteralExpCS | this_NullLiteralExpCS_2= ruleNullLiteralExpCS | this_CollectionLiteralExpCS_3= ruleCollectionLiteralExpCS ) ;
    public final EObject ruleLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_IntLiteralExpCS_0 = null;

        EObject this_BooleanLiteralExpCS_1 = null;

        EObject this_NullLiteralExpCS_2 = null;

        EObject this_CollectionLiteralExpCS_3 = null;



        	enterRule();

        try {
            // InternalMiniOCLCS.g:1842:2: ( (this_IntLiteralExpCS_0= ruleIntLiteralExpCS | this_BooleanLiteralExpCS_1= ruleBooleanLiteralExpCS | this_NullLiteralExpCS_2= ruleNullLiteralExpCS | this_CollectionLiteralExpCS_3= ruleCollectionLiteralExpCS ) )
            // InternalMiniOCLCS.g:1843:2: (this_IntLiteralExpCS_0= ruleIntLiteralExpCS | this_BooleanLiteralExpCS_1= ruleBooleanLiteralExpCS | this_NullLiteralExpCS_2= ruleNullLiteralExpCS | this_CollectionLiteralExpCS_3= ruleCollectionLiteralExpCS )
            {
            // InternalMiniOCLCS.g:1843:2: (this_IntLiteralExpCS_0= ruleIntLiteralExpCS | this_BooleanLiteralExpCS_1= ruleBooleanLiteralExpCS | this_NullLiteralExpCS_2= ruleNullLiteralExpCS | this_CollectionLiteralExpCS_3= ruleCollectionLiteralExpCS )
            int alt26=4;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt26=1;
                }
                break;
            case 41:
            case 42:
                {
                alt26=2;
                }
                break;
            case 43:
                {
                alt26=3;
                }
                break;
            case 47:
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
                    // InternalMiniOCLCS.g:1844:3: this_IntLiteralExpCS_0= ruleIntLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLiteralExpCSAccess().getIntLiteralExpCSParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_IntLiteralExpCS_0=ruleIntLiteralExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_IntLiteralExpCS_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalMiniOCLCS.g:1856:3: this_BooleanLiteralExpCS_1= ruleBooleanLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLiteralExpCSAccess().getBooleanLiteralExpCSParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_BooleanLiteralExpCS_1=ruleBooleanLiteralExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_BooleanLiteralExpCS_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalMiniOCLCS.g:1868:3: this_NullLiteralExpCS_2= ruleNullLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLiteralExpCSAccess().getNullLiteralExpCSParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_NullLiteralExpCS_2=ruleNullLiteralExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_NullLiteralExpCS_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalMiniOCLCS.g:1880:3: this_CollectionLiteralExpCS_3= ruleCollectionLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLiteralExpCSAccess().getCollectionLiteralExpCSParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_CollectionLiteralExpCS_3=ruleCollectionLiteralExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_CollectionLiteralExpCS_3;
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
    // $ANTLR end "ruleLiteralExpCS"


    // $ANTLR start "entryRuleIntLiteralExpCS"
    // InternalMiniOCLCS.g:1895:1: entryRuleIntLiteralExpCS returns [EObject current=null] : iv_ruleIntLiteralExpCS= ruleIntLiteralExpCS EOF ;
    public final EObject entryRuleIntLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntLiteralExpCS = null;


        try {
            // InternalMiniOCLCS.g:1895:56: (iv_ruleIntLiteralExpCS= ruleIntLiteralExpCS EOF )
            // InternalMiniOCLCS.g:1896:2: iv_ruleIntLiteralExpCS= ruleIntLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIntLiteralExpCSRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleIntLiteralExpCS=ruleIntLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIntLiteralExpCS; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIntLiteralExpCS"


    // $ANTLR start "ruleIntLiteralExpCS"
    // InternalMiniOCLCS.g:1902:1: ruleIntLiteralExpCS returns [EObject current=null] : ( (lv_intSymbol_0_0= RULE_INT ) ) ;
    public final EObject ruleIntLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token lv_intSymbol_0_0=null;


        	enterRule();

        try {
            // InternalMiniOCLCS.g:1908:2: ( ( (lv_intSymbol_0_0= RULE_INT ) ) )
            // InternalMiniOCLCS.g:1909:2: ( (lv_intSymbol_0_0= RULE_INT ) )
            {
            // InternalMiniOCLCS.g:1909:2: ( (lv_intSymbol_0_0= RULE_INT ) )
            // InternalMiniOCLCS.g:1910:3: (lv_intSymbol_0_0= RULE_INT )
            {
            // InternalMiniOCLCS.g:1910:3: (lv_intSymbol_0_0= RULE_INT )
            // InternalMiniOCLCS.g:1911:4: lv_intSymbol_0_0= RULE_INT
            {
            lv_intSymbol_0_0=(Token)match(input,RULE_INT,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(lv_intSymbol_0_0, grammarAccess.getIntLiteralExpCSAccess().getIntSymbolINTTerminalRuleCall_0());
              			
            }
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElement(grammarAccess.getIntLiteralExpCSRule());
              				}
              				setWithLastConsumed(
              					current,
              					"intSymbol",
              					lv_intSymbol_0_0,
              					"org.eclipse.xtext.common.Terminals.INT");
              			
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
    // $ANTLR end "ruleIntLiteralExpCS"


    // $ANTLR start "entryRuleBooleanLiteralExpCS"
    // InternalMiniOCLCS.g:1930:1: entryRuleBooleanLiteralExpCS returns [EObject current=null] : iv_ruleBooleanLiteralExpCS= ruleBooleanLiteralExpCS EOF ;
    public final EObject entryRuleBooleanLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteralExpCS = null;


        try {
            // InternalMiniOCLCS.g:1930:60: (iv_ruleBooleanLiteralExpCS= ruleBooleanLiteralExpCS EOF )
            // InternalMiniOCLCS.g:1931:2: iv_ruleBooleanLiteralExpCS= ruleBooleanLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBooleanLiteralExpCSRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBooleanLiteralExpCS=ruleBooleanLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBooleanLiteralExpCS; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalMiniOCLCS.g:1937:1: ruleBooleanLiteralExpCS returns [EObject current=null] : ( () ( ( (lv_boolSymbol_1_0= 'true' ) ) | otherlv_2= 'false' ) ) ;
    public final EObject ruleBooleanLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token lv_boolSymbol_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalMiniOCLCS.g:1943:2: ( ( () ( ( (lv_boolSymbol_1_0= 'true' ) ) | otherlv_2= 'false' ) ) )
            // InternalMiniOCLCS.g:1944:2: ( () ( ( (lv_boolSymbol_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            {
            // InternalMiniOCLCS.g:1944:2: ( () ( ( (lv_boolSymbol_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            // InternalMiniOCLCS.g:1945:3: () ( ( (lv_boolSymbol_1_0= 'true' ) ) | otherlv_2= 'false' )
            {
            // InternalMiniOCLCS.g:1945:3: ()
            // InternalMiniOCLCS.g:1946:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getBooleanLiteralExpCSAccess().getBooleanExpCSAction_0(),
              					current);
              			
            }

            }

            // InternalMiniOCLCS.g:1955:3: ( ( (lv_boolSymbol_1_0= 'true' ) ) | otherlv_2= 'false' )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==41) ) {
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
                    // InternalMiniOCLCS.g:1956:4: ( (lv_boolSymbol_1_0= 'true' ) )
                    {
                    // InternalMiniOCLCS.g:1956:4: ( (lv_boolSymbol_1_0= 'true' ) )
                    // InternalMiniOCLCS.g:1957:5: (lv_boolSymbol_1_0= 'true' )
                    {
                    // InternalMiniOCLCS.g:1957:5: (lv_boolSymbol_1_0= 'true' )
                    // InternalMiniOCLCS.g:1958:6: lv_boolSymbol_1_0= 'true'
                    {
                    lv_boolSymbol_1_0=(Token)match(input,41,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_boolSymbol_1_0, grammarAccess.getBooleanLiteralExpCSAccess().getBoolSymbolTrueKeyword_1_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getBooleanLiteralExpCSRule());
                      						}
                      						setWithLastConsumed(current, "boolSymbol", true, "true");
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMiniOCLCS.g:1971:4: otherlv_2= 'false'
                    {
                    otherlv_2=(Token)match(input,42,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getBooleanLiteralExpCSAccess().getFalseKeyword_1_1());
                      			
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
    // $ANTLR end "ruleBooleanLiteralExpCS"


    // $ANTLR start "entryRuleNullLiteralExpCS"
    // InternalMiniOCLCS.g:1980:1: entryRuleNullLiteralExpCS returns [EObject current=null] : iv_ruleNullLiteralExpCS= ruleNullLiteralExpCS EOF ;
    public final EObject entryRuleNullLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullLiteralExpCS = null;


        try {
            // InternalMiniOCLCS.g:1980:57: (iv_ruleNullLiteralExpCS= ruleNullLiteralExpCS EOF )
            // InternalMiniOCLCS.g:1981:2: iv_ruleNullLiteralExpCS= ruleNullLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNullLiteralExpCSRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleNullLiteralExpCS=ruleNullLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNullLiteralExpCS; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalMiniOCLCS.g:1987:1: ruleNullLiteralExpCS returns [EObject current=null] : ( () otherlv_1= 'null' ) ;
    public final EObject ruleNullLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalMiniOCLCS.g:1993:2: ( ( () otherlv_1= 'null' ) )
            // InternalMiniOCLCS.g:1994:2: ( () otherlv_1= 'null' )
            {
            // InternalMiniOCLCS.g:1994:2: ( () otherlv_1= 'null' )
            // InternalMiniOCLCS.g:1995:3: () otherlv_1= 'null'
            {
            // InternalMiniOCLCS.g:1995:3: ()
            // InternalMiniOCLCS.g:1996:4: 
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

            otherlv_1=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
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


    // $ANTLR start "entryRuleCollectionLiteralExpCS"
    // InternalMiniOCLCS.g:2013:1: entryRuleCollectionLiteralExpCS returns [EObject current=null] : iv_ruleCollectionLiteralExpCS= ruleCollectionLiteralExpCS EOF ;
    public final EObject entryRuleCollectionLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionLiteralExpCS = null;


        try {
            // InternalMiniOCLCS.g:2013:63: (iv_ruleCollectionLiteralExpCS= ruleCollectionLiteralExpCS EOF )
            // InternalMiniOCLCS.g:2014:2: iv_ruleCollectionLiteralExpCS= ruleCollectionLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCollectionLiteralExpCSRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCollectionLiteralExpCS=ruleCollectionLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCollectionLiteralExpCS; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalMiniOCLCS.g:2020:1: ruleCollectionLiteralExpCS returns [EObject current=null] : ( ( (lv_kind_0_0= ruleCollectionKindCS ) ) otherlv_1= '{' ( (lv_parts_2_0= ruleCollectionLiteralPartCS ) )* otherlv_3= '}' ) ;
    public final EObject ruleCollectionLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Enumerator lv_kind_0_0 = null;

        EObject lv_parts_2_0 = null;



        	enterRule();

        try {
            // InternalMiniOCLCS.g:2026:2: ( ( ( (lv_kind_0_0= ruleCollectionKindCS ) ) otherlv_1= '{' ( (lv_parts_2_0= ruleCollectionLiteralPartCS ) )* otherlv_3= '}' ) )
            // InternalMiniOCLCS.g:2027:2: ( ( (lv_kind_0_0= ruleCollectionKindCS ) ) otherlv_1= '{' ( (lv_parts_2_0= ruleCollectionLiteralPartCS ) )* otherlv_3= '}' )
            {
            // InternalMiniOCLCS.g:2027:2: ( ( (lv_kind_0_0= ruleCollectionKindCS ) ) otherlv_1= '{' ( (lv_parts_2_0= ruleCollectionLiteralPartCS ) )* otherlv_3= '}' )
            // InternalMiniOCLCS.g:2028:3: ( (lv_kind_0_0= ruleCollectionKindCS ) ) otherlv_1= '{' ( (lv_parts_2_0= ruleCollectionLiteralPartCS ) )* otherlv_3= '}'
            {
            // InternalMiniOCLCS.g:2028:3: ( (lv_kind_0_0= ruleCollectionKindCS ) )
            // InternalMiniOCLCS.g:2029:4: (lv_kind_0_0= ruleCollectionKindCS )
            {
            // InternalMiniOCLCS.g:2029:4: (lv_kind_0_0= ruleCollectionKindCS )
            // InternalMiniOCLCS.g:2030:5: lv_kind_0_0= ruleCollectionKindCS
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getCollectionLiteralExpCSAccess().getKindCollectionKindCSEnumRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_5);
            lv_kind_0_0=ruleCollectionKindCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getCollectionLiteralExpCSRule());
              					}
              					set(
              						current,
              						"kind",
              						lv_kind_0_0,
              						"org.eclipse.qvtd.doc.MiniOCLCS.CollectionKindCS");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_1=(Token)match(input,12,FOLLOW_32); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getCollectionLiteralExpCSAccess().getLeftCurlyBracketKeyword_1());
              		
            }
            // InternalMiniOCLCS.g:2051:3: ( (lv_parts_2_0= ruleCollectionLiteralPartCS ) )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==RULE_ID||LA28_0==RULE_INT||LA28_0==37||(LA28_0>=41 && LA28_0<=44)||LA28_0==47) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalMiniOCLCS.g:2052:4: (lv_parts_2_0= ruleCollectionLiteralPartCS )
            	    {
            	    // InternalMiniOCLCS.g:2052:4: (lv_parts_2_0= ruleCollectionLiteralPartCS )
            	    // InternalMiniOCLCS.g:2053:5: lv_parts_2_0= ruleCollectionLiteralPartCS
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getCollectionLiteralExpCSAccess().getPartsCollectionLiteralPartCSParserRuleCall_2_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_32);
            	    lv_parts_2_0=ruleCollectionLiteralPartCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getCollectionLiteralExpCSRule());
            	      					}
            	      					add(
            	      						current,
            	      						"parts",
            	      						lv_parts_2_0,
            	      						"org.eclipse.qvtd.doc.MiniOCLCS.CollectionLiteralPartCS");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);

            otherlv_3=(Token)match(input,13,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getCollectionLiteralExpCSAccess().getRightCurlyBracketKeyword_3());
              		
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
    // InternalMiniOCLCS.g:2078:1: entryRuleCollectionLiteralPartCS returns [EObject current=null] : iv_ruleCollectionLiteralPartCS= ruleCollectionLiteralPartCS EOF ;
    public final EObject entryRuleCollectionLiteralPartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionLiteralPartCS = null;


        try {
            // InternalMiniOCLCS.g:2078:64: (iv_ruleCollectionLiteralPartCS= ruleCollectionLiteralPartCS EOF )
            // InternalMiniOCLCS.g:2079:2: iv_ruleCollectionLiteralPartCS= ruleCollectionLiteralPartCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCollectionLiteralPartCSRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCollectionLiteralPartCS=ruleCollectionLiteralPartCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCollectionLiteralPartCS; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalMiniOCLCS.g:2085:1: ruleCollectionLiteralPartCS returns [EObject current=null] : ( ( (lv_first_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_last_2_0= ruleExpCS ) ) )? ) ;
    public final EObject ruleCollectionLiteralPartCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_first_0_0 = null;

        EObject lv_last_2_0 = null;



        	enterRule();

        try {
            // InternalMiniOCLCS.g:2091:2: ( ( ( (lv_first_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_last_2_0= ruleExpCS ) ) )? ) )
            // InternalMiniOCLCS.g:2092:2: ( ( (lv_first_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_last_2_0= ruleExpCS ) ) )? )
            {
            // InternalMiniOCLCS.g:2092:2: ( ( (lv_first_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_last_2_0= ruleExpCS ) ) )? )
            // InternalMiniOCLCS.g:2093:3: ( (lv_first_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_last_2_0= ruleExpCS ) ) )?
            {
            // InternalMiniOCLCS.g:2093:3: ( (lv_first_0_0= ruleExpCS ) )
            // InternalMiniOCLCS.g:2094:4: (lv_first_0_0= ruleExpCS )
            {
            // InternalMiniOCLCS.g:2094:4: (lv_first_0_0= ruleExpCS )
            // InternalMiniOCLCS.g:2095:5: lv_first_0_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getCollectionLiteralPartCSAccess().getFirstExpCSParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_33);
            lv_first_0_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getCollectionLiteralPartCSRule());
              					}
              					set(
              						current,
              						"first",
              						lv_first_0_0,
              						"org.eclipse.qvtd.doc.MiniOCLCS.ExpCS");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalMiniOCLCS.g:2112:3: (otherlv_1= '..' ( (lv_last_2_0= ruleExpCS ) ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==25) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalMiniOCLCS.g:2113:4: otherlv_1= '..' ( (lv_last_2_0= ruleExpCS ) )
                    {
                    otherlv_1=(Token)match(input,25,FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getCollectionLiteralPartCSAccess().getFullStopFullStopKeyword_1_0());
                      			
                    }
                    // InternalMiniOCLCS.g:2117:4: ( (lv_last_2_0= ruleExpCS ) )
                    // InternalMiniOCLCS.g:2118:5: (lv_last_2_0= ruleExpCS )
                    {
                    // InternalMiniOCLCS.g:2118:5: (lv_last_2_0= ruleExpCS )
                    // InternalMiniOCLCS.g:2119:6: lv_last_2_0= ruleExpCS
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getCollectionLiteralPartCSAccess().getLastExpCSParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_last_2_0=ruleExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getCollectionLiteralPartCSRule());
                      						}
                      						set(
                      							current,
                      							"last",
                      							lv_last_2_0,
                      							"org.eclipse.qvtd.doc.MiniOCLCS.ExpCS");
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


    // $ANTLR start "entryRuleLetExpCS"
    // InternalMiniOCLCS.g:2141:1: entryRuleLetExpCS returns [EObject current=null] : iv_ruleLetExpCS= ruleLetExpCS EOF ;
    public final EObject entryRuleLetExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLetExpCS = null;


        try {
            // InternalMiniOCLCS.g:2141:49: (iv_ruleLetExpCS= ruleLetExpCS EOF )
            // InternalMiniOCLCS.g:2142:2: iv_ruleLetExpCS= ruleLetExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLetExpCSRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLetExpCS=ruleLetExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLetExpCS; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalMiniOCLCS.g:2148:1: ruleLetExpCS returns [EObject current=null] : (otherlv_0= 'let' ( (lv_letVars_1_0= ruleLetVarCS ) ) (otherlv_2= ',' ( (lv_letVars_3_0= ruleLetVarCS ) ) )* otherlv_4= 'in' ( (lv_inExp_5_0= ruleExpCS ) ) ) ;
    public final EObject ruleLetExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_letVars_1_0 = null;

        EObject lv_letVars_3_0 = null;

        EObject lv_inExp_5_0 = null;



        	enterRule();

        try {
            // InternalMiniOCLCS.g:2154:2: ( (otherlv_0= 'let' ( (lv_letVars_1_0= ruleLetVarCS ) ) (otherlv_2= ',' ( (lv_letVars_3_0= ruleLetVarCS ) ) )* otherlv_4= 'in' ( (lv_inExp_5_0= ruleExpCS ) ) ) )
            // InternalMiniOCLCS.g:2155:2: (otherlv_0= 'let' ( (lv_letVars_1_0= ruleLetVarCS ) ) (otherlv_2= ',' ( (lv_letVars_3_0= ruleLetVarCS ) ) )* otherlv_4= 'in' ( (lv_inExp_5_0= ruleExpCS ) ) )
            {
            // InternalMiniOCLCS.g:2155:2: (otherlv_0= 'let' ( (lv_letVars_1_0= ruleLetVarCS ) ) (otherlv_2= ',' ( (lv_letVars_3_0= ruleLetVarCS ) ) )* otherlv_4= 'in' ( (lv_inExp_5_0= ruleExpCS ) ) )
            // InternalMiniOCLCS.g:2156:3: otherlv_0= 'let' ( (lv_letVars_1_0= ruleLetVarCS ) ) (otherlv_2= ',' ( (lv_letVars_3_0= ruleLetVarCS ) ) )* otherlv_4= 'in' ( (lv_inExp_5_0= ruleExpCS ) )
            {
            otherlv_0=(Token)match(input,44,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getLetExpCSAccess().getLetKeyword_0());
              		
            }
            // InternalMiniOCLCS.g:2160:3: ( (lv_letVars_1_0= ruleLetVarCS ) )
            // InternalMiniOCLCS.g:2161:4: (lv_letVars_1_0= ruleLetVarCS )
            {
            // InternalMiniOCLCS.g:2161:4: (lv_letVars_1_0= ruleLetVarCS )
            // InternalMiniOCLCS.g:2162:5: lv_letVars_1_0= ruleLetVarCS
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getLetExpCSAccess().getLetVarsLetVarCSParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_34);
            lv_letVars_1_0=ruleLetVarCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getLetExpCSRule());
              					}
              					add(
              						current,
              						"letVars",
              						lv_letVars_1_0,
              						"org.eclipse.qvtd.doc.MiniOCLCS.LetVarCS");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalMiniOCLCS.g:2179:3: (otherlv_2= ',' ( (lv_letVars_3_0= ruleLetVarCS ) ) )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==29) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalMiniOCLCS.g:2180:4: otherlv_2= ',' ( (lv_letVars_3_0= ruleLetVarCS ) )
            	    {
            	    otherlv_2=(Token)match(input,29,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getLetExpCSAccess().getCommaKeyword_2_0());
            	      			
            	    }
            	    // InternalMiniOCLCS.g:2184:4: ( (lv_letVars_3_0= ruleLetVarCS ) )
            	    // InternalMiniOCLCS.g:2185:5: (lv_letVars_3_0= ruleLetVarCS )
            	    {
            	    // InternalMiniOCLCS.g:2185:5: (lv_letVars_3_0= ruleLetVarCS )
            	    // InternalMiniOCLCS.g:2186:6: lv_letVars_3_0= ruleLetVarCS
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getLetExpCSAccess().getLetVarsLetVarCSParserRuleCall_2_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_34);
            	    lv_letVars_3_0=ruleLetVarCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getLetExpCSRule());
            	      						}
            	      						add(
            	      							current,
            	      							"letVars",
            	      							lv_letVars_3_0,
            	      							"org.eclipse.qvtd.doc.MiniOCLCS.LetVarCS");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

            otherlv_4=(Token)match(input,45,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getLetExpCSAccess().getInKeyword_3());
              		
            }
            // InternalMiniOCLCS.g:2208:3: ( (lv_inExp_5_0= ruleExpCS ) )
            // InternalMiniOCLCS.g:2209:4: (lv_inExp_5_0= ruleExpCS )
            {
            // InternalMiniOCLCS.g:2209:4: (lv_inExp_5_0= ruleExpCS )
            // InternalMiniOCLCS.g:2210:5: lv_inExp_5_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getLetExpCSAccess().getInExpExpCSParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_inExp_5_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getLetExpCSRule());
              					}
              					set(
              						current,
              						"inExp",
              						lv_inExp_5_0,
              						"org.eclipse.qvtd.doc.MiniOCLCS.ExpCS");
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


    // $ANTLR start "entryRuleLetVarCS"
    // InternalMiniOCLCS.g:2231:1: entryRuleLetVarCS returns [EObject current=null] : iv_ruleLetVarCS= ruleLetVarCS EOF ;
    public final EObject entryRuleLetVarCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLetVarCS = null;


        try {
            // InternalMiniOCLCS.g:2231:49: (iv_ruleLetVarCS= ruleLetVarCS EOF )
            // InternalMiniOCLCS.g:2232:2: iv_ruleLetVarCS= ruleLetVarCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLetVarCSRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLetVarCS=ruleLetVarCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLetVarCS; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLetVarCS"


    // $ANTLR start "ruleLetVarCS"
    // InternalMiniOCLCS.g:2238:1: ruleLetVarCS returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_typeRef_2_0= rulePathNameCS ) ) )? otherlv_3= '=' ( (lv_initExp_4_0= ruleExpCS ) ) ) ;
    public final EObject ruleLetVarCS() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_typeRef_2_0 = null;

        EObject lv_initExp_4_0 = null;



        	enterRule();

        try {
            // InternalMiniOCLCS.g:2244:2: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_typeRef_2_0= rulePathNameCS ) ) )? otherlv_3= '=' ( (lv_initExp_4_0= ruleExpCS ) ) ) )
            // InternalMiniOCLCS.g:2245:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_typeRef_2_0= rulePathNameCS ) ) )? otherlv_3= '=' ( (lv_initExp_4_0= ruleExpCS ) ) )
            {
            // InternalMiniOCLCS.g:2245:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_typeRef_2_0= rulePathNameCS ) ) )? otherlv_3= '=' ( (lv_initExp_4_0= ruleExpCS ) ) )
            // InternalMiniOCLCS.g:2246:3: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_typeRef_2_0= rulePathNameCS ) ) )? otherlv_3= '=' ( (lv_initExp_4_0= ruleExpCS ) )
            {
            // InternalMiniOCLCS.g:2246:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalMiniOCLCS.g:2247:4: (lv_name_0_0= RULE_ID )
            {
            // InternalMiniOCLCS.g:2247:4: (lv_name_0_0= RULE_ID )
            // InternalMiniOCLCS.g:2248:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_29); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_0_0, grammarAccess.getLetVarCSAccess().getNameIDTerminalRuleCall_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getLetVarCSRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_0_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            // InternalMiniOCLCS.g:2264:3: (otherlv_1= ':' ( (lv_typeRef_2_0= rulePathNameCS ) ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==17) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalMiniOCLCS.g:2265:4: otherlv_1= ':' ( (lv_typeRef_2_0= rulePathNameCS ) )
                    {
                    otherlv_1=(Token)match(input,17,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getLetVarCSAccess().getColonKeyword_1_0());
                      			
                    }
                    // InternalMiniOCLCS.g:2269:4: ( (lv_typeRef_2_0= rulePathNameCS ) )
                    // InternalMiniOCLCS.g:2270:5: (lv_typeRef_2_0= rulePathNameCS )
                    {
                    // InternalMiniOCLCS.g:2270:5: (lv_typeRef_2_0= rulePathNameCS )
                    // InternalMiniOCLCS.g:2271:6: lv_typeRef_2_0= rulePathNameCS
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getLetVarCSAccess().getTypeRefPathNameCSParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_20);
                    lv_typeRef_2_0=rulePathNameCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getLetVarCSRule());
                      						}
                      						set(
                      							current,
                      							"typeRef",
                      							lv_typeRef_2_0,
                      							"org.eclipse.qvtd.doc.MiniOCLCS.PathNameCS");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,31,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getLetVarCSAccess().getEqualsSignKeyword_2());
              		
            }
            // InternalMiniOCLCS.g:2293:3: ( (lv_initExp_4_0= ruleExpCS ) )
            // InternalMiniOCLCS.g:2294:4: (lv_initExp_4_0= ruleExpCS )
            {
            // InternalMiniOCLCS.g:2294:4: (lv_initExp_4_0= ruleExpCS )
            // InternalMiniOCLCS.g:2295:5: lv_initExp_4_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getLetVarCSAccess().getInitExpExpCSParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_initExp_4_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getLetVarCSRule());
              					}
              					set(
              						current,
              						"initExp",
              						lv_initExp_4_0,
              						"org.eclipse.qvtd.doc.MiniOCLCS.ExpCS");
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
    // $ANTLR end "ruleLetVarCS"


    // $ANTLR start "entryRulePathNameCS"
    // InternalMiniOCLCS.g:2316:1: entryRulePathNameCS returns [EObject current=null] : iv_rulePathNameCS= rulePathNameCS EOF ;
    public final EObject entryRulePathNameCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePathNameCS = null;


        try {
            // InternalMiniOCLCS.g:2316:51: (iv_rulePathNameCS= rulePathNameCS EOF )
            // InternalMiniOCLCS.g:2317:2: iv_rulePathNameCS= rulePathNameCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPathNameCSRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePathNameCS=rulePathNameCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePathNameCS; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalMiniOCLCS.g:2323:1: rulePathNameCS returns [EObject current=null] : ( ( (lv_pathElements_0_0= rulePathElementCS ) ) (otherlv_1= '::' ( (lv_pathElements_2_0= rulePathElementCS ) ) )* ) ;
    public final EObject rulePathNameCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_pathElements_0_0 = null;

        EObject lv_pathElements_2_0 = null;



        	enterRule();

        try {
            // InternalMiniOCLCS.g:2329:2: ( ( ( (lv_pathElements_0_0= rulePathElementCS ) ) (otherlv_1= '::' ( (lv_pathElements_2_0= rulePathElementCS ) ) )* ) )
            // InternalMiniOCLCS.g:2330:2: ( ( (lv_pathElements_0_0= rulePathElementCS ) ) (otherlv_1= '::' ( (lv_pathElements_2_0= rulePathElementCS ) ) )* )
            {
            // InternalMiniOCLCS.g:2330:2: ( ( (lv_pathElements_0_0= rulePathElementCS ) ) (otherlv_1= '::' ( (lv_pathElements_2_0= rulePathElementCS ) ) )* )
            // InternalMiniOCLCS.g:2331:3: ( (lv_pathElements_0_0= rulePathElementCS ) ) (otherlv_1= '::' ( (lv_pathElements_2_0= rulePathElementCS ) ) )*
            {
            // InternalMiniOCLCS.g:2331:3: ( (lv_pathElements_0_0= rulePathElementCS ) )
            // InternalMiniOCLCS.g:2332:4: (lv_pathElements_0_0= rulePathElementCS )
            {
            // InternalMiniOCLCS.g:2332:4: (lv_pathElements_0_0= rulePathElementCS )
            // InternalMiniOCLCS.g:2333:5: lv_pathElements_0_0= rulePathElementCS
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPathNameCSAccess().getPathElementsPathElementCSParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_35);
            lv_pathElements_0_0=rulePathElementCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getPathNameCSRule());
              					}
              					add(
              						current,
              						"pathElements",
              						lv_pathElements_0_0,
              						"org.eclipse.qvtd.doc.MiniOCLCS.PathElementCS");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalMiniOCLCS.g:2350:3: (otherlv_1= '::' ( (lv_pathElements_2_0= rulePathElementCS ) ) )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==46) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalMiniOCLCS.g:2351:4: otherlv_1= '::' ( (lv_pathElements_2_0= rulePathElementCS ) )
            	    {
            	    otherlv_1=(Token)match(input,46,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getPathNameCSAccess().getColonColonKeyword_1_0());
            	      			
            	    }
            	    // InternalMiniOCLCS.g:2355:4: ( (lv_pathElements_2_0= rulePathElementCS ) )
            	    // InternalMiniOCLCS.g:2356:5: (lv_pathElements_2_0= rulePathElementCS )
            	    {
            	    // InternalMiniOCLCS.g:2356:5: (lv_pathElements_2_0= rulePathElementCS )
            	    // InternalMiniOCLCS.g:2357:6: lv_pathElements_2_0= rulePathElementCS
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getPathNameCSAccess().getPathElementsPathElementCSParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_35);
            	    lv_pathElements_2_0=rulePathElementCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getPathNameCSRule());
            	      						}
            	      						add(
            	      							current,
            	      							"pathElements",
            	      							lv_pathElements_2_0,
            	      							"org.eclipse.qvtd.doc.MiniOCLCS.PathElementCS");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop32;
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


    // $ANTLR start "entryRulePathElementCS"
    // InternalMiniOCLCS.g:2379:1: entryRulePathElementCS returns [EObject current=null] : iv_rulePathElementCS= rulePathElementCS EOF ;
    public final EObject entryRulePathElementCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePathElementCS = null;


        try {
            // InternalMiniOCLCS.g:2379:54: (iv_rulePathElementCS= rulePathElementCS EOF )
            // InternalMiniOCLCS.g:2380:2: iv_rulePathElementCS= rulePathElementCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPathElementCSRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePathElementCS=rulePathElementCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePathElementCS; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePathElementCS"


    // $ANTLR start "rulePathElementCS"
    // InternalMiniOCLCS.g:2386:1: rulePathElementCS returns [EObject current=null] : ( (lv_elementName_0_0= RULE_ID ) ) ;
    public final EObject rulePathElementCS() throws RecognitionException {
        EObject current = null;

        Token lv_elementName_0_0=null;


        	enterRule();

        try {
            // InternalMiniOCLCS.g:2392:2: ( ( (lv_elementName_0_0= RULE_ID ) ) )
            // InternalMiniOCLCS.g:2393:2: ( (lv_elementName_0_0= RULE_ID ) )
            {
            // InternalMiniOCLCS.g:2393:2: ( (lv_elementName_0_0= RULE_ID ) )
            // InternalMiniOCLCS.g:2394:3: (lv_elementName_0_0= RULE_ID )
            {
            // InternalMiniOCLCS.g:2394:3: (lv_elementName_0_0= RULE_ID )
            // InternalMiniOCLCS.g:2395:4: lv_elementName_0_0= RULE_ID
            {
            lv_elementName_0_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(lv_elementName_0_0, grammarAccess.getPathElementCSAccess().getElementNameIDTerminalRuleCall_0());
              			
            }
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElement(grammarAccess.getPathElementCSRule());
              				}
              				setWithLastConsumed(
              					current,
              					"elementName",
              					lv_elementName_0_0,
              					"org.eclipse.xtext.common.Terminals.ID");
              			
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
    // $ANTLR end "rulePathElementCS"


    // $ANTLR start "ruleCollectionKindCS"
    // InternalMiniOCLCS.g:2414:1: ruleCollectionKindCS returns [Enumerator current=null] : (enumLiteral_0= 'Collection' ) ;
    public final Enumerator ruleCollectionKindCS() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;


        	enterRule();

        try {
            // InternalMiniOCLCS.g:2420:2: ( (enumLiteral_0= 'Collection' ) )
            // InternalMiniOCLCS.g:2421:2: (enumLiteral_0= 'Collection' )
            {
            // InternalMiniOCLCS.g:2421:2: (enumLiteral_0= 'Collection' )
            // InternalMiniOCLCS.g:2422:3: enumLiteral_0= 'Collection'
            {
            enumLiteral_0=(Token)match(input,47,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = grammarAccess.getCollectionKindCSAccess().getCollectionEnumLiteralDeclaration().getEnumLiteral().getInstance();
              			newLeafNode(enumLiteral_0, grammarAccess.getCollectionKindCSAccess().getCollectionEnumLiteralDeclaration());
              		
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
    // $ANTLR end "ruleCollectionKindCS"

    // $ANTLR start synpred19_InternalMiniOCLCS
    public final void synpred19_InternalMiniOCLCS_fragment() throws RecognitionException {   
        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject lv_right_3_0 = null;


        // InternalMiniOCLCS.g:1039:4: ( () ( ( (lv_op_2_1= '=' | lv_op_2_2= '<>' ) ) ) ( (lv_right_3_0= ruleCallExpCS ) ) )
        // InternalMiniOCLCS.g:1039:4: () ( ( (lv_op_2_1= '=' | lv_op_2_2= '<>' ) ) ) ( (lv_right_3_0= ruleCallExpCS ) )
        {
        // InternalMiniOCLCS.g:1039:4: ()
        // InternalMiniOCLCS.g:1040:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        // InternalMiniOCLCS.g:1049:4: ( ( (lv_op_2_1= '=' | lv_op_2_2= '<>' ) ) )
        // InternalMiniOCLCS.g:1050:5: ( (lv_op_2_1= '=' | lv_op_2_2= '<>' ) )
        {
        // InternalMiniOCLCS.g:1050:5: ( (lv_op_2_1= '=' | lv_op_2_2= '<>' ) )
        // InternalMiniOCLCS.g:1051:6: (lv_op_2_1= '=' | lv_op_2_2= '<>' )
        {
        // InternalMiniOCLCS.g:1051:6: (lv_op_2_1= '=' | lv_op_2_2= '<>' )
        int alt34=2;
        int LA34_0 = input.LA(1);

        if ( (LA34_0==31) ) {
            alt34=1;
        }
        else if ( (LA34_0==34) ) {
            alt34=2;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 34, 0, input);

            throw nvae;
        }
        switch (alt34) {
            case 1 :
                // InternalMiniOCLCS.g:1052:7: lv_op_2_1= '='
                {
                lv_op_2_1=(Token)match(input,31,FOLLOW_21); if (state.failed) return ;

                }
                break;
            case 2 :
                // InternalMiniOCLCS.g:1063:7: lv_op_2_2= '<>'
                {
                lv_op_2_2=(Token)match(input,34,FOLLOW_21); if (state.failed) return ;

                }
                break;

        }


        }


        }

        // InternalMiniOCLCS.g:1076:4: ( (lv_right_3_0= ruleCallExpCS ) )
        // InternalMiniOCLCS.g:1077:5: (lv_right_3_0= ruleCallExpCS )
        {
        // InternalMiniOCLCS.g:1077:5: (lv_right_3_0= ruleCallExpCS )
        // InternalMiniOCLCS.g:1078:6: lv_right_3_0= ruleCallExpCS
        {
        if ( state.backtracking==0 ) {

          						newCompositeNode(grammarAccess.getLogicExpCSAccess().getRightCallExpCSParserRuleCall_1_2_0());
          					
        }
        pushFollow(FOLLOW_2);
        lv_right_3_0=ruleCallExpCS();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred19_InternalMiniOCLCS

    // $ANTLR start synpred21_InternalMiniOCLCS
    public final void synpred21_InternalMiniOCLCS_fragment() throws RecognitionException {   
        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject lv_navExp_3_0 = null;


        // InternalMiniOCLCS.g:1127:4: ( () ( ( (lv_op_2_1= '.' | lv_op_2_2= '->' ) ) ) ( (lv_navExp_3_0= ruleNavigationExpCS ) ) )
        // InternalMiniOCLCS.g:1127:4: () ( ( (lv_op_2_1= '.' | lv_op_2_2= '->' ) ) ) ( (lv_navExp_3_0= ruleNavigationExpCS ) )
        {
        // InternalMiniOCLCS.g:1127:4: ()
        // InternalMiniOCLCS.g:1128:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        // InternalMiniOCLCS.g:1137:4: ( ( (lv_op_2_1= '.' | lv_op_2_2= '->' ) ) )
        // InternalMiniOCLCS.g:1138:5: ( (lv_op_2_1= '.' | lv_op_2_2= '->' ) )
        {
        // InternalMiniOCLCS.g:1138:5: ( (lv_op_2_1= '.' | lv_op_2_2= '->' ) )
        // InternalMiniOCLCS.g:1139:6: (lv_op_2_1= '.' | lv_op_2_2= '->' )
        {
        // InternalMiniOCLCS.g:1139:6: (lv_op_2_1= '.' | lv_op_2_2= '->' )
        int alt35=2;
        int LA35_0 = input.LA(1);

        if ( (LA35_0==35) ) {
            alt35=1;
        }
        else if ( (LA35_0==36) ) {
            alt35=2;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 35, 0, input);

            throw nvae;
        }
        switch (alt35) {
            case 1 :
                // InternalMiniOCLCS.g:1140:7: lv_op_2_1= '.'
                {
                lv_op_2_1=(Token)match(input,35,FOLLOW_25); if (state.failed) return ;

                }
                break;
            case 2 :
                // InternalMiniOCLCS.g:1151:7: lv_op_2_2= '->'
                {
                lv_op_2_2=(Token)match(input,36,FOLLOW_25); if (state.failed) return ;

                }
                break;

        }


        }


        }

        // InternalMiniOCLCS.g:1164:4: ( (lv_navExp_3_0= ruleNavigationExpCS ) )
        // InternalMiniOCLCS.g:1165:5: (lv_navExp_3_0= ruleNavigationExpCS )
        {
        // InternalMiniOCLCS.g:1165:5: (lv_navExp_3_0= ruleNavigationExpCS )
        // InternalMiniOCLCS.g:1166:6: lv_navExp_3_0= ruleNavigationExpCS
        {
        if ( state.backtracking==0 ) {

          						newCompositeNode(grammarAccess.getCallExpCSAccess().getNavExpNavigationExpCSParserRuleCall_1_2_0());
          					
        }
        pushFollow(FOLLOW_2);
        lv_navExp_3_0=ruleNavigationExpCS();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred21_InternalMiniOCLCS

    // Delegated rules

    public final boolean synpred19_InternalMiniOCLCS() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred19_InternalMiniOCLCS_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred21_InternalMiniOCLCS() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred21_InternalMiniOCLCS_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000100000802L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000016800L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000009000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000008382000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000440000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000001800040L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000001000040L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000040000010L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000060000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x00009E2000000050L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000200002000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000480000002L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000001800000002L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000014000000010L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000080020000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x00009E2040000050L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x00009E2000002050L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000200020000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000400000000002L});

}