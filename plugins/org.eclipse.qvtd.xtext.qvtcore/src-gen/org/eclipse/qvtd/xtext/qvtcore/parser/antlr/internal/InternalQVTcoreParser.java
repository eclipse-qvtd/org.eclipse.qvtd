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
@SuppressWarnings("all")
public class InternalQVTcoreParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_SIMPLE_ID", "RULE_ESCAPED_ID", "RULE_INT", "RULE_SINGLE_QUOTED_STRING", "RULE_DOUBLE_QUOTED_STRING", "RULE_ML_SINGLE_QUOTED_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'transformation'", "'::'", "'{'", "';'", "'}'", "'imports'", "','", "'uses'", "'map'", "'in'", "'refines'", "'check'", "'enforce'", "'where'", "'('", "')'", "'|'", "':'", "'realize'", "'default'", "':='", "'query'", "'.'", "'e'", "'E'", "'+'", "'-'", "'not'", "'*'", "'/'", "'>'", "'<'", "'>='", "'<='", "'='", "'<>'", "'and'", "'or'", "'xor'", "'implies'", "'->'", "'Tuple'", "'Boolean'", "'Integer'", "'Real'", "'String'", "'UnlimitedNatural'", "'OclAny'", "'OclInvalid'", "'OclVoid'", "'Set'", "'Bag'", "'Sequence'", "'Collection'", "'OrderedSet'", "'..'", "'true'", "'false'", "'invalid'", "'null'", "'['", "']'", "'if'", "'then'", "'else'", "'endif'", "'let'", "'self'"
    };
    public static final int T__42=42;
    public static final int T__28=28;
    public static final int T__57=57;
    public static final int T__23=23;
    public static final int T__80=80;
    public static final int T__51=51;
    public static final int T__69=69;
    public static final int T__47=47;
    public static final int T__73=73;
    public static final int T__50=50;
    public static final int T__21=21;
    public static final int RULE_ML_SINGLE_QUOTED_STRING=9;
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
    public static final int RULE_DOUBLE_QUOTED_STRING=8;
    public static final int T__59=59;
    public static final int T__54=54;
    public static final int T__48=48;
    public static final int T__34=34;
    public static final int T__56=56;
    public static final int T__15=15;
    public static final int RULE_ML_COMMENT=10;
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
    public static final int T__14=14;
    public static final int T__33=33;
    public static final int T__22=22;
    public static final int T__77=77;
    public static final int T__55=55;
    public static final int T__29=29;
    public static final int T__45=45;
    public static final int RULE_ESCAPED_ID=5;
    public static final int RULE_WS=12;
    public static final int T__63=63;
    public static final int T__75=75;
    public static final int T__43=43;
    public static final int T__31=31;
    public static final int T__40=40;
    public static final int EOF=-1;
    public static final int T__53=53;
    public static final int T__16=16;
    public static final int T__32=32;
    public static final int T__38=38;
    public static final int T__76=76;
    public static final int T__37=37;
    public static final int RULE_ANY_OTHER=13;
    public static final int T__26=26;
    public static final int T__81=81;
    public static final int T__25=25;
    public static final int RULE_SL_COMMENT=11;
    public static final int T__60=60;
    public static final int T__41=41;
    public static final int T__71=71;
    public static final int T__18=18;

    // delegates
    // delegators


        public InternalQVTcoreParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalQVTcoreParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalQVTcoreParser.tokenNames; }
    public String getGrammarFileName() { return "../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g"; }



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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:73:1: entryRuleTopLevelCS returns [EObject current=null] : iv_ruleTopLevelCS= ruleTopLevelCS EOF ;
    public final EObject entryRuleTopLevelCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTopLevelCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:74:2: (iv_ruleTopLevelCS= ruleTopLevelCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:75:2: iv_ruleTopLevelCS= ruleTopLevelCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTopLevelCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTopLevelCS_in_entryRuleTopLevelCS81);
            iv_ruleTopLevelCS=ruleTopLevelCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTopLevelCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTopLevelCS91); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:82:1: ruleTopLevelCS returns [EObject current=null] : ( ( (lv_mappings_0_0= ruleMappingCS ) ) | ( (lv_transformations_1_0= ruleTransformationCS ) ) | ( (lv_queries_2_0= ruleQueryCS ) ) )* ;
    public final EObject ruleTopLevelCS() throws RecognitionException {
        EObject current = null;

        EObject lv_mappings_0_0 = null;

        EObject lv_transformations_1_0 = null;

        EObject lv_queries_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:85:28: ( ( ( (lv_mappings_0_0= ruleMappingCS ) ) | ( (lv_transformations_1_0= ruleTransformationCS ) ) | ( (lv_queries_2_0= ruleQueryCS ) ) )* )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:86:1: ( ( (lv_mappings_0_0= ruleMappingCS ) ) | ( (lv_transformations_1_0= ruleTransformationCS ) ) | ( (lv_queries_2_0= ruleQueryCS ) ) )*
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:86:1: ( ( (lv_mappings_0_0= ruleMappingCS ) ) | ( (lv_transformations_1_0= ruleTransformationCS ) ) | ( (lv_queries_2_0= ruleQueryCS ) ) )*
            loop1:
            do {
                int alt1=4;
                switch ( input.LA(1) ) {
                case 22:
                    {
                    alt1=1;
                    }
                    break;
                case 14:
                    {
                    alt1=2;
                    }
                    break;
                case 35:
                    {
                    alt1=3;
                    }
                    break;

                }

                switch (alt1) {
            	case 1 :
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:86:2: ( (lv_mappings_0_0= ruleMappingCS ) )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:86:2: ( (lv_mappings_0_0= ruleMappingCS ) )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:87:1: (lv_mappings_0_0= ruleMappingCS )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:87:1: (lv_mappings_0_0= ruleMappingCS )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:88:3: lv_mappings_0_0= ruleMappingCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTopLevelCSAccess().getMappingsMappingCSParserRuleCall_0_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleMappingCS_in_ruleTopLevelCS137);
            	    lv_mappings_0_0=ruleMappingCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getTopLevelCSRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"mappings",
            	              		lv_mappings_0_0, 
            	              		"MappingCS");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:105:6: ( (lv_transformations_1_0= ruleTransformationCS ) )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:105:6: ( (lv_transformations_1_0= ruleTransformationCS ) )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:106:1: (lv_transformations_1_0= ruleTransformationCS )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:106:1: (lv_transformations_1_0= ruleTransformationCS )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:107:3: lv_transformations_1_0= ruleTransformationCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTopLevelCSAccess().getTransformationsTransformationCSParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleTransformationCS_in_ruleTopLevelCS164);
            	    lv_transformations_1_0=ruleTransformationCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getTopLevelCSRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"transformations",
            	              		lv_transformations_1_0, 
            	              		"TransformationCS");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:124:6: ( (lv_queries_2_0= ruleQueryCS ) )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:124:6: ( (lv_queries_2_0= ruleQueryCS ) )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:125:1: (lv_queries_2_0= ruleQueryCS )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:125:1: (lv_queries_2_0= ruleQueryCS )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:126:3: lv_queries_2_0= ruleQueryCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTopLevelCSAccess().getQueriesQueryCSParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleQueryCS_in_ruleTopLevelCS191);
            	    lv_queries_2_0=ruleQueryCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getTopLevelCSRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"queries",
            	              		lv_queries_2_0, 
            	              		"QueryCS");
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
    // $ANTLR end "ruleTopLevelCS"


    // $ANTLR start "entryRuleTransformationCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:150:1: entryRuleTransformationCS returns [EObject current=null] : iv_ruleTransformationCS= ruleTransformationCS EOF ;
    public final EObject entryRuleTransformationCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransformationCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:151:2: (iv_ruleTransformationCS= ruleTransformationCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:152:2: iv_ruleTransformationCS= ruleTransformationCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTransformationCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTransformationCS_in_entryRuleTransformationCS228);
            iv_ruleTransformationCS=ruleTransformationCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTransformationCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTransformationCS238); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:159:1: ruleTransformationCS returns [EObject current=null] : (otherlv_0= 'transformation' ( ( ( ruleUnrestrictedName ) ) otherlv_2= '::' ( ( ( ruleUnreservedName ) ) otherlv_4= '::' )* )? ( (lv_name_5_0= ruleUnreservedName ) ) otherlv_6= '{' ( ( (lv_directions_7_0= ruleDirectionCS ) ) otherlv_8= ';' )* otherlv_9= '}' ) ;
    public final EObject ruleTransformationCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        AntlrDatatypeRuleToken lv_name_5_0 = null;

        EObject lv_directions_7_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:162:28: ( (otherlv_0= 'transformation' ( ( ( ruleUnrestrictedName ) ) otherlv_2= '::' ( ( ( ruleUnreservedName ) ) otherlv_4= '::' )* )? ( (lv_name_5_0= ruleUnreservedName ) ) otherlv_6= '{' ( ( (lv_directions_7_0= ruleDirectionCS ) ) otherlv_8= ';' )* otherlv_9= '}' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:163:1: (otherlv_0= 'transformation' ( ( ( ruleUnrestrictedName ) ) otherlv_2= '::' ( ( ( ruleUnreservedName ) ) otherlv_4= '::' )* )? ( (lv_name_5_0= ruleUnreservedName ) ) otherlv_6= '{' ( ( (lv_directions_7_0= ruleDirectionCS ) ) otherlv_8= ';' )* otherlv_9= '}' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:163:1: (otherlv_0= 'transformation' ( ( ( ruleUnrestrictedName ) ) otherlv_2= '::' ( ( ( ruleUnreservedName ) ) otherlv_4= '::' )* )? ( (lv_name_5_0= ruleUnreservedName ) ) otherlv_6= '{' ( ( (lv_directions_7_0= ruleDirectionCS ) ) otherlv_8= ';' )* otherlv_9= '}' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:163:3: otherlv_0= 'transformation' ( ( ( ruleUnrestrictedName ) ) otherlv_2= '::' ( ( ( ruleUnreservedName ) ) otherlv_4= '::' )* )? ( (lv_name_5_0= ruleUnreservedName ) ) otherlv_6= '{' ( ( (lv_directions_7_0= ruleDirectionCS ) ) otherlv_8= ';' )* otherlv_9= '}'
            {
            otherlv_0=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleTransformationCS275); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getTransformationCSAccess().getTransformationKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:167:1: ( ( ( ruleUnrestrictedName ) ) otherlv_2= '::' ( ( ( ruleUnreservedName ) ) otherlv_4= '::' )* )?
            int alt3=2;
            alt3 = dfa3.predict(input);
            switch (alt3) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:167:2: ( ( ruleUnrestrictedName ) ) otherlv_2= '::' ( ( ( ruleUnreservedName ) ) otherlv_4= '::' )*
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:167:2: ( ( ruleUnrestrictedName ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:168:1: ( ruleUnrestrictedName )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:168:1: ( ruleUnrestrictedName )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:169:3: ruleUnrestrictedName
                    {
                    if ( state.backtracking==0 ) {
                       
                      		  /* */ 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getTransformationCSRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTransformationCSAccess().getNamespaceNamespaceCrossReference_1_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleTransformationCS303);
                    ruleUnrestrictedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_2=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleTransformationCS315); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getTransformationCSAccess().getColonColonKeyword_1_1());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:189:1: ( ( ( ruleUnreservedName ) ) otherlv_4= '::' )*
                    loop2:
                    do {
                        int alt2=2;
                        alt2 = dfa2.predict(input);
                        switch (alt2) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:189:2: ( ( ruleUnreservedName ) ) otherlv_4= '::'
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:189:2: ( ( ruleUnreservedName ) )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:190:1: ( ruleUnreservedName )
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:190:1: ( ruleUnreservedName )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:191:3: ruleUnreservedName
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      		  /* */ 
                    	      		
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      			if (current==null) {
                    	      	            current = createModelElement(grammarAccess.getTransformationCSRule());
                    	      	        }
                    	              
                    	    }
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getTransformationCSAccess().getNamespaceNamespaceCrossReference_1_2_0_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleUnreservedName_in_ruleTransformationCS343);
                    	    ruleUnreservedName();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }

                    	    otherlv_4=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleTransformationCS355); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_4, grammarAccess.getTransformationCSAccess().getColonColonKeyword_1_2_1());
                    	          
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:211:5: ( (lv_name_5_0= ruleUnreservedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:212:1: (lv_name_5_0= ruleUnreservedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:212:1: (lv_name_5_0= ruleUnreservedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:213:3: lv_name_5_0= ruleUnreservedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTransformationCSAccess().getNameUnreservedNameParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnreservedName_in_ruleTransformationCS380);
            lv_name_5_0=ruleUnreservedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTransformationCSRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_5_0, 
                      		"UnreservedName");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_6=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleTransformationCS392); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getTransformationCSAccess().getLeftCurlyBracketKeyword_3());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:233:1: ( ( (lv_directions_7_0= ruleDirectionCS ) ) otherlv_8= ';' )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>=RULE_SIMPLE_ID && LA4_0<=RULE_ESCAPED_ID)||LA4_0==14||LA4_0==19||(LA4_0>=21 && LA4_0<=22)||(LA4_0>=24 && LA4_0<=27)||LA4_0==32||LA4_0==35||(LA4_0>=37 && LA4_0<=38)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:233:2: ( (lv_directions_7_0= ruleDirectionCS ) ) otherlv_8= ';'
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:233:2: ( (lv_directions_7_0= ruleDirectionCS ) )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:234:1: (lv_directions_7_0= ruleDirectionCS )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:234:1: (lv_directions_7_0= ruleDirectionCS )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:235:3: lv_directions_7_0= ruleDirectionCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTransformationCSAccess().getDirectionsDirectionCSParserRuleCall_4_0_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleDirectionCS_in_ruleTransformationCS414);
            	    lv_directions_7_0=ruleDirectionCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getTransformationCSRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"directions",
            	              		lv_directions_7_0, 
            	              		"DirectionCS");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    otherlv_8=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleTransformationCS426); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_8, grammarAccess.getTransformationCSAccess().getSemicolonKeyword_4_1());
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            otherlv_9=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleTransformationCS440); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_9, grammarAccess.getTransformationCSAccess().getRightCurlyBracketKeyword_5());
                  
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


    // $ANTLR start "entryRuleDirectionCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:267:1: entryRuleDirectionCS returns [EObject current=null] : iv_ruleDirectionCS= ruleDirectionCS EOF ;
    public final EObject entryRuleDirectionCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDirectionCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:268:2: (iv_ruleDirectionCS= ruleDirectionCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:269:2: iv_ruleDirectionCS= ruleDirectionCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDirectionCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleDirectionCS_in_entryRuleDirectionCS476);
            iv_ruleDirectionCS=ruleDirectionCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDirectionCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDirectionCS486); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:276:1: ruleDirectionCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= 'imports' ( ( ruleUnrestrictedName ) ) (otherlv_3= ',' ( ( ruleUnrestrictedName ) ) )* )? (otherlv_5= 'uses' ( ( ruleUnrestrictedName ) ) (otherlv_7= ',' ( ( ruleUnrestrictedName ) ) )* )? ) ;
    public final EObject ruleDirectionCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:279:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= 'imports' ( ( ruleUnrestrictedName ) ) (otherlv_3= ',' ( ( ruleUnrestrictedName ) ) )* )? (otherlv_5= 'uses' ( ( ruleUnrestrictedName ) ) (otherlv_7= ',' ( ( ruleUnrestrictedName ) ) )* )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:280:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= 'imports' ( ( ruleUnrestrictedName ) ) (otherlv_3= ',' ( ( ruleUnrestrictedName ) ) )* )? (otherlv_5= 'uses' ( ( ruleUnrestrictedName ) ) (otherlv_7= ',' ( ( ruleUnrestrictedName ) ) )* )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:280:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= 'imports' ( ( ruleUnrestrictedName ) ) (otherlv_3= ',' ( ( ruleUnrestrictedName ) ) )* )? (otherlv_5= 'uses' ( ( ruleUnrestrictedName ) ) (otherlv_7= ',' ( ( ruleUnrestrictedName ) ) )* )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:280:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= 'imports' ( ( ruleUnrestrictedName ) ) (otherlv_3= ',' ( ( ruleUnrestrictedName ) ) )* )? (otherlv_5= 'uses' ( ( ruleUnrestrictedName ) ) (otherlv_7= ',' ( ( ruleUnrestrictedName ) ) )* )?
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:280:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:281:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:281:1: (lv_name_0_0= ruleUnrestrictedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:282:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDirectionCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleDirectionCS532);
            lv_name_0_0=ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getDirectionCSRule());
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:298:2: (otherlv_1= 'imports' ( ( ruleUnrestrictedName ) ) (otherlv_3= ',' ( ( ruleUnrestrictedName ) ) )* )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==19) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:298:4: otherlv_1= 'imports' ( ( ruleUnrestrictedName ) ) (otherlv_3= ',' ( ( ruleUnrestrictedName ) ) )*
                    {
                    otherlv_1=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleDirectionCS545); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getDirectionCSAccess().getImportsKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:302:1: ( ( ruleUnrestrictedName ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:303:1: ( ruleUnrestrictedName )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:303:1: ( ruleUnrestrictedName )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:304:3: ruleUnrestrictedName
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
                       
                      	        newCompositeNode(grammarAccess.getDirectionCSAccess().getImportsPackageCrossReference_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleDirectionCS572);
                    ruleUnrestrictedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:320:2: (otherlv_3= ',' ( ( ruleUnrestrictedName ) ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==20) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:320:4: otherlv_3= ',' ( ( ruleUnrestrictedName ) )
                    	    {
                    	    otherlv_3=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleDirectionCS585); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getDirectionCSAccess().getCommaKeyword_1_2_0());
                    	          
                    	    }
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:324:1: ( ( ruleUnrestrictedName ) )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:325:1: ( ruleUnrestrictedName )
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:325:1: ( ruleUnrestrictedName )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:326:3: ruleUnrestrictedName
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
                    	       
                    	      	        newCompositeNode(grammarAccess.getDirectionCSAccess().getImportsPackageCrossReference_1_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleDirectionCS612);
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
                    	    break loop5;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:342:6: (otherlv_5= 'uses' ( ( ruleUnrestrictedName ) ) (otherlv_7= ',' ( ( ruleUnrestrictedName ) ) )* )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==21) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:342:8: otherlv_5= 'uses' ( ( ruleUnrestrictedName ) ) (otherlv_7= ',' ( ( ruleUnrestrictedName ) ) )*
                    {
                    otherlv_5=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleDirectionCS629); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getDirectionCSAccess().getUsesKeyword_2_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:346:1: ( ( ruleUnrestrictedName ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:347:1: ( ruleUnrestrictedName )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:347:1: ( ruleUnrestrictedName )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:348:3: ruleUnrestrictedName
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
                       
                      	        newCompositeNode(grammarAccess.getDirectionCSAccess().getUsesDirectionCSCrossReference_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleDirectionCS656);
                    ruleUnrestrictedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:364:2: (otherlv_7= ',' ( ( ruleUnrestrictedName ) ) )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==20) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:364:4: otherlv_7= ',' ( ( ruleUnrestrictedName ) )
                    	    {
                    	    otherlv_7=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleDirectionCS669); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_7, grammarAccess.getDirectionCSAccess().getCommaKeyword_2_2_0());
                    	          
                    	    }
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:368:1: ( ( ruleUnrestrictedName ) )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:369:1: ( ruleUnrestrictedName )
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:369:1: ( ruleUnrestrictedName )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:370:3: ruleUnrestrictedName
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
                    	       
                    	      	        newCompositeNode(grammarAccess.getDirectionCSAccess().getUsesDirectionCSCrossReference_2_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleDirectionCS696);
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
                    	    break loop7;
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


    // $ANTLR start "entryRuleMappingCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:394:1: entryRuleMappingCS returns [EObject current=null] : iv_ruleMappingCS= ruleMappingCS EOF ;
    public final EObject entryRuleMappingCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMappingCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:395:2: (iv_ruleMappingCS= ruleMappingCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:396:2: iv_ruleMappingCS= ruleMappingCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMappingCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMappingCS_in_entryRuleMappingCS736);
            iv_ruleMappingCS=ruleMappingCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMappingCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMappingCS746); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:403:1: ruleMappingCS returns [EObject current=null] : (otherlv_0= 'map' ( (lv_name_1_0= ruleUnrestrictedName ) ) (otherlv_2= 'in' ( ( ruleUnrestrictedName ) ) )? (otherlv_4= 'refines' ( ( ruleUnrestrictedName ) ) (otherlv_6= ',' ( ( ruleUnrestrictedName ) ) )* )? otherlv_8= '{' ( (otherlv_9= 'check' )? (otherlv_10= 'enforce' )? ruleDirectionNameCS ( (lv_domains_12_0= ruleDomainCS ) ) )* otherlv_13= 'where' ( (lv_domains_14_0= ruleDomainCS ) ) ( (lv_composedMappings_15_0= ruleComposedMappingCS ) )* otherlv_16= '}' ) ;
    public final EObject ruleMappingCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_13=null;
        Token otherlv_16=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_domains_12_0 = null;

        EObject lv_domains_14_0 = null;

        EObject lv_composedMappings_15_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:406:28: ( (otherlv_0= 'map' ( (lv_name_1_0= ruleUnrestrictedName ) ) (otherlv_2= 'in' ( ( ruleUnrestrictedName ) ) )? (otherlv_4= 'refines' ( ( ruleUnrestrictedName ) ) (otherlv_6= ',' ( ( ruleUnrestrictedName ) ) )* )? otherlv_8= '{' ( (otherlv_9= 'check' )? (otherlv_10= 'enforce' )? ruleDirectionNameCS ( (lv_domains_12_0= ruleDomainCS ) ) )* otherlv_13= 'where' ( (lv_domains_14_0= ruleDomainCS ) ) ( (lv_composedMappings_15_0= ruleComposedMappingCS ) )* otherlv_16= '}' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:407:1: (otherlv_0= 'map' ( (lv_name_1_0= ruleUnrestrictedName ) ) (otherlv_2= 'in' ( ( ruleUnrestrictedName ) ) )? (otherlv_4= 'refines' ( ( ruleUnrestrictedName ) ) (otherlv_6= ',' ( ( ruleUnrestrictedName ) ) )* )? otherlv_8= '{' ( (otherlv_9= 'check' )? (otherlv_10= 'enforce' )? ruleDirectionNameCS ( (lv_domains_12_0= ruleDomainCS ) ) )* otherlv_13= 'where' ( (lv_domains_14_0= ruleDomainCS ) ) ( (lv_composedMappings_15_0= ruleComposedMappingCS ) )* otherlv_16= '}' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:407:1: (otherlv_0= 'map' ( (lv_name_1_0= ruleUnrestrictedName ) ) (otherlv_2= 'in' ( ( ruleUnrestrictedName ) ) )? (otherlv_4= 'refines' ( ( ruleUnrestrictedName ) ) (otherlv_6= ',' ( ( ruleUnrestrictedName ) ) )* )? otherlv_8= '{' ( (otherlv_9= 'check' )? (otherlv_10= 'enforce' )? ruleDirectionNameCS ( (lv_domains_12_0= ruleDomainCS ) ) )* otherlv_13= 'where' ( (lv_domains_14_0= ruleDomainCS ) ) ( (lv_composedMappings_15_0= ruleComposedMappingCS ) )* otherlv_16= '}' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:407:3: otherlv_0= 'map' ( (lv_name_1_0= ruleUnrestrictedName ) ) (otherlv_2= 'in' ( ( ruleUnrestrictedName ) ) )? (otherlv_4= 'refines' ( ( ruleUnrestrictedName ) ) (otherlv_6= ',' ( ( ruleUnrestrictedName ) ) )* )? otherlv_8= '{' ( (otherlv_9= 'check' )? (otherlv_10= 'enforce' )? ruleDirectionNameCS ( (lv_domains_12_0= ruleDomainCS ) ) )* otherlv_13= 'where' ( (lv_domains_14_0= ruleDomainCS ) ) ( (lv_composedMappings_15_0= ruleComposedMappingCS ) )* otherlv_16= '}'
            {
            otherlv_0=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleMappingCS783); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMappingCSAccess().getMapKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:411:1: ( (lv_name_1_0= ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:412:1: (lv_name_1_0= ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:412:1: (lv_name_1_0= ruleUnrestrictedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:413:3: lv_name_1_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMappingCSAccess().getNameUnrestrictedNameParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleMappingCS804);
            lv_name_1_0=ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getMappingCSRule());
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:429:2: (otherlv_2= 'in' ( ( ruleUnrestrictedName ) ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==23) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:429:4: otherlv_2= 'in' ( ( ruleUnrestrictedName ) )
                    {
                    otherlv_2=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleMappingCS817); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getMappingCSAccess().getInKeyword_2_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:433:1: ( ( ruleUnrestrictedName ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:434:1: ( ruleUnrestrictedName )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:434:1: ( ruleUnrestrictedName )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:435:3: ruleUnrestrictedName
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
                       
                      	        newCompositeNode(grammarAccess.getMappingCSAccess().getInPackageCrossReference_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleMappingCS844);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:451:4: (otherlv_4= 'refines' ( ( ruleUnrestrictedName ) ) (otherlv_6= ',' ( ( ruleUnrestrictedName ) ) )* )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==24) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:451:6: otherlv_4= 'refines' ( ( ruleUnrestrictedName ) ) (otherlv_6= ',' ( ( ruleUnrestrictedName ) ) )*
                    {
                    otherlv_4=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleMappingCS859); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getMappingCSAccess().getRefinesKeyword_3_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:455:1: ( ( ruleUnrestrictedName ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:456:1: ( ruleUnrestrictedName )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:456:1: ( ruleUnrestrictedName )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:457:3: ruleUnrestrictedName
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
                       
                      	        newCompositeNode(grammarAccess.getMappingCSAccess().getRefinesMappingCrossReference_3_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleMappingCS886);
                    ruleUnrestrictedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:473:2: (otherlv_6= ',' ( ( ruleUnrestrictedName ) ) )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==20) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:473:4: otherlv_6= ',' ( ( ruleUnrestrictedName ) )
                    	    {
                    	    otherlv_6=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleMappingCS899); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_6, grammarAccess.getMappingCSAccess().getCommaKeyword_3_2_0());
                    	          
                    	    }
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:477:1: ( ( ruleUnrestrictedName ) )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:478:1: ( ruleUnrestrictedName )
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:478:1: ( ruleUnrestrictedName )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:479:3: ruleUnrestrictedName
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
                    	       
                    	      	        newCompositeNode(grammarAccess.getMappingCSAccess().getRefinesMappingCrossReference_3_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleMappingCS926);
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

            otherlv_8=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleMappingCS942); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getMappingCSAccess().getLeftCurlyBracketKeyword_4());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:499:1: ( (otherlv_9= 'check' )? (otherlv_10= 'enforce' )? ruleDirectionNameCS ( (lv_domains_12_0= ruleDomainCS ) ) )*
            loop14:
            do {
                int alt14=2;
                alt14 = dfa14.predict(input);
                switch (alt14) {
            	case 1 :
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:499:2: (otherlv_9= 'check' )? (otherlv_10= 'enforce' )? ruleDirectionNameCS ( (lv_domains_12_0= ruleDomainCS ) )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:499:2: (otherlv_9= 'check' )?
            	    int alt12=2;
            	    int LA12_0 = input.LA(1);

            	    if ( (LA12_0==25) ) {
            	        int LA12_1 = input.LA(2);

            	        if ( ((LA12_1>=RULE_SIMPLE_ID && LA12_1<=RULE_ESCAPED_ID)||LA12_1==14||LA12_1==19||(LA12_1>=21 && LA12_1<=22)||(LA12_1>=24 && LA12_1<=27)||LA12_1==32||LA12_1==35||(LA12_1>=37 && LA12_1<=38)) ) {
            	            alt12=1;
            	        }
            	    }
            	    switch (alt12) {
            	        case 1 :
            	            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:499:4: otherlv_9= 'check'
            	            {
            	            otherlv_9=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleMappingCS956); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_9, grammarAccess.getMappingCSAccess().getCheckKeyword_5_0());
            	                  
            	            }

            	            }
            	            break;

            	    }

            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:503:3: (otherlv_10= 'enforce' )?
            	    int alt13=2;
            	    int LA13_0 = input.LA(1);

            	    if ( (LA13_0==26) ) {
            	        int LA13_1 = input.LA(2);

            	        if ( ((LA13_1>=RULE_SIMPLE_ID && LA13_1<=RULE_ESCAPED_ID)||LA13_1==14||LA13_1==19||(LA13_1>=21 && LA13_1<=22)||(LA13_1>=24 && LA13_1<=27)||LA13_1==32||LA13_1==35||(LA13_1>=37 && LA13_1<=38)) ) {
            	            alt13=1;
            	        }
            	    }
            	    switch (alt13) {
            	        case 1 :
            	            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:503:5: otherlv_10= 'enforce'
            	            {
            	            otherlv_10=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleMappingCS971); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_10, grammarAccess.getMappingCSAccess().getEnforceKeyword_5_1());
            	                  
            	            }

            	            }
            	            break;

            	    }

            	    if ( state.backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getMappingCSAccess().getDirectionNameCSParserRuleCall_5_2()); 
            	          
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleDirectionNameCS_in_ruleMappingCS992);
            	    ruleDirectionNameCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	              afterParserOrEnumRuleCall();
            	          
            	    }
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:518:1: ( (lv_domains_12_0= ruleDomainCS ) )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:519:1: (lv_domains_12_0= ruleDomainCS )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:519:1: (lv_domains_12_0= ruleDomainCS )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:520:3: lv_domains_12_0= ruleDomainCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMappingCSAccess().getDomainsDomainCSParserRuleCall_5_3_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleDomainCS_in_ruleMappingCS1012);
            	    lv_domains_12_0=ruleDomainCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getMappingCSRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"domains",
            	              		lv_domains_12_0, 
            	              		"DomainCS");
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

            otherlv_13=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleMappingCS1026); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_13, grammarAccess.getMappingCSAccess().getWhereKeyword_6());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:540:1: ( (lv_domains_14_0= ruleDomainCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:541:1: (lv_domains_14_0= ruleDomainCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:541:1: (lv_domains_14_0= ruleDomainCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:542:3: lv_domains_14_0= ruleDomainCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMappingCSAccess().getDomainsDomainCSParserRuleCall_7_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleDomainCS_in_ruleMappingCS1047);
            lv_domains_14_0=ruleDomainCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getMappingCSRule());
              	        }
                     		add(
                     			current, 
                     			"domains",
                      		lv_domains_14_0, 
                      		"DomainCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:558:2: ( (lv_composedMappings_15_0= ruleComposedMappingCS ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==22) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:559:1: (lv_composedMappings_15_0= ruleComposedMappingCS )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:559:1: (lv_composedMappings_15_0= ruleComposedMappingCS )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:560:3: lv_composedMappings_15_0= ruleComposedMappingCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMappingCSAccess().getComposedMappingsComposedMappingCSParserRuleCall_8_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleComposedMappingCS_in_ruleMappingCS1068);
            	    lv_composedMappings_15_0=ruleComposedMappingCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getMappingCSRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"composedMappings",
            	              		lv_composedMappings_15_0, 
            	              		"ComposedMappingCS");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            otherlv_16=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleMappingCS1081); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_16, grammarAccess.getMappingCSAccess().getRightCurlyBracketKeyword_9());
                  
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


    // $ANTLR start "entryRuleDomainCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:588:1: entryRuleDomainCS returns [EObject current=null] : iv_ruleDomainCS= ruleDomainCS EOF ;
    public final EObject entryRuleDomainCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDomainCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:589:2: (iv_ruleDomainCS= ruleDomainCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:590:2: iv_ruleDomainCS= ruleDomainCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDomainCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleDomainCS_in_entryRuleDomainCS1117);
            iv_ruleDomainCS=ruleDomainCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDomainCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDomainCS1127); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDomainCS"


    // $ANTLR start "ruleDomainCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:597:1: ruleDomainCS returns [EObject current=null] : (otherlv_0= '(' ( (lv_guardPattern_1_0= ruleGuardPatternCS ) ) otherlv_2= ')' otherlv_3= '{' ( (lv_bottomPattern_4_0= ruleBottomPatternCS ) ) otherlv_5= '}' ) ;
    public final EObject ruleDomainCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_guardPattern_1_0 = null;

        EObject lv_bottomPattern_4_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:600:28: ( (otherlv_0= '(' ( (lv_guardPattern_1_0= ruleGuardPatternCS ) ) otherlv_2= ')' otherlv_3= '{' ( (lv_bottomPattern_4_0= ruleBottomPatternCS ) ) otherlv_5= '}' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:601:1: (otherlv_0= '(' ( (lv_guardPattern_1_0= ruleGuardPatternCS ) ) otherlv_2= ')' otherlv_3= '{' ( (lv_bottomPattern_4_0= ruleBottomPatternCS ) ) otherlv_5= '}' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:601:1: (otherlv_0= '(' ( (lv_guardPattern_1_0= ruleGuardPatternCS ) ) otherlv_2= ')' otherlv_3= '{' ( (lv_bottomPattern_4_0= ruleBottomPatternCS ) ) otherlv_5= '}' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:601:3: otherlv_0= '(' ( (lv_guardPattern_1_0= ruleGuardPatternCS ) ) otherlv_2= ')' otherlv_3= '{' ( (lv_bottomPattern_4_0= ruleBottomPatternCS ) ) otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleDomainCS1164); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getDomainCSAccess().getLeftParenthesisKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:605:1: ( (lv_guardPattern_1_0= ruleGuardPatternCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:606:1: (lv_guardPattern_1_0= ruleGuardPatternCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:606:1: (lv_guardPattern_1_0= ruleGuardPatternCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:607:3: lv_guardPattern_1_0= ruleGuardPatternCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDomainCSAccess().getGuardPatternGuardPatternCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleGuardPatternCS_in_ruleDomainCS1185);
            lv_guardPattern_1_0=ruleGuardPatternCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getDomainCSRule());
              	        }
                     		set(
                     			current, 
                     			"guardPattern",
                      		lv_guardPattern_1_0, 
                      		"GuardPatternCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleDomainCS1197); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getDomainCSAccess().getRightParenthesisKeyword_2());
                  
            }
            otherlv_3=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleDomainCS1209); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getDomainCSAccess().getLeftCurlyBracketKeyword_3());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:631:1: ( (lv_bottomPattern_4_0= ruleBottomPatternCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:632:1: (lv_bottomPattern_4_0= ruleBottomPatternCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:632:1: (lv_bottomPattern_4_0= ruleBottomPatternCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:633:3: lv_bottomPattern_4_0= ruleBottomPatternCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDomainCSAccess().getBottomPatternBottomPatternCSParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleBottomPatternCS_in_ruleDomainCS1230);
            lv_bottomPattern_4_0=ruleBottomPatternCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getDomainCSRule());
              	        }
                     		set(
                     			current, 
                     			"bottomPattern",
                      		lv_bottomPattern_4_0, 
                      		"BottomPatternCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_5=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleDomainCS1242); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getDomainCSAccess().getRightCurlyBracketKeyword_5());
                  
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
    // $ANTLR end "ruleDomainCS"


    // $ANTLR start "entryRuleComposedMappingCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:661:1: entryRuleComposedMappingCS returns [EObject current=null] : iv_ruleComposedMappingCS= ruleComposedMappingCS EOF ;
    public final EObject entryRuleComposedMappingCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComposedMappingCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:662:2: (iv_ruleComposedMappingCS= ruleComposedMappingCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:663:2: iv_ruleComposedMappingCS= ruleComposedMappingCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getComposedMappingCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleComposedMappingCS_in_entryRuleComposedMappingCS1278);
            iv_ruleComposedMappingCS=ruleComposedMappingCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleComposedMappingCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleComposedMappingCS1288); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleComposedMappingCS"


    // $ANTLR start "ruleComposedMappingCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:670:1: ruleComposedMappingCS returns [EObject current=null] : this_MappingCS_0= ruleMappingCS ;
    public final EObject ruleComposedMappingCS() throws RecognitionException {
        EObject current = null;

        EObject this_MappingCS_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:673:28: (this_MappingCS_0= ruleMappingCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:675:2: this_MappingCS_0= ruleMappingCS
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getComposedMappingCSAccess().getMappingCSParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleMappingCS_in_ruleComposedMappingCS1337);
            this_MappingCS_0=ruleMappingCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_MappingCS_0; 
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
    // $ANTLR end "ruleComposedMappingCS"


    // $ANTLR start "entryRuleGuardPatternCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:694:1: entryRuleGuardPatternCS returns [EObject current=null] : iv_ruleGuardPatternCS= ruleGuardPatternCS EOF ;
    public final EObject entryRuleGuardPatternCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGuardPatternCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:695:2: (iv_ruleGuardPatternCS= ruleGuardPatternCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:696:2: iv_ruleGuardPatternCS= ruleGuardPatternCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGuardPatternCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleGuardPatternCS_in_entryRuleGuardPatternCS1371);
            iv_ruleGuardPatternCS=ruleGuardPatternCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleGuardPatternCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleGuardPatternCS1381); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:703:1: ruleGuardPatternCS returns [EObject current=null] : ( () ( ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) (otherlv_2= ',' ( (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS ) ) )* otherlv_4= '|' )? ( ( (lv_constraints_5_0= ruleConstraintCS ) ) otherlv_6= ';' )* ) ;
    public final EObject ruleGuardPatternCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_unrealizedVariables_1_0 = null;

        EObject lv_unrealizedVariables_3_0 = null;

        EObject lv_constraints_5_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:706:28: ( ( () ( ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) (otherlv_2= ',' ( (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS ) ) )* otherlv_4= '|' )? ( ( (lv_constraints_5_0= ruleConstraintCS ) ) otherlv_6= ';' )* ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:707:1: ( () ( ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) (otherlv_2= ',' ( (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS ) ) )* otherlv_4= '|' )? ( ( (lv_constraints_5_0= ruleConstraintCS ) ) otherlv_6= ';' )* )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:707:1: ( () ( ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) (otherlv_2= ',' ( (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS ) ) )* otherlv_4= '|' )? ( ( (lv_constraints_5_0= ruleConstraintCS ) ) otherlv_6= ';' )* )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:707:2: () ( ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) (otherlv_2= ',' ( (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS ) ) )* otherlv_4= '|' )? ( ( (lv_constraints_5_0= ruleConstraintCS ) ) otherlv_6= ';' )*
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:707:2: ()
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:708:2: 
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:716:2: ( ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) (otherlv_2= ',' ( (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS ) ) )* otherlv_4= '|' )?
            int alt17=2;
            alt17 = dfa17.predict(input);
            switch (alt17) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:716:3: ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) (otherlv_2= ',' ( (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS ) ) )* otherlv_4= '|'
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:716:3: ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:717:1: (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:717:1: (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:718:3: lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getGuardPatternCSAccess().getUnrealizedVariablesUnrealizedVariableCSParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUnrealizedVariableCS_in_ruleGuardPatternCS1440);
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

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:734:2: (otherlv_2= ',' ( (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS ) ) )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==20) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:734:4: otherlv_2= ',' ( (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS ) )
                    	    {
                    	    otherlv_2=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleGuardPatternCS1453); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_2, grammarAccess.getGuardPatternCSAccess().getCommaKeyword_1_1_0());
                    	          
                    	    }
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:738:1: ( (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS ) )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:739:1: (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS )
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:739:1: (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:740:3: lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getGuardPatternCSAccess().getUnrealizedVariablesUnrealizedVariableCSParserRuleCall_1_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleUnrealizedVariableCS_in_ruleGuardPatternCS1474);
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
                    	    break loop16;
                        }
                    } while (true);

                    otherlv_4=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleGuardPatternCS1488); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getGuardPatternCSAccess().getVerticalLineKeyword_1_2());
                          
                    }

                    }
                    break;

            }

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:760:3: ( ( (lv_constraints_5_0= ruleConstraintCS ) ) otherlv_6= ';' )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0>=RULE_SIMPLE_ID && LA18_0<=RULE_SINGLE_QUOTED_STRING)||LA18_0==14||LA18_0==19||(LA18_0>=21 && LA18_0<=22)||(LA18_0>=24 && LA18_0<=28)||(LA18_0>=32 && LA18_0<=33)||LA18_0==35||(LA18_0>=37 && LA18_0<=38)||(LA18_0>=40 && LA18_0<=42)||(LA18_0>=55 && LA18_0<=68)||(LA18_0>=70 && LA18_0<=73)||LA18_0==76||(LA18_0>=80 && LA18_0<=81)) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:760:4: ( (lv_constraints_5_0= ruleConstraintCS ) ) otherlv_6= ';'
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:760:4: ( (lv_constraints_5_0= ruleConstraintCS ) )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:761:1: (lv_constraints_5_0= ruleConstraintCS )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:761:1: (lv_constraints_5_0= ruleConstraintCS )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:762:3: lv_constraints_5_0= ruleConstraintCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getGuardPatternCSAccess().getConstraintsConstraintCSParserRuleCall_2_0_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleConstraintCS_in_ruleGuardPatternCS1512);
            	    lv_constraints_5_0=ruleConstraintCS();

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
            	              		"ConstraintCS");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    otherlv_6=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleGuardPatternCS1524); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_6, grammarAccess.getGuardPatternCSAccess().getSemicolonKeyword_2_1());
            	          
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
    // $ANTLR end "ruleGuardPatternCS"


    // $ANTLR start "entryRuleBottomPatternCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:790:1: entryRuleBottomPatternCS returns [EObject current=null] : iv_ruleBottomPatternCS= ruleBottomPatternCS EOF ;
    public final EObject entryRuleBottomPatternCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBottomPatternCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:791:2: (iv_ruleBottomPatternCS= ruleBottomPatternCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:792:2: iv_ruleBottomPatternCS= ruleBottomPatternCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBottomPatternCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleBottomPatternCS_in_entryRuleBottomPatternCS1562);
            iv_ruleBottomPatternCS=ruleBottomPatternCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBottomPatternCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBottomPatternCS1572); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:799:1: ruleBottomPatternCS returns [EObject current=null] : ( () ( ( ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_2_0= ruleRealizedVariableCS ) ) ) (otherlv_3= ',' ( ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) ) ) )* otherlv_6= '|' )? ( ( (lv_constraints_7_0= ruleConstraintCS ) ) otherlv_8= ';' )* ) ;
    public final EObject ruleBottomPatternCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_3=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_unrealizedVariables_1_0 = null;

        EObject lv_realizedVariables_2_0 = null;

        EObject lv_unrealizedVariables_4_0 = null;

        EObject lv_realizedVariables_5_0 = null;

        EObject lv_constraints_7_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:802:28: ( ( () ( ( ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_2_0= ruleRealizedVariableCS ) ) ) (otherlv_3= ',' ( ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) ) ) )* otherlv_6= '|' )? ( ( (lv_constraints_7_0= ruleConstraintCS ) ) otherlv_8= ';' )* ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:803:1: ( () ( ( ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_2_0= ruleRealizedVariableCS ) ) ) (otherlv_3= ',' ( ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) ) ) )* otherlv_6= '|' )? ( ( (lv_constraints_7_0= ruleConstraintCS ) ) otherlv_8= ';' )* )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:803:1: ( () ( ( ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_2_0= ruleRealizedVariableCS ) ) ) (otherlv_3= ',' ( ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) ) ) )* otherlv_6= '|' )? ( ( (lv_constraints_7_0= ruleConstraintCS ) ) otherlv_8= ';' )* )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:803:2: () ( ( ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_2_0= ruleRealizedVariableCS ) ) ) (otherlv_3= ',' ( ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) ) ) )* otherlv_6= '|' )? ( ( (lv_constraints_7_0= ruleConstraintCS ) ) otherlv_8= ';' )*
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:803:2: ()
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:804:2: 
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:812:2: ( ( ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_2_0= ruleRealizedVariableCS ) ) ) (otherlv_3= ',' ( ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) ) ) )* otherlv_6= '|' )?
            int alt22=2;
            alt22 = dfa22.predict(input);
            switch (alt22) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:812:3: ( ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_2_0= ruleRealizedVariableCS ) ) ) (otherlv_3= ',' ( ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) ) ) )* otherlv_6= '|'
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:812:3: ( ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_2_0= ruleRealizedVariableCS ) ) )
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( ((LA19_0>=RULE_SIMPLE_ID && LA19_0<=RULE_ESCAPED_ID)||LA19_0==14||LA19_0==19||(LA19_0>=21 && LA19_0<=22)||(LA19_0>=24 && LA19_0<=27)||LA19_0==35||(LA19_0>=37 && LA19_0<=38)) ) {
                        alt19=1;
                    }
                    else if ( (LA19_0==32) ) {
                        int LA19_2 = input.LA(2);

                        if ( ((LA19_2>=RULE_SIMPLE_ID && LA19_2<=RULE_ESCAPED_ID)||LA19_2==14||LA19_2==19||(LA19_2>=21 && LA19_2<=22)||(LA19_2>=24 && LA19_2<=27)||LA19_2==32||LA19_2==35||(LA19_2>=37 && LA19_2<=38)) ) {
                            alt19=2;
                        }
                        else if ( (LA19_2==31) ) {
                            alt19=1;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 19, 2, input);

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
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:812:4: ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:812:4: ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:813:1: (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:813:1: (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:814:3: lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getBottomPatternCSAccess().getUnrealizedVariablesUnrealizedVariableCSParserRuleCall_1_0_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleUnrealizedVariableCS_in_ruleBottomPatternCS1632);
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
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:831:6: ( (lv_realizedVariables_2_0= ruleRealizedVariableCS ) )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:831:6: ( (lv_realizedVariables_2_0= ruleRealizedVariableCS ) )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:832:1: (lv_realizedVariables_2_0= ruleRealizedVariableCS )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:832:1: (lv_realizedVariables_2_0= ruleRealizedVariableCS )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:833:3: lv_realizedVariables_2_0= ruleRealizedVariableCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getBottomPatternCSAccess().getRealizedVariablesRealizedVariableCSParserRuleCall_1_0_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleRealizedVariableCS_in_ruleBottomPatternCS1659);
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

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:849:3: (otherlv_3= ',' ( ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) ) ) )*
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0==20) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:849:5: otherlv_3= ',' ( ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) ) )
                    	    {
                    	    otherlv_3=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleBottomPatternCS1673); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getBottomPatternCSAccess().getCommaKeyword_1_1_0());
                    	          
                    	    }
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:853:1: ( ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) ) )
                    	    int alt20=2;
                    	    int LA20_0 = input.LA(1);

                    	    if ( ((LA20_0>=RULE_SIMPLE_ID && LA20_0<=RULE_ESCAPED_ID)||LA20_0==14||LA20_0==19||(LA20_0>=21 && LA20_0<=22)||(LA20_0>=24 && LA20_0<=27)||LA20_0==35||(LA20_0>=37 && LA20_0<=38)) ) {
                    	        alt20=1;
                    	    }
                    	    else if ( (LA20_0==32) ) {
                    	        int LA20_2 = input.LA(2);

                    	        if ( (LA20_2==31) ) {
                    	            alt20=1;
                    	        }
                    	        else if ( ((LA20_2>=RULE_SIMPLE_ID && LA20_2<=RULE_ESCAPED_ID)||LA20_2==14||LA20_2==19||(LA20_2>=21 && LA20_2<=22)||(LA20_2>=24 && LA20_2<=27)||LA20_2==32||LA20_2==35||(LA20_2>=37 && LA20_2<=38)) ) {
                    	            alt20=2;
                    	        }
                    	        else {
                    	            if (state.backtracking>0) {state.failed=true; return current;}
                    	            NoViableAltException nvae =
                    	                new NoViableAltException("", 20, 2, input);

                    	            throw nvae;
                    	        }
                    	    }
                    	    else {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 20, 0, input);

                    	        throw nvae;
                    	    }
                    	    switch (alt20) {
                    	        case 1 :
                    	            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:853:2: ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) )
                    	            {
                    	            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:853:2: ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) )
                    	            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:854:1: (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS )
                    	            {
                    	            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:854:1: (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS )
                    	            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:855:3: lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS
                    	            {
                    	            if ( state.backtracking==0 ) {
                    	               
                    	              	        newCompositeNode(grammarAccess.getBottomPatternCSAccess().getUnrealizedVariablesUnrealizedVariableCSParserRuleCall_1_1_1_0_0()); 
                    	              	    
                    	            }
                    	            pushFollow(FollowSets000.FOLLOW_ruleUnrealizedVariableCS_in_ruleBottomPatternCS1695);
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
                    	            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:872:6: ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) )
                    	            {
                    	            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:872:6: ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) )
                    	            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:873:1: (lv_realizedVariables_5_0= ruleRealizedVariableCS )
                    	            {
                    	            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:873:1: (lv_realizedVariables_5_0= ruleRealizedVariableCS )
                    	            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:874:3: lv_realizedVariables_5_0= ruleRealizedVariableCS
                    	            {
                    	            if ( state.backtracking==0 ) {
                    	               
                    	              	        newCompositeNode(grammarAccess.getBottomPatternCSAccess().getRealizedVariablesRealizedVariableCSParserRuleCall_1_1_1_1_0()); 
                    	              	    
                    	            }
                    	            pushFollow(FollowSets000.FOLLOW_ruleRealizedVariableCS_in_ruleBottomPatternCS1722);
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
                    	    break loop21;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleBottomPatternCS1737); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getBottomPatternCSAccess().getVerticalLineKeyword_1_2());
                          
                    }

                    }
                    break;

            }

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:894:3: ( ( (lv_constraints_7_0= ruleConstraintCS ) ) otherlv_8= ';' )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( ((LA23_0>=RULE_SIMPLE_ID && LA23_0<=RULE_SINGLE_QUOTED_STRING)||LA23_0==14||LA23_0==19||(LA23_0>=21 && LA23_0<=22)||(LA23_0>=24 && LA23_0<=28)||(LA23_0>=32 && LA23_0<=33)||LA23_0==35||(LA23_0>=37 && LA23_0<=38)||(LA23_0>=40 && LA23_0<=42)||(LA23_0>=55 && LA23_0<=68)||(LA23_0>=70 && LA23_0<=73)||LA23_0==76||(LA23_0>=80 && LA23_0<=81)) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:894:4: ( (lv_constraints_7_0= ruleConstraintCS ) ) otherlv_8= ';'
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:894:4: ( (lv_constraints_7_0= ruleConstraintCS ) )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:895:1: (lv_constraints_7_0= ruleConstraintCS )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:895:1: (lv_constraints_7_0= ruleConstraintCS )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:896:3: lv_constraints_7_0= ruleConstraintCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getBottomPatternCSAccess().getConstraintsConstraintCSParserRuleCall_2_0_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleConstraintCS_in_ruleBottomPatternCS1761);
            	    lv_constraints_7_0=ruleConstraintCS();

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
            	              		"ConstraintCS");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    otherlv_8=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleBottomPatternCS1773); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_8, grammarAccess.getBottomPatternCSAccess().getSemicolonKeyword_2_1());
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop23;
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


    // $ANTLR start "entryRuleUnrealizedVariableCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:924:1: entryRuleUnrealizedVariableCS returns [EObject current=null] : iv_ruleUnrealizedVariableCS= ruleUnrealizedVariableCS EOF ;
    public final EObject entryRuleUnrealizedVariableCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnrealizedVariableCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:925:2: (iv_ruleUnrealizedVariableCS= ruleUnrealizedVariableCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:926:2: iv_ruleUnrealizedVariableCS= ruleUnrealizedVariableCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnrealizedVariableCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrealizedVariableCS_in_entryRuleUnrealizedVariableCS1811);
            iv_ruleUnrealizedVariableCS=ruleUnrealizedVariableCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnrealizedVariableCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnrealizedVariableCS1821); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:933:1: ruleUnrealizedVariableCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleVariableNameCS ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) ) ;
    public final EObject ruleUnrealizedVariableCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:936:28: ( ( ( (lv_name_0_0= ruleVariableNameCS ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:937:1: ( ( (lv_name_0_0= ruleVariableNameCS ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:937:1: ( ( (lv_name_0_0= ruleVariableNameCS ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:937:2: ( (lv_name_0_0= ruleVariableNameCS ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:937:2: ( (lv_name_0_0= ruleVariableNameCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:938:1: (lv_name_0_0= ruleVariableNameCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:938:1: (lv_name_0_0= ruleVariableNameCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:939:3: lv_name_0_0= ruleVariableNameCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getUnrealizedVariableCSAccess().getNameVariableNameCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVariableNameCS_in_ruleUnrealizedVariableCS1867);
            lv_name_0_0=ruleVariableNameCS();

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
                      		"VariableNameCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleUnrealizedVariableCS1879); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getUnrealizedVariableCSAccess().getColonKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:959:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:960:1: (lv_ownedType_2_0= ruleTypeExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:960:1: (lv_ownedType_2_0= ruleTypeExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:961:3: lv_ownedType_2_0= ruleTypeExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getUnrealizedVariableCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleUnrealizedVariableCS1900);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:985:1: entryRuleRealizedVariableCS returns [EObject current=null] : iv_ruleRealizedVariableCS= ruleRealizedVariableCS EOF ;
    public final EObject entryRuleRealizedVariableCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealizedVariableCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:986:2: (iv_ruleRealizedVariableCS= ruleRealizedVariableCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:987:2: iv_ruleRealizedVariableCS= ruleRealizedVariableCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRealizedVariableCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleRealizedVariableCS_in_entryRuleRealizedVariableCS1936);
            iv_ruleRealizedVariableCS=ruleRealizedVariableCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRealizedVariableCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRealizedVariableCS1946); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:994:1: ruleRealizedVariableCS returns [EObject current=null] : (otherlv_0= 'realize' ( (lv_name_1_0= ruleVariableNameCS ) ) otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) ) ;
    public final EObject ruleRealizedVariableCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_ownedType_3_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:997:28: ( (otherlv_0= 'realize' ( (lv_name_1_0= ruleVariableNameCS ) ) otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:998:1: (otherlv_0= 'realize' ( (lv_name_1_0= ruleVariableNameCS ) ) otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:998:1: (otherlv_0= 'realize' ( (lv_name_1_0= ruleVariableNameCS ) ) otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:998:3: otherlv_0= 'realize' ( (lv_name_1_0= ruleVariableNameCS ) ) otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) )
            {
            otherlv_0=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleRealizedVariableCS1983); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getRealizedVariableCSAccess().getRealizeKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1002:1: ( (lv_name_1_0= ruleVariableNameCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1003:1: (lv_name_1_0= ruleVariableNameCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1003:1: (lv_name_1_0= ruleVariableNameCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1004:3: lv_name_1_0= ruleVariableNameCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRealizedVariableCSAccess().getNameVariableNameCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVariableNameCS_in_ruleRealizedVariableCS2004);
            lv_name_1_0=ruleVariableNameCS();

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
                      		"VariableNameCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleRealizedVariableCS2016); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getRealizedVariableCSAccess().getColonKeyword_2());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1024:1: ( (lv_ownedType_3_0= ruleTypeExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1025:1: (lv_ownedType_3_0= ruleTypeExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1025:1: (lv_ownedType_3_0= ruleTypeExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1026:3: lv_ownedType_3_0= ruleTypeExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRealizedVariableCSAccess().getOwnedTypeTypeExpCSParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleRealizedVariableCS2037);
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


    // $ANTLR start "entryRuleConstraintCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1050:1: entryRuleConstraintCS returns [EObject current=null] : iv_ruleConstraintCS= ruleConstraintCS EOF ;
    public final EObject entryRuleConstraintCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstraintCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1051:2: (iv_ruleConstraintCS= ruleConstraintCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1052:2: iv_ruleConstraintCS= ruleConstraintCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstraintCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleConstraintCS_in_entryRuleConstraintCS2073);
            iv_ruleConstraintCS=ruleConstraintCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConstraintCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleConstraintCS2083); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConstraintCS"


    // $ANTLR start "ruleConstraintCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1059:1: ruleConstraintCS returns [EObject current=null] : (this_PredicateCS_0= rulePredicateCS | this_AssignmentCS_1= ruleAssignmentCS ) ;
    public final EObject ruleConstraintCS() throws RecognitionException {
        EObject current = null;

        EObject this_PredicateCS_0 = null;

        EObject this_AssignmentCS_1 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1062:28: ( (this_PredicateCS_0= rulePredicateCS | this_AssignmentCS_1= ruleAssignmentCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1063:1: (this_PredicateCS_0= rulePredicateCS | this_AssignmentCS_1= ruleAssignmentCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1063:1: (this_PredicateCS_0= rulePredicateCS | this_AssignmentCS_1= ruleAssignmentCS )
            int alt24=2;
            alt24 = dfa24.predict(input);
            switch (alt24) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1064:2: this_PredicateCS_0= rulePredicateCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getConstraintCSAccess().getPredicateCSParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePredicateCS_in_ruleConstraintCS2133);
                    this_PredicateCS_0=rulePredicateCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_PredicateCS_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1077:2: this_AssignmentCS_1= ruleAssignmentCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getConstraintCSAccess().getAssignmentCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleAssignmentCS_in_ruleConstraintCS2163);
                    this_AssignmentCS_1=ruleAssignmentCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_AssignmentCS_1; 
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
    // $ANTLR end "ruleConstraintCS"


    // $ANTLR start "entryRulePredicateCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1096:1: entryRulePredicateCS returns [EObject current=null] : iv_rulePredicateCS= rulePredicateCS EOF ;
    public final EObject entryRulePredicateCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePredicateCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1097:2: (iv_rulePredicateCS= rulePredicateCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1098:2: iv_rulePredicateCS= rulePredicateCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPredicateCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePredicateCS_in_entryRulePredicateCS2198);
            iv_rulePredicateCS=rulePredicateCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePredicateCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePredicateCS2208); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1105:1: rulePredicateCS returns [EObject current=null] : this_ExpCS_0= ruleExpCS ;
    public final EObject rulePredicateCS() throws RecognitionException {
        EObject current = null;

        EObject this_ExpCS_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1108:28: (this_ExpCS_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1110:2: this_ExpCS_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getPredicateCSAccess().getExpCSParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_rulePredicateCS2257);
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
    // $ANTLR end "rulePredicateCS"


    // $ANTLR start "entryRuleAssignmentCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1129:1: entryRuleAssignmentCS returns [EObject current=null] : iv_ruleAssignmentCS= ruleAssignmentCS EOF ;
    public final EObject entryRuleAssignmentCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignmentCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1130:2: (iv_ruleAssignmentCS= ruleAssignmentCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1131:2: iv_ruleAssignmentCS= ruleAssignmentCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAssignmentCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAssignmentCS_in_entryRuleAssignmentCS2291);
            iv_ruleAssignmentCS=ruleAssignmentCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAssignmentCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAssignmentCS2301); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1138:1: ruleAssignmentCS returns [EObject current=null] : ( ( (lv_default_0_0= 'default' ) )? ( (lv_target_1_0= ruleExpCS ) ) otherlv_2= ':=' ( (lv_initialiser_3_0= ruleExpCS ) ) ) ;
    public final EObject ruleAssignmentCS() throws RecognitionException {
        EObject current = null;

        Token lv_default_0_0=null;
        Token otherlv_2=null;
        EObject lv_target_1_0 = null;

        EObject lv_initialiser_3_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1141:28: ( ( ( (lv_default_0_0= 'default' ) )? ( (lv_target_1_0= ruleExpCS ) ) otherlv_2= ':=' ( (lv_initialiser_3_0= ruleExpCS ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1142:1: ( ( (lv_default_0_0= 'default' ) )? ( (lv_target_1_0= ruleExpCS ) ) otherlv_2= ':=' ( (lv_initialiser_3_0= ruleExpCS ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1142:1: ( ( (lv_default_0_0= 'default' ) )? ( (lv_target_1_0= ruleExpCS ) ) otherlv_2= ':=' ( (lv_initialiser_3_0= ruleExpCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1142:2: ( (lv_default_0_0= 'default' ) )? ( (lv_target_1_0= ruleExpCS ) ) otherlv_2= ':=' ( (lv_initialiser_3_0= ruleExpCS ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1142:2: ( (lv_default_0_0= 'default' ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==33) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1143:1: (lv_default_0_0= 'default' )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1143:1: (lv_default_0_0= 'default' )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1144:3: lv_default_0_0= 'default'
                    {
                    lv_default_0_0=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleAssignmentCS2344); if (state.failed) return current;
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1157:3: ( (lv_target_1_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1158:1: (lv_target_1_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1158:1: (lv_target_1_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1159:3: lv_target_1_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAssignmentCSAccess().getTargetExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleAssignmentCS2379);
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

            otherlv_2=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleAssignmentCS2391); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getAssignmentCSAccess().getColonEqualsSignKeyword_2());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1179:1: ( (lv_initialiser_3_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1180:1: (lv_initialiser_3_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1180:1: (lv_initialiser_3_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1181:3: lv_initialiser_3_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAssignmentCSAccess().getInitialiserExpCSParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleAssignmentCS2412);
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


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
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


    // $ANTLR start "entryRuleDirectionNameCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1205:1: entryRuleDirectionNameCS returns [String current=null] : iv_ruleDirectionNameCS= ruleDirectionNameCS EOF ;
    public final String entryRuleDirectionNameCS() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDirectionNameCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1206:2: (iv_ruleDirectionNameCS= ruleDirectionNameCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1207:2: iv_ruleDirectionNameCS= ruleDirectionNameCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDirectionNameCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleDirectionNameCS_in_entryRuleDirectionNameCS2449);
            iv_ruleDirectionNameCS=ruleDirectionNameCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDirectionNameCS.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDirectionNameCS2460); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDirectionNameCS"


    // $ANTLR start "ruleDirectionNameCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1214:1: ruleDirectionNameCS returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_UnrestrictedName_0= ruleUnrestrictedName ;
    public final AntlrDatatypeRuleToken ruleDirectionNameCS() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_UnrestrictedName_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1217:28: (this_UnrestrictedName_0= ruleUnrestrictedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1219:5: this_UnrestrictedName_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getDirectionNameCSAccess().getUnrestrictedNameParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleDirectionNameCS2506);
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

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDirectionNameCS"


    // $ANTLR start "entryRuleVariableNameCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1239:1: entryRuleVariableNameCS returns [String current=null] : iv_ruleVariableNameCS= ruleVariableNameCS EOF ;
    public final String entryRuleVariableNameCS() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleVariableNameCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1240:2: (iv_ruleVariableNameCS= ruleVariableNameCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1241:2: iv_ruleVariableNameCS= ruleVariableNameCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVariableNameCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleVariableNameCS_in_entryRuleVariableNameCS2553);
            iv_ruleVariableNameCS=ruleVariableNameCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVariableNameCS.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleVariableNameCS2564); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariableNameCS"


    // $ANTLR start "ruleVariableNameCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1248:1: ruleVariableNameCS returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_UnrestrictedName_0= ruleUnrestrictedName ;
    public final AntlrDatatypeRuleToken ruleVariableNameCS() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_UnrestrictedName_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1251:28: (this_UnrestrictedName_0= ruleUnrestrictedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1253:5: this_UnrestrictedName_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getVariableNameCSAccess().getUnrestrictedNameParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleVariableNameCS2610);
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

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVariableNameCS"


    // $ANTLR start "entryRuleQueryCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1271:1: entryRuleQueryCS returns [EObject current=null] : iv_ruleQueryCS= ruleQueryCS EOF ;
    public final EObject entryRuleQueryCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQueryCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1272:2: (iv_ruleQueryCS= ruleQueryCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1273:2: iv_ruleQueryCS= ruleQueryCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQueryCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleQueryCS_in_entryRuleQueryCS2654);
            iv_ruleQueryCS=ruleQueryCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQueryCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleQueryCS2664); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1280:1: ruleQueryCS returns [EObject current=null] : (otherlv_0= 'query' ( (lv_name_1_0= ruleUnrestrictedName ) ) otherlv_2= '(' ( ( (lv_inputParamDeclaration_3_0= ruleParamDeclarationCS ) ) (otherlv_4= ',' ( (lv_inputParamDeclaration_5_0= ruleParamDeclarationCS ) ) )* )? otherlv_6= ')' otherlv_7= ':' ( (lv_ownedType_8_0= ruleTypeExpCS ) ) (otherlv_9= ';' | (otherlv_10= '{' ( (lv_oclExpression_11_0= ruleExpCS ) ) otherlv_12= '}' ) ) ) ;
    public final EObject ruleQueryCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_inputParamDeclaration_3_0 = null;

        EObject lv_inputParamDeclaration_5_0 = null;

        EObject lv_ownedType_8_0 = null;

        EObject lv_oclExpression_11_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1283:28: ( (otherlv_0= 'query' ( (lv_name_1_0= ruleUnrestrictedName ) ) otherlv_2= '(' ( ( (lv_inputParamDeclaration_3_0= ruleParamDeclarationCS ) ) (otherlv_4= ',' ( (lv_inputParamDeclaration_5_0= ruleParamDeclarationCS ) ) )* )? otherlv_6= ')' otherlv_7= ':' ( (lv_ownedType_8_0= ruleTypeExpCS ) ) (otherlv_9= ';' | (otherlv_10= '{' ( (lv_oclExpression_11_0= ruleExpCS ) ) otherlv_12= '}' ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1284:1: (otherlv_0= 'query' ( (lv_name_1_0= ruleUnrestrictedName ) ) otherlv_2= '(' ( ( (lv_inputParamDeclaration_3_0= ruleParamDeclarationCS ) ) (otherlv_4= ',' ( (lv_inputParamDeclaration_5_0= ruleParamDeclarationCS ) ) )* )? otherlv_6= ')' otherlv_7= ':' ( (lv_ownedType_8_0= ruleTypeExpCS ) ) (otherlv_9= ';' | (otherlv_10= '{' ( (lv_oclExpression_11_0= ruleExpCS ) ) otherlv_12= '}' ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1284:1: (otherlv_0= 'query' ( (lv_name_1_0= ruleUnrestrictedName ) ) otherlv_2= '(' ( ( (lv_inputParamDeclaration_3_0= ruleParamDeclarationCS ) ) (otherlv_4= ',' ( (lv_inputParamDeclaration_5_0= ruleParamDeclarationCS ) ) )* )? otherlv_6= ')' otherlv_7= ':' ( (lv_ownedType_8_0= ruleTypeExpCS ) ) (otherlv_9= ';' | (otherlv_10= '{' ( (lv_oclExpression_11_0= ruleExpCS ) ) otherlv_12= '}' ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1284:3: otherlv_0= 'query' ( (lv_name_1_0= ruleUnrestrictedName ) ) otherlv_2= '(' ( ( (lv_inputParamDeclaration_3_0= ruleParamDeclarationCS ) ) (otherlv_4= ',' ( (lv_inputParamDeclaration_5_0= ruleParamDeclarationCS ) ) )* )? otherlv_6= ')' otherlv_7= ':' ( (lv_ownedType_8_0= ruleTypeExpCS ) ) (otherlv_9= ';' | (otherlv_10= '{' ( (lv_oclExpression_11_0= ruleExpCS ) ) otherlv_12= '}' ) )
            {
            otherlv_0=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleQueryCS2701); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getQueryCSAccess().getQueryKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1288:1: ( (lv_name_1_0= ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1289:1: (lv_name_1_0= ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1289:1: (lv_name_1_0= ruleUnrestrictedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1290:3: lv_name_1_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getQueryCSAccess().getNameUnrestrictedNameParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleQueryCS2722);
            lv_name_1_0=ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getQueryCSRule());
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

            otherlv_2=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleQueryCS2734); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getQueryCSAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1310:1: ( ( (lv_inputParamDeclaration_3_0= ruleParamDeclarationCS ) ) (otherlv_4= ',' ( (lv_inputParamDeclaration_5_0= ruleParamDeclarationCS ) ) )* )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( ((LA27_0>=RULE_SIMPLE_ID && LA27_0<=RULE_ESCAPED_ID)||LA27_0==14||LA27_0==19||(LA27_0>=21 && LA27_0<=22)||(LA27_0>=24 && LA27_0<=27)||LA27_0==32||LA27_0==35||(LA27_0>=37 && LA27_0<=38)) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1310:2: ( (lv_inputParamDeclaration_3_0= ruleParamDeclarationCS ) ) (otherlv_4= ',' ( (lv_inputParamDeclaration_5_0= ruleParamDeclarationCS ) ) )*
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1310:2: ( (lv_inputParamDeclaration_3_0= ruleParamDeclarationCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1311:1: (lv_inputParamDeclaration_3_0= ruleParamDeclarationCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1311:1: (lv_inputParamDeclaration_3_0= ruleParamDeclarationCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1312:3: lv_inputParamDeclaration_3_0= ruleParamDeclarationCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getQueryCSAccess().getInputParamDeclarationParamDeclarationCSParserRuleCall_3_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleParamDeclarationCS_in_ruleQueryCS2756);
                    lv_inputParamDeclaration_3_0=ruleParamDeclarationCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getQueryCSRule());
                      	        }
                             		add(
                             			current, 
                             			"inputParamDeclaration",
                              		lv_inputParamDeclaration_3_0, 
                              		"ParamDeclarationCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1328:2: (otherlv_4= ',' ( (lv_inputParamDeclaration_5_0= ruleParamDeclarationCS ) ) )*
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==20) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1328:4: otherlv_4= ',' ( (lv_inputParamDeclaration_5_0= ruleParamDeclarationCS ) )
                    	    {
                    	    otherlv_4=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleQueryCS2769); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_4, grammarAccess.getQueryCSAccess().getCommaKeyword_3_1_0());
                    	          
                    	    }
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1332:1: ( (lv_inputParamDeclaration_5_0= ruleParamDeclarationCS ) )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1333:1: (lv_inputParamDeclaration_5_0= ruleParamDeclarationCS )
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1333:1: (lv_inputParamDeclaration_5_0= ruleParamDeclarationCS )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1334:3: lv_inputParamDeclaration_5_0= ruleParamDeclarationCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getQueryCSAccess().getInputParamDeclarationParamDeclarationCSParserRuleCall_3_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleParamDeclarationCS_in_ruleQueryCS2790);
                    	    lv_inputParamDeclaration_5_0=ruleParamDeclarationCS();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getQueryCSRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"inputParamDeclaration",
                    	              		lv_inputParamDeclaration_5_0, 
                    	              		"ParamDeclarationCS");
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


                    }
                    break;

            }

            otherlv_6=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleQueryCS2806); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getQueryCSAccess().getRightParenthesisKeyword_4());
                  
            }
            otherlv_7=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleQueryCS2818); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getQueryCSAccess().getColonKeyword_5());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1358:1: ( (lv_ownedType_8_0= ruleTypeExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1359:1: (lv_ownedType_8_0= ruleTypeExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1359:1: (lv_ownedType_8_0= ruleTypeExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1360:3: lv_ownedType_8_0= ruleTypeExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getQueryCSAccess().getOwnedTypeTypeExpCSParserRuleCall_6_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleQueryCS2839);
            lv_ownedType_8_0=ruleTypeExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getQueryCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedType",
                      		lv_ownedType_8_0, 
                      		"TypeExpCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1376:2: (otherlv_9= ';' | (otherlv_10= '{' ( (lv_oclExpression_11_0= ruleExpCS ) ) otherlv_12= '}' ) )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==17) ) {
                alt28=1;
            }
            else if ( (LA28_0==16) ) {
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1376:4: otherlv_9= ';'
                    {
                    otherlv_9=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleQueryCS2852); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getQueryCSAccess().getSemicolonKeyword_7_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1381:6: (otherlv_10= '{' ( (lv_oclExpression_11_0= ruleExpCS ) ) otherlv_12= '}' )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1381:6: (otherlv_10= '{' ( (lv_oclExpression_11_0= ruleExpCS ) ) otherlv_12= '}' )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1381:8: otherlv_10= '{' ( (lv_oclExpression_11_0= ruleExpCS ) ) otherlv_12= '}'
                    {
                    otherlv_10=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleQueryCS2871); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getQueryCSAccess().getLeftCurlyBracketKeyword_7_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1385:1: ( (lv_oclExpression_11_0= ruleExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1386:1: (lv_oclExpression_11_0= ruleExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1386:1: (lv_oclExpression_11_0= ruleExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1387:3: lv_oclExpression_11_0= ruleExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getQueryCSAccess().getOclExpressionExpCSParserRuleCall_7_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleQueryCS2892);
                    lv_oclExpression_11_0=ruleExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getQueryCSRule());
                      	        }
                             		set(
                             			current, 
                             			"oclExpression",
                              		lv_oclExpression_11_0, 
                              		"ExpCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_12=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleQueryCS2904); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_12, grammarAccess.getQueryCSAccess().getRightCurlyBracketKeyword_7_1_2());
                          
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


    // $ANTLR start "entryRuleParamDeclarationCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1415:1: entryRuleParamDeclarationCS returns [EObject current=null] : iv_ruleParamDeclarationCS= ruleParamDeclarationCS EOF ;
    public final EObject entryRuleParamDeclarationCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParamDeclarationCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1416:2: (iv_ruleParamDeclarationCS= ruleParamDeclarationCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1417:2: iv_ruleParamDeclarationCS= ruleParamDeclarationCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParamDeclarationCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleParamDeclarationCS_in_entryRuleParamDeclarationCS2942);
            iv_ruleParamDeclarationCS=ruleParamDeclarationCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParamDeclarationCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParamDeclarationCS2952); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1424:1: ruleParamDeclarationCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) ) ;
    public final EObject ruleParamDeclarationCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1427:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1428:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1428:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1428:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1428:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1429:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1429:1: (lv_name_0_0= ruleUnrestrictedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1430:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParamDeclarationCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleParamDeclarationCS2998);
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

            otherlv_1=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleParamDeclarationCS3010); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getParamDeclarationCSAccess().getColonKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1450:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1451:1: (lv_ownedType_2_0= ruleTypeExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1451:1: (lv_ownedType_2_0= ruleTypeExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1452:3: lv_ownedType_2_0= ruleTypeExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParamDeclarationCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleParamDeclarationCS3031);
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


    // $ANTLR start "entryRuleUnrestrictedName"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1476:1: entryRuleUnrestrictedName returns [String current=null] : iv_ruleUnrestrictedName= ruleUnrestrictedName EOF ;
    public final String entryRuleUnrestrictedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnrestrictedName = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1477:2: (iv_ruleUnrestrictedName= ruleUnrestrictedName EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1478:2: iv_ruleUnrestrictedName= ruleUnrestrictedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnrestrictedNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_entryRuleUnrestrictedName3068);
            iv_ruleUnrestrictedName=ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnrestrictedName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnrestrictedName3079); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1485:1: ruleUnrestrictedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_EssentialOCLUnrestrictedName_0= ruleEssentialOCLUnrestrictedName | kw= 'check' | kw= 'enforce' | kw= 'imports' | kw= 'map' | kw= 'query' | kw= 'realize' | kw= 'refines' | kw= 'transformation' | kw= 'uses' | kw= 'where' ) ;
    public final AntlrDatatypeRuleToken ruleUnrestrictedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_EssentialOCLUnrestrictedName_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1488:28: ( (this_EssentialOCLUnrestrictedName_0= ruleEssentialOCLUnrestrictedName | kw= 'check' | kw= 'enforce' | kw= 'imports' | kw= 'map' | kw= 'query' | kw= 'realize' | kw= 'refines' | kw= 'transformation' | kw= 'uses' | kw= 'where' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1489:1: (this_EssentialOCLUnrestrictedName_0= ruleEssentialOCLUnrestrictedName | kw= 'check' | kw= 'enforce' | kw= 'imports' | kw= 'map' | kw= 'query' | kw= 'realize' | kw= 'refines' | kw= 'transformation' | kw= 'uses' | kw= 'where' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1489:1: (this_EssentialOCLUnrestrictedName_0= ruleEssentialOCLUnrestrictedName | kw= 'check' | kw= 'enforce' | kw= 'imports' | kw= 'map' | kw= 'query' | kw= 'realize' | kw= 'refines' | kw= 'transformation' | kw= 'uses' | kw= 'where' )
            int alt29=11;
            switch ( input.LA(1) ) {
            case RULE_SIMPLE_ID:
            case RULE_ESCAPED_ID:
            case 37:
            case 38:
                {
                alt29=1;
                }
                break;
            case 25:
                {
                alt29=2;
                }
                break;
            case 26:
                {
                alt29=3;
                }
                break;
            case 19:
                {
                alt29=4;
                }
                break;
            case 22:
                {
                alt29=5;
                }
                break;
            case 35:
                {
                alt29=6;
                }
                break;
            case 32:
                {
                alt29=7;
                }
                break;
            case 24:
                {
                alt29=8;
                }
                break;
            case 14:
                {
                alt29=9;
                }
                break;
            case 21:
                {
                alt29=10;
                }
                break;
            case 27:
                {
                alt29=11;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }

            switch (alt29) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1490:5: this_EssentialOCLUnrestrictedName_0= ruleEssentialOCLUnrestrictedName
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getUnrestrictedNameAccess().getEssentialOCLUnrestrictedNameParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLUnrestrictedName_in_ruleUnrestrictedName3126);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1502:2: kw= 'check'
                    {
                    kw=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleUnrestrictedName3150); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getCheckKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1509:2: kw= 'enforce'
                    {
                    kw=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleUnrestrictedName3169); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getEnforceKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1516:2: kw= 'imports'
                    {
                    kw=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleUnrestrictedName3188); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getImportsKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1523:2: kw= 'map'
                    {
                    kw=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleUnrestrictedName3207); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getMapKeyword_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1530:2: kw= 'query'
                    {
                    kw=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleUnrestrictedName3226); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getQueryKeyword_5()); 
                          
                    }

                    }
                    break;
                case 7 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1537:2: kw= 'realize'
                    {
                    kw=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleUnrestrictedName3245); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getRealizeKeyword_6()); 
                          
                    }

                    }
                    break;
                case 8 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1544:2: kw= 'refines'
                    {
                    kw=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleUnrestrictedName3264); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getRefinesKeyword_7()); 
                          
                    }

                    }
                    break;
                case 9 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1551:2: kw= 'transformation'
                    {
                    kw=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleUnrestrictedName3283); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getTransformationKeyword_8()); 
                          
                    }

                    }
                    break;
                case 10 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1558:2: kw= 'uses'
                    {
                    kw=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleUnrestrictedName3302); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getUsesKeyword_9()); 
                          
                    }

                    }
                    break;
                case 11 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1565:2: kw= 'where'
                    {
                    kw=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleUnrestrictedName3321); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getWhereKeyword_10()); 
                          
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1580:1: entryRuleID returns [String current=null] : iv_ruleID= ruleID EOF ;
    public final String entryRuleID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleID = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1581:2: (iv_ruleID= ruleID EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1582:2: iv_ruleID= ruleID EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIDRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleID_in_entryRuleID3364);
            iv_ruleID=ruleID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleID.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleID3375); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1589:1: ruleID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_SIMPLE_ID_0= RULE_SIMPLE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID ) ;
    public final AntlrDatatypeRuleToken ruleID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_SIMPLE_ID_0=null;
        Token this_ESCAPED_ID_1=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1592:28: ( (this_SIMPLE_ID_0= RULE_SIMPLE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1593:1: (this_SIMPLE_ID_0= RULE_SIMPLE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1593:1: (this_SIMPLE_ID_0= RULE_SIMPLE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==RULE_SIMPLE_ID) ) {
                alt30=1;
            }
            else if ( (LA30_0==RULE_ESCAPED_ID) ) {
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1593:6: this_SIMPLE_ID_0= RULE_SIMPLE_ID
                    {
                    this_SIMPLE_ID_0=(Token)match(input,RULE_SIMPLE_ID,FollowSets000.FOLLOW_RULE_SIMPLE_ID_in_ruleID3415); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SIMPLE_ID_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SIMPLE_ID_0, grammarAccess.getIDAccess().getSIMPLE_IDTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1601:10: this_ESCAPED_ID_1= RULE_ESCAPED_ID
                    {
                    this_ESCAPED_ID_1=(Token)match(input,RULE_ESCAPED_ID,FollowSets000.FOLLOW_RULE_ESCAPED_ID_in_ruleID3441); if (state.failed) return current;
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


    // $ANTLR start "entryRuleNUMBER_LITERAL"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1616:1: entryRuleNUMBER_LITERAL returns [String current=null] : iv_ruleNUMBER_LITERAL= ruleNUMBER_LITERAL EOF ;
    public final String entryRuleNUMBER_LITERAL() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNUMBER_LITERAL = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1617:2: (iv_ruleNUMBER_LITERAL= ruleNUMBER_LITERAL EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1618:2: iv_ruleNUMBER_LITERAL= ruleNUMBER_LITERAL EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNUMBER_LITERALRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNUMBER_LITERAL_in_entryRuleNUMBER_LITERAL3487);
            iv_ruleNUMBER_LITERAL=ruleNUMBER_LITERAL();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNUMBER_LITERAL.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNUMBER_LITERAL3498); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1625:1: ruleNUMBER_LITERAL returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? ( (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_7= RULE_INT )? ) ;
    public final AntlrDatatypeRuleToken ruleNUMBER_LITERAL() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;
        Token this_INT_7=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1628:28: ( (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? ( (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_7= RULE_INT )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1629:1: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? ( (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_7= RULE_INT )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1629:1: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? ( (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_7= RULE_INT )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1629:6: this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? ( (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_7= RULE_INT )?
            {
            this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleNUMBER_LITERAL3538); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_INT_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_INT_0, grammarAccess.getNUMBER_LITERALAccess().getINTTerminalRuleCall_0()); 
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1636:1: (kw= '.' this_INT_2= RULE_INT )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==36) ) {
                int LA31_1 = input.LA(2);

                if ( (LA31_1==RULE_INT) ) {
                    int LA31_3 = input.LA(3);

                    if ( (synpred42_InternalQVTcore()) ) {
                        alt31=1;
                    }
                }
            }
            switch (alt31) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1637:2: kw= '.' this_INT_2= RULE_INT
                    {
                    kw=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleNUMBER_LITERAL3557); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getNUMBER_LITERALAccess().getFullStopKeyword_1_0()); 
                          
                    }
                    this_INT_2=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleNUMBER_LITERAL3572); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_INT_2);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_INT_2, grammarAccess.getNUMBER_LITERALAccess().getINTTerminalRuleCall_1_1()); 
                          
                    }

                    }
                    break;

            }

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1649:3: ( (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_7= RULE_INT )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( ((LA34_0>=37 && LA34_0<=38)) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1649:4: (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_7= RULE_INT
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1649:4: (kw= 'e' | kw= 'E' )
                    int alt32=2;
                    int LA32_0 = input.LA(1);

                    if ( (LA32_0==37) ) {
                        alt32=1;
                    }
                    else if ( (LA32_0==38) ) {
                        alt32=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 32, 0, input);

                        throw nvae;
                    }
                    switch (alt32) {
                        case 1 :
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1650:2: kw= 'e'
                            {
                            kw=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleNUMBER_LITERAL3594); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      current.merge(kw);
                                      newLeafNode(kw, grammarAccess.getNUMBER_LITERALAccess().getEKeyword_2_0_0()); 
                                  
                            }

                            }
                            break;
                        case 2 :
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1657:2: kw= 'E'
                            {
                            kw=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleNUMBER_LITERAL3613); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      current.merge(kw);
                                      newLeafNode(kw, grammarAccess.getNUMBER_LITERALAccess().getEKeyword_2_0_1()); 
                                  
                            }

                            }
                            break;

                    }

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1662:2: (kw= '+' | kw= '-' )?
                    int alt33=3;
                    int LA33_0 = input.LA(1);

                    if ( (LA33_0==39) ) {
                        alt33=1;
                    }
                    else if ( (LA33_0==40) ) {
                        alt33=2;
                    }
                    switch (alt33) {
                        case 1 :
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1663:2: kw= '+'
                            {
                            kw=(Token)match(input,39,FollowSets000.FOLLOW_39_in_ruleNUMBER_LITERAL3628); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      current.merge(kw);
                                      newLeafNode(kw, grammarAccess.getNUMBER_LITERALAccess().getPlusSignKeyword_2_1_0()); 
                                  
                            }

                            }
                            break;
                        case 2 :
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1670:2: kw= '-'
                            {
                            kw=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleNUMBER_LITERAL3647); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      current.merge(kw);
                                      newLeafNode(kw, grammarAccess.getNUMBER_LITERALAccess().getHyphenMinusKeyword_2_1_1()); 
                                  
                            }

                            }
                            break;

                    }

                    this_INT_7=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleNUMBER_LITERAL3664); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_INT_7);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_INT_7, grammarAccess.getNUMBER_LITERALAccess().getINTTerminalRuleCall_2_2()); 
                          
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
    // $ANTLR end "ruleNUMBER_LITERAL"


    // $ANTLR start "entryRuleEssentialOCLUnrestrictedIdentifier"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1694:1: entryRuleEssentialOCLUnrestrictedIdentifier returns [String current=null] : iv_ruleEssentialOCLUnrestrictedIdentifier= ruleEssentialOCLUnrestrictedIdentifier EOF ;
    public final String entryRuleEssentialOCLUnrestrictedIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEssentialOCLUnrestrictedIdentifier = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1695:2: (iv_ruleEssentialOCLUnrestrictedIdentifier= ruleEssentialOCLUnrestrictedIdentifier EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1696:2: iv_ruleEssentialOCLUnrestrictedIdentifier= ruleEssentialOCLUnrestrictedIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEssentialOCLUnrestrictedIdentifierRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLUnrestrictedIdentifier_in_entryRuleEssentialOCLUnrestrictedIdentifier3716);
            iv_ruleEssentialOCLUnrestrictedIdentifier=ruleEssentialOCLUnrestrictedIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEssentialOCLUnrestrictedIdentifier.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEssentialOCLUnrestrictedIdentifier3727); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEssentialOCLUnrestrictedIdentifier"


    // $ANTLR start "ruleEssentialOCLUnrestrictedIdentifier"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1703:1: ruleEssentialOCLUnrestrictedIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'e' | kw= 'E' ) ;
    public final AntlrDatatypeRuleToken ruleEssentialOCLUnrestrictedIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1706:28: ( (kw= 'e' | kw= 'E' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1707:1: (kw= 'e' | kw= 'E' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1707:1: (kw= 'e' | kw= 'E' )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==37) ) {
                alt35=1;
            }
            else if ( (LA35_0==38) ) {
                alt35=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }
            switch (alt35) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1708:2: kw= 'e'
                    {
                    kw=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleEssentialOCLUnrestrictedIdentifier3765); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLUnrestrictedIdentifierAccess().getEKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1715:2: kw= 'E'
                    {
                    kw=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleEssentialOCLUnrestrictedIdentifier3784); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLUnrestrictedIdentifierAccess().getEKeyword_1()); 
                          
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
    // $ANTLR end "ruleEssentialOCLUnrestrictedIdentifier"


    // $ANTLR start "entryRuleEssentialOCLPrefixOperator"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1728:1: entryRuleEssentialOCLPrefixOperator returns [String current=null] : iv_ruleEssentialOCLPrefixOperator= ruleEssentialOCLPrefixOperator EOF ;
    public final String entryRuleEssentialOCLPrefixOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEssentialOCLPrefixOperator = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1729:2: (iv_ruleEssentialOCLPrefixOperator= ruleEssentialOCLPrefixOperator EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1730:2: iv_ruleEssentialOCLPrefixOperator= ruleEssentialOCLPrefixOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEssentialOCLPrefixOperatorRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLPrefixOperator_in_entryRuleEssentialOCLPrefixOperator3825);
            iv_ruleEssentialOCLPrefixOperator=ruleEssentialOCLPrefixOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEssentialOCLPrefixOperator.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEssentialOCLPrefixOperator3836); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1737:1: ruleEssentialOCLPrefixOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '-' | kw= 'not' ) ;
    public final AntlrDatatypeRuleToken ruleEssentialOCLPrefixOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1740:28: ( (kw= '-' | kw= 'not' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1741:1: (kw= '-' | kw= 'not' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1741:1: (kw= '-' | kw= 'not' )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==40) ) {
                alt36=1;
            }
            else if ( (LA36_0==41) ) {
                alt36=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }
            switch (alt36) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1742:2: kw= '-'
                    {
                    kw=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleEssentialOCLPrefixOperator3874); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLPrefixOperatorAccess().getHyphenMinusKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1749:2: kw= 'not'
                    {
                    kw=(Token)match(input,41,FollowSets000.FOLLOW_41_in_ruleEssentialOCLPrefixOperator3893); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1762:1: entryRuleEssentialOCLInfixOperator returns [String current=null] : iv_ruleEssentialOCLInfixOperator= ruleEssentialOCLInfixOperator EOF ;
    public final String entryRuleEssentialOCLInfixOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEssentialOCLInfixOperator = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1763:2: (iv_ruleEssentialOCLInfixOperator= ruleEssentialOCLInfixOperator EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1764:2: iv_ruleEssentialOCLInfixOperator= ruleEssentialOCLInfixOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEssentialOCLInfixOperatorRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLInfixOperator_in_entryRuleEssentialOCLInfixOperator3934);
            iv_ruleEssentialOCLInfixOperator=ruleEssentialOCLInfixOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEssentialOCLInfixOperator.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEssentialOCLInfixOperator3945); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1771:1: ruleEssentialOCLInfixOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '*' | kw= '/' | kw= '+' | kw= '-' | kw= '>' | kw= '<' | kw= '>=' | kw= '<=' | kw= '=' | kw= '<>' | kw= 'and' | kw= 'or' | kw= 'xor' | kw= 'implies' ) ;
    public final AntlrDatatypeRuleToken ruleEssentialOCLInfixOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1774:28: ( (kw= '*' | kw= '/' | kw= '+' | kw= '-' | kw= '>' | kw= '<' | kw= '>=' | kw= '<=' | kw= '=' | kw= '<>' | kw= 'and' | kw= 'or' | kw= 'xor' | kw= 'implies' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1775:1: (kw= '*' | kw= '/' | kw= '+' | kw= '-' | kw= '>' | kw= '<' | kw= '>=' | kw= '<=' | kw= '=' | kw= '<>' | kw= 'and' | kw= 'or' | kw= 'xor' | kw= 'implies' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1775:1: (kw= '*' | kw= '/' | kw= '+' | kw= '-' | kw= '>' | kw= '<' | kw= '>=' | kw= '<=' | kw= '=' | kw= '<>' | kw= 'and' | kw= 'or' | kw= 'xor' | kw= 'implies' )
            int alt37=14;
            switch ( input.LA(1) ) {
            case 42:
                {
                alt37=1;
                }
                break;
            case 43:
                {
                alt37=2;
                }
                break;
            case 39:
                {
                alt37=3;
                }
                break;
            case 40:
                {
                alt37=4;
                }
                break;
            case 44:
                {
                alt37=5;
                }
                break;
            case 45:
                {
                alt37=6;
                }
                break;
            case 46:
                {
                alt37=7;
                }
                break;
            case 47:
                {
                alt37=8;
                }
                break;
            case 48:
                {
                alt37=9;
                }
                break;
            case 49:
                {
                alt37=10;
                }
                break;
            case 50:
                {
                alt37=11;
                }
                break;
            case 51:
                {
                alt37=12;
                }
                break;
            case 52:
                {
                alt37=13;
                }
                break;
            case 53:
                {
                alt37=14;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }

            switch (alt37) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1776:2: kw= '*'
                    {
                    kw=(Token)match(input,42,FollowSets000.FOLLOW_42_in_ruleEssentialOCLInfixOperator3983); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorAccess().getAsteriskKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1783:2: kw= '/'
                    {
                    kw=(Token)match(input,43,FollowSets000.FOLLOW_43_in_ruleEssentialOCLInfixOperator4002); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorAccess().getSolidusKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1790:2: kw= '+'
                    {
                    kw=(Token)match(input,39,FollowSets000.FOLLOW_39_in_ruleEssentialOCLInfixOperator4021); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorAccess().getPlusSignKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1797:2: kw= '-'
                    {
                    kw=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleEssentialOCLInfixOperator4040); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorAccess().getHyphenMinusKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1804:2: kw= '>'
                    {
                    kw=(Token)match(input,44,FollowSets000.FOLLOW_44_in_ruleEssentialOCLInfixOperator4059); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorAccess().getGreaterThanSignKeyword_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1811:2: kw= '<'
                    {
                    kw=(Token)match(input,45,FollowSets000.FOLLOW_45_in_ruleEssentialOCLInfixOperator4078); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorAccess().getLessThanSignKeyword_5()); 
                          
                    }

                    }
                    break;
                case 7 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1818:2: kw= '>='
                    {
                    kw=(Token)match(input,46,FollowSets000.FOLLOW_46_in_ruleEssentialOCLInfixOperator4097); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorAccess().getGreaterThanSignEqualsSignKeyword_6()); 
                          
                    }

                    }
                    break;
                case 8 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1825:2: kw= '<='
                    {
                    kw=(Token)match(input,47,FollowSets000.FOLLOW_47_in_ruleEssentialOCLInfixOperator4116); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorAccess().getLessThanSignEqualsSignKeyword_7()); 
                          
                    }

                    }
                    break;
                case 9 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1832:2: kw= '='
                    {
                    kw=(Token)match(input,48,FollowSets000.FOLLOW_48_in_ruleEssentialOCLInfixOperator4135); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorAccess().getEqualsSignKeyword_8()); 
                          
                    }

                    }
                    break;
                case 10 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1839:2: kw= '<>'
                    {
                    kw=(Token)match(input,49,FollowSets000.FOLLOW_49_in_ruleEssentialOCLInfixOperator4154); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorAccess().getLessThanSignGreaterThanSignKeyword_9()); 
                          
                    }

                    }
                    break;
                case 11 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1846:2: kw= 'and'
                    {
                    kw=(Token)match(input,50,FollowSets000.FOLLOW_50_in_ruleEssentialOCLInfixOperator4173); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorAccess().getAndKeyword_10()); 
                          
                    }

                    }
                    break;
                case 12 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1853:2: kw= 'or'
                    {
                    kw=(Token)match(input,51,FollowSets000.FOLLOW_51_in_ruleEssentialOCLInfixOperator4192); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorAccess().getOrKeyword_11()); 
                          
                    }

                    }
                    break;
                case 13 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1860:2: kw= 'xor'
                    {
                    kw=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleEssentialOCLInfixOperator4211); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorAccess().getXorKeyword_12()); 
                          
                    }

                    }
                    break;
                case 14 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1867:2: kw= 'implies'
                    {
                    kw=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleEssentialOCLInfixOperator4230); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1880:1: entryRuleEssentialOCLNavigationOperator returns [String current=null] : iv_ruleEssentialOCLNavigationOperator= ruleEssentialOCLNavigationOperator EOF ;
    public final String entryRuleEssentialOCLNavigationOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEssentialOCLNavigationOperator = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1881:2: (iv_ruleEssentialOCLNavigationOperator= ruleEssentialOCLNavigationOperator EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1882:2: iv_ruleEssentialOCLNavigationOperator= ruleEssentialOCLNavigationOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEssentialOCLNavigationOperatorRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLNavigationOperator_in_entryRuleEssentialOCLNavigationOperator4271);
            iv_ruleEssentialOCLNavigationOperator=ruleEssentialOCLNavigationOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEssentialOCLNavigationOperator.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEssentialOCLNavigationOperator4282); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1889:1: ruleEssentialOCLNavigationOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '.' | kw= '->' ) ;
    public final AntlrDatatypeRuleToken ruleEssentialOCLNavigationOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1892:28: ( (kw= '.' | kw= '->' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1893:1: (kw= '.' | kw= '->' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1893:1: (kw= '.' | kw= '->' )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==36) ) {
                alt38=1;
            }
            else if ( (LA38_0==54) ) {
                alt38=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1894:2: kw= '.'
                    {
                    kw=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleEssentialOCLNavigationOperator4320); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLNavigationOperatorAccess().getFullStopKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1901:2: kw= '->'
                    {
                    kw=(Token)match(input,54,FollowSets000.FOLLOW_54_in_ruleEssentialOCLNavigationOperator4339); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1914:1: entryRuleIdentifier returns [String current=null] : iv_ruleIdentifier= ruleIdentifier EOF ;
    public final String entryRuleIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdentifier = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1915:2: (iv_ruleIdentifier= ruleIdentifier EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1916:2: iv_ruleIdentifier= ruleIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIdentifierRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_entryRuleIdentifier4380);
            iv_ruleIdentifier=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIdentifier.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIdentifier4391); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1923:1: ruleIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= ruleID | this_EssentialOCLUnrestrictedIdentifier_1= ruleEssentialOCLUnrestrictedIdentifier ) ;
    public final AntlrDatatypeRuleToken ruleIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_ID_0 = null;

        AntlrDatatypeRuleToken this_EssentialOCLUnrestrictedIdentifier_1 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1926:28: ( (this_ID_0= ruleID | this_EssentialOCLUnrestrictedIdentifier_1= ruleEssentialOCLUnrestrictedIdentifier ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1927:1: (this_ID_0= ruleID | this_EssentialOCLUnrestrictedIdentifier_1= ruleEssentialOCLUnrestrictedIdentifier )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1927:1: (this_ID_0= ruleID | this_EssentialOCLUnrestrictedIdentifier_1= ruleEssentialOCLUnrestrictedIdentifier )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( ((LA39_0>=RULE_SIMPLE_ID && LA39_0<=RULE_ESCAPED_ID)) ) {
                alt39=1;
            }
            else if ( ((LA39_0>=37 && LA39_0<=38)) ) {
                alt39=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }
            switch (alt39) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1928:5: this_ID_0= ruleID
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getIdentifierAccess().getIDParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleID_in_ruleIdentifier4438);
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
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1940:5: this_EssentialOCLUnrestrictedIdentifier_1= ruleEssentialOCLUnrestrictedIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getIdentifierAccess().getEssentialOCLUnrestrictedIdentifierParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLUnrestrictedIdentifier_in_ruleIdentifier4471);
                    this_EssentialOCLUnrestrictedIdentifier_1=ruleEssentialOCLUnrestrictedIdentifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_EssentialOCLUnrestrictedIdentifier_1);
                          
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
    // $ANTLR end "ruleIdentifier"


    // $ANTLR start "entryRuleStringLiteral"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1958:1: entryRuleStringLiteral returns [String current=null] : iv_ruleStringLiteral= ruleStringLiteral EOF ;
    public final String entryRuleStringLiteral() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleStringLiteral = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1959:2: (iv_ruleStringLiteral= ruleStringLiteral EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1960:2: iv_ruleStringLiteral= ruleStringLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStringLiteralRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral4517);
            iv_ruleStringLiteral=ruleStringLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStringLiteral.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleStringLiteral4528); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1967:1: ruleStringLiteral returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING ;
    public final AntlrDatatypeRuleToken ruleStringLiteral() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_SINGLE_QUOTED_STRING_0=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1970:28: (this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1971:5: this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING
            {
            this_SINGLE_QUOTED_STRING_0=(Token)match(input,RULE_SINGLE_QUOTED_STRING,FollowSets000.FOLLOW_RULE_SINGLE_QUOTED_STRING_in_ruleStringLiteral4567); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1986:1: entryRulePrefixOperator returns [String current=null] : iv_rulePrefixOperator= rulePrefixOperator EOF ;
    public final String entryRulePrefixOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePrefixOperator = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1987:2: (iv_rulePrefixOperator= rulePrefixOperator EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1988:2: iv_rulePrefixOperator= rulePrefixOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrefixOperatorRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePrefixOperator_in_entryRulePrefixOperator4612);
            iv_rulePrefixOperator=rulePrefixOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrefixOperator.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrefixOperator4623); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1995:1: rulePrefixOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_EssentialOCLPrefixOperator_0= ruleEssentialOCLPrefixOperator ;
    public final AntlrDatatypeRuleToken rulePrefixOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_EssentialOCLPrefixOperator_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1998:28: (this_EssentialOCLPrefixOperator_0= ruleEssentialOCLPrefixOperator )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2000:5: this_EssentialOCLPrefixOperator_0= ruleEssentialOCLPrefixOperator
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getPrefixOperatorAccess().getEssentialOCLPrefixOperatorParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLPrefixOperator_in_rulePrefixOperator4669);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2018:1: entryRuleInfixOperator returns [String current=null] : iv_ruleInfixOperator= ruleInfixOperator EOF ;
    public final String entryRuleInfixOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInfixOperator = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2019:2: (iv_ruleInfixOperator= ruleInfixOperator EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2020:2: iv_ruleInfixOperator= ruleInfixOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInfixOperatorRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleInfixOperator_in_entryRuleInfixOperator4714);
            iv_ruleInfixOperator=ruleInfixOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInfixOperator.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleInfixOperator4725); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2027:1: ruleInfixOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_EssentialOCLInfixOperator_0= ruleEssentialOCLInfixOperator ;
    public final AntlrDatatypeRuleToken ruleInfixOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_EssentialOCLInfixOperator_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2030:28: (this_EssentialOCLInfixOperator_0= ruleEssentialOCLInfixOperator )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2032:5: this_EssentialOCLInfixOperator_0= ruleEssentialOCLInfixOperator
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getInfixOperatorAccess().getEssentialOCLInfixOperatorParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLInfixOperator_in_ruleInfixOperator4771);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2050:1: entryRuleNavigationOperator returns [String current=null] : iv_ruleNavigationOperator= ruleNavigationOperator EOF ;
    public final String entryRuleNavigationOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNavigationOperator = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2051:2: (iv_ruleNavigationOperator= ruleNavigationOperator EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2052:2: iv_ruleNavigationOperator= ruleNavigationOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigationOperatorRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigationOperator_in_entryRuleNavigationOperator4816);
            iv_ruleNavigationOperator=ruleNavigationOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigationOperator.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigationOperator4827); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2059:1: ruleNavigationOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_EssentialOCLNavigationOperator_0= ruleEssentialOCLNavigationOperator ;
    public final AntlrDatatypeRuleToken ruleNavigationOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_EssentialOCLNavigationOperator_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2062:28: (this_EssentialOCLNavigationOperator_0= ruleEssentialOCLNavigationOperator )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2064:5: this_EssentialOCLNavigationOperator_0= ruleEssentialOCLNavigationOperator
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getNavigationOperatorAccess().getEssentialOCLNavigationOperatorParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLNavigationOperator_in_ruleNavigationOperator4873);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2082:1: entryRuleEssentialOCLUnrestrictedName returns [String current=null] : iv_ruleEssentialOCLUnrestrictedName= ruleEssentialOCLUnrestrictedName EOF ;
    public final String entryRuleEssentialOCLUnrestrictedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEssentialOCLUnrestrictedName = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2083:2: (iv_ruleEssentialOCLUnrestrictedName= ruleEssentialOCLUnrestrictedName EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2084:2: iv_ruleEssentialOCLUnrestrictedName= ruleEssentialOCLUnrestrictedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEssentialOCLUnrestrictedNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLUnrestrictedName_in_entryRuleEssentialOCLUnrestrictedName4918);
            iv_ruleEssentialOCLUnrestrictedName=ruleEssentialOCLUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEssentialOCLUnrestrictedName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEssentialOCLUnrestrictedName4929); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2091:1: ruleEssentialOCLUnrestrictedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_Identifier_0= ruleIdentifier ;
    public final AntlrDatatypeRuleToken ruleEssentialOCLUnrestrictedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_Identifier_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2094:28: (this_Identifier_0= ruleIdentifier )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2096:5: this_Identifier_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getEssentialOCLUnrestrictedNameAccess().getIdentifierParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_ruleEssentialOCLUnrestrictedName4975);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2114:1: entryRuleEssentialOCLUnreservedName returns [String current=null] : iv_ruleEssentialOCLUnreservedName= ruleEssentialOCLUnreservedName EOF ;
    public final String entryRuleEssentialOCLUnreservedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEssentialOCLUnreservedName = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2115:2: (iv_ruleEssentialOCLUnreservedName= ruleEssentialOCLUnreservedName EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2116:2: iv_ruleEssentialOCLUnreservedName= ruleEssentialOCLUnreservedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEssentialOCLUnreservedNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLUnreservedName_in_entryRuleEssentialOCLUnreservedName5020);
            iv_ruleEssentialOCLUnreservedName=ruleEssentialOCLUnreservedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEssentialOCLUnreservedName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEssentialOCLUnreservedName5031); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2123:1: ruleEssentialOCLUnreservedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_UnrestrictedName_0= ruleUnrestrictedName | this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier | this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier | kw= 'Tuple' ) ;
    public final AntlrDatatypeRuleToken ruleEssentialOCLUnreservedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_UnrestrictedName_0 = null;

        AntlrDatatypeRuleToken this_CollectionTypeIdentifier_1 = null;

        AntlrDatatypeRuleToken this_PrimitiveTypeIdentifier_2 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2126:28: ( (this_UnrestrictedName_0= ruleUnrestrictedName | this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier | this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier | kw= 'Tuple' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2127:1: (this_UnrestrictedName_0= ruleUnrestrictedName | this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier | this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier | kw= 'Tuple' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2127:1: (this_UnrestrictedName_0= ruleUnrestrictedName | this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier | this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier | kw= 'Tuple' )
            int alt40=4;
            switch ( input.LA(1) ) {
            case RULE_SIMPLE_ID:
            case RULE_ESCAPED_ID:
            case 14:
            case 19:
            case 21:
            case 22:
            case 24:
            case 25:
            case 26:
            case 27:
            case 32:
            case 35:
            case 37:
            case 38:
                {
                alt40=1;
                }
                break;
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
                {
                alt40=2;
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
                alt40=3;
                }
                break;
            case 55:
                {
                alt40=4;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2128:5: this_UnrestrictedName_0= ruleUnrestrictedName
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getEssentialOCLUnreservedNameAccess().getUnrestrictedNameParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleEssentialOCLUnreservedName5078);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2140:5: this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getEssentialOCLUnreservedNameAccess().getCollectionTypeIdentifierParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCollectionTypeIdentifier_in_ruleEssentialOCLUnreservedName5111);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2152:5: this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getEssentialOCLUnreservedNameAccess().getPrimitiveTypeIdentifierParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrimitiveTypeIdentifier_in_ruleEssentialOCLUnreservedName5144);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2164:2: kw= 'Tuple'
                    {
                    kw=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleEssentialOCLUnreservedName5168); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2177:1: entryRuleUnreservedName returns [String current=null] : iv_ruleUnreservedName= ruleUnreservedName EOF ;
    public final String entryRuleUnreservedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnreservedName = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2178:2: (iv_ruleUnreservedName= ruleUnreservedName EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2179:2: iv_ruleUnreservedName= ruleUnreservedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnreservedNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnreservedName_in_entryRuleUnreservedName5209);
            iv_ruleUnreservedName=ruleUnreservedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnreservedName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnreservedName5220); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2186:1: ruleUnreservedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_EssentialOCLUnreservedName_0= ruleEssentialOCLUnreservedName ;
    public final AntlrDatatypeRuleToken ruleUnreservedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_EssentialOCLUnreservedName_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2189:28: (this_EssentialOCLUnreservedName_0= ruleEssentialOCLUnreservedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2191:5: this_EssentialOCLUnreservedName_0= ruleEssentialOCLUnreservedName
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getUnreservedNameAccess().getEssentialOCLUnreservedNameParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLUnreservedName_in_ruleUnreservedName5266);
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


    // $ANTLR start "entryRulePrimitiveTypeIdentifier"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2209:1: entryRulePrimitiveTypeIdentifier returns [String current=null] : iv_rulePrimitiveTypeIdentifier= rulePrimitiveTypeIdentifier EOF ;
    public final String entryRulePrimitiveTypeIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePrimitiveTypeIdentifier = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2210:2: (iv_rulePrimitiveTypeIdentifier= rulePrimitiveTypeIdentifier EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2211:2: iv_rulePrimitiveTypeIdentifier= rulePrimitiveTypeIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimitiveTypeIdentifierRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePrimitiveTypeIdentifier_in_entryRulePrimitiveTypeIdentifier5311);
            iv_rulePrimitiveTypeIdentifier=rulePrimitiveTypeIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimitiveTypeIdentifier.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrimitiveTypeIdentifier5322); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2218:1: rulePrimitiveTypeIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Boolean' | kw= 'Integer' | kw= 'Real' | kw= 'String' | kw= 'UnlimitedNatural' | kw= 'OclAny' | kw= 'OclInvalid' | kw= 'OclVoid' ) ;
    public final AntlrDatatypeRuleToken rulePrimitiveTypeIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2221:28: ( (kw= 'Boolean' | kw= 'Integer' | kw= 'Real' | kw= 'String' | kw= 'UnlimitedNatural' | kw= 'OclAny' | kw= 'OclInvalid' | kw= 'OclVoid' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2222:1: (kw= 'Boolean' | kw= 'Integer' | kw= 'Real' | kw= 'String' | kw= 'UnlimitedNatural' | kw= 'OclAny' | kw= 'OclInvalid' | kw= 'OclVoid' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2222:1: (kw= 'Boolean' | kw= 'Integer' | kw= 'Real' | kw= 'String' | kw= 'UnlimitedNatural' | kw= 'OclAny' | kw= 'OclInvalid' | kw= 'OclVoid' )
            int alt41=8;
            switch ( input.LA(1) ) {
            case 56:
                {
                alt41=1;
                }
                break;
            case 57:
                {
                alt41=2;
                }
                break;
            case 58:
                {
                alt41=3;
                }
                break;
            case 59:
                {
                alt41=4;
                }
                break;
            case 60:
                {
                alt41=5;
                }
                break;
            case 61:
                {
                alt41=6;
                }
                break;
            case 62:
                {
                alt41=7;
                }
                break;
            case 63:
                {
                alt41=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }

            switch (alt41) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2223:2: kw= 'Boolean'
                    {
                    kw=(Token)match(input,56,FollowSets000.FOLLOW_56_in_rulePrimitiveTypeIdentifier5360); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getBooleanKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2230:2: kw= 'Integer'
                    {
                    kw=(Token)match(input,57,FollowSets000.FOLLOW_57_in_rulePrimitiveTypeIdentifier5379); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getIntegerKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2237:2: kw= 'Real'
                    {
                    kw=(Token)match(input,58,FollowSets000.FOLLOW_58_in_rulePrimitiveTypeIdentifier5398); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getRealKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2244:2: kw= 'String'
                    {
                    kw=(Token)match(input,59,FollowSets000.FOLLOW_59_in_rulePrimitiveTypeIdentifier5417); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getStringKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2251:2: kw= 'UnlimitedNatural'
                    {
                    kw=(Token)match(input,60,FollowSets000.FOLLOW_60_in_rulePrimitiveTypeIdentifier5436); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getUnlimitedNaturalKeyword_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2258:2: kw= 'OclAny'
                    {
                    kw=(Token)match(input,61,FollowSets000.FOLLOW_61_in_rulePrimitiveTypeIdentifier5455); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getOclAnyKeyword_5()); 
                          
                    }

                    }
                    break;
                case 7 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2265:2: kw= 'OclInvalid'
                    {
                    kw=(Token)match(input,62,FollowSets000.FOLLOW_62_in_rulePrimitiveTypeIdentifier5474); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getOclInvalidKeyword_6()); 
                          
                    }

                    }
                    break;
                case 8 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2272:2: kw= 'OclVoid'
                    {
                    kw=(Token)match(input,63,FollowSets000.FOLLOW_63_in_rulePrimitiveTypeIdentifier5493); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2285:1: entryRulePrimitiveTypeCS returns [EObject current=null] : iv_rulePrimitiveTypeCS= rulePrimitiveTypeCS EOF ;
    public final EObject entryRulePrimitiveTypeCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveTypeCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2286:2: (iv_rulePrimitiveTypeCS= rulePrimitiveTypeCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2287:2: iv_rulePrimitiveTypeCS= rulePrimitiveTypeCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimitiveTypeCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePrimitiveTypeCS_in_entryRulePrimitiveTypeCS5533);
            iv_rulePrimitiveTypeCS=rulePrimitiveTypeCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimitiveTypeCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrimitiveTypeCS5543); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2294:1: rulePrimitiveTypeCS returns [EObject current=null] : ( (lv_name_0_0= rulePrimitiveTypeIdentifier ) ) ;
    public final EObject rulePrimitiveTypeCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2297:28: ( ( (lv_name_0_0= rulePrimitiveTypeIdentifier ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2298:1: ( (lv_name_0_0= rulePrimitiveTypeIdentifier ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2298:1: ( (lv_name_0_0= rulePrimitiveTypeIdentifier ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2299:1: (lv_name_0_0= rulePrimitiveTypeIdentifier )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2299:1: (lv_name_0_0= rulePrimitiveTypeIdentifier )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2300:3: lv_name_0_0= rulePrimitiveTypeIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPrimitiveTypeCSAccess().getNamePrimitiveTypeIdentifierParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_rulePrimitiveTypeIdentifier_in_rulePrimitiveTypeCS5588);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2324:1: entryRuleCollectionTypeIdentifier returns [String current=null] : iv_ruleCollectionTypeIdentifier= ruleCollectionTypeIdentifier EOF ;
    public final String entryRuleCollectionTypeIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleCollectionTypeIdentifier = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2325:2: (iv_ruleCollectionTypeIdentifier= ruleCollectionTypeIdentifier EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2326:2: iv_ruleCollectionTypeIdentifier= ruleCollectionTypeIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCollectionTypeIdentifierRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleCollectionTypeIdentifier_in_entryRuleCollectionTypeIdentifier5624);
            iv_ruleCollectionTypeIdentifier=ruleCollectionTypeIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCollectionTypeIdentifier.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCollectionTypeIdentifier5635); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2333:1: ruleCollectionTypeIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Set' | kw= 'Bag' | kw= 'Sequence' | kw= 'Collection' | kw= 'OrderedSet' ) ;
    public final AntlrDatatypeRuleToken ruleCollectionTypeIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2336:28: ( (kw= 'Set' | kw= 'Bag' | kw= 'Sequence' | kw= 'Collection' | kw= 'OrderedSet' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2337:1: (kw= 'Set' | kw= 'Bag' | kw= 'Sequence' | kw= 'Collection' | kw= 'OrderedSet' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2337:1: (kw= 'Set' | kw= 'Bag' | kw= 'Sequence' | kw= 'Collection' | kw= 'OrderedSet' )
            int alt42=5;
            switch ( input.LA(1) ) {
            case 64:
                {
                alt42=1;
                }
                break;
            case 65:
                {
                alt42=2;
                }
                break;
            case 66:
                {
                alt42=3;
                }
                break;
            case 67:
                {
                alt42=4;
                }
                break;
            case 68:
                {
                alt42=5;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2338:2: kw= 'Set'
                    {
                    kw=(Token)match(input,64,FollowSets000.FOLLOW_64_in_ruleCollectionTypeIdentifier5673); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getSetKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2345:2: kw= 'Bag'
                    {
                    kw=(Token)match(input,65,FollowSets000.FOLLOW_65_in_ruleCollectionTypeIdentifier5692); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getBagKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2352:2: kw= 'Sequence'
                    {
                    kw=(Token)match(input,66,FollowSets000.FOLLOW_66_in_ruleCollectionTypeIdentifier5711); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getSequenceKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2359:2: kw= 'Collection'
                    {
                    kw=(Token)match(input,67,FollowSets000.FOLLOW_67_in_ruleCollectionTypeIdentifier5730); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getCollectionKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2366:2: kw= 'OrderedSet'
                    {
                    kw=(Token)match(input,68,FollowSets000.FOLLOW_68_in_ruleCollectionTypeIdentifier5749); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2379:1: entryRuleCollectionTypeCS returns [EObject current=null] : iv_ruleCollectionTypeCS= ruleCollectionTypeCS EOF ;
    public final EObject entryRuleCollectionTypeCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionTypeCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2380:2: (iv_ruleCollectionTypeCS= ruleCollectionTypeCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2381:2: iv_ruleCollectionTypeCS= ruleCollectionTypeCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCollectionTypeCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleCollectionTypeCS_in_entryRuleCollectionTypeCS5789);
            iv_ruleCollectionTypeCS=ruleCollectionTypeCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCollectionTypeCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCollectionTypeCS5799); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2388:1: ruleCollectionTypeCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) ( (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' ) | (otherlv_4= '<' ( (lv_ownedType_5_0= ruleTypeExpCS ) ) otherlv_6= '>' ) )? ) ;
    public final EObject ruleCollectionTypeCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;

        EObject lv_ownedType_5_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2391:28: ( ( ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) ( (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' ) | (otherlv_4= '<' ( (lv_ownedType_5_0= ruleTypeExpCS ) ) otherlv_6= '>' ) )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2392:1: ( ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) ( (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' ) | (otherlv_4= '<' ( (lv_ownedType_5_0= ruleTypeExpCS ) ) otherlv_6= '>' ) )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2392:1: ( ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) ( (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' ) | (otherlv_4= '<' ( (lv_ownedType_5_0= ruleTypeExpCS ) ) otherlv_6= '>' ) )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2392:2: ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) ( (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' ) | (otherlv_4= '<' ( (lv_ownedType_5_0= ruleTypeExpCS ) ) otherlv_6= '>' ) )?
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2392:2: ( (lv_name_0_0= ruleCollectionTypeIdentifier ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2393:1: (lv_name_0_0= ruleCollectionTypeIdentifier )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2393:1: (lv_name_0_0= ruleCollectionTypeIdentifier )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2394:3: lv_name_0_0= ruleCollectionTypeIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCollectionTypeCSAccess().getNameCollectionTypeIdentifierParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleCollectionTypeIdentifier_in_ruleCollectionTypeCS5845);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2410:2: ( (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' ) | (otherlv_4= '<' ( (lv_ownedType_5_0= ruleTypeExpCS ) ) otherlv_6= '>' ) )?
            int alt43=3;
            alt43 = dfa43.predict(input);
            switch (alt43) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2410:3: (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2410:3: (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2410:5: otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleCollectionTypeCS5859); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getCollectionTypeCSAccess().getLeftParenthesisKeyword_1_0_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2414:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2415:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2415:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2416:3: lv_ownedType_2_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionTypeCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_0_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleCollectionTypeCS5880);
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

                    otherlv_3=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleCollectionTypeCS5892); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getCollectionTypeCSAccess().getRightParenthesisKeyword_1_0_2());
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2437:6: (otherlv_4= '<' ( (lv_ownedType_5_0= ruleTypeExpCS ) ) otherlv_6= '>' )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2437:6: (otherlv_4= '<' ( (lv_ownedType_5_0= ruleTypeExpCS ) ) otherlv_6= '>' )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2437:8: otherlv_4= '<' ( (lv_ownedType_5_0= ruleTypeExpCS ) ) otherlv_6= '>'
                    {
                    otherlv_4=(Token)match(input,45,FollowSets000.FOLLOW_45_in_ruleCollectionTypeCS5912); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getCollectionTypeCSAccess().getLessThanSignKeyword_1_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2441:1: ( (lv_ownedType_5_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2442:1: (lv_ownedType_5_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2442:1: (lv_ownedType_5_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2443:3: lv_ownedType_5_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionTypeCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleCollectionTypeCS5933);
                    lv_ownedType_5_0=ruleTypeExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getCollectionTypeCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedType",
                              		lv_ownedType_5_0, 
                              		"TypeExpCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_6=(Token)match(input,44,FollowSets000.FOLLOW_44_in_ruleCollectionTypeCS5945); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getCollectionTypeCSAccess().getGreaterThanSignKeyword_1_1_2());
                          
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
    // $ANTLR end "ruleCollectionTypeCS"


    // $ANTLR start "entryRuleTupleTypeCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2471:1: entryRuleTupleTypeCS returns [EObject current=null] : iv_ruleTupleTypeCS= ruleTupleTypeCS EOF ;
    public final EObject entryRuleTupleTypeCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTupleTypeCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2472:2: (iv_ruleTupleTypeCS= ruleTupleTypeCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2473:2: iv_ruleTupleTypeCS= ruleTupleTypeCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTupleTypeCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTupleTypeCS_in_entryRuleTupleTypeCS5984);
            iv_ruleTupleTypeCS=ruleTupleTypeCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTupleTypeCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTupleTypeCS5994); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2480:1: ruleTupleTypeCS returns [EObject current=null] : ( ( (lv_name_0_0= 'Tuple' ) ) ( (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruletuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruletuplePartCS ) ) )* )? otherlv_5= ')' ) | (otherlv_6= '<' ( ( (lv_ownedParts_7_0= ruletuplePartCS ) ) (otherlv_8= ',' ( (lv_ownedParts_9_0= ruletuplePartCS ) ) )* )? otherlv_10= '>' ) )? ) ;
    public final EObject ruleTupleTypeCS() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject lv_ownedParts_2_0 = null;

        EObject lv_ownedParts_4_0 = null;

        EObject lv_ownedParts_7_0 = null;

        EObject lv_ownedParts_9_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2483:28: ( ( ( (lv_name_0_0= 'Tuple' ) ) ( (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruletuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruletuplePartCS ) ) )* )? otherlv_5= ')' ) | (otherlv_6= '<' ( ( (lv_ownedParts_7_0= ruletuplePartCS ) ) (otherlv_8= ',' ( (lv_ownedParts_9_0= ruletuplePartCS ) ) )* )? otherlv_10= '>' ) )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2484:1: ( ( (lv_name_0_0= 'Tuple' ) ) ( (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruletuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruletuplePartCS ) ) )* )? otherlv_5= ')' ) | (otherlv_6= '<' ( ( (lv_ownedParts_7_0= ruletuplePartCS ) ) (otherlv_8= ',' ( (lv_ownedParts_9_0= ruletuplePartCS ) ) )* )? otherlv_10= '>' ) )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2484:1: ( ( (lv_name_0_0= 'Tuple' ) ) ( (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruletuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruletuplePartCS ) ) )* )? otherlv_5= ')' ) | (otherlv_6= '<' ( ( (lv_ownedParts_7_0= ruletuplePartCS ) ) (otherlv_8= ',' ( (lv_ownedParts_9_0= ruletuplePartCS ) ) )* )? otherlv_10= '>' ) )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2484:2: ( (lv_name_0_0= 'Tuple' ) ) ( (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruletuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruletuplePartCS ) ) )* )? otherlv_5= ')' ) | (otherlv_6= '<' ( ( (lv_ownedParts_7_0= ruletuplePartCS ) ) (otherlv_8= ',' ( (lv_ownedParts_9_0= ruletuplePartCS ) ) )* )? otherlv_10= '>' ) )?
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2484:2: ( (lv_name_0_0= 'Tuple' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2485:1: (lv_name_0_0= 'Tuple' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2485:1: (lv_name_0_0= 'Tuple' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2486:3: lv_name_0_0= 'Tuple'
            {
            lv_name_0_0=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleTupleTypeCS6037); if (state.failed) return current;
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2499:2: ( (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruletuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruletuplePartCS ) ) )* )? otherlv_5= ')' ) | (otherlv_6= '<' ( ( (lv_ownedParts_7_0= ruletuplePartCS ) ) (otherlv_8= ',' ( (lv_ownedParts_9_0= ruletuplePartCS ) ) )* )? otherlv_10= '>' ) )?
            int alt48=3;
            alt48 = dfa48.predict(input);
            switch (alt48) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2499:3: (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruletuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruletuplePartCS ) ) )* )? otherlv_5= ')' )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2499:3: (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruletuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruletuplePartCS ) ) )* )? otherlv_5= ')' )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2499:5: otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruletuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruletuplePartCS ) ) )* )? otherlv_5= ')'
                    {
                    otherlv_1=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleTupleTypeCS6064); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getTupleTypeCSAccess().getLeftParenthesisKeyword_1_0_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2503:1: ( ( (lv_ownedParts_2_0= ruletuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruletuplePartCS ) ) )* )?
                    int alt45=2;
                    int LA45_0 = input.LA(1);

                    if ( ((LA45_0>=RULE_SIMPLE_ID && LA45_0<=RULE_ESCAPED_ID)||LA45_0==14||LA45_0==19||(LA45_0>=21 && LA45_0<=22)||(LA45_0>=24 && LA45_0<=27)||LA45_0==32||LA45_0==35||(LA45_0>=37 && LA45_0<=38)) ) {
                        alt45=1;
                    }
                    switch (alt45) {
                        case 1 :
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2503:2: ( (lv_ownedParts_2_0= ruletuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruletuplePartCS ) ) )*
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2503:2: ( (lv_ownedParts_2_0= ruletuplePartCS ) )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2504:1: (lv_ownedParts_2_0= ruletuplePartCS )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2504:1: (lv_ownedParts_2_0= ruletuplePartCS )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2505:3: lv_ownedParts_2_0= ruletuplePartCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getTupleTypeCSAccess().getOwnedPartsTuplePartCSParserRuleCall_1_0_1_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruletuplePartCS_in_ruleTupleTypeCS6086);
                            lv_ownedParts_2_0=ruletuplePartCS();

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
                                      		"tuplePartCS");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2521:2: (otherlv_3= ',' ( (lv_ownedParts_4_0= ruletuplePartCS ) ) )*
                            loop44:
                            do {
                                int alt44=2;
                                int LA44_0 = input.LA(1);

                                if ( (LA44_0==20) ) {
                                    alt44=1;
                                }


                                switch (alt44) {
                            	case 1 :
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2521:4: otherlv_3= ',' ( (lv_ownedParts_4_0= ruletuplePartCS ) )
                            	    {
                            	    otherlv_3=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleTupleTypeCS6099); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_3, grammarAccess.getTupleTypeCSAccess().getCommaKeyword_1_0_1_1_0());
                            	          
                            	    }
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2525:1: ( (lv_ownedParts_4_0= ruletuplePartCS ) )
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2526:1: (lv_ownedParts_4_0= ruletuplePartCS )
                            	    {
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2526:1: (lv_ownedParts_4_0= ruletuplePartCS )
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2527:3: lv_ownedParts_4_0= ruletuplePartCS
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getTupleTypeCSAccess().getOwnedPartsTuplePartCSParserRuleCall_1_0_1_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FollowSets000.FOLLOW_ruletuplePartCS_in_ruleTupleTypeCS6120);
                            	    lv_ownedParts_4_0=ruletuplePartCS();

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
                            	              		"tuplePartCS");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop44;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_5=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleTupleTypeCS6136); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getTupleTypeCSAccess().getRightParenthesisKeyword_1_0_2());
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2548:6: (otherlv_6= '<' ( ( (lv_ownedParts_7_0= ruletuplePartCS ) ) (otherlv_8= ',' ( (lv_ownedParts_9_0= ruletuplePartCS ) ) )* )? otherlv_10= '>' )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2548:6: (otherlv_6= '<' ( ( (lv_ownedParts_7_0= ruletuplePartCS ) ) (otherlv_8= ',' ( (lv_ownedParts_9_0= ruletuplePartCS ) ) )* )? otherlv_10= '>' )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2548:8: otherlv_6= '<' ( ( (lv_ownedParts_7_0= ruletuplePartCS ) ) (otherlv_8= ',' ( (lv_ownedParts_9_0= ruletuplePartCS ) ) )* )? otherlv_10= '>'
                    {
                    otherlv_6=(Token)match(input,45,FollowSets000.FOLLOW_45_in_ruleTupleTypeCS6156); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getTupleTypeCSAccess().getLessThanSignKeyword_1_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2552:1: ( ( (lv_ownedParts_7_0= ruletuplePartCS ) ) (otherlv_8= ',' ( (lv_ownedParts_9_0= ruletuplePartCS ) ) )* )?
                    int alt47=2;
                    int LA47_0 = input.LA(1);

                    if ( ((LA47_0>=RULE_SIMPLE_ID && LA47_0<=RULE_ESCAPED_ID)||LA47_0==14||LA47_0==19||(LA47_0>=21 && LA47_0<=22)||(LA47_0>=24 && LA47_0<=27)||LA47_0==32||LA47_0==35||(LA47_0>=37 && LA47_0<=38)) ) {
                        alt47=1;
                    }
                    switch (alt47) {
                        case 1 :
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2552:2: ( (lv_ownedParts_7_0= ruletuplePartCS ) ) (otherlv_8= ',' ( (lv_ownedParts_9_0= ruletuplePartCS ) ) )*
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2552:2: ( (lv_ownedParts_7_0= ruletuplePartCS ) )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2553:1: (lv_ownedParts_7_0= ruletuplePartCS )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2553:1: (lv_ownedParts_7_0= ruletuplePartCS )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2554:3: lv_ownedParts_7_0= ruletuplePartCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getTupleTypeCSAccess().getOwnedPartsTuplePartCSParserRuleCall_1_1_1_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruletuplePartCS_in_ruleTupleTypeCS6178);
                            lv_ownedParts_7_0=ruletuplePartCS();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getTupleTypeCSRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"ownedParts",
                                      		lv_ownedParts_7_0, 
                                      		"tuplePartCS");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2570:2: (otherlv_8= ',' ( (lv_ownedParts_9_0= ruletuplePartCS ) ) )*
                            loop46:
                            do {
                                int alt46=2;
                                int LA46_0 = input.LA(1);

                                if ( (LA46_0==20) ) {
                                    alt46=1;
                                }


                                switch (alt46) {
                            	case 1 :
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2570:4: otherlv_8= ',' ( (lv_ownedParts_9_0= ruletuplePartCS ) )
                            	    {
                            	    otherlv_8=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleTupleTypeCS6191); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_8, grammarAccess.getTupleTypeCSAccess().getCommaKeyword_1_1_1_1_0());
                            	          
                            	    }
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2574:1: ( (lv_ownedParts_9_0= ruletuplePartCS ) )
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2575:1: (lv_ownedParts_9_0= ruletuplePartCS )
                            	    {
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2575:1: (lv_ownedParts_9_0= ruletuplePartCS )
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2576:3: lv_ownedParts_9_0= ruletuplePartCS
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getTupleTypeCSAccess().getOwnedPartsTuplePartCSParserRuleCall_1_1_1_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FollowSets000.FOLLOW_ruletuplePartCS_in_ruleTupleTypeCS6212);
                            	    lv_ownedParts_9_0=ruletuplePartCS();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getTupleTypeCSRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"ownedParts",
                            	              		lv_ownedParts_9_0, 
                            	              		"tuplePartCS");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop46;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_10=(Token)match(input,44,FollowSets000.FOLLOW_44_in_ruleTupleTypeCS6228); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getTupleTypeCSAccess().getGreaterThanSignKeyword_1_1_2());
                          
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
    // $ANTLR end "ruleTupleTypeCS"


    // $ANTLR start "entryRuletuplePartCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2604:1: entryRuletuplePartCS returns [EObject current=null] : iv_ruletuplePartCS= ruletuplePartCS EOF ;
    public final EObject entryRuletuplePartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruletuplePartCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2605:2: (iv_ruletuplePartCS= ruletuplePartCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2606:2: iv_ruletuplePartCS= ruletuplePartCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTuplePartCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruletuplePartCS_in_entryRuletuplePartCS6267);
            iv_ruletuplePartCS=ruletuplePartCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruletuplePartCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuletuplePartCS6277); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuletuplePartCS"


    // $ANTLR start "ruletuplePartCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2613:1: ruletuplePartCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) ) ;
    public final EObject ruletuplePartCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2616:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2617:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2617:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2617:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2617:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2618:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2618:1: (lv_name_0_0= ruleUnrestrictedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2619:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTuplePartCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruletuplePartCS6323);
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

            otherlv_1=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruletuplePartCS6335); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getTuplePartCSAccess().getColonKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2639:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2640:1: (lv_ownedType_2_0= ruleTypeExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2640:1: (lv_ownedType_2_0= ruleTypeExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2641:3: lv_ownedType_2_0= ruleTypeExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTuplePartCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruletuplePartCS6356);
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
    // $ANTLR end "ruletuplePartCS"


    // $ANTLR start "entryRuleCollectionLiteralExpCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2665:1: entryRuleCollectionLiteralExpCS returns [EObject current=null] : iv_ruleCollectionLiteralExpCS= ruleCollectionLiteralExpCS EOF ;
    public final EObject entryRuleCollectionLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2666:2: (iv_ruleCollectionLiteralExpCS= ruleCollectionLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2667:2: iv_ruleCollectionLiteralExpCS= ruleCollectionLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCollectionLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteralExpCS_in_entryRuleCollectionLiteralExpCS6392);
            iv_ruleCollectionLiteralExpCS=ruleCollectionLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCollectionLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCollectionLiteralExpCS6402); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2674:1: ruleCollectionLiteralExpCS returns [EObject current=null] : ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}' ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2677:28: ( ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2678:1: ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2678:1: ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2678:2: ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}'
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2678:2: ( (lv_ownedType_0_0= ruleCollectionTypeCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2679:1: (lv_ownedType_0_0= ruleCollectionTypeCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2679:1: (lv_ownedType_0_0= ruleCollectionTypeCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2680:3: lv_ownedType_0_0= ruleCollectionTypeCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedTypeCollectionTypeCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleCollectionTypeCS_in_ruleCollectionLiteralExpCS6448);
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

            otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleCollectionLiteralExpCS6460); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getCollectionLiteralExpCSAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2700:1: ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( ((LA50_0>=RULE_SIMPLE_ID && LA50_0<=RULE_SINGLE_QUOTED_STRING)||LA50_0==14||LA50_0==19||(LA50_0>=21 && LA50_0<=22)||(LA50_0>=24 && LA50_0<=28)||LA50_0==32||LA50_0==35||(LA50_0>=37 && LA50_0<=38)||(LA50_0>=40 && LA50_0<=42)||(LA50_0>=55 && LA50_0<=68)||(LA50_0>=70 && LA50_0<=73)||LA50_0==76||(LA50_0>=80 && LA50_0<=81)) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2700:2: ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )*
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2700:2: ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2701:1: (lv_ownedParts_2_0= ruleCollectionLiteralPartCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2701:1: (lv_ownedParts_2_0= ruleCollectionLiteralPartCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2702:3: lv_ownedParts_2_0= ruleCollectionLiteralPartCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedPartsCollectionLiteralPartCSParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteralPartCS_in_ruleCollectionLiteralExpCS6482);
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

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2718:2: (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )*
                    loop49:
                    do {
                        int alt49=2;
                        int LA49_0 = input.LA(1);

                        if ( (LA49_0==20) ) {
                            alt49=1;
                        }


                        switch (alt49) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2718:4: otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) )
                    	    {
                    	    otherlv_3=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleCollectionLiteralExpCS6495); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getCollectionLiteralExpCSAccess().getCommaKeyword_2_1_0());
                    	          
                    	    }
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2722:1: ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2723:1: (lv_ownedParts_4_0= ruleCollectionLiteralPartCS )
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2723:1: (lv_ownedParts_4_0= ruleCollectionLiteralPartCS )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2724:3: lv_ownedParts_4_0= ruleCollectionLiteralPartCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedPartsCollectionLiteralPartCSParserRuleCall_2_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteralPartCS_in_ruleCollectionLiteralExpCS6516);
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
                    	    break loop49;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleCollectionLiteralExpCS6532); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2752:1: entryRuleCollectionLiteralPartCS returns [EObject current=null] : iv_ruleCollectionLiteralPartCS= ruleCollectionLiteralPartCS EOF ;
    public final EObject entryRuleCollectionLiteralPartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionLiteralPartCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2753:2: (iv_ruleCollectionLiteralPartCS= ruleCollectionLiteralPartCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2754:2: iv_ruleCollectionLiteralPartCS= ruleCollectionLiteralPartCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCollectionLiteralPartCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteralPartCS_in_entryRuleCollectionLiteralPartCS6568);
            iv_ruleCollectionLiteralPartCS=ruleCollectionLiteralPartCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCollectionLiteralPartCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCollectionLiteralPartCS6578); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2761:1: ruleCollectionLiteralPartCS returns [EObject current=null] : ( ( (lv_expressionCS_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_lastExpressionCS_2_0= ruleExpCS ) ) )? ) ;
    public final EObject ruleCollectionLiteralPartCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expressionCS_0_0 = null;

        EObject lv_lastExpressionCS_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2764:28: ( ( ( (lv_expressionCS_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_lastExpressionCS_2_0= ruleExpCS ) ) )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2765:1: ( ( (lv_expressionCS_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_lastExpressionCS_2_0= ruleExpCS ) ) )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2765:1: ( ( (lv_expressionCS_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_lastExpressionCS_2_0= ruleExpCS ) ) )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2765:2: ( (lv_expressionCS_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_lastExpressionCS_2_0= ruleExpCS ) ) )?
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2765:2: ( (lv_expressionCS_0_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2766:1: (lv_expressionCS_0_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2766:1: (lv_expressionCS_0_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2767:3: lv_expressionCS_0_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCollectionLiteralPartCSAccess().getExpressionCSExpCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleCollectionLiteralPartCS6624);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2783:2: (otherlv_1= '..' ( (lv_lastExpressionCS_2_0= ruleExpCS ) ) )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==69) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2783:4: otherlv_1= '..' ( (lv_lastExpressionCS_2_0= ruleExpCS ) )
                    {
                    otherlv_1=(Token)match(input,69,FollowSets000.FOLLOW_69_in_ruleCollectionLiteralPartCS6637); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getCollectionLiteralPartCSAccess().getFullStopFullStopKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2787:1: ( (lv_lastExpressionCS_2_0= ruleExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2788:1: (lv_lastExpressionCS_2_0= ruleExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2788:1: (lv_lastExpressionCS_2_0= ruleExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2789:3: lv_lastExpressionCS_2_0= ruleExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionLiteralPartCSAccess().getLastExpressionCSExpCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleCollectionLiteralPartCS6658);
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


    // $ANTLR start "entryRuleConstructorExpCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2813:1: entryRuleConstructorExpCS returns [EObject current=null] : iv_ruleConstructorExpCS= ruleConstructorExpCS EOF ;
    public final EObject entryRuleConstructorExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstructorExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2814:2: (iv_ruleConstructorExpCS= ruleConstructorExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2815:2: iv_ruleConstructorExpCS= ruleConstructorExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstructorExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleConstructorExpCS_in_entryRuleConstructorExpCS6696);
            iv_ruleConstructorExpCS=ruleConstructorExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConstructorExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleConstructorExpCS6706); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConstructorExpCS"


    // $ANTLR start "ruleConstructorExpCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2822:1: ruleConstructorExpCS returns [EObject current=null] : ( ( ( ( ( ( ruleUnrestrictedName ) ) otherlv_1= '::' ( ( ( ruleUnreservedName ) ) otherlv_3= '::' )* ) ( ( ruleUnreservedName ) ) ) | ( ( ruleUnrestrictedName ) ) ) otherlv_6= '{' ( (lv_ownedParts_7_0= ruleConstructorPartCS ) ) (otherlv_8= ',' ( (lv_ownedParts_9_0= ruleConstructorPartCS ) ) )* otherlv_10= '}' ) ;
    public final EObject ruleConstructorExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject lv_ownedParts_7_0 = null;

        EObject lv_ownedParts_9_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2825:28: ( ( ( ( ( ( ( ruleUnrestrictedName ) ) otherlv_1= '::' ( ( ( ruleUnreservedName ) ) otherlv_3= '::' )* ) ( ( ruleUnreservedName ) ) ) | ( ( ruleUnrestrictedName ) ) ) otherlv_6= '{' ( (lv_ownedParts_7_0= ruleConstructorPartCS ) ) (otherlv_8= ',' ( (lv_ownedParts_9_0= ruleConstructorPartCS ) ) )* otherlv_10= '}' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2826:1: ( ( ( ( ( ( ruleUnrestrictedName ) ) otherlv_1= '::' ( ( ( ruleUnreservedName ) ) otherlv_3= '::' )* ) ( ( ruleUnreservedName ) ) ) | ( ( ruleUnrestrictedName ) ) ) otherlv_6= '{' ( (lv_ownedParts_7_0= ruleConstructorPartCS ) ) (otherlv_8= ',' ( (lv_ownedParts_9_0= ruleConstructorPartCS ) ) )* otherlv_10= '}' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2826:1: ( ( ( ( ( ( ruleUnrestrictedName ) ) otherlv_1= '::' ( ( ( ruleUnreservedName ) ) otherlv_3= '::' )* ) ( ( ruleUnreservedName ) ) ) | ( ( ruleUnrestrictedName ) ) ) otherlv_6= '{' ( (lv_ownedParts_7_0= ruleConstructorPartCS ) ) (otherlv_8= ',' ( (lv_ownedParts_9_0= ruleConstructorPartCS ) ) )* otherlv_10= '}' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2826:2: ( ( ( ( ( ruleUnrestrictedName ) ) otherlv_1= '::' ( ( ( ruleUnreservedName ) ) otherlv_3= '::' )* ) ( ( ruleUnreservedName ) ) ) | ( ( ruleUnrestrictedName ) ) ) otherlv_6= '{' ( (lv_ownedParts_7_0= ruleConstructorPartCS ) ) (otherlv_8= ',' ( (lv_ownedParts_9_0= ruleConstructorPartCS ) ) )* otherlv_10= '}'
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2826:2: ( ( ( ( ( ruleUnrestrictedName ) ) otherlv_1= '::' ( ( ( ruleUnreservedName ) ) otherlv_3= '::' )* ) ( ( ruleUnreservedName ) ) ) | ( ( ruleUnrestrictedName ) ) )
            int alt53=2;
            alt53 = dfa53.predict(input);
            switch (alt53) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2826:3: ( ( ( ( ruleUnrestrictedName ) ) otherlv_1= '::' ( ( ( ruleUnreservedName ) ) otherlv_3= '::' )* ) ( ( ruleUnreservedName ) ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2826:3: ( ( ( ( ruleUnrestrictedName ) ) otherlv_1= '::' ( ( ( ruleUnreservedName ) ) otherlv_3= '::' )* ) ( ( ruleUnreservedName ) ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2826:4: ( ( ( ruleUnrestrictedName ) ) otherlv_1= '::' ( ( ( ruleUnreservedName ) ) otherlv_3= '::' )* ) ( ( ruleUnreservedName ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2826:4: ( ( ( ruleUnrestrictedName ) ) otherlv_1= '::' ( ( ( ruleUnreservedName ) ) otherlv_3= '::' )* )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2826:5: ( ( ruleUnrestrictedName ) ) otherlv_1= '::' ( ( ( ruleUnreservedName ) ) otherlv_3= '::' )*
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2826:5: ( ( ruleUnrestrictedName ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2827:1: ( ruleUnrestrictedName )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2827:1: ( ruleUnrestrictedName )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2828:3: ruleUnrestrictedName
                    {
                    if ( state.backtracking==0 ) {
                       
                      		  /* */ 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getConstructorExpCSRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConstructorExpCSAccess().getNamespaceNamespaceCrossReference_0_0_0_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleConstructorExpCS6761);
                    ruleUnrestrictedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_1=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleConstructorExpCS6773); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getConstructorExpCSAccess().getColonColonKeyword_0_0_0_1());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2848:1: ( ( ( ruleUnreservedName ) ) otherlv_3= '::' )*
                    loop52:
                    do {
                        int alt52=2;
                        alt52 = dfa52.predict(input);
                        switch (alt52) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2848:2: ( ( ruleUnreservedName ) ) otherlv_3= '::'
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2848:2: ( ( ruleUnreservedName ) )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2849:1: ( ruleUnreservedName )
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2849:1: ( ruleUnreservedName )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2850:3: ruleUnreservedName
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      		  /* */ 
                    	      		
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      			if (current==null) {
                    	      	            current = createModelElement(grammarAccess.getConstructorExpCSRule());
                    	      	        }
                    	              
                    	    }
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getConstructorExpCSAccess().getNamespaceNamespaceCrossReference_0_0_0_2_0_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleUnreservedName_in_ruleConstructorExpCS6801);
                    	    ruleUnreservedName();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }

                    	    otherlv_3=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleConstructorExpCS6813); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getConstructorExpCSAccess().getColonColonKeyword_0_0_0_2_1());
                    	          
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop52;
                        }
                    } while (true);


                    }

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2870:4: ( ( ruleUnreservedName ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2871:1: ( ruleUnreservedName )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2871:1: ( ruleUnreservedName )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2872:3: ruleUnreservedName
                    {
                    if ( state.backtracking==0 ) {
                       
                      		  /* */ 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getConstructorExpCSRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConstructorExpCSAccess().getElementTypeCrossReference_0_0_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUnreservedName_in_ruleConstructorExpCS6843);
                    ruleUnreservedName();

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
                case 2 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2889:6: ( ( ruleUnrestrictedName ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2889:6: ( ( ruleUnrestrictedName ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2890:1: ( ruleUnrestrictedName )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2890:1: ( ruleUnrestrictedName )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2891:3: ruleUnrestrictedName
                    {
                    if ( state.backtracking==0 ) {
                       
                      		  /* */ 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getConstructorExpCSRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConstructorExpCSAccess().getElementTypeCrossReference_0_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleConstructorExpCS6877);
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

            otherlv_6=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleConstructorExpCS6890); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getConstructorExpCSAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2911:1: ( (lv_ownedParts_7_0= ruleConstructorPartCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2912:1: (lv_ownedParts_7_0= ruleConstructorPartCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2912:1: (lv_ownedParts_7_0= ruleConstructorPartCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2913:3: lv_ownedParts_7_0= ruleConstructorPartCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getConstructorExpCSAccess().getOwnedPartsConstructorPartCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleConstructorPartCS_in_ruleConstructorExpCS6911);
            lv_ownedParts_7_0=ruleConstructorPartCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getConstructorExpCSRule());
              	        }
                     		add(
                     			current, 
                     			"ownedParts",
                      		lv_ownedParts_7_0, 
                      		"ConstructorPartCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2929:2: (otherlv_8= ',' ( (lv_ownedParts_9_0= ruleConstructorPartCS ) ) )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==20) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2929:4: otherlv_8= ',' ( (lv_ownedParts_9_0= ruleConstructorPartCS ) )
            	    {
            	    otherlv_8=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleConstructorExpCS6924); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_8, grammarAccess.getConstructorExpCSAccess().getCommaKeyword_3_0());
            	          
            	    }
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2933:1: ( (lv_ownedParts_9_0= ruleConstructorPartCS ) )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2934:1: (lv_ownedParts_9_0= ruleConstructorPartCS )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2934:1: (lv_ownedParts_9_0= ruleConstructorPartCS )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2935:3: lv_ownedParts_9_0= ruleConstructorPartCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getConstructorExpCSAccess().getOwnedPartsConstructorPartCSParserRuleCall_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleConstructorPartCS_in_ruleConstructorExpCS6945);
            	    lv_ownedParts_9_0=ruleConstructorPartCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getConstructorExpCSRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedParts",
            	              		lv_ownedParts_9_0, 
            	              		"ConstructorPartCS");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop54;
                }
            } while (true);

            otherlv_10=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleConstructorExpCS6959); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_10, grammarAccess.getConstructorExpCSAccess().getRightCurlyBracketKeyword_4());
                  
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
    // $ANTLR end "ruleConstructorExpCS"


    // $ANTLR start "entryRuleConstructorPartCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2963:1: entryRuleConstructorPartCS returns [EObject current=null] : iv_ruleConstructorPartCS= ruleConstructorPartCS EOF ;
    public final EObject entryRuleConstructorPartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstructorPartCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2964:2: (iv_ruleConstructorPartCS= ruleConstructorPartCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2965:2: iv_ruleConstructorPartCS= ruleConstructorPartCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstructorPartCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleConstructorPartCS_in_entryRuleConstructorPartCS6995);
            iv_ruleConstructorPartCS=ruleConstructorPartCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConstructorPartCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleConstructorPartCS7005); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2972:1: ruleConstructorPartCS returns [EObject current=null] : ( ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( (lv_initExpression_2_0= ruleExpCS ) ) ) ;
    public final EObject ruleConstructorPartCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_initExpression_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2975:28: ( ( ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( (lv_initExpression_2_0= ruleExpCS ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2976:1: ( ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( (lv_initExpression_2_0= ruleExpCS ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2976:1: ( ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( (lv_initExpression_2_0= ruleExpCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2976:2: ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( (lv_initExpression_2_0= ruleExpCS ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2976:2: ( ( ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2977:1: ( ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2977:1: ( ruleUnrestrictedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2978:3: ruleUnrestrictedName
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
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleConstructorPartCS7057);
            ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,48,FollowSets000.FOLLOW_48_in_ruleConstructorPartCS7069); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getConstructorPartCSAccess().getEqualsSignKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2998:1: ( (lv_initExpression_2_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2999:1: (lv_initExpression_2_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2999:1: (lv_initExpression_2_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3000:3: lv_initExpression_2_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getConstructorPartCSAccess().getInitExpressionExpCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleConstructorPartCS7090);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3024:1: entryRulePrimitiveLiteralExpCS returns [EObject current=null] : iv_rulePrimitiveLiteralExpCS= rulePrimitiveLiteralExpCS EOF ;
    public final EObject entryRulePrimitiveLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3025:2: (iv_rulePrimitiveLiteralExpCS= rulePrimitiveLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3026:2: iv_rulePrimitiveLiteralExpCS= rulePrimitiveLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePrimitiveLiteralExpCS_in_entryRulePrimitiveLiteralExpCS7126);
            iv_rulePrimitiveLiteralExpCS=rulePrimitiveLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimitiveLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrimitiveLiteralExpCS7136); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3033:1: rulePrimitiveLiteralExpCS returns [EObject current=null] : (this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS | this_StringLiteralExpCS_1= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_5= ruleNullLiteralExpCS ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3036:28: ( (this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS | this_StringLiteralExpCS_1= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_5= ruleNullLiteralExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3037:1: (this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS | this_StringLiteralExpCS_1= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_5= ruleNullLiteralExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3037:1: (this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS | this_StringLiteralExpCS_1= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_5= ruleNullLiteralExpCS )
            int alt55=6;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt55=1;
                }
                break;
            case RULE_SINGLE_QUOTED_STRING:
                {
                alt55=2;
                }
                break;
            case 70:
            case 71:
                {
                alt55=3;
                }
                break;
            case 42:
                {
                alt55=4;
                }
                break;
            case 72:
                {
                alt55=5;
                }
                break;
            case 73:
                {
                alt55=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;
            }

            switch (alt55) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3038:2: this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getNumberLiteralExpCSParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNumberLiteralExpCS_in_rulePrimitiveLiteralExpCS7186);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3051:2: this_StringLiteralExpCS_1= ruleStringLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getStringLiteralExpCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleStringLiteralExpCS_in_rulePrimitiveLiteralExpCS7216);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3064:2: this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getBooleanLiteralExpCSParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleBooleanLiteralExpCS_in_rulePrimitiveLiteralExpCS7246);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3077:2: this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getUnlimitedNaturalLiteralExpCSParserRuleCall_3()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUnlimitedNaturalLiteralExpCS_in_rulePrimitiveLiteralExpCS7276);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3090:2: this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getInvalidLiteralExpCSParserRuleCall_4()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleInvalidLiteralExpCS_in_rulePrimitiveLiteralExpCS7306);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3103:2: this_NullLiteralExpCS_5= ruleNullLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getNullLiteralExpCSParserRuleCall_5()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNullLiteralExpCS_in_rulePrimitiveLiteralExpCS7336);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3122:1: entryRuleTupleLiteralExpCS returns [EObject current=null] : iv_ruleTupleLiteralExpCS= ruleTupleLiteralExpCS EOF ;
    public final EObject entryRuleTupleLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTupleLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3123:2: (iv_ruleTupleLiteralExpCS= ruleTupleLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3124:2: iv_ruleTupleLiteralExpCS= ruleTupleLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTupleLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralExpCS_in_entryRuleTupleLiteralExpCS7371);
            iv_ruleTupleLiteralExpCS=ruleTupleLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTupleLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTupleLiteralExpCS7381); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3131:1: ruleTupleLiteralExpCS returns [EObject current=null] : (otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}' ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3134:28: ( (otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3135:1: (otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3135:1: (otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3135:3: otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleTupleLiteralExpCS7418); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getTupleLiteralExpCSAccess().getTupleKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleTupleLiteralExpCS7430); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getTupleLiteralExpCSAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3143:1: ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3144:1: (lv_ownedParts_2_0= ruleTupleLiteralPartCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3144:1: (lv_ownedParts_2_0= ruleTupleLiteralPartCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3145:3: lv_ownedParts_2_0= ruleTupleLiteralPartCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTupleLiteralExpCSAccess().getOwnedPartsTupleLiteralPartCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralPartCS_in_ruleTupleLiteralExpCS7451);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3161:2: (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==20) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3161:4: otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) )
            	    {
            	    otherlv_3=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleTupleLiteralExpCS7464); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getTupleLiteralExpCSAccess().getCommaKeyword_3_0());
            	          
            	    }
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3165:1: ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3166:1: (lv_ownedParts_4_0= ruleTupleLiteralPartCS )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3166:1: (lv_ownedParts_4_0= ruleTupleLiteralPartCS )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3167:3: lv_ownedParts_4_0= ruleTupleLiteralPartCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTupleLiteralExpCSAccess().getOwnedPartsTupleLiteralPartCSParserRuleCall_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralPartCS_in_ruleTupleLiteralExpCS7485);
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
            	    break loop56;
                }
            } while (true);

            otherlv_5=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleTupleLiteralExpCS7499); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3195:1: entryRuleTupleLiteralPartCS returns [EObject current=null] : iv_ruleTupleLiteralPartCS= ruleTupleLiteralPartCS EOF ;
    public final EObject entryRuleTupleLiteralPartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTupleLiteralPartCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3196:2: (iv_ruleTupleLiteralPartCS= ruleTupleLiteralPartCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3197:2: iv_ruleTupleLiteralPartCS= ruleTupleLiteralPartCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTupleLiteralPartCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralPartCS_in_entryRuleTupleLiteralPartCS7535);
            iv_ruleTupleLiteralPartCS=ruleTupleLiteralPartCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTupleLiteralPartCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTupleLiteralPartCS7545); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3204:1: ruleTupleLiteralPartCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) ) ) ;
    public final EObject ruleTupleLiteralPartCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;

        EObject lv_initExpression_4_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3207:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3208:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3208:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3208:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3208:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3209:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3209:1: (lv_name_0_0= ruleUnrestrictedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3210:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTupleLiteralPartCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleTupleLiteralPartCS7591);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3226:2: (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==31) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3226:4: otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                    {
                    otherlv_1=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleTupleLiteralPartCS7604); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getTupleLiteralPartCSAccess().getColonKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3230:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3231:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3231:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3232:3: lv_ownedType_2_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTupleLiteralPartCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleTupleLiteralPartCS7625);
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

            otherlv_3=(Token)match(input,48,FollowSets000.FOLLOW_48_in_ruleTupleLiteralPartCS7639); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getTupleLiteralPartCSAccess().getEqualsSignKeyword_2());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3252:1: ( (lv_initExpression_4_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3253:1: (lv_initExpression_4_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3253:1: (lv_initExpression_4_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3254:3: lv_initExpression_4_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTupleLiteralPartCSAccess().getInitExpressionExpCSParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleTupleLiteralPartCS7660);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3278:1: entryRuleNumberLiteralExpCS returns [EObject current=null] : iv_ruleNumberLiteralExpCS= ruleNumberLiteralExpCS EOF ;
    public final EObject entryRuleNumberLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3279:2: (iv_ruleNumberLiteralExpCS= ruleNumberLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3280:2: iv_ruleNumberLiteralExpCS= ruleNumberLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumberLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNumberLiteralExpCS_in_entryRuleNumberLiteralExpCS7696);
            iv_ruleNumberLiteralExpCS=ruleNumberLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumberLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNumberLiteralExpCS7706); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3287:1: ruleNumberLiteralExpCS returns [EObject current=null] : ( (lv_name_0_0= ruleNUMBER_LITERAL ) ) ;
    public final EObject ruleNumberLiteralExpCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3290:28: ( ( (lv_name_0_0= ruleNUMBER_LITERAL ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3291:1: ( (lv_name_0_0= ruleNUMBER_LITERAL ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3291:1: ( (lv_name_0_0= ruleNUMBER_LITERAL ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3292:1: (lv_name_0_0= ruleNUMBER_LITERAL )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3292:1: (lv_name_0_0= ruleNUMBER_LITERAL )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3293:3: lv_name_0_0= ruleNUMBER_LITERAL
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNumberLiteralExpCSAccess().getNameNUMBER_LITERALParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleNUMBER_LITERAL_in_ruleNumberLiteralExpCS7751);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3317:1: entryRuleStringLiteralExpCS returns [EObject current=null] : iv_ruleStringLiteralExpCS= ruleStringLiteralExpCS EOF ;
    public final EObject entryRuleStringLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3318:2: (iv_ruleStringLiteralExpCS= ruleStringLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3319:2: iv_ruleStringLiteralExpCS= ruleStringLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStringLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleStringLiteralExpCS_in_entryRuleStringLiteralExpCS7786);
            iv_ruleStringLiteralExpCS=ruleStringLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStringLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleStringLiteralExpCS7796); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3326:1: ruleStringLiteralExpCS returns [EObject current=null] : ( (lv_name_0_0= ruleStringLiteral ) )+ ;
    public final EObject ruleStringLiteralExpCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3329:28: ( ( (lv_name_0_0= ruleStringLiteral ) )+ )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3330:1: ( (lv_name_0_0= ruleStringLiteral ) )+
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3330:1: ( (lv_name_0_0= ruleStringLiteral ) )+
            int cnt58=0;
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==RULE_SINGLE_QUOTED_STRING) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3331:1: (lv_name_0_0= ruleStringLiteral )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3331:1: (lv_name_0_0= ruleStringLiteral )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3332:3: lv_name_0_0= ruleStringLiteral
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getStringLiteralExpCSAccess().getNameStringLiteralParserRuleCall_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleStringLiteral_in_ruleStringLiteralExpCS7841);
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
            	    if ( cnt58 >= 1 ) break loop58;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(58, input);
                        throw eee;
                }
                cnt58++;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3356:1: entryRuleBooleanLiteralExpCS returns [EObject current=null] : iv_ruleBooleanLiteralExpCS= ruleBooleanLiteralExpCS EOF ;
    public final EObject entryRuleBooleanLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3357:2: (iv_ruleBooleanLiteralExpCS= ruleBooleanLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3358:2: iv_ruleBooleanLiteralExpCS= ruleBooleanLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBooleanLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleBooleanLiteralExpCS_in_entryRuleBooleanLiteralExpCS7877);
            iv_ruleBooleanLiteralExpCS=ruleBooleanLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBooleanLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBooleanLiteralExpCS7887); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3365:1: ruleBooleanLiteralExpCS returns [EObject current=null] : ( ( (lv_name_0_0= 'true' ) ) | ( (lv_name_1_0= 'false' ) ) ) ;
    public final EObject ruleBooleanLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3368:28: ( ( ( (lv_name_0_0= 'true' ) ) | ( (lv_name_1_0= 'false' ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3369:1: ( ( (lv_name_0_0= 'true' ) ) | ( (lv_name_1_0= 'false' ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3369:1: ( ( (lv_name_0_0= 'true' ) ) | ( (lv_name_1_0= 'false' ) ) )
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==70) ) {
                alt59=1;
            }
            else if ( (LA59_0==71) ) {
                alt59=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;
            }
            switch (alt59) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3369:2: ( (lv_name_0_0= 'true' ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3369:2: ( (lv_name_0_0= 'true' ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3370:1: (lv_name_0_0= 'true' )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3370:1: (lv_name_0_0= 'true' )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3371:3: lv_name_0_0= 'true'
                    {
                    lv_name_0_0=(Token)match(input,70,FollowSets000.FOLLOW_70_in_ruleBooleanLiteralExpCS7930); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3385:6: ( (lv_name_1_0= 'false' ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3385:6: ( (lv_name_1_0= 'false' ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3386:1: (lv_name_1_0= 'false' )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3386:1: (lv_name_1_0= 'false' )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3387:3: lv_name_1_0= 'false'
                    {
                    lv_name_1_0=(Token)match(input,71,FollowSets000.FOLLOW_71_in_ruleBooleanLiteralExpCS7967); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3408:1: entryRuleUnlimitedNaturalLiteralExpCS returns [EObject current=null] : iv_ruleUnlimitedNaturalLiteralExpCS= ruleUnlimitedNaturalLiteralExpCS EOF ;
    public final EObject entryRuleUnlimitedNaturalLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnlimitedNaturalLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3409:2: (iv_ruleUnlimitedNaturalLiteralExpCS= ruleUnlimitedNaturalLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3410:2: iv_ruleUnlimitedNaturalLiteralExpCS= ruleUnlimitedNaturalLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnlimitedNaturalLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnlimitedNaturalLiteralExpCS_in_entryRuleUnlimitedNaturalLiteralExpCS8016);
            iv_ruleUnlimitedNaturalLiteralExpCS=ruleUnlimitedNaturalLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnlimitedNaturalLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnlimitedNaturalLiteralExpCS8026); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3417:1: ruleUnlimitedNaturalLiteralExpCS returns [EObject current=null] : ( () otherlv_1= '*' ) ;
    public final EObject ruleUnlimitedNaturalLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3420:28: ( ( () otherlv_1= '*' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3421:1: ( () otherlv_1= '*' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3421:1: ( () otherlv_1= '*' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3421:2: () otherlv_1= '*'
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3421:2: ()
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3422:2: 
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

            otherlv_1=(Token)match(input,42,FollowSets000.FOLLOW_42_in_ruleUnlimitedNaturalLiteralExpCS8075); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3442:1: entryRuleInvalidLiteralExpCS returns [EObject current=null] : iv_ruleInvalidLiteralExpCS= ruleInvalidLiteralExpCS EOF ;
    public final EObject entryRuleInvalidLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInvalidLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3443:2: (iv_ruleInvalidLiteralExpCS= ruleInvalidLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3444:2: iv_ruleInvalidLiteralExpCS= ruleInvalidLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInvalidLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleInvalidLiteralExpCS_in_entryRuleInvalidLiteralExpCS8111);
            iv_ruleInvalidLiteralExpCS=ruleInvalidLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInvalidLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleInvalidLiteralExpCS8121); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3451:1: ruleInvalidLiteralExpCS returns [EObject current=null] : ( () otherlv_1= 'invalid' ) ;
    public final EObject ruleInvalidLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3454:28: ( ( () otherlv_1= 'invalid' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3455:1: ( () otherlv_1= 'invalid' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3455:1: ( () otherlv_1= 'invalid' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3455:2: () otherlv_1= 'invalid'
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3455:2: ()
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3456:2: 
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

            otherlv_1=(Token)match(input,72,FollowSets000.FOLLOW_72_in_ruleInvalidLiteralExpCS8170); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3476:1: entryRuleNullLiteralExpCS returns [EObject current=null] : iv_ruleNullLiteralExpCS= ruleNullLiteralExpCS EOF ;
    public final EObject entryRuleNullLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3477:2: (iv_ruleNullLiteralExpCS= ruleNullLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3478:2: iv_ruleNullLiteralExpCS= ruleNullLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNullLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNullLiteralExpCS_in_entryRuleNullLiteralExpCS8206);
            iv_ruleNullLiteralExpCS=ruleNullLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNullLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNullLiteralExpCS8216); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3485:1: ruleNullLiteralExpCS returns [EObject current=null] : ( () otherlv_1= 'null' ) ;
    public final EObject ruleNullLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3488:28: ( ( () otherlv_1= 'null' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3489:1: ( () otherlv_1= 'null' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3489:1: ( () otherlv_1= 'null' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3489:2: () otherlv_1= 'null'
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3489:2: ()
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3490:2: 
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

            otherlv_1=(Token)match(input,73,FollowSets000.FOLLOW_73_in_ruleNullLiteralExpCS8265); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3510:1: entryRuleTypeLiteralCS returns [EObject current=null] : iv_ruleTypeLiteralCS= ruleTypeLiteralCS EOF ;
    public final EObject entryRuleTypeLiteralCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeLiteralCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3511:2: (iv_ruleTypeLiteralCS= ruleTypeLiteralCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3512:2: iv_ruleTypeLiteralCS= ruleTypeLiteralCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeLiteralCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralCS_in_entryRuleTypeLiteralCS8301);
            iv_ruleTypeLiteralCS=ruleTypeLiteralCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeLiteralCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeLiteralCS8311); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3519:1: ruleTypeLiteralCS returns [EObject current=null] : (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS | this_CollectionTypeCS_1= ruleCollectionTypeCS | this_TupleTypeCS_2= ruleTupleTypeCS ) ;
    public final EObject ruleTypeLiteralCS() throws RecognitionException {
        EObject current = null;

        EObject this_PrimitiveTypeCS_0 = null;

        EObject this_CollectionTypeCS_1 = null;

        EObject this_TupleTypeCS_2 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3522:28: ( (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS | this_CollectionTypeCS_1= ruleCollectionTypeCS | this_TupleTypeCS_2= ruleTupleTypeCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3523:1: (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS | this_CollectionTypeCS_1= ruleCollectionTypeCS | this_TupleTypeCS_2= ruleTupleTypeCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3523:1: (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS | this_CollectionTypeCS_1= ruleCollectionTypeCS | this_TupleTypeCS_2= ruleTupleTypeCS )
            int alt60=3;
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
                alt60=1;
                }
                break;
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
                {
                alt60=2;
                }
                break;
            case 55:
                {
                alt60=3;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3524:2: this_PrimitiveTypeCS_0= rulePrimitiveTypeCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeLiteralCSAccess().getPrimitiveTypeCSParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrimitiveTypeCS_in_ruleTypeLiteralCS8361);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3537:2: this_CollectionTypeCS_1= ruleCollectionTypeCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeLiteralCSAccess().getCollectionTypeCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCollectionTypeCS_in_ruleTypeLiteralCS8391);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3550:2: this_TupleTypeCS_2= ruleTupleTypeCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeLiteralCSAccess().getTupleTypeCSParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTupleTypeCS_in_ruleTypeLiteralCS8421);
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


    // $ANTLR start "entryRuleTypeLiteralExpCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3569:1: entryRuleTypeLiteralExpCS returns [EObject current=null] : iv_ruleTypeLiteralExpCS= ruleTypeLiteralExpCS EOF ;
    public final EObject entryRuleTypeLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3570:2: (iv_ruleTypeLiteralExpCS= ruleTypeLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3571:2: iv_ruleTypeLiteralExpCS= ruleTypeLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralExpCS_in_entryRuleTypeLiteralExpCS8456);
            iv_ruleTypeLiteralExpCS=ruleTypeLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeLiteralExpCS8466); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3578:1: ruleTypeLiteralExpCS returns [EObject current=null] : ( (lv_ownedType_0_0= ruleTypeLiteralCS ) ) ;
    public final EObject ruleTypeLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject lv_ownedType_0_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3581:28: ( ( (lv_ownedType_0_0= ruleTypeLiteralCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3582:1: ( (lv_ownedType_0_0= ruleTypeLiteralCS ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3582:1: ( (lv_ownedType_0_0= ruleTypeLiteralCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3583:1: (lv_ownedType_0_0= ruleTypeLiteralCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3583:1: (lv_ownedType_0_0= ruleTypeLiteralCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3584:3: lv_ownedType_0_0= ruleTypeLiteralCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypeLiteralExpCSAccess().getOwnedTypeTypeLiteralCSParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralCS_in_ruleTypeLiteralExpCS8511);
            lv_ownedType_0_0=ruleTypeLiteralCS();

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
                      		"TypeLiteralCS");
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3608:1: entryRuleTypeNameExpCS returns [EObject current=null] : iv_ruleTypeNameExpCS= ruleTypeNameExpCS EOF ;
    public final EObject entryRuleTypeNameExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeNameExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3609:2: (iv_ruleTypeNameExpCS= ruleTypeNameExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3610:2: iv_ruleTypeNameExpCS= ruleTypeNameExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeNameExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeNameExpCS_in_entryRuleTypeNameExpCS8546);
            iv_ruleTypeNameExpCS=ruleTypeNameExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeNameExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeNameExpCS8556); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3617:1: ruleTypeNameExpCS returns [EObject current=null] : ( ( ( ( ( ruleUnrestrictedName ) ) otherlv_1= '::' ( ( ( ruleUnreservedName ) ) otherlv_3= '::' )* ) ( ( ruleUnreservedName ) ) ) | ( ( ruleUnrestrictedName ) ) ) ;
    public final EObject ruleTypeNameExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3620:28: ( ( ( ( ( ( ruleUnrestrictedName ) ) otherlv_1= '::' ( ( ( ruleUnreservedName ) ) otherlv_3= '::' )* ) ( ( ruleUnreservedName ) ) ) | ( ( ruleUnrestrictedName ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3621:1: ( ( ( ( ( ruleUnrestrictedName ) ) otherlv_1= '::' ( ( ( ruleUnreservedName ) ) otherlv_3= '::' )* ) ( ( ruleUnreservedName ) ) ) | ( ( ruleUnrestrictedName ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3621:1: ( ( ( ( ( ruleUnrestrictedName ) ) otherlv_1= '::' ( ( ( ruleUnreservedName ) ) otherlv_3= '::' )* ) ( ( ruleUnreservedName ) ) ) | ( ( ruleUnrestrictedName ) ) )
            int alt62=2;
            alt62 = dfa62.predict(input);
            switch (alt62) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3621:2: ( ( ( ( ruleUnrestrictedName ) ) otherlv_1= '::' ( ( ( ruleUnreservedName ) ) otherlv_3= '::' )* ) ( ( ruleUnreservedName ) ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3621:2: ( ( ( ( ruleUnrestrictedName ) ) otherlv_1= '::' ( ( ( ruleUnreservedName ) ) otherlv_3= '::' )* ) ( ( ruleUnreservedName ) ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3621:3: ( ( ( ruleUnrestrictedName ) ) otherlv_1= '::' ( ( ( ruleUnreservedName ) ) otherlv_3= '::' )* ) ( ( ruleUnreservedName ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3621:3: ( ( ( ruleUnrestrictedName ) ) otherlv_1= '::' ( ( ( ruleUnreservedName ) ) otherlv_3= '::' )* )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3621:4: ( ( ruleUnrestrictedName ) ) otherlv_1= '::' ( ( ( ruleUnreservedName ) ) otherlv_3= '::' )*
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3621:4: ( ( ruleUnrestrictedName ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3622:1: ( ruleUnrestrictedName )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3622:1: ( ruleUnrestrictedName )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3623:3: ruleUnrestrictedName
                    {
                    if ( state.backtracking==0 ) {
                       
                      		  /* */ 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getTypeNameExpCSRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeNameExpCSAccess().getNamespaceNamespaceCrossReference_0_0_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleTypeNameExpCS8610);
                    ruleUnrestrictedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_1=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleTypeNameExpCS8622); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getTypeNameExpCSAccess().getColonColonKeyword_0_0_1());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3643:1: ( ( ( ruleUnreservedName ) ) otherlv_3= '::' )*
                    loop61:
                    do {
                        int alt61=2;
                        alt61 = dfa61.predict(input);
                        switch (alt61) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3643:2: ( ( ruleUnreservedName ) ) otherlv_3= '::'
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3643:2: ( ( ruleUnreservedName ) )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3644:1: ( ruleUnreservedName )
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3644:1: ( ruleUnreservedName )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3645:3: ruleUnreservedName
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      		  /* */ 
                    	      		
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      			if (current==null) {
                    	      	            current = createModelElement(grammarAccess.getTypeNameExpCSRule());
                    	      	        }
                    	              
                    	    }
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getTypeNameExpCSAccess().getNamespaceNamespaceCrossReference_0_0_2_0_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleUnreservedName_in_ruleTypeNameExpCS8650);
                    	    ruleUnreservedName();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }

                    	    otherlv_3=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleTypeNameExpCS8662); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getTypeNameExpCSAccess().getColonColonKeyword_0_0_2_1());
                    	          
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop61;
                        }
                    } while (true);


                    }

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3665:4: ( ( ruleUnreservedName ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3666:1: ( ruleUnreservedName )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3666:1: ( ruleUnreservedName )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3667:3: ruleUnreservedName
                    {
                    if ( state.backtracking==0 ) {
                       
                      		  /* */ 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getTypeNameExpCSRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeNameExpCSAccess().getElementTypeCrossReference_0_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUnreservedName_in_ruleTypeNameExpCS8692);
                    ruleUnreservedName();

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
                case 2 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3684:6: ( ( ruleUnrestrictedName ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3684:6: ( ( ruleUnrestrictedName ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3685:1: ( ruleUnrestrictedName )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3685:1: ( ruleUnrestrictedName )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3686:3: ruleUnrestrictedName
                    {
                    if ( state.backtracking==0 ) {
                       
                      		  /* */ 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getTypeNameExpCSRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeNameExpCSAccess().getElementTypeCrossReference_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleTypeNameExpCS8726);
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


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3710:1: entryRuleTypeExpCS returns [EObject current=null] : iv_ruleTypeExpCS= ruleTypeExpCS EOF ;
    public final EObject entryRuleTypeExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3711:2: (iv_ruleTypeExpCS= ruleTypeExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3712:2: iv_ruleTypeExpCS= ruleTypeExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_entryRuleTypeExpCS8762);
            iv_ruleTypeExpCS=ruleTypeExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeExpCS8772); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3719:1: ruleTypeExpCS returns [EObject current=null] : (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS ) ;
    public final EObject ruleTypeExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_TypeNameExpCS_0 = null;

        EObject this_TypeLiteralCS_1 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3722:28: ( (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3723:1: (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3723:1: (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS )
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( ((LA63_0>=RULE_SIMPLE_ID && LA63_0<=RULE_ESCAPED_ID)||LA63_0==14||LA63_0==19||(LA63_0>=21 && LA63_0<=22)||(LA63_0>=24 && LA63_0<=27)||LA63_0==32||LA63_0==35||(LA63_0>=37 && LA63_0<=38)) ) {
                alt63=1;
            }
            else if ( ((LA63_0>=55 && LA63_0<=68)) ) {
                alt63=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 63, 0, input);

                throw nvae;
            }
            switch (alt63) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3724:2: this_TypeNameExpCS_0= ruleTypeNameExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeExpCSAccess().getTypeNameExpCSParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeNameExpCS_in_ruleTypeExpCS8822);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3737:2: this_TypeLiteralCS_1= ruleTypeLiteralCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeExpCSAccess().getTypeLiteralCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralCS_in_ruleTypeExpCS8852);
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


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3756:1: entryRuleExpCS returns [EObject current=null] : iv_ruleExpCS= ruleExpCS EOF ;
    public final EObject entryRuleExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3757:2: (iv_ruleExpCS= ruleExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3758:2: iv_ruleExpCS= ruleExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_entryRuleExpCS8887);
            iv_ruleExpCS=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleExpCS8897); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3765:1: ruleExpCS returns [EObject current=null] : this_InfixedExpCS_0= ruleInfixedExpCS ;
    public final EObject ruleExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_InfixedExpCS_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3768:28: (this_InfixedExpCS_0= ruleInfixedExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3770:2: this_InfixedExpCS_0= ruleInfixedExpCS
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getExpCSAccess().getInfixedExpCSParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleInfixedExpCS_in_ruleExpCS8946);
            this_InfixedExpCS_0=ruleInfixedExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_InfixedExpCS_0; 
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


    // $ANTLR start "entryRuleInfixedExpCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3789:1: entryRuleInfixedExpCS returns [EObject current=null] : iv_ruleInfixedExpCS= ruleInfixedExpCS EOF ;
    public final EObject entryRuleInfixedExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInfixedExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3790:2: (iv_ruleInfixedExpCS= ruleInfixedExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3791:2: iv_ruleInfixedExpCS= ruleInfixedExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInfixedExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleInfixedExpCS_in_entryRuleInfixedExpCS8980);
            iv_ruleInfixedExpCS=ruleInfixedExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInfixedExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleInfixedExpCS8990); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInfixedExpCS"


    // $ANTLR start "ruleInfixedExpCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3798:1: ruleInfixedExpCS returns [EObject current=null] : (this_PrefixedExpCS_0= rulePrefixedExpCS ( () ( ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) )+ )? ) ;
    public final EObject ruleInfixedExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_PrefixedExpCS_0 = null;

        EObject lv_ownedOperator_2_0 = null;

        EObject lv_ownedExpression_3_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3801:28: ( (this_PrefixedExpCS_0= rulePrefixedExpCS ( () ( ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) )+ )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3802:1: (this_PrefixedExpCS_0= rulePrefixedExpCS ( () ( ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) )+ )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3802:1: (this_PrefixedExpCS_0= rulePrefixedExpCS ( () ( ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) )+ )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3803:2: this_PrefixedExpCS_0= rulePrefixedExpCS ( () ( ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) )+ )?
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getInfixedExpCSAccess().getPrefixedExpCSParserRuleCall_0()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_rulePrefixedExpCS_in_ruleInfixedExpCS9040);
            this_PrefixedExpCS_0=rulePrefixedExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_PrefixedExpCS_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3814:1: ( () ( ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) )+ )?
            int alt65=2;
            alt65 = dfa65.predict(input);
            switch (alt65) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3814:2: () ( ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) )+
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3814:2: ()
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3815:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElementAndAdd(
                                  grammarAccess.getInfixedExpCSAccess().getInfixExpCSOwnedExpressionAction_1_0(),
                                  current);
                          
                    }

                    }

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3823:2: ( ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) )+
                    int cnt64=0;
                    loop64:
                    do {
                        int alt64=2;
                        alt64 = dfa64.predict(input);
                        switch (alt64) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3823:3: ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) )
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3823:3: ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3824:1: (lv_ownedOperator_2_0= ruleBinaryOperatorCS )
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3824:1: (lv_ownedOperator_2_0= ruleBinaryOperatorCS )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3825:3: lv_ownedOperator_2_0= ruleBinaryOperatorCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getInfixedExpCSAccess().getOwnedOperatorBinaryOperatorCSParserRuleCall_1_1_0_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleBinaryOperatorCS_in_ruleInfixedExpCS9074);
                    	    lv_ownedOperator_2_0=ruleBinaryOperatorCS();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getInfixedExpCSRule());
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

                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3841:2: ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3842:1: (lv_ownedExpression_3_0= rulePrefixedExpCS )
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3842:1: (lv_ownedExpression_3_0= rulePrefixedExpCS )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3843:3: lv_ownedExpression_3_0= rulePrefixedExpCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getInfixedExpCSAccess().getOwnedExpressionPrefixedExpCSParserRuleCall_1_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_rulePrefixedExpCS_in_ruleInfixedExpCS9095);
                    	    lv_ownedExpression_3_0=rulePrefixedExpCS();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getInfixedExpCSRule());
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


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt64 >= 1 ) break loop64;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(64, input);
                                throw eee;
                        }
                        cnt64++;
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
    // $ANTLR end "ruleInfixedExpCS"


    // $ANTLR start "entryRuleBinaryOperatorCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3867:1: entryRuleBinaryOperatorCS returns [EObject current=null] : iv_ruleBinaryOperatorCS= ruleBinaryOperatorCS EOF ;
    public final EObject entryRuleBinaryOperatorCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinaryOperatorCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3868:2: (iv_ruleBinaryOperatorCS= ruleBinaryOperatorCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3869:2: iv_ruleBinaryOperatorCS= ruleBinaryOperatorCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBinaryOperatorCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleBinaryOperatorCS_in_entryRuleBinaryOperatorCS9135);
            iv_ruleBinaryOperatorCS=ruleBinaryOperatorCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBinaryOperatorCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBinaryOperatorCS9145); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3876:1: ruleBinaryOperatorCS returns [EObject current=null] : (this_InfixOperatorCS_0= ruleInfixOperatorCS | this_NavigationOperatorCS_1= ruleNavigationOperatorCS ) ;
    public final EObject ruleBinaryOperatorCS() throws RecognitionException {
        EObject current = null;

        EObject this_InfixOperatorCS_0 = null;

        EObject this_NavigationOperatorCS_1 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3879:28: ( (this_InfixOperatorCS_0= ruleInfixOperatorCS | this_NavigationOperatorCS_1= ruleNavigationOperatorCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3880:1: (this_InfixOperatorCS_0= ruleInfixOperatorCS | this_NavigationOperatorCS_1= ruleNavigationOperatorCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3880:1: (this_InfixOperatorCS_0= ruleInfixOperatorCS | this_NavigationOperatorCS_1= ruleNavigationOperatorCS )
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( ((LA66_0>=39 && LA66_0<=40)||(LA66_0>=42 && LA66_0<=53)) ) {
                alt66=1;
            }
            else if ( (LA66_0==36||LA66_0==54) ) {
                alt66=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 66, 0, input);

                throw nvae;
            }
            switch (alt66) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3881:2: this_InfixOperatorCS_0= ruleInfixOperatorCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBinaryOperatorCSAccess().getInfixOperatorCSParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleInfixOperatorCS_in_ruleBinaryOperatorCS9195);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3894:2: this_NavigationOperatorCS_1= ruleNavigationOperatorCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBinaryOperatorCSAccess().getNavigationOperatorCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNavigationOperatorCS_in_ruleBinaryOperatorCS9225);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3913:1: entryRuleInfixOperatorCS returns [EObject current=null] : iv_ruleInfixOperatorCS= ruleInfixOperatorCS EOF ;
    public final EObject entryRuleInfixOperatorCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInfixOperatorCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3914:2: (iv_ruleInfixOperatorCS= ruleInfixOperatorCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3915:2: iv_ruleInfixOperatorCS= ruleInfixOperatorCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInfixOperatorCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleInfixOperatorCS_in_entryRuleInfixOperatorCS9260);
            iv_ruleInfixOperatorCS=ruleInfixOperatorCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInfixOperatorCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleInfixOperatorCS9270); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3922:1: ruleInfixOperatorCS returns [EObject current=null] : ( (lv_name_0_0= ruleInfixOperator ) ) ;
    public final EObject ruleInfixOperatorCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3925:28: ( ( (lv_name_0_0= ruleInfixOperator ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3926:1: ( (lv_name_0_0= ruleInfixOperator ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3926:1: ( (lv_name_0_0= ruleInfixOperator ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3927:1: (lv_name_0_0= ruleInfixOperator )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3927:1: (lv_name_0_0= ruleInfixOperator )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3928:3: lv_name_0_0= ruleInfixOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getInfixOperatorCSAccess().getNameInfixOperatorParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleInfixOperator_in_ruleInfixOperatorCS9315);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3952:1: entryRuleNavigationOperatorCS returns [EObject current=null] : iv_ruleNavigationOperatorCS= ruleNavigationOperatorCS EOF ;
    public final EObject entryRuleNavigationOperatorCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigationOperatorCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3953:2: (iv_ruleNavigationOperatorCS= ruleNavigationOperatorCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3954:2: iv_ruleNavigationOperatorCS= ruleNavigationOperatorCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigationOperatorCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigationOperatorCS_in_entryRuleNavigationOperatorCS9350);
            iv_ruleNavigationOperatorCS=ruleNavigationOperatorCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigationOperatorCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigationOperatorCS9360); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3961:1: ruleNavigationOperatorCS returns [EObject current=null] : ( (lv_name_0_0= ruleNavigationOperator ) ) ;
    public final EObject ruleNavigationOperatorCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3964:28: ( ( (lv_name_0_0= ruleNavigationOperator ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3965:1: ( (lv_name_0_0= ruleNavigationOperator ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3965:1: ( (lv_name_0_0= ruleNavigationOperator ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3966:1: (lv_name_0_0= ruleNavigationOperator )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3966:1: (lv_name_0_0= ruleNavigationOperator )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3967:3: lv_name_0_0= ruleNavigationOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNavigationOperatorCSAccess().getNameNavigationOperatorParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigationOperator_in_ruleNavigationOperatorCS9405);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3991:1: entryRulePrefixedExpCS returns [EObject current=null] : iv_rulePrefixedExpCS= rulePrefixedExpCS EOF ;
    public final EObject entryRulePrefixedExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrefixedExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3992:2: (iv_rulePrefixedExpCS= rulePrefixedExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3993:2: iv_rulePrefixedExpCS= rulePrefixedExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrefixedExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePrefixedExpCS_in_entryRulePrefixedExpCS9440);
            iv_rulePrefixedExpCS=rulePrefixedExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrefixedExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrefixedExpCS9450); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4000:1: rulePrefixedExpCS returns [EObject current=null] : (this_PrimaryExpCS_0= rulePrimaryExpCS | ( () ( (lv_ownedOperator_2_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_3_0= rulePrimaryExpCS ) ) ) ) ;
    public final EObject rulePrefixedExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_PrimaryExpCS_0 = null;

        EObject lv_ownedOperator_2_0 = null;

        EObject lv_ownedExpression_3_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4003:28: ( (this_PrimaryExpCS_0= rulePrimaryExpCS | ( () ( (lv_ownedOperator_2_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_3_0= rulePrimaryExpCS ) ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4004:1: (this_PrimaryExpCS_0= rulePrimaryExpCS | ( () ( (lv_ownedOperator_2_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_3_0= rulePrimaryExpCS ) ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4004:1: (this_PrimaryExpCS_0= rulePrimaryExpCS | ( () ( (lv_ownedOperator_2_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_3_0= rulePrimaryExpCS ) ) ) )
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( ((LA68_0>=RULE_SIMPLE_ID && LA68_0<=RULE_SINGLE_QUOTED_STRING)||LA68_0==14||LA68_0==19||(LA68_0>=21 && LA68_0<=22)||(LA68_0>=24 && LA68_0<=28)||LA68_0==32||LA68_0==35||(LA68_0>=37 && LA68_0<=38)||LA68_0==42||(LA68_0>=55 && LA68_0<=68)||(LA68_0>=70 && LA68_0<=73)||LA68_0==76||(LA68_0>=80 && LA68_0<=81)) ) {
                alt68=1;
            }
            else if ( ((LA68_0>=40 && LA68_0<=41)) ) {
                alt68=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 68, 0, input);

                throw nvae;
            }
            switch (alt68) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4005:2: this_PrimaryExpCS_0= rulePrimaryExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrefixedExpCSAccess().getPrimaryExpCSParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrimaryExpCS_in_rulePrefixedExpCS9500);
                    this_PrimaryExpCS_0=rulePrimaryExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_PrimaryExpCS_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4017:6: ( () ( (lv_ownedOperator_2_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_3_0= rulePrimaryExpCS ) ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4017:6: ( () ( (lv_ownedOperator_2_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_3_0= rulePrimaryExpCS ) ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4017:7: () ( (lv_ownedOperator_2_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_3_0= rulePrimaryExpCS ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4017:7: ()
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4018:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getPrefixedExpCSAccess().getPrefixExpCSAction_1_0(),
                                  current);
                          
                    }

                    }

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4026:2: ( (lv_ownedOperator_2_0= ruleUnaryOperatorCS ) )+
                    int cnt67=0;
                    loop67:
                    do {
                        int alt67=2;
                        int LA67_0 = input.LA(1);

                        if ( ((LA67_0>=40 && LA67_0<=41)) ) {
                            alt67=1;
                        }


                        switch (alt67) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4027:1: (lv_ownedOperator_2_0= ruleUnaryOperatorCS )
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4027:1: (lv_ownedOperator_2_0= ruleUnaryOperatorCS )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4028:3: lv_ownedOperator_2_0= ruleUnaryOperatorCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getPrefixedExpCSAccess().getOwnedOperatorUnaryOperatorCSParserRuleCall_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleUnaryOperatorCS_in_rulePrefixedExpCS9539);
                    	    lv_ownedOperator_2_0=ruleUnaryOperatorCS();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getPrefixedExpCSRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"ownedOperator",
                    	              		lv_ownedOperator_2_0, 
                    	              		"UnaryOperatorCS");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt67 >= 1 ) break loop67;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(67, input);
                                throw eee;
                        }
                        cnt67++;
                    } while (true);

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4044:3: ( (lv_ownedExpression_3_0= rulePrimaryExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4045:1: (lv_ownedExpression_3_0= rulePrimaryExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4045:1: (lv_ownedExpression_3_0= rulePrimaryExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4046:3: lv_ownedExpression_3_0= rulePrimaryExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrefixedExpCSAccess().getOwnedExpressionPrimaryExpCSParserRuleCall_1_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrimaryExpCS_in_rulePrefixedExpCS9561);
                    lv_ownedExpression_3_0=rulePrimaryExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPrefixedExpCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedExpression",
                              		lv_ownedExpression_3_0, 
                              		"PrimaryExpCS");
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
    // $ANTLR end "rulePrefixedExpCS"


    // $ANTLR start "entryRuleUnaryOperatorCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4070:1: entryRuleUnaryOperatorCS returns [EObject current=null] : iv_ruleUnaryOperatorCS= ruleUnaryOperatorCS EOF ;
    public final EObject entryRuleUnaryOperatorCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryOperatorCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4071:2: (iv_ruleUnaryOperatorCS= ruleUnaryOperatorCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4072:2: iv_ruleUnaryOperatorCS= ruleUnaryOperatorCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryOperatorCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnaryOperatorCS_in_entryRuleUnaryOperatorCS9598);
            iv_ruleUnaryOperatorCS=ruleUnaryOperatorCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnaryOperatorCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnaryOperatorCS9608); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4079:1: ruleUnaryOperatorCS returns [EObject current=null] : ( (lv_name_0_0= rulePrefixOperator ) ) ;
    public final EObject ruleUnaryOperatorCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4082:28: ( ( (lv_name_0_0= rulePrefixOperator ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4083:1: ( (lv_name_0_0= rulePrefixOperator ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4083:1: ( (lv_name_0_0= rulePrefixOperator ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4084:1: (lv_name_0_0= rulePrefixOperator )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4084:1: (lv_name_0_0= rulePrefixOperator )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4085:3: lv_name_0_0= rulePrefixOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getUnaryOperatorCSAccess().getNamePrefixOperatorParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_rulePrefixOperator_in_ruleUnaryOperatorCS9653);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4109:1: entryRulePrimaryExpCS returns [EObject current=null] : iv_rulePrimaryExpCS= rulePrimaryExpCS EOF ;
    public final EObject entryRulePrimaryExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4110:2: (iv_rulePrimaryExpCS= rulePrimaryExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4111:2: iv_rulePrimaryExpCS= rulePrimaryExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimaryExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePrimaryExpCS_in_entryRulePrimaryExpCS9688);
            iv_rulePrimaryExpCS=rulePrimaryExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimaryExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrimaryExpCS9698); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4118:1: rulePrimaryExpCS returns [EObject current=null] : (this_NavigatingExpCS_0= ruleNavigatingExpCS | this_SelfExpCS_1= ruleSelfExpCS | this_PrimitiveLiteralExpCS_2= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_3= ruleTupleLiteralExpCS | this_CollectionLiteralExpCS_4= ruleCollectionLiteralExpCS | this_ConstructorExpCS_5= ruleConstructorExpCS | this_TypeLiteralExpCS_6= ruleTypeLiteralExpCS | this_LetExpCS_7= ruleLetExpCS | this_IfExpCS_8= ruleIfExpCS | this_NestedExpCS_9= ruleNestedExpCS ) ;
    public final EObject rulePrimaryExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_NavigatingExpCS_0 = null;

        EObject this_SelfExpCS_1 = null;

        EObject this_PrimitiveLiteralExpCS_2 = null;

        EObject this_TupleLiteralExpCS_3 = null;

        EObject this_CollectionLiteralExpCS_4 = null;

        EObject this_ConstructorExpCS_5 = null;

        EObject this_TypeLiteralExpCS_6 = null;

        EObject this_LetExpCS_7 = null;

        EObject this_IfExpCS_8 = null;

        EObject this_NestedExpCS_9 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4121:28: ( (this_NavigatingExpCS_0= ruleNavigatingExpCS | this_SelfExpCS_1= ruleSelfExpCS | this_PrimitiveLiteralExpCS_2= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_3= ruleTupleLiteralExpCS | this_CollectionLiteralExpCS_4= ruleCollectionLiteralExpCS | this_ConstructorExpCS_5= ruleConstructorExpCS | this_TypeLiteralExpCS_6= ruleTypeLiteralExpCS | this_LetExpCS_7= ruleLetExpCS | this_IfExpCS_8= ruleIfExpCS | this_NestedExpCS_9= ruleNestedExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4122:1: (this_NavigatingExpCS_0= ruleNavigatingExpCS | this_SelfExpCS_1= ruleSelfExpCS | this_PrimitiveLiteralExpCS_2= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_3= ruleTupleLiteralExpCS | this_CollectionLiteralExpCS_4= ruleCollectionLiteralExpCS | this_ConstructorExpCS_5= ruleConstructorExpCS | this_TypeLiteralExpCS_6= ruleTypeLiteralExpCS | this_LetExpCS_7= ruleLetExpCS | this_IfExpCS_8= ruleIfExpCS | this_NestedExpCS_9= ruleNestedExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4122:1: (this_NavigatingExpCS_0= ruleNavigatingExpCS | this_SelfExpCS_1= ruleSelfExpCS | this_PrimitiveLiteralExpCS_2= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_3= ruleTupleLiteralExpCS | this_CollectionLiteralExpCS_4= ruleCollectionLiteralExpCS | this_ConstructorExpCS_5= ruleConstructorExpCS | this_TypeLiteralExpCS_6= ruleTypeLiteralExpCS | this_LetExpCS_7= ruleLetExpCS | this_IfExpCS_8= ruleIfExpCS | this_NestedExpCS_9= ruleNestedExpCS )
            int alt69=10;
            alt69 = dfa69.predict(input);
            switch (alt69) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4123:2: this_NavigatingExpCS_0= ruleNavigatingExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getNavigatingExpCSParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNavigatingExpCS_in_rulePrimaryExpCS9748);
                    this_NavigatingExpCS_0=ruleNavigatingExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_NavigatingExpCS_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4136:2: this_SelfExpCS_1= ruleSelfExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getSelfExpCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSelfExpCS_in_rulePrimaryExpCS9778);
                    this_SelfExpCS_1=ruleSelfExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_SelfExpCS_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4149:2: this_PrimitiveLiteralExpCS_2= rulePrimitiveLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getPrimitiveLiteralExpCSParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrimitiveLiteralExpCS_in_rulePrimaryExpCS9808);
                    this_PrimitiveLiteralExpCS_2=rulePrimitiveLiteralExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_PrimitiveLiteralExpCS_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4162:2: this_TupleLiteralExpCS_3= ruleTupleLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getTupleLiteralExpCSParserRuleCall_3()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralExpCS_in_rulePrimaryExpCS9838);
                    this_TupleLiteralExpCS_3=ruleTupleLiteralExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_TupleLiteralExpCS_3; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 5 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4175:2: this_CollectionLiteralExpCS_4= ruleCollectionLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getCollectionLiteralExpCSParserRuleCall_4()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteralExpCS_in_rulePrimaryExpCS9868);
                    this_CollectionLiteralExpCS_4=ruleCollectionLiteralExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_CollectionLiteralExpCS_4; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 6 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4188:2: this_ConstructorExpCS_5= ruleConstructorExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getConstructorExpCSParserRuleCall_5()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleConstructorExpCS_in_rulePrimaryExpCS9898);
                    this_ConstructorExpCS_5=ruleConstructorExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ConstructorExpCS_5; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 7 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4201:2: this_TypeLiteralExpCS_6= ruleTypeLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getTypeLiteralExpCSParserRuleCall_6()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralExpCS_in_rulePrimaryExpCS9928);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4214:2: this_LetExpCS_7= ruleLetExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getLetExpCSParserRuleCall_7()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLetExpCS_in_rulePrimaryExpCS9958);
                    this_LetExpCS_7=ruleLetExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_LetExpCS_7; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 9 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4227:2: this_IfExpCS_8= ruleIfExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getIfExpCSParserRuleCall_8()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleIfExpCS_in_rulePrimaryExpCS9988);
                    this_IfExpCS_8=ruleIfExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_IfExpCS_8; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 10 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4240:2: this_NestedExpCS_9= ruleNestedExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getNestedExpCSParserRuleCall_9()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNestedExpCS_in_rulePrimaryExpCS10018);
                    this_NestedExpCS_9=ruleNestedExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_NestedExpCS_9; 
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4259:1: entryRuleNameExpCS returns [EObject current=null] : iv_ruleNameExpCS= ruleNameExpCS EOF ;
    public final EObject entryRuleNameExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNameExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4260:2: (iv_ruleNameExpCS= ruleNameExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4261:2: iv_ruleNameExpCS= ruleNameExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNameExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNameExpCS_in_entryRuleNameExpCS10053);
            iv_ruleNameExpCS=ruleNameExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNameExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNameExpCS10063); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4268:1: ruleNameExpCS returns [EObject current=null] : ( ( ( ( ( ruleUnrestrictedName ) ) otherlv_1= '::' ( ( ( ruleUnreservedName ) ) otherlv_3= '::' )* ) ( ( ruleUnreservedName ) ) ) | ( ( ruleUnrestrictedName ) ) ) ;
    public final EObject ruleNameExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4271:28: ( ( ( ( ( ( ruleUnrestrictedName ) ) otherlv_1= '::' ( ( ( ruleUnreservedName ) ) otherlv_3= '::' )* ) ( ( ruleUnreservedName ) ) ) | ( ( ruleUnrestrictedName ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4272:1: ( ( ( ( ( ruleUnrestrictedName ) ) otherlv_1= '::' ( ( ( ruleUnreservedName ) ) otherlv_3= '::' )* ) ( ( ruleUnreservedName ) ) ) | ( ( ruleUnrestrictedName ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4272:1: ( ( ( ( ( ruleUnrestrictedName ) ) otherlv_1= '::' ( ( ( ruleUnreservedName ) ) otherlv_3= '::' )* ) ( ( ruleUnreservedName ) ) ) | ( ( ruleUnrestrictedName ) ) )
            int alt71=2;
            alt71 = dfa71.predict(input);
            switch (alt71) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4272:2: ( ( ( ( ruleUnrestrictedName ) ) otherlv_1= '::' ( ( ( ruleUnreservedName ) ) otherlv_3= '::' )* ) ( ( ruleUnreservedName ) ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4272:2: ( ( ( ( ruleUnrestrictedName ) ) otherlv_1= '::' ( ( ( ruleUnreservedName ) ) otherlv_3= '::' )* ) ( ( ruleUnreservedName ) ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4272:3: ( ( ( ruleUnrestrictedName ) ) otherlv_1= '::' ( ( ( ruleUnreservedName ) ) otherlv_3= '::' )* ) ( ( ruleUnreservedName ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4272:3: ( ( ( ruleUnrestrictedName ) ) otherlv_1= '::' ( ( ( ruleUnreservedName ) ) otherlv_3= '::' )* )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4272:4: ( ( ruleUnrestrictedName ) ) otherlv_1= '::' ( ( ( ruleUnreservedName ) ) otherlv_3= '::' )*
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4272:4: ( ( ruleUnrestrictedName ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4273:1: ( ruleUnrestrictedName )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4273:1: ( ruleUnrestrictedName )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4274:3: ruleUnrestrictedName
                    {
                    if ( state.backtracking==0 ) {
                       
                      		  /* */ 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getNameExpCSRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNameExpCSAccess().getNamespaceNamespaceCrossReference_0_0_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleNameExpCS10117);
                    ruleUnrestrictedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_1=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleNameExpCS10129); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getNameExpCSAccess().getColonColonKeyword_0_0_1());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4294:1: ( ( ( ruleUnreservedName ) ) otherlv_3= '::' )*
                    loop70:
                    do {
                        int alt70=2;
                        alt70 = dfa70.predict(input);
                        switch (alt70) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4294:2: ( ( ruleUnreservedName ) ) otherlv_3= '::'
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4294:2: ( ( ruleUnreservedName ) )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4295:1: ( ruleUnreservedName )
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4295:1: ( ruleUnreservedName )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4296:3: ruleUnreservedName
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      		  /* */ 
                    	      		
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      			if (current==null) {
                    	      	            current = createModelElement(grammarAccess.getNameExpCSRule());
                    	      	        }
                    	              
                    	    }
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getNameExpCSAccess().getNamespaceNamespaceCrossReference_0_0_2_0_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleUnreservedName_in_ruleNameExpCS10157);
                    	    ruleUnreservedName();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }

                    	    otherlv_3=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleNameExpCS10169); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getNameExpCSAccess().getColonColonKeyword_0_0_2_1());
                    	          
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop70;
                        }
                    } while (true);


                    }

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4316:4: ( ( ruleUnreservedName ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4317:1: ( ruleUnreservedName )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4317:1: ( ruleUnreservedName )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4318:3: ruleUnreservedName
                    {
                    if ( state.backtracking==0 ) {
                       
                      		  /* */ 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getNameExpCSRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNameExpCSAccess().getElementNamedElementCrossReference_0_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUnreservedName_in_ruleNameExpCS10199);
                    ruleUnreservedName();

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
                case 2 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4335:6: ( ( ruleUnrestrictedName ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4335:6: ( ( ruleUnrestrictedName ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4336:1: ( ruleUnrestrictedName )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4336:1: ( ruleUnrestrictedName )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4337:3: ruleUnrestrictedName
                    {
                    if ( state.backtracking==0 ) {
                       
                      		  /* */ 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getNameExpCSRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNameExpCSAccess().getElementNamedElementCrossReference_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleNameExpCS10233);
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


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
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


    // $ANTLR start "entryRuleIndexExpCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4361:1: entryRuleIndexExpCS returns [EObject current=null] : iv_ruleIndexExpCS= ruleIndexExpCS EOF ;
    public final EObject entryRuleIndexExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIndexExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4362:2: (iv_ruleIndexExpCS= ruleIndexExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4363:2: iv_ruleIndexExpCS= ruleIndexExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIndexExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIndexExpCS_in_entryRuleIndexExpCS10269);
            iv_ruleIndexExpCS=ruleIndexExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIndexExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIndexExpCS10279); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIndexExpCS"


    // $ANTLR start "ruleIndexExpCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4370:1: ruleIndexExpCS returns [EObject current=null] : (this_NameExpCS_0= ruleNameExpCS ( () otherlv_2= '[' ( (lv_firstIndexes_3_0= ruleExpCS ) ) (otherlv_4= ',' ( (lv_firstIndexes_5_0= ruleExpCS ) ) )* otherlv_6= ']' (otherlv_7= '[' ( (lv_secondIndexes_8_0= ruleExpCS ) ) (otherlv_9= ',' ( (lv_secondIndexes_10_0= ruleExpCS ) ) )* otherlv_11= ']' )? )? ) ;
    public final EObject ruleIndexExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        EObject this_NameExpCS_0 = null;

        EObject lv_firstIndexes_3_0 = null;

        EObject lv_firstIndexes_5_0 = null;

        EObject lv_secondIndexes_8_0 = null;

        EObject lv_secondIndexes_10_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4373:28: ( (this_NameExpCS_0= ruleNameExpCS ( () otherlv_2= '[' ( (lv_firstIndexes_3_0= ruleExpCS ) ) (otherlv_4= ',' ( (lv_firstIndexes_5_0= ruleExpCS ) ) )* otherlv_6= ']' (otherlv_7= '[' ( (lv_secondIndexes_8_0= ruleExpCS ) ) (otherlv_9= ',' ( (lv_secondIndexes_10_0= ruleExpCS ) ) )* otherlv_11= ']' )? )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4374:1: (this_NameExpCS_0= ruleNameExpCS ( () otherlv_2= '[' ( (lv_firstIndexes_3_0= ruleExpCS ) ) (otherlv_4= ',' ( (lv_firstIndexes_5_0= ruleExpCS ) ) )* otherlv_6= ']' (otherlv_7= '[' ( (lv_secondIndexes_8_0= ruleExpCS ) ) (otherlv_9= ',' ( (lv_secondIndexes_10_0= ruleExpCS ) ) )* otherlv_11= ']' )? )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4374:1: (this_NameExpCS_0= ruleNameExpCS ( () otherlv_2= '[' ( (lv_firstIndexes_3_0= ruleExpCS ) ) (otherlv_4= ',' ( (lv_firstIndexes_5_0= ruleExpCS ) ) )* otherlv_6= ']' (otherlv_7= '[' ( (lv_secondIndexes_8_0= ruleExpCS ) ) (otherlv_9= ',' ( (lv_secondIndexes_10_0= ruleExpCS ) ) )* otherlv_11= ']' )? )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4375:2: this_NameExpCS_0= ruleNameExpCS ( () otherlv_2= '[' ( (lv_firstIndexes_3_0= ruleExpCS ) ) (otherlv_4= ',' ( (lv_firstIndexes_5_0= ruleExpCS ) ) )* otherlv_6= ']' (otherlv_7= '[' ( (lv_secondIndexes_8_0= ruleExpCS ) ) (otherlv_9= ',' ( (lv_secondIndexes_10_0= ruleExpCS ) ) )* otherlv_11= ']' )? )?
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getIndexExpCSAccess().getNameExpCSParserRuleCall_0()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleNameExpCS_in_ruleIndexExpCS10329);
            this_NameExpCS_0=ruleNameExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_NameExpCS_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4386:1: ( () otherlv_2= '[' ( (lv_firstIndexes_3_0= ruleExpCS ) ) (otherlv_4= ',' ( (lv_firstIndexes_5_0= ruleExpCS ) ) )* otherlv_6= ']' (otherlv_7= '[' ( (lv_secondIndexes_8_0= ruleExpCS ) ) (otherlv_9= ',' ( (lv_secondIndexes_10_0= ruleExpCS ) ) )* otherlv_11= ']' )? )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==74) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4386:2: () otherlv_2= '[' ( (lv_firstIndexes_3_0= ruleExpCS ) ) (otherlv_4= ',' ( (lv_firstIndexes_5_0= ruleExpCS ) ) )* otherlv_6= ']' (otherlv_7= '[' ( (lv_secondIndexes_8_0= ruleExpCS ) ) (otherlv_9= ',' ( (lv_secondIndexes_10_0= ruleExpCS ) ) )* otherlv_11= ']' )?
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4386:2: ()
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4387:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElementAndSet(
                                  grammarAccess.getIndexExpCSAccess().getIndexExpCSNamedExpAction_1_0(),
                                  current);
                          
                    }

                    }

                    otherlv_2=(Token)match(input,74,FollowSets000.FOLLOW_74_in_ruleIndexExpCS10353); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getIndexExpCSAccess().getLeftSquareBracketKeyword_1_1());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4399:1: ( (lv_firstIndexes_3_0= ruleExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4400:1: (lv_firstIndexes_3_0= ruleExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4400:1: (lv_firstIndexes_3_0= ruleExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4401:3: lv_firstIndexes_3_0= ruleExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getIndexExpCSAccess().getFirstIndexesExpCSParserRuleCall_1_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleIndexExpCS10374);
                    lv_firstIndexes_3_0=ruleExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getIndexExpCSRule());
                      	        }
                             		add(
                             			current, 
                             			"firstIndexes",
                              		lv_firstIndexes_3_0, 
                              		"ExpCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4417:2: (otherlv_4= ',' ( (lv_firstIndexes_5_0= ruleExpCS ) ) )*
                    loop72:
                    do {
                        int alt72=2;
                        int LA72_0 = input.LA(1);

                        if ( (LA72_0==20) ) {
                            alt72=1;
                        }


                        switch (alt72) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4417:4: otherlv_4= ',' ( (lv_firstIndexes_5_0= ruleExpCS ) )
                    	    {
                    	    otherlv_4=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleIndexExpCS10387); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_4, grammarAccess.getIndexExpCSAccess().getCommaKeyword_1_3_0());
                    	          
                    	    }
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4421:1: ( (lv_firstIndexes_5_0= ruleExpCS ) )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4422:1: (lv_firstIndexes_5_0= ruleExpCS )
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4422:1: (lv_firstIndexes_5_0= ruleExpCS )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4423:3: lv_firstIndexes_5_0= ruleExpCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getIndexExpCSAccess().getFirstIndexesExpCSParserRuleCall_1_3_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleIndexExpCS10408);
                    	    lv_firstIndexes_5_0=ruleExpCS();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getIndexExpCSRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"firstIndexes",
                    	              		lv_firstIndexes_5_0, 
                    	              		"ExpCS");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop72;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,75,FollowSets000.FOLLOW_75_in_ruleIndexExpCS10422); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getIndexExpCSAccess().getRightSquareBracketKeyword_1_4());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4443:1: (otherlv_7= '[' ( (lv_secondIndexes_8_0= ruleExpCS ) ) (otherlv_9= ',' ( (lv_secondIndexes_10_0= ruleExpCS ) ) )* otherlv_11= ']' )?
                    int alt74=2;
                    int LA74_0 = input.LA(1);

                    if ( (LA74_0==74) ) {
                        alt74=1;
                    }
                    switch (alt74) {
                        case 1 :
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4443:3: otherlv_7= '[' ( (lv_secondIndexes_8_0= ruleExpCS ) ) (otherlv_9= ',' ( (lv_secondIndexes_10_0= ruleExpCS ) ) )* otherlv_11= ']'
                            {
                            otherlv_7=(Token)match(input,74,FollowSets000.FOLLOW_74_in_ruleIndexExpCS10435); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_7, grammarAccess.getIndexExpCSAccess().getLeftSquareBracketKeyword_1_5_0());
                                  
                            }
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4447:1: ( (lv_secondIndexes_8_0= ruleExpCS ) )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4448:1: (lv_secondIndexes_8_0= ruleExpCS )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4448:1: (lv_secondIndexes_8_0= ruleExpCS )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4449:3: lv_secondIndexes_8_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getIndexExpCSAccess().getSecondIndexesExpCSParserRuleCall_1_5_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleIndexExpCS10456);
                            lv_secondIndexes_8_0=ruleExpCS();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getIndexExpCSRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"secondIndexes",
                                      		lv_secondIndexes_8_0, 
                                      		"ExpCS");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4465:2: (otherlv_9= ',' ( (lv_secondIndexes_10_0= ruleExpCS ) ) )*
                            loop73:
                            do {
                                int alt73=2;
                                int LA73_0 = input.LA(1);

                                if ( (LA73_0==20) ) {
                                    alt73=1;
                                }


                                switch (alt73) {
                            	case 1 :
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4465:4: otherlv_9= ',' ( (lv_secondIndexes_10_0= ruleExpCS ) )
                            	    {
                            	    otherlv_9=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleIndexExpCS10469); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_9, grammarAccess.getIndexExpCSAccess().getCommaKeyword_1_5_2_0());
                            	          
                            	    }
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4469:1: ( (lv_secondIndexes_10_0= ruleExpCS ) )
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4470:1: (lv_secondIndexes_10_0= ruleExpCS )
                            	    {
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4470:1: (lv_secondIndexes_10_0= ruleExpCS )
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4471:3: lv_secondIndexes_10_0= ruleExpCS
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getIndexExpCSAccess().getSecondIndexesExpCSParserRuleCall_1_5_2_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleIndexExpCS10490);
                            	    lv_secondIndexes_10_0=ruleExpCS();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getIndexExpCSRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"secondIndexes",
                            	              		lv_secondIndexes_10_0, 
                            	              		"ExpCS");
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

                            otherlv_11=(Token)match(input,75,FollowSets000.FOLLOW_75_in_ruleIndexExpCS10504); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_11, grammarAccess.getIndexExpCSAccess().getRightSquareBracketKeyword_1_5_3());
                                  
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
    // $ANTLR end "ruleIndexExpCS"


    // $ANTLR start "entryRuleNavigatingExpCS_Base"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4499:1: entryRuleNavigatingExpCS_Base returns [EObject current=null] : iv_ruleNavigatingExpCS_Base= ruleNavigatingExpCS_Base EOF ;
    public final EObject entryRuleNavigatingExpCS_Base() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingExpCS_Base = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4500:2: (iv_ruleNavigatingExpCS_Base= ruleNavigatingExpCS_Base EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4501:2: iv_ruleNavigatingExpCS_Base= ruleNavigatingExpCS_Base EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingExpCS_BaseRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingExpCS_Base_in_entryRuleNavigatingExpCS_Base10544);
            iv_ruleNavigatingExpCS_Base=ruleNavigatingExpCS_Base();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingExpCS_Base; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigatingExpCS_Base10554); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNavigatingExpCS_Base"


    // $ANTLR start "ruleNavigatingExpCS_Base"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4508:1: ruleNavigatingExpCS_Base returns [EObject current=null] : this_IndexExpCS_0= ruleIndexExpCS ;
    public final EObject ruleNavigatingExpCS_Base() throws RecognitionException {
        EObject current = null;

        EObject this_IndexExpCS_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4511:28: (this_IndexExpCS_0= ruleIndexExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4513:2: this_IndexExpCS_0= ruleIndexExpCS
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getNavigatingExpCS_BaseAccess().getIndexExpCSParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleIndexExpCS_in_ruleNavigatingExpCS_Base10603);
            this_IndexExpCS_0=ruleIndexExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_IndexExpCS_0; 
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
    // $ANTLR end "ruleNavigatingExpCS_Base"


    // $ANTLR start "entryRuleNavigatingExpCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4532:1: entryRuleNavigatingExpCS returns [EObject current=null] : iv_ruleNavigatingExpCS= ruleNavigatingExpCS EOF ;
    public final EObject entryRuleNavigatingExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4533:2: (iv_ruleNavigatingExpCS= ruleNavigatingExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4534:2: iv_ruleNavigatingExpCS= ruleNavigatingExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingExpCS_in_entryRuleNavigatingExpCS10637);
            iv_ruleNavigatingExpCS=ruleNavigatingExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigatingExpCS10647); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNavigatingExpCS"


    // $ANTLR start "ruleNavigatingExpCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4541:1: ruleNavigatingExpCS returns [EObject current=null] : (this_NavigatingExpCS_Base_0= ruleNavigatingExpCS_Base ( () otherlv_2= '(' ( ( (lv_argument_3_0= ruleNavigatingArgCS ) ) ( (lv_argument_4_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_5_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_6_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_7_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_8_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_9= ')' )? ) ;
    public final EObject ruleNavigatingExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_9=null;
        EObject this_NavigatingExpCS_Base_0 = null;

        EObject lv_argument_3_0 = null;

        EObject lv_argument_4_0 = null;

        EObject lv_argument_5_0 = null;

        EObject lv_argument_6_0 = null;

        EObject lv_argument_7_0 = null;

        EObject lv_argument_8_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4544:28: ( (this_NavigatingExpCS_Base_0= ruleNavigatingExpCS_Base ( () otherlv_2= '(' ( ( (lv_argument_3_0= ruleNavigatingArgCS ) ) ( (lv_argument_4_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_5_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_6_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_7_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_8_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_9= ')' )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4545:1: (this_NavigatingExpCS_Base_0= ruleNavigatingExpCS_Base ( () otherlv_2= '(' ( ( (lv_argument_3_0= ruleNavigatingArgCS ) ) ( (lv_argument_4_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_5_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_6_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_7_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_8_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_9= ')' )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4545:1: (this_NavigatingExpCS_Base_0= ruleNavigatingExpCS_Base ( () otherlv_2= '(' ( ( (lv_argument_3_0= ruleNavigatingArgCS ) ) ( (lv_argument_4_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_5_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_6_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_7_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_8_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_9= ')' )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4546:2: this_NavigatingExpCS_Base_0= ruleNavigatingExpCS_Base ( () otherlv_2= '(' ( ( (lv_argument_3_0= ruleNavigatingArgCS ) ) ( (lv_argument_4_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_5_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_6_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_7_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_8_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_9= ')' )?
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getNavigatingExpCSAccess().getNavigatingExpCS_BaseParserRuleCall_0()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingExpCS_Base_in_ruleNavigatingExpCS10697);
            this_NavigatingExpCS_Base_0=ruleNavigatingExpCS_Base();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_NavigatingExpCS_Base_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4557:1: ( () otherlv_2= '(' ( ( (lv_argument_3_0= ruleNavigatingArgCS ) ) ( (lv_argument_4_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_5_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_6_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_7_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_8_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_9= ')' )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==28) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4557:2: () otherlv_2= '(' ( ( (lv_argument_3_0= ruleNavigatingArgCS ) ) ( (lv_argument_4_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_5_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_6_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_7_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_8_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_9= ')'
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4557:2: ()
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4558:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElementAndSet(
                                  grammarAccess.getNavigatingExpCSAccess().getNavigatingExpCSNamedExpAction_1_0(),
                                  current);
                          
                    }

                    }

                    otherlv_2=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleNavigatingExpCS10721); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getNavigatingExpCSAccess().getLeftParenthesisKeyword_1_1());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4570:1: ( ( (lv_argument_3_0= ruleNavigatingArgCS ) ) ( (lv_argument_4_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_5_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_6_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_7_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_8_0= ruleNavigatingCommaArgCS ) )* )? )?
                    int alt81=2;
                    int LA81_0 = input.LA(1);

                    if ( ((LA81_0>=RULE_SIMPLE_ID && LA81_0<=RULE_SINGLE_QUOTED_STRING)||LA81_0==14||LA81_0==19||(LA81_0>=21 && LA81_0<=22)||(LA81_0>=24 && LA81_0<=28)||LA81_0==32||LA81_0==35||(LA81_0>=37 && LA81_0<=38)||(LA81_0>=40 && LA81_0<=42)||(LA81_0>=55 && LA81_0<=68)||(LA81_0>=70 && LA81_0<=73)||LA81_0==76||(LA81_0>=80 && LA81_0<=81)) ) {
                        alt81=1;
                    }
                    switch (alt81) {
                        case 1 :
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4570:2: ( (lv_argument_3_0= ruleNavigatingArgCS ) ) ( (lv_argument_4_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_5_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_6_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_7_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_8_0= ruleNavigatingCommaArgCS ) )* )?
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4570:2: ( (lv_argument_3_0= ruleNavigatingArgCS ) )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4571:1: (lv_argument_3_0= ruleNavigatingArgCS )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4571:1: (lv_argument_3_0= ruleNavigatingArgCS )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4572:3: lv_argument_3_0= ruleNavigatingArgCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getNavigatingExpCSAccess().getArgumentNavigatingArgCSParserRuleCall_1_2_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgCS_in_ruleNavigatingExpCS10743);
                            lv_argument_3_0=ruleNavigatingArgCS();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getNavigatingExpCSRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"argument",
                                      		lv_argument_3_0, 
                                      		"NavigatingArgCS");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4588:2: ( (lv_argument_4_0= ruleNavigatingCommaArgCS ) )*
                            loop76:
                            do {
                                int alt76=2;
                                int LA76_0 = input.LA(1);

                                if ( (LA76_0==20) ) {
                                    alt76=1;
                                }


                                switch (alt76) {
                            	case 1 :
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4589:1: (lv_argument_4_0= ruleNavigatingCommaArgCS )
                            	    {
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4589:1: (lv_argument_4_0= ruleNavigatingCommaArgCS )
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4590:3: lv_argument_4_0= ruleNavigatingCommaArgCS
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getNavigatingExpCSAccess().getArgumentNavigatingCommaArgCSParserRuleCall_1_2_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FollowSets000.FOLLOW_ruleNavigatingCommaArgCS_in_ruleNavigatingExpCS10764);
                            	    lv_argument_4_0=ruleNavigatingCommaArgCS();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getNavigatingExpCSRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"argument",
                            	              		lv_argument_4_0, 
                            	              		"NavigatingCommaArgCS");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop76;
                                }
                            } while (true);

                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4606:3: ( ( (lv_argument_5_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_6_0= ruleNavigatingCommaArgCS ) )* )?
                            int alt78=2;
                            int LA78_0 = input.LA(1);

                            if ( (LA78_0==17) ) {
                                alt78=1;
                            }
                            switch (alt78) {
                                case 1 :
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4606:4: ( (lv_argument_5_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_6_0= ruleNavigatingCommaArgCS ) )*
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4606:4: ( (lv_argument_5_0= ruleNavigatingSemiArgCS ) )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4607:1: (lv_argument_5_0= ruleNavigatingSemiArgCS )
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4607:1: (lv_argument_5_0= ruleNavigatingSemiArgCS )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4608:3: lv_argument_5_0= ruleNavigatingSemiArgCS
                                    {
                                    if ( state.backtracking==0 ) {
                                       
                                      	        newCompositeNode(grammarAccess.getNavigatingExpCSAccess().getArgumentNavigatingSemiArgCSParserRuleCall_1_2_2_0_0()); 
                                      	    
                                    }
                                    pushFollow(FollowSets000.FOLLOW_ruleNavigatingSemiArgCS_in_ruleNavigatingExpCS10787);
                                    lv_argument_5_0=ruleNavigatingSemiArgCS();

                                    state._fsp--;
                                    if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      	        if (current==null) {
                                      	            current = createModelElementForParent(grammarAccess.getNavigatingExpCSRule());
                                      	        }
                                             		add(
                                             			current, 
                                             			"argument",
                                              		lv_argument_5_0, 
                                              		"NavigatingSemiArgCS");
                                      	        afterParserOrEnumRuleCall();
                                      	    
                                    }

                                    }


                                    }

                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4624:2: ( (lv_argument_6_0= ruleNavigatingCommaArgCS ) )*
                                    loop77:
                                    do {
                                        int alt77=2;
                                        int LA77_0 = input.LA(1);

                                        if ( (LA77_0==20) ) {
                                            alt77=1;
                                        }


                                        switch (alt77) {
                                    	case 1 :
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4625:1: (lv_argument_6_0= ruleNavigatingCommaArgCS )
                                    	    {
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4625:1: (lv_argument_6_0= ruleNavigatingCommaArgCS )
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4626:3: lv_argument_6_0= ruleNavigatingCommaArgCS
                                    	    {
                                    	    if ( state.backtracking==0 ) {
                                    	       
                                    	      	        newCompositeNode(grammarAccess.getNavigatingExpCSAccess().getArgumentNavigatingCommaArgCSParserRuleCall_1_2_2_1_0()); 
                                    	      	    
                                    	    }
                                    	    pushFollow(FollowSets000.FOLLOW_ruleNavigatingCommaArgCS_in_ruleNavigatingExpCS10808);
                                    	    lv_argument_6_0=ruleNavigatingCommaArgCS();

                                    	    state._fsp--;
                                    	    if (state.failed) return current;
                                    	    if ( state.backtracking==0 ) {

                                    	      	        if (current==null) {
                                    	      	            current = createModelElementForParent(grammarAccess.getNavigatingExpCSRule());
                                    	      	        }
                                    	             		add(
                                    	             			current, 
                                    	             			"argument",
                                    	              		lv_argument_6_0, 
                                    	              		"NavigatingCommaArgCS");
                                    	      	        afterParserOrEnumRuleCall();
                                    	      	    
                                    	    }

                                    	    }


                                    	    }
                                    	    break;

                                    	default :
                                    	    break loop77;
                                        }
                                    } while (true);


                                    }
                                    break;

                            }

                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4642:5: ( ( (lv_argument_7_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_8_0= ruleNavigatingCommaArgCS ) )* )?
                            int alt80=2;
                            int LA80_0 = input.LA(1);

                            if ( (LA80_0==30) ) {
                                alt80=1;
                            }
                            switch (alt80) {
                                case 1 :
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4642:6: ( (lv_argument_7_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_8_0= ruleNavigatingCommaArgCS ) )*
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4642:6: ( (lv_argument_7_0= ruleNavigatingBarArgCS ) )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4643:1: (lv_argument_7_0= ruleNavigatingBarArgCS )
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4643:1: (lv_argument_7_0= ruleNavigatingBarArgCS )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4644:3: lv_argument_7_0= ruleNavigatingBarArgCS
                                    {
                                    if ( state.backtracking==0 ) {
                                       
                                      	        newCompositeNode(grammarAccess.getNavigatingExpCSAccess().getArgumentNavigatingBarArgCSParserRuleCall_1_2_3_0_0()); 
                                      	    
                                    }
                                    pushFollow(FollowSets000.FOLLOW_ruleNavigatingBarArgCS_in_ruleNavigatingExpCS10833);
                                    lv_argument_7_0=ruleNavigatingBarArgCS();

                                    state._fsp--;
                                    if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      	        if (current==null) {
                                      	            current = createModelElementForParent(grammarAccess.getNavigatingExpCSRule());
                                      	        }
                                             		add(
                                             			current, 
                                             			"argument",
                                              		lv_argument_7_0, 
                                              		"NavigatingBarArgCS");
                                      	        afterParserOrEnumRuleCall();
                                      	    
                                    }

                                    }


                                    }

                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4660:2: ( (lv_argument_8_0= ruleNavigatingCommaArgCS ) )*
                                    loop79:
                                    do {
                                        int alt79=2;
                                        int LA79_0 = input.LA(1);

                                        if ( (LA79_0==20) ) {
                                            alt79=1;
                                        }


                                        switch (alt79) {
                                    	case 1 :
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4661:1: (lv_argument_8_0= ruleNavigatingCommaArgCS )
                                    	    {
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4661:1: (lv_argument_8_0= ruleNavigatingCommaArgCS )
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4662:3: lv_argument_8_0= ruleNavigatingCommaArgCS
                                    	    {
                                    	    if ( state.backtracking==0 ) {
                                    	       
                                    	      	        newCompositeNode(grammarAccess.getNavigatingExpCSAccess().getArgumentNavigatingCommaArgCSParserRuleCall_1_2_3_1_0()); 
                                    	      	    
                                    	    }
                                    	    pushFollow(FollowSets000.FOLLOW_ruleNavigatingCommaArgCS_in_ruleNavigatingExpCS10854);
                                    	    lv_argument_8_0=ruleNavigatingCommaArgCS();

                                    	    state._fsp--;
                                    	    if (state.failed) return current;
                                    	    if ( state.backtracking==0 ) {

                                    	      	        if (current==null) {
                                    	      	            current = createModelElementForParent(grammarAccess.getNavigatingExpCSRule());
                                    	      	        }
                                    	             		add(
                                    	             			current, 
                                    	             			"argument",
                                    	              		lv_argument_8_0, 
                                    	              		"NavigatingCommaArgCS");
                                    	      	        afterParserOrEnumRuleCall();
                                    	      	    
                                    	    }

                                    	    }


                                    	    }
                                    	    break;

                                    	default :
                                    	    break loop79;
                                        }
                                    } while (true);


                                    }
                                    break;

                            }


                            }
                            break;

                    }

                    otherlv_9=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleNavigatingExpCS10871); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getNavigatingExpCSAccess().getRightParenthesisKeyword_1_3());
                          
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
    // $ANTLR end "ruleNavigatingExpCS"


    // $ANTLR start "entryRuleNavigatingArgCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4690:1: entryRuleNavigatingArgCS returns [EObject current=null] : iv_ruleNavigatingArgCS= ruleNavigatingArgCS EOF ;
    public final EObject entryRuleNavigatingArgCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingArgCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4691:2: (iv_ruleNavigatingArgCS= ruleNavigatingArgCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4692:2: iv_ruleNavigatingArgCS= ruleNavigatingArgCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingArgCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgCS_in_entryRuleNavigatingArgCS10909);
            iv_ruleNavigatingArgCS=ruleNavigatingArgCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingArgCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigatingArgCS10919); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4699:1: ruleNavigatingArgCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleNavigatingArgExpCS ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? (otherlv_3= '=' ( (lv_init_4_0= ruleExpCS ) ) )? ) ;
    public final EObject ruleNavigatingArgCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;

        EObject lv_init_4_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4702:28: ( ( ( (lv_name_0_0= ruleNavigatingArgExpCS ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? (otherlv_3= '=' ( (lv_init_4_0= ruleExpCS ) ) )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4703:1: ( ( (lv_name_0_0= ruleNavigatingArgExpCS ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? (otherlv_3= '=' ( (lv_init_4_0= ruleExpCS ) ) )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4703:1: ( ( (lv_name_0_0= ruleNavigatingArgExpCS ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? (otherlv_3= '=' ( (lv_init_4_0= ruleExpCS ) ) )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4703:2: ( (lv_name_0_0= ruleNavigatingArgExpCS ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? (otherlv_3= '=' ( (lv_init_4_0= ruleExpCS ) ) )?
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4703:2: ( (lv_name_0_0= ruleNavigatingArgExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4704:1: (lv_name_0_0= ruleNavigatingArgExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4704:1: (lv_name_0_0= ruleNavigatingArgExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4705:3: lv_name_0_0= ruleNavigatingArgExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getNameNavigatingArgExpCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingArgCS10965);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4721:2: (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )?
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==31) ) {
                alt83=1;
            }
            switch (alt83) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4721:4: otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                    {
                    otherlv_1=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleNavigatingArgCS10978); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getNavigatingArgCSAccess().getColonKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4725:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4726:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4726:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4727:3: lv_ownedType_2_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleNavigatingArgCS10999);
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


                    }
                    break;

            }

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4743:4: (otherlv_3= '=' ( (lv_init_4_0= ruleExpCS ) ) )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==48) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4743:6: otherlv_3= '=' ( (lv_init_4_0= ruleExpCS ) )
                    {
                    otherlv_3=(Token)match(input,48,FollowSets000.FOLLOW_48_in_ruleNavigatingArgCS11014); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getNavigatingArgCSAccess().getEqualsSignKeyword_2_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4747:1: ( (lv_init_4_0= ruleExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4748:1: (lv_init_4_0= ruleExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4748:1: (lv_init_4_0= ruleExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4749:3: lv_init_4_0= ruleExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getInitExpCSParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNavigatingArgCS11035);
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


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4773:1: entryRuleNavigatingBarArgCS returns [EObject current=null] : iv_ruleNavigatingBarArgCS= ruleNavigatingBarArgCS EOF ;
    public final EObject entryRuleNavigatingBarArgCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingBarArgCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4774:2: (iv_ruleNavigatingBarArgCS= ruleNavigatingBarArgCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4775:2: iv_ruleNavigatingBarArgCS= ruleNavigatingBarArgCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingBarArgCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingBarArgCS_in_entryRuleNavigatingBarArgCS11073);
            iv_ruleNavigatingBarArgCS=ruleNavigatingBarArgCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingBarArgCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigatingBarArgCS11083); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4782:1: ruleNavigatingBarArgCS returns [EObject current=null] : ( ( (lv_prefix_0_0= '|' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )? (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4785:28: ( ( ( (lv_prefix_0_0= '|' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )? (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4786:1: ( ( (lv_prefix_0_0= '|' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )? (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4786:1: ( ( (lv_prefix_0_0= '|' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )? (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4786:2: ( (lv_prefix_0_0= '|' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )? (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )?
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4786:2: ( (lv_prefix_0_0= '|' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4787:1: (lv_prefix_0_0= '|' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4787:1: (lv_prefix_0_0= '|' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4788:3: lv_prefix_0_0= '|'
            {
            lv_prefix_0_0=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleNavigatingBarArgCS11126); if (state.failed) return current;
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4801:2: ( (lv_name_1_0= ruleNavigatingArgExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4802:1: (lv_name_1_0= ruleNavigatingArgExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4802:1: (lv_name_1_0= ruleNavigatingArgExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4803:3: lv_name_1_0= ruleNavigatingArgExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNavigatingBarArgCSAccess().getNameNavigatingArgExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingBarArgCS11160);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4819:2: (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )?
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==31) ) {
                alt85=1;
            }
            switch (alt85) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4819:4: otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) )
                    {
                    otherlv_2=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleNavigatingBarArgCS11173); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getNavigatingBarArgCSAccess().getColonKeyword_2_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4823:1: ( (lv_ownedType_3_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4824:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4824:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4825:3: lv_ownedType_3_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingBarArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleNavigatingBarArgCS11194);
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


                    }
                    break;

            }

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4841:4: (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )?
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==48) ) {
                alt86=1;
            }
            switch (alt86) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4841:6: otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) )
                    {
                    otherlv_4=(Token)match(input,48,FollowSets000.FOLLOW_48_in_ruleNavigatingBarArgCS11209); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getNavigatingBarArgCSAccess().getEqualsSignKeyword_3_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4845:1: ( (lv_init_5_0= ruleExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4846:1: (lv_init_5_0= ruleExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4846:1: (lv_init_5_0= ruleExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4847:3: lv_init_5_0= ruleExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingBarArgCSAccess().getInitExpCSParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNavigatingBarArgCS11230);
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


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4871:1: entryRuleNavigatingCommaArgCS returns [EObject current=null] : iv_ruleNavigatingCommaArgCS= ruleNavigatingCommaArgCS EOF ;
    public final EObject entryRuleNavigatingCommaArgCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingCommaArgCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4872:2: (iv_ruleNavigatingCommaArgCS= ruleNavigatingCommaArgCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4873:2: iv_ruleNavigatingCommaArgCS= ruleNavigatingCommaArgCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingCommaArgCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingCommaArgCS_in_entryRuleNavigatingCommaArgCS11268);
            iv_ruleNavigatingCommaArgCS=ruleNavigatingCommaArgCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingCommaArgCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigatingCommaArgCS11278); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4880:1: ruleNavigatingCommaArgCS returns [EObject current=null] : ( ( (lv_prefix_0_0= ',' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )? (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4883:28: ( ( ( (lv_prefix_0_0= ',' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )? (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4884:1: ( ( (lv_prefix_0_0= ',' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )? (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4884:1: ( ( (lv_prefix_0_0= ',' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )? (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4884:2: ( (lv_prefix_0_0= ',' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )? (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )?
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4884:2: ( (lv_prefix_0_0= ',' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4885:1: (lv_prefix_0_0= ',' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4885:1: (lv_prefix_0_0= ',' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4886:3: lv_prefix_0_0= ','
            {
            lv_prefix_0_0=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleNavigatingCommaArgCS11321); if (state.failed) return current;
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4899:2: ( (lv_name_1_0= ruleNavigatingArgExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4900:1: (lv_name_1_0= ruleNavigatingArgExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4900:1: (lv_name_1_0= ruleNavigatingArgExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4901:3: lv_name_1_0= ruleNavigatingArgExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getNameNavigatingArgExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingCommaArgCS11355);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4917:2: (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )?
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==31) ) {
                alt87=1;
            }
            switch (alt87) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4917:4: otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) )
                    {
                    otherlv_2=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleNavigatingCommaArgCS11368); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getNavigatingCommaArgCSAccess().getColonKeyword_2_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4921:1: ( (lv_ownedType_3_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4922:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4922:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4923:3: lv_ownedType_3_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleNavigatingCommaArgCS11389);
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


                    }
                    break;

            }

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4939:4: (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )?
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==48) ) {
                alt88=1;
            }
            switch (alt88) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4939:6: otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) )
                    {
                    otherlv_4=(Token)match(input,48,FollowSets000.FOLLOW_48_in_ruleNavigatingCommaArgCS11404); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getNavigatingCommaArgCSAccess().getEqualsSignKeyword_3_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4943:1: ( (lv_init_5_0= ruleExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4944:1: (lv_init_5_0= ruleExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4944:1: (lv_init_5_0= ruleExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4945:3: lv_init_5_0= ruleExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getInitExpCSParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNavigatingCommaArgCS11425);
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


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4969:1: entryRuleNavigatingSemiArgCS returns [EObject current=null] : iv_ruleNavigatingSemiArgCS= ruleNavigatingSemiArgCS EOF ;
    public final EObject entryRuleNavigatingSemiArgCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingSemiArgCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4970:2: (iv_ruleNavigatingSemiArgCS= ruleNavigatingSemiArgCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4971:2: iv_ruleNavigatingSemiArgCS= ruleNavigatingSemiArgCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingSemiArgCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingSemiArgCS_in_entryRuleNavigatingSemiArgCS11463);
            iv_ruleNavigatingSemiArgCS=ruleNavigatingSemiArgCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingSemiArgCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigatingSemiArgCS11473); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4978:1: ruleNavigatingSemiArgCS returns [EObject current=null] : ( ( (lv_prefix_0_0= ';' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )? (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4981:28: ( ( ( (lv_prefix_0_0= ';' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )? (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4982:1: ( ( (lv_prefix_0_0= ';' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )? (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4982:1: ( ( (lv_prefix_0_0= ';' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )? (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4982:2: ( (lv_prefix_0_0= ';' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )? (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )?
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4982:2: ( (lv_prefix_0_0= ';' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4983:1: (lv_prefix_0_0= ';' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4983:1: (lv_prefix_0_0= ';' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4984:3: lv_prefix_0_0= ';'
            {
            lv_prefix_0_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleNavigatingSemiArgCS11516); if (state.failed) return current;
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4997:2: ( (lv_name_1_0= ruleNavigatingArgExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4998:1: (lv_name_1_0= ruleNavigatingArgExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4998:1: (lv_name_1_0= ruleNavigatingArgExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4999:3: lv_name_1_0= ruleNavigatingArgExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNavigatingSemiArgCSAccess().getNameNavigatingArgExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingSemiArgCS11550);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5015:2: (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )?
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( (LA89_0==31) ) {
                alt89=1;
            }
            switch (alt89) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5015:4: otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) )
                    {
                    otherlv_2=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleNavigatingSemiArgCS11563); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getNavigatingSemiArgCSAccess().getColonKeyword_2_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5019:1: ( (lv_ownedType_3_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5020:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5020:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5021:3: lv_ownedType_3_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingSemiArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleNavigatingSemiArgCS11584);
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


                    }
                    break;

            }

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5037:4: (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )?
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==48) ) {
                alt90=1;
            }
            switch (alt90) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5037:6: otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) )
                    {
                    otherlv_4=(Token)match(input,48,FollowSets000.FOLLOW_48_in_ruleNavigatingSemiArgCS11599); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getNavigatingSemiArgCSAccess().getEqualsSignKeyword_3_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5041:1: ( (lv_init_5_0= ruleExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5042:1: (lv_init_5_0= ruleExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5042:1: (lv_init_5_0= ruleExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5043:3: lv_init_5_0= ruleExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingSemiArgCSAccess().getInitExpCSParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNavigatingSemiArgCS11620);
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


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5067:1: entryRuleNavigatingArgExpCS returns [EObject current=null] : iv_ruleNavigatingArgExpCS= ruleNavigatingArgExpCS EOF ;
    public final EObject entryRuleNavigatingArgExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingArgExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5068:2: (iv_ruleNavigatingArgExpCS= ruleNavigatingArgExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5069:2: iv_ruleNavigatingArgExpCS= ruleNavigatingArgExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingArgExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgExpCS_in_entryRuleNavigatingArgExpCS11658);
            iv_ruleNavigatingArgExpCS=ruleNavigatingArgExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingArgExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigatingArgExpCS11668); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5076:1: ruleNavigatingArgExpCS returns [EObject current=null] : this_ExpCS_0= ruleExpCS ;
    public final EObject ruleNavigatingArgExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_ExpCS_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5079:28: (this_ExpCS_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5081:2: this_ExpCS_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getNavigatingArgExpCSAccess().getExpCSParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNavigatingArgExpCS11717);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5100:1: entryRuleIfExpCS returns [EObject current=null] : iv_ruleIfExpCS= ruleIfExpCS EOF ;
    public final EObject entryRuleIfExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5101:2: (iv_ruleIfExpCS= ruleIfExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5102:2: iv_ruleIfExpCS= ruleIfExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIfExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIfExpCS_in_entryRuleIfExpCS11751);
            iv_ruleIfExpCS=ruleIfExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIfExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIfExpCS11761); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5109:1: ruleIfExpCS returns [EObject current=null] : (otherlv_0= 'if' ( (lv_condition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_thenExpression_3_0= ruleExpCS ) ) otherlv_4= 'else' ( (lv_elseExpression_5_0= ruleExpCS ) ) otherlv_6= 'endif' ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5112:28: ( (otherlv_0= 'if' ( (lv_condition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_thenExpression_3_0= ruleExpCS ) ) otherlv_4= 'else' ( (lv_elseExpression_5_0= ruleExpCS ) ) otherlv_6= 'endif' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5113:1: (otherlv_0= 'if' ( (lv_condition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_thenExpression_3_0= ruleExpCS ) ) otherlv_4= 'else' ( (lv_elseExpression_5_0= ruleExpCS ) ) otherlv_6= 'endif' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5113:1: (otherlv_0= 'if' ( (lv_condition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_thenExpression_3_0= ruleExpCS ) ) otherlv_4= 'else' ( (lv_elseExpression_5_0= ruleExpCS ) ) otherlv_6= 'endif' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5113:3: otherlv_0= 'if' ( (lv_condition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_thenExpression_3_0= ruleExpCS ) ) otherlv_4= 'else' ( (lv_elseExpression_5_0= ruleExpCS ) ) otherlv_6= 'endif'
            {
            otherlv_0=(Token)match(input,76,FollowSets000.FOLLOW_76_in_ruleIfExpCS11798); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getIfExpCSAccess().getIfKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5117:1: ( (lv_condition_1_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5118:1: (lv_condition_1_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5118:1: (lv_condition_1_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5119:3: lv_condition_1_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIfExpCSAccess().getConditionExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleIfExpCS11819);
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

            otherlv_2=(Token)match(input,77,FollowSets000.FOLLOW_77_in_ruleIfExpCS11831); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getIfExpCSAccess().getThenKeyword_2());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5139:1: ( (lv_thenExpression_3_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5140:1: (lv_thenExpression_3_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5140:1: (lv_thenExpression_3_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5141:3: lv_thenExpression_3_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIfExpCSAccess().getThenExpressionExpCSParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleIfExpCS11852);
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

            otherlv_4=(Token)match(input,78,FollowSets000.FOLLOW_78_in_ruleIfExpCS11864); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getIfExpCSAccess().getElseKeyword_4());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5161:1: ( (lv_elseExpression_5_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5162:1: (lv_elseExpression_5_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5162:1: (lv_elseExpression_5_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5163:3: lv_elseExpression_5_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIfExpCSAccess().getElseExpressionExpCSParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleIfExpCS11885);
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

            otherlv_6=(Token)match(input,79,FollowSets000.FOLLOW_79_in_ruleIfExpCS11897); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5191:1: entryRuleLetExpCS returns [EObject current=null] : iv_ruleLetExpCS= ruleLetExpCS EOF ;
    public final EObject entryRuleLetExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLetExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5192:2: (iv_ruleLetExpCS= ruleLetExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5193:2: iv_ruleLetExpCS= ruleLetExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLetExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLetExpCS_in_entryRuleLetExpCS11933);
            iv_ruleLetExpCS=ruleLetExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLetExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLetExpCS11943); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5200:1: ruleLetExpCS returns [EObject current=null] : (otherlv_0= 'let' ( (lv_variable_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_variable_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_in_5_0= ruleExpCS ) ) ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5203:28: ( (otherlv_0= 'let' ( (lv_variable_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_variable_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_in_5_0= ruleExpCS ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5204:1: (otherlv_0= 'let' ( (lv_variable_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_variable_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_in_5_0= ruleExpCS ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5204:1: (otherlv_0= 'let' ( (lv_variable_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_variable_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_in_5_0= ruleExpCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5204:3: otherlv_0= 'let' ( (lv_variable_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_variable_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_in_5_0= ruleExpCS ) )
            {
            otherlv_0=(Token)match(input,80,FollowSets000.FOLLOW_80_in_ruleLetExpCS11980); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLetExpCSAccess().getLetKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5208:1: ( (lv_variable_1_0= ruleLetVariableCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5209:1: (lv_variable_1_0= ruleLetVariableCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5209:1: (lv_variable_1_0= ruleLetVariableCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5210:3: lv_variable_1_0= ruleLetVariableCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetExpCSAccess().getVariableLetVariableCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleLetVariableCS_in_ruleLetExpCS12001);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5226:2: (otherlv_2= ',' ( (lv_variable_3_0= ruleLetVariableCS ) ) )*
            loop91:
            do {
                int alt91=2;
                int LA91_0 = input.LA(1);

                if ( (LA91_0==20) ) {
                    alt91=1;
                }


                switch (alt91) {
            	case 1 :
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5226:4: otherlv_2= ',' ( (lv_variable_3_0= ruleLetVariableCS ) )
            	    {
            	    otherlv_2=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleLetExpCS12014); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getLetExpCSAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5230:1: ( (lv_variable_3_0= ruleLetVariableCS ) )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5231:1: (lv_variable_3_0= ruleLetVariableCS )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5231:1: (lv_variable_3_0= ruleLetVariableCS )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5232:3: lv_variable_3_0= ruleLetVariableCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLetExpCSAccess().getVariableLetVariableCSParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleLetVariableCS_in_ruleLetExpCS12035);
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
            	    break loop91;
                }
            } while (true);

            otherlv_4=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleLetExpCS12049); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getLetExpCSAccess().getInKeyword_3());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5252:1: ( (lv_in_5_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5253:1: (lv_in_5_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5253:1: (lv_in_5_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5254:3: lv_in_5_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetExpCSAccess().getInExpCSParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleLetExpCS12070);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5278:1: entryRuleLetVariableCS returns [EObject current=null] : iv_ruleLetVariableCS= ruleLetVariableCS EOF ;
    public final EObject entryRuleLetVariableCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLetVariableCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5279:2: (iv_ruleLetVariableCS= ruleLetVariableCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5280:2: iv_ruleLetVariableCS= ruleLetVariableCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLetVariableCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLetVariableCS_in_entryRuleLetVariableCS12106);
            iv_ruleLetVariableCS=ruleLetVariableCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLetVariableCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLetVariableCS12116); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5287:1: ruleLetVariableCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) ) ) ;
    public final EObject ruleLetVariableCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;

        EObject lv_initExpression_4_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5290:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5291:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5291:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5291:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5291:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5292:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5292:1: (lv_name_0_0= ruleUnrestrictedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5293:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetVariableCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleLetVariableCS12162);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5309:2: (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )?
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( (LA92_0==31) ) {
                alt92=1;
            }
            switch (alt92) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5309:4: otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                    {
                    otherlv_1=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleLetVariableCS12175); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getLetVariableCSAccess().getColonKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5313:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5314:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5314:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5315:3: lv_ownedType_2_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLetVariableCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleLetVariableCS12196);
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

            otherlv_3=(Token)match(input,48,FollowSets000.FOLLOW_48_in_ruleLetVariableCS12210); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getLetVariableCSAccess().getEqualsSignKeyword_2());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5335:1: ( (lv_initExpression_4_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5336:1: (lv_initExpression_4_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5336:1: (lv_initExpression_4_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5337:3: lv_initExpression_4_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetVariableCSAccess().getInitExpressionExpCSParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleLetVariableCS12231);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5361:1: entryRuleNestedExpCS returns [EObject current=null] : iv_ruleNestedExpCS= ruleNestedExpCS EOF ;
    public final EObject entryRuleNestedExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNestedExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5362:2: (iv_ruleNestedExpCS= ruleNestedExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5363:2: iv_ruleNestedExpCS= ruleNestedExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNestedExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNestedExpCS_in_entryRuleNestedExpCS12267);
            iv_ruleNestedExpCS=ruleNestedExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNestedExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNestedExpCS12277); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5370:1: ruleNestedExpCS returns [EObject current=null] : (otherlv_0= '(' ( (lv_source_1_0= ruleExpCS ) ) otherlv_2= ')' ) ;
    public final EObject ruleNestedExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_source_1_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5373:28: ( (otherlv_0= '(' ( (lv_source_1_0= ruleExpCS ) ) otherlv_2= ')' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5374:1: (otherlv_0= '(' ( (lv_source_1_0= ruleExpCS ) ) otherlv_2= ')' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5374:1: (otherlv_0= '(' ( (lv_source_1_0= ruleExpCS ) ) otherlv_2= ')' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5374:3: otherlv_0= '(' ( (lv_source_1_0= ruleExpCS ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleNestedExpCS12314); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getNestedExpCSAccess().getLeftParenthesisKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5378:1: ( (lv_source_1_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5379:1: (lv_source_1_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5379:1: (lv_source_1_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5380:3: lv_source_1_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNestedExpCSAccess().getSourceExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNestedExpCS12335);
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

            otherlv_2=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleNestedExpCS12347); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5408:1: entryRuleSelfExpCS returns [EObject current=null] : iv_ruleSelfExpCS= ruleSelfExpCS EOF ;
    public final EObject entryRuleSelfExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelfExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5409:2: (iv_ruleSelfExpCS= ruleSelfExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5410:2: iv_ruleSelfExpCS= ruleSelfExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSelfExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSelfExpCS_in_entryRuleSelfExpCS12383);
            iv_ruleSelfExpCS=ruleSelfExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSelfExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSelfExpCS12393); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5417:1: ruleSelfExpCS returns [EObject current=null] : ( () otherlv_1= 'self' ) ;
    public final EObject ruleSelfExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5420:28: ( ( () otherlv_1= 'self' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5421:1: ( () otherlv_1= 'self' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5421:1: ( () otherlv_1= 'self' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5421:2: () otherlv_1= 'self'
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5421:2: ()
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5422:2: 
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

            otherlv_1=(Token)match(input,81,FollowSets000.FOLLOW_81_in_ruleSelfExpCS12442); if (state.failed) return current;
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

    // $ANTLR start synpred16_InternalQVTcore
    public final void synpred16_InternalQVTcore_fragment() throws RecognitionException {   
        Token otherlv_9=null;
        Token otherlv_10=null;
        EObject lv_domains_12_0 = null;


        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:499:2: ( (otherlv_9= 'check' )? (otherlv_10= 'enforce' )? ruleDirectionNameCS ( (lv_domains_12_0= ruleDomainCS ) ) )
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:499:2: (otherlv_9= 'check' )? (otherlv_10= 'enforce' )? ruleDirectionNameCS ( (lv_domains_12_0= ruleDomainCS ) )
        {
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:499:2: (otherlv_9= 'check' )?
        int alt97=2;
        int LA97_0 = input.LA(1);

        if ( (LA97_0==25) ) {
            int LA97_1 = input.LA(2);

            if ( ((LA97_1>=RULE_SIMPLE_ID && LA97_1<=RULE_ESCAPED_ID)||LA97_1==14||LA97_1==19||(LA97_1>=21 && LA97_1<=22)||(LA97_1>=24 && LA97_1<=27)||LA97_1==32||LA97_1==35||(LA97_1>=37 && LA97_1<=38)) ) {
                alt97=1;
            }
        }
        switch (alt97) {
            case 1 :
                // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:499:4: otherlv_9= 'check'
                {
                otherlv_9=(Token)match(input,25,FollowSets000.FOLLOW_25_in_synpred16_InternalQVTcore956); if (state.failed) return ;

                }
                break;

        }

        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:503:3: (otherlv_10= 'enforce' )?
        int alt98=2;
        int LA98_0 = input.LA(1);

        if ( (LA98_0==26) ) {
            int LA98_1 = input.LA(2);

            if ( ((LA98_1>=RULE_SIMPLE_ID && LA98_1<=RULE_ESCAPED_ID)||LA98_1==14||LA98_1==19||(LA98_1>=21 && LA98_1<=22)||(LA98_1>=24 && LA98_1<=27)||LA98_1==32||LA98_1==35||(LA98_1>=37 && LA98_1<=38)) ) {
                alt98=1;
            }
        }
        switch (alt98) {
            case 1 :
                // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:503:5: otherlv_10= 'enforce'
                {
                otherlv_10=(Token)match(input,26,FollowSets000.FOLLOW_26_in_synpred16_InternalQVTcore971); if (state.failed) return ;

                }
                break;

        }

        pushFollow(FollowSets000.FOLLOW_ruleDirectionNameCS_in_synpred16_InternalQVTcore992);
        ruleDirectionNameCS();

        state._fsp--;
        if (state.failed) return ;
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:518:1: ( (lv_domains_12_0= ruleDomainCS ) )
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:519:1: (lv_domains_12_0= ruleDomainCS )
        {
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:519:1: (lv_domains_12_0= ruleDomainCS )
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:520:3: lv_domains_12_0= ruleDomainCS
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getMappingCSAccess().getDomainsDomainCSParserRuleCall_5_3_0()); 
          	    
        }
        pushFollow(FollowSets000.FOLLOW_ruleDomainCS_in_synpred16_InternalQVTcore1012);
        lv_domains_12_0=ruleDomainCS();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred16_InternalQVTcore

    // $ANTLR start synpred26_InternalQVTcore
    public final void synpred26_InternalQVTcore_fragment() throws RecognitionException {   
        EObject this_PredicateCS_0 = null;


        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1064:2: (this_PredicateCS_0= rulePredicateCS )
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1064:2: this_PredicateCS_0= rulePredicateCS
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_rulePredicateCS_in_synpred26_InternalQVTcore2133);
        this_PredicateCS_0=rulePredicateCS();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred26_InternalQVTcore

    // $ANTLR start synpred42_InternalQVTcore
    public final void synpred42_InternalQVTcore_fragment() throws RecognitionException {   
        Token kw=null;
        Token this_INT_2=null;

        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1637:2: (kw= '.' this_INT_2= RULE_INT )
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1637:2: kw= '.' this_INT_2= RULE_INT
        {
        kw=(Token)match(input,36,FollowSets000.FOLLOW_36_in_synpred42_InternalQVTcore3557); if (state.failed) return ;
        this_INT_2=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_synpred42_InternalQVTcore3572); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred42_InternalQVTcore

    // $ANTLR start synpred79_InternalQVTcore
    public final void synpred79_InternalQVTcore_fragment() throws RecognitionException {   
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_ownedType_5_0 = null;


        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2437:6: ( (otherlv_4= '<' ( (lv_ownedType_5_0= ruleTypeExpCS ) ) otherlv_6= '>' ) )
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2437:6: (otherlv_4= '<' ( (lv_ownedType_5_0= ruleTypeExpCS ) ) otherlv_6= '>' )
        {
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2437:6: (otherlv_4= '<' ( (lv_ownedType_5_0= ruleTypeExpCS ) ) otherlv_6= '>' )
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2437:8: otherlv_4= '<' ( (lv_ownedType_5_0= ruleTypeExpCS ) ) otherlv_6= '>'
        {
        otherlv_4=(Token)match(input,45,FollowSets000.FOLLOW_45_in_synpred79_InternalQVTcore5912); if (state.failed) return ;
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2441:1: ( (lv_ownedType_5_0= ruleTypeExpCS ) )
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2442:1: (lv_ownedType_5_0= ruleTypeExpCS )
        {
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2442:1: (lv_ownedType_5_0= ruleTypeExpCS )
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2443:3: lv_ownedType_5_0= ruleTypeExpCS
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getCollectionTypeCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_1_0()); 
          	    
        }
        pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_synpred79_InternalQVTcore5933);
        lv_ownedType_5_0=ruleTypeExpCS();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        otherlv_6=(Token)match(input,44,FollowSets000.FOLLOW_44_in_synpred79_InternalQVTcore5945); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred79_InternalQVTcore

    // $ANTLR start synpred85_InternalQVTcore
    public final void synpred85_InternalQVTcore_fragment() throws RecognitionException {   
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject lv_ownedParts_7_0 = null;

        EObject lv_ownedParts_9_0 = null;


        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2548:6: ( (otherlv_6= '<' ( ( (lv_ownedParts_7_0= ruletuplePartCS ) ) (otherlv_8= ',' ( (lv_ownedParts_9_0= ruletuplePartCS ) ) )* )? otherlv_10= '>' ) )
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2548:6: (otherlv_6= '<' ( ( (lv_ownedParts_7_0= ruletuplePartCS ) ) (otherlv_8= ',' ( (lv_ownedParts_9_0= ruletuplePartCS ) ) )* )? otherlv_10= '>' )
        {
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2548:6: (otherlv_6= '<' ( ( (lv_ownedParts_7_0= ruletuplePartCS ) ) (otherlv_8= ',' ( (lv_ownedParts_9_0= ruletuplePartCS ) ) )* )? otherlv_10= '>' )
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2548:8: otherlv_6= '<' ( ( (lv_ownedParts_7_0= ruletuplePartCS ) ) (otherlv_8= ',' ( (lv_ownedParts_9_0= ruletuplePartCS ) ) )* )? otherlv_10= '>'
        {
        otherlv_6=(Token)match(input,45,FollowSets000.FOLLOW_45_in_synpred85_InternalQVTcore6156); if (state.failed) return ;
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2552:1: ( ( (lv_ownedParts_7_0= ruletuplePartCS ) ) (otherlv_8= ',' ( (lv_ownedParts_9_0= ruletuplePartCS ) ) )* )?
        int alt112=2;
        int LA112_0 = input.LA(1);

        if ( ((LA112_0>=RULE_SIMPLE_ID && LA112_0<=RULE_ESCAPED_ID)||LA112_0==14||LA112_0==19||(LA112_0>=21 && LA112_0<=22)||(LA112_0>=24 && LA112_0<=27)||LA112_0==32||LA112_0==35||(LA112_0>=37 && LA112_0<=38)) ) {
            alt112=1;
        }
        switch (alt112) {
            case 1 :
                // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2552:2: ( (lv_ownedParts_7_0= ruletuplePartCS ) ) (otherlv_8= ',' ( (lv_ownedParts_9_0= ruletuplePartCS ) ) )*
                {
                // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2552:2: ( (lv_ownedParts_7_0= ruletuplePartCS ) )
                // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2553:1: (lv_ownedParts_7_0= ruletuplePartCS )
                {
                // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2553:1: (lv_ownedParts_7_0= ruletuplePartCS )
                // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2554:3: lv_ownedParts_7_0= ruletuplePartCS
                {
                if ( state.backtracking==0 ) {
                   
                  	        newCompositeNode(grammarAccess.getTupleTypeCSAccess().getOwnedPartsTuplePartCSParserRuleCall_1_1_1_0_0()); 
                  	    
                }
                pushFollow(FollowSets000.FOLLOW_ruletuplePartCS_in_synpred85_InternalQVTcore6178);
                lv_ownedParts_7_0=ruletuplePartCS();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2570:2: (otherlv_8= ',' ( (lv_ownedParts_9_0= ruletuplePartCS ) ) )*
                loop111:
                do {
                    int alt111=2;
                    int LA111_0 = input.LA(1);

                    if ( (LA111_0==20) ) {
                        alt111=1;
                    }


                    switch (alt111) {
                	case 1 :
                	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2570:4: otherlv_8= ',' ( (lv_ownedParts_9_0= ruletuplePartCS ) )
                	    {
                	    otherlv_8=(Token)match(input,20,FollowSets000.FOLLOW_20_in_synpred85_InternalQVTcore6191); if (state.failed) return ;
                	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2574:1: ( (lv_ownedParts_9_0= ruletuplePartCS ) )
                	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2575:1: (lv_ownedParts_9_0= ruletuplePartCS )
                	    {
                	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2575:1: (lv_ownedParts_9_0= ruletuplePartCS )
                	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2576:3: lv_ownedParts_9_0= ruletuplePartCS
                	    {
                	    if ( state.backtracking==0 ) {
                	       
                	      	        newCompositeNode(grammarAccess.getTupleTypeCSAccess().getOwnedPartsTuplePartCSParserRuleCall_1_1_1_1_1_0()); 
                	      	    
                	    }
                	    pushFollow(FollowSets000.FOLLOW_ruletuplePartCS_in_synpred85_InternalQVTcore6212);
                	    lv_ownedParts_9_0=ruletuplePartCS();

                	    state._fsp--;
                	    if (state.failed) return ;

                	    }


                	    }


                	    }
                	    break;

                	default :
                	    break loop111;
                    }
                } while (true);


                }
                break;

        }

        otherlv_10=(Token)match(input,44,FollowSets000.FOLLOW_44_in_synpred85_InternalQVTcore6228); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred85_InternalQVTcore

    // $ANTLR start synpred106_InternalQVTcore
    public final void synpred106_InternalQVTcore_fragment() throws RecognitionException {   
        EObject lv_ownedOperator_2_0 = null;

        EObject lv_ownedExpression_3_0 = null;


        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3823:3: ( ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) )
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3823:3: ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) )
        {
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3823:3: ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) )
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3824:1: (lv_ownedOperator_2_0= ruleBinaryOperatorCS )
        {
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3824:1: (lv_ownedOperator_2_0= ruleBinaryOperatorCS )
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3825:3: lv_ownedOperator_2_0= ruleBinaryOperatorCS
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getInfixedExpCSAccess().getOwnedOperatorBinaryOperatorCSParserRuleCall_1_1_0_0()); 
          	    
        }
        pushFollow(FollowSets000.FOLLOW_ruleBinaryOperatorCS_in_synpred106_InternalQVTcore9074);
        lv_ownedOperator_2_0=ruleBinaryOperatorCS();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3841:2: ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) )
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3842:1: (lv_ownedExpression_3_0= rulePrefixedExpCS )
        {
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3842:1: (lv_ownedExpression_3_0= rulePrefixedExpCS )
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3843:3: lv_ownedExpression_3_0= rulePrefixedExpCS
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getInfixedExpCSAccess().getOwnedExpressionPrefixedExpCSParserRuleCall_1_1_1_0()); 
          	    
        }
        pushFollow(FollowSets000.FOLLOW_rulePrefixedExpCS_in_synpred106_InternalQVTcore9095);
        lv_ownedExpression_3_0=rulePrefixedExpCS();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred106_InternalQVTcore

    // $ANTLR start synpred107_InternalQVTcore
    public final void synpred107_InternalQVTcore_fragment() throws RecognitionException {   
        EObject lv_ownedOperator_2_0 = null;

        EObject lv_ownedExpression_3_0 = null;


        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3814:2: ( () ( ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) )+ )
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3814:2: () ( ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) )+
        {
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3814:2: ()
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3815:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3823:2: ( ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) )+
        int cnt116=0;
        loop116:
        do {
            int alt116=2;
            int LA116_0 = input.LA(1);

            if ( (LA116_0==36||(LA116_0>=39 && LA116_0<=40)||(LA116_0>=42 && LA116_0<=54)) ) {
                alt116=1;
            }


            switch (alt116) {
        	case 1 :
        	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3823:3: ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) )
        	    {
        	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3823:3: ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) )
        	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3824:1: (lv_ownedOperator_2_0= ruleBinaryOperatorCS )
        	    {
        	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3824:1: (lv_ownedOperator_2_0= ruleBinaryOperatorCS )
        	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3825:3: lv_ownedOperator_2_0= ruleBinaryOperatorCS
        	    {
        	    if ( state.backtracking==0 ) {
        	       
        	      	        newCompositeNode(grammarAccess.getInfixedExpCSAccess().getOwnedOperatorBinaryOperatorCSParserRuleCall_1_1_0_0()); 
        	      	    
        	    }
        	    pushFollow(FollowSets000.FOLLOW_ruleBinaryOperatorCS_in_synpred107_InternalQVTcore9074);
        	    lv_ownedOperator_2_0=ruleBinaryOperatorCS();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }

        	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3841:2: ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) )
        	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3842:1: (lv_ownedExpression_3_0= rulePrefixedExpCS )
        	    {
        	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3842:1: (lv_ownedExpression_3_0= rulePrefixedExpCS )
        	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3843:3: lv_ownedExpression_3_0= rulePrefixedExpCS
        	    {
        	    if ( state.backtracking==0 ) {
        	       
        	      	        newCompositeNode(grammarAccess.getInfixedExpCSAccess().getOwnedExpressionPrefixedExpCSParserRuleCall_1_1_1_0()); 
        	      	    
        	    }
        	    pushFollow(FollowSets000.FOLLOW_rulePrefixedExpCS_in_synpred107_InternalQVTcore9095);
        	    lv_ownedExpression_3_0=rulePrefixedExpCS();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }


        	    }
        	    break;

        	default :
        	    if ( cnt116 >= 1 ) break loop116;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(116, input);
                    throw eee;
            }
            cnt116++;
        } while (true);


        }
    }
    // $ANTLR end synpred107_InternalQVTcore

    // $ANTLR start synpred111_InternalQVTcore
    public final void synpred111_InternalQVTcore_fragment() throws RecognitionException {   
        EObject this_NavigatingExpCS_0 = null;


        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4123:2: (this_NavigatingExpCS_0= ruleNavigatingExpCS )
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4123:2: this_NavigatingExpCS_0= ruleNavigatingExpCS
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleNavigatingExpCS_in_synpred111_InternalQVTcore9748);
        this_NavigatingExpCS_0=ruleNavigatingExpCS();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred111_InternalQVTcore

    // $ANTLR start synpred114_InternalQVTcore
    public final void synpred114_InternalQVTcore_fragment() throws RecognitionException {   
        EObject this_TupleLiteralExpCS_3 = null;


        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4162:2: (this_TupleLiteralExpCS_3= ruleTupleLiteralExpCS )
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4162:2: this_TupleLiteralExpCS_3= ruleTupleLiteralExpCS
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralExpCS_in_synpred114_InternalQVTcore9838);
        this_TupleLiteralExpCS_3=ruleTupleLiteralExpCS();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred114_InternalQVTcore

    // $ANTLR start synpred115_InternalQVTcore
    public final void synpred115_InternalQVTcore_fragment() throws RecognitionException {   
        EObject this_CollectionLiteralExpCS_4 = null;


        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4175:2: (this_CollectionLiteralExpCS_4= ruleCollectionLiteralExpCS )
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4175:2: this_CollectionLiteralExpCS_4= ruleCollectionLiteralExpCS
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteralExpCS_in_synpred115_InternalQVTcore9868);
        this_CollectionLiteralExpCS_4=ruleCollectionLiteralExpCS();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred115_InternalQVTcore

    // $ANTLR start synpred116_InternalQVTcore
    public final void synpred116_InternalQVTcore_fragment() throws RecognitionException {   
        EObject this_ConstructorExpCS_5 = null;


        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4188:2: (this_ConstructorExpCS_5= ruleConstructorExpCS )
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4188:2: this_ConstructorExpCS_5= ruleConstructorExpCS
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleConstructorExpCS_in_synpred116_InternalQVTcore9898);
        this_ConstructorExpCS_5=ruleConstructorExpCS();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred116_InternalQVTcore

    // $ANTLR start synpred117_InternalQVTcore
    public final void synpred117_InternalQVTcore_fragment() throws RecognitionException {   
        EObject this_TypeLiteralExpCS_6 = null;


        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4201:2: (this_TypeLiteralExpCS_6= ruleTypeLiteralExpCS )
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4201:2: this_TypeLiteralExpCS_6= ruleTypeLiteralExpCS
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralExpCS_in_synpred117_InternalQVTcore9928);
        this_TypeLiteralExpCS_6=ruleTypeLiteralExpCS();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred117_InternalQVTcore

    // Delegated rules

    public final boolean synpred114_InternalQVTcore() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred114_InternalQVTcore_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred111_InternalQVTcore() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred111_InternalQVTcore_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred16_InternalQVTcore() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred16_InternalQVTcore_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred116_InternalQVTcore() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred116_InternalQVTcore_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred42_InternalQVTcore() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred42_InternalQVTcore_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred107_InternalQVTcore() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred107_InternalQVTcore_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred85_InternalQVTcore() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred85_InternalQVTcore_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred115_InternalQVTcore() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred115_InternalQVTcore_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred117_InternalQVTcore() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred117_InternalQVTcore_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred106_InternalQVTcore() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred106_InternalQVTcore_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred79_InternalQVTcore() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred79_InternalQVTcore_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred26_InternalQVTcore() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred26_InternalQVTcore_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA3 dfa3 = new DFA3(this);
    protected DFA2 dfa2 = new DFA2(this);
    protected DFA14 dfa14 = new DFA14(this);
    protected DFA17 dfa17 = new DFA17(this);
    protected DFA22 dfa22 = new DFA22(this);
    protected DFA24 dfa24 = new DFA24(this);
    protected DFA43 dfa43 = new DFA43(this);
    protected DFA48 dfa48 = new DFA48(this);
    protected DFA53 dfa53 = new DFA53(this);
    protected DFA52 dfa52 = new DFA52(this);
    protected DFA62 dfa62 = new DFA62(this);
    protected DFA61 dfa61 = new DFA61(this);
    protected DFA65 dfa65 = new DFA65(this);
    protected DFA64 dfa64 = new DFA64(this);
    protected DFA69 dfa69 = new DFA69(this);
    protected DFA71 dfa71 = new DFA71(this);
    protected DFA70 dfa70 = new DFA70(this);
    static final String DFA3_eotS =
        "\21\uffff";
    static final String DFA3_eofS =
        "\21\uffff";
    static final String DFA3_minS =
        "\1\4\16\17\2\uffff";
    static final String DFA3_maxS =
        "\1\104\16\20\2\uffff";
    static final String DFA3_acceptS =
        "\17\uffff\1\2\1\1";
    static final String DFA3_specialS =
        "\21\uffff}>";
    static final String[] DFA3_transitionS = {
            "\1\1\1\2\10\uffff\1\14\4\uffff\1\7\1\uffff\1\15\1\10\1\uffff"+
            "\1\13\1\5\1\6\1\16\4\uffff\1\12\2\uffff\1\11\1\uffff\1\3\1\4"+
            "\20\uffff\16\17",
            "\1\20\1\17",
            "\1\20\1\17",
            "\1\20\1\17",
            "\1\20\1\17",
            "\1\20\1\17",
            "\1\20\1\17",
            "\1\20\1\17",
            "\1\20\1\17",
            "\1\20\1\17",
            "\1\20\1\17",
            "\1\20\1\17",
            "\1\20\1\17",
            "\1\20\1\17",
            "\1\20\1\17",
            "",
            ""
    };

    static final short[] DFA3_eot = DFA.unpackEncodedString(DFA3_eotS);
    static final short[] DFA3_eof = DFA.unpackEncodedString(DFA3_eofS);
    static final char[] DFA3_min = DFA.unpackEncodedStringToUnsignedChars(DFA3_minS);
    static final char[] DFA3_max = DFA.unpackEncodedStringToUnsignedChars(DFA3_maxS);
    static final short[] DFA3_accept = DFA.unpackEncodedString(DFA3_acceptS);
    static final short[] DFA3_special = DFA.unpackEncodedString(DFA3_specialS);
    static final short[][] DFA3_transition;

    static {
        int numStates = DFA3_transitionS.length;
        DFA3_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA3_transition[i] = DFA.unpackEncodedString(DFA3_transitionS[i]);
        }
    }

    class DFA3 extends DFA {

        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 3;
            this.eot = DFA3_eot;
            this.eof = DFA3_eof;
            this.min = DFA3_min;
            this.max = DFA3_max;
            this.accept = DFA3_accept;
            this.special = DFA3_special;
            this.transition = DFA3_transition;
        }
        public String getDescription() {
            return "167:1: ( ( ( ruleUnrestrictedName ) ) otherlv_2= '::' ( ( ( ruleUnreservedName ) ) otherlv_4= '::' )* )?";
        }
    }
    static final String DFA2_eotS =
        "\37\uffff";
    static final String DFA2_eofS =
        "\37\uffff";
    static final String DFA2_minS =
        "\1\4\34\17\2\uffff";
    static final String DFA2_maxS =
        "\1\104\34\20\2\uffff";
    static final String DFA2_acceptS =
        "\35\uffff\1\2\1\1";
    static final String DFA2_specialS =
        "\37\uffff}>";
    static final String[] DFA2_transitionS = {
            "\1\1\1\2\10\uffff\1\14\4\uffff\1\7\1\uffff\1\15\1\10\1\uffff"+
            "\1\13\1\5\1\6\1\16\4\uffff\1\12\2\uffff\1\11\1\uffff\1\3\1\4"+
            "\20\uffff\1\34\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\17"+
            "\1\20\1\21\1\22\1\23",
            "\1\36\1\35",
            "\1\36\1\35",
            "\1\36\1\35",
            "\1\36\1\35",
            "\1\36\1\35",
            "\1\36\1\35",
            "\1\36\1\35",
            "\1\36\1\35",
            "\1\36\1\35",
            "\1\36\1\35",
            "\1\36\1\35",
            "\1\36\1\35",
            "\1\36\1\35",
            "\1\36\1\35",
            "\1\36\1\35",
            "\1\36\1\35",
            "\1\36\1\35",
            "\1\36\1\35",
            "\1\36\1\35",
            "\1\36\1\35",
            "\1\36\1\35",
            "\1\36\1\35",
            "\1\36\1\35",
            "\1\36\1\35",
            "\1\36\1\35",
            "\1\36\1\35",
            "\1\36\1\35",
            "\1\36\1\35",
            "",
            ""
    };

    static final short[] DFA2_eot = DFA.unpackEncodedString(DFA2_eotS);
    static final short[] DFA2_eof = DFA.unpackEncodedString(DFA2_eofS);
    static final char[] DFA2_min = DFA.unpackEncodedStringToUnsignedChars(DFA2_minS);
    static final char[] DFA2_max = DFA.unpackEncodedStringToUnsignedChars(DFA2_maxS);
    static final short[] DFA2_accept = DFA.unpackEncodedString(DFA2_acceptS);
    static final short[] DFA2_special = DFA.unpackEncodedString(DFA2_specialS);
    static final short[][] DFA2_transition;

    static {
        int numStates = DFA2_transitionS.length;
        DFA2_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA2_transition[i] = DFA.unpackEncodedString(DFA2_transitionS[i]);
        }
    }

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = DFA2_eot;
            this.eof = DFA2_eof;
            this.min = DFA2_min;
            this.max = DFA2_max;
            this.accept = DFA2_accept;
            this.special = DFA2_special;
            this.transition = DFA2_transition;
        }
        public String getDescription() {
            return "()* loopback of 189:1: ( ( ( ruleUnreservedName ) ) otherlv_4= '::' )*";
        }
    }
    static final String DFA14_eotS =
        "\20\uffff";
    static final String DFA14_eofS =
        "\20\uffff";
    static final String DFA14_minS =
        "\1\4\1\0\16\uffff";
    static final String DFA14_maxS =
        "\1\46\1\0\16\uffff";
    static final String DFA14_acceptS =
        "\2\uffff\1\1\14\uffff\1\2";
    static final String DFA14_specialS =
        "\1\uffff\1\0\16\uffff}>";
    static final String[] DFA14_transitionS = {
            "\2\2\10\uffff\1\2\4\uffff\1\2\1\uffff\2\2\1\uffff\3\2\1\1\4"+
            "\uffff\1\2\2\uffff\1\2\1\uffff\2\2",
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
            return "()* loopback of 499:1: ( (otherlv_9= 'check' )? (otherlv_10= 'enforce' )? ruleDirectionNameCS ( (lv_domains_12_0= ruleDomainCS ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA14_1 = input.LA(1);

                         
                        int index14_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred16_InternalQVTcore()) ) {s = 2;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index14_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 14, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA17_eotS =
        "\21\uffff";
    static final String DFA17_eofS =
        "\1\17\20\uffff";
    static final String DFA17_minS =
        "\1\4\16\17\2\uffff";
    static final String DFA17_maxS =
        "\1\121\16\112\2\uffff";
    static final String DFA17_acceptS =
        "\17\uffff\1\2\1\1";
    static final String DFA17_specialS =
        "\21\uffff}>";
    static final String[] DFA17_transitionS = {
            "\1\1\1\2\2\17\6\uffff\1\14\4\uffff\1\7\1\uffff\1\15\1\10\1"+
            "\uffff\1\13\1\5\1\6\1\16\2\17\2\uffff\1\12\1\17\1\uffff\1\11"+
            "\1\uffff\1\3\1\4\1\uffff\3\17\14\uffff\16\17\1\uffff\4\17\2"+
            "\uffff\1\17\3\uffff\2\17",
            "\3\17\12\uffff\1\17\2\uffff\1\20\2\uffff\1\17\1\uffff\1\17"+
            "\2\uffff\2\17\1\uffff\15\17\23\uffff\1\17",
            "\3\17\12\uffff\1\17\2\uffff\1\20\2\uffff\1\17\1\uffff\1\17"+
            "\2\uffff\2\17\1\uffff\15\17\23\uffff\1\17",
            "\3\17\12\uffff\1\17\2\uffff\1\20\2\uffff\1\17\1\uffff\1\17"+
            "\2\uffff\2\17\1\uffff\15\17\23\uffff\1\17",
            "\3\17\12\uffff\1\17\2\uffff\1\20\2\uffff\1\17\1\uffff\1\17"+
            "\2\uffff\2\17\1\uffff\15\17\23\uffff\1\17",
            "\3\17\12\uffff\1\17\2\uffff\1\20\2\uffff\1\17\1\uffff\1\17"+
            "\2\uffff\2\17\1\uffff\15\17\23\uffff\1\17",
            "\3\17\12\uffff\1\17\2\uffff\1\20\2\uffff\1\17\1\uffff\1\17"+
            "\2\uffff\2\17\1\uffff\15\17\23\uffff\1\17",
            "\3\17\12\uffff\1\17\2\uffff\1\20\2\uffff\1\17\1\uffff\1\17"+
            "\2\uffff\2\17\1\uffff\15\17\23\uffff\1\17",
            "\3\17\12\uffff\1\17\2\uffff\1\20\2\uffff\1\17\1\uffff\1\17"+
            "\2\uffff\2\17\1\uffff\15\17\23\uffff\1\17",
            "\3\17\12\uffff\1\17\2\uffff\1\20\2\uffff\1\17\1\uffff\1\17"+
            "\2\uffff\2\17\1\uffff\15\17\23\uffff\1\17",
            "\3\17\12\uffff\1\17\2\uffff\1\20\2\uffff\1\17\1\uffff\1\17"+
            "\2\uffff\2\17\1\uffff\15\17\23\uffff\1\17",
            "\3\17\12\uffff\1\17\2\uffff\1\20\2\uffff\1\17\1\uffff\1\17"+
            "\2\uffff\2\17\1\uffff\15\17\23\uffff\1\17",
            "\3\17\12\uffff\1\17\2\uffff\1\20\2\uffff\1\17\1\uffff\1\17"+
            "\2\uffff\2\17\1\uffff\15\17\23\uffff\1\17",
            "\3\17\12\uffff\1\17\2\uffff\1\20\2\uffff\1\17\1\uffff\1\17"+
            "\2\uffff\2\17\1\uffff\15\17\23\uffff\1\17",
            "\3\17\12\uffff\1\17\2\uffff\1\20\2\uffff\1\17\1\uffff\1\17"+
            "\2\uffff\2\17\1\uffff\15\17\23\uffff\1\17",
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
            return "716:2: ( ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) (otherlv_2= ',' ( (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS ) ) )* otherlv_4= '|' )?";
        }
    }
    static final String DFA22_eotS =
        "\21\uffff";
    static final String DFA22_eofS =
        "\1\17\20\uffff";
    static final String DFA22_minS =
        "\1\4\11\17\1\4\4\17\2\uffff";
    static final String DFA22_maxS =
        "\1\121\16\112\2\uffff";
    static final String DFA22_acceptS =
        "\17\uffff\1\2\1\1";
    static final String DFA22_specialS =
        "\21\uffff}>";
    static final String[] DFA22_transitionS = {
            "\1\1\1\2\2\17\6\uffff\1\14\3\uffff\1\17\1\7\1\uffff\1\15\1"+
            "\10\1\uffff\1\13\1\5\1\6\1\16\1\17\3\uffff\1\12\1\17\1\uffff"+
            "\1\11\1\uffff\1\3\1\4\1\uffff\3\17\14\uffff\16\17\1\uffff\4"+
            "\17\2\uffff\1\17\3\uffff\2\17",
            "\3\17\12\uffff\1\17\2\uffff\1\20\2\uffff\1\17\1\uffff\1\17"+
            "\2\uffff\2\17\1\uffff\15\17\23\uffff\1\17",
            "\3\17\12\uffff\1\17\2\uffff\1\20\2\uffff\1\17\1\uffff\1\17"+
            "\2\uffff\2\17\1\uffff\15\17\23\uffff\1\17",
            "\3\17\12\uffff\1\17\2\uffff\1\20\2\uffff\1\17\1\uffff\1\17"+
            "\2\uffff\2\17\1\uffff\15\17\23\uffff\1\17",
            "\3\17\12\uffff\1\17\2\uffff\1\20\2\uffff\1\17\1\uffff\1\17"+
            "\2\uffff\2\17\1\uffff\15\17\23\uffff\1\17",
            "\3\17\12\uffff\1\17\2\uffff\1\20\2\uffff\1\17\1\uffff\1\17"+
            "\2\uffff\2\17\1\uffff\15\17\23\uffff\1\17",
            "\3\17\12\uffff\1\17\2\uffff\1\20\2\uffff\1\17\1\uffff\1\17"+
            "\2\uffff\2\17\1\uffff\15\17\23\uffff\1\17",
            "\3\17\12\uffff\1\17\2\uffff\1\20\2\uffff\1\17\1\uffff\1\17"+
            "\2\uffff\2\17\1\uffff\15\17\23\uffff\1\17",
            "\3\17\12\uffff\1\17\2\uffff\1\20\2\uffff\1\17\1\uffff\1\17"+
            "\2\uffff\2\17\1\uffff\15\17\23\uffff\1\17",
            "\3\17\12\uffff\1\17\2\uffff\1\20\2\uffff\1\17\1\uffff\1\17"+
            "\2\uffff\2\17\1\uffff\15\17\23\uffff\1\17",
            "\2\20\10\uffff\1\20\3\17\1\uffff\1\20\1\uffff\2\20\1\uffff"+
            "\4\20\1\17\2\uffff\2\20\1\uffff\1\17\1\20\1\17\2\20\2\17\1\uffff"+
            "\15\17\23\uffff\1\17",
            "\3\17\12\uffff\1\17\2\uffff\1\20\2\uffff\1\17\1\uffff\1\17"+
            "\2\uffff\2\17\1\uffff\15\17\23\uffff\1\17",
            "\3\17\12\uffff\1\17\2\uffff\1\20\2\uffff\1\17\1\uffff\1\17"+
            "\2\uffff\2\17\1\uffff\15\17\23\uffff\1\17",
            "\3\17\12\uffff\1\17\2\uffff\1\20\2\uffff\1\17\1\uffff\1\17"+
            "\2\uffff\2\17\1\uffff\15\17\23\uffff\1\17",
            "\3\17\12\uffff\1\17\2\uffff\1\20\2\uffff\1\17\1\uffff\1\17"+
            "\2\uffff\2\17\1\uffff\15\17\23\uffff\1\17",
            "",
            ""
    };

    static final short[] DFA22_eot = DFA.unpackEncodedString(DFA22_eotS);
    static final short[] DFA22_eof = DFA.unpackEncodedString(DFA22_eofS);
    static final char[] DFA22_min = DFA.unpackEncodedStringToUnsignedChars(DFA22_minS);
    static final char[] DFA22_max = DFA.unpackEncodedStringToUnsignedChars(DFA22_maxS);
    static final short[] DFA22_accept = DFA.unpackEncodedString(DFA22_acceptS);
    static final short[] DFA22_special = DFA.unpackEncodedString(DFA22_specialS);
    static final short[][] DFA22_transition;

    static {
        int numStates = DFA22_transitionS.length;
        DFA22_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA22_transition[i] = DFA.unpackEncodedString(DFA22_transitionS[i]);
        }
    }

    class DFA22 extends DFA {

        public DFA22(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 22;
            this.eot = DFA22_eot;
            this.eof = DFA22_eof;
            this.min = DFA22_min;
            this.max = DFA22_max;
            this.accept = DFA22_accept;
            this.special = DFA22_special;
            this.transition = DFA22_transition;
        }
        public String getDescription() {
            return "812:2: ( ( ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_2_0= ruleRealizedVariableCS ) ) ) (otherlv_3= ',' ( ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) ) ) )* otherlv_6= '|' )?";
        }
    }
    static final String DFA24_eotS =
        "\54\uffff";
    static final String DFA24_eofS =
        "\54\uffff";
    static final String DFA24_minS =
        "\1\4\51\0\2\uffff";
    static final String DFA24_maxS =
        "\1\121\51\0\2\uffff";
    static final String DFA24_acceptS =
        "\52\uffff\1\2\1\1";
    static final String DFA24_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1"+
        "\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30"+
        "\1\31\1\32\1\33\1\34\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\44\1\45"+
        "\1\46\1\47\1\50\2\uffff}>";
    static final String[] DFA24_transitionS = {
            "\1\1\1\2\1\20\1\21\6\uffff\1\14\4\uffff\1\7\1\uffff\1\15\1"+
            "\10\1\uffff\1\13\1\5\1\6\1\16\1\47\3\uffff\1\12\1\52\1\uffff"+
            "\1\11\1\uffff\1\3\1\4\1\uffff\1\50\1\51\1\24\14\uffff\1\27\1"+
            "\35\1\36\1\37\1\40\1\41\1\42\1\43\1\44\1\30\1\31\1\32\1\33\1"+
            "\34\1\uffff\1\22\1\23\1\25\1\26\2\uffff\1\46\3\uffff\1\45\1"+
            "\17",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            ""
    };

    static final short[] DFA24_eot = DFA.unpackEncodedString(DFA24_eotS);
    static final short[] DFA24_eof = DFA.unpackEncodedString(DFA24_eofS);
    static final char[] DFA24_min = DFA.unpackEncodedStringToUnsignedChars(DFA24_minS);
    static final char[] DFA24_max = DFA.unpackEncodedStringToUnsignedChars(DFA24_maxS);
    static final short[] DFA24_accept = DFA.unpackEncodedString(DFA24_acceptS);
    static final short[] DFA24_special = DFA.unpackEncodedString(DFA24_specialS);
    static final short[][] DFA24_transition;

    static {
        int numStates = DFA24_transitionS.length;
        DFA24_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA24_transition[i] = DFA.unpackEncodedString(DFA24_transitionS[i]);
        }
    }

    class DFA24 extends DFA {

        public DFA24(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 24;
            this.eot = DFA24_eot;
            this.eof = DFA24_eof;
            this.min = DFA24_min;
            this.max = DFA24_max;
            this.accept = DFA24_accept;
            this.special = DFA24_special;
            this.transition = DFA24_transition;
        }
        public String getDescription() {
            return "1063:1: (this_PredicateCS_0= rulePredicateCS | this_AssignmentCS_1= ruleAssignmentCS )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA24_1 = input.LA(1);

                         
                        int index24_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalQVTcore()) ) {s = 43;}

                        else if ( (true) ) {s = 42;}

                         
                        input.seek(index24_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA24_2 = input.LA(1);

                         
                        int index24_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalQVTcore()) ) {s = 43;}

                        else if ( (true) ) {s = 42;}

                         
                        input.seek(index24_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA24_3 = input.LA(1);

                         
                        int index24_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalQVTcore()) ) {s = 43;}

                        else if ( (true) ) {s = 42;}

                         
                        input.seek(index24_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA24_4 = input.LA(1);

                         
                        int index24_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalQVTcore()) ) {s = 43;}

                        else if ( (true) ) {s = 42;}

                         
                        input.seek(index24_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA24_5 = input.LA(1);

                         
                        int index24_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalQVTcore()) ) {s = 43;}

                        else if ( (true) ) {s = 42;}

                         
                        input.seek(index24_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA24_6 = input.LA(1);

                         
                        int index24_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalQVTcore()) ) {s = 43;}

                        else if ( (true) ) {s = 42;}

                         
                        input.seek(index24_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA24_7 = input.LA(1);

                         
                        int index24_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalQVTcore()) ) {s = 43;}

                        else if ( (true) ) {s = 42;}

                         
                        input.seek(index24_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA24_8 = input.LA(1);

                         
                        int index24_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalQVTcore()) ) {s = 43;}

                        else if ( (true) ) {s = 42;}

                         
                        input.seek(index24_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA24_9 = input.LA(1);

                         
                        int index24_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalQVTcore()) ) {s = 43;}

                        else if ( (true) ) {s = 42;}

                         
                        input.seek(index24_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA24_10 = input.LA(1);

                         
                        int index24_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalQVTcore()) ) {s = 43;}

                        else if ( (true) ) {s = 42;}

                         
                        input.seek(index24_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA24_11 = input.LA(1);

                         
                        int index24_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalQVTcore()) ) {s = 43;}

                        else if ( (true) ) {s = 42;}

                         
                        input.seek(index24_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA24_12 = input.LA(1);

                         
                        int index24_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalQVTcore()) ) {s = 43;}

                        else if ( (true) ) {s = 42;}

                         
                        input.seek(index24_12);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA24_13 = input.LA(1);

                         
                        int index24_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalQVTcore()) ) {s = 43;}

                        else if ( (true) ) {s = 42;}

                         
                        input.seek(index24_13);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA24_14 = input.LA(1);

                         
                        int index24_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalQVTcore()) ) {s = 43;}

                        else if ( (true) ) {s = 42;}

                         
                        input.seek(index24_14);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA24_15 = input.LA(1);

                         
                        int index24_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalQVTcore()) ) {s = 43;}

                        else if ( (true) ) {s = 42;}

                         
                        input.seek(index24_15);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA24_16 = input.LA(1);

                         
                        int index24_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalQVTcore()) ) {s = 43;}

                        else if ( (true) ) {s = 42;}

                         
                        input.seek(index24_16);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA24_17 = input.LA(1);

                         
                        int index24_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalQVTcore()) ) {s = 43;}

                        else if ( (true) ) {s = 42;}

                         
                        input.seek(index24_17);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA24_18 = input.LA(1);

                         
                        int index24_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalQVTcore()) ) {s = 43;}

                        else if ( (true) ) {s = 42;}

                         
                        input.seek(index24_18);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA24_19 = input.LA(1);

                         
                        int index24_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalQVTcore()) ) {s = 43;}

                        else if ( (true) ) {s = 42;}

                         
                        input.seek(index24_19);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA24_20 = input.LA(1);

                         
                        int index24_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalQVTcore()) ) {s = 43;}

                        else if ( (true) ) {s = 42;}

                         
                        input.seek(index24_20);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA24_21 = input.LA(1);

                         
                        int index24_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalQVTcore()) ) {s = 43;}

                        else if ( (true) ) {s = 42;}

                         
                        input.seek(index24_21);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA24_22 = input.LA(1);

                         
                        int index24_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalQVTcore()) ) {s = 43;}

                        else if ( (true) ) {s = 42;}

                         
                        input.seek(index24_22);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA24_23 = input.LA(1);

                         
                        int index24_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalQVTcore()) ) {s = 43;}

                        else if ( (true) ) {s = 42;}

                         
                        input.seek(index24_23);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA24_24 = input.LA(1);

                         
                        int index24_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalQVTcore()) ) {s = 43;}

                        else if ( (true) ) {s = 42;}

                         
                        input.seek(index24_24);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA24_25 = input.LA(1);

                         
                        int index24_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalQVTcore()) ) {s = 43;}

                        else if ( (true) ) {s = 42;}

                         
                        input.seek(index24_25);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA24_26 = input.LA(1);

                         
                        int index24_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalQVTcore()) ) {s = 43;}

                        else if ( (true) ) {s = 42;}

                         
                        input.seek(index24_26);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA24_27 = input.LA(1);

                         
                        int index24_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalQVTcore()) ) {s = 43;}

                        else if ( (true) ) {s = 42;}

                         
                        input.seek(index24_27);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA24_28 = input.LA(1);

                         
                        int index24_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalQVTcore()) ) {s = 43;}

                        else if ( (true) ) {s = 42;}

                         
                        input.seek(index24_28);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA24_29 = input.LA(1);

                         
                        int index24_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalQVTcore()) ) {s = 43;}

                        else if ( (true) ) {s = 42;}

                         
                        input.seek(index24_29);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA24_30 = input.LA(1);

                         
                        int index24_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalQVTcore()) ) {s = 43;}

                        else if ( (true) ) {s = 42;}

                         
                        input.seek(index24_30);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA24_31 = input.LA(1);

                         
                        int index24_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalQVTcore()) ) {s = 43;}

                        else if ( (true) ) {s = 42;}

                         
                        input.seek(index24_31);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA24_32 = input.LA(1);

                         
                        int index24_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalQVTcore()) ) {s = 43;}

                        else if ( (true) ) {s = 42;}

                         
                        input.seek(index24_32);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA24_33 = input.LA(1);

                         
                        int index24_33 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalQVTcore()) ) {s = 43;}

                        else if ( (true) ) {s = 42;}

                         
                        input.seek(index24_33);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA24_34 = input.LA(1);

                         
                        int index24_34 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalQVTcore()) ) {s = 43;}

                        else if ( (true) ) {s = 42;}

                         
                        input.seek(index24_34);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA24_35 = input.LA(1);

                         
                        int index24_35 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalQVTcore()) ) {s = 43;}

                        else if ( (true) ) {s = 42;}

                         
                        input.seek(index24_35);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA24_36 = input.LA(1);

                         
                        int index24_36 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalQVTcore()) ) {s = 43;}

                        else if ( (true) ) {s = 42;}

                         
                        input.seek(index24_36);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA24_37 = input.LA(1);

                         
                        int index24_37 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalQVTcore()) ) {s = 43;}

                        else if ( (true) ) {s = 42;}

                         
                        input.seek(index24_37);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA24_38 = input.LA(1);

                         
                        int index24_38 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalQVTcore()) ) {s = 43;}

                        else if ( (true) ) {s = 42;}

                         
                        input.seek(index24_38);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA24_39 = input.LA(1);

                         
                        int index24_39 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalQVTcore()) ) {s = 43;}

                        else if ( (true) ) {s = 42;}

                         
                        input.seek(index24_39);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA24_40 = input.LA(1);

                         
                        int index24_40 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalQVTcore()) ) {s = 43;}

                        else if ( (true) ) {s = 42;}

                         
                        input.seek(index24_40);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA24_41 = input.LA(1);

                         
                        int index24_41 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalQVTcore()) ) {s = 43;}

                        else if ( (true) ) {s = 42;}

                         
                        input.seek(index24_41);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 24, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA43_eotS =
        "\42\uffff";
    static final String DFA43_eofS =
        "\1\3\41\uffff";
    static final String DFA43_minS =
        "\1\20\1\uffff\1\0\37\uffff";
    static final String DFA43_maxS =
        "\1\117\1\uffff\1\0\37\uffff";
    static final String DFA43_acceptS =
        "\1\uffff\1\1\1\uffff\1\3\35\uffff\1\2";
    static final String DFA43_specialS =
        "\2\uffff\1\0\37\uffff}>";
    static final String[] DFA43_transitionS = {
            "\3\3\1\uffff\1\3\2\uffff\1\3\4\uffff\1\1\3\3\2\uffff\1\3\1"+
            "\uffff\1\3\2\uffff\2\3\1\uffff\3\3\1\2\11\3\16\uffff\1\3\5\uffff"+
            "\1\3\1\uffff\3\3",
            "",
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
            ""
    };

    static final short[] DFA43_eot = DFA.unpackEncodedString(DFA43_eotS);
    static final short[] DFA43_eof = DFA.unpackEncodedString(DFA43_eofS);
    static final char[] DFA43_min = DFA.unpackEncodedStringToUnsignedChars(DFA43_minS);
    static final char[] DFA43_max = DFA.unpackEncodedStringToUnsignedChars(DFA43_maxS);
    static final short[] DFA43_accept = DFA.unpackEncodedString(DFA43_acceptS);
    static final short[] DFA43_special = DFA.unpackEncodedString(DFA43_specialS);
    static final short[][] DFA43_transition;

    static {
        int numStates = DFA43_transitionS.length;
        DFA43_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA43_transition[i] = DFA.unpackEncodedString(DFA43_transitionS[i]);
        }
    }

    class DFA43 extends DFA {

        public DFA43(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 43;
            this.eot = DFA43_eot;
            this.eof = DFA43_eof;
            this.min = DFA43_min;
            this.max = DFA43_max;
            this.accept = DFA43_accept;
            this.special = DFA43_special;
            this.transition = DFA43_transition;
        }
        public String getDescription() {
            return "2410:2: ( (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' ) | (otherlv_4= '<' ( (lv_ownedType_5_0= ruleTypeExpCS ) ) otherlv_6= '>' ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA43_2 = input.LA(1);

                         
                        int index43_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred79_InternalQVTcore()) ) {s = 33;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index43_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 43, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA48_eotS =
        "\42\uffff";
    static final String DFA48_eofS =
        "\1\3\41\uffff";
    static final String DFA48_minS =
        "\1\20\1\uffff\1\0\37\uffff";
    static final String DFA48_maxS =
        "\1\117\1\uffff\1\0\37\uffff";
    static final String DFA48_acceptS =
        "\1\uffff\1\1\1\uffff\1\3\35\uffff\1\2";
    static final String DFA48_specialS =
        "\2\uffff\1\0\37\uffff}>";
    static final String[] DFA48_transitionS = {
            "\3\3\1\uffff\1\3\2\uffff\1\3\4\uffff\1\1\3\3\2\uffff\1\3\1"+
            "\uffff\1\3\2\uffff\2\3\1\uffff\3\3\1\2\11\3\16\uffff\1\3\5\uffff"+
            "\1\3\1\uffff\3\3",
            "",
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
            return "2499:2: ( (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruletuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruletuplePartCS ) ) )* )? otherlv_5= ')' ) | (otherlv_6= '<' ( ( (lv_ownedParts_7_0= ruletuplePartCS ) ) (otherlv_8= ',' ( (lv_ownedParts_9_0= ruletuplePartCS ) ) )* )? otherlv_10= '>' ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA48_2 = input.LA(1);

                         
                        int index48_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred85_InternalQVTcore()) ) {s = 33;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index48_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 48, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA53_eotS =
        "\21\uffff";
    static final String DFA53_eofS =
        "\21\uffff";
    static final String DFA53_minS =
        "\1\4\16\17\2\uffff";
    static final String DFA53_maxS =
        "\1\46\16\20\2\uffff";
    static final String DFA53_acceptS =
        "\17\uffff\1\1\1\2";
    static final String DFA53_specialS =
        "\21\uffff}>";
    static final String[] DFA53_transitionS = {
            "\1\1\1\2\10\uffff\1\14\4\uffff\1\7\1\uffff\1\15\1\10\1\uffff"+
            "\1\13\1\5\1\6\1\16\4\uffff\1\12\2\uffff\1\11\1\uffff\1\3\1\4",
            "\1\17\1\20",
            "\1\17\1\20",
            "\1\17\1\20",
            "\1\17\1\20",
            "\1\17\1\20",
            "\1\17\1\20",
            "\1\17\1\20",
            "\1\17\1\20",
            "\1\17\1\20",
            "\1\17\1\20",
            "\1\17\1\20",
            "\1\17\1\20",
            "\1\17\1\20",
            "\1\17\1\20",
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
            return "2826:2: ( ( ( ( ( ruleUnrestrictedName ) ) otherlv_1= '::' ( ( ( ruleUnreservedName ) ) otherlv_3= '::' )* ) ( ( ruleUnreservedName ) ) ) | ( ( ruleUnrestrictedName ) ) )";
        }
    }
    static final String DFA52_eotS =
        "\37\uffff";
    static final String DFA52_eofS =
        "\37\uffff";
    static final String DFA52_minS =
        "\1\4\34\17\2\uffff";
    static final String DFA52_maxS =
        "\1\104\34\20\2\uffff";
    static final String DFA52_acceptS =
        "\35\uffff\1\1\1\2";
    static final String DFA52_specialS =
        "\37\uffff}>";
    static final String[] DFA52_transitionS = {
            "\1\1\1\2\10\uffff\1\14\4\uffff\1\7\1\uffff\1\15\1\10\1\uffff"+
            "\1\13\1\5\1\6\1\16\4\uffff\1\12\2\uffff\1\11\1\uffff\1\3\1\4"+
            "\20\uffff\1\34\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\17"+
            "\1\20\1\21\1\22\1\23",
            "\1\35\1\36",
            "\1\35\1\36",
            "\1\35\1\36",
            "\1\35\1\36",
            "\1\35\1\36",
            "\1\35\1\36",
            "\1\35\1\36",
            "\1\35\1\36",
            "\1\35\1\36",
            "\1\35\1\36",
            "\1\35\1\36",
            "\1\35\1\36",
            "\1\35\1\36",
            "\1\35\1\36",
            "\1\35\1\36",
            "\1\35\1\36",
            "\1\35\1\36",
            "\1\35\1\36",
            "\1\35\1\36",
            "\1\35\1\36",
            "\1\35\1\36",
            "\1\35\1\36",
            "\1\35\1\36",
            "\1\35\1\36",
            "\1\35\1\36",
            "\1\35\1\36",
            "\1\35\1\36",
            "\1\35\1\36",
            "",
            ""
    };

    static final short[] DFA52_eot = DFA.unpackEncodedString(DFA52_eotS);
    static final short[] DFA52_eof = DFA.unpackEncodedString(DFA52_eofS);
    static final char[] DFA52_min = DFA.unpackEncodedStringToUnsignedChars(DFA52_minS);
    static final char[] DFA52_max = DFA.unpackEncodedStringToUnsignedChars(DFA52_maxS);
    static final short[] DFA52_accept = DFA.unpackEncodedString(DFA52_acceptS);
    static final short[] DFA52_special = DFA.unpackEncodedString(DFA52_specialS);
    static final short[][] DFA52_transition;

    static {
        int numStates = DFA52_transitionS.length;
        DFA52_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA52_transition[i] = DFA.unpackEncodedString(DFA52_transitionS[i]);
        }
    }

    class DFA52 extends DFA {

        public DFA52(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 52;
            this.eot = DFA52_eot;
            this.eof = DFA52_eof;
            this.min = DFA52_min;
            this.max = DFA52_max;
            this.accept = DFA52_accept;
            this.special = DFA52_special;
            this.transition = DFA52_transition;
        }
        public String getDescription() {
            return "()* loopback of 2848:1: ( ( ( ruleUnreservedName ) ) otherlv_3= '::' )*";
        }
    }
    static final String DFA62_eotS =
        "\21\uffff";
    static final String DFA62_eofS =
        "\1\uffff\16\20\2\uffff";
    static final String DFA62_minS =
        "\1\4\16\17\2\uffff";
    static final String DFA62_maxS =
        "\1\46\16\60\2\uffff";
    static final String DFA62_acceptS =
        "\17\uffff\1\1\1\2";
    static final String DFA62_specialS =
        "\21\uffff}>";
    static final String[] DFA62_transitionS = {
            "\1\1\1\2\10\uffff\1\14\4\uffff\1\7\1\uffff\1\15\1\10\1\uffff"+
            "\1\13\1\5\1\6\1\16\4\uffff\1\12\2\uffff\1\11\1\uffff\1\3\1\4",
            "\1\17\2\20\2\uffff\1\20\10\uffff\2\20\15\uffff\1\20\3\uffff"+
            "\1\20",
            "\1\17\2\20\2\uffff\1\20\10\uffff\2\20\15\uffff\1\20\3\uffff"+
            "\1\20",
            "\1\17\2\20\2\uffff\1\20\10\uffff\2\20\15\uffff\1\20\3\uffff"+
            "\1\20",
            "\1\17\2\20\2\uffff\1\20\10\uffff\2\20\15\uffff\1\20\3\uffff"+
            "\1\20",
            "\1\17\2\20\2\uffff\1\20\10\uffff\2\20\15\uffff\1\20\3\uffff"+
            "\1\20",
            "\1\17\2\20\2\uffff\1\20\10\uffff\2\20\15\uffff\1\20\3\uffff"+
            "\1\20",
            "\1\17\2\20\2\uffff\1\20\10\uffff\2\20\15\uffff\1\20\3\uffff"+
            "\1\20",
            "\1\17\2\20\2\uffff\1\20\10\uffff\2\20\15\uffff\1\20\3\uffff"+
            "\1\20",
            "\1\17\2\20\2\uffff\1\20\10\uffff\2\20\15\uffff\1\20\3\uffff"+
            "\1\20",
            "\1\17\2\20\2\uffff\1\20\10\uffff\2\20\15\uffff\1\20\3\uffff"+
            "\1\20",
            "\1\17\2\20\2\uffff\1\20\10\uffff\2\20\15\uffff\1\20\3\uffff"+
            "\1\20",
            "\1\17\2\20\2\uffff\1\20\10\uffff\2\20\15\uffff\1\20\3\uffff"+
            "\1\20",
            "\1\17\2\20\2\uffff\1\20\10\uffff\2\20\15\uffff\1\20\3\uffff"+
            "\1\20",
            "\1\17\2\20\2\uffff\1\20\10\uffff\2\20\15\uffff\1\20\3\uffff"+
            "\1\20",
            "",
            ""
    };

    static final short[] DFA62_eot = DFA.unpackEncodedString(DFA62_eotS);
    static final short[] DFA62_eof = DFA.unpackEncodedString(DFA62_eofS);
    static final char[] DFA62_min = DFA.unpackEncodedStringToUnsignedChars(DFA62_minS);
    static final char[] DFA62_max = DFA.unpackEncodedStringToUnsignedChars(DFA62_maxS);
    static final short[] DFA62_accept = DFA.unpackEncodedString(DFA62_acceptS);
    static final short[] DFA62_special = DFA.unpackEncodedString(DFA62_specialS);
    static final short[][] DFA62_transition;

    static {
        int numStates = DFA62_transitionS.length;
        DFA62_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA62_transition[i] = DFA.unpackEncodedString(DFA62_transitionS[i]);
        }
    }

    class DFA62 extends DFA {

        public DFA62(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 62;
            this.eot = DFA62_eot;
            this.eof = DFA62_eof;
            this.min = DFA62_min;
            this.max = DFA62_max;
            this.accept = DFA62_accept;
            this.special = DFA62_special;
            this.transition = DFA62_transition;
        }
        public String getDescription() {
            return "3621:1: ( ( ( ( ( ruleUnrestrictedName ) ) otherlv_1= '::' ( ( ( ruleUnreservedName ) ) otherlv_3= '::' )* ) ( ( ruleUnreservedName ) ) ) | ( ( ruleUnrestrictedName ) ) )";
        }
    }
    static final String DFA61_eotS =
        "\37\uffff";
    static final String DFA61_eofS =
        "\1\uffff\34\35\2\uffff";
    static final String DFA61_minS =
        "\1\4\34\17\2\uffff";
    static final String DFA61_maxS =
        "\1\104\34\60\2\uffff";
    static final String DFA61_acceptS =
        "\35\uffff\1\2\1\1";
    static final String DFA61_specialS =
        "\37\uffff}>";
    static final String[] DFA61_transitionS = {
            "\1\1\1\2\10\uffff\1\14\4\uffff\1\7\1\uffff\1\15\1\10\1\uffff"+
            "\1\13\1\5\1\6\1\16\4\uffff\1\12\2\uffff\1\11\1\uffff\1\3\1\4"+
            "\20\uffff\1\34\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\17"+
            "\1\20\1\21\1\22\1\23",
            "\1\36\2\35\2\uffff\1\35\10\uffff\2\35\15\uffff\1\35\3\uffff"+
            "\1\35",
            "\1\36\2\35\2\uffff\1\35\10\uffff\2\35\15\uffff\1\35\3\uffff"+
            "\1\35",
            "\1\36\2\35\2\uffff\1\35\10\uffff\2\35\15\uffff\1\35\3\uffff"+
            "\1\35",
            "\1\36\2\35\2\uffff\1\35\10\uffff\2\35\15\uffff\1\35\3\uffff"+
            "\1\35",
            "\1\36\2\35\2\uffff\1\35\10\uffff\2\35\15\uffff\1\35\3\uffff"+
            "\1\35",
            "\1\36\2\35\2\uffff\1\35\10\uffff\2\35\15\uffff\1\35\3\uffff"+
            "\1\35",
            "\1\36\2\35\2\uffff\1\35\10\uffff\2\35\15\uffff\1\35\3\uffff"+
            "\1\35",
            "\1\36\2\35\2\uffff\1\35\10\uffff\2\35\15\uffff\1\35\3\uffff"+
            "\1\35",
            "\1\36\2\35\2\uffff\1\35\10\uffff\2\35\15\uffff\1\35\3\uffff"+
            "\1\35",
            "\1\36\2\35\2\uffff\1\35\10\uffff\2\35\15\uffff\1\35\3\uffff"+
            "\1\35",
            "\1\36\2\35\2\uffff\1\35\10\uffff\2\35\15\uffff\1\35\3\uffff"+
            "\1\35",
            "\1\36\2\35\2\uffff\1\35\10\uffff\2\35\15\uffff\1\35\3\uffff"+
            "\1\35",
            "\1\36\2\35\2\uffff\1\35\10\uffff\2\35\15\uffff\1\35\3\uffff"+
            "\1\35",
            "\1\36\2\35\2\uffff\1\35\10\uffff\2\35\15\uffff\1\35\3\uffff"+
            "\1\35",
            "\1\36\2\35\2\uffff\1\35\10\uffff\2\35\15\uffff\1\35\3\uffff"+
            "\1\35",
            "\1\36\2\35\2\uffff\1\35\10\uffff\2\35\15\uffff\1\35\3\uffff"+
            "\1\35",
            "\1\36\2\35\2\uffff\1\35\10\uffff\2\35\15\uffff\1\35\3\uffff"+
            "\1\35",
            "\1\36\2\35\2\uffff\1\35\10\uffff\2\35\15\uffff\1\35\3\uffff"+
            "\1\35",
            "\1\36\2\35\2\uffff\1\35\10\uffff\2\35\15\uffff\1\35\3\uffff"+
            "\1\35",
            "\1\36\2\35\2\uffff\1\35\10\uffff\2\35\15\uffff\1\35\3\uffff"+
            "\1\35",
            "\1\36\2\35\2\uffff\1\35\10\uffff\2\35\15\uffff\1\35\3\uffff"+
            "\1\35",
            "\1\36\2\35\2\uffff\1\35\10\uffff\2\35\15\uffff\1\35\3\uffff"+
            "\1\35",
            "\1\36\2\35\2\uffff\1\35\10\uffff\2\35\15\uffff\1\35\3\uffff"+
            "\1\35",
            "\1\36\2\35\2\uffff\1\35\10\uffff\2\35\15\uffff\1\35\3\uffff"+
            "\1\35",
            "\1\36\2\35\2\uffff\1\35\10\uffff\2\35\15\uffff\1\35\3\uffff"+
            "\1\35",
            "\1\36\2\35\2\uffff\1\35\10\uffff\2\35\15\uffff\1\35\3\uffff"+
            "\1\35",
            "\1\36\2\35\2\uffff\1\35\10\uffff\2\35\15\uffff\1\35\3\uffff"+
            "\1\35",
            "\1\36\2\35\2\uffff\1\35\10\uffff\2\35\15\uffff\1\35\3\uffff"+
            "\1\35",
            "",
            ""
    };

    static final short[] DFA61_eot = DFA.unpackEncodedString(DFA61_eotS);
    static final short[] DFA61_eof = DFA.unpackEncodedString(DFA61_eofS);
    static final char[] DFA61_min = DFA.unpackEncodedStringToUnsignedChars(DFA61_minS);
    static final char[] DFA61_max = DFA.unpackEncodedStringToUnsignedChars(DFA61_maxS);
    static final short[] DFA61_accept = DFA.unpackEncodedString(DFA61_acceptS);
    static final short[] DFA61_special = DFA.unpackEncodedString(DFA61_specialS);
    static final short[][] DFA61_transition;

    static {
        int numStates = DFA61_transitionS.length;
        DFA61_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA61_transition[i] = DFA.unpackEncodedString(DFA61_transitionS[i]);
        }
    }

    class DFA61 extends DFA {

        public DFA61(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 61;
            this.eot = DFA61_eot;
            this.eof = DFA61_eof;
            this.min = DFA61_min;
            this.max = DFA61_max;
            this.accept = DFA61_accept;
            this.special = DFA61_special;
            this.transition = DFA61_transition;
        }
        public String getDescription() {
            return "()* loopback of 3643:1: ( ( ( ruleUnreservedName ) ) otherlv_3= '::' )*";
        }
    }
    static final String DFA65_eotS =
        "\23\uffff";
    static final String DFA65_eofS =
        "\1\21\22\uffff";
    static final String DFA65_minS =
        "\1\21\20\0\2\uffff";
    static final String DFA65_maxS =
        "\1\117\20\0\2\uffff";
    static final String DFA65_acceptS =
        "\21\uffff\1\2\1\1";
    static final String DFA65_specialS =
        "\1\uffff\1\12\1\16\1\4\1\2\1\5\1\1\1\11\1\17\1\0\1\10\1\6\1\13"+
        "\1\15\1\3\1\7\1\14\2\uffff}>";
    static final String[] DFA65_transitionS = {
            "\2\21\1\uffff\1\21\2\uffff\1\21\5\uffff\3\21\2\uffff\1\21\1"+
            "\uffff\1\17\2\uffff\1\3\1\4\1\uffff\1\1\1\2\1\5\1\6\1\7\1\10"+
            "\1\11\1\12\1\13\1\14\1\15\1\16\1\20\16\uffff\1\21\5\uffff\1"+
            "\21\1\uffff\3\21",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            ""
    };

    static final short[] DFA65_eot = DFA.unpackEncodedString(DFA65_eotS);
    static final short[] DFA65_eof = DFA.unpackEncodedString(DFA65_eofS);
    static final char[] DFA65_min = DFA.unpackEncodedStringToUnsignedChars(DFA65_minS);
    static final char[] DFA65_max = DFA.unpackEncodedStringToUnsignedChars(DFA65_maxS);
    static final short[] DFA65_accept = DFA.unpackEncodedString(DFA65_acceptS);
    static final short[] DFA65_special = DFA.unpackEncodedString(DFA65_specialS);
    static final short[][] DFA65_transition;

    static {
        int numStates = DFA65_transitionS.length;
        DFA65_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA65_transition[i] = DFA.unpackEncodedString(DFA65_transitionS[i]);
        }
    }

    class DFA65 extends DFA {

        public DFA65(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 65;
            this.eot = DFA65_eot;
            this.eof = DFA65_eof;
            this.min = DFA65_min;
            this.max = DFA65_max;
            this.accept = DFA65_accept;
            this.special = DFA65_special;
            this.transition = DFA65_transition;
        }
        public String getDescription() {
            return "3814:1: ( () ( ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) )+ )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA65_9 = input.LA(1);

                         
                        int index65_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred107_InternalQVTcore()) ) {s = 18;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index65_9);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA65_6 = input.LA(1);

                         
                        int index65_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred107_InternalQVTcore()) ) {s = 18;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index65_6);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA65_4 = input.LA(1);

                         
                        int index65_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred107_InternalQVTcore()) ) {s = 18;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index65_4);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA65_14 = input.LA(1);

                         
                        int index65_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred107_InternalQVTcore()) ) {s = 18;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index65_14);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA65_3 = input.LA(1);

                         
                        int index65_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred107_InternalQVTcore()) ) {s = 18;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index65_3);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA65_5 = input.LA(1);

                         
                        int index65_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred107_InternalQVTcore()) ) {s = 18;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index65_5);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA65_11 = input.LA(1);

                         
                        int index65_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred107_InternalQVTcore()) ) {s = 18;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index65_11);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA65_15 = input.LA(1);

                         
                        int index65_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred107_InternalQVTcore()) ) {s = 18;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index65_15);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA65_10 = input.LA(1);

                         
                        int index65_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred107_InternalQVTcore()) ) {s = 18;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index65_10);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA65_7 = input.LA(1);

                         
                        int index65_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred107_InternalQVTcore()) ) {s = 18;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index65_7);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA65_1 = input.LA(1);

                         
                        int index65_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred107_InternalQVTcore()) ) {s = 18;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index65_1);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA65_12 = input.LA(1);

                         
                        int index65_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred107_InternalQVTcore()) ) {s = 18;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index65_12);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA65_16 = input.LA(1);

                         
                        int index65_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred107_InternalQVTcore()) ) {s = 18;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index65_16);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA65_13 = input.LA(1);

                         
                        int index65_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred107_InternalQVTcore()) ) {s = 18;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index65_13);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA65_2 = input.LA(1);

                         
                        int index65_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred107_InternalQVTcore()) ) {s = 18;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index65_2);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA65_8 = input.LA(1);

                         
                        int index65_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred107_InternalQVTcore()) ) {s = 18;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index65_8);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 65, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA64_eotS =
        "\23\uffff";
    static final String DFA64_eofS =
        "\1\1\22\uffff";
    static final String DFA64_minS =
        "\1\21\1\uffff\20\0\1\uffff";
    static final String DFA64_maxS =
        "\1\117\1\uffff\20\0\1\uffff";
    static final String DFA64_acceptS =
        "\1\uffff\1\2\20\uffff\1\1";
    static final String DFA64_specialS =
        "\2\uffff\1\0\1\13\1\16\1\4\1\2\1\5\1\1\1\11\1\17\1\10\1\6\1\12"+
        "\1\15\1\3\1\7\1\14\1\uffff}>";
    static final String[] DFA64_transitionS = {
            "\2\1\1\uffff\1\1\2\uffff\1\1\5\uffff\3\1\2\uffff\1\1\1\uffff"+
            "\1\20\2\uffff\1\5\1\6\1\uffff\1\3\1\4\1\7\1\10\1\11\1\12\1\2"+
            "\1\13\1\14\1\15\1\16\1\17\1\21\16\uffff\1\1\5\uffff\1\1\1\uffff"+
            "\3\1",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            ""
    };

    static final short[] DFA64_eot = DFA.unpackEncodedString(DFA64_eotS);
    static final short[] DFA64_eof = DFA.unpackEncodedString(DFA64_eofS);
    static final char[] DFA64_min = DFA.unpackEncodedStringToUnsignedChars(DFA64_minS);
    static final char[] DFA64_max = DFA.unpackEncodedStringToUnsignedChars(DFA64_maxS);
    static final short[] DFA64_accept = DFA.unpackEncodedString(DFA64_acceptS);
    static final short[] DFA64_special = DFA.unpackEncodedString(DFA64_specialS);
    static final short[][] DFA64_transition;

    static {
        int numStates = DFA64_transitionS.length;
        DFA64_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA64_transition[i] = DFA.unpackEncodedString(DFA64_transitionS[i]);
        }
    }

    class DFA64 extends DFA {

        public DFA64(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 64;
            this.eot = DFA64_eot;
            this.eof = DFA64_eof;
            this.min = DFA64_min;
            this.max = DFA64_max;
            this.accept = DFA64_accept;
            this.special = DFA64_special;
            this.transition = DFA64_transition;
        }
        public String getDescription() {
            return "()+ loopback of 3823:2: ( ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) )+";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA64_2 = input.LA(1);

                         
                        int index64_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred106_InternalQVTcore()) ) {s = 18;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index64_2);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA64_8 = input.LA(1);

                         
                        int index64_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred106_InternalQVTcore()) ) {s = 18;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index64_8);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA64_6 = input.LA(1);

                         
                        int index64_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred106_InternalQVTcore()) ) {s = 18;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index64_6);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA64_15 = input.LA(1);

                         
                        int index64_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred106_InternalQVTcore()) ) {s = 18;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index64_15);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA64_5 = input.LA(1);

                         
                        int index64_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred106_InternalQVTcore()) ) {s = 18;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index64_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA64_7 = input.LA(1);

                         
                        int index64_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred106_InternalQVTcore()) ) {s = 18;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index64_7);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA64_12 = input.LA(1);

                         
                        int index64_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred106_InternalQVTcore()) ) {s = 18;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index64_12);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA64_16 = input.LA(1);

                         
                        int index64_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred106_InternalQVTcore()) ) {s = 18;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index64_16);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA64_11 = input.LA(1);

                         
                        int index64_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred106_InternalQVTcore()) ) {s = 18;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index64_11);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA64_9 = input.LA(1);

                         
                        int index64_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred106_InternalQVTcore()) ) {s = 18;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index64_9);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA64_13 = input.LA(1);

                         
                        int index64_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred106_InternalQVTcore()) ) {s = 18;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index64_13);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA64_3 = input.LA(1);

                         
                        int index64_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred106_InternalQVTcore()) ) {s = 18;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index64_3);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA64_17 = input.LA(1);

                         
                        int index64_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred106_InternalQVTcore()) ) {s = 18;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index64_17);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA64_14 = input.LA(1);

                         
                        int index64_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred106_InternalQVTcore()) ) {s = 18;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index64_14);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA64_4 = input.LA(1);

                         
                        int index64_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred106_InternalQVTcore()) ) {s = 18;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index64_4);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA64_10 = input.LA(1);

                         
                        int index64_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred106_InternalQVTcore()) ) {s = 18;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index64_10);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 64, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA69_eotS =
        "\54\uffff";
    static final String DFA69_eofS =
        "\54\uffff";
    static final String DFA69_minS =
        "\1\4\16\0\10\uffff\6\0\17\uffff";
    static final String DFA69_maxS =
        "\1\121\16\0\10\uffff\6\0\17\uffff";
    static final String DFA69_acceptS =
        "\17\uffff\1\2\1\3\14\uffff\1\7\7\uffff\1\10\1\11\1\12\1\1\1\6\1"+
        "\4\1\5";
    static final String DFA69_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1"+
        "\14\1\15\10\uffff\1\16\1\17\1\20\1\21\1\22\1\23\17\uffff}>";
    static final String[] DFA69_transitionS = {
            "\1\1\1\2\2\20\6\uffff\1\14\4\uffff\1\7\1\uffff\1\15\1\10\1"+
            "\uffff\1\13\1\5\1\6\1\16\1\47\3\uffff\1\12\2\uffff\1\11\1\uffff"+
            "\1\3\1\4\3\uffff\1\20\14\uffff\1\27\10\35\1\30\1\31\1\32\1\33"+
            "\1\34\1\uffff\4\20\2\uffff\1\46\3\uffff\1\45\1\17",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
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
            ""
    };

    static final short[] DFA69_eot = DFA.unpackEncodedString(DFA69_eotS);
    static final short[] DFA69_eof = DFA.unpackEncodedString(DFA69_eofS);
    static final char[] DFA69_min = DFA.unpackEncodedStringToUnsignedChars(DFA69_minS);
    static final char[] DFA69_max = DFA.unpackEncodedStringToUnsignedChars(DFA69_maxS);
    static final short[] DFA69_accept = DFA.unpackEncodedString(DFA69_acceptS);
    static final short[] DFA69_special = DFA.unpackEncodedString(DFA69_specialS);
    static final short[][] DFA69_transition;

    static {
        int numStates = DFA69_transitionS.length;
        DFA69_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA69_transition[i] = DFA.unpackEncodedString(DFA69_transitionS[i]);
        }
    }

    class DFA69 extends DFA {

        public DFA69(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 69;
            this.eot = DFA69_eot;
            this.eof = DFA69_eof;
            this.min = DFA69_min;
            this.max = DFA69_max;
            this.accept = DFA69_accept;
            this.special = DFA69_special;
            this.transition = DFA69_transition;
        }
        public String getDescription() {
            return "4122:1: (this_NavigatingExpCS_0= ruleNavigatingExpCS | this_SelfExpCS_1= ruleSelfExpCS | this_PrimitiveLiteralExpCS_2= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_3= ruleTupleLiteralExpCS | this_CollectionLiteralExpCS_4= ruleCollectionLiteralExpCS | this_ConstructorExpCS_5= ruleConstructorExpCS | this_TypeLiteralExpCS_6= ruleTypeLiteralExpCS | this_LetExpCS_7= ruleLetExpCS | this_IfExpCS_8= ruleIfExpCS | this_NestedExpCS_9= ruleNestedExpCS )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA69_1 = input.LA(1);

                         
                        int index69_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred111_InternalQVTcore()) ) {s = 40;}

                        else if ( (synpred116_InternalQVTcore()) ) {s = 41;}

                         
                        input.seek(index69_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA69_2 = input.LA(1);

                         
                        int index69_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred111_InternalQVTcore()) ) {s = 40;}

                        else if ( (synpred116_InternalQVTcore()) ) {s = 41;}

                         
                        input.seek(index69_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA69_3 = input.LA(1);

                         
                        int index69_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred111_InternalQVTcore()) ) {s = 40;}

                        else if ( (synpred116_InternalQVTcore()) ) {s = 41;}

                         
                        input.seek(index69_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA69_4 = input.LA(1);

                         
                        int index69_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred111_InternalQVTcore()) ) {s = 40;}

                        else if ( (synpred116_InternalQVTcore()) ) {s = 41;}

                         
                        input.seek(index69_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA69_5 = input.LA(1);

                         
                        int index69_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred111_InternalQVTcore()) ) {s = 40;}

                        else if ( (synpred116_InternalQVTcore()) ) {s = 41;}

                         
                        input.seek(index69_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA69_6 = input.LA(1);

                         
                        int index69_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred111_InternalQVTcore()) ) {s = 40;}

                        else if ( (synpred116_InternalQVTcore()) ) {s = 41;}

                         
                        input.seek(index69_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA69_7 = input.LA(1);

                         
                        int index69_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred111_InternalQVTcore()) ) {s = 40;}

                        else if ( (synpred116_InternalQVTcore()) ) {s = 41;}

                         
                        input.seek(index69_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA69_8 = input.LA(1);

                         
                        int index69_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred111_InternalQVTcore()) ) {s = 40;}

                        else if ( (synpred116_InternalQVTcore()) ) {s = 41;}

                         
                        input.seek(index69_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA69_9 = input.LA(1);

                         
                        int index69_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred111_InternalQVTcore()) ) {s = 40;}

                        else if ( (synpred116_InternalQVTcore()) ) {s = 41;}

                         
                        input.seek(index69_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA69_10 = input.LA(1);

                         
                        int index69_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred111_InternalQVTcore()) ) {s = 40;}

                        else if ( (synpred116_InternalQVTcore()) ) {s = 41;}

                         
                        input.seek(index69_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA69_11 = input.LA(1);

                         
                        int index69_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred111_InternalQVTcore()) ) {s = 40;}

                        else if ( (synpred116_InternalQVTcore()) ) {s = 41;}

                         
                        input.seek(index69_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA69_12 = input.LA(1);

                         
                        int index69_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred111_InternalQVTcore()) ) {s = 40;}

                        else if ( (synpred116_InternalQVTcore()) ) {s = 41;}

                         
                        input.seek(index69_12);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA69_13 = input.LA(1);

                         
                        int index69_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred111_InternalQVTcore()) ) {s = 40;}

                        else if ( (synpred116_InternalQVTcore()) ) {s = 41;}

                         
                        input.seek(index69_13);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA69_14 = input.LA(1);

                         
                        int index69_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred111_InternalQVTcore()) ) {s = 40;}

                        else if ( (synpred116_InternalQVTcore()) ) {s = 41;}

                         
                        input.seek(index69_14);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA69_23 = input.LA(1);

                         
                        int index69_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred114_InternalQVTcore()) ) {s = 42;}

                        else if ( (synpred117_InternalQVTcore()) ) {s = 29;}

                         
                        input.seek(index69_23);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA69_24 = input.LA(1);

                         
                        int index69_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred115_InternalQVTcore()) ) {s = 43;}

                        else if ( (synpred117_InternalQVTcore()) ) {s = 29;}

                         
                        input.seek(index69_24);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA69_25 = input.LA(1);

                         
                        int index69_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred115_InternalQVTcore()) ) {s = 43;}

                        else if ( (synpred117_InternalQVTcore()) ) {s = 29;}

                         
                        input.seek(index69_25);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA69_26 = input.LA(1);

                         
                        int index69_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred115_InternalQVTcore()) ) {s = 43;}

                        else if ( (synpred117_InternalQVTcore()) ) {s = 29;}

                         
                        input.seek(index69_26);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA69_27 = input.LA(1);

                         
                        int index69_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred115_InternalQVTcore()) ) {s = 43;}

                        else if ( (synpred117_InternalQVTcore()) ) {s = 29;}

                         
                        input.seek(index69_27);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA69_28 = input.LA(1);

                         
                        int index69_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred115_InternalQVTcore()) ) {s = 43;}

                        else if ( (synpred117_InternalQVTcore()) ) {s = 29;}

                         
                        input.seek(index69_28);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 69, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA71_eotS =
        "\21\uffff";
    static final String DFA71_eofS =
        "\1\uffff\16\20\2\uffff";
    static final String DFA71_minS =
        "\1\4\16\17\2\uffff";
    static final String DFA71_maxS =
        "\1\46\16\117\2\uffff";
    static final String DFA71_acceptS =
        "\17\uffff\1\1\1\2";
    static final String DFA71_specialS =
        "\21\uffff}>";
    static final String[] DFA71_transitionS = {
            "\1\1\1\2\10\uffff\1\14\4\uffff\1\7\1\uffff\1\15\1\10\1\uffff"+
            "\1\13\1\5\1\6\1\16\4\uffff\1\12\2\uffff\1\11\1\uffff\1\3\1\4",
            "\1\17\1\uffff\2\20\1\uffff\1\20\2\uffff\1\20\4\uffff\4\20"+
            "\2\uffff\1\20\1\uffff\1\20\2\uffff\2\20\1\uffff\15\20\16\uffff"+
            "\1\20\4\uffff\2\20\1\uffff\3\20",
            "\1\17\1\uffff\2\20\1\uffff\1\20\2\uffff\1\20\4\uffff\4\20"+
            "\2\uffff\1\20\1\uffff\1\20\2\uffff\2\20\1\uffff\15\20\16\uffff"+
            "\1\20\4\uffff\2\20\1\uffff\3\20",
            "\1\17\1\uffff\2\20\1\uffff\1\20\2\uffff\1\20\4\uffff\4\20"+
            "\2\uffff\1\20\1\uffff\1\20\2\uffff\2\20\1\uffff\15\20\16\uffff"+
            "\1\20\4\uffff\2\20\1\uffff\3\20",
            "\1\17\1\uffff\2\20\1\uffff\1\20\2\uffff\1\20\4\uffff\4\20"+
            "\2\uffff\1\20\1\uffff\1\20\2\uffff\2\20\1\uffff\15\20\16\uffff"+
            "\1\20\4\uffff\2\20\1\uffff\3\20",
            "\1\17\1\uffff\2\20\1\uffff\1\20\2\uffff\1\20\4\uffff\4\20"+
            "\2\uffff\1\20\1\uffff\1\20\2\uffff\2\20\1\uffff\15\20\16\uffff"+
            "\1\20\4\uffff\2\20\1\uffff\3\20",
            "\1\17\1\uffff\2\20\1\uffff\1\20\2\uffff\1\20\4\uffff\4\20"+
            "\2\uffff\1\20\1\uffff\1\20\2\uffff\2\20\1\uffff\15\20\16\uffff"+
            "\1\20\4\uffff\2\20\1\uffff\3\20",
            "\1\17\1\uffff\2\20\1\uffff\1\20\2\uffff\1\20\4\uffff\4\20"+
            "\2\uffff\1\20\1\uffff\1\20\2\uffff\2\20\1\uffff\15\20\16\uffff"+
            "\1\20\4\uffff\2\20\1\uffff\3\20",
            "\1\17\1\uffff\2\20\1\uffff\1\20\2\uffff\1\20\4\uffff\4\20"+
            "\2\uffff\1\20\1\uffff\1\20\2\uffff\2\20\1\uffff\15\20\16\uffff"+
            "\1\20\4\uffff\2\20\1\uffff\3\20",
            "\1\17\1\uffff\2\20\1\uffff\1\20\2\uffff\1\20\4\uffff\4\20"+
            "\2\uffff\1\20\1\uffff\1\20\2\uffff\2\20\1\uffff\15\20\16\uffff"+
            "\1\20\4\uffff\2\20\1\uffff\3\20",
            "\1\17\1\uffff\2\20\1\uffff\1\20\2\uffff\1\20\4\uffff\4\20"+
            "\2\uffff\1\20\1\uffff\1\20\2\uffff\2\20\1\uffff\15\20\16\uffff"+
            "\1\20\4\uffff\2\20\1\uffff\3\20",
            "\1\17\1\uffff\2\20\1\uffff\1\20\2\uffff\1\20\4\uffff\4\20"+
            "\2\uffff\1\20\1\uffff\1\20\2\uffff\2\20\1\uffff\15\20\16\uffff"+
            "\1\20\4\uffff\2\20\1\uffff\3\20",
            "\1\17\1\uffff\2\20\1\uffff\1\20\2\uffff\1\20\4\uffff\4\20"+
            "\2\uffff\1\20\1\uffff\1\20\2\uffff\2\20\1\uffff\15\20\16\uffff"+
            "\1\20\4\uffff\2\20\1\uffff\3\20",
            "\1\17\1\uffff\2\20\1\uffff\1\20\2\uffff\1\20\4\uffff\4\20"+
            "\2\uffff\1\20\1\uffff\1\20\2\uffff\2\20\1\uffff\15\20\16\uffff"+
            "\1\20\4\uffff\2\20\1\uffff\3\20",
            "\1\17\1\uffff\2\20\1\uffff\1\20\2\uffff\1\20\4\uffff\4\20"+
            "\2\uffff\1\20\1\uffff\1\20\2\uffff\2\20\1\uffff\15\20\16\uffff"+
            "\1\20\4\uffff\2\20\1\uffff\3\20",
            "",
            ""
    };

    static final short[] DFA71_eot = DFA.unpackEncodedString(DFA71_eotS);
    static final short[] DFA71_eof = DFA.unpackEncodedString(DFA71_eofS);
    static final char[] DFA71_min = DFA.unpackEncodedStringToUnsignedChars(DFA71_minS);
    static final char[] DFA71_max = DFA.unpackEncodedStringToUnsignedChars(DFA71_maxS);
    static final short[] DFA71_accept = DFA.unpackEncodedString(DFA71_acceptS);
    static final short[] DFA71_special = DFA.unpackEncodedString(DFA71_specialS);
    static final short[][] DFA71_transition;

    static {
        int numStates = DFA71_transitionS.length;
        DFA71_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA71_transition[i] = DFA.unpackEncodedString(DFA71_transitionS[i]);
        }
    }

    class DFA71 extends DFA {

        public DFA71(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 71;
            this.eot = DFA71_eot;
            this.eof = DFA71_eof;
            this.min = DFA71_min;
            this.max = DFA71_max;
            this.accept = DFA71_accept;
            this.special = DFA71_special;
            this.transition = DFA71_transition;
        }
        public String getDescription() {
            return "4272:1: ( ( ( ( ( ruleUnrestrictedName ) ) otherlv_1= '::' ( ( ( ruleUnreservedName ) ) otherlv_3= '::' )* ) ( ( ruleUnreservedName ) ) ) | ( ( ruleUnrestrictedName ) ) )";
        }
    }
    static final String DFA70_eotS =
        "\37\uffff";
    static final String DFA70_eofS =
        "\1\uffff\34\36\2\uffff";
    static final String DFA70_minS =
        "\1\4\34\17\2\uffff";
    static final String DFA70_maxS =
        "\1\104\34\117\2\uffff";
    static final String DFA70_acceptS =
        "\35\uffff\1\1\1\2";
    static final String DFA70_specialS =
        "\37\uffff}>";
    static final String[] DFA70_transitionS = {
            "\1\1\1\2\10\uffff\1\14\4\uffff\1\7\1\uffff\1\15\1\10\1\uffff"+
            "\1\13\1\5\1\6\1\16\4\uffff\1\12\2\uffff\1\11\1\uffff\1\3\1\4"+
            "\20\uffff\1\34\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\17"+
            "\1\20\1\21\1\22\1\23",
            "\1\35\1\uffff\2\36\1\uffff\1\36\2\uffff\1\36\4\uffff\4\36"+
            "\2\uffff\1\36\1\uffff\1\36\2\uffff\2\36\1\uffff\15\36\16\uffff"+
            "\1\36\4\uffff\2\36\1\uffff\3\36",
            "\1\35\1\uffff\2\36\1\uffff\1\36\2\uffff\1\36\4\uffff\4\36"+
            "\2\uffff\1\36\1\uffff\1\36\2\uffff\2\36\1\uffff\15\36\16\uffff"+
            "\1\36\4\uffff\2\36\1\uffff\3\36",
            "\1\35\1\uffff\2\36\1\uffff\1\36\2\uffff\1\36\4\uffff\4\36"+
            "\2\uffff\1\36\1\uffff\1\36\2\uffff\2\36\1\uffff\15\36\16\uffff"+
            "\1\36\4\uffff\2\36\1\uffff\3\36",
            "\1\35\1\uffff\2\36\1\uffff\1\36\2\uffff\1\36\4\uffff\4\36"+
            "\2\uffff\1\36\1\uffff\1\36\2\uffff\2\36\1\uffff\15\36\16\uffff"+
            "\1\36\4\uffff\2\36\1\uffff\3\36",
            "\1\35\1\uffff\2\36\1\uffff\1\36\2\uffff\1\36\4\uffff\4\36"+
            "\2\uffff\1\36\1\uffff\1\36\2\uffff\2\36\1\uffff\15\36\16\uffff"+
            "\1\36\4\uffff\2\36\1\uffff\3\36",
            "\1\35\1\uffff\2\36\1\uffff\1\36\2\uffff\1\36\4\uffff\4\36"+
            "\2\uffff\1\36\1\uffff\1\36\2\uffff\2\36\1\uffff\15\36\16\uffff"+
            "\1\36\4\uffff\2\36\1\uffff\3\36",
            "\1\35\1\uffff\2\36\1\uffff\1\36\2\uffff\1\36\4\uffff\4\36"+
            "\2\uffff\1\36\1\uffff\1\36\2\uffff\2\36\1\uffff\15\36\16\uffff"+
            "\1\36\4\uffff\2\36\1\uffff\3\36",
            "\1\35\1\uffff\2\36\1\uffff\1\36\2\uffff\1\36\4\uffff\4\36"+
            "\2\uffff\1\36\1\uffff\1\36\2\uffff\2\36\1\uffff\15\36\16\uffff"+
            "\1\36\4\uffff\2\36\1\uffff\3\36",
            "\1\35\1\uffff\2\36\1\uffff\1\36\2\uffff\1\36\4\uffff\4\36"+
            "\2\uffff\1\36\1\uffff\1\36\2\uffff\2\36\1\uffff\15\36\16\uffff"+
            "\1\36\4\uffff\2\36\1\uffff\3\36",
            "\1\35\1\uffff\2\36\1\uffff\1\36\2\uffff\1\36\4\uffff\4\36"+
            "\2\uffff\1\36\1\uffff\1\36\2\uffff\2\36\1\uffff\15\36\16\uffff"+
            "\1\36\4\uffff\2\36\1\uffff\3\36",
            "\1\35\1\uffff\2\36\1\uffff\1\36\2\uffff\1\36\4\uffff\4\36"+
            "\2\uffff\1\36\1\uffff\1\36\2\uffff\2\36\1\uffff\15\36\16\uffff"+
            "\1\36\4\uffff\2\36\1\uffff\3\36",
            "\1\35\1\uffff\2\36\1\uffff\1\36\2\uffff\1\36\4\uffff\4\36"+
            "\2\uffff\1\36\1\uffff\1\36\2\uffff\2\36\1\uffff\15\36\16\uffff"+
            "\1\36\4\uffff\2\36\1\uffff\3\36",
            "\1\35\1\uffff\2\36\1\uffff\1\36\2\uffff\1\36\4\uffff\4\36"+
            "\2\uffff\1\36\1\uffff\1\36\2\uffff\2\36\1\uffff\15\36\16\uffff"+
            "\1\36\4\uffff\2\36\1\uffff\3\36",
            "\1\35\1\uffff\2\36\1\uffff\1\36\2\uffff\1\36\4\uffff\4\36"+
            "\2\uffff\1\36\1\uffff\1\36\2\uffff\2\36\1\uffff\15\36\16\uffff"+
            "\1\36\4\uffff\2\36\1\uffff\3\36",
            "\1\35\1\uffff\2\36\1\uffff\1\36\2\uffff\1\36\4\uffff\4\36"+
            "\2\uffff\1\36\1\uffff\1\36\2\uffff\2\36\1\uffff\15\36\16\uffff"+
            "\1\36\4\uffff\2\36\1\uffff\3\36",
            "\1\35\1\uffff\2\36\1\uffff\1\36\2\uffff\1\36\4\uffff\4\36"+
            "\2\uffff\1\36\1\uffff\1\36\2\uffff\2\36\1\uffff\15\36\16\uffff"+
            "\1\36\4\uffff\2\36\1\uffff\3\36",
            "\1\35\1\uffff\2\36\1\uffff\1\36\2\uffff\1\36\4\uffff\4\36"+
            "\2\uffff\1\36\1\uffff\1\36\2\uffff\2\36\1\uffff\15\36\16\uffff"+
            "\1\36\4\uffff\2\36\1\uffff\3\36",
            "\1\35\1\uffff\2\36\1\uffff\1\36\2\uffff\1\36\4\uffff\4\36"+
            "\2\uffff\1\36\1\uffff\1\36\2\uffff\2\36\1\uffff\15\36\16\uffff"+
            "\1\36\4\uffff\2\36\1\uffff\3\36",
            "\1\35\1\uffff\2\36\1\uffff\1\36\2\uffff\1\36\4\uffff\4\36"+
            "\2\uffff\1\36\1\uffff\1\36\2\uffff\2\36\1\uffff\15\36\16\uffff"+
            "\1\36\4\uffff\2\36\1\uffff\3\36",
            "\1\35\1\uffff\2\36\1\uffff\1\36\2\uffff\1\36\4\uffff\4\36"+
            "\2\uffff\1\36\1\uffff\1\36\2\uffff\2\36\1\uffff\15\36\16\uffff"+
            "\1\36\4\uffff\2\36\1\uffff\3\36",
            "\1\35\1\uffff\2\36\1\uffff\1\36\2\uffff\1\36\4\uffff\4\36"+
            "\2\uffff\1\36\1\uffff\1\36\2\uffff\2\36\1\uffff\15\36\16\uffff"+
            "\1\36\4\uffff\2\36\1\uffff\3\36",
            "\1\35\1\uffff\2\36\1\uffff\1\36\2\uffff\1\36\4\uffff\4\36"+
            "\2\uffff\1\36\1\uffff\1\36\2\uffff\2\36\1\uffff\15\36\16\uffff"+
            "\1\36\4\uffff\2\36\1\uffff\3\36",
            "\1\35\1\uffff\2\36\1\uffff\1\36\2\uffff\1\36\4\uffff\4\36"+
            "\2\uffff\1\36\1\uffff\1\36\2\uffff\2\36\1\uffff\15\36\16\uffff"+
            "\1\36\4\uffff\2\36\1\uffff\3\36",
            "\1\35\1\uffff\2\36\1\uffff\1\36\2\uffff\1\36\4\uffff\4\36"+
            "\2\uffff\1\36\1\uffff\1\36\2\uffff\2\36\1\uffff\15\36\16\uffff"+
            "\1\36\4\uffff\2\36\1\uffff\3\36",
            "\1\35\1\uffff\2\36\1\uffff\1\36\2\uffff\1\36\4\uffff\4\36"+
            "\2\uffff\1\36\1\uffff\1\36\2\uffff\2\36\1\uffff\15\36\16\uffff"+
            "\1\36\4\uffff\2\36\1\uffff\3\36",
            "\1\35\1\uffff\2\36\1\uffff\1\36\2\uffff\1\36\4\uffff\4\36"+
            "\2\uffff\1\36\1\uffff\1\36\2\uffff\2\36\1\uffff\15\36\16\uffff"+
            "\1\36\4\uffff\2\36\1\uffff\3\36",
            "\1\35\1\uffff\2\36\1\uffff\1\36\2\uffff\1\36\4\uffff\4\36"+
            "\2\uffff\1\36\1\uffff\1\36\2\uffff\2\36\1\uffff\15\36\16\uffff"+
            "\1\36\4\uffff\2\36\1\uffff\3\36",
            "\1\35\1\uffff\2\36\1\uffff\1\36\2\uffff\1\36\4\uffff\4\36"+
            "\2\uffff\1\36\1\uffff\1\36\2\uffff\2\36\1\uffff\15\36\16\uffff"+
            "\1\36\4\uffff\2\36\1\uffff\3\36",
            "",
            ""
    };

    static final short[] DFA70_eot = DFA.unpackEncodedString(DFA70_eotS);
    static final short[] DFA70_eof = DFA.unpackEncodedString(DFA70_eofS);
    static final char[] DFA70_min = DFA.unpackEncodedStringToUnsignedChars(DFA70_minS);
    static final char[] DFA70_max = DFA.unpackEncodedStringToUnsignedChars(DFA70_maxS);
    static final short[] DFA70_accept = DFA.unpackEncodedString(DFA70_acceptS);
    static final short[] DFA70_special = DFA.unpackEncodedString(DFA70_specialS);
    static final short[][] DFA70_transition;

    static {
        int numStates = DFA70_transitionS.length;
        DFA70_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA70_transition[i] = DFA.unpackEncodedString(DFA70_transitionS[i]);
        }
    }

    class DFA70 extends DFA {

        public DFA70(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 70;
            this.eot = DFA70_eot;
            this.eof = DFA70_eof;
            this.min = DFA70_min;
            this.max = DFA70_max;
            this.accept = DFA70_accept;
            this.special = DFA70_special;
            this.transition = DFA70_transition;
        }
        public String getDescription() {
            return "()* loopback of 4294:1: ( ( ( ruleUnreservedName ) ) otherlv_3= '::' )*";
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleTopLevelCS_in_entryRuleTopLevelCS81 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTopLevelCS91 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMappingCS_in_ruleTopLevelCS137 = new BitSet(new long[]{0x0000000800404002L});
        public static final BitSet FOLLOW_ruleTransformationCS_in_ruleTopLevelCS164 = new BitSet(new long[]{0x0000000800404002L});
        public static final BitSet FOLLOW_ruleQueryCS_in_ruleTopLevelCS191 = new BitSet(new long[]{0x0000000800404002L});
        public static final BitSet FOLLOW_ruleTransformationCS_in_entryRuleTransformationCS228 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTransformationCS238 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleTransformationCS275 = new BitSet(new long[]{0xFF8000690F684030L,0x000000000000001FL});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleTransformationCS303 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleTransformationCS315 = new BitSet(new long[]{0xFF8000690F684030L,0x000000000000001FL});
        public static final BitSet FOLLOW_ruleUnreservedName_in_ruleTransformationCS343 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleTransformationCS355 = new BitSet(new long[]{0xFF8000690F684030L,0x000000000000001FL});
        public static final BitSet FOLLOW_ruleUnreservedName_in_ruleTransformationCS380 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleTransformationCS392 = new BitSet(new long[]{0x000000690F6C4030L});
        public static final BitSet FOLLOW_ruleDirectionCS_in_ruleTransformationCS414 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleTransformationCS426 = new BitSet(new long[]{0x000000690F6C4030L});
        public static final BitSet FOLLOW_18_in_ruleTransformationCS440 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDirectionCS_in_entryRuleDirectionCS476 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDirectionCS486 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleDirectionCS532 = new BitSet(new long[]{0x0000000000280002L});
        public static final BitSet FOLLOW_19_in_ruleDirectionCS545 = new BitSet(new long[]{0x000000690F684030L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleDirectionCS572 = new BitSet(new long[]{0x0000000000300002L});
        public static final BitSet FOLLOW_20_in_ruleDirectionCS585 = new BitSet(new long[]{0x000000690F684030L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleDirectionCS612 = new BitSet(new long[]{0x0000000000300002L});
        public static final BitSet FOLLOW_21_in_ruleDirectionCS629 = new BitSet(new long[]{0x000000690F684030L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleDirectionCS656 = new BitSet(new long[]{0x0000000000100002L});
        public static final BitSet FOLLOW_20_in_ruleDirectionCS669 = new BitSet(new long[]{0x000000690F684030L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleDirectionCS696 = new BitSet(new long[]{0x0000000000100002L});
        public static final BitSet FOLLOW_ruleMappingCS_in_entryRuleMappingCS736 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMappingCS746 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleMappingCS783 = new BitSet(new long[]{0x000000690F684030L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleMappingCS804 = new BitSet(new long[]{0x0000000001810000L});
        public static final BitSet FOLLOW_23_in_ruleMappingCS817 = new BitSet(new long[]{0x000000690F684030L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleMappingCS844 = new BitSet(new long[]{0x0000000001010000L});
        public static final BitSet FOLLOW_24_in_ruleMappingCS859 = new BitSet(new long[]{0x000000690F684030L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleMappingCS886 = new BitSet(new long[]{0x0000000000110000L});
        public static final BitSet FOLLOW_20_in_ruleMappingCS899 = new BitSet(new long[]{0x000000690F684030L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleMappingCS926 = new BitSet(new long[]{0x0000000000110000L});
        public static final BitSet FOLLOW_16_in_ruleMappingCS942 = new BitSet(new long[]{0x000000690F684030L});
        public static final BitSet FOLLOW_25_in_ruleMappingCS956 = new BitSet(new long[]{0x000000690F684030L});
        public static final BitSet FOLLOW_26_in_ruleMappingCS971 = new BitSet(new long[]{0x000000690F684030L});
        public static final BitSet FOLLOW_ruleDirectionNameCS_in_ruleMappingCS992 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_ruleDomainCS_in_ruleMappingCS1012 = new BitSet(new long[]{0x000000690F684030L});
        public static final BitSet FOLLOW_27_in_ruleMappingCS1026 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_ruleDomainCS_in_ruleMappingCS1047 = new BitSet(new long[]{0x0000000000440000L});
        public static final BitSet FOLLOW_ruleComposedMappingCS_in_ruleMappingCS1068 = new BitSet(new long[]{0x0000000000440000L});
        public static final BitSet FOLLOW_18_in_ruleMappingCS1081 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDomainCS_in_entryRuleDomainCS1117 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDomainCS1127 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_ruleDomainCS1164 = new BitSet(new long[]{0xFF80076B3F6840F0L,0x00000000000313DFL});
        public static final BitSet FOLLOW_ruleGuardPatternCS_in_ruleDomainCS1185 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_29_in_ruleDomainCS1197 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleDomainCS1209 = new BitSet(new long[]{0xFF80076B1F6C40F0L,0x00000000000313DFL});
        public static final BitSet FOLLOW_ruleBottomPatternCS_in_ruleDomainCS1230 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleDomainCS1242 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleComposedMappingCS_in_entryRuleComposedMappingCS1278 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleComposedMappingCS1288 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMappingCS_in_ruleComposedMappingCS1337 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGuardPatternCS_in_entryRuleGuardPatternCS1371 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleGuardPatternCS1381 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrealizedVariableCS_in_ruleGuardPatternCS1440 = new BitSet(new long[]{0x0000000040100000L});
        public static final BitSet FOLLOW_20_in_ruleGuardPatternCS1453 = new BitSet(new long[]{0x000000690F684030L});
        public static final BitSet FOLLOW_ruleUnrealizedVariableCS_in_ruleGuardPatternCS1474 = new BitSet(new long[]{0x0000000040100000L});
        public static final BitSet FOLLOW_30_in_ruleGuardPatternCS1488 = new BitSet(new long[]{0xFF80076B1F6840F2L,0x00000000000313DFL});
        public static final BitSet FOLLOW_ruleConstraintCS_in_ruleGuardPatternCS1512 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleGuardPatternCS1524 = new BitSet(new long[]{0xFF80076B1F6840F2L,0x00000000000313DFL});
        public static final BitSet FOLLOW_ruleBottomPatternCS_in_entryRuleBottomPatternCS1562 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBottomPatternCS1572 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrealizedVariableCS_in_ruleBottomPatternCS1632 = new BitSet(new long[]{0x0000000040100000L});
        public static final BitSet FOLLOW_ruleRealizedVariableCS_in_ruleBottomPatternCS1659 = new BitSet(new long[]{0x0000000040100000L});
        public static final BitSet FOLLOW_20_in_ruleBottomPatternCS1673 = new BitSet(new long[]{0x000000690F684030L});
        public static final BitSet FOLLOW_ruleUnrealizedVariableCS_in_ruleBottomPatternCS1695 = new BitSet(new long[]{0x0000000040100000L});
        public static final BitSet FOLLOW_ruleRealizedVariableCS_in_ruleBottomPatternCS1722 = new BitSet(new long[]{0x0000000040100000L});
        public static final BitSet FOLLOW_30_in_ruleBottomPatternCS1737 = new BitSet(new long[]{0xFF80076B1F6840F2L,0x00000000000313DFL});
        public static final BitSet FOLLOW_ruleConstraintCS_in_ruleBottomPatternCS1761 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleBottomPatternCS1773 = new BitSet(new long[]{0xFF80076B1F6840F2L,0x00000000000313DFL});
        public static final BitSet FOLLOW_ruleUnrealizedVariableCS_in_entryRuleUnrealizedVariableCS1811 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnrealizedVariableCS1821 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVariableNameCS_in_ruleUnrealizedVariableCS1867 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_31_in_ruleUnrealizedVariableCS1879 = new BitSet(new long[]{0xFF8000690F684030L,0x000000000000001FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleUnrealizedVariableCS1900 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRealizedVariableCS_in_entryRuleRealizedVariableCS1936 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRealizedVariableCS1946 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_ruleRealizedVariableCS1983 = new BitSet(new long[]{0x000000690F684030L});
        public static final BitSet FOLLOW_ruleVariableNameCS_in_ruleRealizedVariableCS2004 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_31_in_ruleRealizedVariableCS2016 = new BitSet(new long[]{0xFF8000690F684030L,0x000000000000001FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleRealizedVariableCS2037 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConstraintCS_in_entryRuleConstraintCS2073 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleConstraintCS2083 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePredicateCS_in_ruleConstraintCS2133 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignmentCS_in_ruleConstraintCS2163 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePredicateCS_in_entryRulePredicateCS2198 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePredicateCS2208 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpCS_in_rulePredicateCS2257 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignmentCS_in_entryRuleAssignmentCS2291 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAssignmentCS2301 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_ruleAssignmentCS2344 = new BitSet(new long[]{0xFF8007691F6840F0L,0x00000000000313DFL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleAssignmentCS2379 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_34_in_ruleAssignmentCS2391 = new BitSet(new long[]{0xFF8007691F6840F0L,0x00000000000313DFL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleAssignmentCS2412 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDirectionNameCS_in_entryRuleDirectionNameCS2449 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDirectionNameCS2460 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleDirectionNameCS2506 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVariableNameCS_in_entryRuleVariableNameCS2553 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleVariableNameCS2564 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleVariableNameCS2610 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQueryCS_in_entryRuleQueryCS2654 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleQueryCS2664 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_ruleQueryCS2701 = new BitSet(new long[]{0x000000690F684030L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleQueryCS2722 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_28_in_ruleQueryCS2734 = new BitSet(new long[]{0x000000692F684030L});
        public static final BitSet FOLLOW_ruleParamDeclarationCS_in_ruleQueryCS2756 = new BitSet(new long[]{0x0000000020100000L});
        public static final BitSet FOLLOW_20_in_ruleQueryCS2769 = new BitSet(new long[]{0x000000690F684030L});
        public static final BitSet FOLLOW_ruleParamDeclarationCS_in_ruleQueryCS2790 = new BitSet(new long[]{0x0000000020100000L});
        public static final BitSet FOLLOW_29_in_ruleQueryCS2806 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_31_in_ruleQueryCS2818 = new BitSet(new long[]{0xFF8000690F684030L,0x000000000000001FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleQueryCS2839 = new BitSet(new long[]{0x0000000000030000L});
        public static final BitSet FOLLOW_17_in_ruleQueryCS2852 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleQueryCS2871 = new BitSet(new long[]{0xFF8007691F6840F0L,0x00000000000313DFL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleQueryCS2892 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleQueryCS2904 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParamDeclarationCS_in_entryRuleParamDeclarationCS2942 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParamDeclarationCS2952 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleParamDeclarationCS2998 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_31_in_ruleParamDeclarationCS3010 = new BitSet(new long[]{0xFF8000690F684030L,0x000000000000001FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleParamDeclarationCS3031 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_entryRuleUnrestrictedName3068 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnrestrictedName3079 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLUnrestrictedName_in_ruleUnrestrictedName3126 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_ruleUnrestrictedName3150 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_ruleUnrestrictedName3169 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleUnrestrictedName3188 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleUnrestrictedName3207 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_ruleUnrestrictedName3226 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_ruleUnrestrictedName3245 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_ruleUnrestrictedName3264 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleUnrestrictedName3283 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_ruleUnrestrictedName3302 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_ruleUnrestrictedName3321 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleID_in_entryRuleID3364 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleID3375 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_SIMPLE_ID_in_ruleID3415 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ESCAPED_ID_in_ruleID3441 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNUMBER_LITERAL_in_entryRuleNUMBER_LITERAL3487 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNUMBER_LITERAL3498 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleNUMBER_LITERAL3538 = new BitSet(new long[]{0x0000007000000002L});
        public static final BitSet FOLLOW_36_in_ruleNUMBER_LITERAL3557 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleNUMBER_LITERAL3572 = new BitSet(new long[]{0x0000006000000002L});
        public static final BitSet FOLLOW_37_in_ruleNUMBER_LITERAL3594 = new BitSet(new long[]{0x0000018000000040L});
        public static final BitSet FOLLOW_38_in_ruleNUMBER_LITERAL3613 = new BitSet(new long[]{0x0000018000000040L});
        public static final BitSet FOLLOW_39_in_ruleNUMBER_LITERAL3628 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_40_in_ruleNUMBER_LITERAL3647 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleNUMBER_LITERAL3664 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLUnrestrictedIdentifier_in_entryRuleEssentialOCLUnrestrictedIdentifier3716 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEssentialOCLUnrestrictedIdentifier3727 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_ruleEssentialOCLUnrestrictedIdentifier3765 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_ruleEssentialOCLUnrestrictedIdentifier3784 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLPrefixOperator_in_entryRuleEssentialOCLPrefixOperator3825 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEssentialOCLPrefixOperator3836 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_40_in_ruleEssentialOCLPrefixOperator3874 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_41_in_ruleEssentialOCLPrefixOperator3893 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLInfixOperator_in_entryRuleEssentialOCLInfixOperator3934 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEssentialOCLInfixOperator3945 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_42_in_ruleEssentialOCLInfixOperator3983 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_43_in_ruleEssentialOCLInfixOperator4002 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_39_in_ruleEssentialOCLInfixOperator4021 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_40_in_ruleEssentialOCLInfixOperator4040 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_44_in_ruleEssentialOCLInfixOperator4059 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_45_in_ruleEssentialOCLInfixOperator4078 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_46_in_ruleEssentialOCLInfixOperator4097 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_47_in_ruleEssentialOCLInfixOperator4116 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_48_in_ruleEssentialOCLInfixOperator4135 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_49_in_ruleEssentialOCLInfixOperator4154 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_50_in_ruleEssentialOCLInfixOperator4173 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_51_in_ruleEssentialOCLInfixOperator4192 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_52_in_ruleEssentialOCLInfixOperator4211 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_53_in_ruleEssentialOCLInfixOperator4230 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLNavigationOperator_in_entryRuleEssentialOCLNavigationOperator4271 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEssentialOCLNavigationOperator4282 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_ruleEssentialOCLNavigationOperator4320 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_54_in_ruleEssentialOCLNavigationOperator4339 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_entryRuleIdentifier4380 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIdentifier4391 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleID_in_ruleIdentifier4438 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLUnrestrictedIdentifier_in_ruleIdentifier4471 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral4517 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteral4528 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_SINGLE_QUOTED_STRING_in_ruleStringLiteral4567 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrefixOperator_in_entryRulePrefixOperator4612 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrefixOperator4623 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLPrefixOperator_in_rulePrefixOperator4669 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInfixOperator_in_entryRuleInfixOperator4714 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleInfixOperator4725 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLInfixOperator_in_ruleInfixOperator4771 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigationOperator_in_entryRuleNavigationOperator4816 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigationOperator4827 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLNavigationOperator_in_ruleNavigationOperator4873 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLUnrestrictedName_in_entryRuleEssentialOCLUnrestrictedName4918 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEssentialOCLUnrestrictedName4929 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_ruleEssentialOCLUnrestrictedName4975 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLUnreservedName_in_entryRuleEssentialOCLUnreservedName5020 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEssentialOCLUnreservedName5031 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleEssentialOCLUnreservedName5078 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionTypeIdentifier_in_ruleEssentialOCLUnreservedName5111 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveTypeIdentifier_in_ruleEssentialOCLUnreservedName5144 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_55_in_ruleEssentialOCLUnreservedName5168 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnreservedName_in_entryRuleUnreservedName5209 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnreservedName5220 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLUnreservedName_in_ruleUnreservedName5266 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveTypeIdentifier_in_entryRulePrimitiveTypeIdentifier5311 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrimitiveTypeIdentifier5322 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_56_in_rulePrimitiveTypeIdentifier5360 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_57_in_rulePrimitiveTypeIdentifier5379 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_58_in_rulePrimitiveTypeIdentifier5398 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_59_in_rulePrimitiveTypeIdentifier5417 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_60_in_rulePrimitiveTypeIdentifier5436 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_61_in_rulePrimitiveTypeIdentifier5455 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_62_in_rulePrimitiveTypeIdentifier5474 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_63_in_rulePrimitiveTypeIdentifier5493 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveTypeCS_in_entryRulePrimitiveTypeCS5533 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrimitiveTypeCS5543 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveTypeIdentifier_in_rulePrimitiveTypeCS5588 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionTypeIdentifier_in_entryRuleCollectionTypeIdentifier5624 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCollectionTypeIdentifier5635 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_64_in_ruleCollectionTypeIdentifier5673 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_65_in_ruleCollectionTypeIdentifier5692 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_66_in_ruleCollectionTypeIdentifier5711 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_67_in_ruleCollectionTypeIdentifier5730 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_68_in_ruleCollectionTypeIdentifier5749 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionTypeCS_in_entryRuleCollectionTypeCS5789 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCollectionTypeCS5799 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionTypeIdentifier_in_ruleCollectionTypeCS5845 = new BitSet(new long[]{0x0000200010000002L});
        public static final BitSet FOLLOW_28_in_ruleCollectionTypeCS5859 = new BitSet(new long[]{0xFF8000690F684030L,0x000000000000001FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleCollectionTypeCS5880 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_29_in_ruleCollectionTypeCS5892 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_45_in_ruleCollectionTypeCS5912 = new BitSet(new long[]{0xFF8000690F684030L,0x000000000000001FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleCollectionTypeCS5933 = new BitSet(new long[]{0x0000100000000000L});
        public static final BitSet FOLLOW_44_in_ruleCollectionTypeCS5945 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTupleTypeCS_in_entryRuleTupleTypeCS5984 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTupleTypeCS5994 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_55_in_ruleTupleTypeCS6037 = new BitSet(new long[]{0x0000200010000002L});
        public static final BitSet FOLLOW_28_in_ruleTupleTypeCS6064 = new BitSet(new long[]{0x000000692F684030L});
        public static final BitSet FOLLOW_ruletuplePartCS_in_ruleTupleTypeCS6086 = new BitSet(new long[]{0x0000000020100000L});
        public static final BitSet FOLLOW_20_in_ruleTupleTypeCS6099 = new BitSet(new long[]{0x000000690F684030L});
        public static final BitSet FOLLOW_ruletuplePartCS_in_ruleTupleTypeCS6120 = new BitSet(new long[]{0x0000000020100000L});
        public static final BitSet FOLLOW_29_in_ruleTupleTypeCS6136 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_45_in_ruleTupleTypeCS6156 = new BitSet(new long[]{0x000010690F684030L});
        public static final BitSet FOLLOW_ruletuplePartCS_in_ruleTupleTypeCS6178 = new BitSet(new long[]{0x0000100000100000L});
        public static final BitSet FOLLOW_20_in_ruleTupleTypeCS6191 = new BitSet(new long[]{0x000000690F684030L});
        public static final BitSet FOLLOW_ruletuplePartCS_in_ruleTupleTypeCS6212 = new BitSet(new long[]{0x0000100000100000L});
        public static final BitSet FOLLOW_44_in_ruleTupleTypeCS6228 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruletuplePartCS_in_entryRuletuplePartCS6267 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuletuplePartCS6277 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruletuplePartCS6323 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_31_in_ruletuplePartCS6335 = new BitSet(new long[]{0xFF8000690F684030L,0x000000000000001FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruletuplePartCS6356 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionLiteralExpCS_in_entryRuleCollectionLiteralExpCS6392 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCollectionLiteralExpCS6402 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionTypeCS_in_ruleCollectionLiteralExpCS6448 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleCollectionLiteralExpCS6460 = new BitSet(new long[]{0xFF8007691F6C40F0L,0x00000000000313DFL});
        public static final BitSet FOLLOW_ruleCollectionLiteralPartCS_in_ruleCollectionLiteralExpCS6482 = new BitSet(new long[]{0x0000000000140000L});
        public static final BitSet FOLLOW_20_in_ruleCollectionLiteralExpCS6495 = new BitSet(new long[]{0xFF8007691F6840F0L,0x00000000000313DFL});
        public static final BitSet FOLLOW_ruleCollectionLiteralPartCS_in_ruleCollectionLiteralExpCS6516 = new BitSet(new long[]{0x0000000000140000L});
        public static final BitSet FOLLOW_18_in_ruleCollectionLiteralExpCS6532 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionLiteralPartCS_in_entryRuleCollectionLiteralPartCS6568 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCollectionLiteralPartCS6578 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleCollectionLiteralPartCS6624 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000020L});
        public static final BitSet FOLLOW_69_in_ruleCollectionLiteralPartCS6637 = new BitSet(new long[]{0xFF8007691F6840F0L,0x00000000000313DFL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleCollectionLiteralPartCS6658 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConstructorExpCS_in_entryRuleConstructorExpCS6696 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleConstructorExpCS6706 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleConstructorExpCS6761 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleConstructorExpCS6773 = new BitSet(new long[]{0xFF8000690F684030L,0x000000000000001FL});
        public static final BitSet FOLLOW_ruleUnreservedName_in_ruleConstructorExpCS6801 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleConstructorExpCS6813 = new BitSet(new long[]{0xFF8000690F684030L,0x000000000000001FL});
        public static final BitSet FOLLOW_ruleUnreservedName_in_ruleConstructorExpCS6843 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleConstructorExpCS6877 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleConstructorExpCS6890 = new BitSet(new long[]{0x000000690F684030L});
        public static final BitSet FOLLOW_ruleConstructorPartCS_in_ruleConstructorExpCS6911 = new BitSet(new long[]{0x0000000000140000L});
        public static final BitSet FOLLOW_20_in_ruleConstructorExpCS6924 = new BitSet(new long[]{0x000000690F684030L});
        public static final BitSet FOLLOW_ruleConstructorPartCS_in_ruleConstructorExpCS6945 = new BitSet(new long[]{0x0000000000140000L});
        public static final BitSet FOLLOW_18_in_ruleConstructorExpCS6959 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConstructorPartCS_in_entryRuleConstructorPartCS6995 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleConstructorPartCS7005 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleConstructorPartCS7057 = new BitSet(new long[]{0x0001000000000000L});
        public static final BitSet FOLLOW_48_in_ruleConstructorPartCS7069 = new BitSet(new long[]{0xFF8007691F6840F0L,0x00000000000313DFL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleConstructorPartCS7090 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveLiteralExpCS_in_entryRulePrimitiveLiteralExpCS7126 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrimitiveLiteralExpCS7136 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNumberLiteralExpCS_in_rulePrimitiveLiteralExpCS7186 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringLiteralExpCS_in_rulePrimitiveLiteralExpCS7216 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBooleanLiteralExpCS_in_rulePrimitiveLiteralExpCS7246 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnlimitedNaturalLiteralExpCS_in_rulePrimitiveLiteralExpCS7276 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInvalidLiteralExpCS_in_rulePrimitiveLiteralExpCS7306 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNullLiteralExpCS_in_rulePrimitiveLiteralExpCS7336 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTupleLiteralExpCS_in_entryRuleTupleLiteralExpCS7371 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTupleLiteralExpCS7381 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_55_in_ruleTupleLiteralExpCS7418 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleTupleLiteralExpCS7430 = new BitSet(new long[]{0x000000690F684030L});
        public static final BitSet FOLLOW_ruleTupleLiteralPartCS_in_ruleTupleLiteralExpCS7451 = new BitSet(new long[]{0x0000000000140000L});
        public static final BitSet FOLLOW_20_in_ruleTupleLiteralExpCS7464 = new BitSet(new long[]{0x000000690F684030L});
        public static final BitSet FOLLOW_ruleTupleLiteralPartCS_in_ruleTupleLiteralExpCS7485 = new BitSet(new long[]{0x0000000000140000L});
        public static final BitSet FOLLOW_18_in_ruleTupleLiteralExpCS7499 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTupleLiteralPartCS_in_entryRuleTupleLiteralPartCS7535 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTupleLiteralPartCS7545 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleTupleLiteralPartCS7591 = new BitSet(new long[]{0x0001000080000000L});
        public static final BitSet FOLLOW_31_in_ruleTupleLiteralPartCS7604 = new BitSet(new long[]{0xFF8000690F684030L,0x000000000000001FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleTupleLiteralPartCS7625 = new BitSet(new long[]{0x0001000000000000L});
        public static final BitSet FOLLOW_48_in_ruleTupleLiteralPartCS7639 = new BitSet(new long[]{0xFF8007691F6840F0L,0x00000000000313DFL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleTupleLiteralPartCS7660 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNumberLiteralExpCS_in_entryRuleNumberLiteralExpCS7696 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNumberLiteralExpCS7706 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNUMBER_LITERAL_in_ruleNumberLiteralExpCS7751 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringLiteralExpCS_in_entryRuleStringLiteralExpCS7786 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteralExpCS7796 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringLiteral_in_ruleStringLiteralExpCS7841 = new BitSet(new long[]{0x0000000000000082L});
        public static final BitSet FOLLOW_ruleBooleanLiteralExpCS_in_entryRuleBooleanLiteralExpCS7877 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBooleanLiteralExpCS7887 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_70_in_ruleBooleanLiteralExpCS7930 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_71_in_ruleBooleanLiteralExpCS7967 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnlimitedNaturalLiteralExpCS_in_entryRuleUnlimitedNaturalLiteralExpCS8016 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnlimitedNaturalLiteralExpCS8026 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_42_in_ruleUnlimitedNaturalLiteralExpCS8075 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInvalidLiteralExpCS_in_entryRuleInvalidLiteralExpCS8111 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleInvalidLiteralExpCS8121 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_72_in_ruleInvalidLiteralExpCS8170 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNullLiteralExpCS_in_entryRuleNullLiteralExpCS8206 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNullLiteralExpCS8216 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_73_in_ruleNullLiteralExpCS8265 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralCS_in_entryRuleTypeLiteralCS8301 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeLiteralCS8311 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveTypeCS_in_ruleTypeLiteralCS8361 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionTypeCS_in_ruleTypeLiteralCS8391 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTupleTypeCS_in_ruleTypeLiteralCS8421 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralExpCS_in_entryRuleTypeLiteralExpCS8456 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeLiteralExpCS8466 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralCS_in_ruleTypeLiteralExpCS8511 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeNameExpCS_in_entryRuleTypeNameExpCS8546 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeNameExpCS8556 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleTypeNameExpCS8610 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleTypeNameExpCS8622 = new BitSet(new long[]{0xFF8000690F684030L,0x000000000000001FL});
        public static final BitSet FOLLOW_ruleUnreservedName_in_ruleTypeNameExpCS8650 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleTypeNameExpCS8662 = new BitSet(new long[]{0xFF8000690F684030L,0x000000000000001FL});
        public static final BitSet FOLLOW_ruleUnreservedName_in_ruleTypeNameExpCS8692 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleTypeNameExpCS8726 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_entryRuleTypeExpCS8762 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeExpCS8772 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeNameExpCS_in_ruleTypeExpCS8822 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralCS_in_ruleTypeExpCS8852 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpCS_in_entryRuleExpCS8887 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleExpCS8897 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInfixedExpCS_in_ruleExpCS8946 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInfixedExpCS_in_entryRuleInfixedExpCS8980 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleInfixedExpCS8990 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrefixedExpCS_in_ruleInfixedExpCS9040 = new BitSet(new long[]{0x007FFD9000000002L});
        public static final BitSet FOLLOW_ruleBinaryOperatorCS_in_ruleInfixedExpCS9074 = new BitSet(new long[]{0xFF8007691F6840F0L,0x00000000000313DFL});
        public static final BitSet FOLLOW_rulePrefixedExpCS_in_ruleInfixedExpCS9095 = new BitSet(new long[]{0x007FFD9000000002L});
        public static final BitSet FOLLOW_ruleBinaryOperatorCS_in_entryRuleBinaryOperatorCS9135 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBinaryOperatorCS9145 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInfixOperatorCS_in_ruleBinaryOperatorCS9195 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigationOperatorCS_in_ruleBinaryOperatorCS9225 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInfixOperatorCS_in_entryRuleInfixOperatorCS9260 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleInfixOperatorCS9270 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInfixOperator_in_ruleInfixOperatorCS9315 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigationOperatorCS_in_entryRuleNavigationOperatorCS9350 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigationOperatorCS9360 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigationOperator_in_ruleNavigationOperatorCS9405 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrefixedExpCS_in_entryRulePrefixedExpCS9440 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrefixedExpCS9450 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimaryExpCS_in_rulePrefixedExpCS9500 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnaryOperatorCS_in_rulePrefixedExpCS9539 = new BitSet(new long[]{0xFF8007691F6840F0L,0x00000000000313DFL});
        public static final BitSet FOLLOW_rulePrimaryExpCS_in_rulePrefixedExpCS9561 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnaryOperatorCS_in_entryRuleUnaryOperatorCS9598 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnaryOperatorCS9608 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrefixOperator_in_ruleUnaryOperatorCS9653 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimaryExpCS_in_entryRulePrimaryExpCS9688 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpCS9698 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingExpCS_in_rulePrimaryExpCS9748 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSelfExpCS_in_rulePrimaryExpCS9778 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveLiteralExpCS_in_rulePrimaryExpCS9808 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTupleLiteralExpCS_in_rulePrimaryExpCS9838 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionLiteralExpCS_in_rulePrimaryExpCS9868 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConstructorExpCS_in_rulePrimaryExpCS9898 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralExpCS_in_rulePrimaryExpCS9928 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLetExpCS_in_rulePrimaryExpCS9958 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIfExpCS_in_rulePrimaryExpCS9988 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedExpCS_in_rulePrimaryExpCS10018 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNameExpCS_in_entryRuleNameExpCS10053 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNameExpCS10063 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleNameExpCS10117 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleNameExpCS10129 = new BitSet(new long[]{0xFF8000690F684030L,0x000000000000001FL});
        public static final BitSet FOLLOW_ruleUnreservedName_in_ruleNameExpCS10157 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleNameExpCS10169 = new BitSet(new long[]{0xFF8000690F684030L,0x000000000000001FL});
        public static final BitSet FOLLOW_ruleUnreservedName_in_ruleNameExpCS10199 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleNameExpCS10233 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIndexExpCS_in_entryRuleIndexExpCS10269 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIndexExpCS10279 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNameExpCS_in_ruleIndexExpCS10329 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000400L});
        public static final BitSet FOLLOW_74_in_ruleIndexExpCS10353 = new BitSet(new long[]{0xFF8007691F6840F0L,0x00000000000313DFL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleIndexExpCS10374 = new BitSet(new long[]{0x0000000000100000L,0x0000000000000800L});
        public static final BitSet FOLLOW_20_in_ruleIndexExpCS10387 = new BitSet(new long[]{0xFF8007691F6840F0L,0x00000000000313DFL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleIndexExpCS10408 = new BitSet(new long[]{0x0000000000100000L,0x0000000000000800L});
        public static final BitSet FOLLOW_75_in_ruleIndexExpCS10422 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000400L});
        public static final BitSet FOLLOW_74_in_ruleIndexExpCS10435 = new BitSet(new long[]{0xFF8007691F6840F0L,0x00000000000313DFL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleIndexExpCS10456 = new BitSet(new long[]{0x0000000000100000L,0x0000000000000800L});
        public static final BitSet FOLLOW_20_in_ruleIndexExpCS10469 = new BitSet(new long[]{0xFF8007691F6840F0L,0x00000000000313DFL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleIndexExpCS10490 = new BitSet(new long[]{0x0000000000100000L,0x0000000000000800L});
        public static final BitSet FOLLOW_75_in_ruleIndexExpCS10504 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingExpCS_Base_in_entryRuleNavigatingExpCS_Base10544 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigatingExpCS_Base10554 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIndexExpCS_in_ruleNavigatingExpCS_Base10603 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingExpCS_in_entryRuleNavigatingExpCS10637 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigatingExpCS10647 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingExpCS_Base_in_ruleNavigatingExpCS10697 = new BitSet(new long[]{0x0000000010000002L});
        public static final BitSet FOLLOW_28_in_ruleNavigatingExpCS10721 = new BitSet(new long[]{0xFF8007693F6840F0L,0x00000000000313DFL});
        public static final BitSet FOLLOW_ruleNavigatingArgCS_in_ruleNavigatingExpCS10743 = new BitSet(new long[]{0x0000000060120000L});
        public static final BitSet FOLLOW_ruleNavigatingCommaArgCS_in_ruleNavigatingExpCS10764 = new BitSet(new long[]{0x0000000060120000L});
        public static final BitSet FOLLOW_ruleNavigatingSemiArgCS_in_ruleNavigatingExpCS10787 = new BitSet(new long[]{0x0000000060100000L});
        public static final BitSet FOLLOW_ruleNavigatingCommaArgCS_in_ruleNavigatingExpCS10808 = new BitSet(new long[]{0x0000000060100000L});
        public static final BitSet FOLLOW_ruleNavigatingBarArgCS_in_ruleNavigatingExpCS10833 = new BitSet(new long[]{0x0000000020100000L});
        public static final BitSet FOLLOW_ruleNavigatingCommaArgCS_in_ruleNavigatingExpCS10854 = new BitSet(new long[]{0x0000000020100000L});
        public static final BitSet FOLLOW_29_in_ruleNavigatingExpCS10871 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingArgCS_in_entryRuleNavigatingArgCS10909 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigatingArgCS10919 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingArgCS10965 = new BitSet(new long[]{0x0001000080000002L});
        public static final BitSet FOLLOW_31_in_ruleNavigatingArgCS10978 = new BitSet(new long[]{0xFF8000690F684030L,0x000000000000001FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleNavigatingArgCS10999 = new BitSet(new long[]{0x0001000000000002L});
        public static final BitSet FOLLOW_48_in_ruleNavigatingArgCS11014 = new BitSet(new long[]{0xFF8007691F6840F0L,0x00000000000313DFL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNavigatingArgCS11035 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingBarArgCS_in_entryRuleNavigatingBarArgCS11073 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigatingBarArgCS11083 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_ruleNavigatingBarArgCS11126 = new BitSet(new long[]{0xFF8007691F6840F0L,0x00000000000313DFL});
        public static final BitSet FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingBarArgCS11160 = new BitSet(new long[]{0x0001000080000002L});
        public static final BitSet FOLLOW_31_in_ruleNavigatingBarArgCS11173 = new BitSet(new long[]{0xFF8000690F684030L,0x000000000000001FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleNavigatingBarArgCS11194 = new BitSet(new long[]{0x0001000000000002L});
        public static final BitSet FOLLOW_48_in_ruleNavigatingBarArgCS11209 = new BitSet(new long[]{0xFF8007691F6840F0L,0x00000000000313DFL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNavigatingBarArgCS11230 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingCommaArgCS_in_entryRuleNavigatingCommaArgCS11268 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigatingCommaArgCS11278 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleNavigatingCommaArgCS11321 = new BitSet(new long[]{0xFF8007691F6840F0L,0x00000000000313DFL});
        public static final BitSet FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingCommaArgCS11355 = new BitSet(new long[]{0x0001000080000002L});
        public static final BitSet FOLLOW_31_in_ruleNavigatingCommaArgCS11368 = new BitSet(new long[]{0xFF8000690F684030L,0x000000000000001FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleNavigatingCommaArgCS11389 = new BitSet(new long[]{0x0001000000000002L});
        public static final BitSet FOLLOW_48_in_ruleNavigatingCommaArgCS11404 = new BitSet(new long[]{0xFF8007691F6840F0L,0x00000000000313DFL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNavigatingCommaArgCS11425 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingSemiArgCS_in_entryRuleNavigatingSemiArgCS11463 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigatingSemiArgCS11473 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleNavigatingSemiArgCS11516 = new BitSet(new long[]{0xFF8007691F6840F0L,0x00000000000313DFL});
        public static final BitSet FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingSemiArgCS11550 = new BitSet(new long[]{0x0001000080000002L});
        public static final BitSet FOLLOW_31_in_ruleNavigatingSemiArgCS11563 = new BitSet(new long[]{0xFF8000690F684030L,0x000000000000001FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleNavigatingSemiArgCS11584 = new BitSet(new long[]{0x0001000000000002L});
        public static final BitSet FOLLOW_48_in_ruleNavigatingSemiArgCS11599 = new BitSet(new long[]{0xFF8007691F6840F0L,0x00000000000313DFL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNavigatingSemiArgCS11620 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingArgExpCS_in_entryRuleNavigatingArgExpCS11658 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigatingArgExpCS11668 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNavigatingArgExpCS11717 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIfExpCS_in_entryRuleIfExpCS11751 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIfExpCS11761 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_76_in_ruleIfExpCS11798 = new BitSet(new long[]{0xFF8007691F6840F0L,0x00000000000313DFL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleIfExpCS11819 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
        public static final BitSet FOLLOW_77_in_ruleIfExpCS11831 = new BitSet(new long[]{0xFF8007691F6840F0L,0x00000000000313DFL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleIfExpCS11852 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
        public static final BitSet FOLLOW_78_in_ruleIfExpCS11864 = new BitSet(new long[]{0xFF8007691F6840F0L,0x00000000000313DFL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleIfExpCS11885 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
        public static final BitSet FOLLOW_79_in_ruleIfExpCS11897 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLetExpCS_in_entryRuleLetExpCS11933 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLetExpCS11943 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_80_in_ruleLetExpCS11980 = new BitSet(new long[]{0x000000690F684030L});
        public static final BitSet FOLLOW_ruleLetVariableCS_in_ruleLetExpCS12001 = new BitSet(new long[]{0x0000000000900000L});
        public static final BitSet FOLLOW_20_in_ruleLetExpCS12014 = new BitSet(new long[]{0x000000690F684030L});
        public static final BitSet FOLLOW_ruleLetVariableCS_in_ruleLetExpCS12035 = new BitSet(new long[]{0x0000000000900000L});
        public static final BitSet FOLLOW_23_in_ruleLetExpCS12049 = new BitSet(new long[]{0xFF8007691F6840F0L,0x00000000000313DFL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleLetExpCS12070 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLetVariableCS_in_entryRuleLetVariableCS12106 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLetVariableCS12116 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleLetVariableCS12162 = new BitSet(new long[]{0x0001000080000000L});
        public static final BitSet FOLLOW_31_in_ruleLetVariableCS12175 = new BitSet(new long[]{0xFF8000690F684030L,0x000000000000001FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleLetVariableCS12196 = new BitSet(new long[]{0x0001000000000000L});
        public static final BitSet FOLLOW_48_in_ruleLetVariableCS12210 = new BitSet(new long[]{0xFF8007691F6840F0L,0x00000000000313DFL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleLetVariableCS12231 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedExpCS_in_entryRuleNestedExpCS12267 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNestedExpCS12277 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_ruleNestedExpCS12314 = new BitSet(new long[]{0xFF8007691F6840F0L,0x00000000000313DFL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNestedExpCS12335 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_29_in_ruleNestedExpCS12347 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSelfExpCS_in_entryRuleSelfExpCS12383 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSelfExpCS12393 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_81_in_ruleSelfExpCS12442 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_synpred16_InternalQVTcore956 = new BitSet(new long[]{0x000000690F684030L});
        public static final BitSet FOLLOW_26_in_synpred16_InternalQVTcore971 = new BitSet(new long[]{0x000000690F684030L});
        public static final BitSet FOLLOW_ruleDirectionNameCS_in_synpred16_InternalQVTcore992 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_ruleDomainCS_in_synpred16_InternalQVTcore1012 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePredicateCS_in_synpred26_InternalQVTcore2133 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_synpred42_InternalQVTcore3557 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_INT_in_synpred42_InternalQVTcore3572 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_45_in_synpred79_InternalQVTcore5912 = new BitSet(new long[]{0xFF8000690F684030L,0x000000000000001FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_synpred79_InternalQVTcore5933 = new BitSet(new long[]{0x0000100000000000L});
        public static final BitSet FOLLOW_44_in_synpred79_InternalQVTcore5945 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_45_in_synpred85_InternalQVTcore6156 = new BitSet(new long[]{0x000010690F684030L});
        public static final BitSet FOLLOW_ruletuplePartCS_in_synpred85_InternalQVTcore6178 = new BitSet(new long[]{0x0000100000100000L});
        public static final BitSet FOLLOW_20_in_synpred85_InternalQVTcore6191 = new BitSet(new long[]{0x000000690F684030L});
        public static final BitSet FOLLOW_ruletuplePartCS_in_synpred85_InternalQVTcore6212 = new BitSet(new long[]{0x0000100000100000L});
        public static final BitSet FOLLOW_44_in_synpred85_InternalQVTcore6228 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBinaryOperatorCS_in_synpred106_InternalQVTcore9074 = new BitSet(new long[]{0xFF8007691F6840F0L,0x00000000000313DFL});
        public static final BitSet FOLLOW_rulePrefixedExpCS_in_synpred106_InternalQVTcore9095 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBinaryOperatorCS_in_synpred107_InternalQVTcore9074 = new BitSet(new long[]{0xFF8007691F6840F0L,0x00000000000313DFL});
        public static final BitSet FOLLOW_rulePrefixedExpCS_in_synpred107_InternalQVTcore9095 = new BitSet(new long[]{0x007FFD9000000002L});
        public static final BitSet FOLLOW_ruleNavigatingExpCS_in_synpred111_InternalQVTcore9748 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTupleLiteralExpCS_in_synpred114_InternalQVTcore9838 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionLiteralExpCS_in_synpred115_InternalQVTcore9868 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConstructorExpCS_in_synpred116_InternalQVTcore9898 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralExpCS_in_synpred117_InternalQVTcore9928 = new BitSet(new long[]{0x0000000000000002L});
    }


}