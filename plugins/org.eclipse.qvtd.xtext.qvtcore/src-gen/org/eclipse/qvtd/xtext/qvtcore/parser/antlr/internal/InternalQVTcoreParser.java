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

                        if ( (LA19_2==31) ) {
                            alt19=1;
                        }
                        else if ( ((LA19_2>=RULE_SIMPLE_ID && LA19_2<=RULE_ESCAPED_ID)||LA19_2==14||LA19_2==19||(LA19_2>=21 && LA19_2<=22)||(LA19_2>=24 && LA19_2<=27)||LA19_2==32||LA19_2==35||(LA19_2>=37 && LA19_2<=38)) ) {
                            alt19=2;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1692:1: entryRuleEssentialOCLUnrestrictedIdentifier returns [String current=null] : iv_ruleEssentialOCLUnrestrictedIdentifier= ruleEssentialOCLUnrestrictedIdentifier EOF ;
    public final String entryRuleEssentialOCLUnrestrictedIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEssentialOCLUnrestrictedIdentifier = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1693:2: (iv_ruleEssentialOCLUnrestrictedIdentifier= ruleEssentialOCLUnrestrictedIdentifier EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1694:2: iv_ruleEssentialOCLUnrestrictedIdentifier= ruleEssentialOCLUnrestrictedIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEssentialOCLUnrestrictedIdentifierRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLUnrestrictedIdentifier_in_entryRuleEssentialOCLUnrestrictedIdentifier3714);
            iv_ruleEssentialOCLUnrestrictedIdentifier=ruleEssentialOCLUnrestrictedIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEssentialOCLUnrestrictedIdentifier.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEssentialOCLUnrestrictedIdentifier3725); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1701:1: ruleEssentialOCLUnrestrictedIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'e' | kw= 'E' ) ;
    public final AntlrDatatypeRuleToken ruleEssentialOCLUnrestrictedIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1704:28: ( (kw= 'e' | kw= 'E' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1705:1: (kw= 'e' | kw= 'E' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1705:1: (kw= 'e' | kw= 'E' )
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1706:2: kw= 'e'
                    {
                    kw=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleEssentialOCLUnrestrictedIdentifier3763); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLUnrestrictedIdentifierAccess().getEKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1713:2: kw= 'E'
                    {
                    kw=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleEssentialOCLUnrestrictedIdentifier3782); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1726:1: entryRuleEssentialOCLPrefixOperator returns [String current=null] : iv_ruleEssentialOCLPrefixOperator= ruleEssentialOCLPrefixOperator EOF ;
    public final String entryRuleEssentialOCLPrefixOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEssentialOCLPrefixOperator = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1727:2: (iv_ruleEssentialOCLPrefixOperator= ruleEssentialOCLPrefixOperator EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1728:2: iv_ruleEssentialOCLPrefixOperator= ruleEssentialOCLPrefixOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEssentialOCLPrefixOperatorRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLPrefixOperator_in_entryRuleEssentialOCLPrefixOperator3823);
            iv_ruleEssentialOCLPrefixOperator=ruleEssentialOCLPrefixOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEssentialOCLPrefixOperator.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEssentialOCLPrefixOperator3834); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1735:1: ruleEssentialOCLPrefixOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '-' | kw= 'not' ) ;
    public final AntlrDatatypeRuleToken ruleEssentialOCLPrefixOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1738:28: ( (kw= '-' | kw= 'not' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1739:1: (kw= '-' | kw= 'not' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1739:1: (kw= '-' | kw= 'not' )
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1740:2: kw= '-'
                    {
                    kw=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleEssentialOCLPrefixOperator3872); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLPrefixOperatorAccess().getHyphenMinusKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1747:2: kw= 'not'
                    {
                    kw=(Token)match(input,41,FollowSets000.FOLLOW_41_in_ruleEssentialOCLPrefixOperator3891); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1760:1: entryRuleEssentialOCLInfixOperator returns [String current=null] : iv_ruleEssentialOCLInfixOperator= ruleEssentialOCLInfixOperator EOF ;
    public final String entryRuleEssentialOCLInfixOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEssentialOCLInfixOperator = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1761:2: (iv_ruleEssentialOCLInfixOperator= ruleEssentialOCLInfixOperator EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1762:2: iv_ruleEssentialOCLInfixOperator= ruleEssentialOCLInfixOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEssentialOCLInfixOperatorRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLInfixOperator_in_entryRuleEssentialOCLInfixOperator3932);
            iv_ruleEssentialOCLInfixOperator=ruleEssentialOCLInfixOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEssentialOCLInfixOperator.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEssentialOCLInfixOperator3943); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1769:1: ruleEssentialOCLInfixOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '*' | kw= '/' | kw= '+' | kw= '-' | kw= '>' | kw= '<' | kw= '>=' | kw= '<=' | kw= '=' | kw= '<>' | kw= 'and' | kw= 'or' | kw= 'xor' | kw= 'implies' ) ;
    public final AntlrDatatypeRuleToken ruleEssentialOCLInfixOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1772:28: ( (kw= '*' | kw= '/' | kw= '+' | kw= '-' | kw= '>' | kw= '<' | kw= '>=' | kw= '<=' | kw= '=' | kw= '<>' | kw= 'and' | kw= 'or' | kw= 'xor' | kw= 'implies' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1773:1: (kw= '*' | kw= '/' | kw= '+' | kw= '-' | kw= '>' | kw= '<' | kw= '>=' | kw= '<=' | kw= '=' | kw= '<>' | kw= 'and' | kw= 'or' | kw= 'xor' | kw= 'implies' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1773:1: (kw= '*' | kw= '/' | kw= '+' | kw= '-' | kw= '>' | kw= '<' | kw= '>=' | kw= '<=' | kw= '=' | kw= '<>' | kw= 'and' | kw= 'or' | kw= 'xor' | kw= 'implies' )
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1774:2: kw= '*'
                    {
                    kw=(Token)match(input,42,FollowSets000.FOLLOW_42_in_ruleEssentialOCLInfixOperator3981); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorAccess().getAsteriskKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1781:2: kw= '/'
                    {
                    kw=(Token)match(input,43,FollowSets000.FOLLOW_43_in_ruleEssentialOCLInfixOperator4000); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorAccess().getSolidusKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1788:2: kw= '+'
                    {
                    kw=(Token)match(input,39,FollowSets000.FOLLOW_39_in_ruleEssentialOCLInfixOperator4019); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorAccess().getPlusSignKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1795:2: kw= '-'
                    {
                    kw=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleEssentialOCLInfixOperator4038); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorAccess().getHyphenMinusKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1802:2: kw= '>'
                    {
                    kw=(Token)match(input,44,FollowSets000.FOLLOW_44_in_ruleEssentialOCLInfixOperator4057); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorAccess().getGreaterThanSignKeyword_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1809:2: kw= '<'
                    {
                    kw=(Token)match(input,45,FollowSets000.FOLLOW_45_in_ruleEssentialOCLInfixOperator4076); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorAccess().getLessThanSignKeyword_5()); 
                          
                    }

                    }
                    break;
                case 7 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1816:2: kw= '>='
                    {
                    kw=(Token)match(input,46,FollowSets000.FOLLOW_46_in_ruleEssentialOCLInfixOperator4095); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorAccess().getGreaterThanSignEqualsSignKeyword_6()); 
                          
                    }

                    }
                    break;
                case 8 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1823:2: kw= '<='
                    {
                    kw=(Token)match(input,47,FollowSets000.FOLLOW_47_in_ruleEssentialOCLInfixOperator4114); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorAccess().getLessThanSignEqualsSignKeyword_7()); 
                          
                    }

                    }
                    break;
                case 9 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1830:2: kw= '='
                    {
                    kw=(Token)match(input,48,FollowSets000.FOLLOW_48_in_ruleEssentialOCLInfixOperator4133); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorAccess().getEqualsSignKeyword_8()); 
                          
                    }

                    }
                    break;
                case 10 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1837:2: kw= '<>'
                    {
                    kw=(Token)match(input,49,FollowSets000.FOLLOW_49_in_ruleEssentialOCLInfixOperator4152); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorAccess().getLessThanSignGreaterThanSignKeyword_9()); 
                          
                    }

                    }
                    break;
                case 11 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1844:2: kw= 'and'
                    {
                    kw=(Token)match(input,50,FollowSets000.FOLLOW_50_in_ruleEssentialOCLInfixOperator4171); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorAccess().getAndKeyword_10()); 
                          
                    }

                    }
                    break;
                case 12 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1851:2: kw= 'or'
                    {
                    kw=(Token)match(input,51,FollowSets000.FOLLOW_51_in_ruleEssentialOCLInfixOperator4190); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorAccess().getOrKeyword_11()); 
                          
                    }

                    }
                    break;
                case 13 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1858:2: kw= 'xor'
                    {
                    kw=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleEssentialOCLInfixOperator4209); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorAccess().getXorKeyword_12()); 
                          
                    }

                    }
                    break;
                case 14 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1865:2: kw= 'implies'
                    {
                    kw=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleEssentialOCLInfixOperator4228); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1878:1: entryRuleEssentialOCLNavigationOperator returns [String current=null] : iv_ruleEssentialOCLNavigationOperator= ruleEssentialOCLNavigationOperator EOF ;
    public final String entryRuleEssentialOCLNavigationOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEssentialOCLNavigationOperator = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1879:2: (iv_ruleEssentialOCLNavigationOperator= ruleEssentialOCLNavigationOperator EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1880:2: iv_ruleEssentialOCLNavigationOperator= ruleEssentialOCLNavigationOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEssentialOCLNavigationOperatorRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLNavigationOperator_in_entryRuleEssentialOCLNavigationOperator4269);
            iv_ruleEssentialOCLNavigationOperator=ruleEssentialOCLNavigationOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEssentialOCLNavigationOperator.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEssentialOCLNavigationOperator4280); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1887:1: ruleEssentialOCLNavigationOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '.' | kw= '->' ) ;
    public final AntlrDatatypeRuleToken ruleEssentialOCLNavigationOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1890:28: ( (kw= '.' | kw= '->' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1891:1: (kw= '.' | kw= '->' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1891:1: (kw= '.' | kw= '->' )
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1892:2: kw= '.'
                    {
                    kw=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleEssentialOCLNavigationOperator4318); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLNavigationOperatorAccess().getFullStopKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1899:2: kw= '->'
                    {
                    kw=(Token)match(input,54,FollowSets000.FOLLOW_54_in_ruleEssentialOCLNavigationOperator4337); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1912:1: entryRuleIdentifier returns [String current=null] : iv_ruleIdentifier= ruleIdentifier EOF ;
    public final String entryRuleIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdentifier = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1913:2: (iv_ruleIdentifier= ruleIdentifier EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1914:2: iv_ruleIdentifier= ruleIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIdentifierRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_entryRuleIdentifier4378);
            iv_ruleIdentifier=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIdentifier.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIdentifier4389); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1921:1: ruleIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= ruleID | this_EssentialOCLUnrestrictedIdentifier_1= ruleEssentialOCLUnrestrictedIdentifier ) ;
    public final AntlrDatatypeRuleToken ruleIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_ID_0 = null;

        AntlrDatatypeRuleToken this_EssentialOCLUnrestrictedIdentifier_1 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1924:28: ( (this_ID_0= ruleID | this_EssentialOCLUnrestrictedIdentifier_1= ruleEssentialOCLUnrestrictedIdentifier ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1925:1: (this_ID_0= ruleID | this_EssentialOCLUnrestrictedIdentifier_1= ruleEssentialOCLUnrestrictedIdentifier )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1925:1: (this_ID_0= ruleID | this_EssentialOCLUnrestrictedIdentifier_1= ruleEssentialOCLUnrestrictedIdentifier )
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1926:5: this_ID_0= ruleID
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getIdentifierAccess().getIDParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleID_in_ruleIdentifier4436);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1938:5: this_EssentialOCLUnrestrictedIdentifier_1= ruleEssentialOCLUnrestrictedIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getIdentifierAccess().getEssentialOCLUnrestrictedIdentifierParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLUnrestrictedIdentifier_in_ruleIdentifier4469);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1956:1: entryRuleStringLiteral returns [String current=null] : iv_ruleStringLiteral= ruleStringLiteral EOF ;
    public final String entryRuleStringLiteral() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleStringLiteral = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1957:2: (iv_ruleStringLiteral= ruleStringLiteral EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1958:2: iv_ruleStringLiteral= ruleStringLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStringLiteralRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral4515);
            iv_ruleStringLiteral=ruleStringLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStringLiteral.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleStringLiteral4526); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1965:1: ruleStringLiteral returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING ;
    public final AntlrDatatypeRuleToken ruleStringLiteral() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_SINGLE_QUOTED_STRING_0=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1968:28: (this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1969:5: this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING
            {
            this_SINGLE_QUOTED_STRING_0=(Token)match(input,RULE_SINGLE_QUOTED_STRING,FollowSets000.FOLLOW_RULE_SINGLE_QUOTED_STRING_in_ruleStringLiteral4565); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1984:1: entryRulePrefixOperator returns [String current=null] : iv_rulePrefixOperator= rulePrefixOperator EOF ;
    public final String entryRulePrefixOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePrefixOperator = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1985:2: (iv_rulePrefixOperator= rulePrefixOperator EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1986:2: iv_rulePrefixOperator= rulePrefixOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrefixOperatorRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePrefixOperator_in_entryRulePrefixOperator4610);
            iv_rulePrefixOperator=rulePrefixOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrefixOperator.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrefixOperator4621); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1993:1: rulePrefixOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_EssentialOCLPrefixOperator_0= ruleEssentialOCLPrefixOperator ;
    public final AntlrDatatypeRuleToken rulePrefixOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_EssentialOCLPrefixOperator_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1996:28: (this_EssentialOCLPrefixOperator_0= ruleEssentialOCLPrefixOperator )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1998:5: this_EssentialOCLPrefixOperator_0= ruleEssentialOCLPrefixOperator
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getPrefixOperatorAccess().getEssentialOCLPrefixOperatorParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLPrefixOperator_in_rulePrefixOperator4667);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2016:1: entryRuleInfixOperator returns [String current=null] : iv_ruleInfixOperator= ruleInfixOperator EOF ;
    public final String entryRuleInfixOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInfixOperator = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2017:2: (iv_ruleInfixOperator= ruleInfixOperator EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2018:2: iv_ruleInfixOperator= ruleInfixOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInfixOperatorRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleInfixOperator_in_entryRuleInfixOperator4712);
            iv_ruleInfixOperator=ruleInfixOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInfixOperator.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleInfixOperator4723); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2025:1: ruleInfixOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_EssentialOCLInfixOperator_0= ruleEssentialOCLInfixOperator ;
    public final AntlrDatatypeRuleToken ruleInfixOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_EssentialOCLInfixOperator_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2028:28: (this_EssentialOCLInfixOperator_0= ruleEssentialOCLInfixOperator )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2030:5: this_EssentialOCLInfixOperator_0= ruleEssentialOCLInfixOperator
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getInfixOperatorAccess().getEssentialOCLInfixOperatorParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLInfixOperator_in_ruleInfixOperator4769);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2048:1: entryRuleNavigationOperator returns [String current=null] : iv_ruleNavigationOperator= ruleNavigationOperator EOF ;
    public final String entryRuleNavigationOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNavigationOperator = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2049:2: (iv_ruleNavigationOperator= ruleNavigationOperator EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2050:2: iv_ruleNavigationOperator= ruleNavigationOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigationOperatorRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigationOperator_in_entryRuleNavigationOperator4814);
            iv_ruleNavigationOperator=ruleNavigationOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigationOperator.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigationOperator4825); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2057:1: ruleNavigationOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_EssentialOCLNavigationOperator_0= ruleEssentialOCLNavigationOperator ;
    public final AntlrDatatypeRuleToken ruleNavigationOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_EssentialOCLNavigationOperator_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2060:28: (this_EssentialOCLNavigationOperator_0= ruleEssentialOCLNavigationOperator )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2062:5: this_EssentialOCLNavigationOperator_0= ruleEssentialOCLNavigationOperator
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getNavigationOperatorAccess().getEssentialOCLNavigationOperatorParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLNavigationOperator_in_ruleNavigationOperator4871);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2080:1: entryRuleEssentialOCLUnrestrictedName returns [String current=null] : iv_ruleEssentialOCLUnrestrictedName= ruleEssentialOCLUnrestrictedName EOF ;
    public final String entryRuleEssentialOCLUnrestrictedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEssentialOCLUnrestrictedName = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2081:2: (iv_ruleEssentialOCLUnrestrictedName= ruleEssentialOCLUnrestrictedName EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2082:2: iv_ruleEssentialOCLUnrestrictedName= ruleEssentialOCLUnrestrictedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEssentialOCLUnrestrictedNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLUnrestrictedName_in_entryRuleEssentialOCLUnrestrictedName4916);
            iv_ruleEssentialOCLUnrestrictedName=ruleEssentialOCLUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEssentialOCLUnrestrictedName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEssentialOCLUnrestrictedName4927); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2089:1: ruleEssentialOCLUnrestrictedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_Identifier_0= ruleIdentifier ;
    public final AntlrDatatypeRuleToken ruleEssentialOCLUnrestrictedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_Identifier_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2092:28: (this_Identifier_0= ruleIdentifier )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2094:5: this_Identifier_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getEssentialOCLUnrestrictedNameAccess().getIdentifierParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_ruleEssentialOCLUnrestrictedName4973);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2112:1: entryRuleEssentialOCLUnreservedName returns [String current=null] : iv_ruleEssentialOCLUnreservedName= ruleEssentialOCLUnreservedName EOF ;
    public final String entryRuleEssentialOCLUnreservedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEssentialOCLUnreservedName = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2113:2: (iv_ruleEssentialOCLUnreservedName= ruleEssentialOCLUnreservedName EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2114:2: iv_ruleEssentialOCLUnreservedName= ruleEssentialOCLUnreservedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEssentialOCLUnreservedNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLUnreservedName_in_entryRuleEssentialOCLUnreservedName5018);
            iv_ruleEssentialOCLUnreservedName=ruleEssentialOCLUnreservedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEssentialOCLUnreservedName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEssentialOCLUnreservedName5029); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2121:1: ruleEssentialOCLUnreservedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_UnrestrictedName_0= ruleUnrestrictedName | this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier | this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier | kw= 'Tuple' ) ;
    public final AntlrDatatypeRuleToken ruleEssentialOCLUnreservedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_UnrestrictedName_0 = null;

        AntlrDatatypeRuleToken this_CollectionTypeIdentifier_1 = null;

        AntlrDatatypeRuleToken this_PrimitiveTypeIdentifier_2 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2124:28: ( (this_UnrestrictedName_0= ruleUnrestrictedName | this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier | this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier | kw= 'Tuple' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2125:1: (this_UnrestrictedName_0= ruleUnrestrictedName | this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier | this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier | kw= 'Tuple' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2125:1: (this_UnrestrictedName_0= ruleUnrestrictedName | this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier | this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier | kw= 'Tuple' )
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2126:5: this_UnrestrictedName_0= ruleUnrestrictedName
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getEssentialOCLUnreservedNameAccess().getUnrestrictedNameParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleEssentialOCLUnreservedName5076);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2138:5: this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getEssentialOCLUnreservedNameAccess().getCollectionTypeIdentifierParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCollectionTypeIdentifier_in_ruleEssentialOCLUnreservedName5109);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2150:5: this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getEssentialOCLUnreservedNameAccess().getPrimitiveTypeIdentifierParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrimitiveTypeIdentifier_in_ruleEssentialOCLUnreservedName5142);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2162:2: kw= 'Tuple'
                    {
                    kw=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleEssentialOCLUnreservedName5166); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2175:1: entryRuleUnreservedName returns [String current=null] : iv_ruleUnreservedName= ruleUnreservedName EOF ;
    public final String entryRuleUnreservedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnreservedName = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2176:2: (iv_ruleUnreservedName= ruleUnreservedName EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2177:2: iv_ruleUnreservedName= ruleUnreservedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnreservedNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnreservedName_in_entryRuleUnreservedName5207);
            iv_ruleUnreservedName=ruleUnreservedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnreservedName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnreservedName5218); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2184:1: ruleUnreservedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_EssentialOCLUnreservedName_0= ruleEssentialOCLUnreservedName ;
    public final AntlrDatatypeRuleToken ruleUnreservedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_EssentialOCLUnreservedName_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2187:28: (this_EssentialOCLUnreservedName_0= ruleEssentialOCLUnreservedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2189:5: this_EssentialOCLUnreservedName_0= ruleEssentialOCLUnreservedName
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getUnreservedNameAccess().getEssentialOCLUnreservedNameParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLUnreservedName_in_ruleUnreservedName5264);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2207:1: entryRulePrimitiveTypeIdentifier returns [String current=null] : iv_rulePrimitiveTypeIdentifier= rulePrimitiveTypeIdentifier EOF ;
    public final String entryRulePrimitiveTypeIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePrimitiveTypeIdentifier = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2208:2: (iv_rulePrimitiveTypeIdentifier= rulePrimitiveTypeIdentifier EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2209:2: iv_rulePrimitiveTypeIdentifier= rulePrimitiveTypeIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimitiveTypeIdentifierRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePrimitiveTypeIdentifier_in_entryRulePrimitiveTypeIdentifier5309);
            iv_rulePrimitiveTypeIdentifier=rulePrimitiveTypeIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimitiveTypeIdentifier.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrimitiveTypeIdentifier5320); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2216:1: rulePrimitiveTypeIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Boolean' | kw= 'Integer' | kw= 'Real' | kw= 'String' | kw= 'UnlimitedNatural' | kw= 'OclAny' | kw= 'OclInvalid' | kw= 'OclVoid' ) ;
    public final AntlrDatatypeRuleToken rulePrimitiveTypeIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2219:28: ( (kw= 'Boolean' | kw= 'Integer' | kw= 'Real' | kw= 'String' | kw= 'UnlimitedNatural' | kw= 'OclAny' | kw= 'OclInvalid' | kw= 'OclVoid' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2220:1: (kw= 'Boolean' | kw= 'Integer' | kw= 'Real' | kw= 'String' | kw= 'UnlimitedNatural' | kw= 'OclAny' | kw= 'OclInvalid' | kw= 'OclVoid' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2220:1: (kw= 'Boolean' | kw= 'Integer' | kw= 'Real' | kw= 'String' | kw= 'UnlimitedNatural' | kw= 'OclAny' | kw= 'OclInvalid' | kw= 'OclVoid' )
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2221:2: kw= 'Boolean'
                    {
                    kw=(Token)match(input,56,FollowSets000.FOLLOW_56_in_rulePrimitiveTypeIdentifier5358); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getBooleanKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2228:2: kw= 'Integer'
                    {
                    kw=(Token)match(input,57,FollowSets000.FOLLOW_57_in_rulePrimitiveTypeIdentifier5377); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getIntegerKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2235:2: kw= 'Real'
                    {
                    kw=(Token)match(input,58,FollowSets000.FOLLOW_58_in_rulePrimitiveTypeIdentifier5396); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getRealKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2242:2: kw= 'String'
                    {
                    kw=(Token)match(input,59,FollowSets000.FOLLOW_59_in_rulePrimitiveTypeIdentifier5415); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getStringKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2249:2: kw= 'UnlimitedNatural'
                    {
                    kw=(Token)match(input,60,FollowSets000.FOLLOW_60_in_rulePrimitiveTypeIdentifier5434); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getUnlimitedNaturalKeyword_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2256:2: kw= 'OclAny'
                    {
                    kw=(Token)match(input,61,FollowSets000.FOLLOW_61_in_rulePrimitiveTypeIdentifier5453); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getOclAnyKeyword_5()); 
                          
                    }

                    }
                    break;
                case 7 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2263:2: kw= 'OclInvalid'
                    {
                    kw=(Token)match(input,62,FollowSets000.FOLLOW_62_in_rulePrimitiveTypeIdentifier5472); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getOclInvalidKeyword_6()); 
                          
                    }

                    }
                    break;
                case 8 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2270:2: kw= 'OclVoid'
                    {
                    kw=(Token)match(input,63,FollowSets000.FOLLOW_63_in_rulePrimitiveTypeIdentifier5491); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2283:1: entryRulePrimitiveTypeCS returns [EObject current=null] : iv_rulePrimitiveTypeCS= rulePrimitiveTypeCS EOF ;
    public final EObject entryRulePrimitiveTypeCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveTypeCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2284:2: (iv_rulePrimitiveTypeCS= rulePrimitiveTypeCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2285:2: iv_rulePrimitiveTypeCS= rulePrimitiveTypeCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimitiveTypeCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePrimitiveTypeCS_in_entryRulePrimitiveTypeCS5531);
            iv_rulePrimitiveTypeCS=rulePrimitiveTypeCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimitiveTypeCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrimitiveTypeCS5541); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2292:1: rulePrimitiveTypeCS returns [EObject current=null] : ( (lv_name_0_0= rulePrimitiveTypeIdentifier ) ) ;
    public final EObject rulePrimitiveTypeCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2295:28: ( ( (lv_name_0_0= rulePrimitiveTypeIdentifier ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2296:1: ( (lv_name_0_0= rulePrimitiveTypeIdentifier ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2296:1: ( (lv_name_0_0= rulePrimitiveTypeIdentifier ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2297:1: (lv_name_0_0= rulePrimitiveTypeIdentifier )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2297:1: (lv_name_0_0= rulePrimitiveTypeIdentifier )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2298:3: lv_name_0_0= rulePrimitiveTypeIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPrimitiveTypeCSAccess().getNamePrimitiveTypeIdentifierParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_rulePrimitiveTypeIdentifier_in_rulePrimitiveTypeCS5586);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2322:1: entryRuleCollectionTypeIdentifier returns [String current=null] : iv_ruleCollectionTypeIdentifier= ruleCollectionTypeIdentifier EOF ;
    public final String entryRuleCollectionTypeIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleCollectionTypeIdentifier = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2323:2: (iv_ruleCollectionTypeIdentifier= ruleCollectionTypeIdentifier EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2324:2: iv_ruleCollectionTypeIdentifier= ruleCollectionTypeIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCollectionTypeIdentifierRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleCollectionTypeIdentifier_in_entryRuleCollectionTypeIdentifier5622);
            iv_ruleCollectionTypeIdentifier=ruleCollectionTypeIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCollectionTypeIdentifier.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCollectionTypeIdentifier5633); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2331:1: ruleCollectionTypeIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Set' | kw= 'Bag' | kw= 'Sequence' | kw= 'Collection' | kw= 'OrderedSet' ) ;
    public final AntlrDatatypeRuleToken ruleCollectionTypeIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2334:28: ( (kw= 'Set' | kw= 'Bag' | kw= 'Sequence' | kw= 'Collection' | kw= 'OrderedSet' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2335:1: (kw= 'Set' | kw= 'Bag' | kw= 'Sequence' | kw= 'Collection' | kw= 'OrderedSet' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2335:1: (kw= 'Set' | kw= 'Bag' | kw= 'Sequence' | kw= 'Collection' | kw= 'OrderedSet' )
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2336:2: kw= 'Set'
                    {
                    kw=(Token)match(input,64,FollowSets000.FOLLOW_64_in_ruleCollectionTypeIdentifier5671); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getSetKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2343:2: kw= 'Bag'
                    {
                    kw=(Token)match(input,65,FollowSets000.FOLLOW_65_in_ruleCollectionTypeIdentifier5690); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getBagKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2350:2: kw= 'Sequence'
                    {
                    kw=(Token)match(input,66,FollowSets000.FOLLOW_66_in_ruleCollectionTypeIdentifier5709); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getSequenceKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2357:2: kw= 'Collection'
                    {
                    kw=(Token)match(input,67,FollowSets000.FOLLOW_67_in_ruleCollectionTypeIdentifier5728); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getCollectionKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2364:2: kw= 'OrderedSet'
                    {
                    kw=(Token)match(input,68,FollowSets000.FOLLOW_68_in_ruleCollectionTypeIdentifier5747); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2377:1: entryRuleCollectionTypeCS returns [EObject current=null] : iv_ruleCollectionTypeCS= ruleCollectionTypeCS EOF ;
    public final EObject entryRuleCollectionTypeCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionTypeCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2378:2: (iv_ruleCollectionTypeCS= ruleCollectionTypeCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2379:2: iv_ruleCollectionTypeCS= ruleCollectionTypeCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCollectionTypeCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleCollectionTypeCS_in_entryRuleCollectionTypeCS5787);
            iv_ruleCollectionTypeCS=ruleCollectionTypeCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCollectionTypeCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCollectionTypeCS5797); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2386:1: ruleCollectionTypeCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) ( (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' ) | (otherlv_4= '<' ( (lv_ownedType_5_0= ruleTypeExpCS ) ) otherlv_6= '>' ) )? ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2389:28: ( ( ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) ( (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' ) | (otherlv_4= '<' ( (lv_ownedType_5_0= ruleTypeExpCS ) ) otherlv_6= '>' ) )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2390:1: ( ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) ( (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' ) | (otherlv_4= '<' ( (lv_ownedType_5_0= ruleTypeExpCS ) ) otherlv_6= '>' ) )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2390:1: ( ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) ( (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' ) | (otherlv_4= '<' ( (lv_ownedType_5_0= ruleTypeExpCS ) ) otherlv_6= '>' ) )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2390:2: ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) ( (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' ) | (otherlv_4= '<' ( (lv_ownedType_5_0= ruleTypeExpCS ) ) otherlv_6= '>' ) )?
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2390:2: ( (lv_name_0_0= ruleCollectionTypeIdentifier ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2391:1: (lv_name_0_0= ruleCollectionTypeIdentifier )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2391:1: (lv_name_0_0= ruleCollectionTypeIdentifier )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2392:3: lv_name_0_0= ruleCollectionTypeIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCollectionTypeCSAccess().getNameCollectionTypeIdentifierParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleCollectionTypeIdentifier_in_ruleCollectionTypeCS5843);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2408:2: ( (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' ) | (otherlv_4= '<' ( (lv_ownedType_5_0= ruleTypeExpCS ) ) otherlv_6= '>' ) )?
            int alt43=3;
            alt43 = dfa43.predict(input);
            switch (alt43) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2408:3: (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2408:3: (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2408:5: otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleCollectionTypeCS5857); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getCollectionTypeCSAccess().getLeftParenthesisKeyword_1_0_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2412:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2413:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2413:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2414:3: lv_ownedType_2_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionTypeCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_0_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleCollectionTypeCS5878);
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

                    otherlv_3=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleCollectionTypeCS5890); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getCollectionTypeCSAccess().getRightParenthesisKeyword_1_0_2());
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2435:6: (otherlv_4= '<' ( (lv_ownedType_5_0= ruleTypeExpCS ) ) otherlv_6= '>' )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2435:6: (otherlv_4= '<' ( (lv_ownedType_5_0= ruleTypeExpCS ) ) otherlv_6= '>' )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2435:8: otherlv_4= '<' ( (lv_ownedType_5_0= ruleTypeExpCS ) ) otherlv_6= '>'
                    {
                    otherlv_4=(Token)match(input,45,FollowSets000.FOLLOW_45_in_ruleCollectionTypeCS5910); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getCollectionTypeCSAccess().getLessThanSignKeyword_1_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2439:1: ( (lv_ownedType_5_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2440:1: (lv_ownedType_5_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2440:1: (lv_ownedType_5_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2441:3: lv_ownedType_5_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionTypeCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleCollectionTypeCS5931);
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

                    otherlv_6=(Token)match(input,44,FollowSets000.FOLLOW_44_in_ruleCollectionTypeCS5943); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2469:1: entryRuleTupleTypeCS returns [EObject current=null] : iv_ruleTupleTypeCS= ruleTupleTypeCS EOF ;
    public final EObject entryRuleTupleTypeCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTupleTypeCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2470:2: (iv_ruleTupleTypeCS= ruleTupleTypeCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2471:2: iv_ruleTupleTypeCS= ruleTupleTypeCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTupleTypeCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTupleTypeCS_in_entryRuleTupleTypeCS5982);
            iv_ruleTupleTypeCS=ruleTupleTypeCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTupleTypeCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTupleTypeCS5992); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2478:1: ruleTupleTypeCS returns [EObject current=null] : ( ( (lv_name_0_0= 'Tuple' ) ) ( (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruletuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruletuplePartCS ) ) )* )? otherlv_5= ')' ) | (otherlv_6= '<' ( ( (lv_ownedParts_7_0= ruletuplePartCS ) ) (otherlv_8= ',' ( (lv_ownedParts_9_0= ruletuplePartCS ) ) )* )? otherlv_10= '>' ) )? ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2481:28: ( ( ( (lv_name_0_0= 'Tuple' ) ) ( (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruletuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruletuplePartCS ) ) )* )? otherlv_5= ')' ) | (otherlv_6= '<' ( ( (lv_ownedParts_7_0= ruletuplePartCS ) ) (otherlv_8= ',' ( (lv_ownedParts_9_0= ruletuplePartCS ) ) )* )? otherlv_10= '>' ) )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2482:1: ( ( (lv_name_0_0= 'Tuple' ) ) ( (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruletuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruletuplePartCS ) ) )* )? otherlv_5= ')' ) | (otherlv_6= '<' ( ( (lv_ownedParts_7_0= ruletuplePartCS ) ) (otherlv_8= ',' ( (lv_ownedParts_9_0= ruletuplePartCS ) ) )* )? otherlv_10= '>' ) )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2482:1: ( ( (lv_name_0_0= 'Tuple' ) ) ( (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruletuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruletuplePartCS ) ) )* )? otherlv_5= ')' ) | (otherlv_6= '<' ( ( (lv_ownedParts_7_0= ruletuplePartCS ) ) (otherlv_8= ',' ( (lv_ownedParts_9_0= ruletuplePartCS ) ) )* )? otherlv_10= '>' ) )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2482:2: ( (lv_name_0_0= 'Tuple' ) ) ( (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruletuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruletuplePartCS ) ) )* )? otherlv_5= ')' ) | (otherlv_6= '<' ( ( (lv_ownedParts_7_0= ruletuplePartCS ) ) (otherlv_8= ',' ( (lv_ownedParts_9_0= ruletuplePartCS ) ) )* )? otherlv_10= '>' ) )?
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2482:2: ( (lv_name_0_0= 'Tuple' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2483:1: (lv_name_0_0= 'Tuple' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2483:1: (lv_name_0_0= 'Tuple' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2484:3: lv_name_0_0= 'Tuple'
            {
            lv_name_0_0=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleTupleTypeCS6035); if (state.failed) return current;
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2497:2: ( (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruletuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruletuplePartCS ) ) )* )? otherlv_5= ')' ) | (otherlv_6= '<' ( ( (lv_ownedParts_7_0= ruletuplePartCS ) ) (otherlv_8= ',' ( (lv_ownedParts_9_0= ruletuplePartCS ) ) )* )? otherlv_10= '>' ) )?
            int alt48=3;
            alt48 = dfa48.predict(input);
            switch (alt48) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2497:3: (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruletuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruletuplePartCS ) ) )* )? otherlv_5= ')' )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2497:3: (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruletuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruletuplePartCS ) ) )* )? otherlv_5= ')' )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2497:5: otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruletuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruletuplePartCS ) ) )* )? otherlv_5= ')'
                    {
                    otherlv_1=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleTupleTypeCS6062); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getTupleTypeCSAccess().getLeftParenthesisKeyword_1_0_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2501:1: ( ( (lv_ownedParts_2_0= ruletuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruletuplePartCS ) ) )* )?
                    int alt45=2;
                    int LA45_0 = input.LA(1);

                    if ( ((LA45_0>=RULE_SIMPLE_ID && LA45_0<=RULE_ESCAPED_ID)||LA45_0==14||LA45_0==19||(LA45_0>=21 && LA45_0<=22)||(LA45_0>=24 && LA45_0<=27)||LA45_0==32||LA45_0==35||(LA45_0>=37 && LA45_0<=38)) ) {
                        alt45=1;
                    }
                    switch (alt45) {
                        case 1 :
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2501:2: ( (lv_ownedParts_2_0= ruletuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruletuplePartCS ) ) )*
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2501:2: ( (lv_ownedParts_2_0= ruletuplePartCS ) )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2502:1: (lv_ownedParts_2_0= ruletuplePartCS )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2502:1: (lv_ownedParts_2_0= ruletuplePartCS )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2503:3: lv_ownedParts_2_0= ruletuplePartCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getTupleTypeCSAccess().getOwnedPartsTuplePartCSParserRuleCall_1_0_1_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruletuplePartCS_in_ruleTupleTypeCS6084);
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

                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2519:2: (otherlv_3= ',' ( (lv_ownedParts_4_0= ruletuplePartCS ) ) )*
                            loop44:
                            do {
                                int alt44=2;
                                int LA44_0 = input.LA(1);

                                if ( (LA44_0==20) ) {
                                    alt44=1;
                                }


                                switch (alt44) {
                            	case 1 :
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2519:4: otherlv_3= ',' ( (lv_ownedParts_4_0= ruletuplePartCS ) )
                            	    {
                            	    otherlv_3=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleTupleTypeCS6097); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_3, grammarAccess.getTupleTypeCSAccess().getCommaKeyword_1_0_1_1_0());
                            	          
                            	    }
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2523:1: ( (lv_ownedParts_4_0= ruletuplePartCS ) )
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2524:1: (lv_ownedParts_4_0= ruletuplePartCS )
                            	    {
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2524:1: (lv_ownedParts_4_0= ruletuplePartCS )
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2525:3: lv_ownedParts_4_0= ruletuplePartCS
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getTupleTypeCSAccess().getOwnedPartsTuplePartCSParserRuleCall_1_0_1_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FollowSets000.FOLLOW_ruletuplePartCS_in_ruleTupleTypeCS6118);
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

                    otherlv_5=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleTupleTypeCS6134); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getTupleTypeCSAccess().getRightParenthesisKeyword_1_0_2());
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2546:6: (otherlv_6= '<' ( ( (lv_ownedParts_7_0= ruletuplePartCS ) ) (otherlv_8= ',' ( (lv_ownedParts_9_0= ruletuplePartCS ) ) )* )? otherlv_10= '>' )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2546:6: (otherlv_6= '<' ( ( (lv_ownedParts_7_0= ruletuplePartCS ) ) (otherlv_8= ',' ( (lv_ownedParts_9_0= ruletuplePartCS ) ) )* )? otherlv_10= '>' )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2546:8: otherlv_6= '<' ( ( (lv_ownedParts_7_0= ruletuplePartCS ) ) (otherlv_8= ',' ( (lv_ownedParts_9_0= ruletuplePartCS ) ) )* )? otherlv_10= '>'
                    {
                    otherlv_6=(Token)match(input,45,FollowSets000.FOLLOW_45_in_ruleTupleTypeCS6154); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getTupleTypeCSAccess().getLessThanSignKeyword_1_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2550:1: ( ( (lv_ownedParts_7_0= ruletuplePartCS ) ) (otherlv_8= ',' ( (lv_ownedParts_9_0= ruletuplePartCS ) ) )* )?
                    int alt47=2;
                    int LA47_0 = input.LA(1);

                    if ( ((LA47_0>=RULE_SIMPLE_ID && LA47_0<=RULE_ESCAPED_ID)||LA47_0==14||LA47_0==19||(LA47_0>=21 && LA47_0<=22)||(LA47_0>=24 && LA47_0<=27)||LA47_0==32||LA47_0==35||(LA47_0>=37 && LA47_0<=38)) ) {
                        alt47=1;
                    }
                    switch (alt47) {
                        case 1 :
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2550:2: ( (lv_ownedParts_7_0= ruletuplePartCS ) ) (otherlv_8= ',' ( (lv_ownedParts_9_0= ruletuplePartCS ) ) )*
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2550:2: ( (lv_ownedParts_7_0= ruletuplePartCS ) )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2551:1: (lv_ownedParts_7_0= ruletuplePartCS )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2551:1: (lv_ownedParts_7_0= ruletuplePartCS )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2552:3: lv_ownedParts_7_0= ruletuplePartCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getTupleTypeCSAccess().getOwnedPartsTuplePartCSParserRuleCall_1_1_1_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruletuplePartCS_in_ruleTupleTypeCS6176);
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

                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2568:2: (otherlv_8= ',' ( (lv_ownedParts_9_0= ruletuplePartCS ) ) )*
                            loop46:
                            do {
                                int alt46=2;
                                int LA46_0 = input.LA(1);

                                if ( (LA46_0==20) ) {
                                    alt46=1;
                                }


                                switch (alt46) {
                            	case 1 :
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2568:4: otherlv_8= ',' ( (lv_ownedParts_9_0= ruletuplePartCS ) )
                            	    {
                            	    otherlv_8=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleTupleTypeCS6189); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_8, grammarAccess.getTupleTypeCSAccess().getCommaKeyword_1_1_1_1_0());
                            	          
                            	    }
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2572:1: ( (lv_ownedParts_9_0= ruletuplePartCS ) )
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2573:1: (lv_ownedParts_9_0= ruletuplePartCS )
                            	    {
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2573:1: (lv_ownedParts_9_0= ruletuplePartCS )
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2574:3: lv_ownedParts_9_0= ruletuplePartCS
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getTupleTypeCSAccess().getOwnedPartsTuplePartCSParserRuleCall_1_1_1_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FollowSets000.FOLLOW_ruletuplePartCS_in_ruleTupleTypeCS6210);
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

                    otherlv_10=(Token)match(input,44,FollowSets000.FOLLOW_44_in_ruleTupleTypeCS6226); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2602:1: entryRuletuplePartCS returns [EObject current=null] : iv_ruletuplePartCS= ruletuplePartCS EOF ;
    public final EObject entryRuletuplePartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruletuplePartCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2603:2: (iv_ruletuplePartCS= ruletuplePartCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2604:2: iv_ruletuplePartCS= ruletuplePartCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTuplePartCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruletuplePartCS_in_entryRuletuplePartCS6265);
            iv_ruletuplePartCS=ruletuplePartCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruletuplePartCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuletuplePartCS6275); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2611:1: ruletuplePartCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) ) ;
    public final EObject ruletuplePartCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2614:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2615:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2615:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2615:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2615:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2616:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2616:1: (lv_name_0_0= ruleUnrestrictedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2617:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTuplePartCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruletuplePartCS6321);
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

            otherlv_1=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruletuplePartCS6333); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getTuplePartCSAccess().getColonKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2637:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2638:1: (lv_ownedType_2_0= ruleTypeExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2638:1: (lv_ownedType_2_0= ruleTypeExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2639:3: lv_ownedType_2_0= ruleTypeExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTuplePartCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruletuplePartCS6354);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2663:1: entryRuleCollectionLiteralExpCS returns [EObject current=null] : iv_ruleCollectionLiteralExpCS= ruleCollectionLiteralExpCS EOF ;
    public final EObject entryRuleCollectionLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2664:2: (iv_ruleCollectionLiteralExpCS= ruleCollectionLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2665:2: iv_ruleCollectionLiteralExpCS= ruleCollectionLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCollectionLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteralExpCS_in_entryRuleCollectionLiteralExpCS6390);
            iv_ruleCollectionLiteralExpCS=ruleCollectionLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCollectionLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCollectionLiteralExpCS6400); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2672:1: ruleCollectionLiteralExpCS returns [EObject current=null] : ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}' ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2675:28: ( ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2676:1: ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2676:1: ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2676:2: ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}'
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2676:2: ( (lv_ownedType_0_0= ruleCollectionTypeCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2677:1: (lv_ownedType_0_0= ruleCollectionTypeCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2677:1: (lv_ownedType_0_0= ruleCollectionTypeCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2678:3: lv_ownedType_0_0= ruleCollectionTypeCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedTypeCollectionTypeCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleCollectionTypeCS_in_ruleCollectionLiteralExpCS6446);
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

            otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleCollectionLiteralExpCS6458); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getCollectionLiteralExpCSAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2698:1: ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( ((LA50_0>=RULE_SIMPLE_ID && LA50_0<=RULE_SINGLE_QUOTED_STRING)||LA50_0==14||LA50_0==19||(LA50_0>=21 && LA50_0<=22)||(LA50_0>=24 && LA50_0<=28)||LA50_0==32||LA50_0==35||(LA50_0>=37 && LA50_0<=38)||(LA50_0>=40 && LA50_0<=42)||(LA50_0>=55 && LA50_0<=68)||(LA50_0>=70 && LA50_0<=73)||LA50_0==76||(LA50_0>=80 && LA50_0<=81)) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2698:2: ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )*
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2698:2: ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2699:1: (lv_ownedParts_2_0= ruleCollectionLiteralPartCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2699:1: (lv_ownedParts_2_0= ruleCollectionLiteralPartCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2700:3: lv_ownedParts_2_0= ruleCollectionLiteralPartCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedPartsCollectionLiteralPartCSParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteralPartCS_in_ruleCollectionLiteralExpCS6480);
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

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2716:2: (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )*
                    loop49:
                    do {
                        int alt49=2;
                        int LA49_0 = input.LA(1);

                        if ( (LA49_0==20) ) {
                            alt49=1;
                        }


                        switch (alt49) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2716:4: otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) )
                    	    {
                    	    otherlv_3=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleCollectionLiteralExpCS6493); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getCollectionLiteralExpCSAccess().getCommaKeyword_2_1_0());
                    	          
                    	    }
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2720:1: ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2721:1: (lv_ownedParts_4_0= ruleCollectionLiteralPartCS )
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2721:1: (lv_ownedParts_4_0= ruleCollectionLiteralPartCS )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2722:3: lv_ownedParts_4_0= ruleCollectionLiteralPartCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedPartsCollectionLiteralPartCSParserRuleCall_2_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteralPartCS_in_ruleCollectionLiteralExpCS6514);
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

            otherlv_5=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleCollectionLiteralExpCS6530); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2750:1: entryRuleCollectionLiteralPartCS returns [EObject current=null] : iv_ruleCollectionLiteralPartCS= ruleCollectionLiteralPartCS EOF ;
    public final EObject entryRuleCollectionLiteralPartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionLiteralPartCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2751:2: (iv_ruleCollectionLiteralPartCS= ruleCollectionLiteralPartCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2752:2: iv_ruleCollectionLiteralPartCS= ruleCollectionLiteralPartCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCollectionLiteralPartCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteralPartCS_in_entryRuleCollectionLiteralPartCS6566);
            iv_ruleCollectionLiteralPartCS=ruleCollectionLiteralPartCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCollectionLiteralPartCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCollectionLiteralPartCS6576); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2759:1: ruleCollectionLiteralPartCS returns [EObject current=null] : ( ( (lv_expressionCS_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_lastExpressionCS_2_0= ruleExpCS ) ) )? ) ;
    public final EObject ruleCollectionLiteralPartCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expressionCS_0_0 = null;

        EObject lv_lastExpressionCS_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2762:28: ( ( ( (lv_expressionCS_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_lastExpressionCS_2_0= ruleExpCS ) ) )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2763:1: ( ( (lv_expressionCS_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_lastExpressionCS_2_0= ruleExpCS ) ) )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2763:1: ( ( (lv_expressionCS_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_lastExpressionCS_2_0= ruleExpCS ) ) )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2763:2: ( (lv_expressionCS_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_lastExpressionCS_2_0= ruleExpCS ) ) )?
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2763:2: ( (lv_expressionCS_0_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2764:1: (lv_expressionCS_0_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2764:1: (lv_expressionCS_0_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2765:3: lv_expressionCS_0_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCollectionLiteralPartCSAccess().getExpressionCSExpCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleCollectionLiteralPartCS6622);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2781:2: (otherlv_1= '..' ( (lv_lastExpressionCS_2_0= ruleExpCS ) ) )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==69) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2781:4: otherlv_1= '..' ( (lv_lastExpressionCS_2_0= ruleExpCS ) )
                    {
                    otherlv_1=(Token)match(input,69,FollowSets000.FOLLOW_69_in_ruleCollectionLiteralPartCS6635); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getCollectionLiteralPartCSAccess().getFullStopFullStopKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2785:1: ( (lv_lastExpressionCS_2_0= ruleExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2786:1: (lv_lastExpressionCS_2_0= ruleExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2786:1: (lv_lastExpressionCS_2_0= ruleExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2787:3: lv_lastExpressionCS_2_0= ruleExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionLiteralPartCSAccess().getLastExpressionCSExpCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleCollectionLiteralPartCS6656);
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


    // $ANTLR start "entryRulePrimitiveLiteralExpCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2811:1: entryRulePrimitiveLiteralExpCS returns [EObject current=null] : iv_rulePrimitiveLiteralExpCS= rulePrimitiveLiteralExpCS EOF ;
    public final EObject entryRulePrimitiveLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2812:2: (iv_rulePrimitiveLiteralExpCS= rulePrimitiveLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2813:2: iv_rulePrimitiveLiteralExpCS= rulePrimitiveLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePrimitiveLiteralExpCS_in_entryRulePrimitiveLiteralExpCS6694);
            iv_rulePrimitiveLiteralExpCS=rulePrimitiveLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimitiveLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrimitiveLiteralExpCS6704); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2820:1: rulePrimitiveLiteralExpCS returns [EObject current=null] : (this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS | this_StringLiteralExpCS_1= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_5= ruleNullLiteralExpCS ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2823:28: ( (this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS | this_StringLiteralExpCS_1= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_5= ruleNullLiteralExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2824:1: (this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS | this_StringLiteralExpCS_1= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_5= ruleNullLiteralExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2824:1: (this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS | this_StringLiteralExpCS_1= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_5= ruleNullLiteralExpCS )
            int alt52=6;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt52=1;
                }
                break;
            case RULE_SINGLE_QUOTED_STRING:
                {
                alt52=2;
                }
                break;
            case 70:
            case 71:
                {
                alt52=3;
                }
                break;
            case 42:
                {
                alt52=4;
                }
                break;
            case 72:
                {
                alt52=5;
                }
                break;
            case 73:
                {
                alt52=6;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2825:2: this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getNumberLiteralExpCSParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNumberLiteralExpCS_in_rulePrimitiveLiteralExpCS6754);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2838:2: this_StringLiteralExpCS_1= ruleStringLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getStringLiteralExpCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleStringLiteralExpCS_in_rulePrimitiveLiteralExpCS6784);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2851:2: this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getBooleanLiteralExpCSParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleBooleanLiteralExpCS_in_rulePrimitiveLiteralExpCS6814);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2864:2: this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getUnlimitedNaturalLiteralExpCSParserRuleCall_3()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUnlimitedNaturalLiteralExpCS_in_rulePrimitiveLiteralExpCS6844);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2877:2: this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getInvalidLiteralExpCSParserRuleCall_4()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleInvalidLiteralExpCS_in_rulePrimitiveLiteralExpCS6874);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2890:2: this_NullLiteralExpCS_5= ruleNullLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getNullLiteralExpCSParserRuleCall_5()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNullLiteralExpCS_in_rulePrimitiveLiteralExpCS6904);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2909:1: entryRuleTupleLiteralExpCS returns [EObject current=null] : iv_ruleTupleLiteralExpCS= ruleTupleLiteralExpCS EOF ;
    public final EObject entryRuleTupleLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTupleLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2910:2: (iv_ruleTupleLiteralExpCS= ruleTupleLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2911:2: iv_ruleTupleLiteralExpCS= ruleTupleLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTupleLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralExpCS_in_entryRuleTupleLiteralExpCS6939);
            iv_ruleTupleLiteralExpCS=ruleTupleLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTupleLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTupleLiteralExpCS6949); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2918:1: ruleTupleLiteralExpCS returns [EObject current=null] : (otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}' ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2921:28: ( (otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2922:1: (otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2922:1: (otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2922:3: otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleTupleLiteralExpCS6986); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getTupleLiteralExpCSAccess().getTupleKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleTupleLiteralExpCS6998); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getTupleLiteralExpCSAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2930:1: ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2931:1: (lv_ownedParts_2_0= ruleTupleLiteralPartCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2931:1: (lv_ownedParts_2_0= ruleTupleLiteralPartCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2932:3: lv_ownedParts_2_0= ruleTupleLiteralPartCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTupleLiteralExpCSAccess().getOwnedPartsTupleLiteralPartCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralPartCS_in_ruleTupleLiteralExpCS7019);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2948:2: (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==20) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2948:4: otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) )
            	    {
            	    otherlv_3=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleTupleLiteralExpCS7032); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getTupleLiteralExpCSAccess().getCommaKeyword_3_0());
            	          
            	    }
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2952:1: ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2953:1: (lv_ownedParts_4_0= ruleTupleLiteralPartCS )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2953:1: (lv_ownedParts_4_0= ruleTupleLiteralPartCS )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2954:3: lv_ownedParts_4_0= ruleTupleLiteralPartCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTupleLiteralExpCSAccess().getOwnedPartsTupleLiteralPartCSParserRuleCall_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralPartCS_in_ruleTupleLiteralExpCS7053);
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
            	    break loop53;
                }
            } while (true);

            otherlv_5=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleTupleLiteralExpCS7067); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2982:1: entryRuleTupleLiteralPartCS returns [EObject current=null] : iv_ruleTupleLiteralPartCS= ruleTupleLiteralPartCS EOF ;
    public final EObject entryRuleTupleLiteralPartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTupleLiteralPartCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2983:2: (iv_ruleTupleLiteralPartCS= ruleTupleLiteralPartCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2984:2: iv_ruleTupleLiteralPartCS= ruleTupleLiteralPartCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTupleLiteralPartCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralPartCS_in_entryRuleTupleLiteralPartCS7103);
            iv_ruleTupleLiteralPartCS=ruleTupleLiteralPartCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTupleLiteralPartCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTupleLiteralPartCS7113); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2991:1: ruleTupleLiteralPartCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) ) ) ;
    public final EObject ruleTupleLiteralPartCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;

        EObject lv_initExpression_4_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2994:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2995:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2995:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2995:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2995:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2996:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2996:1: (lv_name_0_0= ruleUnrestrictedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2997:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTupleLiteralPartCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleTupleLiteralPartCS7159);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3013:2: (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==31) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3013:4: otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                    {
                    otherlv_1=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleTupleLiteralPartCS7172); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getTupleLiteralPartCSAccess().getColonKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3017:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3018:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3018:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3019:3: lv_ownedType_2_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTupleLiteralPartCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleTupleLiteralPartCS7193);
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

            otherlv_3=(Token)match(input,48,FollowSets000.FOLLOW_48_in_ruleTupleLiteralPartCS7207); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getTupleLiteralPartCSAccess().getEqualsSignKeyword_2());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3039:1: ( (lv_initExpression_4_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3040:1: (lv_initExpression_4_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3040:1: (lv_initExpression_4_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3041:3: lv_initExpression_4_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTupleLiteralPartCSAccess().getInitExpressionExpCSParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleTupleLiteralPartCS7228);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3065:1: entryRuleNumberLiteralExpCS returns [EObject current=null] : iv_ruleNumberLiteralExpCS= ruleNumberLiteralExpCS EOF ;
    public final EObject entryRuleNumberLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3066:2: (iv_ruleNumberLiteralExpCS= ruleNumberLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3067:2: iv_ruleNumberLiteralExpCS= ruleNumberLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumberLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNumberLiteralExpCS_in_entryRuleNumberLiteralExpCS7264);
            iv_ruleNumberLiteralExpCS=ruleNumberLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumberLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNumberLiteralExpCS7274); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3074:1: ruleNumberLiteralExpCS returns [EObject current=null] : ( (lv_name_0_0= ruleNUMBER_LITERAL ) ) ;
    public final EObject ruleNumberLiteralExpCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3077:28: ( ( (lv_name_0_0= ruleNUMBER_LITERAL ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3078:1: ( (lv_name_0_0= ruleNUMBER_LITERAL ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3078:1: ( (lv_name_0_0= ruleNUMBER_LITERAL ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3079:1: (lv_name_0_0= ruleNUMBER_LITERAL )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3079:1: (lv_name_0_0= ruleNUMBER_LITERAL )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3080:3: lv_name_0_0= ruleNUMBER_LITERAL
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNumberLiteralExpCSAccess().getNameNUMBER_LITERALParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleNUMBER_LITERAL_in_ruleNumberLiteralExpCS7319);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3104:1: entryRuleStringLiteralExpCS returns [EObject current=null] : iv_ruleStringLiteralExpCS= ruleStringLiteralExpCS EOF ;
    public final EObject entryRuleStringLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3105:2: (iv_ruleStringLiteralExpCS= ruleStringLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3106:2: iv_ruleStringLiteralExpCS= ruleStringLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStringLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleStringLiteralExpCS_in_entryRuleStringLiteralExpCS7354);
            iv_ruleStringLiteralExpCS=ruleStringLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStringLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleStringLiteralExpCS7364); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3113:1: ruleStringLiteralExpCS returns [EObject current=null] : ( (lv_name_0_0= ruleStringLiteral ) )+ ;
    public final EObject ruleStringLiteralExpCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3116:28: ( ( (lv_name_0_0= ruleStringLiteral ) )+ )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3117:1: ( (lv_name_0_0= ruleStringLiteral ) )+
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3117:1: ( (lv_name_0_0= ruleStringLiteral ) )+
            int cnt55=0;
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==RULE_SINGLE_QUOTED_STRING) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3118:1: (lv_name_0_0= ruleStringLiteral )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3118:1: (lv_name_0_0= ruleStringLiteral )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3119:3: lv_name_0_0= ruleStringLiteral
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getStringLiteralExpCSAccess().getNameStringLiteralParserRuleCall_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleStringLiteral_in_ruleStringLiteralExpCS7409);
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
            	    if ( cnt55 >= 1 ) break loop55;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(55, input);
                        throw eee;
                }
                cnt55++;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3143:1: entryRuleBooleanLiteralExpCS returns [EObject current=null] : iv_ruleBooleanLiteralExpCS= ruleBooleanLiteralExpCS EOF ;
    public final EObject entryRuleBooleanLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3144:2: (iv_ruleBooleanLiteralExpCS= ruleBooleanLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3145:2: iv_ruleBooleanLiteralExpCS= ruleBooleanLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBooleanLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleBooleanLiteralExpCS_in_entryRuleBooleanLiteralExpCS7445);
            iv_ruleBooleanLiteralExpCS=ruleBooleanLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBooleanLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBooleanLiteralExpCS7455); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3152:1: ruleBooleanLiteralExpCS returns [EObject current=null] : ( ( (lv_name_0_0= 'true' ) ) | ( (lv_name_1_0= 'false' ) ) ) ;
    public final EObject ruleBooleanLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3155:28: ( ( ( (lv_name_0_0= 'true' ) ) | ( (lv_name_1_0= 'false' ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3156:1: ( ( (lv_name_0_0= 'true' ) ) | ( (lv_name_1_0= 'false' ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3156:1: ( ( (lv_name_0_0= 'true' ) ) | ( (lv_name_1_0= 'false' ) ) )
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==70) ) {
                alt56=1;
            }
            else if ( (LA56_0==71) ) {
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3156:2: ( (lv_name_0_0= 'true' ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3156:2: ( (lv_name_0_0= 'true' ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3157:1: (lv_name_0_0= 'true' )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3157:1: (lv_name_0_0= 'true' )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3158:3: lv_name_0_0= 'true'
                    {
                    lv_name_0_0=(Token)match(input,70,FollowSets000.FOLLOW_70_in_ruleBooleanLiteralExpCS7498); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3172:6: ( (lv_name_1_0= 'false' ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3172:6: ( (lv_name_1_0= 'false' ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3173:1: (lv_name_1_0= 'false' )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3173:1: (lv_name_1_0= 'false' )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3174:3: lv_name_1_0= 'false'
                    {
                    lv_name_1_0=(Token)match(input,71,FollowSets000.FOLLOW_71_in_ruleBooleanLiteralExpCS7535); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3195:1: entryRuleUnlimitedNaturalLiteralExpCS returns [EObject current=null] : iv_ruleUnlimitedNaturalLiteralExpCS= ruleUnlimitedNaturalLiteralExpCS EOF ;
    public final EObject entryRuleUnlimitedNaturalLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnlimitedNaturalLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3196:2: (iv_ruleUnlimitedNaturalLiteralExpCS= ruleUnlimitedNaturalLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3197:2: iv_ruleUnlimitedNaturalLiteralExpCS= ruleUnlimitedNaturalLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnlimitedNaturalLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnlimitedNaturalLiteralExpCS_in_entryRuleUnlimitedNaturalLiteralExpCS7584);
            iv_ruleUnlimitedNaturalLiteralExpCS=ruleUnlimitedNaturalLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnlimitedNaturalLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnlimitedNaturalLiteralExpCS7594); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3204:1: ruleUnlimitedNaturalLiteralExpCS returns [EObject current=null] : ( () otherlv_1= '*' ) ;
    public final EObject ruleUnlimitedNaturalLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3207:28: ( ( () otherlv_1= '*' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3208:1: ( () otherlv_1= '*' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3208:1: ( () otherlv_1= '*' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3208:2: () otherlv_1= '*'
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3208:2: ()
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3209:2: 
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

            otherlv_1=(Token)match(input,42,FollowSets000.FOLLOW_42_in_ruleUnlimitedNaturalLiteralExpCS7643); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3229:1: entryRuleInvalidLiteralExpCS returns [EObject current=null] : iv_ruleInvalidLiteralExpCS= ruleInvalidLiteralExpCS EOF ;
    public final EObject entryRuleInvalidLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInvalidLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3230:2: (iv_ruleInvalidLiteralExpCS= ruleInvalidLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3231:2: iv_ruleInvalidLiteralExpCS= ruleInvalidLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInvalidLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleInvalidLiteralExpCS_in_entryRuleInvalidLiteralExpCS7679);
            iv_ruleInvalidLiteralExpCS=ruleInvalidLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInvalidLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleInvalidLiteralExpCS7689); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3238:1: ruleInvalidLiteralExpCS returns [EObject current=null] : ( () otherlv_1= 'invalid' ) ;
    public final EObject ruleInvalidLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3241:28: ( ( () otherlv_1= 'invalid' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3242:1: ( () otherlv_1= 'invalid' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3242:1: ( () otherlv_1= 'invalid' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3242:2: () otherlv_1= 'invalid'
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3242:2: ()
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3243:2: 
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

            otherlv_1=(Token)match(input,72,FollowSets000.FOLLOW_72_in_ruleInvalidLiteralExpCS7738); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3263:1: entryRuleNullLiteralExpCS returns [EObject current=null] : iv_ruleNullLiteralExpCS= ruleNullLiteralExpCS EOF ;
    public final EObject entryRuleNullLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3264:2: (iv_ruleNullLiteralExpCS= ruleNullLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3265:2: iv_ruleNullLiteralExpCS= ruleNullLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNullLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNullLiteralExpCS_in_entryRuleNullLiteralExpCS7774);
            iv_ruleNullLiteralExpCS=ruleNullLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNullLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNullLiteralExpCS7784); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3272:1: ruleNullLiteralExpCS returns [EObject current=null] : ( () otherlv_1= 'null' ) ;
    public final EObject ruleNullLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3275:28: ( ( () otherlv_1= 'null' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3276:1: ( () otherlv_1= 'null' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3276:1: ( () otherlv_1= 'null' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3276:2: () otherlv_1= 'null'
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3276:2: ()
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3277:2: 
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

            otherlv_1=(Token)match(input,73,FollowSets000.FOLLOW_73_in_ruleNullLiteralExpCS7833); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3297:1: entryRuleTypeLiteralCS returns [EObject current=null] : iv_ruleTypeLiteralCS= ruleTypeLiteralCS EOF ;
    public final EObject entryRuleTypeLiteralCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeLiteralCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3298:2: (iv_ruleTypeLiteralCS= ruleTypeLiteralCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3299:2: iv_ruleTypeLiteralCS= ruleTypeLiteralCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeLiteralCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralCS_in_entryRuleTypeLiteralCS7869);
            iv_ruleTypeLiteralCS=ruleTypeLiteralCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeLiteralCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeLiteralCS7879); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3306:1: ruleTypeLiteralCS returns [EObject current=null] : (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS | this_CollectionTypeCS_1= ruleCollectionTypeCS | this_TupleTypeCS_2= ruleTupleTypeCS ) ;
    public final EObject ruleTypeLiteralCS() throws RecognitionException {
        EObject current = null;

        EObject this_PrimitiveTypeCS_0 = null;

        EObject this_CollectionTypeCS_1 = null;

        EObject this_TupleTypeCS_2 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3309:28: ( (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS | this_CollectionTypeCS_1= ruleCollectionTypeCS | this_TupleTypeCS_2= ruleTupleTypeCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3310:1: (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS | this_CollectionTypeCS_1= ruleCollectionTypeCS | this_TupleTypeCS_2= ruleTupleTypeCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3310:1: (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS | this_CollectionTypeCS_1= ruleCollectionTypeCS | this_TupleTypeCS_2= ruleTupleTypeCS )
            int alt57=3;
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
                alt57=1;
                }
                break;
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
                {
                alt57=2;
                }
                break;
            case 55:
                {
                alt57=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;
            }

            switch (alt57) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3311:2: this_PrimitiveTypeCS_0= rulePrimitiveTypeCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeLiteralCSAccess().getPrimitiveTypeCSParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrimitiveTypeCS_in_ruleTypeLiteralCS7929);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3324:2: this_CollectionTypeCS_1= ruleCollectionTypeCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeLiteralCSAccess().getCollectionTypeCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCollectionTypeCS_in_ruleTypeLiteralCS7959);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3337:2: this_TupleTypeCS_2= ruleTupleTypeCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeLiteralCSAccess().getTupleTypeCSParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTupleTypeCS_in_ruleTypeLiteralCS7989);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3356:1: entryRuleTypeLiteralExpCS returns [EObject current=null] : iv_ruleTypeLiteralExpCS= ruleTypeLiteralExpCS EOF ;
    public final EObject entryRuleTypeLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3357:2: (iv_ruleTypeLiteralExpCS= ruleTypeLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3358:2: iv_ruleTypeLiteralExpCS= ruleTypeLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralExpCS_in_entryRuleTypeLiteralExpCS8024);
            iv_ruleTypeLiteralExpCS=ruleTypeLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeLiteralExpCS8034); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3365:1: ruleTypeLiteralExpCS returns [EObject current=null] : ( (lv_ownedType_0_0= ruleTypeLiteralCS ) ) ;
    public final EObject ruleTypeLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject lv_ownedType_0_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3368:28: ( ( (lv_ownedType_0_0= ruleTypeLiteralCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3369:1: ( (lv_ownedType_0_0= ruleTypeLiteralCS ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3369:1: ( (lv_ownedType_0_0= ruleTypeLiteralCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3370:1: (lv_ownedType_0_0= ruleTypeLiteralCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3370:1: (lv_ownedType_0_0= ruleTypeLiteralCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3371:3: lv_ownedType_0_0= ruleTypeLiteralCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypeLiteralExpCSAccess().getOwnedTypeTypeLiteralCSParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralCS_in_ruleTypeLiteralExpCS8079);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3395:1: entryRuleTypeNameExpCS returns [EObject current=null] : iv_ruleTypeNameExpCS= ruleTypeNameExpCS EOF ;
    public final EObject entryRuleTypeNameExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeNameExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3396:2: (iv_ruleTypeNameExpCS= ruleTypeNameExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3397:2: iv_ruleTypeNameExpCS= ruleTypeNameExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeNameExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeNameExpCS_in_entryRuleTypeNameExpCS8114);
            iv_ruleTypeNameExpCS=ruleTypeNameExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeNameExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeNameExpCS8124); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3404:1: ruleTypeNameExpCS returns [EObject current=null] : ( ( ( ( ( ruleUnrestrictedName ) ) otherlv_1= '::' ( ( ( ruleUnreservedName ) ) otherlv_3= '::' )* ) ( ( ruleUnreservedName ) ) ) | ( ( ruleUnrestrictedName ) ) ) ;
    public final EObject ruleTypeNameExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3407:28: ( ( ( ( ( ( ruleUnrestrictedName ) ) otherlv_1= '::' ( ( ( ruleUnreservedName ) ) otherlv_3= '::' )* ) ( ( ruleUnreservedName ) ) ) | ( ( ruleUnrestrictedName ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3408:1: ( ( ( ( ( ruleUnrestrictedName ) ) otherlv_1= '::' ( ( ( ruleUnreservedName ) ) otherlv_3= '::' )* ) ( ( ruleUnreservedName ) ) ) | ( ( ruleUnrestrictedName ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3408:1: ( ( ( ( ( ruleUnrestrictedName ) ) otherlv_1= '::' ( ( ( ruleUnreservedName ) ) otherlv_3= '::' )* ) ( ( ruleUnreservedName ) ) ) | ( ( ruleUnrestrictedName ) ) )
            int alt59=2;
            alt59 = dfa59.predict(input);
            switch (alt59) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3408:2: ( ( ( ( ruleUnrestrictedName ) ) otherlv_1= '::' ( ( ( ruleUnreservedName ) ) otherlv_3= '::' )* ) ( ( ruleUnreservedName ) ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3408:2: ( ( ( ( ruleUnrestrictedName ) ) otherlv_1= '::' ( ( ( ruleUnreservedName ) ) otherlv_3= '::' )* ) ( ( ruleUnreservedName ) ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3408:3: ( ( ( ruleUnrestrictedName ) ) otherlv_1= '::' ( ( ( ruleUnreservedName ) ) otherlv_3= '::' )* ) ( ( ruleUnreservedName ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3408:3: ( ( ( ruleUnrestrictedName ) ) otherlv_1= '::' ( ( ( ruleUnreservedName ) ) otherlv_3= '::' )* )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3408:4: ( ( ruleUnrestrictedName ) ) otherlv_1= '::' ( ( ( ruleUnreservedName ) ) otherlv_3= '::' )*
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3408:4: ( ( ruleUnrestrictedName ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3409:1: ( ruleUnrestrictedName )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3409:1: ( ruleUnrestrictedName )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3410:3: ruleUnrestrictedName
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
                    pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleTypeNameExpCS8178);
                    ruleUnrestrictedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_1=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleTypeNameExpCS8190); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getTypeNameExpCSAccess().getColonColonKeyword_0_0_1());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3430:1: ( ( ( ruleUnreservedName ) ) otherlv_3= '::' )*
                    loop58:
                    do {
                        int alt58=2;
                        alt58 = dfa58.predict(input);
                        switch (alt58) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3430:2: ( ( ruleUnreservedName ) ) otherlv_3= '::'
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3430:2: ( ( ruleUnreservedName ) )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3431:1: ( ruleUnreservedName )
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3431:1: ( ruleUnreservedName )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3432:3: ruleUnreservedName
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
                    	    pushFollow(FollowSets000.FOLLOW_ruleUnreservedName_in_ruleTypeNameExpCS8218);
                    	    ruleUnreservedName();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }

                    	    otherlv_3=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleTypeNameExpCS8230); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getTypeNameExpCSAccess().getColonColonKeyword_0_0_2_1());
                    	          
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop58;
                        }
                    } while (true);


                    }

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3452:4: ( ( ruleUnreservedName ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3453:1: ( ruleUnreservedName )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3453:1: ( ruleUnreservedName )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3454:3: ruleUnreservedName
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
                    pushFollow(FollowSets000.FOLLOW_ruleUnreservedName_in_ruleTypeNameExpCS8260);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3471:6: ( ( ruleUnrestrictedName ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3471:6: ( ( ruleUnrestrictedName ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3472:1: ( ruleUnrestrictedName )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3472:1: ( ruleUnrestrictedName )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3473:3: ruleUnrestrictedName
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
                    pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleTypeNameExpCS8294);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3497:1: entryRuleTypeExpCS returns [EObject current=null] : iv_ruleTypeExpCS= ruleTypeExpCS EOF ;
    public final EObject entryRuleTypeExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3498:2: (iv_ruleTypeExpCS= ruleTypeExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3499:2: iv_ruleTypeExpCS= ruleTypeExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_entryRuleTypeExpCS8330);
            iv_ruleTypeExpCS=ruleTypeExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeExpCS8340); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3506:1: ruleTypeExpCS returns [EObject current=null] : (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS ) ;
    public final EObject ruleTypeExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_TypeNameExpCS_0 = null;

        EObject this_TypeLiteralCS_1 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3509:28: ( (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3510:1: (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3510:1: (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS )
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( ((LA60_0>=RULE_SIMPLE_ID && LA60_0<=RULE_ESCAPED_ID)||LA60_0==14||LA60_0==19||(LA60_0>=21 && LA60_0<=22)||(LA60_0>=24 && LA60_0<=27)||LA60_0==32||LA60_0==35||(LA60_0>=37 && LA60_0<=38)) ) {
                alt60=1;
            }
            else if ( ((LA60_0>=55 && LA60_0<=68)) ) {
                alt60=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 60, 0, input);

                throw nvae;
            }
            switch (alt60) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3511:2: this_TypeNameExpCS_0= ruleTypeNameExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeExpCSAccess().getTypeNameExpCSParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeNameExpCS_in_ruleTypeExpCS8390);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3524:2: this_TypeLiteralCS_1= ruleTypeLiteralCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeExpCSAccess().getTypeLiteralCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralCS_in_ruleTypeExpCS8420);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3543:1: entryRuleExpCS returns [EObject current=null] : iv_ruleExpCS= ruleExpCS EOF ;
    public final EObject entryRuleExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3544:2: (iv_ruleExpCS= ruleExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3545:2: iv_ruleExpCS= ruleExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_entryRuleExpCS8455);
            iv_ruleExpCS=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleExpCS8465); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3552:1: ruleExpCS returns [EObject current=null] : this_InfixedExpCS_0= ruleInfixedExpCS ;
    public final EObject ruleExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_InfixedExpCS_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3555:28: (this_InfixedExpCS_0= ruleInfixedExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3557:2: this_InfixedExpCS_0= ruleInfixedExpCS
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getExpCSAccess().getInfixedExpCSParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleInfixedExpCS_in_ruleExpCS8514);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3576:1: entryRuleInfixedExpCS returns [EObject current=null] : iv_ruleInfixedExpCS= ruleInfixedExpCS EOF ;
    public final EObject entryRuleInfixedExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInfixedExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3577:2: (iv_ruleInfixedExpCS= ruleInfixedExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3578:2: iv_ruleInfixedExpCS= ruleInfixedExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInfixedExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleInfixedExpCS_in_entryRuleInfixedExpCS8548);
            iv_ruleInfixedExpCS=ruleInfixedExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInfixedExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleInfixedExpCS8558); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3585:1: ruleInfixedExpCS returns [EObject current=null] : (this_PrefixedExpCS_0= rulePrefixedExpCS ( () ( ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) )+ )? ) ;
    public final EObject ruleInfixedExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_PrefixedExpCS_0 = null;

        EObject lv_ownedOperator_2_0 = null;

        EObject lv_ownedExpression_3_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3588:28: ( (this_PrefixedExpCS_0= rulePrefixedExpCS ( () ( ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) )+ )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3589:1: (this_PrefixedExpCS_0= rulePrefixedExpCS ( () ( ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) )+ )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3589:1: (this_PrefixedExpCS_0= rulePrefixedExpCS ( () ( ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) )+ )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3590:2: this_PrefixedExpCS_0= rulePrefixedExpCS ( () ( ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) )+ )?
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getInfixedExpCSAccess().getPrefixedExpCSParserRuleCall_0()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_rulePrefixedExpCS_in_ruleInfixedExpCS8608);
            this_PrefixedExpCS_0=rulePrefixedExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_PrefixedExpCS_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3601:1: ( () ( ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) )+ )?
            int alt62=2;
            alt62 = dfa62.predict(input);
            switch (alt62) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3601:2: () ( ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) )+
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3601:2: ()
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3602:2: 
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

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3610:2: ( ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) )+
                    int cnt61=0;
                    loop61:
                    do {
                        int alt61=2;
                        alt61 = dfa61.predict(input);
                        switch (alt61) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3610:3: ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) )
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3610:3: ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3611:1: (lv_ownedOperator_2_0= ruleBinaryOperatorCS )
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3611:1: (lv_ownedOperator_2_0= ruleBinaryOperatorCS )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3612:3: lv_ownedOperator_2_0= ruleBinaryOperatorCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getInfixedExpCSAccess().getOwnedOperatorBinaryOperatorCSParserRuleCall_1_1_0_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleBinaryOperatorCS_in_ruleInfixedExpCS8642);
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

                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3628:2: ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3629:1: (lv_ownedExpression_3_0= rulePrefixedExpCS )
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3629:1: (lv_ownedExpression_3_0= rulePrefixedExpCS )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3630:3: lv_ownedExpression_3_0= rulePrefixedExpCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getInfixedExpCSAccess().getOwnedExpressionPrefixedExpCSParserRuleCall_1_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_rulePrefixedExpCS_in_ruleInfixedExpCS8663);
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
                    	    if ( cnt61 >= 1 ) break loop61;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(61, input);
                                throw eee;
                        }
                        cnt61++;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3654:1: entryRuleBinaryOperatorCS returns [EObject current=null] : iv_ruleBinaryOperatorCS= ruleBinaryOperatorCS EOF ;
    public final EObject entryRuleBinaryOperatorCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinaryOperatorCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3655:2: (iv_ruleBinaryOperatorCS= ruleBinaryOperatorCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3656:2: iv_ruleBinaryOperatorCS= ruleBinaryOperatorCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBinaryOperatorCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleBinaryOperatorCS_in_entryRuleBinaryOperatorCS8703);
            iv_ruleBinaryOperatorCS=ruleBinaryOperatorCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBinaryOperatorCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBinaryOperatorCS8713); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3663:1: ruleBinaryOperatorCS returns [EObject current=null] : (this_InfixOperatorCS_0= ruleInfixOperatorCS | this_NavigationOperatorCS_1= ruleNavigationOperatorCS ) ;
    public final EObject ruleBinaryOperatorCS() throws RecognitionException {
        EObject current = null;

        EObject this_InfixOperatorCS_0 = null;

        EObject this_NavigationOperatorCS_1 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3666:28: ( (this_InfixOperatorCS_0= ruleInfixOperatorCS | this_NavigationOperatorCS_1= ruleNavigationOperatorCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3667:1: (this_InfixOperatorCS_0= ruleInfixOperatorCS | this_NavigationOperatorCS_1= ruleNavigationOperatorCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3667:1: (this_InfixOperatorCS_0= ruleInfixOperatorCS | this_NavigationOperatorCS_1= ruleNavigationOperatorCS )
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( ((LA63_0>=39 && LA63_0<=40)||(LA63_0>=42 && LA63_0<=53)) ) {
                alt63=1;
            }
            else if ( (LA63_0==36||LA63_0==54) ) {
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3668:2: this_InfixOperatorCS_0= ruleInfixOperatorCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBinaryOperatorCSAccess().getInfixOperatorCSParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleInfixOperatorCS_in_ruleBinaryOperatorCS8763);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3681:2: this_NavigationOperatorCS_1= ruleNavigationOperatorCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBinaryOperatorCSAccess().getNavigationOperatorCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNavigationOperatorCS_in_ruleBinaryOperatorCS8793);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3700:1: entryRuleInfixOperatorCS returns [EObject current=null] : iv_ruleInfixOperatorCS= ruleInfixOperatorCS EOF ;
    public final EObject entryRuleInfixOperatorCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInfixOperatorCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3701:2: (iv_ruleInfixOperatorCS= ruleInfixOperatorCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3702:2: iv_ruleInfixOperatorCS= ruleInfixOperatorCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInfixOperatorCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleInfixOperatorCS_in_entryRuleInfixOperatorCS8828);
            iv_ruleInfixOperatorCS=ruleInfixOperatorCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInfixOperatorCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleInfixOperatorCS8838); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3709:1: ruleInfixOperatorCS returns [EObject current=null] : ( (lv_name_0_0= ruleInfixOperator ) ) ;
    public final EObject ruleInfixOperatorCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3712:28: ( ( (lv_name_0_0= ruleInfixOperator ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3713:1: ( (lv_name_0_0= ruleInfixOperator ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3713:1: ( (lv_name_0_0= ruleInfixOperator ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3714:1: (lv_name_0_0= ruleInfixOperator )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3714:1: (lv_name_0_0= ruleInfixOperator )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3715:3: lv_name_0_0= ruleInfixOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getInfixOperatorCSAccess().getNameInfixOperatorParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleInfixOperator_in_ruleInfixOperatorCS8883);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3739:1: entryRuleNavigationOperatorCS returns [EObject current=null] : iv_ruleNavigationOperatorCS= ruleNavigationOperatorCS EOF ;
    public final EObject entryRuleNavigationOperatorCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigationOperatorCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3740:2: (iv_ruleNavigationOperatorCS= ruleNavigationOperatorCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3741:2: iv_ruleNavigationOperatorCS= ruleNavigationOperatorCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigationOperatorCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigationOperatorCS_in_entryRuleNavigationOperatorCS8918);
            iv_ruleNavigationOperatorCS=ruleNavigationOperatorCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigationOperatorCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigationOperatorCS8928); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3748:1: ruleNavigationOperatorCS returns [EObject current=null] : ( (lv_name_0_0= ruleNavigationOperator ) ) ;
    public final EObject ruleNavigationOperatorCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3751:28: ( ( (lv_name_0_0= ruleNavigationOperator ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3752:1: ( (lv_name_0_0= ruleNavigationOperator ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3752:1: ( (lv_name_0_0= ruleNavigationOperator ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3753:1: (lv_name_0_0= ruleNavigationOperator )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3753:1: (lv_name_0_0= ruleNavigationOperator )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3754:3: lv_name_0_0= ruleNavigationOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNavigationOperatorCSAccess().getNameNavigationOperatorParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigationOperator_in_ruleNavigationOperatorCS8973);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3778:1: entryRulePrefixedExpCS returns [EObject current=null] : iv_rulePrefixedExpCS= rulePrefixedExpCS EOF ;
    public final EObject entryRulePrefixedExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrefixedExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3779:2: (iv_rulePrefixedExpCS= rulePrefixedExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3780:2: iv_rulePrefixedExpCS= rulePrefixedExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrefixedExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePrefixedExpCS_in_entryRulePrefixedExpCS9008);
            iv_rulePrefixedExpCS=rulePrefixedExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrefixedExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrefixedExpCS9018); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3787:1: rulePrefixedExpCS returns [EObject current=null] : (this_PrimaryExpCS_0= rulePrimaryExpCS | ( () ( (lv_ownedOperator_2_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_3_0= rulePrimaryExpCS ) ) ) ) ;
    public final EObject rulePrefixedExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_PrimaryExpCS_0 = null;

        EObject lv_ownedOperator_2_0 = null;

        EObject lv_ownedExpression_3_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3790:28: ( (this_PrimaryExpCS_0= rulePrimaryExpCS | ( () ( (lv_ownedOperator_2_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_3_0= rulePrimaryExpCS ) ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3791:1: (this_PrimaryExpCS_0= rulePrimaryExpCS | ( () ( (lv_ownedOperator_2_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_3_0= rulePrimaryExpCS ) ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3791:1: (this_PrimaryExpCS_0= rulePrimaryExpCS | ( () ( (lv_ownedOperator_2_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_3_0= rulePrimaryExpCS ) ) ) )
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( ((LA65_0>=RULE_SIMPLE_ID && LA65_0<=RULE_SINGLE_QUOTED_STRING)||LA65_0==14||LA65_0==19||(LA65_0>=21 && LA65_0<=22)||(LA65_0>=24 && LA65_0<=28)||LA65_0==32||LA65_0==35||(LA65_0>=37 && LA65_0<=38)||LA65_0==42||(LA65_0>=55 && LA65_0<=68)||(LA65_0>=70 && LA65_0<=73)||LA65_0==76||(LA65_0>=80 && LA65_0<=81)) ) {
                alt65=1;
            }
            else if ( ((LA65_0>=40 && LA65_0<=41)) ) {
                alt65=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 65, 0, input);

                throw nvae;
            }
            switch (alt65) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3792:2: this_PrimaryExpCS_0= rulePrimaryExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrefixedExpCSAccess().getPrimaryExpCSParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrimaryExpCS_in_rulePrefixedExpCS9068);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3804:6: ( () ( (lv_ownedOperator_2_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_3_0= rulePrimaryExpCS ) ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3804:6: ( () ( (lv_ownedOperator_2_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_3_0= rulePrimaryExpCS ) ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3804:7: () ( (lv_ownedOperator_2_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_3_0= rulePrimaryExpCS ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3804:7: ()
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3805:2: 
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

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3813:2: ( (lv_ownedOperator_2_0= ruleUnaryOperatorCS ) )+
                    int cnt64=0;
                    loop64:
                    do {
                        int alt64=2;
                        int LA64_0 = input.LA(1);

                        if ( ((LA64_0>=40 && LA64_0<=41)) ) {
                            alt64=1;
                        }


                        switch (alt64) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3814:1: (lv_ownedOperator_2_0= ruleUnaryOperatorCS )
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3814:1: (lv_ownedOperator_2_0= ruleUnaryOperatorCS )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3815:3: lv_ownedOperator_2_0= ruleUnaryOperatorCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getPrefixedExpCSAccess().getOwnedOperatorUnaryOperatorCSParserRuleCall_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleUnaryOperatorCS_in_rulePrefixedExpCS9107);
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
                    	    if ( cnt64 >= 1 ) break loop64;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(64, input);
                                throw eee;
                        }
                        cnt64++;
                    } while (true);

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3831:3: ( (lv_ownedExpression_3_0= rulePrimaryExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3832:1: (lv_ownedExpression_3_0= rulePrimaryExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3832:1: (lv_ownedExpression_3_0= rulePrimaryExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3833:3: lv_ownedExpression_3_0= rulePrimaryExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrefixedExpCSAccess().getOwnedExpressionPrimaryExpCSParserRuleCall_1_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrimaryExpCS_in_rulePrefixedExpCS9129);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3857:1: entryRuleUnaryOperatorCS returns [EObject current=null] : iv_ruleUnaryOperatorCS= ruleUnaryOperatorCS EOF ;
    public final EObject entryRuleUnaryOperatorCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryOperatorCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3858:2: (iv_ruleUnaryOperatorCS= ruleUnaryOperatorCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3859:2: iv_ruleUnaryOperatorCS= ruleUnaryOperatorCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryOperatorCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnaryOperatorCS_in_entryRuleUnaryOperatorCS9166);
            iv_ruleUnaryOperatorCS=ruleUnaryOperatorCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnaryOperatorCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnaryOperatorCS9176); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3866:1: ruleUnaryOperatorCS returns [EObject current=null] : ( (lv_name_0_0= rulePrefixOperator ) ) ;
    public final EObject ruleUnaryOperatorCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3869:28: ( ( (lv_name_0_0= rulePrefixOperator ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3870:1: ( (lv_name_0_0= rulePrefixOperator ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3870:1: ( (lv_name_0_0= rulePrefixOperator ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3871:1: (lv_name_0_0= rulePrefixOperator )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3871:1: (lv_name_0_0= rulePrefixOperator )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3872:3: lv_name_0_0= rulePrefixOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getUnaryOperatorCSAccess().getNamePrefixOperatorParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_rulePrefixOperator_in_ruleUnaryOperatorCS9221);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3896:1: entryRulePrimaryExpCS returns [EObject current=null] : iv_rulePrimaryExpCS= rulePrimaryExpCS EOF ;
    public final EObject entryRulePrimaryExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3897:2: (iv_rulePrimaryExpCS= rulePrimaryExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3898:2: iv_rulePrimaryExpCS= rulePrimaryExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimaryExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePrimaryExpCS_in_entryRulePrimaryExpCS9256);
            iv_rulePrimaryExpCS=rulePrimaryExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimaryExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrimaryExpCS9266); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3905:1: rulePrimaryExpCS returns [EObject current=null] : (this_NavigatingExpCS_0= ruleNavigatingExpCS | this_SelfExpCS_1= ruleSelfExpCS | this_PrimitiveLiteralExpCS_2= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_3= ruleTupleLiteralExpCS | this_CollectionLiteralExpCS_4= ruleCollectionLiteralExpCS | this_TypeLiteralExpCS_5= ruleTypeLiteralExpCS | this_LetExpCS_6= ruleLetExpCS | this_IfExpCS_7= ruleIfExpCS | this_NestedExpCS_8= ruleNestedExpCS ) ;
    public final EObject rulePrimaryExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_NavigatingExpCS_0 = null;

        EObject this_SelfExpCS_1 = null;

        EObject this_PrimitiveLiteralExpCS_2 = null;

        EObject this_TupleLiteralExpCS_3 = null;

        EObject this_CollectionLiteralExpCS_4 = null;

        EObject this_TypeLiteralExpCS_5 = null;

        EObject this_LetExpCS_6 = null;

        EObject this_IfExpCS_7 = null;

        EObject this_NestedExpCS_8 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3908:28: ( (this_NavigatingExpCS_0= ruleNavigatingExpCS | this_SelfExpCS_1= ruleSelfExpCS | this_PrimitiveLiteralExpCS_2= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_3= ruleTupleLiteralExpCS | this_CollectionLiteralExpCS_4= ruleCollectionLiteralExpCS | this_TypeLiteralExpCS_5= ruleTypeLiteralExpCS | this_LetExpCS_6= ruleLetExpCS | this_IfExpCS_7= ruleIfExpCS | this_NestedExpCS_8= ruleNestedExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3909:1: (this_NavigatingExpCS_0= ruleNavigatingExpCS | this_SelfExpCS_1= ruleSelfExpCS | this_PrimitiveLiteralExpCS_2= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_3= ruleTupleLiteralExpCS | this_CollectionLiteralExpCS_4= ruleCollectionLiteralExpCS | this_TypeLiteralExpCS_5= ruleTypeLiteralExpCS | this_LetExpCS_6= ruleLetExpCS | this_IfExpCS_7= ruleIfExpCS | this_NestedExpCS_8= ruleNestedExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3909:1: (this_NavigatingExpCS_0= ruleNavigatingExpCS | this_SelfExpCS_1= ruleSelfExpCS | this_PrimitiveLiteralExpCS_2= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_3= ruleTupleLiteralExpCS | this_CollectionLiteralExpCS_4= ruleCollectionLiteralExpCS | this_TypeLiteralExpCS_5= ruleTypeLiteralExpCS | this_LetExpCS_6= ruleLetExpCS | this_IfExpCS_7= ruleIfExpCS | this_NestedExpCS_8= ruleNestedExpCS )
            int alt66=9;
            alt66 = dfa66.predict(input);
            switch (alt66) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3910:2: this_NavigatingExpCS_0= ruleNavigatingExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getNavigatingExpCSParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNavigatingExpCS_in_rulePrimaryExpCS9316);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3923:2: this_SelfExpCS_1= ruleSelfExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getSelfExpCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSelfExpCS_in_rulePrimaryExpCS9346);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3936:2: this_PrimitiveLiteralExpCS_2= rulePrimitiveLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getPrimitiveLiteralExpCSParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrimitiveLiteralExpCS_in_rulePrimaryExpCS9376);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3949:2: this_TupleLiteralExpCS_3= ruleTupleLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getTupleLiteralExpCSParserRuleCall_3()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralExpCS_in_rulePrimaryExpCS9406);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3962:2: this_CollectionLiteralExpCS_4= ruleCollectionLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getCollectionLiteralExpCSParserRuleCall_4()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteralExpCS_in_rulePrimaryExpCS9436);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3975:2: this_TypeLiteralExpCS_5= ruleTypeLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getTypeLiteralExpCSParserRuleCall_5()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralExpCS_in_rulePrimaryExpCS9466);
                    this_TypeLiteralExpCS_5=ruleTypeLiteralExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_TypeLiteralExpCS_5; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 7 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3988:2: this_LetExpCS_6= ruleLetExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getLetExpCSParserRuleCall_6()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLetExpCS_in_rulePrimaryExpCS9496);
                    this_LetExpCS_6=ruleLetExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_LetExpCS_6; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 8 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4001:2: this_IfExpCS_7= ruleIfExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getIfExpCSParserRuleCall_7()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleIfExpCS_in_rulePrimaryExpCS9526);
                    this_IfExpCS_7=ruleIfExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_IfExpCS_7; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 9 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4014:2: this_NestedExpCS_8= ruleNestedExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getNestedExpCSParserRuleCall_8()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNestedExpCS_in_rulePrimaryExpCS9556);
                    this_NestedExpCS_8=ruleNestedExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_NestedExpCS_8; 
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4033:1: entryRuleNameExpCS returns [EObject current=null] : iv_ruleNameExpCS= ruleNameExpCS EOF ;
    public final EObject entryRuleNameExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNameExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4034:2: (iv_ruleNameExpCS= ruleNameExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4035:2: iv_ruleNameExpCS= ruleNameExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNameExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNameExpCS_in_entryRuleNameExpCS9591);
            iv_ruleNameExpCS=ruleNameExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNameExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNameExpCS9601); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4042:1: ruleNameExpCS returns [EObject current=null] : ( ( ( ( ( ruleUnrestrictedName ) ) otherlv_1= '::' ( ( ( ruleUnreservedName ) ) otherlv_3= '::' )* ) ( ( ruleUnreservedName ) ) ) | ( ( ruleUnrestrictedName ) ) ) ;
    public final EObject ruleNameExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4045:28: ( ( ( ( ( ( ruleUnrestrictedName ) ) otherlv_1= '::' ( ( ( ruleUnreservedName ) ) otherlv_3= '::' )* ) ( ( ruleUnreservedName ) ) ) | ( ( ruleUnrestrictedName ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4046:1: ( ( ( ( ( ruleUnrestrictedName ) ) otherlv_1= '::' ( ( ( ruleUnreservedName ) ) otherlv_3= '::' )* ) ( ( ruleUnreservedName ) ) ) | ( ( ruleUnrestrictedName ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4046:1: ( ( ( ( ( ruleUnrestrictedName ) ) otherlv_1= '::' ( ( ( ruleUnreservedName ) ) otherlv_3= '::' )* ) ( ( ruleUnreservedName ) ) ) | ( ( ruleUnrestrictedName ) ) )
            int alt68=2;
            alt68 = dfa68.predict(input);
            switch (alt68) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4046:2: ( ( ( ( ruleUnrestrictedName ) ) otherlv_1= '::' ( ( ( ruleUnreservedName ) ) otherlv_3= '::' )* ) ( ( ruleUnreservedName ) ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4046:2: ( ( ( ( ruleUnrestrictedName ) ) otherlv_1= '::' ( ( ( ruleUnreservedName ) ) otherlv_3= '::' )* ) ( ( ruleUnreservedName ) ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4046:3: ( ( ( ruleUnrestrictedName ) ) otherlv_1= '::' ( ( ( ruleUnreservedName ) ) otherlv_3= '::' )* ) ( ( ruleUnreservedName ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4046:3: ( ( ( ruleUnrestrictedName ) ) otherlv_1= '::' ( ( ( ruleUnreservedName ) ) otherlv_3= '::' )* )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4046:4: ( ( ruleUnrestrictedName ) ) otherlv_1= '::' ( ( ( ruleUnreservedName ) ) otherlv_3= '::' )*
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4046:4: ( ( ruleUnrestrictedName ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4047:1: ( ruleUnrestrictedName )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4047:1: ( ruleUnrestrictedName )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4048:3: ruleUnrestrictedName
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
                    pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleNameExpCS9655);
                    ruleUnrestrictedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_1=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleNameExpCS9667); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getNameExpCSAccess().getColonColonKeyword_0_0_1());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4068:1: ( ( ( ruleUnreservedName ) ) otherlv_3= '::' )*
                    loop67:
                    do {
                        int alt67=2;
                        alt67 = dfa67.predict(input);
                        switch (alt67) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4068:2: ( ( ruleUnreservedName ) ) otherlv_3= '::'
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4068:2: ( ( ruleUnreservedName ) )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4069:1: ( ruleUnreservedName )
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4069:1: ( ruleUnreservedName )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4070:3: ruleUnreservedName
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
                    	    pushFollow(FollowSets000.FOLLOW_ruleUnreservedName_in_ruleNameExpCS9695);
                    	    ruleUnreservedName();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }

                    	    otherlv_3=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleNameExpCS9707); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getNameExpCSAccess().getColonColonKeyword_0_0_2_1());
                    	          
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop67;
                        }
                    } while (true);


                    }

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4090:4: ( ( ruleUnreservedName ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4091:1: ( ruleUnreservedName )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4091:1: ( ruleUnreservedName )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4092:3: ruleUnreservedName
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
                    pushFollow(FollowSets000.FOLLOW_ruleUnreservedName_in_ruleNameExpCS9737);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4109:6: ( ( ruleUnrestrictedName ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4109:6: ( ( ruleUnrestrictedName ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4110:1: ( ruleUnrestrictedName )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4110:1: ( ruleUnrestrictedName )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4111:3: ruleUnrestrictedName
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
                    pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleNameExpCS9771);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4135:1: entryRuleIndexExpCS returns [EObject current=null] : iv_ruleIndexExpCS= ruleIndexExpCS EOF ;
    public final EObject entryRuleIndexExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIndexExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4136:2: (iv_ruleIndexExpCS= ruleIndexExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4137:2: iv_ruleIndexExpCS= ruleIndexExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIndexExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIndexExpCS_in_entryRuleIndexExpCS9807);
            iv_ruleIndexExpCS=ruleIndexExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIndexExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIndexExpCS9817); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4144:1: ruleIndexExpCS returns [EObject current=null] : (this_NameExpCS_0= ruleNameExpCS ( () otherlv_2= '[' ( (lv_firstIndexes_3_0= ruleExpCS ) ) (otherlv_4= ',' ( (lv_firstIndexes_5_0= ruleExpCS ) ) )* otherlv_6= ']' (otherlv_7= '[' ( (lv_secondIndexes_8_0= ruleExpCS ) ) (otherlv_9= ',' ( (lv_secondIndexes_10_0= ruleExpCS ) ) )* otherlv_11= ']' )? )? ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4147:28: ( (this_NameExpCS_0= ruleNameExpCS ( () otherlv_2= '[' ( (lv_firstIndexes_3_0= ruleExpCS ) ) (otherlv_4= ',' ( (lv_firstIndexes_5_0= ruleExpCS ) ) )* otherlv_6= ']' (otherlv_7= '[' ( (lv_secondIndexes_8_0= ruleExpCS ) ) (otherlv_9= ',' ( (lv_secondIndexes_10_0= ruleExpCS ) ) )* otherlv_11= ']' )? )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4148:1: (this_NameExpCS_0= ruleNameExpCS ( () otherlv_2= '[' ( (lv_firstIndexes_3_0= ruleExpCS ) ) (otherlv_4= ',' ( (lv_firstIndexes_5_0= ruleExpCS ) ) )* otherlv_6= ']' (otherlv_7= '[' ( (lv_secondIndexes_8_0= ruleExpCS ) ) (otherlv_9= ',' ( (lv_secondIndexes_10_0= ruleExpCS ) ) )* otherlv_11= ']' )? )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4148:1: (this_NameExpCS_0= ruleNameExpCS ( () otherlv_2= '[' ( (lv_firstIndexes_3_0= ruleExpCS ) ) (otherlv_4= ',' ( (lv_firstIndexes_5_0= ruleExpCS ) ) )* otherlv_6= ']' (otherlv_7= '[' ( (lv_secondIndexes_8_0= ruleExpCS ) ) (otherlv_9= ',' ( (lv_secondIndexes_10_0= ruleExpCS ) ) )* otherlv_11= ']' )? )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4149:2: this_NameExpCS_0= ruleNameExpCS ( () otherlv_2= '[' ( (lv_firstIndexes_3_0= ruleExpCS ) ) (otherlv_4= ',' ( (lv_firstIndexes_5_0= ruleExpCS ) ) )* otherlv_6= ']' (otherlv_7= '[' ( (lv_secondIndexes_8_0= ruleExpCS ) ) (otherlv_9= ',' ( (lv_secondIndexes_10_0= ruleExpCS ) ) )* otherlv_11= ']' )? )?
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getIndexExpCSAccess().getNameExpCSParserRuleCall_0()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleNameExpCS_in_ruleIndexExpCS9867);
            this_NameExpCS_0=ruleNameExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_NameExpCS_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4160:1: ( () otherlv_2= '[' ( (lv_firstIndexes_3_0= ruleExpCS ) ) (otherlv_4= ',' ( (lv_firstIndexes_5_0= ruleExpCS ) ) )* otherlv_6= ']' (otherlv_7= '[' ( (lv_secondIndexes_8_0= ruleExpCS ) ) (otherlv_9= ',' ( (lv_secondIndexes_10_0= ruleExpCS ) ) )* otherlv_11= ']' )? )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==74) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4160:2: () otherlv_2= '[' ( (lv_firstIndexes_3_0= ruleExpCS ) ) (otherlv_4= ',' ( (lv_firstIndexes_5_0= ruleExpCS ) ) )* otherlv_6= ']' (otherlv_7= '[' ( (lv_secondIndexes_8_0= ruleExpCS ) ) (otherlv_9= ',' ( (lv_secondIndexes_10_0= ruleExpCS ) ) )* otherlv_11= ']' )?
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4160:2: ()
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4161:2: 
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

                    otherlv_2=(Token)match(input,74,FollowSets000.FOLLOW_74_in_ruleIndexExpCS9891); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getIndexExpCSAccess().getLeftSquareBracketKeyword_1_1());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4173:1: ( (lv_firstIndexes_3_0= ruleExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4174:1: (lv_firstIndexes_3_0= ruleExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4174:1: (lv_firstIndexes_3_0= ruleExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4175:3: lv_firstIndexes_3_0= ruleExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getIndexExpCSAccess().getFirstIndexesExpCSParserRuleCall_1_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleIndexExpCS9912);
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

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4191:2: (otherlv_4= ',' ( (lv_firstIndexes_5_0= ruleExpCS ) ) )*
                    loop69:
                    do {
                        int alt69=2;
                        int LA69_0 = input.LA(1);

                        if ( (LA69_0==20) ) {
                            alt69=1;
                        }


                        switch (alt69) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4191:4: otherlv_4= ',' ( (lv_firstIndexes_5_0= ruleExpCS ) )
                    	    {
                    	    otherlv_4=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleIndexExpCS9925); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_4, grammarAccess.getIndexExpCSAccess().getCommaKeyword_1_3_0());
                    	          
                    	    }
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4195:1: ( (lv_firstIndexes_5_0= ruleExpCS ) )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4196:1: (lv_firstIndexes_5_0= ruleExpCS )
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4196:1: (lv_firstIndexes_5_0= ruleExpCS )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4197:3: lv_firstIndexes_5_0= ruleExpCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getIndexExpCSAccess().getFirstIndexesExpCSParserRuleCall_1_3_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleIndexExpCS9946);
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
                    	    break loop69;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,75,FollowSets000.FOLLOW_75_in_ruleIndexExpCS9960); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getIndexExpCSAccess().getRightSquareBracketKeyword_1_4());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4217:1: (otherlv_7= '[' ( (lv_secondIndexes_8_0= ruleExpCS ) ) (otherlv_9= ',' ( (lv_secondIndexes_10_0= ruleExpCS ) ) )* otherlv_11= ']' )?
                    int alt71=2;
                    int LA71_0 = input.LA(1);

                    if ( (LA71_0==74) ) {
                        alt71=1;
                    }
                    switch (alt71) {
                        case 1 :
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4217:3: otherlv_7= '[' ( (lv_secondIndexes_8_0= ruleExpCS ) ) (otherlv_9= ',' ( (lv_secondIndexes_10_0= ruleExpCS ) ) )* otherlv_11= ']'
                            {
                            otherlv_7=(Token)match(input,74,FollowSets000.FOLLOW_74_in_ruleIndexExpCS9973); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_7, grammarAccess.getIndexExpCSAccess().getLeftSquareBracketKeyword_1_5_0());
                                  
                            }
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4221:1: ( (lv_secondIndexes_8_0= ruleExpCS ) )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4222:1: (lv_secondIndexes_8_0= ruleExpCS )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4222:1: (lv_secondIndexes_8_0= ruleExpCS )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4223:3: lv_secondIndexes_8_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getIndexExpCSAccess().getSecondIndexesExpCSParserRuleCall_1_5_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleIndexExpCS9994);
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

                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4239:2: (otherlv_9= ',' ( (lv_secondIndexes_10_0= ruleExpCS ) ) )*
                            loop70:
                            do {
                                int alt70=2;
                                int LA70_0 = input.LA(1);

                                if ( (LA70_0==20) ) {
                                    alt70=1;
                                }


                                switch (alt70) {
                            	case 1 :
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4239:4: otherlv_9= ',' ( (lv_secondIndexes_10_0= ruleExpCS ) )
                            	    {
                            	    otherlv_9=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleIndexExpCS10007); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_9, grammarAccess.getIndexExpCSAccess().getCommaKeyword_1_5_2_0());
                            	          
                            	    }
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4243:1: ( (lv_secondIndexes_10_0= ruleExpCS ) )
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4244:1: (lv_secondIndexes_10_0= ruleExpCS )
                            	    {
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4244:1: (lv_secondIndexes_10_0= ruleExpCS )
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4245:3: lv_secondIndexes_10_0= ruleExpCS
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getIndexExpCSAccess().getSecondIndexesExpCSParserRuleCall_1_5_2_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleIndexExpCS10028);
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
                            	    break loop70;
                                }
                            } while (true);

                            otherlv_11=(Token)match(input,75,FollowSets000.FOLLOW_75_in_ruleIndexExpCS10042); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4273:1: entryRuleNavigatingExpCS_Base returns [EObject current=null] : iv_ruleNavigatingExpCS_Base= ruleNavigatingExpCS_Base EOF ;
    public final EObject entryRuleNavigatingExpCS_Base() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingExpCS_Base = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4274:2: (iv_ruleNavigatingExpCS_Base= ruleNavigatingExpCS_Base EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4275:2: iv_ruleNavigatingExpCS_Base= ruleNavigatingExpCS_Base EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingExpCS_BaseRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingExpCS_Base_in_entryRuleNavigatingExpCS_Base10082);
            iv_ruleNavigatingExpCS_Base=ruleNavigatingExpCS_Base();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingExpCS_Base; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigatingExpCS_Base10092); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4282:1: ruleNavigatingExpCS_Base returns [EObject current=null] : this_IndexExpCS_0= ruleIndexExpCS ;
    public final EObject ruleNavigatingExpCS_Base() throws RecognitionException {
        EObject current = null;

        EObject this_IndexExpCS_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4285:28: (this_IndexExpCS_0= ruleIndexExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4287:2: this_IndexExpCS_0= ruleIndexExpCS
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getNavigatingExpCS_BaseAccess().getIndexExpCSParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleIndexExpCS_in_ruleNavigatingExpCS_Base10141);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4306:1: entryRuleNavigatingExpCS returns [EObject current=null] : iv_ruleNavigatingExpCS= ruleNavigatingExpCS EOF ;
    public final EObject entryRuleNavigatingExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4307:2: (iv_ruleNavigatingExpCS= ruleNavigatingExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4308:2: iv_ruleNavigatingExpCS= ruleNavigatingExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingExpCS_in_entryRuleNavigatingExpCS10175);
            iv_ruleNavigatingExpCS=ruleNavigatingExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigatingExpCS10185); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4315:1: ruleNavigatingExpCS returns [EObject current=null] : (this_NavigatingExpCS_Base_0= ruleNavigatingExpCS_Base ( () otherlv_2= '(' ( ( (lv_argument_3_0= ruleNavigatingArgCS ) ) ( (lv_argument_4_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_5_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_6_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_7_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_8_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_9= ')' )? ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4318:28: ( (this_NavigatingExpCS_Base_0= ruleNavigatingExpCS_Base ( () otherlv_2= '(' ( ( (lv_argument_3_0= ruleNavigatingArgCS ) ) ( (lv_argument_4_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_5_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_6_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_7_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_8_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_9= ')' )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4319:1: (this_NavigatingExpCS_Base_0= ruleNavigatingExpCS_Base ( () otherlv_2= '(' ( ( (lv_argument_3_0= ruleNavigatingArgCS ) ) ( (lv_argument_4_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_5_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_6_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_7_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_8_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_9= ')' )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4319:1: (this_NavigatingExpCS_Base_0= ruleNavigatingExpCS_Base ( () otherlv_2= '(' ( ( (lv_argument_3_0= ruleNavigatingArgCS ) ) ( (lv_argument_4_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_5_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_6_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_7_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_8_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_9= ')' )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4320:2: this_NavigatingExpCS_Base_0= ruleNavigatingExpCS_Base ( () otherlv_2= '(' ( ( (lv_argument_3_0= ruleNavigatingArgCS ) ) ( (lv_argument_4_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_5_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_6_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_7_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_8_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_9= ')' )?
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getNavigatingExpCSAccess().getNavigatingExpCS_BaseParserRuleCall_0()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingExpCS_Base_in_ruleNavigatingExpCS10235);
            this_NavigatingExpCS_Base_0=ruleNavigatingExpCS_Base();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_NavigatingExpCS_Base_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4331:1: ( () otherlv_2= '(' ( ( (lv_argument_3_0= ruleNavigatingArgCS ) ) ( (lv_argument_4_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_5_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_6_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_7_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_8_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_9= ')' )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==28) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4331:2: () otherlv_2= '(' ( ( (lv_argument_3_0= ruleNavigatingArgCS ) ) ( (lv_argument_4_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_5_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_6_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_7_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_8_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_9= ')'
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4331:2: ()
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4332:2: 
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

                    otherlv_2=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleNavigatingExpCS10259); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getNavigatingExpCSAccess().getLeftParenthesisKeyword_1_1());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4344:1: ( ( (lv_argument_3_0= ruleNavigatingArgCS ) ) ( (lv_argument_4_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_5_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_6_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_7_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_8_0= ruleNavigatingCommaArgCS ) )* )? )?
                    int alt78=2;
                    int LA78_0 = input.LA(1);

                    if ( ((LA78_0>=RULE_SIMPLE_ID && LA78_0<=RULE_SINGLE_QUOTED_STRING)||LA78_0==14||LA78_0==19||(LA78_0>=21 && LA78_0<=22)||(LA78_0>=24 && LA78_0<=28)||LA78_0==32||LA78_0==35||(LA78_0>=37 && LA78_0<=38)||(LA78_0>=40 && LA78_0<=42)||(LA78_0>=55 && LA78_0<=68)||(LA78_0>=70 && LA78_0<=73)||LA78_0==76||(LA78_0>=80 && LA78_0<=81)) ) {
                        alt78=1;
                    }
                    switch (alt78) {
                        case 1 :
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4344:2: ( (lv_argument_3_0= ruleNavigatingArgCS ) ) ( (lv_argument_4_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_5_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_6_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_7_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_8_0= ruleNavigatingCommaArgCS ) )* )?
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4344:2: ( (lv_argument_3_0= ruleNavigatingArgCS ) )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4345:1: (lv_argument_3_0= ruleNavigatingArgCS )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4345:1: (lv_argument_3_0= ruleNavigatingArgCS )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4346:3: lv_argument_3_0= ruleNavigatingArgCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getNavigatingExpCSAccess().getArgumentNavigatingArgCSParserRuleCall_1_2_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgCS_in_ruleNavigatingExpCS10281);
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

                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4362:2: ( (lv_argument_4_0= ruleNavigatingCommaArgCS ) )*
                            loop73:
                            do {
                                int alt73=2;
                                int LA73_0 = input.LA(1);

                                if ( (LA73_0==20) ) {
                                    alt73=1;
                                }


                                switch (alt73) {
                            	case 1 :
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4363:1: (lv_argument_4_0= ruleNavigatingCommaArgCS )
                            	    {
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4363:1: (lv_argument_4_0= ruleNavigatingCommaArgCS )
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4364:3: lv_argument_4_0= ruleNavigatingCommaArgCS
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getNavigatingExpCSAccess().getArgumentNavigatingCommaArgCSParserRuleCall_1_2_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FollowSets000.FOLLOW_ruleNavigatingCommaArgCS_in_ruleNavigatingExpCS10302);
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
                            	    break loop73;
                                }
                            } while (true);

                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4380:3: ( ( (lv_argument_5_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_6_0= ruleNavigatingCommaArgCS ) )* )?
                            int alt75=2;
                            int LA75_0 = input.LA(1);

                            if ( (LA75_0==17) ) {
                                alt75=1;
                            }
                            switch (alt75) {
                                case 1 :
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4380:4: ( (lv_argument_5_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_6_0= ruleNavigatingCommaArgCS ) )*
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4380:4: ( (lv_argument_5_0= ruleNavigatingSemiArgCS ) )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4381:1: (lv_argument_5_0= ruleNavigatingSemiArgCS )
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4381:1: (lv_argument_5_0= ruleNavigatingSemiArgCS )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4382:3: lv_argument_5_0= ruleNavigatingSemiArgCS
                                    {
                                    if ( state.backtracking==0 ) {
                                       
                                      	        newCompositeNode(grammarAccess.getNavigatingExpCSAccess().getArgumentNavigatingSemiArgCSParserRuleCall_1_2_2_0_0()); 
                                      	    
                                    }
                                    pushFollow(FollowSets000.FOLLOW_ruleNavigatingSemiArgCS_in_ruleNavigatingExpCS10325);
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

                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4398:2: ( (lv_argument_6_0= ruleNavigatingCommaArgCS ) )*
                                    loop74:
                                    do {
                                        int alt74=2;
                                        int LA74_0 = input.LA(1);

                                        if ( (LA74_0==20) ) {
                                            alt74=1;
                                        }


                                        switch (alt74) {
                                    	case 1 :
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4399:1: (lv_argument_6_0= ruleNavigatingCommaArgCS )
                                    	    {
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4399:1: (lv_argument_6_0= ruleNavigatingCommaArgCS )
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4400:3: lv_argument_6_0= ruleNavigatingCommaArgCS
                                    	    {
                                    	    if ( state.backtracking==0 ) {
                                    	       
                                    	      	        newCompositeNode(grammarAccess.getNavigatingExpCSAccess().getArgumentNavigatingCommaArgCSParserRuleCall_1_2_2_1_0()); 
                                    	      	    
                                    	    }
                                    	    pushFollow(FollowSets000.FOLLOW_ruleNavigatingCommaArgCS_in_ruleNavigatingExpCS10346);
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
                                    	    break loop74;
                                        }
                                    } while (true);


                                    }
                                    break;

                            }

                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4416:5: ( ( (lv_argument_7_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_8_0= ruleNavigatingCommaArgCS ) )* )?
                            int alt77=2;
                            int LA77_0 = input.LA(1);

                            if ( (LA77_0==30) ) {
                                alt77=1;
                            }
                            switch (alt77) {
                                case 1 :
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4416:6: ( (lv_argument_7_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_8_0= ruleNavigatingCommaArgCS ) )*
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4416:6: ( (lv_argument_7_0= ruleNavigatingBarArgCS ) )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4417:1: (lv_argument_7_0= ruleNavigatingBarArgCS )
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4417:1: (lv_argument_7_0= ruleNavigatingBarArgCS )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4418:3: lv_argument_7_0= ruleNavigatingBarArgCS
                                    {
                                    if ( state.backtracking==0 ) {
                                       
                                      	        newCompositeNode(grammarAccess.getNavigatingExpCSAccess().getArgumentNavigatingBarArgCSParserRuleCall_1_2_3_0_0()); 
                                      	    
                                    }
                                    pushFollow(FollowSets000.FOLLOW_ruleNavigatingBarArgCS_in_ruleNavigatingExpCS10371);
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

                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4434:2: ( (lv_argument_8_0= ruleNavigatingCommaArgCS ) )*
                                    loop76:
                                    do {
                                        int alt76=2;
                                        int LA76_0 = input.LA(1);

                                        if ( (LA76_0==20) ) {
                                            alt76=1;
                                        }


                                        switch (alt76) {
                                    	case 1 :
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4435:1: (lv_argument_8_0= ruleNavigatingCommaArgCS )
                                    	    {
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4435:1: (lv_argument_8_0= ruleNavigatingCommaArgCS )
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4436:3: lv_argument_8_0= ruleNavigatingCommaArgCS
                                    	    {
                                    	    if ( state.backtracking==0 ) {
                                    	       
                                    	      	        newCompositeNode(grammarAccess.getNavigatingExpCSAccess().getArgumentNavigatingCommaArgCSParserRuleCall_1_2_3_1_0()); 
                                    	      	    
                                    	    }
                                    	    pushFollow(FollowSets000.FOLLOW_ruleNavigatingCommaArgCS_in_ruleNavigatingExpCS10392);
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
                                    	    break loop76;
                                        }
                                    } while (true);


                                    }
                                    break;

                            }


                            }
                            break;

                    }

                    otherlv_9=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleNavigatingExpCS10409); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4464:1: entryRuleNavigatingArgCS returns [EObject current=null] : iv_ruleNavigatingArgCS= ruleNavigatingArgCS EOF ;
    public final EObject entryRuleNavigatingArgCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingArgCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4465:2: (iv_ruleNavigatingArgCS= ruleNavigatingArgCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4466:2: iv_ruleNavigatingArgCS= ruleNavigatingArgCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingArgCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgCS_in_entryRuleNavigatingArgCS10447);
            iv_ruleNavigatingArgCS=ruleNavigatingArgCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingArgCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigatingArgCS10457); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4473:1: ruleNavigatingArgCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleNavigatingArgExpCS ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? (otherlv_3= '=' ( (lv_init_4_0= ruleExpCS ) ) )? ) ;
    public final EObject ruleNavigatingArgCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;

        EObject lv_init_4_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4476:28: ( ( ( (lv_name_0_0= ruleNavigatingArgExpCS ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? (otherlv_3= '=' ( (lv_init_4_0= ruleExpCS ) ) )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4477:1: ( ( (lv_name_0_0= ruleNavigatingArgExpCS ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? (otherlv_3= '=' ( (lv_init_4_0= ruleExpCS ) ) )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4477:1: ( ( (lv_name_0_0= ruleNavigatingArgExpCS ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? (otherlv_3= '=' ( (lv_init_4_0= ruleExpCS ) ) )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4477:2: ( (lv_name_0_0= ruleNavigatingArgExpCS ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? (otherlv_3= '=' ( (lv_init_4_0= ruleExpCS ) ) )?
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4477:2: ( (lv_name_0_0= ruleNavigatingArgExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4478:1: (lv_name_0_0= ruleNavigatingArgExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4478:1: (lv_name_0_0= ruleNavigatingArgExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4479:3: lv_name_0_0= ruleNavigatingArgExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getNameNavigatingArgExpCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingArgCS10503);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4495:2: (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==31) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4495:4: otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                    {
                    otherlv_1=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleNavigatingArgCS10516); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getNavigatingArgCSAccess().getColonKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4499:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4500:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4500:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4501:3: lv_ownedType_2_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleNavigatingArgCS10537);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4517:4: (otherlv_3= '=' ( (lv_init_4_0= ruleExpCS ) ) )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==48) ) {
                alt81=1;
            }
            switch (alt81) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4517:6: otherlv_3= '=' ( (lv_init_4_0= ruleExpCS ) )
                    {
                    otherlv_3=(Token)match(input,48,FollowSets000.FOLLOW_48_in_ruleNavigatingArgCS10552); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getNavigatingArgCSAccess().getEqualsSignKeyword_2_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4521:1: ( (lv_init_4_0= ruleExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4522:1: (lv_init_4_0= ruleExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4522:1: (lv_init_4_0= ruleExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4523:3: lv_init_4_0= ruleExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getInitExpCSParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNavigatingArgCS10573);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4547:1: entryRuleNavigatingBarArgCS returns [EObject current=null] : iv_ruleNavigatingBarArgCS= ruleNavigatingBarArgCS EOF ;
    public final EObject entryRuleNavigatingBarArgCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingBarArgCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4548:2: (iv_ruleNavigatingBarArgCS= ruleNavigatingBarArgCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4549:2: iv_ruleNavigatingBarArgCS= ruleNavigatingBarArgCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingBarArgCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingBarArgCS_in_entryRuleNavigatingBarArgCS10611);
            iv_ruleNavigatingBarArgCS=ruleNavigatingBarArgCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingBarArgCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigatingBarArgCS10621); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4556:1: ruleNavigatingBarArgCS returns [EObject current=null] : ( ( (lv_prefix_0_0= '|' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )? (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4559:28: ( ( ( (lv_prefix_0_0= '|' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )? (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4560:1: ( ( (lv_prefix_0_0= '|' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )? (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4560:1: ( ( (lv_prefix_0_0= '|' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )? (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4560:2: ( (lv_prefix_0_0= '|' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )? (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )?
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4560:2: ( (lv_prefix_0_0= '|' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4561:1: (lv_prefix_0_0= '|' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4561:1: (lv_prefix_0_0= '|' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4562:3: lv_prefix_0_0= '|'
            {
            lv_prefix_0_0=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleNavigatingBarArgCS10664); if (state.failed) return current;
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4575:2: ( (lv_name_1_0= ruleNavigatingArgExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4576:1: (lv_name_1_0= ruleNavigatingArgExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4576:1: (lv_name_1_0= ruleNavigatingArgExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4577:3: lv_name_1_0= ruleNavigatingArgExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNavigatingBarArgCSAccess().getNameNavigatingArgExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingBarArgCS10698);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4593:2: (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==31) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4593:4: otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) )
                    {
                    otherlv_2=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleNavigatingBarArgCS10711); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getNavigatingBarArgCSAccess().getColonKeyword_2_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4597:1: ( (lv_ownedType_3_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4598:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4598:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4599:3: lv_ownedType_3_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingBarArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleNavigatingBarArgCS10732);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4615:4: (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )?
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==48) ) {
                alt83=1;
            }
            switch (alt83) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4615:6: otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) )
                    {
                    otherlv_4=(Token)match(input,48,FollowSets000.FOLLOW_48_in_ruleNavigatingBarArgCS10747); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getNavigatingBarArgCSAccess().getEqualsSignKeyword_3_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4619:1: ( (lv_init_5_0= ruleExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4620:1: (lv_init_5_0= ruleExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4620:1: (lv_init_5_0= ruleExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4621:3: lv_init_5_0= ruleExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingBarArgCSAccess().getInitExpCSParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNavigatingBarArgCS10768);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4645:1: entryRuleNavigatingCommaArgCS returns [EObject current=null] : iv_ruleNavigatingCommaArgCS= ruleNavigatingCommaArgCS EOF ;
    public final EObject entryRuleNavigatingCommaArgCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingCommaArgCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4646:2: (iv_ruleNavigatingCommaArgCS= ruleNavigatingCommaArgCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4647:2: iv_ruleNavigatingCommaArgCS= ruleNavigatingCommaArgCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingCommaArgCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingCommaArgCS_in_entryRuleNavigatingCommaArgCS10806);
            iv_ruleNavigatingCommaArgCS=ruleNavigatingCommaArgCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingCommaArgCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigatingCommaArgCS10816); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4654:1: ruleNavigatingCommaArgCS returns [EObject current=null] : ( ( (lv_prefix_0_0= ',' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )? (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4657:28: ( ( ( (lv_prefix_0_0= ',' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )? (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4658:1: ( ( (lv_prefix_0_0= ',' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )? (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4658:1: ( ( (lv_prefix_0_0= ',' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )? (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4658:2: ( (lv_prefix_0_0= ',' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )? (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )?
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4658:2: ( (lv_prefix_0_0= ',' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4659:1: (lv_prefix_0_0= ',' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4659:1: (lv_prefix_0_0= ',' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4660:3: lv_prefix_0_0= ','
            {
            lv_prefix_0_0=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleNavigatingCommaArgCS10859); if (state.failed) return current;
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4673:2: ( (lv_name_1_0= ruleNavigatingArgExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4674:1: (lv_name_1_0= ruleNavigatingArgExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4674:1: (lv_name_1_0= ruleNavigatingArgExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4675:3: lv_name_1_0= ruleNavigatingArgExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getNameNavigatingArgExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingCommaArgCS10893);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4691:2: (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==31) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4691:4: otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) )
                    {
                    otherlv_2=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleNavigatingCommaArgCS10906); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getNavigatingCommaArgCSAccess().getColonKeyword_2_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4695:1: ( (lv_ownedType_3_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4696:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4696:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4697:3: lv_ownedType_3_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleNavigatingCommaArgCS10927);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4713:4: (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )?
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==48) ) {
                alt85=1;
            }
            switch (alt85) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4713:6: otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) )
                    {
                    otherlv_4=(Token)match(input,48,FollowSets000.FOLLOW_48_in_ruleNavigatingCommaArgCS10942); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getNavigatingCommaArgCSAccess().getEqualsSignKeyword_3_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4717:1: ( (lv_init_5_0= ruleExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4718:1: (lv_init_5_0= ruleExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4718:1: (lv_init_5_0= ruleExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4719:3: lv_init_5_0= ruleExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getInitExpCSParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNavigatingCommaArgCS10963);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4743:1: entryRuleNavigatingSemiArgCS returns [EObject current=null] : iv_ruleNavigatingSemiArgCS= ruleNavigatingSemiArgCS EOF ;
    public final EObject entryRuleNavigatingSemiArgCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingSemiArgCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4744:2: (iv_ruleNavigatingSemiArgCS= ruleNavigatingSemiArgCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4745:2: iv_ruleNavigatingSemiArgCS= ruleNavigatingSemiArgCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingSemiArgCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingSemiArgCS_in_entryRuleNavigatingSemiArgCS11001);
            iv_ruleNavigatingSemiArgCS=ruleNavigatingSemiArgCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingSemiArgCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigatingSemiArgCS11011); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4752:1: ruleNavigatingSemiArgCS returns [EObject current=null] : ( ( (lv_prefix_0_0= ';' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )? (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4755:28: ( ( ( (lv_prefix_0_0= ';' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )? (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4756:1: ( ( (lv_prefix_0_0= ';' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )? (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4756:1: ( ( (lv_prefix_0_0= ';' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )? (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4756:2: ( (lv_prefix_0_0= ';' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )? (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )?
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4756:2: ( (lv_prefix_0_0= ';' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4757:1: (lv_prefix_0_0= ';' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4757:1: (lv_prefix_0_0= ';' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4758:3: lv_prefix_0_0= ';'
            {
            lv_prefix_0_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleNavigatingSemiArgCS11054); if (state.failed) return current;
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4771:2: ( (lv_name_1_0= ruleNavigatingArgExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4772:1: (lv_name_1_0= ruleNavigatingArgExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4772:1: (lv_name_1_0= ruleNavigatingArgExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4773:3: lv_name_1_0= ruleNavigatingArgExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNavigatingSemiArgCSAccess().getNameNavigatingArgExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingSemiArgCS11088);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4789:2: (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )?
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==31) ) {
                alt86=1;
            }
            switch (alt86) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4789:4: otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) )
                    {
                    otherlv_2=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleNavigatingSemiArgCS11101); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getNavigatingSemiArgCSAccess().getColonKeyword_2_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4793:1: ( (lv_ownedType_3_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4794:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4794:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4795:3: lv_ownedType_3_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingSemiArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleNavigatingSemiArgCS11122);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4811:4: (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )?
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==48) ) {
                alt87=1;
            }
            switch (alt87) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4811:6: otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) )
                    {
                    otherlv_4=(Token)match(input,48,FollowSets000.FOLLOW_48_in_ruleNavigatingSemiArgCS11137); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getNavigatingSemiArgCSAccess().getEqualsSignKeyword_3_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4815:1: ( (lv_init_5_0= ruleExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4816:1: (lv_init_5_0= ruleExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4816:1: (lv_init_5_0= ruleExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4817:3: lv_init_5_0= ruleExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingSemiArgCSAccess().getInitExpCSParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNavigatingSemiArgCS11158);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4841:1: entryRuleNavigatingArgExpCS returns [EObject current=null] : iv_ruleNavigatingArgExpCS= ruleNavigatingArgExpCS EOF ;
    public final EObject entryRuleNavigatingArgExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingArgExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4842:2: (iv_ruleNavigatingArgExpCS= ruleNavigatingArgExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4843:2: iv_ruleNavigatingArgExpCS= ruleNavigatingArgExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingArgExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgExpCS_in_entryRuleNavigatingArgExpCS11196);
            iv_ruleNavigatingArgExpCS=ruleNavigatingArgExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingArgExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigatingArgExpCS11206); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4850:1: ruleNavigatingArgExpCS returns [EObject current=null] : this_ExpCS_0= ruleExpCS ;
    public final EObject ruleNavigatingArgExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_ExpCS_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4853:28: (this_ExpCS_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4855:2: this_ExpCS_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getNavigatingArgExpCSAccess().getExpCSParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNavigatingArgExpCS11255);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4874:1: entryRuleIfExpCS returns [EObject current=null] : iv_ruleIfExpCS= ruleIfExpCS EOF ;
    public final EObject entryRuleIfExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4875:2: (iv_ruleIfExpCS= ruleIfExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4876:2: iv_ruleIfExpCS= ruleIfExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIfExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIfExpCS_in_entryRuleIfExpCS11289);
            iv_ruleIfExpCS=ruleIfExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIfExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIfExpCS11299); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4883:1: ruleIfExpCS returns [EObject current=null] : (otherlv_0= 'if' ( (lv_condition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_thenExpression_3_0= ruleExpCS ) ) otherlv_4= 'else' ( (lv_elseExpression_5_0= ruleExpCS ) ) otherlv_6= 'endif' ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4886:28: ( (otherlv_0= 'if' ( (lv_condition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_thenExpression_3_0= ruleExpCS ) ) otherlv_4= 'else' ( (lv_elseExpression_5_0= ruleExpCS ) ) otherlv_6= 'endif' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4887:1: (otherlv_0= 'if' ( (lv_condition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_thenExpression_3_0= ruleExpCS ) ) otherlv_4= 'else' ( (lv_elseExpression_5_0= ruleExpCS ) ) otherlv_6= 'endif' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4887:1: (otherlv_0= 'if' ( (lv_condition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_thenExpression_3_0= ruleExpCS ) ) otherlv_4= 'else' ( (lv_elseExpression_5_0= ruleExpCS ) ) otherlv_6= 'endif' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4887:3: otherlv_0= 'if' ( (lv_condition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_thenExpression_3_0= ruleExpCS ) ) otherlv_4= 'else' ( (lv_elseExpression_5_0= ruleExpCS ) ) otherlv_6= 'endif'
            {
            otherlv_0=(Token)match(input,76,FollowSets000.FOLLOW_76_in_ruleIfExpCS11336); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getIfExpCSAccess().getIfKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4891:1: ( (lv_condition_1_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4892:1: (lv_condition_1_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4892:1: (lv_condition_1_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4893:3: lv_condition_1_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIfExpCSAccess().getConditionExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleIfExpCS11357);
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

            otherlv_2=(Token)match(input,77,FollowSets000.FOLLOW_77_in_ruleIfExpCS11369); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getIfExpCSAccess().getThenKeyword_2());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4913:1: ( (lv_thenExpression_3_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4914:1: (lv_thenExpression_3_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4914:1: (lv_thenExpression_3_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4915:3: lv_thenExpression_3_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIfExpCSAccess().getThenExpressionExpCSParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleIfExpCS11390);
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

            otherlv_4=(Token)match(input,78,FollowSets000.FOLLOW_78_in_ruleIfExpCS11402); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getIfExpCSAccess().getElseKeyword_4());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4935:1: ( (lv_elseExpression_5_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4936:1: (lv_elseExpression_5_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4936:1: (lv_elseExpression_5_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4937:3: lv_elseExpression_5_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIfExpCSAccess().getElseExpressionExpCSParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleIfExpCS11423);
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

            otherlv_6=(Token)match(input,79,FollowSets000.FOLLOW_79_in_ruleIfExpCS11435); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4965:1: entryRuleLetExpCS returns [EObject current=null] : iv_ruleLetExpCS= ruleLetExpCS EOF ;
    public final EObject entryRuleLetExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLetExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4966:2: (iv_ruleLetExpCS= ruleLetExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4967:2: iv_ruleLetExpCS= ruleLetExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLetExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLetExpCS_in_entryRuleLetExpCS11471);
            iv_ruleLetExpCS=ruleLetExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLetExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLetExpCS11481); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4974:1: ruleLetExpCS returns [EObject current=null] : (otherlv_0= 'let' ( (lv_variable_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_variable_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_in_5_0= ruleExpCS ) ) ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4977:28: ( (otherlv_0= 'let' ( (lv_variable_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_variable_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_in_5_0= ruleExpCS ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4978:1: (otherlv_0= 'let' ( (lv_variable_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_variable_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_in_5_0= ruleExpCS ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4978:1: (otherlv_0= 'let' ( (lv_variable_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_variable_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_in_5_0= ruleExpCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4978:3: otherlv_0= 'let' ( (lv_variable_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_variable_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_in_5_0= ruleExpCS ) )
            {
            otherlv_0=(Token)match(input,80,FollowSets000.FOLLOW_80_in_ruleLetExpCS11518); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLetExpCSAccess().getLetKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4982:1: ( (lv_variable_1_0= ruleLetVariableCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4983:1: (lv_variable_1_0= ruleLetVariableCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4983:1: (lv_variable_1_0= ruleLetVariableCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4984:3: lv_variable_1_0= ruleLetVariableCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetExpCSAccess().getVariableLetVariableCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleLetVariableCS_in_ruleLetExpCS11539);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5000:2: (otherlv_2= ',' ( (lv_variable_3_0= ruleLetVariableCS ) ) )*
            loop88:
            do {
                int alt88=2;
                int LA88_0 = input.LA(1);

                if ( (LA88_0==20) ) {
                    alt88=1;
                }


                switch (alt88) {
            	case 1 :
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5000:4: otherlv_2= ',' ( (lv_variable_3_0= ruleLetVariableCS ) )
            	    {
            	    otherlv_2=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleLetExpCS11552); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getLetExpCSAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5004:1: ( (lv_variable_3_0= ruleLetVariableCS ) )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5005:1: (lv_variable_3_0= ruleLetVariableCS )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5005:1: (lv_variable_3_0= ruleLetVariableCS )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5006:3: lv_variable_3_0= ruleLetVariableCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLetExpCSAccess().getVariableLetVariableCSParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleLetVariableCS_in_ruleLetExpCS11573);
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
            	    break loop88;
                }
            } while (true);

            otherlv_4=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleLetExpCS11587); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getLetExpCSAccess().getInKeyword_3());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5026:1: ( (lv_in_5_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5027:1: (lv_in_5_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5027:1: (lv_in_5_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5028:3: lv_in_5_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetExpCSAccess().getInExpCSParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleLetExpCS11608);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5052:1: entryRuleLetVariableCS returns [EObject current=null] : iv_ruleLetVariableCS= ruleLetVariableCS EOF ;
    public final EObject entryRuleLetVariableCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLetVariableCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5053:2: (iv_ruleLetVariableCS= ruleLetVariableCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5054:2: iv_ruleLetVariableCS= ruleLetVariableCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLetVariableCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLetVariableCS_in_entryRuleLetVariableCS11644);
            iv_ruleLetVariableCS=ruleLetVariableCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLetVariableCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLetVariableCS11654); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5061:1: ruleLetVariableCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) ) ) ;
    public final EObject ruleLetVariableCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;

        EObject lv_initExpression_4_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5064:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5065:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5065:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5065:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5065:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5066:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5066:1: (lv_name_0_0= ruleUnrestrictedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5067:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetVariableCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleLetVariableCS11700);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5083:2: (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )?
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( (LA89_0==31) ) {
                alt89=1;
            }
            switch (alt89) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5083:4: otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                    {
                    otherlv_1=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleLetVariableCS11713); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getLetVariableCSAccess().getColonKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5087:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5088:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5088:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5089:3: lv_ownedType_2_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLetVariableCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleLetVariableCS11734);
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

            otherlv_3=(Token)match(input,48,FollowSets000.FOLLOW_48_in_ruleLetVariableCS11748); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getLetVariableCSAccess().getEqualsSignKeyword_2());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5109:1: ( (lv_initExpression_4_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5110:1: (lv_initExpression_4_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5110:1: (lv_initExpression_4_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5111:3: lv_initExpression_4_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetVariableCSAccess().getInitExpressionExpCSParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleLetVariableCS11769);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5135:1: entryRuleNestedExpCS returns [EObject current=null] : iv_ruleNestedExpCS= ruleNestedExpCS EOF ;
    public final EObject entryRuleNestedExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNestedExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5136:2: (iv_ruleNestedExpCS= ruleNestedExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5137:2: iv_ruleNestedExpCS= ruleNestedExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNestedExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNestedExpCS_in_entryRuleNestedExpCS11805);
            iv_ruleNestedExpCS=ruleNestedExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNestedExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNestedExpCS11815); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5144:1: ruleNestedExpCS returns [EObject current=null] : (otherlv_0= '(' ( (lv_source_1_0= ruleExpCS ) ) otherlv_2= ')' ) ;
    public final EObject ruleNestedExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_source_1_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5147:28: ( (otherlv_0= '(' ( (lv_source_1_0= ruleExpCS ) ) otherlv_2= ')' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5148:1: (otherlv_0= '(' ( (lv_source_1_0= ruleExpCS ) ) otherlv_2= ')' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5148:1: (otherlv_0= '(' ( (lv_source_1_0= ruleExpCS ) ) otherlv_2= ')' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5148:3: otherlv_0= '(' ( (lv_source_1_0= ruleExpCS ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleNestedExpCS11852); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getNestedExpCSAccess().getLeftParenthesisKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5152:1: ( (lv_source_1_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5153:1: (lv_source_1_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5153:1: (lv_source_1_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5154:3: lv_source_1_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNestedExpCSAccess().getSourceExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNestedExpCS11873);
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

            otherlv_2=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleNestedExpCS11885); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5182:1: entryRuleSelfExpCS returns [EObject current=null] : iv_ruleSelfExpCS= ruleSelfExpCS EOF ;
    public final EObject entryRuleSelfExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelfExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5183:2: (iv_ruleSelfExpCS= ruleSelfExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5184:2: iv_ruleSelfExpCS= ruleSelfExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSelfExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSelfExpCS_in_entryRuleSelfExpCS11921);
            iv_ruleSelfExpCS=ruleSelfExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSelfExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSelfExpCS11931); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5191:1: ruleSelfExpCS returns [EObject current=null] : ( () otherlv_1= 'self' ) ;
    public final EObject ruleSelfExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5194:28: ( ( () otherlv_1= 'self' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5195:1: ( () otherlv_1= 'self' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5195:1: ( () otherlv_1= 'self' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5195:2: () otherlv_1= 'self'
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5195:2: ()
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5196:2: 
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

            otherlv_1=(Token)match(input,81,FollowSets000.FOLLOW_81_in_ruleSelfExpCS11980); if (state.failed) return current;
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
        int alt94=2;
        int LA94_0 = input.LA(1);

        if ( (LA94_0==25) ) {
            int LA94_1 = input.LA(2);

            if ( ((LA94_1>=RULE_SIMPLE_ID && LA94_1<=RULE_ESCAPED_ID)||LA94_1==14||LA94_1==19||(LA94_1>=21 && LA94_1<=22)||(LA94_1>=24 && LA94_1<=27)||LA94_1==32||LA94_1==35||(LA94_1>=37 && LA94_1<=38)) ) {
                alt94=1;
            }
        }
        switch (alt94) {
            case 1 :
                // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:499:4: otherlv_9= 'check'
                {
                otherlv_9=(Token)match(input,25,FollowSets000.FOLLOW_25_in_synpred16_InternalQVTcore956); if (state.failed) return ;

                }
                break;

        }

        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:503:3: (otherlv_10= 'enforce' )?
        int alt95=2;
        int LA95_0 = input.LA(1);

        if ( (LA95_0==26) ) {
            int LA95_1 = input.LA(2);

            if ( ((LA95_1>=RULE_SIMPLE_ID && LA95_1<=RULE_ESCAPED_ID)||LA95_1==14||LA95_1==19||(LA95_1>=21 && LA95_1<=22)||(LA95_1>=24 && LA95_1<=27)||LA95_1==32||LA95_1==35||(LA95_1>=37 && LA95_1<=38)) ) {
                alt95=1;
            }
        }
        switch (alt95) {
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


        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2435:6: ( (otherlv_4= '<' ( (lv_ownedType_5_0= ruleTypeExpCS ) ) otherlv_6= '>' ) )
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2435:6: (otherlv_4= '<' ( (lv_ownedType_5_0= ruleTypeExpCS ) ) otherlv_6= '>' )
        {
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2435:6: (otherlv_4= '<' ( (lv_ownedType_5_0= ruleTypeExpCS ) ) otherlv_6= '>' )
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2435:8: otherlv_4= '<' ( (lv_ownedType_5_0= ruleTypeExpCS ) ) otherlv_6= '>'
        {
        otherlv_4=(Token)match(input,45,FollowSets000.FOLLOW_45_in_synpred79_InternalQVTcore5910); if (state.failed) return ;
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2439:1: ( (lv_ownedType_5_0= ruleTypeExpCS ) )
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2440:1: (lv_ownedType_5_0= ruleTypeExpCS )
        {
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2440:1: (lv_ownedType_5_0= ruleTypeExpCS )
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2441:3: lv_ownedType_5_0= ruleTypeExpCS
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getCollectionTypeCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_1_0()); 
          	    
        }
        pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_synpred79_InternalQVTcore5931);
        lv_ownedType_5_0=ruleTypeExpCS();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        otherlv_6=(Token)match(input,44,FollowSets000.FOLLOW_44_in_synpred79_InternalQVTcore5943); if (state.failed) return ;

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


        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2546:6: ( (otherlv_6= '<' ( ( (lv_ownedParts_7_0= ruletuplePartCS ) ) (otherlv_8= ',' ( (lv_ownedParts_9_0= ruletuplePartCS ) ) )* )? otherlv_10= '>' ) )
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2546:6: (otherlv_6= '<' ( ( (lv_ownedParts_7_0= ruletuplePartCS ) ) (otherlv_8= ',' ( (lv_ownedParts_9_0= ruletuplePartCS ) ) )* )? otherlv_10= '>' )
        {
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2546:6: (otherlv_6= '<' ( ( (lv_ownedParts_7_0= ruletuplePartCS ) ) (otherlv_8= ',' ( (lv_ownedParts_9_0= ruletuplePartCS ) ) )* )? otherlv_10= '>' )
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2546:8: otherlv_6= '<' ( ( (lv_ownedParts_7_0= ruletuplePartCS ) ) (otherlv_8= ',' ( (lv_ownedParts_9_0= ruletuplePartCS ) ) )* )? otherlv_10= '>'
        {
        otherlv_6=(Token)match(input,45,FollowSets000.FOLLOW_45_in_synpred85_InternalQVTcore6154); if (state.failed) return ;
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2550:1: ( ( (lv_ownedParts_7_0= ruletuplePartCS ) ) (otherlv_8= ',' ( (lv_ownedParts_9_0= ruletuplePartCS ) ) )* )?
        int alt109=2;
        int LA109_0 = input.LA(1);

        if ( ((LA109_0>=RULE_SIMPLE_ID && LA109_0<=RULE_ESCAPED_ID)||LA109_0==14||LA109_0==19||(LA109_0>=21 && LA109_0<=22)||(LA109_0>=24 && LA109_0<=27)||LA109_0==32||LA109_0==35||(LA109_0>=37 && LA109_0<=38)) ) {
            alt109=1;
        }
        switch (alt109) {
            case 1 :
                // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2550:2: ( (lv_ownedParts_7_0= ruletuplePartCS ) ) (otherlv_8= ',' ( (lv_ownedParts_9_0= ruletuplePartCS ) ) )*
                {
                // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2550:2: ( (lv_ownedParts_7_0= ruletuplePartCS ) )
                // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2551:1: (lv_ownedParts_7_0= ruletuplePartCS )
                {
                // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2551:1: (lv_ownedParts_7_0= ruletuplePartCS )
                // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2552:3: lv_ownedParts_7_0= ruletuplePartCS
                {
                if ( state.backtracking==0 ) {
                   
                  	        newCompositeNode(grammarAccess.getTupleTypeCSAccess().getOwnedPartsTuplePartCSParserRuleCall_1_1_1_0_0()); 
                  	    
                }
                pushFollow(FollowSets000.FOLLOW_ruletuplePartCS_in_synpred85_InternalQVTcore6176);
                lv_ownedParts_7_0=ruletuplePartCS();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2568:2: (otherlv_8= ',' ( (lv_ownedParts_9_0= ruletuplePartCS ) ) )*
                loop108:
                do {
                    int alt108=2;
                    int LA108_0 = input.LA(1);

                    if ( (LA108_0==20) ) {
                        alt108=1;
                    }


                    switch (alt108) {
                	case 1 :
                	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2568:4: otherlv_8= ',' ( (lv_ownedParts_9_0= ruletuplePartCS ) )
                	    {
                	    otherlv_8=(Token)match(input,20,FollowSets000.FOLLOW_20_in_synpred85_InternalQVTcore6189); if (state.failed) return ;
                	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2572:1: ( (lv_ownedParts_9_0= ruletuplePartCS ) )
                	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2573:1: (lv_ownedParts_9_0= ruletuplePartCS )
                	    {
                	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2573:1: (lv_ownedParts_9_0= ruletuplePartCS )
                	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2574:3: lv_ownedParts_9_0= ruletuplePartCS
                	    {
                	    if ( state.backtracking==0 ) {
                	       
                	      	        newCompositeNode(grammarAccess.getTupleTypeCSAccess().getOwnedPartsTuplePartCSParserRuleCall_1_1_1_1_1_0()); 
                	      	    
                	    }
                	    pushFollow(FollowSets000.FOLLOW_ruletuplePartCS_in_synpred85_InternalQVTcore6210);
                	    lv_ownedParts_9_0=ruletuplePartCS();

                	    state._fsp--;
                	    if (state.failed) return ;

                	    }


                	    }


                	    }
                	    break;

                	default :
                	    break loop108;
                    }
                } while (true);


                }
                break;

        }

        otherlv_10=(Token)match(input,44,FollowSets000.FOLLOW_44_in_synpred85_InternalQVTcore6226); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred85_InternalQVTcore

    // $ANTLR start synpred103_InternalQVTcore
    public final void synpred103_InternalQVTcore_fragment() throws RecognitionException {   
        EObject lv_ownedOperator_2_0 = null;

        EObject lv_ownedExpression_3_0 = null;


        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3610:3: ( ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) )
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3610:3: ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) )
        {
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3610:3: ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) )
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3611:1: (lv_ownedOperator_2_0= ruleBinaryOperatorCS )
        {
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3611:1: (lv_ownedOperator_2_0= ruleBinaryOperatorCS )
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3612:3: lv_ownedOperator_2_0= ruleBinaryOperatorCS
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getInfixedExpCSAccess().getOwnedOperatorBinaryOperatorCSParserRuleCall_1_1_0_0()); 
          	    
        }
        pushFollow(FollowSets000.FOLLOW_ruleBinaryOperatorCS_in_synpred103_InternalQVTcore8642);
        lv_ownedOperator_2_0=ruleBinaryOperatorCS();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3628:2: ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) )
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3629:1: (lv_ownedExpression_3_0= rulePrefixedExpCS )
        {
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3629:1: (lv_ownedExpression_3_0= rulePrefixedExpCS )
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3630:3: lv_ownedExpression_3_0= rulePrefixedExpCS
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getInfixedExpCSAccess().getOwnedExpressionPrefixedExpCSParserRuleCall_1_1_1_0()); 
          	    
        }
        pushFollow(FollowSets000.FOLLOW_rulePrefixedExpCS_in_synpred103_InternalQVTcore8663);
        lv_ownedExpression_3_0=rulePrefixedExpCS();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred103_InternalQVTcore

    // $ANTLR start synpred104_InternalQVTcore
    public final void synpred104_InternalQVTcore_fragment() throws RecognitionException {   
        EObject lv_ownedOperator_2_0 = null;

        EObject lv_ownedExpression_3_0 = null;


        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3601:2: ( () ( ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) )+ )
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3601:2: () ( ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) )+
        {
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3601:2: ()
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3602:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3610:2: ( ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) )+
        int cnt112=0;
        loop112:
        do {
            int alt112=2;
            int LA112_0 = input.LA(1);

            if ( (LA112_0==36||(LA112_0>=39 && LA112_0<=40)||(LA112_0>=42 && LA112_0<=54)) ) {
                alt112=1;
            }


            switch (alt112) {
        	case 1 :
        	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3610:3: ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) )
        	    {
        	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3610:3: ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) )
        	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3611:1: (lv_ownedOperator_2_0= ruleBinaryOperatorCS )
        	    {
        	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3611:1: (lv_ownedOperator_2_0= ruleBinaryOperatorCS )
        	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3612:3: lv_ownedOperator_2_0= ruleBinaryOperatorCS
        	    {
        	    if ( state.backtracking==0 ) {
        	       
        	      	        newCompositeNode(grammarAccess.getInfixedExpCSAccess().getOwnedOperatorBinaryOperatorCSParserRuleCall_1_1_0_0()); 
        	      	    
        	    }
        	    pushFollow(FollowSets000.FOLLOW_ruleBinaryOperatorCS_in_synpred104_InternalQVTcore8642);
        	    lv_ownedOperator_2_0=ruleBinaryOperatorCS();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }

        	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3628:2: ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) )
        	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3629:1: (lv_ownedExpression_3_0= rulePrefixedExpCS )
        	    {
        	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3629:1: (lv_ownedExpression_3_0= rulePrefixedExpCS )
        	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3630:3: lv_ownedExpression_3_0= rulePrefixedExpCS
        	    {
        	    if ( state.backtracking==0 ) {
        	       
        	      	        newCompositeNode(grammarAccess.getInfixedExpCSAccess().getOwnedExpressionPrefixedExpCSParserRuleCall_1_1_1_0()); 
        	      	    
        	    }
        	    pushFollow(FollowSets000.FOLLOW_rulePrefixedExpCS_in_synpred104_InternalQVTcore8663);
        	    lv_ownedExpression_3_0=rulePrefixedExpCS();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }


        	    }
        	    break;

        	default :
        	    if ( cnt112 >= 1 ) break loop112;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(112, input);
                    throw eee;
            }
            cnt112++;
        } while (true);


        }
    }
    // $ANTLR end synpred104_InternalQVTcore

    // $ANTLR start synpred111_InternalQVTcore
    public final void synpred111_InternalQVTcore_fragment() throws RecognitionException {   
        EObject this_TupleLiteralExpCS_3 = null;


        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3949:2: (this_TupleLiteralExpCS_3= ruleTupleLiteralExpCS )
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3949:2: this_TupleLiteralExpCS_3= ruleTupleLiteralExpCS
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralExpCS_in_synpred111_InternalQVTcore9406);
        this_TupleLiteralExpCS_3=ruleTupleLiteralExpCS();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred111_InternalQVTcore

    // $ANTLR start synpred112_InternalQVTcore
    public final void synpred112_InternalQVTcore_fragment() throws RecognitionException {   
        EObject this_CollectionLiteralExpCS_4 = null;


        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3962:2: (this_CollectionLiteralExpCS_4= ruleCollectionLiteralExpCS )
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3962:2: this_CollectionLiteralExpCS_4= ruleCollectionLiteralExpCS
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteralExpCS_in_synpred112_InternalQVTcore9436);
        this_CollectionLiteralExpCS_4=ruleCollectionLiteralExpCS();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred112_InternalQVTcore

    // $ANTLR start synpred113_InternalQVTcore
    public final void synpred113_InternalQVTcore_fragment() throws RecognitionException {   
        EObject this_TypeLiteralExpCS_5 = null;


        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3975:2: (this_TypeLiteralExpCS_5= ruleTypeLiteralExpCS )
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3975:2: this_TypeLiteralExpCS_5= ruleTypeLiteralExpCS
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralExpCS_in_synpred113_InternalQVTcore9466);
        this_TypeLiteralExpCS_5=ruleTypeLiteralExpCS();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred113_InternalQVTcore

    // Delegated rules

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
    public final boolean synpred103_InternalQVTcore() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred103_InternalQVTcore_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred104_InternalQVTcore() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred104_InternalQVTcore_fragment(); // can never throw exception
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
    public final boolean synpred113_InternalQVTcore() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred113_InternalQVTcore_fragment(); // can never throw exception
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
    public final boolean synpred112_InternalQVTcore() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred112_InternalQVTcore_fragment(); // can never throw exception
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
    protected DFA59 dfa59 = new DFA59(this);
    protected DFA58 dfa58 = new DFA58(this);
    protected DFA62 dfa62 = new DFA62(this);
    protected DFA61 dfa61 = new DFA61(this);
    protected DFA66 dfa66 = new DFA66(this);
    protected DFA68 dfa68 = new DFA68(this);
    protected DFA67 dfa67 = new DFA67(this);
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
        "\35\uffff\1\1\1\2";
    static final String DFA2_specialS =
        "\37\uffff}>";
    static final String[] DFA2_transitionS = {
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
            "\1\17\1\uffff\1\17\12\uffff\1\17\2\uffff\1\20\2\uffff\1\17"+
            "\1\uffff\1\17\2\uffff\2\17\1\uffff\15\17\23\uffff\1\17",
            "\1\17\1\uffff\1\17\12\uffff\1\17\2\uffff\1\20\2\uffff\1\17"+
            "\1\uffff\1\17\2\uffff\2\17\1\uffff\15\17\23\uffff\1\17",
            "\1\17\1\uffff\1\17\12\uffff\1\17\2\uffff\1\20\2\uffff\1\17"+
            "\1\uffff\1\17\2\uffff\2\17\1\uffff\15\17\23\uffff\1\17",
            "\1\17\1\uffff\1\17\12\uffff\1\17\2\uffff\1\20\2\uffff\1\17"+
            "\1\uffff\1\17\2\uffff\2\17\1\uffff\15\17\23\uffff\1\17",
            "\1\17\1\uffff\1\17\12\uffff\1\17\2\uffff\1\20\2\uffff\1\17"+
            "\1\uffff\1\17\2\uffff\2\17\1\uffff\15\17\23\uffff\1\17",
            "\1\17\1\uffff\1\17\12\uffff\1\17\2\uffff\1\20\2\uffff\1\17"+
            "\1\uffff\1\17\2\uffff\2\17\1\uffff\15\17\23\uffff\1\17",
            "\1\17\1\uffff\1\17\12\uffff\1\17\2\uffff\1\20\2\uffff\1\17"+
            "\1\uffff\1\17\2\uffff\2\17\1\uffff\15\17\23\uffff\1\17",
            "\1\17\1\uffff\1\17\12\uffff\1\17\2\uffff\1\20\2\uffff\1\17"+
            "\1\uffff\1\17\2\uffff\2\17\1\uffff\15\17\23\uffff\1\17",
            "\1\17\1\uffff\1\17\12\uffff\1\17\2\uffff\1\20\2\uffff\1\17"+
            "\1\uffff\1\17\2\uffff\2\17\1\uffff\15\17\23\uffff\1\17",
            "\1\17\1\uffff\1\17\12\uffff\1\17\2\uffff\1\20\2\uffff\1\17"+
            "\1\uffff\1\17\2\uffff\2\17\1\uffff\15\17\23\uffff\1\17",
            "\1\17\1\uffff\1\17\12\uffff\1\17\2\uffff\1\20\2\uffff\1\17"+
            "\1\uffff\1\17\2\uffff\2\17\1\uffff\15\17\23\uffff\1\17",
            "\1\17\1\uffff\1\17\12\uffff\1\17\2\uffff\1\20\2\uffff\1\17"+
            "\1\uffff\1\17\2\uffff\2\17\1\uffff\15\17\23\uffff\1\17",
            "\1\17\1\uffff\1\17\12\uffff\1\17\2\uffff\1\20\2\uffff\1\17"+
            "\1\uffff\1\17\2\uffff\2\17\1\uffff\15\17\23\uffff\1\17",
            "\1\17\1\uffff\1\17\12\uffff\1\17\2\uffff\1\20\2\uffff\1\17"+
            "\1\uffff\1\17\2\uffff\2\17\1\uffff\15\17\23\uffff\1\17",
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
            "\1\17\1\uffff\1\17\12\uffff\1\17\2\uffff\1\20\2\uffff\1\17"+
            "\1\uffff\1\17\2\uffff\2\17\1\uffff\15\17\23\uffff\1\17",
            "\1\17\1\uffff\1\17\12\uffff\1\17\2\uffff\1\20\2\uffff\1\17"+
            "\1\uffff\1\17\2\uffff\2\17\1\uffff\15\17\23\uffff\1\17",
            "\1\17\1\uffff\1\17\12\uffff\1\17\2\uffff\1\20\2\uffff\1\17"+
            "\1\uffff\1\17\2\uffff\2\17\1\uffff\15\17\23\uffff\1\17",
            "\1\17\1\uffff\1\17\12\uffff\1\17\2\uffff\1\20\2\uffff\1\17"+
            "\1\uffff\1\17\2\uffff\2\17\1\uffff\15\17\23\uffff\1\17",
            "\1\17\1\uffff\1\17\12\uffff\1\17\2\uffff\1\20\2\uffff\1\17"+
            "\1\uffff\1\17\2\uffff\2\17\1\uffff\15\17\23\uffff\1\17",
            "\1\17\1\uffff\1\17\12\uffff\1\17\2\uffff\1\20\2\uffff\1\17"+
            "\1\uffff\1\17\2\uffff\2\17\1\uffff\15\17\23\uffff\1\17",
            "\1\17\1\uffff\1\17\12\uffff\1\17\2\uffff\1\20\2\uffff\1\17"+
            "\1\uffff\1\17\2\uffff\2\17\1\uffff\15\17\23\uffff\1\17",
            "\1\17\1\uffff\1\17\12\uffff\1\17\2\uffff\1\20\2\uffff\1\17"+
            "\1\uffff\1\17\2\uffff\2\17\1\uffff\15\17\23\uffff\1\17",
            "\1\17\1\uffff\1\17\12\uffff\1\17\2\uffff\1\20\2\uffff\1\17"+
            "\1\uffff\1\17\2\uffff\2\17\1\uffff\15\17\23\uffff\1\17",
            "\2\20\10\uffff\1\20\1\17\1\uffff\1\17\1\uffff\1\20\1\uffff"+
            "\2\20\1\uffff\4\20\1\17\2\uffff\2\20\1\uffff\1\17\1\20\1\17"+
            "\2\20\2\17\1\uffff\15\17\23\uffff\1\17",
            "\1\17\1\uffff\1\17\12\uffff\1\17\2\uffff\1\20\2\uffff\1\17"+
            "\1\uffff\1\17\2\uffff\2\17\1\uffff\15\17\23\uffff\1\17",
            "\1\17\1\uffff\1\17\12\uffff\1\17\2\uffff\1\20\2\uffff\1\17"+
            "\1\uffff\1\17\2\uffff\2\17\1\uffff\15\17\23\uffff\1\17",
            "\1\17\1\uffff\1\17\12\uffff\1\17\2\uffff\1\20\2\uffff\1\17"+
            "\1\uffff\1\17\2\uffff\2\17\1\uffff\15\17\23\uffff\1\17",
            "\1\17\1\uffff\1\17\12\uffff\1\17\2\uffff\1\20\2\uffff\1\17"+
            "\1\uffff\1\17\2\uffff\2\17\1\uffff\15\17\23\uffff\1\17",
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
            return "2408:2: ( (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' ) | (otherlv_4= '<' ( (lv_ownedType_5_0= ruleTypeExpCS ) ) otherlv_6= '>' ) )?";
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
            return "2497:2: ( (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruletuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruletuplePartCS ) ) )* )? otherlv_5= ')' ) | (otherlv_6= '<' ( ( (lv_ownedParts_7_0= ruletuplePartCS ) ) (otherlv_8= ',' ( (lv_ownedParts_9_0= ruletuplePartCS ) ) )* )? otherlv_10= '>' ) )?";
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
    static final String DFA59_eotS =
        "\21\uffff";
    static final String DFA59_eofS =
        "\1\uffff\16\17\2\uffff";
    static final String DFA59_minS =
        "\1\4\16\17\2\uffff";
    static final String DFA59_maxS =
        "\1\46\16\60\2\uffff";
    static final String DFA59_acceptS =
        "\17\uffff\1\2\1\1";
    static final String DFA59_specialS =
        "\21\uffff}>";
    static final String[] DFA59_transitionS = {
            "\1\1\1\2\10\uffff\1\14\4\uffff\1\7\1\uffff\1\15\1\10\1\uffff"+
            "\1\13\1\5\1\6\1\16\4\uffff\1\12\2\uffff\1\11\1\uffff\1\3\1\4",
            "\1\20\2\17\2\uffff\1\17\10\uffff\2\17\15\uffff\1\17\3\uffff"+
            "\1\17",
            "\1\20\2\17\2\uffff\1\17\10\uffff\2\17\15\uffff\1\17\3\uffff"+
            "\1\17",
            "\1\20\2\17\2\uffff\1\17\10\uffff\2\17\15\uffff\1\17\3\uffff"+
            "\1\17",
            "\1\20\2\17\2\uffff\1\17\10\uffff\2\17\15\uffff\1\17\3\uffff"+
            "\1\17",
            "\1\20\2\17\2\uffff\1\17\10\uffff\2\17\15\uffff\1\17\3\uffff"+
            "\1\17",
            "\1\20\2\17\2\uffff\1\17\10\uffff\2\17\15\uffff\1\17\3\uffff"+
            "\1\17",
            "\1\20\2\17\2\uffff\1\17\10\uffff\2\17\15\uffff\1\17\3\uffff"+
            "\1\17",
            "\1\20\2\17\2\uffff\1\17\10\uffff\2\17\15\uffff\1\17\3\uffff"+
            "\1\17",
            "\1\20\2\17\2\uffff\1\17\10\uffff\2\17\15\uffff\1\17\3\uffff"+
            "\1\17",
            "\1\20\2\17\2\uffff\1\17\10\uffff\2\17\15\uffff\1\17\3\uffff"+
            "\1\17",
            "\1\20\2\17\2\uffff\1\17\10\uffff\2\17\15\uffff\1\17\3\uffff"+
            "\1\17",
            "\1\20\2\17\2\uffff\1\17\10\uffff\2\17\15\uffff\1\17\3\uffff"+
            "\1\17",
            "\1\20\2\17\2\uffff\1\17\10\uffff\2\17\15\uffff\1\17\3\uffff"+
            "\1\17",
            "\1\20\2\17\2\uffff\1\17\10\uffff\2\17\15\uffff\1\17\3\uffff"+
            "\1\17",
            "",
            ""
    };

    static final short[] DFA59_eot = DFA.unpackEncodedString(DFA59_eotS);
    static final short[] DFA59_eof = DFA.unpackEncodedString(DFA59_eofS);
    static final char[] DFA59_min = DFA.unpackEncodedStringToUnsignedChars(DFA59_minS);
    static final char[] DFA59_max = DFA.unpackEncodedStringToUnsignedChars(DFA59_maxS);
    static final short[] DFA59_accept = DFA.unpackEncodedString(DFA59_acceptS);
    static final short[] DFA59_special = DFA.unpackEncodedString(DFA59_specialS);
    static final short[][] DFA59_transition;

    static {
        int numStates = DFA59_transitionS.length;
        DFA59_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA59_transition[i] = DFA.unpackEncodedString(DFA59_transitionS[i]);
        }
    }

    class DFA59 extends DFA {

        public DFA59(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 59;
            this.eot = DFA59_eot;
            this.eof = DFA59_eof;
            this.min = DFA59_min;
            this.max = DFA59_max;
            this.accept = DFA59_accept;
            this.special = DFA59_special;
            this.transition = DFA59_transition;
        }
        public String getDescription() {
            return "3408:1: ( ( ( ( ( ruleUnrestrictedName ) ) otherlv_1= '::' ( ( ( ruleUnreservedName ) ) otherlv_3= '::' )* ) ( ( ruleUnreservedName ) ) ) | ( ( ruleUnrestrictedName ) ) )";
        }
    }
    static final String DFA58_eotS =
        "\37\uffff";
    static final String DFA58_eofS =
        "\1\uffff\34\35\2\uffff";
    static final String DFA58_minS =
        "\1\4\34\17\2\uffff";
    static final String DFA58_maxS =
        "\1\104\34\60\2\uffff";
    static final String DFA58_acceptS =
        "\35\uffff\1\2\1\1";
    static final String DFA58_specialS =
        "\37\uffff}>";
    static final String[] DFA58_transitionS = {
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

    static final short[] DFA58_eot = DFA.unpackEncodedString(DFA58_eotS);
    static final short[] DFA58_eof = DFA.unpackEncodedString(DFA58_eofS);
    static final char[] DFA58_min = DFA.unpackEncodedStringToUnsignedChars(DFA58_minS);
    static final char[] DFA58_max = DFA.unpackEncodedStringToUnsignedChars(DFA58_maxS);
    static final short[] DFA58_accept = DFA.unpackEncodedString(DFA58_acceptS);
    static final short[] DFA58_special = DFA.unpackEncodedString(DFA58_specialS);
    static final short[][] DFA58_transition;

    static {
        int numStates = DFA58_transitionS.length;
        DFA58_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA58_transition[i] = DFA.unpackEncodedString(DFA58_transitionS[i]);
        }
    }

    class DFA58 extends DFA {

        public DFA58(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 58;
            this.eot = DFA58_eot;
            this.eof = DFA58_eof;
            this.min = DFA58_min;
            this.max = DFA58_max;
            this.accept = DFA58_accept;
            this.special = DFA58_special;
            this.transition = DFA58_transition;
        }
        public String getDescription() {
            return "()* loopback of 3430:1: ( ( ( ruleUnreservedName ) ) otherlv_3= '::' )*";
        }
    }
    static final String DFA62_eotS =
        "\23\uffff";
    static final String DFA62_eofS =
        "\1\21\22\uffff";
    static final String DFA62_minS =
        "\1\21\20\0\2\uffff";
    static final String DFA62_maxS =
        "\1\117\20\0\2\uffff";
    static final String DFA62_acceptS =
        "\21\uffff\1\2\1\1";
    static final String DFA62_specialS =
        "\1\uffff\1\5\1\14\1\2\1\6\1\11\1\12\1\16\1\0\1\15\1\13\1\4\1\7"+
        "\1\10\1\3\1\17\1\1\2\uffff}>";
    static final String[] DFA62_transitionS = {
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
            return "3601:1: ( () ( ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) )+ )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA62_8 = input.LA(1);

                         
                        int index62_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred104_InternalQVTcore()) ) {s = 18;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index62_8);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA62_16 = input.LA(1);

                         
                        int index62_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred104_InternalQVTcore()) ) {s = 18;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index62_16);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA62_3 = input.LA(1);

                         
                        int index62_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred104_InternalQVTcore()) ) {s = 18;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index62_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA62_14 = input.LA(1);

                         
                        int index62_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred104_InternalQVTcore()) ) {s = 18;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index62_14);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA62_11 = input.LA(1);

                         
                        int index62_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred104_InternalQVTcore()) ) {s = 18;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index62_11);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA62_1 = input.LA(1);

                         
                        int index62_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred104_InternalQVTcore()) ) {s = 18;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index62_1);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA62_4 = input.LA(1);

                         
                        int index62_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred104_InternalQVTcore()) ) {s = 18;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index62_4);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA62_12 = input.LA(1);

                         
                        int index62_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred104_InternalQVTcore()) ) {s = 18;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index62_12);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA62_13 = input.LA(1);

                         
                        int index62_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred104_InternalQVTcore()) ) {s = 18;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index62_13);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA62_5 = input.LA(1);

                         
                        int index62_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred104_InternalQVTcore()) ) {s = 18;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index62_5);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA62_6 = input.LA(1);

                         
                        int index62_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred104_InternalQVTcore()) ) {s = 18;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index62_6);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA62_10 = input.LA(1);

                         
                        int index62_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred104_InternalQVTcore()) ) {s = 18;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index62_10);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA62_2 = input.LA(1);

                         
                        int index62_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred104_InternalQVTcore()) ) {s = 18;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index62_2);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA62_9 = input.LA(1);

                         
                        int index62_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred104_InternalQVTcore()) ) {s = 18;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index62_9);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA62_7 = input.LA(1);

                         
                        int index62_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred104_InternalQVTcore()) ) {s = 18;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index62_7);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA62_15 = input.LA(1);

                         
                        int index62_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred104_InternalQVTcore()) ) {s = 18;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index62_15);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 62, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA61_eotS =
        "\23\uffff";
    static final String DFA61_eofS =
        "\1\1\22\uffff";
    static final String DFA61_minS =
        "\1\21\1\uffff\20\0\1\uffff";
    static final String DFA61_maxS =
        "\1\117\1\uffff\20\0\1\uffff";
    static final String DFA61_acceptS =
        "\1\uffff\1\2\20\uffff\1\1";
    static final String DFA61_specialS =
        "\2\uffff\1\14\1\5\1\15\1\2\1\6\1\11\1\12\1\16\1\0\1\13\1\4\1\7"+
        "\1\10\1\3\1\17\1\1\1\uffff}>";
    static final String[] DFA61_transitionS = {
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
            return "()+ loopback of 3610:2: ( ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) )+";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA61_10 = input.LA(1);

                         
                        int index61_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred103_InternalQVTcore()) ) {s = 18;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_10);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA61_17 = input.LA(1);

                         
                        int index61_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred103_InternalQVTcore()) ) {s = 18;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_17);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA61_5 = input.LA(1);

                         
                        int index61_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred103_InternalQVTcore()) ) {s = 18;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_5);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA61_15 = input.LA(1);

                         
                        int index61_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred103_InternalQVTcore()) ) {s = 18;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_15);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA61_12 = input.LA(1);

                         
                        int index61_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred103_InternalQVTcore()) ) {s = 18;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_12);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA61_3 = input.LA(1);

                         
                        int index61_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred103_InternalQVTcore()) ) {s = 18;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_3);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA61_6 = input.LA(1);

                         
                        int index61_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred103_InternalQVTcore()) ) {s = 18;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_6);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA61_13 = input.LA(1);

                         
                        int index61_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred103_InternalQVTcore()) ) {s = 18;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_13);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA61_14 = input.LA(1);

                         
                        int index61_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred103_InternalQVTcore()) ) {s = 18;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_14);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA61_7 = input.LA(1);

                         
                        int index61_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred103_InternalQVTcore()) ) {s = 18;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_7);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA61_8 = input.LA(1);

                         
                        int index61_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred103_InternalQVTcore()) ) {s = 18;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_8);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA61_11 = input.LA(1);

                         
                        int index61_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred103_InternalQVTcore()) ) {s = 18;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_11);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA61_2 = input.LA(1);

                         
                        int index61_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred103_InternalQVTcore()) ) {s = 18;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_2);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA61_4 = input.LA(1);

                         
                        int index61_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred103_InternalQVTcore()) ) {s = 18;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_4);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA61_9 = input.LA(1);

                         
                        int index61_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred103_InternalQVTcore()) ) {s = 18;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_9);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA61_16 = input.LA(1);

                         
                        int index61_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred103_InternalQVTcore()) ) {s = 18;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_16);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 61, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA66_eotS =
        "\52\uffff";
    static final String DFA66_eofS =
        "\52\uffff";
    static final String DFA66_minS =
        "\1\4\26\uffff\6\0\15\uffff";
    static final String DFA66_maxS =
        "\1\121\26\uffff\6\0\15\uffff";
    static final String DFA66_acceptS =
        "\1\uffff\1\1\15\uffff\1\2\1\3\14\uffff\1\6\7\uffff\1\7\1\10\1\11"+
        "\1\4\1\5";
    static final String DFA66_specialS =
        "\27\uffff\1\0\1\1\1\2\1\3\1\4\1\5\15\uffff}>";
    static final String[] DFA66_transitionS = {
            "\2\1\2\20\6\uffff\1\1\4\uffff\1\1\1\uffff\2\1\1\uffff\4\1\1"+
            "\47\3\uffff\1\1\2\uffff\1\1\1\uffff\2\1\3\uffff\1\20\14\uffff"+
            "\1\27\10\35\1\30\1\31\1\32\1\33\1\34\1\uffff\4\20\2\uffff\1"+
            "\46\3\uffff\1\45\1\17",
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
            ""
    };

    static final short[] DFA66_eot = DFA.unpackEncodedString(DFA66_eotS);
    static final short[] DFA66_eof = DFA.unpackEncodedString(DFA66_eofS);
    static final char[] DFA66_min = DFA.unpackEncodedStringToUnsignedChars(DFA66_minS);
    static final char[] DFA66_max = DFA.unpackEncodedStringToUnsignedChars(DFA66_maxS);
    static final short[] DFA66_accept = DFA.unpackEncodedString(DFA66_acceptS);
    static final short[] DFA66_special = DFA.unpackEncodedString(DFA66_specialS);
    static final short[][] DFA66_transition;

    static {
        int numStates = DFA66_transitionS.length;
        DFA66_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA66_transition[i] = DFA.unpackEncodedString(DFA66_transitionS[i]);
        }
    }

    class DFA66 extends DFA {

        public DFA66(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 66;
            this.eot = DFA66_eot;
            this.eof = DFA66_eof;
            this.min = DFA66_min;
            this.max = DFA66_max;
            this.accept = DFA66_accept;
            this.special = DFA66_special;
            this.transition = DFA66_transition;
        }
        public String getDescription() {
            return "3909:1: (this_NavigatingExpCS_0= ruleNavigatingExpCS | this_SelfExpCS_1= ruleSelfExpCS | this_PrimitiveLiteralExpCS_2= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_3= ruleTupleLiteralExpCS | this_CollectionLiteralExpCS_4= ruleCollectionLiteralExpCS | this_TypeLiteralExpCS_5= ruleTypeLiteralExpCS | this_LetExpCS_6= ruleLetExpCS | this_IfExpCS_7= ruleIfExpCS | this_NestedExpCS_8= ruleNestedExpCS )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA66_23 = input.LA(1);

                         
                        int index66_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred111_InternalQVTcore()) ) {s = 40;}

                        else if ( (synpred113_InternalQVTcore()) ) {s = 29;}

                         
                        input.seek(index66_23);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA66_24 = input.LA(1);

                         
                        int index66_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred112_InternalQVTcore()) ) {s = 41;}

                        else if ( (synpred113_InternalQVTcore()) ) {s = 29;}

                         
                        input.seek(index66_24);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA66_25 = input.LA(1);

                         
                        int index66_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred112_InternalQVTcore()) ) {s = 41;}

                        else if ( (synpred113_InternalQVTcore()) ) {s = 29;}

                         
                        input.seek(index66_25);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA66_26 = input.LA(1);

                         
                        int index66_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred112_InternalQVTcore()) ) {s = 41;}

                        else if ( (synpred113_InternalQVTcore()) ) {s = 29;}

                         
                        input.seek(index66_26);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA66_27 = input.LA(1);

                         
                        int index66_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred112_InternalQVTcore()) ) {s = 41;}

                        else if ( (synpred113_InternalQVTcore()) ) {s = 29;}

                         
                        input.seek(index66_27);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA66_28 = input.LA(1);

                         
                        int index66_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred112_InternalQVTcore()) ) {s = 41;}

                        else if ( (synpred113_InternalQVTcore()) ) {s = 29;}

                         
                        input.seek(index66_28);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 66, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA68_eotS =
        "\21\uffff";
    static final String DFA68_eofS =
        "\1\uffff\16\17\2\uffff";
    static final String DFA68_minS =
        "\1\4\16\17\2\uffff";
    static final String DFA68_maxS =
        "\1\46\16\117\2\uffff";
    static final String DFA68_acceptS =
        "\17\uffff\1\2\1\1";
    static final String DFA68_specialS =
        "\21\uffff}>";
    static final String[] DFA68_transitionS = {
            "\1\1\1\2\10\uffff\1\14\4\uffff\1\7\1\uffff\1\15\1\10\1\uffff"+
            "\1\13\1\5\1\6\1\16\4\uffff\1\12\2\uffff\1\11\1\uffff\1\3\1\4",
            "\1\20\1\uffff\2\17\1\uffff\1\17\2\uffff\1\17\4\uffff\4\17"+
            "\2\uffff\1\17\1\uffff\1\17\2\uffff\2\17\1\uffff\15\17\16\uffff"+
            "\1\17\4\uffff\2\17\1\uffff\3\17",
            "\1\20\1\uffff\2\17\1\uffff\1\17\2\uffff\1\17\4\uffff\4\17"+
            "\2\uffff\1\17\1\uffff\1\17\2\uffff\2\17\1\uffff\15\17\16\uffff"+
            "\1\17\4\uffff\2\17\1\uffff\3\17",
            "\1\20\1\uffff\2\17\1\uffff\1\17\2\uffff\1\17\4\uffff\4\17"+
            "\2\uffff\1\17\1\uffff\1\17\2\uffff\2\17\1\uffff\15\17\16\uffff"+
            "\1\17\4\uffff\2\17\1\uffff\3\17",
            "\1\20\1\uffff\2\17\1\uffff\1\17\2\uffff\1\17\4\uffff\4\17"+
            "\2\uffff\1\17\1\uffff\1\17\2\uffff\2\17\1\uffff\15\17\16\uffff"+
            "\1\17\4\uffff\2\17\1\uffff\3\17",
            "\1\20\1\uffff\2\17\1\uffff\1\17\2\uffff\1\17\4\uffff\4\17"+
            "\2\uffff\1\17\1\uffff\1\17\2\uffff\2\17\1\uffff\15\17\16\uffff"+
            "\1\17\4\uffff\2\17\1\uffff\3\17",
            "\1\20\1\uffff\2\17\1\uffff\1\17\2\uffff\1\17\4\uffff\4\17"+
            "\2\uffff\1\17\1\uffff\1\17\2\uffff\2\17\1\uffff\15\17\16\uffff"+
            "\1\17\4\uffff\2\17\1\uffff\3\17",
            "\1\20\1\uffff\2\17\1\uffff\1\17\2\uffff\1\17\4\uffff\4\17"+
            "\2\uffff\1\17\1\uffff\1\17\2\uffff\2\17\1\uffff\15\17\16\uffff"+
            "\1\17\4\uffff\2\17\1\uffff\3\17",
            "\1\20\1\uffff\2\17\1\uffff\1\17\2\uffff\1\17\4\uffff\4\17"+
            "\2\uffff\1\17\1\uffff\1\17\2\uffff\2\17\1\uffff\15\17\16\uffff"+
            "\1\17\4\uffff\2\17\1\uffff\3\17",
            "\1\20\1\uffff\2\17\1\uffff\1\17\2\uffff\1\17\4\uffff\4\17"+
            "\2\uffff\1\17\1\uffff\1\17\2\uffff\2\17\1\uffff\15\17\16\uffff"+
            "\1\17\4\uffff\2\17\1\uffff\3\17",
            "\1\20\1\uffff\2\17\1\uffff\1\17\2\uffff\1\17\4\uffff\4\17"+
            "\2\uffff\1\17\1\uffff\1\17\2\uffff\2\17\1\uffff\15\17\16\uffff"+
            "\1\17\4\uffff\2\17\1\uffff\3\17",
            "\1\20\1\uffff\2\17\1\uffff\1\17\2\uffff\1\17\4\uffff\4\17"+
            "\2\uffff\1\17\1\uffff\1\17\2\uffff\2\17\1\uffff\15\17\16\uffff"+
            "\1\17\4\uffff\2\17\1\uffff\3\17",
            "\1\20\1\uffff\2\17\1\uffff\1\17\2\uffff\1\17\4\uffff\4\17"+
            "\2\uffff\1\17\1\uffff\1\17\2\uffff\2\17\1\uffff\15\17\16\uffff"+
            "\1\17\4\uffff\2\17\1\uffff\3\17",
            "\1\20\1\uffff\2\17\1\uffff\1\17\2\uffff\1\17\4\uffff\4\17"+
            "\2\uffff\1\17\1\uffff\1\17\2\uffff\2\17\1\uffff\15\17\16\uffff"+
            "\1\17\4\uffff\2\17\1\uffff\3\17",
            "\1\20\1\uffff\2\17\1\uffff\1\17\2\uffff\1\17\4\uffff\4\17"+
            "\2\uffff\1\17\1\uffff\1\17\2\uffff\2\17\1\uffff\15\17\16\uffff"+
            "\1\17\4\uffff\2\17\1\uffff\3\17",
            "",
            ""
    };

    static final short[] DFA68_eot = DFA.unpackEncodedString(DFA68_eotS);
    static final short[] DFA68_eof = DFA.unpackEncodedString(DFA68_eofS);
    static final char[] DFA68_min = DFA.unpackEncodedStringToUnsignedChars(DFA68_minS);
    static final char[] DFA68_max = DFA.unpackEncodedStringToUnsignedChars(DFA68_maxS);
    static final short[] DFA68_accept = DFA.unpackEncodedString(DFA68_acceptS);
    static final short[] DFA68_special = DFA.unpackEncodedString(DFA68_specialS);
    static final short[][] DFA68_transition;

    static {
        int numStates = DFA68_transitionS.length;
        DFA68_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA68_transition[i] = DFA.unpackEncodedString(DFA68_transitionS[i]);
        }
    }

    class DFA68 extends DFA {

        public DFA68(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 68;
            this.eot = DFA68_eot;
            this.eof = DFA68_eof;
            this.min = DFA68_min;
            this.max = DFA68_max;
            this.accept = DFA68_accept;
            this.special = DFA68_special;
            this.transition = DFA68_transition;
        }
        public String getDescription() {
            return "4046:1: ( ( ( ( ( ruleUnrestrictedName ) ) otherlv_1= '::' ( ( ( ruleUnreservedName ) ) otherlv_3= '::' )* ) ( ( ruleUnreservedName ) ) ) | ( ( ruleUnrestrictedName ) ) )";
        }
    }
    static final String DFA67_eotS =
        "\37\uffff";
    static final String DFA67_eofS =
        "\1\uffff\34\36\2\uffff";
    static final String DFA67_minS =
        "\1\4\34\17\2\uffff";
    static final String DFA67_maxS =
        "\1\104\34\117\2\uffff";
    static final String DFA67_acceptS =
        "\35\uffff\1\1\1\2";
    static final String DFA67_specialS =
        "\37\uffff}>";
    static final String[] DFA67_transitionS = {
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

    static final short[] DFA67_eot = DFA.unpackEncodedString(DFA67_eotS);
    static final short[] DFA67_eof = DFA.unpackEncodedString(DFA67_eofS);
    static final char[] DFA67_min = DFA.unpackEncodedStringToUnsignedChars(DFA67_minS);
    static final char[] DFA67_max = DFA.unpackEncodedStringToUnsignedChars(DFA67_maxS);
    static final short[] DFA67_accept = DFA.unpackEncodedString(DFA67_acceptS);
    static final short[] DFA67_special = DFA.unpackEncodedString(DFA67_specialS);
    static final short[][] DFA67_transition;

    static {
        int numStates = DFA67_transitionS.length;
        DFA67_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA67_transition[i] = DFA.unpackEncodedString(DFA67_transitionS[i]);
        }
    }

    class DFA67 extends DFA {

        public DFA67(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 67;
            this.eot = DFA67_eot;
            this.eof = DFA67_eof;
            this.min = DFA67_min;
            this.max = DFA67_max;
            this.accept = DFA67_accept;
            this.special = DFA67_special;
            this.transition = DFA67_transition;
        }
        public String getDescription() {
            return "()* loopback of 4068:1: ( ( ( ruleUnreservedName ) ) otherlv_3= '::' )*";
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
        public static final BitSet FOLLOW_ruleEssentialOCLUnrestrictedIdentifier_in_entryRuleEssentialOCLUnrestrictedIdentifier3714 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEssentialOCLUnrestrictedIdentifier3725 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_ruleEssentialOCLUnrestrictedIdentifier3763 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_ruleEssentialOCLUnrestrictedIdentifier3782 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLPrefixOperator_in_entryRuleEssentialOCLPrefixOperator3823 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEssentialOCLPrefixOperator3834 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_40_in_ruleEssentialOCLPrefixOperator3872 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_41_in_ruleEssentialOCLPrefixOperator3891 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLInfixOperator_in_entryRuleEssentialOCLInfixOperator3932 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEssentialOCLInfixOperator3943 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_42_in_ruleEssentialOCLInfixOperator3981 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_43_in_ruleEssentialOCLInfixOperator4000 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_39_in_ruleEssentialOCLInfixOperator4019 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_40_in_ruleEssentialOCLInfixOperator4038 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_44_in_ruleEssentialOCLInfixOperator4057 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_45_in_ruleEssentialOCLInfixOperator4076 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_46_in_ruleEssentialOCLInfixOperator4095 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_47_in_ruleEssentialOCLInfixOperator4114 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_48_in_ruleEssentialOCLInfixOperator4133 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_49_in_ruleEssentialOCLInfixOperator4152 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_50_in_ruleEssentialOCLInfixOperator4171 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_51_in_ruleEssentialOCLInfixOperator4190 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_52_in_ruleEssentialOCLInfixOperator4209 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_53_in_ruleEssentialOCLInfixOperator4228 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLNavigationOperator_in_entryRuleEssentialOCLNavigationOperator4269 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEssentialOCLNavigationOperator4280 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_ruleEssentialOCLNavigationOperator4318 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_54_in_ruleEssentialOCLNavigationOperator4337 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_entryRuleIdentifier4378 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIdentifier4389 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleID_in_ruleIdentifier4436 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLUnrestrictedIdentifier_in_ruleIdentifier4469 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral4515 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteral4526 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_SINGLE_QUOTED_STRING_in_ruleStringLiteral4565 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrefixOperator_in_entryRulePrefixOperator4610 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrefixOperator4621 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLPrefixOperator_in_rulePrefixOperator4667 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInfixOperator_in_entryRuleInfixOperator4712 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleInfixOperator4723 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLInfixOperator_in_ruleInfixOperator4769 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigationOperator_in_entryRuleNavigationOperator4814 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigationOperator4825 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLNavigationOperator_in_ruleNavigationOperator4871 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLUnrestrictedName_in_entryRuleEssentialOCLUnrestrictedName4916 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEssentialOCLUnrestrictedName4927 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_ruleEssentialOCLUnrestrictedName4973 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLUnreservedName_in_entryRuleEssentialOCLUnreservedName5018 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEssentialOCLUnreservedName5029 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleEssentialOCLUnreservedName5076 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionTypeIdentifier_in_ruleEssentialOCLUnreservedName5109 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveTypeIdentifier_in_ruleEssentialOCLUnreservedName5142 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_55_in_ruleEssentialOCLUnreservedName5166 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnreservedName_in_entryRuleUnreservedName5207 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnreservedName5218 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLUnreservedName_in_ruleUnreservedName5264 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveTypeIdentifier_in_entryRulePrimitiveTypeIdentifier5309 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrimitiveTypeIdentifier5320 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_56_in_rulePrimitiveTypeIdentifier5358 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_57_in_rulePrimitiveTypeIdentifier5377 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_58_in_rulePrimitiveTypeIdentifier5396 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_59_in_rulePrimitiveTypeIdentifier5415 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_60_in_rulePrimitiveTypeIdentifier5434 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_61_in_rulePrimitiveTypeIdentifier5453 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_62_in_rulePrimitiveTypeIdentifier5472 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_63_in_rulePrimitiveTypeIdentifier5491 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveTypeCS_in_entryRulePrimitiveTypeCS5531 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrimitiveTypeCS5541 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveTypeIdentifier_in_rulePrimitiveTypeCS5586 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionTypeIdentifier_in_entryRuleCollectionTypeIdentifier5622 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCollectionTypeIdentifier5633 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_64_in_ruleCollectionTypeIdentifier5671 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_65_in_ruleCollectionTypeIdentifier5690 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_66_in_ruleCollectionTypeIdentifier5709 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_67_in_ruleCollectionTypeIdentifier5728 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_68_in_ruleCollectionTypeIdentifier5747 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionTypeCS_in_entryRuleCollectionTypeCS5787 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCollectionTypeCS5797 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionTypeIdentifier_in_ruleCollectionTypeCS5843 = new BitSet(new long[]{0x0000200010000002L});
        public static final BitSet FOLLOW_28_in_ruleCollectionTypeCS5857 = new BitSet(new long[]{0xFF8000690F684030L,0x000000000000001FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleCollectionTypeCS5878 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_29_in_ruleCollectionTypeCS5890 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_45_in_ruleCollectionTypeCS5910 = new BitSet(new long[]{0xFF8000690F684030L,0x000000000000001FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleCollectionTypeCS5931 = new BitSet(new long[]{0x0000100000000000L});
        public static final BitSet FOLLOW_44_in_ruleCollectionTypeCS5943 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTupleTypeCS_in_entryRuleTupleTypeCS5982 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTupleTypeCS5992 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_55_in_ruleTupleTypeCS6035 = new BitSet(new long[]{0x0000200010000002L});
        public static final BitSet FOLLOW_28_in_ruleTupleTypeCS6062 = new BitSet(new long[]{0x000000692F684030L});
        public static final BitSet FOLLOW_ruletuplePartCS_in_ruleTupleTypeCS6084 = new BitSet(new long[]{0x0000000020100000L});
        public static final BitSet FOLLOW_20_in_ruleTupleTypeCS6097 = new BitSet(new long[]{0x000000690F684030L});
        public static final BitSet FOLLOW_ruletuplePartCS_in_ruleTupleTypeCS6118 = new BitSet(new long[]{0x0000000020100000L});
        public static final BitSet FOLLOW_29_in_ruleTupleTypeCS6134 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_45_in_ruleTupleTypeCS6154 = new BitSet(new long[]{0x000010690F684030L});
        public static final BitSet FOLLOW_ruletuplePartCS_in_ruleTupleTypeCS6176 = new BitSet(new long[]{0x0000100000100000L});
        public static final BitSet FOLLOW_20_in_ruleTupleTypeCS6189 = new BitSet(new long[]{0x000000690F684030L});
        public static final BitSet FOLLOW_ruletuplePartCS_in_ruleTupleTypeCS6210 = new BitSet(new long[]{0x0000100000100000L});
        public static final BitSet FOLLOW_44_in_ruleTupleTypeCS6226 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruletuplePartCS_in_entryRuletuplePartCS6265 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuletuplePartCS6275 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruletuplePartCS6321 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_31_in_ruletuplePartCS6333 = new BitSet(new long[]{0xFF8000690F684030L,0x000000000000001FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruletuplePartCS6354 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionLiteralExpCS_in_entryRuleCollectionLiteralExpCS6390 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCollectionLiteralExpCS6400 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionTypeCS_in_ruleCollectionLiteralExpCS6446 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleCollectionLiteralExpCS6458 = new BitSet(new long[]{0xFF8007691F6C40F0L,0x00000000000313DFL});
        public static final BitSet FOLLOW_ruleCollectionLiteralPartCS_in_ruleCollectionLiteralExpCS6480 = new BitSet(new long[]{0x0000000000140000L});
        public static final BitSet FOLLOW_20_in_ruleCollectionLiteralExpCS6493 = new BitSet(new long[]{0xFF8007691F6840F0L,0x00000000000313DFL});
        public static final BitSet FOLLOW_ruleCollectionLiteralPartCS_in_ruleCollectionLiteralExpCS6514 = new BitSet(new long[]{0x0000000000140000L});
        public static final BitSet FOLLOW_18_in_ruleCollectionLiteralExpCS6530 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionLiteralPartCS_in_entryRuleCollectionLiteralPartCS6566 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCollectionLiteralPartCS6576 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleCollectionLiteralPartCS6622 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000020L});
        public static final BitSet FOLLOW_69_in_ruleCollectionLiteralPartCS6635 = new BitSet(new long[]{0xFF8007691F6840F0L,0x00000000000313DFL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleCollectionLiteralPartCS6656 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveLiteralExpCS_in_entryRulePrimitiveLiteralExpCS6694 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrimitiveLiteralExpCS6704 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNumberLiteralExpCS_in_rulePrimitiveLiteralExpCS6754 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringLiteralExpCS_in_rulePrimitiveLiteralExpCS6784 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBooleanLiteralExpCS_in_rulePrimitiveLiteralExpCS6814 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnlimitedNaturalLiteralExpCS_in_rulePrimitiveLiteralExpCS6844 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInvalidLiteralExpCS_in_rulePrimitiveLiteralExpCS6874 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNullLiteralExpCS_in_rulePrimitiveLiteralExpCS6904 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTupleLiteralExpCS_in_entryRuleTupleLiteralExpCS6939 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTupleLiteralExpCS6949 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_55_in_ruleTupleLiteralExpCS6986 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleTupleLiteralExpCS6998 = new BitSet(new long[]{0x000000690F684030L});
        public static final BitSet FOLLOW_ruleTupleLiteralPartCS_in_ruleTupleLiteralExpCS7019 = new BitSet(new long[]{0x0000000000140000L});
        public static final BitSet FOLLOW_20_in_ruleTupleLiteralExpCS7032 = new BitSet(new long[]{0x000000690F684030L});
        public static final BitSet FOLLOW_ruleTupleLiteralPartCS_in_ruleTupleLiteralExpCS7053 = new BitSet(new long[]{0x0000000000140000L});
        public static final BitSet FOLLOW_18_in_ruleTupleLiteralExpCS7067 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTupleLiteralPartCS_in_entryRuleTupleLiteralPartCS7103 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTupleLiteralPartCS7113 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleTupleLiteralPartCS7159 = new BitSet(new long[]{0x0001000080000000L});
        public static final BitSet FOLLOW_31_in_ruleTupleLiteralPartCS7172 = new BitSet(new long[]{0xFF8000690F684030L,0x000000000000001FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleTupleLiteralPartCS7193 = new BitSet(new long[]{0x0001000000000000L});
        public static final BitSet FOLLOW_48_in_ruleTupleLiteralPartCS7207 = new BitSet(new long[]{0xFF8007691F6840F0L,0x00000000000313DFL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleTupleLiteralPartCS7228 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNumberLiteralExpCS_in_entryRuleNumberLiteralExpCS7264 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNumberLiteralExpCS7274 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNUMBER_LITERAL_in_ruleNumberLiteralExpCS7319 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringLiteralExpCS_in_entryRuleStringLiteralExpCS7354 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteralExpCS7364 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringLiteral_in_ruleStringLiteralExpCS7409 = new BitSet(new long[]{0x0000000000000082L});
        public static final BitSet FOLLOW_ruleBooleanLiteralExpCS_in_entryRuleBooleanLiteralExpCS7445 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBooleanLiteralExpCS7455 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_70_in_ruleBooleanLiteralExpCS7498 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_71_in_ruleBooleanLiteralExpCS7535 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnlimitedNaturalLiteralExpCS_in_entryRuleUnlimitedNaturalLiteralExpCS7584 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnlimitedNaturalLiteralExpCS7594 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_42_in_ruleUnlimitedNaturalLiteralExpCS7643 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInvalidLiteralExpCS_in_entryRuleInvalidLiteralExpCS7679 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleInvalidLiteralExpCS7689 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_72_in_ruleInvalidLiteralExpCS7738 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNullLiteralExpCS_in_entryRuleNullLiteralExpCS7774 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNullLiteralExpCS7784 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_73_in_ruleNullLiteralExpCS7833 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralCS_in_entryRuleTypeLiteralCS7869 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeLiteralCS7879 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveTypeCS_in_ruleTypeLiteralCS7929 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionTypeCS_in_ruleTypeLiteralCS7959 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTupleTypeCS_in_ruleTypeLiteralCS7989 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralExpCS_in_entryRuleTypeLiteralExpCS8024 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeLiteralExpCS8034 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralCS_in_ruleTypeLiteralExpCS8079 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeNameExpCS_in_entryRuleTypeNameExpCS8114 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeNameExpCS8124 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleTypeNameExpCS8178 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleTypeNameExpCS8190 = new BitSet(new long[]{0xFF8000690F684030L,0x000000000000001FL});
        public static final BitSet FOLLOW_ruleUnreservedName_in_ruleTypeNameExpCS8218 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleTypeNameExpCS8230 = new BitSet(new long[]{0xFF8000690F684030L,0x000000000000001FL});
        public static final BitSet FOLLOW_ruleUnreservedName_in_ruleTypeNameExpCS8260 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleTypeNameExpCS8294 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_entryRuleTypeExpCS8330 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeExpCS8340 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeNameExpCS_in_ruleTypeExpCS8390 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralCS_in_ruleTypeExpCS8420 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpCS_in_entryRuleExpCS8455 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleExpCS8465 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInfixedExpCS_in_ruleExpCS8514 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInfixedExpCS_in_entryRuleInfixedExpCS8548 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleInfixedExpCS8558 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrefixedExpCS_in_ruleInfixedExpCS8608 = new BitSet(new long[]{0x007FFD9000000002L});
        public static final BitSet FOLLOW_ruleBinaryOperatorCS_in_ruleInfixedExpCS8642 = new BitSet(new long[]{0xFF8007691F6840F0L,0x00000000000313DFL});
        public static final BitSet FOLLOW_rulePrefixedExpCS_in_ruleInfixedExpCS8663 = new BitSet(new long[]{0x007FFD9000000002L});
        public static final BitSet FOLLOW_ruleBinaryOperatorCS_in_entryRuleBinaryOperatorCS8703 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBinaryOperatorCS8713 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInfixOperatorCS_in_ruleBinaryOperatorCS8763 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigationOperatorCS_in_ruleBinaryOperatorCS8793 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInfixOperatorCS_in_entryRuleInfixOperatorCS8828 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleInfixOperatorCS8838 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInfixOperator_in_ruleInfixOperatorCS8883 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigationOperatorCS_in_entryRuleNavigationOperatorCS8918 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigationOperatorCS8928 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigationOperator_in_ruleNavigationOperatorCS8973 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrefixedExpCS_in_entryRulePrefixedExpCS9008 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrefixedExpCS9018 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimaryExpCS_in_rulePrefixedExpCS9068 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnaryOperatorCS_in_rulePrefixedExpCS9107 = new BitSet(new long[]{0xFF8007691F6840F0L,0x00000000000313DFL});
        public static final BitSet FOLLOW_rulePrimaryExpCS_in_rulePrefixedExpCS9129 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnaryOperatorCS_in_entryRuleUnaryOperatorCS9166 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnaryOperatorCS9176 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrefixOperator_in_ruleUnaryOperatorCS9221 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimaryExpCS_in_entryRulePrimaryExpCS9256 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpCS9266 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingExpCS_in_rulePrimaryExpCS9316 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSelfExpCS_in_rulePrimaryExpCS9346 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveLiteralExpCS_in_rulePrimaryExpCS9376 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTupleLiteralExpCS_in_rulePrimaryExpCS9406 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionLiteralExpCS_in_rulePrimaryExpCS9436 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralExpCS_in_rulePrimaryExpCS9466 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLetExpCS_in_rulePrimaryExpCS9496 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIfExpCS_in_rulePrimaryExpCS9526 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedExpCS_in_rulePrimaryExpCS9556 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNameExpCS_in_entryRuleNameExpCS9591 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNameExpCS9601 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleNameExpCS9655 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleNameExpCS9667 = new BitSet(new long[]{0xFF8000690F684030L,0x000000000000001FL});
        public static final BitSet FOLLOW_ruleUnreservedName_in_ruleNameExpCS9695 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleNameExpCS9707 = new BitSet(new long[]{0xFF8000690F684030L,0x000000000000001FL});
        public static final BitSet FOLLOW_ruleUnreservedName_in_ruleNameExpCS9737 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleNameExpCS9771 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIndexExpCS_in_entryRuleIndexExpCS9807 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIndexExpCS9817 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNameExpCS_in_ruleIndexExpCS9867 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000400L});
        public static final BitSet FOLLOW_74_in_ruleIndexExpCS9891 = new BitSet(new long[]{0xFF8007691F6840F0L,0x00000000000313DFL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleIndexExpCS9912 = new BitSet(new long[]{0x0000000000100000L,0x0000000000000800L});
        public static final BitSet FOLLOW_20_in_ruleIndexExpCS9925 = new BitSet(new long[]{0xFF8007691F6840F0L,0x00000000000313DFL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleIndexExpCS9946 = new BitSet(new long[]{0x0000000000100000L,0x0000000000000800L});
        public static final BitSet FOLLOW_75_in_ruleIndexExpCS9960 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000400L});
        public static final BitSet FOLLOW_74_in_ruleIndexExpCS9973 = new BitSet(new long[]{0xFF8007691F6840F0L,0x00000000000313DFL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleIndexExpCS9994 = new BitSet(new long[]{0x0000000000100000L,0x0000000000000800L});
        public static final BitSet FOLLOW_20_in_ruleIndexExpCS10007 = new BitSet(new long[]{0xFF8007691F6840F0L,0x00000000000313DFL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleIndexExpCS10028 = new BitSet(new long[]{0x0000000000100000L,0x0000000000000800L});
        public static final BitSet FOLLOW_75_in_ruleIndexExpCS10042 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingExpCS_Base_in_entryRuleNavigatingExpCS_Base10082 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigatingExpCS_Base10092 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIndexExpCS_in_ruleNavigatingExpCS_Base10141 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingExpCS_in_entryRuleNavigatingExpCS10175 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigatingExpCS10185 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingExpCS_Base_in_ruleNavigatingExpCS10235 = new BitSet(new long[]{0x0000000010000002L});
        public static final BitSet FOLLOW_28_in_ruleNavigatingExpCS10259 = new BitSet(new long[]{0xFF8007693F6840F0L,0x00000000000313DFL});
        public static final BitSet FOLLOW_ruleNavigatingArgCS_in_ruleNavigatingExpCS10281 = new BitSet(new long[]{0x0000000060120000L});
        public static final BitSet FOLLOW_ruleNavigatingCommaArgCS_in_ruleNavigatingExpCS10302 = new BitSet(new long[]{0x0000000060120000L});
        public static final BitSet FOLLOW_ruleNavigatingSemiArgCS_in_ruleNavigatingExpCS10325 = new BitSet(new long[]{0x0000000060100000L});
        public static final BitSet FOLLOW_ruleNavigatingCommaArgCS_in_ruleNavigatingExpCS10346 = new BitSet(new long[]{0x0000000060100000L});
        public static final BitSet FOLLOW_ruleNavigatingBarArgCS_in_ruleNavigatingExpCS10371 = new BitSet(new long[]{0x0000000020100000L});
        public static final BitSet FOLLOW_ruleNavigatingCommaArgCS_in_ruleNavigatingExpCS10392 = new BitSet(new long[]{0x0000000020100000L});
        public static final BitSet FOLLOW_29_in_ruleNavigatingExpCS10409 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingArgCS_in_entryRuleNavigatingArgCS10447 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigatingArgCS10457 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingArgCS10503 = new BitSet(new long[]{0x0001000080000002L});
        public static final BitSet FOLLOW_31_in_ruleNavigatingArgCS10516 = new BitSet(new long[]{0xFF8000690F684030L,0x000000000000001FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleNavigatingArgCS10537 = new BitSet(new long[]{0x0001000000000002L});
        public static final BitSet FOLLOW_48_in_ruleNavigatingArgCS10552 = new BitSet(new long[]{0xFF8007691F6840F0L,0x00000000000313DFL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNavigatingArgCS10573 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingBarArgCS_in_entryRuleNavigatingBarArgCS10611 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigatingBarArgCS10621 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_ruleNavigatingBarArgCS10664 = new BitSet(new long[]{0xFF8007691F6840F0L,0x00000000000313DFL});
        public static final BitSet FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingBarArgCS10698 = new BitSet(new long[]{0x0001000080000002L});
        public static final BitSet FOLLOW_31_in_ruleNavigatingBarArgCS10711 = new BitSet(new long[]{0xFF8000690F684030L,0x000000000000001FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleNavigatingBarArgCS10732 = new BitSet(new long[]{0x0001000000000002L});
        public static final BitSet FOLLOW_48_in_ruleNavigatingBarArgCS10747 = new BitSet(new long[]{0xFF8007691F6840F0L,0x00000000000313DFL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNavigatingBarArgCS10768 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingCommaArgCS_in_entryRuleNavigatingCommaArgCS10806 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigatingCommaArgCS10816 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleNavigatingCommaArgCS10859 = new BitSet(new long[]{0xFF8007691F6840F0L,0x00000000000313DFL});
        public static final BitSet FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingCommaArgCS10893 = new BitSet(new long[]{0x0001000080000002L});
        public static final BitSet FOLLOW_31_in_ruleNavigatingCommaArgCS10906 = new BitSet(new long[]{0xFF8000690F684030L,0x000000000000001FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleNavigatingCommaArgCS10927 = new BitSet(new long[]{0x0001000000000002L});
        public static final BitSet FOLLOW_48_in_ruleNavigatingCommaArgCS10942 = new BitSet(new long[]{0xFF8007691F6840F0L,0x00000000000313DFL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNavigatingCommaArgCS10963 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingSemiArgCS_in_entryRuleNavigatingSemiArgCS11001 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigatingSemiArgCS11011 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleNavigatingSemiArgCS11054 = new BitSet(new long[]{0xFF8007691F6840F0L,0x00000000000313DFL});
        public static final BitSet FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingSemiArgCS11088 = new BitSet(new long[]{0x0001000080000002L});
        public static final BitSet FOLLOW_31_in_ruleNavigatingSemiArgCS11101 = new BitSet(new long[]{0xFF8000690F684030L,0x000000000000001FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleNavigatingSemiArgCS11122 = new BitSet(new long[]{0x0001000000000002L});
        public static final BitSet FOLLOW_48_in_ruleNavigatingSemiArgCS11137 = new BitSet(new long[]{0xFF8007691F6840F0L,0x00000000000313DFL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNavigatingSemiArgCS11158 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingArgExpCS_in_entryRuleNavigatingArgExpCS11196 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigatingArgExpCS11206 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNavigatingArgExpCS11255 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIfExpCS_in_entryRuleIfExpCS11289 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIfExpCS11299 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_76_in_ruleIfExpCS11336 = new BitSet(new long[]{0xFF8007691F6840F0L,0x00000000000313DFL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleIfExpCS11357 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
        public static final BitSet FOLLOW_77_in_ruleIfExpCS11369 = new BitSet(new long[]{0xFF8007691F6840F0L,0x00000000000313DFL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleIfExpCS11390 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
        public static final BitSet FOLLOW_78_in_ruleIfExpCS11402 = new BitSet(new long[]{0xFF8007691F6840F0L,0x00000000000313DFL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleIfExpCS11423 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
        public static final BitSet FOLLOW_79_in_ruleIfExpCS11435 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLetExpCS_in_entryRuleLetExpCS11471 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLetExpCS11481 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_80_in_ruleLetExpCS11518 = new BitSet(new long[]{0x000000690F684030L});
        public static final BitSet FOLLOW_ruleLetVariableCS_in_ruleLetExpCS11539 = new BitSet(new long[]{0x0000000000900000L});
        public static final BitSet FOLLOW_20_in_ruleLetExpCS11552 = new BitSet(new long[]{0x000000690F684030L});
        public static final BitSet FOLLOW_ruleLetVariableCS_in_ruleLetExpCS11573 = new BitSet(new long[]{0x0000000000900000L});
        public static final BitSet FOLLOW_23_in_ruleLetExpCS11587 = new BitSet(new long[]{0xFF8007691F6840F0L,0x00000000000313DFL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleLetExpCS11608 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLetVariableCS_in_entryRuleLetVariableCS11644 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLetVariableCS11654 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleLetVariableCS11700 = new BitSet(new long[]{0x0001000080000000L});
        public static final BitSet FOLLOW_31_in_ruleLetVariableCS11713 = new BitSet(new long[]{0xFF8000690F684030L,0x000000000000001FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleLetVariableCS11734 = new BitSet(new long[]{0x0001000000000000L});
        public static final BitSet FOLLOW_48_in_ruleLetVariableCS11748 = new BitSet(new long[]{0xFF8007691F6840F0L,0x00000000000313DFL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleLetVariableCS11769 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedExpCS_in_entryRuleNestedExpCS11805 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNestedExpCS11815 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_ruleNestedExpCS11852 = new BitSet(new long[]{0xFF8007691F6840F0L,0x00000000000313DFL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNestedExpCS11873 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_29_in_ruleNestedExpCS11885 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSelfExpCS_in_entryRuleSelfExpCS11921 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSelfExpCS11931 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_81_in_ruleSelfExpCS11980 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_synpred16_InternalQVTcore956 = new BitSet(new long[]{0x000000690F684030L});
        public static final BitSet FOLLOW_26_in_synpred16_InternalQVTcore971 = new BitSet(new long[]{0x000000690F684030L});
        public static final BitSet FOLLOW_ruleDirectionNameCS_in_synpred16_InternalQVTcore992 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_ruleDomainCS_in_synpred16_InternalQVTcore1012 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePredicateCS_in_synpred26_InternalQVTcore2133 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_synpred42_InternalQVTcore3557 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_INT_in_synpred42_InternalQVTcore3572 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_45_in_synpred79_InternalQVTcore5910 = new BitSet(new long[]{0xFF8000690F684030L,0x000000000000001FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_synpred79_InternalQVTcore5931 = new BitSet(new long[]{0x0000100000000000L});
        public static final BitSet FOLLOW_44_in_synpred79_InternalQVTcore5943 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_45_in_synpred85_InternalQVTcore6154 = new BitSet(new long[]{0x000010690F684030L});
        public static final BitSet FOLLOW_ruletuplePartCS_in_synpred85_InternalQVTcore6176 = new BitSet(new long[]{0x0000100000100000L});
        public static final BitSet FOLLOW_20_in_synpred85_InternalQVTcore6189 = new BitSet(new long[]{0x000000690F684030L});
        public static final BitSet FOLLOW_ruletuplePartCS_in_synpred85_InternalQVTcore6210 = new BitSet(new long[]{0x0000100000100000L});
        public static final BitSet FOLLOW_44_in_synpred85_InternalQVTcore6226 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBinaryOperatorCS_in_synpred103_InternalQVTcore8642 = new BitSet(new long[]{0xFF8007691F6840F0L,0x00000000000313DFL});
        public static final BitSet FOLLOW_rulePrefixedExpCS_in_synpred103_InternalQVTcore8663 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBinaryOperatorCS_in_synpred104_InternalQVTcore8642 = new BitSet(new long[]{0xFF8007691F6840F0L,0x00000000000313DFL});
        public static final BitSet FOLLOW_rulePrefixedExpCS_in_synpred104_InternalQVTcore8663 = new BitSet(new long[]{0x007FFD9000000002L});
        public static final BitSet FOLLOW_ruleTupleLiteralExpCS_in_synpred111_InternalQVTcore9406 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionLiteralExpCS_in_synpred112_InternalQVTcore9436 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralExpCS_in_synpred113_InternalQVTcore9466 = new BitSet(new long[]{0x0000000000000002L});
    }


}