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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_SIMPLE_ID", "RULE_ESCAPED_ID", "RULE_INT", "RULE_SINGLE_QUOTED_STRING", "RULE_ESCAPED_CHARACTER", "RULE_LETTER_CHARACTER", "RULE_DOUBLE_QUOTED_STRING", "RULE_ML_SINGLE_QUOTED_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'map'", "'in'", "'refines'", "','", "'{'", "'where'", "'}'", "'|'", "'default'", "':='", "';'", "'imports'", "'uses'", "'('", "')'", "'import'", "':'", "'::'", "'*'", "'library'", "'check'", "'enforce'", "'query'", "'transformation'", "'realize'", "'-'", "'not'", "'/'", "'+'", "'>'", "'<'", "'>='", "'<='", "'='", "'<>'", "'and'", "'or'", "'xor'", "'implies'", "'.'", "'->'", "'Tuple'", "'Boolean'", "'Integer'", "'Real'", "'String'", "'UnlimitedNatural'", "'OclAny'", "'OclInvalid'", "'OclVoid'", "'Set'", "'Bag'", "'Sequence'", "'Collection'", "'OrderedSet'", "'..'", "'['", "']'", "'?'", "'true'", "'false'", "'invalid'", "'null'", "'@'", "'pre'", "'if'", "'then'", "'else'", "'endif'", "'let'", "'self'"
    };
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__64=64;
    public static final int T__29=29;
    public static final int T__65=65;
    public static final int T__28=28;
    public static final int T__62=62;
    public static final int T__27=27;
    public static final int T__63=63;
    public static final int T__26=26;
    public static final int RULE_ESCAPED_CHARACTER=8;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=15;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_ESCAPED_ID=5;
    public static final int RULE_DOUBLE_QUOTED_STRING=10;
    public static final int T__61=61;
    public static final int T__60=60;
    public static final int EOF=-1;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__19=19;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__16=16;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__18=18;
    public static final int T__53=53;
    public static final int T__17=17;
    public static final int T__54=54;
    public static final int T__59=59;
    public static final int RULE_SIMPLE_ID=4;
    public static final int RULE_INT=6;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int RULE_ML_SINGLE_QUOTED_STRING=11;
    public static final int T__41=41;
    public static final int T__80=80;
    public static final int T__46=46;
    public static final int T__81=81;
    public static final int T__47=47;
    public static final int T__82=82;
    public static final int T__44=44;
    public static final int T__83=83;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int RULE_SINGLE_QUOTED_STRING=7;
    public static final int T__85=85;
    public static final int RULE_SL_COMMENT=13;
    public static final int T__84=84;
    public static final int T__86=86;
    public static final int RULE_ML_COMMENT=12;
    public static final int RULE_LETTER_CHARACTER=9;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__71=71;
    public static final int T__33=33;
    public static final int T__72=72;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__70=70;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_WS=14;
    public static final int T__76=76;
    public static final int T__75=75;
    public static final int T__74=74;
    public static final int T__73=73;
    public static final int T__79=79;
    public static final int T__78=78;
    public static final int T__77=77;

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:82:1: ruleTopLevelCS returns [EObject current=null] : ( ( ( (lv_ownedImport_0_0= ruleImportCS ) ) | ( (lv_ownedLibrary_1_0= ruleLibraryCS ) ) )* ( ( (lv_mappings_2_0= ruleMappingCS ) ) | ( (lv_transformations_3_0= ruleTransformationCS ) ) | ( (lv_queries_4_0= ruleQueryCS ) ) )* ) ;
    public final EObject ruleTopLevelCS() throws RecognitionException {
        EObject current = null;

        EObject lv_ownedImport_0_0 = null;

        EObject lv_ownedLibrary_1_0 = null;

        EObject lv_mappings_2_0 = null;

        EObject lv_transformations_3_0 = null;

        EObject lv_queries_4_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:85:28: ( ( ( ( (lv_ownedImport_0_0= ruleImportCS ) ) | ( (lv_ownedLibrary_1_0= ruleLibraryCS ) ) )* ( ( (lv_mappings_2_0= ruleMappingCS ) ) | ( (lv_transformations_3_0= ruleTransformationCS ) ) | ( (lv_queries_4_0= ruleQueryCS ) ) )* ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:86:1: ( ( ( (lv_ownedImport_0_0= ruleImportCS ) ) | ( (lv_ownedLibrary_1_0= ruleLibraryCS ) ) )* ( ( (lv_mappings_2_0= ruleMappingCS ) ) | ( (lv_transformations_3_0= ruleTransformationCS ) ) | ( (lv_queries_4_0= ruleQueryCS ) ) )* )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:86:1: ( ( ( (lv_ownedImport_0_0= ruleImportCS ) ) | ( (lv_ownedLibrary_1_0= ruleLibraryCS ) ) )* ( ( (lv_mappings_2_0= ruleMappingCS ) ) | ( (lv_transformations_3_0= ruleTransformationCS ) ) | ( (lv_queries_4_0= ruleQueryCS ) ) )* )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:86:2: ( ( (lv_ownedImport_0_0= ruleImportCS ) ) | ( (lv_ownedLibrary_1_0= ruleLibraryCS ) ) )* ( ( (lv_mappings_2_0= ruleMappingCS ) ) | ( (lv_transformations_3_0= ruleTransformationCS ) ) | ( (lv_queries_4_0= ruleQueryCS ) ) )*
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:86:2: ( ( (lv_ownedImport_0_0= ruleImportCS ) ) | ( (lv_ownedLibrary_1_0= ruleLibraryCS ) ) )*
            loop1:
            do {
                int alt1=3;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==31) ) {
                    alt1=1;
                }
                else if ( (LA1_0==35) ) {
                    alt1=2;
                }


                switch (alt1) {
            	case 1 :
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:86:3: ( (lv_ownedImport_0_0= ruleImportCS ) )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:86:3: ( (lv_ownedImport_0_0= ruleImportCS ) )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:87:1: (lv_ownedImport_0_0= ruleImportCS )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:87:1: (lv_ownedImport_0_0= ruleImportCS )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:88:3: lv_ownedImport_0_0= ruleImportCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTopLevelCSAccess().getOwnedImportImportCSParserRuleCall_0_0_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleImportCS_in_ruleTopLevelCS138);
            	    lv_ownedImport_0_0=ruleImportCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getTopLevelCSRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedImport",
            	              		lv_ownedImport_0_0, 
            	              		"ImportCS");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:105:6: ( (lv_ownedLibrary_1_0= ruleLibraryCS ) )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:105:6: ( (lv_ownedLibrary_1_0= ruleLibraryCS ) )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:106:1: (lv_ownedLibrary_1_0= ruleLibraryCS )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:106:1: (lv_ownedLibrary_1_0= ruleLibraryCS )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:107:3: lv_ownedLibrary_1_0= ruleLibraryCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTopLevelCSAccess().getOwnedLibraryLibraryCSParserRuleCall_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleLibraryCS_in_ruleTopLevelCS165);
            	    lv_ownedLibrary_1_0=ruleLibraryCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getTopLevelCSRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedLibrary",
            	              		lv_ownedLibrary_1_0, 
            	              		"LibraryCS");
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:123:4: ( ( (lv_mappings_2_0= ruleMappingCS ) ) | ( (lv_transformations_3_0= ruleTransformationCS ) ) | ( (lv_queries_4_0= ruleQueryCS ) ) )*
            loop2:
            do {
                int alt2=4;
                switch ( input.LA(1) ) {
                case 16:
                    {
                    alt2=1;
                    }
                    break;
                case 39:
                    {
                    alt2=2;
                    }
                    break;
                case 38:
                    {
                    alt2=3;
                    }
                    break;

                }

                switch (alt2) {
            	case 1 :
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:123:5: ( (lv_mappings_2_0= ruleMappingCS ) )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:123:5: ( (lv_mappings_2_0= ruleMappingCS ) )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:124:1: (lv_mappings_2_0= ruleMappingCS )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:124:1: (lv_mappings_2_0= ruleMappingCS )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:125:3: lv_mappings_2_0= ruleMappingCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTopLevelCSAccess().getMappingsMappingCSParserRuleCall_1_0_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleMappingCS_in_ruleTopLevelCS189);
            	    lv_mappings_2_0=ruleMappingCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getTopLevelCSRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"mappings",
            	              		lv_mappings_2_0, 
            	              		"MappingCS");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:142:6: ( (lv_transformations_3_0= ruleTransformationCS ) )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:142:6: ( (lv_transformations_3_0= ruleTransformationCS ) )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:143:1: (lv_transformations_3_0= ruleTransformationCS )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:143:1: (lv_transformations_3_0= ruleTransformationCS )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:144:3: lv_transformations_3_0= ruleTransformationCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTopLevelCSAccess().getTransformationsTransformationCSParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleTransformationCS_in_ruleTopLevelCS216);
            	    lv_transformations_3_0=ruleTransformationCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getTopLevelCSRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"transformations",
            	              		lv_transformations_3_0, 
            	              		"TransformationCS");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:161:6: ( (lv_queries_4_0= ruleQueryCS ) )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:161:6: ( (lv_queries_4_0= ruleQueryCS ) )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:162:1: (lv_queries_4_0= ruleQueryCS )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:162:1: (lv_queries_4_0= ruleQueryCS )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:163:3: lv_queries_4_0= ruleQueryCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTopLevelCSAccess().getQueriesQueryCSParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleQueryCS_in_ruleTopLevelCS243);
            	    lv_queries_4_0=ruleQueryCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getTopLevelCSRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"queries",
            	              		lv_queries_4_0, 
            	              		"QueryCS");
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:187:1: entryRuleMappingCS returns [EObject current=null] : iv_ruleMappingCS= ruleMappingCS EOF ;
    public final EObject entryRuleMappingCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMappingCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:188:2: (iv_ruleMappingCS= ruleMappingCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:189:2: iv_ruleMappingCS= ruleMappingCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMappingCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMappingCS_in_entryRuleMappingCS281);
            iv_ruleMappingCS=ruleMappingCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMappingCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMappingCS291); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:196:1: ruleMappingCS returns [EObject current=null] : ( () otherlv_1= 'map' ( (lv_name_2_0= ruleUnrestrictedName ) )? (otherlv_3= 'in' ( ( ruleUnrestrictedName ) ) )? (otherlv_5= 'refines' ( ( ruleUnrestrictedName ) ) (otherlv_7= ',' ( ( ruleUnrestrictedName ) ) )* )? otherlv_9= '{' ( (lv_domains_10_0= ruleNamedDomainCS ) )* (otherlv_11= 'where' ( (lv_middle_12_0= ruleUnnamedDomainCS ) ) )? ( (lv_composedMappings_13_0= ruleMappingCS ) )* otherlv_14= '}' ) ;
    public final EObject ruleMappingCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_14=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_domains_10_0 = null;

        EObject lv_middle_12_0 = null;

        EObject lv_composedMappings_13_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:199:28: ( ( () otherlv_1= 'map' ( (lv_name_2_0= ruleUnrestrictedName ) )? (otherlv_3= 'in' ( ( ruleUnrestrictedName ) ) )? (otherlv_5= 'refines' ( ( ruleUnrestrictedName ) ) (otherlv_7= ',' ( ( ruleUnrestrictedName ) ) )* )? otherlv_9= '{' ( (lv_domains_10_0= ruleNamedDomainCS ) )* (otherlv_11= 'where' ( (lv_middle_12_0= ruleUnnamedDomainCS ) ) )? ( (lv_composedMappings_13_0= ruleMappingCS ) )* otherlv_14= '}' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:200:1: ( () otherlv_1= 'map' ( (lv_name_2_0= ruleUnrestrictedName ) )? (otherlv_3= 'in' ( ( ruleUnrestrictedName ) ) )? (otherlv_5= 'refines' ( ( ruleUnrestrictedName ) ) (otherlv_7= ',' ( ( ruleUnrestrictedName ) ) )* )? otherlv_9= '{' ( (lv_domains_10_0= ruleNamedDomainCS ) )* (otherlv_11= 'where' ( (lv_middle_12_0= ruleUnnamedDomainCS ) ) )? ( (lv_composedMappings_13_0= ruleMappingCS ) )* otherlv_14= '}' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:200:1: ( () otherlv_1= 'map' ( (lv_name_2_0= ruleUnrestrictedName ) )? (otherlv_3= 'in' ( ( ruleUnrestrictedName ) ) )? (otherlv_5= 'refines' ( ( ruleUnrestrictedName ) ) (otherlv_7= ',' ( ( ruleUnrestrictedName ) ) )* )? otherlv_9= '{' ( (lv_domains_10_0= ruleNamedDomainCS ) )* (otherlv_11= 'where' ( (lv_middle_12_0= ruleUnnamedDomainCS ) ) )? ( (lv_composedMappings_13_0= ruleMappingCS ) )* otherlv_14= '}' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:200:2: () otherlv_1= 'map' ( (lv_name_2_0= ruleUnrestrictedName ) )? (otherlv_3= 'in' ( ( ruleUnrestrictedName ) ) )? (otherlv_5= 'refines' ( ( ruleUnrestrictedName ) ) (otherlv_7= ',' ( ( ruleUnrestrictedName ) ) )* )? otherlv_9= '{' ( (lv_domains_10_0= ruleNamedDomainCS ) )* (otherlv_11= 'where' ( (lv_middle_12_0= ruleUnnamedDomainCS ) ) )? ( (lv_composedMappings_13_0= ruleMappingCS ) )* otherlv_14= '}'
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:200:2: ()
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:201:2: 
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

            otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleMappingCS340); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getMappingCSAccess().getMapKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:213:1: ( (lv_name_2_0= ruleUnrestrictedName ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0>=RULE_SIMPLE_ID && LA3_0<=RULE_ESCAPED_ID)||LA3_0==16||(LA3_0>=27 && LA3_0<=28)||LA3_0==31||(LA3_0>=35 && LA3_0<=40)) ) {
                alt3=1;
            }
            else if ( (LA3_0==18) ) {
                int LA3_2 = input.LA(2);

                if ( (LA3_2==17||LA3_2==20) ) {
                    alt3=1;
                }
                else if ( (LA3_2==18) ) {
                    int LA3_4 = input.LA(3);

                    if ( ((LA3_4>=RULE_SIMPLE_ID && LA3_4<=RULE_ESCAPED_ID)||LA3_4==16||LA3_4==18||(LA3_4>=27 && LA3_4<=28)||LA3_4==31||(LA3_4>=35 && LA3_4<=40)) ) {
                        alt3=1;
                    }
                }
            }
            switch (alt3) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:214:1: (lv_name_2_0= ruleUnrestrictedName )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:214:1: (lv_name_2_0= ruleUnrestrictedName )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:215:3: lv_name_2_0= ruleUnrestrictedName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMappingCSAccess().getNameUnrestrictedNameParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleMappingCS361);
                    lv_name_2_0=ruleUnrestrictedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getMappingCSRule());
                      	        }
                             		set(
                             			current, 
                             			"name",
                              		lv_name_2_0, 
                              		"UnrestrictedName");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:231:3: (otherlv_3= 'in' ( ( ruleUnrestrictedName ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==17) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:231:5: otherlv_3= 'in' ( ( ruleUnrestrictedName ) )
                    {
                    otherlv_3=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleMappingCS375); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getMappingCSAccess().getInKeyword_3_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:235:1: ( ( ruleUnrestrictedName ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:236:1: ( ruleUnrestrictedName )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:236:1: ( ruleUnrestrictedName )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:237:3: ruleUnrestrictedName
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
                       
                      	        newCompositeNode(grammarAccess.getMappingCSAccess().getInTransformationCrossReference_3_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleMappingCS402);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:253:4: (otherlv_5= 'refines' ( ( ruleUnrestrictedName ) ) (otherlv_7= ',' ( ( ruleUnrestrictedName ) ) )* )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==18) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:253:6: otherlv_5= 'refines' ( ( ruleUnrestrictedName ) ) (otherlv_7= ',' ( ( ruleUnrestrictedName ) ) )*
                    {
                    otherlv_5=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleMappingCS417); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getMappingCSAccess().getRefinesKeyword_4_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:257:1: ( ( ruleUnrestrictedName ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:258:1: ( ruleUnrestrictedName )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:258:1: ( ruleUnrestrictedName )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:259:3: ruleUnrestrictedName
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
                       
                      	        newCompositeNode(grammarAccess.getMappingCSAccess().getRefinesMappingCrossReference_4_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleMappingCS444);
                    ruleUnrestrictedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:275:2: (otherlv_7= ',' ( ( ruleUnrestrictedName ) ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==19) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:275:4: otherlv_7= ',' ( ( ruleUnrestrictedName ) )
                    	    {
                    	    otherlv_7=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleMappingCS457); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_7, grammarAccess.getMappingCSAccess().getCommaKeyword_4_2_0());
                    	          
                    	    }
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:279:1: ( ( ruleUnrestrictedName ) )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:280:1: ( ruleUnrestrictedName )
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:280:1: ( ruleUnrestrictedName )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:281:3: ruleUnrestrictedName
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
                    	       
                    	      	        newCompositeNode(grammarAccess.getMappingCSAccess().getRefinesMappingCrossReference_4_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleMappingCS484);
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

            otherlv_9=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleMappingCS500); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_9, grammarAccess.getMappingCSAccess().getLeftCurlyBracketKeyword_5());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:301:1: ( (lv_domains_10_0= ruleNamedDomainCS ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==16) ) {
                    int LA7_2 = input.LA(2);

                    if ( (LA7_2==29) ) {
                        alt7=1;
                    }


                }
                else if ( ((LA7_0>=RULE_SIMPLE_ID && LA7_0<=RULE_ESCAPED_ID)||LA7_0==18||(LA7_0>=27 && LA7_0<=28)||LA7_0==31||(LA7_0>=35 && LA7_0<=40)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:302:1: (lv_domains_10_0= ruleNamedDomainCS )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:302:1: (lv_domains_10_0= ruleNamedDomainCS )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:303:3: lv_domains_10_0= ruleNamedDomainCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMappingCSAccess().getDomainsNamedDomainCSParserRuleCall_6_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleNamedDomainCS_in_ruleMappingCS521);
            	    lv_domains_10_0=ruleNamedDomainCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getMappingCSRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"domains",
            	              		lv_domains_10_0, 
            	              		"NamedDomainCS");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:319:3: (otherlv_11= 'where' ( (lv_middle_12_0= ruleUnnamedDomainCS ) ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==21) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:319:5: otherlv_11= 'where' ( (lv_middle_12_0= ruleUnnamedDomainCS ) )
                    {
                    otherlv_11=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleMappingCS535); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_11, grammarAccess.getMappingCSAccess().getWhereKeyword_7_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:323:1: ( (lv_middle_12_0= ruleUnnamedDomainCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:324:1: (lv_middle_12_0= ruleUnnamedDomainCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:324:1: (lv_middle_12_0= ruleUnnamedDomainCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:325:3: lv_middle_12_0= ruleUnnamedDomainCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMappingCSAccess().getMiddleUnnamedDomainCSParserRuleCall_7_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUnnamedDomainCS_in_ruleMappingCS556);
                    lv_middle_12_0=ruleUnnamedDomainCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getMappingCSRule());
                      	        }
                             		set(
                             			current, 
                             			"middle",
                              		lv_middle_12_0, 
                              		"UnnamedDomainCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:341:4: ( (lv_composedMappings_13_0= ruleMappingCS ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==16) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:342:1: (lv_composedMappings_13_0= ruleMappingCS )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:342:1: (lv_composedMappings_13_0= ruleMappingCS )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:343:3: lv_composedMappings_13_0= ruleMappingCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMappingCSAccess().getComposedMappingsMappingCSParserRuleCall_8_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleMappingCS_in_ruleMappingCS579);
            	    lv_composedMappings_13_0=ruleMappingCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getMappingCSRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"composedMappings",
            	              		lv_composedMappings_13_0, 
            	              		"MappingCS");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            otherlv_14=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleMappingCS592); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_14, grammarAccess.getMappingCSAccess().getRightCurlyBracketKeyword_9());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:371:1: entryRuleBottomPatternCS returns [EObject current=null] : iv_ruleBottomPatternCS= ruleBottomPatternCS EOF ;
    public final EObject entryRuleBottomPatternCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBottomPatternCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:372:2: (iv_ruleBottomPatternCS= ruleBottomPatternCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:373:2: iv_ruleBottomPatternCS= ruleBottomPatternCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBottomPatternCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleBottomPatternCS_in_entryRuleBottomPatternCS628);
            iv_ruleBottomPatternCS=ruleBottomPatternCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBottomPatternCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBottomPatternCS638); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:380:1: ruleBottomPatternCS returns [EObject current=null] : ( (otherlv_0= '{' ( ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_2_0= ruleRealizedVariableCS ) ) ) (otherlv_3= ',' ( ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) ) ) )* otherlv_6= '|' ( (lv_constraints_7_0= ruleAssignmentCS ) )* otherlv_8= '}' ) | ( () otherlv_10= '{' ( (lv_constraints_11_0= ruleAssignmentCS ) )* otherlv_12= '}' ) ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:383:28: ( ( (otherlv_0= '{' ( ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_2_0= ruleRealizedVariableCS ) ) ) (otherlv_3= ',' ( ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) ) ) )* otherlv_6= '|' ( (lv_constraints_7_0= ruleAssignmentCS ) )* otherlv_8= '}' ) | ( () otherlv_10= '{' ( (lv_constraints_11_0= ruleAssignmentCS ) )* otherlv_12= '}' ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:384:1: ( (otherlv_0= '{' ( ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_2_0= ruleRealizedVariableCS ) ) ) (otherlv_3= ',' ( ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) ) ) )* otherlv_6= '|' ( (lv_constraints_7_0= ruleAssignmentCS ) )* otherlv_8= '}' ) | ( () otherlv_10= '{' ( (lv_constraints_11_0= ruleAssignmentCS ) )* otherlv_12= '}' ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:384:1: ( (otherlv_0= '{' ( ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_2_0= ruleRealizedVariableCS ) ) ) (otherlv_3= ',' ( ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) ) ) )* otherlv_6= '|' ( (lv_constraints_7_0= ruleAssignmentCS ) )* otherlv_8= '}' ) | ( () otherlv_10= '{' ( (lv_constraints_11_0= ruleAssignmentCS ) )* otherlv_12= '}' ) )
            int alt15=2;
            alt15 = dfa15.predict(input);
            switch (alt15) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:384:2: (otherlv_0= '{' ( ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_2_0= ruleRealizedVariableCS ) ) ) (otherlv_3= ',' ( ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) ) ) )* otherlv_6= '|' ( (lv_constraints_7_0= ruleAssignmentCS ) )* otherlv_8= '}' )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:384:2: (otherlv_0= '{' ( ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_2_0= ruleRealizedVariableCS ) ) ) (otherlv_3= ',' ( ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) ) ) )* otherlv_6= '|' ( (lv_constraints_7_0= ruleAssignmentCS ) )* otherlv_8= '}' )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:384:4: otherlv_0= '{' ( ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_2_0= ruleRealizedVariableCS ) ) ) (otherlv_3= ',' ( ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) ) ) )* otherlv_6= '|' ( (lv_constraints_7_0= ruleAssignmentCS ) )* otherlv_8= '}'
                    {
                    otherlv_0=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleBottomPatternCS676); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getBottomPatternCSAccess().getLeftCurlyBracketKeyword_0_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:388:1: ( ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_2_0= ruleRealizedVariableCS ) ) )
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( ((LA10_0>=RULE_SIMPLE_ID && LA10_0<=RULE_ESCAPED_ID)||LA10_0==16||LA10_0==18||(LA10_0>=27 && LA10_0<=28)||LA10_0==31||(LA10_0>=35 && LA10_0<=39)) ) {
                        alt10=1;
                    }
                    else if ( (LA10_0==40) ) {
                        int LA10_2 = input.LA(2);

                        if ( ((LA10_2>=RULE_SIMPLE_ID && LA10_2<=RULE_ESCAPED_ID)||LA10_2==16||LA10_2==18||(LA10_2>=27 && LA10_2<=28)||LA10_2==31||(LA10_2>=35 && LA10_2<=40)) ) {
                            alt10=2;
                        }
                        else if ( (LA10_2==32) ) {
                            alt10=1;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 10, 2, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 10, 0, input);

                        throw nvae;
                    }
                    switch (alt10) {
                        case 1 :
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:388:2: ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:388:2: ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:389:1: (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:389:1: (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:390:3: lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getBottomPatternCSAccess().getUnrealizedVariablesUnrealizedVariableCSParserRuleCall_0_1_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleUnrealizedVariableCS_in_ruleBottomPatternCS698);
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
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:407:6: ( (lv_realizedVariables_2_0= ruleRealizedVariableCS ) )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:407:6: ( (lv_realizedVariables_2_0= ruleRealizedVariableCS ) )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:408:1: (lv_realizedVariables_2_0= ruleRealizedVariableCS )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:408:1: (lv_realizedVariables_2_0= ruleRealizedVariableCS )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:409:3: lv_realizedVariables_2_0= ruleRealizedVariableCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getBottomPatternCSAccess().getRealizedVariablesRealizedVariableCSParserRuleCall_0_1_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleRealizedVariableCS_in_ruleBottomPatternCS725);
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

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:425:3: (otherlv_3= ',' ( ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) ) ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==19) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:425:5: otherlv_3= ',' ( ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) ) )
                    	    {
                    	    otherlv_3=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleBottomPatternCS739); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getBottomPatternCSAccess().getCommaKeyword_0_2_0());
                    	          
                    	    }
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:429:1: ( ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) ) )
                    	    int alt11=2;
                    	    int LA11_0 = input.LA(1);

                    	    if ( ((LA11_0>=RULE_SIMPLE_ID && LA11_0<=RULE_ESCAPED_ID)||LA11_0==16||LA11_0==18||(LA11_0>=27 && LA11_0<=28)||LA11_0==31||(LA11_0>=35 && LA11_0<=39)) ) {
                    	        alt11=1;
                    	    }
                    	    else if ( (LA11_0==40) ) {
                    	        int LA11_2 = input.LA(2);

                    	        if ( (LA11_2==32) ) {
                    	            alt11=1;
                    	        }
                    	        else if ( ((LA11_2>=RULE_SIMPLE_ID && LA11_2<=RULE_ESCAPED_ID)||LA11_2==16||LA11_2==18||(LA11_2>=27 && LA11_2<=28)||LA11_2==31||(LA11_2>=35 && LA11_2<=40)) ) {
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
                    	            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:429:2: ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) )
                    	            {
                    	            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:429:2: ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) )
                    	            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:430:1: (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS )
                    	            {
                    	            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:430:1: (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS )
                    	            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:431:3: lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS
                    	            {
                    	            if ( state.backtracking==0 ) {
                    	               
                    	              	        newCompositeNode(grammarAccess.getBottomPatternCSAccess().getUnrealizedVariablesUnrealizedVariableCSParserRuleCall_0_2_1_0_0()); 
                    	              	    
                    	            }
                    	            pushFollow(FollowSets000.FOLLOW_ruleUnrealizedVariableCS_in_ruleBottomPatternCS761);
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
                    	            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:448:6: ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) )
                    	            {
                    	            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:448:6: ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) )
                    	            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:449:1: (lv_realizedVariables_5_0= ruleRealizedVariableCS )
                    	            {
                    	            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:449:1: (lv_realizedVariables_5_0= ruleRealizedVariableCS )
                    	            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:450:3: lv_realizedVariables_5_0= ruleRealizedVariableCS
                    	            {
                    	            if ( state.backtracking==0 ) {
                    	               
                    	              	        newCompositeNode(grammarAccess.getBottomPatternCSAccess().getRealizedVariablesRealizedVariableCSParserRuleCall_0_2_1_1_0()); 
                    	              	    
                    	            }
                    	            pushFollow(FollowSets000.FOLLOW_ruleRealizedVariableCS_in_ruleBottomPatternCS788);
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
                    	    break loop12;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleBottomPatternCS803); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getBottomPatternCSAccess().getVerticalLineKeyword_0_3());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:470:1: ( (lv_constraints_7_0= ruleAssignmentCS ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( ((LA13_0>=RULE_SIMPLE_ID && LA13_0<=RULE_SINGLE_QUOTED_STRING)||LA13_0==16||LA13_0==18||LA13_0==24||(LA13_0>=27 && LA13_0<=29)||LA13_0==31||(LA13_0>=34 && LA13_0<=42)||(LA13_0>=57 && LA13_0<=70)||(LA13_0>=75 && LA13_0<=78)||LA13_0==81||(LA13_0>=85 && LA13_0<=86)) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:471:1: (lv_constraints_7_0= ruleAssignmentCS )
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:471:1: (lv_constraints_7_0= ruleAssignmentCS )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:472:3: lv_constraints_7_0= ruleAssignmentCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getBottomPatternCSAccess().getConstraintsAssignmentCSParserRuleCall_0_4_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleAssignmentCS_in_ruleBottomPatternCS824);
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
                    	    break loop13;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleBottomPatternCS837); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getBottomPatternCSAccess().getRightCurlyBracketKeyword_0_5());
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:493:6: ( () otherlv_10= '{' ( (lv_constraints_11_0= ruleAssignmentCS ) )* otherlv_12= '}' )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:493:6: ( () otherlv_10= '{' ( (lv_constraints_11_0= ruleAssignmentCS ) )* otherlv_12= '}' )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:493:7: () otherlv_10= '{' ( (lv_constraints_11_0= ruleAssignmentCS ) )* otherlv_12= '}'
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:493:7: ()
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:494:2: 
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

                    otherlv_10=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleBottomPatternCS869); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getBottomPatternCSAccess().getLeftCurlyBracketKeyword_1_1());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:506:1: ( (lv_constraints_11_0= ruleAssignmentCS ) )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( ((LA14_0>=RULE_SIMPLE_ID && LA14_0<=RULE_SINGLE_QUOTED_STRING)||LA14_0==16||LA14_0==18||LA14_0==24||(LA14_0>=27 && LA14_0<=29)||LA14_0==31||(LA14_0>=34 && LA14_0<=42)||(LA14_0>=57 && LA14_0<=70)||(LA14_0>=75 && LA14_0<=78)||LA14_0==81||(LA14_0>=85 && LA14_0<=86)) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:507:1: (lv_constraints_11_0= ruleAssignmentCS )
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:507:1: (lv_constraints_11_0= ruleAssignmentCS )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:508:3: lv_constraints_11_0= ruleAssignmentCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getBottomPatternCSAccess().getConstraintsAssignmentCSParserRuleCall_1_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleAssignmentCS_in_ruleBottomPatternCS890);
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
                    	    break loop14;
                        }
                    } while (true);

                    otherlv_12=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleBottomPatternCS903); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:536:1: entryRuleAssignmentCS returns [EObject current=null] : iv_ruleAssignmentCS= ruleAssignmentCS EOF ;
    public final EObject entryRuleAssignmentCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignmentCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:537:2: (iv_ruleAssignmentCS= ruleAssignmentCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:538:2: iv_ruleAssignmentCS= ruleAssignmentCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAssignmentCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAssignmentCS_in_entryRuleAssignmentCS940);
            iv_ruleAssignmentCS=ruleAssignmentCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAssignmentCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAssignmentCS950); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:545:1: ruleAssignmentCS returns [EObject current=null] : ( ( (lv_default_0_0= 'default' ) )? ( (lv_target_1_0= ruleExpCS ) ) (otherlv_2= ':=' ( (lv_initialiser_3_0= ruleExpCS ) ) )? otherlv_4= ';' ) ;
    public final EObject ruleAssignmentCS() throws RecognitionException {
        EObject current = null;

        Token lv_default_0_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_target_1_0 = null;

        EObject lv_initialiser_3_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:548:28: ( ( ( (lv_default_0_0= 'default' ) )? ( (lv_target_1_0= ruleExpCS ) ) (otherlv_2= ':=' ( (lv_initialiser_3_0= ruleExpCS ) ) )? otherlv_4= ';' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:549:1: ( ( (lv_default_0_0= 'default' ) )? ( (lv_target_1_0= ruleExpCS ) ) (otherlv_2= ':=' ( (lv_initialiser_3_0= ruleExpCS ) ) )? otherlv_4= ';' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:549:1: ( ( (lv_default_0_0= 'default' ) )? ( (lv_target_1_0= ruleExpCS ) ) (otherlv_2= ':=' ( (lv_initialiser_3_0= ruleExpCS ) ) )? otherlv_4= ';' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:549:2: ( (lv_default_0_0= 'default' ) )? ( (lv_target_1_0= ruleExpCS ) ) (otherlv_2= ':=' ( (lv_initialiser_3_0= ruleExpCS ) ) )? otherlv_4= ';'
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:549:2: ( (lv_default_0_0= 'default' ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==24) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:550:1: (lv_default_0_0= 'default' )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:550:1: (lv_default_0_0= 'default' )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:551:3: lv_default_0_0= 'default'
                    {
                    lv_default_0_0=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleAssignmentCS993); if (state.failed) return current;
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:564:3: ( (lv_target_1_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:565:1: (lv_target_1_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:565:1: (lv_target_1_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:566:3: lv_target_1_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAssignmentCSAccess().getTargetExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleAssignmentCS1028);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:582:2: (otherlv_2= ':=' ( (lv_initialiser_3_0= ruleExpCS ) ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==25) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:582:4: otherlv_2= ':=' ( (lv_initialiser_3_0= ruleExpCS ) )
                    {
                    otherlv_2=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleAssignmentCS1041); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getAssignmentCSAccess().getColonEqualsSignKeyword_2_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:586:1: ( (lv_initialiser_3_0= ruleExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:587:1: (lv_initialiser_3_0= ruleExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:587:1: (lv_initialiser_3_0= ruleExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:588:3: lv_initialiser_3_0= ruleExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAssignmentCSAccess().getInitialiserExpCSParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleAssignmentCS1062);
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

            otherlv_4=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleAssignmentCS1076); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:616:1: entryRuleDirectionCS returns [EObject current=null] : iv_ruleDirectionCS= ruleDirectionCS EOF ;
    public final EObject entryRuleDirectionCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDirectionCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:617:2: (iv_ruleDirectionCS= ruleDirectionCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:618:2: iv_ruleDirectionCS= ruleDirectionCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDirectionCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleDirectionCS_in_entryRuleDirectionCS1112);
            iv_ruleDirectionCS=ruleDirectionCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDirectionCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDirectionCS1122); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:625:1: ruleDirectionCS returns [EObject current=null] : ( () ( (lv_name_1_0= ruleUnrestrictedName ) )? (otherlv_2= 'imports' ( ( ruleUnrestrictedName ) ) (otherlv_4= ',' ( ( ruleUnrestrictedName ) ) )* )? (otherlv_6= 'uses' ( ( ruleUnrestrictedName ) ) (otherlv_8= ',' ( ( ruleUnrestrictedName ) ) )* )? ) ;
    public final EObject ruleDirectionCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:628:28: ( ( () ( (lv_name_1_0= ruleUnrestrictedName ) )? (otherlv_2= 'imports' ( ( ruleUnrestrictedName ) ) (otherlv_4= ',' ( ( ruleUnrestrictedName ) ) )* )? (otherlv_6= 'uses' ( ( ruleUnrestrictedName ) ) (otherlv_8= ',' ( ( ruleUnrestrictedName ) ) )* )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:629:1: ( () ( (lv_name_1_0= ruleUnrestrictedName ) )? (otherlv_2= 'imports' ( ( ruleUnrestrictedName ) ) (otherlv_4= ',' ( ( ruleUnrestrictedName ) ) )* )? (otherlv_6= 'uses' ( ( ruleUnrestrictedName ) ) (otherlv_8= ',' ( ( ruleUnrestrictedName ) ) )* )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:629:1: ( () ( (lv_name_1_0= ruleUnrestrictedName ) )? (otherlv_2= 'imports' ( ( ruleUnrestrictedName ) ) (otherlv_4= ',' ( ( ruleUnrestrictedName ) ) )* )? (otherlv_6= 'uses' ( ( ruleUnrestrictedName ) ) (otherlv_8= ',' ( ( ruleUnrestrictedName ) ) )* )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:629:2: () ( (lv_name_1_0= ruleUnrestrictedName ) )? (otherlv_2= 'imports' ( ( ruleUnrestrictedName ) ) (otherlv_4= ',' ( ( ruleUnrestrictedName ) ) )* )? (otherlv_6= 'uses' ( ( ruleUnrestrictedName ) ) (otherlv_8= ',' ( ( ruleUnrestrictedName ) ) )* )?
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:629:2: ()
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:630:2: 
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:638:2: ( (lv_name_1_0= ruleUnrestrictedName ) )?
            int alt18=2;
            alt18 = dfa18.predict(input);
            switch (alt18) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:639:1: (lv_name_1_0= ruleUnrestrictedName )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:639:1: (lv_name_1_0= ruleUnrestrictedName )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:640:3: lv_name_1_0= ruleUnrestrictedName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDirectionCSAccess().getNameUnrestrictedNameParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleDirectionCS1180);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:656:3: (otherlv_2= 'imports' ( ( ruleUnrestrictedName ) ) (otherlv_4= ',' ( ( ruleUnrestrictedName ) ) )* )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==27) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:656:5: otherlv_2= 'imports' ( ( ruleUnrestrictedName ) ) (otherlv_4= ',' ( ( ruleUnrestrictedName ) ) )*
                    {
                    otherlv_2=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleDirectionCS1194); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getDirectionCSAccess().getImportsKeyword_2_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:660:1: ( ( ruleUnrestrictedName ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:661:1: ( ruleUnrestrictedName )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:661:1: ( ruleUnrestrictedName )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:662:3: ruleUnrestrictedName
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
                    pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleDirectionCS1221);
                    ruleUnrestrictedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:678:2: (otherlv_4= ',' ( ( ruleUnrestrictedName ) ) )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==19) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:678:4: otherlv_4= ',' ( ( ruleUnrestrictedName ) )
                    	    {
                    	    otherlv_4=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleDirectionCS1234); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_4, grammarAccess.getDirectionCSAccess().getCommaKeyword_2_2_0());
                    	          
                    	    }
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:682:1: ( ( ruleUnrestrictedName ) )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:683:1: ( ruleUnrestrictedName )
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:683:1: ( ruleUnrestrictedName )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:684:3: ruleUnrestrictedName
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
                    	    pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleDirectionCS1261);
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
                    	    break loop19;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:700:6: (otherlv_6= 'uses' ( ( ruleUnrestrictedName ) ) (otherlv_8= ',' ( ( ruleUnrestrictedName ) ) )* )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==28) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:700:8: otherlv_6= 'uses' ( ( ruleUnrestrictedName ) ) (otherlv_8= ',' ( ( ruleUnrestrictedName ) ) )*
                    {
                    otherlv_6=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleDirectionCS1278); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getDirectionCSAccess().getUsesKeyword_3_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:704:1: ( ( ruleUnrestrictedName ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:705:1: ( ruleUnrestrictedName )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:705:1: ( ruleUnrestrictedName )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:706:3: ruleUnrestrictedName
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
                    pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleDirectionCS1305);
                    ruleUnrestrictedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:722:2: (otherlv_8= ',' ( ( ruleUnrestrictedName ) ) )*
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0==19) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:722:4: otherlv_8= ',' ( ( ruleUnrestrictedName ) )
                    	    {
                    	    otherlv_8=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleDirectionCS1318); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_8, grammarAccess.getDirectionCSAccess().getCommaKeyword_3_2_0());
                    	          
                    	    }
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:726:1: ( ( ruleUnrestrictedName ) )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:727:1: ( ruleUnrestrictedName )
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:727:1: ( ruleUnrestrictedName )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:728:3: ruleUnrestrictedName
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
                    	    pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleDirectionCS1345);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:752:1: entryRuleGuardPatternCS returns [EObject current=null] : iv_ruleGuardPatternCS= ruleGuardPatternCS EOF ;
    public final EObject entryRuleGuardPatternCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGuardPatternCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:753:2: (iv_ruleGuardPatternCS= ruleGuardPatternCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:754:2: iv_ruleGuardPatternCS= ruleGuardPatternCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGuardPatternCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleGuardPatternCS_in_entryRuleGuardPatternCS1385);
            iv_ruleGuardPatternCS=ruleGuardPatternCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleGuardPatternCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleGuardPatternCS1395); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:761:1: ruleGuardPatternCS returns [EObject current=null] : ( () otherlv_1= '(' ( ( (lv_unrealizedVariables_2_0= ruleUnrealizedVariableCS ) ) (otherlv_3= ',' ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) )* otherlv_5= '|' )? ( (lv_constraints_6_0= ruleAssignmentCS ) )* otherlv_7= ')' ) ;
    public final EObject ruleGuardPatternCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_unrealizedVariables_2_0 = null;

        EObject lv_unrealizedVariables_4_0 = null;

        EObject lv_constraints_6_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:764:28: ( ( () otherlv_1= '(' ( ( (lv_unrealizedVariables_2_0= ruleUnrealizedVariableCS ) ) (otherlv_3= ',' ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) )* otherlv_5= '|' )? ( (lv_constraints_6_0= ruleAssignmentCS ) )* otherlv_7= ')' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:765:1: ( () otherlv_1= '(' ( ( (lv_unrealizedVariables_2_0= ruleUnrealizedVariableCS ) ) (otherlv_3= ',' ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) )* otherlv_5= '|' )? ( (lv_constraints_6_0= ruleAssignmentCS ) )* otherlv_7= ')' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:765:1: ( () otherlv_1= '(' ( ( (lv_unrealizedVariables_2_0= ruleUnrealizedVariableCS ) ) (otherlv_3= ',' ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) )* otherlv_5= '|' )? ( (lv_constraints_6_0= ruleAssignmentCS ) )* otherlv_7= ')' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:765:2: () otherlv_1= '(' ( ( (lv_unrealizedVariables_2_0= ruleUnrealizedVariableCS ) ) (otherlv_3= ',' ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) )* otherlv_5= '|' )? ( (lv_constraints_6_0= ruleAssignmentCS ) )* otherlv_7= ')'
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:765:2: ()
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:766:2: 
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

            otherlv_1=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleGuardPatternCS1444); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getGuardPatternCSAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:778:1: ( ( (lv_unrealizedVariables_2_0= ruleUnrealizedVariableCS ) ) (otherlv_3= ',' ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) )* otherlv_5= '|' )?
            int alt24=2;
            alt24 = dfa24.predict(input);
            switch (alt24) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:778:2: ( (lv_unrealizedVariables_2_0= ruleUnrealizedVariableCS ) ) (otherlv_3= ',' ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) )* otherlv_5= '|'
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:778:2: ( (lv_unrealizedVariables_2_0= ruleUnrealizedVariableCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:779:1: (lv_unrealizedVariables_2_0= ruleUnrealizedVariableCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:779:1: (lv_unrealizedVariables_2_0= ruleUnrealizedVariableCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:780:3: lv_unrealizedVariables_2_0= ruleUnrealizedVariableCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getGuardPatternCSAccess().getUnrealizedVariablesUnrealizedVariableCSParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUnrealizedVariableCS_in_ruleGuardPatternCS1466);
                    lv_unrealizedVariables_2_0=ruleUnrealizedVariableCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getGuardPatternCSRule());
                      	        }
                             		add(
                             			current, 
                             			"unrealizedVariables",
                              		lv_unrealizedVariables_2_0, 
                              		"UnrealizedVariableCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:796:2: (otherlv_3= ',' ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) )*
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==19) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:796:4: otherlv_3= ',' ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) )
                    	    {
                    	    otherlv_3=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleGuardPatternCS1479); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getGuardPatternCSAccess().getCommaKeyword_2_1_0());
                    	          
                    	    }
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:800:1: ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:801:1: (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS )
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:801:1: (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:802:3: lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getGuardPatternCSAccess().getUnrealizedVariablesUnrealizedVariableCSParserRuleCall_2_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleUnrealizedVariableCS_in_ruleGuardPatternCS1500);
                    	    lv_unrealizedVariables_4_0=ruleUnrealizedVariableCS();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getGuardPatternCSRule());
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

                    	default :
                    	    break loop23;
                        }
                    } while (true);

                    otherlv_5=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleGuardPatternCS1514); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getGuardPatternCSAccess().getVerticalLineKeyword_2_2());
                          
                    }

                    }
                    break;

            }

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:822:3: ( (lv_constraints_6_0= ruleAssignmentCS ) )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( ((LA25_0>=RULE_SIMPLE_ID && LA25_0<=RULE_SINGLE_QUOTED_STRING)||LA25_0==16||LA25_0==18||LA25_0==24||(LA25_0>=27 && LA25_0<=29)||LA25_0==31||(LA25_0>=34 && LA25_0<=42)||(LA25_0>=57 && LA25_0<=70)||(LA25_0>=75 && LA25_0<=78)||LA25_0==81||(LA25_0>=85 && LA25_0<=86)) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:823:1: (lv_constraints_6_0= ruleAssignmentCS )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:823:1: (lv_constraints_6_0= ruleAssignmentCS )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:824:3: lv_constraints_6_0= ruleAssignmentCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getGuardPatternCSAccess().getConstraintsAssignmentCSParserRuleCall_3_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleAssignmentCS_in_ruleGuardPatternCS1537);
            	    lv_constraints_6_0=ruleAssignmentCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getGuardPatternCSRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"constraints",
            	              		lv_constraints_6_0, 
            	              		"AssignmentCS");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

            otherlv_7=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleGuardPatternCS1550); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getGuardPatternCSAccess().getRightParenthesisKeyword_4());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
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


    // $ANTLR start "entryRuleImportCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:852:1: entryRuleImportCS returns [EObject current=null] : iv_ruleImportCS= ruleImportCS EOF ;
    public final EObject entryRuleImportCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:853:2: (iv_ruleImportCS= ruleImportCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:854:2: iv_ruleImportCS= ruleImportCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImportCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleImportCS_in_entryRuleImportCS1586);
            iv_ruleImportCS=ruleImportCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImportCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleImportCS1596); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:861:1: ruleImportCS returns [EObject current=null] : (otherlv_0= 'import' ( ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= ':' )? ( (lv_pathName_3_0= ruleURIPathNameCS ) ) ( ( (lv_all_4_0= '::' ) ) otherlv_5= '*' )? otherlv_6= ';' ) ;
    public final EObject ruleImportCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_all_4_0=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_pathName_3_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:864:28: ( (otherlv_0= 'import' ( ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= ':' )? ( (lv_pathName_3_0= ruleURIPathNameCS ) ) ( ( (lv_all_4_0= '::' ) ) otherlv_5= '*' )? otherlv_6= ';' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:865:1: (otherlv_0= 'import' ( ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= ':' )? ( (lv_pathName_3_0= ruleURIPathNameCS ) ) ( ( (lv_all_4_0= '::' ) ) otherlv_5= '*' )? otherlv_6= ';' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:865:1: (otherlv_0= 'import' ( ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= ':' )? ( (lv_pathName_3_0= ruleURIPathNameCS ) ) ( ( (lv_all_4_0= '::' ) ) otherlv_5= '*' )? otherlv_6= ';' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:865:3: otherlv_0= 'import' ( ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= ':' )? ( (lv_pathName_3_0= ruleURIPathNameCS ) ) ( ( (lv_all_4_0= '::' ) ) otherlv_5= '*' )? otherlv_6= ';'
            {
            otherlv_0=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleImportCS1633); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getImportCSAccess().getImportKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:869:1: ( ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= ':' )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==RULE_SIMPLE_ID) ) {
                int LA26_1 = input.LA(2);

                if ( (LA26_1==32) ) {
                    alt26=1;
                }
            }
            else if ( (LA26_0==RULE_ESCAPED_ID) ) {
                int LA26_2 = input.LA(2);

                if ( (LA26_2==32) ) {
                    alt26=1;
                }
            }
            switch (alt26) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:869:2: ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= ':'
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:869:2: ( (lv_name_1_0= ruleIdentifier ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:870:1: (lv_name_1_0= ruleIdentifier )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:870:1: (lv_name_1_0= ruleIdentifier )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:871:3: lv_name_1_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getImportCSAccess().getNameIdentifierParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_ruleImportCS1655);
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
                              		"Identifier");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_2=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleImportCS1667); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getImportCSAccess().getColonKeyword_1_1());
                          
                    }

                    }
                    break;

            }

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:891:3: ( (lv_pathName_3_0= ruleURIPathNameCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:892:1: (lv_pathName_3_0= ruleURIPathNameCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:892:1: (lv_pathName_3_0= ruleURIPathNameCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:893:3: lv_pathName_3_0= ruleURIPathNameCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getImportCSAccess().getPathNameURIPathNameCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleURIPathNameCS_in_ruleImportCS1690);
            lv_pathName_3_0=ruleURIPathNameCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getImportCSRule());
              	        }
                     		set(
                     			current, 
                     			"pathName",
                      		lv_pathName_3_0, 
                      		"URIPathNameCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:909:2: ( ( (lv_all_4_0= '::' ) ) otherlv_5= '*' )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==33) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:909:3: ( (lv_all_4_0= '::' ) ) otherlv_5= '*'
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:909:3: ( (lv_all_4_0= '::' ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:910:1: (lv_all_4_0= '::' )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:910:1: (lv_all_4_0= '::' )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:911:3: lv_all_4_0= '::'
                    {
                    lv_all_4_0=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleImportCS1709); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_all_4_0, grammarAccess.getImportCSAccess().getAllColonColonKeyword_3_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getImportCSRule());
                      	        }
                             		setWithLastConsumed(current, "all", true, "::");
                      	    
                    }

                    }


                    }

                    otherlv_5=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleImportCS1734); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getImportCSAccess().getAsteriskKeyword_3_1());
                          
                    }

                    }
                    break;

            }

            otherlv_6=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleImportCS1748); if (state.failed) return current;
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


    // $ANTLR start "entryRuleLibraryCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:940:1: entryRuleLibraryCS returns [EObject current=null] : iv_ruleLibraryCS= ruleLibraryCS EOF ;
    public final EObject entryRuleLibraryCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLibraryCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:941:2: (iv_ruleLibraryCS= ruleLibraryCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:942:2: iv_ruleLibraryCS= ruleLibraryCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLibraryCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibraryCS_in_entryRuleLibraryCS1784);
            iv_ruleLibraryCS=ruleLibraryCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLibraryCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibraryCS1794); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLibraryCS"


    // $ANTLR start "ruleLibraryCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:949:1: ruleLibraryCS returns [EObject current=null] : (otherlv_0= 'library' ( ( ruleURI ) ) otherlv_2= ';' ) ;
    public final EObject ruleLibraryCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:952:28: ( (otherlv_0= 'library' ( ( ruleURI ) ) otherlv_2= ';' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:953:1: (otherlv_0= 'library' ( ( ruleURI ) ) otherlv_2= ';' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:953:1: (otherlv_0= 'library' ( ( ruleURI ) ) otherlv_2= ';' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:953:3: otherlv_0= 'library' ( ( ruleURI ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleLibraryCS1831); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLibraryCSAccess().getLibraryKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:957:1: ( ( ruleURI ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:958:1: ( ruleURI )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:958:1: ( ruleURI )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:959:3: ruleURI
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getLibraryCSRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLibraryCSAccess().getPackagePackageCrossReference_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleURI_in_ruleLibraryCS1858);
            ruleURI();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleLibraryCS1870); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getLibraryCSAccess().getSemicolonKeyword_2());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLibraryCS"


    // $ANTLR start "entryRuleNamedDomainCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:987:1: entryRuleNamedDomainCS returns [EObject current=null] : iv_ruleNamedDomainCS= ruleNamedDomainCS EOF ;
    public final EObject entryRuleNamedDomainCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedDomainCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:988:2: (iv_ruleNamedDomainCS= ruleNamedDomainCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:989:2: iv_ruleNamedDomainCS= ruleNamedDomainCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNamedDomainCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNamedDomainCS_in_entryRuleNamedDomainCS1906);
            iv_ruleNamedDomainCS=ruleNamedDomainCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNamedDomainCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNamedDomainCS1916); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:996:1: ruleNamedDomainCS returns [EObject current=null] : ( ( (lv_check_0_0= 'check' ) )? ( (lv_enforce_1_0= 'enforce' ) )? ( ( ruleUnrestrictedName ) ) ( (lv_guardPattern_3_0= ruleGuardPatternCS ) ) ( (lv_bottomPattern_4_0= ruleBottomPatternCS ) ) ) ;
    public final EObject ruleNamedDomainCS() throws RecognitionException {
        EObject current = null;

        Token lv_check_0_0=null;
        Token lv_enforce_1_0=null;
        EObject lv_guardPattern_3_0 = null;

        EObject lv_bottomPattern_4_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:999:28: ( ( ( (lv_check_0_0= 'check' ) )? ( (lv_enforce_1_0= 'enforce' ) )? ( ( ruleUnrestrictedName ) ) ( (lv_guardPattern_3_0= ruleGuardPatternCS ) ) ( (lv_bottomPattern_4_0= ruleBottomPatternCS ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1000:1: ( ( (lv_check_0_0= 'check' ) )? ( (lv_enforce_1_0= 'enforce' ) )? ( ( ruleUnrestrictedName ) ) ( (lv_guardPattern_3_0= ruleGuardPatternCS ) ) ( (lv_bottomPattern_4_0= ruleBottomPatternCS ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1000:1: ( ( (lv_check_0_0= 'check' ) )? ( (lv_enforce_1_0= 'enforce' ) )? ( ( ruleUnrestrictedName ) ) ( (lv_guardPattern_3_0= ruleGuardPatternCS ) ) ( (lv_bottomPattern_4_0= ruleBottomPatternCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1000:2: ( (lv_check_0_0= 'check' ) )? ( (lv_enforce_1_0= 'enforce' ) )? ( ( ruleUnrestrictedName ) ) ( (lv_guardPattern_3_0= ruleGuardPatternCS ) ) ( (lv_bottomPattern_4_0= ruleBottomPatternCS ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1000:2: ( (lv_check_0_0= 'check' ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==36) ) {
                int LA28_1 = input.LA(2);

                if ( ((LA28_1>=RULE_SIMPLE_ID && LA28_1<=RULE_ESCAPED_ID)||LA28_1==16||LA28_1==18||(LA28_1>=27 && LA28_1<=28)||LA28_1==31||(LA28_1>=35 && LA28_1<=40)) ) {
                    alt28=1;
                }
            }
            switch (alt28) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1001:1: (lv_check_0_0= 'check' )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1001:1: (lv_check_0_0= 'check' )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1002:3: lv_check_0_0= 'check'
                    {
                    lv_check_0_0=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleNamedDomainCS1959); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_check_0_0, grammarAccess.getNamedDomainCSAccess().getCheckCheckKeyword_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getNamedDomainCSRule());
                      	        }
                             		setWithLastConsumed(current, "check", true, "check");
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1015:3: ( (lv_enforce_1_0= 'enforce' ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==37) ) {
                int LA29_1 = input.LA(2);

                if ( ((LA29_1>=RULE_SIMPLE_ID && LA29_1<=RULE_ESCAPED_ID)||LA29_1==16||LA29_1==18||(LA29_1>=27 && LA29_1<=28)||LA29_1==31||(LA29_1>=35 && LA29_1<=40)) ) {
                    alt29=1;
                }
            }
            switch (alt29) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1016:1: (lv_enforce_1_0= 'enforce' )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1016:1: (lv_enforce_1_0= 'enforce' )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1017:3: lv_enforce_1_0= 'enforce'
                    {
                    lv_enforce_1_0=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleNamedDomainCS1991); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_enforce_1_0, grammarAccess.getNamedDomainCSAccess().getEnforceEnforceKeyword_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getNamedDomainCSRule());
                      	        }
                             		setWithLastConsumed(current, "enforce", true, "enforce");
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1030:3: ( ( ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1031:1: ( ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1031:1: ( ruleUnrestrictedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1032:3: ruleUnrestrictedName
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
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleNamedDomainCS2032);
            ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1048:2: ( (lv_guardPattern_3_0= ruleGuardPatternCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1049:1: (lv_guardPattern_3_0= ruleGuardPatternCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1049:1: (lv_guardPattern_3_0= ruleGuardPatternCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1050:3: lv_guardPattern_3_0= ruleGuardPatternCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNamedDomainCSAccess().getGuardPatternGuardPatternCSParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleGuardPatternCS_in_ruleNamedDomainCS2053);
            lv_guardPattern_3_0=ruleGuardPatternCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getNamedDomainCSRule());
              	        }
                     		set(
                     			current, 
                     			"guardPattern",
                      		lv_guardPattern_3_0, 
                      		"GuardPatternCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1066:2: ( (lv_bottomPattern_4_0= ruleBottomPatternCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1067:1: (lv_bottomPattern_4_0= ruleBottomPatternCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1067:1: (lv_bottomPattern_4_0= ruleBottomPatternCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1068:3: lv_bottomPattern_4_0= ruleBottomPatternCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNamedDomainCSAccess().getBottomPatternBottomPatternCSParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleBottomPatternCS_in_ruleNamedDomainCS2074);
            lv_bottomPattern_4_0=ruleBottomPatternCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getNamedDomainCSRule());
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


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1092:1: entryRuleParamDeclarationCS returns [EObject current=null] : iv_ruleParamDeclarationCS= ruleParamDeclarationCS EOF ;
    public final EObject entryRuleParamDeclarationCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParamDeclarationCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1093:2: (iv_ruleParamDeclarationCS= ruleParamDeclarationCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1094:2: iv_ruleParamDeclarationCS= ruleParamDeclarationCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParamDeclarationCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleParamDeclarationCS_in_entryRuleParamDeclarationCS2110);
            iv_ruleParamDeclarationCS=ruleParamDeclarationCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParamDeclarationCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParamDeclarationCS2120); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1101:1: ruleParamDeclarationCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) ) ;
    public final EObject ruleParamDeclarationCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1104:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1105:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1105:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1105:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1105:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1106:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1106:1: (lv_name_0_0= ruleUnrestrictedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1107:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParamDeclarationCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleParamDeclarationCS2166);
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

            otherlv_1=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleParamDeclarationCS2178); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getParamDeclarationCSAccess().getColonKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1127:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1128:1: (lv_ownedType_2_0= ruleTypeExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1128:1: (lv_ownedType_2_0= ruleTypeExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1129:3: lv_ownedType_2_0= ruleTypeExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParamDeclarationCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleParamDeclarationCS2199);
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


    // $ANTLR start "entryRuleQueryCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1153:1: entryRuleQueryCS returns [EObject current=null] : iv_ruleQueryCS= ruleQueryCS EOF ;
    public final EObject entryRuleQueryCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQueryCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1154:2: (iv_ruleQueryCS= ruleQueryCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1155:2: iv_ruleQueryCS= ruleQueryCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQueryCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleQueryCS_in_entryRuleQueryCS2235);
            iv_ruleQueryCS=ruleQueryCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQueryCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleQueryCS2245); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1162:1: ruleQueryCS returns [EObject current=null] : (otherlv_0= 'query' ( (lv_pathName_1_0= ruleScopeNameCS ) ) ( (lv_name_2_0= ruleUnrestrictedName ) ) otherlv_3= '(' ( ( (lv_inputParamDeclaration_4_0= ruleParamDeclarationCS ) ) (otherlv_5= ',' ( (lv_inputParamDeclaration_6_0= ruleParamDeclarationCS ) ) )* )? otherlv_7= ')' otherlv_8= ':' ( (lv_ownedType_9_0= ruleTypeExpCS ) ) (otherlv_10= ';' | (otherlv_11= '{' ( (lv_expression_12_0= ruleExpCS ) ) otherlv_13= '}' ) ) ) ;
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
        EObject lv_pathName_1_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_inputParamDeclaration_4_0 = null;

        EObject lv_inputParamDeclaration_6_0 = null;

        EObject lv_ownedType_9_0 = null;

        EObject lv_expression_12_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1165:28: ( (otherlv_0= 'query' ( (lv_pathName_1_0= ruleScopeNameCS ) ) ( (lv_name_2_0= ruleUnrestrictedName ) ) otherlv_3= '(' ( ( (lv_inputParamDeclaration_4_0= ruleParamDeclarationCS ) ) (otherlv_5= ',' ( (lv_inputParamDeclaration_6_0= ruleParamDeclarationCS ) ) )* )? otherlv_7= ')' otherlv_8= ':' ( (lv_ownedType_9_0= ruleTypeExpCS ) ) (otherlv_10= ';' | (otherlv_11= '{' ( (lv_expression_12_0= ruleExpCS ) ) otherlv_13= '}' ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1166:1: (otherlv_0= 'query' ( (lv_pathName_1_0= ruleScopeNameCS ) ) ( (lv_name_2_0= ruleUnrestrictedName ) ) otherlv_3= '(' ( ( (lv_inputParamDeclaration_4_0= ruleParamDeclarationCS ) ) (otherlv_5= ',' ( (lv_inputParamDeclaration_6_0= ruleParamDeclarationCS ) ) )* )? otherlv_7= ')' otherlv_8= ':' ( (lv_ownedType_9_0= ruleTypeExpCS ) ) (otherlv_10= ';' | (otherlv_11= '{' ( (lv_expression_12_0= ruleExpCS ) ) otherlv_13= '}' ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1166:1: (otherlv_0= 'query' ( (lv_pathName_1_0= ruleScopeNameCS ) ) ( (lv_name_2_0= ruleUnrestrictedName ) ) otherlv_3= '(' ( ( (lv_inputParamDeclaration_4_0= ruleParamDeclarationCS ) ) (otherlv_5= ',' ( (lv_inputParamDeclaration_6_0= ruleParamDeclarationCS ) ) )* )? otherlv_7= ')' otherlv_8= ':' ( (lv_ownedType_9_0= ruleTypeExpCS ) ) (otherlv_10= ';' | (otherlv_11= '{' ( (lv_expression_12_0= ruleExpCS ) ) otherlv_13= '}' ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1166:3: otherlv_0= 'query' ( (lv_pathName_1_0= ruleScopeNameCS ) ) ( (lv_name_2_0= ruleUnrestrictedName ) ) otherlv_3= '(' ( ( (lv_inputParamDeclaration_4_0= ruleParamDeclarationCS ) ) (otherlv_5= ',' ( (lv_inputParamDeclaration_6_0= ruleParamDeclarationCS ) ) )* )? otherlv_7= ')' otherlv_8= ':' ( (lv_ownedType_9_0= ruleTypeExpCS ) ) (otherlv_10= ';' | (otherlv_11= '{' ( (lv_expression_12_0= ruleExpCS ) ) otherlv_13= '}' ) )
            {
            otherlv_0=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleQueryCS2282); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getQueryCSAccess().getQueryKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1170:1: ( (lv_pathName_1_0= ruleScopeNameCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1171:1: (lv_pathName_1_0= ruleScopeNameCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1171:1: (lv_pathName_1_0= ruleScopeNameCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1172:3: lv_pathName_1_0= ruleScopeNameCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getQueryCSAccess().getPathNameScopeNameCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleScopeNameCS_in_ruleQueryCS2303);
            lv_pathName_1_0=ruleScopeNameCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getQueryCSRule());
              	        }
                     		set(
                     			current, 
                     			"pathName",
                      		lv_pathName_1_0, 
                      		"ScopeNameCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1188:2: ( (lv_name_2_0= ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1189:1: (lv_name_2_0= ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1189:1: (lv_name_2_0= ruleUnrestrictedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1190:3: lv_name_2_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getQueryCSAccess().getNameUnrestrictedNameParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleQueryCS2324);
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
                      		"UnrestrictedName");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleQueryCS2336); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getQueryCSAccess().getLeftParenthesisKeyword_3());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1210:1: ( ( (lv_inputParamDeclaration_4_0= ruleParamDeclarationCS ) ) (otherlv_5= ',' ( (lv_inputParamDeclaration_6_0= ruleParamDeclarationCS ) ) )* )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( ((LA31_0>=RULE_SIMPLE_ID && LA31_0<=RULE_ESCAPED_ID)||LA31_0==16||LA31_0==18||(LA31_0>=27 && LA31_0<=28)||LA31_0==31||(LA31_0>=35 && LA31_0<=40)) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1210:2: ( (lv_inputParamDeclaration_4_0= ruleParamDeclarationCS ) ) (otherlv_5= ',' ( (lv_inputParamDeclaration_6_0= ruleParamDeclarationCS ) ) )*
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1210:2: ( (lv_inputParamDeclaration_4_0= ruleParamDeclarationCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1211:1: (lv_inputParamDeclaration_4_0= ruleParamDeclarationCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1211:1: (lv_inputParamDeclaration_4_0= ruleParamDeclarationCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1212:3: lv_inputParamDeclaration_4_0= ruleParamDeclarationCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getQueryCSAccess().getInputParamDeclarationParamDeclarationCSParserRuleCall_4_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleParamDeclarationCS_in_ruleQueryCS2358);
                    lv_inputParamDeclaration_4_0=ruleParamDeclarationCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getQueryCSRule());
                      	        }
                             		add(
                             			current, 
                             			"inputParamDeclaration",
                              		lv_inputParamDeclaration_4_0, 
                              		"ParamDeclarationCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1228:2: (otherlv_5= ',' ( (lv_inputParamDeclaration_6_0= ruleParamDeclarationCS ) ) )*
                    loop30:
                    do {
                        int alt30=2;
                        int LA30_0 = input.LA(1);

                        if ( (LA30_0==19) ) {
                            alt30=1;
                        }


                        switch (alt30) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1228:4: otherlv_5= ',' ( (lv_inputParamDeclaration_6_0= ruleParamDeclarationCS ) )
                    	    {
                    	    otherlv_5=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleQueryCS2371); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_5, grammarAccess.getQueryCSAccess().getCommaKeyword_4_1_0());
                    	          
                    	    }
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1232:1: ( (lv_inputParamDeclaration_6_0= ruleParamDeclarationCS ) )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1233:1: (lv_inputParamDeclaration_6_0= ruleParamDeclarationCS )
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1233:1: (lv_inputParamDeclaration_6_0= ruleParamDeclarationCS )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1234:3: lv_inputParamDeclaration_6_0= ruleParamDeclarationCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getQueryCSAccess().getInputParamDeclarationParamDeclarationCSParserRuleCall_4_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleParamDeclarationCS_in_ruleQueryCS2392);
                    	    lv_inputParamDeclaration_6_0=ruleParamDeclarationCS();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getQueryCSRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"inputParamDeclaration",
                    	              		lv_inputParamDeclaration_6_0, 
                    	              		"ParamDeclarationCS");
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


                    }
                    break;

            }

            otherlv_7=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleQueryCS2408); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getQueryCSAccess().getRightParenthesisKeyword_5());
                  
            }
            otherlv_8=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleQueryCS2420); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getQueryCSAccess().getColonKeyword_6());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1258:1: ( (lv_ownedType_9_0= ruleTypeExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1259:1: (lv_ownedType_9_0= ruleTypeExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1259:1: (lv_ownedType_9_0= ruleTypeExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1260:3: lv_ownedType_9_0= ruleTypeExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getQueryCSAccess().getOwnedTypeTypeExpCSParserRuleCall_7_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleQueryCS2441);
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
                      		"TypeExpCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1276:2: (otherlv_10= ';' | (otherlv_11= '{' ( (lv_expression_12_0= ruleExpCS ) ) otherlv_13= '}' ) )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==26) ) {
                alt32=1;
            }
            else if ( (LA32_0==20) ) {
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1276:4: otherlv_10= ';'
                    {
                    otherlv_10=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleQueryCS2454); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getQueryCSAccess().getSemicolonKeyword_8_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1281:6: (otherlv_11= '{' ( (lv_expression_12_0= ruleExpCS ) ) otherlv_13= '}' )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1281:6: (otherlv_11= '{' ( (lv_expression_12_0= ruleExpCS ) ) otherlv_13= '}' )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1281:8: otherlv_11= '{' ( (lv_expression_12_0= ruleExpCS ) ) otherlv_13= '}'
                    {
                    otherlv_11=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleQueryCS2473); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_11, grammarAccess.getQueryCSAccess().getLeftCurlyBracketKeyword_8_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1285:1: ( (lv_expression_12_0= ruleExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1286:1: (lv_expression_12_0= ruleExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1286:1: (lv_expression_12_0= ruleExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1287:3: lv_expression_12_0= ruleExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getQueryCSAccess().getExpressionExpCSParserRuleCall_8_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleQueryCS2494);
                    lv_expression_12_0=ruleExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getQueryCSRule());
                      	        }
                             		set(
                             			current, 
                             			"expression",
                              		lv_expression_12_0, 
                              		"ExpCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_13=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleQueryCS2506); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1315:1: entryRuleScopeNameCS returns [EObject current=null] : iv_ruleScopeNameCS= ruleScopeNameCS EOF ;
    public final EObject entryRuleScopeNameCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScopeNameCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1316:2: (iv_ruleScopeNameCS= ruleScopeNameCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1317:2: iv_ruleScopeNameCS= ruleScopeNameCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScopeNameCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleScopeNameCS_in_entryRuleScopeNameCS2544);
            iv_ruleScopeNameCS=ruleScopeNameCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScopeNameCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleScopeNameCS2554); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1324:1: ruleScopeNameCS returns [EObject current=null] : ( ( (lv_path_0_0= ruleFirstPathElementCS ) ) otherlv_1= '::' ( ( (lv_path_2_0= ruleNextPathElementCS ) ) otherlv_3= '::' )* ) ;
    public final EObject ruleScopeNameCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_path_0_0 = null;

        EObject lv_path_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1327:28: ( ( ( (lv_path_0_0= ruleFirstPathElementCS ) ) otherlv_1= '::' ( ( (lv_path_2_0= ruleNextPathElementCS ) ) otherlv_3= '::' )* ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1328:1: ( ( (lv_path_0_0= ruleFirstPathElementCS ) ) otherlv_1= '::' ( ( (lv_path_2_0= ruleNextPathElementCS ) ) otherlv_3= '::' )* )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1328:1: ( ( (lv_path_0_0= ruleFirstPathElementCS ) ) otherlv_1= '::' ( ( (lv_path_2_0= ruleNextPathElementCS ) ) otherlv_3= '::' )* )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1328:2: ( (lv_path_0_0= ruleFirstPathElementCS ) ) otherlv_1= '::' ( ( (lv_path_2_0= ruleNextPathElementCS ) ) otherlv_3= '::' )*
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1328:2: ( (lv_path_0_0= ruleFirstPathElementCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1329:1: (lv_path_0_0= ruleFirstPathElementCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1329:1: (lv_path_0_0= ruleFirstPathElementCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1330:3: lv_path_0_0= ruleFirstPathElementCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getScopeNameCSAccess().getPathFirstPathElementCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleFirstPathElementCS_in_ruleScopeNameCS2600);
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

            otherlv_1=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleScopeNameCS2612); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getScopeNameCSAccess().getColonColonKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1350:1: ( ( (lv_path_2_0= ruleNextPathElementCS ) ) otherlv_3= '::' )*
            loop33:
            do {
                int alt33=2;
                alt33 = dfa33.predict(input);
                switch (alt33) {
            	case 1 :
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1350:2: ( (lv_path_2_0= ruleNextPathElementCS ) ) otherlv_3= '::'
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1350:2: ( (lv_path_2_0= ruleNextPathElementCS ) )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1351:1: (lv_path_2_0= ruleNextPathElementCS )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1351:1: (lv_path_2_0= ruleNextPathElementCS )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1352:3: lv_path_2_0= ruleNextPathElementCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getScopeNameCSAccess().getPathNextPathElementCSParserRuleCall_2_0_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleNextPathElementCS_in_ruleScopeNameCS2634);
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

            	    otherlv_3=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleScopeNameCS2646); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getScopeNameCSAccess().getColonColonKeyword_2_1());
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop33;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1380:1: entryRuleTransformationCS returns [EObject current=null] : iv_ruleTransformationCS= ruleTransformationCS EOF ;
    public final EObject entryRuleTransformationCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransformationCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1381:2: (iv_ruleTransformationCS= ruleTransformationCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1382:2: iv_ruleTransformationCS= ruleTransformationCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTransformationCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTransformationCS_in_entryRuleTransformationCS2684);
            iv_ruleTransformationCS=ruleTransformationCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTransformationCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTransformationCS2694); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1389:1: ruleTransformationCS returns [EObject current=null] : (otherlv_0= 'transformation' ( (lv_pathName_1_0= ruleScopeNameCS ) )? ( (lv_name_2_0= ruleUnreservedName ) ) otherlv_3= '{' ( ( (lv_directions_4_0= ruleDirectionCS ) ) otherlv_5= ';' )* otherlv_6= '}' ) ;
    public final EObject ruleTransformationCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        EObject lv_pathName_1_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_directions_4_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1392:28: ( (otherlv_0= 'transformation' ( (lv_pathName_1_0= ruleScopeNameCS ) )? ( (lv_name_2_0= ruleUnreservedName ) ) otherlv_3= '{' ( ( (lv_directions_4_0= ruleDirectionCS ) ) otherlv_5= ';' )* otherlv_6= '}' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1393:1: (otherlv_0= 'transformation' ( (lv_pathName_1_0= ruleScopeNameCS ) )? ( (lv_name_2_0= ruleUnreservedName ) ) otherlv_3= '{' ( ( (lv_directions_4_0= ruleDirectionCS ) ) otherlv_5= ';' )* otherlv_6= '}' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1393:1: (otherlv_0= 'transformation' ( (lv_pathName_1_0= ruleScopeNameCS ) )? ( (lv_name_2_0= ruleUnreservedName ) ) otherlv_3= '{' ( ( (lv_directions_4_0= ruleDirectionCS ) ) otherlv_5= ';' )* otherlv_6= '}' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1393:3: otherlv_0= 'transformation' ( (lv_pathName_1_0= ruleScopeNameCS ) )? ( (lv_name_2_0= ruleUnreservedName ) ) otherlv_3= '{' ( ( (lv_directions_4_0= ruleDirectionCS ) ) otherlv_5= ';' )* otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,39,FollowSets000.FOLLOW_39_in_ruleTransformationCS2731); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getTransformationCSAccess().getTransformationKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1397:1: ( (lv_pathName_1_0= ruleScopeNameCS ) )?
            int alt34=2;
            alt34 = dfa34.predict(input);
            switch (alt34) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1398:1: (lv_pathName_1_0= ruleScopeNameCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1398:1: (lv_pathName_1_0= ruleScopeNameCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1399:3: lv_pathName_1_0= ruleScopeNameCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTransformationCSAccess().getPathNameScopeNameCSParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleScopeNameCS_in_ruleTransformationCS2752);
                    lv_pathName_1_0=ruleScopeNameCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTransformationCSRule());
                      	        }
                             		set(
                             			current, 
                             			"pathName",
                              		lv_pathName_1_0, 
                              		"ScopeNameCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1415:3: ( (lv_name_2_0= ruleUnreservedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1416:1: (lv_name_2_0= ruleUnreservedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1416:1: (lv_name_2_0= ruleUnreservedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1417:3: lv_name_2_0= ruleUnreservedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTransformationCSAccess().getNameUnreservedNameParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnreservedName_in_ruleTransformationCS2774);
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
                      		"UnreservedName");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleTransformationCS2786); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getTransformationCSAccess().getLeftCurlyBracketKeyword_3());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1437:1: ( ( (lv_directions_4_0= ruleDirectionCS ) ) otherlv_5= ';' )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==EOF||(LA35_0>=RULE_SIMPLE_ID && LA35_0<=RULE_ESCAPED_ID)||LA35_0==16||LA35_0==18||(LA35_0>=26 && LA35_0<=28)||LA35_0==31||(LA35_0>=35 && LA35_0<=40)) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1437:2: ( (lv_directions_4_0= ruleDirectionCS ) ) otherlv_5= ';'
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1437:2: ( (lv_directions_4_0= ruleDirectionCS ) )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1438:1: (lv_directions_4_0= ruleDirectionCS )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1438:1: (lv_directions_4_0= ruleDirectionCS )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1439:3: lv_directions_4_0= ruleDirectionCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTransformationCSAccess().getDirectionsDirectionCSParserRuleCall_4_0_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleDirectionCS_in_ruleTransformationCS2808);
            	    lv_directions_4_0=ruleDirectionCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getTransformationCSRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"directions",
            	              		lv_directions_4_0, 
            	              		"DirectionCS");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    otherlv_5=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleTransformationCS2820); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_5, grammarAccess.getTransformationCSAccess().getSemicolonKeyword_4_1());
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);

            otherlv_6=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleTransformationCS2834); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1471:1: entryRuleUnrealizedVariableCS returns [EObject current=null] : iv_ruleUnrealizedVariableCS= ruleUnrealizedVariableCS EOF ;
    public final EObject entryRuleUnrealizedVariableCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnrealizedVariableCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1472:2: (iv_ruleUnrealizedVariableCS= ruleUnrealizedVariableCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1473:2: iv_ruleUnrealizedVariableCS= ruleUnrealizedVariableCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnrealizedVariableCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrealizedVariableCS_in_entryRuleUnrealizedVariableCS2870);
            iv_ruleUnrealizedVariableCS=ruleUnrealizedVariableCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnrealizedVariableCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnrealizedVariableCS2880); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1480:1: ruleUnrealizedVariableCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) ) ;
    public final EObject ruleUnrealizedVariableCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1483:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1484:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1484:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1484:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1484:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1485:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1485:1: (lv_name_0_0= ruleUnrestrictedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1486:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getUnrealizedVariableCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleUnrealizedVariableCS2926);
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

            otherlv_1=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleUnrealizedVariableCS2938); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getUnrealizedVariableCSAccess().getColonKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1506:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1507:1: (lv_ownedType_2_0= ruleTypeExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1507:1: (lv_ownedType_2_0= ruleTypeExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1508:3: lv_ownedType_2_0= ruleTypeExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getUnrealizedVariableCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleUnrealizedVariableCS2959);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1532:1: entryRuleRealizedVariableCS returns [EObject current=null] : iv_ruleRealizedVariableCS= ruleRealizedVariableCS EOF ;
    public final EObject entryRuleRealizedVariableCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealizedVariableCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1533:2: (iv_ruleRealizedVariableCS= ruleRealizedVariableCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1534:2: iv_ruleRealizedVariableCS= ruleRealizedVariableCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRealizedVariableCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleRealizedVariableCS_in_entryRuleRealizedVariableCS2995);
            iv_ruleRealizedVariableCS=ruleRealizedVariableCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRealizedVariableCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRealizedVariableCS3005); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1541:1: ruleRealizedVariableCS returns [EObject current=null] : (otherlv_0= 'realize' ( (lv_name_1_0= ruleUnrestrictedName ) ) otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) ) ;
    public final EObject ruleRealizedVariableCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_ownedType_3_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1544:28: ( (otherlv_0= 'realize' ( (lv_name_1_0= ruleUnrestrictedName ) ) otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1545:1: (otherlv_0= 'realize' ( (lv_name_1_0= ruleUnrestrictedName ) ) otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1545:1: (otherlv_0= 'realize' ( (lv_name_1_0= ruleUnrestrictedName ) ) otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1545:3: otherlv_0= 'realize' ( (lv_name_1_0= ruleUnrestrictedName ) ) otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) )
            {
            otherlv_0=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleRealizedVariableCS3042); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getRealizedVariableCSAccess().getRealizeKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1549:1: ( (lv_name_1_0= ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1550:1: (lv_name_1_0= ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1550:1: (lv_name_1_0= ruleUnrestrictedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1551:3: lv_name_1_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRealizedVariableCSAccess().getNameUnrestrictedNameParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleRealizedVariableCS3063);
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

            otherlv_2=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleRealizedVariableCS3075); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getRealizedVariableCSAccess().getColonKeyword_2());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1571:1: ( (lv_ownedType_3_0= ruleTypeExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1572:1: (lv_ownedType_3_0= ruleTypeExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1572:1: (lv_ownedType_3_0= ruleTypeExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1573:3: lv_ownedType_3_0= ruleTypeExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRealizedVariableCSAccess().getOwnedTypeTypeExpCSParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleRealizedVariableCS3096);
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


    // $ANTLR start "entryRuleUnnamedDomainCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1597:1: entryRuleUnnamedDomainCS returns [EObject current=null] : iv_ruleUnnamedDomainCS= ruleUnnamedDomainCS EOF ;
    public final EObject entryRuleUnnamedDomainCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnnamedDomainCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1598:2: (iv_ruleUnnamedDomainCS= ruleUnnamedDomainCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1599:2: iv_ruleUnnamedDomainCS= ruleUnnamedDomainCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnnamedDomainCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnnamedDomainCS_in_entryRuleUnnamedDomainCS3132);
            iv_ruleUnnamedDomainCS=ruleUnnamedDomainCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnnamedDomainCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnnamedDomainCS3142); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1606:1: ruleUnnamedDomainCS returns [EObject current=null] : ( () ( (lv_guardPattern_1_0= ruleGuardPatternCS ) ) ( (lv_bottomPattern_2_0= ruleBottomPatternCS ) ) ) ;
    public final EObject ruleUnnamedDomainCS() throws RecognitionException {
        EObject current = null;

        EObject lv_guardPattern_1_0 = null;

        EObject lv_bottomPattern_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1609:28: ( ( () ( (lv_guardPattern_1_0= ruleGuardPatternCS ) ) ( (lv_bottomPattern_2_0= ruleBottomPatternCS ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1610:1: ( () ( (lv_guardPattern_1_0= ruleGuardPatternCS ) ) ( (lv_bottomPattern_2_0= ruleBottomPatternCS ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1610:1: ( () ( (lv_guardPattern_1_0= ruleGuardPatternCS ) ) ( (lv_bottomPattern_2_0= ruleBottomPatternCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1610:2: () ( (lv_guardPattern_1_0= ruleGuardPatternCS ) ) ( (lv_bottomPattern_2_0= ruleBottomPatternCS ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1610:2: ()
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1611:2: 
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1619:2: ( (lv_guardPattern_1_0= ruleGuardPatternCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1620:1: (lv_guardPattern_1_0= ruleGuardPatternCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1620:1: (lv_guardPattern_1_0= ruleGuardPatternCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1621:3: lv_guardPattern_1_0= ruleGuardPatternCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getUnnamedDomainCSAccess().getGuardPatternGuardPatternCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleGuardPatternCS_in_ruleUnnamedDomainCS3200);
            lv_guardPattern_1_0=ruleGuardPatternCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getUnnamedDomainCSRule());
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1637:2: ( (lv_bottomPattern_2_0= ruleBottomPatternCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1638:1: (lv_bottomPattern_2_0= ruleBottomPatternCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1638:1: (lv_bottomPattern_2_0= ruleBottomPatternCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1639:3: lv_bottomPattern_2_0= ruleBottomPatternCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getUnnamedDomainCSAccess().getBottomPatternBottomPatternCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleBottomPatternCS_in_ruleUnnamedDomainCS3221);
            lv_bottomPattern_2_0=ruleBottomPatternCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getUnnamedDomainCSRule());
              	        }
                     		set(
                     			current, 
                     			"bottomPattern",
                      		lv_bottomPattern_2_0, 
                      		"BottomPatternCS");
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1663:1: entryRuleUnrestrictedName returns [String current=null] : iv_ruleUnrestrictedName= ruleUnrestrictedName EOF ;
    public final String entryRuleUnrestrictedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnrestrictedName = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1664:2: (iv_ruleUnrestrictedName= ruleUnrestrictedName EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1665:2: iv_ruleUnrestrictedName= ruleUnrestrictedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnrestrictedNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_entryRuleUnrestrictedName3258);
            iv_ruleUnrestrictedName=ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnrestrictedName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnrestrictedName3269); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1672:1: ruleUnrestrictedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_EssentialOCLUnrestrictedName_0= ruleEssentialOCLUnrestrictedName | kw= 'check' | kw= 'enforce' | kw= 'import' | kw= 'imports' | kw= 'library' | kw= 'map' | kw= 'query' | kw= 'realize' | kw= 'refines' | kw= 'transformation' | kw= 'uses' ) ;
    public final AntlrDatatypeRuleToken ruleUnrestrictedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_EssentialOCLUnrestrictedName_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1675:28: ( (this_EssentialOCLUnrestrictedName_0= ruleEssentialOCLUnrestrictedName | kw= 'check' | kw= 'enforce' | kw= 'import' | kw= 'imports' | kw= 'library' | kw= 'map' | kw= 'query' | kw= 'realize' | kw= 'refines' | kw= 'transformation' | kw= 'uses' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1676:1: (this_EssentialOCLUnrestrictedName_0= ruleEssentialOCLUnrestrictedName | kw= 'check' | kw= 'enforce' | kw= 'import' | kw= 'imports' | kw= 'library' | kw= 'map' | kw= 'query' | kw= 'realize' | kw= 'refines' | kw= 'transformation' | kw= 'uses' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1676:1: (this_EssentialOCLUnrestrictedName_0= ruleEssentialOCLUnrestrictedName | kw= 'check' | kw= 'enforce' | kw= 'import' | kw= 'imports' | kw= 'library' | kw= 'map' | kw= 'query' | kw= 'realize' | kw= 'refines' | kw= 'transformation' | kw= 'uses' )
            int alt36=12;
            switch ( input.LA(1) ) {
            case RULE_SIMPLE_ID:
            case RULE_ESCAPED_ID:
                {
                alt36=1;
                }
                break;
            case 36:
                {
                alt36=2;
                }
                break;
            case 37:
                {
                alt36=3;
                }
                break;
            case 31:
                {
                alt36=4;
                }
                break;
            case 27:
                {
                alt36=5;
                }
                break;
            case 35:
                {
                alt36=6;
                }
                break;
            case 16:
                {
                alt36=7;
                }
                break;
            case 38:
                {
                alt36=8;
                }
                break;
            case 40:
                {
                alt36=9;
                }
                break;
            case 18:
                {
                alt36=10;
                }
                break;
            case 39:
                {
                alt36=11;
                }
                break;
            case 28:
                {
                alt36=12;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }

            switch (alt36) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1677:5: this_EssentialOCLUnrestrictedName_0= ruleEssentialOCLUnrestrictedName
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getUnrestrictedNameAccess().getEssentialOCLUnrestrictedNameParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLUnrestrictedName_in_ruleUnrestrictedName3316);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1689:2: kw= 'check'
                    {
                    kw=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleUnrestrictedName3340); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getCheckKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1696:2: kw= 'enforce'
                    {
                    kw=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleUnrestrictedName3359); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getEnforceKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1703:2: kw= 'import'
                    {
                    kw=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleUnrestrictedName3378); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getImportKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1710:2: kw= 'imports'
                    {
                    kw=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleUnrestrictedName3397); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getImportsKeyword_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1717:2: kw= 'library'
                    {
                    kw=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleUnrestrictedName3416); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getLibraryKeyword_5()); 
                          
                    }

                    }
                    break;
                case 7 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1724:2: kw= 'map'
                    {
                    kw=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleUnrestrictedName3435); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getMapKeyword_6()); 
                          
                    }

                    }
                    break;
                case 8 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1731:2: kw= 'query'
                    {
                    kw=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleUnrestrictedName3454); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getQueryKeyword_7()); 
                          
                    }

                    }
                    break;
                case 9 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1738:2: kw= 'realize'
                    {
                    kw=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleUnrestrictedName3473); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getRealizeKeyword_8()); 
                          
                    }

                    }
                    break;
                case 10 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1745:2: kw= 'refines'
                    {
                    kw=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleUnrestrictedName3492); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getRefinesKeyword_9()); 
                          
                    }

                    }
                    break;
                case 11 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1752:2: kw= 'transformation'
                    {
                    kw=(Token)match(input,39,FollowSets000.FOLLOW_39_in_ruleUnrestrictedName3511); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getTransformationKeyword_10()); 
                          
                    }

                    }
                    break;
                case 12 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1759:2: kw= 'uses'
                    {
                    kw=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleUnrestrictedName3530); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1774:1: entryRuleID returns [String current=null] : iv_ruleID= ruleID EOF ;
    public final String entryRuleID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleID = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1775:2: (iv_ruleID= ruleID EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1776:2: iv_ruleID= ruleID EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIDRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleID_in_entryRuleID3573);
            iv_ruleID=ruleID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleID.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleID3584); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1783:1: ruleID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_SIMPLE_ID_0= RULE_SIMPLE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID ) ;
    public final AntlrDatatypeRuleToken ruleID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_SIMPLE_ID_0=null;
        Token this_ESCAPED_ID_1=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1786:28: ( (this_SIMPLE_ID_0= RULE_SIMPLE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1787:1: (this_SIMPLE_ID_0= RULE_SIMPLE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1787:1: (this_SIMPLE_ID_0= RULE_SIMPLE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==RULE_SIMPLE_ID) ) {
                alt37=1;
            }
            else if ( (LA37_0==RULE_ESCAPED_ID) ) {
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1787:6: this_SIMPLE_ID_0= RULE_SIMPLE_ID
                    {
                    this_SIMPLE_ID_0=(Token)match(input,RULE_SIMPLE_ID,FollowSets000.FOLLOW_RULE_SIMPLE_ID_in_ruleID3624); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SIMPLE_ID_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SIMPLE_ID_0, grammarAccess.getIDAccess().getSIMPLE_IDTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1795:10: this_ESCAPED_ID_1= RULE_ESCAPED_ID
                    {
                    this_ESCAPED_ID_1=(Token)match(input,RULE_ESCAPED_ID,FollowSets000.FOLLOW_RULE_ESCAPED_ID_in_ruleID3650); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1810:1: entryRuleLOWER returns [String current=null] : iv_ruleLOWER= ruleLOWER EOF ;
    public final String entryRuleLOWER() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLOWER = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1811:2: (iv_ruleLOWER= ruleLOWER EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1812:2: iv_ruleLOWER= ruleLOWER EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLOWERRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLOWER_in_entryRuleLOWER3696);
            iv_ruleLOWER=ruleLOWER();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLOWER.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLOWER3707); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1819:1: ruleLOWER returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INT_0= RULE_INT ;
    public final AntlrDatatypeRuleToken ruleLOWER() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1822:28: (this_INT_0= RULE_INT )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1823:5: this_INT_0= RULE_INT
            {
            this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleLOWER3746); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1838:1: entryRuleUPPER returns [String current=null] : iv_ruleUPPER= ruleUPPER EOF ;
    public final String entryRuleUPPER() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUPPER = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1839:2: (iv_ruleUPPER= ruleUPPER EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1840:2: iv_ruleUPPER= ruleUPPER EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUPPERRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUPPER_in_entryRuleUPPER3791);
            iv_ruleUPPER=ruleUPPER();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUPPER.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUPPER3802); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1847:1: ruleUPPER returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT | kw= '*' ) ;
    public final AntlrDatatypeRuleToken ruleUPPER() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1850:28: ( (this_INT_0= RULE_INT | kw= '*' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1851:1: (this_INT_0= RULE_INT | kw= '*' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1851:1: (this_INT_0= RULE_INT | kw= '*' )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==RULE_INT) ) {
                alt38=1;
            }
            else if ( (LA38_0==34) ) {
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1851:6: this_INT_0= RULE_INT
                    {
                    this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleUPPER3842); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_INT_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_INT_0, grammarAccess.getUPPERAccess().getINTTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1860:2: kw= '*'
                    {
                    kw=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleUPPER3866); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1873:1: entryRuleNUMBER_LITERAL returns [String current=null] : iv_ruleNUMBER_LITERAL= ruleNUMBER_LITERAL EOF ;
    public final String entryRuleNUMBER_LITERAL() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNUMBER_LITERAL = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1874:2: (iv_ruleNUMBER_LITERAL= ruleNUMBER_LITERAL EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1875:2: iv_ruleNUMBER_LITERAL= ruleNUMBER_LITERAL EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNUMBER_LITERALRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNUMBER_LITERAL_in_entryRuleNUMBER_LITERAL3907);
            iv_ruleNUMBER_LITERAL=ruleNUMBER_LITERAL();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNUMBER_LITERAL.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNUMBER_LITERAL3918); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1882:1: ruleNUMBER_LITERAL returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INT_0= RULE_INT ;
    public final AntlrDatatypeRuleToken ruleNUMBER_LITERAL() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1885:28: (this_INT_0= RULE_INT )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1886:5: this_INT_0= RULE_INT
            {
            this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleNUMBER_LITERAL3957); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1901:1: entryRuleURI returns [String current=null] : iv_ruleURI= ruleURI EOF ;
    public final String entryRuleURI() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleURI = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1902:2: (iv_ruleURI= ruleURI EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1903:2: iv_ruleURI= ruleURI EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getURIRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleURI_in_entryRuleURI4002);
            iv_ruleURI=ruleURI();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleURI.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleURI4013); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1910:1: ruleURI returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING ;
    public final AntlrDatatypeRuleToken ruleURI() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_SINGLE_QUOTED_STRING_0=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1913:28: (this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1914:5: this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING
            {
            this_SINGLE_QUOTED_STRING_0=(Token)match(input,RULE_SINGLE_QUOTED_STRING,FollowSets000.FOLLOW_RULE_SINGLE_QUOTED_STRING_in_ruleURI4052); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1931:1: entryRuleEssentialOCLUnaryOperatorCS returns [EObject current=null] : iv_ruleEssentialOCLUnaryOperatorCS= ruleEssentialOCLUnaryOperatorCS EOF ;
    public final EObject entryRuleEssentialOCLUnaryOperatorCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEssentialOCLUnaryOperatorCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1932:2: (iv_ruleEssentialOCLUnaryOperatorCS= ruleEssentialOCLUnaryOperatorCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1933:2: iv_ruleEssentialOCLUnaryOperatorCS= ruleEssentialOCLUnaryOperatorCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEssentialOCLUnaryOperatorCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLUnaryOperatorCS_in_entryRuleEssentialOCLUnaryOperatorCS4098);
            iv_ruleEssentialOCLUnaryOperatorCS=ruleEssentialOCLUnaryOperatorCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEssentialOCLUnaryOperatorCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEssentialOCLUnaryOperatorCS4108); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1940:1: ruleEssentialOCLUnaryOperatorCS returns [EObject current=null] : ( ( (lv_name_0_1= '-' | lv_name_0_2= 'not' ) ) ) ;
    public final EObject ruleEssentialOCLUnaryOperatorCS() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1943:28: ( ( ( (lv_name_0_1= '-' | lv_name_0_2= 'not' ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1944:1: ( ( (lv_name_0_1= '-' | lv_name_0_2= 'not' ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1944:1: ( ( (lv_name_0_1= '-' | lv_name_0_2= 'not' ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1945:1: ( (lv_name_0_1= '-' | lv_name_0_2= 'not' ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1945:1: ( (lv_name_0_1= '-' | lv_name_0_2= 'not' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1946:1: (lv_name_0_1= '-' | lv_name_0_2= 'not' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1946:1: (lv_name_0_1= '-' | lv_name_0_2= 'not' )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==41) ) {
                alt39=1;
            }
            else if ( (LA39_0==42) ) {
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1947:3: lv_name_0_1= '-'
                    {
                    lv_name_0_1=(Token)match(input,41,FollowSets000.FOLLOW_41_in_ruleEssentialOCLUnaryOperatorCS4152); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1959:8: lv_name_0_2= 'not'
                    {
                    lv_name_0_2=(Token)match(input,42,FollowSets000.FOLLOW_42_in_ruleEssentialOCLUnaryOperatorCS4181); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1982:1: entryRuleEssentialOCLInfixOperatorCS returns [EObject current=null] : iv_ruleEssentialOCLInfixOperatorCS= ruleEssentialOCLInfixOperatorCS EOF ;
    public final EObject entryRuleEssentialOCLInfixOperatorCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEssentialOCLInfixOperatorCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1983:2: (iv_ruleEssentialOCLInfixOperatorCS= ruleEssentialOCLInfixOperatorCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1984:2: iv_ruleEssentialOCLInfixOperatorCS= ruleEssentialOCLInfixOperatorCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEssentialOCLInfixOperatorCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLInfixOperatorCS_in_entryRuleEssentialOCLInfixOperatorCS4232);
            iv_ruleEssentialOCLInfixOperatorCS=ruleEssentialOCLInfixOperatorCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEssentialOCLInfixOperatorCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEssentialOCLInfixOperatorCS4242); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1991:1: ruleEssentialOCLInfixOperatorCS returns [EObject current=null] : ( ( (lv_name_0_1= '*' | lv_name_0_2= '/' | lv_name_0_3= '+' | lv_name_0_4= '-' | lv_name_0_5= '>' | lv_name_0_6= '<' | lv_name_0_7= '>=' | lv_name_0_8= '<=' | lv_name_0_9= '=' | lv_name_0_10= '<>' | lv_name_0_11= 'and' | lv_name_0_12= 'or' | lv_name_0_13= 'xor' | lv_name_0_14= 'implies' ) ) ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1994:28: ( ( ( (lv_name_0_1= '*' | lv_name_0_2= '/' | lv_name_0_3= '+' | lv_name_0_4= '-' | lv_name_0_5= '>' | lv_name_0_6= '<' | lv_name_0_7= '>=' | lv_name_0_8= '<=' | lv_name_0_9= '=' | lv_name_0_10= '<>' | lv_name_0_11= 'and' | lv_name_0_12= 'or' | lv_name_0_13= 'xor' | lv_name_0_14= 'implies' ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1995:1: ( ( (lv_name_0_1= '*' | lv_name_0_2= '/' | lv_name_0_3= '+' | lv_name_0_4= '-' | lv_name_0_5= '>' | lv_name_0_6= '<' | lv_name_0_7= '>=' | lv_name_0_8= '<=' | lv_name_0_9= '=' | lv_name_0_10= '<>' | lv_name_0_11= 'and' | lv_name_0_12= 'or' | lv_name_0_13= 'xor' | lv_name_0_14= 'implies' ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1995:1: ( ( (lv_name_0_1= '*' | lv_name_0_2= '/' | lv_name_0_3= '+' | lv_name_0_4= '-' | lv_name_0_5= '>' | lv_name_0_6= '<' | lv_name_0_7= '>=' | lv_name_0_8= '<=' | lv_name_0_9= '=' | lv_name_0_10= '<>' | lv_name_0_11= 'and' | lv_name_0_12= 'or' | lv_name_0_13= 'xor' | lv_name_0_14= 'implies' ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1996:1: ( (lv_name_0_1= '*' | lv_name_0_2= '/' | lv_name_0_3= '+' | lv_name_0_4= '-' | lv_name_0_5= '>' | lv_name_0_6= '<' | lv_name_0_7= '>=' | lv_name_0_8= '<=' | lv_name_0_9= '=' | lv_name_0_10= '<>' | lv_name_0_11= 'and' | lv_name_0_12= 'or' | lv_name_0_13= 'xor' | lv_name_0_14= 'implies' ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1996:1: ( (lv_name_0_1= '*' | lv_name_0_2= '/' | lv_name_0_3= '+' | lv_name_0_4= '-' | lv_name_0_5= '>' | lv_name_0_6= '<' | lv_name_0_7= '>=' | lv_name_0_8= '<=' | lv_name_0_9= '=' | lv_name_0_10= '<>' | lv_name_0_11= 'and' | lv_name_0_12= 'or' | lv_name_0_13= 'xor' | lv_name_0_14= 'implies' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1997:1: (lv_name_0_1= '*' | lv_name_0_2= '/' | lv_name_0_3= '+' | lv_name_0_4= '-' | lv_name_0_5= '>' | lv_name_0_6= '<' | lv_name_0_7= '>=' | lv_name_0_8= '<=' | lv_name_0_9= '=' | lv_name_0_10= '<>' | lv_name_0_11= 'and' | lv_name_0_12= 'or' | lv_name_0_13= 'xor' | lv_name_0_14= 'implies' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1997:1: (lv_name_0_1= '*' | lv_name_0_2= '/' | lv_name_0_3= '+' | lv_name_0_4= '-' | lv_name_0_5= '>' | lv_name_0_6= '<' | lv_name_0_7= '>=' | lv_name_0_8= '<=' | lv_name_0_9= '=' | lv_name_0_10= '<>' | lv_name_0_11= 'and' | lv_name_0_12= 'or' | lv_name_0_13= 'xor' | lv_name_0_14= 'implies' )
            int alt40=14;
            switch ( input.LA(1) ) {
            case 34:
                {
                alt40=1;
                }
                break;
            case 43:
                {
                alt40=2;
                }
                break;
            case 44:
                {
                alt40=3;
                }
                break;
            case 41:
                {
                alt40=4;
                }
                break;
            case 45:
                {
                alt40=5;
                }
                break;
            case 46:
                {
                alt40=6;
                }
                break;
            case 47:
                {
                alt40=7;
                }
                break;
            case 48:
                {
                alt40=8;
                }
                break;
            case 49:
                {
                alt40=9;
                }
                break;
            case 50:
                {
                alt40=10;
                }
                break;
            case 51:
                {
                alt40=11;
                }
                break;
            case 52:
                {
                alt40=12;
                }
                break;
            case 53:
                {
                alt40=13;
                }
                break;
            case 54:
                {
                alt40=14;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1998:3: lv_name_0_1= '*'
                    {
                    lv_name_0_1=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleEssentialOCLInfixOperatorCS4286); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2010:8: lv_name_0_2= '/'
                    {
                    lv_name_0_2=(Token)match(input,43,FollowSets000.FOLLOW_43_in_ruleEssentialOCLInfixOperatorCS4315); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2022:8: lv_name_0_3= '+'
                    {
                    lv_name_0_3=(Token)match(input,44,FollowSets000.FOLLOW_44_in_ruleEssentialOCLInfixOperatorCS4344); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2034:8: lv_name_0_4= '-'
                    {
                    lv_name_0_4=(Token)match(input,41,FollowSets000.FOLLOW_41_in_ruleEssentialOCLInfixOperatorCS4373); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2046:8: lv_name_0_5= '>'
                    {
                    lv_name_0_5=(Token)match(input,45,FollowSets000.FOLLOW_45_in_ruleEssentialOCLInfixOperatorCS4402); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2058:8: lv_name_0_6= '<'
                    {
                    lv_name_0_6=(Token)match(input,46,FollowSets000.FOLLOW_46_in_ruleEssentialOCLInfixOperatorCS4431); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2070:8: lv_name_0_7= '>='
                    {
                    lv_name_0_7=(Token)match(input,47,FollowSets000.FOLLOW_47_in_ruleEssentialOCLInfixOperatorCS4460); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2082:8: lv_name_0_8= '<='
                    {
                    lv_name_0_8=(Token)match(input,48,FollowSets000.FOLLOW_48_in_ruleEssentialOCLInfixOperatorCS4489); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2094:8: lv_name_0_9= '='
                    {
                    lv_name_0_9=(Token)match(input,49,FollowSets000.FOLLOW_49_in_ruleEssentialOCLInfixOperatorCS4518); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2106:8: lv_name_0_10= '<>'
                    {
                    lv_name_0_10=(Token)match(input,50,FollowSets000.FOLLOW_50_in_ruleEssentialOCLInfixOperatorCS4547); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2118:8: lv_name_0_11= 'and'
                    {
                    lv_name_0_11=(Token)match(input,51,FollowSets000.FOLLOW_51_in_ruleEssentialOCLInfixOperatorCS4576); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2130:8: lv_name_0_12= 'or'
                    {
                    lv_name_0_12=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleEssentialOCLInfixOperatorCS4605); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2142:8: lv_name_0_13= 'xor'
                    {
                    lv_name_0_13=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleEssentialOCLInfixOperatorCS4634); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2154:8: lv_name_0_14= 'implies'
                    {
                    lv_name_0_14=(Token)match(input,54,FollowSets000.FOLLOW_54_in_ruleEssentialOCLInfixOperatorCS4663); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2177:1: entryRuleEssentialOCLNavigationOperatorCS returns [EObject current=null] : iv_ruleEssentialOCLNavigationOperatorCS= ruleEssentialOCLNavigationOperatorCS EOF ;
    public final EObject entryRuleEssentialOCLNavigationOperatorCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEssentialOCLNavigationOperatorCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2178:2: (iv_ruleEssentialOCLNavigationOperatorCS= ruleEssentialOCLNavigationOperatorCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2179:2: iv_ruleEssentialOCLNavigationOperatorCS= ruleEssentialOCLNavigationOperatorCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEssentialOCLNavigationOperatorCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLNavigationOperatorCS_in_entryRuleEssentialOCLNavigationOperatorCS4714);
            iv_ruleEssentialOCLNavigationOperatorCS=ruleEssentialOCLNavigationOperatorCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEssentialOCLNavigationOperatorCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEssentialOCLNavigationOperatorCS4724); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2186:1: ruleEssentialOCLNavigationOperatorCS returns [EObject current=null] : ( ( (lv_name_0_1= '.' | lv_name_0_2= '->' ) ) ) ;
    public final EObject ruleEssentialOCLNavigationOperatorCS() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2189:28: ( ( ( (lv_name_0_1= '.' | lv_name_0_2= '->' ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2190:1: ( ( (lv_name_0_1= '.' | lv_name_0_2= '->' ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2190:1: ( ( (lv_name_0_1= '.' | lv_name_0_2= '->' ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2191:1: ( (lv_name_0_1= '.' | lv_name_0_2= '->' ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2191:1: ( (lv_name_0_1= '.' | lv_name_0_2= '->' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2192:1: (lv_name_0_1= '.' | lv_name_0_2= '->' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2192:1: (lv_name_0_1= '.' | lv_name_0_2= '->' )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==55) ) {
                alt41=1;
            }
            else if ( (LA41_0==56) ) {
                alt41=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }
            switch (alt41) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2193:3: lv_name_0_1= '.'
                    {
                    lv_name_0_1=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleEssentialOCLNavigationOperatorCS4768); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2205:8: lv_name_0_2= '->'
                    {
                    lv_name_0_2=(Token)match(input,56,FollowSets000.FOLLOW_56_in_ruleEssentialOCLNavigationOperatorCS4797); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2228:1: entryRuleIdentifier returns [String current=null] : iv_ruleIdentifier= ruleIdentifier EOF ;
    public final String entryRuleIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdentifier = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2229:2: (iv_ruleIdentifier= ruleIdentifier EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2230:2: iv_ruleIdentifier= ruleIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIdentifierRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_entryRuleIdentifier4849);
            iv_ruleIdentifier=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIdentifier.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIdentifier4860); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2237:1: ruleIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= ruleID ;
    public final AntlrDatatypeRuleToken ruleIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_ID_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2240:28: (this_ID_0= ruleID )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2242:5: this_ID_0= ruleID
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getIdentifierAccess().getIDParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleID_in_ruleIdentifier4906);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2260:1: entryRuleStringLiteral returns [String current=null] : iv_ruleStringLiteral= ruleStringLiteral EOF ;
    public final String entryRuleStringLiteral() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleStringLiteral = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2261:2: (iv_ruleStringLiteral= ruleStringLiteral EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2262:2: iv_ruleStringLiteral= ruleStringLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStringLiteralRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral4951);
            iv_ruleStringLiteral=ruleStringLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStringLiteral.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleStringLiteral4962); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2269:1: ruleStringLiteral returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING ;
    public final AntlrDatatypeRuleToken ruleStringLiteral() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_SINGLE_QUOTED_STRING_0=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2272:28: (this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2273:5: this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING
            {
            this_SINGLE_QUOTED_STRING_0=(Token)match(input,RULE_SINGLE_QUOTED_STRING,FollowSets000.FOLLOW_RULE_SINGLE_QUOTED_STRING_in_ruleStringLiteral5001); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2288:1: entryRuleBinaryOperatorCS returns [EObject current=null] : iv_ruleBinaryOperatorCS= ruleBinaryOperatorCS EOF ;
    public final EObject entryRuleBinaryOperatorCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinaryOperatorCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2289:2: (iv_ruleBinaryOperatorCS= ruleBinaryOperatorCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2290:2: iv_ruleBinaryOperatorCS= ruleBinaryOperatorCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBinaryOperatorCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleBinaryOperatorCS_in_entryRuleBinaryOperatorCS5045);
            iv_ruleBinaryOperatorCS=ruleBinaryOperatorCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBinaryOperatorCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBinaryOperatorCS5055); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2297:1: ruleBinaryOperatorCS returns [EObject current=null] : (this_InfixOperatorCS_0= ruleInfixOperatorCS | this_NavigationOperatorCS_1= ruleNavigationOperatorCS ) ;
    public final EObject ruleBinaryOperatorCS() throws RecognitionException {
        EObject current = null;

        EObject this_InfixOperatorCS_0 = null;

        EObject this_NavigationOperatorCS_1 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2300:28: ( (this_InfixOperatorCS_0= ruleInfixOperatorCS | this_NavigationOperatorCS_1= ruleNavigationOperatorCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2301:1: (this_InfixOperatorCS_0= ruleInfixOperatorCS | this_NavigationOperatorCS_1= ruleNavigationOperatorCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2301:1: (this_InfixOperatorCS_0= ruleInfixOperatorCS | this_NavigationOperatorCS_1= ruleNavigationOperatorCS )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==34||LA42_0==41||(LA42_0>=43 && LA42_0<=54)) ) {
                alt42=1;
            }
            else if ( ((LA42_0>=55 && LA42_0<=56)) ) {
                alt42=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }
            switch (alt42) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2302:2: this_InfixOperatorCS_0= ruleInfixOperatorCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBinaryOperatorCSAccess().getInfixOperatorCSParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleInfixOperatorCS_in_ruleBinaryOperatorCS5105);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2315:2: this_NavigationOperatorCS_1= ruleNavigationOperatorCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBinaryOperatorCSAccess().getNavigationOperatorCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNavigationOperatorCS_in_ruleBinaryOperatorCS5135);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2334:1: entryRuleInfixOperatorCS returns [EObject current=null] : iv_ruleInfixOperatorCS= ruleInfixOperatorCS EOF ;
    public final EObject entryRuleInfixOperatorCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInfixOperatorCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2335:2: (iv_ruleInfixOperatorCS= ruleInfixOperatorCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2336:2: iv_ruleInfixOperatorCS= ruleInfixOperatorCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInfixOperatorCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleInfixOperatorCS_in_entryRuleInfixOperatorCS5170);
            iv_ruleInfixOperatorCS=ruleInfixOperatorCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInfixOperatorCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleInfixOperatorCS5180); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2343:1: ruleInfixOperatorCS returns [EObject current=null] : this_EssentialOCLInfixOperatorCS_0= ruleEssentialOCLInfixOperatorCS ;
    public final EObject ruleInfixOperatorCS() throws RecognitionException {
        EObject current = null;

        EObject this_EssentialOCLInfixOperatorCS_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2346:28: (this_EssentialOCLInfixOperatorCS_0= ruleEssentialOCLInfixOperatorCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2348:2: this_EssentialOCLInfixOperatorCS_0= ruleEssentialOCLInfixOperatorCS
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getInfixOperatorCSAccess().getEssentialOCLInfixOperatorCSParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLInfixOperatorCS_in_ruleInfixOperatorCS5229);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2367:1: entryRuleNavigationOperatorCS returns [EObject current=null] : iv_ruleNavigationOperatorCS= ruleNavigationOperatorCS EOF ;
    public final EObject entryRuleNavigationOperatorCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigationOperatorCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2368:2: (iv_ruleNavigationOperatorCS= ruleNavigationOperatorCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2369:2: iv_ruleNavigationOperatorCS= ruleNavigationOperatorCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigationOperatorCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigationOperatorCS_in_entryRuleNavigationOperatorCS5263);
            iv_ruleNavigationOperatorCS=ruleNavigationOperatorCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigationOperatorCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigationOperatorCS5273); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2376:1: ruleNavigationOperatorCS returns [EObject current=null] : this_EssentialOCLNavigationOperatorCS_0= ruleEssentialOCLNavigationOperatorCS ;
    public final EObject ruleNavigationOperatorCS() throws RecognitionException {
        EObject current = null;

        EObject this_EssentialOCLNavigationOperatorCS_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2379:28: (this_EssentialOCLNavigationOperatorCS_0= ruleEssentialOCLNavigationOperatorCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2381:2: this_EssentialOCLNavigationOperatorCS_0= ruleEssentialOCLNavigationOperatorCS
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getNavigationOperatorCSAccess().getEssentialOCLNavigationOperatorCSParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLNavigationOperatorCS_in_ruleNavigationOperatorCS5322);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2400:1: entryRuleUnaryOperatorCS returns [EObject current=null] : iv_ruleUnaryOperatorCS= ruleUnaryOperatorCS EOF ;
    public final EObject entryRuleUnaryOperatorCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryOperatorCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2401:2: (iv_ruleUnaryOperatorCS= ruleUnaryOperatorCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2402:2: iv_ruleUnaryOperatorCS= ruleUnaryOperatorCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryOperatorCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnaryOperatorCS_in_entryRuleUnaryOperatorCS5356);
            iv_ruleUnaryOperatorCS=ruleUnaryOperatorCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnaryOperatorCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnaryOperatorCS5366); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2409:1: ruleUnaryOperatorCS returns [EObject current=null] : this_EssentialOCLUnaryOperatorCS_0= ruleEssentialOCLUnaryOperatorCS ;
    public final EObject ruleUnaryOperatorCS() throws RecognitionException {
        EObject current = null;

        EObject this_EssentialOCLUnaryOperatorCS_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2412:28: (this_EssentialOCLUnaryOperatorCS_0= ruleEssentialOCLUnaryOperatorCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2414:2: this_EssentialOCLUnaryOperatorCS_0= ruleEssentialOCLUnaryOperatorCS
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getUnaryOperatorCSAccess().getEssentialOCLUnaryOperatorCSParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLUnaryOperatorCS_in_ruleUnaryOperatorCS5415);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2433:1: entryRuleEssentialOCLUnrestrictedName returns [String current=null] : iv_ruleEssentialOCLUnrestrictedName= ruleEssentialOCLUnrestrictedName EOF ;
    public final String entryRuleEssentialOCLUnrestrictedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEssentialOCLUnrestrictedName = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2434:2: (iv_ruleEssentialOCLUnrestrictedName= ruleEssentialOCLUnrestrictedName EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2435:2: iv_ruleEssentialOCLUnrestrictedName= ruleEssentialOCLUnrestrictedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEssentialOCLUnrestrictedNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLUnrestrictedName_in_entryRuleEssentialOCLUnrestrictedName5450);
            iv_ruleEssentialOCLUnrestrictedName=ruleEssentialOCLUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEssentialOCLUnrestrictedName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEssentialOCLUnrestrictedName5461); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2442:1: ruleEssentialOCLUnrestrictedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_Identifier_0= ruleIdentifier ;
    public final AntlrDatatypeRuleToken ruleEssentialOCLUnrestrictedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_Identifier_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2445:28: (this_Identifier_0= ruleIdentifier )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2447:5: this_Identifier_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getEssentialOCLUnrestrictedNameAccess().getIdentifierParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_ruleEssentialOCLUnrestrictedName5507);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2465:1: entryRuleEssentialOCLUnreservedName returns [String current=null] : iv_ruleEssentialOCLUnreservedName= ruleEssentialOCLUnreservedName EOF ;
    public final String entryRuleEssentialOCLUnreservedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEssentialOCLUnreservedName = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2466:2: (iv_ruleEssentialOCLUnreservedName= ruleEssentialOCLUnreservedName EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2467:2: iv_ruleEssentialOCLUnreservedName= ruleEssentialOCLUnreservedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEssentialOCLUnreservedNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLUnreservedName_in_entryRuleEssentialOCLUnreservedName5552);
            iv_ruleEssentialOCLUnreservedName=ruleEssentialOCLUnreservedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEssentialOCLUnreservedName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEssentialOCLUnreservedName5563); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2474:1: ruleEssentialOCLUnreservedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_UnrestrictedName_0= ruleUnrestrictedName | this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier | this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier | kw= 'Tuple' ) ;
    public final AntlrDatatypeRuleToken ruleEssentialOCLUnreservedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_UnrestrictedName_0 = null;

        AntlrDatatypeRuleToken this_CollectionTypeIdentifier_1 = null;

        AntlrDatatypeRuleToken this_PrimitiveTypeIdentifier_2 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2477:28: ( (this_UnrestrictedName_0= ruleUnrestrictedName | this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier | this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier | kw= 'Tuple' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2478:1: (this_UnrestrictedName_0= ruleUnrestrictedName | this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier | this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier | kw= 'Tuple' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2478:1: (this_UnrestrictedName_0= ruleUnrestrictedName | this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier | this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier | kw= 'Tuple' )
            int alt43=4;
            switch ( input.LA(1) ) {
            case RULE_SIMPLE_ID:
            case RULE_ESCAPED_ID:
            case 16:
            case 18:
            case 27:
            case 28:
            case 31:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
                {
                alt43=1;
                }
                break;
            case 66:
            case 67:
            case 68:
            case 69:
            case 70:
                {
                alt43=2;
                }
                break;
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
                {
                alt43=3;
                }
                break;
            case 57:
                {
                alt43=4;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2479:5: this_UnrestrictedName_0= ruleUnrestrictedName
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getEssentialOCLUnreservedNameAccess().getUnrestrictedNameParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleEssentialOCLUnreservedName5610);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2491:5: this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getEssentialOCLUnreservedNameAccess().getCollectionTypeIdentifierParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCollectionTypeIdentifier_in_ruleEssentialOCLUnreservedName5643);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2503:5: this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getEssentialOCLUnreservedNameAccess().getPrimitiveTypeIdentifierParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrimitiveTypeIdentifier_in_ruleEssentialOCLUnreservedName5676);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2515:2: kw= 'Tuple'
                    {
                    kw=(Token)match(input,57,FollowSets000.FOLLOW_57_in_ruleEssentialOCLUnreservedName5700); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2528:1: entryRuleUnreservedName returns [String current=null] : iv_ruleUnreservedName= ruleUnreservedName EOF ;
    public final String entryRuleUnreservedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnreservedName = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2529:2: (iv_ruleUnreservedName= ruleUnreservedName EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2530:2: iv_ruleUnreservedName= ruleUnreservedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnreservedNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnreservedName_in_entryRuleUnreservedName5741);
            iv_ruleUnreservedName=ruleUnreservedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnreservedName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnreservedName5752); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2537:1: ruleUnreservedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_EssentialOCLUnreservedName_0= ruleEssentialOCLUnreservedName ;
    public final AntlrDatatypeRuleToken ruleUnreservedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_EssentialOCLUnreservedName_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2540:28: (this_EssentialOCLUnreservedName_0= ruleEssentialOCLUnreservedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2542:5: this_EssentialOCLUnreservedName_0= ruleEssentialOCLUnreservedName
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getUnreservedNameAccess().getEssentialOCLUnreservedNameParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLUnreservedName_in_ruleUnreservedName5798);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2560:1: entryRulePathNameCS returns [EObject current=null] : iv_rulePathNameCS= rulePathNameCS EOF ;
    public final EObject entryRulePathNameCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePathNameCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2561:2: (iv_rulePathNameCS= rulePathNameCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2562:2: iv_rulePathNameCS= rulePathNameCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPathNameCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePathNameCS_in_entryRulePathNameCS5842);
            iv_rulePathNameCS=rulePathNameCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePathNameCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePathNameCS5852); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2569:1: rulePathNameCS returns [EObject current=null] : ( ( (lv_path_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )* ) ;
    public final EObject rulePathNameCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_path_0_0 = null;

        EObject lv_path_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2572:28: ( ( ( (lv_path_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )* ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2573:1: ( ( (lv_path_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )* )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2573:1: ( ( (lv_path_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )* )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2573:2: ( (lv_path_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )*
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2573:2: ( (lv_path_0_0= ruleFirstPathElementCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2574:1: (lv_path_0_0= ruleFirstPathElementCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2574:1: (lv_path_0_0= ruleFirstPathElementCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2575:3: lv_path_0_0= ruleFirstPathElementCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPathNameCSAccess().getPathFirstPathElementCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleFirstPathElementCS_in_rulePathNameCS5898);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2591:2: (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==33) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2591:4: otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) )
            	    {
            	    otherlv_1=(Token)match(input,33,FollowSets000.FOLLOW_33_in_rulePathNameCS5911); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getPathNameCSAccess().getColonColonKeyword_1_0());
            	          
            	    }
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2595:1: ( (lv_path_2_0= ruleNextPathElementCS ) )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2596:1: (lv_path_2_0= ruleNextPathElementCS )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2596:1: (lv_path_2_0= ruleNextPathElementCS )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2597:3: lv_path_2_0= ruleNextPathElementCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getPathNameCSAccess().getPathNextPathElementCSParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleNextPathElementCS_in_rulePathNameCS5932);
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
            	    break loop44;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2621:1: entryRuleFirstPathElementCS returns [EObject current=null] : iv_ruleFirstPathElementCS= ruleFirstPathElementCS EOF ;
    public final EObject entryRuleFirstPathElementCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFirstPathElementCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2622:2: (iv_ruleFirstPathElementCS= ruleFirstPathElementCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2623:2: iv_ruleFirstPathElementCS= ruleFirstPathElementCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFirstPathElementCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleFirstPathElementCS_in_entryRuleFirstPathElementCS5970);
            iv_ruleFirstPathElementCS=ruleFirstPathElementCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFirstPathElementCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFirstPathElementCS5980); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2630:1: ruleFirstPathElementCS returns [EObject current=null] : ( ( ruleUnrestrictedName ) ) ;
    public final EObject ruleFirstPathElementCS() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2633:28: ( ( ( ruleUnrestrictedName ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2634:1: ( ( ruleUnrestrictedName ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2634:1: ( ( ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2635:1: ( ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2635:1: ( ruleUnrestrictedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2636:3: ruleUnrestrictedName
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
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleFirstPathElementCS6031);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2660:1: entryRuleNextPathElementCS returns [EObject current=null] : iv_ruleNextPathElementCS= ruleNextPathElementCS EOF ;
    public final EObject entryRuleNextPathElementCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNextPathElementCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2661:2: (iv_ruleNextPathElementCS= ruleNextPathElementCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2662:2: iv_ruleNextPathElementCS= ruleNextPathElementCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNextPathElementCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNextPathElementCS_in_entryRuleNextPathElementCS6066);
            iv_ruleNextPathElementCS=ruleNextPathElementCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNextPathElementCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNextPathElementCS6076); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2669:1: ruleNextPathElementCS returns [EObject current=null] : ( ( ruleUnreservedName ) ) ;
    public final EObject ruleNextPathElementCS() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2672:28: ( ( ( ruleUnreservedName ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2673:1: ( ( ruleUnreservedName ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2673:1: ( ( ruleUnreservedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2674:1: ( ruleUnreservedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2674:1: ( ruleUnreservedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2675:3: ruleUnreservedName
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
            pushFollow(FollowSets000.FOLLOW_ruleUnreservedName_in_ruleNextPathElementCS6127);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2699:1: entryRuleURIPathNameCS returns [EObject current=null] : iv_ruleURIPathNameCS= ruleURIPathNameCS EOF ;
    public final EObject entryRuleURIPathNameCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleURIPathNameCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2700:2: (iv_ruleURIPathNameCS= ruleURIPathNameCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2701:2: iv_ruleURIPathNameCS= ruleURIPathNameCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getURIPathNameCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleURIPathNameCS_in_entryRuleURIPathNameCS6162);
            iv_ruleURIPathNameCS=ruleURIPathNameCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleURIPathNameCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleURIPathNameCS6172); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2708:1: ruleURIPathNameCS returns [EObject current=null] : ( ( (lv_path_0_0= ruleURIFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )* ) ;
    public final EObject ruleURIPathNameCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_path_0_0 = null;

        EObject lv_path_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2711:28: ( ( ( (lv_path_0_0= ruleURIFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )* ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2712:1: ( ( (lv_path_0_0= ruleURIFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )* )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2712:1: ( ( (lv_path_0_0= ruleURIFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )* )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2712:2: ( (lv_path_0_0= ruleURIFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )*
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2712:2: ( (lv_path_0_0= ruleURIFirstPathElementCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2713:1: (lv_path_0_0= ruleURIFirstPathElementCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2713:1: (lv_path_0_0= ruleURIFirstPathElementCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2714:3: lv_path_0_0= ruleURIFirstPathElementCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getURIPathNameCSAccess().getPathURIFirstPathElementCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleURIFirstPathElementCS_in_ruleURIPathNameCS6218);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2730:2: (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==33) ) {
                    int LA45_1 = input.LA(2);

                    if ( ((LA45_1>=RULE_SIMPLE_ID && LA45_1<=RULE_ESCAPED_ID)||LA45_1==16||LA45_1==18||(LA45_1>=27 && LA45_1<=28)||LA45_1==31||(LA45_1>=35 && LA45_1<=40)||(LA45_1>=57 && LA45_1<=70)) ) {
                        alt45=1;
                    }


                }


                switch (alt45) {
            	case 1 :
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2730:4: otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) )
            	    {
            	    otherlv_1=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleURIPathNameCS6231); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getURIPathNameCSAccess().getColonColonKeyword_1_0());
            	          
            	    }
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2734:1: ( (lv_path_2_0= ruleNextPathElementCS ) )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2735:1: (lv_path_2_0= ruleNextPathElementCS )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2735:1: (lv_path_2_0= ruleNextPathElementCS )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2736:3: lv_path_2_0= ruleNextPathElementCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getURIPathNameCSAccess().getPathNextPathElementCSParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleNextPathElementCS_in_ruleURIPathNameCS6252);
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
            	    break loop45;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2760:1: entryRuleURIFirstPathElementCS returns [EObject current=null] : iv_ruleURIFirstPathElementCS= ruleURIFirstPathElementCS EOF ;
    public final EObject entryRuleURIFirstPathElementCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleURIFirstPathElementCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2761:2: (iv_ruleURIFirstPathElementCS= ruleURIFirstPathElementCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2762:2: iv_ruleURIFirstPathElementCS= ruleURIFirstPathElementCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getURIFirstPathElementCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleURIFirstPathElementCS_in_entryRuleURIFirstPathElementCS6290);
            iv_ruleURIFirstPathElementCS=ruleURIFirstPathElementCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleURIFirstPathElementCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleURIFirstPathElementCS6300); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2769:1: ruleURIFirstPathElementCS returns [EObject current=null] : ( ( ( ruleUnrestrictedName ) ) | ( () ( ( ruleURI ) ) ) ) ;
    public final EObject ruleURIFirstPathElementCS() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2772:28: ( ( ( ( ruleUnrestrictedName ) ) | ( () ( ( ruleURI ) ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2773:1: ( ( ( ruleUnrestrictedName ) ) | ( () ( ( ruleURI ) ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2773:1: ( ( ( ruleUnrestrictedName ) ) | ( () ( ( ruleURI ) ) ) )
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( ((LA46_0>=RULE_SIMPLE_ID && LA46_0<=RULE_ESCAPED_ID)||LA46_0==16||LA46_0==18||(LA46_0>=27 && LA46_0<=28)||LA46_0==31||(LA46_0>=35 && LA46_0<=40)) ) {
                alt46=1;
            }
            else if ( (LA46_0==RULE_SINGLE_QUOTED_STRING) ) {
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2773:2: ( ( ruleUnrestrictedName ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2773:2: ( ( ruleUnrestrictedName ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2774:1: ( ruleUnrestrictedName )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2774:1: ( ruleUnrestrictedName )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2775:3: ruleUnrestrictedName
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
                    pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleURIFirstPathElementCS6352);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2792:6: ( () ( ( ruleURI ) ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2792:6: ( () ( ( ruleURI ) ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2792:7: () ( ( ruleURI ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2792:7: ()
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2793:2: 
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

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2801:2: ( ( ruleURI ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2802:1: ( ruleURI )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2802:1: ( ruleURI )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2803:3: ruleURI
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
                    pushFollow(FollowSets000.FOLLOW_ruleURI_in_ruleURIFirstPathElementCS6398);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2827:1: entryRulePrimitiveTypeIdentifier returns [String current=null] : iv_rulePrimitiveTypeIdentifier= rulePrimitiveTypeIdentifier EOF ;
    public final String entryRulePrimitiveTypeIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePrimitiveTypeIdentifier = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2828:2: (iv_rulePrimitiveTypeIdentifier= rulePrimitiveTypeIdentifier EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2829:2: iv_rulePrimitiveTypeIdentifier= rulePrimitiveTypeIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimitiveTypeIdentifierRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePrimitiveTypeIdentifier_in_entryRulePrimitiveTypeIdentifier6436);
            iv_rulePrimitiveTypeIdentifier=rulePrimitiveTypeIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimitiveTypeIdentifier.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrimitiveTypeIdentifier6447); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2836:1: rulePrimitiveTypeIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Boolean' | kw= 'Integer' | kw= 'Real' | kw= 'String' | kw= 'UnlimitedNatural' | kw= 'OclAny' | kw= 'OclInvalid' | kw= 'OclVoid' ) ;
    public final AntlrDatatypeRuleToken rulePrimitiveTypeIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2839:28: ( (kw= 'Boolean' | kw= 'Integer' | kw= 'Real' | kw= 'String' | kw= 'UnlimitedNatural' | kw= 'OclAny' | kw= 'OclInvalid' | kw= 'OclVoid' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2840:1: (kw= 'Boolean' | kw= 'Integer' | kw= 'Real' | kw= 'String' | kw= 'UnlimitedNatural' | kw= 'OclAny' | kw= 'OclInvalid' | kw= 'OclVoid' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2840:1: (kw= 'Boolean' | kw= 'Integer' | kw= 'Real' | kw= 'String' | kw= 'UnlimitedNatural' | kw= 'OclAny' | kw= 'OclInvalid' | kw= 'OclVoid' )
            int alt47=8;
            switch ( input.LA(1) ) {
            case 58:
                {
                alt47=1;
                }
                break;
            case 59:
                {
                alt47=2;
                }
                break;
            case 60:
                {
                alt47=3;
                }
                break;
            case 61:
                {
                alt47=4;
                }
                break;
            case 62:
                {
                alt47=5;
                }
                break;
            case 63:
                {
                alt47=6;
                }
                break;
            case 64:
                {
                alt47=7;
                }
                break;
            case 65:
                {
                alt47=8;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2841:2: kw= 'Boolean'
                    {
                    kw=(Token)match(input,58,FollowSets000.FOLLOW_58_in_rulePrimitiveTypeIdentifier6485); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getBooleanKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2848:2: kw= 'Integer'
                    {
                    kw=(Token)match(input,59,FollowSets000.FOLLOW_59_in_rulePrimitiveTypeIdentifier6504); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getIntegerKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2855:2: kw= 'Real'
                    {
                    kw=(Token)match(input,60,FollowSets000.FOLLOW_60_in_rulePrimitiveTypeIdentifier6523); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getRealKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2862:2: kw= 'String'
                    {
                    kw=(Token)match(input,61,FollowSets000.FOLLOW_61_in_rulePrimitiveTypeIdentifier6542); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getStringKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2869:2: kw= 'UnlimitedNatural'
                    {
                    kw=(Token)match(input,62,FollowSets000.FOLLOW_62_in_rulePrimitiveTypeIdentifier6561); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getUnlimitedNaturalKeyword_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2876:2: kw= 'OclAny'
                    {
                    kw=(Token)match(input,63,FollowSets000.FOLLOW_63_in_rulePrimitiveTypeIdentifier6580); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getOclAnyKeyword_5()); 
                          
                    }

                    }
                    break;
                case 7 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2883:2: kw= 'OclInvalid'
                    {
                    kw=(Token)match(input,64,FollowSets000.FOLLOW_64_in_rulePrimitiveTypeIdentifier6599); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getOclInvalidKeyword_6()); 
                          
                    }

                    }
                    break;
                case 8 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2890:2: kw= 'OclVoid'
                    {
                    kw=(Token)match(input,65,FollowSets000.FOLLOW_65_in_rulePrimitiveTypeIdentifier6618); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2903:1: entryRulePrimitiveTypeCS returns [EObject current=null] : iv_rulePrimitiveTypeCS= rulePrimitiveTypeCS EOF ;
    public final EObject entryRulePrimitiveTypeCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveTypeCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2904:2: (iv_rulePrimitiveTypeCS= rulePrimitiveTypeCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2905:2: iv_rulePrimitiveTypeCS= rulePrimitiveTypeCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimitiveTypeCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePrimitiveTypeCS_in_entryRulePrimitiveTypeCS6658);
            iv_rulePrimitiveTypeCS=rulePrimitiveTypeCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimitiveTypeCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrimitiveTypeCS6668); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2912:1: rulePrimitiveTypeCS returns [EObject current=null] : ( (lv_name_0_0= rulePrimitiveTypeIdentifier ) ) ;
    public final EObject rulePrimitiveTypeCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2915:28: ( ( (lv_name_0_0= rulePrimitiveTypeIdentifier ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2916:1: ( (lv_name_0_0= rulePrimitiveTypeIdentifier ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2916:1: ( (lv_name_0_0= rulePrimitiveTypeIdentifier ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2917:1: (lv_name_0_0= rulePrimitiveTypeIdentifier )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2917:1: (lv_name_0_0= rulePrimitiveTypeIdentifier )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2918:3: lv_name_0_0= rulePrimitiveTypeIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPrimitiveTypeCSAccess().getNamePrimitiveTypeIdentifierParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_rulePrimitiveTypeIdentifier_in_rulePrimitiveTypeCS6713);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2942:1: entryRuleCollectionTypeIdentifier returns [String current=null] : iv_ruleCollectionTypeIdentifier= ruleCollectionTypeIdentifier EOF ;
    public final String entryRuleCollectionTypeIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleCollectionTypeIdentifier = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2943:2: (iv_ruleCollectionTypeIdentifier= ruleCollectionTypeIdentifier EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2944:2: iv_ruleCollectionTypeIdentifier= ruleCollectionTypeIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCollectionTypeIdentifierRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleCollectionTypeIdentifier_in_entryRuleCollectionTypeIdentifier6749);
            iv_ruleCollectionTypeIdentifier=ruleCollectionTypeIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCollectionTypeIdentifier.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCollectionTypeIdentifier6760); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2951:1: ruleCollectionTypeIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Set' | kw= 'Bag' | kw= 'Sequence' | kw= 'Collection' | kw= 'OrderedSet' ) ;
    public final AntlrDatatypeRuleToken ruleCollectionTypeIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2954:28: ( (kw= 'Set' | kw= 'Bag' | kw= 'Sequence' | kw= 'Collection' | kw= 'OrderedSet' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2955:1: (kw= 'Set' | kw= 'Bag' | kw= 'Sequence' | kw= 'Collection' | kw= 'OrderedSet' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2955:1: (kw= 'Set' | kw= 'Bag' | kw= 'Sequence' | kw= 'Collection' | kw= 'OrderedSet' )
            int alt48=5;
            switch ( input.LA(1) ) {
            case 66:
                {
                alt48=1;
                }
                break;
            case 67:
                {
                alt48=2;
                }
                break;
            case 68:
                {
                alt48=3;
                }
                break;
            case 69:
                {
                alt48=4;
                }
                break;
            case 70:
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2956:2: kw= 'Set'
                    {
                    kw=(Token)match(input,66,FollowSets000.FOLLOW_66_in_ruleCollectionTypeIdentifier6798); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getSetKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2963:2: kw= 'Bag'
                    {
                    kw=(Token)match(input,67,FollowSets000.FOLLOW_67_in_ruleCollectionTypeIdentifier6817); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getBagKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2970:2: kw= 'Sequence'
                    {
                    kw=(Token)match(input,68,FollowSets000.FOLLOW_68_in_ruleCollectionTypeIdentifier6836); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getSequenceKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2977:2: kw= 'Collection'
                    {
                    kw=(Token)match(input,69,FollowSets000.FOLLOW_69_in_ruleCollectionTypeIdentifier6855); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getCollectionKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2984:2: kw= 'OrderedSet'
                    {
                    kw=(Token)match(input,70,FollowSets000.FOLLOW_70_in_ruleCollectionTypeIdentifier6874); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2997:1: entryRuleCollectionTypeCS returns [EObject current=null] : iv_ruleCollectionTypeCS= ruleCollectionTypeCS EOF ;
    public final EObject entryRuleCollectionTypeCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionTypeCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2998:2: (iv_ruleCollectionTypeCS= ruleCollectionTypeCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2999:2: iv_ruleCollectionTypeCS= ruleCollectionTypeCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCollectionTypeCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleCollectionTypeCS_in_entryRuleCollectionTypeCS6914);
            iv_ruleCollectionTypeCS=ruleCollectionTypeCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCollectionTypeCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCollectionTypeCS6924); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3006:1: ruleCollectionTypeCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )? ) ;
    public final EObject ruleCollectionTypeCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3009:28: ( ( ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3010:1: ( ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3010:1: ( ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3010:2: ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )?
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3010:2: ( (lv_name_0_0= ruleCollectionTypeIdentifier ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3011:1: (lv_name_0_0= ruleCollectionTypeIdentifier )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3011:1: (lv_name_0_0= ruleCollectionTypeIdentifier )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3012:3: lv_name_0_0= ruleCollectionTypeIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCollectionTypeCSAccess().getNameCollectionTypeIdentifierParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleCollectionTypeIdentifier_in_ruleCollectionTypeCS6970);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3028:2: (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==29) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3028:4: otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleCollectionTypeCS6983); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getCollectionTypeCSAccess().getLeftParenthesisKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3032:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3033:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3033:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3034:3: lv_ownedType_2_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionTypeCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleCollectionTypeCS7004);
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

                    otherlv_3=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleCollectionTypeCS7016); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3062:1: entryRuleMultiplicityBoundsCS returns [EObject current=null] : iv_ruleMultiplicityBoundsCS= ruleMultiplicityBoundsCS EOF ;
    public final EObject entryRuleMultiplicityBoundsCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicityBoundsCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3063:2: (iv_ruleMultiplicityBoundsCS= ruleMultiplicityBoundsCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3064:2: iv_ruleMultiplicityBoundsCS= ruleMultiplicityBoundsCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicityBoundsCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMultiplicityBoundsCS_in_entryRuleMultiplicityBoundsCS7054);
            iv_ruleMultiplicityBoundsCS=ruleMultiplicityBoundsCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicityBoundsCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMultiplicityBoundsCS7064); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3071:1: ruleMultiplicityBoundsCS returns [EObject current=null] : ( ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )? ) ;
    public final EObject ruleMultiplicityBoundsCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_lowerBound_0_0 = null;

        AntlrDatatypeRuleToken lv_upperBound_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3074:28: ( ( ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3075:1: ( ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3075:1: ( ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3075:2: ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )?
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3075:2: ( (lv_lowerBound_0_0= ruleLOWER ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3076:1: (lv_lowerBound_0_0= ruleLOWER )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3076:1: (lv_lowerBound_0_0= ruleLOWER )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3077:3: lv_lowerBound_0_0= ruleLOWER
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiplicityBoundsCSAccess().getLowerBoundLOWERParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleLOWER_in_ruleMultiplicityBoundsCS7110);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3093:2: (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==71) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3093:4: otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) )
                    {
                    otherlv_1=(Token)match(input,71,FollowSets000.FOLLOW_71_in_ruleMultiplicityBoundsCS7123); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getMultiplicityBoundsCSAccess().getFullStopFullStopKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3097:1: ( (lv_upperBound_2_0= ruleUPPER ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3098:1: (lv_upperBound_2_0= ruleUPPER )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3098:1: (lv_upperBound_2_0= ruleUPPER )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3099:3: lv_upperBound_2_0= ruleUPPER
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMultiplicityBoundsCSAccess().getUpperBoundUPPERParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUPPER_in_ruleMultiplicityBoundsCS7144);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3123:1: entryRuleMultiplicityCS returns [EObject current=null] : iv_ruleMultiplicityCS= ruleMultiplicityCS EOF ;
    public final EObject entryRuleMultiplicityCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicityCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3124:2: (iv_ruleMultiplicityCS= ruleMultiplicityCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3125:2: iv_ruleMultiplicityCS= ruleMultiplicityCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicityCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMultiplicityCS_in_entryRuleMultiplicityCS7182);
            iv_ruleMultiplicityCS=ruleMultiplicityCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicityCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMultiplicityCS7192); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3132:1: ruleMultiplicityCS returns [EObject current=null] : (otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) otherlv_3= ']' ) ;
    public final EObject ruleMultiplicityCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        EObject this_MultiplicityBoundsCS_1 = null;

        EObject this_MultiplicityStringCS_2 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3135:28: ( (otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) otherlv_3= ']' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3136:1: (otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) otherlv_3= ']' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3136:1: (otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) otherlv_3= ']' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3136:3: otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) otherlv_3= ']'
            {
            otherlv_0=(Token)match(input,72,FollowSets000.FOLLOW_72_in_ruleMultiplicityCS7229); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMultiplicityCSAccess().getLeftSquareBracketKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3140:1: (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS )
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==RULE_INT) ) {
                alt51=1;
            }
            else if ( (LA51_0==34||LA51_0==44||LA51_0==74) ) {
                alt51=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }
            switch (alt51) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3141:2: this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getMultiplicityCSAccess().getMultiplicityBoundsCSParserRuleCall_1_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMultiplicityBoundsCS_in_ruleMultiplicityCS7255);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3154:2: this_MultiplicityStringCS_2= ruleMultiplicityStringCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getMultiplicityCSAccess().getMultiplicityStringCSParserRuleCall_1_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMultiplicityStringCS_in_ruleMultiplicityCS7285);
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

            otherlv_3=(Token)match(input,73,FollowSets000.FOLLOW_73_in_ruleMultiplicityCS7297); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3177:1: entryRuleMultiplicityStringCS returns [EObject current=null] : iv_ruleMultiplicityStringCS= ruleMultiplicityStringCS EOF ;
    public final EObject entryRuleMultiplicityStringCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicityStringCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3178:2: (iv_ruleMultiplicityStringCS= ruleMultiplicityStringCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3179:2: iv_ruleMultiplicityStringCS= ruleMultiplicityStringCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicityStringCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMultiplicityStringCS_in_entryRuleMultiplicityStringCS7333);
            iv_ruleMultiplicityStringCS=ruleMultiplicityStringCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicityStringCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMultiplicityStringCS7343); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3186:1: ruleMultiplicityStringCS returns [EObject current=null] : ( ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) ) ) ;
    public final EObject ruleMultiplicityStringCS() throws RecognitionException {
        EObject current = null;

        Token lv_stringBounds_0_1=null;
        Token lv_stringBounds_0_2=null;
        Token lv_stringBounds_0_3=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3189:28: ( ( ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3190:1: ( ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3190:1: ( ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3191:1: ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3191:1: ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3192:1: (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3192:1: (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' )
            int alt52=3;
            switch ( input.LA(1) ) {
            case 34:
                {
                alt52=1;
                }
                break;
            case 44:
                {
                alt52=2;
                }
                break;
            case 74:
                {
                alt52=3;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3193:3: lv_stringBounds_0_1= '*'
                    {
                    lv_stringBounds_0_1=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleMultiplicityStringCS7387); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3205:8: lv_stringBounds_0_2= '+'
                    {
                    lv_stringBounds_0_2=(Token)match(input,44,FollowSets000.FOLLOW_44_in_ruleMultiplicityStringCS7416); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3217:8: lv_stringBounds_0_3= '?'
                    {
                    lv_stringBounds_0_3=(Token)match(input,74,FollowSets000.FOLLOW_74_in_ruleMultiplicityStringCS7445); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3240:1: entryRuleTupleTypeCS returns [EObject current=null] : iv_ruleTupleTypeCS= ruleTupleTypeCS EOF ;
    public final EObject entryRuleTupleTypeCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTupleTypeCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3241:2: (iv_ruleTupleTypeCS= ruleTupleTypeCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3242:2: iv_ruleTupleTypeCS= ruleTupleTypeCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTupleTypeCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTupleTypeCS_in_entryRuleTupleTypeCS7496);
            iv_ruleTupleTypeCS=ruleTupleTypeCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTupleTypeCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTupleTypeCS7506); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3249:1: ruleTupleTypeCS returns [EObject current=null] : ( ( (lv_name_0_0= 'Tuple' ) ) (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )? ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3252:28: ( ( ( (lv_name_0_0= 'Tuple' ) ) (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3253:1: ( ( (lv_name_0_0= 'Tuple' ) ) (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3253:1: ( ( (lv_name_0_0= 'Tuple' ) ) (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3253:2: ( (lv_name_0_0= 'Tuple' ) ) (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )?
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3253:2: ( (lv_name_0_0= 'Tuple' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3254:1: (lv_name_0_0= 'Tuple' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3254:1: (lv_name_0_0= 'Tuple' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3255:3: lv_name_0_0= 'Tuple'
            {
            lv_name_0_0=(Token)match(input,57,FollowSets000.FOLLOW_57_in_ruleTupleTypeCS7549); if (state.failed) return current;
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3268:2: (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==29) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3268:4: otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')'
                    {
                    otherlv_1=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleTupleTypeCS7575); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getTupleTypeCSAccess().getLeftParenthesisKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3272:1: ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )?
                    int alt54=2;
                    int LA54_0 = input.LA(1);

                    if ( ((LA54_0>=RULE_SIMPLE_ID && LA54_0<=RULE_ESCAPED_ID)||LA54_0==16||LA54_0==18||(LA54_0>=27 && LA54_0<=28)||LA54_0==31||(LA54_0>=35 && LA54_0<=40)) ) {
                        alt54=1;
                    }
                    switch (alt54) {
                        case 1 :
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3272:2: ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )*
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3272:2: ( (lv_ownedParts_2_0= ruleTuplePartCS ) )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3273:1: (lv_ownedParts_2_0= ruleTuplePartCS )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3273:1: (lv_ownedParts_2_0= ruleTuplePartCS )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3274:3: lv_ownedParts_2_0= ruleTuplePartCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getTupleTypeCSAccess().getOwnedPartsTuplePartCSParserRuleCall_1_1_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleTuplePartCS_in_ruleTupleTypeCS7597);
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

                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3290:2: (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )*
                            loop53:
                            do {
                                int alt53=2;
                                int LA53_0 = input.LA(1);

                                if ( (LA53_0==19) ) {
                                    alt53=1;
                                }


                                switch (alt53) {
                            	case 1 :
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3290:4: otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) )
                            	    {
                            	    otherlv_3=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleTupleTypeCS7610); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_3, grammarAccess.getTupleTypeCSAccess().getCommaKeyword_1_1_1_0());
                            	          
                            	    }
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3294:1: ( (lv_ownedParts_4_0= ruleTuplePartCS ) )
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3295:1: (lv_ownedParts_4_0= ruleTuplePartCS )
                            	    {
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3295:1: (lv_ownedParts_4_0= ruleTuplePartCS )
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3296:3: lv_ownedParts_4_0= ruleTuplePartCS
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getTupleTypeCSAccess().getOwnedPartsTuplePartCSParserRuleCall_1_1_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FollowSets000.FOLLOW_ruleTuplePartCS_in_ruleTupleTypeCS7631);
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
                            	    break loop53;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_5=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleTupleTypeCS7647); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3324:1: entryRuleTuplePartCS returns [EObject current=null] : iv_ruleTuplePartCS= ruleTuplePartCS EOF ;
    public final EObject entryRuleTuplePartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTuplePartCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3325:2: (iv_ruleTuplePartCS= ruleTuplePartCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3326:2: iv_ruleTuplePartCS= ruleTuplePartCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTuplePartCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTuplePartCS_in_entryRuleTuplePartCS7685);
            iv_ruleTuplePartCS=ruleTuplePartCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTuplePartCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTuplePartCS7695); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3333:1: ruleTuplePartCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) ) ;
    public final EObject ruleTuplePartCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3336:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3337:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3337:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3337:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3337:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3338:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3338:1: (lv_name_0_0= ruleUnrestrictedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3339:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTuplePartCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleTuplePartCS7741);
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

            otherlv_1=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleTuplePartCS7753); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getTuplePartCSAccess().getColonKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3359:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3360:1: (lv_ownedType_2_0= ruleTypeExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3360:1: (lv_ownedType_2_0= ruleTypeExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3361:3: lv_ownedType_2_0= ruleTypeExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTuplePartCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleTuplePartCS7774);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3385:1: entryRuleCollectionLiteralExpCS returns [EObject current=null] : iv_ruleCollectionLiteralExpCS= ruleCollectionLiteralExpCS EOF ;
    public final EObject entryRuleCollectionLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3386:2: (iv_ruleCollectionLiteralExpCS= ruleCollectionLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3387:2: iv_ruleCollectionLiteralExpCS= ruleCollectionLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCollectionLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteralExpCS_in_entryRuleCollectionLiteralExpCS7810);
            iv_ruleCollectionLiteralExpCS=ruleCollectionLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCollectionLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCollectionLiteralExpCS7820); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3394:1: ruleCollectionLiteralExpCS returns [EObject current=null] : ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}' ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3397:28: ( ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3398:1: ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3398:1: ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3398:2: ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}'
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3398:2: ( (lv_ownedType_0_0= ruleCollectionTypeCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3399:1: (lv_ownedType_0_0= ruleCollectionTypeCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3399:1: (lv_ownedType_0_0= ruleCollectionTypeCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3400:3: lv_ownedType_0_0= ruleCollectionTypeCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedTypeCollectionTypeCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleCollectionTypeCS_in_ruleCollectionLiteralExpCS7866);
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

            otherlv_1=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleCollectionLiteralExpCS7878); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getCollectionLiteralExpCSAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3420:1: ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( ((LA57_0>=RULE_SIMPLE_ID && LA57_0<=RULE_SINGLE_QUOTED_STRING)||LA57_0==16||LA57_0==18||(LA57_0>=27 && LA57_0<=29)||LA57_0==31||(LA57_0>=34 && LA57_0<=42)||(LA57_0>=57 && LA57_0<=70)||(LA57_0>=75 && LA57_0<=78)||LA57_0==81||(LA57_0>=85 && LA57_0<=86)) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3420:2: ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )*
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3420:2: ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3421:1: (lv_ownedParts_2_0= ruleCollectionLiteralPartCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3421:1: (lv_ownedParts_2_0= ruleCollectionLiteralPartCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3422:3: lv_ownedParts_2_0= ruleCollectionLiteralPartCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedPartsCollectionLiteralPartCSParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteralPartCS_in_ruleCollectionLiteralExpCS7900);
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

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3438:2: (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )*
                    loop56:
                    do {
                        int alt56=2;
                        int LA56_0 = input.LA(1);

                        if ( (LA56_0==19) ) {
                            alt56=1;
                        }


                        switch (alt56) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3438:4: otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) )
                    	    {
                    	    otherlv_3=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleCollectionLiteralExpCS7913); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getCollectionLiteralExpCSAccess().getCommaKeyword_2_1_0());
                    	          
                    	    }
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3442:1: ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3443:1: (lv_ownedParts_4_0= ruleCollectionLiteralPartCS )
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3443:1: (lv_ownedParts_4_0= ruleCollectionLiteralPartCS )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3444:3: lv_ownedParts_4_0= ruleCollectionLiteralPartCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedPartsCollectionLiteralPartCSParserRuleCall_2_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteralPartCS_in_ruleCollectionLiteralExpCS7934);
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
                    	    break loop56;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleCollectionLiteralExpCS7950); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3472:1: entryRuleCollectionLiteralPartCS returns [EObject current=null] : iv_ruleCollectionLiteralPartCS= ruleCollectionLiteralPartCS EOF ;
    public final EObject entryRuleCollectionLiteralPartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionLiteralPartCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3473:2: (iv_ruleCollectionLiteralPartCS= ruleCollectionLiteralPartCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3474:2: iv_ruleCollectionLiteralPartCS= ruleCollectionLiteralPartCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCollectionLiteralPartCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteralPartCS_in_entryRuleCollectionLiteralPartCS7986);
            iv_ruleCollectionLiteralPartCS=ruleCollectionLiteralPartCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCollectionLiteralPartCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCollectionLiteralPartCS7996); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3481:1: ruleCollectionLiteralPartCS returns [EObject current=null] : ( ( (lv_expressionCS_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_lastExpressionCS_2_0= ruleExpCS ) ) )? ) ;
    public final EObject ruleCollectionLiteralPartCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expressionCS_0_0 = null;

        EObject lv_lastExpressionCS_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3484:28: ( ( ( (lv_expressionCS_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_lastExpressionCS_2_0= ruleExpCS ) ) )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3485:1: ( ( (lv_expressionCS_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_lastExpressionCS_2_0= ruleExpCS ) ) )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3485:1: ( ( (lv_expressionCS_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_lastExpressionCS_2_0= ruleExpCS ) ) )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3485:2: ( (lv_expressionCS_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_lastExpressionCS_2_0= ruleExpCS ) ) )?
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3485:2: ( (lv_expressionCS_0_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3486:1: (lv_expressionCS_0_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3486:1: (lv_expressionCS_0_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3487:3: lv_expressionCS_0_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCollectionLiteralPartCSAccess().getExpressionCSExpCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleCollectionLiteralPartCS8042);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3503:2: (otherlv_1= '..' ( (lv_lastExpressionCS_2_0= ruleExpCS ) ) )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==71) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3503:4: otherlv_1= '..' ( (lv_lastExpressionCS_2_0= ruleExpCS ) )
                    {
                    otherlv_1=(Token)match(input,71,FollowSets000.FOLLOW_71_in_ruleCollectionLiteralPartCS8055); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getCollectionLiteralPartCSAccess().getFullStopFullStopKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3507:1: ( (lv_lastExpressionCS_2_0= ruleExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3508:1: (lv_lastExpressionCS_2_0= ruleExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3508:1: (lv_lastExpressionCS_2_0= ruleExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3509:3: lv_lastExpressionCS_2_0= ruleExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionLiteralPartCSAccess().getLastExpressionCSExpCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleCollectionLiteralPartCS8076);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3533:1: entryRuleConstructorPartCS returns [EObject current=null] : iv_ruleConstructorPartCS= ruleConstructorPartCS EOF ;
    public final EObject entryRuleConstructorPartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstructorPartCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3534:2: (iv_ruleConstructorPartCS= ruleConstructorPartCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3535:2: iv_ruleConstructorPartCS= ruleConstructorPartCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstructorPartCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleConstructorPartCS_in_entryRuleConstructorPartCS8114);
            iv_ruleConstructorPartCS=ruleConstructorPartCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConstructorPartCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleConstructorPartCS8124); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3542:1: ruleConstructorPartCS returns [EObject current=null] : ( ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( (lv_initExpression_2_0= ruleExpCS ) ) ) ;
    public final EObject ruleConstructorPartCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_initExpression_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3545:28: ( ( ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( (lv_initExpression_2_0= ruleExpCS ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3546:1: ( ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( (lv_initExpression_2_0= ruleExpCS ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3546:1: ( ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( (lv_initExpression_2_0= ruleExpCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3546:2: ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( (lv_initExpression_2_0= ruleExpCS ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3546:2: ( ( ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3547:1: ( ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3547:1: ( ruleUnrestrictedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3548:3: ruleUnrestrictedName
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
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleConstructorPartCS8176);
            ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,49,FollowSets000.FOLLOW_49_in_ruleConstructorPartCS8188); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getConstructorPartCSAccess().getEqualsSignKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3568:1: ( (lv_initExpression_2_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3569:1: (lv_initExpression_2_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3569:1: (lv_initExpression_2_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3570:3: lv_initExpression_2_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getConstructorPartCSAccess().getInitExpressionExpCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleConstructorPartCS8209);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3594:1: entryRulePrimitiveLiteralExpCS returns [EObject current=null] : iv_rulePrimitiveLiteralExpCS= rulePrimitiveLiteralExpCS EOF ;
    public final EObject entryRulePrimitiveLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3595:2: (iv_rulePrimitiveLiteralExpCS= rulePrimitiveLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3596:2: iv_rulePrimitiveLiteralExpCS= rulePrimitiveLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePrimitiveLiteralExpCS_in_entryRulePrimitiveLiteralExpCS8245);
            iv_rulePrimitiveLiteralExpCS=rulePrimitiveLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimitiveLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrimitiveLiteralExpCS8255); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3603:1: rulePrimitiveLiteralExpCS returns [EObject current=null] : (this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS | this_StringLiteralExpCS_1= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_5= ruleNullLiteralExpCS ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3606:28: ( (this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS | this_StringLiteralExpCS_1= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_5= ruleNullLiteralExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3607:1: (this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS | this_StringLiteralExpCS_1= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_5= ruleNullLiteralExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3607:1: (this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS | this_StringLiteralExpCS_1= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_5= ruleNullLiteralExpCS )
            int alt59=6;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt59=1;
                }
                break;
            case RULE_SINGLE_QUOTED_STRING:
                {
                alt59=2;
                }
                break;
            case 75:
            case 76:
                {
                alt59=3;
                }
                break;
            case 34:
                {
                alt59=4;
                }
                break;
            case 77:
                {
                alt59=5;
                }
                break;
            case 78:
                {
                alt59=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;
            }

            switch (alt59) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3608:2: this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getNumberLiteralExpCSParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNumberLiteralExpCS_in_rulePrimitiveLiteralExpCS8305);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3621:2: this_StringLiteralExpCS_1= ruleStringLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getStringLiteralExpCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleStringLiteralExpCS_in_rulePrimitiveLiteralExpCS8335);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3634:2: this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getBooleanLiteralExpCSParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleBooleanLiteralExpCS_in_rulePrimitiveLiteralExpCS8365);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3647:2: this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getUnlimitedNaturalLiteralExpCSParserRuleCall_3()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUnlimitedNaturalLiteralExpCS_in_rulePrimitiveLiteralExpCS8395);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3660:2: this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getInvalidLiteralExpCSParserRuleCall_4()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleInvalidLiteralExpCS_in_rulePrimitiveLiteralExpCS8425);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3673:2: this_NullLiteralExpCS_5= ruleNullLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getNullLiteralExpCSParserRuleCall_5()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNullLiteralExpCS_in_rulePrimitiveLiteralExpCS8455);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3692:1: entryRuleTupleLiteralExpCS returns [EObject current=null] : iv_ruleTupleLiteralExpCS= ruleTupleLiteralExpCS EOF ;
    public final EObject entryRuleTupleLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTupleLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3693:2: (iv_ruleTupleLiteralExpCS= ruleTupleLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3694:2: iv_ruleTupleLiteralExpCS= ruleTupleLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTupleLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralExpCS_in_entryRuleTupleLiteralExpCS8490);
            iv_ruleTupleLiteralExpCS=ruleTupleLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTupleLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTupleLiteralExpCS8500); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3701:1: ruleTupleLiteralExpCS returns [EObject current=null] : (otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}' ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3704:28: ( (otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3705:1: (otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3705:1: (otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3705:3: otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,57,FollowSets000.FOLLOW_57_in_ruleTupleLiteralExpCS8537); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getTupleLiteralExpCSAccess().getTupleKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleTupleLiteralExpCS8549); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getTupleLiteralExpCSAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3713:1: ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3714:1: (lv_ownedParts_2_0= ruleTupleLiteralPartCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3714:1: (lv_ownedParts_2_0= ruleTupleLiteralPartCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3715:3: lv_ownedParts_2_0= ruleTupleLiteralPartCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTupleLiteralExpCSAccess().getOwnedPartsTupleLiteralPartCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralPartCS_in_ruleTupleLiteralExpCS8570);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3731:2: (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==19) ) {
                    alt60=1;
                }


                switch (alt60) {
            	case 1 :
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3731:4: otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) )
            	    {
            	    otherlv_3=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleTupleLiteralExpCS8583); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getTupleLiteralExpCSAccess().getCommaKeyword_3_0());
            	          
            	    }
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3735:1: ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3736:1: (lv_ownedParts_4_0= ruleTupleLiteralPartCS )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3736:1: (lv_ownedParts_4_0= ruleTupleLiteralPartCS )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3737:3: lv_ownedParts_4_0= ruleTupleLiteralPartCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTupleLiteralExpCSAccess().getOwnedPartsTupleLiteralPartCSParserRuleCall_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralPartCS_in_ruleTupleLiteralExpCS8604);
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
            	    break loop60;
                }
            } while (true);

            otherlv_5=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleTupleLiteralExpCS8618); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3765:1: entryRuleTupleLiteralPartCS returns [EObject current=null] : iv_ruleTupleLiteralPartCS= ruleTupleLiteralPartCS EOF ;
    public final EObject entryRuleTupleLiteralPartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTupleLiteralPartCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3766:2: (iv_ruleTupleLiteralPartCS= ruleTupleLiteralPartCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3767:2: iv_ruleTupleLiteralPartCS= ruleTupleLiteralPartCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTupleLiteralPartCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralPartCS_in_entryRuleTupleLiteralPartCS8654);
            iv_ruleTupleLiteralPartCS=ruleTupleLiteralPartCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTupleLiteralPartCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTupleLiteralPartCS8664); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3774:1: ruleTupleLiteralPartCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) ) ) ;
    public final EObject ruleTupleLiteralPartCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;

        EObject lv_initExpression_4_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3777:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3778:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3778:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3778:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3778:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3779:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3779:1: (lv_name_0_0= ruleUnrestrictedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3780:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTupleLiteralPartCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleTupleLiteralPartCS8710);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3796:2: (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==32) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3796:4: otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                    {
                    otherlv_1=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleTupleLiteralPartCS8723); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getTupleLiteralPartCSAccess().getColonKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3800:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3801:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3801:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3802:3: lv_ownedType_2_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTupleLiteralPartCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleTupleLiteralPartCS8744);
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

            otherlv_3=(Token)match(input,49,FollowSets000.FOLLOW_49_in_ruleTupleLiteralPartCS8758); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getTupleLiteralPartCSAccess().getEqualsSignKeyword_2());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3822:1: ( (lv_initExpression_4_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3823:1: (lv_initExpression_4_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3823:1: (lv_initExpression_4_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3824:3: lv_initExpression_4_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTupleLiteralPartCSAccess().getInitExpressionExpCSParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleTupleLiteralPartCS8779);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3848:1: entryRuleNumberLiteralExpCS returns [EObject current=null] : iv_ruleNumberLiteralExpCS= ruleNumberLiteralExpCS EOF ;
    public final EObject entryRuleNumberLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3849:2: (iv_ruleNumberLiteralExpCS= ruleNumberLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3850:2: iv_ruleNumberLiteralExpCS= ruleNumberLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumberLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNumberLiteralExpCS_in_entryRuleNumberLiteralExpCS8815);
            iv_ruleNumberLiteralExpCS=ruleNumberLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumberLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNumberLiteralExpCS8825); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3857:1: ruleNumberLiteralExpCS returns [EObject current=null] : ( (lv_name_0_0= ruleNUMBER_LITERAL ) ) ;
    public final EObject ruleNumberLiteralExpCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3860:28: ( ( (lv_name_0_0= ruleNUMBER_LITERAL ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3861:1: ( (lv_name_0_0= ruleNUMBER_LITERAL ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3861:1: ( (lv_name_0_0= ruleNUMBER_LITERAL ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3862:1: (lv_name_0_0= ruleNUMBER_LITERAL )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3862:1: (lv_name_0_0= ruleNUMBER_LITERAL )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3863:3: lv_name_0_0= ruleNUMBER_LITERAL
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNumberLiteralExpCSAccess().getNameNUMBER_LITERALParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleNUMBER_LITERAL_in_ruleNumberLiteralExpCS8870);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3887:1: entryRuleStringLiteralExpCS returns [EObject current=null] : iv_ruleStringLiteralExpCS= ruleStringLiteralExpCS EOF ;
    public final EObject entryRuleStringLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3888:2: (iv_ruleStringLiteralExpCS= ruleStringLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3889:2: iv_ruleStringLiteralExpCS= ruleStringLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStringLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleStringLiteralExpCS_in_entryRuleStringLiteralExpCS8905);
            iv_ruleStringLiteralExpCS=ruleStringLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStringLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleStringLiteralExpCS8915); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3896:1: ruleStringLiteralExpCS returns [EObject current=null] : ( (lv_name_0_0= ruleStringLiteral ) )+ ;
    public final EObject ruleStringLiteralExpCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3899:28: ( ( (lv_name_0_0= ruleStringLiteral ) )+ )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3900:1: ( (lv_name_0_0= ruleStringLiteral ) )+
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3900:1: ( (lv_name_0_0= ruleStringLiteral ) )+
            int cnt62=0;
            loop62:
            do {
                int alt62=2;
                int LA62_0 = input.LA(1);

                if ( (LA62_0==RULE_SINGLE_QUOTED_STRING) ) {
                    alt62=1;
                }


                switch (alt62) {
            	case 1 :
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3901:1: (lv_name_0_0= ruleStringLiteral )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3901:1: (lv_name_0_0= ruleStringLiteral )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3902:3: lv_name_0_0= ruleStringLiteral
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getStringLiteralExpCSAccess().getNameStringLiteralParserRuleCall_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleStringLiteral_in_ruleStringLiteralExpCS8960);
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
            	    if ( cnt62 >= 1 ) break loop62;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(62, input);
                        throw eee;
                }
                cnt62++;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3926:1: entryRuleBooleanLiteralExpCS returns [EObject current=null] : iv_ruleBooleanLiteralExpCS= ruleBooleanLiteralExpCS EOF ;
    public final EObject entryRuleBooleanLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3927:2: (iv_ruleBooleanLiteralExpCS= ruleBooleanLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3928:2: iv_ruleBooleanLiteralExpCS= ruleBooleanLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBooleanLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleBooleanLiteralExpCS_in_entryRuleBooleanLiteralExpCS8996);
            iv_ruleBooleanLiteralExpCS=ruleBooleanLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBooleanLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBooleanLiteralExpCS9006); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3935:1: ruleBooleanLiteralExpCS returns [EObject current=null] : ( ( (lv_name_0_0= 'true' ) ) | ( (lv_name_1_0= 'false' ) ) ) ;
    public final EObject ruleBooleanLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3938:28: ( ( ( (lv_name_0_0= 'true' ) ) | ( (lv_name_1_0= 'false' ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3939:1: ( ( (lv_name_0_0= 'true' ) ) | ( (lv_name_1_0= 'false' ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3939:1: ( ( (lv_name_0_0= 'true' ) ) | ( (lv_name_1_0= 'false' ) ) )
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==75) ) {
                alt63=1;
            }
            else if ( (LA63_0==76) ) {
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3939:2: ( (lv_name_0_0= 'true' ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3939:2: ( (lv_name_0_0= 'true' ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3940:1: (lv_name_0_0= 'true' )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3940:1: (lv_name_0_0= 'true' )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3941:3: lv_name_0_0= 'true'
                    {
                    lv_name_0_0=(Token)match(input,75,FollowSets000.FOLLOW_75_in_ruleBooleanLiteralExpCS9049); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3955:6: ( (lv_name_1_0= 'false' ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3955:6: ( (lv_name_1_0= 'false' ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3956:1: (lv_name_1_0= 'false' )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3956:1: (lv_name_1_0= 'false' )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3957:3: lv_name_1_0= 'false'
                    {
                    lv_name_1_0=(Token)match(input,76,FollowSets000.FOLLOW_76_in_ruleBooleanLiteralExpCS9086); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3978:1: entryRuleUnlimitedNaturalLiteralExpCS returns [EObject current=null] : iv_ruleUnlimitedNaturalLiteralExpCS= ruleUnlimitedNaturalLiteralExpCS EOF ;
    public final EObject entryRuleUnlimitedNaturalLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnlimitedNaturalLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3979:2: (iv_ruleUnlimitedNaturalLiteralExpCS= ruleUnlimitedNaturalLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3980:2: iv_ruleUnlimitedNaturalLiteralExpCS= ruleUnlimitedNaturalLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnlimitedNaturalLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnlimitedNaturalLiteralExpCS_in_entryRuleUnlimitedNaturalLiteralExpCS9135);
            iv_ruleUnlimitedNaturalLiteralExpCS=ruleUnlimitedNaturalLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnlimitedNaturalLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnlimitedNaturalLiteralExpCS9145); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3987:1: ruleUnlimitedNaturalLiteralExpCS returns [EObject current=null] : ( () otherlv_1= '*' ) ;
    public final EObject ruleUnlimitedNaturalLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3990:28: ( ( () otherlv_1= '*' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3991:1: ( () otherlv_1= '*' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3991:1: ( () otherlv_1= '*' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3991:2: () otherlv_1= '*'
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3991:2: ()
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3992:2: 
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

            otherlv_1=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleUnlimitedNaturalLiteralExpCS9194); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4012:1: entryRuleInvalidLiteralExpCS returns [EObject current=null] : iv_ruleInvalidLiteralExpCS= ruleInvalidLiteralExpCS EOF ;
    public final EObject entryRuleInvalidLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInvalidLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4013:2: (iv_ruleInvalidLiteralExpCS= ruleInvalidLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4014:2: iv_ruleInvalidLiteralExpCS= ruleInvalidLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInvalidLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleInvalidLiteralExpCS_in_entryRuleInvalidLiteralExpCS9230);
            iv_ruleInvalidLiteralExpCS=ruleInvalidLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInvalidLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleInvalidLiteralExpCS9240); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4021:1: ruleInvalidLiteralExpCS returns [EObject current=null] : ( () otherlv_1= 'invalid' ) ;
    public final EObject ruleInvalidLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4024:28: ( ( () otherlv_1= 'invalid' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4025:1: ( () otherlv_1= 'invalid' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4025:1: ( () otherlv_1= 'invalid' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4025:2: () otherlv_1= 'invalid'
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4025:2: ()
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4026:2: 
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

            otherlv_1=(Token)match(input,77,FollowSets000.FOLLOW_77_in_ruleInvalidLiteralExpCS9289); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4046:1: entryRuleNullLiteralExpCS returns [EObject current=null] : iv_ruleNullLiteralExpCS= ruleNullLiteralExpCS EOF ;
    public final EObject entryRuleNullLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4047:2: (iv_ruleNullLiteralExpCS= ruleNullLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4048:2: iv_ruleNullLiteralExpCS= ruleNullLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNullLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNullLiteralExpCS_in_entryRuleNullLiteralExpCS9325);
            iv_ruleNullLiteralExpCS=ruleNullLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNullLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNullLiteralExpCS9335); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4055:1: ruleNullLiteralExpCS returns [EObject current=null] : ( () otherlv_1= 'null' ) ;
    public final EObject ruleNullLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4058:28: ( ( () otherlv_1= 'null' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4059:1: ( () otherlv_1= 'null' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4059:1: ( () otherlv_1= 'null' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4059:2: () otherlv_1= 'null'
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4059:2: ()
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4060:2: 
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

            otherlv_1=(Token)match(input,78,FollowSets000.FOLLOW_78_in_ruleNullLiteralExpCS9384); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4080:1: entryRuleTypeLiteralCS returns [EObject current=null] : iv_ruleTypeLiteralCS= ruleTypeLiteralCS EOF ;
    public final EObject entryRuleTypeLiteralCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeLiteralCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4081:2: (iv_ruleTypeLiteralCS= ruleTypeLiteralCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4082:2: iv_ruleTypeLiteralCS= ruleTypeLiteralCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeLiteralCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralCS_in_entryRuleTypeLiteralCS9420);
            iv_ruleTypeLiteralCS=ruleTypeLiteralCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeLiteralCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeLiteralCS9430); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4089:1: ruleTypeLiteralCS returns [EObject current=null] : (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS | this_CollectionTypeCS_1= ruleCollectionTypeCS | this_TupleTypeCS_2= ruleTupleTypeCS ) ;
    public final EObject ruleTypeLiteralCS() throws RecognitionException {
        EObject current = null;

        EObject this_PrimitiveTypeCS_0 = null;

        EObject this_CollectionTypeCS_1 = null;

        EObject this_TupleTypeCS_2 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4092:28: ( (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS | this_CollectionTypeCS_1= ruleCollectionTypeCS | this_TupleTypeCS_2= ruleTupleTypeCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4093:1: (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS | this_CollectionTypeCS_1= ruleCollectionTypeCS | this_TupleTypeCS_2= ruleTupleTypeCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4093:1: (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS | this_CollectionTypeCS_1= ruleCollectionTypeCS | this_TupleTypeCS_2= ruleTupleTypeCS )
            int alt64=3;
            switch ( input.LA(1) ) {
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
                {
                alt64=1;
                }
                break;
            case 66:
            case 67:
            case 68:
            case 69:
            case 70:
                {
                alt64=2;
                }
                break;
            case 57:
                {
                alt64=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;
            }

            switch (alt64) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4094:2: this_PrimitiveTypeCS_0= rulePrimitiveTypeCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeLiteralCSAccess().getPrimitiveTypeCSParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrimitiveTypeCS_in_ruleTypeLiteralCS9480);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4107:2: this_CollectionTypeCS_1= ruleCollectionTypeCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeLiteralCSAccess().getCollectionTypeCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCollectionTypeCS_in_ruleTypeLiteralCS9510);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4120:2: this_TupleTypeCS_2= ruleTupleTypeCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeLiteralCSAccess().getTupleTypeCSParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTupleTypeCS_in_ruleTypeLiteralCS9540);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4139:1: entryRuleTypeLiteralWithMultiplicityCS returns [EObject current=null] : iv_ruleTypeLiteralWithMultiplicityCS= ruleTypeLiteralWithMultiplicityCS EOF ;
    public final EObject entryRuleTypeLiteralWithMultiplicityCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeLiteralWithMultiplicityCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4140:2: (iv_ruleTypeLiteralWithMultiplicityCS= ruleTypeLiteralWithMultiplicityCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4141:2: iv_ruleTypeLiteralWithMultiplicityCS= ruleTypeLiteralWithMultiplicityCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeLiteralWithMultiplicityCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralWithMultiplicityCS_in_entryRuleTypeLiteralWithMultiplicityCS9575);
            iv_ruleTypeLiteralWithMultiplicityCS=ruleTypeLiteralWithMultiplicityCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeLiteralWithMultiplicityCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeLiteralWithMultiplicityCS9585); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4148:1: ruleTypeLiteralWithMultiplicityCS returns [EObject current=null] : (this_TypeLiteralCS_0= ruleTypeLiteralCS ( (lv_multiplicity_1_0= ruleMultiplicityCS ) )? ) ;
    public final EObject ruleTypeLiteralWithMultiplicityCS() throws RecognitionException {
        EObject current = null;

        EObject this_TypeLiteralCS_0 = null;

        EObject lv_multiplicity_1_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4151:28: ( (this_TypeLiteralCS_0= ruleTypeLiteralCS ( (lv_multiplicity_1_0= ruleMultiplicityCS ) )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4152:1: (this_TypeLiteralCS_0= ruleTypeLiteralCS ( (lv_multiplicity_1_0= ruleMultiplicityCS ) )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4152:1: (this_TypeLiteralCS_0= ruleTypeLiteralCS ( (lv_multiplicity_1_0= ruleMultiplicityCS ) )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4153:2: this_TypeLiteralCS_0= ruleTypeLiteralCS ( (lv_multiplicity_1_0= ruleMultiplicityCS ) )?
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getTypeLiteralWithMultiplicityCSAccess().getTypeLiteralCSParserRuleCall_0()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralCS_in_ruleTypeLiteralWithMultiplicityCS9635);
            this_TypeLiteralCS_0=ruleTypeLiteralCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_TypeLiteralCS_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4164:1: ( (lv_multiplicity_1_0= ruleMultiplicityCS ) )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==72) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4165:1: (lv_multiplicity_1_0= ruleMultiplicityCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4165:1: (lv_multiplicity_1_0= ruleMultiplicityCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4166:3: lv_multiplicity_1_0= ruleMultiplicityCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeLiteralWithMultiplicityCSAccess().getMultiplicityMultiplicityCSParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMultiplicityCS_in_ruleTypeLiteralWithMultiplicityCS9655);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4190:1: entryRuleTypeLiteralExpCS returns [EObject current=null] : iv_ruleTypeLiteralExpCS= ruleTypeLiteralExpCS EOF ;
    public final EObject entryRuleTypeLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4191:2: (iv_ruleTypeLiteralExpCS= ruleTypeLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4192:2: iv_ruleTypeLiteralExpCS= ruleTypeLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralExpCS_in_entryRuleTypeLiteralExpCS9692);
            iv_ruleTypeLiteralExpCS=ruleTypeLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeLiteralExpCS9702); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4199:1: ruleTypeLiteralExpCS returns [EObject current=null] : ( (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS ) ) ;
    public final EObject ruleTypeLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject lv_ownedType_0_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4202:28: ( ( (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4203:1: ( (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4203:1: ( (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4204:1: (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4204:1: (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4205:3: lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypeLiteralExpCSAccess().getOwnedTypeTypeLiteralWithMultiplicityCSParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralWithMultiplicityCS_in_ruleTypeLiteralExpCS9747);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4229:1: entryRuleTypeNameExpCS returns [EObject current=null] : iv_ruleTypeNameExpCS= ruleTypeNameExpCS EOF ;
    public final EObject entryRuleTypeNameExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeNameExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4230:2: (iv_ruleTypeNameExpCS= ruleTypeNameExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4231:2: iv_ruleTypeNameExpCS= ruleTypeNameExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeNameExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeNameExpCS_in_entryRuleTypeNameExpCS9782);
            iv_ruleTypeNameExpCS=ruleTypeNameExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeNameExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeNameExpCS9792); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4238:1: ruleTypeNameExpCS returns [EObject current=null] : ( (lv_pathName_0_0= rulePathNameCS ) ) ;
    public final EObject ruleTypeNameExpCS() throws RecognitionException {
        EObject current = null;

        EObject lv_pathName_0_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4241:28: ( ( (lv_pathName_0_0= rulePathNameCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4242:1: ( (lv_pathName_0_0= rulePathNameCS ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4242:1: ( (lv_pathName_0_0= rulePathNameCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4243:1: (lv_pathName_0_0= rulePathNameCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4243:1: (lv_pathName_0_0= rulePathNameCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4244:3: lv_pathName_0_0= rulePathNameCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypeNameExpCSAccess().getPathNamePathNameCSParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_rulePathNameCS_in_ruleTypeNameExpCS9837);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4268:1: entryRuleTypeExpCS returns [EObject current=null] : iv_ruleTypeExpCS= ruleTypeExpCS EOF ;
    public final EObject entryRuleTypeExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4269:2: (iv_ruleTypeExpCS= ruleTypeExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4270:2: iv_ruleTypeExpCS= ruleTypeExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_entryRuleTypeExpCS9872);
            iv_ruleTypeExpCS=ruleTypeExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeExpCS9882); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4277:1: ruleTypeExpCS returns [EObject current=null] : ( (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS ) ( (lv_multiplicity_2_0= ruleMultiplicityCS ) )? ) ;
    public final EObject ruleTypeExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_TypeNameExpCS_0 = null;

        EObject this_TypeLiteralCS_1 = null;

        EObject lv_multiplicity_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4280:28: ( ( (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS ) ( (lv_multiplicity_2_0= ruleMultiplicityCS ) )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4281:1: ( (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS ) ( (lv_multiplicity_2_0= ruleMultiplicityCS ) )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4281:1: ( (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS ) ( (lv_multiplicity_2_0= ruleMultiplicityCS ) )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4281:2: (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS ) ( (lv_multiplicity_2_0= ruleMultiplicityCS ) )?
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4281:2: (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS )
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( ((LA66_0>=RULE_SIMPLE_ID && LA66_0<=RULE_ESCAPED_ID)||LA66_0==16||LA66_0==18||(LA66_0>=27 && LA66_0<=28)||LA66_0==31||(LA66_0>=35 && LA66_0<=40)) ) {
                alt66=1;
            }
            else if ( ((LA66_0>=57 && LA66_0<=70)) ) {
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4282:2: this_TypeNameExpCS_0= ruleTypeNameExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeExpCSAccess().getTypeNameExpCSParserRuleCall_0_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeNameExpCS_in_ruleTypeExpCS9933);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4295:2: this_TypeLiteralCS_1= ruleTypeLiteralCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeExpCSAccess().getTypeLiteralCSParserRuleCall_0_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralCS_in_ruleTypeExpCS9963);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4306:2: ( (lv_multiplicity_2_0= ruleMultiplicityCS ) )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==72) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4307:1: (lv_multiplicity_2_0= ruleMultiplicityCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4307:1: (lv_multiplicity_2_0= ruleMultiplicityCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4308:3: lv_multiplicity_2_0= ruleMultiplicityCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeExpCSAccess().getMultiplicityMultiplicityCSParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMultiplicityCS_in_ruleTypeExpCS9984);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4332:1: entryRuleExpCS returns [EObject current=null] : iv_ruleExpCS= ruleExpCS EOF ;
    public final EObject entryRuleExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4333:2: (iv_ruleExpCS= ruleExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4334:2: iv_ruleExpCS= ruleExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_entryRuleExpCS10021);
            iv_ruleExpCS=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleExpCS10031); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4341:1: ruleExpCS returns [EObject current=null] : ( (this_PrefixedExpCS_0= rulePrefixedExpCS ( () ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? ) | ( (lv_ownedExpression_8_0= ruleLetExpCS ) ) ) )? ) | ( () ( (lv_ownedOperator_10_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_11_0= ruleLetExpCS ) ) ) | this_LetExpCS_12= ruleLetExpCS ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4344:28: ( ( (this_PrefixedExpCS_0= rulePrefixedExpCS ( () ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? ) | ( (lv_ownedExpression_8_0= ruleLetExpCS ) ) ) )? ) | ( () ( (lv_ownedOperator_10_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_11_0= ruleLetExpCS ) ) ) | this_LetExpCS_12= ruleLetExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4345:1: ( (this_PrefixedExpCS_0= rulePrefixedExpCS ( () ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? ) | ( (lv_ownedExpression_8_0= ruleLetExpCS ) ) ) )? ) | ( () ( (lv_ownedOperator_10_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_11_0= ruleLetExpCS ) ) ) | this_LetExpCS_12= ruleLetExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4345:1: ( (this_PrefixedExpCS_0= rulePrefixedExpCS ( () ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? ) | ( (lv_ownedExpression_8_0= ruleLetExpCS ) ) ) )? ) | ( () ( (lv_ownedOperator_10_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_11_0= ruleLetExpCS ) ) ) | this_LetExpCS_12= ruleLetExpCS )
            int alt73=3;
            alt73 = dfa73.predict(input);
            switch (alt73) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4345:2: (this_PrefixedExpCS_0= rulePrefixedExpCS ( () ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? ) | ( (lv_ownedExpression_8_0= ruleLetExpCS ) ) ) )? )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4345:2: (this_PrefixedExpCS_0= rulePrefixedExpCS ( () ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? ) | ( (lv_ownedExpression_8_0= ruleLetExpCS ) ) ) )? )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4346:2: this_PrefixedExpCS_0= rulePrefixedExpCS ( () ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? ) | ( (lv_ownedExpression_8_0= ruleLetExpCS ) ) ) )?
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getExpCSAccess().getPrefixedExpCSParserRuleCall_0_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrefixedExpCS_in_ruleExpCS10082);
                    this_PrefixedExpCS_0=rulePrefixedExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_PrefixedExpCS_0; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4357:1: ( () ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? ) | ( (lv_ownedExpression_8_0= ruleLetExpCS ) ) ) )?
                    int alt71=2;
                    int LA71_0 = input.LA(1);

                    if ( (LA71_0==34||LA71_0==41||(LA71_0>=43 && LA71_0<=56)) ) {
                        alt71=1;
                    }
                    switch (alt71) {
                        case 1 :
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4357:2: () ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? ) | ( (lv_ownedExpression_8_0= ruleLetExpCS ) ) )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4357:2: ()
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4358:2: 
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

                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4366:2: ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4367:1: (lv_ownedOperator_2_0= ruleBinaryOperatorCS )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4367:1: (lv_ownedOperator_2_0= ruleBinaryOperatorCS )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4368:3: lv_ownedOperator_2_0= ruleBinaryOperatorCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getExpCSAccess().getOwnedOperatorBinaryOperatorCSParserRuleCall_0_1_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleBinaryOperatorCS_in_ruleExpCS10115);
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

                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4384:2: ( ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? ) | ( (lv_ownedExpression_8_0= ruleLetExpCS ) ) )
                            int alt70=2;
                            int LA70_0 = input.LA(1);

                            if ( ((LA70_0>=RULE_SIMPLE_ID && LA70_0<=RULE_SINGLE_QUOTED_STRING)||LA70_0==16||LA70_0==18||(LA70_0>=27 && LA70_0<=29)||LA70_0==31||(LA70_0>=34 && LA70_0<=42)||(LA70_0>=57 && LA70_0<=70)||(LA70_0>=75 && LA70_0<=78)||LA70_0==81||LA70_0==86) ) {
                                alt70=1;
                            }
                            else if ( (LA70_0==85) ) {
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
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4384:3: ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? )
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4384:3: ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4384:4: ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )?
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4384:4: ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4385:1: (lv_ownedExpression_3_0= rulePrefixedExpCS )
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4385:1: (lv_ownedExpression_3_0= rulePrefixedExpCS )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4386:3: lv_ownedExpression_3_0= rulePrefixedExpCS
                                    {
                                    if ( state.backtracking==0 ) {
                                       
                                      	        newCompositeNode(grammarAccess.getExpCSAccess().getOwnedExpressionPrefixedExpCSParserRuleCall_0_1_2_0_0_0()); 
                                      	    
                                    }
                                    pushFollow(FollowSets000.FOLLOW_rulePrefixedExpCS_in_ruleExpCS10138);
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

                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4402:2: ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )*
                                    loop68:
                                    do {
                                        int alt68=2;
                                        alt68 = dfa68.predict(input);
                                        switch (alt68) {
                                    	case 1 :
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4402:3: ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) )
                                    	    {
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4402:3: ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) )
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4403:1: (lv_ownedOperator_4_0= ruleBinaryOperatorCS )
                                    	    {
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4403:1: (lv_ownedOperator_4_0= ruleBinaryOperatorCS )
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4404:3: lv_ownedOperator_4_0= ruleBinaryOperatorCS
                                    	    {
                                    	    if ( state.backtracking==0 ) {
                                    	       
                                    	      	        newCompositeNode(grammarAccess.getExpCSAccess().getOwnedOperatorBinaryOperatorCSParserRuleCall_0_1_2_0_1_0_0()); 
                                    	      	    
                                    	    }
                                    	    pushFollow(FollowSets000.FOLLOW_ruleBinaryOperatorCS_in_ruleExpCS10160);
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

                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4420:2: ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) )
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4421:1: (lv_ownedExpression_5_0= rulePrefixedExpCS )
                                    	    {
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4421:1: (lv_ownedExpression_5_0= rulePrefixedExpCS )
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4422:3: lv_ownedExpression_5_0= rulePrefixedExpCS
                                    	    {
                                    	    if ( state.backtracking==0 ) {
                                    	       
                                    	      	        newCompositeNode(grammarAccess.getExpCSAccess().getOwnedExpressionPrefixedExpCSParserRuleCall_0_1_2_0_1_1_0()); 
                                    	      	    
                                    	    }
                                    	    pushFollow(FollowSets000.FOLLOW_rulePrefixedExpCS_in_ruleExpCS10181);
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
                                    	    break loop68;
                                        }
                                    } while (true);

                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4438:4: ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )?
                                    int alt69=2;
                                    int LA69_0 = input.LA(1);

                                    if ( (LA69_0==34||LA69_0==41||(LA69_0>=43 && LA69_0<=56)) ) {
                                        alt69=1;
                                    }
                                    switch (alt69) {
                                        case 1 :
                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4438:5: ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) )
                                            {
                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4438:5: ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) )
                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4439:1: (lv_ownedOperator_6_0= ruleBinaryOperatorCS )
                                            {
                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4439:1: (lv_ownedOperator_6_0= ruleBinaryOperatorCS )
                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4440:3: lv_ownedOperator_6_0= ruleBinaryOperatorCS
                                            {
                                            if ( state.backtracking==0 ) {
                                               
                                              	        newCompositeNode(grammarAccess.getExpCSAccess().getOwnedOperatorBinaryOperatorCSParserRuleCall_0_1_2_0_2_0_0()); 
                                              	    
                                            }
                                            pushFollow(FollowSets000.FOLLOW_ruleBinaryOperatorCS_in_ruleExpCS10205);
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

                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4456:2: ( (lv_ownedExpression_7_0= ruleLetExpCS ) )
                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4457:1: (lv_ownedExpression_7_0= ruleLetExpCS )
                                            {
                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4457:1: (lv_ownedExpression_7_0= ruleLetExpCS )
                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4458:3: lv_ownedExpression_7_0= ruleLetExpCS
                                            {
                                            if ( state.backtracking==0 ) {
                                               
                                              	        newCompositeNode(grammarAccess.getExpCSAccess().getOwnedExpressionLetExpCSParserRuleCall_0_1_2_0_2_1_0()); 
                                              	    
                                            }
                                            pushFollow(FollowSets000.FOLLOW_ruleLetExpCS_in_ruleExpCS10226);
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
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4475:6: ( (lv_ownedExpression_8_0= ruleLetExpCS ) )
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4475:6: ( (lv_ownedExpression_8_0= ruleLetExpCS ) )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4476:1: (lv_ownedExpression_8_0= ruleLetExpCS )
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4476:1: (lv_ownedExpression_8_0= ruleLetExpCS )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4477:3: lv_ownedExpression_8_0= ruleLetExpCS
                                    {
                                    if ( state.backtracking==0 ) {
                                       
                                      	        newCompositeNode(grammarAccess.getExpCSAccess().getOwnedExpressionLetExpCSParserRuleCall_0_1_2_1_0()); 
                                      	    
                                    }
                                    pushFollow(FollowSets000.FOLLOW_ruleLetExpCS_in_ruleExpCS10256);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4494:6: ( () ( (lv_ownedOperator_10_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_11_0= ruleLetExpCS ) ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4494:6: ( () ( (lv_ownedOperator_10_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_11_0= ruleLetExpCS ) ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4494:7: () ( (lv_ownedOperator_10_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_11_0= ruleLetExpCS ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4494:7: ()
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4495:2: 
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

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4503:2: ( (lv_ownedOperator_10_0= ruleUnaryOperatorCS ) )+
                    int cnt72=0;
                    loop72:
                    do {
                        int alt72=2;
                        int LA72_0 = input.LA(1);

                        if ( ((LA72_0>=41 && LA72_0<=42)) ) {
                            alt72=1;
                        }


                        switch (alt72) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4504:1: (lv_ownedOperator_10_0= ruleUnaryOperatorCS )
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4504:1: (lv_ownedOperator_10_0= ruleUnaryOperatorCS )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4505:3: lv_ownedOperator_10_0= ruleUnaryOperatorCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getExpCSAccess().getOwnedOperatorUnaryOperatorCSParserRuleCall_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleUnaryOperatorCS_in_ruleExpCS10300);
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
                    	    if ( cnt72 >= 1 ) break loop72;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(72, input);
                                throw eee;
                        }
                        cnt72++;
                    } while (true);

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4521:3: ( (lv_ownedExpression_11_0= ruleLetExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4522:1: (lv_ownedExpression_11_0= ruleLetExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4522:1: (lv_ownedExpression_11_0= ruleLetExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4523:3: lv_ownedExpression_11_0= ruleLetExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpCSAccess().getOwnedExpressionLetExpCSParserRuleCall_1_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLetExpCS_in_ruleExpCS10322);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4541:2: this_LetExpCS_12= ruleLetExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getExpCSAccess().getLetExpCSParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLetExpCS_in_ruleExpCS10354);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4560:1: entryRulePrefixedExpCS returns [EObject current=null] : iv_rulePrefixedExpCS= rulePrefixedExpCS EOF ;
    public final EObject entryRulePrefixedExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrefixedExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4561:2: (iv_rulePrefixedExpCS= rulePrefixedExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4562:2: iv_rulePrefixedExpCS= rulePrefixedExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrefixedExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePrefixedExpCS_in_entryRulePrefixedExpCS10389);
            iv_rulePrefixedExpCS=rulePrefixedExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrefixedExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrefixedExpCS10399); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4569:1: rulePrefixedExpCS returns [EObject current=null] : ( ( () ( (lv_ownedOperator_1_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_2_0= rulePrimaryExpCS ) ) ) | this_PrimaryExpCS_3= rulePrimaryExpCS ) ;
    public final EObject rulePrefixedExpCS() throws RecognitionException {
        EObject current = null;

        EObject lv_ownedOperator_1_0 = null;

        EObject lv_ownedExpression_2_0 = null;

        EObject this_PrimaryExpCS_3 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4572:28: ( ( ( () ( (lv_ownedOperator_1_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_2_0= rulePrimaryExpCS ) ) ) | this_PrimaryExpCS_3= rulePrimaryExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4573:1: ( ( () ( (lv_ownedOperator_1_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_2_0= rulePrimaryExpCS ) ) ) | this_PrimaryExpCS_3= rulePrimaryExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4573:1: ( ( () ( (lv_ownedOperator_1_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_2_0= rulePrimaryExpCS ) ) ) | this_PrimaryExpCS_3= rulePrimaryExpCS )
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( ((LA75_0>=41 && LA75_0<=42)) ) {
                alt75=1;
            }
            else if ( ((LA75_0>=RULE_SIMPLE_ID && LA75_0<=RULE_SINGLE_QUOTED_STRING)||LA75_0==16||LA75_0==18||(LA75_0>=27 && LA75_0<=29)||LA75_0==31||(LA75_0>=34 && LA75_0<=40)||(LA75_0>=57 && LA75_0<=70)||(LA75_0>=75 && LA75_0<=78)||LA75_0==81||LA75_0==86) ) {
                alt75=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 75, 0, input);

                throw nvae;
            }
            switch (alt75) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4573:2: ( () ( (lv_ownedOperator_1_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_2_0= rulePrimaryExpCS ) ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4573:2: ( () ( (lv_ownedOperator_1_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_2_0= rulePrimaryExpCS ) ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4573:3: () ( (lv_ownedOperator_1_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_2_0= rulePrimaryExpCS ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4573:3: ()
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4574:2: 
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

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4582:2: ( (lv_ownedOperator_1_0= ruleUnaryOperatorCS ) )+
                    int cnt74=0;
                    loop74:
                    do {
                        int alt74=2;
                        int LA74_0 = input.LA(1);

                        if ( ((LA74_0>=41 && LA74_0<=42)) ) {
                            alt74=1;
                        }


                        switch (alt74) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4583:1: (lv_ownedOperator_1_0= ruleUnaryOperatorCS )
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4583:1: (lv_ownedOperator_1_0= ruleUnaryOperatorCS )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4584:3: lv_ownedOperator_1_0= ruleUnaryOperatorCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getPrefixedExpCSAccess().getOwnedOperatorUnaryOperatorCSParserRuleCall_0_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleUnaryOperatorCS_in_rulePrefixedExpCS10458);
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
                    	    if ( cnt74 >= 1 ) break loop74;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(74, input);
                                throw eee;
                        }
                        cnt74++;
                    } while (true);

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4600:3: ( (lv_ownedExpression_2_0= rulePrimaryExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4601:1: (lv_ownedExpression_2_0= rulePrimaryExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4601:1: (lv_ownedExpression_2_0= rulePrimaryExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4602:3: lv_ownedExpression_2_0= rulePrimaryExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrefixedExpCSAccess().getOwnedExpressionPrimaryExpCSParserRuleCall_0_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrimaryExpCS_in_rulePrefixedExpCS10480);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4620:2: this_PrimaryExpCS_3= rulePrimaryExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrefixedExpCSAccess().getPrimaryExpCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrimaryExpCS_in_rulePrefixedExpCS10512);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4639:1: entryRulePrimaryExpCS returns [EObject current=null] : iv_rulePrimaryExpCS= rulePrimaryExpCS EOF ;
    public final EObject entryRulePrimaryExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4640:2: (iv_rulePrimaryExpCS= rulePrimaryExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4641:2: iv_rulePrimaryExpCS= rulePrimaryExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimaryExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePrimaryExpCS_in_entryRulePrimaryExpCS10547);
            iv_rulePrimaryExpCS=rulePrimaryExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimaryExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrimaryExpCS10557); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4648:1: rulePrimaryExpCS returns [EObject current=null] : (this_NestedExpCS_0= ruleNestedExpCS | this_IfExpCS_1= ruleIfExpCS | this_SelfExpCS_2= ruleSelfExpCS | this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS | this_CollectionLiteralExpCS_5= ruleCollectionLiteralExpCS | this_TypeLiteralExpCS_6= ruleTypeLiteralExpCS | this_NameExpCS_7= ruleNameExpCS ) ;
    public final EObject rulePrimaryExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_NestedExpCS_0 = null;

        EObject this_IfExpCS_1 = null;

        EObject this_SelfExpCS_2 = null;

        EObject this_PrimitiveLiteralExpCS_3 = null;

        EObject this_TupleLiteralExpCS_4 = null;

        EObject this_CollectionLiteralExpCS_5 = null;

        EObject this_TypeLiteralExpCS_6 = null;

        EObject this_NameExpCS_7 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4651:28: ( (this_NestedExpCS_0= ruleNestedExpCS | this_IfExpCS_1= ruleIfExpCS | this_SelfExpCS_2= ruleSelfExpCS | this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS | this_CollectionLiteralExpCS_5= ruleCollectionLiteralExpCS | this_TypeLiteralExpCS_6= ruleTypeLiteralExpCS | this_NameExpCS_7= ruleNameExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4652:1: (this_NestedExpCS_0= ruleNestedExpCS | this_IfExpCS_1= ruleIfExpCS | this_SelfExpCS_2= ruleSelfExpCS | this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS | this_CollectionLiteralExpCS_5= ruleCollectionLiteralExpCS | this_TypeLiteralExpCS_6= ruleTypeLiteralExpCS | this_NameExpCS_7= ruleNameExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4652:1: (this_NestedExpCS_0= ruleNestedExpCS | this_IfExpCS_1= ruleIfExpCS | this_SelfExpCS_2= ruleSelfExpCS | this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS | this_CollectionLiteralExpCS_5= ruleCollectionLiteralExpCS | this_TypeLiteralExpCS_6= ruleTypeLiteralExpCS | this_NameExpCS_7= ruleNameExpCS )
            int alt76=8;
            alt76 = dfa76.predict(input);
            switch (alt76) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4653:2: this_NestedExpCS_0= ruleNestedExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getNestedExpCSParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNestedExpCS_in_rulePrimaryExpCS10607);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4666:2: this_IfExpCS_1= ruleIfExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getIfExpCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleIfExpCS_in_rulePrimaryExpCS10637);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4679:2: this_SelfExpCS_2= ruleSelfExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getSelfExpCSParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSelfExpCS_in_rulePrimaryExpCS10667);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4692:2: this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getPrimitiveLiteralExpCSParserRuleCall_3()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrimitiveLiteralExpCS_in_rulePrimaryExpCS10697);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4705:2: this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getTupleLiteralExpCSParserRuleCall_4()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralExpCS_in_rulePrimaryExpCS10727);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4718:2: this_CollectionLiteralExpCS_5= ruleCollectionLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getCollectionLiteralExpCSParserRuleCall_5()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteralExpCS_in_rulePrimaryExpCS10757);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4731:2: this_TypeLiteralExpCS_6= ruleTypeLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getTypeLiteralExpCSParserRuleCall_6()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralExpCS_in_rulePrimaryExpCS10787);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4744:2: this_NameExpCS_7= ruleNameExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getNameExpCSParserRuleCall_7()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNameExpCS_in_rulePrimaryExpCS10817);
                    this_NameExpCS_7=ruleNameExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_NameExpCS_7; 
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4763:1: entryRuleNameExpCS returns [EObject current=null] : iv_ruleNameExpCS= ruleNameExpCS EOF ;
    public final EObject entryRuleNameExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNameExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4764:2: (iv_ruleNameExpCS= ruleNameExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4765:2: iv_ruleNameExpCS= ruleNameExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNameExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNameExpCS_in_entryRuleNameExpCS10852);
            iv_ruleNameExpCS=ruleNameExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNameExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNameExpCS10862); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4772:1: ruleNameExpCS returns [EObject current=null] : ( ( (lv_pathName_0_0= rulePathNameCS ) ) ( (lv_squareBracketedClauses_1_0= ruleSquareBracketedClauseCS ) )* ( (lv_roundBracketedClause_2_0= ruleRoundBracketedClauseCS ) )? ( (lv_curlyBracketedClause_3_0= ruleCurlyBracketedClauseCS ) )? ( ( (lv_atPre_4_0= '@' ) ) otherlv_5= 'pre' )? ) ;
    public final EObject ruleNameExpCS() throws RecognitionException {
        EObject current = null;

        Token lv_atPre_4_0=null;
        Token otherlv_5=null;
        EObject lv_pathName_0_0 = null;

        EObject lv_squareBracketedClauses_1_0 = null;

        EObject lv_roundBracketedClause_2_0 = null;

        EObject lv_curlyBracketedClause_3_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4775:28: ( ( ( (lv_pathName_0_0= rulePathNameCS ) ) ( (lv_squareBracketedClauses_1_0= ruleSquareBracketedClauseCS ) )* ( (lv_roundBracketedClause_2_0= ruleRoundBracketedClauseCS ) )? ( (lv_curlyBracketedClause_3_0= ruleCurlyBracketedClauseCS ) )? ( ( (lv_atPre_4_0= '@' ) ) otherlv_5= 'pre' )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4776:1: ( ( (lv_pathName_0_0= rulePathNameCS ) ) ( (lv_squareBracketedClauses_1_0= ruleSquareBracketedClauseCS ) )* ( (lv_roundBracketedClause_2_0= ruleRoundBracketedClauseCS ) )? ( (lv_curlyBracketedClause_3_0= ruleCurlyBracketedClauseCS ) )? ( ( (lv_atPre_4_0= '@' ) ) otherlv_5= 'pre' )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4776:1: ( ( (lv_pathName_0_0= rulePathNameCS ) ) ( (lv_squareBracketedClauses_1_0= ruleSquareBracketedClauseCS ) )* ( (lv_roundBracketedClause_2_0= ruleRoundBracketedClauseCS ) )? ( (lv_curlyBracketedClause_3_0= ruleCurlyBracketedClauseCS ) )? ( ( (lv_atPre_4_0= '@' ) ) otherlv_5= 'pre' )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4776:2: ( (lv_pathName_0_0= rulePathNameCS ) ) ( (lv_squareBracketedClauses_1_0= ruleSquareBracketedClauseCS ) )* ( (lv_roundBracketedClause_2_0= ruleRoundBracketedClauseCS ) )? ( (lv_curlyBracketedClause_3_0= ruleCurlyBracketedClauseCS ) )? ( ( (lv_atPre_4_0= '@' ) ) otherlv_5= 'pre' )?
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4776:2: ( (lv_pathName_0_0= rulePathNameCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4777:1: (lv_pathName_0_0= rulePathNameCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4777:1: (lv_pathName_0_0= rulePathNameCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4778:3: lv_pathName_0_0= rulePathNameCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNameExpCSAccess().getPathNamePathNameCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_rulePathNameCS_in_ruleNameExpCS10908);
            lv_pathName_0_0=rulePathNameCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getNameExpCSRule());
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4794:2: ( (lv_squareBracketedClauses_1_0= ruleSquareBracketedClauseCS ) )*
            loop77:
            do {
                int alt77=2;
                int LA77_0 = input.LA(1);

                if ( (LA77_0==72) ) {
                    alt77=1;
                }


                switch (alt77) {
            	case 1 :
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4795:1: (lv_squareBracketedClauses_1_0= ruleSquareBracketedClauseCS )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4795:1: (lv_squareBracketedClauses_1_0= ruleSquareBracketedClauseCS )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4796:3: lv_squareBracketedClauses_1_0= ruleSquareBracketedClauseCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getNameExpCSAccess().getSquareBracketedClausesSquareBracketedClauseCSParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleSquareBracketedClauseCS_in_ruleNameExpCS10929);
            	    lv_squareBracketedClauses_1_0=ruleSquareBracketedClauseCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getNameExpCSRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"squareBracketedClauses",
            	              		lv_squareBracketedClauses_1_0, 
            	              		"SquareBracketedClauseCS");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop77;
                }
            } while (true);

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4812:3: ( (lv_roundBracketedClause_2_0= ruleRoundBracketedClauseCS ) )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==29) ) {
                alt78=1;
            }
            switch (alt78) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4813:1: (lv_roundBracketedClause_2_0= ruleRoundBracketedClauseCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4813:1: (lv_roundBracketedClause_2_0= ruleRoundBracketedClauseCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4814:3: lv_roundBracketedClause_2_0= ruleRoundBracketedClauseCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNameExpCSAccess().getRoundBracketedClauseRoundBracketedClauseCSParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleRoundBracketedClauseCS_in_ruleNameExpCS10951);
                    lv_roundBracketedClause_2_0=ruleRoundBracketedClauseCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getNameExpCSRule());
                      	        }
                             		set(
                             			current, 
                             			"roundBracketedClause",
                              		lv_roundBracketedClause_2_0, 
                              		"RoundBracketedClauseCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4830:3: ( (lv_curlyBracketedClause_3_0= ruleCurlyBracketedClauseCS ) )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==20) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4831:1: (lv_curlyBracketedClause_3_0= ruleCurlyBracketedClauseCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4831:1: (lv_curlyBracketedClause_3_0= ruleCurlyBracketedClauseCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4832:3: lv_curlyBracketedClause_3_0= ruleCurlyBracketedClauseCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNameExpCSAccess().getCurlyBracketedClauseCurlyBracketedClauseCSParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCurlyBracketedClauseCS_in_ruleNameExpCS10973);
                    lv_curlyBracketedClause_3_0=ruleCurlyBracketedClauseCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getNameExpCSRule());
                      	        }
                             		set(
                             			current, 
                             			"curlyBracketedClause",
                              		lv_curlyBracketedClause_3_0, 
                              		"CurlyBracketedClauseCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4848:3: ( ( (lv_atPre_4_0= '@' ) ) otherlv_5= 'pre' )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==79) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4848:4: ( (lv_atPre_4_0= '@' ) ) otherlv_5= 'pre'
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4848:4: ( (lv_atPre_4_0= '@' ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4849:1: (lv_atPre_4_0= '@' )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4849:1: (lv_atPre_4_0= '@' )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4850:3: lv_atPre_4_0= '@'
                    {
                    lv_atPre_4_0=(Token)match(input,79,FollowSets000.FOLLOW_79_in_ruleNameExpCS10993); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_atPre_4_0, grammarAccess.getNameExpCSAccess().getAtPreCommercialAtKeyword_4_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getNameExpCSRule());
                      	        }
                             		setWithLastConsumed(current, "atPre", true, "@");
                      	    
                    }

                    }


                    }

                    otherlv_5=(Token)match(input,80,FollowSets000.FOLLOW_80_in_ruleNameExpCS11018); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4875:1: entryRuleCurlyBracketedClauseCS returns [EObject current=null] : iv_ruleCurlyBracketedClauseCS= ruleCurlyBracketedClauseCS EOF ;
    public final EObject entryRuleCurlyBracketedClauseCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCurlyBracketedClauseCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4876:2: (iv_ruleCurlyBracketedClauseCS= ruleCurlyBracketedClauseCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4877:2: iv_ruleCurlyBracketedClauseCS= ruleCurlyBracketedClauseCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCurlyBracketedClauseCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleCurlyBracketedClauseCS_in_entryRuleCurlyBracketedClauseCS11056);
            iv_ruleCurlyBracketedClauseCS=ruleCurlyBracketedClauseCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCurlyBracketedClauseCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCurlyBracketedClauseCS11066); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4884:1: ruleCurlyBracketedClauseCS returns [EObject current=null] : ( () otherlv_1= '{' ( ( ( (lv_ownedParts_2_0= ruleConstructorPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleConstructorPartCS ) ) )* )? | ( (lv_value_5_0= ruleStringLiteral ) ) ) otherlv_6= '}' ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4887:28: ( ( () otherlv_1= '{' ( ( ( (lv_ownedParts_2_0= ruleConstructorPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleConstructorPartCS ) ) )* )? | ( (lv_value_5_0= ruleStringLiteral ) ) ) otherlv_6= '}' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4888:1: ( () otherlv_1= '{' ( ( ( (lv_ownedParts_2_0= ruleConstructorPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleConstructorPartCS ) ) )* )? | ( (lv_value_5_0= ruleStringLiteral ) ) ) otherlv_6= '}' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4888:1: ( () otherlv_1= '{' ( ( ( (lv_ownedParts_2_0= ruleConstructorPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleConstructorPartCS ) ) )* )? | ( (lv_value_5_0= ruleStringLiteral ) ) ) otherlv_6= '}' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4888:2: () otherlv_1= '{' ( ( ( (lv_ownedParts_2_0= ruleConstructorPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleConstructorPartCS ) ) )* )? | ( (lv_value_5_0= ruleStringLiteral ) ) ) otherlv_6= '}'
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4888:2: ()
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4889:2: 
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

            otherlv_1=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleCurlyBracketedClauseCS11115); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getCurlyBracketedClauseCSAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4901:1: ( ( ( (lv_ownedParts_2_0= ruleConstructorPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleConstructorPartCS ) ) )* )? | ( (lv_value_5_0= ruleStringLiteral ) ) )
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( ((LA83_0>=RULE_SIMPLE_ID && LA83_0<=RULE_ESCAPED_ID)||LA83_0==16||LA83_0==18||LA83_0==22||(LA83_0>=27 && LA83_0<=28)||LA83_0==31||(LA83_0>=35 && LA83_0<=40)) ) {
                alt83=1;
            }
            else if ( (LA83_0==RULE_SINGLE_QUOTED_STRING) ) {
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4901:2: ( ( (lv_ownedParts_2_0= ruleConstructorPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleConstructorPartCS ) ) )* )?
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4901:2: ( ( (lv_ownedParts_2_0= ruleConstructorPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleConstructorPartCS ) ) )* )?
                    int alt82=2;
                    int LA82_0 = input.LA(1);

                    if ( ((LA82_0>=RULE_SIMPLE_ID && LA82_0<=RULE_ESCAPED_ID)||LA82_0==16||LA82_0==18||(LA82_0>=27 && LA82_0<=28)||LA82_0==31||(LA82_0>=35 && LA82_0<=40)) ) {
                        alt82=1;
                    }
                    switch (alt82) {
                        case 1 :
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4901:3: ( (lv_ownedParts_2_0= ruleConstructorPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleConstructorPartCS ) ) )*
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4901:3: ( (lv_ownedParts_2_0= ruleConstructorPartCS ) )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4902:1: (lv_ownedParts_2_0= ruleConstructorPartCS )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4902:1: (lv_ownedParts_2_0= ruleConstructorPartCS )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4903:3: lv_ownedParts_2_0= ruleConstructorPartCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getCurlyBracketedClauseCSAccess().getOwnedPartsConstructorPartCSParserRuleCall_2_0_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleConstructorPartCS_in_ruleCurlyBracketedClauseCS11138);
                            lv_ownedParts_2_0=ruleConstructorPartCS();

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
                                      		"ConstructorPartCS");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4919:2: (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleConstructorPartCS ) ) )*
                            loop81:
                            do {
                                int alt81=2;
                                int LA81_0 = input.LA(1);

                                if ( (LA81_0==19) ) {
                                    alt81=1;
                                }


                                switch (alt81) {
                            	case 1 :
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4919:4: otherlv_3= ',' ( (lv_ownedParts_4_0= ruleConstructorPartCS ) )
                            	    {
                            	    otherlv_3=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleCurlyBracketedClauseCS11151); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_3, grammarAccess.getCurlyBracketedClauseCSAccess().getCommaKeyword_2_0_1_0());
                            	          
                            	    }
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4923:1: ( (lv_ownedParts_4_0= ruleConstructorPartCS ) )
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4924:1: (lv_ownedParts_4_0= ruleConstructorPartCS )
                            	    {
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4924:1: (lv_ownedParts_4_0= ruleConstructorPartCS )
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4925:3: lv_ownedParts_4_0= ruleConstructorPartCS
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getCurlyBracketedClauseCSAccess().getOwnedPartsConstructorPartCSParserRuleCall_2_0_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FollowSets000.FOLLOW_ruleConstructorPartCS_in_ruleCurlyBracketedClauseCS11172);
                            	    lv_ownedParts_4_0=ruleConstructorPartCS();

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
                            	              		"ConstructorPartCS");
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


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4942:6: ( (lv_value_5_0= ruleStringLiteral ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4942:6: ( (lv_value_5_0= ruleStringLiteral ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4943:1: (lv_value_5_0= ruleStringLiteral )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4943:1: (lv_value_5_0= ruleStringLiteral )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4944:3: lv_value_5_0= ruleStringLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCurlyBracketedClauseCSAccess().getValueStringLiteralParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleStringLiteral_in_ruleCurlyBracketedClauseCS11203);
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
                              		"StringLiteral");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleCurlyBracketedClauseCS11216); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4972:1: entryRuleRoundBracketedClauseCS returns [EObject current=null] : iv_ruleRoundBracketedClauseCS= ruleRoundBracketedClauseCS EOF ;
    public final EObject entryRuleRoundBracketedClauseCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRoundBracketedClauseCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4973:2: (iv_ruleRoundBracketedClauseCS= ruleRoundBracketedClauseCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4974:2: iv_ruleRoundBracketedClauseCS= ruleRoundBracketedClauseCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRoundBracketedClauseCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleRoundBracketedClauseCS_in_entryRuleRoundBracketedClauseCS11252);
            iv_ruleRoundBracketedClauseCS=ruleRoundBracketedClauseCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRoundBracketedClauseCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRoundBracketedClauseCS11262); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4981:1: ruleRoundBracketedClauseCS returns [EObject current=null] : ( () otherlv_1= '(' ( ( (lv_arguments_2_0= ruleNavigatingArgCS ) ) ( (lv_arguments_3_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_arguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_arguments_5_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_arguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_arguments_7_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_8= ')' ) ;
    public final EObject ruleRoundBracketedClauseCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_8=null;
        EObject lv_arguments_2_0 = null;

        EObject lv_arguments_3_0 = null;

        EObject lv_arguments_4_0 = null;

        EObject lv_arguments_5_0 = null;

        EObject lv_arguments_6_0 = null;

        EObject lv_arguments_7_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4984:28: ( ( () otherlv_1= '(' ( ( (lv_arguments_2_0= ruleNavigatingArgCS ) ) ( (lv_arguments_3_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_arguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_arguments_5_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_arguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_arguments_7_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_8= ')' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4985:1: ( () otherlv_1= '(' ( ( (lv_arguments_2_0= ruleNavigatingArgCS ) ) ( (lv_arguments_3_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_arguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_arguments_5_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_arguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_arguments_7_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_8= ')' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4985:1: ( () otherlv_1= '(' ( ( (lv_arguments_2_0= ruleNavigatingArgCS ) ) ( (lv_arguments_3_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_arguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_arguments_5_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_arguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_arguments_7_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_8= ')' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4985:2: () otherlv_1= '(' ( ( (lv_arguments_2_0= ruleNavigatingArgCS ) ) ( (lv_arguments_3_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_arguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_arguments_5_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_arguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_arguments_7_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_8= ')'
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4985:2: ()
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4986:2: 
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

            otherlv_1=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleRoundBracketedClauseCS11311); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getRoundBracketedClauseCSAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4998:1: ( ( (lv_arguments_2_0= ruleNavigatingArgCS ) ) ( (lv_arguments_3_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_arguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_arguments_5_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_arguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_arguments_7_0= ruleNavigatingCommaArgCS ) )* )? )?
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( ((LA89_0>=RULE_SIMPLE_ID && LA89_0<=RULE_SINGLE_QUOTED_STRING)||LA89_0==16||LA89_0==18||(LA89_0>=27 && LA89_0<=29)||LA89_0==31||(LA89_0>=34 && LA89_0<=42)||(LA89_0>=57 && LA89_0<=70)||(LA89_0>=75 && LA89_0<=78)||LA89_0==81||(LA89_0>=85 && LA89_0<=86)) ) {
                alt89=1;
            }
            switch (alt89) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4998:2: ( (lv_arguments_2_0= ruleNavigatingArgCS ) ) ( (lv_arguments_3_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_arguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_arguments_5_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_arguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_arguments_7_0= ruleNavigatingCommaArgCS ) )* )?
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4998:2: ( (lv_arguments_2_0= ruleNavigatingArgCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4999:1: (lv_arguments_2_0= ruleNavigatingArgCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4999:1: (lv_arguments_2_0= ruleNavigatingArgCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5000:3: lv_arguments_2_0= ruleNavigatingArgCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRoundBracketedClauseCSAccess().getArgumentsNavigatingArgCSParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgCS_in_ruleRoundBracketedClauseCS11333);
                    lv_arguments_2_0=ruleNavigatingArgCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getRoundBracketedClauseCSRule());
                      	        }
                             		add(
                             			current, 
                             			"arguments",
                              		lv_arguments_2_0, 
                              		"NavigatingArgCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5016:2: ( (lv_arguments_3_0= ruleNavigatingCommaArgCS ) )*
                    loop84:
                    do {
                        int alt84=2;
                        int LA84_0 = input.LA(1);

                        if ( (LA84_0==19) ) {
                            alt84=1;
                        }


                        switch (alt84) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5017:1: (lv_arguments_3_0= ruleNavigatingCommaArgCS )
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5017:1: (lv_arguments_3_0= ruleNavigatingCommaArgCS )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5018:3: lv_arguments_3_0= ruleNavigatingCommaArgCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getRoundBracketedClauseCSAccess().getArgumentsNavigatingCommaArgCSParserRuleCall_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleNavigatingCommaArgCS_in_ruleRoundBracketedClauseCS11354);
                    	    lv_arguments_3_0=ruleNavigatingCommaArgCS();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getRoundBracketedClauseCSRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"arguments",
                    	              		lv_arguments_3_0, 
                    	              		"NavigatingCommaArgCS");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop84;
                        }
                    } while (true);

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5034:3: ( ( (lv_arguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_arguments_5_0= ruleNavigatingCommaArgCS ) )* )?
                    int alt86=2;
                    int LA86_0 = input.LA(1);

                    if ( (LA86_0==26) ) {
                        alt86=1;
                    }
                    switch (alt86) {
                        case 1 :
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5034:4: ( (lv_arguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_arguments_5_0= ruleNavigatingCommaArgCS ) )*
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5034:4: ( (lv_arguments_4_0= ruleNavigatingSemiArgCS ) )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5035:1: (lv_arguments_4_0= ruleNavigatingSemiArgCS )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5035:1: (lv_arguments_4_0= ruleNavigatingSemiArgCS )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5036:3: lv_arguments_4_0= ruleNavigatingSemiArgCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getRoundBracketedClauseCSAccess().getArgumentsNavigatingSemiArgCSParserRuleCall_2_2_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleNavigatingSemiArgCS_in_ruleRoundBracketedClauseCS11377);
                            lv_arguments_4_0=ruleNavigatingSemiArgCS();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getRoundBracketedClauseCSRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"arguments",
                                      		lv_arguments_4_0, 
                                      		"NavigatingSemiArgCS");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5052:2: ( (lv_arguments_5_0= ruleNavigatingCommaArgCS ) )*
                            loop85:
                            do {
                                int alt85=2;
                                int LA85_0 = input.LA(1);

                                if ( (LA85_0==19) ) {
                                    alt85=1;
                                }


                                switch (alt85) {
                            	case 1 :
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5053:1: (lv_arguments_5_0= ruleNavigatingCommaArgCS )
                            	    {
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5053:1: (lv_arguments_5_0= ruleNavigatingCommaArgCS )
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5054:3: lv_arguments_5_0= ruleNavigatingCommaArgCS
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getRoundBracketedClauseCSAccess().getArgumentsNavigatingCommaArgCSParserRuleCall_2_2_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FollowSets000.FOLLOW_ruleNavigatingCommaArgCS_in_ruleRoundBracketedClauseCS11398);
                            	    lv_arguments_5_0=ruleNavigatingCommaArgCS();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getRoundBracketedClauseCSRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"arguments",
                            	              		lv_arguments_5_0, 
                            	              		"NavigatingCommaArgCS");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop85;
                                }
                            } while (true);


                            }
                            break;

                    }

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5070:5: ( ( (lv_arguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_arguments_7_0= ruleNavigatingCommaArgCS ) )* )?
                    int alt88=2;
                    int LA88_0 = input.LA(1);

                    if ( (LA88_0==23) ) {
                        alt88=1;
                    }
                    switch (alt88) {
                        case 1 :
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5070:6: ( (lv_arguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_arguments_7_0= ruleNavigatingCommaArgCS ) )*
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5070:6: ( (lv_arguments_6_0= ruleNavigatingBarArgCS ) )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5071:1: (lv_arguments_6_0= ruleNavigatingBarArgCS )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5071:1: (lv_arguments_6_0= ruleNavigatingBarArgCS )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5072:3: lv_arguments_6_0= ruleNavigatingBarArgCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getRoundBracketedClauseCSAccess().getArgumentsNavigatingBarArgCSParserRuleCall_2_3_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleNavigatingBarArgCS_in_ruleRoundBracketedClauseCS11423);
                            lv_arguments_6_0=ruleNavigatingBarArgCS();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getRoundBracketedClauseCSRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"arguments",
                                      		lv_arguments_6_0, 
                                      		"NavigatingBarArgCS");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5088:2: ( (lv_arguments_7_0= ruleNavigatingCommaArgCS ) )*
                            loop87:
                            do {
                                int alt87=2;
                                int LA87_0 = input.LA(1);

                                if ( (LA87_0==19) ) {
                                    alt87=1;
                                }


                                switch (alt87) {
                            	case 1 :
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5089:1: (lv_arguments_7_0= ruleNavigatingCommaArgCS )
                            	    {
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5089:1: (lv_arguments_7_0= ruleNavigatingCommaArgCS )
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5090:3: lv_arguments_7_0= ruleNavigatingCommaArgCS
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getRoundBracketedClauseCSAccess().getArgumentsNavigatingCommaArgCSParserRuleCall_2_3_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FollowSets000.FOLLOW_ruleNavigatingCommaArgCS_in_ruleRoundBracketedClauseCS11444);
                            	    lv_arguments_7_0=ruleNavigatingCommaArgCS();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getRoundBracketedClauseCSRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"arguments",
                            	              		lv_arguments_7_0, 
                            	              		"NavigatingCommaArgCS");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop87;
                                }
                            } while (true);


                            }
                            break;

                    }


                    }
                    break;

            }

            otherlv_8=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleRoundBracketedClauseCS11461); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5118:1: entryRuleSquareBracketedClauseCS returns [EObject current=null] : iv_ruleSquareBracketedClauseCS= ruleSquareBracketedClauseCS EOF ;
    public final EObject entryRuleSquareBracketedClauseCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSquareBracketedClauseCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5119:2: (iv_ruleSquareBracketedClauseCS= ruleSquareBracketedClauseCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5120:2: iv_ruleSquareBracketedClauseCS= ruleSquareBracketedClauseCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSquareBracketedClauseCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSquareBracketedClauseCS_in_entryRuleSquareBracketedClauseCS11497);
            iv_ruleSquareBracketedClauseCS=ruleSquareBracketedClauseCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSquareBracketedClauseCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSquareBracketedClauseCS11507); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5127:1: ruleSquareBracketedClauseCS returns [EObject current=null] : (otherlv_0= '[' ( (lv_terms_1_0= ruleExpCS ) ) (otherlv_2= ',' ( (lv_terms_3_0= ruleExpCS ) ) )* otherlv_4= ']' ) ;
    public final EObject ruleSquareBracketedClauseCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_terms_1_0 = null;

        EObject lv_terms_3_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5130:28: ( (otherlv_0= '[' ( (lv_terms_1_0= ruleExpCS ) ) (otherlv_2= ',' ( (lv_terms_3_0= ruleExpCS ) ) )* otherlv_4= ']' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5131:1: (otherlv_0= '[' ( (lv_terms_1_0= ruleExpCS ) ) (otherlv_2= ',' ( (lv_terms_3_0= ruleExpCS ) ) )* otherlv_4= ']' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5131:1: (otherlv_0= '[' ( (lv_terms_1_0= ruleExpCS ) ) (otherlv_2= ',' ( (lv_terms_3_0= ruleExpCS ) ) )* otherlv_4= ']' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5131:3: otherlv_0= '[' ( (lv_terms_1_0= ruleExpCS ) ) (otherlv_2= ',' ( (lv_terms_3_0= ruleExpCS ) ) )* otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,72,FollowSets000.FOLLOW_72_in_ruleSquareBracketedClauseCS11544); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getSquareBracketedClauseCSAccess().getLeftSquareBracketKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5135:1: ( (lv_terms_1_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5136:1: (lv_terms_1_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5136:1: (lv_terms_1_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5137:3: lv_terms_1_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSquareBracketedClauseCSAccess().getTermsExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleSquareBracketedClauseCS11565);
            lv_terms_1_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getSquareBracketedClauseCSRule());
              	        }
                     		add(
                     			current, 
                     			"terms",
                      		lv_terms_1_0, 
                      		"ExpCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5153:2: (otherlv_2= ',' ( (lv_terms_3_0= ruleExpCS ) ) )*
            loop90:
            do {
                int alt90=2;
                int LA90_0 = input.LA(1);

                if ( (LA90_0==19) ) {
                    alt90=1;
                }


                switch (alt90) {
            	case 1 :
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5153:4: otherlv_2= ',' ( (lv_terms_3_0= ruleExpCS ) )
            	    {
            	    otherlv_2=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleSquareBracketedClauseCS11578); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getSquareBracketedClauseCSAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5157:1: ( (lv_terms_3_0= ruleExpCS ) )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5158:1: (lv_terms_3_0= ruleExpCS )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5158:1: (lv_terms_3_0= ruleExpCS )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5159:3: lv_terms_3_0= ruleExpCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSquareBracketedClauseCSAccess().getTermsExpCSParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleSquareBracketedClauseCS11599);
            	    lv_terms_3_0=ruleExpCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getSquareBracketedClauseCSRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"terms",
            	              		lv_terms_3_0, 
            	              		"ExpCS");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop90;
                }
            } while (true);

            otherlv_4=(Token)match(input,73,FollowSets000.FOLLOW_73_in_ruleSquareBracketedClauseCS11613); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5187:1: entryRuleNavigatingArgCS returns [EObject current=null] : iv_ruleNavigatingArgCS= ruleNavigatingArgCS EOF ;
    public final EObject entryRuleNavigatingArgCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingArgCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5188:2: (iv_ruleNavigatingArgCS= ruleNavigatingArgCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5189:2: iv_ruleNavigatingArgCS= ruleNavigatingArgCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingArgCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgCS_in_entryRuleNavigatingArgCS11649);
            iv_ruleNavigatingArgCS=ruleNavigatingArgCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingArgCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigatingArgCS11659); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5196:1: ruleNavigatingArgCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleNavigatingArgExpCS ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_init_4_0= ruleExpCS ) ) )? )? ) ;
    public final EObject ruleNavigatingArgCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;

        EObject lv_init_4_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5199:28: ( ( ( (lv_name_0_0= ruleNavigatingArgExpCS ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_init_4_0= ruleExpCS ) ) )? )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5200:1: ( ( (lv_name_0_0= ruleNavigatingArgExpCS ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_init_4_0= ruleExpCS ) ) )? )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5200:1: ( ( (lv_name_0_0= ruleNavigatingArgExpCS ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_init_4_0= ruleExpCS ) ) )? )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5200:2: ( (lv_name_0_0= ruleNavigatingArgExpCS ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_init_4_0= ruleExpCS ) ) )? )?
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5200:2: ( (lv_name_0_0= ruleNavigatingArgExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5201:1: (lv_name_0_0= ruleNavigatingArgExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5201:1: (lv_name_0_0= ruleNavigatingArgExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5202:3: lv_name_0_0= ruleNavigatingArgExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getNameNavigatingArgExpCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingArgCS11705);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5218:2: (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_init_4_0= ruleExpCS ) ) )? )?
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( (LA92_0==32) ) {
                alt92=1;
            }
            switch (alt92) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5218:4: otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_init_4_0= ruleExpCS ) ) )?
                    {
                    otherlv_1=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleNavigatingArgCS11718); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getNavigatingArgCSAccess().getColonKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5222:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5223:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5223:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5224:3: lv_ownedType_2_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleNavigatingArgCS11739);
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

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5240:2: (otherlv_3= '=' ( (lv_init_4_0= ruleExpCS ) ) )?
                    int alt91=2;
                    int LA91_0 = input.LA(1);

                    if ( (LA91_0==49) ) {
                        alt91=1;
                    }
                    switch (alt91) {
                        case 1 :
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5240:4: otherlv_3= '=' ( (lv_init_4_0= ruleExpCS ) )
                            {
                            otherlv_3=(Token)match(input,49,FollowSets000.FOLLOW_49_in_ruleNavigatingArgCS11752); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_3, grammarAccess.getNavigatingArgCSAccess().getEqualsSignKeyword_1_2_0());
                                  
                            }
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5244:1: ( (lv_init_4_0= ruleExpCS ) )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5245:1: (lv_init_4_0= ruleExpCS )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5245:1: (lv_init_4_0= ruleExpCS )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5246:3: lv_init_4_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getInitExpCSParserRuleCall_1_2_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNavigatingArgCS11773);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5270:1: entryRuleNavigatingBarArgCS returns [EObject current=null] : iv_ruleNavigatingBarArgCS= ruleNavigatingBarArgCS EOF ;
    public final EObject entryRuleNavigatingBarArgCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingBarArgCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5271:2: (iv_ruleNavigatingBarArgCS= ruleNavigatingBarArgCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5272:2: iv_ruleNavigatingBarArgCS= ruleNavigatingBarArgCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingBarArgCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingBarArgCS_in_entryRuleNavigatingBarArgCS11813);
            iv_ruleNavigatingBarArgCS=ruleNavigatingBarArgCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingBarArgCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigatingBarArgCS11823); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5279:1: ruleNavigatingBarArgCS returns [EObject current=null] : ( ( (lv_prefix_0_0= '|' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )? ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5282:28: ( ( ( (lv_prefix_0_0= '|' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5283:1: ( ( (lv_prefix_0_0= '|' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5283:1: ( ( (lv_prefix_0_0= '|' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5283:2: ( (lv_prefix_0_0= '|' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )?
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5283:2: ( (lv_prefix_0_0= '|' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5284:1: (lv_prefix_0_0= '|' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5284:1: (lv_prefix_0_0= '|' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5285:3: lv_prefix_0_0= '|'
            {
            lv_prefix_0_0=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleNavigatingBarArgCS11866); if (state.failed) return current;
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5298:2: ( (lv_name_1_0= ruleNavigatingArgExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5299:1: (lv_name_1_0= ruleNavigatingArgExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5299:1: (lv_name_1_0= ruleNavigatingArgExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5300:3: lv_name_1_0= ruleNavigatingArgExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNavigatingBarArgCSAccess().getNameNavigatingArgExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingBarArgCS11900);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5316:2: (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )?
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==32) ) {
                alt94=1;
            }
            switch (alt94) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5316:4: otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )?
                    {
                    otherlv_2=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleNavigatingBarArgCS11913); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getNavigatingBarArgCSAccess().getColonKeyword_2_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5320:1: ( (lv_ownedType_3_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5321:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5321:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5322:3: lv_ownedType_3_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingBarArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleNavigatingBarArgCS11934);
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

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5338:2: (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )?
                    int alt93=2;
                    int LA93_0 = input.LA(1);

                    if ( (LA93_0==49) ) {
                        alt93=1;
                    }
                    switch (alt93) {
                        case 1 :
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5338:4: otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) )
                            {
                            otherlv_4=(Token)match(input,49,FollowSets000.FOLLOW_49_in_ruleNavigatingBarArgCS11947); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getNavigatingBarArgCSAccess().getEqualsSignKeyword_2_2_0());
                                  
                            }
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5342:1: ( (lv_init_5_0= ruleExpCS ) )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5343:1: (lv_init_5_0= ruleExpCS )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5343:1: (lv_init_5_0= ruleExpCS )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5344:3: lv_init_5_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getNavigatingBarArgCSAccess().getInitExpCSParserRuleCall_2_2_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNavigatingBarArgCS11968);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5368:1: entryRuleNavigatingCommaArgCS returns [EObject current=null] : iv_ruleNavigatingCommaArgCS= ruleNavigatingCommaArgCS EOF ;
    public final EObject entryRuleNavigatingCommaArgCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingCommaArgCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5369:2: (iv_ruleNavigatingCommaArgCS= ruleNavigatingCommaArgCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5370:2: iv_ruleNavigatingCommaArgCS= ruleNavigatingCommaArgCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingCommaArgCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingCommaArgCS_in_entryRuleNavigatingCommaArgCS12008);
            iv_ruleNavigatingCommaArgCS=ruleNavigatingCommaArgCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingCommaArgCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigatingCommaArgCS12018); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5377:1: ruleNavigatingCommaArgCS returns [EObject current=null] : ( ( (lv_prefix_0_0= ',' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )? ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5380:28: ( ( ( (lv_prefix_0_0= ',' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5381:1: ( ( (lv_prefix_0_0= ',' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5381:1: ( ( (lv_prefix_0_0= ',' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5381:2: ( (lv_prefix_0_0= ',' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )?
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5381:2: ( (lv_prefix_0_0= ',' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5382:1: (lv_prefix_0_0= ',' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5382:1: (lv_prefix_0_0= ',' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5383:3: lv_prefix_0_0= ','
            {
            lv_prefix_0_0=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleNavigatingCommaArgCS12061); if (state.failed) return current;
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5396:2: ( (lv_name_1_0= ruleNavigatingArgExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5397:1: (lv_name_1_0= ruleNavigatingArgExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5397:1: (lv_name_1_0= ruleNavigatingArgExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5398:3: lv_name_1_0= ruleNavigatingArgExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getNameNavigatingArgExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingCommaArgCS12095);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5414:2: (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )?
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==32) ) {
                alt96=1;
            }
            switch (alt96) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5414:4: otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )?
                    {
                    otherlv_2=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleNavigatingCommaArgCS12108); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getNavigatingCommaArgCSAccess().getColonKeyword_2_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5418:1: ( (lv_ownedType_3_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5419:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5419:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5420:3: lv_ownedType_3_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleNavigatingCommaArgCS12129);
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

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5436:2: (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )?
                    int alt95=2;
                    int LA95_0 = input.LA(1);

                    if ( (LA95_0==49) ) {
                        alt95=1;
                    }
                    switch (alt95) {
                        case 1 :
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5436:4: otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) )
                            {
                            otherlv_4=(Token)match(input,49,FollowSets000.FOLLOW_49_in_ruleNavigatingCommaArgCS12142); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getNavigatingCommaArgCSAccess().getEqualsSignKeyword_2_2_0());
                                  
                            }
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5440:1: ( (lv_init_5_0= ruleExpCS ) )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5441:1: (lv_init_5_0= ruleExpCS )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5441:1: (lv_init_5_0= ruleExpCS )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5442:3: lv_init_5_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getInitExpCSParserRuleCall_2_2_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNavigatingCommaArgCS12163);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5466:1: entryRuleNavigatingSemiArgCS returns [EObject current=null] : iv_ruleNavigatingSemiArgCS= ruleNavigatingSemiArgCS EOF ;
    public final EObject entryRuleNavigatingSemiArgCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingSemiArgCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5467:2: (iv_ruleNavigatingSemiArgCS= ruleNavigatingSemiArgCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5468:2: iv_ruleNavigatingSemiArgCS= ruleNavigatingSemiArgCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingSemiArgCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingSemiArgCS_in_entryRuleNavigatingSemiArgCS12203);
            iv_ruleNavigatingSemiArgCS=ruleNavigatingSemiArgCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingSemiArgCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigatingSemiArgCS12213); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5475:1: ruleNavigatingSemiArgCS returns [EObject current=null] : ( ( (lv_prefix_0_0= ';' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )? ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5478:28: ( ( ( (lv_prefix_0_0= ';' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5479:1: ( ( (lv_prefix_0_0= ';' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5479:1: ( ( (lv_prefix_0_0= ';' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5479:2: ( (lv_prefix_0_0= ';' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )?
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5479:2: ( (lv_prefix_0_0= ';' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5480:1: (lv_prefix_0_0= ';' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5480:1: (lv_prefix_0_0= ';' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5481:3: lv_prefix_0_0= ';'
            {
            lv_prefix_0_0=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleNavigatingSemiArgCS12256); if (state.failed) return current;
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5494:2: ( (lv_name_1_0= ruleNavigatingArgExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5495:1: (lv_name_1_0= ruleNavigatingArgExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5495:1: (lv_name_1_0= ruleNavigatingArgExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5496:3: lv_name_1_0= ruleNavigatingArgExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNavigatingSemiArgCSAccess().getNameNavigatingArgExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingSemiArgCS12290);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5512:2: (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )?
            int alt98=2;
            int LA98_0 = input.LA(1);

            if ( (LA98_0==32) ) {
                alt98=1;
            }
            switch (alt98) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5512:4: otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )?
                    {
                    otherlv_2=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleNavigatingSemiArgCS12303); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getNavigatingSemiArgCSAccess().getColonKeyword_2_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5516:1: ( (lv_ownedType_3_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5517:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5517:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5518:3: lv_ownedType_3_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingSemiArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleNavigatingSemiArgCS12324);
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

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5534:2: (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )?
                    int alt97=2;
                    int LA97_0 = input.LA(1);

                    if ( (LA97_0==49) ) {
                        alt97=1;
                    }
                    switch (alt97) {
                        case 1 :
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5534:4: otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) )
                            {
                            otherlv_4=(Token)match(input,49,FollowSets000.FOLLOW_49_in_ruleNavigatingSemiArgCS12337); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getNavigatingSemiArgCSAccess().getEqualsSignKeyword_2_2_0());
                                  
                            }
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5538:1: ( (lv_init_5_0= ruleExpCS ) )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5539:1: (lv_init_5_0= ruleExpCS )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5539:1: (lv_init_5_0= ruleExpCS )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5540:3: lv_init_5_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getNavigatingSemiArgCSAccess().getInitExpCSParserRuleCall_2_2_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNavigatingSemiArgCS12358);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5564:1: entryRuleNavigatingArgExpCS returns [EObject current=null] : iv_ruleNavigatingArgExpCS= ruleNavigatingArgExpCS EOF ;
    public final EObject entryRuleNavigatingArgExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingArgExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5565:2: (iv_ruleNavigatingArgExpCS= ruleNavigatingArgExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5566:2: iv_ruleNavigatingArgExpCS= ruleNavigatingArgExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingArgExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgExpCS_in_entryRuleNavigatingArgExpCS12398);
            iv_ruleNavigatingArgExpCS=ruleNavigatingArgExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingArgExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigatingArgExpCS12408); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5573:1: ruleNavigatingArgExpCS returns [EObject current=null] : this_ExpCS_0= ruleExpCS ;
    public final EObject ruleNavigatingArgExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_ExpCS_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5576:28: (this_ExpCS_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5578:2: this_ExpCS_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getNavigatingArgExpCSAccess().getExpCSParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNavigatingArgExpCS12457);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5597:1: entryRuleIfExpCS returns [EObject current=null] : iv_ruleIfExpCS= ruleIfExpCS EOF ;
    public final EObject entryRuleIfExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5598:2: (iv_ruleIfExpCS= ruleIfExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5599:2: iv_ruleIfExpCS= ruleIfExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIfExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIfExpCS_in_entryRuleIfExpCS12491);
            iv_ruleIfExpCS=ruleIfExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIfExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIfExpCS12501); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5606:1: ruleIfExpCS returns [EObject current=null] : (otherlv_0= 'if' ( (lv_condition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_thenExpression_3_0= ruleExpCS ) ) otherlv_4= 'else' ( (lv_elseExpression_5_0= ruleExpCS ) ) otherlv_6= 'endif' ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5609:28: ( (otherlv_0= 'if' ( (lv_condition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_thenExpression_3_0= ruleExpCS ) ) otherlv_4= 'else' ( (lv_elseExpression_5_0= ruleExpCS ) ) otherlv_6= 'endif' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5610:1: (otherlv_0= 'if' ( (lv_condition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_thenExpression_3_0= ruleExpCS ) ) otherlv_4= 'else' ( (lv_elseExpression_5_0= ruleExpCS ) ) otherlv_6= 'endif' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5610:1: (otherlv_0= 'if' ( (lv_condition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_thenExpression_3_0= ruleExpCS ) ) otherlv_4= 'else' ( (lv_elseExpression_5_0= ruleExpCS ) ) otherlv_6= 'endif' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5610:3: otherlv_0= 'if' ( (lv_condition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_thenExpression_3_0= ruleExpCS ) ) otherlv_4= 'else' ( (lv_elseExpression_5_0= ruleExpCS ) ) otherlv_6= 'endif'
            {
            otherlv_0=(Token)match(input,81,FollowSets000.FOLLOW_81_in_ruleIfExpCS12538); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getIfExpCSAccess().getIfKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5614:1: ( (lv_condition_1_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5615:1: (lv_condition_1_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5615:1: (lv_condition_1_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5616:3: lv_condition_1_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIfExpCSAccess().getConditionExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleIfExpCS12559);
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

            otherlv_2=(Token)match(input,82,FollowSets000.FOLLOW_82_in_ruleIfExpCS12571); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getIfExpCSAccess().getThenKeyword_2());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5636:1: ( (lv_thenExpression_3_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5637:1: (lv_thenExpression_3_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5637:1: (lv_thenExpression_3_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5638:3: lv_thenExpression_3_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIfExpCSAccess().getThenExpressionExpCSParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleIfExpCS12592);
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

            otherlv_4=(Token)match(input,83,FollowSets000.FOLLOW_83_in_ruleIfExpCS12604); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getIfExpCSAccess().getElseKeyword_4());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5658:1: ( (lv_elseExpression_5_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5659:1: (lv_elseExpression_5_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5659:1: (lv_elseExpression_5_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5660:3: lv_elseExpression_5_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIfExpCSAccess().getElseExpressionExpCSParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleIfExpCS12625);
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

            otherlv_6=(Token)match(input,84,FollowSets000.FOLLOW_84_in_ruleIfExpCS12637); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5688:1: entryRuleLetExpCS returns [EObject current=null] : iv_ruleLetExpCS= ruleLetExpCS EOF ;
    public final EObject entryRuleLetExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLetExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5689:2: (iv_ruleLetExpCS= ruleLetExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5690:2: iv_ruleLetExpCS= ruleLetExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLetExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLetExpCS_in_entryRuleLetExpCS12673);
            iv_ruleLetExpCS=ruleLetExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLetExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLetExpCS12683); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5697:1: ruleLetExpCS returns [EObject current=null] : (otherlv_0= 'let' ( (lv_variable_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_variable_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_in_5_0= ruleExpCS ) ) ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5700:28: ( (otherlv_0= 'let' ( (lv_variable_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_variable_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_in_5_0= ruleExpCS ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5701:1: (otherlv_0= 'let' ( (lv_variable_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_variable_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_in_5_0= ruleExpCS ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5701:1: (otherlv_0= 'let' ( (lv_variable_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_variable_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_in_5_0= ruleExpCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5701:3: otherlv_0= 'let' ( (lv_variable_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_variable_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_in_5_0= ruleExpCS ) )
            {
            otherlv_0=(Token)match(input,85,FollowSets000.FOLLOW_85_in_ruleLetExpCS12720); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLetExpCSAccess().getLetKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5705:1: ( (lv_variable_1_0= ruleLetVariableCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5706:1: (lv_variable_1_0= ruleLetVariableCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5706:1: (lv_variable_1_0= ruleLetVariableCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5707:3: lv_variable_1_0= ruleLetVariableCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetExpCSAccess().getVariableLetVariableCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleLetVariableCS_in_ruleLetExpCS12741);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5723:2: (otherlv_2= ',' ( (lv_variable_3_0= ruleLetVariableCS ) ) )*
            loop99:
            do {
                int alt99=2;
                int LA99_0 = input.LA(1);

                if ( (LA99_0==19) ) {
                    alt99=1;
                }


                switch (alt99) {
            	case 1 :
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5723:4: otherlv_2= ',' ( (lv_variable_3_0= ruleLetVariableCS ) )
            	    {
            	    otherlv_2=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleLetExpCS12754); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getLetExpCSAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5727:1: ( (lv_variable_3_0= ruleLetVariableCS ) )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5728:1: (lv_variable_3_0= ruleLetVariableCS )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5728:1: (lv_variable_3_0= ruleLetVariableCS )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5729:3: lv_variable_3_0= ruleLetVariableCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLetExpCSAccess().getVariableLetVariableCSParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleLetVariableCS_in_ruleLetExpCS12775);
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
            	    break loop99;
                }
            } while (true);

            otherlv_4=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleLetExpCS12789); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getLetExpCSAccess().getInKeyword_3());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5749:1: ( (lv_in_5_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5750:1: (lv_in_5_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5750:1: (lv_in_5_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5751:3: lv_in_5_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetExpCSAccess().getInExpCSParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleLetExpCS12810);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5775:1: entryRuleLetVariableCS returns [EObject current=null] : iv_ruleLetVariableCS= ruleLetVariableCS EOF ;
    public final EObject entryRuleLetVariableCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLetVariableCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5776:2: (iv_ruleLetVariableCS= ruleLetVariableCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5777:2: iv_ruleLetVariableCS= ruleLetVariableCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLetVariableCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLetVariableCS_in_entryRuleLetVariableCS12846);
            iv_ruleLetVariableCS=ruleLetVariableCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLetVariableCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLetVariableCS12856); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5784:1: ruleLetVariableCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) ) ) ;
    public final EObject ruleLetVariableCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;

        EObject lv_initExpression_4_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5787:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5788:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5788:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5788:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5788:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5789:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5789:1: (lv_name_0_0= ruleUnrestrictedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5790:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetVariableCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleLetVariableCS12902);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5806:2: (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )?
            int alt100=2;
            int LA100_0 = input.LA(1);

            if ( (LA100_0==32) ) {
                alt100=1;
            }
            switch (alt100) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5806:4: otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                    {
                    otherlv_1=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleLetVariableCS12915); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getLetVariableCSAccess().getColonKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5810:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5811:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5811:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5812:3: lv_ownedType_2_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLetVariableCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleLetVariableCS12936);
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

            otherlv_3=(Token)match(input,49,FollowSets000.FOLLOW_49_in_ruleLetVariableCS12950); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getLetVariableCSAccess().getEqualsSignKeyword_2());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5832:1: ( (lv_initExpression_4_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5833:1: (lv_initExpression_4_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5833:1: (lv_initExpression_4_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5834:3: lv_initExpression_4_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetVariableCSAccess().getInitExpressionExpCSParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleLetVariableCS12971);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5858:1: entryRuleNestedExpCS returns [EObject current=null] : iv_ruleNestedExpCS= ruleNestedExpCS EOF ;
    public final EObject entryRuleNestedExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNestedExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5859:2: (iv_ruleNestedExpCS= ruleNestedExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5860:2: iv_ruleNestedExpCS= ruleNestedExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNestedExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNestedExpCS_in_entryRuleNestedExpCS13007);
            iv_ruleNestedExpCS=ruleNestedExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNestedExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNestedExpCS13017); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5867:1: ruleNestedExpCS returns [EObject current=null] : (otherlv_0= '(' ( (lv_source_1_0= ruleExpCS ) ) otherlv_2= ')' ) ;
    public final EObject ruleNestedExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_source_1_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5870:28: ( (otherlv_0= '(' ( (lv_source_1_0= ruleExpCS ) ) otherlv_2= ')' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5871:1: (otherlv_0= '(' ( (lv_source_1_0= ruleExpCS ) ) otherlv_2= ')' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5871:1: (otherlv_0= '(' ( (lv_source_1_0= ruleExpCS ) ) otherlv_2= ')' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5871:3: otherlv_0= '(' ( (lv_source_1_0= ruleExpCS ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleNestedExpCS13054); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getNestedExpCSAccess().getLeftParenthesisKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5875:1: ( (lv_source_1_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5876:1: (lv_source_1_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5876:1: (lv_source_1_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5877:3: lv_source_1_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNestedExpCSAccess().getSourceExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNestedExpCS13075);
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

            otherlv_2=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleNestedExpCS13087); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5905:1: entryRuleSelfExpCS returns [EObject current=null] : iv_ruleSelfExpCS= ruleSelfExpCS EOF ;
    public final EObject entryRuleSelfExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelfExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5906:2: (iv_ruleSelfExpCS= ruleSelfExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5907:2: iv_ruleSelfExpCS= ruleSelfExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSelfExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSelfExpCS_in_entryRuleSelfExpCS13123);
            iv_ruleSelfExpCS=ruleSelfExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSelfExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSelfExpCS13133); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5914:1: ruleSelfExpCS returns [EObject current=null] : ( () otherlv_1= 'self' ) ;
    public final EObject ruleSelfExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5917:28: ( ( () otherlv_1= 'self' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5918:1: ( () otherlv_1= 'self' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5918:1: ( () otherlv_1= 'self' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5918:2: () otherlv_1= 'self'
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5918:2: ()
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5919:2: 
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

            otherlv_1=(Token)match(input,86,FollowSets000.FOLLOW_86_in_ruleSelfExpCS13182); if (state.failed) return current;
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

    // $ANTLR start synpred123_InternalQVTcore
    public final void synpred123_InternalQVTcore_fragment() throws RecognitionException {   
        EObject this_TupleLiteralExpCS_4 = null;


        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4705:2: (this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS )
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4705:2: this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralExpCS_in_synpred123_InternalQVTcore10727);
        this_TupleLiteralExpCS_4=ruleTupleLiteralExpCS();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred123_InternalQVTcore

    // $ANTLR start synpred124_InternalQVTcore
    public final void synpred124_InternalQVTcore_fragment() throws RecognitionException {   
        EObject this_CollectionLiteralExpCS_5 = null;


        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4718:2: (this_CollectionLiteralExpCS_5= ruleCollectionLiteralExpCS )
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4718:2: this_CollectionLiteralExpCS_5= ruleCollectionLiteralExpCS
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteralExpCS_in_synpred124_InternalQVTcore10757);
        this_CollectionLiteralExpCS_5=ruleCollectionLiteralExpCS();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred124_InternalQVTcore

    // $ANTLR start synpred125_InternalQVTcore
    public final void synpred125_InternalQVTcore_fragment() throws RecognitionException {   
        EObject this_TypeLiteralExpCS_6 = null;


        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4731:2: (this_TypeLiteralExpCS_6= ruleTypeLiteralExpCS )
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4731:2: this_TypeLiteralExpCS_6= ruleTypeLiteralExpCS
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralExpCS_in_synpred125_InternalQVTcore10787);
        this_TypeLiteralExpCS_6=ruleTypeLiteralExpCS();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred125_InternalQVTcore

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
    public final boolean synpred125_InternalQVTcore() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred125_InternalQVTcore_fragment(); // can never throw exception
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


    protected DFA15 dfa15 = new DFA15(this);
    protected DFA18 dfa18 = new DFA18(this);
    protected DFA24 dfa24 = new DFA24(this);
    protected DFA33 dfa33 = new DFA33(this);
    protected DFA34 dfa34 = new DFA34(this);
    protected DFA73 dfa73 = new DFA73(this);
    protected DFA68 dfa68 = new DFA68(this);
    protected DFA76 dfa76 = new DFA76(this);
    static final String DFA15_eotS =
        "\21\uffff";
    static final String DFA15_eofS =
        "\21\uffff";
    static final String DFA15_minS =
        "\1\24\1\4\11\24\1\4\3\24\2\uffff";
    static final String DFA15_maxS =
        "\1\24\1\126\15\117\2\uffff";
    static final String DFA15_acceptS =
        "\17\uffff\1\2\1\1";
    static final String DFA15_specialS =
        "\21\uffff}>";
    static final String[] DFA15_transitionS = {
            "\1\1",
            "\1\2\1\3\2\17\10\uffff\1\11\1\uffff\1\14\3\uffff\1\17\1\uffff"+
            "\1\17\2\uffff\1\7\1\16\1\17\1\uffff\1\6\2\uffff\1\17\1\10\1"+
            "\4\1\5\1\12\1\15\1\13\2\17\16\uffff\16\17\4\uffff\4\17\2\uffff"+
            "\1\17\3\uffff\2\17",
            "\1\17\4\uffff\2\17\2\uffff\1\17\2\uffff\1\20\2\17\6\uffff\1"+
            "\17\1\uffff\16\17\17\uffff\1\17\6\uffff\1\17",
            "\1\17\4\uffff\2\17\2\uffff\1\17\2\uffff\1\20\2\17\6\uffff\1"+
            "\17\1\uffff\16\17\17\uffff\1\17\6\uffff\1\17",
            "\1\17\4\uffff\2\17\2\uffff\1\17\2\uffff\1\20\2\17\6\uffff\1"+
            "\17\1\uffff\16\17\17\uffff\1\17\6\uffff\1\17",
            "\1\17\4\uffff\2\17\2\uffff\1\17\2\uffff\1\20\2\17\6\uffff\1"+
            "\17\1\uffff\16\17\17\uffff\1\17\6\uffff\1\17",
            "\1\17\4\uffff\2\17\2\uffff\1\17\2\uffff\1\20\2\17\6\uffff\1"+
            "\17\1\uffff\16\17\17\uffff\1\17\6\uffff\1\17",
            "\1\17\4\uffff\2\17\2\uffff\1\17\2\uffff\1\20\2\17\6\uffff\1"+
            "\17\1\uffff\16\17\17\uffff\1\17\6\uffff\1\17",
            "\1\17\4\uffff\2\17\2\uffff\1\17\2\uffff\1\20\2\17\6\uffff\1"+
            "\17\1\uffff\16\17\17\uffff\1\17\6\uffff\1\17",
            "\1\17\4\uffff\2\17\2\uffff\1\17\2\uffff\1\20\2\17\6\uffff\1"+
            "\17\1\uffff\16\17\17\uffff\1\17\6\uffff\1\17",
            "\1\17\4\uffff\2\17\2\uffff\1\17\2\uffff\1\20\2\17\6\uffff\1"+
            "\17\1\uffff\16\17\17\uffff\1\17\6\uffff\1\17",
            "\2\20\12\uffff\1\20\1\uffff\1\20\1\uffff\1\17\4\uffff\2\17"+
            "\2\20\1\17\1\uffff\2\20\2\17\6\20\1\17\1\uffff\16\17\17\uffff"+
            "\1\17\6\uffff\1\17",
            "\1\17\4\uffff\2\17\2\uffff\1\17\2\uffff\1\20\2\17\6\uffff\1"+
            "\17\1\uffff\16\17\17\uffff\1\17\6\uffff\1\17",
            "\1\17\4\uffff\2\17\2\uffff\1\17\2\uffff\1\20\2\17\6\uffff\1"+
            "\17\1\uffff\16\17\17\uffff\1\17\6\uffff\1\17",
            "\1\17\4\uffff\2\17\2\uffff\1\17\2\uffff\1\20\2\17\6\uffff\1"+
            "\17\1\uffff\16\17\17\uffff\1\17\6\uffff\1\17",
            "",
            ""
    };

    static final short[] DFA15_eot = DFA.unpackEncodedString(DFA15_eotS);
    static final short[] DFA15_eof = DFA.unpackEncodedString(DFA15_eofS);
    static final char[] DFA15_min = DFA.unpackEncodedStringToUnsignedChars(DFA15_minS);
    static final char[] DFA15_max = DFA.unpackEncodedStringToUnsignedChars(DFA15_maxS);
    static final short[] DFA15_accept = DFA.unpackEncodedString(DFA15_acceptS);
    static final short[] DFA15_special = DFA.unpackEncodedString(DFA15_specialS);
    static final short[][] DFA15_transition;

    static {
        int numStates = DFA15_transitionS.length;
        DFA15_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA15_transition[i] = DFA.unpackEncodedString(DFA15_transitionS[i]);
        }
    }

    class DFA15 extends DFA {

        public DFA15(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 15;
            this.eot = DFA15_eot;
            this.eof = DFA15_eof;
            this.min = DFA15_min;
            this.max = DFA15_max;
            this.accept = DFA15_accept;
            this.special = DFA15_special;
            this.transition = DFA15_transition;
        }
        public String getDescription() {
            return "384:1: ( (otherlv_0= '{' ( ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_2_0= ruleRealizedVariableCS ) ) ) (otherlv_3= ',' ( ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) ) ) )* otherlv_6= '|' ( (lv_constraints_7_0= ruleAssignmentCS ) )* otherlv_8= '}' ) | ( () otherlv_10= '{' ( (lv_constraints_11_0= ruleAssignmentCS ) )* otherlv_12= '}' ) )";
        }
    }
    static final String DFA18_eotS =
        "\13\uffff";
    static final String DFA18_eofS =
        "\1\4\1\uffff\2\1\1\uffff\4\4\2\1";
    static final String DFA18_minS =
        "\1\4\1\uffff\2\4\1\uffff\6\4";
    static final String DFA18_maxS =
        "\1\50\1\uffff\2\50\1\uffff\6\50";
    static final String DFA18_acceptS =
        "\1\uffff\1\1\2\uffff\1\2\6\uffff";
    static final String DFA18_specialS =
        "\13\uffff}>";
    static final String[] DFA18_transitionS = {
            "\2\1\12\uffff\1\1\1\uffff\1\1\7\uffff\1\4\1\2\1\3\2\uffff\1"+
            "\1\3\uffff\6\1",
            "",
            "\2\4\12\uffff\1\4\1\uffff\1\4\7\uffff\1\1\1\5\1\6\2\uffff\1"+
            "\4\3\uffff\6\4",
            "\2\4\12\uffff\1\4\1\uffff\1\4\7\uffff\1\1\1\7\1\10\2\uffff"+
            "\1\4\3\uffff\6\4",
            "",
            "\2\1\12\uffff\1\1\1\uffff\1\1\1\4\6\uffff\1\4\1\1\1\11\2\uffff"+
            "\1\1\3\uffff\6\1",
            "\2\1\12\uffff\1\1\1\uffff\1\1\1\4\6\uffff\1\4\1\1\1\12\2\uffff"+
            "\1\1\3\uffff\6\1",
            "\2\1\12\uffff\1\1\1\uffff\1\1\1\4\6\uffff\1\4\2\1\2\uffff\1"+
            "\1\3\uffff\6\1",
            "\2\1\12\uffff\1\1\1\uffff\1\1\1\4\6\uffff\1\4\2\1\2\uffff\1"+
            "\1\3\uffff\6\1",
            "\2\4\12\uffff\1\4\1\uffff\1\4\1\1\6\uffff\1\1\1\4\1\10\2\uffff"+
            "\1\4\3\uffff\6\4",
            "\2\4\12\uffff\1\4\1\uffff\1\4\1\1\6\uffff\1\1\2\4\2\uffff\1"+
            "\4\3\uffff\6\4"
    };

    static final short[] DFA18_eot = DFA.unpackEncodedString(DFA18_eotS);
    static final short[] DFA18_eof = DFA.unpackEncodedString(DFA18_eofS);
    static final char[] DFA18_min = DFA.unpackEncodedStringToUnsignedChars(DFA18_minS);
    static final char[] DFA18_max = DFA.unpackEncodedStringToUnsignedChars(DFA18_maxS);
    static final short[] DFA18_accept = DFA.unpackEncodedString(DFA18_acceptS);
    static final short[] DFA18_special = DFA.unpackEncodedString(DFA18_specialS);
    static final short[][] DFA18_transition;

    static {
        int numStates = DFA18_transitionS.length;
        DFA18_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA18_transition[i] = DFA.unpackEncodedString(DFA18_transitionS[i]);
        }
    }

    class DFA18 extends DFA {

        public DFA18(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 18;
            this.eot = DFA18_eot;
            this.eof = DFA18_eof;
            this.min = DFA18_min;
            this.max = DFA18_max;
            this.accept = DFA18_accept;
            this.special = DFA18_special;
            this.transition = DFA18_transition;
        }
        public String getDescription() {
            return "638:2: ( (lv_name_1_0= ruleUnrestrictedName ) )?";
        }
    }
    static final String DFA24_eotS =
        "\20\uffff";
    static final String DFA24_eofS =
        "\20\uffff";
    static final String DFA24_minS =
        "\1\4\15\24\2\uffff";
    static final String DFA24_maxS =
        "\1\126\15\117\2\uffff";
    static final String DFA24_acceptS =
        "\16\uffff\1\2\1\1";
    static final String DFA24_specialS =
        "\20\uffff}>";
    static final String[] DFA24_transitionS = {
            "\1\1\1\2\2\16\10\uffff\1\10\1\uffff\1\13\5\uffff\1\16\2\uffff"+
            "\1\6\1\15\2\16\1\5\2\uffff\1\16\1\7\1\3\1\4\1\11\1\14\1\12\2"+
            "\16\16\uffff\16\16\4\uffff\4\16\2\uffff\1\16\3\uffff\2\16",
            "\1\16\4\uffff\2\16\2\uffff\1\16\2\uffff\1\17\2\16\6\uffff\1"+
            "\16\1\uffff\16\16\17\uffff\1\16\6\uffff\1\16",
            "\1\16\4\uffff\2\16\2\uffff\1\16\2\uffff\1\17\2\16\6\uffff\1"+
            "\16\1\uffff\16\16\17\uffff\1\16\6\uffff\1\16",
            "\1\16\4\uffff\2\16\2\uffff\1\16\2\uffff\1\17\2\16\6\uffff\1"+
            "\16\1\uffff\16\16\17\uffff\1\16\6\uffff\1\16",
            "\1\16\4\uffff\2\16\2\uffff\1\16\2\uffff\1\17\2\16\6\uffff\1"+
            "\16\1\uffff\16\16\17\uffff\1\16\6\uffff\1\16",
            "\1\16\4\uffff\2\16\2\uffff\1\16\2\uffff\1\17\2\16\6\uffff\1"+
            "\16\1\uffff\16\16\17\uffff\1\16\6\uffff\1\16",
            "\1\16\4\uffff\2\16\2\uffff\1\16\2\uffff\1\17\2\16\6\uffff\1"+
            "\16\1\uffff\16\16\17\uffff\1\16\6\uffff\1\16",
            "\1\16\4\uffff\2\16\2\uffff\1\16\2\uffff\1\17\2\16\6\uffff\1"+
            "\16\1\uffff\16\16\17\uffff\1\16\6\uffff\1\16",
            "\1\16\4\uffff\2\16\2\uffff\1\16\2\uffff\1\17\2\16\6\uffff\1"+
            "\16\1\uffff\16\16\17\uffff\1\16\6\uffff\1\16",
            "\1\16\4\uffff\2\16\2\uffff\1\16\2\uffff\1\17\2\16\6\uffff\1"+
            "\16\1\uffff\16\16\17\uffff\1\16\6\uffff\1\16",
            "\1\16\4\uffff\2\16\2\uffff\1\16\2\uffff\1\17\2\16\6\uffff\1"+
            "\16\1\uffff\16\16\17\uffff\1\16\6\uffff\1\16",
            "\1\16\4\uffff\2\16\2\uffff\1\16\2\uffff\1\17\2\16\6\uffff\1"+
            "\16\1\uffff\16\16\17\uffff\1\16\6\uffff\1\16",
            "\1\16\4\uffff\2\16\2\uffff\1\16\2\uffff\1\17\2\16\6\uffff\1"+
            "\16\1\uffff\16\16\17\uffff\1\16\6\uffff\1\16",
            "\1\16\4\uffff\2\16\2\uffff\1\16\2\uffff\1\17\2\16\6\uffff\1"+
            "\16\1\uffff\16\16\17\uffff\1\16\6\uffff\1\16",
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
            return "778:1: ( ( (lv_unrealizedVariables_2_0= ruleUnrealizedVariableCS ) ) (otherlv_3= ',' ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) )* otherlv_5= '|' )?";
        }
    }
    static final String DFA33_eotS =
        "\36\uffff";
    static final String DFA33_eofS =
        "\1\16\35\uffff";
    static final String DFA33_minS =
        "\1\4\15\24\1\uffff\16\24\1\uffff";
    static final String DFA33_maxS =
        "\1\106\15\41\1\uffff\16\41\1\uffff";
    static final String DFA33_acceptS =
        "\16\uffff\1\2\16\uffff\1\1";
    static final String DFA33_specialS =
        "\36\uffff}>";
    static final String[] DFA33_transitionS = {
            "\1\1\1\2\12\uffff\1\10\1\uffff\1\13\10\uffff\1\6\1\15\2\uffff"+
            "\1\5\3\uffff\1\7\1\3\1\4\1\11\1\14\1\12\20\uffff\1\34\1\24\1"+
            "\25\1\26\1\27\1\30\1\31\1\32\1\33\1\17\1\20\1\21\1\22\1\23",
            "\1\16\10\uffff\1\16\3\uffff\1\35",
            "\1\16\10\uffff\1\16\3\uffff\1\35",
            "\1\16\10\uffff\1\16\3\uffff\1\35",
            "\1\16\10\uffff\1\16\3\uffff\1\35",
            "\1\16\10\uffff\1\16\3\uffff\1\35",
            "\1\16\10\uffff\1\16\3\uffff\1\35",
            "\1\16\10\uffff\1\16\3\uffff\1\35",
            "\1\16\10\uffff\1\16\3\uffff\1\35",
            "\1\16\10\uffff\1\16\3\uffff\1\35",
            "\1\16\10\uffff\1\16\3\uffff\1\35",
            "\1\16\10\uffff\1\16\3\uffff\1\35",
            "\1\16\10\uffff\1\16\3\uffff\1\35",
            "\1\16\10\uffff\1\16\3\uffff\1\35",
            "",
            "\1\16\14\uffff\1\35",
            "\1\16\14\uffff\1\35",
            "\1\16\14\uffff\1\35",
            "\1\16\14\uffff\1\35",
            "\1\16\14\uffff\1\35",
            "\1\16\14\uffff\1\35",
            "\1\16\14\uffff\1\35",
            "\1\16\14\uffff\1\35",
            "\1\16\14\uffff\1\35",
            "\1\16\14\uffff\1\35",
            "\1\16\14\uffff\1\35",
            "\1\16\14\uffff\1\35",
            "\1\16\14\uffff\1\35",
            "\1\16\14\uffff\1\35",
            ""
    };

    static final short[] DFA33_eot = DFA.unpackEncodedString(DFA33_eotS);
    static final short[] DFA33_eof = DFA.unpackEncodedString(DFA33_eofS);
    static final char[] DFA33_min = DFA.unpackEncodedStringToUnsignedChars(DFA33_minS);
    static final char[] DFA33_max = DFA.unpackEncodedStringToUnsignedChars(DFA33_maxS);
    static final short[] DFA33_accept = DFA.unpackEncodedString(DFA33_acceptS);
    static final short[] DFA33_special = DFA.unpackEncodedString(DFA33_specialS);
    static final short[][] DFA33_transition;

    static {
        int numStates = DFA33_transitionS.length;
        DFA33_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA33_transition[i] = DFA.unpackEncodedString(DFA33_transitionS[i]);
        }
    }

    class DFA33 extends DFA {

        public DFA33(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 33;
            this.eot = DFA33_eot;
            this.eof = DFA33_eof;
            this.min = DFA33_min;
            this.max = DFA33_max;
            this.accept = DFA33_accept;
            this.special = DFA33_special;
            this.transition = DFA33_transition;
        }
        public String getDescription() {
            return "()* loopback of 1350:1: ( ( (lv_path_2_0= ruleNextPathElementCS ) ) otherlv_3= '::' )*";
        }
    }
    static final String DFA34_eotS =
        "\20\uffff";
    static final String DFA34_eofS =
        "\20\uffff";
    static final String DFA34_minS =
        "\1\4\15\24\2\uffff";
    static final String DFA34_maxS =
        "\1\106\15\41\2\uffff";
    static final String DFA34_acceptS =
        "\16\uffff\1\2\1\1";
    static final String DFA34_specialS =
        "\20\uffff}>";
    static final String[] DFA34_transitionS = {
            "\1\1\1\2\12\uffff\1\10\1\uffff\1\13\10\uffff\1\6\1\15\2\uffff"+
            "\1\5\3\uffff\1\7\1\3\1\4\1\11\1\14\1\12\20\uffff\16\16",
            "\1\16\14\uffff\1\17",
            "\1\16\14\uffff\1\17",
            "\1\16\14\uffff\1\17",
            "\1\16\14\uffff\1\17",
            "\1\16\14\uffff\1\17",
            "\1\16\14\uffff\1\17",
            "\1\16\14\uffff\1\17",
            "\1\16\14\uffff\1\17",
            "\1\16\14\uffff\1\17",
            "\1\16\14\uffff\1\17",
            "\1\16\14\uffff\1\17",
            "\1\16\14\uffff\1\17",
            "\1\16\14\uffff\1\17",
            "",
            ""
    };

    static final short[] DFA34_eot = DFA.unpackEncodedString(DFA34_eotS);
    static final short[] DFA34_eof = DFA.unpackEncodedString(DFA34_eofS);
    static final char[] DFA34_min = DFA.unpackEncodedStringToUnsignedChars(DFA34_minS);
    static final char[] DFA34_max = DFA.unpackEncodedStringToUnsignedChars(DFA34_maxS);
    static final short[] DFA34_accept = DFA.unpackEncodedString(DFA34_acceptS);
    static final short[] DFA34_special = DFA.unpackEncodedString(DFA34_specialS);
    static final short[][] DFA34_transition;

    static {
        int numStates = DFA34_transitionS.length;
        DFA34_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA34_transition[i] = DFA.unpackEncodedString(DFA34_transitionS[i]);
        }
    }

    class DFA34 extends DFA {

        public DFA34(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 34;
            this.eot = DFA34_eot;
            this.eof = DFA34_eof;
            this.min = DFA34_min;
            this.max = DFA34_max;
            this.accept = DFA34_accept;
            this.special = DFA34_special;
            this.transition = DFA34_transition;
        }
        public String getDescription() {
            return "1397:1: ( (lv_pathName_1_0= ruleScopeNameCS ) )?";
        }
    }
    static final String DFA73_eotS =
        "\6\uffff";
    static final String DFA73_eofS =
        "\6\uffff";
    static final String DFA73_minS =
        "\3\4\3\uffff";
    static final String DFA73_maxS =
        "\3\126\3\uffff";
    static final String DFA73_acceptS =
        "\3\uffff\1\1\1\3\1\2";
    static final String DFA73_specialS =
        "\6\uffff}>";
    static final String[] DFA73_transitionS = {
            "\4\3\10\uffff\1\3\1\uffff\1\3\10\uffff\3\3\1\uffff\1\3\2\uffff"+
            "\7\3\1\1\1\2\16\uffff\16\3\4\uffff\4\3\2\uffff\1\3\3\uffff\1"+
            "\4\1\3",
            "\4\3\10\uffff\1\3\1\uffff\1\3\10\uffff\3\3\1\uffff\1\3\2\uffff"+
            "\7\3\1\1\1\2\16\uffff\16\3\4\uffff\4\3\2\uffff\1\3\3\uffff\1"+
            "\5\1\3",
            "\4\3\10\uffff\1\3\1\uffff\1\3\10\uffff\3\3\1\uffff\1\3\2\uffff"+
            "\7\3\1\1\1\2\16\uffff\16\3\4\uffff\4\3\2\uffff\1\3\3\uffff\1"+
            "\5\1\3",
            "",
            "",
            ""
    };

    static final short[] DFA73_eot = DFA.unpackEncodedString(DFA73_eotS);
    static final short[] DFA73_eof = DFA.unpackEncodedString(DFA73_eofS);
    static final char[] DFA73_min = DFA.unpackEncodedStringToUnsignedChars(DFA73_minS);
    static final char[] DFA73_max = DFA.unpackEncodedStringToUnsignedChars(DFA73_maxS);
    static final short[] DFA73_accept = DFA.unpackEncodedString(DFA73_acceptS);
    static final short[] DFA73_special = DFA.unpackEncodedString(DFA73_specialS);
    static final short[][] DFA73_transition;

    static {
        int numStates = DFA73_transitionS.length;
        DFA73_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA73_transition[i] = DFA.unpackEncodedString(DFA73_transitionS[i]);
        }
    }

    class DFA73 extends DFA {

        public DFA73(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 73;
            this.eot = DFA73_eot;
            this.eof = DFA73_eof;
            this.min = DFA73_min;
            this.max = DFA73_max;
            this.accept = DFA73_accept;
            this.special = DFA73_special;
            this.transition = DFA73_transition;
        }
        public String getDescription() {
            return "4345:1: ( (this_PrefixedExpCS_0= rulePrefixedExpCS ( () ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? ) | ( (lv_ownedExpression_8_0= ruleLetExpCS ) ) ) )? ) | ( () ( (lv_ownedOperator_10_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_11_0= ruleLetExpCS ) ) ) | this_LetExpCS_12= ruleLetExpCS )";
        }
    }
    static final String DFA68_eotS =
        "\23\uffff";
    static final String DFA68_eofS =
        "\1\21\22\uffff";
    static final String DFA68_minS =
        "\1\21\20\4\2\uffff";
    static final String DFA68_maxS =
        "\1\124\20\126\2\uffff";
    static final String DFA68_acceptS =
        "\21\uffff\1\2\1\1";
    static final String DFA68_specialS =
        "\23\uffff}>";
    static final String[] DFA68_transitionS = {
            "\1\21\1\uffff\1\21\2\uffff\2\21\1\uffff\2\21\3\uffff\1\21\1"+
            "\uffff\1\21\1\uffff\1\1\6\uffff\1\4\1\uffff\1\2\1\3\1\5\1\6"+
            "\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\16\uffff\1"+
            "\21\1\uffff\1\21\10\uffff\3\21",
            "\4\22\10\uffff\1\22\1\uffff\1\22\10\uffff\3\22\1\uffff\1\22"+
            "\2\uffff\11\22\16\uffff\16\22\4\uffff\4\22\2\uffff\1\22\3\uffff"+
            "\1\21\1\22",
            "\4\22\10\uffff\1\22\1\uffff\1\22\10\uffff\3\22\1\uffff\1\22"+
            "\2\uffff\11\22\16\uffff\16\22\4\uffff\4\22\2\uffff\1\22\3\uffff"+
            "\1\21\1\22",
            "\4\22\10\uffff\1\22\1\uffff\1\22\10\uffff\3\22\1\uffff\1\22"+
            "\2\uffff\11\22\16\uffff\16\22\4\uffff\4\22\2\uffff\1\22\3\uffff"+
            "\1\21\1\22",
            "\4\22\10\uffff\1\22\1\uffff\1\22\10\uffff\3\22\1\uffff\1\22"+
            "\2\uffff\11\22\16\uffff\16\22\4\uffff\4\22\2\uffff\1\22\3\uffff"+
            "\1\21\1\22",
            "\4\22\10\uffff\1\22\1\uffff\1\22\10\uffff\3\22\1\uffff\1\22"+
            "\2\uffff\11\22\16\uffff\16\22\4\uffff\4\22\2\uffff\1\22\3\uffff"+
            "\1\21\1\22",
            "\4\22\10\uffff\1\22\1\uffff\1\22\10\uffff\3\22\1\uffff\1\22"+
            "\2\uffff\11\22\16\uffff\16\22\4\uffff\4\22\2\uffff\1\22\3\uffff"+
            "\1\21\1\22",
            "\4\22\10\uffff\1\22\1\uffff\1\22\10\uffff\3\22\1\uffff\1\22"+
            "\2\uffff\11\22\16\uffff\16\22\4\uffff\4\22\2\uffff\1\22\3\uffff"+
            "\1\21\1\22",
            "\4\22\10\uffff\1\22\1\uffff\1\22\10\uffff\3\22\1\uffff\1\22"+
            "\2\uffff\11\22\16\uffff\16\22\4\uffff\4\22\2\uffff\1\22\3\uffff"+
            "\1\21\1\22",
            "\4\22\10\uffff\1\22\1\uffff\1\22\10\uffff\3\22\1\uffff\1\22"+
            "\2\uffff\11\22\16\uffff\16\22\4\uffff\4\22\2\uffff\1\22\3\uffff"+
            "\1\21\1\22",
            "\4\22\10\uffff\1\22\1\uffff\1\22\10\uffff\3\22\1\uffff\1\22"+
            "\2\uffff\11\22\16\uffff\16\22\4\uffff\4\22\2\uffff\1\22\3\uffff"+
            "\1\21\1\22",
            "\4\22\10\uffff\1\22\1\uffff\1\22\10\uffff\3\22\1\uffff\1\22"+
            "\2\uffff\11\22\16\uffff\16\22\4\uffff\4\22\2\uffff\1\22\3\uffff"+
            "\1\21\1\22",
            "\4\22\10\uffff\1\22\1\uffff\1\22\10\uffff\3\22\1\uffff\1\22"+
            "\2\uffff\11\22\16\uffff\16\22\4\uffff\4\22\2\uffff\1\22\3\uffff"+
            "\1\21\1\22",
            "\4\22\10\uffff\1\22\1\uffff\1\22\10\uffff\3\22\1\uffff\1\22"+
            "\2\uffff\11\22\16\uffff\16\22\4\uffff\4\22\2\uffff\1\22\3\uffff"+
            "\1\21\1\22",
            "\4\22\10\uffff\1\22\1\uffff\1\22\10\uffff\3\22\1\uffff\1\22"+
            "\2\uffff\11\22\16\uffff\16\22\4\uffff\4\22\2\uffff\1\22\3\uffff"+
            "\1\21\1\22",
            "\4\22\10\uffff\1\22\1\uffff\1\22\10\uffff\3\22\1\uffff\1\22"+
            "\2\uffff\11\22\16\uffff\16\22\4\uffff\4\22\2\uffff\1\22\3\uffff"+
            "\1\21\1\22",
            "\4\22\10\uffff\1\22\1\uffff\1\22\10\uffff\3\22\1\uffff\1\22"+
            "\2\uffff\11\22\16\uffff\16\22\4\uffff\4\22\2\uffff\1\22\3\uffff"+
            "\1\21\1\22",
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
            return "()* loopback of 4402:2: ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )*";
        }
    }
    static final String DFA76_eotS =
        "\50\uffff";
    static final String DFA76_eofS =
        "\50\uffff";
    static final String DFA76_minS =
        "\1\4\12\uffff\6\0\27\uffff";
    static final String DFA76_maxS =
        "\1\126\12\uffff\6\0\27\uffff";
    static final String DFA76_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\14\uffff\1\7\7\uffff\1\10\14\uffff\1\5"+
        "\1\6";
    static final String DFA76_specialS =
        "\13\uffff\1\0\1\1\1\2\1\3\1\4\1\5\27\uffff}>";
    static final String[] DFA76_transitionS = {
            "\2\31\2\4\10\uffff\1\31\1\uffff\1\31\10\uffff\2\31\1\1\1\uffff"+
            "\1\31\2\uffff\1\4\6\31\20\uffff\1\13\10\21\1\14\1\15\1\16\1"+
            "\17\1\20\4\uffff\4\4\2\uffff\1\2\4\uffff\1\3",
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

    static final short[] DFA76_eot = DFA.unpackEncodedString(DFA76_eotS);
    static final short[] DFA76_eof = DFA.unpackEncodedString(DFA76_eofS);
    static final char[] DFA76_min = DFA.unpackEncodedStringToUnsignedChars(DFA76_minS);
    static final char[] DFA76_max = DFA.unpackEncodedStringToUnsignedChars(DFA76_maxS);
    static final short[] DFA76_accept = DFA.unpackEncodedString(DFA76_acceptS);
    static final short[] DFA76_special = DFA.unpackEncodedString(DFA76_specialS);
    static final short[][] DFA76_transition;

    static {
        int numStates = DFA76_transitionS.length;
        DFA76_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA76_transition[i] = DFA.unpackEncodedString(DFA76_transitionS[i]);
        }
    }

    class DFA76 extends DFA {

        public DFA76(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 76;
            this.eot = DFA76_eot;
            this.eof = DFA76_eof;
            this.min = DFA76_min;
            this.max = DFA76_max;
            this.accept = DFA76_accept;
            this.special = DFA76_special;
            this.transition = DFA76_transition;
        }
        public String getDescription() {
            return "4652:1: (this_NestedExpCS_0= ruleNestedExpCS | this_IfExpCS_1= ruleIfExpCS | this_SelfExpCS_2= ruleSelfExpCS | this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS | this_CollectionLiteralExpCS_5= ruleCollectionLiteralExpCS | this_TypeLiteralExpCS_6= ruleTypeLiteralExpCS | this_NameExpCS_7= ruleNameExpCS )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA76_11 = input.LA(1);

                         
                        int index76_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred123_InternalQVTcore()) ) {s = 38;}

                        else if ( (synpred125_InternalQVTcore()) ) {s = 17;}

                         
                        input.seek(index76_11);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA76_12 = input.LA(1);

                         
                        int index76_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred124_InternalQVTcore()) ) {s = 39;}

                        else if ( (synpred125_InternalQVTcore()) ) {s = 17;}

                         
                        input.seek(index76_12);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA76_13 = input.LA(1);

                         
                        int index76_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred124_InternalQVTcore()) ) {s = 39;}

                        else if ( (synpred125_InternalQVTcore()) ) {s = 17;}

                         
                        input.seek(index76_13);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA76_14 = input.LA(1);

                         
                        int index76_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred124_InternalQVTcore()) ) {s = 39;}

                        else if ( (synpred125_InternalQVTcore()) ) {s = 17;}

                         
                        input.seek(index76_14);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA76_15 = input.LA(1);

                         
                        int index76_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred124_InternalQVTcore()) ) {s = 39;}

                        else if ( (synpred125_InternalQVTcore()) ) {s = 17;}

                         
                        input.seek(index76_15);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA76_16 = input.LA(1);

                         
                        int index76_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred124_InternalQVTcore()) ) {s = 39;}

                        else if ( (synpred125_InternalQVTcore()) ) {s = 17;}

                         
                        input.seek(index76_16);
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
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleTopLevelCS_in_entryRuleTopLevelCS81 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTopLevelCS91 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleImportCS_in_ruleTopLevelCS138 = new BitSet(new long[]{0x000000C880010002L});
        public static final BitSet FOLLOW_ruleLibraryCS_in_ruleTopLevelCS165 = new BitSet(new long[]{0x000000C880010002L});
        public static final BitSet FOLLOW_ruleMappingCS_in_ruleTopLevelCS189 = new BitSet(new long[]{0x000000C000010002L});
        public static final BitSet FOLLOW_ruleTransformationCS_in_ruleTopLevelCS216 = new BitSet(new long[]{0x000000C000010002L});
        public static final BitSet FOLLOW_ruleQueryCS_in_ruleTopLevelCS243 = new BitSet(new long[]{0x000000C000010002L});
        public static final BitSet FOLLOW_ruleMappingCS_in_entryRuleMappingCS281 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMappingCS291 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleMappingCS340 = new BitSet(new long[]{0x000001F898170030L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleMappingCS361 = new BitSet(new long[]{0x0000000000160000L});
        public static final BitSet FOLLOW_17_in_ruleMappingCS375 = new BitSet(new long[]{0x000001F898050030L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleMappingCS402 = new BitSet(new long[]{0x0000000000140000L});
        public static final BitSet FOLLOW_18_in_ruleMappingCS417 = new BitSet(new long[]{0x000001F898050030L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleMappingCS444 = new BitSet(new long[]{0x0000000000180000L});
        public static final BitSet FOLLOW_19_in_ruleMappingCS457 = new BitSet(new long[]{0x000001F898050030L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleMappingCS484 = new BitSet(new long[]{0x0000000000180000L});
        public static final BitSet FOLLOW_20_in_ruleMappingCS500 = new BitSet(new long[]{0x000001F898650030L});
        public static final BitSet FOLLOW_ruleNamedDomainCS_in_ruleMappingCS521 = new BitSet(new long[]{0x000001F898650030L});
        public static final BitSet FOLLOW_21_in_ruleMappingCS535 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_ruleUnnamedDomainCS_in_ruleMappingCS556 = new BitSet(new long[]{0x0000000000410000L});
        public static final BitSet FOLLOW_ruleMappingCS_in_ruleMappingCS579 = new BitSet(new long[]{0x0000000000410000L});
        public static final BitSet FOLLOW_22_in_ruleMappingCS592 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBottomPatternCS_in_entryRuleBottomPatternCS628 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBottomPatternCS638 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleBottomPatternCS676 = new BitSet(new long[]{0x000001F898050030L});
        public static final BitSet FOLLOW_ruleUnrealizedVariableCS_in_ruleBottomPatternCS698 = new BitSet(new long[]{0x0000000000880000L});
        public static final BitSet FOLLOW_ruleRealizedVariableCS_in_ruleBottomPatternCS725 = new BitSet(new long[]{0x0000000000880000L});
        public static final BitSet FOLLOW_19_in_ruleBottomPatternCS739 = new BitSet(new long[]{0x000001F898050030L});
        public static final BitSet FOLLOW_ruleUnrealizedVariableCS_in_ruleBottomPatternCS761 = new BitSet(new long[]{0x0000000000880000L});
        public static final BitSet FOLLOW_ruleRealizedVariableCS_in_ruleBottomPatternCS788 = new BitSet(new long[]{0x0000000000880000L});
        public static final BitSet FOLLOW_23_in_ruleBottomPatternCS803 = new BitSet(new long[]{0xFE0007FCB94500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleAssignmentCS_in_ruleBottomPatternCS824 = new BitSet(new long[]{0xFE0007FCB94500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_22_in_ruleBottomPatternCS837 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleBottomPatternCS869 = new BitSet(new long[]{0xFE0007FCB94500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleAssignmentCS_in_ruleBottomPatternCS890 = new BitSet(new long[]{0xFE0007FCB94500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_22_in_ruleBottomPatternCS903 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignmentCS_in_entryRuleAssignmentCS940 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAssignmentCS950 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_ruleAssignmentCS993 = new BitSet(new long[]{0xFE0007FCB90500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleAssignmentCS1028 = new BitSet(new long[]{0x0000000006000000L});
        public static final BitSet FOLLOW_25_in_ruleAssignmentCS1041 = new BitSet(new long[]{0xFE0007FCB90500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleAssignmentCS1062 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_ruleAssignmentCS1076 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDirectionCS_in_entryRuleDirectionCS1112 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDirectionCS1122 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleDirectionCS1180 = new BitSet(new long[]{0x0000000018000002L});
        public static final BitSet FOLLOW_27_in_ruleDirectionCS1194 = new BitSet(new long[]{0x000001F898050030L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleDirectionCS1221 = new BitSet(new long[]{0x0000000010080002L});
        public static final BitSet FOLLOW_19_in_ruleDirectionCS1234 = new BitSet(new long[]{0x000001F898050030L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleDirectionCS1261 = new BitSet(new long[]{0x0000000010080002L});
        public static final BitSet FOLLOW_28_in_ruleDirectionCS1278 = new BitSet(new long[]{0x000001F898050030L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleDirectionCS1305 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_19_in_ruleDirectionCS1318 = new BitSet(new long[]{0x000001F898050030L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleDirectionCS1345 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_ruleGuardPatternCS_in_entryRuleGuardPatternCS1385 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleGuardPatternCS1395 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_ruleGuardPatternCS1444 = new BitSet(new long[]{0xFE0007FCF90500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleUnrealizedVariableCS_in_ruleGuardPatternCS1466 = new BitSet(new long[]{0x0000000000880000L});
        public static final BitSet FOLLOW_19_in_ruleGuardPatternCS1479 = new BitSet(new long[]{0x000001F898050030L});
        public static final BitSet FOLLOW_ruleUnrealizedVariableCS_in_ruleGuardPatternCS1500 = new BitSet(new long[]{0x0000000000880000L});
        public static final BitSet FOLLOW_23_in_ruleGuardPatternCS1514 = new BitSet(new long[]{0xFE0007FCF90500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleAssignmentCS_in_ruleGuardPatternCS1537 = new BitSet(new long[]{0xFE0007FCF90500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_30_in_ruleGuardPatternCS1550 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleImportCS_in_entryRuleImportCS1586 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleImportCS1596 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_ruleImportCS1633 = new BitSet(new long[]{0x000001F8980500B0L});
        public static final BitSet FOLLOW_ruleIdentifier_in_ruleImportCS1655 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_32_in_ruleImportCS1667 = new BitSet(new long[]{0x000001F8980500B0L});
        public static final BitSet FOLLOW_ruleURIPathNameCS_in_ruleImportCS1690 = new BitSet(new long[]{0x0000000204000000L});
        public static final BitSet FOLLOW_33_in_ruleImportCS1709 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_34_in_ruleImportCS1734 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_ruleImportCS1748 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibraryCS_in_entryRuleLibraryCS1784 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibraryCS1794 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_ruleLibraryCS1831 = new BitSet(new long[]{0x000001F8980500B0L});
        public static final BitSet FOLLOW_ruleURI_in_ruleLibraryCS1858 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_ruleLibraryCS1870 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNamedDomainCS_in_entryRuleNamedDomainCS1906 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNamedDomainCS1916 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_ruleNamedDomainCS1959 = new BitSet(new long[]{0x000001F898050030L});
        public static final BitSet FOLLOW_37_in_ruleNamedDomainCS1991 = new BitSet(new long[]{0x000001F898050030L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleNamedDomainCS2032 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_ruleGuardPatternCS_in_ruleNamedDomainCS2053 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_ruleBottomPatternCS_in_ruleNamedDomainCS2074 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParamDeclarationCS_in_entryRuleParamDeclarationCS2110 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParamDeclarationCS2120 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleParamDeclarationCS2166 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_32_in_ruleParamDeclarationCS2178 = new BitSet(new long[]{0xFE0007FCB80500F0L,0x000000000042787FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleParamDeclarationCS2199 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQueryCS_in_entryRuleQueryCS2235 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleQueryCS2245 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_ruleQueryCS2282 = new BitSet(new long[]{0xFE0007FCB80500F0L,0x000000000042787FL});
        public static final BitSet FOLLOW_ruleScopeNameCS_in_ruleQueryCS2303 = new BitSet(new long[]{0x000001F898050030L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleQueryCS2324 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_29_in_ruleQueryCS2336 = new BitSet(new long[]{0x000001F8D8050030L});
        public static final BitSet FOLLOW_ruleParamDeclarationCS_in_ruleQueryCS2358 = new BitSet(new long[]{0x0000000040080000L});
        public static final BitSet FOLLOW_19_in_ruleQueryCS2371 = new BitSet(new long[]{0x000001F898050030L});
        public static final BitSet FOLLOW_ruleParamDeclarationCS_in_ruleQueryCS2392 = new BitSet(new long[]{0x0000000040080000L});
        public static final BitSet FOLLOW_30_in_ruleQueryCS2408 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_32_in_ruleQueryCS2420 = new BitSet(new long[]{0xFE0007FCB80500F0L,0x000000000042787FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleQueryCS2441 = new BitSet(new long[]{0x0000000004100000L});
        public static final BitSet FOLLOW_26_in_ruleQueryCS2454 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleQueryCS2473 = new BitSet(new long[]{0xFE0007FCB90500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleQueryCS2494 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_22_in_ruleQueryCS2506 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScopeNameCS_in_entryRuleScopeNameCS2544 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleScopeNameCS2554 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFirstPathElementCS_in_ruleScopeNameCS2600 = new BitSet(new long[]{0x0000000200000000L});
        public static final BitSet FOLLOW_33_in_ruleScopeNameCS2612 = new BitSet(new long[]{0xFE0001F898050032L,0x000000000000007FL});
        public static final BitSet FOLLOW_ruleNextPathElementCS_in_ruleScopeNameCS2634 = new BitSet(new long[]{0x0000000200000000L});
        public static final BitSet FOLLOW_33_in_ruleScopeNameCS2646 = new BitSet(new long[]{0xFE0001F898050032L,0x000000000000007FL});
        public static final BitSet FOLLOW_ruleTransformationCS_in_entryRuleTransformationCS2684 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTransformationCS2694 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_39_in_ruleTransformationCS2731 = new BitSet(new long[]{0xFE0007FCB80500F0L,0x000000000042787FL});
        public static final BitSet FOLLOW_ruleScopeNameCS_in_ruleTransformationCS2752 = new BitSet(new long[]{0xFE0001F898050030L,0x000000000000007FL});
        public static final BitSet FOLLOW_ruleUnreservedName_in_ruleTransformationCS2774 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleTransformationCS2786 = new BitSet(new long[]{0x000001F89C450030L});
        public static final BitSet FOLLOW_ruleDirectionCS_in_ruleTransformationCS2808 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_ruleTransformationCS2820 = new BitSet(new long[]{0x000001F89C450030L});
        public static final BitSet FOLLOW_22_in_ruleTransformationCS2834 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrealizedVariableCS_in_entryRuleUnrealizedVariableCS2870 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnrealizedVariableCS2880 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleUnrealizedVariableCS2926 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_32_in_ruleUnrealizedVariableCS2938 = new BitSet(new long[]{0xFE0007FCB80500F0L,0x000000000042787FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleUnrealizedVariableCS2959 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRealizedVariableCS_in_entryRuleRealizedVariableCS2995 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRealizedVariableCS3005 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_40_in_ruleRealizedVariableCS3042 = new BitSet(new long[]{0x000001F898050030L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleRealizedVariableCS3063 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_32_in_ruleRealizedVariableCS3075 = new BitSet(new long[]{0xFE0007FCB80500F0L,0x000000000042787FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleRealizedVariableCS3096 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnnamedDomainCS_in_entryRuleUnnamedDomainCS3132 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnnamedDomainCS3142 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGuardPatternCS_in_ruleUnnamedDomainCS3200 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_ruleBottomPatternCS_in_ruleUnnamedDomainCS3221 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_entryRuleUnrestrictedName3258 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnrestrictedName3269 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLUnrestrictedName_in_ruleUnrestrictedName3316 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_ruleUnrestrictedName3340 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_ruleUnrestrictedName3359 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_ruleUnrestrictedName3378 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_ruleUnrestrictedName3397 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_ruleUnrestrictedName3416 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleUnrestrictedName3435 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_ruleUnrestrictedName3454 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_40_in_ruleUnrestrictedName3473 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleUnrestrictedName3492 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_39_in_ruleUnrestrictedName3511 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_ruleUnrestrictedName3530 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleID_in_entryRuleID3573 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleID3584 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_SIMPLE_ID_in_ruleID3624 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ESCAPED_ID_in_ruleID3650 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLOWER_in_entryRuleLOWER3696 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLOWER3707 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleLOWER3746 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUPPER_in_entryRuleUPPER3791 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUPPER3802 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleUPPER3842 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_ruleUPPER3866 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNUMBER_LITERAL_in_entryRuleNUMBER_LITERAL3907 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNUMBER_LITERAL3918 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleNUMBER_LITERAL3957 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleURI_in_entryRuleURI4002 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleURI4013 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_SINGLE_QUOTED_STRING_in_ruleURI4052 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLUnaryOperatorCS_in_entryRuleEssentialOCLUnaryOperatorCS4098 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEssentialOCLUnaryOperatorCS4108 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_41_in_ruleEssentialOCLUnaryOperatorCS4152 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_42_in_ruleEssentialOCLUnaryOperatorCS4181 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLInfixOperatorCS_in_entryRuleEssentialOCLInfixOperatorCS4232 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEssentialOCLInfixOperatorCS4242 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_ruleEssentialOCLInfixOperatorCS4286 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_43_in_ruleEssentialOCLInfixOperatorCS4315 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_44_in_ruleEssentialOCLInfixOperatorCS4344 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_41_in_ruleEssentialOCLInfixOperatorCS4373 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_45_in_ruleEssentialOCLInfixOperatorCS4402 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_46_in_ruleEssentialOCLInfixOperatorCS4431 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_47_in_ruleEssentialOCLInfixOperatorCS4460 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_48_in_ruleEssentialOCLInfixOperatorCS4489 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_49_in_ruleEssentialOCLInfixOperatorCS4518 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_50_in_ruleEssentialOCLInfixOperatorCS4547 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_51_in_ruleEssentialOCLInfixOperatorCS4576 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_52_in_ruleEssentialOCLInfixOperatorCS4605 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_53_in_ruleEssentialOCLInfixOperatorCS4634 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_54_in_ruleEssentialOCLInfixOperatorCS4663 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLNavigationOperatorCS_in_entryRuleEssentialOCLNavigationOperatorCS4714 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEssentialOCLNavigationOperatorCS4724 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_55_in_ruleEssentialOCLNavigationOperatorCS4768 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_56_in_ruleEssentialOCLNavigationOperatorCS4797 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_entryRuleIdentifier4849 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIdentifier4860 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleID_in_ruleIdentifier4906 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral4951 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteral4962 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_SINGLE_QUOTED_STRING_in_ruleStringLiteral5001 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBinaryOperatorCS_in_entryRuleBinaryOperatorCS5045 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBinaryOperatorCS5055 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInfixOperatorCS_in_ruleBinaryOperatorCS5105 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigationOperatorCS_in_ruleBinaryOperatorCS5135 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInfixOperatorCS_in_entryRuleInfixOperatorCS5170 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleInfixOperatorCS5180 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLInfixOperatorCS_in_ruleInfixOperatorCS5229 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigationOperatorCS_in_entryRuleNavigationOperatorCS5263 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigationOperatorCS5273 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLNavigationOperatorCS_in_ruleNavigationOperatorCS5322 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnaryOperatorCS_in_entryRuleUnaryOperatorCS5356 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnaryOperatorCS5366 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLUnaryOperatorCS_in_ruleUnaryOperatorCS5415 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLUnrestrictedName_in_entryRuleEssentialOCLUnrestrictedName5450 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEssentialOCLUnrestrictedName5461 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_ruleEssentialOCLUnrestrictedName5507 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLUnreservedName_in_entryRuleEssentialOCLUnreservedName5552 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEssentialOCLUnreservedName5563 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleEssentialOCLUnreservedName5610 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionTypeIdentifier_in_ruleEssentialOCLUnreservedName5643 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveTypeIdentifier_in_ruleEssentialOCLUnreservedName5676 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_57_in_ruleEssentialOCLUnreservedName5700 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnreservedName_in_entryRuleUnreservedName5741 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnreservedName5752 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLUnreservedName_in_ruleUnreservedName5798 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePathNameCS_in_entryRulePathNameCS5842 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePathNameCS5852 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFirstPathElementCS_in_rulePathNameCS5898 = new BitSet(new long[]{0x0000000200000002L});
        public static final BitSet FOLLOW_33_in_rulePathNameCS5911 = new BitSet(new long[]{0xFE0001F898050030L,0x000000000000007FL});
        public static final BitSet FOLLOW_ruleNextPathElementCS_in_rulePathNameCS5932 = new BitSet(new long[]{0x0000000200000002L});
        public static final BitSet FOLLOW_ruleFirstPathElementCS_in_entryRuleFirstPathElementCS5970 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFirstPathElementCS5980 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleFirstPathElementCS6031 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNextPathElementCS_in_entryRuleNextPathElementCS6066 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNextPathElementCS6076 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnreservedName_in_ruleNextPathElementCS6127 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleURIPathNameCS_in_entryRuleURIPathNameCS6162 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleURIPathNameCS6172 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleURIFirstPathElementCS_in_ruleURIPathNameCS6218 = new BitSet(new long[]{0x0000000200000002L});
        public static final BitSet FOLLOW_33_in_ruleURIPathNameCS6231 = new BitSet(new long[]{0xFE0001F898050030L,0x000000000000007FL});
        public static final BitSet FOLLOW_ruleNextPathElementCS_in_ruleURIPathNameCS6252 = new BitSet(new long[]{0x0000000200000002L});
        public static final BitSet FOLLOW_ruleURIFirstPathElementCS_in_entryRuleURIFirstPathElementCS6290 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleURIFirstPathElementCS6300 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleURIFirstPathElementCS6352 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleURI_in_ruleURIFirstPathElementCS6398 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveTypeIdentifier_in_entryRulePrimitiveTypeIdentifier6436 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrimitiveTypeIdentifier6447 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_58_in_rulePrimitiveTypeIdentifier6485 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_59_in_rulePrimitiveTypeIdentifier6504 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_60_in_rulePrimitiveTypeIdentifier6523 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_61_in_rulePrimitiveTypeIdentifier6542 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_62_in_rulePrimitiveTypeIdentifier6561 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_63_in_rulePrimitiveTypeIdentifier6580 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_64_in_rulePrimitiveTypeIdentifier6599 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_65_in_rulePrimitiveTypeIdentifier6618 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveTypeCS_in_entryRulePrimitiveTypeCS6658 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrimitiveTypeCS6668 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveTypeIdentifier_in_rulePrimitiveTypeCS6713 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionTypeIdentifier_in_entryRuleCollectionTypeIdentifier6749 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCollectionTypeIdentifier6760 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_66_in_ruleCollectionTypeIdentifier6798 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_67_in_ruleCollectionTypeIdentifier6817 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_68_in_ruleCollectionTypeIdentifier6836 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_69_in_ruleCollectionTypeIdentifier6855 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_70_in_ruleCollectionTypeIdentifier6874 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionTypeCS_in_entryRuleCollectionTypeCS6914 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCollectionTypeCS6924 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionTypeIdentifier_in_ruleCollectionTypeCS6970 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_29_in_ruleCollectionTypeCS6983 = new BitSet(new long[]{0xFE0007FCB80500F0L,0x000000000042787FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleCollectionTypeCS7004 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_30_in_ruleCollectionTypeCS7016 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiplicityBoundsCS_in_entryRuleMultiplicityBoundsCS7054 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicityBoundsCS7064 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLOWER_in_ruleMultiplicityBoundsCS7110 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
        public static final BitSet FOLLOW_71_in_ruleMultiplicityBoundsCS7123 = new BitSet(new long[]{0x0000000400000040L});
        public static final BitSet FOLLOW_ruleUPPER_in_ruleMultiplicityBoundsCS7144 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiplicityCS_in_entryRuleMultiplicityCS7182 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicityCS7192 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_72_in_ruleMultiplicityCS7229 = new BitSet(new long[]{0x0000100400000040L,0x0000000000000400L});
        public static final BitSet FOLLOW_ruleMultiplicityBoundsCS_in_ruleMultiplicityCS7255 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
        public static final BitSet FOLLOW_ruleMultiplicityStringCS_in_ruleMultiplicityCS7285 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
        public static final BitSet FOLLOW_73_in_ruleMultiplicityCS7297 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiplicityStringCS_in_entryRuleMultiplicityStringCS7333 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicityStringCS7343 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_ruleMultiplicityStringCS7387 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_44_in_ruleMultiplicityStringCS7416 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_74_in_ruleMultiplicityStringCS7445 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTupleTypeCS_in_entryRuleTupleTypeCS7496 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTupleTypeCS7506 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_57_in_ruleTupleTypeCS7549 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_29_in_ruleTupleTypeCS7575 = new BitSet(new long[]{0x000001F8D8050030L});
        public static final BitSet FOLLOW_ruleTuplePartCS_in_ruleTupleTypeCS7597 = new BitSet(new long[]{0x0000000040080000L});
        public static final BitSet FOLLOW_19_in_ruleTupleTypeCS7610 = new BitSet(new long[]{0x000001F898050030L});
        public static final BitSet FOLLOW_ruleTuplePartCS_in_ruleTupleTypeCS7631 = new BitSet(new long[]{0x0000000040080000L});
        public static final BitSet FOLLOW_30_in_ruleTupleTypeCS7647 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTuplePartCS_in_entryRuleTuplePartCS7685 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTuplePartCS7695 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleTuplePartCS7741 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_32_in_ruleTuplePartCS7753 = new BitSet(new long[]{0xFE0007FCB80500F0L,0x000000000042787FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleTuplePartCS7774 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionLiteralExpCS_in_entryRuleCollectionLiteralExpCS7810 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCollectionLiteralExpCS7820 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionTypeCS_in_ruleCollectionLiteralExpCS7866 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleCollectionLiteralExpCS7878 = new BitSet(new long[]{0xFE0007FCB94500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleCollectionLiteralPartCS_in_ruleCollectionLiteralExpCS7900 = new BitSet(new long[]{0x0000000000480000L});
        public static final BitSet FOLLOW_19_in_ruleCollectionLiteralExpCS7913 = new BitSet(new long[]{0xFE0007FCB90500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleCollectionLiteralPartCS_in_ruleCollectionLiteralExpCS7934 = new BitSet(new long[]{0x0000000000480000L});
        public static final BitSet FOLLOW_22_in_ruleCollectionLiteralExpCS7950 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionLiteralPartCS_in_entryRuleCollectionLiteralPartCS7986 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCollectionLiteralPartCS7996 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleCollectionLiteralPartCS8042 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
        public static final BitSet FOLLOW_71_in_ruleCollectionLiteralPartCS8055 = new BitSet(new long[]{0xFE0007FCB90500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleCollectionLiteralPartCS8076 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConstructorPartCS_in_entryRuleConstructorPartCS8114 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleConstructorPartCS8124 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleConstructorPartCS8176 = new BitSet(new long[]{0x0002000000000000L});
        public static final BitSet FOLLOW_49_in_ruleConstructorPartCS8188 = new BitSet(new long[]{0xFE0007FCB90500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleConstructorPartCS8209 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveLiteralExpCS_in_entryRulePrimitiveLiteralExpCS8245 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrimitiveLiteralExpCS8255 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNumberLiteralExpCS_in_rulePrimitiveLiteralExpCS8305 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringLiteralExpCS_in_rulePrimitiveLiteralExpCS8335 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBooleanLiteralExpCS_in_rulePrimitiveLiteralExpCS8365 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnlimitedNaturalLiteralExpCS_in_rulePrimitiveLiteralExpCS8395 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInvalidLiteralExpCS_in_rulePrimitiveLiteralExpCS8425 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNullLiteralExpCS_in_rulePrimitiveLiteralExpCS8455 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTupleLiteralExpCS_in_entryRuleTupleLiteralExpCS8490 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTupleLiteralExpCS8500 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_57_in_ruleTupleLiteralExpCS8537 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleTupleLiteralExpCS8549 = new BitSet(new long[]{0x000001F898050030L});
        public static final BitSet FOLLOW_ruleTupleLiteralPartCS_in_ruleTupleLiteralExpCS8570 = new BitSet(new long[]{0x0000000000480000L});
        public static final BitSet FOLLOW_19_in_ruleTupleLiteralExpCS8583 = new BitSet(new long[]{0x000001F898050030L});
        public static final BitSet FOLLOW_ruleTupleLiteralPartCS_in_ruleTupleLiteralExpCS8604 = new BitSet(new long[]{0x0000000000480000L});
        public static final BitSet FOLLOW_22_in_ruleTupleLiteralExpCS8618 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTupleLiteralPartCS_in_entryRuleTupleLiteralPartCS8654 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTupleLiteralPartCS8664 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleTupleLiteralPartCS8710 = new BitSet(new long[]{0x0002000100000000L});
        public static final BitSet FOLLOW_32_in_ruleTupleLiteralPartCS8723 = new BitSet(new long[]{0xFE0007FCB80500F0L,0x000000000042787FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleTupleLiteralPartCS8744 = new BitSet(new long[]{0x0002000000000000L});
        public static final BitSet FOLLOW_49_in_ruleTupleLiteralPartCS8758 = new BitSet(new long[]{0xFE0007FCB90500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleTupleLiteralPartCS8779 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNumberLiteralExpCS_in_entryRuleNumberLiteralExpCS8815 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNumberLiteralExpCS8825 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNUMBER_LITERAL_in_ruleNumberLiteralExpCS8870 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringLiteralExpCS_in_entryRuleStringLiteralExpCS8905 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteralExpCS8915 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringLiteral_in_ruleStringLiteralExpCS8960 = new BitSet(new long[]{0x0000000000000082L});
        public static final BitSet FOLLOW_ruleBooleanLiteralExpCS_in_entryRuleBooleanLiteralExpCS8996 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBooleanLiteralExpCS9006 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_75_in_ruleBooleanLiteralExpCS9049 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_76_in_ruleBooleanLiteralExpCS9086 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnlimitedNaturalLiteralExpCS_in_entryRuleUnlimitedNaturalLiteralExpCS9135 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnlimitedNaturalLiteralExpCS9145 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_ruleUnlimitedNaturalLiteralExpCS9194 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInvalidLiteralExpCS_in_entryRuleInvalidLiteralExpCS9230 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleInvalidLiteralExpCS9240 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_77_in_ruleInvalidLiteralExpCS9289 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNullLiteralExpCS_in_entryRuleNullLiteralExpCS9325 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNullLiteralExpCS9335 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_78_in_ruleNullLiteralExpCS9384 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralCS_in_entryRuleTypeLiteralCS9420 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeLiteralCS9430 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveTypeCS_in_ruleTypeLiteralCS9480 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionTypeCS_in_ruleTypeLiteralCS9510 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTupleTypeCS_in_ruleTypeLiteralCS9540 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralWithMultiplicityCS_in_entryRuleTypeLiteralWithMultiplicityCS9575 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeLiteralWithMultiplicityCS9585 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralCS_in_ruleTypeLiteralWithMultiplicityCS9635 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000100L});
        public static final BitSet FOLLOW_ruleMultiplicityCS_in_ruleTypeLiteralWithMultiplicityCS9655 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralExpCS_in_entryRuleTypeLiteralExpCS9692 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeLiteralExpCS9702 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralWithMultiplicityCS_in_ruleTypeLiteralExpCS9747 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeNameExpCS_in_entryRuleTypeNameExpCS9782 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeNameExpCS9792 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePathNameCS_in_ruleTypeNameExpCS9837 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_entryRuleTypeExpCS9872 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeExpCS9882 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeNameExpCS_in_ruleTypeExpCS9933 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000100L});
        public static final BitSet FOLLOW_ruleTypeLiteralCS_in_ruleTypeExpCS9963 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000100L});
        public static final BitSet FOLLOW_ruleMultiplicityCS_in_ruleTypeExpCS9984 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpCS_in_entryRuleExpCS10021 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleExpCS10031 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrefixedExpCS_in_ruleExpCS10082 = new BitSet(new long[]{0x01FFFA0400000002L});
        public static final BitSet FOLLOW_ruleBinaryOperatorCS_in_ruleExpCS10115 = new BitSet(new long[]{0xFE0007FCB90500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_rulePrefixedExpCS_in_ruleExpCS10138 = new BitSet(new long[]{0x01FFFA0400000002L});
        public static final BitSet FOLLOW_ruleBinaryOperatorCS_in_ruleExpCS10160 = new BitSet(new long[]{0xFE0007FCB80500F0L,0x000000000042787FL});
        public static final BitSet FOLLOW_rulePrefixedExpCS_in_ruleExpCS10181 = new BitSet(new long[]{0x01FFFA0400000002L});
        public static final BitSet FOLLOW_ruleBinaryOperatorCS_in_ruleExpCS10205 = new BitSet(new long[]{0xFE0007FCB90500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleLetExpCS_in_ruleExpCS10226 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLetExpCS_in_ruleExpCS10256 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnaryOperatorCS_in_ruleExpCS10300 = new BitSet(new long[]{0xFE0007FCB90500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleLetExpCS_in_ruleExpCS10322 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLetExpCS_in_ruleExpCS10354 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrefixedExpCS_in_entryRulePrefixedExpCS10389 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrefixedExpCS10399 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnaryOperatorCS_in_rulePrefixedExpCS10458 = new BitSet(new long[]{0xFE0007FCB80500F0L,0x000000000042787FL});
        public static final BitSet FOLLOW_rulePrimaryExpCS_in_rulePrefixedExpCS10480 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimaryExpCS_in_rulePrefixedExpCS10512 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimaryExpCS_in_entryRulePrimaryExpCS10547 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpCS10557 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedExpCS_in_rulePrimaryExpCS10607 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIfExpCS_in_rulePrimaryExpCS10637 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSelfExpCS_in_rulePrimaryExpCS10667 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveLiteralExpCS_in_rulePrimaryExpCS10697 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTupleLiteralExpCS_in_rulePrimaryExpCS10727 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionLiteralExpCS_in_rulePrimaryExpCS10757 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralExpCS_in_rulePrimaryExpCS10787 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNameExpCS_in_rulePrimaryExpCS10817 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNameExpCS_in_entryRuleNameExpCS10852 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNameExpCS10862 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePathNameCS_in_ruleNameExpCS10908 = new BitSet(new long[]{0x0000000020100002L,0x0000000000008100L});
        public static final BitSet FOLLOW_ruleSquareBracketedClauseCS_in_ruleNameExpCS10929 = new BitSet(new long[]{0x0000000020100002L,0x0000000000008100L});
        public static final BitSet FOLLOW_ruleRoundBracketedClauseCS_in_ruleNameExpCS10951 = new BitSet(new long[]{0x0000000000100002L,0x0000000000008000L});
        public static final BitSet FOLLOW_ruleCurlyBracketedClauseCS_in_ruleNameExpCS10973 = new BitSet(new long[]{0x0000000000000002L,0x0000000000008000L});
        public static final BitSet FOLLOW_79_in_ruleNameExpCS10993 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
        public static final BitSet FOLLOW_80_in_ruleNameExpCS11018 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCurlyBracketedClauseCS_in_entryRuleCurlyBracketedClauseCS11056 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCurlyBracketedClauseCS11066 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleCurlyBracketedClauseCS11115 = new BitSet(new long[]{0x000001F8984500B0L});
        public static final BitSet FOLLOW_ruleConstructorPartCS_in_ruleCurlyBracketedClauseCS11138 = new BitSet(new long[]{0x0000000000480000L});
        public static final BitSet FOLLOW_19_in_ruleCurlyBracketedClauseCS11151 = new BitSet(new long[]{0x000001F898050030L});
        public static final BitSet FOLLOW_ruleConstructorPartCS_in_ruleCurlyBracketedClauseCS11172 = new BitSet(new long[]{0x0000000000480000L});
        public static final BitSet FOLLOW_ruleStringLiteral_in_ruleCurlyBracketedClauseCS11203 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_22_in_ruleCurlyBracketedClauseCS11216 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRoundBracketedClauseCS_in_entryRuleRoundBracketedClauseCS11252 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRoundBracketedClauseCS11262 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_ruleRoundBracketedClauseCS11311 = new BitSet(new long[]{0xFE0007FCF90500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleNavigatingArgCS_in_ruleRoundBracketedClauseCS11333 = new BitSet(new long[]{0x0000000044880000L});
        public static final BitSet FOLLOW_ruleNavigatingCommaArgCS_in_ruleRoundBracketedClauseCS11354 = new BitSet(new long[]{0x0000000044880000L});
        public static final BitSet FOLLOW_ruleNavigatingSemiArgCS_in_ruleRoundBracketedClauseCS11377 = new BitSet(new long[]{0x0000000040880000L});
        public static final BitSet FOLLOW_ruleNavigatingCommaArgCS_in_ruleRoundBracketedClauseCS11398 = new BitSet(new long[]{0x0000000040880000L});
        public static final BitSet FOLLOW_ruleNavigatingBarArgCS_in_ruleRoundBracketedClauseCS11423 = new BitSet(new long[]{0x0000000040080000L});
        public static final BitSet FOLLOW_ruleNavigatingCommaArgCS_in_ruleRoundBracketedClauseCS11444 = new BitSet(new long[]{0x0000000040080000L});
        public static final BitSet FOLLOW_30_in_ruleRoundBracketedClauseCS11461 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSquareBracketedClauseCS_in_entryRuleSquareBracketedClauseCS11497 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSquareBracketedClauseCS11507 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_72_in_ruleSquareBracketedClauseCS11544 = new BitSet(new long[]{0xFE0007FCB90500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleSquareBracketedClauseCS11565 = new BitSet(new long[]{0x0000000000080000L,0x0000000000000200L});
        public static final BitSet FOLLOW_19_in_ruleSquareBracketedClauseCS11578 = new BitSet(new long[]{0xFE0007FCB90500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleSquareBracketedClauseCS11599 = new BitSet(new long[]{0x0000000000080000L,0x0000000000000200L});
        public static final BitSet FOLLOW_73_in_ruleSquareBracketedClauseCS11613 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingArgCS_in_entryRuleNavigatingArgCS11649 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigatingArgCS11659 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingArgCS11705 = new BitSet(new long[]{0x0000000100000002L});
        public static final BitSet FOLLOW_32_in_ruleNavigatingArgCS11718 = new BitSet(new long[]{0xFE0007FCB80500F0L,0x000000000042787FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleNavigatingArgCS11739 = new BitSet(new long[]{0x0002000000000002L});
        public static final BitSet FOLLOW_49_in_ruleNavigatingArgCS11752 = new BitSet(new long[]{0xFE0007FCB90500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNavigatingArgCS11773 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingBarArgCS_in_entryRuleNavigatingBarArgCS11813 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigatingBarArgCS11823 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_ruleNavigatingBarArgCS11866 = new BitSet(new long[]{0xFE0007FCB90500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingBarArgCS11900 = new BitSet(new long[]{0x0000000100000002L});
        public static final BitSet FOLLOW_32_in_ruleNavigatingBarArgCS11913 = new BitSet(new long[]{0xFE0007FCB80500F0L,0x000000000042787FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleNavigatingBarArgCS11934 = new BitSet(new long[]{0x0002000000000002L});
        public static final BitSet FOLLOW_49_in_ruleNavigatingBarArgCS11947 = new BitSet(new long[]{0xFE0007FCB90500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNavigatingBarArgCS11968 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingCommaArgCS_in_entryRuleNavigatingCommaArgCS12008 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigatingCommaArgCS12018 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleNavigatingCommaArgCS12061 = new BitSet(new long[]{0xFE0007FCB90500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingCommaArgCS12095 = new BitSet(new long[]{0x0000000100000002L});
        public static final BitSet FOLLOW_32_in_ruleNavigatingCommaArgCS12108 = new BitSet(new long[]{0xFE0007FCB80500F0L,0x000000000042787FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleNavigatingCommaArgCS12129 = new BitSet(new long[]{0x0002000000000002L});
        public static final BitSet FOLLOW_49_in_ruleNavigatingCommaArgCS12142 = new BitSet(new long[]{0xFE0007FCB90500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNavigatingCommaArgCS12163 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingSemiArgCS_in_entryRuleNavigatingSemiArgCS12203 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigatingSemiArgCS12213 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_ruleNavigatingSemiArgCS12256 = new BitSet(new long[]{0xFE0007FCB90500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingSemiArgCS12290 = new BitSet(new long[]{0x0000000100000002L});
        public static final BitSet FOLLOW_32_in_ruleNavigatingSemiArgCS12303 = new BitSet(new long[]{0xFE0007FCB80500F0L,0x000000000042787FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleNavigatingSemiArgCS12324 = new BitSet(new long[]{0x0002000000000002L});
        public static final BitSet FOLLOW_49_in_ruleNavigatingSemiArgCS12337 = new BitSet(new long[]{0xFE0007FCB90500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNavigatingSemiArgCS12358 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingArgExpCS_in_entryRuleNavigatingArgExpCS12398 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigatingArgExpCS12408 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNavigatingArgExpCS12457 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIfExpCS_in_entryRuleIfExpCS12491 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIfExpCS12501 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_81_in_ruleIfExpCS12538 = new BitSet(new long[]{0xFE0007FCB90500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleIfExpCS12559 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
        public static final BitSet FOLLOW_82_in_ruleIfExpCS12571 = new BitSet(new long[]{0xFE0007FCB90500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleIfExpCS12592 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
        public static final BitSet FOLLOW_83_in_ruleIfExpCS12604 = new BitSet(new long[]{0xFE0007FCB90500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleIfExpCS12625 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
        public static final BitSet FOLLOW_84_in_ruleIfExpCS12637 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLetExpCS_in_entryRuleLetExpCS12673 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLetExpCS12683 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_85_in_ruleLetExpCS12720 = new BitSet(new long[]{0x000001F898050030L});
        public static final BitSet FOLLOW_ruleLetVariableCS_in_ruleLetExpCS12741 = new BitSet(new long[]{0x00000000000A0000L});
        public static final BitSet FOLLOW_19_in_ruleLetExpCS12754 = new BitSet(new long[]{0x000001F898050030L});
        public static final BitSet FOLLOW_ruleLetVariableCS_in_ruleLetExpCS12775 = new BitSet(new long[]{0x00000000000A0000L});
        public static final BitSet FOLLOW_17_in_ruleLetExpCS12789 = new BitSet(new long[]{0xFE0007FCB90500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleLetExpCS12810 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLetVariableCS_in_entryRuleLetVariableCS12846 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLetVariableCS12856 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleLetVariableCS12902 = new BitSet(new long[]{0x0002000100000000L});
        public static final BitSet FOLLOW_32_in_ruleLetVariableCS12915 = new BitSet(new long[]{0xFE0007FCB80500F0L,0x000000000042787FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleLetVariableCS12936 = new BitSet(new long[]{0x0002000000000000L});
        public static final BitSet FOLLOW_49_in_ruleLetVariableCS12950 = new BitSet(new long[]{0xFE0007FCB90500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleLetVariableCS12971 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedExpCS_in_entryRuleNestedExpCS13007 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNestedExpCS13017 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_ruleNestedExpCS13054 = new BitSet(new long[]{0xFE0007FCB90500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNestedExpCS13075 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_30_in_ruleNestedExpCS13087 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSelfExpCS_in_entryRuleSelfExpCS13123 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSelfExpCS13133 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_86_in_ruleSelfExpCS13182 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTupleLiteralExpCS_in_synpred123_InternalQVTcore10727 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionLiteralExpCS_in_synpred124_InternalQVTcore10757 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralExpCS_in_synpred125_InternalQVTcore10787 = new BitSet(new long[]{0x0000000000000002L});
    }


}