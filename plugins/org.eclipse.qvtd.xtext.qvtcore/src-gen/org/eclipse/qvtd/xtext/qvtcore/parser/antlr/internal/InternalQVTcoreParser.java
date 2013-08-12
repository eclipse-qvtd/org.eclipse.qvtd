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
    public static final int T__42=42;
    public static final int T__86=86;
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

                if ( (LA3_2==18) ) {
                    int LA3_4 = input.LA(3);

                    if ( ((LA3_4>=RULE_SIMPLE_ID && LA3_4<=RULE_ESCAPED_ID)||LA3_4==16||LA3_4==18||(LA3_4>=27 && LA3_4<=28)||LA3_4==31||(LA3_4>=35 && LA3_4<=40)) ) {
                        alt3=1;
                    }
                }
                else if ( (LA3_2==17||LA3_2==20) ) {
                    alt3=1;
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

                        if ( (LA10_2==32) ) {
                            alt10=1;
                        }
                        else if ( ((LA10_2>=RULE_SIMPLE_ID && LA10_2<=RULE_ESCAPED_ID)||LA10_2==16||LA10_2==18||(LA10_2>=27 && LA10_2<=28)||LA10_2==31||(LA10_2>=35 && LA10_2<=40)) ) {
                            alt10=2;
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

                    	        if ( ((LA11_2>=RULE_SIMPLE_ID && LA11_2<=RULE_ESCAPED_ID)||LA11_2==16||LA11_2==18||(LA11_2>=27 && LA11_2<=28)||LA11_2==31||(LA11_2>=35 && LA11_2<=40)) ) {
                    	            alt11=2;
                    	        }
                    	        else if ( (LA11_2==32) ) {
                    	            alt11=1;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:761:1: ruleGuardPatternCS returns [EObject current=null] : ( (otherlv_0= '(' ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) (otherlv_2= ',' ( (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS ) ) )* otherlv_4= '|' ( (lv_constraints_5_0= ruleAssignmentCS ) )* otherlv_6= ')' ) | ( () otherlv_8= '(' ( (lv_constraints_9_0= ruleAssignmentCS ) )* otherlv_10= ')' ) ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:764:28: ( ( (otherlv_0= '(' ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) (otherlv_2= ',' ( (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS ) ) )* otherlv_4= '|' ( (lv_constraints_5_0= ruleAssignmentCS ) )* otherlv_6= ')' ) | ( () otherlv_8= '(' ( (lv_constraints_9_0= ruleAssignmentCS ) )* otherlv_10= ')' ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:765:1: ( (otherlv_0= '(' ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) (otherlv_2= ',' ( (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS ) ) )* otherlv_4= '|' ( (lv_constraints_5_0= ruleAssignmentCS ) )* otherlv_6= ')' ) | ( () otherlv_8= '(' ( (lv_constraints_9_0= ruleAssignmentCS ) )* otherlv_10= ')' ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:765:1: ( (otherlv_0= '(' ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) (otherlv_2= ',' ( (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS ) ) )* otherlv_4= '|' ( (lv_constraints_5_0= ruleAssignmentCS ) )* otherlv_6= ')' ) | ( () otherlv_8= '(' ( (lv_constraints_9_0= ruleAssignmentCS ) )* otherlv_10= ')' ) )
            int alt26=2;
            alt26 = dfa26.predict(input);
            switch (alt26) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:765:2: (otherlv_0= '(' ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) (otherlv_2= ',' ( (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS ) ) )* otherlv_4= '|' ( (lv_constraints_5_0= ruleAssignmentCS ) )* otherlv_6= ')' )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:765:2: (otherlv_0= '(' ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) (otherlv_2= ',' ( (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS ) ) )* otherlv_4= '|' ( (lv_constraints_5_0= ruleAssignmentCS ) )* otherlv_6= ')' )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:765:4: otherlv_0= '(' ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) (otherlv_2= ',' ( (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS ) ) )* otherlv_4= '|' ( (lv_constraints_5_0= ruleAssignmentCS ) )* otherlv_6= ')'
                    {
                    otherlv_0=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleGuardPatternCS1433); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getGuardPatternCSAccess().getLeftParenthesisKeyword_0_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:769:1: ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:770:1: (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:770:1: (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:771:3: lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getGuardPatternCSAccess().getUnrealizedVariablesUnrealizedVariableCSParserRuleCall_0_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUnrealizedVariableCS_in_ruleGuardPatternCS1454);
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

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:787:2: (otherlv_2= ',' ( (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS ) ) )*
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==19) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:787:4: otherlv_2= ',' ( (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS ) )
                    	    {
                    	    otherlv_2=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleGuardPatternCS1467); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_2, grammarAccess.getGuardPatternCSAccess().getCommaKeyword_0_2_0());
                    	          
                    	    }
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:791:1: ( (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS ) )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:792:1: (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS )
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:792:1: (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:793:3: lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getGuardPatternCSAccess().getUnrealizedVariablesUnrealizedVariableCSParserRuleCall_0_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleUnrealizedVariableCS_in_ruleGuardPatternCS1488);
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
                    	    break loop23;
                        }
                    } while (true);

                    otherlv_4=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleGuardPatternCS1502); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getGuardPatternCSAccess().getVerticalLineKeyword_0_3());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:813:1: ( (lv_constraints_5_0= ruleAssignmentCS ) )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( ((LA24_0>=RULE_SIMPLE_ID && LA24_0<=RULE_SINGLE_QUOTED_STRING)||LA24_0==16||LA24_0==18||LA24_0==24||(LA24_0>=27 && LA24_0<=29)||LA24_0==31||(LA24_0>=34 && LA24_0<=42)||(LA24_0>=57 && LA24_0<=70)||(LA24_0>=75 && LA24_0<=78)||LA24_0==81||(LA24_0>=85 && LA24_0<=86)) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:814:1: (lv_constraints_5_0= ruleAssignmentCS )
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:814:1: (lv_constraints_5_0= ruleAssignmentCS )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:815:3: lv_constraints_5_0= ruleAssignmentCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getGuardPatternCSAccess().getConstraintsAssignmentCSParserRuleCall_0_4_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleAssignmentCS_in_ruleGuardPatternCS1523);
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
                    	    break loop24;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleGuardPatternCS1536); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getGuardPatternCSAccess().getRightParenthesisKeyword_0_5());
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:836:6: ( () otherlv_8= '(' ( (lv_constraints_9_0= ruleAssignmentCS ) )* otherlv_10= ')' )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:836:6: ( () otherlv_8= '(' ( (lv_constraints_9_0= ruleAssignmentCS ) )* otherlv_10= ')' )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:836:7: () otherlv_8= '(' ( (lv_constraints_9_0= ruleAssignmentCS ) )* otherlv_10= ')'
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:836:7: ()
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:837:2: 
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

                    otherlv_8=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleGuardPatternCS1568); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getGuardPatternCSAccess().getLeftParenthesisKeyword_1_1());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:849:1: ( (lv_constraints_9_0= ruleAssignmentCS ) )*
                    loop25:
                    do {
                        int alt25=2;
                        int LA25_0 = input.LA(1);

                        if ( ((LA25_0>=RULE_SIMPLE_ID && LA25_0<=RULE_SINGLE_QUOTED_STRING)||LA25_0==16||LA25_0==18||LA25_0==24||(LA25_0>=27 && LA25_0<=29)||LA25_0==31||(LA25_0>=34 && LA25_0<=42)||(LA25_0>=57 && LA25_0<=70)||(LA25_0>=75 && LA25_0<=78)||LA25_0==81||(LA25_0>=85 && LA25_0<=86)) ) {
                            alt25=1;
                        }


                        switch (alt25) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:850:1: (lv_constraints_9_0= ruleAssignmentCS )
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:850:1: (lv_constraints_9_0= ruleAssignmentCS )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:851:3: lv_constraints_9_0= ruleAssignmentCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getGuardPatternCSAccess().getConstraintsAssignmentCSParserRuleCall_1_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleAssignmentCS_in_ruleGuardPatternCS1589);
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
                    	    break loop25;
                        }
                    } while (true);

                    otherlv_10=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleGuardPatternCS1602); if (state.failed) return current;
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


    // $ANTLR start "entryRuleImportCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:879:1: entryRuleImportCS returns [EObject current=null] : iv_ruleImportCS= ruleImportCS EOF ;
    public final EObject entryRuleImportCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:880:2: (iv_ruleImportCS= ruleImportCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:881:2: iv_ruleImportCS= ruleImportCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImportCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleImportCS_in_entryRuleImportCS1639);
            iv_ruleImportCS=ruleImportCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImportCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleImportCS1649); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:888:1: ruleImportCS returns [EObject current=null] : (otherlv_0= 'import' ( ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= ':' )? ( (lv_pathName_3_0= ruleURIPathNameCS ) ) ( ( (lv_all_4_0= '::' ) ) otherlv_5= '*' )? otherlv_6= ';' ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:891:28: ( (otherlv_0= 'import' ( ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= ':' )? ( (lv_pathName_3_0= ruleURIPathNameCS ) ) ( ( (lv_all_4_0= '::' ) ) otherlv_5= '*' )? otherlv_6= ';' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:892:1: (otherlv_0= 'import' ( ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= ':' )? ( (lv_pathName_3_0= ruleURIPathNameCS ) ) ( ( (lv_all_4_0= '::' ) ) otherlv_5= '*' )? otherlv_6= ';' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:892:1: (otherlv_0= 'import' ( ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= ':' )? ( (lv_pathName_3_0= ruleURIPathNameCS ) ) ( ( (lv_all_4_0= '::' ) ) otherlv_5= '*' )? otherlv_6= ';' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:892:3: otherlv_0= 'import' ( ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= ':' )? ( (lv_pathName_3_0= ruleURIPathNameCS ) ) ( ( (lv_all_4_0= '::' ) ) otherlv_5= '*' )? otherlv_6= ';'
            {
            otherlv_0=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleImportCS1686); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getImportCSAccess().getImportKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:896:1: ( ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= ':' )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==RULE_SIMPLE_ID) ) {
                int LA27_1 = input.LA(2);

                if ( (LA27_1==32) ) {
                    alt27=1;
                }
            }
            else if ( (LA27_0==RULE_ESCAPED_ID) ) {
                int LA27_2 = input.LA(2);

                if ( (LA27_2==32) ) {
                    alt27=1;
                }
            }
            switch (alt27) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:896:2: ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= ':'
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:896:2: ( (lv_name_1_0= ruleIdentifier ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:897:1: (lv_name_1_0= ruleIdentifier )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:897:1: (lv_name_1_0= ruleIdentifier )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:898:3: lv_name_1_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getImportCSAccess().getNameIdentifierParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_ruleImportCS1708);
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

                    otherlv_2=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleImportCS1720); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getImportCSAccess().getColonKeyword_1_1());
                          
                    }

                    }
                    break;

            }

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:918:3: ( (lv_pathName_3_0= ruleURIPathNameCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:919:1: (lv_pathName_3_0= ruleURIPathNameCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:919:1: (lv_pathName_3_0= ruleURIPathNameCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:920:3: lv_pathName_3_0= ruleURIPathNameCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getImportCSAccess().getPathNameURIPathNameCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleURIPathNameCS_in_ruleImportCS1743);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:936:2: ( ( (lv_all_4_0= '::' ) ) otherlv_5= '*' )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==33) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:936:3: ( (lv_all_4_0= '::' ) ) otherlv_5= '*'
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:936:3: ( (lv_all_4_0= '::' ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:937:1: (lv_all_4_0= '::' )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:937:1: (lv_all_4_0= '::' )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:938:3: lv_all_4_0= '::'
                    {
                    lv_all_4_0=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleImportCS1762); if (state.failed) return current;
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

                    otherlv_5=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleImportCS1787); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getImportCSAccess().getAsteriskKeyword_3_1());
                          
                    }

                    }
                    break;

            }

            otherlv_6=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleImportCS1801); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:967:1: entryRuleLibraryCS returns [EObject current=null] : iv_ruleLibraryCS= ruleLibraryCS EOF ;
    public final EObject entryRuleLibraryCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLibraryCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:968:2: (iv_ruleLibraryCS= ruleLibraryCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:969:2: iv_ruleLibraryCS= ruleLibraryCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLibraryCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibraryCS_in_entryRuleLibraryCS1837);
            iv_ruleLibraryCS=ruleLibraryCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLibraryCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibraryCS1847); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:976:1: ruleLibraryCS returns [EObject current=null] : (otherlv_0= 'library' ( ( ruleURI ) ) otherlv_2= ';' ) ;
    public final EObject ruleLibraryCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:979:28: ( (otherlv_0= 'library' ( ( ruleURI ) ) otherlv_2= ';' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:980:1: (otherlv_0= 'library' ( ( ruleURI ) ) otherlv_2= ';' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:980:1: (otherlv_0= 'library' ( ( ruleURI ) ) otherlv_2= ';' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:980:3: otherlv_0= 'library' ( ( ruleURI ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleLibraryCS1884); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLibraryCSAccess().getLibraryKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:984:1: ( ( ruleURI ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:985:1: ( ruleURI )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:985:1: ( ruleURI )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:986:3: ruleURI
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
            pushFollow(FollowSets000.FOLLOW_ruleURI_in_ruleLibraryCS1911);
            ruleURI();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleLibraryCS1923); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1014:1: entryRuleNamedDomainCS returns [EObject current=null] : iv_ruleNamedDomainCS= ruleNamedDomainCS EOF ;
    public final EObject entryRuleNamedDomainCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedDomainCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1015:2: (iv_ruleNamedDomainCS= ruleNamedDomainCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1016:2: iv_ruleNamedDomainCS= ruleNamedDomainCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNamedDomainCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNamedDomainCS_in_entryRuleNamedDomainCS1959);
            iv_ruleNamedDomainCS=ruleNamedDomainCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNamedDomainCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNamedDomainCS1969); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1023:1: ruleNamedDomainCS returns [EObject current=null] : ( ( (lv_check_0_0= 'check' ) )? ( (lv_enforce_1_0= 'enforce' ) )? ( ( ruleUnrestrictedName ) ) ( (lv_guardPattern_3_0= ruleGuardPatternCS ) ) ( (lv_bottomPattern_4_0= ruleBottomPatternCS ) ) ) ;
    public final EObject ruleNamedDomainCS() throws RecognitionException {
        EObject current = null;

        Token lv_check_0_0=null;
        Token lv_enforce_1_0=null;
        EObject lv_guardPattern_3_0 = null;

        EObject lv_bottomPattern_4_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1026:28: ( ( ( (lv_check_0_0= 'check' ) )? ( (lv_enforce_1_0= 'enforce' ) )? ( ( ruleUnrestrictedName ) ) ( (lv_guardPattern_3_0= ruleGuardPatternCS ) ) ( (lv_bottomPattern_4_0= ruleBottomPatternCS ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1027:1: ( ( (lv_check_0_0= 'check' ) )? ( (lv_enforce_1_0= 'enforce' ) )? ( ( ruleUnrestrictedName ) ) ( (lv_guardPattern_3_0= ruleGuardPatternCS ) ) ( (lv_bottomPattern_4_0= ruleBottomPatternCS ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1027:1: ( ( (lv_check_0_0= 'check' ) )? ( (lv_enforce_1_0= 'enforce' ) )? ( ( ruleUnrestrictedName ) ) ( (lv_guardPattern_3_0= ruleGuardPatternCS ) ) ( (lv_bottomPattern_4_0= ruleBottomPatternCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1027:2: ( (lv_check_0_0= 'check' ) )? ( (lv_enforce_1_0= 'enforce' ) )? ( ( ruleUnrestrictedName ) ) ( (lv_guardPattern_3_0= ruleGuardPatternCS ) ) ( (lv_bottomPattern_4_0= ruleBottomPatternCS ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1027:2: ( (lv_check_0_0= 'check' ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==36) ) {
                int LA29_1 = input.LA(2);

                if ( ((LA29_1>=RULE_SIMPLE_ID && LA29_1<=RULE_ESCAPED_ID)||LA29_1==16||LA29_1==18||(LA29_1>=27 && LA29_1<=28)||LA29_1==31||(LA29_1>=35 && LA29_1<=40)) ) {
                    alt29=1;
                }
            }
            switch (alt29) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1028:1: (lv_check_0_0= 'check' )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1028:1: (lv_check_0_0= 'check' )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1029:3: lv_check_0_0= 'check'
                    {
                    lv_check_0_0=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleNamedDomainCS2012); if (state.failed) return current;
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1042:3: ( (lv_enforce_1_0= 'enforce' ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==37) ) {
                int LA30_1 = input.LA(2);

                if ( ((LA30_1>=RULE_SIMPLE_ID && LA30_1<=RULE_ESCAPED_ID)||LA30_1==16||LA30_1==18||(LA30_1>=27 && LA30_1<=28)||LA30_1==31||(LA30_1>=35 && LA30_1<=40)) ) {
                    alt30=1;
                }
            }
            switch (alt30) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1043:1: (lv_enforce_1_0= 'enforce' )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1043:1: (lv_enforce_1_0= 'enforce' )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1044:3: lv_enforce_1_0= 'enforce'
                    {
                    lv_enforce_1_0=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleNamedDomainCS2044); if (state.failed) return current;
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1057:3: ( ( ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1058:1: ( ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1058:1: ( ruleUnrestrictedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1059:3: ruleUnrestrictedName
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
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleNamedDomainCS2085);
            ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1075:2: ( (lv_guardPattern_3_0= ruleGuardPatternCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1076:1: (lv_guardPattern_3_0= ruleGuardPatternCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1076:1: (lv_guardPattern_3_0= ruleGuardPatternCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1077:3: lv_guardPattern_3_0= ruleGuardPatternCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNamedDomainCSAccess().getGuardPatternGuardPatternCSParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleGuardPatternCS_in_ruleNamedDomainCS2106);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1093:2: ( (lv_bottomPattern_4_0= ruleBottomPatternCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1094:1: (lv_bottomPattern_4_0= ruleBottomPatternCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1094:1: (lv_bottomPattern_4_0= ruleBottomPatternCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1095:3: lv_bottomPattern_4_0= ruleBottomPatternCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNamedDomainCSAccess().getBottomPatternBottomPatternCSParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleBottomPatternCS_in_ruleNamedDomainCS2127);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1119:1: entryRuleParamDeclarationCS returns [EObject current=null] : iv_ruleParamDeclarationCS= ruleParamDeclarationCS EOF ;
    public final EObject entryRuleParamDeclarationCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParamDeclarationCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1120:2: (iv_ruleParamDeclarationCS= ruleParamDeclarationCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1121:2: iv_ruleParamDeclarationCS= ruleParamDeclarationCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParamDeclarationCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleParamDeclarationCS_in_entryRuleParamDeclarationCS2163);
            iv_ruleParamDeclarationCS=ruleParamDeclarationCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParamDeclarationCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParamDeclarationCS2173); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1128:1: ruleParamDeclarationCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) ) ;
    public final EObject ruleParamDeclarationCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1131:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1132:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1132:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1132:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1132:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1133:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1133:1: (lv_name_0_0= ruleUnrestrictedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1134:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParamDeclarationCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleParamDeclarationCS2219);
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

            otherlv_1=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleParamDeclarationCS2231); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getParamDeclarationCSAccess().getColonKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1154:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1155:1: (lv_ownedType_2_0= ruleTypeExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1155:1: (lv_ownedType_2_0= ruleTypeExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1156:3: lv_ownedType_2_0= ruleTypeExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParamDeclarationCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleParamDeclarationCS2252);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1180:1: entryRuleQueryCS returns [EObject current=null] : iv_ruleQueryCS= ruleQueryCS EOF ;
    public final EObject entryRuleQueryCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQueryCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1181:2: (iv_ruleQueryCS= ruleQueryCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1182:2: iv_ruleQueryCS= ruleQueryCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQueryCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleQueryCS_in_entryRuleQueryCS2288);
            iv_ruleQueryCS=ruleQueryCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQueryCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleQueryCS2298); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1189:1: ruleQueryCS returns [EObject current=null] : (otherlv_0= 'query' ( (lv_pathName_1_0= ruleScopeNameCS ) ) ( (lv_name_2_0= ruleUnrestrictedName ) ) otherlv_3= '(' ( ( (lv_inputParamDeclaration_4_0= ruleParamDeclarationCS ) ) (otherlv_5= ',' ( (lv_inputParamDeclaration_6_0= ruleParamDeclarationCS ) ) )* )? otherlv_7= ')' otherlv_8= ':' ( (lv_ownedType_9_0= ruleTypeExpCS ) ) (otherlv_10= ';' | (otherlv_11= '{' ( (lv_expression_12_0= ruleExpCS ) ) otherlv_13= '}' ) ) ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1192:28: ( (otherlv_0= 'query' ( (lv_pathName_1_0= ruleScopeNameCS ) ) ( (lv_name_2_0= ruleUnrestrictedName ) ) otherlv_3= '(' ( ( (lv_inputParamDeclaration_4_0= ruleParamDeclarationCS ) ) (otherlv_5= ',' ( (lv_inputParamDeclaration_6_0= ruleParamDeclarationCS ) ) )* )? otherlv_7= ')' otherlv_8= ':' ( (lv_ownedType_9_0= ruleTypeExpCS ) ) (otherlv_10= ';' | (otherlv_11= '{' ( (lv_expression_12_0= ruleExpCS ) ) otherlv_13= '}' ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1193:1: (otherlv_0= 'query' ( (lv_pathName_1_0= ruleScopeNameCS ) ) ( (lv_name_2_0= ruleUnrestrictedName ) ) otherlv_3= '(' ( ( (lv_inputParamDeclaration_4_0= ruleParamDeclarationCS ) ) (otherlv_5= ',' ( (lv_inputParamDeclaration_6_0= ruleParamDeclarationCS ) ) )* )? otherlv_7= ')' otherlv_8= ':' ( (lv_ownedType_9_0= ruleTypeExpCS ) ) (otherlv_10= ';' | (otherlv_11= '{' ( (lv_expression_12_0= ruleExpCS ) ) otherlv_13= '}' ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1193:1: (otherlv_0= 'query' ( (lv_pathName_1_0= ruleScopeNameCS ) ) ( (lv_name_2_0= ruleUnrestrictedName ) ) otherlv_3= '(' ( ( (lv_inputParamDeclaration_4_0= ruleParamDeclarationCS ) ) (otherlv_5= ',' ( (lv_inputParamDeclaration_6_0= ruleParamDeclarationCS ) ) )* )? otherlv_7= ')' otherlv_8= ':' ( (lv_ownedType_9_0= ruleTypeExpCS ) ) (otherlv_10= ';' | (otherlv_11= '{' ( (lv_expression_12_0= ruleExpCS ) ) otherlv_13= '}' ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1193:3: otherlv_0= 'query' ( (lv_pathName_1_0= ruleScopeNameCS ) ) ( (lv_name_2_0= ruleUnrestrictedName ) ) otherlv_3= '(' ( ( (lv_inputParamDeclaration_4_0= ruleParamDeclarationCS ) ) (otherlv_5= ',' ( (lv_inputParamDeclaration_6_0= ruleParamDeclarationCS ) ) )* )? otherlv_7= ')' otherlv_8= ':' ( (lv_ownedType_9_0= ruleTypeExpCS ) ) (otherlv_10= ';' | (otherlv_11= '{' ( (lv_expression_12_0= ruleExpCS ) ) otherlv_13= '}' ) )
            {
            otherlv_0=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleQueryCS2335); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getQueryCSAccess().getQueryKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1197:1: ( (lv_pathName_1_0= ruleScopeNameCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1198:1: (lv_pathName_1_0= ruleScopeNameCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1198:1: (lv_pathName_1_0= ruleScopeNameCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1199:3: lv_pathName_1_0= ruleScopeNameCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getQueryCSAccess().getPathNameScopeNameCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleScopeNameCS_in_ruleQueryCS2356);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1215:2: ( (lv_name_2_0= ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1216:1: (lv_name_2_0= ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1216:1: (lv_name_2_0= ruleUnrestrictedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1217:3: lv_name_2_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getQueryCSAccess().getNameUnrestrictedNameParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleQueryCS2377);
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

            otherlv_3=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleQueryCS2389); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getQueryCSAccess().getLeftParenthesisKeyword_3());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1237:1: ( ( (lv_inputParamDeclaration_4_0= ruleParamDeclarationCS ) ) (otherlv_5= ',' ( (lv_inputParamDeclaration_6_0= ruleParamDeclarationCS ) ) )* )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( ((LA32_0>=RULE_SIMPLE_ID && LA32_0<=RULE_ESCAPED_ID)||LA32_0==16||LA32_0==18||(LA32_0>=27 && LA32_0<=28)||LA32_0==31||(LA32_0>=35 && LA32_0<=40)) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1237:2: ( (lv_inputParamDeclaration_4_0= ruleParamDeclarationCS ) ) (otherlv_5= ',' ( (lv_inputParamDeclaration_6_0= ruleParamDeclarationCS ) ) )*
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1237:2: ( (lv_inputParamDeclaration_4_0= ruleParamDeclarationCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1238:1: (lv_inputParamDeclaration_4_0= ruleParamDeclarationCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1238:1: (lv_inputParamDeclaration_4_0= ruleParamDeclarationCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1239:3: lv_inputParamDeclaration_4_0= ruleParamDeclarationCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getQueryCSAccess().getInputParamDeclarationParamDeclarationCSParserRuleCall_4_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleParamDeclarationCS_in_ruleQueryCS2411);
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

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1255:2: (otherlv_5= ',' ( (lv_inputParamDeclaration_6_0= ruleParamDeclarationCS ) ) )*
                    loop31:
                    do {
                        int alt31=2;
                        int LA31_0 = input.LA(1);

                        if ( (LA31_0==19) ) {
                            alt31=1;
                        }


                        switch (alt31) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1255:4: otherlv_5= ',' ( (lv_inputParamDeclaration_6_0= ruleParamDeclarationCS ) )
                    	    {
                    	    otherlv_5=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleQueryCS2424); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_5, grammarAccess.getQueryCSAccess().getCommaKeyword_4_1_0());
                    	          
                    	    }
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1259:1: ( (lv_inputParamDeclaration_6_0= ruleParamDeclarationCS ) )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1260:1: (lv_inputParamDeclaration_6_0= ruleParamDeclarationCS )
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1260:1: (lv_inputParamDeclaration_6_0= ruleParamDeclarationCS )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1261:3: lv_inputParamDeclaration_6_0= ruleParamDeclarationCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getQueryCSAccess().getInputParamDeclarationParamDeclarationCSParserRuleCall_4_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleParamDeclarationCS_in_ruleQueryCS2445);
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
                    	    break loop31;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_7=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleQueryCS2461); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getQueryCSAccess().getRightParenthesisKeyword_5());
                  
            }
            otherlv_8=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleQueryCS2473); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getQueryCSAccess().getColonKeyword_6());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1285:1: ( (lv_ownedType_9_0= ruleTypeExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1286:1: (lv_ownedType_9_0= ruleTypeExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1286:1: (lv_ownedType_9_0= ruleTypeExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1287:3: lv_ownedType_9_0= ruleTypeExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getQueryCSAccess().getOwnedTypeTypeExpCSParserRuleCall_7_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleQueryCS2494);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1303:2: (otherlv_10= ';' | (otherlv_11= '{' ( (lv_expression_12_0= ruleExpCS ) ) otherlv_13= '}' ) )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==26) ) {
                alt33=1;
            }
            else if ( (LA33_0==20) ) {
                alt33=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }
            switch (alt33) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1303:4: otherlv_10= ';'
                    {
                    otherlv_10=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleQueryCS2507); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getQueryCSAccess().getSemicolonKeyword_8_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1308:6: (otherlv_11= '{' ( (lv_expression_12_0= ruleExpCS ) ) otherlv_13= '}' )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1308:6: (otherlv_11= '{' ( (lv_expression_12_0= ruleExpCS ) ) otherlv_13= '}' )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1308:8: otherlv_11= '{' ( (lv_expression_12_0= ruleExpCS ) ) otherlv_13= '}'
                    {
                    otherlv_11=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleQueryCS2526); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_11, grammarAccess.getQueryCSAccess().getLeftCurlyBracketKeyword_8_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1312:1: ( (lv_expression_12_0= ruleExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1313:1: (lv_expression_12_0= ruleExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1313:1: (lv_expression_12_0= ruleExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1314:3: lv_expression_12_0= ruleExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getQueryCSAccess().getExpressionExpCSParserRuleCall_8_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleQueryCS2547);
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

                    otherlv_13=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleQueryCS2559); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1342:1: entryRuleScopeNameCS returns [EObject current=null] : iv_ruleScopeNameCS= ruleScopeNameCS EOF ;
    public final EObject entryRuleScopeNameCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScopeNameCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1343:2: (iv_ruleScopeNameCS= ruleScopeNameCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1344:2: iv_ruleScopeNameCS= ruleScopeNameCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScopeNameCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleScopeNameCS_in_entryRuleScopeNameCS2597);
            iv_ruleScopeNameCS=ruleScopeNameCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScopeNameCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleScopeNameCS2607); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1351:1: ruleScopeNameCS returns [EObject current=null] : ( ( (lv_path_0_0= ruleFirstPathElementCS ) ) otherlv_1= '::' ( ( (lv_path_2_0= ruleNextPathElementCS ) ) otherlv_3= '::' )* ) ;
    public final EObject ruleScopeNameCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_path_0_0 = null;

        EObject lv_path_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1354:28: ( ( ( (lv_path_0_0= ruleFirstPathElementCS ) ) otherlv_1= '::' ( ( (lv_path_2_0= ruleNextPathElementCS ) ) otherlv_3= '::' )* ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1355:1: ( ( (lv_path_0_0= ruleFirstPathElementCS ) ) otherlv_1= '::' ( ( (lv_path_2_0= ruleNextPathElementCS ) ) otherlv_3= '::' )* )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1355:1: ( ( (lv_path_0_0= ruleFirstPathElementCS ) ) otherlv_1= '::' ( ( (lv_path_2_0= ruleNextPathElementCS ) ) otherlv_3= '::' )* )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1355:2: ( (lv_path_0_0= ruleFirstPathElementCS ) ) otherlv_1= '::' ( ( (lv_path_2_0= ruleNextPathElementCS ) ) otherlv_3= '::' )*
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1355:2: ( (lv_path_0_0= ruleFirstPathElementCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1356:1: (lv_path_0_0= ruleFirstPathElementCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1356:1: (lv_path_0_0= ruleFirstPathElementCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1357:3: lv_path_0_0= ruleFirstPathElementCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getScopeNameCSAccess().getPathFirstPathElementCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleFirstPathElementCS_in_ruleScopeNameCS2653);
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

            otherlv_1=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleScopeNameCS2665); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getScopeNameCSAccess().getColonColonKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1377:1: ( ( (lv_path_2_0= ruleNextPathElementCS ) ) otherlv_3= '::' )*
            loop34:
            do {
                int alt34=2;
                alt34 = dfa34.predict(input);
                switch (alt34) {
            	case 1 :
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1377:2: ( (lv_path_2_0= ruleNextPathElementCS ) ) otherlv_3= '::'
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1377:2: ( (lv_path_2_0= ruleNextPathElementCS ) )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1378:1: (lv_path_2_0= ruleNextPathElementCS )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1378:1: (lv_path_2_0= ruleNextPathElementCS )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1379:3: lv_path_2_0= ruleNextPathElementCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getScopeNameCSAccess().getPathNextPathElementCSParserRuleCall_2_0_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleNextPathElementCS_in_ruleScopeNameCS2687);
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

            	    otherlv_3=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleScopeNameCS2699); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getScopeNameCSAccess().getColonColonKeyword_2_1());
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop34;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1407:1: entryRuleTransformationCS returns [EObject current=null] : iv_ruleTransformationCS= ruleTransformationCS EOF ;
    public final EObject entryRuleTransformationCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransformationCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1408:2: (iv_ruleTransformationCS= ruleTransformationCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1409:2: iv_ruleTransformationCS= ruleTransformationCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTransformationCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTransformationCS_in_entryRuleTransformationCS2737);
            iv_ruleTransformationCS=ruleTransformationCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTransformationCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTransformationCS2747); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1416:1: ruleTransformationCS returns [EObject current=null] : (otherlv_0= 'transformation' ( (lv_pathName_1_0= ruleScopeNameCS ) )? ( (lv_name_2_0= ruleUnreservedName ) ) otherlv_3= '{' ( ( (lv_directions_4_0= ruleDirectionCS ) ) otherlv_5= ';' )* otherlv_6= '}' ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1419:28: ( (otherlv_0= 'transformation' ( (lv_pathName_1_0= ruleScopeNameCS ) )? ( (lv_name_2_0= ruleUnreservedName ) ) otherlv_3= '{' ( ( (lv_directions_4_0= ruleDirectionCS ) ) otherlv_5= ';' )* otherlv_6= '}' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1420:1: (otherlv_0= 'transformation' ( (lv_pathName_1_0= ruleScopeNameCS ) )? ( (lv_name_2_0= ruleUnreservedName ) ) otherlv_3= '{' ( ( (lv_directions_4_0= ruleDirectionCS ) ) otherlv_5= ';' )* otherlv_6= '}' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1420:1: (otherlv_0= 'transformation' ( (lv_pathName_1_0= ruleScopeNameCS ) )? ( (lv_name_2_0= ruleUnreservedName ) ) otherlv_3= '{' ( ( (lv_directions_4_0= ruleDirectionCS ) ) otherlv_5= ';' )* otherlv_6= '}' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1420:3: otherlv_0= 'transformation' ( (lv_pathName_1_0= ruleScopeNameCS ) )? ( (lv_name_2_0= ruleUnreservedName ) ) otherlv_3= '{' ( ( (lv_directions_4_0= ruleDirectionCS ) ) otherlv_5= ';' )* otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,39,FollowSets000.FOLLOW_39_in_ruleTransformationCS2784); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getTransformationCSAccess().getTransformationKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1424:1: ( (lv_pathName_1_0= ruleScopeNameCS ) )?
            int alt35=2;
            alt35 = dfa35.predict(input);
            switch (alt35) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1425:1: (lv_pathName_1_0= ruleScopeNameCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1425:1: (lv_pathName_1_0= ruleScopeNameCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1426:3: lv_pathName_1_0= ruleScopeNameCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTransformationCSAccess().getPathNameScopeNameCSParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleScopeNameCS_in_ruleTransformationCS2805);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1442:3: ( (lv_name_2_0= ruleUnreservedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1443:1: (lv_name_2_0= ruleUnreservedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1443:1: (lv_name_2_0= ruleUnreservedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1444:3: lv_name_2_0= ruleUnreservedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTransformationCSAccess().getNameUnreservedNameParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnreservedName_in_ruleTransformationCS2827);
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

            otherlv_3=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleTransformationCS2839); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getTransformationCSAccess().getLeftCurlyBracketKeyword_3());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1464:1: ( ( (lv_directions_4_0= ruleDirectionCS ) ) otherlv_5= ';' )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==EOF||(LA36_0>=RULE_SIMPLE_ID && LA36_0<=RULE_ESCAPED_ID)||LA36_0==16||LA36_0==18||(LA36_0>=26 && LA36_0<=28)||LA36_0==31||(LA36_0>=35 && LA36_0<=40)) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1464:2: ( (lv_directions_4_0= ruleDirectionCS ) ) otherlv_5= ';'
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1464:2: ( (lv_directions_4_0= ruleDirectionCS ) )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1465:1: (lv_directions_4_0= ruleDirectionCS )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1465:1: (lv_directions_4_0= ruleDirectionCS )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1466:3: lv_directions_4_0= ruleDirectionCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTransformationCSAccess().getDirectionsDirectionCSParserRuleCall_4_0_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleDirectionCS_in_ruleTransformationCS2861);
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

            	    otherlv_5=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleTransformationCS2873); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_5, grammarAccess.getTransformationCSAccess().getSemicolonKeyword_4_1());
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);

            otherlv_6=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleTransformationCS2887); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1498:1: entryRuleUnrealizedVariableCS returns [EObject current=null] : iv_ruleUnrealizedVariableCS= ruleUnrealizedVariableCS EOF ;
    public final EObject entryRuleUnrealizedVariableCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnrealizedVariableCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1499:2: (iv_ruleUnrealizedVariableCS= ruleUnrealizedVariableCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1500:2: iv_ruleUnrealizedVariableCS= ruleUnrealizedVariableCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnrealizedVariableCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrealizedVariableCS_in_entryRuleUnrealizedVariableCS2923);
            iv_ruleUnrealizedVariableCS=ruleUnrealizedVariableCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnrealizedVariableCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnrealizedVariableCS2933); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1507:1: ruleUnrealizedVariableCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) ) ;
    public final EObject ruleUnrealizedVariableCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1510:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1511:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1511:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1511:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1511:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1512:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1512:1: (lv_name_0_0= ruleUnrestrictedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1513:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getUnrealizedVariableCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleUnrealizedVariableCS2979);
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

            otherlv_1=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleUnrealizedVariableCS2991); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getUnrealizedVariableCSAccess().getColonKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1533:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1534:1: (lv_ownedType_2_0= ruleTypeExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1534:1: (lv_ownedType_2_0= ruleTypeExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1535:3: lv_ownedType_2_0= ruleTypeExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getUnrealizedVariableCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleUnrealizedVariableCS3012);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1559:1: entryRuleRealizedVariableCS returns [EObject current=null] : iv_ruleRealizedVariableCS= ruleRealizedVariableCS EOF ;
    public final EObject entryRuleRealizedVariableCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealizedVariableCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1560:2: (iv_ruleRealizedVariableCS= ruleRealizedVariableCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1561:2: iv_ruleRealizedVariableCS= ruleRealizedVariableCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRealizedVariableCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleRealizedVariableCS_in_entryRuleRealizedVariableCS3048);
            iv_ruleRealizedVariableCS=ruleRealizedVariableCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRealizedVariableCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRealizedVariableCS3058); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1568:1: ruleRealizedVariableCS returns [EObject current=null] : (otherlv_0= 'realize' ( (lv_name_1_0= ruleUnrestrictedName ) ) otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) ) ;
    public final EObject ruleRealizedVariableCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_ownedType_3_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1571:28: ( (otherlv_0= 'realize' ( (lv_name_1_0= ruleUnrestrictedName ) ) otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1572:1: (otherlv_0= 'realize' ( (lv_name_1_0= ruleUnrestrictedName ) ) otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1572:1: (otherlv_0= 'realize' ( (lv_name_1_0= ruleUnrestrictedName ) ) otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1572:3: otherlv_0= 'realize' ( (lv_name_1_0= ruleUnrestrictedName ) ) otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) )
            {
            otherlv_0=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleRealizedVariableCS3095); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getRealizedVariableCSAccess().getRealizeKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1576:1: ( (lv_name_1_0= ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1577:1: (lv_name_1_0= ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1577:1: (lv_name_1_0= ruleUnrestrictedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1578:3: lv_name_1_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRealizedVariableCSAccess().getNameUnrestrictedNameParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleRealizedVariableCS3116);
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

            otherlv_2=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleRealizedVariableCS3128); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getRealizedVariableCSAccess().getColonKeyword_2());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1598:1: ( (lv_ownedType_3_0= ruleTypeExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1599:1: (lv_ownedType_3_0= ruleTypeExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1599:1: (lv_ownedType_3_0= ruleTypeExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1600:3: lv_ownedType_3_0= ruleTypeExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRealizedVariableCSAccess().getOwnedTypeTypeExpCSParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleRealizedVariableCS3149);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1624:1: entryRuleUnnamedDomainCS returns [EObject current=null] : iv_ruleUnnamedDomainCS= ruleUnnamedDomainCS EOF ;
    public final EObject entryRuleUnnamedDomainCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnnamedDomainCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1625:2: (iv_ruleUnnamedDomainCS= ruleUnnamedDomainCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1626:2: iv_ruleUnnamedDomainCS= ruleUnnamedDomainCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnnamedDomainCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnnamedDomainCS_in_entryRuleUnnamedDomainCS3185);
            iv_ruleUnnamedDomainCS=ruleUnnamedDomainCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnnamedDomainCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnnamedDomainCS3195); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1633:1: ruleUnnamedDomainCS returns [EObject current=null] : ( () ( (lv_guardPattern_1_0= ruleGuardPatternCS ) ) ( (lv_bottomPattern_2_0= ruleBottomPatternCS ) ) ) ;
    public final EObject ruleUnnamedDomainCS() throws RecognitionException {
        EObject current = null;

        EObject lv_guardPattern_1_0 = null;

        EObject lv_bottomPattern_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1636:28: ( ( () ( (lv_guardPattern_1_0= ruleGuardPatternCS ) ) ( (lv_bottomPattern_2_0= ruleBottomPatternCS ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1637:1: ( () ( (lv_guardPattern_1_0= ruleGuardPatternCS ) ) ( (lv_bottomPattern_2_0= ruleBottomPatternCS ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1637:1: ( () ( (lv_guardPattern_1_0= ruleGuardPatternCS ) ) ( (lv_bottomPattern_2_0= ruleBottomPatternCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1637:2: () ( (lv_guardPattern_1_0= ruleGuardPatternCS ) ) ( (lv_bottomPattern_2_0= ruleBottomPatternCS ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1637:2: ()
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1638:2: 
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1646:2: ( (lv_guardPattern_1_0= ruleGuardPatternCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1647:1: (lv_guardPattern_1_0= ruleGuardPatternCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1647:1: (lv_guardPattern_1_0= ruleGuardPatternCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1648:3: lv_guardPattern_1_0= ruleGuardPatternCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getUnnamedDomainCSAccess().getGuardPatternGuardPatternCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleGuardPatternCS_in_ruleUnnamedDomainCS3253);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1664:2: ( (lv_bottomPattern_2_0= ruleBottomPatternCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1665:1: (lv_bottomPattern_2_0= ruleBottomPatternCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1665:1: (lv_bottomPattern_2_0= ruleBottomPatternCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1666:3: lv_bottomPattern_2_0= ruleBottomPatternCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getUnnamedDomainCSAccess().getBottomPatternBottomPatternCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleBottomPatternCS_in_ruleUnnamedDomainCS3274);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1690:1: entryRuleUnrestrictedName returns [String current=null] : iv_ruleUnrestrictedName= ruleUnrestrictedName EOF ;
    public final String entryRuleUnrestrictedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnrestrictedName = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1691:2: (iv_ruleUnrestrictedName= ruleUnrestrictedName EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1692:2: iv_ruleUnrestrictedName= ruleUnrestrictedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnrestrictedNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_entryRuleUnrestrictedName3311);
            iv_ruleUnrestrictedName=ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnrestrictedName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnrestrictedName3322); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1699:1: ruleUnrestrictedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_EssentialOCLUnrestrictedName_0= ruleEssentialOCLUnrestrictedName | kw= 'check' | kw= 'enforce' | kw= 'import' | kw= 'imports' | kw= 'library' | kw= 'map' | kw= 'query' | kw= 'realize' | kw= 'refines' | kw= 'transformation' | kw= 'uses' ) ;
    public final AntlrDatatypeRuleToken ruleUnrestrictedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_EssentialOCLUnrestrictedName_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1702:28: ( (this_EssentialOCLUnrestrictedName_0= ruleEssentialOCLUnrestrictedName | kw= 'check' | kw= 'enforce' | kw= 'import' | kw= 'imports' | kw= 'library' | kw= 'map' | kw= 'query' | kw= 'realize' | kw= 'refines' | kw= 'transformation' | kw= 'uses' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1703:1: (this_EssentialOCLUnrestrictedName_0= ruleEssentialOCLUnrestrictedName | kw= 'check' | kw= 'enforce' | kw= 'import' | kw= 'imports' | kw= 'library' | kw= 'map' | kw= 'query' | kw= 'realize' | kw= 'refines' | kw= 'transformation' | kw= 'uses' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1703:1: (this_EssentialOCLUnrestrictedName_0= ruleEssentialOCLUnrestrictedName | kw= 'check' | kw= 'enforce' | kw= 'import' | kw= 'imports' | kw= 'library' | kw= 'map' | kw= 'query' | kw= 'realize' | kw= 'refines' | kw= 'transformation' | kw= 'uses' )
            int alt37=12;
            switch ( input.LA(1) ) {
            case RULE_SIMPLE_ID:
            case RULE_ESCAPED_ID:
                {
                alt37=1;
                }
                break;
            case 36:
                {
                alt37=2;
                }
                break;
            case 37:
                {
                alt37=3;
                }
                break;
            case 31:
                {
                alt37=4;
                }
                break;
            case 27:
                {
                alt37=5;
                }
                break;
            case 35:
                {
                alt37=6;
                }
                break;
            case 16:
                {
                alt37=7;
                }
                break;
            case 38:
                {
                alt37=8;
                }
                break;
            case 40:
                {
                alt37=9;
                }
                break;
            case 18:
                {
                alt37=10;
                }
                break;
            case 39:
                {
                alt37=11;
                }
                break;
            case 28:
                {
                alt37=12;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1704:5: this_EssentialOCLUnrestrictedName_0= ruleEssentialOCLUnrestrictedName
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getUnrestrictedNameAccess().getEssentialOCLUnrestrictedNameParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLUnrestrictedName_in_ruleUnrestrictedName3369);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1716:2: kw= 'check'
                    {
                    kw=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleUnrestrictedName3393); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getCheckKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1723:2: kw= 'enforce'
                    {
                    kw=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleUnrestrictedName3412); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getEnforceKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1730:2: kw= 'import'
                    {
                    kw=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleUnrestrictedName3431); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getImportKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1737:2: kw= 'imports'
                    {
                    kw=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleUnrestrictedName3450); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getImportsKeyword_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1744:2: kw= 'library'
                    {
                    kw=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleUnrestrictedName3469); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getLibraryKeyword_5()); 
                          
                    }

                    }
                    break;
                case 7 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1751:2: kw= 'map'
                    {
                    kw=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleUnrestrictedName3488); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getMapKeyword_6()); 
                          
                    }

                    }
                    break;
                case 8 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1758:2: kw= 'query'
                    {
                    kw=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleUnrestrictedName3507); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getQueryKeyword_7()); 
                          
                    }

                    }
                    break;
                case 9 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1765:2: kw= 'realize'
                    {
                    kw=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleUnrestrictedName3526); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getRealizeKeyword_8()); 
                          
                    }

                    }
                    break;
                case 10 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1772:2: kw= 'refines'
                    {
                    kw=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleUnrestrictedName3545); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getRefinesKeyword_9()); 
                          
                    }

                    }
                    break;
                case 11 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1779:2: kw= 'transformation'
                    {
                    kw=(Token)match(input,39,FollowSets000.FOLLOW_39_in_ruleUnrestrictedName3564); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getTransformationKeyword_10()); 
                          
                    }

                    }
                    break;
                case 12 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1786:2: kw= 'uses'
                    {
                    kw=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleUnrestrictedName3583); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1801:1: entryRuleID returns [String current=null] : iv_ruleID= ruleID EOF ;
    public final String entryRuleID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleID = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1802:2: (iv_ruleID= ruleID EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1803:2: iv_ruleID= ruleID EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIDRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleID_in_entryRuleID3626);
            iv_ruleID=ruleID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleID.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleID3637); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1810:1: ruleID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_SIMPLE_ID_0= RULE_SIMPLE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID ) ;
    public final AntlrDatatypeRuleToken ruleID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_SIMPLE_ID_0=null;
        Token this_ESCAPED_ID_1=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1813:28: ( (this_SIMPLE_ID_0= RULE_SIMPLE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1814:1: (this_SIMPLE_ID_0= RULE_SIMPLE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1814:1: (this_SIMPLE_ID_0= RULE_SIMPLE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==RULE_SIMPLE_ID) ) {
                alt38=1;
            }
            else if ( (LA38_0==RULE_ESCAPED_ID) ) {
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1814:6: this_SIMPLE_ID_0= RULE_SIMPLE_ID
                    {
                    this_SIMPLE_ID_0=(Token)match(input,RULE_SIMPLE_ID,FollowSets000.FOLLOW_RULE_SIMPLE_ID_in_ruleID3677); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SIMPLE_ID_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SIMPLE_ID_0, grammarAccess.getIDAccess().getSIMPLE_IDTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1822:10: this_ESCAPED_ID_1= RULE_ESCAPED_ID
                    {
                    this_ESCAPED_ID_1=(Token)match(input,RULE_ESCAPED_ID,FollowSets000.FOLLOW_RULE_ESCAPED_ID_in_ruleID3703); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1837:1: entryRuleLOWER returns [String current=null] : iv_ruleLOWER= ruleLOWER EOF ;
    public final String entryRuleLOWER() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLOWER = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1838:2: (iv_ruleLOWER= ruleLOWER EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1839:2: iv_ruleLOWER= ruleLOWER EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLOWERRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLOWER_in_entryRuleLOWER3749);
            iv_ruleLOWER=ruleLOWER();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLOWER.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLOWER3760); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1846:1: ruleLOWER returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INT_0= RULE_INT ;
    public final AntlrDatatypeRuleToken ruleLOWER() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1849:28: (this_INT_0= RULE_INT )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1850:5: this_INT_0= RULE_INT
            {
            this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleLOWER3799); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1865:1: entryRuleUPPER returns [String current=null] : iv_ruleUPPER= ruleUPPER EOF ;
    public final String entryRuleUPPER() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUPPER = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1866:2: (iv_ruleUPPER= ruleUPPER EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1867:2: iv_ruleUPPER= ruleUPPER EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUPPERRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUPPER_in_entryRuleUPPER3844);
            iv_ruleUPPER=ruleUPPER();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUPPER.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUPPER3855); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1874:1: ruleUPPER returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT | kw= '*' ) ;
    public final AntlrDatatypeRuleToken ruleUPPER() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1877:28: ( (this_INT_0= RULE_INT | kw= '*' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1878:1: (this_INT_0= RULE_INT | kw= '*' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1878:1: (this_INT_0= RULE_INT | kw= '*' )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==RULE_INT) ) {
                alt39=1;
            }
            else if ( (LA39_0==34) ) {
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1878:6: this_INT_0= RULE_INT
                    {
                    this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleUPPER3895); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_INT_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_INT_0, grammarAccess.getUPPERAccess().getINTTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1887:2: kw= '*'
                    {
                    kw=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleUPPER3919); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1900:1: entryRuleNUMBER_LITERAL returns [String current=null] : iv_ruleNUMBER_LITERAL= ruleNUMBER_LITERAL EOF ;
    public final String entryRuleNUMBER_LITERAL() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNUMBER_LITERAL = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1901:2: (iv_ruleNUMBER_LITERAL= ruleNUMBER_LITERAL EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1902:2: iv_ruleNUMBER_LITERAL= ruleNUMBER_LITERAL EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNUMBER_LITERALRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNUMBER_LITERAL_in_entryRuleNUMBER_LITERAL3960);
            iv_ruleNUMBER_LITERAL=ruleNUMBER_LITERAL();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNUMBER_LITERAL.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNUMBER_LITERAL3971); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1909:1: ruleNUMBER_LITERAL returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INT_0= RULE_INT ;
    public final AntlrDatatypeRuleToken ruleNUMBER_LITERAL() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1912:28: (this_INT_0= RULE_INT )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1913:5: this_INT_0= RULE_INT
            {
            this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleNUMBER_LITERAL4010); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1928:1: entryRuleURI returns [String current=null] : iv_ruleURI= ruleURI EOF ;
    public final String entryRuleURI() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleURI = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1929:2: (iv_ruleURI= ruleURI EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1930:2: iv_ruleURI= ruleURI EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getURIRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleURI_in_entryRuleURI4055);
            iv_ruleURI=ruleURI();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleURI.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleURI4066); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1937:1: ruleURI returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING ;
    public final AntlrDatatypeRuleToken ruleURI() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_SINGLE_QUOTED_STRING_0=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1940:28: (this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1941:5: this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING
            {
            this_SINGLE_QUOTED_STRING_0=(Token)match(input,RULE_SINGLE_QUOTED_STRING,FollowSets000.FOLLOW_RULE_SINGLE_QUOTED_STRING_in_ruleURI4105); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1958:1: entryRuleEssentialOCLUnaryOperatorCS returns [EObject current=null] : iv_ruleEssentialOCLUnaryOperatorCS= ruleEssentialOCLUnaryOperatorCS EOF ;
    public final EObject entryRuleEssentialOCLUnaryOperatorCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEssentialOCLUnaryOperatorCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1959:2: (iv_ruleEssentialOCLUnaryOperatorCS= ruleEssentialOCLUnaryOperatorCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1960:2: iv_ruleEssentialOCLUnaryOperatorCS= ruleEssentialOCLUnaryOperatorCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEssentialOCLUnaryOperatorCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLUnaryOperatorCS_in_entryRuleEssentialOCLUnaryOperatorCS4151);
            iv_ruleEssentialOCLUnaryOperatorCS=ruleEssentialOCLUnaryOperatorCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEssentialOCLUnaryOperatorCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEssentialOCLUnaryOperatorCS4161); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1967:1: ruleEssentialOCLUnaryOperatorCS returns [EObject current=null] : ( ( (lv_name_0_1= '-' | lv_name_0_2= 'not' ) ) ) ;
    public final EObject ruleEssentialOCLUnaryOperatorCS() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1970:28: ( ( ( (lv_name_0_1= '-' | lv_name_0_2= 'not' ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1971:1: ( ( (lv_name_0_1= '-' | lv_name_0_2= 'not' ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1971:1: ( ( (lv_name_0_1= '-' | lv_name_0_2= 'not' ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1972:1: ( (lv_name_0_1= '-' | lv_name_0_2= 'not' ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1972:1: ( (lv_name_0_1= '-' | lv_name_0_2= 'not' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1973:1: (lv_name_0_1= '-' | lv_name_0_2= 'not' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1973:1: (lv_name_0_1= '-' | lv_name_0_2= 'not' )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==41) ) {
                alt40=1;
            }
            else if ( (LA40_0==42) ) {
                alt40=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1974:3: lv_name_0_1= '-'
                    {
                    lv_name_0_1=(Token)match(input,41,FollowSets000.FOLLOW_41_in_ruleEssentialOCLUnaryOperatorCS4205); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1986:8: lv_name_0_2= 'not'
                    {
                    lv_name_0_2=(Token)match(input,42,FollowSets000.FOLLOW_42_in_ruleEssentialOCLUnaryOperatorCS4234); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2009:1: entryRuleEssentialOCLInfixOperatorCS returns [EObject current=null] : iv_ruleEssentialOCLInfixOperatorCS= ruleEssentialOCLInfixOperatorCS EOF ;
    public final EObject entryRuleEssentialOCLInfixOperatorCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEssentialOCLInfixOperatorCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2010:2: (iv_ruleEssentialOCLInfixOperatorCS= ruleEssentialOCLInfixOperatorCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2011:2: iv_ruleEssentialOCLInfixOperatorCS= ruleEssentialOCLInfixOperatorCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEssentialOCLInfixOperatorCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLInfixOperatorCS_in_entryRuleEssentialOCLInfixOperatorCS4285);
            iv_ruleEssentialOCLInfixOperatorCS=ruleEssentialOCLInfixOperatorCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEssentialOCLInfixOperatorCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEssentialOCLInfixOperatorCS4295); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2018:1: ruleEssentialOCLInfixOperatorCS returns [EObject current=null] : ( ( (lv_name_0_1= '*' | lv_name_0_2= '/' | lv_name_0_3= '+' | lv_name_0_4= '-' | lv_name_0_5= '>' | lv_name_0_6= '<' | lv_name_0_7= '>=' | lv_name_0_8= '<=' | lv_name_0_9= '=' | lv_name_0_10= '<>' | lv_name_0_11= 'and' | lv_name_0_12= 'or' | lv_name_0_13= 'xor' | lv_name_0_14= 'implies' ) ) ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2021:28: ( ( ( (lv_name_0_1= '*' | lv_name_0_2= '/' | lv_name_0_3= '+' | lv_name_0_4= '-' | lv_name_0_5= '>' | lv_name_0_6= '<' | lv_name_0_7= '>=' | lv_name_0_8= '<=' | lv_name_0_9= '=' | lv_name_0_10= '<>' | lv_name_0_11= 'and' | lv_name_0_12= 'or' | lv_name_0_13= 'xor' | lv_name_0_14= 'implies' ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2022:1: ( ( (lv_name_0_1= '*' | lv_name_0_2= '/' | lv_name_0_3= '+' | lv_name_0_4= '-' | lv_name_0_5= '>' | lv_name_0_6= '<' | lv_name_0_7= '>=' | lv_name_0_8= '<=' | lv_name_0_9= '=' | lv_name_0_10= '<>' | lv_name_0_11= 'and' | lv_name_0_12= 'or' | lv_name_0_13= 'xor' | lv_name_0_14= 'implies' ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2022:1: ( ( (lv_name_0_1= '*' | lv_name_0_2= '/' | lv_name_0_3= '+' | lv_name_0_4= '-' | lv_name_0_5= '>' | lv_name_0_6= '<' | lv_name_0_7= '>=' | lv_name_0_8= '<=' | lv_name_0_9= '=' | lv_name_0_10= '<>' | lv_name_0_11= 'and' | lv_name_0_12= 'or' | lv_name_0_13= 'xor' | lv_name_0_14= 'implies' ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2023:1: ( (lv_name_0_1= '*' | lv_name_0_2= '/' | lv_name_0_3= '+' | lv_name_0_4= '-' | lv_name_0_5= '>' | lv_name_0_6= '<' | lv_name_0_7= '>=' | lv_name_0_8= '<=' | lv_name_0_9= '=' | lv_name_0_10= '<>' | lv_name_0_11= 'and' | lv_name_0_12= 'or' | lv_name_0_13= 'xor' | lv_name_0_14= 'implies' ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2023:1: ( (lv_name_0_1= '*' | lv_name_0_2= '/' | lv_name_0_3= '+' | lv_name_0_4= '-' | lv_name_0_5= '>' | lv_name_0_6= '<' | lv_name_0_7= '>=' | lv_name_0_8= '<=' | lv_name_0_9= '=' | lv_name_0_10= '<>' | lv_name_0_11= 'and' | lv_name_0_12= 'or' | lv_name_0_13= 'xor' | lv_name_0_14= 'implies' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2024:1: (lv_name_0_1= '*' | lv_name_0_2= '/' | lv_name_0_3= '+' | lv_name_0_4= '-' | lv_name_0_5= '>' | lv_name_0_6= '<' | lv_name_0_7= '>=' | lv_name_0_8= '<=' | lv_name_0_9= '=' | lv_name_0_10= '<>' | lv_name_0_11= 'and' | lv_name_0_12= 'or' | lv_name_0_13= 'xor' | lv_name_0_14= 'implies' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2024:1: (lv_name_0_1= '*' | lv_name_0_2= '/' | lv_name_0_3= '+' | lv_name_0_4= '-' | lv_name_0_5= '>' | lv_name_0_6= '<' | lv_name_0_7= '>=' | lv_name_0_8= '<=' | lv_name_0_9= '=' | lv_name_0_10= '<>' | lv_name_0_11= 'and' | lv_name_0_12= 'or' | lv_name_0_13= 'xor' | lv_name_0_14= 'implies' )
            int alt41=14;
            switch ( input.LA(1) ) {
            case 34:
                {
                alt41=1;
                }
                break;
            case 43:
                {
                alt41=2;
                }
                break;
            case 44:
                {
                alt41=3;
                }
                break;
            case 41:
                {
                alt41=4;
                }
                break;
            case 45:
                {
                alt41=5;
                }
                break;
            case 46:
                {
                alt41=6;
                }
                break;
            case 47:
                {
                alt41=7;
                }
                break;
            case 48:
                {
                alt41=8;
                }
                break;
            case 49:
                {
                alt41=9;
                }
                break;
            case 50:
                {
                alt41=10;
                }
                break;
            case 51:
                {
                alt41=11;
                }
                break;
            case 52:
                {
                alt41=12;
                }
                break;
            case 53:
                {
                alt41=13;
                }
                break;
            case 54:
                {
                alt41=14;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2025:3: lv_name_0_1= '*'
                    {
                    lv_name_0_1=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleEssentialOCLInfixOperatorCS4339); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2037:8: lv_name_0_2= '/'
                    {
                    lv_name_0_2=(Token)match(input,43,FollowSets000.FOLLOW_43_in_ruleEssentialOCLInfixOperatorCS4368); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2049:8: lv_name_0_3= '+'
                    {
                    lv_name_0_3=(Token)match(input,44,FollowSets000.FOLLOW_44_in_ruleEssentialOCLInfixOperatorCS4397); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2061:8: lv_name_0_4= '-'
                    {
                    lv_name_0_4=(Token)match(input,41,FollowSets000.FOLLOW_41_in_ruleEssentialOCLInfixOperatorCS4426); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2073:8: lv_name_0_5= '>'
                    {
                    lv_name_0_5=(Token)match(input,45,FollowSets000.FOLLOW_45_in_ruleEssentialOCLInfixOperatorCS4455); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2085:8: lv_name_0_6= '<'
                    {
                    lv_name_0_6=(Token)match(input,46,FollowSets000.FOLLOW_46_in_ruleEssentialOCLInfixOperatorCS4484); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2097:8: lv_name_0_7= '>='
                    {
                    lv_name_0_7=(Token)match(input,47,FollowSets000.FOLLOW_47_in_ruleEssentialOCLInfixOperatorCS4513); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2109:8: lv_name_0_8= '<='
                    {
                    lv_name_0_8=(Token)match(input,48,FollowSets000.FOLLOW_48_in_ruleEssentialOCLInfixOperatorCS4542); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2121:8: lv_name_0_9= '='
                    {
                    lv_name_0_9=(Token)match(input,49,FollowSets000.FOLLOW_49_in_ruleEssentialOCLInfixOperatorCS4571); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2133:8: lv_name_0_10= '<>'
                    {
                    lv_name_0_10=(Token)match(input,50,FollowSets000.FOLLOW_50_in_ruleEssentialOCLInfixOperatorCS4600); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2145:8: lv_name_0_11= 'and'
                    {
                    lv_name_0_11=(Token)match(input,51,FollowSets000.FOLLOW_51_in_ruleEssentialOCLInfixOperatorCS4629); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2157:8: lv_name_0_12= 'or'
                    {
                    lv_name_0_12=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleEssentialOCLInfixOperatorCS4658); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2169:8: lv_name_0_13= 'xor'
                    {
                    lv_name_0_13=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleEssentialOCLInfixOperatorCS4687); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2181:8: lv_name_0_14= 'implies'
                    {
                    lv_name_0_14=(Token)match(input,54,FollowSets000.FOLLOW_54_in_ruleEssentialOCLInfixOperatorCS4716); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2204:1: entryRuleEssentialOCLNavigationOperatorCS returns [EObject current=null] : iv_ruleEssentialOCLNavigationOperatorCS= ruleEssentialOCLNavigationOperatorCS EOF ;
    public final EObject entryRuleEssentialOCLNavigationOperatorCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEssentialOCLNavigationOperatorCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2205:2: (iv_ruleEssentialOCLNavigationOperatorCS= ruleEssentialOCLNavigationOperatorCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2206:2: iv_ruleEssentialOCLNavigationOperatorCS= ruleEssentialOCLNavigationOperatorCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEssentialOCLNavigationOperatorCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLNavigationOperatorCS_in_entryRuleEssentialOCLNavigationOperatorCS4767);
            iv_ruleEssentialOCLNavigationOperatorCS=ruleEssentialOCLNavigationOperatorCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEssentialOCLNavigationOperatorCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEssentialOCLNavigationOperatorCS4777); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2213:1: ruleEssentialOCLNavigationOperatorCS returns [EObject current=null] : ( ( (lv_name_0_1= '.' | lv_name_0_2= '->' ) ) ) ;
    public final EObject ruleEssentialOCLNavigationOperatorCS() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2216:28: ( ( ( (lv_name_0_1= '.' | lv_name_0_2= '->' ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2217:1: ( ( (lv_name_0_1= '.' | lv_name_0_2= '->' ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2217:1: ( ( (lv_name_0_1= '.' | lv_name_0_2= '->' ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2218:1: ( (lv_name_0_1= '.' | lv_name_0_2= '->' ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2218:1: ( (lv_name_0_1= '.' | lv_name_0_2= '->' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2219:1: (lv_name_0_1= '.' | lv_name_0_2= '->' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2219:1: (lv_name_0_1= '.' | lv_name_0_2= '->' )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==55) ) {
                alt42=1;
            }
            else if ( (LA42_0==56) ) {
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2220:3: lv_name_0_1= '.'
                    {
                    lv_name_0_1=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleEssentialOCLNavigationOperatorCS4821); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2232:8: lv_name_0_2= '->'
                    {
                    lv_name_0_2=(Token)match(input,56,FollowSets000.FOLLOW_56_in_ruleEssentialOCLNavigationOperatorCS4850); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2255:1: entryRuleIdentifier returns [String current=null] : iv_ruleIdentifier= ruleIdentifier EOF ;
    public final String entryRuleIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdentifier = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2256:2: (iv_ruleIdentifier= ruleIdentifier EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2257:2: iv_ruleIdentifier= ruleIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIdentifierRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_entryRuleIdentifier4902);
            iv_ruleIdentifier=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIdentifier.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIdentifier4913); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2264:1: ruleIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= ruleID ;
    public final AntlrDatatypeRuleToken ruleIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_ID_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2267:28: (this_ID_0= ruleID )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2269:5: this_ID_0= ruleID
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getIdentifierAccess().getIDParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleID_in_ruleIdentifier4959);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2287:1: entryRuleStringLiteral returns [String current=null] : iv_ruleStringLiteral= ruleStringLiteral EOF ;
    public final String entryRuleStringLiteral() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleStringLiteral = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2288:2: (iv_ruleStringLiteral= ruleStringLiteral EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2289:2: iv_ruleStringLiteral= ruleStringLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStringLiteralRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral5004);
            iv_ruleStringLiteral=ruleStringLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStringLiteral.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleStringLiteral5015); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2296:1: ruleStringLiteral returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING ;
    public final AntlrDatatypeRuleToken ruleStringLiteral() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_SINGLE_QUOTED_STRING_0=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2299:28: (this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2300:5: this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING
            {
            this_SINGLE_QUOTED_STRING_0=(Token)match(input,RULE_SINGLE_QUOTED_STRING,FollowSets000.FOLLOW_RULE_SINGLE_QUOTED_STRING_in_ruleStringLiteral5054); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2315:1: entryRuleBinaryOperatorCS returns [EObject current=null] : iv_ruleBinaryOperatorCS= ruleBinaryOperatorCS EOF ;
    public final EObject entryRuleBinaryOperatorCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinaryOperatorCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2316:2: (iv_ruleBinaryOperatorCS= ruleBinaryOperatorCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2317:2: iv_ruleBinaryOperatorCS= ruleBinaryOperatorCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBinaryOperatorCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleBinaryOperatorCS_in_entryRuleBinaryOperatorCS5098);
            iv_ruleBinaryOperatorCS=ruleBinaryOperatorCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBinaryOperatorCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBinaryOperatorCS5108); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2324:1: ruleBinaryOperatorCS returns [EObject current=null] : (this_InfixOperatorCS_0= ruleInfixOperatorCS | this_NavigationOperatorCS_1= ruleNavigationOperatorCS ) ;
    public final EObject ruleBinaryOperatorCS() throws RecognitionException {
        EObject current = null;

        EObject this_InfixOperatorCS_0 = null;

        EObject this_NavigationOperatorCS_1 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2327:28: ( (this_InfixOperatorCS_0= ruleInfixOperatorCS | this_NavigationOperatorCS_1= ruleNavigationOperatorCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2328:1: (this_InfixOperatorCS_0= ruleInfixOperatorCS | this_NavigationOperatorCS_1= ruleNavigationOperatorCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2328:1: (this_InfixOperatorCS_0= ruleInfixOperatorCS | this_NavigationOperatorCS_1= ruleNavigationOperatorCS )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==34||LA43_0==41||(LA43_0>=43 && LA43_0<=54)) ) {
                alt43=1;
            }
            else if ( ((LA43_0>=55 && LA43_0<=56)) ) {
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2329:2: this_InfixOperatorCS_0= ruleInfixOperatorCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBinaryOperatorCSAccess().getInfixOperatorCSParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleInfixOperatorCS_in_ruleBinaryOperatorCS5158);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2342:2: this_NavigationOperatorCS_1= ruleNavigationOperatorCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBinaryOperatorCSAccess().getNavigationOperatorCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNavigationOperatorCS_in_ruleBinaryOperatorCS5188);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2361:1: entryRuleInfixOperatorCS returns [EObject current=null] : iv_ruleInfixOperatorCS= ruleInfixOperatorCS EOF ;
    public final EObject entryRuleInfixOperatorCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInfixOperatorCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2362:2: (iv_ruleInfixOperatorCS= ruleInfixOperatorCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2363:2: iv_ruleInfixOperatorCS= ruleInfixOperatorCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInfixOperatorCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleInfixOperatorCS_in_entryRuleInfixOperatorCS5223);
            iv_ruleInfixOperatorCS=ruleInfixOperatorCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInfixOperatorCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleInfixOperatorCS5233); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2370:1: ruleInfixOperatorCS returns [EObject current=null] : this_EssentialOCLInfixOperatorCS_0= ruleEssentialOCLInfixOperatorCS ;
    public final EObject ruleInfixOperatorCS() throws RecognitionException {
        EObject current = null;

        EObject this_EssentialOCLInfixOperatorCS_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2373:28: (this_EssentialOCLInfixOperatorCS_0= ruleEssentialOCLInfixOperatorCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2375:2: this_EssentialOCLInfixOperatorCS_0= ruleEssentialOCLInfixOperatorCS
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getInfixOperatorCSAccess().getEssentialOCLInfixOperatorCSParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLInfixOperatorCS_in_ruleInfixOperatorCS5282);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2394:1: entryRuleNavigationOperatorCS returns [EObject current=null] : iv_ruleNavigationOperatorCS= ruleNavigationOperatorCS EOF ;
    public final EObject entryRuleNavigationOperatorCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigationOperatorCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2395:2: (iv_ruleNavigationOperatorCS= ruleNavigationOperatorCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2396:2: iv_ruleNavigationOperatorCS= ruleNavigationOperatorCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigationOperatorCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigationOperatorCS_in_entryRuleNavigationOperatorCS5316);
            iv_ruleNavigationOperatorCS=ruleNavigationOperatorCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigationOperatorCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigationOperatorCS5326); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2403:1: ruleNavigationOperatorCS returns [EObject current=null] : this_EssentialOCLNavigationOperatorCS_0= ruleEssentialOCLNavigationOperatorCS ;
    public final EObject ruleNavigationOperatorCS() throws RecognitionException {
        EObject current = null;

        EObject this_EssentialOCLNavigationOperatorCS_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2406:28: (this_EssentialOCLNavigationOperatorCS_0= ruleEssentialOCLNavigationOperatorCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2408:2: this_EssentialOCLNavigationOperatorCS_0= ruleEssentialOCLNavigationOperatorCS
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getNavigationOperatorCSAccess().getEssentialOCLNavigationOperatorCSParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLNavigationOperatorCS_in_ruleNavigationOperatorCS5375);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2427:1: entryRuleUnaryOperatorCS returns [EObject current=null] : iv_ruleUnaryOperatorCS= ruleUnaryOperatorCS EOF ;
    public final EObject entryRuleUnaryOperatorCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryOperatorCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2428:2: (iv_ruleUnaryOperatorCS= ruleUnaryOperatorCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2429:2: iv_ruleUnaryOperatorCS= ruleUnaryOperatorCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryOperatorCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnaryOperatorCS_in_entryRuleUnaryOperatorCS5409);
            iv_ruleUnaryOperatorCS=ruleUnaryOperatorCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnaryOperatorCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnaryOperatorCS5419); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2436:1: ruleUnaryOperatorCS returns [EObject current=null] : this_EssentialOCLUnaryOperatorCS_0= ruleEssentialOCLUnaryOperatorCS ;
    public final EObject ruleUnaryOperatorCS() throws RecognitionException {
        EObject current = null;

        EObject this_EssentialOCLUnaryOperatorCS_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2439:28: (this_EssentialOCLUnaryOperatorCS_0= ruleEssentialOCLUnaryOperatorCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2441:2: this_EssentialOCLUnaryOperatorCS_0= ruleEssentialOCLUnaryOperatorCS
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getUnaryOperatorCSAccess().getEssentialOCLUnaryOperatorCSParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLUnaryOperatorCS_in_ruleUnaryOperatorCS5468);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2460:1: entryRuleEssentialOCLUnrestrictedName returns [String current=null] : iv_ruleEssentialOCLUnrestrictedName= ruleEssentialOCLUnrestrictedName EOF ;
    public final String entryRuleEssentialOCLUnrestrictedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEssentialOCLUnrestrictedName = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2461:2: (iv_ruleEssentialOCLUnrestrictedName= ruleEssentialOCLUnrestrictedName EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2462:2: iv_ruleEssentialOCLUnrestrictedName= ruleEssentialOCLUnrestrictedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEssentialOCLUnrestrictedNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLUnrestrictedName_in_entryRuleEssentialOCLUnrestrictedName5503);
            iv_ruleEssentialOCLUnrestrictedName=ruleEssentialOCLUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEssentialOCLUnrestrictedName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEssentialOCLUnrestrictedName5514); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2469:1: ruleEssentialOCLUnrestrictedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_Identifier_0= ruleIdentifier ;
    public final AntlrDatatypeRuleToken ruleEssentialOCLUnrestrictedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_Identifier_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2472:28: (this_Identifier_0= ruleIdentifier )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2474:5: this_Identifier_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getEssentialOCLUnrestrictedNameAccess().getIdentifierParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_ruleEssentialOCLUnrestrictedName5560);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2492:1: entryRuleEssentialOCLUnreservedName returns [String current=null] : iv_ruleEssentialOCLUnreservedName= ruleEssentialOCLUnreservedName EOF ;
    public final String entryRuleEssentialOCLUnreservedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEssentialOCLUnreservedName = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2493:2: (iv_ruleEssentialOCLUnreservedName= ruleEssentialOCLUnreservedName EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2494:2: iv_ruleEssentialOCLUnreservedName= ruleEssentialOCLUnreservedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEssentialOCLUnreservedNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLUnreservedName_in_entryRuleEssentialOCLUnreservedName5605);
            iv_ruleEssentialOCLUnreservedName=ruleEssentialOCLUnreservedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEssentialOCLUnreservedName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEssentialOCLUnreservedName5616); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2501:1: ruleEssentialOCLUnreservedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_UnrestrictedName_0= ruleUnrestrictedName | this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier | this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier | kw= 'Tuple' ) ;
    public final AntlrDatatypeRuleToken ruleEssentialOCLUnreservedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_UnrestrictedName_0 = null;

        AntlrDatatypeRuleToken this_CollectionTypeIdentifier_1 = null;

        AntlrDatatypeRuleToken this_PrimitiveTypeIdentifier_2 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2504:28: ( (this_UnrestrictedName_0= ruleUnrestrictedName | this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier | this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier | kw= 'Tuple' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2505:1: (this_UnrestrictedName_0= ruleUnrestrictedName | this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier | this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier | kw= 'Tuple' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2505:1: (this_UnrestrictedName_0= ruleUnrestrictedName | this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier | this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier | kw= 'Tuple' )
            int alt44=4;
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
                alt44=1;
                }
                break;
            case 66:
            case 67:
            case 68:
            case 69:
            case 70:
                {
                alt44=2;
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
                alt44=3;
                }
                break;
            case 57:
                {
                alt44=4;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2506:5: this_UnrestrictedName_0= ruleUnrestrictedName
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getEssentialOCLUnreservedNameAccess().getUnrestrictedNameParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleEssentialOCLUnreservedName5663);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2518:5: this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getEssentialOCLUnreservedNameAccess().getCollectionTypeIdentifierParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCollectionTypeIdentifier_in_ruleEssentialOCLUnreservedName5696);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2530:5: this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getEssentialOCLUnreservedNameAccess().getPrimitiveTypeIdentifierParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrimitiveTypeIdentifier_in_ruleEssentialOCLUnreservedName5729);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2542:2: kw= 'Tuple'
                    {
                    kw=(Token)match(input,57,FollowSets000.FOLLOW_57_in_ruleEssentialOCLUnreservedName5753); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2555:1: entryRuleUnreservedName returns [String current=null] : iv_ruleUnreservedName= ruleUnreservedName EOF ;
    public final String entryRuleUnreservedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnreservedName = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2556:2: (iv_ruleUnreservedName= ruleUnreservedName EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2557:2: iv_ruleUnreservedName= ruleUnreservedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnreservedNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnreservedName_in_entryRuleUnreservedName5794);
            iv_ruleUnreservedName=ruleUnreservedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnreservedName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnreservedName5805); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2564:1: ruleUnreservedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_EssentialOCLUnreservedName_0= ruleEssentialOCLUnreservedName ;
    public final AntlrDatatypeRuleToken ruleUnreservedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_EssentialOCLUnreservedName_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2567:28: (this_EssentialOCLUnreservedName_0= ruleEssentialOCLUnreservedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2569:5: this_EssentialOCLUnreservedName_0= ruleEssentialOCLUnreservedName
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getUnreservedNameAccess().getEssentialOCLUnreservedNameParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLUnreservedName_in_ruleUnreservedName5851);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2587:1: entryRulePathNameCS returns [EObject current=null] : iv_rulePathNameCS= rulePathNameCS EOF ;
    public final EObject entryRulePathNameCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePathNameCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2588:2: (iv_rulePathNameCS= rulePathNameCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2589:2: iv_rulePathNameCS= rulePathNameCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPathNameCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePathNameCS_in_entryRulePathNameCS5895);
            iv_rulePathNameCS=rulePathNameCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePathNameCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePathNameCS5905); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2596:1: rulePathNameCS returns [EObject current=null] : ( ( (lv_path_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )* ) ;
    public final EObject rulePathNameCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_path_0_0 = null;

        EObject lv_path_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2599:28: ( ( ( (lv_path_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )* ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2600:1: ( ( (lv_path_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )* )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2600:1: ( ( (lv_path_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )* )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2600:2: ( (lv_path_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )*
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2600:2: ( (lv_path_0_0= ruleFirstPathElementCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2601:1: (lv_path_0_0= ruleFirstPathElementCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2601:1: (lv_path_0_0= ruleFirstPathElementCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2602:3: lv_path_0_0= ruleFirstPathElementCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPathNameCSAccess().getPathFirstPathElementCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleFirstPathElementCS_in_rulePathNameCS5951);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2618:2: (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==33) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2618:4: otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) )
            	    {
            	    otherlv_1=(Token)match(input,33,FollowSets000.FOLLOW_33_in_rulePathNameCS5964); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getPathNameCSAccess().getColonColonKeyword_1_0());
            	          
            	    }
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2622:1: ( (lv_path_2_0= ruleNextPathElementCS ) )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2623:1: (lv_path_2_0= ruleNextPathElementCS )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2623:1: (lv_path_2_0= ruleNextPathElementCS )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2624:3: lv_path_2_0= ruleNextPathElementCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getPathNameCSAccess().getPathNextPathElementCSParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleNextPathElementCS_in_rulePathNameCS5985);
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
    // $ANTLR end "rulePathNameCS"


    // $ANTLR start "entryRuleFirstPathElementCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2648:1: entryRuleFirstPathElementCS returns [EObject current=null] : iv_ruleFirstPathElementCS= ruleFirstPathElementCS EOF ;
    public final EObject entryRuleFirstPathElementCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFirstPathElementCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2649:2: (iv_ruleFirstPathElementCS= ruleFirstPathElementCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2650:2: iv_ruleFirstPathElementCS= ruleFirstPathElementCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFirstPathElementCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleFirstPathElementCS_in_entryRuleFirstPathElementCS6023);
            iv_ruleFirstPathElementCS=ruleFirstPathElementCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFirstPathElementCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFirstPathElementCS6033); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2657:1: ruleFirstPathElementCS returns [EObject current=null] : ( ( ruleUnrestrictedName ) ) ;
    public final EObject ruleFirstPathElementCS() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2660:28: ( ( ( ruleUnrestrictedName ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2661:1: ( ( ruleUnrestrictedName ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2661:1: ( ( ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2662:1: ( ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2662:1: ( ruleUnrestrictedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2663:3: ruleUnrestrictedName
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
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleFirstPathElementCS6084);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2687:1: entryRuleNextPathElementCS returns [EObject current=null] : iv_ruleNextPathElementCS= ruleNextPathElementCS EOF ;
    public final EObject entryRuleNextPathElementCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNextPathElementCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2688:2: (iv_ruleNextPathElementCS= ruleNextPathElementCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2689:2: iv_ruleNextPathElementCS= ruleNextPathElementCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNextPathElementCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNextPathElementCS_in_entryRuleNextPathElementCS6119);
            iv_ruleNextPathElementCS=ruleNextPathElementCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNextPathElementCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNextPathElementCS6129); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2696:1: ruleNextPathElementCS returns [EObject current=null] : ( ( ruleUnreservedName ) ) ;
    public final EObject ruleNextPathElementCS() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2699:28: ( ( ( ruleUnreservedName ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2700:1: ( ( ruleUnreservedName ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2700:1: ( ( ruleUnreservedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2701:1: ( ruleUnreservedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2701:1: ( ruleUnreservedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2702:3: ruleUnreservedName
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
            pushFollow(FollowSets000.FOLLOW_ruleUnreservedName_in_ruleNextPathElementCS6180);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2726:1: entryRuleURIPathNameCS returns [EObject current=null] : iv_ruleURIPathNameCS= ruleURIPathNameCS EOF ;
    public final EObject entryRuleURIPathNameCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleURIPathNameCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2727:2: (iv_ruleURIPathNameCS= ruleURIPathNameCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2728:2: iv_ruleURIPathNameCS= ruleURIPathNameCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getURIPathNameCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleURIPathNameCS_in_entryRuleURIPathNameCS6215);
            iv_ruleURIPathNameCS=ruleURIPathNameCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleURIPathNameCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleURIPathNameCS6225); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2735:1: ruleURIPathNameCS returns [EObject current=null] : ( ( (lv_path_0_0= ruleURIFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )* ) ;
    public final EObject ruleURIPathNameCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_path_0_0 = null;

        EObject lv_path_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2738:28: ( ( ( (lv_path_0_0= ruleURIFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )* ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2739:1: ( ( (lv_path_0_0= ruleURIFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )* )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2739:1: ( ( (lv_path_0_0= ruleURIFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )* )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2739:2: ( (lv_path_0_0= ruleURIFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )*
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2739:2: ( (lv_path_0_0= ruleURIFirstPathElementCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2740:1: (lv_path_0_0= ruleURIFirstPathElementCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2740:1: (lv_path_0_0= ruleURIFirstPathElementCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2741:3: lv_path_0_0= ruleURIFirstPathElementCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getURIPathNameCSAccess().getPathURIFirstPathElementCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleURIFirstPathElementCS_in_ruleURIPathNameCS6271);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2757:2: (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==33) ) {
                    int LA46_1 = input.LA(2);

                    if ( ((LA46_1>=RULE_SIMPLE_ID && LA46_1<=RULE_ESCAPED_ID)||LA46_1==16||LA46_1==18||(LA46_1>=27 && LA46_1<=28)||LA46_1==31||(LA46_1>=35 && LA46_1<=40)||(LA46_1>=57 && LA46_1<=70)) ) {
                        alt46=1;
                    }


                }


                switch (alt46) {
            	case 1 :
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2757:4: otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) )
            	    {
            	    otherlv_1=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleURIPathNameCS6284); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getURIPathNameCSAccess().getColonColonKeyword_1_0());
            	          
            	    }
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2761:1: ( (lv_path_2_0= ruleNextPathElementCS ) )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2762:1: (lv_path_2_0= ruleNextPathElementCS )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2762:1: (lv_path_2_0= ruleNextPathElementCS )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2763:3: lv_path_2_0= ruleNextPathElementCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getURIPathNameCSAccess().getPathNextPathElementCSParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleNextPathElementCS_in_ruleURIPathNameCS6305);
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
            	    break loop46;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2787:1: entryRuleURIFirstPathElementCS returns [EObject current=null] : iv_ruleURIFirstPathElementCS= ruleURIFirstPathElementCS EOF ;
    public final EObject entryRuleURIFirstPathElementCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleURIFirstPathElementCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2788:2: (iv_ruleURIFirstPathElementCS= ruleURIFirstPathElementCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2789:2: iv_ruleURIFirstPathElementCS= ruleURIFirstPathElementCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getURIFirstPathElementCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleURIFirstPathElementCS_in_entryRuleURIFirstPathElementCS6343);
            iv_ruleURIFirstPathElementCS=ruleURIFirstPathElementCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleURIFirstPathElementCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleURIFirstPathElementCS6353); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2796:1: ruleURIFirstPathElementCS returns [EObject current=null] : ( ( ( ruleUnrestrictedName ) ) | ( () ( ( ruleURI ) ) ) ) ;
    public final EObject ruleURIFirstPathElementCS() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2799:28: ( ( ( ( ruleUnrestrictedName ) ) | ( () ( ( ruleURI ) ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2800:1: ( ( ( ruleUnrestrictedName ) ) | ( () ( ( ruleURI ) ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2800:1: ( ( ( ruleUnrestrictedName ) ) | ( () ( ( ruleURI ) ) ) )
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( ((LA47_0>=RULE_SIMPLE_ID && LA47_0<=RULE_ESCAPED_ID)||LA47_0==16||LA47_0==18||(LA47_0>=27 && LA47_0<=28)||LA47_0==31||(LA47_0>=35 && LA47_0<=40)) ) {
                alt47=1;
            }
            else if ( (LA47_0==RULE_SINGLE_QUOTED_STRING) ) {
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2800:2: ( ( ruleUnrestrictedName ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2800:2: ( ( ruleUnrestrictedName ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2801:1: ( ruleUnrestrictedName )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2801:1: ( ruleUnrestrictedName )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2802:3: ruleUnrestrictedName
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
                    pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleURIFirstPathElementCS6405);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2819:6: ( () ( ( ruleURI ) ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2819:6: ( () ( ( ruleURI ) ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2819:7: () ( ( ruleURI ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2819:7: ()
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2820:2: 
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

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2828:2: ( ( ruleURI ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2829:1: ( ruleURI )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2829:1: ( ruleURI )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2830:3: ruleURI
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
                    pushFollow(FollowSets000.FOLLOW_ruleURI_in_ruleURIFirstPathElementCS6451);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2854:1: entryRulePrimitiveTypeIdentifier returns [String current=null] : iv_rulePrimitiveTypeIdentifier= rulePrimitiveTypeIdentifier EOF ;
    public final String entryRulePrimitiveTypeIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePrimitiveTypeIdentifier = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2855:2: (iv_rulePrimitiveTypeIdentifier= rulePrimitiveTypeIdentifier EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2856:2: iv_rulePrimitiveTypeIdentifier= rulePrimitiveTypeIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimitiveTypeIdentifierRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePrimitiveTypeIdentifier_in_entryRulePrimitiveTypeIdentifier6489);
            iv_rulePrimitiveTypeIdentifier=rulePrimitiveTypeIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimitiveTypeIdentifier.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrimitiveTypeIdentifier6500); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2863:1: rulePrimitiveTypeIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Boolean' | kw= 'Integer' | kw= 'Real' | kw= 'String' | kw= 'UnlimitedNatural' | kw= 'OclAny' | kw= 'OclInvalid' | kw= 'OclVoid' ) ;
    public final AntlrDatatypeRuleToken rulePrimitiveTypeIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2866:28: ( (kw= 'Boolean' | kw= 'Integer' | kw= 'Real' | kw= 'String' | kw= 'UnlimitedNatural' | kw= 'OclAny' | kw= 'OclInvalid' | kw= 'OclVoid' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2867:1: (kw= 'Boolean' | kw= 'Integer' | kw= 'Real' | kw= 'String' | kw= 'UnlimitedNatural' | kw= 'OclAny' | kw= 'OclInvalid' | kw= 'OclVoid' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2867:1: (kw= 'Boolean' | kw= 'Integer' | kw= 'Real' | kw= 'String' | kw= 'UnlimitedNatural' | kw= 'OclAny' | kw= 'OclInvalid' | kw= 'OclVoid' )
            int alt48=8;
            switch ( input.LA(1) ) {
            case 58:
                {
                alt48=1;
                }
                break;
            case 59:
                {
                alt48=2;
                }
                break;
            case 60:
                {
                alt48=3;
                }
                break;
            case 61:
                {
                alt48=4;
                }
                break;
            case 62:
                {
                alt48=5;
                }
                break;
            case 63:
                {
                alt48=6;
                }
                break;
            case 64:
                {
                alt48=7;
                }
                break;
            case 65:
                {
                alt48=8;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2868:2: kw= 'Boolean'
                    {
                    kw=(Token)match(input,58,FollowSets000.FOLLOW_58_in_rulePrimitiveTypeIdentifier6538); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getBooleanKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2875:2: kw= 'Integer'
                    {
                    kw=(Token)match(input,59,FollowSets000.FOLLOW_59_in_rulePrimitiveTypeIdentifier6557); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getIntegerKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2882:2: kw= 'Real'
                    {
                    kw=(Token)match(input,60,FollowSets000.FOLLOW_60_in_rulePrimitiveTypeIdentifier6576); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getRealKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2889:2: kw= 'String'
                    {
                    kw=(Token)match(input,61,FollowSets000.FOLLOW_61_in_rulePrimitiveTypeIdentifier6595); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getStringKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2896:2: kw= 'UnlimitedNatural'
                    {
                    kw=(Token)match(input,62,FollowSets000.FOLLOW_62_in_rulePrimitiveTypeIdentifier6614); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getUnlimitedNaturalKeyword_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2903:2: kw= 'OclAny'
                    {
                    kw=(Token)match(input,63,FollowSets000.FOLLOW_63_in_rulePrimitiveTypeIdentifier6633); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getOclAnyKeyword_5()); 
                          
                    }

                    }
                    break;
                case 7 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2910:2: kw= 'OclInvalid'
                    {
                    kw=(Token)match(input,64,FollowSets000.FOLLOW_64_in_rulePrimitiveTypeIdentifier6652); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getOclInvalidKeyword_6()); 
                          
                    }

                    }
                    break;
                case 8 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2917:2: kw= 'OclVoid'
                    {
                    kw=(Token)match(input,65,FollowSets000.FOLLOW_65_in_rulePrimitiveTypeIdentifier6671); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2930:1: entryRulePrimitiveTypeCS returns [EObject current=null] : iv_rulePrimitiveTypeCS= rulePrimitiveTypeCS EOF ;
    public final EObject entryRulePrimitiveTypeCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveTypeCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2931:2: (iv_rulePrimitiveTypeCS= rulePrimitiveTypeCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2932:2: iv_rulePrimitiveTypeCS= rulePrimitiveTypeCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimitiveTypeCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePrimitiveTypeCS_in_entryRulePrimitiveTypeCS6711);
            iv_rulePrimitiveTypeCS=rulePrimitiveTypeCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimitiveTypeCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrimitiveTypeCS6721); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2939:1: rulePrimitiveTypeCS returns [EObject current=null] : ( (lv_name_0_0= rulePrimitiveTypeIdentifier ) ) ;
    public final EObject rulePrimitiveTypeCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2942:28: ( ( (lv_name_0_0= rulePrimitiveTypeIdentifier ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2943:1: ( (lv_name_0_0= rulePrimitiveTypeIdentifier ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2943:1: ( (lv_name_0_0= rulePrimitiveTypeIdentifier ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2944:1: (lv_name_0_0= rulePrimitiveTypeIdentifier )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2944:1: (lv_name_0_0= rulePrimitiveTypeIdentifier )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2945:3: lv_name_0_0= rulePrimitiveTypeIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPrimitiveTypeCSAccess().getNamePrimitiveTypeIdentifierParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_rulePrimitiveTypeIdentifier_in_rulePrimitiveTypeCS6766);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2969:1: entryRuleCollectionTypeIdentifier returns [String current=null] : iv_ruleCollectionTypeIdentifier= ruleCollectionTypeIdentifier EOF ;
    public final String entryRuleCollectionTypeIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleCollectionTypeIdentifier = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2970:2: (iv_ruleCollectionTypeIdentifier= ruleCollectionTypeIdentifier EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2971:2: iv_ruleCollectionTypeIdentifier= ruleCollectionTypeIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCollectionTypeIdentifierRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleCollectionTypeIdentifier_in_entryRuleCollectionTypeIdentifier6802);
            iv_ruleCollectionTypeIdentifier=ruleCollectionTypeIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCollectionTypeIdentifier.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCollectionTypeIdentifier6813); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2978:1: ruleCollectionTypeIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Set' | kw= 'Bag' | kw= 'Sequence' | kw= 'Collection' | kw= 'OrderedSet' ) ;
    public final AntlrDatatypeRuleToken ruleCollectionTypeIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2981:28: ( (kw= 'Set' | kw= 'Bag' | kw= 'Sequence' | kw= 'Collection' | kw= 'OrderedSet' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2982:1: (kw= 'Set' | kw= 'Bag' | kw= 'Sequence' | kw= 'Collection' | kw= 'OrderedSet' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2982:1: (kw= 'Set' | kw= 'Bag' | kw= 'Sequence' | kw= 'Collection' | kw= 'OrderedSet' )
            int alt49=5;
            switch ( input.LA(1) ) {
            case 66:
                {
                alt49=1;
                }
                break;
            case 67:
                {
                alt49=2;
                }
                break;
            case 68:
                {
                alt49=3;
                }
                break;
            case 69:
                {
                alt49=4;
                }
                break;
            case 70:
                {
                alt49=5;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2983:2: kw= 'Set'
                    {
                    kw=(Token)match(input,66,FollowSets000.FOLLOW_66_in_ruleCollectionTypeIdentifier6851); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getSetKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2990:2: kw= 'Bag'
                    {
                    kw=(Token)match(input,67,FollowSets000.FOLLOW_67_in_ruleCollectionTypeIdentifier6870); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getBagKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2997:2: kw= 'Sequence'
                    {
                    kw=(Token)match(input,68,FollowSets000.FOLLOW_68_in_ruleCollectionTypeIdentifier6889); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getSequenceKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3004:2: kw= 'Collection'
                    {
                    kw=(Token)match(input,69,FollowSets000.FOLLOW_69_in_ruleCollectionTypeIdentifier6908); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getCollectionKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3011:2: kw= 'OrderedSet'
                    {
                    kw=(Token)match(input,70,FollowSets000.FOLLOW_70_in_ruleCollectionTypeIdentifier6927); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3024:1: entryRuleCollectionTypeCS returns [EObject current=null] : iv_ruleCollectionTypeCS= ruleCollectionTypeCS EOF ;
    public final EObject entryRuleCollectionTypeCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionTypeCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3025:2: (iv_ruleCollectionTypeCS= ruleCollectionTypeCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3026:2: iv_ruleCollectionTypeCS= ruleCollectionTypeCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCollectionTypeCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleCollectionTypeCS_in_entryRuleCollectionTypeCS6967);
            iv_ruleCollectionTypeCS=ruleCollectionTypeCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCollectionTypeCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCollectionTypeCS6977); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3033:1: ruleCollectionTypeCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )? ) ;
    public final EObject ruleCollectionTypeCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3036:28: ( ( ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3037:1: ( ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3037:1: ( ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3037:2: ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )?
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3037:2: ( (lv_name_0_0= ruleCollectionTypeIdentifier ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3038:1: (lv_name_0_0= ruleCollectionTypeIdentifier )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3038:1: (lv_name_0_0= ruleCollectionTypeIdentifier )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3039:3: lv_name_0_0= ruleCollectionTypeIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCollectionTypeCSAccess().getNameCollectionTypeIdentifierParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleCollectionTypeIdentifier_in_ruleCollectionTypeCS7023);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3055:2: (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==29) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3055:4: otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleCollectionTypeCS7036); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getCollectionTypeCSAccess().getLeftParenthesisKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3059:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3060:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3060:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3061:3: lv_ownedType_2_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionTypeCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleCollectionTypeCS7057);
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

                    otherlv_3=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleCollectionTypeCS7069); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3089:1: entryRuleMultiplicityBoundsCS returns [EObject current=null] : iv_ruleMultiplicityBoundsCS= ruleMultiplicityBoundsCS EOF ;
    public final EObject entryRuleMultiplicityBoundsCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicityBoundsCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3090:2: (iv_ruleMultiplicityBoundsCS= ruleMultiplicityBoundsCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3091:2: iv_ruleMultiplicityBoundsCS= ruleMultiplicityBoundsCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicityBoundsCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMultiplicityBoundsCS_in_entryRuleMultiplicityBoundsCS7107);
            iv_ruleMultiplicityBoundsCS=ruleMultiplicityBoundsCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicityBoundsCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMultiplicityBoundsCS7117); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3098:1: ruleMultiplicityBoundsCS returns [EObject current=null] : ( ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )? ) ;
    public final EObject ruleMultiplicityBoundsCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_lowerBound_0_0 = null;

        AntlrDatatypeRuleToken lv_upperBound_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3101:28: ( ( ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3102:1: ( ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3102:1: ( ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3102:2: ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )?
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3102:2: ( (lv_lowerBound_0_0= ruleLOWER ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3103:1: (lv_lowerBound_0_0= ruleLOWER )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3103:1: (lv_lowerBound_0_0= ruleLOWER )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3104:3: lv_lowerBound_0_0= ruleLOWER
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiplicityBoundsCSAccess().getLowerBoundLOWERParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleLOWER_in_ruleMultiplicityBoundsCS7163);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3120:2: (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==71) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3120:4: otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) )
                    {
                    otherlv_1=(Token)match(input,71,FollowSets000.FOLLOW_71_in_ruleMultiplicityBoundsCS7176); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getMultiplicityBoundsCSAccess().getFullStopFullStopKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3124:1: ( (lv_upperBound_2_0= ruleUPPER ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3125:1: (lv_upperBound_2_0= ruleUPPER )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3125:1: (lv_upperBound_2_0= ruleUPPER )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3126:3: lv_upperBound_2_0= ruleUPPER
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMultiplicityBoundsCSAccess().getUpperBoundUPPERParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUPPER_in_ruleMultiplicityBoundsCS7197);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3150:1: entryRuleMultiplicityCS returns [EObject current=null] : iv_ruleMultiplicityCS= ruleMultiplicityCS EOF ;
    public final EObject entryRuleMultiplicityCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicityCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3151:2: (iv_ruleMultiplicityCS= ruleMultiplicityCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3152:2: iv_ruleMultiplicityCS= ruleMultiplicityCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicityCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMultiplicityCS_in_entryRuleMultiplicityCS7235);
            iv_ruleMultiplicityCS=ruleMultiplicityCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicityCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMultiplicityCS7245); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3159:1: ruleMultiplicityCS returns [EObject current=null] : (otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) otherlv_3= ']' ) ;
    public final EObject ruleMultiplicityCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        EObject this_MultiplicityBoundsCS_1 = null;

        EObject this_MultiplicityStringCS_2 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3162:28: ( (otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) otherlv_3= ']' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3163:1: (otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) otherlv_3= ']' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3163:1: (otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) otherlv_3= ']' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3163:3: otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) otherlv_3= ']'
            {
            otherlv_0=(Token)match(input,72,FollowSets000.FOLLOW_72_in_ruleMultiplicityCS7282); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMultiplicityCSAccess().getLeftSquareBracketKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3167:1: (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS )
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==RULE_INT) ) {
                alt52=1;
            }
            else if ( (LA52_0==34||LA52_0==44||LA52_0==74) ) {
                alt52=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }
            switch (alt52) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3168:2: this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getMultiplicityCSAccess().getMultiplicityBoundsCSParserRuleCall_1_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMultiplicityBoundsCS_in_ruleMultiplicityCS7308);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3181:2: this_MultiplicityStringCS_2= ruleMultiplicityStringCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getMultiplicityCSAccess().getMultiplicityStringCSParserRuleCall_1_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMultiplicityStringCS_in_ruleMultiplicityCS7338);
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

            otherlv_3=(Token)match(input,73,FollowSets000.FOLLOW_73_in_ruleMultiplicityCS7350); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3204:1: entryRuleMultiplicityStringCS returns [EObject current=null] : iv_ruleMultiplicityStringCS= ruleMultiplicityStringCS EOF ;
    public final EObject entryRuleMultiplicityStringCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicityStringCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3205:2: (iv_ruleMultiplicityStringCS= ruleMultiplicityStringCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3206:2: iv_ruleMultiplicityStringCS= ruleMultiplicityStringCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicityStringCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMultiplicityStringCS_in_entryRuleMultiplicityStringCS7386);
            iv_ruleMultiplicityStringCS=ruleMultiplicityStringCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicityStringCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMultiplicityStringCS7396); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3213:1: ruleMultiplicityStringCS returns [EObject current=null] : ( ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) ) ) ;
    public final EObject ruleMultiplicityStringCS() throws RecognitionException {
        EObject current = null;

        Token lv_stringBounds_0_1=null;
        Token lv_stringBounds_0_2=null;
        Token lv_stringBounds_0_3=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3216:28: ( ( ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3217:1: ( ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3217:1: ( ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3218:1: ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3218:1: ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3219:1: (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3219:1: (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' )
            int alt53=3;
            switch ( input.LA(1) ) {
            case 34:
                {
                alt53=1;
                }
                break;
            case 44:
                {
                alt53=2;
                }
                break;
            case 74:
                {
                alt53=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;
            }

            switch (alt53) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3220:3: lv_stringBounds_0_1= '*'
                    {
                    lv_stringBounds_0_1=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleMultiplicityStringCS7440); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3232:8: lv_stringBounds_0_2= '+'
                    {
                    lv_stringBounds_0_2=(Token)match(input,44,FollowSets000.FOLLOW_44_in_ruleMultiplicityStringCS7469); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3244:8: lv_stringBounds_0_3= '?'
                    {
                    lv_stringBounds_0_3=(Token)match(input,74,FollowSets000.FOLLOW_74_in_ruleMultiplicityStringCS7498); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3267:1: entryRuleTupleTypeCS returns [EObject current=null] : iv_ruleTupleTypeCS= ruleTupleTypeCS EOF ;
    public final EObject entryRuleTupleTypeCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTupleTypeCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3268:2: (iv_ruleTupleTypeCS= ruleTupleTypeCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3269:2: iv_ruleTupleTypeCS= ruleTupleTypeCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTupleTypeCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTupleTypeCS_in_entryRuleTupleTypeCS7549);
            iv_ruleTupleTypeCS=ruleTupleTypeCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTupleTypeCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTupleTypeCS7559); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3276:1: ruleTupleTypeCS returns [EObject current=null] : ( ( (lv_name_0_0= 'Tuple' ) ) (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )? ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3279:28: ( ( ( (lv_name_0_0= 'Tuple' ) ) (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3280:1: ( ( (lv_name_0_0= 'Tuple' ) ) (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3280:1: ( ( (lv_name_0_0= 'Tuple' ) ) (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3280:2: ( (lv_name_0_0= 'Tuple' ) ) (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )?
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3280:2: ( (lv_name_0_0= 'Tuple' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3281:1: (lv_name_0_0= 'Tuple' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3281:1: (lv_name_0_0= 'Tuple' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3282:3: lv_name_0_0= 'Tuple'
            {
            lv_name_0_0=(Token)match(input,57,FollowSets000.FOLLOW_57_in_ruleTupleTypeCS7602); if (state.failed) return current;
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3295:2: (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==29) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3295:4: otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')'
                    {
                    otherlv_1=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleTupleTypeCS7628); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getTupleTypeCSAccess().getLeftParenthesisKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3299:1: ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )?
                    int alt55=2;
                    int LA55_0 = input.LA(1);

                    if ( ((LA55_0>=RULE_SIMPLE_ID && LA55_0<=RULE_ESCAPED_ID)||LA55_0==16||LA55_0==18||(LA55_0>=27 && LA55_0<=28)||LA55_0==31||(LA55_0>=35 && LA55_0<=40)) ) {
                        alt55=1;
                    }
                    switch (alt55) {
                        case 1 :
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3299:2: ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )*
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3299:2: ( (lv_ownedParts_2_0= ruleTuplePartCS ) )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3300:1: (lv_ownedParts_2_0= ruleTuplePartCS )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3300:1: (lv_ownedParts_2_0= ruleTuplePartCS )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3301:3: lv_ownedParts_2_0= ruleTuplePartCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getTupleTypeCSAccess().getOwnedPartsTuplePartCSParserRuleCall_1_1_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleTuplePartCS_in_ruleTupleTypeCS7650);
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

                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3317:2: (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )*
                            loop54:
                            do {
                                int alt54=2;
                                int LA54_0 = input.LA(1);

                                if ( (LA54_0==19) ) {
                                    alt54=1;
                                }


                                switch (alt54) {
                            	case 1 :
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3317:4: otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) )
                            	    {
                            	    otherlv_3=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleTupleTypeCS7663); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_3, grammarAccess.getTupleTypeCSAccess().getCommaKeyword_1_1_1_0());
                            	          
                            	    }
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3321:1: ( (lv_ownedParts_4_0= ruleTuplePartCS ) )
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3322:1: (lv_ownedParts_4_0= ruleTuplePartCS )
                            	    {
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3322:1: (lv_ownedParts_4_0= ruleTuplePartCS )
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3323:3: lv_ownedParts_4_0= ruleTuplePartCS
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getTupleTypeCSAccess().getOwnedPartsTuplePartCSParserRuleCall_1_1_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FollowSets000.FOLLOW_ruleTuplePartCS_in_ruleTupleTypeCS7684);
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
                            	    break loop54;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_5=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleTupleTypeCS7700); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3351:1: entryRuleTuplePartCS returns [EObject current=null] : iv_ruleTuplePartCS= ruleTuplePartCS EOF ;
    public final EObject entryRuleTuplePartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTuplePartCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3352:2: (iv_ruleTuplePartCS= ruleTuplePartCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3353:2: iv_ruleTuplePartCS= ruleTuplePartCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTuplePartCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTuplePartCS_in_entryRuleTuplePartCS7738);
            iv_ruleTuplePartCS=ruleTuplePartCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTuplePartCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTuplePartCS7748); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3360:1: ruleTuplePartCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) ) ;
    public final EObject ruleTuplePartCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3363:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3364:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3364:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3364:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3364:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3365:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3365:1: (lv_name_0_0= ruleUnrestrictedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3366:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTuplePartCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleTuplePartCS7794);
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

            otherlv_1=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleTuplePartCS7806); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getTuplePartCSAccess().getColonKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3386:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3387:1: (lv_ownedType_2_0= ruleTypeExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3387:1: (lv_ownedType_2_0= ruleTypeExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3388:3: lv_ownedType_2_0= ruleTypeExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTuplePartCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleTuplePartCS7827);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3412:1: entryRuleCollectionLiteralExpCS returns [EObject current=null] : iv_ruleCollectionLiteralExpCS= ruleCollectionLiteralExpCS EOF ;
    public final EObject entryRuleCollectionLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3413:2: (iv_ruleCollectionLiteralExpCS= ruleCollectionLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3414:2: iv_ruleCollectionLiteralExpCS= ruleCollectionLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCollectionLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteralExpCS_in_entryRuleCollectionLiteralExpCS7863);
            iv_ruleCollectionLiteralExpCS=ruleCollectionLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCollectionLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCollectionLiteralExpCS7873); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3421:1: ruleCollectionLiteralExpCS returns [EObject current=null] : ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}' ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3424:28: ( ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3425:1: ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3425:1: ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3425:2: ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}'
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3425:2: ( (lv_ownedType_0_0= ruleCollectionTypeCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3426:1: (lv_ownedType_0_0= ruleCollectionTypeCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3426:1: (lv_ownedType_0_0= ruleCollectionTypeCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3427:3: lv_ownedType_0_0= ruleCollectionTypeCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedTypeCollectionTypeCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleCollectionTypeCS_in_ruleCollectionLiteralExpCS7919);
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

            otherlv_1=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleCollectionLiteralExpCS7931); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getCollectionLiteralExpCSAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3447:1: ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( ((LA58_0>=RULE_SIMPLE_ID && LA58_0<=RULE_SINGLE_QUOTED_STRING)||LA58_0==16||LA58_0==18||(LA58_0>=27 && LA58_0<=29)||LA58_0==31||(LA58_0>=34 && LA58_0<=42)||(LA58_0>=57 && LA58_0<=70)||(LA58_0>=75 && LA58_0<=78)||LA58_0==81||(LA58_0>=85 && LA58_0<=86)) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3447:2: ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )*
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3447:2: ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3448:1: (lv_ownedParts_2_0= ruleCollectionLiteralPartCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3448:1: (lv_ownedParts_2_0= ruleCollectionLiteralPartCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3449:3: lv_ownedParts_2_0= ruleCollectionLiteralPartCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedPartsCollectionLiteralPartCSParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteralPartCS_in_ruleCollectionLiteralExpCS7953);
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

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3465:2: (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )*
                    loop57:
                    do {
                        int alt57=2;
                        int LA57_0 = input.LA(1);

                        if ( (LA57_0==19) ) {
                            alt57=1;
                        }


                        switch (alt57) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3465:4: otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) )
                    	    {
                    	    otherlv_3=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleCollectionLiteralExpCS7966); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getCollectionLiteralExpCSAccess().getCommaKeyword_2_1_0());
                    	          
                    	    }
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3469:1: ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3470:1: (lv_ownedParts_4_0= ruleCollectionLiteralPartCS )
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3470:1: (lv_ownedParts_4_0= ruleCollectionLiteralPartCS )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3471:3: lv_ownedParts_4_0= ruleCollectionLiteralPartCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedPartsCollectionLiteralPartCSParserRuleCall_2_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteralPartCS_in_ruleCollectionLiteralExpCS7987);
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
                    	    break loop57;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleCollectionLiteralExpCS8003); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3499:1: entryRuleCollectionLiteralPartCS returns [EObject current=null] : iv_ruleCollectionLiteralPartCS= ruleCollectionLiteralPartCS EOF ;
    public final EObject entryRuleCollectionLiteralPartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionLiteralPartCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3500:2: (iv_ruleCollectionLiteralPartCS= ruleCollectionLiteralPartCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3501:2: iv_ruleCollectionLiteralPartCS= ruleCollectionLiteralPartCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCollectionLiteralPartCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteralPartCS_in_entryRuleCollectionLiteralPartCS8039);
            iv_ruleCollectionLiteralPartCS=ruleCollectionLiteralPartCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCollectionLiteralPartCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCollectionLiteralPartCS8049); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3508:1: ruleCollectionLiteralPartCS returns [EObject current=null] : ( ( (lv_expressionCS_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_lastExpressionCS_2_0= ruleExpCS ) ) )? ) ;
    public final EObject ruleCollectionLiteralPartCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expressionCS_0_0 = null;

        EObject lv_lastExpressionCS_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3511:28: ( ( ( (lv_expressionCS_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_lastExpressionCS_2_0= ruleExpCS ) ) )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3512:1: ( ( (lv_expressionCS_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_lastExpressionCS_2_0= ruleExpCS ) ) )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3512:1: ( ( (lv_expressionCS_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_lastExpressionCS_2_0= ruleExpCS ) ) )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3512:2: ( (lv_expressionCS_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_lastExpressionCS_2_0= ruleExpCS ) ) )?
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3512:2: ( (lv_expressionCS_0_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3513:1: (lv_expressionCS_0_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3513:1: (lv_expressionCS_0_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3514:3: lv_expressionCS_0_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCollectionLiteralPartCSAccess().getExpressionCSExpCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleCollectionLiteralPartCS8095);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3530:2: (otherlv_1= '..' ( (lv_lastExpressionCS_2_0= ruleExpCS ) ) )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==71) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3530:4: otherlv_1= '..' ( (lv_lastExpressionCS_2_0= ruleExpCS ) )
                    {
                    otherlv_1=(Token)match(input,71,FollowSets000.FOLLOW_71_in_ruleCollectionLiteralPartCS8108); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getCollectionLiteralPartCSAccess().getFullStopFullStopKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3534:1: ( (lv_lastExpressionCS_2_0= ruleExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3535:1: (lv_lastExpressionCS_2_0= ruleExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3535:1: (lv_lastExpressionCS_2_0= ruleExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3536:3: lv_lastExpressionCS_2_0= ruleExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionLiteralPartCSAccess().getLastExpressionCSExpCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleCollectionLiteralPartCS8129);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3560:1: entryRuleConstructorPartCS returns [EObject current=null] : iv_ruleConstructorPartCS= ruleConstructorPartCS EOF ;
    public final EObject entryRuleConstructorPartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstructorPartCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3561:2: (iv_ruleConstructorPartCS= ruleConstructorPartCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3562:2: iv_ruleConstructorPartCS= ruleConstructorPartCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstructorPartCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleConstructorPartCS_in_entryRuleConstructorPartCS8167);
            iv_ruleConstructorPartCS=ruleConstructorPartCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConstructorPartCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleConstructorPartCS8177); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3569:1: ruleConstructorPartCS returns [EObject current=null] : ( ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( (lv_initExpression_2_0= ruleExpCS ) ) ) ;
    public final EObject ruleConstructorPartCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_initExpression_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3572:28: ( ( ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( (lv_initExpression_2_0= ruleExpCS ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3573:1: ( ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( (lv_initExpression_2_0= ruleExpCS ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3573:1: ( ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( (lv_initExpression_2_0= ruleExpCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3573:2: ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( (lv_initExpression_2_0= ruleExpCS ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3573:2: ( ( ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3574:1: ( ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3574:1: ( ruleUnrestrictedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3575:3: ruleUnrestrictedName
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
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleConstructorPartCS8229);
            ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,49,FollowSets000.FOLLOW_49_in_ruleConstructorPartCS8241); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getConstructorPartCSAccess().getEqualsSignKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3595:1: ( (lv_initExpression_2_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3596:1: (lv_initExpression_2_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3596:1: (lv_initExpression_2_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3597:3: lv_initExpression_2_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getConstructorPartCSAccess().getInitExpressionExpCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleConstructorPartCS8262);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3621:1: entryRulePrimitiveLiteralExpCS returns [EObject current=null] : iv_rulePrimitiveLiteralExpCS= rulePrimitiveLiteralExpCS EOF ;
    public final EObject entryRulePrimitiveLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3622:2: (iv_rulePrimitiveLiteralExpCS= rulePrimitiveLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3623:2: iv_rulePrimitiveLiteralExpCS= rulePrimitiveLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePrimitiveLiteralExpCS_in_entryRulePrimitiveLiteralExpCS8298);
            iv_rulePrimitiveLiteralExpCS=rulePrimitiveLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimitiveLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrimitiveLiteralExpCS8308); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3630:1: rulePrimitiveLiteralExpCS returns [EObject current=null] : (this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS | this_StringLiteralExpCS_1= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_5= ruleNullLiteralExpCS ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3633:28: ( (this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS | this_StringLiteralExpCS_1= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_5= ruleNullLiteralExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3634:1: (this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS | this_StringLiteralExpCS_1= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_5= ruleNullLiteralExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3634:1: (this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS | this_StringLiteralExpCS_1= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_5= ruleNullLiteralExpCS )
            int alt60=6;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt60=1;
                }
                break;
            case RULE_SINGLE_QUOTED_STRING:
                {
                alt60=2;
                }
                break;
            case 75:
            case 76:
                {
                alt60=3;
                }
                break;
            case 34:
                {
                alt60=4;
                }
                break;
            case 77:
                {
                alt60=5;
                }
                break;
            case 78:
                {
                alt60=6;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3635:2: this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getNumberLiteralExpCSParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNumberLiteralExpCS_in_rulePrimitiveLiteralExpCS8358);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3648:2: this_StringLiteralExpCS_1= ruleStringLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getStringLiteralExpCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleStringLiteralExpCS_in_rulePrimitiveLiteralExpCS8388);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3661:2: this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getBooleanLiteralExpCSParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleBooleanLiteralExpCS_in_rulePrimitiveLiteralExpCS8418);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3674:2: this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getUnlimitedNaturalLiteralExpCSParserRuleCall_3()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUnlimitedNaturalLiteralExpCS_in_rulePrimitiveLiteralExpCS8448);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3687:2: this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getInvalidLiteralExpCSParserRuleCall_4()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleInvalidLiteralExpCS_in_rulePrimitiveLiteralExpCS8478);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3700:2: this_NullLiteralExpCS_5= ruleNullLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getNullLiteralExpCSParserRuleCall_5()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNullLiteralExpCS_in_rulePrimitiveLiteralExpCS8508);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3719:1: entryRuleTupleLiteralExpCS returns [EObject current=null] : iv_ruleTupleLiteralExpCS= ruleTupleLiteralExpCS EOF ;
    public final EObject entryRuleTupleLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTupleLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3720:2: (iv_ruleTupleLiteralExpCS= ruleTupleLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3721:2: iv_ruleTupleLiteralExpCS= ruleTupleLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTupleLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralExpCS_in_entryRuleTupleLiteralExpCS8543);
            iv_ruleTupleLiteralExpCS=ruleTupleLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTupleLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTupleLiteralExpCS8553); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3728:1: ruleTupleLiteralExpCS returns [EObject current=null] : (otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}' ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3731:28: ( (otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3732:1: (otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3732:1: (otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3732:3: otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,57,FollowSets000.FOLLOW_57_in_ruleTupleLiteralExpCS8590); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getTupleLiteralExpCSAccess().getTupleKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleTupleLiteralExpCS8602); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getTupleLiteralExpCSAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3740:1: ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3741:1: (lv_ownedParts_2_0= ruleTupleLiteralPartCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3741:1: (lv_ownedParts_2_0= ruleTupleLiteralPartCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3742:3: lv_ownedParts_2_0= ruleTupleLiteralPartCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTupleLiteralExpCSAccess().getOwnedPartsTupleLiteralPartCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralPartCS_in_ruleTupleLiteralExpCS8623);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3758:2: (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )*
            loop61:
            do {
                int alt61=2;
                int LA61_0 = input.LA(1);

                if ( (LA61_0==19) ) {
                    alt61=1;
                }


                switch (alt61) {
            	case 1 :
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3758:4: otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) )
            	    {
            	    otherlv_3=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleTupleLiteralExpCS8636); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getTupleLiteralExpCSAccess().getCommaKeyword_3_0());
            	          
            	    }
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3762:1: ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3763:1: (lv_ownedParts_4_0= ruleTupleLiteralPartCS )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3763:1: (lv_ownedParts_4_0= ruleTupleLiteralPartCS )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3764:3: lv_ownedParts_4_0= ruleTupleLiteralPartCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTupleLiteralExpCSAccess().getOwnedPartsTupleLiteralPartCSParserRuleCall_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralPartCS_in_ruleTupleLiteralExpCS8657);
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
            	    break loop61;
                }
            } while (true);

            otherlv_5=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleTupleLiteralExpCS8671); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3792:1: entryRuleTupleLiteralPartCS returns [EObject current=null] : iv_ruleTupleLiteralPartCS= ruleTupleLiteralPartCS EOF ;
    public final EObject entryRuleTupleLiteralPartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTupleLiteralPartCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3793:2: (iv_ruleTupleLiteralPartCS= ruleTupleLiteralPartCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3794:2: iv_ruleTupleLiteralPartCS= ruleTupleLiteralPartCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTupleLiteralPartCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralPartCS_in_entryRuleTupleLiteralPartCS8707);
            iv_ruleTupleLiteralPartCS=ruleTupleLiteralPartCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTupleLiteralPartCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTupleLiteralPartCS8717); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3801:1: ruleTupleLiteralPartCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) ) ) ;
    public final EObject ruleTupleLiteralPartCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;

        EObject lv_initExpression_4_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3804:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3805:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3805:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3805:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3805:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3806:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3806:1: (lv_name_0_0= ruleUnrestrictedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3807:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTupleLiteralPartCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleTupleLiteralPartCS8763);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3823:2: (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==32) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3823:4: otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                    {
                    otherlv_1=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleTupleLiteralPartCS8776); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getTupleLiteralPartCSAccess().getColonKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3827:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3828:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3828:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3829:3: lv_ownedType_2_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTupleLiteralPartCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleTupleLiteralPartCS8797);
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

            otherlv_3=(Token)match(input,49,FollowSets000.FOLLOW_49_in_ruleTupleLiteralPartCS8811); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getTupleLiteralPartCSAccess().getEqualsSignKeyword_2());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3849:1: ( (lv_initExpression_4_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3850:1: (lv_initExpression_4_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3850:1: (lv_initExpression_4_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3851:3: lv_initExpression_4_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTupleLiteralPartCSAccess().getInitExpressionExpCSParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleTupleLiteralPartCS8832);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3875:1: entryRuleNumberLiteralExpCS returns [EObject current=null] : iv_ruleNumberLiteralExpCS= ruleNumberLiteralExpCS EOF ;
    public final EObject entryRuleNumberLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3876:2: (iv_ruleNumberLiteralExpCS= ruleNumberLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3877:2: iv_ruleNumberLiteralExpCS= ruleNumberLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumberLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNumberLiteralExpCS_in_entryRuleNumberLiteralExpCS8868);
            iv_ruleNumberLiteralExpCS=ruleNumberLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumberLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNumberLiteralExpCS8878); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3884:1: ruleNumberLiteralExpCS returns [EObject current=null] : ( (lv_name_0_0= ruleNUMBER_LITERAL ) ) ;
    public final EObject ruleNumberLiteralExpCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3887:28: ( ( (lv_name_0_0= ruleNUMBER_LITERAL ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3888:1: ( (lv_name_0_0= ruleNUMBER_LITERAL ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3888:1: ( (lv_name_0_0= ruleNUMBER_LITERAL ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3889:1: (lv_name_0_0= ruleNUMBER_LITERAL )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3889:1: (lv_name_0_0= ruleNUMBER_LITERAL )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3890:3: lv_name_0_0= ruleNUMBER_LITERAL
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNumberLiteralExpCSAccess().getNameNUMBER_LITERALParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleNUMBER_LITERAL_in_ruleNumberLiteralExpCS8923);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3914:1: entryRuleStringLiteralExpCS returns [EObject current=null] : iv_ruleStringLiteralExpCS= ruleStringLiteralExpCS EOF ;
    public final EObject entryRuleStringLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3915:2: (iv_ruleStringLiteralExpCS= ruleStringLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3916:2: iv_ruleStringLiteralExpCS= ruleStringLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStringLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleStringLiteralExpCS_in_entryRuleStringLiteralExpCS8958);
            iv_ruleStringLiteralExpCS=ruleStringLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStringLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleStringLiteralExpCS8968); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3923:1: ruleStringLiteralExpCS returns [EObject current=null] : ( (lv_name_0_0= ruleStringLiteral ) )+ ;
    public final EObject ruleStringLiteralExpCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3926:28: ( ( (lv_name_0_0= ruleStringLiteral ) )+ )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3927:1: ( (lv_name_0_0= ruleStringLiteral ) )+
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3927:1: ( (lv_name_0_0= ruleStringLiteral ) )+
            int cnt63=0;
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( (LA63_0==RULE_SINGLE_QUOTED_STRING) ) {
                    alt63=1;
                }


                switch (alt63) {
            	case 1 :
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3928:1: (lv_name_0_0= ruleStringLiteral )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3928:1: (lv_name_0_0= ruleStringLiteral )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3929:3: lv_name_0_0= ruleStringLiteral
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getStringLiteralExpCSAccess().getNameStringLiteralParserRuleCall_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleStringLiteral_in_ruleStringLiteralExpCS9013);
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
            	    if ( cnt63 >= 1 ) break loop63;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(63, input);
                        throw eee;
                }
                cnt63++;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3953:1: entryRuleBooleanLiteralExpCS returns [EObject current=null] : iv_ruleBooleanLiteralExpCS= ruleBooleanLiteralExpCS EOF ;
    public final EObject entryRuleBooleanLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3954:2: (iv_ruleBooleanLiteralExpCS= ruleBooleanLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3955:2: iv_ruleBooleanLiteralExpCS= ruleBooleanLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBooleanLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleBooleanLiteralExpCS_in_entryRuleBooleanLiteralExpCS9049);
            iv_ruleBooleanLiteralExpCS=ruleBooleanLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBooleanLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBooleanLiteralExpCS9059); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3962:1: ruleBooleanLiteralExpCS returns [EObject current=null] : ( ( (lv_name_0_0= 'true' ) ) | ( (lv_name_1_0= 'false' ) ) ) ;
    public final EObject ruleBooleanLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3965:28: ( ( ( (lv_name_0_0= 'true' ) ) | ( (lv_name_1_0= 'false' ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3966:1: ( ( (lv_name_0_0= 'true' ) ) | ( (lv_name_1_0= 'false' ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3966:1: ( ( (lv_name_0_0= 'true' ) ) | ( (lv_name_1_0= 'false' ) ) )
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==75) ) {
                alt64=1;
            }
            else if ( (LA64_0==76) ) {
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3966:2: ( (lv_name_0_0= 'true' ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3966:2: ( (lv_name_0_0= 'true' ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3967:1: (lv_name_0_0= 'true' )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3967:1: (lv_name_0_0= 'true' )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3968:3: lv_name_0_0= 'true'
                    {
                    lv_name_0_0=(Token)match(input,75,FollowSets000.FOLLOW_75_in_ruleBooleanLiteralExpCS9102); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3982:6: ( (lv_name_1_0= 'false' ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3982:6: ( (lv_name_1_0= 'false' ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3983:1: (lv_name_1_0= 'false' )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3983:1: (lv_name_1_0= 'false' )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3984:3: lv_name_1_0= 'false'
                    {
                    lv_name_1_0=(Token)match(input,76,FollowSets000.FOLLOW_76_in_ruleBooleanLiteralExpCS9139); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4005:1: entryRuleUnlimitedNaturalLiteralExpCS returns [EObject current=null] : iv_ruleUnlimitedNaturalLiteralExpCS= ruleUnlimitedNaturalLiteralExpCS EOF ;
    public final EObject entryRuleUnlimitedNaturalLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnlimitedNaturalLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4006:2: (iv_ruleUnlimitedNaturalLiteralExpCS= ruleUnlimitedNaturalLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4007:2: iv_ruleUnlimitedNaturalLiteralExpCS= ruleUnlimitedNaturalLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnlimitedNaturalLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnlimitedNaturalLiteralExpCS_in_entryRuleUnlimitedNaturalLiteralExpCS9188);
            iv_ruleUnlimitedNaturalLiteralExpCS=ruleUnlimitedNaturalLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnlimitedNaturalLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnlimitedNaturalLiteralExpCS9198); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4014:1: ruleUnlimitedNaturalLiteralExpCS returns [EObject current=null] : ( () otherlv_1= '*' ) ;
    public final EObject ruleUnlimitedNaturalLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4017:28: ( ( () otherlv_1= '*' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4018:1: ( () otherlv_1= '*' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4018:1: ( () otherlv_1= '*' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4018:2: () otherlv_1= '*'
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4018:2: ()
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4019:2: 
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

            otherlv_1=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleUnlimitedNaturalLiteralExpCS9247); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4039:1: entryRuleInvalidLiteralExpCS returns [EObject current=null] : iv_ruleInvalidLiteralExpCS= ruleInvalidLiteralExpCS EOF ;
    public final EObject entryRuleInvalidLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInvalidLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4040:2: (iv_ruleInvalidLiteralExpCS= ruleInvalidLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4041:2: iv_ruleInvalidLiteralExpCS= ruleInvalidLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInvalidLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleInvalidLiteralExpCS_in_entryRuleInvalidLiteralExpCS9283);
            iv_ruleInvalidLiteralExpCS=ruleInvalidLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInvalidLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleInvalidLiteralExpCS9293); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4048:1: ruleInvalidLiteralExpCS returns [EObject current=null] : ( () otherlv_1= 'invalid' ) ;
    public final EObject ruleInvalidLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4051:28: ( ( () otherlv_1= 'invalid' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4052:1: ( () otherlv_1= 'invalid' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4052:1: ( () otherlv_1= 'invalid' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4052:2: () otherlv_1= 'invalid'
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4052:2: ()
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4053:2: 
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

            otherlv_1=(Token)match(input,77,FollowSets000.FOLLOW_77_in_ruleInvalidLiteralExpCS9342); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4073:1: entryRuleNullLiteralExpCS returns [EObject current=null] : iv_ruleNullLiteralExpCS= ruleNullLiteralExpCS EOF ;
    public final EObject entryRuleNullLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4074:2: (iv_ruleNullLiteralExpCS= ruleNullLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4075:2: iv_ruleNullLiteralExpCS= ruleNullLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNullLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNullLiteralExpCS_in_entryRuleNullLiteralExpCS9378);
            iv_ruleNullLiteralExpCS=ruleNullLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNullLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNullLiteralExpCS9388); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4082:1: ruleNullLiteralExpCS returns [EObject current=null] : ( () otherlv_1= 'null' ) ;
    public final EObject ruleNullLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4085:28: ( ( () otherlv_1= 'null' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4086:1: ( () otherlv_1= 'null' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4086:1: ( () otherlv_1= 'null' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4086:2: () otherlv_1= 'null'
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4086:2: ()
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4087:2: 
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

            otherlv_1=(Token)match(input,78,FollowSets000.FOLLOW_78_in_ruleNullLiteralExpCS9437); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4107:1: entryRuleTypeLiteralCS returns [EObject current=null] : iv_ruleTypeLiteralCS= ruleTypeLiteralCS EOF ;
    public final EObject entryRuleTypeLiteralCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeLiteralCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4108:2: (iv_ruleTypeLiteralCS= ruleTypeLiteralCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4109:2: iv_ruleTypeLiteralCS= ruleTypeLiteralCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeLiteralCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralCS_in_entryRuleTypeLiteralCS9473);
            iv_ruleTypeLiteralCS=ruleTypeLiteralCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeLiteralCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeLiteralCS9483); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4116:1: ruleTypeLiteralCS returns [EObject current=null] : (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS | this_CollectionTypeCS_1= ruleCollectionTypeCS | this_TupleTypeCS_2= ruleTupleTypeCS ) ;
    public final EObject ruleTypeLiteralCS() throws RecognitionException {
        EObject current = null;

        EObject this_PrimitiveTypeCS_0 = null;

        EObject this_CollectionTypeCS_1 = null;

        EObject this_TupleTypeCS_2 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4119:28: ( (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS | this_CollectionTypeCS_1= ruleCollectionTypeCS | this_TupleTypeCS_2= ruleTupleTypeCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4120:1: (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS | this_CollectionTypeCS_1= ruleCollectionTypeCS | this_TupleTypeCS_2= ruleTupleTypeCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4120:1: (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS | this_CollectionTypeCS_1= ruleCollectionTypeCS | this_TupleTypeCS_2= ruleTupleTypeCS )
            int alt65=3;
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
                alt65=1;
                }
                break;
            case 66:
            case 67:
            case 68:
            case 69:
            case 70:
                {
                alt65=2;
                }
                break;
            case 57:
                {
                alt65=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 65, 0, input);

                throw nvae;
            }

            switch (alt65) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4121:2: this_PrimitiveTypeCS_0= rulePrimitiveTypeCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeLiteralCSAccess().getPrimitiveTypeCSParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrimitiveTypeCS_in_ruleTypeLiteralCS9533);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4134:2: this_CollectionTypeCS_1= ruleCollectionTypeCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeLiteralCSAccess().getCollectionTypeCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCollectionTypeCS_in_ruleTypeLiteralCS9563);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4147:2: this_TupleTypeCS_2= ruleTupleTypeCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeLiteralCSAccess().getTupleTypeCSParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTupleTypeCS_in_ruleTypeLiteralCS9593);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4166:1: entryRuleTypeLiteralWithMultiplicityCS returns [EObject current=null] : iv_ruleTypeLiteralWithMultiplicityCS= ruleTypeLiteralWithMultiplicityCS EOF ;
    public final EObject entryRuleTypeLiteralWithMultiplicityCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeLiteralWithMultiplicityCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4167:2: (iv_ruleTypeLiteralWithMultiplicityCS= ruleTypeLiteralWithMultiplicityCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4168:2: iv_ruleTypeLiteralWithMultiplicityCS= ruleTypeLiteralWithMultiplicityCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeLiteralWithMultiplicityCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralWithMultiplicityCS_in_entryRuleTypeLiteralWithMultiplicityCS9628);
            iv_ruleTypeLiteralWithMultiplicityCS=ruleTypeLiteralWithMultiplicityCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeLiteralWithMultiplicityCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeLiteralWithMultiplicityCS9638); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4175:1: ruleTypeLiteralWithMultiplicityCS returns [EObject current=null] : (this_TypeLiteralCS_0= ruleTypeLiteralCS ( (lv_multiplicity_1_0= ruleMultiplicityCS ) )? ) ;
    public final EObject ruleTypeLiteralWithMultiplicityCS() throws RecognitionException {
        EObject current = null;

        EObject this_TypeLiteralCS_0 = null;

        EObject lv_multiplicity_1_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4178:28: ( (this_TypeLiteralCS_0= ruleTypeLiteralCS ( (lv_multiplicity_1_0= ruleMultiplicityCS ) )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4179:1: (this_TypeLiteralCS_0= ruleTypeLiteralCS ( (lv_multiplicity_1_0= ruleMultiplicityCS ) )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4179:1: (this_TypeLiteralCS_0= ruleTypeLiteralCS ( (lv_multiplicity_1_0= ruleMultiplicityCS ) )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4180:2: this_TypeLiteralCS_0= ruleTypeLiteralCS ( (lv_multiplicity_1_0= ruleMultiplicityCS ) )?
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getTypeLiteralWithMultiplicityCSAccess().getTypeLiteralCSParserRuleCall_0()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralCS_in_ruleTypeLiteralWithMultiplicityCS9688);
            this_TypeLiteralCS_0=ruleTypeLiteralCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_TypeLiteralCS_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4191:1: ( (lv_multiplicity_1_0= ruleMultiplicityCS ) )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==72) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4192:1: (lv_multiplicity_1_0= ruleMultiplicityCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4192:1: (lv_multiplicity_1_0= ruleMultiplicityCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4193:3: lv_multiplicity_1_0= ruleMultiplicityCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeLiteralWithMultiplicityCSAccess().getMultiplicityMultiplicityCSParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMultiplicityCS_in_ruleTypeLiteralWithMultiplicityCS9708);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4217:1: entryRuleTypeLiteralExpCS returns [EObject current=null] : iv_ruleTypeLiteralExpCS= ruleTypeLiteralExpCS EOF ;
    public final EObject entryRuleTypeLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4218:2: (iv_ruleTypeLiteralExpCS= ruleTypeLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4219:2: iv_ruleTypeLiteralExpCS= ruleTypeLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralExpCS_in_entryRuleTypeLiteralExpCS9745);
            iv_ruleTypeLiteralExpCS=ruleTypeLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeLiteralExpCS9755); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4226:1: ruleTypeLiteralExpCS returns [EObject current=null] : ( (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS ) ) ;
    public final EObject ruleTypeLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject lv_ownedType_0_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4229:28: ( ( (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4230:1: ( (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4230:1: ( (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4231:1: (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4231:1: (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4232:3: lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypeLiteralExpCSAccess().getOwnedTypeTypeLiteralWithMultiplicityCSParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralWithMultiplicityCS_in_ruleTypeLiteralExpCS9800);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4256:1: entryRuleTypeNameExpCS returns [EObject current=null] : iv_ruleTypeNameExpCS= ruleTypeNameExpCS EOF ;
    public final EObject entryRuleTypeNameExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeNameExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4257:2: (iv_ruleTypeNameExpCS= ruleTypeNameExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4258:2: iv_ruleTypeNameExpCS= ruleTypeNameExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeNameExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeNameExpCS_in_entryRuleTypeNameExpCS9835);
            iv_ruleTypeNameExpCS=ruleTypeNameExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeNameExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeNameExpCS9845); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4265:1: ruleTypeNameExpCS returns [EObject current=null] : ( (lv_pathName_0_0= rulePathNameCS ) ) ;
    public final EObject ruleTypeNameExpCS() throws RecognitionException {
        EObject current = null;

        EObject lv_pathName_0_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4268:28: ( ( (lv_pathName_0_0= rulePathNameCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4269:1: ( (lv_pathName_0_0= rulePathNameCS ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4269:1: ( (lv_pathName_0_0= rulePathNameCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4270:1: (lv_pathName_0_0= rulePathNameCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4270:1: (lv_pathName_0_0= rulePathNameCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4271:3: lv_pathName_0_0= rulePathNameCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypeNameExpCSAccess().getPathNamePathNameCSParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_rulePathNameCS_in_ruleTypeNameExpCS9890);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4295:1: entryRuleTypeExpCS returns [EObject current=null] : iv_ruleTypeExpCS= ruleTypeExpCS EOF ;
    public final EObject entryRuleTypeExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4296:2: (iv_ruleTypeExpCS= ruleTypeExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4297:2: iv_ruleTypeExpCS= ruleTypeExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_entryRuleTypeExpCS9925);
            iv_ruleTypeExpCS=ruleTypeExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeExpCS9935); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4304:1: ruleTypeExpCS returns [EObject current=null] : ( (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS ) ( (lv_multiplicity_2_0= ruleMultiplicityCS ) )? ) ;
    public final EObject ruleTypeExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_TypeNameExpCS_0 = null;

        EObject this_TypeLiteralCS_1 = null;

        EObject lv_multiplicity_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4307:28: ( ( (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS ) ( (lv_multiplicity_2_0= ruleMultiplicityCS ) )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4308:1: ( (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS ) ( (lv_multiplicity_2_0= ruleMultiplicityCS ) )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4308:1: ( (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS ) ( (lv_multiplicity_2_0= ruleMultiplicityCS ) )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4308:2: (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS ) ( (lv_multiplicity_2_0= ruleMultiplicityCS ) )?
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4308:2: (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS )
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( ((LA67_0>=RULE_SIMPLE_ID && LA67_0<=RULE_ESCAPED_ID)||LA67_0==16||LA67_0==18||(LA67_0>=27 && LA67_0<=28)||LA67_0==31||(LA67_0>=35 && LA67_0<=40)) ) {
                alt67=1;
            }
            else if ( ((LA67_0>=57 && LA67_0<=70)) ) {
                alt67=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 67, 0, input);

                throw nvae;
            }
            switch (alt67) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4309:2: this_TypeNameExpCS_0= ruleTypeNameExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeExpCSAccess().getTypeNameExpCSParserRuleCall_0_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeNameExpCS_in_ruleTypeExpCS9986);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4322:2: this_TypeLiteralCS_1= ruleTypeLiteralCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeExpCSAccess().getTypeLiteralCSParserRuleCall_0_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralCS_in_ruleTypeExpCS10016);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4333:2: ( (lv_multiplicity_2_0= ruleMultiplicityCS ) )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==72) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4334:1: (lv_multiplicity_2_0= ruleMultiplicityCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4334:1: (lv_multiplicity_2_0= ruleMultiplicityCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4335:3: lv_multiplicity_2_0= ruleMultiplicityCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeExpCSAccess().getMultiplicityMultiplicityCSParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMultiplicityCS_in_ruleTypeExpCS10037);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4359:1: entryRuleExpCS returns [EObject current=null] : iv_ruleExpCS= ruleExpCS EOF ;
    public final EObject entryRuleExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4360:2: (iv_ruleExpCS= ruleExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4361:2: iv_ruleExpCS= ruleExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_entryRuleExpCS10074);
            iv_ruleExpCS=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleExpCS10084); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4368:1: ruleExpCS returns [EObject current=null] : ( (this_PrefixedExpCS_0= rulePrefixedExpCS ( () ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? ) | ( (lv_ownedExpression_8_0= ruleLetExpCS ) ) ) )? ) | ( () ( (lv_ownedOperator_10_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_11_0= ruleLetExpCS ) ) ) | this_LetExpCS_12= ruleLetExpCS ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4371:28: ( ( (this_PrefixedExpCS_0= rulePrefixedExpCS ( () ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? ) | ( (lv_ownedExpression_8_0= ruleLetExpCS ) ) ) )? ) | ( () ( (lv_ownedOperator_10_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_11_0= ruleLetExpCS ) ) ) | this_LetExpCS_12= ruleLetExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4372:1: ( (this_PrefixedExpCS_0= rulePrefixedExpCS ( () ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? ) | ( (lv_ownedExpression_8_0= ruleLetExpCS ) ) ) )? ) | ( () ( (lv_ownedOperator_10_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_11_0= ruleLetExpCS ) ) ) | this_LetExpCS_12= ruleLetExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4372:1: ( (this_PrefixedExpCS_0= rulePrefixedExpCS ( () ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? ) | ( (lv_ownedExpression_8_0= ruleLetExpCS ) ) ) )? ) | ( () ( (lv_ownedOperator_10_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_11_0= ruleLetExpCS ) ) ) | this_LetExpCS_12= ruleLetExpCS )
            int alt74=3;
            alt74 = dfa74.predict(input);
            switch (alt74) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4372:2: (this_PrefixedExpCS_0= rulePrefixedExpCS ( () ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? ) | ( (lv_ownedExpression_8_0= ruleLetExpCS ) ) ) )? )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4372:2: (this_PrefixedExpCS_0= rulePrefixedExpCS ( () ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? ) | ( (lv_ownedExpression_8_0= ruleLetExpCS ) ) ) )? )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4373:2: this_PrefixedExpCS_0= rulePrefixedExpCS ( () ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? ) | ( (lv_ownedExpression_8_0= ruleLetExpCS ) ) ) )?
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getExpCSAccess().getPrefixedExpCSParserRuleCall_0_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrefixedExpCS_in_ruleExpCS10135);
                    this_PrefixedExpCS_0=rulePrefixedExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_PrefixedExpCS_0; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4384:1: ( () ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? ) | ( (lv_ownedExpression_8_0= ruleLetExpCS ) ) ) )?
                    int alt72=2;
                    int LA72_0 = input.LA(1);

                    if ( (LA72_0==34||LA72_0==41||(LA72_0>=43 && LA72_0<=56)) ) {
                        alt72=1;
                    }
                    switch (alt72) {
                        case 1 :
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4384:2: () ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? ) | ( (lv_ownedExpression_8_0= ruleLetExpCS ) ) )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4384:2: ()
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4385:2: 
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

                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4393:2: ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4394:1: (lv_ownedOperator_2_0= ruleBinaryOperatorCS )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4394:1: (lv_ownedOperator_2_0= ruleBinaryOperatorCS )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4395:3: lv_ownedOperator_2_0= ruleBinaryOperatorCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getExpCSAccess().getOwnedOperatorBinaryOperatorCSParserRuleCall_0_1_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleBinaryOperatorCS_in_ruleExpCS10168);
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

                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4411:2: ( ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? ) | ( (lv_ownedExpression_8_0= ruleLetExpCS ) ) )
                            int alt71=2;
                            int LA71_0 = input.LA(1);

                            if ( ((LA71_0>=RULE_SIMPLE_ID && LA71_0<=RULE_SINGLE_QUOTED_STRING)||LA71_0==16||LA71_0==18||(LA71_0>=27 && LA71_0<=29)||LA71_0==31||(LA71_0>=34 && LA71_0<=42)||(LA71_0>=57 && LA71_0<=70)||(LA71_0>=75 && LA71_0<=78)||LA71_0==81||LA71_0==86) ) {
                                alt71=1;
                            }
                            else if ( (LA71_0==85) ) {
                                alt71=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 71, 0, input);

                                throw nvae;
                            }
                            switch (alt71) {
                                case 1 :
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4411:3: ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? )
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4411:3: ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4411:4: ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )?
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4411:4: ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4412:1: (lv_ownedExpression_3_0= rulePrefixedExpCS )
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4412:1: (lv_ownedExpression_3_0= rulePrefixedExpCS )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4413:3: lv_ownedExpression_3_0= rulePrefixedExpCS
                                    {
                                    if ( state.backtracking==0 ) {
                                       
                                      	        newCompositeNode(grammarAccess.getExpCSAccess().getOwnedExpressionPrefixedExpCSParserRuleCall_0_1_2_0_0_0()); 
                                      	    
                                    }
                                    pushFollow(FollowSets000.FOLLOW_rulePrefixedExpCS_in_ruleExpCS10191);
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

                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4429:2: ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )*
                                    loop69:
                                    do {
                                        int alt69=2;
                                        alt69 = dfa69.predict(input);
                                        switch (alt69) {
                                    	case 1 :
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4429:3: ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) )
                                    	    {
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4429:3: ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) )
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4430:1: (lv_ownedOperator_4_0= ruleBinaryOperatorCS )
                                    	    {
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4430:1: (lv_ownedOperator_4_0= ruleBinaryOperatorCS )
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4431:3: lv_ownedOperator_4_0= ruleBinaryOperatorCS
                                    	    {
                                    	    if ( state.backtracking==0 ) {
                                    	       
                                    	      	        newCompositeNode(grammarAccess.getExpCSAccess().getOwnedOperatorBinaryOperatorCSParserRuleCall_0_1_2_0_1_0_0()); 
                                    	      	    
                                    	    }
                                    	    pushFollow(FollowSets000.FOLLOW_ruleBinaryOperatorCS_in_ruleExpCS10213);
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

                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4447:2: ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) )
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4448:1: (lv_ownedExpression_5_0= rulePrefixedExpCS )
                                    	    {
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4448:1: (lv_ownedExpression_5_0= rulePrefixedExpCS )
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4449:3: lv_ownedExpression_5_0= rulePrefixedExpCS
                                    	    {
                                    	    if ( state.backtracking==0 ) {
                                    	       
                                    	      	        newCompositeNode(grammarAccess.getExpCSAccess().getOwnedExpressionPrefixedExpCSParserRuleCall_0_1_2_0_1_1_0()); 
                                    	      	    
                                    	    }
                                    	    pushFollow(FollowSets000.FOLLOW_rulePrefixedExpCS_in_ruleExpCS10234);
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
                                    	    break loop69;
                                        }
                                    } while (true);

                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4465:4: ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )?
                                    int alt70=2;
                                    int LA70_0 = input.LA(1);

                                    if ( (LA70_0==34||LA70_0==41||(LA70_0>=43 && LA70_0<=56)) ) {
                                        alt70=1;
                                    }
                                    switch (alt70) {
                                        case 1 :
                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4465:5: ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) )
                                            {
                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4465:5: ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) )
                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4466:1: (lv_ownedOperator_6_0= ruleBinaryOperatorCS )
                                            {
                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4466:1: (lv_ownedOperator_6_0= ruleBinaryOperatorCS )
                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4467:3: lv_ownedOperator_6_0= ruleBinaryOperatorCS
                                            {
                                            if ( state.backtracking==0 ) {
                                               
                                              	        newCompositeNode(grammarAccess.getExpCSAccess().getOwnedOperatorBinaryOperatorCSParserRuleCall_0_1_2_0_2_0_0()); 
                                              	    
                                            }
                                            pushFollow(FollowSets000.FOLLOW_ruleBinaryOperatorCS_in_ruleExpCS10258);
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

                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4483:2: ( (lv_ownedExpression_7_0= ruleLetExpCS ) )
                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4484:1: (lv_ownedExpression_7_0= ruleLetExpCS )
                                            {
                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4484:1: (lv_ownedExpression_7_0= ruleLetExpCS )
                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4485:3: lv_ownedExpression_7_0= ruleLetExpCS
                                            {
                                            if ( state.backtracking==0 ) {
                                               
                                              	        newCompositeNode(grammarAccess.getExpCSAccess().getOwnedExpressionLetExpCSParserRuleCall_0_1_2_0_2_1_0()); 
                                              	    
                                            }
                                            pushFollow(FollowSets000.FOLLOW_ruleLetExpCS_in_ruleExpCS10279);
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
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4502:6: ( (lv_ownedExpression_8_0= ruleLetExpCS ) )
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4502:6: ( (lv_ownedExpression_8_0= ruleLetExpCS ) )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4503:1: (lv_ownedExpression_8_0= ruleLetExpCS )
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4503:1: (lv_ownedExpression_8_0= ruleLetExpCS )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4504:3: lv_ownedExpression_8_0= ruleLetExpCS
                                    {
                                    if ( state.backtracking==0 ) {
                                       
                                      	        newCompositeNode(grammarAccess.getExpCSAccess().getOwnedExpressionLetExpCSParserRuleCall_0_1_2_1_0()); 
                                      	    
                                    }
                                    pushFollow(FollowSets000.FOLLOW_ruleLetExpCS_in_ruleExpCS10309);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4521:6: ( () ( (lv_ownedOperator_10_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_11_0= ruleLetExpCS ) ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4521:6: ( () ( (lv_ownedOperator_10_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_11_0= ruleLetExpCS ) ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4521:7: () ( (lv_ownedOperator_10_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_11_0= ruleLetExpCS ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4521:7: ()
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4522:2: 
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

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4530:2: ( (lv_ownedOperator_10_0= ruleUnaryOperatorCS ) )+
                    int cnt73=0;
                    loop73:
                    do {
                        int alt73=2;
                        int LA73_0 = input.LA(1);

                        if ( ((LA73_0>=41 && LA73_0<=42)) ) {
                            alt73=1;
                        }


                        switch (alt73) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4531:1: (lv_ownedOperator_10_0= ruleUnaryOperatorCS )
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4531:1: (lv_ownedOperator_10_0= ruleUnaryOperatorCS )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4532:3: lv_ownedOperator_10_0= ruleUnaryOperatorCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getExpCSAccess().getOwnedOperatorUnaryOperatorCSParserRuleCall_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleUnaryOperatorCS_in_ruleExpCS10353);
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
                    	    if ( cnt73 >= 1 ) break loop73;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(73, input);
                                throw eee;
                        }
                        cnt73++;
                    } while (true);

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4548:3: ( (lv_ownedExpression_11_0= ruleLetExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4549:1: (lv_ownedExpression_11_0= ruleLetExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4549:1: (lv_ownedExpression_11_0= ruleLetExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4550:3: lv_ownedExpression_11_0= ruleLetExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpCSAccess().getOwnedExpressionLetExpCSParserRuleCall_1_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLetExpCS_in_ruleExpCS10375);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4568:2: this_LetExpCS_12= ruleLetExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getExpCSAccess().getLetExpCSParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLetExpCS_in_ruleExpCS10407);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4587:1: entryRulePrefixedExpCS returns [EObject current=null] : iv_rulePrefixedExpCS= rulePrefixedExpCS EOF ;
    public final EObject entryRulePrefixedExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrefixedExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4588:2: (iv_rulePrefixedExpCS= rulePrefixedExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4589:2: iv_rulePrefixedExpCS= rulePrefixedExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrefixedExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePrefixedExpCS_in_entryRulePrefixedExpCS10442);
            iv_rulePrefixedExpCS=rulePrefixedExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrefixedExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrefixedExpCS10452); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4596:1: rulePrefixedExpCS returns [EObject current=null] : ( ( () ( (lv_ownedOperator_1_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_2_0= rulePrimaryExpCS ) ) ) | this_PrimaryExpCS_3= rulePrimaryExpCS ) ;
    public final EObject rulePrefixedExpCS() throws RecognitionException {
        EObject current = null;

        EObject lv_ownedOperator_1_0 = null;

        EObject lv_ownedExpression_2_0 = null;

        EObject this_PrimaryExpCS_3 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4599:28: ( ( ( () ( (lv_ownedOperator_1_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_2_0= rulePrimaryExpCS ) ) ) | this_PrimaryExpCS_3= rulePrimaryExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4600:1: ( ( () ( (lv_ownedOperator_1_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_2_0= rulePrimaryExpCS ) ) ) | this_PrimaryExpCS_3= rulePrimaryExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4600:1: ( ( () ( (lv_ownedOperator_1_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_2_0= rulePrimaryExpCS ) ) ) | this_PrimaryExpCS_3= rulePrimaryExpCS )
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( ((LA76_0>=41 && LA76_0<=42)) ) {
                alt76=1;
            }
            else if ( ((LA76_0>=RULE_SIMPLE_ID && LA76_0<=RULE_SINGLE_QUOTED_STRING)||LA76_0==16||LA76_0==18||(LA76_0>=27 && LA76_0<=29)||LA76_0==31||(LA76_0>=34 && LA76_0<=40)||(LA76_0>=57 && LA76_0<=70)||(LA76_0>=75 && LA76_0<=78)||LA76_0==81||LA76_0==86) ) {
                alt76=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 76, 0, input);

                throw nvae;
            }
            switch (alt76) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4600:2: ( () ( (lv_ownedOperator_1_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_2_0= rulePrimaryExpCS ) ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4600:2: ( () ( (lv_ownedOperator_1_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_2_0= rulePrimaryExpCS ) ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4600:3: () ( (lv_ownedOperator_1_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_2_0= rulePrimaryExpCS ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4600:3: ()
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4601:2: 
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

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4609:2: ( (lv_ownedOperator_1_0= ruleUnaryOperatorCS ) )+
                    int cnt75=0;
                    loop75:
                    do {
                        int alt75=2;
                        int LA75_0 = input.LA(1);

                        if ( ((LA75_0>=41 && LA75_0<=42)) ) {
                            alt75=1;
                        }


                        switch (alt75) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4610:1: (lv_ownedOperator_1_0= ruleUnaryOperatorCS )
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4610:1: (lv_ownedOperator_1_0= ruleUnaryOperatorCS )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4611:3: lv_ownedOperator_1_0= ruleUnaryOperatorCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getPrefixedExpCSAccess().getOwnedOperatorUnaryOperatorCSParserRuleCall_0_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleUnaryOperatorCS_in_rulePrefixedExpCS10511);
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
                    	    if ( cnt75 >= 1 ) break loop75;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(75, input);
                                throw eee;
                        }
                        cnt75++;
                    } while (true);

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4627:3: ( (lv_ownedExpression_2_0= rulePrimaryExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4628:1: (lv_ownedExpression_2_0= rulePrimaryExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4628:1: (lv_ownedExpression_2_0= rulePrimaryExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4629:3: lv_ownedExpression_2_0= rulePrimaryExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrefixedExpCSAccess().getOwnedExpressionPrimaryExpCSParserRuleCall_0_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrimaryExpCS_in_rulePrefixedExpCS10533);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4647:2: this_PrimaryExpCS_3= rulePrimaryExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrefixedExpCSAccess().getPrimaryExpCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrimaryExpCS_in_rulePrefixedExpCS10565);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4666:1: entryRulePrimaryExpCS returns [EObject current=null] : iv_rulePrimaryExpCS= rulePrimaryExpCS EOF ;
    public final EObject entryRulePrimaryExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4667:2: (iv_rulePrimaryExpCS= rulePrimaryExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4668:2: iv_rulePrimaryExpCS= rulePrimaryExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimaryExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePrimaryExpCS_in_entryRulePrimaryExpCS10600);
            iv_rulePrimaryExpCS=rulePrimaryExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimaryExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrimaryExpCS10610); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4675:1: rulePrimaryExpCS returns [EObject current=null] : (this_NestedExpCS_0= ruleNestedExpCS | this_IfExpCS_1= ruleIfExpCS | this_SelfExpCS_2= ruleSelfExpCS | this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS | this_CollectionLiteralExpCS_5= ruleCollectionLiteralExpCS | this_TypeLiteralExpCS_6= ruleTypeLiteralExpCS | ( () ( (lv_pathName_8_0= rulePathNameCS ) ) ( ( () otherlv_10= '[' ( (lv_firstIndexes_11_0= ruleExpCS ) ) (otherlv_12= ',' ( (lv_firstIndexes_13_0= ruleExpCS ) ) )* otherlv_14= ']' (otherlv_15= '[' ( (lv_secondIndexes_16_0= ruleExpCS ) ) (otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) ) )* otherlv_19= ']' )? ( ( (lv_atPre_20_0= '@' ) ) otherlv_21= 'pre' )? ) | ( () otherlv_23= '{' ( ( ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )* ) | ( (lv_value_27_0= ruleStringLiteral ) ) ) otherlv_28= '}' ) | ( ( ( (lv_atPre_29_0= '@' ) ) otherlv_30= 'pre' )? ( () otherlv_32= '(' ( ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_39= ')' )? ) ) ) ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4678:28: ( (this_NestedExpCS_0= ruleNestedExpCS | this_IfExpCS_1= ruleIfExpCS | this_SelfExpCS_2= ruleSelfExpCS | this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS | this_CollectionLiteralExpCS_5= ruleCollectionLiteralExpCS | this_TypeLiteralExpCS_6= ruleTypeLiteralExpCS | ( () ( (lv_pathName_8_0= rulePathNameCS ) ) ( ( () otherlv_10= '[' ( (lv_firstIndexes_11_0= ruleExpCS ) ) (otherlv_12= ',' ( (lv_firstIndexes_13_0= ruleExpCS ) ) )* otherlv_14= ']' (otherlv_15= '[' ( (lv_secondIndexes_16_0= ruleExpCS ) ) (otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) ) )* otherlv_19= ']' )? ( ( (lv_atPre_20_0= '@' ) ) otherlv_21= 'pre' )? ) | ( () otherlv_23= '{' ( ( ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )* ) | ( (lv_value_27_0= ruleStringLiteral ) ) ) otherlv_28= '}' ) | ( ( ( (lv_atPre_29_0= '@' ) ) otherlv_30= 'pre' )? ( () otherlv_32= '(' ( ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_39= ')' )? ) ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4679:1: (this_NestedExpCS_0= ruleNestedExpCS | this_IfExpCS_1= ruleIfExpCS | this_SelfExpCS_2= ruleSelfExpCS | this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS | this_CollectionLiteralExpCS_5= ruleCollectionLiteralExpCS | this_TypeLiteralExpCS_6= ruleTypeLiteralExpCS | ( () ( (lv_pathName_8_0= rulePathNameCS ) ) ( ( () otherlv_10= '[' ( (lv_firstIndexes_11_0= ruleExpCS ) ) (otherlv_12= ',' ( (lv_firstIndexes_13_0= ruleExpCS ) ) )* otherlv_14= ']' (otherlv_15= '[' ( (lv_secondIndexes_16_0= ruleExpCS ) ) (otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) ) )* otherlv_19= ']' )? ( ( (lv_atPre_20_0= '@' ) ) otherlv_21= 'pre' )? ) | ( () otherlv_23= '{' ( ( ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )* ) | ( (lv_value_27_0= ruleStringLiteral ) ) ) otherlv_28= '}' ) | ( ( ( (lv_atPre_29_0= '@' ) ) otherlv_30= 'pre' )? ( () otherlv_32= '(' ( ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_39= ')' )? ) ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4679:1: (this_NestedExpCS_0= ruleNestedExpCS | this_IfExpCS_1= ruleIfExpCS | this_SelfExpCS_2= ruleSelfExpCS | this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS | this_CollectionLiteralExpCS_5= ruleCollectionLiteralExpCS | this_TypeLiteralExpCS_6= ruleTypeLiteralExpCS | ( () ( (lv_pathName_8_0= rulePathNameCS ) ) ( ( () otherlv_10= '[' ( (lv_firstIndexes_11_0= ruleExpCS ) ) (otherlv_12= ',' ( (lv_firstIndexes_13_0= ruleExpCS ) ) )* otherlv_14= ']' (otherlv_15= '[' ( (lv_secondIndexes_16_0= ruleExpCS ) ) (otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) ) )* otherlv_19= ']' )? ( ( (lv_atPre_20_0= '@' ) ) otherlv_21= 'pre' )? ) | ( () otherlv_23= '{' ( ( ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )* ) | ( (lv_value_27_0= ruleStringLiteral ) ) ) otherlv_28= '}' ) | ( ( ( (lv_atPre_29_0= '@' ) ) otherlv_30= 'pre' )? ( () otherlv_32= '(' ( ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_39= ')' )? ) ) ) )
            int alt92=8;
            alt92 = dfa92.predict(input);
            switch (alt92) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4680:2: this_NestedExpCS_0= ruleNestedExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getNestedExpCSParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNestedExpCS_in_rulePrimaryExpCS10660);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4693:2: this_IfExpCS_1= ruleIfExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getIfExpCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleIfExpCS_in_rulePrimaryExpCS10690);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4706:2: this_SelfExpCS_2= ruleSelfExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getSelfExpCSParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSelfExpCS_in_rulePrimaryExpCS10720);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4719:2: this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getPrimitiveLiteralExpCSParserRuleCall_3()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrimitiveLiteralExpCS_in_rulePrimaryExpCS10750);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4732:2: this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getTupleLiteralExpCSParserRuleCall_4()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralExpCS_in_rulePrimaryExpCS10780);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4745:2: this_CollectionLiteralExpCS_5= ruleCollectionLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getCollectionLiteralExpCSParserRuleCall_5()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteralExpCS_in_rulePrimaryExpCS10810);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4758:2: this_TypeLiteralExpCS_6= ruleTypeLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getTypeLiteralExpCSParserRuleCall_6()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralExpCS_in_rulePrimaryExpCS10840);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4770:6: ( () ( (lv_pathName_8_0= rulePathNameCS ) ) ( ( () otherlv_10= '[' ( (lv_firstIndexes_11_0= ruleExpCS ) ) (otherlv_12= ',' ( (lv_firstIndexes_13_0= ruleExpCS ) ) )* otherlv_14= ']' (otherlv_15= '[' ( (lv_secondIndexes_16_0= ruleExpCS ) ) (otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) ) )* otherlv_19= ']' )? ( ( (lv_atPre_20_0= '@' ) ) otherlv_21= 'pre' )? ) | ( () otherlv_23= '{' ( ( ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )* ) | ( (lv_value_27_0= ruleStringLiteral ) ) ) otherlv_28= '}' ) | ( ( ( (lv_atPre_29_0= '@' ) ) otherlv_30= 'pre' )? ( () otherlv_32= '(' ( ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_39= ')' )? ) ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4770:6: ( () ( (lv_pathName_8_0= rulePathNameCS ) ) ( ( () otherlv_10= '[' ( (lv_firstIndexes_11_0= ruleExpCS ) ) (otherlv_12= ',' ( (lv_firstIndexes_13_0= ruleExpCS ) ) )* otherlv_14= ']' (otherlv_15= '[' ( (lv_secondIndexes_16_0= ruleExpCS ) ) (otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) ) )* otherlv_19= ']' )? ( ( (lv_atPre_20_0= '@' ) ) otherlv_21= 'pre' )? ) | ( () otherlv_23= '{' ( ( ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )* ) | ( (lv_value_27_0= ruleStringLiteral ) ) ) otherlv_28= '}' ) | ( ( ( (lv_atPre_29_0= '@' ) ) otherlv_30= 'pre' )? ( () otherlv_32= '(' ( ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_39= ')' )? ) ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4770:7: () ( (lv_pathName_8_0= rulePathNameCS ) ) ( ( () otherlv_10= '[' ( (lv_firstIndexes_11_0= ruleExpCS ) ) (otherlv_12= ',' ( (lv_firstIndexes_13_0= ruleExpCS ) ) )* otherlv_14= ']' (otherlv_15= '[' ( (lv_secondIndexes_16_0= ruleExpCS ) ) (otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) ) )* otherlv_19= ']' )? ( ( (lv_atPre_20_0= '@' ) ) otherlv_21= 'pre' )? ) | ( () otherlv_23= '{' ( ( ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )* ) | ( (lv_value_27_0= ruleStringLiteral ) ) ) otherlv_28= '}' ) | ( ( ( (lv_atPre_29_0= '@' ) ) otherlv_30= 'pre' )? ( () otherlv_32= '(' ( ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_39= ')' )? ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4770:7: ()
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4771:2: 
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

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4779:2: ( (lv_pathName_8_0= rulePathNameCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4780:1: (lv_pathName_8_0= rulePathNameCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4780:1: (lv_pathName_8_0= rulePathNameCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4781:3: lv_pathName_8_0= rulePathNameCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getPathNamePathNameCSParserRuleCall_7_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePathNameCS_in_rulePrimaryExpCS10879);
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

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4797:2: ( ( () otherlv_10= '[' ( (lv_firstIndexes_11_0= ruleExpCS ) ) (otherlv_12= ',' ( (lv_firstIndexes_13_0= ruleExpCS ) ) )* otherlv_14= ']' (otherlv_15= '[' ( (lv_secondIndexes_16_0= ruleExpCS ) ) (otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) ) )* otherlv_19= ']' )? ( ( (lv_atPre_20_0= '@' ) ) otherlv_21= 'pre' )? ) | ( () otherlv_23= '{' ( ( ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )* ) | ( (lv_value_27_0= ruleStringLiteral ) ) ) otherlv_28= '}' ) | ( ( ( (lv_atPre_29_0= '@' ) ) otherlv_30= 'pre' )? ( () otherlv_32= '(' ( ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_39= ')' )? ) )
                    int alt91=3;
                    switch ( input.LA(1) ) {
                    case 72:
                        {
                        alt91=1;
                        }
                        break;
                    case 20:
                        {
                        alt91=2;
                        }
                        break;
                    case EOF:
                    case 17:
                    case 19:
                    case 22:
                    case 23:
                    case 25:
                    case 26:
                    case 29:
                    case 30:
                    case 32:
                    case 34:
                    case 41:
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
                    case 55:
                    case 56:
                    case 71:
                    case 73:
                    case 79:
                    case 82:
                    case 83:
                    case 84:
                        {
                        alt91=3;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 91, 0, input);

                        throw nvae;
                    }

                    switch (alt91) {
                        case 1 :
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4797:3: ( () otherlv_10= '[' ( (lv_firstIndexes_11_0= ruleExpCS ) ) (otherlv_12= ',' ( (lv_firstIndexes_13_0= ruleExpCS ) ) )* otherlv_14= ']' (otherlv_15= '[' ( (lv_secondIndexes_16_0= ruleExpCS ) ) (otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) ) )* otherlv_19= ']' )? ( ( (lv_atPre_20_0= '@' ) ) otherlv_21= 'pre' )? )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4797:3: ( () otherlv_10= '[' ( (lv_firstIndexes_11_0= ruleExpCS ) ) (otherlv_12= ',' ( (lv_firstIndexes_13_0= ruleExpCS ) ) )* otherlv_14= ']' (otherlv_15= '[' ( (lv_secondIndexes_16_0= ruleExpCS ) ) (otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) ) )* otherlv_19= ']' )? ( ( (lv_atPre_20_0= '@' ) ) otherlv_21= 'pre' )? )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4797:4: () otherlv_10= '[' ( (lv_firstIndexes_11_0= ruleExpCS ) ) (otherlv_12= ',' ( (lv_firstIndexes_13_0= ruleExpCS ) ) )* otherlv_14= ']' (otherlv_15= '[' ( (lv_secondIndexes_16_0= ruleExpCS ) ) (otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) ) )* otherlv_19= ']' )? ( ( (lv_atPre_20_0= '@' ) ) otherlv_21= 'pre' )?
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4797:4: ()
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4798:2: 
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

                            otherlv_10=(Token)match(input,72,FollowSets000.FOLLOW_72_in_rulePrimaryExpCS10905); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_10, grammarAccess.getPrimaryExpCSAccess().getLeftSquareBracketKeyword_7_2_0_1());
                                  
                            }
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4810:1: ( (lv_firstIndexes_11_0= ruleExpCS ) )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4811:1: (lv_firstIndexes_11_0= ruleExpCS )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4811:1: (lv_firstIndexes_11_0= ruleExpCS )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4812:3: lv_firstIndexes_11_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getFirstIndexesExpCSParserRuleCall_7_2_0_2_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_rulePrimaryExpCS10926);
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

                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4828:2: (otherlv_12= ',' ( (lv_firstIndexes_13_0= ruleExpCS ) ) )*
                            loop77:
                            do {
                                int alt77=2;
                                int LA77_0 = input.LA(1);

                                if ( (LA77_0==19) ) {
                                    alt77=1;
                                }


                                switch (alt77) {
                            	case 1 :
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4828:4: otherlv_12= ',' ( (lv_firstIndexes_13_0= ruleExpCS ) )
                            	    {
                            	    otherlv_12=(Token)match(input,19,FollowSets000.FOLLOW_19_in_rulePrimaryExpCS10939); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_12, grammarAccess.getPrimaryExpCSAccess().getCommaKeyword_7_2_0_3_0());
                            	          
                            	    }
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4832:1: ( (lv_firstIndexes_13_0= ruleExpCS ) )
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4833:1: (lv_firstIndexes_13_0= ruleExpCS )
                            	    {
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4833:1: (lv_firstIndexes_13_0= ruleExpCS )
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4834:3: lv_firstIndexes_13_0= ruleExpCS
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getFirstIndexesExpCSParserRuleCall_7_2_0_3_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_rulePrimaryExpCS10960);
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
                            	    break loop77;
                                }
                            } while (true);

                            otherlv_14=(Token)match(input,73,FollowSets000.FOLLOW_73_in_rulePrimaryExpCS10974); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_14, grammarAccess.getPrimaryExpCSAccess().getRightSquareBracketKeyword_7_2_0_4());
                                  
                            }
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4854:1: (otherlv_15= '[' ( (lv_secondIndexes_16_0= ruleExpCS ) ) (otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) ) )* otherlv_19= ']' )?
                            int alt79=2;
                            int LA79_0 = input.LA(1);

                            if ( (LA79_0==72) ) {
                                alt79=1;
                            }
                            switch (alt79) {
                                case 1 :
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4854:3: otherlv_15= '[' ( (lv_secondIndexes_16_0= ruleExpCS ) ) (otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) ) )* otherlv_19= ']'
                                    {
                                    otherlv_15=(Token)match(input,72,FollowSets000.FOLLOW_72_in_rulePrimaryExpCS10987); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                          	newLeafNode(otherlv_15, grammarAccess.getPrimaryExpCSAccess().getLeftSquareBracketKeyword_7_2_0_5_0());
                                          
                                    }
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4858:1: ( (lv_secondIndexes_16_0= ruleExpCS ) )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4859:1: (lv_secondIndexes_16_0= ruleExpCS )
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4859:1: (lv_secondIndexes_16_0= ruleExpCS )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4860:3: lv_secondIndexes_16_0= ruleExpCS
                                    {
                                    if ( state.backtracking==0 ) {
                                       
                                      	        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getSecondIndexesExpCSParserRuleCall_7_2_0_5_1_0()); 
                                      	    
                                    }
                                    pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_rulePrimaryExpCS11008);
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

                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4876:2: (otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) ) )*
                                    loop78:
                                    do {
                                        int alt78=2;
                                        int LA78_0 = input.LA(1);

                                        if ( (LA78_0==19) ) {
                                            alt78=1;
                                        }


                                        switch (alt78) {
                                    	case 1 :
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4876:4: otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) )
                                    	    {
                                    	    otherlv_17=(Token)match(input,19,FollowSets000.FOLLOW_19_in_rulePrimaryExpCS11021); if (state.failed) return current;
                                    	    if ( state.backtracking==0 ) {

                                    	          	newLeafNode(otherlv_17, grammarAccess.getPrimaryExpCSAccess().getCommaKeyword_7_2_0_5_2_0());
                                    	          
                                    	    }
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4880:1: ( (lv_secondIndexes_18_0= ruleExpCS ) )
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4881:1: (lv_secondIndexes_18_0= ruleExpCS )
                                    	    {
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4881:1: (lv_secondIndexes_18_0= ruleExpCS )
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4882:3: lv_secondIndexes_18_0= ruleExpCS
                                    	    {
                                    	    if ( state.backtracking==0 ) {
                                    	       
                                    	      	        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getSecondIndexesExpCSParserRuleCall_7_2_0_5_2_1_0()); 
                                    	      	    
                                    	    }
                                    	    pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_rulePrimaryExpCS11042);
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
                                    	    break loop78;
                                        }
                                    } while (true);

                                    otherlv_19=(Token)match(input,73,FollowSets000.FOLLOW_73_in_rulePrimaryExpCS11056); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                          	newLeafNode(otherlv_19, grammarAccess.getPrimaryExpCSAccess().getRightSquareBracketKeyword_7_2_0_5_3());
                                          
                                    }

                                    }
                                    break;

                            }

                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4902:3: ( ( (lv_atPre_20_0= '@' ) ) otherlv_21= 'pre' )?
                            int alt80=2;
                            int LA80_0 = input.LA(1);

                            if ( (LA80_0==79) ) {
                                alt80=1;
                            }
                            switch (alt80) {
                                case 1 :
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4902:4: ( (lv_atPre_20_0= '@' ) ) otherlv_21= 'pre'
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4902:4: ( (lv_atPre_20_0= '@' ) )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4903:1: (lv_atPre_20_0= '@' )
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4903:1: (lv_atPre_20_0= '@' )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4904:3: lv_atPre_20_0= '@'
                                    {
                                    lv_atPre_20_0=(Token)match(input,79,FollowSets000.FOLLOW_79_in_rulePrimaryExpCS11077); if (state.failed) return current;
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

                                    otherlv_21=(Token)match(input,80,FollowSets000.FOLLOW_80_in_rulePrimaryExpCS11102); if (state.failed) return current;
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
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4922:6: ( () otherlv_23= '{' ( ( ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )* ) | ( (lv_value_27_0= ruleStringLiteral ) ) ) otherlv_28= '}' )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4922:6: ( () otherlv_23= '{' ( ( ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )* ) | ( (lv_value_27_0= ruleStringLiteral ) ) ) otherlv_28= '}' )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4922:7: () otherlv_23= '{' ( ( ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )* ) | ( (lv_value_27_0= ruleStringLiteral ) ) ) otherlv_28= '}'
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4922:7: ()
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4923:2: 
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

                            otherlv_23=(Token)match(input,20,FollowSets000.FOLLOW_20_in_rulePrimaryExpCS11136); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_23, grammarAccess.getPrimaryExpCSAccess().getLeftCurlyBracketKeyword_7_2_1_1());
                                  
                            }
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4935:1: ( ( ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )* ) | ( (lv_value_27_0= ruleStringLiteral ) ) )
                            int alt82=2;
                            int LA82_0 = input.LA(1);

                            if ( ((LA82_0>=RULE_SIMPLE_ID && LA82_0<=RULE_ESCAPED_ID)||LA82_0==16||LA82_0==18||(LA82_0>=27 && LA82_0<=28)||LA82_0==31||(LA82_0>=35 && LA82_0<=40)) ) {
                                alt82=1;
                            }
                            else if ( (LA82_0==RULE_SINGLE_QUOTED_STRING) ) {
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
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4935:2: ( ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )* )
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4935:2: ( ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )* )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4935:3: ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )*
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4935:3: ( (lv_ownedParts_24_0= ruleConstructorPartCS ) )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4936:1: (lv_ownedParts_24_0= ruleConstructorPartCS )
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4936:1: (lv_ownedParts_24_0= ruleConstructorPartCS )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4937:3: lv_ownedParts_24_0= ruleConstructorPartCS
                                    {
                                    if ( state.backtracking==0 ) {
                                       
                                      	        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getOwnedPartsConstructorPartCSParserRuleCall_7_2_1_2_0_0_0()); 
                                      	    
                                    }
                                    pushFollow(FollowSets000.FOLLOW_ruleConstructorPartCS_in_rulePrimaryExpCS11159);
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

                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4953:2: (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )*
                                    loop81:
                                    do {
                                        int alt81=2;
                                        int LA81_0 = input.LA(1);

                                        if ( (LA81_0==19) ) {
                                            alt81=1;
                                        }


                                        switch (alt81) {
                                    	case 1 :
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4953:4: otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) )
                                    	    {
                                    	    otherlv_25=(Token)match(input,19,FollowSets000.FOLLOW_19_in_rulePrimaryExpCS11172); if (state.failed) return current;
                                    	    if ( state.backtracking==0 ) {

                                    	          	newLeafNode(otherlv_25, grammarAccess.getPrimaryExpCSAccess().getCommaKeyword_7_2_1_2_0_1_0());
                                    	          
                                    	    }
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4957:1: ( (lv_ownedParts_26_0= ruleConstructorPartCS ) )
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4958:1: (lv_ownedParts_26_0= ruleConstructorPartCS )
                                    	    {
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4958:1: (lv_ownedParts_26_0= ruleConstructorPartCS )
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4959:3: lv_ownedParts_26_0= ruleConstructorPartCS
                                    	    {
                                    	    if ( state.backtracking==0 ) {
                                    	       
                                    	      	        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getOwnedPartsConstructorPartCSParserRuleCall_7_2_1_2_0_1_1_0()); 
                                    	      	    
                                    	    }
                                    	    pushFollow(FollowSets000.FOLLOW_ruleConstructorPartCS_in_rulePrimaryExpCS11193);
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
                                    	    break loop81;
                                        }
                                    } while (true);


                                    }


                                    }
                                    break;
                                case 2 :
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4976:6: ( (lv_value_27_0= ruleStringLiteral ) )
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4976:6: ( (lv_value_27_0= ruleStringLiteral ) )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4977:1: (lv_value_27_0= ruleStringLiteral )
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4977:1: (lv_value_27_0= ruleStringLiteral )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4978:3: lv_value_27_0= ruleStringLiteral
                                    {
                                    if ( state.backtracking==0 ) {
                                       
                                      	        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getValueStringLiteralParserRuleCall_7_2_1_2_1_0()); 
                                      	    
                                    }
                                    pushFollow(FollowSets000.FOLLOW_ruleStringLiteral_in_rulePrimaryExpCS11223);
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

                            otherlv_28=(Token)match(input,22,FollowSets000.FOLLOW_22_in_rulePrimaryExpCS11236); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_28, grammarAccess.getPrimaryExpCSAccess().getRightCurlyBracketKeyword_7_2_1_3());
                                  
                            }

                            }


                            }
                            break;
                        case 3 :
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4999:6: ( ( ( (lv_atPre_29_0= '@' ) ) otherlv_30= 'pre' )? ( () otherlv_32= '(' ( ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_39= ')' )? )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4999:6: ( ( ( (lv_atPre_29_0= '@' ) ) otherlv_30= 'pre' )? ( () otherlv_32= '(' ( ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_39= ')' )? )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4999:7: ( ( (lv_atPre_29_0= '@' ) ) otherlv_30= 'pre' )? ( () otherlv_32= '(' ( ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_39= ')' )?
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4999:7: ( ( (lv_atPre_29_0= '@' ) ) otherlv_30= 'pre' )?
                            int alt83=2;
                            int LA83_0 = input.LA(1);

                            if ( (LA83_0==79) ) {
                                alt83=1;
                            }
                            switch (alt83) {
                                case 1 :
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4999:8: ( (lv_atPre_29_0= '@' ) ) otherlv_30= 'pre'
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4999:8: ( (lv_atPre_29_0= '@' ) )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5000:1: (lv_atPre_29_0= '@' )
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5000:1: (lv_atPre_29_0= '@' )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5001:3: lv_atPre_29_0= '@'
                                    {
                                    lv_atPre_29_0=(Token)match(input,79,FollowSets000.FOLLOW_79_in_rulePrimaryExpCS11263); if (state.failed) return current;
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

                                    otherlv_30=(Token)match(input,80,FollowSets000.FOLLOW_80_in_rulePrimaryExpCS11288); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                          	newLeafNode(otherlv_30, grammarAccess.getPrimaryExpCSAccess().getPreKeyword_7_2_2_0_1());
                                          
                                    }

                                    }
                                    break;

                            }

                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5018:3: ( () otherlv_32= '(' ( ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_39= ')' )?
                            int alt90=2;
                            int LA90_0 = input.LA(1);

                            if ( (LA90_0==29) ) {
                                alt90=1;
                            }
                            switch (alt90) {
                                case 1 :
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5018:4: () otherlv_32= '(' ( ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_39= ')'
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5018:4: ()
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5019:2: 
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

                                    otherlv_32=(Token)match(input,29,FollowSets000.FOLLOW_29_in_rulePrimaryExpCS11315); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                          	newLeafNode(otherlv_32, grammarAccess.getPrimaryExpCSAccess().getLeftParenthesisKeyword_7_2_2_1_1());
                                          
                                    }
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5031:1: ( ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )? )?
                                    int alt89=2;
                                    int LA89_0 = input.LA(1);

                                    if ( ((LA89_0>=RULE_SIMPLE_ID && LA89_0<=RULE_SINGLE_QUOTED_STRING)||LA89_0==16||LA89_0==18||(LA89_0>=27 && LA89_0<=29)||LA89_0==31||(LA89_0>=34 && LA89_0<=42)||(LA89_0>=57 && LA89_0<=70)||(LA89_0>=75 && LA89_0<=78)||LA89_0==81||(LA89_0>=85 && LA89_0<=86)) ) {
                                        alt89=1;
                                    }
                                    switch (alt89) {
                                        case 1 :
                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5031:2: ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )?
                                            {
                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5031:2: ( (lv_argument_33_0= ruleNavigatingArgCS ) )
                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5032:1: (lv_argument_33_0= ruleNavigatingArgCS )
                                            {
                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5032:1: (lv_argument_33_0= ruleNavigatingArgCS )
                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5033:3: lv_argument_33_0= ruleNavigatingArgCS
                                            {
                                            if ( state.backtracking==0 ) {
                                               
                                              	        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getArgumentNavigatingArgCSParserRuleCall_7_2_2_1_2_0_0()); 
                                              	    
                                            }
                                            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgCS_in_rulePrimaryExpCS11337);
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

                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5049:2: ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )*
                                            loop84:
                                            do {
                                                int alt84=2;
                                                int LA84_0 = input.LA(1);

                                                if ( (LA84_0==19) ) {
                                                    alt84=1;
                                                }


                                                switch (alt84) {
                                            	case 1 :
                                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5050:1: (lv_argument_34_0= ruleNavigatingCommaArgCS )
                                            	    {
                                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5050:1: (lv_argument_34_0= ruleNavigatingCommaArgCS )
                                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5051:3: lv_argument_34_0= ruleNavigatingCommaArgCS
                                            	    {
                                            	    if ( state.backtracking==0 ) {
                                            	       
                                            	      	        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getArgumentNavigatingCommaArgCSParserRuleCall_7_2_2_1_2_1_0()); 
                                            	      	    
                                            	    }
                                            	    pushFollow(FollowSets000.FOLLOW_ruleNavigatingCommaArgCS_in_rulePrimaryExpCS11358);
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
                                            	    break loop84;
                                                }
                                            } while (true);

                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5067:3: ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )?
                                            int alt86=2;
                                            int LA86_0 = input.LA(1);

                                            if ( (LA86_0==26) ) {
                                                alt86=1;
                                            }
                                            switch (alt86) {
                                                case 1 :
                                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5067:4: ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )*
                                                    {
                                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5067:4: ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) )
                                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5068:1: (lv_argument_35_0= ruleNavigatingSemiArgCS )
                                                    {
                                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5068:1: (lv_argument_35_0= ruleNavigatingSemiArgCS )
                                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5069:3: lv_argument_35_0= ruleNavigatingSemiArgCS
                                                    {
                                                    if ( state.backtracking==0 ) {
                                                       
                                                      	        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getArgumentNavigatingSemiArgCSParserRuleCall_7_2_2_1_2_2_0_0()); 
                                                      	    
                                                    }
                                                    pushFollow(FollowSets000.FOLLOW_ruleNavigatingSemiArgCS_in_rulePrimaryExpCS11381);
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

                                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5085:2: ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )*
                                                    loop85:
                                                    do {
                                                        int alt85=2;
                                                        int LA85_0 = input.LA(1);

                                                        if ( (LA85_0==19) ) {
                                                            alt85=1;
                                                        }


                                                        switch (alt85) {
                                                    	case 1 :
                                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5086:1: (lv_argument_36_0= ruleNavigatingCommaArgCS )
                                                    	    {
                                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5086:1: (lv_argument_36_0= ruleNavigatingCommaArgCS )
                                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5087:3: lv_argument_36_0= ruleNavigatingCommaArgCS
                                                    	    {
                                                    	    if ( state.backtracking==0 ) {
                                                    	       
                                                    	      	        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getArgumentNavigatingCommaArgCSParserRuleCall_7_2_2_1_2_2_1_0()); 
                                                    	      	    
                                                    	    }
                                                    	    pushFollow(FollowSets000.FOLLOW_ruleNavigatingCommaArgCS_in_rulePrimaryExpCS11402);
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
                                                    	    break loop85;
                                                        }
                                                    } while (true);


                                                    }
                                                    break;

                                            }

                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5103:5: ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )?
                                            int alt88=2;
                                            int LA88_0 = input.LA(1);

                                            if ( (LA88_0==23) ) {
                                                alt88=1;
                                            }
                                            switch (alt88) {
                                                case 1 :
                                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5103:6: ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )*
                                                    {
                                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5103:6: ( (lv_argument_37_0= ruleNavigatingBarArgCS ) )
                                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5104:1: (lv_argument_37_0= ruleNavigatingBarArgCS )
                                                    {
                                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5104:1: (lv_argument_37_0= ruleNavigatingBarArgCS )
                                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5105:3: lv_argument_37_0= ruleNavigatingBarArgCS
                                                    {
                                                    if ( state.backtracking==0 ) {
                                                       
                                                      	        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getArgumentNavigatingBarArgCSParserRuleCall_7_2_2_1_2_3_0_0()); 
                                                      	    
                                                    }
                                                    pushFollow(FollowSets000.FOLLOW_ruleNavigatingBarArgCS_in_rulePrimaryExpCS11427);
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

                                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5121:2: ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )*
                                                    loop87:
                                                    do {
                                                        int alt87=2;
                                                        int LA87_0 = input.LA(1);

                                                        if ( (LA87_0==19) ) {
                                                            alt87=1;
                                                        }


                                                        switch (alt87) {
                                                    	case 1 :
                                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5122:1: (lv_argument_38_0= ruleNavigatingCommaArgCS )
                                                    	    {
                                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5122:1: (lv_argument_38_0= ruleNavigatingCommaArgCS )
                                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5123:3: lv_argument_38_0= ruleNavigatingCommaArgCS
                                                    	    {
                                                    	    if ( state.backtracking==0 ) {
                                                    	       
                                                    	      	        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getArgumentNavigatingCommaArgCSParserRuleCall_7_2_2_1_2_3_1_0()); 
                                                    	      	    
                                                    	    }
                                                    	    pushFollow(FollowSets000.FOLLOW_ruleNavigatingCommaArgCS_in_rulePrimaryExpCS11448);
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
                                                    	    break loop87;
                                                        }
                                                    } while (true);


                                                    }
                                                    break;

                                            }


                                            }
                                            break;

                                    }

                                    otherlv_39=(Token)match(input,30,FollowSets000.FOLLOW_30_in_rulePrimaryExpCS11465); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5151:1: entryRuleNavigatingArgCS returns [EObject current=null] : iv_ruleNavigatingArgCS= ruleNavigatingArgCS EOF ;
    public final EObject entryRuleNavigatingArgCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingArgCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5152:2: (iv_ruleNavigatingArgCS= ruleNavigatingArgCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5153:2: iv_ruleNavigatingArgCS= ruleNavigatingArgCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingArgCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgCS_in_entryRuleNavigatingArgCS11506);
            iv_ruleNavigatingArgCS=ruleNavigatingArgCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingArgCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigatingArgCS11516); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5160:1: ruleNavigatingArgCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleNavigatingArgExpCS ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_init_4_0= ruleExpCS ) ) )? )? ) ;
    public final EObject ruleNavigatingArgCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;

        EObject lv_init_4_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5163:28: ( ( ( (lv_name_0_0= ruleNavigatingArgExpCS ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_init_4_0= ruleExpCS ) ) )? )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5164:1: ( ( (lv_name_0_0= ruleNavigatingArgExpCS ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_init_4_0= ruleExpCS ) ) )? )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5164:1: ( ( (lv_name_0_0= ruleNavigatingArgExpCS ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_init_4_0= ruleExpCS ) ) )? )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5164:2: ( (lv_name_0_0= ruleNavigatingArgExpCS ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_init_4_0= ruleExpCS ) ) )? )?
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5164:2: ( (lv_name_0_0= ruleNavigatingArgExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5165:1: (lv_name_0_0= ruleNavigatingArgExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5165:1: (lv_name_0_0= ruleNavigatingArgExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5166:3: lv_name_0_0= ruleNavigatingArgExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getNameNavigatingArgExpCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingArgCS11562);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5182:2: (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_init_4_0= ruleExpCS ) ) )? )?
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==32) ) {
                alt94=1;
            }
            switch (alt94) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5182:4: otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_init_4_0= ruleExpCS ) ) )?
                    {
                    otherlv_1=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleNavigatingArgCS11575); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getNavigatingArgCSAccess().getColonKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5186:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5187:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5187:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5188:3: lv_ownedType_2_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleNavigatingArgCS11596);
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

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5204:2: (otherlv_3= '=' ( (lv_init_4_0= ruleExpCS ) ) )?
                    int alt93=2;
                    int LA93_0 = input.LA(1);

                    if ( (LA93_0==49) ) {
                        alt93=1;
                    }
                    switch (alt93) {
                        case 1 :
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5204:4: otherlv_3= '=' ( (lv_init_4_0= ruleExpCS ) )
                            {
                            otherlv_3=(Token)match(input,49,FollowSets000.FOLLOW_49_in_ruleNavigatingArgCS11609); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_3, grammarAccess.getNavigatingArgCSAccess().getEqualsSignKeyword_1_2_0());
                                  
                            }
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5208:1: ( (lv_init_4_0= ruleExpCS ) )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5209:1: (lv_init_4_0= ruleExpCS )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5209:1: (lv_init_4_0= ruleExpCS )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5210:3: lv_init_4_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getInitExpCSParserRuleCall_1_2_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNavigatingArgCS11630);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5234:1: entryRuleNavigatingBarArgCS returns [EObject current=null] : iv_ruleNavigatingBarArgCS= ruleNavigatingBarArgCS EOF ;
    public final EObject entryRuleNavigatingBarArgCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingBarArgCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5235:2: (iv_ruleNavigatingBarArgCS= ruleNavigatingBarArgCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5236:2: iv_ruleNavigatingBarArgCS= ruleNavigatingBarArgCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingBarArgCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingBarArgCS_in_entryRuleNavigatingBarArgCS11670);
            iv_ruleNavigatingBarArgCS=ruleNavigatingBarArgCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingBarArgCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigatingBarArgCS11680); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5243:1: ruleNavigatingBarArgCS returns [EObject current=null] : ( ( (lv_prefix_0_0= '|' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )? ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5246:28: ( ( ( (lv_prefix_0_0= '|' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5247:1: ( ( (lv_prefix_0_0= '|' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5247:1: ( ( (lv_prefix_0_0= '|' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5247:2: ( (lv_prefix_0_0= '|' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )?
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5247:2: ( (lv_prefix_0_0= '|' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5248:1: (lv_prefix_0_0= '|' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5248:1: (lv_prefix_0_0= '|' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5249:3: lv_prefix_0_0= '|'
            {
            lv_prefix_0_0=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleNavigatingBarArgCS11723); if (state.failed) return current;
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5262:2: ( (lv_name_1_0= ruleNavigatingArgExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5263:1: (lv_name_1_0= ruleNavigatingArgExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5263:1: (lv_name_1_0= ruleNavigatingArgExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5264:3: lv_name_1_0= ruleNavigatingArgExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNavigatingBarArgCSAccess().getNameNavigatingArgExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingBarArgCS11757);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5280:2: (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )?
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==32) ) {
                alt96=1;
            }
            switch (alt96) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5280:4: otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )?
                    {
                    otherlv_2=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleNavigatingBarArgCS11770); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getNavigatingBarArgCSAccess().getColonKeyword_2_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5284:1: ( (lv_ownedType_3_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5285:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5285:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5286:3: lv_ownedType_3_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingBarArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleNavigatingBarArgCS11791);
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

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5302:2: (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )?
                    int alt95=2;
                    int LA95_0 = input.LA(1);

                    if ( (LA95_0==49) ) {
                        alt95=1;
                    }
                    switch (alt95) {
                        case 1 :
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5302:4: otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) )
                            {
                            otherlv_4=(Token)match(input,49,FollowSets000.FOLLOW_49_in_ruleNavigatingBarArgCS11804); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getNavigatingBarArgCSAccess().getEqualsSignKeyword_2_2_0());
                                  
                            }
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5306:1: ( (lv_init_5_0= ruleExpCS ) )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5307:1: (lv_init_5_0= ruleExpCS )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5307:1: (lv_init_5_0= ruleExpCS )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5308:3: lv_init_5_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getNavigatingBarArgCSAccess().getInitExpCSParserRuleCall_2_2_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNavigatingBarArgCS11825);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5332:1: entryRuleNavigatingCommaArgCS returns [EObject current=null] : iv_ruleNavigatingCommaArgCS= ruleNavigatingCommaArgCS EOF ;
    public final EObject entryRuleNavigatingCommaArgCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingCommaArgCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5333:2: (iv_ruleNavigatingCommaArgCS= ruleNavigatingCommaArgCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5334:2: iv_ruleNavigatingCommaArgCS= ruleNavigatingCommaArgCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingCommaArgCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingCommaArgCS_in_entryRuleNavigatingCommaArgCS11865);
            iv_ruleNavigatingCommaArgCS=ruleNavigatingCommaArgCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingCommaArgCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigatingCommaArgCS11875); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5341:1: ruleNavigatingCommaArgCS returns [EObject current=null] : ( ( (lv_prefix_0_0= ',' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )? ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5344:28: ( ( ( (lv_prefix_0_0= ',' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5345:1: ( ( (lv_prefix_0_0= ',' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5345:1: ( ( (lv_prefix_0_0= ',' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5345:2: ( (lv_prefix_0_0= ',' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )?
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5345:2: ( (lv_prefix_0_0= ',' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5346:1: (lv_prefix_0_0= ',' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5346:1: (lv_prefix_0_0= ',' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5347:3: lv_prefix_0_0= ','
            {
            lv_prefix_0_0=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleNavigatingCommaArgCS11918); if (state.failed) return current;
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5360:2: ( (lv_name_1_0= ruleNavigatingArgExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5361:1: (lv_name_1_0= ruleNavigatingArgExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5361:1: (lv_name_1_0= ruleNavigatingArgExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5362:3: lv_name_1_0= ruleNavigatingArgExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getNameNavigatingArgExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingCommaArgCS11952);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5378:2: (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )?
            int alt98=2;
            int LA98_0 = input.LA(1);

            if ( (LA98_0==32) ) {
                alt98=1;
            }
            switch (alt98) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5378:4: otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )?
                    {
                    otherlv_2=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleNavigatingCommaArgCS11965); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getNavigatingCommaArgCSAccess().getColonKeyword_2_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5382:1: ( (lv_ownedType_3_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5383:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5383:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5384:3: lv_ownedType_3_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleNavigatingCommaArgCS11986);
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

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5400:2: (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )?
                    int alt97=2;
                    int LA97_0 = input.LA(1);

                    if ( (LA97_0==49) ) {
                        alt97=1;
                    }
                    switch (alt97) {
                        case 1 :
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5400:4: otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) )
                            {
                            otherlv_4=(Token)match(input,49,FollowSets000.FOLLOW_49_in_ruleNavigatingCommaArgCS11999); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getNavigatingCommaArgCSAccess().getEqualsSignKeyword_2_2_0());
                                  
                            }
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5404:1: ( (lv_init_5_0= ruleExpCS ) )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5405:1: (lv_init_5_0= ruleExpCS )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5405:1: (lv_init_5_0= ruleExpCS )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5406:3: lv_init_5_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getInitExpCSParserRuleCall_2_2_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNavigatingCommaArgCS12020);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5430:1: entryRuleNavigatingSemiArgCS returns [EObject current=null] : iv_ruleNavigatingSemiArgCS= ruleNavigatingSemiArgCS EOF ;
    public final EObject entryRuleNavigatingSemiArgCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingSemiArgCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5431:2: (iv_ruleNavigatingSemiArgCS= ruleNavigatingSemiArgCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5432:2: iv_ruleNavigatingSemiArgCS= ruleNavigatingSemiArgCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingSemiArgCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingSemiArgCS_in_entryRuleNavigatingSemiArgCS12060);
            iv_ruleNavigatingSemiArgCS=ruleNavigatingSemiArgCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingSemiArgCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigatingSemiArgCS12070); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5439:1: ruleNavigatingSemiArgCS returns [EObject current=null] : ( ( (lv_prefix_0_0= ';' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )? ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5442:28: ( ( ( (lv_prefix_0_0= ';' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5443:1: ( ( (lv_prefix_0_0= ';' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5443:1: ( ( (lv_prefix_0_0= ';' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5443:2: ( (lv_prefix_0_0= ';' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )?
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5443:2: ( (lv_prefix_0_0= ';' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5444:1: (lv_prefix_0_0= ';' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5444:1: (lv_prefix_0_0= ';' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5445:3: lv_prefix_0_0= ';'
            {
            lv_prefix_0_0=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleNavigatingSemiArgCS12113); if (state.failed) return current;
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5458:2: ( (lv_name_1_0= ruleNavigatingArgExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5459:1: (lv_name_1_0= ruleNavigatingArgExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5459:1: (lv_name_1_0= ruleNavigatingArgExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5460:3: lv_name_1_0= ruleNavigatingArgExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNavigatingSemiArgCSAccess().getNameNavigatingArgExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingSemiArgCS12147);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5476:2: (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )?
            int alt100=2;
            int LA100_0 = input.LA(1);

            if ( (LA100_0==32) ) {
                alt100=1;
            }
            switch (alt100) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5476:4: otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )?
                    {
                    otherlv_2=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleNavigatingSemiArgCS12160); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getNavigatingSemiArgCSAccess().getColonKeyword_2_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5480:1: ( (lv_ownedType_3_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5481:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5481:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5482:3: lv_ownedType_3_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingSemiArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleNavigatingSemiArgCS12181);
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

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5498:2: (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )?
                    int alt99=2;
                    int LA99_0 = input.LA(1);

                    if ( (LA99_0==49) ) {
                        alt99=1;
                    }
                    switch (alt99) {
                        case 1 :
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5498:4: otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) )
                            {
                            otherlv_4=(Token)match(input,49,FollowSets000.FOLLOW_49_in_ruleNavigatingSemiArgCS12194); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getNavigatingSemiArgCSAccess().getEqualsSignKeyword_2_2_0());
                                  
                            }
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5502:1: ( (lv_init_5_0= ruleExpCS ) )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5503:1: (lv_init_5_0= ruleExpCS )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5503:1: (lv_init_5_0= ruleExpCS )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5504:3: lv_init_5_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getNavigatingSemiArgCSAccess().getInitExpCSParserRuleCall_2_2_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNavigatingSemiArgCS12215);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5528:1: entryRuleNavigatingArgExpCS returns [EObject current=null] : iv_ruleNavigatingArgExpCS= ruleNavigatingArgExpCS EOF ;
    public final EObject entryRuleNavigatingArgExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingArgExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5529:2: (iv_ruleNavigatingArgExpCS= ruleNavigatingArgExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5530:2: iv_ruleNavigatingArgExpCS= ruleNavigatingArgExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingArgExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgExpCS_in_entryRuleNavigatingArgExpCS12255);
            iv_ruleNavigatingArgExpCS=ruleNavigatingArgExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingArgExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigatingArgExpCS12265); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5537:1: ruleNavigatingArgExpCS returns [EObject current=null] : this_ExpCS_0= ruleExpCS ;
    public final EObject ruleNavigatingArgExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_ExpCS_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5540:28: (this_ExpCS_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5542:2: this_ExpCS_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getNavigatingArgExpCSAccess().getExpCSParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNavigatingArgExpCS12314);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5561:1: entryRuleIfExpCS returns [EObject current=null] : iv_ruleIfExpCS= ruleIfExpCS EOF ;
    public final EObject entryRuleIfExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5562:2: (iv_ruleIfExpCS= ruleIfExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5563:2: iv_ruleIfExpCS= ruleIfExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIfExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIfExpCS_in_entryRuleIfExpCS12348);
            iv_ruleIfExpCS=ruleIfExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIfExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIfExpCS12358); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5570:1: ruleIfExpCS returns [EObject current=null] : (otherlv_0= 'if' ( (lv_condition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_thenExpression_3_0= ruleExpCS ) ) otherlv_4= 'else' ( (lv_elseExpression_5_0= ruleExpCS ) ) otherlv_6= 'endif' ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5573:28: ( (otherlv_0= 'if' ( (lv_condition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_thenExpression_3_0= ruleExpCS ) ) otherlv_4= 'else' ( (lv_elseExpression_5_0= ruleExpCS ) ) otherlv_6= 'endif' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5574:1: (otherlv_0= 'if' ( (lv_condition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_thenExpression_3_0= ruleExpCS ) ) otherlv_4= 'else' ( (lv_elseExpression_5_0= ruleExpCS ) ) otherlv_6= 'endif' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5574:1: (otherlv_0= 'if' ( (lv_condition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_thenExpression_3_0= ruleExpCS ) ) otherlv_4= 'else' ( (lv_elseExpression_5_0= ruleExpCS ) ) otherlv_6= 'endif' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5574:3: otherlv_0= 'if' ( (lv_condition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_thenExpression_3_0= ruleExpCS ) ) otherlv_4= 'else' ( (lv_elseExpression_5_0= ruleExpCS ) ) otherlv_6= 'endif'
            {
            otherlv_0=(Token)match(input,81,FollowSets000.FOLLOW_81_in_ruleIfExpCS12395); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getIfExpCSAccess().getIfKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5578:1: ( (lv_condition_1_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5579:1: (lv_condition_1_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5579:1: (lv_condition_1_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5580:3: lv_condition_1_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIfExpCSAccess().getConditionExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleIfExpCS12416);
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

            otherlv_2=(Token)match(input,82,FollowSets000.FOLLOW_82_in_ruleIfExpCS12428); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getIfExpCSAccess().getThenKeyword_2());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5600:1: ( (lv_thenExpression_3_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5601:1: (lv_thenExpression_3_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5601:1: (lv_thenExpression_3_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5602:3: lv_thenExpression_3_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIfExpCSAccess().getThenExpressionExpCSParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleIfExpCS12449);
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

            otherlv_4=(Token)match(input,83,FollowSets000.FOLLOW_83_in_ruleIfExpCS12461); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getIfExpCSAccess().getElseKeyword_4());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5622:1: ( (lv_elseExpression_5_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5623:1: (lv_elseExpression_5_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5623:1: (lv_elseExpression_5_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5624:3: lv_elseExpression_5_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIfExpCSAccess().getElseExpressionExpCSParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleIfExpCS12482);
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

            otherlv_6=(Token)match(input,84,FollowSets000.FOLLOW_84_in_ruleIfExpCS12494); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5652:1: entryRuleLetExpCS returns [EObject current=null] : iv_ruleLetExpCS= ruleLetExpCS EOF ;
    public final EObject entryRuleLetExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLetExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5653:2: (iv_ruleLetExpCS= ruleLetExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5654:2: iv_ruleLetExpCS= ruleLetExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLetExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLetExpCS_in_entryRuleLetExpCS12530);
            iv_ruleLetExpCS=ruleLetExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLetExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLetExpCS12540); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5661:1: ruleLetExpCS returns [EObject current=null] : (otherlv_0= 'let' ( (lv_variable_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_variable_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_in_5_0= ruleExpCS ) ) ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5664:28: ( (otherlv_0= 'let' ( (lv_variable_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_variable_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_in_5_0= ruleExpCS ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5665:1: (otherlv_0= 'let' ( (lv_variable_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_variable_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_in_5_0= ruleExpCS ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5665:1: (otherlv_0= 'let' ( (lv_variable_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_variable_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_in_5_0= ruleExpCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5665:3: otherlv_0= 'let' ( (lv_variable_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_variable_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_in_5_0= ruleExpCS ) )
            {
            otherlv_0=(Token)match(input,85,FollowSets000.FOLLOW_85_in_ruleLetExpCS12577); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLetExpCSAccess().getLetKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5669:1: ( (lv_variable_1_0= ruleLetVariableCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5670:1: (lv_variable_1_0= ruleLetVariableCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5670:1: (lv_variable_1_0= ruleLetVariableCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5671:3: lv_variable_1_0= ruleLetVariableCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetExpCSAccess().getVariableLetVariableCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleLetVariableCS_in_ruleLetExpCS12598);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5687:2: (otherlv_2= ',' ( (lv_variable_3_0= ruleLetVariableCS ) ) )*
            loop101:
            do {
                int alt101=2;
                int LA101_0 = input.LA(1);

                if ( (LA101_0==19) ) {
                    alt101=1;
                }


                switch (alt101) {
            	case 1 :
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5687:4: otherlv_2= ',' ( (lv_variable_3_0= ruleLetVariableCS ) )
            	    {
            	    otherlv_2=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleLetExpCS12611); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getLetExpCSAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5691:1: ( (lv_variable_3_0= ruleLetVariableCS ) )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5692:1: (lv_variable_3_0= ruleLetVariableCS )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5692:1: (lv_variable_3_0= ruleLetVariableCS )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5693:3: lv_variable_3_0= ruleLetVariableCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLetExpCSAccess().getVariableLetVariableCSParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleLetVariableCS_in_ruleLetExpCS12632);
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
            	    break loop101;
                }
            } while (true);

            otherlv_4=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleLetExpCS12646); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getLetExpCSAccess().getInKeyword_3());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5713:1: ( (lv_in_5_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5714:1: (lv_in_5_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5714:1: (lv_in_5_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5715:3: lv_in_5_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetExpCSAccess().getInExpCSParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleLetExpCS12667);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5739:1: entryRuleLetVariableCS returns [EObject current=null] : iv_ruleLetVariableCS= ruleLetVariableCS EOF ;
    public final EObject entryRuleLetVariableCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLetVariableCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5740:2: (iv_ruleLetVariableCS= ruleLetVariableCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5741:2: iv_ruleLetVariableCS= ruleLetVariableCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLetVariableCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLetVariableCS_in_entryRuleLetVariableCS12703);
            iv_ruleLetVariableCS=ruleLetVariableCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLetVariableCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLetVariableCS12713); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5748:1: ruleLetVariableCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) ) ) ;
    public final EObject ruleLetVariableCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;

        EObject lv_initExpression_4_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5751:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5752:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5752:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5752:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5752:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5753:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5753:1: (lv_name_0_0= ruleUnrestrictedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5754:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetVariableCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleLetVariableCS12759);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5770:2: (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )?
            int alt102=2;
            int LA102_0 = input.LA(1);

            if ( (LA102_0==32) ) {
                alt102=1;
            }
            switch (alt102) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5770:4: otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                    {
                    otherlv_1=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleLetVariableCS12772); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getLetVariableCSAccess().getColonKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5774:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5775:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5775:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5776:3: lv_ownedType_2_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLetVariableCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleLetVariableCS12793);
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

            otherlv_3=(Token)match(input,49,FollowSets000.FOLLOW_49_in_ruleLetVariableCS12807); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getLetVariableCSAccess().getEqualsSignKeyword_2());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5796:1: ( (lv_initExpression_4_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5797:1: (lv_initExpression_4_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5797:1: (lv_initExpression_4_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5798:3: lv_initExpression_4_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetVariableCSAccess().getInitExpressionExpCSParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleLetVariableCS12828);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5822:1: entryRuleNestedExpCS returns [EObject current=null] : iv_ruleNestedExpCS= ruleNestedExpCS EOF ;
    public final EObject entryRuleNestedExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNestedExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5823:2: (iv_ruleNestedExpCS= ruleNestedExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5824:2: iv_ruleNestedExpCS= ruleNestedExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNestedExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNestedExpCS_in_entryRuleNestedExpCS12864);
            iv_ruleNestedExpCS=ruleNestedExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNestedExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNestedExpCS12874); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5831:1: ruleNestedExpCS returns [EObject current=null] : (otherlv_0= '(' ( (lv_source_1_0= ruleExpCS ) ) otherlv_2= ')' ) ;
    public final EObject ruleNestedExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_source_1_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5834:28: ( (otherlv_0= '(' ( (lv_source_1_0= ruleExpCS ) ) otherlv_2= ')' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5835:1: (otherlv_0= '(' ( (lv_source_1_0= ruleExpCS ) ) otherlv_2= ')' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5835:1: (otherlv_0= '(' ( (lv_source_1_0= ruleExpCS ) ) otherlv_2= ')' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5835:3: otherlv_0= '(' ( (lv_source_1_0= ruleExpCS ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleNestedExpCS12911); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getNestedExpCSAccess().getLeftParenthesisKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5839:1: ( (lv_source_1_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5840:1: (lv_source_1_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5840:1: (lv_source_1_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5841:3: lv_source_1_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNestedExpCSAccess().getSourceExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNestedExpCS12932);
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

            otherlv_2=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleNestedExpCS12944); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5869:1: entryRuleSelfExpCS returns [EObject current=null] : iv_ruleSelfExpCS= ruleSelfExpCS EOF ;
    public final EObject entryRuleSelfExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelfExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5870:2: (iv_ruleSelfExpCS= ruleSelfExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5871:2: iv_ruleSelfExpCS= ruleSelfExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSelfExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSelfExpCS_in_entryRuleSelfExpCS12980);
            iv_ruleSelfExpCS=ruleSelfExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSelfExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSelfExpCS12990); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5878:1: ruleSelfExpCS returns [EObject current=null] : ( () otherlv_1= 'self' ) ;
    public final EObject ruleSelfExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5881:28: ( ( () otherlv_1= 'self' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5882:1: ( () otherlv_1= 'self' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5882:1: ( () otherlv_1= 'self' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5882:2: () otherlv_1= 'self'
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5882:2: ()
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5883:2: 
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

            otherlv_1=(Token)match(input,86,FollowSets000.FOLLOW_86_in_ruleSelfExpCS13039); if (state.failed) return current;
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

    // $ANTLR start synpred124_InternalQVTcore
    public final void synpred124_InternalQVTcore_fragment() throws RecognitionException {   
        EObject this_TupleLiteralExpCS_4 = null;


        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4732:2: (this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS )
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4732:2: this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralExpCS_in_synpred124_InternalQVTcore10780);
        this_TupleLiteralExpCS_4=ruleTupleLiteralExpCS();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred124_InternalQVTcore

    // $ANTLR start synpred125_InternalQVTcore
    public final void synpred125_InternalQVTcore_fragment() throws RecognitionException {   
        EObject this_CollectionLiteralExpCS_5 = null;


        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4745:2: (this_CollectionLiteralExpCS_5= ruleCollectionLiteralExpCS )
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4745:2: this_CollectionLiteralExpCS_5= ruleCollectionLiteralExpCS
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteralExpCS_in_synpred125_InternalQVTcore10810);
        this_CollectionLiteralExpCS_5=ruleCollectionLiteralExpCS();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred125_InternalQVTcore

    // $ANTLR start synpred126_InternalQVTcore
    public final void synpred126_InternalQVTcore_fragment() throws RecognitionException {   
        EObject this_TypeLiteralExpCS_6 = null;


        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4758:2: (this_TypeLiteralExpCS_6= ruleTypeLiteralExpCS )
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4758:2: this_TypeLiteralExpCS_6= ruleTypeLiteralExpCS
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralExpCS_in_synpred126_InternalQVTcore10840);
        this_TypeLiteralExpCS_6=ruleTypeLiteralExpCS();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred126_InternalQVTcore

    // Delegated rules

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


    protected DFA15 dfa15 = new DFA15(this);
    protected DFA18 dfa18 = new DFA18(this);
    protected DFA26 dfa26 = new DFA26(this);
    protected DFA34 dfa34 = new DFA34(this);
    protected DFA35 dfa35 = new DFA35(this);
    protected DFA74 dfa74 = new DFA74(this);
    protected DFA69 dfa69 = new DFA69(this);
    protected DFA92 dfa92 = new DFA92(this);
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
            "\1\17\4\uffff\2\17\2\uffff\1\17\2\uffff\1\20\2\17\6\uffff"+
            "\1\17\1\uffff\16\17\17\uffff\1\17\6\uffff\1\17",
            "\1\17\4\uffff\2\17\2\uffff\1\17\2\uffff\1\20\2\17\6\uffff"+
            "\1\17\1\uffff\16\17\17\uffff\1\17\6\uffff\1\17",
            "\1\17\4\uffff\2\17\2\uffff\1\17\2\uffff\1\20\2\17\6\uffff"+
            "\1\17\1\uffff\16\17\17\uffff\1\17\6\uffff\1\17",
            "\1\17\4\uffff\2\17\2\uffff\1\17\2\uffff\1\20\2\17\6\uffff"+
            "\1\17\1\uffff\16\17\17\uffff\1\17\6\uffff\1\17",
            "\1\17\4\uffff\2\17\2\uffff\1\17\2\uffff\1\20\2\17\6\uffff"+
            "\1\17\1\uffff\16\17\17\uffff\1\17\6\uffff\1\17",
            "\1\17\4\uffff\2\17\2\uffff\1\17\2\uffff\1\20\2\17\6\uffff"+
            "\1\17\1\uffff\16\17\17\uffff\1\17\6\uffff\1\17",
            "\1\17\4\uffff\2\17\2\uffff\1\17\2\uffff\1\20\2\17\6\uffff"+
            "\1\17\1\uffff\16\17\17\uffff\1\17\6\uffff\1\17",
            "\1\17\4\uffff\2\17\2\uffff\1\17\2\uffff\1\20\2\17\6\uffff"+
            "\1\17\1\uffff\16\17\17\uffff\1\17\6\uffff\1\17",
            "\1\17\4\uffff\2\17\2\uffff\1\17\2\uffff\1\20\2\17\6\uffff"+
            "\1\17\1\uffff\16\17\17\uffff\1\17\6\uffff\1\17",
            "\2\20\12\uffff\1\20\1\uffff\1\20\1\uffff\1\17\4\uffff\2\17"+
            "\2\20\1\17\1\uffff\2\20\2\17\6\20\1\17\1\uffff\16\17\17\uffff"+
            "\1\17\6\uffff\1\17",
            "\1\17\4\uffff\2\17\2\uffff\1\17\2\uffff\1\20\2\17\6\uffff"+
            "\1\17\1\uffff\16\17\17\uffff\1\17\6\uffff\1\17",
            "\1\17\4\uffff\2\17\2\uffff\1\17\2\uffff\1\20\2\17\6\uffff"+
            "\1\17\1\uffff\16\17\17\uffff\1\17\6\uffff\1\17",
            "\1\17\4\uffff\2\17\2\uffff\1\17\2\uffff\1\20\2\17\6\uffff"+
            "\1\17\1\uffff\16\17\17\uffff\1\17\6\uffff\1\17",
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
            "\2\4\12\uffff\1\4\1\uffff\1\4\7\uffff\1\1\1\5\1\6\2\uffff"+
            "\1\4\3\uffff\6\4",
            "\2\4\12\uffff\1\4\1\uffff\1\4\7\uffff\1\1\1\7\1\10\2\uffff"+
            "\1\4\3\uffff\6\4",
            "",
            "\2\1\12\uffff\1\1\1\uffff\1\1\1\4\6\uffff\1\4\1\1\1\11\2\uffff"+
            "\1\1\3\uffff\6\1",
            "\2\1\12\uffff\1\1\1\uffff\1\1\1\4\6\uffff\1\4\1\1\1\12\2\uffff"+
            "\1\1\3\uffff\6\1",
            "\2\1\12\uffff\1\1\1\uffff\1\1\1\4\6\uffff\1\4\2\1\2\uffff"+
            "\1\1\3\uffff\6\1",
            "\2\1\12\uffff\1\1\1\uffff\1\1\1\4\6\uffff\1\4\2\1\2\uffff"+
            "\1\1\3\uffff\6\1",
            "\2\4\12\uffff\1\4\1\uffff\1\4\1\1\6\uffff\1\1\1\4\1\10\2\uffff"+
            "\1\4\3\uffff\6\4",
            "\2\4\12\uffff\1\4\1\uffff\1\4\1\1\6\uffff\1\1\2\4\2\uffff"+
            "\1\4\3\uffff\6\4"
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
    static final String DFA26_eotS =
        "\21\uffff";
    static final String DFA26_eofS =
        "\21\uffff";
    static final String DFA26_minS =
        "\1\35\1\4\1\uffff\15\24\1\uffff";
    static final String DFA26_maxS =
        "\1\35\1\126\1\uffff\15\117\1\uffff";
    static final String DFA26_acceptS =
        "\2\uffff\1\2\15\uffff\1\1";
    static final String DFA26_specialS =
        "\21\uffff}>";
    static final String[] DFA26_transitionS = {
            "\1\1",
            "\1\3\1\4\2\2\10\uffff\1\12\1\uffff\1\15\5\uffff\1\2\2\uffff"+
            "\1\10\1\17\2\2\1\7\2\uffff\1\2\1\11\1\5\1\6\1\13\1\16\1\14\2"+
            "\2\16\uffff\16\2\4\uffff\4\2\2\uffff\1\2\3\uffff\2\2",
            "",
            "\1\2\4\uffff\2\2\2\uffff\1\2\2\uffff\1\20\2\2\6\uffff\1\2"+
            "\1\uffff\16\2\17\uffff\1\2\6\uffff\1\2",
            "\1\2\4\uffff\2\2\2\uffff\1\2\2\uffff\1\20\2\2\6\uffff\1\2"+
            "\1\uffff\16\2\17\uffff\1\2\6\uffff\1\2",
            "\1\2\4\uffff\2\2\2\uffff\1\2\2\uffff\1\20\2\2\6\uffff\1\2"+
            "\1\uffff\16\2\17\uffff\1\2\6\uffff\1\2",
            "\1\2\4\uffff\2\2\2\uffff\1\2\2\uffff\1\20\2\2\6\uffff\1\2"+
            "\1\uffff\16\2\17\uffff\1\2\6\uffff\1\2",
            "\1\2\4\uffff\2\2\2\uffff\1\2\2\uffff\1\20\2\2\6\uffff\1\2"+
            "\1\uffff\16\2\17\uffff\1\2\6\uffff\1\2",
            "\1\2\4\uffff\2\2\2\uffff\1\2\2\uffff\1\20\2\2\6\uffff\1\2"+
            "\1\uffff\16\2\17\uffff\1\2\6\uffff\1\2",
            "\1\2\4\uffff\2\2\2\uffff\1\2\2\uffff\1\20\2\2\6\uffff\1\2"+
            "\1\uffff\16\2\17\uffff\1\2\6\uffff\1\2",
            "\1\2\4\uffff\2\2\2\uffff\1\2\2\uffff\1\20\2\2\6\uffff\1\2"+
            "\1\uffff\16\2\17\uffff\1\2\6\uffff\1\2",
            "\1\2\4\uffff\2\2\2\uffff\1\2\2\uffff\1\20\2\2\6\uffff\1\2"+
            "\1\uffff\16\2\17\uffff\1\2\6\uffff\1\2",
            "\1\2\4\uffff\2\2\2\uffff\1\2\2\uffff\1\20\2\2\6\uffff\1\2"+
            "\1\uffff\16\2\17\uffff\1\2\6\uffff\1\2",
            "\1\2\4\uffff\2\2\2\uffff\1\2\2\uffff\1\20\2\2\6\uffff\1\2"+
            "\1\uffff\16\2\17\uffff\1\2\6\uffff\1\2",
            "\1\2\4\uffff\2\2\2\uffff\1\2\2\uffff\1\20\2\2\6\uffff\1\2"+
            "\1\uffff\16\2\17\uffff\1\2\6\uffff\1\2",
            "\1\2\4\uffff\2\2\2\uffff\1\2\2\uffff\1\20\2\2\6\uffff\1\2"+
            "\1\uffff\16\2\17\uffff\1\2\6\uffff\1\2",
            ""
    };

    static final short[] DFA26_eot = DFA.unpackEncodedString(DFA26_eotS);
    static final short[] DFA26_eof = DFA.unpackEncodedString(DFA26_eofS);
    static final char[] DFA26_min = DFA.unpackEncodedStringToUnsignedChars(DFA26_minS);
    static final char[] DFA26_max = DFA.unpackEncodedStringToUnsignedChars(DFA26_maxS);
    static final short[] DFA26_accept = DFA.unpackEncodedString(DFA26_acceptS);
    static final short[] DFA26_special = DFA.unpackEncodedString(DFA26_specialS);
    static final short[][] DFA26_transition;

    static {
        int numStates = DFA26_transitionS.length;
        DFA26_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA26_transition[i] = DFA.unpackEncodedString(DFA26_transitionS[i]);
        }
    }

    class DFA26 extends DFA {

        public DFA26(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 26;
            this.eot = DFA26_eot;
            this.eof = DFA26_eof;
            this.min = DFA26_min;
            this.max = DFA26_max;
            this.accept = DFA26_accept;
            this.special = DFA26_special;
            this.transition = DFA26_transition;
        }
        public String getDescription() {
            return "765:1: ( (otherlv_0= '(' ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) (otherlv_2= ',' ( (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS ) ) )* otherlv_4= '|' ( (lv_constraints_5_0= ruleAssignmentCS ) )* otherlv_6= ')' ) | ( () otherlv_8= '(' ( (lv_constraints_9_0= ruleAssignmentCS ) )* otherlv_10= ')' ) )";
        }
    }
    static final String DFA34_eotS =
        "\36\uffff";
    static final String DFA34_eofS =
        "\1\16\35\uffff";
    static final String DFA34_minS =
        "\1\4\15\24\1\uffff\16\24\1\uffff";
    static final String DFA34_maxS =
        "\1\106\15\41\1\uffff\16\41\1\uffff";
    static final String DFA34_acceptS =
        "\16\uffff\1\2\16\uffff\1\1";
    static final String DFA34_specialS =
        "\36\uffff}>";
    static final String[] DFA34_transitionS = {
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
            return "()* loopback of 1377:1: ( ( (lv_path_2_0= ruleNextPathElementCS ) ) otherlv_3= '::' )*";
        }
    }
    static final String DFA35_eotS =
        "\20\uffff";
    static final String DFA35_eofS =
        "\20\uffff";
    static final String DFA35_minS =
        "\1\4\15\24\2\uffff";
    static final String DFA35_maxS =
        "\1\106\15\41\2\uffff";
    static final String DFA35_acceptS =
        "\16\uffff\1\2\1\1";
    static final String DFA35_specialS =
        "\20\uffff}>";
    static final String[] DFA35_transitionS = {
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

    static final short[] DFA35_eot = DFA.unpackEncodedString(DFA35_eotS);
    static final short[] DFA35_eof = DFA.unpackEncodedString(DFA35_eofS);
    static final char[] DFA35_min = DFA.unpackEncodedStringToUnsignedChars(DFA35_minS);
    static final char[] DFA35_max = DFA.unpackEncodedStringToUnsignedChars(DFA35_maxS);
    static final short[] DFA35_accept = DFA.unpackEncodedString(DFA35_acceptS);
    static final short[] DFA35_special = DFA.unpackEncodedString(DFA35_specialS);
    static final short[][] DFA35_transition;

    static {
        int numStates = DFA35_transitionS.length;
        DFA35_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA35_transition[i] = DFA.unpackEncodedString(DFA35_transitionS[i]);
        }
    }

    class DFA35 extends DFA {

        public DFA35(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 35;
            this.eot = DFA35_eot;
            this.eof = DFA35_eof;
            this.min = DFA35_min;
            this.max = DFA35_max;
            this.accept = DFA35_accept;
            this.special = DFA35_special;
            this.transition = DFA35_transition;
        }
        public String getDescription() {
            return "1424:1: ( (lv_pathName_1_0= ruleScopeNameCS ) )?";
        }
    }
    static final String DFA74_eotS =
        "\6\uffff";
    static final String DFA74_eofS =
        "\6\uffff";
    static final String DFA74_minS =
        "\3\4\3\uffff";
    static final String DFA74_maxS =
        "\3\126\3\uffff";
    static final String DFA74_acceptS =
        "\3\uffff\1\1\1\3\1\2";
    static final String DFA74_specialS =
        "\6\uffff}>";
    static final String[] DFA74_transitionS = {
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
            return "4372:1: ( (this_PrefixedExpCS_0= rulePrefixedExpCS ( () ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? ) | ( (lv_ownedExpression_8_0= ruleLetExpCS ) ) ) )? ) | ( () ( (lv_ownedOperator_10_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_11_0= ruleLetExpCS ) ) ) | this_LetExpCS_12= ruleLetExpCS )";
        }
    }
    static final String DFA69_eotS =
        "\23\uffff";
    static final String DFA69_eofS =
        "\1\21\22\uffff";
    static final String DFA69_minS =
        "\1\21\20\4\2\uffff";
    static final String DFA69_maxS =
        "\1\124\20\126\2\uffff";
    static final String DFA69_acceptS =
        "\21\uffff\1\2\1\1";
    static final String DFA69_specialS =
        "\23\uffff}>";
    static final String[] DFA69_transitionS = {
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
            return "()* loopback of 4429:2: ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )*";
        }
    }
    static final String DFA92_eotS =
        "\50\uffff";
    static final String DFA92_eofS =
        "\50\uffff";
    static final String DFA92_minS =
        "\1\4\12\uffff\6\0\27\uffff";
    static final String DFA92_maxS =
        "\1\126\12\uffff\6\0\27\uffff";
    static final String DFA92_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\14\uffff\1\7\7\uffff\1\10\14\uffff\1\5"+
        "\1\6";
    static final String DFA92_specialS =
        "\13\uffff\1\0\1\1\1\2\1\3\1\4\1\5\27\uffff}>";
    static final String[] DFA92_transitionS = {
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

    static final short[] DFA92_eot = DFA.unpackEncodedString(DFA92_eotS);
    static final short[] DFA92_eof = DFA.unpackEncodedString(DFA92_eofS);
    static final char[] DFA92_min = DFA.unpackEncodedStringToUnsignedChars(DFA92_minS);
    static final char[] DFA92_max = DFA.unpackEncodedStringToUnsignedChars(DFA92_maxS);
    static final short[] DFA92_accept = DFA.unpackEncodedString(DFA92_acceptS);
    static final short[] DFA92_special = DFA.unpackEncodedString(DFA92_specialS);
    static final short[][] DFA92_transition;

    static {
        int numStates = DFA92_transitionS.length;
        DFA92_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA92_transition[i] = DFA.unpackEncodedString(DFA92_transitionS[i]);
        }
    }

    class DFA92 extends DFA {

        public DFA92(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 92;
            this.eot = DFA92_eot;
            this.eof = DFA92_eof;
            this.min = DFA92_min;
            this.max = DFA92_max;
            this.accept = DFA92_accept;
            this.special = DFA92_special;
            this.transition = DFA92_transition;
        }
        public String getDescription() {
            return "4679:1: (this_NestedExpCS_0= ruleNestedExpCS | this_IfExpCS_1= ruleIfExpCS | this_SelfExpCS_2= ruleSelfExpCS | this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS | this_CollectionLiteralExpCS_5= ruleCollectionLiteralExpCS | this_TypeLiteralExpCS_6= ruleTypeLiteralExpCS | ( () ( (lv_pathName_8_0= rulePathNameCS ) ) ( ( () otherlv_10= '[' ( (lv_firstIndexes_11_0= ruleExpCS ) ) (otherlv_12= ',' ( (lv_firstIndexes_13_0= ruleExpCS ) ) )* otherlv_14= ']' (otherlv_15= '[' ( (lv_secondIndexes_16_0= ruleExpCS ) ) (otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) ) )* otherlv_19= ']' )? ( ( (lv_atPre_20_0= '@' ) ) otherlv_21= 'pre' )? ) | ( () otherlv_23= '{' ( ( ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )* ) | ( (lv_value_27_0= ruleStringLiteral ) ) ) otherlv_28= '}' ) | ( ( ( (lv_atPre_29_0= '@' ) ) otherlv_30= 'pre' )? ( () otherlv_32= '(' ( ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_39= ')' )? ) ) ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA92_11 = input.LA(1);

                         
                        int index92_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred124_InternalQVTcore()) ) {s = 38;}

                        else if ( (synpred126_InternalQVTcore()) ) {s = 17;}

                         
                        input.seek(index92_11);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA92_12 = input.LA(1);

                         
                        int index92_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred125_InternalQVTcore()) ) {s = 39;}

                        else if ( (synpred126_InternalQVTcore()) ) {s = 17;}

                         
                        input.seek(index92_12);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA92_13 = input.LA(1);

                         
                        int index92_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred125_InternalQVTcore()) ) {s = 39;}

                        else if ( (synpred126_InternalQVTcore()) ) {s = 17;}

                         
                        input.seek(index92_13);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA92_14 = input.LA(1);

                         
                        int index92_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred125_InternalQVTcore()) ) {s = 39;}

                        else if ( (synpred126_InternalQVTcore()) ) {s = 17;}

                         
                        input.seek(index92_14);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA92_15 = input.LA(1);

                         
                        int index92_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred125_InternalQVTcore()) ) {s = 39;}

                        else if ( (synpred126_InternalQVTcore()) ) {s = 17;}

                         
                        input.seek(index92_15);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA92_16 = input.LA(1);

                         
                        int index92_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred125_InternalQVTcore()) ) {s = 39;}

                        else if ( (synpred126_InternalQVTcore()) ) {s = 17;}

                         
                        input.seek(index92_16);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 92, _s, input);
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
        public static final BitSet FOLLOW_29_in_ruleGuardPatternCS1433 = new BitSet(new long[]{0x000001F898050030L});
        public static final BitSet FOLLOW_ruleUnrealizedVariableCS_in_ruleGuardPatternCS1454 = new BitSet(new long[]{0x0000000000880000L});
        public static final BitSet FOLLOW_19_in_ruleGuardPatternCS1467 = new BitSet(new long[]{0x000001F898050030L});
        public static final BitSet FOLLOW_ruleUnrealizedVariableCS_in_ruleGuardPatternCS1488 = new BitSet(new long[]{0x0000000000880000L});
        public static final BitSet FOLLOW_23_in_ruleGuardPatternCS1502 = new BitSet(new long[]{0xFE0007FCF90500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleAssignmentCS_in_ruleGuardPatternCS1523 = new BitSet(new long[]{0xFE0007FCF90500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_30_in_ruleGuardPatternCS1536 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_ruleGuardPatternCS1568 = new BitSet(new long[]{0xFE0007FCF90500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleAssignmentCS_in_ruleGuardPatternCS1589 = new BitSet(new long[]{0xFE0007FCF90500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_30_in_ruleGuardPatternCS1602 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleImportCS_in_entryRuleImportCS1639 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleImportCS1649 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_ruleImportCS1686 = new BitSet(new long[]{0x000001F8980500B0L});
        public static final BitSet FOLLOW_ruleIdentifier_in_ruleImportCS1708 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_32_in_ruleImportCS1720 = new BitSet(new long[]{0x000001F8980500B0L});
        public static final BitSet FOLLOW_ruleURIPathNameCS_in_ruleImportCS1743 = new BitSet(new long[]{0x0000000204000000L});
        public static final BitSet FOLLOW_33_in_ruleImportCS1762 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_34_in_ruleImportCS1787 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_ruleImportCS1801 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibraryCS_in_entryRuleLibraryCS1837 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibraryCS1847 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_ruleLibraryCS1884 = new BitSet(new long[]{0x000001F8980500B0L});
        public static final BitSet FOLLOW_ruleURI_in_ruleLibraryCS1911 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_ruleLibraryCS1923 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNamedDomainCS_in_entryRuleNamedDomainCS1959 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNamedDomainCS1969 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_ruleNamedDomainCS2012 = new BitSet(new long[]{0x000001F898050030L});
        public static final BitSet FOLLOW_37_in_ruleNamedDomainCS2044 = new BitSet(new long[]{0x000001F898050030L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleNamedDomainCS2085 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_ruleGuardPatternCS_in_ruleNamedDomainCS2106 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_ruleBottomPatternCS_in_ruleNamedDomainCS2127 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParamDeclarationCS_in_entryRuleParamDeclarationCS2163 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParamDeclarationCS2173 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleParamDeclarationCS2219 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_32_in_ruleParamDeclarationCS2231 = new BitSet(new long[]{0xFE0007FCB80500F0L,0x000000000042787FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleParamDeclarationCS2252 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQueryCS_in_entryRuleQueryCS2288 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleQueryCS2298 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_ruleQueryCS2335 = new BitSet(new long[]{0xFE0007FCB80500F0L,0x000000000042787FL});
        public static final BitSet FOLLOW_ruleScopeNameCS_in_ruleQueryCS2356 = new BitSet(new long[]{0x000001F898050030L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleQueryCS2377 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_29_in_ruleQueryCS2389 = new BitSet(new long[]{0x000001F8D8050030L});
        public static final BitSet FOLLOW_ruleParamDeclarationCS_in_ruleQueryCS2411 = new BitSet(new long[]{0x0000000040080000L});
        public static final BitSet FOLLOW_19_in_ruleQueryCS2424 = new BitSet(new long[]{0x000001F898050030L});
        public static final BitSet FOLLOW_ruleParamDeclarationCS_in_ruleQueryCS2445 = new BitSet(new long[]{0x0000000040080000L});
        public static final BitSet FOLLOW_30_in_ruleQueryCS2461 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_32_in_ruleQueryCS2473 = new BitSet(new long[]{0xFE0007FCB80500F0L,0x000000000042787FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleQueryCS2494 = new BitSet(new long[]{0x0000000004100000L});
        public static final BitSet FOLLOW_26_in_ruleQueryCS2507 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleQueryCS2526 = new BitSet(new long[]{0xFE0007FCB90500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleQueryCS2547 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_22_in_ruleQueryCS2559 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScopeNameCS_in_entryRuleScopeNameCS2597 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleScopeNameCS2607 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFirstPathElementCS_in_ruleScopeNameCS2653 = new BitSet(new long[]{0x0000000200000000L});
        public static final BitSet FOLLOW_33_in_ruleScopeNameCS2665 = new BitSet(new long[]{0xFE0001F898050032L,0x000000000000007FL});
        public static final BitSet FOLLOW_ruleNextPathElementCS_in_ruleScopeNameCS2687 = new BitSet(new long[]{0x0000000200000000L});
        public static final BitSet FOLLOW_33_in_ruleScopeNameCS2699 = new BitSet(new long[]{0xFE0001F898050032L,0x000000000000007FL});
        public static final BitSet FOLLOW_ruleTransformationCS_in_entryRuleTransformationCS2737 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTransformationCS2747 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_39_in_ruleTransformationCS2784 = new BitSet(new long[]{0xFE0007FCB80500F0L,0x000000000042787FL});
        public static final BitSet FOLLOW_ruleScopeNameCS_in_ruleTransformationCS2805 = new BitSet(new long[]{0xFE0001F898050030L,0x000000000000007FL});
        public static final BitSet FOLLOW_ruleUnreservedName_in_ruleTransformationCS2827 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleTransformationCS2839 = new BitSet(new long[]{0x000001F89C450030L});
        public static final BitSet FOLLOW_ruleDirectionCS_in_ruleTransformationCS2861 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_ruleTransformationCS2873 = new BitSet(new long[]{0x000001F89C450030L});
        public static final BitSet FOLLOW_22_in_ruleTransformationCS2887 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrealizedVariableCS_in_entryRuleUnrealizedVariableCS2923 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnrealizedVariableCS2933 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleUnrealizedVariableCS2979 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_32_in_ruleUnrealizedVariableCS2991 = new BitSet(new long[]{0xFE0007FCB80500F0L,0x000000000042787FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleUnrealizedVariableCS3012 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRealizedVariableCS_in_entryRuleRealizedVariableCS3048 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRealizedVariableCS3058 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_40_in_ruleRealizedVariableCS3095 = new BitSet(new long[]{0x000001F898050030L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleRealizedVariableCS3116 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_32_in_ruleRealizedVariableCS3128 = new BitSet(new long[]{0xFE0007FCB80500F0L,0x000000000042787FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleRealizedVariableCS3149 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnnamedDomainCS_in_entryRuleUnnamedDomainCS3185 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnnamedDomainCS3195 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGuardPatternCS_in_ruleUnnamedDomainCS3253 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_ruleBottomPatternCS_in_ruleUnnamedDomainCS3274 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_entryRuleUnrestrictedName3311 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnrestrictedName3322 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLUnrestrictedName_in_ruleUnrestrictedName3369 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_ruleUnrestrictedName3393 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_ruleUnrestrictedName3412 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_ruleUnrestrictedName3431 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_ruleUnrestrictedName3450 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_ruleUnrestrictedName3469 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleUnrestrictedName3488 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_ruleUnrestrictedName3507 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_40_in_ruleUnrestrictedName3526 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleUnrestrictedName3545 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_39_in_ruleUnrestrictedName3564 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_ruleUnrestrictedName3583 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleID_in_entryRuleID3626 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleID3637 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_SIMPLE_ID_in_ruleID3677 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ESCAPED_ID_in_ruleID3703 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLOWER_in_entryRuleLOWER3749 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLOWER3760 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleLOWER3799 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUPPER_in_entryRuleUPPER3844 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUPPER3855 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleUPPER3895 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_ruleUPPER3919 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNUMBER_LITERAL_in_entryRuleNUMBER_LITERAL3960 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNUMBER_LITERAL3971 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleNUMBER_LITERAL4010 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleURI_in_entryRuleURI4055 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleURI4066 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_SINGLE_QUOTED_STRING_in_ruleURI4105 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLUnaryOperatorCS_in_entryRuleEssentialOCLUnaryOperatorCS4151 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEssentialOCLUnaryOperatorCS4161 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_41_in_ruleEssentialOCLUnaryOperatorCS4205 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_42_in_ruleEssentialOCLUnaryOperatorCS4234 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLInfixOperatorCS_in_entryRuleEssentialOCLInfixOperatorCS4285 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEssentialOCLInfixOperatorCS4295 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_ruleEssentialOCLInfixOperatorCS4339 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_43_in_ruleEssentialOCLInfixOperatorCS4368 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_44_in_ruleEssentialOCLInfixOperatorCS4397 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_41_in_ruleEssentialOCLInfixOperatorCS4426 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_45_in_ruleEssentialOCLInfixOperatorCS4455 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_46_in_ruleEssentialOCLInfixOperatorCS4484 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_47_in_ruleEssentialOCLInfixOperatorCS4513 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_48_in_ruleEssentialOCLInfixOperatorCS4542 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_49_in_ruleEssentialOCLInfixOperatorCS4571 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_50_in_ruleEssentialOCLInfixOperatorCS4600 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_51_in_ruleEssentialOCLInfixOperatorCS4629 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_52_in_ruleEssentialOCLInfixOperatorCS4658 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_53_in_ruleEssentialOCLInfixOperatorCS4687 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_54_in_ruleEssentialOCLInfixOperatorCS4716 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLNavigationOperatorCS_in_entryRuleEssentialOCLNavigationOperatorCS4767 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEssentialOCLNavigationOperatorCS4777 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_55_in_ruleEssentialOCLNavigationOperatorCS4821 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_56_in_ruleEssentialOCLNavigationOperatorCS4850 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_entryRuleIdentifier4902 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIdentifier4913 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleID_in_ruleIdentifier4959 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral5004 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteral5015 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_SINGLE_QUOTED_STRING_in_ruleStringLiteral5054 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBinaryOperatorCS_in_entryRuleBinaryOperatorCS5098 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBinaryOperatorCS5108 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInfixOperatorCS_in_ruleBinaryOperatorCS5158 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigationOperatorCS_in_ruleBinaryOperatorCS5188 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInfixOperatorCS_in_entryRuleInfixOperatorCS5223 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleInfixOperatorCS5233 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLInfixOperatorCS_in_ruleInfixOperatorCS5282 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigationOperatorCS_in_entryRuleNavigationOperatorCS5316 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigationOperatorCS5326 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLNavigationOperatorCS_in_ruleNavigationOperatorCS5375 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnaryOperatorCS_in_entryRuleUnaryOperatorCS5409 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnaryOperatorCS5419 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLUnaryOperatorCS_in_ruleUnaryOperatorCS5468 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLUnrestrictedName_in_entryRuleEssentialOCLUnrestrictedName5503 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEssentialOCLUnrestrictedName5514 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_ruleEssentialOCLUnrestrictedName5560 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLUnreservedName_in_entryRuleEssentialOCLUnreservedName5605 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEssentialOCLUnreservedName5616 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleEssentialOCLUnreservedName5663 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionTypeIdentifier_in_ruleEssentialOCLUnreservedName5696 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveTypeIdentifier_in_ruleEssentialOCLUnreservedName5729 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_57_in_ruleEssentialOCLUnreservedName5753 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnreservedName_in_entryRuleUnreservedName5794 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnreservedName5805 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLUnreservedName_in_ruleUnreservedName5851 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePathNameCS_in_entryRulePathNameCS5895 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePathNameCS5905 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFirstPathElementCS_in_rulePathNameCS5951 = new BitSet(new long[]{0x0000000200000002L});
        public static final BitSet FOLLOW_33_in_rulePathNameCS5964 = new BitSet(new long[]{0xFE0001F898050030L,0x000000000000007FL});
        public static final BitSet FOLLOW_ruleNextPathElementCS_in_rulePathNameCS5985 = new BitSet(new long[]{0x0000000200000002L});
        public static final BitSet FOLLOW_ruleFirstPathElementCS_in_entryRuleFirstPathElementCS6023 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFirstPathElementCS6033 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleFirstPathElementCS6084 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNextPathElementCS_in_entryRuleNextPathElementCS6119 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNextPathElementCS6129 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnreservedName_in_ruleNextPathElementCS6180 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleURIPathNameCS_in_entryRuleURIPathNameCS6215 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleURIPathNameCS6225 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleURIFirstPathElementCS_in_ruleURIPathNameCS6271 = new BitSet(new long[]{0x0000000200000002L});
        public static final BitSet FOLLOW_33_in_ruleURIPathNameCS6284 = new BitSet(new long[]{0xFE0001F898050030L,0x000000000000007FL});
        public static final BitSet FOLLOW_ruleNextPathElementCS_in_ruleURIPathNameCS6305 = new BitSet(new long[]{0x0000000200000002L});
        public static final BitSet FOLLOW_ruleURIFirstPathElementCS_in_entryRuleURIFirstPathElementCS6343 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleURIFirstPathElementCS6353 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleURIFirstPathElementCS6405 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleURI_in_ruleURIFirstPathElementCS6451 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveTypeIdentifier_in_entryRulePrimitiveTypeIdentifier6489 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrimitiveTypeIdentifier6500 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_58_in_rulePrimitiveTypeIdentifier6538 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_59_in_rulePrimitiveTypeIdentifier6557 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_60_in_rulePrimitiveTypeIdentifier6576 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_61_in_rulePrimitiveTypeIdentifier6595 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_62_in_rulePrimitiveTypeIdentifier6614 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_63_in_rulePrimitiveTypeIdentifier6633 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_64_in_rulePrimitiveTypeIdentifier6652 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_65_in_rulePrimitiveTypeIdentifier6671 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveTypeCS_in_entryRulePrimitiveTypeCS6711 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrimitiveTypeCS6721 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveTypeIdentifier_in_rulePrimitiveTypeCS6766 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionTypeIdentifier_in_entryRuleCollectionTypeIdentifier6802 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCollectionTypeIdentifier6813 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_66_in_ruleCollectionTypeIdentifier6851 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_67_in_ruleCollectionTypeIdentifier6870 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_68_in_ruleCollectionTypeIdentifier6889 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_69_in_ruleCollectionTypeIdentifier6908 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_70_in_ruleCollectionTypeIdentifier6927 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionTypeCS_in_entryRuleCollectionTypeCS6967 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCollectionTypeCS6977 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionTypeIdentifier_in_ruleCollectionTypeCS7023 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_29_in_ruleCollectionTypeCS7036 = new BitSet(new long[]{0xFE0007FCB80500F0L,0x000000000042787FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleCollectionTypeCS7057 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_30_in_ruleCollectionTypeCS7069 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiplicityBoundsCS_in_entryRuleMultiplicityBoundsCS7107 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicityBoundsCS7117 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLOWER_in_ruleMultiplicityBoundsCS7163 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
        public static final BitSet FOLLOW_71_in_ruleMultiplicityBoundsCS7176 = new BitSet(new long[]{0x0000000400000040L});
        public static final BitSet FOLLOW_ruleUPPER_in_ruleMultiplicityBoundsCS7197 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiplicityCS_in_entryRuleMultiplicityCS7235 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicityCS7245 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_72_in_ruleMultiplicityCS7282 = new BitSet(new long[]{0x0000100400000040L,0x0000000000000400L});
        public static final BitSet FOLLOW_ruleMultiplicityBoundsCS_in_ruleMultiplicityCS7308 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
        public static final BitSet FOLLOW_ruleMultiplicityStringCS_in_ruleMultiplicityCS7338 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
        public static final BitSet FOLLOW_73_in_ruleMultiplicityCS7350 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiplicityStringCS_in_entryRuleMultiplicityStringCS7386 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicityStringCS7396 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_ruleMultiplicityStringCS7440 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_44_in_ruleMultiplicityStringCS7469 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_74_in_ruleMultiplicityStringCS7498 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTupleTypeCS_in_entryRuleTupleTypeCS7549 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTupleTypeCS7559 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_57_in_ruleTupleTypeCS7602 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_29_in_ruleTupleTypeCS7628 = new BitSet(new long[]{0x000001F8D8050030L});
        public static final BitSet FOLLOW_ruleTuplePartCS_in_ruleTupleTypeCS7650 = new BitSet(new long[]{0x0000000040080000L});
        public static final BitSet FOLLOW_19_in_ruleTupleTypeCS7663 = new BitSet(new long[]{0x000001F898050030L});
        public static final BitSet FOLLOW_ruleTuplePartCS_in_ruleTupleTypeCS7684 = new BitSet(new long[]{0x0000000040080000L});
        public static final BitSet FOLLOW_30_in_ruleTupleTypeCS7700 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTuplePartCS_in_entryRuleTuplePartCS7738 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTuplePartCS7748 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleTuplePartCS7794 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_32_in_ruleTuplePartCS7806 = new BitSet(new long[]{0xFE0007FCB80500F0L,0x000000000042787FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleTuplePartCS7827 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionLiteralExpCS_in_entryRuleCollectionLiteralExpCS7863 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCollectionLiteralExpCS7873 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionTypeCS_in_ruleCollectionLiteralExpCS7919 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleCollectionLiteralExpCS7931 = new BitSet(new long[]{0xFE0007FCB94500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleCollectionLiteralPartCS_in_ruleCollectionLiteralExpCS7953 = new BitSet(new long[]{0x0000000000480000L});
        public static final BitSet FOLLOW_19_in_ruleCollectionLiteralExpCS7966 = new BitSet(new long[]{0xFE0007FCB90500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleCollectionLiteralPartCS_in_ruleCollectionLiteralExpCS7987 = new BitSet(new long[]{0x0000000000480000L});
        public static final BitSet FOLLOW_22_in_ruleCollectionLiteralExpCS8003 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionLiteralPartCS_in_entryRuleCollectionLiteralPartCS8039 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCollectionLiteralPartCS8049 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleCollectionLiteralPartCS8095 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
        public static final BitSet FOLLOW_71_in_ruleCollectionLiteralPartCS8108 = new BitSet(new long[]{0xFE0007FCB90500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleCollectionLiteralPartCS8129 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConstructorPartCS_in_entryRuleConstructorPartCS8167 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleConstructorPartCS8177 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleConstructorPartCS8229 = new BitSet(new long[]{0x0002000000000000L});
        public static final BitSet FOLLOW_49_in_ruleConstructorPartCS8241 = new BitSet(new long[]{0xFE0007FCB90500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleConstructorPartCS8262 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveLiteralExpCS_in_entryRulePrimitiveLiteralExpCS8298 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrimitiveLiteralExpCS8308 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNumberLiteralExpCS_in_rulePrimitiveLiteralExpCS8358 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringLiteralExpCS_in_rulePrimitiveLiteralExpCS8388 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBooleanLiteralExpCS_in_rulePrimitiveLiteralExpCS8418 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnlimitedNaturalLiteralExpCS_in_rulePrimitiveLiteralExpCS8448 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInvalidLiteralExpCS_in_rulePrimitiveLiteralExpCS8478 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNullLiteralExpCS_in_rulePrimitiveLiteralExpCS8508 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTupleLiteralExpCS_in_entryRuleTupleLiteralExpCS8543 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTupleLiteralExpCS8553 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_57_in_ruleTupleLiteralExpCS8590 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleTupleLiteralExpCS8602 = new BitSet(new long[]{0x000001F898050030L});
        public static final BitSet FOLLOW_ruleTupleLiteralPartCS_in_ruleTupleLiteralExpCS8623 = new BitSet(new long[]{0x0000000000480000L});
        public static final BitSet FOLLOW_19_in_ruleTupleLiteralExpCS8636 = new BitSet(new long[]{0x000001F898050030L});
        public static final BitSet FOLLOW_ruleTupleLiteralPartCS_in_ruleTupleLiteralExpCS8657 = new BitSet(new long[]{0x0000000000480000L});
        public static final BitSet FOLLOW_22_in_ruleTupleLiteralExpCS8671 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTupleLiteralPartCS_in_entryRuleTupleLiteralPartCS8707 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTupleLiteralPartCS8717 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleTupleLiteralPartCS8763 = new BitSet(new long[]{0x0002000100000000L});
        public static final BitSet FOLLOW_32_in_ruleTupleLiteralPartCS8776 = new BitSet(new long[]{0xFE0007FCB80500F0L,0x000000000042787FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleTupleLiteralPartCS8797 = new BitSet(new long[]{0x0002000000000000L});
        public static final BitSet FOLLOW_49_in_ruleTupleLiteralPartCS8811 = new BitSet(new long[]{0xFE0007FCB90500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleTupleLiteralPartCS8832 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNumberLiteralExpCS_in_entryRuleNumberLiteralExpCS8868 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNumberLiteralExpCS8878 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNUMBER_LITERAL_in_ruleNumberLiteralExpCS8923 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringLiteralExpCS_in_entryRuleStringLiteralExpCS8958 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteralExpCS8968 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringLiteral_in_ruleStringLiteralExpCS9013 = new BitSet(new long[]{0x0000000000000082L});
        public static final BitSet FOLLOW_ruleBooleanLiteralExpCS_in_entryRuleBooleanLiteralExpCS9049 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBooleanLiteralExpCS9059 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_75_in_ruleBooleanLiteralExpCS9102 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_76_in_ruleBooleanLiteralExpCS9139 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnlimitedNaturalLiteralExpCS_in_entryRuleUnlimitedNaturalLiteralExpCS9188 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnlimitedNaturalLiteralExpCS9198 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_ruleUnlimitedNaturalLiteralExpCS9247 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInvalidLiteralExpCS_in_entryRuleInvalidLiteralExpCS9283 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleInvalidLiteralExpCS9293 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_77_in_ruleInvalidLiteralExpCS9342 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNullLiteralExpCS_in_entryRuleNullLiteralExpCS9378 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNullLiteralExpCS9388 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_78_in_ruleNullLiteralExpCS9437 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralCS_in_entryRuleTypeLiteralCS9473 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeLiteralCS9483 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveTypeCS_in_ruleTypeLiteralCS9533 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionTypeCS_in_ruleTypeLiteralCS9563 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTupleTypeCS_in_ruleTypeLiteralCS9593 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralWithMultiplicityCS_in_entryRuleTypeLiteralWithMultiplicityCS9628 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeLiteralWithMultiplicityCS9638 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralCS_in_ruleTypeLiteralWithMultiplicityCS9688 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000100L});
        public static final BitSet FOLLOW_ruleMultiplicityCS_in_ruleTypeLiteralWithMultiplicityCS9708 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralExpCS_in_entryRuleTypeLiteralExpCS9745 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeLiteralExpCS9755 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralWithMultiplicityCS_in_ruleTypeLiteralExpCS9800 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeNameExpCS_in_entryRuleTypeNameExpCS9835 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeNameExpCS9845 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePathNameCS_in_ruleTypeNameExpCS9890 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_entryRuleTypeExpCS9925 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeExpCS9935 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeNameExpCS_in_ruleTypeExpCS9986 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000100L});
        public static final BitSet FOLLOW_ruleTypeLiteralCS_in_ruleTypeExpCS10016 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000100L});
        public static final BitSet FOLLOW_ruleMultiplicityCS_in_ruleTypeExpCS10037 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpCS_in_entryRuleExpCS10074 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleExpCS10084 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrefixedExpCS_in_ruleExpCS10135 = new BitSet(new long[]{0x01FFFA0400000002L});
        public static final BitSet FOLLOW_ruleBinaryOperatorCS_in_ruleExpCS10168 = new BitSet(new long[]{0xFE0007FCB90500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_rulePrefixedExpCS_in_ruleExpCS10191 = new BitSet(new long[]{0x01FFFA0400000002L});
        public static final BitSet FOLLOW_ruleBinaryOperatorCS_in_ruleExpCS10213 = new BitSet(new long[]{0xFE0007FCB80500F0L,0x000000000042787FL});
        public static final BitSet FOLLOW_rulePrefixedExpCS_in_ruleExpCS10234 = new BitSet(new long[]{0x01FFFA0400000002L});
        public static final BitSet FOLLOW_ruleBinaryOperatorCS_in_ruleExpCS10258 = new BitSet(new long[]{0xFE0007FCB90500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleLetExpCS_in_ruleExpCS10279 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLetExpCS_in_ruleExpCS10309 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnaryOperatorCS_in_ruleExpCS10353 = new BitSet(new long[]{0xFE0007FCB90500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleLetExpCS_in_ruleExpCS10375 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLetExpCS_in_ruleExpCS10407 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrefixedExpCS_in_entryRulePrefixedExpCS10442 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrefixedExpCS10452 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnaryOperatorCS_in_rulePrefixedExpCS10511 = new BitSet(new long[]{0xFE0007FCB80500F0L,0x000000000042787FL});
        public static final BitSet FOLLOW_rulePrimaryExpCS_in_rulePrefixedExpCS10533 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimaryExpCS_in_rulePrefixedExpCS10565 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimaryExpCS_in_entryRulePrimaryExpCS10600 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpCS10610 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedExpCS_in_rulePrimaryExpCS10660 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIfExpCS_in_rulePrimaryExpCS10690 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSelfExpCS_in_rulePrimaryExpCS10720 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveLiteralExpCS_in_rulePrimaryExpCS10750 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTupleLiteralExpCS_in_rulePrimaryExpCS10780 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionLiteralExpCS_in_rulePrimaryExpCS10810 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralExpCS_in_rulePrimaryExpCS10840 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePathNameCS_in_rulePrimaryExpCS10879 = new BitSet(new long[]{0x0000000020100002L,0x0000000000008100L});
        public static final BitSet FOLLOW_72_in_rulePrimaryExpCS10905 = new BitSet(new long[]{0xFE0007FCB90500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleExpCS_in_rulePrimaryExpCS10926 = new BitSet(new long[]{0x0000000000080000L,0x0000000000000200L});
        public static final BitSet FOLLOW_19_in_rulePrimaryExpCS10939 = new BitSet(new long[]{0xFE0007FCB90500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleExpCS_in_rulePrimaryExpCS10960 = new BitSet(new long[]{0x0000000000080000L,0x0000000000000200L});
        public static final BitSet FOLLOW_73_in_rulePrimaryExpCS10974 = new BitSet(new long[]{0x0000000000000002L,0x0000000000008100L});
        public static final BitSet FOLLOW_72_in_rulePrimaryExpCS10987 = new BitSet(new long[]{0xFE0007FCB90500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleExpCS_in_rulePrimaryExpCS11008 = new BitSet(new long[]{0x0000000000080000L,0x0000000000000200L});
        public static final BitSet FOLLOW_19_in_rulePrimaryExpCS11021 = new BitSet(new long[]{0xFE0007FCB90500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleExpCS_in_rulePrimaryExpCS11042 = new BitSet(new long[]{0x0000000000080000L,0x0000000000000200L});
        public static final BitSet FOLLOW_73_in_rulePrimaryExpCS11056 = new BitSet(new long[]{0x0000000000000002L,0x0000000000008000L});
        public static final BitSet FOLLOW_79_in_rulePrimaryExpCS11077 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
        public static final BitSet FOLLOW_80_in_rulePrimaryExpCS11102 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rulePrimaryExpCS11136 = new BitSet(new long[]{0x000001F8980500B0L});
        public static final BitSet FOLLOW_ruleConstructorPartCS_in_rulePrimaryExpCS11159 = new BitSet(new long[]{0x0000000000480000L});
        public static final BitSet FOLLOW_19_in_rulePrimaryExpCS11172 = new BitSet(new long[]{0x000001F898050030L});
        public static final BitSet FOLLOW_ruleConstructorPartCS_in_rulePrimaryExpCS11193 = new BitSet(new long[]{0x0000000000480000L});
        public static final BitSet FOLLOW_ruleStringLiteral_in_rulePrimaryExpCS11223 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_22_in_rulePrimaryExpCS11236 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_79_in_rulePrimaryExpCS11263 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
        public static final BitSet FOLLOW_80_in_rulePrimaryExpCS11288 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_29_in_rulePrimaryExpCS11315 = new BitSet(new long[]{0xFE0007FCF90500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleNavigatingArgCS_in_rulePrimaryExpCS11337 = new BitSet(new long[]{0x0000000044880000L});
        public static final BitSet FOLLOW_ruleNavigatingCommaArgCS_in_rulePrimaryExpCS11358 = new BitSet(new long[]{0x0000000044880000L});
        public static final BitSet FOLLOW_ruleNavigatingSemiArgCS_in_rulePrimaryExpCS11381 = new BitSet(new long[]{0x0000000040880000L});
        public static final BitSet FOLLOW_ruleNavigatingCommaArgCS_in_rulePrimaryExpCS11402 = new BitSet(new long[]{0x0000000040880000L});
        public static final BitSet FOLLOW_ruleNavigatingBarArgCS_in_rulePrimaryExpCS11427 = new BitSet(new long[]{0x0000000040080000L});
        public static final BitSet FOLLOW_ruleNavigatingCommaArgCS_in_rulePrimaryExpCS11448 = new BitSet(new long[]{0x0000000040080000L});
        public static final BitSet FOLLOW_30_in_rulePrimaryExpCS11465 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingArgCS_in_entryRuleNavigatingArgCS11506 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigatingArgCS11516 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingArgCS11562 = new BitSet(new long[]{0x0000000100000002L});
        public static final BitSet FOLLOW_32_in_ruleNavigatingArgCS11575 = new BitSet(new long[]{0xFE0007FCB80500F0L,0x000000000042787FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleNavigatingArgCS11596 = new BitSet(new long[]{0x0002000000000002L});
        public static final BitSet FOLLOW_49_in_ruleNavigatingArgCS11609 = new BitSet(new long[]{0xFE0007FCB90500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNavigatingArgCS11630 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingBarArgCS_in_entryRuleNavigatingBarArgCS11670 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigatingBarArgCS11680 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_ruleNavigatingBarArgCS11723 = new BitSet(new long[]{0xFE0007FCB90500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingBarArgCS11757 = new BitSet(new long[]{0x0000000100000002L});
        public static final BitSet FOLLOW_32_in_ruleNavigatingBarArgCS11770 = new BitSet(new long[]{0xFE0007FCB80500F0L,0x000000000042787FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleNavigatingBarArgCS11791 = new BitSet(new long[]{0x0002000000000002L});
        public static final BitSet FOLLOW_49_in_ruleNavigatingBarArgCS11804 = new BitSet(new long[]{0xFE0007FCB90500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNavigatingBarArgCS11825 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingCommaArgCS_in_entryRuleNavigatingCommaArgCS11865 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigatingCommaArgCS11875 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleNavigatingCommaArgCS11918 = new BitSet(new long[]{0xFE0007FCB90500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingCommaArgCS11952 = new BitSet(new long[]{0x0000000100000002L});
        public static final BitSet FOLLOW_32_in_ruleNavigatingCommaArgCS11965 = new BitSet(new long[]{0xFE0007FCB80500F0L,0x000000000042787FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleNavigatingCommaArgCS11986 = new BitSet(new long[]{0x0002000000000002L});
        public static final BitSet FOLLOW_49_in_ruleNavigatingCommaArgCS11999 = new BitSet(new long[]{0xFE0007FCB90500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNavigatingCommaArgCS12020 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingSemiArgCS_in_entryRuleNavigatingSemiArgCS12060 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigatingSemiArgCS12070 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_ruleNavigatingSemiArgCS12113 = new BitSet(new long[]{0xFE0007FCB90500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingSemiArgCS12147 = new BitSet(new long[]{0x0000000100000002L});
        public static final BitSet FOLLOW_32_in_ruleNavigatingSemiArgCS12160 = new BitSet(new long[]{0xFE0007FCB80500F0L,0x000000000042787FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleNavigatingSemiArgCS12181 = new BitSet(new long[]{0x0002000000000002L});
        public static final BitSet FOLLOW_49_in_ruleNavigatingSemiArgCS12194 = new BitSet(new long[]{0xFE0007FCB90500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNavigatingSemiArgCS12215 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingArgExpCS_in_entryRuleNavigatingArgExpCS12255 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigatingArgExpCS12265 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNavigatingArgExpCS12314 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIfExpCS_in_entryRuleIfExpCS12348 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIfExpCS12358 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_81_in_ruleIfExpCS12395 = new BitSet(new long[]{0xFE0007FCB90500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleIfExpCS12416 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
        public static final BitSet FOLLOW_82_in_ruleIfExpCS12428 = new BitSet(new long[]{0xFE0007FCB90500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleIfExpCS12449 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
        public static final BitSet FOLLOW_83_in_ruleIfExpCS12461 = new BitSet(new long[]{0xFE0007FCB90500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleIfExpCS12482 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
        public static final BitSet FOLLOW_84_in_ruleIfExpCS12494 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLetExpCS_in_entryRuleLetExpCS12530 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLetExpCS12540 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_85_in_ruleLetExpCS12577 = new BitSet(new long[]{0x000001F898050030L});
        public static final BitSet FOLLOW_ruleLetVariableCS_in_ruleLetExpCS12598 = new BitSet(new long[]{0x00000000000A0000L});
        public static final BitSet FOLLOW_19_in_ruleLetExpCS12611 = new BitSet(new long[]{0x000001F898050030L});
        public static final BitSet FOLLOW_ruleLetVariableCS_in_ruleLetExpCS12632 = new BitSet(new long[]{0x00000000000A0000L});
        public static final BitSet FOLLOW_17_in_ruleLetExpCS12646 = new BitSet(new long[]{0xFE0007FCB90500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleLetExpCS12667 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLetVariableCS_in_entryRuleLetVariableCS12703 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLetVariableCS12713 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleLetVariableCS12759 = new BitSet(new long[]{0x0002000100000000L});
        public static final BitSet FOLLOW_32_in_ruleLetVariableCS12772 = new BitSet(new long[]{0xFE0007FCB80500F0L,0x000000000042787FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleLetVariableCS12793 = new BitSet(new long[]{0x0002000000000000L});
        public static final BitSet FOLLOW_49_in_ruleLetVariableCS12807 = new BitSet(new long[]{0xFE0007FCB90500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleLetVariableCS12828 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedExpCS_in_entryRuleNestedExpCS12864 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNestedExpCS12874 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_ruleNestedExpCS12911 = new BitSet(new long[]{0xFE0007FCB90500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNestedExpCS12932 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_30_in_ruleNestedExpCS12944 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSelfExpCS_in_entryRuleSelfExpCS12980 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSelfExpCS12990 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_86_in_ruleSelfExpCS13039 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTupleLiteralExpCS_in_synpred124_InternalQVTcore10780 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionLiteralExpCS_in_synpred125_InternalQVTcore10810 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralExpCS_in_synpred126_InternalQVTcore10840 = new BitSet(new long[]{0x0000000000000002L});
    }


}