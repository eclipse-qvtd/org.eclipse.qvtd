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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_SIMPLE_ID", "RULE_ESCAPED_ID", "RULE_INT", "RULE_SINGLE_QUOTED_STRING", "RULE_ESCAPED_CHARACTER", "RULE_LETTER_CHARACTER", "RULE_DOUBLE_QUOTED_STRING", "RULE_ML_SINGLE_QUOTED_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'map'", "'in'", "'refines'", "','", "'{'", "'where'", "'}'", "'|'", "'default'", "':='", "';'", "'imports'", "'uses'", "'import'", "':'", "'::'", "'*'", "'library'", "'check'", "'enforce'", "'('", "')'", "'query'", "'transformation'", "'realize'", "'-'", "'not'", "'/'", "'+'", "'>'", "'<'", "'>='", "'<='", "'='", "'<>'", "'and'", "'or'", "'xor'", "'implies'", "'.'", "'->'", "'Tuple'", "'Boolean'", "'Integer'", "'Real'", "'String'", "'UnlimitedNatural'", "'OclAny'", "'OclInvalid'", "'OclVoid'", "'Set'", "'Bag'", "'Sequence'", "'Collection'", "'OrderedSet'", "'..'", "'['", "']'", "'?'", "'true'", "'false'", "'invalid'", "'null'", "'@'", "'pre'", "'if'", "'then'", "'else'", "'endif'", "'let'", "'self'"
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

                if ( (LA1_0==29) ) {
                    alt1=1;
                }
                else if ( (LA1_0==33) ) {
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

            if ( ((LA3_0>=RULE_SIMPLE_ID && LA3_0<=RULE_ESCAPED_ID)||LA3_0==16||(LA3_0>=27 && LA3_0<=29)||(LA3_0>=33 && LA3_0<=35)||(LA3_0>=38 && LA3_0<=40)) ) {
                alt3=1;
            }
            else if ( (LA3_0==18) ) {
                int LA3_2 = input.LA(2);

                if ( (LA3_2==18) ) {
                    int LA3_4 = input.LA(3);

                    if ( ((LA3_4>=RULE_SIMPLE_ID && LA3_4<=RULE_ESCAPED_ID)||LA3_4==16||LA3_4==18||(LA3_4>=27 && LA3_4<=29)||(LA3_4>=33 && LA3_4<=35)||(LA3_4>=38 && LA3_4<=40)) ) {
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

                    if ( (LA7_2==36) ) {
                        alt7=1;
                    }


                }
                else if ( ((LA7_0>=RULE_SIMPLE_ID && LA7_0<=RULE_ESCAPED_ID)||LA7_0==18||(LA7_0>=27 && LA7_0<=29)||(LA7_0>=33 && LA7_0<=35)||(LA7_0>=38 && LA7_0<=40)) ) {
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:380:1: ruleBottomPatternCS returns [EObject current=null] : ( () ( ( ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_2_0= ruleRealizedVariableCS ) ) ) (otherlv_3= ',' ( ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) ) ) )* otherlv_6= '|' )? ( (lv_constraints_7_0= ruleAssignmentCS ) )* ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:383:28: ( ( () ( ( ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_2_0= ruleRealizedVariableCS ) ) ) (otherlv_3= ',' ( ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) ) ) )* otherlv_6= '|' )? ( (lv_constraints_7_0= ruleAssignmentCS ) )* ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:384:1: ( () ( ( ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_2_0= ruleRealizedVariableCS ) ) ) (otherlv_3= ',' ( ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) ) ) )* otherlv_6= '|' )? ( (lv_constraints_7_0= ruleAssignmentCS ) )* )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:384:1: ( () ( ( ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_2_0= ruleRealizedVariableCS ) ) ) (otherlv_3= ',' ( ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) ) ) )* otherlv_6= '|' )? ( (lv_constraints_7_0= ruleAssignmentCS ) )* )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:384:2: () ( ( ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_2_0= ruleRealizedVariableCS ) ) ) (otherlv_3= ',' ( ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) ) ) )* otherlv_6= '|' )? ( (lv_constraints_7_0= ruleAssignmentCS ) )*
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:384:2: ()
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:385:2: 
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:393:2: ( ( ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_2_0= ruleRealizedVariableCS ) ) ) (otherlv_3= ',' ( ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) ) ) )* otherlv_6= '|' )?
            int alt13=2;
            alt13 = dfa13.predict(input);
            switch (alt13) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:393:3: ( ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_2_0= ruleRealizedVariableCS ) ) ) (otherlv_3= ',' ( ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) ) ) )* otherlv_6= '|'
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:393:3: ( ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_2_0= ruleRealizedVariableCS ) ) )
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( ((LA10_0>=RULE_SIMPLE_ID && LA10_0<=RULE_ESCAPED_ID)||LA10_0==16||LA10_0==18||(LA10_0>=27 && LA10_0<=29)||(LA10_0>=33 && LA10_0<=35)||(LA10_0>=38 && LA10_0<=39)) ) {
                        alt10=1;
                    }
                    else if ( (LA10_0==40) ) {
                        int LA10_2 = input.LA(2);

                        if ( (LA10_2==30) ) {
                            alt10=1;
                        }
                        else if ( ((LA10_2>=RULE_SIMPLE_ID && LA10_2<=RULE_ESCAPED_ID)||LA10_2==16||LA10_2==18||(LA10_2>=27 && LA10_2<=29)||(LA10_2>=33 && LA10_2<=35)||(LA10_2>=38 && LA10_2<=40)) ) {
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
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:393:4: ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:393:4: ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:394:1: (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:394:1: (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:395:3: lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getBottomPatternCSAccess().getUnrealizedVariablesUnrealizedVariableCSParserRuleCall_1_0_0_0()); 
                              	    
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
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:412:6: ( (lv_realizedVariables_2_0= ruleRealizedVariableCS ) )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:412:6: ( (lv_realizedVariables_2_0= ruleRealizedVariableCS ) )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:413:1: (lv_realizedVariables_2_0= ruleRealizedVariableCS )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:413:1: (lv_realizedVariables_2_0= ruleRealizedVariableCS )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:414:3: lv_realizedVariables_2_0= ruleRealizedVariableCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getBottomPatternCSAccess().getRealizedVariablesRealizedVariableCSParserRuleCall_1_0_1_0()); 
                              	    
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

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:430:3: (otherlv_3= ',' ( ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) ) ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==19) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:430:5: otherlv_3= ',' ( ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) ) )
                    	    {
                    	    otherlv_3=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleBottomPatternCS739); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getBottomPatternCSAccess().getCommaKeyword_1_1_0());
                    	          
                    	    }
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:434:1: ( ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) ) )
                    	    int alt11=2;
                    	    int LA11_0 = input.LA(1);

                    	    if ( ((LA11_0>=RULE_SIMPLE_ID && LA11_0<=RULE_ESCAPED_ID)||LA11_0==16||LA11_0==18||(LA11_0>=27 && LA11_0<=29)||(LA11_0>=33 && LA11_0<=35)||(LA11_0>=38 && LA11_0<=39)) ) {
                    	        alt11=1;
                    	    }
                    	    else if ( (LA11_0==40) ) {
                    	        int LA11_2 = input.LA(2);

                    	        if ( ((LA11_2>=RULE_SIMPLE_ID && LA11_2<=RULE_ESCAPED_ID)||LA11_2==16||LA11_2==18||(LA11_2>=27 && LA11_2<=29)||(LA11_2>=33 && LA11_2<=35)||(LA11_2>=38 && LA11_2<=40)) ) {
                    	            alt11=2;
                    	        }
                    	        else if ( (LA11_2==30) ) {
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
                    	            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:434:2: ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) )
                    	            {
                    	            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:434:2: ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) )
                    	            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:435:1: (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS )
                    	            {
                    	            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:435:1: (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS )
                    	            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:436:3: lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS
                    	            {
                    	            if ( state.backtracking==0 ) {
                    	               
                    	              	        newCompositeNode(grammarAccess.getBottomPatternCSAccess().getUnrealizedVariablesUnrealizedVariableCSParserRuleCall_1_1_1_0_0()); 
                    	              	    
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
                    	            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:453:6: ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) )
                    	            {
                    	            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:453:6: ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) )
                    	            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:454:1: (lv_realizedVariables_5_0= ruleRealizedVariableCS )
                    	            {
                    	            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:454:1: (lv_realizedVariables_5_0= ruleRealizedVariableCS )
                    	            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:455:3: lv_realizedVariables_5_0= ruleRealizedVariableCS
                    	            {
                    	            if ( state.backtracking==0 ) {
                    	               
                    	              	        newCompositeNode(grammarAccess.getBottomPatternCSAccess().getRealizedVariablesRealizedVariableCSParserRuleCall_1_1_1_1_0()); 
                    	              	    
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

                          	newLeafNode(otherlv_6, grammarAccess.getBottomPatternCSAccess().getVerticalLineKeyword_1_2());
                          
                    }

                    }
                    break;

            }

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:475:3: ( (lv_constraints_7_0= ruleAssignmentCS ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0>=RULE_SIMPLE_ID && LA14_0<=RULE_SINGLE_QUOTED_STRING)||LA14_0==16||LA14_0==18||LA14_0==24||(LA14_0>=27 && LA14_0<=29)||(LA14_0>=32 && LA14_0<=36)||(LA14_0>=38 && LA14_0<=42)||(LA14_0>=57 && LA14_0<=70)||(LA14_0>=75 && LA14_0<=78)||LA14_0==81||(LA14_0>=85 && LA14_0<=86)) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:476:1: (lv_constraints_7_0= ruleAssignmentCS )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:476:1: (lv_constraints_7_0= ruleAssignmentCS )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:477:3: lv_constraints_7_0= ruleAssignmentCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getBottomPatternCSAccess().getConstraintsAssignmentCSParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleAssignmentCS_in_ruleBottomPatternCS826);
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
    // $ANTLR end "ruleBottomPatternCS"


    // $ANTLR start "entryRuleAssignmentCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:501:1: entryRuleAssignmentCS returns [EObject current=null] : iv_ruleAssignmentCS= ruleAssignmentCS EOF ;
    public final EObject entryRuleAssignmentCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignmentCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:502:2: (iv_ruleAssignmentCS= ruleAssignmentCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:503:2: iv_ruleAssignmentCS= ruleAssignmentCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAssignmentCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAssignmentCS_in_entryRuleAssignmentCS863);
            iv_ruleAssignmentCS=ruleAssignmentCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAssignmentCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAssignmentCS873); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:510:1: ruleAssignmentCS returns [EObject current=null] : ( ( (lv_default_0_0= 'default' ) )? ( (lv_target_1_0= ruleExpCS ) ) (otherlv_2= ':=' ( (lv_initialiser_3_0= ruleExpCS ) ) )? otherlv_4= ';' ) ;
    public final EObject ruleAssignmentCS() throws RecognitionException {
        EObject current = null;

        Token lv_default_0_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_target_1_0 = null;

        EObject lv_initialiser_3_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:513:28: ( ( ( (lv_default_0_0= 'default' ) )? ( (lv_target_1_0= ruleExpCS ) ) (otherlv_2= ':=' ( (lv_initialiser_3_0= ruleExpCS ) ) )? otherlv_4= ';' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:514:1: ( ( (lv_default_0_0= 'default' ) )? ( (lv_target_1_0= ruleExpCS ) ) (otherlv_2= ':=' ( (lv_initialiser_3_0= ruleExpCS ) ) )? otherlv_4= ';' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:514:1: ( ( (lv_default_0_0= 'default' ) )? ( (lv_target_1_0= ruleExpCS ) ) (otherlv_2= ':=' ( (lv_initialiser_3_0= ruleExpCS ) ) )? otherlv_4= ';' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:514:2: ( (lv_default_0_0= 'default' ) )? ( (lv_target_1_0= ruleExpCS ) ) (otherlv_2= ':=' ( (lv_initialiser_3_0= ruleExpCS ) ) )? otherlv_4= ';'
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:514:2: ( (lv_default_0_0= 'default' ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==24) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:515:1: (lv_default_0_0= 'default' )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:515:1: (lv_default_0_0= 'default' )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:516:3: lv_default_0_0= 'default'
                    {
                    lv_default_0_0=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleAssignmentCS916); if (state.failed) return current;
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:529:3: ( (lv_target_1_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:530:1: (lv_target_1_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:530:1: (lv_target_1_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:531:3: lv_target_1_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAssignmentCSAccess().getTargetExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleAssignmentCS951);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:547:2: (otherlv_2= ':=' ( (lv_initialiser_3_0= ruleExpCS ) ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==25) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:547:4: otherlv_2= ':=' ( (lv_initialiser_3_0= ruleExpCS ) )
                    {
                    otherlv_2=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleAssignmentCS964); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getAssignmentCSAccess().getColonEqualsSignKeyword_2_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:551:1: ( (lv_initialiser_3_0= ruleExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:552:1: (lv_initialiser_3_0= ruleExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:552:1: (lv_initialiser_3_0= ruleExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:553:3: lv_initialiser_3_0= ruleExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAssignmentCSAccess().getInitialiserExpCSParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleAssignmentCS985);
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

            otherlv_4=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleAssignmentCS999); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:581:1: entryRuleDirectionCS returns [EObject current=null] : iv_ruleDirectionCS= ruleDirectionCS EOF ;
    public final EObject entryRuleDirectionCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDirectionCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:582:2: (iv_ruleDirectionCS= ruleDirectionCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:583:2: iv_ruleDirectionCS= ruleDirectionCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDirectionCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleDirectionCS_in_entryRuleDirectionCS1035);
            iv_ruleDirectionCS=ruleDirectionCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDirectionCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDirectionCS1045); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:590:1: ruleDirectionCS returns [EObject current=null] : ( () ( (lv_name_1_0= ruleUnrestrictedName ) )? (otherlv_2= 'imports' ( ( ruleUnrestrictedName ) ) (otherlv_4= ',' ( ( ruleUnrestrictedName ) ) )* )? (otherlv_6= 'uses' ( ( ruleUnrestrictedName ) ) (otherlv_8= ',' ( ( ruleUnrestrictedName ) ) )* )? ) ;
    public final EObject ruleDirectionCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:593:28: ( ( () ( (lv_name_1_0= ruleUnrestrictedName ) )? (otherlv_2= 'imports' ( ( ruleUnrestrictedName ) ) (otherlv_4= ',' ( ( ruleUnrestrictedName ) ) )* )? (otherlv_6= 'uses' ( ( ruleUnrestrictedName ) ) (otherlv_8= ',' ( ( ruleUnrestrictedName ) ) )* )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:594:1: ( () ( (lv_name_1_0= ruleUnrestrictedName ) )? (otherlv_2= 'imports' ( ( ruleUnrestrictedName ) ) (otherlv_4= ',' ( ( ruleUnrestrictedName ) ) )* )? (otherlv_6= 'uses' ( ( ruleUnrestrictedName ) ) (otherlv_8= ',' ( ( ruleUnrestrictedName ) ) )* )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:594:1: ( () ( (lv_name_1_0= ruleUnrestrictedName ) )? (otherlv_2= 'imports' ( ( ruleUnrestrictedName ) ) (otherlv_4= ',' ( ( ruleUnrestrictedName ) ) )* )? (otherlv_6= 'uses' ( ( ruleUnrestrictedName ) ) (otherlv_8= ',' ( ( ruleUnrestrictedName ) ) )* )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:594:2: () ( (lv_name_1_0= ruleUnrestrictedName ) )? (otherlv_2= 'imports' ( ( ruleUnrestrictedName ) ) (otherlv_4= ',' ( ( ruleUnrestrictedName ) ) )* )? (otherlv_6= 'uses' ( ( ruleUnrestrictedName ) ) (otherlv_8= ',' ( ( ruleUnrestrictedName ) ) )* )?
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:594:2: ()
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:595:2: 
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:603:2: ( (lv_name_1_0= ruleUnrestrictedName ) )?
            int alt17=2;
            alt17 = dfa17.predict(input);
            switch (alt17) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:604:1: (lv_name_1_0= ruleUnrestrictedName )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:604:1: (lv_name_1_0= ruleUnrestrictedName )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:605:3: lv_name_1_0= ruleUnrestrictedName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDirectionCSAccess().getNameUnrestrictedNameParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleDirectionCS1103);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:621:3: (otherlv_2= 'imports' ( ( ruleUnrestrictedName ) ) (otherlv_4= ',' ( ( ruleUnrestrictedName ) ) )* )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==27) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:621:5: otherlv_2= 'imports' ( ( ruleUnrestrictedName ) ) (otherlv_4= ',' ( ( ruleUnrestrictedName ) ) )*
                    {
                    otherlv_2=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleDirectionCS1117); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getDirectionCSAccess().getImportsKeyword_2_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:625:1: ( ( ruleUnrestrictedName ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:626:1: ( ruleUnrestrictedName )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:626:1: ( ruleUnrestrictedName )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:627:3: ruleUnrestrictedName
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
                    pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleDirectionCS1144);
                    ruleUnrestrictedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:643:2: (otherlv_4= ',' ( ( ruleUnrestrictedName ) ) )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==19) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:643:4: otherlv_4= ',' ( ( ruleUnrestrictedName ) )
                    	    {
                    	    otherlv_4=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleDirectionCS1157); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_4, grammarAccess.getDirectionCSAccess().getCommaKeyword_2_2_0());
                    	          
                    	    }
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:647:1: ( ( ruleUnrestrictedName ) )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:648:1: ( ruleUnrestrictedName )
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:648:1: ( ruleUnrestrictedName )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:649:3: ruleUnrestrictedName
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
                    	    pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleDirectionCS1184);
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
                    	    break loop18;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:665:6: (otherlv_6= 'uses' ( ( ruleUnrestrictedName ) ) (otherlv_8= ',' ( ( ruleUnrestrictedName ) ) )* )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==28) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:665:8: otherlv_6= 'uses' ( ( ruleUnrestrictedName ) ) (otherlv_8= ',' ( ( ruleUnrestrictedName ) ) )*
                    {
                    otherlv_6=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleDirectionCS1201); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getDirectionCSAccess().getUsesKeyword_3_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:669:1: ( ( ruleUnrestrictedName ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:670:1: ( ruleUnrestrictedName )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:670:1: ( ruleUnrestrictedName )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:671:3: ruleUnrestrictedName
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
                    pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleDirectionCS1228);
                    ruleUnrestrictedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:687:2: (otherlv_8= ',' ( ( ruleUnrestrictedName ) ) )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==19) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:687:4: otherlv_8= ',' ( ( ruleUnrestrictedName ) )
                    	    {
                    	    otherlv_8=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleDirectionCS1241); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_8, grammarAccess.getDirectionCSAccess().getCommaKeyword_3_2_0());
                    	          
                    	    }
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:691:1: ( ( ruleUnrestrictedName ) )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:692:1: ( ruleUnrestrictedName )
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:692:1: ( ruleUnrestrictedName )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:693:3: ruleUnrestrictedName
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
                    	    pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleDirectionCS1268);
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
                    	    break loop20;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:717:1: entryRuleGuardPatternCS returns [EObject current=null] : iv_ruleGuardPatternCS= ruleGuardPatternCS EOF ;
    public final EObject entryRuleGuardPatternCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGuardPatternCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:718:2: (iv_ruleGuardPatternCS= ruleGuardPatternCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:719:2: iv_ruleGuardPatternCS= ruleGuardPatternCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGuardPatternCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleGuardPatternCS_in_entryRuleGuardPatternCS1308);
            iv_ruleGuardPatternCS=ruleGuardPatternCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleGuardPatternCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleGuardPatternCS1318); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:726:1: ruleGuardPatternCS returns [EObject current=null] : ( () ( ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) (otherlv_2= ',' ( (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS ) ) )* otherlv_4= '|' )? ( (lv_constraints_5_0= ruleAssignmentCS ) )* ) ;
    public final EObject ruleGuardPatternCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_unrealizedVariables_1_0 = null;

        EObject lv_unrealizedVariables_3_0 = null;

        EObject lv_constraints_5_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:729:28: ( ( () ( ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) (otherlv_2= ',' ( (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS ) ) )* otherlv_4= '|' )? ( (lv_constraints_5_0= ruleAssignmentCS ) )* ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:730:1: ( () ( ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) (otherlv_2= ',' ( (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS ) ) )* otherlv_4= '|' )? ( (lv_constraints_5_0= ruleAssignmentCS ) )* )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:730:1: ( () ( ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) (otherlv_2= ',' ( (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS ) ) )* otherlv_4= '|' )? ( (lv_constraints_5_0= ruleAssignmentCS ) )* )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:730:2: () ( ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) (otherlv_2= ',' ( (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS ) ) )* otherlv_4= '|' )? ( (lv_constraints_5_0= ruleAssignmentCS ) )*
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:730:2: ()
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:731:2: 
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:739:2: ( ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) (otherlv_2= ',' ( (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS ) ) )* otherlv_4= '|' )?
            int alt23=2;
            alt23 = dfa23.predict(input);
            switch (alt23) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:739:3: ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) (otherlv_2= ',' ( (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS ) ) )* otherlv_4= '|'
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:739:3: ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:740:1: (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:740:1: (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:741:3: lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getGuardPatternCSAccess().getUnrealizedVariablesUnrealizedVariableCSParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUnrealizedVariableCS_in_ruleGuardPatternCS1377);
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

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:757:2: (otherlv_2= ',' ( (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS ) ) )*
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==19) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:757:4: otherlv_2= ',' ( (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS ) )
                    	    {
                    	    otherlv_2=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleGuardPatternCS1390); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_2, grammarAccess.getGuardPatternCSAccess().getCommaKeyword_1_1_0());
                    	          
                    	    }
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:761:1: ( (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS ) )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:762:1: (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS )
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:762:1: (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:763:3: lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getGuardPatternCSAccess().getUnrealizedVariablesUnrealizedVariableCSParserRuleCall_1_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleUnrealizedVariableCS_in_ruleGuardPatternCS1411);
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
                    	    break loop22;
                        }
                    } while (true);

                    otherlv_4=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleGuardPatternCS1425); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getGuardPatternCSAccess().getVerticalLineKeyword_1_2());
                          
                    }

                    }
                    break;

            }

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:783:3: ( (lv_constraints_5_0= ruleAssignmentCS ) )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( ((LA24_0>=RULE_SIMPLE_ID && LA24_0<=RULE_SINGLE_QUOTED_STRING)||LA24_0==16||LA24_0==18||LA24_0==24||(LA24_0>=27 && LA24_0<=29)||(LA24_0>=32 && LA24_0<=36)||(LA24_0>=38 && LA24_0<=42)||(LA24_0>=57 && LA24_0<=70)||(LA24_0>=75 && LA24_0<=78)||LA24_0==81||(LA24_0>=85 && LA24_0<=86)) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:784:1: (lv_constraints_5_0= ruleAssignmentCS )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:784:1: (lv_constraints_5_0= ruleAssignmentCS )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:785:3: lv_constraints_5_0= ruleAssignmentCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getGuardPatternCSAccess().getConstraintsAssignmentCSParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleAssignmentCS_in_ruleGuardPatternCS1448);
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


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:809:1: entryRuleImportCS returns [EObject current=null] : iv_ruleImportCS= ruleImportCS EOF ;
    public final EObject entryRuleImportCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:810:2: (iv_ruleImportCS= ruleImportCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:811:2: iv_ruleImportCS= ruleImportCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImportCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleImportCS_in_entryRuleImportCS1485);
            iv_ruleImportCS=ruleImportCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImportCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleImportCS1495); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:818:1: ruleImportCS returns [EObject current=null] : (otherlv_0= 'import' ( ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= ':' )? ( (lv_pathName_3_0= ruleURIPathNameCS ) ) ( ( (lv_all_4_0= '::' ) ) otherlv_5= '*' )? otherlv_6= ';' ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:821:28: ( (otherlv_0= 'import' ( ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= ':' )? ( (lv_pathName_3_0= ruleURIPathNameCS ) ) ( ( (lv_all_4_0= '::' ) ) otherlv_5= '*' )? otherlv_6= ';' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:822:1: (otherlv_0= 'import' ( ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= ':' )? ( (lv_pathName_3_0= ruleURIPathNameCS ) ) ( ( (lv_all_4_0= '::' ) ) otherlv_5= '*' )? otherlv_6= ';' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:822:1: (otherlv_0= 'import' ( ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= ':' )? ( (lv_pathName_3_0= ruleURIPathNameCS ) ) ( ( (lv_all_4_0= '::' ) ) otherlv_5= '*' )? otherlv_6= ';' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:822:3: otherlv_0= 'import' ( ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= ':' )? ( (lv_pathName_3_0= ruleURIPathNameCS ) ) ( ( (lv_all_4_0= '::' ) ) otherlv_5= '*' )? otherlv_6= ';'
            {
            otherlv_0=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleImportCS1532); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getImportCSAccess().getImportKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:826:1: ( ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= ':' )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==RULE_SIMPLE_ID) ) {
                int LA25_1 = input.LA(2);

                if ( (LA25_1==30) ) {
                    alt25=1;
                }
            }
            else if ( (LA25_0==RULE_ESCAPED_ID) ) {
                int LA25_2 = input.LA(2);

                if ( (LA25_2==30) ) {
                    alt25=1;
                }
            }
            switch (alt25) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:826:2: ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= ':'
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:826:2: ( (lv_name_1_0= ruleIdentifier ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:827:1: (lv_name_1_0= ruleIdentifier )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:827:1: (lv_name_1_0= ruleIdentifier )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:828:3: lv_name_1_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getImportCSAccess().getNameIdentifierParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_ruleImportCS1554);
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

                    otherlv_2=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleImportCS1566); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getImportCSAccess().getColonKeyword_1_1());
                          
                    }

                    }
                    break;

            }

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:848:3: ( (lv_pathName_3_0= ruleURIPathNameCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:849:1: (lv_pathName_3_0= ruleURIPathNameCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:849:1: (lv_pathName_3_0= ruleURIPathNameCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:850:3: lv_pathName_3_0= ruleURIPathNameCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getImportCSAccess().getPathNameURIPathNameCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleURIPathNameCS_in_ruleImportCS1589);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:866:2: ( ( (lv_all_4_0= '::' ) ) otherlv_5= '*' )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==31) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:866:3: ( (lv_all_4_0= '::' ) ) otherlv_5= '*'
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:866:3: ( (lv_all_4_0= '::' ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:867:1: (lv_all_4_0= '::' )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:867:1: (lv_all_4_0= '::' )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:868:3: lv_all_4_0= '::'
                    {
                    lv_all_4_0=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleImportCS1608); if (state.failed) return current;
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

                    otherlv_5=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleImportCS1633); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getImportCSAccess().getAsteriskKeyword_3_1());
                          
                    }

                    }
                    break;

            }

            otherlv_6=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleImportCS1647); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:897:1: entryRuleLibraryCS returns [EObject current=null] : iv_ruleLibraryCS= ruleLibraryCS EOF ;
    public final EObject entryRuleLibraryCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLibraryCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:898:2: (iv_ruleLibraryCS= ruleLibraryCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:899:2: iv_ruleLibraryCS= ruleLibraryCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLibraryCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibraryCS_in_entryRuleLibraryCS1683);
            iv_ruleLibraryCS=ruleLibraryCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLibraryCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibraryCS1693); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:906:1: ruleLibraryCS returns [EObject current=null] : (otherlv_0= 'library' ( ( ruleURI ) ) otherlv_2= ';' ) ;
    public final EObject ruleLibraryCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:909:28: ( (otherlv_0= 'library' ( ( ruleURI ) ) otherlv_2= ';' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:910:1: (otherlv_0= 'library' ( ( ruleURI ) ) otherlv_2= ';' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:910:1: (otherlv_0= 'library' ( ( ruleURI ) ) otherlv_2= ';' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:910:3: otherlv_0= 'library' ( ( ruleURI ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleLibraryCS1730); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLibraryCSAccess().getLibraryKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:914:1: ( ( ruleURI ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:915:1: ( ruleURI )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:915:1: ( ruleURI )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:916:3: ruleURI
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
            pushFollow(FollowSets000.FOLLOW_ruleURI_in_ruleLibraryCS1757);
            ruleURI();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleLibraryCS1769); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:944:1: entryRuleNamedDomainCS returns [EObject current=null] : iv_ruleNamedDomainCS= ruleNamedDomainCS EOF ;
    public final EObject entryRuleNamedDomainCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedDomainCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:945:2: (iv_ruleNamedDomainCS= ruleNamedDomainCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:946:2: iv_ruleNamedDomainCS= ruleNamedDomainCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNamedDomainCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNamedDomainCS_in_entryRuleNamedDomainCS1805);
            iv_ruleNamedDomainCS=ruleNamedDomainCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNamedDomainCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNamedDomainCS1815); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:953:1: ruleNamedDomainCS returns [EObject current=null] : ( ( (lv_check_0_0= 'check' ) )? ( (lv_enforce_1_0= 'enforce' ) )? ( ( ruleUnrestrictedName ) ) otherlv_3= '(' ( (lv_guardPattern_4_0= ruleGuardPatternCS ) )? otherlv_5= ')' otherlv_6= '{' ( (lv_bottomPattern_7_0= ruleBottomPatternCS ) )? otherlv_8= '}' ) ;
    public final EObject ruleNamedDomainCS() throws RecognitionException {
        EObject current = null;

        Token lv_check_0_0=null;
        Token lv_enforce_1_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_guardPattern_4_0 = null;

        EObject lv_bottomPattern_7_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:956:28: ( ( ( (lv_check_0_0= 'check' ) )? ( (lv_enforce_1_0= 'enforce' ) )? ( ( ruleUnrestrictedName ) ) otherlv_3= '(' ( (lv_guardPattern_4_0= ruleGuardPatternCS ) )? otherlv_5= ')' otherlv_6= '{' ( (lv_bottomPattern_7_0= ruleBottomPatternCS ) )? otherlv_8= '}' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:957:1: ( ( (lv_check_0_0= 'check' ) )? ( (lv_enforce_1_0= 'enforce' ) )? ( ( ruleUnrestrictedName ) ) otherlv_3= '(' ( (lv_guardPattern_4_0= ruleGuardPatternCS ) )? otherlv_5= ')' otherlv_6= '{' ( (lv_bottomPattern_7_0= ruleBottomPatternCS ) )? otherlv_8= '}' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:957:1: ( ( (lv_check_0_0= 'check' ) )? ( (lv_enforce_1_0= 'enforce' ) )? ( ( ruleUnrestrictedName ) ) otherlv_3= '(' ( (lv_guardPattern_4_0= ruleGuardPatternCS ) )? otherlv_5= ')' otherlv_6= '{' ( (lv_bottomPattern_7_0= ruleBottomPatternCS ) )? otherlv_8= '}' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:957:2: ( (lv_check_0_0= 'check' ) )? ( (lv_enforce_1_0= 'enforce' ) )? ( ( ruleUnrestrictedName ) ) otherlv_3= '(' ( (lv_guardPattern_4_0= ruleGuardPatternCS ) )? otherlv_5= ')' otherlv_6= '{' ( (lv_bottomPattern_7_0= ruleBottomPatternCS ) )? otherlv_8= '}'
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:957:2: ( (lv_check_0_0= 'check' ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==34) ) {
                int LA27_1 = input.LA(2);

                if ( ((LA27_1>=RULE_SIMPLE_ID && LA27_1<=RULE_ESCAPED_ID)||LA27_1==16||LA27_1==18||(LA27_1>=27 && LA27_1<=29)||(LA27_1>=33 && LA27_1<=35)||(LA27_1>=38 && LA27_1<=40)) ) {
                    alt27=1;
                }
            }
            switch (alt27) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:958:1: (lv_check_0_0= 'check' )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:958:1: (lv_check_0_0= 'check' )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:959:3: lv_check_0_0= 'check'
                    {
                    lv_check_0_0=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleNamedDomainCS1858); if (state.failed) return current;
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:972:3: ( (lv_enforce_1_0= 'enforce' ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==35) ) {
                int LA28_1 = input.LA(2);

                if ( ((LA28_1>=RULE_SIMPLE_ID && LA28_1<=RULE_ESCAPED_ID)||LA28_1==16||LA28_1==18||(LA28_1>=27 && LA28_1<=29)||(LA28_1>=33 && LA28_1<=35)||(LA28_1>=38 && LA28_1<=40)) ) {
                    alt28=1;
                }
            }
            switch (alt28) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:973:1: (lv_enforce_1_0= 'enforce' )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:973:1: (lv_enforce_1_0= 'enforce' )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:974:3: lv_enforce_1_0= 'enforce'
                    {
                    lv_enforce_1_0=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleNamedDomainCS1890); if (state.failed) return current;
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:987:3: ( ( ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:988:1: ( ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:988:1: ( ruleUnrestrictedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:989:3: ruleUnrestrictedName
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
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleNamedDomainCS1931);
            ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleNamedDomainCS1943); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getNamedDomainCSAccess().getLeftParenthesisKeyword_3());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1009:1: ( (lv_guardPattern_4_0= ruleGuardPatternCS ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( ((LA29_0>=RULE_SIMPLE_ID && LA29_0<=RULE_SINGLE_QUOTED_STRING)||LA29_0==16||LA29_0==18||LA29_0==24||(LA29_0>=27 && LA29_0<=29)||(LA29_0>=32 && LA29_0<=36)||(LA29_0>=38 && LA29_0<=42)||(LA29_0>=57 && LA29_0<=70)||(LA29_0>=75 && LA29_0<=78)||LA29_0==81||(LA29_0>=85 && LA29_0<=86)) ) {
                alt29=1;
            }
            else if ( (LA29_0==37) ) {
                int LA29_2 = input.LA(2);

                if ( (synpred32_InternalQVTcore()) ) {
                    alt29=1;
                }
            }
            switch (alt29) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1010:1: (lv_guardPattern_4_0= ruleGuardPatternCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1010:1: (lv_guardPattern_4_0= ruleGuardPatternCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1011:3: lv_guardPattern_4_0= ruleGuardPatternCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNamedDomainCSAccess().getGuardPatternGuardPatternCSParserRuleCall_4_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleGuardPatternCS_in_ruleNamedDomainCS1964);
                    lv_guardPattern_4_0=ruleGuardPatternCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getNamedDomainCSRule());
                      	        }
                             		set(
                             			current, 
                             			"guardPattern",
                              		lv_guardPattern_4_0, 
                              		"GuardPatternCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleNamedDomainCS1977); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getNamedDomainCSAccess().getRightParenthesisKeyword_5());
                  
            }
            otherlv_6=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleNamedDomainCS1989); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getNamedDomainCSAccess().getLeftCurlyBracketKeyword_6());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1035:1: ( (lv_bottomPattern_7_0= ruleBottomPatternCS ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( ((LA30_0>=RULE_SIMPLE_ID && LA30_0<=RULE_SINGLE_QUOTED_STRING)||LA30_0==16||LA30_0==18||LA30_0==24||(LA30_0>=27 && LA30_0<=29)||(LA30_0>=32 && LA30_0<=36)||(LA30_0>=38 && LA30_0<=42)||(LA30_0>=57 && LA30_0<=70)||(LA30_0>=75 && LA30_0<=78)||LA30_0==81||(LA30_0>=85 && LA30_0<=86)) ) {
                alt30=1;
            }
            else if ( (LA30_0==22) ) {
                int LA30_2 = input.LA(2);

                if ( (synpred33_InternalQVTcore()) ) {
                    alt30=1;
                }
            }
            switch (alt30) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1036:1: (lv_bottomPattern_7_0= ruleBottomPatternCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1036:1: (lv_bottomPattern_7_0= ruleBottomPatternCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1037:3: lv_bottomPattern_7_0= ruleBottomPatternCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNamedDomainCSAccess().getBottomPatternBottomPatternCSParserRuleCall_7_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleBottomPatternCS_in_ruleNamedDomainCS2010);
                    lv_bottomPattern_7_0=ruleBottomPatternCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getNamedDomainCSRule());
                      	        }
                             		set(
                             			current, 
                             			"bottomPattern",
                              		lv_bottomPattern_7_0, 
                              		"BottomPatternCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_8=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleNamedDomainCS2023); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getNamedDomainCSAccess().getRightCurlyBracketKeyword_8());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1065:1: entryRuleParamDeclarationCS returns [EObject current=null] : iv_ruleParamDeclarationCS= ruleParamDeclarationCS EOF ;
    public final EObject entryRuleParamDeclarationCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParamDeclarationCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1066:2: (iv_ruleParamDeclarationCS= ruleParamDeclarationCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1067:2: iv_ruleParamDeclarationCS= ruleParamDeclarationCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParamDeclarationCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleParamDeclarationCS_in_entryRuleParamDeclarationCS2059);
            iv_ruleParamDeclarationCS=ruleParamDeclarationCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParamDeclarationCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParamDeclarationCS2069); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1074:1: ruleParamDeclarationCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) ) ;
    public final EObject ruleParamDeclarationCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1077:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1078:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1078:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1078:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1078:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1079:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1079:1: (lv_name_0_0= ruleUnrestrictedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1080:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParamDeclarationCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleParamDeclarationCS2115);
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

            otherlv_1=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleParamDeclarationCS2127); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getParamDeclarationCSAccess().getColonKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1100:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1101:1: (lv_ownedType_2_0= ruleTypeExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1101:1: (lv_ownedType_2_0= ruleTypeExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1102:3: lv_ownedType_2_0= ruleTypeExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParamDeclarationCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleParamDeclarationCS2148);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1126:1: entryRuleQueryCS returns [EObject current=null] : iv_ruleQueryCS= ruleQueryCS EOF ;
    public final EObject entryRuleQueryCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQueryCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1127:2: (iv_ruleQueryCS= ruleQueryCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1128:2: iv_ruleQueryCS= ruleQueryCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQueryCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleQueryCS_in_entryRuleQueryCS2184);
            iv_ruleQueryCS=ruleQueryCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQueryCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleQueryCS2194); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1135:1: ruleQueryCS returns [EObject current=null] : (otherlv_0= 'query' ( (lv_pathName_1_0= ruleScopeNameCS ) ) ( (lv_name_2_0= ruleUnrestrictedName ) ) otherlv_3= '(' ( ( (lv_inputParamDeclaration_4_0= ruleParamDeclarationCS ) ) (otherlv_5= ',' ( (lv_inputParamDeclaration_6_0= ruleParamDeclarationCS ) ) )* )? otherlv_7= ')' otherlv_8= ':' ( (lv_ownedType_9_0= ruleTypeExpCS ) ) (otherlv_10= ';' | (otherlv_11= '{' ( (lv_expression_12_0= ruleExpCS ) ) otherlv_13= '}' ) ) ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1138:28: ( (otherlv_0= 'query' ( (lv_pathName_1_0= ruleScopeNameCS ) ) ( (lv_name_2_0= ruleUnrestrictedName ) ) otherlv_3= '(' ( ( (lv_inputParamDeclaration_4_0= ruleParamDeclarationCS ) ) (otherlv_5= ',' ( (lv_inputParamDeclaration_6_0= ruleParamDeclarationCS ) ) )* )? otherlv_7= ')' otherlv_8= ':' ( (lv_ownedType_9_0= ruleTypeExpCS ) ) (otherlv_10= ';' | (otherlv_11= '{' ( (lv_expression_12_0= ruleExpCS ) ) otherlv_13= '}' ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1139:1: (otherlv_0= 'query' ( (lv_pathName_1_0= ruleScopeNameCS ) ) ( (lv_name_2_0= ruleUnrestrictedName ) ) otherlv_3= '(' ( ( (lv_inputParamDeclaration_4_0= ruleParamDeclarationCS ) ) (otherlv_5= ',' ( (lv_inputParamDeclaration_6_0= ruleParamDeclarationCS ) ) )* )? otherlv_7= ')' otherlv_8= ':' ( (lv_ownedType_9_0= ruleTypeExpCS ) ) (otherlv_10= ';' | (otherlv_11= '{' ( (lv_expression_12_0= ruleExpCS ) ) otherlv_13= '}' ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1139:1: (otherlv_0= 'query' ( (lv_pathName_1_0= ruleScopeNameCS ) ) ( (lv_name_2_0= ruleUnrestrictedName ) ) otherlv_3= '(' ( ( (lv_inputParamDeclaration_4_0= ruleParamDeclarationCS ) ) (otherlv_5= ',' ( (lv_inputParamDeclaration_6_0= ruleParamDeclarationCS ) ) )* )? otherlv_7= ')' otherlv_8= ':' ( (lv_ownedType_9_0= ruleTypeExpCS ) ) (otherlv_10= ';' | (otherlv_11= '{' ( (lv_expression_12_0= ruleExpCS ) ) otherlv_13= '}' ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1139:3: otherlv_0= 'query' ( (lv_pathName_1_0= ruleScopeNameCS ) ) ( (lv_name_2_0= ruleUnrestrictedName ) ) otherlv_3= '(' ( ( (lv_inputParamDeclaration_4_0= ruleParamDeclarationCS ) ) (otherlv_5= ',' ( (lv_inputParamDeclaration_6_0= ruleParamDeclarationCS ) ) )* )? otherlv_7= ')' otherlv_8= ':' ( (lv_ownedType_9_0= ruleTypeExpCS ) ) (otherlv_10= ';' | (otherlv_11= '{' ( (lv_expression_12_0= ruleExpCS ) ) otherlv_13= '}' ) )
            {
            otherlv_0=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleQueryCS2231); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getQueryCSAccess().getQueryKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1143:1: ( (lv_pathName_1_0= ruleScopeNameCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1144:1: (lv_pathName_1_0= ruleScopeNameCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1144:1: (lv_pathName_1_0= ruleScopeNameCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1145:3: lv_pathName_1_0= ruleScopeNameCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getQueryCSAccess().getPathNameScopeNameCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleScopeNameCS_in_ruleQueryCS2252);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1161:2: ( (lv_name_2_0= ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1162:1: (lv_name_2_0= ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1162:1: (lv_name_2_0= ruleUnrestrictedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1163:3: lv_name_2_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getQueryCSAccess().getNameUnrestrictedNameParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleQueryCS2273);
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

            otherlv_3=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleQueryCS2285); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getQueryCSAccess().getLeftParenthesisKeyword_3());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1183:1: ( ( (lv_inputParamDeclaration_4_0= ruleParamDeclarationCS ) ) (otherlv_5= ',' ( (lv_inputParamDeclaration_6_0= ruleParamDeclarationCS ) ) )* )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( ((LA32_0>=RULE_SIMPLE_ID && LA32_0<=RULE_ESCAPED_ID)||LA32_0==16||LA32_0==18||(LA32_0>=27 && LA32_0<=29)||(LA32_0>=33 && LA32_0<=35)||(LA32_0>=38 && LA32_0<=40)) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1183:2: ( (lv_inputParamDeclaration_4_0= ruleParamDeclarationCS ) ) (otherlv_5= ',' ( (lv_inputParamDeclaration_6_0= ruleParamDeclarationCS ) ) )*
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1183:2: ( (lv_inputParamDeclaration_4_0= ruleParamDeclarationCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1184:1: (lv_inputParamDeclaration_4_0= ruleParamDeclarationCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1184:1: (lv_inputParamDeclaration_4_0= ruleParamDeclarationCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1185:3: lv_inputParamDeclaration_4_0= ruleParamDeclarationCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getQueryCSAccess().getInputParamDeclarationParamDeclarationCSParserRuleCall_4_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleParamDeclarationCS_in_ruleQueryCS2307);
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

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1201:2: (otherlv_5= ',' ( (lv_inputParamDeclaration_6_0= ruleParamDeclarationCS ) ) )*
                    loop31:
                    do {
                        int alt31=2;
                        int LA31_0 = input.LA(1);

                        if ( (LA31_0==19) ) {
                            alt31=1;
                        }


                        switch (alt31) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1201:4: otherlv_5= ',' ( (lv_inputParamDeclaration_6_0= ruleParamDeclarationCS ) )
                    	    {
                    	    otherlv_5=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleQueryCS2320); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_5, grammarAccess.getQueryCSAccess().getCommaKeyword_4_1_0());
                    	          
                    	    }
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1205:1: ( (lv_inputParamDeclaration_6_0= ruleParamDeclarationCS ) )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1206:1: (lv_inputParamDeclaration_6_0= ruleParamDeclarationCS )
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1206:1: (lv_inputParamDeclaration_6_0= ruleParamDeclarationCS )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1207:3: lv_inputParamDeclaration_6_0= ruleParamDeclarationCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getQueryCSAccess().getInputParamDeclarationParamDeclarationCSParserRuleCall_4_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleParamDeclarationCS_in_ruleQueryCS2341);
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

            otherlv_7=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleQueryCS2357); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getQueryCSAccess().getRightParenthesisKeyword_5());
                  
            }
            otherlv_8=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleQueryCS2369); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getQueryCSAccess().getColonKeyword_6());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1231:1: ( (lv_ownedType_9_0= ruleTypeExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1232:1: (lv_ownedType_9_0= ruleTypeExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1232:1: (lv_ownedType_9_0= ruleTypeExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1233:3: lv_ownedType_9_0= ruleTypeExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getQueryCSAccess().getOwnedTypeTypeExpCSParserRuleCall_7_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleQueryCS2390);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1249:2: (otherlv_10= ';' | (otherlv_11= '{' ( (lv_expression_12_0= ruleExpCS ) ) otherlv_13= '}' ) )
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1249:4: otherlv_10= ';'
                    {
                    otherlv_10=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleQueryCS2403); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getQueryCSAccess().getSemicolonKeyword_8_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1254:6: (otherlv_11= '{' ( (lv_expression_12_0= ruleExpCS ) ) otherlv_13= '}' )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1254:6: (otherlv_11= '{' ( (lv_expression_12_0= ruleExpCS ) ) otherlv_13= '}' )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1254:8: otherlv_11= '{' ( (lv_expression_12_0= ruleExpCS ) ) otherlv_13= '}'
                    {
                    otherlv_11=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleQueryCS2422); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_11, grammarAccess.getQueryCSAccess().getLeftCurlyBracketKeyword_8_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1258:1: ( (lv_expression_12_0= ruleExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1259:1: (lv_expression_12_0= ruleExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1259:1: (lv_expression_12_0= ruleExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1260:3: lv_expression_12_0= ruleExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getQueryCSAccess().getExpressionExpCSParserRuleCall_8_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleQueryCS2443);
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

                    otherlv_13=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleQueryCS2455); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1288:1: entryRuleScopeNameCS returns [EObject current=null] : iv_ruleScopeNameCS= ruleScopeNameCS EOF ;
    public final EObject entryRuleScopeNameCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScopeNameCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1289:2: (iv_ruleScopeNameCS= ruleScopeNameCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1290:2: iv_ruleScopeNameCS= ruleScopeNameCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScopeNameCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleScopeNameCS_in_entryRuleScopeNameCS2493);
            iv_ruleScopeNameCS=ruleScopeNameCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScopeNameCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleScopeNameCS2503); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1297:1: ruleScopeNameCS returns [EObject current=null] : ( ( (lv_path_0_0= ruleFirstPathElementCS ) ) otherlv_1= '::' ( ( (lv_path_2_0= ruleNextPathElementCS ) ) otherlv_3= '::' )* ) ;
    public final EObject ruleScopeNameCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_path_0_0 = null;

        EObject lv_path_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1300:28: ( ( ( (lv_path_0_0= ruleFirstPathElementCS ) ) otherlv_1= '::' ( ( (lv_path_2_0= ruleNextPathElementCS ) ) otherlv_3= '::' )* ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1301:1: ( ( (lv_path_0_0= ruleFirstPathElementCS ) ) otherlv_1= '::' ( ( (lv_path_2_0= ruleNextPathElementCS ) ) otherlv_3= '::' )* )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1301:1: ( ( (lv_path_0_0= ruleFirstPathElementCS ) ) otherlv_1= '::' ( ( (lv_path_2_0= ruleNextPathElementCS ) ) otherlv_3= '::' )* )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1301:2: ( (lv_path_0_0= ruleFirstPathElementCS ) ) otherlv_1= '::' ( ( (lv_path_2_0= ruleNextPathElementCS ) ) otherlv_3= '::' )*
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1301:2: ( (lv_path_0_0= ruleFirstPathElementCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1302:1: (lv_path_0_0= ruleFirstPathElementCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1302:1: (lv_path_0_0= ruleFirstPathElementCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1303:3: lv_path_0_0= ruleFirstPathElementCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getScopeNameCSAccess().getPathFirstPathElementCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleFirstPathElementCS_in_ruleScopeNameCS2549);
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

            otherlv_1=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleScopeNameCS2561); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getScopeNameCSAccess().getColonColonKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1323:1: ( ( (lv_path_2_0= ruleNextPathElementCS ) ) otherlv_3= '::' )*
            loop34:
            do {
                int alt34=2;
                alt34 = dfa34.predict(input);
                switch (alt34) {
            	case 1 :
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1323:2: ( (lv_path_2_0= ruleNextPathElementCS ) ) otherlv_3= '::'
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1323:2: ( (lv_path_2_0= ruleNextPathElementCS ) )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1324:1: (lv_path_2_0= ruleNextPathElementCS )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1324:1: (lv_path_2_0= ruleNextPathElementCS )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1325:3: lv_path_2_0= ruleNextPathElementCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getScopeNameCSAccess().getPathNextPathElementCSParserRuleCall_2_0_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleNextPathElementCS_in_ruleScopeNameCS2583);
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

            	    otherlv_3=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleScopeNameCS2595); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1353:1: entryRuleTransformationCS returns [EObject current=null] : iv_ruleTransformationCS= ruleTransformationCS EOF ;
    public final EObject entryRuleTransformationCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransformationCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1354:2: (iv_ruleTransformationCS= ruleTransformationCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1355:2: iv_ruleTransformationCS= ruleTransformationCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTransformationCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTransformationCS_in_entryRuleTransformationCS2633);
            iv_ruleTransformationCS=ruleTransformationCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTransformationCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTransformationCS2643); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1362:1: ruleTransformationCS returns [EObject current=null] : (otherlv_0= 'transformation' ( (lv_pathName_1_0= ruleScopeNameCS ) )? ( (lv_name_2_0= ruleUnreservedName ) ) otherlv_3= '{' ( ( (lv_directions_4_0= ruleDirectionCS ) ) otherlv_5= ';' )* otherlv_6= '}' ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1365:28: ( (otherlv_0= 'transformation' ( (lv_pathName_1_0= ruleScopeNameCS ) )? ( (lv_name_2_0= ruleUnreservedName ) ) otherlv_3= '{' ( ( (lv_directions_4_0= ruleDirectionCS ) ) otherlv_5= ';' )* otherlv_6= '}' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1366:1: (otherlv_0= 'transformation' ( (lv_pathName_1_0= ruleScopeNameCS ) )? ( (lv_name_2_0= ruleUnreservedName ) ) otherlv_3= '{' ( ( (lv_directions_4_0= ruleDirectionCS ) ) otherlv_5= ';' )* otherlv_6= '}' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1366:1: (otherlv_0= 'transformation' ( (lv_pathName_1_0= ruleScopeNameCS ) )? ( (lv_name_2_0= ruleUnreservedName ) ) otherlv_3= '{' ( ( (lv_directions_4_0= ruleDirectionCS ) ) otherlv_5= ';' )* otherlv_6= '}' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1366:3: otherlv_0= 'transformation' ( (lv_pathName_1_0= ruleScopeNameCS ) )? ( (lv_name_2_0= ruleUnreservedName ) ) otherlv_3= '{' ( ( (lv_directions_4_0= ruleDirectionCS ) ) otherlv_5= ';' )* otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,39,FollowSets000.FOLLOW_39_in_ruleTransformationCS2680); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getTransformationCSAccess().getTransformationKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1370:1: ( (lv_pathName_1_0= ruleScopeNameCS ) )?
            int alt35=2;
            alt35 = dfa35.predict(input);
            switch (alt35) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1371:1: (lv_pathName_1_0= ruleScopeNameCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1371:1: (lv_pathName_1_0= ruleScopeNameCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1372:3: lv_pathName_1_0= ruleScopeNameCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTransformationCSAccess().getPathNameScopeNameCSParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleScopeNameCS_in_ruleTransformationCS2701);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1388:3: ( (lv_name_2_0= ruleUnreservedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1389:1: (lv_name_2_0= ruleUnreservedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1389:1: (lv_name_2_0= ruleUnreservedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1390:3: lv_name_2_0= ruleUnreservedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTransformationCSAccess().getNameUnreservedNameParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnreservedName_in_ruleTransformationCS2723);
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

            otherlv_3=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleTransformationCS2735); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getTransformationCSAccess().getLeftCurlyBracketKeyword_3());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1410:1: ( ( (lv_directions_4_0= ruleDirectionCS ) ) otherlv_5= ';' )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==EOF||(LA36_0>=RULE_SIMPLE_ID && LA36_0<=RULE_ESCAPED_ID)||LA36_0==16||LA36_0==18||(LA36_0>=26 && LA36_0<=29)||(LA36_0>=33 && LA36_0<=35)||(LA36_0>=38 && LA36_0<=40)) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1410:2: ( (lv_directions_4_0= ruleDirectionCS ) ) otherlv_5= ';'
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1410:2: ( (lv_directions_4_0= ruleDirectionCS ) )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1411:1: (lv_directions_4_0= ruleDirectionCS )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1411:1: (lv_directions_4_0= ruleDirectionCS )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1412:3: lv_directions_4_0= ruleDirectionCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTransformationCSAccess().getDirectionsDirectionCSParserRuleCall_4_0_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleDirectionCS_in_ruleTransformationCS2757);
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

            	    otherlv_5=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleTransformationCS2769); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_5, grammarAccess.getTransformationCSAccess().getSemicolonKeyword_4_1());
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);

            otherlv_6=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleTransformationCS2783); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1444:1: entryRuleUnrealizedVariableCS returns [EObject current=null] : iv_ruleUnrealizedVariableCS= ruleUnrealizedVariableCS EOF ;
    public final EObject entryRuleUnrealizedVariableCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnrealizedVariableCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1445:2: (iv_ruleUnrealizedVariableCS= ruleUnrealizedVariableCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1446:2: iv_ruleUnrealizedVariableCS= ruleUnrealizedVariableCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnrealizedVariableCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrealizedVariableCS_in_entryRuleUnrealizedVariableCS2819);
            iv_ruleUnrealizedVariableCS=ruleUnrealizedVariableCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnrealizedVariableCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnrealizedVariableCS2829); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1453:1: ruleUnrealizedVariableCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) ) ;
    public final EObject ruleUnrealizedVariableCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1456:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1457:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1457:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1457:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1457:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1458:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1458:1: (lv_name_0_0= ruleUnrestrictedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1459:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getUnrealizedVariableCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleUnrealizedVariableCS2875);
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

            otherlv_1=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleUnrealizedVariableCS2887); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getUnrealizedVariableCSAccess().getColonKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1479:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1480:1: (lv_ownedType_2_0= ruleTypeExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1480:1: (lv_ownedType_2_0= ruleTypeExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1481:3: lv_ownedType_2_0= ruleTypeExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getUnrealizedVariableCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleUnrealizedVariableCS2908);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1505:1: entryRuleRealizedVariableCS returns [EObject current=null] : iv_ruleRealizedVariableCS= ruleRealizedVariableCS EOF ;
    public final EObject entryRuleRealizedVariableCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealizedVariableCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1506:2: (iv_ruleRealizedVariableCS= ruleRealizedVariableCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1507:2: iv_ruleRealizedVariableCS= ruleRealizedVariableCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRealizedVariableCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleRealizedVariableCS_in_entryRuleRealizedVariableCS2944);
            iv_ruleRealizedVariableCS=ruleRealizedVariableCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRealizedVariableCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRealizedVariableCS2954); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1514:1: ruleRealizedVariableCS returns [EObject current=null] : (otherlv_0= 'realize' ( (lv_name_1_0= ruleUnrestrictedName ) ) otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) ) ;
    public final EObject ruleRealizedVariableCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_ownedType_3_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1517:28: ( (otherlv_0= 'realize' ( (lv_name_1_0= ruleUnrestrictedName ) ) otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1518:1: (otherlv_0= 'realize' ( (lv_name_1_0= ruleUnrestrictedName ) ) otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1518:1: (otherlv_0= 'realize' ( (lv_name_1_0= ruleUnrestrictedName ) ) otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1518:3: otherlv_0= 'realize' ( (lv_name_1_0= ruleUnrestrictedName ) ) otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) )
            {
            otherlv_0=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleRealizedVariableCS2991); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getRealizedVariableCSAccess().getRealizeKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1522:1: ( (lv_name_1_0= ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1523:1: (lv_name_1_0= ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1523:1: (lv_name_1_0= ruleUnrestrictedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1524:3: lv_name_1_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRealizedVariableCSAccess().getNameUnrestrictedNameParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleRealizedVariableCS3012);
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

            otherlv_2=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleRealizedVariableCS3024); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getRealizedVariableCSAccess().getColonKeyword_2());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1544:1: ( (lv_ownedType_3_0= ruleTypeExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1545:1: (lv_ownedType_3_0= ruleTypeExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1545:1: (lv_ownedType_3_0= ruleTypeExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1546:3: lv_ownedType_3_0= ruleTypeExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRealizedVariableCSAccess().getOwnedTypeTypeExpCSParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleRealizedVariableCS3045);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1570:1: entryRuleUnnamedDomainCS returns [EObject current=null] : iv_ruleUnnamedDomainCS= ruleUnnamedDomainCS EOF ;
    public final EObject entryRuleUnnamedDomainCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnnamedDomainCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1571:2: (iv_ruleUnnamedDomainCS= ruleUnnamedDomainCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1572:2: iv_ruleUnnamedDomainCS= ruleUnnamedDomainCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnnamedDomainCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnnamedDomainCS_in_entryRuleUnnamedDomainCS3081);
            iv_ruleUnnamedDomainCS=ruleUnnamedDomainCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnnamedDomainCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnnamedDomainCS3091); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1579:1: ruleUnnamedDomainCS returns [EObject current=null] : ( () otherlv_1= '(' ( (lv_guardPattern_2_0= ruleGuardPatternCS ) )? otherlv_3= ')' otherlv_4= '{' ( (lv_bottomPattern_5_0= ruleBottomPatternCS ) )? otherlv_6= '}' ) ;
    public final EObject ruleUnnamedDomainCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_guardPattern_2_0 = null;

        EObject lv_bottomPattern_5_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1582:28: ( ( () otherlv_1= '(' ( (lv_guardPattern_2_0= ruleGuardPatternCS ) )? otherlv_3= ')' otherlv_4= '{' ( (lv_bottomPattern_5_0= ruleBottomPatternCS ) )? otherlv_6= '}' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1583:1: ( () otherlv_1= '(' ( (lv_guardPattern_2_0= ruleGuardPatternCS ) )? otherlv_3= ')' otherlv_4= '{' ( (lv_bottomPattern_5_0= ruleBottomPatternCS ) )? otherlv_6= '}' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1583:1: ( () otherlv_1= '(' ( (lv_guardPattern_2_0= ruleGuardPatternCS ) )? otherlv_3= ')' otherlv_4= '{' ( (lv_bottomPattern_5_0= ruleBottomPatternCS ) )? otherlv_6= '}' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1583:2: () otherlv_1= '(' ( (lv_guardPattern_2_0= ruleGuardPatternCS ) )? otherlv_3= ')' otherlv_4= '{' ( (lv_bottomPattern_5_0= ruleBottomPatternCS ) )? otherlv_6= '}'
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1583:2: ()
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1584:2: 
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

            otherlv_1=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleUnnamedDomainCS3140); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getUnnamedDomainCSAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1596:1: ( (lv_guardPattern_2_0= ruleGuardPatternCS ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( ((LA37_0>=RULE_SIMPLE_ID && LA37_0<=RULE_SINGLE_QUOTED_STRING)||LA37_0==16||LA37_0==18||LA37_0==24||(LA37_0>=27 && LA37_0<=29)||(LA37_0>=32 && LA37_0<=36)||(LA37_0>=38 && LA37_0<=42)||(LA37_0>=57 && LA37_0<=70)||(LA37_0>=75 && LA37_0<=78)||LA37_0==81||(LA37_0>=85 && LA37_0<=86)) ) {
                alt37=1;
            }
            else if ( (LA37_0==37) ) {
                int LA37_2 = input.LA(2);

                if ( (synpred40_InternalQVTcore()) ) {
                    alt37=1;
                }
            }
            switch (alt37) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1597:1: (lv_guardPattern_2_0= ruleGuardPatternCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1597:1: (lv_guardPattern_2_0= ruleGuardPatternCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1598:3: lv_guardPattern_2_0= ruleGuardPatternCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getUnnamedDomainCSAccess().getGuardPatternGuardPatternCSParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleGuardPatternCS_in_ruleUnnamedDomainCS3161);
                    lv_guardPattern_2_0=ruleGuardPatternCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getUnnamedDomainCSRule());
                      	        }
                             		set(
                             			current, 
                             			"guardPattern",
                              		lv_guardPattern_2_0, 
                              		"GuardPatternCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleUnnamedDomainCS3174); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getUnnamedDomainCSAccess().getRightParenthesisKeyword_3());
                  
            }
            otherlv_4=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleUnnamedDomainCS3186); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getUnnamedDomainCSAccess().getLeftCurlyBracketKeyword_4());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1622:1: ( (lv_bottomPattern_5_0= ruleBottomPatternCS ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( ((LA38_0>=RULE_SIMPLE_ID && LA38_0<=RULE_SINGLE_QUOTED_STRING)||LA38_0==16||LA38_0==18||LA38_0==24||(LA38_0>=27 && LA38_0<=29)||(LA38_0>=32 && LA38_0<=36)||(LA38_0>=38 && LA38_0<=42)||(LA38_0>=57 && LA38_0<=70)||(LA38_0>=75 && LA38_0<=78)||LA38_0==81||(LA38_0>=85 && LA38_0<=86)) ) {
                alt38=1;
            }
            else if ( (LA38_0==22) ) {
                int LA38_2 = input.LA(2);

                if ( (synpred41_InternalQVTcore()) ) {
                    alt38=1;
                }
            }
            switch (alt38) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1623:1: (lv_bottomPattern_5_0= ruleBottomPatternCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1623:1: (lv_bottomPattern_5_0= ruleBottomPatternCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1624:3: lv_bottomPattern_5_0= ruleBottomPatternCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getUnnamedDomainCSAccess().getBottomPatternBottomPatternCSParserRuleCall_5_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleBottomPatternCS_in_ruleUnnamedDomainCS3207);
                    lv_bottomPattern_5_0=ruleBottomPatternCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getUnnamedDomainCSRule());
                      	        }
                             		set(
                             			current, 
                             			"bottomPattern",
                              		lv_bottomPattern_5_0, 
                              		"BottomPatternCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleUnnamedDomainCS3220); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getUnnamedDomainCSAccess().getRightCurlyBracketKeyword_6());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1652:1: entryRuleUnrestrictedName returns [String current=null] : iv_ruleUnrestrictedName= ruleUnrestrictedName EOF ;
    public final String entryRuleUnrestrictedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnrestrictedName = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1653:2: (iv_ruleUnrestrictedName= ruleUnrestrictedName EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1654:2: iv_ruleUnrestrictedName= ruleUnrestrictedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnrestrictedNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_entryRuleUnrestrictedName3257);
            iv_ruleUnrestrictedName=ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnrestrictedName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnrestrictedName3268); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1661:1: ruleUnrestrictedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_EssentialOCLUnrestrictedName_0= ruleEssentialOCLUnrestrictedName | kw= 'check' | kw= 'enforce' | kw= 'import' | kw= 'imports' | kw= 'library' | kw= 'map' | kw= 'query' | kw= 'realize' | kw= 'refines' | kw= 'transformation' | kw= 'uses' ) ;
    public final AntlrDatatypeRuleToken ruleUnrestrictedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_EssentialOCLUnrestrictedName_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1664:28: ( (this_EssentialOCLUnrestrictedName_0= ruleEssentialOCLUnrestrictedName | kw= 'check' | kw= 'enforce' | kw= 'import' | kw= 'imports' | kw= 'library' | kw= 'map' | kw= 'query' | kw= 'realize' | kw= 'refines' | kw= 'transformation' | kw= 'uses' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1665:1: (this_EssentialOCLUnrestrictedName_0= ruleEssentialOCLUnrestrictedName | kw= 'check' | kw= 'enforce' | kw= 'import' | kw= 'imports' | kw= 'library' | kw= 'map' | kw= 'query' | kw= 'realize' | kw= 'refines' | kw= 'transformation' | kw= 'uses' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1665:1: (this_EssentialOCLUnrestrictedName_0= ruleEssentialOCLUnrestrictedName | kw= 'check' | kw= 'enforce' | kw= 'import' | kw= 'imports' | kw= 'library' | kw= 'map' | kw= 'query' | kw= 'realize' | kw= 'refines' | kw= 'transformation' | kw= 'uses' )
            int alt39=12;
            switch ( input.LA(1) ) {
            case RULE_SIMPLE_ID:
            case RULE_ESCAPED_ID:
                {
                alt39=1;
                }
                break;
            case 34:
                {
                alt39=2;
                }
                break;
            case 35:
                {
                alt39=3;
                }
                break;
            case 29:
                {
                alt39=4;
                }
                break;
            case 27:
                {
                alt39=5;
                }
                break;
            case 33:
                {
                alt39=6;
                }
                break;
            case 16:
                {
                alt39=7;
                }
                break;
            case 38:
                {
                alt39=8;
                }
                break;
            case 40:
                {
                alt39=9;
                }
                break;
            case 18:
                {
                alt39=10;
                }
                break;
            case 39:
                {
                alt39=11;
                }
                break;
            case 28:
                {
                alt39=12;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1666:5: this_EssentialOCLUnrestrictedName_0= ruleEssentialOCLUnrestrictedName
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getUnrestrictedNameAccess().getEssentialOCLUnrestrictedNameParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLUnrestrictedName_in_ruleUnrestrictedName3315);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1678:2: kw= 'check'
                    {
                    kw=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleUnrestrictedName3339); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getCheckKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1685:2: kw= 'enforce'
                    {
                    kw=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleUnrestrictedName3358); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getEnforceKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1692:2: kw= 'import'
                    {
                    kw=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleUnrestrictedName3377); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getImportKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1699:2: kw= 'imports'
                    {
                    kw=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleUnrestrictedName3396); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getImportsKeyword_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1706:2: kw= 'library'
                    {
                    kw=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleUnrestrictedName3415); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getLibraryKeyword_5()); 
                          
                    }

                    }
                    break;
                case 7 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1713:2: kw= 'map'
                    {
                    kw=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleUnrestrictedName3434); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getMapKeyword_6()); 
                          
                    }

                    }
                    break;
                case 8 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1720:2: kw= 'query'
                    {
                    kw=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleUnrestrictedName3453); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getQueryKeyword_7()); 
                          
                    }

                    }
                    break;
                case 9 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1727:2: kw= 'realize'
                    {
                    kw=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleUnrestrictedName3472); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getRealizeKeyword_8()); 
                          
                    }

                    }
                    break;
                case 10 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1734:2: kw= 'refines'
                    {
                    kw=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleUnrestrictedName3491); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getRefinesKeyword_9()); 
                          
                    }

                    }
                    break;
                case 11 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1741:2: kw= 'transformation'
                    {
                    kw=(Token)match(input,39,FollowSets000.FOLLOW_39_in_ruleUnrestrictedName3510); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getTransformationKeyword_10()); 
                          
                    }

                    }
                    break;
                case 12 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1748:2: kw= 'uses'
                    {
                    kw=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleUnrestrictedName3529); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1763:1: entryRuleID returns [String current=null] : iv_ruleID= ruleID EOF ;
    public final String entryRuleID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleID = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1764:2: (iv_ruleID= ruleID EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1765:2: iv_ruleID= ruleID EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIDRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleID_in_entryRuleID3572);
            iv_ruleID=ruleID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleID.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleID3583); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1772:1: ruleID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_SIMPLE_ID_0= RULE_SIMPLE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID ) ;
    public final AntlrDatatypeRuleToken ruleID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_SIMPLE_ID_0=null;
        Token this_ESCAPED_ID_1=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1775:28: ( (this_SIMPLE_ID_0= RULE_SIMPLE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1776:1: (this_SIMPLE_ID_0= RULE_SIMPLE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1776:1: (this_SIMPLE_ID_0= RULE_SIMPLE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==RULE_SIMPLE_ID) ) {
                alt40=1;
            }
            else if ( (LA40_0==RULE_ESCAPED_ID) ) {
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1776:6: this_SIMPLE_ID_0= RULE_SIMPLE_ID
                    {
                    this_SIMPLE_ID_0=(Token)match(input,RULE_SIMPLE_ID,FollowSets000.FOLLOW_RULE_SIMPLE_ID_in_ruleID3623); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SIMPLE_ID_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SIMPLE_ID_0, grammarAccess.getIDAccess().getSIMPLE_IDTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1784:10: this_ESCAPED_ID_1= RULE_ESCAPED_ID
                    {
                    this_ESCAPED_ID_1=(Token)match(input,RULE_ESCAPED_ID,FollowSets000.FOLLOW_RULE_ESCAPED_ID_in_ruleID3649); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1799:1: entryRuleLOWER returns [String current=null] : iv_ruleLOWER= ruleLOWER EOF ;
    public final String entryRuleLOWER() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLOWER = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1800:2: (iv_ruleLOWER= ruleLOWER EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1801:2: iv_ruleLOWER= ruleLOWER EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLOWERRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLOWER_in_entryRuleLOWER3695);
            iv_ruleLOWER=ruleLOWER();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLOWER.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLOWER3706); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1808:1: ruleLOWER returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INT_0= RULE_INT ;
    public final AntlrDatatypeRuleToken ruleLOWER() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1811:28: (this_INT_0= RULE_INT )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1812:5: this_INT_0= RULE_INT
            {
            this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleLOWER3745); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1827:1: entryRuleUPPER returns [String current=null] : iv_ruleUPPER= ruleUPPER EOF ;
    public final String entryRuleUPPER() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUPPER = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1828:2: (iv_ruleUPPER= ruleUPPER EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1829:2: iv_ruleUPPER= ruleUPPER EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUPPERRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUPPER_in_entryRuleUPPER3790);
            iv_ruleUPPER=ruleUPPER();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUPPER.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUPPER3801); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1836:1: ruleUPPER returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT | kw= '*' ) ;
    public final AntlrDatatypeRuleToken ruleUPPER() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1839:28: ( (this_INT_0= RULE_INT | kw= '*' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1840:1: (this_INT_0= RULE_INT | kw= '*' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1840:1: (this_INT_0= RULE_INT | kw= '*' )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==RULE_INT) ) {
                alt41=1;
            }
            else if ( (LA41_0==32) ) {
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1840:6: this_INT_0= RULE_INT
                    {
                    this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleUPPER3841); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_INT_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_INT_0, grammarAccess.getUPPERAccess().getINTTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1849:2: kw= '*'
                    {
                    kw=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleUPPER3865); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1862:1: entryRuleNUMBER_LITERAL returns [String current=null] : iv_ruleNUMBER_LITERAL= ruleNUMBER_LITERAL EOF ;
    public final String entryRuleNUMBER_LITERAL() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNUMBER_LITERAL = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1863:2: (iv_ruleNUMBER_LITERAL= ruleNUMBER_LITERAL EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1864:2: iv_ruleNUMBER_LITERAL= ruleNUMBER_LITERAL EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNUMBER_LITERALRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNUMBER_LITERAL_in_entryRuleNUMBER_LITERAL3906);
            iv_ruleNUMBER_LITERAL=ruleNUMBER_LITERAL();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNUMBER_LITERAL.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNUMBER_LITERAL3917); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1871:1: ruleNUMBER_LITERAL returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INT_0= RULE_INT ;
    public final AntlrDatatypeRuleToken ruleNUMBER_LITERAL() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1874:28: (this_INT_0= RULE_INT )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1875:5: this_INT_0= RULE_INT
            {
            this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleNUMBER_LITERAL3956); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1890:1: entryRuleURI returns [String current=null] : iv_ruleURI= ruleURI EOF ;
    public final String entryRuleURI() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleURI = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1891:2: (iv_ruleURI= ruleURI EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1892:2: iv_ruleURI= ruleURI EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getURIRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleURI_in_entryRuleURI4001);
            iv_ruleURI=ruleURI();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleURI.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleURI4012); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1899:1: ruleURI returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING ;
    public final AntlrDatatypeRuleToken ruleURI() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_SINGLE_QUOTED_STRING_0=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1902:28: (this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1903:5: this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING
            {
            this_SINGLE_QUOTED_STRING_0=(Token)match(input,RULE_SINGLE_QUOTED_STRING,FollowSets000.FOLLOW_RULE_SINGLE_QUOTED_STRING_in_ruleURI4051); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1920:1: entryRuleEssentialOCLUnaryOperatorCS returns [EObject current=null] : iv_ruleEssentialOCLUnaryOperatorCS= ruleEssentialOCLUnaryOperatorCS EOF ;
    public final EObject entryRuleEssentialOCLUnaryOperatorCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEssentialOCLUnaryOperatorCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1921:2: (iv_ruleEssentialOCLUnaryOperatorCS= ruleEssentialOCLUnaryOperatorCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1922:2: iv_ruleEssentialOCLUnaryOperatorCS= ruleEssentialOCLUnaryOperatorCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEssentialOCLUnaryOperatorCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLUnaryOperatorCS_in_entryRuleEssentialOCLUnaryOperatorCS4097);
            iv_ruleEssentialOCLUnaryOperatorCS=ruleEssentialOCLUnaryOperatorCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEssentialOCLUnaryOperatorCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEssentialOCLUnaryOperatorCS4107); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1929:1: ruleEssentialOCLUnaryOperatorCS returns [EObject current=null] : ( ( (lv_name_0_1= '-' | lv_name_0_2= 'not' ) ) ) ;
    public final EObject ruleEssentialOCLUnaryOperatorCS() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1932:28: ( ( ( (lv_name_0_1= '-' | lv_name_0_2= 'not' ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1933:1: ( ( (lv_name_0_1= '-' | lv_name_0_2= 'not' ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1933:1: ( ( (lv_name_0_1= '-' | lv_name_0_2= 'not' ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1934:1: ( (lv_name_0_1= '-' | lv_name_0_2= 'not' ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1934:1: ( (lv_name_0_1= '-' | lv_name_0_2= 'not' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1935:1: (lv_name_0_1= '-' | lv_name_0_2= 'not' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1935:1: (lv_name_0_1= '-' | lv_name_0_2= 'not' )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==41) ) {
                alt42=1;
            }
            else if ( (LA42_0==42) ) {
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1936:3: lv_name_0_1= '-'
                    {
                    lv_name_0_1=(Token)match(input,41,FollowSets000.FOLLOW_41_in_ruleEssentialOCLUnaryOperatorCS4151); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1948:8: lv_name_0_2= 'not'
                    {
                    lv_name_0_2=(Token)match(input,42,FollowSets000.FOLLOW_42_in_ruleEssentialOCLUnaryOperatorCS4180); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1971:1: entryRuleEssentialOCLInfixOperatorCS returns [EObject current=null] : iv_ruleEssentialOCLInfixOperatorCS= ruleEssentialOCLInfixOperatorCS EOF ;
    public final EObject entryRuleEssentialOCLInfixOperatorCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEssentialOCLInfixOperatorCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1972:2: (iv_ruleEssentialOCLInfixOperatorCS= ruleEssentialOCLInfixOperatorCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1973:2: iv_ruleEssentialOCLInfixOperatorCS= ruleEssentialOCLInfixOperatorCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEssentialOCLInfixOperatorCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLInfixOperatorCS_in_entryRuleEssentialOCLInfixOperatorCS4231);
            iv_ruleEssentialOCLInfixOperatorCS=ruleEssentialOCLInfixOperatorCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEssentialOCLInfixOperatorCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEssentialOCLInfixOperatorCS4241); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1980:1: ruleEssentialOCLInfixOperatorCS returns [EObject current=null] : ( ( (lv_name_0_1= '*' | lv_name_0_2= '/' | lv_name_0_3= '+' | lv_name_0_4= '-' | lv_name_0_5= '>' | lv_name_0_6= '<' | lv_name_0_7= '>=' | lv_name_0_8= '<=' | lv_name_0_9= '=' | lv_name_0_10= '<>' | lv_name_0_11= 'and' | lv_name_0_12= 'or' | lv_name_0_13= 'xor' | lv_name_0_14= 'implies' ) ) ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1983:28: ( ( ( (lv_name_0_1= '*' | lv_name_0_2= '/' | lv_name_0_3= '+' | lv_name_0_4= '-' | lv_name_0_5= '>' | lv_name_0_6= '<' | lv_name_0_7= '>=' | lv_name_0_8= '<=' | lv_name_0_9= '=' | lv_name_0_10= '<>' | lv_name_0_11= 'and' | lv_name_0_12= 'or' | lv_name_0_13= 'xor' | lv_name_0_14= 'implies' ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1984:1: ( ( (lv_name_0_1= '*' | lv_name_0_2= '/' | lv_name_0_3= '+' | lv_name_0_4= '-' | lv_name_0_5= '>' | lv_name_0_6= '<' | lv_name_0_7= '>=' | lv_name_0_8= '<=' | lv_name_0_9= '=' | lv_name_0_10= '<>' | lv_name_0_11= 'and' | lv_name_0_12= 'or' | lv_name_0_13= 'xor' | lv_name_0_14= 'implies' ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1984:1: ( ( (lv_name_0_1= '*' | lv_name_0_2= '/' | lv_name_0_3= '+' | lv_name_0_4= '-' | lv_name_0_5= '>' | lv_name_0_6= '<' | lv_name_0_7= '>=' | lv_name_0_8= '<=' | lv_name_0_9= '=' | lv_name_0_10= '<>' | lv_name_0_11= 'and' | lv_name_0_12= 'or' | lv_name_0_13= 'xor' | lv_name_0_14= 'implies' ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1985:1: ( (lv_name_0_1= '*' | lv_name_0_2= '/' | lv_name_0_3= '+' | lv_name_0_4= '-' | lv_name_0_5= '>' | lv_name_0_6= '<' | lv_name_0_7= '>=' | lv_name_0_8= '<=' | lv_name_0_9= '=' | lv_name_0_10= '<>' | lv_name_0_11= 'and' | lv_name_0_12= 'or' | lv_name_0_13= 'xor' | lv_name_0_14= 'implies' ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1985:1: ( (lv_name_0_1= '*' | lv_name_0_2= '/' | lv_name_0_3= '+' | lv_name_0_4= '-' | lv_name_0_5= '>' | lv_name_0_6= '<' | lv_name_0_7= '>=' | lv_name_0_8= '<=' | lv_name_0_9= '=' | lv_name_0_10= '<>' | lv_name_0_11= 'and' | lv_name_0_12= 'or' | lv_name_0_13= 'xor' | lv_name_0_14= 'implies' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1986:1: (lv_name_0_1= '*' | lv_name_0_2= '/' | lv_name_0_3= '+' | lv_name_0_4= '-' | lv_name_0_5= '>' | lv_name_0_6= '<' | lv_name_0_7= '>=' | lv_name_0_8= '<=' | lv_name_0_9= '=' | lv_name_0_10= '<>' | lv_name_0_11= 'and' | lv_name_0_12= 'or' | lv_name_0_13= 'xor' | lv_name_0_14= 'implies' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1986:1: (lv_name_0_1= '*' | lv_name_0_2= '/' | lv_name_0_3= '+' | lv_name_0_4= '-' | lv_name_0_5= '>' | lv_name_0_6= '<' | lv_name_0_7= '>=' | lv_name_0_8= '<=' | lv_name_0_9= '=' | lv_name_0_10= '<>' | lv_name_0_11= 'and' | lv_name_0_12= 'or' | lv_name_0_13= 'xor' | lv_name_0_14= 'implies' )
            int alt43=14;
            switch ( input.LA(1) ) {
            case 32:
                {
                alt43=1;
                }
                break;
            case 43:
                {
                alt43=2;
                }
                break;
            case 44:
                {
                alt43=3;
                }
                break;
            case 41:
                {
                alt43=4;
                }
                break;
            case 45:
                {
                alt43=5;
                }
                break;
            case 46:
                {
                alt43=6;
                }
                break;
            case 47:
                {
                alt43=7;
                }
                break;
            case 48:
                {
                alt43=8;
                }
                break;
            case 49:
                {
                alt43=9;
                }
                break;
            case 50:
                {
                alt43=10;
                }
                break;
            case 51:
                {
                alt43=11;
                }
                break;
            case 52:
                {
                alt43=12;
                }
                break;
            case 53:
                {
                alt43=13;
                }
                break;
            case 54:
                {
                alt43=14;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1987:3: lv_name_0_1= '*'
                    {
                    lv_name_0_1=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleEssentialOCLInfixOperatorCS4285); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1999:8: lv_name_0_2= '/'
                    {
                    lv_name_0_2=(Token)match(input,43,FollowSets000.FOLLOW_43_in_ruleEssentialOCLInfixOperatorCS4314); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2011:8: lv_name_0_3= '+'
                    {
                    lv_name_0_3=(Token)match(input,44,FollowSets000.FOLLOW_44_in_ruleEssentialOCLInfixOperatorCS4343); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2023:8: lv_name_0_4= '-'
                    {
                    lv_name_0_4=(Token)match(input,41,FollowSets000.FOLLOW_41_in_ruleEssentialOCLInfixOperatorCS4372); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2035:8: lv_name_0_5= '>'
                    {
                    lv_name_0_5=(Token)match(input,45,FollowSets000.FOLLOW_45_in_ruleEssentialOCLInfixOperatorCS4401); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2047:8: lv_name_0_6= '<'
                    {
                    lv_name_0_6=(Token)match(input,46,FollowSets000.FOLLOW_46_in_ruleEssentialOCLInfixOperatorCS4430); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2059:8: lv_name_0_7= '>='
                    {
                    lv_name_0_7=(Token)match(input,47,FollowSets000.FOLLOW_47_in_ruleEssentialOCLInfixOperatorCS4459); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2071:8: lv_name_0_8= '<='
                    {
                    lv_name_0_8=(Token)match(input,48,FollowSets000.FOLLOW_48_in_ruleEssentialOCLInfixOperatorCS4488); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2083:8: lv_name_0_9= '='
                    {
                    lv_name_0_9=(Token)match(input,49,FollowSets000.FOLLOW_49_in_ruleEssentialOCLInfixOperatorCS4517); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2095:8: lv_name_0_10= '<>'
                    {
                    lv_name_0_10=(Token)match(input,50,FollowSets000.FOLLOW_50_in_ruleEssentialOCLInfixOperatorCS4546); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2107:8: lv_name_0_11= 'and'
                    {
                    lv_name_0_11=(Token)match(input,51,FollowSets000.FOLLOW_51_in_ruleEssentialOCLInfixOperatorCS4575); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2119:8: lv_name_0_12= 'or'
                    {
                    lv_name_0_12=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleEssentialOCLInfixOperatorCS4604); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2131:8: lv_name_0_13= 'xor'
                    {
                    lv_name_0_13=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleEssentialOCLInfixOperatorCS4633); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2143:8: lv_name_0_14= 'implies'
                    {
                    lv_name_0_14=(Token)match(input,54,FollowSets000.FOLLOW_54_in_ruleEssentialOCLInfixOperatorCS4662); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2166:1: entryRuleEssentialOCLNavigationOperatorCS returns [EObject current=null] : iv_ruleEssentialOCLNavigationOperatorCS= ruleEssentialOCLNavigationOperatorCS EOF ;
    public final EObject entryRuleEssentialOCLNavigationOperatorCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEssentialOCLNavigationOperatorCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2167:2: (iv_ruleEssentialOCLNavigationOperatorCS= ruleEssentialOCLNavigationOperatorCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2168:2: iv_ruleEssentialOCLNavigationOperatorCS= ruleEssentialOCLNavigationOperatorCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEssentialOCLNavigationOperatorCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLNavigationOperatorCS_in_entryRuleEssentialOCLNavigationOperatorCS4713);
            iv_ruleEssentialOCLNavigationOperatorCS=ruleEssentialOCLNavigationOperatorCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEssentialOCLNavigationOperatorCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEssentialOCLNavigationOperatorCS4723); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2175:1: ruleEssentialOCLNavigationOperatorCS returns [EObject current=null] : ( ( (lv_name_0_1= '.' | lv_name_0_2= '->' ) ) ) ;
    public final EObject ruleEssentialOCLNavigationOperatorCS() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2178:28: ( ( ( (lv_name_0_1= '.' | lv_name_0_2= '->' ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2179:1: ( ( (lv_name_0_1= '.' | lv_name_0_2= '->' ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2179:1: ( ( (lv_name_0_1= '.' | lv_name_0_2= '->' ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2180:1: ( (lv_name_0_1= '.' | lv_name_0_2= '->' ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2180:1: ( (lv_name_0_1= '.' | lv_name_0_2= '->' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2181:1: (lv_name_0_1= '.' | lv_name_0_2= '->' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2181:1: (lv_name_0_1= '.' | lv_name_0_2= '->' )
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==55) ) {
                alt44=1;
            }
            else if ( (LA44_0==56) ) {
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2182:3: lv_name_0_1= '.'
                    {
                    lv_name_0_1=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleEssentialOCLNavigationOperatorCS4767); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2194:8: lv_name_0_2= '->'
                    {
                    lv_name_0_2=(Token)match(input,56,FollowSets000.FOLLOW_56_in_ruleEssentialOCLNavigationOperatorCS4796); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2217:1: entryRuleIdentifier returns [String current=null] : iv_ruleIdentifier= ruleIdentifier EOF ;
    public final String entryRuleIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdentifier = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2218:2: (iv_ruleIdentifier= ruleIdentifier EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2219:2: iv_ruleIdentifier= ruleIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIdentifierRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_entryRuleIdentifier4848);
            iv_ruleIdentifier=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIdentifier.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIdentifier4859); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2226:1: ruleIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= ruleID ;
    public final AntlrDatatypeRuleToken ruleIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_ID_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2229:28: (this_ID_0= ruleID )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2231:5: this_ID_0= ruleID
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getIdentifierAccess().getIDParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleID_in_ruleIdentifier4905);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2249:1: entryRuleStringLiteral returns [String current=null] : iv_ruleStringLiteral= ruleStringLiteral EOF ;
    public final String entryRuleStringLiteral() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleStringLiteral = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2250:2: (iv_ruleStringLiteral= ruleStringLiteral EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2251:2: iv_ruleStringLiteral= ruleStringLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStringLiteralRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral4950);
            iv_ruleStringLiteral=ruleStringLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStringLiteral.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleStringLiteral4961); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2258:1: ruleStringLiteral returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING ;
    public final AntlrDatatypeRuleToken ruleStringLiteral() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_SINGLE_QUOTED_STRING_0=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2261:28: (this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2262:5: this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING
            {
            this_SINGLE_QUOTED_STRING_0=(Token)match(input,RULE_SINGLE_QUOTED_STRING,FollowSets000.FOLLOW_RULE_SINGLE_QUOTED_STRING_in_ruleStringLiteral5000); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2277:1: entryRuleBinaryOperatorCS returns [EObject current=null] : iv_ruleBinaryOperatorCS= ruleBinaryOperatorCS EOF ;
    public final EObject entryRuleBinaryOperatorCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinaryOperatorCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2278:2: (iv_ruleBinaryOperatorCS= ruleBinaryOperatorCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2279:2: iv_ruleBinaryOperatorCS= ruleBinaryOperatorCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBinaryOperatorCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleBinaryOperatorCS_in_entryRuleBinaryOperatorCS5044);
            iv_ruleBinaryOperatorCS=ruleBinaryOperatorCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBinaryOperatorCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBinaryOperatorCS5054); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2286:1: ruleBinaryOperatorCS returns [EObject current=null] : (this_InfixOperatorCS_0= ruleInfixOperatorCS | this_NavigationOperatorCS_1= ruleNavigationOperatorCS ) ;
    public final EObject ruleBinaryOperatorCS() throws RecognitionException {
        EObject current = null;

        EObject this_InfixOperatorCS_0 = null;

        EObject this_NavigationOperatorCS_1 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2289:28: ( (this_InfixOperatorCS_0= ruleInfixOperatorCS | this_NavigationOperatorCS_1= ruleNavigationOperatorCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2290:1: (this_InfixOperatorCS_0= ruleInfixOperatorCS | this_NavigationOperatorCS_1= ruleNavigationOperatorCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2290:1: (this_InfixOperatorCS_0= ruleInfixOperatorCS | this_NavigationOperatorCS_1= ruleNavigationOperatorCS )
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==32||LA45_0==41||(LA45_0>=43 && LA45_0<=54)) ) {
                alt45=1;
            }
            else if ( ((LA45_0>=55 && LA45_0<=56)) ) {
                alt45=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }
            switch (alt45) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2291:2: this_InfixOperatorCS_0= ruleInfixOperatorCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBinaryOperatorCSAccess().getInfixOperatorCSParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleInfixOperatorCS_in_ruleBinaryOperatorCS5104);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2304:2: this_NavigationOperatorCS_1= ruleNavigationOperatorCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBinaryOperatorCSAccess().getNavigationOperatorCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNavigationOperatorCS_in_ruleBinaryOperatorCS5134);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2323:1: entryRuleInfixOperatorCS returns [EObject current=null] : iv_ruleInfixOperatorCS= ruleInfixOperatorCS EOF ;
    public final EObject entryRuleInfixOperatorCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInfixOperatorCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2324:2: (iv_ruleInfixOperatorCS= ruleInfixOperatorCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2325:2: iv_ruleInfixOperatorCS= ruleInfixOperatorCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInfixOperatorCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleInfixOperatorCS_in_entryRuleInfixOperatorCS5169);
            iv_ruleInfixOperatorCS=ruleInfixOperatorCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInfixOperatorCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleInfixOperatorCS5179); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2332:1: ruleInfixOperatorCS returns [EObject current=null] : this_EssentialOCLInfixOperatorCS_0= ruleEssentialOCLInfixOperatorCS ;
    public final EObject ruleInfixOperatorCS() throws RecognitionException {
        EObject current = null;

        EObject this_EssentialOCLInfixOperatorCS_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2335:28: (this_EssentialOCLInfixOperatorCS_0= ruleEssentialOCLInfixOperatorCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2337:2: this_EssentialOCLInfixOperatorCS_0= ruleEssentialOCLInfixOperatorCS
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getInfixOperatorCSAccess().getEssentialOCLInfixOperatorCSParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLInfixOperatorCS_in_ruleInfixOperatorCS5228);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2356:1: entryRuleNavigationOperatorCS returns [EObject current=null] : iv_ruleNavigationOperatorCS= ruleNavigationOperatorCS EOF ;
    public final EObject entryRuleNavigationOperatorCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigationOperatorCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2357:2: (iv_ruleNavigationOperatorCS= ruleNavigationOperatorCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2358:2: iv_ruleNavigationOperatorCS= ruleNavigationOperatorCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigationOperatorCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigationOperatorCS_in_entryRuleNavigationOperatorCS5262);
            iv_ruleNavigationOperatorCS=ruleNavigationOperatorCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigationOperatorCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigationOperatorCS5272); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2365:1: ruleNavigationOperatorCS returns [EObject current=null] : this_EssentialOCLNavigationOperatorCS_0= ruleEssentialOCLNavigationOperatorCS ;
    public final EObject ruleNavigationOperatorCS() throws RecognitionException {
        EObject current = null;

        EObject this_EssentialOCLNavigationOperatorCS_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2368:28: (this_EssentialOCLNavigationOperatorCS_0= ruleEssentialOCLNavigationOperatorCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2370:2: this_EssentialOCLNavigationOperatorCS_0= ruleEssentialOCLNavigationOperatorCS
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getNavigationOperatorCSAccess().getEssentialOCLNavigationOperatorCSParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLNavigationOperatorCS_in_ruleNavigationOperatorCS5321);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2389:1: entryRuleUnaryOperatorCS returns [EObject current=null] : iv_ruleUnaryOperatorCS= ruleUnaryOperatorCS EOF ;
    public final EObject entryRuleUnaryOperatorCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryOperatorCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2390:2: (iv_ruleUnaryOperatorCS= ruleUnaryOperatorCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2391:2: iv_ruleUnaryOperatorCS= ruleUnaryOperatorCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryOperatorCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnaryOperatorCS_in_entryRuleUnaryOperatorCS5355);
            iv_ruleUnaryOperatorCS=ruleUnaryOperatorCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnaryOperatorCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnaryOperatorCS5365); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2398:1: ruleUnaryOperatorCS returns [EObject current=null] : this_EssentialOCLUnaryOperatorCS_0= ruleEssentialOCLUnaryOperatorCS ;
    public final EObject ruleUnaryOperatorCS() throws RecognitionException {
        EObject current = null;

        EObject this_EssentialOCLUnaryOperatorCS_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2401:28: (this_EssentialOCLUnaryOperatorCS_0= ruleEssentialOCLUnaryOperatorCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2403:2: this_EssentialOCLUnaryOperatorCS_0= ruleEssentialOCLUnaryOperatorCS
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getUnaryOperatorCSAccess().getEssentialOCLUnaryOperatorCSParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLUnaryOperatorCS_in_ruleUnaryOperatorCS5414);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2422:1: entryRuleEssentialOCLUnrestrictedName returns [String current=null] : iv_ruleEssentialOCLUnrestrictedName= ruleEssentialOCLUnrestrictedName EOF ;
    public final String entryRuleEssentialOCLUnrestrictedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEssentialOCLUnrestrictedName = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2423:2: (iv_ruleEssentialOCLUnrestrictedName= ruleEssentialOCLUnrestrictedName EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2424:2: iv_ruleEssentialOCLUnrestrictedName= ruleEssentialOCLUnrestrictedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEssentialOCLUnrestrictedNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLUnrestrictedName_in_entryRuleEssentialOCLUnrestrictedName5449);
            iv_ruleEssentialOCLUnrestrictedName=ruleEssentialOCLUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEssentialOCLUnrestrictedName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEssentialOCLUnrestrictedName5460); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2431:1: ruleEssentialOCLUnrestrictedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_Identifier_0= ruleIdentifier ;
    public final AntlrDatatypeRuleToken ruleEssentialOCLUnrestrictedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_Identifier_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2434:28: (this_Identifier_0= ruleIdentifier )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2436:5: this_Identifier_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getEssentialOCLUnrestrictedNameAccess().getIdentifierParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_ruleEssentialOCLUnrestrictedName5506);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2454:1: entryRuleEssentialOCLUnreservedName returns [String current=null] : iv_ruleEssentialOCLUnreservedName= ruleEssentialOCLUnreservedName EOF ;
    public final String entryRuleEssentialOCLUnreservedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEssentialOCLUnreservedName = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2455:2: (iv_ruleEssentialOCLUnreservedName= ruleEssentialOCLUnreservedName EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2456:2: iv_ruleEssentialOCLUnreservedName= ruleEssentialOCLUnreservedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEssentialOCLUnreservedNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLUnreservedName_in_entryRuleEssentialOCLUnreservedName5551);
            iv_ruleEssentialOCLUnreservedName=ruleEssentialOCLUnreservedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEssentialOCLUnreservedName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEssentialOCLUnreservedName5562); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2463:1: ruleEssentialOCLUnreservedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_UnrestrictedName_0= ruleUnrestrictedName | this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier | this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier | kw= 'Tuple' ) ;
    public final AntlrDatatypeRuleToken ruleEssentialOCLUnreservedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_UnrestrictedName_0 = null;

        AntlrDatatypeRuleToken this_CollectionTypeIdentifier_1 = null;

        AntlrDatatypeRuleToken this_PrimitiveTypeIdentifier_2 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2466:28: ( (this_UnrestrictedName_0= ruleUnrestrictedName | this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier | this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier | kw= 'Tuple' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2467:1: (this_UnrestrictedName_0= ruleUnrestrictedName | this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier | this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier | kw= 'Tuple' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2467:1: (this_UnrestrictedName_0= ruleUnrestrictedName | this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier | this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier | kw= 'Tuple' )
            int alt46=4;
            switch ( input.LA(1) ) {
            case RULE_SIMPLE_ID:
            case RULE_ESCAPED_ID:
            case 16:
            case 18:
            case 27:
            case 28:
            case 29:
            case 33:
            case 34:
            case 35:
            case 38:
            case 39:
            case 40:
                {
                alt46=1;
                }
                break;
            case 66:
            case 67:
            case 68:
            case 69:
            case 70:
                {
                alt46=2;
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
                alt46=3;
                }
                break;
            case 57:
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2468:5: this_UnrestrictedName_0= ruleUnrestrictedName
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getEssentialOCLUnreservedNameAccess().getUnrestrictedNameParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleEssentialOCLUnreservedName5609);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2480:5: this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getEssentialOCLUnreservedNameAccess().getCollectionTypeIdentifierParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCollectionTypeIdentifier_in_ruleEssentialOCLUnreservedName5642);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2492:5: this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getEssentialOCLUnreservedNameAccess().getPrimitiveTypeIdentifierParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrimitiveTypeIdentifier_in_ruleEssentialOCLUnreservedName5675);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2504:2: kw= 'Tuple'
                    {
                    kw=(Token)match(input,57,FollowSets000.FOLLOW_57_in_ruleEssentialOCLUnreservedName5699); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2517:1: entryRuleUnreservedName returns [String current=null] : iv_ruleUnreservedName= ruleUnreservedName EOF ;
    public final String entryRuleUnreservedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnreservedName = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2518:2: (iv_ruleUnreservedName= ruleUnreservedName EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2519:2: iv_ruleUnreservedName= ruleUnreservedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnreservedNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnreservedName_in_entryRuleUnreservedName5740);
            iv_ruleUnreservedName=ruleUnreservedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnreservedName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnreservedName5751); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2526:1: ruleUnreservedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_EssentialOCLUnreservedName_0= ruleEssentialOCLUnreservedName ;
    public final AntlrDatatypeRuleToken ruleUnreservedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_EssentialOCLUnreservedName_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2529:28: (this_EssentialOCLUnreservedName_0= ruleEssentialOCLUnreservedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2531:5: this_EssentialOCLUnreservedName_0= ruleEssentialOCLUnreservedName
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getUnreservedNameAccess().getEssentialOCLUnreservedNameParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLUnreservedName_in_ruleUnreservedName5797);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2549:1: entryRulePathNameCS returns [EObject current=null] : iv_rulePathNameCS= rulePathNameCS EOF ;
    public final EObject entryRulePathNameCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePathNameCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2550:2: (iv_rulePathNameCS= rulePathNameCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2551:2: iv_rulePathNameCS= rulePathNameCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPathNameCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePathNameCS_in_entryRulePathNameCS5841);
            iv_rulePathNameCS=rulePathNameCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePathNameCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePathNameCS5851); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2558:1: rulePathNameCS returns [EObject current=null] : ( ( (lv_path_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )* ) ;
    public final EObject rulePathNameCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_path_0_0 = null;

        EObject lv_path_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2561:28: ( ( ( (lv_path_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )* ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2562:1: ( ( (lv_path_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )* )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2562:1: ( ( (lv_path_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )* )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2562:2: ( (lv_path_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )*
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2562:2: ( (lv_path_0_0= ruleFirstPathElementCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2563:1: (lv_path_0_0= ruleFirstPathElementCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2563:1: (lv_path_0_0= ruleFirstPathElementCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2564:3: lv_path_0_0= ruleFirstPathElementCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPathNameCSAccess().getPathFirstPathElementCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleFirstPathElementCS_in_rulePathNameCS5897);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2580:2: (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==31) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2580:4: otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) )
            	    {
            	    otherlv_1=(Token)match(input,31,FollowSets000.FOLLOW_31_in_rulePathNameCS5910); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getPathNameCSAccess().getColonColonKeyword_1_0());
            	          
            	    }
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2584:1: ( (lv_path_2_0= ruleNextPathElementCS ) )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2585:1: (lv_path_2_0= ruleNextPathElementCS )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2585:1: (lv_path_2_0= ruleNextPathElementCS )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2586:3: lv_path_2_0= ruleNextPathElementCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getPathNameCSAccess().getPathNextPathElementCSParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleNextPathElementCS_in_rulePathNameCS5931);
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
            	    break loop47;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2610:1: entryRuleFirstPathElementCS returns [EObject current=null] : iv_ruleFirstPathElementCS= ruleFirstPathElementCS EOF ;
    public final EObject entryRuleFirstPathElementCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFirstPathElementCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2611:2: (iv_ruleFirstPathElementCS= ruleFirstPathElementCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2612:2: iv_ruleFirstPathElementCS= ruleFirstPathElementCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFirstPathElementCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleFirstPathElementCS_in_entryRuleFirstPathElementCS5969);
            iv_ruleFirstPathElementCS=ruleFirstPathElementCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFirstPathElementCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFirstPathElementCS5979); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2619:1: ruleFirstPathElementCS returns [EObject current=null] : ( ( ruleUnrestrictedName ) ) ;
    public final EObject ruleFirstPathElementCS() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2622:28: ( ( ( ruleUnrestrictedName ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2623:1: ( ( ruleUnrestrictedName ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2623:1: ( ( ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2624:1: ( ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2624:1: ( ruleUnrestrictedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2625:3: ruleUnrestrictedName
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
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleFirstPathElementCS6030);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2649:1: entryRuleNextPathElementCS returns [EObject current=null] : iv_ruleNextPathElementCS= ruleNextPathElementCS EOF ;
    public final EObject entryRuleNextPathElementCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNextPathElementCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2650:2: (iv_ruleNextPathElementCS= ruleNextPathElementCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2651:2: iv_ruleNextPathElementCS= ruleNextPathElementCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNextPathElementCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNextPathElementCS_in_entryRuleNextPathElementCS6065);
            iv_ruleNextPathElementCS=ruleNextPathElementCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNextPathElementCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNextPathElementCS6075); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2658:1: ruleNextPathElementCS returns [EObject current=null] : ( ( ruleUnreservedName ) ) ;
    public final EObject ruleNextPathElementCS() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2661:28: ( ( ( ruleUnreservedName ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2662:1: ( ( ruleUnreservedName ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2662:1: ( ( ruleUnreservedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2663:1: ( ruleUnreservedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2663:1: ( ruleUnreservedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2664:3: ruleUnreservedName
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
            pushFollow(FollowSets000.FOLLOW_ruleUnreservedName_in_ruleNextPathElementCS6126);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2688:1: entryRuleURIPathNameCS returns [EObject current=null] : iv_ruleURIPathNameCS= ruleURIPathNameCS EOF ;
    public final EObject entryRuleURIPathNameCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleURIPathNameCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2689:2: (iv_ruleURIPathNameCS= ruleURIPathNameCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2690:2: iv_ruleURIPathNameCS= ruleURIPathNameCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getURIPathNameCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleURIPathNameCS_in_entryRuleURIPathNameCS6161);
            iv_ruleURIPathNameCS=ruleURIPathNameCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleURIPathNameCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleURIPathNameCS6171); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2697:1: ruleURIPathNameCS returns [EObject current=null] : ( ( (lv_path_0_0= ruleURIFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )* ) ;
    public final EObject ruleURIPathNameCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_path_0_0 = null;

        EObject lv_path_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2700:28: ( ( ( (lv_path_0_0= ruleURIFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )* ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2701:1: ( ( (lv_path_0_0= ruleURIFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )* )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2701:1: ( ( (lv_path_0_0= ruleURIFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )* )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2701:2: ( (lv_path_0_0= ruleURIFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )*
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2701:2: ( (lv_path_0_0= ruleURIFirstPathElementCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2702:1: (lv_path_0_0= ruleURIFirstPathElementCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2702:1: (lv_path_0_0= ruleURIFirstPathElementCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2703:3: lv_path_0_0= ruleURIFirstPathElementCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getURIPathNameCSAccess().getPathURIFirstPathElementCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleURIFirstPathElementCS_in_ruleURIPathNameCS6217);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2719:2: (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==31) ) {
                    int LA48_1 = input.LA(2);

                    if ( ((LA48_1>=RULE_SIMPLE_ID && LA48_1<=RULE_ESCAPED_ID)||LA48_1==16||LA48_1==18||(LA48_1>=27 && LA48_1<=29)||(LA48_1>=33 && LA48_1<=35)||(LA48_1>=38 && LA48_1<=40)||(LA48_1>=57 && LA48_1<=70)) ) {
                        alt48=1;
                    }


                }


                switch (alt48) {
            	case 1 :
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2719:4: otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) )
            	    {
            	    otherlv_1=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleURIPathNameCS6230); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getURIPathNameCSAccess().getColonColonKeyword_1_0());
            	          
            	    }
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2723:1: ( (lv_path_2_0= ruleNextPathElementCS ) )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2724:1: (lv_path_2_0= ruleNextPathElementCS )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2724:1: (lv_path_2_0= ruleNextPathElementCS )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2725:3: lv_path_2_0= ruleNextPathElementCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getURIPathNameCSAccess().getPathNextPathElementCSParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleNextPathElementCS_in_ruleURIPathNameCS6251);
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
            	    break loop48;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2749:1: entryRuleURIFirstPathElementCS returns [EObject current=null] : iv_ruleURIFirstPathElementCS= ruleURIFirstPathElementCS EOF ;
    public final EObject entryRuleURIFirstPathElementCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleURIFirstPathElementCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2750:2: (iv_ruleURIFirstPathElementCS= ruleURIFirstPathElementCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2751:2: iv_ruleURIFirstPathElementCS= ruleURIFirstPathElementCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getURIFirstPathElementCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleURIFirstPathElementCS_in_entryRuleURIFirstPathElementCS6289);
            iv_ruleURIFirstPathElementCS=ruleURIFirstPathElementCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleURIFirstPathElementCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleURIFirstPathElementCS6299); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2758:1: ruleURIFirstPathElementCS returns [EObject current=null] : ( ( ( ruleUnrestrictedName ) ) | ( () ( ( ruleURI ) ) ) ) ;
    public final EObject ruleURIFirstPathElementCS() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2761:28: ( ( ( ( ruleUnrestrictedName ) ) | ( () ( ( ruleURI ) ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2762:1: ( ( ( ruleUnrestrictedName ) ) | ( () ( ( ruleURI ) ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2762:1: ( ( ( ruleUnrestrictedName ) ) | ( () ( ( ruleURI ) ) ) )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( ((LA49_0>=RULE_SIMPLE_ID && LA49_0<=RULE_ESCAPED_ID)||LA49_0==16||LA49_0==18||(LA49_0>=27 && LA49_0<=29)||(LA49_0>=33 && LA49_0<=35)||(LA49_0>=38 && LA49_0<=40)) ) {
                alt49=1;
            }
            else if ( (LA49_0==RULE_SINGLE_QUOTED_STRING) ) {
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2762:2: ( ( ruleUnrestrictedName ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2762:2: ( ( ruleUnrestrictedName ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2763:1: ( ruleUnrestrictedName )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2763:1: ( ruleUnrestrictedName )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2764:3: ruleUnrestrictedName
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
                    pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleURIFirstPathElementCS6351);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2781:6: ( () ( ( ruleURI ) ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2781:6: ( () ( ( ruleURI ) ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2781:7: () ( ( ruleURI ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2781:7: ()
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2782:2: 
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

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2790:2: ( ( ruleURI ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2791:1: ( ruleURI )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2791:1: ( ruleURI )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2792:3: ruleURI
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
                    pushFollow(FollowSets000.FOLLOW_ruleURI_in_ruleURIFirstPathElementCS6397);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2816:1: entryRulePrimitiveTypeIdentifier returns [String current=null] : iv_rulePrimitiveTypeIdentifier= rulePrimitiveTypeIdentifier EOF ;
    public final String entryRulePrimitiveTypeIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePrimitiveTypeIdentifier = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2817:2: (iv_rulePrimitiveTypeIdentifier= rulePrimitiveTypeIdentifier EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2818:2: iv_rulePrimitiveTypeIdentifier= rulePrimitiveTypeIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimitiveTypeIdentifierRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePrimitiveTypeIdentifier_in_entryRulePrimitiveTypeIdentifier6435);
            iv_rulePrimitiveTypeIdentifier=rulePrimitiveTypeIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimitiveTypeIdentifier.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrimitiveTypeIdentifier6446); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2825:1: rulePrimitiveTypeIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Boolean' | kw= 'Integer' | kw= 'Real' | kw= 'String' | kw= 'UnlimitedNatural' | kw= 'OclAny' | kw= 'OclInvalid' | kw= 'OclVoid' ) ;
    public final AntlrDatatypeRuleToken rulePrimitiveTypeIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2828:28: ( (kw= 'Boolean' | kw= 'Integer' | kw= 'Real' | kw= 'String' | kw= 'UnlimitedNatural' | kw= 'OclAny' | kw= 'OclInvalid' | kw= 'OclVoid' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2829:1: (kw= 'Boolean' | kw= 'Integer' | kw= 'Real' | kw= 'String' | kw= 'UnlimitedNatural' | kw= 'OclAny' | kw= 'OclInvalid' | kw= 'OclVoid' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2829:1: (kw= 'Boolean' | kw= 'Integer' | kw= 'Real' | kw= 'String' | kw= 'UnlimitedNatural' | kw= 'OclAny' | kw= 'OclInvalid' | kw= 'OclVoid' )
            int alt50=8;
            switch ( input.LA(1) ) {
            case 58:
                {
                alt50=1;
                }
                break;
            case 59:
                {
                alt50=2;
                }
                break;
            case 60:
                {
                alt50=3;
                }
                break;
            case 61:
                {
                alt50=4;
                }
                break;
            case 62:
                {
                alt50=5;
                }
                break;
            case 63:
                {
                alt50=6;
                }
                break;
            case 64:
                {
                alt50=7;
                }
                break;
            case 65:
                {
                alt50=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }

            switch (alt50) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2830:2: kw= 'Boolean'
                    {
                    kw=(Token)match(input,58,FollowSets000.FOLLOW_58_in_rulePrimitiveTypeIdentifier6484); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getBooleanKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2837:2: kw= 'Integer'
                    {
                    kw=(Token)match(input,59,FollowSets000.FOLLOW_59_in_rulePrimitiveTypeIdentifier6503); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getIntegerKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2844:2: kw= 'Real'
                    {
                    kw=(Token)match(input,60,FollowSets000.FOLLOW_60_in_rulePrimitiveTypeIdentifier6522); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getRealKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2851:2: kw= 'String'
                    {
                    kw=(Token)match(input,61,FollowSets000.FOLLOW_61_in_rulePrimitiveTypeIdentifier6541); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getStringKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2858:2: kw= 'UnlimitedNatural'
                    {
                    kw=(Token)match(input,62,FollowSets000.FOLLOW_62_in_rulePrimitiveTypeIdentifier6560); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getUnlimitedNaturalKeyword_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2865:2: kw= 'OclAny'
                    {
                    kw=(Token)match(input,63,FollowSets000.FOLLOW_63_in_rulePrimitiveTypeIdentifier6579); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getOclAnyKeyword_5()); 
                          
                    }

                    }
                    break;
                case 7 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2872:2: kw= 'OclInvalid'
                    {
                    kw=(Token)match(input,64,FollowSets000.FOLLOW_64_in_rulePrimitiveTypeIdentifier6598); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getOclInvalidKeyword_6()); 
                          
                    }

                    }
                    break;
                case 8 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2879:2: kw= 'OclVoid'
                    {
                    kw=(Token)match(input,65,FollowSets000.FOLLOW_65_in_rulePrimitiveTypeIdentifier6617); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2892:1: entryRulePrimitiveTypeCS returns [EObject current=null] : iv_rulePrimitiveTypeCS= rulePrimitiveTypeCS EOF ;
    public final EObject entryRulePrimitiveTypeCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveTypeCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2893:2: (iv_rulePrimitiveTypeCS= rulePrimitiveTypeCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2894:2: iv_rulePrimitiveTypeCS= rulePrimitiveTypeCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimitiveTypeCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePrimitiveTypeCS_in_entryRulePrimitiveTypeCS6657);
            iv_rulePrimitiveTypeCS=rulePrimitiveTypeCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimitiveTypeCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrimitiveTypeCS6667); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2901:1: rulePrimitiveTypeCS returns [EObject current=null] : ( (lv_name_0_0= rulePrimitiveTypeIdentifier ) ) ;
    public final EObject rulePrimitiveTypeCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2904:28: ( ( (lv_name_0_0= rulePrimitiveTypeIdentifier ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2905:1: ( (lv_name_0_0= rulePrimitiveTypeIdentifier ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2905:1: ( (lv_name_0_0= rulePrimitiveTypeIdentifier ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2906:1: (lv_name_0_0= rulePrimitiveTypeIdentifier )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2906:1: (lv_name_0_0= rulePrimitiveTypeIdentifier )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2907:3: lv_name_0_0= rulePrimitiveTypeIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPrimitiveTypeCSAccess().getNamePrimitiveTypeIdentifierParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_rulePrimitiveTypeIdentifier_in_rulePrimitiveTypeCS6712);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2931:1: entryRuleCollectionTypeIdentifier returns [String current=null] : iv_ruleCollectionTypeIdentifier= ruleCollectionTypeIdentifier EOF ;
    public final String entryRuleCollectionTypeIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleCollectionTypeIdentifier = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2932:2: (iv_ruleCollectionTypeIdentifier= ruleCollectionTypeIdentifier EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2933:2: iv_ruleCollectionTypeIdentifier= ruleCollectionTypeIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCollectionTypeIdentifierRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleCollectionTypeIdentifier_in_entryRuleCollectionTypeIdentifier6748);
            iv_ruleCollectionTypeIdentifier=ruleCollectionTypeIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCollectionTypeIdentifier.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCollectionTypeIdentifier6759); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2940:1: ruleCollectionTypeIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Set' | kw= 'Bag' | kw= 'Sequence' | kw= 'Collection' | kw= 'OrderedSet' ) ;
    public final AntlrDatatypeRuleToken ruleCollectionTypeIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2943:28: ( (kw= 'Set' | kw= 'Bag' | kw= 'Sequence' | kw= 'Collection' | kw= 'OrderedSet' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2944:1: (kw= 'Set' | kw= 'Bag' | kw= 'Sequence' | kw= 'Collection' | kw= 'OrderedSet' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2944:1: (kw= 'Set' | kw= 'Bag' | kw= 'Sequence' | kw= 'Collection' | kw= 'OrderedSet' )
            int alt51=5;
            switch ( input.LA(1) ) {
            case 66:
                {
                alt51=1;
                }
                break;
            case 67:
                {
                alt51=2;
                }
                break;
            case 68:
                {
                alt51=3;
                }
                break;
            case 69:
                {
                alt51=4;
                }
                break;
            case 70:
                {
                alt51=5;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2945:2: kw= 'Set'
                    {
                    kw=(Token)match(input,66,FollowSets000.FOLLOW_66_in_ruleCollectionTypeIdentifier6797); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getSetKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2952:2: kw= 'Bag'
                    {
                    kw=(Token)match(input,67,FollowSets000.FOLLOW_67_in_ruleCollectionTypeIdentifier6816); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getBagKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2959:2: kw= 'Sequence'
                    {
                    kw=(Token)match(input,68,FollowSets000.FOLLOW_68_in_ruleCollectionTypeIdentifier6835); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getSequenceKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2966:2: kw= 'Collection'
                    {
                    kw=(Token)match(input,69,FollowSets000.FOLLOW_69_in_ruleCollectionTypeIdentifier6854); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getCollectionKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2973:2: kw= 'OrderedSet'
                    {
                    kw=(Token)match(input,70,FollowSets000.FOLLOW_70_in_ruleCollectionTypeIdentifier6873); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2986:1: entryRuleCollectionTypeCS returns [EObject current=null] : iv_ruleCollectionTypeCS= ruleCollectionTypeCS EOF ;
    public final EObject entryRuleCollectionTypeCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionTypeCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2987:2: (iv_ruleCollectionTypeCS= ruleCollectionTypeCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2988:2: iv_ruleCollectionTypeCS= ruleCollectionTypeCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCollectionTypeCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleCollectionTypeCS_in_entryRuleCollectionTypeCS6913);
            iv_ruleCollectionTypeCS=ruleCollectionTypeCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCollectionTypeCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCollectionTypeCS6923); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2995:1: ruleCollectionTypeCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )? ) ;
    public final EObject ruleCollectionTypeCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2998:28: ( ( ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2999:1: ( ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2999:1: ( ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2999:2: ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )?
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:2999:2: ( (lv_name_0_0= ruleCollectionTypeIdentifier ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3000:1: (lv_name_0_0= ruleCollectionTypeIdentifier )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3000:1: (lv_name_0_0= ruleCollectionTypeIdentifier )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3001:3: lv_name_0_0= ruleCollectionTypeIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCollectionTypeCSAccess().getNameCollectionTypeIdentifierParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleCollectionTypeIdentifier_in_ruleCollectionTypeCS6969);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3017:2: (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==36) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3017:4: otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleCollectionTypeCS6982); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getCollectionTypeCSAccess().getLeftParenthesisKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3021:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3022:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3022:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3023:3: lv_ownedType_2_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionTypeCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleCollectionTypeCS7003);
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

                    otherlv_3=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleCollectionTypeCS7015); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3051:1: entryRuleMultiplicityBoundsCS returns [EObject current=null] : iv_ruleMultiplicityBoundsCS= ruleMultiplicityBoundsCS EOF ;
    public final EObject entryRuleMultiplicityBoundsCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicityBoundsCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3052:2: (iv_ruleMultiplicityBoundsCS= ruleMultiplicityBoundsCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3053:2: iv_ruleMultiplicityBoundsCS= ruleMultiplicityBoundsCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicityBoundsCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMultiplicityBoundsCS_in_entryRuleMultiplicityBoundsCS7053);
            iv_ruleMultiplicityBoundsCS=ruleMultiplicityBoundsCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicityBoundsCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMultiplicityBoundsCS7063); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3060:1: ruleMultiplicityBoundsCS returns [EObject current=null] : ( ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )? ) ;
    public final EObject ruleMultiplicityBoundsCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_lowerBound_0_0 = null;

        AntlrDatatypeRuleToken lv_upperBound_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3063:28: ( ( ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3064:1: ( ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3064:1: ( ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3064:2: ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )?
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3064:2: ( (lv_lowerBound_0_0= ruleLOWER ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3065:1: (lv_lowerBound_0_0= ruleLOWER )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3065:1: (lv_lowerBound_0_0= ruleLOWER )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3066:3: lv_lowerBound_0_0= ruleLOWER
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiplicityBoundsCSAccess().getLowerBoundLOWERParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleLOWER_in_ruleMultiplicityBoundsCS7109);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3082:2: (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==71) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3082:4: otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) )
                    {
                    otherlv_1=(Token)match(input,71,FollowSets000.FOLLOW_71_in_ruleMultiplicityBoundsCS7122); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getMultiplicityBoundsCSAccess().getFullStopFullStopKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3086:1: ( (lv_upperBound_2_0= ruleUPPER ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3087:1: (lv_upperBound_2_0= ruleUPPER )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3087:1: (lv_upperBound_2_0= ruleUPPER )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3088:3: lv_upperBound_2_0= ruleUPPER
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMultiplicityBoundsCSAccess().getUpperBoundUPPERParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUPPER_in_ruleMultiplicityBoundsCS7143);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3112:1: entryRuleMultiplicityCS returns [EObject current=null] : iv_ruleMultiplicityCS= ruleMultiplicityCS EOF ;
    public final EObject entryRuleMultiplicityCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicityCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3113:2: (iv_ruleMultiplicityCS= ruleMultiplicityCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3114:2: iv_ruleMultiplicityCS= ruleMultiplicityCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicityCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMultiplicityCS_in_entryRuleMultiplicityCS7181);
            iv_ruleMultiplicityCS=ruleMultiplicityCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicityCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMultiplicityCS7191); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3121:1: ruleMultiplicityCS returns [EObject current=null] : (otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) otherlv_3= ']' ) ;
    public final EObject ruleMultiplicityCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        EObject this_MultiplicityBoundsCS_1 = null;

        EObject this_MultiplicityStringCS_2 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3124:28: ( (otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) otherlv_3= ']' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3125:1: (otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) otherlv_3= ']' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3125:1: (otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) otherlv_3= ']' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3125:3: otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) otherlv_3= ']'
            {
            otherlv_0=(Token)match(input,72,FollowSets000.FOLLOW_72_in_ruleMultiplicityCS7228); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMultiplicityCSAccess().getLeftSquareBracketKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3129:1: (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS )
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==RULE_INT) ) {
                alt54=1;
            }
            else if ( (LA54_0==32||LA54_0==44||LA54_0==74) ) {
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3130:2: this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getMultiplicityCSAccess().getMultiplicityBoundsCSParserRuleCall_1_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMultiplicityBoundsCS_in_ruleMultiplicityCS7254);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3143:2: this_MultiplicityStringCS_2= ruleMultiplicityStringCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getMultiplicityCSAccess().getMultiplicityStringCSParserRuleCall_1_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMultiplicityStringCS_in_ruleMultiplicityCS7284);
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

            otherlv_3=(Token)match(input,73,FollowSets000.FOLLOW_73_in_ruleMultiplicityCS7296); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3166:1: entryRuleMultiplicityStringCS returns [EObject current=null] : iv_ruleMultiplicityStringCS= ruleMultiplicityStringCS EOF ;
    public final EObject entryRuleMultiplicityStringCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicityStringCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3167:2: (iv_ruleMultiplicityStringCS= ruleMultiplicityStringCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3168:2: iv_ruleMultiplicityStringCS= ruleMultiplicityStringCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicityStringCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMultiplicityStringCS_in_entryRuleMultiplicityStringCS7332);
            iv_ruleMultiplicityStringCS=ruleMultiplicityStringCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicityStringCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMultiplicityStringCS7342); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3175:1: ruleMultiplicityStringCS returns [EObject current=null] : ( ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) ) ) ;
    public final EObject ruleMultiplicityStringCS() throws RecognitionException {
        EObject current = null;

        Token lv_stringBounds_0_1=null;
        Token lv_stringBounds_0_2=null;
        Token lv_stringBounds_0_3=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3178:28: ( ( ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3179:1: ( ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3179:1: ( ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3180:1: ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3180:1: ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3181:1: (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3181:1: (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' )
            int alt55=3;
            switch ( input.LA(1) ) {
            case 32:
                {
                alt55=1;
                }
                break;
            case 44:
                {
                alt55=2;
                }
                break;
            case 74:
                {
                alt55=3;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3182:3: lv_stringBounds_0_1= '*'
                    {
                    lv_stringBounds_0_1=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleMultiplicityStringCS7386); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3194:8: lv_stringBounds_0_2= '+'
                    {
                    lv_stringBounds_0_2=(Token)match(input,44,FollowSets000.FOLLOW_44_in_ruleMultiplicityStringCS7415); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3206:8: lv_stringBounds_0_3= '?'
                    {
                    lv_stringBounds_0_3=(Token)match(input,74,FollowSets000.FOLLOW_74_in_ruleMultiplicityStringCS7444); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3229:1: entryRuleTupleTypeCS returns [EObject current=null] : iv_ruleTupleTypeCS= ruleTupleTypeCS EOF ;
    public final EObject entryRuleTupleTypeCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTupleTypeCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3230:2: (iv_ruleTupleTypeCS= ruleTupleTypeCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3231:2: iv_ruleTupleTypeCS= ruleTupleTypeCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTupleTypeCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTupleTypeCS_in_entryRuleTupleTypeCS7495);
            iv_ruleTupleTypeCS=ruleTupleTypeCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTupleTypeCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTupleTypeCS7505); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3238:1: ruleTupleTypeCS returns [EObject current=null] : ( ( (lv_name_0_0= 'Tuple' ) ) (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )? ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3241:28: ( ( ( (lv_name_0_0= 'Tuple' ) ) (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3242:1: ( ( (lv_name_0_0= 'Tuple' ) ) (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3242:1: ( ( (lv_name_0_0= 'Tuple' ) ) (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3242:2: ( (lv_name_0_0= 'Tuple' ) ) (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )?
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3242:2: ( (lv_name_0_0= 'Tuple' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3243:1: (lv_name_0_0= 'Tuple' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3243:1: (lv_name_0_0= 'Tuple' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3244:3: lv_name_0_0= 'Tuple'
            {
            lv_name_0_0=(Token)match(input,57,FollowSets000.FOLLOW_57_in_ruleTupleTypeCS7548); if (state.failed) return current;
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3257:2: (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==36) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3257:4: otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')'
                    {
                    otherlv_1=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleTupleTypeCS7574); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getTupleTypeCSAccess().getLeftParenthesisKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3261:1: ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )?
                    int alt57=2;
                    int LA57_0 = input.LA(1);

                    if ( ((LA57_0>=RULE_SIMPLE_ID && LA57_0<=RULE_ESCAPED_ID)||LA57_0==16||LA57_0==18||(LA57_0>=27 && LA57_0<=29)||(LA57_0>=33 && LA57_0<=35)||(LA57_0>=38 && LA57_0<=40)) ) {
                        alt57=1;
                    }
                    switch (alt57) {
                        case 1 :
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3261:2: ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )*
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3261:2: ( (lv_ownedParts_2_0= ruleTuplePartCS ) )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3262:1: (lv_ownedParts_2_0= ruleTuplePartCS )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3262:1: (lv_ownedParts_2_0= ruleTuplePartCS )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3263:3: lv_ownedParts_2_0= ruleTuplePartCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getTupleTypeCSAccess().getOwnedPartsTuplePartCSParserRuleCall_1_1_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleTuplePartCS_in_ruleTupleTypeCS7596);
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

                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3279:2: (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )*
                            loop56:
                            do {
                                int alt56=2;
                                int LA56_0 = input.LA(1);

                                if ( (LA56_0==19) ) {
                                    alt56=1;
                                }


                                switch (alt56) {
                            	case 1 :
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3279:4: otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) )
                            	    {
                            	    otherlv_3=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleTupleTypeCS7609); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_3, grammarAccess.getTupleTypeCSAccess().getCommaKeyword_1_1_1_0());
                            	          
                            	    }
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3283:1: ( (lv_ownedParts_4_0= ruleTuplePartCS ) )
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3284:1: (lv_ownedParts_4_0= ruleTuplePartCS )
                            	    {
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3284:1: (lv_ownedParts_4_0= ruleTuplePartCS )
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3285:3: lv_ownedParts_4_0= ruleTuplePartCS
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getTupleTypeCSAccess().getOwnedPartsTuplePartCSParserRuleCall_1_1_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FollowSets000.FOLLOW_ruleTuplePartCS_in_ruleTupleTypeCS7630);
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
                            	    break loop56;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_5=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleTupleTypeCS7646); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3313:1: entryRuleTuplePartCS returns [EObject current=null] : iv_ruleTuplePartCS= ruleTuplePartCS EOF ;
    public final EObject entryRuleTuplePartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTuplePartCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3314:2: (iv_ruleTuplePartCS= ruleTuplePartCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3315:2: iv_ruleTuplePartCS= ruleTuplePartCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTuplePartCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTuplePartCS_in_entryRuleTuplePartCS7684);
            iv_ruleTuplePartCS=ruleTuplePartCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTuplePartCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTuplePartCS7694); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3322:1: ruleTuplePartCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) ) ;
    public final EObject ruleTuplePartCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3325:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3326:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3326:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3326:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3326:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3327:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3327:1: (lv_name_0_0= ruleUnrestrictedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3328:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTuplePartCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleTuplePartCS7740);
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

            otherlv_1=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleTuplePartCS7752); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getTuplePartCSAccess().getColonKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3348:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3349:1: (lv_ownedType_2_0= ruleTypeExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3349:1: (lv_ownedType_2_0= ruleTypeExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3350:3: lv_ownedType_2_0= ruleTypeExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTuplePartCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleTuplePartCS7773);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3374:1: entryRuleCollectionLiteralExpCS returns [EObject current=null] : iv_ruleCollectionLiteralExpCS= ruleCollectionLiteralExpCS EOF ;
    public final EObject entryRuleCollectionLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3375:2: (iv_ruleCollectionLiteralExpCS= ruleCollectionLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3376:2: iv_ruleCollectionLiteralExpCS= ruleCollectionLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCollectionLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteralExpCS_in_entryRuleCollectionLiteralExpCS7809);
            iv_ruleCollectionLiteralExpCS=ruleCollectionLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCollectionLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCollectionLiteralExpCS7819); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3383:1: ruleCollectionLiteralExpCS returns [EObject current=null] : ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}' ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3386:28: ( ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3387:1: ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3387:1: ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3387:2: ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}'
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3387:2: ( (lv_ownedType_0_0= ruleCollectionTypeCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3388:1: (lv_ownedType_0_0= ruleCollectionTypeCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3388:1: (lv_ownedType_0_0= ruleCollectionTypeCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3389:3: lv_ownedType_0_0= ruleCollectionTypeCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedTypeCollectionTypeCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleCollectionTypeCS_in_ruleCollectionLiteralExpCS7865);
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

            otherlv_1=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleCollectionLiteralExpCS7877); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getCollectionLiteralExpCSAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3409:1: ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( ((LA60_0>=RULE_SIMPLE_ID && LA60_0<=RULE_SINGLE_QUOTED_STRING)||LA60_0==16||LA60_0==18||(LA60_0>=27 && LA60_0<=29)||(LA60_0>=32 && LA60_0<=36)||(LA60_0>=38 && LA60_0<=42)||(LA60_0>=57 && LA60_0<=70)||(LA60_0>=75 && LA60_0<=78)||LA60_0==81||(LA60_0>=85 && LA60_0<=86)) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3409:2: ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )*
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3409:2: ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3410:1: (lv_ownedParts_2_0= ruleCollectionLiteralPartCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3410:1: (lv_ownedParts_2_0= ruleCollectionLiteralPartCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3411:3: lv_ownedParts_2_0= ruleCollectionLiteralPartCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedPartsCollectionLiteralPartCSParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteralPartCS_in_ruleCollectionLiteralExpCS7899);
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

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3427:2: (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )*
                    loop59:
                    do {
                        int alt59=2;
                        int LA59_0 = input.LA(1);

                        if ( (LA59_0==19) ) {
                            alt59=1;
                        }


                        switch (alt59) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3427:4: otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) )
                    	    {
                    	    otherlv_3=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleCollectionLiteralExpCS7912); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getCollectionLiteralExpCSAccess().getCommaKeyword_2_1_0());
                    	          
                    	    }
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3431:1: ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3432:1: (lv_ownedParts_4_0= ruleCollectionLiteralPartCS )
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3432:1: (lv_ownedParts_4_0= ruleCollectionLiteralPartCS )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3433:3: lv_ownedParts_4_0= ruleCollectionLiteralPartCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedPartsCollectionLiteralPartCSParserRuleCall_2_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteralPartCS_in_ruleCollectionLiteralExpCS7933);
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
                    	    break loop59;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleCollectionLiteralExpCS7949); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3461:1: entryRuleCollectionLiteralPartCS returns [EObject current=null] : iv_ruleCollectionLiteralPartCS= ruleCollectionLiteralPartCS EOF ;
    public final EObject entryRuleCollectionLiteralPartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionLiteralPartCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3462:2: (iv_ruleCollectionLiteralPartCS= ruleCollectionLiteralPartCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3463:2: iv_ruleCollectionLiteralPartCS= ruleCollectionLiteralPartCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCollectionLiteralPartCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteralPartCS_in_entryRuleCollectionLiteralPartCS7985);
            iv_ruleCollectionLiteralPartCS=ruleCollectionLiteralPartCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCollectionLiteralPartCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCollectionLiteralPartCS7995); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3470:1: ruleCollectionLiteralPartCS returns [EObject current=null] : ( ( (lv_expressionCS_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_lastExpressionCS_2_0= ruleExpCS ) ) )? ) ;
    public final EObject ruleCollectionLiteralPartCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expressionCS_0_0 = null;

        EObject lv_lastExpressionCS_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3473:28: ( ( ( (lv_expressionCS_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_lastExpressionCS_2_0= ruleExpCS ) ) )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3474:1: ( ( (lv_expressionCS_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_lastExpressionCS_2_0= ruleExpCS ) ) )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3474:1: ( ( (lv_expressionCS_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_lastExpressionCS_2_0= ruleExpCS ) ) )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3474:2: ( (lv_expressionCS_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_lastExpressionCS_2_0= ruleExpCS ) ) )?
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3474:2: ( (lv_expressionCS_0_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3475:1: (lv_expressionCS_0_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3475:1: (lv_expressionCS_0_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3476:3: lv_expressionCS_0_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCollectionLiteralPartCSAccess().getExpressionCSExpCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleCollectionLiteralPartCS8041);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3492:2: (otherlv_1= '..' ( (lv_lastExpressionCS_2_0= ruleExpCS ) ) )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==71) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3492:4: otherlv_1= '..' ( (lv_lastExpressionCS_2_0= ruleExpCS ) )
                    {
                    otherlv_1=(Token)match(input,71,FollowSets000.FOLLOW_71_in_ruleCollectionLiteralPartCS8054); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getCollectionLiteralPartCSAccess().getFullStopFullStopKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3496:1: ( (lv_lastExpressionCS_2_0= ruleExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3497:1: (lv_lastExpressionCS_2_0= ruleExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3497:1: (lv_lastExpressionCS_2_0= ruleExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3498:3: lv_lastExpressionCS_2_0= ruleExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionLiteralPartCSAccess().getLastExpressionCSExpCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleCollectionLiteralPartCS8075);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3522:1: entryRuleConstructorPartCS returns [EObject current=null] : iv_ruleConstructorPartCS= ruleConstructorPartCS EOF ;
    public final EObject entryRuleConstructorPartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstructorPartCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3523:2: (iv_ruleConstructorPartCS= ruleConstructorPartCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3524:2: iv_ruleConstructorPartCS= ruleConstructorPartCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstructorPartCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleConstructorPartCS_in_entryRuleConstructorPartCS8113);
            iv_ruleConstructorPartCS=ruleConstructorPartCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConstructorPartCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleConstructorPartCS8123); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3531:1: ruleConstructorPartCS returns [EObject current=null] : ( ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( (lv_initExpression_2_0= ruleExpCS ) ) ) ;
    public final EObject ruleConstructorPartCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_initExpression_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3534:28: ( ( ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( (lv_initExpression_2_0= ruleExpCS ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3535:1: ( ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( (lv_initExpression_2_0= ruleExpCS ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3535:1: ( ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( (lv_initExpression_2_0= ruleExpCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3535:2: ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( (lv_initExpression_2_0= ruleExpCS ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3535:2: ( ( ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3536:1: ( ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3536:1: ( ruleUnrestrictedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3537:3: ruleUnrestrictedName
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
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleConstructorPartCS8175);
            ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,49,FollowSets000.FOLLOW_49_in_ruleConstructorPartCS8187); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getConstructorPartCSAccess().getEqualsSignKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3557:1: ( (lv_initExpression_2_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3558:1: (lv_initExpression_2_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3558:1: (lv_initExpression_2_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3559:3: lv_initExpression_2_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getConstructorPartCSAccess().getInitExpressionExpCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleConstructorPartCS8208);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3583:1: entryRulePrimitiveLiteralExpCS returns [EObject current=null] : iv_rulePrimitiveLiteralExpCS= rulePrimitiveLiteralExpCS EOF ;
    public final EObject entryRulePrimitiveLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3584:2: (iv_rulePrimitiveLiteralExpCS= rulePrimitiveLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3585:2: iv_rulePrimitiveLiteralExpCS= rulePrimitiveLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePrimitiveLiteralExpCS_in_entryRulePrimitiveLiteralExpCS8244);
            iv_rulePrimitiveLiteralExpCS=rulePrimitiveLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimitiveLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrimitiveLiteralExpCS8254); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3592:1: rulePrimitiveLiteralExpCS returns [EObject current=null] : (this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS | this_StringLiteralExpCS_1= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_5= ruleNullLiteralExpCS ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3595:28: ( (this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS | this_StringLiteralExpCS_1= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_5= ruleNullLiteralExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3596:1: (this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS | this_StringLiteralExpCS_1= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_5= ruleNullLiteralExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3596:1: (this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS | this_StringLiteralExpCS_1= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_5= ruleNullLiteralExpCS )
            int alt62=6;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt62=1;
                }
                break;
            case RULE_SINGLE_QUOTED_STRING:
                {
                alt62=2;
                }
                break;
            case 75:
            case 76:
                {
                alt62=3;
                }
                break;
            case 32:
                {
                alt62=4;
                }
                break;
            case 77:
                {
                alt62=5;
                }
                break;
            case 78:
                {
                alt62=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 62, 0, input);

                throw nvae;
            }

            switch (alt62) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3597:2: this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getNumberLiteralExpCSParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNumberLiteralExpCS_in_rulePrimitiveLiteralExpCS8304);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3610:2: this_StringLiteralExpCS_1= ruleStringLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getStringLiteralExpCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleStringLiteralExpCS_in_rulePrimitiveLiteralExpCS8334);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3623:2: this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getBooleanLiteralExpCSParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleBooleanLiteralExpCS_in_rulePrimitiveLiteralExpCS8364);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3636:2: this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getUnlimitedNaturalLiteralExpCSParserRuleCall_3()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUnlimitedNaturalLiteralExpCS_in_rulePrimitiveLiteralExpCS8394);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3649:2: this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getInvalidLiteralExpCSParserRuleCall_4()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleInvalidLiteralExpCS_in_rulePrimitiveLiteralExpCS8424);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3662:2: this_NullLiteralExpCS_5= ruleNullLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getNullLiteralExpCSParserRuleCall_5()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNullLiteralExpCS_in_rulePrimitiveLiteralExpCS8454);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3681:1: entryRuleTupleLiteralExpCS returns [EObject current=null] : iv_ruleTupleLiteralExpCS= ruleTupleLiteralExpCS EOF ;
    public final EObject entryRuleTupleLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTupleLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3682:2: (iv_ruleTupleLiteralExpCS= ruleTupleLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3683:2: iv_ruleTupleLiteralExpCS= ruleTupleLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTupleLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralExpCS_in_entryRuleTupleLiteralExpCS8489);
            iv_ruleTupleLiteralExpCS=ruleTupleLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTupleLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTupleLiteralExpCS8499); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3690:1: ruleTupleLiteralExpCS returns [EObject current=null] : (otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}' ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3693:28: ( (otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3694:1: (otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3694:1: (otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3694:3: otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,57,FollowSets000.FOLLOW_57_in_ruleTupleLiteralExpCS8536); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getTupleLiteralExpCSAccess().getTupleKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleTupleLiteralExpCS8548); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getTupleLiteralExpCSAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3702:1: ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3703:1: (lv_ownedParts_2_0= ruleTupleLiteralPartCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3703:1: (lv_ownedParts_2_0= ruleTupleLiteralPartCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3704:3: lv_ownedParts_2_0= ruleTupleLiteralPartCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTupleLiteralExpCSAccess().getOwnedPartsTupleLiteralPartCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralPartCS_in_ruleTupleLiteralExpCS8569);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3720:2: (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )*
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( (LA63_0==19) ) {
                    alt63=1;
                }


                switch (alt63) {
            	case 1 :
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3720:4: otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) )
            	    {
            	    otherlv_3=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleTupleLiteralExpCS8582); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getTupleLiteralExpCSAccess().getCommaKeyword_3_0());
            	          
            	    }
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3724:1: ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3725:1: (lv_ownedParts_4_0= ruleTupleLiteralPartCS )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3725:1: (lv_ownedParts_4_0= ruleTupleLiteralPartCS )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3726:3: lv_ownedParts_4_0= ruleTupleLiteralPartCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTupleLiteralExpCSAccess().getOwnedPartsTupleLiteralPartCSParserRuleCall_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralPartCS_in_ruleTupleLiteralExpCS8603);
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
            	    break loop63;
                }
            } while (true);

            otherlv_5=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleTupleLiteralExpCS8617); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3754:1: entryRuleTupleLiteralPartCS returns [EObject current=null] : iv_ruleTupleLiteralPartCS= ruleTupleLiteralPartCS EOF ;
    public final EObject entryRuleTupleLiteralPartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTupleLiteralPartCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3755:2: (iv_ruleTupleLiteralPartCS= ruleTupleLiteralPartCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3756:2: iv_ruleTupleLiteralPartCS= ruleTupleLiteralPartCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTupleLiteralPartCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralPartCS_in_entryRuleTupleLiteralPartCS8653);
            iv_ruleTupleLiteralPartCS=ruleTupleLiteralPartCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTupleLiteralPartCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTupleLiteralPartCS8663); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3763:1: ruleTupleLiteralPartCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) ) ) ;
    public final EObject ruleTupleLiteralPartCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;

        EObject lv_initExpression_4_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3766:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3767:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3767:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3767:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3767:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3768:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3768:1: (lv_name_0_0= ruleUnrestrictedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3769:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTupleLiteralPartCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleTupleLiteralPartCS8709);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3785:2: (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==30) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3785:4: otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                    {
                    otherlv_1=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleTupleLiteralPartCS8722); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getTupleLiteralPartCSAccess().getColonKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3789:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3790:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3790:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3791:3: lv_ownedType_2_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTupleLiteralPartCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleTupleLiteralPartCS8743);
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

            otherlv_3=(Token)match(input,49,FollowSets000.FOLLOW_49_in_ruleTupleLiteralPartCS8757); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getTupleLiteralPartCSAccess().getEqualsSignKeyword_2());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3811:1: ( (lv_initExpression_4_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3812:1: (lv_initExpression_4_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3812:1: (lv_initExpression_4_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3813:3: lv_initExpression_4_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTupleLiteralPartCSAccess().getInitExpressionExpCSParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleTupleLiteralPartCS8778);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3837:1: entryRuleNumberLiteralExpCS returns [EObject current=null] : iv_ruleNumberLiteralExpCS= ruleNumberLiteralExpCS EOF ;
    public final EObject entryRuleNumberLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3838:2: (iv_ruleNumberLiteralExpCS= ruleNumberLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3839:2: iv_ruleNumberLiteralExpCS= ruleNumberLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumberLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNumberLiteralExpCS_in_entryRuleNumberLiteralExpCS8814);
            iv_ruleNumberLiteralExpCS=ruleNumberLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumberLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNumberLiteralExpCS8824); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3846:1: ruleNumberLiteralExpCS returns [EObject current=null] : ( (lv_name_0_0= ruleNUMBER_LITERAL ) ) ;
    public final EObject ruleNumberLiteralExpCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3849:28: ( ( (lv_name_0_0= ruleNUMBER_LITERAL ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3850:1: ( (lv_name_0_0= ruleNUMBER_LITERAL ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3850:1: ( (lv_name_0_0= ruleNUMBER_LITERAL ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3851:1: (lv_name_0_0= ruleNUMBER_LITERAL )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3851:1: (lv_name_0_0= ruleNUMBER_LITERAL )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3852:3: lv_name_0_0= ruleNUMBER_LITERAL
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNumberLiteralExpCSAccess().getNameNUMBER_LITERALParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleNUMBER_LITERAL_in_ruleNumberLiteralExpCS8869);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3876:1: entryRuleStringLiteralExpCS returns [EObject current=null] : iv_ruleStringLiteralExpCS= ruleStringLiteralExpCS EOF ;
    public final EObject entryRuleStringLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3877:2: (iv_ruleStringLiteralExpCS= ruleStringLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3878:2: iv_ruleStringLiteralExpCS= ruleStringLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStringLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleStringLiteralExpCS_in_entryRuleStringLiteralExpCS8904);
            iv_ruleStringLiteralExpCS=ruleStringLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStringLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleStringLiteralExpCS8914); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3885:1: ruleStringLiteralExpCS returns [EObject current=null] : ( (lv_name_0_0= ruleStringLiteral ) )+ ;
    public final EObject ruleStringLiteralExpCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3888:28: ( ( (lv_name_0_0= ruleStringLiteral ) )+ )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3889:1: ( (lv_name_0_0= ruleStringLiteral ) )+
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3889:1: ( (lv_name_0_0= ruleStringLiteral ) )+
            int cnt65=0;
            loop65:
            do {
                int alt65=2;
                int LA65_0 = input.LA(1);

                if ( (LA65_0==RULE_SINGLE_QUOTED_STRING) ) {
                    alt65=1;
                }


                switch (alt65) {
            	case 1 :
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3890:1: (lv_name_0_0= ruleStringLiteral )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3890:1: (lv_name_0_0= ruleStringLiteral )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3891:3: lv_name_0_0= ruleStringLiteral
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getStringLiteralExpCSAccess().getNameStringLiteralParserRuleCall_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleStringLiteral_in_ruleStringLiteralExpCS8959);
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
            	    if ( cnt65 >= 1 ) break loop65;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(65, input);
                        throw eee;
                }
                cnt65++;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3915:1: entryRuleBooleanLiteralExpCS returns [EObject current=null] : iv_ruleBooleanLiteralExpCS= ruleBooleanLiteralExpCS EOF ;
    public final EObject entryRuleBooleanLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3916:2: (iv_ruleBooleanLiteralExpCS= ruleBooleanLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3917:2: iv_ruleBooleanLiteralExpCS= ruleBooleanLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBooleanLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleBooleanLiteralExpCS_in_entryRuleBooleanLiteralExpCS8995);
            iv_ruleBooleanLiteralExpCS=ruleBooleanLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBooleanLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBooleanLiteralExpCS9005); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3924:1: ruleBooleanLiteralExpCS returns [EObject current=null] : ( ( (lv_name_0_0= 'true' ) ) | ( (lv_name_1_0= 'false' ) ) ) ;
    public final EObject ruleBooleanLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3927:28: ( ( ( (lv_name_0_0= 'true' ) ) | ( (lv_name_1_0= 'false' ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3928:1: ( ( (lv_name_0_0= 'true' ) ) | ( (lv_name_1_0= 'false' ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3928:1: ( ( (lv_name_0_0= 'true' ) ) | ( (lv_name_1_0= 'false' ) ) )
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==75) ) {
                alt66=1;
            }
            else if ( (LA66_0==76) ) {
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3928:2: ( (lv_name_0_0= 'true' ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3928:2: ( (lv_name_0_0= 'true' ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3929:1: (lv_name_0_0= 'true' )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3929:1: (lv_name_0_0= 'true' )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3930:3: lv_name_0_0= 'true'
                    {
                    lv_name_0_0=(Token)match(input,75,FollowSets000.FOLLOW_75_in_ruleBooleanLiteralExpCS9048); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3944:6: ( (lv_name_1_0= 'false' ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3944:6: ( (lv_name_1_0= 'false' ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3945:1: (lv_name_1_0= 'false' )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3945:1: (lv_name_1_0= 'false' )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3946:3: lv_name_1_0= 'false'
                    {
                    lv_name_1_0=(Token)match(input,76,FollowSets000.FOLLOW_76_in_ruleBooleanLiteralExpCS9085); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3967:1: entryRuleUnlimitedNaturalLiteralExpCS returns [EObject current=null] : iv_ruleUnlimitedNaturalLiteralExpCS= ruleUnlimitedNaturalLiteralExpCS EOF ;
    public final EObject entryRuleUnlimitedNaturalLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnlimitedNaturalLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3968:2: (iv_ruleUnlimitedNaturalLiteralExpCS= ruleUnlimitedNaturalLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3969:2: iv_ruleUnlimitedNaturalLiteralExpCS= ruleUnlimitedNaturalLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnlimitedNaturalLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnlimitedNaturalLiteralExpCS_in_entryRuleUnlimitedNaturalLiteralExpCS9134);
            iv_ruleUnlimitedNaturalLiteralExpCS=ruleUnlimitedNaturalLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnlimitedNaturalLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnlimitedNaturalLiteralExpCS9144); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3976:1: ruleUnlimitedNaturalLiteralExpCS returns [EObject current=null] : ( () otherlv_1= '*' ) ;
    public final EObject ruleUnlimitedNaturalLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3979:28: ( ( () otherlv_1= '*' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3980:1: ( () otherlv_1= '*' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3980:1: ( () otherlv_1= '*' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3980:2: () otherlv_1= '*'
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3980:2: ()
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:3981:2: 
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

            otherlv_1=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleUnlimitedNaturalLiteralExpCS9193); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4001:1: entryRuleInvalidLiteralExpCS returns [EObject current=null] : iv_ruleInvalidLiteralExpCS= ruleInvalidLiteralExpCS EOF ;
    public final EObject entryRuleInvalidLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInvalidLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4002:2: (iv_ruleInvalidLiteralExpCS= ruleInvalidLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4003:2: iv_ruleInvalidLiteralExpCS= ruleInvalidLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInvalidLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleInvalidLiteralExpCS_in_entryRuleInvalidLiteralExpCS9229);
            iv_ruleInvalidLiteralExpCS=ruleInvalidLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInvalidLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleInvalidLiteralExpCS9239); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4010:1: ruleInvalidLiteralExpCS returns [EObject current=null] : ( () otherlv_1= 'invalid' ) ;
    public final EObject ruleInvalidLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4013:28: ( ( () otherlv_1= 'invalid' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4014:1: ( () otherlv_1= 'invalid' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4014:1: ( () otherlv_1= 'invalid' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4014:2: () otherlv_1= 'invalid'
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4014:2: ()
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4015:2: 
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

            otherlv_1=(Token)match(input,77,FollowSets000.FOLLOW_77_in_ruleInvalidLiteralExpCS9288); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4035:1: entryRuleNullLiteralExpCS returns [EObject current=null] : iv_ruleNullLiteralExpCS= ruleNullLiteralExpCS EOF ;
    public final EObject entryRuleNullLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4036:2: (iv_ruleNullLiteralExpCS= ruleNullLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4037:2: iv_ruleNullLiteralExpCS= ruleNullLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNullLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNullLiteralExpCS_in_entryRuleNullLiteralExpCS9324);
            iv_ruleNullLiteralExpCS=ruleNullLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNullLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNullLiteralExpCS9334); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4044:1: ruleNullLiteralExpCS returns [EObject current=null] : ( () otherlv_1= 'null' ) ;
    public final EObject ruleNullLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4047:28: ( ( () otherlv_1= 'null' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4048:1: ( () otherlv_1= 'null' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4048:1: ( () otherlv_1= 'null' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4048:2: () otherlv_1= 'null'
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4048:2: ()
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4049:2: 
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

            otherlv_1=(Token)match(input,78,FollowSets000.FOLLOW_78_in_ruleNullLiteralExpCS9383); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4069:1: entryRuleTypeLiteralCS returns [EObject current=null] : iv_ruleTypeLiteralCS= ruleTypeLiteralCS EOF ;
    public final EObject entryRuleTypeLiteralCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeLiteralCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4070:2: (iv_ruleTypeLiteralCS= ruleTypeLiteralCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4071:2: iv_ruleTypeLiteralCS= ruleTypeLiteralCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeLiteralCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralCS_in_entryRuleTypeLiteralCS9419);
            iv_ruleTypeLiteralCS=ruleTypeLiteralCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeLiteralCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeLiteralCS9429); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4078:1: ruleTypeLiteralCS returns [EObject current=null] : (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS | this_CollectionTypeCS_1= ruleCollectionTypeCS | this_TupleTypeCS_2= ruleTupleTypeCS ) ;
    public final EObject ruleTypeLiteralCS() throws RecognitionException {
        EObject current = null;

        EObject this_PrimitiveTypeCS_0 = null;

        EObject this_CollectionTypeCS_1 = null;

        EObject this_TupleTypeCS_2 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4081:28: ( (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS | this_CollectionTypeCS_1= ruleCollectionTypeCS | this_TupleTypeCS_2= ruleTupleTypeCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4082:1: (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS | this_CollectionTypeCS_1= ruleCollectionTypeCS | this_TupleTypeCS_2= ruleTupleTypeCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4082:1: (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS | this_CollectionTypeCS_1= ruleCollectionTypeCS | this_TupleTypeCS_2= ruleTupleTypeCS )
            int alt67=3;
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
                alt67=1;
                }
                break;
            case 66:
            case 67:
            case 68:
            case 69:
            case 70:
                {
                alt67=2;
                }
                break;
            case 57:
                {
                alt67=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 67, 0, input);

                throw nvae;
            }

            switch (alt67) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4083:2: this_PrimitiveTypeCS_0= rulePrimitiveTypeCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeLiteralCSAccess().getPrimitiveTypeCSParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrimitiveTypeCS_in_ruleTypeLiteralCS9479);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4096:2: this_CollectionTypeCS_1= ruleCollectionTypeCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeLiteralCSAccess().getCollectionTypeCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCollectionTypeCS_in_ruleTypeLiteralCS9509);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4109:2: this_TupleTypeCS_2= ruleTupleTypeCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeLiteralCSAccess().getTupleTypeCSParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTupleTypeCS_in_ruleTypeLiteralCS9539);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4128:1: entryRuleTypeLiteralWithMultiplicityCS returns [EObject current=null] : iv_ruleTypeLiteralWithMultiplicityCS= ruleTypeLiteralWithMultiplicityCS EOF ;
    public final EObject entryRuleTypeLiteralWithMultiplicityCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeLiteralWithMultiplicityCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4129:2: (iv_ruleTypeLiteralWithMultiplicityCS= ruleTypeLiteralWithMultiplicityCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4130:2: iv_ruleTypeLiteralWithMultiplicityCS= ruleTypeLiteralWithMultiplicityCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeLiteralWithMultiplicityCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralWithMultiplicityCS_in_entryRuleTypeLiteralWithMultiplicityCS9574);
            iv_ruleTypeLiteralWithMultiplicityCS=ruleTypeLiteralWithMultiplicityCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeLiteralWithMultiplicityCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeLiteralWithMultiplicityCS9584); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4137:1: ruleTypeLiteralWithMultiplicityCS returns [EObject current=null] : (this_TypeLiteralCS_0= ruleTypeLiteralCS ( (lv_multiplicity_1_0= ruleMultiplicityCS ) )? ) ;
    public final EObject ruleTypeLiteralWithMultiplicityCS() throws RecognitionException {
        EObject current = null;

        EObject this_TypeLiteralCS_0 = null;

        EObject lv_multiplicity_1_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4140:28: ( (this_TypeLiteralCS_0= ruleTypeLiteralCS ( (lv_multiplicity_1_0= ruleMultiplicityCS ) )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4141:1: (this_TypeLiteralCS_0= ruleTypeLiteralCS ( (lv_multiplicity_1_0= ruleMultiplicityCS ) )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4141:1: (this_TypeLiteralCS_0= ruleTypeLiteralCS ( (lv_multiplicity_1_0= ruleMultiplicityCS ) )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4142:2: this_TypeLiteralCS_0= ruleTypeLiteralCS ( (lv_multiplicity_1_0= ruleMultiplicityCS ) )?
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getTypeLiteralWithMultiplicityCSAccess().getTypeLiteralCSParserRuleCall_0()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralCS_in_ruleTypeLiteralWithMultiplicityCS9634);
            this_TypeLiteralCS_0=ruleTypeLiteralCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_TypeLiteralCS_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4153:1: ( (lv_multiplicity_1_0= ruleMultiplicityCS ) )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==72) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4154:1: (lv_multiplicity_1_0= ruleMultiplicityCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4154:1: (lv_multiplicity_1_0= ruleMultiplicityCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4155:3: lv_multiplicity_1_0= ruleMultiplicityCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeLiteralWithMultiplicityCSAccess().getMultiplicityMultiplicityCSParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMultiplicityCS_in_ruleTypeLiteralWithMultiplicityCS9654);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4179:1: entryRuleTypeLiteralExpCS returns [EObject current=null] : iv_ruleTypeLiteralExpCS= ruleTypeLiteralExpCS EOF ;
    public final EObject entryRuleTypeLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4180:2: (iv_ruleTypeLiteralExpCS= ruleTypeLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4181:2: iv_ruleTypeLiteralExpCS= ruleTypeLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralExpCS_in_entryRuleTypeLiteralExpCS9691);
            iv_ruleTypeLiteralExpCS=ruleTypeLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeLiteralExpCS9701); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4188:1: ruleTypeLiteralExpCS returns [EObject current=null] : ( (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS ) ) ;
    public final EObject ruleTypeLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject lv_ownedType_0_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4191:28: ( ( (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4192:1: ( (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4192:1: ( (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4193:1: (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4193:1: (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4194:3: lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypeLiteralExpCSAccess().getOwnedTypeTypeLiteralWithMultiplicityCSParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralWithMultiplicityCS_in_ruleTypeLiteralExpCS9746);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4218:1: entryRuleTypeNameExpCS returns [EObject current=null] : iv_ruleTypeNameExpCS= ruleTypeNameExpCS EOF ;
    public final EObject entryRuleTypeNameExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeNameExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4219:2: (iv_ruleTypeNameExpCS= ruleTypeNameExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4220:2: iv_ruleTypeNameExpCS= ruleTypeNameExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeNameExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeNameExpCS_in_entryRuleTypeNameExpCS9781);
            iv_ruleTypeNameExpCS=ruleTypeNameExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeNameExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeNameExpCS9791); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4227:1: ruleTypeNameExpCS returns [EObject current=null] : ( (lv_pathName_0_0= rulePathNameCS ) ) ;
    public final EObject ruleTypeNameExpCS() throws RecognitionException {
        EObject current = null;

        EObject lv_pathName_0_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4230:28: ( ( (lv_pathName_0_0= rulePathNameCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4231:1: ( (lv_pathName_0_0= rulePathNameCS ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4231:1: ( (lv_pathName_0_0= rulePathNameCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4232:1: (lv_pathName_0_0= rulePathNameCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4232:1: (lv_pathName_0_0= rulePathNameCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4233:3: lv_pathName_0_0= rulePathNameCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypeNameExpCSAccess().getPathNamePathNameCSParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_rulePathNameCS_in_ruleTypeNameExpCS9836);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4257:1: entryRuleTypeExpCS returns [EObject current=null] : iv_ruleTypeExpCS= ruleTypeExpCS EOF ;
    public final EObject entryRuleTypeExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4258:2: (iv_ruleTypeExpCS= ruleTypeExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4259:2: iv_ruleTypeExpCS= ruleTypeExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_entryRuleTypeExpCS9871);
            iv_ruleTypeExpCS=ruleTypeExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeExpCS9881); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4266:1: ruleTypeExpCS returns [EObject current=null] : ( (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS ) ( (lv_multiplicity_2_0= ruleMultiplicityCS ) )? ) ;
    public final EObject ruleTypeExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_TypeNameExpCS_0 = null;

        EObject this_TypeLiteralCS_1 = null;

        EObject lv_multiplicity_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4269:28: ( ( (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS ) ( (lv_multiplicity_2_0= ruleMultiplicityCS ) )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4270:1: ( (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS ) ( (lv_multiplicity_2_0= ruleMultiplicityCS ) )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4270:1: ( (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS ) ( (lv_multiplicity_2_0= ruleMultiplicityCS ) )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4270:2: (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS ) ( (lv_multiplicity_2_0= ruleMultiplicityCS ) )?
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4270:2: (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS )
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( ((LA69_0>=RULE_SIMPLE_ID && LA69_0<=RULE_ESCAPED_ID)||LA69_0==16||LA69_0==18||(LA69_0>=27 && LA69_0<=29)||(LA69_0>=33 && LA69_0<=35)||(LA69_0>=38 && LA69_0<=40)) ) {
                alt69=1;
            }
            else if ( ((LA69_0>=57 && LA69_0<=70)) ) {
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4271:2: this_TypeNameExpCS_0= ruleTypeNameExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeExpCSAccess().getTypeNameExpCSParserRuleCall_0_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeNameExpCS_in_ruleTypeExpCS9932);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4284:2: this_TypeLiteralCS_1= ruleTypeLiteralCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeExpCSAccess().getTypeLiteralCSParserRuleCall_0_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralCS_in_ruleTypeExpCS9962);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4295:2: ( (lv_multiplicity_2_0= ruleMultiplicityCS ) )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==72) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4296:1: (lv_multiplicity_2_0= ruleMultiplicityCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4296:1: (lv_multiplicity_2_0= ruleMultiplicityCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4297:3: lv_multiplicity_2_0= ruleMultiplicityCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeExpCSAccess().getMultiplicityMultiplicityCSParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMultiplicityCS_in_ruleTypeExpCS9983);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4321:1: entryRuleExpCS returns [EObject current=null] : iv_ruleExpCS= ruleExpCS EOF ;
    public final EObject entryRuleExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4322:2: (iv_ruleExpCS= ruleExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4323:2: iv_ruleExpCS= ruleExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_entryRuleExpCS10020);
            iv_ruleExpCS=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleExpCS10030); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4330:1: ruleExpCS returns [EObject current=null] : ( (this_PrefixedExpCS_0= rulePrefixedExpCS ( () ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? ) | ( (lv_ownedExpression_8_0= ruleLetExpCS ) ) ) )? ) | ( () ( (lv_ownedOperator_10_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_11_0= ruleLetExpCS ) ) ) | this_LetExpCS_12= ruleLetExpCS ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4333:28: ( ( (this_PrefixedExpCS_0= rulePrefixedExpCS ( () ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? ) | ( (lv_ownedExpression_8_0= ruleLetExpCS ) ) ) )? ) | ( () ( (lv_ownedOperator_10_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_11_0= ruleLetExpCS ) ) ) | this_LetExpCS_12= ruleLetExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4334:1: ( (this_PrefixedExpCS_0= rulePrefixedExpCS ( () ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? ) | ( (lv_ownedExpression_8_0= ruleLetExpCS ) ) ) )? ) | ( () ( (lv_ownedOperator_10_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_11_0= ruleLetExpCS ) ) ) | this_LetExpCS_12= ruleLetExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4334:1: ( (this_PrefixedExpCS_0= rulePrefixedExpCS ( () ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? ) | ( (lv_ownedExpression_8_0= ruleLetExpCS ) ) ) )? ) | ( () ( (lv_ownedOperator_10_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_11_0= ruleLetExpCS ) ) ) | this_LetExpCS_12= ruleLetExpCS )
            int alt76=3;
            alt76 = dfa76.predict(input);
            switch (alt76) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4334:2: (this_PrefixedExpCS_0= rulePrefixedExpCS ( () ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? ) | ( (lv_ownedExpression_8_0= ruleLetExpCS ) ) ) )? )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4334:2: (this_PrefixedExpCS_0= rulePrefixedExpCS ( () ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? ) | ( (lv_ownedExpression_8_0= ruleLetExpCS ) ) ) )? )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4335:2: this_PrefixedExpCS_0= rulePrefixedExpCS ( () ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? ) | ( (lv_ownedExpression_8_0= ruleLetExpCS ) ) ) )?
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getExpCSAccess().getPrefixedExpCSParserRuleCall_0_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrefixedExpCS_in_ruleExpCS10081);
                    this_PrefixedExpCS_0=rulePrefixedExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_PrefixedExpCS_0; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4346:1: ( () ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? ) | ( (lv_ownedExpression_8_0= ruleLetExpCS ) ) ) )?
                    int alt74=2;
                    int LA74_0 = input.LA(1);

                    if ( (LA74_0==32||LA74_0==41||(LA74_0>=43 && LA74_0<=56)) ) {
                        alt74=1;
                    }
                    switch (alt74) {
                        case 1 :
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4346:2: () ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? ) | ( (lv_ownedExpression_8_0= ruleLetExpCS ) ) )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4346:2: ()
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4347:2: 
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

                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4355:2: ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4356:1: (lv_ownedOperator_2_0= ruleBinaryOperatorCS )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4356:1: (lv_ownedOperator_2_0= ruleBinaryOperatorCS )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4357:3: lv_ownedOperator_2_0= ruleBinaryOperatorCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getExpCSAccess().getOwnedOperatorBinaryOperatorCSParserRuleCall_0_1_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleBinaryOperatorCS_in_ruleExpCS10114);
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

                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4373:2: ( ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? ) | ( (lv_ownedExpression_8_0= ruleLetExpCS ) ) )
                            int alt73=2;
                            int LA73_0 = input.LA(1);

                            if ( ((LA73_0>=RULE_SIMPLE_ID && LA73_0<=RULE_SINGLE_QUOTED_STRING)||LA73_0==16||LA73_0==18||(LA73_0>=27 && LA73_0<=29)||(LA73_0>=32 && LA73_0<=36)||(LA73_0>=38 && LA73_0<=42)||(LA73_0>=57 && LA73_0<=70)||(LA73_0>=75 && LA73_0<=78)||LA73_0==81||LA73_0==86) ) {
                                alt73=1;
                            }
                            else if ( (LA73_0==85) ) {
                                alt73=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 73, 0, input);

                                throw nvae;
                            }
                            switch (alt73) {
                                case 1 :
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4373:3: ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? )
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4373:3: ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4373:4: ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )?
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4373:4: ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4374:1: (lv_ownedExpression_3_0= rulePrefixedExpCS )
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4374:1: (lv_ownedExpression_3_0= rulePrefixedExpCS )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4375:3: lv_ownedExpression_3_0= rulePrefixedExpCS
                                    {
                                    if ( state.backtracking==0 ) {
                                       
                                      	        newCompositeNode(grammarAccess.getExpCSAccess().getOwnedExpressionPrefixedExpCSParserRuleCall_0_1_2_0_0_0()); 
                                      	    
                                    }
                                    pushFollow(FollowSets000.FOLLOW_rulePrefixedExpCS_in_ruleExpCS10137);
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

                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4391:2: ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )*
                                    loop71:
                                    do {
                                        int alt71=2;
                                        alt71 = dfa71.predict(input);
                                        switch (alt71) {
                                    	case 1 :
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4391:3: ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) )
                                    	    {
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4391:3: ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) )
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4392:1: (lv_ownedOperator_4_0= ruleBinaryOperatorCS )
                                    	    {
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4392:1: (lv_ownedOperator_4_0= ruleBinaryOperatorCS )
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4393:3: lv_ownedOperator_4_0= ruleBinaryOperatorCS
                                    	    {
                                    	    if ( state.backtracking==0 ) {
                                    	       
                                    	      	        newCompositeNode(grammarAccess.getExpCSAccess().getOwnedOperatorBinaryOperatorCSParserRuleCall_0_1_2_0_1_0_0()); 
                                    	      	    
                                    	    }
                                    	    pushFollow(FollowSets000.FOLLOW_ruleBinaryOperatorCS_in_ruleExpCS10159);
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

                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4409:2: ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) )
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4410:1: (lv_ownedExpression_5_0= rulePrefixedExpCS )
                                    	    {
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4410:1: (lv_ownedExpression_5_0= rulePrefixedExpCS )
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4411:3: lv_ownedExpression_5_0= rulePrefixedExpCS
                                    	    {
                                    	    if ( state.backtracking==0 ) {
                                    	       
                                    	      	        newCompositeNode(grammarAccess.getExpCSAccess().getOwnedExpressionPrefixedExpCSParserRuleCall_0_1_2_0_1_1_0()); 
                                    	      	    
                                    	    }
                                    	    pushFollow(FollowSets000.FOLLOW_rulePrefixedExpCS_in_ruleExpCS10180);
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
                                    	    break loop71;
                                        }
                                    } while (true);

                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4427:4: ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )?
                                    int alt72=2;
                                    int LA72_0 = input.LA(1);

                                    if ( (LA72_0==32||LA72_0==41||(LA72_0>=43 && LA72_0<=56)) ) {
                                        alt72=1;
                                    }
                                    switch (alt72) {
                                        case 1 :
                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4427:5: ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) )
                                            {
                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4427:5: ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) )
                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4428:1: (lv_ownedOperator_6_0= ruleBinaryOperatorCS )
                                            {
                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4428:1: (lv_ownedOperator_6_0= ruleBinaryOperatorCS )
                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4429:3: lv_ownedOperator_6_0= ruleBinaryOperatorCS
                                            {
                                            if ( state.backtracking==0 ) {
                                               
                                              	        newCompositeNode(grammarAccess.getExpCSAccess().getOwnedOperatorBinaryOperatorCSParserRuleCall_0_1_2_0_2_0_0()); 
                                              	    
                                            }
                                            pushFollow(FollowSets000.FOLLOW_ruleBinaryOperatorCS_in_ruleExpCS10204);
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

                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4445:2: ( (lv_ownedExpression_7_0= ruleLetExpCS ) )
                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4446:1: (lv_ownedExpression_7_0= ruleLetExpCS )
                                            {
                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4446:1: (lv_ownedExpression_7_0= ruleLetExpCS )
                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4447:3: lv_ownedExpression_7_0= ruleLetExpCS
                                            {
                                            if ( state.backtracking==0 ) {
                                               
                                              	        newCompositeNode(grammarAccess.getExpCSAccess().getOwnedExpressionLetExpCSParserRuleCall_0_1_2_0_2_1_0()); 
                                              	    
                                            }
                                            pushFollow(FollowSets000.FOLLOW_ruleLetExpCS_in_ruleExpCS10225);
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
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4464:6: ( (lv_ownedExpression_8_0= ruleLetExpCS ) )
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4464:6: ( (lv_ownedExpression_8_0= ruleLetExpCS ) )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4465:1: (lv_ownedExpression_8_0= ruleLetExpCS )
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4465:1: (lv_ownedExpression_8_0= ruleLetExpCS )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4466:3: lv_ownedExpression_8_0= ruleLetExpCS
                                    {
                                    if ( state.backtracking==0 ) {
                                       
                                      	        newCompositeNode(grammarAccess.getExpCSAccess().getOwnedExpressionLetExpCSParserRuleCall_0_1_2_1_0()); 
                                      	    
                                    }
                                    pushFollow(FollowSets000.FOLLOW_ruleLetExpCS_in_ruleExpCS10255);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4483:6: ( () ( (lv_ownedOperator_10_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_11_0= ruleLetExpCS ) ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4483:6: ( () ( (lv_ownedOperator_10_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_11_0= ruleLetExpCS ) ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4483:7: () ( (lv_ownedOperator_10_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_11_0= ruleLetExpCS ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4483:7: ()
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4484:2: 
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

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4492:2: ( (lv_ownedOperator_10_0= ruleUnaryOperatorCS ) )+
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
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4493:1: (lv_ownedOperator_10_0= ruleUnaryOperatorCS )
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4493:1: (lv_ownedOperator_10_0= ruleUnaryOperatorCS )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4494:3: lv_ownedOperator_10_0= ruleUnaryOperatorCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getExpCSAccess().getOwnedOperatorUnaryOperatorCSParserRuleCall_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleUnaryOperatorCS_in_ruleExpCS10299);
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
                    	    if ( cnt75 >= 1 ) break loop75;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(75, input);
                                throw eee;
                        }
                        cnt75++;
                    } while (true);

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4510:3: ( (lv_ownedExpression_11_0= ruleLetExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4511:1: (lv_ownedExpression_11_0= ruleLetExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4511:1: (lv_ownedExpression_11_0= ruleLetExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4512:3: lv_ownedExpression_11_0= ruleLetExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpCSAccess().getOwnedExpressionLetExpCSParserRuleCall_1_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLetExpCS_in_ruleExpCS10321);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4530:2: this_LetExpCS_12= ruleLetExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getExpCSAccess().getLetExpCSParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLetExpCS_in_ruleExpCS10353);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4549:1: entryRulePrefixedExpCS returns [EObject current=null] : iv_rulePrefixedExpCS= rulePrefixedExpCS EOF ;
    public final EObject entryRulePrefixedExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrefixedExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4550:2: (iv_rulePrefixedExpCS= rulePrefixedExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4551:2: iv_rulePrefixedExpCS= rulePrefixedExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrefixedExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePrefixedExpCS_in_entryRulePrefixedExpCS10388);
            iv_rulePrefixedExpCS=rulePrefixedExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrefixedExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrefixedExpCS10398); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4558:1: rulePrefixedExpCS returns [EObject current=null] : ( ( () ( (lv_ownedOperator_1_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_2_0= rulePrimaryExpCS ) ) ) | this_PrimaryExpCS_3= rulePrimaryExpCS ) ;
    public final EObject rulePrefixedExpCS() throws RecognitionException {
        EObject current = null;

        EObject lv_ownedOperator_1_0 = null;

        EObject lv_ownedExpression_2_0 = null;

        EObject this_PrimaryExpCS_3 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4561:28: ( ( ( () ( (lv_ownedOperator_1_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_2_0= rulePrimaryExpCS ) ) ) | this_PrimaryExpCS_3= rulePrimaryExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4562:1: ( ( () ( (lv_ownedOperator_1_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_2_0= rulePrimaryExpCS ) ) ) | this_PrimaryExpCS_3= rulePrimaryExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4562:1: ( ( () ( (lv_ownedOperator_1_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_2_0= rulePrimaryExpCS ) ) ) | this_PrimaryExpCS_3= rulePrimaryExpCS )
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( ((LA78_0>=41 && LA78_0<=42)) ) {
                alt78=1;
            }
            else if ( ((LA78_0>=RULE_SIMPLE_ID && LA78_0<=RULE_SINGLE_QUOTED_STRING)||LA78_0==16||LA78_0==18||(LA78_0>=27 && LA78_0<=29)||(LA78_0>=32 && LA78_0<=36)||(LA78_0>=38 && LA78_0<=40)||(LA78_0>=57 && LA78_0<=70)||(LA78_0>=75 && LA78_0<=78)||LA78_0==81||LA78_0==86) ) {
                alt78=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 78, 0, input);

                throw nvae;
            }
            switch (alt78) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4562:2: ( () ( (lv_ownedOperator_1_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_2_0= rulePrimaryExpCS ) ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4562:2: ( () ( (lv_ownedOperator_1_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_2_0= rulePrimaryExpCS ) ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4562:3: () ( (lv_ownedOperator_1_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_2_0= rulePrimaryExpCS ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4562:3: ()
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4563:2: 
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

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4571:2: ( (lv_ownedOperator_1_0= ruleUnaryOperatorCS ) )+
                    int cnt77=0;
                    loop77:
                    do {
                        int alt77=2;
                        int LA77_0 = input.LA(1);

                        if ( ((LA77_0>=41 && LA77_0<=42)) ) {
                            alt77=1;
                        }


                        switch (alt77) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4572:1: (lv_ownedOperator_1_0= ruleUnaryOperatorCS )
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4572:1: (lv_ownedOperator_1_0= ruleUnaryOperatorCS )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4573:3: lv_ownedOperator_1_0= ruleUnaryOperatorCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getPrefixedExpCSAccess().getOwnedOperatorUnaryOperatorCSParserRuleCall_0_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleUnaryOperatorCS_in_rulePrefixedExpCS10457);
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
                    	    if ( cnt77 >= 1 ) break loop77;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(77, input);
                                throw eee;
                        }
                        cnt77++;
                    } while (true);

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4589:3: ( (lv_ownedExpression_2_0= rulePrimaryExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4590:1: (lv_ownedExpression_2_0= rulePrimaryExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4590:1: (lv_ownedExpression_2_0= rulePrimaryExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4591:3: lv_ownedExpression_2_0= rulePrimaryExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrefixedExpCSAccess().getOwnedExpressionPrimaryExpCSParserRuleCall_0_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrimaryExpCS_in_rulePrefixedExpCS10479);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4609:2: this_PrimaryExpCS_3= rulePrimaryExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrefixedExpCSAccess().getPrimaryExpCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrimaryExpCS_in_rulePrefixedExpCS10511);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4628:1: entryRulePrimaryExpCS returns [EObject current=null] : iv_rulePrimaryExpCS= rulePrimaryExpCS EOF ;
    public final EObject entryRulePrimaryExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4629:2: (iv_rulePrimaryExpCS= rulePrimaryExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4630:2: iv_rulePrimaryExpCS= rulePrimaryExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimaryExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePrimaryExpCS_in_entryRulePrimaryExpCS10546);
            iv_rulePrimaryExpCS=rulePrimaryExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimaryExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrimaryExpCS10556); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4637:1: rulePrimaryExpCS returns [EObject current=null] : (this_NestedExpCS_0= ruleNestedExpCS | this_IfExpCS_1= ruleIfExpCS | this_SelfExpCS_2= ruleSelfExpCS | this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS | this_CollectionLiteralExpCS_5= ruleCollectionLiteralExpCS | this_TypeLiteralExpCS_6= ruleTypeLiteralExpCS | ( () ( (lv_pathName_8_0= rulePathNameCS ) ) ( ( () otherlv_10= '[' ( (lv_firstIndexes_11_0= ruleExpCS ) ) (otherlv_12= ',' ( (lv_firstIndexes_13_0= ruleExpCS ) ) )* otherlv_14= ']' (otherlv_15= '[' ( (lv_secondIndexes_16_0= ruleExpCS ) ) (otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) ) )* otherlv_19= ']' )? ( ( (lv_atPre_20_0= '@' ) ) otherlv_21= 'pre' )? ) | ( () otherlv_23= '{' ( ( ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )* ) | ( (lv_value_27_0= ruleStringLiteral ) ) ) otherlv_28= '}' ) | ( ( ( (lv_atPre_29_0= '@' ) ) otherlv_30= 'pre' )? ( () otherlv_32= '(' ( ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_39= ')' )? ) ) ) ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4640:28: ( (this_NestedExpCS_0= ruleNestedExpCS | this_IfExpCS_1= ruleIfExpCS | this_SelfExpCS_2= ruleSelfExpCS | this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS | this_CollectionLiteralExpCS_5= ruleCollectionLiteralExpCS | this_TypeLiteralExpCS_6= ruleTypeLiteralExpCS | ( () ( (lv_pathName_8_0= rulePathNameCS ) ) ( ( () otherlv_10= '[' ( (lv_firstIndexes_11_0= ruleExpCS ) ) (otherlv_12= ',' ( (lv_firstIndexes_13_0= ruleExpCS ) ) )* otherlv_14= ']' (otherlv_15= '[' ( (lv_secondIndexes_16_0= ruleExpCS ) ) (otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) ) )* otherlv_19= ']' )? ( ( (lv_atPre_20_0= '@' ) ) otherlv_21= 'pre' )? ) | ( () otherlv_23= '{' ( ( ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )* ) | ( (lv_value_27_0= ruleStringLiteral ) ) ) otherlv_28= '}' ) | ( ( ( (lv_atPre_29_0= '@' ) ) otherlv_30= 'pre' )? ( () otherlv_32= '(' ( ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_39= ')' )? ) ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4641:1: (this_NestedExpCS_0= ruleNestedExpCS | this_IfExpCS_1= ruleIfExpCS | this_SelfExpCS_2= ruleSelfExpCS | this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS | this_CollectionLiteralExpCS_5= ruleCollectionLiteralExpCS | this_TypeLiteralExpCS_6= ruleTypeLiteralExpCS | ( () ( (lv_pathName_8_0= rulePathNameCS ) ) ( ( () otherlv_10= '[' ( (lv_firstIndexes_11_0= ruleExpCS ) ) (otherlv_12= ',' ( (lv_firstIndexes_13_0= ruleExpCS ) ) )* otherlv_14= ']' (otherlv_15= '[' ( (lv_secondIndexes_16_0= ruleExpCS ) ) (otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) ) )* otherlv_19= ']' )? ( ( (lv_atPre_20_0= '@' ) ) otherlv_21= 'pre' )? ) | ( () otherlv_23= '{' ( ( ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )* ) | ( (lv_value_27_0= ruleStringLiteral ) ) ) otherlv_28= '}' ) | ( ( ( (lv_atPre_29_0= '@' ) ) otherlv_30= 'pre' )? ( () otherlv_32= '(' ( ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_39= ')' )? ) ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4641:1: (this_NestedExpCS_0= ruleNestedExpCS | this_IfExpCS_1= ruleIfExpCS | this_SelfExpCS_2= ruleSelfExpCS | this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS | this_CollectionLiteralExpCS_5= ruleCollectionLiteralExpCS | this_TypeLiteralExpCS_6= ruleTypeLiteralExpCS | ( () ( (lv_pathName_8_0= rulePathNameCS ) ) ( ( () otherlv_10= '[' ( (lv_firstIndexes_11_0= ruleExpCS ) ) (otherlv_12= ',' ( (lv_firstIndexes_13_0= ruleExpCS ) ) )* otherlv_14= ']' (otherlv_15= '[' ( (lv_secondIndexes_16_0= ruleExpCS ) ) (otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) ) )* otherlv_19= ']' )? ( ( (lv_atPre_20_0= '@' ) ) otherlv_21= 'pre' )? ) | ( () otherlv_23= '{' ( ( ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )* ) | ( (lv_value_27_0= ruleStringLiteral ) ) ) otherlv_28= '}' ) | ( ( ( (lv_atPre_29_0= '@' ) ) otherlv_30= 'pre' )? ( () otherlv_32= '(' ( ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_39= ')' )? ) ) ) )
            int alt94=8;
            alt94 = dfa94.predict(input);
            switch (alt94) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4642:2: this_NestedExpCS_0= ruleNestedExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getNestedExpCSParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNestedExpCS_in_rulePrimaryExpCS10606);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4655:2: this_IfExpCS_1= ruleIfExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getIfExpCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleIfExpCS_in_rulePrimaryExpCS10636);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4668:2: this_SelfExpCS_2= ruleSelfExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getSelfExpCSParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSelfExpCS_in_rulePrimaryExpCS10666);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4681:2: this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getPrimitiveLiteralExpCSParserRuleCall_3()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrimitiveLiteralExpCS_in_rulePrimaryExpCS10696);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4694:2: this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getTupleLiteralExpCSParserRuleCall_4()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralExpCS_in_rulePrimaryExpCS10726);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4707:2: this_CollectionLiteralExpCS_5= ruleCollectionLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getCollectionLiteralExpCSParserRuleCall_5()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteralExpCS_in_rulePrimaryExpCS10756);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4720:2: this_TypeLiteralExpCS_6= ruleTypeLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getTypeLiteralExpCSParserRuleCall_6()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralExpCS_in_rulePrimaryExpCS10786);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4732:6: ( () ( (lv_pathName_8_0= rulePathNameCS ) ) ( ( () otherlv_10= '[' ( (lv_firstIndexes_11_0= ruleExpCS ) ) (otherlv_12= ',' ( (lv_firstIndexes_13_0= ruleExpCS ) ) )* otherlv_14= ']' (otherlv_15= '[' ( (lv_secondIndexes_16_0= ruleExpCS ) ) (otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) ) )* otherlv_19= ']' )? ( ( (lv_atPre_20_0= '@' ) ) otherlv_21= 'pre' )? ) | ( () otherlv_23= '{' ( ( ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )* ) | ( (lv_value_27_0= ruleStringLiteral ) ) ) otherlv_28= '}' ) | ( ( ( (lv_atPre_29_0= '@' ) ) otherlv_30= 'pre' )? ( () otherlv_32= '(' ( ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_39= ')' )? ) ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4732:6: ( () ( (lv_pathName_8_0= rulePathNameCS ) ) ( ( () otherlv_10= '[' ( (lv_firstIndexes_11_0= ruleExpCS ) ) (otherlv_12= ',' ( (lv_firstIndexes_13_0= ruleExpCS ) ) )* otherlv_14= ']' (otherlv_15= '[' ( (lv_secondIndexes_16_0= ruleExpCS ) ) (otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) ) )* otherlv_19= ']' )? ( ( (lv_atPre_20_0= '@' ) ) otherlv_21= 'pre' )? ) | ( () otherlv_23= '{' ( ( ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )* ) | ( (lv_value_27_0= ruleStringLiteral ) ) ) otherlv_28= '}' ) | ( ( ( (lv_atPre_29_0= '@' ) ) otherlv_30= 'pre' )? ( () otherlv_32= '(' ( ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_39= ')' )? ) ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4732:7: () ( (lv_pathName_8_0= rulePathNameCS ) ) ( ( () otherlv_10= '[' ( (lv_firstIndexes_11_0= ruleExpCS ) ) (otherlv_12= ',' ( (lv_firstIndexes_13_0= ruleExpCS ) ) )* otherlv_14= ']' (otherlv_15= '[' ( (lv_secondIndexes_16_0= ruleExpCS ) ) (otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) ) )* otherlv_19= ']' )? ( ( (lv_atPre_20_0= '@' ) ) otherlv_21= 'pre' )? ) | ( () otherlv_23= '{' ( ( ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )* ) | ( (lv_value_27_0= ruleStringLiteral ) ) ) otherlv_28= '}' ) | ( ( ( (lv_atPre_29_0= '@' ) ) otherlv_30= 'pre' )? ( () otherlv_32= '(' ( ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_39= ')' )? ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4732:7: ()
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4733:2: 
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

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4741:2: ( (lv_pathName_8_0= rulePathNameCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4742:1: (lv_pathName_8_0= rulePathNameCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4742:1: (lv_pathName_8_0= rulePathNameCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4743:3: lv_pathName_8_0= rulePathNameCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getPathNamePathNameCSParserRuleCall_7_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePathNameCS_in_rulePrimaryExpCS10825);
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

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4759:2: ( ( () otherlv_10= '[' ( (lv_firstIndexes_11_0= ruleExpCS ) ) (otherlv_12= ',' ( (lv_firstIndexes_13_0= ruleExpCS ) ) )* otherlv_14= ']' (otherlv_15= '[' ( (lv_secondIndexes_16_0= ruleExpCS ) ) (otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) ) )* otherlv_19= ']' )? ( ( (lv_atPre_20_0= '@' ) ) otherlv_21= 'pre' )? ) | ( () otherlv_23= '{' ( ( ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )* ) | ( (lv_value_27_0= ruleStringLiteral ) ) ) otherlv_28= '}' ) | ( ( ( (lv_atPre_29_0= '@' ) ) otherlv_30= 'pre' )? ( () otherlv_32= '(' ( ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_39= ')' )? ) )
                    int alt93=3;
                    switch ( input.LA(1) ) {
                    case 72:
                        {
                        alt93=1;
                        }
                        break;
                    case 20:
                        {
                        alt93=2;
                        }
                        break;
                    case EOF:
                    case 17:
                    case 19:
                    case 22:
                    case 23:
                    case 25:
                    case 26:
                    case 30:
                    case 32:
                    case 36:
                    case 37:
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
                        alt93=3;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 93, 0, input);

                        throw nvae;
                    }

                    switch (alt93) {
                        case 1 :
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4759:3: ( () otherlv_10= '[' ( (lv_firstIndexes_11_0= ruleExpCS ) ) (otherlv_12= ',' ( (lv_firstIndexes_13_0= ruleExpCS ) ) )* otherlv_14= ']' (otherlv_15= '[' ( (lv_secondIndexes_16_0= ruleExpCS ) ) (otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) ) )* otherlv_19= ']' )? ( ( (lv_atPre_20_0= '@' ) ) otherlv_21= 'pre' )? )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4759:3: ( () otherlv_10= '[' ( (lv_firstIndexes_11_0= ruleExpCS ) ) (otherlv_12= ',' ( (lv_firstIndexes_13_0= ruleExpCS ) ) )* otherlv_14= ']' (otherlv_15= '[' ( (lv_secondIndexes_16_0= ruleExpCS ) ) (otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) ) )* otherlv_19= ']' )? ( ( (lv_atPre_20_0= '@' ) ) otherlv_21= 'pre' )? )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4759:4: () otherlv_10= '[' ( (lv_firstIndexes_11_0= ruleExpCS ) ) (otherlv_12= ',' ( (lv_firstIndexes_13_0= ruleExpCS ) ) )* otherlv_14= ']' (otherlv_15= '[' ( (lv_secondIndexes_16_0= ruleExpCS ) ) (otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) ) )* otherlv_19= ']' )? ( ( (lv_atPre_20_0= '@' ) ) otherlv_21= 'pre' )?
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4759:4: ()
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4760:2: 
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

                            otherlv_10=(Token)match(input,72,FollowSets000.FOLLOW_72_in_rulePrimaryExpCS10851); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_10, grammarAccess.getPrimaryExpCSAccess().getLeftSquareBracketKeyword_7_2_0_1());
                                  
                            }
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4772:1: ( (lv_firstIndexes_11_0= ruleExpCS ) )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4773:1: (lv_firstIndexes_11_0= ruleExpCS )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4773:1: (lv_firstIndexes_11_0= ruleExpCS )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4774:3: lv_firstIndexes_11_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getFirstIndexesExpCSParserRuleCall_7_2_0_2_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_rulePrimaryExpCS10872);
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

                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4790:2: (otherlv_12= ',' ( (lv_firstIndexes_13_0= ruleExpCS ) ) )*
                            loop79:
                            do {
                                int alt79=2;
                                int LA79_0 = input.LA(1);

                                if ( (LA79_0==19) ) {
                                    alt79=1;
                                }


                                switch (alt79) {
                            	case 1 :
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4790:4: otherlv_12= ',' ( (lv_firstIndexes_13_0= ruleExpCS ) )
                            	    {
                            	    otherlv_12=(Token)match(input,19,FollowSets000.FOLLOW_19_in_rulePrimaryExpCS10885); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_12, grammarAccess.getPrimaryExpCSAccess().getCommaKeyword_7_2_0_3_0());
                            	          
                            	    }
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4794:1: ( (lv_firstIndexes_13_0= ruleExpCS ) )
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4795:1: (lv_firstIndexes_13_0= ruleExpCS )
                            	    {
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4795:1: (lv_firstIndexes_13_0= ruleExpCS )
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4796:3: lv_firstIndexes_13_0= ruleExpCS
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getFirstIndexesExpCSParserRuleCall_7_2_0_3_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_rulePrimaryExpCS10906);
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
                            	    break loop79;
                                }
                            } while (true);

                            otherlv_14=(Token)match(input,73,FollowSets000.FOLLOW_73_in_rulePrimaryExpCS10920); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_14, grammarAccess.getPrimaryExpCSAccess().getRightSquareBracketKeyword_7_2_0_4());
                                  
                            }
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4816:1: (otherlv_15= '[' ( (lv_secondIndexes_16_0= ruleExpCS ) ) (otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) ) )* otherlv_19= ']' )?
                            int alt81=2;
                            int LA81_0 = input.LA(1);

                            if ( (LA81_0==72) ) {
                                alt81=1;
                            }
                            switch (alt81) {
                                case 1 :
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4816:3: otherlv_15= '[' ( (lv_secondIndexes_16_0= ruleExpCS ) ) (otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) ) )* otherlv_19= ']'
                                    {
                                    otherlv_15=(Token)match(input,72,FollowSets000.FOLLOW_72_in_rulePrimaryExpCS10933); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                          	newLeafNode(otherlv_15, grammarAccess.getPrimaryExpCSAccess().getLeftSquareBracketKeyword_7_2_0_5_0());
                                          
                                    }
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4820:1: ( (lv_secondIndexes_16_0= ruleExpCS ) )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4821:1: (lv_secondIndexes_16_0= ruleExpCS )
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4821:1: (lv_secondIndexes_16_0= ruleExpCS )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4822:3: lv_secondIndexes_16_0= ruleExpCS
                                    {
                                    if ( state.backtracking==0 ) {
                                       
                                      	        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getSecondIndexesExpCSParserRuleCall_7_2_0_5_1_0()); 
                                      	    
                                    }
                                    pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_rulePrimaryExpCS10954);
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

                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4838:2: (otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) ) )*
                                    loop80:
                                    do {
                                        int alt80=2;
                                        int LA80_0 = input.LA(1);

                                        if ( (LA80_0==19) ) {
                                            alt80=1;
                                        }


                                        switch (alt80) {
                                    	case 1 :
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4838:4: otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) )
                                    	    {
                                    	    otherlv_17=(Token)match(input,19,FollowSets000.FOLLOW_19_in_rulePrimaryExpCS10967); if (state.failed) return current;
                                    	    if ( state.backtracking==0 ) {

                                    	          	newLeafNode(otherlv_17, grammarAccess.getPrimaryExpCSAccess().getCommaKeyword_7_2_0_5_2_0());
                                    	          
                                    	    }
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4842:1: ( (lv_secondIndexes_18_0= ruleExpCS ) )
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4843:1: (lv_secondIndexes_18_0= ruleExpCS )
                                    	    {
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4843:1: (lv_secondIndexes_18_0= ruleExpCS )
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4844:3: lv_secondIndexes_18_0= ruleExpCS
                                    	    {
                                    	    if ( state.backtracking==0 ) {
                                    	       
                                    	      	        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getSecondIndexesExpCSParserRuleCall_7_2_0_5_2_1_0()); 
                                    	      	    
                                    	    }
                                    	    pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_rulePrimaryExpCS10988);
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
                                    	    break loop80;
                                        }
                                    } while (true);

                                    otherlv_19=(Token)match(input,73,FollowSets000.FOLLOW_73_in_rulePrimaryExpCS11002); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                          	newLeafNode(otherlv_19, grammarAccess.getPrimaryExpCSAccess().getRightSquareBracketKeyword_7_2_0_5_3());
                                          
                                    }

                                    }
                                    break;

                            }

                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4864:3: ( ( (lv_atPre_20_0= '@' ) ) otherlv_21= 'pre' )?
                            int alt82=2;
                            int LA82_0 = input.LA(1);

                            if ( (LA82_0==79) ) {
                                alt82=1;
                            }
                            switch (alt82) {
                                case 1 :
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4864:4: ( (lv_atPre_20_0= '@' ) ) otherlv_21= 'pre'
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4864:4: ( (lv_atPre_20_0= '@' ) )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4865:1: (lv_atPre_20_0= '@' )
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4865:1: (lv_atPre_20_0= '@' )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4866:3: lv_atPre_20_0= '@'
                                    {
                                    lv_atPre_20_0=(Token)match(input,79,FollowSets000.FOLLOW_79_in_rulePrimaryExpCS11023); if (state.failed) return current;
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

                                    otherlv_21=(Token)match(input,80,FollowSets000.FOLLOW_80_in_rulePrimaryExpCS11048); if (state.failed) return current;
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
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4884:6: ( () otherlv_23= '{' ( ( ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )* ) | ( (lv_value_27_0= ruleStringLiteral ) ) ) otherlv_28= '}' )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4884:6: ( () otherlv_23= '{' ( ( ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )* ) | ( (lv_value_27_0= ruleStringLiteral ) ) ) otherlv_28= '}' )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4884:7: () otherlv_23= '{' ( ( ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )* ) | ( (lv_value_27_0= ruleStringLiteral ) ) ) otherlv_28= '}'
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4884:7: ()
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4885:2: 
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

                            otherlv_23=(Token)match(input,20,FollowSets000.FOLLOW_20_in_rulePrimaryExpCS11082); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_23, grammarAccess.getPrimaryExpCSAccess().getLeftCurlyBracketKeyword_7_2_1_1());
                                  
                            }
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4897:1: ( ( ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )* ) | ( (lv_value_27_0= ruleStringLiteral ) ) )
                            int alt84=2;
                            int LA84_0 = input.LA(1);

                            if ( ((LA84_0>=RULE_SIMPLE_ID && LA84_0<=RULE_ESCAPED_ID)||LA84_0==16||LA84_0==18||(LA84_0>=27 && LA84_0<=29)||(LA84_0>=33 && LA84_0<=35)||(LA84_0>=38 && LA84_0<=40)) ) {
                                alt84=1;
                            }
                            else if ( (LA84_0==RULE_SINGLE_QUOTED_STRING) ) {
                                alt84=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 84, 0, input);

                                throw nvae;
                            }
                            switch (alt84) {
                                case 1 :
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4897:2: ( ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )* )
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4897:2: ( ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )* )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4897:3: ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )*
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4897:3: ( (lv_ownedParts_24_0= ruleConstructorPartCS ) )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4898:1: (lv_ownedParts_24_0= ruleConstructorPartCS )
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4898:1: (lv_ownedParts_24_0= ruleConstructorPartCS )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4899:3: lv_ownedParts_24_0= ruleConstructorPartCS
                                    {
                                    if ( state.backtracking==0 ) {
                                       
                                      	        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getOwnedPartsConstructorPartCSParserRuleCall_7_2_1_2_0_0_0()); 
                                      	    
                                    }
                                    pushFollow(FollowSets000.FOLLOW_ruleConstructorPartCS_in_rulePrimaryExpCS11105);
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

                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4915:2: (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )*
                                    loop83:
                                    do {
                                        int alt83=2;
                                        int LA83_0 = input.LA(1);

                                        if ( (LA83_0==19) ) {
                                            alt83=1;
                                        }


                                        switch (alt83) {
                                    	case 1 :
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4915:4: otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) )
                                    	    {
                                    	    otherlv_25=(Token)match(input,19,FollowSets000.FOLLOW_19_in_rulePrimaryExpCS11118); if (state.failed) return current;
                                    	    if ( state.backtracking==0 ) {

                                    	          	newLeafNode(otherlv_25, grammarAccess.getPrimaryExpCSAccess().getCommaKeyword_7_2_1_2_0_1_0());
                                    	          
                                    	    }
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4919:1: ( (lv_ownedParts_26_0= ruleConstructorPartCS ) )
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4920:1: (lv_ownedParts_26_0= ruleConstructorPartCS )
                                    	    {
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4920:1: (lv_ownedParts_26_0= ruleConstructorPartCS )
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4921:3: lv_ownedParts_26_0= ruleConstructorPartCS
                                    	    {
                                    	    if ( state.backtracking==0 ) {
                                    	       
                                    	      	        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getOwnedPartsConstructorPartCSParserRuleCall_7_2_1_2_0_1_1_0()); 
                                    	      	    
                                    	    }
                                    	    pushFollow(FollowSets000.FOLLOW_ruleConstructorPartCS_in_rulePrimaryExpCS11139);
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
                                    	    break loop83;
                                        }
                                    } while (true);


                                    }


                                    }
                                    break;
                                case 2 :
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4938:6: ( (lv_value_27_0= ruleStringLiteral ) )
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4938:6: ( (lv_value_27_0= ruleStringLiteral ) )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4939:1: (lv_value_27_0= ruleStringLiteral )
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4939:1: (lv_value_27_0= ruleStringLiteral )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4940:3: lv_value_27_0= ruleStringLiteral
                                    {
                                    if ( state.backtracking==0 ) {
                                       
                                      	        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getValueStringLiteralParserRuleCall_7_2_1_2_1_0()); 
                                      	    
                                    }
                                    pushFollow(FollowSets000.FOLLOW_ruleStringLiteral_in_rulePrimaryExpCS11169);
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

                            otherlv_28=(Token)match(input,22,FollowSets000.FOLLOW_22_in_rulePrimaryExpCS11182); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_28, grammarAccess.getPrimaryExpCSAccess().getRightCurlyBracketKeyword_7_2_1_3());
                                  
                            }

                            }


                            }
                            break;
                        case 3 :
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4961:6: ( ( ( (lv_atPre_29_0= '@' ) ) otherlv_30= 'pre' )? ( () otherlv_32= '(' ( ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_39= ')' )? )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4961:6: ( ( ( (lv_atPre_29_0= '@' ) ) otherlv_30= 'pre' )? ( () otherlv_32= '(' ( ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_39= ')' )? )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4961:7: ( ( (lv_atPre_29_0= '@' ) ) otherlv_30= 'pre' )? ( () otherlv_32= '(' ( ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_39= ')' )?
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4961:7: ( ( (lv_atPre_29_0= '@' ) ) otherlv_30= 'pre' )?
                            int alt85=2;
                            int LA85_0 = input.LA(1);

                            if ( (LA85_0==79) ) {
                                alt85=1;
                            }
                            switch (alt85) {
                                case 1 :
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4961:8: ( (lv_atPre_29_0= '@' ) ) otherlv_30= 'pre'
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4961:8: ( (lv_atPre_29_0= '@' ) )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4962:1: (lv_atPre_29_0= '@' )
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4962:1: (lv_atPre_29_0= '@' )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4963:3: lv_atPre_29_0= '@'
                                    {
                                    lv_atPre_29_0=(Token)match(input,79,FollowSets000.FOLLOW_79_in_rulePrimaryExpCS11209); if (state.failed) return current;
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

                                    otherlv_30=(Token)match(input,80,FollowSets000.FOLLOW_80_in_rulePrimaryExpCS11234); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                          	newLeafNode(otherlv_30, grammarAccess.getPrimaryExpCSAccess().getPreKeyword_7_2_2_0_1());
                                          
                                    }

                                    }
                                    break;

                            }

                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4980:3: ( () otherlv_32= '(' ( ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_39= ')' )?
                            int alt92=2;
                            int LA92_0 = input.LA(1);

                            if ( (LA92_0==36) ) {
                                alt92=1;
                            }
                            switch (alt92) {
                                case 1 :
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4980:4: () otherlv_32= '(' ( ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_39= ')'
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4980:4: ()
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4981:2: 
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

                                    otherlv_32=(Token)match(input,36,FollowSets000.FOLLOW_36_in_rulePrimaryExpCS11261); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                          	newLeafNode(otherlv_32, grammarAccess.getPrimaryExpCSAccess().getLeftParenthesisKeyword_7_2_2_1_1());
                                          
                                    }
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4993:1: ( ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )? )?
                                    int alt91=2;
                                    int LA91_0 = input.LA(1);

                                    if ( ((LA91_0>=RULE_SIMPLE_ID && LA91_0<=RULE_SINGLE_QUOTED_STRING)||LA91_0==16||LA91_0==18||(LA91_0>=27 && LA91_0<=29)||(LA91_0>=32 && LA91_0<=36)||(LA91_0>=38 && LA91_0<=42)||(LA91_0>=57 && LA91_0<=70)||(LA91_0>=75 && LA91_0<=78)||LA91_0==81||(LA91_0>=85 && LA91_0<=86)) ) {
                                        alt91=1;
                                    }
                                    switch (alt91) {
                                        case 1 :
                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4993:2: ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )?
                                            {
                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4993:2: ( (lv_argument_33_0= ruleNavigatingArgCS ) )
                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4994:1: (lv_argument_33_0= ruleNavigatingArgCS )
                                            {
                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4994:1: (lv_argument_33_0= ruleNavigatingArgCS )
                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4995:3: lv_argument_33_0= ruleNavigatingArgCS
                                            {
                                            if ( state.backtracking==0 ) {
                                               
                                              	        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getArgumentNavigatingArgCSParserRuleCall_7_2_2_1_2_0_0()); 
                                              	    
                                            }
                                            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgCS_in_rulePrimaryExpCS11283);
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

                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5011:2: ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )*
                                            loop86:
                                            do {
                                                int alt86=2;
                                                int LA86_0 = input.LA(1);

                                                if ( (LA86_0==19) ) {
                                                    alt86=1;
                                                }


                                                switch (alt86) {
                                            	case 1 :
                                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5012:1: (lv_argument_34_0= ruleNavigatingCommaArgCS )
                                            	    {
                                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5012:1: (lv_argument_34_0= ruleNavigatingCommaArgCS )
                                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5013:3: lv_argument_34_0= ruleNavigatingCommaArgCS
                                            	    {
                                            	    if ( state.backtracking==0 ) {
                                            	       
                                            	      	        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getArgumentNavigatingCommaArgCSParserRuleCall_7_2_2_1_2_1_0()); 
                                            	      	    
                                            	    }
                                            	    pushFollow(FollowSets000.FOLLOW_ruleNavigatingCommaArgCS_in_rulePrimaryExpCS11304);
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
                                            	    break loop86;
                                                }
                                            } while (true);

                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5029:3: ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )?
                                            int alt88=2;
                                            int LA88_0 = input.LA(1);

                                            if ( (LA88_0==26) ) {
                                                alt88=1;
                                            }
                                            switch (alt88) {
                                                case 1 :
                                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5029:4: ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )*
                                                    {
                                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5029:4: ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) )
                                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5030:1: (lv_argument_35_0= ruleNavigatingSemiArgCS )
                                                    {
                                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5030:1: (lv_argument_35_0= ruleNavigatingSemiArgCS )
                                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5031:3: lv_argument_35_0= ruleNavigatingSemiArgCS
                                                    {
                                                    if ( state.backtracking==0 ) {
                                                       
                                                      	        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getArgumentNavigatingSemiArgCSParserRuleCall_7_2_2_1_2_2_0_0()); 
                                                      	    
                                                    }
                                                    pushFollow(FollowSets000.FOLLOW_ruleNavigatingSemiArgCS_in_rulePrimaryExpCS11327);
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

                                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5047:2: ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )*
                                                    loop87:
                                                    do {
                                                        int alt87=2;
                                                        int LA87_0 = input.LA(1);

                                                        if ( (LA87_0==19) ) {
                                                            alt87=1;
                                                        }


                                                        switch (alt87) {
                                                    	case 1 :
                                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5048:1: (lv_argument_36_0= ruleNavigatingCommaArgCS )
                                                    	    {
                                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5048:1: (lv_argument_36_0= ruleNavigatingCommaArgCS )
                                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5049:3: lv_argument_36_0= ruleNavigatingCommaArgCS
                                                    	    {
                                                    	    if ( state.backtracking==0 ) {
                                                    	       
                                                    	      	        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getArgumentNavigatingCommaArgCSParserRuleCall_7_2_2_1_2_2_1_0()); 
                                                    	      	    
                                                    	    }
                                                    	    pushFollow(FollowSets000.FOLLOW_ruleNavigatingCommaArgCS_in_rulePrimaryExpCS11348);
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
                                                    	    break loop87;
                                                        }
                                                    } while (true);


                                                    }
                                                    break;

                                            }

                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5065:5: ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )?
                                            int alt90=2;
                                            int LA90_0 = input.LA(1);

                                            if ( (LA90_0==23) ) {
                                                alt90=1;
                                            }
                                            switch (alt90) {
                                                case 1 :
                                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5065:6: ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )*
                                                    {
                                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5065:6: ( (lv_argument_37_0= ruleNavigatingBarArgCS ) )
                                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5066:1: (lv_argument_37_0= ruleNavigatingBarArgCS )
                                                    {
                                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5066:1: (lv_argument_37_0= ruleNavigatingBarArgCS )
                                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5067:3: lv_argument_37_0= ruleNavigatingBarArgCS
                                                    {
                                                    if ( state.backtracking==0 ) {
                                                       
                                                      	        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getArgumentNavigatingBarArgCSParserRuleCall_7_2_2_1_2_3_0_0()); 
                                                      	    
                                                    }
                                                    pushFollow(FollowSets000.FOLLOW_ruleNavigatingBarArgCS_in_rulePrimaryExpCS11373);
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

                                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5083:2: ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )*
                                                    loop89:
                                                    do {
                                                        int alt89=2;
                                                        int LA89_0 = input.LA(1);

                                                        if ( (LA89_0==19) ) {
                                                            alt89=1;
                                                        }


                                                        switch (alt89) {
                                                    	case 1 :
                                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5084:1: (lv_argument_38_0= ruleNavigatingCommaArgCS )
                                                    	    {
                                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5084:1: (lv_argument_38_0= ruleNavigatingCommaArgCS )
                                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5085:3: lv_argument_38_0= ruleNavigatingCommaArgCS
                                                    	    {
                                                    	    if ( state.backtracking==0 ) {
                                                    	       
                                                    	      	        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getArgumentNavigatingCommaArgCSParserRuleCall_7_2_2_1_2_3_1_0()); 
                                                    	      	    
                                                    	    }
                                                    	    pushFollow(FollowSets000.FOLLOW_ruleNavigatingCommaArgCS_in_rulePrimaryExpCS11394);
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
                                                    	    break loop89;
                                                        }
                                                    } while (true);


                                                    }
                                                    break;

                                            }


                                            }
                                            break;

                                    }

                                    otherlv_39=(Token)match(input,37,FollowSets000.FOLLOW_37_in_rulePrimaryExpCS11411); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5113:1: entryRuleNavigatingArgCS returns [EObject current=null] : iv_ruleNavigatingArgCS= ruleNavigatingArgCS EOF ;
    public final EObject entryRuleNavigatingArgCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingArgCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5114:2: (iv_ruleNavigatingArgCS= ruleNavigatingArgCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5115:2: iv_ruleNavigatingArgCS= ruleNavigatingArgCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingArgCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgCS_in_entryRuleNavigatingArgCS11452);
            iv_ruleNavigatingArgCS=ruleNavigatingArgCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingArgCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigatingArgCS11462); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5122:1: ruleNavigatingArgCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleNavigatingArgExpCS ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_init_4_0= ruleExpCS ) ) )? )? ) ;
    public final EObject ruleNavigatingArgCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;

        EObject lv_init_4_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5125:28: ( ( ( (lv_name_0_0= ruleNavigatingArgExpCS ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_init_4_0= ruleExpCS ) ) )? )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5126:1: ( ( (lv_name_0_0= ruleNavigatingArgExpCS ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_init_4_0= ruleExpCS ) ) )? )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5126:1: ( ( (lv_name_0_0= ruleNavigatingArgExpCS ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_init_4_0= ruleExpCS ) ) )? )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5126:2: ( (lv_name_0_0= ruleNavigatingArgExpCS ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_init_4_0= ruleExpCS ) ) )? )?
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5126:2: ( (lv_name_0_0= ruleNavigatingArgExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5127:1: (lv_name_0_0= ruleNavigatingArgExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5127:1: (lv_name_0_0= ruleNavigatingArgExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5128:3: lv_name_0_0= ruleNavigatingArgExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getNameNavigatingArgExpCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingArgCS11508);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5144:2: (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_init_4_0= ruleExpCS ) ) )? )?
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==30) ) {
                alt96=1;
            }
            switch (alt96) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5144:4: otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_init_4_0= ruleExpCS ) ) )?
                    {
                    otherlv_1=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleNavigatingArgCS11521); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getNavigatingArgCSAccess().getColonKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5148:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5149:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5149:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5150:3: lv_ownedType_2_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleNavigatingArgCS11542);
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

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5166:2: (otherlv_3= '=' ( (lv_init_4_0= ruleExpCS ) ) )?
                    int alt95=2;
                    int LA95_0 = input.LA(1);

                    if ( (LA95_0==49) ) {
                        alt95=1;
                    }
                    switch (alt95) {
                        case 1 :
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5166:4: otherlv_3= '=' ( (lv_init_4_0= ruleExpCS ) )
                            {
                            otherlv_3=(Token)match(input,49,FollowSets000.FOLLOW_49_in_ruleNavigatingArgCS11555); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_3, grammarAccess.getNavigatingArgCSAccess().getEqualsSignKeyword_1_2_0());
                                  
                            }
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5170:1: ( (lv_init_4_0= ruleExpCS ) )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5171:1: (lv_init_4_0= ruleExpCS )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5171:1: (lv_init_4_0= ruleExpCS )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5172:3: lv_init_4_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getInitExpCSParserRuleCall_1_2_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNavigatingArgCS11576);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5196:1: entryRuleNavigatingBarArgCS returns [EObject current=null] : iv_ruleNavigatingBarArgCS= ruleNavigatingBarArgCS EOF ;
    public final EObject entryRuleNavigatingBarArgCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingBarArgCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5197:2: (iv_ruleNavigatingBarArgCS= ruleNavigatingBarArgCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5198:2: iv_ruleNavigatingBarArgCS= ruleNavigatingBarArgCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingBarArgCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingBarArgCS_in_entryRuleNavigatingBarArgCS11616);
            iv_ruleNavigatingBarArgCS=ruleNavigatingBarArgCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingBarArgCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigatingBarArgCS11626); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5205:1: ruleNavigatingBarArgCS returns [EObject current=null] : ( ( (lv_prefix_0_0= '|' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )? ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5208:28: ( ( ( (lv_prefix_0_0= '|' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5209:1: ( ( (lv_prefix_0_0= '|' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5209:1: ( ( (lv_prefix_0_0= '|' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5209:2: ( (lv_prefix_0_0= '|' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )?
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5209:2: ( (lv_prefix_0_0= '|' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5210:1: (lv_prefix_0_0= '|' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5210:1: (lv_prefix_0_0= '|' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5211:3: lv_prefix_0_0= '|'
            {
            lv_prefix_0_0=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleNavigatingBarArgCS11669); if (state.failed) return current;
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5224:2: ( (lv_name_1_0= ruleNavigatingArgExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5225:1: (lv_name_1_0= ruleNavigatingArgExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5225:1: (lv_name_1_0= ruleNavigatingArgExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5226:3: lv_name_1_0= ruleNavigatingArgExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNavigatingBarArgCSAccess().getNameNavigatingArgExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingBarArgCS11703);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5242:2: (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )?
            int alt98=2;
            int LA98_0 = input.LA(1);

            if ( (LA98_0==30) ) {
                alt98=1;
            }
            switch (alt98) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5242:4: otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )?
                    {
                    otherlv_2=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleNavigatingBarArgCS11716); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getNavigatingBarArgCSAccess().getColonKeyword_2_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5246:1: ( (lv_ownedType_3_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5247:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5247:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5248:3: lv_ownedType_3_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingBarArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleNavigatingBarArgCS11737);
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

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5264:2: (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )?
                    int alt97=2;
                    int LA97_0 = input.LA(1);

                    if ( (LA97_0==49) ) {
                        alt97=1;
                    }
                    switch (alt97) {
                        case 1 :
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5264:4: otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) )
                            {
                            otherlv_4=(Token)match(input,49,FollowSets000.FOLLOW_49_in_ruleNavigatingBarArgCS11750); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getNavigatingBarArgCSAccess().getEqualsSignKeyword_2_2_0());
                                  
                            }
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5268:1: ( (lv_init_5_0= ruleExpCS ) )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5269:1: (lv_init_5_0= ruleExpCS )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5269:1: (lv_init_5_0= ruleExpCS )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5270:3: lv_init_5_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getNavigatingBarArgCSAccess().getInitExpCSParserRuleCall_2_2_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNavigatingBarArgCS11771);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5294:1: entryRuleNavigatingCommaArgCS returns [EObject current=null] : iv_ruleNavigatingCommaArgCS= ruleNavigatingCommaArgCS EOF ;
    public final EObject entryRuleNavigatingCommaArgCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingCommaArgCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5295:2: (iv_ruleNavigatingCommaArgCS= ruleNavigatingCommaArgCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5296:2: iv_ruleNavigatingCommaArgCS= ruleNavigatingCommaArgCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingCommaArgCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingCommaArgCS_in_entryRuleNavigatingCommaArgCS11811);
            iv_ruleNavigatingCommaArgCS=ruleNavigatingCommaArgCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingCommaArgCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigatingCommaArgCS11821); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5303:1: ruleNavigatingCommaArgCS returns [EObject current=null] : ( ( (lv_prefix_0_0= ',' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )? ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5306:28: ( ( ( (lv_prefix_0_0= ',' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5307:1: ( ( (lv_prefix_0_0= ',' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5307:1: ( ( (lv_prefix_0_0= ',' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5307:2: ( (lv_prefix_0_0= ',' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )?
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5307:2: ( (lv_prefix_0_0= ',' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5308:1: (lv_prefix_0_0= ',' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5308:1: (lv_prefix_0_0= ',' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5309:3: lv_prefix_0_0= ','
            {
            lv_prefix_0_0=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleNavigatingCommaArgCS11864); if (state.failed) return current;
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5322:2: ( (lv_name_1_0= ruleNavigatingArgExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5323:1: (lv_name_1_0= ruleNavigatingArgExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5323:1: (lv_name_1_0= ruleNavigatingArgExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5324:3: lv_name_1_0= ruleNavigatingArgExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getNameNavigatingArgExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingCommaArgCS11898);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5340:2: (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )?
            int alt100=2;
            int LA100_0 = input.LA(1);

            if ( (LA100_0==30) ) {
                alt100=1;
            }
            switch (alt100) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5340:4: otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )?
                    {
                    otherlv_2=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleNavigatingCommaArgCS11911); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getNavigatingCommaArgCSAccess().getColonKeyword_2_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5344:1: ( (lv_ownedType_3_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5345:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5345:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5346:3: lv_ownedType_3_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleNavigatingCommaArgCS11932);
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

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5362:2: (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )?
                    int alt99=2;
                    int LA99_0 = input.LA(1);

                    if ( (LA99_0==49) ) {
                        alt99=1;
                    }
                    switch (alt99) {
                        case 1 :
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5362:4: otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) )
                            {
                            otherlv_4=(Token)match(input,49,FollowSets000.FOLLOW_49_in_ruleNavigatingCommaArgCS11945); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getNavigatingCommaArgCSAccess().getEqualsSignKeyword_2_2_0());
                                  
                            }
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5366:1: ( (lv_init_5_0= ruleExpCS ) )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5367:1: (lv_init_5_0= ruleExpCS )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5367:1: (lv_init_5_0= ruleExpCS )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5368:3: lv_init_5_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getInitExpCSParserRuleCall_2_2_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNavigatingCommaArgCS11966);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5392:1: entryRuleNavigatingSemiArgCS returns [EObject current=null] : iv_ruleNavigatingSemiArgCS= ruleNavigatingSemiArgCS EOF ;
    public final EObject entryRuleNavigatingSemiArgCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingSemiArgCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5393:2: (iv_ruleNavigatingSemiArgCS= ruleNavigatingSemiArgCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5394:2: iv_ruleNavigatingSemiArgCS= ruleNavigatingSemiArgCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingSemiArgCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingSemiArgCS_in_entryRuleNavigatingSemiArgCS12006);
            iv_ruleNavigatingSemiArgCS=ruleNavigatingSemiArgCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingSemiArgCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigatingSemiArgCS12016); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5401:1: ruleNavigatingSemiArgCS returns [EObject current=null] : ( ( (lv_prefix_0_0= ';' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )? ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5404:28: ( ( ( (lv_prefix_0_0= ';' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5405:1: ( ( (lv_prefix_0_0= ';' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5405:1: ( ( (lv_prefix_0_0= ';' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5405:2: ( (lv_prefix_0_0= ';' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )?
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5405:2: ( (lv_prefix_0_0= ';' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5406:1: (lv_prefix_0_0= ';' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5406:1: (lv_prefix_0_0= ';' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5407:3: lv_prefix_0_0= ';'
            {
            lv_prefix_0_0=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleNavigatingSemiArgCS12059); if (state.failed) return current;
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5420:2: ( (lv_name_1_0= ruleNavigatingArgExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5421:1: (lv_name_1_0= ruleNavigatingArgExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5421:1: (lv_name_1_0= ruleNavigatingArgExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5422:3: lv_name_1_0= ruleNavigatingArgExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNavigatingSemiArgCSAccess().getNameNavigatingArgExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingSemiArgCS12093);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5438:2: (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )?
            int alt102=2;
            int LA102_0 = input.LA(1);

            if ( (LA102_0==30) ) {
                alt102=1;
            }
            switch (alt102) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5438:4: otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )?
                    {
                    otherlv_2=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleNavigatingSemiArgCS12106); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getNavigatingSemiArgCSAccess().getColonKeyword_2_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5442:1: ( (lv_ownedType_3_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5443:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5443:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5444:3: lv_ownedType_3_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingSemiArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleNavigatingSemiArgCS12127);
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

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5460:2: (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )?
                    int alt101=2;
                    int LA101_0 = input.LA(1);

                    if ( (LA101_0==49) ) {
                        alt101=1;
                    }
                    switch (alt101) {
                        case 1 :
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5460:4: otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) )
                            {
                            otherlv_4=(Token)match(input,49,FollowSets000.FOLLOW_49_in_ruleNavigatingSemiArgCS12140); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getNavigatingSemiArgCSAccess().getEqualsSignKeyword_2_2_0());
                                  
                            }
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5464:1: ( (lv_init_5_0= ruleExpCS ) )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5465:1: (lv_init_5_0= ruleExpCS )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5465:1: (lv_init_5_0= ruleExpCS )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5466:3: lv_init_5_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getNavigatingSemiArgCSAccess().getInitExpCSParserRuleCall_2_2_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNavigatingSemiArgCS12161);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5490:1: entryRuleNavigatingArgExpCS returns [EObject current=null] : iv_ruleNavigatingArgExpCS= ruleNavigatingArgExpCS EOF ;
    public final EObject entryRuleNavigatingArgExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingArgExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5491:2: (iv_ruleNavigatingArgExpCS= ruleNavigatingArgExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5492:2: iv_ruleNavigatingArgExpCS= ruleNavigatingArgExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingArgExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgExpCS_in_entryRuleNavigatingArgExpCS12201);
            iv_ruleNavigatingArgExpCS=ruleNavigatingArgExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingArgExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigatingArgExpCS12211); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5499:1: ruleNavigatingArgExpCS returns [EObject current=null] : this_ExpCS_0= ruleExpCS ;
    public final EObject ruleNavigatingArgExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_ExpCS_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5502:28: (this_ExpCS_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5504:2: this_ExpCS_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getNavigatingArgExpCSAccess().getExpCSParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNavigatingArgExpCS12260);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5523:1: entryRuleIfExpCS returns [EObject current=null] : iv_ruleIfExpCS= ruleIfExpCS EOF ;
    public final EObject entryRuleIfExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5524:2: (iv_ruleIfExpCS= ruleIfExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5525:2: iv_ruleIfExpCS= ruleIfExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIfExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIfExpCS_in_entryRuleIfExpCS12294);
            iv_ruleIfExpCS=ruleIfExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIfExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIfExpCS12304); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5532:1: ruleIfExpCS returns [EObject current=null] : (otherlv_0= 'if' ( (lv_condition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_thenExpression_3_0= ruleExpCS ) ) otherlv_4= 'else' ( (lv_elseExpression_5_0= ruleExpCS ) ) otherlv_6= 'endif' ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5535:28: ( (otherlv_0= 'if' ( (lv_condition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_thenExpression_3_0= ruleExpCS ) ) otherlv_4= 'else' ( (lv_elseExpression_5_0= ruleExpCS ) ) otherlv_6= 'endif' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5536:1: (otherlv_0= 'if' ( (lv_condition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_thenExpression_3_0= ruleExpCS ) ) otherlv_4= 'else' ( (lv_elseExpression_5_0= ruleExpCS ) ) otherlv_6= 'endif' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5536:1: (otherlv_0= 'if' ( (lv_condition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_thenExpression_3_0= ruleExpCS ) ) otherlv_4= 'else' ( (lv_elseExpression_5_0= ruleExpCS ) ) otherlv_6= 'endif' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5536:3: otherlv_0= 'if' ( (lv_condition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_thenExpression_3_0= ruleExpCS ) ) otherlv_4= 'else' ( (lv_elseExpression_5_0= ruleExpCS ) ) otherlv_6= 'endif'
            {
            otherlv_0=(Token)match(input,81,FollowSets000.FOLLOW_81_in_ruleIfExpCS12341); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getIfExpCSAccess().getIfKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5540:1: ( (lv_condition_1_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5541:1: (lv_condition_1_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5541:1: (lv_condition_1_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5542:3: lv_condition_1_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIfExpCSAccess().getConditionExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleIfExpCS12362);
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

            otherlv_2=(Token)match(input,82,FollowSets000.FOLLOW_82_in_ruleIfExpCS12374); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getIfExpCSAccess().getThenKeyword_2());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5562:1: ( (lv_thenExpression_3_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5563:1: (lv_thenExpression_3_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5563:1: (lv_thenExpression_3_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5564:3: lv_thenExpression_3_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIfExpCSAccess().getThenExpressionExpCSParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleIfExpCS12395);
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

            otherlv_4=(Token)match(input,83,FollowSets000.FOLLOW_83_in_ruleIfExpCS12407); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getIfExpCSAccess().getElseKeyword_4());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5584:1: ( (lv_elseExpression_5_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5585:1: (lv_elseExpression_5_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5585:1: (lv_elseExpression_5_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5586:3: lv_elseExpression_5_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIfExpCSAccess().getElseExpressionExpCSParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleIfExpCS12428);
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

            otherlv_6=(Token)match(input,84,FollowSets000.FOLLOW_84_in_ruleIfExpCS12440); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5614:1: entryRuleLetExpCS returns [EObject current=null] : iv_ruleLetExpCS= ruleLetExpCS EOF ;
    public final EObject entryRuleLetExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLetExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5615:2: (iv_ruleLetExpCS= ruleLetExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5616:2: iv_ruleLetExpCS= ruleLetExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLetExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLetExpCS_in_entryRuleLetExpCS12476);
            iv_ruleLetExpCS=ruleLetExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLetExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLetExpCS12486); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5623:1: ruleLetExpCS returns [EObject current=null] : (otherlv_0= 'let' ( (lv_variable_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_variable_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_in_5_0= ruleExpCS ) ) ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5626:28: ( (otherlv_0= 'let' ( (lv_variable_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_variable_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_in_5_0= ruleExpCS ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5627:1: (otherlv_0= 'let' ( (lv_variable_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_variable_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_in_5_0= ruleExpCS ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5627:1: (otherlv_0= 'let' ( (lv_variable_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_variable_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_in_5_0= ruleExpCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5627:3: otherlv_0= 'let' ( (lv_variable_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_variable_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_in_5_0= ruleExpCS ) )
            {
            otherlv_0=(Token)match(input,85,FollowSets000.FOLLOW_85_in_ruleLetExpCS12523); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLetExpCSAccess().getLetKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5631:1: ( (lv_variable_1_0= ruleLetVariableCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5632:1: (lv_variable_1_0= ruleLetVariableCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5632:1: (lv_variable_1_0= ruleLetVariableCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5633:3: lv_variable_1_0= ruleLetVariableCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetExpCSAccess().getVariableLetVariableCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleLetVariableCS_in_ruleLetExpCS12544);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5649:2: (otherlv_2= ',' ( (lv_variable_3_0= ruleLetVariableCS ) ) )*
            loop103:
            do {
                int alt103=2;
                int LA103_0 = input.LA(1);

                if ( (LA103_0==19) ) {
                    alt103=1;
                }


                switch (alt103) {
            	case 1 :
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5649:4: otherlv_2= ',' ( (lv_variable_3_0= ruleLetVariableCS ) )
            	    {
            	    otherlv_2=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleLetExpCS12557); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getLetExpCSAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5653:1: ( (lv_variable_3_0= ruleLetVariableCS ) )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5654:1: (lv_variable_3_0= ruleLetVariableCS )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5654:1: (lv_variable_3_0= ruleLetVariableCS )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5655:3: lv_variable_3_0= ruleLetVariableCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLetExpCSAccess().getVariableLetVariableCSParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleLetVariableCS_in_ruleLetExpCS12578);
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
            	    break loop103;
                }
            } while (true);

            otherlv_4=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleLetExpCS12592); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getLetExpCSAccess().getInKeyword_3());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5675:1: ( (lv_in_5_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5676:1: (lv_in_5_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5676:1: (lv_in_5_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5677:3: lv_in_5_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetExpCSAccess().getInExpCSParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleLetExpCS12613);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5701:1: entryRuleLetVariableCS returns [EObject current=null] : iv_ruleLetVariableCS= ruleLetVariableCS EOF ;
    public final EObject entryRuleLetVariableCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLetVariableCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5702:2: (iv_ruleLetVariableCS= ruleLetVariableCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5703:2: iv_ruleLetVariableCS= ruleLetVariableCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLetVariableCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLetVariableCS_in_entryRuleLetVariableCS12649);
            iv_ruleLetVariableCS=ruleLetVariableCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLetVariableCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLetVariableCS12659); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5710:1: ruleLetVariableCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) ) ) ;
    public final EObject ruleLetVariableCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;

        EObject lv_initExpression_4_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5713:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5714:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5714:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5714:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5714:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5715:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5715:1: (lv_name_0_0= ruleUnrestrictedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5716:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetVariableCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleLetVariableCS12705);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5732:2: (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )?
            int alt104=2;
            int LA104_0 = input.LA(1);

            if ( (LA104_0==30) ) {
                alt104=1;
            }
            switch (alt104) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5732:4: otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                    {
                    otherlv_1=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleLetVariableCS12718); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getLetVariableCSAccess().getColonKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5736:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5737:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5737:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5738:3: lv_ownedType_2_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLetVariableCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleLetVariableCS12739);
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

            otherlv_3=(Token)match(input,49,FollowSets000.FOLLOW_49_in_ruleLetVariableCS12753); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getLetVariableCSAccess().getEqualsSignKeyword_2());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5758:1: ( (lv_initExpression_4_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5759:1: (lv_initExpression_4_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5759:1: (lv_initExpression_4_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5760:3: lv_initExpression_4_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetVariableCSAccess().getInitExpressionExpCSParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleLetVariableCS12774);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5784:1: entryRuleNestedExpCS returns [EObject current=null] : iv_ruleNestedExpCS= ruleNestedExpCS EOF ;
    public final EObject entryRuleNestedExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNestedExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5785:2: (iv_ruleNestedExpCS= ruleNestedExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5786:2: iv_ruleNestedExpCS= ruleNestedExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNestedExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNestedExpCS_in_entryRuleNestedExpCS12810);
            iv_ruleNestedExpCS=ruleNestedExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNestedExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNestedExpCS12820); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5793:1: ruleNestedExpCS returns [EObject current=null] : (otherlv_0= '(' ( (lv_source_1_0= ruleExpCS ) ) otherlv_2= ')' ) ;
    public final EObject ruleNestedExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_source_1_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5796:28: ( (otherlv_0= '(' ( (lv_source_1_0= ruleExpCS ) ) otherlv_2= ')' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5797:1: (otherlv_0= '(' ( (lv_source_1_0= ruleExpCS ) ) otherlv_2= ')' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5797:1: (otherlv_0= '(' ( (lv_source_1_0= ruleExpCS ) ) otherlv_2= ')' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5797:3: otherlv_0= '(' ( (lv_source_1_0= ruleExpCS ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleNestedExpCS12857); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getNestedExpCSAccess().getLeftParenthesisKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5801:1: ( (lv_source_1_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5802:1: (lv_source_1_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5802:1: (lv_source_1_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5803:3: lv_source_1_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNestedExpCSAccess().getSourceExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNestedExpCS12878);
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

            otherlv_2=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleNestedExpCS12890); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5831:1: entryRuleSelfExpCS returns [EObject current=null] : iv_ruleSelfExpCS= ruleSelfExpCS EOF ;
    public final EObject entryRuleSelfExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelfExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5832:2: (iv_ruleSelfExpCS= ruleSelfExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5833:2: iv_ruleSelfExpCS= ruleSelfExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSelfExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSelfExpCS_in_entryRuleSelfExpCS12926);
            iv_ruleSelfExpCS=ruleSelfExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSelfExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSelfExpCS12936); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5840:1: ruleSelfExpCS returns [EObject current=null] : ( () otherlv_1= 'self' ) ;
    public final EObject ruleSelfExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5843:28: ( ( () otherlv_1= 'self' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5844:1: ( () otherlv_1= 'self' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5844:1: ( () otherlv_1= 'self' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5844:2: () otherlv_1= 'self'
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5844:2: ()
            // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:5845:2: 
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

            otherlv_1=(Token)match(input,86,FollowSets000.FOLLOW_86_in_ruleSelfExpCS12985); if (state.failed) return current;
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

    // $ANTLR start synpred32_InternalQVTcore
    public final void synpred32_InternalQVTcore_fragment() throws RecognitionException {   
        EObject lv_guardPattern_4_0 = null;


        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1010:1: ( (lv_guardPattern_4_0= ruleGuardPatternCS ) )
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1010:1: (lv_guardPattern_4_0= ruleGuardPatternCS )
        {
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1010:1: (lv_guardPattern_4_0= ruleGuardPatternCS )
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1011:3: lv_guardPattern_4_0= ruleGuardPatternCS
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getNamedDomainCSAccess().getGuardPatternGuardPatternCSParserRuleCall_4_0()); 
          	    
        }
        pushFollow(FollowSets000.FOLLOW_ruleGuardPatternCS_in_synpred32_InternalQVTcore1964);
        lv_guardPattern_4_0=ruleGuardPatternCS();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred32_InternalQVTcore

    // $ANTLR start synpred33_InternalQVTcore
    public final void synpred33_InternalQVTcore_fragment() throws RecognitionException {   
        EObject lv_bottomPattern_7_0 = null;


        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1036:1: ( (lv_bottomPattern_7_0= ruleBottomPatternCS ) )
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1036:1: (lv_bottomPattern_7_0= ruleBottomPatternCS )
        {
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1036:1: (lv_bottomPattern_7_0= ruleBottomPatternCS )
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1037:3: lv_bottomPattern_7_0= ruleBottomPatternCS
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getNamedDomainCSAccess().getBottomPatternBottomPatternCSParserRuleCall_7_0()); 
          	    
        }
        pushFollow(FollowSets000.FOLLOW_ruleBottomPatternCS_in_synpred33_InternalQVTcore2010);
        lv_bottomPattern_7_0=ruleBottomPatternCS();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred33_InternalQVTcore

    // $ANTLR start synpred40_InternalQVTcore
    public final void synpred40_InternalQVTcore_fragment() throws RecognitionException {   
        EObject lv_guardPattern_2_0 = null;


        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1597:1: ( (lv_guardPattern_2_0= ruleGuardPatternCS ) )
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1597:1: (lv_guardPattern_2_0= ruleGuardPatternCS )
        {
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1597:1: (lv_guardPattern_2_0= ruleGuardPatternCS )
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1598:3: lv_guardPattern_2_0= ruleGuardPatternCS
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getUnnamedDomainCSAccess().getGuardPatternGuardPatternCSParserRuleCall_2_0()); 
          	    
        }
        pushFollow(FollowSets000.FOLLOW_ruleGuardPatternCS_in_synpred40_InternalQVTcore3161);
        lv_guardPattern_2_0=ruleGuardPatternCS();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred40_InternalQVTcore

    // $ANTLR start synpred41_InternalQVTcore
    public final void synpred41_InternalQVTcore_fragment() throws RecognitionException {   
        EObject lv_bottomPattern_5_0 = null;


        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1623:1: ( (lv_bottomPattern_5_0= ruleBottomPatternCS ) )
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1623:1: (lv_bottomPattern_5_0= ruleBottomPatternCS )
        {
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1623:1: (lv_bottomPattern_5_0= ruleBottomPatternCS )
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:1624:3: lv_bottomPattern_5_0= ruleBottomPatternCS
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getUnnamedDomainCSAccess().getBottomPatternBottomPatternCSParserRuleCall_5_0()); 
          	    
        }
        pushFollow(FollowSets000.FOLLOW_ruleBottomPatternCS_in_synpred41_InternalQVTcore3207);
        lv_bottomPattern_5_0=ruleBottomPatternCS();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred41_InternalQVTcore

    // $ANTLR start synpred126_InternalQVTcore
    public final void synpred126_InternalQVTcore_fragment() throws RecognitionException {   
        EObject this_TupleLiteralExpCS_4 = null;


        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4694:2: (this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS )
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4694:2: this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralExpCS_in_synpred126_InternalQVTcore10726);
        this_TupleLiteralExpCS_4=ruleTupleLiteralExpCS();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred126_InternalQVTcore

    // $ANTLR start synpred127_InternalQVTcore
    public final void synpred127_InternalQVTcore_fragment() throws RecognitionException {   
        EObject this_CollectionLiteralExpCS_5 = null;


        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4707:2: (this_CollectionLiteralExpCS_5= ruleCollectionLiteralExpCS )
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4707:2: this_CollectionLiteralExpCS_5= ruleCollectionLiteralExpCS
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteralExpCS_in_synpred127_InternalQVTcore10756);
        this_CollectionLiteralExpCS_5=ruleCollectionLiteralExpCS();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred127_InternalQVTcore

    // $ANTLR start synpred128_InternalQVTcore
    public final void synpred128_InternalQVTcore_fragment() throws RecognitionException {   
        EObject this_TypeLiteralExpCS_6 = null;


        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4720:2: (this_TypeLiteralExpCS_6= ruleTypeLiteralExpCS )
        // ../../plugins/org.eclipse.qvtd.xtext.qvtcore/src-gen/org/eclipse/qvtd/xtext/qvtcore/parser/antlr/internal/InternalQVTcore.g:4720:2: this_TypeLiteralExpCS_6= ruleTypeLiteralExpCS
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralExpCS_in_synpred128_InternalQVTcore10786);
        this_TypeLiteralExpCS_6=ruleTypeLiteralExpCS();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred128_InternalQVTcore

    // Delegated rules

    public final boolean synpred128_InternalQVTcore() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred128_InternalQVTcore_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred127_InternalQVTcore() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred127_InternalQVTcore_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred40_InternalQVTcore() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred40_InternalQVTcore_fragment(); // can never throw exception
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
    public final boolean synpred41_InternalQVTcore() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred41_InternalQVTcore_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred33_InternalQVTcore() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred33_InternalQVTcore_fragment(); // can never throw exception
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


    protected DFA13 dfa13 = new DFA13(this);
    protected DFA17 dfa17 = new DFA17(this);
    protected DFA23 dfa23 = new DFA23(this);
    protected DFA34 dfa34 = new DFA34(this);
    protected DFA35 dfa35 = new DFA35(this);
    protected DFA76 dfa76 = new DFA76(this);
    protected DFA71 dfa71 = new DFA71(this);
    protected DFA94 dfa94 = new DFA94(this);
    static final String DFA13_eotS =
        "\20\uffff";
    static final String DFA13_eofS =
        "\1\16\17\uffff";
    static final String DFA13_minS =
        "\1\4\11\24\1\4\3\24\2\uffff";
    static final String DFA13_maxS =
        "\1\126\15\117\2\uffff";
    static final String DFA13_acceptS =
        "\16\uffff\1\2\1\1";
    static final String DFA13_specialS =
        "\20\uffff}>";
    static final String[] DFA13_transitionS = {
            "\1\1\1\2\2\16\10\uffff\1\10\1\uffff\1\13\3\uffff\1\16\1\uffff"+
            "\1\16\2\uffff\1\6\1\15\1\5\2\uffff\1\16\1\7\1\3\1\4\1\16\1\uffff"+
            "\1\11\1\14\1\12\2\16\16\uffff\16\16\4\uffff\4\16\2\uffff\1\16"+
            "\3\uffff\2\16",
            "\1\16\4\uffff\2\16\3\uffff\1\17\2\16\3\uffff\1\16\4\uffff"+
            "\1\16\1\uffff\16\16\17\uffff\1\16\6\uffff\1\16",
            "\1\16\4\uffff\2\16\3\uffff\1\17\2\16\3\uffff\1\16\4\uffff"+
            "\1\16\1\uffff\16\16\17\uffff\1\16\6\uffff\1\16",
            "\1\16\4\uffff\2\16\3\uffff\1\17\2\16\3\uffff\1\16\4\uffff"+
            "\1\16\1\uffff\16\16\17\uffff\1\16\6\uffff\1\16",
            "\1\16\4\uffff\2\16\3\uffff\1\17\2\16\3\uffff\1\16\4\uffff"+
            "\1\16\1\uffff\16\16\17\uffff\1\16\6\uffff\1\16",
            "\1\16\4\uffff\2\16\3\uffff\1\17\2\16\3\uffff\1\16\4\uffff"+
            "\1\16\1\uffff\16\16\17\uffff\1\16\6\uffff\1\16",
            "\1\16\4\uffff\2\16\3\uffff\1\17\2\16\3\uffff\1\16\4\uffff"+
            "\1\16\1\uffff\16\16\17\uffff\1\16\6\uffff\1\16",
            "\1\16\4\uffff\2\16\3\uffff\1\17\2\16\3\uffff\1\16\4\uffff"+
            "\1\16\1\uffff\16\16\17\uffff\1\16\6\uffff\1\16",
            "\1\16\4\uffff\2\16\3\uffff\1\17\2\16\3\uffff\1\16\4\uffff"+
            "\1\16\1\uffff\16\16\17\uffff\1\16\6\uffff\1\16",
            "\1\16\4\uffff\2\16\3\uffff\1\17\2\16\3\uffff\1\16\4\uffff"+
            "\1\16\1\uffff\16\16\17\uffff\1\16\6\uffff\1\16",
            "\2\17\12\uffff\1\17\1\uffff\1\17\1\uffff\1\16\4\uffff\2\16"+
            "\4\17\2\16\3\17\1\16\1\uffff\3\17\1\16\1\uffff\16\16\17\uffff"+
            "\1\16\6\uffff\1\16",
            "\1\16\4\uffff\2\16\3\uffff\1\17\2\16\3\uffff\1\16\4\uffff"+
            "\1\16\1\uffff\16\16\17\uffff\1\16\6\uffff\1\16",
            "\1\16\4\uffff\2\16\3\uffff\1\17\2\16\3\uffff\1\16\4\uffff"+
            "\1\16\1\uffff\16\16\17\uffff\1\16\6\uffff\1\16",
            "\1\16\4\uffff\2\16\3\uffff\1\17\2\16\3\uffff\1\16\4\uffff"+
            "\1\16\1\uffff\16\16\17\uffff\1\16\6\uffff\1\16",
            "",
            ""
    };

    static final short[] DFA13_eot = DFA.unpackEncodedString(DFA13_eotS);
    static final short[] DFA13_eof = DFA.unpackEncodedString(DFA13_eofS);
    static final char[] DFA13_min = DFA.unpackEncodedStringToUnsignedChars(DFA13_minS);
    static final char[] DFA13_max = DFA.unpackEncodedStringToUnsignedChars(DFA13_maxS);
    static final short[] DFA13_accept = DFA.unpackEncodedString(DFA13_acceptS);
    static final short[] DFA13_special = DFA.unpackEncodedString(DFA13_specialS);
    static final short[][] DFA13_transition;

    static {
        int numStates = DFA13_transitionS.length;
        DFA13_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA13_transition[i] = DFA.unpackEncodedString(DFA13_transitionS[i]);
        }
    }

    class DFA13 extends DFA {

        public DFA13(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 13;
            this.eot = DFA13_eot;
            this.eof = DFA13_eof;
            this.min = DFA13_min;
            this.max = DFA13_max;
            this.accept = DFA13_accept;
            this.special = DFA13_special;
            this.transition = DFA13_transition;
        }
        public String getDescription() {
            return "393:2: ( ( ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_2_0= ruleRealizedVariableCS ) ) ) (otherlv_3= ',' ( ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) ) ) )* otherlv_6= '|' )?";
        }
    }
    static final String DFA17_eotS =
        "\13\uffff";
    static final String DFA17_eofS =
        "\1\4\1\uffff\2\1\1\uffff\4\4\2\1";
    static final String DFA17_minS =
        "\1\4\1\uffff\2\4\1\uffff\6\4";
    static final String DFA17_maxS =
        "\1\50\1\uffff\2\50\1\uffff\6\50";
    static final String DFA17_acceptS =
        "\1\uffff\1\1\2\uffff\1\2\6\uffff";
    static final String DFA17_specialS =
        "\13\uffff}>";
    static final String[] DFA17_transitionS = {
            "\2\1\12\uffff\1\1\1\uffff\1\1\7\uffff\1\4\1\2\1\3\1\1\3\uffff"+
            "\3\1\2\uffff\3\1",
            "",
            "\2\4\12\uffff\1\4\1\uffff\1\4\7\uffff\1\1\1\5\1\6\1\4\3\uffff"+
            "\3\4\2\uffff\3\4",
            "\2\4\12\uffff\1\4\1\uffff\1\4\7\uffff\1\1\1\7\1\10\1\4\3\uffff"+
            "\3\4\2\uffff\3\4",
            "",
            "\2\1\12\uffff\1\1\1\uffff\1\1\1\4\6\uffff\1\4\1\1\1\11\1\1"+
            "\3\uffff\3\1\2\uffff\3\1",
            "\2\1\12\uffff\1\1\1\uffff\1\1\1\4\6\uffff\1\4\1\1\1\12\1\1"+
            "\3\uffff\3\1\2\uffff\3\1",
            "\2\1\12\uffff\1\1\1\uffff\1\1\1\4\6\uffff\1\4\3\1\3\uffff"+
            "\3\1\2\uffff\3\1",
            "\2\1\12\uffff\1\1\1\uffff\1\1\1\4\6\uffff\1\4\3\1\3\uffff"+
            "\3\1\2\uffff\3\1",
            "\2\4\12\uffff\1\4\1\uffff\1\4\1\1\6\uffff\1\1\1\4\1\10\1\4"+
            "\3\uffff\3\4\2\uffff\3\4",
            "\2\4\12\uffff\1\4\1\uffff\1\4\1\1\6\uffff\1\1\3\4\3\uffff"+
            "\3\4\2\uffff\3\4"
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
            return "603:2: ( (lv_name_1_0= ruleUnrestrictedName ) )?";
        }
    }
    static final String DFA23_eotS =
        "\20\uffff";
    static final String DFA23_eofS =
        "\1\16\17\uffff";
    static final String DFA23_minS =
        "\1\4\15\24\2\uffff";
    static final String DFA23_maxS =
        "\1\126\15\117\2\uffff";
    static final String DFA23_acceptS =
        "\16\uffff\1\2\1\1";
    static final String DFA23_specialS =
        "\20\uffff}>";
    static final String[] DFA23_transitionS = {
            "\1\1\1\2\2\16\10\uffff\1\10\1\uffff\1\13\5\uffff\1\16\2\uffff"+
            "\1\6\1\15\1\5\2\uffff\1\16\1\7\1\3\1\4\2\16\1\11\1\14\1\12\2"+
            "\16\16\uffff\16\16\4\uffff\4\16\2\uffff\1\16\3\uffff\2\16",
            "\1\16\4\uffff\2\16\3\uffff\1\17\2\16\3\uffff\1\16\4\uffff"+
            "\1\16\1\uffff\16\16\17\uffff\1\16\6\uffff\1\16",
            "\1\16\4\uffff\2\16\3\uffff\1\17\2\16\3\uffff\1\16\4\uffff"+
            "\1\16\1\uffff\16\16\17\uffff\1\16\6\uffff\1\16",
            "\1\16\4\uffff\2\16\3\uffff\1\17\2\16\3\uffff\1\16\4\uffff"+
            "\1\16\1\uffff\16\16\17\uffff\1\16\6\uffff\1\16",
            "\1\16\4\uffff\2\16\3\uffff\1\17\2\16\3\uffff\1\16\4\uffff"+
            "\1\16\1\uffff\16\16\17\uffff\1\16\6\uffff\1\16",
            "\1\16\4\uffff\2\16\3\uffff\1\17\2\16\3\uffff\1\16\4\uffff"+
            "\1\16\1\uffff\16\16\17\uffff\1\16\6\uffff\1\16",
            "\1\16\4\uffff\2\16\3\uffff\1\17\2\16\3\uffff\1\16\4\uffff"+
            "\1\16\1\uffff\16\16\17\uffff\1\16\6\uffff\1\16",
            "\1\16\4\uffff\2\16\3\uffff\1\17\2\16\3\uffff\1\16\4\uffff"+
            "\1\16\1\uffff\16\16\17\uffff\1\16\6\uffff\1\16",
            "\1\16\4\uffff\2\16\3\uffff\1\17\2\16\3\uffff\1\16\4\uffff"+
            "\1\16\1\uffff\16\16\17\uffff\1\16\6\uffff\1\16",
            "\1\16\4\uffff\2\16\3\uffff\1\17\2\16\3\uffff\1\16\4\uffff"+
            "\1\16\1\uffff\16\16\17\uffff\1\16\6\uffff\1\16",
            "\1\16\4\uffff\2\16\3\uffff\1\17\2\16\3\uffff\1\16\4\uffff"+
            "\1\16\1\uffff\16\16\17\uffff\1\16\6\uffff\1\16",
            "\1\16\4\uffff\2\16\3\uffff\1\17\2\16\3\uffff\1\16\4\uffff"+
            "\1\16\1\uffff\16\16\17\uffff\1\16\6\uffff\1\16",
            "\1\16\4\uffff\2\16\3\uffff\1\17\2\16\3\uffff\1\16\4\uffff"+
            "\1\16\1\uffff\16\16\17\uffff\1\16\6\uffff\1\16",
            "\1\16\4\uffff\2\16\3\uffff\1\17\2\16\3\uffff\1\16\4\uffff"+
            "\1\16\1\uffff\16\16\17\uffff\1\16\6\uffff\1\16",
            "",
            ""
    };

    static final short[] DFA23_eot = DFA.unpackEncodedString(DFA23_eotS);
    static final short[] DFA23_eof = DFA.unpackEncodedString(DFA23_eofS);
    static final char[] DFA23_min = DFA.unpackEncodedStringToUnsignedChars(DFA23_minS);
    static final char[] DFA23_max = DFA.unpackEncodedStringToUnsignedChars(DFA23_maxS);
    static final short[] DFA23_accept = DFA.unpackEncodedString(DFA23_acceptS);
    static final short[] DFA23_special = DFA.unpackEncodedString(DFA23_specialS);
    static final short[][] DFA23_transition;

    static {
        int numStates = DFA23_transitionS.length;
        DFA23_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA23_transition[i] = DFA.unpackEncodedString(DFA23_transitionS[i]);
        }
    }

    class DFA23 extends DFA {

        public DFA23(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 23;
            this.eot = DFA23_eot;
            this.eof = DFA23_eof;
            this.min = DFA23_min;
            this.max = DFA23_max;
            this.accept = DFA23_accept;
            this.special = DFA23_special;
            this.transition = DFA23_transition;
        }
        public String getDescription() {
            return "739:2: ( ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) (otherlv_2= ',' ( (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS ) ) )* otherlv_4= '|' )?";
        }
    }
    static final String DFA34_eotS =
        "\36\uffff";
    static final String DFA34_eofS =
        "\1\16\35\uffff";
    static final String DFA34_minS =
        "\1\4\15\24\1\uffff\16\24\1\uffff";
    static final String DFA34_maxS =
        "\1\106\15\44\1\uffff\16\37\1\uffff";
    static final String DFA34_acceptS =
        "\16\uffff\1\2\16\uffff\1\1";
    static final String DFA34_specialS =
        "\36\uffff}>";
    static final String[] DFA34_transitionS = {
            "\1\1\1\2\12\uffff\1\10\1\uffff\1\13\10\uffff\1\6\1\15\1\5\3"+
            "\uffff\1\7\1\3\1\4\2\uffff\1\11\1\14\1\12\20\uffff\1\34\1\24"+
            "\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\17\1\20\1\21\1\22\1\23",
            "\1\16\12\uffff\1\35\4\uffff\1\16",
            "\1\16\12\uffff\1\35\4\uffff\1\16",
            "\1\16\12\uffff\1\35\4\uffff\1\16",
            "\1\16\12\uffff\1\35\4\uffff\1\16",
            "\1\16\12\uffff\1\35\4\uffff\1\16",
            "\1\16\12\uffff\1\35\4\uffff\1\16",
            "\1\16\12\uffff\1\35\4\uffff\1\16",
            "\1\16\12\uffff\1\35\4\uffff\1\16",
            "\1\16\12\uffff\1\35\4\uffff\1\16",
            "\1\16\12\uffff\1\35\4\uffff\1\16",
            "\1\16\12\uffff\1\35\4\uffff\1\16",
            "\1\16\12\uffff\1\35\4\uffff\1\16",
            "\1\16\12\uffff\1\35\4\uffff\1\16",
            "",
            "\1\16\12\uffff\1\35",
            "\1\16\12\uffff\1\35",
            "\1\16\12\uffff\1\35",
            "\1\16\12\uffff\1\35",
            "\1\16\12\uffff\1\35",
            "\1\16\12\uffff\1\35",
            "\1\16\12\uffff\1\35",
            "\1\16\12\uffff\1\35",
            "\1\16\12\uffff\1\35",
            "\1\16\12\uffff\1\35",
            "\1\16\12\uffff\1\35",
            "\1\16\12\uffff\1\35",
            "\1\16\12\uffff\1\35",
            "\1\16\12\uffff\1\35",
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
            return "()* loopback of 1323:1: ( ( (lv_path_2_0= ruleNextPathElementCS ) ) otherlv_3= '::' )*";
        }
    }
    static final String DFA35_eotS =
        "\20\uffff";
    static final String DFA35_eofS =
        "\20\uffff";
    static final String DFA35_minS =
        "\1\4\15\24\2\uffff";
    static final String DFA35_maxS =
        "\1\106\15\37\2\uffff";
    static final String DFA35_acceptS =
        "\16\uffff\1\2\1\1";
    static final String DFA35_specialS =
        "\20\uffff}>";
    static final String[] DFA35_transitionS = {
            "\1\1\1\2\12\uffff\1\10\1\uffff\1\13\10\uffff\1\6\1\15\1\5\3"+
            "\uffff\1\7\1\3\1\4\2\uffff\1\11\1\14\1\12\20\uffff\16\16",
            "\1\16\12\uffff\1\17",
            "\1\16\12\uffff\1\17",
            "\1\16\12\uffff\1\17",
            "\1\16\12\uffff\1\17",
            "\1\16\12\uffff\1\17",
            "\1\16\12\uffff\1\17",
            "\1\16\12\uffff\1\17",
            "\1\16\12\uffff\1\17",
            "\1\16\12\uffff\1\17",
            "\1\16\12\uffff\1\17",
            "\1\16\12\uffff\1\17",
            "\1\16\12\uffff\1\17",
            "\1\16\12\uffff\1\17",
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
            return "1370:1: ( (lv_pathName_1_0= ruleScopeNameCS ) )?";
        }
    }
    static final String DFA76_eotS =
        "\6\uffff";
    static final String DFA76_eofS =
        "\6\uffff";
    static final String DFA76_minS =
        "\3\4\3\uffff";
    static final String DFA76_maxS =
        "\3\126\3\uffff";
    static final String DFA76_acceptS =
        "\3\uffff\1\1\1\3\1\2";
    static final String DFA76_specialS =
        "\6\uffff}>";
    static final String[] DFA76_transitionS = {
            "\4\3\10\uffff\1\3\1\uffff\1\3\10\uffff\3\3\2\uffff\5\3\1\uffff"+
            "\3\3\1\1\1\2\16\uffff\16\3\4\uffff\4\3\2\uffff\1\3\3\uffff\1"+
            "\4\1\3",
            "\4\3\10\uffff\1\3\1\uffff\1\3\10\uffff\3\3\2\uffff\5\3\1\uffff"+
            "\3\3\1\1\1\2\16\uffff\16\3\4\uffff\4\3\2\uffff\1\3\3\uffff\1"+
            "\5\1\3",
            "\4\3\10\uffff\1\3\1\uffff\1\3\10\uffff\3\3\2\uffff\5\3\1\uffff"+
            "\3\3\1\1\1\2\16\uffff\16\3\4\uffff\4\3\2\uffff\1\3\3\uffff\1"+
            "\5\1\3",
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
            return "4334:1: ( (this_PrefixedExpCS_0= rulePrefixedExpCS ( () ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? ) | ( (lv_ownedExpression_8_0= ruleLetExpCS ) ) ) )? ) | ( () ( (lv_ownedOperator_10_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_11_0= ruleLetExpCS ) ) ) | this_LetExpCS_12= ruleLetExpCS )";
        }
    }
    static final String DFA71_eotS =
        "\23\uffff";
    static final String DFA71_eofS =
        "\1\21\22\uffff";
    static final String DFA71_minS =
        "\1\21\20\4\2\uffff";
    static final String DFA71_maxS =
        "\1\124\20\126\2\uffff";
    static final String DFA71_acceptS =
        "\21\uffff\1\2\1\1";
    static final String DFA71_specialS =
        "\23\uffff}>";
    static final String[] DFA71_transitionS = {
            "\1\21\1\uffff\1\21\2\uffff\2\21\1\uffff\2\21\3\uffff\1\21\1"+
            "\uffff\1\1\4\uffff\1\21\3\uffff\1\4\1\uffff\1\2\1\3\1\5\1\6"+
            "\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\16\uffff\1"+
            "\21\1\uffff\1\21\10\uffff\3\21",
            "\4\22\10\uffff\1\22\1\uffff\1\22\10\uffff\3\22\2\uffff\5\22"+
            "\1\uffff\5\22\16\uffff\16\22\4\uffff\4\22\2\uffff\1\22\3\uffff"+
            "\1\21\1\22",
            "\4\22\10\uffff\1\22\1\uffff\1\22\10\uffff\3\22\2\uffff\5\22"+
            "\1\uffff\5\22\16\uffff\16\22\4\uffff\4\22\2\uffff\1\22\3\uffff"+
            "\1\21\1\22",
            "\4\22\10\uffff\1\22\1\uffff\1\22\10\uffff\3\22\2\uffff\5\22"+
            "\1\uffff\5\22\16\uffff\16\22\4\uffff\4\22\2\uffff\1\22\3\uffff"+
            "\1\21\1\22",
            "\4\22\10\uffff\1\22\1\uffff\1\22\10\uffff\3\22\2\uffff\5\22"+
            "\1\uffff\5\22\16\uffff\16\22\4\uffff\4\22\2\uffff\1\22\3\uffff"+
            "\1\21\1\22",
            "\4\22\10\uffff\1\22\1\uffff\1\22\10\uffff\3\22\2\uffff\5\22"+
            "\1\uffff\5\22\16\uffff\16\22\4\uffff\4\22\2\uffff\1\22\3\uffff"+
            "\1\21\1\22",
            "\4\22\10\uffff\1\22\1\uffff\1\22\10\uffff\3\22\2\uffff\5\22"+
            "\1\uffff\5\22\16\uffff\16\22\4\uffff\4\22\2\uffff\1\22\3\uffff"+
            "\1\21\1\22",
            "\4\22\10\uffff\1\22\1\uffff\1\22\10\uffff\3\22\2\uffff\5\22"+
            "\1\uffff\5\22\16\uffff\16\22\4\uffff\4\22\2\uffff\1\22\3\uffff"+
            "\1\21\1\22",
            "\4\22\10\uffff\1\22\1\uffff\1\22\10\uffff\3\22\2\uffff\5\22"+
            "\1\uffff\5\22\16\uffff\16\22\4\uffff\4\22\2\uffff\1\22\3\uffff"+
            "\1\21\1\22",
            "\4\22\10\uffff\1\22\1\uffff\1\22\10\uffff\3\22\2\uffff\5\22"+
            "\1\uffff\5\22\16\uffff\16\22\4\uffff\4\22\2\uffff\1\22\3\uffff"+
            "\1\21\1\22",
            "\4\22\10\uffff\1\22\1\uffff\1\22\10\uffff\3\22\2\uffff\5\22"+
            "\1\uffff\5\22\16\uffff\16\22\4\uffff\4\22\2\uffff\1\22\3\uffff"+
            "\1\21\1\22",
            "\4\22\10\uffff\1\22\1\uffff\1\22\10\uffff\3\22\2\uffff\5\22"+
            "\1\uffff\5\22\16\uffff\16\22\4\uffff\4\22\2\uffff\1\22\3\uffff"+
            "\1\21\1\22",
            "\4\22\10\uffff\1\22\1\uffff\1\22\10\uffff\3\22\2\uffff\5\22"+
            "\1\uffff\5\22\16\uffff\16\22\4\uffff\4\22\2\uffff\1\22\3\uffff"+
            "\1\21\1\22",
            "\4\22\10\uffff\1\22\1\uffff\1\22\10\uffff\3\22\2\uffff\5\22"+
            "\1\uffff\5\22\16\uffff\16\22\4\uffff\4\22\2\uffff\1\22\3\uffff"+
            "\1\21\1\22",
            "\4\22\10\uffff\1\22\1\uffff\1\22\10\uffff\3\22\2\uffff\5\22"+
            "\1\uffff\5\22\16\uffff\16\22\4\uffff\4\22\2\uffff\1\22\3\uffff"+
            "\1\21\1\22",
            "\4\22\10\uffff\1\22\1\uffff\1\22\10\uffff\3\22\2\uffff\5\22"+
            "\1\uffff\5\22\16\uffff\16\22\4\uffff\4\22\2\uffff\1\22\3\uffff"+
            "\1\21\1\22",
            "\4\22\10\uffff\1\22\1\uffff\1\22\10\uffff\3\22\2\uffff\5\22"+
            "\1\uffff\5\22\16\uffff\16\22\4\uffff\4\22\2\uffff\1\22\3\uffff"+
            "\1\21\1\22",
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
            return "()* loopback of 4391:2: ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )*";
        }
    }
    static final String DFA94_eotS =
        "\50\uffff";
    static final String DFA94_eofS =
        "\50\uffff";
    static final String DFA94_minS =
        "\1\4\12\uffff\6\0\27\uffff";
    static final String DFA94_maxS =
        "\1\126\12\uffff\6\0\27\uffff";
    static final String DFA94_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\14\uffff\1\7\7\uffff\1\10\14\uffff\1\5"+
        "\1\6";
    static final String DFA94_specialS =
        "\13\uffff\1\0\1\1\1\2\1\3\1\4\1\5\27\uffff}>";
    static final String[] DFA94_transitionS = {
            "\2\31\2\4\10\uffff\1\31\1\uffff\1\31\10\uffff\3\31\2\uffff"+
            "\1\4\3\31\1\1\1\uffff\3\31\20\uffff\1\13\10\21\1\14\1\15\1\16"+
            "\1\17\1\20\4\uffff\4\4\2\uffff\1\2\4\uffff\1\3",
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

    static final short[] DFA94_eot = DFA.unpackEncodedString(DFA94_eotS);
    static final short[] DFA94_eof = DFA.unpackEncodedString(DFA94_eofS);
    static final char[] DFA94_min = DFA.unpackEncodedStringToUnsignedChars(DFA94_minS);
    static final char[] DFA94_max = DFA.unpackEncodedStringToUnsignedChars(DFA94_maxS);
    static final short[] DFA94_accept = DFA.unpackEncodedString(DFA94_acceptS);
    static final short[] DFA94_special = DFA.unpackEncodedString(DFA94_specialS);
    static final short[][] DFA94_transition;

    static {
        int numStates = DFA94_transitionS.length;
        DFA94_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA94_transition[i] = DFA.unpackEncodedString(DFA94_transitionS[i]);
        }
    }

    class DFA94 extends DFA {

        public DFA94(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 94;
            this.eot = DFA94_eot;
            this.eof = DFA94_eof;
            this.min = DFA94_min;
            this.max = DFA94_max;
            this.accept = DFA94_accept;
            this.special = DFA94_special;
            this.transition = DFA94_transition;
        }
        public String getDescription() {
            return "4641:1: (this_NestedExpCS_0= ruleNestedExpCS | this_IfExpCS_1= ruleIfExpCS | this_SelfExpCS_2= ruleSelfExpCS | this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS | this_CollectionLiteralExpCS_5= ruleCollectionLiteralExpCS | this_TypeLiteralExpCS_6= ruleTypeLiteralExpCS | ( () ( (lv_pathName_8_0= rulePathNameCS ) ) ( ( () otherlv_10= '[' ( (lv_firstIndexes_11_0= ruleExpCS ) ) (otherlv_12= ',' ( (lv_firstIndexes_13_0= ruleExpCS ) ) )* otherlv_14= ']' (otherlv_15= '[' ( (lv_secondIndexes_16_0= ruleExpCS ) ) (otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) ) )* otherlv_19= ']' )? ( ( (lv_atPre_20_0= '@' ) ) otherlv_21= 'pre' )? ) | ( () otherlv_23= '{' ( ( ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )* ) | ( (lv_value_27_0= ruleStringLiteral ) ) ) otherlv_28= '}' ) | ( ( ( (lv_atPre_29_0= '@' ) ) otherlv_30= 'pre' )? ( () otherlv_32= '(' ( ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_39= ')' )? ) ) ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA94_11 = input.LA(1);

                         
                        int index94_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred126_InternalQVTcore()) ) {s = 38;}

                        else if ( (synpred128_InternalQVTcore()) ) {s = 17;}

                         
                        input.seek(index94_11);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA94_12 = input.LA(1);

                         
                        int index94_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred127_InternalQVTcore()) ) {s = 39;}

                        else if ( (synpred128_InternalQVTcore()) ) {s = 17;}

                         
                        input.seek(index94_12);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA94_13 = input.LA(1);

                         
                        int index94_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred127_InternalQVTcore()) ) {s = 39;}

                        else if ( (synpred128_InternalQVTcore()) ) {s = 17;}

                         
                        input.seek(index94_13);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA94_14 = input.LA(1);

                         
                        int index94_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred127_InternalQVTcore()) ) {s = 39;}

                        else if ( (synpred128_InternalQVTcore()) ) {s = 17;}

                         
                        input.seek(index94_14);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA94_15 = input.LA(1);

                         
                        int index94_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred127_InternalQVTcore()) ) {s = 39;}

                        else if ( (synpred128_InternalQVTcore()) ) {s = 17;}

                         
                        input.seek(index94_15);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA94_16 = input.LA(1);

                         
                        int index94_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred127_InternalQVTcore()) ) {s = 39;}

                        else if ( (synpred128_InternalQVTcore()) ) {s = 17;}

                         
                        input.seek(index94_16);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 94, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleTopLevelCS_in_entryRuleTopLevelCS81 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTopLevelCS91 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleImportCS_in_ruleTopLevelCS138 = new BitSet(new long[]{0x000000C220010002L});
        public static final BitSet FOLLOW_ruleLibraryCS_in_ruleTopLevelCS165 = new BitSet(new long[]{0x000000C220010002L});
        public static final BitSet FOLLOW_ruleMappingCS_in_ruleTopLevelCS189 = new BitSet(new long[]{0x000000C000010002L});
        public static final BitSet FOLLOW_ruleTransformationCS_in_ruleTopLevelCS216 = new BitSet(new long[]{0x000000C000010002L});
        public static final BitSet FOLLOW_ruleQueryCS_in_ruleTopLevelCS243 = new BitSet(new long[]{0x000000C000010002L});
        public static final BitSet FOLLOW_ruleMappingCS_in_entryRuleMappingCS281 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMappingCS291 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleMappingCS340 = new BitSet(new long[]{0x000001CE38170030L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleMappingCS361 = new BitSet(new long[]{0x0000000000160000L});
        public static final BitSet FOLLOW_17_in_ruleMappingCS375 = new BitSet(new long[]{0x000001CE38050030L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleMappingCS402 = new BitSet(new long[]{0x0000000000140000L});
        public static final BitSet FOLLOW_18_in_ruleMappingCS417 = new BitSet(new long[]{0x000001CE38050030L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleMappingCS444 = new BitSet(new long[]{0x0000000000180000L});
        public static final BitSet FOLLOW_19_in_ruleMappingCS457 = new BitSet(new long[]{0x000001CE38050030L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleMappingCS484 = new BitSet(new long[]{0x0000000000180000L});
        public static final BitSet FOLLOW_20_in_ruleMappingCS500 = new BitSet(new long[]{0x000001CE38650030L});
        public static final BitSet FOLLOW_ruleNamedDomainCS_in_ruleMappingCS521 = new BitSet(new long[]{0x000001CE38650030L});
        public static final BitSet FOLLOW_21_in_ruleMappingCS535 = new BitSet(new long[]{0x0000001000000000L});
        public static final BitSet FOLLOW_ruleUnnamedDomainCS_in_ruleMappingCS556 = new BitSet(new long[]{0x0000000000410000L});
        public static final BitSet FOLLOW_ruleMappingCS_in_ruleMappingCS579 = new BitSet(new long[]{0x0000000000410000L});
        public static final BitSet FOLLOW_22_in_ruleMappingCS592 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBottomPatternCS_in_entryRuleBottomPatternCS628 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBottomPatternCS638 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrealizedVariableCS_in_ruleBottomPatternCS698 = new BitSet(new long[]{0x0000000000880000L});
        public static final BitSet FOLLOW_ruleRealizedVariableCS_in_ruleBottomPatternCS725 = new BitSet(new long[]{0x0000000000880000L});
        public static final BitSet FOLLOW_19_in_ruleBottomPatternCS739 = new BitSet(new long[]{0x000001CE38050030L});
        public static final BitSet FOLLOW_ruleUnrealizedVariableCS_in_ruleBottomPatternCS761 = new BitSet(new long[]{0x0000000000880000L});
        public static final BitSet FOLLOW_ruleRealizedVariableCS_in_ruleBottomPatternCS788 = new BitSet(new long[]{0x0000000000880000L});
        public static final BitSet FOLLOW_23_in_ruleBottomPatternCS803 = new BitSet(new long[]{0xFE0007DF390500F2L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleAssignmentCS_in_ruleBottomPatternCS826 = new BitSet(new long[]{0xFE0007DF390500F2L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleAssignmentCS_in_entryRuleAssignmentCS863 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAssignmentCS873 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_ruleAssignmentCS916 = new BitSet(new long[]{0xFE0007DF390500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleAssignmentCS951 = new BitSet(new long[]{0x0000000006000000L});
        public static final BitSet FOLLOW_25_in_ruleAssignmentCS964 = new BitSet(new long[]{0xFE0007DF390500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleAssignmentCS985 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_ruleAssignmentCS999 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDirectionCS_in_entryRuleDirectionCS1035 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDirectionCS1045 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleDirectionCS1103 = new BitSet(new long[]{0x0000000018000002L});
        public static final BitSet FOLLOW_27_in_ruleDirectionCS1117 = new BitSet(new long[]{0x000001CE38050030L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleDirectionCS1144 = new BitSet(new long[]{0x0000000010080002L});
        public static final BitSet FOLLOW_19_in_ruleDirectionCS1157 = new BitSet(new long[]{0x000001CE38050030L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleDirectionCS1184 = new BitSet(new long[]{0x0000000010080002L});
        public static final BitSet FOLLOW_28_in_ruleDirectionCS1201 = new BitSet(new long[]{0x000001CE38050030L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleDirectionCS1228 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_19_in_ruleDirectionCS1241 = new BitSet(new long[]{0x000001CE38050030L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleDirectionCS1268 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_ruleGuardPatternCS_in_entryRuleGuardPatternCS1308 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleGuardPatternCS1318 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrealizedVariableCS_in_ruleGuardPatternCS1377 = new BitSet(new long[]{0x0000000000880000L});
        public static final BitSet FOLLOW_19_in_ruleGuardPatternCS1390 = new BitSet(new long[]{0x000001CE38050030L});
        public static final BitSet FOLLOW_ruleUnrealizedVariableCS_in_ruleGuardPatternCS1411 = new BitSet(new long[]{0x0000000000880000L});
        public static final BitSet FOLLOW_23_in_ruleGuardPatternCS1425 = new BitSet(new long[]{0xFE0007DF390500F2L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleAssignmentCS_in_ruleGuardPatternCS1448 = new BitSet(new long[]{0xFE0007DF390500F2L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleImportCS_in_entryRuleImportCS1485 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleImportCS1495 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_ruleImportCS1532 = new BitSet(new long[]{0x000001CE380500B0L});
        public static final BitSet FOLLOW_ruleIdentifier_in_ruleImportCS1554 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_30_in_ruleImportCS1566 = new BitSet(new long[]{0x000001CE380500B0L});
        public static final BitSet FOLLOW_ruleURIPathNameCS_in_ruleImportCS1589 = new BitSet(new long[]{0x0000000084000000L});
        public static final BitSet FOLLOW_31_in_ruleImportCS1608 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_32_in_ruleImportCS1633 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_ruleImportCS1647 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibraryCS_in_entryRuleLibraryCS1683 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibraryCS1693 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_ruleLibraryCS1730 = new BitSet(new long[]{0x000001CE380500B0L});
        public static final BitSet FOLLOW_ruleURI_in_ruleLibraryCS1757 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_ruleLibraryCS1769 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNamedDomainCS_in_entryRuleNamedDomainCS1805 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNamedDomainCS1815 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_ruleNamedDomainCS1858 = new BitSet(new long[]{0x000001CE38050030L});
        public static final BitSet FOLLOW_35_in_ruleNamedDomainCS1890 = new BitSet(new long[]{0x000001CE38050030L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleNamedDomainCS1931 = new BitSet(new long[]{0x0000001000000000L});
        public static final BitSet FOLLOW_36_in_ruleNamedDomainCS1943 = new BitSet(new long[]{0xFE0007FF390500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleGuardPatternCS_in_ruleNamedDomainCS1964 = new BitSet(new long[]{0x0000002000000000L});
        public static final BitSet FOLLOW_37_in_ruleNamedDomainCS1977 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleNamedDomainCS1989 = new BitSet(new long[]{0xFE0007DF394500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleBottomPatternCS_in_ruleNamedDomainCS2010 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_22_in_ruleNamedDomainCS2023 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParamDeclarationCS_in_entryRuleParamDeclarationCS2059 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParamDeclarationCS2069 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleParamDeclarationCS2115 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_30_in_ruleParamDeclarationCS2127 = new BitSet(new long[]{0xFE0007DF380500F0L,0x000000000042787FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleParamDeclarationCS2148 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQueryCS_in_entryRuleQueryCS2184 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleQueryCS2194 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_ruleQueryCS2231 = new BitSet(new long[]{0xFE0007DF380500F0L,0x000000000042787FL});
        public static final BitSet FOLLOW_ruleScopeNameCS_in_ruleQueryCS2252 = new BitSet(new long[]{0x000001CE38050030L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleQueryCS2273 = new BitSet(new long[]{0x0000001000000000L});
        public static final BitSet FOLLOW_36_in_ruleQueryCS2285 = new BitSet(new long[]{0x000001EE38050030L});
        public static final BitSet FOLLOW_ruleParamDeclarationCS_in_ruleQueryCS2307 = new BitSet(new long[]{0x0000002000080000L});
        public static final BitSet FOLLOW_19_in_ruleQueryCS2320 = new BitSet(new long[]{0x000001CE38050030L});
        public static final BitSet FOLLOW_ruleParamDeclarationCS_in_ruleQueryCS2341 = new BitSet(new long[]{0x0000002000080000L});
        public static final BitSet FOLLOW_37_in_ruleQueryCS2357 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_30_in_ruleQueryCS2369 = new BitSet(new long[]{0xFE0007DF380500F0L,0x000000000042787FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleQueryCS2390 = new BitSet(new long[]{0x0000000004100000L});
        public static final BitSet FOLLOW_26_in_ruleQueryCS2403 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleQueryCS2422 = new BitSet(new long[]{0xFE0007DF390500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleQueryCS2443 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_22_in_ruleQueryCS2455 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScopeNameCS_in_entryRuleScopeNameCS2493 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleScopeNameCS2503 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFirstPathElementCS_in_ruleScopeNameCS2549 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_31_in_ruleScopeNameCS2561 = new BitSet(new long[]{0xFE0001CE38050032L,0x000000000000007FL});
        public static final BitSet FOLLOW_ruleNextPathElementCS_in_ruleScopeNameCS2583 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_31_in_ruleScopeNameCS2595 = new BitSet(new long[]{0xFE0001CE38050032L,0x000000000000007FL});
        public static final BitSet FOLLOW_ruleTransformationCS_in_entryRuleTransformationCS2633 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTransformationCS2643 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_39_in_ruleTransformationCS2680 = new BitSet(new long[]{0xFE0007DF380500F0L,0x000000000042787FL});
        public static final BitSet FOLLOW_ruleScopeNameCS_in_ruleTransformationCS2701 = new BitSet(new long[]{0xFE0001CE38050030L,0x000000000000007FL});
        public static final BitSet FOLLOW_ruleUnreservedName_in_ruleTransformationCS2723 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleTransformationCS2735 = new BitSet(new long[]{0x000001CE3C450030L});
        public static final BitSet FOLLOW_ruleDirectionCS_in_ruleTransformationCS2757 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_ruleTransformationCS2769 = new BitSet(new long[]{0x000001CE3C450030L});
        public static final BitSet FOLLOW_22_in_ruleTransformationCS2783 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrealizedVariableCS_in_entryRuleUnrealizedVariableCS2819 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnrealizedVariableCS2829 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleUnrealizedVariableCS2875 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_30_in_ruleUnrealizedVariableCS2887 = new BitSet(new long[]{0xFE0007DF380500F0L,0x000000000042787FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleUnrealizedVariableCS2908 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRealizedVariableCS_in_entryRuleRealizedVariableCS2944 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRealizedVariableCS2954 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_40_in_ruleRealizedVariableCS2991 = new BitSet(new long[]{0x000001CE38050030L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleRealizedVariableCS3012 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_30_in_ruleRealizedVariableCS3024 = new BitSet(new long[]{0xFE0007DF380500F0L,0x000000000042787FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleRealizedVariableCS3045 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnnamedDomainCS_in_entryRuleUnnamedDomainCS3081 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnnamedDomainCS3091 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_ruleUnnamedDomainCS3140 = new BitSet(new long[]{0xFE0007FF390500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleGuardPatternCS_in_ruleUnnamedDomainCS3161 = new BitSet(new long[]{0x0000002000000000L});
        public static final BitSet FOLLOW_37_in_ruleUnnamedDomainCS3174 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleUnnamedDomainCS3186 = new BitSet(new long[]{0xFE0007DF394500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleBottomPatternCS_in_ruleUnnamedDomainCS3207 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_22_in_ruleUnnamedDomainCS3220 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_entryRuleUnrestrictedName3257 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnrestrictedName3268 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLUnrestrictedName_in_ruleUnrestrictedName3315 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_ruleUnrestrictedName3339 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_ruleUnrestrictedName3358 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_ruleUnrestrictedName3377 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_ruleUnrestrictedName3396 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_ruleUnrestrictedName3415 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleUnrestrictedName3434 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_ruleUnrestrictedName3453 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_40_in_ruleUnrestrictedName3472 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleUnrestrictedName3491 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_39_in_ruleUnrestrictedName3510 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_ruleUnrestrictedName3529 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleID_in_entryRuleID3572 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleID3583 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_SIMPLE_ID_in_ruleID3623 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ESCAPED_ID_in_ruleID3649 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLOWER_in_entryRuleLOWER3695 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLOWER3706 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleLOWER3745 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUPPER_in_entryRuleUPPER3790 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUPPER3801 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleUPPER3841 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_ruleUPPER3865 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNUMBER_LITERAL_in_entryRuleNUMBER_LITERAL3906 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNUMBER_LITERAL3917 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleNUMBER_LITERAL3956 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleURI_in_entryRuleURI4001 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleURI4012 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_SINGLE_QUOTED_STRING_in_ruleURI4051 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLUnaryOperatorCS_in_entryRuleEssentialOCLUnaryOperatorCS4097 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEssentialOCLUnaryOperatorCS4107 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_41_in_ruleEssentialOCLUnaryOperatorCS4151 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_42_in_ruleEssentialOCLUnaryOperatorCS4180 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLInfixOperatorCS_in_entryRuleEssentialOCLInfixOperatorCS4231 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEssentialOCLInfixOperatorCS4241 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_ruleEssentialOCLInfixOperatorCS4285 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_43_in_ruleEssentialOCLInfixOperatorCS4314 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_44_in_ruleEssentialOCLInfixOperatorCS4343 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_41_in_ruleEssentialOCLInfixOperatorCS4372 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_45_in_ruleEssentialOCLInfixOperatorCS4401 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_46_in_ruleEssentialOCLInfixOperatorCS4430 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_47_in_ruleEssentialOCLInfixOperatorCS4459 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_48_in_ruleEssentialOCLInfixOperatorCS4488 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_49_in_ruleEssentialOCLInfixOperatorCS4517 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_50_in_ruleEssentialOCLInfixOperatorCS4546 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_51_in_ruleEssentialOCLInfixOperatorCS4575 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_52_in_ruleEssentialOCLInfixOperatorCS4604 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_53_in_ruleEssentialOCLInfixOperatorCS4633 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_54_in_ruleEssentialOCLInfixOperatorCS4662 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLNavigationOperatorCS_in_entryRuleEssentialOCLNavigationOperatorCS4713 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEssentialOCLNavigationOperatorCS4723 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_55_in_ruleEssentialOCLNavigationOperatorCS4767 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_56_in_ruleEssentialOCLNavigationOperatorCS4796 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_entryRuleIdentifier4848 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIdentifier4859 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleID_in_ruleIdentifier4905 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral4950 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteral4961 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_SINGLE_QUOTED_STRING_in_ruleStringLiteral5000 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBinaryOperatorCS_in_entryRuleBinaryOperatorCS5044 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBinaryOperatorCS5054 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInfixOperatorCS_in_ruleBinaryOperatorCS5104 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigationOperatorCS_in_ruleBinaryOperatorCS5134 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInfixOperatorCS_in_entryRuleInfixOperatorCS5169 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleInfixOperatorCS5179 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLInfixOperatorCS_in_ruleInfixOperatorCS5228 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigationOperatorCS_in_entryRuleNavigationOperatorCS5262 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigationOperatorCS5272 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLNavigationOperatorCS_in_ruleNavigationOperatorCS5321 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnaryOperatorCS_in_entryRuleUnaryOperatorCS5355 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnaryOperatorCS5365 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLUnaryOperatorCS_in_ruleUnaryOperatorCS5414 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLUnrestrictedName_in_entryRuleEssentialOCLUnrestrictedName5449 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEssentialOCLUnrestrictedName5460 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_ruleEssentialOCLUnrestrictedName5506 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLUnreservedName_in_entryRuleEssentialOCLUnreservedName5551 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEssentialOCLUnreservedName5562 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleEssentialOCLUnreservedName5609 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionTypeIdentifier_in_ruleEssentialOCLUnreservedName5642 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveTypeIdentifier_in_ruleEssentialOCLUnreservedName5675 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_57_in_ruleEssentialOCLUnreservedName5699 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnreservedName_in_entryRuleUnreservedName5740 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnreservedName5751 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLUnreservedName_in_ruleUnreservedName5797 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePathNameCS_in_entryRulePathNameCS5841 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePathNameCS5851 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFirstPathElementCS_in_rulePathNameCS5897 = new BitSet(new long[]{0x0000000080000002L});
        public static final BitSet FOLLOW_31_in_rulePathNameCS5910 = new BitSet(new long[]{0xFE0001CE38050030L,0x000000000000007FL});
        public static final BitSet FOLLOW_ruleNextPathElementCS_in_rulePathNameCS5931 = new BitSet(new long[]{0x0000000080000002L});
        public static final BitSet FOLLOW_ruleFirstPathElementCS_in_entryRuleFirstPathElementCS5969 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFirstPathElementCS5979 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleFirstPathElementCS6030 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNextPathElementCS_in_entryRuleNextPathElementCS6065 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNextPathElementCS6075 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnreservedName_in_ruleNextPathElementCS6126 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleURIPathNameCS_in_entryRuleURIPathNameCS6161 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleURIPathNameCS6171 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleURIFirstPathElementCS_in_ruleURIPathNameCS6217 = new BitSet(new long[]{0x0000000080000002L});
        public static final BitSet FOLLOW_31_in_ruleURIPathNameCS6230 = new BitSet(new long[]{0xFE0001CE38050030L,0x000000000000007FL});
        public static final BitSet FOLLOW_ruleNextPathElementCS_in_ruleURIPathNameCS6251 = new BitSet(new long[]{0x0000000080000002L});
        public static final BitSet FOLLOW_ruleURIFirstPathElementCS_in_entryRuleURIFirstPathElementCS6289 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleURIFirstPathElementCS6299 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleURIFirstPathElementCS6351 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleURI_in_ruleURIFirstPathElementCS6397 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveTypeIdentifier_in_entryRulePrimitiveTypeIdentifier6435 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrimitiveTypeIdentifier6446 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_58_in_rulePrimitiveTypeIdentifier6484 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_59_in_rulePrimitiveTypeIdentifier6503 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_60_in_rulePrimitiveTypeIdentifier6522 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_61_in_rulePrimitiveTypeIdentifier6541 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_62_in_rulePrimitiveTypeIdentifier6560 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_63_in_rulePrimitiveTypeIdentifier6579 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_64_in_rulePrimitiveTypeIdentifier6598 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_65_in_rulePrimitiveTypeIdentifier6617 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveTypeCS_in_entryRulePrimitiveTypeCS6657 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrimitiveTypeCS6667 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveTypeIdentifier_in_rulePrimitiveTypeCS6712 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionTypeIdentifier_in_entryRuleCollectionTypeIdentifier6748 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCollectionTypeIdentifier6759 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_66_in_ruleCollectionTypeIdentifier6797 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_67_in_ruleCollectionTypeIdentifier6816 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_68_in_ruleCollectionTypeIdentifier6835 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_69_in_ruleCollectionTypeIdentifier6854 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_70_in_ruleCollectionTypeIdentifier6873 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionTypeCS_in_entryRuleCollectionTypeCS6913 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCollectionTypeCS6923 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionTypeIdentifier_in_ruleCollectionTypeCS6969 = new BitSet(new long[]{0x0000001000000002L});
        public static final BitSet FOLLOW_36_in_ruleCollectionTypeCS6982 = new BitSet(new long[]{0xFE0007DF380500F0L,0x000000000042787FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleCollectionTypeCS7003 = new BitSet(new long[]{0x0000002000000000L});
        public static final BitSet FOLLOW_37_in_ruleCollectionTypeCS7015 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiplicityBoundsCS_in_entryRuleMultiplicityBoundsCS7053 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicityBoundsCS7063 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLOWER_in_ruleMultiplicityBoundsCS7109 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
        public static final BitSet FOLLOW_71_in_ruleMultiplicityBoundsCS7122 = new BitSet(new long[]{0x0000000100000040L});
        public static final BitSet FOLLOW_ruleUPPER_in_ruleMultiplicityBoundsCS7143 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiplicityCS_in_entryRuleMultiplicityCS7181 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicityCS7191 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_72_in_ruleMultiplicityCS7228 = new BitSet(new long[]{0x0000100100000040L,0x0000000000000400L});
        public static final BitSet FOLLOW_ruleMultiplicityBoundsCS_in_ruleMultiplicityCS7254 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
        public static final BitSet FOLLOW_ruleMultiplicityStringCS_in_ruleMultiplicityCS7284 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
        public static final BitSet FOLLOW_73_in_ruleMultiplicityCS7296 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiplicityStringCS_in_entryRuleMultiplicityStringCS7332 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicityStringCS7342 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_ruleMultiplicityStringCS7386 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_44_in_ruleMultiplicityStringCS7415 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_74_in_ruleMultiplicityStringCS7444 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTupleTypeCS_in_entryRuleTupleTypeCS7495 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTupleTypeCS7505 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_57_in_ruleTupleTypeCS7548 = new BitSet(new long[]{0x0000001000000002L});
        public static final BitSet FOLLOW_36_in_ruleTupleTypeCS7574 = new BitSet(new long[]{0x000001EE38050030L});
        public static final BitSet FOLLOW_ruleTuplePartCS_in_ruleTupleTypeCS7596 = new BitSet(new long[]{0x0000002000080000L});
        public static final BitSet FOLLOW_19_in_ruleTupleTypeCS7609 = new BitSet(new long[]{0x000001CE38050030L});
        public static final BitSet FOLLOW_ruleTuplePartCS_in_ruleTupleTypeCS7630 = new BitSet(new long[]{0x0000002000080000L});
        public static final BitSet FOLLOW_37_in_ruleTupleTypeCS7646 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTuplePartCS_in_entryRuleTuplePartCS7684 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTuplePartCS7694 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleTuplePartCS7740 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_30_in_ruleTuplePartCS7752 = new BitSet(new long[]{0xFE0007DF380500F0L,0x000000000042787FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleTuplePartCS7773 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionLiteralExpCS_in_entryRuleCollectionLiteralExpCS7809 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCollectionLiteralExpCS7819 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionTypeCS_in_ruleCollectionLiteralExpCS7865 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleCollectionLiteralExpCS7877 = new BitSet(new long[]{0xFE0007DF394500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleCollectionLiteralPartCS_in_ruleCollectionLiteralExpCS7899 = new BitSet(new long[]{0x0000000000480000L});
        public static final BitSet FOLLOW_19_in_ruleCollectionLiteralExpCS7912 = new BitSet(new long[]{0xFE0007DF390500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleCollectionLiteralPartCS_in_ruleCollectionLiteralExpCS7933 = new BitSet(new long[]{0x0000000000480000L});
        public static final BitSet FOLLOW_22_in_ruleCollectionLiteralExpCS7949 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionLiteralPartCS_in_entryRuleCollectionLiteralPartCS7985 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCollectionLiteralPartCS7995 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleCollectionLiteralPartCS8041 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
        public static final BitSet FOLLOW_71_in_ruleCollectionLiteralPartCS8054 = new BitSet(new long[]{0xFE0007DF390500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleCollectionLiteralPartCS8075 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConstructorPartCS_in_entryRuleConstructorPartCS8113 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleConstructorPartCS8123 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleConstructorPartCS8175 = new BitSet(new long[]{0x0002000000000000L});
        public static final BitSet FOLLOW_49_in_ruleConstructorPartCS8187 = new BitSet(new long[]{0xFE0007DF390500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleConstructorPartCS8208 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveLiteralExpCS_in_entryRulePrimitiveLiteralExpCS8244 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrimitiveLiteralExpCS8254 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNumberLiteralExpCS_in_rulePrimitiveLiteralExpCS8304 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringLiteralExpCS_in_rulePrimitiveLiteralExpCS8334 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBooleanLiteralExpCS_in_rulePrimitiveLiteralExpCS8364 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnlimitedNaturalLiteralExpCS_in_rulePrimitiveLiteralExpCS8394 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInvalidLiteralExpCS_in_rulePrimitiveLiteralExpCS8424 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNullLiteralExpCS_in_rulePrimitiveLiteralExpCS8454 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTupleLiteralExpCS_in_entryRuleTupleLiteralExpCS8489 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTupleLiteralExpCS8499 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_57_in_ruleTupleLiteralExpCS8536 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleTupleLiteralExpCS8548 = new BitSet(new long[]{0x000001CE38050030L});
        public static final BitSet FOLLOW_ruleTupleLiteralPartCS_in_ruleTupleLiteralExpCS8569 = new BitSet(new long[]{0x0000000000480000L});
        public static final BitSet FOLLOW_19_in_ruleTupleLiteralExpCS8582 = new BitSet(new long[]{0x000001CE38050030L});
        public static final BitSet FOLLOW_ruleTupleLiteralPartCS_in_ruleTupleLiteralExpCS8603 = new BitSet(new long[]{0x0000000000480000L});
        public static final BitSet FOLLOW_22_in_ruleTupleLiteralExpCS8617 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTupleLiteralPartCS_in_entryRuleTupleLiteralPartCS8653 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTupleLiteralPartCS8663 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleTupleLiteralPartCS8709 = new BitSet(new long[]{0x0002000040000000L});
        public static final BitSet FOLLOW_30_in_ruleTupleLiteralPartCS8722 = new BitSet(new long[]{0xFE0007DF380500F0L,0x000000000042787FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleTupleLiteralPartCS8743 = new BitSet(new long[]{0x0002000000000000L});
        public static final BitSet FOLLOW_49_in_ruleTupleLiteralPartCS8757 = new BitSet(new long[]{0xFE0007DF390500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleTupleLiteralPartCS8778 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNumberLiteralExpCS_in_entryRuleNumberLiteralExpCS8814 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNumberLiteralExpCS8824 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNUMBER_LITERAL_in_ruleNumberLiteralExpCS8869 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringLiteralExpCS_in_entryRuleStringLiteralExpCS8904 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteralExpCS8914 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringLiteral_in_ruleStringLiteralExpCS8959 = new BitSet(new long[]{0x0000000000000082L});
        public static final BitSet FOLLOW_ruleBooleanLiteralExpCS_in_entryRuleBooleanLiteralExpCS8995 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBooleanLiteralExpCS9005 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_75_in_ruleBooleanLiteralExpCS9048 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_76_in_ruleBooleanLiteralExpCS9085 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnlimitedNaturalLiteralExpCS_in_entryRuleUnlimitedNaturalLiteralExpCS9134 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnlimitedNaturalLiteralExpCS9144 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_ruleUnlimitedNaturalLiteralExpCS9193 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInvalidLiteralExpCS_in_entryRuleInvalidLiteralExpCS9229 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleInvalidLiteralExpCS9239 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_77_in_ruleInvalidLiteralExpCS9288 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNullLiteralExpCS_in_entryRuleNullLiteralExpCS9324 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNullLiteralExpCS9334 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_78_in_ruleNullLiteralExpCS9383 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralCS_in_entryRuleTypeLiteralCS9419 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeLiteralCS9429 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveTypeCS_in_ruleTypeLiteralCS9479 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionTypeCS_in_ruleTypeLiteralCS9509 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTupleTypeCS_in_ruleTypeLiteralCS9539 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralWithMultiplicityCS_in_entryRuleTypeLiteralWithMultiplicityCS9574 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeLiteralWithMultiplicityCS9584 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralCS_in_ruleTypeLiteralWithMultiplicityCS9634 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000100L});
        public static final BitSet FOLLOW_ruleMultiplicityCS_in_ruleTypeLiteralWithMultiplicityCS9654 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralExpCS_in_entryRuleTypeLiteralExpCS9691 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeLiteralExpCS9701 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralWithMultiplicityCS_in_ruleTypeLiteralExpCS9746 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeNameExpCS_in_entryRuleTypeNameExpCS9781 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeNameExpCS9791 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePathNameCS_in_ruleTypeNameExpCS9836 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_entryRuleTypeExpCS9871 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeExpCS9881 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeNameExpCS_in_ruleTypeExpCS9932 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000100L});
        public static final BitSet FOLLOW_ruleTypeLiteralCS_in_ruleTypeExpCS9962 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000100L});
        public static final BitSet FOLLOW_ruleMultiplicityCS_in_ruleTypeExpCS9983 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpCS_in_entryRuleExpCS10020 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleExpCS10030 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrefixedExpCS_in_ruleExpCS10081 = new BitSet(new long[]{0x01FFFA0100000002L});
        public static final BitSet FOLLOW_ruleBinaryOperatorCS_in_ruleExpCS10114 = new BitSet(new long[]{0xFE0007DF390500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_rulePrefixedExpCS_in_ruleExpCS10137 = new BitSet(new long[]{0x01FFFA0100000002L});
        public static final BitSet FOLLOW_ruleBinaryOperatorCS_in_ruleExpCS10159 = new BitSet(new long[]{0xFE0007DF380500F0L,0x000000000042787FL});
        public static final BitSet FOLLOW_rulePrefixedExpCS_in_ruleExpCS10180 = new BitSet(new long[]{0x01FFFA0100000002L});
        public static final BitSet FOLLOW_ruleBinaryOperatorCS_in_ruleExpCS10204 = new BitSet(new long[]{0xFE0007DF390500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleLetExpCS_in_ruleExpCS10225 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLetExpCS_in_ruleExpCS10255 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnaryOperatorCS_in_ruleExpCS10299 = new BitSet(new long[]{0xFE0007DF390500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleLetExpCS_in_ruleExpCS10321 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLetExpCS_in_ruleExpCS10353 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrefixedExpCS_in_entryRulePrefixedExpCS10388 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrefixedExpCS10398 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnaryOperatorCS_in_rulePrefixedExpCS10457 = new BitSet(new long[]{0xFE0007DF380500F0L,0x000000000042787FL});
        public static final BitSet FOLLOW_rulePrimaryExpCS_in_rulePrefixedExpCS10479 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimaryExpCS_in_rulePrefixedExpCS10511 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimaryExpCS_in_entryRulePrimaryExpCS10546 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpCS10556 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedExpCS_in_rulePrimaryExpCS10606 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIfExpCS_in_rulePrimaryExpCS10636 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSelfExpCS_in_rulePrimaryExpCS10666 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveLiteralExpCS_in_rulePrimaryExpCS10696 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTupleLiteralExpCS_in_rulePrimaryExpCS10726 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionLiteralExpCS_in_rulePrimaryExpCS10756 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralExpCS_in_rulePrimaryExpCS10786 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePathNameCS_in_rulePrimaryExpCS10825 = new BitSet(new long[]{0x0000001000100002L,0x0000000000008100L});
        public static final BitSet FOLLOW_72_in_rulePrimaryExpCS10851 = new BitSet(new long[]{0xFE0007DF390500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleExpCS_in_rulePrimaryExpCS10872 = new BitSet(new long[]{0x0000000000080000L,0x0000000000000200L});
        public static final BitSet FOLLOW_19_in_rulePrimaryExpCS10885 = new BitSet(new long[]{0xFE0007DF390500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleExpCS_in_rulePrimaryExpCS10906 = new BitSet(new long[]{0x0000000000080000L,0x0000000000000200L});
        public static final BitSet FOLLOW_73_in_rulePrimaryExpCS10920 = new BitSet(new long[]{0x0000000000000002L,0x0000000000008100L});
        public static final BitSet FOLLOW_72_in_rulePrimaryExpCS10933 = new BitSet(new long[]{0xFE0007DF390500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleExpCS_in_rulePrimaryExpCS10954 = new BitSet(new long[]{0x0000000000080000L,0x0000000000000200L});
        public static final BitSet FOLLOW_19_in_rulePrimaryExpCS10967 = new BitSet(new long[]{0xFE0007DF390500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleExpCS_in_rulePrimaryExpCS10988 = new BitSet(new long[]{0x0000000000080000L,0x0000000000000200L});
        public static final BitSet FOLLOW_73_in_rulePrimaryExpCS11002 = new BitSet(new long[]{0x0000000000000002L,0x0000000000008000L});
        public static final BitSet FOLLOW_79_in_rulePrimaryExpCS11023 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
        public static final BitSet FOLLOW_80_in_rulePrimaryExpCS11048 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rulePrimaryExpCS11082 = new BitSet(new long[]{0x000001CE380500B0L});
        public static final BitSet FOLLOW_ruleConstructorPartCS_in_rulePrimaryExpCS11105 = new BitSet(new long[]{0x0000000000480000L});
        public static final BitSet FOLLOW_19_in_rulePrimaryExpCS11118 = new BitSet(new long[]{0x000001CE38050030L});
        public static final BitSet FOLLOW_ruleConstructorPartCS_in_rulePrimaryExpCS11139 = new BitSet(new long[]{0x0000000000480000L});
        public static final BitSet FOLLOW_ruleStringLiteral_in_rulePrimaryExpCS11169 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_22_in_rulePrimaryExpCS11182 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_79_in_rulePrimaryExpCS11209 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
        public static final BitSet FOLLOW_80_in_rulePrimaryExpCS11234 = new BitSet(new long[]{0x0000001000000002L});
        public static final BitSet FOLLOW_36_in_rulePrimaryExpCS11261 = new BitSet(new long[]{0xFE0007FF390500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleNavigatingArgCS_in_rulePrimaryExpCS11283 = new BitSet(new long[]{0x0000002004880000L});
        public static final BitSet FOLLOW_ruleNavigatingCommaArgCS_in_rulePrimaryExpCS11304 = new BitSet(new long[]{0x0000002004880000L});
        public static final BitSet FOLLOW_ruleNavigatingSemiArgCS_in_rulePrimaryExpCS11327 = new BitSet(new long[]{0x0000002000880000L});
        public static final BitSet FOLLOW_ruleNavigatingCommaArgCS_in_rulePrimaryExpCS11348 = new BitSet(new long[]{0x0000002000880000L});
        public static final BitSet FOLLOW_ruleNavigatingBarArgCS_in_rulePrimaryExpCS11373 = new BitSet(new long[]{0x0000002000080000L});
        public static final BitSet FOLLOW_ruleNavigatingCommaArgCS_in_rulePrimaryExpCS11394 = new BitSet(new long[]{0x0000002000080000L});
        public static final BitSet FOLLOW_37_in_rulePrimaryExpCS11411 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingArgCS_in_entryRuleNavigatingArgCS11452 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigatingArgCS11462 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingArgCS11508 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_30_in_ruleNavigatingArgCS11521 = new BitSet(new long[]{0xFE0007DF380500F0L,0x000000000042787FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleNavigatingArgCS11542 = new BitSet(new long[]{0x0002000000000002L});
        public static final BitSet FOLLOW_49_in_ruleNavigatingArgCS11555 = new BitSet(new long[]{0xFE0007DF390500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNavigatingArgCS11576 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingBarArgCS_in_entryRuleNavigatingBarArgCS11616 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigatingBarArgCS11626 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_ruleNavigatingBarArgCS11669 = new BitSet(new long[]{0xFE0007DF390500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingBarArgCS11703 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_30_in_ruleNavigatingBarArgCS11716 = new BitSet(new long[]{0xFE0007DF380500F0L,0x000000000042787FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleNavigatingBarArgCS11737 = new BitSet(new long[]{0x0002000000000002L});
        public static final BitSet FOLLOW_49_in_ruleNavigatingBarArgCS11750 = new BitSet(new long[]{0xFE0007DF390500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNavigatingBarArgCS11771 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingCommaArgCS_in_entryRuleNavigatingCommaArgCS11811 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigatingCommaArgCS11821 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleNavigatingCommaArgCS11864 = new BitSet(new long[]{0xFE0007DF390500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingCommaArgCS11898 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_30_in_ruleNavigatingCommaArgCS11911 = new BitSet(new long[]{0xFE0007DF380500F0L,0x000000000042787FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleNavigatingCommaArgCS11932 = new BitSet(new long[]{0x0002000000000002L});
        public static final BitSet FOLLOW_49_in_ruleNavigatingCommaArgCS11945 = new BitSet(new long[]{0xFE0007DF390500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNavigatingCommaArgCS11966 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingSemiArgCS_in_entryRuleNavigatingSemiArgCS12006 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigatingSemiArgCS12016 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_ruleNavigatingSemiArgCS12059 = new BitSet(new long[]{0xFE0007DF390500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingSemiArgCS12093 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_30_in_ruleNavigatingSemiArgCS12106 = new BitSet(new long[]{0xFE0007DF380500F0L,0x000000000042787FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleNavigatingSemiArgCS12127 = new BitSet(new long[]{0x0002000000000002L});
        public static final BitSet FOLLOW_49_in_ruleNavigatingSemiArgCS12140 = new BitSet(new long[]{0xFE0007DF390500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNavigatingSemiArgCS12161 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingArgExpCS_in_entryRuleNavigatingArgExpCS12201 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigatingArgExpCS12211 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNavigatingArgExpCS12260 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIfExpCS_in_entryRuleIfExpCS12294 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIfExpCS12304 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_81_in_ruleIfExpCS12341 = new BitSet(new long[]{0xFE0007DF390500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleIfExpCS12362 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
        public static final BitSet FOLLOW_82_in_ruleIfExpCS12374 = new BitSet(new long[]{0xFE0007DF390500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleIfExpCS12395 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
        public static final BitSet FOLLOW_83_in_ruleIfExpCS12407 = new BitSet(new long[]{0xFE0007DF390500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleIfExpCS12428 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
        public static final BitSet FOLLOW_84_in_ruleIfExpCS12440 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLetExpCS_in_entryRuleLetExpCS12476 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLetExpCS12486 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_85_in_ruleLetExpCS12523 = new BitSet(new long[]{0x000001CE38050030L});
        public static final BitSet FOLLOW_ruleLetVariableCS_in_ruleLetExpCS12544 = new BitSet(new long[]{0x00000000000A0000L});
        public static final BitSet FOLLOW_19_in_ruleLetExpCS12557 = new BitSet(new long[]{0x000001CE38050030L});
        public static final BitSet FOLLOW_ruleLetVariableCS_in_ruleLetExpCS12578 = new BitSet(new long[]{0x00000000000A0000L});
        public static final BitSet FOLLOW_17_in_ruleLetExpCS12592 = new BitSet(new long[]{0xFE0007DF390500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleLetExpCS12613 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLetVariableCS_in_entryRuleLetVariableCS12649 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLetVariableCS12659 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleLetVariableCS12705 = new BitSet(new long[]{0x0002000040000000L});
        public static final BitSet FOLLOW_30_in_ruleLetVariableCS12718 = new BitSet(new long[]{0xFE0007DF380500F0L,0x000000000042787FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleLetVariableCS12739 = new BitSet(new long[]{0x0002000000000000L});
        public static final BitSet FOLLOW_49_in_ruleLetVariableCS12753 = new BitSet(new long[]{0xFE0007DF390500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleLetVariableCS12774 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedExpCS_in_entryRuleNestedExpCS12810 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNestedExpCS12820 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_ruleNestedExpCS12857 = new BitSet(new long[]{0xFE0007DF390500F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNestedExpCS12878 = new BitSet(new long[]{0x0000002000000000L});
        public static final BitSet FOLLOW_37_in_ruleNestedExpCS12890 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSelfExpCS_in_entryRuleSelfExpCS12926 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSelfExpCS12936 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_86_in_ruleSelfExpCS12985 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGuardPatternCS_in_synpred32_InternalQVTcore1964 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBottomPatternCS_in_synpred33_InternalQVTcore2010 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGuardPatternCS_in_synpred40_InternalQVTcore3161 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBottomPatternCS_in_synpred41_InternalQVTcore3207 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTupleLiteralExpCS_in_synpred126_InternalQVTcore10726 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionLiteralExpCS_in_synpred127_InternalQVTcore10756 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralExpCS_in_synpred128_InternalQVTcore10786 = new BitSet(new long[]{0x0000000000000002L});
    }


}