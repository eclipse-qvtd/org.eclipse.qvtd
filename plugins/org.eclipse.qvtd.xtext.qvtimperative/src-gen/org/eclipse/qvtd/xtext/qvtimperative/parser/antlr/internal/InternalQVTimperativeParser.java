package org.eclipse.qvtd.xtext.qvtimperative.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalQVTimperativeParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_SIMPLE_ID", "RULE_ESCAPED_ID", "RULE_INT", "RULE_SINGLE_QUOTED_STRING", "RULE_ESCAPED_CHARACTER", "RULE_LETTER_CHARACTER", "RULE_DOUBLE_QUOTED_STRING", "RULE_ML_SINGLE_QUOTED_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'map'", "'in'", "'{'", "'where'", "'}'", "':='", "'<='", "';'", "','", "'|'", "'default'", "'imports'", "'uses'", "'('", "')'", "'import'", "':'", "'::'", "'*'", "'library'", "'check'", "'enforce'", "'query'", "'transformation'", "'realize'", "'refines'", "'-'", "'not'", "'/'", "'+'", "'>'", "'<'", "'>='", "'='", "'<>'", "'and'", "'or'", "'xor'", "'implies'", "'.'", "'->'", "'Tuple'", "'Boolean'", "'Integer'", "'Real'", "'String'", "'UnlimitedNatural'", "'OclAny'", "'OclInvalid'", "'OclVoid'", "'Set'", "'Bag'", "'Sequence'", "'Collection'", "'OrderedSet'", "'..'", "'['", "']'", "'?'", "'true'", "'false'", "'invalid'", "'null'", "'@'", "'pre'", "'if'", "'then'", "'else'", "'endif'", "'let'", "'self'"
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


        public InternalQVTimperativeParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalQVTimperativeParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalQVTimperativeParser.tokenNames; }
    public String getGrammarFileName() { return "../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */
     
     	private QVTimperativeGrammarAccess grammarAccess;
     	
        public InternalQVTimperativeParser(TokenStream input, QVTimperativeGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "TopLevelCS";	
       	}
       	
       	@Override
       	protected QVTimperativeGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleTopLevelCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:73:1: entryRuleTopLevelCS returns [EObject current=null] : iv_ruleTopLevelCS= ruleTopLevelCS EOF ;
    public final EObject entryRuleTopLevelCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTopLevelCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:74:2: (iv_ruleTopLevelCS= ruleTopLevelCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:75:2: iv_ruleTopLevelCS= ruleTopLevelCS EOF
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:82:1: ruleTopLevelCS returns [EObject current=null] : ( ( ( (lv_ownedImport_0_0= ruleImportCS ) ) | ( (lv_ownedLibrary_1_0= ruleLibraryCS ) ) )* ( ( (lv_mappings_2_0= ruleMappingCS ) ) | ( (lv_transformations_3_0= ruleTransformationCS ) ) | ( (lv_queries_4_0= ruleQueryCS ) ) )* ) ;
    public final EObject ruleTopLevelCS() throws RecognitionException {
        EObject current = null;

        EObject lv_ownedImport_0_0 = null;

        EObject lv_ownedLibrary_1_0 = null;

        EObject lv_mappings_2_0 = null;

        EObject lv_transformations_3_0 = null;

        EObject lv_queries_4_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:85:28: ( ( ( ( (lv_ownedImport_0_0= ruleImportCS ) ) | ( (lv_ownedLibrary_1_0= ruleLibraryCS ) ) )* ( ( (lv_mappings_2_0= ruleMappingCS ) ) | ( (lv_transformations_3_0= ruleTransformationCS ) ) | ( (lv_queries_4_0= ruleQueryCS ) ) )* ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:86:1: ( ( ( (lv_ownedImport_0_0= ruleImportCS ) ) | ( (lv_ownedLibrary_1_0= ruleLibraryCS ) ) )* ( ( (lv_mappings_2_0= ruleMappingCS ) ) | ( (lv_transformations_3_0= ruleTransformationCS ) ) | ( (lv_queries_4_0= ruleQueryCS ) ) )* )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:86:1: ( ( ( (lv_ownedImport_0_0= ruleImportCS ) ) | ( (lv_ownedLibrary_1_0= ruleLibraryCS ) ) )* ( ( (lv_mappings_2_0= ruleMappingCS ) ) | ( (lv_transformations_3_0= ruleTransformationCS ) ) | ( (lv_queries_4_0= ruleQueryCS ) ) )* )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:86:2: ( ( (lv_ownedImport_0_0= ruleImportCS ) ) | ( (lv_ownedLibrary_1_0= ruleLibraryCS ) ) )* ( ( (lv_mappings_2_0= ruleMappingCS ) ) | ( (lv_transformations_3_0= ruleTransformationCS ) ) | ( (lv_queries_4_0= ruleQueryCS ) ) )*
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:86:2: ( ( (lv_ownedImport_0_0= ruleImportCS ) ) | ( (lv_ownedLibrary_1_0= ruleLibraryCS ) ) )*
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
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:86:3: ( (lv_ownedImport_0_0= ruleImportCS ) )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:86:3: ( (lv_ownedImport_0_0= ruleImportCS ) )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:87:1: (lv_ownedImport_0_0= ruleImportCS )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:87:1: (lv_ownedImport_0_0= ruleImportCS )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:88:3: lv_ownedImport_0_0= ruleImportCS
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
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:105:6: ( (lv_ownedLibrary_1_0= ruleLibraryCS ) )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:105:6: ( (lv_ownedLibrary_1_0= ruleLibraryCS ) )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:106:1: (lv_ownedLibrary_1_0= ruleLibraryCS )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:106:1: (lv_ownedLibrary_1_0= ruleLibraryCS )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:107:3: lv_ownedLibrary_1_0= ruleLibraryCS
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:123:4: ( ( (lv_mappings_2_0= ruleMappingCS ) ) | ( (lv_transformations_3_0= ruleTransformationCS ) ) | ( (lv_queries_4_0= ruleQueryCS ) ) )*
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
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:123:5: ( (lv_mappings_2_0= ruleMappingCS ) )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:123:5: ( (lv_mappings_2_0= ruleMappingCS ) )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:124:1: (lv_mappings_2_0= ruleMappingCS )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:124:1: (lv_mappings_2_0= ruleMappingCS )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:125:3: lv_mappings_2_0= ruleMappingCS
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
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:142:6: ( (lv_transformations_3_0= ruleTransformationCS ) )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:142:6: ( (lv_transformations_3_0= ruleTransformationCS ) )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:143:1: (lv_transformations_3_0= ruleTransformationCS )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:143:1: (lv_transformations_3_0= ruleTransformationCS )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:144:3: lv_transformations_3_0= ruleTransformationCS
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
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:161:6: ( (lv_queries_4_0= ruleQueryCS ) )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:161:6: ( (lv_queries_4_0= ruleQueryCS ) )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:162:1: (lv_queries_4_0= ruleQueryCS )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:162:1: (lv_queries_4_0= ruleQueryCS )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:163:3: lv_queries_4_0= ruleQueryCS
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:187:1: entryRuleMappingCS returns [EObject current=null] : iv_ruleMappingCS= ruleMappingCS EOF ;
    public final EObject entryRuleMappingCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMappingCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:188:2: (iv_ruleMappingCS= ruleMappingCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:189:2: iv_ruleMappingCS= ruleMappingCS EOF
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:196:1: ruleMappingCS returns [EObject current=null] : ( () otherlv_1= 'map' ( (lv_name_2_0= ruleUnrestrictedName ) ) (otherlv_3= 'in' ( ( ruleUnrestrictedName ) ) )? otherlv_5= '{' ( (lv_domains_6_0= ruleNamedDomainCS ) )* (otherlv_7= 'where' ( (lv_middle_8_0= ruleUnnamedDomainCS ) ) )? ( (lv_mappingCalls_9_0= ruleMappingCallCS ) )* otherlv_10= '}' ) ;
    public final EObject ruleMappingCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_10=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_domains_6_0 = null;

        EObject lv_middle_8_0 = null;

        EObject lv_mappingCalls_9_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:199:28: ( ( () otherlv_1= 'map' ( (lv_name_2_0= ruleUnrestrictedName ) ) (otherlv_3= 'in' ( ( ruleUnrestrictedName ) ) )? otherlv_5= '{' ( (lv_domains_6_0= ruleNamedDomainCS ) )* (otherlv_7= 'where' ( (lv_middle_8_0= ruleUnnamedDomainCS ) ) )? ( (lv_mappingCalls_9_0= ruleMappingCallCS ) )* otherlv_10= '}' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:200:1: ( () otherlv_1= 'map' ( (lv_name_2_0= ruleUnrestrictedName ) ) (otherlv_3= 'in' ( ( ruleUnrestrictedName ) ) )? otherlv_5= '{' ( (lv_domains_6_0= ruleNamedDomainCS ) )* (otherlv_7= 'where' ( (lv_middle_8_0= ruleUnnamedDomainCS ) ) )? ( (lv_mappingCalls_9_0= ruleMappingCallCS ) )* otherlv_10= '}' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:200:1: ( () otherlv_1= 'map' ( (lv_name_2_0= ruleUnrestrictedName ) ) (otherlv_3= 'in' ( ( ruleUnrestrictedName ) ) )? otherlv_5= '{' ( (lv_domains_6_0= ruleNamedDomainCS ) )* (otherlv_7= 'where' ( (lv_middle_8_0= ruleUnnamedDomainCS ) ) )? ( (lv_mappingCalls_9_0= ruleMappingCallCS ) )* otherlv_10= '}' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:200:2: () otherlv_1= 'map' ( (lv_name_2_0= ruleUnrestrictedName ) ) (otherlv_3= 'in' ( ( ruleUnrestrictedName ) ) )? otherlv_5= '{' ( (lv_domains_6_0= ruleNamedDomainCS ) )* (otherlv_7= 'where' ( (lv_middle_8_0= ruleUnnamedDomainCS ) ) )? ( (lv_mappingCalls_9_0= ruleMappingCallCS ) )* otherlv_10= '}'
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:200:2: ()
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:201:2: 
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:213:1: ( (lv_name_2_0= ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:214:1: (lv_name_2_0= ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:214:1: (lv_name_2_0= ruleUnrestrictedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:215:3: lv_name_2_0= ruleUnrestrictedName
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:231:2: (otherlv_3= 'in' ( ( ruleUnrestrictedName ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==17) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:231:4: otherlv_3= 'in' ( ( ruleUnrestrictedName ) )
                    {
                    otherlv_3=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleMappingCS374); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getMappingCSAccess().getInKeyword_3_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:235:1: ( ( ruleUnrestrictedName ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:236:1: ( ruleUnrestrictedName )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:236:1: ( ruleUnrestrictedName )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:237:3: ruleUnrestrictedName
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
                    pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleMappingCS401);
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

            otherlv_5=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleMappingCS415); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getMappingCSAccess().getLeftCurlyBracketKeyword_4());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:257:1: ( (lv_domains_6_0= ruleNamedDomainCS ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==16) ) {
                    int LA4_2 = input.LA(2);

                    if ( (LA4_2==29) ) {
                        alt4=1;
                    }


                }
                else if ( ((LA4_0>=RULE_SIMPLE_ID && LA4_0<=RULE_ESCAPED_ID)||(LA4_0>=27 && LA4_0<=28)||LA4_0==31||(LA4_0>=35 && LA4_0<=41)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:258:1: (lv_domains_6_0= ruleNamedDomainCS )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:258:1: (lv_domains_6_0= ruleNamedDomainCS )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:259:3: lv_domains_6_0= ruleNamedDomainCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMappingCSAccess().getDomainsNamedDomainCSParserRuleCall_5_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleNamedDomainCS_in_ruleMappingCS436);
            	    lv_domains_6_0=ruleNamedDomainCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getMappingCSRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"domains",
            	              		lv_domains_6_0, 
            	              		"NamedDomainCS");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:275:3: (otherlv_7= 'where' ( (lv_middle_8_0= ruleUnnamedDomainCS ) ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==19) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:275:5: otherlv_7= 'where' ( (lv_middle_8_0= ruleUnnamedDomainCS ) )
                    {
                    otherlv_7=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleMappingCS450); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getMappingCSAccess().getWhereKeyword_6_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:279:1: ( (lv_middle_8_0= ruleUnnamedDomainCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:280:1: (lv_middle_8_0= ruleUnnamedDomainCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:280:1: (lv_middle_8_0= ruleUnnamedDomainCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:281:3: lv_middle_8_0= ruleUnnamedDomainCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMappingCSAccess().getMiddleUnnamedDomainCSParserRuleCall_6_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUnnamedDomainCS_in_ruleMappingCS471);
                    lv_middle_8_0=ruleUnnamedDomainCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getMappingCSRule());
                      	        }
                             		set(
                             			current, 
                             			"middle",
                              		lv_middle_8_0, 
                              		"UnnamedDomainCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:297:4: ( (lv_mappingCalls_9_0= ruleMappingCallCS ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==16) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:298:1: (lv_mappingCalls_9_0= ruleMappingCallCS )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:298:1: (lv_mappingCalls_9_0= ruleMappingCallCS )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:299:3: lv_mappingCalls_9_0= ruleMappingCallCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMappingCSAccess().getMappingCallsMappingCallCSParserRuleCall_7_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleMappingCallCS_in_ruleMappingCS494);
            	    lv_mappingCalls_9_0=ruleMappingCallCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getMappingCSRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"mappingCalls",
            	              		lv_mappingCalls_9_0, 
            	              		"MappingCallCS");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            otherlv_10=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleMappingCS507); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_10, grammarAccess.getMappingCSAccess().getRightCurlyBracketKeyword_8());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
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


    // $ANTLR start "entryRuleMappingCallCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:327:1: entryRuleMappingCallCS returns [EObject current=null] : iv_ruleMappingCallCS= ruleMappingCallCS EOF ;
    public final EObject entryRuleMappingCallCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMappingCallCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:328:2: (iv_ruleMappingCallCS= ruleMappingCallCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:329:2: iv_ruleMappingCallCS= ruleMappingCallCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMappingCallCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMappingCallCS_in_entryRuleMappingCallCS543);
            iv_ruleMappingCallCS=ruleMappingCallCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMappingCallCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMappingCallCS553); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMappingCallCS"


    // $ANTLR start "ruleMappingCallCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:336:1: ruleMappingCallCS returns [EObject current=null] : ( () otherlv_1= 'map' ( ( ruleUnrestrictedName ) ) otherlv_3= '{' ( (lv_bindings_4_0= ruleMappingCallBindingCS ) )* otherlv_5= '}' ) ;
    public final EObject ruleMappingCallCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_bindings_4_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:339:28: ( ( () otherlv_1= 'map' ( ( ruleUnrestrictedName ) ) otherlv_3= '{' ( (lv_bindings_4_0= ruleMappingCallBindingCS ) )* otherlv_5= '}' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:340:1: ( () otherlv_1= 'map' ( ( ruleUnrestrictedName ) ) otherlv_3= '{' ( (lv_bindings_4_0= ruleMappingCallBindingCS ) )* otherlv_5= '}' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:340:1: ( () otherlv_1= 'map' ( ( ruleUnrestrictedName ) ) otherlv_3= '{' ( (lv_bindings_4_0= ruleMappingCallBindingCS ) )* otherlv_5= '}' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:340:2: () otherlv_1= 'map' ( ( ruleUnrestrictedName ) ) otherlv_3= '{' ( (lv_bindings_4_0= ruleMappingCallBindingCS ) )* otherlv_5= '}'
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:340:2: ()
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:341:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getMappingCallCSAccess().getMappingCallCSAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleMappingCallCS602); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getMappingCallCSAccess().getMapKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:353:1: ( ( ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:354:1: ( ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:354:1: ( ruleUnrestrictedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:355:3: ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getMappingCallCSRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMappingCallCSAccess().getReferredMappingMappingCrossReference_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleMappingCallCS629);
            ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleMappingCallCS641); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getMappingCallCSAccess().getLeftCurlyBracketKeyword_3());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:375:1: ( (lv_bindings_4_0= ruleMappingCallBindingCS ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>=RULE_SIMPLE_ID && LA7_0<=RULE_ESCAPED_ID)||LA7_0==16||(LA7_0>=27 && LA7_0<=28)||LA7_0==31||(LA7_0>=35 && LA7_0<=41)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:376:1: (lv_bindings_4_0= ruleMappingCallBindingCS )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:376:1: (lv_bindings_4_0= ruleMappingCallBindingCS )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:377:3: lv_bindings_4_0= ruleMappingCallBindingCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMappingCallCSAccess().getBindingsMappingCallBindingCSParserRuleCall_4_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleMappingCallBindingCS_in_ruleMappingCallCS662);
            	    lv_bindings_4_0=ruleMappingCallBindingCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getMappingCallCSRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"bindings",
            	              		lv_bindings_4_0, 
            	              		"MappingCallBindingCS");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            otherlv_5=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleMappingCallCS675); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getMappingCallCSAccess().getRightCurlyBracketKeyword_5());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMappingCallCS"


    // $ANTLR start "entryRuleMappingCallBindingCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:405:1: entryRuleMappingCallBindingCS returns [EObject current=null] : iv_ruleMappingCallBindingCS= ruleMappingCallBindingCS EOF ;
    public final EObject entryRuleMappingCallBindingCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMappingCallBindingCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:406:2: (iv_ruleMappingCallBindingCS= ruleMappingCallBindingCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:407:2: iv_ruleMappingCallBindingCS= ruleMappingCallBindingCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMappingCallBindingCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMappingCallBindingCS_in_entryRuleMappingCallBindingCS711);
            iv_ruleMappingCallBindingCS=ruleMappingCallBindingCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMappingCallBindingCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMappingCallBindingCS721); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMappingCallBindingCS"


    // $ANTLR start "ruleMappingCallBindingCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:414:1: ruleMappingCallBindingCS returns [EObject current=null] : ( ( ( ruleUnrestrictedName ) ) (otherlv_1= ':=' | ( (lv_isLoop_2_0= '<=' ) ) ) ( (lv_value_3_0= ruleExpCS ) ) otherlv_4= ';' ) ;
    public final EObject ruleMappingCallBindingCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_isLoop_2_0=null;
        Token otherlv_4=null;
        EObject lv_value_3_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:417:28: ( ( ( ( ruleUnrestrictedName ) ) (otherlv_1= ':=' | ( (lv_isLoop_2_0= '<=' ) ) ) ( (lv_value_3_0= ruleExpCS ) ) otherlv_4= ';' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:418:1: ( ( ( ruleUnrestrictedName ) ) (otherlv_1= ':=' | ( (lv_isLoop_2_0= '<=' ) ) ) ( (lv_value_3_0= ruleExpCS ) ) otherlv_4= ';' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:418:1: ( ( ( ruleUnrestrictedName ) ) (otherlv_1= ':=' | ( (lv_isLoop_2_0= '<=' ) ) ) ( (lv_value_3_0= ruleExpCS ) ) otherlv_4= ';' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:418:2: ( ( ruleUnrestrictedName ) ) (otherlv_1= ':=' | ( (lv_isLoop_2_0= '<=' ) ) ) ( (lv_value_3_0= ruleExpCS ) ) otherlv_4= ';'
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:418:2: ( ( ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:419:1: ( ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:419:1: ( ruleUnrestrictedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:420:3: ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getMappingCallBindingCSRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMappingCallBindingCSAccess().getReferredVariableVariableCrossReference_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleMappingCallBindingCS773);
            ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:436:2: (otherlv_1= ':=' | ( (lv_isLoop_2_0= '<=' ) ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==21) ) {
                alt8=1;
            }
            else if ( (LA8_0==22) ) {
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:436:4: otherlv_1= ':='
                    {
                    otherlv_1=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleMappingCallBindingCS786); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getMappingCallBindingCSAccess().getColonEqualsSignKeyword_1_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:441:6: ( (lv_isLoop_2_0= '<=' ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:441:6: ( (lv_isLoop_2_0= '<=' ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:442:1: (lv_isLoop_2_0= '<=' )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:442:1: (lv_isLoop_2_0= '<=' )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:443:3: lv_isLoop_2_0= '<='
                    {
                    lv_isLoop_2_0=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleMappingCallBindingCS810); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_isLoop_2_0, grammarAccess.getMappingCallBindingCSAccess().getIsLoopLessThanSignEqualsSignKeyword_1_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getMappingCallBindingCSRule());
                      	        }
                             		setWithLastConsumed(current, "isLoop", true, "<=");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:456:3: ( (lv_value_3_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:457:1: (lv_value_3_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:457:1: (lv_value_3_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:458:3: lv_value_3_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMappingCallBindingCSAccess().getValueExpCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleMappingCallBindingCS845);
            lv_value_3_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getMappingCallBindingCSRule());
              	        }
                     		set(
                     			current, 
                     			"value",
                      		lv_value_3_0, 
                      		"ExpCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleMappingCallBindingCS857); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getMappingCallBindingCSAccess().getSemicolonKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMappingCallBindingCS"


    // $ANTLR start "entryRuleBottomPatternCS"
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:486:1: entryRuleBottomPatternCS returns [EObject current=null] : iv_ruleBottomPatternCS= ruleBottomPatternCS EOF ;
    public final EObject entryRuleBottomPatternCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBottomPatternCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:487:2: (iv_ruleBottomPatternCS= ruleBottomPatternCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:488:2: iv_ruleBottomPatternCS= ruleBottomPatternCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBottomPatternCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleBottomPatternCS_in_entryRuleBottomPatternCS893);
            iv_ruleBottomPatternCS=ruleBottomPatternCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBottomPatternCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBottomPatternCS903); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:495:1: ruleBottomPatternCS returns [EObject current=null] : ( (otherlv_0= '{' ( ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_2_0= ruleRealizedVariableCS ) ) ) (otherlv_3= ',' ( ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) ) ) )* otherlv_6= '|' ( (lv_constraints_7_0= ruleAssignmentCS ) )* otherlv_8= '}' ) | ( () otherlv_10= '{' ( (lv_constraints_11_0= ruleAssignmentCS ) )* otherlv_12= '}' ) ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:498:28: ( ( (otherlv_0= '{' ( ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_2_0= ruleRealizedVariableCS ) ) ) (otherlv_3= ',' ( ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) ) ) )* otherlv_6= '|' ( (lv_constraints_7_0= ruleAssignmentCS ) )* otherlv_8= '}' ) | ( () otherlv_10= '{' ( (lv_constraints_11_0= ruleAssignmentCS ) )* otherlv_12= '}' ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:499:1: ( (otherlv_0= '{' ( ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_2_0= ruleRealizedVariableCS ) ) ) (otherlv_3= ',' ( ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) ) ) )* otherlv_6= '|' ( (lv_constraints_7_0= ruleAssignmentCS ) )* otherlv_8= '}' ) | ( () otherlv_10= '{' ( (lv_constraints_11_0= ruleAssignmentCS ) )* otherlv_12= '}' ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:499:1: ( (otherlv_0= '{' ( ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_2_0= ruleRealizedVariableCS ) ) ) (otherlv_3= ',' ( ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) ) ) )* otherlv_6= '|' ( (lv_constraints_7_0= ruleAssignmentCS ) )* otherlv_8= '}' ) | ( () otherlv_10= '{' ( (lv_constraints_11_0= ruleAssignmentCS ) )* otherlv_12= '}' ) )
            int alt14=2;
            alt14 = dfa14.predict(input);
            switch (alt14) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:499:2: (otherlv_0= '{' ( ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_2_0= ruleRealizedVariableCS ) ) ) (otherlv_3= ',' ( ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) ) ) )* otherlv_6= '|' ( (lv_constraints_7_0= ruleAssignmentCS ) )* otherlv_8= '}' )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:499:2: (otherlv_0= '{' ( ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_2_0= ruleRealizedVariableCS ) ) ) (otherlv_3= ',' ( ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) ) ) )* otherlv_6= '|' ( (lv_constraints_7_0= ruleAssignmentCS ) )* otherlv_8= '}' )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:499:4: otherlv_0= '{' ( ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_2_0= ruleRealizedVariableCS ) ) ) (otherlv_3= ',' ( ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) ) ) )* otherlv_6= '|' ( (lv_constraints_7_0= ruleAssignmentCS ) )* otherlv_8= '}'
                    {
                    otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleBottomPatternCS941); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getBottomPatternCSAccess().getLeftCurlyBracketKeyword_0_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:503:1: ( ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_2_0= ruleRealizedVariableCS ) ) )
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( ((LA9_0>=RULE_SIMPLE_ID && LA9_0<=RULE_ESCAPED_ID)||LA9_0==16||(LA9_0>=27 && LA9_0<=28)||LA9_0==31||(LA9_0>=35 && LA9_0<=39)||LA9_0==41) ) {
                        alt9=1;
                    }
                    else if ( (LA9_0==40) ) {
                        int LA9_2 = input.LA(2);

                        if ( (LA9_2==32) ) {
                            alt9=1;
                        }
                        else if ( ((LA9_2>=RULE_SIMPLE_ID && LA9_2<=RULE_ESCAPED_ID)||LA9_2==16||(LA9_2>=27 && LA9_2<=28)||LA9_2==31||(LA9_2>=35 && LA9_2<=41)) ) {
                            alt9=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 2, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 9, 0, input);

                        throw nvae;
                    }
                    switch (alt9) {
                        case 1 :
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:503:2: ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:503:2: ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:504:1: (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:504:1: (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:505:3: lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getBottomPatternCSAccess().getUnrealizedVariablesUnrealizedVariableCSParserRuleCall_0_1_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleUnrealizedVariableCS_in_ruleBottomPatternCS963);
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
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:522:6: ( (lv_realizedVariables_2_0= ruleRealizedVariableCS ) )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:522:6: ( (lv_realizedVariables_2_0= ruleRealizedVariableCS ) )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:523:1: (lv_realizedVariables_2_0= ruleRealizedVariableCS )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:523:1: (lv_realizedVariables_2_0= ruleRealizedVariableCS )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:524:3: lv_realizedVariables_2_0= ruleRealizedVariableCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getBottomPatternCSAccess().getRealizedVariablesRealizedVariableCSParserRuleCall_0_1_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleRealizedVariableCS_in_ruleBottomPatternCS990);
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

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:540:3: (otherlv_3= ',' ( ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) ) ) )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==24) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:540:5: otherlv_3= ',' ( ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) ) )
                    	    {
                    	    otherlv_3=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleBottomPatternCS1004); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getBottomPatternCSAccess().getCommaKeyword_0_2_0());
                    	          
                    	    }
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:544:1: ( ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) ) )
                    	    int alt10=2;
                    	    int LA10_0 = input.LA(1);

                    	    if ( ((LA10_0>=RULE_SIMPLE_ID && LA10_0<=RULE_ESCAPED_ID)||LA10_0==16||(LA10_0>=27 && LA10_0<=28)||LA10_0==31||(LA10_0>=35 && LA10_0<=39)||LA10_0==41) ) {
                    	        alt10=1;
                    	    }
                    	    else if ( (LA10_0==40) ) {
                    	        int LA10_2 = input.LA(2);

                    	        if ( (LA10_2==32) ) {
                    	            alt10=1;
                    	        }
                    	        else if ( ((LA10_2>=RULE_SIMPLE_ID && LA10_2<=RULE_ESCAPED_ID)||LA10_2==16||(LA10_2>=27 && LA10_2<=28)||LA10_2==31||(LA10_2>=35 && LA10_2<=41)) ) {
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
                    	            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:544:2: ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) )
                    	            {
                    	            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:544:2: ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) )
                    	            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:545:1: (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS )
                    	            {
                    	            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:545:1: (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS )
                    	            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:546:3: lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS
                    	            {
                    	            if ( state.backtracking==0 ) {
                    	               
                    	              	        newCompositeNode(grammarAccess.getBottomPatternCSAccess().getUnrealizedVariablesUnrealizedVariableCSParserRuleCall_0_2_1_0_0()); 
                    	              	    
                    	            }
                    	            pushFollow(FollowSets000.FOLLOW_ruleUnrealizedVariableCS_in_ruleBottomPatternCS1026);
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
                    	            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:563:6: ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) )
                    	            {
                    	            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:563:6: ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) )
                    	            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:564:1: (lv_realizedVariables_5_0= ruleRealizedVariableCS )
                    	            {
                    	            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:564:1: (lv_realizedVariables_5_0= ruleRealizedVariableCS )
                    	            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:565:3: lv_realizedVariables_5_0= ruleRealizedVariableCS
                    	            {
                    	            if ( state.backtracking==0 ) {
                    	               
                    	              	        newCompositeNode(grammarAccess.getBottomPatternCSAccess().getRealizedVariablesRealizedVariableCSParserRuleCall_0_2_1_1_0()); 
                    	              	    
                    	            }
                    	            pushFollow(FollowSets000.FOLLOW_ruleRealizedVariableCS_in_ruleBottomPatternCS1053);
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
                    	    break loop11;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleBottomPatternCS1068); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getBottomPatternCSAccess().getVerticalLineKeyword_0_3());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:585:1: ( (lv_constraints_7_0= ruleAssignmentCS ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( ((LA12_0>=RULE_SIMPLE_ID && LA12_0<=RULE_SINGLE_QUOTED_STRING)||LA12_0==16||(LA12_0>=26 && LA12_0<=29)||LA12_0==31||(LA12_0>=34 && LA12_0<=43)||(LA12_0>=57 && LA12_0<=70)||(LA12_0>=75 && LA12_0<=78)||LA12_0==81||(LA12_0>=85 && LA12_0<=86)) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:586:1: (lv_constraints_7_0= ruleAssignmentCS )
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:586:1: (lv_constraints_7_0= ruleAssignmentCS )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:587:3: lv_constraints_7_0= ruleAssignmentCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getBottomPatternCSAccess().getConstraintsAssignmentCSParserRuleCall_0_4_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleAssignmentCS_in_ruleBottomPatternCS1089);
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
                    	    break loop12;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleBottomPatternCS1102); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getBottomPatternCSAccess().getRightCurlyBracketKeyword_0_5());
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:608:6: ( () otherlv_10= '{' ( (lv_constraints_11_0= ruleAssignmentCS ) )* otherlv_12= '}' )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:608:6: ( () otherlv_10= '{' ( (lv_constraints_11_0= ruleAssignmentCS ) )* otherlv_12= '}' )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:608:7: () otherlv_10= '{' ( (lv_constraints_11_0= ruleAssignmentCS ) )* otherlv_12= '}'
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:608:7: ()
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:609:2: 
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

                    otherlv_10=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleBottomPatternCS1134); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getBottomPatternCSAccess().getLeftCurlyBracketKeyword_1_1());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:621:1: ( (lv_constraints_11_0= ruleAssignmentCS ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( ((LA13_0>=RULE_SIMPLE_ID && LA13_0<=RULE_SINGLE_QUOTED_STRING)||LA13_0==16||(LA13_0>=26 && LA13_0<=29)||LA13_0==31||(LA13_0>=34 && LA13_0<=43)||(LA13_0>=57 && LA13_0<=70)||(LA13_0>=75 && LA13_0<=78)||LA13_0==81||(LA13_0>=85 && LA13_0<=86)) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:622:1: (lv_constraints_11_0= ruleAssignmentCS )
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:622:1: (lv_constraints_11_0= ruleAssignmentCS )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:623:3: lv_constraints_11_0= ruleAssignmentCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getBottomPatternCSAccess().getConstraintsAssignmentCSParserRuleCall_1_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleAssignmentCS_in_ruleBottomPatternCS1155);
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
                    	    break loop13;
                        }
                    } while (true);

                    otherlv_12=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleBottomPatternCS1168); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:651:1: entryRuleAssignmentCS returns [EObject current=null] : iv_ruleAssignmentCS= ruleAssignmentCS EOF ;
    public final EObject entryRuleAssignmentCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignmentCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:652:2: (iv_ruleAssignmentCS= ruleAssignmentCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:653:2: iv_ruleAssignmentCS= ruleAssignmentCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAssignmentCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAssignmentCS_in_entryRuleAssignmentCS1205);
            iv_ruleAssignmentCS=ruleAssignmentCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAssignmentCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAssignmentCS1215); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:660:1: ruleAssignmentCS returns [EObject current=null] : ( ( (lv_default_0_0= 'default' ) )? ( (lv_target_1_0= ruleExpCS ) ) (otherlv_2= ':=' ( (lv_initialiser_3_0= ruleExpCS ) ) )? otherlv_4= ';' ) ;
    public final EObject ruleAssignmentCS() throws RecognitionException {
        EObject current = null;

        Token lv_default_0_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_target_1_0 = null;

        EObject lv_initialiser_3_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:663:28: ( ( ( (lv_default_0_0= 'default' ) )? ( (lv_target_1_0= ruleExpCS ) ) (otherlv_2= ':=' ( (lv_initialiser_3_0= ruleExpCS ) ) )? otherlv_4= ';' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:664:1: ( ( (lv_default_0_0= 'default' ) )? ( (lv_target_1_0= ruleExpCS ) ) (otherlv_2= ':=' ( (lv_initialiser_3_0= ruleExpCS ) ) )? otherlv_4= ';' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:664:1: ( ( (lv_default_0_0= 'default' ) )? ( (lv_target_1_0= ruleExpCS ) ) (otherlv_2= ':=' ( (lv_initialiser_3_0= ruleExpCS ) ) )? otherlv_4= ';' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:664:2: ( (lv_default_0_0= 'default' ) )? ( (lv_target_1_0= ruleExpCS ) ) (otherlv_2= ':=' ( (lv_initialiser_3_0= ruleExpCS ) ) )? otherlv_4= ';'
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:664:2: ( (lv_default_0_0= 'default' ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==26) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:665:1: (lv_default_0_0= 'default' )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:665:1: (lv_default_0_0= 'default' )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:666:3: lv_default_0_0= 'default'
                    {
                    lv_default_0_0=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleAssignmentCS1258); if (state.failed) return current;
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:679:3: ( (lv_target_1_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:680:1: (lv_target_1_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:680:1: (lv_target_1_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:681:3: lv_target_1_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAssignmentCSAccess().getTargetExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleAssignmentCS1293);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:697:2: (otherlv_2= ':=' ( (lv_initialiser_3_0= ruleExpCS ) ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==21) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:697:4: otherlv_2= ':=' ( (lv_initialiser_3_0= ruleExpCS ) )
                    {
                    otherlv_2=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleAssignmentCS1306); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getAssignmentCSAccess().getColonEqualsSignKeyword_2_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:701:1: ( (lv_initialiser_3_0= ruleExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:702:1: (lv_initialiser_3_0= ruleExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:702:1: (lv_initialiser_3_0= ruleExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:703:3: lv_initialiser_3_0= ruleExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAssignmentCSAccess().getInitialiserExpCSParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleAssignmentCS1327);
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

            otherlv_4=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleAssignmentCS1341); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:731:1: entryRuleDirectionCS returns [EObject current=null] : iv_ruleDirectionCS= ruleDirectionCS EOF ;
    public final EObject entryRuleDirectionCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDirectionCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:732:2: (iv_ruleDirectionCS= ruleDirectionCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:733:2: iv_ruleDirectionCS= ruleDirectionCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDirectionCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleDirectionCS_in_entryRuleDirectionCS1377);
            iv_ruleDirectionCS=ruleDirectionCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDirectionCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDirectionCS1387); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:740:1: ruleDirectionCS returns [EObject current=null] : ( () ( (lv_name_1_0= ruleUnrestrictedName ) )? (otherlv_2= 'imports' ( ( ruleUnrestrictedName ) ) (otherlv_4= ',' ( ( ruleUnrestrictedName ) ) )* )? (otherlv_6= 'uses' ( ( ruleUnrestrictedName ) ) (otherlv_8= ',' ( ( ruleUnrestrictedName ) ) )* )? ) ;
    public final EObject ruleDirectionCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:743:28: ( ( () ( (lv_name_1_0= ruleUnrestrictedName ) )? (otherlv_2= 'imports' ( ( ruleUnrestrictedName ) ) (otherlv_4= ',' ( ( ruleUnrestrictedName ) ) )* )? (otherlv_6= 'uses' ( ( ruleUnrestrictedName ) ) (otherlv_8= ',' ( ( ruleUnrestrictedName ) ) )* )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:744:1: ( () ( (lv_name_1_0= ruleUnrestrictedName ) )? (otherlv_2= 'imports' ( ( ruleUnrestrictedName ) ) (otherlv_4= ',' ( ( ruleUnrestrictedName ) ) )* )? (otherlv_6= 'uses' ( ( ruleUnrestrictedName ) ) (otherlv_8= ',' ( ( ruleUnrestrictedName ) ) )* )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:744:1: ( () ( (lv_name_1_0= ruleUnrestrictedName ) )? (otherlv_2= 'imports' ( ( ruleUnrestrictedName ) ) (otherlv_4= ',' ( ( ruleUnrestrictedName ) ) )* )? (otherlv_6= 'uses' ( ( ruleUnrestrictedName ) ) (otherlv_8= ',' ( ( ruleUnrestrictedName ) ) )* )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:744:2: () ( (lv_name_1_0= ruleUnrestrictedName ) )? (otherlv_2= 'imports' ( ( ruleUnrestrictedName ) ) (otherlv_4= ',' ( ( ruleUnrestrictedName ) ) )* )? (otherlv_6= 'uses' ( ( ruleUnrestrictedName ) ) (otherlv_8= ',' ( ( ruleUnrestrictedName ) ) )* )?
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:744:2: ()
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:745:2: 
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:753:2: ( (lv_name_1_0= ruleUnrestrictedName ) )?
            int alt17=2;
            alt17 = dfa17.predict(input);
            switch (alt17) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:754:1: (lv_name_1_0= ruleUnrestrictedName )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:754:1: (lv_name_1_0= ruleUnrestrictedName )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:755:3: lv_name_1_0= ruleUnrestrictedName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDirectionCSAccess().getNameUnrestrictedNameParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleDirectionCS1445);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:771:3: (otherlv_2= 'imports' ( ( ruleUnrestrictedName ) ) (otherlv_4= ',' ( ( ruleUnrestrictedName ) ) )* )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==27) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:771:5: otherlv_2= 'imports' ( ( ruleUnrestrictedName ) ) (otherlv_4= ',' ( ( ruleUnrestrictedName ) ) )*
                    {
                    otherlv_2=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleDirectionCS1459); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getDirectionCSAccess().getImportsKeyword_2_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:775:1: ( ( ruleUnrestrictedName ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:776:1: ( ruleUnrestrictedName )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:776:1: ( ruleUnrestrictedName )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:777:3: ruleUnrestrictedName
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
                    pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleDirectionCS1486);
                    ruleUnrestrictedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:793:2: (otherlv_4= ',' ( ( ruleUnrestrictedName ) ) )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==24) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:793:4: otherlv_4= ',' ( ( ruleUnrestrictedName ) )
                    	    {
                    	    otherlv_4=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleDirectionCS1499); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_4, grammarAccess.getDirectionCSAccess().getCommaKeyword_2_2_0());
                    	          
                    	    }
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:797:1: ( ( ruleUnrestrictedName ) )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:798:1: ( ruleUnrestrictedName )
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:798:1: ( ruleUnrestrictedName )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:799:3: ruleUnrestrictedName
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
                    	    pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleDirectionCS1526);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:815:6: (otherlv_6= 'uses' ( ( ruleUnrestrictedName ) ) (otherlv_8= ',' ( ( ruleUnrestrictedName ) ) )* )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==28) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:815:8: otherlv_6= 'uses' ( ( ruleUnrestrictedName ) ) (otherlv_8= ',' ( ( ruleUnrestrictedName ) ) )*
                    {
                    otherlv_6=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleDirectionCS1543); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getDirectionCSAccess().getUsesKeyword_3_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:819:1: ( ( ruleUnrestrictedName ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:820:1: ( ruleUnrestrictedName )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:820:1: ( ruleUnrestrictedName )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:821:3: ruleUnrestrictedName
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
                    pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleDirectionCS1570);
                    ruleUnrestrictedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:837:2: (otherlv_8= ',' ( ( ruleUnrestrictedName ) ) )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==24) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:837:4: otherlv_8= ',' ( ( ruleUnrestrictedName ) )
                    	    {
                    	    otherlv_8=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleDirectionCS1583); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_8, grammarAccess.getDirectionCSAccess().getCommaKeyword_3_2_0());
                    	          
                    	    }
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:841:1: ( ( ruleUnrestrictedName ) )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:842:1: ( ruleUnrestrictedName )
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:842:1: ( ruleUnrestrictedName )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:843:3: ruleUnrestrictedName
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
                    	    pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleDirectionCS1610);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:867:1: entryRuleGuardPatternCS returns [EObject current=null] : iv_ruleGuardPatternCS= ruleGuardPatternCS EOF ;
    public final EObject entryRuleGuardPatternCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGuardPatternCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:868:2: (iv_ruleGuardPatternCS= ruleGuardPatternCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:869:2: iv_ruleGuardPatternCS= ruleGuardPatternCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGuardPatternCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleGuardPatternCS_in_entryRuleGuardPatternCS1650);
            iv_ruleGuardPatternCS=ruleGuardPatternCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleGuardPatternCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleGuardPatternCS1660); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:876:1: ruleGuardPatternCS returns [EObject current=null] : ( (otherlv_0= '(' ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) (otherlv_2= ',' ( (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS ) ) )* otherlv_4= '|' ( (lv_constraints_5_0= ruleAssignmentCS ) )* otherlv_6= ')' ) | ( () otherlv_8= '(' ( (lv_constraints_9_0= ruleAssignmentCS ) )* otherlv_10= ')' ) ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:879:28: ( ( (otherlv_0= '(' ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) (otherlv_2= ',' ( (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS ) ) )* otherlv_4= '|' ( (lv_constraints_5_0= ruleAssignmentCS ) )* otherlv_6= ')' ) | ( () otherlv_8= '(' ( (lv_constraints_9_0= ruleAssignmentCS ) )* otherlv_10= ')' ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:880:1: ( (otherlv_0= '(' ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) (otherlv_2= ',' ( (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS ) ) )* otherlv_4= '|' ( (lv_constraints_5_0= ruleAssignmentCS ) )* otherlv_6= ')' ) | ( () otherlv_8= '(' ( (lv_constraints_9_0= ruleAssignmentCS ) )* otherlv_10= ')' ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:880:1: ( (otherlv_0= '(' ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) (otherlv_2= ',' ( (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS ) ) )* otherlv_4= '|' ( (lv_constraints_5_0= ruleAssignmentCS ) )* otherlv_6= ')' ) | ( () otherlv_8= '(' ( (lv_constraints_9_0= ruleAssignmentCS ) )* otherlv_10= ')' ) )
            int alt25=2;
            alt25 = dfa25.predict(input);
            switch (alt25) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:880:2: (otherlv_0= '(' ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) (otherlv_2= ',' ( (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS ) ) )* otherlv_4= '|' ( (lv_constraints_5_0= ruleAssignmentCS ) )* otherlv_6= ')' )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:880:2: (otherlv_0= '(' ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) (otherlv_2= ',' ( (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS ) ) )* otherlv_4= '|' ( (lv_constraints_5_0= ruleAssignmentCS ) )* otherlv_6= ')' )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:880:4: otherlv_0= '(' ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) (otherlv_2= ',' ( (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS ) ) )* otherlv_4= '|' ( (lv_constraints_5_0= ruleAssignmentCS ) )* otherlv_6= ')'
                    {
                    otherlv_0=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleGuardPatternCS1698); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getGuardPatternCSAccess().getLeftParenthesisKeyword_0_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:884:1: ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:885:1: (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:885:1: (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:886:3: lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getGuardPatternCSAccess().getUnrealizedVariablesUnrealizedVariableCSParserRuleCall_0_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUnrealizedVariableCS_in_ruleGuardPatternCS1719);
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

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:902:2: (otherlv_2= ',' ( (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS ) ) )*
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==24) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:902:4: otherlv_2= ',' ( (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS ) )
                    	    {
                    	    otherlv_2=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleGuardPatternCS1732); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_2, grammarAccess.getGuardPatternCSAccess().getCommaKeyword_0_2_0());
                    	          
                    	    }
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:906:1: ( (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS ) )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:907:1: (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS )
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:907:1: (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:908:3: lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getGuardPatternCSAccess().getUnrealizedVariablesUnrealizedVariableCSParserRuleCall_0_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleUnrealizedVariableCS_in_ruleGuardPatternCS1753);
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

                    otherlv_4=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleGuardPatternCS1767); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getGuardPatternCSAccess().getVerticalLineKeyword_0_3());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:928:1: ( (lv_constraints_5_0= ruleAssignmentCS ) )*
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( ((LA23_0>=RULE_SIMPLE_ID && LA23_0<=RULE_SINGLE_QUOTED_STRING)||LA23_0==16||(LA23_0>=26 && LA23_0<=29)||LA23_0==31||(LA23_0>=34 && LA23_0<=43)||(LA23_0>=57 && LA23_0<=70)||(LA23_0>=75 && LA23_0<=78)||LA23_0==81||(LA23_0>=85 && LA23_0<=86)) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:929:1: (lv_constraints_5_0= ruleAssignmentCS )
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:929:1: (lv_constraints_5_0= ruleAssignmentCS )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:930:3: lv_constraints_5_0= ruleAssignmentCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getGuardPatternCSAccess().getConstraintsAssignmentCSParserRuleCall_0_4_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleAssignmentCS_in_ruleGuardPatternCS1788);
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
                    	    break loop23;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleGuardPatternCS1801); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getGuardPatternCSAccess().getRightParenthesisKeyword_0_5());
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:951:6: ( () otherlv_8= '(' ( (lv_constraints_9_0= ruleAssignmentCS ) )* otherlv_10= ')' )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:951:6: ( () otherlv_8= '(' ( (lv_constraints_9_0= ruleAssignmentCS ) )* otherlv_10= ')' )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:951:7: () otherlv_8= '(' ( (lv_constraints_9_0= ruleAssignmentCS ) )* otherlv_10= ')'
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:951:7: ()
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:952:2: 
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

                    otherlv_8=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleGuardPatternCS1833); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getGuardPatternCSAccess().getLeftParenthesisKeyword_1_1());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:964:1: ( (lv_constraints_9_0= ruleAssignmentCS ) )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( ((LA24_0>=RULE_SIMPLE_ID && LA24_0<=RULE_SINGLE_QUOTED_STRING)||LA24_0==16||(LA24_0>=26 && LA24_0<=29)||LA24_0==31||(LA24_0>=34 && LA24_0<=43)||(LA24_0>=57 && LA24_0<=70)||(LA24_0>=75 && LA24_0<=78)||LA24_0==81||(LA24_0>=85 && LA24_0<=86)) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:965:1: (lv_constraints_9_0= ruleAssignmentCS )
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:965:1: (lv_constraints_9_0= ruleAssignmentCS )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:966:3: lv_constraints_9_0= ruleAssignmentCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getGuardPatternCSAccess().getConstraintsAssignmentCSParserRuleCall_1_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleAssignmentCS_in_ruleGuardPatternCS1854);
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
                    	    break loop24;
                        }
                    } while (true);

                    otherlv_10=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleGuardPatternCS1867); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:994:1: entryRuleImportCS returns [EObject current=null] : iv_ruleImportCS= ruleImportCS EOF ;
    public final EObject entryRuleImportCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:995:2: (iv_ruleImportCS= ruleImportCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:996:2: iv_ruleImportCS= ruleImportCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImportCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleImportCS_in_entryRuleImportCS1904);
            iv_ruleImportCS=ruleImportCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImportCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleImportCS1914); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1003:1: ruleImportCS returns [EObject current=null] : (otherlv_0= 'import' ( ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= ':' )? ( (lv_pathName_3_0= ruleURIPathNameCS ) ) ( ( (lv_all_4_0= '::' ) ) otherlv_5= '*' )? otherlv_6= ';' ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1006:28: ( (otherlv_0= 'import' ( ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= ':' )? ( (lv_pathName_3_0= ruleURIPathNameCS ) ) ( ( (lv_all_4_0= '::' ) ) otherlv_5= '*' )? otherlv_6= ';' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1007:1: (otherlv_0= 'import' ( ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= ':' )? ( (lv_pathName_3_0= ruleURIPathNameCS ) ) ( ( (lv_all_4_0= '::' ) ) otherlv_5= '*' )? otherlv_6= ';' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1007:1: (otherlv_0= 'import' ( ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= ':' )? ( (lv_pathName_3_0= ruleURIPathNameCS ) ) ( ( (lv_all_4_0= '::' ) ) otherlv_5= '*' )? otherlv_6= ';' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1007:3: otherlv_0= 'import' ( ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= ':' )? ( (lv_pathName_3_0= ruleURIPathNameCS ) ) ( ( (lv_all_4_0= '::' ) ) otherlv_5= '*' )? otherlv_6= ';'
            {
            otherlv_0=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleImportCS1951); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getImportCSAccess().getImportKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1011:1: ( ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= ':' )?
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1011:2: ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= ':'
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1011:2: ( (lv_name_1_0= ruleIdentifier ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1012:1: (lv_name_1_0= ruleIdentifier )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1012:1: (lv_name_1_0= ruleIdentifier )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1013:3: lv_name_1_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getImportCSAccess().getNameIdentifierParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_ruleImportCS1973);
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

                    otherlv_2=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleImportCS1985); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getImportCSAccess().getColonKeyword_1_1());
                          
                    }

                    }
                    break;

            }

            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1033:3: ( (lv_pathName_3_0= ruleURIPathNameCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1034:1: (lv_pathName_3_0= ruleURIPathNameCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1034:1: (lv_pathName_3_0= ruleURIPathNameCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1035:3: lv_pathName_3_0= ruleURIPathNameCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getImportCSAccess().getPathNameURIPathNameCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleURIPathNameCS_in_ruleImportCS2008);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1051:2: ( ( (lv_all_4_0= '::' ) ) otherlv_5= '*' )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==33) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1051:3: ( (lv_all_4_0= '::' ) ) otherlv_5= '*'
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1051:3: ( (lv_all_4_0= '::' ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1052:1: (lv_all_4_0= '::' )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1052:1: (lv_all_4_0= '::' )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1053:3: lv_all_4_0= '::'
                    {
                    lv_all_4_0=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleImportCS2027); if (state.failed) return current;
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

                    otherlv_5=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleImportCS2052); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getImportCSAccess().getAsteriskKeyword_3_1());
                          
                    }

                    }
                    break;

            }

            otherlv_6=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleImportCS2066); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1082:1: entryRuleLibraryCS returns [EObject current=null] : iv_ruleLibraryCS= ruleLibraryCS EOF ;
    public final EObject entryRuleLibraryCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLibraryCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1083:2: (iv_ruleLibraryCS= ruleLibraryCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1084:2: iv_ruleLibraryCS= ruleLibraryCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLibraryCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibraryCS_in_entryRuleLibraryCS2102);
            iv_ruleLibraryCS=ruleLibraryCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLibraryCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibraryCS2112); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1091:1: ruleLibraryCS returns [EObject current=null] : (otherlv_0= 'library' ( ( ruleURI ) ) otherlv_2= ';' ) ;
    public final EObject ruleLibraryCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1094:28: ( (otherlv_0= 'library' ( ( ruleURI ) ) otherlv_2= ';' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1095:1: (otherlv_0= 'library' ( ( ruleURI ) ) otherlv_2= ';' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1095:1: (otherlv_0= 'library' ( ( ruleURI ) ) otherlv_2= ';' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1095:3: otherlv_0= 'library' ( ( ruleURI ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleLibraryCS2149); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLibraryCSAccess().getLibraryKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1099:1: ( ( ruleURI ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1100:1: ( ruleURI )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1100:1: ( ruleURI )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1101:3: ruleURI
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
            pushFollow(FollowSets000.FOLLOW_ruleURI_in_ruleLibraryCS2176);
            ruleURI();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleLibraryCS2188); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1129:1: entryRuleNamedDomainCS returns [EObject current=null] : iv_ruleNamedDomainCS= ruleNamedDomainCS EOF ;
    public final EObject entryRuleNamedDomainCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedDomainCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1130:2: (iv_ruleNamedDomainCS= ruleNamedDomainCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1131:2: iv_ruleNamedDomainCS= ruleNamedDomainCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNamedDomainCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNamedDomainCS_in_entryRuleNamedDomainCS2224);
            iv_ruleNamedDomainCS=ruleNamedDomainCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNamedDomainCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNamedDomainCS2234); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1138:1: ruleNamedDomainCS returns [EObject current=null] : ( ( (lv_check_0_0= 'check' ) )? ( (lv_enforce_1_0= 'enforce' ) )? ( ( ruleUnrestrictedName ) ) ( (lv_guardPattern_3_0= ruleGuardPatternCS ) ) ( (lv_bottomPattern_4_0= ruleBottomPatternCS ) ) ) ;
    public final EObject ruleNamedDomainCS() throws RecognitionException {
        EObject current = null;

        Token lv_check_0_0=null;
        Token lv_enforce_1_0=null;
        EObject lv_guardPattern_3_0 = null;

        EObject lv_bottomPattern_4_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1141:28: ( ( ( (lv_check_0_0= 'check' ) )? ( (lv_enforce_1_0= 'enforce' ) )? ( ( ruleUnrestrictedName ) ) ( (lv_guardPattern_3_0= ruleGuardPatternCS ) ) ( (lv_bottomPattern_4_0= ruleBottomPatternCS ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1142:1: ( ( (lv_check_0_0= 'check' ) )? ( (lv_enforce_1_0= 'enforce' ) )? ( ( ruleUnrestrictedName ) ) ( (lv_guardPattern_3_0= ruleGuardPatternCS ) ) ( (lv_bottomPattern_4_0= ruleBottomPatternCS ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1142:1: ( ( (lv_check_0_0= 'check' ) )? ( (lv_enforce_1_0= 'enforce' ) )? ( ( ruleUnrestrictedName ) ) ( (lv_guardPattern_3_0= ruleGuardPatternCS ) ) ( (lv_bottomPattern_4_0= ruleBottomPatternCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1142:2: ( (lv_check_0_0= 'check' ) )? ( (lv_enforce_1_0= 'enforce' ) )? ( ( ruleUnrestrictedName ) ) ( (lv_guardPattern_3_0= ruleGuardPatternCS ) ) ( (lv_bottomPattern_4_0= ruleBottomPatternCS ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1142:2: ( (lv_check_0_0= 'check' ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==36) ) {
                int LA28_1 = input.LA(2);

                if ( ((LA28_1>=RULE_SIMPLE_ID && LA28_1<=RULE_ESCAPED_ID)||LA28_1==16||(LA28_1>=27 && LA28_1<=28)||LA28_1==31||(LA28_1>=35 && LA28_1<=41)) ) {
                    alt28=1;
                }
            }
            switch (alt28) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1143:1: (lv_check_0_0= 'check' )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1143:1: (lv_check_0_0= 'check' )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1144:3: lv_check_0_0= 'check'
                    {
                    lv_check_0_0=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleNamedDomainCS2277); if (state.failed) return current;
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1157:3: ( (lv_enforce_1_0= 'enforce' ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==37) ) {
                int LA29_1 = input.LA(2);

                if ( ((LA29_1>=RULE_SIMPLE_ID && LA29_1<=RULE_ESCAPED_ID)||LA29_1==16||(LA29_1>=27 && LA29_1<=28)||LA29_1==31||(LA29_1>=35 && LA29_1<=41)) ) {
                    alt29=1;
                }
            }
            switch (alt29) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1158:1: (lv_enforce_1_0= 'enforce' )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1158:1: (lv_enforce_1_0= 'enforce' )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1159:3: lv_enforce_1_0= 'enforce'
                    {
                    lv_enforce_1_0=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleNamedDomainCS2309); if (state.failed) return current;
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1172:3: ( ( ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1173:1: ( ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1173:1: ( ruleUnrestrictedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1174:3: ruleUnrestrictedName
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
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleNamedDomainCS2350);
            ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1190:2: ( (lv_guardPattern_3_0= ruleGuardPatternCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1191:1: (lv_guardPattern_3_0= ruleGuardPatternCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1191:1: (lv_guardPattern_3_0= ruleGuardPatternCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1192:3: lv_guardPattern_3_0= ruleGuardPatternCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNamedDomainCSAccess().getGuardPatternGuardPatternCSParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleGuardPatternCS_in_ruleNamedDomainCS2371);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1208:2: ( (lv_bottomPattern_4_0= ruleBottomPatternCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1209:1: (lv_bottomPattern_4_0= ruleBottomPatternCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1209:1: (lv_bottomPattern_4_0= ruleBottomPatternCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1210:3: lv_bottomPattern_4_0= ruleBottomPatternCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNamedDomainCSAccess().getBottomPatternBottomPatternCSParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleBottomPatternCS_in_ruleNamedDomainCS2392);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1234:1: entryRuleParamDeclarationCS returns [EObject current=null] : iv_ruleParamDeclarationCS= ruleParamDeclarationCS EOF ;
    public final EObject entryRuleParamDeclarationCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParamDeclarationCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1235:2: (iv_ruleParamDeclarationCS= ruleParamDeclarationCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1236:2: iv_ruleParamDeclarationCS= ruleParamDeclarationCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParamDeclarationCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleParamDeclarationCS_in_entryRuleParamDeclarationCS2428);
            iv_ruleParamDeclarationCS=ruleParamDeclarationCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParamDeclarationCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParamDeclarationCS2438); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1243:1: ruleParamDeclarationCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) ) ;
    public final EObject ruleParamDeclarationCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1246:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1247:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1247:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1247:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1247:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1248:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1248:1: (lv_name_0_0= ruleUnrestrictedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1249:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParamDeclarationCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleParamDeclarationCS2484);
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

            otherlv_1=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleParamDeclarationCS2496); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getParamDeclarationCSAccess().getColonKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1269:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1270:1: (lv_ownedType_2_0= ruleTypeExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1270:1: (lv_ownedType_2_0= ruleTypeExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1271:3: lv_ownedType_2_0= ruleTypeExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParamDeclarationCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleParamDeclarationCS2517);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1295:1: entryRuleQueryCS returns [EObject current=null] : iv_ruleQueryCS= ruleQueryCS EOF ;
    public final EObject entryRuleQueryCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQueryCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1296:2: (iv_ruleQueryCS= ruleQueryCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1297:2: iv_ruleQueryCS= ruleQueryCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQueryCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleQueryCS_in_entryRuleQueryCS2553);
            iv_ruleQueryCS=ruleQueryCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQueryCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleQueryCS2563); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1304:1: ruleQueryCS returns [EObject current=null] : (otherlv_0= 'query' ( (lv_pathName_1_0= ruleScopeNameCS ) ) ( (lv_name_2_0= ruleUnrestrictedName ) ) otherlv_3= '(' ( ( (lv_inputParamDeclaration_4_0= ruleParamDeclarationCS ) ) (otherlv_5= ',' ( (lv_inputParamDeclaration_6_0= ruleParamDeclarationCS ) ) )* )? otherlv_7= ')' otherlv_8= ':' ( (lv_ownedType_9_0= ruleTypeExpCS ) ) (otherlv_10= ';' | (otherlv_11= '{' ( (lv_expression_12_0= ruleExpCS ) ) otherlv_13= '}' ) ) ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1307:28: ( (otherlv_0= 'query' ( (lv_pathName_1_0= ruleScopeNameCS ) ) ( (lv_name_2_0= ruleUnrestrictedName ) ) otherlv_3= '(' ( ( (lv_inputParamDeclaration_4_0= ruleParamDeclarationCS ) ) (otherlv_5= ',' ( (lv_inputParamDeclaration_6_0= ruleParamDeclarationCS ) ) )* )? otherlv_7= ')' otherlv_8= ':' ( (lv_ownedType_9_0= ruleTypeExpCS ) ) (otherlv_10= ';' | (otherlv_11= '{' ( (lv_expression_12_0= ruleExpCS ) ) otherlv_13= '}' ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1308:1: (otherlv_0= 'query' ( (lv_pathName_1_0= ruleScopeNameCS ) ) ( (lv_name_2_0= ruleUnrestrictedName ) ) otherlv_3= '(' ( ( (lv_inputParamDeclaration_4_0= ruleParamDeclarationCS ) ) (otherlv_5= ',' ( (lv_inputParamDeclaration_6_0= ruleParamDeclarationCS ) ) )* )? otherlv_7= ')' otherlv_8= ':' ( (lv_ownedType_9_0= ruleTypeExpCS ) ) (otherlv_10= ';' | (otherlv_11= '{' ( (lv_expression_12_0= ruleExpCS ) ) otherlv_13= '}' ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1308:1: (otherlv_0= 'query' ( (lv_pathName_1_0= ruleScopeNameCS ) ) ( (lv_name_2_0= ruleUnrestrictedName ) ) otherlv_3= '(' ( ( (lv_inputParamDeclaration_4_0= ruleParamDeclarationCS ) ) (otherlv_5= ',' ( (lv_inputParamDeclaration_6_0= ruleParamDeclarationCS ) ) )* )? otherlv_7= ')' otherlv_8= ':' ( (lv_ownedType_9_0= ruleTypeExpCS ) ) (otherlv_10= ';' | (otherlv_11= '{' ( (lv_expression_12_0= ruleExpCS ) ) otherlv_13= '}' ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1308:3: otherlv_0= 'query' ( (lv_pathName_1_0= ruleScopeNameCS ) ) ( (lv_name_2_0= ruleUnrestrictedName ) ) otherlv_3= '(' ( ( (lv_inputParamDeclaration_4_0= ruleParamDeclarationCS ) ) (otherlv_5= ',' ( (lv_inputParamDeclaration_6_0= ruleParamDeclarationCS ) ) )* )? otherlv_7= ')' otherlv_8= ':' ( (lv_ownedType_9_0= ruleTypeExpCS ) ) (otherlv_10= ';' | (otherlv_11= '{' ( (lv_expression_12_0= ruleExpCS ) ) otherlv_13= '}' ) )
            {
            otherlv_0=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleQueryCS2600); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getQueryCSAccess().getQueryKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1312:1: ( (lv_pathName_1_0= ruleScopeNameCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1313:1: (lv_pathName_1_0= ruleScopeNameCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1313:1: (lv_pathName_1_0= ruleScopeNameCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1314:3: lv_pathName_1_0= ruleScopeNameCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getQueryCSAccess().getPathNameScopeNameCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleScopeNameCS_in_ruleQueryCS2621);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1330:2: ( (lv_name_2_0= ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1331:1: (lv_name_2_0= ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1331:1: (lv_name_2_0= ruleUnrestrictedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1332:3: lv_name_2_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getQueryCSAccess().getNameUnrestrictedNameParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleQueryCS2642);
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

            otherlv_3=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleQueryCS2654); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getQueryCSAccess().getLeftParenthesisKeyword_3());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1352:1: ( ( (lv_inputParamDeclaration_4_0= ruleParamDeclarationCS ) ) (otherlv_5= ',' ( (lv_inputParamDeclaration_6_0= ruleParamDeclarationCS ) ) )* )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( ((LA31_0>=RULE_SIMPLE_ID && LA31_0<=RULE_ESCAPED_ID)||LA31_0==16||(LA31_0>=27 && LA31_0<=28)||LA31_0==31||(LA31_0>=35 && LA31_0<=41)) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1352:2: ( (lv_inputParamDeclaration_4_0= ruleParamDeclarationCS ) ) (otherlv_5= ',' ( (lv_inputParamDeclaration_6_0= ruleParamDeclarationCS ) ) )*
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1352:2: ( (lv_inputParamDeclaration_4_0= ruleParamDeclarationCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1353:1: (lv_inputParamDeclaration_4_0= ruleParamDeclarationCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1353:1: (lv_inputParamDeclaration_4_0= ruleParamDeclarationCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1354:3: lv_inputParamDeclaration_4_0= ruleParamDeclarationCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getQueryCSAccess().getInputParamDeclarationParamDeclarationCSParserRuleCall_4_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleParamDeclarationCS_in_ruleQueryCS2676);
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

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1370:2: (otherlv_5= ',' ( (lv_inputParamDeclaration_6_0= ruleParamDeclarationCS ) ) )*
                    loop30:
                    do {
                        int alt30=2;
                        int LA30_0 = input.LA(1);

                        if ( (LA30_0==24) ) {
                            alt30=1;
                        }


                        switch (alt30) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1370:4: otherlv_5= ',' ( (lv_inputParamDeclaration_6_0= ruleParamDeclarationCS ) )
                    	    {
                    	    otherlv_5=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleQueryCS2689); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_5, grammarAccess.getQueryCSAccess().getCommaKeyword_4_1_0());
                    	          
                    	    }
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1374:1: ( (lv_inputParamDeclaration_6_0= ruleParamDeclarationCS ) )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1375:1: (lv_inputParamDeclaration_6_0= ruleParamDeclarationCS )
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1375:1: (lv_inputParamDeclaration_6_0= ruleParamDeclarationCS )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1376:3: lv_inputParamDeclaration_6_0= ruleParamDeclarationCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getQueryCSAccess().getInputParamDeclarationParamDeclarationCSParserRuleCall_4_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleParamDeclarationCS_in_ruleQueryCS2710);
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

            otherlv_7=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleQueryCS2726); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getQueryCSAccess().getRightParenthesisKeyword_5());
                  
            }
            otherlv_8=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleQueryCS2738); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getQueryCSAccess().getColonKeyword_6());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1400:1: ( (lv_ownedType_9_0= ruleTypeExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1401:1: (lv_ownedType_9_0= ruleTypeExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1401:1: (lv_ownedType_9_0= ruleTypeExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1402:3: lv_ownedType_9_0= ruleTypeExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getQueryCSAccess().getOwnedTypeTypeExpCSParserRuleCall_7_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleQueryCS2759);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1418:2: (otherlv_10= ';' | (otherlv_11= '{' ( (lv_expression_12_0= ruleExpCS ) ) otherlv_13= '}' ) )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==23) ) {
                alt32=1;
            }
            else if ( (LA32_0==18) ) {
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1418:4: otherlv_10= ';'
                    {
                    otherlv_10=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleQueryCS2772); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getQueryCSAccess().getSemicolonKeyword_8_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1423:6: (otherlv_11= '{' ( (lv_expression_12_0= ruleExpCS ) ) otherlv_13= '}' )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1423:6: (otherlv_11= '{' ( (lv_expression_12_0= ruleExpCS ) ) otherlv_13= '}' )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1423:8: otherlv_11= '{' ( (lv_expression_12_0= ruleExpCS ) ) otherlv_13= '}'
                    {
                    otherlv_11=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleQueryCS2791); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_11, grammarAccess.getQueryCSAccess().getLeftCurlyBracketKeyword_8_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1427:1: ( (lv_expression_12_0= ruleExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1428:1: (lv_expression_12_0= ruleExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1428:1: (lv_expression_12_0= ruleExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1429:3: lv_expression_12_0= ruleExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getQueryCSAccess().getExpressionExpCSParserRuleCall_8_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleQueryCS2812);
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

                    otherlv_13=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleQueryCS2824); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1457:1: entryRuleScopeNameCS returns [EObject current=null] : iv_ruleScopeNameCS= ruleScopeNameCS EOF ;
    public final EObject entryRuleScopeNameCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScopeNameCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1458:2: (iv_ruleScopeNameCS= ruleScopeNameCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1459:2: iv_ruleScopeNameCS= ruleScopeNameCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScopeNameCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleScopeNameCS_in_entryRuleScopeNameCS2862);
            iv_ruleScopeNameCS=ruleScopeNameCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScopeNameCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleScopeNameCS2872); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1466:1: ruleScopeNameCS returns [EObject current=null] : ( ( (lv_path_0_0= ruleFirstPathElementCS ) ) otherlv_1= '::' ( ( (lv_path_2_0= ruleNextPathElementCS ) ) otherlv_3= '::' )* ) ;
    public final EObject ruleScopeNameCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_path_0_0 = null;

        EObject lv_path_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1469:28: ( ( ( (lv_path_0_0= ruleFirstPathElementCS ) ) otherlv_1= '::' ( ( (lv_path_2_0= ruleNextPathElementCS ) ) otherlv_3= '::' )* ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1470:1: ( ( (lv_path_0_0= ruleFirstPathElementCS ) ) otherlv_1= '::' ( ( (lv_path_2_0= ruleNextPathElementCS ) ) otherlv_3= '::' )* )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1470:1: ( ( (lv_path_0_0= ruleFirstPathElementCS ) ) otherlv_1= '::' ( ( (lv_path_2_0= ruleNextPathElementCS ) ) otherlv_3= '::' )* )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1470:2: ( (lv_path_0_0= ruleFirstPathElementCS ) ) otherlv_1= '::' ( ( (lv_path_2_0= ruleNextPathElementCS ) ) otherlv_3= '::' )*
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1470:2: ( (lv_path_0_0= ruleFirstPathElementCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1471:1: (lv_path_0_0= ruleFirstPathElementCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1471:1: (lv_path_0_0= ruleFirstPathElementCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1472:3: lv_path_0_0= ruleFirstPathElementCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getScopeNameCSAccess().getPathFirstPathElementCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleFirstPathElementCS_in_ruleScopeNameCS2918);
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

            otherlv_1=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleScopeNameCS2930); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getScopeNameCSAccess().getColonColonKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1492:1: ( ( (lv_path_2_0= ruleNextPathElementCS ) ) otherlv_3= '::' )*
            loop33:
            do {
                int alt33=2;
                alt33 = dfa33.predict(input);
                switch (alt33) {
            	case 1 :
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1492:2: ( (lv_path_2_0= ruleNextPathElementCS ) ) otherlv_3= '::'
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1492:2: ( (lv_path_2_0= ruleNextPathElementCS ) )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1493:1: (lv_path_2_0= ruleNextPathElementCS )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1493:1: (lv_path_2_0= ruleNextPathElementCS )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1494:3: lv_path_2_0= ruleNextPathElementCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getScopeNameCSAccess().getPathNextPathElementCSParserRuleCall_2_0_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleNextPathElementCS_in_ruleScopeNameCS2952);
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

            	    otherlv_3=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleScopeNameCS2964); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1522:1: entryRuleTransformationCS returns [EObject current=null] : iv_ruleTransformationCS= ruleTransformationCS EOF ;
    public final EObject entryRuleTransformationCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransformationCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1523:2: (iv_ruleTransformationCS= ruleTransformationCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1524:2: iv_ruleTransformationCS= ruleTransformationCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTransformationCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTransformationCS_in_entryRuleTransformationCS3002);
            iv_ruleTransformationCS=ruleTransformationCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTransformationCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTransformationCS3012); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1531:1: ruleTransformationCS returns [EObject current=null] : (otherlv_0= 'transformation' ( (lv_pathName_1_0= ruleScopeNameCS ) )? ( (lv_name_2_0= ruleUnreservedName ) ) otherlv_3= '{' ( ( (lv_directions_4_0= ruleDirectionCS ) ) otherlv_5= ';' )* otherlv_6= '}' ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1534:28: ( (otherlv_0= 'transformation' ( (lv_pathName_1_0= ruleScopeNameCS ) )? ( (lv_name_2_0= ruleUnreservedName ) ) otherlv_3= '{' ( ( (lv_directions_4_0= ruleDirectionCS ) ) otherlv_5= ';' )* otherlv_6= '}' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1535:1: (otherlv_0= 'transformation' ( (lv_pathName_1_0= ruleScopeNameCS ) )? ( (lv_name_2_0= ruleUnreservedName ) ) otherlv_3= '{' ( ( (lv_directions_4_0= ruleDirectionCS ) ) otherlv_5= ';' )* otherlv_6= '}' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1535:1: (otherlv_0= 'transformation' ( (lv_pathName_1_0= ruleScopeNameCS ) )? ( (lv_name_2_0= ruleUnreservedName ) ) otherlv_3= '{' ( ( (lv_directions_4_0= ruleDirectionCS ) ) otherlv_5= ';' )* otherlv_6= '}' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1535:3: otherlv_0= 'transformation' ( (lv_pathName_1_0= ruleScopeNameCS ) )? ( (lv_name_2_0= ruleUnreservedName ) ) otherlv_3= '{' ( ( (lv_directions_4_0= ruleDirectionCS ) ) otherlv_5= ';' )* otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,39,FollowSets000.FOLLOW_39_in_ruleTransformationCS3049); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getTransformationCSAccess().getTransformationKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1539:1: ( (lv_pathName_1_0= ruleScopeNameCS ) )?
            int alt34=2;
            alt34 = dfa34.predict(input);
            switch (alt34) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1540:1: (lv_pathName_1_0= ruleScopeNameCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1540:1: (lv_pathName_1_0= ruleScopeNameCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1541:3: lv_pathName_1_0= ruleScopeNameCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTransformationCSAccess().getPathNameScopeNameCSParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleScopeNameCS_in_ruleTransformationCS3070);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1557:3: ( (lv_name_2_0= ruleUnreservedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1558:1: (lv_name_2_0= ruleUnreservedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1558:1: (lv_name_2_0= ruleUnreservedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1559:3: lv_name_2_0= ruleUnreservedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTransformationCSAccess().getNameUnreservedNameParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnreservedName_in_ruleTransformationCS3092);
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

            otherlv_3=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleTransformationCS3104); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getTransformationCSAccess().getLeftCurlyBracketKeyword_3());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1579:1: ( ( (lv_directions_4_0= ruleDirectionCS ) ) otherlv_5= ';' )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==EOF||(LA35_0>=RULE_SIMPLE_ID && LA35_0<=RULE_ESCAPED_ID)||LA35_0==16||LA35_0==23||(LA35_0>=27 && LA35_0<=28)||LA35_0==31||(LA35_0>=35 && LA35_0<=41)) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1579:2: ( (lv_directions_4_0= ruleDirectionCS ) ) otherlv_5= ';'
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1579:2: ( (lv_directions_4_0= ruleDirectionCS ) )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1580:1: (lv_directions_4_0= ruleDirectionCS )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1580:1: (lv_directions_4_0= ruleDirectionCS )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1581:3: lv_directions_4_0= ruleDirectionCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTransformationCSAccess().getDirectionsDirectionCSParserRuleCall_4_0_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleDirectionCS_in_ruleTransformationCS3126);
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

            	    otherlv_5=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleTransformationCS3138); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_5, grammarAccess.getTransformationCSAccess().getSemicolonKeyword_4_1());
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);

            otherlv_6=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleTransformationCS3152); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1613:1: entryRuleUnrealizedVariableCS returns [EObject current=null] : iv_ruleUnrealizedVariableCS= ruleUnrealizedVariableCS EOF ;
    public final EObject entryRuleUnrealizedVariableCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnrealizedVariableCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1614:2: (iv_ruleUnrealizedVariableCS= ruleUnrealizedVariableCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1615:2: iv_ruleUnrealizedVariableCS= ruleUnrealizedVariableCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnrealizedVariableCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrealizedVariableCS_in_entryRuleUnrealizedVariableCS3188);
            iv_ruleUnrealizedVariableCS=ruleUnrealizedVariableCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnrealizedVariableCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnrealizedVariableCS3198); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1622:1: ruleUnrealizedVariableCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) ) ;
    public final EObject ruleUnrealizedVariableCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1625:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1626:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1626:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1626:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1626:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1627:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1627:1: (lv_name_0_0= ruleUnrestrictedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1628:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getUnrealizedVariableCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleUnrealizedVariableCS3244);
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

            otherlv_1=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleUnrealizedVariableCS3256); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getUnrealizedVariableCSAccess().getColonKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1648:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1649:1: (lv_ownedType_2_0= ruleTypeExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1649:1: (lv_ownedType_2_0= ruleTypeExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1650:3: lv_ownedType_2_0= ruleTypeExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getUnrealizedVariableCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleUnrealizedVariableCS3277);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1674:1: entryRuleRealizedVariableCS returns [EObject current=null] : iv_ruleRealizedVariableCS= ruleRealizedVariableCS EOF ;
    public final EObject entryRuleRealizedVariableCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealizedVariableCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1675:2: (iv_ruleRealizedVariableCS= ruleRealizedVariableCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1676:2: iv_ruleRealizedVariableCS= ruleRealizedVariableCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRealizedVariableCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleRealizedVariableCS_in_entryRuleRealizedVariableCS3313);
            iv_ruleRealizedVariableCS=ruleRealizedVariableCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRealizedVariableCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRealizedVariableCS3323); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1683:1: ruleRealizedVariableCS returns [EObject current=null] : (otherlv_0= 'realize' ( (lv_name_1_0= ruleUnrestrictedName ) ) otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) ) ;
    public final EObject ruleRealizedVariableCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_ownedType_3_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1686:28: ( (otherlv_0= 'realize' ( (lv_name_1_0= ruleUnrestrictedName ) ) otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1687:1: (otherlv_0= 'realize' ( (lv_name_1_0= ruleUnrestrictedName ) ) otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1687:1: (otherlv_0= 'realize' ( (lv_name_1_0= ruleUnrestrictedName ) ) otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1687:3: otherlv_0= 'realize' ( (lv_name_1_0= ruleUnrestrictedName ) ) otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) )
            {
            otherlv_0=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleRealizedVariableCS3360); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getRealizedVariableCSAccess().getRealizeKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1691:1: ( (lv_name_1_0= ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1692:1: (lv_name_1_0= ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1692:1: (lv_name_1_0= ruleUnrestrictedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1693:3: lv_name_1_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRealizedVariableCSAccess().getNameUnrestrictedNameParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleRealizedVariableCS3381);
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

            otherlv_2=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleRealizedVariableCS3393); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getRealizedVariableCSAccess().getColonKeyword_2());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1713:1: ( (lv_ownedType_3_0= ruleTypeExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1714:1: (lv_ownedType_3_0= ruleTypeExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1714:1: (lv_ownedType_3_0= ruleTypeExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1715:3: lv_ownedType_3_0= ruleTypeExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRealizedVariableCSAccess().getOwnedTypeTypeExpCSParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleRealizedVariableCS3414);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1739:1: entryRuleUnnamedDomainCS returns [EObject current=null] : iv_ruleUnnamedDomainCS= ruleUnnamedDomainCS EOF ;
    public final EObject entryRuleUnnamedDomainCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnnamedDomainCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1740:2: (iv_ruleUnnamedDomainCS= ruleUnnamedDomainCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1741:2: iv_ruleUnnamedDomainCS= ruleUnnamedDomainCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnnamedDomainCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnnamedDomainCS_in_entryRuleUnnamedDomainCS3450);
            iv_ruleUnnamedDomainCS=ruleUnnamedDomainCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnnamedDomainCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnnamedDomainCS3460); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1748:1: ruleUnnamedDomainCS returns [EObject current=null] : ( () ( (lv_guardPattern_1_0= ruleGuardPatternCS ) ) ( (lv_bottomPattern_2_0= ruleBottomPatternCS ) ) ) ;
    public final EObject ruleUnnamedDomainCS() throws RecognitionException {
        EObject current = null;

        EObject lv_guardPattern_1_0 = null;

        EObject lv_bottomPattern_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1751:28: ( ( () ( (lv_guardPattern_1_0= ruleGuardPatternCS ) ) ( (lv_bottomPattern_2_0= ruleBottomPatternCS ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1752:1: ( () ( (lv_guardPattern_1_0= ruleGuardPatternCS ) ) ( (lv_bottomPattern_2_0= ruleBottomPatternCS ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1752:1: ( () ( (lv_guardPattern_1_0= ruleGuardPatternCS ) ) ( (lv_bottomPattern_2_0= ruleBottomPatternCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1752:2: () ( (lv_guardPattern_1_0= ruleGuardPatternCS ) ) ( (lv_bottomPattern_2_0= ruleBottomPatternCS ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1752:2: ()
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1753:2: 
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1761:2: ( (lv_guardPattern_1_0= ruleGuardPatternCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1762:1: (lv_guardPattern_1_0= ruleGuardPatternCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1762:1: (lv_guardPattern_1_0= ruleGuardPatternCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1763:3: lv_guardPattern_1_0= ruleGuardPatternCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getUnnamedDomainCSAccess().getGuardPatternGuardPatternCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleGuardPatternCS_in_ruleUnnamedDomainCS3518);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1779:2: ( (lv_bottomPattern_2_0= ruleBottomPatternCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1780:1: (lv_bottomPattern_2_0= ruleBottomPatternCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1780:1: (lv_bottomPattern_2_0= ruleBottomPatternCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1781:3: lv_bottomPattern_2_0= ruleBottomPatternCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getUnnamedDomainCSAccess().getBottomPatternBottomPatternCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleBottomPatternCS_in_ruleUnnamedDomainCS3539);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1805:1: entryRuleUnrestrictedName returns [String current=null] : iv_ruleUnrestrictedName= ruleUnrestrictedName EOF ;
    public final String entryRuleUnrestrictedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnrestrictedName = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1806:2: (iv_ruleUnrestrictedName= ruleUnrestrictedName EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1807:2: iv_ruleUnrestrictedName= ruleUnrestrictedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnrestrictedNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_entryRuleUnrestrictedName3576);
            iv_ruleUnrestrictedName=ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnrestrictedName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnrestrictedName3587); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1814:1: ruleUnrestrictedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_EssentialOCLUnrestrictedName_0= ruleEssentialOCLUnrestrictedName | kw= 'check' | kw= 'enforce' | kw= 'import' | kw= 'imports' | kw= 'library' | kw= 'map' | kw= 'query' | kw= 'realize' | kw= 'refines' | kw= 'transformation' | kw= 'uses' ) ;
    public final AntlrDatatypeRuleToken ruleUnrestrictedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_EssentialOCLUnrestrictedName_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1817:28: ( (this_EssentialOCLUnrestrictedName_0= ruleEssentialOCLUnrestrictedName | kw= 'check' | kw= 'enforce' | kw= 'import' | kw= 'imports' | kw= 'library' | kw= 'map' | kw= 'query' | kw= 'realize' | kw= 'refines' | kw= 'transformation' | kw= 'uses' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1818:1: (this_EssentialOCLUnrestrictedName_0= ruleEssentialOCLUnrestrictedName | kw= 'check' | kw= 'enforce' | kw= 'import' | kw= 'imports' | kw= 'library' | kw= 'map' | kw= 'query' | kw= 'realize' | kw= 'refines' | kw= 'transformation' | kw= 'uses' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1818:1: (this_EssentialOCLUnrestrictedName_0= ruleEssentialOCLUnrestrictedName | kw= 'check' | kw= 'enforce' | kw= 'import' | kw= 'imports' | kw= 'library' | kw= 'map' | kw= 'query' | kw= 'realize' | kw= 'refines' | kw= 'transformation' | kw= 'uses' )
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
            case 41:
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1819:5: this_EssentialOCLUnrestrictedName_0= ruleEssentialOCLUnrestrictedName
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getUnrestrictedNameAccess().getEssentialOCLUnrestrictedNameParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLUnrestrictedName_in_ruleUnrestrictedName3634);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1831:2: kw= 'check'
                    {
                    kw=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleUnrestrictedName3658); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getCheckKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1838:2: kw= 'enforce'
                    {
                    kw=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleUnrestrictedName3677); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getEnforceKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1845:2: kw= 'import'
                    {
                    kw=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleUnrestrictedName3696); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getImportKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1852:2: kw= 'imports'
                    {
                    kw=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleUnrestrictedName3715); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getImportsKeyword_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1859:2: kw= 'library'
                    {
                    kw=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleUnrestrictedName3734); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getLibraryKeyword_5()); 
                          
                    }

                    }
                    break;
                case 7 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1866:2: kw= 'map'
                    {
                    kw=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleUnrestrictedName3753); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getMapKeyword_6()); 
                          
                    }

                    }
                    break;
                case 8 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1873:2: kw= 'query'
                    {
                    kw=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleUnrestrictedName3772); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getQueryKeyword_7()); 
                          
                    }

                    }
                    break;
                case 9 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1880:2: kw= 'realize'
                    {
                    kw=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleUnrestrictedName3791); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getRealizeKeyword_8()); 
                          
                    }

                    }
                    break;
                case 10 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1887:2: kw= 'refines'
                    {
                    kw=(Token)match(input,41,FollowSets000.FOLLOW_41_in_ruleUnrestrictedName3810); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getRefinesKeyword_9()); 
                          
                    }

                    }
                    break;
                case 11 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1894:2: kw= 'transformation'
                    {
                    kw=(Token)match(input,39,FollowSets000.FOLLOW_39_in_ruleUnrestrictedName3829); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getTransformationKeyword_10()); 
                          
                    }

                    }
                    break;
                case 12 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1901:2: kw= 'uses'
                    {
                    kw=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleUnrestrictedName3848); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1916:1: entryRuleID returns [String current=null] : iv_ruleID= ruleID EOF ;
    public final String entryRuleID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleID = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1917:2: (iv_ruleID= ruleID EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1918:2: iv_ruleID= ruleID EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIDRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleID_in_entryRuleID3891);
            iv_ruleID=ruleID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleID.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleID3902); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1925:1: ruleID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_SIMPLE_ID_0= RULE_SIMPLE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID ) ;
    public final AntlrDatatypeRuleToken ruleID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_SIMPLE_ID_0=null;
        Token this_ESCAPED_ID_1=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1928:28: ( (this_SIMPLE_ID_0= RULE_SIMPLE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1929:1: (this_SIMPLE_ID_0= RULE_SIMPLE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1929:1: (this_SIMPLE_ID_0= RULE_SIMPLE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID )
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1929:6: this_SIMPLE_ID_0= RULE_SIMPLE_ID
                    {
                    this_SIMPLE_ID_0=(Token)match(input,RULE_SIMPLE_ID,FollowSets000.FOLLOW_RULE_SIMPLE_ID_in_ruleID3942); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SIMPLE_ID_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SIMPLE_ID_0, grammarAccess.getIDAccess().getSIMPLE_IDTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1937:10: this_ESCAPED_ID_1= RULE_ESCAPED_ID
                    {
                    this_ESCAPED_ID_1=(Token)match(input,RULE_ESCAPED_ID,FollowSets000.FOLLOW_RULE_ESCAPED_ID_in_ruleID3968); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1952:1: entryRuleLOWER returns [String current=null] : iv_ruleLOWER= ruleLOWER EOF ;
    public final String entryRuleLOWER() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLOWER = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1953:2: (iv_ruleLOWER= ruleLOWER EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1954:2: iv_ruleLOWER= ruleLOWER EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLOWERRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLOWER_in_entryRuleLOWER4014);
            iv_ruleLOWER=ruleLOWER();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLOWER.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLOWER4025); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1961:1: ruleLOWER returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INT_0= RULE_INT ;
    public final AntlrDatatypeRuleToken ruleLOWER() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1964:28: (this_INT_0= RULE_INT )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1965:5: this_INT_0= RULE_INT
            {
            this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleLOWER4064); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1980:1: entryRuleUPPER returns [String current=null] : iv_ruleUPPER= ruleUPPER EOF ;
    public final String entryRuleUPPER() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUPPER = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1981:2: (iv_ruleUPPER= ruleUPPER EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1982:2: iv_ruleUPPER= ruleUPPER EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUPPERRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUPPER_in_entryRuleUPPER4109);
            iv_ruleUPPER=ruleUPPER();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUPPER.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUPPER4120); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1989:1: ruleUPPER returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT | kw= '*' ) ;
    public final AntlrDatatypeRuleToken ruleUPPER() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1992:28: ( (this_INT_0= RULE_INT | kw= '*' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1993:1: (this_INT_0= RULE_INT | kw= '*' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1993:1: (this_INT_0= RULE_INT | kw= '*' )
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:1993:6: this_INT_0= RULE_INT
                    {
                    this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleUPPER4160); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_INT_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_INT_0, grammarAccess.getUPPERAccess().getINTTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2002:2: kw= '*'
                    {
                    kw=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleUPPER4184); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2015:1: entryRuleNUMBER_LITERAL returns [String current=null] : iv_ruleNUMBER_LITERAL= ruleNUMBER_LITERAL EOF ;
    public final String entryRuleNUMBER_LITERAL() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNUMBER_LITERAL = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2016:2: (iv_ruleNUMBER_LITERAL= ruleNUMBER_LITERAL EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2017:2: iv_ruleNUMBER_LITERAL= ruleNUMBER_LITERAL EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNUMBER_LITERALRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNUMBER_LITERAL_in_entryRuleNUMBER_LITERAL4225);
            iv_ruleNUMBER_LITERAL=ruleNUMBER_LITERAL();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNUMBER_LITERAL.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNUMBER_LITERAL4236); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2024:1: ruleNUMBER_LITERAL returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INT_0= RULE_INT ;
    public final AntlrDatatypeRuleToken ruleNUMBER_LITERAL() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2027:28: (this_INT_0= RULE_INT )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2028:5: this_INT_0= RULE_INT
            {
            this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleNUMBER_LITERAL4275); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2043:1: entryRuleURI returns [String current=null] : iv_ruleURI= ruleURI EOF ;
    public final String entryRuleURI() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleURI = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2044:2: (iv_ruleURI= ruleURI EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2045:2: iv_ruleURI= ruleURI EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getURIRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleURI_in_entryRuleURI4320);
            iv_ruleURI=ruleURI();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleURI.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleURI4331); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2052:1: ruleURI returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING ;
    public final AntlrDatatypeRuleToken ruleURI() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_SINGLE_QUOTED_STRING_0=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2055:28: (this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2056:5: this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING
            {
            this_SINGLE_QUOTED_STRING_0=(Token)match(input,RULE_SINGLE_QUOTED_STRING,FollowSets000.FOLLOW_RULE_SINGLE_QUOTED_STRING_in_ruleURI4370); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2073:1: entryRuleEssentialOCLUnaryOperatorCS returns [EObject current=null] : iv_ruleEssentialOCLUnaryOperatorCS= ruleEssentialOCLUnaryOperatorCS EOF ;
    public final EObject entryRuleEssentialOCLUnaryOperatorCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEssentialOCLUnaryOperatorCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2074:2: (iv_ruleEssentialOCLUnaryOperatorCS= ruleEssentialOCLUnaryOperatorCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2075:2: iv_ruleEssentialOCLUnaryOperatorCS= ruleEssentialOCLUnaryOperatorCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEssentialOCLUnaryOperatorCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLUnaryOperatorCS_in_entryRuleEssentialOCLUnaryOperatorCS4416);
            iv_ruleEssentialOCLUnaryOperatorCS=ruleEssentialOCLUnaryOperatorCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEssentialOCLUnaryOperatorCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEssentialOCLUnaryOperatorCS4426); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2082:1: ruleEssentialOCLUnaryOperatorCS returns [EObject current=null] : ( ( (lv_name_0_1= '-' | lv_name_0_2= 'not' ) ) ) ;
    public final EObject ruleEssentialOCLUnaryOperatorCS() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2085:28: ( ( ( (lv_name_0_1= '-' | lv_name_0_2= 'not' ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2086:1: ( ( (lv_name_0_1= '-' | lv_name_0_2= 'not' ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2086:1: ( ( (lv_name_0_1= '-' | lv_name_0_2= 'not' ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2087:1: ( (lv_name_0_1= '-' | lv_name_0_2= 'not' ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2087:1: ( (lv_name_0_1= '-' | lv_name_0_2= 'not' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2088:1: (lv_name_0_1= '-' | lv_name_0_2= 'not' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2088:1: (lv_name_0_1= '-' | lv_name_0_2= 'not' )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==42) ) {
                alt39=1;
            }
            else if ( (LA39_0==43) ) {
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2089:3: lv_name_0_1= '-'
                    {
                    lv_name_0_1=(Token)match(input,42,FollowSets000.FOLLOW_42_in_ruleEssentialOCLUnaryOperatorCS4470); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2101:8: lv_name_0_2= 'not'
                    {
                    lv_name_0_2=(Token)match(input,43,FollowSets000.FOLLOW_43_in_ruleEssentialOCLUnaryOperatorCS4499); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2124:1: entryRuleEssentialOCLInfixOperatorCS returns [EObject current=null] : iv_ruleEssentialOCLInfixOperatorCS= ruleEssentialOCLInfixOperatorCS EOF ;
    public final EObject entryRuleEssentialOCLInfixOperatorCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEssentialOCLInfixOperatorCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2125:2: (iv_ruleEssentialOCLInfixOperatorCS= ruleEssentialOCLInfixOperatorCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2126:2: iv_ruleEssentialOCLInfixOperatorCS= ruleEssentialOCLInfixOperatorCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEssentialOCLInfixOperatorCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLInfixOperatorCS_in_entryRuleEssentialOCLInfixOperatorCS4550);
            iv_ruleEssentialOCLInfixOperatorCS=ruleEssentialOCLInfixOperatorCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEssentialOCLInfixOperatorCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEssentialOCLInfixOperatorCS4560); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2133:1: ruleEssentialOCLInfixOperatorCS returns [EObject current=null] : ( ( (lv_name_0_1= '*' | lv_name_0_2= '/' | lv_name_0_3= '+' | lv_name_0_4= '-' | lv_name_0_5= '>' | lv_name_0_6= '<' | lv_name_0_7= '>=' | lv_name_0_8= '<=' | lv_name_0_9= '=' | lv_name_0_10= '<>' | lv_name_0_11= 'and' | lv_name_0_12= 'or' | lv_name_0_13= 'xor' | lv_name_0_14= 'implies' ) ) ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2136:28: ( ( ( (lv_name_0_1= '*' | lv_name_0_2= '/' | lv_name_0_3= '+' | lv_name_0_4= '-' | lv_name_0_5= '>' | lv_name_0_6= '<' | lv_name_0_7= '>=' | lv_name_0_8= '<=' | lv_name_0_9= '=' | lv_name_0_10= '<>' | lv_name_0_11= 'and' | lv_name_0_12= 'or' | lv_name_0_13= 'xor' | lv_name_0_14= 'implies' ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2137:1: ( ( (lv_name_0_1= '*' | lv_name_0_2= '/' | lv_name_0_3= '+' | lv_name_0_4= '-' | lv_name_0_5= '>' | lv_name_0_6= '<' | lv_name_0_7= '>=' | lv_name_0_8= '<=' | lv_name_0_9= '=' | lv_name_0_10= '<>' | lv_name_0_11= 'and' | lv_name_0_12= 'or' | lv_name_0_13= 'xor' | lv_name_0_14= 'implies' ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2137:1: ( ( (lv_name_0_1= '*' | lv_name_0_2= '/' | lv_name_0_3= '+' | lv_name_0_4= '-' | lv_name_0_5= '>' | lv_name_0_6= '<' | lv_name_0_7= '>=' | lv_name_0_8= '<=' | lv_name_0_9= '=' | lv_name_0_10= '<>' | lv_name_0_11= 'and' | lv_name_0_12= 'or' | lv_name_0_13= 'xor' | lv_name_0_14= 'implies' ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2138:1: ( (lv_name_0_1= '*' | lv_name_0_2= '/' | lv_name_0_3= '+' | lv_name_0_4= '-' | lv_name_0_5= '>' | lv_name_0_6= '<' | lv_name_0_7= '>=' | lv_name_0_8= '<=' | lv_name_0_9= '=' | lv_name_0_10= '<>' | lv_name_0_11= 'and' | lv_name_0_12= 'or' | lv_name_0_13= 'xor' | lv_name_0_14= 'implies' ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2138:1: ( (lv_name_0_1= '*' | lv_name_0_2= '/' | lv_name_0_3= '+' | lv_name_0_4= '-' | lv_name_0_5= '>' | lv_name_0_6= '<' | lv_name_0_7= '>=' | lv_name_0_8= '<=' | lv_name_0_9= '=' | lv_name_0_10= '<>' | lv_name_0_11= 'and' | lv_name_0_12= 'or' | lv_name_0_13= 'xor' | lv_name_0_14= 'implies' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2139:1: (lv_name_0_1= '*' | lv_name_0_2= '/' | lv_name_0_3= '+' | lv_name_0_4= '-' | lv_name_0_5= '>' | lv_name_0_6= '<' | lv_name_0_7= '>=' | lv_name_0_8= '<=' | lv_name_0_9= '=' | lv_name_0_10= '<>' | lv_name_0_11= 'and' | lv_name_0_12= 'or' | lv_name_0_13= 'xor' | lv_name_0_14= 'implies' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2139:1: (lv_name_0_1= '*' | lv_name_0_2= '/' | lv_name_0_3= '+' | lv_name_0_4= '-' | lv_name_0_5= '>' | lv_name_0_6= '<' | lv_name_0_7= '>=' | lv_name_0_8= '<=' | lv_name_0_9= '=' | lv_name_0_10= '<>' | lv_name_0_11= 'and' | lv_name_0_12= 'or' | lv_name_0_13= 'xor' | lv_name_0_14= 'implies' )
            int alt40=14;
            switch ( input.LA(1) ) {
            case 34:
                {
                alt40=1;
                }
                break;
            case 44:
                {
                alt40=2;
                }
                break;
            case 45:
                {
                alt40=3;
                }
                break;
            case 42:
                {
                alt40=4;
                }
                break;
            case 46:
                {
                alt40=5;
                }
                break;
            case 47:
                {
                alt40=6;
                }
                break;
            case 48:
                {
                alt40=7;
                }
                break;
            case 22:
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2140:3: lv_name_0_1= '*'
                    {
                    lv_name_0_1=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleEssentialOCLInfixOperatorCS4604); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2152:8: lv_name_0_2= '/'
                    {
                    lv_name_0_2=(Token)match(input,44,FollowSets000.FOLLOW_44_in_ruleEssentialOCLInfixOperatorCS4633); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2164:8: lv_name_0_3= '+'
                    {
                    lv_name_0_3=(Token)match(input,45,FollowSets000.FOLLOW_45_in_ruleEssentialOCLInfixOperatorCS4662); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2176:8: lv_name_0_4= '-'
                    {
                    lv_name_0_4=(Token)match(input,42,FollowSets000.FOLLOW_42_in_ruleEssentialOCLInfixOperatorCS4691); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2188:8: lv_name_0_5= '>'
                    {
                    lv_name_0_5=(Token)match(input,46,FollowSets000.FOLLOW_46_in_ruleEssentialOCLInfixOperatorCS4720); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2200:8: lv_name_0_6= '<'
                    {
                    lv_name_0_6=(Token)match(input,47,FollowSets000.FOLLOW_47_in_ruleEssentialOCLInfixOperatorCS4749); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2212:8: lv_name_0_7= '>='
                    {
                    lv_name_0_7=(Token)match(input,48,FollowSets000.FOLLOW_48_in_ruleEssentialOCLInfixOperatorCS4778); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2224:8: lv_name_0_8= '<='
                    {
                    lv_name_0_8=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleEssentialOCLInfixOperatorCS4807); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2236:8: lv_name_0_9= '='
                    {
                    lv_name_0_9=(Token)match(input,49,FollowSets000.FOLLOW_49_in_ruleEssentialOCLInfixOperatorCS4836); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2248:8: lv_name_0_10= '<>'
                    {
                    lv_name_0_10=(Token)match(input,50,FollowSets000.FOLLOW_50_in_ruleEssentialOCLInfixOperatorCS4865); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2260:8: lv_name_0_11= 'and'
                    {
                    lv_name_0_11=(Token)match(input,51,FollowSets000.FOLLOW_51_in_ruleEssentialOCLInfixOperatorCS4894); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2272:8: lv_name_0_12= 'or'
                    {
                    lv_name_0_12=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleEssentialOCLInfixOperatorCS4923); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2284:8: lv_name_0_13= 'xor'
                    {
                    lv_name_0_13=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleEssentialOCLInfixOperatorCS4952); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2296:8: lv_name_0_14= 'implies'
                    {
                    lv_name_0_14=(Token)match(input,54,FollowSets000.FOLLOW_54_in_ruleEssentialOCLInfixOperatorCS4981); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2319:1: entryRuleEssentialOCLNavigationOperatorCS returns [EObject current=null] : iv_ruleEssentialOCLNavigationOperatorCS= ruleEssentialOCLNavigationOperatorCS EOF ;
    public final EObject entryRuleEssentialOCLNavigationOperatorCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEssentialOCLNavigationOperatorCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2320:2: (iv_ruleEssentialOCLNavigationOperatorCS= ruleEssentialOCLNavigationOperatorCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2321:2: iv_ruleEssentialOCLNavigationOperatorCS= ruleEssentialOCLNavigationOperatorCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEssentialOCLNavigationOperatorCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLNavigationOperatorCS_in_entryRuleEssentialOCLNavigationOperatorCS5032);
            iv_ruleEssentialOCLNavigationOperatorCS=ruleEssentialOCLNavigationOperatorCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEssentialOCLNavigationOperatorCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEssentialOCLNavigationOperatorCS5042); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2328:1: ruleEssentialOCLNavigationOperatorCS returns [EObject current=null] : ( ( (lv_name_0_1= '.' | lv_name_0_2= '->' ) ) ) ;
    public final EObject ruleEssentialOCLNavigationOperatorCS() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2331:28: ( ( ( (lv_name_0_1= '.' | lv_name_0_2= '->' ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2332:1: ( ( (lv_name_0_1= '.' | lv_name_0_2= '->' ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2332:1: ( ( (lv_name_0_1= '.' | lv_name_0_2= '->' ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2333:1: ( (lv_name_0_1= '.' | lv_name_0_2= '->' ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2333:1: ( (lv_name_0_1= '.' | lv_name_0_2= '->' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2334:1: (lv_name_0_1= '.' | lv_name_0_2= '->' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2334:1: (lv_name_0_1= '.' | lv_name_0_2= '->' )
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2335:3: lv_name_0_1= '.'
                    {
                    lv_name_0_1=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleEssentialOCLNavigationOperatorCS5086); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2347:8: lv_name_0_2= '->'
                    {
                    lv_name_0_2=(Token)match(input,56,FollowSets000.FOLLOW_56_in_ruleEssentialOCLNavigationOperatorCS5115); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2370:1: entryRuleIdentifier returns [String current=null] : iv_ruleIdentifier= ruleIdentifier EOF ;
    public final String entryRuleIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdentifier = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2371:2: (iv_ruleIdentifier= ruleIdentifier EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2372:2: iv_ruleIdentifier= ruleIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIdentifierRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_entryRuleIdentifier5167);
            iv_ruleIdentifier=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIdentifier.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIdentifier5178); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2379:1: ruleIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= ruleID ;
    public final AntlrDatatypeRuleToken ruleIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_ID_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2382:28: (this_ID_0= ruleID )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2384:5: this_ID_0= ruleID
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getIdentifierAccess().getIDParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleID_in_ruleIdentifier5224);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2402:1: entryRuleStringLiteral returns [String current=null] : iv_ruleStringLiteral= ruleStringLiteral EOF ;
    public final String entryRuleStringLiteral() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleStringLiteral = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2403:2: (iv_ruleStringLiteral= ruleStringLiteral EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2404:2: iv_ruleStringLiteral= ruleStringLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStringLiteralRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral5269);
            iv_ruleStringLiteral=ruleStringLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStringLiteral.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleStringLiteral5280); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2411:1: ruleStringLiteral returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING ;
    public final AntlrDatatypeRuleToken ruleStringLiteral() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_SINGLE_QUOTED_STRING_0=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2414:28: (this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2415:5: this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING
            {
            this_SINGLE_QUOTED_STRING_0=(Token)match(input,RULE_SINGLE_QUOTED_STRING,FollowSets000.FOLLOW_RULE_SINGLE_QUOTED_STRING_in_ruleStringLiteral5319); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2430:1: entryRuleBinaryOperatorCS returns [EObject current=null] : iv_ruleBinaryOperatorCS= ruleBinaryOperatorCS EOF ;
    public final EObject entryRuleBinaryOperatorCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinaryOperatorCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2431:2: (iv_ruleBinaryOperatorCS= ruleBinaryOperatorCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2432:2: iv_ruleBinaryOperatorCS= ruleBinaryOperatorCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBinaryOperatorCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleBinaryOperatorCS_in_entryRuleBinaryOperatorCS5363);
            iv_ruleBinaryOperatorCS=ruleBinaryOperatorCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBinaryOperatorCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBinaryOperatorCS5373); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2439:1: ruleBinaryOperatorCS returns [EObject current=null] : (this_InfixOperatorCS_0= ruleInfixOperatorCS | this_NavigationOperatorCS_1= ruleNavigationOperatorCS ) ;
    public final EObject ruleBinaryOperatorCS() throws RecognitionException {
        EObject current = null;

        EObject this_InfixOperatorCS_0 = null;

        EObject this_NavigationOperatorCS_1 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2442:28: ( (this_InfixOperatorCS_0= ruleInfixOperatorCS | this_NavigationOperatorCS_1= ruleNavigationOperatorCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2443:1: (this_InfixOperatorCS_0= ruleInfixOperatorCS | this_NavigationOperatorCS_1= ruleNavigationOperatorCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2443:1: (this_InfixOperatorCS_0= ruleInfixOperatorCS | this_NavigationOperatorCS_1= ruleNavigationOperatorCS )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==22||LA42_0==34||LA42_0==42||(LA42_0>=44 && LA42_0<=54)) ) {
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2444:2: this_InfixOperatorCS_0= ruleInfixOperatorCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBinaryOperatorCSAccess().getInfixOperatorCSParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleInfixOperatorCS_in_ruleBinaryOperatorCS5423);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2457:2: this_NavigationOperatorCS_1= ruleNavigationOperatorCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBinaryOperatorCSAccess().getNavigationOperatorCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNavigationOperatorCS_in_ruleBinaryOperatorCS5453);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2476:1: entryRuleInfixOperatorCS returns [EObject current=null] : iv_ruleInfixOperatorCS= ruleInfixOperatorCS EOF ;
    public final EObject entryRuleInfixOperatorCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInfixOperatorCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2477:2: (iv_ruleInfixOperatorCS= ruleInfixOperatorCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2478:2: iv_ruleInfixOperatorCS= ruleInfixOperatorCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInfixOperatorCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleInfixOperatorCS_in_entryRuleInfixOperatorCS5488);
            iv_ruleInfixOperatorCS=ruleInfixOperatorCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInfixOperatorCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleInfixOperatorCS5498); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2485:1: ruleInfixOperatorCS returns [EObject current=null] : this_EssentialOCLInfixOperatorCS_0= ruleEssentialOCLInfixOperatorCS ;
    public final EObject ruleInfixOperatorCS() throws RecognitionException {
        EObject current = null;

        EObject this_EssentialOCLInfixOperatorCS_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2488:28: (this_EssentialOCLInfixOperatorCS_0= ruleEssentialOCLInfixOperatorCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2490:2: this_EssentialOCLInfixOperatorCS_0= ruleEssentialOCLInfixOperatorCS
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getInfixOperatorCSAccess().getEssentialOCLInfixOperatorCSParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLInfixOperatorCS_in_ruleInfixOperatorCS5547);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2509:1: entryRuleNavigationOperatorCS returns [EObject current=null] : iv_ruleNavigationOperatorCS= ruleNavigationOperatorCS EOF ;
    public final EObject entryRuleNavigationOperatorCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigationOperatorCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2510:2: (iv_ruleNavigationOperatorCS= ruleNavigationOperatorCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2511:2: iv_ruleNavigationOperatorCS= ruleNavigationOperatorCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigationOperatorCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigationOperatorCS_in_entryRuleNavigationOperatorCS5581);
            iv_ruleNavigationOperatorCS=ruleNavigationOperatorCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigationOperatorCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigationOperatorCS5591); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2518:1: ruleNavigationOperatorCS returns [EObject current=null] : this_EssentialOCLNavigationOperatorCS_0= ruleEssentialOCLNavigationOperatorCS ;
    public final EObject ruleNavigationOperatorCS() throws RecognitionException {
        EObject current = null;

        EObject this_EssentialOCLNavigationOperatorCS_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2521:28: (this_EssentialOCLNavigationOperatorCS_0= ruleEssentialOCLNavigationOperatorCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2523:2: this_EssentialOCLNavigationOperatorCS_0= ruleEssentialOCLNavigationOperatorCS
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getNavigationOperatorCSAccess().getEssentialOCLNavigationOperatorCSParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLNavigationOperatorCS_in_ruleNavigationOperatorCS5640);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2542:1: entryRuleUnaryOperatorCS returns [EObject current=null] : iv_ruleUnaryOperatorCS= ruleUnaryOperatorCS EOF ;
    public final EObject entryRuleUnaryOperatorCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryOperatorCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2543:2: (iv_ruleUnaryOperatorCS= ruleUnaryOperatorCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2544:2: iv_ruleUnaryOperatorCS= ruleUnaryOperatorCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryOperatorCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnaryOperatorCS_in_entryRuleUnaryOperatorCS5674);
            iv_ruleUnaryOperatorCS=ruleUnaryOperatorCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnaryOperatorCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnaryOperatorCS5684); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2551:1: ruleUnaryOperatorCS returns [EObject current=null] : this_EssentialOCLUnaryOperatorCS_0= ruleEssentialOCLUnaryOperatorCS ;
    public final EObject ruleUnaryOperatorCS() throws RecognitionException {
        EObject current = null;

        EObject this_EssentialOCLUnaryOperatorCS_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2554:28: (this_EssentialOCLUnaryOperatorCS_0= ruleEssentialOCLUnaryOperatorCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2556:2: this_EssentialOCLUnaryOperatorCS_0= ruleEssentialOCLUnaryOperatorCS
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getUnaryOperatorCSAccess().getEssentialOCLUnaryOperatorCSParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLUnaryOperatorCS_in_ruleUnaryOperatorCS5733);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2575:1: entryRuleEssentialOCLUnrestrictedName returns [String current=null] : iv_ruleEssentialOCLUnrestrictedName= ruleEssentialOCLUnrestrictedName EOF ;
    public final String entryRuleEssentialOCLUnrestrictedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEssentialOCLUnrestrictedName = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2576:2: (iv_ruleEssentialOCLUnrestrictedName= ruleEssentialOCLUnrestrictedName EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2577:2: iv_ruleEssentialOCLUnrestrictedName= ruleEssentialOCLUnrestrictedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEssentialOCLUnrestrictedNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLUnrestrictedName_in_entryRuleEssentialOCLUnrestrictedName5768);
            iv_ruleEssentialOCLUnrestrictedName=ruleEssentialOCLUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEssentialOCLUnrestrictedName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEssentialOCLUnrestrictedName5779); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2584:1: ruleEssentialOCLUnrestrictedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_Identifier_0= ruleIdentifier ;
    public final AntlrDatatypeRuleToken ruleEssentialOCLUnrestrictedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_Identifier_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2587:28: (this_Identifier_0= ruleIdentifier )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2589:5: this_Identifier_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getEssentialOCLUnrestrictedNameAccess().getIdentifierParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_ruleEssentialOCLUnrestrictedName5825);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2607:1: entryRuleEssentialOCLUnreservedName returns [String current=null] : iv_ruleEssentialOCLUnreservedName= ruleEssentialOCLUnreservedName EOF ;
    public final String entryRuleEssentialOCLUnreservedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEssentialOCLUnreservedName = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2608:2: (iv_ruleEssentialOCLUnreservedName= ruleEssentialOCLUnreservedName EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2609:2: iv_ruleEssentialOCLUnreservedName= ruleEssentialOCLUnreservedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEssentialOCLUnreservedNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLUnreservedName_in_entryRuleEssentialOCLUnreservedName5870);
            iv_ruleEssentialOCLUnreservedName=ruleEssentialOCLUnreservedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEssentialOCLUnreservedName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEssentialOCLUnreservedName5881); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2616:1: ruleEssentialOCLUnreservedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_UnrestrictedName_0= ruleUnrestrictedName | this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier | this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier | kw= 'Tuple' ) ;
    public final AntlrDatatypeRuleToken ruleEssentialOCLUnreservedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_UnrestrictedName_0 = null;

        AntlrDatatypeRuleToken this_CollectionTypeIdentifier_1 = null;

        AntlrDatatypeRuleToken this_PrimitiveTypeIdentifier_2 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2619:28: ( (this_UnrestrictedName_0= ruleUnrestrictedName | this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier | this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier | kw= 'Tuple' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2620:1: (this_UnrestrictedName_0= ruleUnrestrictedName | this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier | this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier | kw= 'Tuple' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2620:1: (this_UnrestrictedName_0= ruleUnrestrictedName | this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier | this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier | kw= 'Tuple' )
            int alt43=4;
            switch ( input.LA(1) ) {
            case RULE_SIMPLE_ID:
            case RULE_ESCAPED_ID:
            case 16:
            case 27:
            case 28:
            case 31:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2621:5: this_UnrestrictedName_0= ruleUnrestrictedName
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getEssentialOCLUnreservedNameAccess().getUnrestrictedNameParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleEssentialOCLUnreservedName5928);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2633:5: this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getEssentialOCLUnreservedNameAccess().getCollectionTypeIdentifierParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCollectionTypeIdentifier_in_ruleEssentialOCLUnreservedName5961);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2645:5: this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getEssentialOCLUnreservedNameAccess().getPrimitiveTypeIdentifierParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrimitiveTypeIdentifier_in_ruleEssentialOCLUnreservedName5994);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2657:2: kw= 'Tuple'
                    {
                    kw=(Token)match(input,57,FollowSets000.FOLLOW_57_in_ruleEssentialOCLUnreservedName6018); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2670:1: entryRuleUnreservedName returns [String current=null] : iv_ruleUnreservedName= ruleUnreservedName EOF ;
    public final String entryRuleUnreservedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnreservedName = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2671:2: (iv_ruleUnreservedName= ruleUnreservedName EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2672:2: iv_ruleUnreservedName= ruleUnreservedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnreservedNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnreservedName_in_entryRuleUnreservedName6059);
            iv_ruleUnreservedName=ruleUnreservedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnreservedName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnreservedName6070); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2679:1: ruleUnreservedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_EssentialOCLUnreservedName_0= ruleEssentialOCLUnreservedName ;
    public final AntlrDatatypeRuleToken ruleUnreservedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_EssentialOCLUnreservedName_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2682:28: (this_EssentialOCLUnreservedName_0= ruleEssentialOCLUnreservedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2684:5: this_EssentialOCLUnreservedName_0= ruleEssentialOCLUnreservedName
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getUnreservedNameAccess().getEssentialOCLUnreservedNameParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLUnreservedName_in_ruleUnreservedName6116);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2702:1: entryRulePathNameCS returns [EObject current=null] : iv_rulePathNameCS= rulePathNameCS EOF ;
    public final EObject entryRulePathNameCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePathNameCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2703:2: (iv_rulePathNameCS= rulePathNameCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2704:2: iv_rulePathNameCS= rulePathNameCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPathNameCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePathNameCS_in_entryRulePathNameCS6160);
            iv_rulePathNameCS=rulePathNameCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePathNameCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePathNameCS6170); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2711:1: rulePathNameCS returns [EObject current=null] : ( ( (lv_path_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )* ) ;
    public final EObject rulePathNameCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_path_0_0 = null;

        EObject lv_path_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2714:28: ( ( ( (lv_path_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )* ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2715:1: ( ( (lv_path_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )* )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2715:1: ( ( (lv_path_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )* )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2715:2: ( (lv_path_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )*
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2715:2: ( (lv_path_0_0= ruleFirstPathElementCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2716:1: (lv_path_0_0= ruleFirstPathElementCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2716:1: (lv_path_0_0= ruleFirstPathElementCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2717:3: lv_path_0_0= ruleFirstPathElementCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPathNameCSAccess().getPathFirstPathElementCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleFirstPathElementCS_in_rulePathNameCS6216);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2733:2: (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==33) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2733:4: otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) )
            	    {
            	    otherlv_1=(Token)match(input,33,FollowSets000.FOLLOW_33_in_rulePathNameCS6229); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getPathNameCSAccess().getColonColonKeyword_1_0());
            	          
            	    }
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2737:1: ( (lv_path_2_0= ruleNextPathElementCS ) )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2738:1: (lv_path_2_0= ruleNextPathElementCS )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2738:1: (lv_path_2_0= ruleNextPathElementCS )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2739:3: lv_path_2_0= ruleNextPathElementCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getPathNameCSAccess().getPathNextPathElementCSParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleNextPathElementCS_in_rulePathNameCS6250);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2763:1: entryRuleFirstPathElementCS returns [EObject current=null] : iv_ruleFirstPathElementCS= ruleFirstPathElementCS EOF ;
    public final EObject entryRuleFirstPathElementCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFirstPathElementCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2764:2: (iv_ruleFirstPathElementCS= ruleFirstPathElementCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2765:2: iv_ruleFirstPathElementCS= ruleFirstPathElementCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFirstPathElementCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleFirstPathElementCS_in_entryRuleFirstPathElementCS6288);
            iv_ruleFirstPathElementCS=ruleFirstPathElementCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFirstPathElementCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFirstPathElementCS6298); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2772:1: ruleFirstPathElementCS returns [EObject current=null] : ( ( ruleUnrestrictedName ) ) ;
    public final EObject ruleFirstPathElementCS() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2775:28: ( ( ( ruleUnrestrictedName ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2776:1: ( ( ruleUnrestrictedName ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2776:1: ( ( ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2777:1: ( ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2777:1: ( ruleUnrestrictedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2778:3: ruleUnrestrictedName
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
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleFirstPathElementCS6349);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2802:1: entryRuleNextPathElementCS returns [EObject current=null] : iv_ruleNextPathElementCS= ruleNextPathElementCS EOF ;
    public final EObject entryRuleNextPathElementCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNextPathElementCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2803:2: (iv_ruleNextPathElementCS= ruleNextPathElementCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2804:2: iv_ruleNextPathElementCS= ruleNextPathElementCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNextPathElementCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNextPathElementCS_in_entryRuleNextPathElementCS6384);
            iv_ruleNextPathElementCS=ruleNextPathElementCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNextPathElementCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNextPathElementCS6394); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2811:1: ruleNextPathElementCS returns [EObject current=null] : ( ( ruleUnreservedName ) ) ;
    public final EObject ruleNextPathElementCS() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2814:28: ( ( ( ruleUnreservedName ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2815:1: ( ( ruleUnreservedName ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2815:1: ( ( ruleUnreservedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2816:1: ( ruleUnreservedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2816:1: ( ruleUnreservedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2817:3: ruleUnreservedName
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
            pushFollow(FollowSets000.FOLLOW_ruleUnreservedName_in_ruleNextPathElementCS6445);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2841:1: entryRuleURIPathNameCS returns [EObject current=null] : iv_ruleURIPathNameCS= ruleURIPathNameCS EOF ;
    public final EObject entryRuleURIPathNameCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleURIPathNameCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2842:2: (iv_ruleURIPathNameCS= ruleURIPathNameCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2843:2: iv_ruleURIPathNameCS= ruleURIPathNameCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getURIPathNameCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleURIPathNameCS_in_entryRuleURIPathNameCS6480);
            iv_ruleURIPathNameCS=ruleURIPathNameCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleURIPathNameCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleURIPathNameCS6490); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2850:1: ruleURIPathNameCS returns [EObject current=null] : ( ( (lv_path_0_0= ruleURIFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )* ) ;
    public final EObject ruleURIPathNameCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_path_0_0 = null;

        EObject lv_path_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2853:28: ( ( ( (lv_path_0_0= ruleURIFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )* ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2854:1: ( ( (lv_path_0_0= ruleURIFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )* )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2854:1: ( ( (lv_path_0_0= ruleURIFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )* )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2854:2: ( (lv_path_0_0= ruleURIFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )*
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2854:2: ( (lv_path_0_0= ruleURIFirstPathElementCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2855:1: (lv_path_0_0= ruleURIFirstPathElementCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2855:1: (lv_path_0_0= ruleURIFirstPathElementCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2856:3: lv_path_0_0= ruleURIFirstPathElementCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getURIPathNameCSAccess().getPathURIFirstPathElementCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleURIFirstPathElementCS_in_ruleURIPathNameCS6536);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2872:2: (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==33) ) {
                    int LA45_1 = input.LA(2);

                    if ( ((LA45_1>=RULE_SIMPLE_ID && LA45_1<=RULE_ESCAPED_ID)||LA45_1==16||(LA45_1>=27 && LA45_1<=28)||LA45_1==31||(LA45_1>=35 && LA45_1<=41)||(LA45_1>=57 && LA45_1<=70)) ) {
                        alt45=1;
                    }


                }


                switch (alt45) {
            	case 1 :
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2872:4: otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) )
            	    {
            	    otherlv_1=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleURIPathNameCS6549); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getURIPathNameCSAccess().getColonColonKeyword_1_0());
            	          
            	    }
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2876:1: ( (lv_path_2_0= ruleNextPathElementCS ) )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2877:1: (lv_path_2_0= ruleNextPathElementCS )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2877:1: (lv_path_2_0= ruleNextPathElementCS )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2878:3: lv_path_2_0= ruleNextPathElementCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getURIPathNameCSAccess().getPathNextPathElementCSParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleNextPathElementCS_in_ruleURIPathNameCS6570);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2902:1: entryRuleURIFirstPathElementCS returns [EObject current=null] : iv_ruleURIFirstPathElementCS= ruleURIFirstPathElementCS EOF ;
    public final EObject entryRuleURIFirstPathElementCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleURIFirstPathElementCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2903:2: (iv_ruleURIFirstPathElementCS= ruleURIFirstPathElementCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2904:2: iv_ruleURIFirstPathElementCS= ruleURIFirstPathElementCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getURIFirstPathElementCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleURIFirstPathElementCS_in_entryRuleURIFirstPathElementCS6608);
            iv_ruleURIFirstPathElementCS=ruleURIFirstPathElementCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleURIFirstPathElementCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleURIFirstPathElementCS6618); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2911:1: ruleURIFirstPathElementCS returns [EObject current=null] : ( ( ( ruleUnrestrictedName ) ) | ( () ( ( ruleURI ) ) ) ) ;
    public final EObject ruleURIFirstPathElementCS() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2914:28: ( ( ( ( ruleUnrestrictedName ) ) | ( () ( ( ruleURI ) ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2915:1: ( ( ( ruleUnrestrictedName ) ) | ( () ( ( ruleURI ) ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2915:1: ( ( ( ruleUnrestrictedName ) ) | ( () ( ( ruleURI ) ) ) )
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( ((LA46_0>=RULE_SIMPLE_ID && LA46_0<=RULE_ESCAPED_ID)||LA46_0==16||(LA46_0>=27 && LA46_0<=28)||LA46_0==31||(LA46_0>=35 && LA46_0<=41)) ) {
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2915:2: ( ( ruleUnrestrictedName ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2915:2: ( ( ruleUnrestrictedName ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2916:1: ( ruleUnrestrictedName )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2916:1: ( ruleUnrestrictedName )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2917:3: ruleUnrestrictedName
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
                    pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleURIFirstPathElementCS6670);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2934:6: ( () ( ( ruleURI ) ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2934:6: ( () ( ( ruleURI ) ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2934:7: () ( ( ruleURI ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2934:7: ()
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2935:2: 
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

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2943:2: ( ( ruleURI ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2944:1: ( ruleURI )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2944:1: ( ruleURI )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2945:3: ruleURI
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
                    pushFollow(FollowSets000.FOLLOW_ruleURI_in_ruleURIFirstPathElementCS6716);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2969:1: entryRulePrimitiveTypeIdentifier returns [String current=null] : iv_rulePrimitiveTypeIdentifier= rulePrimitiveTypeIdentifier EOF ;
    public final String entryRulePrimitiveTypeIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePrimitiveTypeIdentifier = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2970:2: (iv_rulePrimitiveTypeIdentifier= rulePrimitiveTypeIdentifier EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2971:2: iv_rulePrimitiveTypeIdentifier= rulePrimitiveTypeIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimitiveTypeIdentifierRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePrimitiveTypeIdentifier_in_entryRulePrimitiveTypeIdentifier6754);
            iv_rulePrimitiveTypeIdentifier=rulePrimitiveTypeIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimitiveTypeIdentifier.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrimitiveTypeIdentifier6765); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2978:1: rulePrimitiveTypeIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Boolean' | kw= 'Integer' | kw= 'Real' | kw= 'String' | kw= 'UnlimitedNatural' | kw= 'OclAny' | kw= 'OclInvalid' | kw= 'OclVoid' ) ;
    public final AntlrDatatypeRuleToken rulePrimitiveTypeIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2981:28: ( (kw= 'Boolean' | kw= 'Integer' | kw= 'Real' | kw= 'String' | kw= 'UnlimitedNatural' | kw= 'OclAny' | kw= 'OclInvalid' | kw= 'OclVoid' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2982:1: (kw= 'Boolean' | kw= 'Integer' | kw= 'Real' | kw= 'String' | kw= 'UnlimitedNatural' | kw= 'OclAny' | kw= 'OclInvalid' | kw= 'OclVoid' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2982:1: (kw= 'Boolean' | kw= 'Integer' | kw= 'Real' | kw= 'String' | kw= 'UnlimitedNatural' | kw= 'OclAny' | kw= 'OclInvalid' | kw= 'OclVoid' )
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2983:2: kw= 'Boolean'
                    {
                    kw=(Token)match(input,58,FollowSets000.FOLLOW_58_in_rulePrimitiveTypeIdentifier6803); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getBooleanKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2990:2: kw= 'Integer'
                    {
                    kw=(Token)match(input,59,FollowSets000.FOLLOW_59_in_rulePrimitiveTypeIdentifier6822); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getIntegerKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:2997:2: kw= 'Real'
                    {
                    kw=(Token)match(input,60,FollowSets000.FOLLOW_60_in_rulePrimitiveTypeIdentifier6841); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getRealKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3004:2: kw= 'String'
                    {
                    kw=(Token)match(input,61,FollowSets000.FOLLOW_61_in_rulePrimitiveTypeIdentifier6860); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getStringKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3011:2: kw= 'UnlimitedNatural'
                    {
                    kw=(Token)match(input,62,FollowSets000.FOLLOW_62_in_rulePrimitiveTypeIdentifier6879); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getUnlimitedNaturalKeyword_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3018:2: kw= 'OclAny'
                    {
                    kw=(Token)match(input,63,FollowSets000.FOLLOW_63_in_rulePrimitiveTypeIdentifier6898); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getOclAnyKeyword_5()); 
                          
                    }

                    }
                    break;
                case 7 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3025:2: kw= 'OclInvalid'
                    {
                    kw=(Token)match(input,64,FollowSets000.FOLLOW_64_in_rulePrimitiveTypeIdentifier6917); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getOclInvalidKeyword_6()); 
                          
                    }

                    }
                    break;
                case 8 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3032:2: kw= 'OclVoid'
                    {
                    kw=(Token)match(input,65,FollowSets000.FOLLOW_65_in_rulePrimitiveTypeIdentifier6936); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3045:1: entryRulePrimitiveTypeCS returns [EObject current=null] : iv_rulePrimitiveTypeCS= rulePrimitiveTypeCS EOF ;
    public final EObject entryRulePrimitiveTypeCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveTypeCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3046:2: (iv_rulePrimitiveTypeCS= rulePrimitiveTypeCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3047:2: iv_rulePrimitiveTypeCS= rulePrimitiveTypeCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimitiveTypeCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePrimitiveTypeCS_in_entryRulePrimitiveTypeCS6976);
            iv_rulePrimitiveTypeCS=rulePrimitiveTypeCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimitiveTypeCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrimitiveTypeCS6986); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3054:1: rulePrimitiveTypeCS returns [EObject current=null] : ( (lv_name_0_0= rulePrimitiveTypeIdentifier ) ) ;
    public final EObject rulePrimitiveTypeCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3057:28: ( ( (lv_name_0_0= rulePrimitiveTypeIdentifier ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3058:1: ( (lv_name_0_0= rulePrimitiveTypeIdentifier ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3058:1: ( (lv_name_0_0= rulePrimitiveTypeIdentifier ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3059:1: (lv_name_0_0= rulePrimitiveTypeIdentifier )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3059:1: (lv_name_0_0= rulePrimitiveTypeIdentifier )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3060:3: lv_name_0_0= rulePrimitiveTypeIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPrimitiveTypeCSAccess().getNamePrimitiveTypeIdentifierParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_rulePrimitiveTypeIdentifier_in_rulePrimitiveTypeCS7031);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3084:1: entryRuleCollectionTypeIdentifier returns [String current=null] : iv_ruleCollectionTypeIdentifier= ruleCollectionTypeIdentifier EOF ;
    public final String entryRuleCollectionTypeIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleCollectionTypeIdentifier = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3085:2: (iv_ruleCollectionTypeIdentifier= ruleCollectionTypeIdentifier EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3086:2: iv_ruleCollectionTypeIdentifier= ruleCollectionTypeIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCollectionTypeIdentifierRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleCollectionTypeIdentifier_in_entryRuleCollectionTypeIdentifier7067);
            iv_ruleCollectionTypeIdentifier=ruleCollectionTypeIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCollectionTypeIdentifier.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCollectionTypeIdentifier7078); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3093:1: ruleCollectionTypeIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Set' | kw= 'Bag' | kw= 'Sequence' | kw= 'Collection' | kw= 'OrderedSet' ) ;
    public final AntlrDatatypeRuleToken ruleCollectionTypeIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3096:28: ( (kw= 'Set' | kw= 'Bag' | kw= 'Sequence' | kw= 'Collection' | kw= 'OrderedSet' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3097:1: (kw= 'Set' | kw= 'Bag' | kw= 'Sequence' | kw= 'Collection' | kw= 'OrderedSet' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3097:1: (kw= 'Set' | kw= 'Bag' | kw= 'Sequence' | kw= 'Collection' | kw= 'OrderedSet' )
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3098:2: kw= 'Set'
                    {
                    kw=(Token)match(input,66,FollowSets000.FOLLOW_66_in_ruleCollectionTypeIdentifier7116); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getSetKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3105:2: kw= 'Bag'
                    {
                    kw=(Token)match(input,67,FollowSets000.FOLLOW_67_in_ruleCollectionTypeIdentifier7135); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getBagKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3112:2: kw= 'Sequence'
                    {
                    kw=(Token)match(input,68,FollowSets000.FOLLOW_68_in_ruleCollectionTypeIdentifier7154); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getSequenceKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3119:2: kw= 'Collection'
                    {
                    kw=(Token)match(input,69,FollowSets000.FOLLOW_69_in_ruleCollectionTypeIdentifier7173); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getCollectionKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3126:2: kw= 'OrderedSet'
                    {
                    kw=(Token)match(input,70,FollowSets000.FOLLOW_70_in_ruleCollectionTypeIdentifier7192); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3139:1: entryRuleCollectionTypeCS returns [EObject current=null] : iv_ruleCollectionTypeCS= ruleCollectionTypeCS EOF ;
    public final EObject entryRuleCollectionTypeCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionTypeCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3140:2: (iv_ruleCollectionTypeCS= ruleCollectionTypeCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3141:2: iv_ruleCollectionTypeCS= ruleCollectionTypeCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCollectionTypeCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleCollectionTypeCS_in_entryRuleCollectionTypeCS7232);
            iv_ruleCollectionTypeCS=ruleCollectionTypeCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCollectionTypeCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCollectionTypeCS7242); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3148:1: ruleCollectionTypeCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )? ) ;
    public final EObject ruleCollectionTypeCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3151:28: ( ( ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3152:1: ( ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3152:1: ( ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3152:2: ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )?
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3152:2: ( (lv_name_0_0= ruleCollectionTypeIdentifier ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3153:1: (lv_name_0_0= ruleCollectionTypeIdentifier )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3153:1: (lv_name_0_0= ruleCollectionTypeIdentifier )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3154:3: lv_name_0_0= ruleCollectionTypeIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCollectionTypeCSAccess().getNameCollectionTypeIdentifierParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleCollectionTypeIdentifier_in_ruleCollectionTypeCS7288);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3170:2: (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==29) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3170:4: otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleCollectionTypeCS7301); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getCollectionTypeCSAccess().getLeftParenthesisKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3174:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3175:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3175:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3176:3: lv_ownedType_2_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionTypeCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleCollectionTypeCS7322);
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

                    otherlv_3=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleCollectionTypeCS7334); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3204:1: entryRuleMultiplicityBoundsCS returns [EObject current=null] : iv_ruleMultiplicityBoundsCS= ruleMultiplicityBoundsCS EOF ;
    public final EObject entryRuleMultiplicityBoundsCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicityBoundsCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3205:2: (iv_ruleMultiplicityBoundsCS= ruleMultiplicityBoundsCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3206:2: iv_ruleMultiplicityBoundsCS= ruleMultiplicityBoundsCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicityBoundsCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMultiplicityBoundsCS_in_entryRuleMultiplicityBoundsCS7372);
            iv_ruleMultiplicityBoundsCS=ruleMultiplicityBoundsCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicityBoundsCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMultiplicityBoundsCS7382); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3213:1: ruleMultiplicityBoundsCS returns [EObject current=null] : ( ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )? ) ;
    public final EObject ruleMultiplicityBoundsCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_lowerBound_0_0 = null;

        AntlrDatatypeRuleToken lv_upperBound_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3216:28: ( ( ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3217:1: ( ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3217:1: ( ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3217:2: ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )?
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3217:2: ( (lv_lowerBound_0_0= ruleLOWER ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3218:1: (lv_lowerBound_0_0= ruleLOWER )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3218:1: (lv_lowerBound_0_0= ruleLOWER )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3219:3: lv_lowerBound_0_0= ruleLOWER
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiplicityBoundsCSAccess().getLowerBoundLOWERParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleLOWER_in_ruleMultiplicityBoundsCS7428);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3235:2: (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==71) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3235:4: otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) )
                    {
                    otherlv_1=(Token)match(input,71,FollowSets000.FOLLOW_71_in_ruleMultiplicityBoundsCS7441); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getMultiplicityBoundsCSAccess().getFullStopFullStopKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3239:1: ( (lv_upperBound_2_0= ruleUPPER ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3240:1: (lv_upperBound_2_0= ruleUPPER )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3240:1: (lv_upperBound_2_0= ruleUPPER )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3241:3: lv_upperBound_2_0= ruleUPPER
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMultiplicityBoundsCSAccess().getUpperBoundUPPERParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUPPER_in_ruleMultiplicityBoundsCS7462);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3265:1: entryRuleMultiplicityCS returns [EObject current=null] : iv_ruleMultiplicityCS= ruleMultiplicityCS EOF ;
    public final EObject entryRuleMultiplicityCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicityCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3266:2: (iv_ruleMultiplicityCS= ruleMultiplicityCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3267:2: iv_ruleMultiplicityCS= ruleMultiplicityCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicityCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMultiplicityCS_in_entryRuleMultiplicityCS7500);
            iv_ruleMultiplicityCS=ruleMultiplicityCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicityCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMultiplicityCS7510); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3274:1: ruleMultiplicityCS returns [EObject current=null] : (otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) otherlv_3= ']' ) ;
    public final EObject ruleMultiplicityCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        EObject this_MultiplicityBoundsCS_1 = null;

        EObject this_MultiplicityStringCS_2 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3277:28: ( (otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) otherlv_3= ']' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3278:1: (otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) otherlv_3= ']' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3278:1: (otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) otherlv_3= ']' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3278:3: otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) otherlv_3= ']'
            {
            otherlv_0=(Token)match(input,72,FollowSets000.FOLLOW_72_in_ruleMultiplicityCS7547); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMultiplicityCSAccess().getLeftSquareBracketKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3282:1: (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS )
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==RULE_INT) ) {
                alt51=1;
            }
            else if ( (LA51_0==34||LA51_0==45||LA51_0==74) ) {
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3283:2: this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getMultiplicityCSAccess().getMultiplicityBoundsCSParserRuleCall_1_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMultiplicityBoundsCS_in_ruleMultiplicityCS7573);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3296:2: this_MultiplicityStringCS_2= ruleMultiplicityStringCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getMultiplicityCSAccess().getMultiplicityStringCSParserRuleCall_1_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMultiplicityStringCS_in_ruleMultiplicityCS7603);
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

            otherlv_3=(Token)match(input,73,FollowSets000.FOLLOW_73_in_ruleMultiplicityCS7615); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3319:1: entryRuleMultiplicityStringCS returns [EObject current=null] : iv_ruleMultiplicityStringCS= ruleMultiplicityStringCS EOF ;
    public final EObject entryRuleMultiplicityStringCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicityStringCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3320:2: (iv_ruleMultiplicityStringCS= ruleMultiplicityStringCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3321:2: iv_ruleMultiplicityStringCS= ruleMultiplicityStringCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicityStringCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMultiplicityStringCS_in_entryRuleMultiplicityStringCS7651);
            iv_ruleMultiplicityStringCS=ruleMultiplicityStringCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicityStringCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMultiplicityStringCS7661); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3328:1: ruleMultiplicityStringCS returns [EObject current=null] : ( ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) ) ) ;
    public final EObject ruleMultiplicityStringCS() throws RecognitionException {
        EObject current = null;

        Token lv_stringBounds_0_1=null;
        Token lv_stringBounds_0_2=null;
        Token lv_stringBounds_0_3=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3331:28: ( ( ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3332:1: ( ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3332:1: ( ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3333:1: ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3333:1: ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3334:1: (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3334:1: (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' )
            int alt52=3;
            switch ( input.LA(1) ) {
            case 34:
                {
                alt52=1;
                }
                break;
            case 45:
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3335:3: lv_stringBounds_0_1= '*'
                    {
                    lv_stringBounds_0_1=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleMultiplicityStringCS7705); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3347:8: lv_stringBounds_0_2= '+'
                    {
                    lv_stringBounds_0_2=(Token)match(input,45,FollowSets000.FOLLOW_45_in_ruleMultiplicityStringCS7734); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3359:8: lv_stringBounds_0_3= '?'
                    {
                    lv_stringBounds_0_3=(Token)match(input,74,FollowSets000.FOLLOW_74_in_ruleMultiplicityStringCS7763); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3382:1: entryRuleTupleTypeCS returns [EObject current=null] : iv_ruleTupleTypeCS= ruleTupleTypeCS EOF ;
    public final EObject entryRuleTupleTypeCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTupleTypeCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3383:2: (iv_ruleTupleTypeCS= ruleTupleTypeCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3384:2: iv_ruleTupleTypeCS= ruleTupleTypeCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTupleTypeCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTupleTypeCS_in_entryRuleTupleTypeCS7814);
            iv_ruleTupleTypeCS=ruleTupleTypeCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTupleTypeCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTupleTypeCS7824); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3391:1: ruleTupleTypeCS returns [EObject current=null] : ( ( (lv_name_0_0= 'Tuple' ) ) (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )? ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3394:28: ( ( ( (lv_name_0_0= 'Tuple' ) ) (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3395:1: ( ( (lv_name_0_0= 'Tuple' ) ) (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3395:1: ( ( (lv_name_0_0= 'Tuple' ) ) (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3395:2: ( (lv_name_0_0= 'Tuple' ) ) (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )?
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3395:2: ( (lv_name_0_0= 'Tuple' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3396:1: (lv_name_0_0= 'Tuple' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3396:1: (lv_name_0_0= 'Tuple' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3397:3: lv_name_0_0= 'Tuple'
            {
            lv_name_0_0=(Token)match(input,57,FollowSets000.FOLLOW_57_in_ruleTupleTypeCS7867); if (state.failed) return current;
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3410:2: (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==29) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3410:4: otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')'
                    {
                    otherlv_1=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleTupleTypeCS7893); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getTupleTypeCSAccess().getLeftParenthesisKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3414:1: ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )?
                    int alt54=2;
                    int LA54_0 = input.LA(1);

                    if ( ((LA54_0>=RULE_SIMPLE_ID && LA54_0<=RULE_ESCAPED_ID)||LA54_0==16||(LA54_0>=27 && LA54_0<=28)||LA54_0==31||(LA54_0>=35 && LA54_0<=41)) ) {
                        alt54=1;
                    }
                    switch (alt54) {
                        case 1 :
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3414:2: ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )*
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3414:2: ( (lv_ownedParts_2_0= ruleTuplePartCS ) )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3415:1: (lv_ownedParts_2_0= ruleTuplePartCS )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3415:1: (lv_ownedParts_2_0= ruleTuplePartCS )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3416:3: lv_ownedParts_2_0= ruleTuplePartCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getTupleTypeCSAccess().getOwnedPartsTuplePartCSParserRuleCall_1_1_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleTuplePartCS_in_ruleTupleTypeCS7915);
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

                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3432:2: (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )*
                            loop53:
                            do {
                                int alt53=2;
                                int LA53_0 = input.LA(1);

                                if ( (LA53_0==24) ) {
                                    alt53=1;
                                }


                                switch (alt53) {
                            	case 1 :
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3432:4: otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) )
                            	    {
                            	    otherlv_3=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleTupleTypeCS7928); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_3, grammarAccess.getTupleTypeCSAccess().getCommaKeyword_1_1_1_0());
                            	          
                            	    }
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3436:1: ( (lv_ownedParts_4_0= ruleTuplePartCS ) )
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3437:1: (lv_ownedParts_4_0= ruleTuplePartCS )
                            	    {
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3437:1: (lv_ownedParts_4_0= ruleTuplePartCS )
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3438:3: lv_ownedParts_4_0= ruleTuplePartCS
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getTupleTypeCSAccess().getOwnedPartsTuplePartCSParserRuleCall_1_1_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FollowSets000.FOLLOW_ruleTuplePartCS_in_ruleTupleTypeCS7949);
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

                    otherlv_5=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleTupleTypeCS7965); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3466:1: entryRuleTuplePartCS returns [EObject current=null] : iv_ruleTuplePartCS= ruleTuplePartCS EOF ;
    public final EObject entryRuleTuplePartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTuplePartCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3467:2: (iv_ruleTuplePartCS= ruleTuplePartCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3468:2: iv_ruleTuplePartCS= ruleTuplePartCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTuplePartCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTuplePartCS_in_entryRuleTuplePartCS8003);
            iv_ruleTuplePartCS=ruleTuplePartCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTuplePartCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTuplePartCS8013); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3475:1: ruleTuplePartCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) ) ;
    public final EObject ruleTuplePartCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3478:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3479:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3479:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3479:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3479:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3480:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3480:1: (lv_name_0_0= ruleUnrestrictedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3481:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTuplePartCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleTuplePartCS8059);
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

            otherlv_1=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleTuplePartCS8071); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getTuplePartCSAccess().getColonKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3501:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3502:1: (lv_ownedType_2_0= ruleTypeExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3502:1: (lv_ownedType_2_0= ruleTypeExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3503:3: lv_ownedType_2_0= ruleTypeExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTuplePartCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleTuplePartCS8092);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3527:1: entryRuleCollectionLiteralExpCS returns [EObject current=null] : iv_ruleCollectionLiteralExpCS= ruleCollectionLiteralExpCS EOF ;
    public final EObject entryRuleCollectionLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3528:2: (iv_ruleCollectionLiteralExpCS= ruleCollectionLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3529:2: iv_ruleCollectionLiteralExpCS= ruleCollectionLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCollectionLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteralExpCS_in_entryRuleCollectionLiteralExpCS8128);
            iv_ruleCollectionLiteralExpCS=ruleCollectionLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCollectionLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCollectionLiteralExpCS8138); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3536:1: ruleCollectionLiteralExpCS returns [EObject current=null] : ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}' ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3539:28: ( ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3540:1: ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3540:1: ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3540:2: ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}'
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3540:2: ( (lv_ownedType_0_0= ruleCollectionTypeCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3541:1: (lv_ownedType_0_0= ruleCollectionTypeCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3541:1: (lv_ownedType_0_0= ruleCollectionTypeCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3542:3: lv_ownedType_0_0= ruleCollectionTypeCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedTypeCollectionTypeCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleCollectionTypeCS_in_ruleCollectionLiteralExpCS8184);
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

            otherlv_1=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleCollectionLiteralExpCS8196); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getCollectionLiteralExpCSAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3562:1: ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( ((LA57_0>=RULE_SIMPLE_ID && LA57_0<=RULE_SINGLE_QUOTED_STRING)||LA57_0==16||(LA57_0>=27 && LA57_0<=29)||LA57_0==31||(LA57_0>=34 && LA57_0<=43)||(LA57_0>=57 && LA57_0<=70)||(LA57_0>=75 && LA57_0<=78)||LA57_0==81||(LA57_0>=85 && LA57_0<=86)) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3562:2: ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )*
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3562:2: ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3563:1: (lv_ownedParts_2_0= ruleCollectionLiteralPartCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3563:1: (lv_ownedParts_2_0= ruleCollectionLiteralPartCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3564:3: lv_ownedParts_2_0= ruleCollectionLiteralPartCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedPartsCollectionLiteralPartCSParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteralPartCS_in_ruleCollectionLiteralExpCS8218);
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

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3580:2: (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )*
                    loop56:
                    do {
                        int alt56=2;
                        int LA56_0 = input.LA(1);

                        if ( (LA56_0==24) ) {
                            alt56=1;
                        }


                        switch (alt56) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3580:4: otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) )
                    	    {
                    	    otherlv_3=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleCollectionLiteralExpCS8231); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getCollectionLiteralExpCSAccess().getCommaKeyword_2_1_0());
                    	          
                    	    }
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3584:1: ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3585:1: (lv_ownedParts_4_0= ruleCollectionLiteralPartCS )
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3585:1: (lv_ownedParts_4_0= ruleCollectionLiteralPartCS )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3586:3: lv_ownedParts_4_0= ruleCollectionLiteralPartCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedPartsCollectionLiteralPartCSParserRuleCall_2_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteralPartCS_in_ruleCollectionLiteralExpCS8252);
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

            otherlv_5=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleCollectionLiteralExpCS8268); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3614:1: entryRuleCollectionLiteralPartCS returns [EObject current=null] : iv_ruleCollectionLiteralPartCS= ruleCollectionLiteralPartCS EOF ;
    public final EObject entryRuleCollectionLiteralPartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionLiteralPartCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3615:2: (iv_ruleCollectionLiteralPartCS= ruleCollectionLiteralPartCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3616:2: iv_ruleCollectionLiteralPartCS= ruleCollectionLiteralPartCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCollectionLiteralPartCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteralPartCS_in_entryRuleCollectionLiteralPartCS8304);
            iv_ruleCollectionLiteralPartCS=ruleCollectionLiteralPartCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCollectionLiteralPartCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCollectionLiteralPartCS8314); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3623:1: ruleCollectionLiteralPartCS returns [EObject current=null] : ( ( (lv_expressionCS_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_lastExpressionCS_2_0= ruleExpCS ) ) )? ) ;
    public final EObject ruleCollectionLiteralPartCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expressionCS_0_0 = null;

        EObject lv_lastExpressionCS_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3626:28: ( ( ( (lv_expressionCS_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_lastExpressionCS_2_0= ruleExpCS ) ) )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3627:1: ( ( (lv_expressionCS_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_lastExpressionCS_2_0= ruleExpCS ) ) )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3627:1: ( ( (lv_expressionCS_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_lastExpressionCS_2_0= ruleExpCS ) ) )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3627:2: ( (lv_expressionCS_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_lastExpressionCS_2_0= ruleExpCS ) ) )?
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3627:2: ( (lv_expressionCS_0_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3628:1: (lv_expressionCS_0_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3628:1: (lv_expressionCS_0_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3629:3: lv_expressionCS_0_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCollectionLiteralPartCSAccess().getExpressionCSExpCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleCollectionLiteralPartCS8360);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3645:2: (otherlv_1= '..' ( (lv_lastExpressionCS_2_0= ruleExpCS ) ) )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==71) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3645:4: otherlv_1= '..' ( (lv_lastExpressionCS_2_0= ruleExpCS ) )
                    {
                    otherlv_1=(Token)match(input,71,FollowSets000.FOLLOW_71_in_ruleCollectionLiteralPartCS8373); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getCollectionLiteralPartCSAccess().getFullStopFullStopKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3649:1: ( (lv_lastExpressionCS_2_0= ruleExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3650:1: (lv_lastExpressionCS_2_0= ruleExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3650:1: (lv_lastExpressionCS_2_0= ruleExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3651:3: lv_lastExpressionCS_2_0= ruleExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionLiteralPartCSAccess().getLastExpressionCSExpCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleCollectionLiteralPartCS8394);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3675:1: entryRuleConstructorPartCS returns [EObject current=null] : iv_ruleConstructorPartCS= ruleConstructorPartCS EOF ;
    public final EObject entryRuleConstructorPartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstructorPartCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3676:2: (iv_ruleConstructorPartCS= ruleConstructorPartCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3677:2: iv_ruleConstructorPartCS= ruleConstructorPartCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstructorPartCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleConstructorPartCS_in_entryRuleConstructorPartCS8432);
            iv_ruleConstructorPartCS=ruleConstructorPartCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConstructorPartCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleConstructorPartCS8442); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3684:1: ruleConstructorPartCS returns [EObject current=null] : ( ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( (lv_initExpression_2_0= ruleExpCS ) ) ) ;
    public final EObject ruleConstructorPartCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_initExpression_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3687:28: ( ( ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( (lv_initExpression_2_0= ruleExpCS ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3688:1: ( ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( (lv_initExpression_2_0= ruleExpCS ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3688:1: ( ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( (lv_initExpression_2_0= ruleExpCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3688:2: ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( (lv_initExpression_2_0= ruleExpCS ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3688:2: ( ( ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3689:1: ( ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3689:1: ( ruleUnrestrictedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3690:3: ruleUnrestrictedName
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
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleConstructorPartCS8494);
            ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,49,FollowSets000.FOLLOW_49_in_ruleConstructorPartCS8506); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getConstructorPartCSAccess().getEqualsSignKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3710:1: ( (lv_initExpression_2_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3711:1: (lv_initExpression_2_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3711:1: (lv_initExpression_2_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3712:3: lv_initExpression_2_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getConstructorPartCSAccess().getInitExpressionExpCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleConstructorPartCS8527);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3736:1: entryRulePrimitiveLiteralExpCS returns [EObject current=null] : iv_rulePrimitiveLiteralExpCS= rulePrimitiveLiteralExpCS EOF ;
    public final EObject entryRulePrimitiveLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3737:2: (iv_rulePrimitiveLiteralExpCS= rulePrimitiveLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3738:2: iv_rulePrimitiveLiteralExpCS= rulePrimitiveLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePrimitiveLiteralExpCS_in_entryRulePrimitiveLiteralExpCS8563);
            iv_rulePrimitiveLiteralExpCS=rulePrimitiveLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimitiveLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrimitiveLiteralExpCS8573); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3745:1: rulePrimitiveLiteralExpCS returns [EObject current=null] : (this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS | this_StringLiteralExpCS_1= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_5= ruleNullLiteralExpCS ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3748:28: ( (this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS | this_StringLiteralExpCS_1= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_5= ruleNullLiteralExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3749:1: (this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS | this_StringLiteralExpCS_1= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_5= ruleNullLiteralExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3749:1: (this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS | this_StringLiteralExpCS_1= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_5= ruleNullLiteralExpCS )
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3750:2: this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getNumberLiteralExpCSParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNumberLiteralExpCS_in_rulePrimitiveLiteralExpCS8623);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3763:2: this_StringLiteralExpCS_1= ruleStringLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getStringLiteralExpCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleStringLiteralExpCS_in_rulePrimitiveLiteralExpCS8653);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3776:2: this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getBooleanLiteralExpCSParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleBooleanLiteralExpCS_in_rulePrimitiveLiteralExpCS8683);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3789:2: this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getUnlimitedNaturalLiteralExpCSParserRuleCall_3()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUnlimitedNaturalLiteralExpCS_in_rulePrimitiveLiteralExpCS8713);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3802:2: this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getInvalidLiteralExpCSParserRuleCall_4()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleInvalidLiteralExpCS_in_rulePrimitiveLiteralExpCS8743);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3815:2: this_NullLiteralExpCS_5= ruleNullLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getNullLiteralExpCSParserRuleCall_5()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNullLiteralExpCS_in_rulePrimitiveLiteralExpCS8773);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3834:1: entryRuleTupleLiteralExpCS returns [EObject current=null] : iv_ruleTupleLiteralExpCS= ruleTupleLiteralExpCS EOF ;
    public final EObject entryRuleTupleLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTupleLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3835:2: (iv_ruleTupleLiteralExpCS= ruleTupleLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3836:2: iv_ruleTupleLiteralExpCS= ruleTupleLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTupleLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralExpCS_in_entryRuleTupleLiteralExpCS8808);
            iv_ruleTupleLiteralExpCS=ruleTupleLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTupleLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTupleLiteralExpCS8818); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3843:1: ruleTupleLiteralExpCS returns [EObject current=null] : (otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}' ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3846:28: ( (otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3847:1: (otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3847:1: (otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3847:3: otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,57,FollowSets000.FOLLOW_57_in_ruleTupleLiteralExpCS8855); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getTupleLiteralExpCSAccess().getTupleKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleTupleLiteralExpCS8867); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getTupleLiteralExpCSAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3855:1: ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3856:1: (lv_ownedParts_2_0= ruleTupleLiteralPartCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3856:1: (lv_ownedParts_2_0= ruleTupleLiteralPartCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3857:3: lv_ownedParts_2_0= ruleTupleLiteralPartCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTupleLiteralExpCSAccess().getOwnedPartsTupleLiteralPartCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralPartCS_in_ruleTupleLiteralExpCS8888);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3873:2: (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==24) ) {
                    alt60=1;
                }


                switch (alt60) {
            	case 1 :
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3873:4: otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) )
            	    {
            	    otherlv_3=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleTupleLiteralExpCS8901); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getTupleLiteralExpCSAccess().getCommaKeyword_3_0());
            	          
            	    }
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3877:1: ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3878:1: (lv_ownedParts_4_0= ruleTupleLiteralPartCS )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3878:1: (lv_ownedParts_4_0= ruleTupleLiteralPartCS )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3879:3: lv_ownedParts_4_0= ruleTupleLiteralPartCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTupleLiteralExpCSAccess().getOwnedPartsTupleLiteralPartCSParserRuleCall_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralPartCS_in_ruleTupleLiteralExpCS8922);
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

            otherlv_5=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleTupleLiteralExpCS8936); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3907:1: entryRuleTupleLiteralPartCS returns [EObject current=null] : iv_ruleTupleLiteralPartCS= ruleTupleLiteralPartCS EOF ;
    public final EObject entryRuleTupleLiteralPartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTupleLiteralPartCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3908:2: (iv_ruleTupleLiteralPartCS= ruleTupleLiteralPartCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3909:2: iv_ruleTupleLiteralPartCS= ruleTupleLiteralPartCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTupleLiteralPartCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralPartCS_in_entryRuleTupleLiteralPartCS8972);
            iv_ruleTupleLiteralPartCS=ruleTupleLiteralPartCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTupleLiteralPartCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTupleLiteralPartCS8982); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3916:1: ruleTupleLiteralPartCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) ) ) ;
    public final EObject ruleTupleLiteralPartCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;

        EObject lv_initExpression_4_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3919:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3920:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3920:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3920:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3920:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3921:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3921:1: (lv_name_0_0= ruleUnrestrictedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3922:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTupleLiteralPartCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleTupleLiteralPartCS9028);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3938:2: (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==32) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3938:4: otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                    {
                    otherlv_1=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleTupleLiteralPartCS9041); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getTupleLiteralPartCSAccess().getColonKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3942:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3943:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3943:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3944:3: lv_ownedType_2_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTupleLiteralPartCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleTupleLiteralPartCS9062);
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

            otherlv_3=(Token)match(input,49,FollowSets000.FOLLOW_49_in_ruleTupleLiteralPartCS9076); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getTupleLiteralPartCSAccess().getEqualsSignKeyword_2());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3964:1: ( (lv_initExpression_4_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3965:1: (lv_initExpression_4_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3965:1: (lv_initExpression_4_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3966:3: lv_initExpression_4_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTupleLiteralPartCSAccess().getInitExpressionExpCSParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleTupleLiteralPartCS9097);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3990:1: entryRuleNumberLiteralExpCS returns [EObject current=null] : iv_ruleNumberLiteralExpCS= ruleNumberLiteralExpCS EOF ;
    public final EObject entryRuleNumberLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3991:2: (iv_ruleNumberLiteralExpCS= ruleNumberLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3992:2: iv_ruleNumberLiteralExpCS= ruleNumberLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumberLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNumberLiteralExpCS_in_entryRuleNumberLiteralExpCS9133);
            iv_ruleNumberLiteralExpCS=ruleNumberLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumberLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNumberLiteralExpCS9143); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:3999:1: ruleNumberLiteralExpCS returns [EObject current=null] : ( (lv_name_0_0= ruleNUMBER_LITERAL ) ) ;
    public final EObject ruleNumberLiteralExpCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4002:28: ( ( (lv_name_0_0= ruleNUMBER_LITERAL ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4003:1: ( (lv_name_0_0= ruleNUMBER_LITERAL ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4003:1: ( (lv_name_0_0= ruleNUMBER_LITERAL ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4004:1: (lv_name_0_0= ruleNUMBER_LITERAL )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4004:1: (lv_name_0_0= ruleNUMBER_LITERAL )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4005:3: lv_name_0_0= ruleNUMBER_LITERAL
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNumberLiteralExpCSAccess().getNameNUMBER_LITERALParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleNUMBER_LITERAL_in_ruleNumberLiteralExpCS9188);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4029:1: entryRuleStringLiteralExpCS returns [EObject current=null] : iv_ruleStringLiteralExpCS= ruleStringLiteralExpCS EOF ;
    public final EObject entryRuleStringLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4030:2: (iv_ruleStringLiteralExpCS= ruleStringLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4031:2: iv_ruleStringLiteralExpCS= ruleStringLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStringLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleStringLiteralExpCS_in_entryRuleStringLiteralExpCS9223);
            iv_ruleStringLiteralExpCS=ruleStringLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStringLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleStringLiteralExpCS9233); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4038:1: ruleStringLiteralExpCS returns [EObject current=null] : ( (lv_name_0_0= ruleStringLiteral ) )+ ;
    public final EObject ruleStringLiteralExpCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4041:28: ( ( (lv_name_0_0= ruleStringLiteral ) )+ )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4042:1: ( (lv_name_0_0= ruleStringLiteral ) )+
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4042:1: ( (lv_name_0_0= ruleStringLiteral ) )+
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
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4043:1: (lv_name_0_0= ruleStringLiteral )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4043:1: (lv_name_0_0= ruleStringLiteral )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4044:3: lv_name_0_0= ruleStringLiteral
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getStringLiteralExpCSAccess().getNameStringLiteralParserRuleCall_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleStringLiteral_in_ruleStringLiteralExpCS9278);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4068:1: entryRuleBooleanLiteralExpCS returns [EObject current=null] : iv_ruleBooleanLiteralExpCS= ruleBooleanLiteralExpCS EOF ;
    public final EObject entryRuleBooleanLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4069:2: (iv_ruleBooleanLiteralExpCS= ruleBooleanLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4070:2: iv_ruleBooleanLiteralExpCS= ruleBooleanLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBooleanLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleBooleanLiteralExpCS_in_entryRuleBooleanLiteralExpCS9314);
            iv_ruleBooleanLiteralExpCS=ruleBooleanLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBooleanLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBooleanLiteralExpCS9324); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4077:1: ruleBooleanLiteralExpCS returns [EObject current=null] : ( ( (lv_name_0_0= 'true' ) ) | ( (lv_name_1_0= 'false' ) ) ) ;
    public final EObject ruleBooleanLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4080:28: ( ( ( (lv_name_0_0= 'true' ) ) | ( (lv_name_1_0= 'false' ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4081:1: ( ( (lv_name_0_0= 'true' ) ) | ( (lv_name_1_0= 'false' ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4081:1: ( ( (lv_name_0_0= 'true' ) ) | ( (lv_name_1_0= 'false' ) ) )
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4081:2: ( (lv_name_0_0= 'true' ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4081:2: ( (lv_name_0_0= 'true' ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4082:1: (lv_name_0_0= 'true' )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4082:1: (lv_name_0_0= 'true' )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4083:3: lv_name_0_0= 'true'
                    {
                    lv_name_0_0=(Token)match(input,75,FollowSets000.FOLLOW_75_in_ruleBooleanLiteralExpCS9367); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4097:6: ( (lv_name_1_0= 'false' ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4097:6: ( (lv_name_1_0= 'false' ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4098:1: (lv_name_1_0= 'false' )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4098:1: (lv_name_1_0= 'false' )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4099:3: lv_name_1_0= 'false'
                    {
                    lv_name_1_0=(Token)match(input,76,FollowSets000.FOLLOW_76_in_ruleBooleanLiteralExpCS9404); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4120:1: entryRuleUnlimitedNaturalLiteralExpCS returns [EObject current=null] : iv_ruleUnlimitedNaturalLiteralExpCS= ruleUnlimitedNaturalLiteralExpCS EOF ;
    public final EObject entryRuleUnlimitedNaturalLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnlimitedNaturalLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4121:2: (iv_ruleUnlimitedNaturalLiteralExpCS= ruleUnlimitedNaturalLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4122:2: iv_ruleUnlimitedNaturalLiteralExpCS= ruleUnlimitedNaturalLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnlimitedNaturalLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnlimitedNaturalLiteralExpCS_in_entryRuleUnlimitedNaturalLiteralExpCS9453);
            iv_ruleUnlimitedNaturalLiteralExpCS=ruleUnlimitedNaturalLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnlimitedNaturalLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnlimitedNaturalLiteralExpCS9463); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4129:1: ruleUnlimitedNaturalLiteralExpCS returns [EObject current=null] : ( () otherlv_1= '*' ) ;
    public final EObject ruleUnlimitedNaturalLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4132:28: ( ( () otherlv_1= '*' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4133:1: ( () otherlv_1= '*' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4133:1: ( () otherlv_1= '*' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4133:2: () otherlv_1= '*'
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4133:2: ()
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4134:2: 
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

            otherlv_1=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleUnlimitedNaturalLiteralExpCS9512); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4154:1: entryRuleInvalidLiteralExpCS returns [EObject current=null] : iv_ruleInvalidLiteralExpCS= ruleInvalidLiteralExpCS EOF ;
    public final EObject entryRuleInvalidLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInvalidLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4155:2: (iv_ruleInvalidLiteralExpCS= ruleInvalidLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4156:2: iv_ruleInvalidLiteralExpCS= ruleInvalidLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInvalidLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleInvalidLiteralExpCS_in_entryRuleInvalidLiteralExpCS9548);
            iv_ruleInvalidLiteralExpCS=ruleInvalidLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInvalidLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleInvalidLiteralExpCS9558); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4163:1: ruleInvalidLiteralExpCS returns [EObject current=null] : ( () otherlv_1= 'invalid' ) ;
    public final EObject ruleInvalidLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4166:28: ( ( () otherlv_1= 'invalid' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4167:1: ( () otherlv_1= 'invalid' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4167:1: ( () otherlv_1= 'invalid' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4167:2: () otherlv_1= 'invalid'
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4167:2: ()
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4168:2: 
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

            otherlv_1=(Token)match(input,77,FollowSets000.FOLLOW_77_in_ruleInvalidLiteralExpCS9607); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4188:1: entryRuleNullLiteralExpCS returns [EObject current=null] : iv_ruleNullLiteralExpCS= ruleNullLiteralExpCS EOF ;
    public final EObject entryRuleNullLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4189:2: (iv_ruleNullLiteralExpCS= ruleNullLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4190:2: iv_ruleNullLiteralExpCS= ruleNullLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNullLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNullLiteralExpCS_in_entryRuleNullLiteralExpCS9643);
            iv_ruleNullLiteralExpCS=ruleNullLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNullLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNullLiteralExpCS9653); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4197:1: ruleNullLiteralExpCS returns [EObject current=null] : ( () otherlv_1= 'null' ) ;
    public final EObject ruleNullLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4200:28: ( ( () otherlv_1= 'null' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4201:1: ( () otherlv_1= 'null' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4201:1: ( () otherlv_1= 'null' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4201:2: () otherlv_1= 'null'
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4201:2: ()
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4202:2: 
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

            otherlv_1=(Token)match(input,78,FollowSets000.FOLLOW_78_in_ruleNullLiteralExpCS9702); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4222:1: entryRuleTypeLiteralCS returns [EObject current=null] : iv_ruleTypeLiteralCS= ruleTypeLiteralCS EOF ;
    public final EObject entryRuleTypeLiteralCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeLiteralCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4223:2: (iv_ruleTypeLiteralCS= ruleTypeLiteralCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4224:2: iv_ruleTypeLiteralCS= ruleTypeLiteralCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeLiteralCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralCS_in_entryRuleTypeLiteralCS9738);
            iv_ruleTypeLiteralCS=ruleTypeLiteralCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeLiteralCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeLiteralCS9748); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4231:1: ruleTypeLiteralCS returns [EObject current=null] : (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS | this_CollectionTypeCS_1= ruleCollectionTypeCS | this_TupleTypeCS_2= ruleTupleTypeCS ) ;
    public final EObject ruleTypeLiteralCS() throws RecognitionException {
        EObject current = null;

        EObject this_PrimitiveTypeCS_0 = null;

        EObject this_CollectionTypeCS_1 = null;

        EObject this_TupleTypeCS_2 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4234:28: ( (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS | this_CollectionTypeCS_1= ruleCollectionTypeCS | this_TupleTypeCS_2= ruleTupleTypeCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4235:1: (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS | this_CollectionTypeCS_1= ruleCollectionTypeCS | this_TupleTypeCS_2= ruleTupleTypeCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4235:1: (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS | this_CollectionTypeCS_1= ruleCollectionTypeCS | this_TupleTypeCS_2= ruleTupleTypeCS )
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4236:2: this_PrimitiveTypeCS_0= rulePrimitiveTypeCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeLiteralCSAccess().getPrimitiveTypeCSParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrimitiveTypeCS_in_ruleTypeLiteralCS9798);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4249:2: this_CollectionTypeCS_1= ruleCollectionTypeCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeLiteralCSAccess().getCollectionTypeCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCollectionTypeCS_in_ruleTypeLiteralCS9828);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4262:2: this_TupleTypeCS_2= ruleTupleTypeCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeLiteralCSAccess().getTupleTypeCSParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTupleTypeCS_in_ruleTypeLiteralCS9858);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4281:1: entryRuleTypeLiteralWithMultiplicityCS returns [EObject current=null] : iv_ruleTypeLiteralWithMultiplicityCS= ruleTypeLiteralWithMultiplicityCS EOF ;
    public final EObject entryRuleTypeLiteralWithMultiplicityCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeLiteralWithMultiplicityCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4282:2: (iv_ruleTypeLiteralWithMultiplicityCS= ruleTypeLiteralWithMultiplicityCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4283:2: iv_ruleTypeLiteralWithMultiplicityCS= ruleTypeLiteralWithMultiplicityCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeLiteralWithMultiplicityCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralWithMultiplicityCS_in_entryRuleTypeLiteralWithMultiplicityCS9893);
            iv_ruleTypeLiteralWithMultiplicityCS=ruleTypeLiteralWithMultiplicityCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeLiteralWithMultiplicityCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeLiteralWithMultiplicityCS9903); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4290:1: ruleTypeLiteralWithMultiplicityCS returns [EObject current=null] : (this_TypeLiteralCS_0= ruleTypeLiteralCS ( (lv_multiplicity_1_0= ruleMultiplicityCS ) )? ) ;
    public final EObject ruleTypeLiteralWithMultiplicityCS() throws RecognitionException {
        EObject current = null;

        EObject this_TypeLiteralCS_0 = null;

        EObject lv_multiplicity_1_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4293:28: ( (this_TypeLiteralCS_0= ruleTypeLiteralCS ( (lv_multiplicity_1_0= ruleMultiplicityCS ) )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4294:1: (this_TypeLiteralCS_0= ruleTypeLiteralCS ( (lv_multiplicity_1_0= ruleMultiplicityCS ) )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4294:1: (this_TypeLiteralCS_0= ruleTypeLiteralCS ( (lv_multiplicity_1_0= ruleMultiplicityCS ) )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4295:2: this_TypeLiteralCS_0= ruleTypeLiteralCS ( (lv_multiplicity_1_0= ruleMultiplicityCS ) )?
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getTypeLiteralWithMultiplicityCSAccess().getTypeLiteralCSParserRuleCall_0()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralCS_in_ruleTypeLiteralWithMultiplicityCS9953);
            this_TypeLiteralCS_0=ruleTypeLiteralCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_TypeLiteralCS_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4306:1: ( (lv_multiplicity_1_0= ruleMultiplicityCS ) )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==72) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4307:1: (lv_multiplicity_1_0= ruleMultiplicityCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4307:1: (lv_multiplicity_1_0= ruleMultiplicityCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4308:3: lv_multiplicity_1_0= ruleMultiplicityCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeLiteralWithMultiplicityCSAccess().getMultiplicityMultiplicityCSParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMultiplicityCS_in_ruleTypeLiteralWithMultiplicityCS9973);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4332:1: entryRuleTypeLiteralExpCS returns [EObject current=null] : iv_ruleTypeLiteralExpCS= ruleTypeLiteralExpCS EOF ;
    public final EObject entryRuleTypeLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4333:2: (iv_ruleTypeLiteralExpCS= ruleTypeLiteralExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4334:2: iv_ruleTypeLiteralExpCS= ruleTypeLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralExpCS_in_entryRuleTypeLiteralExpCS10010);
            iv_ruleTypeLiteralExpCS=ruleTypeLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeLiteralExpCS10020); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4341:1: ruleTypeLiteralExpCS returns [EObject current=null] : ( (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS ) ) ;
    public final EObject ruleTypeLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject lv_ownedType_0_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4344:28: ( ( (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4345:1: ( (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4345:1: ( (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4346:1: (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4346:1: (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4347:3: lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypeLiteralExpCSAccess().getOwnedTypeTypeLiteralWithMultiplicityCSParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralWithMultiplicityCS_in_ruleTypeLiteralExpCS10065);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4371:1: entryRuleTypeNameExpCS returns [EObject current=null] : iv_ruleTypeNameExpCS= ruleTypeNameExpCS EOF ;
    public final EObject entryRuleTypeNameExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeNameExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4372:2: (iv_ruleTypeNameExpCS= ruleTypeNameExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4373:2: iv_ruleTypeNameExpCS= ruleTypeNameExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeNameExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeNameExpCS_in_entryRuleTypeNameExpCS10100);
            iv_ruleTypeNameExpCS=ruleTypeNameExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeNameExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeNameExpCS10110); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4380:1: ruleTypeNameExpCS returns [EObject current=null] : ( (lv_pathName_0_0= rulePathNameCS ) ) ;
    public final EObject ruleTypeNameExpCS() throws RecognitionException {
        EObject current = null;

        EObject lv_pathName_0_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4383:28: ( ( (lv_pathName_0_0= rulePathNameCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4384:1: ( (lv_pathName_0_0= rulePathNameCS ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4384:1: ( (lv_pathName_0_0= rulePathNameCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4385:1: (lv_pathName_0_0= rulePathNameCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4385:1: (lv_pathName_0_0= rulePathNameCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4386:3: lv_pathName_0_0= rulePathNameCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypeNameExpCSAccess().getPathNamePathNameCSParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_rulePathNameCS_in_ruleTypeNameExpCS10155);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4410:1: entryRuleTypeExpCS returns [EObject current=null] : iv_ruleTypeExpCS= ruleTypeExpCS EOF ;
    public final EObject entryRuleTypeExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4411:2: (iv_ruleTypeExpCS= ruleTypeExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4412:2: iv_ruleTypeExpCS= ruleTypeExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_entryRuleTypeExpCS10190);
            iv_ruleTypeExpCS=ruleTypeExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeExpCS10200); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4419:1: ruleTypeExpCS returns [EObject current=null] : ( (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS ) ( (lv_multiplicity_2_0= ruleMultiplicityCS ) )? ) ;
    public final EObject ruleTypeExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_TypeNameExpCS_0 = null;

        EObject this_TypeLiteralCS_1 = null;

        EObject lv_multiplicity_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4422:28: ( ( (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS ) ( (lv_multiplicity_2_0= ruleMultiplicityCS ) )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4423:1: ( (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS ) ( (lv_multiplicity_2_0= ruleMultiplicityCS ) )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4423:1: ( (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS ) ( (lv_multiplicity_2_0= ruleMultiplicityCS ) )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4423:2: (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS ) ( (lv_multiplicity_2_0= ruleMultiplicityCS ) )?
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4423:2: (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS )
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( ((LA66_0>=RULE_SIMPLE_ID && LA66_0<=RULE_ESCAPED_ID)||LA66_0==16||(LA66_0>=27 && LA66_0<=28)||LA66_0==31||(LA66_0>=35 && LA66_0<=41)) ) {
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4424:2: this_TypeNameExpCS_0= ruleTypeNameExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeExpCSAccess().getTypeNameExpCSParserRuleCall_0_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeNameExpCS_in_ruleTypeExpCS10251);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4437:2: this_TypeLiteralCS_1= ruleTypeLiteralCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeExpCSAccess().getTypeLiteralCSParserRuleCall_0_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralCS_in_ruleTypeExpCS10281);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4448:2: ( (lv_multiplicity_2_0= ruleMultiplicityCS ) )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==72) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4449:1: (lv_multiplicity_2_0= ruleMultiplicityCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4449:1: (lv_multiplicity_2_0= ruleMultiplicityCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4450:3: lv_multiplicity_2_0= ruleMultiplicityCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeExpCSAccess().getMultiplicityMultiplicityCSParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMultiplicityCS_in_ruleTypeExpCS10302);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4474:1: entryRuleExpCS returns [EObject current=null] : iv_ruleExpCS= ruleExpCS EOF ;
    public final EObject entryRuleExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4475:2: (iv_ruleExpCS= ruleExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4476:2: iv_ruleExpCS= ruleExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_entryRuleExpCS10339);
            iv_ruleExpCS=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleExpCS10349); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4483:1: ruleExpCS returns [EObject current=null] : ( (this_PrefixedExpCS_0= rulePrefixedExpCS ( () ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? ) | ( (lv_ownedExpression_8_0= ruleLetExpCS ) ) ) )? ) | ( () ( (lv_ownedOperator_10_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_11_0= ruleLetExpCS ) ) ) | this_LetExpCS_12= ruleLetExpCS ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4486:28: ( ( (this_PrefixedExpCS_0= rulePrefixedExpCS ( () ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? ) | ( (lv_ownedExpression_8_0= ruleLetExpCS ) ) ) )? ) | ( () ( (lv_ownedOperator_10_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_11_0= ruleLetExpCS ) ) ) | this_LetExpCS_12= ruleLetExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4487:1: ( (this_PrefixedExpCS_0= rulePrefixedExpCS ( () ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? ) | ( (lv_ownedExpression_8_0= ruleLetExpCS ) ) ) )? ) | ( () ( (lv_ownedOperator_10_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_11_0= ruleLetExpCS ) ) ) | this_LetExpCS_12= ruleLetExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4487:1: ( (this_PrefixedExpCS_0= rulePrefixedExpCS ( () ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? ) | ( (lv_ownedExpression_8_0= ruleLetExpCS ) ) ) )? ) | ( () ( (lv_ownedOperator_10_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_11_0= ruleLetExpCS ) ) ) | this_LetExpCS_12= ruleLetExpCS )
            int alt73=3;
            alt73 = dfa73.predict(input);
            switch (alt73) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4487:2: (this_PrefixedExpCS_0= rulePrefixedExpCS ( () ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? ) | ( (lv_ownedExpression_8_0= ruleLetExpCS ) ) ) )? )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4487:2: (this_PrefixedExpCS_0= rulePrefixedExpCS ( () ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? ) | ( (lv_ownedExpression_8_0= ruleLetExpCS ) ) ) )? )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4488:2: this_PrefixedExpCS_0= rulePrefixedExpCS ( () ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? ) | ( (lv_ownedExpression_8_0= ruleLetExpCS ) ) ) )?
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getExpCSAccess().getPrefixedExpCSParserRuleCall_0_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrefixedExpCS_in_ruleExpCS10400);
                    this_PrefixedExpCS_0=rulePrefixedExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_PrefixedExpCS_0; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4499:1: ( () ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? ) | ( (lv_ownedExpression_8_0= ruleLetExpCS ) ) ) )?
                    int alt71=2;
                    int LA71_0 = input.LA(1);

                    if ( (LA71_0==22||LA71_0==34||LA71_0==42||(LA71_0>=44 && LA71_0<=56)) ) {
                        alt71=1;
                    }
                    switch (alt71) {
                        case 1 :
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4499:2: () ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? ) | ( (lv_ownedExpression_8_0= ruleLetExpCS ) ) )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4499:2: ()
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4500:2: 
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

                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4508:2: ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4509:1: (lv_ownedOperator_2_0= ruleBinaryOperatorCS )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4509:1: (lv_ownedOperator_2_0= ruleBinaryOperatorCS )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4510:3: lv_ownedOperator_2_0= ruleBinaryOperatorCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getExpCSAccess().getOwnedOperatorBinaryOperatorCSParserRuleCall_0_1_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleBinaryOperatorCS_in_ruleExpCS10433);
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

                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4526:2: ( ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? ) | ( (lv_ownedExpression_8_0= ruleLetExpCS ) ) )
                            int alt70=2;
                            int LA70_0 = input.LA(1);

                            if ( ((LA70_0>=RULE_SIMPLE_ID && LA70_0<=RULE_SINGLE_QUOTED_STRING)||LA70_0==16||(LA70_0>=27 && LA70_0<=29)||LA70_0==31||(LA70_0>=34 && LA70_0<=43)||(LA70_0>=57 && LA70_0<=70)||(LA70_0>=75 && LA70_0<=78)||LA70_0==81||LA70_0==86) ) {
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
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4526:3: ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? )
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4526:3: ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4526:4: ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )?
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4526:4: ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4527:1: (lv_ownedExpression_3_0= rulePrefixedExpCS )
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4527:1: (lv_ownedExpression_3_0= rulePrefixedExpCS )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4528:3: lv_ownedExpression_3_0= rulePrefixedExpCS
                                    {
                                    if ( state.backtracking==0 ) {
                                       
                                      	        newCompositeNode(grammarAccess.getExpCSAccess().getOwnedExpressionPrefixedExpCSParserRuleCall_0_1_2_0_0_0()); 
                                      	    
                                    }
                                    pushFollow(FollowSets000.FOLLOW_rulePrefixedExpCS_in_ruleExpCS10456);
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

                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4544:2: ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )*
                                    loop68:
                                    do {
                                        int alt68=2;
                                        alt68 = dfa68.predict(input);
                                        switch (alt68) {
                                    	case 1 :
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4544:3: ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) )
                                    	    {
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4544:3: ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) )
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4545:1: (lv_ownedOperator_4_0= ruleBinaryOperatorCS )
                                    	    {
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4545:1: (lv_ownedOperator_4_0= ruleBinaryOperatorCS )
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4546:3: lv_ownedOperator_4_0= ruleBinaryOperatorCS
                                    	    {
                                    	    if ( state.backtracking==0 ) {
                                    	       
                                    	      	        newCompositeNode(grammarAccess.getExpCSAccess().getOwnedOperatorBinaryOperatorCSParserRuleCall_0_1_2_0_1_0_0()); 
                                    	      	    
                                    	    }
                                    	    pushFollow(FollowSets000.FOLLOW_ruleBinaryOperatorCS_in_ruleExpCS10478);
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

                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4562:2: ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) )
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4563:1: (lv_ownedExpression_5_0= rulePrefixedExpCS )
                                    	    {
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4563:1: (lv_ownedExpression_5_0= rulePrefixedExpCS )
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4564:3: lv_ownedExpression_5_0= rulePrefixedExpCS
                                    	    {
                                    	    if ( state.backtracking==0 ) {
                                    	       
                                    	      	        newCompositeNode(grammarAccess.getExpCSAccess().getOwnedExpressionPrefixedExpCSParserRuleCall_0_1_2_0_1_1_0()); 
                                    	      	    
                                    	    }
                                    	    pushFollow(FollowSets000.FOLLOW_rulePrefixedExpCS_in_ruleExpCS10499);
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

                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4580:4: ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )?
                                    int alt69=2;
                                    int LA69_0 = input.LA(1);

                                    if ( (LA69_0==22||LA69_0==34||LA69_0==42||(LA69_0>=44 && LA69_0<=56)) ) {
                                        alt69=1;
                                    }
                                    switch (alt69) {
                                        case 1 :
                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4580:5: ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) )
                                            {
                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4580:5: ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) )
                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4581:1: (lv_ownedOperator_6_0= ruleBinaryOperatorCS )
                                            {
                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4581:1: (lv_ownedOperator_6_0= ruleBinaryOperatorCS )
                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4582:3: lv_ownedOperator_6_0= ruleBinaryOperatorCS
                                            {
                                            if ( state.backtracking==0 ) {
                                               
                                              	        newCompositeNode(grammarAccess.getExpCSAccess().getOwnedOperatorBinaryOperatorCSParserRuleCall_0_1_2_0_2_0_0()); 
                                              	    
                                            }
                                            pushFollow(FollowSets000.FOLLOW_ruleBinaryOperatorCS_in_ruleExpCS10523);
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

                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4598:2: ( (lv_ownedExpression_7_0= ruleLetExpCS ) )
                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4599:1: (lv_ownedExpression_7_0= ruleLetExpCS )
                                            {
                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4599:1: (lv_ownedExpression_7_0= ruleLetExpCS )
                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4600:3: lv_ownedExpression_7_0= ruleLetExpCS
                                            {
                                            if ( state.backtracking==0 ) {
                                               
                                              	        newCompositeNode(grammarAccess.getExpCSAccess().getOwnedExpressionLetExpCSParserRuleCall_0_1_2_0_2_1_0()); 
                                              	    
                                            }
                                            pushFollow(FollowSets000.FOLLOW_ruleLetExpCS_in_ruleExpCS10544);
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
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4617:6: ( (lv_ownedExpression_8_0= ruleLetExpCS ) )
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4617:6: ( (lv_ownedExpression_8_0= ruleLetExpCS ) )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4618:1: (lv_ownedExpression_8_0= ruleLetExpCS )
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4618:1: (lv_ownedExpression_8_0= ruleLetExpCS )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4619:3: lv_ownedExpression_8_0= ruleLetExpCS
                                    {
                                    if ( state.backtracking==0 ) {
                                       
                                      	        newCompositeNode(grammarAccess.getExpCSAccess().getOwnedExpressionLetExpCSParserRuleCall_0_1_2_1_0()); 
                                      	    
                                    }
                                    pushFollow(FollowSets000.FOLLOW_ruleLetExpCS_in_ruleExpCS10574);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4636:6: ( () ( (lv_ownedOperator_10_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_11_0= ruleLetExpCS ) ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4636:6: ( () ( (lv_ownedOperator_10_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_11_0= ruleLetExpCS ) ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4636:7: () ( (lv_ownedOperator_10_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_11_0= ruleLetExpCS ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4636:7: ()
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4637:2: 
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

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4645:2: ( (lv_ownedOperator_10_0= ruleUnaryOperatorCS ) )+
                    int cnt72=0;
                    loop72:
                    do {
                        int alt72=2;
                        int LA72_0 = input.LA(1);

                        if ( ((LA72_0>=42 && LA72_0<=43)) ) {
                            alt72=1;
                        }


                        switch (alt72) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4646:1: (lv_ownedOperator_10_0= ruleUnaryOperatorCS )
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4646:1: (lv_ownedOperator_10_0= ruleUnaryOperatorCS )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4647:3: lv_ownedOperator_10_0= ruleUnaryOperatorCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getExpCSAccess().getOwnedOperatorUnaryOperatorCSParserRuleCall_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleUnaryOperatorCS_in_ruleExpCS10618);
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

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4663:3: ( (lv_ownedExpression_11_0= ruleLetExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4664:1: (lv_ownedExpression_11_0= ruleLetExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4664:1: (lv_ownedExpression_11_0= ruleLetExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4665:3: lv_ownedExpression_11_0= ruleLetExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpCSAccess().getOwnedExpressionLetExpCSParserRuleCall_1_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLetExpCS_in_ruleExpCS10640);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4683:2: this_LetExpCS_12= ruleLetExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getExpCSAccess().getLetExpCSParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLetExpCS_in_ruleExpCS10672);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4702:1: entryRulePrefixedExpCS returns [EObject current=null] : iv_rulePrefixedExpCS= rulePrefixedExpCS EOF ;
    public final EObject entryRulePrefixedExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrefixedExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4703:2: (iv_rulePrefixedExpCS= rulePrefixedExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4704:2: iv_rulePrefixedExpCS= rulePrefixedExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrefixedExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePrefixedExpCS_in_entryRulePrefixedExpCS10707);
            iv_rulePrefixedExpCS=rulePrefixedExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrefixedExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrefixedExpCS10717); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4711:1: rulePrefixedExpCS returns [EObject current=null] : ( ( () ( (lv_ownedOperator_1_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_2_0= rulePrimaryExpCS ) ) ) | this_PrimaryExpCS_3= rulePrimaryExpCS ) ;
    public final EObject rulePrefixedExpCS() throws RecognitionException {
        EObject current = null;

        EObject lv_ownedOperator_1_0 = null;

        EObject lv_ownedExpression_2_0 = null;

        EObject this_PrimaryExpCS_3 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4714:28: ( ( ( () ( (lv_ownedOperator_1_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_2_0= rulePrimaryExpCS ) ) ) | this_PrimaryExpCS_3= rulePrimaryExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4715:1: ( ( () ( (lv_ownedOperator_1_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_2_0= rulePrimaryExpCS ) ) ) | this_PrimaryExpCS_3= rulePrimaryExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4715:1: ( ( () ( (lv_ownedOperator_1_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_2_0= rulePrimaryExpCS ) ) ) | this_PrimaryExpCS_3= rulePrimaryExpCS )
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( ((LA75_0>=42 && LA75_0<=43)) ) {
                alt75=1;
            }
            else if ( ((LA75_0>=RULE_SIMPLE_ID && LA75_0<=RULE_SINGLE_QUOTED_STRING)||LA75_0==16||(LA75_0>=27 && LA75_0<=29)||LA75_0==31||(LA75_0>=34 && LA75_0<=41)||(LA75_0>=57 && LA75_0<=70)||(LA75_0>=75 && LA75_0<=78)||LA75_0==81||LA75_0==86) ) {
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4715:2: ( () ( (lv_ownedOperator_1_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_2_0= rulePrimaryExpCS ) ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4715:2: ( () ( (lv_ownedOperator_1_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_2_0= rulePrimaryExpCS ) ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4715:3: () ( (lv_ownedOperator_1_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_2_0= rulePrimaryExpCS ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4715:3: ()
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4716:2: 
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

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4724:2: ( (lv_ownedOperator_1_0= ruleUnaryOperatorCS ) )+
                    int cnt74=0;
                    loop74:
                    do {
                        int alt74=2;
                        int LA74_0 = input.LA(1);

                        if ( ((LA74_0>=42 && LA74_0<=43)) ) {
                            alt74=1;
                        }


                        switch (alt74) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4725:1: (lv_ownedOperator_1_0= ruleUnaryOperatorCS )
                    	    {
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4725:1: (lv_ownedOperator_1_0= ruleUnaryOperatorCS )
                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4726:3: lv_ownedOperator_1_0= ruleUnaryOperatorCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getPrefixedExpCSAccess().getOwnedOperatorUnaryOperatorCSParserRuleCall_0_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleUnaryOperatorCS_in_rulePrefixedExpCS10776);
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

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4742:3: ( (lv_ownedExpression_2_0= rulePrimaryExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4743:1: (lv_ownedExpression_2_0= rulePrimaryExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4743:1: (lv_ownedExpression_2_0= rulePrimaryExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4744:3: lv_ownedExpression_2_0= rulePrimaryExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrefixedExpCSAccess().getOwnedExpressionPrimaryExpCSParserRuleCall_0_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrimaryExpCS_in_rulePrefixedExpCS10798);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4762:2: this_PrimaryExpCS_3= rulePrimaryExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrefixedExpCSAccess().getPrimaryExpCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrimaryExpCS_in_rulePrefixedExpCS10830);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4781:1: entryRulePrimaryExpCS returns [EObject current=null] : iv_rulePrimaryExpCS= rulePrimaryExpCS EOF ;
    public final EObject entryRulePrimaryExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4782:2: (iv_rulePrimaryExpCS= rulePrimaryExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4783:2: iv_rulePrimaryExpCS= rulePrimaryExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimaryExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePrimaryExpCS_in_entryRulePrimaryExpCS10865);
            iv_rulePrimaryExpCS=rulePrimaryExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimaryExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrimaryExpCS10875); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4790:1: rulePrimaryExpCS returns [EObject current=null] : (this_NestedExpCS_0= ruleNestedExpCS | this_IfExpCS_1= ruleIfExpCS | this_SelfExpCS_2= ruleSelfExpCS | this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS | this_CollectionLiteralExpCS_5= ruleCollectionLiteralExpCS | this_TypeLiteralExpCS_6= ruleTypeLiteralExpCS | ( () ( (lv_pathName_8_0= rulePathNameCS ) ) ( ( () otherlv_10= '[' ( (lv_firstIndexes_11_0= ruleExpCS ) ) (otherlv_12= ',' ( (lv_firstIndexes_13_0= ruleExpCS ) ) )* otherlv_14= ']' (otherlv_15= '[' ( (lv_secondIndexes_16_0= ruleExpCS ) ) (otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) ) )* otherlv_19= ']' )? ( ( (lv_atPre_20_0= '@' ) ) otherlv_21= 'pre' )? ) | ( () otherlv_23= '{' ( ( ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )* ) | ( (lv_value_27_0= ruleStringLiteral ) ) ) otherlv_28= '}' ) | ( ( ( (lv_atPre_29_0= '@' ) ) otherlv_30= 'pre' )? ( () otherlv_32= '(' ( ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_39= ')' )? ) ) ) ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4793:28: ( (this_NestedExpCS_0= ruleNestedExpCS | this_IfExpCS_1= ruleIfExpCS | this_SelfExpCS_2= ruleSelfExpCS | this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS | this_CollectionLiteralExpCS_5= ruleCollectionLiteralExpCS | this_TypeLiteralExpCS_6= ruleTypeLiteralExpCS | ( () ( (lv_pathName_8_0= rulePathNameCS ) ) ( ( () otherlv_10= '[' ( (lv_firstIndexes_11_0= ruleExpCS ) ) (otherlv_12= ',' ( (lv_firstIndexes_13_0= ruleExpCS ) ) )* otherlv_14= ']' (otherlv_15= '[' ( (lv_secondIndexes_16_0= ruleExpCS ) ) (otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) ) )* otherlv_19= ']' )? ( ( (lv_atPre_20_0= '@' ) ) otherlv_21= 'pre' )? ) | ( () otherlv_23= '{' ( ( ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )* ) | ( (lv_value_27_0= ruleStringLiteral ) ) ) otherlv_28= '}' ) | ( ( ( (lv_atPre_29_0= '@' ) ) otherlv_30= 'pre' )? ( () otherlv_32= '(' ( ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_39= ')' )? ) ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4794:1: (this_NestedExpCS_0= ruleNestedExpCS | this_IfExpCS_1= ruleIfExpCS | this_SelfExpCS_2= ruleSelfExpCS | this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS | this_CollectionLiteralExpCS_5= ruleCollectionLiteralExpCS | this_TypeLiteralExpCS_6= ruleTypeLiteralExpCS | ( () ( (lv_pathName_8_0= rulePathNameCS ) ) ( ( () otherlv_10= '[' ( (lv_firstIndexes_11_0= ruleExpCS ) ) (otherlv_12= ',' ( (lv_firstIndexes_13_0= ruleExpCS ) ) )* otherlv_14= ']' (otherlv_15= '[' ( (lv_secondIndexes_16_0= ruleExpCS ) ) (otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) ) )* otherlv_19= ']' )? ( ( (lv_atPre_20_0= '@' ) ) otherlv_21= 'pre' )? ) | ( () otherlv_23= '{' ( ( ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )* ) | ( (lv_value_27_0= ruleStringLiteral ) ) ) otherlv_28= '}' ) | ( ( ( (lv_atPre_29_0= '@' ) ) otherlv_30= 'pre' )? ( () otherlv_32= '(' ( ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_39= ')' )? ) ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4794:1: (this_NestedExpCS_0= ruleNestedExpCS | this_IfExpCS_1= ruleIfExpCS | this_SelfExpCS_2= ruleSelfExpCS | this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS | this_CollectionLiteralExpCS_5= ruleCollectionLiteralExpCS | this_TypeLiteralExpCS_6= ruleTypeLiteralExpCS | ( () ( (lv_pathName_8_0= rulePathNameCS ) ) ( ( () otherlv_10= '[' ( (lv_firstIndexes_11_0= ruleExpCS ) ) (otherlv_12= ',' ( (lv_firstIndexes_13_0= ruleExpCS ) ) )* otherlv_14= ']' (otherlv_15= '[' ( (lv_secondIndexes_16_0= ruleExpCS ) ) (otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) ) )* otherlv_19= ']' )? ( ( (lv_atPre_20_0= '@' ) ) otherlv_21= 'pre' )? ) | ( () otherlv_23= '{' ( ( ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )* ) | ( (lv_value_27_0= ruleStringLiteral ) ) ) otherlv_28= '}' ) | ( ( ( (lv_atPre_29_0= '@' ) ) otherlv_30= 'pre' )? ( () otherlv_32= '(' ( ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_39= ')' )? ) ) ) )
            int alt91=8;
            alt91 = dfa91.predict(input);
            switch (alt91) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4795:2: this_NestedExpCS_0= ruleNestedExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getNestedExpCSParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNestedExpCS_in_rulePrimaryExpCS10925);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4808:2: this_IfExpCS_1= ruleIfExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getIfExpCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleIfExpCS_in_rulePrimaryExpCS10955);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4821:2: this_SelfExpCS_2= ruleSelfExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getSelfExpCSParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSelfExpCS_in_rulePrimaryExpCS10985);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4834:2: this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getPrimitiveLiteralExpCSParserRuleCall_3()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrimitiveLiteralExpCS_in_rulePrimaryExpCS11015);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4847:2: this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getTupleLiteralExpCSParserRuleCall_4()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralExpCS_in_rulePrimaryExpCS11045);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4860:2: this_CollectionLiteralExpCS_5= ruleCollectionLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getCollectionLiteralExpCSParserRuleCall_5()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteralExpCS_in_rulePrimaryExpCS11075);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4873:2: this_TypeLiteralExpCS_6= ruleTypeLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getTypeLiteralExpCSParserRuleCall_6()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralExpCS_in_rulePrimaryExpCS11105);
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
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4885:6: ( () ( (lv_pathName_8_0= rulePathNameCS ) ) ( ( () otherlv_10= '[' ( (lv_firstIndexes_11_0= ruleExpCS ) ) (otherlv_12= ',' ( (lv_firstIndexes_13_0= ruleExpCS ) ) )* otherlv_14= ']' (otherlv_15= '[' ( (lv_secondIndexes_16_0= ruleExpCS ) ) (otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) ) )* otherlv_19= ']' )? ( ( (lv_atPre_20_0= '@' ) ) otherlv_21= 'pre' )? ) | ( () otherlv_23= '{' ( ( ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )* ) | ( (lv_value_27_0= ruleStringLiteral ) ) ) otherlv_28= '}' ) | ( ( ( (lv_atPre_29_0= '@' ) ) otherlv_30= 'pre' )? ( () otherlv_32= '(' ( ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_39= ')' )? ) ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4885:6: ( () ( (lv_pathName_8_0= rulePathNameCS ) ) ( ( () otherlv_10= '[' ( (lv_firstIndexes_11_0= ruleExpCS ) ) (otherlv_12= ',' ( (lv_firstIndexes_13_0= ruleExpCS ) ) )* otherlv_14= ']' (otherlv_15= '[' ( (lv_secondIndexes_16_0= ruleExpCS ) ) (otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) ) )* otherlv_19= ']' )? ( ( (lv_atPre_20_0= '@' ) ) otherlv_21= 'pre' )? ) | ( () otherlv_23= '{' ( ( ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )* ) | ( (lv_value_27_0= ruleStringLiteral ) ) ) otherlv_28= '}' ) | ( ( ( (lv_atPre_29_0= '@' ) ) otherlv_30= 'pre' )? ( () otherlv_32= '(' ( ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_39= ')' )? ) ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4885:7: () ( (lv_pathName_8_0= rulePathNameCS ) ) ( ( () otherlv_10= '[' ( (lv_firstIndexes_11_0= ruleExpCS ) ) (otherlv_12= ',' ( (lv_firstIndexes_13_0= ruleExpCS ) ) )* otherlv_14= ']' (otherlv_15= '[' ( (lv_secondIndexes_16_0= ruleExpCS ) ) (otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) ) )* otherlv_19= ']' )? ( ( (lv_atPre_20_0= '@' ) ) otherlv_21= 'pre' )? ) | ( () otherlv_23= '{' ( ( ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )* ) | ( (lv_value_27_0= ruleStringLiteral ) ) ) otherlv_28= '}' ) | ( ( ( (lv_atPre_29_0= '@' ) ) otherlv_30= 'pre' )? ( () otherlv_32= '(' ( ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_39= ')' )? ) )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4885:7: ()
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4886:2: 
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

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4894:2: ( (lv_pathName_8_0= rulePathNameCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4895:1: (lv_pathName_8_0= rulePathNameCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4895:1: (lv_pathName_8_0= rulePathNameCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4896:3: lv_pathName_8_0= rulePathNameCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getPathNamePathNameCSParserRuleCall_7_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePathNameCS_in_rulePrimaryExpCS11144);
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

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4912:2: ( ( () otherlv_10= '[' ( (lv_firstIndexes_11_0= ruleExpCS ) ) (otherlv_12= ',' ( (lv_firstIndexes_13_0= ruleExpCS ) ) )* otherlv_14= ']' (otherlv_15= '[' ( (lv_secondIndexes_16_0= ruleExpCS ) ) (otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) ) )* otherlv_19= ']' )? ( ( (lv_atPre_20_0= '@' ) ) otherlv_21= 'pre' )? ) | ( () otherlv_23= '{' ( ( ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )* ) | ( (lv_value_27_0= ruleStringLiteral ) ) ) otherlv_28= '}' ) | ( ( ( (lv_atPre_29_0= '@' ) ) otherlv_30= 'pre' )? ( () otherlv_32= '(' ( ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_39= ')' )? ) )
                    int alt90=3;
                    switch ( input.LA(1) ) {
                    case 72:
                        {
                        alt90=1;
                        }
                        break;
                    case 18:
                        {
                        alt90=2;
                        }
                        break;
                    case EOF:
                    case 17:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 29:
                    case 30:
                    case 32:
                    case 34:
                    case 42:
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
                        alt90=3;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 90, 0, input);

                        throw nvae;
                    }

                    switch (alt90) {
                        case 1 :
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4912:3: ( () otherlv_10= '[' ( (lv_firstIndexes_11_0= ruleExpCS ) ) (otherlv_12= ',' ( (lv_firstIndexes_13_0= ruleExpCS ) ) )* otherlv_14= ']' (otherlv_15= '[' ( (lv_secondIndexes_16_0= ruleExpCS ) ) (otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) ) )* otherlv_19= ']' )? ( ( (lv_atPre_20_0= '@' ) ) otherlv_21= 'pre' )? )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4912:3: ( () otherlv_10= '[' ( (lv_firstIndexes_11_0= ruleExpCS ) ) (otherlv_12= ',' ( (lv_firstIndexes_13_0= ruleExpCS ) ) )* otherlv_14= ']' (otherlv_15= '[' ( (lv_secondIndexes_16_0= ruleExpCS ) ) (otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) ) )* otherlv_19= ']' )? ( ( (lv_atPre_20_0= '@' ) ) otherlv_21= 'pre' )? )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4912:4: () otherlv_10= '[' ( (lv_firstIndexes_11_0= ruleExpCS ) ) (otherlv_12= ',' ( (lv_firstIndexes_13_0= ruleExpCS ) ) )* otherlv_14= ']' (otherlv_15= '[' ( (lv_secondIndexes_16_0= ruleExpCS ) ) (otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) ) )* otherlv_19= ']' )? ( ( (lv_atPre_20_0= '@' ) ) otherlv_21= 'pre' )?
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4912:4: ()
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4913:2: 
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

                            otherlv_10=(Token)match(input,72,FollowSets000.FOLLOW_72_in_rulePrimaryExpCS11170); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_10, grammarAccess.getPrimaryExpCSAccess().getLeftSquareBracketKeyword_7_2_0_1());
                                  
                            }
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4925:1: ( (lv_firstIndexes_11_0= ruleExpCS ) )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4926:1: (lv_firstIndexes_11_0= ruleExpCS )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4926:1: (lv_firstIndexes_11_0= ruleExpCS )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4927:3: lv_firstIndexes_11_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getFirstIndexesExpCSParserRuleCall_7_2_0_2_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_rulePrimaryExpCS11191);
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

                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4943:2: (otherlv_12= ',' ( (lv_firstIndexes_13_0= ruleExpCS ) ) )*
                            loop76:
                            do {
                                int alt76=2;
                                int LA76_0 = input.LA(1);

                                if ( (LA76_0==24) ) {
                                    alt76=1;
                                }


                                switch (alt76) {
                            	case 1 :
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4943:4: otherlv_12= ',' ( (lv_firstIndexes_13_0= ruleExpCS ) )
                            	    {
                            	    otherlv_12=(Token)match(input,24,FollowSets000.FOLLOW_24_in_rulePrimaryExpCS11204); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_12, grammarAccess.getPrimaryExpCSAccess().getCommaKeyword_7_2_0_3_0());
                            	          
                            	    }
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4947:1: ( (lv_firstIndexes_13_0= ruleExpCS ) )
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4948:1: (lv_firstIndexes_13_0= ruleExpCS )
                            	    {
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4948:1: (lv_firstIndexes_13_0= ruleExpCS )
                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4949:3: lv_firstIndexes_13_0= ruleExpCS
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getFirstIndexesExpCSParserRuleCall_7_2_0_3_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_rulePrimaryExpCS11225);
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
                            	    break loop76;
                                }
                            } while (true);

                            otherlv_14=(Token)match(input,73,FollowSets000.FOLLOW_73_in_rulePrimaryExpCS11239); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_14, grammarAccess.getPrimaryExpCSAccess().getRightSquareBracketKeyword_7_2_0_4());
                                  
                            }
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4969:1: (otherlv_15= '[' ( (lv_secondIndexes_16_0= ruleExpCS ) ) (otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) ) )* otherlv_19= ']' )?
                            int alt78=2;
                            int LA78_0 = input.LA(1);

                            if ( (LA78_0==72) ) {
                                alt78=1;
                            }
                            switch (alt78) {
                                case 1 :
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4969:3: otherlv_15= '[' ( (lv_secondIndexes_16_0= ruleExpCS ) ) (otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) ) )* otherlv_19= ']'
                                    {
                                    otherlv_15=(Token)match(input,72,FollowSets000.FOLLOW_72_in_rulePrimaryExpCS11252); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                          	newLeafNode(otherlv_15, grammarAccess.getPrimaryExpCSAccess().getLeftSquareBracketKeyword_7_2_0_5_0());
                                          
                                    }
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4973:1: ( (lv_secondIndexes_16_0= ruleExpCS ) )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4974:1: (lv_secondIndexes_16_0= ruleExpCS )
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4974:1: (lv_secondIndexes_16_0= ruleExpCS )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4975:3: lv_secondIndexes_16_0= ruleExpCS
                                    {
                                    if ( state.backtracking==0 ) {
                                       
                                      	        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getSecondIndexesExpCSParserRuleCall_7_2_0_5_1_0()); 
                                      	    
                                    }
                                    pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_rulePrimaryExpCS11273);
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

                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4991:2: (otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) ) )*
                                    loop77:
                                    do {
                                        int alt77=2;
                                        int LA77_0 = input.LA(1);

                                        if ( (LA77_0==24) ) {
                                            alt77=1;
                                        }


                                        switch (alt77) {
                                    	case 1 :
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4991:4: otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) )
                                    	    {
                                    	    otherlv_17=(Token)match(input,24,FollowSets000.FOLLOW_24_in_rulePrimaryExpCS11286); if (state.failed) return current;
                                    	    if ( state.backtracking==0 ) {

                                    	          	newLeafNode(otherlv_17, grammarAccess.getPrimaryExpCSAccess().getCommaKeyword_7_2_0_5_2_0());
                                    	          
                                    	    }
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4995:1: ( (lv_secondIndexes_18_0= ruleExpCS ) )
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4996:1: (lv_secondIndexes_18_0= ruleExpCS )
                                    	    {
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4996:1: (lv_secondIndexes_18_0= ruleExpCS )
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4997:3: lv_secondIndexes_18_0= ruleExpCS
                                    	    {
                                    	    if ( state.backtracking==0 ) {
                                    	       
                                    	      	        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getSecondIndexesExpCSParserRuleCall_7_2_0_5_2_1_0()); 
                                    	      	    
                                    	    }
                                    	    pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_rulePrimaryExpCS11307);
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
                                    	    break loop77;
                                        }
                                    } while (true);

                                    otherlv_19=(Token)match(input,73,FollowSets000.FOLLOW_73_in_rulePrimaryExpCS11321); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                          	newLeafNode(otherlv_19, grammarAccess.getPrimaryExpCSAccess().getRightSquareBracketKeyword_7_2_0_5_3());
                                          
                                    }

                                    }
                                    break;

                            }

                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5017:3: ( ( (lv_atPre_20_0= '@' ) ) otherlv_21= 'pre' )?
                            int alt79=2;
                            int LA79_0 = input.LA(1);

                            if ( (LA79_0==79) ) {
                                alt79=1;
                            }
                            switch (alt79) {
                                case 1 :
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5017:4: ( (lv_atPre_20_0= '@' ) ) otherlv_21= 'pre'
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5017:4: ( (lv_atPre_20_0= '@' ) )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5018:1: (lv_atPre_20_0= '@' )
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5018:1: (lv_atPre_20_0= '@' )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5019:3: lv_atPre_20_0= '@'
                                    {
                                    lv_atPre_20_0=(Token)match(input,79,FollowSets000.FOLLOW_79_in_rulePrimaryExpCS11342); if (state.failed) return current;
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

                                    otherlv_21=(Token)match(input,80,FollowSets000.FOLLOW_80_in_rulePrimaryExpCS11367); if (state.failed) return current;
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
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5037:6: ( () otherlv_23= '{' ( ( ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )* ) | ( (lv_value_27_0= ruleStringLiteral ) ) ) otherlv_28= '}' )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5037:6: ( () otherlv_23= '{' ( ( ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )* ) | ( (lv_value_27_0= ruleStringLiteral ) ) ) otherlv_28= '}' )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5037:7: () otherlv_23= '{' ( ( ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )* ) | ( (lv_value_27_0= ruleStringLiteral ) ) ) otherlv_28= '}'
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5037:7: ()
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5038:2: 
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

                            otherlv_23=(Token)match(input,18,FollowSets000.FOLLOW_18_in_rulePrimaryExpCS11401); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_23, grammarAccess.getPrimaryExpCSAccess().getLeftCurlyBracketKeyword_7_2_1_1());
                                  
                            }
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5050:1: ( ( ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )* ) | ( (lv_value_27_0= ruleStringLiteral ) ) )
                            int alt81=2;
                            int LA81_0 = input.LA(1);

                            if ( ((LA81_0>=RULE_SIMPLE_ID && LA81_0<=RULE_ESCAPED_ID)||LA81_0==16||(LA81_0>=27 && LA81_0<=28)||LA81_0==31||(LA81_0>=35 && LA81_0<=41)) ) {
                                alt81=1;
                            }
                            else if ( (LA81_0==RULE_SINGLE_QUOTED_STRING) ) {
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
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5050:2: ( ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )* )
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5050:2: ( ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )* )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5050:3: ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )*
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5050:3: ( (lv_ownedParts_24_0= ruleConstructorPartCS ) )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5051:1: (lv_ownedParts_24_0= ruleConstructorPartCS )
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5051:1: (lv_ownedParts_24_0= ruleConstructorPartCS )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5052:3: lv_ownedParts_24_0= ruleConstructorPartCS
                                    {
                                    if ( state.backtracking==0 ) {
                                       
                                      	        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getOwnedPartsConstructorPartCSParserRuleCall_7_2_1_2_0_0_0()); 
                                      	    
                                    }
                                    pushFollow(FollowSets000.FOLLOW_ruleConstructorPartCS_in_rulePrimaryExpCS11424);
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

                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5068:2: (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )*
                                    loop80:
                                    do {
                                        int alt80=2;
                                        int LA80_0 = input.LA(1);

                                        if ( (LA80_0==24) ) {
                                            alt80=1;
                                        }


                                        switch (alt80) {
                                    	case 1 :
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5068:4: otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) )
                                    	    {
                                    	    otherlv_25=(Token)match(input,24,FollowSets000.FOLLOW_24_in_rulePrimaryExpCS11437); if (state.failed) return current;
                                    	    if ( state.backtracking==0 ) {

                                    	          	newLeafNode(otherlv_25, grammarAccess.getPrimaryExpCSAccess().getCommaKeyword_7_2_1_2_0_1_0());
                                    	          
                                    	    }
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5072:1: ( (lv_ownedParts_26_0= ruleConstructorPartCS ) )
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5073:1: (lv_ownedParts_26_0= ruleConstructorPartCS )
                                    	    {
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5073:1: (lv_ownedParts_26_0= ruleConstructorPartCS )
                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5074:3: lv_ownedParts_26_0= ruleConstructorPartCS
                                    	    {
                                    	    if ( state.backtracking==0 ) {
                                    	       
                                    	      	        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getOwnedPartsConstructorPartCSParserRuleCall_7_2_1_2_0_1_1_0()); 
                                    	      	    
                                    	    }
                                    	    pushFollow(FollowSets000.FOLLOW_ruleConstructorPartCS_in_rulePrimaryExpCS11458);
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
                                    	    break loop80;
                                        }
                                    } while (true);


                                    }


                                    }
                                    break;
                                case 2 :
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5091:6: ( (lv_value_27_0= ruleStringLiteral ) )
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5091:6: ( (lv_value_27_0= ruleStringLiteral ) )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5092:1: (lv_value_27_0= ruleStringLiteral )
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5092:1: (lv_value_27_0= ruleStringLiteral )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5093:3: lv_value_27_0= ruleStringLiteral
                                    {
                                    if ( state.backtracking==0 ) {
                                       
                                      	        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getValueStringLiteralParserRuleCall_7_2_1_2_1_0()); 
                                      	    
                                    }
                                    pushFollow(FollowSets000.FOLLOW_ruleStringLiteral_in_rulePrimaryExpCS11488);
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

                            otherlv_28=(Token)match(input,20,FollowSets000.FOLLOW_20_in_rulePrimaryExpCS11501); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_28, grammarAccess.getPrimaryExpCSAccess().getRightCurlyBracketKeyword_7_2_1_3());
                                  
                            }

                            }


                            }
                            break;
                        case 3 :
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5114:6: ( ( ( (lv_atPre_29_0= '@' ) ) otherlv_30= 'pre' )? ( () otherlv_32= '(' ( ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_39= ')' )? )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5114:6: ( ( ( (lv_atPre_29_0= '@' ) ) otherlv_30= 'pre' )? ( () otherlv_32= '(' ( ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_39= ')' )? )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5114:7: ( ( (lv_atPre_29_0= '@' ) ) otherlv_30= 'pre' )? ( () otherlv_32= '(' ( ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_39= ')' )?
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5114:7: ( ( (lv_atPre_29_0= '@' ) ) otherlv_30= 'pre' )?
                            int alt82=2;
                            int LA82_0 = input.LA(1);

                            if ( (LA82_0==79) ) {
                                alt82=1;
                            }
                            switch (alt82) {
                                case 1 :
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5114:8: ( (lv_atPre_29_0= '@' ) ) otherlv_30= 'pre'
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5114:8: ( (lv_atPre_29_0= '@' ) )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5115:1: (lv_atPre_29_0= '@' )
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5115:1: (lv_atPre_29_0= '@' )
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5116:3: lv_atPre_29_0= '@'
                                    {
                                    lv_atPre_29_0=(Token)match(input,79,FollowSets000.FOLLOW_79_in_rulePrimaryExpCS11528); if (state.failed) return current;
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

                                    otherlv_30=(Token)match(input,80,FollowSets000.FOLLOW_80_in_rulePrimaryExpCS11553); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                          	newLeafNode(otherlv_30, grammarAccess.getPrimaryExpCSAccess().getPreKeyword_7_2_2_0_1());
                                          
                                    }

                                    }
                                    break;

                            }

                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5133:3: ( () otherlv_32= '(' ( ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_39= ')' )?
                            int alt89=2;
                            int LA89_0 = input.LA(1);

                            if ( (LA89_0==29) ) {
                                alt89=1;
                            }
                            switch (alt89) {
                                case 1 :
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5133:4: () otherlv_32= '(' ( ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_39= ')'
                                    {
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5133:4: ()
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5134:2: 
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

                                    otherlv_32=(Token)match(input,29,FollowSets000.FOLLOW_29_in_rulePrimaryExpCS11580); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                          	newLeafNode(otherlv_32, grammarAccess.getPrimaryExpCSAccess().getLeftParenthesisKeyword_7_2_2_1_1());
                                          
                                    }
                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5146:1: ( ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )? )?
                                    int alt88=2;
                                    int LA88_0 = input.LA(1);

                                    if ( ((LA88_0>=RULE_SIMPLE_ID && LA88_0<=RULE_SINGLE_QUOTED_STRING)||LA88_0==16||(LA88_0>=27 && LA88_0<=29)||LA88_0==31||(LA88_0>=34 && LA88_0<=43)||(LA88_0>=57 && LA88_0<=70)||(LA88_0>=75 && LA88_0<=78)||LA88_0==81||(LA88_0>=85 && LA88_0<=86)) ) {
                                        alt88=1;
                                    }
                                    switch (alt88) {
                                        case 1 :
                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5146:2: ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )?
                                            {
                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5146:2: ( (lv_argument_33_0= ruleNavigatingArgCS ) )
                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5147:1: (lv_argument_33_0= ruleNavigatingArgCS )
                                            {
                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5147:1: (lv_argument_33_0= ruleNavigatingArgCS )
                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5148:3: lv_argument_33_0= ruleNavigatingArgCS
                                            {
                                            if ( state.backtracking==0 ) {
                                               
                                              	        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getArgumentNavigatingArgCSParserRuleCall_7_2_2_1_2_0_0()); 
                                              	    
                                            }
                                            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgCS_in_rulePrimaryExpCS11602);
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

                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5164:2: ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )*
                                            loop83:
                                            do {
                                                int alt83=2;
                                                int LA83_0 = input.LA(1);

                                                if ( (LA83_0==24) ) {
                                                    alt83=1;
                                                }


                                                switch (alt83) {
                                            	case 1 :
                                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5165:1: (lv_argument_34_0= ruleNavigatingCommaArgCS )
                                            	    {
                                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5165:1: (lv_argument_34_0= ruleNavigatingCommaArgCS )
                                            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5166:3: lv_argument_34_0= ruleNavigatingCommaArgCS
                                            	    {
                                            	    if ( state.backtracking==0 ) {
                                            	       
                                            	      	        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getArgumentNavigatingCommaArgCSParserRuleCall_7_2_2_1_2_1_0()); 
                                            	      	    
                                            	    }
                                            	    pushFollow(FollowSets000.FOLLOW_ruleNavigatingCommaArgCS_in_rulePrimaryExpCS11623);
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
                                            	    break loop83;
                                                }
                                            } while (true);

                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5182:3: ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )?
                                            int alt85=2;
                                            int LA85_0 = input.LA(1);

                                            if ( (LA85_0==23) ) {
                                                alt85=1;
                                            }
                                            switch (alt85) {
                                                case 1 :
                                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5182:4: ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )*
                                                    {
                                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5182:4: ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) )
                                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5183:1: (lv_argument_35_0= ruleNavigatingSemiArgCS )
                                                    {
                                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5183:1: (lv_argument_35_0= ruleNavigatingSemiArgCS )
                                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5184:3: lv_argument_35_0= ruleNavigatingSemiArgCS
                                                    {
                                                    if ( state.backtracking==0 ) {
                                                       
                                                      	        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getArgumentNavigatingSemiArgCSParserRuleCall_7_2_2_1_2_2_0_0()); 
                                                      	    
                                                    }
                                                    pushFollow(FollowSets000.FOLLOW_ruleNavigatingSemiArgCS_in_rulePrimaryExpCS11646);
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

                                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5200:2: ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )*
                                                    loop84:
                                                    do {
                                                        int alt84=2;
                                                        int LA84_0 = input.LA(1);

                                                        if ( (LA84_0==24) ) {
                                                            alt84=1;
                                                        }


                                                        switch (alt84) {
                                                    	case 1 :
                                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5201:1: (lv_argument_36_0= ruleNavigatingCommaArgCS )
                                                    	    {
                                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5201:1: (lv_argument_36_0= ruleNavigatingCommaArgCS )
                                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5202:3: lv_argument_36_0= ruleNavigatingCommaArgCS
                                                    	    {
                                                    	    if ( state.backtracking==0 ) {
                                                    	       
                                                    	      	        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getArgumentNavigatingCommaArgCSParserRuleCall_7_2_2_1_2_2_1_0()); 
                                                    	      	    
                                                    	    }
                                                    	    pushFollow(FollowSets000.FOLLOW_ruleNavigatingCommaArgCS_in_rulePrimaryExpCS11667);
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
                                                    	    break loop84;
                                                        }
                                                    } while (true);


                                                    }
                                                    break;

                                            }

                                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5218:5: ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )?
                                            int alt87=2;
                                            int LA87_0 = input.LA(1);

                                            if ( (LA87_0==25) ) {
                                                alt87=1;
                                            }
                                            switch (alt87) {
                                                case 1 :
                                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5218:6: ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )*
                                                    {
                                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5218:6: ( (lv_argument_37_0= ruleNavigatingBarArgCS ) )
                                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5219:1: (lv_argument_37_0= ruleNavigatingBarArgCS )
                                                    {
                                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5219:1: (lv_argument_37_0= ruleNavigatingBarArgCS )
                                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5220:3: lv_argument_37_0= ruleNavigatingBarArgCS
                                                    {
                                                    if ( state.backtracking==0 ) {
                                                       
                                                      	        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getArgumentNavigatingBarArgCSParserRuleCall_7_2_2_1_2_3_0_0()); 
                                                      	    
                                                    }
                                                    pushFollow(FollowSets000.FOLLOW_ruleNavigatingBarArgCS_in_rulePrimaryExpCS11692);
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

                                                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5236:2: ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )*
                                                    loop86:
                                                    do {
                                                        int alt86=2;
                                                        int LA86_0 = input.LA(1);

                                                        if ( (LA86_0==24) ) {
                                                            alt86=1;
                                                        }


                                                        switch (alt86) {
                                                    	case 1 :
                                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5237:1: (lv_argument_38_0= ruleNavigatingCommaArgCS )
                                                    	    {
                                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5237:1: (lv_argument_38_0= ruleNavigatingCommaArgCS )
                                                    	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5238:3: lv_argument_38_0= ruleNavigatingCommaArgCS
                                                    	    {
                                                    	    if ( state.backtracking==0 ) {
                                                    	       
                                                    	      	        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getArgumentNavigatingCommaArgCSParserRuleCall_7_2_2_1_2_3_1_0()); 
                                                    	      	    
                                                    	    }
                                                    	    pushFollow(FollowSets000.FOLLOW_ruleNavigatingCommaArgCS_in_rulePrimaryExpCS11713);
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
                                                    	    break loop86;
                                                        }
                                                    } while (true);


                                                    }
                                                    break;

                                            }


                                            }
                                            break;

                                    }

                                    otherlv_39=(Token)match(input,30,FollowSets000.FOLLOW_30_in_rulePrimaryExpCS11730); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5266:1: entryRuleNavigatingArgCS returns [EObject current=null] : iv_ruleNavigatingArgCS= ruleNavigatingArgCS EOF ;
    public final EObject entryRuleNavigatingArgCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingArgCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5267:2: (iv_ruleNavigatingArgCS= ruleNavigatingArgCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5268:2: iv_ruleNavigatingArgCS= ruleNavigatingArgCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingArgCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgCS_in_entryRuleNavigatingArgCS11771);
            iv_ruleNavigatingArgCS=ruleNavigatingArgCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingArgCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigatingArgCS11781); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5275:1: ruleNavigatingArgCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleNavigatingArgExpCS ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_init_4_0= ruleExpCS ) ) )? )? ) ;
    public final EObject ruleNavigatingArgCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;

        EObject lv_init_4_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5278:28: ( ( ( (lv_name_0_0= ruleNavigatingArgExpCS ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_init_4_0= ruleExpCS ) ) )? )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5279:1: ( ( (lv_name_0_0= ruleNavigatingArgExpCS ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_init_4_0= ruleExpCS ) ) )? )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5279:1: ( ( (lv_name_0_0= ruleNavigatingArgExpCS ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_init_4_0= ruleExpCS ) ) )? )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5279:2: ( (lv_name_0_0= ruleNavigatingArgExpCS ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_init_4_0= ruleExpCS ) ) )? )?
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5279:2: ( (lv_name_0_0= ruleNavigatingArgExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5280:1: (lv_name_0_0= ruleNavigatingArgExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5280:1: (lv_name_0_0= ruleNavigatingArgExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5281:3: lv_name_0_0= ruleNavigatingArgExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getNameNavigatingArgExpCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingArgCS11827);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5297:2: (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_init_4_0= ruleExpCS ) ) )? )?
            int alt93=2;
            int LA93_0 = input.LA(1);

            if ( (LA93_0==32) ) {
                alt93=1;
            }
            switch (alt93) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5297:4: otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_init_4_0= ruleExpCS ) ) )?
                    {
                    otherlv_1=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleNavigatingArgCS11840); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getNavigatingArgCSAccess().getColonKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5301:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5302:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5302:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5303:3: lv_ownedType_2_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleNavigatingArgCS11861);
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

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5319:2: (otherlv_3= '=' ( (lv_init_4_0= ruleExpCS ) ) )?
                    int alt92=2;
                    int LA92_0 = input.LA(1);

                    if ( (LA92_0==49) ) {
                        alt92=1;
                    }
                    switch (alt92) {
                        case 1 :
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5319:4: otherlv_3= '=' ( (lv_init_4_0= ruleExpCS ) )
                            {
                            otherlv_3=(Token)match(input,49,FollowSets000.FOLLOW_49_in_ruleNavigatingArgCS11874); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_3, grammarAccess.getNavigatingArgCSAccess().getEqualsSignKeyword_1_2_0());
                                  
                            }
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5323:1: ( (lv_init_4_0= ruleExpCS ) )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5324:1: (lv_init_4_0= ruleExpCS )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5324:1: (lv_init_4_0= ruleExpCS )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5325:3: lv_init_4_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getInitExpCSParserRuleCall_1_2_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNavigatingArgCS11895);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5349:1: entryRuleNavigatingBarArgCS returns [EObject current=null] : iv_ruleNavigatingBarArgCS= ruleNavigatingBarArgCS EOF ;
    public final EObject entryRuleNavigatingBarArgCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingBarArgCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5350:2: (iv_ruleNavigatingBarArgCS= ruleNavigatingBarArgCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5351:2: iv_ruleNavigatingBarArgCS= ruleNavigatingBarArgCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingBarArgCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingBarArgCS_in_entryRuleNavigatingBarArgCS11935);
            iv_ruleNavigatingBarArgCS=ruleNavigatingBarArgCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingBarArgCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigatingBarArgCS11945); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5358:1: ruleNavigatingBarArgCS returns [EObject current=null] : ( ( (lv_prefix_0_0= '|' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )? ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5361:28: ( ( ( (lv_prefix_0_0= '|' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5362:1: ( ( (lv_prefix_0_0= '|' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5362:1: ( ( (lv_prefix_0_0= '|' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5362:2: ( (lv_prefix_0_0= '|' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )?
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5362:2: ( (lv_prefix_0_0= '|' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5363:1: (lv_prefix_0_0= '|' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5363:1: (lv_prefix_0_0= '|' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5364:3: lv_prefix_0_0= '|'
            {
            lv_prefix_0_0=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleNavigatingBarArgCS11988); if (state.failed) return current;
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5377:2: ( (lv_name_1_0= ruleNavigatingArgExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5378:1: (lv_name_1_0= ruleNavigatingArgExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5378:1: (lv_name_1_0= ruleNavigatingArgExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5379:3: lv_name_1_0= ruleNavigatingArgExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNavigatingBarArgCSAccess().getNameNavigatingArgExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingBarArgCS12022);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5395:2: (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )?
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( (LA95_0==32) ) {
                alt95=1;
            }
            switch (alt95) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5395:4: otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )?
                    {
                    otherlv_2=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleNavigatingBarArgCS12035); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getNavigatingBarArgCSAccess().getColonKeyword_2_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5399:1: ( (lv_ownedType_3_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5400:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5400:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5401:3: lv_ownedType_3_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingBarArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleNavigatingBarArgCS12056);
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

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5417:2: (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )?
                    int alt94=2;
                    int LA94_0 = input.LA(1);

                    if ( (LA94_0==49) ) {
                        alt94=1;
                    }
                    switch (alt94) {
                        case 1 :
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5417:4: otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) )
                            {
                            otherlv_4=(Token)match(input,49,FollowSets000.FOLLOW_49_in_ruleNavigatingBarArgCS12069); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getNavigatingBarArgCSAccess().getEqualsSignKeyword_2_2_0());
                                  
                            }
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5421:1: ( (lv_init_5_0= ruleExpCS ) )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5422:1: (lv_init_5_0= ruleExpCS )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5422:1: (lv_init_5_0= ruleExpCS )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5423:3: lv_init_5_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getNavigatingBarArgCSAccess().getInitExpCSParserRuleCall_2_2_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNavigatingBarArgCS12090);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5447:1: entryRuleNavigatingCommaArgCS returns [EObject current=null] : iv_ruleNavigatingCommaArgCS= ruleNavigatingCommaArgCS EOF ;
    public final EObject entryRuleNavigatingCommaArgCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingCommaArgCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5448:2: (iv_ruleNavigatingCommaArgCS= ruleNavigatingCommaArgCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5449:2: iv_ruleNavigatingCommaArgCS= ruleNavigatingCommaArgCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingCommaArgCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingCommaArgCS_in_entryRuleNavigatingCommaArgCS12130);
            iv_ruleNavigatingCommaArgCS=ruleNavigatingCommaArgCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingCommaArgCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigatingCommaArgCS12140); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5456:1: ruleNavigatingCommaArgCS returns [EObject current=null] : ( ( (lv_prefix_0_0= ',' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )? ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5459:28: ( ( ( (lv_prefix_0_0= ',' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5460:1: ( ( (lv_prefix_0_0= ',' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5460:1: ( ( (lv_prefix_0_0= ',' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5460:2: ( (lv_prefix_0_0= ',' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )?
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5460:2: ( (lv_prefix_0_0= ',' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5461:1: (lv_prefix_0_0= ',' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5461:1: (lv_prefix_0_0= ',' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5462:3: lv_prefix_0_0= ','
            {
            lv_prefix_0_0=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleNavigatingCommaArgCS12183); if (state.failed) return current;
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5475:2: ( (lv_name_1_0= ruleNavigatingArgExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5476:1: (lv_name_1_0= ruleNavigatingArgExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5476:1: (lv_name_1_0= ruleNavigatingArgExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5477:3: lv_name_1_0= ruleNavigatingArgExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getNameNavigatingArgExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingCommaArgCS12217);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5493:2: (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )?
            int alt97=2;
            int LA97_0 = input.LA(1);

            if ( (LA97_0==32) ) {
                alt97=1;
            }
            switch (alt97) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5493:4: otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )?
                    {
                    otherlv_2=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleNavigatingCommaArgCS12230); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getNavigatingCommaArgCSAccess().getColonKeyword_2_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5497:1: ( (lv_ownedType_3_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5498:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5498:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5499:3: lv_ownedType_3_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleNavigatingCommaArgCS12251);
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

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5515:2: (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )?
                    int alt96=2;
                    int LA96_0 = input.LA(1);

                    if ( (LA96_0==49) ) {
                        alt96=1;
                    }
                    switch (alt96) {
                        case 1 :
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5515:4: otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) )
                            {
                            otherlv_4=(Token)match(input,49,FollowSets000.FOLLOW_49_in_ruleNavigatingCommaArgCS12264); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getNavigatingCommaArgCSAccess().getEqualsSignKeyword_2_2_0());
                                  
                            }
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5519:1: ( (lv_init_5_0= ruleExpCS ) )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5520:1: (lv_init_5_0= ruleExpCS )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5520:1: (lv_init_5_0= ruleExpCS )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5521:3: lv_init_5_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getInitExpCSParserRuleCall_2_2_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNavigatingCommaArgCS12285);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5545:1: entryRuleNavigatingSemiArgCS returns [EObject current=null] : iv_ruleNavigatingSemiArgCS= ruleNavigatingSemiArgCS EOF ;
    public final EObject entryRuleNavigatingSemiArgCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingSemiArgCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5546:2: (iv_ruleNavigatingSemiArgCS= ruleNavigatingSemiArgCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5547:2: iv_ruleNavigatingSemiArgCS= ruleNavigatingSemiArgCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingSemiArgCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingSemiArgCS_in_entryRuleNavigatingSemiArgCS12325);
            iv_ruleNavigatingSemiArgCS=ruleNavigatingSemiArgCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingSemiArgCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigatingSemiArgCS12335); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5554:1: ruleNavigatingSemiArgCS returns [EObject current=null] : ( ( (lv_prefix_0_0= ';' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )? ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5557:28: ( ( ( (lv_prefix_0_0= ';' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )? ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5558:1: ( ( (lv_prefix_0_0= ';' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )? )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5558:1: ( ( (lv_prefix_0_0= ';' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )? )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5558:2: ( (lv_prefix_0_0= ';' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )?
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5558:2: ( (lv_prefix_0_0= ';' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5559:1: (lv_prefix_0_0= ';' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5559:1: (lv_prefix_0_0= ';' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5560:3: lv_prefix_0_0= ';'
            {
            lv_prefix_0_0=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleNavigatingSemiArgCS12378); if (state.failed) return current;
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5573:2: ( (lv_name_1_0= ruleNavigatingArgExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5574:1: (lv_name_1_0= ruleNavigatingArgExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5574:1: (lv_name_1_0= ruleNavigatingArgExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5575:3: lv_name_1_0= ruleNavigatingArgExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNavigatingSemiArgCSAccess().getNameNavigatingArgExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingSemiArgCS12412);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5591:2: (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )? )?
            int alt99=2;
            int LA99_0 = input.LA(1);

            if ( (LA99_0==32) ) {
                alt99=1;
            }
            switch (alt99) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5591:4: otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )?
                    {
                    otherlv_2=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleNavigatingSemiArgCS12425); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getNavigatingSemiArgCSAccess().getColonKeyword_2_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5595:1: ( (lv_ownedType_3_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5596:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5596:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5597:3: lv_ownedType_3_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingSemiArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleNavigatingSemiArgCS12446);
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

                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5613:2: (otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) ) )?
                    int alt98=2;
                    int LA98_0 = input.LA(1);

                    if ( (LA98_0==49) ) {
                        alt98=1;
                    }
                    switch (alt98) {
                        case 1 :
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5613:4: otherlv_4= '=' ( (lv_init_5_0= ruleExpCS ) )
                            {
                            otherlv_4=(Token)match(input,49,FollowSets000.FOLLOW_49_in_ruleNavigatingSemiArgCS12459); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getNavigatingSemiArgCSAccess().getEqualsSignKeyword_2_2_0());
                                  
                            }
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5617:1: ( (lv_init_5_0= ruleExpCS ) )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5618:1: (lv_init_5_0= ruleExpCS )
                            {
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5618:1: (lv_init_5_0= ruleExpCS )
                            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5619:3: lv_init_5_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getNavigatingSemiArgCSAccess().getInitExpCSParserRuleCall_2_2_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNavigatingSemiArgCS12480);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5643:1: entryRuleNavigatingArgExpCS returns [EObject current=null] : iv_ruleNavigatingArgExpCS= ruleNavigatingArgExpCS EOF ;
    public final EObject entryRuleNavigatingArgExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingArgExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5644:2: (iv_ruleNavigatingArgExpCS= ruleNavigatingArgExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5645:2: iv_ruleNavigatingArgExpCS= ruleNavigatingArgExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingArgExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgExpCS_in_entryRuleNavigatingArgExpCS12520);
            iv_ruleNavigatingArgExpCS=ruleNavigatingArgExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingArgExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigatingArgExpCS12530); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5652:1: ruleNavigatingArgExpCS returns [EObject current=null] : this_ExpCS_0= ruleExpCS ;
    public final EObject ruleNavigatingArgExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_ExpCS_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5655:28: (this_ExpCS_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5657:2: this_ExpCS_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getNavigatingArgExpCSAccess().getExpCSParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNavigatingArgExpCS12579);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5676:1: entryRuleIfExpCS returns [EObject current=null] : iv_ruleIfExpCS= ruleIfExpCS EOF ;
    public final EObject entryRuleIfExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5677:2: (iv_ruleIfExpCS= ruleIfExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5678:2: iv_ruleIfExpCS= ruleIfExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIfExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIfExpCS_in_entryRuleIfExpCS12613);
            iv_ruleIfExpCS=ruleIfExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIfExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIfExpCS12623); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5685:1: ruleIfExpCS returns [EObject current=null] : (otherlv_0= 'if' ( (lv_condition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_thenExpression_3_0= ruleExpCS ) ) otherlv_4= 'else' ( (lv_elseExpression_5_0= ruleExpCS ) ) otherlv_6= 'endif' ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5688:28: ( (otherlv_0= 'if' ( (lv_condition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_thenExpression_3_0= ruleExpCS ) ) otherlv_4= 'else' ( (lv_elseExpression_5_0= ruleExpCS ) ) otherlv_6= 'endif' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5689:1: (otherlv_0= 'if' ( (lv_condition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_thenExpression_3_0= ruleExpCS ) ) otherlv_4= 'else' ( (lv_elseExpression_5_0= ruleExpCS ) ) otherlv_6= 'endif' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5689:1: (otherlv_0= 'if' ( (lv_condition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_thenExpression_3_0= ruleExpCS ) ) otherlv_4= 'else' ( (lv_elseExpression_5_0= ruleExpCS ) ) otherlv_6= 'endif' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5689:3: otherlv_0= 'if' ( (lv_condition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_thenExpression_3_0= ruleExpCS ) ) otherlv_4= 'else' ( (lv_elseExpression_5_0= ruleExpCS ) ) otherlv_6= 'endif'
            {
            otherlv_0=(Token)match(input,81,FollowSets000.FOLLOW_81_in_ruleIfExpCS12660); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getIfExpCSAccess().getIfKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5693:1: ( (lv_condition_1_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5694:1: (lv_condition_1_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5694:1: (lv_condition_1_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5695:3: lv_condition_1_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIfExpCSAccess().getConditionExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleIfExpCS12681);
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

            otherlv_2=(Token)match(input,82,FollowSets000.FOLLOW_82_in_ruleIfExpCS12693); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getIfExpCSAccess().getThenKeyword_2());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5715:1: ( (lv_thenExpression_3_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5716:1: (lv_thenExpression_3_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5716:1: (lv_thenExpression_3_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5717:3: lv_thenExpression_3_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIfExpCSAccess().getThenExpressionExpCSParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleIfExpCS12714);
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

            otherlv_4=(Token)match(input,83,FollowSets000.FOLLOW_83_in_ruleIfExpCS12726); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getIfExpCSAccess().getElseKeyword_4());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5737:1: ( (lv_elseExpression_5_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5738:1: (lv_elseExpression_5_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5738:1: (lv_elseExpression_5_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5739:3: lv_elseExpression_5_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIfExpCSAccess().getElseExpressionExpCSParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleIfExpCS12747);
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

            otherlv_6=(Token)match(input,84,FollowSets000.FOLLOW_84_in_ruleIfExpCS12759); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5767:1: entryRuleLetExpCS returns [EObject current=null] : iv_ruleLetExpCS= ruleLetExpCS EOF ;
    public final EObject entryRuleLetExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLetExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5768:2: (iv_ruleLetExpCS= ruleLetExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5769:2: iv_ruleLetExpCS= ruleLetExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLetExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLetExpCS_in_entryRuleLetExpCS12795);
            iv_ruleLetExpCS=ruleLetExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLetExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLetExpCS12805); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5776:1: ruleLetExpCS returns [EObject current=null] : (otherlv_0= 'let' ( (lv_variable_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_variable_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_in_5_0= ruleExpCS ) ) ) ;
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
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5779:28: ( (otherlv_0= 'let' ( (lv_variable_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_variable_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_in_5_0= ruleExpCS ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5780:1: (otherlv_0= 'let' ( (lv_variable_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_variable_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_in_5_0= ruleExpCS ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5780:1: (otherlv_0= 'let' ( (lv_variable_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_variable_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_in_5_0= ruleExpCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5780:3: otherlv_0= 'let' ( (lv_variable_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_variable_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_in_5_0= ruleExpCS ) )
            {
            otherlv_0=(Token)match(input,85,FollowSets000.FOLLOW_85_in_ruleLetExpCS12842); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLetExpCSAccess().getLetKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5784:1: ( (lv_variable_1_0= ruleLetVariableCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5785:1: (lv_variable_1_0= ruleLetVariableCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5785:1: (lv_variable_1_0= ruleLetVariableCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5786:3: lv_variable_1_0= ruleLetVariableCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetExpCSAccess().getVariableLetVariableCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleLetVariableCS_in_ruleLetExpCS12863);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5802:2: (otherlv_2= ',' ( (lv_variable_3_0= ruleLetVariableCS ) ) )*
            loop100:
            do {
                int alt100=2;
                int LA100_0 = input.LA(1);

                if ( (LA100_0==24) ) {
                    alt100=1;
                }


                switch (alt100) {
            	case 1 :
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5802:4: otherlv_2= ',' ( (lv_variable_3_0= ruleLetVariableCS ) )
            	    {
            	    otherlv_2=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleLetExpCS12876); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getLetExpCSAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5806:1: ( (lv_variable_3_0= ruleLetVariableCS ) )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5807:1: (lv_variable_3_0= ruleLetVariableCS )
            	    {
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5807:1: (lv_variable_3_0= ruleLetVariableCS )
            	    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5808:3: lv_variable_3_0= ruleLetVariableCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLetExpCSAccess().getVariableLetVariableCSParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleLetVariableCS_in_ruleLetExpCS12897);
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
            	    break loop100;
                }
            } while (true);

            otherlv_4=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleLetExpCS12911); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getLetExpCSAccess().getInKeyword_3());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5828:1: ( (lv_in_5_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5829:1: (lv_in_5_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5829:1: (lv_in_5_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5830:3: lv_in_5_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetExpCSAccess().getInExpCSParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleLetExpCS12932);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5854:1: entryRuleLetVariableCS returns [EObject current=null] : iv_ruleLetVariableCS= ruleLetVariableCS EOF ;
    public final EObject entryRuleLetVariableCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLetVariableCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5855:2: (iv_ruleLetVariableCS= ruleLetVariableCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5856:2: iv_ruleLetVariableCS= ruleLetVariableCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLetVariableCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLetVariableCS_in_entryRuleLetVariableCS12968);
            iv_ruleLetVariableCS=ruleLetVariableCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLetVariableCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLetVariableCS12978); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5863:1: ruleLetVariableCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) ) ) ;
    public final EObject ruleLetVariableCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;

        EObject lv_initExpression_4_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5866:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5867:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5867:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5867:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpCS ) )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5867:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5868:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5868:1: (lv_name_0_0= ruleUnrestrictedName )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5869:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetVariableCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleLetVariableCS13024);
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

            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5885:2: (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )?
            int alt101=2;
            int LA101_0 = input.LA(1);

            if ( (LA101_0==32) ) {
                alt101=1;
            }
            switch (alt101) {
                case 1 :
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5885:4: otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                    {
                    otherlv_1=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleLetVariableCS13037); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getLetVariableCSAccess().getColonKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5889:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5890:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5890:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5891:3: lv_ownedType_2_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLetVariableCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleLetVariableCS13058);
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

            otherlv_3=(Token)match(input,49,FollowSets000.FOLLOW_49_in_ruleLetVariableCS13072); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getLetVariableCSAccess().getEqualsSignKeyword_2());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5911:1: ( (lv_initExpression_4_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5912:1: (lv_initExpression_4_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5912:1: (lv_initExpression_4_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5913:3: lv_initExpression_4_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetVariableCSAccess().getInitExpressionExpCSParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleLetVariableCS13093);
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5937:1: entryRuleNestedExpCS returns [EObject current=null] : iv_ruleNestedExpCS= ruleNestedExpCS EOF ;
    public final EObject entryRuleNestedExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNestedExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5938:2: (iv_ruleNestedExpCS= ruleNestedExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5939:2: iv_ruleNestedExpCS= ruleNestedExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNestedExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNestedExpCS_in_entryRuleNestedExpCS13129);
            iv_ruleNestedExpCS=ruleNestedExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNestedExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNestedExpCS13139); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5946:1: ruleNestedExpCS returns [EObject current=null] : (otherlv_0= '(' ( (lv_source_1_0= ruleExpCS ) ) otherlv_2= ')' ) ;
    public final EObject ruleNestedExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_source_1_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5949:28: ( (otherlv_0= '(' ( (lv_source_1_0= ruleExpCS ) ) otherlv_2= ')' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5950:1: (otherlv_0= '(' ( (lv_source_1_0= ruleExpCS ) ) otherlv_2= ')' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5950:1: (otherlv_0= '(' ( (lv_source_1_0= ruleExpCS ) ) otherlv_2= ')' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5950:3: otherlv_0= '(' ( (lv_source_1_0= ruleExpCS ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleNestedExpCS13176); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getNestedExpCSAccess().getLeftParenthesisKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5954:1: ( (lv_source_1_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5955:1: (lv_source_1_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5955:1: (lv_source_1_0= ruleExpCS )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5956:3: lv_source_1_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNestedExpCSAccess().getSourceExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNestedExpCS13197);
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

            otherlv_2=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleNestedExpCS13209); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5984:1: entryRuleSelfExpCS returns [EObject current=null] : iv_ruleSelfExpCS= ruleSelfExpCS EOF ;
    public final EObject entryRuleSelfExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelfExpCS = null;


        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5985:2: (iv_ruleSelfExpCS= ruleSelfExpCS EOF )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5986:2: iv_ruleSelfExpCS= ruleSelfExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSelfExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSelfExpCS_in_entryRuleSelfExpCS13245);
            iv_ruleSelfExpCS=ruleSelfExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSelfExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSelfExpCS13255); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5993:1: ruleSelfExpCS returns [EObject current=null] : ( () otherlv_1= 'self' ) ;
    public final EObject ruleSelfExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5996:28: ( ( () otherlv_1= 'self' ) )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5997:1: ( () otherlv_1= 'self' )
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5997:1: ( () otherlv_1= 'self' )
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5997:2: () otherlv_1= 'self'
            {
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5997:2: ()
            // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:5998:2: 
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

            otherlv_1=(Token)match(input,86,FollowSets000.FOLLOW_86_in_ruleSelfExpCS13304); if (state.failed) return current;
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

    // $ANTLR start synpred123_InternalQVTimperative
    public final void synpred123_InternalQVTimperative_fragment() throws RecognitionException {   
        EObject this_TupleLiteralExpCS_4 = null;


        // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4847:2: (this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS )
        // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4847:2: this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralExpCS_in_synpred123_InternalQVTimperative11045);
        this_TupleLiteralExpCS_4=ruleTupleLiteralExpCS();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred123_InternalQVTimperative

    // $ANTLR start synpred124_InternalQVTimperative
    public final void synpred124_InternalQVTimperative_fragment() throws RecognitionException {   
        EObject this_CollectionLiteralExpCS_5 = null;


        // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4860:2: (this_CollectionLiteralExpCS_5= ruleCollectionLiteralExpCS )
        // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4860:2: this_CollectionLiteralExpCS_5= ruleCollectionLiteralExpCS
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteralExpCS_in_synpred124_InternalQVTimperative11075);
        this_CollectionLiteralExpCS_5=ruleCollectionLiteralExpCS();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred124_InternalQVTimperative

    // $ANTLR start synpred125_InternalQVTimperative
    public final void synpred125_InternalQVTimperative_fragment() throws RecognitionException {   
        EObject this_TypeLiteralExpCS_6 = null;


        // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4873:2: (this_TypeLiteralExpCS_6= ruleTypeLiteralExpCS )
        // ../../plugins/org.eclipse.qvtd.xtext.qvtimperative/src-gen/org/eclipse/qvtd/xtext/qvtimperative/parser/antlr/internal/InternalQVTimperative.g:4873:2: this_TypeLiteralExpCS_6= ruleTypeLiteralExpCS
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralExpCS_in_synpred125_InternalQVTimperative11105);
        this_TypeLiteralExpCS_6=ruleTypeLiteralExpCS();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred125_InternalQVTimperative

    // Delegated rules

    public final boolean synpred125_InternalQVTimperative() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred125_InternalQVTimperative_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred124_InternalQVTimperative() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred124_InternalQVTimperative_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred123_InternalQVTimperative() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred123_InternalQVTimperative_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA14 dfa14 = new DFA14(this);
    protected DFA17 dfa17 = new DFA17(this);
    protected DFA25 dfa25 = new DFA25(this);
    protected DFA33 dfa33 = new DFA33(this);
    protected DFA34 dfa34 = new DFA34(this);
    protected DFA73 dfa73 = new DFA73(this);
    protected DFA68 dfa68 = new DFA68(this);
    protected DFA91 dfa91 = new DFA91(this);
    static final String DFA14_eotS =
        "\21\uffff";
    static final String DFA14_eofS =
        "\21\uffff";
    static final String DFA14_minS =
        "\1\22\1\4\1\uffff\11\22\1\4\3\22\1\uffff";
    static final String DFA14_maxS =
        "\1\22\1\126\1\uffff\15\117\1\uffff";
    static final String DFA14_acceptS =
        "\2\uffff\1\2\15\uffff\1\1";
    static final String DFA14_specialS =
        "\21\uffff}>";
    static final String[] DFA14_transitionS = {
            "\1\1",
            "\1\3\1\4\2\2\10\uffff\1\12\3\uffff\1\2\5\uffff\1\2\1\10\1"+
            "\17\1\2\1\uffff\1\7\2\uffff\1\2\1\11\1\5\1\6\1\13\1\16\1\14"+
            "\1\15\2\2\15\uffff\16\2\4\uffff\4\2\2\uffff\1\2\3\uffff\2\2",
            "",
            "\1\2\2\uffff\3\2\5\uffff\1\2\2\uffff\1\20\2\2\7\uffff\1\2"+
            "\1\uffff\15\2\17\uffff\1\2\6\uffff\1\2",
            "\1\2\2\uffff\3\2\5\uffff\1\2\2\uffff\1\20\2\2\7\uffff\1\2"+
            "\1\uffff\15\2\17\uffff\1\2\6\uffff\1\2",
            "\1\2\2\uffff\3\2\5\uffff\1\2\2\uffff\1\20\2\2\7\uffff\1\2"+
            "\1\uffff\15\2\17\uffff\1\2\6\uffff\1\2",
            "\1\2\2\uffff\3\2\5\uffff\1\2\2\uffff\1\20\2\2\7\uffff\1\2"+
            "\1\uffff\15\2\17\uffff\1\2\6\uffff\1\2",
            "\1\2\2\uffff\3\2\5\uffff\1\2\2\uffff\1\20\2\2\7\uffff\1\2"+
            "\1\uffff\15\2\17\uffff\1\2\6\uffff\1\2",
            "\1\2\2\uffff\3\2\5\uffff\1\2\2\uffff\1\20\2\2\7\uffff\1\2"+
            "\1\uffff\15\2\17\uffff\1\2\6\uffff\1\2",
            "\1\2\2\uffff\3\2\5\uffff\1\2\2\uffff\1\20\2\2\7\uffff\1\2"+
            "\1\uffff\15\2\17\uffff\1\2\6\uffff\1\2",
            "\1\2\2\uffff\3\2\5\uffff\1\2\2\uffff\1\20\2\2\7\uffff\1\2"+
            "\1\uffff\15\2\17\uffff\1\2\6\uffff\1\2",
            "\1\2\2\uffff\3\2\5\uffff\1\2\2\uffff\1\20\2\2\7\uffff\1\2"+
            "\1\uffff\15\2\17\uffff\1\2\6\uffff\1\2",
            "\2\20\12\uffff\1\20\1\uffff\1\2\2\uffff\3\2\3\uffff\2\20\1"+
            "\2\1\uffff\2\20\2\2\7\20\1\2\1\uffff\15\2\17\uffff\1\2\6\uffff"+
            "\1\2",
            "\1\2\2\uffff\3\2\5\uffff\1\2\2\uffff\1\20\2\2\7\uffff\1\2"+
            "\1\uffff\15\2\17\uffff\1\2\6\uffff\1\2",
            "\1\2\2\uffff\3\2\5\uffff\1\2\2\uffff\1\20\2\2\7\uffff\1\2"+
            "\1\uffff\15\2\17\uffff\1\2\6\uffff\1\2",
            "\1\2\2\uffff\3\2\5\uffff\1\2\2\uffff\1\20\2\2\7\uffff\1\2"+
            "\1\uffff\15\2\17\uffff\1\2\6\uffff\1\2",
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
            return "499:1: ( (otherlv_0= '{' ( ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_2_0= ruleRealizedVariableCS ) ) ) (otherlv_3= ',' ( ( (lv_unrealizedVariables_4_0= ruleUnrealizedVariableCS ) ) | ( (lv_realizedVariables_5_0= ruleRealizedVariableCS ) ) ) )* otherlv_6= '|' ( (lv_constraints_7_0= ruleAssignmentCS ) )* otherlv_8= '}' ) | ( () otherlv_10= '{' ( (lv_constraints_11_0= ruleAssignmentCS ) )* otherlv_12= '}' ) )";
        }
    }
    static final String DFA17_eotS =
        "\13\uffff";
    static final String DFA17_eofS =
        "\1\4\1\uffff\2\1\1\uffff\4\4\2\1";
    static final String DFA17_minS =
        "\1\4\1\uffff\2\4\1\uffff\6\4";
    static final String DFA17_maxS =
        "\1\51\1\uffff\2\51\1\uffff\6\51";
    static final String DFA17_acceptS =
        "\1\uffff\1\1\2\uffff\1\2\6\uffff";
    static final String DFA17_specialS =
        "\13\uffff}>";
    static final String[] DFA17_transitionS = {
            "\2\1\12\uffff\1\1\6\uffff\1\4\3\uffff\1\2\1\3\2\uffff\1\1\3"+
            "\uffff\7\1",
            "",
            "\2\4\12\uffff\1\4\6\uffff\1\1\3\uffff\1\5\1\6\2\uffff\1\4"+
            "\3\uffff\7\4",
            "\2\4\12\uffff\1\4\6\uffff\1\1\3\uffff\1\7\1\10\2\uffff\1\4"+
            "\3\uffff\7\4",
            "",
            "\2\1\12\uffff\1\1\6\uffff\2\4\2\uffff\1\1\1\11\2\uffff\1\1"+
            "\3\uffff\7\1",
            "\2\1\12\uffff\1\1\6\uffff\2\4\2\uffff\1\1\1\12\2\uffff\1\1"+
            "\3\uffff\7\1",
            "\2\1\12\uffff\1\1\6\uffff\2\4\2\uffff\2\1\2\uffff\1\1\3\uffff"+
            "\7\1",
            "\2\1\12\uffff\1\1\6\uffff\2\4\2\uffff\2\1\2\uffff\1\1\3\uffff"+
            "\7\1",
            "\2\4\12\uffff\1\4\6\uffff\2\1\2\uffff\1\4\1\10\2\uffff\1\4"+
            "\3\uffff\7\4",
            "\2\4\12\uffff\1\4\6\uffff\2\1\2\uffff\2\4\2\uffff\1\4\3\uffff"+
            "\7\4"
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
            return "753:2: ( (lv_name_1_0= ruleUnrestrictedName ) )?";
        }
    }
    static final String DFA25_eotS =
        "\21\uffff";
    static final String DFA25_eofS =
        "\21\uffff";
    static final String DFA25_minS =
        "\1\35\1\4\1\uffff\15\22\1\uffff";
    static final String DFA25_maxS =
        "\1\35\1\126\1\uffff\15\117\1\uffff";
    static final String DFA25_acceptS =
        "\2\uffff\1\2\15\uffff\1\1";
    static final String DFA25_specialS =
        "\21\uffff}>";
    static final String[] DFA25_transitionS = {
            "\1\1",
            "\1\3\1\4\2\2\10\uffff\1\12\11\uffff\1\2\1\10\1\17\2\2\1\7"+
            "\2\uffff\1\2\1\11\1\5\1\6\1\13\1\16\1\14\1\15\2\2\15\uffff\16"+
            "\2\4\uffff\4\2\2\uffff\1\2\3\uffff\2\2",
            "",
            "\1\2\2\uffff\3\2\5\uffff\1\2\2\uffff\1\20\2\2\7\uffff\1\2"+
            "\1\uffff\15\2\17\uffff\1\2\6\uffff\1\2",
            "\1\2\2\uffff\3\2\5\uffff\1\2\2\uffff\1\20\2\2\7\uffff\1\2"+
            "\1\uffff\15\2\17\uffff\1\2\6\uffff\1\2",
            "\1\2\2\uffff\3\2\5\uffff\1\2\2\uffff\1\20\2\2\7\uffff\1\2"+
            "\1\uffff\15\2\17\uffff\1\2\6\uffff\1\2",
            "\1\2\2\uffff\3\2\5\uffff\1\2\2\uffff\1\20\2\2\7\uffff\1\2"+
            "\1\uffff\15\2\17\uffff\1\2\6\uffff\1\2",
            "\1\2\2\uffff\3\2\5\uffff\1\2\2\uffff\1\20\2\2\7\uffff\1\2"+
            "\1\uffff\15\2\17\uffff\1\2\6\uffff\1\2",
            "\1\2\2\uffff\3\2\5\uffff\1\2\2\uffff\1\20\2\2\7\uffff\1\2"+
            "\1\uffff\15\2\17\uffff\1\2\6\uffff\1\2",
            "\1\2\2\uffff\3\2\5\uffff\1\2\2\uffff\1\20\2\2\7\uffff\1\2"+
            "\1\uffff\15\2\17\uffff\1\2\6\uffff\1\2",
            "\1\2\2\uffff\3\2\5\uffff\1\2\2\uffff\1\20\2\2\7\uffff\1\2"+
            "\1\uffff\15\2\17\uffff\1\2\6\uffff\1\2",
            "\1\2\2\uffff\3\2\5\uffff\1\2\2\uffff\1\20\2\2\7\uffff\1\2"+
            "\1\uffff\15\2\17\uffff\1\2\6\uffff\1\2",
            "\1\2\2\uffff\3\2\5\uffff\1\2\2\uffff\1\20\2\2\7\uffff\1\2"+
            "\1\uffff\15\2\17\uffff\1\2\6\uffff\1\2",
            "\1\2\2\uffff\3\2\5\uffff\1\2\2\uffff\1\20\2\2\7\uffff\1\2"+
            "\1\uffff\15\2\17\uffff\1\2\6\uffff\1\2",
            "\1\2\2\uffff\3\2\5\uffff\1\2\2\uffff\1\20\2\2\7\uffff\1\2"+
            "\1\uffff\15\2\17\uffff\1\2\6\uffff\1\2",
            "\1\2\2\uffff\3\2\5\uffff\1\2\2\uffff\1\20\2\2\7\uffff\1\2"+
            "\1\uffff\15\2\17\uffff\1\2\6\uffff\1\2",
            ""
    };

    static final short[] DFA25_eot = DFA.unpackEncodedString(DFA25_eotS);
    static final short[] DFA25_eof = DFA.unpackEncodedString(DFA25_eofS);
    static final char[] DFA25_min = DFA.unpackEncodedStringToUnsignedChars(DFA25_minS);
    static final char[] DFA25_max = DFA.unpackEncodedStringToUnsignedChars(DFA25_maxS);
    static final short[] DFA25_accept = DFA.unpackEncodedString(DFA25_acceptS);
    static final short[] DFA25_special = DFA.unpackEncodedString(DFA25_specialS);
    static final short[][] DFA25_transition;

    static {
        int numStates = DFA25_transitionS.length;
        DFA25_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA25_transition[i] = DFA.unpackEncodedString(DFA25_transitionS[i]);
        }
    }

    class DFA25 extends DFA {

        public DFA25(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 25;
            this.eot = DFA25_eot;
            this.eof = DFA25_eof;
            this.min = DFA25_min;
            this.max = DFA25_max;
            this.accept = DFA25_accept;
            this.special = DFA25_special;
            this.transition = DFA25_transition;
        }
        public String getDescription() {
            return "880:1: ( (otherlv_0= '(' ( (lv_unrealizedVariables_1_0= ruleUnrealizedVariableCS ) ) (otherlv_2= ',' ( (lv_unrealizedVariables_3_0= ruleUnrealizedVariableCS ) ) )* otherlv_4= '|' ( (lv_constraints_5_0= ruleAssignmentCS ) )* otherlv_6= ')' ) | ( () otherlv_8= '(' ( (lv_constraints_9_0= ruleAssignmentCS ) )* otherlv_10= ')' ) )";
        }
    }
    static final String DFA33_eotS =
        "\36\uffff";
    static final String DFA33_eofS =
        "\1\16\35\uffff";
    static final String DFA33_minS =
        "\1\4\15\22\1\uffff\16\22\1\uffff";
    static final String DFA33_maxS =
        "\1\106\15\41\1\uffff\16\41\1\uffff";
    static final String DFA33_acceptS =
        "\16\uffff\1\2\16\uffff\1\1";
    static final String DFA33_specialS =
        "\36\uffff}>";
    static final String[] DFA33_transitionS = {
            "\1\1\1\2\12\uffff\1\10\12\uffff\1\6\1\15\2\uffff\1\5\3\uffff"+
            "\1\7\1\3\1\4\1\11\1\14\1\12\1\13\17\uffff\1\34\1\24\1\25\1\26"+
            "\1\27\1\30\1\31\1\32\1\33\1\17\1\20\1\21\1\22\1\23",
            "\1\16\12\uffff\1\16\3\uffff\1\35",
            "\1\16\12\uffff\1\16\3\uffff\1\35",
            "\1\16\12\uffff\1\16\3\uffff\1\35",
            "\1\16\12\uffff\1\16\3\uffff\1\35",
            "\1\16\12\uffff\1\16\3\uffff\1\35",
            "\1\16\12\uffff\1\16\3\uffff\1\35",
            "\1\16\12\uffff\1\16\3\uffff\1\35",
            "\1\16\12\uffff\1\16\3\uffff\1\35",
            "\1\16\12\uffff\1\16\3\uffff\1\35",
            "\1\16\12\uffff\1\16\3\uffff\1\35",
            "\1\16\12\uffff\1\16\3\uffff\1\35",
            "\1\16\12\uffff\1\16\3\uffff\1\35",
            "\1\16\12\uffff\1\16\3\uffff\1\35",
            "",
            "\1\16\16\uffff\1\35",
            "\1\16\16\uffff\1\35",
            "\1\16\16\uffff\1\35",
            "\1\16\16\uffff\1\35",
            "\1\16\16\uffff\1\35",
            "\1\16\16\uffff\1\35",
            "\1\16\16\uffff\1\35",
            "\1\16\16\uffff\1\35",
            "\1\16\16\uffff\1\35",
            "\1\16\16\uffff\1\35",
            "\1\16\16\uffff\1\35",
            "\1\16\16\uffff\1\35",
            "\1\16\16\uffff\1\35",
            "\1\16\16\uffff\1\35",
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
            return "()* loopback of 1492:1: ( ( (lv_path_2_0= ruleNextPathElementCS ) ) otherlv_3= '::' )*";
        }
    }
    static final String DFA34_eotS =
        "\20\uffff";
    static final String DFA34_eofS =
        "\20\uffff";
    static final String DFA34_minS =
        "\1\4\15\22\2\uffff";
    static final String DFA34_maxS =
        "\1\106\15\41\2\uffff";
    static final String DFA34_acceptS =
        "\16\uffff\1\2\1\1";
    static final String DFA34_specialS =
        "\20\uffff}>";
    static final String[] DFA34_transitionS = {
            "\1\1\1\2\12\uffff\1\10\12\uffff\1\6\1\15\2\uffff\1\5\3\uffff"+
            "\1\7\1\3\1\4\1\11\1\14\1\12\1\13\17\uffff\16\16",
            "\1\16\16\uffff\1\17",
            "\1\16\16\uffff\1\17",
            "\1\16\16\uffff\1\17",
            "\1\16\16\uffff\1\17",
            "\1\16\16\uffff\1\17",
            "\1\16\16\uffff\1\17",
            "\1\16\16\uffff\1\17",
            "\1\16\16\uffff\1\17",
            "\1\16\16\uffff\1\17",
            "\1\16\16\uffff\1\17",
            "\1\16\16\uffff\1\17",
            "\1\16\16\uffff\1\17",
            "\1\16\16\uffff\1\17",
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
            return "1539:1: ( (lv_pathName_1_0= ruleScopeNameCS ) )?";
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
            "\4\3\10\uffff\1\3\12\uffff\3\3\1\uffff\1\3\2\uffff\10\3\1\1"+
            "\1\2\15\uffff\16\3\4\uffff\4\3\2\uffff\1\3\3\uffff\1\4\1\3",
            "\4\3\10\uffff\1\3\12\uffff\3\3\1\uffff\1\3\2\uffff\10\3\1"+
            "\1\1\2\15\uffff\16\3\4\uffff\4\3\2\uffff\1\3\3\uffff\1\5\1\3",
            "\4\3\10\uffff\1\3\12\uffff\3\3\1\uffff\1\3\2\uffff\10\3\1"+
            "\1\1\2\15\uffff\16\3\4\uffff\4\3\2\uffff\1\3\3\uffff\1\5\1\3",
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
            return "4487:1: ( (this_PrefixedExpCS_0= rulePrefixedExpCS ( () ( (lv_ownedOperator_2_0= ruleBinaryOperatorCS ) ) ( ( ( (lv_ownedExpression_3_0= rulePrefixedExpCS ) ) ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )* ( ( (lv_ownedOperator_6_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_7_0= ruleLetExpCS ) ) )? ) | ( (lv_ownedExpression_8_0= ruleLetExpCS ) ) ) )? ) | ( () ( (lv_ownedOperator_10_0= ruleUnaryOperatorCS ) )+ ( (lv_ownedExpression_11_0= ruleLetExpCS ) ) ) | this_LetExpCS_12= ruleLetExpCS )";
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
            "\1\21\2\uffff\2\21\1\10\3\21\4\uffff\1\21\1\uffff\1\21\1\uffff"+
            "\1\1\7\uffff\1\4\1\uffff\1\2\1\3\1\5\1\6\1\7\1\11\1\12\1\13"+
            "\1\14\1\15\1\16\1\17\1\20\16\uffff\1\21\1\uffff\1\21\10\uffff"+
            "\3\21",
            "\4\22\10\uffff\1\22\12\uffff\3\22\1\uffff\1\22\2\uffff\12"+
            "\22\15\uffff\16\22\4\uffff\4\22\2\uffff\1\22\3\uffff\1\21\1"+
            "\22",
            "\4\22\10\uffff\1\22\12\uffff\3\22\1\uffff\1\22\2\uffff\12"+
            "\22\15\uffff\16\22\4\uffff\4\22\2\uffff\1\22\3\uffff\1\21\1"+
            "\22",
            "\4\22\10\uffff\1\22\12\uffff\3\22\1\uffff\1\22\2\uffff\12"+
            "\22\15\uffff\16\22\4\uffff\4\22\2\uffff\1\22\3\uffff\1\21\1"+
            "\22",
            "\4\22\10\uffff\1\22\12\uffff\3\22\1\uffff\1\22\2\uffff\12"+
            "\22\15\uffff\16\22\4\uffff\4\22\2\uffff\1\22\3\uffff\1\21\1"+
            "\22",
            "\4\22\10\uffff\1\22\12\uffff\3\22\1\uffff\1\22\2\uffff\12"+
            "\22\15\uffff\16\22\4\uffff\4\22\2\uffff\1\22\3\uffff\1\21\1"+
            "\22",
            "\4\22\10\uffff\1\22\12\uffff\3\22\1\uffff\1\22\2\uffff\12"+
            "\22\15\uffff\16\22\4\uffff\4\22\2\uffff\1\22\3\uffff\1\21\1"+
            "\22",
            "\4\22\10\uffff\1\22\12\uffff\3\22\1\uffff\1\22\2\uffff\12"+
            "\22\15\uffff\16\22\4\uffff\4\22\2\uffff\1\22\3\uffff\1\21\1"+
            "\22",
            "\4\22\10\uffff\1\22\12\uffff\3\22\1\uffff\1\22\2\uffff\12"+
            "\22\15\uffff\16\22\4\uffff\4\22\2\uffff\1\22\3\uffff\1\21\1"+
            "\22",
            "\4\22\10\uffff\1\22\12\uffff\3\22\1\uffff\1\22\2\uffff\12"+
            "\22\15\uffff\16\22\4\uffff\4\22\2\uffff\1\22\3\uffff\1\21\1"+
            "\22",
            "\4\22\10\uffff\1\22\12\uffff\3\22\1\uffff\1\22\2\uffff\12"+
            "\22\15\uffff\16\22\4\uffff\4\22\2\uffff\1\22\3\uffff\1\21\1"+
            "\22",
            "\4\22\10\uffff\1\22\12\uffff\3\22\1\uffff\1\22\2\uffff\12"+
            "\22\15\uffff\16\22\4\uffff\4\22\2\uffff\1\22\3\uffff\1\21\1"+
            "\22",
            "\4\22\10\uffff\1\22\12\uffff\3\22\1\uffff\1\22\2\uffff\12"+
            "\22\15\uffff\16\22\4\uffff\4\22\2\uffff\1\22\3\uffff\1\21\1"+
            "\22",
            "\4\22\10\uffff\1\22\12\uffff\3\22\1\uffff\1\22\2\uffff\12"+
            "\22\15\uffff\16\22\4\uffff\4\22\2\uffff\1\22\3\uffff\1\21\1"+
            "\22",
            "\4\22\10\uffff\1\22\12\uffff\3\22\1\uffff\1\22\2\uffff\12"+
            "\22\15\uffff\16\22\4\uffff\4\22\2\uffff\1\22\3\uffff\1\21\1"+
            "\22",
            "\4\22\10\uffff\1\22\12\uffff\3\22\1\uffff\1\22\2\uffff\12"+
            "\22\15\uffff\16\22\4\uffff\4\22\2\uffff\1\22\3\uffff\1\21\1"+
            "\22",
            "\4\22\10\uffff\1\22\12\uffff\3\22\1\uffff\1\22\2\uffff\12"+
            "\22\15\uffff\16\22\4\uffff\4\22\2\uffff\1\22\3\uffff\1\21\1"+
            "\22",
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
            return "()* loopback of 4544:2: ( ( (lv_ownedOperator_4_0= ruleBinaryOperatorCS ) ) ( (lv_ownedExpression_5_0= rulePrefixedExpCS ) ) )*";
        }
    }
    static final String DFA91_eotS =
        "\50\uffff";
    static final String DFA91_eofS =
        "\50\uffff";
    static final String DFA91_minS =
        "\1\4\12\uffff\6\0\27\uffff";
    static final String DFA91_maxS =
        "\1\126\12\uffff\6\0\27\uffff";
    static final String DFA91_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\14\uffff\1\7\7\uffff\1\10\14\uffff\1\5"+
        "\1\6";
    static final String DFA91_specialS =
        "\13\uffff\1\0\1\1\1\2\1\3\1\4\1\5\27\uffff}>";
    static final String[] DFA91_transitionS = {
            "\2\31\2\4\10\uffff\1\31\12\uffff\2\31\1\1\1\uffff\1\31\2\uffff"+
            "\1\4\7\31\17\uffff\1\13\10\21\1\14\1\15\1\16\1\17\1\20\4\uffff"+
            "\4\4\2\uffff\1\2\4\uffff\1\3",
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

    static final short[] DFA91_eot = DFA.unpackEncodedString(DFA91_eotS);
    static final short[] DFA91_eof = DFA.unpackEncodedString(DFA91_eofS);
    static final char[] DFA91_min = DFA.unpackEncodedStringToUnsignedChars(DFA91_minS);
    static final char[] DFA91_max = DFA.unpackEncodedStringToUnsignedChars(DFA91_maxS);
    static final short[] DFA91_accept = DFA.unpackEncodedString(DFA91_acceptS);
    static final short[] DFA91_special = DFA.unpackEncodedString(DFA91_specialS);
    static final short[][] DFA91_transition;

    static {
        int numStates = DFA91_transitionS.length;
        DFA91_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA91_transition[i] = DFA.unpackEncodedString(DFA91_transitionS[i]);
        }
    }

    class DFA91 extends DFA {

        public DFA91(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 91;
            this.eot = DFA91_eot;
            this.eof = DFA91_eof;
            this.min = DFA91_min;
            this.max = DFA91_max;
            this.accept = DFA91_accept;
            this.special = DFA91_special;
            this.transition = DFA91_transition;
        }
        public String getDescription() {
            return "4794:1: (this_NestedExpCS_0= ruleNestedExpCS | this_IfExpCS_1= ruleIfExpCS | this_SelfExpCS_2= ruleSelfExpCS | this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS | this_CollectionLiteralExpCS_5= ruleCollectionLiteralExpCS | this_TypeLiteralExpCS_6= ruleTypeLiteralExpCS | ( () ( (lv_pathName_8_0= rulePathNameCS ) ) ( ( () otherlv_10= '[' ( (lv_firstIndexes_11_0= ruleExpCS ) ) (otherlv_12= ',' ( (lv_firstIndexes_13_0= ruleExpCS ) ) )* otherlv_14= ']' (otherlv_15= '[' ( (lv_secondIndexes_16_0= ruleExpCS ) ) (otherlv_17= ',' ( (lv_secondIndexes_18_0= ruleExpCS ) ) )* otherlv_19= ']' )? ( ( (lv_atPre_20_0= '@' ) ) otherlv_21= 'pre' )? ) | ( () otherlv_23= '{' ( ( ( (lv_ownedParts_24_0= ruleConstructorPartCS ) ) (otherlv_25= ',' ( (lv_ownedParts_26_0= ruleConstructorPartCS ) ) )* ) | ( (lv_value_27_0= ruleStringLiteral ) ) ) otherlv_28= '}' ) | ( ( ( (lv_atPre_29_0= '@' ) ) otherlv_30= 'pre' )? ( () otherlv_32= '(' ( ( (lv_argument_33_0= ruleNavigatingArgCS ) ) ( (lv_argument_34_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_argument_35_0= ruleNavigatingSemiArgCS ) ) ( (lv_argument_36_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_argument_37_0= ruleNavigatingBarArgCS ) ) ( (lv_argument_38_0= ruleNavigatingCommaArgCS ) )* )? )? otherlv_39= ')' )? ) ) ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA91_11 = input.LA(1);

                         
                        int index91_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred123_InternalQVTimperative()) ) {s = 38;}

                        else if ( (synpred125_InternalQVTimperative()) ) {s = 17;}

                         
                        input.seek(index91_11);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA91_12 = input.LA(1);

                         
                        int index91_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred124_InternalQVTimperative()) ) {s = 39;}

                        else if ( (synpred125_InternalQVTimperative()) ) {s = 17;}

                         
                        input.seek(index91_12);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA91_13 = input.LA(1);

                         
                        int index91_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred124_InternalQVTimperative()) ) {s = 39;}

                        else if ( (synpred125_InternalQVTimperative()) ) {s = 17;}

                         
                        input.seek(index91_13);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA91_14 = input.LA(1);

                         
                        int index91_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred124_InternalQVTimperative()) ) {s = 39;}

                        else if ( (synpred125_InternalQVTimperative()) ) {s = 17;}

                         
                        input.seek(index91_14);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA91_15 = input.LA(1);

                         
                        int index91_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred124_InternalQVTimperative()) ) {s = 39;}

                        else if ( (synpred125_InternalQVTimperative()) ) {s = 17;}

                         
                        input.seek(index91_15);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA91_16 = input.LA(1);

                         
                        int index91_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred124_InternalQVTimperative()) ) {s = 39;}

                        else if ( (synpred125_InternalQVTimperative()) ) {s = 17;}

                         
                        input.seek(index91_16);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 91, _s, input);
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
        public static final BitSet FOLLOW_16_in_ruleMappingCS340 = new BitSet(new long[]{0x000003F898010030L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleMappingCS361 = new BitSet(new long[]{0x0000000000060000L});
        public static final BitSet FOLLOW_17_in_ruleMappingCS374 = new BitSet(new long[]{0x000003F898010030L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleMappingCS401 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleMappingCS415 = new BitSet(new long[]{0x000003F898190030L});
        public static final BitSet FOLLOW_ruleNamedDomainCS_in_ruleMappingCS436 = new BitSet(new long[]{0x000003F898190030L});
        public static final BitSet FOLLOW_19_in_ruleMappingCS450 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_ruleUnnamedDomainCS_in_ruleMappingCS471 = new BitSet(new long[]{0x0000000000110000L});
        public static final BitSet FOLLOW_ruleMappingCallCS_in_ruleMappingCS494 = new BitSet(new long[]{0x0000000000110000L});
        public static final BitSet FOLLOW_20_in_ruleMappingCS507 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMappingCallCS_in_entryRuleMappingCallCS543 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMappingCallCS553 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleMappingCallCS602 = new BitSet(new long[]{0x000003F898010030L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleMappingCallCS629 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleMappingCallCS641 = new BitSet(new long[]{0x000003F898110030L});
        public static final BitSet FOLLOW_ruleMappingCallBindingCS_in_ruleMappingCallCS662 = new BitSet(new long[]{0x000003F898110030L});
        public static final BitSet FOLLOW_20_in_ruleMappingCallCS675 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMappingCallBindingCS_in_entryRuleMappingCallBindingCS711 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMappingCallBindingCS721 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleMappingCallBindingCS773 = new BitSet(new long[]{0x0000000000600000L});
        public static final BitSet FOLLOW_21_in_ruleMappingCallBindingCS786 = new BitSet(new long[]{0xFE000FFCB80100F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_22_in_ruleMappingCallBindingCS810 = new BitSet(new long[]{0xFE000FFCB80100F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleMappingCallBindingCS845 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleMappingCallBindingCS857 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBottomPatternCS_in_entryRuleBottomPatternCS893 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBottomPatternCS903 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleBottomPatternCS941 = new BitSet(new long[]{0x000003F898010030L});
        public static final BitSet FOLLOW_ruleUnrealizedVariableCS_in_ruleBottomPatternCS963 = new BitSet(new long[]{0x0000000003000000L});
        public static final BitSet FOLLOW_ruleRealizedVariableCS_in_ruleBottomPatternCS990 = new BitSet(new long[]{0x0000000003000000L});
        public static final BitSet FOLLOW_24_in_ruleBottomPatternCS1004 = new BitSet(new long[]{0x000003F898010030L});
        public static final BitSet FOLLOW_ruleUnrealizedVariableCS_in_ruleBottomPatternCS1026 = new BitSet(new long[]{0x0000000003000000L});
        public static final BitSet FOLLOW_ruleRealizedVariableCS_in_ruleBottomPatternCS1053 = new BitSet(new long[]{0x0000000003000000L});
        public static final BitSet FOLLOW_25_in_ruleBottomPatternCS1068 = new BitSet(new long[]{0xFE000FFCBC1100F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleAssignmentCS_in_ruleBottomPatternCS1089 = new BitSet(new long[]{0xFE000FFCBC1100F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_20_in_ruleBottomPatternCS1102 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleBottomPatternCS1134 = new BitSet(new long[]{0xFE000FFCBC1100F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleAssignmentCS_in_ruleBottomPatternCS1155 = new BitSet(new long[]{0xFE000FFCBC1100F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_20_in_ruleBottomPatternCS1168 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignmentCS_in_entryRuleAssignmentCS1205 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAssignmentCS1215 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_ruleAssignmentCS1258 = new BitSet(new long[]{0xFE000FFCB80100F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleAssignmentCS1293 = new BitSet(new long[]{0x0000000000A00000L});
        public static final BitSet FOLLOW_21_in_ruleAssignmentCS1306 = new BitSet(new long[]{0xFE000FFCB80100F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleAssignmentCS1327 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleAssignmentCS1341 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDirectionCS_in_entryRuleDirectionCS1377 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDirectionCS1387 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleDirectionCS1445 = new BitSet(new long[]{0x0000000018000002L});
        public static final BitSet FOLLOW_27_in_ruleDirectionCS1459 = new BitSet(new long[]{0x000003F898010030L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleDirectionCS1486 = new BitSet(new long[]{0x0000000011000002L});
        public static final BitSet FOLLOW_24_in_ruleDirectionCS1499 = new BitSet(new long[]{0x000003F898010030L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleDirectionCS1526 = new BitSet(new long[]{0x0000000011000002L});
        public static final BitSet FOLLOW_28_in_ruleDirectionCS1543 = new BitSet(new long[]{0x000003F898010030L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleDirectionCS1570 = new BitSet(new long[]{0x0000000001000002L});
        public static final BitSet FOLLOW_24_in_ruleDirectionCS1583 = new BitSet(new long[]{0x000003F898010030L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleDirectionCS1610 = new BitSet(new long[]{0x0000000001000002L});
        public static final BitSet FOLLOW_ruleGuardPatternCS_in_entryRuleGuardPatternCS1650 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleGuardPatternCS1660 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_ruleGuardPatternCS1698 = new BitSet(new long[]{0x000003F898010030L});
        public static final BitSet FOLLOW_ruleUnrealizedVariableCS_in_ruleGuardPatternCS1719 = new BitSet(new long[]{0x0000000003000000L});
        public static final BitSet FOLLOW_24_in_ruleGuardPatternCS1732 = new BitSet(new long[]{0x000003F898010030L});
        public static final BitSet FOLLOW_ruleUnrealizedVariableCS_in_ruleGuardPatternCS1753 = new BitSet(new long[]{0x0000000003000000L});
        public static final BitSet FOLLOW_25_in_ruleGuardPatternCS1767 = new BitSet(new long[]{0xFE000FFCFC0100F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleAssignmentCS_in_ruleGuardPatternCS1788 = new BitSet(new long[]{0xFE000FFCFC0100F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_30_in_ruleGuardPatternCS1801 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_ruleGuardPatternCS1833 = new BitSet(new long[]{0xFE000FFCFC0100F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleAssignmentCS_in_ruleGuardPatternCS1854 = new BitSet(new long[]{0xFE000FFCFC0100F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_30_in_ruleGuardPatternCS1867 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleImportCS_in_entryRuleImportCS1904 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleImportCS1914 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_ruleImportCS1951 = new BitSet(new long[]{0x000003F8980100B0L});
        public static final BitSet FOLLOW_ruleIdentifier_in_ruleImportCS1973 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_32_in_ruleImportCS1985 = new BitSet(new long[]{0x000003F8980100B0L});
        public static final BitSet FOLLOW_ruleURIPathNameCS_in_ruleImportCS2008 = new BitSet(new long[]{0x0000000200800000L});
        public static final BitSet FOLLOW_33_in_ruleImportCS2027 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_34_in_ruleImportCS2052 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleImportCS2066 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibraryCS_in_entryRuleLibraryCS2102 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibraryCS2112 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_ruleLibraryCS2149 = new BitSet(new long[]{0x000003F8980100B0L});
        public static final BitSet FOLLOW_ruleURI_in_ruleLibraryCS2176 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleLibraryCS2188 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNamedDomainCS_in_entryRuleNamedDomainCS2224 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNamedDomainCS2234 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_ruleNamedDomainCS2277 = new BitSet(new long[]{0x000003F898010030L});
        public static final BitSet FOLLOW_37_in_ruleNamedDomainCS2309 = new BitSet(new long[]{0x000003F898010030L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleNamedDomainCS2350 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_ruleGuardPatternCS_in_ruleNamedDomainCS2371 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_ruleBottomPatternCS_in_ruleNamedDomainCS2392 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParamDeclarationCS_in_entryRuleParamDeclarationCS2428 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParamDeclarationCS2438 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleParamDeclarationCS2484 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_32_in_ruleParamDeclarationCS2496 = new BitSet(new long[]{0xFE000FFCB80100F0L,0x000000000042787FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleParamDeclarationCS2517 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQueryCS_in_entryRuleQueryCS2553 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleQueryCS2563 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_ruleQueryCS2600 = new BitSet(new long[]{0xFE000FFCB80100F0L,0x000000000042787FL});
        public static final BitSet FOLLOW_ruleScopeNameCS_in_ruleQueryCS2621 = new BitSet(new long[]{0x000003F898010030L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleQueryCS2642 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_29_in_ruleQueryCS2654 = new BitSet(new long[]{0x000003F8D8010030L});
        public static final BitSet FOLLOW_ruleParamDeclarationCS_in_ruleQueryCS2676 = new BitSet(new long[]{0x0000000041000000L});
        public static final BitSet FOLLOW_24_in_ruleQueryCS2689 = new BitSet(new long[]{0x000003F898010030L});
        public static final BitSet FOLLOW_ruleParamDeclarationCS_in_ruleQueryCS2710 = new BitSet(new long[]{0x0000000041000000L});
        public static final BitSet FOLLOW_30_in_ruleQueryCS2726 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_32_in_ruleQueryCS2738 = new BitSet(new long[]{0xFE000FFCB80100F0L,0x000000000042787FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleQueryCS2759 = new BitSet(new long[]{0x0000000000840000L});
        public static final BitSet FOLLOW_23_in_ruleQueryCS2772 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleQueryCS2791 = new BitSet(new long[]{0xFE000FFCB80100F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleQueryCS2812 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleQueryCS2824 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScopeNameCS_in_entryRuleScopeNameCS2862 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleScopeNameCS2872 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFirstPathElementCS_in_ruleScopeNameCS2918 = new BitSet(new long[]{0x0000000200000000L});
        public static final BitSet FOLLOW_33_in_ruleScopeNameCS2930 = new BitSet(new long[]{0xFE0003F898010032L,0x000000000000007FL});
        public static final BitSet FOLLOW_ruleNextPathElementCS_in_ruleScopeNameCS2952 = new BitSet(new long[]{0x0000000200000000L});
        public static final BitSet FOLLOW_33_in_ruleScopeNameCS2964 = new BitSet(new long[]{0xFE0003F898010032L,0x000000000000007FL});
        public static final BitSet FOLLOW_ruleTransformationCS_in_entryRuleTransformationCS3002 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTransformationCS3012 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_39_in_ruleTransformationCS3049 = new BitSet(new long[]{0xFE000FFCB80100F0L,0x000000000042787FL});
        public static final BitSet FOLLOW_ruleScopeNameCS_in_ruleTransformationCS3070 = new BitSet(new long[]{0xFE0003F898010030L,0x000000000000007FL});
        public static final BitSet FOLLOW_ruleUnreservedName_in_ruleTransformationCS3092 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleTransformationCS3104 = new BitSet(new long[]{0x000003F898910030L});
        public static final BitSet FOLLOW_ruleDirectionCS_in_ruleTransformationCS3126 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleTransformationCS3138 = new BitSet(new long[]{0x000003F898910030L});
        public static final BitSet FOLLOW_20_in_ruleTransformationCS3152 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrealizedVariableCS_in_entryRuleUnrealizedVariableCS3188 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnrealizedVariableCS3198 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleUnrealizedVariableCS3244 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_32_in_ruleUnrealizedVariableCS3256 = new BitSet(new long[]{0xFE000FFCB80100F0L,0x000000000042787FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleUnrealizedVariableCS3277 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRealizedVariableCS_in_entryRuleRealizedVariableCS3313 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRealizedVariableCS3323 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_40_in_ruleRealizedVariableCS3360 = new BitSet(new long[]{0x000003F898010030L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleRealizedVariableCS3381 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_32_in_ruleRealizedVariableCS3393 = new BitSet(new long[]{0xFE000FFCB80100F0L,0x000000000042787FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleRealizedVariableCS3414 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnnamedDomainCS_in_entryRuleUnnamedDomainCS3450 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnnamedDomainCS3460 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGuardPatternCS_in_ruleUnnamedDomainCS3518 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_ruleBottomPatternCS_in_ruleUnnamedDomainCS3539 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_entryRuleUnrestrictedName3576 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnrestrictedName3587 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLUnrestrictedName_in_ruleUnrestrictedName3634 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_ruleUnrestrictedName3658 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_ruleUnrestrictedName3677 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_ruleUnrestrictedName3696 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_ruleUnrestrictedName3715 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_ruleUnrestrictedName3734 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleUnrestrictedName3753 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_ruleUnrestrictedName3772 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_40_in_ruleUnrestrictedName3791 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_41_in_ruleUnrestrictedName3810 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_39_in_ruleUnrestrictedName3829 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_ruleUnrestrictedName3848 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleID_in_entryRuleID3891 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleID3902 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_SIMPLE_ID_in_ruleID3942 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ESCAPED_ID_in_ruleID3968 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLOWER_in_entryRuleLOWER4014 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLOWER4025 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleLOWER4064 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUPPER_in_entryRuleUPPER4109 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUPPER4120 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleUPPER4160 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_ruleUPPER4184 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNUMBER_LITERAL_in_entryRuleNUMBER_LITERAL4225 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNUMBER_LITERAL4236 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleNUMBER_LITERAL4275 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleURI_in_entryRuleURI4320 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleURI4331 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_SINGLE_QUOTED_STRING_in_ruleURI4370 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLUnaryOperatorCS_in_entryRuleEssentialOCLUnaryOperatorCS4416 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEssentialOCLUnaryOperatorCS4426 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_42_in_ruleEssentialOCLUnaryOperatorCS4470 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_43_in_ruleEssentialOCLUnaryOperatorCS4499 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLInfixOperatorCS_in_entryRuleEssentialOCLInfixOperatorCS4550 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEssentialOCLInfixOperatorCS4560 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_ruleEssentialOCLInfixOperatorCS4604 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_44_in_ruleEssentialOCLInfixOperatorCS4633 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_45_in_ruleEssentialOCLInfixOperatorCS4662 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_42_in_ruleEssentialOCLInfixOperatorCS4691 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_46_in_ruleEssentialOCLInfixOperatorCS4720 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_47_in_ruleEssentialOCLInfixOperatorCS4749 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_48_in_ruleEssentialOCLInfixOperatorCS4778 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleEssentialOCLInfixOperatorCS4807 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_49_in_ruleEssentialOCLInfixOperatorCS4836 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_50_in_ruleEssentialOCLInfixOperatorCS4865 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_51_in_ruleEssentialOCLInfixOperatorCS4894 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_52_in_ruleEssentialOCLInfixOperatorCS4923 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_53_in_ruleEssentialOCLInfixOperatorCS4952 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_54_in_ruleEssentialOCLInfixOperatorCS4981 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLNavigationOperatorCS_in_entryRuleEssentialOCLNavigationOperatorCS5032 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEssentialOCLNavigationOperatorCS5042 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_55_in_ruleEssentialOCLNavigationOperatorCS5086 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_56_in_ruleEssentialOCLNavigationOperatorCS5115 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_entryRuleIdentifier5167 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIdentifier5178 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleID_in_ruleIdentifier5224 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral5269 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteral5280 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_SINGLE_QUOTED_STRING_in_ruleStringLiteral5319 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBinaryOperatorCS_in_entryRuleBinaryOperatorCS5363 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBinaryOperatorCS5373 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInfixOperatorCS_in_ruleBinaryOperatorCS5423 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigationOperatorCS_in_ruleBinaryOperatorCS5453 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInfixOperatorCS_in_entryRuleInfixOperatorCS5488 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleInfixOperatorCS5498 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLInfixOperatorCS_in_ruleInfixOperatorCS5547 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigationOperatorCS_in_entryRuleNavigationOperatorCS5581 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigationOperatorCS5591 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLNavigationOperatorCS_in_ruleNavigationOperatorCS5640 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnaryOperatorCS_in_entryRuleUnaryOperatorCS5674 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnaryOperatorCS5684 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLUnaryOperatorCS_in_ruleUnaryOperatorCS5733 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLUnrestrictedName_in_entryRuleEssentialOCLUnrestrictedName5768 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEssentialOCLUnrestrictedName5779 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_ruleEssentialOCLUnrestrictedName5825 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLUnreservedName_in_entryRuleEssentialOCLUnreservedName5870 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEssentialOCLUnreservedName5881 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleEssentialOCLUnreservedName5928 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionTypeIdentifier_in_ruleEssentialOCLUnreservedName5961 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveTypeIdentifier_in_ruleEssentialOCLUnreservedName5994 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_57_in_ruleEssentialOCLUnreservedName6018 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnreservedName_in_entryRuleUnreservedName6059 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnreservedName6070 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLUnreservedName_in_ruleUnreservedName6116 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePathNameCS_in_entryRulePathNameCS6160 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePathNameCS6170 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFirstPathElementCS_in_rulePathNameCS6216 = new BitSet(new long[]{0x0000000200000002L});
        public static final BitSet FOLLOW_33_in_rulePathNameCS6229 = new BitSet(new long[]{0xFE0003F898010030L,0x000000000000007FL});
        public static final BitSet FOLLOW_ruleNextPathElementCS_in_rulePathNameCS6250 = new BitSet(new long[]{0x0000000200000002L});
        public static final BitSet FOLLOW_ruleFirstPathElementCS_in_entryRuleFirstPathElementCS6288 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFirstPathElementCS6298 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleFirstPathElementCS6349 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNextPathElementCS_in_entryRuleNextPathElementCS6384 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNextPathElementCS6394 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnreservedName_in_ruleNextPathElementCS6445 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleURIPathNameCS_in_entryRuleURIPathNameCS6480 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleURIPathNameCS6490 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleURIFirstPathElementCS_in_ruleURIPathNameCS6536 = new BitSet(new long[]{0x0000000200000002L});
        public static final BitSet FOLLOW_33_in_ruleURIPathNameCS6549 = new BitSet(new long[]{0xFE0003F898010030L,0x000000000000007FL});
        public static final BitSet FOLLOW_ruleNextPathElementCS_in_ruleURIPathNameCS6570 = new BitSet(new long[]{0x0000000200000002L});
        public static final BitSet FOLLOW_ruleURIFirstPathElementCS_in_entryRuleURIFirstPathElementCS6608 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleURIFirstPathElementCS6618 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleURIFirstPathElementCS6670 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleURI_in_ruleURIFirstPathElementCS6716 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveTypeIdentifier_in_entryRulePrimitiveTypeIdentifier6754 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrimitiveTypeIdentifier6765 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_58_in_rulePrimitiveTypeIdentifier6803 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_59_in_rulePrimitiveTypeIdentifier6822 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_60_in_rulePrimitiveTypeIdentifier6841 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_61_in_rulePrimitiveTypeIdentifier6860 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_62_in_rulePrimitiveTypeIdentifier6879 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_63_in_rulePrimitiveTypeIdentifier6898 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_64_in_rulePrimitiveTypeIdentifier6917 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_65_in_rulePrimitiveTypeIdentifier6936 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveTypeCS_in_entryRulePrimitiveTypeCS6976 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrimitiveTypeCS6986 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveTypeIdentifier_in_rulePrimitiveTypeCS7031 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionTypeIdentifier_in_entryRuleCollectionTypeIdentifier7067 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCollectionTypeIdentifier7078 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_66_in_ruleCollectionTypeIdentifier7116 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_67_in_ruleCollectionTypeIdentifier7135 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_68_in_ruleCollectionTypeIdentifier7154 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_69_in_ruleCollectionTypeIdentifier7173 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_70_in_ruleCollectionTypeIdentifier7192 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionTypeCS_in_entryRuleCollectionTypeCS7232 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCollectionTypeCS7242 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionTypeIdentifier_in_ruleCollectionTypeCS7288 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_29_in_ruleCollectionTypeCS7301 = new BitSet(new long[]{0xFE000FFCB80100F0L,0x000000000042787FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleCollectionTypeCS7322 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_30_in_ruleCollectionTypeCS7334 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiplicityBoundsCS_in_entryRuleMultiplicityBoundsCS7372 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicityBoundsCS7382 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLOWER_in_ruleMultiplicityBoundsCS7428 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
        public static final BitSet FOLLOW_71_in_ruleMultiplicityBoundsCS7441 = new BitSet(new long[]{0x0000000400000040L});
        public static final BitSet FOLLOW_ruleUPPER_in_ruleMultiplicityBoundsCS7462 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiplicityCS_in_entryRuleMultiplicityCS7500 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicityCS7510 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_72_in_ruleMultiplicityCS7547 = new BitSet(new long[]{0x0000200400000040L,0x0000000000000400L});
        public static final BitSet FOLLOW_ruleMultiplicityBoundsCS_in_ruleMultiplicityCS7573 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
        public static final BitSet FOLLOW_ruleMultiplicityStringCS_in_ruleMultiplicityCS7603 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
        public static final BitSet FOLLOW_73_in_ruleMultiplicityCS7615 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiplicityStringCS_in_entryRuleMultiplicityStringCS7651 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicityStringCS7661 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_ruleMultiplicityStringCS7705 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_45_in_ruleMultiplicityStringCS7734 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_74_in_ruleMultiplicityStringCS7763 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTupleTypeCS_in_entryRuleTupleTypeCS7814 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTupleTypeCS7824 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_57_in_ruleTupleTypeCS7867 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_29_in_ruleTupleTypeCS7893 = new BitSet(new long[]{0x000003F8D8010030L});
        public static final BitSet FOLLOW_ruleTuplePartCS_in_ruleTupleTypeCS7915 = new BitSet(new long[]{0x0000000041000000L});
        public static final BitSet FOLLOW_24_in_ruleTupleTypeCS7928 = new BitSet(new long[]{0x000003F898010030L});
        public static final BitSet FOLLOW_ruleTuplePartCS_in_ruleTupleTypeCS7949 = new BitSet(new long[]{0x0000000041000000L});
        public static final BitSet FOLLOW_30_in_ruleTupleTypeCS7965 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTuplePartCS_in_entryRuleTuplePartCS8003 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTuplePartCS8013 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleTuplePartCS8059 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_32_in_ruleTuplePartCS8071 = new BitSet(new long[]{0xFE000FFCB80100F0L,0x000000000042787FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleTuplePartCS8092 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionLiteralExpCS_in_entryRuleCollectionLiteralExpCS8128 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCollectionLiteralExpCS8138 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionTypeCS_in_ruleCollectionLiteralExpCS8184 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleCollectionLiteralExpCS8196 = new BitSet(new long[]{0xFE000FFCB81100F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleCollectionLiteralPartCS_in_ruleCollectionLiteralExpCS8218 = new BitSet(new long[]{0x0000000001100000L});
        public static final BitSet FOLLOW_24_in_ruleCollectionLiteralExpCS8231 = new BitSet(new long[]{0xFE000FFCB80100F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleCollectionLiteralPartCS_in_ruleCollectionLiteralExpCS8252 = new BitSet(new long[]{0x0000000001100000L});
        public static final BitSet FOLLOW_20_in_ruleCollectionLiteralExpCS8268 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionLiteralPartCS_in_entryRuleCollectionLiteralPartCS8304 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCollectionLiteralPartCS8314 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleCollectionLiteralPartCS8360 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
        public static final BitSet FOLLOW_71_in_ruleCollectionLiteralPartCS8373 = new BitSet(new long[]{0xFE000FFCB80100F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleCollectionLiteralPartCS8394 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConstructorPartCS_in_entryRuleConstructorPartCS8432 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleConstructorPartCS8442 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleConstructorPartCS8494 = new BitSet(new long[]{0x0002000000000000L});
        public static final BitSet FOLLOW_49_in_ruleConstructorPartCS8506 = new BitSet(new long[]{0xFE000FFCB80100F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleConstructorPartCS8527 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveLiteralExpCS_in_entryRulePrimitiveLiteralExpCS8563 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrimitiveLiteralExpCS8573 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNumberLiteralExpCS_in_rulePrimitiveLiteralExpCS8623 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringLiteralExpCS_in_rulePrimitiveLiteralExpCS8653 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBooleanLiteralExpCS_in_rulePrimitiveLiteralExpCS8683 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnlimitedNaturalLiteralExpCS_in_rulePrimitiveLiteralExpCS8713 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInvalidLiteralExpCS_in_rulePrimitiveLiteralExpCS8743 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNullLiteralExpCS_in_rulePrimitiveLiteralExpCS8773 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTupleLiteralExpCS_in_entryRuleTupleLiteralExpCS8808 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTupleLiteralExpCS8818 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_57_in_ruleTupleLiteralExpCS8855 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleTupleLiteralExpCS8867 = new BitSet(new long[]{0x000003F898010030L});
        public static final BitSet FOLLOW_ruleTupleLiteralPartCS_in_ruleTupleLiteralExpCS8888 = new BitSet(new long[]{0x0000000001100000L});
        public static final BitSet FOLLOW_24_in_ruleTupleLiteralExpCS8901 = new BitSet(new long[]{0x000003F898010030L});
        public static final BitSet FOLLOW_ruleTupleLiteralPartCS_in_ruleTupleLiteralExpCS8922 = new BitSet(new long[]{0x0000000001100000L});
        public static final BitSet FOLLOW_20_in_ruleTupleLiteralExpCS8936 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTupleLiteralPartCS_in_entryRuleTupleLiteralPartCS8972 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTupleLiteralPartCS8982 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleTupleLiteralPartCS9028 = new BitSet(new long[]{0x0002000100000000L});
        public static final BitSet FOLLOW_32_in_ruleTupleLiteralPartCS9041 = new BitSet(new long[]{0xFE000FFCB80100F0L,0x000000000042787FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleTupleLiteralPartCS9062 = new BitSet(new long[]{0x0002000000000000L});
        public static final BitSet FOLLOW_49_in_ruleTupleLiteralPartCS9076 = new BitSet(new long[]{0xFE000FFCB80100F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleTupleLiteralPartCS9097 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNumberLiteralExpCS_in_entryRuleNumberLiteralExpCS9133 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNumberLiteralExpCS9143 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNUMBER_LITERAL_in_ruleNumberLiteralExpCS9188 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringLiteralExpCS_in_entryRuleStringLiteralExpCS9223 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteralExpCS9233 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringLiteral_in_ruleStringLiteralExpCS9278 = new BitSet(new long[]{0x0000000000000082L});
        public static final BitSet FOLLOW_ruleBooleanLiteralExpCS_in_entryRuleBooleanLiteralExpCS9314 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBooleanLiteralExpCS9324 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_75_in_ruleBooleanLiteralExpCS9367 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_76_in_ruleBooleanLiteralExpCS9404 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnlimitedNaturalLiteralExpCS_in_entryRuleUnlimitedNaturalLiteralExpCS9453 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnlimitedNaturalLiteralExpCS9463 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_ruleUnlimitedNaturalLiteralExpCS9512 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInvalidLiteralExpCS_in_entryRuleInvalidLiteralExpCS9548 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleInvalidLiteralExpCS9558 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_77_in_ruleInvalidLiteralExpCS9607 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNullLiteralExpCS_in_entryRuleNullLiteralExpCS9643 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNullLiteralExpCS9653 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_78_in_ruleNullLiteralExpCS9702 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralCS_in_entryRuleTypeLiteralCS9738 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeLiteralCS9748 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveTypeCS_in_ruleTypeLiteralCS9798 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionTypeCS_in_ruleTypeLiteralCS9828 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTupleTypeCS_in_ruleTypeLiteralCS9858 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralWithMultiplicityCS_in_entryRuleTypeLiteralWithMultiplicityCS9893 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeLiteralWithMultiplicityCS9903 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralCS_in_ruleTypeLiteralWithMultiplicityCS9953 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000100L});
        public static final BitSet FOLLOW_ruleMultiplicityCS_in_ruleTypeLiteralWithMultiplicityCS9973 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralExpCS_in_entryRuleTypeLiteralExpCS10010 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeLiteralExpCS10020 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralWithMultiplicityCS_in_ruleTypeLiteralExpCS10065 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeNameExpCS_in_entryRuleTypeNameExpCS10100 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeNameExpCS10110 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePathNameCS_in_ruleTypeNameExpCS10155 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_entryRuleTypeExpCS10190 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeExpCS10200 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeNameExpCS_in_ruleTypeExpCS10251 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000100L});
        public static final BitSet FOLLOW_ruleTypeLiteralCS_in_ruleTypeExpCS10281 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000100L});
        public static final BitSet FOLLOW_ruleMultiplicityCS_in_ruleTypeExpCS10302 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpCS_in_entryRuleExpCS10339 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleExpCS10349 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrefixedExpCS_in_ruleExpCS10400 = new BitSet(new long[]{0x01FFF40400400002L});
        public static final BitSet FOLLOW_ruleBinaryOperatorCS_in_ruleExpCS10433 = new BitSet(new long[]{0xFE000FFCB80100F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_rulePrefixedExpCS_in_ruleExpCS10456 = new BitSet(new long[]{0x01FFF40400400002L});
        public static final BitSet FOLLOW_ruleBinaryOperatorCS_in_ruleExpCS10478 = new BitSet(new long[]{0xFE000FFCB80100F0L,0x000000000042787FL});
        public static final BitSet FOLLOW_rulePrefixedExpCS_in_ruleExpCS10499 = new BitSet(new long[]{0x01FFF40400400002L});
        public static final BitSet FOLLOW_ruleBinaryOperatorCS_in_ruleExpCS10523 = new BitSet(new long[]{0xFE000FFCB80100F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleLetExpCS_in_ruleExpCS10544 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLetExpCS_in_ruleExpCS10574 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnaryOperatorCS_in_ruleExpCS10618 = new BitSet(new long[]{0xFE000FFCB80100F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleLetExpCS_in_ruleExpCS10640 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLetExpCS_in_ruleExpCS10672 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrefixedExpCS_in_entryRulePrefixedExpCS10707 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrefixedExpCS10717 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnaryOperatorCS_in_rulePrefixedExpCS10776 = new BitSet(new long[]{0xFE000FFCB80100F0L,0x000000000042787FL});
        public static final BitSet FOLLOW_rulePrimaryExpCS_in_rulePrefixedExpCS10798 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimaryExpCS_in_rulePrefixedExpCS10830 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimaryExpCS_in_entryRulePrimaryExpCS10865 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpCS10875 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedExpCS_in_rulePrimaryExpCS10925 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIfExpCS_in_rulePrimaryExpCS10955 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSelfExpCS_in_rulePrimaryExpCS10985 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveLiteralExpCS_in_rulePrimaryExpCS11015 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTupleLiteralExpCS_in_rulePrimaryExpCS11045 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionLiteralExpCS_in_rulePrimaryExpCS11075 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralExpCS_in_rulePrimaryExpCS11105 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePathNameCS_in_rulePrimaryExpCS11144 = new BitSet(new long[]{0x0000000020040002L,0x0000000000008100L});
        public static final BitSet FOLLOW_72_in_rulePrimaryExpCS11170 = new BitSet(new long[]{0xFE000FFCB80100F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleExpCS_in_rulePrimaryExpCS11191 = new BitSet(new long[]{0x0000000001000000L,0x0000000000000200L});
        public static final BitSet FOLLOW_24_in_rulePrimaryExpCS11204 = new BitSet(new long[]{0xFE000FFCB80100F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleExpCS_in_rulePrimaryExpCS11225 = new BitSet(new long[]{0x0000000001000000L,0x0000000000000200L});
        public static final BitSet FOLLOW_73_in_rulePrimaryExpCS11239 = new BitSet(new long[]{0x0000000000000002L,0x0000000000008100L});
        public static final BitSet FOLLOW_72_in_rulePrimaryExpCS11252 = new BitSet(new long[]{0xFE000FFCB80100F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleExpCS_in_rulePrimaryExpCS11273 = new BitSet(new long[]{0x0000000001000000L,0x0000000000000200L});
        public static final BitSet FOLLOW_24_in_rulePrimaryExpCS11286 = new BitSet(new long[]{0xFE000FFCB80100F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleExpCS_in_rulePrimaryExpCS11307 = new BitSet(new long[]{0x0000000001000000L,0x0000000000000200L});
        public static final BitSet FOLLOW_73_in_rulePrimaryExpCS11321 = new BitSet(new long[]{0x0000000000000002L,0x0000000000008000L});
        public static final BitSet FOLLOW_79_in_rulePrimaryExpCS11342 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
        public static final BitSet FOLLOW_80_in_rulePrimaryExpCS11367 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rulePrimaryExpCS11401 = new BitSet(new long[]{0x000003F8980100B0L});
        public static final BitSet FOLLOW_ruleConstructorPartCS_in_rulePrimaryExpCS11424 = new BitSet(new long[]{0x0000000001100000L});
        public static final BitSet FOLLOW_24_in_rulePrimaryExpCS11437 = new BitSet(new long[]{0x000003F898010030L});
        public static final BitSet FOLLOW_ruleConstructorPartCS_in_rulePrimaryExpCS11458 = new BitSet(new long[]{0x0000000001100000L});
        public static final BitSet FOLLOW_ruleStringLiteral_in_rulePrimaryExpCS11488 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_rulePrimaryExpCS11501 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_79_in_rulePrimaryExpCS11528 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
        public static final BitSet FOLLOW_80_in_rulePrimaryExpCS11553 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_29_in_rulePrimaryExpCS11580 = new BitSet(new long[]{0xFE000FFCF80100F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleNavigatingArgCS_in_rulePrimaryExpCS11602 = new BitSet(new long[]{0x0000000043800000L});
        public static final BitSet FOLLOW_ruleNavigatingCommaArgCS_in_rulePrimaryExpCS11623 = new BitSet(new long[]{0x0000000043800000L});
        public static final BitSet FOLLOW_ruleNavigatingSemiArgCS_in_rulePrimaryExpCS11646 = new BitSet(new long[]{0x0000000043000000L});
        public static final BitSet FOLLOW_ruleNavigatingCommaArgCS_in_rulePrimaryExpCS11667 = new BitSet(new long[]{0x0000000043000000L});
        public static final BitSet FOLLOW_ruleNavigatingBarArgCS_in_rulePrimaryExpCS11692 = new BitSet(new long[]{0x0000000041000000L});
        public static final BitSet FOLLOW_ruleNavigatingCommaArgCS_in_rulePrimaryExpCS11713 = new BitSet(new long[]{0x0000000041000000L});
        public static final BitSet FOLLOW_30_in_rulePrimaryExpCS11730 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingArgCS_in_entryRuleNavigatingArgCS11771 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigatingArgCS11781 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingArgCS11827 = new BitSet(new long[]{0x0000000100000002L});
        public static final BitSet FOLLOW_32_in_ruleNavigatingArgCS11840 = new BitSet(new long[]{0xFE000FFCB80100F0L,0x000000000042787FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleNavigatingArgCS11861 = new BitSet(new long[]{0x0002000000000002L});
        public static final BitSet FOLLOW_49_in_ruleNavigatingArgCS11874 = new BitSet(new long[]{0xFE000FFCB80100F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNavigatingArgCS11895 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingBarArgCS_in_entryRuleNavigatingBarArgCS11935 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigatingBarArgCS11945 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_ruleNavigatingBarArgCS11988 = new BitSet(new long[]{0xFE000FFCB80100F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingBarArgCS12022 = new BitSet(new long[]{0x0000000100000002L});
        public static final BitSet FOLLOW_32_in_ruleNavigatingBarArgCS12035 = new BitSet(new long[]{0xFE000FFCB80100F0L,0x000000000042787FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleNavigatingBarArgCS12056 = new BitSet(new long[]{0x0002000000000002L});
        public static final BitSet FOLLOW_49_in_ruleNavigatingBarArgCS12069 = new BitSet(new long[]{0xFE000FFCB80100F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNavigatingBarArgCS12090 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingCommaArgCS_in_entryRuleNavigatingCommaArgCS12130 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigatingCommaArgCS12140 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_ruleNavigatingCommaArgCS12183 = new BitSet(new long[]{0xFE000FFCB80100F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingCommaArgCS12217 = new BitSet(new long[]{0x0000000100000002L});
        public static final BitSet FOLLOW_32_in_ruleNavigatingCommaArgCS12230 = new BitSet(new long[]{0xFE000FFCB80100F0L,0x000000000042787FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleNavigatingCommaArgCS12251 = new BitSet(new long[]{0x0002000000000002L});
        public static final BitSet FOLLOW_49_in_ruleNavigatingCommaArgCS12264 = new BitSet(new long[]{0xFE000FFCB80100F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNavigatingCommaArgCS12285 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingSemiArgCS_in_entryRuleNavigatingSemiArgCS12325 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigatingSemiArgCS12335 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_ruleNavigatingSemiArgCS12378 = new BitSet(new long[]{0xFE000FFCB80100F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingSemiArgCS12412 = new BitSet(new long[]{0x0000000100000002L});
        public static final BitSet FOLLOW_32_in_ruleNavigatingSemiArgCS12425 = new BitSet(new long[]{0xFE000FFCB80100F0L,0x000000000042787FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleNavigatingSemiArgCS12446 = new BitSet(new long[]{0x0002000000000002L});
        public static final BitSet FOLLOW_49_in_ruleNavigatingSemiArgCS12459 = new BitSet(new long[]{0xFE000FFCB80100F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNavigatingSemiArgCS12480 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingArgExpCS_in_entryRuleNavigatingArgExpCS12520 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigatingArgExpCS12530 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNavigatingArgExpCS12579 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIfExpCS_in_entryRuleIfExpCS12613 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIfExpCS12623 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_81_in_ruleIfExpCS12660 = new BitSet(new long[]{0xFE000FFCB80100F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleIfExpCS12681 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
        public static final BitSet FOLLOW_82_in_ruleIfExpCS12693 = new BitSet(new long[]{0xFE000FFCB80100F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleIfExpCS12714 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
        public static final BitSet FOLLOW_83_in_ruleIfExpCS12726 = new BitSet(new long[]{0xFE000FFCB80100F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleIfExpCS12747 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
        public static final BitSet FOLLOW_84_in_ruleIfExpCS12759 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLetExpCS_in_entryRuleLetExpCS12795 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLetExpCS12805 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_85_in_ruleLetExpCS12842 = new BitSet(new long[]{0x000003F898010030L});
        public static final BitSet FOLLOW_ruleLetVariableCS_in_ruleLetExpCS12863 = new BitSet(new long[]{0x0000000001020000L});
        public static final BitSet FOLLOW_24_in_ruleLetExpCS12876 = new BitSet(new long[]{0x000003F898010030L});
        public static final BitSet FOLLOW_ruleLetVariableCS_in_ruleLetExpCS12897 = new BitSet(new long[]{0x0000000001020000L});
        public static final BitSet FOLLOW_17_in_ruleLetExpCS12911 = new BitSet(new long[]{0xFE000FFCB80100F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleLetExpCS12932 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLetVariableCS_in_entryRuleLetVariableCS12968 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLetVariableCS12978 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleLetVariableCS13024 = new BitSet(new long[]{0x0002000100000000L});
        public static final BitSet FOLLOW_32_in_ruleLetVariableCS13037 = new BitSet(new long[]{0xFE000FFCB80100F0L,0x000000000042787FL});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleLetVariableCS13058 = new BitSet(new long[]{0x0002000000000000L});
        public static final BitSet FOLLOW_49_in_ruleLetVariableCS13072 = new BitSet(new long[]{0xFE000FFCB80100F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleLetVariableCS13093 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedExpCS_in_entryRuleNestedExpCS13129 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNestedExpCS13139 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_ruleNestedExpCS13176 = new BitSet(new long[]{0xFE000FFCB80100F0L,0x000000000062787FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNestedExpCS13197 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_30_in_ruleNestedExpCS13209 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSelfExpCS_in_entryRuleSelfExpCS13245 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSelfExpCS13255 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_86_in_ruleSelfExpCS13304 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTupleLiteralExpCS_in_synpred123_InternalQVTimperative11045 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionLiteralExpCS_in_synpred124_InternalQVTimperative11075 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralExpCS_in_synpred125_InternalQVTimperative11105 = new BitSet(new long[]{0x0000000000000002L});
    }


}