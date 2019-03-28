package org.eclipse.qvtd.doc.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.qvtd.doc.services.MiniOCLCSGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalMiniOCLCSParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'import'", "':'", "';'", "'package'", "'{'", "'}'", "'class'", "'extends'", "'prop'", "'['", "'?'", "'*'", "'..'", "']'", "'op'", "'('", "','", "')'", "'='", "'context'", "'inv'", "'<>'", "'.'", "'->'", "'self'", "'collect'", "'|'", "'iterate'", "'true'", "'false'", "'null'", "'let'", "'in'", "'::'", "'Collection'"
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
    // InternalMiniOCLCS.g:78:1: ruleRootCS returns [EObject current=null] : ( ( (lv_imports_0_0= ruleImportCS ) )* ( ( (lv_packages_1_0= rulePackageCS ) ) | ( (lv_constraints_2_0= ruleConstraintsDefCS ) ) )* ) ;
    public final EObject ruleRootCS() throws RecognitionException {
        EObject current = null;

        EObject lv_imports_0_0 = null;

        EObject lv_packages_1_0 = null;

        EObject lv_constraints_2_0 = null;



        	enterRule();

        try {
            // InternalMiniOCLCS.g:84:2: ( ( ( (lv_imports_0_0= ruleImportCS ) )* ( ( (lv_packages_1_0= rulePackageCS ) ) | ( (lv_constraints_2_0= ruleConstraintsDefCS ) ) )* ) )
            // InternalMiniOCLCS.g:85:2: ( ( (lv_imports_0_0= ruleImportCS ) )* ( ( (lv_packages_1_0= rulePackageCS ) ) | ( (lv_constraints_2_0= ruleConstraintsDefCS ) ) )* )
            {
            // InternalMiniOCLCS.g:85:2: ( ( (lv_imports_0_0= ruleImportCS ) )* ( ( (lv_packages_1_0= rulePackageCS ) ) | ( (lv_constraints_2_0= ruleConstraintsDefCS ) ) )* )
            // InternalMiniOCLCS.g:86:3: ( (lv_imports_0_0= ruleImportCS ) )* ( ( (lv_packages_1_0= rulePackageCS ) ) | ( (lv_constraints_2_0= ruleConstraintsDefCS ) ) )*
            {
            // InternalMiniOCLCS.g:86:3: ( (lv_imports_0_0= ruleImportCS ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalMiniOCLCS.g:87:4: (lv_imports_0_0= ruleImportCS )
            	    {
            	    // InternalMiniOCLCS.g:87:4: (lv_imports_0_0= ruleImportCS )
            	    // InternalMiniOCLCS.g:88:5: lv_imports_0_0= ruleImportCS
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getRootCSAccess().getImportsImportCSParserRuleCall_0_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_3);
            	    lv_imports_0_0=ruleImportCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getRootCSRule());
            	      					}
            	      					add(
            	      						current,
            	      						"imports",
            	      						lv_imports_0_0,
            	      						"org.eclipse.qvtd.doc.MiniOCLCS.ImportCS");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // InternalMiniOCLCS.g:105:3: ( ( (lv_packages_1_0= rulePackageCS ) ) | ( (lv_constraints_2_0= ruleConstraintsDefCS ) ) )*
            loop2:
            do {
                int alt2=3;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==14) ) {
                    alt2=1;
                }
                else if ( (LA2_0==30) ) {
                    alt2=2;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalMiniOCLCS.g:106:4: ( (lv_packages_1_0= rulePackageCS ) )
            	    {
            	    // InternalMiniOCLCS.g:106:4: ( (lv_packages_1_0= rulePackageCS ) )
            	    // InternalMiniOCLCS.g:107:5: (lv_packages_1_0= rulePackageCS )
            	    {
            	    // InternalMiniOCLCS.g:107:5: (lv_packages_1_0= rulePackageCS )
            	    // InternalMiniOCLCS.g:108:6: lv_packages_1_0= rulePackageCS
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getRootCSAccess().getPackagesPackageCSParserRuleCall_1_0_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_4);
            	    lv_packages_1_0=rulePackageCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getRootCSRule());
            	      						}
            	      						add(
            	      							current,
            	      							"packages",
            	      							lv_packages_1_0,
            	      							"org.eclipse.qvtd.doc.MiniOCLCS.PackageCS");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalMiniOCLCS.g:126:4: ( (lv_constraints_2_0= ruleConstraintsDefCS ) )
            	    {
            	    // InternalMiniOCLCS.g:126:4: ( (lv_constraints_2_0= ruleConstraintsDefCS ) )
            	    // InternalMiniOCLCS.g:127:5: (lv_constraints_2_0= ruleConstraintsDefCS )
            	    {
            	    // InternalMiniOCLCS.g:127:5: (lv_constraints_2_0= ruleConstraintsDefCS )
            	    // InternalMiniOCLCS.g:128:6: lv_constraints_2_0= ruleConstraintsDefCS
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getRootCSAccess().getConstraintsConstraintsDefCSParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_4);
            	    lv_constraints_2_0=ruleConstraintsDefCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getRootCSRule());
            	      						}
            	      						add(
            	      							current,
            	      							"constraints",
            	      							lv_constraints_2_0,
            	      							"org.eclipse.qvtd.doc.MiniOCLCS.ConstraintsDefCS");
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
    // $ANTLR end "ruleRootCS"


    // $ANTLR start "entryRuleImportCS"
    // InternalMiniOCLCS.g:150:1: entryRuleImportCS returns [EObject current=null] : iv_ruleImportCS= ruleImportCS EOF ;
    public final EObject entryRuleImportCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportCS = null;


        try {
            // InternalMiniOCLCS.g:150:49: (iv_ruleImportCS= ruleImportCS EOF )
            // InternalMiniOCLCS.g:151:2: iv_ruleImportCS= ruleImportCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImportCSRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleImportCS=ruleImportCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImportCS; 
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
    // $ANTLR end "entryRuleImportCS"


    // $ANTLR start "ruleImportCS"
    // InternalMiniOCLCS.g:157:1: ruleImportCS returns [EObject current=null] : (otherlv_0= 'import' ( ( (lv_alias_1_0= RULE_ID ) ) otherlv_2= ':' ) ( (lv_uri_3_0= RULE_STRING ) ) otherlv_4= ';' ) ;
    public final EObject ruleImportCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_alias_1_0=null;
        Token otherlv_2=null;
        Token lv_uri_3_0=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalMiniOCLCS.g:163:2: ( (otherlv_0= 'import' ( ( (lv_alias_1_0= RULE_ID ) ) otherlv_2= ':' ) ( (lv_uri_3_0= RULE_STRING ) ) otherlv_4= ';' ) )
            // InternalMiniOCLCS.g:164:2: (otherlv_0= 'import' ( ( (lv_alias_1_0= RULE_ID ) ) otherlv_2= ':' ) ( (lv_uri_3_0= RULE_STRING ) ) otherlv_4= ';' )
            {
            // InternalMiniOCLCS.g:164:2: (otherlv_0= 'import' ( ( (lv_alias_1_0= RULE_ID ) ) otherlv_2= ':' ) ( (lv_uri_3_0= RULE_STRING ) ) otherlv_4= ';' )
            // InternalMiniOCLCS.g:165:3: otherlv_0= 'import' ( ( (lv_alias_1_0= RULE_ID ) ) otherlv_2= ':' ) ( (lv_uri_3_0= RULE_STRING ) ) otherlv_4= ';'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getImportCSAccess().getImportKeyword_0());
              		
            }
            // InternalMiniOCLCS.g:169:3: ( ( (lv_alias_1_0= RULE_ID ) ) otherlv_2= ':' )
            // InternalMiniOCLCS.g:170:4: ( (lv_alias_1_0= RULE_ID ) ) otherlv_2= ':'
            {
            // InternalMiniOCLCS.g:170:4: ( (lv_alias_1_0= RULE_ID ) )
            // InternalMiniOCLCS.g:171:5: (lv_alias_1_0= RULE_ID )
            {
            // InternalMiniOCLCS.g:171:5: (lv_alias_1_0= RULE_ID )
            // InternalMiniOCLCS.g:172:6: lv_alias_1_0= RULE_ID
            {
            lv_alias_1_0=(Token)match(input,RULE_ID,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              						newLeafNode(lv_alias_1_0, grammarAccess.getImportCSAccess().getAliasIDTerminalRuleCall_1_0_0());
              					
            }
            if ( state.backtracking==0 ) {

              						if (current==null) {
              							current = createModelElement(grammarAccess.getImportCSRule());
              						}
              						setWithLastConsumed(
              							current,
              							"alias",
              							lv_alias_1_0,
              							"org.eclipse.xtext.common.Terminals.ID");
              					
            }

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_2, grammarAccess.getImportCSAccess().getColonKeyword_1_1());
              			
            }

            }

            // InternalMiniOCLCS.g:193:3: ( (lv_uri_3_0= RULE_STRING ) )
            // InternalMiniOCLCS.g:194:4: (lv_uri_3_0= RULE_STRING )
            {
            // InternalMiniOCLCS.g:194:4: (lv_uri_3_0= RULE_STRING )
            // InternalMiniOCLCS.g:195:5: lv_uri_3_0= RULE_STRING
            {
            lv_uri_3_0=(Token)match(input,RULE_STRING,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_uri_3_0, grammarAccess.getImportCSAccess().getUriSTRINGTerminalRuleCall_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getImportCSRule());
              					}
              					setWithLastConsumed(
              						current,
              						"uri",
              						lv_uri_3_0,
              						"org.eclipse.xtext.common.Terminals.STRING");
              				
            }

            }


            }

            otherlv_4=(Token)match(input,13,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getImportCSAccess().getSemicolonKeyword_3());
              		
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


    // $ANTLR start "entryRulePackageCS"
    // InternalMiniOCLCS.g:219:1: entryRulePackageCS returns [EObject current=null] : iv_rulePackageCS= rulePackageCS EOF ;
    public final EObject entryRulePackageCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePackageCS = null;


        try {
            // InternalMiniOCLCS.g:219:50: (iv_rulePackageCS= rulePackageCS EOF )
            // InternalMiniOCLCS.g:220:2: iv_rulePackageCS= rulePackageCS EOF
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
    // InternalMiniOCLCS.g:226:1: rulePackageCS returns [EObject current=null] : (otherlv_0= 'package' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_packages_3_0= rulePackageCS ) ) | ( (lv_classes_4_0= ruleClassCS ) ) )* otherlv_5= '}' ) ;
    public final EObject rulePackageCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        EObject lv_packages_3_0 = null;

        EObject lv_classes_4_0 = null;



        	enterRule();

        try {
            // InternalMiniOCLCS.g:232:2: ( (otherlv_0= 'package' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_packages_3_0= rulePackageCS ) ) | ( (lv_classes_4_0= ruleClassCS ) ) )* otherlv_5= '}' ) )
            // InternalMiniOCLCS.g:233:2: (otherlv_0= 'package' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_packages_3_0= rulePackageCS ) ) | ( (lv_classes_4_0= ruleClassCS ) ) )* otherlv_5= '}' )
            {
            // InternalMiniOCLCS.g:233:2: (otherlv_0= 'package' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_packages_3_0= rulePackageCS ) ) | ( (lv_classes_4_0= ruleClassCS ) ) )* otherlv_5= '}' )
            // InternalMiniOCLCS.g:234:3: otherlv_0= 'package' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_packages_3_0= rulePackageCS ) ) | ( (lv_classes_4_0= ruleClassCS ) ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,14,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getPackageCSAccess().getPackageKeyword_0());
              		
            }
            // InternalMiniOCLCS.g:238:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMiniOCLCS.g:239:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMiniOCLCS.g:239:4: (lv_name_1_0= RULE_ID )
            // InternalMiniOCLCS.g:240:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_9); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,15,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getPackageCSAccess().getLeftCurlyBracketKeyword_2());
              		
            }
            // InternalMiniOCLCS.g:260:3: ( ( (lv_packages_3_0= rulePackageCS ) ) | ( (lv_classes_4_0= ruleClassCS ) ) )*
            loop3:
            do {
                int alt3=3;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==14) ) {
                    alt3=1;
                }
                else if ( (LA3_0==17) ) {
                    alt3=2;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalMiniOCLCS.g:261:4: ( (lv_packages_3_0= rulePackageCS ) )
            	    {
            	    // InternalMiniOCLCS.g:261:4: ( (lv_packages_3_0= rulePackageCS ) )
            	    // InternalMiniOCLCS.g:262:5: (lv_packages_3_0= rulePackageCS )
            	    {
            	    // InternalMiniOCLCS.g:262:5: (lv_packages_3_0= rulePackageCS )
            	    // InternalMiniOCLCS.g:263:6: lv_packages_3_0= rulePackageCS
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getPackageCSAccess().getPackagesPackageCSParserRuleCall_3_0_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_10);
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
            	    // InternalMiniOCLCS.g:281:4: ( (lv_classes_4_0= ruleClassCS ) )
            	    {
            	    // InternalMiniOCLCS.g:281:4: ( (lv_classes_4_0= ruleClassCS ) )
            	    // InternalMiniOCLCS.g:282:5: (lv_classes_4_0= ruleClassCS )
            	    {
            	    // InternalMiniOCLCS.g:282:5: (lv_classes_4_0= ruleClassCS )
            	    // InternalMiniOCLCS.g:283:6: lv_classes_4_0= ruleClassCS
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getPackageCSAccess().getClassesClassCSParserRuleCall_3_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_10);
            	    lv_classes_4_0=ruleClassCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getPackageCSRule());
            	      						}
            	      						add(
            	      							current,
            	      							"classes",
            	      							lv_classes_4_0,
            	      							"org.eclipse.qvtd.doc.MiniOCLCS.ClassCS");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            otherlv_5=(Token)match(input,16,FOLLOW_2); if (state.failed) return current;
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


    // $ANTLR start "entryRuleClassCS"
    // InternalMiniOCLCS.g:309:1: entryRuleClassCS returns [EObject current=null] : iv_ruleClassCS= ruleClassCS EOF ;
    public final EObject entryRuleClassCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClassCS = null;


        try {
            // InternalMiniOCLCS.g:309:48: (iv_ruleClassCS= ruleClassCS EOF )
            // InternalMiniOCLCS.g:310:2: iv_ruleClassCS= ruleClassCS EOF
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
    // InternalMiniOCLCS.g:316:1: ruleClassCS returns [EObject current=null] : (otherlv_0= 'class' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (lv_extends_3_0= rulePathNameCS ) ) )? otherlv_4= '{' ( ( (lv_properties_5_0= rulePropertyCS ) ) | ( (lv_operations_6_0= ruleOperationCS ) ) )* otherlv_7= '}' ) ;
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
            // InternalMiniOCLCS.g:322:2: ( (otherlv_0= 'class' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (lv_extends_3_0= rulePathNameCS ) ) )? otherlv_4= '{' ( ( (lv_properties_5_0= rulePropertyCS ) ) | ( (lv_operations_6_0= ruleOperationCS ) ) )* otherlv_7= '}' ) )
            // InternalMiniOCLCS.g:323:2: (otherlv_0= 'class' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (lv_extends_3_0= rulePathNameCS ) ) )? otherlv_4= '{' ( ( (lv_properties_5_0= rulePropertyCS ) ) | ( (lv_operations_6_0= ruleOperationCS ) ) )* otherlv_7= '}' )
            {
            // InternalMiniOCLCS.g:323:2: (otherlv_0= 'class' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (lv_extends_3_0= rulePathNameCS ) ) )? otherlv_4= '{' ( ( (lv_properties_5_0= rulePropertyCS ) ) | ( (lv_operations_6_0= ruleOperationCS ) ) )* otherlv_7= '}' )
            // InternalMiniOCLCS.g:324:3: otherlv_0= 'class' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (lv_extends_3_0= rulePathNameCS ) ) )? otherlv_4= '{' ( ( (lv_properties_5_0= rulePropertyCS ) ) | ( (lv_operations_6_0= ruleOperationCS ) ) )* otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,17,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getClassCSAccess().getClassKeyword_0());
              		
            }
            // InternalMiniOCLCS.g:328:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMiniOCLCS.g:329:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMiniOCLCS.g:329:4: (lv_name_1_0= RULE_ID )
            // InternalMiniOCLCS.g:330:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_11); if (state.failed) return current;
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

            // InternalMiniOCLCS.g:346:3: (otherlv_2= 'extends' ( (lv_extends_3_0= rulePathNameCS ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==18) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalMiniOCLCS.g:347:4: otherlv_2= 'extends' ( (lv_extends_3_0= rulePathNameCS ) )
                    {
                    otherlv_2=(Token)match(input,18,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getClassCSAccess().getExtendsKeyword_2_0());
                      			
                    }
                    // InternalMiniOCLCS.g:351:4: ( (lv_extends_3_0= rulePathNameCS ) )
                    // InternalMiniOCLCS.g:352:5: (lv_extends_3_0= rulePathNameCS )
                    {
                    // InternalMiniOCLCS.g:352:5: (lv_extends_3_0= rulePathNameCS )
                    // InternalMiniOCLCS.g:353:6: lv_extends_3_0= rulePathNameCS
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getClassCSAccess().getExtendsPathNameCSParserRuleCall_2_1_0());
                      					
                    }
                    pushFollow(FOLLOW_9);
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

            otherlv_4=(Token)match(input,15,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getClassCSAccess().getLeftCurlyBracketKeyword_3());
              		
            }
            // InternalMiniOCLCS.g:375:3: ( ( (lv_properties_5_0= rulePropertyCS ) ) | ( (lv_operations_6_0= ruleOperationCS ) ) )*
            loop5:
            do {
                int alt5=3;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==19) ) {
                    alt5=1;
                }
                else if ( (LA5_0==25) ) {
                    alt5=2;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalMiniOCLCS.g:376:4: ( (lv_properties_5_0= rulePropertyCS ) )
            	    {
            	    // InternalMiniOCLCS.g:376:4: ( (lv_properties_5_0= rulePropertyCS ) )
            	    // InternalMiniOCLCS.g:377:5: (lv_properties_5_0= rulePropertyCS )
            	    {
            	    // InternalMiniOCLCS.g:377:5: (lv_properties_5_0= rulePropertyCS )
            	    // InternalMiniOCLCS.g:378:6: lv_properties_5_0= rulePropertyCS
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getClassCSAccess().getPropertiesPropertyCSParserRuleCall_4_0_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_12);
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
            	    // InternalMiniOCLCS.g:396:4: ( (lv_operations_6_0= ruleOperationCS ) )
            	    {
            	    // InternalMiniOCLCS.g:396:4: ( (lv_operations_6_0= ruleOperationCS ) )
            	    // InternalMiniOCLCS.g:397:5: (lv_operations_6_0= ruleOperationCS )
            	    {
            	    // InternalMiniOCLCS.g:397:5: (lv_operations_6_0= ruleOperationCS )
            	    // InternalMiniOCLCS.g:398:6: lv_operations_6_0= ruleOperationCS
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getClassCSAccess().getOperationsOperationCSParserRuleCall_4_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_12);
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

            otherlv_7=(Token)match(input,16,FOLLOW_2); if (state.failed) return current;
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


    // $ANTLR start "entryRulePropertyCS"
    // InternalMiniOCLCS.g:424:1: entryRulePropertyCS returns [EObject current=null] : iv_rulePropertyCS= rulePropertyCS EOF ;
    public final EObject entryRulePropertyCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyCS = null;


        try {
            // InternalMiniOCLCS.g:424:51: (iv_rulePropertyCS= rulePropertyCS EOF )
            // InternalMiniOCLCS.g:425:2: iv_rulePropertyCS= rulePropertyCS EOF
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
    // InternalMiniOCLCS.g:431:1: rulePropertyCS returns [EObject current=null] : (otherlv_0= 'prop' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_typeRef_3_0= rulePathNameCS ) ) ( (lv_multiplicity_4_0= ruleMultiplicityCS ) )? otherlv_5= ';' ) ;
    public final EObject rulePropertyCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        EObject lv_typeRef_3_0 = null;

        EObject lv_multiplicity_4_0 = null;



        	enterRule();

        try {
            // InternalMiniOCLCS.g:437:2: ( (otherlv_0= 'prop' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_typeRef_3_0= rulePathNameCS ) ) ( (lv_multiplicity_4_0= ruleMultiplicityCS ) )? otherlv_5= ';' ) )
            // InternalMiniOCLCS.g:438:2: (otherlv_0= 'prop' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_typeRef_3_0= rulePathNameCS ) ) ( (lv_multiplicity_4_0= ruleMultiplicityCS ) )? otherlv_5= ';' )
            {
            // InternalMiniOCLCS.g:438:2: (otherlv_0= 'prop' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_typeRef_3_0= rulePathNameCS ) ) ( (lv_multiplicity_4_0= ruleMultiplicityCS ) )? otherlv_5= ';' )
            // InternalMiniOCLCS.g:439:3: otherlv_0= 'prop' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_typeRef_3_0= rulePathNameCS ) ) ( (lv_multiplicity_4_0= ruleMultiplicityCS ) )? otherlv_5= ';'
            {
            otherlv_0=(Token)match(input,19,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getPropertyCSAccess().getPropKeyword_0());
              		
            }
            // InternalMiniOCLCS.g:443:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMiniOCLCS.g:444:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMiniOCLCS.g:444:4: (lv_name_1_0= RULE_ID )
            // InternalMiniOCLCS.g:445:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getPropertyCSAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getPropertyCSRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getPropertyCSAccess().getColonKeyword_2());
              		
            }
            // InternalMiniOCLCS.g:465:3: ( (lv_typeRef_3_0= rulePathNameCS ) )
            // InternalMiniOCLCS.g:466:4: (lv_typeRef_3_0= rulePathNameCS )
            {
            // InternalMiniOCLCS.g:466:4: (lv_typeRef_3_0= rulePathNameCS )
            // InternalMiniOCLCS.g:467:5: lv_typeRef_3_0= rulePathNameCS
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPropertyCSAccess().getTypeRefPathNameCSParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_13);
            lv_typeRef_3_0=rulePathNameCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getPropertyCSRule());
              					}
              					set(
              						current,
              						"typeRef",
              						lv_typeRef_3_0,
              						"org.eclipse.qvtd.doc.MiniOCLCS.PathNameCS");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalMiniOCLCS.g:484:3: ( (lv_multiplicity_4_0= ruleMultiplicityCS ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==20) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalMiniOCLCS.g:485:4: (lv_multiplicity_4_0= ruleMultiplicityCS )
                    {
                    // InternalMiniOCLCS.g:485:4: (lv_multiplicity_4_0= ruleMultiplicityCS )
                    // InternalMiniOCLCS.g:486:5: lv_multiplicity_4_0= ruleMultiplicityCS
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getPropertyCSAccess().getMultiplicityMultiplicityCSParserRuleCall_4_0());
                      				
                    }
                    pushFollow(FOLLOW_8);
                    lv_multiplicity_4_0=ruleMultiplicityCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getPropertyCSRule());
                      					}
                      					set(
                      						current,
                      						"multiplicity",
                      						lv_multiplicity_4_0,
                      						"org.eclipse.qvtd.doc.MiniOCLCS.MultiplicityCS");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,13,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getPropertyCSAccess().getSemicolonKeyword_5());
              		
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
    // InternalMiniOCLCS.g:511:1: entryRuleMultiplicityCS returns [EObject current=null] : iv_ruleMultiplicityCS= ruleMultiplicityCS EOF ;
    public final EObject entryRuleMultiplicityCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicityCS = null;


        try {
            // InternalMiniOCLCS.g:511:55: (iv_ruleMultiplicityCS= ruleMultiplicityCS EOF )
            // InternalMiniOCLCS.g:512:2: iv_ruleMultiplicityCS= ruleMultiplicityCS EOF
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
    // InternalMiniOCLCS.g:518:1: ruleMultiplicityCS returns [EObject current=null] : (otherlv_0= '[' ( ( (lv_opt_1_0= '?' ) ) | ( (lv_mult_2_0= '*' ) ) | ( (lv_mandatory_3_0= RULE_INT ) ) | ( ( (lv_lowerInt_4_0= RULE_INT ) ) otherlv_5= '..' ( ( (lv_upperInt_6_0= RULE_INT ) ) | ( (lv_upperMult_7_0= '*' ) ) ) ) ) otherlv_8= ']' ) ;
    public final EObject ruleMultiplicityCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_opt_1_0=null;
        Token lv_mult_2_0=null;
        Token lv_mandatory_3_0=null;
        Token lv_lowerInt_4_0=null;
        Token otherlv_5=null;
        Token lv_upperInt_6_0=null;
        Token lv_upperMult_7_0=null;
        Token otherlv_8=null;


        	enterRule();

        try {
            // InternalMiniOCLCS.g:524:2: ( (otherlv_0= '[' ( ( (lv_opt_1_0= '?' ) ) | ( (lv_mult_2_0= '*' ) ) | ( (lv_mandatory_3_0= RULE_INT ) ) | ( ( (lv_lowerInt_4_0= RULE_INT ) ) otherlv_5= '..' ( ( (lv_upperInt_6_0= RULE_INT ) ) | ( (lv_upperMult_7_0= '*' ) ) ) ) ) otherlv_8= ']' ) )
            // InternalMiniOCLCS.g:525:2: (otherlv_0= '[' ( ( (lv_opt_1_0= '?' ) ) | ( (lv_mult_2_0= '*' ) ) | ( (lv_mandatory_3_0= RULE_INT ) ) | ( ( (lv_lowerInt_4_0= RULE_INT ) ) otherlv_5= '..' ( ( (lv_upperInt_6_0= RULE_INT ) ) | ( (lv_upperMult_7_0= '*' ) ) ) ) ) otherlv_8= ']' )
            {
            // InternalMiniOCLCS.g:525:2: (otherlv_0= '[' ( ( (lv_opt_1_0= '?' ) ) | ( (lv_mult_2_0= '*' ) ) | ( (lv_mandatory_3_0= RULE_INT ) ) | ( ( (lv_lowerInt_4_0= RULE_INT ) ) otherlv_5= '..' ( ( (lv_upperInt_6_0= RULE_INT ) ) | ( (lv_upperMult_7_0= '*' ) ) ) ) ) otherlv_8= ']' )
            // InternalMiniOCLCS.g:526:3: otherlv_0= '[' ( ( (lv_opt_1_0= '?' ) ) | ( (lv_mult_2_0= '*' ) ) | ( (lv_mandatory_3_0= RULE_INT ) ) | ( ( (lv_lowerInt_4_0= RULE_INT ) ) otherlv_5= '..' ( ( (lv_upperInt_6_0= RULE_INT ) ) | ( (lv_upperMult_7_0= '*' ) ) ) ) ) otherlv_8= ']'
            {
            otherlv_0=(Token)match(input,20,FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getMultiplicityCSAccess().getLeftSquareBracketKeyword_0());
              		
            }
            // InternalMiniOCLCS.g:530:3: ( ( (lv_opt_1_0= '?' ) ) | ( (lv_mult_2_0= '*' ) ) | ( (lv_mandatory_3_0= RULE_INT ) ) | ( ( (lv_lowerInt_4_0= RULE_INT ) ) otherlv_5= '..' ( ( (lv_upperInt_6_0= RULE_INT ) ) | ( (lv_upperMult_7_0= '*' ) ) ) ) )
            int alt8=4;
            switch ( input.LA(1) ) {
            case 21:
                {
                alt8=1;
                }
                break;
            case 22:
                {
                alt8=2;
                }
                break;
            case RULE_INT:
                {
                int LA8_3 = input.LA(2);

                if ( (LA8_3==24) ) {
                    alt8=3;
                }
                else if ( (LA8_3==23) ) {
                    alt8=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 3, input);

                    throw nvae;
                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // InternalMiniOCLCS.g:531:4: ( (lv_opt_1_0= '?' ) )
                    {
                    // InternalMiniOCLCS.g:531:4: ( (lv_opt_1_0= '?' ) )
                    // InternalMiniOCLCS.g:532:5: (lv_opt_1_0= '?' )
                    {
                    // InternalMiniOCLCS.g:532:5: (lv_opt_1_0= '?' )
                    // InternalMiniOCLCS.g:533:6: lv_opt_1_0= '?'
                    {
                    lv_opt_1_0=(Token)match(input,21,FOLLOW_15); if (state.failed) return current;
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
                    // InternalMiniOCLCS.g:546:4: ( (lv_mult_2_0= '*' ) )
                    {
                    // InternalMiniOCLCS.g:546:4: ( (lv_mult_2_0= '*' ) )
                    // InternalMiniOCLCS.g:547:5: (lv_mult_2_0= '*' )
                    {
                    // InternalMiniOCLCS.g:547:5: (lv_mult_2_0= '*' )
                    // InternalMiniOCLCS.g:548:6: lv_mult_2_0= '*'
                    {
                    lv_mult_2_0=(Token)match(input,22,FOLLOW_15); if (state.failed) return current;
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
                    // InternalMiniOCLCS.g:561:4: ( (lv_mandatory_3_0= RULE_INT ) )
                    {
                    // InternalMiniOCLCS.g:561:4: ( (lv_mandatory_3_0= RULE_INT ) )
                    // InternalMiniOCLCS.g:562:5: (lv_mandatory_3_0= RULE_INT )
                    {
                    // InternalMiniOCLCS.g:562:5: (lv_mandatory_3_0= RULE_INT )
                    // InternalMiniOCLCS.g:563:6: lv_mandatory_3_0= RULE_INT
                    {
                    lv_mandatory_3_0=(Token)match(input,RULE_INT,FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_mandatory_3_0, grammarAccess.getMultiplicityCSAccess().getMandatoryINTTerminalRuleCall_1_2_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getMultiplicityCSRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"mandatory",
                      							lv_mandatory_3_0,
                      							"org.eclipse.xtext.common.Terminals.INT");
                      					
                    }

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalMiniOCLCS.g:580:4: ( ( (lv_lowerInt_4_0= RULE_INT ) ) otherlv_5= '..' ( ( (lv_upperInt_6_0= RULE_INT ) ) | ( (lv_upperMult_7_0= '*' ) ) ) )
                    {
                    // InternalMiniOCLCS.g:580:4: ( ( (lv_lowerInt_4_0= RULE_INT ) ) otherlv_5= '..' ( ( (lv_upperInt_6_0= RULE_INT ) ) | ( (lv_upperMult_7_0= '*' ) ) ) )
                    // InternalMiniOCLCS.g:581:5: ( (lv_lowerInt_4_0= RULE_INT ) ) otherlv_5= '..' ( ( (lv_upperInt_6_0= RULE_INT ) ) | ( (lv_upperMult_7_0= '*' ) ) )
                    {
                    // InternalMiniOCLCS.g:581:5: ( (lv_lowerInt_4_0= RULE_INT ) )
                    // InternalMiniOCLCS.g:582:6: (lv_lowerInt_4_0= RULE_INT )
                    {
                    // InternalMiniOCLCS.g:582:6: (lv_lowerInt_4_0= RULE_INT )
                    // InternalMiniOCLCS.g:583:7: lv_lowerInt_4_0= RULE_INT
                    {
                    lv_lowerInt_4_0=(Token)match(input,RULE_INT,FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(lv_lowerInt_4_0, grammarAccess.getMultiplicityCSAccess().getLowerIntINTTerminalRuleCall_1_3_0_0());
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getMultiplicityCSRule());
                      							}
                      							setWithLastConsumed(
                      								current,
                      								"lowerInt",
                      								lv_lowerInt_4_0,
                      								"org.eclipse.xtext.common.Terminals.INT");
                      						
                    }

                    }


                    }

                    otherlv_5=(Token)match(input,23,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_5, grammarAccess.getMultiplicityCSAccess().getFullStopFullStopKeyword_1_3_1());
                      				
                    }
                    // InternalMiniOCLCS.g:603:5: ( ( (lv_upperInt_6_0= RULE_INT ) ) | ( (lv_upperMult_7_0= '*' ) ) )
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==RULE_INT) ) {
                        alt7=1;
                    }
                    else if ( (LA7_0==22) ) {
                        alt7=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 0, input);

                        throw nvae;
                    }
                    switch (alt7) {
                        case 1 :
                            // InternalMiniOCLCS.g:604:6: ( (lv_upperInt_6_0= RULE_INT ) )
                            {
                            // InternalMiniOCLCS.g:604:6: ( (lv_upperInt_6_0= RULE_INT ) )
                            // InternalMiniOCLCS.g:605:7: (lv_upperInt_6_0= RULE_INT )
                            {
                            // InternalMiniOCLCS.g:605:7: (lv_upperInt_6_0= RULE_INT )
                            // InternalMiniOCLCS.g:606:8: lv_upperInt_6_0= RULE_INT
                            {
                            lv_upperInt_6_0=(Token)match(input,RULE_INT,FOLLOW_15); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								newLeafNode(lv_upperInt_6_0, grammarAccess.getMultiplicityCSAccess().getUpperIntINTTerminalRuleCall_1_3_2_0_0());
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElement(grammarAccess.getMultiplicityCSRule());
                              								}
                              								setWithLastConsumed(
                              									current,
                              									"upperInt",
                              									lv_upperInt_6_0,
                              									"org.eclipse.xtext.common.Terminals.INT");
                              							
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalMiniOCLCS.g:623:6: ( (lv_upperMult_7_0= '*' ) )
                            {
                            // InternalMiniOCLCS.g:623:6: ( (lv_upperMult_7_0= '*' ) )
                            // InternalMiniOCLCS.g:624:7: (lv_upperMult_7_0= '*' )
                            {
                            // InternalMiniOCLCS.g:624:7: (lv_upperMult_7_0= '*' )
                            // InternalMiniOCLCS.g:625:8: lv_upperMult_7_0= '*'
                            {
                            lv_upperMult_7_0=(Token)match(input,22,FOLLOW_15); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								newLeafNode(lv_upperMult_7_0, grammarAccess.getMultiplicityCSAccess().getUpperMultAsteriskKeyword_1_3_2_1_0());
                              							
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

            otherlv_8=(Token)match(input,24,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_8, grammarAccess.getMultiplicityCSAccess().getRightSquareBracketKeyword_2());
              		
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
    // InternalMiniOCLCS.g:648:1: entryRuleOperationCS returns [EObject current=null] : iv_ruleOperationCS= ruleOperationCS EOF ;
    public final EObject entryRuleOperationCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationCS = null;


        try {
            // InternalMiniOCLCS.g:648:52: (iv_ruleOperationCS= ruleOperationCS EOF )
            // InternalMiniOCLCS.g:649:2: iv_ruleOperationCS= ruleOperationCS EOF
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
    // InternalMiniOCLCS.g:655:1: ruleOperationCS returns [EObject current=null] : (otherlv_0= 'op' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_params_3_0= ruleParameterCS ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleParameterCS ) ) )* )? otherlv_6= ')' otherlv_7= ':' ( (lv_resultRef_8_0= rulePathNameCS ) ) otherlv_9= '=' ( (lv_body_10_0= ruleExpCS ) ) otherlv_11= ';' ) ;
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
            // InternalMiniOCLCS.g:661:2: ( (otherlv_0= 'op' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_params_3_0= ruleParameterCS ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleParameterCS ) ) )* )? otherlv_6= ')' otherlv_7= ':' ( (lv_resultRef_8_0= rulePathNameCS ) ) otherlv_9= '=' ( (lv_body_10_0= ruleExpCS ) ) otherlv_11= ';' ) )
            // InternalMiniOCLCS.g:662:2: (otherlv_0= 'op' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_params_3_0= ruleParameterCS ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleParameterCS ) ) )* )? otherlv_6= ')' otherlv_7= ':' ( (lv_resultRef_8_0= rulePathNameCS ) ) otherlv_9= '=' ( (lv_body_10_0= ruleExpCS ) ) otherlv_11= ';' )
            {
            // InternalMiniOCLCS.g:662:2: (otherlv_0= 'op' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_params_3_0= ruleParameterCS ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleParameterCS ) ) )* )? otherlv_6= ')' otherlv_7= ':' ( (lv_resultRef_8_0= rulePathNameCS ) ) otherlv_9= '=' ( (lv_body_10_0= ruleExpCS ) ) otherlv_11= ';' )
            // InternalMiniOCLCS.g:663:3: otherlv_0= 'op' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_params_3_0= ruleParameterCS ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleParameterCS ) ) )* )? otherlv_6= ')' otherlv_7= ':' ( (lv_resultRef_8_0= rulePathNameCS ) ) otherlv_9= '=' ( (lv_body_10_0= ruleExpCS ) ) otherlv_11= ';'
            {
            otherlv_0=(Token)match(input,25,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getOperationCSAccess().getOpKeyword_0());
              		
            }
            // InternalMiniOCLCS.g:667:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMiniOCLCS.g:668:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMiniOCLCS.g:668:4: (lv_name_1_0= RULE_ID )
            // InternalMiniOCLCS.g:669:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_18); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,26,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getOperationCSAccess().getLeftParenthesisKeyword_2());
              		
            }
            // InternalMiniOCLCS.g:689:3: ( ( (lv_params_3_0= ruleParameterCS ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleParameterCS ) ) )* )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ID) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalMiniOCLCS.g:690:4: ( (lv_params_3_0= ruleParameterCS ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleParameterCS ) ) )*
                    {
                    // InternalMiniOCLCS.g:690:4: ( (lv_params_3_0= ruleParameterCS ) )
                    // InternalMiniOCLCS.g:691:5: (lv_params_3_0= ruleParameterCS )
                    {
                    // InternalMiniOCLCS.g:691:5: (lv_params_3_0= ruleParameterCS )
                    // InternalMiniOCLCS.g:692:6: lv_params_3_0= ruleParameterCS
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getOperationCSAccess().getParamsParameterCSParserRuleCall_3_0_0());
                      					
                    }
                    pushFollow(FOLLOW_20);
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

                    // InternalMiniOCLCS.g:709:4: (otherlv_4= ',' ( (lv_params_5_0= ruleParameterCS ) ) )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==27) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // InternalMiniOCLCS.g:710:5: otherlv_4= ',' ( (lv_params_5_0= ruleParameterCS ) )
                    	    {
                    	    otherlv_4=(Token)match(input,27,FOLLOW_5); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_4, grammarAccess.getOperationCSAccess().getCommaKeyword_3_1_0());
                    	      				
                    	    }
                    	    // InternalMiniOCLCS.g:714:5: ( (lv_params_5_0= ruleParameterCS ) )
                    	    // InternalMiniOCLCS.g:715:6: (lv_params_5_0= ruleParameterCS )
                    	    {
                    	    // InternalMiniOCLCS.g:715:6: (lv_params_5_0= ruleParameterCS )
                    	    // InternalMiniOCLCS.g:716:7: lv_params_5_0= ruleParameterCS
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getOperationCSAccess().getParamsParameterCSParserRuleCall_3_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_20);
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
                    	    break loop9;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,28,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getOperationCSAccess().getRightParenthesisKeyword_4());
              		
            }
            otherlv_7=(Token)match(input,12,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_7, grammarAccess.getOperationCSAccess().getColonKeyword_5());
              		
            }
            // InternalMiniOCLCS.g:743:3: ( (lv_resultRef_8_0= rulePathNameCS ) )
            // InternalMiniOCLCS.g:744:4: (lv_resultRef_8_0= rulePathNameCS )
            {
            // InternalMiniOCLCS.g:744:4: (lv_resultRef_8_0= rulePathNameCS )
            // InternalMiniOCLCS.g:745:5: lv_resultRef_8_0= rulePathNameCS
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getOperationCSAccess().getResultRefPathNameCSParserRuleCall_6_0());
              				
            }
            pushFollow(FOLLOW_21);
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

            otherlv_9=(Token)match(input,29,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_9, grammarAccess.getOperationCSAccess().getEqualsSignKeyword_7());
              		
            }
            // InternalMiniOCLCS.g:766:3: ( (lv_body_10_0= ruleExpCS ) )
            // InternalMiniOCLCS.g:767:4: (lv_body_10_0= ruleExpCS )
            {
            // InternalMiniOCLCS.g:767:4: (lv_body_10_0= ruleExpCS )
            // InternalMiniOCLCS.g:768:5: lv_body_10_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getOperationCSAccess().getBodyExpCSParserRuleCall_8_0());
              				
            }
            pushFollow(FOLLOW_8);
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

            otherlv_11=(Token)match(input,13,FOLLOW_2); if (state.failed) return current;
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
    // InternalMiniOCLCS.g:793:1: entryRuleParameterCS returns [EObject current=null] : iv_ruleParameterCS= ruleParameterCS EOF ;
    public final EObject entryRuleParameterCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterCS = null;


        try {
            // InternalMiniOCLCS.g:793:52: (iv_ruleParameterCS= ruleParameterCS EOF )
            // InternalMiniOCLCS.g:794:2: iv_ruleParameterCS= ruleParameterCS EOF
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
    // InternalMiniOCLCS.g:800:1: ruleParameterCS returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_typeRef_2_0= rulePathNameCS ) ) ) ;
    public final EObject ruleParameterCS() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_typeRef_2_0 = null;



        	enterRule();

        try {
            // InternalMiniOCLCS.g:806:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_typeRef_2_0= rulePathNameCS ) ) ) )
            // InternalMiniOCLCS.g:807:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_typeRef_2_0= rulePathNameCS ) ) )
            {
            // InternalMiniOCLCS.g:807:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_typeRef_2_0= rulePathNameCS ) ) )
            // InternalMiniOCLCS.g:808:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_typeRef_2_0= rulePathNameCS ) )
            {
            // InternalMiniOCLCS.g:808:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalMiniOCLCS.g:809:4: (lv_name_0_0= RULE_ID )
            {
            // InternalMiniOCLCS.g:809:4: (lv_name_0_0= RULE_ID )
            // InternalMiniOCLCS.g:810:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_6); if (state.failed) return current;
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

            otherlv_1=(Token)match(input,12,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getParameterCSAccess().getColonKeyword_1());
              		
            }
            // InternalMiniOCLCS.g:830:3: ( (lv_typeRef_2_0= rulePathNameCS ) )
            // InternalMiniOCLCS.g:831:4: (lv_typeRef_2_0= rulePathNameCS )
            {
            // InternalMiniOCLCS.g:831:4: (lv_typeRef_2_0= rulePathNameCS )
            // InternalMiniOCLCS.g:832:5: lv_typeRef_2_0= rulePathNameCS
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
    // InternalMiniOCLCS.g:853:1: entryRuleConstraintsDefCS returns [EObject current=null] : iv_ruleConstraintsDefCS= ruleConstraintsDefCS EOF ;
    public final EObject entryRuleConstraintsDefCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstraintsDefCS = null;


        try {
            // InternalMiniOCLCS.g:853:57: (iv_ruleConstraintsDefCS= ruleConstraintsDefCS EOF )
            // InternalMiniOCLCS.g:854:2: iv_ruleConstraintsDefCS= ruleConstraintsDefCS EOF
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
    // InternalMiniOCLCS.g:860:1: ruleConstraintsDefCS returns [EObject current=null] : (otherlv_0= 'context' ( (lv_typeRef_1_0= rulePathNameCS ) ) otherlv_2= '{' ( (lv_invariants_3_0= ruleInvariantCS ) )* otherlv_4= '}' ) ;
    public final EObject ruleConstraintsDefCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_typeRef_1_0 = null;

        EObject lv_invariants_3_0 = null;



        	enterRule();

        try {
            // InternalMiniOCLCS.g:866:2: ( (otherlv_0= 'context' ( (lv_typeRef_1_0= rulePathNameCS ) ) otherlv_2= '{' ( (lv_invariants_3_0= ruleInvariantCS ) )* otherlv_4= '}' ) )
            // InternalMiniOCLCS.g:867:2: (otherlv_0= 'context' ( (lv_typeRef_1_0= rulePathNameCS ) ) otherlv_2= '{' ( (lv_invariants_3_0= ruleInvariantCS ) )* otherlv_4= '}' )
            {
            // InternalMiniOCLCS.g:867:2: (otherlv_0= 'context' ( (lv_typeRef_1_0= rulePathNameCS ) ) otherlv_2= '{' ( (lv_invariants_3_0= ruleInvariantCS ) )* otherlv_4= '}' )
            // InternalMiniOCLCS.g:868:3: otherlv_0= 'context' ( (lv_typeRef_1_0= rulePathNameCS ) ) otherlv_2= '{' ( (lv_invariants_3_0= ruleInvariantCS ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,30,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getConstraintsDefCSAccess().getContextKeyword_0());
              		
            }
            // InternalMiniOCLCS.g:872:3: ( (lv_typeRef_1_0= rulePathNameCS ) )
            // InternalMiniOCLCS.g:873:4: (lv_typeRef_1_0= rulePathNameCS )
            {
            // InternalMiniOCLCS.g:873:4: (lv_typeRef_1_0= rulePathNameCS )
            // InternalMiniOCLCS.g:874:5: lv_typeRef_1_0= rulePathNameCS
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getConstraintsDefCSAccess().getTypeRefPathNameCSParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_9);
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

            otherlv_2=(Token)match(input,15,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getConstraintsDefCSAccess().getLeftCurlyBracketKeyword_2());
              		
            }
            // InternalMiniOCLCS.g:895:3: ( (lv_invariants_3_0= ruleInvariantCS ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==31) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalMiniOCLCS.g:896:4: (lv_invariants_3_0= ruleInvariantCS )
            	    {
            	    // InternalMiniOCLCS.g:896:4: (lv_invariants_3_0= ruleInvariantCS )
            	    // InternalMiniOCLCS.g:897:5: lv_invariants_3_0= ruleInvariantCS
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getConstraintsDefCSAccess().getInvariantsInvariantCSParserRuleCall_3_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_23);
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
            	    break loop11;
                }
            } while (true);

            otherlv_4=(Token)match(input,16,FOLLOW_2); if (state.failed) return current;
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
    // InternalMiniOCLCS.g:922:1: entryRuleInvariantCS returns [EObject current=null] : iv_ruleInvariantCS= ruleInvariantCS EOF ;
    public final EObject entryRuleInvariantCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInvariantCS = null;


        try {
            // InternalMiniOCLCS.g:922:52: (iv_ruleInvariantCS= ruleInvariantCS EOF )
            // InternalMiniOCLCS.g:923:2: iv_ruleInvariantCS= ruleInvariantCS EOF
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
    // InternalMiniOCLCS.g:929:1: ruleInvariantCS returns [EObject current=null] : (otherlv_0= 'inv' otherlv_1= ':' ( (lv_exp_2_0= ruleExpCS ) ) otherlv_3= ';' ) ;
    public final EObject ruleInvariantCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_exp_2_0 = null;



        	enterRule();

        try {
            // InternalMiniOCLCS.g:935:2: ( (otherlv_0= 'inv' otherlv_1= ':' ( (lv_exp_2_0= ruleExpCS ) ) otherlv_3= ';' ) )
            // InternalMiniOCLCS.g:936:2: (otherlv_0= 'inv' otherlv_1= ':' ( (lv_exp_2_0= ruleExpCS ) ) otherlv_3= ';' )
            {
            // InternalMiniOCLCS.g:936:2: (otherlv_0= 'inv' otherlv_1= ':' ( (lv_exp_2_0= ruleExpCS ) ) otherlv_3= ';' )
            // InternalMiniOCLCS.g:937:3: otherlv_0= 'inv' otherlv_1= ':' ( (lv_exp_2_0= ruleExpCS ) ) otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,31,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getInvariantCSAccess().getInvKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,12,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getInvariantCSAccess().getColonKeyword_1());
              		
            }
            // InternalMiniOCLCS.g:945:3: ( (lv_exp_2_0= ruleExpCS ) )
            // InternalMiniOCLCS.g:946:4: (lv_exp_2_0= ruleExpCS )
            {
            // InternalMiniOCLCS.g:946:4: (lv_exp_2_0= ruleExpCS )
            // InternalMiniOCLCS.g:947:5: lv_exp_2_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getInvariantCSAccess().getExpExpCSParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_8);
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

            otherlv_3=(Token)match(input,13,FOLLOW_2); if (state.failed) return current;
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
    // InternalMiniOCLCS.g:972:1: entryRuleExpCS returns [EObject current=null] : iv_ruleExpCS= ruleExpCS EOF ;
    public final EObject entryRuleExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpCS = null;


        try {
            // InternalMiniOCLCS.g:972:46: (iv_ruleExpCS= ruleExpCS EOF )
            // InternalMiniOCLCS.g:973:2: iv_ruleExpCS= ruleExpCS EOF
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
    // InternalMiniOCLCS.g:979:1: ruleExpCS returns [EObject current=null] : this_EqualityExpCS_0= ruleEqualityExpCS ;
    public final EObject ruleExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_EqualityExpCS_0 = null;



        	enterRule();

        try {
            // InternalMiniOCLCS.g:985:2: (this_EqualityExpCS_0= ruleEqualityExpCS )
            // InternalMiniOCLCS.g:986:2: this_EqualityExpCS_0= ruleEqualityExpCS
            {
            if ( state.backtracking==0 ) {

              		/* */
              	
            }
            if ( state.backtracking==0 ) {

              		newCompositeNode(grammarAccess.getExpCSAccess().getEqualityExpCSParserRuleCall());
              	
            }
            pushFollow(FOLLOW_2);
            this_EqualityExpCS_0=ruleEqualityExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current = this_EqualityExpCS_0;
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


    // $ANTLR start "entryRuleEqualityExpCS"
    // InternalMiniOCLCS.g:1000:1: entryRuleEqualityExpCS returns [EObject current=null] : iv_ruleEqualityExpCS= ruleEqualityExpCS EOF ;
    public final EObject entryRuleEqualityExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpCS = null;


        try {
            // InternalMiniOCLCS.g:1000:54: (iv_ruleEqualityExpCS= ruleEqualityExpCS EOF )
            // InternalMiniOCLCS.g:1001:2: iv_ruleEqualityExpCS= ruleEqualityExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEqualityExpCSRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEqualityExpCS=ruleEqualityExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEqualityExpCS; 
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
    // $ANTLR end "entryRuleEqualityExpCS"


    // $ANTLR start "ruleEqualityExpCS"
    // InternalMiniOCLCS.g:1007:1: ruleEqualityExpCS returns [EObject current=null] : (this_CallExpCS_0= ruleCallExpCS ( () ( ( (lv_opName_2_1= '=' | lv_opName_2_2= '<>' ) ) ) ( (lv_right_3_0= ruleCallExpCS ) ) )* ) ;
    public final EObject ruleEqualityExpCS() throws RecognitionException {
        EObject current = null;

        Token lv_opName_2_1=null;
        Token lv_opName_2_2=null;
        EObject this_CallExpCS_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalMiniOCLCS.g:1013:2: ( (this_CallExpCS_0= ruleCallExpCS ( () ( ( (lv_opName_2_1= '=' | lv_opName_2_2= '<>' ) ) ) ( (lv_right_3_0= ruleCallExpCS ) ) )* ) )
            // InternalMiniOCLCS.g:1014:2: (this_CallExpCS_0= ruleCallExpCS ( () ( ( (lv_opName_2_1= '=' | lv_opName_2_2= '<>' ) ) ) ( (lv_right_3_0= ruleCallExpCS ) ) )* )
            {
            // InternalMiniOCLCS.g:1014:2: (this_CallExpCS_0= ruleCallExpCS ( () ( ( (lv_opName_2_1= '=' | lv_opName_2_2= '<>' ) ) ) ( (lv_right_3_0= ruleCallExpCS ) ) )* )
            // InternalMiniOCLCS.g:1015:3: this_CallExpCS_0= ruleCallExpCS ( () ( ( (lv_opName_2_1= '=' | lv_opName_2_2= '<>' ) ) ) ( (lv_right_3_0= ruleCallExpCS ) ) )*
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getEqualityExpCSAccess().getCallExpCSParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_24);
            this_CallExpCS_0=ruleCallExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_CallExpCS_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalMiniOCLCS.g:1026:3: ( () ( ( (lv_opName_2_1= '=' | lv_opName_2_2= '<>' ) ) ) ( (lv_right_3_0= ruleCallExpCS ) ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==29) ) {
                    int LA13_2 = input.LA(2);

                    if ( (synpred18_InternalMiniOCLCS()) ) {
                        alt13=1;
                    }


                }
                else if ( (LA13_0==32) ) {
                    int LA13_3 = input.LA(2);

                    if ( (synpred18_InternalMiniOCLCS()) ) {
                        alt13=1;
                    }


                }


                switch (alt13) {
            	case 1 :
            	    // InternalMiniOCLCS.g:1027:4: () ( ( (lv_opName_2_1= '=' | lv_opName_2_2= '<>' ) ) ) ( (lv_right_3_0= ruleCallExpCS ) )
            	    {
            	    // InternalMiniOCLCS.g:1027:4: ()
            	    // InternalMiniOCLCS.g:1028:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					/* */
            	      				
            	    }
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getEqualityExpCSAccess().getEqualityExpCSLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalMiniOCLCS.g:1037:4: ( ( (lv_opName_2_1= '=' | lv_opName_2_2= '<>' ) ) )
            	    // InternalMiniOCLCS.g:1038:5: ( (lv_opName_2_1= '=' | lv_opName_2_2= '<>' ) )
            	    {
            	    // InternalMiniOCLCS.g:1038:5: ( (lv_opName_2_1= '=' | lv_opName_2_2= '<>' ) )
            	    // InternalMiniOCLCS.g:1039:6: (lv_opName_2_1= '=' | lv_opName_2_2= '<>' )
            	    {
            	    // InternalMiniOCLCS.g:1039:6: (lv_opName_2_1= '=' | lv_opName_2_2= '<>' )
            	    int alt12=2;
            	    int LA12_0 = input.LA(1);

            	    if ( (LA12_0==29) ) {
            	        alt12=1;
            	    }
            	    else if ( (LA12_0==32) ) {
            	        alt12=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 12, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt12) {
            	        case 1 :
            	            // InternalMiniOCLCS.g:1040:7: lv_opName_2_1= '='
            	            {
            	            lv_opName_2_1=(Token)match(input,29,FOLLOW_22); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_opName_2_1, grammarAccess.getEqualityExpCSAccess().getOpNameEqualsSignKeyword_1_1_0_0());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getEqualityExpCSRule());
            	              							}
            	              							setWithLastConsumed(current, "opName", lv_opName_2_1, null);
            	              						
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // InternalMiniOCLCS.g:1051:7: lv_opName_2_2= '<>'
            	            {
            	            lv_opName_2_2=(Token)match(input,32,FOLLOW_22); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_opName_2_2, grammarAccess.getEqualityExpCSAccess().getOpNameLessThanSignGreaterThanSignKeyword_1_1_0_1());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getEqualityExpCSRule());
            	              							}
            	              							setWithLastConsumed(current, "opName", lv_opName_2_2, null);
            	              						
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalMiniOCLCS.g:1064:4: ( (lv_right_3_0= ruleCallExpCS ) )
            	    // InternalMiniOCLCS.g:1065:5: (lv_right_3_0= ruleCallExpCS )
            	    {
            	    // InternalMiniOCLCS.g:1065:5: (lv_right_3_0= ruleCallExpCS )
            	    // InternalMiniOCLCS.g:1066:6: lv_right_3_0= ruleCallExpCS
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getEqualityExpCSAccess().getRightCallExpCSParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_24);
            	    lv_right_3_0=ruleCallExpCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getEqualityExpCSRule());
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
            	    break loop13;
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
    // $ANTLR end "ruleEqualityExpCS"


    // $ANTLR start "entryRuleCallExpCS"
    // InternalMiniOCLCS.g:1088:1: entryRuleCallExpCS returns [EObject current=null] : iv_ruleCallExpCS= ruleCallExpCS EOF ;
    public final EObject entryRuleCallExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCallExpCS = null;


        try {
            // InternalMiniOCLCS.g:1088:50: (iv_ruleCallExpCS= ruleCallExpCS EOF )
            // InternalMiniOCLCS.g:1089:2: iv_ruleCallExpCS= ruleCallExpCS EOF
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
    // InternalMiniOCLCS.g:1095:1: ruleCallExpCS returns [EObject current=null] : (this_PrimaryExpCS_0= rulePrimaryExpCS ( () ( ( (lv_opName_2_1= '.' | lv_opName_2_2= '->' ) ) ) ( (lv_navExp_3_0= ruleNavigationExpCS ) ) )* ) ;
    public final EObject ruleCallExpCS() throws RecognitionException {
        EObject current = null;

        Token lv_opName_2_1=null;
        Token lv_opName_2_2=null;
        EObject this_PrimaryExpCS_0 = null;

        EObject lv_navExp_3_0 = null;



        	enterRule();

        try {
            // InternalMiniOCLCS.g:1101:2: ( (this_PrimaryExpCS_0= rulePrimaryExpCS ( () ( ( (lv_opName_2_1= '.' | lv_opName_2_2= '->' ) ) ) ( (lv_navExp_3_0= ruleNavigationExpCS ) ) )* ) )
            // InternalMiniOCLCS.g:1102:2: (this_PrimaryExpCS_0= rulePrimaryExpCS ( () ( ( (lv_opName_2_1= '.' | lv_opName_2_2= '->' ) ) ) ( (lv_navExp_3_0= ruleNavigationExpCS ) ) )* )
            {
            // InternalMiniOCLCS.g:1102:2: (this_PrimaryExpCS_0= rulePrimaryExpCS ( () ( ( (lv_opName_2_1= '.' | lv_opName_2_2= '->' ) ) ) ( (lv_navExp_3_0= ruleNavigationExpCS ) ) )* )
            // InternalMiniOCLCS.g:1103:3: this_PrimaryExpCS_0= rulePrimaryExpCS ( () ( ( (lv_opName_2_1= '.' | lv_opName_2_2= '->' ) ) ) ( (lv_navExp_3_0= ruleNavigationExpCS ) ) )*
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getCallExpCSAccess().getPrimaryExpCSParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_25);
            this_PrimaryExpCS_0=rulePrimaryExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_PrimaryExpCS_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalMiniOCLCS.g:1114:3: ( () ( ( (lv_opName_2_1= '.' | lv_opName_2_2= '->' ) ) ) ( (lv_navExp_3_0= ruleNavigationExpCS ) ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==33) ) {
                    int LA15_2 = input.LA(2);

                    if ( (synpred20_InternalMiniOCLCS()) ) {
                        alt15=1;
                    }


                }
                else if ( (LA15_0==34) ) {
                    int LA15_3 = input.LA(2);

                    if ( (synpred20_InternalMiniOCLCS()) ) {
                        alt15=1;
                    }


                }


                switch (alt15) {
            	case 1 :
            	    // InternalMiniOCLCS.g:1115:4: () ( ( (lv_opName_2_1= '.' | lv_opName_2_2= '->' ) ) ) ( (lv_navExp_3_0= ruleNavigationExpCS ) )
            	    {
            	    // InternalMiniOCLCS.g:1115:4: ()
            	    // InternalMiniOCLCS.g:1116:5: 
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

            	    // InternalMiniOCLCS.g:1125:4: ( ( (lv_opName_2_1= '.' | lv_opName_2_2= '->' ) ) )
            	    // InternalMiniOCLCS.g:1126:5: ( (lv_opName_2_1= '.' | lv_opName_2_2= '->' ) )
            	    {
            	    // InternalMiniOCLCS.g:1126:5: ( (lv_opName_2_1= '.' | lv_opName_2_2= '->' ) )
            	    // InternalMiniOCLCS.g:1127:6: (lv_opName_2_1= '.' | lv_opName_2_2= '->' )
            	    {
            	    // InternalMiniOCLCS.g:1127:6: (lv_opName_2_1= '.' | lv_opName_2_2= '->' )
            	    int alt14=2;
            	    int LA14_0 = input.LA(1);

            	    if ( (LA14_0==33) ) {
            	        alt14=1;
            	    }
            	    else if ( (LA14_0==34) ) {
            	        alt14=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 14, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt14) {
            	        case 1 :
            	            // InternalMiniOCLCS.g:1128:7: lv_opName_2_1= '.'
            	            {
            	            lv_opName_2_1=(Token)match(input,33,FOLLOW_26); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_opName_2_1, grammarAccess.getCallExpCSAccess().getOpNameFullStopKeyword_1_1_0_0());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getCallExpCSRule());
            	              							}
            	              							setWithLastConsumed(current, "opName", lv_opName_2_1, null);
            	              						
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // InternalMiniOCLCS.g:1139:7: lv_opName_2_2= '->'
            	            {
            	            lv_opName_2_2=(Token)match(input,34,FOLLOW_26); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_opName_2_2, grammarAccess.getCallExpCSAccess().getOpNameHyphenMinusGreaterThanSignKeyword_1_1_0_1());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getCallExpCSRule());
            	              							}
            	              							setWithLastConsumed(current, "opName", lv_opName_2_2, null);
            	              						
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalMiniOCLCS.g:1152:4: ( (lv_navExp_3_0= ruleNavigationExpCS ) )
            	    // InternalMiniOCLCS.g:1153:5: (lv_navExp_3_0= ruleNavigationExpCS )
            	    {
            	    // InternalMiniOCLCS.g:1153:5: (lv_navExp_3_0= ruleNavigationExpCS )
            	    // InternalMiniOCLCS.g:1154:6: lv_navExp_3_0= ruleNavigationExpCS
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getCallExpCSAccess().getNavExpNavigationExpCSParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_25);
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
    // $ANTLR end "ruleCallExpCS"


    // $ANTLR start "entryRulePrimaryExpCS"
    // InternalMiniOCLCS.g:1176:1: entryRulePrimaryExpCS returns [EObject current=null] : iv_rulePrimaryExpCS= rulePrimaryExpCS EOF ;
    public final EObject entryRulePrimaryExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpCS = null;


        try {
            // InternalMiniOCLCS.g:1176:53: (iv_rulePrimaryExpCS= rulePrimaryExpCS EOF )
            // InternalMiniOCLCS.g:1177:2: iv_rulePrimaryExpCS= rulePrimaryExpCS EOF
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
    // InternalMiniOCLCS.g:1183:1: rulePrimaryExpCS returns [EObject current=null] : (this_SelfExpCS_0= ruleSelfExpCS | this_NameExpCS_1= ruleNameExpCS | this_LiteralExpCS_2= ruleLiteralExpCS | this_LetExpCS_3= ruleLetExpCS ) ;
    public final EObject rulePrimaryExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_SelfExpCS_0 = null;

        EObject this_NameExpCS_1 = null;

        EObject this_LiteralExpCS_2 = null;

        EObject this_LetExpCS_3 = null;



        	enterRule();

        try {
            // InternalMiniOCLCS.g:1189:2: ( (this_SelfExpCS_0= ruleSelfExpCS | this_NameExpCS_1= ruleNameExpCS | this_LiteralExpCS_2= ruleLiteralExpCS | this_LetExpCS_3= ruleLetExpCS ) )
            // InternalMiniOCLCS.g:1190:2: (this_SelfExpCS_0= ruleSelfExpCS | this_NameExpCS_1= ruleNameExpCS | this_LiteralExpCS_2= ruleLiteralExpCS | this_LetExpCS_3= ruleLetExpCS )
            {
            // InternalMiniOCLCS.g:1190:2: (this_SelfExpCS_0= ruleSelfExpCS | this_NameExpCS_1= ruleNameExpCS | this_LiteralExpCS_2= ruleLiteralExpCS | this_LetExpCS_3= ruleLetExpCS )
            int alt16=4;
            switch ( input.LA(1) ) {
            case 35:
                {
                alt16=1;
                }
                break;
            case RULE_ID:
                {
                alt16=2;
                }
                break;
            case RULE_INT:
            case 39:
            case 40:
            case 41:
            case 45:
                {
                alt16=3;
                }
                break;
            case 42:
                {
                alt16=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // InternalMiniOCLCS.g:1191:3: this_SelfExpCS_0= ruleSelfExpCS
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
                    // InternalMiniOCLCS.g:1203:3: this_NameExpCS_1= ruleNameExpCS
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
                    // InternalMiniOCLCS.g:1215:3: this_LiteralExpCS_2= ruleLiteralExpCS
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
                    // InternalMiniOCLCS.g:1227:3: this_LetExpCS_3= ruleLetExpCS
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
    // InternalMiniOCLCS.g:1242:1: entryRuleSelfExpCS returns [EObject current=null] : iv_ruleSelfExpCS= ruleSelfExpCS EOF ;
    public final EObject entryRuleSelfExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelfExpCS = null;


        try {
            // InternalMiniOCLCS.g:1242:50: (iv_ruleSelfExpCS= ruleSelfExpCS EOF )
            // InternalMiniOCLCS.g:1243:2: iv_ruleSelfExpCS= ruleSelfExpCS EOF
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
    // InternalMiniOCLCS.g:1249:1: ruleSelfExpCS returns [EObject current=null] : ( () otherlv_1= 'self' ) ;
    public final EObject ruleSelfExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalMiniOCLCS.g:1255:2: ( ( () otherlv_1= 'self' ) )
            // InternalMiniOCLCS.g:1256:2: ( () otherlv_1= 'self' )
            {
            // InternalMiniOCLCS.g:1256:2: ( () otherlv_1= 'self' )
            // InternalMiniOCLCS.g:1257:3: () otherlv_1= 'self'
            {
            // InternalMiniOCLCS.g:1257:3: ()
            // InternalMiniOCLCS.g:1258:4: 
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

            otherlv_1=(Token)match(input,35,FOLLOW_2); if (state.failed) return current;
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
    // InternalMiniOCLCS.g:1275:1: entryRuleNavigationExpCS returns [EObject current=null] : iv_ruleNavigationExpCS= ruleNavigationExpCS EOF ;
    public final EObject entryRuleNavigationExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigationExpCS = null;


        try {
            // InternalMiniOCLCS.g:1275:56: (iv_ruleNavigationExpCS= ruleNavigationExpCS EOF )
            // InternalMiniOCLCS.g:1276:2: iv_ruleNavigationExpCS= ruleNavigationExpCS EOF
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
    // InternalMiniOCLCS.g:1282:1: ruleNavigationExpCS returns [EObject current=null] : (this_LoopExpCS_0= ruleLoopExpCS | this_NameExpCS_1= ruleNameExpCS ) ;
    public final EObject ruleNavigationExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_LoopExpCS_0 = null;

        EObject this_NameExpCS_1 = null;



        	enterRule();

        try {
            // InternalMiniOCLCS.g:1288:2: ( (this_LoopExpCS_0= ruleLoopExpCS | this_NameExpCS_1= ruleNameExpCS ) )
            // InternalMiniOCLCS.g:1289:2: (this_LoopExpCS_0= ruleLoopExpCS | this_NameExpCS_1= ruleNameExpCS )
            {
            // InternalMiniOCLCS.g:1289:2: (this_LoopExpCS_0= ruleLoopExpCS | this_NameExpCS_1= ruleNameExpCS )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==36||LA17_0==38) ) {
                alt17=1;
            }
            else if ( (LA17_0==RULE_ID) ) {
                alt17=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // InternalMiniOCLCS.g:1290:3: this_LoopExpCS_0= ruleLoopExpCS
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
                    // InternalMiniOCLCS.g:1302:3: this_NameExpCS_1= ruleNameExpCS
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
    // InternalMiniOCLCS.g:1317:1: entryRuleLoopExpCS returns [EObject current=null] : iv_ruleLoopExpCS= ruleLoopExpCS EOF ;
    public final EObject entryRuleLoopExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoopExpCS = null;


        try {
            // InternalMiniOCLCS.g:1317:50: (iv_ruleLoopExpCS= ruleLoopExpCS EOF )
            // InternalMiniOCLCS.g:1318:2: iv_ruleLoopExpCS= ruleLoopExpCS EOF
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
    // InternalMiniOCLCS.g:1324:1: ruleLoopExpCS returns [EObject current=null] : (this_CollectExpCS_0= ruleCollectExpCS | this_IterateExpCS_1= ruleIterateExpCS ) ;
    public final EObject ruleLoopExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_CollectExpCS_0 = null;

        EObject this_IterateExpCS_1 = null;



        	enterRule();

        try {
            // InternalMiniOCLCS.g:1330:2: ( (this_CollectExpCS_0= ruleCollectExpCS | this_IterateExpCS_1= ruleIterateExpCS ) )
            // InternalMiniOCLCS.g:1331:2: (this_CollectExpCS_0= ruleCollectExpCS | this_IterateExpCS_1= ruleIterateExpCS )
            {
            // InternalMiniOCLCS.g:1331:2: (this_CollectExpCS_0= ruleCollectExpCS | this_IterateExpCS_1= ruleIterateExpCS )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==36) ) {
                alt18=1;
            }
            else if ( (LA18_0==38) ) {
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
                    // InternalMiniOCLCS.g:1332:3: this_CollectExpCS_0= ruleCollectExpCS
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
                    // InternalMiniOCLCS.g:1344:3: this_IterateExpCS_1= ruleIterateExpCS
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
    // InternalMiniOCLCS.g:1359:1: entryRuleCollectExpCS returns [EObject current=null] : iv_ruleCollectExpCS= ruleCollectExpCS EOF ;
    public final EObject entryRuleCollectExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectExpCS = null;


        try {
            // InternalMiniOCLCS.g:1359:53: (iv_ruleCollectExpCS= ruleCollectExpCS EOF )
            // InternalMiniOCLCS.g:1360:2: iv_ruleCollectExpCS= ruleCollectExpCS EOF
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
    // InternalMiniOCLCS.g:1366:1: ruleCollectExpCS returns [EObject current=null] : (otherlv_0= 'collect' otherlv_1= '(' ( ( (lv_itVar_2_0= ruleIteratorVarCS ) ) otherlv_3= '|' )? ( (lv_exp_4_0= ruleExpCS ) ) otherlv_5= ')' ) ;
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
            // InternalMiniOCLCS.g:1372:2: ( (otherlv_0= 'collect' otherlv_1= '(' ( ( (lv_itVar_2_0= ruleIteratorVarCS ) ) otherlv_3= '|' )? ( (lv_exp_4_0= ruleExpCS ) ) otherlv_5= ')' ) )
            // InternalMiniOCLCS.g:1373:2: (otherlv_0= 'collect' otherlv_1= '(' ( ( (lv_itVar_2_0= ruleIteratorVarCS ) ) otherlv_3= '|' )? ( (lv_exp_4_0= ruleExpCS ) ) otherlv_5= ')' )
            {
            // InternalMiniOCLCS.g:1373:2: (otherlv_0= 'collect' otherlv_1= '(' ( ( (lv_itVar_2_0= ruleIteratorVarCS ) ) otherlv_3= '|' )? ( (lv_exp_4_0= ruleExpCS ) ) otherlv_5= ')' )
            // InternalMiniOCLCS.g:1374:3: otherlv_0= 'collect' otherlv_1= '(' ( ( (lv_itVar_2_0= ruleIteratorVarCS ) ) otherlv_3= '|' )? ( (lv_exp_4_0= ruleExpCS ) ) otherlv_5= ')'
            {
            otherlv_0=(Token)match(input,36,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getCollectExpCSAccess().getCollectKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,26,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getCollectExpCSAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalMiniOCLCS.g:1382:3: ( ( (lv_itVar_2_0= ruleIteratorVarCS ) ) otherlv_3= '|' )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_ID) ) {
                int LA19_1 = input.LA(2);

                if ( (LA19_1==12||LA19_1==37) ) {
                    alt19=1;
                }
            }
            switch (alt19) {
                case 1 :
                    // InternalMiniOCLCS.g:1383:4: ( (lv_itVar_2_0= ruleIteratorVarCS ) ) otherlv_3= '|'
                    {
                    // InternalMiniOCLCS.g:1383:4: ( (lv_itVar_2_0= ruleIteratorVarCS ) )
                    // InternalMiniOCLCS.g:1384:5: (lv_itVar_2_0= ruleIteratorVarCS )
                    {
                    // InternalMiniOCLCS.g:1384:5: (lv_itVar_2_0= ruleIteratorVarCS )
                    // InternalMiniOCLCS.g:1385:6: lv_itVar_2_0= ruleIteratorVarCS
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getCollectExpCSAccess().getItVarIteratorVarCSParserRuleCall_2_0_0());
                      					
                    }
                    pushFollow(FOLLOW_27);
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

                    otherlv_3=(Token)match(input,37,FOLLOW_22); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getCollectExpCSAccess().getVerticalLineKeyword_2_1());
                      			
                    }

                    }
                    break;

            }

            // InternalMiniOCLCS.g:1407:3: ( (lv_exp_4_0= ruleExpCS ) )
            // InternalMiniOCLCS.g:1408:4: (lv_exp_4_0= ruleExpCS )
            {
            // InternalMiniOCLCS.g:1408:4: (lv_exp_4_0= ruleExpCS )
            // InternalMiniOCLCS.g:1409:5: lv_exp_4_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getCollectExpCSAccess().getExpExpCSParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_28);
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

            otherlv_5=(Token)match(input,28,FOLLOW_2); if (state.failed) return current;
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
    // InternalMiniOCLCS.g:1434:1: entryRuleIteratorVarCS returns [EObject current=null] : iv_ruleIteratorVarCS= ruleIteratorVarCS EOF ;
    public final EObject entryRuleIteratorVarCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIteratorVarCS = null;


        try {
            // InternalMiniOCLCS.g:1434:54: (iv_ruleIteratorVarCS= ruleIteratorVarCS EOF )
            // InternalMiniOCLCS.g:1435:2: iv_ruleIteratorVarCS= ruleIteratorVarCS EOF
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
    // InternalMiniOCLCS.g:1441:1: ruleIteratorVarCS returns [EObject current=null] : ( ( (lv_itName_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_itType_2_0= rulePathNameCS ) ) )? ) ;
    public final EObject ruleIteratorVarCS() throws RecognitionException {
        EObject current = null;

        Token lv_itName_0_0=null;
        Token otherlv_1=null;
        EObject lv_itType_2_0 = null;



        	enterRule();

        try {
            // InternalMiniOCLCS.g:1447:2: ( ( ( (lv_itName_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_itType_2_0= rulePathNameCS ) ) )? ) )
            // InternalMiniOCLCS.g:1448:2: ( ( (lv_itName_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_itType_2_0= rulePathNameCS ) ) )? )
            {
            // InternalMiniOCLCS.g:1448:2: ( ( (lv_itName_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_itType_2_0= rulePathNameCS ) ) )? )
            // InternalMiniOCLCS.g:1449:3: ( (lv_itName_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_itType_2_0= rulePathNameCS ) ) )?
            {
            // InternalMiniOCLCS.g:1449:3: ( (lv_itName_0_0= RULE_ID ) )
            // InternalMiniOCLCS.g:1450:4: (lv_itName_0_0= RULE_ID )
            {
            // InternalMiniOCLCS.g:1450:4: (lv_itName_0_0= RULE_ID )
            // InternalMiniOCLCS.g:1451:5: lv_itName_0_0= RULE_ID
            {
            lv_itName_0_0=(Token)match(input,RULE_ID,FOLLOW_29); if (state.failed) return current;
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

            // InternalMiniOCLCS.g:1467:3: (otherlv_1= ':' ( (lv_itType_2_0= rulePathNameCS ) ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==12) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalMiniOCLCS.g:1468:4: otherlv_1= ':' ( (lv_itType_2_0= rulePathNameCS ) )
                    {
                    otherlv_1=(Token)match(input,12,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getIteratorVarCSAccess().getColonKeyword_1_0());
                      			
                    }
                    // InternalMiniOCLCS.g:1472:4: ( (lv_itType_2_0= rulePathNameCS ) )
                    // InternalMiniOCLCS.g:1473:5: (lv_itType_2_0= rulePathNameCS )
                    {
                    // InternalMiniOCLCS.g:1473:5: (lv_itType_2_0= rulePathNameCS )
                    // InternalMiniOCLCS.g:1474:6: lv_itType_2_0= rulePathNameCS
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
    // InternalMiniOCLCS.g:1496:1: entryRuleIterateExpCS returns [EObject current=null] : iv_ruleIterateExpCS= ruleIterateExpCS EOF ;
    public final EObject entryRuleIterateExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIterateExpCS = null;


        try {
            // InternalMiniOCLCS.g:1496:53: (iv_ruleIterateExpCS= ruleIterateExpCS EOF )
            // InternalMiniOCLCS.g:1497:2: iv_ruleIterateExpCS= ruleIterateExpCS EOF
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
    // InternalMiniOCLCS.g:1503:1: ruleIterateExpCS returns [EObject current=null] : (otherlv_0= 'iterate' otherlv_1= '(' ( (lv_itVar_2_0= ruleIteratorVarCS ) ) otherlv_3= ';' ( (lv_accVar_4_0= ruleAccVarCS ) ) otherlv_5= '|' ( (lv_exp_6_0= ruleExpCS ) ) otherlv_7= ')' ) ;
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
            // InternalMiniOCLCS.g:1509:2: ( (otherlv_0= 'iterate' otherlv_1= '(' ( (lv_itVar_2_0= ruleIteratorVarCS ) ) otherlv_3= ';' ( (lv_accVar_4_0= ruleAccVarCS ) ) otherlv_5= '|' ( (lv_exp_6_0= ruleExpCS ) ) otherlv_7= ')' ) )
            // InternalMiniOCLCS.g:1510:2: (otherlv_0= 'iterate' otherlv_1= '(' ( (lv_itVar_2_0= ruleIteratorVarCS ) ) otherlv_3= ';' ( (lv_accVar_4_0= ruleAccVarCS ) ) otherlv_5= '|' ( (lv_exp_6_0= ruleExpCS ) ) otherlv_7= ')' )
            {
            // InternalMiniOCLCS.g:1510:2: (otherlv_0= 'iterate' otherlv_1= '(' ( (lv_itVar_2_0= ruleIteratorVarCS ) ) otherlv_3= ';' ( (lv_accVar_4_0= ruleAccVarCS ) ) otherlv_5= '|' ( (lv_exp_6_0= ruleExpCS ) ) otherlv_7= ')' )
            // InternalMiniOCLCS.g:1511:3: otherlv_0= 'iterate' otherlv_1= '(' ( (lv_itVar_2_0= ruleIteratorVarCS ) ) otherlv_3= ';' ( (lv_accVar_4_0= ruleAccVarCS ) ) otherlv_5= '|' ( (lv_exp_6_0= ruleExpCS ) ) otherlv_7= ')'
            {
            otherlv_0=(Token)match(input,38,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getIterateExpCSAccess().getIterateKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,26,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getIterateExpCSAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalMiniOCLCS.g:1519:3: ( (lv_itVar_2_0= ruleIteratorVarCS ) )
            // InternalMiniOCLCS.g:1520:4: (lv_itVar_2_0= ruleIteratorVarCS )
            {
            // InternalMiniOCLCS.g:1520:4: (lv_itVar_2_0= ruleIteratorVarCS )
            // InternalMiniOCLCS.g:1521:5: lv_itVar_2_0= ruleIteratorVarCS
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getIterateExpCSAccess().getItVarIteratorVarCSParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_8);
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

            otherlv_3=(Token)match(input,13,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getIterateExpCSAccess().getSemicolonKeyword_3());
              		
            }
            // InternalMiniOCLCS.g:1542:3: ( (lv_accVar_4_0= ruleAccVarCS ) )
            // InternalMiniOCLCS.g:1543:4: (lv_accVar_4_0= ruleAccVarCS )
            {
            // InternalMiniOCLCS.g:1543:4: (lv_accVar_4_0= ruleAccVarCS )
            // InternalMiniOCLCS.g:1544:5: lv_accVar_4_0= ruleAccVarCS
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getIterateExpCSAccess().getAccVarAccVarCSParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_27);
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

            otherlv_5=(Token)match(input,37,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getIterateExpCSAccess().getVerticalLineKeyword_5());
              		
            }
            // InternalMiniOCLCS.g:1565:3: ( (lv_exp_6_0= ruleExpCS ) )
            // InternalMiniOCLCS.g:1566:4: (lv_exp_6_0= ruleExpCS )
            {
            // InternalMiniOCLCS.g:1566:4: (lv_exp_6_0= ruleExpCS )
            // InternalMiniOCLCS.g:1567:5: lv_exp_6_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getIterateExpCSAccess().getExpExpCSParserRuleCall_6_0());
              				
            }
            pushFollow(FOLLOW_28);
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

            otherlv_7=(Token)match(input,28,FOLLOW_2); if (state.failed) return current;
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
    // InternalMiniOCLCS.g:1592:1: entryRuleAccVarCS returns [EObject current=null] : iv_ruleAccVarCS= ruleAccVarCS EOF ;
    public final EObject entryRuleAccVarCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAccVarCS = null;


        try {
            // InternalMiniOCLCS.g:1592:49: (iv_ruleAccVarCS= ruleAccVarCS EOF )
            // InternalMiniOCLCS.g:1593:2: iv_ruleAccVarCS= ruleAccVarCS EOF
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
    // InternalMiniOCLCS.g:1599:1: ruleAccVarCS returns [EObject current=null] : ( ( (lv_accName_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_accType_2_0= rulePathNameCS ) ) )? otherlv_3= '=' ( (lv_accInitExp_4_0= ruleExpCS ) ) ) ;
    public final EObject ruleAccVarCS() throws RecognitionException {
        EObject current = null;

        Token lv_accName_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_accType_2_0 = null;

        EObject lv_accInitExp_4_0 = null;



        	enterRule();

        try {
            // InternalMiniOCLCS.g:1605:2: ( ( ( (lv_accName_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_accType_2_0= rulePathNameCS ) ) )? otherlv_3= '=' ( (lv_accInitExp_4_0= ruleExpCS ) ) ) )
            // InternalMiniOCLCS.g:1606:2: ( ( (lv_accName_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_accType_2_0= rulePathNameCS ) ) )? otherlv_3= '=' ( (lv_accInitExp_4_0= ruleExpCS ) ) )
            {
            // InternalMiniOCLCS.g:1606:2: ( ( (lv_accName_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_accType_2_0= rulePathNameCS ) ) )? otherlv_3= '=' ( (lv_accInitExp_4_0= ruleExpCS ) ) )
            // InternalMiniOCLCS.g:1607:3: ( (lv_accName_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_accType_2_0= rulePathNameCS ) ) )? otherlv_3= '=' ( (lv_accInitExp_4_0= ruleExpCS ) )
            {
            // InternalMiniOCLCS.g:1607:3: ( (lv_accName_0_0= RULE_ID ) )
            // InternalMiniOCLCS.g:1608:4: (lv_accName_0_0= RULE_ID )
            {
            // InternalMiniOCLCS.g:1608:4: (lv_accName_0_0= RULE_ID )
            // InternalMiniOCLCS.g:1609:5: lv_accName_0_0= RULE_ID
            {
            lv_accName_0_0=(Token)match(input,RULE_ID,FOLLOW_30); if (state.failed) return current;
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

            // InternalMiniOCLCS.g:1625:3: (otherlv_1= ':' ( (lv_accType_2_0= rulePathNameCS ) ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==12) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalMiniOCLCS.g:1626:4: otherlv_1= ':' ( (lv_accType_2_0= rulePathNameCS ) )
                    {
                    otherlv_1=(Token)match(input,12,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getAccVarCSAccess().getColonKeyword_1_0());
                      			
                    }
                    // InternalMiniOCLCS.g:1630:4: ( (lv_accType_2_0= rulePathNameCS ) )
                    // InternalMiniOCLCS.g:1631:5: (lv_accType_2_0= rulePathNameCS )
                    {
                    // InternalMiniOCLCS.g:1631:5: (lv_accType_2_0= rulePathNameCS )
                    // InternalMiniOCLCS.g:1632:6: lv_accType_2_0= rulePathNameCS
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAccVarCSAccess().getAccTypePathNameCSParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_21);
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

            otherlv_3=(Token)match(input,29,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getAccVarCSAccess().getEqualsSignKeyword_2());
              		
            }
            // InternalMiniOCLCS.g:1654:3: ( (lv_accInitExp_4_0= ruleExpCS ) )
            // InternalMiniOCLCS.g:1655:4: (lv_accInitExp_4_0= ruleExpCS )
            {
            // InternalMiniOCLCS.g:1655:4: (lv_accInitExp_4_0= ruleExpCS )
            // InternalMiniOCLCS.g:1656:5: lv_accInitExp_4_0= ruleExpCS
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
    // InternalMiniOCLCS.g:1677:1: entryRuleNameExpCS returns [EObject current=null] : iv_ruleNameExpCS= ruleNameExpCS EOF ;
    public final EObject entryRuleNameExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNameExpCS = null;


        try {
            // InternalMiniOCLCS.g:1677:50: (iv_ruleNameExpCS= ruleNameExpCS EOF )
            // InternalMiniOCLCS.g:1678:2: iv_ruleNameExpCS= ruleNameExpCS EOF
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
    // InternalMiniOCLCS.g:1684:1: ruleNameExpCS returns [EObject current=null] : ( ( (lv_expName_0_0= rulePathNameCS ) ) ( (lv_roundedBrackets_1_0= ruleRoundedBracketClauseCS ) )? ) ;
    public final EObject ruleNameExpCS() throws RecognitionException {
        EObject current = null;

        EObject lv_expName_0_0 = null;

        EObject lv_roundedBrackets_1_0 = null;



        	enterRule();

        try {
            // InternalMiniOCLCS.g:1690:2: ( ( ( (lv_expName_0_0= rulePathNameCS ) ) ( (lv_roundedBrackets_1_0= ruleRoundedBracketClauseCS ) )? ) )
            // InternalMiniOCLCS.g:1691:2: ( ( (lv_expName_0_0= rulePathNameCS ) ) ( (lv_roundedBrackets_1_0= ruleRoundedBracketClauseCS ) )? )
            {
            // InternalMiniOCLCS.g:1691:2: ( ( (lv_expName_0_0= rulePathNameCS ) ) ( (lv_roundedBrackets_1_0= ruleRoundedBracketClauseCS ) )? )
            // InternalMiniOCLCS.g:1692:3: ( (lv_expName_0_0= rulePathNameCS ) ) ( (lv_roundedBrackets_1_0= ruleRoundedBracketClauseCS ) )?
            {
            // InternalMiniOCLCS.g:1692:3: ( (lv_expName_0_0= rulePathNameCS ) )
            // InternalMiniOCLCS.g:1693:4: (lv_expName_0_0= rulePathNameCS )
            {
            // InternalMiniOCLCS.g:1693:4: (lv_expName_0_0= rulePathNameCS )
            // InternalMiniOCLCS.g:1694:5: lv_expName_0_0= rulePathNameCS
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getNameExpCSAccess().getExpNamePathNameCSParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_31);
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

            // InternalMiniOCLCS.g:1711:3: ( (lv_roundedBrackets_1_0= ruleRoundedBracketClauseCS ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==26) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalMiniOCLCS.g:1712:4: (lv_roundedBrackets_1_0= ruleRoundedBracketClauseCS )
                    {
                    // InternalMiniOCLCS.g:1712:4: (lv_roundedBrackets_1_0= ruleRoundedBracketClauseCS )
                    // InternalMiniOCLCS.g:1713:5: lv_roundedBrackets_1_0= ruleRoundedBracketClauseCS
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
    // InternalMiniOCLCS.g:1734:1: entryRuleRoundedBracketClauseCS returns [EObject current=null] : iv_ruleRoundedBracketClauseCS= ruleRoundedBracketClauseCS EOF ;
    public final EObject entryRuleRoundedBracketClauseCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRoundedBracketClauseCS = null;


        try {
            // InternalMiniOCLCS.g:1734:63: (iv_ruleRoundedBracketClauseCS= ruleRoundedBracketClauseCS EOF )
            // InternalMiniOCLCS.g:1735:2: iv_ruleRoundedBracketClauseCS= ruleRoundedBracketClauseCS EOF
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
    // InternalMiniOCLCS.g:1741:1: ruleRoundedBracketClauseCS returns [EObject current=null] : ( () otherlv_1= '(' ( ( (lv_args_2_0= ruleExpCS ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpCS ) ) )* )? otherlv_5= ')' ) ;
    public final EObject ruleRoundedBracketClauseCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_args_2_0 = null;

        EObject lv_args_4_0 = null;



        	enterRule();

        try {
            // InternalMiniOCLCS.g:1747:2: ( ( () otherlv_1= '(' ( ( (lv_args_2_0= ruleExpCS ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpCS ) ) )* )? otherlv_5= ')' ) )
            // InternalMiniOCLCS.g:1748:2: ( () otherlv_1= '(' ( ( (lv_args_2_0= ruleExpCS ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpCS ) ) )* )? otherlv_5= ')' )
            {
            // InternalMiniOCLCS.g:1748:2: ( () otherlv_1= '(' ( ( (lv_args_2_0= ruleExpCS ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpCS ) ) )* )? otherlv_5= ')' )
            // InternalMiniOCLCS.g:1749:3: () otherlv_1= '(' ( ( (lv_args_2_0= ruleExpCS ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpCS ) ) )* )? otherlv_5= ')'
            {
            // InternalMiniOCLCS.g:1749:3: ()
            // InternalMiniOCLCS.g:1750:4: 
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

            otherlv_1=(Token)match(input,26,FOLLOW_32); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getRoundedBracketClauseCSAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalMiniOCLCS.g:1763:3: ( ( (lv_args_2_0= ruleExpCS ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpCS ) ) )* )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==RULE_ID||LA24_0==RULE_INT||LA24_0==35||(LA24_0>=39 && LA24_0<=42)||LA24_0==45) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalMiniOCLCS.g:1764:4: ( (lv_args_2_0= ruleExpCS ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpCS ) ) )*
                    {
                    // InternalMiniOCLCS.g:1764:4: ( (lv_args_2_0= ruleExpCS ) )
                    // InternalMiniOCLCS.g:1765:5: (lv_args_2_0= ruleExpCS )
                    {
                    // InternalMiniOCLCS.g:1765:5: (lv_args_2_0= ruleExpCS )
                    // InternalMiniOCLCS.g:1766:6: lv_args_2_0= ruleExpCS
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getRoundedBracketClauseCSAccess().getArgsExpCSParserRuleCall_2_0_0());
                      					
                    }
                    pushFollow(FOLLOW_20);
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

                    // InternalMiniOCLCS.g:1783:4: (otherlv_3= ',' ( (lv_args_4_0= ruleExpCS ) ) )*
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==27) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // InternalMiniOCLCS.g:1784:5: otherlv_3= ',' ( (lv_args_4_0= ruleExpCS ) )
                    	    {
                    	    otherlv_3=(Token)match(input,27,FOLLOW_22); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_3, grammarAccess.getRoundedBracketClauseCSAccess().getCommaKeyword_2_1_0());
                    	      				
                    	    }
                    	    // InternalMiniOCLCS.g:1788:5: ( (lv_args_4_0= ruleExpCS ) )
                    	    // InternalMiniOCLCS.g:1789:6: (lv_args_4_0= ruleExpCS )
                    	    {
                    	    // InternalMiniOCLCS.g:1789:6: (lv_args_4_0= ruleExpCS )
                    	    // InternalMiniOCLCS.g:1790:7: lv_args_4_0= ruleExpCS
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getRoundedBracketClauseCSAccess().getArgsExpCSParserRuleCall_2_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_20);
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
                    	    break loop23;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,28,FOLLOW_2); if (state.failed) return current;
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
    // InternalMiniOCLCS.g:1817:1: entryRuleLiteralExpCS returns [EObject current=null] : iv_ruleLiteralExpCS= ruleLiteralExpCS EOF ;
    public final EObject entryRuleLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralExpCS = null;


        try {
            // InternalMiniOCLCS.g:1817:53: (iv_ruleLiteralExpCS= ruleLiteralExpCS EOF )
            // InternalMiniOCLCS.g:1818:2: iv_ruleLiteralExpCS= ruleLiteralExpCS EOF
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
    // InternalMiniOCLCS.g:1824:1: ruleLiteralExpCS returns [EObject current=null] : (this_IntLiteralExpCS_0= ruleIntLiteralExpCS | this_BooleanLiteralExpCS_1= ruleBooleanLiteralExpCS | this_NullLiteralExpCS_2= ruleNullLiteralExpCS | this_CollectionLiteralExpCS_3= ruleCollectionLiteralExpCS ) ;
    public final EObject ruleLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_IntLiteralExpCS_0 = null;

        EObject this_BooleanLiteralExpCS_1 = null;

        EObject this_NullLiteralExpCS_2 = null;

        EObject this_CollectionLiteralExpCS_3 = null;



        	enterRule();

        try {
            // InternalMiniOCLCS.g:1830:2: ( (this_IntLiteralExpCS_0= ruleIntLiteralExpCS | this_BooleanLiteralExpCS_1= ruleBooleanLiteralExpCS | this_NullLiteralExpCS_2= ruleNullLiteralExpCS | this_CollectionLiteralExpCS_3= ruleCollectionLiteralExpCS ) )
            // InternalMiniOCLCS.g:1831:2: (this_IntLiteralExpCS_0= ruleIntLiteralExpCS | this_BooleanLiteralExpCS_1= ruleBooleanLiteralExpCS | this_NullLiteralExpCS_2= ruleNullLiteralExpCS | this_CollectionLiteralExpCS_3= ruleCollectionLiteralExpCS )
            {
            // InternalMiniOCLCS.g:1831:2: (this_IntLiteralExpCS_0= ruleIntLiteralExpCS | this_BooleanLiteralExpCS_1= ruleBooleanLiteralExpCS | this_NullLiteralExpCS_2= ruleNullLiteralExpCS | this_CollectionLiteralExpCS_3= ruleCollectionLiteralExpCS )
            int alt25=4;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt25=1;
                }
                break;
            case 39:
            case 40:
                {
                alt25=2;
                }
                break;
            case 41:
                {
                alt25=3;
                }
                break;
            case 45:
                {
                alt25=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }

            switch (alt25) {
                case 1 :
                    // InternalMiniOCLCS.g:1832:3: this_IntLiteralExpCS_0= ruleIntLiteralExpCS
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
                    // InternalMiniOCLCS.g:1844:3: this_BooleanLiteralExpCS_1= ruleBooleanLiteralExpCS
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
                    // InternalMiniOCLCS.g:1856:3: this_NullLiteralExpCS_2= ruleNullLiteralExpCS
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
                    // InternalMiniOCLCS.g:1868:3: this_CollectionLiteralExpCS_3= ruleCollectionLiteralExpCS
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
    // InternalMiniOCLCS.g:1883:1: entryRuleIntLiteralExpCS returns [EObject current=null] : iv_ruleIntLiteralExpCS= ruleIntLiteralExpCS EOF ;
    public final EObject entryRuleIntLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntLiteralExpCS = null;


        try {
            // InternalMiniOCLCS.g:1883:56: (iv_ruleIntLiteralExpCS= ruleIntLiteralExpCS EOF )
            // InternalMiniOCLCS.g:1884:2: iv_ruleIntLiteralExpCS= ruleIntLiteralExpCS EOF
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
    // InternalMiniOCLCS.g:1890:1: ruleIntLiteralExpCS returns [EObject current=null] : ( (lv_intSymbol_0_0= RULE_INT ) ) ;
    public final EObject ruleIntLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token lv_intSymbol_0_0=null;


        	enterRule();

        try {
            // InternalMiniOCLCS.g:1896:2: ( ( (lv_intSymbol_0_0= RULE_INT ) ) )
            // InternalMiniOCLCS.g:1897:2: ( (lv_intSymbol_0_0= RULE_INT ) )
            {
            // InternalMiniOCLCS.g:1897:2: ( (lv_intSymbol_0_0= RULE_INT ) )
            // InternalMiniOCLCS.g:1898:3: (lv_intSymbol_0_0= RULE_INT )
            {
            // InternalMiniOCLCS.g:1898:3: (lv_intSymbol_0_0= RULE_INT )
            // InternalMiniOCLCS.g:1899:4: lv_intSymbol_0_0= RULE_INT
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
    // InternalMiniOCLCS.g:1918:1: entryRuleBooleanLiteralExpCS returns [EObject current=null] : iv_ruleBooleanLiteralExpCS= ruleBooleanLiteralExpCS EOF ;
    public final EObject entryRuleBooleanLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteralExpCS = null;


        try {
            // InternalMiniOCLCS.g:1918:60: (iv_ruleBooleanLiteralExpCS= ruleBooleanLiteralExpCS EOF )
            // InternalMiniOCLCS.g:1919:2: iv_ruleBooleanLiteralExpCS= ruleBooleanLiteralExpCS EOF
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
    // InternalMiniOCLCS.g:1925:1: ruleBooleanLiteralExpCS returns [EObject current=null] : ( () ( ( (lv_boolSymbol_1_0= 'true' ) ) | otherlv_2= 'false' ) ) ;
    public final EObject ruleBooleanLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token lv_boolSymbol_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalMiniOCLCS.g:1931:2: ( ( () ( ( (lv_boolSymbol_1_0= 'true' ) ) | otherlv_2= 'false' ) ) )
            // InternalMiniOCLCS.g:1932:2: ( () ( ( (lv_boolSymbol_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            {
            // InternalMiniOCLCS.g:1932:2: ( () ( ( (lv_boolSymbol_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            // InternalMiniOCLCS.g:1933:3: () ( ( (lv_boolSymbol_1_0= 'true' ) ) | otherlv_2= 'false' )
            {
            // InternalMiniOCLCS.g:1933:3: ()
            // InternalMiniOCLCS.g:1934:4: 
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

            // InternalMiniOCLCS.g:1943:3: ( ( (lv_boolSymbol_1_0= 'true' ) ) | otherlv_2= 'false' )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==39) ) {
                alt26=1;
            }
            else if ( (LA26_0==40) ) {
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
                    // InternalMiniOCLCS.g:1944:4: ( (lv_boolSymbol_1_0= 'true' ) )
                    {
                    // InternalMiniOCLCS.g:1944:4: ( (lv_boolSymbol_1_0= 'true' ) )
                    // InternalMiniOCLCS.g:1945:5: (lv_boolSymbol_1_0= 'true' )
                    {
                    // InternalMiniOCLCS.g:1945:5: (lv_boolSymbol_1_0= 'true' )
                    // InternalMiniOCLCS.g:1946:6: lv_boolSymbol_1_0= 'true'
                    {
                    lv_boolSymbol_1_0=(Token)match(input,39,FOLLOW_2); if (state.failed) return current;
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
                    // InternalMiniOCLCS.g:1959:4: otherlv_2= 'false'
                    {
                    otherlv_2=(Token)match(input,40,FOLLOW_2); if (state.failed) return current;
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
    // InternalMiniOCLCS.g:1968:1: entryRuleNullLiteralExpCS returns [EObject current=null] : iv_ruleNullLiteralExpCS= ruleNullLiteralExpCS EOF ;
    public final EObject entryRuleNullLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullLiteralExpCS = null;


        try {
            // InternalMiniOCLCS.g:1968:57: (iv_ruleNullLiteralExpCS= ruleNullLiteralExpCS EOF )
            // InternalMiniOCLCS.g:1969:2: iv_ruleNullLiteralExpCS= ruleNullLiteralExpCS EOF
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
    // InternalMiniOCLCS.g:1975:1: ruleNullLiteralExpCS returns [EObject current=null] : ( () otherlv_1= 'null' ) ;
    public final EObject ruleNullLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalMiniOCLCS.g:1981:2: ( ( () otherlv_1= 'null' ) )
            // InternalMiniOCLCS.g:1982:2: ( () otherlv_1= 'null' )
            {
            // InternalMiniOCLCS.g:1982:2: ( () otherlv_1= 'null' )
            // InternalMiniOCLCS.g:1983:3: () otherlv_1= 'null'
            {
            // InternalMiniOCLCS.g:1983:3: ()
            // InternalMiniOCLCS.g:1984:4: 
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

            otherlv_1=(Token)match(input,41,FOLLOW_2); if (state.failed) return current;
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
    // InternalMiniOCLCS.g:2001:1: entryRuleCollectionLiteralExpCS returns [EObject current=null] : iv_ruleCollectionLiteralExpCS= ruleCollectionLiteralExpCS EOF ;
    public final EObject entryRuleCollectionLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionLiteralExpCS = null;


        try {
            // InternalMiniOCLCS.g:2001:63: (iv_ruleCollectionLiteralExpCS= ruleCollectionLiteralExpCS EOF )
            // InternalMiniOCLCS.g:2002:2: iv_ruleCollectionLiteralExpCS= ruleCollectionLiteralExpCS EOF
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
    // InternalMiniOCLCS.g:2008:1: ruleCollectionLiteralExpCS returns [EObject current=null] : ( ( (lv_kind_0_0= ruleCollectionKindCS ) ) otherlv_1= '{' ( (lv_parts_2_0= ruleCollectionLiteralPartCS ) )* otherlv_3= '}' ) ;
    public final EObject ruleCollectionLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Enumerator lv_kind_0_0 = null;

        EObject lv_parts_2_0 = null;



        	enterRule();

        try {
            // InternalMiniOCLCS.g:2014:2: ( ( ( (lv_kind_0_0= ruleCollectionKindCS ) ) otherlv_1= '{' ( (lv_parts_2_0= ruleCollectionLiteralPartCS ) )* otherlv_3= '}' ) )
            // InternalMiniOCLCS.g:2015:2: ( ( (lv_kind_0_0= ruleCollectionKindCS ) ) otherlv_1= '{' ( (lv_parts_2_0= ruleCollectionLiteralPartCS ) )* otherlv_3= '}' )
            {
            // InternalMiniOCLCS.g:2015:2: ( ( (lv_kind_0_0= ruleCollectionKindCS ) ) otherlv_1= '{' ( (lv_parts_2_0= ruleCollectionLiteralPartCS ) )* otherlv_3= '}' )
            // InternalMiniOCLCS.g:2016:3: ( (lv_kind_0_0= ruleCollectionKindCS ) ) otherlv_1= '{' ( (lv_parts_2_0= ruleCollectionLiteralPartCS ) )* otherlv_3= '}'
            {
            // InternalMiniOCLCS.g:2016:3: ( (lv_kind_0_0= ruleCollectionKindCS ) )
            // InternalMiniOCLCS.g:2017:4: (lv_kind_0_0= ruleCollectionKindCS )
            {
            // InternalMiniOCLCS.g:2017:4: (lv_kind_0_0= ruleCollectionKindCS )
            // InternalMiniOCLCS.g:2018:5: lv_kind_0_0= ruleCollectionKindCS
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getCollectionLiteralExpCSAccess().getKindCollectionKindCSEnumRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_9);
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

            otherlv_1=(Token)match(input,15,FOLLOW_33); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getCollectionLiteralExpCSAccess().getLeftCurlyBracketKeyword_1());
              		
            }
            // InternalMiniOCLCS.g:2039:3: ( (lv_parts_2_0= ruleCollectionLiteralPartCS ) )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==RULE_ID||LA27_0==RULE_INT||LA27_0==35||(LA27_0>=39 && LA27_0<=42)||LA27_0==45) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalMiniOCLCS.g:2040:4: (lv_parts_2_0= ruleCollectionLiteralPartCS )
            	    {
            	    // InternalMiniOCLCS.g:2040:4: (lv_parts_2_0= ruleCollectionLiteralPartCS )
            	    // InternalMiniOCLCS.g:2041:5: lv_parts_2_0= ruleCollectionLiteralPartCS
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getCollectionLiteralExpCSAccess().getPartsCollectionLiteralPartCSParserRuleCall_2_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_33);
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
            	    break loop27;
                }
            } while (true);

            otherlv_3=(Token)match(input,16,FOLLOW_2); if (state.failed) return current;
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
    // InternalMiniOCLCS.g:2066:1: entryRuleCollectionLiteralPartCS returns [EObject current=null] : iv_ruleCollectionLiteralPartCS= ruleCollectionLiteralPartCS EOF ;
    public final EObject entryRuleCollectionLiteralPartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionLiteralPartCS = null;


        try {
            // InternalMiniOCLCS.g:2066:64: (iv_ruleCollectionLiteralPartCS= ruleCollectionLiteralPartCS EOF )
            // InternalMiniOCLCS.g:2067:2: iv_ruleCollectionLiteralPartCS= ruleCollectionLiteralPartCS EOF
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
    // InternalMiniOCLCS.g:2073:1: ruleCollectionLiteralPartCS returns [EObject current=null] : ( ( (lv_first_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_last_2_0= ruleExpCS ) ) )? ) ;
    public final EObject ruleCollectionLiteralPartCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_first_0_0 = null;

        EObject lv_last_2_0 = null;



        	enterRule();

        try {
            // InternalMiniOCLCS.g:2079:2: ( ( ( (lv_first_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_last_2_0= ruleExpCS ) ) )? ) )
            // InternalMiniOCLCS.g:2080:2: ( ( (lv_first_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_last_2_0= ruleExpCS ) ) )? )
            {
            // InternalMiniOCLCS.g:2080:2: ( ( (lv_first_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_last_2_0= ruleExpCS ) ) )? )
            // InternalMiniOCLCS.g:2081:3: ( (lv_first_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_last_2_0= ruleExpCS ) ) )?
            {
            // InternalMiniOCLCS.g:2081:3: ( (lv_first_0_0= ruleExpCS ) )
            // InternalMiniOCLCS.g:2082:4: (lv_first_0_0= ruleExpCS )
            {
            // InternalMiniOCLCS.g:2082:4: (lv_first_0_0= ruleExpCS )
            // InternalMiniOCLCS.g:2083:5: lv_first_0_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getCollectionLiteralPartCSAccess().getFirstExpCSParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_34);
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

            // InternalMiniOCLCS.g:2100:3: (otherlv_1= '..' ( (lv_last_2_0= ruleExpCS ) ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==23) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalMiniOCLCS.g:2101:4: otherlv_1= '..' ( (lv_last_2_0= ruleExpCS ) )
                    {
                    otherlv_1=(Token)match(input,23,FOLLOW_22); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getCollectionLiteralPartCSAccess().getFullStopFullStopKeyword_1_0());
                      			
                    }
                    // InternalMiniOCLCS.g:2105:4: ( (lv_last_2_0= ruleExpCS ) )
                    // InternalMiniOCLCS.g:2106:5: (lv_last_2_0= ruleExpCS )
                    {
                    // InternalMiniOCLCS.g:2106:5: (lv_last_2_0= ruleExpCS )
                    // InternalMiniOCLCS.g:2107:6: lv_last_2_0= ruleExpCS
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
    // InternalMiniOCLCS.g:2129:1: entryRuleLetExpCS returns [EObject current=null] : iv_ruleLetExpCS= ruleLetExpCS EOF ;
    public final EObject entryRuleLetExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLetExpCS = null;


        try {
            // InternalMiniOCLCS.g:2129:49: (iv_ruleLetExpCS= ruleLetExpCS EOF )
            // InternalMiniOCLCS.g:2130:2: iv_ruleLetExpCS= ruleLetExpCS EOF
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
    // InternalMiniOCLCS.g:2136:1: ruleLetExpCS returns [EObject current=null] : (otherlv_0= 'let' ( (lv_letVars_1_0= ruleLetVarCS ) ) (otherlv_2= ',' ( (lv_letVars_3_0= ruleLetVarCS ) ) )* otherlv_4= 'in' ( (lv_inExp_5_0= ruleExpCS ) ) ) ;
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
            // InternalMiniOCLCS.g:2142:2: ( (otherlv_0= 'let' ( (lv_letVars_1_0= ruleLetVarCS ) ) (otherlv_2= ',' ( (lv_letVars_3_0= ruleLetVarCS ) ) )* otherlv_4= 'in' ( (lv_inExp_5_0= ruleExpCS ) ) ) )
            // InternalMiniOCLCS.g:2143:2: (otherlv_0= 'let' ( (lv_letVars_1_0= ruleLetVarCS ) ) (otherlv_2= ',' ( (lv_letVars_3_0= ruleLetVarCS ) ) )* otherlv_4= 'in' ( (lv_inExp_5_0= ruleExpCS ) ) )
            {
            // InternalMiniOCLCS.g:2143:2: (otherlv_0= 'let' ( (lv_letVars_1_0= ruleLetVarCS ) ) (otherlv_2= ',' ( (lv_letVars_3_0= ruleLetVarCS ) ) )* otherlv_4= 'in' ( (lv_inExp_5_0= ruleExpCS ) ) )
            // InternalMiniOCLCS.g:2144:3: otherlv_0= 'let' ( (lv_letVars_1_0= ruleLetVarCS ) ) (otherlv_2= ',' ( (lv_letVars_3_0= ruleLetVarCS ) ) )* otherlv_4= 'in' ( (lv_inExp_5_0= ruleExpCS ) )
            {
            otherlv_0=(Token)match(input,42,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getLetExpCSAccess().getLetKeyword_0());
              		
            }
            // InternalMiniOCLCS.g:2148:3: ( (lv_letVars_1_0= ruleLetVarCS ) )
            // InternalMiniOCLCS.g:2149:4: (lv_letVars_1_0= ruleLetVarCS )
            {
            // InternalMiniOCLCS.g:2149:4: (lv_letVars_1_0= ruleLetVarCS )
            // InternalMiniOCLCS.g:2150:5: lv_letVars_1_0= ruleLetVarCS
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getLetExpCSAccess().getLetVarsLetVarCSParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_35);
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

            // InternalMiniOCLCS.g:2167:3: (otherlv_2= ',' ( (lv_letVars_3_0= ruleLetVarCS ) ) )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==27) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalMiniOCLCS.g:2168:4: otherlv_2= ',' ( (lv_letVars_3_0= ruleLetVarCS ) )
            	    {
            	    otherlv_2=(Token)match(input,27,FOLLOW_5); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getLetExpCSAccess().getCommaKeyword_2_0());
            	      			
            	    }
            	    // InternalMiniOCLCS.g:2172:4: ( (lv_letVars_3_0= ruleLetVarCS ) )
            	    // InternalMiniOCLCS.g:2173:5: (lv_letVars_3_0= ruleLetVarCS )
            	    {
            	    // InternalMiniOCLCS.g:2173:5: (lv_letVars_3_0= ruleLetVarCS )
            	    // InternalMiniOCLCS.g:2174:6: lv_letVars_3_0= ruleLetVarCS
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getLetExpCSAccess().getLetVarsLetVarCSParserRuleCall_2_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_35);
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
            	    break loop29;
                }
            } while (true);

            otherlv_4=(Token)match(input,43,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getLetExpCSAccess().getInKeyword_3());
              		
            }
            // InternalMiniOCLCS.g:2196:3: ( (lv_inExp_5_0= ruleExpCS ) )
            // InternalMiniOCLCS.g:2197:4: (lv_inExp_5_0= ruleExpCS )
            {
            // InternalMiniOCLCS.g:2197:4: (lv_inExp_5_0= ruleExpCS )
            // InternalMiniOCLCS.g:2198:5: lv_inExp_5_0= ruleExpCS
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
    // InternalMiniOCLCS.g:2219:1: entryRuleLetVarCS returns [EObject current=null] : iv_ruleLetVarCS= ruleLetVarCS EOF ;
    public final EObject entryRuleLetVarCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLetVarCS = null;


        try {
            // InternalMiniOCLCS.g:2219:49: (iv_ruleLetVarCS= ruleLetVarCS EOF )
            // InternalMiniOCLCS.g:2220:2: iv_ruleLetVarCS= ruleLetVarCS EOF
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
    // InternalMiniOCLCS.g:2226:1: ruleLetVarCS returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_typeRef_2_0= rulePathNameCS ) ) )? otherlv_3= '=' ( (lv_initExp_4_0= ruleExpCS ) ) ) ;
    public final EObject ruleLetVarCS() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_typeRef_2_0 = null;

        EObject lv_initExp_4_0 = null;



        	enterRule();

        try {
            // InternalMiniOCLCS.g:2232:2: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_typeRef_2_0= rulePathNameCS ) ) )? otherlv_3= '=' ( (lv_initExp_4_0= ruleExpCS ) ) ) )
            // InternalMiniOCLCS.g:2233:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_typeRef_2_0= rulePathNameCS ) ) )? otherlv_3= '=' ( (lv_initExp_4_0= ruleExpCS ) ) )
            {
            // InternalMiniOCLCS.g:2233:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_typeRef_2_0= rulePathNameCS ) ) )? otherlv_3= '=' ( (lv_initExp_4_0= ruleExpCS ) ) )
            // InternalMiniOCLCS.g:2234:3: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_typeRef_2_0= rulePathNameCS ) ) )? otherlv_3= '=' ( (lv_initExp_4_0= ruleExpCS ) )
            {
            // InternalMiniOCLCS.g:2234:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalMiniOCLCS.g:2235:4: (lv_name_0_0= RULE_ID )
            {
            // InternalMiniOCLCS.g:2235:4: (lv_name_0_0= RULE_ID )
            // InternalMiniOCLCS.g:2236:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_30); if (state.failed) return current;
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

            // InternalMiniOCLCS.g:2252:3: (otherlv_1= ':' ( (lv_typeRef_2_0= rulePathNameCS ) ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==12) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalMiniOCLCS.g:2253:4: otherlv_1= ':' ( (lv_typeRef_2_0= rulePathNameCS ) )
                    {
                    otherlv_1=(Token)match(input,12,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getLetVarCSAccess().getColonKeyword_1_0());
                      			
                    }
                    // InternalMiniOCLCS.g:2257:4: ( (lv_typeRef_2_0= rulePathNameCS ) )
                    // InternalMiniOCLCS.g:2258:5: (lv_typeRef_2_0= rulePathNameCS )
                    {
                    // InternalMiniOCLCS.g:2258:5: (lv_typeRef_2_0= rulePathNameCS )
                    // InternalMiniOCLCS.g:2259:6: lv_typeRef_2_0= rulePathNameCS
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getLetVarCSAccess().getTypeRefPathNameCSParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_21);
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

            otherlv_3=(Token)match(input,29,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getLetVarCSAccess().getEqualsSignKeyword_2());
              		
            }
            // InternalMiniOCLCS.g:2281:3: ( (lv_initExp_4_0= ruleExpCS ) )
            // InternalMiniOCLCS.g:2282:4: (lv_initExp_4_0= ruleExpCS )
            {
            // InternalMiniOCLCS.g:2282:4: (lv_initExp_4_0= ruleExpCS )
            // InternalMiniOCLCS.g:2283:5: lv_initExp_4_0= ruleExpCS
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
    // InternalMiniOCLCS.g:2304:1: entryRulePathNameCS returns [EObject current=null] : iv_rulePathNameCS= rulePathNameCS EOF ;
    public final EObject entryRulePathNameCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePathNameCS = null;


        try {
            // InternalMiniOCLCS.g:2304:51: (iv_rulePathNameCS= rulePathNameCS EOF )
            // InternalMiniOCLCS.g:2305:2: iv_rulePathNameCS= rulePathNameCS EOF
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
    // InternalMiniOCLCS.g:2311:1: rulePathNameCS returns [EObject current=null] : ( ( (lv_pathElements_0_0= rulePathElementCS ) ) (otherlv_1= '::' ( (lv_pathElements_2_0= rulePathElementCS ) ) )* ) ;
    public final EObject rulePathNameCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_pathElements_0_0 = null;

        EObject lv_pathElements_2_0 = null;



        	enterRule();

        try {
            // InternalMiniOCLCS.g:2317:2: ( ( ( (lv_pathElements_0_0= rulePathElementCS ) ) (otherlv_1= '::' ( (lv_pathElements_2_0= rulePathElementCS ) ) )* ) )
            // InternalMiniOCLCS.g:2318:2: ( ( (lv_pathElements_0_0= rulePathElementCS ) ) (otherlv_1= '::' ( (lv_pathElements_2_0= rulePathElementCS ) ) )* )
            {
            // InternalMiniOCLCS.g:2318:2: ( ( (lv_pathElements_0_0= rulePathElementCS ) ) (otherlv_1= '::' ( (lv_pathElements_2_0= rulePathElementCS ) ) )* )
            // InternalMiniOCLCS.g:2319:3: ( (lv_pathElements_0_0= rulePathElementCS ) ) (otherlv_1= '::' ( (lv_pathElements_2_0= rulePathElementCS ) ) )*
            {
            // InternalMiniOCLCS.g:2319:3: ( (lv_pathElements_0_0= rulePathElementCS ) )
            // InternalMiniOCLCS.g:2320:4: (lv_pathElements_0_0= rulePathElementCS )
            {
            // InternalMiniOCLCS.g:2320:4: (lv_pathElements_0_0= rulePathElementCS )
            // InternalMiniOCLCS.g:2321:5: lv_pathElements_0_0= rulePathElementCS
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPathNameCSAccess().getPathElementsPathElementCSParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_36);
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

            // InternalMiniOCLCS.g:2338:3: (otherlv_1= '::' ( (lv_pathElements_2_0= rulePathElementCS ) ) )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==44) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalMiniOCLCS.g:2339:4: otherlv_1= '::' ( (lv_pathElements_2_0= rulePathElementCS ) )
            	    {
            	    otherlv_1=(Token)match(input,44,FOLLOW_5); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getPathNameCSAccess().getColonColonKeyword_1_0());
            	      			
            	    }
            	    // InternalMiniOCLCS.g:2343:4: ( (lv_pathElements_2_0= rulePathElementCS ) )
            	    // InternalMiniOCLCS.g:2344:5: (lv_pathElements_2_0= rulePathElementCS )
            	    {
            	    // InternalMiniOCLCS.g:2344:5: (lv_pathElements_2_0= rulePathElementCS )
            	    // InternalMiniOCLCS.g:2345:6: lv_pathElements_2_0= rulePathElementCS
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getPathNameCSAccess().getPathElementsPathElementCSParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_36);
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
            	    break loop31;
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
    // InternalMiniOCLCS.g:2367:1: entryRulePathElementCS returns [EObject current=null] : iv_rulePathElementCS= rulePathElementCS EOF ;
    public final EObject entryRulePathElementCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePathElementCS = null;


        try {
            // InternalMiniOCLCS.g:2367:54: (iv_rulePathElementCS= rulePathElementCS EOF )
            // InternalMiniOCLCS.g:2368:2: iv_rulePathElementCS= rulePathElementCS EOF
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
    // InternalMiniOCLCS.g:2374:1: rulePathElementCS returns [EObject current=null] : ( (lv_elementName_0_0= RULE_ID ) ) ;
    public final EObject rulePathElementCS() throws RecognitionException {
        EObject current = null;

        Token lv_elementName_0_0=null;


        	enterRule();

        try {
            // InternalMiniOCLCS.g:2380:2: ( ( (lv_elementName_0_0= RULE_ID ) ) )
            // InternalMiniOCLCS.g:2381:2: ( (lv_elementName_0_0= RULE_ID ) )
            {
            // InternalMiniOCLCS.g:2381:2: ( (lv_elementName_0_0= RULE_ID ) )
            // InternalMiniOCLCS.g:2382:3: (lv_elementName_0_0= RULE_ID )
            {
            // InternalMiniOCLCS.g:2382:3: (lv_elementName_0_0= RULE_ID )
            // InternalMiniOCLCS.g:2383:4: lv_elementName_0_0= RULE_ID
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
    // InternalMiniOCLCS.g:2402:1: ruleCollectionKindCS returns [Enumerator current=null] : (enumLiteral_0= 'Collection' ) ;
    public final Enumerator ruleCollectionKindCS() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;


        	enterRule();

        try {
            // InternalMiniOCLCS.g:2408:2: ( (enumLiteral_0= 'Collection' ) )
            // InternalMiniOCLCS.g:2409:2: (enumLiteral_0= 'Collection' )
            {
            // InternalMiniOCLCS.g:2409:2: (enumLiteral_0= 'Collection' )
            // InternalMiniOCLCS.g:2410:3: enumLiteral_0= 'Collection'
            {
            enumLiteral_0=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
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

    // $ANTLR start synpred18_InternalMiniOCLCS
    public final void synpred18_InternalMiniOCLCS_fragment() throws RecognitionException {   
        Token lv_opName_2_1=null;
        Token lv_opName_2_2=null;
        EObject lv_right_3_0 = null;


        // InternalMiniOCLCS.g:1027:4: ( () ( ( (lv_opName_2_1= '=' | lv_opName_2_2= '<>' ) ) ) ( (lv_right_3_0= ruleCallExpCS ) ) )
        // InternalMiniOCLCS.g:1027:4: () ( ( (lv_opName_2_1= '=' | lv_opName_2_2= '<>' ) ) ) ( (lv_right_3_0= ruleCallExpCS ) )
        {
        // InternalMiniOCLCS.g:1027:4: ()
        // InternalMiniOCLCS.g:1028:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        // InternalMiniOCLCS.g:1037:4: ( ( (lv_opName_2_1= '=' | lv_opName_2_2= '<>' ) ) )
        // InternalMiniOCLCS.g:1038:5: ( (lv_opName_2_1= '=' | lv_opName_2_2= '<>' ) )
        {
        // InternalMiniOCLCS.g:1038:5: ( (lv_opName_2_1= '=' | lv_opName_2_2= '<>' ) )
        // InternalMiniOCLCS.g:1039:6: (lv_opName_2_1= '=' | lv_opName_2_2= '<>' )
        {
        // InternalMiniOCLCS.g:1039:6: (lv_opName_2_1= '=' | lv_opName_2_2= '<>' )
        int alt33=2;
        int LA33_0 = input.LA(1);

        if ( (LA33_0==29) ) {
            alt33=1;
        }
        else if ( (LA33_0==32) ) {
            alt33=2;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 33, 0, input);

            throw nvae;
        }
        switch (alt33) {
            case 1 :
                // InternalMiniOCLCS.g:1040:7: lv_opName_2_1= '='
                {
                lv_opName_2_1=(Token)match(input,29,FOLLOW_22); if (state.failed) return ;

                }
                break;
            case 2 :
                // InternalMiniOCLCS.g:1051:7: lv_opName_2_2= '<>'
                {
                lv_opName_2_2=(Token)match(input,32,FOLLOW_22); if (state.failed) return ;

                }
                break;

        }


        }


        }

        // InternalMiniOCLCS.g:1064:4: ( (lv_right_3_0= ruleCallExpCS ) )
        // InternalMiniOCLCS.g:1065:5: (lv_right_3_0= ruleCallExpCS )
        {
        // InternalMiniOCLCS.g:1065:5: (lv_right_3_0= ruleCallExpCS )
        // InternalMiniOCLCS.g:1066:6: lv_right_3_0= ruleCallExpCS
        {
        if ( state.backtracking==0 ) {

          						newCompositeNode(grammarAccess.getEqualityExpCSAccess().getRightCallExpCSParserRuleCall_1_2_0());
          					
        }
        pushFollow(FOLLOW_2);
        lv_right_3_0=ruleCallExpCS();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred18_InternalMiniOCLCS

    // $ANTLR start synpred20_InternalMiniOCLCS
    public final void synpred20_InternalMiniOCLCS_fragment() throws RecognitionException {   
        Token lv_opName_2_1=null;
        Token lv_opName_2_2=null;
        EObject lv_navExp_3_0 = null;


        // InternalMiniOCLCS.g:1115:4: ( () ( ( (lv_opName_2_1= '.' | lv_opName_2_2= '->' ) ) ) ( (lv_navExp_3_0= ruleNavigationExpCS ) ) )
        // InternalMiniOCLCS.g:1115:4: () ( ( (lv_opName_2_1= '.' | lv_opName_2_2= '->' ) ) ) ( (lv_navExp_3_0= ruleNavigationExpCS ) )
        {
        // InternalMiniOCLCS.g:1115:4: ()
        // InternalMiniOCLCS.g:1116:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        // InternalMiniOCLCS.g:1125:4: ( ( (lv_opName_2_1= '.' | lv_opName_2_2= '->' ) ) )
        // InternalMiniOCLCS.g:1126:5: ( (lv_opName_2_1= '.' | lv_opName_2_2= '->' ) )
        {
        // InternalMiniOCLCS.g:1126:5: ( (lv_opName_2_1= '.' | lv_opName_2_2= '->' ) )
        // InternalMiniOCLCS.g:1127:6: (lv_opName_2_1= '.' | lv_opName_2_2= '->' )
        {
        // InternalMiniOCLCS.g:1127:6: (lv_opName_2_1= '.' | lv_opName_2_2= '->' )
        int alt34=2;
        int LA34_0 = input.LA(1);

        if ( (LA34_0==33) ) {
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
                // InternalMiniOCLCS.g:1128:7: lv_opName_2_1= '.'
                {
                lv_opName_2_1=(Token)match(input,33,FOLLOW_26); if (state.failed) return ;

                }
                break;
            case 2 :
                // InternalMiniOCLCS.g:1139:7: lv_opName_2_2= '->'
                {
                lv_opName_2_2=(Token)match(input,34,FOLLOW_26); if (state.failed) return ;

                }
                break;

        }


        }


        }

        // InternalMiniOCLCS.g:1152:4: ( (lv_navExp_3_0= ruleNavigationExpCS ) )
        // InternalMiniOCLCS.g:1153:5: (lv_navExp_3_0= ruleNavigationExpCS )
        {
        // InternalMiniOCLCS.g:1153:5: (lv_navExp_3_0= ruleNavigationExpCS )
        // InternalMiniOCLCS.g:1154:6: lv_navExp_3_0= ruleNavigationExpCS
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
    // $ANTLR end synpred20_InternalMiniOCLCS

    // Delegated rules

    public final boolean synpred20_InternalMiniOCLCS() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred20_InternalMiniOCLCS_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred18_InternalMiniOCLCS() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred18_InternalMiniOCLCS_fragment(); // can never throw exception
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
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000040004802L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000040004002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000034000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000048000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000002090000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000102000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000600040L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000400040L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000010000010L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000278800000050L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000080010000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000120000002L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000600000002L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000005000000010L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000020001000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000278810000050L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000278800010050L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000080008000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000100000000002L});

}